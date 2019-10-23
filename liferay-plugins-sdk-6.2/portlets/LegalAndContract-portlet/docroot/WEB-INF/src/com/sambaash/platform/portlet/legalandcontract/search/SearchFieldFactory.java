package com.sambaash.platform.portlet.legalandcontract.search;

public class SearchFieldFactory {
	
	public static SearchField getSearchFieldText(String title, String key, String indexerFieldName){
		SearchField sf = new SearchField();
		sf.setTitle(title);
		sf.setKey(key);
		sf.setIndexerFieldName(indexerFieldName);
		sf.setType(SearchField.TEXT);
		return sf;
	}
	public static SearchField getSearchFieldDate(String title, String key, String indexerFieldName){
		SearchField sf = new SearchField();
		sf.setTitle(title);
		sf.setKey(key);
		sf.setIndexerFieldName(indexerFieldName);
		sf.setType(SearchField.DATE_RANGE);
		return sf;
	}
	public static SearchField getSearchFieldCategory(String title, String key, String indexerFieldName,long vocId){
		SearchField sf = new SearchField();
		sf.setTitle(title);
		sf.setKey(key);
		sf.setIndexerFieldName(indexerFieldName);
		sf.setVocId(vocId);
		sf.setType(SearchField.CATEGORY);
		return sf;
	}
	public static SearchField getSearchFieldCategory(String title, String key, String indexerFieldName,String vocIdKey){
		SearchField sf = new SearchField();
		sf.setTitle(title);
		sf.setKey(key);
		sf.setIndexerFieldName(indexerFieldName);
		sf.setVocIdKey(vocIdKey);
		sf.setType(SearchField.CATEGORY);
		return sf;
	}
	public static SearchField getSearchFieldDropdown(String title, String key, String indexerFieldName){
		SearchField sf = new SearchField();
		sf.setTitle(title);
		sf.setKey(key);
		sf.setIndexerFieldName(indexerFieldName);
		sf.setType(SearchField.DROPDOWN);
		return sf;
	}
	public static SearchField getSearchField(String title, String key, int type){
		SearchField sf = new SearchField();
		sf.setTitle(title);
		sf.setKey(key);
		sf.setType(type);
		return sf;
	}
}
