package com.sambaash.platform.spchallenge.helper;

public interface SPChallengeConstants {

	// dropdowns
	String VOC_APPLICANT_TYPE_ID = "applicantTypeVocId";
	String VOC_CHALLENGE_CATEGORY_ID = "challengeCategoryVocId";
	String VOC_CHALLENGE_TYPE_ID = "challengeTypeVocId";
	String VOC_REGION_TYPE_ID = "regionTypeVocId";
	String VOC_CHALLENGE_COLLAB_TYPE_ID = "challengeCollabVocId";
	String VOC_ITEMS_PER_PAGE = "itemsPerPage";
	String VOC_VIEW_MODE = "viewMode";
	String VOC_VIEW_SLIDER = "Slider";
	String VOC_VIEW_LIST = "List";
	
	String VOC_ORG_INCORPORATED_STATUS_ID = "orgIncorporatedVocId";
	String VOC_ORG_LIFESTAGE_ID = "orgLifecycleStageVocId";
	String VOC_ORG_RAISING_FUNDS_ID = "orgRaisingFundsVocId";
	String VOC_ORG_CATEGORY_ID = "orgCategoryVocId";
	String VOC_ORG_BENCHMARK_ID = "orgBenchmarkVocId";
	String VOC_ORG_COST_BENCHMARK_ID = "orgCostBenchmarkVocId";
	String VOC_BRAND_ID = "brandVocId";
	
	String VOC_ALL_VOCS = "assetVocabularies";
	
	String APPLICANT_TYPES_LIST = "applicantTypesList";
	String CHALLENGE_CATEGORY_LIST = "challengeCategoryList";
	String CHALLENGE_TYPE_LIST = "challengeTypeList";
	String REGION_LIST = "regionList";
	
	String ORG_INCORPORATED_ID = "orgIncorporatedId";
	String ORG_LIFESTAGE_ID = "orgLifecycleStageId";
	String ORG_RAISING_FUNDS_ID = "orgRaisingFundsId";
	String ORG_CATEGORY_ID = "orgCategoryId";
	String ORG_BENCHMARK_ID = "orgBenchmarkId";
	String ORG_COST_BENCHMARK_ID = "orgCostBenchmarkId";
	
	String ORG_INCORPORATED_LIST = "orgIncorporatedList";
	String ORG_LIFESTAGE_LIST = "orgLifecycleStageList";
	String ORG_RAISING_FUNDS_LIST = "orgRaisingFundsList";
	String ORG_CATEGORY_LIST = "orgCategoryList";
	String ORG_BENCHMARK_LIST = "orgBenchmarkList";
	String ORG_COST_BENCHMARK_LIST = "orgCostBenchmarkList";
	String ORG_BRAND_LIST = "orgBrandList";

	String COLLAB_TYPE_LIST = "collabTypeList";
	
//	String APPLICANT_TYPES_ID = "applicantTypesId";
//	String CHALLENGE_CATEGORY_ID = "challengeCategoryId";
//	String CHALLENGE_TYPE_ID = "challengeTypeId";
//	String REGION_ID = "regionId";
//	String COLLAB_TYPE_ID = "collabTypeId";
	
	String ACTION_ADD_CHALLENGE = "ADD_CHALLENGE";
	String ACTION_EDIT_CHALLENGE = "EDIT_CHALLENGE";
	String ACTION_DELETE_CHALLENGE = "DELETE_CHALLENGE";
	String ACTION_VIEW_APPLICATION = "VIEW_APPLICATION";
	
	// attributes
	String ATTRIB_CHALLENGE_APPLICANT = "applicant";
	String ATTRIB_CHALLENGE = "challenge";
	String ATTRIB_CHALLENGES = "challenges";
	
	String ATTRIB_ORGANIZATION = "organization";
	String ATTRIB_OFFICE = "office";
	String ATTRIB_HQ = "hq";
	String ATTRIB_FILLED_BY = "fillBy";
	String ATTRIB_BOARD_MEMBER = "boardMember";
	String ATTRIB_COMPETITOR = "competitor";
	String ATTRIB_FOUNDER = "founder";
	String ATTRIB_FUNDING_ROUND = "fundingRound";
	String ATTRIB_INVESTOR_COMP = "investor";
	String ATTRIB_INVESTOR_PERSON = "investorPerson";
	String ATTRIB_INVESTORS = "investors";
	
	String ACTION = "action";
	String ACTION_CHLG_APPLICATION_SAVE = "saveBriefApplication";
	String ACTION_CHLG_SAVE = "addChallenge";
	String ACTION_FILTER_RESULTS = "filterResults";
	String ACTION_GET_SIMILAR_CHALLENGES = "getSimilarChallenges";
	String ACTION_UPLOAD_LOGO = "uploadLogo";
	String ACTION_MAIL_ID_SUGGESTIONS = "notefToSuggestions";
	String ACTION_SCOUT_SUGGESTIONS = "scoutSuggestions";
	String ACTION_GET_APPLY_INFOS = "getChallengeApplyInfos";
	String ACTION_REMOVE_LOGO = "removeLogo";
	String ACTION_SET_APPLICANT_STATUS = "setApplicantStatus";
	String ACTION_SET_APPLICATION_STATUS = "setApplicationStatus";
	String ACTION_RESPOND_TO_APPLICANTS = "respondAction";
	
	String CHALLENGE_ID = "spChallengeId";
	String CHALLENGE_APPLICANT_ID = "spChallengeApplicantId";
	String ORGANIZATION_ID = "orgId";
	String ORGANIZATION_NAME = "orgName";
	String ORGANIZATION_NAME_LOWER = "orgNameLower";
	
