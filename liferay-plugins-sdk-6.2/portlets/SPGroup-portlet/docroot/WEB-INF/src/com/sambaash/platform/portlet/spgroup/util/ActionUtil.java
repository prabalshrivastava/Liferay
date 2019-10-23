package com.sambaash.platform.portlet.spgroup.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.model.notification.NotificationForm;
import com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.service.SPGroupLocalServiceUtil;
import com.sambaash.platform.srv.spinbox.model.IBMessage;
import com.sambaash.platform.srv.spinbox.model.IBMessageDetail;
import com.sambaash.platform.srv.spinbox.service.IBMessageDetailLocalServiceUtil;
import com.sambaash.platform.srv.spinbox.service.IBMessageLocalServiceUtil;
import com.sambaash.platform.util.NotificationUtils;
import com.sambaash.platform.util.SambaashUtil;
public class ActionUtil {

	public static IBMessage addIBMessage(
			long scopeGroupId, long companyId, long spGroupId, String createBy, long createByUserId, String fromEmail,
			String toEmails, String subject, String body)
			throws PortalException, SystemException {

			IBMessage ibmessage =
				IBMessageLocalServiceUtil.addMessage(
					null, 0, scopeGroupId, companyId, subject, body, new Date(), fromEmail, toEmails, createBy,
					createByUserId+"", true, false, "", false, false, spGroupId);
			Indexer indexer = IndexerRegistryUtil.getIndexer(IBMessage.class);
			indexer.reindex(ibmessage);
			return ibmessage;
		}

	public static void addIBMessageDetail(
			long companyId, IBMessage ibmessage, long toUserId, String toUserFullName, String ibMsgDetailStatus,
			String messageCategory, long processId)
			throws PortalException, SystemException {

			// add IBMessageDetail

			IBMessageDetail msgDetails = IBMessageDetailLocalServiceUtil.addMessageDetail(
				ibmessage.getMessageId(), toUserId, toUserFullName, new Date(), messageCategory, false, null, null,
				"unread", "", ibMsgDetailStatus, processId, 0);

			if (SambaashUtil.isWebSocketEnabled()) {
				try {

					String communityName = NotificationUtils.getCommunityName();//PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);//SambaashUtil.getCommunityName(spGroupId);

					List<String> sendToUsers = new ArrayList<String>();
				/* if (Validator.isNotNull(ibmessage.getTo())) {
						String[] emails = ibmessage.getTo().split(StringPool.COMMA);

						for (String email : emails) {
							User usr = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
							sendToUsers.add(usr.getScreenName());
						}
					} */
					User usr = UserLocalServiceUtil.getUser(toUserId);
					sendToUsers.add(usr.getScreenName());
					String detailLink = NotificationUtils.getSpGroupLink(ibmessage.getSubject(), ibmessage.getContent());
					NotificationForm form = new NotificationForm(NotificationUtils.UNREAD, communityName, ibmessage.getSubject(), NotificationUtils.getMsgContent(ibmessage),
							detailLink, String.valueOf(msgDetails.getIbMsgDetailId()), sendToUsers);
					SPGroupLocalServiceUtil.pushRealtimeActivityFeed(form);

				}catch (Exception ex) {
					_log.error("Error while pushing real time notification " + ex.getMessage());
				}
			}
		}

	public static SPGroup getSPGroup(HttpServletRequest request) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		long spGroupId = ParamUtil.getLong(request, "spGroupId");

		String urlTitle = ParamUtil.getString(request, "urlTitle");

		SPGroup spGroup = null;
		_log.error("spGroup #######spGroupid ##  " + spGroupId);
		if (spGroupId > 0) {
			spGroup = SPGroupLocalServiceUtil.getSPGroup(spGroupId);
			_log.error("spGroup spGroup spGroup spGroup " + spGroup);
		}
		else if (Validator.isNotNull(urlTitle)) {
			try {
				_log.error("try ########## ");
				spGroup = SPGroupLocalServiceUtil.findByURLTitleAndGroupId(
						themeDisplay.getScopeGroupId(), urlTitle);
			}
			catch (NoSuchSPGroupException nsspge) {
				if (urlTitle.indexOf(CharPool.UNDERLINE) != -1) {

					// Check another URL title for backwards compatibility. See
					// LEP-5733.
_log.error("catch ########## ");
					urlTitle = StringUtil.replace(
						urlTitle, CharPool.UNDERLINE, CharPool.DASH);

					spGroup = SPGroupLocalServiceUtil.findByURLTitleAndGroupId(
							themeDisplay.getScopeGroupId(), urlTitle);
				}
				else {
					throw nsspge;
				}
			}
		}

		request.setAttribute("SP_GROUP", spGroup);
		return spGroup;
	}

	public static SPGroup getSPGroup(PortletRequest portletRequest)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			portletRequest);

		return getSPGroup(request);
	}

	private static Log _log = LogFactoryUtil.getLog(ActionUtil.class);

}