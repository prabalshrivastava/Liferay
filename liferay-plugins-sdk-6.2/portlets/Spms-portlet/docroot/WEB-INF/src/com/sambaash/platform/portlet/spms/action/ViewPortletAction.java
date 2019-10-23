package com.sambaash.platform.portlet.spms.action;

/**
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;**/
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ViewPortletAction extends MVCPortlet {
/**
	private static Log _log = LogFactoryUtil.getLog(ViewPortletAction.class);

	 //* Start -- Attributes declared in MembershipSubscriptionAction

	long companyId;
	Date promotionFrom = new Date();
	Date promotionTo = new Date();

	// * End -- Attributes declared in MembershipSubscriptionAction

	@Override
	public void doView(RenderRequest req, RenderResponse res) throws IOException, PortletException {
		String strutsActionPath = req.getParameter("struts_action");

		if ("/spms/addItem".equalsIgnoreCase(strutsActionPath) || "/spms/payment_return".equalsIgnoreCase(strutsActionPath) ||
			"/spms/buy_more".equalsIgnoreCase(strutsActionPath) || "/spms/upgrade".equalsIgnoreCase(strutsActionPath) ||
			"/spms/upgrade_membership".equalsIgnoreCase(strutsActionPath) || "/spms/createaccountredirect".equalsIgnoreCase(strutsActionPath) ||
			"/spms/membershipsubscription_action".equalsIgnoreCase(strutsActionPath) || "/spms/paypal_notify".equalsIgnoreCase(strutsActionPath)) {
			try {
				HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
				String cmd = req.getParameter("CMD");
				_log.info("cmd Is : " + cmd);
				HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(req));
				String upgrade_member = httpRequest.getParameter("upgrade_member");
				String up_payment = httpRequest.getParameter("payment");
				String userID = httpRequest.getParameter("userId");
				String mpId = httpRequest.getParameter("mpId");
				_log.info("ouside if condition" + "upgrade_member" + upgrade_member + "userID" + userID + "mpId" + mpId + "up_payment" + up_payment);
				String usrName = "";
				String usrMail = "";
				long usrMpId = 0;
				String mpNameFrom = "";
				String mpNameTo = "";
				long compId = CompanyThreadLocal.getCompanyId();
				ThemeDisplay themeDisplays = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);

				long userId = themeDisplays.getUserId();

				if (cmd != null && cmd.equalsIgnoreCase("pay")) {
					_log.info("upgrade_member from cmd pay Is : " + upgrade_member);
					_log.info("mpId from cmd pay Is : " + mpId);
					httpRequest.setAttribute("upgrade_member", upgrade_member);
					httpRequest.setAttribute("mpId", mpId);
//					setForward(req, "spms.payment_return");
//					return mapping.findForward("spms.payment_return");
			include("/html/paymentReturn.jsp", req, res);
				}

				if (cmd != null && cmd.equals("buy_more")) {
//					setForward(req, "spms.buy_more");
//					return mapping.findForward("spms.buy_more");
			include("/html/buy_more.jsp", req, res);
				}else if (cmd != null && cmd.equals("form")) {
//					return mapping.findForward("spms.membershipsubscription.form");
			include("/html/membershipsubscription_form.jsp", req, res);
				} else if (cmd != null && cmd.equals("detail")) {
					String recId = req.getParameter("recId");
					req.setAttribute("recId", recId);
//					return mapping.findForward("spms.membershipsubscription.detail");
			include("/html/membershipsubscription_detail.jsp", req, res);
				} else if (cmd != null && cmd.equals("edit")) {
					String recId = req.getParameter("recId");
					req.setAttribute("recId", recId);
//					return mapping.findForward("spms.membershipsubscription.edit");
			include("/html/membershipsubscription_edit.jsp", req, res);
				} else if (cmd != null && cmd.equals("notify")) {
//					return mapping.findForward("spms.membershipsubscription.notify");
			include("/html/notify.jsp", req, res);
				} else if (cmd != null && cmd.equals("upgrade")) {
					String recId = req.getParameter("recId");
					String promoCodeCheck = req.getParameter("status");

					if ((promoCodeCheck != null) && (promoCodeCheck.equals("failed"))) {
						request.setAttribute("is_promotion_code", "not_promotion_code");
					}

					req.setAttribute("upgrade", "true");
					req.setAttribute("recId", recId);
//					return mapping.findForward("spms.membershipupgrade");
			include("/html/membershipupgrade.jsp", req, res);
				} else if ((cmd != null) && (cmd.equals("upgrade_member"))) {

					_log.info("upgrade_member" + upgrade_member + "userID" + userID + "mpId" + mpId);

					// UserProfileBasic usrDetails =
					// UserProfileBasicLocalServiceUtil.getUserProfileBasic(Long.parseLong(userID));

					SocialProfile usrDetails = SocialProfileLocalServiceUtil.getSocialProfile(Long.parseLong(userID));
					User userDet = UserLocalServiceUtil.getUser(Long.parseLong(userID));
					usrName = userDet.getFullName();

					// usrMail = usrDetails.getEmailAddress();

					usrMail = themeDisplays.getUser().getEmailAddress();
					usrMpId = usrDetails.getMemberPackage();
					_log.info("usrDetails *********************" + usrDetails);

					if ((up_payment == null) || (!"true".equalsIgnoreCase(up_payment))) {
						addDataIntoDatabase((PortletRequest) req, "Insert", userId, "false");
						_log.info("data added to membershipsubscription table *********************");
					}

					usrDetails.setMemberPackage(Long.valueOf(mpId));

					// UserProfileBasicLocalServiceUtil.updateUserProfileBasic(usrDetails);

					SocialProfileLocalServiceUtil.updateSocialProfile(usrDetails);
					_log.info("data updated in userprofilebasic table *********************");

					MembershipPackage usrMpDetailsFrom = MembershipPackageLocalServiceUtil.getMembershipPackage(usrMpId);
					mpNameFrom = usrMpDetailsFrom.getName();

					MembershipPackage usrMpDetailsTo = MembershipPackageLocalServiceUtil.getMembershipPackage(Long.parseLong(mpId));
					mpNameTo = usrMpDetailsTo.getName();
					String portalUrl = Util.getPortalUrl();

					List<MembershipSubscription> msDetails = MembershipSubscriptionLocalServiceUtil.findByMembershipSubscriptionUserId(Long.parseLong(userID));
					Iterator<MembershipSubscription> msItr = msDetails.iterator();
					long msKey = 0;
					while (msItr.hasNext()) {
						MembershipSubscription mpsr = msItr.next();
						msKey = mpsr.getPrimaryKey();
					}

					MembershipSubscription msUpdate = MembershipSubscriptionLocalServiceUtil.getMembershipSubscription(msKey);
					String paymentStatus = msUpdate.getPpPaymentStatus();

					if (!paymentStatus.equalsIgnoreCase("completed")) {
						SendMailImpl.sendEmail(mpNameFrom, Long.parseLong(mpId), userDet, usrDetails, portalUrl, PortalUtil.getScopeGroupId(httpRequest));
					}

					if ((up_payment != null) || (!"true".equalsIgnoreCase(up_payment))) {
						_log.info("up_payment *********************" + up_payment);
						msUpdate.setPpPaymentStatus("Completed");
						MembershipSubscriptionLocalServiceUtil.updateMembershipSubscription(msUpdate);
						_log.info("msDetails &&&&&&&&&&&&&" + msDetails);
					}

					String fromName = PropsUtil.get("admin.email.from.name");
					String fromAddress = PropsUtil.get("admin.email.from.address");
					String toAddress = usrMail;
					String toName = usrName;
					String subject = "Confirmation for Membership Upgrade";
					String body = "Your membership has been upgraded from" + "    " + mpNameFrom + "   to   " + mpNameTo;

					InternetAddress from = new InternetAddress(fromAddress, fromName);

					InternetAddress to = new InternetAddress(toAddress, toName);

					// MailMessage message = new MailMessage(from, to, subject, body,
					// true); MailServiceUtil.sendEmail(message); new
					// MailServiceImpl().sendEmail(message);
					// MailEngine.send(from, to, subject, body);
					// HttpServletResponse httpResponse =
					// PortalUtil.getHttpServletResponse(renderResponse);
					// return;

					httpRequest.setAttribute("mpNameTo", mpNameTo);
					httpRequest.setAttribute("compId", String.valueOf(compId));
					httpRequest.setAttribute("id", userID);

					// Membership subscription for upgrade membership

//					if (userDet != null) {
//						NotificationSubscriptionLocalServiceUtil.removeSubscriptionsByUserId(userDet.getUserId());
//						NotificationSubscriptionLocalServiceUtil.addUserSubscriptionsByMpId(userDet.getUserId(), Long.parseLong(mpId), themeDisplays.getCompanyId(), themeDisplays.getScopeGroupId(),
//								new Date(), new Date());
//					}

//					return mapping.findForward("spms.upgrade_membership");
			include("/html/upgrade_membership.jsp", req, res);
				} else {

					ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);

					try {
						validateUserInfo(req);

					} catch (Exception ex) {

						HttpServletResponse response = PortalUtil.getHttpServletResponse(res);

						PortletURL portleturl = getCreateAccountURL(request);

						String redirect = getRedirectURL(themeDisplay);

						if (request.getParameter("corporateName") != null && request.getParameter("corporateName") != "") {

							// redirect=redirect+"&corporateName="+request.getParameter("corporateName");

							request.setAttribute("corporateName", request.getParameter("corporateName"));
						}

						request.setAttribute("pwdError", ex);

						ActionForward fd = new ActionForward(redirect, true);

//						return mapping.findForward("spms.createaccountredirect");
				include("/html/createaccountredirect.jsp", req, res);
					}

//					return mapping.findForward("spms.addItem");
			include("/html/membershipsubscription_form.jsp", req, res);
				}

//				return mapping.findForward("spms.membershipsubscription.list");
			}catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

		}else if ("/spms/membershipsubscriptionaddonservices_action".equalsIgnoreCase(strutsActionPath)) {
			String cmd = req.getParameter("CMD");

			if (cmd != null && cmd.equals("form")) {
//				return mapping.findForward("spms.membershipsubscriptionaddonservices.form");
		include("/membershipsubscriptionaddonservices_form.jsp", req, res);
			} else if (cmd != null && cmd.equals("detail")) {
				String recId = req.getParameter("recId");
				req.setAttribute("recId", recId);
//				return mapping.findForward("spms.membershipsubscriptionaddonservices.detail");
		include("/membershipsubscriptionaddonservices_detail.jsp", req, res);
			} else if (cmd != null && cmd.equals("edit")) {
				String recId = req.getParameter("recId");
				req.setAttribute("recId", recId);
//				return mapping.findForward("spms.membershipsubscriptionaddonservices.edit");
		include("/membershipsubscriptionaddonservices_edit.jsp", req, res);
			}

//			return mapping.findForward("spms.membershipsubscriptionaddonservices.list");
	include("/membershipsubscriptionaddonservices_list.jsp", req, res);
		}else {
			super.doView(req, res);
		}
	}

	@Override
	public void processAction(ActionRequest req, ActionResponse res) throws IOException, PortletException {
		String strutsActionPath = req.getParameter("struts_action");

		ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
		String portletName = (String)req.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(req), portletName,
				themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);

		if ("/spms/addItem".equalsIgnoreCase(strutsActionPath) || "/spms/payment_return".equalsIgnoreCase(strutsActionPath) ||
			"/spms/buy_more".equalsIgnoreCase(strutsActionPath) || "/spms/upgrade".equalsIgnoreCase(strutsActionPath) ||
			"/spms/upgrade_membership".equalsIgnoreCase(strutsActionPath) || "/spms/createaccountredirect".equalsIgnoreCase(strutsActionPath) ||
			"/spms/membershipsubscription_action".equalsIgnoreCase(strutsActionPath) || "/spms/paypal_notify".equalsIgnoreCase(strutsActionPath)) {
			try {
				HttpServletRequest request = PortalUtil.getHttpServletRequest(req);

				companyId = themeDisplay.getCompanyId();
				long userId = themeDisplay.getUserId();

				String cmd = req.getParameter("CMD");
				_log.info("CMD IS : " + cmd);
				String mpId = req.getParameter("upgrade_memberyType");
				String memberPack = req.getParameter("upgrade_memberPack");
				String pay_complete = req.getParameter("pay_complete");
				String pay = "true";
				_log.info("mpId mpId mpId IS : " + mpId);
				_log.info("memberPack memberPack IS : " + memberPack);
				_log.info("pay_complete pay_complete IS : " + req.getParameter("corporateName"));

				if (cmd != null && cmd.equals("process")) {
					if ((memberPack != null) && (memberPack.equals("true"))) {
						req.setAttribute("memberPack", "true");
						req.setAttribute("mpId", mpId);
						pay = "false";
					}

					_log.info("CMD IS Process? : " + cmd);

					addDataIntoDatabase((PortletRequest) req, "Insert", userId, pay);

					// here set values required for payment.jsp input

					_log.info("Forward to spms.payment as addDataIntoDatabase is DONE and CMD IS : " + cmd);

//					setForward(req, "spms.payment");
					redirectURL.setParameter("jspPage", "/html/payment.jsp");
				res.sendRedirect(redirectURL.toString());
					return;

					// for Additional services
					// MembershipSubscriptionAddonServicesLocalServiceUtil.addMembershipSubscriptionAddonServices(entityImpl);

				} else if (cmd != null && cmd.equals("delete")) {
					String[] pKeys = req.getParameterValues("deleteItem");

					if ((pKeys != null) && (pKeys.length != 0)) {
						for (int i = 0; i < pKeys.length; i++) {
							List ls = MembershipSubscriptionAddonServicesLocalServiceUtil.findByMembershipSubscriptionAddonServicesMsId(Long.parseLong(pKeys[i]));

							Iterator itr = ls.iterator();
							while (itr.hasNext()) {
								MembershipSubscriptionAddonServices group = (MembershipSubscriptionAddonServices)itr.next();
								MembershipSubscriptionAddonServicesLocalServiceUtil.deleteMembershipSubscriptionAddonServices(group);
							}

							MembershipSubscriptionLocalServiceUtil.deleteMembershipSubscription(Long.parseLong(pKeys[i]));
						}
					}
				} else if (cmd != null && cmd.equals("edit")) {
					String recId = req.getParameter("recId");
					long pKey = Long.parseLong(recId);

					// MembershipSubscription entityImpl = new
					// MembershipSubscriptionImpl();
					// entityImpl = (MembershipSubscriptionImpl) UIHelper.getObject(req,
					// MembershipSubscriptionImpl.class);

					MembershipSubscription actualImpl = MembershipSubscriptionLocalServiceUtil.getMembershipSubscription(pKey);

					// UIHelper.copyBean(actualImpl, entityImpl, req);

					MembershipSubscriptionLocalServiceUtil.updateMembershipSubscription(actualImpl);
				} else if (cmd != null && cmd.equals("upgrade")) {
					String recId = req.getParameter("recId");
					req.setAttribute("upgrade", "true");
					req.setAttribute("recId", recId);
					_log.info("mpId Is : " + mpId);
//					setForward(req, "spms.membershipupgrade");
					redirectURL.setParameter("jspPage", "/html/membershipupgrade.jsp");
				res.sendRedirect(redirectURL.toString());
					return;
				} else if (cmd != null && cmd.equals("upgrade_additem")) {
					String recId = req.getParameter("recId");
					long mpIdLong = Long.parseLong(mpId);

					// String mpId = req.getParameter("mpId"); String
					// promotionCode =
					// req.getParameter("membershipsubscription_promotionCode");

					String promoId = "membershipsubscription_promotionCode_" + mpIdLong;
					String promotionCode = req.getParameter(promoId);
					_log.info("promotionCode : " + promotionCode + "  promoId ** " + promoId);

					try {
						_isPromotion(mpIdLong, promotionCode, request);
					} catch (Exception exe) {
						_log.info("not Promotion : ");
						req.setAttribute("is_promotion_code", "not_promotion_code");
						String is_promotion_code = "";
						String is_promotion_period = (String) req.getAttribute("is_promotion_period");
						String has_promotion_code = (String) req.getAttribute("has_promotion_code");

						if (has_promotion_code == null || "".equals(has_promotion_code)) {
							if (is_promotion_period == null || "".equals(is_promotion_period)) {
								is_promotion_code = "not_promotion_code";
							}
						}

						String redirectFormUrl = SambaashUtil.getCommunityPath(themeDisplay.getScopeGroupId())
								+ "/membershipupgrade?p_p_id=Spms_WAR_Spmsportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column1&p_p_col_pos=1&p_p_col_count=2&_Spms_WAR_Spmsportlet_struts_action=%2Fspms%2Fupgrade&_Spms_WAR_Spmsportlet_CMD=upgrade&status=failed"
								+ "&is_promotion_code=" + is_promotion_code + "&has_promotion_code=" + has_promotion_code + "&is_promotion_period=" + is_promotion_period;
						res.sendRedirect(redirectFormUrl);

						// setForward(req,"spms.membershipupgrade");

						return;
					}

					req.setAttribute("cmd", cmd);
					req.setAttribute("recId", recId);
					req.setAttribute("mpId", mpId);
					_log.info("mpId Is : " + mpId);
					request.setAttribute("_58_promotion_code", promotionCode);
					request.setAttribute("memberType", mpId);
//					setForward(req, "spms.addItem");
					redirectURL.setParameter("jspPage", "/html/membershipsubscription_form.jsp");
				res.sendRedirect(redirectURL.toString());
					return;
				}

				PortletURL url = ((ActionResponseImpl)res).createRenderURL();
				url.setParameter("struts_action", "/spms/membershipsubscription_action");
				res.sendRedirect(url.toString());

			}catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}else if ("/spms/membershipsubscriptionaddonservices_action".equalsIgnoreCase(strutsActionPath)) {
			try {

				String cmd = req.getParameter("CMD");

				if (cmd != null && cmd.equals("process")) {
					long pKey = CounterLocalServiceUtil.increment("MembershipSubscriptionAddonServices.class");
//					MembershipSubscriptionAddonServices entityImpl = new MembershipSubscriptionAddonServicesImpl();
//					entityImpl = (MembershipSubscriptionAddonServicesImpl)UIHelper.getObject(req, MembershipSubscriptionAddonServicesImpl.class);
					MembershipSubscriptionAddonServices entityImpl = MembershipSubscriptionAddonServicesLocalServiceUtil.createMembershipSubscriptionAddonServices(pKey);
					entityImpl.setPrimaryKey(pKey);
					MembershipSubscriptionAddonServicesLocalServiceUtil.addMembershipSubscriptionAddonServices(entityImpl);
				} else if (cmd != null && cmd.equals("delete")) {
						String[] pKeys = req.getParameterValues("deleteItem");

						if ((pKeys != null) && (pKeys.length != 0)) {
						for (int i = 0; i<pKeys.length; i++) {
							MembershipSubscriptionAddonServicesLocalServiceUtil.deleteMembershipSubscriptionAddonServices(Long.parseLong(pKeys[i]));
						}
					}
				} else if (cmd != null && cmd.equals("edit")) {
					String recId = req.getParameter("recId");
					long pKey = Long.parseLong(recId);

//					MembershipSubscriptionAddonServices entityImpl = new MembershipSubscriptionAddonServicesImpl();
//					entityImpl = (MembershipSubscriptionAddonServicesImpl)UIHelper.getObject(req, MembershipSubscriptionAddonServicesImpl.class);

					MembershipSubscriptionAddonServices entityImpl = MembershipSubscriptionAddonServicesLocalServiceUtil.createMembershipSubscriptionAddonServices(pKey);
					entityImpl.setPrimaryKey(pKey);
					MembershipSubscriptionAddonServices actualImpl = MembershipSubscriptionAddonServicesLocalServiceUtil.getMembershipSubscriptionAddonServices(pKey);
					UIHelper.copyBean(actualImpl, entityImpl, req);
					MembershipSubscriptionAddonServicesLocalServiceUtil.updateMembershipSubscriptionAddonServices(actualImpl);
				}

				PortletURL url = ((ActionResponseImpl)res).createRenderURL();
				url.setParameter("struts_action", "/spms/membershipsubscriptionaddonservices_action");
				res.sendRedirect(url.toString());
			}catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}
	}

	// * Start -- Methods declared in MembershipSubscriptionAction

	public String getCommunityName(ThemeDisplay themeDisplay) {
		String communityName = SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());
		return communityName;
	}

	public String getRedirectURL(ThemeDisplay themeDisplay) {
		String cmName = getCommunityName(themeDisplay);
		String redirectURL = SambaashUtil.getCommunityPath(themeDisplay.getScopeGroupId())
				+ "/home?p_p_id=58&p_p_lifecycle=1&p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Fcreate_account";
		return redirectURL;
	}

	public void addDataIntoDatabase(PortletRequest req, String crud, long userId, String pay) throws Exception {
		long pKey = CounterLocalServiceUtil.increment("MembershipSubscription.class");
		_log.info("MembershipSubscription KEY IS : " + pKey);
		_log.info("User Id : " + userId);

		// MembershipAddonServices

		String mpAddonId = "mpAddonId";
		String scName = "scName";
		String scId = "scId";
		String paramFrom = "paramFrom";
		String paramUpto = "paramUpto";
		String paramType = "paramType";
		String serviceChargesCurrency = "serviceChargesCurrency";
		String serviceCharges = "serviceCharges";
		String serviceChargesPeriodType = "serviceChargesPeriodType";

		// Membership Subscription

		String name = "";
		String description = "";
		String mpOrder_1 = "";
		String mpId_1 = "";
		String mpName_1 = "";
		int mpQty_1 = 0;
		float mpPrice_1 = 0.0f;
		String mpPriceCurrency_1 = "SGD";
		String sessionId = "";
		String mpName_3 = "";
		String firstName = "";
		String lastName = "";
		String emailAddress = "";
		String password = "";
		String promotionCode = "";
		String triOrPay = "";
		String corporateName = "";
		String claimFlow = "";
		String corpId = "";

		// UserProfileBasic usrDetails = null;

		SocialProfile usrDetails = null;
		Date crtDate = new Date();
		;

		promotionCode = req.getParameter("_58_promotion_code");
		_log.info("MembershipSubscription promotionCode : " + promotionCode);

		firstName = req.getParameter("_58_firstName");
		lastName = req.getParameter("_58_lastName");
		corporateName = req.getParameter("corporateName");
		claimFlow = req.getParameter("claimFlow");
		corpId = req.getParameter("corporateId");
		_log.info("corporateName" + corporateName + "claimFlow " + claimFlow);

		emailAddress = req.getParameter("_58_emailAddress");
		password = req.getParameter("_58_password1");
		triOrPay = req.getParameter("triOrPay");

		Enumeration enumer = req.getParameterNames();
		while (enumer.hasMoreElements()) {
			String s = (String)enumer.nextElement();
			_log.info(s + " ########## " + req.getParameter(s));
		}

		String membershipsubscription_status = req.getParameter("membershipsubscription_status");
		_log.info("membershipsubscription_status promotionCode : " + membershipsubscription_status);

		if ((membershipsubscription_status == null)) {
			promotionCode = req.getParameter("58_promotion_code");
			_log.info("MembershipSubscription promotionCode : " + promotionCode);
		}

		try {

			// usrDetails =
			// UserProfileBasicLocalServiceUtil.getUserProfileBasic(userId);

			usrDetails = SocialProfileLocalServiceUtil.getSocialProfile(userId);
			long MPID = usrDetails.getMemberPackage();
			MembershipPackage mpdetails = MembershipPackageLocalServiceUtil.getMembershipPackage(MPID);
			mpName_3 = mpdetails.getName();
			User usrD = UserLocalServiceUtil.getUser(userId);
			crtDate = usrD.getCreateDate();
			_log.info("ctrDate $$$$$$$$$$$$$$: " + crtDate);
		} catch (Exception e) {
		}

		float mpSubtotal = 0.0f;
		String mpSubtotalCurrency = "";
		float addOnSubtotal = 0.0f;
		String addOnSubtotalCurrency = "";
		float netTotal = 0.0f;
		String nettotalCurrency = "";
		float tax = 0.0f;
		List<String> countRowArray = new ArrayList<String>();

		mpOrder_1 = req.getParameter("mpOrder_1");
		mpName_1 = req.getParameter("mpName_1");
		mpId_1 = req.getParameter("mpId_1");

		sessionId = req.getParameter("_58_sessionId");
		_log.info("Session Id : " + sessionId);
		String mpQty = req.getParameter("mpQty_1");
		String mpPrice = req.getParameter("mpPrice_1");
		_log.info("firstName : " + firstName + "lastName" + lastName + "emailAddress" + emailAddress + "mpOrder_1" + mpOrder_1 + "mpName_1" + mpName_1 + "mpId_1" + mpId_1);

		if ((mpQty != null) && (mpPrice != null)) {
			mpQty_1 = Integer.parseInt(mpQty);
			mpPrice_1 = Float.parseFloat(mpPrice);
			addOnSubtotal = Float.parseFloat(req.getParameter("addOnSubTotal"));
			mpSubtotal = Float.parseFloat(req.getParameter("mpSubtotal"));
			netTotal = Float.parseFloat(req.getParameter("netTotal"));
			tax = Float.parseFloat(req.getParameter("tax"));
		}

		// MembershipSubscription entityImpl = new MembershipSubscriptionImpl();
		// entityImpl = (MembershipSubscriptionImpl) UIHelper.getObject(req,
		// MembershipSubscriptionImpl.class);

		MembershipSubscription entityImpl = MembershipSubscriptionLocalServiceUtil.createMembershipSubscription(pKey);

		entityImpl.setPrimaryKey(pKey);

		entityImpl.setName(mpOrder_1 + mpId_1 + firstName);
		entityImpl.setDescription(mpOrder_1 + mpId_1 + firstName);
		entityImpl.setPromotionFrom(new Date());
		entityImpl.setPromotionTo(new Date());
		entityImpl.setEffectiveFromDate(new Date());
		entityImpl.setEffectiveToDate(new Date());
		try {
			MembershipPackage memberPack = MembershipPackageLocalServiceUtil.getMembershipPackage(Long.parseLong(mpId_1));
			List<MembershipPackagePromotionCode> mpPromotionCodeList = MembershipPackagePromotionCodeLocalServiceUtil.findBymembershipPackage_Id(Long.parseLong(mpId_1));
			Iterator<MembershipPackagePromotionCode> mpPromotionCodeItr = mpPromotionCodeList.iterator();
			mpPromotionCodeLoop: while (mpPromotionCodeItr.hasNext()) {
				MembershipPackagePromotionCode mpPromotionCode = mpPromotionCodeItr.next();

				if (promotionCode.equals(mpPromotionCode.getPromotionCode())) {
					entityImpl.setPromotionFrom(mpPromotionCode.getPromotionFrom());
					entityImpl.setPromotionTo(mpPromotionCode.getPromotionTo());
					entityImpl.setEffectiveFromDate(mpPromotionCode.getPromotionFrom());
					entityImpl.setEffectiveToDate(mpPromotionCode.getPromotionTo());
					break mpPromotionCodeLoop;
				}
			}

		} catch (Exception e) {
		}

		entityImpl.setMporder_1(mpOrder_1);
		entityImpl.setMpName_1(mpName_1);
		entityImpl.setMpId_1(mpId_1);
		entityImpl.setMpQty_1(mpQty_1);
		entityImpl.setMpPrice_1(mpPrice_1);
		entityImpl.setMpPriceCurrency_1("SGD");
		entityImpl.setAddOnSubtotal(addOnSubtotal);
		entityImpl.setAddOnSubtotalCurrency("SGD");
		entityImpl.setMpSubtotal(mpSubtotal);
		entityImpl.setMpSubtotalCurrency("SGD");
		entityImpl.setNettotal(netTotal);
		entityImpl.setNettotalCurrency("SGD");
		entityImpl.setTax(tax);
		entityImpl.setUserName(sessionId);
		entityImpl.setPromotionCode(promotionCode);
		entityImpl.setUserId(userId);
		entityImpl.setShippingStreet(membershipsubscription_status);
		entityImpl.setMpName_4(corporateName);
		entityImpl.setMpId_4(claimFlow);
		entityImpl.setMporder_4(corpId);

		// add create date and modified date on 10.08.2010(dd/mm/yy)

		entityImpl.setCreateDate(new Date());

		if ((pay != null) && (pay.equals("false"))) {
			entityImpl.setCreateDate(crtDate);
			entityImpl.setMpName_3(mpName_3);
			entityImpl.setShippingStreet("upgrade");
			_log.info("for pay false upgrade");
		}

		entityImpl.setModifiedDate(new Date());

		// add shipping information on 16.08.2010

		entityImpl.setShippingFirstName(firstName);
		entityImpl.setShippingLastName(lastName);
		entityImpl.setShippingCompany(password);
		entityImpl.setShippingEmailAddress(emailAddress);
		entityImpl.setCompanyId(companyId);

		// membership subscription status for Upgrade or New

		// entityImpl.setMpName_4(triOrPay);

		int rowCount = 0;

		Enumeration<String> enu = req.getParameterNames();

		if (crud.equalsIgnoreCase("Insert")) {
			while (enu.hasMoreElements()) {
				String temp = enu.nextElement();

				if (temp.contains("scName")) {
					countRowArray.add(temp.substring(6));
					rowCount++;
				}
			}
		}

		Iterator<String> codeNumberItr = countRowArray.iterator();

		MembershipSubscriptionAddonServices msAddon;// = new

													// MembershipSubscriptionAddonServicesImpl();

		if (crud.equalsIgnoreCase("Insert")) {
			List msDynamicQueryByShippingEmailList = MembershipSubscriptionLocalServiceUtil.findByMembershipSubscriptionShippingEmailAddress(emailAddress);

			Iterator msDynamicQueryByShippingEmailItr = msDynamicQueryByShippingEmailList.iterator();

			while (msDynamicQueryByShippingEmailItr.hasNext()) {
				MembershipSubscription membershipSubscriptionDelete = (MembershipSubscription)msDynamicQueryByShippingEmailItr.next();
				MembershipSubscriptionLocalServiceUtil.deleteMembershipSubscription(membershipSubscriptionDelete);
			}

			MembershipSubscriptionLocalServiceUtil.addMembershipSubscription(entityImpl);
			ServiceComponentsLocalServiceUtil.deleteMembershipSubscriptionAddonBySessionId(sessionId);

			for (int i = 0; i < rowCount; i++) {
				String code = codeNumberItr.next();

				mpAddonId = req.getParameter("mpAddonId" + code);
				scName = req.getParameter("scName" + code);
				scId = req.getParameter("scId" + code);
				paramFrom = req.getParameter("paramFrom" + code);
				paramUpto = req.getParameter("paramUpto" + code);
				paramType = req.getParameter("paramType" + code);

				serviceChargesCurrency = "SGD";
				serviceCharges = req.getParameter("serviceCharges" + code);
				serviceChargesPeriodType = req.getParameter("serviceChargesPeriodType" + code);

				// primary key

				long msAddonId = CounterLocalServiceUtil.increment("MembershipSubscriptionAddonServices.class");
				_log.info("MembershipSubscriptionAddonServices KEY IS : " + msAddonId);

				msAddon = MembershipSubscriptionAddonServicesLocalServiceUtil.createMembershipSubscriptionAddonServices(msAddonId);

				msAddon.setPrimaryKey(msAddonId);
				msAddon.setMsId(pKey);
				msAddon.setScName(scName);
				msAddon.setScId(scId);
				msAddon.setParamFrom(paramFrom);
				msAddon.setParamUpto(paramUpto);
				msAddon.setParamType(paramType);

				ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);

				User user = themeDisplay.getUser();

				msAddon.setExtra1(mpId_1);// String.valueOf(themeDisplay.getUser().getUserId()));
				msAddon.setDescription(sessionId);
				MembershipSubscriptionAddonServicesLocalServiceUtil.addMembershipSubscriptionAddonServices(msAddon);
			}
		}
	}

	public boolean validateUserInfo(RenderRequest actionRequest) throws DuplicateUserEmailAddressException, RequiredPasswordPolicyException, PromotionCodeNotMatchException,
			PromotionCodePeriodException, NoSuchMembershipPackageException, NoPromotionCodeForMembershipException, Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		boolean ok = false;
		long mpIdLong = 0;
		long corporateId = 0L;
		String memberType = actionRequest.getParameter("memberType");

		if (MultiVMPoolUtil.get("corporateId", "corporateId" + actionRequest.getRequestedSessionId()) != null)
			corporateId = (Long) MultiVMPoolUtil.get("corporateId", "corporateId" + actionRequest.getRequestedSessionId());

		String password_ = actionRequest.getParameter("_58_password1");
		String firstName = actionRequest.getParameter("_58_firstName");
		String lastName = actionRequest.getParameter("_58_lastName");
		String userType = actionRequest.getParameter("userType");
		String terms = actionRequest.getParameter("terms");
		String promotion_code = actionRequest.getParameter("_58_promotion_code");
		String corporateName = actionRequest.getParameter("corporateName");
		String claimFlow = actionRequest.getParameter("claimFlow");

		String emailAddress = actionRequest.getParameter("_58_emailAddress");
		_log.info("authen_p_p ::::: " + actionRequest.getParameter("authen_p_p"));
		_log.info("promotion_code ::::: " + promotion_code);
		_log.info("memberType ::::: " + memberType);

		if (memberType == null || memberType.trim().equals("")) {
			throw new NoSuchMembershipPackageException();
		}

		try {
			mpIdLong = Long.parseLong(memberType);
		} catch (Exception exception) {
			throw new NoSuchMembershipPackageException();
		}

		boolean isPromotionCode = _isPromotionCode(mpIdLong, promotion_code, request);
		boolean isPormotionPeriod = false;

		if (isPromotionCode) {
			isPormotionPeriod = _isPromotionPeriod(mpIdLong, promotion_code);
		}

		// boolean isPormotionPeriod = _isPromotionPeriod(mpIdLong,
		// promotion_code);

		if (terms == null || terms.trim().equals("")) {
			throw new RequiredPasswordPolicyException();
		}

		if (terms.equalsIgnoreCase("off")) {
			throw new RequiredPasswordPolicyException();
		}

		if (firstName == null || firstName.trim().equals("")) {
			throw new ContactFirstNameException();
		}

		if (lastName == null || lastName.trim().equals("")) {
			throw new ContactLastNameException();
		}

		// modified by sriram to allow corporate claim

		if ((userType == null || "".equals(userType)) && corporateId == 0L) {
			throw new NoSuchOrganizationException();
		}

		// if (!isPromotionCode) { throw new PromotionCodeNotMatchException(); }

		//

		// if (promotion_code!=null) { if (!promotion_code.trim().equals("")) {
		// if (!isPormotionPeriod) { throw new PromotionCodePeriodException(); }
		// } }

		MembershipPackage membershipPackage = MembershipPackageLocalServiceUtil.getMembershipPackage(mpIdLong);
		_log.info("promotion code in MembershipPackage : " + membershipPackage.getPromotionCode());
		List<MembershipPackagePromotionCode> mpPromotionCodeList = MembershipPackagePromotionCodeLocalServiceUtil.findBymembershipPackage_Id(mpIdLong);

		if (promotion_code != null) {

			// if (membershipPackage.getPromotionCode().trim().equals("")) {

			if (mpPromotionCodeList.size() < 1) {
				if (!promotion_code.trim().equals("")) {
					_log.info("There is no promotion code for membership ");
					throw new NoPromotionCodeForMembershipException();
				}
			}
		}

		HttpSession session = request.getSession();
		SessionErrors.add(request, "promotionFrom", promotionFrom);
		SessionErrors.add(request, "promotionTo", promotionTo);
		request.setAttribute("promotionFrom", promotionFrom);
		request.setAttribute("promotionTo", promotionTo);
		_log.info("isPromotionCode " + isPromotionCode);

		if (!isPromotionCode) {
			if (promotion_code != null) {
				if (!promotion_code.trim().equals(""))
					throw new PromotionCodeNotMatchException();
			}

			// else without promotion code entry will do...

		}

		if (promotion_code != null) {
			if (!promotion_code.trim().equals("")) {
				if (!isPormotionPeriod) {
					throw new PromotionCodePeriodException();
				}
			}
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// long companyid = themeDisplay.getCompanyId();

//		ValidationUtil validationUtil = new ValidationUtil();

//		validationUtil.validateEmailAddress(themeDisplay.getCompanyId(), emailAddress);

		// validationUtil.validatePassword(companyid,themeDisplay.getDefaultUserId(),password_,password_);

		if (!validatePassword(password_)) {
			throw new NoSuchPasswordPolicyException();
		}

		PasswordPolicy passwordPolicy = PasswordPolicyLocalServiceUtil.getPasswordPolicyByUserId(themeDisplay.getDefaultUserId());
		BasicToolkit _toolkit = (BasicToolkit)InstancePool.get(PropsUtil.get(PropsKeys.PASSWORDS_TOOLKIT));

		_toolkit.validate(themeDisplay.getDefaultUserId(), password_, password_, passwordPolicy);

		// validate(themeDisplay.getDefaultUserId(), password_, password_,
		// passwordPolicy);

		// boolean isDuplicate =
		// UserProfileBasicLocalServiceUtil.existsUserProfileBasic(emailAddress);

		User existUser = null;
		try {
			existUser = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), emailAddress);
		} catch (Exception e) {
			_log.debug("No user found with given email id.");
		}

		if (existUser != null)
			throw new DuplicateUserEmailAddressException();

		// * YS - C&O new field corporateName added on jsp create_account.jsp

		 //* forwarded to membershipsubscription_form.jsp to capture Corporate
		 //* Name when Member Type defined = Corporate

		_log.info(">>>>>corporateName from request scope=" + corporateName);

		if (userType != null && "Corporate".equalsIgnoreCase(userType)) {

			// name check

			if ((corporateName == null || corporateName.trim().length() == 0) && corporateId == 0L) {
				throw new CorporateProfileException("Corporate name is required.");
			}

			// check for unique corporate name

			CorporateProfile corpProfile = null;
			try {
				corpProfile = CorporateProfileLocalServiceUtil.findByCorporateIdByName(corporateName);
				throw new NoSuchCorporateProfileException("A Corporate with the same name already exists.");
			} catch (NoSuchCorporateProfileException e) {

				// continue then

				_log.info("Corporate name is available to be created");
			}

			// email address check

			if (!isValidCorporateEmailDomain(emailAddress, themeDisplay.getScopeGroupId())) {
				_log.info(">>>>>Corporate User email domain entered belongs to blacklist configured in AssetCategories set");
				throw new UserEmailAddressException("Corporate User email domain entered is not allowed!");
			}

			// populate MultiVM with corporate Name - normal corporate create
			// workflow

			if (corporateId == 0L) {
				MultiVMPoolUtil.put("corporateName", "corporate" + actionRequest.getRequestedSessionId(), corporateName);
				_log.info(">>>>>Adding corporateName=" + corporateName + " to MultiVMPoolUtil with =" + corporateName + " using key=corporate" + actionRequest.getRequestedSessionId());
			}
		}
		//* YS - END

		return ok;
	}

	public boolean validatePassword(String checkPassword) {
		String str = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
		String num = "1,2,3,4,5,6,7,8,9,0";
		String[] strArray = str.split(",");
		String[] numArray = num.split(",");
		boolean strBoolean = false;
		boolean numBoolean = false;
		boolean lengthBoolean = false;

		if (checkPassword.length() >= 8) {
			lengthBoolean = true;
		}

		strloop: for (int j = 0; j < checkPassword.length(); j++) {
			for (int i = 0; i < strArray.length; i++) {
				if (checkPassword.contains(strArray[i])) {
					strBoolean = true;
					break strloop;
				}
			}
		}

		numloop: for (int j = 0; j < checkPassword.length(); j++) {
			for (int i = 0; i < numArray.length; i++) {
				if (checkPassword.contains(numArray[i])) {
					numBoolean = true;
					break numloop;
				}
			}
		}

		return (strBoolean && numBoolean && lengthBoolean);
	}

	public static PortletURL getCreateAccountURL(HttpServletRequest request) throws PortletModeException, WindowStateException {

		// String portletkey = "58";

		PortletURL portletURL = new PortletURLImpl(request, PortletKeys.LOGIN, Long.parseLong(PortletKeys.LOGIN), PortletRequest.RENDER_PHASE);

		portletURL.setWindowState(WindowState.MAXIMIZED);
		portletURL.setPortletMode(PortletMode.VIEW);

		portletURL.setParameter("saveLastPath", "/login/create_account");
		portletURL.setParameter("struts_action", "/login/create_account");

		return portletURL;
	}

	protected boolean isValidCorporateEmailDomain(String corpUserEmailAddress, long groupId) throws CorporateProfileException {
		boolean corpEmailDomainIsValid = false;

		_log.info(">>>>>corpUserEmailAddress to be validated=" + corpUserEmailAddress);
		StrTokenizer tokens = new StrTokenizer(corpUserEmailAddress, "@");
		_log.info("Email string tokens: " + tokens.getTokenList());
		String emailDomainStr = (String)tokens.getTokenList().get(tokens.getTokenList().size() - 1);
		_log.info(">>>>>corpUserEmailAddress domain extracted=" + emailDomainStr);

		if (emailDomainStr != null && emailDomainStr.trim().length() > 0) {
			try {
				SPParameters param = SPParametersLocalServiceUtil.findBySPParametersGroupIdAndName(groupId, SambaashConstants.CATEGORIES.CORP_REGISTRATION_RESTRICTED_DOMAIN);
				AssetVocabulary vocab = AssetVocabularyLocalServiceUtil.getGroupVocabulary(groupId, param.getValue());
				int categoriesCount = AssetCategoryLocalServiceUtil.getAssetCategoriesCount();
				List<AssetCategory> categories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocab.getVocabularyId(), 0, categoriesCount, null);

				if (categories == null || categories.size() == 0) {
					_log.info(">>>>>AssetCategories with key Restricted domains is NOT SETUP");
				} else {
					Scanner scanner = new Scanner(emailDomainStr.toUpperCase());
					String scannerResult = null;

					for (int f = 0; f < categories.size(); f++) {
						_log.info(">>>>>Current forbidden email domain being validated against =" + categories.get(f).getName());
						scannerResult = scanner.findInLine(categories.get(f).getName().toUpperCase());
						_log.info(">>>>>Result of scanner.findInLine(forbiddenCorpEmailDomainList.get(f).getName().toUpperCase()) =" + scannerResult);

						if (scannerResult != null && scanner != null && scanner.hasNext()) {
							_log.info(">>>>>corpUserEmailAddress emailDomainStr contains domain/s from forbiddenCorpEmailDomainList set! Returning failure at Corporate User Email validation!");
							corpEmailDomainIsValid = false;
							break;
						} else {
							corpEmailDomainIsValid = true;
						}
					}
				}
			} catch (Exception e) {

			}
		}

		return corpEmailDomainIsValid;
	}

	protected List<ListType> getListTypes(String key) throws CorporateProfileException {
		List<ListType> listTypeList = null;
		try {
			_log.info(">>>>>Retrieving ListType entries for key=" + key);
			listTypeList = ListTypeServiceUtil.getListTypes(key);
			_log.info(">>>>>Items in retrieved ListType for key=" + key + " : " + listTypeList);
		} catch (SystemException e) {
			_log.error(e.getCause());
			throw new CorporateProfileException(" Error getting List Types values\n" + e.getMessage());
		}

		return listTypeList;
	}

	protected boolean _isPromotionPeriod(long mpId, String promotionCode) throws PortalException, SystemException {
		MembershipPackage membershipPackage = MembershipPackageLocalServiceUtil.getMembershipPackage(mpId);

		promotionFrom = getPromotionFrom(mpId, promotionCode);
		promotionTo = getPromotionTo(mpId, promotionCode);
		_log.info("promotionFrom ::: " + promotionFrom);
		_log.info("promotionTo ::: " + promotionTo);
		Calendar calendar = Calendar.getInstance();
		Calendar calendarFrom = Calendar.getInstance();
		Calendar calendarTo = Calendar.getInstance();

		calendarFrom.setTime(promotionFrom);
		calendarTo.setTime(promotionTo);

		// calendarFrom.add(Calendar.DATE, -1);

		calendarTo.add(Calendar.DATE, 1);

		if (!(calendar.after(calendarFrom) && calendar.before(calendarTo))) {
			return false;
		} else
			return true;

	}

	public static Date getPromotionFrom(long mpId, String promotionCode) {
		Date mpPromotionFrom = null;
		List<MembershipPackagePromotionCode> mpPromotionCodeList = null;
		try {
			mpPromotionCodeList = MembershipPackagePromotionCodeLocalServiceUtil.findBymembershipPackage_Id(mpId);
			Iterator<MembershipPackagePromotionCode> mpPromotionCodeItr = mpPromotionCodeList.iterator();
			while (mpPromotionCodeItr.hasNext()) {
				MembershipPackagePromotionCode mpPromotionCode = mpPromotionCodeItr.next();

				_log.info("mpPromotionCode.getPromotionFrom() ::: " + mpPromotionCode.getPromotionFrom());

				if (mpPromotionCode.getPromotionCode().equals(promotionCode)) {
					mpPromotionFrom = mpPromotionCode.getPromotionFrom();
				}
			}
		} catch (Exception e) {

		}

		return mpPromotionFrom;
	}

	public static Date getPromotionTo(long mpId, String promotionCode) throws SystemException {
		Date mpPromotionTo = null;
		List<MembershipPackagePromotionCode> mpPromotionCodeList = null;
		try {
			mpPromotionCodeList = MembershipPackagePromotionCodeLocalServiceUtil.findBymembershipPackage_Id(mpId);
			Iterator<MembershipPackagePromotionCode> mpPromotionCodeItr = mpPromotionCodeList.iterator();
			while (mpPromotionCodeItr.hasNext()) {
				MembershipPackagePromotionCode mpPromotionCode = mpPromotionCodeItr.next();

				_log.info("mpPromotionCode.getPromotionTo() ::: " + mpPromotionCode.getPromotionTo());

				if (mpPromotionCode.getPromotionCode().equals(promotionCode)) {
					mpPromotionTo = mpPromotionCode.getPromotionTo();
				}
			}
		} catch (Exception e) {

		}

		return mpPromotionTo;
	}

	protected boolean _isPromotion(long mpId, String promotionCode, HttpServletRequest request) throws PortalException, PromotionCodeNotMatchException, SystemException {
		boolean isPromotionCode = _isPromotionCode(mpId, promotionCode, request);
		boolean isPromotionPeriod = false;

		if (isPromotionCode == true) {
			isPromotionPeriod = _isPromotionPeriod(mpId, promotionCode);
		}

		_log.info("isPromotionCode ::: " + isPromotionCode);
		_log.info("isPromotionPeriod ::: " + isPromotionPeriod);

		if (promotionCode != null && (!promotionCode.trim().equals(""))) {
			if (isPromotionCode) {
				if (!isPromotionPeriod) {
					request.setAttribute("is_promotion_period", "not_promotion_period");
					_log.info("Not Promotion Period");
					throw new PromotionCodePeriodException();
				}
			} else {

				// check multiple promotioncode

				List<MembershipPackagePromotionCode> mpPromotionCodeList = MembershipPackagePromotionCodeLocalServiceUtil.findBymembershipPackage_Id(mpId);
				_log.info(" MembershipPackagePromotionCode List Size : " + mpPromotionCodeList.size());

				if (mpPromotionCodeList.size() < 1) {
					request.setAttribute("has_promotion_code", "not_having_promotion_code");
					_log.info("There is no promotion code for membership ");
					throw new NoPromotionCodeForMembershipException();
				} else {
					request.setAttribute("is_promotion_code", "not_promotion_code");
					_log.info("There is no promotion code");
					throw new PromotionCodeNotMatchException();
				}
			}
		}

		return true;
	}

	protected boolean _isPromotionCode(long mpId, String promotionCode, HttpServletRequest request) throws PortalException, SystemException {
		boolean isPromotionCode = false;

		// MembershipPackage membershipPackage =
		// MembershipPackageLocalServiceUtil.getMembershipPackage(mpId); add for
		// checking multiple promotion code

		List<MembershipPackagePromotionCode> mpPromotionCodeList = MembershipPackagePromotionCodeLocalServiceUtil.findBymembershipPackage_Id(mpId);
		Iterator<MembershipPackagePromotionCode> mpPromotionCodeItr = mpPromotionCodeList.iterator();
		while (mpPromotionCodeItr.hasNext()) {
			MembershipPackagePromotionCode mpPromotionCode = mpPromotionCodeItr.next();

			_log.info("mpPromotionCode.getPromotionCode() ::: " + mpPromotionCode.getPromotionCode());
			_log.info("PromotionCode ::: " + promotionCode);

			if (mpPromotionCode.getPromotionCode().equals(promotionCode)) {
				request.setAttribute("mpPromotionCodeId", mpPromotionCode.getPromotionCode_id());

				isPromotionCode = true;
			} else {
				request.setAttribute("is_promotion_code", "not_promotion_code");
			}
		}

		_log.info("ispromotioncode : " + isPromotionCode);
		return isPromotionCode;
	}

	/**
	 * End -- Methods declared in MembershipSubscriptionAction
	 *
	 */
}