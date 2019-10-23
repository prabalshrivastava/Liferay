package com.sambaash.platform.pe;

public interface PEEntity {

	public void setName(String name);
	public String getName();
	
	// Name1 is just another name for entity. If name1 exists, it will be considered otherwise name will be considered
	// Some cases, entity requires another name to distinguish uniquely from other entity names
	public void setName1(String name);
	public String getName1();
	
	public void setId(long id);
	public long getId();

	public void setClassNameId(long id);
	public long getClassNameId();
	
	public void setDesc(String desc);
	public String getDesc();
	
	public void setSiteId(long siteId);
	public long getSiteId();
}
