package com.sambaash.platform.action;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;

public class ExpandoFieldsAction extends SimpleAction {

	public ExpandoFieldsAction() {
		super();
	}

	private static Log _log = LogFactoryUtil.getLog(ExpandoFieldsAction.class);

	public void run(String[] ids) throws ActionException {
		try {
			doRun(GetterUtil.getLong(ids[0]));
		} catch (Exception e) {
			throw new ActionException(e);
		}
	}
	
	
	protected void doRun(long companyId) throws Exception {
		_log.debug("ExpandoFieldAction Initializing");

		UnicodeProperties properties = new UnicodeProperties();
		properties.setProperty("hidden", "true");
		properties.setProperty("visible-with-update-permission", "false");
		/**
		ExpandoTable expandoTable = addTable(companyId, Company.class.getName());

		_log.debug("Checking/Creating Expandos");

		if (Validator.isNotNull(expandoTable)) {
			for (Map.Entry<String, Integer> entry : SocialLoginConstants.mapGeneralFields
					.entrySet()) {
				_log.debug("Checking Expando:" + (String) entry.getKey());

				addColumn(expandoTable.getTableId(), (String) entry.getKey(),
						((Integer) entry.getValue()).intValue(), properties);
			}

			for (Map.Entry<String, Integer> entry : SocialLoginConstants.mapGoogleFields
					.entrySet()) {
				_log.debug("Checking Expando:" + (String) entry.getKey());

				addColumn(expandoTable.getTableId(), (String) entry.getKey(),
						((Integer) entry.getValue()).intValue(), properties);
			}

			for (Map.Entry<String, Integer> entry : SocialLoginConstants.mapFacebookFields
					.entrySet()) {
				_log.debug("Checking Expando:" + (String) entry.getKey());

				addColumn(expandoTable.getTableId(), (String) entry.getKey(),
						((Integer) entry.getValue()).intValue(), properties);
			}

			for (Map.Entry<String, Integer> entry : SocialLoginConstants.mapTwitterFields
					.entrySet()) {
				_log.debug("Checking Expando:" + (String) entry.getKey());

				addColumn(expandoTable.getTableId(), (String) entry.getKey(),
						((Integer) entry.getValue()).intValue(), properties);
			}

			for (Map.Entry<String, Integer> entry : SocialLoginConstants.mapLinkedinFields
					.entrySet()) {
				_log.debug("Checking Expando:" + (String) entry.getKey());

				addColumn(expandoTable.getTableId(), (String) entry.getKey(),
						((Integer) entry.getValue()).intValue(), properties);
			}

			for (Map.Entry<String, Integer> entry : SocialLoginConstants.mapMicrosoftFields
					.entrySet()) {
				_log.debug("Checking Expando:" + (String) entry.getKey());

				addColumn(expandoTable.getTableId(), (String) entry.getKey(),
						((Integer) entry.getValue()).intValue(), properties);
			}

		}

		ExpandoTable expandoTableUser = addTable(companyId,
				User.class.getName());

		_log.debug("Checking/Creating User Expandos");

		if (Validator.isNotNull(expandoTableUser)) {
			_log.debug("Checking User Expando:socialLoginTwitterId");

			addColumn(expandoTableUser.getTableId(), "socialLoginTwitterId",
					15, properties);
		}
		
		**/
	}

	protected ExpandoTable addTable(long companyId, String className)
			throws PortalException, SystemException {
		ExpandoTable expandoTable = null;
		try {
			expandoTable = ExpandoTableLocalServiceUtil.addTable(companyId,
					className, "SP_SOCIAL_LOGIN");
		} catch (Exception e) {
			expandoTable = ExpandoTableLocalServiceUtil.getTable(companyId,
					className, "SP_SOCIAL_LOGIN");
		}
		return expandoTable;
	}

	protected ExpandoColumn addColumn(long tableId, String fieldName, int type,
			UnicodeProperties properties) throws PortalException,
			SystemException {
		ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(tableId,
				fieldName);

		if (Validator.isNotNull(column)) {
			return column;
		}

		ExpandoColumn newColumn = ExpandoColumnLocalServiceUtil.addColumn(
				tableId, fieldName, type);

		ExpandoColumnLocalServiceUtil.updateTypeSettings(
				newColumn.getColumnId(), properties.toString());

		return newColumn;
	}

}