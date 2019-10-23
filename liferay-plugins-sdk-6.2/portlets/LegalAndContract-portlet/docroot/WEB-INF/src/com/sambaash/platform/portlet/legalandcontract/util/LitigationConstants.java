package com.sambaash.platform.portlet.legalandcontract.util;

public class LitigationConstants {
	
	public static final String PORTLET_ID = "litigationaction_WAR_LegalAndContractportlet";
	public static final String LITIGATION_ID = "litigationId";
	public static final String DB_CLMN_LITIGATION_ID = "spLitigationId";
	public static final String COUNTRY = "country";
	public static final String START_VERSION = "1.0";
	public static final String LATEST = "latest";
	
	public static final String TRADEMARKS = "trademarks";
	public static final String TRADEMARKS_ID_DD = "trademarksIddd";
	
	public static final String TRADEMARKS_ID = "trademarksId";
	public static final String DETAILS_LINK = "DetailsLink";
	
	public static final int CATEGORIES_IDS_SIZE = 6;
	
	public static final String LITIGATION = "litigation";
	public static final String CATEGORY_IDS = "categoryIds";

	// List Fields
	public static final String COUNTRY_LIST = "countryList";
	public static final String PROCEEDING_TYPE = "proceedingType";
	//public static final String FILED_AT_COUNTRY = "filedAtCountry";
	public static final String ALERT_BEFORE = "alertBefore";
	public static final String CUSTOM_LIST_1 = "customList1";
	public static final String CUSTOM_LIST_2 = "customList2";
	public static final String CUSTOM_LIST_3 = "customList3";

	// Vocabulary Id's
	public static final String COUNTRY_VOC_ID = "countryVocId";
	public static final String PROCEEDING_TYPE_VOC_ID = "proceedingTypeVocId";
	//public static final String FILED_AT_COUNTRY_VOC_ID = "filedAtCountryVocId";
	public static final String ALERT_BEFORE_VOC_ID = "alertBeforeVocId";
	public static final String CUSTOM_LIST_1_VOC_ID = "customList1VocId";
	public static final String CUSTOM_LIST_2_VOC_ID = "customList2VocId";
	public static final String CUSTOM_LIST_3_VOC_ID = "customList3VocId";
	
	
	// Text Fields
	public static final String TRADEMARK_REG_NUMBER = "trademarkRegNumber";
	public static final String FILED_BY = "filedBy";
	public static final String CLAIMS_REMARKS = "claimsRemarks";
	public static final String STATUS = "status";
	public static final String LAW_FIRM = "customField1";
	public static final String THRID_PARTY_APP_NUMBER = "customField2";
	public static final String CUSTOM_FIELD_3 = "customField3";
	
	// Date related
	public static final String FILED_ON_DATE_DAY = "filedOnDay";
	public static final String FILED_ON_DATE_MONTH = "filedOnMonth";
	public static final String FILED_ON_DATE_YEAR = "filedOnYear";
	
	public static final String RESPONSE_DEADLINE_DAY = "responseDeadlineDay";
	public static final String RESPONSE_DEADLINE_MONTH = "responseDeadlineMonth";
	public static final String RESPONSE_DEADLINE_YEAR = "responseDeadlineYear";
	
/*	public static final String ACTUAL_RESPONSE_DATE_DAY = "actualResponseDay";
	public static final String ACTUAL_RESPONSE_DATE_MONTH = "actualResponseMonth";
	public static final String ACTUAL_RESPONSE_DATE_YEAR = "actualResponseYear"; */
	
	public static final String CUSTOM_DATE_1_DAY = "customDay1";
	public static final String CUSTOM_DATE_1_MONTH= "customMonth1";
	public static final String CUSTOM_DATE_1_YEAR = "customYear1";

	public static final String CUSTOM_DATE_2_DAY = "customDay2";
	public static final String CUSTOM_DATE_2_MONTH= "customMonth2";
	public static final String CUSTOM_DATE_2_YEAR = "customYear2";
	
	public static final String CUSTOM_DATE_3_DAY = "customDay3";
	public static final String CUSTOM_DATE_3_MONTH= "customMonth3";
	public static final String CUSTOM_DATE_3_YEAR = "customYear3";
	
	
	// Date fields
	public static final String FILED_ON_DATE = "filedOn";
	public static final String RESPONSE_DEADLINE = "responseDeadline";
	public static final String RDLS = "rdls";
	public static final String RDLS_COUNT = "rdlsCount";
//	public static final String ACTUAL_RESPONSE_DATE = "actualResponse";
	public static final String CUSTOM_DATE_1 = "customDate1";
	public static final String CUSTOM_DATE_2 = "customDate2";
	public static final String CUSTOM_DATE_3 = "customDate3";
	
	
	//Misc
	public static final String ASSET_VOCABULARIES = "assetVocabularies";

