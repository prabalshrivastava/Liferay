package com.sambaash.platform.genericsearch.model;

import java.util.List;

import com.liferay.portal.kernel.util.Validator;

public class GenericSearchFilter implements Comparable<GenericSearchFilter> {

	public static final String SELECT_SINGLE = "select-single";
	public static final String SELECT_MULTIPLE = "select-muliple";
	public static final String SELECT_RATINGS = "select-rating";
	public static final String SELECT_AGERANGE = "select-agerange";
	public static final String SELECT_DATES = "select-dates";
	public static final String SELECT_VOCABULARIES = "select-vocabularies";
	public static final String SELECT_API = "select-api";
	public static final String SELECT_NONE = "select-none";
	
	public static final String TYPE_TAG = "tag";
	public static final String TYPE_FIELD = "field";
	public static final String TYPE_VOCAB = "vocab";

	// startup, challenge, common
	private String component;
	private String componentClass;
	// vocabId, field, tag
	private String type;
	private String apiList;
	private int level;



	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getApiList() {
		return apiList;
	}

	public void setApiList(String apiList) {
		this.apiList = apiList;
	}

	private String selection;
	public String getSelection() {
		return selection;
	}

	public void setSelection(String subType) {
		this.selection = subType;
	}

	// single multiple
	private String displayCount;
	private String config;
	public String getConfig() {
		return config;
	}

	public void setConfig(String text) {
		this.config = text;
	}

	// vocabId if type == vocab
	private Long vocabId;
	// vocabId if type == vocabulary
	private Long fieldVocabularyId;
	public Long getFieldVocabularyId() {
		return fieldVocabularyId;
	}

	public void setFieldVocabularyId(Long fieldVocabularyId) {
		this.fieldVocabularyId = fieldVocabularyId;
	}

	// indexed field if type == field
	private String field;
	// should the filter option be shown to the user
	private boolean display;
	// preselected values
	private List<String> values;
	// operator for 'values'
	private String operator;
	// position of search filter
	private int position;
	// label for the row.
	private String label;

	// filterId : unique id for every filter.
	private int filterId;
	public int getFilterId() {
		return filterId;
	}

	public void setFilterId(int filterId) {
		this.filterId = filterId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (Validator.isNotNull(type))
			this.type = type.trim();
	}

	public String getDisplayCount() {
		return displayCount;
	}

	public void setDisplayCount(String displayCount) {
		if (Validator.isNotNull(displayCount))
			this.displayCount = displayCount;
	}

	public Long getVocabId() {
		return vocabId;
	}

	public void setVocabId(Long vocabId) {
		this.vocabId = vocabId;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		if (Validator.isNotNull(field))
			this.field = field;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		if (Validator.isNotNull(component))
			this.component = component;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		if (Validator.isNotNull(label))
			this.label = label;
	}

	@Override
	public int compareTo(GenericSearchFilter o) {
		return position - o.getPosition();
	}

	@Override
	public String toString() {
		return "GenericSearchFilter [component=" + component + ", type=" + type
				+ ", apiList=" + apiList + ", selection=" + selection + ", level=" + level
				+ ", displayCount=" + displayCount + ", config=" + config
				+ ", vocabId=" + vocabId + ", fieldVocabularyId="
				+ fieldVocabularyId + ", field=" + field + ", display="
				+ display + ", values=" + values + ", operator=" + operator
				+ ", position=" + position + ", label=" + label + ", filterId="
				+ filterId + "]";
	}

	public String getComponentClass() {
		return componentClass;
	}

	public void setComponentClass(String componentClass) {
		this.componentClass = componentClass;
	}

}
