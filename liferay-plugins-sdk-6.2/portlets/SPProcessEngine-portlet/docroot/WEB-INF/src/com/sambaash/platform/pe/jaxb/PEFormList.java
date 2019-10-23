package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEFormList extends PENodeListImpl {

	public List<PEForm> getList() {

		if (list == null) {
			list = new ArrayList<PEForm>();
		}

		return list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	} 

	@XmlElement(name ="form")
	public void setList(List<PEForm> list) {
		this.list = list;
	}

	public String toString() {
		return "FormList [list=" + list + "]";
	}

	private List<PEForm> list;

}