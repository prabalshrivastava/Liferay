package com.sambaash.platform.sppayment.provider.exception;

public class PaymentCustomerException extends Exception{

	public PaymentCustomerException() {
		super();
	}

	public PaymentCustomerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PaymentCustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentCustomerException(String message) {
		super(message);
	}

	public PaymentCustomerException(Throwable cause) {
		super(cause);
	}

}
