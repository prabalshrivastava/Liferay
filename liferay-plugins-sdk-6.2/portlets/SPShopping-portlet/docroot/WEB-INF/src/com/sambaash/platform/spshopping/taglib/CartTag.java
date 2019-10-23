package com.sambaash.platform.spshopping.taglib;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class CartTag extends IncludeTag {

	String packageIds;
	boolean paymentRequired;
	boolean expandable;
	boolean updatable;
	String orderPage;

	private static final String _PAGE =
		"/html/sambaash/platform/taglib/shopping/cartPage.jsp";

	@Override
	protected void cleanUp() {
		packageIds = null;
		paymentRequired = true;
		expandable = false;
		updatable = false;
		orderPage = null;
	}
	
	
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute(
			"sp-shopping:packageIds", packageIds);
		request.setAttribute(
			"sp-shopping:paymentRequired", paymentRequired);
		request.setAttribute(
				"sp-shopping:expandable", expandable);
		request.setAttribute(
				"sp-shopping:updatable", updatable);
		request.setAttribute(
				"sp-shopping:orderPage", orderPage);
	}

	public String getPackageIds() {
		return packageIds;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	public boolean isUpdatable() {
		return updatable;
	}

	public void setUpdatable(boolean updatable) {
		this.updatable = updatable;
	}
	
	public boolean isExpandable() {
		return expandable;
	}

	public boolean isPaymentRequired() {
		return paymentRequired;
	}

	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}

	public void setPackageIds(String packageIds) {
		this.packageIds = packageIds;
	}

	public void setPaymentRequired(boolean paymentRequired) {
		this.paymentRequired = paymentRequired;
	}
	

	public String getOrderPage() {
		return orderPage;
	}


	public void setOrderPage(String orderPage) {
		this.orderPage = orderPage;
	}

}
