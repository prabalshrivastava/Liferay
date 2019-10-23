package com.sambaash.platform.product.helper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.model.Certificate;
import com.sambaash.platform.srv.model.CompetencyUnit;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.model.Module;
import com.sambaash.platform.srv.model.Outline;
import com.sambaash.platform.srv.model.Product;

public class ProductSearch {

	private static Log _log = LogFactoryUtil.getLog(ProductSearch.class);
	private Class<?> searchClass;

	private String[] sortFields;
	private String[] searchableFields;
	private int pageSize = 10;

	public ProductSearch(Class<?> clsObj) {
		searchClass = clsObj;

		// Product
		if (isProductsSearch()) {
			sortFields = new String[] { "productName", "" };
			searchableFields = new String[] { "productName_lower", "courseName_lower", "countryName_lower", "productId" };
		}

		// Module
		if (isModulesSearch()) {
			sortFields = new String[] { "moduleCode", "" };
			searchableFields = new String[] { "moduleName_lower", "moduleCode_lower" , "courseName_lower"};
		}

		// Course
		if (isCoursesSearch()) {
			sortFields = new String[] { "courseCode", "" };
			searchableFields = new String[] { "courseName_lower", "courseCode_lower", "moduleName_lower" };
		}

		// Certificate
		if (isCertificatesSearch()) {
			sortFields = new String[] { "title", "" };
			searchableFields = new String[] { "title_lower", "levelName_lower", "typeName_lower" };
		}

		// Outline
		if (isOutlinesSearch()) {
			sortFields = new String[] { "competencyCode", "" };
			searchableFields = new String[] { "competencyCode_lower", "competencyDesc_lower", "outlineType_lower" };
		}

		// Competency unit
		if (isCompetencySearch()) {
			sortFields = new String[] { "competencyCode", "" };
			searchableFields = new String[] { "competencyCode_lower", "competencyDesc_lower" };
		}

		// Framework
		if (isFrameworkSearch()) {
			sortFields = new String[] { "frameworkName", "" };
			searchableFields = new String[] { "frameworkCode_lower", "frameworkName_lower" };
		}

		// Framework
		if (isFeeComponentSearch()) {
			sortFields = new String[] { "feeTypeName", "" };
			searchableFields = new String[] { "title_lower", "feeTypeName", "misc" };
		}

		// TODO:initialize for other screens
	}

	private boolean isProductsSearch() {
		return searchClass.getName().equals(Product.class.getName());
	}

	private boolean isModulesSearch() {
		return searchClass.getName().equals(Module.class.getName());
	}

	private boolean isCoursesSearch() {
		return searchClass.getName().equals(Course.class.getName());
	}

	private boolean isCertificatesSearch() {
		return searchClass.getName().equals(Certificate.class.getName());
	}

	private boolean isOutlinesSearch() {
		return searchClass.getName().equals(Outline.class.getName());
	}

	private boolean isCompetencySearch() {
		return searchClass.getName().equals(CompetencyUnit.class.getName());
	}

	private boolean isFrameworkSearch() {
		return searchClass.getName().equals(Framework.class.getName());
	}
	
	private boolean isFeeComponentSearch() {
		return searchClass.getName().equals(FeeType.class.getName());
	}

	private Sort[] getSortFields() {
		Sort[] sortObjs = new Sort[sortFields.length];
		for (int i = 0; i < sortFields.length; i++) {
			Sort sort = SortFactoryUtil.create(sortFields[i], Sort.STRING_TYPE, false);
			sortObjs[i] = sort;
		}
		return sortObjs;
	}

	public Hits search(PortletRequest request, int start) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		Indexer indexer = IndexerRegistryUtil.getIndexer(searchClass.getName());

		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(themeDisplay.getCompanyId());

		int end = start + pageSize;

		searchContext.setStart(start);
		searchContext.setEnd(end);

		Sort[] sorts = getSortFields();
		if (sorts.length > 0) {
			searchContext.setSorts(sorts);
		}

		searchContext.setLike(true);

		List<BooleanClause> bcs = new ArrayList<BooleanClause>();
		BooleanClause bc = null;

		String text = ParamUtil.getString(request, "searchText").trim();

		if (Validator.isNotNull(text)) {
			try {
				bc = getSearchTextQuery(searchContext, text.toLowerCase());
				if (bc != null) {
					bcs.add(bc);
				}
			} catch (ParseException | SystemException e) {
				// TODO Auto-generated catch block
				_log.error(e.getMessage());
			}

		}

