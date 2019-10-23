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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode;

/**
 * The persistence interface for the membership package promotion code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackagePromotionCodePersistenceImpl
 * @see MembershipPackagePromotionCodeUtil
 * @generated
 */
public interface MembershipPackagePromotionCodePersistence
	extends BasePersistence<MembershipPackagePromotionCode> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MembershipPackagePromotionCodeUtil} to access the membership package promotion code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the membership package promotion codes where membershipPackage_id = &#63;.
	*
	* @param membershipPackage_id the membership package_id
	* @return the matching membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findBymembershipPackage_Id(
		long membershipPackage_id)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findBymembershipPackage_Id(
		long membershipPackage_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findBymembershipPackage_Id(
		long membershipPackage_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package promotion code in the ordered set where membershipPackage_id = &#63;.
	*
	* @param membershipPackage_id the membership package_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package promotion code
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode findBymembershipPackage_Id_First(
		long membershipPackage_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException;

	/**
	* Returns the first membership package promotion code in the ordered set where membershipPackage_id = &#63;.
	*
	* @param membershipPackage_id the membership package_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package promotion code, or <code>null</code> if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode fetchBymembershipPackage_Id_First(
		long membershipPackage_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package promotion code in the ordered set where membershipPackage_id = &#63;.
	*
	* @param membershipPackage_id the membership package_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package promotion code
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode findBymembershipPackage_Id_Last(
		long membershipPackage_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException;

	/**
	* Returns the last membership package promotion code in the ordered set where membershipPackage_id = &#63;.
	*
	* @param membershipPackage_id the membership package_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package promotion code, or <code>null</code> if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode fetchBymembershipPackage_Id_Last(
		long membershipPackage_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode[] findBymembershipPackage_Id_PrevAndNext(
		long promotionCode_id, long membershipPackage_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException;

	/**
	* Removes all the membership package promotion codes where membershipPackage_id = &#63; from the database.
	*
	* @param membershipPackage_id the membership package_id
	* @throws SystemException if a system exception occurred
	*/
	public void removeBymembershipPackage_Id(long membershipPackage_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package promotion codes where membershipPackage_id = &#63;.
	*
	* @param membershipPackage_id the membership package_id
	* @return the number of matching membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public int countBymembershipPackage_Id(long membershipPackage_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package promotion codes where promotionCode = &#63;.
	*
	* @param promotionCode the promotion code
	* @return the matching membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findBypromotionCode(
		java.lang.String promotionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findBypromotionCode(
		java.lang.String promotionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findBypromotionCode(
		java.lang.String promotionCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership package promotion code in the ordered set where promotionCode = &#63;.
	*
	* @param promotionCode the promotion code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package promotion code
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode findBypromotionCode_First(
		java.lang.String promotionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException;

	/**
	* Returns the first membership package promotion code in the ordered set where promotionCode = &#63;.
	*
	* @param promotionCode the promotion code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership package promotion code, or <code>null</code> if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode fetchBypromotionCode_First(
		java.lang.String promotionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership package promotion code in the ordered set where promotionCode = &#63;.
	*
	* @param promotionCode the promotion code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package promotion code
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode findBypromotionCode_Last(
		java.lang.String promotionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException;

	/**
	* Returns the last membership package promotion code in the ordered set where promotionCode = &#63;.
	*
	* @param promotionCode the promotion code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership package promotion code, or <code>null</code> if a matching membership package promotion code could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode fetchBypromotionCode_Last(
		java.lang.String promotionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode[] findBypromotionCode_PrevAndNext(
		long promotionCode_id, java.lang.String promotionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException;

	/**
	* Removes all the membership package promotion codes where promotionCode = &#63; from the database.
	*
	* @param promotionCode the promotion code
	* @throws SystemException if a system exception occurred
	*/
	public void removeBypromotionCode(java.lang.String promotionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package promotion codes where promotionCode = &#63;.
	*
	* @param promotionCode the promotion code
	* @return the number of matching membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public int countBypromotionCode(java.lang.String promotionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the membership package promotion code in the entity cache if it is enabled.
	*
	* @param membershipPackagePromotionCode the membership package promotion code
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode membershipPackagePromotionCode);

	/**
	* Caches the membership package promotion codes in the entity cache if it is enabled.
	*
	* @param membershipPackagePromotionCodes the membership package promotion codes
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> membershipPackagePromotionCodes);

	/**
	* Creates a new membership package promotion code with the primary key. Does not add the membership package promotion code to the database.
	*
	* @param promotionCode_id the primary key for the new membership package promotion code
	* @return the new membership package promotion code
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode create(
		long promotionCode_id);

	/**
	* Removes the membership package promotion code with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param promotionCode_id the primary key of the membership package promotion code
	* @return the membership package promotion code that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a membership package promotion code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode remove(
		long promotionCode_id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException;

	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode membershipPackagePromotionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership package promotion code with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException} if it could not be found.
	*
	* @param promotionCode_id the primary key of the membership package promotion code
	* @return the membership package promotion code
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a membership package promotion code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode findByPrimaryKey(
		long promotionCode_id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException;

	/**
	* Returns the membership package promotion code with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param promotionCode_id the primary key of the membership package promotion code
	* @return the membership package promotion code, or <code>null</code> if a membership package promotion code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode fetchByPrimaryKey(
		long promotionCode_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership package promotion codes.
	*
	* @return the membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the membership package promotion codes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership package promotion codes.
	*
	* @return the number of membership package promotion codes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}