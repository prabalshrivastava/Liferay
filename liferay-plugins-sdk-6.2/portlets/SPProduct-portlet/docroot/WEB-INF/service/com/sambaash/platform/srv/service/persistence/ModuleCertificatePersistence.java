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

package com.sambaash.platform.srv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.model.ModuleCertificate;

/**
 * The persistence interface for the module certificate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModuleCertificatePersistenceImpl
 * @see ModuleCertificateUtil
 * @generated
 */
public interface ModuleCertificatePersistence extends BasePersistence<ModuleCertificate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ModuleCertificateUtil} to access the module certificate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the module certificates where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching module certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the module certificates where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of module certificates
	* @param end the upper bound of the range of module certificates (not inclusive)
	* @return the range of matching module certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the module certificates where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of module certificates
	* @param end the upper bound of the range of module certificates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first module certificate in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module certificate
	* @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a matching module certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCertificateException;

	/**
	* Returns the first module certificate in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module certificate, or <code>null</code> if a matching module certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last module certificate in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module certificate
	* @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a matching module certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCertificateException;

	/**
	* Returns the last module certificate in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module certificate, or <code>null</code> if a matching module certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the module certificates before and after the current module certificate in the ordered set where groupId = &#63;.
	*
	* @param spModuleCertificateId the primary key of the current module certificate
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module certificate
	* @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a module certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate[] findByGroupId_PrevAndNext(
		long spModuleCertificateId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCertificateException;

	/**
	* Removes all the module certificates where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of module certificates where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching module certificates
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the module certificates where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @return the matching module certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> findByModuleIdAndGroupId(
		long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the module certificates where spModuleId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param start the lower bound of the range of module certificates
	* @param end the upper bound of the range of module certificates (not inclusive)
	* @return the range of matching module certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> findByModuleIdAndGroupId(
		long spModuleId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the module certificates where spModuleId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param start the lower bound of the range of module certificates
	* @param end the upper bound of the range of module certificates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> findByModuleIdAndGroupId(
		long spModuleId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first module certificate in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module certificate
	* @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a matching module certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate findByModuleIdAndGroupId_First(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCertificateException;

	/**
	* Returns the first module certificate in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module certificate, or <code>null</code> if a matching module certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate fetchByModuleIdAndGroupId_First(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last module certificate in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module certificate
	* @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a matching module certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate findByModuleIdAndGroupId_Last(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCertificateException;

	/**
	* Returns the last module certificate in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module certificate, or <code>null</code> if a matching module certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate fetchByModuleIdAndGroupId_Last(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the module certificates before and after the current module certificate in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleCertificateId the primary key of the current module certificate
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module certificate
	* @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a module certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate[] findByModuleIdAndGroupId_PrevAndNext(
		long spModuleCertificateId, long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCertificateException;

	/**
	* Removes all the module certificates where spModuleId = &#63; and groupId = &#63; from the database.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByModuleIdAndGroupId(long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of module certificates where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @return the number of matching module certificates
	* @throws SystemException if a system exception occurred
	*/
	public int countByModuleIdAndGroupId(long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the module certificates where spCertificatetId = &#63; and groupId = &#63;.
	*
	* @param spCertificatetId the sp certificatet ID
	* @param groupId the group ID
	* @return the matching module certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> findByCertificateIdAndGroupId(
		long spCertificatetId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the module certificates where spCertificatetId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCertificatetId the sp certificatet ID
	* @param groupId the group ID
	* @param start the lower bound of the range of module certificates
	* @param end the upper bound of the range of module certificates (not inclusive)
	* @return the range of matching module certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> findByCertificateIdAndGroupId(
		long spCertificatetId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the module certificates where spCertificatetId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCertificatetId the sp certificatet ID
	* @param groupId the group ID
	* @param start the lower bound of the range of module certificates
	* @param end the upper bound of the range of module certificates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching module certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> findByCertificateIdAndGroupId(
		long spCertificatetId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first module certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	*
	* @param spCertificatetId the sp certificatet ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module certificate
	* @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a matching module certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate findByCertificateIdAndGroupId_First(
		long spCertificatetId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCertificateException;

	/**
	* Returns the first module certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	*
	* @param spCertificatetId the sp certificatet ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching module certificate, or <code>null</code> if a matching module certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate fetchByCertificateIdAndGroupId_First(
		long spCertificatetId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last module certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	*
	* @param spCertificatetId the sp certificatet ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module certificate
	* @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a matching module certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate findByCertificateIdAndGroupId_Last(
		long spCertificatetId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCertificateException;

	/**
	* Returns the last module certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	*
	* @param spCertificatetId the sp certificatet ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching module certificate, or <code>null</code> if a matching module certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate fetchByCertificateIdAndGroupId_Last(
		long spCertificatetId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the module certificates before and after the current module certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	*
	* @param spModuleCertificateId the primary key of the current module certificate
	* @param spCertificatetId the sp certificatet ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next module certificate
	* @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a module certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate[] findByCertificateIdAndGroupId_PrevAndNext(
		long spModuleCertificateId, long spCertificatetId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCertificateException;

	/**
	* Removes all the module certificates where spCertificatetId = &#63; and groupId = &#63; from the database.
	*
	* @param spCertificatetId the sp certificatet ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCertificateIdAndGroupId(long spCertificatetId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of module certificates where spCertificatetId = &#63; and groupId = &#63;.
	*
	* @param spCertificatetId the sp certificatet ID
	* @param groupId the group ID
	* @return the number of matching module certificates
	* @throws SystemException if a system exception occurred
	*/
	public int countByCertificateIdAndGroupId(long spCertificatetId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the module certificate in the entity cache if it is enabled.
	*
	* @param moduleCertificate the module certificate
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.ModuleCertificate moduleCertificate);

	/**
	* Caches the module certificates in the entity cache if it is enabled.
	*
	* @param moduleCertificates the module certificates
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> moduleCertificates);

	/**
	* Creates a new module certificate with the primary key. Does not add the module certificate to the database.
	*
	* @param spModuleCertificateId the primary key for the new module certificate
	* @return the new module certificate
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate create(
		long spModuleCertificateId);

	/**
	* Removes the module certificate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spModuleCertificateId the primary key of the module certificate
	* @return the module certificate that was removed
	* @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a module certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate remove(
		long spModuleCertificateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCertificateException;

	public com.sambaash.platform.srv.model.ModuleCertificate updateImpl(
		com.sambaash.platform.srv.model.ModuleCertificate moduleCertificate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the module certificate with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchModuleCertificateException} if it could not be found.
	*
	* @param spModuleCertificateId the primary key of the module certificate
	* @return the module certificate
	* @throws com.sambaash.platform.srv.NoSuchModuleCertificateException if a module certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate findByPrimaryKey(
		long spModuleCertificateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchModuleCertificateException;

	/**
	* Returns the module certificate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spModuleCertificateId the primary key of the module certificate
	* @return the module certificate, or <code>null</code> if a module certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.ModuleCertificate fetchByPrimaryKey(
		long spModuleCertificateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the module certificates.
	*
	* @return the module certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the module certificates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of module certificates
	* @param end the upper bound of the range of module certificates (not inclusive)
	* @return the range of module certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the module certificates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of module certificates
	* @param end the upper bound of the range of module certificates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of module certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.ModuleCertificate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the module certificates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of module certificates.
	*
	* @return the number of module certificates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}