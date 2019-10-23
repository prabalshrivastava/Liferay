package com.sambaash.platform.portlet.enrollment.helper;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil;

public class ApplicantSearchHelper extends EnrollmentHelper{
	
	private static final Log _log = LogFactoryUtil.getLog(ApplicantSearchHelper.class);

	public static JSONObject searchApplicants(PortletRequest request){
		List<Document> docsList = search(request);
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		JSONArray applicants = JSONFactoryUtil.createJSONArray();
		JSONObject applicant;
		long classPK,classNameId,userIdProcess,processId;
		long processStateId;
		for(Document doc : docsList){
			applicant = JSONFactoryUtil.createJSONObject();
			// check PEProcessStateIndexer for field names fetching from document object
			applicant.put("name", doc.get(PEConstantsGlobal.FULL_NAME));
			processStateId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
			/*classPK = GetterUtil.getLong(doc.get(PEConstantsGlobal.ENTITY_ID));
			classNameId =  GetterUtil.getLong(doc.get(PEConstantsGlobal.ENTITY_CLASS_ID));
			userIdProcess = GetterUtil.getLong(doc.get(PEConstantsGlobal.USER_ID_PROCESS));
			processId = GetterUtil.getLong(doc.get(PEConstantsGlobal.PROCESS_ID)); */
			
			// this is required
			applicant.put("processStateId", processStateId);
			try {
				applicant.put("status", PEEngineLocalServiceUtil.getStatusString(processStateId));
			} catch (Exception e) {
				_log.error(e);
			}
			
			applicants.put(applicant);
		}
		obj.put("applicants", applicants);
		return obj;
	}
	public static List<Document> search(PortletRequest request){
		String text = ParamUtil.getString(request, "searchText");
		long productId = ParamUtil.getLong(request, "productId");

		/** Calculating start and end */
		int start = ParamUtil.getInteger(request, "start", -1);
		int pageSize = ParamUtil.getInteger(request, "pageSize", 10);

		// make sure start is valid
		if(start < 1){
			start = -1;
		}
		// just to make sure, page size valid
		if(pageSize < 1 || pageSize > 500){
			pageSize =  10;
		}
		//TODO: if start = -1, make sure we are fetching documents length = pagesize
		int end = start + pageSize;
		/** End -- Calculating start and end */
		
		
		/** Preparing searchContext */
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setCompanyId(themeDisplay.getCompanyId());

		// sort by user full name -- may be can be changed to sort applied/modified date
		Sort sort = SortFactoryUtil.create("fullName",
				Sort.STRING_TYPE, false);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);

		if(Validator.isNotNull(text)){
			searchContext.setKeywords(text);
		}
		
		List<BooleanClause>bcs = new ArrayList<BooleanClause>();
		// must be filtered by classNameId of Product class
		bcs.add(getBCProductClassName(searchContext));
		
		// if valid productId found
		if(productId > 0){
			bcs.add(getBCProductId(searchContext, productId));
		}
		searchContext.setBooleanClauses(bcs.toArray(new BooleanClause[bcs.size()]));
		/** End -- Preparing search context */

		// Let's make search
		Hits results  = searchApplicants(searchContext);
		// Convert results to list 
		List<Document>docs = convertToList(results);
		return docs;
	}
	
	private static BooleanClause getBCProductClassName(SearchContext searchContext){
		return getBC4ExactTerm(PEConstantsGlobal.ENTITY_CLASS_ID, getClassNameIdProduct(), searchContext);
	}
	private static BooleanClause getBCProductId(SearchContext searchContext,long productId){
		return getBC4ExactTerm(Field.ENTRY_CLASS_NAME, productId, searchContext);
	}
	
	public static Hits searchApplicants(SearchContext searchContext) {

		Indexer indexer = IndexerRegistryUtil.getIndexer(PEProcessState.class
				.getName());
		Hits results = null;
		try {
			results = indexer.search(searchContext);
			_log.debug("Search Query " + results.getQuery());
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
		return results;
	}
	
}
