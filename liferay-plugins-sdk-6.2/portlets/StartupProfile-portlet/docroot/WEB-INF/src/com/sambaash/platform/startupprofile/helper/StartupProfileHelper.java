package com.sambaash.platform.startupprofile.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.sambaash.platform.model.ProfileType;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.startupprofile.StartupConstants;
import com.sambaash.platform.util.FormHelper;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.wrapper.HttpServletRequestWrapperExtended;
public class StartupProfileHelper {

	private static Log logger = LogFactoryUtil.getLog(StartupProfileHelper.class);

	public long persistStartupData(ResourceRequest resourceRequest, String orgId) {

		try {
			Map<String, Object> existingMap = null;
			if (Validator.isNotNull(orgId) && !Long.valueOf(orgId).equals(-1L))
				existingMap = OrganizationLocalServiceUtil.createOrgDataMap(Long.valueOf(orgId));
			logger.debug("persistStartupData - Existing information for org = " + orgId + " --> " + existingMap);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Map<String, String> requestParams = FormHelper.getRequestParamMap(resourceRequest,
					themeDisplay);
			logger.debug("persistStartupData - Information from user org = " + orgId + " --> " + requestParams);
			Organization organization = OrganizationLocalServiceUtil.persistData(requestParams, existingMap,
					String.valueOf(SambaashUtil.getProductId(PortalUtil.getHttpServletRequest(resourceRequest))),
					String.valueOf(SambaashUtil.getSubProductId(PortalUtil.getHttpServletRequest(resourceRequest))),
					String.valueOf(SambaashUtil.getVirtualHostId(PortalUtil.getHttpServletRequest(resourceRequest))));
			logger.debug("persistStartupData - Organization persisted successfully");
			try{
				Set<Entry<String, String>> entrySet = requestParams.entrySet();
				List<Long> entries = new ArrayList<Long>();
				for (Entry<String, String> entry : entrySet) {
					if(entry.getKey().startsWith("asset_") && !entry.getValue().equals(StringPool.BLANK)) {
						entries.add(Long.valueOf(entry.getValue()));
					}
				}
				// projects
				String orgBrandListJsonStr = ParamUtil.getString(resourceRequest,"orgBrandList");
				JSONArray orgBrandJsonArr = JSONFactoryUtil.createJSONArray(orgBrandListJsonStr);
				if (orgBrandJsonArr.length() > 0) {
					String orgProjectListsonStr = ParamUtil.getString(resourceRequest,"orgProjectList");
					JSONArray orgProjectJsonArr = JSONFactoryUtil.createJSONArray(orgProjectListsonStr);
					JSONArray projectsWorkedOnArr = JSONFactoryUtil.createJSONArray();
					for(int i=0; i<orgBrandJsonArr.length(); i++) {
						JSONObject projectWorkedOn = JSONFactoryUtil.createJSONObject();
						String brandCategoryId = orgBrandJsonArr.getString(i);
						String projectCategoryName = orgProjectJsonArr.getString(i);
						if (StringUtils.isEmpty(brandCategoryId) || StringUtils.isEmpty(projectCategoryName)) {
							continue;	// both entry must not be null to be persisted
						}
						entries.add(Long.valueOf(brandCategoryId));
						AssetCategory projectCategory = getProjectCategoryOrCreateIfNotExist(resourceRequest, projectCategoryName);
						entries.add(projectCategory.getCategoryId());
						projectWorkedOn.put("brand", brandCategoryId);
						projectWorkedOn.put("project", projectCategory.getCategoryId());
						projectsWorkedOnArr.put(projectWorkedOn);
					}
					organization.setProjectsWorkedOn(projectsWorkedOnArr.toString());
				} else {
					organization.setProjectsWorkedOn(null);
				}
				
				// tags	
				persistStartupTags(resourceRequest, entries);

				if(entries.size() > 0) {
					long[] assetEntries = ArrayUtils.toPrimitive(entries.toArray(new Long[entries.size()]));
					OrganizationLocalServiceUtil.updateAssets(themeDisplay.getUserId(), organization, assetEntries);
				}
			
			} catch(Exception e){
				logger.error("Error while saving assets" + e.getMessage() , e);
			}
			//logo update
			try{
				// Move files from temp folder to actual folder
				FileEntry fe = SPStartupDLHelper.updateOrMoveFolders(
						resourceRequest, String.valueOf(organization.getOrganizationId()),
						StartupConstants.FOLDERTYPE_LOGO,
						StartupConstants.FOLDERTYPE_COVER,
						StartupConstants.FOLDERTYPE_OTHERS);
				if (Validator.isNotNull(fe)) {
					organization.setLogoId(fe.getFileEntryId());
					OrganizationLocalServiceUtil.updateOrganization(organization);
				}
			} catch (Exception e) {
				logger.error("Error while uploading logo" + e.getMessage(), e);
			}
			// video links
			String videoLinkArrJsonStr = ParamUtil.getString(resourceRequest,"orgVideoLinkList");
			organization.setVideoLinks(videoLinkArrJsonStr);	
			
			// update contact name
			updateOrganizationContactName(resourceRequest, organization);
			
			if ("+".equals(organization.getMobile().trim())) {
				organization.setMobile(StringPool.BLANK);
			}

			OrganizationLocalServiceUtil.updateOrganization(organization);
						
			// Reindex must be called  at this point since all the organization data saved by this point. 
			OrganizationLocalServiceUtil.reIndex(organization);
			return organization.getOrganizationId();
		} catch (Exception e) {
			logger.error("Error persisting data", e);
			return -1l;
		}
	}


