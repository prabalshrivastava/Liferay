package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEPaymentV2List extends PENodeListImpl {

	private List<PEPaymentV2> list;

	public List<PEPaymentV2> getList() {

		if (list == null) {
			list = new ArrayList<PEPaymentV2>();
		}

		return list;
	}

	@XmlElement(name ="paymentV2")
	public void setList(List<PEPaymentV2> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}