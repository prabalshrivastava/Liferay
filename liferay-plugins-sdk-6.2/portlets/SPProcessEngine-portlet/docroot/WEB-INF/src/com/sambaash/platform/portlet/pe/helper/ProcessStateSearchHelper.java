package com.sambaash.platform.portlet.pe.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;
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
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEEntity;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.helpers.PEHelper;
import com.sambaash.platform.pe.helpers.PEProcessHelper;
import com.sambaash.platform.pe.helpers.SearchHelper;
import com.sambaash.platform.pe.indexer.PEProcessStateIndexer;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil;
import com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage;
import com.sambaash.platform.srv.spdynamicforms.service.SPFormStorageLocalServiceUtil;
import com.sambaash.platform.util.ConvertUtil;
import com.sambaash.platform.util.SambaashUtil;

public class ProcessStateSearchHelper extends SearchHelper {
	private static final List<String> ID_ARRAY_PROPERTIES = Arrays.asList(PEConstants.PREF_PROCESS_IDS, PEConstants.PREF_DEAL_STATUS_IDS, PEConstants.PREF_STAGE_IDS, PEConstants.PREF_STUDENT_DASHBOARD_APPLICATION_STATUS);
	// search in listing screen

	public static Hits search(PortletRequest request, int start, int end) throws ParseException, SystemException {

		/** Preparing searchContext */
//		PortletPreferences portletPreferences = request.getPreferences();
		JSONObject prefs = ProcessStateSearchHelper.getStateListingConfiguration(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		SearchContext searchContext = new SearchContext();
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setCompanyId(themeDisplay.getCompanyId());

		Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
		Sort[] sorts = new Sort[] { sort };

		searchContext.setSorts(sorts);

		List<BooleanClause> bcs = new ArrayList<BooleanClause>();

		String formDataParam = SambaashUtil.getParameter(PEConstants.SP_PARAM_PE_PEOCESS_FORM_DATA, 0);

		JSONArray jsonArrayObject = null;

		// Applicant type
		if (isApplicantType(request)) {
			bcs.add(getBC4ExactTerm(PEConstantsGlobal.USER_ID_PROCESS, themeDisplay.getUserId(), searchContext));
			String applicationStatusToDisplay = getPrefrencesIds(prefs,
					PEConstants.PREF_STUDENT_DASHBOARD_APPLICATION_STATUS);

			if (applicationStatusToDisplay
					.contains(SambaashUtil.getParameter(PEConstants.SP_PARAM_PENDING_STAGE_ID, 0))) {
				applicationStatusToDisplay = applicationStatusToDisplay
						.replace(SambaashUtil.getParameter(PEConstants.SP_PARAM_PENDING_STAGE_ID, 0), "0");
			}
			bcs.add(getBCProcessIds(searchContext, applicationStatusToDisplay, PEConstantsGlobal.CLOSED_STAGE_ID));
		} else if (isAgentType(request)) { // Agent viewing the screent
			bcs.add(getBC4ExactTerm(PEConstantsGlobal.USER_ID_AGENT, themeDisplay.getUserId(), searchContext));
		} else if (isSupervisorType(request)) { // supervisor viewing the screen
			bcs.add(getBC4ExactTerm(PEConstantsGlobal.USER_ID_SUPERVISOR, themeDisplay.getUserId(), searchContext));
		} else if (isApproverType(request)) { // Approver viewing the screen
			// nothing
		} else {
			// error case
			return null;
		}
		BooleanClause bc = null;
		// process id clasue
		long processId = ParamUtil.getLong(request, "processId");
		String processIds = getPrefrencesIds(prefs, PEConstants.PREF_PROCESS_IDS);
		if (processId > 0) { // if the user select some process id then take it
								// else take from processes configured in
								// preferences
			processIds = String.valueOf(processId);
		}
		bcs.add(getBCProcessIds(searchContext, processIds, PEConstantsGlobal.PROCESS_ID));

		String statusTypeName = ParamUtil.getString(request, "statusTypeId");
		if (Validator.isNotNull(statusTypeName) && !ALL_STATUS_TYPES_VALUE.equalsIgnoreCase(statusTypeName)) {
			statusTypeName = statusTypeName.replace("&", "");
			bcs.add(getBC4ExactTerm(PEConstantsGlobal.PROCESS_STATUS_TYPE_NAME_LOWER, statusTypeName, searchContext));
		}

		String stageId = ParamUtil.getString(request, "stageId");
		if (Validator.isNotNull(stageId) && !stageId.equalsIgnoreCase("0")) {
			bcs.add(getBCProcessIds(searchContext, stageId, PEConstantsGlobal.STAGE_ID));
		}
		if (jsonArrayObject == null) {
			try {
				jsonArrayObject = JSONFactoryUtil.createJSONArray(formDataParam);

				for (int i = 0; i < jsonArrayObject.length(); i++) {
					JSONObject field = jsonArrayObject.getJSONObject(i);
					String formId = field.getString("htmlFormId");
					String fieldName = field.getString("fieldId");
					String fieldType = field.getString("fieldType");
					String paramId = fieldName + "_" + formId;
					String dynamicSelectName = ParamUtil.getString(request, paramId);
					_log.error(dynamicSelectName);
					if (Validator.isNotNull(dynamicSelectName) && !dynamicSelectName.equalsIgnoreCase("-1")) {
						BooleanQuery fieldSearchQuery = BooleanQueryFactoryUtil.create(searchContext);
						TermQuery phraseSearchQuery = TermQueryFactoryUtil.create(searchContext, paramId,
								StringEscapeUtils.escapeJava(dynamicSelectName));
						fieldSearchQuery.add(phraseSearchQuery, BooleanClauseOccur.SHOULD);
						bcs.add(BooleanClauseFactoryUtil.create(searchContext, fieldSearchQuery,
								BooleanClauseOccur.MUST.getName()));
						// bcs.add(getBC4Terms(new String[] { paramId },
						// String.valueOf(dynamicSelectName), searchContext));
						// bcs.add(getBC4ExactTerm(paramId, dynamicSelectName,
						// searchContext));
					}

				}
			} catch (JSONException e) {
				_log.error(e);
			}
		}

		long dealStatusId = ParamUtil.getLong(request, "dealStatusId");
		if (dealStatusId > 0) {
			long[] dealStageIds = PEEngineLocalServiceUtil.getDealStageIds();
			String dealStageIdsStrArr = Arrays.toString(dealStageIds);
			if (dealStageIdsStrArr.contains(String.valueOf(dealStatusId))) {
				bcs.add(getBC4Terms(new String[] { PEConstantsGlobal.CLOSED_STAGE_ID }, String.valueOf(dealStatusId),
						searchContext));
			} else {
				bcs.add(getBC4Terms(new String[] { PEConstantsGlobal.CLOSED_STAGE_ID }, String.valueOf(0),
						searchContext)); // search for pending applications
			}
		}

		long closedLostReasonId = ParamUtil.getLong(request, PEConstantsGlobal.CLOSED_REASON_ID);
		if (closedLostReasonId > 0) {
			bcs.add(getBC4ExactTerm(PEConstantsGlobal.CLOSED_REASON_ID, closedLostReasonId, searchContext));
		}

		long userId = ParamUtil.getLong(request, "assigneeId");
		if (userId >= 0) {
			// when supervisor is viewing the screen, Assignee filled with agent
			// user id's. Search must be done on Agent column
			if (isSupervisorType(request)) {
				bcs.add(getBC4ExactTerm(PEConstantsGlobal.USER_ID_AGENT, userId, searchContext));
			} else if (isApproverType(request)) {
				// when Approver is viewing the screen, Assignee filled with
				// agents and supervisor user id's. so Search must be done on
				// Agent column and Supervisor column
				bcs.add(getBC4Terms(
						new String[] { PEConstantsGlobal.USER_ID_AGENT, PEConstantsGlobal.USER_ID_SUPERVISOR },
						String.valueOf(userId), searchContext));
			}
		}

		String text = ParamUtil.getString(request, "searchText");
		if (Validator.isNotNull(text)) {
			bc = getSearchTextQuery(searchContext, text);
			if (bc != null) {
				bcs.add(bc);
			}
		}

		bc = getBCForDate(request, searchContext);
		if (bc != null) {
			bcs.add(bc);
		}

		/** -----ActiveStatus filter Start--- ***/
		// Fileter for Active/Inactive applications. By default active
		// applications must be displayed.
		String activeStatus = ParamUtil.getString(request, "activeStatus");
		bc = null;
		if (Validator.isNotNull(activeStatus) && !activeStatus.equalsIgnoreCase("-1")) {
			// If no filter is supplied, by default fetch only active records
			// activeStatus = PEConstantsGlobal.ACTIVE_STATUS_ACTIVE;
			bc = getBC4ExactTerm(PEConstantsGlobal.ACTIVE_STATUS, String.valueOf(activeStatus), searchContext);
		}

		if (bc != null) {
			bcs.add(bc);
		}
		/** -----ActiveStatus filter End--- ***/

		/** --- Entity Filter Start --- **/
		bc = getBCEntity(request, searchContext);
		if (bc != null) {
			bcs.add(bc);
		}

		/** --- Entity Filter End--- **/

		if (bcs.size() > 0) {
			searchContext.setBooleanClauses(bcs.toArray(new BooleanClause[bcs.size()]));
		}

		/** End -- Preparing search context */

		// Let's make search

		Hits results = search(searchContext);

		// Convert results to list

		return results;
	}

	public static Hits search(SearchContext searchContext) {

		Indexer indexer = IndexerRegistryUtil.getIndexer(PEProcessState.class.getName());
		Hits results = null;
		try {
			results = indexer.search(searchContext);
			_log.debug("Search Query " + results.getQuery());
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}

		return results;
	}

	// id is random id, ususally userId
	public static String generateName(long id) {
		String tmp = "submissions_" + System.currentTimeMillis() + "_" + id + ".xlsx";
		return System.getProperty("java.io.tmpdir") + File.separator + tmp;
	}

	public static JSONObject export(PortletRequest request) {
		String processId = ParamUtil.getString(request, "processId");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		try {
			Hits hits = search(request, -1, -1);
			List<Document> docs = convertToList(hits);
			String path = generateName(themeDisplay.getUserId());
			ExportHelper exportHelper = ExportHelper.getExportHelper(GetterUtil.getLong(processId), path);
			exportHelper.export(docs);
			responseData.put("filePath", path);
		} catch (SystemException | PEConfigException | PortalException | JAXBException | IOException e) {
			_log.error(e);
			responseData.put("error", "Unable to export the details");
		}

		return responseData;
	}

	public static JSONObject searchProcessStates(ResourceRequest request, ResourceResponse response) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//		PortletPreferences portletPreferences = request.getPreferences();
//		String processIds = GetterUtil.getString(portletPreferences.getValue(PEConstants.PREF_PROCESS_IDS, "0"));
		String processIds = getPrefrencesIds(getStateListingConfiguration(request), PEConstants.PREF_PROCESS_IDS);
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		/** Calculating start and end */
		int start = ParamUtil.getInteger(request, "start", 0);
		int pageSize = ParamUtil.getInteger(request, "pageSize", 10);

		// just to make sure, page size valid

		if (pageSize < 1 || pageSize > 500) {
			pageSize = 10;
		}

		// TODO: if start = -1, make sure we are fetching documents length =
		// pagesize

		int end = start + pageSize;

		Hits results = null;
		try {
			results = search(request, start, end);
			if (Validator.isNotNull(results)) {
				responseData.put("total", results.getLength());
			}
		} catch (ParseException | SystemException e1) {
			_log.error(e1);
			responseData.put("error", "Unable to get the results");
		}
		List<Document> docsList = convertToList(results);

		Map<Long, PEProcess> processMap = getProcessMap(processIds);
		JSONArray processStates = JSONFactoryUtil.createJSONArray();

		long processStateId;
		long processId;
		long entityId;
		JSONObject processStateJson;
		PEProcess process;
		PEEntity peEntity;
		String status;
		String statusTypeName;
		String closedWonEnabledStages = GetterUtil
				.getString(SambaashUtil.getParameter(PEConstantsGlobal.SP_PARAM_CLOSED_ENABLED_STAGE_IDS, 0));
		for (Document doc : docsList) {
			processStateJson = JSONFactoryUtil.createJSONObject();

			// check PEProcessStateIndexer for field names fetching from
			// document object

			processStateId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
			processId = GetterUtil.getLong(doc.get(PEConstantsGlobal.PROCESS_ID));
			entityId = GetterUtil.getLong(doc.get(PEConstantsGlobal.ENTITY_ID));

			status = GetterUtil.getString(doc.get(PEConstantsGlobal.STATUS));
			statusTypeName = GetterUtil.getString(doc.get(PEConstantsGlobal.PROCESS_STATUS_TYPE_NAME));

			// this is required

			processStateJson.put("processStateId", processStateId);

			process = processMap.get(processId);

			try {
				long entityClassId = GetterUtil.getLong(doc.get(PEConstantsGlobal.ENTITY_CLASS_ID));
				long usrId = 0;
				long siteId = 0;
				try {
					usrId = PortalUtil.getUserId(request);
					siteId = PortalUtil.getScopeGroupId(request);

				} catch (PortalException | SystemException e) {
					_log.error(e.getMessage());
				}
				peEntity = PEProcessLocalServiceUtil.getEntityDetail(entityClassId, String.valueOf(entityId), usrId,
						siteId);
				processStateJson.put("processId", doc.get(PEConstantsGlobal.PROCESS_ID));
				String stageName = doc.get(PEConstantsGlobal.STAGE_NAME);
				long closedCatgId = GetterUtil.getLong(doc.get(PEConstantsGlobal.CLOSED_REASON_ID));
				processStateJson.put("closedCatgId", closedCatgId);
				processStateJson.put("colsedStageId", GetterUtil.getLong(doc.get(PEConstantsGlobal.CLOSED_STAGE_ID)));
				String closedStageName = doc.get(PEConstantsGlobal.CLOSED_STAGE_NAME);
				long processStateConvertedTo = GetterUtil
						.getLong(doc.get(PEConstantsGlobal.PROCESS_STATE_CONVERTED_TO));
				if (Validator.isNotNull(processStateConvertedTo)) {
					String convertedToOpportunity = StringPool.BLANK;
					if (processStateConvertedTo > 0) {
						convertedToOpportunity = "Conv..";
					}
					stageName = stageName + " (" + convertedToOpportunity + ")";
					processStateJson.put("closedStageStyle", doc.get(PEConstantsGlobal.CLOSED_STAGE_STYLE));
				} else if (Validator.isNotNull(closedStageName)) {
					if (closedStageName.toLowerCase().indexOf("lost") > 1) {
						closedStageName = "Lost";
					} else if (closedStageName.toLowerCase().indexOf("won") > 1) {
						closedStageName = "Won";
					}
					stageName = stageName + " (" + closedStageName + ")";
					processStateJson.put("closedStageStyle", doc.get(PEConstantsGlobal.CLOSED_STAGE_STYLE));
				}
				if (closedCatgId > 0) {
					String closeddec = doc.get(PEConstantsGlobal.CLOSED_DESC);
					AssetCategory catg = AssetCategoryLocalServiceUtil.getAssetCategory(closedCatgId);
					String desc = catg.getName();
					if (Validator.isNotNull(closeddec)) {
						desc = desc + " - " + closeddec;
					}
					processStateJson.put("stageToolTip", desc);
				}

				long stageId = GetterUtil.getLong(doc.get(PEConstantsGlobal.STAGE_ID));
				processStateJson.put("stageId", stageId);
				processStateJson.put("stageName", stageName);
				processStateJson.put("applicantName", doc.get(PEConstantsGlobal.FULL_NAME));
				processStateJson.put("dataModified", PEHelper.getDateStrddMMYYYYHMS(doc.getDate(Field.MODIFIED_DATE)));
				processStateJson.put("dataCreated", PEHelper.getDateStrddMMYYYYHMS(doc.getDate(Field.CREATE_DATE)));
				processStateJson.put("style", doc.get(PEConstantsGlobal.STAGE_STYLE));
				processStateJson.put("entityName", peEntity.getName());
				processStateJson.put("currentStep", getStatusString(statusTypeName, status));
				processStateJson.put("activeStatus", doc.get(PEConstantsGlobal.ACTIVE_STATUS));

				// supervisor
				long supervisorId = GetterUtil.getLong(doc.get(PEConstantsGlobal.USER_ID_SUPERVISOR));
				if (supervisorId > 0) {
					User supervisor = UserLocalServiceUtil.getUser(supervisorId);
					processStateJson.put("supervisorName", supervisor.getFullName());
				}
				// Agent
				long agentId = GetterUtil.getLong(doc.get(PEConstantsGlobal.USER_ID_AGENT));
				if (agentId > 0) {
					User agent = UserLocalServiceUtil.getUser(agentId);
					processStateJson.put("agentName", agent.getFullName());
				}

				String[] stages = closedWonEnabledStages.split(StringPool.COMMA);
				for (String stage : stages) {
					long stageTemp = GetterUtil.getLong(stage);
					if (stageTemp == stageId) {
						processStateJson.put("enableCloseWon", true);
						break;
					}
				}

				// user profile url
				String profileUrl = StringPool.BLANK;
				try {
					Long userId = Long.parseLong(doc.get(PEConstantsGlobal.USER_ID_PROCESS));
					processStateJson.put("userIdProcess", userId);
					User user = UserLocalServiceUtil.getUser(userId);
					profileUrl = StringPool.FORWARD_SLASH + user.getScreenName();
				} catch (Exception e) {
					_log.error("Failed to retrive user profile url");
				}

				processStateJson.put("profileUrl", profileUrl);

			} catch (Exception e) {
				_log.error("Failed to get processStates 470 " + e.getMessage());
			}
			processStates.put(processStateJson);

			processStateJson.put("url",
					ProcessStateDisplayHelper.getDisplayUrlProcessState(request, processStateId, 0));

			long convertedToProcessStateId = GetterUtil.getLong(doc.get(PEConstantsGlobal.PROCESS_STATE_CONVERTED_TO));
			long convertedFromProcessStateId = GetterUtil
					.getLong(doc.get(PEConstantsGlobal.PROCESS_STATE_CONVERTED_FROM));
			try {
				if (convertedToProcessStateId > 0) {
					User loggedInUser = themeDisplay.getUser();
					if (PEProcessHelper.isAgent(loggedInUser, process)
							|| PEProcessHelper.isSupervisor(loggedInUser, process)
							|| PEProcessHelper.isGlobalStatusTypeApprover(loggedInUser, process)) {
						processStateJson.put("convertedToUrl", ProcessStateDisplayHelper
								.getDisplayUrlProcessState(request, convertedToProcessStateId, 0));
					}

				}

				if (convertedFromProcessStateId > 0) {
					User loggedInUser = themeDisplay.getUser();
					if (PEProcessHelper.isAgent(loggedInUser, process)
							|| PEProcessHelper.isSupervisor(loggedInUser, process)
							|| PEProcessHelper.isGlobalStatusTypeApprover(loggedInUser, process)) {
						processStateJson.put("convertedFromUrl", ProcessStateDisplayHelper
								.getDisplayUrlProcessState(request, convertedFromProcessStateId, 0));
					}

				}
			} catch (SystemException e) {
				_log.error(e);
			}
		}

		responseData.put("procesStates", processStates);
		// obj.put("totalDocs", results.getLength());
		return responseData;
	}

