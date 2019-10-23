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

package com.sambaash.platform.srv.processbuilder.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.pe.PEEntity;
import com.sambaash.platform.pe.PEEntityField;
import com.sambaash.platform.pe.PEEntityImpl;
import com.sambaash.platform.srv.processbuilder.model.PEDummyEntity;
import com.sambaash.platform.srv.processbuilder.service.base.PEDummyEntityLocalServiceBaseImpl;

/**
 * The implementation of the p e dummy entity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author aishwarya
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEDummyEntityLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalServiceUtil
 */
public class PEDummyEntityLocalServiceImpl
	extends PEDummyEntityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalServiceUtil} to access the p e dummy entity local service.
	 */
	
	public PEEntity getPEEntity(Long classPk) throws SystemException, PortalException{
		PEDummyEntity peDummyEntity = peDummyEntityPersistence.fetchByPrimaryKey(classPk);
		PEEntity entity = getEntity(peDummyEntity);
		return entity;
	}
	
	public PEDummyEntity getDummyEntityByName(String name) throws SystemException, PortalException{
		PEDummyEntity peDummyEntity = peDummyEntityPersistence.findByName(name);
		return peDummyEntity;
	}
	
	public List<PEEntity> getPEEntityList(Integer start, Integer end) throws SystemException{
		start = GetterUtil.getInteger(start);
		end = GetterUtil.getInteger(end);
		List<PEDummyEntity> list = peDummyEntityPersistence.findAll(start, end);
		List<PEEntity> entityList = new ArrayList<PEEntity>();
		for(PEDummyEntity peDummyEntity : list){
			entityList.add(getEntity(peDummyEntityPersistence.fetchByPrimaryKey(peDummyEntity.getSpPEDummyEntityId())));
		}
		return entityList;
	}
	public List<PEEntity> getPEEntityList(List<Long>entityIds) throws SystemException{
		long[]IdsTemp = new long[entityIds.size()];
		for (int i = 0; i < entityIds.size() ; i++) {
			IdsTemp[i] = entityIds.get(i);
		}
		List<PEDummyEntity> list = peDummyEntityPersistence.findByentityIds(IdsTemp);
		List<PEEntity> entityList = new ArrayList<PEEntity>();
		for(PEDummyEntity peDummyEntity : list){
			entityList.add(getEntity(peDummyEntityPersistence.fetchByPrimaryKey(peDummyEntity.getSpPEDummyEntityId())));
		}
		return entityList;
	}
	
	public PEEntity getEntity(PEDummyEntity peDummyEntity){
		PEEntity peEntity = new PEEntityImpl();
		peEntity.setName(peDummyEntity.getName());
		peEntity.setDesc(peDummyEntity.getName());
		peEntity.setId(peDummyEntity.getSpPEDummyEntityId());
		peEntity.setName1(peDummyEntity.getName());
		return peEntity;
	}
	
	public List<PEEntityField> getPEEntityFields(){
		return null;
	}
	
	public String getPEEntityFieldValue(Long entityId, String fieldId) throws PortalException, SystemException{
		return StringPool.BLANK;
	}
}