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

import com.sambaash.platform.srv.spservices.model.ServiceComponentGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceComponentGroup in entity cache.
 *
 * @author gauravvijayvergia
 * @see ServiceComponentGroup
 * @generated
 */
public class ServiceComponentGroupCacheModel implements CacheModel<ServiceComponentGroup>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{scgId=");
		sb.append(scgId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", phase=");
		sb.append(phase);
		sb.append(", status=");
		sb.append(status);
		sb.append(", version=");
		sb.append(version);
		sb.append(", deploymentCluster=");
		sb.append(deploymentCluster);
		sb.append(", community=");
		sb.append(community);
		sb.append(", dateAdded=");
		sb.append(dateAdded);
		sb.append(", dateModified=");
		sb.append(dateModified);
		sb.append(", author=");
		sb.append(author);
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
	public ServiceComponentGroup toEntityModel() {
		ServiceComponentGroupImpl serviceComponentGroupImpl = new ServiceComponentGroupImpl();

		serviceComponentGroupImpl.setScgId(scgId);

		if (name == null) {
			serviceComponentGroupImpl.setName(StringPool.BLANK);
		}
		else {
			serviceComponentGroupImpl.setName(name);
		}

		if (description == null) {
			serviceComponentGroupImpl.setDescription(StringPool.BLANK);
		}
		else {
			serviceComponentGroupImpl.setDescription(description);
		}

		if (phase == null) {
			serviceComponentGroupImpl.setPhase(StringPool.BLANK);
		}
		else {
			serviceComponentGroupImpl.setPhase(phase);
		}

		if (status == null) {
			serviceComponentGroupImpl.setStatus(StringPool.BLANK);
		}
		else {
			serviceComponentGroupImpl.setStatus(status);
		}

		if (version == null) {
			serviceComponentGroupImpl.setVersion(StringPool.BLANK);
		}
		else {
			serviceComponentGroupImpl.setVersion(version);
		}

		if (deploymentCluster == null) {
			serviceComponentGroupImpl.setDeploymentCluster(StringPool.BLANK);
		}
		else {
			serviceComponentGroupImpl.setDeploymentCluster(deploymentCluster);
		}

		if (community == null) {
			serviceComponentGroupImpl.setCommunity(StringPool.BLANK);
		}
		else {
			serviceComponentGroupImpl.setCommunity(community);
		}

		if (dateAdded == Long.MIN_VALUE) {
			serviceComponentGroupImpl.setDateAdded(null);
		}
		else {
			serviceComponentGroupImpl.setDateAdded(new Date(dateAdded));
		}

		if (dateModified == Long.MIN_VALUE) {
			serviceComponentGroupImpl.setDateModified(null);
		}
		else {
			serviceComponentGroupImpl.setDateModified(new Date(dateModified));
		}

		if (author == null) {
			serviceComponentGroupImpl.setAuthor(StringPool.BLANK);
		}
		else {
			serviceComponentGroupImpl.setAuthor(author);
		}

		if (extra1 == null) {
			serviceComponentGroupImpl.setExtra1(StringPool.BLANK);
		}
		else {
			serviceComponentGroupImpl.setExtra1(extra1);
		}

		if (extra2 == null) {
			serviceComponentGroupImpl.setExtra2(StringPool.BLANK);
		}
		else {
			serviceComponentGroupImpl.setExtra2(extra2);
		}

		if (extra3 == null) {
			serviceComponentGroupImpl.setExtra3(StringPool.BLANK);
		}
		else {
			serviceComponentGroupImpl.setExtra3(extra3);
		}

		if (extra4 == null) {
			serviceComponentGroupImpl.setExtra4(StringPool.BLANK);
		}
		else {
			serviceComponentGroupImpl.setExtra4(extra4);
		}

		if (extra5 == Long.MIN_VALUE) {
			serviceComponentGroupImpl.setExtra5(null);
		}
		else {
			serviceComponentGroupImpl.setExtra5(new Date(extra5));
		}

		if (extra6 == Long.MIN_VALUE) {
			serviceComponentGroupImpl.setExtra6(null);
		}
		else {
			serviceComponentGroupImpl.setExtra6(new Date(extra6));
		}

		serviceComponentGroupImpl.resetOriginalValues();

		return serviceComponentGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		scgId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		phase = objectInput.readUTF();
		status = objectInput.readUTF();
		version = objectInput.readUTF();
		deploymentCluster = objectInput.readUTF();
		community = objectInput.readUTF();
		dateAdded = objectInput.readLong();
		dateModified = objectInput.readLong();
		author = objectInput.readUTF();
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
		objectOutput.writeLong(scgId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (phase == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phase);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}

		if (deploymentCluster == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deploymentCluster);
		}

		if (community == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(community);
		}

		objectOutput.writeLong(dateAdded);
		objectOutput.writeLong(dateModified);

		if (author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(author);
		}

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

	public long scgId;
	public String name;
	public String description;
	public String phase;
	public String status;
	public String version;
	public String deploymentCluster;
	public String community;
	public long dateAdded;
	public long dateModified;
	public String author;
	public String extra1;
	public String extra2;
	public String extra3;
	public String extra4;
	public long extra5;
	public long extra6;
}