	private static BooleanClause getBCProcessIds(SearchContext searchContext, String processIds, String term)
			throws SystemException, ParseException {
		BooleanQuery query = BooleanQueryFactoryUtil.create(searchContext);
		String[] processIdAr = processIds.split(StringPool.COMMA);
		for (String processId : processIdAr) {
			if (Validator.isNotNull(processId)) {
				query.addTerm(term, processId);
			}
		}
		BooleanClause bc = null;
		if (query.hasClauses()) {
			bc = BooleanClauseFactoryUtil.create(searchContext, query, BooleanClauseOccur.MUST.getName());
		}
		return bc;
	}

	private static BooleanClause getBCEntity(PortletRequest request, SearchContext searchContext) {
		BooleanClause bc = null;
		String entity = ParamUtil.getString(request, "entity");
		if (Validator.isNotNull(entity)) {
			String[] ids = entity.split(StringPool.POUND);
			if (ids.length > 1) {
				long entityClassId = GetterUtil.getLong(ids[0]);
				long entityId = GetterUtil.getLong(ids[1]);
				if (entityId > 0 && entityClassId > 0) {
					BooleanQuery query = BooleanQueryFactoryUtil.create(searchContext);
					query.addRequiredTerm(PEConstantsGlobal.ENTITY_ID, entityId);
					query.addRequiredTerm(PEConstantsGlobal.ENTITY_CLASS_ID, entityClassId);
					bc = BooleanClauseFactoryUtil.create(searchContext, query, BooleanClauseOccur.MUST.getName());
				}
			}
		}
		return bc;
	}

