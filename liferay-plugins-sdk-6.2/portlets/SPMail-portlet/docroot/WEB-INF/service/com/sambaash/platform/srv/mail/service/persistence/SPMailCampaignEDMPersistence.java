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

package com.sambaash.platform.srv.mail.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;

/**
 * The persistence interface for the s p mail campaign e d m service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignEDMPersistenceImpl
 * @see SPMailCampaignEDMUtil
 * @generated
 */
public interface SPMailCampaignEDMPersistence extends BasePersistence<SPMailCampaignEDM> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPMailCampaignEDMUtil} to access the s p mail campaign e d m persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p mail campaign e d ms where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @return the matching s p mail campaign e d ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignEDM> findByCampaignId(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail campaign e d ms where spMailCampaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignEDMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param start the lower bound of the range of s p mail campaign e d ms
	* @param end the upper bound of the range of s p mail campaign e d ms (not inclusive)
	* @return the range of matching s p mail campaign e d ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignEDM> findByCampaignId(
		long spMailCampaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail campaign e d ms where spMailCampaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignEDMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param start the lower bound of the range of s p mail campaign e d ms
	* @param end the upper bound of the range of s p mail campaign e d ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign e d ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignEDM> findByCampaignId(
		long spMailCampaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail campaign e d m in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign e d m
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a matching s p mail campaign e d m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM findByCampaignId_First(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignEDMException;

	/**
	* Returns the first s p mail campaign e d m in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign e d m, or <code>null</code> if a matching s p mail campaign e d m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM fetchByCampaignId_First(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail campaign e d m in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign e d m
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a matching s p mail campaign e d m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM findByCampaignId_Last(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignEDMException;

	/**
	* Returns the last s p mail campaign e d m in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign e d m, or <code>null</code> if a matching s p mail campaign e d m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM fetchByCampaignId_Last(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaign e d ms before and after the current s p mail campaign e d m in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignEDMId the primary key of the current s p mail campaign e d m
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign e d m
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a s p mail campaign e d m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM[] findByCampaignId_PrevAndNext(
		long spMailCampaignEDMId, long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignEDMException;

	/**
	* Removes all the s p mail campaign e d ms where spMailCampaignId = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignId(long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign e d ms where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @return the number of matching s p mail campaign e d ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignId(long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaign e d m where spMailCampaignId = &#63; and seqNo = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignEDMException} if it could not be found.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param seqNo the seq no
	* @return the matching s p mail campaign e d m
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a matching s p mail campaign e d m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM findByCampaignIdMailType(
		long spMailCampaignId, int seqNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignEDMException;

	/**
	* Returns the s p mail campaign e d m where spMailCampaignId = &#63; and seqNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param seqNo the seq no
	* @return the matching s p mail campaign e d m, or <code>null</code> if a matching s p mail campaign e d m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM fetchByCampaignIdMailType(
		long spMailCampaignId, int seqNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaign e d m where spMailCampaignId = &#63; and seqNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param seqNo the seq no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail campaign e d m, or <code>null</code> if a matching s p mail campaign e d m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM fetchByCampaignIdMailType(
		long spMailCampaignId, int seqNo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p mail campaign e d m where spMailCampaignId = &#63; and seqNo = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param seqNo the seq no
	* @return the s p mail campaign e d m that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM removeByCampaignIdMailType(
		long spMailCampaignId, int seqNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignEDMException;

	/**
	* Returns the number of s p mail campaign e d ms where spMailCampaignId = &#63; and seqNo = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param seqNo the seq no
	* @return the number of matching s p mail campaign e d ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdMailType(long spMailCampaignId, int seqNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p mail campaign e d m in the entity cache if it is enabled.
	*
	* @param spMailCampaignEDM the s p mail campaign e d m
	*/
	public void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailCampaignEDM spMailCampaignEDM);

	/**
	* Caches the s p mail campaign e d ms in the entity cache if it is enabled.
	*
	* @param spMailCampaignEDMs the s p mail campaign e d ms
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignEDM> spMailCampaignEDMs);

	/**
	* Creates a new s p mail campaign e d m with the primary key. Does not add the s p mail campaign e d m to the database.
	*
	* @param spMailCampaignEDMId the primary key for the new s p mail campaign e d m
	* @return the new s p mail campaign e d m
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM create(
		long spMailCampaignEDMId);

	/**
	* Removes the s p mail campaign e d m with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignEDMId the primary key of the s p mail campaign e d m
	* @return the s p mail campaign e d m that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a s p mail campaign e d m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM remove(
		long spMailCampaignEDMId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignEDMException;

	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailCampaignEDM spMailCampaignEDM)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaign e d m with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignEDMException} if it could not be found.
	*
	* @param spMailCampaignEDMId the primary key of the s p mail campaign e d m
	* @return the s p mail campaign e d m
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a s p mail campaign e d m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM findByPrimaryKey(
		long spMailCampaignEDMId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignEDMException;

	/**
	* Returns the s p mail campaign e d m with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailCampaignEDMId the primary key of the s p mail campaign e d m
	* @return the s p mail campaign e d m, or <code>null</code> if a s p mail campaign e d m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignEDM fetchByPrimaryKey(
		long spMailCampaignEDMId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign e d ms.
	*
	* @return the s p mail campaign e d ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignEDM> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail campaign e d ms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignEDMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail campaign e d ms
	* @param end the upper bound of the range of s p mail campaign e d ms (not inclusive)
	* @return the range of s p mail campaign e d ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignEDM> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail campaign e d ms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignEDMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail campaign e d ms
	* @param end the upper bound of the range of s p mail campaign e d ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p mail campaign e d ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignEDM> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p mail campaign e d ms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign e d ms.
	*
	* @return the number of s p mail campaign e d ms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}