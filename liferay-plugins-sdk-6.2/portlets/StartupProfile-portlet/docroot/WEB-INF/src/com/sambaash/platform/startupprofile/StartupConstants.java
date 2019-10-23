package com.sambaash.platform.startupprofile;

public interface StartupConstants {
	/********************
	 * Startup Profile start
	 ********************/
	
	String PORTLET_ID = "managestartupprofile_WAR_StartupProfileportlet";
	String PORTLET_ID_STARTUP_LISTING = "startuplisting_WAR_StartupProfileportlet";
	String ACQUISITION = "Acquisition";
	String ADDRESS = "Address";
	String CATEGORY = "Category";
	String ORGANIZATION = "Organization";
	String IPO = "Ipo";
	String FUNDING_ROUND = "FundingRound";
	String IMAGE_ASSET = "ImageAsset";
	String INVESTOR_INV = "InvestorInvestment";
	String PERSON = "Person";
	String PRESS_REF = "PressReference";
	String VIDEO_ASSET = "VideoAsset";
	String WEB_PRESENCE = "WebPresence";
	String PRODUCT = "Product";
	String EMAIL = "email";
	String FILLED_BY_EMAIL = "filledByEmail";
	String FOUNDED = "foundedOn";
	String TOTAL_FUNDS = "totalFunds";
	String STAGE = "stage";
	

	String ADDRESS_STREET1 = "street_1";
	String ADDRESS_STREET2 = "street_2";
	String ADDRESS_CITY = "city";
	String ADDRESS_REGION = "region";
	String ADDRESS_COUNTRY = "country";
	String ADDRESS_POSTAL_CODE = "postal_code";

	String DESCRIPTION = "description";
	String SHORT_DESCRIPTION = "short_description";

	String TITLE = "title";
	String URL = "url";
	String NAME = "name";
	String TYPE = "type";
	String UUID = "uuid";
	String PATH = "path";
	String API_PATH = "apiPath";
	String UEN = "uen";
	
	String ACTIVE = "active";
	String BASE_ORG = "isBaseOrg";
	
	String ATO = "isATO";
	String CORPORATE_CODE = "corporateCode";
	String APPROVAL_DATE = "ApprovalDate";

	//TODO : move to db
	String CB_BASE_URL = "https://api.crunchbase.com/v/2/";
	String CB_RESOURCE_URL = "https://res.cloudinary.com/crunchbase-production";

	String ACTION = "action";
	String ACTION_SEARCH = "search";
	String ACTION_FETCH = "fetch";
	String ACTION_IMPORT = "import";
	String ACTION_SIGNUP = "signup";
	String ACTION_ORG_NAME_CHECK = "orgNameCheck";
	String ACTION_ORG_EMAIL_CHECK = "orgEmailAddressCheck";
	String ACTION_DELETE = "delete";
	String ACTION_PROFILE_COMPLETE = "profileComplete";
	String ACTION_UPLOAD_LOGO = "uploadLogo";
	String ACTION_UPLOAD_COVER = "uploadCover";
	String ACTION_PASSWORD_CHECK = "passwordCheck";
	String ACTION_ORG_UEN_CHECK = "orgUENCheck";
	
	String ORGANIZATION_NOT_FOUND = "Organization not found";
	
	String ACTION_VIEW_STARTUP = "VIEW_STARTUP";

	String ATTRIB_ORGANIZATION = "organization";
	String ATTRIB_OFFICE = "office";
	String ATTRIB_ADDRESS = "address";
	String ATTRIB_CONTACT = "contact";
	
	String ATTRIB_EMPLOYEE_INFO = "employeeInfo";
	String ATTRIB_SPATO_CONTACTS = "atoContacts";
	String ATTRIB_APPROVED_MENTORS = "mentor";
	String ATTRIB_GUIDELINES = "guidelines";
	String ATTRIB_ACCREDITATION = "accreditation";
	String ATTRIB_PRINCIPLES = "principles";
	String ATTRIB_ATO_DOCUMENT = "atoDocument";
	
