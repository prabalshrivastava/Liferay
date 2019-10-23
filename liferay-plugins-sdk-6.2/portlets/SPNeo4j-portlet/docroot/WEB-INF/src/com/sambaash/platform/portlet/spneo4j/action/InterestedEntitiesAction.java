package com.sambaash.platform.portlet.spneo4j.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;

/**
 * Portlet implementation class InterestedEntitiesAction
 */
public class InterestedEntitiesAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = renderRequest.getPreferences();
		String blogPageName = preferences.getValue("blogPageName", "spblogs");
		try {
			List<AssetEntityGraphWrapper> assetEntitiesUserMayBeInterested = SPNeoforjLocalServiceUtil
					.findAssetEntitiesUserMayBeInterested(themeDisplay
							.getUserId(), themeDisplay.getCompanyId(),
							themeDisplay.getScopeGroupId(), themeDisplay
									.getLayoutSet().getLayoutSetId());
			
			List<AssetEntityGraphWrapper> assetEntityGraphWrappersUserMayBeInterested = new ArrayList<AssetEntityGraphWrapper>();
			
			for(AssetEntityGraphWrapper assetEntityUserMayBeInterested : assetEntitiesUserMayBeInterested) {
				AssetEntityGraphWrapper assetEntityGraphWrapper = new AssetEntityGraphWrapper();

				assetEntityGraphWrapper.setClassName(assetEntityUserMayBeInterested.getClassName());
				assetEntityGraphWrapper.setClassPK(assetEntityUserMayBeInterested.getClassPK());
				assetEntityGraphWrapper.setTitle(assetEntityUserMayBeInterested.getTitle());
				assetEntityGraphWrapper.setContent(assetEntityUserMayBeInterested.getContent());
				String imageUrl = assetEntityUserMayBeInterested.getImageUrl();

//				if (Validator.isNotNull(imageUrl) 
//						&& (imageUrl.startsWith(themeDisplay.getPortalURL()) || imageUrl.startsWith(StringPool.FORWARD_SLASH))) {
//					if (imageUrl.indexOf(StringPool.QUESTION) != -1) {
//						imageUrl = imageUrl + "&imageThumbnail=2";
//					} else {
//						imageUrl = imageUrl + "?imageThumbnail=2";
//					}
//				}
				
				assetEntityGraphWrapper.setImageUrl(imageUrl);
				assetEntityGraphWrapper.setStatus(assetEntityUserMayBeInterested.getStatus());
				
				String assetEntityDetailURL = StringPool.BLANK;
				
				if(BlogsEntry.class.getName().equalsIgnoreCase(assetEntityUserMayBeInterested.getClassName())) {
					Layout spBlogDetailLayout = null;
					try {
						spBlogDetailLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(
								themeDisplay.getScopeGroupId(), false, "/" + blogPageName);
					} catch (com.liferay.portal.NoSuchLayoutException e) {
						// do nothing
					}

					if (spBlogDetailLayout != null) {
						long spBlogDetailPlid = spBlogDetailLayout.getPlid();

						PortletURL spBlogDetailPortletURL = PortletURLFactoryUtil.create(renderRequest,
								"SPBlogs_WAR_SPBlogsportlet", spBlogDetailPlid,
								PortletRequest.RENDER_PHASE);
						spBlogDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
						spBlogDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
						spBlogDetailPortletURL.setParameter("struts_action", "/spblogs/view_entry");
						spBlogDetailPortletURL.setParameter("urlTitle", assetEntityUserMayBeInterested.getUrlTitle());
						spBlogDetailPortletURL.setParameter("entryId", String.valueOf(assetEntityUserMayBeInterested.getClassPK()));
						assetEntityDetailURL = spBlogDetailPortletURL.toString();
					}
				}else if(SPChallenge.class.getName().equalsIgnoreCase(assetEntityUserMayBeInterested.getClassName())){
						long challengeId = GetterUtil.getLong(assetEntityUserMayBeInterested.getClassPK());
						if(challengeId != 0){
							assetEntityDetailURL = SPChallengeLocalServiceUtil.displayChallengeFriendlyURL(themeDisplay, challengeId);
						}
				}
				assetEntityGraphWrapper.setDetailUrl(assetEntityDetailURL);
				
				assetEntityGraphWrappersUserMayBeInterested.add(assetEntityGraphWrapper);
			}
			renderRequest.setAttribute("assetEntityGraphWrappersUserMayBeInterested", assetEntityGraphWrappersUserMayBeInterested);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		try {
			String action = ParamUtil.getString(actionRequest, "action");
			if (Constants.EDIT.equalsIgnoreCase(action)) {
				String groupDetailPageName = ParamUtil.getString(actionRequest, "groupDetailPageName");
				String blogPageName = ParamUtil.getString(actionRequest, "blogPageName");
				portletPreferences.setValue("groupDetailPageName", groupDetailPageName);
				portletPreferences.setValue("blogPageName", blogPageName);
				portletPreferences.store();
				addSuccessMessage(actionRequest, actionResponse);
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		super.serveResource(resourceRequest, resourceResponse);
	}

	private Log _log = LogFactoryUtil.getLog(InterestedEntitiesAction.class);
	
}