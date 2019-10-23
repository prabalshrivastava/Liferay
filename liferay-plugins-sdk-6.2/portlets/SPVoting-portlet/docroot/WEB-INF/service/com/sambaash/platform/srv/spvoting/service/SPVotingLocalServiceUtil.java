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

package com.sambaash.platform.srv.spvoting.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPVoting. This utility wraps
 * {@link com.sambaash.platform.srv.spvoting.service.impl.SPVotingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author harini
 * @see SPVotingLocalService
 * @see com.sambaash.platform.srv.spvoting.service.base.SPVotingLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spvoting.service.impl.SPVotingLocalServiceImpl
 * @generated
 */
public class SPVotingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spvoting.service.impl.SPVotingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the s p voting to the database. Also notifies the appropriate model listeners.
	*
	* @param spVoting the s p voting
	* @return the s p voting that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting addSPVoting(
		com.sambaash.platform.srv.spvoting.model.SPVoting spVoting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSPVoting(spVoting);
	}

	/**
	* Creates a new s p voting with the primary key. Does not add the s p voting to the database.
	*
	* @param spVotingId the primary key for the new s p voting
	* @return the new s p voting
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting createSPVoting(
		long spVotingId) {
		return getService().createSPVoting(spVotingId);
	}

	/**
	* Deletes the s p voting with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spVotingId the primary key of the s p voting
	* @return the s p voting that was removed
	* @throws PortalException if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting deleteSPVoting(
		long spVotingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPVoting(spVotingId);
	}

	/**
	* Deletes the s p voting from the database. Also notifies the appropriate model listeners.
	*
	* @param spVoting the s p voting
	* @return the s p voting that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting deleteSPVoting(
		com.sambaash.platform.srv.spvoting.model.SPVoting spVoting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSPVoting(spVoting);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchSPVoting(
		long spVotingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPVoting(spVotingId);
	}

	/**
	* Returns the s p voting with the matching UUID and company.
	*
	* @param uuid the s p voting's UUID
	* @param companyId the primary key of the company
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchSPVotingByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPVotingByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p voting matching the UUID and group.
	*
	* @param uuid the s p voting's UUID
	* @param groupId the primary key of the group
	* @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting fetchSPVotingByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSPVotingByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the s p voting with the primary key.
	*
	* @param spVotingId the primary key of the s p voting
	* @return the s p voting
	* @throws PortalException if a s p voting with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting getSPVoting(
		long spVotingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPVoting(spVotingId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the s p voting with the matching UUID and company.
	*
	* @param uuid the s p voting's UUID
	* @param companyId the primary key of the company
	* @return the matching s p voting
	* @throws PortalException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting getSPVotingByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPVotingByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the s p voting matching the UUID and group.
	*
	* @param uuid the s p voting's UUID
	* @param groupId the primary key of the group
	* @return the matching s p voting
	* @throws PortalException if a matching s p voting could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting getSPVotingByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPVotingByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the s p votings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p votings
	* @param end the upper bound of the range of s p votings (not inclusive)
	* @return the range of s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> getSPVotings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPVotings(start, end);
	}

	/**
	* Returns the number of s p votings.
	*
	* @return the number of s p votings
	* @throws SystemException if a system exception occurred
	*/
	public static int getSPVotingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSPVotingsCount();
	}

	/**
	* Updates the s p voting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spVoting the s p voting
	* @return the s p voting that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spvoting.model.SPVoting updateSPVoting(
		com.sambaash.platform.srv.spvoting.model.SPVoting spVoting)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSPVoting(spVoting);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use
	* {@link service.SPVotingLocalServiceUtil} to access the s p voting local
	* service.
	*/
	public static void testVoting(java.lang.String msg) {
		getService().testVoting(msg);
	}

	public static void voteUp(java.lang.String className, long classPK,
		long userId, java.lang.String ip, boolean isSignedIn)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().voteUp(className, classPK, userId, ip, isSignedIn);
	}

	public static java.util.List<com.sambaash.platform.srv.spvoting.model.SPVoting> findByEntry(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByEntry(className, classPK);
	}

	public static com.sambaash.platform.srv.spvoting.model.SPVoting findByEntryAndUserId(
		java.lang.String className, long classPK, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getService().findByEntryAndUserId(className, classPK, userId);
	}

	public static com.sambaash.platform.srv.spvoting.model.SPVoting findByEntryAndIp(
		java.lang.String className, long classPK, java.lang.String ip)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spvoting.NoSuchSPVotingException {
		return getService().findByEntryAndIp(className, classPK, ip);
	}

	public static int countByEntry(java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByEntry(className, classPK);
	}

	public static int countByEntryAndUserId(java.lang.String className,
		long classPK, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByEntryAndUserId(className, classPK, userId);
	}

	public static int countByEntryAndIp(java.lang.String className,
		long classPK, java.lang.String ip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByEntryAndIp(className, classPK, ip);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPVotingLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPVotingLocalService.class.getName());

			if (invokableLocalService instanceof SPVotingLocalService) {
				_service = (SPVotingLocalService)invokableLocalService;
			}
			else {
				_service = new SPVotingLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPVotingLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPVotingLocalService service) {
	}

	private static SPVotingLocalService _service;
}