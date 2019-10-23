package com.sambaash.platform.portlet.spneo4j.listener;

import java.util.Date;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;
import com.sambaash.platform.model.spneo4j.form.UserGraphForm;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.util.Neo4jHelper;
import com.sambaash.platform.util.SambaashUtil;
public class UserGraphListener extends BaseModelListener<User> {
	
	//TODO for users can use the groupid from the user object so need to find a workaround

//	@Override
//	public void onAfterCreate(User user) throws ModelListenerException {
//		try {
//			if (SambaashUtil.isNeo4jEnabled()) {
//				_log.debug("***************** onAfterCreate user ********************");
//				long userId = user.getUserId();
//				String firstName = user.getFirstName();
//				String lastName = user.getLastName();
//				String screenName = user.getScreenName();
//				long portraitId = user.getPortraitId();
//				boolean emailAddressVerified = user.getEmailAddressVerified();
//				int status = user.getStatus();
//				Date createDate = user.getCreateDate();
//				Date modifiedDate = user.getModifiedDate();
//
//				UserGraphForm userGraphForm = new UserGraphForm();
//				userGraphForm.setUserId(userId);
//				userGraphForm.setFirstName(firstName);
//				userGraphForm.setLastName(lastName);
//				userGraphForm.setScreenName(screenName);
//				userGraphForm.setPortraitId(portraitId);
//				userGraphForm.setEmailAddressVerified(emailAddressVerified);
//				userGraphForm.setStatus(status);
//				userGraphForm.setCreateDate(createDate);
//				userGraphForm.setModifiedDate(modifiedDate);
//				userGraphForm.setCommunityName(PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME));
//				
//				Neo4jHelper.fillMandatoryFields(userGraphForm, user.getCompanyId(), user.getGroupId(), -1L);
//
//				SPNeoforjLocalServiceUtil.addUserGraph(userGraphForm);
//			}
//		} catch (Exception e) {
//			_log.error(e);
//			//throw new ModelListenerException(e);
//		}
//	}
//
//	@Override
//	public void onAfterRemove(User user) throws ModelListenerException {
//		try {
//			if (SambaashUtil.isNeo4jEnabled()) {
//				_log.debug("***************** onAfterRemove user ********************");
//
//				String communityName = PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME);
//				long userId = user.getUserId();
//
//				SPNeoforjLocalServiceUtil.removeUserGraph(userId, communityName);
//			}
//		} catch (Exception e) {
//			_log.error(e);
//		//	throw new ModelListenerException(e);
//		}
//	}

// TODO add alternative for this	
//	@Override
//	public void onAfterUpdate(User user) throws ModelListenerException {
//		try {
//			if (SambaashUtil.isNeo4jEnabled()) {
//				_log.debug("***************** onAfterUpdate user ********************");
//
//				long userId = user.getUserId();
//				String firstName = user.getFirstName();
//				String lastName = user.getLastName();
//				String screenName = user.getScreenName();
//				long portraitId = user.getPortraitId();
//				boolean emailAddressVerified = user.getEmailAddressVerified();
//				int status = user.getStatus();
//				Date modifiedDate = user.getModifiedDate();
//
//				UserGraphForm userGraphForm = new UserGraphForm();
//				userGraphForm.setUserId(userId);
//				userGraphForm.setFirstName(firstName);
//				userGraphForm.setLastName(lastName);
//				userGraphForm.setScreenName(screenName);
//				userGraphForm.setPortraitId(portraitId);
//				userGraphForm.setEmailAddressVerified(emailAddressVerified);
//				userGraphForm.setStatus(status);
//				userGraphForm.setModifiedDate(modifiedDate);
////				userGraphForm.setGender();
//
//				userGraphForm.setCommunityName(PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME));
//				Neo4jHelper.fillMandatoryFields(userGraphForm, user.getCompanyId(), user.getGroupId(), -1L);
//				
//				SPNeoforjLocalServiceUtil.updateUserGraph(userGraphForm);
//			}
//		} catch (Exception e) {
//			_log.error(e);
//			//throw new ModelListenerException(e);
//		}
//	}

	private static Log _log = LogFactoryUtil.getLog(UserGraphListener.class);

}