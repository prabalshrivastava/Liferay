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

package com.sambaash.platform.srv.spinbox.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spinbox.model.IBMessageDetail;

import java.util.List;

/**
 * The persistence utility for the i b message detail service. This utility wraps {@link IBMessageDetailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see IBMessageDetailPersistence
 * @see IBMessageDetailPersistenceImpl
 * @generated
 */
public class IBMessageDetailUtil {
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
	public static void clearCache(IBMessageDetail ibMessageDetail) {
		getPersistence().clearCache(ibMessageDetail);
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
	public static List<IBMessageDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IBMessageDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IBMessageDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static IBMessageDetail update(IBMessageDetail ibMessageDetail)
		throws SystemException {
		return getPersistence().update(ibMessageDetail);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static IBMessageDetail update(IBMessageDetail ibMessageDetail,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ibMessageDetail, serviceContext);
	}

	/**
	* Returns all the i b message details where messageId = &#63;.
	*
	* @param messageId the message ID
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMessageId(messageId);
	}

	/**
	* Returns a range of all the i b message details where messageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param messageId the message ID
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMessageId(messageId, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where messageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param messageId the message ID
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByMessageId(
		long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId(messageId, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByMessageId_First(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByMessageId_First(messageId, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByMessageId_First(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMessageId_First(messageId, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByMessageId_Last(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByMessageId_Last(messageId, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByMessageId_Last(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMessageId_Last(messageId, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where messageId = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByMessageId_PrevAndNext(
		long ibMsgDetailId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByMessageId_PrevAndNext(ibMsgDetailId, messageId,
			orderByComparator);
	}

	/**
	* Removes all the i b message details where messageId = &#63; from the database.
	*
	* @param messageId the message ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMessageId(messageId);
	}

	/**
	* Returns the number of i b message details where messageId = &#63;.
	*
	* @param messageId the message ID
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMessageId(messageId);
	}

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByReceId(receiverId, archived);
	}

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByReceId(receiverId, archived, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceId(
		long receiverId, boolean archived, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceId(receiverId, archived, start, end,
			orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceId_First(
		long receiverId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceId_First(receiverId, archived, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceId_First(
		long receiverId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceId_First(receiverId, archived, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceId_Last(
		long receiverId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceId_Last(receiverId, archived, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceId_Last(
		long receiverId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceId_Last(receiverId, archived, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceId_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceId_PrevAndNext(ibMsgDetailId, receiverId,
			archived, orderByComparator);
	}

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReceId(long receiverId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByReceId(receiverId, archived);
	}

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReceId(long receiverId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByReceId(receiverId, archived);
	}

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdAndRms(receiverId, archived, receiverMsgStatus);
	}

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdAndRms(receiverId, archived, receiverMsgStatus,
			start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndRms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdAndRms(receiverId, archived, receiverMsgStatus,
			start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdAndRms_First(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdAndRms_First(receiverId, archived,
			receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdAndRms_First(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdAndRms_First(receiverId, archived,
			receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdAndRms_Last(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdAndRms_Last(receiverId, archived,
			receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdAndRms_Last(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdAndRms_Last(receiverId, archived,
			receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdAndRms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdAndRms_PrevAndNext(ibMsgDetailId, receiverId,
			archived, receiverMsgStatus, orderByComparator);
	}

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReceIdAndRms(long receiverId, boolean archived,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByReceIdAndRms(receiverId, archived, receiverMsgStatus);
	}

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReceIdAndRms(long receiverId, boolean archived,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByReceIdAndRms(receiverId, archived, receiverMsgStatus);
	}

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdAndSms(receiverId, archived, senderMsgStatus);
	}

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdAndSms(receiverId, archived, senderMsgStatus,
			start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndSms(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdAndSms(receiverId, archived, senderMsgStatus,
			start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdAndSms_First(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdAndSms_First(receiverId, archived,
			senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdAndSms_First(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdAndSms_First(receiverId, archived,
			senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdAndSms_Last(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdAndSms_Last(receiverId, archived,
			senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdAndSms_Last(
		long receiverId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdAndSms_Last(receiverId, archived,
			senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdAndSms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdAndSms_PrevAndNext(ibMsgDetailId, receiverId,
			archived, senderMsgStatus, orderByComparator);
	}

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReceIdAndSms(long receiverId, boolean archived,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByReceIdAndSms(receiverId, archived, senderMsgStatus);
	}

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReceIdAndSms(long receiverId, boolean archived,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByReceIdAndSms(receiverId, archived, senderMsgStatus);
	}

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdRmsAndSms(receiverId, archived,
			receiverMsgStatus, senderMsgStatus);
	}

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdRmsAndSms(receiverId, archived,
			receiverMsgStatus, senderMsgStatus, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdRmsAndSms(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdRmsAndSms(receiverId, archived,
			receiverMsgStatus, senderMsgStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdRmsAndSms_First(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdRmsAndSms_First(receiverId, archived,
			receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdRmsAndSms_First(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdRmsAndSms_First(receiverId, archived,
			receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdRmsAndSms_Last(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdRmsAndSms_Last(receiverId, archived,
			receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdRmsAndSms_Last(
		long receiverId, boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdRmsAndSms_Last(receiverId, archived,
			receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdRmsAndSms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdRmsAndSms_PrevAndNext(ibMsgDetailId,
			receiverId, archived, receiverMsgStatus, senderMsgStatus,
			orderByComparator);
	}

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReceIdRmsAndSms(long receiverId,
		boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByReceIdRmsAndSms(receiverId, archived, receiverMsgStatus,
			senderMsgStatus);
	}

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReceIdRmsAndSms(long receiverId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByReceIdRmsAndSms(receiverId, archived,
			receiverMsgStatus, senderMsgStatus);
	}

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdAndCty(receiverId, archived, category);
	}

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdAndCty(receiverId, archived, category, start,
			end);
	}

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdAndCty(
		long receiverId, boolean archived, java.lang.String category,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdAndCty(receiverId, archived, category, start,
			end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdAndCty_First(
		long receiverId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdAndCty_First(receiverId, archived, category,
			orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdAndCty_First(
		long receiverId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdAndCty_First(receiverId, archived, category,
			orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdAndCty_Last(
		long receiverId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdAndCty_Last(receiverId, archived, category,
			orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdAndCty_Last(
		long receiverId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdAndCty_Last(receiverId, archived, category,
			orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdAndCty_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdAndCty_PrevAndNext(ibMsgDetailId, receiverId,
			archived, category, orderByComparator);
	}

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReceIdAndCty(long receiverId, boolean archived,
		java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByReceIdAndCty(receiverId, archived, category);
	}

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReceIdAndCty(long receiverId, boolean archived,
		java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByReceIdAndCty(receiverId, archived, category);
	}

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdCtyAndRms(receiverId, archived, category,
			receiverMsgStatus);
	}

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdCtyAndRms(receiverId, archived, category,
			receiverMsgStatus, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndRms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdCtyAndRms(receiverId, archived, category,
			receiverMsgStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdCtyAndRms_First(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdCtyAndRms_First(receiverId, archived, category,
			receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdCtyAndRms_First(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdCtyAndRms_First(receiverId, archived,
			category, receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdCtyAndRms_Last(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdCtyAndRms_Last(receiverId, archived, category,
			receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdCtyAndRms_Last(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdCtyAndRms_Last(receiverId, archived, category,
			receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdCtyAndRms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdCtyAndRms_PrevAndNext(ibMsgDetailId,
			receiverId, archived, category, receiverMsgStatus, orderByComparator);
	}

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReceIdCtyAndRms(long receiverId,
		boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByReceIdCtyAndRms(receiverId, archived, category,
			receiverMsgStatus);
	}

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReceIdCtyAndRms(long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByReceIdCtyAndRms(receiverId, archived, category,
			receiverMsgStatus);
	}

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdCtyAndSms(receiverId, archived, category,
			senderMsgStatus);
	}

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdCtyAndSms(receiverId, archived, category,
			senderMsgStatus, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdCtyAndSms(receiverId, archived, category,
			senderMsgStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdCtyAndSms_First(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdCtyAndSms_First(receiverId, archived, category,
			senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdCtyAndSms_First(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdCtyAndSms_First(receiverId, archived,
			category, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdCtyAndSms_Last(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdCtyAndSms_Last(receiverId, archived, category,
			senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdCtyAndSms_Last(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdCtyAndSms_Last(receiverId, archived, category,
			senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdCtyAndSms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String category, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdCtyAndSms_PrevAndNext(ibMsgDetailId,
			receiverId, archived, category, senderMsgStatus, orderByComparator);
	}

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReceIdCtyAndSms(long receiverId,
		boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByReceIdCtyAndSms(receiverId, archived, category,
			senderMsgStatus);
	}

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReceIdCtyAndSms(long receiverId, boolean archived,
		java.lang.String category, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByReceIdCtyAndSms(receiverId, archived, category,
			senderMsgStatus);
	}

	/**
	* Returns all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdCtyRmsAndSms(receiverId, archived, category,
			receiverMsgStatus, senderMsgStatus);
	}

	/**
	* Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdCtyRmsAndSms(receiverId, archived, category,
			receiverMsgStatus, senderMsgStatus, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByReceIdCtyRmsAndSms(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReceIdCtyRmsAndSms(receiverId, archived, category,
			receiverMsgStatus, senderMsgStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdCtyRmsAndSms_First(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdCtyRmsAndSms_First(receiverId, archived,
			category, receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdCtyRmsAndSms_First(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdCtyRmsAndSms_First(receiverId, archived,
			category, receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceIdCtyRmsAndSms_Last(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdCtyRmsAndSms_Last(receiverId, archived,
			category, receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceIdCtyRmsAndSms_Last(
		long receiverId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceIdCtyRmsAndSms_Last(receiverId, archived,
			category, receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByReceIdCtyRmsAndSms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByReceIdCtyRmsAndSms_PrevAndNext(ibMsgDetailId,
			receiverId, archived, category, receiverMsgStatus, senderMsgStatus,
			orderByComparator);
	}

	/**
	* Removes all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReceIdCtyRmsAndSms(long receiverId,
		boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByReceIdCtyRmsAndSms(receiverId, archived, category,
			receiverMsgStatus, senderMsgStatus);
	}

	/**
	* Returns the number of i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param receiverId the receiver ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReceIdCtyRmsAndSms(long receiverId,
		boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByReceIdCtyRmsAndSms(receiverId, archived, category,
			receiverMsgStatus, senderMsgStatus);
	}

	/**
	* Returns the i b message detail where receiverId = &#63; and messageId = &#63; or throws a {@link com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException} if it could not be found.
	*
	* @param receiverId the receiver ID
	* @param messageId the message ID
	* @return the matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByReceiverIdmessageId(
		long receiverId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence().findByReceiverIdmessageId(receiverId, messageId);
	}

	/**
	* Returns the i b message detail where receiverId = &#63; and messageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param receiverId the receiver ID
	* @param messageId the message ID
	* @return the matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceiverIdmessageId(
		long receiverId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByReceiverIdmessageId(receiverId, messageId);
	}

	/**
	* Returns the i b message detail where receiverId = &#63; and messageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param receiverId the receiver ID
	* @param messageId the message ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByReceiverIdmessageId(
		long receiverId, long messageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReceiverIdmessageId(receiverId, messageId,
			retrieveFromCache);
	}

	/**
	* Removes the i b message detail where receiverId = &#63; and messageId = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @param messageId the message ID
	* @return the i b message detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail removeByReceiverIdmessageId(
		long receiverId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .removeByReceiverIdmessageId(receiverId, messageId);
	}

	/**
	* Returns the number of i b message details where receiverId = &#63; and messageId = &#63;.
	*
	* @param receiverId the receiver ID
	* @param messageId the message ID
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReceiverIdmessageId(long receiverId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByReceiverIdmessageId(receiverId, messageId);
	}

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCorpId(corpProfileId, archived);
	}

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCorpId(corpProfileId, archived, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpId(
		long corpProfileId, boolean archived, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpId(corpProfileId, archived, start, end,
			orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpId_First(
		long corpProfileId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpId_First(corpProfileId, archived,
			orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpId_First(
		long corpProfileId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpId_First(corpProfileId, archived,
			orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpId_Last(
		long corpProfileId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpId_Last(corpProfileId, archived, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpId_Last(
		long corpProfileId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpId_Last(corpProfileId, archived,
			orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpId_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpId_PrevAndNext(ibMsgDetailId, corpProfileId,
			archived, orderByComparator);
	}

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCorpId(long corpProfileId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCorpId(corpProfileId, archived);
	}

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCorpId(long corpProfileId, boolean archived)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCorpId(corpProfileId, archived);
	}

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdAndRms(corpProfileId, archived,
			receiverMsgStatus);
	}

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdAndRms(corpProfileId, archived,
			receiverMsgStatus, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndRms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdAndRms(corpProfileId, archived,
			receiverMsgStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdAndRms_First(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdAndRms_First(corpProfileId, archived,
			receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdAndRms_First(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdAndRms_First(corpProfileId, archived,
			receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdAndRms_Last(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdAndRms_Last(corpProfileId, archived,
			receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdAndRms_Last(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdAndRms_Last(corpProfileId, archived,
			receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdAndRms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdAndRms_PrevAndNext(ibMsgDetailId,
			corpProfileId, archived, receiverMsgStatus, orderByComparator);
	}

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCorpIdAndRms(long corpProfileId,
		boolean archived, java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCorpIdAndRms(corpProfileId, archived, receiverMsgStatus);
	}

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCorpIdAndRms(long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCorpIdAndRms(corpProfileId, archived,
			receiverMsgStatus);
	}

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdAndSms(corpProfileId, archived, senderMsgStatus);
	}

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdAndSms(corpProfileId, archived,
			senderMsgStatus, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndSms(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdAndSms(corpProfileId, archived,
			senderMsgStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdAndSms_First(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdAndSms_First(corpProfileId, archived,
			senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdAndSms_First(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdAndSms_First(corpProfileId, archived,
			senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdAndSms_Last(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdAndSms_Last(corpProfileId, archived,
			senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdAndSms_Last(
		long corpProfileId, boolean archived, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdAndSms_Last(corpProfileId, archived,
			senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdAndSms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdAndSms_PrevAndNext(ibMsgDetailId,
			corpProfileId, archived, senderMsgStatus, orderByComparator);
	}

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCorpIdAndSms(long corpProfileId,
		boolean archived, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCorpIdAndSms(corpProfileId, archived, senderMsgStatus);
	}

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCorpIdAndSms(long corpProfileId, boolean archived,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCorpIdAndSms(corpProfileId, archived, senderMsgStatus);
	}

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdRmsAndSms(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus);
	}

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdRmsAndSms(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdRmsAndSms(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdRmsAndSms(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdRmsAndSms_First(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdRmsAndSms_First(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdRmsAndSms_First(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdRmsAndSms_First(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdRmsAndSms_Last(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdRmsAndSms_Last(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdRmsAndSms_Last(
		long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdRmsAndSms_Last(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdRmsAndSms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdRmsAndSms_PrevAndNext(ibMsgDetailId,
			corpProfileId, archived, receiverMsgStatus, senderMsgStatus,
			orderByComparator);
	}

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCorpIdRmsAndSms(long corpProfileId,
		boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCorpIdRmsAndSms(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus);
	}

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCorpIdRmsAndSms(long corpProfileId,
		boolean archived, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCorpIdRmsAndSms(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus);
	}

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdAndCty(corpProfileId, archived, category);
	}

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdAndCty(corpProfileId, archived, category,
			start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdAndCty(
		long corpProfileId, boolean archived, java.lang.String category,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdAndCty(corpProfileId, archived, category,
			start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdAndCty_First(
		long corpProfileId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdAndCty_First(corpProfileId, archived, category,
			orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdAndCty_First(
		long corpProfileId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdAndCty_First(corpProfileId, archived,
			category, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdAndCty_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdAndCty_Last(corpProfileId, archived, category,
			orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdAndCty_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdAndCty_Last(corpProfileId, archived, category,
			orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdAndCty_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdAndCty_PrevAndNext(ibMsgDetailId,
			corpProfileId, archived, category, orderByComparator);
	}

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCorpIdAndCty(long corpProfileId,
		boolean archived, java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCorpIdAndCty(corpProfileId, archived, category);
	}

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCorpIdAndCty(long corpProfileId, boolean archived,
		java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCorpIdAndCty(corpProfileId, archived, category);
	}

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdCtyAndRms(corpProfileId, archived, category,
			receiverMsgStatus);
	}

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdCtyAndRms(corpProfileId, archived, category,
			receiverMsgStatus, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndRms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdCtyAndRms(corpProfileId, archived, category,
			receiverMsgStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdCtyAndRms_First(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdCtyAndRms_First(corpProfileId, archived,
			category, receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdCtyAndRms_First(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdCtyAndRms_First(corpProfileId, archived,
			category, receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdCtyAndRms_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdCtyAndRms_Last(corpProfileId, archived,
			category, receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdCtyAndRms_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdCtyAndRms_Last(corpProfileId, archived,
			category, receiverMsgStatus, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdCtyAndRms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdCtyAndRms_PrevAndNext(ibMsgDetailId,
			corpProfileId, archived, category, receiverMsgStatus,
			orderByComparator);
	}

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCorpIdCtyAndRms(long corpProfileId,
		boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCorpIdCtyAndRms(corpProfileId, archived, category,
			receiverMsgStatus);
	}

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCorpIdCtyAndRms(long corpProfileId,
		boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCorpIdCtyAndRms(corpProfileId, archived, category,
			receiverMsgStatus);
	}

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdCtyAndSms(corpProfileId, archived, category,
			senderMsgStatus);
	}

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdCtyAndSms(corpProfileId, archived, category,
			senderMsgStatus, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdCtyAndSms(corpProfileId, archived, category,
			senderMsgStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdCtyAndSms_First(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdCtyAndSms_First(corpProfileId, archived,
			category, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdCtyAndSms_First(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdCtyAndSms_First(corpProfileId, archived,
			category, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdCtyAndSms_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdCtyAndSms_Last(corpProfileId, archived,
			category, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdCtyAndSms_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdCtyAndSms_Last(corpProfileId, archived,
			category, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdCtyAndSms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String category, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdCtyAndSms_PrevAndNext(ibMsgDetailId,
			corpProfileId, archived, category, senderMsgStatus,
			orderByComparator);
	}

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCorpIdCtyAndSms(long corpProfileId,
		boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCorpIdCtyAndSms(corpProfileId, archived, category,
			senderMsgStatus);
	}

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCorpIdCtyAndSms(long corpProfileId,
		boolean archived, java.lang.String category,
		java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCorpIdCtyAndSms(corpProfileId, archived, category,
			senderMsgStatus);
	}

	/**
	* Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdCtyRmsAndSms(corpProfileId, archived, category,
			receiverMsgStatus, senderMsgStatus);
	}

	/**
	* Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdCtyRmsAndSms(corpProfileId, archived, category,
			receiverMsgStatus, senderMsgStatus, start, end);
	}

	/**
	* Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findByCorpIdCtyRmsAndSms(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCorpIdCtyRmsAndSms(corpProfileId, archived, category,
			receiverMsgStatus, senderMsgStatus, start, end, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdCtyRmsAndSms_First(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdCtyRmsAndSms_First(corpProfileId, archived,
			category, receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdCtyRmsAndSms_First(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdCtyRmsAndSms_First(corpProfileId, archived,
			category, receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByCorpIdCtyRmsAndSms_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdCtyRmsAndSms_Last(corpProfileId, archived,
			category, receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByCorpIdCtyRmsAndSms_Last(
		long corpProfileId, boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCorpIdCtyRmsAndSms_Last(corpProfileId, archived,
			category, receiverMsgStatus, senderMsgStatus, orderByComparator);
	}

	/**
	* Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param ibMsgDetailId the primary key of the current i b message detail
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail[] findByCorpIdCtyRmsAndSms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		java.lang.String category, java.lang.String receiverMsgStatus,
		java.lang.String senderMsgStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence()
				   .findByCorpIdCtyRmsAndSms_PrevAndNext(ibMsgDetailId,
			corpProfileId, archived, category, receiverMsgStatus,
			senderMsgStatus, orderByComparator);
	}

	/**
	* Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63; from the database.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCorpIdCtyRmsAndSms(long corpProfileId,
		boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCorpIdCtyRmsAndSms(corpProfileId, archived, category,
			receiverMsgStatus, senderMsgStatus);
	}

	/**
	* Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	*
	* @param corpProfileId the corp profile ID
	* @param archived the archived
	* @param category the category
	* @param receiverMsgStatus the receiver msg status
	* @param senderMsgStatus the sender msg status
	* @return the number of matching i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCorpIdCtyRmsAndSms(long corpProfileId,
		boolean archived, java.lang.String category,
		java.lang.String receiverMsgStatus, java.lang.String senderMsgStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCorpIdCtyRmsAndSms(corpProfileId, archived,
			category, receiverMsgStatus, senderMsgStatus);
	}

	/**
	* Caches the i b message detail in the entity cache if it is enabled.
	*
	* @param ibMessageDetail the i b message detail
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail) {
		getPersistence().cacheResult(ibMessageDetail);
	}

	/**
	* Caches the i b message details in the entity cache if it is enabled.
	*
	* @param ibMessageDetails the i b message details
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> ibMessageDetails) {
		getPersistence().cacheResult(ibMessageDetails);
	}

	/**
	* Creates a new i b message detail with the primary key. Does not add the i b message detail to the database.
	*
	* @param ibMsgDetailId the primary key for the new i b message detail
	* @return the new i b message detail
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail create(
		long ibMsgDetailId) {
		return getPersistence().create(ibMsgDetailId);
	}

	/**
	* Removes the i b message detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ibMsgDetailId the primary key of the i b message detail
	* @return the i b message detail that was removed
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail remove(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence().remove(ibMsgDetailId);
	}

	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail updateImpl(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ibMessageDetail);
	}

	/**
	* Returns the i b message detail with the primary key or throws a {@link com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException} if it could not be found.
	*
	* @param ibMsgDetailId the primary key of the i b message detail
	* @return the i b message detail
	* @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail findByPrimaryKey(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException {
		return getPersistence().findByPrimaryKey(ibMsgDetailId);
	}

	/**
	* Returns the i b message detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ibMsgDetailId the primary key of the i b message detail
	* @return the i b message detail, or <code>null</code> if a i b message detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spinbox.model.IBMessageDetail fetchByPrimaryKey(
		long ibMsgDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ibMsgDetailId);
	}

	/**
	* Returns all the i b message details.
	*
	* @return the i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the i b message details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @return the range of i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the i b message details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i b message details
	* @param end the upper bound of the range of i b message details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spinbox.model.IBMessageDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the i b message details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of i b message details.
	*
	* @return the number of i b message details
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static IBMessageDetailPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (IBMessageDetailPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spinbox.service.ClpSerializer.getServletContextName(),
					IBMessageDetailPersistence.class.getName());

			ReferenceRegistry.registerReference(IBMessageDetailUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(IBMessageDetailPersistence persistence) {
	}

	private static IBMessageDetailPersistence _persistence;
}