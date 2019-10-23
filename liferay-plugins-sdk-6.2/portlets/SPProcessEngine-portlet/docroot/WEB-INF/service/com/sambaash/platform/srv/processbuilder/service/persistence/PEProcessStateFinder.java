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

package com.sambaash.platform.srv.processbuilder.service.persistence;

/**
 * @author nareshchebolu
 */
public interface PEProcessStateFinder {
	public java.util.List<java.lang.Object> getOfflineFinancereport(
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date startDate1, java.util.Date endDate1,
		java.util.Date startDate2, java.util.Date endDate2)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object> getOnlineFinancereport(
		java.util.Date startDate, java.util.Date endDate,
		java.util.Date startDate1, java.util.Date endDate1,
		java.util.Date startDate2, java.util.Date endDate2)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object> getOfflineFinancereport(
		java.util.Date arg0, java.util.Date arg1)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object> getOnlineFinancereport(
		java.util.Date arg0, java.util.Date arg1)
		throws com.liferay.portal.kernel.exception.SystemException;
}