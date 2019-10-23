package com.sambaash.platform.announcement.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.announcement.config.GenericSearchConstants;
import com.sambaash.platform.announcement.config.GenericSearchFilter;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;

public class GSUserProfileHelper {

	public static class GSUserPESearchRequest{
		private long companyId;
		private long groupId;
		private int startIndex;
		private int itemsPerPage;
		private JSONArray processesdUserIds;
		private JSONObject searchItems;
		
		public GSUserPESearchRequest(long companyId,long groupId,int startIndex,int itemsPerPage){
			this.companyId = companyId;
			this.groupId = groupId;
			this.startIndex = startIndex;
			this.itemsPerPage = itemsPerPage;
		}
		
		public GSUserPESearchRequest setProcessedUserIds(JSONArray processesdUserIds){
			this.processesdUserIds = processesdUserIds;
			return this;
		}
		public GSUserPESearchRequest setSearchItems(JSONObject searchItems){
			this.searchItems = searchItems;
			return this;
		}

		public long getCompanyId() {
			return companyId;
		}

		public long getGroupId() {
			return groupId;
		}

		public int getStartIndex() {
			return startIndex;
		}

		public JSONArray getProcessesdUserIds() {
			return processesdUserIds;
		}
		
		public JSONObject getSearchItems(){
			return searchItems;
		}

		public int getItemsPerPage() {
			return itemsPerPage;
		}
		
	}
	public static class GSUserPESearchResponse{
		private int startIndex;
		private JSONArray processesdUserIds;
		private List<Document> docs;
		
		GSUserPESearchResponse(int startIndex, List<Document>docs){
			this.startIndex = startIndex;
			this.docs = docs;
		}
		
		GSUserPESearchResponse setProcessedUserIds(JSONArray processesdUserIds){
			this.processesdUserIds = processesdUserIds;
			return this;
		}

		public int getStartIndex() {
			return startIndex;
		}

		public JSONArray getProcessesdUserIds() {
			return processesdUserIds;
		}

