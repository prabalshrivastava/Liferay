package com.sambaash.platform.portlet.spgroup.action;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.htmlparser.util.ParserException;

import com.liferay.compat.portal.model.UserConstants;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.facebook.FacebookConnectUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.SubscriptionLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageDisplay;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.model.MBTreeWalker;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.SPGroupStatus;
import com.sambaash.platform.model.SPGroupType;
import com.sambaash.platform.model.SPGroupUserStatus;
import com.sambaash.platform.model.SPGroupUserType;
import com.sambaash.platform.portlet.spgroup.util.ActionUtil;
import com.sambaash.platform.portlet.spgroup.util.SPGroupConstants;
import com.sambaash.platform.portlet.spgroup.util.SPGroupUpdatesUtil;
import com.sambaash.platform.portlet.spgroup.util.Util;
import com.sambaash.platform.portlet.spgroup.wrapper.CommentBo;
import com.sambaash.platform.portlet.spgroup.wrapper.CommentJsonBo;
import com.sambaash.platform.portlet.spgroup.wrapper.CommentJsonListBo;
import com.sambaash.platform.portlet.spgroup.wrapper.SPGroupMemberWrapper;
import com.sambaash.platform.srv.spgroup.NoSuchPrefException;
import com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;
import com.sambaash.platform.srv.spgroup.NoSuchUserException;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.model.SPGroupPref;
import com.sambaash.platform.srv.spgroup.model.SPGroupUser;
import com.sambaash.platform.srv.spgroup.service.SPGroupLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.service.SPGroupPrefLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK;
import com.sambaash.platform.srv.spinbox.model.IBMessage;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spsocialsharing.service.SPSocialSharingLocalServiceUtil;
import com.sambaash.platform.util.SPHtmlUtil;
import com.sambaash.platform.util.SambaashUtil;
//import com.sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil;

/**
 * Portlet implementation class SPGroupDetailAction
 */
