package com.sambaash.platform.portlet.spinbox.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.spinbox.helper.InboxConstants;
import com.sambaash.platform.portlet.spinbox.helper.InboxRequestHelper;
import com.sambaash.platform.portlet.spinbox.helper.InboxUtil;
import com.sambaash.platform.srv.spinbox.model.IBMessage;
import com.sambaash.platform.srv.spinbox.model.IBMessageDetail;
import com.sambaash.platform.srv.spinbox.service.IBMessageDetailLocalServiceUtil;
import com.sambaash.platform.srv.spinbox.service.IBMessageLocalServiceUtil;

/**
 * Portlet implementation class Inbox
 */
public class InboxAction extends MVCPortlet {
	
	
	private static final Log logger = LogFactoryUtil
			.getLog(InboxAction.class);
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String view = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)).getParameter("view");
		renderRequest.setAttribute("initialView", GetterUtil.getString(view));
		super.doView(renderRequest, renderResponse);
	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String action = ParamUtil.getString(resourceRequest, InboxConstants.ACTION);
		if ("getMails".equalsIgnoreCase(action)) {
			try {
				resourceResponse.getWriter().write(InboxRequestHelper.getMyInboxList(resourceRequest).toString());
			} catch (SystemException e) {
				logger.error(e);
			} catch (PortalException e) {
				logger.error(e);
			}
		}
		if ("search".equalsIgnoreCase(action)) {
			try {
				resourceResponse.getWriter().write(InboxRequestHelper.search(resourceRequest).toString());
			} catch (Exception e) {
				logger.error(e);
			} 
		}
		if("archieveAndfetchData".equalsIgnoreCase(action)){
			try{
				 String msgDetailIds = ParamUtil.getString(resourceRequest, "msgDetailIds");
				 if(Validator.isNotNull(msgDetailIds)){
					 String[] ids = msgDetailIds.split(StringPool.COMMA);
					 for (String id : ids) {
						long msgId = GetterUtil.getLong(id);
						if(msgId != 0){
							try{
								 IBMessageDetail details = IBMessageDetailLocalServiceUtil.getIBMessageDetail(GetterUtil.getLong(id));
								 details.setArchived(true);
								 IBMessageDetailLocalServiceUtil.updateIBMessageDetail(details);
							}catch(Exception ex){
								logger.error(ex);
							}
						}
					}
					resourceResponse.getWriter().write(InboxRequestHelper.getMyInboxList(resourceRequest).toString());
				 }
			}catch(Exception ex){
				logger.error(ex);
			}
		}
		if("deleteAndfetchData".equalsIgnoreCase(action)){
			try{
				String msgDetailIds = ParamUtil.getString(resourceRequest, "msgDetailIds");
				if(Validator.isNotNull(msgDetailIds)){
					String[] ids = msgDetailIds.split(StringPool.COMMA);
					for (String id : ids) {
						long msgId = GetterUtil.getLong(id);
						if(msgId != 0){
							try{
								IBMessage msg = IBMessageLocalServiceUtil.getIBMessage(msgId);
								msg.setDeleteStatus(true);;
								IBMessageLocalServiceUtil.updateIBMessage(msg);
							}catch(Exception ex){
								logger.error(ex);
							}
						}
					}
					resourceResponse.getWriter().write(InboxRequestHelper.getMyInboxList(resourceRequest).toString());
				}
			}catch(Exception ex){
				logger.error(ex);
			}
		}
		if ("sendMsg".equalsIgnoreCase(action)) {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			try {
				String result = InboxRequestHelper.sendMessage(resourceRequest);
				if(result.equalsIgnoreCase("success")){
					json.put("msg", result);
				}else{
					json.put("errorMsg", result);
				}
			} catch (Exception e) {
				logger.error(e);
				json.put("errorMsg", "Error while sending msg");
			} 
			resourceResponse.getWriter().write(json.toString());
		}
		if ("saveAsDraft".equalsIgnoreCase(action)) {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			try {
				IBMessage msg = InboxRequestHelper.saveAsDraft(resourceRequest);
				if(Validator.isNotNull(msg)){
					json.put("msg", "success");
				}else{
					json.put("errorMsg", "Error While saving as draft");
				}
			} catch (Exception e) {
				logger.error(e);
				json.put("errorMsg", "Error While saving as draft");
			} 
			resourceResponse.getWriter().write(json.toString());
		}
		if ("updateMsgStatusRead".equalsIgnoreCase(action)) {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			try {
				long msgDetailId = ParamUtil.getLong(resourceRequest, "msgDetailId");
				boolean status  = false;
				if(msgDetailId != 0){
					status = InboxRequestHelper.updateMsgStatus(msgDetailId, InboxUtil.READ);
				}
				if(status){
					json.put("msg", "success");
				}else{
					json.put("errorMsg", "Error While updating msg status to read");
				}
			} catch (Exception e) {
				logger.error(e);
				json.put("errorMsg", "Error While updating msg status to read");
			} 
			resourceResponse.getWriter().write(json.toString());
		}
		 if ("getMailSuggestions".equalsIgnoreCase(action)) {
			
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				try {
					resourceResponse.getWriter().write(InboxRequestHelper.findUsers(resourceRequest, themeDisplay.getCompanyId()));
				} catch (Exception e) {
					logger.error("Error while fetching users");
				}
			}
		 if ("getMsgConversation".equalsIgnoreCase(action)) {
			 
			 resourceResponse.setContentType("application/json");
			 resourceResponse.setCharacterEncoding("utf-8");
			 try {
				 resourceResponse.getWriter().write(InboxRequestHelper.getMessageDetailThread(resourceRequest).toString());
			 } catch (Exception e) {
				 logger.error("Error while fetching users");
			 }
		 }
	}
}
