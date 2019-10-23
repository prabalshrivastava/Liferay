package com.sambaash.platform.portlet.spgroup.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.BaseModelListener;
import com.sambaash.platform.model.ActivityFeedType;
import com.sambaash.platform.model.SPGroupType;
import com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm;
import com.sambaash.platform.model.spneo4j.form.RealtimeActivityFeedForm;
import com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.util.Neo4jHelper;
import com.sambaash.platform.util.SPHtmlUtil;
import com.sambaash.platform.util.SambaashUtil;
public class SPGroupGraphListener extends BaseModelListener<SPGroup> {

	@Override
	public void onAfterCreate(SPGroup spGroup) throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterCreate spGroup ********************");

				String communityName = PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);

				long classPK = spGroup.getSpGroupId();
				String title = spGroup.getTitle();
				String urlTitle = spGroup.getUrlTitle();
				String content = spGroup.getDescription();
				long userId = spGroup.getUserId();
				int status = spGroup.getStatus();
				Date createDate = spGroup.getCreateDate();
				Date modifiedDate = spGroup.getModifiedDate();
				int type = spGroup.getType();

				String imageUrl = "/image/image_gallery?img_id=" + spGroup.getImageId() + "&t=" + modifiedDate.getTime();

				AssetEntityGraphForm assetEntityGraphForm = new AssetEntityGraphForm();

				assetEntityGraphForm.setClassName(SPGroup.class.getName());
				assetEntityGraphForm.setClassPK(classPK);
				assetEntityGraphForm.setTitle(title);
				assetEntityGraphForm.setUrlTitle(urlTitle);
				assetEntityGraphForm.setContent(SPHtmlUtil.shortenHtmlText(content, 400));
				assetEntityGraphForm.setImageUrl(imageUrl);
				assetEntityGraphForm.setUserId(userId);
				assetEntityGraphForm.setStatus(status);
				assetEntityGraphForm.setCreateDate(createDate);
				assetEntityGraphForm.setModifiedDate(modifiedDate);

				assetEntityGraphForm.setType(type);

				assetEntityGraphForm.setCommunityName(communityName);
				Neo4jHelper.fillMandatoryFields(assetEntityGraphForm, spGroup.getCompanyId(), spGroup.getGroupId(), -1L);
				
				SPNeoforjLocalServiceUtil.addAssetEntityGraph(assetEntityGraphForm);

				// push real time activity

				if (status == 0 && type != SPGroupType.ADMIN.getValue()) {
					List<UserGraphWrapper> followers = SPNeoforjLocalServiceUtil.findUserFollowers(spGroup.getUserId(), spGroup.getCompanyId(), spGroup.getGroupId(), -1L , 0,
							100000);
					List<String> sendToUsers = new ArrayList<String>();
					if (followers != null) {
						
						for (UserGraphWrapper follower : followers) {
							sendToUsers.add(follower.getScreenName());
						}

						if (SambaashUtil.isWebSocketEnabled()) {
							SPNeoforjLocalServiceUtil.pushRealtimeActivityFeed(new RealtimeActivityFeedForm(communityName, SPGroup.class
									.getName(), classPK, ActivityFeedType.ADD_ENTITY.getValue(), sendToUsers));
						}					
					}
				}
			}

		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	@Override
	public void onAfterRemove(SPGroup spGroup) throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterRemove spGroup ********************");

				long classPK = spGroup.getSpGroupId();

				SPNeoforjLocalServiceUtil.removeAssetEntityGraph(SPGroup.class.getName(), classPK, spGroup.getCompanyId(), spGroup.getGroupId(), -1L);
			}

		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	@Override
	public void onAfterUpdate(SPGroup spGroup) throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterUpdate spGroup ********************");

				String communityName = PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);

				long classPK = spGroup.getSpGroupId();

				AssetEntityGraphWrapper assetEntityGraphWrapper = SPNeoforjLocalServiceUtil.findAssetEntityGraph(spGroup.getCompanyId(), spGroup.getGroupId(), -1L,
						SPGroup.class.getName(), classPK);
				int oldStatus = assetEntityGraphWrapper.getStatus();

				String title = spGroup.getTitle();
				String urlTitle = spGroup.getUrlTitle();
				String content = spGroup.getDescription();
				int status = spGroup.getStatus();
				Date modifiedDate = spGroup.getModifiedDate();

				int type = spGroup.getType();

				String imageUrl = SambaashUtil.getPortalURL(spGroup.getCompanyId(), spGroup.getGroupId()) + "/image/image_gallery?img_id=" + spGroup.getImageId() + "&t=" + modifiedDate.getTime();;

				AssetEntityGraphForm assetEntityGraphForm = new AssetEntityGraphForm();
				assetEntityGraphForm.setClassName(SPGroup.class.getName());
				assetEntityGraphForm.setClassPK(classPK);
				assetEntityGraphForm.setTitle(title);
				assetEntityGraphForm.setUrlTitle(urlTitle);
				assetEntityGraphForm.setContent(SPHtmlUtil.shortenHtmlText(content, 400));
				assetEntityGraphForm.setImageUrl(imageUrl);
				assetEntityGraphForm.setStatus(status);
				assetEntityGraphForm.setModifiedDate(modifiedDate);
				assetEntityGraphForm.setType(type);

				assetEntityGraphForm.setCommunityName(communityName);
				Neo4jHelper.fillMandatoryFields(assetEntityGraphForm, spGroup.getCompanyId(), spGroup.getGroupId(), -1L);
				SPNeoforjLocalServiceUtil.updateAssetEntityGraph(assetEntityGraphForm);

				// push real time activity

				if ((oldStatus != 0 && status == 0) && type != SPGroupType.ADMIN.getValue()) {
					List<UserGraphWrapper> followers = SPNeoforjLocalServiceUtil.findUserFollowers(spGroup.getUserId(), spGroup.getCompanyId(), spGroup.getGroupId(), -1L, 0,
							100000);
					List<String> sendToUsers = new ArrayList<String>();

					for (UserGraphWrapper follower : followers) {
						sendToUsers.add(follower.getScreenName());
					}

					if (SambaashUtil.isWebSocketEnabled()) {
						SPNeoforjLocalServiceUtil.pushRealtimeActivityFeed(new RealtimeActivityFeedForm(communityName, SPGroup.class
								.getName(), classPK, ActivityFeedType.ADD_ENTITY.getValue(), sendToUsers));
					}
				}
			}

		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPGroupGraphListener.class);

}