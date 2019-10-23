package com.sambaash.platform.portlet.legalandcontract.util;

public class TrademarksConstants {
	
	public static final String PORTLET_ID = "trademarksmaster_WAR_LegalAndContractportlet";
	public static final String TRADEMARKS_ID = "trademarksId";
	public static final String ROOT_TRADEMARK_ID = "rootTrademarksId";
	public static final String DB_CLMN_TRADEMARKS_ID = "spTrademarksId";
	public static final String DB_CLMN_ROOT_TRADEMARK_ID = "rootSpTrademarksId";
	public static final String AGENCY_ID = "agencyId";
	//public static final String CLASS_ID = "classId";
	public static final String AGENCY_ID_DD = "agencyIddd";
	public static final String CLASS_ID_DD = "classIddd";
	public static final String COUNTRY = "country";
	public static final String START_VERSION = "1.0";
	public static final String LATEST = "latest";
	public static final String FROM_PAGE = "fromPage";
	public static final String SEARCH = "search";
	public static final String LITIGATION_IDS = "litigationIds";
	public static final String TRADEMARK_LOGO = "trademarkLogo";
	public static final String DETAILS = "Details";
	public static final String DETAILS_LINK = "DetailsLink";
	public static final String AGENCY_DETAILS_LINK = "agencyDetailsLink";
	
	
	public static final String ALL_SEARCH_COLUMN ="All";
	public static final String ALL_SEARCH ="searchAllTrademarks";
	
	//Various actions
	public static final String ACTION_PARAM = "actionParameter";
	public static final String ACTION_PARAM_VIEW = "view";
	public static final String ACTION_PARAM_UPDATE = "update";
	public static final String ACTION_PARAM_ADD = "add";
	public static final String ACTION_PARAM_SEARCH = "search";
	public static final String ACTION_PARAM_UPLOAD = "upload";
	public static final String ACTION_PARAM_DISPLAY_ADD_TRADEMARKS = "display-add-trademarks";
	public static final String ACTION_PARAM_DISPLAY_EDIT_TRADEMARKS = "display-edit-trademarks";
	public static final String ACTION_PARAM_VIEW_AGENCY = "view-agency";
	public static final String ACTION_PARAM_VIEW_LITIGATION = "view-litigation";
	
	public static final String TRADEMARK_HISTORY = "trademarkHistory";
	public static final String TRADEMARK_HISTORY_LABEL = "Trademarks History";
	
	public static final int CATEGORIES_IDS_SIZE = 7;
	
	public static final String TRADEMARKS_MASTER = "trademarksMaster";
	public static final String CATEGORY_IDS = "categoryIds";

	// List Fields
	public static final String COUNTRY_LIST = "countryList";
	public static final String CLASS_CODE = "classCode";
	public static final String TRADEMARK_TYPE = "trademarkType";
	public static final String STATUS = "status";
	public static final String RENEWAL_ALERT_BEFORE = "renewalAlertBefore";
//	public static final String OPPOSITION_STATUS = "oppositionStatus";
	public static final String REGISTERED_OWNER_LIST = "customList1";
	public static final String CUSTOM_LIST_2 = "customList2";
	public static final String CUSTOM_LIST_3 = "customList3";

	public static final String WORD = "word";
	public static final String LOGO = "logo";
	public static final String LOGO_FILE_ENTRY_ID = "tmLogoFeId";
	
	public static final int MAX_CLASS_CODES = 33; // misc.js
	public static final String CC_P_FORMAT = "Class-%s";
	public static final String CC_P = "Class-";
	public static final String CC_PREFIX = "cCode";
	public static final String CC_SPEC_PREFIX = "cSpec";
	public static final String CLASS_CODES = "classcodes";
	public static final String CLASS_CODES_SIZE = "classcodesSize";

	// Vocabulary Id's
	public static final String COUNTRY_VOC_ID = "countryVocId";
	public static final String CLASS_CODE_VOC_ID = "classCodeVocId";
	//public static final String TRADEMARK_TYPE_VOC_ID = "trademarkTypeVocId";
	public static final String STATUS_VOC_ID = "statusVocId";
	public static final String RENEWAL_ALERT_BEFORE_VOC_ID = "renewalAlertBeforeVocId";
//	public static final String OPPOSITION_STATUS_VOC_ID = "oppositionStatusVocId";
	public static final String REGISTERED_OWNER_VOC_ID = "customList1VocId";
	public static final String CUSTOM_LIST_2_VOC_ID = "customList2VocId";
	public static final String CUSTOM_LIST_3_VOC_ID = "customList3VocId";
	
	
	// Text Fields
	public static final String REGISTRATION_NUMBER = "registrationNumber";
	public static final String CLASS_DESCRIPTION = "classDescription";
	public static final String TRADEMARK = "trademark";
	public static final String TRADEMARK_LOGO_IMG_FORMAT =  "<img alt='logo' border='2' src='%s' style=max-width:60px max-height:150px>";
	public static final String TRADEMARK_KEY = "trademark_key";

