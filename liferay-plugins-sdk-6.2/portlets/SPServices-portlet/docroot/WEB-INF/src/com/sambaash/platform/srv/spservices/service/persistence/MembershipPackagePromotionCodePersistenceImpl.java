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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException;
import com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode;
import com.sambaash.platform.srv.spservices.model.impl.MembershipPackagePromotionCodeImpl;
import com.sambaash.platform.srv.spservices.model.impl.MembershipPackagePromotionCodeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the membership package promotion code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackagePromotionCodePersistence
 * @see MembershipPackagePromotionCodeUtil
 * @generated
 */
public class MembershipPackagePromotionCodePersistenceImpl
	extends BasePersistenceImpl<MembershipPackagePromotionCode>
	implements MembershipPackagePromotionCodePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MembershipPackagePromotionCodeUtil} to access the membership package promotion code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MembershipPackagePromotionCodeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackagePromotionCodeModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackagePromotionCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackagePromotionCodeModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackagePromotionCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackagePromotionCodeModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGE_ID =
		new FinderPath(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackagePromotionCodeModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackagePromotionCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBymembershipPackage_Id",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGE_ID =
		new FinderPath(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackagePromotionCodeModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackagePromotionCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBymembershipPackage_Id",
			new String[] { Long.class.getName() },
			MembershipPackagePromotionCodeModelImpl.MEMBERSHIPPACKAGE_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGE_ID = new FinderPath(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackagePromotionCodeModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBymembershipPackage_Id", new String[] { Long.class.getName() });

	/**
	 * Returns all the membership package promotion codes where membershipPackage_id = &#63;.
	 *
	 * @param membershipPackage_id the membership package_id
	 * @return the matching membership package promotion codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackagePromotionCode> findBymembershipPackage_Id(
		long membershipPackage_id) throws SystemException {
		return findBymembershipPackage_Id(membershipPackage_id,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MembershipPackagePromotionCode> findBymembershipPackage_Id(
		long membershipPackage_id, int start, int end)
		throws SystemException {
		return findBymembershipPackage_Id(membershipPackage_id, start, end, null);
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
	@Override
	public List<MembershipPackagePromotionCode> findBymembershipPackage_Id(
		long membershipPackage_id, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGE_ID;
			finderArgs = new Object[] { membershipPackage_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGE_ID;
			finderArgs = new Object[] {
					membershipPackage_id,
					
					start, end, orderByComparator
				};
		}

		List<MembershipPackagePromotionCode> list = (List<MembershipPackagePromotionCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackagePromotionCode membershipPackagePromotionCode : list) {
				if ((membershipPackage_id != membershipPackagePromotionCode.getMembershipPackage_id())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGEPROMOTIONCODE_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGE_ID_MEMBERSHIPPACKAGE_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackagePromotionCodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(membershipPackage_id);

				if (!pagination) {
					list = (List<MembershipPackagePromotionCode>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackagePromotionCode>(list);
				}
				else {
					list = (List<MembershipPackagePromotionCode>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public MembershipPackagePromotionCode findBymembershipPackage_Id_First(
		long membershipPackage_id, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackagePromotionCodeException, SystemException {
		MembershipPackagePromotionCode membershipPackagePromotionCode = fetchBymembershipPackage_Id_First(membershipPackage_id,
				orderByComparator);

		if (membershipPackagePromotionCode != null) {
			return membershipPackagePromotionCode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("membershipPackage_id=");
		msg.append(membershipPackage_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackagePromotionCodeException(msg.toString());
	}

	/**
	 * Returns the first membership package promotion code in the ordered set where membershipPackage_id = &#63;.
	 *
	 * @param membershipPackage_id the membership package_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package promotion code, or <code>null</code> if a matching membership package promotion code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackagePromotionCode fetchBymembershipPackage_Id_First(
		long membershipPackage_id, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackagePromotionCode> list = findBymembershipPackage_Id(membershipPackage_id,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MembershipPackagePromotionCode findBymembershipPackage_Id_Last(
		long membershipPackage_id, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackagePromotionCodeException, SystemException {
		MembershipPackagePromotionCode membershipPackagePromotionCode = fetchBymembershipPackage_Id_Last(membershipPackage_id,
				orderByComparator);

		if (membershipPackagePromotionCode != null) {
			return membershipPackagePromotionCode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("membershipPackage_id=");
		msg.append(membershipPackage_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackagePromotionCodeException(msg.toString());
	}

	/**
	 * Returns the last membership package promotion code in the ordered set where membershipPackage_id = &#63;.
	 *
	 * @param membershipPackage_id the membership package_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package promotion code, or <code>null</code> if a matching membership package promotion code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackagePromotionCode fetchBymembershipPackage_Id_Last(
		long membershipPackage_id, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBymembershipPackage_Id(membershipPackage_id);

		if (count == 0) {
			return null;
		}

		List<MembershipPackagePromotionCode> list = findBymembershipPackage_Id(membershipPackage_id,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MembershipPackagePromotionCode[] findBymembershipPackage_Id_PrevAndNext(
		long promotionCode_id, long membershipPackage_id,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackagePromotionCodeException, SystemException {
		MembershipPackagePromotionCode membershipPackagePromotionCode = findByPrimaryKey(promotionCode_id);

		Session session = null;

		try {
			session = openSession();

			MembershipPackagePromotionCode[] array = new MembershipPackagePromotionCodeImpl[3];

			array[0] = getBymembershipPackage_Id_PrevAndNext(session,
					membershipPackagePromotionCode, membershipPackage_id,
					orderByComparator, true);

			array[1] = membershipPackagePromotionCode;

			array[2] = getBymembershipPackage_Id_PrevAndNext(session,
					membershipPackagePromotionCode, membershipPackage_id,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipPackagePromotionCode getBymembershipPackage_Id_PrevAndNext(
		Session session,
		MembershipPackagePromotionCode membershipPackagePromotionCode,
		long membershipPackage_id, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGEPROMOTIONCODE_WHERE);

		query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGE_ID_MEMBERSHIPPACKAGE_ID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MembershipPackagePromotionCodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(membershipPackage_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackagePromotionCode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackagePromotionCode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package promotion codes where membershipPackage_id = &#63; from the database.
	 *
	 * @param membershipPackage_id the membership package_id
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBymembershipPackage_Id(long membershipPackage_id)
		throws SystemException {
		for (MembershipPackagePromotionCode membershipPackagePromotionCode : findBymembershipPackage_Id(
				membershipPackage_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackagePromotionCode);
		}
	}

	/**
	 * Returns the number of membership package promotion codes where membershipPackage_id = &#63;.
	 *
	 * @param membershipPackage_id the membership package_id
	 * @return the number of matching membership package promotion codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBymembershipPackage_Id(long membershipPackage_id)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGE_ID;

		Object[] finderArgs = new Object[] { membershipPackage_id };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGEPROMOTIONCODE_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGE_ID_MEMBERSHIPPACKAGE_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(membershipPackage_id);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGE_ID_MEMBERSHIPPACKAGE_ID_2 =
		"membershipPackagePromotionCode.membershipPackage_id = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROMOTIONCODE =
		new FinderPath(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackagePromotionCodeModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackagePromotionCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypromotionCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROMOTIONCODE =
		new FinderPath(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackagePromotionCodeModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackagePromotionCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypromotionCode",
			new String[] { String.class.getName() },
			MembershipPackagePromotionCodeModelImpl.PROMOTIONCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROMOTIONCODE = new FinderPath(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackagePromotionCodeModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypromotionCode", new String[] { String.class.getName() });

	/**
	 * Returns all the membership package promotion codes where promotionCode = &#63;.
	 *
	 * @param promotionCode the promotion code
	 * @return the matching membership package promotion codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackagePromotionCode> findBypromotionCode(
		String promotionCode) throws SystemException {
		return findBypromotionCode(promotionCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<MembershipPackagePromotionCode> findBypromotionCode(
		String promotionCode, int start, int end) throws SystemException {
		return findBypromotionCode(promotionCode, start, end, null);
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
	@Override
	public List<MembershipPackagePromotionCode> findBypromotionCode(
		String promotionCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROMOTIONCODE;
			finderArgs = new Object[] { promotionCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROMOTIONCODE;
			finderArgs = new Object[] {
					promotionCode,
					
					start, end, orderByComparator
				};
		}

		List<MembershipPackagePromotionCode> list = (List<MembershipPackagePromotionCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackagePromotionCode membershipPackagePromotionCode : list) {
				if (!Validator.equals(promotionCode,
							membershipPackagePromotionCode.getPromotionCode())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGEPROMOTIONCODE_WHERE);

			boolean bindPromotionCode = false;

			if (promotionCode == null) {
				query.append(_FINDER_COLUMN_PROMOTIONCODE_PROMOTIONCODE_1);
			}
			else if (promotionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROMOTIONCODE_PROMOTIONCODE_3);
			}
			else {
				bindPromotionCode = true;

				query.append(_FINDER_COLUMN_PROMOTIONCODE_PROMOTIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackagePromotionCodeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPromotionCode) {
					qPos.add(promotionCode);
				}

				if (!pagination) {
					list = (List<MembershipPackagePromotionCode>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackagePromotionCode>(list);
				}
				else {
					list = (List<MembershipPackagePromotionCode>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public MembershipPackagePromotionCode findBypromotionCode_First(
		String promotionCode, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackagePromotionCodeException, SystemException {
		MembershipPackagePromotionCode membershipPackagePromotionCode = fetchBypromotionCode_First(promotionCode,
				orderByComparator);

		if (membershipPackagePromotionCode != null) {
			return membershipPackagePromotionCode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("promotionCode=");
		msg.append(promotionCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackagePromotionCodeException(msg.toString());
	}

	/**
	 * Returns the first membership package promotion code in the ordered set where promotionCode = &#63;.
	 *
	 * @param promotionCode the promotion code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package promotion code, or <code>null</code> if a matching membership package promotion code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackagePromotionCode fetchBypromotionCode_First(
		String promotionCode, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackagePromotionCode> list = findBypromotionCode(promotionCode,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MembershipPackagePromotionCode findBypromotionCode_Last(
		String promotionCode, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackagePromotionCodeException, SystemException {
		MembershipPackagePromotionCode membershipPackagePromotionCode = fetchBypromotionCode_Last(promotionCode,
				orderByComparator);

		if (membershipPackagePromotionCode != null) {
			return membershipPackagePromotionCode;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("promotionCode=");
		msg.append(promotionCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackagePromotionCodeException(msg.toString());
	}

	/**
	 * Returns the last membership package promotion code in the ordered set where promotionCode = &#63;.
	 *
	 * @param promotionCode the promotion code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package promotion code, or <code>null</code> if a matching membership package promotion code could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackagePromotionCode fetchBypromotionCode_Last(
		String promotionCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBypromotionCode(promotionCode);

		if (count == 0) {
			return null;
		}

		List<MembershipPackagePromotionCode> list = findBypromotionCode(promotionCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MembershipPackagePromotionCode[] findBypromotionCode_PrevAndNext(
		long promotionCode_id, String promotionCode,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackagePromotionCodeException, SystemException {
		MembershipPackagePromotionCode membershipPackagePromotionCode = findByPrimaryKey(promotionCode_id);

		Session session = null;

		try {
			session = openSession();

			MembershipPackagePromotionCode[] array = new MembershipPackagePromotionCodeImpl[3];

			array[0] = getBypromotionCode_PrevAndNext(session,
					membershipPackagePromotionCode, promotionCode,
					orderByComparator, true);

			array[1] = membershipPackagePromotionCode;

			array[2] = getBypromotionCode_PrevAndNext(session,
					membershipPackagePromotionCode, promotionCode,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipPackagePromotionCode getBypromotionCode_PrevAndNext(
		Session session,
		MembershipPackagePromotionCode membershipPackagePromotionCode,
		String promotionCode, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGEPROMOTIONCODE_WHERE);

		boolean bindPromotionCode = false;

		if (promotionCode == null) {
			query.append(_FINDER_COLUMN_PROMOTIONCODE_PROMOTIONCODE_1);
		}
		else if (promotionCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PROMOTIONCODE_PROMOTIONCODE_3);
		}
		else {
			bindPromotionCode = true;

			query.append(_FINDER_COLUMN_PROMOTIONCODE_PROMOTIONCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MembershipPackagePromotionCodeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPromotionCode) {
			qPos.add(promotionCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackagePromotionCode);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackagePromotionCode> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package promotion codes where promotionCode = &#63; from the database.
	 *
	 * @param promotionCode the promotion code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBypromotionCode(String promotionCode)
		throws SystemException {
		for (MembershipPackagePromotionCode membershipPackagePromotionCode : findBypromotionCode(
				promotionCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackagePromotionCode);
		}
	}

	/**
	 * Returns the number of membership package promotion codes where promotionCode = &#63;.
	 *
	 * @param promotionCode the promotion code
	 * @return the number of matching membership package promotion codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypromotionCode(String promotionCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROMOTIONCODE;

		Object[] finderArgs = new Object[] { promotionCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGEPROMOTIONCODE_WHERE);

			boolean bindPromotionCode = false;

			if (promotionCode == null) {
				query.append(_FINDER_COLUMN_PROMOTIONCODE_PROMOTIONCODE_1);
			}
			else if (promotionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROMOTIONCODE_PROMOTIONCODE_3);
			}
			else {
				bindPromotionCode = true;

				query.append(_FINDER_COLUMN_PROMOTIONCODE_PROMOTIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPromotionCode) {
					qPos.add(promotionCode);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROMOTIONCODE_PROMOTIONCODE_1 = "membershipPackagePromotionCode.promotionCode IS NULL";
	private static final String _FINDER_COLUMN_PROMOTIONCODE_PROMOTIONCODE_2 = "membershipPackagePromotionCode.promotionCode = ?";
	private static final String _FINDER_COLUMN_PROMOTIONCODE_PROMOTIONCODE_3 = "(membershipPackagePromotionCode.promotionCode IS NULL OR membershipPackagePromotionCode.promotionCode = '')";

	public MembershipPackagePromotionCodePersistenceImpl() {
		setModelClass(MembershipPackagePromotionCode.class);
	}

	/**
	 * Caches the membership package promotion code in the entity cache if it is enabled.
	 *
	 * @param membershipPackagePromotionCode the membership package promotion code
	 */
	@Override
	public void cacheResult(
		MembershipPackagePromotionCode membershipPackagePromotionCode) {
		EntityCacheUtil.putResult(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackagePromotionCodeImpl.class,
			membershipPackagePromotionCode.getPrimaryKey(),
			membershipPackagePromotionCode);

		membershipPackagePromotionCode.resetOriginalValues();
	}

	/**
	 * Caches the membership package promotion codes in the entity cache if it is enabled.
	 *
	 * @param membershipPackagePromotionCodes the membership package promotion codes
	 */
	@Override
	public void cacheResult(
		List<MembershipPackagePromotionCode> membershipPackagePromotionCodes) {
		for (MembershipPackagePromotionCode membershipPackagePromotionCode : membershipPackagePromotionCodes) {
			if (EntityCacheUtil.getResult(
						MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
						MembershipPackagePromotionCodeImpl.class,
						membershipPackagePromotionCode.getPrimaryKey()) == null) {
				cacheResult(membershipPackagePromotionCode);
			}
			else {
				membershipPackagePromotionCode.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all membership package promotion codes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MembershipPackagePromotionCodeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MembershipPackagePromotionCodeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the membership package promotion code.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		MembershipPackagePromotionCode membershipPackagePromotionCode) {
		EntityCacheUtil.removeResult(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackagePromotionCodeImpl.class,
			membershipPackagePromotionCode.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<MembershipPackagePromotionCode> membershipPackagePromotionCodes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MembershipPackagePromotionCode membershipPackagePromotionCode : membershipPackagePromotionCodes) {
			EntityCacheUtil.removeResult(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
				MembershipPackagePromotionCodeImpl.class,
				membershipPackagePromotionCode.getPrimaryKey());
		}
	}

	/**
	 * Creates a new membership package promotion code with the primary key. Does not add the membership package promotion code to the database.
	 *
	 * @param promotionCode_id the primary key for the new membership package promotion code
	 * @return the new membership package promotion code
	 */
	@Override
	public MembershipPackagePromotionCode create(long promotionCode_id) {
		MembershipPackagePromotionCode membershipPackagePromotionCode = new MembershipPackagePromotionCodeImpl();

		membershipPackagePromotionCode.setNew(true);
		membershipPackagePromotionCode.setPrimaryKey(promotionCode_id);

		return membershipPackagePromotionCode;
	}

	/**
	 * Removes the membership package promotion code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param promotionCode_id the primary key of the membership package promotion code
	 * @return the membership package promotion code that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a membership package promotion code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackagePromotionCode remove(long promotionCode_id)
		throws NoSuchMembershipPackagePromotionCodeException, SystemException {
		return remove((Serializable)promotionCode_id);
	}

	/**
	 * Removes the membership package promotion code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the membership package promotion code
	 * @return the membership package promotion code that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a membership package promotion code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackagePromotionCode remove(Serializable primaryKey)
		throws NoSuchMembershipPackagePromotionCodeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MembershipPackagePromotionCode membershipPackagePromotionCode = (MembershipPackagePromotionCode)session.get(MembershipPackagePromotionCodeImpl.class,
					primaryKey);

			if (membershipPackagePromotionCode == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMembershipPackagePromotionCodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(membershipPackagePromotionCode);
		}
		catch (NoSuchMembershipPackagePromotionCodeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MembershipPackagePromotionCode removeImpl(
		MembershipPackagePromotionCode membershipPackagePromotionCode)
		throws SystemException {
		membershipPackagePromotionCode = toUnwrappedModel(membershipPackagePromotionCode);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(membershipPackagePromotionCode)) {
				membershipPackagePromotionCode = (MembershipPackagePromotionCode)session.get(MembershipPackagePromotionCodeImpl.class,
						membershipPackagePromotionCode.getPrimaryKeyObj());
			}

			if (membershipPackagePromotionCode != null) {
				session.delete(membershipPackagePromotionCode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (membershipPackagePromotionCode != null) {
			clearCache(membershipPackagePromotionCode);
		}

		return membershipPackagePromotionCode;
	}

	@Override
	public MembershipPackagePromotionCode updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode membershipPackagePromotionCode)
		throws SystemException {
		membershipPackagePromotionCode = toUnwrappedModel(membershipPackagePromotionCode);

		boolean isNew = membershipPackagePromotionCode.isNew();

		MembershipPackagePromotionCodeModelImpl membershipPackagePromotionCodeModelImpl =
			(MembershipPackagePromotionCodeModelImpl)membershipPackagePromotionCode;

		Session session = null;

		try {
			session = openSession();

			if (membershipPackagePromotionCode.isNew()) {
				session.save(membershipPackagePromotionCode);

				membershipPackagePromotionCode.setNew(false);
			}
			else {
				session.merge(membershipPackagePromotionCode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!MembershipPackagePromotionCodeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((membershipPackagePromotionCodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGE_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackagePromotionCodeModelImpl.getOriginalMembershipPackage_id()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGE_ID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGE_ID,
					args);

				args = new Object[] {
						membershipPackagePromotionCodeModelImpl.getMembershipPackage_id()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGE_ID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGE_ID,
					args);
			}

			if ((membershipPackagePromotionCodeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROMOTIONCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackagePromotionCodeModelImpl.getOriginalPromotionCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROMOTIONCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROMOTIONCODE,
					args);

				args = new Object[] {
						membershipPackagePromotionCodeModelImpl.getPromotionCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROMOTIONCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROMOTIONCODE,
					args);
			}
		}

		EntityCacheUtil.putResult(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackagePromotionCodeImpl.class,
			membershipPackagePromotionCode.getPrimaryKey(),
			membershipPackagePromotionCode);

		return membershipPackagePromotionCode;
	}

	protected MembershipPackagePromotionCode toUnwrappedModel(
		MembershipPackagePromotionCode membershipPackagePromotionCode) {
		if (membershipPackagePromotionCode instanceof MembershipPackagePromotionCodeImpl) {
			return membershipPackagePromotionCode;
		}

		MembershipPackagePromotionCodeImpl membershipPackagePromotionCodeImpl = new MembershipPackagePromotionCodeImpl();

		membershipPackagePromotionCodeImpl.setNew(membershipPackagePromotionCode.isNew());
		membershipPackagePromotionCodeImpl.setPrimaryKey(membershipPackagePromotionCode.getPrimaryKey());

		membershipPackagePromotionCodeImpl.setPromotionCode_id(membershipPackagePromotionCode.getPromotionCode_id());
		membershipPackagePromotionCodeImpl.setMembershipPackage_id(membershipPackagePromotionCode.getMembershipPackage_id());
		membershipPackagePromotionCodeImpl.setPromotionCode(membershipPackagePromotionCode.getPromotionCode());
		membershipPackagePromotionCodeImpl.setPromotionFrom(membershipPackagePromotionCode.getPromotionFrom());
		membershipPackagePromotionCodeImpl.setPromotionTo(membershipPackagePromotionCode.getPromotionTo());
		membershipPackagePromotionCodeImpl.setDiscount(membershipPackagePromotionCode.getDiscount());
		membershipPackagePromotionCodeImpl.setExtra1(membershipPackagePromotionCode.getExtra1());
		membershipPackagePromotionCodeImpl.setExtra2(membershipPackagePromotionCode.getExtra2());
		membershipPackagePromotionCodeImpl.setExtra3(membershipPackagePromotionCode.getExtra3());
		membershipPackagePromotionCodeImpl.setExtra4(membershipPackagePromotionCode.getExtra4());
		membershipPackagePromotionCodeImpl.setExtra5(membershipPackagePromotionCode.getExtra5());

		return membershipPackagePromotionCodeImpl;
	}

	/**
	 * Returns the membership package promotion code with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership package promotion code
	 * @return the membership package promotion code
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a membership package promotion code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackagePromotionCode findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchMembershipPackagePromotionCodeException, SystemException {
		MembershipPackagePromotionCode membershipPackagePromotionCode = fetchByPrimaryKey(primaryKey);

		if (membershipPackagePromotionCode == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMembershipPackagePromotionCodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return membershipPackagePromotionCode;
	}

	/**
	 * Returns the membership package promotion code with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException} if it could not be found.
	 *
	 * @param promotionCode_id the primary key of the membership package promotion code
	 * @return the membership package promotion code
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackagePromotionCodeException if a membership package promotion code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackagePromotionCode findByPrimaryKey(
		long promotionCode_id)
		throws NoSuchMembershipPackagePromotionCodeException, SystemException {
		return findByPrimaryKey((Serializable)promotionCode_id);
	}

	/**
	 * Returns the membership package promotion code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership package promotion code
	 * @return the membership package promotion code, or <code>null</code> if a membership package promotion code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackagePromotionCode fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		MembershipPackagePromotionCode membershipPackagePromotionCode = (MembershipPackagePromotionCode)EntityCacheUtil.getResult(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
				MembershipPackagePromotionCodeImpl.class, primaryKey);

		if (membershipPackagePromotionCode == _nullMembershipPackagePromotionCode) {
			return null;
		}

		if (membershipPackagePromotionCode == null) {
			Session session = null;

			try {
				session = openSession();

				membershipPackagePromotionCode = (MembershipPackagePromotionCode)session.get(MembershipPackagePromotionCodeImpl.class,
						primaryKey);

				if (membershipPackagePromotionCode != null) {
					cacheResult(membershipPackagePromotionCode);
				}
				else {
					EntityCacheUtil.putResult(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
						MembershipPackagePromotionCodeImpl.class, primaryKey,
						_nullMembershipPackagePromotionCode);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MembershipPackagePromotionCodeModelImpl.ENTITY_CACHE_ENABLED,
					MembershipPackagePromotionCodeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return membershipPackagePromotionCode;
	}

	/**
	 * Returns the membership package promotion code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param promotionCode_id the primary key of the membership package promotion code
	 * @return the membership package promotion code, or <code>null</code> if a membership package promotion code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackagePromotionCode fetchByPrimaryKey(
		long promotionCode_id) throws SystemException {
		return fetchByPrimaryKey((Serializable)promotionCode_id);
	}

	/**
	 * Returns all the membership package promotion codes.
	 *
	 * @return the membership package promotion codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackagePromotionCode> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MembershipPackagePromotionCode> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<MembershipPackagePromotionCode> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<MembershipPackagePromotionCode> list = (List<MembershipPackagePromotionCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERSHIPPACKAGEPROMOTIONCODE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERSHIPPACKAGEPROMOTIONCODE;

				if (pagination) {
					sql = sql.concat(MembershipPackagePromotionCodeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MembershipPackagePromotionCode>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackagePromotionCode>(list);
				}
				else {
					list = (List<MembershipPackagePromotionCode>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the membership package promotion codes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MembershipPackagePromotionCode membershipPackagePromotionCode : findAll()) {
			remove(membershipPackagePromotionCode);
		}
	}

	/**
	 * Returns the number of membership package promotion codes.
	 *
	 * @return the number of membership package promotion codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MEMBERSHIPPACKAGEPROMOTIONCODE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the membership package promotion code persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MembershipPackagePromotionCode>> listenersList =
					new ArrayList<ModelListener<MembershipPackagePromotionCode>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MembershipPackagePromotionCode>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(MembershipPackagePromotionCodeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBERSHIPPACKAGEPROMOTIONCODE = "SELECT membershipPackagePromotionCode FROM MembershipPackagePromotionCode membershipPackagePromotionCode";
	private static final String _SQL_SELECT_MEMBERSHIPPACKAGEPROMOTIONCODE_WHERE =
		"SELECT membershipPackagePromotionCode FROM MembershipPackagePromotionCode membershipPackagePromotionCode WHERE ";
	private static final String _SQL_COUNT_MEMBERSHIPPACKAGEPROMOTIONCODE = "SELECT COUNT(membershipPackagePromotionCode) FROM MembershipPackagePromotionCode membershipPackagePromotionCode";
	private static final String _SQL_COUNT_MEMBERSHIPPACKAGEPROMOTIONCODE_WHERE = "SELECT COUNT(membershipPackagePromotionCode) FROM MembershipPackagePromotionCode membershipPackagePromotionCode WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "membershipPackagePromotionCode.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MembershipPackagePromotionCode exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MembershipPackagePromotionCode exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MembershipPackagePromotionCodePersistenceImpl.class);
	private static MembershipPackagePromotionCode _nullMembershipPackagePromotionCode =
		new MembershipPackagePromotionCodeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MembershipPackagePromotionCode> toCacheModel() {
				return _nullMembershipPackagePromotionCodeCacheModel;
			}
		};

	private static CacheModel<MembershipPackagePromotionCode> _nullMembershipPackagePromotionCodeCacheModel =
		new CacheModel<MembershipPackagePromotionCode>() {
			@Override
			public MembershipPackagePromotionCode toEntityModel() {
				return _nullMembershipPackagePromotionCode;
			}
		};
}