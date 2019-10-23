package com.sambaash.platform.portlet.spgroup.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.htmlparser.util.ParserException;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.sambaash.platform.constant.ClassConstant;
import com.sambaash.platform.model.ActivityFeedType;
import com.sambaash.platform.model.SPGroupType;
import com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm;
import com.sambaash.platform.model.spneo4j.form.RealtimeActivityFeedForm;
import com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper;
import com.sambaash.platform.portlet.spgroup.util.Util;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.service.SPGroupLocalServiceUtil;
import com.sambaash.platform.util.Neo4jHelper;
import com.sambaash.platform.util.SPHtmlUtil;
import com.sambaash.platform.util.SambaashUtil;
public class SPGroupDiscussionGraphListener extends BaseModelListener<MBMessage>{

	public void onAfterCreate(MBMessage mbMessage) throws ModelListenerException {
		try {
			if (SPGroup.class.getName().equalsIgnoreCase(mbMessage.getClassName())) {
				boolean isRootMessage = mbMessage.getParentMessageId()==0 
						&& mbMessage.getClassPK() == Long.parseLong(mbMessage.getSubject())
						&& mbMessage.getClassPK() == Long.parseLong(mbMessage.getBody())
						&& mbMessage.getRootMessageId() == mbMessage.getMessageId();
				if (SambaashUtil.isNeo4jEnabled() && mbMessage.getStatus()==0 && (mbMessage.getParentMessageId()>0 || isRootMessage)) {
					_log.debug("***************** onAfterCreate mbMessage ********************");
					populateGraphDb(mbMessage);
				}
			}
		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	private void populateGraphDb(MBMessage mbMessage) throws PortalException,
			SystemException, ParserException {
		try {
			SPGroup spGroup = SPGroupLocalServiceUtil.getSPGroup(mbMessage.getClassPK());
			String communityName = PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);

			long classPK = mbMessage.getMessageId();
			String title = mbMessage.getSubject();
			String urlTitle = spGroup.getUrlTitle();
			String content = mbMessage.getBody();
			long userId = mbMessage.getUserId();
			int status = mbMessage.getStatus();
			Date createDate = mbMessage.getCreateDate();
			Date modifiedDate = mbMessage.getModifiedDate();

			int type = spGroup.getType();

			String imageUrl = Util.getImageUrlFromHtml(content);

			AssetEntityGraphForm assetEntityGraphForm = new AssetEntityGraphForm();

			assetEntityGraphForm.setClassName(MBMessage.class.getName());
			assetEntityGraphForm.setClassPK(classPK);
			assetEntityGraphForm.setTitle(title);
			assetEntityGraphForm.setUrlTitle(urlTitle);
			assetEntityGraphForm.setContent(SPHtmlUtil.shortenHtmlText(content, 400));
			assetEntityGraphForm.setImageUrl(imageUrl);
			assetEntityGraphForm.setUserId(userId);
			assetEntityGraphForm.setStatus(status);
			assetEntityGraphForm.setCreateDate(createDate);
			assetEntityGraphForm.setModifiedDate(modifiedDate);
			assetEntityGraphForm.setParentId(mbMessage.getParentMessageId());

			assetEntityGraphForm.setReferenceId(spGroup.getSpGroupId());
			assetEntityGraphForm.setReferenceTitle(spGroup.getTitle());
			assetEntityGraphForm.setReferenceUrlTitle(spGroup.getUrlTitle());
			assetEntityGraphForm.setReferenceClassId(ClassConstant.SPGROUP_CLASSNAME_ID);

			assetEntityGraphForm.setCommunityName(communityName);
			Neo4jHelper.fillMandatoryFields(assetEntityGraphForm, spGroup.getCompanyId(), spGroup.getGroupId(), -1L);
			
			SPNeoforjLocalServiceUtil.addAssetEntityGraph(assetEntityGraphForm);

			// push real time activity

			if (status == 0 && type != SPGroupType.ADMIN.getValue()) {
				List<UserGraphWrapper> followers = SPNeoforjLocalServiceUtil.findUserFollowers(spGroup.getUserId(), spGroup.getCompanyId(), spGroup.getGroupId(), -1L, 0,
						100000);
				List<String> sendToUsers = new ArrayList<String>();

				for (UserGraphWrapper follower : followers) {
					sendToUsers.add(follower.getScreenName());
				}

				if (SambaashUtil.isWebSocketEnabled()) {
					SPNeoforjLocalServiceUtil.pushRealtimeActivityFeed(new RealtimeActivityFeedForm(communityName, MBMessage.class
							.getName(), classPK, ActivityFeedType.ADD_ENTITY.getValue(), sendToUsers));
				}
			}
		}catch (NoSuchSPGroupException nsspge) {

			// do nothing

		}
	}

	public void onAfterRemove(MBMessage mbMessage) throws ModelListenerException {
		try {
			if (SPGroup.class.getName().equalsIgnoreCase(mbMessage.getClassName())) {
				if (SambaashUtil.isNeo4jEnabled()) {
					_log.debug("***************** onAfterRemove mbMessage ********************");
					long classPK = mbMessage.getClassPK();
					SPNeoforjLocalServiceUtil.removeAssetEntityGraph(MBMessage.class.getName(), classPK, mbMessage.getCompanyId(), mbMessage.getGroupId(), -1L);
				}
			}

		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	public void onAfterUpdate(MBMessage mbMessage) throws ModelListenerException {
		try {
			if (SPGroup.class.getName().equalsIgnoreCase(mbMessage.getClassName())) {
				// when replying on discussion at the SPGroup Details screen
				// the onAfterCreate will not be able to get the complete data yet
				// because the final message is updated with the reference detail after creation
				// see SPGroupDiscussionDetailAction.addReplyJsonString()
				boolean isRootMessage = mbMessage.getParentMessageId()==0 
						&& mbMessage.getClassPK() == Long.parseLong(mbMessage.getSubject())
						&& mbMessage.getClassPK() == Long.parseLong(mbMessage.getBody())
						&& mbMessage.getRootMessageId() == mbMessage.getMessageId();
				if (SambaashUtil.isNeo4jEnabled() && mbMessage.getStatus()==0 && (mbMessage.getParentMessageId()>0 || isRootMessage)) {
					_log.debug("***************** onAfterUpdate mbMessage ********************");
					populateGraphDb(mbMessage);
				}
			}

		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPGroupDiscussionGraphListener.class);

}