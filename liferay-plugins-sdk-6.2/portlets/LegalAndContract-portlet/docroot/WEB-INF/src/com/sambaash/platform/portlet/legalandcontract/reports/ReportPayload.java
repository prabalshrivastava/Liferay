package com.sambaash.platform.portlet.legalandcontract.reports;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liferay.portal.kernel.util.DateUtil;

@XmlRootElement
public class ReportPayload {

	Map<String, String> extras;
	List<ReportRecord> recList;

	public Map<String, String> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, String> extras) {
		this.extras = extras;
	}

	public List<ReportRecord> getRecList() {
		return recList;
	}

	public void setRecList(List<ReportRecord> recList) {
		this.recList = recList;
	}

	public void useDefaultMap() {
		extras = new HashMap<String, String>();
		
		extras.put(
				"Logo",
//				"http://localhost:8080/MenariniESN-theme/images/header-footer/Menarini_ESN_Logo3.png");
				"https://connect.menariniapac.com/MenariniESN-theme/images/header-footer/Menarini_ESN_Logo3.png");
				//"http://www.menariniapac.com/wp-content/themes/menarini/images/menarini-logo.png");
		extras.put(
				"TimeStamp",
				DateUtil.getCurrentDate("dd MMM yyyy HH:mm",
						Locale.getDefault()));
	}

	public void setType(String string) {
		if(extras != null)
			extras.put("type", string);
	}
	@XmlTransient
	public String getType() {
		if(extras != null)
			return extras.get("type");
		return null;
	}
	
}