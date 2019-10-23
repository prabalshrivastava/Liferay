package com.sambaash.platform.portlet.dynamicdatalists.util;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;

public class DDLRecordCreateDateComparator extends OrderByComparator {

	private static final long serialVersionUID = 8555645479380447050L;

	public static final String ORDER_BY_ASC = "DDLRecord.createDate ASC";

	public static final String ORDER_BY_DESC = "DDLRecord.createDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"createDate"};

	public DDLRecordCreateDateComparator() {
		this(true);
	}

	public DDLRecordCreateDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		DDLRecord record1 = (DDLRecord)obj1;
		DDLRecord record2 = (DDLRecord)obj2;

		int value = DateUtil.compareTo(
				record1.getCreateDate(), record2.getCreateDate());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}

