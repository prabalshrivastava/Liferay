	package com.sambaash.platform.portlet.pe.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.FileExtensionException;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.exception.FileFormatException;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEEntity;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.ProcessEngine;
import com.sambaash.platform.pe.ProcessEngineImpl;
import com.sambaash.platform.pe.cache.PEProcessCache;
import com.sambaash.platform.pe.cache.PEProcessDirectory;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.course.enroll.CourseEnrollConstants;
import com.sambaash.platform.pe.course.enroll.CourseEnrollFeeHelper;
import com.sambaash.platform.pe.course.enroll.InFixExpressionEvaluator;
import com.sambaash.platform.pe.helpers.PEEntityHelper;
import com.sambaash.platform.pe.helpers.PEHelper;
import com.sambaash.platform.pe.helpers.PEProcessHelper;
import com.sambaash.platform.pe.jaxb.PEForm;
import com.sambaash.platform.pe.permissions.PermissionsUtil;
import com.sambaash.platform.srv.model.FeeDetails;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.model.Funding;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeDetailsLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class ProcessStateActionHelper implements PEConstants {

	public static JSONObject approve(PortletRequest request, PortletResponse response) {

		ProcessEngine processEngine = new ProcessEngineImpl();
		JSONObject data = JSONFactoryUtil.createJSONObject();
		try {
			long processStateId = ParamUtil.getLong(request, PARAM_PROCESS_STATE_ID);
			PEOutput output = processEngine.approve(processStateId, request, response);

			if (output.errorExists()) {
				data.put(KEY_ERROR, output.getError().toString());
			}

			if (output.validationMsgsExists()) {
				JSONArray validations = JSONFactoryUtil.createJSONArray();

				for (String msg : output.getValidationMsgs()) {
					validations.put(msg);
				}

				data.put("validations", validations);
			}

			if (Validator.isNotNull(output.getMsg())) {
				data.put("msg", output.getMsg());
			}

			request.setAttribute(ATTR_OUTPUT, output);
		} catch (SystemException e) {
			_log.error(e);
			data.put(KEY_ERROR, "Error while processing your request");
		}

		return data;
	}

	public static JSONObject uploadBulkRegistration(PortletRequest request, PortletResponse response) {
		JSONObject data = JSONFactoryUtil.createJSONObject();

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
			File file = uploadPortletRequest.getFile("bulkRegistration");
			long processId = ParamUtil.getLong(uploadPortletRequest, "processId");
			if (_log.isDebugEnabled()) {
				_log.debug("---------------- fileName : " + file.getName());
			}
			if (file.getName().endsWith(EXCEL.EXTENSION)) {
				readFileXlsx(new FileInputStream(file));
			} else if (file.getName().endsWith(EXCEL.EXTENSION_OLD)) {
				readFileXls(new FileInputStream(file));
			} else {
				throw new FileFormatException(FileFormatException.FILE_TYPE_EXCEPTION);
			}

			PEProcess peProcess = PEProcessLocalServiceUtil.getPEProcess(processId);
			PEProcessDirectory directory = PEProcessCache.getInstance().getProcessDirectory(processId);
			PEForm form = directory.getFirstForm();

			FormBuilderLocalServiceUtil.submitFormDataMultipartBulkRegistration(peProcess.getSpPEProcessId(),
					peProcess.getEntityClassId(), form.getFormId(), themeDisplay.getUserId(), file);

			data.put("msg", "File processed successfully. Records are being processed in the background.");

		} catch (Exception e) {
			if (e instanceof FileExtensionException || e instanceof FileFormatException) {
				data.put("msg", "Invalid file");
			}
			_log.error(e);
			data.put("msg", "Upload failed");
		}

		return data;
	}

	private static HSSFWorkbook readFileXls(InputStream inputStream) throws IOException {
		return new HSSFWorkbook(inputStream);
	}

	private static XSSFWorkbook readFileXlsx(InputStream inputStream) throws IOException {
		return new XSSFWorkbook(inputStream);
	}

	public static JSONObject reject(PortletRequest request, PortletResponse response) {

		ProcessEngine processEngine = new ProcessEngineImpl();
		JSONObject data = JSONFactoryUtil.createJSONObject();
		try {
			long processStateId = ParamUtil.getLong(request, PARAM_PROCESS_STATE_ID);
			PEOutput output = processEngine.reject(processStateId, request, response);

			if (output.errorExists()) {
				data.put(KEY_ERROR, output.getError().toString());
			}

			if (output.validationMsgsExists()) {
				JSONArray validations = JSONFactoryUtil.createJSONArray();

				for (String msg : output.getValidationMsgs()) {
					validations.put(msg);
				}

				data.put("validations", validations);
			}

			if (Validator.isNotNull(output.getMsg())) {
				data.put("msg", output.getMsg());
			}

			request.setAttribute(ATTR_OUTPUT, output);
		} catch (SystemException e) {
			_log.error(e);
			data.put(KEY_ERROR, "Error while processing your request");
		}

		return data;
	}

	public static JSONObject assign(PortletRequest request, PortletResponse response) {
		JSONObject data = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if (!PermissionsUtil.hasAssignPermission(themeDisplay)) {
			data.put("error", "You are not authorized to assign");
			return data;
		}
		long processStateId = ParamUtil.getLong(request, PARAM_PROCESS_STATE_ID);
		long assigneeId = ParamUtil.getLong(request, "assigneeId");
		try {
			User newAssigne = UserLocalServiceUtil.getUser(assigneeId);
			PEProcessState processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			PEProcess process = PEProcessLocalServiceUtil.getPEProcess(processState.getSpPEProcessId());
			boolean update = false;
			if (PEProcessHelper.isSupervisor(themeDisplay.getUser(), process)) {
				if (PEProcessHelper.isAgent(newAssigne, process)) {
					processState.setUserIdAgent(assigneeId);
					data.put("agentName", newAssigne.getFullName());
					update = true;
				}
			} else if (PEProcessHelper.isGlobalStatusTypeApprover(themeDisplay.getUser(), process)
					|| SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				if (PEProcessHelper.isAgent(newAssigne, process)) {
					processState.setUserIdAgent(assigneeId);
					data.put("agentName", newAssigne.getFullName());
					update = true;
				}
				if (PEProcessHelper.isSupervisor(newAssigne, process)) {
					processState.setUserIdSupervisor(assigneeId);
					data.put("supervisorName", newAssigne.getFullName());
					update = true;
				}
			} else {
				data.put("Error", "Sorry, You are not authorized to assign the applicaiton");
			}
			if (update) {
				SambaashUtil.fillAudit(processState, themeDisplay, false);
				PEProcessStateLocalServiceUtil.updatePEProcessState(processState);
				data.put("msg", "Application assigned to " + newAssigne.getFullName());

				// reindexing social profile
				PEHelper.reindexSocialProfile(processState);
			}
		} catch (SystemException | PortalException e) {
			_log.error(e);
			data.put("error", "Error while assigning the application");
		}

		return data;
	}

	public static JSONObject changeStatus(PortletRequest request, PortletResponse response) {
		JSONObject data = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if (!PermissionsUtil.hasApplicationChangeStatusPermission(themeDisplay)) {
			data.put("error", "You are not authorized to change the status");
			return data;
		}
		long processStateId = ParamUtil.getLong(request, PARAM_PROCESS_STATE_ID);
		int status = ParamUtil.getInteger(request, "status");
		try {
			PEProcessState processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			if (status == PEConstantsGlobal.ACTIVE_STATUS_ACTIVE) {
				processState.setActiveStatus(PEConstantsGlobal.ACTIVE_STATUS_IN_ACTIVE);
				data.put("msg", "Application is InActive");
			} else {
				processState.setActiveStatus(PEConstantsGlobal.ACTIVE_STATUS_ACTIVE);
				data.put("msg", "Application is Active");
			}
			SambaashUtil.fillAudit(processState, themeDisplay, false);
			PEProcessStateLocalServiceUtil.updatePEProcessState(processState);

		} catch (SystemException | PortalException e) {
			_log.error(e);
			data.put("error", "Error while changing the status of the application");
		}

		return data;
	}

	public static JSONObject close(PortletRequest request, PortletResponse response) {
		JSONObject data = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		// checking permissions
		if (!PermissionsUtil.hasApplicationClosePermission(themeDisplay)) {
			data.put("error", "You are not authorized to close the application");
			return data;
		}
		long processStateId = ParamUtil.getLong(request, PARAM_PROCESS_STATE_ID);
		String closedType = ParamUtil.getString(request, "closedType");
		String closedDateStr = ParamUtil.getString(request, "closedDate");
		Date closedDate = PEHelper.getDate4rDDMMYYYY(closedDateStr);
		try {
			PEProcessState processState = PEProcessStateLocalServiceUtil.getPEProcessState(processStateId);
			Date now = new Date();
			if (closedDate.compareTo(now) > 0) {
				_log.error("date error ......................" + closedDate.compareTo(now));
				data.put("error", "The application close date cannot be a future date");
				return data;
			}
			_log.error("fetching fee details ......................" + processState.getAmount());

			if (!StringUtils.isNotBlank(processState.getAmount())) {
				try {
					Product product = ProductLocalServiceUtil.getProduct(processState.getEntityId());
					if (null != product) {
						User user = UserLocalServiceUtil.getUser(processState.getUserId());
						PERequestData requestData = PERequestData.getRequestData(request, user);
						PEDataSource dataSource = new PEDataSource(requestData, processState);
						Funding applicableFunding = CourseEnrollFeeHelper.getFundingApplicable(dataSource);

						_log.debug("product id " + product.getSpProductId());
						List<FeeDetails> feeList;
						if (applicableFunding != null) {
							_log.debug("fee details from funding id " + product.getSpProductId());
							feeList = FeeDetailsLocalServiceUtil.findByFundIdAndSpCourseId(
									applicableFunding.getSpFundingId(), product.getSpCourseId());
						} else {
							feeList = FeeDetailsLocalServiceUtil.findByFeeTypeAndCourseId(10l, product.getSpCourseId());
						}

						for (FeeDetails feeDetails : feeList) {
							FeeType feeType = FeeTypeLocalServiceUtil.getFeeType(feeDetails.getFeeType());
							if (CourseEnrollConstants.FEE_TYPE_COURSE_FEE.equalsIgnoreCase(feeType.getFeeType())) {
								BigDecimal calculatedAmount = InFixExpressionEvaluator
										.getBigDecimalWithRounding(String.valueOf(feeDetails.getAmount()));
								processState.setAmount(String.valueOf(calculatedAmount));
								break;
							}

						}
					}

				} catch (Exception e) {
					_log.error(e);
				}
			}

			// Marking as Closed WON
			if ("WON".equalsIgnoreCase(closedType)) {
				long wonStageId = GetterUtil
						.getLong(SambaashUtil.getParameter(PEConstantsGlobal.SP_PARAM_CLOSED_WON_STAGE_ID, 0));
				if (wonStageId > 0) {
					// check if it is already marked as closed won
					if (wonStageId == processState.getClosedStageId()) {
						data.put("error", "This applicaiton already marked as Closed Won");
					} else {
						processState.setClosedStageId(wonStageId);
						processState.setClosedReasonCatId(0);
						processState.setClosedDescription(StringPool.BLANK);
						processState.setClosedDate(closedDate);
						SambaashUtil.fillAudit(processState, themeDisplay, false);
						PEProcessStateLocalServiceUtil.updatePEProcessState(processState);
						data.put("msg", "Application marked as Closed Won");
						PEProcessStage stage = PEProcessStageLocalServiceUtil.getPEProcessStage(wonStageId);
						data.put("style", stage.getStyle());

						// reindexing social profile
						PEHelper.reindexSocialProfile(processState);
					}

				}
			} else if ("LOST".equalsIgnoreCase(closedType)) {
				// Marking as Closed Lost
				long lostStageId = GetterUtil
						.getLong(SambaashUtil.getParameter(PEConstantsGlobal.SP_PARAM_CLOSED_LOST_STAGE_ID, 0));
				if (lostStageId > 0) {
					// check if it already closed lost
					if (lostStageId == processState.getClosedStageId()) {
						data.put("error", "This applicaiton already marked as Closed Lost");
					} else {
						processState.setClosedStageId(lostStageId);
						long catgId = ParamUtil.getLong(request, "closedReasonId");
						AssetCategory catg = AssetCategoryLocalServiceUtil.getAssetCategory(catgId);
						processState.setClosedReasonCatId(catg.getCategoryId());
						processState.setClosedDescription(ParamUtil.getString(request, "closedDesc"));
						processState.setClosedDate(closedDate);
						SambaashUtil.fillAudit(processState, themeDisplay, false);
						PEProcessStateLocalServiceUtil.updatePEProcessState(processState);
						data.put("msg", "Application marked as Closed Lost");
						PEProcessStage stage = PEProcessStageLocalServiceUtil.getPEProcessStage(lostStageId);
						data.put("style", stage.getStyle());

						// reindexing social profile
						PEHelper.reindexSocialProfile(processState);
					}

				}
			} else {
				data.put("error", "Can not be closed. Unknown Close type");
			}

		} catch (SystemException | PortalException e) {
			_log.error(e);
			data.put("error", "Error while closing the application");
		}

		return data;
	}

	public static JSONObject getEntityIdClassIdProcessIdJson() {
		// Get the processId,classId,entityid list, - entties for which
		// applications were registered will be returned.
		List list = PEProcessStateLocalServiceUtil.getDistinctEntityIdClasseIdProcessIdList();
		JSONObject processToEntityJson = JSONFactoryUtil.createJSONObject();
		if (list != null) {
			// classNameId + # + entityId
			final String entityInfoFormat = "%s#%s";
			// Maintains entities corresponding to entity class
			Map<Long, List<Long>> entityClassToEntity = new HashMap<>();

			// Maintains the entties registered for process
			Map<String, List<String>> processToEntityInfo = new HashMap<>();

			for (Object obj : list) {
				long entityId = (long) ((Object[]) obj)[0];
				long entityClassId = (long) ((Object[]) obj)[1];
				long processId = (long) ((Object[]) obj)[2];

				// for entity ids to fetch in bulk
				List<Long> entityIds = entityClassToEntity.get(entityClassId);
				if (entityIds == null) {
					entityIds = new ArrayList<Long>();
					entityClassToEntity.put(entityClassId, entityIds);
				}
				entityIds.add(entityId);

				// maintaint the entities corresponding to process
				List<String> entitisInfo = processToEntityInfo.get(String.valueOf(processId));
				if (entitisInfo == null) {
					entitisInfo = new ArrayList<String>();
					processToEntityInfo.put(String.valueOf(processId), entitisInfo);
				}
				entitisInfo.add(String.format(entityInfoFormat, entityClassId, entityId));
			}

			// List of entities for each process
			List<PEEntity> allEntities = new ArrayList<PEEntity>();
			// Map for all entities, easy for retrival
			Map<String, PEEntity> entitiesMap = new HashMap<String, PEEntity>();
			for (Entry<Long, List<Long>> entry : entityClassToEntity.entrySet()) {
				List<PEEntity> entityList = PEEntityHelper.getEntities(entry.getKey(), entry.getValue());

				for (PEEntity peEntity : entityList) {
					// key is classNameId + # + entityId
					entitiesMap.put(String.format(entityInfoFormat, entry.getKey(), peEntity.getId()), peEntity);
					allEntities.add(peEntity);
				}
			}

			// Comparator sorting purpose
			Comparator<PEEntity> comparator = new Comparator<PEEntity>() {

				@Override
				public int compare(PEEntity o1, PEEntity o2) {
					if (o1 != null && o2 != null) {
						o1.getName().compareToIgnoreCase(o2.getName());
					}
					return 0;
				}
			};

			Map<String, List<PEEntity>> processEntityList = new HashMap<String, List<PEEntity>>();
			for (Entry<String, List<String>> entry : processToEntityInfo.entrySet()) {
				List<String> entityInfoList = entry.getValue();
				List<PEEntity> entityList = new ArrayList<PEEntity>();
				processEntityList.put(entry.getKey(), entityList);
				for (String info : entityInfoList) {
					PEEntity entity = entitiesMap.get(info);
					if (entity != null) {
						entityList.add(entity);
					} else {
					}
				}
				Collections.sort(entityList, comparator);
				JSONArray array = JSONFactoryUtil.createJSONArray();
				array.put(getJson("0", "All"));
				for (PEEntity peEntity : entityList) {
					array.put(getJson(String.format(entityInfoFormat, peEntity.getClassNameId(), peEntity.getId()),
							peEntity.getName()));
				}
				processToEntityJson.put(entry.getKey(), array);
			}

			Collections.sort(allEntities, comparator);
			JSONArray array = JSONFactoryUtil.createJSONArray();
			array.put(getJson("0", "All"));
			for (PEEntity peEntity : allEntities) {
				array.put(getJson(String.format(entityInfoFormat, peEntity.getClassNameId(), peEntity.getId()),
						peEntity.getName()));
			}
			processToEntityJson.put("0", array);
		}

		return processToEntityJson;
	}

	public static JSONObject getSubPersona(String personaId) {
		JSONObject subPersonaJson = JSONFactoryUtil.createJSONObject();
		JSONArray subPersonaArray = JSONFactoryUtil.createJSONArray();

		String vocabId;
		try {
			vocabId = SambaashUtil.getParameter(PEConstants.PERSONA_VOCABULARY_ID, 0);
			List<AssetCategory> assetCatList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(GetterUtil.getLong(personaId), GetterUtil.getLong(vocabId), -1, -1, null);
			if (assetCatList.size() > 0) {
				for (AssetCategory assetCat : assetCatList) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					obj.put("id", assetCat.getCategoryId());
					obj.put("name", assetCat.getName());
					subPersonaArray.put(obj);
				}
			}
			subPersonaJson.put("subPersona", subPersonaArray);

		} catch (Exception e) {
			_log.error(e);
			subPersonaJson.put("error", "Error while fetching Sub Persona");
		}

		return subPersonaJson;
	}
	
	
	public static JSONObject getScheduleDetails(long scheduleModelId, Long userId, Long siteId) {
		JSONObject scheduleData = JSONFactoryUtil.createJSONObject();
		JSONObject resultObj = JSONFactoryUtil.createJSONObject();

		String recordResponse;
		try {
			recordResponse = SystemLocalServiceUtil.fetchRecordByModelId(String.valueOf(scheduleModelId),"schedule",userId, siteId);
			scheduleData = JSONFactoryUtil.createJSONObject(recordResponse);
			JSONObject scheduleSpecifiData = scheduleData.getJSONObject("contentJson");
		
			resultObj.put("StartDate", scheduleSpecifiData.getString("StartDate"));
			resultObj.put("EndDate", scheduleSpecifiData.getString("EndDate"));
			_log.debug("StartDate " + scheduleSpecifiData.getString("StartDate"));
			_log.debug("EndDate " + scheduleSpecifiData.getString("EndDate"));
		} catch (Exception e) {
			_log.error(e);
			resultObj.put("error", "Error while fetching Schedule Details");
		}

		return resultObj;
	}


	private static JSONObject getJson(String id, String name) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("id", id);
		json.put("name", name);
		return json;
	}

	public static JSONObject retrieveProcessData(PEDataSource ds, Long formId) {
		JSONObject param = JSONFactoryUtil.createJSONObject();
		try {
			if (formId != null && formId > 0) {
				param.put("FORM_DATA", ds.getFormDataAdapter().fetchFormData(formId));
			}
			param.put("STATE_DATA", JSONFactoryUtil.createJSONObject(ds.getProcessState().getData()));
			param.put("USER_DATA", retrieveUserData(ds));
			param.put("ENTITY_DATA", retrieveEntityData(ds));
		} catch (Exception e) {
			_log.error(e);
		}
		return param;
	}

	private static JSONObject retrieveEntityData(PEDataSource ds) {
		JSONObject entityData = JSONFactoryUtil.createJSONObject();
		try {
			entityData.put("entityType", ds.getProcessState().getEntityClassId());
			entityData.put("entityId", ds.getProcessState().getEntityId());
		} catch (Exception e) {
			_log.error(e);
		}
		return entityData;
	}

	private static JSONObject retrieveUserData(PEDataSource ds) {
		JSONObject userData = JSONFactoryUtil.createJSONObject();
		try {
			userData.put("loggedInUserId", ds.getLoggedInUserId());
			JSONArray luRoles = JSONFactoryUtil.createJSONArray();
			for (Long rid : ds.getLoggedInUser().getRoleIds()) {
				luRoles.put(rid);
			}
			userData.put("loggedInUserRoles", luRoles);
			userData.put("applicantUserId", ds.getApplicant().getUserId());

			JSONArray applicantRoles = JSONFactoryUtil.createJSONArray();
			for (Long rid : ds.getApplicant().getRoleIds()) {
				applicantRoles.put(rid);
			}
			userData.put("applicantUserRoles", applicantRoles);
		} catch (Exception e) {
			_log.error(e);
		}
		return userData;
	}

	private static final Log _log = LogFactoryUtil.getLog(ProcessStateActionHelper.class);
}
