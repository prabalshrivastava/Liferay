package com.sambaash.platform.portlet.legalandcontract.search;

import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;

public class SearchField implements Comparable {
	
	public static final int TEXT = 1;
	public static final int CATEGORY = 2;
	public static final int DROPDOWN = 3;
	public static final int DATE_RANGE = 4;
	
	private  String title;
	private  String key;
	private  String indexerFieldName;
	private  int type;
	private  long vocId;
	private  String vocIdKey;
	private  String listId;
	
	public SearchField(){
		
	}
	public long getVocId() {
		return vocId;
	}
	public void setVocId(long vocId) {
		this.vocId = vocId;
	}
	public SearchField(String title, String key){
		this.title = title;
		this.key = key;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getVocIdKey() {
		return vocIdKey;
	}
	public void setVocIdKey(String vocIdKey) {
		this.vocIdKey = vocIdKey;
	}

	public String getListId() {
		return listId;
	}
	public void setListId(String listId) {
		this.listId = listId;
	}
	public String getIndexerFieldName() {
		return indexerFieldName;
	}
	public void setIndexerFieldName(String indexerFieldName) {
		this.indexerFieldName = indexerFieldName;
	}
	@Override
	public int compareTo(Object o) {
		try{
			if(TrademarksConstants.ALL_SEARCH_COLUMN.equalsIgnoreCase(this.getTitle())){
				return -1;
			}
			return this.getTitle().compareTo(((SearchField)o).getTitle());
		}catch(Exception ex){
			
		}
		// TODO Auto-generated method stub
		return 0;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public boolean isCategoryField(){
		return type == CATEGORY;
	}
	public boolean isDropdownField(){
		return type == DROPDOWN;
	}
	public boolean isDateRangeField(){
		return type == DATE_RANGE;
	}
}
