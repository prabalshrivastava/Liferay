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

package com.sambaash.platform.srv.spgroup.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author harini
 * @generated
 */
public class SPGroupUserPK implements Comparable<SPGroupUserPK>, Serializable {
	public long spGroupId;
	public long userId;

	public SPGroupUserPK() {
	}

	public SPGroupUserPK(long spGroupId, long userId) {
		this.spGroupId = spGroupId;
		this.userId = userId;
	}

	public long getSpGroupId() {
		return spGroupId;
	}

	public void setSpGroupId(long spGroupId) {
		this.spGroupId = spGroupId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public int compareTo(SPGroupUserPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (spGroupId < pk.spGroupId) {
			value = -1;
		}
		else if (spGroupId > pk.spGroupId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (userId < pk.userId) {
			value = -1;
		}
		else if (userId > pk.userId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPGroupUserPK)) {
			return false;
		}

		SPGroupUserPK pk = (SPGroupUserPK)obj;

		if ((spGroupId == pk.spGroupId) && (userId == pk.userId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(spGroupId) + String.valueOf(userId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("spGroupId");
		sb.append(StringPool.EQUAL);
		sb.append(spGroupId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("userId");
		sb.append(StringPool.EQUAL);
		sb.append(userId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}