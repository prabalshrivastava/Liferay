package com.sambaash.platform.portlet.socialprofile.util;

public class ProfileConstants {

	public static final String ERROR_MSG = "errorMsg";

	public static final String UNAUTH_MSG_VIEW = "You dont have permissions to perform requested operation";

	public static final String ID = "field_id";
	public static final String MULTI_INSTANCE = "multi_instance";
	public static final String EMAIL_ADDRESS = "emailAddress";
	public static final String SECTION_ID = "section_id";
	public static final String VALUES = "values";
	public static final String WORKHISTORY = "workhistory";

	public static final String GENDER = "gender";
	public static final String GENDER_MALE = "male";

	public static final String HIGHEST_EDUCATION = "employment_status_13";

	public static final String EMPLOYMENT_STATUS = "employment_status_13";
	
	
	public interface Fields_Constants {

		public static final String LOCATION = "location";
		public static final String ABOUT = "about";
		public static final String SKILLS_QUALIFICATION = "skillsQualification";
		public static final String TRAINING_EDUCATION = "trainingEducation";
		public static final String TITLE = "title";
		public static final String INTEREST = "interest";
		public static final String HONORS = "honors";
		public static final String GROUP_ASSOCIATION = "groupAssociation";
		public static final String FIRST_NAME = "firstName";
		public static final String LAST_NAME = "lastName";
		public static final String MIDDLE_NAME = "middleName";
		public static final String FULL_NAME = "fullName";
		public static final String EMAIL_ADDRESS = "emailAddress";
		public static final String PORTRAIT_ID = "portraitId";
		public static final String USER_REGISTRATION_TYPE = "userRegistrationType";
		public static final String CREATE_DATE = "createDate";
		public static final String SCREENNAME = "screenName";
		public static final String ACTIVE = "active";
		public static final String USER_STATUS = "userStatus";
		public static final String USER_REGISTRATION_STATUS = "userRegistrationStatus";
		public static final String PROFILE_VIEW_COUNT = "profileViewCount";
		public static final String MEMBERSHIP_PACKAGE = "membershipPackage";

		public static final String FUNCTIONAL_GROUP = "functionalGroup";
		public static final String JOB_ROLE = "jobRole";
		public static final String CERTIFICATE = "certificate";
		public static final String COMPETENCY = "competency";

	}

	public interface PROFILE_VIEW_COUNT_INCREASE_MODEL {
		public static final String DAILY = "daily";
		public static final String WEEKLY = "weekly";
		public static final String MONTHLY = "monthly";
		public static final String YEARLY = "yearly";
	}

	public interface SP_LIST_TYPE_KEY {
		public static final String PROFILE_COMPANY_SIZE = "company.size";
		public static final String PROFILE_INDUSTRY_TYPE = "profile.industry.types";
		public static final String PROFILE_MESSENGER_TYPE = "messenger.type";
	}

	public interface USER_PROFILE {
		public static final String DEFAULT_COMMUNITY_NAME = "";
		public static final String XSLNAMES = "profile.xsl.names";
		public static final String RESOURCE_BUNDLE_NAME = "content/Language";
		public static final String RESOURCE_BUNDLE_FIELDS = "fields";
		public static final String XML_PATH = "/xml/";
		public static final String XSL_PATH = "/xsl/";
		public static final String XSL_FILE_EXT = ".xsl";
		public static final String FIELD_TYPES = "socialprofile.field.types";// "TextField,TextArea,CKEditor";
		public static final String VALIDATION_TYPES = "socialprofile.validation.types";// "0-None,1-Integer,2-AlphaNumeric,3-Url,4-Phone,5-Email,6-String";
		public static final String OVERLAPPING_TOKEN = "socialprofile.workhistory.overlapping.token";
		public static final String PORTLET_ID = "UserProfile_WAR_UserProfileportlet";
		public static final String SEARCHABLE_FIELDS = "userprofile.system.searchable.fields";
		public static final String INDEXABLE_FIELDS = "userprofile.system.indexable.fields";
	}

	public interface XSL_NAME {
		public static final String PERSONAL_INFO_FIELDS = "personal.info.fields";
		public static final String BASIC_INFO_FIELDS = "basic.info.fields";
		public static final String ABAILABILITY_INFO_FIELDS = "availability.info.fields";
		public static final String CONTACT_INFO_FIELDS = "contact.info.fields";
		public static final String NETWORK_INFO_FIELDS = "network.info.fields";
		public static final String WORKHISTORY_FIELDS = "workhistory.fields";
	}
	
}