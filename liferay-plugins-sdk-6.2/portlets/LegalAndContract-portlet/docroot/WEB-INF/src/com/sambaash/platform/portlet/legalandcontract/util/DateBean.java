package com.sambaash.platform.portlet.legalandcontract.util;

import com.liferay.portal.kernel.util.Validator;

public class DateBean {
	
	private String date;
	private String month;
	private String year;
	private boolean nullable;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public DateBean(){
		
	}
	public DateBean(String date, String month, String year){
		if(Validator.isNull(date) && Validator.isNull(month) && Validator.isNull(year)){
			this.date = "0";
			this.month = "-1";
			this.year = "0";
			
		}else{
			this.date = date;
			this.month = month;
			this.year = year;
		}
	}
	public boolean isNullable() {
		if(Validator.isNull(this.date) || "0".equalsIgnoreCase(this.date)){
			this.nullable = true;
		}
		if(Validator.isNull(this.month) || "-1".equalsIgnoreCase(this.date)){
			this.nullable = true;
			
		}
		if(Validator.isNull(this.year) || "0".equalsIgnoreCase(this.date)){
			this.nullable = true;
		}
		return nullable;
	}
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}
}
