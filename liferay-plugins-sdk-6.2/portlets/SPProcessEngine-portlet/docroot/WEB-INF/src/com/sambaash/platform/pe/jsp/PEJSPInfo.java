package com.sambaash.platform.pe.jsp;

import com.sambaash.platform.pe.helpers.PEJSPHelperOld;

public class PEJSPInfo {
	private String name;
	private PEJSPHelperOld helper;
	
	public static PEJSPInfo getJSPInfo(String name,PEJSPHelperOld helper){
		return new PEJSPInfo(name, helper);
	}
	
	private PEJSPInfo(String name,PEJSPHelperOld helper){
		this.name = name;
		this.helper = helper;
	}
	public PEJSPHelperOld getHelper() {
		return helper;
	}
	public void setHelper(PEJSPHelperOld helper) {
		this.helper = helper;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
