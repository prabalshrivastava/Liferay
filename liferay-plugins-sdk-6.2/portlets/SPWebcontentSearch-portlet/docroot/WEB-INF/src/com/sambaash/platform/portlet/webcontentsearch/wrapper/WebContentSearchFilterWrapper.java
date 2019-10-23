package com.sambaash.platform.portlet.webcontentsearch.wrapper;

import java.util.List;

import com.liferay.portlet.asset.model.AssetCategory;

public class WebContentSearchFilterWrapper {
	
	public List<AssetCategory> assetCategory;

	public String selectionType;
	
	public String vocabularyId;
	
	public String vocabularyName;
	
	public String catgName;
	
	public String catgDesc;
	
	public String catgId;
	
	
	public WebContentSearchFilterWrapper() {
		super();
	}

	public WebContentSearchFilterWrapper(List<AssetCategory> assetCategory, String selectionType, String vocabularyId, String vocabularyName,String catgName, String catgDesc, String catgId) {
		super();
		this.assetCategory = assetCategory;
		this.selectionType = selectionType;
		this.vocabularyId = vocabularyId;
		this.vocabularyName = vocabularyName;
		this.catgName = catgName;
		this.catgDesc = catgDesc;
		this.catgId = catgId;
	}

	public List<AssetCategory> getAssetCategory() {
		return assetCategory;
	}

	public void setAssetCategory(List<AssetCategory> assetCategory) {
		this.assetCategory = assetCategory;
	}

	public String getSelectionType() {
		return selectionType;
	}

	public void setSelectionType(String selectionType) {
		this.selectionType = selectionType;
	}
	
	public String getVocabularyName() {
		return vocabularyName;
	}

	public void setVocabularyName(String vocabularyName) {
		this.vocabularyName = vocabularyName;
	}

	public String getVocabularyId() {
		return vocabularyId;
	}

	public void setVocabularyId(String vocabularyId) {
		this.vocabularyId = vocabularyId;
	}

	public String getCatgName() {
		return catgName;
	}

	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}

	public String getCatgDesc() {
		return catgDesc;
	}

	public void setCatgDesc(String catgDesc) {
		this.catgDesc = catgDesc;
	}

	public String getCatgId() {
		return catgId;
	}

	public void setCatgId(String catgId) {
		this.catgId = catgId;
	}

}
