package com.sambaash.platform.portlet.search.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sambaash.platform.srv.spgroup.model.SPGroup;

public class GroupUserDetailRegisterDateComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "registerDate ASC";

	public static String ORDER_BY_DESC = "registerDate DESC";

	public static String[] ORDER_BY_FIELDS = { "registerDate" };

	public GroupUserDetailRegisterDateComparator() {
		this(false);
	}

	public GroupUserDetailRegisterDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		SPGroup groupUserDetail1 = (SPGroup) obj1;
		SPGroup groupUserDetail2 = (SPGroup) obj2;

		int value = DateUtil.compareTo(groupUserDetail1.getCreateDate(), groupUserDetail2.getCreateDate());

		if (_ascending) {
			return value;
		} else {
			return -value;
		}
	}

	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		} else {
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
