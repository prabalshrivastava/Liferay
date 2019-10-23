package com.sambaash.platform.portlet.enrollment.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.sambaash.platform.srv.model.Product;

public class EnrollmentHelper {

	public static String getDateStrddMMYYYY(Date date){
		String dateStr = "";
		String format = "dd/MM/yyyy";
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateStr = sdf.format(date); 
		}
		return dateStr;
	}
	
	public static List<Document> convertToList(Hits results){

		Document []docs = results.getDocs();
		List<Document> list = ListUtil.fromArray(docs);
	
		return list;
	}

	public static long getClassNameIdProduct(){
		return ClassNameLocalServiceUtil.getClassNameId(Product.class.getName());
	}
	
	static BooleanClause getBC4ExactTerm(String field,long val,SearchContext searchContext){
		return getBC4ExactTerm(field, String.valueOf(val), searchContext);
	}
	static BooleanClause getBC4ExactTerm(String field,String val,SearchContext searchContext){
		BooleanClause bc = null;
		if(Validator.isNotNull(field)){
			BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
			bq.addExactTerm(field, "\"" + val +"\"");
			bc = BooleanClauseFactoryUtil.create(searchContext,bq,
					BooleanClauseOccur.MUST.getName());
		}
		return bc;
	}
}
