package com.sambaash.platform.announcement.helper;

import java.awt.Color;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.search.StringQueryFactoryUtil;
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;
import com.liferay.portal.kernel.search.TermRangeQuery;
import com.liferay.portal.kernel.search.TermRangeQueryFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.platform.announcement.config.GenericSearchConfig;
import com.sambaash.platform.announcement.config.GenericSearchConstants;
import com.sambaash.platform.announcement.config.GenericSearchFilter;
import com.sambaash.platform.srv.genericsearch.model.GSFavourite;

public class GenericSearchHelper {

	public static final String DATE_FORMAT_PATTERN = "yyyyMMddHHmmss";
	private static final short ROW_START = 3;
	private static final short COL_START = 1;
	private static final int MAX_WIDTH = 40 * 256;
	private static final int MIN_WIDTH = 6 * 256;
	public static final int DATE_RANGE_HACK_YEARS = 10;

	public GenericSearchConfig parseConfiguration(PortletPreferences preferences) {
		GenericSearchConfig config = new GenericSearchConfig();
		config.setItemsPerPage(
				GetterUtil.getInteger(preferences.getValue(GenericSearchConstants.PREF_ITEMS_PER_PAGE, "3"), 3));
		config.setEnabledComponentFilters(
				GetterUtil.getBoolean(preferences.getValue(GenericSearchConstants.PREF_COMP_FILTERING, "Off"), false));
		config.setResultsOrientation(
				preferences.getValue(GenericSearchConstants.PREF_RESULTS_ORIENTATION, "Horizontal"));
		config.setHideFitlers(
				GetterUtil.getBoolean(preferences.getValue(GenericSearchConstants.PREF_HIDE_FILTERS, "Off")));
		config.setDateFitlers(
				GetterUtil.getBoolean(preferences.getValue(GenericSearchConstants.PREF_DATE_FILTERING, "Off")));
		config.setDateFitlersField(GetterUtil
				.getString(preferences.getValue(GenericSearchConstants.PREF_DATE_FILTERING_FIELD, Field.CREATE_DATE)));
		config.setFreeTextSearch(GetterUtil.getString(preferences.getValue(GenericSearchConstants.PREF_FREE_TEXT_SEARCH,
				GenericSearchConstants.PARTIAL_MATCH)));
		config.setHideExports(
				GetterUtil.getBoolean(preferences.getValue(GenericSearchConstants.PREF_HIDE_EXPORTS, "Off")));
		config.setAdminOnlyExports(
				GetterUtil.getBoolean(preferences.getValue(GenericSearchConstants.PREF_ADMIN_EXPORTS, "Off")));
		config.setDisableUnwantedFilters(GetterUtil
				.getBoolean(preferences.getValue(GenericSearchConstants.PREF_DISABLE_UNWANTED_FILTERS, "Off")));
		config.setDisableTextSearch(
				GetterUtil.getBoolean(preferences.getValue(GenericSearchConstants.PREF_DISABLE_TEXT_SEARCH, "Off")));
		config.setFilterTopLabel(preferences.getValue(GenericSearchConstants.PREF_FILTER_LABEL,
				GenericSearchConstants.DEFAULT_FILTER_LABEL));
		config.setLeftFilterPlacement(
				GetterUtil.getBoolean(preferences.getValue(GenericSearchConstants.PREF_FILTER_PLACEMENT, "On")));
		config.setClearFiltersOnTextSearch(GetterUtil
				.getBoolean(preferences.getValue(GenericSearchConstants.PREF_CLEAR_FILTERS_TEXTSEARCH, "Off")));
		config.setHideFavourites(
				GetterUtil.getBoolean(preferences.getValue(GenericSearchConstants.PREF_HIDE_FAVOURITES, "Off")));
		config.setSortFitlers(
				GetterUtil.getBoolean(preferences.getValue(GenericSearchConstants.PREF_SORT_FILTERING, "Off")));
		config.setFavouritesRoles(
				GetterUtil.getString(preferences.getValue(GenericSearchConstants.PREF_ENABLED_ROLES, "")));

		Map<String, String> componentMap = getComponentsMap(preferences);
		Set<String> components = componentMap.keySet();

		// read filter rows
		for (String key : preferences.getMap().keySet()) {
			if (!key.startsWith("filter--type--"))
				continue;

			String rowID = key.replaceAll("filter--type--", "");
			String component = rowID.split("_")[0];
			if (!components.contains(component))
				continue;

			String type = preferences.getValue("filter--type--" + rowID, null);
			if (Validator.isNull(type))
				continue;

			String count = preferences.getValue("filter--count--" + rowID, null);
			String subType = preferences.getValue("filter--selection--" + rowID, null);
			String vocab = preferences.getValue("filter--vocab--" + rowID, null);
			String fieldVocabulary = preferences.getValue("filter--fieldVocabulary--" + rowID, null);
			String field = preferences.getValue("filter--field--" + rowID, null);
			String text = preferences.getValue("filter--config--" + rowID, null);
			String apiList = preferences.getValue("filter--apiList--" + rowID, null);
			String display = preferences.getValue("filter--display--" + rowID, null);
			String opr = preferences.getValue("filter--opr--" + rowID, null);
			String values = preferences.getValue("filter--values--" + rowID, null);
			int level = GetterUtil.getInteger(preferences.getValue("filter--level--" + rowID, null));
			int pos = GetterUtil.getInteger(preferences.getValue("filter--position--" + rowID, null), -1);
			int filterId = GetterUtil.getInteger(preferences.getValue("filter--filterId--" + rowID, null));
			GenericSearchFilter filter = new GenericSearchFilter();
			filter.setComponent(component);
			filter.setComponentClass(componentMap.get(component));
			if (GenericSearchFilter.TYPE_FIELD.equalsIgnoreCase(type)) {
				filter.setDisplayCount(count);
			} else {
				filter.setDisplayCount(StringPool.BLANK);
			}
			filter.setFilterId(filterId);
			filter.setType(type);
			filter.setSelection(subType);
			filter.setConfig(text);
			filter.setApiList(apiList);
			filter.setField(field);
			filter.setOperator(opr);
			filter.setPosition(pos);
			filter.setLevel(level);
			if (Validator.isNotNull(values)) {
				values = values.replaceAll("-", ",");
				filter.setValues(Arrays.asList(values.split(StringPool.COMMA)));
			}
			if (GenericSearchFilter.TYPE_VOCAB.equals(type)) {
				filter.setVocabId(GetterUtil.getLong(vocab, -1));
			}
			if (GenericSearchFilter.SELECT_VOCABULARIES.equals(count)) {
				filter.setFieldVocabularyId(GetterUtil.getLong(fieldVocabulary, -1));
			}
			filter.setDisplay(GetterUtil.getBoolean(display, false));
			filter.setLabel(preferences.getValue("filter--label--" + rowID, null));
			config.addFilter(filter);
		}

		return config;
	}

