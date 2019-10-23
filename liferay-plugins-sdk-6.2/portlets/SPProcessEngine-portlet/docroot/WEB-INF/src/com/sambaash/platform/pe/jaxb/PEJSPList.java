package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEJSPList extends PENodeListImpl {

	private List<PEJSP> list;

	public List<PEJSP> getList() {

		if (list == null) {
			list = new ArrayList<PEJSP>();
		}

		return list;
	}

	@XmlElement(name ="jsp")
	public void setList(List<PEJSP> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}