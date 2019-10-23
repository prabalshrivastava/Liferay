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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.sambaash.platform.srv.legalandcontract.model.RDL;
import com.sambaash.platform.srv.legalandcontract.service.RDLLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.base.RDLLocalServiceBaseImpl;
import com.sambaash.platform.srv.legalandcontract.service.persistence.RDLUtil;


/**
 * The implementation of the r d l local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.legalandcontract.service.RDLLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.legalandcontract.service.base.RDLLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.legalandcontract.service.RDLLocalServiceUtil
 */
public class RDLLocalServiceImpl extends RDLLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.service.RDLLocalServiceUtil} to access the r d l local service.
	 */
	
	public List<RDL> findBylitigationId(long litigationId){
		try {
			return RDLUtil.findBylitigationId(litigationId);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		return new ArrayList<RDL>();
	}
	
	public RDL getNewRDL() throws SystemException {
		RDL rdl = null;
		try {
			long rdlId = counterLocalService.increment(getModelClassName());
			rdl = RDLLocalServiceUtil.createRDL(rdlId);
		} catch (SystemException ex) {
			_log.error(ex);
			throw ex;
		}
		return rdl;
	}

	public RDL addRDL(RDL rdl, long userId, long[] assetCategoryIds) throws Exception {
		try {
			User user = userPersistence.findByPrimaryKey(userId);
			rdl.setCompanyId(user.getCompanyId());
			rdl.setUserId(user.getUserId());
			rdl.setUserName(user.getFullName());
			Date now = new Date();
			rdl.setCreateDate(now);
			rdl = rdlPersistence.update(rdl, false);
			// Asset
			updateAsset(rdl.getUserId(), rdl, assetCategoryIds, null, null);
			 reIndex(rdl);

		} catch (Exception ex) {
			_log.error(ex);
			throw ex;
		}
		
		return rdl;
	}
	
	
	public void reIndex(RDL rdl){
		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());
		if (Validator.isNotNull(indexer) && Validator.isNotNull(rdl)) {
			try {
				indexer.reindex(rdl);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}
	
	public void updateAsset(long userId, RDL rdl,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		boolean visible = true;

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				rdl.getGroupId(), getModelClassName(),
				rdl.getSpRdlId(), rdl.getUuid(), 0, assetCategoryIds,
				assetTagNames, visible, null, null, rdl.getCreateDate(),
				null, ContentTypes.TEXT_HTML, String.valueOf(rdl.getSpRdlId()), null,
				String.valueOf(rdl.getSpRdlId()), null, null, 0, 0, null, false);
		
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				assetLinkEntryIds, AssetLinkConstants.TYPE_RELATED);
	}
	
	
	private static Log _log = LogFactoryUtil.getLog(RDLLocalServiceImpl.class.getName());
}