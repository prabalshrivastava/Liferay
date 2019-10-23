package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class PEApiNodeList extends PENodeListImpl {

	private List<PEApiNode> list;

	public List<PEApiNode> getList() {

		if (list == null) {
			list = new ArrayList<>();
		}

		return list;
	}

	@XmlElement(name ="api")
	public void setList(List<PEApiNode> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}