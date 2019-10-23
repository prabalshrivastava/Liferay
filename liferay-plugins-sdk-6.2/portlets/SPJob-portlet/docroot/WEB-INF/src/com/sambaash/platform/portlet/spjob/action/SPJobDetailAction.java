package com.sambaash.platform.portlet.spjob.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.spjob.permissions.JobPermissionsUtil;
import com.sambaash.platform.portlet.spjob.util.SPJobConstants;
import com.sambaash.platform.portlet.spjob.util.SPJobUtil;
import com.sambaash.platform.portlet.spjob.wrapper.SPJobDetailWrapper;
import com.sambaash.platform.srv.spjob.NoSuchSPJobException;
import com.sambaash.platform.srv.spjob.model.SPJob;
import com.sambaash.platform.srv.spjob.service.SPJobLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
//import com.sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil;

/**
 * Portlet implementation class SPJobDetailAction
 */
public class SPJobDetailAction extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String nameOfLandingPage = preferences.getValue("nameOfLandingPage", StringPool.BLANK);
			String nameOfApplyPage = preferences.getValue("nameOfApplyPage", StringPool.BLANK);
			renderRequest.setAttribute("nameOfLandingPage", nameOfLandingPage);
			renderRequest.setAttribute("nameOfApplyPage", nameOfApplyPage);
			String description = StringPool.BLANK;
			String keywords = StringPool.BLANK;
			boolean jobNotFound = false;
			HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			HttpServletRequest originalServletRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);
			String jobIdStr = originalServletRequest.getParameter("id");
			long jobId = 0;
			try {
				jobId = Long.valueOf(jobIdStr);
			} catch (NumberFormatException nfe) {

				// do nothing

			}

			SPJob job = null;
			try {
				job = SPJobLocalServiceUtil.getSPJob(jobId);
				
				String jobStatus = job.getStatus();
				_log.error("job status " + jobStatus + " id  " + jobId);
				if(!"Closed".equalsIgnoreCase(jobStatus)){
					SPJobDetailWrapper jobDetailWrapper = new SPJobDetailWrapper();
					jobDetailWrapper.setId(job.getSpJobId());
					jobDetailWrapper.setUserId(job.getUserId());
					jobDetailWrapper.setTitle(job.getJobTitle());
					jobDetailWrapper.setDescription(job.getJobDescription());
					jobDetailWrapper.setCreateDate(DateFormat.getDateInstance().format(job.getCreateDate()));
					jobDetailWrapper.setStartDate(Validator.isNotNull(job.getStartDate()) ? DateFormat.getDateInstance()
							.format(job.getStartDate()) : _NOT_AVAILABLE);
					jobDetailWrapper.setEndDate(Validator.isNotNull(job.getEndDate()) ? DateFormat.getDateInstance()
							.format(job.getEndDate()) : _NOT_AVAILABLE);
					jobDetailWrapper.setClosingDate(Validator.isNotNull(job.getClosingDate()) ? DateFormat
							.getDateInstance().format(job.getClosingDate()) : _NOT_AVAILABLE);
					jobDetailWrapper.setType(Validator.isNotNull(job.getJobType()) ? job.getJobType() : _NOT_AVAILABLE);
					jobDetailWrapper.setCompanyName(Validator.isNotNull(job.getCorporateName()) ? job.getCorporateName()
							: _NOT_AVAILABLE);
					jobDetailWrapper.setLocation(Validator.isNotNull(job.getJobLocation()) ? job.getJobLocation()
							: _NOT_AVAILABLE);
					jobDetailWrapper.setCost(Validator.isNotNull(job.getSalary()) ? job.getSalary() + StringPool.SPACE +
							job.getCurrency() : _NOT_AVAILABLE);
					jobDetailWrapper.setExp(Validator.isNotNull(job.getYearsOfExperience()) ? job.getYearsOfExperience()
							: _NOT_AVAILABLE);
					String jobPreviewImageUrl = "/image/image_gallery?img_id=" + job.getExtra2();
	
					// String jobPreviewImageUrl =
					// "http://sambaash.emeriocorp.com/image/image_gallery?img_id=34980";
	
					jobDetailWrapper.setImageUrl(jobPreviewImageUrl);
	
					String[] categoryArray = AssetCategoryLocalServiceUtil.getCategoryNames(SPJob.class.getName(), jobId);
					String[] tagArray = AssetTagLocalServiceUtil.getTagNames(SPJob.class.getName(), jobId);
	
					String categories = StringPool.BLANK;
					String tags = StringPool.BLANK;
	
					for (int i = 0; i < categoryArray.length; i++) {
						if (i > 0) {
							categories += ", ";
						}
	
						categories += categoryArray[i];
					}
	
					for (int j = 0; j < tagArray.length; j++) {
						if (j > 0) {
							tags += ", ";
						}
	
						tags += tagArray[j];
					}
	
					jobDetailWrapper.setCategories(categories);
					jobDetailWrapper.setTags(tags);
	
					renderRequest.setAttribute("jobDetailWrapper", jobDetailWrapper);
	
					description = HtmlUtil.stripHtml(jobDetailWrapper.getDescription());
	
					description = (Validator.isNotNull(description) && description.length() > 300) ? description.substring(
							0, 300) : description;
	
					PortalUtil.setPageTitle(jobDetailWrapper.getTitle(), originalServletRequest);
					PortalUtil.setPageDescription(description, originalServletRequest);
	
					if (Validator.isNotNull(job.getJobType())) {
						keywords = job.getJobType();
					}
	
					if (Validator.isNotNull(job.getJobLocation())) {
						if (Validator.isNotNull(keywords)) {
							keywords = keywords + StringPool.COMMA + jobDetailWrapper.getLocation();
						} else {
							keywords = jobDetailWrapper.getLocation();
						}
					}
	
					if (Validator.isNotNull(keywords)) {
						PortalUtil.setPageKeywords(keywords, originalServletRequest);
					}
	
					SambaashUtil.setOGTitle(jobDetailWrapper.getTitle(), originalServletRequest);
					SambaashUtil.setOGDescription(description, originalServletRequest);
					SambaashUtil.setOGImage(jobDetailWrapper.getImageUrl(), originalServletRequest);
					SambaashUtil.setOGUrl(themeDisplay.getPortalURL() + themeDisplay.getURLCurrent(),
							originalServletRequest);
	
					SambaashUtil.setTwitterCard("summary", originalServletRequest);
					SambaashUtil.setTwitterTitle(jobDetailWrapper.getTitle(), originalServletRequest);
					SambaashUtil.setTwitterDescription(description, originalServletRequest);
					SambaashUtil.setTwitterImage(jobDetailWrapper.getImageUrl(), originalServletRequest);
					SambaashUtil.setTwitterUrl(themeDisplay.getPortalURL() + themeDisplay.getURLCurrent(),
							originalServletRequest);
	
					SambaashUtil.setSchemaItempropDescription(description, originalServletRequest);
					SambaashUtil.setSchemaItempropName(jobDetailWrapper.getTitle(), originalServletRequest);
					SambaashUtil.setSchemaItempropThumbnail(jobDetailWrapper.getImageUrl(), originalServletRequest);
					SambaashUtil.setSchemaItempropUrl(themeDisplay.getPortalURL() + themeDisplay.getURLCurrent(),
							originalServletRequest);
	
					String applyServiceUserStatus ="You do not have the required permission to access this service.";
					HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
					String signUpUrl = PortalUtil.getCreateAccountURL(request, themeDisplay);
					String signinUrl = "/signin?redirect=/jobs";
					if(!themeDisplay.isSignedIn()){
						applyServiceUserStatus="Please <a href=" + signinUrl + ">Login</a> to apply for this job.<br/> Not a Member?<a href="  + signUpUrl + ">Join Us</a>";
					}
	
					if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()) || JobPermissionsUtil.hasJobApplyPermission(themeDisplay,nameOfApplyPage)) {
						renderRequest.setAttribute("applyServiceHasAccess", true);
					}else{
						renderRequest.setAttribute("applyServiceHasAccess", false);
						renderRequest.setAttribute("applyServiceUserStatus", applyServiceUserStatus);
					}
					
					/*String applyServiceStrutsAction = StringPool.BLANK;
					SPParameter applyServiceParameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
							themeDisplay.getScopeGroupId(), SPJobConstants.JOBS.APPLY_JOB_SERVICE);
					applyServiceStrutsAction = applyServiceParameter.getValue();
					Map<String, Object> parameterMap = new HashMap<String, Object>();
					parameterMap.put("struts_action", applyServiceStrutsAction);
					parameterMap.put("groupId", new Long(themeDisplay.getScopeGroupId()));
	
					Map<String, Object> applyServiceHasAccessMap = ServiceComponentsLocalServiceUtil.hasAccess(
							parameterMap, themeDisplay.getUser());
					applyServiceHasAccess = (Boolean)applyServiceHasAccessMap
							.get(SambaashConstants.MEMBERSHIP.SERVICE_HASACCESS);
					applyServiceUserStatus = (String)applyServiceHasAccessMap
							.get(SambaashConstants.MEMBERSHIP.SERVICE_REDIRECTURL);*/
	
					/* To show or hide Notefication To field */
					boolean enableNotef = SPJobUtil.enableNoteficationTo();
	
					if (enableNotef) {
						jobDetailWrapper.setNotefTo(job.getNotefto());
						renderRequest.setAttribute("enableNoteF", enableNotef);
					}
			
				}else{
					jobNotFound = true;
					renderRequest.setAttribute("jobNotFound", jobNotFound);
				}

			} catch (NoSuchSPJobException nsje) {
				jobNotFound = true;
			}

			String communityName = SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());
			renderRequest.setAttribute("communityName", communityName);

			renderRequest.setAttribute("jobNotFound", jobNotFound);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String nameOfLandingPage = preferences.getValue("nameOfLandingPage", StringPool.BLANK);
			String nameOfApplyPage = preferences.getValue("nameOfApplyPage", StringPool.BLANK);
			renderRequest.setAttribute("nameOfLandingPage", nameOfLandingPage);
			renderRequest.setAttribute("nameOfApplyPage", nameOfApplyPage);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		try {
			String action = ParamUtil.getString(actionRequest, "action");

			if (Constants.EDIT.equalsIgnoreCase(action)) {
				PortletPreferences preferences = actionRequest.getPreferences();
				String nameOfLandingPage = ParamUtil.getString(actionRequest, "nameOfLandingPage");
				String nameOfApplyPage = ParamUtil.getString(actionRequest, "nameOfApplyPage");
				preferences.setValue("nameOfLandingPage", nameOfLandingPage);
				preferences.setValue("nameOfApplyPage", nameOfApplyPage);
				preferences.store();
				actionResponse.setPortletMode(PortletMode.VIEW);
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		super.serveResource(resourceRequest, resourceResponse);
	}

	private static final String _NOT_AVAILABLE = "Not available";

	private static Log _log = LogFactoryUtil.getLog(SPJobDetailAction.class);

}