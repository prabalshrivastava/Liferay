/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.sambaash.platform.portlet.spinbox.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sambaash.platform.srv.spinbox.model.IBMessage;

/**
 * <a href="ArticleModifiedDateComparator.java.html"><b><i>View Source</i></b>
 * </a>
 *
 * @author Brian Wing Shun Chan
 */
@SuppressWarnings("serial")
public class IBMessageCreateDateComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "createDate ASC";

	public static String ORDER_BY_DESC = "createDate DESC";

	public static String[] ORDER_BY_FIELDS = {"createDate"};

	public IBMessageCreateDateComparator() {
		this(false);
	}

	public IBMessageCreateDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		IBMessage m1 = (IBMessage)obj1;
		IBMessage m2 = (IBMessage)obj2;

		int value = DateUtil.compareTo(m1.getCreateDate(), m2.getCreateDate());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}