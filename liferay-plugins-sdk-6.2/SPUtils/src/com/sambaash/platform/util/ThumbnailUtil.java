package com.sambaash.platform.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.AudioProcessorUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.documentlibrary.util.ImageProcessorUtil;
import com.liferay.portlet.documentlibrary.util.PDFProcessorUtil;

@SuppressWarnings("deprecation")
public class ThumbnailUtil {

	public static String getThumbnailUrl(FileEntry fileEntry, ThemeDisplay themeDisplay) {
		return getThumbnailUrl(fileEntry, themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
				themeDisplay.getPathContext(), THUMBNAIL_SIZE_1);
	}

	/**
	 * @param fileEntry
	 * @param pathThemeImages
	 *            using themeDisplay.getPathThemeImages()
	 * @param portalUrl
	 *            using themeDisplay.getPortalURL()
	 * @param pathContext
	 *            using themeDisplay.getPathContext()
	 * @param type
	 *            using portal-ext.properties (thumbnail 1,2,3)
	 * @return
	 */
	public static String getThumbnailUrl(FileEntry fileEntry, String pathThemeImages, String portalUrl,
			String pathContext, int type) {

		String thumbnailSrc = StringPool.BLANK;
		String videoBaseUrl = StringPool.BLANK;
		boolean hasVideo = false;
		try {
			boolean hasImages = hasImages(fileEntry.getFileVersion());

			boolean hasPDFImages = hasPDFImages(fileEntry.getFileVersion());

			if ("video".equalsIgnoreCase(DLUtil.getGenericName(fileEntry.getExtension()))
					|| "flv".equalsIgnoreCase(fileEntry.getExtension())) {
				Group group = GroupLocalServiceUtil.getGroup(fileEntry.getGroupId());
				videoBaseUrl = getVideoBaseUrl(group.getName(), fileEntry.getFileVersion());

				hasVideo = hasVideo(videoBaseUrl);
			}

			boolean hasEmbed = hasEmbed(fileEntry);

			thumbnailSrc = pathThemeImages + "/file_system/large/" + DLUtil.getGenericName(fileEntry.getExtension())
					+ ".png";

			if (_log.isDebugEnabled()) {
				_log.debug("hasImages : " + hasImages + " : hasPDFImages : " + hasPDFImages + " : hasVideo : "
						+ hasVideo + " : hasEmbed :  " + hasEmbed);
			}

			String thumbnailQueryString = null;

			if (hasImages) {
				thumbnailQueryString = "&imageThumbnail=" + type;
			} else if (hasPDFImages) {
				thumbnailQueryString = "&documentThumbnail=1";
			} else if (hasVideo) {
				thumbnailSrc = videoBaseUrl + "/medium.png";
			} else if (hasEmbed) {
				thumbnailSrc = getEmbedThumbnailUrl(fileEntry, pathThemeImages);
			}

			if (Validator.isNotNull(thumbnailQueryString)) {
				thumbnailSrc = _getPreviewURL(fileEntry, fileEntry.getFileVersion(), thumbnailQueryString, false,
						portalUrl, pathContext);
			}

			if (_log.isDebugEnabled()) {
				_log.debug("thumbnailSrc : " + thumbnailSrc);
			}

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		} catch (UnsupportedEncodingException e) {
			_log.error(e);
		}
		return thumbnailSrc;
	}
	