	public static final String TRADEMARK_IN_ENGLISH = "Trademark (Latin)";
	public static final String TRADEMARK_LOCALIZED = "trademarkLocalized";
	public static final String APPLICATION_NO = "applicationNo";
	public static final String REGISTERED_OWNER = "registeredOwner";
//	public static final String GOODS_SERVICES = "goodsServices";
	public static final String REMARKS = "pendingComments";
	public static final String PENDING_RENEWAL = "pendinRenewal";
	public static final String PENDING_RENEWAL_LABEL = "Pending Renewal";
	//public static final String AGENT = "agent";
//	public static final String AGENCY_REFERENCE = "agencyReference";
	public static final String LEGAL_CONF_REMARKS = "legalConfRemarks";
	public static final String ACTIVE_IN_GREDIENTS = "customField1";
	public static final String INTERNATIONAL_REG_NUM = "customField2";
	public static final String CUSTOM_FIELD_3 = "customField3";
	
	// File related
	public static final String ATTACHMENTS = "attachments";
	public static final String CONF_ATTACHMENTS = "confAttachments";

	public static final String PREV_ATTACHMENTS = "prevAttachments";
	public static final String PREV_CONF_ATTACHMENTS = "prevConfAttachments";
	
	
	// Date related
	public static final String APPLICATION_DATE_DAY = "applicationDateDay";
	public static final String APPLICATION_DATE_MONTH = "applicationDateMonth";
	public static final String APPLICATION_DATE_YEAR = "applicationDateYear";
	
	public static final String FIRST_REG_DATE_DAY = "firstRegDateDay";
	public static final String FIRST_REG_DATE_MONTH = "firstRegDateMonth";
	public static final String FIRST_REG_DATE_YEAR = "firstRegDateYear";
	
	public static final String RENEWAL_DATE_DAY = "renewalDateDay";
	public static final String RENEWAL_DATE_MONTH = "renewalDateMonth";
	public static final String RENEWAL_DATE_YEAR = "renewalDateYear";
	
	public static final String PRIORITY_DATE_DAY = "customDay1";
	public static final String PRIORITY_DATE_MONTH= "customMonth1";
	public static final String PRIORITY_DATE_YEAR = "customYear1";

	public static final String CUSTOM_DATE_2_DAY = "customDay2";
	public static final String CUSTOM_DATE_2_MONTH= "customMonth2";
	public static final String CUSTOM_DATE_2_YEAR = "customYear2";
	
	public static final String CUSTOM_DATE_3_DAY = "customDay3";
	public static final String CUSTOM_DATE_3_MONTH= "customMonth3";
	public static final String CUSTOM_DATE_3_YEAR = "customYear3";
	
	
	// Date fields
	public static final String APPLICATION_DATE = "applicationDate";
	public static final String FIRST_REG_DATE = "firstRegDate";
	public static final String EXPIRY_DATE = "renewalDate";
	public static final String PRIORITY_DATE = "customDate1";
	public static final String CUSTOM_DATE_2 = "customDate2";
	public static final String CUSTOM_DATE_3 = "customDate3";
	
	
	//Action Keys
	public static final String ACTION_KEY_ADD_TRADEMARK = "ADD_TRADEMARK";
	public static final String ACTION_KEY_EDIT_TRADEMARK = "EDIT_TRADEMARK";
	public static final String ACTION_KEY_DELETE_TRADEMARK = "DELETE_TRADEMARK";
	public static final String ACTION_KEY_BULKUPLOAD_TRADEMARK = "BULKUPLOAD_TRADEMARK";
	public static final String ACTION_KEY_DOWNLOAD_FILE = "DOWNLOAD_FILE";

	// String Formates
	public static final String DATE_FORMAT_DDMMYYYY = "dd/MM/yyyy";
	public static final String TRADEMARK_DUPLICATE_ROW_FORMAT = "Trademark exists with Trademark Number=%s and  Country=%s ";
	public static final String TRADEMARK_ALREADY_UPDATED_ROW_FORMAT = "Trademark  with Application No=%s and  Country=%s already updated in the current transaction. ";
	public static final String AGENCY_ERROR_NAME_COUNTRY = "Law Firm does not exists with Company Registration Number='%s' and Law Firm Country='%s'";
	public static final String CLASS_ERROR_NAME_COUNTRY = "Class does not exists with Class Code=%s and Class Country=%s";
	
	public static final String TRADEMARK_ROOT_FOLDER_NAME = "TrademarksFolders";
	public static final String TRADEMARK_FOLDER_NAME = "tm_%s";
	public static final String USER_UNAUTHORIZED_ON_COUNTRY = "You are not authorized to add / modify the Trademarks details for country = %s";