		public List<Document> getDocs() {
			return docs;
		}
		
	}
	public void overrideComponentClass(JSONArray peFilters ){
		if(peFilters != null){
			for(int i = 0 ; i < peFilters.length() ; i++){
				JSONObject filter = peFilters.getJSONObject(i);
				String component = LanguageUtil.get(
						Locale.US, PEProcessState.class.getCanonicalName());
				filter.put(GenericSearchConstants.KEY_COMPONENT, component);
				filter.put(GenericSearchConstants.KEY_COMPONENT_CLASS, PEProcessState.class.getCanonicalName());
			}
		}
	}
	public GSUserPESearchResponse searchUsingUsrAndPEFilters(GSUserPESearchRequest request, JSONArray usrFilters, JSONArray peFilters,boolean returnAllDocs) throws Exception {
		int start = request.getStartIndex();
		int itemsPerPage = request.getItemsPerPage();

		// Building GSSearchItems to query ProcessIndexer using GenericSearch logic
		GenericSearchHelper.GSSearchItems pesearchItems = buildGSSearchItemsForPE(peFilters);
		final String peFiltersStr = peFilters.toString();

		// Building GSSearchItems to query social profile indexer
		String[] usrClass = {SocialProfile.class.getName()};
		GenericSearchHelper.GSSearchItems usrsearchItems = new GenericSearchHelper.GSSearchItems(request.getSearchItems(),usrClass);
		List<Document>processed = new ArrayList<Document>();
		GenericSearchHelper helper = new GenericSearchHelper();
		// Create searchitem with default value, then reuse same searchitem by resetting value
		JSONObject searchItemUserId = buildSearchItemPE(PEConstantsGlobal.USER_ID_PROCESS, String.valueOf(0));
		if(returnAllDocs){
			itemsPerPage = Integer.MAX_VALUE;
		}
		/** 1.Query the user indexer
		 *  2.For each user document check if corresponding process filters are being satisfied  
		 *  3.If yes, then user can be displayed 
		 *  4.Continue above 3 steps until we able to fetch desired number ( pagesize) of users
		 * 
		 */
		while(processed.size() < itemsPerPage){
			// Query User profile indexer.. for better performance keeping page size as 100 and start index will keep moved as documents are processed
			int end = start + 100; 
			List<Document>usrDocs = helper.search(request.getCompanyId(), request.getGroupId(), start, end, null, usrsearchItems);
			if( usrDocs == null || usrDocs.size() == 0){
				break;
			}
			
			// loop through docs and check each doc whether satisfying process engine filters by querying process indexer
			for (Document usrDoc : usrDocs) {
				// Move start index to next
				start = start + 1;
				String userId =   usrDoc.get(Field.USER_ID);
				
				// Construct new json array (Searchitems) from filters coming from client and add new filter to identy the user
				// For performance reason, using same searchitem and resetting userid value.
				searchItemUserId.put(GenericSearchConstants.KEY_VALUE,userId);
				JSONArray peFiltersTemp = JSONFactoryUtil.createJSONArray(peFiltersStr);
				peFiltersTemp.put(searchItemUserId);
				pesearchItems.setSearchItems(peFiltersTemp);
				//Search process indexer
				List<Document>pedocs = helper.search(request.getCompanyId(), request.getGroupId(), -1, -1, null, pesearchItems);
				if(pedocs == null || pedocs.size() == 0){
					// ignore the user doc.. it's not satisfying process filters
				}else{
					processed.add(usrDoc);
					// we got desired number of docs, so no need to further processing. Break the loop here
					if(processed.size() == itemsPerPage){
						break;
					}
				}
			}
			
		}
		GSUserPESearchResponse response = new GSUserProfileHelper.GSUserPESearchResponse(start,processed);
		return response;
	}
	public GSUserPESearchResponse searchUsingPEFilersOnly(GSUserPESearchRequest request,JSONArray peFilters, String sortParams,boolean returnAllDocs ) throws Exception {
		int start = request.getStartIndex();
		JSONArray processesdUserIds = null;
		if (Validator.isNull(request.getProcessesdUserIds())){
			 processesdUserIds = JSONFactoryUtil.createJSONArray();
		}else{
			 processesdUserIds = request.getProcessesdUserIds();
		}
		int itemsPerPage = request.getItemsPerPage();	

		// Building GSSearchItems to query ProcessIndexer using GenericSearch logic. Sortparams are required as process indexer here acting as master.
		// So while querying process indexer itself, documents needs to fetched in sorted order
		GenericSearchHelper.GSSearchItems pesearchItems = buildGSSearchItemsForPE(
				peFilters, sortParams);


		GenericSearchHelper helper = new GenericSearchHelper();
		// Keep query the process indexer until we get desired (pagesize) unique user documents
		
		/** 1.Query the process indexer
		 *  2.For each process document check if corresponding user doc processed 
		 *  3.If not, get the corresponding user document 
		 *  4.Continue above 3 steps until we able to fetch desired number ( pagesize) of users
		 * 
		 */
		// User filters - for retrieving  profiles from indexer. Users in this array are satisfied the search filters  
		JSONArray usrFilters = JSONFactoryUtil.createJSONArray();
		if(returnAllDocs){
			itemsPerPage = Integer.MAX_VALUE;
		}
		while(usrFilters.length() < itemsPerPage){
			// Query process indexer.. for better performance keeping page size as 50 and start index will keep moved as documents are processed
			int end = start + 50; 
			List<Document>pedocs = helper.search(request.getCompanyId(), request.getGroupId(), start, end, null, pesearchItems);
			if( pedocs == null || pedocs.size() == 0){
				break;
			}
			// loop through docs and fetch corresponding user document
			for (Document pedoc : pedocs) {
				start = start + 1;
				long userId =   GetterUtil.getLong(pedoc.get(PEConstantsGlobal.USER_ID_PROCESS));

				// Uniqueness check. If user doc is already processed then dont included it.
				if(!userIdExists(processesdUserIds, userId)){
					processesdUserIds.put(userId);
					// creating search filter to get user doc.
					
					usrFilters.put(buildSearchItemForProfile(userId));
					
					if(usrFilters.length() >= itemsPerPage){
						break;
					}
				}
			}
		}
		List<Document>usrDocs = null;
		if(usrFilters.length() > 0){
			// Buildig GSSearchItems to query social profile indexer
			GenericSearchHelper.GSSearchItems usrsearchItems = buildGSSearchItemsForProfile(request,usrFilters);
			usrsearchItems.setSortParams(sortParams);
			// fetch corresponding user doc
			usrDocs = helper.search(request.getCompanyId(), request.getGroupId(), -1,-1, null, usrsearchItems);
		}
		GSUserPESearchResponse response = new GSUserProfileHelper.GSUserPESearchResponse(start,usrDocs);
		response.setProcessedUserIds(processesdUserIds);
		return response;
	}
	private GenericSearchHelper.GSSearchItems buildGSSearchItemsForProfile(
			GSUserPESearchRequest request,JSONArray profileFilters) throws JSONException {
		// Buildig GSSearchItems to query social profile indexer 
		// create searchitems object using request object then reset  propertis like searchitems array as needed.
		// using this way, startdate,enddate,searchtext etc.. can be preserved
		JSONObject searchItemsJson = JSONFactoryUtil.createJSONObject(request.getSearchItems().toString());
		String[] usrClass = {SocialProfile.class.getName()};
		GenericSearchHelper.GSSearchItems usrsearchItems = new GenericSearchHelper.GSSearchItems(searchItemsJson,usrClass);
		usrsearchItems.setSearchItems(profileFilters);
		return usrsearchItems;
	}
	private GenericSearchHelper.GSSearchItems buildGSSearchItemsForPE(
			JSONArray peFilters) {
		return buildGSSearchItemsForPE(peFilters,null);
	}
	private GenericSearchHelper.GSSearchItems buildGSSearchItemsForPE(
			JSONArray peFilters, String sortParams) {
		// Building GSSearchItems to query ProcessIndexer using GenericSearch logic
		// this is required for generic search
		overrideComponentClass(peFilters);
		// Add default filter. Search only active applications
		peFilters.put(buildSearchItemPEActiveApps());
		String[] peClass = {PEProcessState.class.getCanonicalName()};
		GenericSearchHelper.GSSearchItems pesearchItems = new GenericSearchHelper.GSSearchItems(peClass);
		pesearchItems.setSearchItems(peFilters).setSortParams(sortParams);
		return pesearchItems;
	}
	