	private static Map<Long, PEProcess> getProcessMap(String processids) {
		Map<Long, PEProcess> processMap = new HashMap<Long, PEProcess>();
		String[] ids = processids.split(StringPool.COMMA);

		for (String strid : ids) {
			long processId = GetterUtil.getLong(strid);

			if (processId > 0) {
				try {
					PEProcess process = PEProcessLocalServiceUtil.getPEProcess(processId);
					processMap.put(process.getSpPEProcessId(), process);
				} catch (Exception ex) {
					_log.error("Error while getting process with id=" + processId, ex);
				}
			}
		}

		return processMap;
	}

	public static String getStatusString(long statsTypeId, String status) {
		PEProcessStatusType stausType;
		try {
			stausType = PEProcessStatusTypeLocalServiceUtil.getPEProcessStatusType(statsTypeId);
			return stausType.getStatusName() + (Validator.isNotNull(status) ? " - " + status : StringPool.BLANK);
		} catch (PortalException | SystemException e) {
			_log.error("Error while getting status type for statustype id " + statsTypeId);
		}
		return StringPool.BLANK;
	}

	public static String getStatusString(String statusName, String status) {
		return GetterUtil.getString(statusName) + (Validator.isNotNull(status) ? " - " + status : StringPool.BLANK);
	}

