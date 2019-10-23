package com.sambaash.platform.pe.indexer;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.sambaash.platform.constant.FormConstants;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.adapter.PEFormDataAdapter;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.helpers.PEEntityHelper;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessStateActionableDynamicQuery;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
public class PEProcessStateIndexer extends BaseIndexer {
	public static final String[] CLASS_NAMES = { PEProcessState.class.getName() };

	public static final String PORTLET_ID = PEConstants.PORTLET_ID;

	private static Log _log = LogFactoryUtil.getLog(PEProcessStateIndexer.class);
	
	private static String formDataParam = null;
	
	private static JSONArray jsonArrayObject = null;

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		PEProcessState processState = (PEProcessState)obj;
		deleteDocument(processState.getCompanyId(), processState.getSpPEProcessStateId());
	}

	public static String getSearchableString(String str){
		str = GetterUtil.getString(str);
		str = str.toLowerCase();
		str = str.replace("?", "");
		str = str.replace("*", "");
		str = str.replace("'", "");
		str = str.replace(" ", "");
		str = str.replace("-", "");
		str = str.replace("_", "");
		str = str.replace("+", "");
		str = str.replace("@", "");
		str = str.replace("&", "");
		str = str.replace(":", "");
		return str;
	}
	
	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		PEProcessState processState = (PEProcessState)obj;
		Document document = null;
		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Indexing document " + processState);
			}
			
			document = getBaseModelDocument(PORTLET_ID, processState);
			if(formDataParam == null){
				formDataParam = SambaashUtil.getParameter(PEConstants.SP_PARAM_PE_PEOCESS_FORM_DATA, 0);
			}
			if(jsonArrayObject == null || jsonArrayObject.length() == 0) {
				jsonArrayObject = JSONFactoryUtil.createJSONArray(formDataParam);
			}
			
			PEFormDataAdapter dataAdapter = PEFormDataAdapter.getFormDataAdapter(processState);
			for (int i = 0; i < jsonArrayObject.length(); i++) {
				JSONObject field = jsonArrayObject.getJSONObject(i);
				String formId = field.getString("htmlFormId");
				String fieldName = field.getString("fieldId");
				String fieldType = field.getString("fieldType");
				String fieldValue = dataAdapter.getDataFromForm(formId, fieldName);
				if(fieldType.equalsIgnoreCase(FormConstants.KEY_OPTION_LIST) && null != fieldValue) {
					JSONArray jsonValueArray = JSONFactoryUtil.createJSONArray(fieldValue);
					if(null != jsonValueArray && jsonValueArray.length() > 0){
						JSONObject valueField = jsonValueArray.getJSONObject(0);
						if(null != valueField){
							String indexValue = valueField.getString("value", "");
							document.addKeyword(fieldName + "_" + formId, indexValue);	
						}
					}
				}
			}

			document.addKeyword(PEConstantsGlobal.ENTITY_ID, processState.getEntityId());
			document.addKeyword(PEConstantsGlobal.PROCESS_STATE_ID, processState.getSpPEProcessStateId());
			try{
			document.addKeyword(PEConstantsGlobal.ENTITY_NAME, PEEntityHelper.getEntity(processState.getEntityClassId(), processState.getEntityId()).getName());
			document.addKeyword(PEConstantsGlobal.ENTITY_NAME_LOWER, getSearchableString(PEEntityHelper.getEntity(processState.getEntityClassId(), processState.getEntityId()).getName()));
			}catch(Exception e){
				_log.error("error getting class name " + e.getMessage());
			}
			
			document.addKeyword(PEConstantsGlobal.ENTITY_CLASS_ID, processState.getEntityClassId());
			document.addKeyword(PEConstantsGlobal.PROCESS_STATUS_TYPE_ID, processState.getStatusTypeId());
			long closedStageId = processState.getClosedStageId();
			document.addKeyword(PEConstantsGlobal.CLOSED_STAGE_ID, closedStageId);
			if(closedStageId > 0){
				PEProcessStage stage = PEProcessStageLocalServiceUtil.getPEProcessStage(closedStageId);
				document.addKeyword(PEConstantsGlobal.CLOSED_STAGE_NAME, stage.getName());
				document.addKeyword(PEConstantsGlobal.CLOSED_STAGE_STYLE, stage.getStyle());
				document.addKeyword(PEConstantsGlobal.CLOSED_REASON_ID, processState.getClosedReasonCatId());
				document.addKeyword(PEConstantsGlobal.CLOSED_DESC, processState.getClosedDescription());
			}
			
			//Actve/Inactive status
			
			document.addKeyword(PEConstantsGlobal.ACTIVE_STATUS, processState.getActiveStatus());
			//Applicant
			document.addKeyword(PEConstantsGlobal.USER_ID_PROCESS, processState.getUserIdProcess());
			// Application Created By userId
			document.addKeyword(PEConstantsGlobal.USER_ID_CREATOR, processState.getUserIdCreator());
			// Supervisor for the application
			document.addKeyword(PEConstantsGlobal.USER_ID_SUPERVISOR, processState.getUserIdSupervisor());
			// Agent for the application
			document.addKeyword(PEConstantsGlobal.USER_ID_AGENT, processState.getUserIdAgent());
			document.addKeyword(PEConstantsGlobal.PROCESS_ID, processState.getSpPEProcessId());
			document.addKeyword(PEConstantsGlobal.STATUS, processState.getStatus());
			
			
			User user = UserLocalServiceUtil.getUser(processState.getUserIdProcess());
			if(user != null){
				document.addKeyword(PEConstantsGlobal.SCREEN_NAME, user.getScreenName());
				document.addKeyword(PEConstantsGlobal.EMAIL, user.getEmailAddress());
				document.addKeyword(PEConstantsGlobal.EMAIL_SEARCHABLE, getSearchableString(user.getEmailAddress()));
				document.addKeyword(PEConstantsGlobal.FULL_NAME_SEARCHABLE, getSearchableString(user.getFullName()));
				document.addKeyword(PEConstantsGlobal.FULL_NAME, user.getFullName());	
			}
			
			document.addKeyword(PEConstantsGlobal.PROCESS_STATE_CONVERTED_FROM, processState.getConvertedFromProcessStateId());
			document.addKeyword(PEConstantsGlobal.PROCESS_STATE_CONVERTED_TO, processState.getConvertedToProcessStateId());
			
			long statusTypeId = processState.getStatusTypeId();
			try {
				if (statusTypeId > 0){ // can be zero until first step is done
					PEProcessStatusType statusType = PEProcessStatusTypeLocalServiceUtil.getPEProcessStatusType(processState.getStatusTypeId());
					document.addKeyword(PEConstantsGlobal.PROCESS_STATUS_TYPE_NAME, statusType.getStatusName());
					document.addKeyword(PEConstantsGlobal.PROCESS_STATUS_TYPE_NAME_LOWER, getSearchableString(statusType.getStatusName()));
					if (statusType.getSpPEProcessStageId() > 0){ // stage id can be zero while registering ..
						PEProcessStage stage = PEProcessStageLocalServiceUtil.getPEProcessStage(statusType.getSpPEProcessStageId());
						document.addKeyword(PEConstantsGlobal.STAGE_NAME, stage.getName());
						document.addKeyword(PEConstantsGlobal.STAGE_ID, stage.getSpPEProcessStageId());
						document.addKeyword(PEConstantsGlobal.STAGE_STYLE, stage.getStyle());
					}
				}
			}catch (Exception ex) {
				_log.error("Error while indexing process stage information " + obj,ex );
			}
			if(PEEngineLocalServiceUtil.isOpenApplication(processState)){
				document.addKeyword(PEConstantsGlobal.DEAL_STAGE, -1); //Pending
			}else{
				document.addKeyword(PEConstantsGlobal.DEAL_STAGE, processState.getClosedStageId());
			}
			try {
				ClassName className = ClassNameLocalServiceUtil.getClassName(processState.getEntityClassId());
				if(className.getClassName().equalsIgnoreCase(Product.class.getCanonicalName())){
					Product product = ProductLocalServiceUtil.getProduct(processState.getEntityId());
					List<AssetCategory>splsList = ProductLocalServiceUtil.getSpecializationCatgIds(product);
					long[] specializationIds = StringUtil.split(
							ListUtil.toString(splsList, AssetCategory.CATEGORY_ID_ACCESSOR), 0L);
					document.addKeyword(PEConstantsGlobal.SPECIALIZAITON, specializationIds);
					document.addKeyword(PEConstantsGlobal.PRODUCT_COUNTRY, product.getCountryId());
				}
			} catch (Exception e) {
				_log.error("Error while indixeing product info");
			}
			try{
				// to support case insensitive search
				StringBuilder sb = new StringBuilder();
				Map<String, Field> map = document.getFields();
				Set<String> keyset = map.keySet();
				Iterator<String> iterator = keyset.iterator();
				while (iterator.hasNext()) {
					Field field = map.get(iterator.next());
					sb.append(field.getValue());
					sb.append(StringPool.SPACE);
				}
				document.addText("searchableContent", sb.toString().toLowerCase());
			}catch(Exception e){
				_log.error(e);
			}
			
			// participant details
			try {
				if (processState.getData().contains("participantDetails")) {
					JSONObject dataObj = JSONFactoryUtil.createJSONObject(processState.getData());
					document.addText(PEConstantsGlobal.PARTICIPANT_DETAILS, dataObj.getString("participantDetails"));
				} else {
					// not applicable
					document.addText(PEConstantsGlobal.PARTICIPANT_DETAILS, "NA");
				}
			} catch (Exception e) {
				_log.error("Error extracting participant details from: " + processState.getData(), e);
			}

		}catch (Exception ex) {
			_log.error("Error while indexing document " + obj,ex );
		}
		

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {

		// TODO Auto-generated method stub

		return null;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		PEProcessState processState = (PEProcessState)obj;
		Document doc = getDocument(obj);
		SearchEngineUtil.updateDocument(SearchEngineUtil.getSearchEngineId(doc), processState.getCompanyId(), doc, true);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		PEProcessState processState = PEProcessStateLocalServiceUtil.getPEProcessState(classPK);
		reindex(processState);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	private void reindexEntries(long companyId) throws PortalException, SystemException {

		// reference DLFileEntryIndexer

		ActionableDynamicQuery query = new PEProcessStateActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) throws PortalException,
					SystemException {
				PEProcessState processtate = (PEProcessState)object;
				Document document = getDocument(processtate);

				if (document != null) {
					addDocument(document);
				}
			}
		};
		query.setClassLoader(PortletClassLoaderUtil.getClassLoader(PEConstants.PORTLET_ID));
		query.setCompanyId(companyId);

		// this method internall query the all rows , calls performaction method on each object.

		query.performActions();
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {

		// TODO Auto-generated method stub

		return PORTLET_ID;
	}
}
