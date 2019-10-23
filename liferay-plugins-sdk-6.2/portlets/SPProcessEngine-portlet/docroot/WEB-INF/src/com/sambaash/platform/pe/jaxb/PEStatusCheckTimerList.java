package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEStatusCheckTimerList extends PENodeListImpl {

	private List<PEStatusCheckTimer> list;

	public List<PEStatusCheckTimer> getList() {

		if (list == null) {
			list = new ArrayList<PEStatusCheckTimer>();
		}

		return list;
	}

	@XmlElement(name ="statusCheckTimer")
	public void setList(List<PEStatusCheckTimer> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}