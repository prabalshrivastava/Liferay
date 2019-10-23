package com.sambaash.gu.msg;

public class GUMsg {

	private String msg;
	private String sheetName;
	private boolean warning;
	private int rowNo = -1;
	private String clmnName;
	
	public GUMsg(String msg) {
		this.msg = msg;
	}
	public GUMsg(String msg, String sheetName) {
		this.msg = msg;
		this.sheetName = sheetName;
	}
	public GUMsg(String msg, String sheetName, int rowNo) {
		this.msg = msg;
		this.sheetName = sheetName;
		this.rowNo = rowNo;
	}
	public GUMsg(String msg, String sheetName, int rowNo, String clmnName) {
		this.msg = msg;
		this.sheetName = sheetName;
		this.rowNo = rowNo;
		this.clmnName = clmnName;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public boolean isWarning() {
		return warning;
	}
	public void setWarning(boolean warning) {
		this.warning = warning;
	}
	public int getRowNo() {
		return rowNo;
	}
	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	public String getClmnName() {
		return clmnName;
	}
	public void setClmnName(String clmnName) {
		this.clmnName = clmnName;
	}
}
