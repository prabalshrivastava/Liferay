package com.sambaash.platform.pe.cache;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.jaxb.PEForm;
import com.sambaash.platform.pe.jaxb.PEFormV2;
import com.sambaash.platform.pe.jaxb.PEProcessDefinition;
import com.sambaash.platform.pe.jaxb.PEProcessableNode;
import com.sambaash.platform.pe.xml.converters.PEPDUnmarshaller;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;

public class PEProcessDirectory implements Serializable {

	private static Log _log = LogFactoryUtil.getLog(PEProcessDirectory.class);
	private PEProcessDefinition processDefinition;
	private long processId;
	private Map<Long, PEProcessableNode> nodeDirectory;
	private PEProcess process;
	private PEForm firstForm;
	private PEFormV2 firstFormV2;
	
	// list of submitters of various forms. Each form can be submitted by different role 
	private List<Long> submitterRoleIds;

	// list of approvers of various statuses. Each step/status can be approved by different role
	private List<Long> approverRoleIds;
	
	private PEProcessDirectoryHelper helper;

	private PEProcessDirectory(PEProcess process, PEProcessDefinition pd, Map<Long, PEProcessableNode> nodeDir)
			throws PEConfigException {
		if (process == null || Validator.isNull(pd) || Validator.isNull(nodeDir)) {
			throw new PEConfigException(PEErrors.CONFIG_ERROR_PROCESS_DEFINITON);
		}

		this.processId = process.getSpPEProcessId();
		this.processDefinition = pd;
		this.nodeDirectory = nodeDir;
		this.process = process;
		
		this.helper = PEProcessDirectoryHelper.getPEDirectoryHelper(this);
		this.submitterRoleIds = helper.getFormAndJspSubmitters();
		this.approverRoleIds = helper.getStatusApprovers();
		this.firstForm = helper.getFirstForm();
		this.firstFormV2 = helper.getFirstFormV2();

		// prepareDirectory();

	}

	public PEProcessDefinition getProcessDefinition() {
		return processDefinition;
	}

	public void setProcessDefinition(PEProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	}

	public long getProcessId() {
		return processId;
	}

	public void setProcessId(long processId) {
		this.processId = processId;
	}

	public Map<Long, PEProcessableNode> getNodeDirectory() {
		return nodeDirectory;
	}

	public void setNodeDirectory(Map<Long, PEProcessableNode> nodeDirectory) {
		this.nodeDirectory = nodeDirectory;
	}

	public PEProcessableNode getNode(long nodeId) {
		return nodeDirectory.get(nodeId);
	}

	public PEProcessableNode getStartNode() {
		return getNode(processDefinition.getStartNodeId());
	}

	public long getStartNodeId() {
		return processDefinition.getStartNodeId();
	}

	public static PEProcessDirectory loadPD(long processId) throws JAXBException, PEConfigException {
		PEProcess process = null;
		try {
			process = PEProcessLocalServiceUtil.getPEProcess(processId);
		} catch (PortalException | SystemException e) {
			_log.error(e);
			throw new PEConfigException(PEErrors.PROCESS_DEFINITON_NOT_FOUND);
		}

		String pdStr = process.getDefiniton();
		_log.debug("Unmarshalling about to start. Definiton xml= " + pdStr);
		Map<String, Object> result = PEPDUnmarshaller.unmarshall(pdStr);
		PEProcessDefinition pd = (PEProcessDefinition) result.get("pd");
		Map<Long, PEProcessableNode> nodeDir = (Map<Long, PEProcessableNode>) result.get("nodedir");
		_log.debug("Unmarshlling done.");
		return new PEProcessDirectory(process, pd, nodeDir);
	}
	
	public long getNodeIdForFieldId(String fieldId){
		return helper.getNodeIdForFieldId(fieldId);
	}
	
	public PEProcess getProcess() {
		return process;
	}

	public void setProcess(PEProcess process) {
		this.process = process;
	}

	public List<Long> getSubmitterRoleIds() {
		return submitterRoleIds;
	}

	public void setSubmitterRoleIds(List<Long> submitterRoleIds) {
		this.submitterRoleIds = submitterRoleIds;
	}

	public List<Long> getApproverRoleIds() {
		return approverRoleIds;
	}

	public void setApproverRoleIds(List<Long> approverRoleIds) {
		this.approverRoleIds = approverRoleIds;
	}
	
	public PEForm getFirstForm(){
		return firstForm;
	}

	public PEFormV2 getFirstFormV2() {
		return firstFormV2;
	}
	
}