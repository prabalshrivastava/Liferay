package com.sambaash.platform.portlet.socialprofile.listener;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;

public class UserListener extends BaseModelListener<User> {

	private static final Log _log = LogFactoryUtil.getLog(UserListener.class);

	@Override
	public void onAfterCreate(User user) throws ModelListenerException {

		SocialProfile profileUser = null;

		try {
			profileUser = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId(), user.getCompanyId());
		} catch (NoSuchSocialProfileException e1) {
			_log.debug(e1.getMessage());
		} catch (SystemException e1) {
			_log.error(e1.getMessage());
		}

		try {
			Group group = GroupLocalServiceUtil.getGroup(user.getCompanyId(),
					PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME));

			if (group == null) {
				throw new SystemException();
			}

			if (Validator.isNull(profileUser)) {
				profileUser = SocialProfileLocalServiceUtil.addOrUpdateSocialProfile(profileUser, user, false,
						group.getGroupId(), true);
			}

		} catch (SystemException e1) {
			_log.error("SocialProfile can't be updated. " + e1.getMessage());
		} catch (Exception e) {
			_log.error("SocialProfile can't be updated. " + e.getMessage());
		}

	}

	@Override
	public void onAfterUpdate(User user) throws ModelListenerException {

		SocialProfile profileUser = null;

		try {
			profileUser = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId(), user.getCompanyId());
		} catch (NoSuchSocialProfileException e1) {
			_log.debug(e1.getMessage());
		} catch (SystemException e1) {
			_log.error(e1.getMessage());
		}

		try {
			Group group = GroupLocalServiceUtil.getGroup(user.getCompanyId(),
					PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME));

			if (group == null) {
				throw new SystemException();
			}
			// String classNameId =
			// String.valueOf(ClassNameLocalServiceUtil.getClassNameId(SocialProfile.class));
			long companyId = user.getCompanyId();
			long userId = user.getUserId();
			profileUser = SocialProfileLocalServiceUtil.addOrUpdateSocialProfile(profileUser, user, false,
					group.getGroupId(), true);

			SocialProfileLocalServiceUtil.updateMobileNo(profileUser,
					PhoneLocalServiceUtil.getPhones(companyId, SocialProfile.class.getName(), userId));
			SocialProfileLocalServiceUtil.updateXMLFromSocialProfile(profileUser);

			SocialProfileLocalServiceUtil.updateSocialProfile(profileUser);

			_log.debug("Social Profile Updated: " + profileUser.getUserId());
		} catch (SystemException e1) {
			_log.error("SocialProfile can't be updated. ");
		} catch (Exception e) {
			_log.error("SocialProfile can't be updated. ");
		}
	}

	@Override
	public void onAfterRemove(User user) throws ModelListenerException {
		SocialProfile profileUser = null;

		try {
			profileUser = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId(), user.getCompanyId());

			if (profileUser != null) {
				SocialProfileLocalServiceUtil.deleteSocialProfile(profileUser);
			}
		} catch (NoSuchSocialProfileException e1) {
			_log.error(e1.getMessage());
		} catch (SystemException e1) {
			_log.error(e1.getMessage());
		}

	}

}
