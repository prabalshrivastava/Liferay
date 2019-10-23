package com.sambaash.platform.enrolement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFileException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.action.ajax.CheckUserExistsActionHandler;
import com.sambaash.platform.action.ajax.CorporateActionHandler;
import com.sambaash.platform.action.ajax.CreateActionHandler;
import com.sambaash.platform.action.ajax.CreateUserActionHandler;
import com.sambaash.platform.action.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.action.ajax.ExportListActionHandler;
import com.sambaash.platform.action.ajax.ExportRowActionHandler;
import com.sambaash.platform.action.ajax.FetchActionHandler;
import com.sambaash.platform.action.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.action.ajax.FilterColumnListActionHandler;
import com.sambaash.platform.action.ajax.LoadListActionHandler;
import com.sambaash.platform.action.ajax.PricingActionHandler;
import com.sambaash.platform.action.ajax.ProgramActionHandler;
import com.sambaash.platform.action.ajax.SaveFeesActionHandler;
import com.sambaash.platform.action.ajax.SearchCanditateActionHandlerX;
import com.sambaash.platform.action.ajax.SearchListActionHandler;
import com.sambaash.platform.action.ajax.SendNotificationActionHandler;
import com.sambaash.platform.action.ajax.SendRequestActionHandler;
import com.sambaash.platform.action.ajax.SwitchActionHandler;
import com.sambaash.platform.action.ajax.VerifyEnrolmentActionHandler;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords;
import com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalServiceUtil;
import com.sambaash.platform.srv.enrolment.service.EnrollUploadedTempRecordsLocalServiceUtil;
import com.sambaash.platform.util.CandidateValidator;
import com.sambaash.platform.util.CandidateValidator.Response;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class EnrolmentPortlet
 */
