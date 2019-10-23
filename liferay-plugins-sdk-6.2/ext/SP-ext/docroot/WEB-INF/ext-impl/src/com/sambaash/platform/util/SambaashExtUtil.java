package com.sambaash.platform.util;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;

public class SambaashExtUtil {
	
	private static Log _log = LogFactoryUtil.getLog(SambaashExtUtil.class);
	
	/**
	 * Adding ExpandoTable place holder for adding values like custom table values
	 * @param companyId @mandatory parameter
	 * @param className
	 * @param tableName - can be null
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static ExpandoTable addTable(long companyId, String className, String tableName)
			throws PortalException, SystemException {
		
		if(!Validator.isNotNull(tableName)){
			tableName = ExpandoTableConstants.DEFAULT_TABLE_NAME;
		}
		
		ExpandoTable expandoTable = ExpandoTableLocalServiceUtil.getTable(companyId, className, tableName);
		
		if (Validator.isNotNull(expandoTable)) {
			return expandoTable;
		}
		expandoTable = ExpandoTableLocalServiceUtil.addTable(companyId,	className, tableName);
		return expandoTable;
	}

	/**
	 * 
	 * @param tableId
	 * @param fieldName
	 * @param type
	 * @param properties
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static ExpandoColumn addColumn(long tableId, String fieldName, int type, UnicodeProperties properties, Object defaultData) throws PortalException,
			SystemException {
		ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(tableId, fieldName);
		
		if (Validator.isNotNull(column)) {
			return column;
		}
		
		//ExpandoColumnConstants.STRING_ARRAY
		ExpandoColumn newColumn = ExpandoColumnLocalServiceUtil.addColumn(tableId, fieldName, type, defaultData);
		
		ExpandoColumnLocalServiceUtil.updateTypeSettings(newColumn.getColumnId(), properties.toString());
		return newColumn;
	}
	
	/**
	 * This method only executes if {@link SambaashConstants#SP_PARAM_FILTER_COUNTRY_PAGE} is present in SPParameter table.
	 * @param request
	 * @param friendlyURL
	 * @param companyId
	 * @param groupId
	 * @return Returns friendlyUrl based on the request IP address
	 * @throws Exception
	 */
	public static String updateFriendlyUrl(HttpServletRequest request, String friendlyURL, long companyId, long groupId, String i18nLanguageId) throws Exception{

		Boolean paramFilter = GetterUtil.getBoolean(SambaashUtil.getParameter(SambaashConstants.SP_PARAM_FILTER_COUNTRY_PAGE, 0), false);

		if(!paramFilter){
			return friendlyURL;
		}
		
		ExpandoTable expandoTable = addTable(companyId, Layout.class.getName(), null);
		UnicodeProperties properties = new UnicodeProperties();
		properties.setProperty("display-type", "selection-list");
		properties.setProperty("hidden", "0");
		properties.setProperty("index-type", "0");
		properties.setProperty("visible-with-update-permission", "1");

		Locale[] availaleLocales = LanguageUtil.getAvailableLocales(groupId);
		String a[] = new String[availaleLocales.length + 1];
		a[0] = "Not Applicable";
		for (int i = 0; i < availaleLocales.length; i++) {
			Locale locale = availaleLocales[i];
			a[i + 1] = locale.getDisplayLanguage() + " (" + locale.getDisplayCountry() + ")";
		}
		_log.debug("adding expando column");
		addColumn(expandoTable.getTableId(), SambaashConstants.SP_PARAM_COUNTRY_CUSTOM_NAME, ExpandoColumnConstants.STRING_ARRAY, properties, a);
		
		String newfriendlyURL = friendlyURL;
		if(Validator.isNotNull(i18nLanguageId)){
			i18nLanguageId = i18nLanguageId.replace(StringPool.FORWARD_SLASH, "");
		}
		if(StringUtil.equalsIgnoreCase(friendlyURL, StringPool.FORWARD_SLASH)){

			Group group = GroupLocalServiceUtil.getGroup(groupId);
			Layout defaultLayout = LayoutLocalServiceUtil.getLayout(group.getDefaultPublicPlid());
			newfriendlyURL = getChildFriendlyUrlForCountry(groupId, companyId, defaultLayout.getLayoutId(), i18nLanguageId, friendlyURL);
			
		}else if(Validator.isNotNull(friendlyURL)){

			try {
				String checkFriendlyUrl = friendlyURL.substring(friendlyURL.lastIndexOf(StringPool.FORWARD_SLASH));
				Layout layoutHome = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId, false, checkFriendlyUrl);
				newfriendlyURL = getChildFriendlyUrlForCountry(groupId, companyId, layoutHome.getLayoutId(), i18nLanguageId, friendlyURL);
				
			} catch (Exception e) {
				_log.error("no layout avaliable :: " + friendlyURL);
			}
		}
		return newfriendlyURL;
	}
	
	/**
	 * This method will retrieve child layout and checks with country name provided, if matched child layout friendly URl will be returned
	 * @param groupId
	 * @param companyId
	 * @param layoutId
	 * @param countryName
	 * @param friendlyURL
	 * @return Returns child friendlyUrl or returns current friendlyUrl
	 */
	private static String getChildFriendlyUrlForCountry(long groupId, long companyId, long layoutId, String countryName, String friendlyURL){
		String newfriendlyURL = friendlyURL;
		_log.debug("countryName : " + countryName);
		if(!Validator.isNotNull(countryName)){
			return newfriendlyURL;
		}
		try {
			List<Layout> layoutList = LayoutLocalServiceUtil.getLayouts(groupId, false, layoutId);

			for (Layout layout : layoutList) {
				String[] string = (String[])ExpandoValueLocalServiceUtil.getData(companyId, Layout.class.getName(), 
						ExpandoTableConstants.DEFAULT_TABLE_NAME, SambaashConstants.SP_PARAM_COUNTRY_CUSTOM_NAME, 
						layout.getPlid());
				if(string != null && string.length > 0){
					String pageCountry = string[0];
					_log.debug("pageCountry : " + pageCountry);
					if(Validator.isNotNull(pageCountry) && pageCountry.toLowerCase().startsWith(countryName.toLowerCase())){
						newfriendlyURL = layout.getFriendlyURL();
						break;
					}	
				}
			}
		} catch (Exception e) {
			_log.error("no layout avaliable :: " + layoutId);
		}
		return newfriendlyURL;
	}

}
