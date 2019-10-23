package com.sambaash.platform.model.spneo4j.wrapper;

import java.io.Serializable;

public class AssetCategoryGraphWrapper extends BaseGraphWrapper implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long categoryId;
	
	private String name;
	
	private long vocabularyId;

	public AssetCategoryGraphWrapper() {
		
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getVocabularyId() {
		return vocabularyId;
	}

	public void setVocabularyId(long vocabularyId) {
		this.vocabularyId = vocabularyId;
	}

}
