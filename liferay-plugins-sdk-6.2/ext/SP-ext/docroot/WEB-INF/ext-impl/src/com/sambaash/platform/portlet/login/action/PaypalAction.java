package com.sambaash.platform.portlet.login.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portlet.ActionResponseImpl;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.Paypal;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.PaypalUtil;
import com.sambaash.platform.util.SambaashUtil;
//import sambaash.platform.srv.membershippackage.model.MembershipPackagePromotionCode;
//import sambaash.platform.srv.membershippackage.service.MembershipPackagePromotionCodeLocalServiceUtil;
//import sambaash.platform.srv.membershipsubscription.model.MembershipSubscription;
//import sambaash.platform.srv.membershipsubscription.service.MembershipSubscriptionLocalServiceUtil;

public class PaypalAction extends PortletAction {
	static Log logger = LogFactoryUtil.getLog(PaypalAction.class);

	// TODO: [Rio] - System outputs will be removed after Paypal testing

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		ThemeDisplay _themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(com.liferay.portal.util.WebKeys.THEME_DISPLAY);
		long groupId = _themeDisplay.getScopeGroupId();
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(actionRequest));

		String CMD = ParamUtil.getString(actionRequest, Constants.CMD);
		String upgrade = ParamUtil.getString(actionRequest, "source");

		boolean isUpgrade = PaypalUtil.isMembershipPackageUpgrade(upgrade);

		String remoteUser = actionRequest.getRemoteUser();

		if (Validator.isNull(remoteUser)) {
			remoteUser = ParamUtil.getString(actionRequest, "userid");
		}

		PortletURL portletActionUrl = ((ActionResponseImpl) actionResponse)
				.createActionURL();
		// portletActionUrl.setWindowState(WindowState.MAXIMIZED);

		if (Validator.isNotNull(CMD) && CMD.equals("return_payment")) {
			// String shippingEmailAddress = ParamUtil.getString(actionRequest,
			// "cm");
			// String tx = ParamUtil.getString(actionRequest,"tx"); //pptxnid
			// String amt = ParamUtil.getString(actionRequest,"amt");
			// //pppaymentgross
			// String cc = ParamUtil.getString(actionRequest,"cc"); //ccname
			// String item_number =
			// ParamUtil.getString(actionRequest,"item_number");
			String status = ParamUtil.getString(actionRequest, "st"); // pppaymentstatus

			if (Validator.isNotNull(status)
					&& status
							.equalsIgnoreCase(SambaashConstants.MEMBERSHIPSUBSCRIPTION.PPPAYMENTSTATUS_COMPLETED)) {
				if (isUpgrade) {
					String upgradeAccountSuccessUrl = SambaashUtil
							.getPortalURL(_themeDisplay.getCompanyId(), groupId);
					upgradeAccountSuccessUrl += StringPool.SLASH
							+ "membershipupgrade";
					actionRequest.setAttribute("return_url",
							upgradeAccountSuccessUrl);
					actionRequest.setAttribute("return_action",
							"paymentSuccess");
					setForward(actionRequest, "portlet.paypal.notify");
				} else {
					String createAccountSuccessUrl = portletActionUrl
							.toString();
					createAccountSuccessUrl = HttpUtil
							.setParameter(
									createAccountSuccessUrl,
									Constants.CMD,
									SambaashConstants.MEMBERSHIPSUBSCRIPTION.PPPAYMENTSTATUS_COMPLETED);
					createAccountSuccessUrl = HttpUtil.setParameter(
							createAccountSuccessUrl, "struts_action",
							"/login/sp_create_account");
					actionResponse.sendRedirect(createAccountSuccessUrl);
				}
				return;
			} else {
				actionRequest.setAttribute("errorMessage",
						"Payment unsuccessful. Please try again.");
				setForward(actionRequest, "portlet.paypal.error");
			}
		} else {
			String emailAddress = ParamUtil.getString(actionRequest, "email");
			String firstName = ParamUtil.getString(actionRequest, "firstname");
			String lastName = ParamUtil.getString(actionRequest, "lastname");
			String mpName = ParamUtil.getString(actionRequest, "packagename");
			String total = ParamUtil.getString(actionRequest, "total");
			String currency = ParamUtil.getString(actionRequest, "currency");
			String mpId = ParamUtil.getString(actionRequest, "packageid");
			String promoCode = ParamUtil.getString(httpRequest,
					"promotion_code");

			String communityName = PaypalUtil.getCommunityDescription(groupId);
			String mpSubscriptionName = firstName + StringPool.SPACE + lastName
					+ StringPool.SPACE + mpName + " membership package for "
					+ communityName;
			if (Validator.isNull(currency)) {
				currency = PaypalUtil.getPaypalDefaultCurrencyCode(groupId);
			}
			String location = PaypalUtil.getPaypalDefaultLocation(groupId);

			String paypalGatewayURL = PaypalUtil.getPaypalGatewayURL(groupId);
			// String paypalGatewayURL =
			// "https://www.sandbox.paypal.com/cgi-bin/webscr";

			String paypalid = PaypalUtil.getPaypalId(groupId);
			// String paypalid = "JDASN6CNPEMK8";
			// String icType = PaypalUtil.
			String btnImgUrl = PaypalUtil.getPaymentBtnURL(groupId);

			Layout layout;
			long plid = 0;

			try {
				layout = LayoutLocalServiceUtil.getFriendlyURLLayout(
						_themeDisplay.getScopeGroupId(), false, "/welcome");
				if (layout != null) {
					plid = layout.getPlid();
				}
			} catch (PortalException e) {
				logger.error(e);
			} catch (SystemException e) {
				logger.error(e);
			}

			PortletURL portletLoginRenderUrl = PortletURLFactoryUtil.create(
					PortalUtil.getHttpServletRequest(actionRequest),
					PortletKeys.LOGIN, plid, PortletRequest.RENDER_PHASE);
			portletLoginRenderUrl.setWindowState(WindowState.MAXIMIZED);

			PortletURL portletLoginActionUrl = PortletURLFactoryUtil.create(
					PortalUtil.getHttpServletRequest(actionRequest),
					PortletKeys.LOGIN, plid, PortletRequest.ACTION_PHASE);
			portletLoginActionUrl.setWindowState(WindowState.MAXIMIZED);

			String cancelReturnUrl = portletActionUrl.toString();
			cancelReturnUrl = HttpUtil.setParameter(cancelReturnUrl,
					Constants.CMD, "cancel");
			cancelReturnUrl = HttpUtil.setParameter(cancelReturnUrl,
					"struts_action", "/login/sp_create_account");

			String paymentReturnUrl = portletLoginActionUrl.toString();
			paymentReturnUrl = HttpUtil.setParameter(paymentReturnUrl,
					Constants.CMD, "return_payment");
			paymentReturnUrl = HttpUtil.setParameter(paymentReturnUrl,
					"struts_action", "/login/paypal");
			paymentReturnUrl = HttpUtil.setParameter(paymentReturnUrl,
					"promotion_code", promoCode);

			String notifyUrl = portletLoginRenderUrl.toString();
			notifyUrl = HttpUtil.setParameter(notifyUrl, "action",
					"notify_payment");
			notifyUrl = HttpUtil.setParameter(notifyUrl, "struts_action",
					"/login/paypal");
			notifyUrl = HttpUtil.setParameter(notifyUrl, "userid", remoteUser);
			notifyUrl = HttpUtil.setParameter(notifyUrl, "packageid", mpId);
			notifyUrl = HttpUtil.setParameter(notifyUrl, "promotion_code",
					promoCode);
			notifyUrl = HttpUtil.setParameter(notifyUrl, "groupid", groupId);

			if (isUpgrade) {
				cancelReturnUrl = SambaashUtil.getPortalURL(
						_themeDisplay.getCompanyId(), groupId)
						+ StringPool.FORWARD_SLASH
						+ "membershipupgrade?action=paymentCancel";
				paymentReturnUrl = HttpUtil.setParameter(paymentReturnUrl,
						"source", "upgrade");
				notifyUrl = HttpUtil.setParameter(notifyUrl, "source",
						"upgrade");
			}// end upgrade

			String imgUrl1 = paypalGatewayURL
					+ "/en_US/i/btn/btn_buynowCC_LG.gif";
			String imgUrl2 = paypalGatewayURL + "/en_US/i/scr/pixel.gif";

			float taxFactor = PaypalUtil.getTaxFactor(groupId);
			double netTotal = 0;

			try {
				if (Validator.isNotNull(total)) {
					netTotal = Double.parseDouble(total);
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}

			int qty = 1;
			int shipFlg = 1; // 1 do not prompt for an address
			int rm = 2; // 2 the payer's browser is redirected to the return URL
						// by the POST method, and all transaction variables are
						// also posted

			Paypal paypal = new Paypal();
			paypal.setPaypalId(paypalid);
			paypal.setEmailAddress(emailAddress);
			paypal.setTaxRate(taxFactor);
			paypal.setItemNumber(mpName); // value will be returned upon payment
											// completion
			paypal.setItemName(mpSubscriptionName); // description
			paypal.setShippingFlag(shipFlg);
			paypal.setQuantity(qty);
			paypal.setTotal(netTotal);
			paypal.setReturnMethod(rm);
			paypal.setPaypalGatewayURL(paypalGatewayURL);
			paypal.setPaypalButtonURL(btnImgUrl);
			paypal.setCancelURL(cancelReturnUrl.toString());
			paypal.setReturnURL(paymentReturnUrl.toString());
			paypal.setNotificationURL(notifyUrl.toString());
			paypal.setCurrencyCode(currency);
			paypal.setLocation(location);
			paypal.setSubType(PaypalUtil.PAYPAL_SERVICES);
			paypal.setImgURL1(imgUrl1);
			paypal.setImgURL2(imgUrl2);
			logger.error(paypal.toString());
			actionRequest.setAttribute("paypal", paypal);

			setForward(actionRequest, "portlet.paypal.payment");
			return;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, RenderRequest request,
			RenderResponse response) throws Exception {

		String action = ParamUtil.getString(request, "action");
		String strGroupId = ParamUtil.getString(request, "groupid");

		if (Validator.isNotNull(action) && action.equals("notify_payment")) {
			Enumeration<String> en = request.getParameterNames();// read post
																	// from
																	// PayPal
																	// system
																	// and add
																	// 'cmd'
			String str = "cmd=_notify-validate";
			while (en.hasMoreElements()) {
				String paramName = (String) en.nextElement();
				String paramValue = request.getParameter(paramName);

				str = str + "&" + paramName + "="
						+ URLEncoder.encode(paramValue);
			}

			long groupId = 0;
			if (Validator.isNotNull(strGroupId)) {
				groupId = Long.valueOf(strGroupId);
			} else {
				groupId = Long.valueOf(SambaashConstants.DEFAULT_GROUP_ID);
			}

			String paypalGatewayURL = PaypalUtil.getPaypalGatewayURL(groupId);
			// String paypalGatewayURL =
			// "https://www.sandbox.paypal.com/cgi-bin/webscr";

			// post back to PayPal system to validate
			// NOTE: change http: to https: in the following URL to verify using
			// SSL (for increased security).
			// using HTTPS requires either Java 1.4 or greater, or Java Secure
			// Socket Extension (JSSE)
			// and configured for older versions.
			URL u = new URL(paypalGatewayURL);
			URLConnection uc = u.openConnection();
			uc.setDoOutput(true);
			uc.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			PrintWriter pw = new PrintWriter(uc.getOutputStream());
			pw.println(str);
			pw.close();

			String res = "";
			BufferedReader in = null;
			try {
				in = new BufferedReader(new InputStreamReader(
						uc.getInputStream()));
				res = in.readLine();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			} finally {
				if (in != null) {
					in.close();
				}
			}

			String upgrade = ParamUtil.getString(request, "source");

			boolean isUpgrade = PaypalUtil.isMembershipPackageUpgrade(upgrade);

			if (res.equalsIgnoreCase("VERIFIED")) {
				updateSubscriptionFromPaypalNotify(request, response, isUpgrade);
			} else if (res.equals("INVALID")) {
				logger.error("Paypal transaction returns INVALID");
			} else {
				logger.error("Paypal transaction unsuccessful!");
			}
		}

		String forward = (String) request.getAttribute(PortletAction
				.getForwardKey(request));

		return mapping.findForward(forward);
	}

	protected boolean updateSubscriptionFromPaypalNotify(RenderRequest request,
			RenderResponse response, boolean upgrade) throws Exception {

		boolean success = false;

		// assign posted variables to local variables
		// String itemName = ParamUtil.getString(request, "item_name");
		String itemNumber = ParamUtil.getString(request, "item_number");
		String paymentStatus = ParamUtil.getString(request, "payment_status"); // Completed
		String paymentAmount = ParamUtil.getString(request, "mc_gross");

		String txnId = ParamUtil.getString(request, "txn_id");
		String receiverEmail = ParamUtil.getString(request, "receiver_email");// to
																				// PpReceiverEmail
		String payerEmail = ParamUtil.getString(request, "payer_email");// BillingEmailAddress

		// String emailAddress = ParamUtil.getString(request, "custom");
		String billingFirstName = ParamUtil.getString(request, "first_name");// billingFirstName
		String billingLastName = ParamUtil.getString(request, "last_name");// billingLastName
		String residence_country = ParamUtil.getString(request,
				"residence_country");// to
										// ShippingCountry
										// US
		String transaction_subject = ParamUtil.getString(request,
				"transaction_subject");// to
										// MpName_2
										// sdPremiumpayuser1
		String mc_currency = ParamUtil.getString(request, "mc_currency");// to
																			// CcName
		String receipt_id = ParamUtil.getString(request, "receipt_id");// to
																		// MpId_2
		String payer_status = ParamUtil.getString(request, "payer_status");

		String remoteUser = ParamUtil.getString(request, "userid");
		String memPackageid = ParamUtil.getString(request, "packageid");
		long mpId = 0;

		if (Validator.isNotNull(memPackageid)) {
			mpId = Long.valueOf(memPackageid);
		}

		String promoCode = ParamUtil.getString(request, "promotion_code");

		// process payment
		if (Validator.isNotNull(paymentStatus)
				&& paymentStatus
						.trim()
						.equalsIgnoreCase(
								SambaashConstants.MEMBERSHIPSUBSCRIPTION.PPPAYMENTSTATUS_COMPLETED)) {

			float paymentAmountFloat = 0.0f;
			try {
				paymentAmountFloat = Float.parseFloat(paymentAmount.trim());
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}

			long userId = 0;
			if (Validator.isNotNull(remoteUser)) {
				userId = Long.valueOf(remoteUser).longValue();
			}
			/**
			 * List<MembershipSubscription> msList =
			 * MembershipSubscriptionLocalServiceUtil
			 * .findByMembershipSubscriptionUserId(userId);
			 * 
			 * Iterator<MembershipSubscription> msItr = msList.iterator(); long
			 * msId = 0; while (msItr.hasNext()) { MembershipSubscription ms =
			 * msItr.next(); msId = ms.getPrimaryKey(); }
			 * 
			 * MembershipSubscription msupdate =
			 * MembershipSubscriptionLocalServiceUtil
			 * .getMembershipSubscription(msId);
			 * 
			 * if ((msupdate != null) &&
			 * (msupdate.getPpPaymentStatus().equalsIgnoreCase("Pending"))) {
			 * 
			 * String checkTxnId = msupdate.getPpTxnId();
			 * 
			 * // check that txnId has not been posted more than 1 or not a //
			 * duplicate if (Validator.isNotNull(txnId) &&
			 * (txnId.equalsIgnoreCase(checkTxnId))) { return false; }
			 * 
			 * msupdate.setBillingFirstName(billingFirstName);
			 * msupdate.setBillingLastName(billingLastName);
			 * msupdate.setBillingEmailAddress(payerEmail);
			 * msupdate.setPpTxnId(txnId);
			 * msupdate.setPpReceiverEmail(receiverEmail);
			 * msupdate.setCcName(mc_currency);
			 * msupdate.setShippingCountry(residence_country);
			 * msupdate.setMpName_2(transaction_subject);
			 * msupdate.setMpId_2(receipt_id);
			 * msupdate.setShippingState(payer_status);
			 * msupdate.setNettotal(paymentAmountFloat);
			 * msupdate.setPpPaymentStatus
			 * (SambaashConstants.MEMBERSHIPSUBSCRIPTION
			 * .PPPAYMENTSTATUS_COMPLETED);// set // to // completed // right //
			 * after // payment msupdate.setModifiedDate(new Date());
			 * 
			 * if (Validator.isNotNull(promoCode)) {
			 * msupdate.setPromotionCode(promoCode);
			 * List<MembershipPackagePromotionCode> mpCodes =
			 * MembershipPackagePromotionCodeLocalServiceUtil
			 * .findBypromotionCode(promoCode); for
			 * (MembershipPackagePromotionCode mpPromoCode : mpCodes) {
			 * msupdate.setPromotionFrom(mpPromoCode.getPromotionFrom());
			 * msupdate.setPromotionTo(mpPromoCode.getPromotionTo());
			 * msupdate.setEffectiveFromDate(mpPromoCode.getPromotionFrom());
			 * msupdate.setEffectiveToDate(mpPromoCode.getPromotionTo()); } }
			 * 
			 * if (upgrade) { // update the fields only on upgrade String
			 * prevMemPkgName = msupdate.getMpName_1(); String prevMemPkgId =
			 * msupdate.getMpId_1(); int prevMemPkgQty = msupdate.getMpQty_1();
			 * float prevMemPkgPrice = msupdate.getMpPrice_1(); String
			 * prevMemPkgCurr = msupdate.getMpPriceCurrency_1();
			 * 
			 * msupdate.setMpId_3(prevMemPkgId);
			 * msupdate.setMpName_3(prevMemPkgName);// copy prev membership //
			 * package msupdate.setMpQty_3(prevMemPkgQty);
			 * msupdate.setMpPrice_3(prevMemPkgPrice);
			 * msupdate.setMpPriceCurrency_3(prevMemPkgCurr);
			 * 
			 * msupdate.setMpName_1(itemNumber);// new membership package //
			 * name msupdate.setMpQty_1(1);
			 * msupdate.setMpPrice_1(paymentAmountFloat);
			 * msupdate.setMpPriceCurrency_1(mc_currency);
			 * msupdate.setShippingStreet
			 * ((SambaashConstants.MEMBERSHIPSUBSCRIPTION.UPGRADE));// update //
			 * status // to // "Upgrade"
			 * 
			 * 
			 * MembershipSubscriptionLocalServiceUtil.
			 * updateMembershipSubscription(msupdate);
			 * 
			 * // update subscription package SocialProfile socialProfile =
			 * SocialProfileLocalServiceUtil.getSocialProfile(userId);
			 * socialProfile.setMemberPackage(mpId);
			 * socialProfile.setModifiedDate(new Date());
			 * SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);
			 * 
			 * // send email notification upon upgrade
			 * sendMembershipUpgradeEmail(userId, mpId, prevMemPkgName,
			 * itemNumber, request);
			 * 
			 * } else { MembershipSubscriptionLocalServiceUtil.
			 * updateMembershipSubscription(msupdate);
			 * 
			 * sendRegistrationEmailVerification(userId, request); // send //
			 * email // verification // only // upon // registration }// end
			 * upgrade success = true; }// end msupdate != null
			 **/
		}// end payment status = Completed

		return success;
	}

	protected void sendRegistrationEmailVerification(long userId,
			PortletRequest request) throws PortalException, SystemException {
		// send email
		User user = UserLocalServiceUtil.getUser(userId);
		SocialProfile socialProfile = SocialProfileLocalServiceUtil
				.getSocialProfile(userId);
		final ServiceContext serviceContext = ServiceContextFactory
				.getInstance(User.class.getName(), request);
		Company company = CompanyLocalServiceUtil.getCompany(PortalUtil
				.getDefaultCompanyId());
		if (company.isStrangersVerify()) {
			serviceContext
					.setAttribute(
							SambaashConstants.REGISTRATION.SEND_VERIFICATION_EMAIL_FLAG,
							"true");
			UserLocalServiceUtil.sendEmailAddressVerification(user,
					user.getEmailAddress(), serviceContext);
		} else {
			socialProfile
					.setUserRegistrationStatus(SambaashConstants.REGISTRATION.USER_REGISTRATION_STATUS_ACTIVE);
			SocialProfileLocalServiceUtil.updateSocialProfile(socialProfile);
		}
	}

	protected void sendMembershipUpgradeEmail(long userId, long mpId,
			String prevMemPkg, String newMemPkg, PortletRequest request)
			throws Exception {
		// send email

		User user = UserLocalServiceUtil.getUser(userId);
		/***
		 * Administrators Name and Email
		 * ***/
		String fromName = PrefsPropsUtil.getString(user.getCompanyId(),
				PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromAddress = PrefsPropsUtil.getString(user.getCompanyId(),
				PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

		/***
		 * Recipient Name and Email
		 * ***/
		String toName = user.getFullName();
		String toAddress = user.getEmailAddress();

		final ServiceContext serviceContext = ServiceContextFactory
				.getInstance(User.class.getName(), request);
		com.sambaash.platform.model.MailMessage mailMessage = null;
		String mailTemplateIdParameter = SambaashConstants.TEMPLATE_MEMBERSHIP_UPGRADED_NOTIFICATION_ID;
		// mailMessage =
		// MailTemplateLocalServiceUtil.getMailMessage(mailTemplateIdParameter,
		// serviceContext.getPortalURL(), serviceContext.getScopeGroupId());

		mailMessage = SPMailTemplateLocalServiceUtil
				.getMailMessage(mailTemplateIdParameter,
						serviceContext.getScopeGroupId(), true);

		String subject = mailMessage.getSubject();
		String body = mailMessage.getHtmlBody();

		SubscriptionSender subscriptionSender = new SubscriptionSender();
		subscriptionSender.setBody(body);
		subscriptionSender.setCompanyId(user.getCompanyId());

		subscriptionSender.setContextAttributes("[$USER_SCREEN_NAME$]", toName,
				"[$MEMBERSHIP_PACK_FROM$]", prevMemPkg,
				"[$MEMBERSHIP_PACK_TO$]", newMemPkg, "[$SENDER_NAME$]",
				fromName, "[$SENDER_EMAIL_ADDRESS$]", fromAddress);

		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);
		subscriptionSender.setMailId("user", user.getUserId());
		subscriptionSender.setSubject(subject);
		subscriptionSender.setUserId(user.getUserId());

		subscriptionSender.addRuntimeSubscribers(toAddress, toName);
		subscriptionSender.flushNotificationsAsync();
		// MailServiceUtil.sendEmail(mailMessage);
	}

	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

}
