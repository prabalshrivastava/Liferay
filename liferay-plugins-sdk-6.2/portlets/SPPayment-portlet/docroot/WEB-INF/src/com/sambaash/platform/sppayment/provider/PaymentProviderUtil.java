package com.sambaash.platform.sppayment.provider;

import com.sambaash.platform.model.payment.PaymentProvider;
import com.sambaash.platform.util.SambaashUtil;

public class PaymentProviderUtil {
	public static String getPublicKey(long groupId, String providerName) {
		return SambaashUtil.getParameter(providerName + PaymentProvider.PUBLIC_KEY_PARAM_SUFFIX, groupId);
	}

	public static String getSecretKey(long groupId, String providerName) {
		return SambaashUtil.getParameter(providerName + PaymentProvider.SECRET_KEY_PARAM_SUFFIX, groupId);
	}
}
