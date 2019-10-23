package com.sambaash.platform.pe;

import com.liferay.portal.kernel.util.StringPool;

public class PEEntityImpl implements PEEntity {
	
	private String name = StringPool.BLANK;
	private String name1 = StringPool.BLANK;
	private String desc = StringPool.BLANK;
	private long id = 0;
	private long classNameId = 0;
	private long siteId = 0;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String getDesc() {
		return desc;
	}

	@Override
	public void setName1(String name) {
		this.name1 = name;
	}

	@Override
	public String getName1() {
		return name1;
	}

	@Override
	public void setClassNameId(long id) {
		classNameId = id;
	}

	@Override
	public long getClassNameId() {
		return classNameId;
	}
	
	@Override
	public void setSiteId(long sId) {
		siteId = sId;
	}

	@Override
	public long getSiteId() {
		return siteId;
	}

}
