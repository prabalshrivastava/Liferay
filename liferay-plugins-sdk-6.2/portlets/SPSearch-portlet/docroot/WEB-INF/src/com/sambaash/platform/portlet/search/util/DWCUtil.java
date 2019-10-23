package com.sambaash.platform.portlet.search.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ThumbnailUtil;
//import sambaash.platform.srv.corporate.NoSuchCorporateProfileException;
//import sambaash.platform.srv.corporate.NoSuchCorporateProfileUserException;
//import sambaash.platform.srv.corporate.model.CorporateProfile;
//import sambaash.platform.srv.corporate.model.CorporateProfileUser;
//import sambaash.platform.srv.corporate.service.CorporateProfileLocalServiceUtil;
//import sambaash.platform.srv.corporate.service.CorporateProfileUserLocalServiceUtil;

public class DWCUtil {



	private final static String DEFAULTCHARSET = "UTF-8";
	
	public static String getJobsImageUrl(long companyId, long groupId, String imageId) throws ParserException{
		String imageURL = SambaashUtil.getPortalURL(companyId, groupId)
		+ "/image/image_gallery?img_id=" + imageId;
		return imageURL;
	}

	public static String getBlogImageUrl(String content) throws ParserException{
        return getImageUrlFromHtml(content);
	}
	
	public static String getImageUrlFromHtml(String content) throws ParserException{
        String imageSrc = "";

		Parser parser = Parser.createParser(content, DEFAULTCHARSET);
		TagNameFilter filter = new TagNameFilter("img");
        NodeList nodeList3 = parser.parse(filter);
        Node node = null;
        if (nodeList3.size()>0) {
        	node = nodeList3.elementAt(0);
        	imageSrc = ((ImageTag) node).getAttribute("src");
        }

		return imageSrc;
	}

	public static String getEventImageUrl(String description) throws ParserException{
        return getImageUrlFromHtml(description);
	}

	public static String getGroupDetailImageUrl(long docId) throws SystemException, PortalException {
        String imageSrc = "";
        try{
    		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(docId);
    		imageSrc = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getUuid();
        }catch(NoSuchFileEntryException nsfee) {
        	_log.info(nsfee.getMessage());
        }
		return imageSrc;
	}
/**
	public static String getGalleryImageUrl(long fileId, String category, long scopeGroupId) throws PortalException, SystemException {
        String imageSrc = "";
        String mediaURL = SambaashUtil.getParameter(SambaashConstants.MEDIA_URL, scopeGroupId);
        PortfolioFile portfolioFile = null;
        try {
             portfolioFile = PortfolioFileLocalServiceUtil.getPortfolioFile(fileId);
             if ("image".equalsIgnoreCase(category)) {
             	imageSrc = mediaURL + portfolioFile.getPath();
             }else {
             	imageSrc = getPortfolioNoneImageFileBGImage(scopeGroupId, category);
             }
        }catch(NoSuchPortfolioFileException nspfe) {
        	_log.info(nspfe.getMessage());
        }

		return imageSrc;
	}
**/
	public static String getUserFullName(long userId) throws PortalException, SystemException {
		try{
			User user = UserLocalServiceUtil.getUser(userId);
			return user.getFullName();
		}catch(NoSuchUserException nsue) {
			_log.error("No such user existing with primary key: " + userId);
			return "";
		}
	}

	public static String getDiaplayDate(Date modifiedDate) {
		SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
		return format.format(modifiedDate);
	}

	public static String getPortfolioNoneImageFileBGImage(long scopeGroupId, String fileType) {
		String imageURL = "";
		String fileBGImageDocFolderNameKey = "";
		if ("sound".equalsIgnoreCase(fileType)) {
			fileBGImageDocFolderNameKey = SambaashConstants.PORTFOLIO_SOUNDFILE_BGIMAGE_DOCFOLDERNAME;
		} else if ("video".equalsIgnoreCase(fileType)) {
			fileBGImageDocFolderNameKey = SambaashConstants.PORTFOLIO_VIDEOFILE_BGIMAGE_DOCFOLDERNAME;
		}

		DLFileEntry fileEntry = null;
		DLFolder fileBGImageDocFolder = null;

		String fileBGImageDocFolderName = SambaashUtil.getParameter(fileBGImageDocFolderNameKey, scopeGroupId);

		try {
			long parentFolderId = 0;
			fileBGImageDocFolder = DLFolderLocalServiceUtil.getFolder(scopeGroupId, parentFolderId, fileBGImageDocFolderName);
			if (fileBGImageDocFolder != null) {
				long folderId = fileBGImageDocFolder.getFolderId();
				List<DLFileEntry> fileEntrys = new ArrayList<DLFileEntry>();
				fileEntrys = DLFileEntryLocalServiceUtil.getFileEntries(scopeGroupId, folderId, -1, -1, null);
				if (fileEntrys != null && fileEntrys.size() > 0) {
					fileEntry = fileEntrys.get(0);
				}
			}
		} catch(NoSuchFolderException e) {
				_log.info("No such folder exist with name: " + fileBGImageDocFolderName);
		} catch(NoSuchFileEntryException e) {
				_log.info("No such file entry exist under folder: " + fileBGImageDocFolderName);
		} catch (Exception e) {
				_log.error("TemplateUtil : " + e.getMessage());
		}

		if (fileEntry != null) {
			imageURL = "/documents" + StringPool.FORWARD_SLASH + scopeGroupId + StringPool.FORWARD_SLASH + fileEntry.getUuid();
		}
		return imageURL;
	}

