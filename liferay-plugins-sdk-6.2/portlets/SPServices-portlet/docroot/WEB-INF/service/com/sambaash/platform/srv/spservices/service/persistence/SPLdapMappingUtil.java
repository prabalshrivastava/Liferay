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

package com.sambaash.platform.srv.spservices.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spservices.model.SPLdapMapping;

import java.util.List;

/**
 * The persistence utility for the s p ldap mapping service. This utility wraps {@link SPLdapMappingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPLdapMappingPersistence
 * @see SPLdapMappingPersistenceImpl
 * @generated
 */
public class SPLdapMappingUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SPLdapMapping spLdapMapping) {
		getPersistence().clearCache(spLdapMapping);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SPLdapMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPLdapMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPLdapMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPLdapMapping update(SPLdapMapping spLdapMapping)
		throws SystemException {
		return getPersistence().update(spLdapMapping);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPLdapMapping update(SPLdapMapping spLdapMapping,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spLdapMapping, serviceContext);
	}

	/**
	* Returns the s p ldap mapping where ldapCountry = &#63; and ldapDepartment = &#63; and ldapCompany = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException} if it could not be found.
	*
	* @param ldapCountry the ldap country
	* @param ldapDepartment the ldap department
	* @param ldapCompany the ldap company
	* @return the matching s p ldap mapping
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException if a matching s p ldap mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapMapping findByCountryDepartmentAndLegalEntity(
		java.lang.String ldapCountry, java.lang.String ldapDepartment,
		java.lang.String ldapCompany)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException {
		return getPersistence()
				   .findByCountryDepartmentAndLegalEntity(ldapCountry,
			ldapDepartment, ldapCompany);
	}

	/**
	* Returns the s p ldap mapping where ldapCountry = &#63; and ldapDepartment = &#63; and ldapCompany = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ldapCountry the ldap country
	* @param ldapDepartment the ldap department
	* @param ldapCompany the ldap company
	* @return the matching s p ldap mapping, or <code>null</code> if a matching s p ldap mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapMapping fetchByCountryDepartmentAndLegalEntity(
		java.lang.String ldapCountry, java.lang.String ldapDepartment,
		java.lang.String ldapCompany)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryDepartmentAndLegalEntity(ldapCountry,
			ldapDepartment, ldapCompany);
	}

	/**
	* Returns the s p ldap mapping where ldapCountry = &#63; and ldapDepartment = &#63; and ldapCompany = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ldapCountry the ldap country
	* @param ldapDepartment the ldap department
	* @param ldapCompany the ldap company
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p ldap mapping, or <code>null</code> if a matching s p ldap mapping could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapMapping fetchByCountryDepartmentAndLegalEntity(
		java.lang.String ldapCountry, java.lang.String ldapDepartment,
		java.lang.String ldapCompany, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCountryDepartmentAndLegalEntity(ldapCountry,
			ldapDepartment, ldapCompany, retrieveFromCache);
	}

	/**
	* Removes the s p ldap mapping where ldapCountry = &#63; and ldapDepartment = &#63; and ldapCompany = &#63; from the database.
	*
	* @param ldapCountry the ldap country
	* @param ldapDepartment the ldap department
	* @param ldapCompany the ldap company
	* @return the s p ldap mapping that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapMapping removeByCountryDepartmentAndLegalEntity(
		java.lang.String ldapCountry, java.lang.String ldapDepartment,
		java.lang.String ldapCompany)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException {
		return getPersistence()
				   .removeByCountryDepartmentAndLegalEntity(ldapCountry,
			ldapDepartment, ldapCompany);
	}

	/**
	* Returns the number of s p ldap mappings where ldapCountry = &#63; and ldapDepartment = &#63; and ldapCompany = &#63;.
	*
	* @param ldapCountry the ldap country
	* @param ldapDepartment the ldap department
	* @param ldapCompany the ldap company
	* @return the number of matching s p ldap mappings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCountryDepartmentAndLegalEntity(
		java.lang.String ldapCountry, java.lang.String ldapDepartment,
		java.lang.String ldapCompany)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCountryDepartmentAndLegalEntity(ldapCountry,
			ldapDepartment, ldapCompany);
	}

	/**
	* Caches the s p ldap mapping in the entity cache if it is enabled.
	*
	* @param spLdapMapping the s p ldap mapping
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.SPLdapMapping spLdapMapping) {
		getPersistence().cacheResult(spLdapMapping);
	}

	/**
	* Caches the s p ldap mappings in the entity cache if it is enabled.
	*
	* @param spLdapMappings the s p ldap mappings
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapMapping> spLdapMappings) {
		getPersistence().cacheResult(spLdapMappings);
	}

	/**
	* Creates a new s p ldap mapping with the primary key. Does not add the s p ldap mapping to the database.
	*
	* @param spLdapMappingId the primary key for the new s p ldap mapping
	* @return the new s p ldap mapping
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapMapping create(
		long spLdapMappingId) {
		return getPersistence().create(spLdapMappingId);
	}

	/**
	* Removes the s p ldap mapping with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spLdapMappingId the primary key of the s p ldap mapping
	* @return the s p ldap mapping that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException if a s p ldap mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapMapping remove(
		long spLdapMappingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException {
		return getPersistence().remove(spLdapMappingId);
	}

	public static com.sambaash.platform.srv.spservices.model.SPLdapMapping updateImpl(
		com.sambaash.platform.srv.spservices.model.SPLdapMapping spLdapMapping)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spLdapMapping);
	}

	/**
	* Returns the s p ldap mapping with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException} if it could not be found.
	*
	* @param spLdapMappingId the primary key of the s p ldap mapping
	* @return the s p ldap mapping
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException if a s p ldap mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapMapping findByPrimaryKey(
		long spLdapMappingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPLdapMappingException {
		return getPersistence().findByPrimaryKey(spLdapMappingId);
	}

	/**
	* Returns the s p ldap mapping with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spLdapMappingId the primary key of the s p ldap mapping
	* @return the s p ldap mapping, or <code>null</code> if a s p ldap mapping with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPLdapMapping fetchByPrimaryKey(
		long spLdapMappingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spLdapMappingId);
	}

	/**
	* Returns all the s p ldap mappings.
	*
	* @return the s p ldap mappings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapMapping> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p ldap mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p ldap mappings
	* @param end the upper bound of the range of s p ldap mappings (not inclusive)
	* @return the range of s p ldap mappings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapMapping> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p ldap mappings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p ldap mappings
	* @param end the upper bound of the range of s p ldap mappings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p ldap mappings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPLdapMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p ldap mappings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p ldap mappings.
	*
	* @return the number of s p ldap mappings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPLdapMappingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPLdapMappingPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					SPLdapMappingPersistence.class.getName());

			ReferenceRegistry.registerReference(SPLdapMappingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPLdapMappingPersistence persistence) {
	}

	private static SPLdapMappingPersistence _persistence;
}