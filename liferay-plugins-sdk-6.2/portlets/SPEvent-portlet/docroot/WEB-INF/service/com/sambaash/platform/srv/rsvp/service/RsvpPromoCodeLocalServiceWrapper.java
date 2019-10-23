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
 * Provides a wrapper for {@link RsvpPromoCodeLocalService}.
 *
 * @author gauravvijayvergia
 * @see RsvpPromoCodeLocalService
 * @generated
 */
public class RsvpPromoCodeLocalServiceWrapper
	implements RsvpPromoCodeLocalService,
		ServiceWrapper<RsvpPromoCodeLocalService> {
	public RsvpPromoCodeLocalServiceWrapper(
		RsvpPromoCodeLocalService rsvpPromoCodeLocalService) {
		_rsvpPromoCodeLocalService = rsvpPromoCodeLocalService;
	}

	/**
	* Adds the rsvp promo code to the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpPromoCode the rsvp promo code
	* @return the rsvp promo code that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode addRsvpPromoCode(
		com.sambaash.platform.srv.rsvp.model.RsvpPromoCode rsvpPromoCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.addRsvpPromoCode(rsvpPromoCode);
	}

	/**
	* Creates a new rsvp promo code with the primary key. Does not add the rsvp promo code to the database.
	*
	* @param rsvpPromoCodeId the primary key for the new rsvp promo code
	* @return the new rsvp promo code
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode createRsvpPromoCode(
		long rsvpPromoCodeId) {
		return _rsvpPromoCodeLocalService.createRsvpPromoCode(rsvpPromoCodeId);
	}

	/**
	* Deletes the rsvp promo code with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpPromoCodeId the primary key of the rsvp promo code
	* @return the rsvp promo code that was removed
	* @throws PortalException if a rsvp promo code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode deleteRsvpPromoCode(
		long rsvpPromoCodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.deleteRsvpPromoCode(rsvpPromoCodeId);
	}

	/**
	* Deletes the rsvp promo code from the database. Also notifies the appropriate model listeners.
	*
	* @param rsvpPromoCode the rsvp promo code
	* @return the rsvp promo code that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode deleteRsvpPromoCode(
		com.sambaash.platform.srv.rsvp.model.RsvpPromoCode rsvpPromoCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.deleteRsvpPromoCode(rsvpPromoCode);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rsvpPromoCodeLocalService.dynamicQuery();
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
		return _rsvpPromoCodeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rsvpPromoCodeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rsvpPromoCodeLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _rsvpPromoCodeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _rsvpPromoCodeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchRsvpPromoCode(
		long rsvpPromoCodeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.fetchRsvpPromoCode(rsvpPromoCodeId);
	}

	/**
	* Returns the rsvp promo code with the matching UUID and company.
	*
	* @param uuid the rsvp promo code's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchRsvpPromoCodeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.fetchRsvpPromoCodeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the rsvp promo code matching the UUID and group.
	*
	* @param uuid the rsvp promo code's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp promo code, or <code>null</code> if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode fetchRsvpPromoCodeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.fetchRsvpPromoCodeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the rsvp promo code with the primary key.
	*
	* @param rsvpPromoCodeId the primary key of the rsvp promo code
	* @return the rsvp promo code
	* @throws PortalException if a rsvp promo code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode getRsvpPromoCode(
		long rsvpPromoCodeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.getRsvpPromoCode(rsvpPromoCodeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the rsvp promo code with the matching UUID and company.
	*
	* @param uuid the rsvp promo code's UUID
	* @param companyId the primary key of the company
	* @return the matching rsvp promo code
	* @throws PortalException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode getRsvpPromoCodeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.getRsvpPromoCodeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the rsvp promo code matching the UUID and group.
	*
	* @param uuid the rsvp promo code's UUID
	* @param groupId the primary key of the group
	* @return the matching rsvp promo code
	* @throws PortalException if a matching rsvp promo code could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode getRsvpPromoCodeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.getRsvpPromoCodeByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the rsvp promo codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPromoCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rsvp promo codes
	* @param end the upper bound of the range of rsvp promo codes (not inclusive)
	* @return the range of rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> getRsvpPromoCodes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.getRsvpPromoCodes(start, end);
	}

	/**
	* Returns the number of rsvp promo codes.
	*
	* @return the number of rsvp promo codes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRsvpPromoCodesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.getRsvpPromoCodesCount();
	}

	/**
	* Updates the rsvp promo code in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rsvpPromoCode the rsvp promo code
	* @return the rsvp promo code that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPromoCode updateRsvpPromoCode(
		com.sambaash.platform.srv.rsvp.model.RsvpPromoCode rsvpPromoCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.updateRsvpPromoCode(rsvpPromoCode);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rsvpPromoCodeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rsvpPromoCodeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rsvpPromoCodeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.sambaash.platform.srv.rsvp.service.RsvpPromoCodeLocalServiceUtil} to access the rsvp promo code local service.
	*/
	@Override
	public void clearCache() {
		_rsvpPromoCodeLocalService.clearCache();
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByPromoCode(
		java.lang.String promoCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.findByPromoCode(promoCode);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByPromoCode(
		java.lang.String promoCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.findByPromoCode(promoCode, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByPromoCode(
		java.lang.String promoCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.findByPromoCode(promoCode, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByrsvpId(
		long rsvpId) throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.findByrsvpId(rsvpId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByrsvpId(
		long rsvpId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.findByrsvpId(rsvpId, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.rsvp.model.RsvpPromoCode> findByrsvpId(
		long rsvpId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPromoCodeLocalService.findByrsvpId(rsvpId, start, end,
			orderByComparator);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RsvpPromoCodeLocalService getWrappedRsvpPromoCodeLocalService() {
		return _rsvpPromoCodeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRsvpPromoCodeLocalService(
		RsvpPromoCodeLocalService rsvpPromoCodeLocalService) {
		_rsvpPromoCodeLocalService = rsvpPromoCodeLocalService;
	}

	@Override
	public RsvpPromoCodeLocalService getWrappedService() {
		return _rsvpPromoCodeLocalService;
	}

	@Override
	public void setWrappedService(
		RsvpPromoCodeLocalService rsvpPromoCodeLocalService) {
		_rsvpPromoCodeLocalService = rsvpPromoCodeLocalService;
	}

	private RsvpPromoCodeLocalService _rsvpPromoCodeLocalService;
}