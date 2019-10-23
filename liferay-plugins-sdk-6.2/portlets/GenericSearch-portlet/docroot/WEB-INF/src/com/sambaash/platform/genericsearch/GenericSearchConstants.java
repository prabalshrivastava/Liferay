package com.sambaash.platform.genericsearch;

public interface GenericSearchConstants {
	String PREF_ENABLED_COMPONENTS = "generic-search-components";
	String PREF_ENABLED_EMS_COMPONENTS = "generic-search-emscomponents";
	String PREF_ITEMS_PER_PAGE = "items-per-page";
	String RESULT_TITLE = "title-for-result-listing";
	String LOAD_MORE_TEXT = "load-more-text";
	String PREF_RESULTS_ORIENTATION = "results-orientation";
	String PREF_COMP_FILTERING = "component-filtering";
	String PREF_DATE_FILTERING = "date-filtering";
	String PREF_DATE_FILTERING_FIELD = "date-filtering-field";
	String PREF_SORT_FILTERING = "sort-filtering";
	String PREF_CLEAR_FILTERS_TEXTSEARCH = "clear-filters-on-textsearch";
	String PREF_FREE_TEXT_SEARCH = "free-text-search";
	String PREF_HIDE_FILTERS = "hide-filters";
	String PREF_HIDE_EXPORTS = "hide-exports";
	String PREF_ADMIN_EXPORTS = "admin-exports";
	String PREF_DISABLE_UNWANTED_FILTERS = "disable-unwanted-filters";
	String PREF_DISABLE_TEXT_SEARCH = "disable-text-search";
	String PREF_FILTER_PLACEMENT = "filter-placement";
	String PREF_FILTER_LABEL = "filter-label";
	String PREF_EXPORTS = "exports-fields-";
	String PREF_CUSTOM_COLOR_MAP = "custom-color-map";
	String PREF_HIDE_FAVOURITES = "hide-favourites";
	String PREF_ENABLED_ROLES = "generic-search-favourites-role";
	
	String RESP_MSG = "respMsg";
	String MSG_UNAUTH = "You do not have permissions to perform the requested operation, kindly contact the Foundry Team";
	String MSG_ERROR = "Error occured while searching!";
	String MSG_NO_RESULTS = "No Results";

	String ATTRIB_SEARCH_PAGE = "pageNo";
	String ATTRIB_SORT_BY = "field";
	String ATTRIB_SORT_TYPE = "fieldType";
	String ATTRIB_SORT_ORDER = "order";
	String ATTRIB_RESULT_LIST = "generic-search-result-list";
	String ATTRIB_RESULT_MAP = "generic-search-result-map";
	String ATTRIB_RESULT_TEMPLATE_ID = "portletDisplayDDMTemplateId";
	String ATTRIB_URL = "url";
	String ATTRIB_CONFIG_OBJ = "configuration-obj";
	String ATTRIB_SORT_PARAMS = "sortParams";
	String ATTRIB_SEARCH_ITEMS = "searchItems";
	String ATTRIB_USER_SEARCH_RESPONSE = "usrsearchresponse";
	
	String PARAM_LOAD_OBJECTS = "loadObject";
	String PARAM_NODE_IDS = "nodeIds";
	
	String DEFAULT_FILTER_LABEL = "Filters";
	String DEFAULT_CUSTOM_COLOR_MAP = "{}";

	String KEY_COMPONENT = "gsf-component";
	String KEY_COMPONENT_CLASS = "gsf-component-class";
	String KEY_TYPE = "gsf-type";
	String KEY_OPER = "gsf-opr";
	// for field name
	String KEY_TYPE_KEY = "gsf-type-key";
	String KEY_SECTION_TYPE_KEY = "gsf-section-type-key";
	String KEY_VALUE = "gsf-value";
	String KEY_FILTER_ID = "gsf-filter-id";
	
	int PERMISSIONTYPE_PRIVATE = 1;
	int PERMISSIONTYPE_GLOBAL = 2;
	
	String PARTIAL_MATCH = "partial";
	String EXACT_MATCH = "exact";
	
	public static final String SEARCH_VOCABULARY_NAME = "vocName";
	public static final String SEARCH_CATEGORY_NAME = "catName";
}