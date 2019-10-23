package com.sambaash.platform.spchallenge.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.platform.spchallenge.helper.SPChallengeConstants;
import com.sambaash.platform.spchallenge.helper.SPChallengeDLHelper;
import com.sambaash.platform.spchallenge.helper.SPChallengeHelper;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;


/**
 * Portlet implementation class MyChallengesAction
 */
public class MyChallengesAction extends SPChallengeAction {

	private static Log logger = LogFactoryUtil.getLog(MyChallengesAction.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		try {
			
			Object multiPartData[] = new Object[2];
			HttpServletRequestWrapper httpRequest=null;
			if(ServletFileUpload.isMultipartContent(PortalUtil.getHttpServletRequest(resourceRequest))){
				try {
					multiPartData = SPChallengeDLHelper.parseFileUploadRequest(resourceRequest, resourceResponse);
					httpRequest = SPChallengeHelper.getHttpRequestWrapperMultiPart(resourceRequest,((Map<String,String>)multiPartData[0]));
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
				
			}else{
				httpRequest = SPChallengeHelper.getHttpRequestWrapper(resourceRequest);
			}
			

			try {
				//AuthTokenUtil.getToken(httpRequest)
				AuthTokenUtil.checkCSRFToken(httpRequest, MyChallengesAction.class.getName());
			} catch (PortalException e1) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put(SPChallengeConstants.ERROR_MSG, SPChallengeConstants.MSG_UNAUTH);
				logger.error(e1.getMessage());
				resourceResponse.getWriter().write(obj.toString());
				return;
			}
			
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			List<Organization> orgs = OrganizationLocalServiceUtil
					.getUserOrganizations(themeDisplay.getUserId());
			logger.debug("user orgs = " + orgs + " for user = " + themeDisplay.getUserId());
			String categories = getOrganizatonCategories(resourceRequest, orgs);
			JSONObject obj ;
			if(Validator.isNotNull(categories)){
				String query = "(assetCategoryIds:(%s))";
				logger.debug("user categories = " + categories + " for user = " + themeDisplay.getUserId());
				int pageNo = ParamUtil.getInteger(resourceRequest,
						SPChallengeConstants.PARAM_SEARCH_PAGE_NO);
				int itemsPerPage = Integer.valueOf(resourceRequest.getPreferences()
						.getValue(SPChallengeConstants.VOC_ITEMS_PER_PAGE, "3"));
				obj = SPChallengeHelper.handleSearch(null, String.format(query, categories),
						pageNo, itemsPerPage, SPChallengeConstants.ATTRIB_CHALLENGE,
						resourceRequest);
			}else{
				obj = JSONFactoryUtil.createJSONObject();
			}
			resourceResponse.getWriter().write(HtmlUtil.stripHtml(obj.toString()));
		} catch (Exception e) {
			logger.error("Error getting user preferred challenges", e);
		}
	}

	private String getOrganizatonCategories(PortletRequest request, List<Organization> orgs) throws Exception {
		String categories = "";
		for (Organization organization : orgs) {
			try {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
						Organization.class.getName(),
						organization.getOrganizationId());
				if (Validator.isNull(assetEntry)) {
					continue;
				}
				// organization 'category' is one of the vocabulary
				String vocId = request.getPreferences().getValue(
						SPChallengeConstants.VOC_CHALLENGE_CATEGORY_ID, "0");
				for (AssetCategory assetCategory : assetEntry.getCategories()) {
					AssetVocabularyLocalServiceUtil
							.getAssetVocabulary(assetCategory.getVocabularyId());
					if (Long.valueOf(vocId).equals(
							assetCategory.getVocabularyId()) && !categories.contains(""+assetCategory.getCategoryId())) {
						categories += (" " + assetCategory.getCategoryId());
					}
				}
			} catch (Exception e) {
				logger.error("Error while getting org categorires", e);
			}
		}
		return categories;
	}
}
