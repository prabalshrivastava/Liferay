package com.sambaash.platform.portlet.spneo4j.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.UserConstants;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.model.ActivityFeedType;
import com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedGraphWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.ActivityFeedsWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.UserLikesWrapper;
import com.sambaash.platform.portlet.spneo4j.util.Util;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class SocialConnectionsAction
 */
public class SocialConnectionsAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		try {

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		PortletPreferences portletPreferences = actionRequest.getPreferences();
		try {
			String action = ParamUtil.getString(actionRequest, "action");
			if (Constants.EDIT.equalsIgnoreCase(action)) {

				String[] arr = { "groupDetailPageName", "blogPageName",
						"showAboutTab", "showFollowersTab",
						"showFollowingsTab", "showActivitiesTab",
						"showLikesTab" , "showPostsTab"};

				for (String string : arr) {
					portletPreferences.setValue(string,
							ParamUtil.getString(actionRequest, string));
				}
				portletPreferences.store();
				addSuccessMessage(actionRequest, actionResponse);
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = resourceRequest.getPreferences();
		String blogPageName = preferences.getValue("blogPageName", "spblogs");

		try {
			String action = resourceRequest.getParameter("action");
			if ("retrieveFollowers".equalsIgnoreCase(action)) {

				String curShowingNoStr = resourceRequest
						.getParameter("cur_showing_no");
				String offsetStr = resourceRequest.getParameter("offset");
				String currentURL = resourceRequest.getParameter("currentURL");

				int curShowingNo = 0;
				int offset = 0;

				try {
					curShowingNo = Integer.valueOf(curShowingNoStr);
				} catch (NumberFormatException nfe) {
				}
				try {
					offset = Integer.valueOf(offsetStr);
				} catch (NumberFormatException nfe) {
				}

				int start = curShowingNo;

				long profileUserId = SambaashUtil.getUserIdByScreenName(
						themeDisplay.getCompanyId(), currentURL);
				if (profileUserId == 0) {
					profileUserId = themeDisplay.getUserId();
				}
				List<UserGraphWrapper> followers = SPNeoforjLocalServiceUtil
						.findUserFollowers(profileUserId, themeDisplay
								.getCompanyId(),
								themeDisplay.getScopeGroupId(), themeDisplay
										.getLayoutSet().getLayoutSetId(),
								start, offset);
				int count = SPNeoforjLocalServiceUtil.findUserFollowersCount(
						profileUserId, themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(), themeDisplay
								.getLayoutSet().getLayoutSetId());

				JSONObject data = JSONFactoryUtil.createJSONObject();
				JSONArray items = JSONFactoryUtil.createJSONArray();

				for (UserGraphWrapper userFollowerGraphWrapper : followers) {
					String profileUrl = StringPool.SLASH
							+ userFollowerGraphWrapper.getScreenName();
					String userProfileImageUrl = UserConstants.getPortraitURL(
							themeDisplay.getPathImage(), true,
							userFollowerGraphWrapper.getPortraitId());
					JSONObject item = JSONFactoryUtil.createJSONObject();
					String html = "<div class=\"aui-helper-clearfix\">"
							+ "<div style=\"float: left; line-height: 0;\">"
							+ "<img alt=\"User Image\" src=\""
							+ userProfileImageUrl
							+ "\" style=\"width: 50px; height: 50px;\" />"
							+ "</div>"
							+ "<div style=\"margin-left: 65px; min-height: 50px;\">"
							+ "<div><a href=\"" + profileUrl + "\">"
							+ userFollowerGraphWrapper.getFirstName()
							+ StringPool.SPACE
							+ userFollowerGraphWrapper.getLastName()
							+ "</a></div>" + "</div>"
							+ "<hr style=\"margin: 10px 0;border-top: none;\">"
							+ "</div>";

					item.put("html", html);
					items.put(item);
				}

				data.put("items", items);
				data.put("count", count);

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());

			} else if ("retrieveFollowing".equalsIgnoreCase(action)) {

				String curShowingNoStr = resourceRequest
						.getParameter("cur_showing_no");
				String offsetStr = resourceRequest.getParameter("offset");
				String currentURL = resourceRequest.getParameter("currentURL");

				int curShowingNo = 0;
				int offset = 0;

				try {
					curShowingNo = Integer.valueOf(curShowingNoStr);
				} catch (NumberFormatException nfe) {
				}
				try {
					offset = Integer.valueOf(offsetStr);
				} catch (NumberFormatException nfe) {
				}

				int start = curShowingNo;

				long profileUserId = SambaashUtil.getUserIdByScreenName(
						themeDisplay.getCompanyId(), currentURL);
				if (profileUserId == 0) {
					profileUserId = themeDisplay.getUserId();
				}
				List<UserGraphWrapper> following = SPNeoforjLocalServiceUtil
						.findUserFollowing(profileUserId, themeDisplay
								.getCompanyId(),
								themeDisplay.getScopeGroupId(), themeDisplay
										.getLayoutSet().getLayoutSetId(),
								start, offset);
				int count = SPNeoforjLocalServiceUtil.findUserFollowersCount(
						profileUserId, themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(), themeDisplay
								.getLayoutSet().getLayoutSetId());

				JSONObject data = JSONFactoryUtil.createJSONObject();
				JSONArray items = JSONFactoryUtil.createJSONArray();

				for (UserGraphWrapper userFollowingGraphWrapper : following) {
					String profileUrl = StringPool.SLASH
							+ userFollowingGraphWrapper.getScreenName();
					String userProfileImageUrl = UserConstants.getPortraitURL(
							themeDisplay.getPathImage(), true,
							userFollowingGraphWrapper.getPortraitId());
					JSONObject item = JSONFactoryUtil.createJSONObject();
					String html = "<div class=\"aui-helper-clearfix\">"
							+ "<div style=\"float: left; line-height: 0;\">"
							+ "<img alt=\"User Image\" src=\""
							+ userProfileImageUrl
							+ "\" style=\"width: 50px; height: 50px;\" />"
							+ "</div>"
							+ "<div style=\"margin-left: 65px; min-height: 50px;\">"
							+ "<div><a href=\"" + profileUrl + "\">"
							+ userFollowingGraphWrapper.getFirstName()
							+ StringPool.SPACE
							+ userFollowingGraphWrapper.getLastName()
							+ "</a></div>" + "</div>"
							+ "<hr style=\"margin: 10px 0;border-top: none;\">"
							+ "</div>";

					item.put("html", html);
					items.put(item);
				}

				data.put("items", items);
				data.put("count", count);

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());

			} else if ("retrieveLikes".equalsIgnoreCase(action)) {

				String curShowingNoStr = resourceRequest
						.getParameter("cur_showing_no");
				String offsetStr = resourceRequest.getParameter("offset");
				String currentURL = resourceRequest.getParameter("currentURL");

				int curShowingNo = 0;
				int offset = 0;

				try {
					curShowingNo = Integer.valueOf(curShowingNoStr);
				} catch (NumberFormatException nfe) {
				}
				try {
					offset = Integer.valueOf(offsetStr);
				} catch (NumberFormatException nfe) {
				}

				int start = curShowingNo;

				long profileUserId = SambaashUtil.getUserIdByScreenName(
						themeDisplay.getCompanyId(), currentURL);
				if (profileUserId == 0) {
					profileUserId = themeDisplay.getUserId();
				}
				UserLikesWrapper userLikesWrapper = SPNeoforjLocalServiceUtil
						.findAssetEntitiesUserLikes(profileUserId,
								themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getLayoutSet().getLayoutSetId(), start, offset);

				List<AssetEntityGraphWrapper> assetEntityGraphWrappers = userLikesWrapper
						.getAssetEntityGraphWrappersUserLikes();
				int count = userLikesWrapper.getAssetEntitiesUserLiksCount();

				JSONObject data = JSONFactoryUtil.createJSONObject();
				JSONArray items = JSONFactoryUtil.createJSONArray();

				for (AssetEntityGraphWrapper assetEntityGraphWrapper : assetEntityGraphWrappers) {
					String assetEntityDetailURL = StringPool.BLANK;
					if (BlogsEntry.class.getName().equalsIgnoreCase(
							assetEntityGraphWrapper.getClassName())) {
						Layout spBlogDetailLayout = null;
						try {
							spBlogDetailLayout = LayoutLocalServiceUtil
									.getFriendlyURLLayout(
											themeDisplay.getScopeGroupId(),
											false, "/" + blogPageName);
						} catch (com.liferay.portal.NoSuchLayoutException e) {
							// do nothing
						}

						if (spBlogDetailLayout != null) {
							long spBlogDetailPlid = spBlogDetailLayout
									.getPlid();

							PortletURL spBlogDetailPortletURL = PortletURLFactoryUtil
									.create(resourceRequest,
											"SPBlogs_WAR_SPBlogsportlet",
											spBlogDetailPlid,
											PortletRequest.RENDER_PHASE);
							spBlogDetailPortletURL
									.setWindowState(javax.portlet.WindowState.NORMAL);
							spBlogDetailPortletURL
									.setPortletMode(javax.portlet.PortletMode.VIEW);
							spBlogDetailPortletURL.setParameter(
									"struts_action", "/spblogs/view_entry");
							spBlogDetailPortletURL.setParameter("urlTitle",
									assetEntityGraphWrapper.getUrlTitle());
							spBlogDetailPortletURL.setParameter("entryId",
									String.valueOf(assetEntityGraphWrapper
											.getClassPK()));
							assetEntityDetailURL = spBlogDetailPortletURL
									.toString();
						}
					} else if (SPChallenge.class.getName().equalsIgnoreCase(
							assetEntityGraphWrapper.getClassName())){
						assetEntityDetailURL = SPChallengeLocalServiceUtil.displayChallengeFriendlyURL(themeDisplay, assetEntityGraphWrapper
								.getClassPK());
					}
					assetEntityGraphWrapper.setDetailUrl(assetEntityDetailURL);

					JSONObject item = JSONFactoryUtil.createJSONObject();
					String html = "";
					
					if (Validator.isNotNull(assetEntityGraphWrapper.getImageUrl())) { 
						html = "<li class='margin-right-half'><div style=\"margin-bottom: 6px; display: block;\"><a href=\""
					
							+ assetEntityGraphWrapper.getDetailUrl()
							+ "\">"
							+ assetEntityGraphWrapper.getTitle()
							+ "</a></div>"
							+ "<div style=\"line-height: 0; max-height: 150px; overflow-y: hidden;\">"
							+ "<img alt=\"Image\" src=\""
							+ assetEntityGraphWrapper.getImageUrl()
							+ "\" style=\"width: 100%; max-height: 600px;\" />"
							+ "</div>"
							+ "<div style=\"margin-top: 10px;\">"
							+ "<div>"
							+ assetEntityGraphWrapper.getContent()
							+ "</div>"
							+ "</div>"
							+ "<hr style=\"margin: 10px 0;border-top: none;\"></li>";
					
					} else {
						html = "<li class='margin-right-half'><div style=\"margin-bottom: 6px; display: block;\"><a href=\""
								+ assetEntityGraphWrapper.getDetailUrl()
								+ "\">"
								+ assetEntityGraphWrapper.getTitle()
								+ "</a></div>"
								+ "<div style=\"margin-top: 10px;\">"
								+ "<div>"
								+ assetEntityGraphWrapper.getContent()
								+ "</div>"
								+ "</div>"
								+ "<hr style=\"margin: 10px 0;border-top: none;\"></li>";
					}

					item.put("html", html);
					items.put(item);
				}

				data.put("items", items);
				data.put("count", count);

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());

			} else if ("retrievePosts".equalsIgnoreCase(action)) {
				String curShowingNoStr = resourceRequest
						.getParameter("cur_showing_no");
				String offsetStr = resourceRequest.getParameter("offset");
				String currentURL = resourceRequest.getParameter("currentURL");

				int curShowingNo = 0;
				int offset = 0;

				try {
					curShowingNo = Integer.valueOf(curShowingNoStr);
				} catch (NumberFormatException nfe) {
				}
				try {
					offset = Integer.valueOf(offsetStr);
				} catch (NumberFormatException nfe) {
				}

				int start = curShowingNo;

				long profileUserId = SambaashUtil.getUserIdByScreenName(
						themeDisplay.getCompanyId(), currentURL);
				if (profileUserId == 0) {
					profileUserId = themeDisplay.getUserId();
				}
				ActivityFeedsWrapper activityFeedsWrapper = SPNeoforjLocalServiceUtil
						.findUserPosts(profileUserId, themeDisplay
								.getCompanyId(),
								themeDisplay.getScopeGroupId(), themeDisplay
										.getLayoutSet().getLayoutSetId(),
								start, offset);

				List<ActivityFeedGraphWrapper> activityFeedGraphWrappers = activityFeedsWrapper
						.getActivityFeedGraphWrappers();
				int count = activityFeedsWrapper.getActivityFeedsCount();

				JSONObject data = JSONFactoryUtil.createJSONObject();
				JSONArray items = JSONFactoryUtil.createJSONArray();

				for (ActivityFeedGraphWrapper activityFeedGraphWrapper : activityFeedGraphWrappers) {
					String assetEntityDetailURL = StringPool.BLANK;
					if (BlogsEntry.class.getName().equalsIgnoreCase(
							activityFeedGraphWrapper.getEndClassName())) {
						Layout spBlogDetailLayout = null;
						try {
							spBlogDetailLayout = LayoutLocalServiceUtil
									.getFriendlyURLLayout(
											themeDisplay.getScopeGroupId(),
											false, "/" + blogPageName);
						} catch (com.liferay.portal.NoSuchLayoutException e) {
							// do nothing
						}

						if (spBlogDetailLayout != null) {
							long spBlogDetailPlid = spBlogDetailLayout
									.getPlid();

							PortletURL spBlogDetailPortletURL = PortletURLFactoryUtil
									.create(resourceRequest,
											"SPBlogs_WAR_SPBlogsportlet",
											spBlogDetailPlid,
											PortletRequest.RENDER_PHASE);
							spBlogDetailPortletURL
									.setWindowState(javax.portlet.WindowState.NORMAL);
							spBlogDetailPortletURL
									.setPortletMode(javax.portlet.PortletMode.VIEW);
							spBlogDetailPortletURL.setParameter(
									"struts_action", "/spblogs/view_entry");
							spBlogDetailPortletURL.setParameter("urlTitle",
									activityFeedGraphWrapper
											.getEndAssetEntityUrlTitle());
							spBlogDetailPortletURL.setParameter("entryId",
									String.valueOf(activityFeedGraphWrapper
											.getEndClassPK()));
							assetEntityDetailURL = spBlogDetailPortletURL
									.toString();
						}
					} else if (SPChallenge.class.getName().equalsIgnoreCase(
							activityFeedGraphWrapper.getEndClassName())){
						assetEntityDetailURL = SPChallengeLocalServiceUtil.displayChallengeFriendlyURL(themeDisplay, activityFeedGraphWrapper
								.getEndClassPK());
					}

					String actionText = StringPool.BLANK;
					if (activityFeedGraphWrapper.getType() == ActivityFeedType.ADD_ENTITY
							.getValue()) {
						actionText = " added ";
					}

					JSONObject item = JSONFactoryUtil.createJSONObject();

					String html = StringPool.BLANK;

//					String userProfileImageUrl = "/../image/user_male_portrait?img_id="
//							+ activityFeedGraphWrapper.getStartUserPortraitId();
					String userProfileImageUrl = UserConstants.getPortraitURL(
							themeDisplay.getPathImage(), true,
							activityFeedGraphWrapper.getStartUserPortraitId());
					
					String profileUrl = StringPool.SLASH
							+ activityFeedGraphWrapper.getStartUserScreenName();

					html += "<li class=\"aui-helper-clearfix\"> "
							+ "<div style=\"float: left;\"> "
							+ "<a href=\""
							+ profileUrl
							+ "\" style=\"line-height: 0; display: block;\"><img alt=\"User Image\" src=\""
							+ userProfileImageUrl
							+ "\" style=\"width: 50px; height: 50px;\"></a> "
							+ "</div> "
							+ "<div style=\"margin-left: 65px; min-height: 50px;\"> "
							+ "<div><a href=\""
							+ profileUrl
							+ "\">"
							+ activityFeedGraphWrapper.getStartUserFirstName()
							+ StringPool.SPACE
							+ activityFeedGraphWrapper.getStartUserLastName()
							+ "</a><span style=\"color: #9197A3;\">"
							+ actionText
							+ "a </span><a href=\""
							+ assetEntityDetailURL
							+ "\" target=\"_blank\">blog</a></div>"
							+ "<div style=\"margin: 5px 0 10px; color: #9197A3;\">"
							+ lFormat.format(activityFeedGraphWrapper
									.getCreateDate()) + "</div>"
							+ "<div class=\"aui-helper-clearfix\"> ";
					html += (Validator.isNotNull(activityFeedGraphWrapper
							.getEndAssetEntityImageUrl()) ? "<div style=\"line-height: 0; margin-bottom: 10px;\"> "
							+ "<img alt=\"Activity Feed Image\" src=\""
							+ activityFeedGraphWrapper
									.getEndAssetEntityImageUrl()
							+ "\" style=\"max-width: 100%; max-height: 400px;\"> "
							+ "</div> "
							: StringPool.BLANK);
					html += "<div style=\"font-size: 15px; margin-bottom: 6px; display: block;\"><a href=\""
							+ assetEntityDetailURL
							+ "\" style=\"color: #333333;\" target=\"_blank\">"
							+ activityFeedGraphWrapper.getEndAssetEntityTitle()
							+ "</a></div>"
							+ "<div>"
							+ activityFeedGraphWrapper
									.getEndAssetEntityContent()
							+ "</div>  "
							+ "</div>"
							+ "</div> "
							+ "<hr style=\"border-top: none; margin: 12px 0;\"> "
							+ "</li>";

					item.put("html", html);
					items.put(item);

				}

				data.put("items", items);
				data.put("count", count);

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());

			} else if ("retrieveActivity".equalsIgnoreCase(action)) {
				String curShowingNoStr = resourceRequest
						.getParameter("cur_showing_no");
				String offsetStr = resourceRequest.getParameter("offset");
				String currentURL = resourceRequest.getParameter("currentURL");

				int curShowingNo = 0;
				int offset = 0;

				try {
					curShowingNo = Integer.valueOf(curShowingNoStr);
				} catch (NumberFormatException nfe) {
				}
				try {
					offset = Integer.valueOf(offsetStr);
				} catch (NumberFormatException nfe) {
				}

				int start = curShowingNo;

				long profileUserId = SambaashUtil.getUserIdByScreenName(
						themeDisplay.getCompanyId(), currentURL);
				if (profileUserId == 0) {
					profileUserId = themeDisplay.getUserId();
				}

				ActivityFeedsWrapper activityFeedsWrapper = SPNeoforjLocalServiceUtil
						.findUserActivity(profileUserId, themeDisplay
								.getCompanyId(),
								themeDisplay.getScopeGroupId(), themeDisplay
										.getLayoutSet().getLayoutSetId(),
								start, offset);

				List<ActivityFeedGraphWrapper> activityFeedGraphWrappers = activityFeedsWrapper
						.getActivityFeedGraphWrappers();
				int count = activityFeedsWrapper.getActivityFeedsCount();

				JSONObject data = JSONFactoryUtil.createJSONObject();
				JSONArray items = JSONFactoryUtil.createJSONArray();

				for (ActivityFeedGraphWrapper activityFeedGraphWrapper : activityFeedGraphWrappers) {
					JSONObject item = JSONFactoryUtil.createJSONObject();
					String html = StringPool.BLANK;

					String assetEntityDetailURL = StringPool.BLANK;
					String assetEntityName = StringPool.BLANK;

					html = "<li>";
					if (activityFeedGraphWrapper.getType() == ActivityFeedType.LIKE
							.getValue()) {
						html += "[$USER_NAME$] liked [$ASSET_ENTITY_NAME$] <a href=\"[$ASSET_ENTITY_DETAIL_URL$]\"><b>[$ASSET_ENTITY_TITLE$]</b></a>";

						if (BlogsEntry.class.getName().equalsIgnoreCase(
								activityFeedGraphWrapper.getEndClassName())) {
							Layout spBlogDetailLayout = null;
							try {
								spBlogDetailLayout = LayoutLocalServiceUtil
										.getFriendlyURLLayout(
												themeDisplay.getScopeGroupId(),
												false, "/" + blogPageName);
							} catch (com.liferay.portal.NoSuchLayoutException e) {
								// do nothing
							}

							if (spBlogDetailLayout != null) {
								long spBlogDetailPlid = spBlogDetailLayout
										.getPlid();

								PortletURL spBlogDetailPortletURL = PortletURLFactoryUtil
										.create(resourceRequest,
												"SPBlogs_WAR_SPBlogsportlet",
												spBlogDetailPlid,
												PortletRequest.RENDER_PHASE);
								spBlogDetailPortletURL
										.setWindowState(javax.portlet.WindowState.NORMAL);
								spBlogDetailPortletURL
										.setPortletMode(javax.portlet.PortletMode.VIEW);
								spBlogDetailPortletURL.setParameter(
										"struts_action", "/spblogs/view_entry");
								spBlogDetailPortletURL.setParameter("urlTitle",
										activityFeedGraphWrapper
												.getEndAssetEntityUrlTitle());
								spBlogDetailPortletURL.setParameter("entryId",
										String.valueOf(activityFeedGraphWrapper
												.getEndClassPK()));
								assetEntityDetailURL = spBlogDetailPortletURL
										.toString();
							}
							assetEntityName = "a blog";
						} else if (SPChallenge.class.getName().equalsIgnoreCase(
								activityFeedGraphWrapper.getEndClassName())){
							assetEntityDetailURL = SPChallengeLocalServiceUtil.displayChallengeFriendlyURL(themeDisplay, activityFeedGraphWrapper
									.getEndClassPK());
							assetEntityName = "a challenge";
						}
					} else if (activityFeedGraphWrapper.getType() == ActivityFeedType.FOLLOW
							.getValue()) {
						html += "[$USER_NAME$] started following <a href=\"[$FOLLOWING_PROFILE_URL$]\"><b>[$FOLLOWING_USER_NAME$]</b></a>";
					}
					html += "<p style=\"margin-top: 10px; color: #9197A3;\">"
							+ Util.getTimeDifferent(
									activityFeedGraphWrapper.getCreateDate(),
									new Date()) + "</p>";
					html += "<hr style=\"border-top: none; margin: 10px 0;\">";
					html += "</li>";

					html = StringUtil.replace(
							html,
							new String[] { "[$USER_NAME$]",
									"[$ASSET_ENTITY_NAME$]",
									"[$ASSET_ENTITY_DETAIL_URL$]",
									"[$ASSET_ENTITY_TITLE$]",
									"[$FOLLOWING_PROFILE_URL$]",
									"[$FOLLOWING_USER_NAME$]" },
							new String[] {
									activityFeedGraphWrapper
											.getStartUserFirstName()
											+ StringPool.SPACE
											+ activityFeedGraphWrapper
													.getStartUserLastName(),
									assetEntityName,
									assetEntityDetailURL,
									activityFeedGraphWrapper
											.getEndAssetEntityTitle(),
									StringPool.SLASH
											+ activityFeedGraphWrapper
													.getEndUserScreenName(),
									activityFeedGraphWrapper
											.getEndUserFirstName()
											+ StringPool.SPACE
											+ activityFeedGraphWrapper
													.getEndUserLastName() });

					item.put("html", html);
					items.put(item);
				}

				data.put("items", items);
				data.put("count", count);

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	private SimpleDateFormat lFormat = new SimpleDateFormat(
			"MMM dd, yyyy 'at' hh:mm a");

	private Log _log = LogFactoryUtil.getLog(SocialConnectionsAction.class);

}
