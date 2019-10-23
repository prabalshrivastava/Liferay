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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.model.FeeDetails;

import java.util.List;

/**
 * The persistence utility for the fee details service. This utility wraps {@link FeeDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see FeeDetailsPersistence
 * @see FeeDetailsPersistenceImpl
 * @generated
 */
public class FeeDetailsUtil {
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
	public static void clearCache(FeeDetails feeDetails) {
		getPersistence().clearCache(feeDetails);
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
	public static List<FeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FeeDetails update(FeeDetails feeDetails)
		throws SystemException {
		return getPersistence().update(feeDetails);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FeeDetails update(FeeDetails feeDetails,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(feeDetails, serviceContext);
	}

	/**
	* Returns all the fee detailses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the fee detailses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @return the range of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the fee detailses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first fee details in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first fee details in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last fee details in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last fee details in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the fee detailses before and after the current fee details in the ordered set where groupId = &#63;.
	*
	* @param spFeeDetailsId the primary key of the current fee details
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails[] findByGroupId_PrevAndNext(
		long spFeeDetailsId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(spFeeDetailsId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the fee detailses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of fee detailses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the fee detailses where fundId = &#63; and spCourseId = &#63;.
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @return the matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundIdAndSpCourseId(
		long fundId, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFundIdAndSpCourseId(fundId, spCourseId);
	}

	/**
	* Returns a range of all the fee detailses where fundId = &#63; and spCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @return the range of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundIdAndSpCourseId(
		long fundId, long spCourseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFundIdAndSpCourseId(fundId, spCourseId, start, end);
	}

	/**
	* Returns an ordered range of all the fee detailses where fundId = &#63; and spCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundIdAndSpCourseId(
		long fundId, long spCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFundIdAndSpCourseId(fundId, spCourseId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first fee details in the ordered set where fundId = &#63; and spCourseId = &#63;.
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findByFundIdAndSpCourseId_First(
		long fundId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .findByFundIdAndSpCourseId_First(fundId, spCourseId,
			orderByComparator);
	}

	/**
	* Returns the first fee details in the ordered set where fundId = &#63; and spCourseId = &#63;.
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByFundIdAndSpCourseId_First(
		long fundId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFundIdAndSpCourseId_First(fundId, spCourseId,
			orderByComparator);
	}

	/**
	* Returns the last fee details in the ordered set where fundId = &#63; and spCourseId = &#63;.
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findByFundIdAndSpCourseId_Last(
		long fundId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .findByFundIdAndSpCourseId_Last(fundId, spCourseId,
			orderByComparator);
	}

	/**
	* Returns the last fee details in the ordered set where fundId = &#63; and spCourseId = &#63;.
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByFundIdAndSpCourseId_Last(
		long fundId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFundIdAndSpCourseId_Last(fundId, spCourseId,
			orderByComparator);
	}

	/**
	* Returns the fee detailses before and after the current fee details in the ordered set where fundId = &#63; and spCourseId = &#63;.
	*
	* @param spFeeDetailsId the primary key of the current fee details
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails[] findByFundIdAndSpCourseId_PrevAndNext(
		long spFeeDetailsId, long fundId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .findByFundIdAndSpCourseId_PrevAndNext(spFeeDetailsId,
			fundId, spCourseId, orderByComparator);
	}

	/**
	* Removes all the fee detailses where fundId = &#63; and spCourseId = &#63; from the database.
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFundIdAndSpCourseId(long fundId, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFundIdAndSpCourseId(fundId, spCourseId);
	}

	/**
	* Returns the number of fee detailses where fundId = &#63; and spCourseId = &#63;.
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFundIdAndSpCourseId(long fundId, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFundIdAndSpCourseId(fundId, spCourseId);
	}

	/**
	* Returns all the fee detailses where fundId = &#63;.
	*
	* @param fundId the fund ID
	* @return the matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundId(
		long fundId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFundId(fundId);
	}

	/**
	* Returns a range of all the fee detailses where fundId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fundId the fund ID
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @return the range of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundId(
		long fundId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFundId(fundId, start, end);
	}

	/**
	* Returns an ordered range of all the fee detailses where fundId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fundId the fund ID
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundId(
		long fundId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFundId(fundId, start, end, orderByComparator);
	}

	/**
	* Returns the first fee details in the ordered set where fundId = &#63;.
	*
	* @param fundId the fund ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findByFundId_First(
		long fundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence().findByFundId_First(fundId, orderByComparator);
	}

	/**
	* Returns the first fee details in the ordered set where fundId = &#63;.
	*
	* @param fundId the fund ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByFundId_First(
		long fundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFundId_First(fundId, orderByComparator);
	}

	/**
	* Returns the last fee details in the ordered set where fundId = &#63;.
	*
	* @param fundId the fund ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findByFundId_Last(
		long fundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence().findByFundId_Last(fundId, orderByComparator);
	}

	/**
	* Returns the last fee details in the ordered set where fundId = &#63;.
	*
	* @param fundId the fund ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByFundId_Last(
		long fundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFundId_Last(fundId, orderByComparator);
	}

	/**
	* Returns the fee detailses before and after the current fee details in the ordered set where fundId = &#63;.
	*
	* @param spFeeDetailsId the primary key of the current fee details
	* @param fundId the fund ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails[] findByFundId_PrevAndNext(
		long spFeeDetailsId, long fundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .findByFundId_PrevAndNext(spFeeDetailsId, fundId,
			orderByComparator);
	}

	/**
	* Removes all the fee detailses where fundId = &#63; from the database.
	*
	* @param fundId the fund ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFundId(long fundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFundId(fundId);
	}

	/**
	* Returns the number of fee detailses where fundId = &#63;.
	*
	* @param fundId the fund ID
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFundId(long fundId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFundId(fundId);
	}

	/**
	* Returns all the fee detailses where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseIdAndGroupId(spCourseId, groupId);
	}

	/**
	* Returns a range of all the fee detailses where spCourseId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @return the range of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdAndGroupId(spCourseId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the fee detailses where spCourseId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseIdAndGroupId(spCourseId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first fee details in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .findByCourseIdAndGroupId_First(spCourseId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first fee details in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdAndGroupId_First(spCourseId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last fee details in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .findByCourseIdAndGroupId_Last(spCourseId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last fee details in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseIdAndGroupId_Last(spCourseId, groupId,
			orderByComparator);
	}

	/**
	* Returns the fee detailses before and after the current fee details in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spFeeDetailsId the primary key of the current fee details
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails[] findByCourseIdAndGroupId_PrevAndNext(
		long spFeeDetailsId, long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .findByCourseIdAndGroupId_PrevAndNext(spFeeDetailsId,
			spCourseId, groupId, orderByComparator);
	}

	/**
	* Removes all the fee detailses where spCourseId = &#63; and groupId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourseIdAndGroupId(spCourseId, groupId);
	}

	/**
	* Returns the number of fee detailses where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseIdAndGroupId(spCourseId, groupId);
	}

	/**
	* Returns all the fee detailses where feeType = &#63; and spCourseId = &#63;.
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @return the matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFeeTypeAndCourseId(
		long feeType, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFeeTypeAndCourseId(feeType, spCourseId);
	}

	/**
	* Returns a range of all the fee detailses where feeType = &#63; and spCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @return the range of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFeeTypeAndCourseId(
		long feeType, long spCourseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFeeTypeAndCourseId(feeType, spCourseId, start, end);
	}

	/**
	* Returns an ordered range of all the fee detailses where feeType = &#63; and spCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFeeTypeAndCourseId(
		long feeType, long spCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFeeTypeAndCourseId(feeType, spCourseId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first fee details in the ordered set where feeType = &#63; and spCourseId = &#63;.
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findByFeeTypeAndCourseId_First(
		long feeType, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .findByFeeTypeAndCourseId_First(feeType, spCourseId,
			orderByComparator);
	}

	/**
	* Returns the first fee details in the ordered set where feeType = &#63; and spCourseId = &#63;.
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByFeeTypeAndCourseId_First(
		long feeType, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFeeTypeAndCourseId_First(feeType, spCourseId,
			orderByComparator);
	}

	/**
	* Returns the last fee details in the ordered set where feeType = &#63; and spCourseId = &#63;.
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findByFeeTypeAndCourseId_Last(
		long feeType, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .findByFeeTypeAndCourseId_Last(feeType, spCourseId,
			orderByComparator);
	}

	/**
	* Returns the last fee details in the ordered set where feeType = &#63; and spCourseId = &#63;.
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByFeeTypeAndCourseId_Last(
		long feeType, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFeeTypeAndCourseId_Last(feeType, spCourseId,
			orderByComparator);
	}

	/**
	* Returns the fee detailses before and after the current fee details in the ordered set where feeType = &#63; and spCourseId = &#63;.
	*
	* @param spFeeDetailsId the primary key of the current fee details
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails[] findByFeeTypeAndCourseId_PrevAndNext(
		long spFeeDetailsId, long feeType, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .findByFeeTypeAndCourseId_PrevAndNext(spFeeDetailsId,
			feeType, spCourseId, orderByComparator);
	}

	/**
	* Removes all the fee detailses where feeType = &#63; and spCourseId = &#63; from the database.
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFeeTypeAndCourseId(long feeType, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFeeTypeAndCourseId(feeType, spCourseId);
	}

	/**
	* Returns the number of fee detailses where feeType = &#63; and spCourseId = &#63;.
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFeeTypeAndCourseId(long feeType, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFeeTypeAndCourseId(feeType, spCourseId);
	}

	/**
	* Returns the fee details where fundId = &#63; and feeType = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchFeeDetailsException} if it could not be found.
	*
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findByfundIdFeeType(
		long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence().findByfundIdFeeType(fundId, feeType);
	}

	/**
	* Returns the fee details where fundId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByfundIdFeeType(
		long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByfundIdFeeType(fundId, feeType);
	}

	/**
	* Returns the fee details where fundId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fundId the fund ID
	* @param feeType the fee type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByfundIdFeeType(
		long fundId, long feeType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfundIdFeeType(fundId, feeType, retrieveFromCache);
	}

	/**
	* Removes the fee details where fundId = &#63; and feeType = &#63; from the database.
	*
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the fee details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails removeByfundIdFeeType(
		long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence().removeByfundIdFeeType(fundId, feeType);
	}

	/**
	* Returns the number of fee detailses where fundId = &#63; and feeType = &#63;.
	*
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfundIdFeeType(long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfundIdFeeType(fundId, feeType);
	}

	/**
	* Returns the fee details where spCourseId = &#63; and fundId = &#63; and feeType = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchFeeDetailsException} if it could not be found.
	*
	* @param spCourseId the sp course ID
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findBycourseIdFundIdFeeType(
		long spCourseId, long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .findBycourseIdFundIdFeeType(spCourseId, fundId, feeType);
	}

	/**
	* Returns the fee details where spCourseId = &#63; and fundId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spCourseId the sp course ID
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchBycourseIdFundIdFeeType(
		long spCourseId, long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycourseIdFundIdFeeType(spCourseId, fundId, feeType);
	}

	/**
	* Returns the fee details where spCourseId = &#63; and fundId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spCourseId the sp course ID
	* @param fundId the fund ID
	* @param feeType the fee type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchBycourseIdFundIdFeeType(
		long spCourseId, long fundId, long feeType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycourseIdFundIdFeeType(spCourseId, fundId, feeType,
			retrieveFromCache);
	}

	/**
	* Removes the fee details where spCourseId = &#63; and fundId = &#63; and feeType = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the fee details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails removeBycourseIdFundIdFeeType(
		long spCourseId, long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence()
				   .removeBycourseIdFundIdFeeType(spCourseId, fundId, feeType);
	}

	/**
	* Returns the number of fee detailses where spCourseId = &#63; and fundId = &#63; and feeType = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycourseIdFundIdFeeType(long spCourseId,
		long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBycourseIdFundIdFeeType(spCourseId, fundId, feeType);
	}

	/**
	* Caches the fee details in the entity cache if it is enabled.
	*
	* @param feeDetails the fee details
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.FeeDetails feeDetails) {
		getPersistence().cacheResult(feeDetails);
	}

	/**
	* Caches the fee detailses in the entity cache if it is enabled.
	*
	* @param feeDetailses the fee detailses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.FeeDetails> feeDetailses) {
		getPersistence().cacheResult(feeDetailses);
	}

	/**
	* Creates a new fee details with the primary key. Does not add the fee details to the database.
	*
	* @param spFeeDetailsId the primary key for the new fee details
	* @return the new fee details
	*/
	public static com.sambaash.platform.srv.model.FeeDetails create(
		long spFeeDetailsId) {
		return getPersistence().create(spFeeDetailsId);
	}

	/**
	* Removes the fee details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spFeeDetailsId the primary key of the fee details
	* @return the fee details that was removed
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails remove(
		long spFeeDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence().remove(spFeeDetailsId);
	}

	public static com.sambaash.platform.srv.model.FeeDetails updateImpl(
		com.sambaash.platform.srv.model.FeeDetails feeDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(feeDetails);
	}

	/**
	* Returns the fee details with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchFeeDetailsException} if it could not be found.
	*
	* @param spFeeDetailsId the primary key of the fee details
	* @return the fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails findByPrimaryKey(
		long spFeeDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException {
		return getPersistence().findByPrimaryKey(spFeeDetailsId);
	}

	/**
	* Returns the fee details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spFeeDetailsId the primary key of the fee details
	* @return the fee details, or <code>null</code> if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.FeeDetails fetchByPrimaryKey(
		long spFeeDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spFeeDetailsId);
	}

	/**
	* Returns all the fee detailses.
	*
	* @return the fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fee detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @return the range of fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fee detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fee detailses
	* @param end the upper bound of the range of fee detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.FeeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the fee detailses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fee detailses.
	*
	* @return the number of fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FeeDetailsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FeeDetailsPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					FeeDetailsPersistence.class.getName());

			ReferenceRegistry.registerReference(FeeDetailsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FeeDetailsPersistence persistence) {
	}

	private static FeeDetailsPersistence _persistence;
}