package com.sambaash.platform.pe.helpers;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.model.payment.PaymentProvider;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.model.PERule;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PECustomActionInfoLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PERuleLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class ProcessBuilderHelper {

	public static JSONArray loadRoles() throws SystemException {

		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject obj;
		List<Role> roles = RoleLocalServiceUtil.getRoles(-1, -1);

		for (Role role : roles) {
			obj = JSONFactoryUtil.createJSONObject();

			obj.put("id", role.getRoleId());
			obj.put("name", role.getName());
			array.put(obj);
		}

		return array;
	}

	public static JSONArray loadVocabulary() throws SystemException {

		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject obj;
		List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);

		for (AssetVocabulary assetVocabulary : assetVocabularies) {
			obj = JSONFactoryUtil.createJSONObject();

			obj.put("id", assetVocabulary.getVocabularyId());
			obj.put("name", assetVocabulary.getName());
			array.put(obj);
		}

		return array;
	}

	public static String loadUsers() {
		JSONArray array = JSONFactoryUtil.createJSONArray();
		try {
			List<User> userList = UserLocalServiceUtil.getUsers(-1, -1);
			for (User user : userList) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("code", user.getEmailAddress());
				obj.put("key", user.getUserId());
				array.put(obj);
			}
		} catch (SystemException e) {
			_log.error(e);
		}

		if (array.length() > 0) {
			return JSONFactoryUtil.looseSerialize(array);
		} else {
			return StringPool.BLANK;
		}
	}

	public static JSONArray loadRules(long rulesetId) throws SystemException {

		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject obj;
		List<PERule> rules = PERuleLocalServiceUtil.findByRuleSetId(rulesetId);

		for (PERule rule : rules) {
			obj = JSONFactoryUtil.createJSONObject();

			obj.put("id", rule.getSpPERuleId());
			obj.put("name", rule.getName());
			array.put(obj);
		}

		return array;
	}

	public static JSONArray loadRuleSetsForm() throws SystemException {

		JSONArray array = null;
		List<PERuleSet> ruleSets = PERuleSetHelper.getRuleSetsForm();
		array = prepareJsonData(ruleSets);
		return array;
	}

	public static JSONArray loadRuleSetsJsp() throws SystemException {

		JSONArray array = null;
		List<PERuleSet> ruleSets = PERuleSetHelper.getRuleSetsJsp();
		array = prepareJsonData(ruleSets);
		return array;
	}

	public static JSONArray loadRuleSetsProcess() throws SystemException {

		JSONArray array = null;
		List<PERuleSet> ruleSets = PERuleSetHelper.getRuleSetsProcess();
		array = prepareJsonData(ruleSets);
		return array;
	}

	public static JSONArray loadStatusTypes(long processId, boolean includeAll) throws SystemException {

		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject obj;
		List<PEProcessStatusType> types = PEProcessStatusTypeLocalServiceUtil.findByProcessId(processId);
		if (includeAll) {
			obj = JSONFactoryUtil.createJSONObject();
			obj.put("id", 0);
			obj.put("name", "All Status Types");
			array.put(obj);
		}

		for (PEProcessStatusType type : types) {
			obj = JSONFactoryUtil.createJSONObject();

			obj.put("id", type.getSpPEProcessStatusTypeId());
			obj.put("name", type.getStatusName());
			array.put(obj);
		}

		return array;
	}

	public static JSONArray loadStatusTypesAndStatus(long processId) throws SystemException {

		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject obj;
		List<PEProcessStatusType> types = PEProcessStatusTypeLocalServiceUtil.findByProcessId(processId);
		String[] statuses = new String[] { PEConstantsGlobal.STATUS_STARTED, PEConstantsGlobal.STATUS_INPROGRESS,
				PEConstantsGlobal.STATUS_PENDING, PEConstantsGlobal.STATUS_APPROVED };

		for (PEProcessStatusType type : types) {

			for (String status : statuses) {
				obj = JSONFactoryUtil.createJSONObject();
				obj.put("id", type.getSpPEProcessStatusTypeId() + "-" + status);
				obj.put("name", type.getStatusName() + "-" + status);
				array.put(obj);
			}

		}

		return array;
	}

	public static JSONArray loadStages(boolean includeAll) throws SystemException {

		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject obj;
		List<PEProcessStage> stages = PEProcessStageLocalServiceUtil.getPEProcessStages(-1, -1);

		if (includeAll) {
			obj = JSONFactoryUtil.createJSONObject();
			obj.put("id", 0);
			obj.put("name", "All Stages");
			array.put(obj);
		}
		for (PEProcessStage type : stages) {
			obj = JSONFactoryUtil.createJSONObject();

			obj.put("id", type.getSpPEProcessStageId());
			obj.put("name", type.getName());
			array.put(obj);
		}

		return array;
	}

	public static JSONArray prepareJsonData(List<PERuleSet> ruleSets) throws SystemException {

		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject obj;

		for (PERuleSet ruleset : ruleSets) {
			obj = JSONFactoryUtil.createJSONObject();

			obj.put("rules", loadRules(ruleset.getSpPERuleSetId()));
			obj.put("id", ruleset.getSpPERuleSetId());
			obj.put("type", ruleset.getComponentType());
			obj.put("componentId", ruleset.getComponentId());
			obj.put("name", ruleset.getName());
			array.put(obj);
		}

		return array;
	}

	public static JSONObject prepareMasterData(long processId) throws SystemException {
		JSONObject obj = JSONFactoryUtil.createJSONObject();

		obj.put("mails", loadMailTemplates());
		obj.put("statusTypeList", loadStatusTypes(processId, false));
		obj.put("roleList", loadRoles());
		obj.put("formList", loadRuleSetsForm());
		obj.put("jspList", loadRuleSetsJsp());
		obj.put("processList", loadRuleSetsProcess());

		return obj;
	}

	public static JSONArray loadMailTemplates() throws SystemException {

		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject obj;
		// List<SPMailTemplate> templates =
		// SPMailTemplateLocalServiceUtil.getSPMailTemplates(-1, -1);
		 List<SPMailTemplate> templates = SPMailTemplateLocalServiceUtil.getTemplates();

		for (SPMailTemplate template : templates) {
			obj = JSONFactoryUtil.createJSONObject();

			obj.put("id", template.getSpMailTemplateId());
			obj.put("name", template.getTemplateName());
			array.put(obj);
		}

		return array;
	}

	public static JSONArray loadCustomActionDetails() throws SystemException {

		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject obj;
		List<PECustomActionInfo> customActionList = PECustomActionInfoLocalServiceUtil.getPECustomActionInfos(-1, -1);

		for (PECustomActionInfo customAction : customActionList) {
			obj = JSONFactoryUtil.createJSONObject();

			obj.put("id", customAction.getSpPEActionId());
			obj.put("name", customAction.getTitle());
			obj.put("configurationText", customAction.getDefaultConfiguration());
			array.put(obj);
		}

		return array;
	}

	public static JSONArray loadPaymentProviders() throws SystemException {

		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject obj;
		String providers = SambaashUtil.getParameter(PaymentProvider.PROVIDER_LIST_KEY, 0);
		if (StringUtils.isEmpty(providers)) {
			providers = "stripe,eNets,paypal";
		}

		for (String provider : providers.split(",")) {
			obj = JSONFactoryUtil.createJSONObject();

			obj.put("id", provider);
			obj.put("name", provider);
			array.put(obj);
		}

		return array;
	}

	public static JSONArray loadPreviewList() throws SystemException {

		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject obj;
		String previewList = SambaashUtil.getParameter(PEConstants.SP_PARAM_PREVIEW_LIST_KEY, 0);
		if (StringUtils.isEmpty(previewList)) {
			previewList = "Select template from Doc Library,Upload Pdf file,Generate New Pdf,Custom";
		}

		for (String preview : previewList.split(",")) {
			obj = JSONFactoryUtil.createJSONObject();

			obj.put("id", preview);
			obj.put("name", preview);
			array.put(obj);
		}

		return array;
	}

	public static JSONArray loadCustomList() throws SystemException {

		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject obj;
		String customList = SambaashUtil.getParameter(PEConstants.SP_PARAM_CUSTOM_LIST_KEY, 0);
		if (StringUtils.isEmpty(customList)) {
			customList = "Esign";
		}

		for (String custom : customList.split(",")) {
			obj = JSONFactoryUtil.createJSONObject();

			obj.put("id", custom);
			obj.put("name", custom);
			array.put(obj);
		}

		return array;
	}

	private static Log _log = LogFactoryUtil.getLog(ProcessBuilderHelper.class);

}