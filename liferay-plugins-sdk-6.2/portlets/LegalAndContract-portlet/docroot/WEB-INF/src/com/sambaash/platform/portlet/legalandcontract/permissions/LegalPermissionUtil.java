package com.sambaash.platform.portlet.legalandcontract.permissions;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.ResourceAction;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.roles.model.SPRoles;
import com.sambaash.platform.srv.roles.service.SPRolesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class LegalPermissionUtil {
	
	private static Log _log = LogFactoryUtil.getLog(LegalPermissionUtil.class);

	public  List<AssetCategory> getPermissionedCountries(long userId,long groupId,long countryVocId){
		String exceptionCountries = getExceptionCountries();
		String userCountry = SambaashUtil.getUserCountry(userId);
		
		boolean includeAllCns = false;
		boolean highPreviligedRole = false;
		try {
			highPreviligedRole = isUserHavingRegionalRole(userId);
		} catch (Exception e) {
		}

		if(highPreviligedRole || ( Validator.isNotNull(userCountry) && exceptionCountries.toLowerCase().contains(userCountry.toLowerCase()) ) ){
			includeAllCns = true;
		}
		if(SambaashUtil.isAdmin(groupId, userId)){
			includeAllCns = true;
		}
		List<AssetCategory>list;
		if(includeAllCns){
			List<AssetCategory> countryList = getCountryList(countryVocId);
			list = countryList;
		}else{
			AssetCategory cat = Utils.getAssetCategory(countryVocId, userCountry);
			list = new ArrayList<AssetCategory>();
			if(Validator.isNotNull(cat)){
				list.add(cat);
			}
		}
		return list;
	}
	
	public  List<String> getPermissionedCountriesAsStringList(long userId,long groupId,long countryVocId){
		List<AssetCategory> acList = getPermissionedCountries(userId, groupId, countryVocId);
		List<String> list = new ArrayList<String>();
		if(Validator.isNotNull(acList)){
			for(AssetCategory cat: acList){
				list.add(cat.getName());
			}
		}
		return list;
	} 
	public  List<String> getUnPermissionedCountriesAsStringList(long userId,long groupId,long countryVocId){
		List<String> permCountries = getPermissionedCountriesAsStringList(userId, groupId, countryVocId);
		String exceptionCountries = getExceptionCountries();
		List<AssetCategory> countryList = getCountryList(countryVocId);
		boolean allCountryPerm = false;
		for(String country: permCountries){
			if(exceptionCountries.contains(country)){
				allCountryPerm = true;
				break;
			}
		}
		List<String> unPermCountries = new ArrayList<String>();
		if(allCountryPerm){
			return unPermCountries;
		}

		for(AssetCategory cat: countryList){
			if(!permCountries.contains(cat.getName())){
				unPermCountries.add(cat.getName());
			}
		}
	
		return unPermCountries;
	} 
	public List<SPRoles> getRoles(long userId,long groupId){
		List<SPRoles> roles = new ArrayList<SPRoles>();
		try{
			User user = UserLocalServiceUtil.getUser(userId);
			long[] roleIds = user.getRoleIds();
			if(Validator.isNotNull(roleIds)){
				for(long rolId: roleIds){
					roles.addAll(SPRolesLocalServiceUtil.findByRoleId(groupId, rolId));
				}
			}
		}catch(Exception ex){
			_log.error(ex);
		}
		return roles;
	}
	
	public String getExceptionCountries(){
		SPParameter spparm;
		String exceptionList = StringPool.BLANK;
		try {
			spparm = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(0,SambaashConstants.LEGAL_COUNTRY_EXCEPTION_LIST);
			exceptionList = spparm.getValue();
		} catch (Exception e) {
			_log.error(e);
		} 
		
		return exceptionList;
	}
	public List<AssetCategory> getCountryList(long countryVocId){
		List<AssetCategory> countryList = null;
		try {
		     countryList = AssetCategoryLocalServiceUtil.getVocabularyCategories(
		    		 countryVocId, -1, -1, null);
		} catch (Exception e) {
			_log.error(e);
		} 
		return countryList;
	}
	
	public boolean checkPermissionForUserOnCountry(long userId,long groupId,long countryVocId,String countryName){
		List<AssetCategory> clist = getPermissionedCountries(userId, groupId,countryVocId);
		boolean permissioned = false;
		for (AssetCategory cat : clist) {
			if(cat.getName().equalsIgnoreCase(countryName)){
				permissioned = true; break;
			}
		}
		return permissioned;
		
	}
	
	public static List<Role>  getRolesHavingAddEditTrademarksPermission() throws PortalException, SystemException{
		ResourceAction addAction =   ResourceActionLocalServiceUtil.getResourceAction(TrademarksConstants.PORTLET_ID,TrademarksConstants.ACTION_KEY_ADD_TRADEMARK);
		ResourceAction ediAction =   ResourceActionLocalServiceUtil.getResourceAction(TrademarksConstants.PORTLET_ID,TrademarksConstants.ACTION_KEY_EDIT_TRADEMARK);
		
		List<Role> roles = RoleLocalServiceUtil.getRoles(-1, -1);
		List<Role> permRoles = new ArrayList<Role>();
		for(Role role: roles){
			List<ResourcePermission>roleResources = ResourcePermissionLocalServiceUtil.getRoleResourcePermissions(role.getRoleId());
			for (ResourcePermission resourcePermission : roleResources) {
				if(TrademarksConstants.PORTLET_ID.equalsIgnoreCase(resourcePermission.getName())){
					boolean hasPermission = false;
					if( (resourcePermission.getActionIds() & addAction.getBitwiseValue()) == addAction.getBitwiseValue()){
						hasPermission = true;
					}
					if( (resourcePermission.getActionIds() & ediAction.getBitwiseValue()) == ediAction.getBitwiseValue()){
						hasPermission = true;
					}
					if(hasPermission){
						permRoles.add(role);
					}
				}
			}
		}
		
		return permRoles;
	}
	public static List<Role>  getRolesHavingAnyPermissionsOnPortlet(String portletId, List<String>permissions) throws PortalException, SystemException {
		List<ResourceAction> actions = new ArrayList<ResourceAction>();
		for(String actionStr:permissions){
			ResourceAction action =   ResourceActionLocalServiceUtil.getResourceAction(portletId,actionStr);
			actions.add(action);
		}
		List<Role> roles = RoleLocalServiceUtil.getRoles(-1, -1);
		List<Role> permRoles = new ArrayList<Role>();
		for(Role role: roles){
			List<ResourcePermission>roleResources = ResourcePermissionLocalServiceUtil.getRoleResourcePermissions(role.getRoleId());
			for (ResourcePermission resourcePermission : roleResources) {
				if(portletId.equalsIgnoreCase(resourcePermission.getName())){
					boolean hasPermission = false;
					
					for(ResourceAction action:actions){
						if( (resourcePermission.getActionIds() & action.getBitwiseValue()) == action.getBitwiseValue()){
							hasPermission = true;
							break;
						}
						
					}
					if(hasPermission){
						permRoles.add(role);
					}
				}
			}
		}
		
		return permRoles;
	}
	
	public static boolean isUserHavingRegionalRole(long userId) throws PortalException, SystemException{
		boolean authorized = false;
		User user = UserLocalServiceUtil.getUser(userId);
		List<Role> roles = user.getRoles();
		String temp = SambaashUtil.getParameter(SambaashConstants.LEGAL_HIGH_PRIVILIGED_ROLES,0);
		String []privilegedRoles = temp.split(",");
		
		if(Validator.isNotNull(roles)){
			for(Role role: roles){
				/*if(SambaashConstants.LEGAL_REGIONAL_ROLE_NAME.equalsIgnoreCase(role.getName())){
					authorized = true;
				}*/
				for(String prole:privilegedRoles){
					if(role.getName().equalsIgnoreCase(GetterUtil.getString(prole))){
						authorized = true;break;
					}
				}
			}
		}
		
		return authorized;
		
	}
	
	public static List<User> getUsersHavingRole(long companyId,String roleName){
		List<User> list = null;
		try {
				long roleId = RoleLocalServiceUtil.fetchRole(companyId, roleName).getRoleId();
				list = UserLocalServiceUtil.getRoleUsers(roleId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public static Set<User> getDefaultUsersToSendMails(long companyId){
		Set<User> set = new LinkedHashSet<User>();
		try {
			String rolesStr = SambaashUtil.getParameter(SambaashConstants.LEGAL_DEFAULT_ROLES_TO_SEND_MAILS,0);
			String []roles = rolesStr.split(StringPool.COMMA);
			for (String roleName : roles) {
				set.addAll(getUsersHavingRole(companyId, roleName));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return set;
		
	}
	
	
	
	public static void authorize(PortletRequest req, String portletName,String action)
			throws PrincipalException, PortalException, SystemException {
		// permission checker code
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		if(SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())){
			return;
		}
		long plid = layout.getPlid();
		PermissionChecker permissionChecker = PermissionThreadLocal
				.getPermissionChecker();
		try {
			PortletPermissionUtil.check(permissionChecker, plid,
					portletName, action);
		} catch (PrincipalException pe) {
			throw new PrincipalException(pe);
		}
	}
}
