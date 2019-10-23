package com.sambaash.platform.constant;

public interface PEConstantsGlobal {
	String ENTITY_ID = "entityId";
	String ENTITY_NAME = "entityName";
	String ENTITY_CLASS_ID = "entityClassId";
	String USER_ID_PROCESS = "userIdProcess";
	String PROCESS_ID = "processId";
	String USER_ID_CREATOR = "userIdCreator";
	String USER_ID_SUPERVISOR = "userIdSupervisor";
	String USER_ID_AGENT = "userIdAgent";

	String PROCESS_STATE_ID = "processStateId";
	String PROCESS_STATUS_TYPE_ID = "statusTypeId";
	String PROCESS_STATUS_TYPE_NAME = "statusTypeName";
	String PROCESS_STATUS_TYPE_NAME_LOWER = "statusTypeNameLower";
	String ENTITY_NAME_LOWER = "entityNameLower";
	String PROCESS_STATE_CONVERTED_FROM = "convertedFromProcessStateId";
	String PROCESS_STATE_CONVERTED_TO = "convertedToProcessStateId";
	String ACTIVE_STATUS = "activeStatus";
	long PROCESS_DEFAULT_ENTITY = 0;
	
	String DEAL_STAGE = "dealStageId";
	String SPECIALIZAITON = "specialization";
	String PRODUCT_COUNTRY = "productCountry";
	
	
	
	String SCREEN_NAME = "screenName";
	String EMAIL = "email";
	String FULL_NAME = "fullName";
	String EMAIL_SEARCHABLE = "emailSearchable";
	String FULL_NAME_SEARCHABLE = "fullNameSearchable";
	
	/** status constants */
	
	String STATUS_PENDING = "Pending";
	String STATUS_APPROVED = "Approved";
	String STATUS_REJECTED = "Rejected";
	String STATUS_STARTED = "Started";
	String STATUS_INPROGRESS = "InProgress";
	String STATUS_REFUNDED = "Refunded";	// For Payment refund
	String STATUS_OFFLINE = "Offline";	// For Offline Payment
	String STATUS = "status";
	String STATUS_TYPE_ID = "statusTypeId";
	
	String STAGE_NAME ="stageName";
	String STAGE_ID ="stageId";
	String STAGE_STYLE ="stageStyle";
	
	String FIELD_TYPE_TEXT = "text";
	String FIELD_TYPE_SELECT = "select";
	
	String CLOSED_STAGE_ID = "closedStageId";
	String CLOSED_STAGE_NAME = "closedStageName";
	String CLOSED_REASON_ID = "closedReasonCatgId";
	String CLOSED_DESC = "closedDesc";
	String CLOSED_STAGE_STYLE = "closedStageStyle";
	
	String SP_PARAM_NON_DEAL_STAGE_IDS= "pe.non.deal.stage.ids";
	String SP_PARAM_CLOSED_WON_STAGE_ID = "pe.closed.won.stage.id";
	String SP_PARAM_CLOSED_LOST_STAGE_ID = "pe.closed.lost.stage.id";
	String SP_PARAM_CLOSED_ENABLED_STAGE_IDS = "pe.enable.closed.stage.ids";
	String SP_PARAM_LEAD_PROCESS_ID = "pe.lead.process.id";
	String SP_PARAM_OPPORTUNITY_PROCESS_IDS = "pe.opprtunity.process.ids";
	String SP_PARAM_LEAD_CATEGORY_ID= "pe.lead.category.id";
	String SP_PARAM_OPPORTUNITY_CATEGORY_ID= "pe.opportunity.category.id";

	
	String SP_PARAM_ESIGN_API_KEY = "esign.api.key";
	String SP_PARAM_ESIGN_API_URL = "esign.api.url";
	String SP_PARAM_PE_ROOT_FOLDR = "pe.root.folder.name";
	
	String ACTION_SAVE = "save";
	String ACTION_SUBMIT = "submit";

	int ACTIVE_STATUS_ACTIVE = 1;
	int ACTIVE_STATUS_IN_ACTIVE = 2;
	
	String PARTICIPANT_DETAILS = "participantDetails";
	
	String PORTLET_ID = "SPProcessEngine_WAR_SPProcessEngineportlet";
	
}
