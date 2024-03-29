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

import com.liferay.saml.model.SamlIdpSpSession;

/**
 * The persistence interface for the saml idp sp session service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mika Koivisto, W. Berks
 * @see SamlIdpSpSessionPersistenceImpl
 * @see SamlIdpSpSessionUtil
 * @generated
 */
public interface SamlIdpSpSessionPersistence extends BasePersistence<SamlIdpSpSession> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SamlIdpSpSessionUtil} to access the saml idp sp session persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the saml idp sp sessions where samlIdpSsoSessionId = &#63;.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @return the matching saml idp sp sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.saml.model.SamlIdpSpSession> findBySamlIdpSsoSessionId(
		long samlIdpSsoSessionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the saml idp sp sessions where samlIdpSsoSessionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlIdpSpSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @param start the lower bound of the range of saml idp sp sessions
	* @param end the upper bound of the range of saml idp sp sessions (not inclusive)
	* @return the range of matching saml idp sp sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.saml.model.SamlIdpSpSession> findBySamlIdpSsoSessionId(
		long samlIdpSsoSessionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the saml idp sp sessions where samlIdpSsoSessionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlIdpSpSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @param start the lower bound of the range of saml idp sp sessions
	* @param end the upper bound of the range of saml idp sp sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching saml idp sp sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.saml.model.SamlIdpSpSession> findBySamlIdpSsoSessionId(
		long samlIdpSsoSessionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first saml idp sp session in the ordered set where samlIdpSsoSessionId = &#63;.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching saml idp sp session
	* @throws com.liferay.saml.NoSuchIdpSpSessionException if a matching saml idp sp session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlIdpSpSession findBySamlIdpSsoSessionId_First(
		long samlIdpSsoSessionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.saml.NoSuchIdpSpSessionException;

	/**
	* Returns the first saml idp sp session in the ordered set where samlIdpSsoSessionId = &#63;.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching saml idp sp session, or <code>null</code> if a matching saml idp sp session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlIdpSpSession fetchBySamlIdpSsoSessionId_First(
		long samlIdpSsoSessionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last saml idp sp session in the ordered set where samlIdpSsoSessionId = &#63;.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching saml idp sp session
	* @throws com.liferay.saml.NoSuchIdpSpSessionException if a matching saml idp sp session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlIdpSpSession findBySamlIdpSsoSessionId_Last(
		long samlIdpSsoSessionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.saml.NoSuchIdpSpSessionException;

	/**
	* Returns the last saml idp sp session in the ordered set where samlIdpSsoSessionId = &#63;.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching saml idp sp session, or <code>null</code> if a matching saml idp sp session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlIdpSpSession fetchBySamlIdpSsoSessionId_Last(
		long samlIdpSsoSessionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the saml idp sp sessions before and after the current saml idp sp session in the ordered set where samlIdpSsoSessionId = &#63;.
	*
	* @param samlIdpSpSessionId the primary key of the current saml idp sp session
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next saml idp sp session
	* @throws com.liferay.saml.NoSuchIdpSpSessionException if a saml idp sp session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlIdpSpSession[] findBySamlIdpSsoSessionId_PrevAndNext(
		long samlIdpSpSessionId, long samlIdpSsoSessionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.saml.NoSuchIdpSpSessionException;

	/**
	* Removes all the saml idp sp sessions where samlIdpSsoSessionId = &#63; from the database.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySamlIdpSsoSessionId(long samlIdpSsoSessionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of saml idp sp sessions where samlIdpSsoSessionId = &#63;.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @return the number of matching saml idp sp sessions
	* @throws SystemException if a system exception occurred
	*/
	public int countBySamlIdpSsoSessionId(long samlIdpSsoSessionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the saml idp sp session where samlIdpSsoSessionId = &#63; and samlSpEntityId = &#63; or throws a {@link com.liferay.saml.NoSuchIdpSpSessionException} if it could not be found.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @param samlSpEntityId the saml sp entity ID
	* @return the matching saml idp sp session
	* @throws com.liferay.saml.NoSuchIdpSpSessionException if a matching saml idp sp session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlIdpSpSession findBySISSI_SSEI(
		long samlIdpSsoSessionId, java.lang.String samlSpEntityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.saml.NoSuchIdpSpSessionException;

	/**
	* Returns the saml idp sp session where samlIdpSsoSessionId = &#63; and samlSpEntityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @param samlSpEntityId the saml sp entity ID
	* @return the matching saml idp sp session, or <code>null</code> if a matching saml idp sp session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlIdpSpSession fetchBySISSI_SSEI(
		long samlIdpSsoSessionId, java.lang.String samlSpEntityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the saml idp sp session where samlIdpSsoSessionId = &#63; and samlSpEntityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @param samlSpEntityId the saml sp entity ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching saml idp sp session, or <code>null</code> if a matching saml idp sp session could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlIdpSpSession fetchBySISSI_SSEI(
		long samlIdpSsoSessionId, java.lang.String samlSpEntityId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the saml idp sp session where samlIdpSsoSessionId = &#63; and samlSpEntityId = &#63; from the database.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @param samlSpEntityId the saml sp entity ID
	* @return the saml idp sp session that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlIdpSpSession removeBySISSI_SSEI(
		long samlIdpSsoSessionId, java.lang.String samlSpEntityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.saml.NoSuchIdpSpSessionException;

	/**
	* Returns the number of saml idp sp sessions where samlIdpSsoSessionId = &#63; and samlSpEntityId = &#63;.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID
	* @param samlSpEntityId the saml sp entity ID
	* @return the number of matching saml idp sp sessions
	* @throws SystemException if a system exception occurred
	*/
	public int countBySISSI_SSEI(long samlIdpSsoSessionId,
		java.lang.String samlSpEntityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the saml idp sp session in the entity cache if it is enabled.
	*
	* @param samlIdpSpSession the saml idp sp session
	*/
	public void cacheResult(
		com.liferay.saml.model.SamlIdpSpSession samlIdpSpSession);

	/**
	* Caches the saml idp sp sessions in the entity cache if it is enabled.
	*
	* @param samlIdpSpSessions the saml idp sp sessions
	*/
	public void cacheResult(
		java.util.List<com.liferay.saml.model.SamlIdpSpSession> samlIdpSpSessions);

	/**
	* Creates a new saml idp sp session with the primary key. Does not add the saml idp sp session to the database.
	*
	* @param samlIdpSpSessionId the primary key for the new saml idp sp session
	* @return the new saml idp sp session
	*/
	public com.liferay.saml.model.SamlIdpSpSession create(
		long samlIdpSpSessionId);

	/**
	* Removes the saml idp sp session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param samlIdpSpSessionId the primary key of the saml idp sp session
	* @return the saml idp sp session that was removed
	* @throws com.liferay.saml.NoSuchIdpSpSessionException if a saml idp sp session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlIdpSpSession remove(
		long samlIdpSpSessionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.saml.NoSuchIdpSpSessionException;

	public com.liferay.saml.model.SamlIdpSpSession updateImpl(
		com.liferay.saml.model.SamlIdpSpSession samlIdpSpSession)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the saml idp sp session with the primary key or throws a {@link com.liferay.saml.NoSuchIdpSpSessionException} if it could not be found.
	*
	* @param samlIdpSpSessionId the primary key of the saml idp sp session
	* @return the saml idp sp session
	* @throws com.liferay.saml.NoSuchIdpSpSessionException if a saml idp sp session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlIdpSpSession findByPrimaryKey(
		long samlIdpSpSessionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.saml.NoSuchIdpSpSessionException;

	/**
	* Returns the saml idp sp session with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param samlIdpSpSessionId the primary key of the saml idp sp session
	* @return the saml idp sp session, or <code>null</code> if a saml idp sp session with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.saml.model.SamlIdpSpSession fetchByPrimaryKey(
		long samlIdpSpSessionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the saml idp sp sessions.
	*
	* @return the saml idp sp sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.saml.model.SamlIdpSpSession> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the saml idp sp sessions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlIdpSpSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of saml idp sp sessions
	* @param end the upper bound of the range of saml idp sp sessions (not inclusive)
	* @return the range of saml idp sp sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.saml.model.SamlIdpSpSession> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the saml idp sp sessions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.saml.model.impl.SamlIdpSpSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of saml idp sp sessions
	* @param end the upper bound of the range of saml idp sp sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of saml idp sp sessions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.saml.model.SamlIdpSpSession> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the saml idp sp sessions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of saml idp sp sessions.
	*
	* @return the number of saml idp sp sessions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}