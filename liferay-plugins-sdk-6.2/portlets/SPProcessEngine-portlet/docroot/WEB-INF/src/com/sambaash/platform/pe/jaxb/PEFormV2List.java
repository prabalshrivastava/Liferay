package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEFormV2List extends PENodeListImpl {
	private List<PEFormV2> list;

	public List<PEFormV2> getList() {

		if (list == null) {
			list = new ArrayList<>();
		}

		return list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	} 

	@XmlElement(name ="formV2")
	public void setList(List<PEFormV2> list) {
		this.list = list;
	}

	public String toString() {
		return "FormV2List [list=" + list + "]";
	}

}