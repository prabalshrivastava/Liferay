package com.sambaash.platform.portlet.spneo4j.listener;

import java.util.Date;

import org.htmlparser.util.ParserException;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.sambaash.platform.constant.ClassConstant;
import com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm;
import com.sambaash.platform.portlet.spneo4j.util.Util;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.util.Neo4jHelper;
import com.sambaash.platform.util.SPHtmlUtil;
import com.sambaash.platform.util.SambaashUtil;

public class MBMessageGraphListener extends BaseModelListener<MBMessage>{

	public void onAfterCreate(MBMessage mbMessage) throws ModelListenerException {
		try {
			String className = mbMessage.getClassName();
			boolean isFeedClass = ClassConstant.isActivityFeedClass(className) && !className.equals(SPGroup.class.getName());
			if (isFeedClass && mbMessage.getStatus()==0 && SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterCreate mbMessage ********************");
				populateGraphDB(mbMessage);
			}
		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	private void populateGraphDB(MBMessage mbMessage) throws ParserException,
			PortalException, SystemException {
		try {
			String communityName = PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);

			long classPK = mbMessage.getMessageId();
			String title = mbMessage.getSubject();
			String content = mbMessage.getBody();
			long userId = mbMessage.getUserId();
			int status = mbMessage.getStatus();
			Date createDate = mbMessage.getCreateDate();
			Date modifiedDate = mbMessage.getModifiedDate();

			String imageUrl = Util.getImageUrlFromHtml(content);

			AssetEntityGraphForm assetEntityGraphForm = new AssetEntityGraphForm();

			assetEntityGraphForm.setClassName(MBMessage.class.getName());
			assetEntityGraphForm.setClassPK(classPK);
			assetEntityGraphForm.setTitle(title);
			assetEntityGraphForm.setContent(SPHtmlUtil.shortenHtmlText(content, 400));
			assetEntityGraphForm.setImageUrl(imageUrl);
			assetEntityGraphForm.setUserId(userId);
			assetEntityGraphForm.setStatus(status);
			assetEntityGraphForm.setCreateDate(createDate);
			assetEntityGraphForm.setModifiedDate(modifiedDate);
			assetEntityGraphForm.setParentId(mbMessage.getParentMessageId());

			addReferenceDetails(assetEntityGraphForm, mbMessage);

			assetEntityGraphForm.setCommunityName(communityName);
			Neo4jHelper.fillMandatoryFields(assetEntityGraphForm, mbMessage.getCompanyId(), mbMessage.getGroupId(), -1L);
			
			SPNeoforjLocalServiceUtil.addAssetEntityGraph(assetEntityGraphForm);

		} catch (NoSuchSPGroupException nsspge) {
			// do nothing
		}
	}

	private void addReferenceDetails(AssetEntityGraphForm assetEntityGraphForm,
			MBMessage mbMessage) throws PortalException, SystemException {
		String urlTitle = null, referenceTitle = null, referenceUrlTitle = null;
		long classnameId = mbMessage.getClassNameId();
		long refId = mbMessage.getClassPK();
		assetEntityGraphForm.setReferenceClassId(classnameId);
		assetEntityGraphForm.setReferenceId(refId);
		
		if (classnameId==ClassConstant.BLOGS_ENTRY_CLASSNAME_ID) {
			BlogsEntry blogsEntry = BlogsEntryLocalServiceUtil.getBlogsEntry(refId);
			urlTitle = blogsEntry.getUrlTitle();
			referenceTitle = blogsEntry.getTitle();
			referenceUrlTitle = blogsEntry.getUrlTitle();	
		} else if (classnameId==ClassConstant.SPCHALLENGE_CLASSNAME_ID) {
			SPChallenge challenge = SPChallengeLocalServiceUtil.getSPChallenge(refId);		
			urlTitle = SPChallengeLocalServiceUtil.displayChallengeFriendlyURL(null, refId);
			referenceTitle = challenge.getName();
			referenceUrlTitle = urlTitle;	
		} else if (classnameId==ClassConstant.SPASSET_ENTRY_CLASSNAME_ID) {
			SPAssetEntry asset = SPAssetEntryLocalServiceUtil.getSPAssetEntry(refId);
			urlTitle = asset.getUrlTitle();
			referenceTitle = asset.getTitle();
			referenceUrlTitle = urlTitle;
		} else if (classnameId==ClassConstant.CALENDAR_BOOKING_CLASSNAME_ID) {
			CalendarBooking calendarBooking = CalendarBookingLocalServiceUtil.getCalendarBooking(refId);
			urlTitle = calendarBooking.getTitle();
			referenceTitle = urlTitle;
			referenceUrlTitle = urlTitle;
		}
		assetEntityGraphForm.setUrlTitle(urlTitle);
		assetEntityGraphForm.setReferenceTitle(referenceTitle);
		assetEntityGraphForm.setReferenceUrlTitle(referenceUrlTitle);
		
	}

	public void onAfterRemove(MBMessage mbMessage) throws ModelListenerException {
		try {
			String className = mbMessage.getClassName();
			boolean isFeedClass = ClassConstant.isActivityFeedClass(className) && !className.equals(SPGroup.class.getName());
			if (isFeedClass && mbMessage.getStatus()==0 && SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterRemove mbMessage ********************");
				long classPK = mbMessage.getMessageId();
				SPNeoforjLocalServiceUtil.removeAssetEntityGraph(MBMessage.class.getName(), classPK, mbMessage.getCompanyId(), mbMessage.getGroupId(), -1L);
			}
		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	public void onAfterUpdate(MBMessage mbMessage) throws ModelListenerException {
		try {
			String className = mbMessage.getClassName();
			boolean isFeedClass = ClassConstant.isActivityFeedClass(className) && !className.equals(SPGroup.class.getName());
			// when replying on discussion at the Activity Feed screen
			// the onAfterCreate will not be able to get the complete data yet
			// because the final message is updated with the reference detail after creation
			// see ActivityFeedAction.addReplyJsonString()
			if (isFeedClass && mbMessage.getStatus()==0 && SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterUpdate mbMessage ********************");
				populateGraphDB(mbMessage);
			}
		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MBMessageGraphListener.class);

}