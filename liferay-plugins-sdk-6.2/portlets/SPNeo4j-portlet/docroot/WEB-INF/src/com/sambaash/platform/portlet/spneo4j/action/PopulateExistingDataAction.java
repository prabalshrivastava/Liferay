package com.sambaash.platform.portlet.spneo4j.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.htmlparser.util.ParserException;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.ClassConstant;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm;
import com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm;
import com.sambaash.platform.model.spneo4j.form.UserGraphForm;
import com.sambaash.platform.portlet.spneo4j.exception.AssetCategoriesVocabularyIdNotSetupException;
import com.sambaash.platform.portlet.spneo4j.util.Util;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.model.SPAssetType;
import com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalServiceUtil;
import com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.model.SPGroupUser;
import com.sambaash.platform.srv.spgroup.service.SPGroupLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPLikes;
import com.sambaash.platform.srv.spservices.service.SPLikesLocalServiceUtil;
import com.sambaash.platform.util.Neo4jHelper;
import com.sambaash.platform.util.SPHtmlUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ThumbnailUtil;

/**
 * Portlet implementation class PopulateExistingDataAction
 */
public class PopulateExistingDataAction extends MVCPortlet {
	private Log _log = LogFactoryUtil.getLog(PopulateExistingDataAction.class);

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String action = ParamUtil.getString(actionRequest, "action");
		if ("populateExistingData".equalsIgnoreCase(action)) {

			try {
				// Users
				populateUserGraph(themeDisplay);

				// Asset Categories
				populateAssetCategoryGraph();

				List<AssetEntityGraphForm> assetEntityTypeGraphForms = new ArrayList<AssetEntityGraphForm>();
				addSPAssetEntryTypeToAssetEntityGraph(themeDisplay, assetEntityTypeGraphForms);
				SPNeoforjLocalServiceUtil.addAssetEntitiesInBatch(assetEntityTypeGraphForms);
				
				List<AssetEntityGraphForm> assetEntityGraphForms = new ArrayList<AssetEntityGraphForm>();
				
				List<SPGroup> spGroups = addSPGroupToAssetEntityGraph(themeDisplay, assetEntityGraphForms);
				addGroupDiscussionsToAssetEntityGraph(assetEntityGraphForms, themeDisplay,
						spGroups);

				// Blogs
				addBlogsToAssetEntityGraph(assetEntityGraphForms);
				
				// CalendarBooking
				addCalendarBookingToAssetEntityGraph(assetEntityGraphForms);
				
				// SPAssetEntry
				addSPAssetEntryToAssetEntityGraph(themeDisplay, assetEntityGraphForms);
				
				SPNeoforjLocalServiceUtil.addAssetEntitiesInBatch(assetEntityGraphForms);

				// SPGroup Users
				populateSPGroupUser(themeDisplay);

				// SPChallenges
				SPChallengeLocalServiceUtil.addAllChallengesToGraph();
				
				// SPLikes
				addSPLikesToDatabaseGraph();

				addSuccessMessage(actionRequest, actionResponse);
			} catch (Exception e) {
				if (e instanceof AssetCategoriesVocabularyIdNotSetupException) {
					SessionErrors.add(actionRequest, e.getClass().getName(), e);
				} else {
					_log.error(e.getMessage(), e);
					SessionErrors.add(actionRequest, "your-request-failed-to-complete");
				}
			}
		}
		super.processAction(actionRequest, actionResponse);
	}

	protected void populateSPGroupUser(ThemeDisplay themeDisplay)
			throws SystemException {
		List<SPGroupUser> spGroupUsers = SPGroupUserLocalServiceUtil.getSPGroupUsers(-1, -1);
		for (SPGroupUser spGroupUser : spGroupUsers) {
			SPNeoforjLocalServiceUtil.join(SambaashConstants.NEO4J.JOIN, spGroupUser.getUserId(),
					SPGroup.class.getName(), spGroupUser.getSpGroupId(), spGroupUser.getRole(),
					spGroupUser.getStatus(), spGroupUser.getCompanyId(), spGroupUser.getGroupId(),
					themeDisplay.getLayout().getLayoutId());
		}
	}

	protected void addCalendarBookingToAssetEntityGraph(
			List<AssetEntityGraphForm> assetEntityGraphForms)
			throws SystemException, ParserException {
		List<CalendarBooking> calBookings = CalendarBookingLocalServiceUtil.getCalendarBookings(-1, -1);
		for (CalendarBooking calBooking : calBookings) {

			long classPK = calBooking.getCalendarBookingId();
			String title = calBooking.getTitle();
			String content = calBooking.getDescription();
			long userId = calBooking.getUserId();
			Date createDate = calBooking.getCreateDate();
			Date modifiedDate = calBooking.getModifiedDate();

			String imageUrl = Util.getImageUrlFromHtml(content);

			AssetEntityGraphForm assetEntityGraphForm = new AssetEntityGraphForm();
			assetEntityGraphForm.setClassName(CalendarBooking.class.getName());
			assetEntityGraphForm.setClassPK(classPK);
			assetEntityGraphForm.setTitle(title);
			assetEntityGraphForm.setContent(SPHtmlUtil.shortenHtmlText(content, 400));
			assetEntityGraphForm.setImageUrl(imageUrl);
			assetEntityGraphForm.setUserId(userId);
			assetEntityGraphForm.setStatus(0);
			assetEntityGraphForm.setCreateDate(createDate);
			assetEntityGraphForm.setModifiedDate(modifiedDate);

			Neo4jHelper.fillMandatoryFields(assetEntityGraphForm, calBooking.getCompanyId(),
					calBooking.getGroupId(), -1L);

			long[] calCategoryIdArray = AssetCategoryLocalServiceUtil
					.getCategoryIds(CalendarBooking.class.getName(), calBooking.getCalendarBookingId());
			Long[] calCategoryIdArrayObjectArray = ArrayUtils.toObject(calCategoryIdArray);
			assetEntityGraphForm.setCategoryIds(Arrays.asList(calCategoryIdArrayObjectArray));

			assetEntityGraphForms.add(assetEntityGraphForm);
		}
	}

	protected void addSPAssetEntryTypeToAssetEntityGraph(ThemeDisplay themeDisplay,
			List<AssetEntityGraphForm> assetEntityGraphForms)
			throws SystemException, ParserException {
		List<SPAssetType> spAssetTypes = SPAssetTypeLocalServiceUtil.getSPAssetTypes(-1, -1);
		for (SPAssetType spAssetType : spAssetTypes) {
			long classPK = spAssetType.getSpAssetTypeId();
			String title = spAssetType.getSpAssetTypeName();
			String urlTitle = spAssetType.getSpAssetTypeName();
			String content = spAssetType.getSpAssetTypeName();
			long userId = spAssetType.getUserId();
			Date createDate = spAssetType.getCreateDate();
			Date modifiedDate = spAssetType.getModifiedDate();
			
			AssetEntityGraphForm assetEntityGraphForm = new AssetEntityGraphForm();
			assetEntityGraphForm.setClassName(SPAssetType.class.getName());
			assetEntityGraphForm.setClassPK(classPK);
			assetEntityGraphForm.setTitle(title);
			assetEntityGraphForm.setUrlTitle(urlTitle);
			assetEntityGraphForm.setContent(SPHtmlUtil.shortenHtmlText(content, 400));
			assetEntityGraphForm.setUserId(userId);
			assetEntityGraphForm.setStatus(0);
			assetEntityGraphForm.setCreateDate(createDate);
			assetEntityGraphForm.setModifiedDate(modifiedDate);

			Neo4jHelper.fillMandatoryFields(assetEntityGraphForm, spAssetType.getCompanyId(),
					spAssetType.getGroupId(), -1L);
			
			assetEntityGraphForms.add(assetEntityGraphForm);
		}
	}
	
	protected void addSPAssetEntryToAssetEntityGraph(ThemeDisplay themeDisplay,
			List<AssetEntityGraphForm> assetEntityGraphForms)
			throws SystemException, ParserException {
		List<SPAssetEntry> spAssetEntries = SPAssetEntryLocalServiceUtil.getSPAssetEntries(-1, -1);
		for (SPAssetEntry spAsset : spAssetEntries) {

			long classPK = spAsset.getSpAssetEntryId();
			String title = spAsset.getTitle();
			String urlTitle = spAsset.getUrlTitle();
			String content = spAsset.getDescription();
			long userId = spAsset.getUserId();
			Date createDate = spAsset.getCreateDate();
			Date modifiedDate = spAsset.getModifiedDate();

			String imageUrl = getAssetEntryImageUrl(themeDisplay, spAsset.getCoverFileEntryId());

			AssetEntityGraphForm assetEntityGraphForm = new AssetEntityGraphForm();
			assetEntityGraphForm.setClassName(SPAssetEntry.class.getName());
			assetEntityGraphForm.setClassPK(classPK);
			assetEntityGraphForm.setTitle(title);
			assetEntityGraphForm.setUrlTitle(urlTitle);
			assetEntityGraphForm.setContent(SPHtmlUtil.shortenHtmlText(content, 400));
			assetEntityGraphForm.setImageUrl(imageUrl);
			assetEntityGraphForm.setUserId(userId);
			assetEntityGraphForm.setStatus(0);
			assetEntityGraphForm.setCreateDate(createDate);
			assetEntityGraphForm.setModifiedDate(modifiedDate);
			assetEntityGraphForm.setType(spAsset.getSpAssetTypeId());

			Neo4jHelper.fillMandatoryFields(assetEntityGraphForm, spAsset.getCompanyId(),
					spAsset.getGroupId(), -1L);

			long[] calCategoryIdArray = AssetCategoryLocalServiceUtil
					.getCategoryIds(SPAssetEntry.class.getName(), spAsset.getSpAssetEntryId());
			Long[] calCategoryIdArrayObjectArray = ArrayUtils.toObject(calCategoryIdArray);
			assetEntityGraphForm.setCategoryIds(Arrays.asList(calCategoryIdArrayObjectArray));

			assetEntityGraphForms.add(assetEntityGraphForm);
		}
	}

	protected List<SPGroup> addSPGroupToAssetEntityGraph(ThemeDisplay themeDisplay,
			List<AssetEntityGraphForm> assetEntityGraphForms)
			throws SystemException, ParserException, PortalException {
		List<SPGroup> spGroups = SPGroupLocalServiceUtil.getSPGroups(-1, -1);
		for (SPGroup spGroup : spGroups) {

			long classPK = spGroup.getSpGroupId();
			String title = spGroup.getTitle();
			String urlTitle = spGroup.getUrlTitle();
			String content = spGroup.getDescription();
			long userId = spGroup.getUserId();
//			int status = spGroup.getStatus();
			Date createDate = spGroup.getCreateDate();
			Date modifiedDate = spGroup.getModifiedDate();

			String imageUrl = "/image/image_gallery?img_id=" + spGroup.getImageId() + "&t=" + modifiedDate.getTime();

			AssetEntityGraphForm assetEntityGraphForm = new AssetEntityGraphForm();
			assetEntityGraphForm.setClassName(SPGroup.class.getName());
			assetEntityGraphForm.setClassPK(classPK);
			assetEntityGraphForm.setTitle(title);
			assetEntityGraphForm.setUrlTitle(urlTitle);
			assetEntityGraphForm.setContent(SPHtmlUtil.shortenHtmlText(content, 400));
			assetEntityGraphForm.setImageUrl(imageUrl);
			assetEntityGraphForm.setUserId(userId);
			assetEntityGraphForm.setStatus(0);
			assetEntityGraphForm.setCreateDate(createDate);
			assetEntityGraphForm.setModifiedDate(modifiedDate);

			assetEntityGraphForm.setType(spGroup.getType());

			Neo4jHelper.fillMandatoryFields(assetEntityGraphForm, spGroup.getCompanyId(), spGroup.getGroupId(),
					-1L);

			long[] spGroupCategoryIdArray = AssetCategoryLocalServiceUtil
					.getCategoryIds(SPGroup.class.getName(), spGroup.getSpGroupId());
			Long[] spGroupCategoryIdArrayObjectArray = ArrayUtils.toObject(spGroupCategoryIdArray);
			assetEntityGraphForm.setCategoryIds(Arrays.asList(spGroupCategoryIdArrayObjectArray));

			assetEntityGraphForms.add(assetEntityGraphForm);
		}
		
		return spGroups;

	}

	private void addGroupDiscussionsToAssetEntityGraph(
			List<AssetEntityGraphForm> assetEntityGraphForms,
			ThemeDisplay themeDisplay, List<SPGroup> spGroups) {
		long classNameId = ClassConstant.SPGROUP_CLASSNAME_ID;
		for (SPGroup spGroup : spGroups) {
			try {
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MBMessage.class,
						PortalClassLoaderUtil.getClassLoader());
						dynamicQuery.add(PropertyFactoryUtil.forName("classPK").eq(new Long(spGroup.getSpGroupId())));
						dynamicQuery.add(PropertyFactoryUtil.forName("classNameId").eq(new Long(classNameId)));
						dynamicQuery.addOrder(OrderFactoryUtil.asc("classPK"));
						dynamicQuery.addOrder(OrderFactoryUtil.asc("rootMessageId"));
						dynamicQuery.addOrder(OrderFactoryUtil.asc("parentMessageId"));
				@SuppressWarnings("unchecked")
				List<MBMessage> groupDiscussionsAndComments = MBMessageLocalServiceUtil.dynamicQuery(dynamicQuery);
				updateDiscussionModifiedDate(groupDiscussionsAndComments);
				for (MBMessage discussion : groupDiscussionsAndComments) {
					addMBMessage(assetEntityGraphForms, spGroup, discussion);
				}
			} catch (Exception e) {
				_log.error(e);
			}
		}			
	}

	private void updateDiscussionModifiedDate(
			List<MBMessage> groupDiscussionsAndComments) {
		Map<Long, Date> parentMsgModifiedDateMap = new HashMap<Long, Date>();
		for (MBMessage discussion : groupDiscussionsAndComments) {
			long parentId = discussion.getParentMessageId() > 0 ? discussion.getParentMessageId() : discussion.getMessageId();
			Date latestModifiedDate = parentMsgModifiedDateMap.get(parentId);
			if (latestModifiedDate==null || discussion.getModifiedDate().getTime() > latestModifiedDate.getTime()) {
				latestModifiedDate = discussion.getModifiedDate();
			}
			parentMsgModifiedDateMap.put(parentId, latestModifiedDate);
		}
		for (MBMessage discussion : groupDiscussionsAndComments) {
			long msgId = discussion.getMessageId();
			if (parentMsgModifiedDateMap.containsKey(msgId)) {
				discussion.setModifiedDate(parentMsgModifiedDateMap.get(msgId));
			}
		}

	}

	private void addMBMessage(List<AssetEntityGraphForm> assetEntityGraphForms,
			SPGroup spGroup, MBMessage discussion) throws ParserException {
		String communityName = PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);
		long classPK = discussion.getMessageId();
		String title = discussion.getSubject();
		String urlTitle = spGroup.getUrlTitle();
		String content = discussion.getBody();
		long userId = discussion.getUserId();
		int status = discussion.getStatus();
		Date createDate = discussion.getCreateDate();
		Date modifiedDate = discussion.getModifiedDate();
		String imageUrl = Util.getImageUrlFromHtml(content);

		AssetEntityGraphForm assetEntityGraphForm = new AssetEntityGraphForm();

		assetEntityGraphForm.setClassName(MBMessage.class.getName());
		assetEntityGraphForm.setClassPK(classPK);
		assetEntityGraphForm.setTitle(title);
		assetEntityGraphForm.setUrlTitle(urlTitle);
		assetEntityGraphForm.setContent(SPHtmlUtil.shortenHtmlText(content, 400));
		if (StringUtils.isEmpty(assetEntityGraphForm.getContent())) {
			String body = HtmlUtil.stripHtml(discussion.getBody());
			String subject = HtmlUtil.stripHtml(discussion.getSubject());
			String parentContent = StringUtils.isNotBlank(body) && !body.equals(subject)
					? String.format("%s [ %s ]", subject, body)
					: StringUtils.isNotBlank(subject) ? subject
					: body; 
			assetEntityGraphForm.setContent(parentContent);
		}
		assetEntityGraphForm.setImageUrl(imageUrl);
		assetEntityGraphForm.setUserId(userId);
		assetEntityGraphForm.setStatus(status);
		assetEntityGraphForm.setCreateDate(createDate);
		assetEntityGraphForm.setModifiedDate(modifiedDate);
		assetEntityGraphForm.setParentId(discussion.getParentMessageId());

		assetEntityGraphForm.setReferenceId(spGroup.getSpGroupId());
		assetEntityGraphForm.setReferenceTitle(spGroup.getTitle());
		assetEntityGraphForm.setReferenceUrlTitle(spGroup.getUrlTitle());
		assetEntityGraphForm.setReferenceClassId(ClassConstant.SPGROUP_CLASSNAME_ID);

		assetEntityGraphForm.setCommunityName(communityName);
		
		Neo4jHelper.fillMandatoryFields(assetEntityGraphForm, discussion.getCompanyId(),
				discussion.getGroupId(), -1L);

		assetEntityGraphForms.add(assetEntityGraphForm);
	}

	protected void addBlogsToAssetEntityGraph(
			List<AssetEntityGraphForm> assetEntityGraphForms)
			throws SystemException, ParserException {
		List<BlogsEntry> blogsEntries = BlogsEntryLocalServiceUtil.getBlogsEntries(-1, -1);
		for (BlogsEntry blogsEntry : blogsEntries) {

			long classPK = blogsEntry.getEntryId();
			String title = blogsEntry.getTitle();
			String urlTitle = blogsEntry.getUrlTitle();
			String content = blogsEntry.getContent();
			long userId = blogsEntry.getUserId();
//			int status = blogsEntry.getStatus();
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
			assetEntityGraphForm.setStatus(0);
			assetEntityGraphForm.setCreateDate(createDate);
			assetEntityGraphForm.setModifiedDate(modifiedDate);

			Neo4jHelper.fillMandatoryFields(assetEntityGraphForm, blogsEntry.getCompanyId(),
					blogsEntry.getGroupId(), -1L);

			long[] blogCategoryIdArray = AssetCategoryLocalServiceUtil
					.getCategoryIds(BlogsEntry.class.getName(), blogsEntry.getEntryId());
			Long[] blogCategoryIdArrayObjectArray = ArrayUtils.toObject(blogCategoryIdArray);
			assetEntityGraphForm.setCategoryIds(Arrays.asList(blogCategoryIdArrayObjectArray));

			assetEntityGraphForms.add(assetEntityGraphForm);
		}
	}

	protected void populateAssetCategoryGraph() throws SystemException {
		List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
		List<AssetCategoryGraphForm> assetCategoryGraphForms = new ArrayList<AssetCategoryGraphForm>();
		for (AssetVocabulary av : assetVocabularies) {
			List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(av.getVocabularyId(), -1, -1, null);
			for (AssetCategory assetCategory : assetCategories) {
				long categoryId = assetCategory.getCategoryId();
				String name = assetCategory.getName();
				long vocabularyId = assetCategory.getVocabularyId();

				AssetCategoryGraphForm assetCategoryForm = new AssetCategoryGraphForm();
				assetCategoryForm.setCategoryId(categoryId);
				assetCategoryForm.setName(name);
				assetCategoryForm.setVocabularyId(vocabularyId);

				Neo4jHelper.fillMandatoryFields(assetCategoryForm, assetCategory.getCompanyId(),
						assetCategory.getGroupId(), -1L);

				assetCategoryGraphForms.add(assetCategoryForm);
			}
		}

		if (assetCategoryGraphForms.size() > 0) {
			SPNeoforjLocalServiceUtil.addCategoriesInBatch(assetCategoryGraphForms);
		}
	}

	protected void populateUserGraph(ThemeDisplay themeDisplay)
			throws SystemException, PortalException {
		List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
		List<UserGraphForm> userGraphForms = new ArrayList<UserGraphForm>();
		for (User user : users) {

			if (SambaashUtil.hasSiteAccess(themeDisplay, user.getUserId())) {

				long userId = user.getUserId();
				String firstName = user.getFirstName();
				String lastName = user.getLastName();
				String screenName = user.getScreenName();
				long portraitId = user.getPortraitId();
				boolean emailAddressVerified = user.getEmailAddressVerified();
				int status = user.getStatus();
				Date createDate = user.getCreateDate();
				Date modifiedDate = user.getModifiedDate();

				UserGraphForm userGraphForm = new UserGraphForm();
				userGraphForm.setUserId(userId);
				userGraphForm.setFirstName(firstName);
				userGraphForm.setLastName(lastName);
				userGraphForm.setScreenName(screenName);
				userGraphForm.setPortraitId(portraitId);
				userGraphForm.setEmailAddressVerified(emailAddressVerified);
				userGraphForm.setStatus(status);
				userGraphForm.setCreateDate(createDate);
				userGraphForm.setModifiedDate(modifiedDate);
				userGraphForm.setEmailAddress(user.getEmailAddress());
				if (user.isMale()) {
					userGraphForm.setGender("male");
				} else {
					userGraphForm.setGender("female");
				}

				Neo4jHelper.fillMandatoryFields(userGraphForm, themeDisplay);

				userGraphForms.add(userGraphForm);
			}
		}

		if (userGraphForms.size() > 0) {
			SPNeoforjLocalServiceUtil.addUsersInBatch(userGraphForms);
		}
	}
	
	private String getAssetEntryImageUrl(ThemeDisplay themeDisplay, long coverFileEntryId) {
		String url = themeDisplay.getPathThemeImages() + "/common/default-gallery-image.png";

		FileEntry coverFileEntry;
		try {
			coverFileEntry = DLAppServiceUtil.getFileEntry(coverFileEntryId);
			if (coverFileEntry != null) {
				url = ThumbnailUtil.getThumbnailUrl(coverFileEntry, themeDisplay.getPathThemeImages(),
						themeDisplay.getPortalURL(), themeDisplay.getPathContext(), 3);
			}
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}
		return url;
	}

	private void addSPLikesToDatabaseGraph() throws SystemException {
		for (SPLikes like: SPLikesLocalServiceUtil.getSPLikeses(-1, -1)) {
			SPNeoforjLocalServiceUtil.like(like.getCompanyId(), 
					like.getGroupId(), like.getLayoutSetId(),
					like.getAction(), like.getActorUserId(), 
					like.getClassName(), like.getClassPK(), false);
		}
	}

}