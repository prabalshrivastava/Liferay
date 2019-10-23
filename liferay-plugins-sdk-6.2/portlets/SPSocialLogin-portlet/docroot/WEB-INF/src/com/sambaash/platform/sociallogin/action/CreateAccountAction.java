package com.sambaash.platform.sociallogin.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.AddressCityException;
import com.liferay.portal.AddressStreetException;
import com.liferay.portal.AddressZipException;
import com.liferay.portal.CompanyMaxUsersException;
import com.liferay.portal.ContactFirstNameException;
import com.liferay.portal.ContactFullNameException;
import com.liferay.portal.ContactLastNameException;
import com.liferay.portal.DuplicateUserEmailAddressException;
import com.liferay.portal.DuplicateUserScreenNameException;
import com.liferay.portal.EmailAddressException;
import com.liferay.portal.GroupFriendlyURLException;
import com.liferay.portal.NoSuchCountryException;
import com.liferay.portal.NoSuchListTypeException;
import com.liferay.portal.NoSuchOrganizationException;
import com.liferay.portal.NoSuchRegionException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.OrganizationParentException;
import com.liferay.portal.PhoneNumberException;
import com.liferay.portal.RequiredFieldException;
import com.liferay.portal.RequiredUserException;
import com.liferay.portal.ReservedUserEmailAddressException;
import com.liferay.portal.ReservedUserScreenNameException;
import com.liferay.portal.TermsOfUseException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserIdException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.UserScreenNameException;
import com.liferay.portal.UserSmsException;
import com.liferay.portal.WebsiteURLException;
import com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.membershippolicy.SiteMembershipPolicyUtil;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.service.VirtualHostLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.security.util.SPAuthenticationUtil;
import com.sambaash.platform.sociallogin.util.SocialLoginConstants;
import com.sambaash.platform.sociallogin.util.SocialLoginUtils;
import com.sambaash.platform.srv.spservices.model.SPSiteSetup;
import com.sambaash.platform.srv.spservices.service.SPSiteLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;


public class CreateAccountAction extends BaseStrutsPortletAction {

	public void processAction(StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		
		HttpSession session = request.getSession();
		
		Boolean twitterLoginPending = (Boolean) session.getAttribute("TWITTER_USER_LOGIN_PENDING");

		if ((twitterLoginPending != null) && (twitterLoginPending.booleanValue())) {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
			Company company = themeDisplay.getCompany();

			if (!company.isStrangers()) {
				throw new PrincipalException();
			}
			try {
				addUserBySocialCreateAccount(actionRequest, actionResponse);
				sendLoginRedirect(request, response);
			} catch (Exception ex) {
				if (((ex instanceof DuplicateUserEmailAddressException))
						|| ((ex instanceof DuplicateUserScreenNameException)) || ((ex instanceof AddressCityException))
						|| ((ex instanceof AddressStreetException)) || ((ex instanceof AddressZipException))
						|| ((ex instanceof CaptchaMaxChallengesException)) || ((ex instanceof CaptchaTextException))
						|| ((ex instanceof CompanyMaxUsersException)) || ((ex instanceof ContactFirstNameException))
						|| ((ex instanceof ContactFullNameException)) || ((ex instanceof ContactLastNameException))
						|| ((ex instanceof EmailAddressException)) || ((ex instanceof GroupFriendlyURLException))
						|| ((ex instanceof NoSuchCountryException)) || ((ex instanceof NoSuchListTypeException))
						|| ((ex instanceof NoSuchOrganizationException)) || ((ex instanceof NoSuchRegionException))
						|| ((ex instanceof OrganizationParentException)) || ((ex instanceof PhoneNumberException))
						|| ((ex instanceof RequiredFieldException)) || ((ex instanceof RequiredUserException))
						|| ((ex instanceof ReservedUserEmailAddressException))
						|| ((ex instanceof ReservedUserScreenNameException)) || ((ex instanceof TermsOfUseException))
						|| ((ex instanceof UserEmailAddressException)) || ((ex instanceof UserIdException))
						|| ((ex instanceof UserPasswordException)) || ((ex instanceof UserScreenNameException))
						|| ((ex instanceof UserSmsException)) || ((ex instanceof WebsiteURLException))) {
					SessionErrors.add(actionRequest, ex.getClass(), ex);

					return;
				}
				throw ex;
			}

		} else {
			String country = ParamUtil.getString(actionRequest, "location");
			boolean agreedToTermsOfUse = ParamUtil.getBoolean(actionRequest, "agreedToTermsOfUse");

			String mobileNumberValue = ParamUtil.getString(actionRequest, "mobile_number");

			if (_log.isDebugEnabled()) {
				_log.debug("Country : " + country + " : AgreedToTermsOfUse : " + agreedToTermsOfUse
						+ " : Contact Number : " + mobileNumberValue);
			}

			if (SambaashUtil.LOGIN_CREATE_ACCOUNT_MOBILE_NUMBER && !Validator.isNumber(mobileNumberValue)) {
				SessionErrors.add(actionRequest, "invalid-contact-number");
				return;
			}

			if (SambaashUtil.LOGIN_CREATE_ACCOUNT_LOCATION && Validator.isNull(country)) {
				SessionErrors.add(actionRequest, "invalid-country");
				return;
			}

			if (SambaashUtil.LOGIN_CREATE_ACCOUNT_TERMS_OF_USE && !agreedToTermsOfUse) {
				SessionErrors.add(actionRequest, "must-agree-terms-of-use");
				return;
			}
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Company company = themeDisplay.getCompany();
			String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
			
			User existingUser = findUserByEmailAddress(company, emailAddress);
			boolean isValid = spAccountCreateValidation(existingUser, actionRequest, company.getCompanyId());
			if (!isValid) {
				Exception ex = new EmailAddressException();
				SessionErrors.add(actionRequest, ex.getClass(), ex);
				return;
			} else {
				if(existingUser==null) { // new Liferay user
					originalStrutsPortletAction.processAction(originalStrutsPortletAction, portletConfig, actionRequest,
							actionResponse);
				}
				try {
					User user = findUserByEmailAddress(company, emailAddress);
					if(existingUser==null) { // new Liferay user
						if (SambaashUtil.LOGIN_CREATE_ACCOUNT_TERMS_OF_USE) {
							UserLocalServiceUtil.updateAgreedToTermsOfUse(user.getUserId(), true);
						}
		
						if (SambaashUtil.LOGIN_CREATE_ACCOUNT_LOCATION || SambaashUtil.LOGIN_CREATE_ACCOUNT_MOBILE_NUMBER) {
							updateLocationAndMobileNumber(country, mobileNumberValue, user);
						}					
					}
					addSiteMembership(themeDisplay, user);
					addOrUpdateSPSiteUser(actionRequest, themeDisplay, user.getUserId(), user.getPassword());
					if(!SambaashConstants.SP_DEFAULT_LIFERAY_LOGIN.equals(SambaashUtil.getSPLoginType(company.getCompanyId()))) {
						sendRedirect(actionRequest, actionResponse, themeDisplay, emailAddress);
					}
				} catch (NoSuchUserException ne) {
					_log.error("User not found with email address : " + emailAddress);
				}
			}
		}
	}

