package com.sambaash.platform.pe.payment;

import static com.sambaash.platform.model.payment.PaymentProvider.*;

import java.math.BigDecimal;

import org.apache.commons.lang.math.NumberUtils;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sambaash.platform.model.payment.PaymentProvider;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;


public class PEPaymentUtil {
	
	public static String amountStringToBigIntegerString(String amount) {
		return bigDecimalToBigIntegerString(NumberUtils.createBigDecimal(amount));
	}
	
	public static String bigDecimalToBigIntegerString(BigDecimal amount) {
		return bigDecimalToBigIntegerString(amount, PaymentProvider.DEFAULT_AMOUNT_MULTIPLIER);
	}
	
	public static String bigDecimalToBigIntegerString(BigDecimal amount, BigDecimal multiplier) {
		return amount.multiply(multiplier).toBigInteger().toString();
	}
	
	public static void storeRefundInfo(PEProcessStateDataAdapter dataAdapter, PEProcessState stateB4Refund) {
		String stateJson = JSONFactoryUtil.looseSerialize(stateB4Refund);
		dataAdapter.store(PAY_REFUND_IN_PROGRESS, "true");
		dataAdapter.store(PAY_REFUND_RESUME_STATE, stateJson);
	}
	
	public static void clearRefundInfo(PEProcessStateDataAdapter dataAdapter) {
		dataAdapter.store(PAY_REFUND_IN_PROGRESS, "false");
		dataAdapter.store(PAY_REFUND_RESUME_STATE, "");
	}

}
