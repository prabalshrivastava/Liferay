package com.sambaash.platform.pe.jaxb;

import javax.xml.bind.annotation.XmlElement;
public abstract class SingleOutputNodeImpl extends PEProcessableNodeImpl implements SingleOutputNode {
	@Override
	public long getNextNodeId() {
		return this.nextNodeId;
	}

	@XmlElement(name = "nextNodeId")
	public void setNextNodeId(long nodeId) {
		this.nextNodeId = nodeId;
	}

	private long nextNodeId;

}