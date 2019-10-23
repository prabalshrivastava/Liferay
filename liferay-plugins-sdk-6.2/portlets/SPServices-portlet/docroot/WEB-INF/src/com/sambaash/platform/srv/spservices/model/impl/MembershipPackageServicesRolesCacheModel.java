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

import com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MembershipPackageServicesRoles in entity cache.
 *
 * @author gauravvijayvergia
 * @see MembershipPackageServicesRoles
 * @generated
 */
public class MembershipPackageServicesRolesCacheModel implements CacheModel<MembershipPackageServicesRoles>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{mpgsrlId=");
		sb.append(mpgsrlId);
		sb.append(", mpId=");
		sb.append(mpId);
		sb.append(", serviceId=");
		sb.append(serviceId);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", extra1=");
		sb.append(extra1);
		sb.append(", extra2=");
		sb.append(extra2);
		sb.append(", extra3=");
		sb.append(extra3);
		sb.append(", extra4=");
		sb.append(extra4);
		sb.append(", extra5=");
		sb.append(extra5);
		sb.append(", extra6=");
		sb.append(extra6);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MembershipPackageServicesRoles toEntityModel() {
		MembershipPackageServicesRolesImpl membershipPackageServicesRolesImpl = new MembershipPackageServicesRolesImpl();

		membershipPackageServicesRolesImpl.setMpgsrlId(mpgsrlId);
		membershipPackageServicesRolesImpl.setMpId(mpId);
		membershipPackageServicesRolesImpl.setServiceId(serviceId);
		membershipPackageServicesRolesImpl.setClassNameId(classNameId);
		membershipPackageServicesRolesImpl.setRoleId(roleId);

		if (extra1 == null) {
			membershipPackageServicesRolesImpl.setExtra1(StringPool.BLANK);
		}
		else {
			membershipPackageServicesRolesImpl.setExtra1(extra1);
		}

		if (extra2 == null) {
			membershipPackageServicesRolesImpl.setExtra2(StringPool.BLANK);
		}
		else {
			membershipPackageServicesRolesImpl.setExtra2(extra2);
		}

		if (extra3 == null) {
			membershipPackageServicesRolesImpl.setExtra3(StringPool.BLANK);
		}
		else {
			membershipPackageServicesRolesImpl.setExtra3(extra3);
		}

		if (extra4 == null) {
			membershipPackageServicesRolesImpl.setExtra4(StringPool.BLANK);
		}
		else {
			membershipPackageServicesRolesImpl.setExtra4(extra4);
		}

		if (extra5 == Long.MIN_VALUE) {
			membershipPackageServicesRolesImpl.setExtra5(null);
		}
		else {
			membershipPackageServicesRolesImpl.setExtra5(new Date(extra5));
		}

		if (extra6 == Long.MIN_VALUE) {
			membershipPackageServicesRolesImpl.setExtra6(null);
		}
		else {
			membershipPackageServicesRolesImpl.setExtra6(new Date(extra6));
		}

		membershipPackageServicesRolesImpl.resetOriginalValues();

		return membershipPackageServicesRolesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mpgsrlId = objectInput.readLong();
		mpId = objectInput.readLong();
		serviceId = objectInput.readLong();
		classNameId = objectInput.readLong();
		roleId = objectInput.readLong();
		extra1 = objectInput.readUTF();
		extra2 = objectInput.readUTF();
		extra3 = objectInput.readUTF();
		extra4 = objectInput.readUTF();
		extra5 = objectInput.readLong();
		extra6 = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(mpgsrlId);
		objectOutput.writeLong(mpId);
		objectOutput.writeLong(serviceId);
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(roleId);

		if (extra1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra1);
		}

		if (extra2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra2);
		}

		if (extra3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra3);
		}

		if (extra4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra4);
		}

		objectOutput.writeLong(extra5);
		objectOutput.writeLong(extra6);
	}

	public long mpgsrlId;
	public long mpId;
	public long serviceId;
	public long classNameId;
	public long roleId;
	public String extra1;
	public String extra2;
	public String extra3;
	public String extra4;
	public long extra5;
	public long extra6;
}