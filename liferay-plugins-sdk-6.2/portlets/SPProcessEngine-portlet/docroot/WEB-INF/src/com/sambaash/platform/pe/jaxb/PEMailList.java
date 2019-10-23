package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEMailList extends PENodeListImpl {

	private List<PEMail> list;

	public List<PEMail> getList() {

		if (list == null) {
			list = new ArrayList<PEMail>();
		}

		return list;
	}

	@XmlElement(name ="mail")
	public void setList(List<PEMail> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}