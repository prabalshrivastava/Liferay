package com.sambaash.platform.portlet.advancedsearch.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
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
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
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

public class ASUtil {

	private final static String DEFAULTCHARSET = "UTF-8";

	public static String getJobsImageUrl(long companyId, long groupId, String imageId) throws ParserException {
		String imageURL = SambaashUtil.getPortalURL(companyId, groupId) + "/image/image_gallery?img_id=" + imageId;
		return imageURL;
	}

	public static String getBlogImageUrl(String content) throws ParserException {
		return getImageUrlFromHtml(content);
	}

	public static String getImageUrlFromHtml(String content) throws ParserException {
		String imageSrc = "";

		Parser parser = Parser.createParser(content, DEFAULTCHARSET);
		TagNameFilter filter = new TagNameFilter("img");
		NodeList nodeList3 = parser.parse(filter);
		Node node = null;
		if (nodeList3.size() > 0) {
			node = nodeList3.elementAt(0);
			imageSrc = ((ImageTag) node).getAttribute("src");
		}

		return imageSrc;
	}

	public static String getEventImageUrl(String description) throws ParserException {
		return getImageUrlFromHtml(description);
	}

	public static String getGroupDetailImageUrl(long docId) throws SystemException, PortalException {
		String imageSrc = "";
		try {
			DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(docId);
			imageSrc = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getUuid();
		} catch (NoSuchFileEntryException nsfee) {
			_log.info(nsfee.getMessage());
		}
		return imageSrc;
	}

	/**
	 * public static String getGalleryImageUrl(long fileId, String category,
	 * long scopeGroupId) throws PortalException, SystemException { String
	 * imageSrc = ""; String mediaURL =
	 * SambaashUtil.getParameter(SambaashConstants.MEDIA_URL, scopeGroupId);
	 * PortfolioFile portfolioFile = null; try { portfolioFile =
	 * PortfolioFileLocalServiceUtil.getPortfolioFile(fileId); if
	 * ("image".equalsIgnoreCase(category)) { imageSrc = mediaURL +
	 * portfolioFile.getPath(); }else { imageSrc =
	 * getPortfolioNoneImageFileBGImage(scopeGroupId, category); }
	 * }catch(NoSuchPortfolioFileException nspfe) {
	 * _log.info(nspfe.getMessage()); }
	 * 
	 * return imageSrc; }
	 **/
	public static String getSPAssetEntryThumbnailURL(ThemeDisplay themeDisplay, FileEntry coverFileEntry) {
		String thumbNail = ThumbnailUtil.getThumbnailUrl(coverFileEntry, themeDisplay.getPathThemeImages(),
				themeDisplay.getPortalURL(), themeDisplay.getPathContext(), ThumbnailUtil.THUMBNAIL_SIZE_3);
		return thumbNail;
	}

	public static String getUserFullName(long userId) throws PortalException, SystemException {
		try {
			User user = UserLocalServiceUtil.getUser(userId);
			return user.getFullName();
		} catch (NoSuchUserException nsue) {
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
			fileBGImageDocFolder = DLFolderLocalServiceUtil.getFolder(scopeGroupId, parentFolderId,
					fileBGImageDocFolderName);

			if (fileBGImageDocFolder != null) {
				long folderId = fileBGImageDocFolder.getFolderId();
				List<DLFileEntry> fileEntrys = new ArrayList<DLFileEntry>();
				fileEntrys = DLFileEntryLocalServiceUtil.getFileEntries(scopeGroupId, folderId, -1, -1, null);

				if (fileEntrys != null && fileEntrys.size() > 0) {
					fileEntry = fileEntrys.get(0);
				}
			}
		} catch (NoSuchFolderException e) {
			_log.info("No such folder exist with name: " + fileBGImageDocFolderName);
		} catch (NoSuchFileEntryException e) {
			_log.info("No such file entry exist under folder: " + fileBGImageDocFolderName);
		} catch (Exception e) {
			_log.error("TemplateUtil : " + e.getMessage());
		}

		if (fileEntry != null) {
			imageURL = "/documents" + StringPool.FORWARD_SLASH + scopeGroupId + StringPool.FORWARD_SLASH
					+ fileEntry.getUuid();
		}

		return imageURL;
	}