	private JSONObject buildSearchItemForProfile(long userId){
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put(GenericSearchConstants.KEY_TYPE, GenericSearchFilter.TYPE_FIELD);
		String component = LanguageUtil.get(
				Locale.US, SocialProfile.class.getCanonicalName());
		obj.put(GenericSearchConstants.KEY_COMPONENT, component);
		obj.put(GenericSearchConstants.KEY_COMPONENT_CLASS, SocialProfile.class.getCanonicalName());
		//obj.put(GenericSearchConstants.KEY_SECTION_TYPE_KEY, "");
		obj.put(GenericSearchConstants.KEY_TYPE_KEY, Field.USER_ID); // field
		obj.put(GenericSearchConstants.KEY_VALUE, userId); // value
		return obj;
	}
	
	private JSONObject buildSearchItemPE(String fieldName,String value){
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put(GenericSearchConstants.KEY_TYPE, GenericSearchFilter.TYPE_FIELD);
		String component = LanguageUtil.get(
				Locale.US, PEProcessState.class.getCanonicalName());
		obj.put(GenericSearchConstants.KEY_COMPONENT, component);
		obj.put(GenericSearchConstants.KEY_COMPONENT_CLASS, PEProcessState.class.getCanonicalName());
		obj.put(GenericSearchConstants.KEY_TYPE_KEY, fieldName); // field
		obj.put(GenericSearchConstants.KEY_VALUE, value); // value
		return obj;
	}
	private JSONObject buildSearchItemPEActiveApps(){
		return buildSearchItemPE(PEConstantsGlobal.ACTIVE_STATUS, String.valueOf(PEConstantsGlobal.ACTIVE_STATUS_ACTIVE));
	}
	
	private boolean userIdExists(JSONArray array,long userId){
		if(array == null){
			return false;
		}
		
		for(int index = 0 ; index < array.length() ; index++){
			if(userId == array.getLong(index)){
				return true;
			}
		}
		return false;
	}
	
}
