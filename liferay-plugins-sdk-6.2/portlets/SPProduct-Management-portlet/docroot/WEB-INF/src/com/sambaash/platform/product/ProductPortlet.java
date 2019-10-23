package com.sambaash.platform.product;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.action.ajax.ArchiveActionHandler;
import com.sambaash.platform.action.ajax.CreateActionHandler;
import com.sambaash.platform.action.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.action.ajax.ExportListActionHandler;
import com.sambaash.platform.action.ajax.ExportRowActionHandler;
import com.sambaash.platform.action.ajax.FetchActionHandler;
import com.sambaash.platform.action.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.action.ajax.FileDownloadActionHandler;
import com.sambaash.platform.action.ajax.FileUploadActionHandler;
import com.sambaash.platform.action.ajax.FileUploadS3ActionHandler;
import com.sambaash.platform.action.ajax.FilterColumnListActionHandler;
import com.sambaash.platform.action.ajax.GetTemplateFormsActionHandler;
import com.sambaash.platform.action.ajax.LoadListActionHandler;
import com.sambaash.platform.action.ajax.SavePreferenceActionHandler;
import com.sambaash.platform.action.ajax.SearchListActionHandler;
import com.sambaash.platform.action.ajax.SendRequestActionHandler;

/**
 * Portlet implementation class SubjectSetup
 */
public class ProductPortlet extends MVCPortlet {

	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", CreateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData", FetchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchFormFields", FetchFormFieldsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadList", LoadListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("archive", ArchiveActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("searchList", SearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchList", ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("getTemplateForms", GetTemplateFormsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("savePreference", SavePreferenceActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("filterColumnList", FilterColumnListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportRow", ExportRowActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportList", ExportListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("upload", FileUploadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("uploadS3", FileUploadS3ActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fileDownload", FileDownloadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("sendRequest", SendRequestActionHandler.class);
	}
	/**
	 * This is an object of Log class
	 */
	private Log log = LogFactoryUtil.getLog(ProductPortlet.class.getName());

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			
			boolean multipart = ServletFileUpload.isMultipartContent(PortalUtil.getHttpServletRequest(resourceRequest));
			String action = ParamUtil.getString(resourceRequest, "action");
			if (multipart && (action.equalsIgnoreCase(StringPool.BLANK))) {
				action = "upload";
			}
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
