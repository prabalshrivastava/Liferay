package com.sambaash.platform.pe;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
public class PEOutput {

	public boolean errorExists() {
		boolean exists = (Validator.isNotNull(error) || validationMsgsExists());
		return exists;
	}

	public long getClassPk() {
		return classPk;
	}

	public String getCurrentStep() {
		return currentStep;
	}

	public String getEmailProcessUser() {
		return emailProcessUser;
	}

	public String getEntityName() {
		return entityName;
	}

	public PEError getError() {
		return error;
	}

	public String getFullNameProcessUser() {
		return fullNameProcessUser;
	}

	public String getHeading() {
		return heading;
	}

	public long getId() {
		return id;
	}

	public String getMsg() {
		return msg;
	}

	public String getName() {
		return name;
	}

	public long getNodeId() {
		return nodeId;
	}

	public long getProcessId() {
		return processId;
	}

	public PEProcessState getProcessState() {
		return processState;
	}

	public JSONArray getStatusTypes() {
		if (statusTypes == null) {
			statusTypes = JSONFactoryUtil.createJSONArray();
		}

		return statusTypes;
	}

	public long getStorageId() {
		return storageId;
	}

	public String getUrlToListPage() {
		return urlToListPage;
	}

	public List<String> getValidationMsgs() {
		if (Validator.isNull(this.validationMsgs)) {
			this.validationMsgs = new ArrayList<String>();
		}
		return this.validationMsgs;
	}

	public boolean isCanApprove() {
		return canApprove;
	}

	public boolean isCanSubmit() {
		return canSubmit;
	}

	public boolean isForm() {

		// if valid id exists, then it is form

		return getId() > 0;
	}

	public boolean isFormV2() {

		// if valid id exists, then it is form

		return getFormV2Id() > 0;
	}

	public boolean isJsp() {

		// if valid name exists, then it is jsp

		return Validator.isNotNull(getName());
	}

	public boolean isPayment() {
		return "payment".equals(getName());
	}

	public boolean isPaymentV2() {
		return "paymentV2".equals(getName());
	}

	public boolean isPricing() {
		return "pricing".equals(getName());
	}

	public boolean isMsg() {

		// if valid msg exists, then it is msg to display

		return Validator.isNotNull(getMsg());
	}

	public boolean isShowProcessProgress() {
		return showProcessProgress;
	}

	public void setCanApprove(boolean canApprove) {
		this.canApprove = canApprove;
	}

	public void setCanSubmit(boolean canSubmit) {
		this.canSubmit = canSubmit;
	}

	public void setClassPk(long classPk) {
		this.classPk = classPk;
	}

	public void setCurrentStep(String currentStep) {
		this.currentStep = currentStep;
	}

