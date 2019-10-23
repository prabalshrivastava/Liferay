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
import com.sambaash.platform.srv.spinbox.model.IBMessageDetail;

/**
 * <a href="ArticleModifiedDateComparator.java.html"><b><i>View Source</i></b>
 * </a>
 *
 * @author Brian Wing Shun Chan
 */
@SuppressWarnings("serial")
public class IBMessageDetailReceiveDateComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "receiveDate ASC";

	public static String ORDER_BY_DESC = "receiveDate DESC";

	public static String[] ORDER_BY_FIELDS = {"receiveDate"};

	public IBMessageDetailReceiveDateComparator() {
		this(false);
	}

	public IBMessageDetailReceiveDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		IBMessageDetail md1 = (IBMessageDetail)obj1;
		IBMessageDetail md2 = (IBMessageDetail)obj2;

		int value = DateUtil.compareTo(
				md1.getReceiveDate(), md2.getReceiveDate());

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