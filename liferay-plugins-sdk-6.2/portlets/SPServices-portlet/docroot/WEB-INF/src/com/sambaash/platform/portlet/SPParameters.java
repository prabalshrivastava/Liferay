package com.sambaash.platform.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.spservices.search.SPServicesSearch;
import com.sambaash.platform.portlet.spservices.util.SPServicesConstants;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class SPParameters
 */
public class SPParameters extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SPParameters.class);
	

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		search(renderRequest, renderResponse);
		super.doView(renderRequest, renderResponse);

	}

	public void search(PortletRequest renderRequest,
			PortletResponse renderResponse) throws IOException,
			PortletException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			SPServicesSearch search = new SPServicesSearch(renderRequest,
					renderResponse);

			String spPrameterNameValue = ParamUtil.getString(renderRequest,
					SPServicesConstants.SEARCH_TEXT);
			long groupId = ParamUtil.getLong(renderRequest,
					SPServicesConstants.GROUP_ID);

			renderRequest.setAttribute("searchContainer", search
					.displaySearchSPParameter(spPrameterNameValue, groupId));

			setDisplayAddSPParameterUrl(search, renderRequest);

			List<Long> result = getGroupIds(themeDisplay);
			renderRequest.setAttribute("groups", result);

		} catch (Exception e) {
			_log.error("Error while getting trademarks", e);
		}
	}

	public void displayEditSPParamtersResult(ActionRequest actionRequest,
			ActionResponse actionResponse,SPParameter spparameter ) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		actionRequest.setAttribute(SPServicesConstants.SPPARAMETER_ID,
				spparameter.getSpParameterId());
		actionRequest.setAttribute(SPServicesConstants.GROUP_ID,
				spparameter.getGroupId());
		actionRequest.setAttribute(SPServicesConstants.NAME,
				spparameter.getName());
		actionRequest.setAttribute(SPServicesConstants.VALUE,
				spparameter.getValue());
		actionRequest.setAttribute("showhideSpan2", "hide");

		List<Long> result = getGroupIds(themeDisplay);

		actionRequest.setAttribute("groups", result);

		actionResponse.setRenderParameter("jspPage",
				"/html/spparameters/editSPParameter.jsp");
	}
	
	public void displayEditSPParamters(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		SPParameter spparameter = SPParameterLocalServiceUtil
				.getSPParameter(ParamUtil.getLong(actionRequest,
						SPServicesConstants.SPPARAMETER_ID));
		
		actionRequest.setAttribute(SPServicesConstants.SPPARAMETER_ID,
				spparameter.getSpParameterId());
		actionRequest.setAttribute(SPServicesConstants.GROUP_ID,
				spparameter.getGroupId());
		actionRequest.setAttribute(SPServicesConstants.NAME,
				spparameter.getName());
		actionRequest.setAttribute(SPServicesConstants.VALUE,
				spparameter.getValue());
		actionRequest.setAttribute("showhideSpan2", "hide");

		List<Long> result = getGroupIds(themeDisplay);

		actionRequest.setAttribute("groups", result);

		actionResponse.setRenderParameter("jspPage",
				"/html/spparameters/editSPParameter.jsp");
	}

	@SuppressWarnings("unchecked")
	public List<Long> getGroupIds(ThemeDisplay themeDisplay) {
		
		List<Long>groups = new ArrayList<Long>();

		groups.add(0, (long) 0);
		try {
			for(Group site: GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), 0, true)) {
				groups.add(site.getGroupId());
			}		
		} catch (Exception e) {
			_log.error(e);
		}
		return groups;

	}
	
	

	public void updateSPParameter(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		try {
		long spPrameterId = ParamUtil.getLong(actionRequest,
				SPServicesConstants.SPPARAMETER_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String name = ParamUtil.getString(actionRequest,
				SPServicesConstants.NAME);
		long groupId = ParamUtil.getLong(actionRequest,
				SPServicesConstants.GROUP_ID);
		String value = ParamUtil.getString(actionRequest,
				SPServicesConstants.VALUE);
		SPParameter paramTemp = SPParameterLocalServiceUtil
				.findBySPParameterGroupIdAndNameWithoutCreatingNewSPParameter(
						groupId, name);
		if(paramTemp != null && paramTemp.getSpParameterId() != spPrameterId){
			//error case
			SessionErrors.add(actionRequest, "spparameters.name.update.error");
			return;
		}
		SPParameter spParameter = null;
		String paramName = name;
		boolean add = true ;
		if(spPrameterId > 0 || (spPrameterId == 0 && paramName.equals(SambaashConstants.VIRTUALHOST))){
			//update
			spParameter = SPParameterLocalServiceUtil
					.getSPParameter(spPrameterId);
			add = false;
		}else{
			//Add
			spParameter = SPParameterLocalServiceUtil
					.getNewSPParameter();
			spParameter.setCreateDate(DateUtil.newDate());
		}
		
		spParameter.setUserId(themeDisplay.getUserId());
		

		//SambaashUtil.fillAudit(spParameter, themeDisplay, spParameter.isNew());
		
		spParameter.setName(name);
		spParameter.setGroupId(groupId);
		spParameter.setValue(value);
		
		spParameter.setModifiedDate(DateUtil.newDate());
		spParameter.setUserId(themeDisplay.getUserId());
		spParameter.setUserName(themeDisplay.getUser().getFullName());
		spParameter.setCompanyId(themeDisplay.getCompanyId());
		
		SPParameterLocalServiceUtil.updateSPParameter(spParameter);
		SambaashUtil.clearAllCaches();
		
		if(add){
			SessionMessages.add(actionRequest, "request_processed",
					"SPParameter has been added");
		}else{
			SessionMessages.add(actionRequest, "request_processed",
					"SPParameter has been updated");
		}
		
		
		displayEditSPParamtersResult(actionRequest, actionResponse,spParameter);
		
		}

		catch (Exception ex) {
			_log.error("Error while updating spparameters");
			_log.error(ex);
			
		}

	}

	public PortletURL setDisplayAddSPParameterUrl(SPServicesSearch search,
			PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL actionUrl = PortletURLFactoryUtil.create(request,
				SPServicesConstants.PORTLET_ID, themeDisplay.getPlid(),
				PortletRequest.ACTION_PHASE);
		try {
			actionUrl.setWindowState(WindowState.MAXIMIZED);
			actionUrl.setParameter("javax.portlet.action",
					"displayAddSPParameter");
			request.setAttribute("displayAddSPParameterURL", actionUrl);
		} catch (WindowStateException e) {
			_log.error("Error whiel setting window state", e);
		}
		return actionUrl;
	}

	public void displayAddSPParameter(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		List<Long> result = getGroupIds(themeDisplay);

		actionRequest.setAttribute("groups", result);
		actionRequest.setAttribute("showhide", "hide");
		actionRequest.setAttribute("showhideSpan1", "hide");
		actionResponse.setWindowState(WindowState.MAXIMIZED);
		actionResponse.setRenderParameter("jspPage",
				"/html/spparameters/editSPParameter.jsp");

	}

	public void searchSPParameter(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		search(actionRequest, actionResponse);
		List<Long> result = getGroupIds(themeDisplay);
		actionRequest.setAttribute("groups", result);
		actionRequest.setAttribute(SPServicesConstants.GROUP_ID,
				ParamUtil.getLong(actionRequest, SPServicesConstants.GROUP_ID));
		actionRequest.setAttribute(SPServicesConstants.SEARCH_TEXT, ParamUtil
				.getString(actionRequest, SPServicesConstants.SEARCH_TEXT));
		actionResponse.setWindowState(WindowState.MAXIMIZED);
		actionResponse.setRenderParameter("jspPage",
				"/html/spparameters/view.jsp");

	}

}