	public void setEmailProcessUser(String emailProcessUser) {
		this.emailProcessUser = emailProcessUser;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public void setError(PEError error) {
		this.error = error;
	}

	public void setFullNameProcessUser(String fullNameProcessUser) {
		this.fullNameProcessUser = fullNameProcessUser;
	}

	public void setHeading(String heading) {

		this.heading = heading;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public void setProcessId(long processId) {
		this.processId = processId;
	}

	public void setProcessState(PEProcessState processState) {
		this.processState = processState;
	}

	public void setShowProcessProgress(boolean showProcessProgress) {
		this.showProcessProgress = showProcessProgress;
	}

	public void setStatusTypes(JSONArray statusTypes) {
		this.statusTypes = statusTypes;
	}

	public void setStorageId(long storageId) {
		this.storageId = storageId;
	}

	public void setUrlToListPage(String urlToListPage) {
		this.urlToListPage = urlToListPage;
	}

	public void setValidationMsgs(List<String> validationMsgs) {
		this.validationMsgs = validationMsgs;
	}
	
	public void addValidationMsg(String message){
		if(Validator.isNotNull(message)){
			getValidationMsgs().add(message);
		}
	}

	public boolean validationMsgsExists() {
		boolean exists = (validationMsgs != null && !validationMsgs.isEmpty());
		return exists;
	}

	public boolean isAgent() {
		return isAgent;
	}

	public void setAgent(boolean isAgent) {
		this.isAgent = isAgent;
	}

	public PEDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(PEDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean isFromAudit() {
		return fromAudit;
	}

	public void setFromAudit(boolean fromAudit) {
		this.fromAudit = fromAudit;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSucessMsg() {
		return sucessMsg;
	}

	public void setSucessMsg(String sucessMsg) {
		this.sucessMsg = sucessMsg;
	}

	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}

	public PEProcessAudit getAudit() {
		return audit;
	}

	public void setAudit(PEProcessAudit audit) {
		this.audit = audit;
	}

	public JSONObject getDataJson() {
		return dataJson;
	}

	public void setDataJson(JSONObject dataJson) {
		this.dataJson = dataJson;
	}

	public long getClassNameId() {
		return classNameId;
	}

	public void setClassNameId(long classNameId) {
		this.classNameId = classNameId;
	}

	public User getLastSaveDoneBy() {
		return lastSaveDoneBy;
	}

	public void setLastSaveDoneBy(User lastSaveDoneBy) {
		this.lastSaveDoneBy = lastSaveDoneBy;
	}

	public String getLastSaveDateStr() {
		return lastSaveDateStr;
	}

	public void setLastSaveDateStr(String lastSaveDateStr) {
		this.lastSaveDateStr = lastSaveDateStr;
	}

	public long getFormV2Id() {
		return formV2Id;
	}

	public void setFormV2Id(long formV2Id) {
		this.formV2Id = formV2Id;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public boolean isShowHeader() {
		return showHeader;
	}

	public void setShowHeader(boolean showHeader) {
		this.showHeader = showHeader;
	}

	public boolean isEnableFirstStepProgress() {
		return enableFirstStepProgress;
	}

	public void setEnableFirstStepProgress(boolean enableFirstStepProgress) {
		this.enableFirstStepProgress = enableFirstStepProgress;
	}

	public boolean isReProcessing() {
		return reProcessing;
	}

	public void setReProcessing(boolean reProcessing) {
		this.reProcessing = reProcessing;
	}

	private boolean canApprove;
	private boolean canSubmit;
	private long classPk;
	private long classNameId;
	private String currentStep;
	private String emailProcessUser;
	private String entityName;

	private String fullNameProcessUser;


	private String heading;

	// represents formId or any other

	private long id;
	// form v2 ID
	private long formV2Id;

	private boolean isAgent;

	// Represents error caused by some exception. Mostly used for errors in the process
	private PEError error;
	// Can be used to add error / Validation messages. These messages are considered as errors.
	private List<String> validationMsgs; 
	// represents html to display. This html can come form either message node, or wait message of form/Jsp or by system for simple messages to display
	private String msg = StringPool.BLANK;
	// Any success message by system to display
	private String sucessMsg = StringPool.BLANK;
	// represent jsp name to load
	private String name = StringPool.BLANK;
	// represnts form or jsp's action like save or submit
	private String action = StringPool.BLANK;
	// Node Id coming from
	private long nodeId;
	private long processId;
	private PEProcessState processState;
	private boolean showProcessProgress;
	private JSONArray statusTypes;
	// form storage Id. When form is saved/submitted, storage id created for corresponding data.
	private long storageId;
	
	private String urlToListPage;
	
	private boolean fromAudit;
	
	private PEProcessAudit audit;

	// To check edit permission of form/jsp.
	private boolean canEdit;

	private PEDataSource dataSource;

	// to carry any json type data. For ex, during ajax requests this object helpful
	private JSONObject dataJson;
	
	// Last activity(save/submit) done by
	
	private User lastSaveDoneBy;
	private String lastSaveDateStr;
	private String orientation;
	private boolean showHeader;
	private boolean enableFirstStepProgress;
	private boolean reProcessing;
}