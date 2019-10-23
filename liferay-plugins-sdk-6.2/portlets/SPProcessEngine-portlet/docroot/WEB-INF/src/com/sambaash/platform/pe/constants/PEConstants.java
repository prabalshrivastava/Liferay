package com.sambaash.platform.pe.constants;

public interface PEConstants {

	String PORTLET_ID = "SPProcessEngine_WAR_SPProcessEngineportlet";
	String PORTLET_ID_PROCESS_STATE = "processstatelisting_WAR_SPProcessEngineportlet";
	String PORTLET_NAME_PROCESS_STATE_LISTING = "process-state-listing";
	String NODE_ID = "nodeId";
	String ERROR = "error";
	
	String FILTER_TYPE_AND = "AND";
	String FILTER_TYPE_OR = "OR";
	
	

	/** types used in conditions */
	String TYPE_STRING = "string";
	String TYPE_NUMBER = "number";
	String TYPE_DATE = "date";
	String TYPE_BOOLEAN = "boolean";

	/** String operations supported by rule engine */

	String OPERATION_EQUALS = "equals";
	String OPERATION_NOT_EQUALS = "notEquals";

	String OPERATION_CONTAINS = "contains";
	String OPERATION_NOT_CONTAINS = "notContains";

	String OPERATION_STARTS_WITH = "startsWith";
	String OPERATION_IN= "in";
	String OPERATION_NOT_IN= "notin";
	String OPERATION_IS_EMPTY = "isEmpty";
	String OPERATION_IS_NOT_EMPTY = "isNotEmpty";

	/** Number/Date related */
	String OPERATION_GREATER_THAN = "greaterThan";
	String OPERATION_LESS_THAN = "lessThan";
	String OPERATION_LESS_THAN_OR_EQUAL = "lte";
	String OPERATION_GREATER_THAN_OR_EQUAL = "gte";
	

	/** rule types */
	String RULE_SIMPLE = "simple";
	String RULE_COMPLEX = "complex";

	int RULE_ID_DEFAULT = -1;

	/** Attributes */

	String ATTR_OUTPUT = "output";
	String ATTR_OUTPUT_VALIDATION = "validationOutput";
	String ATTR_PROCESS_STATE = "processState";
	String ATTR_CLASS_NAME_ID = "classNameId";
	String ATTR_CLASS_PK = "classPK";
	String ATTR_PROCESS_ID = "processId";
	String ATTR_PROCESS_STATE_ID = "processStateId";
	String ATTR_DATA_SOURCE = "datasource";

	/** Parameters */

	String PARAM_ACTION = "action";
	String PARAM_ACTION_TYPE = "actionType";
	String PARAM_FORM_DATA_SUBMITTED = "formData";
	String PARAM_CLASS_NAME_ID = "classNameId";
	String PARAM_CLASS_PK = "classPK";
	String PARAM_CLASS_PK_SAVED_CODE = "classPKSavedCode";
	String PARAM_PROCESS_ID = "processId";
	String PARAM_PROCESS_STATE_ID = "processStateId";
	String PARAM_STATUS_TYPE_ID = "statusTypeId";
	String PARAM_TEST_KEY="testKey";
	String PARAM_PACKAGE_ID="packageId";
	String PARAM_SIGNER_ID="signerId";
	

	/** constans */
	long UNKNOWN_PROCESS_STATE_ID = 0;

	/** preferences **/
	String PREF_PROCESS_IDS = "processIds";
	String PREF_USER_TYPE = "userType";
	String PREF_STAGE_IDS = "stageIds";
	String PREF_DEAL_STATUS_IDS = "dealStatusIds";

	/** keys */
	String KEY_ERROR = "error";
	String KEY_PORTAL_URL = "portalUrl";
	String KEY_SIGNIN_URL = "signInUrl";

	String USER_TYPE_APPLICANT = "normal";
	String USER_TYPE_APPROVER = "approver";
	String USER_TYPE_AGENT = "agent";
	String USER_TYPE_SUPERVISOR = "supervisor";

	/** Pre defined variables; used to indicate some object or property */
	String PRE_DEF_PROCESS_USER_EMAIL = "PROCESS_USER_EMAIL";

	
	/** Preferences */
	String PREF_MOBILE_SUPPORT  = "mobileSupport";
	String PREF_DISPLAY_ACTIVE_STATUS  = "displayActiveStatusDD";
	String PREF_DISPLAY_ENTITY_FILTER = "displayEntityDD";
	String PREF_DISPLAY_CHANGE_STATUS = "changeStatus";
	String PREF_STUDENT_DASHBOARD_APPLICATION_STATUS = "studentDashboardApplicationStatusIds";
	
	/** Status constants.. */

	int STATUS_PUBLISHED = 1;
	int STATUS_DRAFT = 2;

	String COLUMN_PE_PROCESS_STATE_ID = "spPEProcessStateId";
	String COLUMN_TYPE = "type";
	String COLUMN_CREATE_DATE = "createDate";
	String COLUMN_STATUS_NAME = "statusName";
	String COLUMN_SEQ_NO = "seqNo";
	String COLUMN_ENTITY_ID = "entityId";
	String COLUMN_ENTITY_CLASS_ID = "entityClassId";
	String COLUMN_PROCESS_ID = "spPEProcessId";
	
	
	
	
	String TABLE_PROCESS_AUDIT = "SPPEProcessAudit";

