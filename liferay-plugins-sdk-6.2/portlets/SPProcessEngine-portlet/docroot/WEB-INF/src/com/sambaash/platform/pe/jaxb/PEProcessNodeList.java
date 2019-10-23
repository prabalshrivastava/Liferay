package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEProcessNodeList extends PENodeListImpl {

	private List<PEProcessNode> list;

	public List<PEProcessNode> getList() {

		if (list == null) {
			list = new ArrayList<PEProcessNode>();
		}

		return list;
	}

	@XmlElement(name ="process")
	public void setList(List<PEProcessNode> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}