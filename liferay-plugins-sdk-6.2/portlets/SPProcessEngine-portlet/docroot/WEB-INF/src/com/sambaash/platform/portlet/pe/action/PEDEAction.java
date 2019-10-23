package com.sambaash.platform.portlet.pe.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.helpers.PEHelper;
import com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException;
import com.sambaash.platform.srv.processbuilder.model.PEDummyEntity;
import com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class PEDEAction
 */
public class PEDEAction extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(PEDEAction.class);
	
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		List<PEDummyEntity> peDummyEntity = null;

		try {
			peDummyEntity = PEDummyEntityLocalServiceUtil.getPEDummyEntities(-1, -1);
		} catch (SystemException e) {
			_log.debug(e);
		}

		request.setAttribute("listOfDummyEntities", peDummyEntity);
		super.render(request, response);
	}
	
	@Override
	public void serveResource(ResourceRequest req, ResourceResponse res) {
		try {
			switch(req.getResourceID()) {

				case "addNewDummyEntity" : addDummyEntity(req, res);break;
				case "retriveDummyEntityDetail" : loadSDummyEntityDetailInToResponseObj(req, res);break;
				case "editDummyEntity" : editDummyEntity(req, res);break;
				case "retrieveTableData":  retrieveTableData(req,res); break;
				case "searchDummyEntity":  searchDummyEntity(req,res); break;
				
			}
		}catch (Exception e) {
			_log.debug(e);
		}
	} 
	
	//add new dummy entity
	@SuppressWarnings("unchecked")
	protected static void addDummyEntity(ResourceRequest request, ResourceResponse response) throws SystemException{
		try	{
			JSONObject responseData = JSONFactoryUtil.createJSONObject();
			long spPEDummyEntityId = CounterLocalServiceUtil.increment("SPPEDummyEntity", 100);
			PEDummyEntity peDummyEntity = PEDummyEntityLocalServiceUtil.createPEDummyEntity(spPEDummyEntityId);
			
			String dummyEntityName = ParamUtil.getString(request, "dummyEntityName", StringPool.BLANK);
			
			List<PEDummyEntity> dummyEntityList = PEDummyEntityLocalServiceUtil.dynamicQuery(getSearchQueryDuplicate(dummyEntityName.trim()),-1,-1);
			
			if (dummyEntityList.size() > 0){
				responseData.put("duplicateFlag",true);
			} else{
			//set above fields
			peDummyEntity.setSpPEDummyEntityId(spPEDummyEntityId);
			peDummyEntity.setName(dummyEntityName); 

			Date now = new Date();
			peDummyEntity.setCreateDate(now);
			peDummyEntity.setModifiedDate(now);
			
			//set common fields
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			SambaashUtil.fillAudit(peDummyEntity, themeDisplay, peDummyEntity.isNew());

			PEDummyEntityLocalServiceUtil.addPEDummyEntity(peDummyEntity);
			responseData.put("duplicateFlag",false);
			}
			response.getWriter().write(responseData.toString());
			
			} catch (IOException e) {
				_log.debug(e);
			}
			
	}
		
	private static void streamWriter(ResourceResponse response, JSONObject jsonObject) {
			PrintWriter writer = null;
			try {
				writer = response.getWriter();
			} catch (IOException e1) {
				_log.error(e1.getMessage());
			}

			writer.print(jsonObject.toString());
			writer.flush();
			writer.close();
	}
	
	private static void retrieveTableData(ResourceRequest req, ResourceResponse res) throws SystemException {
		JSONArray dummyEntities = JSONFactoryUtil.createJSONArray();
		JSONObject obj=null;
		List<PEDummyEntity> dummyEntityList = PEDummyEntityLocalServiceUtil.getPEDummyEntities(-1, -1);
		for(PEDummyEntity dummyEntity : dummyEntityList){
			obj = JSONFactoryUtil.createJSONObject();
			obj.put("dummyEntityId",dummyEntity.getSpPEDummyEntityId());
			obj.put("dummyEntityName", dummyEntity.getName());
			obj.put("dummyEntityDateCreated", PEHelper.getDateStrddMMYYYYHMS(dummyEntity.getCreateDate()));
			
			dummyEntities.put(obj);
		}
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("dummyEntities", dummyEntities);

		streamWriter(res, jsonObject);
	}
 
	public static void loadSDummyEntityDetailInToResponseObj(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException {
		
		long spPEDummyEntityId = ParamUtil.getLong(request, "dummyEntityId", -1);

		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj = getDummyEntityDetailById(spPEDummyEntityId);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("dummyEntityDetail", obj);

		streamWriter(response, jsonObject);
	}
	
	private static JSONObject getDummyEntityDetailById(long spPEDummyEntityId) throws PortalException, SystemException{
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		PEDummyEntity peDummyEntity = PEDummyEntityLocalServiceUtil.getPEDummyEntity(spPEDummyEntityId);
			obj.put("dummyEntityId",peDummyEntity.getSpPEDummyEntityId());
			obj.put("dummyEntityName", peDummyEntity.getName());
			obj.put("dummyEntityDateCreated", peDummyEntity.getCreateDate());
			
		return obj;	
	}
	
	//edit dummy entity
	@SuppressWarnings("unchecked")
	protected static void editDummyEntity(ResourceRequest request, ResourceResponse response) throws SystemException, PortalException{
		try {
			JSONObject responseData = JSONFactoryUtil.createJSONObject();
			boolean duplicateFlag = false;
			long spPEDummyEntityId = ParamUtil.getLong(request, "dummyEntityId",1);
			PEDummyEntity peDummyEntity = PEDummyEntityLocalServiceUtil.getPEDummyEntity(spPEDummyEntityId);
			
			String dummyEntityName = ParamUtil.getString(request,"dummyEntityName", StringPool.BLANK);
		
			List<PEDummyEntity> dummyEntityList = PEDummyEntityLocalServiceUtil.dynamicQuery(getSearchQueryDuplicate(dummyEntityName.trim()),-1,-1);

			if (dummyEntityList.size() > 0){
				duplicateFlag = true;
				for (PEDummyEntity dummyEntity : dummyEntityList){
					if (dummyEntity.getSpPEDummyEntityId() == spPEDummyEntityId){
						duplicateFlag = false;
						break;
					}
				}
				
			}

			if (!duplicateFlag){
			//set below fields
			peDummyEntity.setName(dummyEntityName);

			Date now = new Date();
			peDummyEntity.setModifiedDate(now);

			PEDummyEntityLocalServiceUtil.updatePEDummyEntity(peDummyEntity);
			
			}
			
			responseData.put("duplicateFlag",duplicateFlag);
			response.getWriter().write(responseData.toString());
			
			} catch (IOException e) {
				_log.debug(e);
			}
			
	}
	
	@SuppressWarnings("unchecked")
	private static void searchDummyEntity(ResourceRequest req, ResourceResponse res) throws SystemException {
		
		String searchText = ParamUtil.getString(req, "searchText");
		JSONArray dummyEntities = JSONFactoryUtil.createJSONArray();
		JSONObject obj=null;
		List<PEDummyEntity> dummyEntityList = PEDummyEntityLocalServiceUtil.dynamicQuery(getSearchQuery(searchText.trim()),-1,-1);
		for(PEDummyEntity dummyEntity : dummyEntityList){
			obj = JSONFactoryUtil.createJSONObject();
			obj.put("dummyEntityId",dummyEntity.getSpPEDummyEntityId());
			obj.put("dummyEntityName", dummyEntity.getName());
			obj.put("dummyEntityDateCreated", PEHelper.getDateStrddMMYYYYHMS(dummyEntity.getCreateDate()));
			
			dummyEntities.put(obj);
		}
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("dummyEntities", dummyEntities);

		streamWriter(res, jsonObject);
	}
	
	public static  DynamicQuery getSearchQuery(String searchText) {
	
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PEDummyEntity.class,
				PortletClassLoaderUtil.getClassLoader(PEConstants.PORTLET_ID));
		
		Criterion searchTextCriteria = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + searchText + StringPool.PERCENT);
		
		if  (Validator.isNotNull(searchText)){ 
			dynamicQuery.add(searchTextCriteria);
		}
		
		return dynamicQuery;
			
	}

	public static  DynamicQuery getSearchQueryDuplicate(String searchText) {
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PEDummyEntity.class,
				PortletClassLoaderUtil.getClassLoader(PEConstants.PORTLET_ID));
		
		Criterion searchTextCriteria = RestrictionsFactoryUtil.ilike("name", searchText);
		
		if  (Validator.isNotNull(searchText)){ 
			dynamicQuery.add(searchTextCriteria);
		}
		
		return dynamicQuery;
			
	}

}
