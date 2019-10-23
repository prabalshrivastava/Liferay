package com.sambaash.platform.pe.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.GroupedModel;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;

public class PEHelper {

	public static void fillAudit(BaseModel baseModel, PERequestData requestData, boolean isNew) {

		if (baseModel instanceof GroupedModel) {
			GroupedModel groupedModel = (GroupedModel) baseModel;
			groupedModel.setGroupId(requestData.getScopeGroupId());
		}
		if (baseModel instanceof AuditedModel) {
			AuditedModel auditedModel = (AuditedModel) baseModel;
			Date now = new Date();
			if (isNew) {
				auditedModel.setCreateDate(now);
			}
			auditedModel.setModifiedDate(now);
			auditedModel.setUserId(requestData.getUserId());
			auditedModel.setUserName(requestData.getUser().getFullName());
			auditedModel.setCompanyId(requestData.getCompanyId());
		}

	}

	public static Date getDate4rDDMMMYYYY(String str) {
		if (Validator.isNotNull(str)) {
			try {
				String format = "dd/MMM/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(format);
				Date date = df.parse(str);
				return date;
			} catch (Exception ex) {
				_log.error("Error while format String to date. String=" + str);
			}

		}
		return null;
	}

	public static Date getDate4rDDMMYYYY(String str) {
		if (Validator.isNotNull(str)) {
			try {
				String format = "dd/MM/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(format);
				Date date = df.parse(str);
				return date;
			} catch (Exception ex) {
				_log.error("Error while format String to date. String=" + str);
			}

		}
		return null;
	}

	public static Date getDate4rMMDDYYYY(String str) {
		if (Validator.isNotNull(str)) {
			try {
				String format = "MM/dd/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(format);
				Date date = df.parse(str);
				return date;
			} catch (Exception ex) {
				_log.error("Error while format String to date. String=" + str);
			}

		}
		return null;
	}

	public static String getDateStrddMMYYYYHMS(Date date) {
		String dateStr = "";
		String format = "dd/MM/yyyy HH:mm:ss";

		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateStr = sdf.format(date);
		}

		return dateStr;
	}

	public static String getDateStrddMMYYYY(Date date) {
		if (Validator.isNotNull(date)) {
			try {
				String format = "dd/MM/yyyy";
				SimpleDateFormat df = new SimpleDateFormat(format);
				return df.format(date);
			} catch (Exception ex) {
				_log.error("Error while format date to String=" + date);
			}
		}
		return StringPool.BLANK;
	}

	public static void reindexSocialProfile(PEProcessState peProcessState) {

		Indexer indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class.getName());
		SocialProfile socialProfile = null;
		try {
			socialProfile = SocialProfileLocalServiceUtil.fetchSocialProfile(peProcessState.getUserIdProcess());
			indexer.reindex(socialProfile);
		} catch (Exception e) {
			_log.error("Error while reindexing social profile with userId =" + socialProfile.getUserId());
		}

	}

	private static final Log _log = LogFactoryUtil.getLog(PEHelper.class);
}
