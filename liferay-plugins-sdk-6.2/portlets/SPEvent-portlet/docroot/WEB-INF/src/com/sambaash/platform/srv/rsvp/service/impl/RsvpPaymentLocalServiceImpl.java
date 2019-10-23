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

import com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;
import com.sambaash.platform.srv.rsvp.model.RsvpPayment;
import com.sambaash.platform.srv.rsvp.service.base.RsvpPaymentLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the rsvp payment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.rsvp.service.RsvpPaymentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.rsvp.service.base.RsvpPaymentLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.rsvp.service.RsvpPaymentLocalServiceUtil
 */
public class RsvpPaymentLocalServiceImpl extends RsvpPaymentLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.rsvp.service.RsvpPaymentLocalServiceUtil} to access the rsvp payment local service.
	 */

	public List<RsvpPayment> findByRsvpDetailId(long rsvpDetailId)
			throws SystemException {
		return rsvpPaymentPersistence.findByRsvpDetailId(rsvpDetailId);
	}

	public List<RsvpPayment> findByRsvpDetailIdTransactionStatus(long rsvpDetailId, java.lang.String transactionStatus)
			throws SystemException {
		return rsvpPaymentPersistence.findByRsvpDetailIdTransactionStatus(rsvpDetailId, transactionStatus);
	}

	public RsvpPayment findByTicketNumber(String ticketNumber)
			throws NoSuchRsvpPaymentException, SystemException {
		return rsvpPaymentPersistence.findByTicketNumber(ticketNumber);
	}

}