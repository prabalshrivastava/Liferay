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

package com.sambaash.platform.srv.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.pe.PEEntity;
import com.sambaash.platform.pe.PEEntityField;
import com.sambaash.platform.pe.PEEntityImpl;
import com.sambaash.platform.product.util.SPProductConstants;
import com.sambaash.platform.product.util.SPProductUtil;
import com.sambaash.platform.srv.NoSuchProductException;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.service.base.ProductLocalServiceBaseImpl;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.service.ProductLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.service.base.ProductLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.service.ProductLocalServiceUtil
 */
public class ProductLocalServiceImpl extends ProductLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.service.ProductLocalServiceUtil} to access the
	 * product local service.
	 */

	private static final Log _log = LogFactoryUtil.getLog(ProductLocalServiceImpl.class);
	public void clearCache() {
		productPersistence.clearCache();
	}
	
	public Product create() throws SystemException{
		long spProductId = CounterLocalServiceUtil.increment("Product.class");
		Product product = ProductLocalServiceUtil.createProduct(spProductId);
		return product;
	}

	public List<PEEntity> getPEEntityList(Integer start, Integer end) throws SystemException{
		start = GetterUtil.getInteger(start);
		end = GetterUtil.getInteger(end);
		List<Product> list = getProducts(start, end);
		List<PEEntity> entityList = new ArrayList<PEEntity>();
		for(Product product : list){
			entityList.add(getEntity(product));
		}
		return entityList;
	}
	public PEEntity getPEEntity(Long classPk) throws SystemException, PortalException{
		Product product = getProduct(classPk);
		PEEntity entity = getEntity(product);
		return entity;
	}
	
	public PEEntity getEntity(Product product){
		PEEntity peEntity = new PEEntityImpl();
		peEntity.setName(product.getProductName());
		peEntity.setDesc(product.getProductName());
		peEntity.setId(product.getSpProductId());
		try {
				AssetCategory category = AssetCategoryLocalServiceUtil.getAssetCategory(GetterUtil.getLong(product.getCountryId()));
				peEntity.setName1(product.getProductName() + " - " + category.getName());
				peEntity.setName(product.getProductName() + " - " + category.getName());
		} catch (Exception e) {
		}
		return peEntity;
	}
	
	public String customProductName(Product product){
		try {
				AssetCategory category = AssetCategoryLocalServiceUtil.getAssetCategory(GetterUtil.getLong(product.getCountryId()));
				if (Validator.isNotNull(category)){
					return product.getProductName() + " - " + category.getName();
				}
		} catch (PortalException | SystemException e) {
		}
		return product.getProductName();
	}
	
	public List<PEEntityField> getPEEntityFields(){
		List<PEEntityField> fields = new ArrayList<PEEntityField>();
		PEEntityField field = new PEEntityField();
		field.setId("testLink");
		field.setName("Entrance Test");
		field.setType(PEConstantsGlobal.FIELD_TYPE_TEXT);
		fields.add(field);
		return fields;
	}
	
	public String getPEEntityFieldValue(Long entityId, String fieldId) throws PortalException, SystemException{
		Product product = ProductLocalServiceUtil.getProduct(entityId);
		Course course = CourseLocalServiceUtil.getCourse(product.getSpCourseId());
		String value = StringPool.BLANK;
		if("testLink".equalsIgnoreCase(fieldId)){
			value = course.getTestLink();
		}
		else if("countryId".equalsIgnoreCase(fieldId)){
			value = course.getCountryId();
		}
		else if("countryName".equalsIgnoreCase(fieldId)){
			value = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(course.getCountryId())).getName();
		}
		return value;
	}
	
	public Product findByProductNameCountryId(String productname, String countryCode) throws NoSuchProductException, SystemException{
		return productPersistence.findByProductNameCounryId(productname, countryCode);
	}
	
	public List<Product> findByGroupIdAndCourseId(long groupId, long courseId) throws NoSuchProductException, SystemException{
		return productPersistence.findByGroupIdAndCourseId(groupId, courseId);
	}

	public boolean isQualificationTypeProduct(Product product){
		return SPProductUtil.isQualificationTypeProduct(product);
	}
	public boolean isQualificationTypeCourse(Course course){
		return SPProductUtil.isQualificationTypeCourse(course);
	}
	
	public List<Product> findByStatus(int status, int start, int end) throws NoSuchProductException, SystemException{
		return productPersistence.findByStatus(status, start, end);
	}
	public List<Product> getActiveProducts() throws SystemException{
		List<Product>list = productPersistence.findByStatus(SPProductConstants.ACTIVE, -1, -1);
		return  list;
	}
	
	public List<PEEntity> getPEEntityList(List<Long>entityIds) throws SystemException{
		long[]IdsTemp = new long[entityIds.size()];
		for (int i = 0; i < entityIds.size() ; i++) {
			IdsTemp[i] = entityIds.get(i);
		}
		List<Product> list  = productPersistence.findByproductIds(IdsTemp);
		List<PEEntity> entityList = new ArrayList<PEEntity>();
		for(Product product : list){
			entityList.add(getEntity(product));
		}
		return entityList;
	}
	
	public List<AssetCategory> getSpecializationCatgIds(Product product){
		List<AssetCategory> list = new ArrayList<AssetCategory>();
		try {
			AssetEntry asst = AssetEntryLocalServiceUtil.getEntry(Product.class.getName(),product.getSpProductId()	);
			if(asst != null){
				String vocName = GetterUtil.getString(SambaashUtil.getParameter("product.specialization.voc.id", 0));
				if(Validator.isNull(vocName)){
					vocName = SPProductConstants.SPECIALIZATION;
				}
				List<AssetCategory> productCtgs = asst.getCategories();
				AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(product.getGroupId(),
						vocName);
				for (AssetCategory assetCategory : productCtgs) {
					if(assetCategory.getVocabularyId() == assetVocabulary.getVocabularyId()){
						list.add(assetCategory);
					}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}
		return list;

	}
}