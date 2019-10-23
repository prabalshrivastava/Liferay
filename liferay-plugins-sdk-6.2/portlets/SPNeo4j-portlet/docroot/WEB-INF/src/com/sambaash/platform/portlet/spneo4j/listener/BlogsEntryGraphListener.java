package com.sambaash.platform.portlet.spneo4j.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.sambaash.platform.model.ActivityFeedType;
import com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm;
import com.sambaash.platform.model.spneo4j.form.RealtimeActivityFeedForm;
import com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper;
import com.sambaash.platform.portlet.spneo4j.util.Util;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.util.Neo4jHelper;
import com.sambaash.platform.util.SPHtmlUtil;
import com.sambaash.platform.util.SambaashUtil;

public class BlogsEntryGraphListener extends BaseModelListener<BlogsEntry> {

	@Override
	public void onAfterCreate(BlogsEntry blogsEntry)
			throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterCreate blogsEntry ********************");

				String communityName = getCommunityName(blogsEntry);

				long classPK = blogsEntry.getEntryId();
				String title = blogsEntry.getTitle();
				String urlTitle = blogsEntry.getUrlTitle();
				String content = blogsEntry.getContent();
				long userId = blogsEntry.getUserId();
				int status = blogsEntry.getStatus();
				Date createDate = blogsEntry.getCreateDate();
				Date modifiedDate = blogsEntry.getModifiedDate();

				String imageUrl = Util.getImageUrlFromHtml(content);

				AssetEntityGraphForm assetEntityGraphForm = new AssetEntityGraphForm();

				assetEntityGraphForm.setClassName(BlogsEntry.class.getName());
				assetEntityGraphForm.setClassPK(classPK);
				assetEntityGraphForm.setTitle(title);
				assetEntityGraphForm.setUrlTitle(urlTitle);
				assetEntityGraphForm.setContent(SPHtmlUtil.shortenHtmlText(content, 400));
				assetEntityGraphForm.setImageUrl(imageUrl);
				assetEntityGraphForm.setUserId(userId);
				assetEntityGraphForm.setStatus(status);
				assetEntityGraphForm.setCreateDate(createDate);
				assetEntityGraphForm.setModifiedDate(modifiedDate);

				Neo4jHelper.fillMandatoryFields(assetEntityGraphForm,
						blogsEntry.getCompanyId(),
						blogsEntry.getGroupId(), -1L);

				SPNeoforjLocalServiceUtil
						.addAssetEntityGraph(assetEntityGraphForm);

				// push real time activity

				if (status == 0) {
					List<UserGraphWrapper> followers = SPNeoforjLocalServiceUtil
							.findUserFollowers(blogsEntry.getUserId(),
									blogsEntry.getCompanyId(),
									blogsEntry.getGroupId(), -1L, 0, 10000);
					List<String> sendToUsers = new ArrayList<String>();

					for (UserGraphWrapper follower : followers) {
						sendToUsers.add(follower.getScreenName());
					}

					if (SambaashUtil.isWebSocketEnabled()) {
						SPNeoforjLocalServiceUtil
								.pushRealtimeActivityFeed(new RealtimeActivityFeedForm(
										communityName, BlogsEntry.class
												.getName(), classPK,
										ActivityFeedType.ADD_ENTITY.getValue(),
										sendToUsers));
					}
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	private String getCommunityName(BlogsEntry blogsEntry)
			throws PortalException, SystemException {
		return SambaashUtil.getCommunityName(blogsEntry.getGroupId());
	}

	@Override
	public void onAfterRemove(BlogsEntry blogsEntry)
			throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterRemove blogsEntry ********************");

				long classPK = blogsEntry.getEntryId();

				SPNeoforjLocalServiceUtil
						.removeAssetEntityGraph(BlogsEntry.class.getName(),
								classPK, blogsEntry.getCompanyId(),
								blogsEntry.getGroupId(), -1L);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	@Override
	public void onAfterUpdate(BlogsEntry blogsEntry) {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterUpdate blogsEntry ********************");

				long classPK = blogsEntry.getEntryId();

				AssetEntityGraphWrapper assetEntityGraphWrapper = SPNeoforjLocalServiceUtil
						.findAssetEntityGraph(blogsEntry.getCompanyId(),
								blogsEntry.getGroupId(), -1L,
								BlogsEntry.class.getName(), classPK);
				int oldStatus = assetEntityGraphWrapper.getStatus();

				String title = blogsEntry.getTitle();
				String urlTitle = blogsEntry.getUrlTitle();
				String content = blogsEntry.getContent();
				int status = blogsEntry.getStatus();
				Date modifiedDate = blogsEntry.getModifiedDate();

				String imageUrl = Util.getImageUrlFromHtml(content);

				AssetEntityGraphForm assetEntityGraphForm = new AssetEntityGraphForm();
				assetEntityGraphForm.setClassName(BlogsEntry.class.getName());
				assetEntityGraphForm.setClassPK(classPK);
				assetEntityGraphForm.setTitle(title);
				assetEntityGraphForm.setUrlTitle(urlTitle);
//				assetEntityGraphForm.setContent(HtmlUtil.extractText(content));
				assetEntityGraphForm.setContent(SPHtmlUtil.shortenHtmlText(content, 400));
				assetEntityGraphForm.setImageUrl(imageUrl);
				assetEntityGraphForm.setStatus(status);
				assetEntityGraphForm.setModifiedDate(modifiedDate);
				assetEntityGraphForm.setUserId(blogsEntry.getUserId());

				Neo4jHelper.fillMandatoryFields(assetEntityGraphForm,
						blogsEntry.getCompanyId(),
						blogsEntry.getGroupId(), -1L);

				SPNeoforjLocalServiceUtil
						.updateAssetEntityGraph(assetEntityGraphForm);

				// push real time activity

				if (oldStatus != 0 && status == 0) {
					List<UserGraphWrapper> followers = SPNeoforjLocalServiceUtil
							.findUserFollowers(blogsEntry.getUserId(),
									blogsEntry.getCompanyId(),
									blogsEntry.getGroupId(), -1L, 0, 100000);
					List<String> sendToUsers = new ArrayList<String>();

					for (UserGraphWrapper follower : followers) {
						sendToUsers.add(follower.getScreenName());
					}

					if (SambaashUtil.isWebSocketEnabled()) {
						String communityName = getCommunityName(blogsEntry);
						SPNeoforjLocalServiceUtil
								.pushRealtimeActivityFeed(new RealtimeActivityFeedForm(
										communityName, BlogsEntry.class
												.getName(), classPK,
										ActivityFeedType.ADD_ENTITY.getValue(),
										sendToUsers));
					}
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil
			.getLog(BlogsEntryGraphListener.class);

}