package com.sambaash.platform.startupprofile.helper;

import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.model.SPATOContacts;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.SPATOContactsLocalServiceUtil;
import com.sambaash.platform.startupprofile.StartupConstants;
import com.sambaash.platform.util.SambaashUtil;

public class StartupPermissionHelper {
	private static final Log logger = LogFactoryUtil.getLog(StartupPermissionHelper.class);
	
	// Only non-markters can create startups
	public static boolean canCreateStartup(User user){
		boolean create = false;
		try {
			create = !SambaashUtil.isMarketer(user);
		} catch (Exception e) {
			logger.error("Error while checking marketer role", e);
		}
		return create;
	}
	
	public static boolean canCreateStartup(long userId){
		boolean create = false;
		try{
			User user = UserLocalServiceUtil.getUser(userId);
			create =  canCreateStartup(user);
		}catch(Exception ex){
			logger.error("Error while checking marketer role" , ex);
		}
		return create;
	}
	public static boolean canCreateStartup(PortletRequest request){
		boolean create = false;
		try{
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			create =  canCreateStartup(user);
		}catch(Exception ex){
			logger.error("Error while checking marketer role" , ex);
		}
		return create;
	}
	
	public static boolean canUpdateStartup(long scopeGroupId,long userId, long orgId){
		boolean canEdit = false;
		try {
			   Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
			   User user = UserLocalServiceUtil.getUser(userId);
			   // Future: org.isIsBaseOrg() should be removed if related organization ( ex: competitor ) tries to register as startup
			   if( (userId == org.getUserId()) && org.isIsBaseOrg() && !SambaashUtil.isMarketer(user) ){
				   canEdit = true;
			   }
			   List<SPATOContacts> atoContacts = SPATOContactsLocalServiceUtil.findATOContactsByOrganizationId(orgId);
			   if(atoContacts.size() > 0){
				   if(atoContacts.get(0).getPrimaryPrincipalUserId().equalsIgnoreCase(String.valueOf(userId))  ||
						   atoContacts.get(0).getSecondaryPrincipalUserId().equalsIgnoreCase(String.valueOf(userId))   ){
					   canEdit = true;
				   }
				   
			   }
			   
			   // By pass foundry admin
			   if(SambaashUtil.isFoundryAdmin(user) || SambaashUtil.isAdmin(scopeGroupId, userId)){
				   canEdit = true;
			   }
		} catch (Exception e) {
			logger.error("Error while checking startup edit permission for [userId,orgId] =" + userId + ", " + orgId,e);
		}
		if (!canEdit && logger.isWarnEnabled())
			logger.warn("Unauthorized user with id = " + userId + " trying to update startup with id = " + orgId);
		return canEdit;
	}
	public static boolean canViewStartup(PortletRequest request, long orgId){
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if(themeDisplay.isSignedIn()){
			canView = canViewStartup(themeDisplay.getScopeGroupId(),themeDisplay.getUserId(), orgId);
		}
		return canView;
	}
	public static boolean canViewStartup(long scopeGroupId,long userId, long orgId){
		boolean canView = false;
		try {
			   Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
			   User user = UserLocalServiceUtil.getUser(userId);
			   // Future: org.isIsBaseOrg() should be removed if related organization ( ex: competitor ) tries to register as startup
			   if( (userId == org.getUserId()) || SambaashUtil.isMarketer(user) ){
				   canView = true;
			   }
			   List<SPATOContacts> atoContacts = SPATOContactsLocalServiceUtil.findATOContactsByOrganizationId(orgId);
			   if(atoContacts.size() > 0){
				   if(atoContacts.get(0).getPrimaryPrincipalUserId().equalsIgnoreCase(String.valueOf(userId))  ||
						   atoContacts.get(0).getSecondaryPrincipalUserId().equalsIgnoreCase(String.valueOf(userId))   ){
					   canView = true;
				   }
			   }
			   if(SambaashUtil.isAdmin(scopeGroupId, userId)){
				   canView = true;
			   }
		} catch (Exception e) {
			logger.error("Error while checking startup edit permission for [userId,orgId] =" + userId + ", " + orgId,e);
		}
		if (!canView && logger.isWarnEnabled())
			logger.warn("Unauthorized user with id = " + userId + " trying to update startup with id = " + orgId);
		return canView;
	}
	public static boolean canDeleteStartup(long scopeGroupId,long userId, long orgId){
		boolean canDelete = false;
		try {
			Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
			if( userId == org.getUserId() && org.isIsBaseOrg()){
				canDelete = true;
			}
			
			// By pass admin
			if(SambaashUtil.isAdmin(scopeGroupId, userId)){
				canDelete = true;
			}
		} catch (Exception e) {
			logger.error("Error while checking startup delete permission for [userId,orgId] =" + userId + " " + orgId,e);
		}
		if (!canDelete && logger.isWarnEnabled())
			logger.warn("Unauthorized user with id = " + userId + " trying to delete startup with id = " + orgId);
		return canDelete;
	}
	
	// To check, if the logged in user has permission to edit given organization
	public static boolean canUpdateStartup(PortletRequest request, long orgId){
		boolean canEdit = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if(themeDisplay.isSignedIn()){
			canEdit = canUpdateStartup(themeDisplay.getScopeGroupId(),themeDisplay.getUserId(), orgId);
		}
		return canEdit;
	}
//	// To check, if the logged in user has permission to view given organization
//	public static boolean canViewStartup(PortletRequest request, long orgId){
//		boolean canView = false;
//		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
//		if(themeDisplay.isSignedIn()){
//			canView = canViewStartup(themeDisplay.getScopeGroupId(),themeDisplay.getUserId(), orgId);
//		}
//		return canView;
//	}
	// To check, if the logged in user has permission to delete given organization
	public static boolean canDeleteStartup(PortletRequest request, long orgId){
		boolean delete = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if(themeDisplay.isSignedIn()){
			delete = canDeleteStartup(themeDisplay.getScopeGroupId(),themeDisplay.getUserId(), orgId);
		}
		return delete;
	}
	
	public static boolean authorize(PortletRequest req, String portletName,String action) {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		long plid = layout.getPlid();
		PermissionChecker permissionChecker = PermissionThreadLocal
				.getPermissionChecker();
		try {
			PortletPermissionUtil.check(permissionChecker, plid,
					portletName, action);
		} catch (PrincipalException pe) {
			logger.warn("Unauthorized access of " + action + " by user " + themeDisplay.getUserId());
			return false;
		} catch (Exception e) {
			logger.error("System error while checking permission for " + action + " by user " + themeDisplay.getUserId());
			return false;
		}
		return true;
	}
}