	public static String getUserType(PortletRequest request) {
		String type = getPreference(getStateListingConfiguration(request), PEConstants.PREF_USER_TYPE, "");
//		PortletPreferences preferences = request.getPreferences();
//		String type = preferences.getValue(PEConstants.PREF_USER_TYPE, "");
		return type;
	}

	public static boolean isSupervisorType(PortletRequest request) {
		return PEConstants.USER_TYPE_SUPERVISOR.equalsIgnoreCase(getUserType(request));
	}

	public static boolean isApproverType(PortletRequest request) {
		return PEConstants.USER_TYPE_APPROVER.equalsIgnoreCase(getUserType(request));
	}

	public static boolean isAgentType(PortletRequest request) {
		return PEConstants.USER_TYPE_AGENT.equalsIgnoreCase(getUserType(request));
	}

	public static boolean isApplicantType(PortletRequest request) {
		return PEConstants.USER_TYPE_APPLICANT.equalsIgnoreCase(getUserType(request));
	}

//	public static String getPrefrencesIds(PortletPreferences portletPreferences, String constant) {
//		return GetterUtil.getString(portletPreferences.getValue(constant, "0"));
//	}
//
//	public static long[] getPrefrencesIdsArray(PortletPreferences portletPreferences, String constant) {
//		String prefIdstr = getPrefrencesIds(portletPreferences, constant);
//		String[] temp = prefIdstr.split(StringPool.COMMA);
//		long[] prefIds = new long[temp.length];
//		for (int i = 0; i < temp.length; i++) {
//			prefIds[i] = GetterUtil.getLong(temp[i]);
//		}
//
//		return prefIds;
//	}

public static String getPrefrencesIds(JSONObject prefs, String key) {
	if (ID_ARRAY_PROPERTIES.contains(key)) {
		return getPreference(prefs, key, "0").replace("[", "").replace("]", "");	
	} else {
		return getPreference(prefs, key, "0");	
	}
}
	
public static long[] getPrefrencesIdsArray(JSONObject prefs, String key) {
	String prefIdstr = getPrefrencesIds(prefs, key);
	String[] temp = prefIdstr.replace("[", "").replace("]", "").split(StringPool.COMMA);
	long[] prefIds = new long[temp.length];
	for (int i = 0; i < temp.length; i++) {
		prefIds[i] = GetterUtil.getLong(temp[i]);
	}

	return prefIds;
}
	
