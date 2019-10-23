package com.sambaash.gu.msg;


public class GUError extends GUMsg{
	public GUError(String msg) {
		super(msg);
	}

	public GUError(String msg, String sheetName) {
		super(msg,sheetName);
	}

	public GUError(String msg, String sheetName, int rowNo) {
		super(msg, sheetName, rowNo);
	}
	public GUError(String msg, String sheetName, int rowNo, String clmnName) {
		super(msg, sheetName, rowNo, clmnName);
	}
}
