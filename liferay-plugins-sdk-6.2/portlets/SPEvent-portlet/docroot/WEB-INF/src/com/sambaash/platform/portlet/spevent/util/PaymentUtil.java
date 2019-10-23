package com.sambaash.platform.portlet.spevent.util;

import java.util.Calendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.sambaash.platform.model.Paypal;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.model.RsvpDetail;
import com.sambaash.platform.srv.rsvp.model.RsvpDiscount;
import com.sambaash.platform.srv.rsvp.model.RsvpPayment;
import com.sambaash.platform.srv.rsvp.model.RsvpPromoCode;
import com.sambaash.platform.srv.rsvp.model.RsvpTicket;
import com.sambaash.platform.srv.rsvp.service.RsvpDiscountLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpPaymentLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpPromoCodeLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpTicketLocalServiceUtil;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.util.PaypalUtil;
public class PaymentUtil {

	public RsvpPayment addPaymentDetails(ActionRequest actionRequest, ThemeDisplay themeDisplay, RsvpDetail rsvpDetail,
			Rsvp rsvp, boolean minPriceFlag, double discount, long rsvpPromoCodeId) throws SystemException {

		float tax = Float.parseFloat(rsvp.getTax());
		double pricePerItem = 0.0;
		long spTicketRsvpId = 0;

		if (minPriceFlag) {
			pricePerItem = Double.parseDouble(actionRequest.getParameter("minPrice"));
		} else {
			spTicketRsvpId = Long.parseLong(actionRequest.getParameter("priceList"));
			try {
				RsvpTicket spRsvpTicket = RsvpTicketLocalServiceUtil.getRsvpTicket(spTicketRsvpId);
				pricePerItem = spRsvpTicket.getPrice();
			} catch (Exception e) {
				_log.error("Retrieving price is not valid ");
			}
		}

		double totalPrice = pricePerItem * rsvpDetail.getNumberOfPeople();
		double netTotal = totalPrice + (tax / 100 * totalPrice) - discount;

		long rsvpPaymentId = CounterLocalServiceUtil.increment("RsvpPayment.class");

		RsvpPayment rsvpPayment = RsvpPaymentLocalServiceUtil.createRsvpPayment(rsvpPaymentId);
		rsvpPayment.setTicketNumber(null);
		rsvpPayment.setGroupId(themeDisplay.getScopeGroupId());
		rsvpPayment.setRsvpDetailId(rsvpDetail.getRsvpDetailId());
		rsvpPayment.setNetTotal(netTotal);
		rsvpPayment.setNumberOfPeople(rsvpDetail.getNumberOfPeople());
		rsvpPayment.setPrice(pricePerItem);
		rsvpPayment.setRsvpId(rsvp.getRsvpId());
		rsvpPayment.setRsvpTicketId(spTicketRsvpId);

		if (rsvpPayment.getNetTotal() == 0 && rsvpPromoCodeId > 0) {
			rsvpPayment.setTransactionStatus("Completed");
		} else {
			rsvpPayment.setTransactionStatus("pending");
		}

		if (rsvpPromoCodeId > 0) {
			rsvpPayment.setRsvpPromoCodeId(rsvpPromoCodeId);
		}

		return RsvpPaymentLocalServiceUtil.updateRsvpPayment(rsvpPayment);
	}

