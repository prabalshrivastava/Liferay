package com.sambaash.platform.portlet.pe.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.pe.PEEntity;
import com.sambaash.platform.pe.PEEntityField;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.helpers.PEEntityHelper;
import com.sambaash.platform.pe.helpers.PEHelper;
import com.sambaash.platform.srv.processbuilder.model.PERule;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PERuleLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;

public class FormsRepositoryAction extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(FormsRepositoryAction.class.getName());

	@ProcessAction(name = "mvcPath")
	public void addEntry(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {

	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		List<PERuleSet> ruleList = null;

//		try {
//			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//			JSONArray jsonArray = FormBuilderLocalServiceUtil.getFormsList(themeDisplay.getUserId());
//			_log.error(jsonArray);
//			ruleList = PERuleSetLocalServiceUtil.getPERuleSets(-1, -1);
//
//		} catch (SystemException e) {
//			_log.error("Error in forms list", e);
//		}
//
//		request.setAttribute("rules", ruleList);
		
		super.render(request, response);

	}

	@Override
	public void serveResource(ResourceRequest resourseRequest, ResourceResponse resourseResponse)
			throws IOException, PortletException {		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourseRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if(resourseRequest.getResourceID().equals("unlockHtmlForm")) {

			String htmlFormId = ParamUtil.getString(resourseRequest, "htmlFormId", StringPool.BLANK);
			Boolean lock = ParamUtil.getBoolean(resourseRequest, "lock", true);
			_log.error("HTML form id ... " + htmlFormId + " : lock : " +  lock);
			if(Validator.isNumber(htmlFormId)){
				FormBuilderLocalServiceUtil.submitFormData(Long.parseLong(htmlFormId), lock, themeDisplay.getUserId());
			}

		}
	}
	

	
	public static  DynamicQuery getSearchQuery(String searchText) {
	
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PERuleSet.class,
				PortletClassLoaderUtil.getClassLoader(PEConstants.PORTLET_ID));
		
		Criterion searchTextCriteria = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + searchText + StringPool.PERCENT);
		
		if  (Validator.isNotNull(searchText)){ 
			dynamicQuery.add(searchTextCriteria);
		}
		
		return dynamicQuery;
			
	}
		
}
	
