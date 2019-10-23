package com.sambaash.platform.util;

import java.util.Calendar;

import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class SearchUtils {
	protected static String _DATE_FORMAT_PATTERN = PropsUtil.get("index.date.format.pattern");
	
	public static String  getRangeQuery(String field ,Calendar from, Calendar to){
		String query = StringPool.BLANK;
		if(Validator.isNotNull(field)){
			setHMS_0(from);
			setHMS_MAX(to);
			String fromDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT_PATTERN).format(
					from.getTime());
			String toDateString = FastDateFormatFactoryUtil.getSimpleDateFormat(_DATE_FORMAT_PATTERN).format(
					to.getTime());
			
			String format = "%s:[%s TO %s]";
			query = String.format(format, field,fromDateString,toDateString);
			
		}
		return query;
	}
	
	public static String getDateBetweenQuery(String startField, String endField,Calendar date){
		Calendar from = Calendar.getInstance();
		from.set(Calendar.YEAR, date.get(Calendar.YEAR)-100);
		String q1 = getRangeQuery(startField, from, date);
		
		Calendar to = Calendar.getInstance();
		to.set(Calendar.YEAR, date.get(Calendar.YEAR) + 100);
		String q2 = getRangeQuery(endField, date, to);
		
		String resultQFormat = "(%s AND %s)";
		
		return String.format(resultQFormat, q1,q2);
		
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
	
	public static String getActiveOnlyChallengesQuery(){
		String q1 = getDateBetweenQuery("startDate", "endDate", Calendar.getInstance());
		String q2 = "(active:true)";
		String resultQFormat = "(%s AND %s)";
		return String.format(resultQFormat, q1,q2);
		
	}
	
	public static String getActiveChallengesEndDateOnlyQuery(){
		Calendar to = Calendar.getInstance();
		to.set(Calendar.YEAR, to.get(Calendar.YEAR) + 100);
		String q1 = getRangeQuery("endDate", Calendar.getInstance(), to);
		String q2 = "(active:true)";
		String resultQFormat = "(%s AND %s)";
		return String.format(resultQFormat, q1,q2);
		
	}
	
	public static String getActiveCalendarBookingOnlyQuery(){
		Calendar to = Calendar.getInstance();
		to.set(Calendar.YEAR, to.get(Calendar.YEAR) + 100);
		String q1 = getRangeInMillisQuery("startTime", Calendar.getInstance(), to);
		String resultQFormat = "(%s)";
		return String.format(resultQFormat, q1);
	}
	
	public static String getRangeInMillisQuery(String field ,Calendar from, Calendar to) {
		setHMS_0(from);
		setHMS_MAX(to);
		String format = "%s:[%s TO %s]";
		return String.format(format, field,from.getTimeInMillis(),to.getTimeInMillis());
	}

}