public class SPGroupDetailAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = renderRequest.getPreferences();
		String groupDetailPageName = preferences.getValue("groupDetailPageName", "group-detail");

		try {
			boolean isCommunityAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
			renderRequest.setAttribute("isCommunityAdmin", isCommunityAdmin);

			String urlTitle = ParamUtil.getString(renderRequest, "urlTitle");
			String action = ParamUtil.getString(renderRequest, "action");

			SPGroup spGroup = null;

			boolean isSPGroupClosed = false;

			boolean isOwner = false;
			boolean isAdmin = false;
			boolean isMember = false;
			boolean isWaitingForApproval = false;
			boolean isRejected = false;
			boolean isInvited = false;

			try {
				spGroup = ActionUtil.getSPGroup(renderRequest);

				if (spGroup != null) {
					isSPGroupClosed = spGroup.getStatus() == SPGroupStatus.CLOSED.getValue() ? true : false;
					long spGroupId = spGroup.getSpGroupId();

					if ("joinSPGroup".equalsIgnoreCase(action)) {
						int spGroupType = spGroup.getType();
						try {
							SPGroupUser spGroupUser = SPGroupUserLocalServiceUtil
									.getSPGroupUser(new SPGroupUserPK(spGroupId, themeDisplay.getUserId()));

							if (SPGroupType.PUBLIC.getValue() == spGroupType) {
								spGroupUser.setStatus(SPGroupUserStatus.APPROVE.getValue());
								SPGroupUserLocalServiceUtil.updateSPGroupUser(spGroupUser);
								PortletURL spGroupDetailPortletURL = getGroupDetailURL(
										renderRequest, themeDisplay,
										groupDetailPageName, urlTitle,
										spGroupId);
								sendUserJoinedNotification(spGroup, spGroupDetailPortletURL.toString(), themeDisplay.getUserId(), renderRequest);
							} else if (SPGroupType.MEMBERS_ONLY.getValue() == spGroupType
									|| SPGroupType.ADMIN.getValue() == spGroupType) {
								if (SPGroupUserStatus.INVITATION_UNCONFIRMED.getValue() == spGroupUser.getStatus()) {
									spGroupUser.setStatus(SPGroupUserStatus.APPROVE.getValue());
									SPGroupUserLocalServiceUtil.updateSPGroupUser(spGroupUser);
									PortletURL spGroupDetailPortletURL = getGroupDetailURL(
											renderRequest, themeDisplay,
											groupDetailPageName, urlTitle,
											spGroupId);
									sendUserJoinedNotification(spGroup, spGroupDetailPortletURL.toString(), themeDisplay.getUserId(), renderRequest);
								} else if (SPGroupUserStatus.REJECTED.getValue() == spGroupUser.getStatus()) {
									SessionErrors.add(renderRequest, "HASBEENREJECTED");
								}
							}
						} catch (NoSuchUserException nsue) {
							if (SPGroupType.PUBLIC.getValue() == spGroupType) {
								SPGroupUserLocalServiceUtil.addSPGroupUser(spGroupId, themeDisplay.getUserId(),
										SPGroupUserType.MEMBER.getValue(), SPGroupUserStatus.APPROVE.getValue(),
										spGroup.getGroupId(), spGroup.getCompanyId());
								PortletURL spGroupDetailPortletURL = getGroupDetailURL(
										renderRequest, themeDisplay,
										groupDetailPageName, urlTitle,
										spGroupId);
								sendUserJoinedNotification(spGroup, spGroupDetailPortletURL.toString(), themeDisplay.getUserId(), renderRequest);
							} else if (SPGroupType.MEMBERS_ONLY.getValue() == spGroupType) {
								SPGroupUser spGroupUser = SPGroupUserLocalServiceUtil.addSPGroupUser(spGroupId,
										themeDisplay.getUserId(), SPGroupUserType.MEMBER.getValue(),
										SPGroupUserStatus.REQUEST_PENDING.getValue(), spGroup.getGroupId(),
										spGroup.getCompanyId());

								// send join request

								String portalURL = PortalUtil.getPortalURL(renderRequest);
								String portalSigninUrl = portalURL + "/signin?redirect=";
								String profileURL = portalURL + StringPool.SLASH
										+ themeDisplay.getUser().getScreenName();
								String username = themeDisplay.getUser().getFullName();

								String groupTitle = spGroup.getTitle();
								String spGroupMembersURL = StringPool.BLANK;
								String spGroupDetailURL = StringPool.BLANK;
								PortletURL spGroupDetailPortletURL = getGroupDetailURL(
										renderRequest, themeDisplay,
										groupDetailPageName, urlTitle,
										spGroupId);
								if (Validator.isNotNull(spGroupDetailPortletURL)){
									spGroupDetailURL = spGroupDetailPortletURL.toString();
									
									spGroupDetailPortletURL.setParameter("tab1", "members");
									spGroupMembersURL = spGroupDetailPortletURL.toString();
								}
								
								Map<String, Object> paramsMap = new HashMap<String, Object>();
								paramsMap.put("profileURL", profileURL);
								paramsMap.put("username", username);
								paramsMap.put("groupDetailURL", spGroupDetailURL);
								paramsMap.put("groupTitle", groupTitle);
								paramsMap.put("spGroupMembersURL", spGroupMembersURL);
								paramsMap.put("senderId", themeDisplay.getUserId());
								paramsMap.put("portalSigninUrl", portalSigninUrl);

								String[] joinRequestTitleAndBody = getJoinRequestTitleAndBody(paramsMap);

								// owners and admins

								List<SPGroupUser> owners = SPGroupUserLocalServiceUtil.findBySPGroupIdAndRole(spGroupId,
										SPGroupUserType.OWNER.getValue());
								List<SPGroupUser> admins = SPGroupUserLocalServiceUtil.findBySPGroupIdAndRole(spGroupId,
										SPGroupUserType.ADMIN.getValue());

								List<Long> toUserIds = new ArrayList<Long>();
								List<String> toEmails = new ArrayList<String>();
								List<String> toUsernames = new ArrayList<String>();

								for (SPGroupUser owner : owners) {
									long ownerId = owner.getUserId();
									try {
										User user = UserLocalServiceUtil.getUser(ownerId);
										toUserIds.add(user.getUserId());
										toEmails.add(user.getEmailAddress());
										toUsernames.add(user.getFullName());

										sendExternalEmail(themeDisplay.getCompanyId(), joinRequestTitleAndBody[0],
												joinRequestTitleAndBody[1], user.getFullName(), user.getEmailAddress(),
												paramsMap);

									} catch (com.liferay.portal.NoSuchUserException nsue_) {

										// do nothing

									}
								}

								for (SPGroupUser admin : admins) {
									long adminId = admin.getUserId();
									try {
										User user = UserLocalServiceUtil.getUser(adminId);
										toUserIds.add(user.getUserId());
										toEmails.add(user.getEmailAddress());
										toUsernames.add(user.getFullName());

										sendExternalEmail(themeDisplay.getCompanyId(), joinRequestTitleAndBody[0],
												joinRequestTitleAndBody[1], user.getFullName(), user.getEmailAddress(),
												paramsMap);

									} catch (com.liferay.portal.NoSuchUserException nsue_) {

										// do nothing

									}
								}

								StringBuffer toEmailsSb = new StringBuffer();

								for (int i = 0; i < toEmails.size(); i++) {
									String toEmail = toEmails.get(i);
									toEmailsSb.append(toEmail);

									if (i < toEmails.size() - 1) {
										toEmailsSb.append(StringPool.COMMA);
									}
								}
								
								PortletURL groupDetailPortletURL = getGroupDetailURL(
										renderRequest, themeDisplay,
										groupDetailPageName, urlTitle,
										spGroupId);
								sendUserJoinRequestNotification(spGroup, groupDetailPortletURL, 
										themeDisplay.getUserId(), renderRequest);

								// add IBMessage

								IBMessage ibmessage = ActionUtil.addIBMessage(themeDisplay.getScopeGroupId(),
										themeDisplay.getCompanyId(), spGroupId, themeDisplay.getUser().getFullName(),
										themeDisplay.getUser().getUserId(), themeDisplay.getUser().getEmailAddress(),
										toEmailsSb.toString(), joinRequestTitleAndBody[0], joinRequestTitleAndBody[1]);

								for (int i = 0; i < toUserIds.size(); i++) {
									ActionUtil.addIBMessageDetail(themeDisplay.getCompanyId(), ibmessage,
											toUserIds.get(i), toUsernames.get(i), "Pending", "request",
											spGroupUser.getUserId());

								}

							}
						}

					} else if ("cancelJoinSPGroupRequest".equalsIgnoreCase(action)) {
						try {
							SPGroupUserLocalServiceUtil
									.getSPGroupUser(new SPGroupUserPK(spGroupId, themeDisplay.getUserId()));

							SPGroupUserLocalServiceUtil.deleteSPGroupUser(spGroupId, themeDisplay.getUserId());

						} catch (NoSuchUserException nsue) {

							// do nothing

						}

					} else if ("acceptJoinSPGroupRequest".equalsIgnoreCase(action)) {
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil
									.getSPGroupUser(new SPGroupUserPK(spGroupId, themeDisplay.getUserId()));
							spGroupUser.setStatus(SPGroupUserStatus.APPROVE.getValue());
							SPGroupUserLocalServiceUtil.updateSPGroupUser(spGroupUser);
							
							PortletURL spGroupDetailPortletURL = getGroupDetailURL(
									renderRequest, themeDisplay,
									groupDetailPageName, urlTitle,
									spGroupId);
							sendUserJoinedNotification(spGroup, spGroupDetailPortletURL.toString(), 
									themeDisplay.getUserId(), renderRequest);
							
							// delete notification accept/reject
							Long notificationId = ParamUtil.getLong(renderRequest, "notificationEventId");
							deleteUserNotification(notificationId);
						} catch (NoSuchUserException nsue) {
							// do nothing
						}

					}  else if ("ignoreJoinSPGroupRequest".equalsIgnoreCase(action)) {
						// delete notification accept/reject
						Long notificationId = ParamUtil.getLong(renderRequest, "notificationEventId");
						deleteUserNotification(notificationId);
					} else if ("quitSPGroup".equalsIgnoreCase(action)) {
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil.findByUserIdAndGroupIdAndStatus(
									themeDisplay.getUserId(), spGroupId, SPGroupUserStatus.APPROVE.getValue());

							if (spGroupUser.getRole() == SPGroupUserType.OWNER.getValue()) {
								List<SPGroupUser> owners = SPGroupUserLocalServiceUtil.findBySPGroupIdAndRole(spGroupId,
										SPGroupUserType.OWNER.getValue());

								if (owners.size() <= 1) {

									// skip last owner

									SessionErrors.add(renderRequest, "LASTOWNEROFTHISGROUP");
								} else {
									SPGroupUserLocalServiceUtil.deleteSPGroupUser(spGroupId, themeDisplay.getUserId());

									// unsubscribe

									SubscriptionLocalServiceUtil.deleteSubscription(themeDisplay.getUserId(),
											SPGroup.class.getName(), spGroupId);
								}
							} else {
								SPGroupUserLocalServiceUtil.deleteSPGroupUser(spGroupId, themeDisplay.getUserId());
							}
						} catch (NoSuchUserException nsue) {

							// do nothing

						}

					} else if ("approveOfJoiningSPGroup".equalsIgnoreCase(action)) {
						long selectedUserId = ParamUtil.getLong(renderRequest, "selectedUserId");
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil
									.getSPGroupUser(new SPGroupUserPK(spGroupId, selectedUserId));
							spGroupUser.setStatus(SPGroupUserStatus.APPROVE.getValue());
							SPGroupUserLocalServiceUtil.updateSPGroupUser(spGroupUser);

							String groupTitle = spGroup.getTitle();
							
							PortletURL spGroupDetailPortletURL = getGroupDetailURL(
									renderRequest, themeDisplay,
									groupDetailPageName, urlTitle,
									spGroupId);
							
							sendUserJoinedNotification(spGroup, spGroupDetailPortletURL.toString(), selectedUserId, renderRequest);
							sendApprovalResponseNotification(
									spGroup,
									spGroupDetailPortletURL.toString(),
									selectedUserId,
									themeDisplay.getUserId(),
									SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_JOIN_REQUEST_APPROVED,
									renderRequest);

							Map<String, Object> paramsMap = new HashMap<String, Object>();
							String portalURL = PortalUtil.getPortalURL(renderRequest);
							String portalSigninUrl = portalURL + "/signin?redirect=";
							paramsMap.put("groupDetailURL", spGroupDetailPortletURL.toString());
							paramsMap.put("groupTitle", groupTitle);
							paramsMap.put("portalSigninUrl", portalSigninUrl);

							String[] joinRequestNotificationTitleAndBody = getJoinRequestNotificationTitleAndBody(
									paramsMap, true);

							User selectedUser = null;
							try {
								selectedUser = UserLocalServiceUtil.getUser(selectedUserId);

								// add IBMessage

								IBMessage ibmessage = ActionUtil.addIBMessage(themeDisplay.getScopeGroupId(),
										themeDisplay.getCompanyId(), spGroupId, themeDisplay.getUser().getFullName(),
										themeDisplay.getUser().getUserId(), themeDisplay.getUser().getEmailAddress(),
										selectedUser.getEmailAddress(), joinRequestNotificationTitleAndBody[0],
										joinRequestNotificationTitleAndBody[1]);

								ActionUtil.addIBMessageDetail(themeDisplay.getCompanyId(), ibmessage, selectedUserId,
										selectedUser.getFullName(), "", "notification", spGroupUser.getUserId());

							} catch (com.liferay.portal.NoSuchUserException nsue) {

								// do nothing

							}

							paramsMap.put("senderId", themeDisplay.getUserId());
							sendExternalEmail(themeDisplay.getCompanyId(), joinRequestNotificationTitleAndBody[0],
									joinRequestNotificationTitleAndBody[1], selectedUser.getFullName(),
									selectedUser.getEmailAddress(), paramsMap);

						} catch (NoSuchUserException nsue) {

							// do nothing

						}
					} else if ("rejectOfJoiningSPGroup".equalsIgnoreCase(action)) {
						long selectedUserId = ParamUtil.getLong(renderRequest, "selectedUserId");
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil
									.getSPGroupUser(new SPGroupUserPK(spGroupId, selectedUserId));
							spGroupUser.setStatus(SPGroupUserStatus.REJECTED.getValue());
							SPGroupUserLocalServiceUtil.updateSPGroupUser(spGroupUser);

							String groupTitle = spGroup.getTitle();
							String spGroupDetailURL = StringPool.BLANK;
							Layout spGroupDetailLayout = null;
							try {
								spGroupDetailLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(
										themeDisplay.getScopeGroupId(), false, "/" + groupDetailPageName);
							} catch (com.liferay.portal.NoSuchLayoutException e) {

								// do nothing

							}

							if (spGroupDetailLayout != null) {
								long spGroupDetailPlid = spGroupDetailLayout.getPlid();

								PortletURL spGroupDetailPortletURL = PortletURLFactoryUtil.create(renderRequest,
										SPGroupConstants.PORTLET_ID_GROUP_DETAIL, spGroupDetailPlid,
										PortletRequest.RENDER_PHASE);
								spGroupDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
								spGroupDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
								spGroupDetailPortletURL.setParameter("struts_action", "/groups/view_entry");
								spGroupDetailPortletURL.setParameter("urlTitle", urlTitle);
								spGroupDetailPortletURL.setParameter("spGroupId", String.valueOf(spGroupId));
								spGroupDetailURL = spGroupDetailPortletURL.toString();

							}

							Map<String, Object> paramsMap = new HashMap<String, Object>();
							String portalURL = PortalUtil.getPortalURL(renderRequest);
							String portalSigninUrl = portalURL + "/signin?redirect=";
							paramsMap.put("groupDetailURL", spGroupDetailURL);
							paramsMap.put("groupTitle", groupTitle);
							paramsMap.put("portalSigninUrl", portalSigninUrl);

							String[] joinRequestNotificationTitleAndBody = getJoinRequestNotificationTitleAndBody(
									paramsMap, false);

							User selectedUser = null;
							try {
								selectedUser = UserLocalServiceUtil.getUser(selectedUserId);

								// add IBMessage

								IBMessage ibmessage = ActionUtil.addIBMessage(themeDisplay.getScopeGroupId(),
										themeDisplay.getCompanyId(), spGroupId, themeDisplay.getUser().getFullName(),
										themeDisplay.getUser().getUserId(), themeDisplay.getUser().getEmailAddress(),
										selectedUser.getEmailAddress(), joinRequestNotificationTitleAndBody[0],
										joinRequestNotificationTitleAndBody[1]);

								ActionUtil.addIBMessageDetail(themeDisplay.getCompanyId(), ibmessage, selectedUserId,
										selectedUser.getFullName(), "", "notification", spGroupUser.getUserId());

							} catch (com.liferay.portal.NoSuchUserException nsue) {

								// do nothing

							}
							
							PortletURL spGroupDetailPortletURL = getGroupDetailURL(
									renderRequest, themeDisplay,
									groupDetailPageName, urlTitle,
									spGroupId);
							sendApprovalResponseNotification(
									spGroup,
									spGroupDetailPortletURL.toString(),
									selectedUserId,
									themeDisplay.getUserId(),
									SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_JOIN_REQUEST_REJECTED,
									renderRequest);

							paramsMap.put("senderId", themeDisplay.getUserId());
							sendExternalEmail(themeDisplay.getCompanyId(), joinRequestNotificationTitleAndBody[0],
									joinRequestNotificationTitleAndBody[1], selectedUser.getFullName(),
									selectedUser.getEmailAddress(), paramsMap);

						} catch (NoSuchUserException nsue) {

							// do nothing

						}
					} else if ("removeFromSPGroup".equalsIgnoreCase(action)) {
						long selectedUserId = ParamUtil.getLong(renderRequest, "selectedUserId");

						// check privilege

						boolean privileged = false;
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil.findByUserIdAndGroupIdAndStatus(
									themeDisplay.getUserId(), spGroupId, SPGroupUserStatus.APPROVE.getValue());

							if (spGroupUser.getRole() == SPGroupUserType.ADMIN.getValue()
									|| spGroupUser.getRole() == SPGroupUserType.OWNER.getValue()) {
								privileged = true;
							}
						} catch (NoSuchUserException nsue) {

						}

						if (privileged) {
							SPGroupUserLocalServiceUtil.deleteSPGroupUser(spGroupId, selectedUserId);
						}

					} else if ("promoteFromMemberToAdmin".equalsIgnoreCase(action)) {
						long selectedUserId = ParamUtil.getLong(renderRequest, "selectedUserId");

						// check privilege

						boolean privileged = false;
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil.findByUserIdAndGroupIdAndStatus(
									themeDisplay.getUserId(), spGroupId, SPGroupUserStatus.APPROVE.getValue());

							if (spGroupUser.getRole() == SPGroupUserType.OWNER.getValue()) {
								privileged = true;
							}
						} catch (NoSuchUserException nsue) {

						}

						if (privileged) {
							SPGroupUserLocalServiceUtil.updateSPGroupUserRole(spGroupId, selectedUserId,
									SPGroupUserType.ADMIN.getValue());
						}

					} else if ("promoteFromAdminToOwner".equalsIgnoreCase(action)) {
						long selectedUserId = ParamUtil.getLong(renderRequest, "selectedUserId");

						// check privilege

						boolean privileged = false;
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil.findByUserIdAndGroupIdAndStatus(
									themeDisplay.getUserId(), spGroupId, SPGroupUserStatus.APPROVE.getValue());

							if (spGroupUser.getRole() == SPGroupUserType.OWNER.getValue()) {
								privileged = true;
							}
						} catch (NoSuchUserException nsue) {

						}

						if (privileged) {
							SPGroupUserLocalServiceUtil.updateSPGroupUserRole(spGroupId, selectedUserId,
									SPGroupUserType.OWNER.getValue());
						}

					} else if ("demoteFromAdminToMember".equalsIgnoreCase(action)) {
						long selectedUserId = ParamUtil.getLong(renderRequest, "selectedUserId");

						// check privilege

						boolean privileged = false;
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil.findByUserIdAndGroupIdAndStatus(
									themeDisplay.getUserId(), spGroupId, SPGroupUserStatus.APPROVE.getValue());

							if (spGroupUser.getRole() == SPGroupUserType.OWNER.getValue()) {
								privileged = true;
							}
						} catch (NoSuchUserException nsue) {

						}

						if (privileged) {
							SPGroupUserLocalServiceUtil.updateSPGroupUserRole(spGroupId, selectedUserId,
									SPGroupUserType.MEMBER.getValue());
						}

					}

					else if ("stepDownFromOwnerToAdmin".equalsIgnoreCase(action)) {

						// check privilege

						boolean privileged = false;
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil.findByUserIdAndGroupIdAndStatus(
									themeDisplay.getUserId(), spGroupId, SPGroupUserStatus.APPROVE.getValue());

							if (spGroupUser.getRole() == SPGroupUserType.OWNER.getValue()) {
								privileged = true;
							}
						} catch (NoSuchUserException nsue) {

						}

						if (privileged) {
							List<SPGroupUser> owners = SPGroupUserLocalServiceUtil.findBySPGroupIdAndRole(spGroupId,
									SPGroupUserType.OWNER.getValue());

							if (owners.size() <= 1) {

								// skip last owner

								SessionErrors.add(renderRequest, "LASTOWNEROFTHISGROUP");
							} else {
								SPGroupUserLocalServiceUtil.updateSPGroupUserRole(spGroupId, themeDisplay.getUserId(),
										SPGroupUserType.ADMIN.getValue());
							}
						}

					} else if ("stepDownFromAdminToMember".equalsIgnoreCase(action)) {

						// check privilege

						boolean privileged = false;
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil.findByUserIdAndGroupIdAndStatus(
									themeDisplay.getUserId(), spGroupId, SPGroupUserStatus.APPROVE.getValue());

							if (spGroupUser.getRole() == SPGroupUserType.ADMIN.getValue()) {
								privileged = true;
							}
						} catch (NoSuchUserException nsue) {

						}

						if (privileged) {
							SPGroupUserLocalServiceUtil.updateSPGroupUserRole(spGroupId, themeDisplay.getUserId(),
									SPGroupUserType.MEMBER.getValue());
						}

					} else if ("stepDownFromOwnerToMember".equalsIgnoreCase(action)) {

						// check privilege

						boolean privileged = false;
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil.findByUserIdAndGroupIdAndStatus(
									themeDisplay.getUserId(), spGroupId, SPGroupUserStatus.APPROVE.getValue());

							if (spGroupUser.getRole() == SPGroupUserType.OWNER.getValue()) {
								privileged = true;
							}
						} catch (NoSuchUserException nsue) {

						}

						if (privileged) {
							List<SPGroupUser> owners = SPGroupUserLocalServiceUtil.findBySPGroupIdAndRole(spGroupId,
									SPGroupUserType.OWNER.getValue());

							if (owners.size() <= 1) {

								// skip last owner

								SessionErrors.add(renderRequest, "LASTOWNEROFTHISGROUP");
							} else {
								SPGroupUserLocalServiceUtil.updateSPGroupUserRole(spGroupId, themeDisplay.getUserId(),
										SPGroupUserType.MEMBER.getValue());
							}
						}

					} else if ("closeSPGroup".equalsIgnoreCase(action)) {

						// check privilege

						if (isCommunityAdmin) {
							spGroup.setStatus(SPGroupStatus.CLOSED.getValue());
							SPGroupLocalServiceUtil.updateSPGroup(spGroup);
							isSPGroupClosed = true;

							Indexer indexer = IndexerRegistryUtil.getIndexer(SPGroup.class);
							indexer.reindex(spGroup);
						}
					}

					renderRequest.setAttribute("isSPGroupClosed", isSPGroupClosed);

					if (!isSPGroupClosed) {
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil
									.getSPGroupUser(new SPGroupUserPK(spGroupId, themeDisplay.getUserId()));

							if (spGroupUser.getRole() == SPGroupUserType.OWNER.getValue()) {
								isOwner = true;
							}

							if (spGroupUser.getRole() == SPGroupUserType.ADMIN.getValue()) {
								isAdmin = true;
							}

							if (spGroupUser.getStatus() == SPGroupUserStatus.APPROVE.getValue()) {
								isMember = true;
							}

							if (spGroupUser.getStatus() == SPGroupUserStatus.REQUEST_PENDING.getValue()) {
								isWaitingForApproval = true;
							}

							if (spGroupUser.getStatus() == SPGroupUserStatus.REJECTED.getValue()) {
								isRejected = true;
							}

							if (spGroupUser.getStatus() == SPGroupUserStatus.INVITATION_UNCONFIRMED.getValue()) {
								isInvited = true;
							}

						} catch (NoSuchUserException nsue) {

						}

						renderRequest.setAttribute("isOwner", isOwner);
						renderRequest.setAttribute("isAdmin", isAdmin);
						renderRequest.setAttribute("isMember", isMember);
						renderRequest.setAttribute("isWaitingForApproval", isWaitingForApproval);
						renderRequest.setAttribute("isRejected", isRejected);
						renderRequest.setAttribute("isInvited", isInvited);

						renderRequest.setAttribute("isGroupPublic",
								spGroup.getType() == SPGroupType.PUBLIC.getValue() ? true : false);
						renderRequest.setAttribute("isGroupMembersOnly",
								spGroup.getType() == SPGroupType.MEMBERS_ONLY.getValue() ? true : false);
						renderRequest.setAttribute("isGroupAdmin",
								spGroup.getType() == SPGroupType.ADMIN.getValue() ? true : false);
						renderRequest.setAttribute("isAdmin",
								SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()) ? true : false);
						// members count

						int membersCount = SPGroupUserLocalServiceUtil.countBySPGroupIdAndStatus(spGroupId,
								SPGroupUserStatus.APPROVE.getValue());
						renderRequest.setAttribute("membersCount", membersCount);

						// discussions count

						long classNameId = ClassNameLocalServiceUtil.getClassNameId(SPGroup.class);
						String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);
						MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(
								themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), SPGroup.class.getName(),
								spGroup.getSpGroupId(), WorkflowConstants.STATUS_ANY, threadView);
						MBThread thread = messageDisplay.getThread();
						MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
						MBMessage rootMessage = null;

						if (treeWalker != null) {
							rootMessage = treeWalker.getRoot();
						} else {
							rootMessage = MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
						}

						DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class,
								PortalClassLoaderUtil.getClassLoader());
						dynamicQuery
								.add(PropertyFactoryUtil.forName("messageId").ne(new Long(rootMessage.getMessageId())));
						dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(rootMessage.getMessageId()));
						dynamicQuery.add(PropertyFactoryUtil.forName("classPK").eq(new Long(spGroup.getSpGroupId())));
						dynamicQuery.add(PropertyFactoryUtil.forName("classNameId").eq(new Long(classNameId)));
						dynamicQuery.addOrder(OrderFactoryUtil.desc("modifiedDate"));
						long discussionsCount = MBMessageLocalServiceUtil.dynamicQueryCount(dynamicQuery);
						renderRequest.setAttribute("discussionsCount", discussionsCount);
						renderRequest.setAttribute("parentCount", discussionsCount);

						// tabs

						String tab1 = ParamUtil.getString(renderRequest, "tab1");
						renderRequest.setAttribute("tab1", tab1);

						if ("members".equalsIgnoreCase(tab1)) {
							List<SPGroupUser> spGroupUsers = SPGroupUserLocalServiceUtil
									.findBySPGroupIdAndStatus(spGroupId, SPGroupUserStatus.APPROVE.getValue(), 0, 9);
							List<SPGroupMemberWrapper> spGroupMemberWrappers = new ArrayList<SPGroupMemberWrapper>();

							for (SPGroupUser spGroupMember : spGroupUsers) {
								SPGroupMemberWrapper spGroupMemberWrapper = new SPGroupMemberWrapper();
								spGroupMemberWrapper.setSpGroupId(spGroupId);
								spGroupMemberWrapper.setRole(spGroupMember.getRole());
								long memberId = spGroupMember.getUserId();
								spGroupMemberWrapper.setUserId(memberId);
								User member = null;
								try {
									member = UserLocalServiceUtil.getUser(memberId);
									spGroupMemberWrapper.setUserName(member.getFullName());
									spGroupMemberWrapper.setScreenName(member.getScreenName());
									spGroupMemberWrapper.setPortraitId(member.getPortraitId());
								} catch (com.liferay.portal.NoSuchUserException nsue) {

									// do nothing

								}

								spGroupMemberWrappers.add(spGroupMemberWrapper);
							}

							renderRequest.setAttribute("spGroupMemberWrappers", spGroupMemberWrappers);

							try {
								spGroupUser = SPGroupUserLocalServiceUtil.findByUserIdAndGroupIdAndStatus(
										themeDisplay.getUserId(), spGroupId, SPGroupUserStatus.APPROVE.getValue());

								if (spGroupUser.getRole() == SPGroupUserType.OWNER.getValue()
										|| spGroupUser.getRole() == SPGroupUserType.ADMIN.getValue()) {
									List<SPGroupUser> spGroupPendingUsers = SPGroupUserLocalServiceUtil
											.findBySPGroupIdAndStatus(spGroupId,
													SPGroupUserStatus.REQUEST_PENDING.getValue());
									List<SPGroupMemberWrapper> spGroupPendingUserWrappers = new ArrayList<SPGroupMemberWrapper>();

									for (SPGroupUser spGroupPendingUser : spGroupPendingUsers) {
										SPGroupMemberWrapper spGroupMemberWrapper = new SPGroupMemberWrapper();
										spGroupMemberWrapper.setSpGroupId(spGroupId);
										spGroupMemberWrapper.setRole(spGroupPendingUser.getRole());
										long memberId = spGroupPendingUser.getUserId();
										spGroupMemberWrapper.setUserId(memberId);
										User member = null;
										try {
											member = UserLocalServiceUtil.getUser(memberId);
											spGroupMemberWrapper.setUserName(member.getFullName());
											spGroupMemberWrapper.setScreenName(member.getScreenName());
											spGroupMemberWrapper.setPortraitId(member.getPortraitId());
										} catch (com.liferay.portal.NoSuchUserException nsue) {

											// do nothing

										}

										spGroupPendingUserWrappers.add(spGroupMemberWrapper);
									}

									renderRequest.setAttribute("spGroupPendingUserWrappers",
											spGroupPendingUserWrappers);

								}
							} catch (NoSuchUserException nsue) {

								// do nothing

							}

						} else if ("admin".equalsIgnoreCase(tab1)) {
							List<SPGroupUser> spGroupOwners = SPGroupUserLocalServiceUtil
									.findBySPGroupIdAndRole(spGroupId, SPGroupUserType.OWNER.getValue());

							List<SPGroupMemberWrapper> spGroupOwnerWrappers = new ArrayList<SPGroupMemberWrapper>();

							for (SPGroupUser spGroupOwner : spGroupOwners) {
								SPGroupMemberWrapper spGroupOwnerWrapper = new SPGroupMemberWrapper();
								spGroupOwnerWrapper.setSpGroupId(spGroupId);
								long memberId = spGroupOwner.getUserId();
								spGroupOwnerWrapper.setUserId(memberId);
								spGroupOwnerWrapper.setRole(spGroupOwner.getRole());
								User member = null;
								try {
									member = UserLocalServiceUtil.getUser(memberId);
									spGroupOwnerWrapper.setUserName(member.getFullName());
									spGroupOwnerWrapper.setScreenName(member.getScreenName());
									spGroupOwnerWrapper.setPortraitId(member.getPortraitId());
								} catch (com.liferay.portal.NoSuchUserException nsue) {

									// do nothing

								}

								spGroupOwnerWrappers.add(spGroupOwnerWrapper);
							}

							List<SPGroupUser> spGroupAdmins = SPGroupUserLocalServiceUtil
									.findBySPGroupIdAndRole(spGroupId, SPGroupUserType.ADMIN.getValue(), 0, 9);

							List<SPGroupMemberWrapper> spGroupAdminWrappers = new ArrayList<SPGroupMemberWrapper>();

							for (SPGroupUser spGroupAdmin : spGroupAdmins) {
								SPGroupMemberWrapper spGroupAdminWrapper = new SPGroupMemberWrapper();
								spGroupAdminWrapper.setSpGroupId(spGroupId);
								long memberId = spGroupAdmin.getUserId();
								spGroupAdminWrapper.setUserId(memberId);
								spGroupAdminWrapper.setRole(spGroupAdmin.getRole());
								User member = null;
								try {
									member = UserLocalServiceUtil.getUser(memberId);
									spGroupAdminWrapper.setUserName(member.getFullName());
									spGroupAdminWrapper.setScreenName(member.getScreenName());
									spGroupAdminWrapper.setPortraitId(member.getPortraitId());
								} catch (com.liferay.portal.NoSuchUserException nsue) {

									// do nothing

								}

								spGroupAdminWrappers.add(spGroupAdminWrapper);
							}

							renderRequest.setAttribute("spGroupOwnerWrappers", spGroupOwnerWrappers);
							renderRequest.setAttribute("spGroupAdminWrappers", spGroupAdminWrappers);
						} else if ("invite_friends".equalsIgnoreCase(tab1)) {
							String tab2 = ParamUtil.getString(renderRequest, "tab2");
							renderRequest.setAttribute("tab2", tab2);

							String fbAppId = FacebookConnectUtil.getAppId(themeDisplay.getCompanyId());
							renderRequest.setAttribute("fbAppId", fbAppId);

						} else {
							javax.portlet.PortletURL viewSPGroupDiscussionPortletURL = null;
							try {
								com.liferay.portal.model.Layout viewSPGroupDiscussionLayout = com.liferay.portal.service.LayoutLocalServiceUtil
										.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false,
												"/discussion-detail");
								long viewSPGroupDiscussionPlid = viewSPGroupDiscussionLayout.getPlid();

								viewSPGroupDiscussionPortletURL = com.liferay.portlet.PortletURLFactoryUtil.create(
										renderRequest, "SPGroupDiscussionDetail_WAR_SPGroupportlet",
										viewSPGroupDiscussionPlid, javax.portlet.PortletRequest.RENDER_PHASE);
								viewSPGroupDiscussionPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
								viewSPGroupDiscussionPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
								viewSPGroupDiscussionPortletURL.setParameter("struts_action",
										"/discussions/view_discussion");
								viewSPGroupDiscussionPortletURL.setParameter("urlTitle", urlTitle);
								viewSPGroupDiscussionPortletURL.setParameter("spGroupId", String.valueOf(spGroupId));

							} catch (com.liferay.portal.NoSuchLayoutException e) {

								// do nothing

							}

							// TODO see commented section
							boolean commentServiceHasAccess = true;
							String commentServiceUserStatus = "";
							String commentServiceStrutsAction = StringPool.BLANK;
							SPParameter commentServiceParameter = SPParameterLocalServiceUtil
									.findBySPParameterGroupIdAndName(themeDisplay.getScopeGroupId(),
											SambaashConstants.MEMBERSHIP_SERVICECOMPONENTS.SPGROUP_COMMENT);
							commentServiceStrutsAction = commentServiceParameter.getValue();
							Map<String, Object> parameterMap = new HashMap<String, Object>();
							parameterMap.put("struts_action", commentServiceStrutsAction);
							parameterMap.put("groupId", new Long(themeDisplay.getScopeGroupId()));

							/*
							 * Map<String, Object> commentServiceHasAccessMap =
							 * ServiceComponentsLocalServiceUtil.hasAccess(
							 * parameterMap, themeDisplay.getUser());
							 * commentServiceHasAccess =
							 * (Boolean)commentServiceHasAccessMap.get(
							 * SambaashConstants.MEMBERSHIP.SERVICE_HASACCESS);
							 * commentServiceUserStatus =
							 * (String)commentServiceHasAccessMap.get(
							 * SambaashConstants.MEMBERSHIP.SERVICE_REDIRECTURL)
							 * ;
							 * 
							 * renderRequest.setAttribute(
							 * "commentServiceHasAccess",
							 * commentServiceHasAccess);
							 * renderRequest.setAttribute(
							 * "commentServiceUserStatus",
							 * commentServiceUserStatus);
							 */
							_commentServiceHasAccess = commentServiceHasAccess;
							_commentServiceUserStatus = commentServiceUserStatus;

							/*
							 * End comment
							 */

							renderRequest.setAttribute("commentServiceHasAccess", commentServiceHasAccess);
							renderRequest.setAttribute("commentServiceUserStatus", commentServiceUserStatus);
						}

						// social sharing

						HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
						HttpServletRequest originalServletRequest = PortalUtil.getOriginalServletRequest(request);

						Date now = new Date();

						String ogImage = PortalUtil.getPortalURL(renderRequest) + "/image/image_gallery?img_id="
								+ spGroup.getImageId() + "&t=" + now.getTime();

						String spGroupDetailURL = StringPool.BLANK;
						Layout spGroupDetailLayout = null;
						try {
							spGroupDetailLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(
									themeDisplay.getScopeGroupId(), false, "/" + groupDetailPageName);
						} catch (com.liferay.portal.NoSuchLayoutException e) {

							// do nothing

						}

						if (spGroupDetailLayout != null) {
							long spGroupDetailPlid = spGroupDetailLayout.getPlid();

							PortletURL spGroupDetailPortletURL = PortletURLFactoryUtil.create(renderRequest,
									SPGroupConstants.PORTLET_ID_GROUP_DETAIL, spGroupDetailPlid, PortletRequest.RENDER_PHASE);
							spGroupDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
							spGroupDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
							spGroupDetailPortletURL.setParameter("struts_action", "/groups/view_entry");
							spGroupDetailPortletURL.setParameter("urlTitle", urlTitle);
							spGroupDetailPortletURL.setParameter("spGroupId", String.valueOf(spGroupId));
							spGroupDetailURL = spGroupDetailPortletURL.toString();

						}

						SambaashUtil.setOGUrl(spGroupDetailURL, originalServletRequest);
						SambaashUtil.setOGImage(ogImage, originalServletRequest);
						SambaashUtil.setOGTitle(spGroup.getTitle(), originalServletRequest);
						SambaashUtil.setOGDescription(spGroup.getDescription(), originalServletRequest);

					}

				}

			} catch (NoSuchSPGroupException nsspge) {

			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	private void deleteUserNotification(Long notificationId) {
		try {
			if (Validator.isNotNull(notificationId)){
				UserNotificationEventLocalServiceUtil.deleteUserNotificationEvent(notificationId);
			}
		} catch (Exception e){
			//ignore
		}
	}

	private PortletURL getGroupDetailURL(PortletRequest request,
			ThemeDisplay themeDisplay, String groupDetailPageName,
			String urlTitle, long spGroupId) throws PortalException,
			SystemException, WindowStateException, PortletModeException {
		Layout spGroupDetailLayout = null;
		try {
			spGroupDetailLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(
					themeDisplay.getScopeGroupId(), false, "/" + groupDetailPageName);
		} catch (com.liferay.portal.NoSuchLayoutException e) {

			// do nothing

		}
		PortletURL spGroupDetailPortletURL = null;
		if (spGroupDetailLayout != null) {
			long spGroupDetailPlid = spGroupDetailLayout.getPlid();

			spGroupDetailPortletURL = PortletURLFactoryUtil.create(request,
					SPGroupConstants.PORTLET_ID_GROUP_DETAIL, spGroupDetailPlid,
					PortletRequest.RENDER_PHASE);
			spGroupDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
			spGroupDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
			spGroupDetailPortletURL.setParameter("struts_action", "/groups/view_entry");
			spGroupDetailPortletURL.setParameter("urlTitle", urlTitle);
			spGroupDetailPortletURL.setParameter("spGroupId", String.valueOf(spGroupId));

		}
		return spGroupDetailPortletURL;
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		PortletPreferences preferences = actionRequest.getPreferences();
		String groupDetailPageName = preferences.getValue("groupDetailPageName", "group-detail");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			String action = ParamUtil.getString(actionRequest, "action");

			if (Constants.EDIT.equalsIgnoreCase(action)) {
				String twShareText = ParamUtil.getString(actionRequest, "twShareText");
				String gplusShareText = ParamUtil.getString(actionRequest, "gplusShareText");
				String googleClientId = ParamUtil.getString(actionRequest, "googleClientId");
				preferences.setValue("twShareText", twShareText);
				preferences.setValue("gplusShareText", gplusShareText);
				preferences.setValue("googleClientId", googleClientId);

				groupDetailPageName = ParamUtil.getString(actionRequest, "groupDetailPageName");
				String groupCreatePageName = ParamUtil.getString(actionRequest, "groupCreatePageName");

				preferences.setValue("groupDetailPageName", groupDetailPageName);
				preferences.setValue("groupCreatePageName", groupCreatePageName);

				preferences.store();

				// actionResponse.setPortletMode(PortletMode.VIEW);

				addSuccessMessage(actionRequest, actionResponse);
			} else if ("editSettings".equalsIgnoreCase(action)) {
				long spGroupId = ParamUtil.getLong(actionRequest, "spGroupId");
				String urlTitle = ParamUtil.getString(actionRequest, "urlTitle");

				boolean dIn = ParamUtil.getBoolean(actionRequest, "dIn");
				boolean dGoogle = ParamUtil.getBoolean(actionRequest, "dGoogle");
				boolean dFb = ParamUtil.getBoolean(actionRequest, "dFb");
				boolean dTw = ParamUtil.getBoolean(actionRequest, "dTw");

				boolean cIn = ParamUtil.getBoolean(actionRequest, "cIn");
				boolean cGoogle = ParamUtil.getBoolean(actionRequest, "cGoogle");
				boolean cFb = ParamUtil.getBoolean(actionRequest, "cFb");
				boolean cTw = ParamUtil.getBoolean(actionRequest, "cTw");

				boolean enableSubscribeToComments = ParamUtil.getBoolean(actionRequest, "enableSubscribeToComments");
				boolean enableGroupUpdateNotification = ParamUtil.getBoolean(actionRequest,
						"enableGroupUpdateNotification");

				String updateFrequency = ParamUtil.getString(actionRequest, "updateFrequency");

				boolean edit = false;
				SPGroupPref spGroupPref = null;
				try {
					spGroupPref = SPGroupPrefLocalServiceUtil.getSPGroupPref(spGroupId);
					edit = true;
				} catch (NoSuchPrefException nspe) {

					// do nothing

				}

				if (!edit) {
					spGroupPref = SPGroupPrefLocalServiceUtil.createSPGroupPref(spGroupId);
				}

				spGroupPref.setDIn(dIn);
				spGroupPref.setDGoogle(dGoogle);
				spGroupPref.setDFb(dFb);
				spGroupPref.setDTw(dTw);

				spGroupPref.setCIn(cIn);
				spGroupPref.setCGoogle(cGoogle);
				spGroupPref.setCFb(cFb);
				spGroupPref.setCTw(cTw);

				spGroupPref.setEnableSubscribeToComments(enableSubscribeToComments);

				spGroupPref.setEnableGroupUpdateNotification(enableGroupUpdateNotification);

				// spGroupPref.setEnableMemberUpdate(enableMemberUpdate);
				// spGroupPref.setEnableDiscussionUpdate(enableDiscussionUpdate);

				if (enableGroupUpdateNotification) {
					spGroupPref.setUpdateFrequency(updateFrequency);

					// scheduler

					String cronExpression = StringPool.BLANK;

					if (updateFrequency.equalsIgnoreCase("Daily")) {
						cronExpression = SambaashUtil.getParameter(SambaashConstants.DAILY_CRON_EXPRESSION,
								themeDisplay.getScopeGroupId());
					} else if (updateFrequency.equalsIgnoreCase("Weekly")) {
						cronExpression = SambaashUtil.getParameter(SambaashConstants.WEEKLY_CRON_EXPRESSION,
								themeDisplay.getScopeGroupId());
					} else if (updateFrequency.equalsIgnoreCase("Monthly")) {
						cronExpression = SambaashUtil.getParameter(SambaashConstants.MONTHLY_CRON_EXPRESSION,
								themeDisplay.getScopeGroupId());
					} else if (updateFrequency.equalsIgnoreCase("Yearly")) {
						cronExpression = SambaashUtil.getParameter(SambaashConstants.YEARLY_CRON_EXPRESSION,
								themeDisplay.getScopeGroupId());
					}

					SPGroupUpdatesUtil.schedule(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), spGroupId,
							themeDisplay.getUserId(), updateFrequency, cronExpression);

				} else {
					SPGroupUpdatesUtil.delete(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), spGroupId,
							themeDisplay.getUserId());
				}

				SPGroupPrefLocalServiceUtil.updateSPGroupPref(spGroupPref);

				String spGroupDetailURL = StringPool.BLANK;
				Layout spGroupDetailLayout = null;
				try {
					spGroupDetailLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(),
							false, "/" + groupDetailPageName);
				} catch (com.liferay.portal.NoSuchLayoutException e) {

					// do nothing

				}

				if (spGroupDetailLayout != null) {
					long spGroupDetailPlid = spGroupDetailLayout.getPlid();

					PortletURL spGroupDetailPortletURL = PortletURLFactoryUtil.create(actionRequest,
							SPGroupConstants.PORTLET_ID_GROUP_DETAIL, spGroupDetailPlid, PortletRequest.RENDER_PHASE);
					spGroupDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
					spGroupDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
					spGroupDetailPortletURL.setParameter("struts_action", "/groups/view_entry");
					spGroupDetailPortletURL.setParameter("urlTitle", urlTitle);
					spGroupDetailPortletURL.setParameter("spGroupId", String.valueOf(spGroupId));
					spGroupDetailPortletURL.setParameter("tab1", "settings");
					spGroupDetailURL = spGroupDetailPortletURL.toString();
					actionResponse.sendRedirect(spGroupDetailURL);
				}

			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			PortletPreferences preferences = resourceRequest.getPreferences();
			String action = ParamUtil.getString(resourceRequest, "action");
			if ("retrieveComments".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter()
						.write(retrieveCommentsJsonString(resourceRequest, resourceResponse, themeDisplay));
			} else if ("retrieveReplies".equalsIgnoreCase(action)) {

				// resourceResponse.setContentType("application/json");
				// resourceResponse.setCharacterEncoding("utf-8");
				// resourceResponse.getWriter().write(retrieveRepliesJsonString(resourceRequest,
				// themeDisplay));

			} else if ("addComment".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter()
						.write(addCommentJsonString(resourceRequest, resourceResponse, themeDisplay));
			} else if ("addReply".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(addReplyJsonString(resourceRequest, themeDisplay));
			} else if ("deleteComment".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(deleteCommentJsonString(resourceRequest));
			} else if ("attachLink".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(attachLinkJsonString(resourceRequest));
			} else if ("findInvitePeopleSuggestions".equalsIgnoreCase(action)) {
				String inviteBy = resourceRequest.getParameter("invite_by");
				//_log.error("entered value email inviteBy " + inviteBy);
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");

				if ("email".equalsIgnoreCase(inviteBy)) {
					resourceResponse.getWriter().write(
							findInvitePeopleSuggestionsByEmailJsonString(resourceRequest, themeDisplay.getCompanyId()));
				}

			}

			else if ("inviteFriends".equalsIgnoreCase(action)) {
				String inviteBy = resourceRequest.getParameter("invite_by");
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");

				if ("email".equalsIgnoreCase(inviteBy)) {
					resourceResponse.getWriter().write(inviteFriendsByEmailJsonString(themeDisplay, resourceRequest,
							resourceResponse, preferences));
				}

			} else if ("subscribeToComments".equalsIgnoreCase(action)) {
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter()
						.write(subscribeToCommentsJsonString(resourceRequest, resourceResponse, themeDisplay));
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	public String subscribeToCommentsJsonString(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ThemeDisplay themeDisplay) throws Exception {

		boolean subscribe = ParamUtil.getBoolean(resourceRequest, "subscribe");
		String className = ParamUtil.getString(resourceRequest, "className");
		long classPK = ParamUtil.getLong(resourceRequest, "classPK");

		if (subscribe) {
			subscribeToComments(resourceRequest, themeDisplay, true, className, classPK);
		} else {
			subscribeToComments(resourceRequest, themeDisplay, false, className, classPK);
		}

		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		dataJSONObject.put("subscribe", subscribe);
		dataJSONObject.put("className", className);
		dataJSONObject.put("classPK", classPK);
		return dataJSONObject.toString();
	}

	private void subscribeToComments(ResourceRequest resourceRequest, ThemeDisplay themeDisplay, boolean subscribe,
			String className, long classPK) throws Exception {

		if (subscribe) {
			SubscriptionLocalServiceUtil.addSubscription(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
					className, classPK);
		} else {
			SubscriptionLocalServiceUtil.deleteSubscription(themeDisplay.getUserId(), className, classPK);
		}
	}

	private String inviteFriendsByEmailJsonString(ThemeDisplay themeDisplay, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, PortletPreferences preferences)
			throws PortalException, PortletModeException, SystemException, WindowStateException {

		String groupDetailPageName = preferences.getValue("groupDetailPageName", "group-detail");
		String urlTitle = ParamUtil.getString(resourceRequest, "url_title");
		long spGroupId = ParamUtil.getLong(resourceRequest, "sp_group_id");
		String sendToStr = ParamUtil.getString(resourceRequest, "send_to");
		String comment = ParamUtil.getString(resourceRequest, "comment");
		String[] sendTos = StringUtil.split(sendToStr, StringPool.COMMA);
		String portalURL = PortalUtil.getPortalURL(resourceRequest);
		String portalSigninUrl = portalURL + "/signin?redirect=";
		SPGroup spGroup = null;

		if (spGroupId > 0) {
			try {
				spGroup = SPGroupLocalServiceUtil.getSPGroup(spGroupId);

				String senderProfileURL = portalURL + StringPool.SLASH + themeDisplay.getUser().getScreenName();
				String senderName = themeDisplay.getUser().getFullName();

				String groupTitle = spGroup.getTitle();
				String spGroupDetailURL = StringPool.BLANK;
				String joinSPGroupURL = StringPool.BLANK;
				Layout spGroupDetailLayout = null;
				try {
					spGroupDetailLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(),
							false, "/" + groupDetailPageName);
				} catch (com.liferay.portal.NoSuchLayoutException e) {

					// do nothing

				}

				if (spGroupDetailLayout != null) {
					long spGroupDetailPlid = spGroupDetailLayout.getPlid();

					PortletURL spGroupDetailPortletURL = PortletURLFactoryUtil.create(resourceRequest,
							SPGroupConstants.PORTLET_ID_GROUP_DETAIL, spGroupDetailPlid, PortletRequest.RENDER_PHASE);
					spGroupDetailPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
					spGroupDetailPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
					spGroupDetailPortletURL.setParameter("struts_action", "/groups/view_entry");
					spGroupDetailPortletURL.setParameter("urlTitle", urlTitle);
					spGroupDetailPortletURL.setParameter("spGroupId", String.valueOf(spGroupId));
					spGroupDetailURL = spGroupDetailPortletURL.toString();

					PortletURL joinSPGroupPortletURL = PortletURLFactoryUtil.create(resourceRequest,
							SPGroupConstants.PORTLET_ID_GROUP_DETAIL, spGroupDetailPlid, PortletRequest.RENDER_PHASE);
					joinSPGroupPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
					joinSPGroupPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
					joinSPGroupPortletURL.setParameter("struts_action", "/groups/view_entry");
					joinSPGroupPortletURL.setParameter("urlTitle", urlTitle);
					joinSPGroupPortletURL.setParameter("action", "joinSPGroup");
					joinSPGroupPortletURL.setParameter("spGroupId", String.valueOf(spGroupId));
					joinSPGroupURL = joinSPGroupPortletURL.toString();
					joinSPGroupURL = SambaashUtil.getPortalURL(themeDisplay.getCompanyId(),
							themeDisplay.getScopeGroupId()) + "/signin?redirect=" + joinSPGroupURL;
				}

				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("senderProfileURL", senderProfileURL);
				paramsMap.put("joinGroupURL", joinSPGroupURL);
				paramsMap.put("groupDetailURL", spGroupDetailURL);
				paramsMap.put("groupTitle", groupTitle);
				paramsMap.put("senderId", themeDisplay.getUserId());
				paramsMap.put("senderName", senderName);
				paramsMap.put("comment", comment);
				paramsMap.put("portalSigninUrl", portalSigninUrl);

				String[] internalInvitationTitleAndBody = getInternalInvitationTitleAndBody(paramsMap);

				String externalInvitationTitle = preferences.getValue("groupInvitationSubject", StringPool.BLANK);
				String externalInvitationBody = preferences.getValue("groupInvitationBody", StringPool.BLANK);

				spGroupDetailURL = SambaashUtil.getPortalURL(themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId()) + "/signin?redirect=" + spGroupDetailURL;
				paramsMap.put("groupDetailURL", spGroupDetailURL);

				String[] externalInvitationTitleAndBody = getExternalInvitationTitleAndBody(externalInvitationTitle,
						externalInvitationBody, paramsMap);

				// add IBMessage

				String inviteEmailsStr = StringPool.BLANK;

				List<User> toUsers = new ArrayList<User>();
				List<String> toEmails = new ArrayList<String>();

				for (String sendTo : sendTos) {
					long sendToUserId = 0;
					try {
						sendToUserId = Long.valueOf(sendTo);
					} catch (NumberFormatException nfe) {

						// do nothing

					}

					if (sendToUserId != 0) {
						try {
							User toUser = UserLocalServiceUtil.getUser(sendToUserId);
							toUsers.add(toUser);

							if (inviteEmailsStr.length() > 0) {
								inviteEmailsStr += StringPool.COMMA;
							}

							inviteEmailsStr += toUser.getEmailAddress();
						} catch (com.liferay.portal.NoSuchUserException nsue) {

						}
					} else {
						toEmails.add(sendTo);
					}
				}

				IBMessage ibmessage = ActionUtil.addIBMessage(themeDisplay.getScopeGroupId(),
						themeDisplay.getCompanyId(), spGroupId, themeDisplay.getUser().getFullName(),
						themeDisplay.getUser().getUserId(), themeDisplay.getUser().getEmailAddress(), inviteEmailsStr,
						internalInvitationTitleAndBody[0], internalInvitationTitleAndBody[1]);

				// send email

				for (User toUser : toUsers) {
					try {
						SPGroupUser spGroupUser = SPGroupUserLocalServiceUtil
								.getSPGroupUser(new SPGroupUserPK(spGroupId, toUser.getUserId()));

						if (SPGroupUserStatus.APPROVE.getValue() != spGroupUser.getStatus()) {
							spGroupUser.setStatus(SPGroupUserStatus.INVITATION_UNCONFIRMED.getValue());
							SPGroupUserLocalServiceUtil.updateSPGroupUser(spGroupUser);
						}

						// send internally

						ActionUtil.addIBMessageDetail(themeDisplay.getCompanyId(), ibmessage, toUser.getUserId(),
								toUser.getFullName(), "Pending", "invitation", spGroupUser.getUserId());
						
					} catch (NoSuchUserException nsue) {
						SPGroupUserLocalServiceUtil.addSPGroupUser(spGroupId, toUser.getUserId(),
								SPGroupUserType.MEMBER.getValue(), SPGroupUserStatus.INVITATION_UNCONFIRMED.getValue(),
								spGroup.getGroupId(), spGroup.getCompanyId());
					} finally {
						PortletURL detailsUrl = getGroupDetailURL(
								resourceRequest, themeDisplay, groupDetailPageName,
								urlTitle, spGroupId);
						sendUserInvitedNotification(
								spGroup,
								detailsUrl,
								toUser.getUserId(), themeDisplay.getUserId(), resourceRequest);
					}

					// and externally

					sendExternalEmail(themeDisplay.getCompanyId(), externalInvitationTitleAndBody[0],
							externalInvitationTitleAndBody[1], toUser.getFullName(), toUser.getEmailAddress(),
							paramsMap);

				}

				for (String toEmail : toEmails) {

					// send externally

					String toName = toEmail.substring(0, toEmail.indexOf(StringPool.AT));
					sendExternalEmail(themeDisplay.getCompanyId(), externalInvitationTitleAndBody[0],
							externalInvitationTitleAndBody[1], toName, toEmail, paramsMap);

				}

			} catch (NoSuchSPGroupException nsspge) {

				// do nothing

			}
		}

		String successMsg = StringPool.BLANK;
		successMsg = "Your request has been processed successfully!";

		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		dataJSONObject.put("success_msg", successMsg);
		return dataJSONObject.toString();
	}

	@SuppressWarnings("unchecked")
	private String findInvitePeopleSuggestionsByEmailJsonString(ResourceRequest resourceRequest, long companyId)
			throws PortalException, SystemException {
		long spGroupId = ParamUtil.getLong(resourceRequest, "group_id");
		_log.error("findInvitePeopleSuggestionsByEmailJsonString groupId " + spGroupId);
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String q = ParamUtil.getString(resourceRequest, "q");
		
		String ctx = resourceRequest.getContextPath();

		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray itemsJSONArray = JSONFactoryUtil.createJSONArray();

		String suggestion = "<div data-autocomplete-dom-id=\"option\" data-user-id=\"" + "%d"
				+ "\" %s><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Auto Complete Image\" data-autocomplete-dom-id=\"option-img\" src=\""
				+ "%s"
				+ "\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-oh\"><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><span data-autocomplete-dom-id=\"option-name\" class=\"sp-group-fwb\">"
				+ "%s ( %s )" + "</span></div></div></div></div></div>";

		String suggestinByMail = "<div data-autocomplete-dom-id=\"option\" data-user-id=\"0\" class=\"ip-sb-option\"><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Auto Complete Image\" src=\""
				+ ctx
				+ "/images/send_by_email.png\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-oh\"><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><div class=\"sp-group-ui-lh1 mtxs mbs\">Send an email to</div><div data-autocomplete-dom-id=\"option-email\" class=\"sp-group-ui-lh1 sp-group-fwb\">"
				+ "%s" + "</div></div></div></div></div></div>";

		List<User> matchedUsers = new ArrayList<User>();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class,
				PortalClassLoaderUtil.getClassLoader());

		if (Validator.isNotNull(q)) {
			try {

				dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class, PortalClassLoaderUtil.getClassLoader());
				Criterion criterion = RestrictionsFactoryUtil.ilike("emailAddress", q + "%");
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("screenName", q + "%"));

				String[] firstAndLastnameQ = StringUtil.split(q, StringPool.SPACE);
				String firstNameQ = StringPool.BLANK;
				String lastNameQ = StringPool.BLANK;

				if (firstAndLastnameQ.length == 2) {
					firstNameQ = firstAndLastnameQ[0].trim();
					lastNameQ = firstAndLastnameQ[1].trim();
					criterion = RestrictionsFactoryUtil.or(criterion,
							RestrictionsFactoryUtil.ilike("firstName", firstNameQ + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion,
							RestrictionsFactoryUtil.ilike("lastName", lastNameQ + "%"));
				}

				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("firstName", q + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("lastName", q + "%"));

				dynamicQuery.add(PropertyFactoryUtil.forName("emailAddressVerified").eq(new Boolean(true)));
				dynamicQuery.add(criterion);

				matchedUsers = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
				
				if(matchedUsers.isEmpty()){
					String email = q;
					_log.debug("entered value email email " + email);
					String html = "<div data-autocomplete-dom-id=\"option\" data-user-id=\"0\" class=\"ip-sb-option hover\"><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Auto Complete Image\" src=\""
							+ ctx
							+ "/images/send_by_email.png\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-oh\"><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><div class=\"sp-group-ui-lh1 mtxs mbs\">Send an email to</div><div data-autocomplete-dom-id=\"option-email\" class=\"sp-group-ui-lh1 sp-group-fwb\">"
							+ email + "</div></div></div></div></div></div>";

					_log.debug("entered value email html " + html);
					JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
					htmlJSONObject.put("html", html);
					itemsJSONArray.put(htmlJSONObject);
				}else{
					long userId;
					String username;
					String userImage;
					String html;
					boolean isFirst = true;
					String htmlClass;
					String userIdArray = "0";
					try{
						List<SPGroupUser> members = SPGroupUserLocalServiceUtil.findBySPGroupIdAndStatus(spGroupId,
								SPGroupUserStatus.APPROVE.getValue());
	
						for (int i = 0; i < members.size(); i++) {
							userIdArray = userIdArray + StringPool.COMMA + members.get(i).getUserId();
						}
					}catch(Exception e){
						_log.error("Error getting Group Members " + e.getMessage());
					}
					_log.error("userIdArray " + userIdArray);
					for (User user : matchedUsers) {
						if(user.getUserId() != themeDisplay.getUserId() && !userIdArray.contains(","+String.valueOf(user.getUserId()))){
							userId = user.getUserId();
							username = user.getFullName();
							userImage = getUserPortraitUrl((ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY), user.getPortraitId());
		
							if (isFirst) {
								isFirst = false;
								htmlClass = "class =\"ip-sb-option hover\"";
							} else {
								htmlClass = "class=\"ip-sb-option\"";
							}
		
							html = String.format(suggestion, userId, htmlClass, userImage, username, user.getEmailAddress());
							JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
							htmlJSONObject.put("html", html);
							itemsJSONArray.put(htmlJSONObject);
		
							html = String.format(suggestinByMail, user.getEmailAddress());
							htmlJSONObject = JSONFactoryUtil.createJSONObject();
							htmlJSONObject.put("html", html);
							itemsJSONArray.put(htmlJSONObject);
						}
					}
				}	
			} catch (Exception nsue) {
				String email = q;
				String html = "<div data-autocomplete-dom-id=\"option\" data-user-id=\"0\" class=\"ip-sb-option hover\"><div class=\"sp-group-clearfix\"><div class=\"sp-group-lfloat sp-group-mrm\" style=\"line-height: 0;\"><img alt=\"Auto Complete Image\" src=\""
						+ ctx
						+ "/images/send_by_email.png\" class=\"sp-group-thumb_32\" /></div><div class=\"sp-group-ui-oh\"><div class=\"sp-group-ui-dib\"><div class=\"sp-group-ui-dib sp-group-ui-vam\" style=\"height:32px;\"></div><div class=\"sp-group-ui-dib sp-group-ui-vam\"><div class=\"sp-group-ui-lh1 mtxs mbs\">Send an email to</div><div data-autocomplete-dom-id=\"option-email\" class=\"sp-group-ui-lh1 sp-group-fwb\">"
						+ email + "</div></div></div></div></div></div>";

				JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
				htmlJSONObject.put("html", html);
				itemsJSONArray.put(htmlJSONObject);

			}

		} else {

		}

		dataJSONObject.put("items", itemsJSONArray);
		return dataJSONObject.toString();
	}

	private String attachLinkJsonString(ResourceRequest resourceRequest) throws PortalException, SystemException {

		String link = resourceRequest.getParameter("link");

		if (link.trim().startsWith("www.")) {
			link = "http://" + link;
		}

		String content = StringPool.BLANK;
		try {
			String sourceHtml = Util.getHtmlByUrl(link);

			if (Validator.isNotNull(sourceHtml)) {
				content = Util.attachLink(link, sourceHtml, "UTF-8");
			}
		} catch (ParserException pe) {
			content = "<div>No preview available</div>";
		} catch (IOException ioe) {
			content = "<div>No preview available</div>";
		}

		String html = content;
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		dataJSONObject.put("html", html);
		return dataJSONObject.toString();
	}

	private String deleteCommentJsonString(ResourceRequest resourceRequest) throws PortalException, SystemException {

		String commentIdStr = resourceRequest.getParameter("comment_id");
		String isParentStr = resourceRequest.getParameter("is_parent");
		String classPK = resourceRequest.getParameter("class_pk");
		long commentId = 0;
		try {
			commentId = Long.valueOf(commentIdStr);
		} catch (NumberFormatException nfe) {
		}

		if ("true".equalsIgnoreCase(isParentStr)) {

			// delete children comments

			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class,
					PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(commentId)));
			@SuppressWarnings("unchecked")
			List<MBMessage> childComments = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery);

			for (MBMessage childComment : childComments) {
				MBMessageLocalServiceUtil.deleteMBMessage(childComment.getMessageId());
			}
		}

		// delete comment

		MBMessageLocalServiceUtil.deleteMBMessage(commentId);
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		dataJSONObject.put("comment_id", commentId);
		dataJSONObject.put("class_pk", classPK);
		return dataJSONObject.toString();
	}

	private String addCommentJsonString(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ThemeDisplay themeDisplay)
			throws PortalException, PortletModeException, SystemException, WindowStateException {

		String classPKStr = resourceRequest.getParameter("class_pk");
		long classPK = 0;
		try {
			classPK = Long.valueOf(classPKStr);
		} catch (NumberFormatException nfe) {
		}

		String groupImageIdStr = resourceRequest.getParameter("group_image_id");
		long groupImageId = 0;
		try {
			groupImageId = Long.valueOf(groupImageIdStr);
		} catch (NumberFormatException nfe) {
		}

		boolean isMember = false;
		SPGroupUser spGroupUser = null;
		try {
			spGroupUser = SPGroupUserLocalServiceUtil
					.getSPGroupUser(new SPGroupUserPK(classPK, themeDisplay.getUserId()));

			if (spGroupUser.getStatus() == SPGroupUserStatus.APPROVE.getValue()) {
				isMember = true;
			}

		} catch (NoSuchUserException nsue) {

		}

		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		String html = StringPool.BLANK;

		if (isMember) {
			String className = resourceRequest.getParameter("class_name");
			String title = resourceRequest.getParameter("title");
			String content = resourceRequest.getParameter("content");
			String linkContent = content.replaceAll("[\r\n]", StringPool.SPACE);
			String linkUrlList = SPGroupConstants.URL_LINKS_GROUP_COMMENTS;
			String[] linkUrls = linkUrlList.split(StringPool.SEMICOLON);
			for(String linkUrl : linkUrls){
				if(linkContent.contains(linkUrl)){
					String[] gethttpsurl = linkContent.split(StringPool.SPACE);
					for(int i = 0;i<gethttpsurl.length;i++){
						if(gethttpsurl[i].contains(linkUrl)){
							String setLink = "<a href=" + gethttpsurl[i] + " target='_blank'>" + gethttpsurl[i] + "</a>";
							content = content.replace(gethttpsurl[i], setLink);
						}
					}
				}
			}	
			_log.error("themeDisplay.getPortalURL() " + themeDisplay.getPortalURL());
			if(linkContent.contains(themeDisplay.getPortalURL())){
				String[] gethttpsurl = linkContent.split(StringPool.SPACE);
				for(int i = 0;i<gethttpsurl.length;i++){
					if(gethttpsurl[i].contains(themeDisplay.getPortalURL())){
						String setLink = "<a href=" + gethttpsurl[i] + " target='_blank'>" + gethttpsurl[i] + "</a>";
						content = content.replace(gethttpsurl[i], setLink);
					}
				}
			}
			if (Validator.isNull(content))
				content = content.replaceAll("[\r\n]", "<br>");
			String description = content;

			String attachContentImage = resourceRequest.getParameter("attach_content_image");
			String attachContentTitle = resourceRequest.getParameter("attach_content_title");
			String attachContentLink = resourceRequest.getParameter("attach_content_link");
			String attachContentDescription = resourceRequest.getParameter("attach_content_description");

			String attachContent = StringPool.BLANK;
			content += "<div style=\"position: relative;\">";

			if (Validator.isNotNull(attachContentImage)) {
				attachContent += "<div style=\"position: absolute;\">";
				attachContent += "<img alt=\"Image\" data-comment-dom-id=\"attach-content-image\" style=\"width: 50px; height: 50px; display: block;\" src=\""
						+ attachContentImage + "\">";
				attachContent += "</div><div style=\"margin-left: 60px; min-height: 50px;\">";
			} else {
				attachContent += "<div>";
			}

			attachContent += "<div><span data-comment-dom-id=\"attach-content-title\" class=\"sp-group-fsl\">"
					+ attachContentTitle + "</span></div>"
					+ "<p data-comment-dom-id=\"attach-content-link\" class=\"sp-group-fss sp-group-fcl\">"
					+ attachContentLink + "</p>"
					+ "<p data-comment-dom-id=\"attach-content-description\" class=\"sp-group-mts\">"
					+ attachContentDescription + "</p>" + "</div>";

			if (Validator.isNull(attachContentTitle)) {
				attachContent = StringPool.BLANK;
			}

			content += attachContent + "</div>";

			String urlTitle = ParamUtil.getString(resourceRequest, "urlTitle");

			long scopeGroupId = themeDisplay.getScopeGroupId();

			long currentUserId = themeDisplay.getUserId();
			String currentUserScreenName = themeDisplay.getUser().getScreenName();
			String currentUserFullName = themeDisplay.getUser().getFullName();
			long portraitId = themeDisplay.getUser().getPortraitId();

			String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);

			MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(currentUserId,
					scopeGroupId, className, classPK, WorkflowConstants.STATUS_ANY, threadView);

			MBThread thread = messageDisplay.getThread();
			MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
			MBMessage rootMessage = null;
			if (treeWalker != null) {
				rootMessage = treeWalker.getRoot();
			} else {
				rootMessage = MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
			}

			String viewSPGroupDiscussionURL = PortalUtil.getPortalURL(resourceRequest) + "/discussion-detail";
			javax.portlet.PortletURL viewSPGroupDiscussionPortletURL = null;
			try {
				com.liferay.portal.model.Layout createSPGroupLayout = com.liferay.portal.service.LayoutLocalServiceUtil
						.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, "/discussion-detail");
				long viewSPGroupDiscussionPlid = createSPGroupLayout.getPlid();

				viewSPGroupDiscussionPortletURL = com.liferay.portlet.PortletURLFactoryUtil.create(resourceRequest,
						"SPGroupDiscussionDetail_WAR_SPGroupportlet", viewSPGroupDiscussionPlid,
						javax.portlet.PortletRequest.RENDER_PHASE);
				viewSPGroupDiscussionPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
				viewSPGroupDiscussionPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
				viewSPGroupDiscussionPortletURL.setParameter("struts_action", "/discussions/view_discussion");
				viewSPGroupDiscussionPortletURL.setParameter("urlTitle", urlTitle);
				viewSPGroupDiscussionPortletURL.setParameter("spGroupId", String.valueOf(classPK));

			} catch (com.liferay.portal.NoSuchLayoutException e) {

				// do nothing

			}

			String subject = title;
			String body = content;
			ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(),
					resourceRequest);
			serviceContext.setAttribute("viewSPGroupDiscussionPortletURL",
					(Serializable) viewSPGroupDiscussionPortletURL);

			MBMessage mbmsg = MBMessageLocalServiceUtil.addDiscussionMessage(currentUserId, currentUserFullName,
					scopeGroupId, className, classPK, thread.getThreadId(), rootMessage.getMessageId(), subject, body,
					serviceContext);

			// mbmsg.setSubject(title); mbmsg.setBody(content);
			// MBMessageLocalServiceUtil.updateMBMessage(mbmsg);

			CommentBo parentCommentBo = new CommentBo(mbmsg);
			parentCommentBo.setScreenName(currentUserScreenName);
			parentCommentBo.setFullName(currentUserFullName);
			parentCommentBo.setPortraitId(portraitId);

			int cStart = 0;
			int cOffset = 3;
			long childCount = 0;
			parentCommentBo.setChildCount(childCount);

			if (viewSPGroupDiscussionPortletURL != null) {
				viewSPGroupDiscussionPortletURL.setParameter("discussionId", String.valueOf(mbmsg.getMessageId()));
				viewSPGroupDiscussionURL = viewSPGroupDiscussionPortletURL.toString();
			}

			parentCommentBo.setViewDiscussionURL(viewSPGroupDiscussionURL);

			html = getParentCommentHtml(resourceResponse, classPK, className, urlTitle, groupImageId, parentCommentBo,
					themeDisplay, cStart, cOffset, true);

			// social sharing

			try {
				SPGroupPref spGroupPref = SPGroupPrefLocalServiceUtil.getSPGroupPref(classPK);

				boolean dFb = spGroupPref.getDFb();
				boolean dIn = spGroupPref.getDIn();
				boolean dGoogle = spGroupPref.getDGoogle();
				boolean dTw = spGroupPref.getDTw();

				String imgUrl = "/image/image_gallery?img_id=" + groupImageId;
				SPSocialSharingLocalServiceUtil.postSPGroupToSocialNetworks(
						ClassNameLocalServiceUtil.getClassNameId(MBMessage.class), mbmsg.getMessageId(), title,
						description, viewSPGroupDiscussionURL, imgUrl, themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getUser(), dFb, dIn, dGoogle, dTw);

			} catch (NoSuchPrefException nspe) {

				// do nothing

			}

			// Notifications
			try {
				String groupDetailPageName = resourceRequest.getPreferences()
						.getValue("groupDetailPageName", "group-detail");
				PortletURL spGroupDetailPortletURL = getGroupDetailURL(
						resourceRequest, themeDisplay, groupDetailPageName,
						urlTitle, classPK);
				sendNewDiscussionNotification(
						SPGroupLocalServiceUtil.getSPGroup(classPK),
						spGroupDetailPortletURL.toString(),
						viewSPGroupDiscussionURL, title,
						themeDisplay.getUserId(), resourceRequest);
			} catch (Exception e) {

			}

			try {
				List<SPGroupUser> members = SPGroupUserLocalServiceUtil.findBySPGroupIdAndStatus(classPK,
						SPGroupUserStatus.APPROVE.getValue());
				StringBuilder toEmailsSb = new StringBuilder();
				List<Long> toUserIds = new ArrayList<Long>();
				List<String> toUsernames = new ArrayList<String>();

				for (int i = 0; i < members.size(); i++) {
					long userId = members.get(i).getUserId();
					try {
						User user = UserLocalServiceUtil.getUser(userId);
						toEmailsSb.append(user.getEmailAddress());
						toUserIds.add(user.getUserId());
						toUsernames.add(user.getFullName());

						if (i != members.size() - 1) {
							toEmailsSb.append(StringPool.COMMA);
						}
					} catch (Exception ex) {
						_log.error("Group update mail failed " + ex.getMessage());
					}
				}

				String portalURL = PortalUtil.getPortalURL(resourceRequest);
				String portalSigninUrl = portalURL + "/signin?redirect=";
				String senderProfileURL = portalURL + StringPool.SLASH + themeDisplay.getUser().getScreenName();
				String senderName = themeDisplay.getUser().getFullName();
				SPGroup spGroup = SPGroupLocalServiceUtil.getSPGroup(classPK);
				String groupTitle = spGroup.getTitle();

				/*
				 * Layout spGroupDetailLayout = null; try { spGroupDetailLayout
				 * = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.
				 * getScopeGroupId(), false, "/" + groupDetailPageName); } catch
				 * (com.liferay.portal.NoSuchLayoutException e) {
				 * 
				 * // do nothing
				 * 
				 * }
				 * 
				 * String spGroupDetailURL = "";
				 * 
				 * if (spGroupDetailLayout != null) { long spGroupDetailPlid =
				 * spGroupDetailLayout.getPlid();
				 * 
				 * PortletURL spGroupDetailPortletURL =
				 * PortletURLFactoryUtil.create( resourceRequest,
				 * "SPGroupDetail_WAR_SPGroupportlet", spGroupDetailPlid,
				 * PortletRequest.RENDER_PHASE);
				 * spGroupDetailPortletURL.setWindowState(javax.portlet.
				 * WindowState.NORMAL);
				 * spGroupDetailPortletURL.setPortletMode(javax.portlet.
				 * PortletMode.VIEW);
				 * spGroupDetailPortletURL.setParameter("struts_action",
				 * "/groups/view_entry");
				 * spGroupDetailPortletURL.setParameter("urlTitle", urlTitle);
				 * spGroupDetailPortletURL.setParameter("spGroupId",
				 * String.valueOf(classPK)); spGroupDetailURL =
				 * spGroupDetailPortletURL.toString(); }
				 */

				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("senderProfileURL", senderProfileURL);
				paramsMap.put("discussionUrl", viewSPGroupDiscussionURL);
				paramsMap.put("groupTitle", groupTitle);
				paramsMap.put("senderId", themeDisplay.getUserId());
				paramsMap.put("senderName", senderName);
				paramsMap.put("portalSigninUrl", portalSigninUrl);

				String array[] = getNewDiscThreadSubjectBody(paramsMap);
				IBMessage ibmessage = ActionUtil.addIBMessage(themeDisplay.getScopeGroupId(),
						themeDisplay.getCompanyId(), classPK, themeDisplay.getUser().getFullName(),
						themeDisplay.getUser().getUserId(), themeDisplay.getUser().getEmailAddress(),
						toEmailsSb.toString(), array[0], array[1]);

				for (int i = 0; i < toUserIds.size(); i++) {
					ActionUtil.addIBMessageDetail(themeDisplay.getCompanyId(), ibmessage, toUserIds.get(i),
							toUsernames.get(i), "Pending", "notification", toUserIds.get(i));

				}

			} catch (Exception ex) {

			}

		}

		dataJSONObject.put("html", html);
		dataJSONObject.put("class_pk", classPK);

		return dataJSONObject.toString();
	}

	private String addReplyJsonString(ResourceRequest resourceRequest, ThemeDisplay themeDisplay)
			throws PortalException, PortletModeException, SystemException, WindowStateException {

		String classPKStr = resourceRequest.getParameter("class_pk");
		String urlTitle = resourceRequest.getParameter("url_title");
		String className = resourceRequest.getParameter("class_name");
		String parentIdStr = resourceRequest.getParameter("parent_id");
		String content = resourceRequest.getParameter("content");

		String groupImageIdStr = resourceRequest.getParameter("groupImageId");
		long groupImageId = 0;
		try {
			groupImageId = Long.valueOf(groupImageIdStr);
		} catch (NumberFormatException nfe) {
		}

		long classPK = 0;
		try {
			classPK = Long.valueOf(classPKStr);
		} catch (NumberFormatException nfe) {
		}

		long parentId = 0;
		try {
			parentId = Long.valueOf(parentIdStr);
		} catch (NumberFormatException nfe) {
		}

		int workflowAction = WorkflowConstants.ACTION_PUBLISH;
		long currentUserId = themeDisplay.getUserId();
		String currentUserFullName = themeDisplay.getUser().getFullName();
		String currentUserScreenName = themeDisplay.getUser().getScreenName();
		long portraitId = themeDisplay.getUser().getPortraitId();

		MBMessage mbmsg = MBMessageLocalServiceUtil.addDiscussionMessage(currentUserId, currentUserFullName,
				themeDisplay.getScopeGroupId(), className, classPK, workflowAction);
		mbmsg.setParentMessageId(parentId);
		mbmsg.setBody(content);
		MBMessageLocalServiceUtil.updateMBMessage(mbmsg);
		CommentBo childCommentBo = new CommentBo(mbmsg);
		childCommentBo.setScreenName(currentUserScreenName);
		childCommentBo.setFullName(currentUserFullName);
		childCommentBo.setPortraitId(portraitId);

		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		String html = getChildCommentHtml(childCommentBo, themeDisplay, false, true);
		dataJSONObject.put("html", html);
		dataJSONObject.put("class_pk", classPK);
		dataJSONObject.put("parent_id", parentId);

		// social sharing

		try {
			SPGroupPref spGroupPref = SPGroupPrefLocalServiceUtil.getSPGroupPref(classPK);

			boolean cFb = spGroupPref.getCFb();
			boolean cIn = spGroupPref.getCIn();
			boolean cGoogle = spGroupPref.getCGoogle();
			boolean cTw = spGroupPref.getCTw();

			String viewSPGroupDiscussionURL = PortalUtil.getPortalURL(resourceRequest) + "/discussion-detail";
			javax.portlet.PortletURL viewSPGroupDiscussionPortletURL = null;
			try {
				com.liferay.portal.model.Layout createSPGroupLayout = com.liferay.portal.service.LayoutLocalServiceUtil
						.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, "/discussion-detail");
				long viewSPGroupDiscussionPlid = createSPGroupLayout.getPlid();

				viewSPGroupDiscussionPortletURL = com.liferay.portlet.PortletURLFactoryUtil.create(resourceRequest,
						"SPGroupDiscussionDetail_WAR_SPGroupportlet", viewSPGroupDiscussionPlid,
						javax.portlet.PortletRequest.RENDER_PHASE);
				viewSPGroupDiscussionPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
				viewSPGroupDiscussionPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
				viewSPGroupDiscussionPortletURL.setParameter("struts_action", "/discussions/view_discussion");
				viewSPGroupDiscussionPortletURL.setParameter("urlTitle", urlTitle);
				viewSPGroupDiscussionPortletURL.setParameter("spGroupId", String.valueOf(classPK));

			} catch (com.liferay.portal.NoSuchLayoutException e) {

				// do nothing

			}

			if (viewSPGroupDiscussionPortletURL != null) {
				viewSPGroupDiscussionPortletURL.setParameter("discussionId", String.valueOf(mbmsg.getMessageId()));
				viewSPGroupDiscussionURL = viewSPGroupDiscussionPortletURL.toString();
			}

			String imgUrl = "/image/image_gallery?img_id=" + groupImageId;
			String title = "";
			SPSocialSharingLocalServiceUtil.postSPGroupToSocialNetworks(
					ClassNameLocalServiceUtil.getClassNameId(MBMessage.class), mbmsg.getMessageId(), title, content,
					viewSPGroupDiscussionURL, imgUrl, themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
					themeDisplay.getUser(), cFb, cIn, cGoogle, cTw);

		} catch (NoSuchPrefException nspe) {

			// do nothing

		}

		return dataJSONObject.toString();
	}

	private String retrieveCommentsJsonString(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ThemeDisplay themeDisplay)
			throws PortalException, PortletModeException, SystemException, WindowStateException {

		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
		JSONArray itemsJSONArray = JSONFactoryUtil.createJSONArray();
		CommentJsonListBo commentJsonListBo = retrieveComments(resourceRequest, resourceResponse, themeDisplay);
		List<CommentJsonBo> commentJsonBos = commentJsonListBo.getItems();

		for (CommentJsonBo commentJsonBo : commentJsonBos) {
			String html = commentJsonBo.getHtml();
			JSONObject htmlJSONObject = JSONFactoryUtil.createJSONObject();
			htmlJSONObject.put("html", html);
			itemsJSONArray.put(htmlJSONObject);
		}

		dataJSONObject.put("items", itemsJSONArray);

		return dataJSONObject.toString();
	}

	private CommentJsonListBo retrieveComments(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ThemeDisplay themeDisplay)
			throws PortalException, PortletModeException, SystemException, WindowStateException {

		String classPKStr = resourceRequest.getParameter("class_pk");
		String className = resourceRequest.getParameter("class_name");
		String initTotalStr = resourceRequest.getParameter("init_total");
		String curShowingNoStr = resourceRequest.getParameter("cur_showing_no");
		String offsetStr = resourceRequest.getParameter("offset");
		String urlTitle = resourceRequest.getParameter("url_title");

		long classPK = 0;
		int curShowingNo = 0;
		int initTotal = 0;
		int offset = 0;

		try {
			classPK = Long.valueOf(classPKStr);
		} catch (NumberFormatException nfe) {
		}

		SPGroup spGroup = null;
		long groupImageId = 0;
		try {
			spGroup = SPGroupLocalServiceUtil.getSPGroup(classPK);
			groupImageId = spGroup.getImageId();
		} catch (NoSuchSPGroupException nsspge) {

			// do nothing

		}

		boolean isMember = false;
		SPGroupUser spGroupUser = null;
		try {
			spGroupUser = SPGroupUserLocalServiceUtil
					.getSPGroupUser(new SPGroupUserPK(classPK, themeDisplay.getUserId()));

			if (spGroupUser.getStatus() == SPGroupUserStatus.APPROVE.getValue()) {
				isMember = true;
			}

		} catch (NoSuchUserException nsue) {

		}

		try {
			curShowingNo = Integer.valueOf(curShowingNoStr);
		} catch (NumberFormatException nfe) {
		}

		try {
			initTotal = Integer.valueOf(initTotalStr);
		} catch (NumberFormatException nfe) {
		}

		try {
			offset = Integer.valueOf(offsetStr);
		} catch (NumberFormatException nfe) {
		}

		int start = curShowingNo;

		long classNameId = ClassNameLocalServiceUtil.getClassNameId(className);

		String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);

		MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(
				themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), className, classPK,
				WorkflowConstants.STATUS_ANY, threadView);

		MBThread thread = messageDisplay.getThread();
		MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
		MBMessage rootMessage = null;

		if (treeWalker != null) {
			rootMessage = treeWalker.getRoot();
		} else {
			rootMessage = MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class,
				PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("messageId").ne(new Long(rootMessage.getMessageId())));
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(rootMessage.getMessageId())));
		dynamicQuery.add(PropertyFactoryUtil.forName("classPK").eq(new Long(classPK)));
		dynamicQuery.add(PropertyFactoryUtil.forName("classNameId").eq(new Long(classNameId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		long countL = MBMessageLocalServiceUtil.dynamicQueryCount(dynamicQuery);

		// Catch this exception, we'll see ...

		int count = Util.safeLongToInt(countL);
		int balance = 0;
		balance = count - initTotal;
		start += balance;

		int cStart = 0;
		int cOffset = 3;

		return populateParentCommentJsonList(resourceRequest, resourceResponse, themeDisplay, classPK, className,
				urlTitle, groupImageId, start, offset, cStart, cOffset, isMember);
	}

	private List<CommentBo> getParentCommentBos(long classPK, long classNameId, long rootMessageId,
			PortletURL viewSPGroupDiscussionPortletURL, String viewSPGroupDiscussionURL, int pStart, int pOffset,
			int cStart, int cOffset) throws PortalException, SystemException {

		List<CommentBo> parentCommentBos = new ArrayList<CommentBo>();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class,
				PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("messageId").ne(new Long(rootMessageId)));
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(rootMessageId)));
		dynamicQuery.add(PropertyFactoryUtil.forName("classPK").eq(new Long(classPK)));
		dynamicQuery.add(PropertyFactoryUtil.forName("classNameId").eq(new Long(classNameId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("modifiedDate"));

		@SuppressWarnings("unchecked")
		List<MBMessage> parentComments = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery, pStart, pStart + pOffset);

		for (MBMessage parentComment : parentComments) {
			long parentCommentId = parentComment.getMessageId();
			long userId = parentComment.getUserId();
			User actor = UserLocalServiceUtil.getUserById(userId);
			CommentBo parentCommentBo = new CommentBo(parentComment);
			parentCommentBo.setScreenName(actor.getScreenName());
			parentCommentBo.setFullName(actor.getFullName());
			parentCommentBo.setPortraitId(actor.getPortraitId());
			List<CommentBo> childCommentBos = getChildCommentBos(parentCommentId, cStart, cOffset);
			parentCommentBo.setChildCommentBos(childCommentBos);

			dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(parentCommentId)));
			dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

			long childCount = MBMessageLocalServiceUtil.dynamicQueryCount(dynamicQuery);
			parentCommentBo.setChildCount(childCount);

			if (viewSPGroupDiscussionPortletURL != null) {
				viewSPGroupDiscussionPortletURL.setParameter("discussionId", String.valueOf(parentCommentId));
				viewSPGroupDiscussionURL = viewSPGroupDiscussionPortletURL.toString();
			}

			parentCommentBo.setViewDiscussionURL(viewSPGroupDiscussionURL);
			parentCommentBos.add(parentCommentBo);
		}

		return parentCommentBos;
	}

	private List<CommentBo> getChildCommentBos(long parentId, int cStart, int cOffset)
			throws PortalException, SystemException {

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class,
				PortalClassLoaderUtil.getClassLoader());
		dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class, PortalClassLoaderUtil.getClassLoader());
		dynamicQuery.add(PropertyFactoryUtil.forName("parentMessageId").eq(new Long(parentId)));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		@SuppressWarnings("unchecked")
		List<MBMessage> childComments = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery, cStart, cStart + cOffset);

		List<CommentBo> childCommentBos = new ArrayList<CommentBo>();

		for (MBMessage childComment : childComments) {
			CommentBo childCommentBo = new CommentBo(childComment);
			long userId = childComment.getUserId();
			User actor = UserLocalServiceUtil.getUserById(userId);
			childCommentBo.setScreenName(actor.getScreenName());
			childCommentBo.setFullName(actor.getFullName());
			childCommentBo.setPortraitId(actor.getPortraitId());
			childCommentBos.add(childCommentBo);
		}

		return childCommentBos;
	}

	private CommentJsonListBo populateParentCommentJsonList(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, ThemeDisplay themeDisplay, long classPK, String className,
			String urlTitle, long groupImageId, int pStart, int pOffset, int cStart, int cOffset, boolean isMember)
			throws PortalException, PortletModeException, SystemException, WindowStateException {

		List<CommentJsonBo> commentJsonBos = new ArrayList<CommentJsonBo>();
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(className);

		String threadView = PropsUtil.get(PropsKeys.DISCUSSION_THREAD_VIEW);

		MBMessageDisplay messageDisplay = MBMessageLocalServiceUtil.getDiscussionMessageDisplay(
				themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), className, classPK,
				WorkflowConstants.STATUS_ANY, threadView);

		MBThread thread = messageDisplay.getThread();
		MBTreeWalker treeWalker = messageDisplay.getTreeWalker();
		MBMessage rootMessage = null;

		if (treeWalker != null) {
			rootMessage = treeWalker.getRoot();
		} else {
			rootMessage = MBMessageLocalServiceUtil.getMessage(thread.getRootMessageId());
		}

		String viewSPGroupDiscussionURL = PortalUtil.getPortalURL(resourceRequest) + "/discussion-detail";
		javax.portlet.PortletURL viewSPGroupDiscussionPortletURL = null;
		try {
			com.liferay.portal.model.Layout createSPGroupLayout = com.liferay.portal.service.LayoutLocalServiceUtil
					.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, "/discussion-detail");
			long viewSPGroupDiscussionPlid = createSPGroupLayout.getPlid();

			viewSPGroupDiscussionPortletURL = com.liferay.portlet.PortletURLFactoryUtil.create(resourceRequest,
					"SPGroupDiscussionDetail_WAR_SPGroupportlet", viewSPGroupDiscussionPlid,
					javax.portlet.PortletRequest.RENDER_PHASE);
			viewSPGroupDiscussionPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
			viewSPGroupDiscussionPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
			viewSPGroupDiscussionPortletURL.setParameter("struts_action", "/discussions/view_discussion");
			viewSPGroupDiscussionPortletURL.setParameter("urlTitle", urlTitle);
			viewSPGroupDiscussionPortletURL.setParameter("spGroupId", String.valueOf(classPK));

		} catch (com.liferay.portal.NoSuchLayoutException e) {

			// do nothing

		}

		List<CommentBo> parentCommentBos = getParentCommentBos(classPK, classNameId, rootMessage.getMessageId(),
				viewSPGroupDiscussionPortletURL, viewSPGroupDiscussionURL, pStart, pOffset, cStart, cOffset);

		for (CommentBo parentCommentBo : parentCommentBos) {
			String html = getParentCommentHtml(resourceResponse, classPK, className, urlTitle, groupImageId,
					parentCommentBo, themeDisplay, cStart, cOffset, isMember);
			CommentJsonBo commentJsonBo = new CommentJsonBo(html);
			commentJsonBos.add(commentJsonBo);
		}

		CommentJsonListBo commentJsonListBo = new CommentJsonListBo(commentJsonBos);
		return commentJsonListBo;
	}

	private String getParentCommentHtml(ResourceResponse resourceResponse, long classPK, String className,
			String urlTitle, long groupImageId, CommentBo parentCommentBo, ThemeDisplay themeDisplay, int cStart,
			int cOffset, boolean isMember) throws PortalException, SystemException {

		long parentCommentId = parentCommentBo.getCommentId();
		String title = parentCommentBo.getTitle();
		String content = parentCommentBo.getContent();
		if(Validator.isNotNull(content) && !content.isEmpty()){
			content =  content.replaceAll("[\r\n]", "<br>");//SPHtmlUtil.changeNewLineToBR(SPHtmlUtil.shortenHtmlTextWithLink(content,content.length()));
		}	
		String displayDate = parentCommentBo.getDisplayDate();
		long actorId = parentCommentBo.getUserId();
		String screenName = parentCommentBo.getScreenName();
		String fullName = parentCommentBo.getFullName();
		String userThumbnailURL = getUserPortraitUrl(themeDisplay, parentCommentBo.getPortraitId());
		String profileURL = "/" + screenName;

		long childCount = parentCommentBo.getChildCount();

		String html = "<li data-comment-is-parent=\"true\" data-comment-id=\"" + parentCommentId
				+ "\" class=\"sp-gd-entry level1\">" + "<div class=\"sp-gd-entry-inner\">"
				+ "<div class=\"avatar-wrap\"><a href=\"" + profileURL + "\"><img alt=\"User Image\" class=\"avatar\" src=\""
				+ userThumbnailURL + "\"/><span class=\"sp-group-mvm\" style=\"display: block; height: 32px;\">"
				+ fullName + "</span></a></div>" + "<div class=\"sp-gd-content-wrap\">"
				+ "<div class=\"sp-gd-content\">" + "<div class=\"sp-group-fsxl sp-group-mbs\"><a href=\""
				+ parentCommentBo.getViewDiscussionURL() + "\">" + title + "</a></div><div class=\"comment-details\">" + content + "</div>";

		html += "<div class=\"sp-group-fss\"><span class=\"sp-group-fcl\">posted " + displayDate + "</span>";
		long currentUserId = themeDisplay.getUserId();

		if (themeDisplay.isSignedIn() && isMember) {
			html += "<span> - </span><a href=\"" + parentCommentBo.getViewDiscussionURL() + "\" />Comment</a> ";

			// html += "<a href=\"" + parentCommentBo.getViewDiscussionURL() +
			// "\"><span>(</span>" + childCount + "<span>)</span></a>";

			boolean isOwner = (actorId == currentUserId) ? true : false;

			if (isOwner) {
				html += "<span> - </span><a href=\"#\" data-comment-dom-id=\"delete-link\">Delete</a>";
			}
		}

		html += "</div>";

		html += "</div>";

		html += "<div data-loadmore-dom-id=\"loadmore-container\" class=\"sp-gd-reply-container\">"
				+ "<ul data-comment-dom-id=\"child-entry-container\" data-loadmore-dom-id=\"items-container\" class=\"sp-group-child-entry-container\">";

		List<CommentBo> childCommentBos = this.getChildCommentBos(parentCommentId, cStart, 1);

		for (int i = 0; i < childCommentBos.size(); i++) {
			CommentBo childCommentBo = childCommentBos.get(i);

			if (i == 0) {
				html += getChildCommentHtml(childCommentBo, themeDisplay, true, isMember);
			} else {
				html += getChildCommentHtml(childCommentBo, themeDisplay, false, isMember);
			}
		}

		html += "</ul>";
		html += "<div ";

		if (childCount <= childCommentBos.size()) {
			html += "style=\"display: none;\"";
		}

		ResourceURL retrieveRepliesResourceURL = resourceResponse.createResourceURL();
		retrieveRepliesResourceURL.setParameter("action", "retrieveReplies");

		html += "data-loadmore-dom-id=\"view-more-link-container\" class=\"sp-gd-children-more\"><a href=\""
				+ parentCommentBo.getViewDiscussionURL() + "\">View <span data-loadmore-dom-id=\"unshown-status\">"
				+ (childCount - childCommentBos.size())
				+ "</span> more <span class=\"arrow arrow-down arrow-down-lightblue arrow-down-small\"></span></a></div>";
		html += "<div data-loadmore-dom-id=\"loading-status\" style=\"display: none;\" align=\"center\"><span>Loading...</span></div>";
		html += "<div data-loadmore-dom-id=\"load-msg\" style=\"display: none;\" align=\"center\"></div>";

		if (themeDisplay.isSignedIn()) {
			html += getReplyFormHtml(resourceResponse, themeDisplay, classPK, className, urlTitle, groupImageId);
		}

		html += "</div></div></div></li>";

		return html;
	}

	private String getChildCommentHtml(CommentBo commentBo, ThemeDisplay themeDisplay, boolean firstComment,
			boolean isMember) {

		long commentId = commentBo.getCommentId();
		String content = commentBo.getContent();
		content = StringUtil.shorten(content, 118, "...");
		String displayDate = commentBo.getDisplayDate();
		long actorId = commentBo.getUserId();
		String screenName = commentBo.getScreenName();
		String fullName = commentBo.getFullName();
		String profileURL = "/" + screenName;
		String userThumbnailURL = getUserPortraitUrl(themeDisplay, commentBo.getPortraitId());

		String html = "<li data-comment-id=\"" + commentId
				+ "\" data-comment-is-parent=\"false\" class=\"sp-gd-entry level\">"
				+ "<div class=\"sp-gd-entry-inner\">" + "<div class=\"avatar-wrap\"><a href=\"" + profileURL
				+ "\"><img alt=\"Image\" data-comment-dom-id= \"child-avatar\" src=\"" + userThumbnailURL
				+ "\" class=\"avatar\"/></a></div>";

		html += "<div data-comment-dom-id= \"child-content-wrap\" class=\"sp-gd-content-wrap\"";

		if (!firstComment) {
			html += "style=\"display: none\"";
		}

		html += ">" + "<div class=\"sp-gd-content\">" + "<a href=\"" + profileURL + "\" class=\"sp-group-fwb\">"
				+ fullName + "</a> - " + "<span>" + content + "</span>";

		long currentUserId = themeDisplay.getUserId();
		html += "<div class=\"sp-group-fss\"><span class=\"sp-group-fcl\">" + displayDate + "</span>";

		if (themeDisplay.isSignedIn() && isMember) {

			// html +=
			// "<span> - </span><a data-comment-dom-id=\"add-reply-link\"
			// href=\"#\">Reply</a>";

			boolean isOwner = (actorId == currentUserId) ? true : false;

			if (isOwner) {
				html += "<span> - </span><a href=\"#\" data-comment-dom-id=\"delete-link\">Delete</a>";
			}
		}

		html += "</div></div></div></div></li>";
		return html;
	}

	private String getReplyFormHtml(ResourceResponse resourceResponse, ThemeDisplay themeDisplay, long classPK,
			String className, String urlTitle, long groupImageId) {

		String currentUserThumbnailURL = getUserPortraitUrl(themeDisplay, themeDisplay.getUser().getPortraitId());

		ResourceURL addReplyResourceURL = resourceResponse.createResourceURL();
		addReplyResourceURL.setParameter("action", "addReply");

		String html = "<div data-comment-dom-id=\"add-reply-form-container\" class=\"sp-gd-entry level2\" style=\"display: none;\">"
				+ "<div class=\"sp-gd-entry-inner\">"
				+ "<div class=\"avatar-wrap\"><img alt=\"User Image\" data-comment-dom-id=\"avatar\" src=\"" + currentUserThumbnailURL
				+ "\" class=\"avatar\"/></div>" + "<div style=\"margin: 0 0 8px 48px; min-height: 40px;\">"
				+ "<form data-comment-dom-id=\"add-reply-form\" action=\"" + addReplyResourceURL + "\" method=\"post\">"
				+ "<input type=\"hidden\" name=\"classPK\" value=\"" + classPK + "\"/>"
				+ "<input type=\"hidden\" name=\"className\" value=\"" + className + "\"/>"
				+ "<input type=\"hidden\" name=\"urlTitle\" value=\"" + urlTitle + "\"/>"
				+ "<input type=\"hidden\" name=\"groupImageId\" value=\"" + groupImageId + "\"/>"
				+ "<div class=\"sp-gd-textarea-outer\">"
				+ "<textarea data-comment-dom-id=\"add-reply-textarea\" style=\"height: 28px;\"></textarea>" + "</div>"
				+ "<div align=\"right\" class=\"sp-group-mts\">";

		if (!_commentServiceHasAccess) {
			html += "<input type=\"button\" value=\"Reply\" class=\"sp-gd-btn small btn-primary sp-group-comment-service-access-check\" name=\""
					+ _commentServiceUserStatus + "&upload=false\" title=\"Permission Denied\" />";
		} else {
			html += "<input data-comment-dom-id=\"add-reply-form-sumbit-btn\" type=\"submit\" class=\"sp-gd-btn btn-primary small\" value=\"Reply\" />";
		}

		html += "</div></form>" + "</div></div></div>";
		return html;
	}

	private String[] getJoinRequestTitleAndBody(Map<String, Object> paramsMap) {

		// When changing the subject line also look into
		// SambaashConstants.SPGroup.GRP_JOIN_REQUEST_PREFIX and
		// NotificationUtils.getSpGroupLink
		// Based on subject line NotificationUtils.getSpGroupLink interpreting
		// group link in content

		String subject = "Group Join Request [$GROUP_TITLE$]";
		String portalSigninUrl = (String) paramsMap.get("portalSigninUrl");
		String body = "<p>Greetings,</p>" + "<p><a target=\"_blank\" href=\"" + portalSigninUrl
				+ "[$PROFILE_URL$]\"><b>[$REQUEST_USER_NAME$]</b></a> has requested to join group <a target=\"_blank\" href=\""
				+ portalSigninUrl + "[$GROUP_DETAIL_URL$]\"><b>[$GROUP_TITLE$]</b></a>.</p>"
				+ "<p>Click <a target=\"_blank\" href=\"" + portalSigninUrl
				+ "[$VIEW_MEMBERS_URL$]\">here</a> to Approve or Reject.</p>";

		String profileURL = (String) paramsMap.get("profileURL");
		String username = (String) paramsMap.get("username");
		String groupDetailURL = (String) paramsMap.get("groupDetailURL");
		String groupTitle = (String) paramsMap.get("groupTitle");
		String spGroupMembersURL = (String) paramsMap.get("spGroupMembersURL");

		subject = StringUtil.replace(subject, new String[] { "[$GROUP_TITLE$]" }, new String[] { groupTitle });

		body = StringUtil.replace(body,
				new String[] { "[$PROFILE_URL$]", "[$REQUEST_USER_NAME$]", "[$GROUP_TITLE$]", "[$GROUP_DETAIL_URL$]",
						"[$VIEW_MEMBERS_URL$]" },
				new String[] { profileURL, username, groupTitle, groupDetailURL, spGroupMembersURL });
		return new String[] { subject, body };
	}

	private String[] getJoinRequestNotificationTitleAndBody(Map<String, Object> paramsMap, boolean approved) {

		// When changing the subject line also look into
		// SambaashConstants.SPGroup.GRP_JOIN_REQUEST_PREFIX and
		// NotificationUtils.getSpGroupLink
		// Based on subject line NotificationUtils.getSpGroupLink interpreting
		// group link in content

		String subject = "Group Request Notification '[$GROUP_TITLE$]'";
		String groupDetailURL = (String) paramsMap.get("groupDetailURL");
		String groupTitle = (String) paramsMap.get("groupTitle");
		String portalSigninUrl = (String) paramsMap.get("portalSigninUrl");

		String body = "<p>Greetings,</p>" + "<p>Your request of joining group <a href=\"" + portalSigninUrl
				+ "[$GROUP_DETAIL_URL$]\" target=\"_blank\">[$GROUP_TITLE$]</a> has been ";

		if (approved) {
			body += "approved";
		} else {
			body += "rejected";
		}

		body += ".</p>";

		body = StringUtil.replace(body, new String[] { "[$GROUP_TITLE$]", "[$GROUP_DETAIL_URL$]" },
				new String[] { groupTitle, groupDetailURL });
		return new String[] { subject, body };
	}

	private String[] getInternalInvitationTitleAndBody(Map<String, Object> paramsMap) {

		// When changing the subject line also look into
		// SambaashConstants.SPGroup.GRP_JOIN_REQUEST_PREFIX and
		// NotificationUtils.getSpGroupLink
		// Based on subject line NotificationUtils.getSpGroupLink interpreting
		// group link in content

		String subject = "Invitation to group '[$GROUP_TITLE$]'";

		String senderProfileURL = (String) paramsMap.get("senderProfileURL");
		String groupDetailURL = (String) paramsMap.get("groupDetailURL");
		String groupTitle = (String) paramsMap.get("groupTitle");
		String senderName = (String) paramsMap.get("senderName");
		String comment = (String) paramsMap.get("comment");
		String portalSigninUrl = (String) paramsMap.get("portalSigninUrl");

		String body = "<p>Greetings,</p>" + "<p><a href=\"" + portalSigninUrl
				+ "[$PROFILE_URL$]\" target=\"_blank\">[$FROM_NAME$]</a> invited you to join the group <a href=\""
				+ portalSigninUrl + "[$GROUP_DETAIL_URL$]\" target=\"_blank\">[$GROUP_TITLE$]</a>.</p>"
				+ "<p><b>[$COMMENT$]</b></p>";

		subject = StringUtil.replace(subject, new String[] { "[$GROUP_TITLE$]" }, new String[] { groupTitle });

		body = StringUtil.replace(body,
				new String[] { "[$PROFILE_URL$]", "[$FROM_NAME$]", "[$GROUP_TITLE$]", "[$GROUP_DETAIL_URL$]",
						"[$COMMENT$]" },
				new String[] { senderProfileURL, senderName, groupTitle, groupDetailURL, comment });
		return new String[] { subject, body };
	}

	private String[] getExternalInvitationTitleAndBody(String subject, String body, Map<String, Object> paramsMap) {

		subject = "Invitation to group '[$GROUP_TITLE$]'";

		String senderProfileURL = (String) paramsMap.get("senderProfileURL");
		String groupDetailURL = (String) paramsMap.get("groupDetailURL");
		String joinGroupURL = (String) paramsMap.get("joinGroupURL");
		String groupTitle = (String) paramsMap.get("groupTitle");
		String senderName = (String) paramsMap.get("senderName");
		String comment = (String) paramsMap.get("comment");
		String portalSigninUrl = (String) paramsMap.get("portalSigninUrl");

		body = "<p>Greetings,</p>" + "<p><a href=\"" + portalSigninUrl
				+ "[$PROFILE_URL$]\" target=\"_blank\">[$FROM_NAME$]</a> invited you to join the group <a href=\""
				+ portalSigninUrl + "[$GROUP_DETAIL_URL$]\" target=\"_blank\">[$GROUP_TITLE$]</a>.</p>"
				+ "<p>Please click <a target=\"_blank\" href=\"" + portalSigninUrl
				+ "[$JOIN_GROUP_URL$]\">here</a> to join.</p>" + "<p><b>[$COMMENT$]</b></p>";

		subject = StringUtil.replace(subject, new String[] { "[$GROUP_TITLE$]" }, new String[] { groupTitle });

		body = StringUtil.replace(body,
				new String[] { "[$PROFILE_URL$]", "[$FROM_NAME$]", "[$GROUP_TITLE$]", "[$GROUP_DETAIL_URL$]",
						"[$JOIN_GROUP_URL$]", "[$COMMENT$]" },
				new String[] { senderProfileURL, senderName, groupTitle, groupDetailURL, joinGroupURL, comment });
		return new String[] { subject, body };
	}

	private String[] getNewDiscThreadSubjectBody(Map<String, Object> paramsMap) {

		String senderProfileURL = (String) paramsMap.get("senderProfileURL");
		String groupDetailURL = (String) paramsMap.get("discussionUrl");
		String groupTitle = (String) paramsMap.get("groupTitle");
		String senderName = (String) paramsMap.get("senderName");
		String portalSigninUrl = (String) paramsMap.get("portalSigninUrl");
		String subject = "New Discussion started";
		String body = "<p>Greetings,</p>" + "<p><a href=\"" + portalSigninUrl
				+ "[$PROFILE_URL$]\" target=\"_blank\">[$FROM_NAME$]</a> started new discussion in the group <a href=\""
				+ portalSigninUrl + "[$GROUP_DETAIL_URL$]\" target=\"_blank\">[$GROUP_TITLE$]</a>.</p>";

		body = StringUtil.replace(body,
				new String[] { "[$PROFILE_URL$]", "[$FROM_NAME$]", "[$GROUP_TITLE$]", "[$GROUP_DETAIL_URL$]" },
				new String[] { senderProfileURL, senderName, groupTitle, groupDetailURL });
		return new String[] { subject, body };
	}

	private void sendExternalEmail(long companyId, String subject, String body, String toName, String toAddress,
			Map<String, Object> paramsMap) throws SystemException {

		String fromName = PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromAddress = PropsUtil.get(PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

		long senderId = (Long) paramsMap.get("senderId");

		SubscriptionSender subscriptionSender = new SubscriptionSender();

		subscriptionSender.setSubject(subject);
		subscriptionSender.setBody(body);
		subscriptionSender.setCompanyId(companyId);
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);
		subscriptionSender.setMailId("user", senderId);
		subscriptionSender.setUserId(senderId);
		subscriptionSender.addRuntimeSubscribers(toAddress, toName);
		subscriptionSender.flushNotificationsAsync();

	}
	
	private void sendUserJoinedNotification(SPGroup spGroup,
			String spGroupDetailURL, Long joinerUserId,
			RenderRequest renderRequest) throws Exception {
		Date now = new Date();
		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(renderRequest);

		List<SPGroupUser> members = SPGroupUserLocalServiceUtil
				.findBySPGroupId(spGroup.getSpGroupId());
		JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
		payloadJSON.put(Field.USER_ID, joinerUserId);
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.USER_NAME,
				UserLocalServiceUtil.getUser(joinerUserId).getFullName());
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_URL,
				spGroupDetailURL);
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_NAME,
				spGroup.getTitle());
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_IMAGE,
				PortalUtil.getPortalURL(renderRequest) + "/image/image_gallery?img_id="
						+ spGroup.getImageId() + "&t=" + now.getTime());
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE,
				SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_USER_JOINED);
		for (SPGroupUser spGroupUser : members) {
			if (joinerUserId == spGroupUser.getUserId())
				continue;
			UserNotificationEventLocalServiceUtil
					.addUserNotificationEvent(spGroupUser.getUserId(),
							SPGroupConstants.PORTLET_ID_GROUP_DETAIL, now.getTime(),
							joinerUserId, payloadJSON.toString(), false,
							serviceContext);
		}
	}
	
	private void sendNewDiscussionNotification(SPGroup spGroup,
			String spGroupDetailURL, String discussionUrl, String discussionName, Long addedBy,
			ResourceRequest resourceRequest) throws Exception {
		Date now = new Date();
		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(resourceRequest);

		List<SPGroupUser> members = SPGroupUserLocalServiceUtil
				.findBySPGroupId(spGroup.getSpGroupId());
		JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
		payloadJSON.put(Field.USER_ID, addedBy);
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.USER_NAME,
				UserLocalServiceUtil.getUser(addedBy).getFullName());
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_URL,
				spGroupDetailURL);
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_NAME,
				spGroup.getTitle());
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.DISC_URL,
				discussionUrl);
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.DISC_NAME,
				discussionName);
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_IMAGE,
				PortalUtil.getPortalURL(resourceRequest) + "/image/image_gallery?img_id="
						+ spGroup.getImageId() + "&t=" + now.getTime());
		payloadJSON.put(SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE,
				SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_NEW_DICUSSION);
		for (SPGroupUser spGroupUser : members) {
			if (addedBy == spGroupUser.getUserId())
				continue;
			UserNotificationEventLocalServiceUtil
					.addUserNotificationEvent(spGroupUser.getUserId(),
							SPGroupConstants.PORTLET_ID_GROUP_DETAIL, now.getTime(),
							addedBy, payloadJSON.toString(), false,
							serviceContext);
		}
	}
	
	private String getUserPortraitUrl(ThemeDisplay themeDisplay, long portraitId) {
		return UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, portraitId);
	}
	
	
	private void sendUserInvitedNotification(SPGroup spGroup, PortletURL detailsUrl,
			long invitedUserId, long userId, ResourceRequest resourceRequest) {
		try {
			Date now = new Date();
			ServiceContext serviceContext = ServiceContextFactory
					.getInstance(resourceRequest);

			JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
			payloadJSON.put(Field.USER_ID, userId);
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.USER_NAME,
					UserLocalServiceUtil.getUser(userId).getFullName());
			detailsUrl.setParameter("action", "acceptJoinSPGroupRequest");
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_URL,
					detailsUrl.toString());
			detailsUrl.setParameter("action", "ignoreJoinSPGroupRequest");
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.IGNORE_URL,
					detailsUrl.toString());
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_NAME,
					spGroup.getTitle());
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE,
					SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_APPROVE_INVITE_REQUEST);
			UserNotificationEventLocalServiceUtil
					.addUserNotificationEvent(invitedUserId,
							SPGroupConstants.PORTLET_ID_GROUP_DETAIL, now.getTime(),
							userId, payloadJSON.toString(), false,
							serviceContext);
		} catch (Exception e) {
			_log.error("Error ", e);
		}
	}
	
	private void sendUserJoinRequestNotification(SPGroup spGroup, PortletURL detailsUrl,
			long joinerUserId, RenderRequest renderRequest) {
		try {
			Date now = new Date();
			ServiceContext serviceContext = ServiceContextFactory
					.getInstance(renderRequest);
			JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
			payloadJSON.put(Field.USER_ID, joinerUserId);
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.USER_NAME,
					UserLocalServiceUtil.getUser(joinerUserId).getFullName());
			detailsUrl.setParameter("selectedUserId", "" + joinerUserId);
			detailsUrl.setParameter("tab1", "members");
			detailsUrl.setParameter("action", "approveOfJoiningSPGroup");
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_URL,
					detailsUrl.toString());
			detailsUrl.setParameter("action", "rejectOfJoiningSPGroup");
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.IGNORE_URL,
					detailsUrl.toString());
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_NAME,
					spGroup.getTitle());
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE,
					SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE_APPROVE_INVITE_REQUEST);
			List<SPGroupUser> owners = SPGroupUserLocalServiceUtil.findBySPGroupIdAndRole(spGroup.getSpGroupId(),
					SPGroupUserType.OWNER.getValue());
			List<SPGroupUser> admins = SPGroupUserLocalServiceUtil.findBySPGroupIdAndRole(spGroup.getSpGroupId(),
					SPGroupUserType.ADMIN.getValue());
			if (Validator.isNotNull(admins) && admins.size() > 0) {
				owners.addAll(admins);
			}
			for (SPGroupUser spGroupUser : owners) {
				UserNotificationEventLocalServiceUtil
						.addUserNotificationEvent(spGroupUser.getUserId(),
								SPGroupConstants.PORTLET_ID_GROUP_DETAIL, now.getTime(),
								joinerUserId, payloadJSON.toString(), false,
								serviceContext);
			}
		} catch (Exception e) {
			_log.error("Error ", e);
		}
	}

	private void sendApprovalResponseNotification(SPGroup spGroup,
			String detailsUrl, long joinerUserId, long userId,
			int notificationType, RenderRequest renderRequest) {
		try {
			Date now = new Date();
			ServiceContext serviceContext = ServiceContextFactory
					.getInstance(renderRequest);

			JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
			payloadJSON.put(Field.USER_ID, userId);
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_URL,
					detailsUrl.toString());
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.GROUP_NAME,
					spGroup.getTitle());
			payloadJSON.put(SPGroupConstants.NOTIFICATIONS.NOTIFICATION_TYPE,
					notificationType);
			UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
					joinerUserId, SPGroupConstants.PORTLET_ID_GROUP_DETAIL,
					now.getTime(), userId, payloadJSON.toString(), false,
					serviceContext);
		} catch (Exception e) {
			_log.error("Error ", e);
		}
	}

	private boolean _commentServiceHasAccess = true;
	private String _commentServiceUserStatus = StringPool.BLANK;

	private static Log _log = LogFactoryUtil.getLog(SPGroupDetailAction.class);

}
