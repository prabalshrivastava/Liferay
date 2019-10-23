package com.sambaash.platform.portlet.spinbox.helper;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.SambaashUtil;
public class LiferayMixUserWrapper {

	private static Log _log = LogFactoryUtil.getLog(LiferayMixUserWrapper.class);


    private long corpProfileId = 0;

    private long userId = 0;
    private User user;
    private boolean isCorporateUser = false;
    private boolean hasAccessGroupAdminService = false;

    public LiferayMixUserWrapper(long userId, long corpProfileId) throws Exception {
        this.userId = userId;
        this.corpProfileId = corpProfileId;
        try{
            user = UserLocalServiceUtil.getUser(userId);
        	isCorporateUser = false;
        }catch(NoSuchUserException nsue) {
        	_log.error("No such user exist with primary key :"+ userId);
        }
    }

    public LiferayMixUserWrapper(long userId) throws Exception {
        this.userId = userId;
        try{
            user = UserLocalServiceUtil.getUser(userId);
        	isCorporateUser = false;
		
        }catch(NoSuchUserException nsue) {
        	_log.error("No such user exist with primary key :"+ userId);
        }
    }
    public LiferayMixUserWrapper(User user) throws Exception {
    	this.userId = user.getUserId();
    	this.user = user;
    	isCorporateUser = false;
    }

    public long getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }

	public String getPublicPage() {
		return getDisplayURL();
	}

    public String getDisplayURL() {
    	String viewDetailUrl = "";

		if (Validator.isNotNull(user)) {
			viewDetailUrl = StringPool.SLASH + user.getScreenName();
		}
	

		return viewDetailUrl;
    }

	public String getFullName() {
	    String fullName = "";
		if (Validator.isNotNull(user)) {
			fullName = this.user.getFullName();
		}
		return fullName;
	}

	public String getEmailAddress() {
	    String emailAddress = "";

		if (Validator.isNotNull(user)) {
			emailAddress = this.user.getEmailAddress();
		}
	
		return emailAddress;
	}

	public boolean isCorporateUser() {
		return isCorporateUser;
	}

	public long getCorpProfileId() {
		return corpProfileId;
	}

	public boolean isHasAccessGroupAdminService(long scopeGroupId) {
		if (isCorporateUser) {
			hasAccessGroupAdminService = true;
		}else{
	    	hasAccessGroupAdminService = InboxUtil.checkAccessForService(user,
	    			SambaashUtil.getParameter(SambaashConstants.MEMBERSHIP_SERVICECOMPONENTS.GROUP_ADMIN, scopeGroupId));
		}
		return hasAccessGroupAdminService;
	}

}