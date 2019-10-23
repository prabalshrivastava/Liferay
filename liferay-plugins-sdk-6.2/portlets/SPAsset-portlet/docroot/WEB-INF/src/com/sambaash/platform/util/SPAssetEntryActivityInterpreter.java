package com.sambaash.platform.util;

import java.text.Format;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.social.model.BaseSocialActivityInterpreter;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityFeedEntry;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalServiceUtil;
import com.sambaash.platform.srv.spasset.service.permission.SPAssetEntryPermission;

public class SPAssetEntryActivityInterpreter extends BaseSocialActivityInterpreter {
 private static Log _log = LogFactoryUtil.getLog(SPAssetEntryActivityInterpreter.class);
 public static final String[] CLASS_NAMES = { SPAssetEntry.class.getName() };

 @Override
 public String[] getClassNames() {
  return CLASS_NAMES;
 }

 @SuppressWarnings("deprecation")
 protected SocialActivityFeedEntry doInterpret(
   SocialActivity activity, ThemeDisplay themeDisplay)
  throws Exception {
  _log.info("------------------fetching activities------------------------");
  
  User user = UserServiceUtil.getUserById(activity.getUserId());
  SPAssetEntry spAssetEntry = SPAssetEntryLocalServiceUtil.getSPAssetEntry(activity.getClassPK());
  
  String link = themeDisplay.getURLPortal() + themeDisplay.getPathMain() + "/spassetentry";
  String title = user.getFirstName() + StringPool.SPACE + SPAssetActivityKeys.ACTIVITY_MESSAGES.get(activity.getType());
  StringBuilder sb = new StringBuilder();
  sb.append("<a href=\"");
  sb.append(link);
  sb.append("\">");
  sb.append(cleanContent(spAssetEntry.getTitle()));
  sb.append("</a><br />");
  sb.append(cleanContent(spAssetEntry.getDescription()));
  String body = sb.toString();

  _log.info("Link ==> " + link);
  _log.info("Title ==> " + title);
  _log.info("Body ==> " + body);

  return new SocialActivityFeedEntry(link, title, body);
 }
 
 
/* @Override
	protected String getPath(
		SocialActivity activity, ServiceContext serviceContext) {

		return "/blogs/find_entry?entryId=" + activity.getClassPK();
	}*/

	@Override
	protected Object[] getTitleArguments(
			String groupName, SocialActivity activity, String link,
			String title, ServiceContext serviceContext)
		throws Exception {

		String creatorUserName = getUserName(
			activity.getUserId(), serviceContext);
		String receiverUserName = getUserName(
			activity.getReceiverUserId(), serviceContext);

		SPAssetEntry entry = SPAssetEntryLocalServiceUtil.getSPAssetEntry(activity.getClassPK());

		String displayDate = StringPool.BLANK;

		if ((activity.getType() == SPAssetActivityKeys.ADD_ENTRY) ) {
			// && (entry.getStatus() == WorkflowConstants.STATUS_SCHEDULED)                  @deprecated As of 6.2.0
			

			link = null;

			Format dateFormatDate =
				FastDateFormatFactoryUtil.getSimpleDateFormat(
					"MMMM d", serviceContext.getLocale(),
					serviceContext.getTimeZone());

			displayDate = dateFormatDate.format(entry.getModifiedDate());  // changed DisplayDate() to modified date
		}

		return new Object[] {
			groupName, creatorUserName, receiverUserName, wrapLink(link, title),
			displayDate
		};
	}

	@Override
	protected String getTitlePattern(String groupName, SocialActivity activity)
		throws Exception {

		int activityType = activity.getType();

		if (activityType == SPAssetActivityKeys.ADD_ENTRY) {
			SPAssetEntry entry =SPAssetEntryLocalServiceUtil.getSPAssetEntry(activity.getClassPK());


				if (Validator.isNull(groupName)) {
					return "activity-spasset-entry-add-entry";
				}
				else {
					return "activity-spasset-entry-add-entry-in";
				}
		}
		else if (activityType == SPAssetActivityKeys.DELETE_ENTRY) {
			if (Validator.isNull(groupName)) {
				return "activity-spasset-entry-move-to-trash";
			}
			else {
				return "activity-spasset-entry-move-to-trash-in";
			}
		}

		else if (activityType == SPAssetActivityKeys.UPDATE_ENTRY) {
			if (Validator.isNull(groupName)) {
				return "activity-spasset-entry-update-entry";
			}
			else {
				return "activity-spasset-entry-update-entry-in";
			}
		}

		return null;
	}

	@Override
	protected boolean hasPermissions(
			PermissionChecker permissionChecker, SocialActivity activity,
			String actionId, ServiceContext serviceContext)
		throws Exception {

		return SPAssetEntryPermission.contains(
			permissionChecker, activity.getClassPK(), actionId);
	}
	
	/*@Override
	protected String getTitlePattern(String groupName, SocialActivity activity)
		throws Exception {

		int activityType = activity.getType();

		if ((activityType == SPAssetActivityKeys.ADD_COMMENT) ||
			(activityType == SPAssetActivityKeys.TYPE_ADD_COMMENT)) {

			if (Validator.isNull(groupName)) {
				return "activity-blogs-entry-add-comment";
			}
			else {
				return "activity-blogs-entry-add-comment-in";
			}
		}
		else if (activityType == SPAssetActivityKeys.ADD_ENTRY) {
			SPAssetEntry entry =SPAssetEntryLocalServiceUtil.getSPAssetEntry(activity.getClassPK());

			if (entry.getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
				if (Validator.isNull(groupName)) {
					return "activity-blogs-entry-schedule-entry";
				}
				else {
					return "activity-blogs-entry-schedule-entry-in";
				}
			}
			else {
				if (Validator.isNull(groupName)) {
					return "activity-blogs-entry-add-entry";
				}
				else {
					return "activity-blogs-entry-add-entry-in";
				}
			//}
		}
		else if (activityType == SPAssetActivityKeys.DELETE_ENTRY) {
			if (Validator.isNull(groupName)) {
				return "activity-blogs-entry-move-to-trash";
			}
			else {
				return "activity-blogs-entry-move-to-trash-in";
			}
		}
		else if (activityType ==
					SocialActivityConstants.TYPE_RESTORE_FROM_TRASH) {

			if (Validator.isNull(groupName)) {
				return "activity-blogs-entry-restore-from-trash";
			}
			else {
				return "activity-blogs-entry-restore-from-trash-in";
			}
		}
		else if (activityType == SPAssetActivityKeys.UPDATE_ENTRY) {
			if (Validator.isNull(groupName)) {
				return "activity-blogs-entry-update-entry";
			}
			else {
				return "activity-blogs-entry-update-entry-in";
			}
		}

		return null;
	}*/
	
 
}