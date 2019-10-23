package com.sambaash.gu.helper;

import java.util.LinkedHashMap;
import java.util.Map;

import com.liferay.portlet.asset.model.AssetVocabulary;

public class GUModal {

	private String name;
	private String sheetName;
	private boolean deleteThenCreate;
	private String formNodeId;
	private Map<String, GUField> fieldsMap;
	public GUModal(String name){
		this.name = name;
		fieldsMap = new LinkedHashMap<String, GUModal.GUField>();
	}
	
	public GUField getField(String fieldName){
		return fieldsMap.get(fieldName);
	}
	
	public void putField(String fieldName,GUField field){
		fieldsMap.put(fieldName, field);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public Map<String, GUField> getFieldsMap() {
		return fieldsMap;
	}
	public void setFieldsMap(Map<String, GUField> fieldsMap) {
		this.fieldsMap = fieldsMap;
	}
	
	public boolean isDeleteThenCreate() {
		return deleteThenCreate;
	}

	public void setDeleteThenCreate(boolean deleteThenCreate) {
		this.deleteThenCreate = deleteThenCreate;
	}
	
    public String getFormNodeId() {
		return formNodeId;
	}

	public void setFormNodeId(String formNodeId) {
		this.formNodeId = formNodeId;
	}
    
	public class GUField {
		private String fieldName;
		private String clmnName;
		private String defaultValue;
		private String vocabName;
		private AssetVocabulary assetVocabulary;
		private boolean createCatg; 
		private boolean key;
		private String linkedModal;
		private String linkedModalProperty;
		private boolean multiInstance;
		private boolean deleteCreateMultiInstance;
		
		private String documentType;
		private String srcPath;
		private String destinationPath;
		private String folderMatchingPath;
		private String formNodeId;
		private String arrayFieldName;
		
		// All System related fields must prefix with sys
		private String system_type; 
		
		public String getModalName() {
			return GUModal.this.name;
		}

		public String getSheetName() {
			return sheetName;
		}
		public GUField(String fieldName){
			this.fieldName = fieldName;
			
		}
		public String getFieldName() {
			return fieldName;
		}
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		public String getClmnName() {
			return clmnName;
		}
		public void setClmnName(String clmnName) {
			this.clmnName = clmnName;
		}
		public String getVocabName() {
			return vocabName;
		}
		public void setVocabName(String vocabName) {
			this.vocabName = vocabName;
		}
		public boolean isCreateCatg() {
			return createCatg;
		}
		public void setCreateCatg(boolean createCatg) {
			this.createCatg = createCatg;
		}
		public boolean isKey() {
			return key;
		}
		public void setKey(boolean key) {
			this.key = key;
		}
		public boolean isMultiInstance() {
			return multiInstance;
		}
		public void setMultiInstance(boolean multiInstance) {
			this.multiInstance = multiInstance;
		}
		public String getLinkedModal() {
			return linkedModal;
		}
		public void setLinkedModal(String linkedModal) {
			this.linkedModal = linkedModal;
		}
		public String getLinkedModalProperty() {
			return linkedModalProperty;
		}
		public void setLinkedModalProperty(String linkedModalProperty) {
			this.linkedModalProperty = linkedModalProperty;
		}
		public AssetVocabulary getAssetVocabulary() {
			return assetVocabulary;
		}
		public void setAssetVocabulary(AssetVocabulary assetVocabulary) {
			this.assetVocabulary = assetVocabulary;
		}
		public boolean isDeleteCreateMultiInstance() {
			return deleteCreateMultiInstance;
		}
		public void setDeleteCreateMultiInstance(boolean deleteCreateMultiInstance) {
			this.deleteCreateMultiInstance = deleteCreateMultiInstance;
		}

		public String getDocumentType() {
			return documentType;
		}

		public void setDocumentType(String documentType) {
			this.documentType = documentType;
		}

		public String getSrcPath() {
			return srcPath;
		}

		public void setSrcPath(String srcPath) {
			this.srcPath = srcPath;
		}

		public String getDestinationPath() {
			return destinationPath;
		}

		public void setDestinationPath(String destinationPath) {
			this.destinationPath = destinationPath;
		}

		public String getFolderMatchingPath() {
			return folderMatchingPath;
		}

		public void setFolderMatchingPath(String folderMatchingPath) {
			this.folderMatchingPath = folderMatchingPath;
		}

		public String getSystem_type() {
			return system_type;
		}

		public void setSystem_type(String system_type) {
			this.system_type = system_type;
		}

		public String getDefaultValue() {
			return defaultValue;
		}

		public void setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
		}

		public String getFormNodeId() {
			return formNodeId;
		}

		public void setFormNodeId(String formNodeId) {
			this.formNodeId = formNodeId;
		}

		public String getArrayFieldName() {
			return arrayFieldName;
		}

		public void setArrayFieldName(String arrayFieldName) {
			this.arrayFieldName = arrayFieldName;
		}
	}
}
