package com.sambaash.platform.sppayment.action;

import java.io.IOException;
import java.math.BigDecimal;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.model.payment.ChargeStatus;
import com.sambaash.platform.model.payment.PaymentProvider;
import com.sambaash.platform.sppayment.SPPaymentConstants;
import com.sambaash.platform.sppayment.provider.PaymentProviderFactory;
import com.sambaash.platform.srv.sppayment.service.SPPaymentLocalServiceUtil;
import com.sambaash.platform.util.wrapper.HttpServletRequestWrapperExtended;

/**
 * Portlet implementation class SPCartPayment
 */
public class SPCartPayment extends MVCPortlet {

	private static final String RESULT_PAGE = "/html/spcartpayment/view.jsp";

	private static Log logger = LogFactoryUtil.getLog(SPCartPayment.class);

	private static final String PAGE_PAY_RESULT = "/html/common/payResult.jsp";
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		//TODO: glenn retrieve from passed parameters
		BigDecimal payAmount = new BigDecimal("1500.00");
		String currency = "sgd";
		String locale="auto";
//		String logoUrl = "/Lithan-v3-theme/images/menu/LithanHall_Logo2Footer.png";
		String logoUrl = "/Lithan-v3-theme/images/login/globe.svg";
		String payDesc = "Course Fee Payment";
		String siteName = "sambaash.com";
		String payEmail = "";
		String provider="stripe";
		try {
			User user = PortalUtil.getUser(renderRequest);
			payEmail = user.getEmailAddress();
			PaymentProvider payProvider = PaymentProviderFactory.newPaymentProvider(provider, renderRequest);
			payProvider.addProviderCheckout(renderRequest, payAmount, currency, locale, logoUrl, payDesc, siteName, payEmail);
		} catch (Exception e) {
			logger.error(e);
		}
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		
		try {
			HttpServletRequestWrapper httpRequest = new HttpServletRequestWrapperExtended(
					PortalUtil.getHttpServletRequest(resourceRequest));
			AuthTokenUtil.checkCSRFToken(httpRequest,
					SPPaymentConstants.class.getName());
		} catch (PortalException e1) {
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put(SPPaymentConstants.STATUS, SPPaymentConstants.FAIL);
			obj.put(SPPaymentConstants.ERROR_MSG,
					SPPaymentConstants.UNAUTH_MSG_VIEW);
			logger.error(e1);
			resourceResponse.getWriter().write(obj.toString());
			return;
		}
		
		String action = ParamUtil.getString(resourceRequest, SPPaymentConstants.ACTION);
		
		switch (action) {
			case "createPayment":
				try {
					ChargeStatus status = SPPaymentLocalServiceUtil.chargePayment(resourceRequest);
					logger.debug("Payment Successful ? "+status.isSuccess());
					resourceRequest.setAttribute("charge_ref_code", status.getChargeId());
					include(RESULT_PAGE, resourceRequest, resourceResponse);
					return;
				} catch (Exception e) {
					logger.error(e);
				}
				break;
			case "refund":
				try {
					ChargeStatus status = SPPaymentLocalServiceUtil.refundPayment(resourceRequest);
					logger.debug("Refund Successful ? "+status.isSuccess());
					resourceRequest.setAttribute("refund_ref_code", status.getChargeId());
					include(RESULT_PAGE, resourceRequest, resourceResponse);
					return;
				} catch (Exception e) {
					logger.error(e);
				}
				break;
			default :
				// no action
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

}
