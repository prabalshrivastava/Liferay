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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.util.LitigationConstants;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.model.Litigation;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.legalandcontract.service.LitigationLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.base.LitigationLocalServiceBaseImpl;
import com.sambaash.platform.util.filters.RemoveZeroPredicateFilter;


/**
 * The implementation of the litigation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.legalandcontract.service.LitigationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.legalandcontract.service.base.LitigationLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.legalandcontract.service.LitigationLocalServiceUtil
 */
public class LitigationLocalServiceImpl extends LitigationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.LitigationLocalServiceUtil} to access the litigation local service.
	 */
	private static Log _log = LogFactoryUtil
			.getLog(LitigationLocalServiceImpl.class);

	public void addNewLitigationVersion(long userId, long oldLitigationId,Litigation newLitigation, long[] assetCategoryIds) {
		try {
			Litigation oldLitigation = getLitigation(oldLitigationId);
			addNewLitigationVersion(userId, oldLitigation, newLitigation, assetCategoryIds);
		} catch (Exception ex) {
			_log.error(ex);
		}
	} 
	
	public void addNewLitigationVersion(long userId, Litigation oldLitigation,Litigation newLitigation, long[] assetCategoryIds) {
		try {
			String version = oldLitigation.getVersion();
			version = Utils.getNextVersion(version);
			newLitigation.setVersion(version);
			newLitigation.setRootSpLitigationId(oldLitigation.getRootSpLitigationId());
			newLitigation.setSpTrademarksId(oldLitigation.getSpTrademarksId());
			newLitigation.setCountry(oldLitigation.getCountry());
			
			boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(userId);
			if(!authorized){
				newLitigation.setLegalConfRemarks(oldLitigation.getLegalConfRemarks());
			}
			
			addLitigation(userId,newLitigation,assetCategoryIds);
			reIndex(oldLitigation);
			
			Trademarks trademarks = trademarksLocalService.getTrademarks(newLitigation.getSpTrademarksId());
			reIndexTrademark(trademarks);


		} catch (Exception ex) {
			_log.error(ex);
		}
	} 
	public void addNewLitigation(long userId, Litigation litigation, long[] assetCategoryIds) {
		try {
			litigation.setVersion(LitigationConstants.START_VERSION);
			litigation.setRootSpLitigationId(litigation.getSpLitigationId());
			boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(userId);
			if(!authorized){
				litigation.setLegalConfRemarks(StringPool.BLANK);
			}
			addLitigation(userId,litigation,assetCategoryIds);
			
			Trademarks trademarks = trademarksLocalService.getTrademarks(litigation.getSpTrademarksId());
			reIndexTrademark(trademarks);
			
		} catch (Exception ex) {
			_log.error(ex);
		}
	} 
	
	public void reIndex(Litigation litigation){
		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());
		if (indexer != null) {
			try {
				indexer.reindex(litigation);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}
	public void reIndexTrademark(Trademarks trademarks){
	/*	Document doc = TrademarksSearch.getDocumentByPK(trademarks.getSpTrademarksId(), trademarks.getCompanyId(),Trademarks.class.getName());
		boolean isLatest = GetterUtil.getBoolean(doc.get(TrademarksConstants.LATEST));
		
		Map<String,Object>map = new HashMap<String,Object>();
		map.put(TrademarksConstants.TRADEMARK, trademarks);
		map.put(TrademarksConstants.LATEST, isLatest);
		String litIds = doc.get(TrademarksConstants.LITIGATION_IDS);
		if(Validator.isNull(litIds)){
			litIds = String.valueOf(litigationId);
		}else{
			litIds = litIds + "," + litigationId;
		}
		map.put(TrademarksConstants.LITIGATION_IDS, litIds); */
		Indexer indexer = IndexerRegistryUtil.getIndexer(Trademarks.class.getName());
		if (indexer != null) {
			try {
				indexer.reindex(trademarks);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}
	public void addLitigation(long userId, Litigation litigation, long[] assetCategoryIds) throws Exception {
		try {
			User user = userPersistence.findByPrimaryKey(userId);
			litigation.setCompanyId(user.getCompanyId());
			litigation.setUserId(user.getUserId());
			litigation.setUserName(user.getFullName());
			Date now = new Date();
			litigation.setCreateDate(now);
			litigation = litigationPersistence.update(litigation, false);
			// Asset
			if(Validator.isNotNull(assetCategoryIds)){
				assetCategoryIds = Utils.filterZeros(assetCategoryIds);
				updateAsset(litigation.getUserId(), litigation, assetCategoryIds, null,
						null);
			}
			reIndex(litigation);
			
		} catch (Exception ex) {
			_log.error(ex);
			throw ex;
		}
	}

	public Litigation getNewLitigation() throws SystemException {
		Litigation litigation = null;
		try {
			long litigationId = counterLocalService.increment(getModelClassName());
			litigation = LitigationLocalServiceUtil.createLitigation(litigationId);
		} catch (SystemException ex) {
			_log.error(ex);
			throw ex;
		}
		return litigation;
	}
	
	public void updateAsset(long userId, Litigation litigation,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		boolean visible = true;
		// filter 0's as they are not valid category ids.Else while fetching categories AssetCateogryLocalServiceUtil.getCategories will throw exception
		assetCategoryIds = ArrayUtil.filter(assetCategoryIds, new RemoveZeroPredicateFilter());
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				litigation.getGroupId(), getModelClassName(),
				litigation.getSpLitigationId(), litigation.getUuid(), 0, assetCategoryIds,
				assetTagNames, visible, null, null, litigation.getCreateDate(),
				null, ContentTypes.TEXT_HTML, String.valueOf(litigation.getSpTrademarksId()), null,
				String.valueOf(litigation.getSpTrademarksId()), null, null, 0, 0, null, false);
		
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getLatestLitigation(long rootLitigationId){
		try{
			DynamicQuery dynaQuery =  DynamicQueryFactoryUtil.forClass(
					Litigation.class,
					PortletClassLoaderUtil.getClassLoader(LitigationConstants.PORTLET_ID));
			dynaQuery.add(PropertyFactoryUtil.forName(LitigationConstants.DB_CLMN_ROOT_LITIGATION_ID).eq(rootLitigationId));
			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.max(LitigationConstants.VERSION));
			proList.add(ProjectionFactoryUtil.max(LitigationConstants.DB_CLMN_LITIGATION_ID));
			//proList.add(ProjectionFactoryUtil.groupProperty(LitigationConstants.ROOT_LITIGATION_ID));
			dynaQuery.setProjection(proList);
			 
			return litigationLocalService.dynamicQuery(dynaQuery);
			
		}catch(Exception ex){
			_log.error(ex);
		}
		return null;
	}
	
	/**
	 * @param trademarkId
	 * @param country
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getLatestLitigationsByTrademarkId(long trademarkId) {

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Litigation.class,
					PortletClassLoaderUtil.getClassLoader(LitigationConstants.PORTLET_ID));

			dynamicQuery.add(PropertyFactoryUtil.forName(TrademarksConstants.DB_CLMN_TRADEMARKS_ID).eq(new Long(trademarkId)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.max(LitigationConstants.VERSION));
			proList.add(ProjectionFactoryUtil.max(LitigationConstants.DB_CLMN_LITIGATION_ID));
			proList.add(ProjectionFactoryUtil.groupProperty(LitigationConstants.DB_CLMN_ROOT_LITIGATION_ID));
			proList.add(ProjectionFactoryUtil.groupProperty(LitigationConstants.COUNTRY));
			dynamicQuery.setProjection(proList);

			return trademarksLocalService.dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;

	}
	
}