	private static BooleanClause getSearchTextQuery(SearchContext searchContext, String text)
			throws SystemException, ParseException {
		// optional search text
		BooleanClause bc = null;
		if (Validator.isNotNull(text)) {
			BooleanQuery query = BooleanQueryFactoryUtil.create(searchContext);
			String[] searchableFields = { "searchableContent" };
			query.addTerms(searchableFields, PEProcessStateIndexer.getSearchableString(text), true);
			if (query.hasClauses()) {
				bc = BooleanClauseFactoryUtil.create(searchContext, query, BooleanClauseOccur.MUST.getName());
			}
		}
		return bc;
	}

	public static JSONObject getCloseReasons(long[] processIds) {
		JSONObject processes = JSONFactoryUtil.createJSONObject();
		try {
			List<PEProcess> list = PEProcessLocalServiceUtil.findByProcessIds(processIds);
			for (PEProcess process : list) {
				long vocId = process.getClosedReasonVocId();
				JSONArray array = JSONFactoryUtil.createJSONArray();
				if (vocId > 0) {
					List<AssetCategory> catgs = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocId, -1, -1,
							null);
					for (AssetCategory catg : catgs) {
						array.put(getJson(String.valueOf(catg.getCategoryId()), catg.getName()));
					}
				}
				processes.put(String.valueOf(process.getSpPEProcessId()), array);
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return processes;
	}

	public static JSONObject getCloseReasonsFliter(long[] processIds) {
		JSONObject processes = JSONFactoryUtil.createJSONObject();
		try {
			List<PEProcess> list = PEProcessLocalServiceUtil.findByProcessIds(processIds);
			Map<String, JSONObject> uniqueAssetTypes = new LinkedHashMap<String, JSONObject>();
			for (PEProcess process : list) {
				long vocId = process.getClosedReasonVocId();
				JSONArray array = JSONFactoryUtil.createJSONArray();
				if (vocId > 0) {
					List<AssetCategory> catgs = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocId, -1, -1,
							null);
					for (AssetCategory catg : catgs) {
						uniqueAssetTypes.put(String.valueOf(catg.getCategoryId()),
								getJson(String.valueOf(catg.getCategoryId()), catg.getName()));
					}
				}
			}
			JSONArray defaultAllJson = JSONFactoryUtil.createJSONArray();
			for (Entry<String, JSONObject> entry : uniqueAssetTypes.entrySet()) {
				defaultAllJson.put(entry.getValue());
			}
			processes.put("0", defaultAllJson);
		} catch (Exception e) {
			_log.error(e);
		}
		return processes;
	}

