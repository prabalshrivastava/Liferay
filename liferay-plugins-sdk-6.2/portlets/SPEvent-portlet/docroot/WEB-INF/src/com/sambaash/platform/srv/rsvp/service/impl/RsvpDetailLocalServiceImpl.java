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

import com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;
import com.sambaash.platform.srv.rsvp.model.RsvpDetail;
import com.sambaash.platform.srv.rsvp.service.base.RsvpDetailLocalServiceBaseImpl;
import com.sambaash.platform.srv.rsvp.service.persistence.RsvpDetailFinderUtil;

import java.util.List;

/**
 * The implementation of the rsvp detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.rsvp.service.RsvpDetailLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.rsvp.service.base.RsvpDetailLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.rsvp.service.RsvpDetailLocalServiceUtil
 */
public class RsvpDetailLocalServiceImpl extends RsvpDetailLocalServiceBaseImpl {
	/**
	 * @param rsvpId
	 * @param start
	 * @param end
	 * @return List<Object<[]Object>>
	 * BigInteger rsvpPaymentId = (BigInteger) objectArray[0];
	 * String firstName = (String) objectArray[1];
	 * String lastName = (String) objectArray[2];
	 * String emailAddress = (String) objectArray[3];
	 * int attendance = (Integer) objectArray[4];
	 * int numberOfPeople = (Integer) objectArray[5];
	 * String transactionId = (String) objectArray[6];
	 * double amount = (Double) objectArray[7];
	 * Date transactionDate = (Date) objectArray[8];
	 * String userInfo = (String) objectArray[9];
	 * BigInteger rsvpDetailId = (BigInteger) objectArray[10];
	 * @throws SystemException
	 */
	public List<Object> findByCustomSqlAndRsvpId(long rsvpId, int start, int end) throws SystemException {
		return RsvpDetailFinderUtil.findByRsvpId(rsvpId, start, end);
	}

	/**
	 * @param rsvpId
	 * @param emailAddress
	 * @param start
	 * @param end
	 * @return List<Object<[]Object>>
	 * BigInteger rsvpPaymentId = (BigInteger) objectArray[0];
	 * String firstName = (String) objectArray[1];
	 * String lastName = (String) objectArray[2];
	 * String emailAddress = (String) objectArray[3];
	 * int attendance = (Integer) objectArray[4];
	 * int numberOfPeople = (Integer) objectArray[5];
	 * String transactionId = (String) objectArray[6];
	 * double amount = (Double) objectArray[7];
	 * Date transactionDate = (Date) objectArray[8];
	 * String userInfo = (String) objectArray[9];
	 * BigInteger rsvpDetailId = (BigInteger) objectArray[10];
	 * @throws SystemException
	 */
	public List<Object> findByCustomSqlRsvpIdAndEMailAddress(long rsvpId, String emailAddress, int start, int end)
			throws SystemException {
		return RsvpDetailFinderUtil.findByEmailAddress(rsvpId, emailAddress, start, end);
	}

	/**
	 * @param rsvpId
	 * @param firstName
	 * @param lastName
	 * @param start
	 * @param end
	 * @return List<Object<[]Object>>
	 * BigInteger rsvpPaymentId = (BigInteger) objectArray[0];
	 * String firstName = (String) objectArray[1];
	 * String lastName = (String) objectArray[2];
	 * String emailAddress = (String) objectArray[3];
	 * int attendance = (Integer) objectArray[4];
	 * int numberOfPeople = (Integer) objectArray[5];
	 * String transactionId = (String) objectArray[6];
	 * double amount = (Double) objectArray[7];
	 * Date transactionDate = (Date) objectArray[8];
	 * String userInfo = (String) objectArray[9];
	 * BigInteger rsvpDetailId = (BigInteger) objectArray[10];
	 * @throws SystemException
	 */

	public List<Object> findByCustomSqlRsvpIdAndName(long rsvpId, String firstName, String lastName, int start, int end)
			throws SystemException {
		return RsvpDetailFinderUtil.findByName(rsvpId, firstName, lastName, start, end);
	}

	public List<RsvpDetail> findByemailAddress(String emailAddress) throws SystemException {
		return rsvpDetailPersistence.findByemailAddress(emailAddress);
	}

	public List<RsvpDetail> findByemailAddressAndRsvpId(long rsvpId, String emailAddress) throws SystemException,
	NoSuchRsvpDetailException {
		return rsvpDetailPersistence.findByemailAddressAndRsvpId(rsvpId, emailAddress);
	}
	
	public List<RsvpDetail> findBynameAndRsvpId(String firstName,long rsvpId) throws SystemException,
	NoSuchRsvpDetailException {
		return rsvpDetailPersistence.findBynameAndRsvpId(firstName, rsvpId);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.rsvp.service.RsvpDetailLocalServiceUtil} to access the rsvp detail local service.
	 */

	public List<RsvpDetail> findByRsvpId(long rsvpId) throws NoSuchRsvpDetailException, SystemException {
		return rsvpDetailPersistence.findByRsvpId(rsvpId);
	}

	public List<RsvpDetail> findByRsvpId(long rsvpId, int start, int end) throws NoSuchRsvpDetailException, SystemException {
		return rsvpDetailPersistence.findByRsvpId(rsvpId, start, end);
	}

	public List<RsvpDetail> findByrsvpIdAndAttendance(long rsvpId, int attendance) throws SystemException {
		return rsvpDetailPersistence.findByrsvpIdAndAttendance(rsvpId, attendance);
	}

	public List<RsvpDetail> findByrsvpIdAndAttendance(long rsvpId, int attendance, int start, int end)
			throws SystemException {
		return rsvpDetailPersistence.findByrsvpIdAndAttendance(rsvpId, attendance, start, end);
	}

	public List<RsvpDetail> findByrsvpIdAndSource(long rsvpId, int source) throws SystemException {
		return rsvpDetailPersistence.findByrsvpIdAndSource(rsvpId, source);
	}

	public List<RsvpDetail> findByrsvpStatusAndRsvpId(long rsvpId, int rsvpStatus) throws SystemException {
		return rsvpDetailPersistence.findByrsvpStatusAndRsvpId(rsvpId, rsvpStatus);
	}

	public List<RsvpDetail> findByrsvpStatusAndRsvpId(long rsvpId, int rsvpStatus, int start, int end)
			throws SystemException {
		return rsvpDetailPersistence.findByrsvpStatusAndRsvpId(rsvpId, rsvpStatus, start, end);
	}

}