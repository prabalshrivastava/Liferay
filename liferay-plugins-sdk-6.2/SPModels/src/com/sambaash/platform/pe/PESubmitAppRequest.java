package com.sambaash.platform.pe;

import java.util.Map;

public class PESubmitAppRequest {
	private final long processId;
 	private final long entityId;
 	private final long userId;
 	private boolean supressMailNotifications;
 	private final long entityClassId;
 	
 	private final Map<String,PEFormField> formFields;
 	
 	public PESubmitAppRequest(long userId,long processId, long entityId, Map<String, PEFormField> fields, long entityClassId){
 		this.userId = userId;
 		this.processId = processId;
 		this.entityId = entityId;
 		this.formFields = fields;
 		this.entityClassId = entityClassId;
 	}

	public long getEntityClassId() {
		return entityClassId;
	}

	public long getProcessId() {
		return processId;
	}

	public long getEntityId() {
		return entityId;
	}

	public Map<String, PEFormField> getFields() {
		return formFields;
	}
	
	public PEFormField putField(String fieldId,String fieldValue){
		PEFormField field = formFields.get(fieldId);
		if(field == null){
			field = new PEFormField(fieldId);
		}
		field.addValue(fieldValue);;
		return formFields.put(fieldId, field);
	}

	public long getUserId() {
		return userId;
	}

	public Map<String, PEFormField> getFormFields() {
		return formFields;
	}

	public boolean isSupressMailNotifications() {
		return supressMailNotifications;
	}

	public void setSupressMailNotifications(boolean supressMailNotifications) {
		this.supressMailNotifications = supressMailNotifications;
	}
}
