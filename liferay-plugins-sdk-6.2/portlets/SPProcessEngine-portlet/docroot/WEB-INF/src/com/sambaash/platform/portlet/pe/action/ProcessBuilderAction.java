package com.sambaash.platform.portlet.pe.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.portlet.pe.action.ajax.PEPriceSubSchemesHandler;
import com.sambaash.platform.portlet.pe.action.ajax.PEProcessEntityListHandler;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;

public class ProcessBuilderAction extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(ProcessBuilderAction.class);
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("getPKs", PEProcessEntityListHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("getPriceSubSchemes", PEPriceSubSchemesHandler.class);
	}

	@ProcessAction(name = "mvcPath")
	public void addEntry(ActionRequest request, ActionResponse response) throws IOException, PortletException {
	}

	// On click of update button...
	public void dispayUpdate(ActionRequest request, ActionResponse response) {

		long processId = ParamUtil.getLong(request, "processId");
	}

	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		List<PEProcess> peprocess = null;

		try {
			peprocess = PEProcessLocalServiceUtil.getPEProcesses(-1, -1);
		} catch (SystemException e) {
			_log.error(e);
		}

		request.setAttribute("listOfProcess", peprocess);
		super.render(request, response);
	}

	@Override
	public void serveResource(ResourceRequest req, ResourceResponse res) {

		try {
			String action = req.getResourceID();
			_log.info("resource id is " + req.getResourceID());
			switch (action) {

			case "addNewProcess":
				ProcessBuilderActionHelper.addProcess(req, res);
				break;
			case "addNewProcessStatusType":
				ProcessBuilderActionHelper.addProcessStatusType(req, res);
				break;
			case "SaveProcess":
				ProcessBuilderActionHelper.saveProcess(req, res);
				break;
			case "retriveNodeSkelton":
				ProcessBuilderActionHelper.prepareDesignerData(req, res);
				break;
			case "retriveModelPopupDropDownList":
				ProcessBuilderActionHelper.prepareModalDropDownData(req, res);
				break;
			case "retriveRuleSetId":
				ProcessBuilderActionHelper.prepareRuleSetId(req, res);
				break;
			case "retriveEntities":
				ProcessBuilderActionHelper.prepareEntities(req, res);
				break;
			case "retriveSchedules":
				ProcessBuilderActionHelper.prepareSchedules(req, res);
				break;
			case "retriveSubProductType":
				ProcessBuilderActionHelper.prepareSubProductType(req, res);
				break;
			case "retriveProductType":
				ProcessBuilderActionHelper.prepareProductType(req, res);
				break;
			case "retriveProcess":
				ProcessBuilderActionHelper.prepareProcess(req, res);
				break;
			case "retriveProcessDetail":
				ProcessBuilderActionHelper.loadProcessDetailInToResponseObj(req, res);
				break;
			case "retriveStatusTypeDetail":
				ProcessBuilderActionHelper.loadStatusTypeDetailInToResponseObj(req, res);
				break;
			case "editProcess":
				ProcessBuilderActionHelper.editProcess(req, res);
				break;
			case "copyProcess":
				ProcessBuilderActionHelper.copyProcess(req, res);
				break;
			case "editStatusType":
				ProcessBuilderActionHelper.editProcessStatusType(req, res);
				break;
			case "retrieveTableData":
				ProcessBuilderActionHelper.retrieveTableData(req, res);
				break;
			case "validateEmailAddress":
				ProcessBuilderActionHelper.validateEmailAddress(req, res);
				break;
			default:
				SERVE_RESOURCE_MANAGER.newHandler(action).handle(req, res);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}
}