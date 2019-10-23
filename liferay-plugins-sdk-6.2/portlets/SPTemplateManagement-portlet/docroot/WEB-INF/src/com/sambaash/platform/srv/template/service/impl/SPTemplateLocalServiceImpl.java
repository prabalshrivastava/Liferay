/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.template.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.TemplatePortlet;
import com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil;
import com.sambaash.platform.srv.template.model.SPComponentTemplate;
import com.sambaash.platform.srv.template.model.SPTemplate;
import com.sambaash.platform.srv.template.model.impl.SPComponentTemplateImpl;
import com.sambaash.platform.srv.template.model.impl.SPTemplateImpl;
import com.sambaash.platform.srv.template.service.SPComponentTemplateLocalServiceUtil;
import com.sambaash.platform.srv.template.service.SPTemplateLocalServiceUtil;
import com.sambaash.platform.srv.template.service.base.SPTemplateLocalServiceBaseImpl;
import com.sambaash.platform.srv.template.service.persistence.SPTemplateFinderUtil;
import com.sambaash.platform.util.TemplateUtil;

/**
 * The implementation of the s p template local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.template.service.SPTemplateLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author WattabyteIT
 * @see com.sambaash.platform.srv.template.service.base.SPTemplateLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.template.service.SPTemplateLocalServiceUtil
 */