	public double getDiscount(long ticketId, long rsvpId, int numberOfTickets, String promoCodeFlag, String promoCode) {
		Calendar currentDate = Calendar.getInstance();
		currentDate.setTime(DateUtil.newDate());
		currentDate.set(Calendar.SECOND, 0);

		try {
			_log.error("rsvpId :" + rsvpId + " : price :" + ticketId + " : fromDate :" + currentDate.getTime() +
					" : toDate :" + currentDate.getTime());

			if ("true".equalsIgnoreCase(promoCodeFlag)) {
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RsvpPromoCode.class,
						PortletClassLoaderUtil.getClassLoader("RSVP_WAR_SPEventportlet"));
				dynamicQuery.add(PropertyFactoryUtil.forName("rsvpId").eq(new Long(rsvpId)))
						.add(PropertyFactoryUtil.forName("spRsvpTicketId").eq(new Long(ticketId)))
						.add(PropertyFactoryUtil.forName("noOfTickets").eq(new Integer(numberOfTickets)))
						.add(PropertyFactoryUtil.forName("promoCode").eq(new String(promoCode)))
						.add(PropertyFactoryUtil.forName("fromDate").le(currentDate.getTime()))
						.add(PropertyFactoryUtil.forName("toDate").ge(currentDate.getTime()));

				@SuppressWarnings("unchecked")
				List<RsvpPromoCode> rsvpRsvpPromoCodeList = RsvpPromoCodeLocalServiceUtil.dynamicQuery(dynamicQuery);

				if (rsvpRsvpPromoCodeList == null || rsvpRsvpPromoCodeList.size() > 1) {
					throw new Exception("Invalid promo code setup.");
				}

				for (RsvpPromoCode rsvpPromoCode : rsvpRsvpPromoCodeList) {
					return rsvpPromoCode.getDiscount();
				}

			} else {

				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(RsvpDiscount.class,
						PortletClassLoaderUtil.getClassLoader("RSVP_WAR_SPEventportlet"));
				dynamicQuery.add(PropertyFactoryUtil.forName("rsvpId").eq(new Long(rsvpId)))
						.add(PropertyFactoryUtil.forName("spRsvpTicketId").eq(new Long(ticketId)))
						.add(PropertyFactoryUtil.forName("noOfTickets").eq(new Integer(numberOfTickets)))
						.add(PropertyFactoryUtil.forName("fromDate").le(currentDate.getTime()))
						.add(PropertyFactoryUtil.forName("toDate").ge(currentDate.getTime()));

				@SuppressWarnings("unchecked")
				List<RsvpDiscount> rsvpDiscountList = RsvpDiscountLocalServiceUtil.dynamicQuery(dynamicQuery);

				if (rsvpDiscountList == null || rsvpDiscountList.size() > 1) {
					throw new Exception("Invalid discount setup.");
				}

				for (RsvpDiscount rsvpDiscount : rsvpDiscountList) {
					return rsvpDiscount.getDiscount();
				}
			}

		} catch (Exception e) {
			_log.error(e);
		}

