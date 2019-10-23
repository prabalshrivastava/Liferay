package com.sambaash.platform.pe.helpers;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.srv.startupprofile.model.ApprovedMentors;
import com.sambaash.platform.srv.startupprofile.model.SPATOContacts;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;

public class OrganizationHelper {

	private static Log _log = LogFactoryUtil.getLog(OrganizationHelper.class);

	public static Long getOrganiastionId(JSONObject additionalData, PEDataSource ds) {
		String orgId;
		if (Validator.isNotNull(additionalData) && additionalData.has(PEConstants.ORGANIZATION_ID)) {
			orgId = additionalData.getString(PEConstants.ORGANIZATION_ID);
		} else {
			orgId = OrganizationLocalServiceUtil
					.getCurrentUserBaseOrganization(ds.getProcessState().getUserIdProcess());
		}

		return Long.parseLong(orgId);
	}

	public static List<User> getMentors(JSONObject additionalData, PEDataSource ds) {
		List<User> userList = new ArrayList<>();

		Long orgId = getOrganiastionId(additionalData, ds);

		List<ApprovedMentors> mentors = OrganizationLocalServiceUtil.getApprovedMentors(orgId);
		for (ApprovedMentors mentor : mentors) {
			try {
				User user = UserLocalServiceUtil.getUser(Long.parseLong(mentor.getUserId()));
				userList.add(user);
			} catch (NumberFormatException | PortalException | SystemException e) {

			}

		}

		_log.info(String.format("Mentors list size %s", userList.size()));

		return userList;
	}

	public static User getTrainingPrincipal(JSONObject additionalData, PEDataSource ds) {

		Long orgId = getOrganiastionId(additionalData, ds);

		SPATOContacts atoContacts = OrganizationLocalServiceUtil.getSPATOContacts(orgId);

		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(Long.parseLong(atoContacts.getPrimaryPrincipalUserId()));
		} catch (NumberFormatException | PortalException | SystemException e) {
			_log.error(e.getMessage());
		}

		_log.info(String.format("Training Principal User  %s", user.getUserId()));

		return user;
	}

	public static User getSecondaryContact(JSONObject additionalData, PEDataSource ds) {

		Long orgId = getOrganiastionId(additionalData, ds);

		SPATOContacts atoContacts = OrganizationLocalServiceUtil.getSPATOContacts(orgId);

		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(Long.parseLong(atoContacts.getSecondaryPrincipalUserId()));
		} catch (NumberFormatException | PortalException | SystemException e) {
			_log.error(e.getMessage());
		}

		_log.info(String.format("Secondary Contact User  %s", user.getUserId()));

		return user;
	}

}