	// String Formates
	public static final String DATE_FORMAT_DDMMYYYY = "dd/MM/yyyy";
	public static final String LITIGATION_DUPLICATE_ROW_FORMAT = "Contentious Proceedings exists with Trademark Application Number=%s and  Country=%s ";
	public static final String TRADEMARK_NOT_EXISS_ROW_FORMAT = "Trademark does not exists with Trademark Application Number='%s' and  Country='%s' ";
	public static final String VERSION = "version";
	public static final String ROOT_LITIGATION_ID = "rootLitigationId";
	public static final String DB_CLMN_ROOT_LITIGATION_ID = "rootSpLitigationId";
	
	public static final String ALL_SEARCH_COLUMN ="All";
	public static final String ALL_SEARCH ="searchAllLitigations";

	// Constants for Bulk Upload
	public static final String TRADEMARK_REG_NUMBER_COLUMN = "Trademark Registration Number";
	public static final String TRADEMARK_APP_NUMBER_COLUMN = "Trademark Application Number";
	public static final String COUNTRY_COLUMN = "Country";
	public static final String PROCEEDING_TYPE_COLUMN = "Proceedings";
	public static final String FILED_BY_COLUMN = "Filed By";
	public static final String FILED_ON_COLUMN = "Filed On";
//	public static final String FILED_AT_COUNTRY_COLUMN = "Filed At Country";
	public static final String CLAIMS_REMARKS_COLUMN = "Remarks";
	public static final String RESPONSE_DEADLINE_COLUMN = "Response Deadline";
	public static final String ALERT_BEFORE_COLUMN = "Alert Before";
//	public static final String ACTUAL_RESPONSE_COLUMN = "Actual Response Date";
	public static final String STATUS_COLUMN = "Status";
	public static final String LAW_FIRM_COLUMN = "Law Firm";
	public static final String THRID_PARTY_APP_NUMBER_COLUMN = "Third Party Trademark Number";
	public static final String CUSTOM_FIELD_3_COLUMN = "Custom Field3";
	public static final String CUSTOM_DATE_1_COLUMN = "Custom Date1";
	public static final String CUSTOM_DATE_2_COLUMN = "Custom Date2";
	public static final String CUSTOM_DATE_3_COLUMN = "Custom Date3";
	public static final String CUSTOM_LIST_1_COLUMN = "Custom List1";
	public static final String CUSTOM_LIST_2_COLUMN = "Custom List2";
	public static final String CUSTOM_LIST_3_COLUMN = "Custom List3";

	public static final String FILES_COLUMN = "Files";
	public static final String CONFIDENTIAL_FILES_COLUMN = "Confidential Files";
	
	//Action Keys
	public static final String ACTION_KEY_ADD_LITIGATION = "ADD_LITIGATION";
	public static final String ACTION_KEY_EDIT_LITIGATION = "EDIT_LITIGATION";
	public static final String ACTION_KEY_DELETE_LITIGATION = "DELETE_LITIGATION";
	public static final String ACTION_KEY_BULKUPLOAD_LITIGATION = "BULKUPLOAD_LITIGATION";
	public static final String ACTION_KEY_DOWNLOAD_FILE = "DOWNLOAD_FILE";

	public static final String FOLDER_NAME_ATTACHEMENTS = "litigation_attachements";
	public static final String FOLDER_NAME_CONF_ATTACHEMENTS = "litigation_conf_attachments";
	public static final String LITIGATION_ROOT_FOLDER_NAME = "ContentiousProceedings";
	public static final String LITIGATION_FOLDER_NAME_FORMAT = "Litigations_%s";

	public static final String LITIGATION_HISTORY = "agencyHistory";
	public static final String LITIGATION_HISTORY_LABEL = "History";
	public static final String SEARCH = "search";
	
	public static final String UPDATE_BY = "userName";
	public static final String UPDATE_BY_COLUMN = "Update By";
	public static final String MODIFIED_DATE = "modifiedDate";
	public static final String MODIFIED_DATE_COLUMN = "Last Updated";
	
	public static final String TRADEMARK_TEXT = "trademarkText";
	public static final String TRADEMARK_URL = "trademarkUrl";

	public static final String TRADEMARK_APPNO_COUNTRY = "Trademark Application Number / Country";
}
