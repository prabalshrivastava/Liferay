package com.sambaash.platform.pe.jaxb;

import java.util.List;
public interface PENodeList extends PEContainerNode {

//	List<Node> getList();
//	void setList(List<Node> list);
	List<PEProcessableNode> getNodes();
}