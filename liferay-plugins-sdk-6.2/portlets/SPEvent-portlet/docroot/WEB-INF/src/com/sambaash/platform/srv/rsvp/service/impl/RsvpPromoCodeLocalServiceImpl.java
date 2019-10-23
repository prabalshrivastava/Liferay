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
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sambaash.platform.srv.rsvp.model.RsvpPromoCode;
import com.sambaash.platform.srv.rsvp.service.base.RsvpPromoCodeLocalServiceBaseImpl;
import com.sambaash.platform.srv.rsvp.service.persistence.RsvpPromoCodeUtil;

/**
 * The implementation of the rsvp promo code local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.rsvp.service.RsvpPromoCodeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.rsvp.service.base.RsvpPromoCodeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.rsvp.service.RsvpPromoCodeLocalServiceUtil
 */
public class RsvpPromoCodeLocalServiceImpl
	extends RsvpPromoCodeLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.rsvp.service.RsvpPromoCodeLocalServiceUtil} to access the rsvp promo code local service.
	 */

	public void clearCache() {
		RsvpPromoCodeUtil.clearCache();
	}

	public java.util.List<RsvpPromoCode> findByPromoCode(
		java.lang.String promoCode)
		throws SystemException {
		return rsvpPromoCodePersistence.findByPromoCode(promoCode);
	}

	public java.util.List<RsvpPromoCode> findByPromoCode(
		java.lang.String promoCode, int start, int end)
		throws SystemException {
		return rsvpPromoCodePersistence.findByPromoCode(promoCode, start, end);
	}

	public java.util.List<RsvpPromoCode> findByPromoCode(
		java.lang.String promoCode, int start, int end,
		OrderByComparator orderByComparator)
		throws SystemException {
		return rsvpPromoCodePersistence
				.findByPromoCode(promoCode, start, end, orderByComparator);
	}

	public java.util.List<RsvpPromoCode> findByrsvpId(
		long rsvpId) throws SystemException {
		return rsvpPromoCodePersistence.findByrsvpId(rsvpId);
	}

	public java.util.List<RsvpPromoCode> findByrsvpId(
		long rsvpId, int start, int end)
		throws SystemException {
		return rsvpPromoCodePersistence.findByrsvpId(rsvpId, start, end);
	}

	public java.util.List<RsvpPromoCode> findByrsvpId(
		long rsvpId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return rsvpPromoCodePersistence
				.findByrsvpId(rsvpId, start, end, orderByComparator);
	}

}