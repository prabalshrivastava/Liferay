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

import com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;
import com.sambaash.platform.srv.rsvp.NoSuchRsvpException;
import com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail;
import com.sambaash.platform.srv.rsvp.service.base.RsvpCoParticipantDetailLocalServiceBaseImpl;
import com.sambaash.platform.srv.rsvp.service.persistence.RsvpCoParticipantDetailUtil;

import java.util.List;

/**
 * The implementation of the rsvp co participant detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.rsvp.service.RsvpCoParticipantDetailLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.rsvp.service.base.RsvpCoParticipantDetailLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.rsvp.service.RsvpCoParticipantDetailLocalServiceUtil
 */
public class RsvpCoParticipantDetailLocalServiceImpl
		extends RsvpCoParticipantDetailLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.rsvp.service.RsvpCoParticipantDetailLocalServiceUtil} to access the
	 * rsvp co participant detail local service.
	 */

	public List<RsvpCoParticipantDetail> findByRsvpDetailId(long rsvpDetailId)
			throws NoSuchRsvpException, SystemException {
		return RsvpCoParticipantDetailUtil.findByRsvpDetailId(rsvpDetailId);
	}

	public List<RsvpCoParticipantDetail> findByRsvpDetailIdAndSPRsvpPaymentId(
			long rsvpDetailId, long spRsvpPaymentId) throws SystemException,
			NoSuchRsvpException {
		return RsvpCoParticipantDetailUtil
				.findByRsvpDetailIdAndSPRsvpPaymentId(rsvpDetailId,
						spRsvpPaymentId);
	}

	public RsvpCoParticipantDetail findByTicketNumber(String ticketNumber)
			throws com.liferay.portal.kernel.exception.SystemException,
			NoSuchRsvpCoParticipantDetailException {
		return RsvpCoParticipantDetailUtil.findByTicketNumber(ticketNumber);
	}

}