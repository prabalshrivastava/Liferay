package com.sambaash.platform.portlet.spservices.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.sambaash.platform.portlet.spservices.util.SPServicesConstants;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;

public class SPServicesSearch  {

	private static Log _log = LogFactoryUtil.getLog(SPServicesSearch.class);
	protected static final String SEARCH_QUERY_PARAM =  "searchQueryJson";

	private PortletRequest request;
	private PortletResponse response;
	private ThemeDisplay themeDisplay ;
	

	public SPServicesSearch(PortletRequest request, PortletResponse response) {
		this.request = request;
		this.response = response;
		this.themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
	}
	
	public SearchContainer displaySearchSPParameter(String searchText, long groupId) throws WindowStateException, PortalException, SystemException {

		PortletURL actionUrl;
		List<SPParameter> results = null;
		PortletURL portletURL = getRenderUrl(SPServicesConstants.PORTLET_ID,groupId,searchText);

		List<String> headerNames = new ArrayList<String>();
		headerNames.add("SPParameter ID");
		headerNames.add("Group ID");
		headerNames.add("Name");
		headerNames.add("Value");
		headerNames.add("Edit");

		// create search container, used to display table
		SearchContainer searchContainer = new SearchContainer(request, null, null, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_DELTA, portletURL, headerNames, "There are no SPParameters to display");
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));

		results = getSPParameters(groupId,searchText,searchContainer.getStart(), searchContainer.getEnd());

		if (Validator.isNotNull(results)) {
			searchContainer.setTotal( getCount(groupId,searchText));
			// fill table
			List<ResultRow> resultRows = searchContainer.getResultRows();
			int length = results.size();

			for (int i = 0; i < length; i++) {
				SPParameter param = results.get(i);
				ResultRow row = new ResultRow(param, param.getSpParameterId(), i);

				row.addText(String.valueOf(param.getSpParameterId()));
				row.addText(String.valueOf(param.getGroupId()));
				row.addText(param.getName());
				row.addText(param.getValue());
				
		
				actionUrl = PortletURLFactoryUtil.create(request, SPServicesConstants.PORTLET_ID,
				themeDisplay.getPlid(), PortletRequest.ACTION_PHASE); 
				actionUrl.setWindowState(WindowState.MAXIMIZED);
				actionUrl.setParameter(SPServicesConstants.SPPARAMETER_ID, String.valueOf(param.getSpParameterId()));
				actionUrl.setParameter("javax.portlet.action", "displayEditSPParamters");
				
				row.addText("Edit", actionUrl.toString());
				
				resultRows.add(row);
			}
		}

		return searchContainer;
	}
	
	private PortletURL getRenderUrl(String portledId,long groupId,String searchText){
		PortletURL portletURL = PortletURLFactoryUtil.create(request, portledId, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		portletURL.setParameter(SPServicesConstants.GROUP_ID, String.valueOf(groupId));
		portletURL.setParameter(SPServicesConstants.SEARCH_TEXT, searchText);
		return portletURL;
	}

	
	@SuppressWarnings("unchecked")
	public  List<SPParameter> getSPParameters(long groupId, String searchText,int start,int end) {

		try {
			return SPParameterLocalServiceUtil.dynamicQuery(getSearchQuery(groupId, searchText),start,end);
		} catch (SystemException e) {
			_log.error(e);
		}

		return null;

	}
	
	@SuppressWarnings("unchecked")
	public  DynamicQuery getSearchQuery(long groupId, String searchText) {
		

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPParameter.class,
				PortletClassLoaderUtil.getClassLoader(SPServicesConstants.PORTLET_ID));
		//groupIdCriteria = null;
		
		Criterion groupIdCriteria = RestrictionsFactoryUtil.eq(SPServicesConstants.GROUP_ID, new Long(groupId));
		
		Criterion searchTextCriteria = RestrictionsFactoryUtil.like(SPServicesConstants.NAME, StringPool.PERCENT + searchText + StringPool.PERCENT);
		
		searchTextCriteria = RestrictionsFactoryUtil.or(searchTextCriteria, (RestrictionsFactoryUtil.like(SPServicesConstants.VALUE, StringPool.PERCENT + searchText + StringPool.PERCENT)));
		
		if  (Validator.isNotNull(searchText)){ 
			dynamicQuery.add(searchTextCriteria);
		}
		if ( (groupId != -1)){ 
			dynamicQuery.add(groupIdCriteria);
		}
		
		return dynamicQuery;
			
	}
	
	public  int getCount(long groupId, String searchText) throws SystemException {

		return (int)SPParameterLocalServiceUtil.dynamicQueryCount(getSearchQuery(groupId, searchText));
	}
}