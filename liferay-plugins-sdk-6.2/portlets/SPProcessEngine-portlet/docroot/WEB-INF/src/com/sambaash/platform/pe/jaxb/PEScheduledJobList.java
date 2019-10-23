package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class PEScheduledJobList extends PENodeListImpl {

	private List<PEScheduledMail> list;

	public List<PEScheduledMail> getList() {

		if (list == null) {
			list = new ArrayList<>();
		}

		return list;
	}

	@XmlElement(name ="scheduledJob")
	public void setList(List<PEScheduledMail> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}