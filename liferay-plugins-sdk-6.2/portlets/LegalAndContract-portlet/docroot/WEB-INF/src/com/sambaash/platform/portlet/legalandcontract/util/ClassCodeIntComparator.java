package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.Comparator;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portlet.asset.model.AssetCategory;

public class ClassCodeIntComparator implements Comparator{

	@Override
	public int compare(Object obj1, Object obj2) {
		int result = 0;
		try{
			JSONObject code1 = (JSONObject)obj1;
			JSONObject code2 = (JSONObject)obj2;
			Long l1 = GetterUtil.getLong(code1.getString(TrademarksConstants.CC_PREFIX));
			Long l2 = GetterUtil.getLong(code2.getString(TrademarksConstants.CC_PREFIX));
			
			return l1.compareTo(l2);
		}catch(Exception ex){
			
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
