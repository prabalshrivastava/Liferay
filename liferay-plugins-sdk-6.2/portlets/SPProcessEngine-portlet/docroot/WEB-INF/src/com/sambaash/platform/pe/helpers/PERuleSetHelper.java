package com.sambaash.platform.pe.helpers;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalServiceUtil;
public class PERuleSetHelper {
	public static long getFormId(long rulesetId) throws PEException {
		long formId = 0;
		try {
			PERuleSet ruleSet = PERuleSetLocalServiceUtil.getPERuleSet(rulesetId);
			formId = GetterUtil.getLong(ruleSet.getComponentId());

		}catch (PortalException ex) {
			_log.error("Error while getting ruleset , for rulesetid= " + rulesetId, ex);
			throw new PEException(PEErrors.format(PEErrors.RULE_SET_NOT_FOUND_ARGS, rulesetId));
		} catch (SystemException e) {
			throw new PEException(PEErrors.SYSTEM_ERROR);
		}
		
		if (formId == 0) {
			throw new PEException(PEErrors.format(PEErrors.FORM_NOT_FOUND_ARGS, rulesetId,formId));
		}

		return formId;
	}

	public static long getFormV2Id(long rulesetId) throws PEException {
		long formId = 0;
		try {
			JSONObject ruleJson = RulesMicroserviceLocalServiceUtil.getRuleSet(rulesetId);
				formId = ruleJson.getLong("componentId");
		}catch (Exception ex) {
			_log.error("Error while getting ruleset , for rulesetid= " + rulesetId, ex);
			throw new PEException(PEErrors.format(PEErrors.RULE_SET_NOT_FOUND_ARGS, rulesetId));
		}
		
		if (formId == 0) {
			throw new PEException(PEErrors.format(PEErrors.RULE_SET_NOT_VALID_FOR_COMPONENT, rulesetId));
		}

		return formId;
	}

	public static String getJspV2Name(long rulesetId) throws PEException {
		String jspName = "";
		try {
			JSONObject ruleJson = RulesMicroserviceLocalServiceUtil.getRuleSet(rulesetId);
			jspName = ruleJson.getString("componentId");
		}catch (Exception ex) {
			_log.error("Error while getting ruleset , for rulesetid= " + rulesetId, ex);
			throw new PEException(PEErrors.format(PEErrors.RULE_SET_NOT_FOUND_ARGS, rulesetId));
		}
		
		if (StringUtils.isEmpty(jspName)) {
			throw new PEException(PEErrors.format(PEErrors.RULE_SET_NOT_VALID_FOR_COMPONENT, rulesetId));
		}

		return jspName;
	}
	
	public static String getJspName(long rulesetId) {
		return getJspName(rulesetId, PEConstants.RULE_VERSION_1);
	}

	public static String getJspName(long rulesetId, String version) {
		String name = StringPool.BLANK;
		try {
			if (PEConstants.RULE_VERSION_2.equals(version)) {
				name = getJspV2Name(rulesetId);
			} else {
				PERuleSet ruleSet = PERuleSetLocalServiceUtil.getPERuleSet(rulesetId);
				name = ruleSet.getComponentId();				
			}
		}catch (Exception ex) {
			_log.error("Error while getting formId from ruleset, for rulesetid= " + rulesetId, ex);
		}

		return name;
	}

	public static List<PERuleSet> getRuleSets(String type) throws SystemException {
		return PERuleSetLocalServiceUtil.findByComponentType(type);
	}

	public static List<PERuleSet> getRuleSetsForm() throws SystemException {
		return getRuleSets(PEAuditConstants.TYPE_FORM);
	}

	public static List<PERuleSet> getRuleSetsJsp() throws SystemException {
		return getRuleSets(PEAuditConstants.TYPE_JSP);
	}

	public static List<PERuleSet> getRuleSetsProcess() throws SystemException {
		return getRuleSets(PEAuditConstants.TYPE_PROCESS);
	}

	private static Log _log = LogFactoryUtil.getLog(PERuleSetHelper.class);

}