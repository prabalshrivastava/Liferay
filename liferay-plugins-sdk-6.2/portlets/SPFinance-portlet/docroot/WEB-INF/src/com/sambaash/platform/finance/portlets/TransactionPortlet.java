package com.sambaash.platform.finance.portlets;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.finance.ajax.ArchiveActionHandler;
import com.sambaash.platform.finance.ajax.CreateActionHandler;
import com.sambaash.platform.finance.ajax.DownloadPdfActionHandler;
import com.sambaash.platform.finance.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.finance.ajax.ExportListActionHandler;
import com.sambaash.platform.finance.ajax.ExportPaymentAdvicePDFActionHandler;
import com.sambaash.platform.finance.ajax.ExportPaymentAdviceExcelActionHandler;
import com.sambaash.platform.finance.ajax.ExportPdfActionHandler;
import com.sambaash.platform.finance.ajax.ExportRowActionHandler;
import com.sambaash.platform.finance.ajax.FetchActionHandler;
import com.sambaash.platform.finance.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.finance.ajax.FetchMiscFeeSchemeListActionHandler;
import com.sambaash.platform.finance.ajax.TransactionFilterActionHandler;
import com.sambaash.platform.finance.ajax.FileDownloadActionHandler;
import com.sambaash.platform.finance.ajax.FileUploadActionHandler;
import com.sambaash.platform.finance.ajax.FilterColumnListActionHandler;
import com.sambaash.platform.finance.ajax.LoadListActionHandler;
import com.sambaash.platform.finance.ajax.ProcessTransactionActionHandler;
import com.sambaash.platform.finance.ajax.SearchListActionHandler;
import com.sambaash.platform.finance.ajax.WorkFlowActionHandler;
import com.sambaash.platform.finance.ajax.SendNotificationActionHandler;
import com.sambaash.platform.finance.ajax.SendRequestActionHandler;
import com.sambaash.platform.finance.constants.FinanceConstants;

/**
 * Portlet implementation class TransactionDocumentPortlet
 */
public class TransactionPortlet extends MVCPortlet {
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", CreateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("process", ProcessTransactionActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData", FetchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchFormFields", FetchFormFieldsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadList", LoadListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("archive", ArchiveActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("searchList", SearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchList", ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("filterColumnList", FilterColumnListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportRow", ExportRowActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportList", ExportListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("preparePdf", ExportPdfActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("downloadPdf", DownloadPdfActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("upload", FileUploadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fileDownload", FileDownloadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchReceiptInfo", TransactionFilterActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchMiscFeeSchemeList", FetchMiscFeeSchemeListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("processWorkflow", WorkFlowActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("sendNotification", SendNotificationActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("sendRequest", SendRequestActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportPaymentAdvicePdf", ExportPaymentAdvicePDFActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportPaymentAdviceExcel", ExportPaymentAdviceExcelActionHandler.class);
	}
	/**
	 * This is an object of Log class
	 */
	private Log log = LogFactoryUtil.getLog(ChartOfAccountsPortlet.class.getName());

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			boolean multipart = ServletFileUpload.isMultipartContent(PortalUtil.getHttpServletRequest(resourceRequest));
			String action = ParamUtil.getString(resourceRequest, "action");
			if (multipart && org.apache.commons.lang.StringUtils.isEmpty(action)) {
				action = "upload";
			}
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletPreferences preferences = actionRequest.getPreferences();
		String formId = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_HTML_FORM_ID, "0");
		String style = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_CONTAINER_STYLE, "");
		String modelName = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_MODEL_NAME, "0");
		String baseUrl = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_BASE_URL, "");
		String categoryType = ParamUtil.getString(actionRequest, FinanceConstants.PREF_CATEGORY_TYPE, "");
		String invoiceType = ParamUtil.getString(actionRequest, FinanceConstants.PREF_INVOICE_TYPE, "");
		String sendNotification = ParamUtil.getString(actionRequest, FinanceConstants.PREF_SEND_NOTIFICATION, "");
		String enableApproval = ParamUtil.getString(actionRequest, FinanceConstants.PREF_ENABLE_APPROVAL, "");
		String listHeader = ParamUtil.getString(actionRequest, FinanceConstants.PREF_LIST_HEADER, "");
		String showPending = ParamUtil.getString(actionRequest, FinanceConstants.PREF_SHOW_PENDING, "false");
		try {
			preferences.setValue(SystemSetupConstants.PREF_HTML_FORM_ID, formId);
			preferences.setValue(SystemSetupConstants.PREF_CONTAINER_STYLE, style);
			preferences.setValue(SystemSetupConstants.PREF_MODEL_NAME, modelName);
			preferences.setValue(SystemSetupConstants.PREF_BASE_URL, baseUrl);
			preferences.setValue(FinanceConstants.PREF_CATEGORY_TYPE, categoryType);
			preferences.setValue(FinanceConstants.PREF_INVOICE_TYPE, invoiceType);
			preferences.setValue(FinanceConstants.PREF_SEND_NOTIFICATION, sendNotification);
			preferences.setValue(FinanceConstants.PREF_ENABLE_APPROVAL, enableApproval);
			preferences.setValue(FinanceConstants.PREF_LIST_HEADER, listHeader);
			preferences.setValue(FinanceConstants.PREF_SHOW_PENDING, showPending);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException | ValidatorException | IOException | PortletModeException e) {
			log.error(e);
		}
	}
}