	public static String getProfileFullName(User user) {
		String fullName = "";
		try {
			SocialProfile socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId());

			String userType = socialProfile.getUserType();
			if (SambaashConstants.REGISTRATION.USER_TYPE_CORPORATE.equalsIgnoreCase(userType)) {
				//fullName = CorporateProfileLocalServiceUtil.getCorporateNameByUserId(user.getUserId());

			}else if (SambaashConstants.REGISTRATION.USER_TYPE_INDIVIDUAL.equalsIgnoreCase(userType)) {
				fullName = user.getFullName();
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		return fullName;
	}

	public static String getProfileViewDetailUrl(long userId) throws PortalException, SystemException {
		try{
			User user = UserLocalServiceUtil.getUser(userId);
			return getProfileViewDetailUrl(user);
		}catch(NoSuchUserException nsue) {
			_log.error("No such user existing with primary key: " + userId);
			return "";
		}
	}
	public static String getProfileViewDetailUrl(User user) {
		String viewDetailUrl = "";
		String userType = getUserType(user.getUserId());
		if (SambaashConstants.REGISTRATION.USER_TYPE_CORPORATE.equalsIgnoreCase(userType)) {
			viewDetailUrl = getCorpProfileViewDetailUrl(user.getUserId());
		}else{
			viewDetailUrl = getIndiProfileViewDetailUrl(user.getScreenName());
		}
		return viewDetailUrl;
	}
	
	public static String getCorpProfileViewDetailUrl(long userId) {
		return StringPool.SLASH + getCorporatePublicUrl(userId);
	}
	
	public static String getCorpProfileViewDetailUrl(String profileScreenName) {
		return StringPool.SLASH + profileScreenName;
	}
	
	public static String getIndiProfileViewDetailUrl(String screenName) {
		return StringPool.SLASH + screenName;
	}

	public static String getProfileImageUrl(User user, long scopeGroupId) {
		String imageUrl = "";
		String userType = getUserType(user.getUserId());
			if (SambaashConstants.REGISTRATION.USER_TYPE_CORPORATE.equalsIgnoreCase(userType)) {
				return getCorporateUserImageUrl(user, scopeGroupId);
			}else if (SambaashConstants.REGISTRATION.USER_TYPE_INDIVIDUAL.equalsIgnoreCase(userType)) {
				return getIndividualsUserImageUrl(user.getPortraitId());
			}
		return imageUrl;
	}

	public static String getUserType(long userId) {
		try{
			SocialProfile socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(userId);
			return socialProfile.getUserType();
		}catch(Exception e) {
			if (e instanceof NoSuchSocialProfileException) {
				_log.info("No such userPrifileBasic exist with userId: " + userId);
			}
		}
		return null;
	}

	public static String getJobDetailViewUrl(String portalURL, long scopeGroupId, long jobId) {
		return portalURL + SambaashUtil.getParameter("jobs.more.details.url", scopeGroupId) + jobId;
	}

	public static String getKCDetailViewUrl(String portalURL, long scopeGroupId, long knowledgeCenterId) {
		String contentDetailUrl ="";
		try {
			SPParameter spParam = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId, "kc.redirect.kcdetail");
			contentDetailUrl = portalURL + StringPool.SLASH + spParam.getValue() + "?kcId="+knowledgeCenterId;
		} catch (NoSuchSPParameterException e) {
			_log.error("NoSuchSPParametersException : "+e.getMessage());
		} catch (SystemException e) {
			_log.error("SystemException : "+e.getMessage());
		}
		return contentDetailUrl;
	}

