package com.sambaash.platform.timeline.ajax;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.constant.PEConstantsGlobal;
//import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
//import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
//import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;

public class FetchProcessListActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(FetchProcessListActionHandler.class.getName());

	// sppeprocessaudit
	@SuppressWarnings("unchecked")
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");/// 05/16/2018
//		PortletPreferences preferences = request.getPreferences();
//		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PEProcessAudit.class,
//				PortletClassLoaderUtil.getClassLoader(PEConstantsGlobal.PORTLET_ID));
//
//		List<PEProcessAudit> processsAuditList;
//
//		long specialRequestProcessId;
//		long enquiryProcessId;
//		long feedbackProcessId;
//
//		JSONObject objMain = new JSONObject();
//		int totalPage = 0;
//		int itemsPerPage = 10;
//		int pageIndex = 0;
//		long preferencesProcessId = 0;
//		String endDate = StringPool.BLANK;
//		String startDate = StringPool.BLANK;
//		String processes = StringPool.BLANK;
//		String pageIndexStr = "pageIndex";
//		String itemsPerPageStr = "itemsPerPage";
//		String totalPageStr = "totalPage";
//		String createDateStr = "createDate";
//		String formStr = " form";
//		String spPEProcessIdStr = "spPEProcessId";
//		System.out.println("hellllllooooo");
//		try {
//			endDate = request.getParameter("endDate");
//			startDate = request.getParameter("startDate");
//			processes = request.getParameter("processes");
//			specialRequestProcessId = Long.parseLong(preferences.getValue("SpecialRequestProcessId", "0"));
//			enquiryProcessId = Long.parseLong(preferences.getValue("EnquiryProcessId", "0"));
//			feedbackProcessId = Long.parseLong(preferences.getValue("FeedbackProcessId", "0"));
//
//			preferencesProcessId = Long.parseLong(preferences.getValue(processes, "0"));
//
//			if (!request.getParameter(itemsPerPageStr).isEmpty()) {
//				itemsPerPage = Integer.parseInt(request.getParameter(itemsPerPageStr));
//			}
//			if (!request.getParameter(pageIndexStr).isEmpty()) {
//				pageIndex = Integer.parseInt(request.getParameter(pageIndexStr));
//			}
//			if (preferencesProcessId > 0) {
//				dynamicQuery.add(PropertyFactoryUtil.forName(spPEProcessIdStr).eq(preferencesProcessId));
//			} else {
//				Criterion crit = null;
//				crit = RestrictionsFactoryUtil.eq(spPEProcessIdStr, specialRequestProcessId);
//				Criterion ep = RestrictionsFactoryUtil.eq(spPEProcessIdStr, enquiryProcessId);
//				Criterion fp = RestrictionsFactoryUtil.eq(spPEProcessIdStr, feedbackProcessId);
//				crit = RestrictionsFactoryUtil.or(crit, ep);
//				crit = RestrictionsFactoryUtil.or(crit, fp);
//				dynamicQuery.add(crit);
//			}
//
//			if (startDate.length() > 0 && endDate.length() > 0) {
//				Criterion criterion = RestrictionsFactoryUtil.between(createDateStr, dateFormat.parse(startDate),
//						dateFormat.parse(endDate));
//				dynamicQuery.add(criterion);
//			} else if (startDate.length() > 0 && endDate.length() == 0) {
//				Criterion criterion = RestrictionsFactoryUtil.between(createDateStr, dateFormat.parse(startDate),
//						new Date());
//				dynamicQuery.add(criterion);
//			} else if (startDate.length() == 0 && endDate.length() > 0) {
//				dynamicQuery.add(PropertyFactoryUtil.forName(createDateStr).le(dateFormat.parse(endDate)));
//			}
//
//			String userId = request.getRemoteUser();
//			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.parseLong(userId)));
//
//			processsAuditList = PEProcessStateLocalServiceUtil.dynamicQuery(dynamicQuery);
//			JSONArray jsonArr = new JSONArray();
//			int count = 0;
//			for (int i = (itemsPerPage * pageIndex); i < processsAuditList.size(); i++) {
//				JSONObject obj = new JSONObject();
//				obj.put("PEProcessStateId", processsAuditList.get(i).getSpPEProcessStateId());
//				obj.put("PEProcessStageId", processsAuditList.get(i).getSpPEProcessStageId());
//				obj.put("UserId", processsAuditList.get(i).getUserId());
//				obj.put("ModifiedDate", simpleDateFormat.format(processsAuditList.get(i).getModifiedDate()));
//				obj.put("CreateDate", simpleDateFormat.format(processsAuditList.get(i).getCreateDate()));
//				obj.put("Data", processsAuditList.get(i).getData1());
//				obj.put("Status", processsAuditList.get(i).getStatus());
//
//				String inf = StringPool.BLANK;
//				// PEProcessLocalServiceUtil.getPEProcess(processstate.get(i).getSpPEProcessId()).getName();
//
//				String processName = PEProcessLocalServiceUtil.getPEProcess(processsAuditList.get(i).getSpPEProcessId())
//						.getName();
//
//				if (processsAuditList.get(i).getType().equalsIgnoreCase("form")) {
//					if (processsAuditList.get(i).getAction().equalsIgnoreCase("submit")) {
//						inf += "Your have submited " + processName + formStr;
//					}
//
//				} else if (processsAuditList.get(i).getType().equalsIgnoreCase("status")) {
//					inf += "Status Change of  " + processName + formStr;
//				} else if (processsAuditList.get(i).getType().equalsIgnoreCase("mail")) {
//					inf += "Mail sent " + processName + formStr;
//				} else if (processsAuditList.get(i).getType().equalsIgnoreCase("msg")) {
//					inf += "Message sent " + processName + formStr;
//				} else {
//					inf += processsAuditList.get(i).getType().toUpperCase() + " " + processsAuditList.get(i).getAction()
//							+ " " + processName + formStr;
//
//				}
//				obj.put("Info", inf);
//				jsonArr.put(obj);
//				count = count + 1;
//				if (count >= itemsPerPage) {
//					break;
//				}
//			}
//			objMain.put("List", jsonArr);
//
//			int r = (((processsAuditList.size() % itemsPerPage) > 0) ? 1 : 0);
//			int t = ((!processsAuditList.isEmpty()) ? (processsAuditList.size() / itemsPerPage) : 0);
//
//			totalPage = t + r;
//			objMain.put(itemsPerPageStr, itemsPerPage);
//			objMain.put(totalPageStr, totalPage);
//			objMain.put(pageIndexStr, pageIndex);
//
//		} catch (Exception e) {
//			log.error(e.toString());
//		}
//
//		try {
//			response.getWriter().write(StringPool.BLANK + objMain.toString());
//
//		} catch (IOException e) {
//			log.error(e);
//		}

	}
}
