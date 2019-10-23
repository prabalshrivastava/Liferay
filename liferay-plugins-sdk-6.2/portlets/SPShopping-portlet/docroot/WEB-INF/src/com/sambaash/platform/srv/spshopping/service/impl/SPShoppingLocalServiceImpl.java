/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.spshopping.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.sambaash.platform.model.payment.PaymentProvider;
import com.sambaash.platform.srv.spshopping.model.SPCart;
import com.sambaash.platform.srv.spshopping.model.SPCartPackage;
import com.sambaash.platform.srv.spshopping.model.SPCartPackageItem;
import com.sambaash.platform.srv.spshopping.model.SPPackageItems;
import com.sambaash.platform.srv.spshopping.model.SPSellingItem;
import com.sambaash.platform.srv.spshopping.model.SPSellingPackage;
import com.sambaash.platform.srv.spshopping.model.SPSellingPrice;
import com.sambaash.platform.srv.spshopping.service.SPCartLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPCartPackageLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPShoppingLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.base.SPShoppingLocalServiceBaseImpl;
import com.sambaash.platform.util.DateUtils;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p shopping local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spshopping.service.SPShoppingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.spshopping.service.base.SPShoppingLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spshopping.service.SPShoppingLocalServiceUtil
 */
public class SPShoppingLocalServiceImpl extends SPShoppingLocalServiceBaseImpl {
	public static final String DEFAULT_INVENTORY_START_DATE = "1970-01-01";
	public static final String DEFAULT_INVENTORY_END_DATE = "3999-12-31";
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spshopping.service.SPShoppingLocalServiceUtil} to access the s p shopping local service.
	 */
	
	public static Log logger = LogFactoryUtil.getLog(SPShoppingLocalServiceImpl.class);
	
	public long addProductCatalog
	(
			long companyId, long groupId, long userId, String userName,
			long classNameId, long classPk, String title, String itemCode, String shortDesc, String longDesc) 
	{
		long itemId = -1L;
		String prodIdStr = String.format("%d~%d - %s", classNameId, classPk, title);
		try {
			Date now = new Date();
			SPSellingItem product;
			try {
				product = spSellingItemPersistence.findByEntityClassNameIdAndEntityClassPk(classNameId, classPk);	
			} catch (Exception e) {
				product = null; // not found
			}
			
			if (product == null) {
				debug("Adding new product :: " + prodIdStr);
				itemId = CounterLocalServiceUtil.increment("SPSellingItem");
				product = spSellingItemPersistence.create(itemId);				
				product.setCreateDate(now);
			} else {
				debug("Updating existing product :: " + prodIdStr);
				itemId = product.getSpSellingItemId();
			}
			
			product.setTitle(title);
			product.setItemCode(itemCode);
			product.setEntityClassNameId(classNameId);
			product.setEntityClassPk(classPk);
			product.setEntityClassName(ClassNameLocalServiceUtil.getClassName(classNameId).getClassName());
			product.setShortDescription(shortDesc);
			product.setLongDescription(longDesc);
			
			product.setModifiedDate(now);
			product.setActive(true);
			product.setCompanyId(companyId);
			product.setGroupId(groupId);
			product.setUserId(userId);
			product.setUserName(userName);
			
			spSellingItemLocalService.updateSPSellingItem(product);
			
			debug("Product cataloged :: " + prodIdStr + " with id " + itemId);
		} catch (Exception e) {
			logger.error("Error adding to product catalog :: " + prodIdStr, e);
		}
		return itemId;
	}

	public void addProductInventory
	(
			long companyId, long groupId, long userId, String userName,
			long classNameId, long classPk, Date startDate, Date endDate, int quantity) 
	{
		try {
			startDate = startDate==null?DateUtils.toDate(DEFAULT_INVENTORY_START_DATE):startDate;
			endDate = endDate==null?DateUtils.toDate(DEFAULT_INVENTORY_END_DATE):endDate;			
		} catch (Exception e) {
			// should not reach here
		}
		String prodIdStr = String.format("%d~%d~%s~%s~%d", classNameId, classPk, startDate.toString(), endDate.toString(), quantity);
		SPSellingItem product;
		List<SPPackageItems> inventoryList;
		try {
			product = spSellingItemPersistence.findByEntityClassNameIdAndEntityClassPk(classNameId, classPk);
			inventoryList = spPackageItemsPersistence.findByItemId(product.getSpSellingItemId());			
		} catch (Exception e) {
			product = null;
			inventoryList = null;
		}
		
		try {
			SPSellingPackage pkg = null;
			SPPackageItems inventory = null;
			Date now = new Date();
			if (inventoryList != null) {
				for (SPPackageItems item : inventoryList) {
					SPSellingPackage p = spSellingPackageLocalService.fetchSPSellingPackage(item.getPackageId());
					if (DateUtils.toString(p.getStartDate()).equals(DateUtils.toString(startDate)) && DateUtils.toString(p.getEndDate()).equals(DateUtils.toString(endDate))) {
						// found existing inventory entry
						pkg = p;
						inventory = item;
						break;
					}
				}
			}
			// new inventory
			if (pkg == null) {
				pkg = spSellingPackagePersistence.create(CounterLocalServiceUtil.increment("SPSellingPackage"));
				pkg.setCreateDate(now);
				inventory = spPackageItemsPersistence.create(CounterLocalServiceUtil.increment("SPPackageItems"));
				inventory.setCreateDate(now);
			}
			pkg.setModifiedDate(now);
			pkg.setActive(true);
			pkg.setCompanyId(companyId);
			pkg.setGroupId(groupId);
			pkg.setUserId(userId);
			pkg.setUserName(userName);
			pkg.setStartDate(startDate);
			pkg.setEndDate(endDate);
			pkg.setTitle(product.getTitle());
			pkg.setPkgCode(genEntityCode(classNameId, classPk));
			pkg.setShortDescription(product.getShortDescription());
			pkg.setLongDescription(product.getLongDescription());
			spSellingPackageLocalService.updateSPSellingPackage(pkg);

			inventory.setModifiedDate(now);
			inventory.setCompanyId(companyId);
			inventory.setGroupId(groupId);
			inventory.setUserId(userId);
			inventory.setUserName(userName);
			inventory.setQuantity(quantity);
			inventory.setPackageId(pkg.getSpSellingPackageId());
			inventory.setItemId(product.getSpSellingItemId());
			spPackageItemsLocalService.updateSPPackageItems(inventory);
		} catch (Exception e) {
			logger.error("Error adding to product inventory :: " + prodIdStr, e);
		}
	}
	
	public JSONArray retrieveProductInventory (long classNameId, long classPk) 
	{
		JSONArray result = JSONFactoryUtil.createJSONArray();
		String prodIdStr = String.format("%d~%d", classNameId, classPk);
		try {
			SPSellingItem product = spSellingItemPersistence.findByEntityClassNameIdAndEntityClassPk(classNameId, classPk);	
			List<SPPackageItems> inventoryList = spPackageItemsPersistence.findByItemId(product.getSpSellingItemId());
			for (SPPackageItems item : inventoryList) {
				SPSellingPackage p = spSellingPackageLocalService.fetchSPSellingPackage(item.getPackageId());
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("startDate", DateUtils.toString(p.getStartDate()));
				obj.put("endDate", DateUtils.toString(p.getEndDate()));
				obj.put("quantity", item.getQuantity());
				int totalSold = retrieveTotalQtySoldForPackage(p);
				obj.put("remainingInventory", item.getQuantity() - totalSold);	
				obj.put("packageId",item.getPackageId());	
				result.put(obj);
			}
		} catch (Exception e) {
			logger.error("Error retrieving the product inventory :: " + prodIdStr, e);
		}
		return result;
	}
	
	public int retrieveRemainingInventory (long classNameId, long classPk) 
	{
		int remaining = 0;
		String prodIdStr = String.format("%d~%d", classNameId, classPk);
		try {
			Date now = new Date();
			SPSellingItem product = spSellingItemPersistence.findByEntityClassNameIdAndEntityClassPk(classNameId, classPk);	
			List<SPPackageItems> inventoryList = spPackageItemsPersistence.findByItemId(product.getSpSellingItemId());
			for (SPPackageItems inventory : inventoryList) {
				SPSellingPackage p = spSellingPackageLocalService.fetchSPSellingPackage(inventory.getPackageId());
				if (!now.before(p.getStartDate()) && !now.after(p.getEndDate())) {
					// falls in range
					// check sold quantities for this package
					int totalSold = retrieveTotalQtySoldForPackage(p);
					// return the highest inventory remaining that  is within date range
					if ((inventory.getQuantity()-totalSold) > remaining) {
						remaining = inventory.getQuantity()-totalSold;
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error retrieving the product inventory :: " + prodIdStr, e);
		}
		logger.debug("Remaining inventory for ["+prodIdStr+"]="+remaining);
		return remaining;
	}

	private int retrieveTotalQtySoldForPackage(SPSellingPackage sellingPackage)
			throws SystemException, PortalException {
		int totalSold = 0;
		List<SPCartPackage> cartPackages = spCartPackagePersistence.findByPackageId(sellingPackage.getSpSellingPackageId());
		for(SPCartPackage scp : cartPackages) {
			SPCart cart = SPCartLocalServiceUtil.getSPCart(scp.getCartId()); 
			if (cart.getStatus() == PaymentProvider.PAYMENT_CONFIRMED_STATUS) {
				List<SPCartPackageItem> soldItems = spCartPackageItemPersistence.findBySPCartPackageId(scp.getSpCartPackageId());
				for (SPCartPackageItem sold : soldItems) {
					totalSold += sold.getQuantity();
				}							
			}
		}
		return totalSold;
	}

	public boolean hasEnoughInventory(long classNameId, long classPk, int inventoryNeeded) {
		boolean hasNeededInventory = false;
		int inventoryLeft = retrieveRemainingInventory(classNameId, classPk);
		hasNeededInventory = (inventoryLeft - inventoryNeeded) >= 0;
		return hasNeededInventory;
	}
	
	public long addProductPrice
	(
			long companyId, long groupId, long userId, String userName,
			long classNameId, long classPk, String currencyCode, java.math.BigDecimal price) 
	{
		long priceId = -1L;
		String prodIdStr = String.format("%d~%d", classNameId, classPk);
		try {
			debug("Adding product price :: " + prodIdStr);
			priceId = CounterLocalServiceUtil.increment("SPSellingPrice");
			
			SPSellingPrice productPrice = spSellingPricePersistence.create(priceId);
			
			Date now = new Date();
			productPrice.setCreateDate(now);
			productPrice.setModifiedDate(now);
			productPrice.setCompanyId(companyId);
			productPrice.setGroupId(groupId);
			productPrice.setUserId(userId);
			productPrice.setUserName(userName);
			productPrice.setCurrencyCode(currencyCode);
			
			productPrice.setBasePriceAmount(price);
			productPrice.setTotalPriceAmount(price);
			
			spSellingPriceLocalService.addSPSellingPrice(productPrice);
			
			debug("Product price added :: " + prodIdStr + " with id " + priceId);
		} catch (Exception e) {
			logError("Error adding new product :: " + prodIdStr, e);
		}
		return priceId;
	}
	
	public long createPaymentCart(long companyId, long groupId, long userId, String userName,
			String payItemClassName, long payItemClassPk, BigDecimal payAmount, String payCcy) {
		return createPaymentCart(companyId, groupId, userId, userName, payItemClassName, payItemClassPk, payAmount, payCcy, 1);
	}
	
	public long createPaymentCart(long companyId, long groupId, long userId, String userName,
			String payItemClassName, long payItemClassPk, BigDecimal payAmount, String payCcy, int quantity) {
		long cartId;
		try {
			Date now = new Date();
			// add cart
			cartId = CounterLocalServiceUtil.increment("SPCart");
			SPCart cart = spCartPersistence.create(cartId);
			cart.setCreateDate(now);
			cart.setModifiedDate(now);
			cart.setCompanyId(companyId);
			cart.setGroupId(groupId);
			cart.setUserId(userId);
			cart.setUserName(userName);
			cart.setTotalPriceAmount(payAmount);
			spCartLocalService.addSPCart(cart);
			
			// add cart package
			long pkgId = CounterLocalServiceUtil.increment("SPCartPackage");
			SPCartPackage pkg = spCartPackagePersistence.create(pkgId);
			pkg.setCreateDate(now);
			pkg.setModifiedDate(now);
			pkg.setCompanyId(companyId);
			pkg.setGroupId(groupId);
			pkg.setUserId(userId);
			pkg.setUserName(userName);
			pkg.setCartId(cartId);
			pkg.setSelectedCurrency(payCcy);
			pkg.setInitialPriceAmount(payAmount);
			pkg.setTotalPriceAmount(payAmount);
			try {
				pkg.setPackageId(retrievePakageWithEnoughInventory(ClassNameLocalServiceUtil.getClassNameId(payItemClassName), payItemClassPk, quantity));				
			} catch (Exception e) {
				// non-inventory
			}
			spCartPackageLocalService.addSPCartPackage(pkg);
			
			// add as cart package item
			long pkgItemId = CounterLocalServiceUtil.increment("SPCartPackageItem");
			SPCartPackageItem pkgItem = spCartPackageItemPersistence.create(pkgItemId);
			pkgItem.setCreateDate(now);
			pkgItem.setModifiedDate(now);
			pkgItem.setCompanyId(companyId);
			pkgItem.setGroupId(groupId);
			pkgItem.setUserId(userId);
			pkgItem.setUserName(userName);
			pkgItem.setEntityClassName(payItemClassName);
			pkgItem.setEntityClassPk(payItemClassPk);
			String itemCode = String.format("%s_%d", SambaashUtil.getClassSimpleName(payItemClassName), payItemClassPk);
			pkgItem.setItemCode(itemCode);
			pkgItem.setTitle(itemCode);
			pkgItem.setQuantity(quantity);
			pkgItem.setTotalPriceAmount(payAmount);
			pkgItem.setSpCartPackageId(pkgId);
			spCartPackageItemLocalService.addSPCartPackageItem(pkgItem);
		} catch (Exception e) {
			logError("Error creating payment cart", e);
			cartId = -1;
		}
		
		return cartId;
	}

	public long retrievePakageWithEnoughInventory (long classNameId, long classPk, int qty) 
	{
		int remaining = 0;
		String prodIdStr = String.format("%d~%d", classNameId, classPk);
		try {
			Date now = new Date();
			SPSellingItem product = spSellingItemPersistence.findByEntityClassNameIdAndEntityClassPk(classNameId, classPk);	
			List<SPPackageItems> inventoryList = spPackageItemsPersistence.findByItemId(product.getSpSellingItemId());
			for (SPPackageItems inventory : inventoryList) {
				SPSellingPackage p = spSellingPackageLocalService.fetchSPSellingPackage(inventory.getPackageId());
				if (!now.before(p.getStartDate()) && !now.after(p.getEndDate())) {
					// falls in range
					// check sold quantities for this package
					List<SPCartPackage> cartPackages = spCartPackagePersistence.findByPackageId(p.getSpSellingPackageId());
					int totalSold = 0;
					for(SPCartPackage scp : cartPackages) {
						SPCart cart = SPCartLocalServiceUtil.getSPCart(scp.getCartId()); 
						if (cart.getStatus() == PaymentProvider.PAYMENT_CONFIRMED_STATUS) {
							List<SPCartPackageItem> soldItems = spCartPackageItemPersistence.findBySPCartPackageId(scp.getSpCartPackageId());
							for (SPCartPackageItem sold : soldItems) {
								totalSold += sold.getQuantity();
							}							
						}
					}
					// return the first inventory remaining that  is within date range
					if ((inventory.getQuantity()-totalSold) > 0) {
						logger.debug("retrievePakageWithEnoughInventory got selling package id ["+p.getSpSellingPackageId()+"]");
						return p.getSpSellingPackageId();
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error retrieving the product inventory :: " + prodIdStr, e);
		}
		return 0;
	}
	
	public void confirmPayment(long cartId, int confirmedQty) {
		try {
			SPCart cart = SPCartLocalServiceUtil.fetchSPCart(cartId);
			for (SPCartPackage spcp :spCartPackagePersistence.findBycartId(cartId)) {
				for (SPCartPackageItem pi : spCartPackageItemPersistence.findBySPCartPackageId(spcp.getSpCartPackageId())) {
					pi.setQuantity(confirmedQty);
					spCartPackageItemLocalService.updateSPCartPackageItem(pi);
				}
			}
			cart.setStatus(PaymentProvider.PAYMENT_CONFIRMED_STATUS);
			spCartPersistence.update(cart);
		} catch (Exception e) {
			logger.error("error confirming payment: "+cartId+" with quantity: "+confirmedQty);
		}
	}
	
	public void rejectPayment(long cartId) {
		try {
			SPCart cart = SPCartLocalServiceUtil.fetchSPCart(cartId);
			cart.setStatus(PaymentProvider.PAYMENT_REJECTED_STATUS);
			spCartPersistence.update(cart);
		} catch (Exception e) {
			logger.error("error rejecting payment: "+cartId);
		}
	}
	
	private static void debug(String debugMsg) {
		if (logger.isDebugEnabled()) {
			logger.debug(debugMsg);
		}
	}
	private static void logError(String debugMsg, Throwable e) {
		logger.error(debugMsg, e);
	}
	
	private static String genEntityCode(long entityClassNameId, long classPk) {
		return String.format("%d~%d", entityClassNameId, classPk);
	}
}