	String ATTRIB_HQ = "hq";
	String ATTRIB_FILLED_BY = "fillBy";
	String ATTRIB_BOARD_MEMBER = "boardMember";
	String ATTRIB_COMPETITOR = "competitor";
	String ATTRIB_FOUNDER = "founder";
	String ATTRIB_FUNDING_ROUND = "fundingRound";
	String ATTRIB_INVESTOR_COMP = "investor";
	String ATTRIB_INVESTOR_PERSON = "investorPerson";
	String ATTRIB_INVESTORS = "investors";
	String ATTRIB_TEAM_MEMBER = "teamMember";
	String ATTRIB_QUESTIONNAIRE="questionnaire";
	//String ATTRIB_ORGS = "orgs";
	String ATTRIB_SHOW_IN_BLACKBOOK="showInBlackbook";
	String BUSINESS_DEV_MANAGER_ID="businessDevManagerId";
	String BUSINESS_DEV_MANAGER_NAME="businessDevManagerName";
	
	String ORGANIZATION_ID = "orgId";
	
	
	String VOC_ALL_VOCS = "assetVocabularies";
	

	String VOC_ORG_INCORPORATED_STATUS_ID = "orgIncorporatedVocId";
	String VOC_ORG_LIFESTAGE_ID = "orgLifecycleStageVocId";
	String VOC_ORG_RAISING_FUNDS_ID = "orgRaisingFundsVocId";
	String VOC_ORG_CATEGORY_ID = "orgCategoryVocId";
	String VOC_ORG_BENCHMARK_ID = "orgBenchmarkVocId";
	String VOC_ORG_COST_BENCHMARK_ID = "orgCostBenchmarkVocId";
	String VOC_ORG_METHODOLOGY_ID = "orgMethodologyVocId";
	String VOC_ORG_BRAND_ID = "orgBrandVocId";
	String VOC_ORG_PROJECTS_ID = "orgProjectsVocId";
	String VOC_ORG_TAGS_ID = "orgTagsVocId";
	String VOC_ORG_COLLAB_STAGE_ID = "orgCollabStageVocId";
	
	String VOC_ORG_CORPORATE_TYPE_ID = "orgCorporateTypeVocId";
	String VOC_ORG_CORPORATE_CATEGORY_ID = "orgCorporateCategoryVocId";
	String VOC_ORG_SALUTATION_ID = "orgSalutationVocId";
	
		
	String ORG_INCORPORATED_LIST = "orgIncorporatedList";
	String ORG_LIFESTAGE_LIST = "orgLifecycleStageList";
	String ORG_RAISING_FUNDS_LIST = "orgRaisingFundsList";
	String ORG_CATEGORY_LIST = "orgCategoryList";
	String ORG_BENCHMARK_LIST = "orgBenchmarkList";
	String ORG_COST_BENCHMARK_LIST = "orgCostBenchmarkList";
	String ORG_METHODOLOGY_TYPE_LIST = "orgMethodologyTypeList";
	String ORG_METHODOLOGY_SUBTYPE_LIST = "orgMethodologySubTypeList";
	String ORG_BRAND_LIST = "orgBrandList";
	String ORG_PROJECT_LIST = "orgProjectList";
	String ORG_STAGE_LIST = "orgStageList";
	String ORG_VIDEO_LINK_LIST = "orgVideoLinkList";
	String ORG_SLIDER_VIDEO_LINK_LIST = "orgSliderVideoLinkList";
	String BRAND_LIST = "brandList";
	String PROJECT_LIST = "projectList";
	String ORG_TAG_LIST = "orgTagList";

	String ORG_COLLAB_STAGE_LIST = "orgCollabStageList";

	String ORG_PIPELINE_STATUS_LIST = "pipelineStatusList";
	String ORG_BUSINESS_DEV_MANAGER_LIST = "businessDevManagerList";
	String ORG_PREV_BUSINESS_DEV_MANAGER_LIST = "prevBusinessDevManagerList";

	String ORG_CORPORATE_TYPE_LIST = "orgCorporateTypeList";
	String ORG_CORPORATE_CATEGORY_LIST = "orgCorporateCategoryList";
	String ORG_SALUTATION_LIST = "orgSalutationList";
	
	
	
