package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.Calendar;
import java.util.Date;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;

public class UIUtils {
	public  static boolean validateDate(String month,String day, String year){
		boolean valid = true;

		if(isDateIgnoreCase(day, month, year)){
			
		}else{
			if( "-1".equals(month) || "-1".equals(day)  || "-1".equals(year)){
			   valid = false;
			}
			if( Validator.isNotNull(month) && (Validator.isNull(day)  || Validator.isNull(year))){
				valid = false;
			}
			if( Validator.isNotNull(day) && (Validator.isNull(month)  || Validator.isNull(year))){
				valid = false;
			}
			if( Validator.isNotNull(year) && (Validator.isNull(day)  || Validator.isNull(month))){
				valid = false;
			}
		}
		return valid;
	}
	public  static boolean validateDate(DateBean db){
		if(Validator.isNotNull(db)){
			return validateDate(db.getMonth(),db.getDate(),db.getYear());
		}
		return true;
	}
	public static boolean isDateIgnoreCase(String day,String month,String year){
		if((Validator.isNull(day) && Validator.isNull(month) && Validator.isNull(year)) ||
				("-1".equals(month) && "0".equals(day) && "0".equals(year)) || ("-1".equals(month) && "-1".equals(day) && "-1".equals(year)) ){
			//Ignore this cases 
			return true;
		}
		return false;
	}
	
	public static Date getDate(ThemeDisplay themeDisplay, DateBean db){
		try{
			String day = db.getDate();
			String month = db.getMonth();
			String year = db.getYear();
			if(UIUtils.isDateIgnoreCase(day, month, year)){
				//Ignore this cases
			}else{
				int appDay = Integer.parseInt(db.getDate());
				int appMonth = Integer.parseInt((db.getMonth()));
				int appYear = Integer.parseInt((db.getYear()));
				Calendar appCal = Utils.getCalendar(themeDisplay, appDay-1,
						appMonth, appYear);
				return appCal.getTime();
			
			}
			
		}catch(Exception ex){
			
		}
		return null;
	}
}
