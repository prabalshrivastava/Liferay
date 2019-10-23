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

package com.sambaash.platform.srv.processbuilder.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo;
import com.sambaash.platform.srv.processbuilder.service.PECustomActionInfoLocalServiceUtil;

/**
 * The extended model base implementation for the PECustomActionInfo service. Represents a row in the &quot;SPPECustomActionInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PECustomActionInfoImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see PECustomActionInfoImpl
 * @see com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo
 * @generated
 */
public abstract class PECustomActionInfoBaseImpl
	extends PECustomActionInfoModelImpl implements PECustomActionInfo {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a p e custom action info model instance should use the {@link PECustomActionInfo} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PECustomActionInfoLocalServiceUtil.addPECustomActionInfo(this);
		}
		else {
			PECustomActionInfoLocalServiceUtil.updatePECustomActionInfo(this);
		}
	}
}