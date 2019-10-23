package com.sambaash.platform.pe.rule;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.processbuilder.model.PERule;
public interface PERuleEngine {

	long evaluateRuleset() throws PortalException, SystemException;
	boolean evaluateRule(PERule rule);
}