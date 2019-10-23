package com.sambaash.platform.portlet.profile.action;

import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringEscapeUtils;
import org.xml.sax.InputSource;

import com.liferay.counter.service.CounterLocalServiceUtil;
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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.NoSuchTemplateException;
import com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.profile.ProfileConstants;
import com.sambaash.platform.srv.mail.NoSuchCampaignEDMException;
import com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLinkTrackingLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.processbuilder.model.PEDummyEntity;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException;
import com.sambaash.platform.srv.spprofile.model.ProfilePreferences;
import com.sambaash.platform.srv.spprofile.service.ProfilePreferencesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class ProfileAction extends MVCPortlet {

	private static Log logger = LogFactoryUtil.getLog(ProfileAction.class);
	public static final String PORTLET_ID = "UserProfile_WAR_UserProfileportlet";

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String loadObjects = ParamUtil.getString(renderRequest, ProfileConstants.PARAM_LOAD_OBJECTS);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String storageId = renderRequest.getParameter("userId");
		
		PortletPreferences preferences = renderRequest.getPreferences();
		String currentUrl = PortalUtil.getCurrentURL(httpRequest);
		String screenName = themeDisplay.getUser().getScreenName();
		
		long userId =themeDisplay.getUserId();
		if(storageId != null){
			userId = Long.valueOf(storageId);
		}
		//logger.error("userIdgggg 1 " + userId + "orgFriendlyUrl " + orgFriendlyUrl);
		if (!currentUrl.endsWith(screenName)) {
			userId = SambaashUtil.getUserIdByScreenName(themeDisplay.getCompanyId(), currentUrl);
			//logger.error("userIdgggg 2 screenName " + userId);
		}
		
		if (Validator.isNull(loadObjects)) {
			if (!currentUrl.endsWith(screenName)) {
				userId = SambaashUtil.getUserIdByScreenName(themeDisplay.getCompanyId(), currentUrl);
				//logger.error("userIdgggg 3 screenName " + userId);
			}
			if(userId == 0){
				userId = themeDisplay.getUserId();
			}	
			renderRequest.setAttribute("userId", userId);
			preferences.setValue("userId", String.valueOf(userId));
			preferences.store();
		}
		
		try {
			if (!currentUrl.contains("viewprofile")){
				ClassName cn = ClassNameLocalServiceUtil.getClassName(ProfilePreferences.class.getName());
				renderRequest.setAttribute("SPActivityHub_ClassPK_"+ themeDisplay.getPortletDisplay().getId(), String.valueOf(userId));
				renderRequest.setAttribute("SPActivityHub_ClassName_"+ themeDisplay.getPortletDisplay().getId(), ProfilePreferences.class.getName());
				renderRequest.setAttribute("SPActivityHub_ClassNameId_"+ themeDisplay.getPortletDisplay().getId(), cn.getClassNameId());
				renderRequest.setAttribute("SPActivityHub_DispalyParam_"+ themeDisplay.getPortletDisplay().getId(), "viewprofile");
			}
		} catch (Exception e) {
			logger.error("Error while loading objects" + e.getMessage());
		}
		
		if (Validator.isNotNull(loadObjects)) {
			if(userId == 0 && Validator.isNotNull(preferences.getValue("userId", "0"))){
				userId = Long.parseLong(preferences.getValue("userId", "0"));
			}	
			//logger.error("userIdgggg 4 " + userId);
			if (logger.isDebugEnabled())
				logger.debug("Starting to search");
			try {
				Document documents = search(renderRequest, themeDisplay, false,userId);
				loadObjectsForView(documents, renderRequest, renderResponse);
				if (logger.isDebugEnabled())
					logger.debug("End Search");
				return;
			} catch (Exception e) {
				logger.error("Error while loading objects" + e.getMessage());
			}
		}
		logger.error("userId " + userId);
		super.doView(renderRequest, renderResponse);
	}
	
	private JSONObject getLeadsProduct(String productId, ThemeDisplay themeDisplay, String leadCreateDate, String leadModifiedDate, String stageName, int start, int end, String productName, String processStateId) {
		
		com.liferay.portal.kernel.json.JSONObject productValues = JSONFactoryUtil.createJSONObject();
		List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(start);
		searchContext.setEnd(end);
		Sort sort = SortFactoryUtil.create(Field.CREATE_DATE,
				Sort.LONG_TYPE, true);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);
		searchContext.setCompanyId(themeDisplay.getCompanyId());
		
		BooleanQuery productBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
		productBooleanQuery.addRequiredTerm("productId", productId);
		
		BooleanClause productBooleanClause = BooleanClauseFactoryUtil.create(searchContext,
				productBooleanQuery, BooleanClauseOccur.MUST.getName());
		booleanClauseList.add(productBooleanClause);
		BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
		for (int i = 0; i < booleanClauseList.size(); i++) {
			booleanClauses[i] = booleanClauseList.get(i);
		}
		String applicationUrl = StringPool.BLANK;
		if(Validator.isNotNull(processStateId) && !processStateId.isEmpty()){
			applicationUrl = PEEngineLocalServiceUtil.getApplicationDisplayUrl(themeDisplay.getUser(), Long.parseLong(processStateId), themeDisplay);
		}
		searchContext.setBooleanClauses(booleanClauses);
		Indexer indexer = IndexerRegistryUtil.getIndexer(Product.class.getName());
		
			Hits hits = null;
			try {
				hits = indexer.search(searchContext);
				String imageUrl = "/SPProfile-portlet/images/Minisite-productDefaultImage.png";
				if (hits.getLength() > 0){
					String displayCourseDesc = hits.doc(0).get("courseDescription");
					if(displayCourseDesc.length() > 300){
						displayCourseDesc = displayCourseDesc.substring(0,300) + "...";
					}
					productValues.put("productImageUrl", hits.doc(0).get("imgUrl"));
					productValues.put("productName", hits.doc(0).get("productName"));
					productValues.put("courseName", hits.doc(0).get("courseName"));
					productValues.put("courseDescription", displayCourseDesc);
					productValues.put("leadCreateDate", leadCreateDate);
					productValues.put("leadModifiedDate", leadModifiedDate);
					productValues.put("stageName", stageName);
					productValues.put("applicationUrl", applicationUrl);
				}
				
				if(!productName.isEmpty()){
					productValues.put("productImageUrl",imageUrl);
					productValues.put("productName", productName);
					productValues.put("courseName", StringPool.BLANK);
					productValues.put("courseDescription", StringPool.BLANK);
					productValues.put("leadCreateDate", leadCreateDate);
					productValues.put("leadModifiedDate", leadModifiedDate);
					productValues.put("stageName", stageName);
					productValues.put("applicationUrl", applicationUrl);
				}
			} catch (SearchException e) {
				// TODO Auto-generated catch block
				logger.error("Error while getting product details" + e.getMessage());
			}
			return productValues;
	}

	private List<Document> searchProcess(long userId,ThemeDisplay themeDisplay,ResourceRequest resourceRequest,String spParameter,String stages, int start, int end) {
		// TODO Auto-generated method stub
				List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(start);
		searchContext.setEnd(end);
		Sort sort = SortFactoryUtil.create(Field.CREATE_DATE,
				Sort.LONG_TYPE, true);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);
		searchContext.setCompanyId(themeDisplay.getCompanyId());
		
		//userId = 1254291;
		BooleanQuery processStateBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
		processStateBooleanQuery.addRequiredTerm(PEConstantsGlobal.USER_ID_PROCESS, userId);
		SPParameter leadsIds = null;
		try {
			leadsIds = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
					themeDisplay.getScopeGroupId(), spParameter);
		} catch (NoSuchSPParameterException e) {
			// TODO Auto-generated catch block
			logger.error("Error while getting process flow " + e.getMessage());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			logger.error("Error while getting process flow " + e.getMessage());
		}
		BooleanQuery processLeadBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
		BooleanQuery processStageBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
		if(Validator.isNotNull(leadsIds)){
			String[] leadsIdArray = leadsIds.getValue().split(",");
				try {
					for(String leadsId : leadsIdArray){
						if(Validator.isNotNull(leadsId) && !leadsId.isEmpty()){
							processLeadBooleanQuery.addTerm("processId", Long.parseLong(leadsId));
						}	
					}
					if(!stages.isEmpty()){
						if(!"all".equalsIgnoreCase(stages)){
							if(Validator.isNotNull(stages) && !stages.isEmpty()){
								processStageBooleanQuery.addTerm("stageId", Long.parseLong(stages));
							}	
						BooleanClause processStageBooleanClause = BooleanClauseFactoryUtil.create(searchContext,
								processStageBooleanQuery, BooleanClauseOccur.MUST.getName());
						booleanClauseList.add(processStageBooleanClause);
						}
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					logger.error("Error while getting process flow " + e.getMessage());
				}
			
		}
		
		BooleanClause processStateBooleanClause = BooleanClauseFactoryUtil.create(searchContext,
				processStateBooleanQuery, BooleanClauseOccur.MUST.getName());
		BooleanClause processLeadBooleanClause = BooleanClauseFactoryUtil.create(searchContext,
				processLeadBooleanQuery, BooleanClauseOccur.MUST.getName());
		
		booleanClauseList.add(processStateBooleanClause);
		booleanClauseList.add(processLeadBooleanClause);
		
		BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
		for (int i = 0; i < booleanClauseList.size(); i++) {
			booleanClauses[i] = booleanClauseList.get(i);
		}
		

		searchContext.setBooleanClauses(booleanClauses);
		Indexer indexer = IndexerRegistryUtil.getIndexer("com.sambaash.platform.srv.processbuilder.model.PEProcessState");
		
			Hits hits = null;
			try {
				hits = indexer.search(searchContext);
				if (hits.getLength() < start){
					return null;
				}
			} catch (SearchException e) {
				// TODO Auto-generated catch block
				logger.error("Error while getting process flow  " + e.getMessage());
			}
			return hits.toList();
		
	}

	private Document search(PortletRequest req, ThemeDisplay themeDisp,Boolean returnAllDocs,long userId) throws Exception {
		String indexerClassName = "com.sambaash.platform.srv.spsocialprofile.model.SocialProfile";

		int start = -1;
		int end = -1;
		List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(start);
		searchContext.setUserId(userId);
		searchContext.setEnd(end);
		Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE,
				Sort.LONG_TYPE, true);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);

		searchContext.setCompanyId(themeDisp.getCompanyId());
		BooleanQuery userProfileBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
		userProfileBooleanQuery.addRequiredTerm(Field.USER_ID, userId);
		BooleanClause userProfileBooleanClause = BooleanClauseFactoryUtil.create(searchContext,
				userProfileBooleanQuery, BooleanClauseOccur.MUST.getName());
		booleanClauseList.add(userProfileBooleanClause);
		BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
		for (int i = 0; i < booleanClauseList.size(); i++) {
			booleanClauses[i] = booleanClauseList.get(i);
		}
		logger.error("userProfileBooleanQuery " + userProfileBooleanQuery);
		searchContext.setBooleanClauses(booleanClauses);
		Indexer indexer = IndexerRegistryUtil.getIndexer(indexerClassName);
		
			Hits hits = indexer.search(searchContext);
			logger.error("hits " + hits.getLength());
			if(hits.getLength() > 0){
				return hits.doc(0);
			}else{
				return null;
			}
		
	}
	
	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences preferences = renderRequest.getPreferences();
		
		renderRequest.setAttribute("nav_config", preferences.getValue("nav_config", ""));
		renderRequest.setAttribute("displayStyle", preferences.getValue("displayStyle", ""));
		//logger.debug("pref " + preferences.getValue("nav_config", ""));
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = resourceRequest.getPreferences();
		String action = ParamUtil.getString(resourceRequest, "action");
		String seemore = ParamUtil.getString(resourceRequest, "seemore");
		long userId = Long.parseLong(preferences.getValue("userId","0"));
		int start = 0;
		int end = 3;
		if(Validator.isNotNull(seemore) && !seemore.isEmpty()){
			start = -1;
			end = -1;
		}
		if("work-experience".equalsIgnoreCase(action)){
			try {
				SocialProfile profileUser = SocialProfileLocalServiceUtil.getSocialProfile(userId);
				JSONObject workHistoryDetailsJson = SocialProfileLocalServiceUtil.getUserWorkHistoryDetails(profileUser);
				//logger.debug("workHistoryDetailsJson  " + workHistoryDetailsJson);
				resourceResponse.getWriter().write(workHistoryDetailsJson.toString());
			} catch (PortalException e1) {
				// TODO Auto-generated catch block
				logger.error("Error getting work experience details " + e1.getMessage());
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				logger.error("Error getting work experience details " + e1.getMessage());
			}
		}else if("transaction-history".equalsIgnoreCase(action)){
			try {
				SocialProfile profileUser = SocialProfileLocalServiceUtil.getSocialProfile(userId);
				String transactionHistory = SambaashUtil.getParameter(ProfileConstants.SP_PARAM_TRANSACTION_HISTORY_FORM_DETAILS, 0);
				String[] transactionHistoryArr = transactionHistory.split(",");
				String transactionHistoryFileds = SambaashUtil.getParameter(transactionHistoryArr[2], 0);
				String[] transactionHistoryFiledsArr = transactionHistoryFileds.split(",");
				JSONObject transactionHistoryDetailsJson = SocialProfileLocalServiceUtil.getUserTransactionHistoryDetails(profileUser, transactionHistoryArr[0], transactionHistoryArr[1], transactionHistoryFiledsArr);
				//logger.debug("transactionHistoryDetailsJson  " + transactionHistoryDetailsJson);
				resourceResponse.getWriter().write(transactionHistoryDetailsJson.toString());
			} catch (PortalException e1) {
				// TODO Auto-generated catch block
				logger.error("Error getting work experience details " + e1.getMessage());
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				logger.error("Error getting work experience details " + e1.getMessage());
			}
		}else if("leads".equalsIgnoreCase(action)){
			List<Document> leadsDetailList = searchProcess(userId, themeDisplay, resourceRequest,SambaashConstants.PROCESS_ID_LEAD,"",start,end);
			//logger.debug("productDetail leads " + leadsDetailList.toString());
			com.liferay.portal.kernel.json.JSONObject productLeadsJSON = JSONFactoryUtil.createJSONObject();
			int i=10;
			String productName = StringPool.BLANK;
			for(Document leadsDetail : leadsDetailList){
				String productId = leadsDetail.get("entityId");
				String processStateId = leadsDetail.get("processStateId");
				try{
					String entityClassId = leadsDetail.get("entityClassId");
					long classNameId = PortalUtil.getClassNameId(PEDummyEntity.class.getName());
					if(entityClassId.equalsIgnoreCase(String.valueOf(classNameId))){
						PEDummyEntity dummyEntity = PEDummyEntityLocalServiceUtil.getPEDummyEntity(Long.parseLong(productId));
						productName = dummyEntity.getName();
					}
				}catch(Exception e){
					logger.error(e.getMessage());
				}
				String leadCreateDate = leadsDetail.get("createDate_sortable");
				String leadModifiedDate = leadsDetail.get("modified_sortable");
				SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
				if(Validator.isNotNull(leadCreateDate) && !leadCreateDate.isEmpty()){
					Date date = new Date(Long.parseLong(leadCreateDate));
					String createdateText = format.format(date);
					leadCreateDate = "Created on " + createdateText;
				}	
				if(Validator.isNotNull(leadModifiedDate) && !leadModifiedDate.isEmpty()){
					Date date1 = new Date(Long.parseLong(leadModifiedDate));
			        String modifieddateText = format.format(date1);
					leadModifiedDate = "Last Updated on " + modifieddateText;
				}	
				JSONObject leadsJson = getLeadsProduct(productId,themeDisplay,leadCreateDate,leadModifiedDate,"",start,end,productName,processStateId);
				productLeadsJSON.put(String.valueOf(i), leadsJson);
				i = i + 1;
			}
			productLeadsJSON.put("TotalCount0", leadsDetailList.size());
			resourceResponse.getWriter().write(productLeadsJSON.toString());
			//logger.debug("productLeadsJSON " + productLeadsJSON);
		}else if(action.contains("opportunities")){
			String stages = ParamUtil.getString(resourceRequest, "stages");
			List<Document> processDetailList = searchProcess(userId, themeDisplay, resourceRequest,SambaashConstants.PROCESS_ID_OPPORTUNITY,stages,start,end);
			logger.debug("productDetail opportunities " + processDetailList.toString());
			com.liferay.portal.kernel.json.JSONObject productLeadsJSON = JSONFactoryUtil.createJSONObject();
			int i=10;
			com.liferay.portal.kernel.json.JSONObject stageCountJSON = JSONFactoryUtil.createJSONObject();
			com.liferay.portal.kernel.json.JSONObject stageIdJSON = JSONFactoryUtil.createJSONObject();
			try {
				List<PEProcessStage> stagesList = PEProcessStageLocalServiceUtil.getPEProcessStages(-1, -1);
				for(PEProcessStage stagesVal : stagesList){
					List<PEProcessState> stage = PEProcessStateLocalServiceUtil.findByuserIdProcessPEProcessStageId(userId, stagesVal.getSpPEProcessStageId());
					int count = stage.size();
					String stageName = stagesVal.getName();
					stageCountJSON.put(stageName, String.valueOf(count));
					stageIdJSON.put(stageName, String.valueOf(stagesVal.getSpPEProcessStageId()));
				}
				productLeadsJSON.put("Stage0", stageCountJSON);
				productLeadsJSON.put("Stage1", stageIdJSON);
				//logger.debug("productLeadsJSON " + productLeadsJSON);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				logger.error("Error while ghetting process opportunity details" + e.getMessage());
			}
			for(Document processDetail : processDetailList){
				String productId = processDetail.get("entityId");
				String productName = StringPool.BLANK;
				String processStateId = processDetail.get("processStateId");
				try{
					String entityClassId = processDetail.get("entityClassId");
					long classNameId = PortalUtil.getClassNameId(PEDummyEntity.class.getName());
					if(entityClassId.equalsIgnoreCase(String.valueOf(classNameId))){
						PEDummyEntity dummyEntity = PEDummyEntityLocalServiceUtil.getPEDummyEntity(Long.parseLong(productId));
						productName = dummyEntity.getName();
					}
				}catch(Exception e){
					logger.error(e.getMessage());
				}
				String leadCreateDate = processDetail.get("createDate_sortable");
				String leadModifiedDate = processDetail.get("modified_sortable");
				SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
				if(Validator.isNotNull(leadCreateDate) && !leadCreateDate.isEmpty()){
					Date date = new Date(Long.parseLong(leadCreateDate));
					 String createdateText = format.format(date);
					 leadCreateDate = "Created on " + createdateText;
				}	
				if(Validator.isNotNull(leadModifiedDate) && !leadModifiedDate.isEmpty()){
					Date date1 = new Date(Long.parseLong(leadModifiedDate));
			        String modifieddateText = format.format(date1);
					leadModifiedDate = "Last Updated on " + modifieddateText;
				}	
				String stageName = processDetail.get("stageName");
				JSONObject leadsJson = getLeadsProduct(productId,themeDisplay,leadCreateDate,leadModifiedDate,stageName,start,end,productName,processStateId);
				productLeadsJSON.put(String.valueOf(i), leadsJson);
				i = i + 1;
			}
			productLeadsJSON.put("TotalCount0", processDetailList.size());
			resourceResponse.getWriter().write(productLeadsJSON.toString());
			logger.debug("productLeadsJSON " + productLeadsJSON);
		}else if(action.contains("current-learner")){
			JSONObject currentLearnerJson = getLearnerProductList(userId,themeDisplay,"Learner",seemore);
			if(currentLearnerJson.length() == 0){
				currentLearnerJson.put("noresult", "noresult");
			}
			//logger.debug("productLeadsJSON " + currentLearnerJson);
			resourceResponse.getWriter().write(currentLearnerJson.toString());
		}else if(action.contains("alumni")){
			JSONObject alumniJson = getLearnerProductList(userId,themeDisplay,"Alumni",seemore);
			if(alumniJson.length() == 0){
				alumniJson.put("noresult", "noresult");
			}
			resourceResponse.getWriter().write(alumniJson.toString());
			//logger.debug("productLeadsJSON alumniJson " + alumniJson);
		}else if(action.equalsIgnoreCase("campaigns")){
			JSONObject campaignJson = getCampaignList(userId,themeDisplay,seemore);
			if(campaignJson.length() <= 3){
				campaignJson.put("noresult", "noresult");
			}
			resourceResponse.getWriter().write(campaignJson.toString());
			logger.debug("productLeadsJSON campaignJson " + campaignJson);
		}
		else if("documents".equalsIgnoreCase(action)){
			
			String response = SystemLocalServiceUtil.fetchRecord(resourceRequest, resourceResponse);
			JSONObject documents = JSONFactoryUtil.createJSONObject();
			try {
				documents = JSONFactoryUtil.createJSONObject(response);
			} catch (JSONException e) {
			}
			
			resourceResponse.getWriter().write(documents.toString());
			
		}
		else if("sponsor-details".equalsIgnoreCase(action) || "profile-info".equalsIgnoreCase(action) || "personal-info".equalsIgnoreCase(action) ){
			
			String response = SystemLocalServiceUtil.fetchRecord(resourceRequest, resourceResponse);
			JSONObject responseJson = JSONFactoryUtil.createJSONObject();
			JSONObject contentJson = JSONFactoryUtil.createJSONObject();
			try {
				responseJson = JSONFactoryUtil.createJSONObject(response);
				contentJson.put("contentJson", responseJson);
			} catch (JSONException e) {
				logger.error("Error while getting sponsor details" + e.getMessage());
			}
			
			resourceResponse.getWriter().write(contentJson.toString());
		
		}
		else if("bank-details".equalsIgnoreCase(action)){
			
			String response = SystemLocalServiceUtil.fetchRecord(resourceRequest, resourceResponse);
			JSONObject responseJson = JSONFactoryUtil.createJSONObject();
			JSONObject contentJson = JSONFactoryUtil.createJSONObject();
			try {
				responseJson = JSONFactoryUtil.createJSONObject(response);
				contentJson.put("contentJson", responseJson);
			} catch (JSONException e) {
				logger.error("Error while getting sponsor details" + e.getMessage());
			}
			
			resourceResponse.getWriter().write(contentJson.toString());
		
		}
		else if("invigilation-experience".equalsIgnoreCase(action)){
			
			String response = SystemLocalServiceUtil.fetchRecord(resourceRequest, resourceResponse);
			JSONObject responseJson = JSONFactoryUtil.createJSONObject();
			JSONObject contentJson = JSONFactoryUtil.createJSONObject();
			JSONArray invigilationExperienceList = JSONFactoryUtil.createJSONArray();
			try {
				responseJson = JSONFactoryUtil.createJSONObject(response);
				contentJson = responseJson;
				responseJson = JSONFactoryUtil.createJSONObject();
				invigilationExperienceList = contentJson.getJSONArray("InvigilationExperienceList");
				for(int i = 0; i < invigilationExperienceList.length(); i++){
					String strDateFormat = "yyyy-MM-dd'T'HH:mm:ss";  //2018-11-15T12:00:00+05:30
		            DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		            Date dateFrom = null;Date dateTo = null;
					try {
						dateFrom = dateFormat.parse(invigilationExperienceList.getJSONObject(i).getString("From"));
						dateTo = dateFormat.parse(invigilationExperienceList.getJSONObject(i).getString("To"));
					} catch (java.text.ParseException e) {
						logger.error("Error while getting sponsor details" + e.getMessage());
					}
					DateFormat requiredDateFormat = new SimpleDateFormat("MM/yyyy");
		            String fromDate= requiredDateFormat.format(dateFrom);
		            String toDate= requiredDateFormat.format(dateTo);
					invigilationExperienceList.getJSONObject(i).put("fromDate", fromDate);
					invigilationExperienceList.getJSONObject(i).put("toDate", toDate);
				}
				responseJson.put("contentJson", invigilationExperienceList);
				contentJson = JSONFactoryUtil.createJSONObject();
				contentJson.put("contentJson", responseJson);
			} catch (JSONException e) {
				logger.error("Error while getting sponsor details" + e.getMessage());
			}
			
			resourceResponse.getWriter().write(responseJson.toString());
		
		}
		
		if ("getTemplate".equals(action)) {
			String filterValue = ParamUtil.getString(resourceRequest, "filterValue");
			JSONObject lstObject = JSONFactoryUtil.createJSONObject();
			try {
				JSONObject spMailCampaignObject = JSONFactoryUtil.createJSONObject();
				spMailCampaignObject.put("subject",
						SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long.parseLong(filterValue)).getSubject());
				spMailCampaignObject.put("htmlContent",
						SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long.parseLong(filterValue)).getHtmlContent());
				spMailCampaignObject.put("textContent",
						SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long.parseLong(filterValue)).getTextContent());
				lstObject.put(filterValue, spMailCampaignObject);
				resourceResponse.getWriter().append(lstObject.toString());
			} catch (Exception e) {
				logger.error(e);
			}

		}
	}
	
	private JSONObject getCampaignList(long userId, ThemeDisplay themeDisplay, String seemore) {
		com.liferay.portal.kernel.json.JSONObject campaignValuesJson = JSONFactoryUtil.createJSONObject();
		try {
			//logger.debug("userId in campaigns " + userId);
			List<SPMailCampaignSubscribers> mailCampaignSubscribersList = SPMailCampaignSubscribersLocalServiceUtil.findByUserId(userId);
			
			int openedCount = SPMailCampaignSubscribersLocalServiceUtil.countByUserIdAndOpened(userId, true);
			int i = 10;
			int totalInteractionCount = 0;
			int interactionCount = 0;
			long edmTemplateId  = 0;
			int displayCnt = 3;
			int cnt = 1;
			if(Validator.isNotNull(seemore) && !seemore.isEmpty()){
				displayCnt = mailCampaignSubscribersList.size();
			}
			for(SPMailCampaignSubscribers mailCampaignSubscribers : mailCampaignSubscribersList){
				try {
						SPMailCampaignEDM mailCampaignEDM = SPMailCampaignEDMLocalServiceUtil.findByCampaignIdMailType(mailCampaignSubscribers.getSpMailCampaignId(),mailCampaignSubscribers.getSpMailType());
						interactionCount = 0;
						com.liferay.portal.kernel.json.JSONObject campaignValues = JSONFactoryUtil.createJSONObject();
						long campaignId = mailCampaignSubscribers.getSpMailCampaignId();
						SPMailCampaign mailCampaign = SPMailCampaignLocalServiceUtil.getCampaign(campaignId);
						//logger.debug("userId in campaigns date " + mailCampaign.getMainScheduledDate());
						edmTemplateId = mailCampaignEDM.getSpMailTemplateId();
						List<Object[]> linkList = SPMailLinkTrackingLocalServiceUtil.getMailLinkInteractionCount(campaignId,mailCampaignSubscribers.getSpMailCampaignSubscribersId());
						for (Object[] obj : linkList) {
							boolean isOpened = (Boolean)obj[2];
							if (isOpened) {
								totalInteractionCount = totalInteractionCount + 1;
								interactionCount = interactionCount + 1;
								logger.debug("opened " + totalInteractionCount);
							} 
						}
						SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
						SimpleDateFormat format2 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
						String outputDate = mailCampaignEDM.getNextScheduleDateTime().toString();
						logger.error("outputDate " + mailCampaignEDM.getCreateDate());
						if(cnt <= displayCnt){
							campaignValues.put("campaignName", mailCampaignEDM.getName());
							campaignValues.put("edmTemplateId",edmTemplateId);
							if(mailCampaignSubscribers.getOpened()){
								campaignValues.put("campaignMailOpened", "1");
							}else{
								campaignValues.put("campaignMailOpened", "0");
							}
							try {
								Date date = mailCampaignEDM.getCreateDate();
								if(date.toString().contains("SGT")){
									date = format2.parse(date.toString());
								}else{
									date = format1.parse(date.toString());
								}	

								// Format date into output format
								SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
								outputDate = format.format(date);
							} catch (java.text.ParseException e) {
								// TODO Auto-generated catch block
								logger.error(e.getMessage());
							}
							campaignValues.put("campaignMailDate", outputDate);
							campaignValues.put("interactionCount", interactionCount);
							campaignValuesJson.put("CampaignValues"+i, campaignValues);
						}	
						
						i=i+1;
				} catch (NoSuchCampaignEDMException e) {
					// TODO Auto-generated catch block
					logger.error(e.getMessage());
				}	
				cnt = cnt + 1;
			}
			if(mailCampaignSubscribersList.isEmpty()){
				campaignValuesJson.put("linkInteractionCount", totalInteractionCount);
			}
			campaignValuesJson.put("linkInteractionCount", totalInteractionCount);
			campaignValuesJson.put("OpenedMailCount", openedCount);
			campaignValuesJson.put("TotalCount", mailCampaignSubscribersList.size());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			logger.error("Error while campaign list " + e.getMessage());
		} catch (NoSuchCampaignSubscribersException e) {
			// TODO Auto-generated catch block
			logger.error("Error while campaign list " + e.getMessage());
		}
		
		return campaignValuesJson;
	}

	private JSONObject getLearnerProductList(long userId, ThemeDisplay themeDisplay,String userType, String seemore) {
		com.liferay.portal.kernel.json.JSONObject currentLearnerProductJSON = JSONFactoryUtil.createJSONObject();
		
				int start = -1;
				int end = -1;
				List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
				SearchContext searchContext = new SearchContext();
				searchContext.setStart(start);
				searchContext.setEnd(end);
				Sort sort1 = SortFactoryUtil.create(Field.CREATE_DATE,
						Sort.LONG_TYPE, true);
				Sort[] sorts1 = new Sort[] { sort1 };
				searchContext.setSorts(sorts1);
				searchContext.setCompanyId(themeDisplay.getCompanyId());
				
				String userTypeFieldName = "userType";
				String productFieldName = "productName";
				String startDateFieldName = "startDate";
				String endDateFieldName = "endDate";
				try {
					String config = SambaashUtil.getParameter(SambaashConstants.SOCIAL_PROFILE_INDEXER_EXTRA_INFO_CONFIG, 0);
					JSONObject configJ = JSONFactoryUtil.createJSONObject(config);
					JSONObject userTypeConfigJ = JSONFactoryUtil.createJSONObject(configJ.getString("userType"));
					userTypeFieldName = userTypeConfigJ.getString("fieldName");
					
					JSONObject productNameConfigJ = JSONFactoryUtil.createJSONObject(configJ.getString("courseName"));
					productFieldName = productNameConfigJ.getString("fieldName");
					
					JSONObject startDateConfigJ = JSONFactoryUtil.createJSONObject(configJ.getString("courseStartDate"));
					startDateFieldName = startDateConfigJ.getString("fieldName");
					
					JSONObject endDateConfigJ = JSONFactoryUtil.createJSONObject(configJ.getString("courseEndDate"));
					endDateFieldName = endDateConfigJ.getString("fieldName");
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					logger.error(e1.getMessage());
				}
				
				BooleanQuery userProfileBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
				userProfileBooleanQuery.addRequiredTerm(Field.USER_ID, userId);
				
				BooleanClause userProfileBooleanClause = BooleanClauseFactoryUtil.create(searchContext,
						userProfileBooleanQuery, BooleanClauseOccur.MUST.getName());
				booleanClauseList.add(userProfileBooleanClause);
				BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
				for (int i = 0; i < booleanClauseList.size(); i++) {
					booleanClauses[i] = booleanClauseList.get(i);
				}
				
				String productIds = StringPool.BLANK;
				String userTypeIds = StringPool.BLANK;
				String courseStartDate = StringPool.BLANK;
				String courseEndDate = StringPool.BLANK;
				searchContext.setBooleanClauses(booleanClauses);
				Indexer indexer= IndexerRegistryUtil.getIndexer("com.sambaash.platform.srv.spsocialprofile.model.SocialProfile");
				
					Hits hits = null;
					try {
						hits = indexer.search(searchContext);
						if (hits.getLength() > 0){
							userTypeIds = hits.doc(0).get(userTypeFieldName);
							productIds = hits.doc(0).get(productFieldName);
							courseStartDate = hits.doc(0).get(startDateFieldName);
							courseEndDate = hits.doc(0).get(endDateFieldName);
							int totalCount = StringUtil.count(userTypeIds.toLowerCase(), userType.toLowerCase());
							SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
							SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
							String[] userTypeIdsArray = userTypeIds.split(StringPool.EXCLAMATION+StringPool.AMPERSAND);
							String[] ProductIdsArray = productIds.split(StringPool.EXCLAMATION+StringPool.AMPERSAND);
							String[] courseStartDateArray = courseStartDate.split(StringPool.EXCLAMATION+StringPool.AMPERSAND);
							String[] courseEndDateArray = courseEndDate.split(StringPool.EXCLAMATION+StringPool.AMPERSAND);
							int displayCount = 3;
							if(displayCount > userTypeIdsArray.length){
								displayCount = userTypeIdsArray.length;
							}
							if(Validator.isNotNull(seemore) && !seemore.isEmpty()){
								displayCount = userTypeIdsArray.length;
							}
							int dcnt = 1;
							if(ProductIdsArray.length != 0){
								for(int n=0; n<=userTypeIdsArray.length-1;n++){
									if(dcnt <= displayCount){
										if(userTypeIdsArray[n].equalsIgnoreCase(userType)){
											com.liferay.portal.kernel.json.JSONObject productJson = JSONFactoryUtil.createJSONObject();
											productJson.put("courseName", ProductIdsArray[n]);
											if(Validator.isNotNull(courseStartDateArray[n]) && !courseStartDateArray[n].isEmpty()){
												try {
													Date date = format1.parse(courseStartDateArray[n]);
													courseStartDate = format.format(date);
												} catch (java.text.ParseException e) {
													courseStartDate = courseStartDateArray[n];
													logger.error(e.getMessage());
												}
											}	
											if(Validator.isNotNull(courseEndDateArray[n]) && !courseEndDateArray[n].isEmpty()){
												try {
													Date date1 = format1.parse(courseEndDateArray[n]);
													courseEndDate = format.format(date1);
												} catch (java.text.ParseException e) {
													courseEndDate = courseEndDateArray[n];
													logger.error(e.getMessage());
												}
											}	
											productJson.put("courseStartDate", courseStartDate);
											productJson.put("courseEndDate", courseEndDate);
											currentLearnerProductJSON.put("CurrentLearner"+n, productJson);
											currentLearnerProductJSON.put("TotalCount", totalCount);
											dcnt=dcnt+1;
										}	
									}	
								}
							}	
						}
					} catch (SearchException e) {
						// TODO Auto-generated catch block
						logger.error("Error while learner product list " + e.getMessage());
					}
			return currentLearnerProductJSON;
		
	}

	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		PortletPreferences preferences = actionRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String navConfig = ParamUtil.getString(actionRequest, "nav_config", "");
		//String displayStyle = ParamUtil.getString(actionRequest, "_SPProfile_WAR_SPProfileportlet_displayStyle", "");
		String displayStyle = actionRequest.getParameter("displayStyle");
		//logger.debug("displayStyle " + displayStyle);
		preferences.setValue("nav_config", navConfig);
		preferences.setValue("displayStyle", displayStyle);
		preferences.store();
		long preferenceId = 0;
		ProfilePreferences profilePreference = null;
		try {
			List<ProfilePreferences> profilePreferenceList = ProfilePreferencesLocalServiceUtil.findBylayOutIdAndPortletId(String.valueOf(themeDisplay.getLayout().getLayoutId()), PORTLET_ID);
			if(Validator.isNotNull(profilePreferenceList) && !profilePreferenceList.isEmpty()){
				for(ProfilePreferences profilePref : profilePreferenceList){
					preferenceId = profilePref.getProferenceId();
					profilePreference = ProfilePreferencesLocalServiceUtil.deleteProfilePreferences(preferenceId);
				}
			}
			
			preferenceId = CounterLocalServiceUtil.increment("ProfilePrefernces.class");
			profilePreference = ProfilePreferencesLocalServiceUtil.createProfilePreferences(preferenceId);
			profilePreference.setCreateDate(new Date());
			profilePreference.setModifiedDate(new Date());
			profilePreference.setLayoutId(String.valueOf(themeDisplay.getLayout().getLayoutId()));
			profilePreference.setPortletId(PORTLET_ID);
			profilePreference.setPreferenceName("displayStyle");
			profilePreference.setPortletPreferences(displayStyle);
			profilePreference.setPreferenceName("nav_config");
			profilePreference.setPortletPreferences(navConfig);
			ProfilePreferencesLocalServiceUtil.updateProfilePreferences(profilePreference);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			logger.error("Error while saving preferences" + e.getMessage());
		} catch (NoSuchProfilePreferencesException e) {
			// TODO Auto-generated catch block
			logger.error("Error while saving preferences" + e.getMessage());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			logger.error("Error while saving preferences" + e.getMessage());
		}
		
		actionResponse.setPortletMode(PortletMode.VIEW);
		
		super.processAction(actionRequest, actionResponse);
	}
	
	private void loadObjectsForView(Document document, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		if (Validator.isNull(document)) {
			renderResponse.getWriter().write("<div id='generic-search-no-more-results'>No profile information found for this user</div>");
			logger.error("document " + document);
			return;
		}
		PortletPreferences preferences = renderRequest.getPreferences();

		String key = StringPool.BLANK;
			try {
				
				
				key = "displayStyle--" + document.get(Field.ENTRY_CLASS_NAME);
				logger.debug("key " + key);
				Long selectedTemplateId = GetterUtil.getLong(preferences.getValue("displayStyle", null));
				// check if exists
				DDMTemplateLocalServiceUtil.getTemplate(selectedTemplateId);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("document", document);
				//map.put("userId", userId);
				logger.debug("document " + document);
				logger.debug("document " + document.get("location"));
				
				renderRequest.setAttribute(Field.ENTRY_CLASS_NAME, document.get(Field.ENTRY_CLASS_NAME));
				renderRequest.setAttribute(ProfileConstants.ATTRIB_RESULT_TEMPLATE_ID, selectedTemplateId);
				renderRequest.setAttribute(ProfileConstants.ATTRIB_RESULT_LIST, new ArrayList());
				renderRequest.setAttribute(ProfileConstants.ATTRIB_RESULT_MAP, map);
				include("/html/profile/view-single-result.jsp", renderRequest, renderResponse);
			} catch (NoSuchTemplateException e) {
				logger.error("Missing/Invalid template selected for " + document.get(Field.ENTRY_CLASS_NAME));
			} catch (Exception e) {
				logger.error("Error while converting to templates", e);
			}
	}
	
}
