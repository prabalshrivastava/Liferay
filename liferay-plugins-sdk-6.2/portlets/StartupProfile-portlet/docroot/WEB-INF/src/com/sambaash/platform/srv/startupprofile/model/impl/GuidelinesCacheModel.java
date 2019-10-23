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

import com.sambaash.platform.srv.startupprofile.model.Guidelines;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Guidelines in entity cache.
 *
 * @author pradeep
 * @see Guidelines
 * @generated
 */
public class GuidelinesCacheModel implements CacheModel<Guidelines>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", guidelineId=");
		sb.append(guidelineId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", principleId=");
		sb.append(principleId);
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
		sb.append(", moreInfo=");
		sb.append(moreInfo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Guidelines toEntityModel() {
		GuidelinesImpl guidelinesImpl = new GuidelinesImpl();

		if (uuid == null) {
			guidelinesImpl.setUuid(StringPool.BLANK);
		}
		else {
			guidelinesImpl.setUuid(uuid);
		}

		guidelinesImpl.setGuidelineId(guidelineId);
		guidelinesImpl.setOrganizationId(organizationId);
		guidelinesImpl.setPrincipleId(principleId);
		guidelinesImpl.setGuideline1(guideline1);
		guidelinesImpl.setGuideline2(guideline2);
		guidelinesImpl.setGuideline3(guideline3);
		guidelinesImpl.setGuideline4(guideline4);
		guidelinesImpl.setGuideline5(guideline5);
		guidelinesImpl.setGuideline6(guideline6);
		guidelinesImpl.setGuideline7(guideline7);
		guidelinesImpl.setGuideline8(guideline8);

		if (moreInfo == null) {
			guidelinesImpl.setMoreInfo(StringPool.BLANK);
		}
		else {
			guidelinesImpl.setMoreInfo(moreInfo);
		}

		guidelinesImpl.resetOriginalValues();

		return guidelinesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		guidelineId = objectInput.readLong();
		organizationId = objectInput.readLong();
		principleId = objectInput.readLong();
		guideline1 = objectInput.readBoolean();
		guideline2 = objectInput.readBoolean();
		guideline3 = objectInput.readBoolean();
		guideline4 = objectInput.readBoolean();
		guideline5 = objectInput.readBoolean();
		guideline6 = objectInput.readBoolean();
		guideline7 = objectInput.readBoolean();
		guideline8 = objectInput.readBoolean();
		moreInfo = objectInput.readUTF();
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

		objectOutput.writeLong(guidelineId);
		objectOutput.writeLong(organizationId);
		objectOutput.writeLong(principleId);
		objectOutput.writeBoolean(guideline1);
		objectOutput.writeBoolean(guideline2);
		objectOutput.writeBoolean(guideline3);
		objectOutput.writeBoolean(guideline4);
		objectOutput.writeBoolean(guideline5);
		objectOutput.writeBoolean(guideline6);
		objectOutput.writeBoolean(guideline7);
		objectOutput.writeBoolean(guideline8);

		if (moreInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moreInfo);
		}
	}

	public String uuid;
	public long guidelineId;
	public long organizationId;
	public long principleId;
	public boolean guideline1;
	public boolean guideline2;
	public boolean guideline3;
	public boolean guideline4;
	public boolean guideline5;
	public boolean guideline6;
	public boolean guideline7;
	public boolean guideline8;
	public String moreInfo;
}