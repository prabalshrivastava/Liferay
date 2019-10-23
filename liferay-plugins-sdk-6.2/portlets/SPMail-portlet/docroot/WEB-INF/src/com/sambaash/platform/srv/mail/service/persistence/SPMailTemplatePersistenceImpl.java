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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.mail.NoSuchTemplateException;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.model.impl.SPMailTemplateImpl;
import com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p mail template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailTemplatePersistence
 * @see SPMailTemplateUtil
 * @generated
 */
public class SPMailTemplatePersistenceImpl extends BasePersistenceImpl<SPMailTemplate>
	implements SPMailTemplatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPMailTemplateUtil} to access the s p mail template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPMailTemplateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME =
		new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProductTypeIdAndSubProductTypeIdAndTemplateName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME =
		new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProductTypeIdAndSubProductTypeIdAndTemplateName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			SPMailTemplateModelImpl.PRODUCTTYPEID_COLUMN_BITMASK |
			SPMailTemplateModelImpl.SUBPRODUCTTYPEID_COLUMN_BITMASK |
			SPMailTemplateModelImpl.TEMPLATENAME_COLUMN_BITMASK |
			SPMailTemplateModelImpl.PARENTTEMPALTEID_COLUMN_BITMASK |
			SPMailTemplateModelImpl.VERSIONNUMBER_COLUMN_BITMASK |
			SPMailTemplateModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME =
		new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProductTypeIdAndSubProductTypeIdAndTemplateName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the s p mail templates where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @return the matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findByProductTypeIdAndSubProductTypeIdAndTemplateName(
		long productTypeId, long subProductTypeId, String templateName)
		throws SystemException {
		return findByProductTypeIdAndSubProductTypeIdAndTemplateName(productTypeId,
			subProductTypeId, templateName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail templates where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @param start the lower bound of the range of s p mail templates
	 * @param end the upper bound of the range of s p mail templates (not inclusive)
	 * @return the range of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findByProductTypeIdAndSubProductTypeIdAndTemplateName(
		long productTypeId, long subProductTypeId, String templateName,
		int start, int end) throws SystemException {
		return findByProductTypeIdAndSubProductTypeIdAndTemplateName(productTypeId,
			subProductTypeId, templateName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail templates where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @param start the lower bound of the range of s p mail templates
	 * @param end the upper bound of the range of s p mail templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findByProductTypeIdAndSubProductTypeIdAndTemplateName(
		long productTypeId, long subProductTypeId, String templateName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME;
			finderArgs = new Object[] {
					productTypeId, subProductTypeId, templateName
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME;
			finderArgs = new Object[] {
					productTypeId, subProductTypeId, templateName,
					
					start, end, orderByComparator
				};
		}

		List<SPMailTemplate> list = (List<SPMailTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailTemplate spMailTemplate : list) {
				if ((productTypeId != spMailTemplate.getProductTypeId()) ||
						(subProductTypeId != spMailTemplate.getSubProductTypeId()) ||
						!Validator.equals(templateName,
							spMailTemplate.getTemplateName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SPMAILTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_PRODUCTTYPEID_2);

			query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_SUBPRODUCTTYPEID_2);

			boolean bindTemplateName = false;

			if (templateName == null) {
				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_TEMPLATENAME_1);
			}
			else if (templateName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_TEMPLATENAME_3);
			}
			else {
				bindTemplateName = true;

				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_TEMPLATENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productTypeId);

				qPos.add(subProductTypeId);

				if (bindTemplateName) {
					qPos.add(templateName);
				}

				if (!pagination) {
					list = (List<SPMailTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailTemplate>(list);
				}
				else {
					list = (List<SPMailTemplate>)QueryUtil.list(q,
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
	 * Returns the first s p mail template in the ordered set where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate findByProductTypeIdAndSubProductTypeIdAndTemplateName_First(
		long productTypeId, long subProductTypeId, String templateName,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = fetchByProductTypeIdAndSubProductTypeIdAndTemplateName_First(productTypeId,
				subProductTypeId, templateName, orderByComparator);

		if (spMailTemplate != null) {
			return spMailTemplate;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productTypeId=");
		msg.append(productTypeId);

		msg.append(", subProductTypeId=");
		msg.append(subProductTypeId);

		msg.append(", templateName=");
		msg.append(templateName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateException(msg.toString());
	}

	/**
	 * Returns the first s p mail template in the ordered set where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchByProductTypeIdAndSubProductTypeIdAndTemplateName_First(
		long productTypeId, long subProductTypeId, String templateName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailTemplate> list = findByProductTypeIdAndSubProductTypeIdAndTemplateName(productTypeId,
				subProductTypeId, templateName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail template in the ordered set where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate findByProductTypeIdAndSubProductTypeIdAndTemplateName_Last(
		long productTypeId, long subProductTypeId, String templateName,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = fetchByProductTypeIdAndSubProductTypeIdAndTemplateName_Last(productTypeId,
				subProductTypeId, templateName, orderByComparator);

		if (spMailTemplate != null) {
			return spMailTemplate;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productTypeId=");
		msg.append(productTypeId);

		msg.append(", subProductTypeId=");
		msg.append(subProductTypeId);

		msg.append(", templateName=");
		msg.append(templateName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateException(msg.toString());
	}

	/**
	 * Returns the last s p mail template in the ordered set where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchByProductTypeIdAndSubProductTypeIdAndTemplateName_Last(
		long productTypeId, long subProductTypeId, String templateName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProductTypeIdAndSubProductTypeIdAndTemplateName(productTypeId,
				subProductTypeId, templateName);

		if (count == 0) {
			return null;
		}

		List<SPMailTemplate> list = findByProductTypeIdAndSubProductTypeIdAndTemplateName(productTypeId,
				subProductTypeId, templateName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail templates before and after the current s p mail template in the ordered set where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	 *
	 * @param spMailTemplateId the primary key of the current s p mail template
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate[] findByProductTypeIdAndSubProductTypeIdAndTemplateName_PrevAndNext(
		long spMailTemplateId, long productTypeId, long subProductTypeId,
		String templateName, OrderByComparator orderByComparator)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = findByPrimaryKey(spMailTemplateId);

		Session session = null;

		try {
			session = openSession();

			SPMailTemplate[] array = new SPMailTemplateImpl[3];

			array[0] = getByProductTypeIdAndSubProductTypeIdAndTemplateName_PrevAndNext(session,
					spMailTemplate, productTypeId, subProductTypeId,
					templateName, orderByComparator, true);

			array[1] = spMailTemplate;

			array[2] = getByProductTypeIdAndSubProductTypeIdAndTemplateName_PrevAndNext(session,
					spMailTemplate, productTypeId, subProductTypeId,
					templateName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailTemplate getByProductTypeIdAndSubProductTypeIdAndTemplateName_PrevAndNext(
		Session session, SPMailTemplate spMailTemplate, long productTypeId,
		long subProductTypeId, String templateName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILTEMPLATE_WHERE);

		query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_PRODUCTTYPEID_2);

		query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_SUBPRODUCTTYPEID_2);

		boolean bindTemplateName = false;

		if (templateName == null) {
			query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_TEMPLATENAME_1);
		}
		else if (templateName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_TEMPLATENAME_3);
		}
		else {
			bindTemplateName = true;

			query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_TEMPLATENAME_2);
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
			query.append(SPMailTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(productTypeId);

		qPos.add(subProductTypeId);

		if (bindTemplateName) {
			qPos.add(templateName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail templates where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63; from the database.
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProductTypeIdAndSubProductTypeIdAndTemplateName(
		long productTypeId, long subProductTypeId, String templateName)
		throws SystemException {
		for (SPMailTemplate spMailTemplate : findByProductTypeIdAndSubProductTypeIdAndTemplateName(
				productTypeId, subProductTypeId, templateName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailTemplate);
		}
	}

	/**
	 * Returns the number of s p mail templates where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63;.
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @return the number of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProductTypeIdAndSubProductTypeIdAndTemplateName(
		long productTypeId, long subProductTypeId, String templateName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME;

		Object[] finderArgs = new Object[] {
				productTypeId, subProductTypeId, templateName
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPMAILTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_PRODUCTTYPEID_2);

			query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_SUBPRODUCTTYPEID_2);

			boolean bindTemplateName = false;

			if (templateName == null) {
				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_TEMPLATENAME_1);
			}
			else if (templateName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_TEMPLATENAME_3);
			}
			else {
				bindTemplateName = true;

				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_TEMPLATENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productTypeId);

				qPos.add(subProductTypeId);

				if (bindTemplateName) {
					qPos.add(templateName);
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

	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_PRODUCTTYPEID_2 =
		"spMailTemplate.productTypeId = ? AND ";
	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_SUBPRODUCTTYPEID_2 =
		"spMailTemplate.subProductTypeId = ? AND ";
	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_TEMPLATENAME_1 =
		"spMailTemplate.templateName IS NULL AND spMailTemplate.status=0";
	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_TEMPLATENAME_2 =
		"spMailTemplate.templateName = ? AND spMailTemplate.status=0";
	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME_TEMPLATENAME_3 =
		"(spMailTemplate.templateName IS NULL OR spMailTemplate.templateName = '') AND spMailTemplate.status=0";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATENAME =
		new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTemplateName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATENAME =
		new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplateName",
			new String[] { String.class.getName() },
			SPMailTemplateModelImpl.TEMPLATENAME_COLUMN_BITMASK |
			SPMailTemplateModelImpl.PARENTTEMPALTEID_COLUMN_BITMASK |
			SPMailTemplateModelImpl.VERSIONNUMBER_COLUMN_BITMASK |
			SPMailTemplateModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATENAME = new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplateName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p mail templates where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @return the matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findByTemplateName(String templateName)
		throws SystemException {
		return findByTemplateName(templateName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail templates where templateName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateName the template name
	 * @param start the lower bound of the range of s p mail templates
	 * @param end the upper bound of the range of s p mail templates (not inclusive)
	 * @return the range of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findByTemplateName(String templateName,
		int start, int end) throws SystemException {
		return findByTemplateName(templateName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail templates where templateName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateName the template name
	 * @param start the lower bound of the range of s p mail templates
	 * @param end the upper bound of the range of s p mail templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findByTemplateName(String templateName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATENAME;
			finderArgs = new Object[] { templateName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATENAME;
			finderArgs = new Object[] {
					templateName,
					
					start, end, orderByComparator
				};
		}

		List<SPMailTemplate> list = (List<SPMailTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailTemplate spMailTemplate : list) {
				if (!Validator.equals(templateName,
							spMailTemplate.getTemplateName())) {
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

			query.append(_SQL_SELECT_SPMAILTEMPLATE_WHERE);

			boolean bindTemplateName = false;

			if (templateName == null) {
				query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_1);
			}
			else if (templateName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_3);
			}
			else {
				bindTemplateName = true;

				query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTemplateName) {
					qPos.add(templateName);
				}

				if (!pagination) {
					list = (List<SPMailTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailTemplate>(list);
				}
				else {
					list = (List<SPMailTemplate>)QueryUtil.list(q,
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
	 * Returns the first s p mail template in the ordered set where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate findByTemplateName_First(String templateName,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = fetchByTemplateName_First(templateName,
				orderByComparator);

		if (spMailTemplate != null) {
			return spMailTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateName=");
		msg.append(templateName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateException(msg.toString());
	}

	/**
	 * Returns the first s p mail template in the ordered set where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchByTemplateName_First(String templateName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailTemplate> list = findByTemplateName(templateName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail template in the ordered set where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate findByTemplateName_Last(String templateName,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = fetchByTemplateName_Last(templateName,
				orderByComparator);

		if (spMailTemplate != null) {
			return spMailTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateName=");
		msg.append(templateName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateException(msg.toString());
	}

	/**
	 * Returns the last s p mail template in the ordered set where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchByTemplateName_Last(String templateName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTemplateName(templateName);

		if (count == 0) {
			return null;
		}

		List<SPMailTemplate> list = findByTemplateName(templateName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail templates before and after the current s p mail template in the ordered set where templateName = &#63;.
	 *
	 * @param spMailTemplateId the primary key of the current s p mail template
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate[] findByTemplateName_PrevAndNext(
		long spMailTemplateId, String templateName,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = findByPrimaryKey(spMailTemplateId);

		Session session = null;

		try {
			session = openSession();

			SPMailTemplate[] array = new SPMailTemplateImpl[3];

			array[0] = getByTemplateName_PrevAndNext(session, spMailTemplate,
					templateName, orderByComparator, true);

			array[1] = spMailTemplate;

			array[2] = getByTemplateName_PrevAndNext(session, spMailTemplate,
					templateName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailTemplate getByTemplateName_PrevAndNext(Session session,
		SPMailTemplate spMailTemplate, String templateName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILTEMPLATE_WHERE);

		boolean bindTemplateName = false;

		if (templateName == null) {
			query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_1);
		}
		else if (templateName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_3);
		}
		else {
			bindTemplateName = true;

			query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_2);
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
			query.append(SPMailTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTemplateName) {
			qPos.add(templateName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail templates where templateName = &#63; from the database.
	 *
	 * @param templateName the template name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplateName(String templateName)
		throws SystemException {
		for (SPMailTemplate spMailTemplate : findByTemplateName(templateName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailTemplate);
		}
	}

	/**
	 * Returns the number of s p mail templates where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @return the number of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplateName(String templateName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATENAME;

		Object[] finderArgs = new Object[] { templateName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPMAILTEMPLATE_WHERE);

			boolean bindTemplateName = false;

			if (templateName == null) {
				query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_1);
			}
			else if (templateName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_3);
			}
			else {
				bindTemplateName = true;

				query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTemplateName) {
					qPos.add(templateName);
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

	private static final String _FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_1 = "spMailTemplate.templateName IS NULL AND spMailTemplate.status=0";
	private static final String _FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_2 = "spMailTemplate.templateName = ? AND spMailTemplate.status=0";
	private static final String _FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_3 = "(spMailTemplate.templateName IS NULL OR spMailTemplate.templateName = '') AND spMailTemplate.status=0";
	public static final FinderPath FINDER_PATH_FETCH_BY_TEMPLATENAMEANDVERSIONNUMBER =
		new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTemplateNameAndVersionNumber",
			new String[] { String.class.getName(), String.class.getName() },
			SPMailTemplateModelImpl.TEMPLATENAME_COLUMN_BITMASK |
			SPMailTemplateModelImpl.VERSIONNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATENAMEANDVERSIONNUMBER =
		new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTemplateNameAndVersionNumber",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the s p mail template where templateName = &#63; and versionNumber = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchTemplateException} if it could not be found.
	 *
	 * @param templateName the template name
	 * @param versionNumber the version number
	 * @return the matching s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate findByTemplateNameAndVersionNumber(
		String templateName, String versionNumber)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = fetchByTemplateNameAndVersionNumber(templateName,
				versionNumber);

		if (spMailTemplate == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("templateName=");
			msg.append(templateName);

			msg.append(", versionNumber=");
			msg.append(versionNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTemplateException(msg.toString());
		}

		return spMailTemplate;
	}

	/**
	 * Returns the s p mail template where templateName = &#63; and versionNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param templateName the template name
	 * @param versionNumber the version number
	 * @return the matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchByTemplateNameAndVersionNumber(
		String templateName, String versionNumber) throws SystemException {
		return fetchByTemplateNameAndVersionNumber(templateName, versionNumber,
			true);
	}

	/**
	 * Returns the s p mail template where templateName = &#63; and versionNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param templateName the template name
	 * @param versionNumber the version number
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchByTemplateNameAndVersionNumber(
		String templateName, String versionNumber, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { templateName, versionNumber };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TEMPLATENAMEANDVERSIONNUMBER,
					finderArgs, this);
		}

		if (result instanceof SPMailTemplate) {
			SPMailTemplate spMailTemplate = (SPMailTemplate)result;

			if (!Validator.equals(templateName, spMailTemplate.getTemplateName()) ||
					!Validator.equals(versionNumber,
						spMailTemplate.getVersionNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPMAILTEMPLATE_WHERE);

			boolean bindTemplateName = false;

			if (templateName == null) {
				query.append(_FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_1);
			}
			else if (templateName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_3);
			}
			else {
				bindTemplateName = true;

				query.append(_FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_2);
			}

			boolean bindVersionNumber = false;

			if (versionNumber == null) {
				query.append(_FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_1);
			}
			else if (versionNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_3);
			}
			else {
				bindVersionNumber = true;

				query.append(_FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTemplateName) {
					qPos.add(templateName);
				}

				if (bindVersionNumber) {
					qPos.add(versionNumber);
				}

				List<SPMailTemplate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEMPLATENAMEANDVERSIONNUMBER,
						finderArgs, list);
				}
				else {
					SPMailTemplate spMailTemplate = list.get(0);

					result = spMailTemplate;

					cacheResult(spMailTemplate);

					if ((spMailTemplate.getTemplateName() == null) ||
							!spMailTemplate.getTemplateName()
											   .equals(templateName) ||
							(spMailTemplate.getVersionNumber() == null) ||
							!spMailTemplate.getVersionNumber()
											   .equals(versionNumber)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEMPLATENAMEANDVERSIONNUMBER,
							finderArgs, spMailTemplate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEMPLATENAMEANDVERSIONNUMBER,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SPMailTemplate)result;
		}
	}

	/**
	 * Removes the s p mail template where templateName = &#63; and versionNumber = &#63; from the database.
	 *
	 * @param templateName the template name
	 * @param versionNumber the version number
	 * @return the s p mail template that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate removeByTemplateNameAndVersionNumber(
		String templateName, String versionNumber)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = findByTemplateNameAndVersionNumber(templateName,
				versionNumber);

		return remove(spMailTemplate);
	}

	/**
	 * Returns the number of s p mail templates where templateName = &#63; and versionNumber = &#63;.
	 *
	 * @param templateName the template name
	 * @param versionNumber the version number
	 * @return the number of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplateNameAndVersionNumber(String templateName,
		String versionNumber) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATENAMEANDVERSIONNUMBER;

		Object[] finderArgs = new Object[] { templateName, versionNumber };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILTEMPLATE_WHERE);

			boolean bindTemplateName = false;

			if (templateName == null) {
				query.append(_FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_1);
			}
			else if (templateName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_3);
			}
			else {
				bindTemplateName = true;

				query.append(_FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_2);
			}

			boolean bindVersionNumber = false;

			if (versionNumber == null) {
				query.append(_FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_1);
			}
			else if (versionNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_3);
			}
			else {
				bindVersionNumber = true;

				query.append(_FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTemplateName) {
					qPos.add(templateName);
				}

				if (bindVersionNumber) {
					qPos.add(versionNumber);
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

	private static final String _FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_1 =
		"spMailTemplate.templateName IS NULL AND ";
	private static final String _FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_2 =
		"spMailTemplate.templateName = ? AND ";
	private static final String _FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_3 =
		"(spMailTemplate.templateName IS NULL OR spMailTemplate.templateName = '') AND ";
	private static final String _FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_1 =
		"spMailTemplate.versionNumber IS NULL";
	private static final String _FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_2 =
		"spMailTemplate.versionNumber = ?";
	private static final String _FINDER_COLUMN_TEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_3 =
		"(spMailTemplate.versionNumber IS NULL OR spMailTemplate.versionNumber = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER =
		new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			SPMailTemplateModelImpl.PRODUCTTYPEID_COLUMN_BITMASK |
			SPMailTemplateModelImpl.SUBPRODUCTTYPEID_COLUMN_BITMASK |
			SPMailTemplateModelImpl.TEMPLATENAME_COLUMN_BITMASK |
			SPMailTemplateModelImpl.VERSIONNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER =
		new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns the s p mail template where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63; and versionNumber = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchTemplateException} if it could not be found.
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @param versionNumber the version number
	 * @return the matching s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate findByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(
		long productTypeId, long subProductTypeId, String templateName,
		String versionNumber) throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = fetchByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(productTypeId,
				subProductTypeId, templateName, versionNumber);

		if (spMailTemplate == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("productTypeId=");
			msg.append(productTypeId);

			msg.append(", subProductTypeId=");
			msg.append(subProductTypeId);

			msg.append(", templateName=");
			msg.append(templateName);

			msg.append(", versionNumber=");
			msg.append(versionNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTemplateException(msg.toString());
		}

		return spMailTemplate;
	}

	/**
	 * Returns the s p mail template where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63; and versionNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @param versionNumber the version number
	 * @return the matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(
		long productTypeId, long subProductTypeId, String templateName,
		String versionNumber) throws SystemException {
		return fetchByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(productTypeId,
			subProductTypeId, templateName, versionNumber, true);
	}

	/**
	 * Returns the s p mail template where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63; and versionNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @param versionNumber the version number
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(
		long productTypeId, long subProductTypeId, String templateName,
		String versionNumber, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				productTypeId, subProductTypeId, templateName, versionNumber
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
					finderArgs, this);
		}

		if (result instanceof SPMailTemplate) {
			SPMailTemplate spMailTemplate = (SPMailTemplate)result;

			if ((productTypeId != spMailTemplate.getProductTypeId()) ||
					(subProductTypeId != spMailTemplate.getSubProductTypeId()) ||
					!Validator.equals(templateName,
						spMailTemplate.getTemplateName()) ||
					!Validator.equals(versionNumber,
						spMailTemplate.getVersionNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_SPMAILTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_PRODUCTTYPEID_2);

			query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_SUBPRODUCTTYPEID_2);

			boolean bindTemplateName = false;

			if (templateName == null) {
				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_1);
			}
			else if (templateName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_3);
			}
			else {
				bindTemplateName = true;

				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_2);
			}

			boolean bindVersionNumber = false;

			if (versionNumber == null) {
				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_1);
			}
			else if (versionNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_3);
			}
			else {
				bindVersionNumber = true;

				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productTypeId);

				qPos.add(subProductTypeId);

				if (bindTemplateName) {
					qPos.add(templateName);
				}

				if (bindVersionNumber) {
					qPos.add(versionNumber);
				}

				List<SPMailTemplate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
						finderArgs, list);
				}
				else {
					SPMailTemplate spMailTemplate = list.get(0);

					result = spMailTemplate;

					cacheResult(spMailTemplate);

					if ((spMailTemplate.getProductTypeId() != productTypeId) ||
							(spMailTemplate.getSubProductTypeId() != subProductTypeId) ||
							(spMailTemplate.getTemplateName() == null) ||
							!spMailTemplate.getTemplateName()
											   .equals(templateName) ||
							(spMailTemplate.getVersionNumber() == null) ||
							!spMailTemplate.getVersionNumber()
											   .equals(versionNumber)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
							finderArgs, spMailTemplate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SPMailTemplate)result;
		}
	}

	/**
	 * Removes the s p mail template where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63; and versionNumber = &#63; from the database.
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @param versionNumber the version number
	 * @return the s p mail template that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate removeByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(
		long productTypeId, long subProductTypeId, String templateName,
		String versionNumber) throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = findByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(productTypeId,
				subProductTypeId, templateName, versionNumber);

		return remove(spMailTemplate);
	}

	/**
	 * Returns the number of s p mail templates where productTypeId = &#63; and subProductTypeId = &#63; and templateName = &#63; and versionNumber = &#63;.
	 *
	 * @param productTypeId the product type ID
	 * @param subProductTypeId the sub product type ID
	 * @param templateName the template name
	 * @param versionNumber the version number
	 * @return the number of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(
		long productTypeId, long subProductTypeId, String templateName,
		String versionNumber) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER;

		Object[] finderArgs = new Object[] {
				productTypeId, subProductTypeId, templateName, versionNumber
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SPMAILTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_PRODUCTTYPEID_2);

			query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_SUBPRODUCTTYPEID_2);

			boolean bindTemplateName = false;

			if (templateName == null) {
				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_1);
			}
			else if (templateName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_3);
			}
			else {
				bindTemplateName = true;

				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_2);
			}

			boolean bindVersionNumber = false;

			if (versionNumber == null) {
				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_1);
			}
			else if (versionNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_3);
			}
			else {
				bindVersionNumber = true;

				query.append(_FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productTypeId);

				qPos.add(subProductTypeId);

				if (bindTemplateName) {
					qPos.add(templateName);
				}

				if (bindVersionNumber) {
					qPos.add(versionNumber);
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

	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_PRODUCTTYPEID_2 =
		"spMailTemplate.productTypeId = ? AND ";
	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_SUBPRODUCTTYPEID_2 =
		"spMailTemplate.subProductTypeId = ? AND ";
	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_1 =
		"spMailTemplate.templateName IS NULL AND ";
	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_2 =
		"spMailTemplate.templateName = ? AND ";
	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_TEMPLATENAME_3 =
		"(spMailTemplate.templateName IS NULL OR spMailTemplate.templateName = '') AND ";
	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_1 =
		"spMailTemplate.versionNumber IS NULL";
	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_2 =
		"spMailTemplate.versionNumber = ?";
	private static final String _FINDER_COLUMN_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER_VERSIONNUMBER_3 =
		"(spMailTemplate.versionNumber IS NULL OR spMailTemplate.versionNumber = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTEMPALTEID =
		new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByparentTempalteId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTEMPALTEID =
		new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByparentTempalteId", new String[] { Long.class.getName() },
			SPMailTemplateModelImpl.PARENTTEMPALTEID_COLUMN_BITMASK |
			SPMailTemplateModelImpl.VERSIONNUMBER_COLUMN_BITMASK |
			SPMailTemplateModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTTEMPALTEID = new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByparentTempalteId", new String[] { Long.class.getName() });

	/**
	 * Returns all the s p mail templates where parentTempalteId = &#63;.
	 *
	 * @param parentTempalteId the parent tempalte ID
	 * @return the matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findByparentTempalteId(long parentTempalteId)
		throws SystemException {
		return findByparentTempalteId(parentTempalteId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail templates where parentTempalteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentTempalteId the parent tempalte ID
	 * @param start the lower bound of the range of s p mail templates
	 * @param end the upper bound of the range of s p mail templates (not inclusive)
	 * @return the range of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findByparentTempalteId(long parentTempalteId,
		int start, int end) throws SystemException {
		return findByparentTempalteId(parentTempalteId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail templates where parentTempalteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentTempalteId the parent tempalte ID
	 * @param start the lower bound of the range of s p mail templates
	 * @param end the upper bound of the range of s p mail templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findByparentTempalteId(long parentTempalteId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTEMPALTEID;
			finderArgs = new Object[] { parentTempalteId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTEMPALTEID;
			finderArgs = new Object[] {
					parentTempalteId,
					
					start, end, orderByComparator
				};
		}

		List<SPMailTemplate> list = (List<SPMailTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailTemplate spMailTemplate : list) {
				if ((parentTempalteId != spMailTemplate.getParentTempalteId())) {
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

			query.append(_SQL_SELECT_SPMAILTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PARENTTEMPALTEID_PARENTTEMPALTEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentTempalteId);

				if (!pagination) {
					list = (List<SPMailTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailTemplate>(list);
				}
				else {
					list = (List<SPMailTemplate>)QueryUtil.list(q,
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
	 * Returns the first s p mail template in the ordered set where parentTempalteId = &#63;.
	 *
	 * @param parentTempalteId the parent tempalte ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate findByparentTempalteId_First(long parentTempalteId,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = fetchByparentTempalteId_First(parentTempalteId,
				orderByComparator);

		if (spMailTemplate != null) {
			return spMailTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentTempalteId=");
		msg.append(parentTempalteId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateException(msg.toString());
	}

	/**
	 * Returns the first s p mail template in the ordered set where parentTempalteId = &#63;.
	 *
	 * @param parentTempalteId the parent tempalte ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchByparentTempalteId_First(long parentTempalteId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailTemplate> list = findByparentTempalteId(parentTempalteId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail template in the ordered set where parentTempalteId = &#63;.
	 *
	 * @param parentTempalteId the parent tempalte ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate findByparentTempalteId_Last(long parentTempalteId,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = fetchByparentTempalteId_Last(parentTempalteId,
				orderByComparator);

		if (spMailTemplate != null) {
			return spMailTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentTempalteId=");
		msg.append(parentTempalteId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateException(msg.toString());
	}

	/**
	 * Returns the last s p mail template in the ordered set where parentTempalteId = &#63;.
	 *
	 * @param parentTempalteId the parent tempalte ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchByparentTempalteId_Last(long parentTempalteId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByparentTempalteId(parentTempalteId);

		if (count == 0) {
			return null;
		}

		List<SPMailTemplate> list = findByparentTempalteId(parentTempalteId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail templates before and after the current s p mail template in the ordered set where parentTempalteId = &#63;.
	 *
	 * @param spMailTemplateId the primary key of the current s p mail template
	 * @param parentTempalteId the parent tempalte ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate[] findByparentTempalteId_PrevAndNext(
		long spMailTemplateId, long parentTempalteId,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = findByPrimaryKey(spMailTemplateId);

		Session session = null;

		try {
			session = openSession();

			SPMailTemplate[] array = new SPMailTemplateImpl[3];

			array[0] = getByparentTempalteId_PrevAndNext(session,
					spMailTemplate, parentTempalteId, orderByComparator, true);

			array[1] = spMailTemplate;

			array[2] = getByparentTempalteId_PrevAndNext(session,
					spMailTemplate, parentTempalteId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailTemplate getByparentTempalteId_PrevAndNext(
		Session session, SPMailTemplate spMailTemplate, long parentTempalteId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILTEMPLATE_WHERE);

		query.append(_FINDER_COLUMN_PARENTTEMPALTEID_PARENTTEMPALTEID_2);

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
			query.append(SPMailTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentTempalteId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail templates where parentTempalteId = &#63; from the database.
	 *
	 * @param parentTempalteId the parent tempalte ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByparentTempalteId(long parentTempalteId)
		throws SystemException {
		for (SPMailTemplate spMailTemplate : findByparentTempalteId(
				parentTempalteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailTemplate);
		}
	}

	/**
	 * Returns the number of s p mail templates where parentTempalteId = &#63;.
	 *
	 * @param parentTempalteId the parent tempalte ID
	 * @return the number of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByparentTempalteId(long parentTempalteId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTTEMPALTEID;

		Object[] finderArgs = new Object[] { parentTempalteId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPMAILTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_PARENTTEMPALTEID_PARENTTEMPALTEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentTempalteId);

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

	private static final String _FINDER_COLUMN_PARENTTEMPALTEID_PARENTTEMPALTEID_2 =
		"spMailTemplate.parentTempalteId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBystatus",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPMailTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Boolean.class.getName() },
			SPMailTemplateModelImpl.STATUS_COLUMN_BITMASK |
			SPMailTemplateModelImpl.PARENTTEMPALTEID_COLUMN_BITMASK |
			SPMailTemplateModelImpl.VERSIONNUMBER_COLUMN_BITMASK |
			SPMailTemplateModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the s p mail templates where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findBystatus(boolean status)
		throws SystemException {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail templates where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of s p mail templates
	 * @param end the upper bound of the range of s p mail templates (not inclusive)
	 * @return the range of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findBystatus(boolean status, int start, int end)
		throws SystemException {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail templates where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of s p mail templates
	 * @param end the upper bound of the range of s p mail templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findBystatus(boolean status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<SPMailTemplate> list = (List<SPMailTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailTemplate spMailTemplate : list) {
				if ((status != spMailTemplate.getStatus())) {
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

			query.append(_SQL_SELECT_SPMAILTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<SPMailTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailTemplate>(list);
				}
				else {
					list = (List<SPMailTemplate>)QueryUtil.list(q,
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
	 * Returns the first s p mail template in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate findBystatus_First(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = fetchBystatus_First(status,
				orderByComparator);

		if (spMailTemplate != null) {
			return spMailTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateException(msg.toString());
	}

	/**
	 * Returns the first s p mail template in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchBystatus_First(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailTemplate> list = findBystatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail template in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate findBystatus_Last(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = fetchBystatus_Last(status,
				orderByComparator);

		if (spMailTemplate != null) {
			return spMailTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTemplateException(msg.toString());
	}

	/**
	 * Returns the last s p mail template in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail template, or <code>null</code> if a matching s p mail template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchBystatus_Last(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBystatus(status);

		if (count == 0) {
			return null;
		}

		List<SPMailTemplate> list = findBystatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail templates before and after the current s p mail template in the ordered set where status = &#63;.
	 *
	 * @param spMailTemplateId the primary key of the current s p mail template
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate[] findBystatus_PrevAndNext(long spMailTemplateId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = findByPrimaryKey(spMailTemplateId);

		Session session = null;

		try {
			session = openSession();

			SPMailTemplate[] array = new SPMailTemplateImpl[3];

			array[0] = getBystatus_PrevAndNext(session, spMailTemplate, status,
					orderByComparator, true);

			array[1] = spMailTemplate;

			array[2] = getBystatus_PrevAndNext(session, spMailTemplate, status,
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

	protected SPMailTemplate getBystatus_PrevAndNext(Session session,
		SPMailTemplate spMailTemplate, boolean status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILTEMPLATE_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(SPMailTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail templates where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystatus(boolean status) throws SystemException {
		for (SPMailTemplate spMailTemplate : findBystatus(status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailTemplate);
		}
	}

	/**
	 * Returns the number of s p mail templates where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystatus(boolean status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPMAILTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "spMailTemplate.status = ?";

	public SPMailTemplatePersistenceImpl() {
		setModelClass(SPMailTemplate.class);
	}

	/**
	 * Caches the s p mail template in the entity cache if it is enabled.
	 *
	 * @param spMailTemplate the s p mail template
	 */
	@Override
	public void cacheResult(SPMailTemplate spMailTemplate) {
		EntityCacheUtil.putResult(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateImpl.class, spMailTemplate.getPrimaryKey(),
			spMailTemplate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEMPLATENAMEANDVERSIONNUMBER,
			new Object[] {
				spMailTemplate.getTemplateName(),
				spMailTemplate.getVersionNumber()
			}, spMailTemplate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
			new Object[] {
				spMailTemplate.getProductTypeId(),
				spMailTemplate.getSubProductTypeId(),
				spMailTemplate.getTemplateName(),
				spMailTemplate.getVersionNumber()
			}, spMailTemplate);

		spMailTemplate.resetOriginalValues();
	}

	/**
	 * Caches the s p mail templates in the entity cache if it is enabled.
	 *
	 * @param spMailTemplates the s p mail templates
	 */
	@Override
	public void cacheResult(List<SPMailTemplate> spMailTemplates) {
		for (SPMailTemplate spMailTemplate : spMailTemplates) {
			if (EntityCacheUtil.getResult(
						SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
						SPMailTemplateImpl.class, spMailTemplate.getPrimaryKey()) == null) {
				cacheResult(spMailTemplate);
			}
			else {
				spMailTemplate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p mail templates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPMailTemplateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPMailTemplateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p mail template.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPMailTemplate spMailTemplate) {
		EntityCacheUtil.removeResult(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateImpl.class, spMailTemplate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spMailTemplate);
	}

	@Override
	public void clearCache(List<SPMailTemplate> spMailTemplates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPMailTemplate spMailTemplate : spMailTemplates) {
			EntityCacheUtil.removeResult(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
				SPMailTemplateImpl.class, spMailTemplate.getPrimaryKey());

			clearUniqueFindersCache(spMailTemplate);
		}
	}

	protected void cacheUniqueFindersCache(SPMailTemplate spMailTemplate) {
		if (spMailTemplate.isNew()) {
			Object[] args = new Object[] {
					spMailTemplate.getTemplateName(),
					spMailTemplate.getVersionNumber()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TEMPLATENAMEANDVERSIONNUMBER,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEMPLATENAMEANDVERSIONNUMBER,
				args, spMailTemplate);

			args = new Object[] {
					spMailTemplate.getProductTypeId(),
					spMailTemplate.getSubProductTypeId(),
					spMailTemplate.getTemplateName(),
					spMailTemplate.getVersionNumber()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
				args, spMailTemplate);
		}
		else {
			SPMailTemplateModelImpl spMailTemplateModelImpl = (SPMailTemplateModelImpl)spMailTemplate;

			if ((spMailTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TEMPLATENAMEANDVERSIONNUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailTemplate.getTemplateName(),
						spMailTemplate.getVersionNumber()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TEMPLATENAMEANDVERSIONNUMBER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEMPLATENAMEANDVERSIONNUMBER,
					args, spMailTemplate);
			}

			if ((spMailTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailTemplate.getProductTypeId(),
						spMailTemplate.getSubProductTypeId(),
						spMailTemplate.getTemplateName(),
						spMailTemplate.getVersionNumber()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
					args, spMailTemplate);
			}
		}
	}

	protected void clearUniqueFindersCache(SPMailTemplate spMailTemplate) {
		SPMailTemplateModelImpl spMailTemplateModelImpl = (SPMailTemplateModelImpl)spMailTemplate;

		Object[] args = new Object[] {
				spMailTemplate.getTemplateName(),
				spMailTemplate.getVersionNumber()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATENAMEANDVERSIONNUMBER,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEMPLATENAMEANDVERSIONNUMBER,
			args);

		if ((spMailTemplateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TEMPLATENAMEANDVERSIONNUMBER.getColumnBitmask()) != 0) {
			args = new Object[] {
					spMailTemplateModelImpl.getOriginalTemplateName(),
					spMailTemplateModelImpl.getOriginalVersionNumber()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATENAMEANDVERSIONNUMBER,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEMPLATENAMEANDVERSIONNUMBER,
				args);
		}

		args = new Object[] {
				spMailTemplate.getProductTypeId(),
				spMailTemplate.getSubProductTypeId(),
				spMailTemplate.getTemplateName(),
				spMailTemplate.getVersionNumber()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
			args);

		if ((spMailTemplateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER.getColumnBitmask()) != 0) {
			args = new Object[] {
					spMailTemplateModelImpl.getOriginalProductTypeId(),
					spMailTemplateModelImpl.getOriginalSubProductTypeId(),
					spMailTemplateModelImpl.getOriginalTemplateName(),
					spMailTemplateModelImpl.getOriginalVersionNumber()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAMEANDVERSIONNUMBER,
				args);
		}
	}

	/**
	 * Creates a new s p mail template with the primary key. Does not add the s p mail template to the database.
	 *
	 * @param spMailTemplateId the primary key for the new s p mail template
	 * @return the new s p mail template
	 */
	@Override
	public SPMailTemplate create(long spMailTemplateId) {
		SPMailTemplate spMailTemplate = new SPMailTemplateImpl();

		spMailTemplate.setNew(true);
		spMailTemplate.setPrimaryKey(spMailTemplateId);

		return spMailTemplate;
	}

	/**
	 * Removes the s p mail template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spMailTemplateId the primary key of the s p mail template
	 * @return the s p mail template that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate remove(long spMailTemplateId)
		throws NoSuchTemplateException, SystemException {
		return remove((Serializable)spMailTemplateId);
	}

	/**
	 * Removes the s p mail template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p mail template
	 * @return the s p mail template that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate remove(Serializable primaryKey)
		throws NoSuchTemplateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPMailTemplate spMailTemplate = (SPMailTemplate)session.get(SPMailTemplateImpl.class,
					primaryKey);

			if (spMailTemplate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spMailTemplate);
		}
		catch (NoSuchTemplateException nsee) {
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
	protected SPMailTemplate removeImpl(SPMailTemplate spMailTemplate)
		throws SystemException {
		spMailTemplate = toUnwrappedModel(spMailTemplate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spMailTemplate)) {
				spMailTemplate = (SPMailTemplate)session.get(SPMailTemplateImpl.class,
						spMailTemplate.getPrimaryKeyObj());
			}

			if (spMailTemplate != null) {
				session.delete(spMailTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spMailTemplate != null) {
			clearCache(spMailTemplate);
		}

		return spMailTemplate;
	}

	@Override
	public SPMailTemplate updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailTemplate spMailTemplate)
		throws SystemException {
		spMailTemplate = toUnwrappedModel(spMailTemplate);

		boolean isNew = spMailTemplate.isNew();

		SPMailTemplateModelImpl spMailTemplateModelImpl = (SPMailTemplateModelImpl)spMailTemplate;

		Session session = null;

		try {
			session = openSession();

			if (spMailTemplate.isNew()) {
				session.save(spMailTemplate);

				spMailTemplate.setNew(false);
			}
			else {
				session.merge(spMailTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPMailTemplateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spMailTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailTemplateModelImpl.getOriginalProductTypeId(),
						spMailTemplateModelImpl.getOriginalSubProductTypeId(),
						spMailTemplateModelImpl.getOriginalTemplateName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME,
					args);

				args = new Object[] {
						spMailTemplateModelImpl.getProductTypeId(),
						spMailTemplateModelImpl.getSubProductTypeId(),
						spMailTemplateModelImpl.getTemplateName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTTYPEIDANDSUBPRODUCTTYPEIDANDTEMPLATENAME,
					args);
			}

			if ((spMailTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailTemplateModelImpl.getOriginalTemplateName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATENAME,
					args);

				args = new Object[] { spMailTemplateModelImpl.getTemplateName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATENAME,
					args);
			}

			if ((spMailTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTEMPALTEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailTemplateModelImpl.getOriginalParentTempalteId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTEMPALTEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTEMPALTEID,
					args);

				args = new Object[] {
						spMailTemplateModelImpl.getParentTempalteId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTTEMPALTEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTEMPALTEID,
					args);
			}

			if ((spMailTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailTemplateModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { spMailTemplateModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPMailTemplateImpl.class, spMailTemplate.getPrimaryKey(),
			spMailTemplate);

		clearUniqueFindersCache(spMailTemplate);
		cacheUniqueFindersCache(spMailTemplate);

		return spMailTemplate;
	}

	protected SPMailTemplate toUnwrappedModel(SPMailTemplate spMailTemplate) {
		if (spMailTemplate instanceof SPMailTemplateImpl) {
			return spMailTemplate;
		}

		SPMailTemplateImpl spMailTemplateImpl = new SPMailTemplateImpl();

		spMailTemplateImpl.setNew(spMailTemplate.isNew());
		spMailTemplateImpl.setPrimaryKey(spMailTemplate.getPrimaryKey());

		spMailTemplateImpl.setSpMailTemplateId(spMailTemplate.getSpMailTemplateId());
		spMailTemplateImpl.setProductTypeId(spMailTemplate.getProductTypeId());
		spMailTemplateImpl.setSubProductTypeId(spMailTemplate.getSubProductTypeId());
		spMailTemplateImpl.setTemplateName(spMailTemplate.getTemplateName());
		spMailTemplateImpl.setGroupId(spMailTemplate.getGroupId());
		spMailTemplateImpl.setCompanyId(spMailTemplate.getCompanyId());
		spMailTemplateImpl.setSubject(spMailTemplate.getSubject());
		spMailTemplateImpl.setHtmlContent(spMailTemplate.getHtmlContent());
		spMailTemplateImpl.setTextContent(spMailTemplate.getTextContent());
		spMailTemplateImpl.setHtmlUpload(spMailTemplate.isHtmlUpload());
		spMailTemplateImpl.setStatus(spMailTemplate.isStatus());
		spMailTemplateImpl.setCreateBy(spMailTemplate.getCreateBy());
		spMailTemplateImpl.setCreateDate(spMailTemplate.getCreateDate());
		spMailTemplateImpl.setModifiedBy(spMailTemplate.getModifiedBy());
		spMailTemplateImpl.setModifiedDate(spMailTemplate.getModifiedDate());
		spMailTemplateImpl.setParentTempalteId(spMailTemplate.getParentTempalteId());
		spMailTemplateImpl.setVersionNumber(spMailTemplate.getVersionNumber());
		spMailTemplateImpl.setFromAddress(spMailTemplate.getFromAddress());
		spMailTemplateImpl.setFromName(spMailTemplate.getFromName());

		return spMailTemplateImpl;
	}

	/**
	 * Returns the s p mail template with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail template
	 * @return the s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTemplateException, SystemException {
		SPMailTemplate spMailTemplate = fetchByPrimaryKey(primaryKey);

		if (spMailTemplate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spMailTemplate;
	}

	/**
	 * Returns the s p mail template with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchTemplateException} if it could not be found.
	 *
	 * @param spMailTemplateId the primary key of the s p mail template
	 * @return the s p mail template
	 * @throws com.sambaash.platform.srv.mail.NoSuchTemplateException if a s p mail template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate findByPrimaryKey(long spMailTemplateId)
		throws NoSuchTemplateException, SystemException {
		return findByPrimaryKey((Serializable)spMailTemplateId);
	}

	/**
	 * Returns the s p mail template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail template
	 * @return the s p mail template, or <code>null</code> if a s p mail template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPMailTemplate spMailTemplate = (SPMailTemplate)EntityCacheUtil.getResult(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
				SPMailTemplateImpl.class, primaryKey);

		if (spMailTemplate == _nullSPMailTemplate) {
			return null;
		}

		if (spMailTemplate == null) {
			Session session = null;

			try {
				session = openSession();

				spMailTemplate = (SPMailTemplate)session.get(SPMailTemplateImpl.class,
						primaryKey);

				if (spMailTemplate != null) {
					cacheResult(spMailTemplate);
				}
				else {
					EntityCacheUtil.putResult(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
						SPMailTemplateImpl.class, primaryKey,
						_nullSPMailTemplate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPMailTemplateModelImpl.ENTITY_CACHE_ENABLED,
					SPMailTemplateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spMailTemplate;
	}

	/**
	 * Returns the s p mail template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spMailTemplateId the primary key of the s p mail template
	 * @return the s p mail template, or <code>null</code> if a s p mail template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailTemplate fetchByPrimaryKey(long spMailTemplateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spMailTemplateId);
	}

	/**
	 * Returns all the s p mail templates.
	 *
	 * @return the s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail templates
	 * @param end the upper bound of the range of s p mail templates (not inclusive)
	 * @return the range of s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail templates
	 * @param end the upper bound of the range of s p mail templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p mail templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailTemplate> findAll(int start, int end,
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

		List<SPMailTemplate> list = (List<SPMailTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPMAILTEMPLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPMAILTEMPLATE;

				if (pagination) {
					sql = sql.concat(SPMailTemplateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPMailTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailTemplate>(list);
				}
				else {
					list = (List<SPMailTemplate>)QueryUtil.list(q,
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
	 * Removes all the s p mail templates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPMailTemplate spMailTemplate : findAll()) {
			remove(spMailTemplate);
		}
	}

	/**
	 * Returns the number of s p mail templates.
	 *
	 * @return the number of s p mail templates
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

				Query q = session.createQuery(_SQL_COUNT_SPMAILTEMPLATE);

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
	 * Initializes the s p mail template persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.mail.model.SPMailTemplate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPMailTemplate>> listenersList = new ArrayList<ModelListener<SPMailTemplate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPMailTemplate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPMailTemplateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPMAILTEMPLATE = "SELECT spMailTemplate FROM SPMailTemplate spMailTemplate";
	private static final String _SQL_SELECT_SPMAILTEMPLATE_WHERE = "SELECT spMailTemplate FROM SPMailTemplate spMailTemplate WHERE ";
	private static final String _SQL_COUNT_SPMAILTEMPLATE = "SELECT COUNT(spMailTemplate) FROM SPMailTemplate spMailTemplate";
	private static final String _SQL_COUNT_SPMAILTEMPLATE_WHERE = "SELECT COUNT(spMailTemplate) FROM SPMailTemplate spMailTemplate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spMailTemplate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPMailTemplate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPMailTemplate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPMailTemplatePersistenceImpl.class);
	private static SPMailTemplate _nullSPMailTemplate = new SPMailTemplateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPMailTemplate> toCacheModel() {
				return _nullSPMailTemplateCacheModel;
			}
		};

	private static CacheModel<SPMailTemplate> _nullSPMailTemplateCacheModel = new CacheModel<SPMailTemplate>() {
			@Override
			public SPMailTemplate toEntityModel() {
				return _nullSPMailTemplate;
			}
		};
}