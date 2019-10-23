package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEStatusList extends PENodeListImpl {

	private List<PEStatus> list;

	public List<PEStatus> getList() {

		if (list == null) {
			list = new ArrayList<PEStatus>();
		}

		return list;
	}

	@XmlElement(name ="status")
	public void setList(List<PEStatus> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}