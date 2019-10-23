package com.sambaash.platform.portlet.extendedprofile.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.NoSuchCategoryException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException;
import com.sambaash.platform.srv.extendedprofile.model.SPCertification;
import com.sambaash.platform.srv.extendedprofile.service.SPCertificationLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class CertificationAction
 */
public class CertificationAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			List<AssetVocabulary> assetVocabularies = getAssetVocabularies(themeDisplay);

			PortletPreferences preferences = renderRequest.getPreferences();
			String savedLevelOneId = preferences.getValue("savedLevelOneId", StringPool.BLANK);

			renderRequest.setAttribute("savedLevelOneId", savedLevelOneId);

			renderRequest.setAttribute("assetVocabularies", assetVocabularies);

		}catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long profileUserId = getProfileUserId(themeDisplay);
		long remoteUserId = themeDisplay.getUserId();
		boolean editable = (profileUserId == remoteUserId) ? true : false;
		renderRequest.setAttribute("editable", editable);
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String savedLevelOneId = preferences.getValue("savedLevelOneId", StringPool.BLANK);

			long vocabularyId = 0;
			try {
				vocabularyId = Long.valueOf(savedLevelOneId);
			}catch (NumberFormatException nfe) {

				// do nothing

			}

			List<AssetCategory> allCertificationCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, -1, -1, null);
			JSONObject allCertificationCategoryJSONObject = JSONFactoryUtil.createJSONObject();

			for (AssetCategory assetCategory : allCertificationCategories) {
				allCertificationCategoryJSONObject.put(String.valueOf(assetCategory.getCategoryId()), assetCategory.getName());
			}

			renderRequest.setAttribute("allCertificationCategoryJSONObject", allCertificationCategoryJSONObject.toString());

			List<SPCertification> myCertifications = SPCertificationLocalServiceUtil.findByUserId(profileUserId);
			List<AssetCategory> myCertificationCategories = new ArrayList<AssetCategory>();

			String certificationIdsStr = StringPool.BLANK;

			for (SPCertification certification : myCertifications) {
				if (certificationIdsStr.length() > 0) {
					certificationIdsStr += StringPool.COMMA;
				}

				long certificationId = certification.getCertificationId();
				certificationIdsStr += certificationId;
				AssetCategory assetCategory = null;
				try {
					assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(certificationId);
				}catch (NoSuchCategoryException nsce) {

					// do nothing

				}

				myCertificationCategories.add(assetCategory);
			}

			renderRequest.setAttribute("myCertificationCategories", myCertificationCategories);
			renderRequest.setAttribute("certificationIdsStr", certificationIdsStr);

		}catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		try {
			SocialProfile socialProfile = null;
			try {
				socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(userId);
			}catch (NoSuchSocialProfileException nsspe) {

				// do nothing

			}

			Indexer indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class.getName());

			String action = resourceRequest.getParameter("action");

			if ("save".equalsIgnoreCase(action)) {
				StringBuffer sb = new StringBuffer();
				String certificationIdsStr = resourceRequest.getParameter("certificationIdsStr");
				sb.append("<div><div class=\"workhistory_editAlignExt\"><a href=\"#\" title=\"edit\" data-mycertifications=\"" + certificationIdsStr + "\" onclick=\"javascript:editCertificationOnClick(event)\" class=\"userprofile-edit-linkExt\">&nbsp;</a></div>");

				List<SPCertification> existingCertifications = SPCertificationLocalServiceUtil.findByUserId(userId);

				List<SPCertification> _existingCertifications = new ArrayList<SPCertification>();
				_existingCertifications.addAll(existingCertifications);

				if (Validator.isNotNull(certificationIdsStr)) {
					String[] certificationIdsStrArray = StringUtil.split(certificationIdsStr, StringPool.COMMA);

					for (String certificationIdStr : certificationIdsStrArray) {
						long certificationId = 0;
						try {
							certificationId = Long.valueOf(certificationIdStr);
							SPCertification certification = null;
							Date now = new Date();
							try {
								certification = SPCertificationLocalServiceUtil.findByUserIdAndCertificationId(userId, certificationId);
								_existingCertifications.remove(certification);
							}catch (NoSuchSPCertificationException nsce) {
								certification = SPCertificationLocalServiceUtil.createSPCertification(CounterLocalServiceUtil.increment());
								certification.setCreateDate(now);
							}

							certification.setUserId(userId);
							certification.setCertificationId(certificationId);
							certification.setModifiedDate(now);
							certification.setCompanyId(themeDisplay.getCompanyId());
							SPCertificationLocalServiceUtil.updateSPCertification(certification);

						}catch (NumberFormatException nfe) {

							// do nothing

						}

						if (certificationId > 0) {
							AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(certificationId);
							sb.append("<div style=\"display: list-item; list-style: disc inside none;\">");
							sb.append(assetCategory.getName());
							sb.append("</div>");
							sb.append("<br />");
						}
					}

				}

				sb.append("</div>");

				for (SPCertification certification : _existingCertifications) {
					SPCertificationLocalServiceUtil.deleteSPCertification(certification);
				}

				if (socialProfile != null) {
					indexer.reindex(socialProfile);
				}

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");

				JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
				dataJSONObject.put("html", sb.toString());

				resourceResponse.getWriter().write(dataJSONObject.toString());

			}else if ("edit".equalsIgnoreCase(action)) {
				String levelOneId = resourceRequest.getParameter("levelOneId");
				PortletPreferences preferences = resourceRequest.getPreferences();
				preferences.setValue("savedLevelOneId", levelOneId);
				preferences.store();
			}
		}catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	private List<AssetVocabulary> getAssetVocabularies(ThemeDisplay themeDisplay) throws PortalException, SystemException {
		long scopeGroupId = themeDisplay.getScopeGroupId();
		List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();
		Group group = themeDisplay.getScopeGroup();

		if (group.isLayout()) {
			vocabularies.addAll(AssetVocabularyLocalServiceUtil.getGroupVocabularies(group.getParentGroupId(), false));
		}
		else {
			vocabularies.addAll(AssetVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId, false));
		}

		if (scopeGroupId != themeDisplay.getCompanyGroupId()) {
			vocabularies.addAll(AssetVocabularyLocalServiceUtil.getGroupVocabularies(themeDisplay.getCompanyGroupId(), false));
		}

		return vocabularies;
	}

	private long getProfileUserId(ThemeDisplay themeDisplay) {
		long remoteUserId = themeDisplay.getUserId();
	String friendlyURL = themeDisplay.getURLCurrent();
	long companyId = themeDisplay.getCompanyId();
	long profileUserId = SambaashUtil.getUserIdByScreenName(companyId, friendlyURL);

	if (profileUserId == 0) {
	profileUserId = remoteUserId;
	}

	return profileUserId;
	}

	private static Log _log = LogFactoryUtil.getLog(CertificationAction.class);
}