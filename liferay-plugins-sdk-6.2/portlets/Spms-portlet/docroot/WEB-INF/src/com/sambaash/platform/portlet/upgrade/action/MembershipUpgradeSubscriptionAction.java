package com.sambaash.platform.portlet.upgrade.action;

/**
import sambaash.platform.spms.hlp.Util;
import sambaash.platform.srv.membershippackage.model.MembershipPackage;
import sambaash.platform.srv.membershippackage.model.MembershipPackagePromotionCode;
import sambaash.platform.srv.membershippackage.service.MembershipPackageLocalServiceUtil;
import sambaash.platform.srv.membershipsubscription.model.MembershipSubscription;
import sambaash.platform.srv.membershipsubscription.service.MembershipSubscriptionLocalServiceUtil;
import sambaash.platform.srv.membershipsubscription.util.SendMailImpl;
import sambaash.platform.srv.socialprofile.model.SocialProfile;
import sambaash.platform.srv.socialprofile.service.SocialProfileLocalServiceUtil;
import sambaash.platform.upgrade.bean.MembershipUpgradeBean;
import sambaash.platform.upgrade.service.MembershipUpgradeService;**/
import com.sambaash.platform.util.SambaashUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MembershipUpgradeSubscriptionAction
 */
public class MembershipUpgradeSubscriptionAction extends MVCPortlet {
/**
	static Log _log = LogFactoryUtil.getLog(MembershipUpgradeSubscriptionAction.class);

	private final static String _SUCCESS_MESSAGE = "Your membership package has been successfully upgraded from ";
	private final static String _NO_UPDATE_AVAILABLE = "No membership package available for Upgrade";
	private final static String _FAILED_MESSAGE = "Payment has not been processed successfully.";
	private final static String _NOTIFICATION = "/html/upgrade/notification.jsp";
	private final static String _NO_UPGRADE = "/html/upgrade/noUpgrade.jsp";
	private final static String _VIEW = "/html/upgrade/view.jsp";

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {

		ThemeDisplay _themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);

		long scopeGroupId = _themeDisplay.getScopeGroupId();

		long userId = _themeDisplay.getUserId();

		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		HttpSession session = request.getSession();

		String action = ParamUtil.getString(request, Constants.ACTION);

		_log.info("PROCESS ACTION : " + action);

		MembershipUpgradeBean membershipUpgrade = (MembershipUpgradeBean) session.getAttribute("membershipUpgrade");

		User user = this.getUserInfo(userId);

		long plid = 0;
		try {
			Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(_themeDisplay.getScopeGroupId(), false, _themeDisplay.getLayout()
					.getFriendlyURL());

			if (layout != null) {
				plid = layout.getPlid();
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		if (action.equals("cancel")) {
			String url = SambaashUtil.getCommunityPath(scopeGroupId) + StringPool.FORWARD_SLASH + "home";

			actionResponse.sendRedirect(url.toString());

		} else if (action.equals("payments")) {

			// * if net total is zero, meaning the paypal payment need not to

			 //* process else update the membership subscription and send
			 //* notification to user

			if (membershipUpgrade.getNetTotal() != 0) {
				try {
					this.getUpdateMembershipSubscription(membershipUpgrade, userId, "Pending");

				} catch (SystemException e) {
					_log.error(e.getMessage(), e);
				}

				PortletURL paypalURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), PortletKeys.LOGIN, plid,
						PortletRequest.ACTION_PHASE);

				paypalURL.setWindowState(WindowState.MAXIMIZED);
				paypalURL.setPortletMode(PortletMode.VIEW);

				paypalURL.setParameter("struts_action", "/login/paypal");
				paypalURL.setParameter("total", Double.toString(membershipUpgrade.getNetTotal()));
				paypalURL.setParameter("email", user.getEmailAddress());
				paypalURL.setParameter("firstname", user.getFirstName());
				paypalURL.setParameter("lastname", user.getLastName());
				paypalURL.setParameter("packagename", membershipUpgrade.getMembershipPackage().getName());
				paypalURL.setParameter("source", "upgrade");
				paypalURL.setParameter("promotion_code", membershipUpgrade.getMembershipPackage().getPromotionCode());
				paypalURL.setParameter("currency", membershipUpgrade.getMembershipPackage().getCostCurrency());
				paypalURL.setParameter("packageid", String.valueOf(membershipUpgrade.getMembershipPackage().getMpId()));

				actionResponse.sendRedirect(paypalURL.toString());
			} else {
				try {
					PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), portletName, plid,
							PortletRequest.RENDER_PHASE);

					this.processMembershipPackageWithNoPayment(membershipUpgrade, request, session, _themeDisplay, userId);

					redirectURL.setParameter("jspPage", _NOTIFICATION);
					actionResponse.sendRedirect(redirectURL.toString());

				} catch (Exception e) {
					_log.error(e);
				}
			}
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay _themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// String userId = renderRequest.getRemoteUser();

		long userId = _themeDisplay.getUserId();

		String action = SambaashUtil.getStringOriginalServletRequestParam(renderRequest, "action");

		_log.info("DO VIEW ACTION : " + action);

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		HttpSession session = httpServletRequest.getSession();

		SocialProfile socialProfile = this.getSocialProfile(userId);

		if (action.equals("") || action == null) {
			boolean isUpgradable = this.checkIfUpgradable(_themeDisplay);

			if (!isUpgradable) {
				include(_NO_UPGRADE, renderRequest, renderResponse);
			} else {
				super.doView(renderRequest, renderResponse);
			}

		} else {

			MembershipUpgradeBean membershipUpgrade = (MembershipUpgradeBean) session.getAttribute("membershipUpgrade");

			if (Validator.isNotNull(membershipUpgrade)) {

				// clear the success message

				membershipUpgrade.setMessageSuccess("");
				membershipUpgrade.setPromotionCode(null);
			}

			if (action.equals("paymentSuccess")) {
				try {
					this.processMembershipPackagePaymentCompleted(membershipUpgrade, httpServletRequest, session, userId);

				} catch (Exception e) {

					// _log.error(e);

				}

				include(_NOTIFICATION, renderRequest, renderResponse);

			} else if (action.equals("paymentCancel")) {
				try {
					this.getUpdateMembershipSubscription(membershipUpgrade, userId, "");

					String promoCode = "";

					if (!Validator.isNull(membershipUpgrade.getPromotionCode()))
						promoCode = membershipUpgrade.getPromotionCode().getPromotionCode();

					MembershipPackagePromotionCode mppc = MembershipUpgradeService.getMembershipPackagePromotionCode(membershipUpgrade
							.getMembershipPackage().getMpId(), promoCode);

					this.computeMembershipPackage(membershipUpgrade, mppc, membershipUpgrade.getMembershipPackage().getMpId());

					session.setAttribute("membershipUpgrade", membershipUpgrade);

					include(_VIEW, renderRequest, renderResponse);

				} catch (SystemException e) {
					_log.error(e.getMessage(), e);
				}

			}

		}

	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		ThemeDisplay _themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpSession session = httpServletRequest.getSession();

		long userId = _themeDisplay.getUserId();
		String action = resourceRequest.getParameter("action");

		_log.info("SERVE RESOURCE ACTION : " + action);

		MembershipUpgradeBean membershipUpgrade = (MembershipUpgradeBean) session.getAttribute("membershipUpgrade");

		SocialProfile socialProfile = this.getSocialProfile(userId);

		if (action.equals("selectSubscriptionList")) {

			// reset promo code

			if (Validator.isNotNull(membershipUpgrade.getPromotionCode()))
				membershipUpgrade.setPromotionCode(null);

			String mpId = resourceRequest.getParameter("membershipId");

			for (MembershipPackage mp : membershipUpgrade.getMembershipPackagesList()) {
				if (mp.getMpId() == Long.parseLong(mpId)) {
					membershipUpgrade.setMembershipPackage((MembershipPackage)mp.clone());

					String mps = membershipUpgrade.getMembershipPackageJsonString(mp);

					resourceResponse.getWriter().write(mps);
				}
			}

			session.setAttribute("membershipUpgrade", membershipUpgrade);

		} else if (action.equals("validatePromoCode")) {
			String strPromoCode = resourceRequest.getParameter("promoCode");
			String strPackageId = resourceRequest.getParameter("packageId");

			long mpId = Long.parseLong(strPackageId);

			String message = MembershipUpgradeService.getValidatePromotionCode(mpId, strPromoCode);

			if (message == "") {
				MembershipPackagePromotionCode mppc = MembershipUpgradeService.getMembershipPackagePromotionCode(mpId, strPromoCode);

				String response = this.computeMembershipPackage(membershipUpgrade, mppc, mpId);
				try {

					// to get the details of the selected package

					MembershipPackage membershipPackage = MembershipPackageLocalServiceUtil.getMembershipPackage(mpId);

					membershipUpgrade.setMembershipPackage(membershipPackage);

				} catch (PortalException e) {
					_log.error(e);
				} catch (SystemException e) {
					_log.error(e);
				}

				resourceResponse.getWriter().write(response);
				session.setAttribute("membershipUpgrade", membershipUpgrade);

			} else {
				resourceResponse.getWriter().write(message);
			}
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	private String computeMembershipPackage(MembershipUpgradeBean membershipUpgrade, MembershipPackagePromotionCode mppc, long mpId) {
		String strResponse = "";

		for (MembershipPackage mp : membershipUpgrade.getMembershipPackagesList()) {
			if (mp.getMpId() == mpId) {
				try {
					membershipUpgrade.getMembershipPackage().setDiscount(mppc.getDiscount());
				} catch (NullPointerException npe) {
					membershipUpgrade.getMembershipPackage().setDiscount("");
				}
			}
		}

		membershipUpgrade.setPromotionCode(mppc);

		// strResponse = membershipUpgrade
		// .getMembershipPackageJsonString(membershipUpgrade.getMembershipPackage());

		strResponse = membershipUpgrade.getMembershipPackageJsonString();

		return strResponse;
	}

	private void processMembershipPackagePaymentCompleted(MembershipUpgradeBean membershipUpgrade, HttpServletRequest httpServletRequest,
			HttpSession session, long userId) {
		try {
			SocialProfile socialProfile = this.getSocialProfile(userId);
			User user = this.getUserInfo(userId);

			List<MembershipSubscription> membershipSubscriptions = MembershipSubscriptionLocalServiceUtil.findByMembershipSubscriptionUserId(user
					.getUserId());
			long key = 0;

			for (MembershipSubscription ms : membershipSubscriptions) {
				key = ms.getPrimaryKey();
			}

			/***
			// * find the membership subscription

			MembershipSubscription membershipSubscription = MembershipSubscriptionLocalServiceUtil.getMembershipSubscription(key);

			/***
			// * if the membership payment status is completed then user will be
			// * notified

			if (membershipSubscription.getPpPaymentStatus().equals("Completed")) {
				String message = _SUCCESS_MESSAGE + membershipSubscription.getMpName_3() + " to " + membershipSubscription.getMpName_1();

				this.setMessageSuccess(session, membershipUpgrade, message);
			} else {
				this.setMessageSuccess(session, membershipUpgrade, _FAILED_MESSAGE);
			}

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

	}

	private void processMembershipPackageWithNoPayment(MembershipUpgradeBean membershipUpgrade, HttpServletRequest httpServletRequest,
			HttpSession session, ThemeDisplay _themeDisplay, long userId) {
		try {
			SocialProfile socialProfile = this.getSocialProfile(userId);
			User user = this.getUserInfo(userId);

			long smpId = socialProfile.getMemberPackage();

			MembershipPackage oldMemberPackage = MembershipPackageLocalServiceUtil.getMembershipPackage(smpId);

			/***
			// * Update membership package in social profile

			socialProfile.setMemberPackage(membershipUpgrade.getMembershipPackage().getMpId());
			SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);

			List<MembershipSubscription> membershipSubscriptions = MembershipSubscriptionLocalServiceUtil.findByMembershipSubscriptionUserId(user
					.getUserId());
			long key = 0;

			for (MembershipSubscription ms : membershipSubscriptions) {
				key = ms.getPrimaryKey();
			}

			/***
			// * Update membership subscription table

			this.getUpdateMembershipSubscription(membershipSubscriptions, membershipUpgrade, user, oldMemberPackage.getName());

			/***
			// * find the membership subscription

			MembershipSubscription membershipSubscription = MembershipSubscriptionLocalServiceUtil.getMembershipSubscription(key);

			/***
			// * if the membership payment status is blank meaning user has no *
			// bill to pay Upgrade without any charges e.g 100% discounted

			long groupId = PortalUtil.getScopeGroupId(httpServletRequest);

			if (membershipSubscription.getPpPaymentStatus().equalsIgnoreCase("")) {
				SendMailImpl.sendEmail(oldMemberPackage.getName(), membershipUpgrade.getMembershipPackage().getMpId(), user, socialProfile,
						Util.getPortalUrl(), groupId);
			}

			/***
			// * Membership subscription for upgrade membership

//			if (user != null) {
//				NotificationSubscriptionLocalServiceUtil.removeSubscriptionsByUserId(user.getUserId());
//
//				NotificationSubscriptionLocalServiceUtil.addUserSubscriptionsByMpId(user.getUserId(), membershipUpgrade.getMembershipPackage()
//						.getMpId(), _themeDisplay.getCompanyId(), _themeDisplay.getScopeGroupId(), new Date(), new Date());
//			}

			String message = _SUCCESS_MESSAGE + oldMemberPackage.getName() + " to " + membershipUpgrade.getMembershipPackage().getName();

			this.setMessageSuccess(session, membershipUpgrade, message);

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	private void getUpdateMembershipSubscription(MembershipUpgradeBean membershipUpgrade, long userId, String paymentStatus) throws SystemException {

		User user = this.getUserInfo(userId);

		List<MembershipSubscription> membershipSubscriptions = MembershipSubscriptionLocalServiceUtil.findByMembershipSubscriptionUserId(user
				.getUserId());

		MembershipSubscription membershipSubscription = null;

		for (MembershipSubscription ms : membershipSubscriptions) {
			membershipSubscription = (MembershipSubscription)ms.clone();
		}

		if (Validator.isNotNull(membershipSubscription)) {
			membershipSubscription.setPpPaymentStatus(paymentStatus);
			membershipSubscription.setShippingEmailAddress(user.getEmailAddress());
			membershipSubscription.setNettotal((float)membershipUpgrade.getNetTotal());

			MembershipSubscriptionLocalServiceUtil.updateMembershipSubscription(membershipSubscription);
		}
	}

	private void getUpdateMembershipSubscription(List<MembershipSubscription> membershipSubscriptions, MembershipUpgradeBean membershipUpgrade,
			User user, String previousPackageName) throws SystemException {
		if (Validator.isNotNull(membershipSubscriptions)) {
			MembershipSubscription membershipSubscription = null;

			for (MembershipSubscription ms : membershipSubscriptions) {
				membershipSubscription = (MembershipSubscription)ms.clone();
			}

			if (Validator.isNotNull(membershipSubscription)) {

				// should be the new updated package done by the user

				membershipSubscription.setMpName_1(membershipUpgrade.getMembershipPackage().getName());

				membershipSubscription.setMpId_1(String.valueOf(membershipUpgrade.getMembershipPackage().getMpId()));
				membershipSubscription.setCreateDate(user.getCreateDate());

				// should be the previous package wish to upgrade e.g Basic to
				// Premium

				membershipSubscription.setMpName_3(previousPackageName);
				membershipSubscription.setShippingStreet("upgrade");

				// set the promo code for membership subscription

				if (Validator.isNotNull(membershipUpgrade.getPromotionCode())) {
					membershipSubscription.setPromotionCode(membershipUpgrade.getPromotionCode().getPromotionCode());
					membershipSubscription.setPromotionFrom(membershipUpgrade.getPromotionCode().getPromotionFrom());
					membershipSubscription.setPromotionTo(membershipUpgrade.getPromotionCode().getPromotionTo());
					membershipSubscription.setDiscount(membershipUpgrade.getPromotionCode().getDiscount());
				}
			}

			MembershipSubscriptionLocalServiceUtil.updateMembershipSubscription(membershipSubscription);
		}
	}

	private SocialProfile getSocialProfile(long userId) {
		return MembershipUpgradeService.getUserProfile(String.valueOf(userId));
	}

	private User getUserInfo(long userId) {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return user;
	}

	/***
	 //* Put the notification message to membershipUpgrade bean object

	private void setMessageSuccess(HttpSession session, MembershipUpgradeBean membershipUpgrade, String message) {
		membershipUpgrade.setMessageSuccess(message);
		session.setAttribute("membershipUpgrade", membershipUpgrade);
	}

	/***
	// * Check if the current user has package to upgrade

	private boolean checkIfUpgradable(ThemeDisplay _themeDisplay) {
		boolean isUpgradable = false;

		try {
			MembershipPackage membershipPackage = MembershipPackageLocalServiceUtil.getMembershipPackage(this.getSocialProfile(
					_themeDisplay.getUserId()).getMemberPackage());

			List<MembershipPackage> membershipPackages = MembershipPackageLocalServiceUtil.findByMembershipPackageType(this.getSocialProfile(
					_themeDisplay.getUserId()).getUserType());

			for (MembershipPackage mp : membershipPackages) {
				if (mp.getMpId() != membershipPackage.getMpId()) {
					if (mp.getCost() >= membershipPackage.getCost()) {
						isUpgradable = true;
					}
				}
			}

		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return isUpgradable;
	}

**/
}