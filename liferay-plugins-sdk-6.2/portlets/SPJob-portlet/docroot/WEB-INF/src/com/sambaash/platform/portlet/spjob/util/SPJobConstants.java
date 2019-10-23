package com.sambaash.platform.portlet.spjob.util;

public class SPJobConstants {

	public static final String JOB_LOCATION_VOCABULARY_ID = "job.location.vocabulary.id";

	public static final String JOBS_DEFAULT_ADDED_PORTFOLIO_COUNT = "jobs.default.added.portfolio.count";

	public static final String POST_JOB_ACTIVE = "Active";

	public static final String POST_JOB_CLOSED = "Closed";

	public static final String POST_JOB_DRAFT = "Draft";

	public static final String POST_JOB_NEW = "New!";

	public static final String ACTION_CREATE = "ADD_JOB";

	public static final String ACTION_EDIT = "EDIT_JOB";

	public static final String ACTION_DELETE = "DELETE_JOB";

	public static final String ACTION_JOB_APPLY = "APPLY_JOB";

	public static final String ACTION_JOB_VIEW = "VIEW_JOB";

	public static final String APPLY_PORTLET_ID = "SPJobApply_WAR_SPJobportlet";

	public static final String CREATE_PORTLET_ID = "SPJobCreate_WAR_SPJobportlet";

	public interface JOBS {
		public static String JOBS_MAINFRAME_APPLY ="apply";
		public static String JOBS_MAINFRAME_POST ="post";
		public static String JOBS_MAINFRAME_NEWPOST ="newpost";
		public static String JOBS_MAINFRAME_MOREDETAILS ="moredetails";
		public static String JOBS_TEXTBOX_WIDTH = "textbox-width";
		public static String JOBS_ERROR_MESSAGE = "jobs_error";
		public static String JOBS_TYPE = "jobs.type";
		public static String JOBS_LOCATION = "jobs.location";
		public static String JOBS_YEARS_EXPERIENCE = "jobs.years.experience";
		public static String JOBS_SALARAY_CURRENCY = "jobs.salary.currency";
		public static String JOBS_SALARY_PERIOD = "jobs.salary.period";
		public static String POST_JOB_SERVICE = "jobs.servicecomponent.post";
		public static String APPLY_JOB_SERVICE = "jobs.servicecomponent.apply";
		public static String MORE_DETAILS_SERVICE = "jobs.servicecomponent.moredetails";
		public static String SHOW_APPLY_JOBS = "jobs.show.apply.jobs";
		public static String JOBS_DETAILS_URL = "jobs.more.details.url";
		public static String SHOW_JOBS_DETAIL = "jobs.show.jobs.details";
		public static String GET_PAGE_NAME_JOBS = "jobs.get.page.name";
	}

	public interface PAGE {
		public static final String FIRST = "<< First";
		public static final String FREVIOUS = "< Previous";
		public static final String NEXT = "Next >";
		public static final String LAST = "Last >>";

	}

	public interface SEARCH_TYPE {
		public static final String SEARCH_JOBS_FILTER = "searchJobsFilter";
		public static final String SEARCH_BY_KEYWORDS = "searchByKeywords";
		public static final String SEARCH_BY_LETTER = "searchByLetter";
		public static final String SEARCH_BY_COMPANY = "searchByCompany";
	}

	public interface SP_LIST_TYPE_KEY {
		public static final String JOBS_ = "";
		public static final String INDUSTRY_TYPE = "profile.industry.types";
	}

	public interface TAGNAME {
		public static final String FILTER_JOBS ="Filter jobs";
		public static final String SEARCH_BY_KEYWORDS ="Search by keywords";
		public static final String SEARCH_BY_COMPANY ="Search by company";
		public static final String APPLY_FOR_JOB = "Apply For Job";
		public static final String Portfolio_FOR_JOB = "Portfolio For Job";
		public static final String POST_JOB_FILE = "Post job";
		public static final String POST_JOB = "Step 1: Job details";
		public static final String POST_JOB_VIEW = "Step :2 Preview";
		public static final String POST_JOB_CONFIRM = "Step 3:Confirm";
		public static final String POST_JOB_DRAFT = "Draft job";
		public static final String APPLY_JOB_CONFIRM = "Confirm Apply Job";
		public static final String POST_JOB_FAILED = "Post job failed";
		public static final String APPLY_JOB_FAILED = "Apply job failed";
	}

	public interface UPLOAD {
		public static String IMAGE_MAX_HEIGHT ="image.max.height";
		public static String IMAGE_MAX_WIDTH ="image.max.width";
		public static String IMAGE_UPLOAD_LOCATION ="image.upload.location";
	}

}