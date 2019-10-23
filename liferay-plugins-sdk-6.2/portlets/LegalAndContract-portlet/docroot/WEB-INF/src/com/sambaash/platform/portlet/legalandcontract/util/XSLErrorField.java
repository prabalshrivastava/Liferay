package com.sambaash.platform.portlet.legalandcontract.util;

public class XSLErrorField {
	
	private int sheetNo;
	private int rowNo;
	private String fieldName;
	private String msg;
	
	public XSLErrorField(){
		
	}
	public XSLErrorField(int sheetNo,int rowNo,String fieldName,String msg){
		this.sheetNo = sheetNo;
		this.rowNo = rowNo;
		this.fieldName = fieldName;
		this.msg = msg;
	}
	public XSLErrorField(String fieldName,String msg){
		this.fieldName = fieldName;
		this.msg = msg;
	}
	public long getSheetNo() {
		return sheetNo;
	}
	public int getRowNo() {
		return rowNo;
	}
	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setSheetNo(int sheetNo) {
		this.sheetNo = sheetNo;
	}

	@Override
	public String toString() {
		return "sheetNo=" + sheetNo + ", rowNo=" + rowNo + ", fieldName=" + fieldName + ", msg=" + msg;
	}
	
}
