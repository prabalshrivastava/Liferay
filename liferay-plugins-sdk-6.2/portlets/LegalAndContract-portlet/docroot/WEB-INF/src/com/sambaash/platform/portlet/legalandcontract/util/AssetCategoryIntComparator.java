package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.Comparator;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portlet.asset.model.AssetCategory;

public class AssetCategoryIntComparator implements Comparator{

	@Override
	public int compare(Object obj1, Object obj2) {
		int result = 0;
		try{
			AssetCategory categ1 = (AssetCategory)obj1;
			AssetCategory categ2 = (AssetCategory)obj2;
			Long l1 = GetterUtil.getLong(categ1.getName());
			Long l2 = GetterUtil.getLong(categ2.getName());
			
			return l1.compareTo(l2);
		}catch(Exception ex){
			
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