public class EnrolmentPortlet extends MVCPortlet {

	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("corporate", CorporateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData", FetchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("createUser", CreateUserActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("search", SearchCanditateActionHandlerX.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("searchList", SearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", CreateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("program", ProgramActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadList", LoadListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("filterColumnList", FilterColumnListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchFormFields", FetchFormFieldsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("checkuser", CheckUserExistsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchList", ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportList", ExportListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("pricing", PricingActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("saveFees", SaveFeesActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("verify", VerifyEnrolmentActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("switch", SwitchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("sendRequest", SendRequestActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportRow", ExportRowActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportList", ExportListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("sendNotification", SendNotificationActionHandler.class);
	}

	/**
	 * This is an object of Log class
	 */
	private Log _log = LogFactoryUtil.getLog(EnrolmentPortlet.class.getName());

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			String action = resourceRequest.getParameter("action");
			String exportCSV = ParamUtil.getString(resourceRequest, "exportCSV");

			if (Validator.isNotNull(exportCSV) && exportCSV.equals("exportCSV")) {
				exportCSVData(resourceRequest, resourceResponse);
			}

			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletPreferences preferences = actionRequest.getPreferences();
		String candidateFormId = ParamUtil.getString(actionRequest, EnrolmentConstants.PREF_CANDIDATE_FORM_ID, EnrolmentConstants.DEFAULT_CANDIDATE_FORM_ID);
		String enrolmentFormId = ParamUtil.getString(actionRequest, EnrolmentConstants.PREF_ENROLMENT_FORM_ID, EnrolmentConstants.DEFAULT_ENROLMENT_FORM_ID);
		String style = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_CONTAINER_STYLE, StringPool.BLANK);
		String modelName = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_MODEL_NAME, "0");
		String baseUrl = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_BASE_URL, StringPool.BLANK);
		String cancelUrl = ParamUtil.getString(actionRequest, EnrolmentConstants.PREF_ENROLMENT_CANCEL_URL, EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL);
		String collectPaymentbaseUrl = ParamUtil.getString(actionRequest, EnrolmentConstants.PREF_COLLECT_PAYMENT_BASE_URL, StringPool.BLANK);
		try {
			preferences.setValue(EnrolmentConstants.PREF_CANDIDATE_FORM_ID, candidateFormId);
			preferences.setValue(EnrolmentConstants.PREF_ENROLMENT_FORM_ID, enrolmentFormId);
			preferences.setValue(SystemSetupConstants.PREF_CONTAINER_STYLE, style);
			preferences.setValue(SystemSetupConstants.PREF_MODEL_NAME, modelName);
			preferences.setValue(SystemSetupConstants.PREF_BASE_URL, baseUrl);
			preferences.setValue(EnrolmentConstants.PREF_ENROLMENT_CANCEL_URL, cancelUrl);
			preferences.setValue(EnrolmentConstants.PREF_COLLECT_PAYMENT_BASE_URL, collectPaymentbaseUrl);
			preferences.setValue(SystemSetupConstants.ACTION_VIEW_MODEL, "newuser");
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException | ValidatorException | IOException | PortletModeException e) {
			_log.error(e);
		}

	}

	public void uploadFiles(ActionRequest actionRequest, ActionResponse actionResponse) {

		String response = EnrollBatchUploadLocalServiceUtil.handleBatchUploadFile(actionRequest, actionResponse);

		JSONObject data = null;
		String totalRecords = "0";
		String successfulRecords = "0";
		String failedRecords = "0";
		JSONArray invalidRecords = JSONFactoryUtil.createJSONArray();
		JSONObject heading = JSONFactoryUtil.createJSONObject();
		JSONObject sequence = JSONFactoryUtil.createJSONObject();
		try {
			data = JSONFactoryUtil.createJSONObject(response).getJSONObject("data");
		} catch (JSONException e) {
			_log.error(e);
		}
		totalRecords = data.getString("totalRecords");
		successfulRecords = data.getString("successfulRecords");
		failedRecords = data.getString("failedRecords");
		invalidRecords = data.getJSONArray("invalidRecords");
		heading = data.getJSONObject("heading");
		actionResponse.setRenderParameter("totalRecords", String.valueOf(totalRecords));
		actionResponse.setRenderParameter("successfulRecords", String.valueOf(successfulRecords));
		actionResponse.setRenderParameter("failedRecords", String.valueOf(failedRecords));
		actionResponse.setRenderParameter("invalidRecords", invalidRecords.toString());
		actionResponse.setRenderParameter("heading", heading.toString());
		actionResponse.setRenderParameter("sequence", sequence.toString());
		actionResponse.setRenderParameter("pendingProcessing", "0");

		actionResponse.setRenderParameter("responsee", response);
		actionResponse.setRenderParameter("mvcPath", "/html/enrolment/batch/uploadStat.jsp");
	}

	public void uploadFiles1(ActionRequest actionRequest, ActionResponse actionResponse) {
		int totalRecords = 0;
		int successfulRecords = 0;

		EnrollBatchUploadLocalServiceUtil.deleteAllLocations();

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		File filUpload = uploadRequest.getFile("filesToUpload", true);
		int pos = uploadRequest.getFileName("filesToUpload").lastIndexOf('.');
		String fileExtension = uploadRequest.getFileName("filesToUpload").substring(pos + 1);
		if (Validator.isNull(fileExtension) || !(fileExtension.equalsIgnoreCase("csv"))) {
			try {
				throw new NoSuchFileException();
			} catch (NoSuchFileException e) {
				_log.error(e);
			}
		}

		String uploadTransactId = PortalUUIDUtil.generate();
		if (fileExtension
				.equalsIgnoreCase("csv") /* || (fileExtension == "csv") */) {
			BufferedReader br = null;
			try {

				br = new BufferedReader(new FileReader(filUpload.getAbsolutePath()));

				for (int itri = 1;; itri++) {
					totalRecords++;
					String strLine = br.readLine();

					if (strLine == null) {
						break;
					}

					String[] rawData = strLine.split(",");
					String sprCode = rawData[0];
					String title = rawData[1];
					String name = rawData[2];
					String gender = rawData[3];
					String dob = rawData[4];
					String IDtype = rawData[5];
					String IDNumber1 = rawData[6];
					String IDNumber2 = rawData[6];
					String addressLine1 = rawData[7];
					String addressLine2 = rawData[8];
					String addressLine3 = rawData[9];
					String addressLine4 = rawData[10];
					String country = rawData[11];
					String postalCode = rawData[12];
					String telephone1 = rawData[13];
					String telephone2 = rawData[14];
					String email = rawData[15];
					String programmeCode = rawData[16];
					String routeCode = rawData[17];
					String facultyCode = rawData[18];
					String moduleCode = rawData[19];
					String moduleOccurance = rawData[20];
					String academicYear = rawData[21];
					String period = rawData[22];
					String courseBlock = StringPool.BLANK;
					String courseWorkOnly = StringPool.BLANK;
					String entered = StringPool.BLANK;
					String[] combinedName = name.split("\\s+");

					String firstName = StringPool.BLANK, middleName = StringPool.BLANK, lastName = StringPool.BLANK;

					switch (combinedName.length) {
					case 1:
						firstName = combinedName[0];
						break;

					case 2:
						firstName = combinedName[0];
						lastName = combinedName[1];
						break;

					case 3:
						firstName = combinedName[0];
						middleName = combinedName[1];
						lastName = combinedName[2];
						break;

					default:
						break;
					}
					EnrollUploadedTempRecords records = EnrollUploadedTempRecordsLocalServiceUtil.addEnrollUploadStat(
							uploadTransactId, dob, gender, themeDisplay.getUserId(), name, sprCode, title, email);
					CandidateValidator candidateValidator = new CandidateValidator();

					Response result = candidateValidator.isValidCandidate(rawData, themeDisplay.getCompanyId(),
							uploadTransactId, themeDisplay.getUserId(), records.getUploadedRecId());

					if (itri > 0) {
						if (result.isValid) {
							User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(),
									email);
							if (user == null) {
								user = addUser(email, name);
							}
							if (Validator.isNotNull(user)) {
								successfulRecords++;
								String vocabularyURL = SambaashUtil
										.getParameter(SambaashConstants.API_STORAGE_ENGINE_BASEURL, 54501);
								long currentUserId = themeDisplay.getUserId();
								long currentGroupId = themeDisplay.getSiteGroupId();

								JSONObject apiRequest = JSONFactoryUtil.createJSONObject();
								JSONObject candidateData = JSONFactoryUtil.createJSONObject();

								candidateData.put("FirstName", firstName);
								candidateData.put("UserId", String.valueOf(user.getUserId()));
								candidateData.put("ModelName", "Candidate");

								candidateData.put("Remarks", StringPool.BLANK);
								candidateData.put("InactiveReason", StringPool.BLANK);
								candidateData.put("LastName", lastName);
								candidateData.put("CorporateName", StringPool.BLANK);
								candidateData.put("PrimaryEmailAddress", email);
								candidateData.put("FullName", name);
								candidateData.put("MiddleName", middleName);
								candidateData.put("BuildingName", addressLine1);
								candidateData.put("CandidateStatus", "Pending");
								candidateData.put("HouseBlockNo", addressLine2);
								candidateData.put("ContactNumberSingapore", telephone1);
								candidateData.put("SrnNumber", sprCode);
								candidateData.put("SecondaryEmailAddress", StringPool.BLANK);
								candidateData.put("CorporateCode", StringPool.BLANK);
								candidateData.put("SponsorshipType", StringPool.BLANK);
								candidateData.put("Salutation", StringPool.BLANK);
								candidateData.put("IDType2", StringPool.BLANK);
								candidateData.put("ContactNumberOthers", telephone2);
								candidateData.put("Country", country);
								candidateData.put("DateOfBirth", dob);
								candidateData.put("EnrolmentStatus", "Pending");
								candidateData.put("PostalCode", postalCode);
								candidateData.put("UnitNo", StringPool.BLANK);
								candidateData.put("IDType", IDtype);
								candidateData.put("Gender", gender);
								candidateData.put("FacultyCode", facultyCode);

								candidateData.put("PrimaryEmailAddress", email);
								candidateData.put("submit", "true");

								candidateData.put("IDNumber", IDNumber1);
								candidateData.put("IDNumber2", IDNumber2);

								apiRequest.put("contentJson", candidateData);
								this.post(vocabularyURL + "/candidate/new", apiRequest.toString(), currentUserId,
										currentGroupId);
							}
						}
					}
				}

			} catch (Exception e) {
				_log.error(e);
			}
		}
		int failedRecords = totalRecords - successfulRecords;
		actionResponse.setRenderParameter("uploadTransactId", uploadTransactId);
		actionResponse.setRenderParameter("totalRecords", String.valueOf(totalRecords));
		actionResponse.setRenderParameter("successfulRecords", String.valueOf(successfulRecords));
		actionResponse.setRenderParameter("failedRecords", String.valueOf(failedRecords));

		actionResponse.setRenderParameter("pendingProcessing", "0");

		actionResponse.setRenderParameter("mvcPath", "/html/enrolment/batch/uploadStat.jsp");
	}

	public void post(String url, String param, long currentUserId, long currentGroupId) throws Exception {
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		conn.setRequestProperty("X-USER-ID", String.valueOf(currentUserId));
		conn.setRequestProperty("X-SCOPEGROUP-ID", String.valueOf(SambaashUtil.getScopeGroupId(currentGroupId)));

		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

		writer.write(param);
		writer.flush();
		writer.close();
	}

	protected User addUser(String email, String name) {

		Date date = new Date();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUuid(UUID.randomUUID().toString());
		serviceContext.setCreateDate(date);
		serviceContext.setModifiedDate(date);
		long companyId = PortalUtil.getDefaultCompanyId();
		long creatorUserId = 0;
		boolean autoPassword = false;
		boolean autoScreenName = false;
		boolean male = true;
		boolean sendEmail = false;
		int prefixId = 1;
		int suffixId = 1;
		int birthdayMonth = 1;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String screenName = name;
		String jobTitle = StringPool.BLANK;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] userGroupIds = null;
		String password1 = "test";
		String password2 = "test";
		String firstName = name;
		String lastName = name;
		String emailAddress = email;
		long facebookId = 0;
		String openId = StringPool.BLANK;
		Locale locale = LocaleUtil.getDefault();
		Role rolePu;
		User user = null;
		try {
			rolePu = RoleLocalServiceUtil.getRole(companyId, RoleConstants.SITE_MEMBER);
			long[] roleIds = { rolePu.getRoleId() };

			user = UserLocalServiceUtil.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1,
					password2, autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName,
					StringPool.BLANK, lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
					jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		} catch (SystemException e) {
			_log.error(e);
		} catch (Exception e) {
			_log.error(e);
		}

		return user;
	}

	protected void exportCSVData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		String[] columnNames = { "uploadTransactId", "email", "DOB", "SPR Code", "Full Official Name" };
		String CSV_SEPARATOR = ",";
		StringBundler sb = new StringBundler();
		for (String columnName : columnNames) {
			sb.append(getCSVFormattedValue(columnName));
			sb.append(CSV_SEPARATOR);
		}
		sb.setIndex(sb.index() - 1);
		sb.append(CharPool.NEW_LINE);
		List<EnrollUploadedTempRecords> usersList = EnrollUploadedTempRecordsLocalServiceUtil
				.getEnrollUploadedTempRecordses(0,
						EnrollUploadedTempRecordsLocalServiceUtil.getEnrollUploadedTempRecordsesCount());
		for (EnrollUploadedTempRecords user : usersList) {
			sb.append(getCSVFormattedValue(String.valueOf(user.getUploadTransactId())));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getEmail())));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getDateofBirth())));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getSprCode())));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getFullOfficialName())));
			sb.append(CSV_SEPARATOR);
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);
		}

		String fileName = "portalUsers.csv";
		byte[] bytes = sb.toString().getBytes();
		String contentType = ContentTypes.APPLICATION_TEXT;
		PortletResponseUtil.sendFile(resourceRequest, resourceResponse, fileName, bytes, contentType);
	}

	protected String getCSVFormattedValue(String value) {
		StringBundler sb = new StringBundler(3);
		sb.append(CharPool.QUOTE);
		sb.append(StringUtil.replace(value, CharPool.QUOTE, StringPool.DOUBLE_QUOTE));
		sb.append(CharPool.QUOTE);
		return sb.toString();
	}

	public void proceedToFees(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionResponse.setRenderParameter("pendingProcessing", "0");
		actionResponse.setRenderParameter("mvcPath", "/html/enrolment/fee.jsp");

	}
}