	private void updateOrganizationContactName(ResourceRequest resourceRequest,
			Organization organization) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		String contactFirstName = ParamUtil.getString(resourceRequest,"organization_fname");
		String contactLastName = ParamUtil.getString(resourceRequest,"organization_lname");
		if(!contactFirstName.equalsIgnoreCase(StringPool.BLANK)  && !contactLastName.equalsIgnoreCase(StringPool.BLANK)){
			User startupUser = UserLocalServiceUtil.getUser(organization.getUserId());
			startupUser.setFirstName(contactFirstName);
			startupUser.setLastName(contactLastName);
			UserLocalServiceUtil.updateUser(startupUser);
			organization.setUserName(startupUser.getFullName());
		}
	}


	public void persistStartupTags(ResourceRequest resourceRequest,
			List<Long> entries) {
		String tagIds = ParamUtil.getString(resourceRequest,"startupTag_tagIdList");
		if (StringUtils.isNotEmpty(tagIds)) {
			String[] tagIdArr = tagIds.split(",");
			for (int i=0; i < tagIdArr.length; i++) {
				if (StringUtils.isNumeric(tagIdArr[i])) {
					entries.add(Long.valueOf(tagIdArr[i]));
				} else { // new tag
					String key = String.format("startupTag%d_tagName", i+1);
					AssetCategory tagCategory = getTagCategoryOrCreateIfNotExist(resourceRequest, ParamUtil.getString(resourceRequest,key));
					entries.add(tagCategory.getCategoryId());
				}
			}
		}
	}

	
	private AssetCategory getProjectCategoryOrCreateIfNotExist(ResourceRequest resourceRequest, String projectCategoryName) {
		long orgProjectsVocId = GetterUtil.getLong(resourceRequest.getPreferences().getValue(
				StartupConstants.VOC_ORG_PROJECTS_ID, "0"));
		return getAssetCategoryOrCreateIfNotExist(resourceRequest, orgProjectsVocId, projectCategoryName);
	}

	private AssetCategory getTagCategoryOrCreateIfNotExist(ResourceRequest resourceRequest, String tagCategoryName) {
		long orgTagsVocId = GetterUtil.getLong(resourceRequest.getPreferences().getValue(
				StartupConstants.VOC_ORG_TAGS_ID, "0"));
		return getAssetCategoryOrCreateIfNotExist(resourceRequest, orgTagsVocId, tagCategoryName);
	}

	private AssetCategory getAssetCategoryOrCreateIfNotExist(ResourceRequest resourceRequest, long vocabularyId, String categoryName) {
		AssetCategory category = getAssetCategoryByName(vocabularyId, categoryName);
		try {
			if (category == null) {	// new category to be added
				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				ServiceContext serviceContext = ServiceContextFactory.getInstance(AssetCategory.class.getName(), resourceRequest);
				Map<Locale,String> titleMap = new HashMap<Locale, String>();
				titleMap.put(Locale.getDefault(), categoryName);
				category = AssetCategoryLocalServiceUtil.addCategory(themeDisplay.getUserId(), 
						0, titleMap, new HashMap<Locale,String>(), vocabularyId, new String[]{}, serviceContext);			
			}
		} catch (Exception e) {
			logger.debug("Error adding new asset category for vocabulary id : "+vocabularyId, e);
		}
		return category;
	}
	
	@SuppressWarnings("unchecked")
	public static AssetCategory getAssetCategoryByName(long vocabularyId, String categoryName) {
		AssetCategory category = null;
		try {
			DynamicQuery getProjectsQuery = DynamicQueryFactoryUtil.forClass(AssetCategory.class,PortletClassLoaderUtil.getClassLoader())
	        		.add(RestrictionsFactoryUtil.eq("vocabularyId", vocabularyId))
	        		.add(RestrictionsFactoryUtil.eq("name", categoryName));
	        List<AssetCategory> orgProjectList = AssetCategoryLocalServiceUtil.dynamicQuery(getProjectsQuery, -1, -1);			
			if (orgProjectList.size()>0) {
				category = orgProjectList.get(0);
			}
		} catch (Exception e) {
			// do nothing
		}
		return category;
	}
	
	public static boolean deleteStartup(PortletRequest request,Organization org){
		if(Validator.isNotNull(org)){
			return deleteStartup(request, org.getOrganizationId());
		}
		return false;
	}
	public static boolean deleteStartup(PortletRequest request,long orgId){
		boolean status = false;
		if(StartupPermissionHelper.canDeleteStartup(request, orgId)){
			try {
				Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
				//User Id of Startup creater
				long userId = org.getUserId();
				org.setActive(false);
				org.setModifiedDate(new Date());
				OrganizationLocalServiceUtil.updateOrganization(org);
				status = true;
				
				try{
					if (OrganizationLocalServiceUtil.getUserOrganizations(userId).size() == 0) {
						ServiceContext serviceContext = ServiceContextFactory
								.getInstance(Organization.class.getName(),
										request);
						SocialProfileLocalServiceUtil.updateProfileType(
								UserLocalServiceUtil.getUser(userId), ProfileType.USER,
								serviceContext);
					}
				}catch (Exception e){}
			} catch (Exception e) {
				logger.error("error deleting organization" , e);
				status = false;
			}
		}
			
		return status;
	}
	
	public static void readOrgData(String orgId,PortletRequest request) {
		if (Validator.isNotNull(orgId)) {
			try {
				long organizationId = GetterUtil.getLong(orgId);
				StartupFormHelper helper = new StartupFormHelper();
				helper.addOrgDataToRequest(request, organizationId);
			}catch (Exception e) {
				logger.error("Error while fetching data for orgId" + orgId, e);
			}
		}
	}
	
	
	public static String displayStartupDetailsFriendlyURL(ThemeDisplay themeDisplay,long orgId) {
		
		if (themeDisplay.isSignedIn()) {
			return String.format("%s/-/manage-profile/view/%s",
					getStartupDisplayPath(themeDisplay.getScopeGroupId()),orgId);
		} else {

			String loginUrl = SambaashUtil.getSignInURL(
					themeDisplay.getScopeGroupId(), themeDisplay, true);
			return String.format(
					"%s%sredirect=%s/-/manage-profile/view/%s", loginUrl,
					loginUrl.contains("?") ? "&" : "?", getStartupDisplayPath(themeDisplay.getScopeGroupId()),orgId);
		}
	}
	
	public static String displayStartupApplicationsFriendlyURL(ThemeDisplay themeDisplay,long orgId) {
		
		if (themeDisplay.isSignedIn()) {
			return String.format("%s/-/manage-profile/applications/%s",
					getStartupDisplayPath(themeDisplay.getScopeGroupId()),orgId);
		} else {

			String loginUrl = SambaashUtil.getSignInURL(
					themeDisplay.getScopeGroupId(), themeDisplay, true);
			return String.format(
					"%s%sredirect=%s/-/manage-profile/applications/%s", loginUrl,
					loginUrl.contains("?") ? "&" : "?", getStartupDisplayPath(themeDisplay.getScopeGroupId()),orgId);
		}
	}
	
	public static String displayStartupDetailsFriendlyURL(long scopeGroupId) {
		String format = "%s/-/manage-profile/view/";
		return String.format(format, getStartupDisplayPath(scopeGroupId));
	}
	
	public static String displayStartupApplicationsFriendlyURL(long scopeGroupId) {
		String format = "%s/-/manage-profile/applications/";
		return String.format(format, getStartupDisplayPath(scopeGroupId));
	}
	
	public static String createStartupFriendlyURL(ThemeDisplay themeDisplay) {
		if (themeDisplay.isSignedIn()) {
			return String.format("%s/-/manage-profile/create",
					getStartupCreatePath(themeDisplay.getScopeGroupId()));
		} else {

			String loginUrl = SambaashUtil.getSignInURL(
					themeDisplay.getScopeGroupId(), themeDisplay, true);
			return String.format(
					"%s%sredirect=%s/-/manage-profile/create", loginUrl,
					loginUrl.contains("?") ? "&" : "?", getStartupCreatePath(themeDisplay.getScopeGroupId()));
		}
	}
	
	public static String editStartupFriendlyURL(ThemeDisplay themeDisplay, long orgId) {
		if (themeDisplay.isSignedIn()) {
			return String.format("%s/-/manage-profile/edit/%s",
					getStartupCreatePath(themeDisplay.getScopeGroupId()),orgId);
		} else {

			String loginUrl = SambaashUtil.getSignInURL(
					themeDisplay.getScopeGroupId(), themeDisplay, true);
			return String.format(
					"%s%sredirect=%s/-/manage-profile/edit/%s", loginUrl,
					loginUrl.contains("?") ? "&" : "?", getStartupCreatePath(themeDisplay.getScopeGroupId()),orgId);
		}
	}
	
	public static String displayChallengeFriendlyURL(ThemeDisplay themeDisplay, long challengeId) {
		if (themeDisplay.isSignedIn()) {
			return String.format("%s/-/spchallenge/view/challenge/%s",
					getChallengesPath(themeDisplay.getScopeGroupId()),challengeId);
		} else {

			String loginUrl = SambaashUtil.getSignInURL(
					themeDisplay.getScopeGroupId(), themeDisplay, true);
			return String.format(
					"%s%sredirect=%s/-/spchallenge/view/challenge/%s", loginUrl,
					loginUrl.contains("?") ? "&" : "?", getChallengesPath(themeDisplay.getScopeGroupId()),challengeId);
		}
	}
	
	public static String displayApplicationFriendlyURL(ThemeDisplay themeDisplay,long applicantId) {
		if (themeDisplay.isSignedIn()) {
			return String.format("%s/-/spchallenge/view/applicant/%s",
					getChallengesPath(themeDisplay.getScopeGroupId()),applicantId);
		} else {

			String loginUrl = SambaashUtil.getSignInURL(
					themeDisplay.getScopeGroupId(), themeDisplay, true);
			return String.format(
					"%s%sredirect=%s/-/spchallenge/view/applicant/%s", loginUrl,
					loginUrl.contains("?") ? "&" : "?", getChallengesPath(themeDisplay.getScopeGroupId()),applicantId);
		}
	}
	
	public static String deleteStarupFriendlyURL(ThemeDisplay themeDisplay , long orgId) {
		String format = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/%s/-/startup-listing/delete/%s";
		return String.format(format,getStartupsListingPath(themeDisplay.getScopeGroupId()),orgId);
	}

	public static String getStartupCreatePath(long scopeGroupId) {
		String pageHome = "";
		try {
			pageHome = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId, StartupConstants.SP_PARAM_STARTUP_CREATE).getValue();
		}catch (Exception e) {
			pageHome = "/startup/create";
		}
		return pageHome;
	}
	
