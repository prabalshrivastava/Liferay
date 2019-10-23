package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEPaymentList extends PENodeListImpl {

	private List<PEPayment> list;

	public List<PEPayment> getList() {

		if (list == null) {
			list = new ArrayList<PEPayment>();
		}

		return list;
	}

	@XmlElement(name ="payment")
	public void setList(List<PEPayment> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}