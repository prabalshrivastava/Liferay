package com.sambaash.platform.portlet.legalandcontract.reports;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

@XmlRootElement
public class ReportRecord {

	Map<String, String> colDataMap;
	Map<String, String> extras;

	public Map<String, String> getDataMap() {
		return colDataMap;
	}

	public void setDataMap(Map<String, String> dataMap) {
		this.colDataMap = dataMap;
	}

	public Map<String, String> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, String> extras) {
		this.extras = extras;
	}
	
	public void addExtraData(String key,String value){
		if(Validator.isNull(extras)){
			extras = new HashMap<String, String>();
		}
		extras.put(key, value);
	}
	
	public String getExtraData(String key){
		String value = StringPool.BLANK;
		if(Validator.isNotNull(extras)){
			value = GetterUtil.getString(extras.get(key));
		}
		return value;
	}
	
}