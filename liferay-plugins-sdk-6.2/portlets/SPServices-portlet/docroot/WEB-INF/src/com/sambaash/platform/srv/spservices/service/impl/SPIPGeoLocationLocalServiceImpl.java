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

package com.sambaash.platform.srv.spservices.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.srv.spservices.model.SPIPGeoLocation;
import com.sambaash.platform.srv.spservices.model.impl.SPIPGeoLocationImpl;
import com.sambaash.platform.srv.spservices.service.base.SPIPGeoLocationLocalServiceBaseImpl;

/**
 * The implementation of the s p i p geo location local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.SPIPGeoLocationLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.SPIPGeoLocationLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.SPIPGeoLocationLocalServiceUtil
 */
public class SPIPGeoLocationLocalServiceImpl extends SPIPGeoLocationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.spservices.service.SPIPGeoLocationLocalServiceUtil} to access the s
	 * p i p geo location local service.
	 */

	private static Log _log = LogFactoryUtil.getLog(SPIPGeoLocationLocalServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * sambaash.platform
	 * .srv.spipgeolocation.service.SPIPGeoLocationLocalServiceUtil} to access
	 * the s p i p geo location local service.
	 */
	public String findCountryISOByIpAddress(String ipAddress) {
		try {
			ipAddress = getPrefix(ipAddress);
			List<SPIPGeoLocation> geoLocationList = spipGeoLocationPersistence.findByipPrefixLike(ipAddress);
			if (Validator.isNotNull(geoLocationList) && geoLocationList.size() > 0) {
				return geoLocationList.get(0).getCountry();
			}
		} catch (Exception e) {
			_log.error("could not find ip address", e);
		}
		return null;
	}

	public void addSPIPGeoLocation(String ip, String countryCode) {
		try {
			ip = getPrefix(ip);
			SPIPGeoLocation geoLocation = new SPIPGeoLocationImpl();
			geoLocation.setSpIPGeoLocationId(CounterLocalServiceUtil.increment("SPIPGeoLocation"));
			geoLocation.setNew(true);
			geoLocation.setIpPrefix(ip);
			geoLocation.setCountry(countryCode.toLowerCase());
			this.addSPIPGeoLocation(geoLocation);
		} catch (Exception e) {
			_log.error("could not add ip address", e);
		}
	}

	private String getPrefix(String ipAddress) {
		int index = ordinalIndexOf(ipAddress, '.', 2);
		if (index > 0) {
			ipAddress = ipAddress.substring(0, index);
		}
		return ipAddress;
	}

	private static int ordinalIndexOf(String str, char c, int n) {
		int pos = str.indexOf(c, 0);
		while (n-- > 0 && pos != -1)
			pos = str.indexOf(c, pos + 1);
		return pos;
	}

}