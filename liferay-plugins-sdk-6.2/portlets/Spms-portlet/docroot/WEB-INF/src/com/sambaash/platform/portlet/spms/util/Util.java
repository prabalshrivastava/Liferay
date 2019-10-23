package com.sambaash.platform.portlet.spms.util;

/**
**/
public class Util {
/**
	public static User addUser(Map userMap, MembershipSubscription spms, ServiceContext serviceContext) {
		User user = null;
		long addUserId = 0;
		int COPR_CLAIMED = SambaashConstants.REGISTRATION.CORP_NOT_CLAIMABLE;
		try {
			long companyId = Long.parseLong(String.valueOf(userMap.get("companyId")));
			boolean autoPassword = Boolean.getBoolean(String.valueOf(userMap.get("autoPassword")));
			//boolean autoScreenName= Boolean.getBoolean(String.valueOf(userMap.get("autoScreenName")));
			boolean autoScreenName = true;
			String emailAddress = String.valueOf(userMap.get("emailAddress"));
			String firstName = String.valueOf(userMap.get("firstName"));
			String lastName = String.valueOf(userMap.get("lastName"));
			String openId = String.valueOf(userMap.get("OpenId"));
			String jobTitle = String.valueOf(userMap.get("jobTitle"));
			String screenName = String.valueOf(userMap.get("screenName"));
			//String screenName = "";
			long[] groupIds = (long[])userMap.get("groupIds");
			long[] organizationIds = (long[])userMap.get("organizationIds");
			long[] roleIds = (long[])userMap.get("roleIds");
			long[] userGroupIds = (long[])userMap.get("userGroupIds");
			boolean sendEmail = Boolean.getBoolean(String.valueOf(userMap.get("sendEmail")));
			sendEmail = true;
			String userType = String.valueOf(userMap.get("userType"));
			String memberPackage = String.valueOf(userMap.get("memberPackage"));
			String userRegistrationStatus = String.valueOf(userMap.get("userRegistrationStatus"));
			String password = String.valueOf(userMap.get("password"));
			String communityName = String.valueOf(userMap.get("communityName"));
			long scopeGroupId = Long.parseLong(String.valueOf(userMap.get("groupId")));
			long spmsId = Long.parseLong(String.valueOf(userMap.get("spms_Id")));
			String usrpckId = "";
			String usrpckName = "";

			usrpckId = spms.getMpId_1();
			usrpckName = spms.getMpName_1();

			_log.info(" user to be added to database ===" + "userType" + userType + "    emailAddress    " +emailAddress + "sendEmail**************" + sendEmail) ;
			try {
				User usrDet = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
				addUserId = usrDet.getUserId();
			}catch (Exception e){}
			String authURL = createAuthURL(emailAddress, communityName, scopeGroupId);
			_log.info("authURL : "+authURL);
			serviceContext.setAttribute("AuthURL", authURL);

			serviceContext.setAttribute("roleId", roleId);

			String portalUrl = getPortalUrl();

			_log.info("PortalUrl : "+portalUrl);

			serviceContext.setPortalURL(portalUrl);

			//add by yan check claim flow and if so don't use liferay api for send mail, use another mail template

			if (spms.getMpId_4().equals("claimFlow")) {
				sendEmail = false;
			}

			user = UserLocalServiceUtil.addUser(
					0L, companyId, autoPassword, password, password,
					autoScreenName, screenName, emailAddress, 0, openId,
					new Locale("en", "US"), firstName, "", lastName, 0, 0, true,
					BIRTH_MONTH, BIRTH_DAY, BIRTH_YEAR, jobTitle, groupIds,
					organizationIds, roleIds, userGroupIds, sendEmail,
					serviceContext);
			_log.info(" user in database ===" + user);

			//Add user profile basic
			//TODO Change the method to user UserProfileBasic Service as per new service
			String claimFlow = spms.getMpId_4();

			if ((claimFlow != null) && (claimFlow.equals("claimFlow"))) {
				USER_REGISTRATION_STATUS = "unverified";
				COPR_CLAIMED = SambaashConstants.REGISTRATION.COPR_CLAIMED;
			}

			_log.info("USER_REGISTRATION_STATUS ===" + USER_REGISTRATION_STATUS);

			if (user != null) {

//                UserProfileBasic basic = UserProfileBasicLocalServiceUtil.createUserProfileBasic((int) user.getUserId());

				SocialProfile socialProfile = SocialProfileLocalServiceUtil.createSocialProfile((int)user.getUserId());
				socialProfile.setCompanyId(user.getCompanyId());
				socialProfile.setUserRegistrationStatus(USER_REGISTRATION_STATUS);
				socialProfile.setUserType(userType);
				socialProfile.setMemberPackage(Long.valueOf(usrpckId));

//                UserProfileBasicLocalServiceUtil.updateUserProfileBasic(basic);

				SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);

				_log.info("userType : "+userType);
				//Scheduler for corporate registration Yan 20101215

				if (userType.equals(SambaashConstants.REGISTRATION.USER_TYPE_CORPORATE)) {

					long profileId = 0;

					if ((claimFlow != null) && (claimFlow.equals("claimFlow"))) {
						profileId = Long.parseLong(spms.getMporder_4());
						CorporateProfile corporateProfile = CorporateProfileLocalServiceUtil.getCorporateProfile(profileId);
		corporateProfile.setClaimed(COPR_CLAIMED);
		corporateProfile.setModifiedDate(new Date());
		corporateProfile.setMembershipId(Long.parseLong(usrpckId));
		CorporateProfileLocalServiceUtil.updateCorporateProfile(corporateProfile);

		CorporateProfileUser crpProfileUser = CorporateProfileUserLocalServiceUtil.addCorporateUser(user.getUserId(), profileId);
		CorporateProfileUser ProfileUser = CorporateProfileUserLocalServiceUtil.getCorporateProfileUser(crpProfileUser.getId());
		ProfileUser.setAdmin(true);
		ProfileUser.setDefaultAdmin(true);
		ProfileUser.setModifiedDate(new Date());
		CorporateProfileUserLocalServiceUtil.updateCorporateProfileUser(ProfileUser);
		_log.info("Corporate Registration Finished for claim profile");

		                //add by yan send mail
		                boolean withImage = true;
		                String userName = user.getFirstName()+" "+user.getLastName();
		                String corporateName = corporateProfile.getName();
		                claimFlowSendMail(profileId, userName, corporateName, authURL, withImage, user);

					}else {
	CorporateProfileUser corpProfileUser = CorporateProfileUserLocalServiceUtil.createCorporateProfile(user.getUserId());
	CorporateProfileUser crpProfileUser = CorporateProfileUserLocalServiceUtil.getCorporateProfileUser(corpProfileUser.getId());

	crpProfileUser.setModifiedDate(new Date());
	profileId = crpProfileUser.getProfileId();
	_log.info("corpProfileUser.getId() : "+crpProfileUser + profileId);
	CorporateProfileUserLocalServiceUtil.updateCorporateProfileUser(corpProfileUser);

	String corporateName = spms.getMpName_4();
	_log.info("corporateName : "+corporateName);
//	                CorporateProfileLocalServiceUtil.createCorpProfile(profileId, corporateName, usrpckId, user.getUserId());
	                CorporateProfile corporateProfile = CorporateProfileLocalServiceUtil.getCorporateProfile(profileId);
	                corporateProfile.setClaimed(COPR_CLAIMED);
	                corporateProfile.setModifiedDate(new Date());
	                CorporateProfileLocalServiceUtil.updateCorporateProfile(corporateProfile);
	                _log.info("Corporate Registration Finished ");
					}

	List<Role> addRoles = new ArrayList<Role>();
	try {
				addRoles = MembershipPackageServices_RolesLocalServiceUtil.getUserMembershipRoles(user.getUserId());

				long[] arrAddRoles = new long[addRoles.size()];

				for (int index = 0; index<addRoles.size(); index++) {
					arrAddRoles[index]= addRoles.get(index).getRoleId();
				}

				if (arrAddRoles.length>0)
				RoleLocalServiceUtil.addUserRoles((long)user.getUserId(), arrAddRoles);

			}catch (PortalException e) {
				_log.error("Exception while adding corporate user roles");
			}

			_log.info("Corporate Registration user added to user_roles");
				}
				//End corporate registration Yan 20101215
			}

		} catch (PortalException e) {
			_log.error(e);

			try {
			spms.setPpPaymentStatus(STATUS_COMPLETED);
			spms.setUserId(addUserId);
			spms.setShippingCompany("");
			MembershipSubscriptionLocalServiceUtil.updateMembershipSubscription(spms);
			}catch (SystemException ex) {
				_log.error(ex);
			}

			_log.info("spms" + spms);
		} catch (SystemException e) {
			_log.error(e);
		}

		spms.setUserId(user.getUserId());
		//set payment status to completed
		spms.setPpPaymentStatus(STATUS_COMPLETED);

		//set session id to ""
		spms.setShippingCompany("");
		spms.setUserName("");

		return user;
	}

	public static void addUserSubscriptionsByMpId(long userId, long mpId, long companyId,
			long scopeGroupId, Date createDate, Date modifiedDate) throws PortalException, SystemException {
		sambaash.platform.srv.subscription.service.NotificationSubscriptionLocalServiceUtil
			.addUserSubscriptionsByMpId(userId, mpId, companyId, scopeGroupId, createDate, modifiedDate);
	}

	public static void check(MembershipSubscription spms) throws Exception {

		String communityName = "";//getTypeValue(SambaashConstants.CURRENT_COMMUNITY_NAME);
		//membership package name
			boolean autoPassword = false;
			boolean autoScreenName = true;
			long[] groupIds = null;
			long[] organizationIds = null;
			long[] roleIds = null;
			long[] userGroupIds = null;

			long mpId = Long.parseLong(spms.getMpId_1());
			String mpName = spms.getMpName_1();
			String firstName = spms.getShippingFirstName();
			String lastName = spms.getShippingLastName();
			String emailAddress = spms.getShippingEmailAddress();
			String password = spms.getShippingCompany();
			long companyId = spms.getCompanyId();
			long spms_Id = spms.getMsId();

			pass = password;

			if (mpName == null || "".equals(mpName)) {
				throw new NoSuchOrganizationException();
			}

			//boolean isDuplicate = UserHelper.existUser(emailAddress);

			//if (isDuplicate) {
				//throw new DuplicateUserEmailAddressException();
			//}

			MembershipPackage spmp = MembershipPackageLocalServiceUtil.getMembershipPackage(mpId);

			roleId = spmp.getExtra1();

			Map userMap = new HashMap();
			userMap.put("spms_Id",spms_Id);
			userMap.put("companyId", companyId);
			userMap.put("autoPassword", autoPassword);
			userMap.put("autoScreenName", autoScreenName);
			userMap.put("emailAddress", emailAddress);
			userMap.put("firstName", firstName);
			userMap.put("lastName", lastName);
			userMap.put("OpenId", "");
			userMap.put("jobTitle", "");
			userMap.put("screenName", firstName);
			userMap.put("groupIds", groupIds);
			userMap.put("organizationIds", organizationIds);
			userMap.put("roleIds", roleIds);
			userMap.put("userGroupIds", userGroupIds);
			userMap.put("sendEmail", true);
			userMap.put("userType", spmp.getType());
			userMap.put("memberPackage", spmp.getMpId());
			userMap.put("userRegistrationStatus", "inactive");
			userMap.put("groupId", groupId);
			groupId = Long.parseLong(spmp.getExtra3());

			communityName = GroupLocalServiceUtil.getGroup(groupId).getName();

			_log.info("groupId "+groupId);
			_log.info("Community Name "+communityName + "autoScreenName $$$$$$$$$$$$$" + autoScreenName);

			userMap.put("communityName", communityName);

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setAttribute("userType", spmp.getType());
			serviceContext.setAttribute("memberPackage", mpName);
			serviceContext.setScopeGroupId(groupId);

			if (!PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD) {
				autoPassword = false;
				userMap.put("password", password);
				//objUserModel.setPassword(password);
			}

			addUser(userMap, spms, serviceContext);
	}

	public static void checkStatus() throws Exception {
		_log.info("Running Unprocessing Records: STATUS_DONE"+STATUS_DONE);
		List ls = MembershipSubscriptionLocalServiceUtil.findByMembershipSubscriptionPpPaymentStatus(STATUS_DONE);
		_log.info("Running Unprocessing Records: STATUS_DONE1"+STATUS_DONE + ls.size());

		if (ls != null) {
			_log.info("Running Unprocessing Records: "+ls.size());
		}
		else {
			_log.info("Running Unprocessing Records: No records fetched");
		}

		Iterator lsItr = ls.iterator();
		while (lsItr.hasNext()) {
			try {
			MembershipSubscription spms = (MembershipSubscription)lsItr.next();

			String scopeGroupId_str = SambaashConstants.DEFAULT_GROUP_ID;

			if (spms != null) {
				long mpId = Long.parseLong(spms.getMpId_1());
				MembershipPackage spmp = MembershipPackageLocalServiceUtil.getMembershipPackage(mpId);

				if (spmp != null) {
					scopeGroupId_str = spmp.getExtra3();
				}

	long scopeGroupId = 0;
	try {
	scopeGroupId = Long.valueOf(scopeGroupId_str);
	}catch (NumberFormatException nfe) {
	_log.info("Catch NumberFormatException when convert "+ scopeGroupId_str +" to Long type");
	}

				sessionId = spms.getUserName();
				//spms.getPpPaymentStatus().trim().equals("") &&
				_log.info("SESSIONID "+sessionId);

				if ((!sessionId.trim().equals("")) &&
					(!spms.getShippingEmailAddress().trim().equals(""))) {

					_log.info("Status Upgrade? : "+spms.getShippingStreet());

					//Membership subscription for upgrade membership

					if (spms.getShippingStreet().equals(STATUS_UPGRADE )) {
						upgradeMembershipSubscription(spms, scopeGroupId);

						User _user = UserLocalServiceUtil.getUserByEmailAddress(spms.getCompanyId(), spms.getShippingEmailAddress());

						if (_user != null) {
//							removeSubscription(_user.getUserId());
//							addUserSubscriptionsByMpId(_user.getUserId(), mpId, spms.getCompanyId(), scopeGroupId, new Date(), new Date());
						}

					}else {
						//Membership subscription for newly created user
						check(spms);
					}

					MembershipSubscriptionLocalServiceUtil.updateMembershipSubscription(spms);
				}
			}
		}catch (Exception e) {
			_log.error(e);
		}
		}
	}

	public static String createAuthURL(String emailAddress, String communityName, long scopeGroupId) {

		//String email = emailAddress.replace("@", "%40");

		String portalUrl = getPortalUrl();

		//String loginLink = portalUrl+"/web/"+communityName+"/membershipsubscription?p_p_id=58&p_p_state=maximized"+
															//"&_58_struts_action=%2Flogin%2Flogin&_58_login=";

		String loginLink = portalUrl+SambaashUtil.getCommunityPath(scopeGroupId)+"/home?p_p_id=58&p_p_state=maximized"+
		"&_58_struts_action=/login/login&_58_login=";

		//String redirect = loginLink+email+"&_58_clickauth="+email+
									//"&p_p_lifecycle=1&_58_isclick=1&_58_pass="+pass;

		String redirect = loginLink+emailAddress+"&_58_clickauth="+emailAddress+"&p_p_lifecycle=1";

		StringTokenizer st = new StringTokenizer(redirect, "&");
		String temp = new String();
		StringBuffer authURL = new StringBuffer();

		while (st.hasMoreTokens()) {
			temp = st.nextToken().toString();

			if (temp.contains("?")) {
				authURL = authURL.append(temp);
			} else {
				if (!temp.contains("p_p_mode") &&
					!temp.contains("saveLastPath") &&
					!temp.contains("p_p_lifecycle")) {
					authURL = authURL.append("&").append(temp);
				}
			}
		}

		authURL = authURL.append("&").append("p_p_lifecycle=1");
		authURL = authURL.append("&").append("_58_isclick=1");
		temp = authURL.toString();
		_log.info("temp : "+temp);

	 //   temp = EncrypDecrypHelper.encrypt(temp);

		temp = portalUrl + "/auth/athid=" + temp;
		return temp;
	}

	public static String getPortalUrl() {
		try {
		String virtualHost = "";
		String port = "";
		String _portalUrl = "";
		String protocol = SambaashConstants.PROTOCOL;

		SPParameters spParameter_virtualHost = SPParametersLocalServiceUtil.findBySPParametersGroupIdAndName(groupId, SambaashConstants.VIRTUALHOST);
		SPParameters spParameter_port = SPParametersLocalServiceUtil.findBySPParametersGroupIdAndName(groupId, SambaashConstants.PORT);

		virtualHost = spParameter_virtualHost.getValue();
		port = spParameter_port.getValue();
		_log.info("VirtualHost : "+virtualHost);
		_log.info("PortalUrl : "+protocol+""+virtualHost);

		if (port!= null) {
			if (port.trim().equals("")) {
			_portalUrl = protocol+virtualHost;

			}else {

			_portalUrl = protocol+virtualHost+StringPool.COLON + port;
			}

			}else {

			_portalUrl = protocol+virtualHost;
			}

		return _portalUrl;
		}catch (Exception exception) {
			_log.error("getPortalUrl Exception ::: "+exception.getMessage());
			return "";
		}
	}

	/**
	public static void removeSubscription(long userId) throws SystemException {
		sambaash.platform.srv.subscription.service.NotificationSubscriptionLocalServiceUtil
			.removeSubscriptionsByUserId(userId);
	}

	public static void upgradeMembershipSubscription(MembershipSubscription spms, long scopeGroupId) throws PortalException, SystemException, UnsupportedEncodingException {
		User u = UserLocalServiceUtil.getUserByEmailAddress(spms.getCompanyId(),
				spms.getShippingEmailAddress());

		if (u!= null) {
			String usrName = "";
			String usrMail = "";
			long usrMpId = 0;
			String mpNameFrom = "";
			String mpNameTo = "";

//			UserProfileBasic usrDetails = UserProfileBasicLocalServiceUtil.getUserProfileBasic(u.getUserId());
			SocialProfile usrDetails = SocialProfileLocalServiceUtil.getSocialProfile(u.getUserId());
			User userDet = UserLocalServiceUtil.getUser(u.getUserId());
			//usrName = usrDetails.getDisplayName();
			usrName = u.getFullName();
			usrMpId = usrDetails.getMemberPackage();
			_log.info("usrDetails *********************" + usrDetails);
			usrDetails.setMemberPackage(Long.valueOf(spms.getMpId_1()));
//			UserProfileBasicLocalServiceUtil.updateUserProfileBasic(usrDetails);
			SocialProfileLocalServiceUtil.updateSocialProfile(usrDetails);

			MembershipPackage usrMpDetailsFrom = MembershipPackageLocalServiceUtil.getMembershipPackage(usrMpId);
			mpNameFrom = usrMpDetailsFrom.getName();

			MembershipPackage usrMpDetailsTo = MembershipPackageLocalServiceUtil.getMembershipPackage(Long.parseLong(spms.getMpId_1()));
			mpNameTo = usrMpDetailsTo.getName();

			String portalUrl = getPortalUrl();

			_log.info("PortalUrl : "+portalUrl);

			SendMailImpl.sendEmail(mpNameFrom, Long.parseLong(spms.getMpId_1()), userDet, usrDetails, portalUrl, scopeGroupId);

			spms.setUserId(u.getUserId());
		}

		spms.setPpPaymentStatus(STATUS_COMPLETED);
		spms.setUserName("");
		//spms.setShippingStreet("");
		_log.info("upgraded : ");
	}

	private static void claimFlowSendMail(long corporateId, String userName, String corporateName, String authURL, boolean withImage, User user) {
		try {
			MailMessage mailMessage = CorporateProfileClaimLocalServiceUtil.getMailMessage(corporateName, authURL, groupId, corporateId, user);
			MailServiceUtil.sendEmail(mailMessage);
			_log.info("Done mail sending ");
		}catch (BeanLocatorException ble) {
			_log.error(" Services not yet initialized. ");
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}



	private static final String STATUS_COMPLETED ="Completed";

	private static final String STATUS_DONE = "Done";

	private static final String STATUS_UPGRADE = "upgrade";

//	private static String loginLink = portalURL+"/web/"+communityName+"/membershipsubscription?p_p_id=58&p_p_state=maximized"+
//														"&_58_struts_action=%2Flogin%2Flogin&_58_login=";

	private static Log _log = LogFactoryUtil.getLog(Util.class);

	private static int BIRTH_DAY = 1;

	private static int BIRTH_MONTH = 1;

	private static int BIRTH_YEAR = 1970;

	private static String USER_REGISTRATION_STATUS = SambaashConstants.REGISTRATION.USER_REGISTRATION_STATUS_INACTIVE;

	private static String USER_TYPE_CORPORATE = SambaashConstants.REGISTRATION.USER_TYPE_CORPORATE;

	private static long groupId = Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID);
	private static String pass = "";
	private static String portalURL = MembershipSubscriptionConfigurValue.SIT_URL.toString();
	private static String roleId;
	private static String sessionId;**/

}