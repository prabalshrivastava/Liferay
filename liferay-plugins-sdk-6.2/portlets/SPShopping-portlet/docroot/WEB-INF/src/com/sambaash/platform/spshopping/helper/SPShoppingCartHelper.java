package com.sambaash.platform.spshopping.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.spshopping.SPShoppingConstants;
import com.sambaash.platform.srv.spshopping.model.SPCart;
import com.sambaash.platform.srv.spshopping.model.SPCartPackage;
import com.sambaash.platform.srv.spshopping.model.SPCartPackageItem;
import com.sambaash.platform.srv.spshopping.model.SPDiscount;
import com.sambaash.platform.srv.spshopping.model.SPPackageItems;
import com.sambaash.platform.srv.spshopping.model.SPSellingItem;
import com.sambaash.platform.srv.spshopping.model.SPSellingPackage;
import com.sambaash.platform.srv.spshopping.model.SPSellingPrice;
import com.sambaash.platform.srv.spshopping.model.impl.SPCartImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPCartPackageItemImpl;
import com.sambaash.platform.srv.spshopping.service.SPCartLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPCartPackageItemLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPCartPackageLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPDiscountLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPPackageItemsLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingItemLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingPackageLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SPShoppingCartHelper {

	private static Log _log = LogFactoryUtil.getLog(SPShoppingCartHelper.class);
	
	public static boolean validateCart(String[] packageIds,
			List<String> errors, String orderPage) throws Exception {
		String currencyCode = null;
		boolean orderPageFound = false;
		for (int i = 0; i < packageIds.length; i++) {
			SPSellingPackage pkg = null;

			try {
				pkg = SPSellingPackageLocalServiceUtil
						.getSPSellingPackage(GetterUtil.getLong(packageIds[i]));
			} catch (Exception e) {
				errors.add(SPShoppingConstants.ERROR_PKG_NOT_FOUND);
				return false;
			}

			if (Validator.isNotNull(pkg.getOrderPage()))
				orderPageFound = true;

			if (currencyCode == null) {
				currencyCode = pkg.getCurrencyCode();
			} else if (!currencyCode.equalsIgnoreCase(pkg.getCurrencyCode())) {
				errors.add(SPShoppingConstants.ERROR_CODE_DIFF_CURRENCY);
				return false;
			}

			if (!pkg.getActive()) {
				errors.add(SPShoppingConstants.ERROR_PKG_NOT_ACTIVE);
				return false;
			}
		}
		if (!orderPageFound && Validator.isNull(orderPage)) {
			errors.add(SPShoppingConstants.ERROR_ORDER_PAGE_NOT_SET);
			return false;
		}

		return true;
	}

	public static SPCart initializeCart(Long cartId, String[] pkgIdArray,
			String orderPage, String userRemarks) throws Exception {
		SPCart cart = null;
		try {
			if (Validator.isNotNull(cartId)) {
				// for future use when packages can be added to cart on the fly.
				cart = SPCartLocalServiceUtil.getSPCart(cartId);
				List<SPCartPackage> pkgs = SPCartPackageLocalServiceUtil
						.findPriceByCartId(cartId);
				List<String> missingPackageIds = new ArrayList<String>();
				for (String pkgId : pkgIdArray) {
					boolean found = false;
					for (SPCartPackage spCartPackage : pkgs) {
						if (spCartPackage.getPackageId() == GetterUtil
								.getLong(pkgId)) {
							found = true;
							break;
						}
					}
					if (!found) {
						missingPackageIds.add(pkgId);
					}
				}
				if (missingPackageIds.size() > 0) {
					List<SPCartPackage> cartPackages = new ArrayList<SPCartPackage>();
					List<SPCartPackageItem> cartPackageItems = new ArrayList<SPCartPackageItem>();
					BigDecimal totalPrice = createNewCartPackages(missingPackageIds,
							cartPackages, cartPackageItems, cartId);
					saveCartPackageItems(cartPackageItems);
					saveCartPackages(cartPackages);
					cart.setTotalPriceAmount(cart.getTotalPriceAmount().add(totalPrice));
				}
			} else {
				List<String> errors = new ArrayList<String>();
				validateCart(pkgIdArray, errors, orderPage);

				if (errors.size() != 0) {
					return null;
				}
				// create a new cart
				cart = new SPCartImpl();
				cartId = CounterLocalServiceUtil.increment("SPCart");
				cart.setSpCartId(cartId);
				cart.setUserRemarks(userRemarks);
				cart.setStatus(SPShoppingConstants.CART_STATUS.NEW);
				cart.setTransactionDetails("");
				cart.setNew(true);

				// add packages to cart
				List<SPCartPackage> cartPackages = new ArrayList<SPCartPackage>();
				List<SPCartPackageItem> cartPackageItems = new ArrayList<SPCartPackageItem>();
				BigDecimal totalPrice = createNewCartPackages(
						Arrays.asList(pkgIdArray), cartPackages, cartPackageItems, cartId);

				// first calc everything then save cartPackages and only then
				// the cart
				saveCartPackageItems(cartPackageItems);
				saveCartPackages(cartPackages);

				cart.setTotalPriceAmount(totalPrice);
				cart.setDiscountAmount(BigDecimal.ZERO);
				cart = SPCartLocalServiceUtil.updateSPCart(cart);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
			throw e;
		}
		return cart;
	}

	private static void saveCartPackageItems(
			List<SPCartPackageItem> cartPackageItems) throws Exception {
		for (SPCartPackageItem spCartPackageItem : cartPackageItems) {
			SPCartPackageItemLocalServiceUtil.updateSPCartPackageItem(spCartPackageItem);
		}
	}

	private static void saveCartPackages(List<SPCartPackage> cartPackages)
			throws Exception {
		for (SPCartPackage spCartPackage : cartPackages) {
			SPCartPackageLocalServiceUtil.updateSPCartPackage(spCartPackage);
		}
	}

	private static BigDecimal createNewCartPackages(List<String> packageIds,
			List<SPCartPackage> packages, List<SPCartPackageItem> items, Long cartId) throws Exception {

		BigDecimal cartPrice = BigDecimal.ZERO;

		for (String pkgId : packageIds) {
			SPCartPackage cartPkg = new SPCartPackageImpl();
			cartPkg.setSpCartPackageId(CounterLocalServiceUtil
					.increment("SPCartPackage"));
			cartPkg.setCartId(cartId);
			SPSellingPackage pkg = SPSellingPackageLocalServiceUtil
					.getSPSellingPackage(GetterUtil.getLong(pkgId));
			SPSellingPrice price = SPSellingPriceLocalServiceUtil
					.findPriceByPackageId(GetterUtil.getLong(pkgId));
			cartPkg.setPackageId(pkg.getSpSellingPackageId());
			cartPkg.setSelectedCurrency(pkg.getCurrencyCode());
			cartPkg.setTotalPrice(price.getTotalPrice());
			cartPrice = cartPrice.add(price.getTotalPriceAmount());
			cartPkg.setInitialPrice(price.getTotalPrice());
			cartPkg.setDiscountAmount(BigDecimal.ZERO);
			cartPkg.setNew(true);
			cartPkg.setUsedDiscountRefId(-1);
			cartPkg.setUsedDiscountRefPCId(-1);
			cartPkg.setRemarks(""); // log the discounts / promocode used and
									// amount
			packages.add(cartPkg);
			
			List<SPCartPackageItem> cartPkgItems = createCartPackageItems(cartPkg.getSpCartPackageId(), GetterUtil.getLong(pkgId));
			if (cartPkgItems.size() > 0)
				items.addAll(cartPkgItems);
		}

		return cartPrice;
	}
	
	private static List<SPCartPackageItem> createCartPackageItems(Long cartPackageId, Long packageId) throws Exception {
		List<SPPackageItems> pkgItems = SPPackageItemsLocalServiceUtil.findByPackageId(packageId);
		List<SPCartPackageItem> cartPackageItems = new ArrayList<SPCartPackageItem>();
		for (SPPackageItems pkgItem : pkgItems) {
			SPSellingItem item = SPSellingItemLocalServiceUtil.getSPSellingItem(pkgItem.getItemId());
			SPCartPackageItem cartItem = new SPCartPackageItemImpl();
			cartItem.setSpCartPackageItemId(CounterLocalServiceUtil
					.increment("SPCartPackageItem"));
			cartItem.setSpCartPackageId(cartPackageId);
			cartItem.setEntityClassPk(item.getEntityClassPk());
			cartItem.setEntityClassName(item.getEntityClassName());
			cartItem.setItemCode(item.getItemCode());
			cartItem.setNew(true);
			cartItem.setTitle(item.getTitle());
			cartItem.setTotalPrice(String.valueOf(pkgItem.getQuantity()));
			cartPackageItems.add(cartItem);
		}
		return cartPackageItems;
	}
	
	public static void calculateCart(SPCart cart) throws Exception {
		List<SPCartPackage> cartPkgs = SPCartPackageLocalServiceUtil
				.findPriceByCartId(cart.getSpCartId());
		BigDecimal cartPrice = BigDecimal.ZERO;
		BigDecimal totalDiscount = BigDecimal.ZERO;
		for (SPCartPackage spCartPackage : cartPkgs) {
			List<SPDiscount> discounts = SPDiscountLocalServiceUtil
					.findDiscountsByPackageId(spCartPackage.getPackageId());
			SPDiscount normalDiscount = SPShoppingDiscountHelper
					.getPercentDiscount(discounts, new Date());
			BigDecimal price = spCartPackage.getInitialPriceAmount();
			BigDecimal discount = spCartPackage.getDiscountAmount();

			// if promo code not yet used, check if normal discount given
			if (spCartPackage.getUsedDiscountRefPCId() == -1) {
				if (normalDiscount != null && spCartPackage.getUsedDiscountRefId() < 0) {
					discount = getDiscount(price, normalDiscount);
					price = substract(price, discount);

					// if mismatch update db
					if (price.compareTo(spCartPackage.getTotalPriceAmount()) != 0) {
						spCartPackage.setUsedDiscountRefId(normalDiscount
								.getSpDiscountId());
						spCartPackage.setDiscountAmount(discount);
						spCartPackage.setTotalPriceAmount(price);
						spCartPackage.setRemarks("Discount of " + discount
								+ " given refID = "
								+ normalDiscount.getSpDiscountId());
						SPCartPackageLocalServiceUtil
								.updateSPCartPackage(spCartPackage);
					}
				}
			} else {
				price = spCartPackage.getTotalPriceAmount();
			}

			cartPrice = cartPrice.add(price);
			totalDiscount = totalDiscount.add(discount);//incorrect
		}

		cart.setTotalPriceAmount(cartPrice);
		cart.setDiscountAmount(totalDiscount);
		cart.setStatus(SPShoppingConstants.CART_STATUS.VALIDATED);
		SPCartLocalServiceUtil.updateSPCart(cart);
	}

	private static BigDecimal substract(BigDecimal amount, BigDecimal value) {
		BigDecimal subtractedAmount = amount.subtract(value);
		return (subtractedAmount.doubleValue() > 0) ? subtractedAmount : BigDecimal.ZERO;
	}

	private static BigDecimal getDiscount(BigDecimal price, SPDiscount discount) {
		if (discount.isPercent()) {
			return (price.multiply(discount.getValueAmount()).divide(BigDecimal.valueOf(100)));
		} else {
			return discount.getValueAmount();
		}
	}

	public static boolean applyCoupon(SPCart cart, SPCartPackage cartPackage,
			String couponCode) throws Exception {
		
		List<SPDiscount> discounts = SPDiscountLocalServiceUtil
				.findDiscountsByPackageId(cartPackage.getPackageId());

		SPDiscount discount = SPShoppingDiscountHelper.getCouponDiscount(
				discounts, new Date());
		if (!discount.getCouponCode().equalsIgnoreCase(couponCode)) {
			return false;
		}

		if (cartPackage.getUsedDiscountRefPCId() > 0) {
			// if already used just return success no change in price.
			return true;
		}

		cartPackage.setUsedDiscountRefPCId(discount.getSpDiscountId());
		BigDecimal discountAmount = getDiscount(cartPackage.getTotalPriceAmount(), discount);
		cartPackage.setDiscount(cartPackage.getDiscount() + discountAmount);
		cartPackage.setTotalPriceAmount(cartPackage.getTotalPriceAmount().subtract(discountAmount));
		String remarks = cartPackage.getRemarks();
		cartPackage.setRemarks(remarks + " | " + "promoCode :" + couponCode + " used");
		SPCartPackageLocalServiceUtil.updateSPCartPackage(cartPackage);
		calculateCart(cart);
		return true;
	}

	public static boolean removeCoupon(Long cartId, String cartPackageId) {
		return false;
	}

}
