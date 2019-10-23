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

package com.sambaash.platform.srv.rsvp.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.rsvp.NoSuchRsvpException;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.service.base.RsvpLocalServiceBaseImpl;

/**
 * The implementation of the rsvp local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.rsvp.service.RsvpLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.rsvp.service.base.RsvpLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil
 */
public class RsvpLocalServiceImpl extends RsvpLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil} to access the rsvp local service.
	 */

	public Rsvp findByeventId(long eventId) throws NoSuchRsvpException, SystemException {
		return rsvpPersistence.findByeventId(eventId);
	}

	public Rsvp findByeventIdAndSpAssetTypeId(long eventId, long spAssetTypeId) throws SystemException,
			NoSuchRsvpException {
		return rsvpPersistence.findByeventIdAndSpAssetTypeId(eventId, spAssetTypeId);
	}

	public Rsvp findByspAssetTypeId(long spAssetTypeId) throws NoSuchRsvpException, SystemException {
		return rsvpPersistence.findByspAssetTypeId(spAssetTypeId);
	}

}