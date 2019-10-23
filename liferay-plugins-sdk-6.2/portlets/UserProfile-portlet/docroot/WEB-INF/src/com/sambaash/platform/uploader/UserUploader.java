package com.sambaash.platform.uploader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.FileExtensionException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.exception.FileFormatException;
import com.sambaash.platform.model.ProfileType;
import com.sambaash.platform.model.UserMetaData;
import com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil;
import com.sambaash.platform.portlet.socialprofile.util.XMLManipulator;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class UserUploader
 */
public class UserUploader extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(UserUploader.class);

	public static String ACTION_CREATE_CATEGORY_IF_NOT_EXIST = "createCatgIfNotExists";
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		renderRequest.setAttribute("hasAccess", (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(),
				themeDisplay.getUserId()) || SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(),
				themeDisplay.getUserId())));

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		_log.error("processAction");
		String action = actionRequest.getParameter("action");

		long companyId = PortalUtil.getCompanyId(actionRequest);
		try {
			if ("uploadFiles".equalsIgnoreCase(action)) {
				UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
				File[] files = uploadPortletRequest.getFiles("filesToUpload");
				for (File file : files) {
					if (_log.isDebugEnabled()) {
						_log.debug("---------------- fileName : " + file.getName());
					}
					Workbook wb = null;
					if (file.getName().endsWith(EXCEL.EXTENSION)) {
						wb = readFileXlsx(new FileInputStream(file));
					} else if (file.getName().endsWith(EXCEL.EXTENSION_OLD)) {
						wb = readFileXls(new FileInputStream(file));
					} else {
						throw new FileFormatException(FileFormatException.FILE_TYPE_EXCEPTION);
					}

					if (wb == null || wb.getNumberOfSheets() < 2) {
						throw new FileFormatException(FileFormatException.METADATA_EXCEPTION);
					}

					Map<String, UserMetaData> metaData = readMetaData(wb);
					for (int i = 1; i < wb.getNumberOfSheets(); i++) {
						Sheet userData = wb.getSheetAt(i);
						if (validate(metaData, userData)) {
							processData(companyId, metaData, userData, actionRequest);
						}
					}

					actionRequest.setAttribute("success", "true");

				}
			}
		} catch (Exception e) {
			if (e instanceof FileExtensionException || e instanceof FileFormatException) {
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
			_log.error(e);
		}
	}

	private Map<String, UserMetaData> readMetaData(Workbook wb) throws FileFormatException {
		Sheet sheet = wb.getSheetAt(0);
		Map<String, UserMetaData> metaDataMap = new LinkedHashMap<String, UserMetaData>();

		if (!"firstName".toLowerCase().equalsIgnoreCase(sheet.getRow(1).getCell(0).getStringCellValue())
				|| !"lastName".toLowerCase().equalsIgnoreCase(sheet.getRow(2).getCell(0).getStringCellValue())
				|| !"emailAddress".toLowerCase().equalsIgnoreCase(sheet.getRow(3).getCell(0).getStringCellValue())) {
			throw new FileFormatException(FileFormatException.FIXED_COLUMN_EXCEPTION);
		}

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			if (Validator.isNotNull(row) && Validator.isNotNull(row.getCell(0))
					&& Validator.isNotNull(row.getCell(0).getStringCellValue())) {
				String columnName = row.getCell(0).getStringCellValue().trim();
				boolean multiInstance = "multi-instance".equalsIgnoreCase(Validator.isNotNull(row.getCell(4)) ? row
						.getCell(4).getStringCellValue().trim() : StringPool.BLANK);

				if (metaDataMap.containsKey(columnName)) {
					_log.error("Duplicate columnName in metadata : " + columnName);
					throw new FileFormatException(FileFormatException.DUPLICATE_COLUMN_NAME_IN_METADATA);
				}

				String categoryName = row.getCell(1).getStringCellValue().trim();
				String categoryDetail = row.getCell(2).getStringCellValue().trim();
				boolean override = "override".equalsIgnoreCase(Validator.isNotNull(row.getCell(3)) ? row.getCell(3)
						.getStringCellValue().trim() : StringPool.BLANK);
				

				UserMetaData userMetaData = new UserMetaData(columnName, categoryName, categoryDetail, override,
						multiInstance);
				
				String action = getCellValue(row.getCell(6));
				if(ACTION_CREATE_CATEGORY_IF_NOT_EXIST.equalsIgnoreCase(action)){
					userMetaData.setAction(action);
					userMetaData.setVocId(UserProfileUtil.getVocId(categoryName, categoryDetail));
				}
				metaDataMap.put(columnName, userMetaData);
			}
		}
		return metaDataMap;
	}
	
	private String getCellValue(Cell cell){
		if(cell != null){
			return cell.getStringCellValue().trim();
		}
		return StringPool.BLANK;
	}

	
	private boolean validate(Map<String, UserMetaData> metaData, Sheet userData) throws FileFormatException {
		Row header = userData.getRow(0);
		Iterator<Cell> cellIterator = header.cellIterator();
		Set<String> columnNames = new HashSet<String>();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			if (Validator.isNotNull(cell) && Validator.isNotNull(cell.getStringCellValue())) {
				if (!metaData.containsKey(cell.getStringCellValue().trim())) {
					_log.error("Column not found in metadata : " + cell.getStringCellValue().trim());
					throw new FileFormatException(FileFormatException.COLUMN_NOT_FOUND_IN_METADATA);
				}
				columnNames.add(cell.getStringCellValue().trim());
			}
		}

		if (!(metaData.size() == columnNames.size())) {
			_log.error("Column count not equal : metaData.size() :  " + metaData.size()
					+ " : columnNames.size() in data sheet : " + columnNames.size());
			throw new FileFormatException(FileFormatException.COLUMN_COUNT_NOT_EQUAL);
		}

		if (!"firstName".equalsIgnoreCase(header.getCell(0).getStringCellValue().trim())
				|| !"lastName".equalsIgnoreCase(header.getCell(1).getStringCellValue().trim())
				|| !"emailAddress".equalsIgnoreCase(header.getCell(2).getStringCellValue().trim())) {
			throw new FileFormatException(FileFormatException.FIXED_COLUMN_EXCEPTION);
		}

		return true;

	}

	private void override(long companyId, Map<String, UserMetaData> metaData, Sheet userData,
			Map<String, List<Row>> dataMap) {
		List<Row> rowList = null;
		Row headerRow = userData.getRow(0);
		for (Map.Entry<String, List<Row>> entry : dataMap.entrySet()) {
			rowList = entry.getValue();
			// boolean overrideCompleted = false;

			Row row = rowList.get(0);

			if (Validator.isNull(row.getCell(2)) || Validator.isNull(row.getCell(2).getStringCellValue())) {
				_log.error("Error in retrieveing email address : " + row.getRowNum());
				continue;
			}

			String emailAddress = row.getCell(2).getStringCellValue();

			User user = null;
			try {
				user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
				if (_log.isDebugEnabled()) {
					_log.debug("user already exists");
				}

				try {
					SocialProfile socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId());
					if (socialProfile != null) {
						String userXml = socialProfile.getUserInfo();
						XMLManipulator manipulator = new XMLManipulator(userXml);
						boolean updateRequired = false;
						for (int c = 3; c < row.getLastCellNum(); c++) {
							UserMetaData userMetaData = metaData.get(headerRow.getCell(c).getStringCellValue().trim());
							if (userMetaData.isMultiInstance() && userMetaData.isOverride()) {
								_log.error("userMetaData.getCategoryName() : " + userMetaData.getCategoryName()
										+ " : userMetaData.getCategoryDetail() : " + userMetaData.getCategoryDetail());
								// manipulator.removeAllNodes(userMetaData.getCategoryName(),
								// userMetaData.getCategoryDetail());
								String nodeXQuery = "//" + userMetaData.getCategoryName() + "/"
										+ userMetaData.getCategoryName() + "_details";
								manipulator.removeAllNodes(nodeXQuery);
								updateRequired = true;
							}
						}
						if (updateRequired) {
							socialProfile.setUserInfo(manipulator.toString(null));
							SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);
						}
					} else {
						_log.error("SocialProfile not found for userId : " + user.getUserId());
					}
				} catch (PortalException e) {
					_log.error(e);
				} catch (SystemException e) {
					_log.error(e);
				} catch (Exception e) {
					_log.error(e);
				}

			} catch (NoSuchUserException nsue) {
				_log.error("User doesn't exist. Can't override : " + emailAddress);
			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}
		}
	}

	private void processData(long companyId, Map<String, UserMetaData> metaData, Sheet userData,
			ActionRequest actionRequest) {
		String apiKey = "cWqb6X63ut+SXix3RESxtIy1W412NbY/MLLZf3v4RA==";

		Row headerRow = userData.getRow(0);
		Map<String, List<Row>> dataMap = new Hashtable<String, List<Row>>();

		List<Row> rowList = null;
		// Map<String, String> errorMap = new HashMap<String, String>();
		if (_log.isDebugEnabled()) {
			_log.debug("***** userData.getLastRowNum() : " + userData.getLastRowNum());
			_log.debug("***** userData.getPhysicalNumberOfRows() : " + userData.getPhysicalNumberOfRows());
		}
		for (int r = 1; r <= userData.getLastRowNum(); r++) {
			Row row = userData.getRow(r);
			if(row == null) continue;
			String emailAddress = StringPool.BLANK;
			if (Validator.isNull(row.getCell(2)) && Validator.isNotNull(row.getCell(0))
					&& Validator.isNotNull(row.getCell(0).getStringCellValue())) {
				emailAddress = "dummy_" + Calendar.getInstance().getTimeInMillis() + "@dummy.com";
				if (_log.isDebugEnabled()) {
					_log.debug("***** Creating record with dummy email : " + emailAddress);
				}
			} else if (Validator.isNotNull(row.getCell(2))
					&& Validator.isEmailAddress(row.getCell(2).getStringCellValue())) {
				emailAddress = row.getCell(2).getStringCellValue().trim().toLowerCase();
				if (_log.isDebugEnabled()) {
					_log.debug("***** row.getCell(2).getStringCellValue() : " + row.getCell(2).getStringCellValue());
				}
			} else {
				if (_log.isDebugEnabled()) {
					_log.debug("***** invalid emailAddress ");
				}
				continue;
			}

			if (dataMap.containsKey(emailAddress)) {
				// _log.error("adding emailAddress to map existing list: " +
				// emailAddress);
				dataMap.get(emailAddress).add(row);
			} else {
				rowList = new ArrayList<Row>();
				rowList.add(row);
				// _log.error("adding emailAddress to map new list: " +
				// emailAddress);
				dataMap.put(emailAddress, rowList);
			}
		}

		UploadThread t = new UploadThread(actionRequest, companyId, metaData, userData, dataMap, apiKey, headerRow);
		t.run();
//		cannot run a new thread, unless we can pass all Liferay ThreadLocal variables to the new thread
//		otherwise, these data will get lost (e.g. CompanyThreadLocal)
//		Runnable r = new UploadThread(actionRequest, companyId, metaData, userData, dataMap, apiKey, headerRow);
//		new Thread(r).start();

	}

	private class UploadThread implements Runnable {

		ActionRequest actionRequest = null;
		long companyId = -1L;
		Map<String, UserMetaData> metaData = null;
		Sheet userData = null;
		Map<String, List<Row>> dataMap = null;
		String apiKey = null;
		Row headerRow = null;
		private long groupId;

		public UploadThread(ActionRequest actionRequest, long companyId, Map<String, UserMetaData> metaData,
				Sheet userData, Map<String, List<Row>> dataMap, String apiKey, Row headerRow) {
			this.actionRequest = actionRequest;
			this.companyId = companyId;
			this.metaData = metaData;
			this.userData = userData;
			this.dataMap = dataMap;
			this.apiKey = apiKey;
			this.headerRow = headerRow;
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			this.groupId = themeDisplay.getScopeGroupId();
		}

		public void run() {
			upload(actionRequest, companyId, metaData, userData, dataMap, apiKey, headerRow,groupId);
		}
	}

	@SuppressWarnings("deprecation")
	private void upload(ActionRequest actionRequest, long companyId, Map<String, UserMetaData> metaData,
			Sheet userData, Map<String, List<Row>> dataMap, String apiKey, Row headerRow, long groupId) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Map<String, Role> roleMap = new HashMap<String, Role>();
	
		for (Map.Entry<String, List<Row>> entry : dataMap.entrySet()) {
			List<Row> rowList = entry.getValue();
			// boolean overrideCompleted = false;
			for (Row row : rowList) {

				try {
					String firstName = row.getCell(0).getStringCellValue();
					String lastName = row.getCell(1).getStringCellValue();

					if (Validator.isNull(row.getCell(2)) || Validator.isNull(row.getCell(2).getStringCellValue())) {
						_log.debug("Error in retrieveing email address : " + row.getRowNum());
						continue;
					}

					String emailAddress = row.getCell(2).getStringCellValue();

					if (Validator.isNull(firstName)) {
						_log.error("Invalid Data");
						continue;
					}

					if (Validator.isNull(lastName)) {
						lastName = ".";
						_log.error("***** dummy last name : " + lastName);
					}

					User user = null;
					try {
						user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
						_log.debug("user already exists");
						// Find if there is change. Update user object only if there is change.
						if(! (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) && user.getEmailAddress().equals(emailAddress)){
							_log.debug("Change in user details.So changes will be updated.");
							user.setFirstName(firstName);
							user.setLastName(lastName);
							user.setLastLoginDate(new Date());
							UserLocalServiceUtil.updateUser(user);
						}
					} catch (NoSuchUserException nsue) {
						_log.debug("Will create user : " + emailAddress);
						user = SocialProfileServiceUtil.addUser(apiKey, firstName, lastName, emailAddress, "zaq12wsx",
								false);
					} catch (PortalException e) {
						_log.error(e);
					} catch (SystemException e) {
						_log.error(e);
					}

					String lastCategoryName = StringPool.BLANK;
					String instance = StringPool.BLANK;

					if (Validator.isNotNull(user)) {
						try {
							SocialProfile socialProfile = null;
							try {
								socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId());
							} catch (NoSuchSocialProfileException e) {
								// _log.error("Social Profile not found");
							}

							if (socialProfile != null) {

								String userXml = socialProfile.getUserInfo();
								XMLManipulator manipulator = new XMLManipulator(userXml);
								for (int c = 3; c < row.getLastCellNum(); c++) {
									UserMetaData userMetaData = metaData.get(headerRow.getCell(c).getStringCellValue()
											.trim());
									Node node = null;

									if (Validator.isNotNull(row.getCell(c))) {
										Cell cell = row.getCell(c);
										String cellValue = StringPool.BLANK;
										switch (cell.getCellType()) {

										case HSSFCell.CELL_TYPE_STRING:
											cellValue = cell.getRichStringCellValue().getString();
											break;
										case HSSFCell.CELL_TYPE_NUMERIC:
											if (HSSFDateUtil.isCellDateFormatted(cell)) {
												Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
												cellValue = formatter.format(date);
												if (_log.isDebugEnabled()) {
													_log.debug("Date : " + cellValue);
												}
											} else {
												cell.setCellType(Cell.CELL_TYPE_STRING);
												cellValue = cell.getRichStringCellValue().getString();
												// cellValue =
												// Double.toString(cell.getNumericCellValue());
												if (_log.isDebugEnabled()) {
													_log.debug("Number converted to string : " + cellValue);
												}
											}
											break;
										}
										if (Validator.isNotNull(cellValue)) {
											
											if(ACTION_CREATE_CATEGORY_IF_NOT_EXIST.equalsIgnoreCase(userMetaData.getAction()) && userMetaData.getVocId() > 0){
												createAssetCatgoryIfNtExist(
														userMetaData, cellValue,groupId);
											}

											if ("role".equalsIgnoreCase(userMetaData.getColumnName())) {

												String[] rolesNameArray = cellValue.split(",");

												for (String roleName : rolesNameArray) {
													if (Validator.isNotNull(roleName)) {
														roleName = roleName.trim();
														Role role = null;
														if (roleMap.containsKey(roleName)) {
															role = roleMap.get(roleName);
														} else {

															try {
																role = RoleLocalServiceUtil.getRole(
																		user.getCompanyId(), roleName);

															} catch (NoSuchRoleException ne) {
																Map<Locale, String> titleMap = new HashMap<Locale, String>();
																titleMap.put(LocaleUtil.getDefault(), roleName);

																Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
																descriptionMap.put(LocaleUtil.getDefault(), roleName);

																role = RoleLocalServiceUtil.addRole(
																		SambaashUtil.getAdminUserId(),
																		user.getCompanyId(), roleName, titleMap,
																		descriptionMap, RoleConstants.TYPE_REGULAR);
															}

															roleMap.put(roleName, role);
														}

														if (Validator.isNotNull(role)) {
															_log.debug("Adding " + role.getName() + " role to "
																	+ user.getEmailAddress());
															UserLocalServiceUtil.addRoleUsers(role.getRoleId(),
																	new long[] { user.getUserId() });
														}

													}
												}

											} else if ("type".equalsIgnoreCase(userMetaData.getColumnName())) {
												ServiceContext serviceContext = ServiceContextFactory.getInstance(
														User.class.getName(), actionRequest);
												if (ProfileType.MARKETER.getValue().equalsIgnoreCase(cellValue)
														|| SambaashConstants.MENTOR.equalsIgnoreCase(cellValue)) {
													SocialProfileLocalServiceUtil.updateProfileType(user,
															ProfileType.MARKETER, serviceContext);
												}

												if (SambaashConstants.MENTOR.equalsIgnoreCase(cellValue)) {
													SocialProfileLocalServiceUtil.addAsMentor(user, serviceContext);
												}
											} else {

												if (!lastCategoryName.equalsIgnoreCase(userMetaData.getCategoryName())) {
													node = manipulator.selectNode(userMetaData.getCategoryName(),
															userMetaData.getCategoryDetail());
													if (Validator.isNull(node)) {
														if (!(userMetaData.getCategoryName()
																.startsWith("personal_info")
																|| userMetaData.getCategoryName().startsWith(
																		"basic_info")
																|| userMetaData.getCategoryName().startsWith(
																		"availability_info")
																|| userMetaData.getCategoryName().startsWith(
																		"network_info") || userMetaData
																.getCategoryName().startsWith("contact_info"))) {
															instance = createXml(manipulator,
																	userMetaData.getCategoryName(),
																	userMetaData.getCategoryDetail());
														}
													}

												}

												if (Validator.isNull(node)) {
													if (userMetaData.getCategoryName().startsWith("contact_info")) {
														_log.debug("Updating contact_info node : "
																+ userMetaData.getCategoryDetail());
														String nodeXQuery = "//contact_info/contact_details/"
																+ userMetaData.getCategoryDetail();

														Node cNode = manipulator.selectNode(nodeXQuery);
														if (Validator.isNull(cNode)) {
															nodeXQuery = "//contact_info/contact_details/address_details/"
																	+ userMetaData.getCategoryDetail();
															cNode = manipulator.selectNode(nodeXQuery);
														}
														if (Validator.isNull(cNode)) {
															nodeXQuery = "//contact_info/contact_details/phone_details/"
																	+ userMetaData.getCategoryDetail();
														}

														manipulator.setNodeValue(cellValue, nodeXQuery);

													} else if (userMetaData.getCategoryName().startsWith("workhistory")
															&& userMetaData.isMultiInstance()
															&& Validator.isNotNull(row.getCell(c))) {
														_log.debug("Updating MultiInstance node : "
																+ userMetaData.getCategoryDetail());
														String nodeXQuery = "//" + userMetaData.getCategoryName() + "/"
																+ "work_details[@id='" + instance + "']/"
																+ userMetaData.getCategoryDetail();
														manipulator.setNodeValue(cellValue, nodeXQuery);
													} else if (userMetaData.isMultiInstance()
															&& Validator.isNotNull(row.getCell(c))) {
														_log.debug("Updating MultiInstance node : "
																+ userMetaData.getCategoryDetail());
														String nodeXQuery = "//" + userMetaData.getCategoryName() + "/"
																+ userMetaData.getCategoryName() + "_details[@id='"
																+ instance + "']/" + userMetaData.getCategoryDetail();
														manipulator.setNodeValue(cellValue, nodeXQuery);
													} else {

														node = manipulator.selectNode(userMetaData.getCategoryName(),
																userMetaData.getCategoryDetail());
														if (Validator.isNotNull(node)) {
															manipulator.setNodeValue(cellValue,
																	"//" + userMetaData.getCategoryName() + "/"
																			+ userMetaData.getCategoryDetail());
														} else {
															_log.debug("Error in data or node "
																	+ userMetaData.getCategoryDetail());
														}
													}
												} else if (Validator.isNotNull(node)) {
													if ((Validator.isNull(node.getNodeValue()) || userMetaData
															.isOverride()) && Validator.isNotNull(row.getCell(c))) {
														_log.debug("Updating single instance node : "
																+ userMetaData.getCategoryDetail());

														if (userMetaData.getCategoryName().startsWith("basic_info")
																&& "gender".equalsIgnoreCase(userMetaData
																		.getCategoryDetail())) {
															if ("M".equalsIgnoreCase(cellValue)
																	|| "MALE".equalsIgnoreCase(cellValue)) {
																cellValue = "1";
															} else if ("F".equalsIgnoreCase(cellValue)
																	|| "FEMALE".equalsIgnoreCase(cellValue)) {
																cellValue = "0";
															}
														}

														manipulator.setNodeValue(cellValue,
																"//" + userMetaData.getCategoryName() + "/"
																		+ userMetaData.getCategoryDetail());

													}
												}

												lastCategoryName = userMetaData.getCategoryName();
											}
										}
									}
								}
								// overrideCompleted = true;
								socialProfile.setUserInfo(manipulator.toString(null));
								SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);
							} else {
								_log.error("SocialProfile not found for userId : " + user.getUserId());
							}
						} catch (PortalException e) {
							_log.error(e);
						} catch (SystemException e) {
							_log.error(e);
						} catch (Exception e) {
							_log.error(e);
						}
					} else {
						_log.error("user is null");
					}
				} catch (Exception e) {
					_log.error("Will skip this record due to unknown errros : Row Number : " + row.getRowNum()
							+ " Email Address : " + row.getCell(2) + " First Name : " + row.getCell(0)
							+ " Last Name : " + row.getCell(1));
				}
			}
		}

		override(companyId, metaData, userData, dataMap);
	}

	private void createAssetCatgoryIfNtExist(UserMetaData userMetaData, String cellValue,long groupId)
			throws SystemException {
		List<AssetCategory> list = AssetCategoryLocalServiceUtil.getVocabularyCategories(userMetaData.getVocId(), -1, -1, null);
		boolean create = true;
		for (AssetCategory assetCategory : list) {
			if(cellValue.equalsIgnoreCase(assetCategory.getName())){
				// category found and no need to create;
				create = false;
				break; 
			}
		}
		if(create){
			try{
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setScopeGroupId(groupId);
				AssetCategoryLocalServiceUtil.addCategory(SambaashUtil.getAdminUserId(), cellValue, userMetaData.getVocId(),serviceContext );
			}catch(Exception ex){
				_log.error(ex);
			}
		}
	}

	private String createXml(XMLManipulator manipulator, String categoryName, String categoryDetails)
			throws SystemException, Exception {
		Node node = null;
		String _instance = String.valueOf(new Date().getTime());
		if (Validator.isNotNull(categoryName) && Validator.isNotNull(categoryDetails)) {
			String xmlFile = "";
			SPParameter parameter = null;

			// XMLManipulator manipulator = new XMLManipulator(userXml);

			String attr = manipulator.findNodeById(categoryName + StringPool.SLASH + categoryDetails, "id", _instance);

			if (Validator.isNull(attr)) {
				attr = manipulator.findNodeById("other_details" + StringPool.SLASH + categoryName + StringPool.SLASH
						+ categoryDetails, "id", _instance);
			}

			if (Validator.isNull(attr)) { // create new node
				try {
					parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(0, categoryName
							+ ".xml.template");
					xmlFile = parameter.getDescription();
				} catch (NoSuchSPParameterException e1) {
					_log.error(e1);
				}

				String mNode = "//profile";

				if (!(categoryName.startsWith("personal_info") || categoryName.startsWith("basic_info")
						|| categoryName.startsWith("availability_info") || categoryName.startsWith("network_info") || categoryName
							.startsWith("contact_info"))) {
					if (Validator.isNull(manipulator.findNode("//profile/other_details"))) {
						manipulator.appendNode("other_details", mNode);
					}

					mNode = "//other_details";
				}

				node = manipulator.appendXmlWithId(categoryName, xmlFile, _instance);
				if (node == null) {
					_log.error("Can't find nodeId so it will add in otherDetails");
					if (Validator.isNull(manipulator.findNode(mNode + "/" + categoryName))) {
						manipulator.appendNode(categoryName, mNode);
					}
					node = manipulator.appendXmlWithId(mNode + "/" + categoryName, xmlFile, _instance);

				}
			}
		}
		return _instance;
	}

	private HSSFWorkbook readFileXls(InputStream inputStream) throws IOException {
		return new HSSFWorkbook(inputStream);
	}

	private XSSFWorkbook readFileXlsx(InputStream inputStream) throws IOException {
		return new XSSFWorkbook(inputStream);
	}

}
