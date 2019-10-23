package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class PEPricingList extends PENodeListImpl {

	private List<PEPricing> list;

	public List<PEPricing> getList() {

		if (list == null) {
			list = new ArrayList<>();
		}

		return list;
	}

	@XmlElement(name ="pricing")
	public void setList(List<PEPricing> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}