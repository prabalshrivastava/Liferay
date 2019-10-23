package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PECustomActionList extends PENodeListImpl {

	private List<PECustomActionNode> list;

	public List<PECustomActionNode> getList() {

		if (list == null) {
			list = new ArrayList<PECustomActionNode>();
		}

		return list;
	}

	@XmlElement(name ="customAction")
	public void setList(List<PECustomActionNode> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}