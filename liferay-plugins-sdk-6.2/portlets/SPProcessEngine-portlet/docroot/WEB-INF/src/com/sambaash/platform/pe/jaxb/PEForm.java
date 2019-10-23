package com.sambaash.platform.pe.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.handlers.PEFormHandler;
import com.sambaash.platform.pe.handlers.PENodeHandler;
import com.sambaash.platform.pe.helpers.PERuleSetHelper;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;
public class PEForm extends PEDataSubmittableMultiOutputNode implements PEDisplayable {

	@Override
	public void fillOutput(PEOutput output) {
		long formId;
		try {
			formId = PERuleSetHelper.getFormId(getRuleSetId());
			output.setHeading(name);
			output.setId(formId);
		} catch (PEException e) {
			output.setError(e.getError());
		}
	}

	public long getFormId() throws PortalException, SystemException{
		PERuleSet ruleSet = PERuleSetLocalServiceUtil.getPERuleSet(getRuleSetId());
		long formId = GetterUtil.getLong(ruleSet.getComponentId());
		return formId;
	}
	public PEDataMapping getDataMapping() {
		return dataMapping;
	}

	public String getName() {
		return name;
	}

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.FORM;
	}

	@Override
	public PENodeType getNodeType() {
		return PENodeType.DATA_COLLECTING;
	}

	@Override
	public boolean isDisplayable() {
		return true;
	}

	@Override
	public PEProcessableNodeOutput process(PEProcessState processState, PEDataSource ds) {
		PEProcessableNodeOutput output = null;
		try {
			PENodeHandler handler = new PEFormHandler(this, ds);
			output = handler.process();
		}catch (Exception ex) {
			output = new PEProcessableNodeOutput();
			output.setError(ex);
		}

		return output;
	}

	@XmlElement(name ="dataMapping")
	public void setDataMapping(PEDataMapping dataMapping) {
		this.dataMapping = dataMapping;
	}

	@XmlElement(name ="name")
	public void setName(String name) {
		this.name = name;
	} 
	
	public String getFormFieldIdForProcessField(String processFieldId){
		PEDataMapping mapping  = getDataMapping();
		List<PEDataMappingElement> list = mapping.getElmnts();
		for (PEDataMappingElement element : list) {
			if(processFieldId.equals(element.getProcessFieldId())){
				return   element.getFieldId();
			}
		}
		return StringPool.BLANK;
	
	}

	private String name;
	private PEDataMapping dataMapping;
}