public class SPTemplateLocalServiceImpl extends SPTemplateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.template.service.SPTemplateLocalServiceUtil} to
	 * access the s p template local service.
	 */
	private static Log log = LogFactoryUtil.getLog(SPTemplateLocalServiceImpl.class);
	public List<SPTemplate> findByTemplateName(String templateName) throws SystemException {
		return spTemplatePersistence.findByTemplateName(templateName);
	}

	public List getAllTemplates(String cur, String delta) {
		return SPTemplateFinderUtil.getAllTemplates(cur, delta);
	}
	public int getAllTemplatesCount() {
		return SPTemplateFinderUtil.getAllTemplatesCount();
	}

	public List getTemplateDetail(long templateId) {
		return SPTemplateFinderUtil.getTemplateDetail(templateId);
	}

	public List getTemplateDetail(String templateName) {
		return SPTemplateFinderUtil.getTemplateDetail(templateName);
	}

	public boolean deleteTemplateComponents(long templateId) {
		// return
		// SPComponentTemplateFinderUtil.deleteTemplateComponents(templateId);
		return true;
	}

	public void createTemplate(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long portletGroupId = themeDisplay.getScopeGroupId();
			long spTemplateId = CounterLocalServiceUtil.increment("SPTemplate.class");
			String className = TemplatePortlet.class.getName();
			long classNameId = PortalUtil.getClassNameId(className);

			String templateName = ParamUtil.getString(resourceRequest, "templateName", "");
			SPTemplate spTemplate = new SPTemplateImpl();
			spTemplate.setTemplateName(templateName);
			spTemplate.setSpTemplateId(spTemplateId);
			spTemplate.setGroupId(portletGroupId);
			spTemplate.setCompanyId(themeDisplay.getCompanyId());
			spTemplate.setCreateBy(themeDisplay.getUserId());
			spTemplate.setCreateDate(new Date());
			spTemplate.setClassNameId(classNameId);
			spTemplate.setStatus(1);

			List<SPTemplate> templates = SPTemplateLocalServiceUtil.findByTemplateName(templateName);
			JSONObject jsonMessageObject = JSONFactoryUtil.createJSONObject();
			jsonMessageObject.put("status", Boolean.FALSE);
			if (!templates.isEmpty()) {
				resourceResponse.getWriter().write("Template Exists");
			} else {

				SPTemplateLocalServiceUtil.addSPTemplate(spTemplate);

				int subLevels = ParamUtil.getInteger(resourceRequest, "activatedsubleveles", 1);
				PortletPreferences portletPreferences1 = resourceRequest.getPreferences();
				String maxlevels = portletPreferences1.getValue("maxlevels", "10");
				SPComponentTemplate spCompTemplate = null;
				long spComponentTemplateId = CounterLocalServiceUtil.increment("SPComponentTemplate.class");
				for (int i = 1; i <= subLevels; i++) {
					spComponentTemplateId++;
					spCompTemplate = new SPComponentTemplateImpl();
					spCompTemplate.setGroupId(portletGroupId);
					spCompTemplate.setCompanyId(themeDisplay.getCompanyId());
					spCompTemplate.setCreateBy(themeDisplay.getUserId());
					spCompTemplate.setCreateDate(new Date());
					spCompTemplate.setSpTemplateId(spTemplateId);
					spCompTemplate.setSpComponentTemplateId(spComponentTemplateId);
					spCompTemplate.setStatus(1);
					spCompTemplate.setCreateBy(themeDisplay.getUserId());

					String levelInfo = "";
					String[] stringArray;
					long componenetClassNameId;
					JSONObject saveFormObject;
					long formId;
					levelInfo = ParamUtil.getString(resourceRequest, "parentTemplate", "");
					stringArray = levelInfo.split("--");
					if (stringArray[0] != "0") {
						
						try{
							componenetClassNameId = PortalUtil.getClassNameId(stringArray[1]);
						}catch(Exception e){
							componenetClassNameId = 0;
						}
						saveFormObject = FormBuilderLocalServiceUtil.createFormCopy(stringArray[0]);
						formId = saveFormObject.getJSONObject("output").getLong("htmlFormId");
						spCompTemplate.setLevel0ClassNameId(componenetClassNameId);
						spCompTemplate.setLevel0FormId(Long.valueOf(formId));
					}
					for (int j = 1; j < Integer.valueOf(maxlevels); j++) {
						levelInfo = ParamUtil.getString(resourceRequest, "selectField" + j + "-" + i, "");
						stringArray = levelInfo.split("--");
						if (stringArray.length > 0 && !stringArray[0].equalsIgnoreCase("0")) {
							if(stringArray.length == 2){
								componenetClassNameId = PortalUtil.getClassNameId(stringArray[1]);
							}else{
								componenetClassNameId = 0;
							}
							saveFormObject = FormBuilderLocalServiceUtil.createFormCopy(stringArray[0]);
							formId = saveFormObject.getJSONObject("output").getLong("htmlFormId");
							if (j == 1) {
								spCompTemplate.setLevel1ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel1FormId(Long.valueOf(formId));
							} else if (j == 2) {
								spCompTemplate.setLevel2ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel2FormId(Long.valueOf(formId));
							} else if (j == 3) {
								spCompTemplate.setLevel3ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel3FormId(Long.valueOf(formId));
							} else if (j == 4) {
								spCompTemplate.setLevel4ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel4FormId(Long.valueOf(formId));
							} else if (j == 5) {
								spCompTemplate.setLevel5ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel5FormId(Long.valueOf(formId));
							} else if (j == 6) {
								spCompTemplate.setLevel6ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel6FormId(Long.valueOf(formId));
							} else if (j == 7) {
								spCompTemplate.setLevel7ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel7FormId(Long.valueOf(formId));
							} else if (j == 8) {
								spCompTemplate.setLevel8ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel8FormId(Long.valueOf(formId));
							} else if (j == 9) {
								spCompTemplate.setLevel9ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel9FormId(Long.valueOf(formId));
							} else if (j == 10) {
								spCompTemplate.setLevel10ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel10FormId(Long.valueOf(formId));
							}
						}
					}
					SPComponentTemplateLocalServiceUtil.addSPComponentTemplate(spCompTemplate);
				}
				resourceResponse.getWriter().write("Template added");
			}

		} catch (Exception e2) {

		}
	}

	public void deleteTemplate(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		long spTemplateId = ParamUtil.getLong(resourceRequest, "template_id", 0);
		spTemplateId = Long.valueOf(resourceRequest.getParameter("template_id"));

		SPTemplateFinderUtil.deleteTemplate(spTemplateId);
		try {
			resourceResponse.getWriter().write("Template deleted");
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	public void updateTemplate(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long portletGroupId = themeDisplay.getScopeGroupId();
			// long spTemplateId =
			// CounterLocalServiceUtil.increment("SPTemplate.class");
			String className = TemplatePortlet.class.getName();
			long classNameId = PortalUtil.getClassNameId(className);

			String templateName = ParamUtil.getString(resourceRequest, "templateName", "");
			long spTemplateId = ParamUtil.getLong(resourceRequest, "templateId", 0);
			SPTemplate spTemplate = new SPTemplateImpl();
			spTemplate.setTemplateName(templateName);
			spTemplate.setModifiedBy(themeDisplay.getUserId());
			spTemplate.setModifiedDate((new Date()));
			spTemplate.setSpTemplateId(spTemplateId);
			spTemplate.setStatus(1);

			List<SPTemplate> templates = SPTemplateLocalServiceUtil.findByTemplateName(templateName);
			JSONObject jsonMessageObject = JSONFactoryUtil.createJSONObject();
			jsonMessageObject.put("status", Boolean.TRUE);
			if ((!templates.isEmpty() || spTemplateId == 0) && templates.get(0).getSpTemplateId() != spTemplateId) {
				resourceResponse.getWriter().write("Template name Exists");
			} else {

				SPTemplateLocalServiceUtil.updateSPTemplate(spTemplate);

				HashMap<String, JSONObject> systemtemplates = new HashMap();
				HashMap<String, JSONObject> copiedtemplates = new HashMap();
				HashMap<String, JSONObject> formHashMap = new HashMap();
				TemplateUtil.getFormsListV2(systemtemplates, copiedtemplates);

				SPComponentTemplateLocalServiceUtil.deleteTemplateComponentsByTemplateId(spTemplateId);
				int subLevels = ParamUtil.getInteger(resourceRequest, "activatedsubleveles", 1);
				PortletPreferences portletPreferences1 = resourceRequest.getPreferences();
				String maxlevels = portletPreferences1.getValue("maxlevels", "10");
				SPComponentTemplate spCompTemplate = null;
				long spComponentTemplateId = CounterLocalServiceUtil.increment("SPComponentTemplate.class");
				for (int i = 1; i <= subLevels; i++) {
					spComponentTemplateId++;
					spCompTemplate = new SPComponentTemplateImpl();
					spCompTemplate.setGroupId(portletGroupId);
					spCompTemplate.setCompanyId(themeDisplay.getCompanyId());
					spCompTemplate.setCreateBy(themeDisplay.getUserId());
					spCompTemplate.setCreateDate(new Date());
					spCompTemplate.setSpTemplateId(spTemplateId);
					spCompTemplate.setSpComponentTemplateId(spComponentTemplateId);
					spCompTemplate.setStatus(1);
					spCompTemplate.setCreateBy(themeDisplay.getUserId());

					String levelInfo = "";
					String[] stringArray;
					long componenetClassNameId;
					JSONObject saveFormObject;
					long formId;
					levelInfo = ParamUtil.getString(resourceRequest, "parentTemplate", "");
					stringArray = levelInfo.split("--");
					if (stringArray[0] != "0") {
						componenetClassNameId = PortalUtil.getClassNameId(stringArray[1]);
						if (systemtemplates.containsKey(stringArray[0])) {
							saveFormObject = FormBuilderLocalServiceUtil.createFormCopy(stringArray[0]);
							formId = saveFormObject.getJSONObject("output").getLong("htmlFormId");
						} else {
							formId = Long.valueOf(stringArray[0]);
						}
						spCompTemplate.setLevel0ClassNameId(componenetClassNameId);
						spCompTemplate.setLevel0FormId(Long.valueOf(formId));

					}

					for (int j = 1; j < Integer.valueOf(maxlevels); j++) {
						levelInfo = ParamUtil.getString(resourceRequest, "selectField" + j + "-" + i, "");
						stringArray = levelInfo.split("--");
						if (stringArray.length >= 1 && stringArray[0] != "0") {
							try{
								componenetClassNameId = PortalUtil.getClassNameId(stringArray[1]);
							}catch(Exception e){
								componenetClassNameId = 0;
							}

							if (systemtemplates.containsKey(stringArray[0])) {
								saveFormObject = FormBuilderLocalServiceUtil.createFormCopy(stringArray[0]);
								formId = saveFormObject.getJSONObject("output").getLong("htmlFormId");
							} else {
								formId = Long.valueOf(stringArray[0]);
							}
							if (j == 1) {
								spCompTemplate.setLevel1ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel1FormId(Long.valueOf(formId));
							} else if (j == 2) {
								spCompTemplate.setLevel2ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel2FormId(Long.valueOf(formId));
							} else if (j == 3) {
								spCompTemplate.setLevel3ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel3FormId(Long.valueOf(formId));
							} else if (j == 4) {
								spCompTemplate.setLevel4ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel4FormId(Long.valueOf(formId));
							} else if (j == 5) {
								spCompTemplate.setLevel5ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel5FormId(Long.valueOf(formId));
							} else if (j == 6) {
								spCompTemplate.setLevel6ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel6FormId(Long.valueOf(stringArray[0]));
							} else if (j == 7) {
								spCompTemplate.setLevel7ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel7FormId(Long.valueOf(stringArray[0]));
							} else if (j == 8) {
								spCompTemplate.setLevel8ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel8FormId(Long.valueOf(stringArray[0]));
							} else if (j == 9) {
								spCompTemplate.setLevel9ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel9FormId(Long.valueOf(stringArray[0]));
							} else if (j == 10) {
								spCompTemplate.setLevel10ClassNameId(componenetClassNameId);
								spCompTemplate.setLevel10FormId(Long.valueOf(stringArray[0]));
							}
						}
					}

					SPComponentTemplateLocalServiceUtil.addSPComponentTemplate(spCompTemplate);
				}
				resourceResponse.getWriter().write("Template updated");
			}
		} catch (Exception e2) {
			log.error(e2.toString());
		}
	}

}