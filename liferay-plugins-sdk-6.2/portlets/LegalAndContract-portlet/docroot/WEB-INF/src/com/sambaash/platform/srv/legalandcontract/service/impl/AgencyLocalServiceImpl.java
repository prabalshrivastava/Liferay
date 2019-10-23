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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.sambaash.platform.portlet.legalandcontract.util.AgencyConstants;
import com.sambaash.platform.portlet.legalandcontract.util.LegalConstants;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.model.Agency;
import com.sambaash.platform.srv.legalandcontract.service.AgencyLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.base.AgencyLocalServiceBaseImpl;
import com.sambaash.platform.util.filters.RemoveZeroPredicateFilter;

/**
 * The implementation of the agency local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.legalandcontract.service.AgencyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.legalandcontract.service.base.AgencyLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.legalandcontract.service.AgencyLocalServiceUtil
 */
public class AgencyLocalServiceImpl extends AgencyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.service.AgencyLocalServiceUtil} to access the
	 * agency local service.
	 */

	private static Log _log = LogFactoryUtil
			.getLog(AgencyLocalServiceImpl.class);

	public void addAgency(long userId, Agency agency, long[] assetCategoryIds) throws Exception{
		try {
			User user = userPersistence.findByPrimaryKey(userId);
			agency.setCompanyId(user.getCompanyId());
			agency.setUserId(user.getUserId());
			agency.setUserName(user.getFullName());
			agency.setNew(true);
			agency.setCreateDate(new Date());
			agency = agencyPersistence.update(agency, false);

		} catch (Exception ex) {
			ex = new Exception("Error while adding Agency",ex);
			_log.error(ex);
			throw ex;
		}
		// Asset
		try {
			updateAsset(agency.getUserId(), agency, assetCategoryIds, null,
					null);
		} catch (Exception e) {
		//	e = new Exception("Error while updating Agency Asset " + assetCategoryIds,e);
			_log.error(e.getMessage(),e);
			throw e;
		} 
		reIndex(agency);
	}
	
	public void addNewAgencyVersion(long userId, long oldAgencyId,Agency newAgency, long[] assetCategoryIds) throws Exception {
		Agency oldAgency = getAgency(oldAgencyId);
		addNewAgencyVersion(userId, oldAgency, newAgency, assetCategoryIds);
	} 
	
	public void addNewAgencyVersion(long userId, Agency oldAgency,Agency newAgency, long[] assetCategoryIds) throws Exception{
		String version = oldAgency.getVersion();
		version = Utils.getNextVersion(version);
		newAgency.setVersion(version);
		newAgency.setRootSpAgencyId(oldAgency.getRootSpAgencyId());
		newAgency.setNumber(oldAgency.getNumber());
		newAgency.setCountry(oldAgency.getCountry());
		addAgency(userId,newAgency,assetCategoryIds);
		reIndex(oldAgency);
	} 
	public void addNewAgency(long userId, Agency agency, long[] assetCategoryIds) throws Exception {
		agency.setVersion(AgencyConstants.START_VERSION);
		agency.setRootSpAgencyId(agency.getSpAgencyId());
		addAgency(userId,agency,assetCategoryIds);
	} 
	
	private void reIndex(Agency agency){
		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());
		if (indexer != null) {
			try {
				indexer.reindex(agency);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	public Agency getNewAgency() throws SystemException {
		Agency agency = null;
		try {
			long agencyId = counterLocalService.increment("Agency.class");
			agency = AgencyLocalServiceUtil.createAgency(agencyId);
			agency.setNew(true);
		} catch (SystemException ex) {
			_log.error(ex);
			throw ex;
		}
		return agency;
	}

	public void updateAsset(long userId, Agency agency,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		boolean visible = true;
		String str = "";
		if(Validator.isNotNull(assetCategoryIds)){
			for(long id:assetCategoryIds){
				str += id + ",";
			}
		}
		_log.debug("--------UpdateAsset Agency-----------------------------");
		_log.debug("userId="+userId + ", agency.getGroupId() = " + agency.getGroupId() + " , agency.getAgencyId() = " + agency.getSpAgencyId() +
				" , agency.getUuid()=" + agency.getUuid() + ", assetCategoryIds= " + str + ", assetTagNames= " + assetTagNames  + " agency.getName() = " +agency.getName());
		// filter 0's as they are not valid category ids.Else while fetching categories AssetCateogryLocalServiceUtil.getCategories will throw exception
		assetCategoryIds = ArrayUtil.filter(assetCategoryIds, new RemoveZeroPredicateFilter());
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				agency.getGroupId(), Agency.class.getName(),
				agency.getSpAgencyId(), agency.getUuid(), 0, assetCategoryIds,
				assetTagNames, visible, null, null, agency.getCreateDate(),
				null, ContentTypes.TEXT_HTML, agency.getName(), null,
				agency.getName(), null, null, 0, 0, null, false);
		_log.debug("--------UpdateAsset Agency Done-----------------------------");
		_log.debug("assetLinkEntryIds=" +assetLinkEntryIds + ", assetEntry.getEntryId()=" +assetEntry.getEntryId());
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
		_log.debug("--------updateLinks Agency Done-----------------------------");
	}

	
	public Agency findByNumberCountry(String number,String country){
		Agency agency = null;
		try{
			agency = agencyPersistence.findByNumberCountry(number, country);
		}catch(Exception ex){
			_log.error(ex);
		}
		return agency;
	}
	
	public Agency getLatestAgencyByNumberCountry(String number,String country){
		Agency agency = null;
		try{
			DynamicQuery dynaQuery =  DynamicQueryFactoryUtil.forClass(
					Agency.class,
					PortletClassLoaderUtil.getClassLoader());
//			Criterion criterion1 = RestrictionsFactoryUtil.eq(AgencyConstants.COUNTRY,
//					country);
			Criterion criterion1 = RestrictionsFactoryUtil.ilike(AgencyConstants.COUNTRY,
					country);
			Criterion criterion2 = RestrictionsFactoryUtil.ilike(AgencyConstants.NUMBER,
					number);
			dynaQuery.add(RestrictionsFactoryUtil.and(criterion1, criterion2));

			List<Agency> list = agencyLocalService
					.dynamicQuery(dynaQuery);
			float latest = -1;float temp;
			for(Agency ta: list){
				temp = Float.parseFloat(ta.getVersion());
				if(temp > latest){
					latest = temp;
					agency = ta;
				}
			}
		}catch(Exception ex){
			_log.error(ex);
		}
		return agency;
	}
	
	public Agency getLatestAgencyByNameCountry(String name,String country){
		Agency agency = null;
		try{
			DynamicQuery dynaQuery =  DynamicQueryFactoryUtil.forClass(
					Agency.class,
					PortletClassLoaderUtil.getClassLoader(AgencyConstants.PORTLET_ID));
			Criterion criterion1 = RestrictionsFactoryUtil.eq(AgencyConstants.COUNTRY,
					country);
			Criterion criterion2 = RestrictionsFactoryUtil.eq(AgencyConstants.NAME,
					name);
			dynaQuery.add(RestrictionsFactoryUtil.and(criterion1, criterion2));
			
			List<Agency> list = agencyLocalService
					.dynamicQuery(dynaQuery);
			float latest = -1;float temp;
			for(Agency ta: list){
				temp = Float.parseFloat(ta.getVersion());
				if(temp > latest){
					latest = temp;
					agency = ta;
				}
			}
		}catch(Exception ex){
			_log.error(ex);
		}
		return agency;
	}
	
	/**
	 * @param number
	 * @param country
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getLatestAgencyIdAndVersionNumber(String number, String country) {

		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Agency.class,
					PortletClassLoaderUtil.getClassLoader(AgencyConstants.PORTLET_ID));

			dynamicQuery.add(PropertyFactoryUtil.forName(AgencyConstants.NUMBER).eq(new String(number)))
					.add(PropertyFactoryUtil.forName(TrademarksConstants.COUNTRY).eq(new String(country)));

			ProjectionList proList = ProjectionFactoryUtil.projectionList();
			proList.add(ProjectionFactoryUtil.max(LegalConstants.VERSION));
			proList.add(ProjectionFactoryUtil.max(AgencyConstants.DB_CLMN_AGENCY_ID));
			proList.add(ProjectionFactoryUtil.groupProperty(AgencyConstants.NUMBER));
			proList.add(ProjectionFactoryUtil.groupProperty(AgencyConstants.COUNTRY));
			dynamicQuery.setProjection(proList);

			return trademarksLocalService.dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;

	}
}