	public static Comparator<AssetCategory> getComparator() {
		return new Comparator<AssetCategory>() {

			@Override
			public int compare(AssetCategory o1, AssetCategory o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}

		};
	}

	public static Map<String, String> getFilterOptionsMap(GenericSearchFilter filter, ThemeDisplay themeDisplay) {
		try {
			Map<String, String> options = new LinkedHashMap<String, String>();
			if (GenericSearchFilter.TYPE_TAG.equals(filter.getType())
					|| ((GenericSearchFilter.TYPE_FIELD.equals(filter.getType()))
							&& (!GenericSearchFilter.SELECT_API.equals(filter.getDisplayCount()))
							&& (!GenericSearchFilter.SELECT_VOCABULARIES.equals(filter.getDisplayCount())))) {
				boolean isFieldFilter = GenericSearchFilter.TYPE_FIELD.equals(filter.getType());
				if (filter.getValues() != null) {
					for (String value : filter.getValues()) {
						if (isFieldFilter && value.contains("=")) {
							options.put(value.split("=")[0], value.split("=")[1]);
						} else {
							options.put(value, value);
						}
					}
				}
			} else if (GenericSearchFilter.SELECT_VOCABULARIES.equals(filter.getDisplayCount())) {

				List<AssetCategory> categories = new ArrayList<AssetCategory>();
				if ((filter.getLevel() == 0) || (Validator.isNull(filter.getLevel()))) {
					categories = AssetCategoryLocalServiceUtil.getVocabularyCategories(filter.getFieldVocabularyId(),
							-1, -1, null);
				} else if (filter.getLevel() == 1) {
					categories = AssetCategoryLocalServiceUtil.getVocabularyCategories(0, filter.getFieldVocabularyId(),
							-1, -1, null);
				} else if (filter.getLevel() == 2) {
					List<AssetCategory> categoriesTemp = AssetCategoryLocalServiceUtil
							.getVocabularyCategories(filter.getFieldVocabularyId(), -1, -1, null);

					for (AssetCategory category : categoriesTemp) {
						if (category.getParentCategoryId() > 0) {
							categories.add(category);
						}
					}
				}

				List<AssetCategory> categoriesSorted = new ArrayList<AssetCategory>(categories);
				Collections.sort(categoriesSorted, getComparator());

				for (AssetCategory assetCategory : categoriesSorted) {
					options.put(String.valueOf(assetCategory.getCategoryId()), assetCategory.getName());
				}

			} else if (GenericSearchFilter.SELECT_API.equals(filter.getDisplayCount())) {
				GenericSearchAPIHelper apiHelper = new GenericSearchAPIHelper(themeDisplay.getCompanyId());
				options = apiHelper.getAPIData(filter.getApiList(), filter.getConfig());
			} else {
				List<AssetCategory> categories = new ArrayList<AssetCategory>();
				if ((filter.getLevel() == 0) || (Validator.isNull(filter.getLevel()))) {
					categories = AssetCategoryLocalServiceUtil.getVocabularyCategories(filter.getVocabId(), -1, -1,
							null);
				} else if (filter.getLevel() == 1) {
					categories = AssetCategoryLocalServiceUtil.getVocabularyCategories(0, filter.getVocabId(), -1, -1,
							null);
				} else if (filter.getLevel() == 2) {
					List<AssetCategory> categoriesTemp = AssetCategoryLocalServiceUtil
							.getVocabularyCategories(filter.getVocabId(), -1, -1, null);

					for (AssetCategory category : categoriesTemp) {
						if (category.getParentCategoryId() > 0) {
							categories.add(category);
						}
					}
				}

				List<AssetCategory> categoriesSorted = new ArrayList<AssetCategory>(categories);
				Collections.sort(categoriesSorted, getComparator());

				for (AssetCategory assetCategory : categoriesSorted) {
					options.put(String.valueOf(assetCategory.getCategoryId()), assetCategory.getName());
				}
			}
			return options;
		} catch (Exception e) {
			logger.warn("Error while building filter options, returning null!");
			return null;
		}
	}

