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

package com.sambaash.platform.srv.rsvp.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RsvpDetailLocalService}.
 *
 * @author gauravvijayvergia
 * @see RsvpDetailLocalService
 * @generated
 */
public class RsvpDetailLocalServiceWrapper implements RsvpDetailLocalService,
	ServiceWrapper<RsvpDetailLocalService> {
	public RsvpDetailLocalServiceWrapper(
		RsvpDetailLocalService rsvpDetailLocalService) {
		_rsvpDetailLocalService = rsvpDetailLocalService;
	}

	/**
	* Adds the rsvp detail to the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpDetail the rsvp detail
	* @return the rsvp detail that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail addRsvpDetail(
		com.sambaash.platform.srv.rsvp.model.RsvpDetail rsvpDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.addRsvpDetail(rsvpDetail);
	}

	/**
	* Creates a new rsvp detail with the primary key. Does not add the rsvp detail to the database.
	*
	* @param rsvpDetailId the primary key for the new rsvp detail
	* @return the new rsvp detail
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail createRsvpDetail(
		long rsvpDetailId) {
		return _rsvpDetailLocalService.createRsvpDetail(rsvpDetailId);
	}

	/**
	* Deletes the rsvp detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpDetailId the primary key of the rsvp detail
	* @return the rsvp detail that was removed
	* @throws PortalException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail deleteRsvpDetail(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.deleteRsvpDetail(rsvpDetailId);
	}

	/**
	* Deletes the rsvp detail from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpDetail the rsvp detail
	* @return the rsvp detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail deleteRsvpDetail(
		com.sambaash.platform.srv.rsvp.model.RsvpDetail rsvpDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.deleteRsvpDetail(rsvpDetail);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rsvpDetailLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchRsvpDetail(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.fetchRsvpDetail(rsvpDetailId);
	}

	/**
	* Returns the rsvp detail with the matching UUID and company.
	*
	* @param uuid the rsvp detail's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchRsvpDetailByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.fetchRsvpDetailByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the rsvp detail matching the UUID and group.
	*
	* @param uuid the rsvp detail's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp detail, or <code>null</code> if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail fetchRsvpDetailByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.fetchRsvpDetailByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the rsvp detail with the primary key.
	*
	* @param rsvpDetailId the primary key of the rsvp detail
	* @return the rsvp detail
	* @throws PortalException if a rsvp detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail getRsvpDetail(
		long rsvpDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.getRsvpDetail(rsvpDetailId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rsvp detail with the matching UUID and company.
	*
	* @param uuid the rsvp detail's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp detail
	* @throws PortalException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail getRsvpDetailByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.getRsvpDetailByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the rsvp detail matching the UUID and group.
	*
	* @param uuid the rsvp detail's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp detail
	* @throws PortalException if a matching rsvp detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail getRsvpDetailByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.getRsvpDetailByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the rsvp details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp details
	* @param end the upper bound of the range of rsvp details (not inclusive)
	* @return the range of rsvp details
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> getRsvpDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.getRsvpDetails(start, end);
	}

	/**
	* Returns the number of rsvp details.
	*
	* @return the number of rsvp details
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRsvpDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.getRsvpDetailsCount();
	}

	/**
	* Updates the rsvp detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rsvpDetail the rsvp detail
	* @return the rsvp detail that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail updateRsvpDetail(
		com.sambaash.platform.srv.rsvp.model.RsvpDetail rsvpDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.updateRsvpDetail(rsvpDetail);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rsvpDetailLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rsvpDetailLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rsvpDetailLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* @param rsvpId
	* @param start
	* @param end
	* @return List<Object<[]Object>>
	BigInteger rsvpPaymentId = (BigInteger) objectArray[0];
	String firstName = (String) objectArray[1];
	String lastName = (String) objectArray[2];
	String emailAddress = (String) objectArray[3];
	int attendance = (Integer) objectArray[4];
	int numberOfPeople = (Integer) objectArray[5];
	String transactionId = (String) objectArray[6];
	double amount = (Double) objectArray[7];
	Date transactionDate = (Date) objectArray[8];
	String userInfo = (String) objectArray[9];
	BigInteger rsvpDetailId = (BigInteger) objectArray[10];
	* @throws SystemException
	*/
	@Override
	public java.util.List<java.lang.Object> findByCustomSqlAndRsvpId(
		long rsvpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.findByCustomSqlAndRsvpId(rsvpId, start,
			end);
	}

	/**
	* @param rsvpId
	* @param emailAddress
	* @param start
	* @param end
	* @return List<Object<[]Object>>
	BigInteger rsvpPaymentId = (BigInteger) objectArray[0];
	String firstName = (String) objectArray[1];
	String lastName = (String) objectArray[2];
	String emailAddress = (String) objectArray[3];
	int attendance = (Integer) objectArray[4];
	int numberOfPeople = (Integer) objectArray[5];
	String transactionId = (String) objectArray[6];
	double amount = (Double) objectArray[7];
	Date transactionDate = (Date) objectArray[8];
	String userInfo = (String) objectArray[9];
	BigInteger rsvpDetailId = (BigInteger) objectArray[10];
	* @throws SystemException
	*/
	@Override
	public java.util.List<java.lang.Object> findByCustomSqlRsvpIdAndEMailAddress(
		long rsvpId, java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.findByCustomSqlRsvpIdAndEMailAddress(rsvpId,
			emailAddress, start, end);
	}

	/**
	* @param rsvpId
	* @param firstName
	* @param lastName
	* @param start
	* @param end
	* @return List<Object<[]Object>>
	BigInteger rsvpPaymentId = (BigInteger) objectArray[0];
	String firstName = (String) objectArray[1];
	String lastName = (String) objectArray[2];
	String emailAddress = (String) objectArray[3];
	int attendance = (Integer) objectArray[4];
	int numberOfPeople = (Integer) objectArray[5];
	String transactionId = (String) objectArray[6];
	double amount = (Double) objectArray[7];
	Date transactionDate = (Date) objectArray[8];
	String userInfo = (String) objectArray[9];
	BigInteger rsvpDetailId = (BigInteger) objectArray[10];
	* @throws SystemException
	*/
	@Override
	public java.util.List<java.lang.Object> findByCustomSqlRsvpIdAndName(
		long rsvpId, java.lang.String firstName, java.lang.String lastName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.findByCustomSqlRsvpIdAndName(rsvpId,
			firstName, lastName, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.findByemailAddress(emailAddress);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByemailAddressAndRsvpId(
		long rsvpId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return _rsvpDetailLocalService.findByemailAddressAndRsvpId(rsvpId,
			emailAddress);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findBynameAndRsvpId(
		java.lang.String firstName, long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return _rsvpDetailLocalService.findBynameAndRsvpId(firstName, rsvpId);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.sambaash.platform.srv.rsvp.service.RsvpDetailLocalServiceUtil} to access the rsvp detail local service.
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByRsvpId(
		long rsvpId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return _rsvpDetailLocalService.findByRsvpId(rsvpId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByRsvpId(
		long rsvpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException {
		return _rsvpDetailLocalService.findByRsvpId(rsvpId, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndAttendance(
		long rsvpId, int attendance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.findByrsvpIdAndAttendance(rsvpId,
			attendance);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndAttendance(
		long rsvpId, int attendance, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.findByrsvpIdAndAttendance(rsvpId,
			attendance, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpIdAndSource(
		long rsvpId, int source)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.findByrsvpIdAndSource(rsvpId, source);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpStatusAndRsvpId(
		long rsvpId, int rsvpStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.findByrsvpStatusAndRsvpId(rsvpId,
			rsvpStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpDetail> findByrsvpStatusAndRsvpId(
		long rsvpId, int rsvpStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetailLocalService.findByrsvpStatusAndRsvpId(rsvpId,
			rsvpStatus, start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RsvpDetailLocalService getWrappedRsvpDetailLocalService() {
		return _rsvpDetailLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRsvpDetailLocalService(
		RsvpDetailLocalService rsvpDetailLocalService) {
		_rsvpDetailLocalService = rsvpDetailLocalService;
	}

	@Override
	public RsvpDetailLocalService getWrappedService() {
		return _rsvpDetailLocalService;
	}

	@Override
	public void setWrappedService(RsvpDetailLocalService rsvpDetailLocalService) {
		_rsvpDetailLocalService = rsvpDetailLocalService;
	}

	private RsvpDetailLocalService _rsvpDetailLocalService;
}