	public static String getProfileFullName(User user) {
		String fullName = "";
		try {
			SocialProfile socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId());

			String userType = socialProfile.getUserType();

			// if
			// (SambaashConstants.REGISTRATION.USER_TYPE_CORPORATE.equalsIgnoreCase(userType))
			// {
			// fullName =
			// CorporateProfileLocalServiceUtil.getCorporateNameByUserId(user.getUserId());

			// } else
			if (SambaashConstants.REGISTRATION.USER_TYPE_INDIVIDUAL.equalsIgnoreCase(userType)) {
				fullName = user.getFullName();
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return fullName;
	}

	public static String getProfileViewDetailUrl(long userId) throws PortalException, SystemException {
		try {
			User user = UserLocalServiceUtil.getUser(userId);
			return getProfileViewDetailUrl(user);
		} catch (NoSuchUserException nsue) {
			_log.error("No such user existing with primary key: " + userId);
			return "";
		}
	}

	public static String getProfileViewDetailUrl(User user) {
		String viewDetailUrl = "";
		String userType = getUserType(user.getUserId());

		// if
		// (SambaashConstants.REGISTRATION.USER_TYPE_CORPORATE.equalsIgnoreCase(userType))
		// {
		// viewDetailUrl = getCorpProfileViewDetailUrl(user.getUserId());
		// } else {
		viewDetailUrl = getIndiProfileViewDetailUrl(user.getScreenName());
		// }
		return viewDetailUrl;
	}

	/*
	 * public static String getCorpProfileViewDetailUrl(long userId) { return
	 * StringPool.SLASH + getCorporatePublicUrl(userId); }
	 */

	/*
	 * public static String getCorpProfileViewDetailUrl(String
	 * profileScreenName) { return StringPool.SLASH + profileScreenName; }
	 */
	public static String getIndiProfileViewDetailUrl(String screenName) {
		return StringPool.SLASH + screenName;
	}

	public static String getProfileImageUrl(User user, long scopeGroupId) {
		String imageUrl = "";
		String userType = getUserType(user.getUserId());
		if (SambaashConstants.REGISTRATION.USER_TYPE_CORPORATE.equalsIgnoreCase(userType)) {
			return getCorporateUserImageUrl(user, scopeGroupId);
		} else if (SambaashConstants.REGISTRATION.USER_TYPE_INDIVIDUAL.equalsIgnoreCase(userType)) {
			return getIndividualsUserImageUrl(user.getPortraitId());
		}
		return imageUrl;
	}

	public static String getUserType(long userId) {
		try {
			SocialProfile socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(userId);
			return socialProfile.getUserType();
		} catch (Exception e) {
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
		String contentDetailUrl = "";
		try {
			SPParameter spParam = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(scopeGroupId,
					"kc.redirect.kcdetail");
			contentDetailUrl = portalURL + StringPool.SLASH + spParam.getValue() + "?kcId=" + knowledgeCenterId;
		} catch (NoSuchSPParameterException e) {
			_log.error("NoSuchSPParameterException : " + e.getMessage());
		} catch (SystemException e) {
			_log.error("SystemException : " + e.getMessage());
		}
		return contentDetailUrl;
	}

	public static String getViewGroupDetailURL(String portalURL, long scopeGroupId, long groupId) {
		return portalURL + StringPool.SLASH
				+ SambaashUtil.getParameter(SambaashConstants.URL.GROUP_DETAIL, scopeGroupId) + "?groupId=" + groupId;
	}

	public static String getBlogViewDetailUrl(String portalURL, long scopeGroupId, String blogeEntryUrlTitle) {
		return portalURL + "/" + SambaashUtil.getParameter(SambaashConstants.URL.BLOG_LANDING, scopeGroupId)
				+ "/-/blogs/" + blogeEntryUrlTitle;
	}

	public static String getSPAssetViewDetailUrl(String portalURL, long scopeGroupId, String assetEntryId,
			String detailPageName) {
		// return "/" + detailPageName + "/-/asset/view/" + entryUrlTitle;

		return "/" + detailPageName + "/-/assetdetails/view/" + assetEntryId;
	}

	public static String getViewEventDetailURL(String portalURL, long scopeGroupId, long eventId) {
		return portalURL + "/events?eventViewId=" + eventId + "?flagDetail=false";
	}

	public static String getIndividualsUserImageUrl(long portraitId) {
		return "/../image/user_male_portrait?img_id=" + portraitId;
	}

	public static String getCorporateUserImageUrl(long docId, long scopeGroupId) {
		String uuid = getPictureFileUuid(docId);
		if (Validator.isNotNull(uuid)) {
			return "/../documents/" + scopeGroupId + "/" + uuid;
		} else {
			return "/../image/user_male_portrait?img_id=" + 0;
		}
	}

	public static String getCorporateUserImageUrl(User user, long scopeGroupId) {
		String imageUrl = "";
		long profileId = 0;
		try {
			/*
			 * CorporateProfileUser profileUser =
			 * CorporateProfileUserLocalServiceUtil.getCorporateProfilesByUserId
			 * (user .getUserId()); if (profileUser != null) { profileId =
			 * profileUser.getProfileId(); } CorporateProfile corpProfile =
			 * CorporateProfileLocalServiceUtil.getCorporateProfile(profileId);
			 * if (corpProfile != null && corpProfile.getDocumentId() != 0L) {
			 * String uuid = getPictureFileUuid(corpProfile.getDocumentId());
			 * imageUrl = "/../documents/" + scopeGroupId + "/" + uuid; } else {
			 */
			imageUrl = getIndividualsUserImageUrl(user.getPortraitId());
			// }

		} catch (Exception e) {
			_log.error(" getCorporateUserImageUrl : " + e.getMessage());
		}
		return imageUrl;
	}

	public static String getPictureFileUuid(long documentId) {
		String uuid = "";
		try {
			uuid = DLFileEntryLocalServiceUtil.getDLFileEntry(documentId).getUuid();
		} catch (Exception e) {
			if (e instanceof NoSuchFileEntryException) {
				_log.info("_NO SUCH ENTITY WITH PRIMARY KEY " + documentId);
			} else {
				_log.error(e.getMessage(), e);
			}
		}
		return uuid;
	}

	/*
	 * public static String getCorporatePublicUrl(long userId) { // every corp
	 * should have a screen name String screenName = ""; long profileId = 0; try
	 * { CorporateProfileUser profileUser = CorporateProfileUserLocalServiceUtil
	 * .getCorporateProfilesByUserId(userId); if (profileUser != null) {
	 * profileId = profileUser.getProfileId(); } CorporateProfile corpProfile =
	 * CorporateProfileLocalServiceUtil.getCorporateProfile(profileId);
	 * screenName = corpProfile.getProfileScreenName(); } catch
	 * (NoSuchCorporateProfileUserException e) { _log.error(
	 * "No such corporateProfileUser exist with userId :" + userId); } catch
	 * (NoSuchCorporateProfileException e) { _log.error(
	 * "No such corporateProfile exist with profileId :" + profileId); } catch
	 * (Exception e) { _log.error(" getCorporatePublicUrl : " + e.getMessage());
	 * } return screenName; }
	 */

	public static HashMap<String, String> generateSearchReport(Hits results, String downloadLocation,
			ThemeDisplay themeDisplay) {
		String downloadSuccessful = "true";
		_log.error("generateSearchReport ");

		String excelPath = downloadUserDetailsFromXML(results, downloadLocation);
		HashMap<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("downloadSuccessful", "true");
		resultMap.put("excelPath", excelPath);
		return resultMap;
	}

	public static String downloadUserDetails(Hits results, String downloadLocation, ThemeDisplay themeDisplay) {
		String fileLocation = "";
		HSSFWorkbook workbook = new HSSFWorkbook();
		String downloadSuccessful = "true";

		// to get the list of indexed fields
		Map<String, List<String>> indexableFieldsMap = null;

		// xcel header romw styling
		Font headerFont = workbook.createFont();
		headerFont.setFontHeightInPoints((short) 10);
		headerFont.setFontName("Arial Narrow");
		headerFont.setColor(HSSFColor.WHITE.index);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(HSSFColor.BLACK.index);
		headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		headerStyle.setFont(headerFont);
		headerStyle.setBorderBottom(CellStyle.BORDER_THIN);
		headerStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		headerStyle.setBorderLeft(CellStyle.BORDER_THIN);
		headerStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		headerStyle.setBorderRight(CellStyle.BORDER_THIN);
		headerStyle.setRightBorderColor(HSSFColor.BLACK.index);
		headerStyle.setBorderTop(CellStyle.BORDER_THIN);
		headerStyle.setTopBorderColor(HSSFColor.BLACK.index);

		HSSFSheet firstSheet = workbook.createSheet("User Details");
		HSSFRow rowA = firstSheet.createRow(0);
		HSSFCell cellA = rowA.createCell(0);
		cellA.setCellValue(new HSSFRichTextString("First Name"));
		cellA.setCellStyle(headerStyle);

		HSSFCell cellB = rowA.createCell(1);
		cellB.setCellValue(new HSSFRichTextString("Last Name"));
		cellB.setCellStyle(headerStyle);

		HSSFCell cellC = rowA.createCell(2);
		cellC.setCellValue(new HSSFRichTextString("Email Address"));
		cellC.setCellStyle(headerStyle);
		String colTitle = StringPool.BLANK;
		int totalCols = 3;
		try {
			indexableFieldsMap = new HashMap<String, List<String>>();
			//indexableFieldsMap =  SocialProfileLocalServiceUtil.getIndexableFieldsMap(themeDisplay.getCompanyId());
		} catch (Exception e) {
			_log.error("Error getting indexed fields " + e.getMessage());
		}
		for (Map.Entry<String, List<String>> entry : indexableFieldsMap.entrySet()) {
			List<String> indexableFields = entry.getValue();

			for (String indexableField : indexableFields) {
				colTitle = getColumnTitle(indexableField);

				if (!indexableField.equalsIgnoreCase("first_name") && !indexableField.equalsIgnoreCase("last_name")) {
					HSSFCell cellD = rowA.createCell(totalCols);
					cellD.setCellValue(new HSSFRichTextString(colTitle));
					cellD.setCellStyle(headerStyle);
					totalCols = totalCols + 1;
				}

			}
		}

		try {

			for (int i = 0; i < results.getLength(); i++) {
				int totalValueCols = 3;
				Document doc = results.doc(i);
				String firstName = GetterUtil.getString(doc.get("firstName"));
				String lastName = GetterUtil.getString(doc.get("lastName"));
				String email = GetterUtil.getString(doc.get("emailAddress"));

				HSSFRow rowB = firstSheet.createRow(i + 1);

				HSSFCell cellA1 = rowB.createCell(0);
				cellA1.setCellValue(new HSSFRichTextString(firstName));

				HSSFCell cellB2 = rowB.createCell(1);
				cellB2.setCellValue(new HSSFRichTextString(lastName));

				HSSFCell cellC3 = rowB.createCell(2);
				cellC3.setCellValue(new HSSFRichTextString(email));

				for (Map.Entry<String, List<String>> entry : indexableFieldsMap.entrySet()) {
					List<String> indexableFields = entry.getValue();

					for (String indexableField : indexableFields) {
						int k = 0;
						if (!indexableField.equalsIgnoreCase("first_name")
								&& !indexableField.equalsIgnoreCase("last_name")) {

							HSSFCell cellC4 = null;
							String fieldValue = GetterUtil.getString(doc.get(indexableField));
							String[] fieldValueArray = fieldValue.split(StringPool.EXCLAMATION + StringPool.AMPERSAND);
							if (fieldValueArray.length >= 2) {
								for (String displayFieldValue : fieldValueArray) {
									if (k == 0) {
										cellC4 = rowB.createCell(totalValueCols);
										cellC4.setCellValue(new HSSFRichTextString(displayFieldValue));
										totalValueCols = totalValueCols + 1;
									} else {
										colTitle = getColumnTitle(indexableField);
										HSSFCell cellD = rowA.createCell(totalCols);
										cellD.setCellValue(new HSSFRichTextString(colTitle));
										cellD.setCellStyle(headerStyle);
										cellC4 = rowB.createCell(totalCols);
										cellC4.setCellValue(new HSSFRichTextString(displayFieldValue));
										totalCols = totalCols + 1;
									}
									k = k + 1;
								}
							} else if (fieldValueArray.length == 1) {
								cellC4 = rowB.createCell(totalValueCols);
								cellC4.setCellValue(new HSSFRichTextString(fieldValueArray[0]));
								totalValueCols = totalValueCols + 1;
							} else if (fieldValueArray.length == 0) {
								cellC4 = rowB.createCell(totalValueCols);
								cellC4.setCellValue(new HSSFRichTextString(StringPool.BLANK));
								totalValueCols = totalValueCols + 1;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			_log.error("Error creating excel" + e.getMessage());
		}

		FileOutputStream fos = null;

		try {
			try {

				// downloadLocation = "/usr/sambaashplatform/"+"excel";

				File copyFile = new File(downloadLocation);

				if (!copyFile.exists()) {
					copyFile.mkdirs();
				}
			} catch (Exception e) {
			}

			fileLocation = downloadLocation + "/UserProfileDetails" + String.valueOf(new Date().getTime()) + ".xls";
			fos = new FileOutputStream(new File(fileLocation));
			workbook.write(fos);
		} catch (IOException e) {
			_log.error("Error creating excel in the filelocation" + e.getMessage());
		} finally {
			if (fos != null) {
				try {
					fos.flush();
					fos.close();
				} catch (IOException e) {
					_log.error("Error - ", e);
				}
			}
		}

		return fileLocation;
	}

	public static String downloadUserDetailsFromXML(Hits results, String downloadLocation) {
		String fileLocation = "";
		HSSFWorkbook workbook = new HSSFWorkbook();

		// xcel header romw styling
		Font headerFont = workbook.createFont();
		headerFont.setFontHeightInPoints((short) 10);
		headerFont.setFontName("Arial Narrow");
		headerFont.setColor(HSSFColor.WHITE.index);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(HSSFColor.BLACK.index);
		headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		headerStyle.setFont(headerFont);
		headerStyle.setBorderBottom(CellStyle.BORDER_THIN);
		headerStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		headerStyle.setBorderLeft(CellStyle.BORDER_THIN);
		headerStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		headerStyle.setBorderRight(CellStyle.BORDER_THIN);
		headerStyle.setRightBorderColor(HSSFColor.BLACK.index);
		headerStyle.setBorderTop(CellStyle.BORDER_THIN);
		headerStyle.setTopBorderColor(HSSFColor.BLACK.index);

		HSSFSheet firstSheet = workbook.createSheet("User Details");
		HSSFRow rowA = firstSheet.createRow(0);
		rowA.setHeight((short) 500);
		HSSFCell cellA = rowA.createCell(0);
		cellA.setCellValue(new HSSFRichTextString("First Name"));
		cellA.setCellStyle(headerStyle);

		HSSFCell cellB = rowA.createCell(1);
		cellB.setCellValue(new HSSFRichTextString("Last Name"));
		cellB.setCellStyle(headerStyle);

		HSSFCell cellC = rowA.createCell(2);
		cellC.setCellValue(new HSSFRichTextString("Email Address"));
		cellC.setCellStyle(headerStyle);
		String colTitle = StringPool.BLANK;
		CellStyle wrapText = workbook.createCellStyle();
		wrapText.setWrapText(true);

		try {

			for (int i = 0; i < results.getLength(); i++) {
				int totalCols = 3;
				int totalValueCols = 3;
				Document doc = results.doc(i);
				String firstName = GetterUtil.getString(doc.get("firstName"));
				String lastName = GetterUtil.getString(doc.get("lastName"));
				String email = GetterUtil.getString(doc.get("emailAddress"));

				HSSFRow rowB = firstSheet.createRow(i + 1);

				HSSFCell cellA1 = rowB.createCell(0);
				cellA1.setCellValue(new HSSFRichTextString(firstName));
				firstSheet.setColumnWidth(0, 5000);
				cellA1.setCellStyle(wrapText);

				HSSFCell cellB2 = rowB.createCell(1);
				cellB2.setCellValue(new HSSFRichTextString(lastName));
				firstSheet.setColumnWidth(1, 5000);
				cellB2.setCellStyle(wrapText);

				HSSFCell cellC3 = rowB.createCell(2);
				cellC3.setCellValue(new HSSFRichTextString(email));
				firstSheet.setColumnWidth(2, 5000);
				cellC3.setCellStyle(wrapText);

				org.w3c.dom.NodeList list = SocialProfileLocalServiceUtil
						.getProfileFields(GetterUtil.getString(doc.get(Field.USER_ID)));
				if (Validator.isNotNull(list)) {
					for (int l = 0; l < list.getLength(); l++) {
						org.w3c.dom.Node childNode = list.item(l);
						org.w3c.dom.NodeList childNodeList = childNode.getChildNodes();

						for (int c = 0; c < childNodeList.getLength(); c++) {
							org.w3c.dom.Node childNode1 = childNodeList.item(c);
							org.w3c.dom.NodeList childNodeList1 = childNode1.getChildNodes();
							String mainKey = childNodeList.item(c).getNodeName();
							for (int d = 0; d < childNodeList1.getLength(); d++) {
								String key = childNodeList1.item(d).getNodeName();
								String val = HtmlUtil.unescape(childNodeList1.item(d).getTextContent().trim());
								if (mainKey.trim().equalsIgnoreCase("basic_info")
										|| mainKey.trim().equalsIgnoreCase("personal_info")
										|| mainKey.trim().equalsIgnoreCase("network_info")
										|| mainKey.trim().equalsIgnoreCase("contact_info")
										|| mainKey.trim().equalsIgnoreCase("workhistory")
										|| mainKey.trim().equalsIgnoreCase("availability_info")) {
									val = HtmlUtil.stripHtml(val);
									if (!key.equalsIgnoreCase("user_availability")
											&& !key.equalsIgnoreCase("contact_details")
											&& !key.equalsIgnoreCase("work_details")
											&& !key.equalsIgnoreCase("profileFields")) {
										if (!key.equals("#text")) {
											colTitle = getColumnTitle(key);

											if (!key.equalsIgnoreCase("first_name")
													&& !key.equalsIgnoreCase("last_name")
													&& !key.contains("_details")) {
												HSSFCell cellD = rowA.createCell(totalCols);
												cellD.setCellValue(new HSSFRichTextString(colTitle));
												cellD.setCellStyle(headerStyle);

												if (key.equalsIgnoreCase("gender")) {
													if (val == "1") {
														val = "Male";
													} else {
														val = "Female";
													}
												}
												HSSFCell cellC4 = rowB.createCell(totalCols);
												cellC4.setCellValue(new HSSFRichTextString(val));
												firstSheet.setColumnWidth(totalCols, 5000);
												cellC4.setCellStyle(wrapText);
												totalCols = totalCols + 1;
												totalValueCols = totalValueCols + 1;
											}
										}
									}

									if (key.equalsIgnoreCase("contact_details")
											|| key.equalsIgnoreCase("work_details")) {
										org.w3c.dom.Node childNode2 = childNodeList1.item(d);
										org.w3c.dom.NodeList childNodeList2 = childNode2.getChildNodes();
										for (int f = 0; f < childNodeList2.getLength(); f++) {
											key = childNodeList2.item(f).getNodeName();
											val = HtmlUtil.unescape(childNodeList2.item(f).getTextContent().trim());
											val = HtmlUtil.stripHtml(val);
											if (!key.equals("#text")) {
												colTitle = getColumnTitle(key);
												HSSFCell cellD = rowA.createCell(totalCols);
												cellD.setCellValue(new HSSFRichTextString(colTitle));
												cellD.setCellStyle(headerStyle);

												HSSFCell cellC4 = rowB.createCell(totalCols);
												cellC4.setCellValue(new HSSFRichTextString(val));
												firstSheet.setColumnWidth(totalCols, 5000);
												cellC4.setCellStyle(wrapText);
												totalCols = totalCols + 1;
												totalValueCols = totalValueCols + 1;
											}
										}
									}
								}
								if (mainKey.trim().equalsIgnoreCase("other_details")) {
									org.w3c.dom.Node childNode2 = childNodeList1.item(d);
									org.w3c.dom.NodeList childNodeList2 = childNode2.getChildNodes();
									int fieldInstance = 1;
									for (int f = 0; f < childNodeList2.getLength(); f++) {
										org.w3c.dom.Node childNode3 = childNodeList2.item(f);
										org.w3c.dom.NodeList childNodeList3 = childNode3.getChildNodes();
										if (!key.contains("_details")) {
											for (int g = 0; g < childNodeList3.getLength(); g++) {
												org.w3c.dom.Node childNode4 = childNodeList3.item(g);
												key = childNode4.getNodeName();
												val = HtmlUtil.unescape(childNode4.getTextContent().trim());
												val = HtmlUtil.stripHtml(val);
												boolean isaddCol = true;
												if (!key.equals("#text")) {
													colTitle = getColumnTitle(key);
													int totalscells = rowA.getPhysicalNumberOfCells();
													for (int t = 0; t < totalscells; t++) {
														String existingHeader = rowA.getCell(t).getStringCellValue();
														if (existingHeader.equalsIgnoreCase(colTitle)
																&& fieldInstance == 1) {
															isaddCol = false;
														}
													}
													if (isaddCol) {

														HSSFCell cellD = rowA.createCell(totalCols);
														cellD.setCellValue(new HSSFRichTextString(colTitle));
														cellD.setCellStyle(headerStyle);
														totalscells = totalscells + 1;
													}

													HSSFCell cellC4 = rowB.createCell(totalCols);
													cellC4.setCellValue(new HSSFRichTextString(val));
													firstSheet.setColumnWidth(totalCols, 5000);
													cellC4.setCellStyle(wrapText);
													totalCols = totalCols + 1;
													totalValueCols = totalValueCols + 1;
												}
											}
											fieldInstance = fieldInstance + 1;
										}
									}
								}
							}
						}
					}
				}

			}
		} catch (Exception e) {
			_log.error("Error creating excel" + e.getMessage());
		}

		FileOutputStream fos = null;

		try {
			try {

				// downloadLocation = "/usr/sambaashplatform/"+"excel";

				File copyFile = new File(downloadLocation);

				if (!copyFile.exists()) {
					copyFile.mkdirs();
				}
			} catch (Exception e) {
			}

			fileLocation = downloadLocation + "/UserProfileDetails" + String.valueOf(new Date().getTime()) + ".xls";
			fos = new FileOutputStream(new File(fileLocation));
			workbook.write(fos);
		} catch (IOException e) {
			_log.error("Error creating excel in the filelocation" + e.getMessage());
		} finally {
			if (fos != null) {
				try {
					fos.flush();
					fos.close();
				} catch (IOException e) {
					_log.error("Error - ", e);
				}
			}
		}

		return fileLocation;
	}

	private static String getColumnTitle(String indexableField) {
		// TODO Auto-generated method stub
		String colTitle = StringPool.BLANK;
		String[] indexableFieldArray = indexableField.split("_");
		colTitle = indexableField.replace(indexableField.substring(0, 1), indexableField.substring(0, 1).toUpperCase());
		colTitle = colTitle.replace("_", StringPool.SPACE);

		return colTitle;
	}

	private static Log _log = LogFactoryUtil.getLog(ASUtil.class);

}
