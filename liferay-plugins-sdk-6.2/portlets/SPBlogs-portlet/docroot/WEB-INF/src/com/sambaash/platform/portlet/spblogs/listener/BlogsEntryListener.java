package com.sambaash.platform.portlet.spblogs.listener;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.sambaash.platform.portlet.spblogs.notification.SPBlogsNotificationConstants;

public class BlogsEntryListener  extends BaseModelListener<BlogsEntry> {
	private static final Log _log = LogFactoryUtil.getLog(BlogsEntryListener.class);
	private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(5);

	@Override
	public void onAfterCreate(BlogsEntry blogsEntry) throws ModelListenerException {
		notifyBlogActivity(SPBlogsNotificationConstants.NOTIFICATION_TYPE_BLOG_CREATED, blogsEntry);
	}

	@Override
	public void onAfterRemove(BlogsEntry blogsEntry) throws ModelListenerException {
		notifyBlogActivity(SPBlogsNotificationConstants.NOTIFICATION_TYPE_BLOG_DELETED, blogsEntry);
	}

	@Override
	public void onAfterUpdate(BlogsEntry blogsEntry) throws ModelListenerException {
		notifyBlogActivity(SPBlogsNotificationConstants.NOTIFICATION_TYPE_BLOG_MODIFIED, blogsEntry);		
	}

	public static void shutdown() {
		EXECUTOR.shutdown();
	}
	
	protected void notifyBlogActivity(int type, BlogsEntry entry) 
	{
		if (entry.getStatus() != 0) {
			return;
		}
		long userId = entry.getStatusByUserId();
		JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
		payloadJSON.put(SPBlogsNotificationConstants.NOTIFICATION_TYPE, type);
		String spBlogDetailURL = "%s/-/blogs/%s";
		spBlogDetailURL = String.format(spBlogDetailURL, "/blog", entry.getUrlTitle());
		payloadJSON.put(SPBlogsNotificationConstants.LINK, spBlogDetailURL);
		payloadJSON.put(SPBlogsNotificationConstants.USER_NAME, entry.getStatusByUserName());
		payloadJSON.put(SPBlogsNotificationConstants.TITLE, entry.getTitle());
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUuid(UUID.randomUUID().toString());
		try {
			for(User notifiedUser : UserLocalServiceUtil.getCompanyUsers(entry.getCompanyId(), -1, -1)) {
				if (notifiedUser.getUserId() != userId) {
					EXECUTOR.submit(new NotificationTask(serviceContext, payloadJSON, notifiedUser, userId));
				}
			}
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	private class NotificationTask implements Runnable {
		private JSONObject payloadJSON;
		private ServiceContext serviceContext;
		private User notifiedUser;
		private long userId;
		
		public NotificationTask(ServiceContext serviceContext, JSONObject payloadJSON, User notifyUser, long fromUserId) {
			this.payloadJSON = payloadJSON;
			this.serviceContext = serviceContext;
			this.notifiedUser = notifyUser;
			this.userId = fromUserId;
		}
		
		@Override
		public void run() {
		    try {
				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(notifiedUser.getUserId(), 
						SPBlogsNotificationConstants.PORTLET_ID, (new Date()).getTime(), userId,
						payloadJSON.toString(), false, serviceContext);
			} catch (PortalException | SystemException e) {
				_log.error(e);
			}					
		}
		
	}
}
