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

package com.sambaash.platform.srv.contactus.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.contactus.model.SPContactUs;

/**
 * The persistence interface for the s p contact us service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPContactUsPersistenceImpl
 * @see SPContactUsUtil
 * @generated
 */
public interface SPContactUsPersistence extends BasePersistence<SPContactUs> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPContactUsUtil} to access the s p contact us persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the s p contact us in the entity cache if it is enabled.
	*
	* @param spContactUs the s p contact us
	*/
	public void cacheResult(
		com.sambaash.platform.srv.contactus.model.SPContactUs spContactUs);

	/**
	* Caches the s p contact uses in the entity cache if it is enabled.
	*
	* @param spContactUses the s p contact uses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.contactus.model.SPContactUs> spContactUses);

	/**
	* Creates a new s p contact us with the primary key. Does not add the s p contact us to the database.
	*
	* @param spContactUsId the primary key for the new s p contact us
	* @return the new s p contact us
	*/
	public com.sambaash.platform.srv.contactus.model.SPContactUs create(
		long spContactUsId);

	/**
	* Removes the s p contact us with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spContactUsId the primary key of the s p contact us
	* @return the s p contact us that was removed
	* @throws com.sambaash.platform.srv.contactus.NoSuchSPContactUsException if a s p contact us with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.contactus.model.SPContactUs remove(
		long spContactUsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.contactus.NoSuchSPContactUsException;

	public com.sambaash.platform.srv.contactus.model.SPContactUs updateImpl(
		com.sambaash.platform.srv.contactus.model.SPContactUs spContactUs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p contact us with the primary key or throws a {@link com.sambaash.platform.srv.contactus.NoSuchSPContactUsException} if it could not be found.
	*
	* @param spContactUsId the primary key of the s p contact us
	* @return the s p contact us
	* @throws com.sambaash.platform.srv.contactus.NoSuchSPContactUsException if a s p contact us with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.contactus.model.SPContactUs findByPrimaryKey(
		long spContactUsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.contactus.NoSuchSPContactUsException;

	/**
	* Returns the s p contact us with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spContactUsId the primary key of the s p contact us
	* @return the s p contact us, or <code>null</code> if a s p contact us with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.contactus.model.SPContactUs fetchByPrimaryKey(
		long spContactUsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p contact uses.
	*
	* @return the s p contact uses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.contactus.model.SPContactUs> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p contact uses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.contactus.model.impl.SPContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p contact uses
	* @param end the upper bound of the range of s p contact uses (not inclusive)
	* @return the range of s p contact uses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.contactus.model.SPContactUs> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p contact uses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.contactus.model.impl.SPContactUsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p contact uses
	* @param end the upper bound of the range of s p contact uses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p contact uses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.contactus.model.SPContactUs> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p contact uses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p contact uses.
	*
	* @return the number of s p contact uses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}