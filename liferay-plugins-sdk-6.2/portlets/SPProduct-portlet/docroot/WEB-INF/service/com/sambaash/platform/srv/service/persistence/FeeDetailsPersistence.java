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

import com.sambaash.platform.srv.model.FeeDetails;

/**
 * The persistence interface for the fee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see FeeDetailsPersistenceImpl
 * @see FeeDetailsUtil
 * @generated
 */
public interface FeeDetailsPersistence extends BasePersistence<FeeDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FeeDetailsUtil} to access the fee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fee detailses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fee details in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the first fee details in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fee details in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the last fee details in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails[] findByGroupId_PrevAndNext(
		long spFeeDetailsId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Removes all the fee detailses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fee detailses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fee detailses where fundId = &#63; and spCourseId = &#63;.
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @return the matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundIdAndSpCourseId(
		long fundId, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundIdAndSpCourseId(
		long fundId, long spCourseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundIdAndSpCourseId(
		long fundId, long spCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails findByFundIdAndSpCourseId_First(
		long fundId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the first fee details in the ordered set where fundId = &#63; and spCourseId = &#63;.
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByFundIdAndSpCourseId_First(
		long fundId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails findByFundIdAndSpCourseId_Last(
		long fundId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the last fee details in the ordered set where fundId = &#63; and spCourseId = &#63;.
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByFundIdAndSpCourseId_Last(
		long fundId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails[] findByFundIdAndSpCourseId_PrevAndNext(
		long spFeeDetailsId, long fundId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Removes all the fee detailses where fundId = &#63; and spCourseId = &#63; from the database.
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFundIdAndSpCourseId(long fundId, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fee detailses where fundId = &#63; and spCourseId = &#63;.
	*
	* @param fundId the fund ID
	* @param spCourseId the sp course ID
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByFundIdAndSpCourseId(long fundId, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fee detailses where fundId = &#63;.
	*
	* @param fundId the fund ID
	* @return the matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundId(
		long fundId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundId(
		long fundId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFundId(
		long fundId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fee details in the ordered set where fundId = &#63;.
	*
	* @param fundId the fund ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails findByFundId_First(
		long fundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the first fee details in the ordered set where fundId = &#63;.
	*
	* @param fundId the fund ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByFundId_First(
		long fundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fee details in the ordered set where fundId = &#63;.
	*
	* @param fundId the fund ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails findByFundId_Last(
		long fundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the last fee details in the ordered set where fundId = &#63;.
	*
	* @param fundId the fund ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByFundId_Last(
		long fundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails[] findByFundId_PrevAndNext(
		long spFeeDetailsId, long fundId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Removes all the fee detailses where fundId = &#63; from the database.
	*
	* @param fundId the fund ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFundId(long fundId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fee detailses where fundId = &#63;.
	*
	* @param fundId the fund ID
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByFundId(long fundId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fee detailses where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails findByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the first fee details in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails findByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the last fee details in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails[] findByCourseIdAndGroupId_PrevAndNext(
		long spFeeDetailsId, long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Removes all the fee detailses where spCourseId = &#63; and groupId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fee detailses where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fee detailses where feeType = &#63; and spCourseId = &#63;.
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @return the matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFeeTypeAndCourseId(
		long feeType, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFeeTypeAndCourseId(
		long feeType, long spCourseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findByFeeTypeAndCourseId(
		long feeType, long spCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails findByFeeTypeAndCourseId_First(
		long feeType, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the first fee details in the ordered set where feeType = &#63; and spCourseId = &#63;.
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByFeeTypeAndCourseId_First(
		long feeType, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails findByFeeTypeAndCourseId_Last(
		long feeType, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the last fee details in the ordered set where feeType = &#63; and spCourseId = &#63;.
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByFeeTypeAndCourseId_Last(
		long feeType, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails[] findByFeeTypeAndCourseId_PrevAndNext(
		long spFeeDetailsId, long feeType, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Removes all the fee detailses where feeType = &#63; and spCourseId = &#63; from the database.
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFeeTypeAndCourseId(long feeType, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fee detailses where feeType = &#63; and spCourseId = &#63;.
	*
	* @param feeType the fee type
	* @param spCourseId the sp course ID
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByFeeTypeAndCourseId(long feeType, long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fee details where fundId = &#63; and feeType = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchFeeDetailsException} if it could not be found.
	*
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the matching fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails findByfundIdFeeType(
		long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the fee details where fundId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByfundIdFeeType(
		long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fee details where fundId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param fundId the fund ID
	* @param feeType the fee type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByfundIdFeeType(
		long fundId, long feeType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the fee details where fundId = &#63; and feeType = &#63; from the database.
	*
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the fee details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails removeByfundIdFeeType(
		long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the number of fee detailses where fundId = &#63; and feeType = &#63;.
	*
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countByfundIdFeeType(long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails findBycourseIdFundIdFeeType(
		long spCourseId, long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the fee details where spCourseId = &#63; and fundId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spCourseId the sp course ID
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the matching fee details, or <code>null</code> if a matching fee details could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchBycourseIdFundIdFeeType(
		long spCourseId, long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.model.FeeDetails fetchBycourseIdFundIdFeeType(
		long spCourseId, long fundId, long feeType, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the fee details where spCourseId = &#63; and fundId = &#63; and feeType = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the fee details that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails removeBycourseIdFundIdFeeType(
		long spCourseId, long fundId, long feeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the number of fee detailses where spCourseId = &#63; and fundId = &#63; and feeType = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param fundId the fund ID
	* @param feeType the fee type
	* @return the number of matching fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countBycourseIdFundIdFeeType(long spCourseId, long fundId,
		long feeType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the fee details in the entity cache if it is enabled.
	*
	* @param feeDetails the fee details
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.FeeDetails feeDetails);

	/**
	* Caches the fee detailses in the entity cache if it is enabled.
	*
	* @param feeDetailses the fee detailses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.FeeDetails> feeDetailses);

	/**
	* Creates a new fee details with the primary key. Does not add the fee details to the database.
	*
	* @param spFeeDetailsId the primary key for the new fee details
	* @return the new fee details
	*/
	public com.sambaash.platform.srv.model.FeeDetails create(
		long spFeeDetailsId);

	/**
	* Removes the fee details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spFeeDetailsId the primary key of the fee details
	* @return the fee details that was removed
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails remove(
		long spFeeDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	public com.sambaash.platform.srv.model.FeeDetails updateImpl(
		com.sambaash.platform.srv.model.FeeDetails feeDetails)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fee details with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchFeeDetailsException} if it could not be found.
	*
	* @param spFeeDetailsId the primary key of the fee details
	* @return the fee details
	* @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails findByPrimaryKey(
		long spFeeDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchFeeDetailsException;

	/**
	* Returns the fee details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spFeeDetailsId the primary key of the fee details
	* @return the fee details, or <code>null</code> if a fee details with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.FeeDetails fetchByPrimaryKey(
		long spFeeDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fee detailses.
	*
	* @return the fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.model.FeeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fee detailses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fee detailses.
	*
	* @return the number of fee detailses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}