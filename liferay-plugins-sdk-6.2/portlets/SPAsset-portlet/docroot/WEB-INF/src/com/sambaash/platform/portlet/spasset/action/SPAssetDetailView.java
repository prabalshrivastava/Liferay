package com.sambaash.platform.portlet.spasset.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.compat.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.facebook.FacebookConnectUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.struts.PortletActionInvoker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.documentlibrary.util.VideoProcessorUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.spasset.helper.SPAssetHelper;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.model.SPAssetType;
import com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalServiceUtil;
import com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil;
import com.sambaash.platform.srv.spasset.service.permission.SPAssetEntryPermission;
import com.sambaash.platform.tag.handlers.CommentTagProcess;
import com.sambaash.platform.util.SPHtmlUtil;
import com.sambaash.platform.util.ThumbnailUtil;

/**
 * Portlet implementation class SPAssetDetailView
 */
public class SPAssetDetailView extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SPAssetDetailView.class);

	private static String ASSET_ENTRY_ID = "assetEntryId";
	private static String FILE_ID = "fileId";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		long assetEntryId = ParamUtil.getLong(renderRequest, ASSET_ENTRY_ID);
		long fileId = ParamUtil.getLong(renderRequest, FILE_ID);
		renderRequest.setAttribute(ASSET_ENTRY_ID, assetEntryId);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		if (assetEntryId != 0) {

			try {
				SPAssetEntryPermission.check(themeDisplay.getPermissionChecker(), assetEntryId, ActionKeys.VIEW);
			} catch (PortalException e) {
				_log.error("Un authorized user tried to view asset entry. " + themeDisplay.getUserId() + "  isSignedIn "
						+ themeDisplay.isSignedIn());
				include("/html/detail/unauthorized.jsp", renderRequest, renderResponse);
				return;
			} catch (SystemException e) {
				include("/html/detail/systemError.jsp", renderRequest, renderResponse);
				return;
			}

			try {
				SPAssetEntry assetEntry = SPAssetEntryLocalServiceUtil.getSPAssetEntry(assetEntryId);
				SPAssetType spAssetType = SPAssetTypeLocalServiceUtil.getSPAssetType(assetEntry.getSpAssetTypeId());
				renderRequest.setAttribute("galleryTitle", assetEntry.getTitle());
				renderRequest.setAttribute("galleryDescription",
						SPHtmlUtil.changeNewLineToBR(SPHtmlUtil.shortenHtmlText(assetEntry.getDescription(),assetEntry.getDescription().length())));
				renderRequest.setAttribute("galleryUrl", SPAssetHelper
						.getFriendlyUrlAssetDetails(spAssetType.getSpAssetTypeDetailUrl(), assetEntryId, 0, ""));
				renderRequest.setAttribute("galleryCoverId", assetEntry.getCoverFileEntryId());
				renderRequest.setAttribute("galleryPageUrl", spAssetType.getSpAssetTypeCreateUrl());
				String coverImageUrl = StringPool.BLANK;
				try{
				FileEntry coverImage = DLAppServiceUtil.getFileEntry(assetEntry.getCoverFileEntryId());
				coverImageUrl = ThumbnailUtil.getThumbnailUrl(coverImage, themeDisplay.getPathThemeImages(),
						themeDisplay.getPortalURL(), themeDisplay.getPathContext(), 3);
				}catch(Exception e){
					_log.error(e);
				}
				
				renderRequest.setAttribute("ogtitle", assetEntry.getTitle());
				renderRequest.setAttribute("ogdescription", SPHtmlUtil.shortenHtmlText(assetEntry.getDescription(),assetEntry.getDescription().length()));
				renderRequest.setAttribute("ogimage", coverImageUrl);
				try {
					renderRequest.setAttribute("ogurl", URLEncoder.encode(themeDisplay.getPortalURL() + themeDisplay.getURLCurrent(), "UTF-8"));
					renderRequest.setAttribute("fbappid",FacebookConnectUtil.getAppId(themeDisplay.getCompanyId()));
				} catch (UnsupportedEncodingException | SystemException e) {
					_log.error(e.getMessage());
				}

				prepareNextPrevUrls(renderRequest, assetEntry);
			} catch (Exception ex) {
				_log.error(ex);
			}
			if (fileId == 0) {
				// code for social share - individual file is not requested,
				// only gallery requested
				renderRequest.setAttribute("assetEntry_setmetadata", true);
				renderRequest.setAttribute("fileEntry-setmetadata", false);
			} else {
				// code for social share - when Individual file in gallery is
				// requested.
				renderRequest.setAttribute("assetEntry-setmetadata", false);
				renderRequest.setAttribute("fileEntry-setmetadata", true);
				try {
					DLFileEntry fe = DLFileEntryLocalServiceUtil.getFileEntry(fileId);
					renderRequest.setAttribute("title", fe.getTitle());
					renderRequest.setAttribute("description", fe.getDescription());
					renderRequest.setAttribute("url", getGalleryFileFriendlyUrl(renderRequest, assetEntryId, fileId));

				} catch (Exception ex) {
					_log.error(ex);
				}
			}
		}
		// renderRequest.setAttribute("classPK", fileId);
		renderRequest.setAttribute("fileId", fileId);
		renderRequest.setAttribute("className", DLFileEntry.class.getName());
		renderRequest.setAttribute("showComments", true);
		super.doView(renderRequest, renderResponse);
	}

	private static void prepareNextPrevUrls(PortletRequest request, SPAssetEntry assetEntry) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			SPAssetType assetType = SPAssetTypeLocalServiceUtil.getSPAssetType(assetEntry.getSpAssetTypeId());
			String posIndex = request.getParameter("posIndex");
			String posIndexSearchText = request.getParameter("posIndexSearchText");
			// PortletPreferences preferences = request.getPreferences();
			int pos = -1;
			if (Validator.isNull(posIndex) || posIndex.equals(StringPool.DASH)) {
				pos = findCurrentIndex(request, themeDisplay, assetEntry, posIndexSearchText);
			} else {
				pos = Integer.parseInt(posIndex);
			}
			// Indexer indexer =
			// IndexerRegistryUtil.getIndexer(SPAssetEntry.class);

			// Hits hits = indexer.search(searchContext);

			// Hits hits =
			// SPChallengeLocalServiceUtil.searchChallenges(themeDisplay.getCompanyId(),
			// pos, pos + 1, null, true);
			Hits hits = SPAssetHelper.searchGallery(request, pos, pos + 1, assetEntry.getSpAssetTypeId(),
					posIndexSearchText);
			int end = hits.getLength() - 1;
			int prevIndex = pos - 1;
			int nextIndex = pos + 1;
			if (nextIndex > end) {
				nextIndex = 0;
			} else if (prevIndex < 0) {
				prevIndex = end;
			}

			List<Document> galleryListing = SPAssetHelper.getGalleryListing(request, prevIndex, prevIndex + 1,
					assetEntry.getSpAssetTypeId(), posIndexSearchText);
			long assetEntryId;
			String url;
			if (galleryListing.size() > 0) {
				assetEntryId = GetterUtil.getLong(galleryListing.get(0).get(Field.ENTRY_CLASS_PK));
				url = SPAssetHelper.getFriendlyUrlAssetDetails(assetType.getSpAssetTypeDetailUrl(), assetEntryId, pos,
						posIndexSearchText);
				request.setAttribute("previousGalleryUrl", url);
			} else {
				request.setAttribute("previousGalleryUrl", StringPool.BLANK);
			}
			galleryListing = SPAssetHelper.getGalleryListing(request, nextIndex, nextIndex + 1,
					assetEntry.getSpAssetTypeId(), posIndexSearchText);
			if (galleryListing.size() > 0) {
				assetEntryId = GetterUtil.getLong(galleryListing.get(0).get(Field.ENTRY_CLASS_PK));
				url = SPAssetHelper.getFriendlyUrlAssetDetails(assetType.getSpAssetTypeDetailUrl(), assetEntryId, pos,
						posIndexSearchText);
				request.setAttribute("nextGalleryUrl", url);
			} else {
				request.setAttribute("nextGalleryUrl", StringPool.BLANK);
			}
		} catch (Exception e) {
			_log.error("Error while setting previous and next urls!! URL = " + themeDisplay.getURLCurrent(), e);
		}
	}

	private static int findCurrentIndex(PortletRequest request, ThemeDisplay themeDisplay, SPAssetEntry assetEntry,
			String posIndexSearchText) {
		try {
			int count = 0;
			while (true) {
				List<Document> galleryListing = SPAssetHelper.getGalleryListing(request, count, count + 10,
						assetEntry.getSpAssetTypeId(), posIndexSearchText);
				if (Validator.isNull(galleryListing) || galleryListing.size() == 0) {
					break;
				}
				for (Document doc : galleryListing) {
					long assetEntryDocId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
					if (assetEntryDocId == assetEntry.getSpAssetEntryId()) {
						return count;
					}
					count++;
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return 0;
	}

	public void saveComments(ActionRequest request, ActionResponse response) {
		try {
			PortletActionInvoker.processAction("com.liferay.portlet.messageboards.action.EditDiscussionAction", null,
					request, response);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		String type = resourceRequest.getParameter("type");
		String fileId = resourceRequest.getParameter("fileId");
		String assetEntryId = resourceRequest.getParameter("assetEntryId");
		if ("setAsCoverImage".equalsIgnoreCase(type)) {
			try {
				JSONObject data = JSONFactoryUtil.createJSONObject();
				if (Validator.isNotNull(assetEntryId)) {
					ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
					SPAssetEntry asstEntry = SPAssetEntryLocalServiceUtil
							.getSPAssetEntry(GetterUtil.getLong(assetEntryId));
					if (Validator.isNotNull(fileId)) {
						asstEntry.setCoverFileEntryId(Long.parseLong(fileId));
						SPAssetEntryLocalServiceUtil.updateSPAssetEntry(asstEntry);
						FileEntry coverImage = DLAppServiceUtil.getFileEntry(asstEntry.getCoverFileEntryId());
						data.put("coverImage",
								ThumbnailUtil.getThumbnailUrl(coverImage, themeDisplay.getPathThemeImages(),
										themeDisplay.getPortalURL(), themeDisplay.getPathContext(), 3));
						data.put("coverFileEntryId", asstEntry.getCoverFileEntryId());
						data.put("msg", "success");
						resourceResponse.getWriter().write(data.toString());
					}
				}

			} catch (Exception e) {
				_log.error(e);
			}
			return;
		}
		try {
			String action = ParamUtil.getString(resourceRequest, "action");
			String source = ParamUtil.getString(resourceRequest, "source");
			JSONObject data = JSONFactoryUtil.createJSONObject();
			String msg = "success";
			if (CommentTagProcess.SOURCE_COMMENTS_TAG.equalsIgnoreCase(source)) {
				// Leave the process to CommentTagProcess class, it will take
				// care of each action in comments
				CommentTagProcess ctp = new CommentTagProcess();
				ctp.serveResource(resourceRequest, resourceResponse);
			} else if ("getFiles".equals(action)) {
				try {
					data = getAssetEntryContent(resourceRequest, resourceResponse);
				} catch (Exception ex) {
					msg = "Error.";
					_log.error(ex);
				}
				if (Validator.isNull(data)) {
					data = JSONFactoryUtil.createJSONObject();
				}
				data.put("msg", msg);
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			}

		} catch (Exception ex) {

		}
	}

	private JSONObject getAssetEntryContent(PortletRequest request, PortletResponse response) {
		long assetEntryId = ParamUtil.getLong(request, "assetEntryId");
		int start = ParamUtil.getInteger(request, "start");
		int end = ParamUtil.getInteger(request, "end");
		JSONObject data = JSONFactoryUtil.createJSONObject();
		JSONObject json;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		SPAssetEntry assetEntry = null;
		try {
			assetEntry = SPAssetEntryLocalServiceUtil.getSPAssetEntry(assetEntryId);
		} catch (Exception e) {
			_log.error(e);
		}
		if (Validator.isNotNull(assetEntry)) {
			try {
				User uploader = UserLocalServiceUtil.getUser(assetEntry.getUserId());
				data.put("assetEntryId", assetEntryId);
				data.put("title", assetEntry.getTitle());
				data.put("uploaderImg", uploader.getPortraitURL(themeDisplay));
				data.put("uploaderName", uploader.getFullName());
				data.put("uploadedTime", CommentTagProcess.getTimeDifferent(assetEntry.getCreateDate(), new Date()));
				if (assetEntry.getCoverFileEntryId() > 0) {
					data.put("coverFileEntryId", assetEntry.getCoverFileEntryId());
					try {
						FileEntry coverImage = DLAppServiceUtil.getFileEntry(assetEntry.getCoverFileEntryId());
						data.put("coverImage",
								ThumbnailUtil.getThumbnailUrl(coverImage, themeDisplay.getPathThemeImages(),
										themeDisplay.getPortalURL(), themeDisplay.getPathContext(), 3));
						data.put("coverImageFileId", assetEntry.getCoverFileEntryId());

					} catch (Exception ex) {
						_log.error("Error while getting cover image : CoverFileEntryId "
								+ assetEntry.getCoverFileEntryId() + " AssetEntryId = " + assetEntryId);
					}
				}
				data.put("description", SPHtmlUtil.changeNewLineToBR(SPHtmlUtil.shortenHtmlText(assetEntry.getDescription(),assetEntry.getDescription().length())));
				addAssets(data, SPAssetEntry.class.getName(), assetEntryId);

				long folderId = assetEntry.getDlFolderId();
				List<FileEntry> files = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), folderId, start,
						end);
				JSONArray array = JSONFactoryUtil.createJSONArray();
				Group group = themeDisplay.getScopeGroup();
				for (FileEntry fileEntry : files) {
					try {

						json = JSONFactoryUtil.createJSONObject();
						String extension = fileEntry.getExtension();
						String type = DLUtil.getGenericName(extension);
						String description = SPHtmlUtil.changeNewLineToBR(SPHtmlUtil.shortenHtmlText(assetEntry.getDescription(),assetEntry.getDescription().length()));
						if (Validator.isNull(description)) {

						}

						addAssets(json, DLFileEntry.class.getName(), fileEntry.getFileEntryId());

						json.put("fileId", fileEntry.getFileEntryId());
						json.put("type", type);
						json.put("extension", extension);
						json.put("mimeType", fileEntry.getMimeType());

//						_log.error("DLUtil.getGenericName(extension) : " + type + " : fileEntry.getMimeType() : "
//								+ fileEntry.getMimeType());

						if ("video".equalsIgnoreCase(type)) {
							JSONArray jarray = JSONFactoryUtil.createJSONArray();
							// With below call, Vidoe conversion will happen in
							// case video was not converted to mp4,webm and ogg
							// formats
							VideoProcessorUtil.hasVideo(fileEntry.getFileVersion());

							List<String> urls = ThumbnailUtil.getVideoUrls(group.getName(), fileEntry.getFileVersion());
							_log.info("Vidoe urls as list " + urls.toString());
							JSONObject videoUrl = JSONFactoryUtil.createJSONObject();
							videoUrl.put("src", urls.get(0));
							videoUrl.put("type", "video/mp4");
							jarray.put(videoUrl);

							videoUrl = JSONFactoryUtil.createJSONObject();
							videoUrl.put("src", urls.get(1));
							videoUrl.put("type", "video/webm");
							jarray.put(videoUrl);

							videoUrl = JSONFactoryUtil.createJSONObject();
							videoUrl.put("src", urls.get(2));
							videoUrl.put("type", "video/ogg");
							jarray.put(videoUrl);

							json.put("urls", jarray);

							_log.info("Vidoe urls as json " + jarray.toString());

						} else if ("image".equalsIgnoreCase(type)) {
							json.put("url", ThumbnailUtil.getThumbnailUrl(fileEntry, themeDisplay.getPathThemeImages(),
									themeDisplay.getPortalURL(), themeDisplay.getPathContext(), 3));
						} else {
							json.put("url",
									ThumbnailUtil._getPreviewURL(fileEntry, fileEntry.getFileVersion(),
											StringPool.BLANK, false, themeDisplay.getPortalURL(),
											themeDisplay.getPathContext()));
						}

						json.put("friendlyUrl",
								getGalleryFileFriendlyUrl(request, assetEntryId, fileEntry.getFileEntryId()));
						json.put("description", description);
						json.put("downloadUrl", DLUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(),
								themeDisplay, StringPool.BLANK));
						json.put("size", fileEntry.getSize());
						json.put("thumnailUrl",
								ThumbnailUtil.getThumbnailUrl(fileEntry, themeDisplay.getPathThemeImages(),
										themeDisplay.getPortalURL(), themeDisplay.getPathContext(), 3));

						array.put(json);
					} catch (Exception ex) {
						_log.error(ex);
					}
				}
				data.put("items", array);
			} catch (Exception e) {
				_log.error(e);
			}
		} else {
			// TODO: handle null case
		}
		return data;
	}

	private String getGalleryFileFriendlyUrl(PortletRequest request, long assetEntryId, long fileEntryId) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		// String pageNmae = getAssetDetailPageName(request);
		try {
			return PortalUtil.getLayoutURL(themeDisplay) + "/-/assetdetails/view/" + assetEntryId + "/" + fileEntryId;
		} catch (Exception e) {
			_log.error(e);
		}
		return StringPool.BLANK;
	}

	private void addAssets(JSONObject data, String className, long id) {
		try {
			AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(className, id);
			List<AssetCategory> cats = entry.getCategories();
			JSONArray jcats = JSONFactoryUtil.createJSONArray();
			if (Validator.isNotNull(cats)) {
				for (AssetCategory cat : cats) {
					JSONObject jcat = JSONFactoryUtil.createJSONObject();
					jcat.put("id", cat.getCategoryId());
					AssetVocabulary voc = AssetVocabularyLocalServiceUtil.getVocabulary(cat.getVocabularyId());
					jcat.put("name", cat.getName());
					jcat.put("vocName", voc.getName());
					jcats.put(jcat);
				}
			}
			data.put("catgs", jcats);
			String[] tagNames = entry.getTagNames();
			StringBuilder sb = new StringBuilder();
			if (tagNames != null && tagNames.length > 0) {
				for (int i = 0; i < tagNames.length; i++) {
					sb.append(tagNames[i]);
					if (i + 1 != tagNames.length) {
						sb.append(StringPool.COMMA);
					}
				}
			} else {
				// json.put("tags",StringPool.BLANK);
			}
			data.put("tags", sb.toString());
		} catch (Exception e) {
			_log.error(e);
		}
	}

}
