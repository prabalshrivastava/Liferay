package com.sambaash.platform.pe.actions;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.jaxb.PECustomActionNode;

public abstract class PECustomActionImpl implements PECustomAction{

	final protected PEDataSource ds;
	final protected PECustomActionNode actionNode;
	
	public PECustomActionImpl(PEDataSource ds,PECustomActionNode actionNode){
		this.ds = ds;
		this.actionNode = actionNode;
	}
	
	public PEActionResult getActionResultSuccess(){
		PEActionResult actionResult = new PEActionResult();
		return actionResult;
	}
	
	public PEActionResult getActionResultFailure(String errMsg){
		PEActionResult actionResult = new PEActionResult();
		actionResult.addValidationMsg(errMsg);
		return actionResult;
	}
}
