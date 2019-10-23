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

import com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode;

import java.util.List;

/**
 * The persistence utility for the membership package promotion code service. This utility wraps {@link MembershipPackagePromotionCodePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackagePromotionCodePersistence
 * @see MembershipPackagePromotionCodePersistenceImpl
 * @generated
 */
public class MembershipPackagePromotionCodeUtil {
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
	public static void clearCache(
		MembershipPackagePromotionCode membershipPackagePromotionCode) {
		getPersistence().clearCache(membershipPackagePromotionCode);
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
	public static List<MembershipPackagePromotionCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MembershipPackagePromotionCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MembershipPackagePromotionCode> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MembershipPackagePromotionCode update(
		MembershipPackagePromotionCode membershipPackagePromotionCode)
		throws SystemException {
		return getPersistence().update(membershipPackagePromotionCode);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MembershipPackagePromotionCode update(
		MembershipPackagePromotionCode membershipPackagePromotionCode,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(membershipPackagePromotionCode, serviceContext);
	}

	/**
	* Returns all the membership package promotion codes where membershipPackage_id = &#63;.
	*
	* @param membershipPackage_id the membership package_id
	* @return the matching membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findBymembershipPackage_Id(
		long membershipPackage_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymembershipPackage_Id(membershipPackage_id);
	}

	/**
	* Returns a range of all the membership package promotion codes where membershipPackage_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackagePromotionCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param membershipPackage_id the membership package_id
	* @param start the lower bound of the range of membership package promotion codes
	* @param end the upper bound of the range of membership package promotion codes (not inclusive)
	* @return the range of matching membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findBymembershipPackage_Id(
		long membershipPackage_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymembershipPackage_Id(membershipPackage_id, start, end);
	}

	/**
	* Returns an ordered range of all the membership package promotion codes where membershipPackage_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackagePromotionCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param membershipPackage_id the membership package_id
	* @param start the lower bound of the range of membership package promotion codes
	* @param end the upper bound of the range of membership package promotion codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findBymembershipPackage_Id(
		long membershipPackage_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymembershipPackage_Id(membershipPackage_id, start,
			end, orderByComparator);
	}

	/**
	* Returns the first membership package promotion code in the ordered set where membershipPackage_id = &#63;.
	*
	* @param membershipPackage_id the membership package_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package promotion code
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode findBymembershipPackage_Id_First(
		long membershipPackage_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException {
		return getPersistence()
				   .findBymembershipPackage_Id_First(membershipPackage_id,
			orderByComparator);
	}

	/**
	* Returns the first membership package promotion code in the ordered set where membershipPackage_id = &#63;.
	*
	* @param membershipPackage_id the membership package_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package promotion code, or <code>null</code> if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode fetchBymembershipPackage_Id_First(
		long membershipPackage_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymembershipPackage_Id_First(membershipPackage_id,
			orderByComparator);
	}

	/**
	* Returns the last membership package promotion code in the ordered set where membershipPackage_id = &#63;.
	*
	* @param membershipPackage_id the membership package_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package promotion code
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode findBymembershipPackage_Id_Last(
		long membershipPackage_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException {
		return getPersistence()
				   .findBymembershipPackage_Id_Last(membershipPackage_id,
			orderByComparator);
	}

	/**
	* Returns the last membership package promotion code in the ordered set where membershipPackage_id = &#63;.
	*
	* @param membershipPackage_id the membership package_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package promotion code, or <code>null</code> if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode fetchBymembershipPackage_Id_Last(
		long membershipPackage_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymembershipPackage_Id_Last(membershipPackage_id,
			orderByComparator);
	}

	/**
	* Returns the membership package promotion codes before and after the current membership package promotion code in the ordered set where membershipPackage_id = &#63;.
	*
	* @param promotionCode_id the primary key of the current membership package promotion code
	* @param membershipPackage_id the membership package_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package promotion code
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a membership package promotion code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode[] findBymembershipPackage_Id_PrevAndNext(
		long promotionCode_id, long membershipPackage_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException {
		return getPersistence()
				   .findBymembershipPackage_Id_PrevAndNext(promotionCode_id,
			membershipPackage_id, orderByComparator);
	}

	/**
	* Removes all the membership package promotion codes where membershipPackage_id = &#63; from the database.
	*
	* @param membershipPackage_id the membership package_id
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymembershipPackage_Id(long membershipPackage_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBymembershipPackage_Id(membershipPackage_id);
	}

	/**
	* Returns the number of membership package promotion codes where membershipPackage_id = &#63;.
	*
	* @param membershipPackage_id the membership package_id
	* @return the number of matching membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymembershipPackage_Id(long membershipPackage_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymembershipPackage_Id(membershipPackage_id);
	}

	/**
	* Returns all the membership package promotion codes where promotionCode = &#63;.
	*
	* @param promotionCode the promotion code
	* @return the matching membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findBypromotionCode(
		java.lang.String promotionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBypromotionCode(promotionCode);
	}

	/**
	* Returns a range of all the membership package promotion codes where promotionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackagePromotionCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param promotionCode the promotion code
	* @param start the lower bound of the range of membership package promotion codes
	* @param end the upper bound of the range of membership package promotion codes (not inclusive)
	* @return the range of matching membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findBypromotionCode(
		java.lang.String promotionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBypromotionCode(promotionCode, start, end);
	}

	/**
	* Returns an ordered range of all the membership package promotion codes where promotionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackagePromotionCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param promotionCode the promotion code
	* @param start the lower bound of the range of membership package promotion codes
	* @param end the upper bound of the range of membership package promotion codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findBypromotionCode(
		java.lang.String promotionCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypromotionCode(promotionCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership package promotion code in the ordered set where promotionCode = &#63;.
	*
	* @param promotionCode the promotion code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package promotion code
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode findBypromotionCode_First(
		java.lang.String promotionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException {
		return getPersistence()
				   .findBypromotionCode_First(promotionCode, orderByComparator);
	}

	/**
	* Returns the first membership package promotion code in the ordered set where promotionCode = &#63;.
	*
	* @param promotionCode the promotion code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package promotion code, or <code>null</code> if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode fetchBypromotionCode_First(
		java.lang.String promotionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypromotionCode_First(promotionCode, orderByComparator);
	}

	/**
	* Returns the last membership package promotion code in the ordered set where promotionCode = &#63;.
	*
	* @param promotionCode the promotion code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package promotion code
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode findBypromotionCode_Last(
		java.lang.String promotionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException {
		return getPersistence()
				   .findBypromotionCode_Last(promotionCode, orderByComparator);
	}

	/**
	* Returns the last membership package promotion code in the ordered set where promotionCode = &#63;.
	*
	* @param promotionCode the promotion code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package promotion code, or <code>null</code> if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode fetchBypromotionCode_Last(
		java.lang.String promotionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypromotionCode_Last(promotionCode, orderByComparator);
	}

	/**
	* Returns the membership package promotion codes before and after the current membership package promotion code in the ordered set where promotionCode = &#63;.
	*
	* @param promotionCode_id the primary key of the current membership package promotion code
	* @param promotionCode the promotion code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership package promotion code
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a membership package promotion code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode[] findBypromotionCode_PrevAndNext(
		long promotionCode_id, java.lang.String promotionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException {
		return getPersistence()
				   .findBypromotionCode_PrevAndNext(promotionCode_id,
			promotionCode, orderByComparator);
	}

	/**
	* Removes all the membership package promotion codes where promotionCode = &#63; from the database.
	*
	* @param promotionCode the promotion code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBypromotionCode(java.lang.String promotionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBypromotionCode(promotionCode);
	}

	/**
	* Returns the number of membership package promotion codes where promotionCode = &#63;.
	*
	* @param promotionCode the promotion code
	* @return the number of matching membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypromotionCode(java.lang.String promotionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBypromotionCode(promotionCode);
	}

	/**
	* Caches the membership package promotion code in the entity cache if it is enabled.
	*
	* @param membershipPackagePromotionCode the membership package promotion code
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode membershipPackagePromotionCode) {
		getPersistence().cacheResult(membershipPackagePromotionCode);
	}

	/**
	* Caches the membership package promotion codes in the entity cache if it is enabled.
	*
	* @param membershipPackagePromotionCodes the membership package promotion codes
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> membershipPackagePromotionCodes) {
		getPersistence().cacheResult(membershipPackagePromotionCodes);
	}

	/**
	* Creates a new membership package promotion code with the primary key. Does not add the membership package promotion code to the database.
	*
	* @param promotionCode_id the primary key for the new membership package promotion code
	* @return the new membership package promotion code
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode create(
		long promotionCode_id) {
		return getPersistence().create(promotionCode_id);
	}

	/**
	* Removes the membership package promotion code with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param promotionCode_id the primary key of the membership package promotion code
	* @return the membership package promotion code that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a membership package promotion code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode remove(
		long promotionCode_id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException {
		return getPersistence().remove(promotionCode_id);
	}

	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode membershipPackagePromotionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(membershipPackagePromotionCode);
	}

	/**
	* Returns the membership package promotion code with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException} if it could not be found.
	*
	* @param promotionCode_id the primary key of the membership package promotion code
	* @return the membership package promotion code
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a membership package promotion code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode findByPrimaryKey(
		long promotionCode_id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException {
		return getPersistence().findByPrimaryKey(promotionCode_id);
	}

	/**
	* Returns the membership package promotion code with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param promotionCode_id the primary key of the membership package promotion code
	* @return the membership package promotion code, or <code>null</code> if a membership package promotion code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode fetchByPrimaryKey(
		long promotionCode_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(promotionCode_id);
	}

	/**
	* Returns all the membership package promotion codes.
	*
	* @return the membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the membership package promotion codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackagePromotionCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package promotion codes
	* @param end the upper bound of the range of membership package promotion codes (not inclusive)
	* @return the range of membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the membership package promotion codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackagePromotionCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership package promotion codes
	* @param end the upper bound of the range of membership package promotion codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the membership package promotion codes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of membership package promotion codes.
	*
	* @return the number of membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MembershipPackagePromotionCodePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MembershipPackagePromotionCodePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					MembershipPackagePromotionCodePersistence.class.getName());

			ReferenceRegistry.registerReference(MembershipPackagePromotionCodeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		MembershipPackagePromotionCodePersistence persistence) {
	}

	private static MembershipPackagePromotionCodePersistence _persistence;
}