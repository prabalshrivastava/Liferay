package com.sambaash.platform.pe.actions;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.convert.PEConvertApplicationHelper;
import com.sambaash.platform.pe.convert.RegisterInterestDS;
import com.sambaash.platform.pe.exception.PEConfigException;
import com.sambaash.platform.pe.exception.PEProcessStateException;
import com.sambaash.platform.pe.jaxb.PECustomActionNode;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;

/**
 * This action is used to convert one application of one process to another process 
 * 
 * Configuration data takes below format
   {
	    nodeId: 1,
	    dataSrc: form/jsp/etc..,
	    fieldMap :[
	       {
	          srcField :"",
	          destField :"",
	          type:""
	       }
	    ]
	}
 * @author nareshchebolu
 *
 */
public class CourseEnrollConversionAction extends PECustomActionImpl{
	
	public CourseEnrollConversionAction(PEDataSource ds,
			PECustomActionNode actionNode) {
		super(ds, actionNode);
	}
	
	@Override
	public PEActionResult perform() {
		
		JSONObject config;
		try {
			config = JSONFactoryUtil.createJSONObject(actionNode.getConfiguration());
		} catch (JSONException e) {
			_log.error(e);
			return getActionResultFailure("Error while converting to opportunity. Invalid Configuration data");
		}
		long jspNodeId = config.getLong("nodeId");
		PEJSP jsp = (PEJSP)ds.getDirectory().getNode(jspNodeId);
		RegisterInterestDS rsDS= new RegisterInterestDS(ds, jsp);
		
		long productId  = GetterUtil.getLong(rsDS.getValue("productId"));
		//TODO: remove below lines.
		
	//	long targetProductId = GetterUtil.getLong(config.getString("targetEntityId"));
		Product product = null;
		try {
			product = ProductLocalServiceUtil.getProduct(productId);
		} catch (PortalException | SystemException e) {
			_log.error("Product Id " + productId,e);
			//TODO: Temporaryly commented below line. have to undo..
			//return getActionResultFailure("Error while converting to opportunity. Invalid Product");
		}
		PEConvertApplicationHelper helper = PEConvertApplicationHelper.getInstance(ds, rsDS, config, product.getPEProcessId(),PEConstantsGlobal.PROCESS_DEFAULT_ENTITY, productId);
		try {
			helper.convert(true);
		} catch (PEConfigException | FileNotFoundException | PortalException
				| SystemException | PEProcessStateException | JAXBException e) {
			_log.error(e);
			return getActionResultFailure("Error while converting to opportunity. ");
		}
		return getActionResultSuccess();
	}
	
	private static Log _log = LogFactoryUtil.getLog(CourseEnrollConversionAction.class.getName());
}
