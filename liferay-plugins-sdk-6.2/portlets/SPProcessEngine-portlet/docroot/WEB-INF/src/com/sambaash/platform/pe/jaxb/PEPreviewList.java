package com.sambaash.platform.pe.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
public class PEPreviewList extends PENodeListImpl {

	private List<PEPreview> list;

	public List<PEPreview> getList() {

		if (list == null) {
			list = new ArrayList<PEPreview>();
		}

		return list;
	}

	@XmlElement(name ="preview")
	public void setList(List<PEPreview> list) {
		this.list = list;
	}

	public List<PEProcessableNode> getNodes() {
		return new ArrayList<PEProcessableNode>(getList());
	}
}