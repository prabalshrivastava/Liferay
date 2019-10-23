package com.sambaash.platform.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
	public static final String DATE_STRING_FORMAT = "yyyy-MM-dd";
	public static final String DATETIME_STRING_FORMAT = "yyyy-MM-dd HHmmss";
	public static final String DATETIME_STRING_FORMAT1 = "yyyy-MM-dd HH:mm:ss";
	public static final SimpleDateFormat DATE_FORMATTER;
	public static final SimpleDateFormat DATETIME_FORMATTER;
	public static final SimpleDateFormat DATETIME_FORMATTER1;
	
	static {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        DATE_FORMATTER = sdf;	
        
		SimpleDateFormat sdf2 = new SimpleDateFormat(DATETIME_STRING_FORMAT);
        sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));
        DATETIME_FORMATTER = sdf2;
        
        SimpleDateFormat sdf3 = new SimpleDateFormat(DATETIME_STRING_FORMAT1);
        sdf3.setTimeZone(TimeZone.getTimeZone("UTC"));
        DATETIME_FORMATTER1 = sdf3;
      
	}

    static public Date toDate(String dateStr) throws ParseException {
        return DATE_FORMATTER.parse(dateStr);
    }
    	
    static public String toString(Date date) {
        return toString(date, null);
    }
    
    static public String toString(Date date, String dateFormat) {
    	SimpleDateFormat df;
    	if (dateFormat==null) {
    		df=DATE_FORMATTER;
    	} else {
    		df = new SimpleDateFormat(dateFormat);
    	}
        return df.format(date);
    }
    
    static public Date toDateTime(String dateStr) throws ParseException {
        return DATETIME_FORMATTER.parse(dateStr);
    }
    	
    static public String toDateTimeString(Date date) {
        return DATETIME_FORMATTER.format(date);
    }
    
    static public String toDateTimeStringFormat(Date date) {
        return DATETIME_FORMATTER1.format(date);
    }
    
    static public String getUTCStartDateString(Date date) {
    	return toString(date);
    }
	
    static public Date getUTCStartDate(Date date) {
    	try {
    		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    		c.setTime(date);
        	c.set(Calendar.HOUR, 0);
        	c.set(Calendar.MINUTE, 0);
        	c.set(Calendar.SECOND, 0);
        	return c.getTime();    		
		} catch (Exception e) {
			return date;
		}
    }
	
    static public Date getUTCEndDate(Date date) {
    	try {
    		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    		c.setTime(getUTCStartDate(date));
        	c.add(Calendar.HOUR, 23);
        	c.add(Calendar.MINUTE, 59);
        	c.add(Calendar.SECOND, 59);
        	return c.getTime();
		} catch (Exception e) {
			return date;
		}
    }
	
    public static void main(String[] args) {
    	Date now = new Date();
	}
    
	
}
