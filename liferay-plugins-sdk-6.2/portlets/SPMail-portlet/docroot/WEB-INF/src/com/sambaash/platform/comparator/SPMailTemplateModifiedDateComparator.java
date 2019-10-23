package com.sambaash.platform.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sambaash.platform.srv.mail.model.SPMailTemplate;
public class SPMailTemplateModifiedDateComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "modifiedDate ASC";

	public static String ORDER_BY_DESC = "modifiedDate DESC";

	public static String[] ORDER_BY_FIELDS = {"modifiedDate"};

	public SPMailTemplateModifiedDateComparator() {
		this(false);
	}

	public SPMailTemplateModifiedDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		SPMailTemplate entry1 = (SPMailTemplate)obj1;
		SPMailTemplate entry2 = (SPMailTemplate)obj2;

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