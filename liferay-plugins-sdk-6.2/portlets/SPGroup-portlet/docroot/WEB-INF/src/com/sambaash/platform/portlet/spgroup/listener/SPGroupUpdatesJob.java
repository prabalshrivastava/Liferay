package com.sambaash.platform.portlet.spgroup.listener;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.model.SPGroupUserStatus;
import com.sambaash.platform.portlet.spgroup.util.DiscussionTree;
import com.sambaash.platform.portlet.spgroup.util.DiscussionTreeListener;
import com.sambaash.platform.portlet.spgroup.util.SPGroupConstants.FIELDS;
import com.sambaash.platform.portlet.spgroup.util.SPGroupUpdatesUtil;
import com.sambaash.platform.portlet.spgroup.util.Util;
import com.sambaash.platform.scheduler.SPScheduledJob;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.model.SPGroupUser;
import com.sambaash.platform.srv.spgroup.service.SPGroupLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SPGroupUpdatesJob extends SPScheduledJob implements DiscussionTreeListener {
	public static final int INDENT_SIZE = 25;

	private static Log _log = LogFactoryUtil.getLog(SPGroupUpdatesJob.class);
	private String content;
	private SPGroup spGroup;
	private int dIndex;

	@SuppressWarnings("unchecked")
	@Override
	public void executeJob() {

		_log.error(" Sendign digest");

		long startTime = Calendar.getInstance().getTimeInMillis();

		Map<String, Object> paramMap = getExtrasMap();

		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Start time for send invite : " + startTime);
			}

			try {
				long companyId = (Long) paramMap.get(FIELDS.COMPANY_ID);
				long scopeGroupId = (Long) paramMap.get(FIELDS.SCOPE_GROUP_ID);
				long userId = (Long) paramMap.get(FIELDS.USER_ID);
				long spGroupId = (Long) paramMap.get(FIELDS.SP_GROUP_ID);
				String updateFrequency = (String) paramMap.get(FIELDS.UPDATE_FREQUENCY);
				_log.error("spGroupId " + spGroupId);
				try {

					spGroup = SPGroupLocalServiceUtil.getSPGroup(spGroupId);

					SPMailTemplate spMailTemplate = SPGroupUpdatesUtil.getSPMailTemplate(companyId, scopeGroupId,
							userId);

					String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
							PropsKeys.ADMIN_EMAIL_FROM_NAME);

					String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
							PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

					content = spMailTemplate.getHtmlContent();
					String subject = "[$GROUP_TITLE$] : " + updateFrequency.substring(0,1).toUpperCase()+ updateFrequency.substring(1) + " Digest";//spMailTemplate.getSubject();
					//_log.error(" mail content " + content);
					String groupUrl = String.format("%s/%s/-/groups/%s"
							, SambaashUtil.getPortalURL(companyId, scopeGroupId)
							, SambaashUtil.getParameter(SambaashConstants.URL.GROUP_DETAIL, scopeGroupId)
							, spGroup.getUrlTitle());
					
					content = StringUtil.replace(content, new String[] { "[$GROUP_TITLE$]" , "[$GROUP_URL$]"},
							new String[] { spGroup.getTitle(), groupUrl });

                    subject = StringUtil.replace(subject, new String[] { "[$GROUP_TITLE$]" },
                            new String[] { spGroup.getTitle() });

					int interval = 7;

					if (updateFrequency.equalsIgnoreCase("Daily")) {
						interval = 1;
					} else if (updateFrequency.equalsIgnoreCase("Weekly")) {
						interval = 7;
					} else if (updateFrequency.equalsIgnoreCase("Monthly")) {
						interval = 30;
					} else if (updateFrequency.equalsIgnoreCase("Yearly")) {
						interval = 365;
					}
					//_log.error(" subject " + subject);
					Calendar cal = CalendarFactoryUtil.getCalendar(TimeZoneUtil.getDefault(), LocaleUtil.getDefault());
					cal.add(Calendar.DATE, -interval);
					Date fromDate = cal.getTime();

					// updates
					//_log.error("fromDate " + fromDate);
					//_log.error("spGroup " + spGroup.getCreateDate() + " spGroup Modified Date " + spGroup.getModifiedDate());
					long spGroupClassNameId = ClassNameLocalServiceUtil.getClassNameId(SPGroup.class.getName());
					int mIndex = 0;

					DynamicQuery dynamicQuery2 = DynamicQueryFactoryUtil.forClass(MBMessage.class,
							PortalClassLoaderUtil.getClassLoader());
					dynamicQuery2.add(PropertyFactoryUtil.forName("classPK").eq(new Long(spGroupId)));
					dynamicQuery2.add(PropertyFactoryUtil.forName("classNameId").eq(new Long(spGroupClassNameId)));
					dynamicQuery2.add(RestrictionsFactoryUtil.between("createDate", fromDate, new Date()));
					dynamicQuery2.addOrder(OrderFactoryUtil.desc("modifiedDate"));

					List<MBMessage> newSPGroupDiscussions = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery2, 0, 5);

					new DiscussionTree(newSPGroupDiscussions).addListener(this).walkTheTree();
					

					/**
					 * solution:
					 * http://michi-path.blogspot.sg/2013/08/while-using-dynamic-query-getting.html
					 */
					DynamicQuery dynamicQuery1 = DynamicQueryFactoryUtil.forClass(SPGroupUser.class);
					dynamicQuery1.add(PropertyFactoryUtil.forName("primaryKey.spGroupId").eq(new Long(spGroupId)));
					dynamicQuery1.add(PropertyFactoryUtil.forName("status")
							.eq(new Integer(SPGroupUserStatus.APPROVE.getValue())));
					dynamicQuery1.add(RestrictionsFactoryUtil.between("joinDate", fromDate, new Date()));
					dynamicQuery1.addOrder(OrderFactoryUtil.desc("joinDate"));

					List<SPGroupUser> newSPGroupUsers = SPGroupUserLocalServiceUtil.dynamicQuery(dynamicQuery1, 0, 5);
					
					if(Validator.isNotNull(newSPGroupUsers) && !newSPGroupUsers.isEmpty()){
						for (SPGroupUser newSPGroupUser : newSPGroupUsers) {
							long newSPGroupUserId = newSPGroupUser.getUserId();
							try {
								User newSPGroupUser_ = UserLocalServiceUtil.getUser(newSPGroupUserId);
								String memberName = newSPGroupUser_.getFullName();
								String memberScreenName = newSPGroupUser_.getScreenName();
								String memberPortrait = Util.getUserPortraitAsBase64String(companyId, newSPGroupUser_.getGroupId(), newSPGroupUser_.getPortraitId());
								String memberProfileURL = SambaashUtil.getPortalURL(companyId, scopeGroupId) + "/"
										+ memberScreenName;
								content = StringUtil.replace(content,
										new String[] { "[$MEMBER_DISPLAY_" + mIndex + "$]",
												"[$MEMBER_PORTRAIT_" + mIndex + "$]", "[$MEMBER_NAME_" + mIndex + "$]",
												"[$MEMBER_PROFILE_URL_" + mIndex + "$]", "[$NEW_MEMBERS$]"},
										new String[] { "block", memberPortrait, memberName, memberProfileURL ,"New Members:"});
	
							} catch (NoSuchUserException nsue) {
	
								_log.error("NoSuchUserException " + nsue.getMessage());
	
							}
	
							mIndex++;
						}
				   }else{
					   content = StringUtil.replace(content,
								new String[] { "[$NEW_MEMBERS$]"},
								new String[] {StringPool.BLANK});
				   }
					_log.debug(" newSPGroupUser ");
					for (int dpIndexL = 0; dpIndexL < 5; dpIndexL++) { // hide the rest that were not replaced
						content = StringUtil.replace(content,
								new String[] { "[$DISCUSSION_DISPLAY_" + dpIndexL + "$]", "[$DISCUSSION_PARENT_DISPLAY_" + dpIndexL + "$]" }, new String[] { "none", "none" });
					}

					if (mIndex < 4) {
						for (int mIndexL = mIndex; mIndexL <= 4; mIndexL++) {
							content = StringUtil.replace(content, new String[] { "[$MEMBER_DISPLAY_" + mIndexL + "$]" },
									new String[] { "none" });
						}
					}

					List<SPGroupUser> spGroupUsers = SPGroupUserLocalServiceUtil.findBySPGroupIdAndStatus(spGroupId,
							SPGroupUserStatus.APPROVE.getValue(), 0, 9);
					_log.debug("newSPGroupUsers " + newSPGroupUsers);
					_log.error("newSPGroupDiscussions ^^ " + newSPGroupDiscussions);
					if(!newSPGroupDiscussions.isEmpty()){
						for (SPGroupUser spGroupMember : spGroupUsers) {
							long memberId = spGroupMember.getUserId();
							User member = null;
							String contentForUser = StringPool.BLANK;
							try {
								member = UserLocalServiceUtil.getUser(memberId);
								contentForUser = StringUtil.replace(content, new String[] { "[$TO_NAME$]" },
										new String[] { member.getFullName() });
							} catch (com.liferay.portal.NoSuchUserException nsue) {
	
								_log.error("NoSuchUserException " + nsue.getMessage());
	
							}
							MailMessage mailMessage = new MailMessage();
							mailMessage.setFromAddress(fromAddress);
							mailMessage.setFromName(fromName);
							mailMessage.setSubject(subject);
							mailMessage.setHtmlBody(contentForUser);
							mailMessage.setToAddress(member.getEmailAddress());
	
							_log.debug("Final html content : " + mailMessage.getHtmlBody());
							SPMailLocalServiceUtil.sendMail(mailMessage);
	
						}
					}else{
						_log.error("Final html content : no email sent");
					}
					
					long endTime = Calendar.getInstance().getTimeInMillis();

					if (_log.isDebugEnabled()) {
						_log.debug("End time for send invite : " + endTime);
					}

					_log.error("Total time taken for blast : " + getTotalTime(endTime - startTime));

				} catch (NoSuchSPGroupException nsspge) {

					_log.error("NoSuchSPGroupException " + nsspge.getMessage());

				}
			} catch (NumberFormatException nfe) {

				_log.error("NumberFormatException " + nfe.getMessage());

			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}

	public String getTotalTime(long diffMSec) {
		int left = 0;
		int ss = 0;
		int mm = 0;
		int hh = 0;
		int dd = 0;
		left = (int) (diffMSec / 1000);
		ss = left % 60;
		left = (int) left / 60;

		if (left > 0) {
			mm = left % 60;
			left = (int) left / 60;

			if (left > 0) {
				hh = left % 24;
				left = (int) left / 24;

				if (left > 0) {
					dd = left;
				}
			}
		}

		StringBuffer diff = new StringBuffer();
		diff.append(dd).append(StringPool.SPACE).append(StringPool.COLON).append(StringPool.SPACE).append(hh)
				.append(StringPool.SPACE).append(StringPool.COLON).append(StringPool.SPACE).append(mm)
				.append(StringPool.SPACE).append(StringPool.COLON).append(StringPool.SPACE).append(ss)
				.append(StringPool.SPACE).append(StringPool.COLON).append(StringPool.SPACE);

		return diff.toString();
	}

	private String getDiscussionTitle(MBMessage message) {
		return message.getSubject().equals(String.valueOf(message.getClassPK()))
				? message.getBody() : message.getSubject();
	}

	@Override
	public void onDiscussionContentTraversed(MBMessage message, int level) {
		int indention = getIndentionSize(level);
		String discussionTitle = getDiscussionTitle(message);
		String discussionDetailURL = SambaashUtil.getPortalURL(message.getCompanyId(), message.getGroupId())
				+ "/discussion-detail/-/discussions/" + spGroup.getUrlTitle() + "/discussion/"
				+ message.getMessageId();
		content = StringUtil.replace(content, new String[] { "[$DISCUSSION_DISPLAY_" + dIndex + "$]",
				"[$DISCUSSION_TITLE_" + dIndex + "$]", "[$DISCUSSION_DETAIL_URL_" + dIndex + "$]",
				"[$DISCUSSION_INDENT_" + dIndex + "$]" },
				new String[] { "block", discussionTitle, discussionDetailURL, String.valueOf(indention) });
		dIndex++;
	}

	@Override
	public void onMissingDiscussion(long discussionId, int level) {
		try {
			MBMessage message = MBMessageLocalServiceUtil.getMBMessage(discussionId);
			int indention = getIndentionSize(level);
			String discussionTitle = isParentDiscussionThisGroup(message) ?
					spGroup.getTitle() : getDiscussionTitle(message);
			String discussionDetailURL = SambaashUtil.getPortalURL(message.getCompanyId(), message.getGroupId())
					+ "/discussion-detail/-/discussions/" + spGroup.getUrlTitle() + "/discussion/"
					+ message.getMessageId();
			content = StringUtil.replace(content, new String[] { "[$DISCUSSION_PARENT_DISPLAY_" + dIndex + "$]",
					"[$DISCUSSION_PARENT_TITLE_" + dIndex + "$]", "[$DISCUSSION_PARENT_DETAIL_URL_" + dIndex + "$]",
					"[$DISCUSSION_PARENT_INDENT_" + dIndex + "$]" },
					new String[] { "block", discussionTitle, discussionDetailURL, String.valueOf(indention) });
		} catch (Exception e) {
			_log.error("Unable to get parent discussion.", e);
		}
	}

	private int getIndentionSize(int level) {
		int indention = INDENT_SIZE * (level) + 13;
		return indention;
	}

	private boolean isParentDiscussionThisGroup(MBMessage parentMB) {
		try {
			long subjectId = Long.parseLong(parentMB.getSubject());
			long bodyId = Long.parseLong(parentMB.getBody());
			return (subjectId == spGroup.getSpGroupId()) && (subjectId == bodyId);
		} catch (Exception e) {
			return false;
		}
	}

}