	private void addSiteMembership(ThemeDisplay themeDisplay, User user) {
		SPAuthenticationUtil.addSiteMembership(themeDisplay, user);
	}

	private User findUserByEmailAddress(Company company, String emailAddress) {
		try {
			return UserLocalServiceUtil.getUserByEmailAddress(company.getCompanyId(), emailAddress);			
		} catch (Exception e) {
			return null;
		}
	}

	private void addOrUpdateSPSiteUser(ActionRequest actionRequest, ThemeDisplay themeDisplay, long userId, String encryptedPassword) 
	{
		SPAuthenticationUtil.addOrUpdateSPSiteUser(actionRequest, userId, encryptedPassword);
	}
	
 	private boolean spAccountCreateValidation(User existingLiferayUser, ActionRequest actionRequest, long companyId) {
		return SPAuthenticationUtil.spAccountCreateValidation(existingLiferayUser, actionRequest, companyId);
	}
	
	public String render(StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		return originalStrutsPortletAction.render(null, portletConfig, renderRequest, renderResponse);
	}

	public void serveResource(StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig,
			ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		originalStrutsPortletAction.serveResource(originalStrutsPortletAction, portletConfig, resourceRequest,
				resourceResponse);
	}

	public void addUserBySocialCreateAccount(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);

		HttpSession session = request.getSession();

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		Company company = themeDisplay.getCompany();

		boolean autoPassword = true;
		String password1 = null;
		String password2 = null;
		boolean autoScreenName = false;
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
		long facebookId = ParamUtil.getLong(actionRequest, "facebookId");
		String openId = ParamUtil.getString(actionRequest, "openId");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		int prefixId = ParamUtil.getInteger(actionRequest, "prefixId");
		int suffixId = ParamUtil.getInteger(actionRequest, "suffixId");
		boolean male = ParamUtil.getBoolean(actionRequest, "male", true);
		int birthdayMonth = ParamUtil.getInteger(actionRequest, "birthdayMonth");
		int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");
		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = false;

		User existingUser = findUserByEmailAddress(company, emailAddress);
		boolean isValid = spAccountCreateValidation(existingUser, actionRequest, company.getCompanyId());
		if (!isValid) {
			Exception ex = new EmailAddressException();
			SessionErrors.add(actionRequest, ex.getClass(), ex);
			return;
		}
		