	public static String getBannerImageUrl(FileEntry fileEntry, String pathThemeImages, String portalUrl,
			String pathContext, int type) {

		String thumbnailSrc = StringPool.BLANK;
		try {
			boolean hasImages = hasImages(fileEntry.getFileVersion());

			thumbnailSrc = pathThemeImages + "/file_system/large/" + DLUtil.getGenericName(fileEntry.getExtension())
					+ ".png";

			if (_log.isDebugEnabled()) {
				_log.debug("hasImages : " + hasImages);
			}

			thumbnailSrc = _getPreviewURL(fileEntry, fileEntry.getFileVersion(), "", false,
						portalUrl, pathContext);

			if (_log.isDebugEnabled()) {
				_log.debug("thumbnailSrc : " + thumbnailSrc);
			}

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
		return thumbnailSrc;
	}

	public static boolean hasAudio(FileVersion fileVersion) {
		try {
			return AudioProcessorUtil.hasAudio(fileVersion);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return false;

	}

	public static boolean hasImages(FileVersion fileVersion) {
		try {
			return ImageProcessorUtil.hasImages(fileVersion);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return false;

	}

	public static boolean hasPDFImages(FileVersion fileVersion) {
		try {
			return PDFProcessorUtil.hasImages(fileVersion);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return false;

	}

	public static boolean hasVideo(FileVersion fileVersion) {
		try {
			Group grp = GroupLocalServiceUtil.getGroup(fileVersion.getGroupId());
			String siteName = grp.getName();
			String videoBaseUrl = getVideoBaseUrl(siteName, fileVersion);
			boolean hasVideo = hasVideo(videoBaseUrl);
			if (_log.isDebugEnabled()) {
				_log.debug("fileVersionId =" + fileVersion.getFileVersionId() + " videoBaseUrl = " + videoBaseUrl
						+ " hasVideo= " + hasVideo);
			}
			return hasVideo;
		} catch (Exception ex) {
			_log.error(ex.getMessage());
		}
		return false;
	}

	public static boolean hasVideo(String videoBaseUrl) {

		return hasVideoPreview(videoBaseUrl) && hasVideoThumbnail(videoBaseUrl);
	}

	private static boolean hasVideoPreview(String videoBaseUrl) {

		boolean hasPreviewVideo = false;

		try {
			URL previewUrl = new URL(videoBaseUrl + "_type1.mp4");
			BufferedReader in = new BufferedReader(new InputStreamReader(previewUrl.openStream()));

			if (in.readLine() != null) {
				hasPreviewVideo = true;
				if (_log.isDebugEnabled()) {
					_log.debug("Video Preview found : " + previewUrl);
				}
			}

			in.close();

		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return hasPreviewVideo;
	}

	private static boolean hasVideoThumbnail(String videoBaseUrl) {
		boolean hasThumbnail = false;
		try {
			URL previewUrl = new URL(videoBaseUrl + "/medium.png");
			BufferedReader in = new BufferedReader(new InputStreamReader(previewUrl.openStream()));

			if (in.readLine() != null) {
				hasThumbnail = true;
				if (_log.isDebugEnabled()) {
					_log.debug("Video Thumbnail Preview found : " + previewUrl);
				}
			}

			in.close();

		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return hasThumbnail;
	}

	public static boolean hasEmbed(FileEntry fileEntry) {
		try {
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getFileEntry(fileEntry.getFileEntryId());

			DLFileEntryType fileEntryType = DLFileEntryTypeLocalServiceUtil
					.getFileEntryType(dlFileEntry.getFileEntryTypeId());
			if ("Embed".equalsIgnoreCase(fileEntryType.getName())) {
				return true;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return false;
	}

	public static String getEmbedThumbnailUrl(FileEntry fileEntry, String pathThemeImages) {

		String thumbnailSrc = StringPool.BLANK;

		if (Validator.isNull(thumbnailSrc)) {
			thumbnailSrc = pathThemeImages + "/file_system/large/embed.png";
		}

		return thumbnailSrc;
	}

	public static final String _getPreviewURL(FileEntry fileEntry, FileVersion fileVersion, String queryString,
			boolean appendToken, String portalUrl, String pathContext) {
		StringBundler sb = new StringBundler(13);

		sb.append(portalUrl);
		sb.append(pathContext);
		sb.append("/documents/");
		sb.append(fileEntry.getRepositoryId());
		sb.append(StringPool.SLASH);
		sb.append(fileEntry.getFolderId());
		sb.append(StringPool.SLASH);
		sb.append(HttpUtil.encodeURL(HtmlUtil.unescape(fileEntry.getTitle()), true));
		sb.append("?version=");
		sb.append(fileVersion.getVersion());

		if (appendToken) {
			sb.append("&t=");

			Date modifiedDate = fileVersion.getModifiedDate();

			sb.append(modifiedDate.getTime());
		}

		if(!queryString.isEmpty()){
			sb.append(queryString);
		}	

		return sb.toString();
	}

	public static String generatePdfFromSVG(String[] inputFilesPath, String outputFilePath, String filePath) {
		String zipFile = StringPool.BLANK;
		try {
			zipFile = (String) PortalClassInvoker.invoke(false, _generatePdfFromSVG, inputFilesPath, outputFilePath,
					filePath);
		} catch (Exception e) {
			_log.error(e);
		}
		return (String) zipFile;
	}

	public static String getVideoBaseUrl(String siteName, FileVersion fileVersion) throws UnsupportedEncodingException {

		StringBuilder sb = new StringBuilder();

		sb.append("https://s3-ap-southeast-1.amazonaws.com/").append(bucketName).append(StringPool.FORWARD_SLASH)
				.append(siteName).append(StringPool.FORWARD_SLASH).append(fileVersion.getCompanyId())
				.append(StringPool.FORWARD_SLASH).append(fileVersion.getRepositoryId());

		try {
			sb.append(StringPool.FORWARD_SLASH).append(fileVersion.getFileEntry().getFolderId());
		} catch (PortalException | SystemException e) {
			_log.error(
					"Error retrieving folderId from fileVersion for video upload path, will upload the file without folderId after conversion.");
		}

		sb.append(StringPool.FORWARD_SLASH).append(fileVersion.getFileEntryId()).append(StringPool.FORWARD_SLASH)
				.append(fileVersion.getVersion()).append(StringPool.FORWARD_SLASH)
				.append(URLEncoder.encode(fileVersion.getTitle(), "UTF-8"));

		if (_log.isDebugEnabled()) {
			_log.debug("getVideoBaseUrl : " + sb.toString());
		}

		return sb.toString();

	}

	public static List<String> getVideoUrls(String siteName, FileVersion fileVersion)
			throws UnsupportedEncodingException {
		List<String> list = new ArrayList<String>();
		String baseUrl = getVideoBaseUrl(siteName, fileVersion);
		list.add(baseUrl + "_type1.mp4");
		list.add(baseUrl + "_type2.webm");
		list.add(baseUrl + "_type3.ogg");

		return list;
	}

	private static final String _CLASS_NAME_IMAGES = "com.liferay.portlet.documentlibrary.util.ImageProcessor";

	private static MethodKey _generatePdfFromSVG = new MethodKey(_CLASS_NAME_IMAGES, "generatePdfFromSVG",
			String[].class, String.class, String.class);

	public static int THUMBNAIL_SIZE_1 = 1;

	public static int THUMBNAIL_SIZE_2 = 2;

	public static int THUMBNAIL_SIZE_3 = 3;

	private static String bucketName = PropsUtil.get(PropsKeys.DL_STORE_S3_BUCKET_NAME);

	private static Log _log = LogFactoryUtil.getLog(ThumbnailUtil.class);

}
