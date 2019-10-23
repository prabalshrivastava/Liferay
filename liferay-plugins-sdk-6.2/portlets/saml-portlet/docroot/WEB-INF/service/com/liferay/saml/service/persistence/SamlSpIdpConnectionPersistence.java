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

package com.liferay.saml.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.saml.model.SamlSpIdpConnection;

/**
 * The persistence interface for the saml sp idp connection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mika Koivisto, W. Berks
 * @see SamlSpIdpConnectionPersistenceImpl
 * @see SamlSpIdpConnectionUtil
 * @generated
 */
public interface SamlSpIdpConnectionPersistence extends BasePersistence<SamlSpIdpConnection> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SamlSpIdpConnectionUtil} to access the saml sp idp connection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the saml sp idp connection where companyId = &#63; and groupId = &#63; or throws a {@link com.liferay.saml.NoSuchSpIdpConnectionException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching saml sp idp connection
	* @throws com.liferay.saml.NoSuchSpIdpConnectionException if a matching saml sp idp connection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlSpIdpConnection findByCompanyIdGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.saml.NoSuchSpIdpConnectionException;

	/**
	* Returns the saml sp idp connection where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the matching saml sp idp connection, or <code>null</code> if a matching saml sp idp connection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlSpIdpConnection fetchByCompanyIdGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the saml sp idp connection where companyId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching saml sp idp connection, or <code>null</code> if a matching saml sp idp connection could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlSpIdpConnection fetchByCompanyIdGroupId(
		long companyId, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the saml sp idp connection where companyId = &#63; and groupId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the saml sp idp connection that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlSpIdpConnection removeByCompanyIdGroupId(
		long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.saml.NoSuchSpIdpConnectionException;

	/**
	* Returns the number of saml sp idp connections where companyId = &#63; and groupId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @return the number of matching saml sp idp connections
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyIdGroupId(long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the saml sp idp connection in the entity cache if it is enabled.
	*
	* @param samlSpIdpConnection the saml sp idp connection
	*/
	public void cacheResult(
		com.liferay.saml.model.SamlSpIdpConnection samlSpIdpConnection);

	/**
	* Caches the saml sp idp connections in the entity cache if it is enabled.
	*
	* @param samlSpIdpConnections the saml sp idp connections
	*/
	public void cacheResult(
		java.util.List<com.liferay.saml.model.SamlSpIdpConnection> samlSpIdpConnections);

	/**
	* Creates a new saml sp idp connection with the primary key. Does not add the saml sp idp connection to the database.
	*
	* @param samlSpIdpConnectionId the primary key for the new saml sp idp connection
	* @return the new saml sp idp connection
	*/
	public com.liferay.saml.model.SamlSpIdpConnection create(
		long samlSpIdpConnectionId);

	/**
	* Removes the saml sp idp connection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param samlSpIdpConnectionId the primary key of the saml sp idp connection
	* @return the saml sp idp connection that was removed
	* @throws com.liferay.saml.NoSuchSpIdpConnectionException if a saml sp idp connection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlSpIdpConnection remove(
		long samlSpIdpConnectionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.saml.NoSuchSpIdpConnectionException;

	public com.liferay.saml.model.SamlSpIdpConnection updateImpl(
		com.liferay.saml.model.SamlSpIdpConnection samlSpIdpConnection)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the saml sp idp connection with the primary key or throws a {@link com.liferay.saml.NoSuchSpIdpConnectionException} if it could not be found.
	*
	* @param samlSpIdpConnectionId the primary key of the saml sp idp connection
	* @return the saml sp idp connection
	* @throws com.liferay.saml.NoSuchSpIdpConnectionException if a saml sp idp connection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlSpIdpConnection findByPrimaryKey(
		long samlSpIdpConnectionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.saml.NoSuchSpIdpConnectionException;

	/**
	* Returns the saml sp idp connection with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param samlSpIdpConnectionId the primary key of the saml sp idp connection
	* @return the saml sp idp connection, or <code>null</code> if a saml sp idp connection with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlSpIdpConnection fetchByPrimaryKey(
		long samlSpIdpConnectionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the saml sp idp connections.
	*
	* @return the saml sp idp connections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.saml.model.SamlSpIdpConnection> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the saml sp idp connections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlSpIdpConnectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of saml sp idp connections
	* @param end the upper bound of the range of saml sp idp connections (not inclusive)
	* @return the range of saml sp idp connections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.saml.model.SamlSpIdpConnection> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the saml sp idp connections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlSpIdpConnectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of saml sp idp connections
	* @param end the upper bound of the range of saml sp idp connections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of saml sp idp connections
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.saml.model.SamlSpIdpConnection> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the saml sp idp connections from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of saml sp idp connections.
	*
	* @return the number of saml sp idp connections
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}