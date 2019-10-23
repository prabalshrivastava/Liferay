package com.sambaash.platform.action.ajax;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.liferay.compat.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;

public class FetchDataTypeListActionHandler implements ServeResourceActionHandler {
	private Log _log = LogFactoryUtil.getLog(FetchActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		PortletPreferences preferences = request.getPreferences();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PEProcessState.class,
				PortletClassLoaderUtil.getClassLoader(PEConstantsGlobal.PORTLET_ID));

		JSONObject objMain = new JSONObject();
		int totalPage = 0;
		int itemsPerPage = 10;
		int pageIndex = 0;

		String userId = StringPool.BLANK;
		String userType = StringPool.BLANK;
		String startDate = StringPool.BLANK;
		String endDate = StringPool.BLANK;
		String searchText = StringPool.BLANK;
		String select1 = StringPool.BLANK;
		String select2 = StringPool.BLANK;
		String select3 = StringPool.BLANK;
		String select4 = StringPool.BLANK;
		try {

			long processId = Long.valueOf(preferences.getValue("processId", "0"));
			userType = preferences.getValue("userType", StringPool.BLANK);
			userId = request.getRemoteUser();

			select1 = preferences.getValue("select1", StringPool.BLANK);
			select2 = preferences.getValue("select2", StringPool.BLANK);
			select3 = preferences.getValue("select3", StringPool.BLANK);
			select4 = preferences.getValue("select4", StringPool.BLANK);
			searchText = request.getParameter("searchText").toLowerCase();

			if (!request.getParameter("itemsPerPage").isEmpty()) {
				itemsPerPage = Integer.parseInt(request.getParameter("itemsPerPage"));
			}
			if (!request.getParameter("pageIndex").isEmpty()) {
				pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			}

			if (userType.equalsIgnoreCase("Internal User")) {
				startDate = request.getParameter("startDate");
				endDate = request.getParameter("endDate");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");/// 05/16/2018

				if (startDate.length() > 0 && endDate.length() > 0) {
					Criterion criterion = RestrictionsFactoryUtil.between("createDate", dateFormat.parse(startDate),
							dateFormat.parse(endDate));
					dynamicQuery.add(criterion);
				} else if (startDate.length() > 0 && endDate.length() == 0) {
					Criterion criterion = RestrictionsFactoryUtil.between("createDate", dateFormat.parse(startDate),
							new Date());
					dynamicQuery.add(criterion);
				} else if (startDate.length() == 0 && endDate.length() > 0) {
					dynamicQuery.add(PropertyFactoryUtil.forName("createDate").le(dateFormat.parse(endDate)));
				}

			}

			_log.debug("totalPage = " + totalPage + "\n itemsPerPage = " + itemsPerPage + "\n pageIndex = " + pageIndex
					+ "\n preferencesProcessId = " + processId + "\n userId = " + userId + "\n userType = "
					+ userType + "\n startDate = " + startDate + "\n endDate = " + endDate + "\n searchText = "
					+ searchText);

			if (searchText.length() > 0) {
				Criterion criterion = RestrictionsFactoryUtil.like("data",
						new StringBuilder("%").append(searchText).append("%").toString());
				dynamicQuery.add(criterion);
			}

			if (userType.equalsIgnoreCase("User")) {
				dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.parseLong(userId)));
			}

			if (Validator.isNotNull(processId)) {
				dynamicQuery.add(PropertyFactoryUtil.forName("spPEProcessId").eq(processId));
			} else {
				_log.error("Could not retrieve select processId's from preferences.");
			}
			dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

			@SuppressWarnings("unchecked")
			List<PEProcessState> processAudit = PEProcessStateLocalServiceUtil.dynamicQuery(dynamicQuery);

			JSONArray jsonArr = new JSONArray();
			int count = 0;
			for (int i = (itemsPerPage * pageIndex); i < processAudit.size(); i++) {
				JSONObject obj = new JSONObject();
				try{
					obj.put("PEProcessStateId", processAudit.get(i).getSpPEProcessStateId());
					obj.put("PEProcessStateId", processAudit.get(i).getSpPEProcessStateId());
					obj.put("PEProcessStageId", processAudit.get(i).getSpPEProcessStageId());
					obj.put("UserId", processAudit.get(i).getUserId());
					obj.put("ModifiedDate", processAudit.get(i).getModifiedDate());
					obj.put("CreateDate", processAudit.get(i).getCreateDate());
					obj.put("Data", processAudit.get(i).getData());
					PEProcessState  processState = PEProcessStateLocalServiceUtil.getPEProcessState(processAudit.get(i).getSpPEProcessStateId());
					String status = processState.getStatus();
					obj.put("Status", status);  // processAudit.get(i).getStatus()
					if( !processAudit.get(i).getData().equalsIgnoreCase(StringPool.BLANK)){
						
						JSONObject contentObj = new JSONObject(processAudit.get(i).getData());
						
						obj.put("select1", contentObj.has(select1) ? contentObj.getString(select1) : StringPool.BLANK);
						obj.put("select2", contentObj.has(select2) ? contentObj.getString(select2) : StringPool.BLANK);
						obj.put("select3", contentObj.has(select3) ? contentObj.getString(select3) : StringPool.BLANK);
						obj.put("select4", contentObj.has(select4) ? contentObj.getString(select4) : StringPool.BLANK);
						jsonArr.put(obj);
						count = count + 1;
						
					}
				}catch(org.json.JSONException | PortalException e){
					_log.error(e);
				}
				
				if (count >= itemsPerPage) {

					break;
				
				}
			}
			try{
				objMain.put("List", jsonArr);
	
				int r = (((processAudit.size() % itemsPerPage) > 0) ? 1 : 0);
				int t = ((processAudit.size() > 0) ? (processAudit.size() / itemsPerPage) : 0);
	
				_log.debug("R = " + r + "\n T = " + t);
				totalPage = t + r;
	
				objMain.put("itemsPerPage", itemsPerPage);
				objMain.put("totalPage", totalPage);
				objMain.put("pageIndex", pageIndex);
			}
			catch(org.json.JSONException e){
				_log.error(e);
			}

			response.getWriter().write(StringPool.BLANK + objMain.toString());

		} catch (IOException | SystemException | ParseException e) {
			_log.error(e);
		}

	}

}