	public static JSONObject getStatusTypes(long[] processIds) {
		// stores status types of all processes in this format { processId :
		// [types],processId:[types]}
		// there will be one default processId (0), which ties all process types
		// of all processes
		JSONObject allProcessStatusTypes = JSONFactoryUtil.createJSONObject();

		try {
			List<PEProcessStatusType> types = PEProcessStatusTypeLocalServiceUtil.findByProcessIds(processIds);
			// using map her to have unique Status Type names
			Map<String, JSONObject> uniqueStatusTypes = new LinkedHashMap<String, JSONObject>();
			for (PEProcessStatusType peProcessStatusType : types) {
				String key = String.valueOf(peProcessStatusType.getSpPEProcessId());
				JSONArray processStatusTypes = allProcessStatusTypes.getJSONArray(key);
				if (processStatusTypes == null) {
					processStatusTypes = JSONFactoryUtil.createJSONArray();
					// keeping ALL_STATUS_TYPES_VALUE instead of empty to work
					// in IE. Empty value causing issue in IE. When value is
					// empty, respective text(All Status Types) is being
					// returned by A.one("statusType").val() method
					processStatusTypes.put(getJson(ALL_STATUS_TYPES_VALUE, "All Status Types"));
					allProcessStatusTypes.put(key, processStatusTypes);
				}
				String searchable = PEProcessStateIndexer.getSearchableString(peProcessStatusType.getStatusName());
				JSONObject statuTypeJson = getJson(searchable, peProcessStatusType.getStatusName());
				processStatusTypes.put(statuTypeJson);
				uniqueStatusTypes.put(searchable, statuTypeJson);
			}

			// Convert map to json
			JSONArray defaultAllJson = JSONFactoryUtil.createJSONArray();
			defaultAllJson.put(getJson(ALL_STATUS_TYPES_VALUE, "All Status Types"));
			for (Entry<String, JSONObject> entry : uniqueStatusTypes.entrySet()) {
				defaultAllJson.put(entry.getValue());
			}
			allProcessStatusTypes.put("0", defaultAllJson);

		} catch (SystemException e) {
			_log.error(e);
		}
		return allProcessStatusTypes;
	}

