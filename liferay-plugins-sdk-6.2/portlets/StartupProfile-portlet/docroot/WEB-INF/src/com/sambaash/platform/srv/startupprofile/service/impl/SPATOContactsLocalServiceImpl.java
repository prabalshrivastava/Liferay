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

package com.sambaash.platform.srv.startupprofile.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.SPATOContacts;
import com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.base.SPATOContactsLocalServiceBaseImpl;

/**
 * The implementation of the s p a t o contacts local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.startupprofile.service.base.SPATOContactsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalServiceUtil
 */
public class SPATOContactsLocalServiceImpl extends SPATOContactsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.startupprofile.service.
	 * SPATOContactsLocalServiceUtil} to access the s p a t o contacts local
	 * service.
	 */
	public List<SPATOContacts> findByOrganizationId(long organizationId) {
		try {
			return getSPATOContactsPersistence().findByOrganizationId(organizationId);
		} catch (SystemException e) {
			return null;
		}

	}

	public List<SPATOContacts> findATOTrainingPrincipalByOrganizationId(long organizationId) {
		try {

			List<SPATOContacts> contactsList = getSPATOContactsPersistence().findByOrganizationId(organizationId);

			for (SPATOContacts contact : contactsList) {
				if (Validator.isNumber(contact.getPrimaryPrincipalUserId())) {
					User user = UserLocalServiceUtil.fetchUser(Long.parseLong(contact.getPrimaryPrincipalUserId()));
					contact.setPrimaryPrincipalUserFirstName(user.getFirstName());
					contact.setPrimaryPrincipalUserLastName(user.getLastName());
				}
			}
			return contactsList;
		} catch (SystemException e) {
			return null;
		}
	}

	public List<SPATOContacts> findATOSecondaryContactByOrganizationId(long organizationId) {
		try {

			List<SPATOContacts> contactsList = getSPATOContactsPersistence().findByOrganizationId(organizationId);

			for (SPATOContacts contact : contactsList) {
				if (Validator.isNumber(contact.getSecondaryPrincipalUserId())) {
					User user = UserLocalServiceUtil.fetchUser(Long.parseLong(contact.getSecondaryPrincipalUserId()));
					contact.setSecondaryPrincipalUserFirstName(user.getFirstName());
					contact.setSecondaryPrincipalUserLastName(user.getLastName());
				}
			}
			return contactsList;
		} catch (SystemException e) {
			return null;
		}
	}

	public List<SPATOContacts> findATOContactsByOrganizationId(long organizationId) {
		try {

			List<SPATOContacts> contactsList = getSPATOContactsPersistence().findByOrganizationId(organizationId);

			for (SPATOContacts contact : contactsList) {
				if (Validator.isNumber(contact.getPrimaryPrincipalUserId())) {
					User user = UserLocalServiceUtil.fetchUser(Long.parseLong(contact.getPrimaryPrincipalUserId()));
					contact.setPrimaryPrincipalUserFirstName(user.getFirstName());
					contact.setPrimaryPrincipalUserLastName(user.getLastName());
					contact.setPrimaryPrincipalUserEmail(user.getEmailAddress());
				}

				if (Validator.isNumber(contact.getSecondaryPrincipalUserId())) {
					User user = UserLocalServiceUtil.fetchUser(Long.parseLong(contact.getSecondaryPrincipalUserId()));
					contact.setSecondaryPrincipalUserFirstName(user.getFirstName());
					contact.setSecondaryPrincipalUserLastName(user.getLastName());
					contact.setSecondaryPrincipalUserEmail(user.getEmailAddress());
				}
			}
			return contactsList;
		} catch (SystemException e) {
			return null;
		}
	}
	public List<SPATOContacts> findATOContactsByTrainingPrincipal(long userId) {
		try {

			List<SPATOContacts> contactsList = getSPATOContactsPersistence().findByPrimaryPrincipalUserId(String.valueOf(userId));

			return contactsList;
		} catch (SystemException e) {
			return null;
		}
	}
	public List<SPATOContacts> findATOContactsBySecondaryContact(long userId) {
		try {

			List<SPATOContacts> contactsList = getSPATOContactsPersistence().findBySecondaryPrincipalUserId(String.valueOf(userId));

			return contactsList;
		} catch (SystemException e) {
			return null;
		}
	}
}