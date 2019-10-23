package com.sambaash.platform.model;

/**
 * @author gauravvijayvergia http://www.paypalobjects.com/IntegrationCenter/ic_std-variable-ref-buy-now.html
 */

public class Paypal {

	private String paypalId;
	private String emailAddress;
	private String location;
	private String itemName;
	private String itemNumber;
	private double total;
	private String currencyCode;
	private int quantity;
	private int shippingFlag;
	private float taxRate;
	private float shippingRate;
	private String returnURL; //payment confirmation page
	private String cancelURL; //A URL to which the customer's browser is returned if payment is canceled; for example, a URL on your website that displays a "Payment Canceled" page.
	private String paypalButtonURL;
	private String paypalGatewayURL;
	private String notificationURL; //The URL to which PayPal posts information about the transaction via Instant Payment Notification. Must be URL-encoded.
	private int returnMethod;
	private String instruction;
	private String subType;
	private String imgURL1;
	private String imgURL2;
	private String logoUrl; //The URL of the 150x50-pixel image displayed as your logo in the upper left corner of PayPal's pages. Must be URL-encoded.
	private String cppHeaderImage; //top left of the payment page. The image's maximum size is 750 pixels wide by 90 pixels high
	private String cppHeaderbackColor; //background color for the header of the payment page
	private String cppHeaderborderColor; //border color around the header of the payment page. The border is a two-pixel perimeter around the header space, which has a maximum size of 750 pixels wide by 90 pixels high
	private String cppPayflowColor; //background color for the payment page below the header. Valid value is case-insensitive six-character HTML hexadecimal color code in ASCII
	private String cs; //Sets the background color of your payment pages. Default or 0 = background color is white. 1 = background color is black.
	
	public Paypal() {
	}

	public String getPaypalId() {
		return paypalId;
	}

	public void setPaypalId(String paypalId) {
		this.paypalId = paypalId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getShippingFlag() {
		return shippingFlag;
	}

	public void setShippingFlag(int shippingFlag) {
		this.shippingFlag = shippingFlag;
	}

	public float getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}

	public float getShippingRate() {
		return shippingRate;
	}

	public void setShippingRate(float shippingRate) {
		this.shippingRate = shippingRate;
	}

	public String getNotificationURL() {
		return notificationURL;
	}

	public void setNotificationURL(String notificationURL) {
		this.notificationURL = notificationURL;
	}

	public String getReturnURL() {
		return returnURL;
	}

	public void setReturnURL(String returnURL) {
		this.returnURL = returnURL;
	}

	public String getCancelURL() {
		return cancelURL;
	}

	public void setCancelURL(String cancelURL) {
		this.cancelURL = cancelURL;
	}

	public String getPaypalButtonURL() {
		return paypalButtonURL;
	}

	public void setPaypalButtonURL(String paypalButtonURL) {
		this.paypalButtonURL = paypalButtonURL;
	}

	public String getPaypalGatewayURL() {
		return paypalGatewayURL;
	}

	public void setPaypalGatewayURL(String paypalGatewayURL) {
		this.paypalGatewayURL = paypalGatewayURL;
	}

	public int getReturnMethod() {
		return returnMethod;
	}

	public void setReturnMethod(int returnMethod) {
		this.returnMethod = returnMethod;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getImgURL1() {
		return imgURL1;
	}

	public void setImgURL1(String imgURL1) {
		this.imgURL1 = imgURL1;
	}

	public String getImgURL2() {
		return imgURL2;
	}

	public void setImgURL2(String imgURL2) {
		this.imgURL2 = imgURL2;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getCppHeaderImage() {
		return cppHeaderImage;
	}

	public void setCppHeaderImage(String cppHeaderImage) {
		this.cppHeaderImage = cppHeaderImage;
	}

	public String getCppHeaderbackColor() {
		return cppHeaderbackColor;
	}

	public void setCppHeaderbackColor(String cppHeaderbackColor) {
		this.cppHeaderbackColor = cppHeaderbackColor;
	}

	public String getCppHeaderborderColor() {
		return cppHeaderborderColor;
	}

	public void setCppHeaderborderColor(String cppHeaderborderColor) {
		this.cppHeaderborderColor = cppHeaderborderColor;
	}

	public String getCppPayflowColor() {
		return cppPayflowColor;
	}

	public void setCppPayflowColor(String cppPayflowColor) {
		this.cppPayflowColor = cppPayflowColor;
	}

	public String getCs() {
		return cs;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

	@Override
	public String toString() {
		return "Paypal [paypalId=" + paypalId + ", emailAddress=" + emailAddress + ", location=" + location
				+ ", itemName=" + itemName + ", itemNumber=" + itemNumber + ", total=" + total + ", currencyCode="
				+ currencyCode + ", quantity=" + quantity + ", shippingFlag=" + shippingFlag + ", taxRate=" + taxRate
				+ ", shippingRate=" + shippingRate + ", returnURL=" + returnURL + ", cancelURL=" + cancelURL
				+ ", paypalButtonURL=" + paypalButtonURL + ", paypalGatewayURL=" + paypalGatewayURL
				+ ", notificationURL=" + notificationURL + ", returnMethod=" + returnMethod + ", instruction="
				+ instruction + ", subType=" + subType + ", imgURL1=" + imgURL1 + ", imgURL2=" + imgURL2 + ", logoUrl="
				+ logoUrl + ", cppHeaderImage=" + cppHeaderImage + ", cppHeaderbackColor=" + cppHeaderbackColor
				+ ", cppHeaderborderColor=" + cppHeaderborderColor + ", cppPayflowColor=" + cppPayflowColor + ", cs="
				+ cs + "]";
	}

}