//	public static String getStartupDisplayPath() {
//		return getStartupDisplayPath();
//	}
	
	public static String getStartupDisplayPath(long scopeGroupId) {
		String pageHome = "";
		try {
			pageHome = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId, StartupConstants.SP_PARAM_STARTUP_DISP).getValue();
		}catch (Exception e) {
			pageHome = "/startup/view";
		}
		return pageHome;
	}
	
	public static String getChallengesPath(long scopeGroupId) {
		String pageHome = "";
		try {
			pageHome = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId, StartupConstants.SP_PARAM_CHALLENGE_HOME).getValue();
		}catch (Exception e) {
			pageHome = "/challenges";
		}
		return pageHome;
	}
	public static String getStartupsListingPath(long scopeGroupId) {
		String pageHome = "";
		try {
			pageHome = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId, StartupConstants.SP_PARAM_STARTUP_LISTING).getValue();
		}catch (Exception e) {
			pageHome = "startup-list";
		}
		return pageHome;
	}

	public static String getIframeWebProtocol() {
		String protocol = "https";
		try {
			protocol = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(0, StartupConstants.IFRAME_WEB_PROTOCOL).getValue();
		}catch (Exception e) {
			logger.debug("Unable to retrieve iframe web protocol. Defaulting to https.",e);
		}
		return protocol;
	}
	