		String socialIdValue = ParamUtil.getString(actionRequest, SocialLoginConstants.TWITTERID);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);

		if (GetterUtil.getBoolean(PropsUtil.get("login.create.account.allow.custom.password"))) {
			autoPassword = false;
			password1 = ParamUtil.getString(actionRequest, "password1");
			password2 = ParamUtil.getString(actionRequest, "password2");
		}

		User user = UserServiceUtil.addUserWithWorkflow(company.getCompanyId(), autoPassword, password1, password2,
				autoScreenName, screenName, emailAddress, facebookId, openId, themeDisplay.getLocale(), firstName,
				middleName, lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle,
				groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);

		UserLocalServiceUtil.updateLastLogin(user.getUserId(), user.getLoginIP());

		UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);

		ExpandoValueLocalServiceUtil.addValue(company.getCompanyId(), User.class.getName(),
				SocialLoginConstants.SOCIALLOGIN_EXPANDO_TABLE, SocialLoginConstants.TWITTER_USER_ID, user.getUserId(),
				socialIdValue);
		session.setAttribute(SocialLoginConstants.TWITTER_SESSION_ATTRIBUTE_ID, new Long(user.getUserId()));

		session.removeAttribute(SocialLoginConstants.TWITTER_SESSION_LOGINPENDING);

		String pictureUrl = ParamUtil.getString(actionRequest, SocialLoginConstants.TWITTER_FIELD_PICTURE_URL);

		if (user.getPortraitId() < 1 && Validator.isNotNull(pictureUrl)) {
			UserLocalServiceUtil.updatePortrait(user.getUserId(), SocialLoginUtils.urlToByte(pictureUrl));
		}

	}

	protected void sendLoginRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		PortletURL portletURL = PortletURLFactoryUtil.create(request, "164", themeDisplay.getPlid(), "RENDER_PHASE");

		portletURL.setWindowState(LiferayWindowState.POP_UP);

		portletURL.setParameter("struts_action", "/login/login_redirect");

		response.sendRedirect(portletURL.toString());
	}

	private void updateLocationAndMobileNumber(String location, String mobileNumber, User user) {
		Phone phone;
		int phoneTypeId = 0;
		List<Phone> phoneList = new ArrayList<Phone>();
		try {

			if (Validator.isNotNull(mobileNumber)) {
				List<ListType> listTypeList = ListTypeServiceUtil.getListTypes(Contact.class.getName() + ".phone");

				for (ListType listType : listTypeList) {
					if (listType.getName().equalsIgnoreCase("mobile-phone")) {
						phoneTypeId = listType.getListTypeId();
						break;
					}
				}

				phone = PhoneLocalServiceUtil.createPhone(CounterLocalServiceUtil.increment("Phone.class"));
				phone.setCompanyId(user.getCompanyId());
				phone.setClassName(Contact.class.getName());
				phone.setClassPK(0L);
				phone.setTypeId(phoneTypeId);
				phone.setUserId(user.getUserId());
				phone.setNumber(mobileNumber);
				phone.setPrimary(true);
				phone.setCreateDate(DateUtil.newDate());
				phone = PhoneLocalServiceUtil.updatePhone(phone);
				phoneList.add(phone);
			}
			SocialProfile socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(user.getUserId());

			if (Validator.isNotNull(location)) {
				socialProfile.setLocation(capitalize(location));
			}
			SocialProfileLocalServiceUtil.updateLocationAndMobileNo(socialProfile, phoneList);
		} catch (SystemException | PortalException e) {
			_log.error("Failed to update location and mobile number for userId : " + user.getUserId()
					+ " : mobileNumber : " + mobileNumber + " : location : " + location);
		}
	}

	protected void sendRedirect(
			ActionRequest actionRequest, ActionResponse actionResponse,
			ThemeDisplay themeDisplay, String login)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);

		String redirect = PortalUtil.escapeRedirect(
		ParamUtil.getString(actionRequest, "redirect"));
		PortletURL loginURL = getLoginURL(request, themeDisplay.getPlid());
		loginURL.setParameter("login", login);
		redirect = loginURL.toString();
		actionResponse.sendRedirect(redirect);
	}
	
	public static String capitalize(String s) {
		if (s.length() == 0)
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

	public static PortletURL getLoginURL(HttpServletRequest request, long plid)
			throws PortletModeException, WindowStateException {

		PortletURL portletURL = PortletURLFactoryUtil.create(request, PortletKeys.LOGIN, plid,
				PortletRequest.RENDER_PHASE);

		portletURL.setParameter("saveLastPath", Boolean.FALSE.toString());
		portletURL.setParameter("struts_action", "/login/login");
		portletURL.setPortletMode(PortletMode.VIEW);
		portletURL.setWindowState(WindowState.MAXIMIZED);

		return portletURL;
	}
	
	private static Log _log = LogFactoryUtil.getLog(com.sambaash.platform.sociallogin.action.CreateAccountAction.class);

}