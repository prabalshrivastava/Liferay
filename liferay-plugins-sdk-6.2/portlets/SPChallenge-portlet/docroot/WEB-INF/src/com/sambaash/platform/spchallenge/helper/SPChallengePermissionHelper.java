package com.sambaash.platform.spchallenge.helper;

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
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeApplicantLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SPChallengePermissionHelper {
	private static final Log logger = LogFactoryUtil.getLog(SPChallengePermissionHelper.class);
	
	// Only non-markters can create startups
//	public static boolean canCreateChallenge1(User user,long scopeGroupId){
//		boolean create = false;
//		try {
//				create = SambaashUtil.isMarketer(user) || SambaashUtil.isAdmin(scopeGroupId, user.getUserId());
//		} catch (Exception e) {
//			logger.error("Error while checking marketer,admin role",e);
//		}
//		return create;
//	}
//	
//	public static boolean canCreateChallenge1(PortletRequest request, long scopeGroupId){
//		boolean create = false;
//		try{
//			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
//			if(themeDisplay.isSignedIn()){
//				User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
//				create =  canCreateChallenge(user, scopeGroupId);
//			}
//		}catch(Exception ex){
//			logger.error("Error while checking create challenge permissions " , ex);
//		}
//		return create;
//	}
	public static boolean canCreateChallenge(PortletRequest request){
		boolean create = false;
		try{
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			if (themeDisplay.isSignedIn()) {
				create = authorize(request, SPChallengeConstants.PORTLET_ID,
						SPChallengeConstants.ACTION_ADD_CHALLENGE)
						|| SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(),
								themeDisplay.getUserId());
			}
		}catch(Exception ex){
			logger.error("Error while checking create challenge permissions " , ex);
		}
		return create;
	}
	public static boolean canUpdateChallenge(PortletRequest request, long challengeId) {
		boolean canEdit = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		try {
			canEdit = authorize(request, SPChallengeConstants.PORTLET_ID,
					SPChallengeConstants.ACTION_EDIT_CHALLENGE)
					|| SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(),
							userId);
		} catch (Exception e) {
			logger.error("Error while checking challenge edit permission for [userId,challengeId] =" + userId + " " + challengeId,e);
		}
