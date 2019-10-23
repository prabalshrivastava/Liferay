package com.sambaash.platform.pe.helpers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.sambaash.platform.srv.model.Product;
public class SearchHelper {
	
	private static final Log _log = LogFactoryUtil.getLog(SearchHelper.class);

	public static List<Document> convertToList(Hits results) {

		Document[]docs = results.getDocs();
		List<Document> list = ListUtil.fromArray(docs);

		return list;
	}

	public static BooleanClause getBC4ExactTerm(String field, String val, SearchContext searchContext) {
		BooleanClause bc = null;

		if (Validator.isNotNull(field)) {
			BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
			bq.addExactTerm(field, "\"" + val +"\"");
			bc = BooleanClauseFactoryUtil.create(searchContext, bq,
					BooleanClauseOccur.MUST.getName());
		}

		return bc;
	} 
	public static BooleanClause getBC4Terms(String fields[], String val, SearchContext searchContext) {
		BooleanClause bc = null;
		
		if (fields != null && fields.length > 0) {
			BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
			for (String field : fields) {
				try {
					bq.addTerm(field, "\"" + val +"\"");
				} catch (ParseException e) {
					_log.error("Error while adding term to boolean clause ",e);
				}
			}
			bc = BooleanClauseFactoryUtil.create(searchContext, bq,
					BooleanClauseOccur.MUST.getName());
		}
		
		return bc;
	} 
	public static BooleanClause getBC4ExactTerm(String field, long val, SearchContext searchContext) {
		return getBC4ExactTerm(field, String.valueOf(val), searchContext);
	}
	protected static String _DATE_FORMAT_PATTERN = PropsUtil.get("index.date.format.pattern");
	static BooleanClause  getBC4RangeTerm(String field ,Calendar from, Calendar to, SearchContext searchContext){
		BooleanClause bc = null;
		if(Validator.isNotNull(field)){
			setHMS_0(from);
			setHMS_MAX(to);
			String fromDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT_PATTERN).format(
					from.getTime());
			String toDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT_PATTERN).format(
					to.getTime());
			BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
			bq.addRangeTerm(field, fromDateString, toDateString);
			bc = BooleanClauseFactoryUtil.create(searchContext,bq,
					BooleanClauseOccur.MUST.getName());
		}
		return bc;
	}
	
	static void  setHMS_0(Calendar cal){
		if(Validator.isNotNull(cal)){
			cal.set(Calendar.AM_PM, Calendar.AM);
			cal.set(Calendar.HOUR,0);
			cal.set(Calendar.MINUTE,0);
			cal.set(Calendar.SECOND,0);
		}
	}
	static void  setHMS_MAX(Calendar cal){
		if(Validator.isNotNull(cal)){
			cal.set(Calendar.AM_PM, Calendar.PM);
			cal.set(Calendar.HOUR,11);
			cal.set(Calendar.MINUTE,59);
			cal.set(Calendar.SECOND,59);
		}
	}
	public static BooleanClause getBCForDate(PortletRequest request, SearchContext searchContext){
		String startDate = ParamUtil.getString(request, "startDate");
		String endDate = ParamUtil.getString(request, "endDate");
		Calendar startCal = null;
		Calendar endCal = null;
		
        if(Validator.isNotNull(startDate) && Validator.isNotNull(endDate)){
        	Date date1 = PEHelper.getDate4rDDMMYYYY(startDate);
        	Date date2 = PEHelper.getDate4rDDMMYYYY(endDate);
        	
        	startCal = getStartCalendar(date1);
        	endCal = getEndCalendar(date2);
        	
        }else if(Validator.isNotNull(startDate) && Validator.isNull(endDate)){
        	Date date1 = PEHelper.getDate4rDDMMYYYY(startDate);
        	
        	startCal = getStartCalendar(date1);
        	endCal = getEndCalendar(null);
        	
        }else if(Validator.isNull(startDate) && Validator.isNotNull(endDate)){
        	Date date2 = PEHelper.getDate4rDDMMYYYY(endDate);
        	
        	startCal = getStartCalendar(null);
        	endCal = getEndCalendar(date2);
        	
        }
        BooleanClause bc  = null;
        if(startCal != null && endCal != null){
        	String text = ParamUtil.getString(request, "selectDateType");
        	if(Field.MODIFIED_DATE.equalsIgnoreCase(text)){
        		bc = getBC4RangeTerm(Field.MODIFIED_DATE, startCal, endCal, searchContext);
        	}else if(Field.CREATE_DATE.equalsIgnoreCase(text)){
        		bc = getBC4RangeTerm(Field.CREATE_DATE, startCal, endCal, searchContext);
        	}
        	 
        }
        
        return bc;
	}
	public static Calendar getStartCalendar(Date date){
		Calendar startCal = Calendar.getInstance();
    	if(date !=  null){
    		startCal.setTime(date);
    	}else{
    		startCal.set(Calendar.YEAR, startCal.get(Calendar.YEAR) - 10);
    	}
    	
    	return startCal;
	}
	public static Calendar getEndCalendar(Date date){
		Calendar startCal = Calendar.getInstance();
		if(date !=  null){
			startCal.setTime(date);
		}else{
			startCal.set(Calendar.YEAR, startCal.get(Calendar.YEAR) + 10);
		}
		
		return startCal;
	}

	public static long getClassNameIdProduct() {
		return ClassNameLocalServiceUtil.getClassNameId(Product.class.getName());
	}


}