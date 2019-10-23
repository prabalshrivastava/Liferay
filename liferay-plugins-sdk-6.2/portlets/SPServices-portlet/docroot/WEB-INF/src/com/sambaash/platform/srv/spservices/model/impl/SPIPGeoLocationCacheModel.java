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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spservices.model.SPIPGeoLocation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SPIPGeoLocation in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPIPGeoLocation
 * @generated
 */
public class SPIPGeoLocationCacheModel implements CacheModel<SPIPGeoLocation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spIPGeoLocationId=");
		sb.append(spIPGeoLocationId);
		sb.append(", ipPrefix=");
		sb.append(ipPrefix);
		sb.append(", country=");
		sb.append(country);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPIPGeoLocation toEntityModel() {
		SPIPGeoLocationImpl spipGeoLocationImpl = new SPIPGeoLocationImpl();

		if (uuid == null) {
			spipGeoLocationImpl.setUuid(StringPool.BLANK);
		}
		else {
			spipGeoLocationImpl.setUuid(uuid);
		}

		spipGeoLocationImpl.setSpIPGeoLocationId(spIPGeoLocationId);

		if (ipPrefix == null) {
			spipGeoLocationImpl.setIpPrefix(StringPool.BLANK);
		}
		else {
			spipGeoLocationImpl.setIpPrefix(ipPrefix);
		}

		if (country == null) {
			spipGeoLocationImpl.setCountry(StringPool.BLANK);
		}
		else {
			spipGeoLocationImpl.setCountry(country);
		}

		spipGeoLocationImpl.resetOriginalValues();

		return spipGeoLocationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spIPGeoLocationId = objectInput.readLong();
		ipPrefix = objectInput.readUTF();
		country = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(spIPGeoLocationId);

		if (ipPrefix == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ipPrefix);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}
	}

	public String uuid;
	public long spIPGeoLocationId;
	public String ipPrefix;
	public String country;
}