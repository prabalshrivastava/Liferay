package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEEntityNodeList extends PENodeListImpl {

	private List<PEEntityNode> list;

	public List<PEEntityNode> getList() {

		if (list == null) {
			list = new ArrayList<PEEntityNode>();
		}

		return list;
	}

	@XmlElement(name ="entity")
	public void setList(List<PEEntityNode> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}