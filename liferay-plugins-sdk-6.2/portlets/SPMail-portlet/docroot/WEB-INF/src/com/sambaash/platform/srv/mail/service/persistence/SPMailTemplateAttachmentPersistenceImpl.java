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

package com.sambaash.platform.srv.mail.service.persistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException;
import com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment;
import com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentImpl;
import com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p mail template attachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailTemplateAttachmentPersistence
 * @see SPMailTemplateAttachmentUtil
 * @generated
 */
public class SPMailTemplateAttachmentPersistenceImpl extends BasePersistenceImpl<SPMailTemplateAttachment>
	implements SPMailTemplateAttachmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPMailTemplateAttachmentUtil} to access the s p mail template attachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPMailTemplateAttachmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTemplateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplateId",
			new String[] { Long.class.getName() },
			SPMailTemplateAttachmentModelImpl.TEMPLATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATEID = new FinderPath(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p mail template attachments where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @return the matching s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplateAttachment> findByTemplateId(long templateId)
		throws SystemException {
		return findByTemplateId(templateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail template attachments where templateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param start the lower bound of the range of s p mail template attachments
	 * @param end the upper bound of the range of s p mail template attachments (not inclusive)
	 * @return the range of matching s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplateAttachment> findByTemplateId(long templateId,
		int start, int end) throws SystemException {
		return findByTemplateId(templateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail template attachments where templateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param start the lower bound of the range of s p mail template attachments
	 * @param end the upper bound of the range of s p mail template attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplateAttachment> findByTemplateId(long templateId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID;
			finderArgs = new Object[] { templateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID;
			finderArgs = new Object[] { templateId, start, end, orderByComparator };
		}

		List<SPMailTemplateAttachment> list = (List<SPMailTemplateAttachment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailTemplateAttachment spMailTemplateAttachment : list) {
				if ((templateId != spMailTemplateAttachment.getTemplateId())) {
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

			query.append(_SQL_SELECT_SPMAILTEMPLATEATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailTemplateAttachmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

				if (!pagination) {
					list = (List<SPMailTemplateAttachment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailTemplateAttachment>(list);
				}
				else {
					list = (List<SPMailTemplateAttachment>)QueryUtil.list(q,
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
	 * Returns the first s p mail template attachment in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template attachment
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment findByTemplateId_First(long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateAttachmentException, SystemException {
		SPMailTemplateAttachment spMailTemplateAttachment = fetchByTemplateId_First(templateId,
				orderByComparator);

		if (spMailTemplateAttachment != null) {
			return spMailTemplateAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateAttachmentException(msg.toString());
	}

	/**
	 * Returns the first s p mail template attachment in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment fetchByTemplateId_First(long templateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailTemplateAttachment> list = findByTemplateId(templateId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail template attachment in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template attachment
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment findByTemplateId_Last(long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateAttachmentException, SystemException {
		SPMailTemplateAttachment spMailTemplateAttachment = fetchByTemplateId_Last(templateId,
				orderByComparator);

		if (spMailTemplateAttachment != null) {
			return spMailTemplateAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateAttachmentException(msg.toString());
	}

	/**
	 * Returns the last s p mail template attachment in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment fetchByTemplateId_Last(long templateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTemplateId(templateId);

		if (count == 0) {
			return null;
		}

		List<SPMailTemplateAttachment> list = findByTemplateId(templateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail template attachments before and after the current s p mail template attachment in the ordered set where templateId = &#63;.
	 *
	 * @param spTemplateAttachmentId the primary key of the current s p mail template attachment
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail template attachment
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment[] findByTemplateId_PrevAndNext(
		long spTemplateAttachmentId, long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateAttachmentException, SystemException {
		SPMailTemplateAttachment spMailTemplateAttachment = findByPrimaryKey(spTemplateAttachmentId);

		Session session = null;

		try {
			session = openSession();

			SPMailTemplateAttachment[] array = new SPMailTemplateAttachmentImpl[3];

			array[0] = getByTemplateId_PrevAndNext(session,
					spMailTemplateAttachment, templateId, orderByComparator,
					true);

			array[1] = spMailTemplateAttachment;

			array[2] = getByTemplateId_PrevAndNext(session,
					spMailTemplateAttachment, templateId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailTemplateAttachment getByTemplateId_PrevAndNext(
		Session session, SPMailTemplateAttachment spMailTemplateAttachment,
		long templateId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILTEMPLATEATTACHMENT_WHERE);

		query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

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
			query.append(SPMailTemplateAttachmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(templateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailTemplateAttachment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailTemplateAttachment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail template attachments where templateId = &#63; from the database.
	 *
	 * @param templateId the template ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplateId(long templateId) throws SystemException {
		for (SPMailTemplateAttachment spMailTemplateAttachment : findByTemplateId(
				templateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailTemplateAttachment);
		}
	}

	/**
	 * Returns the number of s p mail template attachments where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @return the number of matching s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplateId(long templateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATEID;

		Object[] finderArgs = new Object[] { templateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPMAILTEMPLATEATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

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

	private static final String _FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2 = "spMailTemplateAttachment.templateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEENTRYID =
		new FinderPath(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfileEntryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID =
		new FinderPath(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfileEntryId",
			new String[] { Long.class.getName() },
			SPMailTemplateAttachmentModelImpl.FILEENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILEENTRYID = new FinderPath(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfileEntryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p mail template attachments where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplateAttachment> findByfileEntryId(long fileEntryId)
		throws SystemException {
		return findByfileEntryId(fileEntryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail template attachments where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of s p mail template attachments
	 * @param end the upper bound of the range of s p mail template attachments (not inclusive)
	 * @return the range of matching s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplateAttachment> findByfileEntryId(long fileEntryId,
		int start, int end) throws SystemException {
		return findByfileEntryId(fileEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail template attachments where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of s p mail template attachments
	 * @param end the upper bound of the range of s p mail template attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplateAttachment> findByfileEntryId(long fileEntryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID;
			finderArgs = new Object[] { fileEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEENTRYID;
			finderArgs = new Object[] { fileEntryId, start, end, orderByComparator };
		}

		List<SPMailTemplateAttachment> list = (List<SPMailTemplateAttachment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailTemplateAttachment spMailTemplateAttachment : list) {
				if ((fileEntryId != spMailTemplateAttachment.getFileEntryId())) {
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

			query.append(_SQL_SELECT_SPMAILTEMPLATEATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailTemplateAttachmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileEntryId);

				if (!pagination) {
					list = (List<SPMailTemplateAttachment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailTemplateAttachment>(list);
				}
				else {
					list = (List<SPMailTemplateAttachment>)QueryUtil.list(q,
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
	 * Returns the first s p mail template attachment in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template attachment
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment findByfileEntryId_First(long fileEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateAttachmentException, SystemException {
		SPMailTemplateAttachment spMailTemplateAttachment = fetchByfileEntryId_First(fileEntryId,
				orderByComparator);

		if (spMailTemplateAttachment != null) {
			return spMailTemplateAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileEntryId=");
		msg.append(fileEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateAttachmentException(msg.toString());
	}

	/**
	 * Returns the first s p mail template attachment in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment fetchByfileEntryId_First(long fileEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailTemplateAttachment> list = findByfileEntryId(fileEntryId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail template attachment in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template attachment
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment findByfileEntryId_Last(long fileEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateAttachmentException, SystemException {
		SPMailTemplateAttachment spMailTemplateAttachment = fetchByfileEntryId_Last(fileEntryId,
				orderByComparator);

		if (spMailTemplateAttachment != null) {
			return spMailTemplateAttachment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileEntryId=");
		msg.append(fileEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateAttachmentException(msg.toString());
	}

	/**
	 * Returns the last s p mail template attachment in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment fetchByfileEntryId_Last(long fileEntryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByfileEntryId(fileEntryId);

		if (count == 0) {
			return null;
		}

		List<SPMailTemplateAttachment> list = findByfileEntryId(fileEntryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail template attachments before and after the current s p mail template attachment in the ordered set where fileEntryId = &#63;.
	 *
	 * @param spTemplateAttachmentId the primary key of the current s p mail template attachment
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail template attachment
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment[] findByfileEntryId_PrevAndNext(
		long spTemplateAttachmentId, long fileEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateAttachmentException, SystemException {
		SPMailTemplateAttachment spMailTemplateAttachment = findByPrimaryKey(spTemplateAttachmentId);

		Session session = null;

		try {
			session = openSession();

			SPMailTemplateAttachment[] array = new SPMailTemplateAttachmentImpl[3];

			array[0] = getByfileEntryId_PrevAndNext(session,
					spMailTemplateAttachment, fileEntryId, orderByComparator,
					true);

			array[1] = spMailTemplateAttachment;

			array[2] = getByfileEntryId_PrevAndNext(session,
					spMailTemplateAttachment, fileEntryId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailTemplateAttachment getByfileEntryId_PrevAndNext(
		Session session, SPMailTemplateAttachment spMailTemplateAttachment,
		long fileEntryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILTEMPLATEATTACHMENT_WHERE);

		query.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2);

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
			query.append(SPMailTemplateAttachmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fileEntryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailTemplateAttachment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailTemplateAttachment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail template attachments where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByfileEntryId(long fileEntryId) throws SystemException {
		for (SPMailTemplateAttachment spMailTemplateAttachment : findByfileEntryId(
				fileEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailTemplateAttachment);
		}
	}

	/**
	 * Returns the number of s p mail template attachments where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfileEntryId(long fileEntryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILEENTRYID;

		Object[] finderArgs = new Object[] { fileEntryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPMAILTEMPLATEATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileEntryId);

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

	private static final String _FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2 = "spMailTemplateAttachment.fileEntryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEIDFILEENTRYID =
		new FinderPath(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTemplateIdFileEntryId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEIDFILEENTRYID =
		new FinderPath(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTemplateIdFileEntryId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPMailTemplateAttachmentModelImpl.TEMPLATEID_COLUMN_BITMASK |
			SPMailTemplateAttachmentModelImpl.FILEENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATEIDFILEENTRYID = new FinderPath(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTemplateIdFileEntryId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p mail template attachments where templateId = &#63; and fileEntryId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param fileEntryId the file entry ID
	 * @return the matching s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplateAttachment> findByTemplateIdFileEntryId(
		long templateId, long fileEntryId) throws SystemException {
		return findByTemplateIdFileEntryId(templateId, fileEntryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail template attachments where templateId = &#63; and fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of s p mail template attachments
	 * @param end the upper bound of the range of s p mail template attachments (not inclusive)
	 * @return the range of matching s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplateAttachment> findByTemplateIdFileEntryId(
		long templateId, long fileEntryId, int start, int end)
		throws SystemException {
		return findByTemplateIdFileEntryId(templateId, fileEntryId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the s p mail template attachments where templateId = &#63; and fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of s p mail template attachments
	 * @param end the upper bound of the range of s p mail template attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplateAttachment> findByTemplateIdFileEntryId(
		long templateId, long fileEntryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEIDFILEENTRYID;
			finderArgs = new Object[] { templateId, fileEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEIDFILEENTRYID;
			finderArgs = new Object[] {
					templateId, fileEntryId,
					
					start, end, orderByComparator
				};
		}

		List<SPMailTemplateAttachment> list = (List<SPMailTemplateAttachment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailTemplateAttachment spMailTemplateAttachment : list) {
				if ((templateId != spMailTemplateAttachment.getTemplateId()) ||
						(fileEntryId != spMailTemplateAttachment.getFileEntryId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SPMAILTEMPLATEATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEIDFILEENTRYID_TEMPLATEID_2);

			query.append(_FINDER_COLUMN_TEMPLATEIDFILEENTRYID_FILEENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailTemplateAttachmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

				qPos.add(fileEntryId);

				if (!pagination) {
					list = (List<SPMailTemplateAttachment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailTemplateAttachment>(list);
				}
				else {
					list = (List<SPMailTemplateAttachment>)QueryUtil.list(q,
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
	 * Returns the first s p mail template attachment in the ordered set where templateId = &#63; and fileEntryId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template attachment
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment findByTemplateIdFileEntryId_First(
		long templateId, long fileEntryId, OrderByComparator orderByComparator)
		throws NoSuchTemplateAttachmentException, SystemException {
		SPMailTemplateAttachment spMailTemplateAttachment = fetchByTemplateIdFileEntryId_First(templateId,
				fileEntryId, orderByComparator);

		if (spMailTemplateAttachment != null) {
			return spMailTemplateAttachment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(", fileEntryId=");
		msg.append(fileEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateAttachmentException(msg.toString());
	}

	/**
	 * Returns the first s p mail template attachment in the ordered set where templateId = &#63; and fileEntryId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment fetchByTemplateIdFileEntryId_First(
		long templateId, long fileEntryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPMailTemplateAttachment> list = findByTemplateIdFileEntryId(templateId,
				fileEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail template attachment in the ordered set where templateId = &#63; and fileEntryId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template attachment
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a matching s p mail template attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment findByTemplateIdFileEntryId_Last(
		long templateId, long fileEntryId, OrderByComparator orderByComparator)
		throws NoSuchTemplateAttachmentException, SystemException {
		SPMailTemplateAttachment spMailTemplateAttachment = fetchByTemplateIdFileEntryId_Last(templateId,
				fileEntryId, orderByComparator);

		if (spMailTemplateAttachment != null) {
			return spMailTemplateAttachment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(", fileEntryId=");
		msg.append(fileEntryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateAttachmentException(msg.toString());
	}

	/**
	 * Returns the last s p mail template attachment in the ordered set where templateId = &#63; and fileEntryId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template attachment, or <code>null</code> if a matching s p mail template attachment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment fetchByTemplateIdFileEntryId_Last(
		long templateId, long fileEntryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTemplateIdFileEntryId(templateId, fileEntryId);

		if (count == 0) {
			return null;
		}

		List<SPMailTemplateAttachment> list = findByTemplateIdFileEntryId(templateId,
				fileEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail template attachments before and after the current s p mail template attachment in the ordered set where templateId = &#63; and fileEntryId = &#63;.
	 *
	 * @param spTemplateAttachmentId the primary key of the current s p mail template attachment
	 * @param templateId the template ID
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail template attachment
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment[] findByTemplateIdFileEntryId_PrevAndNext(
		long spTemplateAttachmentId, long templateId, long fileEntryId,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateAttachmentException, SystemException {
		SPMailTemplateAttachment spMailTemplateAttachment = findByPrimaryKey(spTemplateAttachmentId);

		Session session = null;

		try {
			session = openSession();

			SPMailTemplateAttachment[] array = new SPMailTemplateAttachmentImpl[3];

			array[0] = getByTemplateIdFileEntryId_PrevAndNext(session,
					spMailTemplateAttachment, templateId, fileEntryId,
					orderByComparator, true);

			array[1] = spMailTemplateAttachment;

			array[2] = getByTemplateIdFileEntryId_PrevAndNext(session,
					spMailTemplateAttachment, templateId, fileEntryId,
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

	protected SPMailTemplateAttachment getByTemplateIdFileEntryId_PrevAndNext(
		Session session, SPMailTemplateAttachment spMailTemplateAttachment,
		long templateId, long fileEntryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILTEMPLATEATTACHMENT_WHERE);

		query.append(_FINDER_COLUMN_TEMPLATEIDFILEENTRYID_TEMPLATEID_2);

		query.append(_FINDER_COLUMN_TEMPLATEIDFILEENTRYID_FILEENTRYID_2);

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
			query.append(SPMailTemplateAttachmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(templateId);

		qPos.add(fileEntryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailTemplateAttachment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailTemplateAttachment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail template attachments where templateId = &#63; and fileEntryId = &#63; from the database.
	 *
	 * @param templateId the template ID
	 * @param fileEntryId the file entry ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplateIdFileEntryId(long templateId, long fileEntryId)
		throws SystemException {
		for (SPMailTemplateAttachment spMailTemplateAttachment : findByTemplateIdFileEntryId(
				templateId, fileEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(spMailTemplateAttachment);
		}
	}

	/**
	 * Returns the number of s p mail template attachments where templateId = &#63; and fileEntryId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param fileEntryId the file entry ID
	 * @return the number of matching s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplateIdFileEntryId(long templateId, long fileEntryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATEIDFILEENTRYID;

		Object[] finderArgs = new Object[] { templateId, fileEntryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILTEMPLATEATTACHMENT_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEIDFILEENTRYID_TEMPLATEID_2);

			query.append(_FINDER_COLUMN_TEMPLATEIDFILEENTRYID_FILEENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

				qPos.add(fileEntryId);

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

	private static final String _FINDER_COLUMN_TEMPLATEIDFILEENTRYID_TEMPLATEID_2 =
		"spMailTemplateAttachment.templateId = ? AND ";
	private static final String _FINDER_COLUMN_TEMPLATEIDFILEENTRYID_FILEENTRYID_2 =
		"spMailTemplateAttachment.fileEntryId = ?";

	public SPMailTemplateAttachmentPersistenceImpl() {
		setModelClass(SPMailTemplateAttachment.class);
	}

	/**
	 * Caches the s p mail template attachment in the entity cache if it is enabled.
	 *
	 * @param spMailTemplateAttachment the s p mail template attachment
	 */
	@Override
	public void cacheResult(SPMailTemplateAttachment spMailTemplateAttachment) {
		EntityCacheUtil.putResult(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentImpl.class,
			spMailTemplateAttachment.getPrimaryKey(), spMailTemplateAttachment);

		spMailTemplateAttachment.resetOriginalValues();
	}

	/**
	 * Caches the s p mail template attachments in the entity cache if it is enabled.
	 *
	 * @param spMailTemplateAttachments the s p mail template attachments
	 */
	@Override
	public void cacheResult(
		List<SPMailTemplateAttachment> spMailTemplateAttachments) {
		for (SPMailTemplateAttachment spMailTemplateAttachment : spMailTemplateAttachments) {
			if (EntityCacheUtil.getResult(
						SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
						SPMailTemplateAttachmentImpl.class,
						spMailTemplateAttachment.getPrimaryKey()) == null) {
				cacheResult(spMailTemplateAttachment);
			}
			else {
				spMailTemplateAttachment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p mail template attachments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPMailTemplateAttachmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPMailTemplateAttachmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p mail template attachment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPMailTemplateAttachment spMailTemplateAttachment) {
		EntityCacheUtil.removeResult(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentImpl.class,
			spMailTemplateAttachment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<SPMailTemplateAttachment> spMailTemplateAttachments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPMailTemplateAttachment spMailTemplateAttachment : spMailTemplateAttachments) {
			EntityCacheUtil.removeResult(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
				SPMailTemplateAttachmentImpl.class,
				spMailTemplateAttachment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p mail template attachment with the primary key. Does not add the s p mail template attachment to the database.
	 *
	 * @param spTemplateAttachmentId the primary key for the new s p mail template attachment
	 * @return the new s p mail template attachment
	 */
	@Override
	public SPMailTemplateAttachment create(long spTemplateAttachmentId) {
		SPMailTemplateAttachment spMailTemplateAttachment = new SPMailTemplateAttachmentImpl();

		spMailTemplateAttachment.setNew(true);
		spMailTemplateAttachment.setPrimaryKey(spTemplateAttachmentId);

		return spMailTemplateAttachment;
	}

	/**
	 * Removes the s p mail template attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spTemplateAttachmentId the primary key of the s p mail template attachment
	 * @return the s p mail template attachment that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment remove(long spTemplateAttachmentId)
		throws NoSuchTemplateAttachmentException, SystemException {
		return remove((Serializable)spTemplateAttachmentId);
	}

	/**
	 * Removes the s p mail template attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p mail template attachment
	 * @return the s p mail template attachment that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment remove(Serializable primaryKey)
		throws NoSuchTemplateAttachmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPMailTemplateAttachment spMailTemplateAttachment = (SPMailTemplateAttachment)session.get(SPMailTemplateAttachmentImpl.class,
					primaryKey);

			if (spMailTemplateAttachment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTemplateAttachmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spMailTemplateAttachment);
		}
		catch (NoSuchTemplateAttachmentException nsee) {
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
	protected SPMailTemplateAttachment removeImpl(
		SPMailTemplateAttachment spMailTemplateAttachment)
		throws SystemException {
		spMailTemplateAttachment = toUnwrappedModel(spMailTemplateAttachment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spMailTemplateAttachment)) {
				spMailTemplateAttachment = (SPMailTemplateAttachment)session.get(SPMailTemplateAttachmentImpl.class,
						spMailTemplateAttachment.getPrimaryKeyObj());
			}

			if (spMailTemplateAttachment != null) {
				session.delete(spMailTemplateAttachment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spMailTemplateAttachment != null) {
			clearCache(spMailTemplateAttachment);
		}

		return spMailTemplateAttachment;
	}

	@Override
	public SPMailTemplateAttachment updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment spMailTemplateAttachment)
		throws SystemException {
		spMailTemplateAttachment = toUnwrappedModel(spMailTemplateAttachment);

		boolean isNew = spMailTemplateAttachment.isNew();

		SPMailTemplateAttachmentModelImpl spMailTemplateAttachmentModelImpl = (SPMailTemplateAttachmentModelImpl)spMailTemplateAttachment;

		Session session = null;

		try {
			session = openSession();

			if (spMailTemplateAttachment.isNew()) {
				session.save(spMailTemplateAttachment);

				spMailTemplateAttachment.setNew(false);
			}
			else {
				session.merge(spMailTemplateAttachment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPMailTemplateAttachmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spMailTemplateAttachmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailTemplateAttachmentModelImpl.getOriginalTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);

				args = new Object[] {
						spMailTemplateAttachmentModelImpl.getTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);
			}

			if ((spMailTemplateAttachmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailTemplateAttachmentModelImpl.getOriginalFileEntryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEENTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID,
					args);

				args = new Object[] {
						spMailTemplateAttachmentModelImpl.getFileEntryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEENTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID,
					args);
			}

			if ((spMailTemplateAttachmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEIDFILEENTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailTemplateAttachmentModelImpl.getOriginalTemplateId(),
						spMailTemplateAttachmentModelImpl.getOriginalFileEntryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEIDFILEENTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEIDFILEENTRYID,
					args);

				args = new Object[] {
						spMailTemplateAttachmentModelImpl.getTemplateId(),
						spMailTemplateAttachmentModelImpl.getFileEntryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEIDFILEENTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEIDFILEENTRYID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateAttachmentImpl.class,
			spMailTemplateAttachment.getPrimaryKey(), spMailTemplateAttachment);

		return spMailTemplateAttachment;
	}

	protected SPMailTemplateAttachment toUnwrappedModel(
		SPMailTemplateAttachment spMailTemplateAttachment) {
		if (spMailTemplateAttachment instanceof SPMailTemplateAttachmentImpl) {
			return spMailTemplateAttachment;
		}

		SPMailTemplateAttachmentImpl spMailTemplateAttachmentImpl = new SPMailTemplateAttachmentImpl();

		spMailTemplateAttachmentImpl.setNew(spMailTemplateAttachment.isNew());
		spMailTemplateAttachmentImpl.setPrimaryKey(spMailTemplateAttachment.getPrimaryKey());

		spMailTemplateAttachmentImpl.setSpTemplateAttachmentId(spMailTemplateAttachment.getSpTemplateAttachmentId());
		spMailTemplateAttachmentImpl.setTemplateId(spMailTemplateAttachment.getTemplateId());
		spMailTemplateAttachmentImpl.setRsvpId(spMailTemplateAttachment.getRsvpId());
		spMailTemplateAttachmentImpl.setFileEntryId(spMailTemplateAttachment.getFileEntryId());

		return spMailTemplateAttachmentImpl;
	}

	/**
	 * Returns the s p mail template attachment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail template attachment
	 * @return the s p mail template attachment
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTemplateAttachmentException, SystemException {
		SPMailTemplateAttachment spMailTemplateAttachment = fetchByPrimaryKey(primaryKey);

		if (spMailTemplateAttachment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTemplateAttachmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spMailTemplateAttachment;
	}

	/**
	 * Returns the s p mail template attachment with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException} if it could not be found.
	 *
	 * @param spTemplateAttachmentId the primary key of the s p mail template attachment
	 * @return the s p mail template attachment
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateAttachmentException if a s p mail template attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment findByPrimaryKey(
		long spTemplateAttachmentId)
		throws NoSuchTemplateAttachmentException, SystemException {
		return findByPrimaryKey((Serializable)spTemplateAttachmentId);
	}

	/**
	 * Returns the s p mail template attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail template attachment
	 * @return the s p mail template attachment, or <code>null</code> if a s p mail template attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPMailTemplateAttachment spMailTemplateAttachment = (SPMailTemplateAttachment)EntityCacheUtil.getResult(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
				SPMailTemplateAttachmentImpl.class, primaryKey);

		if (spMailTemplateAttachment == _nullSPMailTemplateAttachment) {
			return null;
		}

		if (spMailTemplateAttachment == null) {
			Session session = null;

			try {
				session = openSession();

				spMailTemplateAttachment = (SPMailTemplateAttachment)session.get(SPMailTemplateAttachmentImpl.class,
						primaryKey);

				if (spMailTemplateAttachment != null) {
					cacheResult(spMailTemplateAttachment);
				}
				else {
					EntityCacheUtil.putResult(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
						SPMailTemplateAttachmentImpl.class, primaryKey,
						_nullSPMailTemplateAttachment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPMailTemplateAttachmentModelImpl.ENTITY_CACHE_ENABLED,
					SPMailTemplateAttachmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spMailTemplateAttachment;
	}

	/**
	 * Returns the s p mail template attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spTemplateAttachmentId the primary key of the s p mail template attachment
	 * @return the s p mail template attachment, or <code>null</code> if a s p mail template attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplateAttachment fetchByPrimaryKey(
		long spTemplateAttachmentId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spTemplateAttachmentId);
	}

	/**
	 * Returns all the s p mail template attachments.
	 *
	 * @return the s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplateAttachment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail template attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail template attachments
	 * @param end the upper bound of the range of s p mail template attachments (not inclusive)
	 * @return the range of s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplateAttachment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail template attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail template attachments
	 * @param end the upper bound of the range of s p mail template attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p mail template attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplateAttachment> findAll(int start, int end,
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

		List<SPMailTemplateAttachment> list = (List<SPMailTemplateAttachment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPMAILTEMPLATEATTACHMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPMAILTEMPLATEATTACHMENT;

				if (pagination) {
					sql = sql.concat(SPMailTemplateAttachmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPMailTemplateAttachment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailTemplateAttachment>(list);
				}
				else {
					list = (List<SPMailTemplateAttachment>)QueryUtil.list(q,
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
	 * Removes all the s p mail template attachments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPMailTemplateAttachment spMailTemplateAttachment : findAll()) {
			remove(spMailTemplateAttachment);
		}
	}

	/**
	 * Returns the number of s p mail template attachments.
	 *
	 * @return the number of s p mail template attachments
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

				Query q = session.createQuery(_SQL_COUNT_SPMAILTEMPLATEATTACHMENT);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the s p mail template attachment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.mail.model.SPMailTemplateAttachment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPMailTemplateAttachment>> listenersList = new ArrayList<ModelListener<SPMailTemplateAttachment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPMailTemplateAttachment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPMailTemplateAttachmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPMAILTEMPLATEATTACHMENT = "SELECT spMailTemplateAttachment FROM SPMailTemplateAttachment spMailTemplateAttachment";
	private static final String _SQL_SELECT_SPMAILTEMPLATEATTACHMENT_WHERE = "SELECT spMailTemplateAttachment FROM SPMailTemplateAttachment spMailTemplateAttachment WHERE ";
	private static final String _SQL_COUNT_SPMAILTEMPLATEATTACHMENT = "SELECT COUNT(spMailTemplateAttachment) FROM SPMailTemplateAttachment spMailTemplateAttachment";
	private static final String _SQL_COUNT_SPMAILTEMPLATEATTACHMENT_WHERE = "SELECT COUNT(spMailTemplateAttachment) FROM SPMailTemplateAttachment spMailTemplateAttachment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spMailTemplateAttachment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPMailTemplateAttachment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPMailTemplateAttachment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPMailTemplateAttachmentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"spTemplateAttachmentId"
			});
	private static SPMailTemplateAttachment _nullSPMailTemplateAttachment = new SPMailTemplateAttachmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPMailTemplateAttachment> toCacheModel() {
				return _nullSPMailTemplateAttachmentCacheModel;
			}
		};

	private static CacheModel<SPMailTemplateAttachment> _nullSPMailTemplateAttachmentCacheModel =
		new CacheModel<SPMailTemplateAttachment>() {
			@Override
			public SPMailTemplateAttachment toEntityModel() {
				return _nullSPMailTemplateAttachment;
			}
		};
}