//		if (!canEdit && logger.isWarnEnabled()) {
//			logger.warn("Unauthorized user with id = " + userId + " trying to update challenge with id = " + challengeId);
//		}
		return canEdit;
	}
	public static boolean canUpdateApplication(long scopeGroupId,long userId, long applicationId){
		boolean canEdit = false;
		try {
			SPChallengeApplicant application = SPChallengeApplicantLocalServiceUtil.getSPChallengeApplicant(applicationId);
			//User user = UserLocalServiceUtil.getUser(userId);
			if( SambaashUtil.isAdmin(scopeGroupId, userId) ||  (userId == application.getUserId())){
				canEdit = true;
			}
			
		} catch (Exception e) {
			logger.error("Error while checking challenge application edit permission for [userId,challengeId] =" + userId + " " + applicationId,e);
		}
//		if (!canEdit && logger.isWarnEnabled()) {
//			logger.warn("Unauthorized user with id = " + userId + " trying to update challenge application with id = " + applicationId);
//		}
		return canEdit;
	}
	public static boolean canViewApplication(long scopeGroupId,long userId, long applicationId){
		boolean canView = false;
		try {
			SPChallengeApplicant application = SPChallengeApplicantLocalServiceUtil.getSPChallengeApplicant(applicationId);
			User user = UserLocalServiceUtil.getUser(userId);
			if( SambaashUtil.isAdmin(scopeGroupId, userId) || SambaashUtil.isMarketer(user) || (userId == application.getUserId())){
				canView = true;
			}
			
		} catch (Exception e) {
			logger.error("Error while checking challenge application view permission for [userId,challengeId] =" + userId + " " + applicationId,e);
		}
//		if (!canView && logger.isWarnEnabled()) {
//			logger.warn("Unauthorized user with id = " + userId + " trying to view challenge application with id = " + applicationId);
//		}
		return canView;
	}
	public static boolean canDeleteApplication(long scopeGroupId,long userId, long applicationId){
		boolean canDelete = false;
		try {
			//SPChallengeApplicant application = SPChallengeApplicantLocalServiceUtil.getSPChallengeApplicant(applicationId);
			User user = UserLocalServiceUtil.getUser(userId);
			if( SambaashUtil.isAdmin(scopeGroupId, userId) || SambaashUtil.isMarketer(user)){
				canDelete = true;
			}
			
		} catch (Exception e) {
			logger.error("Error while checking challenge application delete permission for [userId,challengeId] =" + userId + " " + applicationId,e);
		}
//		if(!canDelete && logger.isWarnEnabled()) {
//			logger.warn("Unauthorized user with id = " + userId + " trying to delete challenge application with id = " + applicationId);
//		}
		return canDelete;
	}
	public static boolean canDeleteChallenge(long scopeGroupId,long userId, long challengeId){
		boolean canDelete = false;
		try {
			  SPChallenge challenge = SPChallengeLocalServiceUtil.getSPChallenge(challengeId);
			  if( userId == challenge.getUserId()  || SambaashUtil.isAdmin(scopeGroupId, userId)){
				  canDelete = true;
			  }
			  
		} catch (Exception e) {
			logger.error("Error while checking challenge edit permission for [userId,challengeId] =" + userId + " " + challengeId,e);
		}
//		if (!canDelete && logger.isWarnEnabled()) {
//			logger.warn("Unauthorized user with id = " + userId + " trying to delete challenge with id = " + challengeId);
//		}
		return canDelete;
	}
	
	// To check, if the logged in user has permission to update given challenge applicaiton
	public static boolean canUpdateApplication(PortletRequest request, long applicationId){
		boolean canUpdate = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if(themeDisplay.isSignedIn()){
			canUpdate = canUpdateApplication(themeDisplay.getScopeGroupId(),themeDisplay.getUserId(), applicationId);
		}
		return canUpdate;
	}
	// To check, if the logged in user has permission to view given challenge applicaiton
	public static boolean canViewApplication(PortletRequest request, long applicationId){
		boolean canView = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if(themeDisplay.isSignedIn()){
			canView = canViewApplication(themeDisplay.getScopeGroupId(),themeDisplay.getUserId(), applicationId);
		}
		return canView;
	}

	// To check, if the logged in user has permission to delete given challenge
	public static boolean canDeleteChallenge(PortletRequest request, long challengeId){
		boolean delete = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if(themeDisplay.isSignedIn()){
			delete = canDeleteChallenge(themeDisplay.getScopeGroupId(),themeDisplay.getUserId(), challengeId);
		}
		return delete;
	}
	// To check, if the logged in user has permission to apply given challenge
	public static boolean canApplyChallenge(PortletRequest request, long orgId, long challengeId){
		boolean delete = false;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if(themeDisplay.isSignedIn()){
			delete = canApplyChallenge(themeDisplay.getScopeGroupId(),themeDisplay.getUserId(), challengeId, orgId);
		}
		return delete;
	}
	
	
	public static boolean canApplyChallenge(long scopeGroupId,long userId, long challengeId, long orgId){
		boolean canApply = true;
		try {
			  if(userId == 0 || challengeId == 0 || orgId == 0){
					return false;
			  }
			
			 SPChallenge challenge = SPChallengeLocalServiceUtil.getSPChallenge(challengeId);
			 boolean challengRunning = SPChallengeHelper.isChallengeRunning(challenge.getStartDate(), challenge.getEndDate());
			 boolean isChallengeActive = challenge.isActive();
			 
			 Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
			 boolean isOrgOwner = ( userId == org.getUserId());
			 
			 boolean startup = SambaashUtil.isStartup(UserLocalServiceUtil.getUser(userId));
			 
			 if(challengRunning && isChallengeActive && isOrgOwner && startup){
				 canApply = true;
			 }
			 
			 if(SambaashUtil.isAdmin(scopeGroupId, userId)){
				 canApply = true;
			 }
			
		} catch (Exception e) {
			logger.error("Error while chekcing challenge apply permission [userid challengeId orgId]" + userId + " " + challengeId + " " + orgId);
			logger.error(e.getMessage());
		}
//		if (!canApply && logger.isWarnEnabled()) {
//			logger.warn("Unauthorized user with id = " + userId + " orgid = " + orgId + "trying to apply for challenge with id = " + challengeId);
//		}
		return canApply;
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
//			logger.warn("Unauthorized access of " + action + " by user " + themeDisplay.getUserId());
			return false;
		} catch (Exception e) {
			logger.error("System error while checking permission for " + action + " by user " + themeDisplay.getUserId());
			return false;
		}
		return true;
	}
}
