/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
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
import com.liferay.portal.model.User;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.sambaash.platform.portlet.legalandcontract.util.ClassMasterConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.model.ClassMaster;
import com.sambaash.platform.srv.legalandcontract.service.ClassMasterLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.base.ClassMasterLocalServiceBaseImpl;

/**
 * The implementation of the class master local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.service.ClassMasterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.ClassMasterLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.ClassMasterLocalServiceUtil
 */
public class ClassMasterLocalServiceImpl extends ClassMasterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.ClassMasterLocalServiceUtil} to access the class master local service.
	 */
	private static Log _log = LogFactoryUtil
			.getLog(ClassMasterLocalServiceImpl.class);
	
	
	public void addNewClass(long userId, ClassMaster classMaster, long[] assetCategoryIds) {
		try {
			classMaster.setVersion(ClassMasterConstants.START_VERSION);
			classMaster.setRootSpClassId(classMaster.getSpClassId());
			addClass(userId,classMaster,assetCategoryIds);
			
		} catch (Exception ex) {
			_log.error(ex);
		}
	} 
	
	public void addClass(long userId, ClassMaster classMaster, long[] assetCategoryIds) throws Exception {
		try {
			User user = userPersistence.findByPrimaryKey(userId);
			classMaster.setCompanyId(user.getCompanyId());
			classMaster.setUserId(user.getUserId());
			classMaster.setUserName(user.getFullName());
			Date now = new Date();
			classMaster.setCreateDate(now);
			classMaster = classMasterPersistence.update(classMaster, false);
			// Asset
			updateAsset(classMaster.getUserId(), classMaster, assetCategoryIds, null,
								null);
			reIndex(classMaster,true);
			
		} catch (Exception ex) {
			_log.error(ex);
			throw ex;
		}
	}

	public void addNewClassVersion(long userId, long oldClassId,ClassMaster newClassMaster, long[] assetCategoryIds) {
		try {
			ClassMaster laInDb = getClassMaster(oldClassId);
			String version = laInDb.getVersion();
			version = Utils.getNextVersion(version);
			newClassMaster.setVersion(version);
			newClassMaster.setRootSpClassId(laInDb.getRootSpClassId());
			addClass(userId,newClassMaster,assetCategoryIds);
			reIndex(laInDb, false);
		
		} catch (Exception ex) {
			_log.error(ex);
		}
	}
	public void addNewClassVersion(long userId, ClassMaster oldClassMaster,ClassMaster newClassMaster, long[] assetCategoryIds) {
		try {
			String version = oldClassMaster.getVersion();
			version = Utils.getNextVersion(version);
			newClassMaster.setVersion(version);
			newClassMaster.setRootSpClassId(oldClassMaster.getRootSpClassId());
			addClass(userId,newClassMaster,assetCategoryIds);
			reIndex(oldClassMaster, false);
			
		} catch (Exception ex) {
			_log.error(ex);
		}
	}

	public ClassMaster getNewClassMaster() throws SystemException {
		ClassMaster classMaster = null;
		try {
			long classMasterId = counterLocalService.increment(getModelClassName());
			classMaster = ClassMasterLocalServiceUtil.createClassMaster(classMasterId);
		} catch (SystemException ex) {
			_log.error(ex);
			throw ex;
		}
		return classMaster;
	}

	private void reIndex(ClassMaster cm,boolean isLatest){
		Map<String,Object>map = new HashMap<String,Object>();
		map.put(ClassMasterConstants.CLASS_MASTER, cm);
		map.put(ClassMasterConstants.LATEST, isLatest);
		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());
		if (indexer != null) {
			try {
				indexer.reindex(map);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}
	public void updateAsset(long userId, ClassMaster classMaster,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		boolean visible = true;

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				classMaster.getGroupId(), getModelClassName(),
				classMaster.getSpClassId(), classMaster.getUuid(), 0, assetCategoryIds,
				assetTagNames, visible, null, null, classMaster.getCreateDate(),
				null, ContentTypes.TEXT_HTML, classMaster.getCode(), null,
				classMaster.getCode(), null, null, 0, 0, null, false);
		
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
	}
	
	public ClassMaster findByCodeCountry(String code,String country){
		ClassMaster cm = null;
		try {
			cm = classMasterPersistence.findByCodeCountry(code, country);
		} catch (Exception e) {
			_log.error(e);
		}
		return cm;
	}
	
	public ClassMaster getLatestClassByCodeCountry(String code,String country) throws Exception{
		ClassMaster cm = null;
		try{
			DynamicQuery dynaQuery =  DynamicQueryFactoryUtil.forClass(
					ClassMaster.class,
					PortletClassLoaderUtil.getClassLoader(ClassMasterConstants.PORTLET_ID));
			Criterion criterion1 = RestrictionsFactoryUtil.eq(ClassMasterConstants.COUNTRY,
					country);
			Criterion criterion2 = RestrictionsFactoryUtil.eq(ClassMasterConstants.CLASS_CODE,
					code);
			dynaQuery.add(RestrictionsFactoryUtil.and(criterion1, criterion2));
			List<ClassMaster> list = classMasterLocalService
					.dynamicQuery(dynaQuery);
			float latest = -1;float temp;
			for(ClassMaster ta: list){
				temp = Float.parseFloat(ta.getVersion());
				if(temp > latest){
					latest = temp;
					cm = ta;
				}
			}
		}catch(Exception ex){
			_log.error(ex);
			throw ex;
		}
		return cm;
	}
}