	public static String getViewGroupDetailURL(String portalURL, long scopeGroupId, long groupId) {
		return portalURL + StringPool.SLASH + SambaashUtil.getParameter(SambaashConstants.URL.GROUP_DETAIL, scopeGroupId) + "?groupId=" + groupId;
	}

	public static String getBlogViewDetailUrl(String portalURL, long scopeGroupId, String blogeEntryUrlTitle) {
		return portalURL + "/" + SambaashUtil.getParameter(SambaashConstants.URL.BLOG_LANDING, scopeGroupId) + "/-/blogs/" + blogeEntryUrlTitle;
	}

	public static String getSPAssetViewDetailUrl(String portalURL, long scopeGroupId, String entryUrlTitle, String detailPageName) {
		return "/" + detailPageName + "/-/asset/view/" + entryUrlTitle;
	}

	public static String getSPAssetEntryThumbnailURL(ThemeDisplay themeDisplay, FileEntry coverFileEntry) {
		String thumbNail = ThumbnailUtil.getThumbnailUrl(coverFileEntry, themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
				themeDisplay.getPathContext(), ThumbnailUtil.THUMBNAIL_SIZE_3);
		return thumbNail;
	}

	public static String getViewEventDetailURL(String portalURL, long scopeGroupId, long eventId) {
		return portalURL + "/events?eventViewId=" + eventId;
	}

	public static String getIndividualsUserImageUrl(long portraitId) {
		return "/../image/user_male_portrait?img_id=" + portraitId;
	}

	public static String getCorporateUserImageUrl(long docId, long scopeGroupId) {
		String uuid = getPictureFileUuid(docId);
		if(Validator.isNotNull(uuid)) {
			return "/../documents/" + scopeGroupId + "/" + uuid;
		}else {
			return "/../image/user_male_portrait?img_id=" + 0;
		}
	}
	
	public static String getCorporateUserImageUrl(User user, long scopeGroupId) {
		String imageUrl = "";
		long profileId = 0;
		/**try{
			CorporateProfileUser profileUser = CorporateProfileUserLocalServiceUtil.getCorporateProfilesByUserId(user.getUserId());
			if (profileUser != null) {
				profileId = profileUser.getProfileId();
			}
			CorporateProfile corpProfile = CorporateProfileLocalServiceUtil.getCorporateProfile(profileId);
			if (corpProfile != null && corpProfile.getDocumentId()!=0L) {
				String uuid = getPictureFileUuid(corpProfile.getDocumentId());
				imageUrl = "/../documents/" + scopeGroupId + "/" + uuid;
			}else{
				imageUrl = getIndividualsUserImageUrl(user.getPortraitId());
			}

		}catch (NoSuchCorporateProfileUserException e) {
			_log.error("No such corporateProfileUser exist with userId :"+ user.getUserId());
		}catch (NoSuchCorporateProfileException e) {
			_log.error("No such corporateProfile exist with profileId :"+ profileId);
		}catch(Exception e) {
			_log.error(" getCorporateUserImageUrl : " +e.getMessage());
		}**/
		return imageUrl;
	}

    public static String getPictureFileUuid(long documentId) {
        String uuid = "";
        try{
        	uuid = DLFileEntryLocalServiceUtil.getDLFileEntry(documentId).getUuid();
        }catch(Exception e) {
        	if (e instanceof NoSuchFileEntryException) {
        		_log.info("_NO SUCH ENTITY WITH PRIMARY KEY "+ documentId);
        	}else{
        		_log.error(e.getMessage(), e);
        	}
        }
    	return uuid;
    }

	public static String getCorporatePublicUrl(long userId) {
		//every corp should have a screen name
		String screenName="";
		long profileId = 0;
		/**try{
			CorporateProfileUser profileUser = CorporateProfileUserLocalServiceUtil.getCorporateProfilesByUserId(userId);
			if (profileUser != null) {
				profileId = profileUser.getProfileId();
			}
			CorporateProfile corpProfile = CorporateProfileLocalServiceUtil.getCorporateProfile(profileId);
			screenName=corpProfile.getProfileScreenName();
		}catch (NoSuchCorporateProfileUserException e) {
			_log.error("No such corporateProfileUser exist with userId :"+ userId);
		}catch (NoSuchCorporateProfileException e) {
			_log.error("No such corporateProfile exist with profileId :"+ profileId);
		}catch(Exception e) {
			_log.error(" getCorporatePublicUrl : " +e.getMessage());
		}**/
		return screenName;
	}

	private static Log _log = LogFactoryUtil.getLog(DWCUtil.class);


}
