package com.sambaash.platform.portlet.spneo4j.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class UpdateInterestsAction
 */
public class UpdateInterestsAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		try {
			StringBuffer sb = new StringBuffer();
			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil
					.getAssetVocabularies(-1, -1);
			for (AssetVocabulary av : assetVocabularies) {
				sb.append(av.getName() + ": " + av.getVocabularyId() + ", ");
			}
			renderRequest
					.setAttribute("assetVocabulariesString", sb.toString());
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		long assetCategoriesVocabularyId = 0;
		try {
			String assetCategoriesVocabularyIdStr = portletPreferences
					.getValue("assetCategoriesVocabularyId", "0");
			try {
				assetCategoriesVocabularyId = Long
						.valueOf(assetCategoriesVocabularyIdStr);
			} catch (NumberFormatException nfe) {
				// do nothing
			}
			if (assetCategoriesVocabularyId > 0) {
				List<Long> selectedInterests = SPNeoforjLocalServiceUtil
						.findMyInterestedCategoryIds(themeDisplay.getUserId(),
								themeDisplay.getCompanyId(), themeDisplay
										.getScopeGroupId(), themeDisplay
										.getLayoutSet().getLayoutSetId());
				// List<Long> selectedInterests = new ArrayList<Long>();
				renderRequest.setAttribute("selectedInterests",
						selectedInterests);
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		} finally {
			try {
				List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil
						.getVocabularyCategories(assetCategoriesVocabularyId,
								-1, -1, null);
				renderRequest.setAttribute("assetCategories", assetCategories);
			} catch (SystemException e) {
			}
		}
		
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		try {
			String action = ParamUtil.getString(actionRequest, "action");
			if (Constants.EDIT.equalsIgnoreCase(action)) {
				String assetCategoriesVocabularyIdStr = ParamUtil.getString(
						actionRequest, "assetCategoriesVocabularyId");
				portletPreferences.setValue("assetCategoriesVocabularyId",
						assetCategoriesVocabularyIdStr);
				portletPreferences.store();
				addSuccessMessage(actionRequest, actionResponse);
			} else if ("updateInterests".equalsIgnoreCase(action)) {
				String skip = actionRequest.getParameter("skip");
				if (StringPool.FALSE.equalsIgnoreCase(skip)) {
					List<Long> selectedInterests = new ArrayList<Long>();

					String[] interests = actionRequest
							.getParameterValues("interests");
					if (interests != null) {
						for (String interest : interests) {
							selectedInterests.add(Long.valueOf(interest));
						}
					}
					SPNeoforjLocalServiceUtil.updateUserInterests(themeDisplay
							.getUserId(), selectedInterests, themeDisplay
							.getCompanyId(), themeDisplay.getScopeGroupId(),
							themeDisplay.getLayout().getLayoutId());
				}

				try {
					SocialProfile socialProfile = SocialProfileLocalServiceUtil
							.getSocialProfile(themeDisplay.getUser()
									.getUserId());
					socialProfile.setUpdateInterestsStatus(1);
					SocialProfileLocalServiceUtil
							.updateSocialProfile(socialProfile);
				} catch (NoSuchSocialProfileException nsspe) {
					// do nothing
				}

				actionResponse.sendRedirect(SambaashUtil.getDashboardUrl(
						themeDisplay.getScopeGroupId(),
						themeDisplay.getUserId()));

			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		
		super.processAction(actionRequest, actionResponse);
	}

	private Log _log = LogFactoryUtil.getLog(UpdateInterestsAction.class);

}