	String ORG_INCORPORATED_ID = "orgIncorporatedId";
	String ORG_LIFESTAGE_ID = "orgLifecycleStageId";
	String ORG_RAISING_FUNDS_ID = "orgRaisingFundsId";
	String ORG_CATEGORY_ID = "orgCategoryId";
	String ORG_BENCHMARK_ID = "orgBenchmarkId";
	String ORG_COST_BENCHMARK_ID = "orgCostBenchmarkId";
	String ORG_METHODOLOGY_TYPE_ID = "orgMethodologyTypeId";
	String ORG_METHODOLOGY_SUBTYPE_ID = "orgMethodologySubTypeId";
	String ORG_ENABLE_MEMBERS = "orgEnableMembers";
	String ORG_ENABLE_CONTACT_NAME = "orgEnableContactName";
    String ORG_LABEL_CONTACT_NAME = "orgLabelContactName";
    String ORG_REQUIRED_CONTACT_NAME = "orgRequiredContactName";
    String ORG_ENABLE_FAX_NUMBER = "orgEnableFaxNumber";
    String ORG_REQUIRED_FAX_NUMBER = "orgRequiredFaxNumber";
    String ORG_LABEL_FAX_NUMBER = "orgLabelFaxNumber";
    String ORG_ENABLE_DESIGNATION = "orgEnableDesignation";
    String ORG_REQUIRED_DESIGNATION = "orgRequiredDesignation";
    String ORG_LABEL_DESIGNATION = "orgLabelDesignation";
    String ORG_LABEL_PIPELINE_STATUS = "orgLabelPipelineStatus";
    String ORG_ENABLE_PIPELINE_STATUS = "orgEnablePipelineStatus";
    String ORG_REQUIRED_PIPELINE_STATUS = "orgRequiredPipelineStatus";
    String ORG_LABEL_BUSINESS_DEV_MANAGER = "orgLabelBusinessDevManager";
    String ORG_ENABLE_BUSINESS_DEV_MANAGER = "orgEnableBusinessDevManager";
    String ORG_REQUIRED_BUSINESS_DEV_MANAGER = "orgRequiredBusinessDevManager";
    String ORG_REQUIRED_PREV_BUSINESS_DEV_MANAGER = "orgRequiredPrevBusinessDevManager";
    String ORG_ENABLE_PREV_BUSINESS_DEV_MANAGER = "orgEnablePrevBusinessDevManager";
    String ORG_LABEL_PREV_BUSINESS_DEV_MANAGER = "orgLabelPrevBusinessDevManager";
    String ORG_ENABLE_FIRST_LAST_NAME = "orgEnableFirstLastName";
    String ORG_REQUIRED_FIRST_LAST_NAME = "orgRequiredFirstLastName";
    String ORG_ENABLE_ATO = "orgEnableATO";
    
    
    
    
    
    String ORG_ENABLE_STARTUP_EVALUATION = "orgEnableStartupEvaluation";
    String ORG_ENABLE_CORPORATE = "orgEnableCorporate";
    String ORG_ENABLE_HEADQUATER = "orgEnableHeadquater";
    String ORG_ENABLE_PROJECTS = "orgEnableProjects";
    String ORG_ENABLE_FUNDING = "orgEnableFunding";
    String ORG_ENABLE_ADDRESS = "orgEnableAddress";
    String ORG_ENABLE_OLD_CONTACT = "orgEnableOldContact";
    String ORG_ENABLE_NEW_CONTACT = "orgEnableNewContact";
    
    
    String ORG_ENABLE_PRINCIPLE1 = "orgEnablePrinciple1";
    String ORG_ENABLE_PRINCIPLE2 = "orgEnablePrinciple2";
    String ORG_ENABLE_PRINCIPLE3 = "orgEnablePrinciple3";
    String ORG_ENABLE_PRINCIPLE4 = "orgEnablePrinciple4";
    String ORG_ENABLE_PRINCIPLE5 = "orgEnablePrinciple5";
    String ORG_ENABLE_PRINCIPLE6 = "orgEnablePrinciple6";
    
    
    
    
    
    
	