	public static JSONObject getAssignees(long[] processIds, PortletRequest request) {
		// stores agent/supervisor of all processes in this format { processId :
		// [users],processId:[users]}
		// there will be one default processId (0), which includes all
		// agents/supervisors of all processes
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject assigneeData = JSONFactoryUtil.createJSONObject();
		try {
			String roleIdsStr = StringPool.BLANK;
			// allAssignees - All processes supervisors and agents
			JSONArray allAssignees = JSONFactoryUtil.createJSONArray();
			JSONArray allAssigneesSorted = JSONFactoryUtil.createJSONArray();

			// default
			assigneeData.put(String.valueOf(0), allAssigneesSorted);

			Map<Long, Long> allAssigneesUnique = new LinkedHashMap<Long, Long>();
			List<PEProcess> processList = PEProcessLocalServiceUtil.findByProcessIds(processIds);
			for (PEProcess process : processList) {
				// For supervisors allow only agent id's to be searchable
				if (isSupervisorType(request)) {
					roleIdsStr = process.getAgentRoleIds(); // roleIds + "," +
															// process.getAgentRoleIds();
				}
				// For Approvers/Admins allow all both supervisors and agents
				if (isApproverType(request)
						|| SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
					roleIdsStr = process.getAgentRoleIds(); // process.getSupervisorRoleIds()
															// + "," +
				}

				// Convert to ArrayList
				String idsStr[] = roleIdsStr.split(StringPool.COMMA);
				List<User> assignees = new ArrayList<User>();
				for (String idStr : idsStr) {
					long roleId = GetterUtil.getLong(idStr);
					if (roleId > 0) {
						List<User> list = UserLocalServiceUtil.getRoleUsers(roleId);
						assignees.addAll(list);
					}
				}
				JSONArray usersJson = JSONFactoryUtil.createJSONArray();
				Map<Long, Long> unique = new LinkedHashMap<Long, Long>();
				for (User user : assignees) {
					if (unique.containsKey(user.getUserId())) {
						continue;
					}
					unique.put(user.getUserId(), user.getUserId());

					JSONObject userJson = getJson(String.valueOf(user.getUserId()), user.getFullName());
					usersJson.put(userJson);

					if (!allAssigneesUnique.containsKey(user.getUserId())) {
						allAssigneesUnique.put(user.getUserId(), user.getUserId());
						allAssignees.put(getJson(String.valueOf(user.getUserId()), user.getFullName()));
					}
				}

				JSONArray usersJsonSorted = getSortedJsonArray(usersJson);

				assigneeData.put(String.valueOf(process.getSpPEProcessId()), usersJsonSorted);
			}

			allAssigneesSorted = getSortedJsonArray(allAssignees);

			assigneeData.put("0", allAssigneesSorted);

		} catch (SystemException e) {
			_log.error(e);
		}
		return assigneeData;
	}

	public static JSONObject getDataSalesDropdown(long[] processIds, PortletRequest request) {
		// stores agent/supervisor of all processes in this format { processId :
		// [users],processId:[users]}
		// there will be one default processId (0), which includes all
		// agents/supervisors of all processes
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject assigneeData = JSONFactoryUtil.createJSONObject();
		try {
			String roleIdsStr = StringPool.BLANK;
			// allAssignees - All processes supervisors and agents
			JSONArray allAssignees = JSONFactoryUtil.createJSONArray();
			JSONArray allAssigneesSorted = JSONFactoryUtil.createJSONArray();

			// default
			assigneeData.put(String.valueOf(0), allAssigneesSorted);

			Map<Long, Long> allAssigneesUnique = new LinkedHashMap<Long, Long>();
			List<PEProcess> processList = PEProcessLocalServiceUtil.findByProcessIds(processIds);
			for (PEProcess process : processList) {
				// For supervisors allow only agent id's to be searchable
				if (isSupervisorType(request)) {
					roleIdsStr = process.getAgentRoleIds(); // roleIds + "," +
															// process.getAgentRoleIds();
				}
				// For Approvers/Admins allow all both supervisors and agents
				if (isApproverType(request)
						|| SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
					roleIdsStr = process.getSupervisorRoleIds() + "," + process.getAgentRoleIds();
				}

				// Convert to ArrayList
				String idsStr[] = roleIdsStr.split(StringPool.COMMA);
				List<User> assignees = new ArrayList<User>();
				for (String idStr : idsStr) {
					long roleId = GetterUtil.getLong(idStr);
					if (roleId > 0) {
						List<User> list = UserLocalServiceUtil.getRoleUsers(roleId);
						assignees.addAll(list);
					}
				}
				JSONArray usersJson = JSONFactoryUtil.createJSONArray();
				Map<Long, Long> unique = new LinkedHashMap<Long, Long>();
				for (User user : assignees) {
					if (unique.containsKey(user.getUserId())) {
						continue;
					}
					unique.put(user.getUserId(), user.getUserId());

					JSONObject userJson = getJson(String.valueOf(user.getUserId()), user.getFullName());
					usersJson.put(userJson);

					if (!allAssigneesUnique.containsKey(user.getUserId())) {
						allAssigneesUnique.put(user.getUserId(), user.getUserId());
						allAssignees.put(getJson(String.valueOf(user.getUserId()), user.getFullName()));
					}
				}

				JSONArray usersJsonSorted = getSortedJsonArray(usersJson);

				assigneeData.put(String.valueOf(process.getSpPEProcessId()), usersJsonSorted);
			}

			allAssigneesSorted = getSortedJsonArray(allAssignees);

			assigneeData.put("0", allAssigneesSorted);

		} catch (SystemException e) {
			_log.error(e);
		}
		return assigneeData;
	}

