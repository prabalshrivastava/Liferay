package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.Comparator;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portlet.asset.model.AssetCategory;

public class AssetCategoryStringComparator implements Comparator{

	@Override
	public int compare(Object obj1, Object obj2) {
		int result = 0;
		try{
			AssetCategory categ1 = (AssetCategory)obj1;
			AssetCategory categ2 = (AssetCategory)obj2;
			return categ1.getName().compareTo(categ2.getName());
		}catch(Exception ex){
			
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
