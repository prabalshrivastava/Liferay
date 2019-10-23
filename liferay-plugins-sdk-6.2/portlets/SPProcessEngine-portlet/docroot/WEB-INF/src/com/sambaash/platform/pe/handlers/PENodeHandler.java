package com.sambaash.platform.pe.handlers;

import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.jaxb.PEProcessableNodeOutput;
public interface PENodeHandler {

	PEProcessableNodeOutput process() throws PEException, SystemException;
}