	private static JSONArray getSortedJsonArray(JSONArray jsonArrStr) {

		JSONArray jsonArr = jsonArrStr;
		JSONArray sortedJsonArray = JSONFactoryUtil.createJSONArray();

		List<JSONObject> jsonValues = new ArrayList<JSONObject>();
		for (int i = 0; i < jsonArr.length(); i++) {
			jsonValues.add(jsonArr.getJSONObject(i));
		}

		Collections.sort(jsonValues, new Comparator<JSONObject>() {
			// You can change "Name" with "ID" if you want to sort by ID
			private static final String KEY_NAME = "name";

			@Override
			public int compare(JSONObject a, JSONObject b) {
				String valA = new String();
				String valB = new String();

				valA = (String) a.getString(KEY_NAME);
				valB = (String) b.getString(KEY_NAME);

				return valA.compareToIgnoreCase(valB);
			}
		});

		sortedJsonArray.put(getJson(String.valueOf(-1), ASSIGNEE));
		sortedJsonArray.put(getJson(String.valueOf(0), UNASSIGNED));
		for (int i = 0; i < jsonArr.length(); i++) {
			sortedJsonArray.put(jsonValues.get(i));
		}

		return sortedJsonArray;
	}

	private static String ALL_STATUS_TYPES_VALUE = "allStatusTypes";
	private static String ASSIGNEE = "Sales";
	private static String UNASSIGNED = "Unassigned";

	private static JSONObject getJson(String id, String name) {
		JSONObject statusType = JSONFactoryUtil.createJSONObject();
		statusType.put("id", id);
		statusType.put("name", name);
		return statusType;
	}
	
	public static JSONObject getStateListingConfiguration(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		return getStateListingConfiguration(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), request.getPreferences());
	}
	
	public static JSONObject getStateListingConfiguration(long scopeGroupId, long userId, PortletPreferences portletPreferences) {
		JSONObject retVal = JSONFactoryUtil.createJSONObject();
		long configStorageId = GetterUtil.getLong(portletPreferences.getValue("configStorageId", "0"));
		try {
			SPFormStorage data = SPFormStorageLocalServiceUtil.getSPFormStorage(configStorageId);
			JSONObject prefs = JSONFactoryUtil.createJSONObject(data.getContent());
			JSONArray configArr = prefs.getJSONArray("configuration");
			for (int i=0; i<configArr.length(); i++) {
				JSONObject config = configArr.getJSONObject(i);
				JSONArray roleArr = config.getJSONArray("role");
				List<String> configRoleList = ConvertUtil.Json.jsonArrayToStringList(roleArr);
				String roleListStr = StringUtils.join(configRoleList.toArray(),",");
				if (SambaashUtil.checkRoleAccess(scopeGroupId, userId, roleListStr)) {
					retVal = config;
					break;
				}
			}
		} catch (Exception e) {
			_log.error("Error getting state listing config. Config strorage Id from Preferences : " + configStorageId);
			if(_log.isDebugEnabled()){
				_log.error(e);
			}
		}
		return retVal;
	}
	
	public static String getPreference(JSONObject prefs, String key, String defaultValue) {
		String retVal = null;
		try {
			retVal = prefs.getString(key);
		} catch (Exception e) {
			_log.error("Unable to get preference: "+key, e);
		}
		if (StringUtils.isEmpty(retVal)) {
			retVal = defaultValue;
		}
		return retVal;
	}

	private static Log _log = LogFactoryUtil.getLog(ProcessStateSearchHelper.class);

}
