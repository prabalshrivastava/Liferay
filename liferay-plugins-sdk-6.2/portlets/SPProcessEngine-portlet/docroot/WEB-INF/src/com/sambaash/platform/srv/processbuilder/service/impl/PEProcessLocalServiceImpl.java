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

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.pe.PEEntity;
import com.sambaash.platform.pe.PEEntityClassRegister;
import com.sambaash.platform.pe.PEEntityImpl;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.helpers.PEEntityHelper;
import com.sambaash.platform.portlet.pe.helper.ProcessStateActionHelper;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.base.PEProcessLocalServiceBaseImpl;
import com.sambaash.platform.srv.processbuilder.service.persistence.PEProcessUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

/**
 * The implementation of the p e process local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.processbuilder.service.PEProcessLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.processbuilder.service.base.PEProcessLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil
 */
public class PEProcessLocalServiceImpl extends PEProcessLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil}
	 * to access the p e process local service.
	 */

	public List<PEProcess> getPublished() throws SystemException {
		return PEProcessUtil.findBystatus(PEConstants.STATUS_PUBLISHED);
	}

	public List<PEProcess> findByProcessIds(long[] processIdsArr) throws SystemException {
		return peProcessPersistence.findByspPEProcessIds(processIdsArr);
	}

	public PEProcess create() throws SystemException {
		PEProcess peProcess = peProcessPersistence.create(counterLocalService.increment("PEProcess"));
		return peProcess;
	}

	public PEProcess findByName(String name) throws NoSuchPEProcessException, SystemException {
		return peProcessPersistence.findByProcessName(name);
	}

	public JSONObject getEntitiesListing(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			String servercall, long entityClassId, boolean formatJSON) {
		JSONObject data = JSONFactoryUtil.createJSONObject();
		if (!formatJSON) {
			if (!servercall.isEmpty() && servercall != null) {

				try {

					String modelData = PEEntityClassRegister.getServerCall(entityClassId);
					if (!modelData.isEmpty() && modelData != null) {
						resourceRequest.setAttribute("data", modelData);
						String elkListing = SystemLocalServiceUtil.getElasticSearchListing(resourceRequest,
								resourceResponse);
						data = JSONFactoryUtil.createJSONObject(elkListing);
					}
					// }
				} catch (Exception e) {
					_log.error("json exception " + e.getMessage());
				}
			} else {
				data = ProcessStateActionHelper.getEntityIdClassIdProcessIdJson();
			}
		} else {
			data = getEntitiesListingFormatedJSON(resourceRequest, resourceResponse, servercall, entityClassId);
		}
		return data;
	}

	public PEEntity getEntityDetail(long entityClassId, String entityId, long userId, long siteId) {
		PEEntity peEntity = null;
		JSONObject peEntityData = JSONFactoryUtil.createJSONObject();
		try{
			peEntity = PEEntityHelper.getEntity(entityClassId, Long.parseLong(entityId));
			if(Validator.isNull(peEntity)){
				peEntity = new PEEntityImpl();
				String formType = PEEntityClassRegister.getDisplayName(entityClassId);
				String entityRcordResponse = SystemLocalServiceUtil.fetchRecordByModelId(entityId,formType,userId, siteId);
				peEntity.setClassNameId(entityClassId);
				peEntity.setId(Long.parseLong(entityId));
				// peEntity.set
				peEntityData = JSONFactoryUtil.createJSONObject(entityRcordResponse);
				JSONObject entitySpecifiData = peEntityData.getJSONObject("contentJson");
				String entityName = entitySpecifiData.getString("ProgrammeTitle");
				peEntity.setName(entityName);
			}
		} catch (Exception e) {
			_log.error("Error in getting entity detail " + e.getMessage());
		}
		return peEntity;
	}

	public JSONArray getFeeDetailsForProcess(String storageId, String modelName, long userId, long siteId) {
		JSONArray defaultFeeRows = JSONFactoryUtil.createJSONArray();
		JSONObject pricingDetailData;
		String[] entityLinkArrayentityLink = storageId.split(",");

		for (int j = 0; j < entityLinkArrayentityLink.length; j++) {
			String pricingDetails = SystemLocalServiceUtil.fetchRecord(entityLinkArrayentityLink[j].trim(), modelName,
					userId, siteId);

			try {
				pricingDetailData = JSONFactoryUtil.createJSONObject(pricingDetails);
				// String priceDetails =
				// "{'PricingSchemeCode':'PSC001','PricingSchemeName':'PSC001','PricingDescription':'Pricing
				// Scheme
				// Modular','PricingCategory':'Subject','PricingType':'ExamModular','ModifiedOn':'19/11/2018','StartDate':'01/02/2019','EndDate':'30/05/2020','PromoCode':'','Status':'Active','SubSchemeDetails':[{'priceSubSchemeId':'PSSC001','taxCodeId':'','discountId':'Std-Graduate-Route-001-Half','ccyCode':'GBP','amount':132},{'priceSubSchemeId':'PSSC002','taxCodeId':'Singapore|GST7|2018-11-09T07:30:00+13:00','discountId':'','ccyCode':'SGD','amount':95},{'priceSubSchemeId':'PSSC003','taxCodeId':'','discountId':'Std-Graduate-Route-001-Full','ccyCode':'GBP','amount':264},{'priceSubSchemeId':'PSSC004','taxCodeId':'Singapore|GST7|2018-11-09T07:30:00+13:00','discountId':'','ccyCode':'SGD','amount':95},{'priceSubSchemeId':'PSSC005','taxCodeId':'','discountId':'Std-Graduate-Route-001-Law','ccyCode':'GBP','amount':264},{'priceSubSchemeId':'PSSC006','taxCodeId':'Singapore|GST7|2018-11-09T07:30:00+13:00','discountId':'','ccyCode':'SGD','amount':95}]}";
				JSONObject entitySpecifiData = pricingDetailData.getJSONObject("contentJson");
				// JSONObject entitySpecifiData =
				// pricingDetailData.getJSONObject(priceDetails);
				String subPriceSchema = entitySpecifiData.getString("SubSchemeDetails");
				JSONArray jsonContentArray = JSONFactoryUtil.createJSONArray(subPriceSchema);
				for (int i = 0; i < jsonContentArray.length(); i++) {
					JSONObject jsoninnerContent = JSONFactoryUtil.createJSONObject(jsonContentArray.getString(i));
					String subPricingDetails = SystemLocalServiceUtil.fetchRecord(
							jsoninnerContent.getString("priceSubSchemeId"), "PriceSubScheme", userId, siteId);
					JSONObject subPricingJSON = JSONFactoryUtil.createJSONObject(subPricingDetails);
					JSONObject subPricingcnt = JSONFactoryUtil
							.createJSONObject(subPricingJSON.getString("contentJson"));
					JSONObject fee = JSONFactoryUtil.createJSONObject();
					fee.put("feeLabel", subPricingcnt.getString("PriceSubSchemeName"));
					fee.put("feeType", subPricingcnt.getString("PriceType"));
					fee.put("feeSubType", subPricingcnt.getString("PriceSubType"));
					fee.put("formula", jsoninnerContent.getString("discountId"));
					fee.put("feeAmount", jsoninnerContent.getString("amount"));
					// fee.put("default", isDefault); // default will make
					// feetype uneditable and remove button wont displayed
					defaultFeeRows.put(fee);
				}
			} catch (JSONException e) {
				_log.error(e);
			}
		}
		return defaultFeeRows;

	}

	public double getTotalFeePayable(String storageId, String modelName, long userId, long siteId) {
		double totalFeePayable = 0;
		JSONArray defaultFeeRows = JSONFactoryUtil.createJSONArray();

		String[] entityLinkArrayentityLink = storageId.split(",");
		for (int j = 0; j < entityLinkArrayentityLink.length; j++) {
			defaultFeeRows = PEProcessLocalServiceUtil.getFeeDetailsForProcess(entityLinkArrayentityLink[j],
					"PriceScheme", userId, siteId);
			for (int i = 0; i < defaultFeeRows.length(); i++) {
				try {
					JSONObject fee = JSONFactoryUtil.createJSONObject(defaultFeeRows.getString(i));
					String amount = fee.getString("feeAmount");
					if (Validator.isNotNull(amount)) {
						totalFeePayable = totalFeePayable + Double.valueOf(amount);
					}
				} catch (JSONException e) {
					_log.error(e);
				}
			}

		}
		return totalFeePayable;

	}

	public JSONObject getEntitiesListingFormatedJSON(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			String servercall, long entityClassId) {
		JSONObject data = JSONFactoryUtil.createJSONObject();
		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject entityJ = null;

		try {
			List<PEEntity> entites = PEEntityHelper.getEntities(entityClassId, resourceRequest, resourceResponse);
			if (!entites.isEmpty()) {
				for (PEEntity entity : entites) {
					entityJ = JSONFactoryUtil.createJSONObject();
					entityJ.put("name", entity.getName());
					entityJ.put("id", entity.getId());
					array.put(entityJ);
				}
			} else {
				String modelData = PEEntityClassRegister.getServerCall(entityClassId);
				resourceRequest.setAttribute("data", modelData);
				String modelServiceResponse = SystemLocalServiceUtil.getElasticSearchListing(resourceRequest,
						resourceResponse);
				JSONObject data1 = JSONFactoryUtil.createJSONObject(modelServiceResponse);

				String jsonContent = data1.getString("content");

				JSONArray jsonContentArray = JSONFactoryUtil.createJSONArray(jsonContent);
				for (int i = 0; i < jsonContentArray.length(); i++) {
					entityJ = JSONFactoryUtil.createJSONObject();

					JSONObject jsoninnerContent = JSONFactoryUtil.createJSONObject(jsonContentArray.getString(i));

					entityJ.put("id", jsoninnerContent.getString("modelId"));
					String contentJSON = jsoninnerContent.getString("contentJson");
					JSONObject programeJson = JSONFactoryUtil.createJSONObject(contentJSON);
					entityJ.put("name", programeJson.getString("ProgrammeTitle"));
					entityJ.put("code", programeJson.getString("ProgrammeCode"));
					array.put(entityJ);
				}
			}
			data.put("entities", array);
		} catch (Exception e) {
			_log.error(e);
			data.put("error", "Error while accessing process data");
		}
		return data;

	}

	private static Log _log = LogFactoryUtil.getLog(PEProcessLocalServiceImpl.class);

}
