package com.sambaash.platform.pe.handlers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.actions.PEActionResult;
import com.sambaash.platform.pe.actions.PECustomAction;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.jaxb.PECustomActionNode;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
import com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo;
import com.sambaash.platform.srv.processbuilder.service.PECustomActionInfoLocalServiceUtil;
public class PECustomActionHandler extends PESingleOutputNodeHandler {

	public PECustomActionHandler(PECustomActionNode node, PEDataSource ds) {
		super(node, ds);
	}

	@Override
	public PEProcessableNodeOutput process() throws SystemException, PEException {
		PECustomActionNode actionNode = (PECustomActionNode)node;
		
		PEProcessableNodeOutput output = new PEProcessableNodeOutput();
//		output.setNextNodeId(actionNode.getNextNodeId());
		proceedToNextNode(output, actionNode.getNextNodeId(), false);

		PECustomActionInfo info = null;
		try {
			info = PECustomActionInfoLocalServiceUtil.getPECustomActionInfo(actionNode.getActionClassId());
		} catch (PortalException e) {
			_log.error("Error while getting custom action class. Action Class Info Id = " + actionNode.getActionClassId(),e);
			throw new PEConfigException(PEErrors.CUSTOM_ACTION_CLASS_NOT_FOUND);
		}
		Constructor<PECustomAction> cons = null;
		try {
			 @SuppressWarnings("unchecked")
		 	 Class<PECustomAction> actionClass  = (Class<PECustomAction>) Class.forName(info.getActionClassName());
			 cons = actionClass.getConstructor(PEDataSource.class, PECustomActionNode.class);
			 
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			_log.error("Error while loading the class =  " + info.getActionClassName(),e);
			throw new PEConfigException(PEErrors.CUSTOM_ACTION_CLASS_NOT_FOUND);
		} 
		
		PECustomAction action  = null;
		try {
			 action = (PECustomAction)cons.newInstance(ds,actionNode);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			_log.error("Error while creating cusom aciton class object",e);
			 throw new PEException("Error while processing your request");
		}
		
		PEActionResult actionResult = action.perform();
		if(actionResult.errorExists()){
			output.setValidationMsgs(actionResult.getValidationMsgs());
			output.setError(actionResult.getError());
			return output;
		}
		
		try {
			PEAuditHelper audit = ds.getAuditHelper();
		}catch (Exception ex) {
			output.setError(PEErrors.AUDIT_STATUS);
		}

		return output;
	}

	

	
	private static Log _log = LogFactoryUtil.getLog(PECustomActionHandler.class);
}