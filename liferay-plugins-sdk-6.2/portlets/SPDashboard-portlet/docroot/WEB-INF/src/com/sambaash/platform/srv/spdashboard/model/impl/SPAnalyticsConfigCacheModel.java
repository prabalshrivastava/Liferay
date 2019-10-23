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

package com.sambaash.platform.srv.spdashboard.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SPAnalyticsConfig in entity cache.
 *
 * @author pradeep
 * @see SPAnalyticsConfig
 * @generated
 */
public class SPAnalyticsConfigCacheModel implements CacheModel<SPAnalyticsConfig>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{spAnalyticsConfigId=");
		sb.append(spAnalyticsConfigId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", config=");
		sb.append(config);
		sb.append(", type=");
		sb.append(type);
		sb.append(", query=");
		sb.append(query);
		sb.append(", warId=");
		sb.append(warId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPAnalyticsConfig toEntityModel() {
		SPAnalyticsConfigImpl spAnalyticsConfigImpl = new SPAnalyticsConfigImpl();

		spAnalyticsConfigImpl.setSpAnalyticsConfigId(spAnalyticsConfigId);

		if (name == null) {
			spAnalyticsConfigImpl.setName(StringPool.BLANK);
		}
		else {
			spAnalyticsConfigImpl.setName(name);
		}

		if (config == null) {
			spAnalyticsConfigImpl.setConfig(StringPool.BLANK);
		}
		else {
			spAnalyticsConfigImpl.setConfig(config);
		}

		spAnalyticsConfigImpl.setType(type);

		if (query == null) {
			spAnalyticsConfigImpl.setQuery(StringPool.BLANK);
		}
		else {
			spAnalyticsConfigImpl.setQuery(query);
		}

		if (warId == null) {
			spAnalyticsConfigImpl.setWarId(StringPool.BLANK);
		}
		else {
			spAnalyticsConfigImpl.setWarId(warId);
		}

		spAnalyticsConfigImpl.resetOriginalValues();

		return spAnalyticsConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spAnalyticsConfigId = objectInput.readLong();
		name = objectInput.readUTF();
		config = objectInput.readUTF();
		type = objectInput.readInt();
		query = objectInput.readUTF();
		warId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spAnalyticsConfigId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (config == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(config);
		}

		objectOutput.writeInt(type);

		if (query == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(query);
		}

		if (warId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(warId);
		}
	}

	public long spAnalyticsConfigId;
	public String name;
	public String config;
	public int type;
	public String query;
	public String warId;
}