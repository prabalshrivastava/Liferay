package com.sambaash.platform.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;

public class PaypalUtil {
	private static Log _log = LogFactoryUtil.getLog(PaypalUtil.class);
	private static final String PAYPAL_DEFAULT_LOCATION = "subscription.paypal.default.location";
	private static final String PAYPAL_DEFAULT_CURRENCY = "subscription.paypal.default.currencycode";

	public static final String PAYPAL_SERVICES = "services";
	public static final String STATUS_PENDING = "Pending";

	public static String getPaypalDefaultLocation(long groupId) throws NoSuchSPParameterException, SystemException {

		return SambaashUtil.getParameter(PAYPAL_DEFAULT_LOCATION, groupId);

	}

	public static String getPaypalDefaultCurrencyCode(long groupId) throws NoSuchSPParameterException, SystemException {

		return SambaashUtil.getParameter(PAYPAL_DEFAULT_CURRENCY, groupId);

	}

	public static String getCommunityDescription(long scopeGroupId) {
		try {
			Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);
			return group.getDescription();
		} catch (Exception e) {
			_log.error("Error getting community name. Returning empty string");
		}
		return "";
	}

	/**
	 * Returns TRUE if transaction is an upgrade membership
	 * 
	 * @param httpRequest
	 * @return
	 */
	public static boolean isMembershipPackageUpgrade(String source) {
		if (Validator.isNotNull(source) && source.equals("upgrade")) {
			return true;
		}
		return false;
	}

	public static String getPaypalGatewayURL(long groupId) {

		return SambaashUtil.getParameter(SambaashConstants.PAYMENTGATEWAY.PAYMENT_GATEWAY_URL, groupId)
				+ "/cgi-bin/webscr";

	}

	public static String getPaymentBtnURL(long groupId) {

		return SambaashUtil.getParameter(SambaashConstants.PAYMENTGATEWAY.PAYMENT_GATEWAY_BUTTON_URL, groupId)
				+ "/en_US/i/btn/btn_buynowCC_LG.gif";

	}

	public static String getPaypalId(long groupId) {

		return SambaashUtil.getParameter(SambaashConstants.PAYPAL_PAYPALID, groupId);

	}

	public static float getTaxFactor(long groupId) {
		float taxFactor = 0.0f;
		try {
			taxFactor = Float.parseFloat(SambaashUtil.getParameter(SambaashConstants.PAYPAL_TAXFACTOR, groupId));
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		return taxFactor;
	}
}