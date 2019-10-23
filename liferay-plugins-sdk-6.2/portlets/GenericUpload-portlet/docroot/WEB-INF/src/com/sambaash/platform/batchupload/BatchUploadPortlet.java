package com.sambaash.platform.batchupload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

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

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFileException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.batchupload.action.ajax.BatchUploadActionHandler;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.srv.genericupload.service.BatchUploadLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class BatchUploadPortlet
 */
public class BatchUploadPortlet extends MVCPortlet {
 
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("batchUpload", BatchUploadActionHandler.class);
	}
	/**
     * This is an object of Log class
     */
    private Log _log = LogFactoryUtil.getLog(BatchUploadPortlet.class.getName());
    
    
    
    @Override
    public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)throws  IOException, PortletException {
	    try {
	    	boolean multipart = ServletFileUpload.isMultipartContent(PortalUtil.getHttpServletRequest(resourceRequest));
			String action = ParamUtil.getString(resourceRequest, "action");
			if (multipart && org.apache.commons.lang.StringUtils.isEmpty(action)) {
				action = "batchUpload";
			}
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
	    }
	    catch (Exception e) {
	    	_log.error(e);
	    }
    	
//    	String resourceId = resourceRequest.getResourceID();
//        _log.info(resourceId);
//        if(resourceId != null && resourceId.equals("UPLOAD_FILE")){
//            uploadFile(resourceRequest, resourceResponse);
//        }
//        if(resourceId != null && resourceId.equals("FILES_LIST")){
//            listFiles(resourceRequest, resourceResponse);
//        }else{
//        	
//        }
    }
    private void listFiles(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException {
        StringBuilder responseText = new StringBuilder();
        String uploadDirectory = "tmp1";
		File uploadDirectoryObj = new File(uploadDirectory );
        if(uploadDirectoryObj.exists()){
            File[] files = uploadDirectoryObj.listFiles();
            responseText.append("<ul>");
            for(File file : files){
                responseText.append("<li>").append(file.getName()).append("</li>");
            }
            responseText.append("</ul>");
        }else{
            responseText.append("No File Found");
        }
        
        //sendResponse(resourceRequest, resourceResponse, responseText.toString());
    }
    private void uploadFile(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException {
        UploadRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
        File objFile = uploadRequest.getFile("myFile");
        String objFileName = uploadRequest.getFileName("myFile");
        _log.info("objFile: [" + objFile + "], objFileName: [" + objFileName + "]");        
        String uploadDirectory = "E:/myfiles/";

        File currentFile = new File(uploadDirectory);
        if (currentFile.exists()) {
            _log.info("Going to write the file contents");
            File newFile = new File(uploadDirectory + "/" + objFileName);
            OutputStream os = new FileOutputStream(newFile);
            InputStream is = new FileInputStream(objFile);
            
            byte[] buff = new byte[is.available()];
            is.read(buff);
            os.write(buff);
            is.close();
            os.close();
            
        }
    }   
	public void uploadFiles(ActionRequest actionRequest, ActionResponse actionResponse) {
		String response = BatchUploadLocalServiceUtil.handleBatchUploadFile(actionRequest, actionResponse);
		JSONObject data = null;
		String totalRecords = "0";
		String successfulRecords =  "0";
		String failedRecords =  "0";
		JSONArray invalidRecords = JSONFactoryUtil.createJSONArray();
		try {
			data = JSONFactoryUtil.createJSONObject(response).getJSONObject("data");
		} catch (JSONException e) {
			_log.error(e.getMessage());
		}
		totalRecords = data.getString("totalRecords");
		successfulRecords = data.getString("successfulRecords");
		failedRecords = data.getString("failedRecords");
		invalidRecords = data.getJSONArray("invalidRecords");
		actionResponse.setRenderParameter("totalRecords", String.valueOf(totalRecords));
		actionResponse.setRenderParameter("successfulRecords", String.valueOf(successfulRecords));
		actionResponse.setRenderParameter("failedRecords", String.valueOf(failedRecords));
		actionResponse.setRenderParameter("invalidRecords", invalidRecords.toString());
		actionResponse.setRenderParameter("pendingProcessing", "0");
		
		actionResponse.setRenderParameter("responsee", response);
		actionResponse.setRenderParameter("mvcPath", "/html/batchupload/uploadStat.jsp");
	}

	protected User addUser(String email, String name) {

		Date date = new Date();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setUuid(UUID.randomUUID().toString());
		serviceContext.setCreateDate(date);
		serviceContext.setModifiedDate(date);
		long companyId = PortalUtil.getDefaultCompanyId();
		long creatorUserId = 0;
		boolean autoPassword = false;
		boolean autoScreenName = false;
		boolean male = true;
		boolean sendEmail = false;
		int prefixId = 1;
		int suffixId = 1;
		int birthdayMonth = 1;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String screenName = name;
		String jobTitle = "";
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] userGroupIds = null;
		String password1 = "test";
		String password2 = "test";
		String firstName = name;
		String lastName = name;
		String emailAddress = email;
		long facebookId = 0;
		String openId = "";
		Locale locale = LocaleUtil.getDefault();
		Role rolePu;
		User user = null;
		try {
			rolePu = RoleLocalServiceUtil.getRole(companyId, RoleConstants.SITE_MEMBER);
			long[] roleIds = { rolePu.getRoleId() };

			user = UserLocalServiceUtil.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1,
					password2, autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, "",
					lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
					organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return user;
	}
	public void savePreferences(ActionRequest actionRequest,ActionResponse actionResponse)  {
		PortletPreferences preferences = actionRequest.getPreferences();
		String style = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_CONTAINER_STYLE, "");
		String modelName = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_MODEL_NAME, "0");
		String baseUrl = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_BASE_URL, "");
		try {
			preferences.setValue(SystemSetupConstants.PREF_CONTAINER_STYLE, style);
			preferences.setValue(SystemSetupConstants.PREF_MODEL_NAME, modelName);
			preferences.setValue(SystemSetupConstants.PREF_BASE_URL, baseUrl);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException | ValidatorException | IOException | PortletModeException e) {
			_log.error(e);
		}
		
	}
}