	public static Map<String, Object> getFilterDataMap(GenericSearchFilter filter) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put(GenericSearchConstants.KEY_COMPONENT, filter.getComponent());
		dataMap.put(GenericSearchConstants.KEY_COMPONENT_CLASS, filter.getComponentClass());
		dataMap.put(GenericSearchConstants.KEY_TYPE, filter.getType());
		String key = StringPool.BLANK;
		if (GenericSearchFilter.TYPE_TAG.equals(filter.getType())) {
			key = Field.ASSET_TAG_NAMES;
		} else if ((GenericSearchFilter.TYPE_FIELD.equals(filter.getType()))) {
			key = filter.getField();
			dataMap.put(GenericSearchConstants.KEY_OPER, filter.getOperator());
		} else {
			key = Field.ASSET_CATEGORY_IDS;
			dataMap.put(GenericSearchConstants.KEY_TYPE, filter.getVocabId());
		}
		dataMap.put(GenericSearchConstants.KEY_TYPE_KEY, key);
		dataMap.put(GenericSearchConstants.KEY_SECTION_TYPE_KEY, filter.getDisplayCount());
		dataMap.put(GenericSearchConstants.KEY_FILTER_ID, filter.getFilterId());
		return dataMap;
	}

	public List<Document> search(GSFavourite favourite, int start, int end) throws Exception {
		PortletPreferences prefs = PortletPreferencesLocalServiceUtil.fetchPreferences(favourite.getCompanyId(),
				PortletKeys.PREFS_OWNER_ID_DEFAULT, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, favourite.getLayoutId(),
				favourite.getPortletInstanceId());
		GenericSearchConfig config = parseConfiguration(prefs);
		JSONObject searchItemsJson = JSONFactoryUtil.createJSONObject(favourite.getConfig());
		GenericSearchHelper.GSSearchItems searchItems = null;// new
																// GenericSearchHelper.GSSearchItems(searchItemsJson);
		return search(favourite.getCompanyId(), favourite.getGroupId(), start, end, config, searchItems);
	}

	public List<Document> search(long companyId, long scropeGroupId, int start, int end, GenericSearchConfig config,
			GSSearchItems searchItems) throws Exception {
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setEntryClassNames(searchItems.getComonentClasses());
		// searchContext.setGroupIds(new long[] { themeDisp.getScopeGroupId()
		// });
		searchContext.setCompanyId(companyId);

		String sortParams = searchItems.getSortParams();
		Sort sort = buildSortObject(sortParams);
		if (logger.isDebugEnabled()) {
			logger.debug("start = " + start + ", end = " + end);
			logger.debug("sort = " + sort);
		}

		searchContext.setSorts(sort);

		BooleanQuery searchQuery = buildBooleanQuery(companyId, scropeGroupId, searchContext, config, searchItems);
		logger.error("Search Query " + searchQuery);
		if (Validator.isNotNull(searchQuery)) {
			Hits hits = SearchEngineUtil.search(searchContext.getSearchEngineId(), companyId, searchQuery, sort, start,
					end);
			if (hits.getLength() <= start)
				return null;
			return hits.toList();
		}
		return null;

	}

	public Sort buildSortObject(String sortParams) {
		Sort sort = null;
		try {
			JSONObject obj = JSONFactoryUtil.createJSONObject(sortParams);
			String sortBy = obj.getString(GenericSearchConstants.ATTRIB_SORT_BY);
			int sortFieldType = obj.getInt(GenericSearchConstants.ATTRIB_SORT_TYPE);
			boolean isDesc = obj.getBoolean(GenericSearchConstants.ATTRIB_SORT_ORDER);
			if (Validator.isNotNull(sortBy)) {
				if (sortFieldType == 0 || sortFieldType == -1) {
					sortFieldType = Sort.STRING_TYPE;
				}
				if ((sortFieldType != Sort.STRING_TYPE)
						|| (sortFieldType == Sort.STRING_TYPE && DocumentImpl.isSortableTextField(sortBy))) {
					sortBy = DocumentImpl.getSortableFieldName(sortBy);
				}
				sort = SortFactoryUtil.create(sortBy, sortFieldType, isDesc);
			}
		} catch (Exception e) {
			logger.error("Error building sort criteria, using default as name (desc)", e);
		}
		if (Validator.isNull(sort)) {
			sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
		}
		return sort;
	}

	/**
	 * Builds the base query for this portlet
	 * 
	 * @param req
	 * @param themeDisp
	 * @param searchContext
	 * @param config
	 * @return
	 * @throws ParseException
	 */
	public BooleanQuery buildBooleanQuery(long companyId, long groupId, SearchContext searchContext,
			GenericSearchConfig config, GSSearchItems searchItems) throws ParseException {
		BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
		searchQuery.addRequiredTerm(Field.COMPANY_ID, companyId);

		// TODO: SocialProfile doesnot have scopegroupid so below line had to be
		// commented. So execute the line if search entry class is not
		// socialprofile
		/*
		 * searchQuery.addRequiredTerm(Field.SCOPE_GROUP_ID,
		 * themeDisp.getScopeGroupId());
		 */

		// field search
		Map<String, BooleanQuery> conditionsMap = buildComponentConditionsMap(searchContext, config, searchItems);

		// text search
		String textSearchInput = searchItems.getSearchText();

		if (Validator.isNotNull(textSearchInput)) {
			try {
				String[] enabledComponentClasses = searchItems.getComonentClasses();// getEnabledComponentClasses(req);
				if (ArrayUtil.isEmpty(enabledComponentClasses) || (enabledComponentClasses.length == 1
						&& ArrayUtil.contains(enabledComponentClasses, StringPool.BLANK))) {
					return null;
				}
				Set<String> indexedFields = new HashSet<String>();
				for (String componentClass : enabledComponentClasses) {
					Indexer indexer = IndexerRegistryUtil.getIndexer(componentClass);
					Map<String, String> temp = indexer.getIndexedFields();
					indexedFields.addAll(temp.keySet());
				}
				indexedFields.removeAll(Arrays.asList(Field.UNSCORED_FIELD_NAMES));
				String queryString = StringPool.BLANK;
				if (config != null && config.getFreeTextSearch().equalsIgnoreCase(GenericSearchConstants.EXACT_MATCH)) {
					textSearchInput = textSearchInput.trim().replaceAll(StringPool.SPACE + StringPool.PLUS,
							StringPool.SPACE);
					textSearchInput = textSearchInput.replaceAll(StringPool.SPACE, StringPool.STAR);
					textSearchInput = StringPool.QUOTE + textSearchInput + StringPool.QUOTE;
					if (indexedFields.size() > 0) {
						for (String field : indexedFields) {
							queryString = queryString + StringPool.SPACE + field + StringPool.COLON + textSearchInput
									+ StringPool.SPACE;
						}
						searchQuery.add(StringQueryFactoryUtil.create(queryString), BooleanClauseOccur.MUST);
					}
				} else {
					if (indexedFields.size() > 0) {
						String[] indexedFieldsStrArr = indexedFields.toArray(new String[indexedFields.size()]);
						BooleanQuery subQuery = BooleanQueryFactoryUtil.create(searchContext);
						subQuery.addTerms(indexedFieldsStrArr, textSearchInput, true);
						searchQuery.add(subQuery, BooleanClauseOccur.MUST);
					}

				}
			} catch (Exception e) {
				logger.error("Exception adding searchText ", e);
			}
		}

		// date search
		String startDate = searchItems.getStartDate();
		String endDate = searchItems.getEndDate();
		if (Validator.isNotNull(startDate) || Validator.isNotNull(endDate)) {
			BooleanQuery bq = getBCForDate(config.getDateFitlersField(), startDate, endDate, searchContext);
			searchQuery.add(bq, BooleanClauseOccur.MUST);
		}

		if (Validator.isNull(conditionsMap)) {
			logger.error("No search performed!");
			return null;
		}

		// combine search queries
		Set<Entry<String, BooleanQuery>> entrySet = conditionsMap.entrySet();
		BooleanQuery classesQuery = BooleanQueryFactoryUtil.create(searchContext);
		for (Entry<String, BooleanQuery> entry : entrySet) {
			if (entry.getKey().equals("common")) {
				if (entry.getValue().hasClauses())
					searchQuery.add(entry.getValue(), BooleanClauseOccur.MUST);
			} else {
				classesQuery.add(entry.getValue(), BooleanClauseOccur.SHOULD);
			}
		}
		searchQuery.add(classesQuery, BooleanClauseOccur.MUST);
		// TODO remove this!!
		if (logger.isInfoEnabled()) {
			logger.info("searchQuery = " + searchQuery);
		}
		return searchQuery;
	}

	public static BooleanQuery getBCForDate(String dateFilteringField, String startDate, String endDate,
			SearchContext searchContext) {
		Calendar startCal = null;
		Calendar endCal = null;

		if (Validator.isNotNull(startDate) && Validator.isNotNull(endDate)) {
			Date date1 = getDate4rDDMMYYYY(startDate);
			Date date2 = getDate4rDDMMYYYY(endDate);

			startCal = getStartCalendar(date1);
			endCal = getEndCalendar(date2);

		} else if (Validator.isNotNull(startDate) && Validator.isNull(endDate)) {
			Date date1 = getDate4rDDMMYYYY(startDate);

			startCal = getStartCalendar(date1);
			endCal = getEndCalendar(null);

		} else if (Validator.isNull(startDate) && Validator.isNotNull(endDate)) {
			Date date2 = getDate4rDDMMYYYY(endDate);

			startCal = getStartCalendar(null);
			endCal = getEndCalendar(date2);

		}
		BooleanQuery bq = null;
		if (startCal != null && endCal != null) {
			bq = getBC4RangeTerm(dateFilteringField, startCal, endCal, searchContext); // the
																						// dateFilteringField
																						// can
																						// be
																						// createDate
																						// or
																						// modified
																						// or
																						// displayDate
		}

		return bq;
	}

	public static Calendar getStartCalendar(Date date) {
		Calendar startCal = Calendar.getInstance();
		if (date != null) {
			startCal.setTime(date);
		} else {
			startCal.set(Calendar.YEAR, startCal.get(Calendar.YEAR) - 10);
		}

		return startCal;
	}

	public static Calendar getEndCalendar(Date date) {
		Calendar startCal = Calendar.getInstance();
		if (date != null) {
			startCal.setTime(date);
		} else {
			startCal.set(Calendar.YEAR, startCal.get(Calendar.YEAR) + 10);
		}

		return startCal;
	}

	protected static String _DATE_FORMAT_PATTERN = PropsUtil.get("index.date.format.pattern");

	static BooleanQuery getBC4RangeTerm(String field, Calendar from, Calendar to, SearchContext searchContext) {
		BooleanClause bc = null;
		BooleanQuery bq = null;
		if (Validator.isNotNull(field)) {
			setHMS_0(from);
			setHMS_MAX(to);
			String fromDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT_PATTERN)
					.format(from.getTime());
			String toDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT_PATTERN)
					.format(to.getTime());
			bq = BooleanQueryFactoryUtil.create(searchContext);
			bq.addRangeTerm(field, fromDateString, toDateString);
		}
		return bq;
	}

	public static Date getDate4rDDMMYYYY(String str) {
		if (Validator.isNotNull(str)) {
			try {
				String format = "dd/MM/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(format);
				Date date = df.parse(str);
				return date;
			} catch (Exception ex) {
				logger.error("Error while format String to date. String=" + str);
			}

		}
		return null;
	}

	static void setHMS_0(Calendar cal) {
		if (Validator.isNotNull(cal)) {
			cal.set(Calendar.AM_PM, Calendar.AM);
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
		}
	}

	static void setHMS_MAX(Calendar cal) {
		if (Validator.isNotNull(cal)) {
			cal.set(Calendar.AM_PM, Calendar.PM);
			cal.set(Calendar.HOUR, 11);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
		}
	}

	private Map<String, BooleanQuery> buildComponentConditionsMap(SearchContext searchContext,
			GenericSearchConfig config, GSSearchItems selectedFs) {
		try {
			Map<String, BooleanQuery> conditionMap = new HashMap<String, BooleanQuery>();
			// Map<String, String> componentsMap = getComponentsMap(req,
			// themeDisp);
			String[] componentClasses = selectedFs.getComonentClasses();
			for (String strClass : componentClasses) {
				BooleanQuery classesQuery = BooleanQueryFactoryUtil.create(searchContext);
				conditionMap.put(strClass, classesQuery);

				if ("common".equals(strClass))
					continue;
				classesQuery.add(TermQueryFactoryUtil.create(searchContext, Field.ENTRY_CLASS_NAME, strClass),
						BooleanClauseOccur.MUST);
			}
			JSONArray jsonArray = selectedFs.getSearchItems();
			if (jsonArray != null) {
				List<Integer> ignoreIndexes = new ArrayList<Integer>(jsonArray.length());
				// user filters (displayed on ui)
				for (int i = 0; i < jsonArray.length(); i++) {
					if (ignoreIndexes.contains(i))
						continue;
					ignoreIndexes.add(i);

					JSONObject obj = jsonArray.getJSONObject(i);
					if (obj.length() == 0)
						continue;
					// vocabid or field or tag
					String type = obj.getString(GenericSearchConstants.KEY_TYPE);
					String comp = obj.getString(GenericSearchConstants.KEY_COMPONENT);
					String compClass = obj.getString(GenericSearchConstants.KEY_COMPONENT_CLASS);
					String sectionType = obj.getString(GenericSearchConstants.KEY_SECTION_TYPE_KEY);
					// field name
					String field = obj.getString(GenericSearchConstants.KEY_TYPE_KEY);
					String value = obj.getString(GenericSearchConstants.KEY_VALUE);
					List<Object> valuesList = new ArrayList<Object>();
					valuesList.add(value);
					String opr = obj.getString(GenericSearchConstants.KEY_OPER);
					if (Validator.isNull(opr))
						opr = "eq";

					boolean isCombined = false;
					String otherObjsectionType = StringPool.BLANK;
					// combine values if its a multi select.
					for (int j = 0; (j < jsonArray.length()); j++) {
						if (ignoreIndexes.contains(j))
							continue;
						JSONObject otherObj = jsonArray.getJSONObject(j);
						// vocabid or field or tag
						String otherObjType = otherObj.getString(GenericSearchConstants.KEY_TYPE);
						String otherObjComp = otherObj.getString(GenericSearchConstants.KEY_COMPONENT);
						String otherObjField = otherObj.getString(GenericSearchConstants.KEY_TYPE_KEY);
						otherObjsectionType = obj.getString(GenericSearchConstants.KEY_SECTION_TYPE_KEY);
						String otherObjopr = otherObj.getString(GenericSearchConstants.KEY_OPER);
						if (!otherObjComp.equals(comp) || !otherObjType.equals(type) || !otherObjField.equals(field))
							continue;
						if (Validator.isNull(otherObjopr))
							otherObjopr = "eq";
						if (!otherObjopr.equals(opr))
							continue;
						String otherObjValue = otherObj.getString(GenericSearchConstants.KEY_VALUE);
						valuesList.add(otherObjValue);
						// value = value + " " + otherObjValue;
						ignoreIndexes.add(j);
						isCombined = true;
					}

					String[] componentClasses1 = selectedFs.getComonentClasses();
					for (String strClass : componentClasses1) {

						BooleanQuery query = conditionMap.get(strClass);

						if ((sectionType.equalsIgnoreCase(GenericSearchFilter.SELECT_AGERANGE))
								|| (otherObjsectionType.equalsIgnoreCase(GenericSearchFilter.SELECT_AGERANGE))) {
							String[] splitValue = value.toString().replace(".00", "").split(",");
							// [0] - Indicates the min value chosen, [2] -
							// Indicates the max value chosen
							// [2] -- Slider Min, [3] - Slider max
							// [4] - Indicates whether to consider slider values
							// when their min and max are same as chosen min and
							// max

							if ((GetterUtil.getInteger(splitValue[4]) == 1
									&& GetterUtil.getInteger(splitValue[0]) == GetterUtil.getInteger(splitValue[2])
									&& GetterUtil.getInteger(splitValue[1]) == GetterUtil.getInteger(splitValue[3])
									|| (GetterUtil.getInteger(splitValue[0]) != GetterUtil.getInteger(splitValue[2])
											|| GetterUtil.getInteger(splitValue[1]) != GetterUtil
													.getInteger(splitValue[3])))) {
								if (isCombined) {
									updateQueryWithConditions(query, searchContext, field, sectionType, opr,
											valuesList);
								} else {
									updateQueryWithConditions(query, searchContext, field, sectionType, opr, value);
								}
							}
						} else {
							if (isCombined) {
								updateQueryWithConditions(query, searchContext, field, sectionType, opr, valuesList);
							} else {
								updateQueryWithConditions(query, searchContext, field, sectionType, opr, value);
							}
						}
					}
				}
			}

			if (logger.isDebugEnabled()) {
				logger.debug("conditionMap after user filters = " + conditionMap);
			}
			// background filters (not displayed on ui)
			if (config != null) {
				List<GenericSearchFilter> filters = config.getFilters();
				if (Validator.isNotNull(config.getFilters())) {
					for (GenericSearchFilter filter : filters) {
						if (filter.isDisplay())
							continue;
						BooleanQuery query = conditionMap.get(filter.getComponentClass());
						Map<String, Object> filterDataMap = GenericSearchHelper.getFilterDataMap(filter);
						String typeKey = (String) filterDataMap.get(GenericSearchConstants.KEY_TYPE_KEY);
						String sectionType = (String) filterDataMap.get(GenericSearchConstants.KEY_SECTION_TYPE_KEY);
						String opr = (String) filterDataMap.get(GenericSearchConstants.KEY_OPER);
						if (Validator.isNull(opr))
							opr = "eq";

						if (GenericSearchFilter.SELECT_AGERANGE.equalsIgnoreCase(sectionType)) {
							String[] splitValue = filter.getValues().toString().replace(".00", "").split(",");
							// [0] - Indicates the min value chosen, [2] -
							// Indicates the max value chosen
							// [2] -- Slider Min, [3] - Slider max
							// [4] - Indicates whether to consider slider values
							// when their min and max are same as chosen min and
							// max

							if ((GetterUtil.getInteger(splitValue[4]) == 1
									&& GetterUtil.getInteger(splitValue[0]) == GetterUtil.getInteger(splitValue[2])
									&& GetterUtil.getInteger(splitValue[1]) == GetterUtil.getInteger(splitValue[3])
									|| (GetterUtil.getInteger(splitValue[0]) != GetterUtil.getInteger(splitValue[2])
											|| GetterUtil.getInteger(splitValue[1]) != GetterUtil
													.getInteger(splitValue[3])))) {
								updateQueryWithConditions(query, searchContext, typeKey, sectionType, opr,
										filter.getValues());
							}
						} else {
							updateQueryWithConditions(query, searchContext, typeKey, sectionType, opr,
									filter.getValues());
						}

					}
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug("conditionMap after background filters = " + conditionMap);
			}
			return conditionMap;
		} catch (Exception e) {
			logger.error("Error while building conditions maps for component, returning null", e);
			return null;
		}
	}

	private void updateQueryWithConditions(BooleanQuery query, SearchContext searchContext, String key,
			String sectionType, String opr, Object values) throws Exception {
		if (Validator.isNull(opr) || opr.equals("eq") || opr.equals("ne")) {
			BooleanQuery outerQuery = BooleanQueryFactoryUtil.create(searchContext);
			if (values instanceof List) {
				List<String> valuesList = (List<String>) values;
				for (String value : valuesList) {
					TermQuery innerQuery = TermQueryFactoryUtil.create(searchContext, key, value);
					outerQuery.add(innerQuery, BooleanClauseOccur.SHOULD);
				}
			} else {
				TermQuery innerQuery = TermQueryFactoryUtil.create(searchContext, key, values.toString());
				outerQuery.add(innerQuery, BooleanClauseOccur.SHOULD);
			}
			BooleanClauseOccur condition = opr.equals("ne") ? BooleanClauseOccur.MUST_NOT : BooleanClauseOccur.MUST;
			query.add(outerQuery, condition);
		} else if ("contains".equals(opr)) {
			BooleanQuery outerQuery = BooleanQueryFactoryUtil.create(searchContext);
			if (values instanceof List) {
				List<String> valuesList = (List<String>) values;
				for (String value : valuesList) {
					outerQuery.addTerm(key, value, true);
				}
			} else {
				outerQuery.addTerm(key, values.toString(), true);
			}
			query.add(outerQuery, BooleanClauseOccur.MUST);
		} else if ("bt".equals(opr)) {
			String start = StringPool.BLANK;
			String end = StringPool.BLANK;
			if (values instanceof List) {
				List<String> valuesList = (List<String>) values;
				start = valuesList.get(0);
				end = valuesList.get(1);
			} else {
				String[] split = values.toString().split(",");
				start = split[0];
				end = split[1];
			}
			// otherwise lucene doesnt return valid results.
			if (start.equals("0.00")) {
				start = "0";
			}
			BooleanQuery outerQuery = BooleanQueryFactoryUtil.create(searchContext);
			createRangeQuery(searchContext, key, sectionType, opr, null, start, end, outerQuery);
			query.add(outerQuery, BooleanClauseOccur.MUST);
		} else {
			String start = StringPool.STAR;
			String end = StringPool.STAR;

			BooleanQuery outerQuery = BooleanQueryFactoryUtil.create(searchContext);
			if (values instanceof List) {
				List<String> valuesList = (List<String>) values;
				for (String value : valuesList) {
					createRangeQuery(searchContext, key, sectionType, opr, value, start, end, outerQuery);
				}
			} else {
				createRangeQuery(searchContext, key, sectionType, opr, values.toString(), start, end, outerQuery);
			}

			query.add(outerQuery, BooleanClauseOccur.MUST);
		}
	}

	private void createRangeQuery(SearchContext searchContext, String key, String sectionType, String opr, String value,
			String start, String end, BooleanQuery outerQuery) throws ParseException {
		boolean includesLower = false;
		boolean includesUpper = false;

		if (sectionType.equalsIgnoreCase(GenericSearchFilter.SELECT_AGERANGE)) {
			start = start.replace(".00", "");
			end = end.replace(".00", "");
			int startInt = Integer.parseInt(start);
			int endInt = Integer.parseInt(end);
			start = calculateDob(endInt);
			end = calculateDob(startInt);
		} else {
			start = checkIfTodayValue(start);
			end = checkIfTodayValue(end);
		}
		value = checkIfTodayValue(value);

		if (opr.endsWith("e") || opr.equals("bt")) {
			includesLower = true;
			includesUpper = true;
		}

		if (opr.startsWith("l")) {
			end = value;
			start = null;
		} else if (opr.startsWith("g")) {
			start = value;
			end = null;
		}

		TermRangeQuery rangeQuery = TermRangeQueryFactoryUtil.create(searchContext, key, start, end, includesLower,
				includesUpper);
		outerQuery.add(rangeQuery, BooleanClauseOccur.SHOULD);
	}

	// Improve date options; as of now only today
	private String checkIfTodayValue(String value) {
		if (Validator.isNull(value))
			return value;
		if (!"today".equalsIgnoreCase(value) && !"now".equalsIgnoreCase(value))
			return value;
		Calendar instance = Calendar.getInstance();
		if (value.contains("today")) {
			instance.set(Calendar.MILLISECOND, 0);
			instance.set(Calendar.SECOND, 0);
			instance.set(Calendar.MINUTE, 0);
			instance.set(Calendar.HOUR, 0);
		}

		Format simpleDateFormat = FastDateFormatFactoryUtil.getSimpleDateFormat(DATE_FORMAT_PATTERN);
		return simpleDateFormat.format(instance.getTime());
	}

	// Get the date of birth based on age
	private String calculateDob(int age) {

		Calendar now = Calendar.getInstance();
		now.add(Calendar.YEAR, -age);

		Format simpleDateFormat = FastDateFormatFactoryUtil.getSimpleDateFormat(DATE_FORMAT_PATTERN);
		return simpleDateFormat.format(now.getTime());

	}

	/**
	 * @param req
	 * @param themeDisplay
	 * @return Returns the Map of enabled classes and components by converting
	 *         the component classname to short text.
	 *         <code>component-name : class</code> eg Startups :
	 *         com.sambaash.platform.srv.startupprofile.model.Organization
	 */
	public Map<String, String> getComponentsMap(PortletPreferences prefs) {
		Map<String, String> componentsMap = new HashMap<String, String>();
		String[] enabledClasses = getEnabledComponentClasses(prefs);
		if (ArrayUtil.isEmpty(enabledClasses))
			return componentsMap;
		for (String compClazz : enabledClasses) {
			String component = LanguageUtil.get(Locale.US, compClazz);
			componentsMap.put(component.toLowerCase(), compClazz);
		}
		componentsMap.put("common", "common");
		return componentsMap;
	}

	public static String[] getEnabledComponentClasses(PortletPreferences prefs) {
		String value = prefs.getValue(GenericSearchConstants.PREF_ENABLED_COMPONENTS, StringPool.BLANK);
		// if (Validator.isNull(value))
		// return null;
		// return value.split(StringPool.COMMA);
		String[] enabledComponentClasses = { "com.sambaash.platform.srv.spsocialprofile.model.SocialProfile" };
		return enabledComponentClasses;
	}

	public static String[] getEnabledComponentClasses(PortletRequest req) {
		return getEnabledComponentClasses(req.getPreferences());
	}

	public XSSFWorkbook generateReport(PortletRequest req, ThemeDisplay themeDisplay, List<Document> docs) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		Map<String, String[]> columnMap = new HashMap<String, String[]>();

		createSheetsAndHeaders(req, themeDisplay, workbook, columnMap);

		createRows(req, themeDisplay, docs, workbook, columnMap);

		cleanup(workbook);

		return workbook;
	}

	private void createRows(PortletRequest req, ThemeDisplay themeDisplay, List<Document> docs, XSSFWorkbook workbook,
			Map<String, String[]> columnMap) {
		PortletConfig portletConfig = (PortletConfig) req.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		// format <vocabid_categoryid> = <category name>
		Map<String, String> categoryNames = new HashMap<String, String>();
		for (Document doc : docs) {
			try {
				String component = LanguageUtil.get(portletConfig, themeDisplay.getLocale(),
						doc.get(Field.ENTRY_CLASS_NAME));
				XSSFSheet sheet = workbook.getSheet(WordUtils.capitalize(component));
				String[] cols = columnMap.get(component.toLowerCase());

				int newRowNum = sheet.getLastRowNum() + 1;
				XSSFRow row = sheet.createRow(newRowNum);
				int colCount = COL_START;
				XSSFCell cell = row.createCell(colCount);
				cell.setCellValue(newRowNum - ROW_START);
				for (String col : cols) {
					colCount++;
					cell = row.createCell(colCount);
					if (doc.hasField(col)) {
						String value = StringPool.BLANK;
						try {
							Date date = doc.getDate(col);
							if (Validator.isNotNull(date)) {
								value = DateUtil.getDate(date, "MMM dd, yyyy", themeDisplay.getLocale());
							} else {
								value = GetterUtil.getString(doc.get(col));
							}
						} catch (Exception e) {
							value = GetterUtil.getString(doc.get(col));
						} finally {
							if ("true".equalsIgnoreCase(value)) {
								value = "Yes";
							} else if ("false".equalsIgnoreCase(value)) {
								value = "No";
							}
							cell.setCellValue(value);
						}
					} else if (GetterUtil.getLong(col) != 0) {
						handleAssetCategoryEntries(cell, doc, col, categoryNames);
					}
				}
			} catch (Exception e) {
				logger.error("Error while creating row", e);
			}
		}
	}

	private void handleAssetCategoryEntries(XSSFCell cell, Document doc, String col, Map<String, String> categoryNames)
			throws Exception {
		long categoryIds[] = GetterUtil.getLongValues(doc.getValues(Field.ASSET_CATEGORY_IDS));
		List<Long> categories = Arrays.asList(ArrayUtils.toObject(categoryIds));
		List<String> cellValues = new ArrayList<String>();
		for (Long categoryId : categories) {
			if (categoryId == 0)
				continue;
			String categoryName = categoryNames.get(col + "_" + categoryId);
			if (Validator.isNull(categoryName)) {
				AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);
				categoryNames.put(assetCategory.getVocabularyId() + "_" + categoryId, assetCategory.getName());
				if (Validator.equals(assetCategory.getVocabularyId(), col)) {
					categoryName = assetCategory.getName();
				}
			}
			if (Validator.isNotNull(categoryName))
				cellValues.add(categoryName);
		}
		cell.setCellValue(StringUtil.merge(cellValues.toArray(), ","));
	}

	private void createSheetsAndHeaders(PortletRequest req, ThemeDisplay themeDisplay, XSSFWorkbook workbook,
			Map<String, String[]> columnMap) {
		Map<String, String> componentsMap = getComponentsMap(req.getPreferences());
		for (Entry<String, String> entry : componentsMap.entrySet()) {
			if ("common".equals(entry.getKey()))
				continue;
			Map<String, String> indexedFields = IndexerRegistryUtil.getIndexer(entry.getValue()).getIndexedFields();
			String sheetName = WordUtils.capitalize(entry.getKey());
			XSSFSheet sheet = workbook.createSheet(sheetName);

			String valuesString = req.getPreferences().getValue(GenericSearchConstants.PREF_EXPORTS + entry.getKey(),
					null);
			String[] fields = valuesString.split(",");
			XSSFRow row = sheet.createRow(ROW_START - 2);
			XSSFCell cell = row.createCell((fields.length + COL_START) / 2);
			cell.setCellValue(sheetName);
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			cellStyle.setFillForegroundColor(new XSSFColor(new Color(200, 200, 200)));
			if (ArrayUtil.isNotEmpty(fields)) {
				columnMap.put(entry.getKey(), fields);
				row = sheet.createRow(ROW_START);
				int colCount = COL_START;
				cell = row.createCell(colCount++);
				cell.setCellValue("S No");
				cell.setCellStyle(cellStyle);
				for (String field : fields) {
					cell = row.createCell(colCount++);
					cell.setCellStyle(cellStyle);
					if (Validator.isNotNull(indexedFields.get(field))) {
						cell.setCellValue(WordUtils.capitalize(indexedFields.get(field)));
					} else if (GetterUtil.getLong(field) != 0L) {
						try {
							AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil
									.getAssetVocabulary(GetterUtil.getLong(field));
							cell.setCellValue(assetVocabulary.getName());
						} catch (Exception e) {
							logger.error("Asset Vocabulary not found", e);
						}
					} else {
						cell.setCellValue(field);
					}
				}
			}
		}
	}

	private void cleanup(XSSFWorkbook workbook) {
		for (int i = workbook.getNumberOfSheets() - 1; i >= 0; i--) {
			XSSFSheet sheet = workbook.getSheetAt(i);
			// if no rows remove sheet
			if (sheet.getLastRowNum() == ROW_START) {
				workbook.removeSheetAt(i);
				continue;
			}
			short lastCellNum = sheet.getRow(ROW_START + 1).getLastCellNum();
			for (int j = 0; j < lastCellNum; j++) {
				sheet.autoSizeColumn(j);
				int colWidth = sheet.getColumnWidth(j);
				if (colWidth > MAX_WIDTH) {
					CellStyle columnStyle = sheet.getColumnStyle(j);
					columnStyle.setAlignment(CellStyle.ALIGN_JUSTIFY);
					columnStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
					sheet.setColumnWidth(j, MAX_WIDTH);
				} else if (colWidth <= MIN_WIDTH) {
					sheet.setColumnWidth(j, MIN_WIDTH);
				}
			}
			short firstCellNum = sheet.getRow(sheet.getFirstRowNum()).getFirstCellNum();
			XSSFCellStyle columnStyle = workbook.createCellStyle();
			columnStyle.setAlignment(CellStyle.ALIGN_CENTER);
			sheet.setDefaultColumnStyle(firstCellNum, columnStyle);
		}
		// to avoid error
		if (workbook.getNumberOfSheets() == 0) {
			workbook.createSheet();
		}
	}

	// Class used to process json object containing filters selected during
	// search
	// This json comes from either browser (Whilde doing the search )
	// or from saved favourite (SPGSFavourite table).
	public static class GSSearchItems {
		JSONObject sf;

		/**
		 * selectedFilters = { componentClasses : [], searchItems: [{},{} ],
		 * textSearchInput: "", startDate:"", endDate:"" }
		 * 
		 * 
		 * @param selectedFilters
		 * @param componentClasses
		 */
		public GSSearchItems(JSONObject selectedFilters, String componentClasses[]) {
			this.sf = selectedFilters;
			sf.put("componentClasses", convertToJsonArray(componentClasses));
		}

		public GSSearchItems(String[] componentClasses) {
			sf = JSONFactoryUtil.createJSONObject();
			// sf.put("searchItems", searchItems);
			sf.put("componentClasses", convertToJsonArray(componentClasses));
		}

		public GSSearchItems setSearchItems(JSONArray searchItems) {
			sf.put("searchItems", searchItems);
			return this;
		}

		public GSSearchItems setSortParams(String sortParams) {
			sf.put("sortParams", sortParams);
			return this;
		}

		public GSSearchItems setSearchText(String searchText) {
			sf.put("textSearchInput", searchText);
			return this;
		}

		public GSSearchItems setStartDate(String startDate) {
			sf.put("startDate", startDate);
			return this;
		}

		public GSSearchItems setEndDate(String endDate) {
			sf.put("endDate", endDate);
			return this;
		}

		private JSONArray convertToJsonArray(String str[]) {
			JSONArray cls = JSONFactoryUtil.createJSONArray();
			for (String string : str) {
				cls.put(string);
			}
			return cls;
		}

		public String[] getComonentClasses() {
			String[] strAr = null;
			try {
				JSONArray arr = JSONFactoryUtil.createJSONArray(sf.getString("componentClasses"));
				strAr = new String[arr.length()];
				for (int i = 0; i < arr.length(); i++) {
					strAr[i] = arr.getString(i);
				}
			} catch (Exception e) {
				logger.error(e);
			}

			return strAr;
		}

		public JSONArray getSearchItems() {
			JSONArray jsonArray = null;
			try {
				String searchItems = sf.getString("searchItems");
				jsonArray = JSONFactoryUtil.createJSONArray(searchItems);
			} catch (Exception e) {
				logger.error(e);
			}
			return jsonArray;
		}

		public String getSearchText() {
			return sf.getString("textSearchInput");
		}

		public String getStartDate() {
			return sf.getString("startDate");
		}

		public String getEndDate() {
			return sf.getString("endDate");
		}

		public String getSortParams() {
			return sf.getString("sortParams");
		}
	}

	private static final Log logger = LogFactoryUtil.getLog(GenericSearchHelper.class);

}
