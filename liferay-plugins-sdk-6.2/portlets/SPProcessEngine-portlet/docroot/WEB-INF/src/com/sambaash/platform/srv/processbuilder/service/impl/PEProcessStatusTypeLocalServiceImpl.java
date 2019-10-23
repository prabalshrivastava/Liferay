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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.service.base.PEProcessStatusTypeLocalServiceBaseImpl;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessStatusTypeUtil;

/**
 * The implementation of the p e process status type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEProcessStatusTypeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil
 */
public class PEProcessStatusTypeLocalServiceImpl extends PEProcessStatusTypeLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.processbuilder.service.PEProcessStatusTypeLocalServiceUtil} to
	 * access the p e process status type local service.
	 */

	public List<PEProcessStatusType> findByProcessId(long processId) throws SystemException {
		OrderByComparator comparator = OrderByComparatorFactoryUtil.create(PEConstants.TABLE_PROCESS_STATUS_TYPE,
				"seqNo", true);
		return PEProcessStatusTypeUtil.findByspPEProcessId(processId, -1, -1, comparator);
	}
	public List<PEProcessStatusType> findByProcessIds(long[]processIdsArr) throws SystemException {
		OrderByComparator comparator = OrderByComparatorFactoryUtil.create(PEConstants.TABLE_PROCESS_STATUS_TYPE,
				PEConstants.COLUMN_SEQ_NO, true);
		//long[]processIdsArr = ArrayUtil.toArray(processIds.toArray(new Long[processIds.size()]));
		return PEProcessStatusTypeUtil.findByspPEProcessIds(processIdsArr, -1, -1, comparator);
	}
	
	public PEProcessStatusType create() throws SystemException {
		PEProcessStatusType processStatusType = peProcessStatusTypePersistence.create(counterLocalService.increment("PEProcessStatusType"));
		return processStatusType;
	}
}