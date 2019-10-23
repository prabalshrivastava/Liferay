package com.sambaash.platform.portlet.spwebcontentfilter.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ThumbnailUtil;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.RepositoryException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Html;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalContentSearch;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContent;

public class SPWebContentFilterAction extends MVCPortlet {

		private static Log _log = LogFactoryUtil.getLog(SPWebContentFilterAction.class);

		@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
			_log.info("SPAssetEntryTypeLandingMVCPortlet:doView()");

			ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			JSONObject solutionsJSONObject = getAllContents(themeDisplay,renderRequest,renderResponse);
			renderRequest.setAttribute("solutionsJSONObject", solutionsJSONObject);
			super.doView(renderRequest, renderResponse);
		}

		@Override
		public void init() throws PortletException {
			_log.info("init()");
			super.init();
		}

		@Override
		public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

			super.serveResource(resourceRequest, resourceResponse);
			
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String categoryIds = resourceRequest.getParameter("categoryIds");
			JSONObject solutionsSearchJSONObject = JSONFactoryUtil.createJSONObject();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String jsonResponse = null;
			
			SearchContext searchContext = new SearchContext();
			searchContext.setCompanyId(themeDisplay.getCompanyId());
			searchContext.setStart(0);
			searchContext.setEnd(50);
			String categoryName1 = "";
			String categoryName2 = "";
			String categoryName3 = "";
			long categoryId1 =0;
			long categoryId2 =0;
			long categoryId3 =0;
			if(!categoryIds.equals("0/0/0")){
			try{
			String [] categoryIdArray = categoryIds.split("/"); 
		    long[] categoryId = new long[categoryIdArray.length];     
		    List<BooleanClause>  booleanClauseList = new ArrayList<BooleanClause>();
		    
		    BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);;
		    for (int i = 0; i < categoryIdArray.length; i++) {   
		    	if((i==0) && (Integer.parseInt(categoryIdArray[i]) != 0)){
		    		
		    		categoryId[0] = Long.parseLong(categoryIdArray[0]);
		    		AssetCategory asstCategory = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId[0]);
		    		categoryName1 = asstCategory.getName();
		    	}
		    	if((i==1) && (Integer.parseInt(categoryIdArray[i]) != 0)){
		    		
		    		categoryId[i] = Long.parseLong(categoryIdArray[i]);
		    		AssetCategory asstCategory = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId[i]);
		    		categoryName2 = asstCategory.getName();
		    	}
		    	if((i==2) && (Integer.parseInt(categoryIdArray[i]) != 0)){
		
		    		categoryId[i] = Long.parseLong(categoryIdArray[i]);
		    		AssetCategory asstCategory = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId[i]);
		    		categoryName3 = asstCategory.getName();
		    	}
		    } 
		    if(!categoryName1.isEmpty())
		    booleanQuery.addRequiredTerm(Field.ASSET_CATEGORY_NAMES, "\"" + categoryName1 + "\"");
		    if(!categoryName2.isEmpty())
		    booleanQuery.addRequiredTerm(Field.ASSET_CATEGORY_NAMES, "\"" + categoryName2 + "\"");
		    if(!categoryName3.isEmpty())
		    booleanQuery.addRequiredTerm(Field.ASSET_CATEGORY_NAMES, "\"" + categoryName3 + "\"");
		    BooleanClause booleanClause = BooleanClauseFactoryUtil.create(searchContext,booleanQuery, BooleanClauseOccur.MUST.getName());
			booleanClauseList.add(booleanClause);
			
			BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
			for (int i = 0; i < booleanClauseList.size(); i++) {
			booleanClauses[i] = booleanClauseList.get(i);
			}
			searchContext.setBooleanClauses(booleanClauses);
			
		    //searchContext.setCategoryIds(categoryId);
			Indexer indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class.getName());
			
			Hits results = indexer.search(searchContext);
			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				String title = GetterUtil.getString(doc.get(Field.TITLE));
				String articleId = GetterUtil.getString(doc.get("articleId"));
