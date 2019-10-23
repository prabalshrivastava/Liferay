/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.processbuilder.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.processbuilder.model.PERule;
import com.sambaash.platform.srv.processbuilder.service.base.PERuleLocalServiceBaseImpl;
import com.sambaash.platform.srv.processbuilder.service.persistence.PERuleUtil;

import java.util.List;

/**
 * The implementation of the p e rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.processbuilder.service.PERuleLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.processbuilder.service.base.PERuleLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.PERuleLocalServiceUtil
 */
public class PERuleLocalServiceImpl extends PERuleLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.processbuilder.service.PERuleLocalServiceUtil}
	 * to access the p e rule local service.
	 */

	public List<PERule> findByRuleSetId(long rulesetId) throws SystemException {
		return PERuleUtil.findByRuleSetId(rulesetId);
	}

}