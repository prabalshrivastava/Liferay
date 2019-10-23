package com.sambaash.platform.pe.handlers;

import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.jaxb.SingleOutputNode;
public abstract class PESingleOutputNodeHandler extends PENodeHandlerImpl {

	protected SingleOutputNode node;

	PESingleOutputNodeHandler(SingleOutputNode node, PEDataSource ds) {
		super(ds);
		this.node = node;
	}

}