	String PORTLET_ID = "spchallengeaction_WAR_SPChallengeportlet";
	String APPLICANT_PORTLET_ID = "spchallengeapplicantaction_WAR_SPChallengeportlet";
	
	String FRIENDLY_URL = "friendlyUrl";
	String FRIENDLY_EDIT_URL = "editfriendlyUrl";
	String FRIENDLY_CREATE_URL = "createFriendlyUrl";
	
	// document fields
	String NAME = "name";
	String OPEN_TO = "openTo";
	String TYPE = "type";
	String BACKGROUND = "background";
	String DESCRIPTION = "description";
	String SCOPE = "scope";
	String BENEFIT = "benefit";
	String BUDGET = "budget";
	String EXTRAS = "extras";
	// Startdata , enddate and active fields has been hard coded in SearchUtils.getActiveOnlyChallengesQuery.
	// so if there is any change in these two fields, then the above mehtod should be modified accordingly
	String START_DATE = "startDate";
	String END_DATE = "endDate";
	String APPLY_BY = "applyBy";
	String CUSTOM_STATUS1= "customStatus1";
	String CUSTOM_STATUS2= "customStatus2";
	// See the comment for startdate field when modifying below field "active".
	String ACTIVE = "active";
	String DRAFT = "draft";
	String APPLICANT_REF_ID = "applicantRefId";
	String CHALLENGE_OWNER = "challengeOwner";
	String APPLICATION_STATUS = "applicationStatus";
	String NOTIFICATION_STATUS = "notificationStatus";
	String ORGANIZATION_OWNER = "organizationOwner";
	
	String Q1 = "q1";
	String Q2 = "q2";
	String Q3 = "q3";
	String Q4 = "q4";
	String Q5 = "q5";
	String Q6 = "q6";
	String Q7 = "q7";
	String Q8 = "q8";
	String Q9 = "q9";
	String Q10 = "q10";
	String Q11 = "q11";
	String Q12 = "q12";
	String Q13 = "q13";
	String Q14 = "q14";
	String Q15 = "q15";
	String Q16 = "q16";
	String Q17 = "q17";
	String Q18 = "q18";
	String Q19 = "q19";
	String Q20 = "q20";
	
	String PARAM_SEARCH_START_INDEX = "startIndex";
	String PARAM_SEARCH_PAGE_NO = "pageNo";
	String PARAM_SEARCH_ITEMS = "searchItems";
	String PARAM_SEARCH_TYPE = "searchType";
	String RESULTS = "searchResults";
	String TOTAL_DOCS = "total";
	String MORE_DOCS_AVAILABLE = "moreDocsAvailable";
	String ITEMS = "items";
	String CHALLENGE_NAME = "challengeName";
	
	String PARAM_CREATE_CHALLENGE = "createChallenge";
	String PARAM_EDIT_CHALLENGE = "editChallenge";
	String PARAM_DISPLAY_CHALLENGE = "displayChallenge";
	String PARAM_APPLY_TO_CHALLENGE = "applyToChallenge";
	
	String PARAM_APPLY_CHALLENGE = "applyChallenge";
	String PARAM_VIEW_APPLICATION = "viewApplication";
	String PARAM_EDIT_APPLICATION = "editApplication";
	
	// Document Library constants
	long DL_ROOT_FOLDER_ID = 0;
	String CHALLENGES_FOLERNAME = "Challenges";
	String CHALLENGES_TEMP_FOLERNAME = "ChallengesTemp";
	String LOGO_URL = "logoUrl";
	String CHALLENGE_LOGO_URL = "challengeLogoUrl";
	String FILE_ENTRY_ID = "fileEntryId";
	
	String ERROR_MSG = "errorMsg";
	String MSG_UNAUTH = "You do not have permissions to perform the requested operation, kindly contact the Admin Team";
	String MSG_ORG_INCOMPLETE = "Startup profile is incomplete. You can not use incomplete profile to apply challenge.";
	
	String SUCCESS = "success";
	String FAIL = "fail";
	
	String SP_PARAM_STARTUP_DISP = "startupDisplayPage";
	String SP_PARAM_STARTUP_CREATE = "startupCreatePage";
	String SP_PARAM_CHALLENGE_HOME = "challengesHomePage";
	String SP_PARAM_BRIEF_TEMPLATE_URI = "briefTemplateUri";
	String SP_PARAM_CHALLENGE_LIST_HOME = "challengesListPage";
	
	
	String PARAM_SEARCH_STARTUP_NAME = "searchStartupName";
	String PARAM_SEARCH_CHALLENGE = "searchChallenge";
	
	String MSG_LOGO_ERROR = "Error while uploading the logo";
	
	/**  Challenge collaberation type propertis */
	String COLLAB_TYPE_PREFIX = "challengeCollab_"; 
	String COLLAB_TYPE_INTERNAL = "internal";
	String COLLAB_TYPE_EXTERRNAL = "external";
	String POSITION_INDEX = "posIndex";
	
	String SCOUT_ROLE_NAME = "SCOUT";

	// Application Status
	int APPLICATION_PENDING = 0;
	int APPLICATION_REJECTED = -1;
	int APPLICATION_ACCEPTED = 1;
	int APPLICATION_KEEP_IN_VIEW = 2;
	
	// Notification Status
	int NOTIFICATION_PENDING = 0;
	int NOTIFICATION_FAILED = -1;
	int NOTIFICATION_SUCCESS = 1;
}
