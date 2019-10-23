package com.sambaash.platform.portlet.spmail.util;

public interface MailConst {
	String CRONE_TYPE_ONE_TIME = "oneTime";
	String CRONE_TYPE_DAILY = "daily";
	String CRONE_TYPE_WEEKLY = "weekly";
	String CRONE_TYPE_MONTHLY = "monthly";
	String CRONE_TYPE_SEMI_YEARLY = "semiAnnual";
	String CRONE_TYPE_YEARLY = "yearly";

	// every day at one'O clock,5th min, 5h sec
	String CRONE_EXP_DAILY = "%s %s %s * * ?";
	String CRONE_EXP_WEEKLY = "%s %s %s ? * SUN";
	String CRONE_EXP_MONTHLY = "%s %s %s ? * 1L";
	String CRONE_EXP_SEMI_ANNUAL = "%s %s %s ? 1/6 1L";
	String CRONE_EXP_YEARLY = "%s %s %s ? 1 1L *";

	String DELAY_MINS = "mins";
	String DELAY_HOURS = "hours";
	String DELAY_DAYS = "days";
	String DELAY_WEEKS = "weeks";
	String DELAY_MONTHS = "months";

	// campaign types
	String CAMPAIGN_TYPE_AUTOMATED = "automated";
	String CAMPAIGN_TYPE_SUBSCRIPTION = "subscription";

	String COMPANY_ID = "companyId";
	String SCOPE_GROUP_ID = "scopeGroupId";
	String USER_ID = "userId";
	String SP_MAIL_TYPE = "spMailType";
	String CAMPAIGN_ID = "campaignId";
	String SUBSCRIBER_ID = "subscriberId";

	String FORMAT_JOB_ID_CAMPAIGN_AUTOMATED = "%s:%s-campaign";
	String FORMAT_JOB_ID_CAMPAIGN_SUBSCRIPTION = "%s:%s_%s-campaign";

	String FLAG_SUBSCRIPTION_CAMPAIGN = "S";
	int SEQ_NO_START = 10000;

	String[] CRONE_TYPES = { CRONE_TYPE_ONE_TIME, CRONE_TYPE_DAILY, CRONE_TYPE_WEEKLY, CRONE_TYPE_MONTHLY,
			CRONE_TYPE_SEMI_YEARLY, CRONE_TYPE_YEARLY };

}
