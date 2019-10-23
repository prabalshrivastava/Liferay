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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.processbuilder.model.PERule;

/**
 * The persistence interface for the p e rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PERulePersistenceImpl
 * @see PERuleUtil
 * @generated
 */
public interface PERulePersistence extends BasePersistence<PERule> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PERuleUtil} to access the p e rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the p e rules where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e rules where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e rules
	* @param end the upper bound of the range of p e rules (not inclusive)
	* @return the range of matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e rules where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e rules
	* @param end the upper bound of the range of p e rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e rule in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e rule
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	/**
	* Returns the first p e rule in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e rule, or <code>null</code> if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e rule in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e rule
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	/**
	* Returns the last p e rule in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e rule, or <code>null</code> if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e rules before and after the current p e rule in the ordered set where uuid = &#63;.
	*
	* @param spPERuleId the primary key of the current p e rule
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e rule
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a p e rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule[] findByUuid_PrevAndNext(
		long spPERuleId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	/**
	* Removes all the p e rules where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e rules where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e rule where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPERuleException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e rule
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	/**
	* Returns the p e rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e rule, or <code>null</code> if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e rule, or <code>null</code> if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the p e rule where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the p e rule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	/**
	* Returns the number of p e rules where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e rules where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e rules where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e rules
	* @param end the upper bound of the range of p e rules (not inclusive)
	* @return the range of matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e rules where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e rules
	* @param end the upper bound of the range of p e rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e rule in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e rule
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	/**
	* Returns the first p e rule in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e rule, or <code>null</code> if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e rule in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e rule
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	/**
	* Returns the last p e rule in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e rule, or <code>null</code> if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e rules before and after the current p e rule in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spPERuleId the primary key of the current p e rule
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e rule
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a p e rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule[] findByUuid_C_PrevAndNext(
		long spPERuleId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	/**
	* Removes all the p e rules where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e rules where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e rules where spPERuleSetId = &#63;.
	*
	* @param spPERuleSetId the sp p e rule set ID
	* @return the matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> findByRuleSetId(
		long spPERuleSetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e rules where spPERuleSetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPERuleSetId the sp p e rule set ID
	* @param start the lower bound of the range of p e rules
	* @param end the upper bound of the range of p e rules (not inclusive)
	* @return the range of matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> findByRuleSetId(
		long spPERuleSetId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e rules where spPERuleSetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spPERuleSetId the sp p e rule set ID
	* @param start the lower bound of the range of p e rules
	* @param end the upper bound of the range of p e rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> findByRuleSetId(
		long spPERuleSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e rule in the ordered set where spPERuleSetId = &#63;.
	*
	* @param spPERuleSetId the sp p e rule set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e rule
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule findByRuleSetId_First(
		long spPERuleSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	/**
	* Returns the first p e rule in the ordered set where spPERuleSetId = &#63;.
	*
	* @param spPERuleSetId the sp p e rule set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e rule, or <code>null</code> if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule fetchByRuleSetId_First(
		long spPERuleSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e rule in the ordered set where spPERuleSetId = &#63;.
	*
	* @param spPERuleSetId the sp p e rule set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e rule
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule findByRuleSetId_Last(
		long spPERuleSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	/**
	* Returns the last p e rule in the ordered set where spPERuleSetId = &#63;.
	*
	* @param spPERuleSetId the sp p e rule set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e rule, or <code>null</code> if a matching p e rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule fetchByRuleSetId_Last(
		long spPERuleSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e rules before and after the current p e rule in the ordered set where spPERuleSetId = &#63;.
	*
	* @param spPERuleId the primary key of the current p e rule
	* @param spPERuleSetId the sp p e rule set ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e rule
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a p e rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule[] findByRuleSetId_PrevAndNext(
		long spPERuleId, long spPERuleSetId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	/**
	* Removes all the p e rules where spPERuleSetId = &#63; from the database.
	*
	* @param spPERuleSetId the sp p e rule set ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRuleSetId(long spPERuleSetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e rules where spPERuleSetId = &#63;.
	*
	* @param spPERuleSetId the sp p e rule set ID
	* @return the number of matching p e rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByRuleSetId(long spPERuleSetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the p e rule in the entity cache if it is enabled.
	*
	* @param peRule the p e rule
	*/
	public void cacheResult(
		com.sambaash.platform.srv.processbuilder.model.PERule peRule);

	/**
	* Caches the p e rules in the entity cache if it is enabled.
	*
	* @param peRules the p e rules
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> peRules);

	/**
	* Creates a new p e rule with the primary key. Does not add the p e rule to the database.
	*
	* @param spPERuleId the primary key for the new p e rule
	* @return the new p e rule
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule create(
		long spPERuleId);

	/**
	* Removes the p e rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPERuleId the primary key of the p e rule
	* @return the p e rule that was removed
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a p e rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule remove(
		long spPERuleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	public com.sambaash.platform.srv.processbuilder.model.PERule updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PERule peRule)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e rule with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPERuleException} if it could not be found.
	*
	* @param spPERuleId the primary key of the p e rule
	* @return the p e rule
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a p e rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule findByPrimaryKey(
		long spPERuleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;

	/**
	* Returns the p e rule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPERuleId the primary key of the p e rule
	* @return the p e rule, or <code>null</code> if a p e rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERule fetchByPrimaryKey(
		long spPERuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e rules.
	*
	* @return the p e rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e rules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e rules
	* @param end the upper bound of the range of p e rules (not inclusive)
	* @return the range of p e rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e rules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e rules
	* @param end the upper bound of the range of p e rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p e rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p e rules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e rules.
	*
	* @return the number of p e rules
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}