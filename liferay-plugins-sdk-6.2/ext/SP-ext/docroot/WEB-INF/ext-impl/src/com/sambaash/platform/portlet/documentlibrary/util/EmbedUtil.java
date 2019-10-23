package com.sambaash.platform.portlet.documentlibrary.util;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryMetadataException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryTypeException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata;
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryMetadataLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.storage.StorageEngineUtil;

public class EmbedUtil {

	public static String getEmbedThumbnailUrl(FileEntry fileEntry) {

		String thumbnailSrc = StringPool.BLANK;

		try {
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntry.getFileEntryId());
			long fileEntryTypeId = dlFileEntry.getFileEntryTypeId();
			try {
				DLFileEntryType fileEntryType = DLFileEntryTypeServiceUtil.getFileEntryType(fileEntryTypeId);
				if (fileEntryType != null) {
					String embedContent = getEmbedContent(fileEntryType, fileEntry.getFileVersion().getFileVersionId());
					embedContent = embedContent.replaceAll("\"", "\'");
					Matcher matcher = Pattern.compile("src='([^']+)").matcher(embedContent);
					if (matcher.find()) {
						String src = matcher.group(1);
						if (isYoutubeEmbed(src)) {
							String uid = src.substring(src.lastIndexOf("/") + 1);
							thumbnailSrc = "https://img.youtube.com/vi/" + uid + "/hqdefault.jpg";
						} else if (isVimeoEmbed(src)) {
							String uid = src.substring(src.lastIndexOf("/") + 1);
							String requestURL = "http://vimeo.com/api/v2/video/" + uid + ".json";
							GetMethod getMethod = new GetMethod(requestURL);
							HttpClient client = new HttpClient();
							try {
								client.executeMethod(getMethod);
								String reponseBody = getMethod.getResponseBodyAsString();
								JSONArray reponseBodyJSONArray = JSONFactoryUtil.createJSONArray(reponseBody);
								JSONObject dataJSONObject = reponseBodyJSONArray.getJSONObject(0);
								thumbnailSrc = dataJSONObject.getString("thumbnail_large");
							} catch (Exception e) {
								_log.error(e);
							}

						}
					}
				}
			} catch (NoSuchFileEntryTypeException nsfete) {
				// do nothing
			}
		} catch (NoSuchFileEntryException nsfee) {
			// do nothing
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return thumbnailSrc;
	}

	private static String getEmbedContent(DLFileEntryType fileEntryType, long fileVersionId) throws SystemException, PortalException {
		String content = StringPool.BLANK;
		List<DDMStructure> ddmStructures = fileEntryType.getDDMStructures();

		// assume there is only one DDMStructure
		for (DDMStructure ddmStructure : ddmStructures) {
			Set<String> fieldNames = ddmStructure.getFieldNames();
			Fields fields = null;
			try {
				DLFileEntryMetadata fileEntryMetadata = DLFileEntryMetadataLocalServiceUtil.getFileEntryMetadata(ddmStructure.getStructureId(),
						fileVersionId);
				if (fileEntryMetadata != null) {
					fields = StorageEngineUtil.getFields(fileEntryMetadata.getDDMStorageId());
				}
			} catch (NoSuchFileEntryMetadataException nsfeme) {
				// do nothing
			}
			// assume there is only one DDMStructure
			if (fields != null) {
				for (String name : fieldNames) {
					Field field = fields.get(name);
					content = (String) field.getValue();
				}
			}
		}
		return content;
	}

	private static boolean isYoutubeEmbed(String src) {
		String patternString = "http://www.youtube.com";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(src);
		return matcher.find();
	}

	private static boolean isVimeoEmbed(String src) {
		String patternString = "http://player.vimeo.com";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(src);
		return matcher.find();
	}

	private static Log _log = LogFactoryUtil.getLog(EmbedUtil.class);

}

