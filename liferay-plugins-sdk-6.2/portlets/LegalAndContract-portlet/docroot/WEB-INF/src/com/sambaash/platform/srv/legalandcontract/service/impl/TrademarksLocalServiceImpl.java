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

package com.sambaash.platform.srv.legalandcontract.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.compat.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.legalandcontract.service.LitigationLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.base.TrademarksLocalServiceBaseImpl;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.filters.RemoveZeroPredicateFilter;
/**
 * The implementation of the trademarks local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.legalandcontract.service.base.TrademarksLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalServiceUtil
 */
public class TrademarksLocalServiceImpl extends TrademarksLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.service.TrademarksLocalServiceUtil} to access
	 * the trademarks local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(TrademarksLocalServiceImpl.class);

	public void addTrademarks(long userId, Trademarks trademarks, long[] assetCategoryIds) throws Exception {
		try {
			User user = userPersistence.findByPrimaryKey(userId);
			Date now = new Date();
			trademarks.setCreateDate(now);
			trademarks.setCompanyId(user.getCompanyId());
			trademarks.setUserId(user.getUserId());
			trademarks.setUserName(user.getFullName());
			trademarks.setNew(true);
			trademarks = trademarksPersistence.update(trademarks, false);
			boolean trademarkWfEnabled = new Boolean(SambaashUtil.getParameter(
					SambaashConstants.TRADEMARK_WORKFLOW_ENABLED, 0));
			if (trademarkWfEnabled) {
				trademarks.setWorkflowStatus(TrademarksConstants.DRAFT);
			} else {
				trademarks.setWorkflowStatus(TrademarksConstants.APPROVED);
			}

			// Asset
			updateAsset(trademarks.getUserId(), trademarks, assetCategoryIds, null, null);

			reIndex(trademarks);

		} catch (Exception ex) {
			_log.error(ex);
			throw ex;
		}
	}

	public void addNewTrademarksVersion(long userId, long oldTrademarksId, Trademarks newTrademarks,
			long[] assetCategoryIds) throws Exception {
		Trademarks oldTrademarks = getTrademarks(oldTrademarksId);
		addNewTrademarksVersion(userId, oldTrademarks, newTrademarks, assetCategoryIds);
	}

	public void addNewTrademarksVersion(long userId, Trademarks oldTrademarks, Trademarks newTrademarks,
			long[] assetCategoryIds) throws Exception{

		String version = oldTrademarks.getVersion();
		version = Utils.getNextVersion(version);
		newTrademarks.setVersion(version);
		newTrademarks.setRootSpTrademarksId(oldTrademarks.getRootSpTrademarksId());
		// newTrademarks.setRegistrationNumber(oldTrademarks.getRegistrationNumber());
		newTrademarks.setApplicationNo(oldTrademarks.getApplicationNo());
		newTrademarks.setCountry(oldTrademarks.getCountry());

		boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(userId);
		if(!authorized){
			newTrademarks.setLegalConfRemarks(oldTrademarks.getLegalConfRemarks());
		}
		
		addTrademarks(userId, newTrademarks, assetCategoryIds);
		reIndex(oldTrademarks);
		try {
			if (!oldTrademarks.getTrademark().equals(
					newTrademarks.getTrademark())) {
				List<Object[]> litigationIdArrList = LitigationLocalServiceUtil
						.getLatestLitigationsByTrademarkId(newTrademarks
								.getRootSpTrademarksId());
				for (Object[] obj : litigationIdArrList) {
					LitigationLocalServiceUtil.reIndex(LitigationLocalServiceUtil.getLitigation((Long) obj[1]));
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	
	}

	public void addNewTrademarks(long userId, Trademarks trademarks, long[] assetCategoryIds) throws Exception{
		trademarks.setVersion(TrademarksConstants.START_VERSION);
		trademarks.setRootSpTrademarksId(trademarks.getSpTrademarksId());
		boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(userId);
		if(!authorized){
			trademarks.setLegalConfRemarks(StringPool.BLANK);
		}
		addTrademarks(userId, trademarks, assetCategoryIds);
	}

	public void reIndex(Trademarks trademarks) {
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put(TrademarksConstants.TRADEMARK, trademarks);
		//map.put(TrademarksConstants.LATEST, isLatest);
		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());
		if (indexer != null) {
			try {
				indexer.reindex(trademarks);
			} catch (SearchException se) {
				_log.error(se.getMessage());
			}
		}
	}

	public Trademarks getNewTrademarks() throws SystemException {
		Trademarks trademarks = null;
		try {
			long trademarksId = counterLocalService.increment("Trademarks.class");
			trademarks = TrademarksLocalServiceUtil.createTrademarks(trademarksId);
			trademarks.setNew(true);
		} catch (SystemException ex) {
			_log.error(ex);
			throw ex;
		}
		return trademarks;
	}

	public void updateAsset(long userId, Trademarks trademarks, long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		boolean visible = true;

		// filter 0's as they are not valid category ids.Else while fetching categories AssetCateogryLocalServiceUtil.getCategories will throw exception
		assetCategoryIds = ArrayUtil.filter(assetCategoryIds, new RemoveZeroPredicateFilter());
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, trademarks.getGroupId(),
				Trademarks.class.getName(), trademarks.getSpTrademarksId(), trademarks.getUuid(), 0, assetCategoryIds,
				assetTagNames, visible, null, null, trademarks.getCreateDate(), null, ContentTypes.TEXT_HTML,
				trademarks.getApplicationNo(), null, trademarks.getApplicationNo(), null, null, 0, 0, null, false);
		
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), assetLinkEntryIds,
				AssetLinkConstants.TYPE_RELATED);
	}

	public Trademarks findByRegistrationNumberCountry(String regNum, String country) {
		Trademarks trademarks = null;
		try {
			trademarks = trademarksPersistence.findByRegistrationNumberCountry(regNum, country);
		} catch (NoSuchTrademarksException e) {
			_log.error("Trademark not found with regNum " + regNum + " : country" + country);
		} catch (Exception ex) {
			_log.error(ex);
		}
		return trademarks;
	}

	public Trademarks findByApplicationNoCountry(String applicationNo, String country) {
		Trademarks trademarks = null;
		try {
			trademarks = trademarksPersistence.findByApplicationNoCountry(applicationNo, country);
		} catch (NoSuchTrademarksException e) {
			_log.error("Trademark not found with applicationNo " + applicationNo + " : country" + country);
		} catch (Exception ex) {
			_log.error(ex);
		}
		return trademarks;
	}

	@SuppressWarnings("unchecked")
	public Trademarks getLatestTrademarksByNumberCountry(String number, String country) {
		Trademarks trademark = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(Trademarks.class,
					PortletClassLoaderUtil.getClassLoader(TrademarksConstants.PORTLET_ID));
			Criterion criterion1 = RestrictionsFactoryUtil.eq(TrademarksConstants.COUNTRY, country);
			Criterion criterion2 = RestrictionsFactoryUtil.eq(TrademarksConstants.REGISTRATION_NUMBER, number);
			dynaQuery.add(RestrictionsFactoryUtil.and(criterion1, criterion2));
			List<Trademarks> list = trademarksLocalService.dynamicQuery(dynaQuery);
			float latest = -1;
			float temp;
			for (Trademarks ta : list) {
				temp = Float.parseFloat(ta.getVersion());
				if (temp > latest) {
					latest = temp;
					trademark = ta;
				}
			}
		} catch (Exception ex) {
			_log.error(ex);
		}
		return trademark;
	}

	@SuppressWarnings("unchecked")
	public Trademarks getLatestTrademarksByApplicationNoCountry(String number, String country) {
		Trademarks trademark = null;
		try {
			DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(Trademarks.class,
					PortletClassLoaderUtil.getClassLoader(TrademarksConstants.PORTLET_ID));
//			Criterion criterion1 = RestrictionsFactoryUtil.eq(TrademarksConstants.COUNTRY, country);
//			Criterion criterion2 = RestrictionsFactoryUtil.eq(TrademarksConstants.APPLICATION_NO, number);
			Criterion criterion1 = RestrictionsFactoryUtil.ilike(TrademarksConstants.COUNTRY, country);
			Criterion criterion2 = RestrictionsFactoryUtil.ilike(TrademarksConstants.APPLICATION_NO, number);
			dynaQuery.add(RestrictionsFactoryUtil.and(criterion1, criterion2));
			List<Trademarks> list = trademarksLocalService.dynamicQuery(dynaQuery);
			float latest = -1;
			float temp;
			for (Trademarks ta : list) {
				temp = Float.parseFloat(ta.getVersion());
				if (temp > latest) {
					latest = temp;
					trademark = ta;
				}
			}
		} catch (Exception ex) {
			_log.error(ex);
		}
		return trademark;
	}

	/**
	 * @param number
	 * @param country
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getLatestTrademarkIdAndVersionNumber(String number, String country) {

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Trademarks.class,
					PortletClassLoaderUtil.getClassLoader(TrademarksConstants.PORTLET_ID));

			dynamicQuery.add(PropertyFactoryUtil.forName(TrademarksConstants.APPLICATION_NO).eq(new String(number)))
					.add(PropertyFactoryUtil.forName(TrademarksConstants.COUNTRY).eq(new String(country)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.max(TrademarksConstants.VERSION));
			proList.add(ProjectionFactoryUtil.max(TrademarksConstants.DB_CLMN_TRADEMARKS_ID));
			proList.add(ProjectionFactoryUtil.groupProperty(TrademarksConstants.APPLICATION_NO));
			proList.add(ProjectionFactoryUtil.groupProperty(TrademarksConstants.COUNTRY));
			dynamicQuery.setProjection(proList);

			return trademarksLocalService.dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;

	}

}