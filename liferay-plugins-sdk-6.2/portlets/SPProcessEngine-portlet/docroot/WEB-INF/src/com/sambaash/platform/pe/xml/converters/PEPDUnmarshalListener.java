package com.sambaash.platform.pe.xml.converters;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.pe.jaxb.PEProcessableNode;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.Unmarshaller.Listener;
public class PEPDUnmarshalListener extends Listener {

	@Override
	public void afterUnmarshal(Object target, Object parent) {
		if (target instanceof PEProcessableNode) {
			PEProcessableNode node = (PEProcessableNode)target;
			_log.debug("Adding node " + node);
			nodeDir.put(node.getNodeId(), node);
		}
	}

	public Map<Long, PEProcessableNode> getNodeDir() {
		return nodeDir;
	} private Map<Long, PEProcessableNode> nodeDir = new HashMap<>();

	private static Log _log = LogFactoryUtil.getLog(PEPDUnmarshalListener.class);

}