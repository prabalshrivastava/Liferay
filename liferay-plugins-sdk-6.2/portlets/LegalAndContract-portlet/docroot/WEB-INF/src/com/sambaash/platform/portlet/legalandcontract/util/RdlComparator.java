package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.Comparator;

import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.srv.legalandcontract.model.RDL;

public class RdlComparator implements Comparator{

	@Override
	public int compare(Object obj1, Object obj2) {
		
		try{
			if(Validator.isNull(obj2)){
				return 1;
			}
			if(Validator.isNull(obj1)){
				return -1;
			}
			RDL rdl1 = (RDL)obj1;
			RDL rdl2 = (RDL)obj2;
			
			
			return rdl1.compareTo(rdl2);
		}catch(Exception ex){
			
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