	String TABLE_PROCESS_STATUS_TYPE = "SPPEProcessStatusType";
	
	String ACTION_EXPORT = "EXPORT_SUBMSSIONS";
	String ACTION_ASSIGN = "ASSIGN";
	String ACTION_CLOSE = "STAGE_CLOSE";
	String ACTION_CHANGE_STATUS = "STATUS_CHANGE";
	String ACTION_DISPLAY_SEARCH_SECTION = "SEARCH_SECTION";
	String ACTION_BULK_UPLOAD = "BULK_UPLOAD";
	
	String FIELD_SIGNED_IN = "signedIn";
	String FIELD_ENTITY_ID  = "entityId";
	String FIELD_FIRST_LOGIN = "firstLogin";
	
	
	String RULE_COMPONENT_TYPE_ENTITY ="entity";

	String RECIPIENT_USER = "user";
	String RECIPIENT_OFFICER = "officer";
	String RECIPIENT_ASSIGNED_SALES_AGENT = "assignedSalesAgent";
	String RECIPIENT_ASSIGNED_SUPERVISOR = "assignedSupervisor";
	String CC_ASSIGNED_SALES_AGENT = "ccAssignedSalesAgent";
	String CC_ASSIGNED_SUPERVISOR = "ccAssignedSupervisor";
	String CC_EMAIL_ADDRESS = "ccEmailAddress";
	String RECIPIENT_SALES_AGENT_ROLE = "salesAgentRole";
	String RECIPIENT_SUPERVISOR_ROLE = "supervisorRole";
	
	String RECIPIENT_TRAINING_PRINCIPAL_ROLE = "trainingPrincipalRole";
	String RECIPIENT_SECONDAY_CONTACT_ROLE = "secondaryContactRole";
	String RECIPIENT_MENTOR_ROLE = "mentorRole";
	
	// Indication for approvers defined in process table. They can approve any status tye in the process
	String RECIPIENT_GLOBAL_APPROVERS = "allStatusTypesApprovers";
	
	int LOCKED = 1;
	int UNLOCKED = 0;
	
	long  DEFAULT_NODE_ID = 0l;
	//
	long  DEFAULT_STATUS_TYPE_ID = 0;
	
	// Actions
	
	String ACTION_DOWNLOAD_FROM_TEMP = "downloadFromTemp";
	
	/** spparameters**/
	
	String CAREER_ADVISORY_DOMAIN_AREAS = "career.advisory.domain.areas";
	String CAREER_ADVISORY_USER_MAIL_TEMPLATE = "career.advisory.user.mail.template";
	String CAREER_ADVISORY_EVENTS_LIST_TEMPLATE = "career.advisory.events.list.template";
	String SP_PARAM_SELF_SPONSORED_CATEGORY_ID = "self.sponsored.category.id";
	String SP_PARAM_PREVIEW_LIST_KEY = "preview.list.key";
	String SP_PARAM_CUSTOM_LIST_KEY = "custom.list.key";
	
	String SP_PARAM_PENDING_STAGE_ID = "pe.pending.stage.id";
	
	String EDIT_CONDITION_STATUS_TYPE = "Status Type";
	
	String STORAGE_ID="storageId";
	String PARAM_SUPPRESS_MAIL_NOTIFICATIONS = "suppressMailNotifications";
	
	boolean ACTION_DONE = true;
	boolean ACTION_NOT_DONE = false;

	String SHOW_PROCESS_PROGRESS = "showProcessProgress";

	String PERSONA_VOCABULARY_ID ="persona.vocabulary.id";
	String PERSONA_SUB_PERSONA_FIELD_NAMES ="persona.subpersona.field.names";
	String SP_PARAM_STAGES = "pe.stages";
	String SP_PARAM_DEAL_STATUS = "pe.deal.status";
	
	String SP_PARAM_PE_PEOCESS_FORM_DATA = "pe.process.form.search";
	String SP_PARAM_PE_PEOCESS_FORM_LIST_URL = "pe.process.form.list.url";
	String ENABLE_TEMP_STORAGE_VALIDATION = "enableTempStorageValidation";
	String ENABLE_TEMP_STORAGE_VALIDATION_STEP_NUMBER = "enableTempStorageValidationStepNumber";
	
	String PE_REPROCESSING = "_PE_REPROCESSING_";
	String PE_PRE_REPROCESSING_NODE = "_PE_PRE_REPROCESSING_NODE_";
	String REPROCESSING_STOPPED_MSG = "Reprocessing of next node is not allowed. Resume by clicking reprocessable step.";
	
	String RULE_VERSION_1 = "1";
	String RULE_VERSION_2 = "2";
	
	String JOB_LISTENER_PACKAGE = "com.sambaash.platform.pe.handlers.job.listener";
	String DEFAULT_JOB_LISTENER = "ScheduledMailJob";
	
	String USER_ID = "userId";
	String SITE_ID = "siteId";
	
	String ORGANIZATION_ID ="organizationId";
	String ACTIVITY = "activity";
	
	String RENEWAL_URL = "renewalUrl";
	String RENEWAL_STATUS = "renewalStatus";
	String CURRENT_TEMPLATE = "currentTemplate";
	String EXPIRY_DATE = "expiryDate";
	String TITLE = "title";
	
}