	public static final String FOLDER_NAME_ATTACHEMENTS = "Trademarks_attachements";
	public static final String FOLDER_NAME_CONF_ATTACHEMENTS = "Trademarks_conf_attachments";
	public static final String FOLDER_NAME_TRADEMARK_LOGOS = "Trademarks_logos";
	public static final String VERSION = "version";
	public static final String FILE_ENTRY_ID = "fileEntryId";

	public static final String REGIONAL_ROLE_NAME = "regionalRole";
	// Constants for Bulk Upload
	public static final String ATTACHMENTS_COLUMN = "Attachments";
	public static final String CONF_ATTACHMENTS_COLUMN = "Confidential Attachments" ;
	public static final String TRADEMARK_LOGO_COLUMN = "Trademarks Logo";
	public static final String TRADEMARK_LOGO_TITLE_COLUMN = "Logo Title/Trademark (Latin)";
	public static final String TRADEMARKS_COLUMN = "Trademarks";
	public static final String CONTENTIOUS_PROCEEDINGS_COLUMN = "Contentious Proceedings";
	public static final String CONTENTIOUS_PROCEEDINGS = "contentiousProceedings";
	public static final String ACTIVE_INGREDIENTS = "activeIngredients";
	public static final String UPDATE_BY = "userName";
	public static final String UPDATE_BY_COLUMN = "Update By";
	public static final String MODIFIED_DATE = "modifiedDate";
	public static final String MODIFIED_DATE_COLUMN = "Last Updated";

	public static final String REGISTRATION_NO_COLUMN = "Registration Number";
	public static final String REGISTRATION_NUMBER_COLUMN = "Registration Number";
	public static final String ACTIVE_INGREDIENTS_COLUMN = "Active Ingredients";
	public static final String REGISTRATION_NUMBER_COLUMN_1 = "Registration No";
	public static final String COUNTRY_COLUMN = "Country";
	public static final String TRADEMARK_COLUMN = "Trademark";
	public static final String TRADEMARK_TYPE_COLUMN = "Trademark Type";
	public static final String STATUS_COLUMN = "Status";
	public static final String APPLICATION_NO_COLUMN = "Application Number";
	public static final String REGISTERED_OWNER_COLUMN = "Registered Owner";
	public static final String APPLICATION_DATE_COLUMN = "Application Date";
	public static final String FIRST_REG_DATE_COLUMN = "Registration Date";
	public static final String RENEWAL_ALERT_BEFORE_COLUMN = "Renewal Alert Before";
	public static final String EXPIRY_DATE_COLUMN = "Expiry Date";
//	public static final String GOODS_SERVICES_COLUMN = "Goods Services";
//	public static final String OPPOSITION_STATUS_COLUMN = "Opposition Status";
	public static final String REMARKS_COLUMN = "Remarks";
	public static final String AGENCY_ID_COLUMN = "Agency";
	public static final String LEGAL_CONF_REMARKS_COLUMN = "Legal Confidential Remarks";
	public static final String INTL_REG_NUMBER = "Intl. Reg. Number";
	//public static final String INTL_REG_NUMBER_COLUMN = "International Registration Number";
	public static final String ACTIVE_INGREDIANTS_COLUMN = "Active Ingredients";
	public static final String INTERNATIONAL_REG_NUM_COLUMN = "International Registration Number";
	public static final String HISTORY_COLUMN = "History";
	public static final String PRIORITY_DATE_COLUMN = "Priority Date";
	public static final String CUSTOM_DATE_2_COLUMN = "Custom Date2";
	public static final String CUSTOM_DATE_3_COLUMN = "Custom Date3";
	public static final String CUSTOM_LIST_1_COLUMN = "Custom List1";
	public static final String CUSTOM_LIST_2_COLUMN = "Custom List2";
	public static final String CUSTOM_LIST_3_COLUMN = "Custom List3";
	
	public static final String AGENCY_NAME_COLUMN = "Agency Name";
	public static final String AGENCY_NUMBER_COLUMN = "Company Registration Number";
	public static final String AGENCY_COUNTRY_COLUMN = "Law Firm Country";
	public static final String CLASS_CODE_COLUMN = "Class Code";
	public static final String CLASS_COLUMN = "Class";
	public static final String TITLE_COLUMN = "Title";
//	public static final String CLASS_COUNTRY_COLUMN = "Class Country";
	public static final String CLASS_DESCRIPTION_COLUMN = "Class Specifications";

	
	
	// Workflow constants
	
	public static final long DRAFT = 1;
	public static final long APPROVED = 1;
	public static final String WORKFLOW_ENABLED = "workflowEnabled";
	
	public static final String STATUS_OPPOSED = "opposed";
	public static final String STATUS_CANCELLED = "cancelled";
	public static final String STATUS_REVOKED = "revoked";

}