		bc = getBCForDate(request, searchContext);
		if (bc != null) {
			bcs.add(bc);
		}

		if (bcs.size() > 0) {
			searchContext.setBooleanClauses(bcs.toArray(new BooleanClause[bcs.size()]));
		}

		Hits results = null;
		try {
			results = indexer.search(searchContext);

		} catch (SearchException e) {
			_log.error(e);
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Total Number of documents " + results.getLength());
			_log.debug("Query" + results.getQuery());
		}

		return results;

	}

	public BooleanClause getBCForDate(PortletRequest request, SearchContext searchContext) {
		String startDate = ParamUtil.getString(request, "startDate");
		String endDate = ParamUtil.getString(request, "endDate");
		Calendar startCal = null;
		Calendar endCal = null;

		if (Validator.isNotNull(startDate) && Validator.isNotNull(endDate)) {
			Date date1 = getDate4rDDMMMYYYY(startDate);
			Date date2 = getDate4rDDMMMYYYY(endDate);

			startCal = getStartCalendar(date1);
			endCal = getEndCalendar(date2);

		} else if (Validator.isNotNull(startDate) && Validator.isNull(endDate)) {
			Date date1 = getDate4rDDMMMYYYY(startDate);

			startCal = getStartCalendar(date1);
			endCal = getEndCalendar(null);

		} else if (Validator.isNull(startDate) && Validator.isNotNull(endDate)) {
			Date date2 = getDate4rDDMMMYYYY(endDate);

			startCal = getStartCalendar(null);
			endCal = getEndCalendar(date2);

		}
		BooleanClause bc = null;
		if (startCal != null && endCal != null) {
			bc = getBC4RangeTerm(Field.MODIFIED_DATE, startCal, endCal, searchContext);
		}

		return bc;
	}

	public Date getDate4rDDMMMYYYY(String str) {
		if (Validator.isNotNull(str)) {
			try {
				String format = "MM/dd/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(format);
				Date date = df.parse(str);
				return date;
			} catch (Exception ex) {
				_log.error("Error while format String to date. String=" + str);
			}

		}
		return null;
	}

	public Calendar getStartCalendar(Date date) {
		Calendar startCal = Calendar.getInstance();
		if (date != null) {
			startCal.setTime(date);
		} else {
			startCal.set(Calendar.YEAR, startCal.get(Calendar.YEAR) - 10);
		}

		return startCal;
	}

	public Calendar getEndCalendar(Date date) {
		Calendar startCal = Calendar.getInstance();
		if (date != null) {
			startCal.setTime(date);
		} else {
			startCal.set(Calendar.YEAR, startCal.get(Calendar.YEAR) + 10);
		}

		return startCal;
	}

	protected static String _DATE_FORMAT_PATTERN = PropsUtil.get("index.date.format.pattern");

	static BooleanClause getBC4RangeTerm(String field, Calendar from, Calendar to, SearchContext searchContext) {
		BooleanClause bc = null;
		if (Validator.isNotNull(field)) {
			setHMS_0(from);
			setHMS_MAX(to);
			String fromDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT_PATTERN)
					.format(from.getTime());
			String toDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT_PATTERN)
					.format(to.getTime());
			BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
			bq.addRangeTerm(field, fromDateString, toDateString);
			bc = BooleanClauseFactoryUtil.create(searchContext, bq, BooleanClauseOccur.MUST.getName());
		}
		return bc;
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

	private BooleanClause getSearchTextQuery(SearchContext searchContext, String text)
			throws SystemException, ParseException {
		// optional search text
		BooleanClause bc = null;
		if (Validator.isNotNull(text) && searchableFields.length > 0) {
			BooleanQuery query = BooleanQueryFactoryUtil.create(searchContext);

			// split the text using space
			String[] splitTexts = text.split(" ");
			for (String searchField : searchableFields) {
				BooleanQuery subQuery = BooleanQueryFactoryUtil.create(searchContext);
				for (String splitText : splitTexts) {
					subQuery.addTerm(searchField, splitText, true, BooleanClauseOccur.MUST);
				}
				query.add(subQuery, BooleanClauseOccur.SHOULD);

			}
			if (query.hasClauses()) {
				bc = BooleanClauseFactoryUtil.create(searchContext, query, BooleanClauseOccur.MUST.getName());
			}
		}
		return bc;
	}

}
