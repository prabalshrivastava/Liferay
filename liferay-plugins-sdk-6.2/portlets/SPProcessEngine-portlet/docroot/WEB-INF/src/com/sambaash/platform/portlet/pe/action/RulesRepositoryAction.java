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
import com.sambaash.platform.srv.processbuilder.service.PERuleLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;

public class RulesRepositoryAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(RulesRepositoryAction.class.getName());

	@ProcessAction(name = "mvcPath")
	public void addEntry(ActionRequest request, ActionResponse response) throws IOException, PortletException {

	}

	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {

		List<PERuleSet> ruleList = null;

		try {

			ruleList = PERuleSetLocalServiceUtil.getPERuleSets(-1, -1);

		} catch (SystemException e) {
			_log.error(e.getMessage());
		}

		request.setAttribute("rules", ruleList);

		super.render(request, response);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void serveResource(ResourceRequest resourseRequest, ResourceResponse resourseResponse)
			throws IOException, PortletException {

		if (resourseRequest.getResourceID().equals("addNewRuleTable")) {

			String formName = ParamUtil.getString(resourseRequest, "formName", StringPool.BLANK);
			String selectOption = ParamUtil.getString(resourseRequest, "selectOption", StringPool.BLANK);
			String formStatus = ParamUtil.getString(resourseRequest, "status", StringPool.BLANK);
			String JSPName = ParamUtil.getString(resourseRequest, "jspName", StringPool.BLANK);
			String formVersion = ParamUtil.getString(resourseRequest, "formVersion", StringPool.BLANK);

			PERuleSet newRule = null;
			try {

				long peRuleSetId = CounterLocalServiceUtil.increment();

				newRule = PERuleSetLocalServiceUtil.createPERuleSet(peRuleSetId);

				_log.info("Parameter 1 is ==>" + formName);
				_log.info("Parameter 2 is ==>" + selectOption);
				_log.info("Parameter 3 is ==>" + formStatus);
				_log.info("Parameter 4 is ==>" + JSPName);
				_log.info("formVersion is ==>" + formVersion);

				Date now = new Date();
				ThemeDisplay themeDisplay = (ThemeDisplay) resourseRequest.getAttribute(WebKeys.THEME_DISPLAY);

				newRule.setGroupId(themeDisplay.getScopeGroupId());
				newRule.setCreateDate(now);
				newRule.setModifiedDate(now);
				newRule.setUserId(themeDisplay.getUserId());
				newRule.setUserName(themeDisplay.getUser().getFullName());
				newRule.setCompanyId(themeDisplay.getCompanyId());

				newRule.setName(formName);
				if (selectOption.equalsIgnoreCase("jsp")) {
					newRule.setComponentType(PEAuditConstants.TYPE_JSP);
					newRule.setComponentId(JSPName);
				} else if (selectOption.equalsIgnoreCase("process")) {
					newRule.setComponentType(PEAuditConstants.TYPE_PROCESS);
				} else {
					newRule.setComponentType(PEAuditConstants.TYPE_FORM);
					newRule.setComponentId(selectOption);
					newRule.setFormVersion(formVersion);
				}

				newRule.setStatus(2);

				PERuleSetLocalServiceUtil.addPERuleSet(newRule);

			} catch (SystemException e) {
				_log.error(e.getMessage());
			}

			resourseResponse.setContentType("text/html");
			PrintWriter writer = resourseResponse.getWriter();

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("ruleSetId", newRule.getSpPERuleSetId());
			jsonObject.put("ruleSetName", formName);
			jsonObject.put("componentType", newRule.getComponentType());
			jsonObject.put("componentId", newRule.getComponentId());
			jsonObject.put("formVersion", newRule.getFormVersion());

			writer.print(jsonObject.toString());

		} else if (resourseRequest.getResourceID().equals("saveRules")) {

			String saveDefinition = ParamUtil.getString(resourseRequest, "RuleDetails", StringPool.BLANK);
			String customRuleName = ParamUtil.getString(resourseRequest, "ruleName", StringPool.BLANK);
			String customRuleID = ParamUtil.getString(resourseRequest, "ruleDBId", StringPool.BLANK);
			String formId = ParamUtil.getString(resourseRequest, "formId", StringPool.BLANK);
			long sequenceNo = ParamUtil.getLong(resourseRequest, "sequence", 0);
			long form_ID = Long.parseLong(formId);
			long rule_ID = Long.parseLong(customRuleID);

			try {

				PERule saveRule = null;
				ThemeDisplay themeDisplay = (ThemeDisplay) resourseRequest.getAttribute(WebKeys.THEME_DISPLAY);
				Date now = new Date();

				if (rule_ID != -1) {
					saveRule = PERuleLocalServiceUtil.getPERule(rule_ID);
					saveRule.setName(customRuleName);
					saveRule.setModifiedDate(now);
					saveRule.setDefinition(saveDefinition);
					PERuleLocalServiceUtil.updatePERule(saveRule);
				} else {
					long peRuleId = CounterLocalServiceUtil.increment();
					saveRule = PERuleLocalServiceUtil.createPERule(peRuleId);
					saveRule.setCreateDate(now);
					saveRule.setSpPERuleId(peRuleId);
					saveRule.setGroupId(themeDisplay.getScopeGroupId());
					saveRule.setModifiedDate(now);
					saveRule.setUserId(themeDisplay.getUserId());
					saveRule.setUserName(themeDisplay.getUser().getFullName());
					saveRule.setCompanyId(themeDisplay.getCompanyId());
					saveRule.setSpPERuleSetId(form_ID);
					saveRule.setName(customRuleName);
					saveRule.setDefinition(saveDefinition);
					saveRule.setSequenceNO(sequenceNo);
					saveRule.setType("Simple");
					PERuleLocalServiceUtil.addPERule(saveRule);
				}

				// set sattus
				PERuleSet perulset = PERuleSetLocalServiceUtil.getPERuleSet(form_ID);
				_log.info("publishRuleSetId : form_ID -> " + form_ID + " PEConstants.STATUS_DRAFT : "
						+ PEConstants.STATUS_DRAFT);
				perulset.setStatus(PEConstants.STATUS_DRAFT);

				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				jsonObject.put("ruleDBId", saveRule.getSpPERuleId());
				jsonObject.put("rueSequence", sequenceNo);

				PrintWriter writer = resourseResponse.getWriter();

				writer.print(jsonObject.toString());
				_log.info("Parameter 1 is ==>" + saveDefinition);

			} catch (SystemException | PortalException pe) {
				_log.error(pe.getMessage());
			}

			// super.serveResource(resourseRequest, resourseResponse);

		} else if (resourseRequest.getResourceID().equals("retrieveFormRules")) {

			PERule ruleObject = null;
			List<PERule> ruleSetList = null;
			Long updateFormID = null;
			ArrayList<String> rulesDefination = new ArrayList<String>();
			ArrayList<String> rulesName = new ArrayList<String>();

			// String saveDefinition = ParamUtil.getString(resourseRequest,
			// "updateformID", StringPool.BLANK);
			String formID = ParamUtil.getString(resourseRequest, "updateformID", StringPool.BLANK);

			updateFormID = Long.parseLong(formID);

			try {

				ruleSetList = PERuleLocalServiceUtil.findByRuleSetId(updateFormID);
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

				for (int i = 0; i < ruleSetList.size(); i++) {

					ruleObject = ruleSetList.get(i);

					JSONObject jsonObjectForRule = JSONFactoryUtil.createJSONObject();

					jsonObjectForRule.put("definition", ruleObject.getDefinition());
					jsonObjectForRule.put("ruleName", ruleObject.getName());
					jsonObjectForRule.put("ruleId", ruleObject.getSpPERuleId());

					jsonArray.put(jsonObjectForRule);

				}

				resourseResponse.setContentType("text/html");

				jsonObject.put("retrieveRules", jsonArray);

				PrintWriter writer = resourseResponse.getWriter();
				writer.print(jsonObject.toString());

				// resourseRequest.setAttribute("retrieveRules",
				// rulesDefination);
				writer.flush();
				writer.close();

			} catch (SystemException e) {
				_log.error(e.getMessage());
			}

		} else if (resourseRequest.getResourceID().equals("deleteFormRules")) {

			String formId = ParamUtil.getString(resourseRequest, "formId", StringPool.BLANK);
			List<PERule> ruleSetList = null;
			long form_ID = Long.parseLong(formId);

			// if(PERuleLocalServiceUtil.getPERule(form_ID) == formID){}

			try {

				ruleSetList = PERuleLocalServiceUtil.findByRuleSetId(form_ID);

				for (int i = 0; i < ruleSetList.size(); i++) {

					try {
						PERuleLocalServiceUtil.deletePERule(ruleSetList.get(i).getSpPERuleId());
					} catch (Exception e) {
						_log.error(e.getMessage());
					}
				}

			} catch (Exception e) {
				_log.error(e.getMessage());
			}

			// super.serveResource(resourseRequest, resourseResponse);

		} else if (resourseRequest.getResourceID().equals("deleteRulesSetID")) {

			String tableRowId = ParamUtil.getString(resourseRequest, "tableRowId", StringPool.BLANK);

			long table_Row_ID = Long.parseLong(tableRowId);

			try {

				PERuleSetLocalServiceUtil.deletePERuleSet(table_Row_ID);

			} catch (Exception e) {
				_log.error(e.getMessage());
			}

			super.serveResource(resourseRequest, resourseResponse);

		} else if (resourseRequest.getResourceID().equals("retrieveEntityDetails")) {// retrieveEntityTypes

			ProcessBuilderActionHelper.prepareEntities(resourseRequest, resourseResponse);

		} else if (resourseRequest.getResourceID().equals("retrieveEntityFields")) {// retrieveEntityFields
																					// by
																					// Abhinay
			_log.info("retrieveEntityFields : ");
			long classNameId = ParamUtil.getLong(resourseRequest, "entityId");
			JSONObject entity = null;
			JSONArray valueArray = null;
			JSONArray entityFields = JSONFactoryUtil.createJSONArray();

			// get the entity fields
			List<PEEntityField> fields = PEEntityHelper.getPEEntityFields(classNameId);
			for (PEEntityField peEntityField : fields) {
				entity = JSONFactoryUtil.createJSONObject();
				valueArray = JSONFactoryUtil.createJSONArray();
				if (peEntityField.getValues() != null) {
					for (Entry<String, String> entry : peEntityField.getValues().entrySet()) {
						JSONObject val = JSONFactoryUtil.createJSONObject();
						val.put("prodId", entry.getKey());
						val.put("prodName", entry.getValue());
						valueArray.put(val);
					}
				}

				entity.put("id", peEntityField.getId());
				entity.put("name", peEntityField.getName());
				entity.put("type", peEntityField.getType());
				entity.put("values", valueArray);
				entityFields.put(entity);
			}

			PrintWriter writer = null;
			try {
				writer = resourseResponse.getWriter();
			} catch (IOException e1) {
				_log.error(e1.getMessage());
			}

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("entityFields", entityFields);

			writer.print(jsonObject.toString());
			writer.flush();
			writer.close();

		} else if (resourseRequest.getResourceID().equals("retrieveRoleDetails")) {// retrieveRoles
			ProcessBuilderActionHelper.prepareRoleDropDownData(resourseRequest, resourseResponse);
		} else if (resourseRequest.getResourceID().equals("retrieveEntities")) {
			_log.info("retrieveEntities : ");
			long classNameId = ParamUtil.getLong(resourseRequest, "entityId");
			JSONObject entity = null;
			JSONArray entitiesName = JSONFactoryUtil.createJSONArray();

			List<PEEntity> entities = PEEntityHelper.getEntities(classNameId);

			for (PEEntity peEntity : entities) {
				entity = JSONFactoryUtil.createJSONObject();
				entity.put("key", peEntity.getId());
				entity.put("name", peEntity.getName());
				entitiesName.put(entity);
			}

			PrintWriter writer = null;

			try {
				writer = resourseResponse.getWriter();
			} catch (IOException e1) {
				_log.error(e1.getMessage());
			}
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("entities", entitiesName);

			writer.print(jsonObject.toString());
			writer.flush();
			writer.close();

		} else if (resourseRequest.getResourceID().equals("publishRuleSetId")) {
			long rulesetid = ParamUtil.getLong(resourseRequest, "tableRowId");
			_log.info("publishRuleSetId : formId -> " + rulesetid);
			PERuleSet perule = null;
			try {
				perule = PERuleSetLocalServiceUtil.getPERuleSet(rulesetid);
			} catch (PortalException | SystemException e) {
				_log.error(e.getMessage());
			}
			perule.setStatus(PEConstants.STATUS_PUBLISHED);
			// perule.setStatus(1);
		} else if (resourseRequest.getResourceID().equals("searchRuleSetId")) {
			String searchText = ParamUtil.getString(resourseRequest, "searchText");
			JSONArray ruleSets = JSONFactoryUtil.createJSONArray();
			JSONObject obj = null;
			long ruleCount = 0;
			List<PERuleSet> ruleSetList;
			try {
				ruleSetList = PERuleSetLocalServiceUtil.dynamicQuery(getSearchQuery(searchText.trim()), -1, -1);

				for (PERuleSet ruleSet : ruleSetList) {
					ruleCount = PERuleLocalServiceUtil.findByRuleSetId(ruleSet.getSpPERuleSetId()).size();
					obj = JSONFactoryUtil.createJSONObject();
					obj.put("spPERuleSetId", ruleSet.getSpPERuleSetId());
					obj.put("name", ruleSet.getName());
					obj.put("status", ruleSet.getStatus());
					obj.put("componentType", ruleSet.getComponentType());
					obj.put("componentId", ruleSet.getComponentId());
					obj.put("ruleCount", ruleCount);
					obj.put("createDate", PEHelper.getDateStrddMMYYYYHMS(ruleSet.getCreateDate()));

					ruleSets.put(obj);
				}

				PrintWriter writer = null;

				try {
					writer = resourseResponse.getWriter();
				} catch (IOException e1) {
					_log.error(e1.getMessage());
				}
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("ruleSets", ruleSets);

				writer.print(jsonObject.toString());
				writer.flush();
				writer.close();
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}

		}
	}

	public static DynamicQuery getSearchQuery(String searchText) {

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PERuleSet.class,
				PortletClassLoaderUtil.getClassLoader(PEConstants.PORTLET_ID));

		Criterion searchTextCriteria = RestrictionsFactoryUtil.ilike("name",
				StringPool.PERCENT + searchText + StringPool.PERCENT);

		if (Validator.isNotNull(searchText)) {
			dynamicQuery.add(searchTextCriteria);
		}

		return dynamicQuery;

	}

}
