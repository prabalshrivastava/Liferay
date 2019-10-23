package com.sambaash.platform.pe.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.handlers.PEFormV2Handler;
import com.sambaash.platform.pe.handlers.PENodeHandler;
import com.sambaash.platform.pe.helpers.PERuleSetHelper;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
public class PEFormV2 extends PEDataSubmittableMultiOutputNode implements PEDisplayable {

	private String name;
	private PEDataMapping dataMapping;
	
	@Override
	public void fillOutput(PEOutput output) {
		long formId;
		try {
			formId = PERuleSetHelper.getFormV2Id(getRuleSetId());
			output.setHeading(name);
			output.setFormV2Id(formId);
		} catch (PEException e) {
			output.setError(e.getError());
		}
	}

	public long getFormId() throws PEException {
		return PERuleSetHelper.getFormV2Id(getRuleSetId());
	}
	
	public PEDataMapping getDataMapping() {
		return dataMapping;
	}

	public String getName() {
		return name;
	}

	@Override
	public PENodeSubType getNodeSubType() {
		return PENodeSubType.FORMV2;
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
			PENodeHandler handler = new PEFormV2Handler(this, ds);
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

}