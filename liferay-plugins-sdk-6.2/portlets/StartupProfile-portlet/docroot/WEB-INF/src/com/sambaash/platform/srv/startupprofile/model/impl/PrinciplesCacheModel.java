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

package com.sambaash.platform.srv.startupprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.startupprofile.model.Principles;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Principles in entity cache.
 *
 * @author pradeep
 * @see Principles
 * @generated
 */
public class PrinciplesCacheModel implements CacheModel<Principles>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", siteId=");
		sb.append(siteId);
		sb.append(", principleId=");
		sb.append(principleId);
		sb.append(", principleText=");
		sb.append(principleText);
		sb.append(", guideline1=");
		sb.append(guideline1);
		sb.append(", guideline2=");
		sb.append(guideline2);
		sb.append(", guideline3=");
		sb.append(guideline3);
		sb.append(", guideline4=");
		sb.append(guideline4);
		sb.append(", guideline5=");
		sb.append(guideline5);
		sb.append(", guideline6=");
		sb.append(guideline6);
		sb.append(", guideline7=");
		sb.append(guideline7);
		sb.append(", guideline8=");
		sb.append(guideline8);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Principles toEntityModel() {
		PrinciplesImpl principlesImpl = new PrinciplesImpl();

		if (uuid == null) {
			principlesImpl.setUuid(StringPool.BLANK);
		}
		else {
			principlesImpl.setUuid(uuid);
		}

		principlesImpl.setSiteId(siteId);
		principlesImpl.setPrincipleId(principleId);

		if (principleText == null) {
			principlesImpl.setPrincipleText(StringPool.BLANK);
		}
		else {
			principlesImpl.setPrincipleText(principleText);
		}

		if (guideline1 == null) {
			principlesImpl.setGuideline1(StringPool.BLANK);
		}
		else {
			principlesImpl.setGuideline1(guideline1);
		}

		if (guideline2 == null) {
			principlesImpl.setGuideline2(StringPool.BLANK);
		}
		else {
			principlesImpl.setGuideline2(guideline2);
		}

		if (guideline3 == null) {
			principlesImpl.setGuideline3(StringPool.BLANK);
		}
		else {
			principlesImpl.setGuideline3(guideline3);
		}

		if (guideline4 == null) {
			principlesImpl.setGuideline4(StringPool.BLANK);
		}
		else {
			principlesImpl.setGuideline4(guideline4);
		}

		if (guideline5 == null) {
			principlesImpl.setGuideline5(StringPool.BLANK);
		}
		else {
			principlesImpl.setGuideline5(guideline5);
		}

		if (guideline6 == null) {
			principlesImpl.setGuideline6(StringPool.BLANK);
		}
		else {
			principlesImpl.setGuideline6(guideline6);
		}

		if (guideline7 == null) {
			principlesImpl.setGuideline7(StringPool.BLANK);
		}
		else {
			principlesImpl.setGuideline7(guideline7);
		}

		if (guideline8 == null) {
			principlesImpl.setGuideline8(StringPool.BLANK);
		}
		else {
			principlesImpl.setGuideline8(guideline8);
		}

		principlesImpl.resetOriginalValues();

		return principlesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		siteId = objectInput.readLong();
		principleId = objectInput.readLong();
		principleText = objectInput.readUTF();
		guideline1 = objectInput.readUTF();
		guideline2 = objectInput.readUTF();
		guideline3 = objectInput.readUTF();
		guideline4 = objectInput.readUTF();
		guideline5 = objectInput.readUTF();
		guideline6 = objectInput.readUTF();
		guideline7 = objectInput.readUTF();
		guideline8 = objectInput.readUTF();
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

		objectOutput.writeLong(siteId);
		objectOutput.writeLong(principleId);

		if (principleText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(principleText);
		}

		if (guideline1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(guideline1);
		}

		if (guideline2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(guideline2);
		}

		if (guideline3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(guideline3);
		}

		if (guideline4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(guideline4);
		}

		if (guideline5 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(guideline5);
		}

		if (guideline6 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(guideline6);
		}

		if (guideline7 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(guideline7);
		}

		if (guideline8 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(guideline8);
		}
	}

	public String uuid;
	public long siteId;
	public long principleId;
	public String principleText;
	public String guideline1;
	public String guideline2;
	public String guideline3;
	public String guideline4;
	public String guideline5;
	public String guideline6;
	public String guideline7;
	public String guideline8;
}