//				String[] ids = id.split("_");
//				String articleId = "";
//				if(ids.length > 0){
//					articleId = ids[4];
//				}
				String description = GetterUtil.getString(doc.get(Field.CONTENT));
				String content = GetterUtil.getString(doc.get("exactContent"));
				JSONObject solutionsTitleSearchJSONObject = JSONFactoryUtil.createJSONObject();
				solutionsTitleSearchJSONObject.put(title, description);
				solutionsSearchJSONObject.put(articleId, solutionsTitleSearchJSONObject);
			}	
			}catch(Exception e){
				_log.error(e.getMessage());
			}
			}else{
				solutionsSearchJSONObject = getAllContents(themeDisplay,null,null);
			}
			
			resourceResponse.getWriter().append(solutionsSearchJSONObject.toString());
			resourceRequest.setAttribute("solutionsSearchJSONObject", solutionsSearchJSONObject);
		}
		
		@Override
		public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

			super.doEdit(renderRequest, renderResponse);
			
		}

		@Override
		public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
			super.processAction(actionRequest, actionResponse);
		}
		
		public JSONObject getAllContents(ThemeDisplay themeDisplay,RenderRequest renderRequest,RenderResponse renderResponse){
			JSONObject solutionsJSONObject = JSONFactoryUtil.createJSONObject();
			List<AssetVocabulary> assetVocabularies = null;
			try{
			if (assetVocabularies == null) {
				assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
			}
			int noOfCategories = 0;
			int totalCategories = 0;
			long[] cIds;
			int j = 0;
			
			List<AssetCategory> industryAssetCategories = null;
			noOfCategories = AssetCategoryLocalServiceUtil.getVocabularyCategoriesCount(13497);
			industryAssetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(13497, 0, noOfCategories, null);
			if(renderRequest!=null)
			renderRequest.setAttribute("industryAssetCategories", industryAssetCategories);
			Iterator<AssetCategory> industryCategoriesItr = industryAssetCategories.iterator();
			totalCategories = totalCategories + noOfCategories;
			
			List<AssetCategory> functionAssetCategories = null;
			noOfCategories = AssetCategoryLocalServiceUtil.getVocabularyCategoriesCount(13512);
			functionAssetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(13512, 0, noOfCategories, null);
			if(renderRequest!=null)
			renderRequest.setAttribute("functionAssetCategories", functionAssetCategories);
			Iterator<AssetCategory> functionCategoriesItr = functionAssetCategories.iterator();
			totalCategories = totalCategories + noOfCategories;
			List<AssetCategory> serviceAssetCategories = null;
			noOfCategories = AssetCategoryLocalServiceUtil.getVocabularyCategoriesCount(13526);
			serviceAssetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(13526, 0, noOfCategories, null);
			if(renderRequest!=null)
			renderRequest.setAttribute("serviceAssetCategories", serviceAssetCategories);
			Iterator<AssetCategory> serviceAssetCategoriesItr = serviceAssetCategories.iterator();
			totalCategories = totalCategories + noOfCategories;
			cIds = new long[totalCategories];
			if(renderRequest!=null)
			renderRequest.setAttribute("totalCategories", totalCategories);
			SearchContext searchContext = new SearchContext();
			searchContext.setCompanyId(themeDisplay.getCompanyId());
			searchContext.setStart(0);
			searchContext.setEnd(100);
			List<BooleanClause>  booleanClauseList = new ArrayList<BooleanClause>();
			BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
			
			while(industryCategoriesItr.hasNext()){
				String searchByCategory1 = industryCategoriesItr.next().getName();
				categoryBooleanQuery.addTerm(Field.ASSET_CATEGORY_NAMES,  "\"" + searchByCategory1 + "\"");
			}
			while(functionCategoriesItr.hasNext()){
				String searchByCategory2 = functionCategoriesItr.next().getName();
				categoryBooleanQuery.addTerm(Field.ASSET_CATEGORY_NAMES,  "\"" + searchByCategory2 + "\"" );
			}
			while(serviceAssetCategoriesItr.hasNext()){
				String searchByCategory3 =  serviceAssetCategoriesItr.next().getName();
				categoryBooleanQuery.addTerm(Field.ASSET_CATEGORY_NAMES,  "\"" + searchByCategory3 + "\"");
			}
			
			BooleanClause categoryBooleanClause = BooleanClauseFactoryUtil.create(searchContext,categoryBooleanQuery, BooleanClauseOccur.MUST.getName());
			booleanClauseList.add(categoryBooleanClause);
		
		BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];
		for(int i=0; i<booleanClauseList.size(); i++) {
			booleanClauses[i] = booleanClauseList.get(i);
		}
		searchContext.setBooleanClauses(booleanClauses);
			Indexer indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class.getName());
			Hits results = indexer.search(searchContext);
			for (int i = 0; i < results.getDocs().length; i++) {
				Document doc = results.doc(i);
				String title = GetterUtil.getString(doc.get(Field.TITLE));
				String aId = GetterUtil.getString(doc.get("articleId"));
				String articleId = "";
				String id = GetterUtil.getString(doc.get(Field.UID));
				String[] ids = id.split("_");

				if(ids.length > 0){
					articleId = ids[4];
				}
				String description = GetterUtil.getString(doc.get(Field.CONTENT));
				JournalArticle jArticle = JournalArticleLocalServiceUtil.getArticle(themeDisplay.getScopeGroupId(), aId);
				String content = jArticle.getContent();
				JSONObject solutionsTitleJSONObject = JSONFactoryUtil.createJSONObject();
				solutionsTitleJSONObject.put(title, content);
				solutionsJSONObject.put(articleId, solutionsTitleJSONObject);
			}
			}catch(Exception e)
			{
				_log.error(e.getMessage());
			}
			return solutionsJSONObject;
		}

	}
