package com.sambaash.platform.spshopping;

public interface SPShoppingConstants {
	
	String PORTLET_ID = "shoppingcatalog_WAR_SPShoppingportlet";
	String NAME = "name";
	String ID = "id";
	String ERROR_MSG = "errorMsg";
	String UNAUTH_MSG_VIEW = "You are not authorized to do this operation";
	
	String PARAM_CREATE_PACKAGE = "createpackage";
	String PARAM_CREATE_DISCOUNT = "creatediscount";
	String PARAM_CREATE_ITEM = "createitem";
	
	String PARAM_LIST_ITEMS = "items";
	String PARAM_LIST_DISCOUNTS = "discounts";
	String PARAM_LIST_PACKAGES = "packages";
	
	String PARAM_DISPLAY_PACKAGE = "viewpackage";
	String PARAM_DISPLAY_DISCOUNT = "viewdiscount";
	String PARAM_DISPLAY_ITEM = "viewitem";

	String PARAM_SETTINGS = "settings";
	String PARAM_SELECT_ITEMS = "selectItems";
	
	String ACTION = "action";
	String OBJECT = "object";
	String FAIL = "fail";
	String SUCCESS = "success";
	String STATUS = "status";
	
	String SHORT_DESCRIPTION = "shortDesc";
	String LONG_DESCRIPTION = "longDesc";
	String ITEM_CODE = "itemCode";
	String START_DATE = "startDate";
	String END_DATE = "endDate";
	String MIN_QUANTITY = "minQuantity";
	String MAX_QUANTITY = "maxQuantity";
	String CART = "cart";
	String CART_PACKAGE ="cartPackage";

	String ATTRIB_ITEM = "item";
	String ATTRIB_PRICE = "price";
	String ATTRIB_PKG = "pkg";
	String ATTRIB_TAX = "tax";
	String ATTRIB_DISCOUNT = "discount";
	String ATTRIB_ALL_PACKAGE_MAP = "allPackageMap";
	String ATTRIB_ALL_ITEM_MAP = "allItemMap";
	
	String ATTRIB_PKGIDS = "packageIds";
	String ATTRIB_PKGID = "packgeId";
	String ATTRIB_ORDER_PAGE = "orderPage";
	String ATTRIB_CART_ID = "cartId";
	String ATTRIB_CART_PKGID = "cartPackageId";
	String ATTRIB_COUPON_CODE = "couponCode";
	
	Long PRICE_REF_TYPE_ITEM_ID = 1L;
	Long PRICE_REF_TYPE_PKG_ID = 2L;
	
	
	
	interface PAGE {
		String CREATE_PACKAGE = "/html/shoppingcatalog/packages/create.jsp";
		String CREATE_DISCOUNT = "/html/shoppingcatalog/discounts/create.jsp";
		String CREATE_ITEM = "/html/shoppingcatalog/items/create.jsp";
		
		String LIST_ITEMS = "/html/shoppingcatalog/items/list.jsp";
		String LIST_DISCOUNTS = "/html/shoppingcatalog/discounts/list.jsp";
		String LIST_PACKAGES = "/html/shoppingcatalog/packages/list.jsp";
		
		String DISPLAY_PACKAGE = "/html/shoppingcatalog/packages/view.jsp";
		String DISPLAY_DISCOUNT = "/html/shoppingcatalog/discounts/view.jsp";
		String DISPLAY_ITEM = "/html/shoppingcatalog/items/view.jsp";
		
		String ERROR_PAGE = "/html/common/error.jsp";
		String SETTINGS = "/html/common/settings.jsp";
		String SELECT_ITEMS = "/html/shoppingcatalog/items/selectItems.jsp";
	}
	
	String ERROR_CODE_DIFF_CURRENCY = "Packages with different currency codes cant be clubbed added together to the cart";
	String ERROR_PKG_NOT_ACTIVE = "One of the packages is not active";
	String ERROR_PKG_NOT_FOUND = "Package id not found";
	String ERROR_ORDER_PAGE_NOT_SET = "Order page not set";
	
	interface CART_STATUS {
		int NEW = 1;
		int VALIDATED = 2;
		int INIT_PAYMENT = 3;
		int COMPLETE_PAYMENT = 5;
		int CANCEL_PAYMENT = 4;
		int FAILED_PAYMENT = 6;
	}
	
}