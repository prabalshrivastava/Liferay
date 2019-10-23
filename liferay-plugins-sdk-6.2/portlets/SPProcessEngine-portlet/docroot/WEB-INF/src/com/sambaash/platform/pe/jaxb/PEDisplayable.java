package com.sambaash.platform.pe.jaxb;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.exception.PEException;
public interface PEDisplayable extends PEProcessableNode{

	void fillOutput(PEOutput output);
	boolean canProceedToNextStep(PEDataSource dataSource)  throws SystemException, PEException,PortalException;
}