	/********************
	 * Startup Profile end
	 ********************/
	
//	String PARAM_EDIT_PROFILE = "editProfile";
//	String PARAM_CREATE_PROFILE = "createProfile";
	String PARAM_DISPLAY_PROFILE = "displayProfile";
	String PARAM_DELETE_PROFILE = "deleteProfile";
	String PARAM_USER_ID = "userId";
	String PARAM_POST_LOGIN_PROFILE = "postloginProfile";
	
	String DB_ID = "dbId";
	String FRIENDLY_URL = "friendlyUrl";
	String EDIT_FRIENDLY_URL = "editFriendlyUrl";
	String IS_PROFILE_COMPLETE = "profileComplete";
	String APPLICATION_URL = "applicationUrl";
	
	// Document Library constants
	long DL_ROOT_FOLDER_ID = 0;
	String STARTUP_FOLDERNAME = "startupProfilesNew";
//	String STARTUP_TEMP_FOLERNAME = "startupProfilesTemp";
	String LOGO_URL = "logoUrl";
	String FILE_ENTRY_ID = "fileEntryId";
	String STARTUP_FOLDER_PREFIX = "ORG_";
	String FOLDERTYPE_LOGO = "logo";
	String FOLDERTYPE_COVER = "cover";
	String FOLDERTYPE_OTHERS = "others";
	
	// Head quarter location
	String HQ_ADDRESS_ID = "hqAddressId";
	String HQ_ADDRESS = "hqAddress";
	String HQ_STREET1 = "hqStree1";
	String HQ_STREET2 = "hqStree2";
	String HQ_CITY = "hqCity";
	String HQ_REGION = "hqRegion";
	String HQ_COUNTRY = "hqCountry";
	String HQ_POSTALCODE = "hqPostalCode";
	
	//
	String ERROR_MSG = "errorMsg";
	String MSG_UPLOAD_ERROR = "Error while uploading file/files";
	String UNAUTH_MSG_CREATE = "You are not authorized to create startup profile";
	String UNAUTH_MSG_UPDATE = "You are not authorized to update startup profile";
	String UNAUTH_MSG_VIEW = "You do not have permissions to perform the requested operation, kindly contact the Admin Team";
	String UNAUTH_MSG_DELETE = "You are not authorized to delete startup profile";
	
	String SUCCESS = "success";
	String FAIL = "fail";
	
	String SP_PARAM_STARTUP_DISP = "startupDisplayPage";
	String SP_PARAM_STARTUP_CREATE = "startupCreatePage";
	String SP_PARAM_CHALLENGE_HOME = "challengesHomePage";
	String SP_PARAM_STARTUP_LISTING = "startupListingPage";
	String IFRAME_WEB_PROTOCOL = "iframe_web_protocol";
	
	
	String PARAM_SEARCH_STARTUP_EMAIL = "searchStartupEmail";
	String PARAM_SEARCH_STARTUP_NAME = "searchStartupName";
	String PARAM_SEARCH_STARTUP_LIFECYCLE = "orgLifecycleStageId";
	String PARAM_SEARCH_COUNTRY = "searchCountry";
	String PARAM_SEARCH_CATEGORY = "orgCategoryId";
	String WEBSITE = "website";
	
	// Startup Stage
	int PITCH_STAGE = 1;
	int PILOT_STAGE = 2;
	int PARTNER_STAGE = 3;
	
	// Applications
	String ORG_CHALLENGE_APPLICATIONS = "orgChallengeApplications";
	String ORG_CHALLENGE_DETAILS = "orgChallengeDetails";
	
	String ORG_ADDRESSES = "orgAddresses";
	String ORG_CONTACTS = "orgContacts";
	
	
	// Application Status
	int APPLICATION_PENDING = 0;
	int APPLICATION_REJECTED = -1;
	int APPLICATION_ACCEPTED = 1;
	int APPLICATION_KEEP_IN_VIEW = 2;
	
	String NEXT_EXPIRY_DURATION_FROM_APPROVAL = "next.expiry.duration.from.approval";
	String ADVANCE_NOTICE = "advance.notice";
	String POST_EXPIRY_NOTICE = "post.expiry.notice";
	String TEMPLATE_PATTERN = "templatePattern";
	
}