//	public static List<SPChallenge> getOrgAppliedChallenges(long orgId){
//		try{
//			return SPChallengeApplicantLocalServiceUtil.getAppliedChallenges(orgId);
//		}catch(Exception ex){
//			logger.error("Error while getting applied challenges", ex);
//		}
//		return new ArrayList<SPChallenge>();
//	}
//	public static List<Map<String,Object>> getOrgAppliedChallengesAsMap(PortletRequest request, long orgId){
//		try{
//			List<SPChallenge> challenges = getOrgAppliedChallenges(orgId);
//			List<Map<String,Object>>list = new ArrayList<Map<String,Object>>();
//			Map<String,Object>map;
//			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//			for (SPChallenge challenge : challenges) {
//				map = beanToMap(challenge);
//				map.put(StartupConstants.DESCRIPTION, HtmlUtil.stripHtml(shorten((String)map.get(StartupConstants.DESCRIPTION))));
//				map.put(StartupConstants.FRIENDLY_URL, displayChallengeFriendlyURL(themeDisplay, challenge.getSpChallengeId()));
//				map.put(StartupConstants.LOGO_URL, SambaashUtil.getDLFileUrl(request, challenge.getLogoId()));
//				SPChallengeApplicant applicant = SPChallengeApplicantLocalServiceUtil.findByChallengeIdApplicantRefId(challenge.getSpChallengeId(), orgId);
//				map.put(StartupConstants.APPLICATION_URL, displayApplicationFriendlyURL(themeDisplay, applicant.getSpChallengeApplicantId()));
//				list.add(map);
//			}
//			return list;
//		}catch(Exception ex){
//			logger.error("Error while getting applied challenges", ex);
//		}
//		return new ArrayList<Map<String,Object>>();
//	}
	
	public static String shorten(String desc){
		String result = StringPool.BLANK;
		int maxlength = 200;
		if(Validator.isNotNull(desc)){
			if(desc.length() > maxlength){
				result = desc.substring(0, maxlength-3);
				result = result + "...";
			}
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> beanToMap(Object bean){
		try {
			return BeanUtils.describe(bean);
		} catch (Exception e) {
			logger.error("beanToMap - Error while converting bean to map", e);
		}
		return new HashMap<String, Object>();
	}
	
	public static HttpServletRequestWrapper getHttpRequestWrapper(PortletRequest request) {
		 return new HttpServletRequestWrapperExtended(PortalUtil.getHttpServletRequest(request));
	}
	public static HttpServletRequestWrapper getHttpRequestWrapperMultiPart(PortletRequest request,Map<String,String>paramMap) {
		return new HttpServletRequestWrapperExtended(PortalUtil.getHttpServletRequest(request),paramMap);
	}
	
	public static String generateExportFileName(long userId, String prefix, String suffix) {
		String tmp = prefix + "_" + System.currentTimeMillis() + "_"
				+ userId + suffix;
		
		return System.getProperty("java.io.tmpdir") + File.separator + tmp;
	}
	
	public static String getDateMMMDDYYYYFormat(Date date){
		String formattedDate = StringPool.BLANK;
		if(Validator.isNotNull(date)){
			formattedDate = DateUtil.getDate(date,	"MMM dd, yyyy", Locale.ENGLISH);
		}
		return formattedDate;
	}
	
	public static long[] getFoundryAdminIds(ThemeDisplay themeDisplay) throws Exception {
		String temp = SambaashUtil.getParameter("foundry.admin.rolenames", 0);
		if(Validator.isNull(temp)) {
			temp = "Foundry Admin";
		}
		Role role = RoleServiceUtil.getRole(themeDisplay.getCompanyId(),
				temp);
		long[] userIds = UserServiceUtil.getRoleUserIds(role.getRoleId());
		return userIds;
	}
}