		return 0;
	}

	public Paypal processPaypalPayment(ActionRequest actionRequest, ThemeDisplay themeDisplay, RsvpPayment rsvpPayment,
			SPMailCampaign campaign, SPMailCampaignSubscribers subscriber, Rsvp rsvp, String promoCodeFlag,
			String promoCode) throws NoSuchSPParameterException, SystemException, WindowStateException {

		double discount = getDiscount(rsvpPayment.getRsvpTicketId(), rsvp.getRsvpId(), rsvpPayment.getNumberOfPeople(),
				promoCodeFlag, promoCode);

		PortletURL portletRenderUrl = PortletURLFactoryUtil.create(actionRequest, "RSVP_WAR_SPEventportlet",
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		portletRenderUrl.setWindowState(WindowState.MAXIMIZED);

		PortletURL portletActionUrl = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				"RSVP_WAR_SPEventportlet", themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
		portletActionUrl.setWindowState(WindowState.MAXIMIZED);

		String notifyUrl = PortalUtil.getPortalURL(actionRequest) + "/paymentnotification";
		notifyUrl = HttpUtil.setParameter(notifyUrl, "spTxnId", rsvpPayment.getRsvpPaymentId());
		notifyUrl = HttpUtil.setParameter(notifyUrl, "groupid", themeDisplay.getScopeGroupId());

		String cancelReturnUrl = portletActionUrl.toString();
		cancelReturnUrl = HttpUtil.setParameter(cancelReturnUrl, "action", "cancel");
		cancelReturnUrl = HttpUtil.setParameter(cancelReturnUrl, "spTxnId", rsvpPayment.getRsvpPaymentId());
		cancelReturnUrl = HttpUtil.setParameter(cancelReturnUrl, "groupid", themeDisplay.getScopeGroupId());

		String paymentReturnUrl = portletActionUrl.toString();
		paymentReturnUrl = HttpUtil.setParameter(paymentReturnUrl, "action", "return_payment");

		StringBuilder sb = new StringBuilder();
		sb.append("rsvpPaymentId").append(StringPool.EQUAL).append(rsvpPayment.getRsvpPaymentId())
				.append(StringPool.AMPERSAND).append("rsvpId").append(StringPool.EQUAL).append(rsvp.getRsvpId())
				.append(StringPool.AMPERSAND).append("spCampaignId").append(StringPool.EQUAL)
				.append(campaign.getSpMailCampaignId()).append(StringPool.AMPERSAND).append("spSubscriberId")
				.append(StringPool.EQUAL).append(subscriber.getSpMailCampaignSubscribersId())
				.append(StringPool.AMPERSAND).append("groupid").append(StringPool.EQUAL)
				.append(themeDisplay.getScopeGroupId());

		String encryptedParams = SPMailLocalServiceUtil.encryptLink(sb.toString());
		paymentReturnUrl = HttpUtil.setParameter(paymentReturnUrl, "spTxnId", encryptedParams);

		Paypal paypal = new Paypal();

		if (Validator.isNotNull(rsvp.getAccountId())) {
			paypal.setPaypalId(rsvp.getAccountId());
		} else {
			paypal.setPaypalId(PaypalUtil.getPaypalId(themeDisplay.getScopeGroupId()));
		}

		paypal.setEmailAddress(subscriber.getEmailAddress());
		paypal.setTaxRate(Float.parseFloat(rsvp.getTax()));
		paypal.setItemNumber(rsvp.getTitle()); // value will be

												// returned upon payment
		// completion

		paypal.setItemName(rsvp.getDescription()); // description
		paypal.setShippingFlag(1); // 1 do not prompt for an address
		paypal.setQuantity(rsvpPayment.getNumberOfPeople());

		if (discount > 0) {
			paypal.setTotal(Math.round((rsvpPayment.getPrice() - (rsvpPayment.getPrice() * discount / 100)) * 100.0) / 100.0);
		} else {
			paypal.setTotal(rsvpPayment.getPrice());
		}

		paypal.setReturnMethod(2); // 2 the payer's browser is

									// redirected to the return URL by the POST
									// method, and all transaction variables are
									// also posted

		paypal.setPaypalGatewayURL(PaypalUtil.getPaypalGatewayURL(themeDisplay.getScopeGroupId()));
		paypal.setPaypalButtonURL(PaypalUtil.getPaymentBtnURL(themeDisplay.getScopeGroupId()));
		paypal.setCancelURL(cancelReturnUrl.toString());
		paypal.setReturnURL(paymentReturnUrl.toString());
		paypal.setNotificationURL(notifyUrl.toString());
		paypal.setCurrencyCode(rsvp.getCurrency());
		paypal.setLocation(PaypalUtil.getPaypalDefaultLocation(themeDisplay.getScopeGroupId()));
		paypal.setSubType(PaypalUtil.PAYPAL_SERVICES);
		paypal.setImgURL1(themeDisplay.getPathThemeImages() + "/paypal/AM_SbyPP_mc_vs_dc_ae.jpg");
		paypal.setImgURL2(themeDisplay.getPathThemeImages() + "/paypal/AM_SbyPP_mc_vs_dc_ae.jpg");
		paypal.setLogoUrl(PortalUtil.getPortalURL(actionRequest) + themeDisplay.getCompanyLogo());
		paypal.setCppHeaderImage(PortalUtil.getPortalURL(actionRequest) + themeDisplay.getCompanyLogo());

		return paypal;
	}

	private static Log _log = LogFactoryUtil.getLog(PaymentUtil.class);

}