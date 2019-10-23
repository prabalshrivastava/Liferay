package com.sambaash.platform.portlet.search.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sambaash.platform.srv.spgroup.model.SPGroup;

public class GroupDetailModifiedDateComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "modifiedDate ASC";

	public static String ORDER_BY_DESC = "modifiedDate DESC";

	public static String[] ORDER_BY_FIELDS = {"modifiedDate"};

	public GroupDetailModifiedDateComparator() {
		this(false);
	}

	public GroupDetailModifiedDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		SPGroup entry1 = (SPGroup)obj1;
		SPGroup entry2 = (SPGroup)obj2;

		int value = DateUtil.compareTo(
			entry1.getModifiedDate(), entry2.getModifiedDate());

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
