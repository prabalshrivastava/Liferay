package com.sambaash.platform.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.srv.spservices.model.SPSite;
import com.sambaash.platform.srv.spservices.model.SPUserType;
import com.sambaash.platform.srv.spservices.service.SPSiteLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPUserTypeLocalServiceUtil;

public class UserTypeUtil {

	private static final Log _log = LogFactoryUtil.getLog(UserTypeUtil.class);

	public List<SPUserType> getUserType(long userId) {
		List<SPUserType> userTypeList = new ArrayList<>();
		List<SPSite> spSiteUserList = SPSiteLocalServiceUtil.findByUserId(userId);
		for (SPSite spSiteUser : spSiteUserList) {
			spSiteUser.getSpSiteId();
		}
		return userTypeList;

	}

	public List<SPUserType> getUserTypeList(long userId, long virtualHostId) {
		List<SPUserType> userTypeList = new ArrayList<>();

		// most likely it will return only 1 value since layout set for
		// public/private will have only 1 sign-up
		List<SPSite> spSiteUserList = SPSiteLocalServiceUtil.findByUserIdAndVirtualHostId(userId, virtualHostId);

		for (SPSite spSiteUser : spSiteUserList) {
			try {
				List<SPUserType> spUserTypeList = SPUserTypeLocalServiceUtil.findBySpSiteId(spSiteUser.getSpSiteId());
				userTypeList.addAll(spUserTypeList);
			} catch (SystemException e) {
				_log.error(String.format("Error in fetching SPUserType by %s ", spSiteUser.getSpSiteId()));
			}
		}

		return userTypeList;
	}
	

}
