package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEMsgList extends PENodeListImpl {

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}

	@XmlElement(name ="msg")
	public void setList(List<PEMsg> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MsgList [");

		if (list != null) {
			builder.append("list=");
			builder.append(list);
		}

		builder.append("]");
		return builder.toString();
	} public List<PEMsg> getList() {

		if (list == null) {
			list = new ArrayList<PEMsg>();
		}

		return list;
	}

	private List<PEMsg> list;

}