package com.sambaash.platform.spshopping.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequestWrapper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.spshopping.SPShoppingConstants;
import com.sambaash.platform.spshopping.helper.SPShoppingCartHelper;
import com.sambaash.platform.spshopping.helper.SPShoppingHelper;
import com.sambaash.platform.srv.spshopping.model.SPCart;
import com.sambaash.platform.srv.spshopping.model.SPCartPackage;
import com.sambaash.platform.srv.spshopping.model.SPSellingPackage;
import com.sambaash.platform.srv.spshopping.model.SPSellingPrice;
import com.sambaash.platform.srv.spshopping.service.SPCartLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPCartPackageLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingPackageLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalServiceUtil;
import com.sambaash.platform.util.wrapper.HttpServletRequestWrapperExtended;

/**
 * Portlet implementation class ShoppingPackageAction
 */
public class ShoppingCartAction extends MVCPortlet {

	private static Log logger = LogFactoryUtil.getLog(ShoppingCartAction.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
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
					ShoppingCatalogAction.class.getName());
		} catch (PortalException e1) {
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put(SPShoppingConstants.STATUS, SPShoppingConstants.FAIL);
			obj.put(SPShoppingConstants.ERROR_MSG,
					SPShoppingConstants.UNAUTH_MSG_VIEW);
			logger.error(e1.getMessage());
			resourceResponse.getWriter().write(obj.toString());
			return;
		}

		String action = ParamUtil.getString(resourceRequest,
				SPShoppingConstants.ACTION);
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		String pkgIds = ParamUtil.getString(resourceRequest,
				SPShoppingConstants.ATTRIB_PKGIDS);
		String cartPackageId = ParamUtil.getString(resourceRequest,
				SPShoppingConstants.ATTRIB_CART_PKGID);
		String[] pkgIdArray = pkgIds.split(",");
		String orderPage = ParamUtil.getString(resourceRequest,
				SPShoppingConstants.ATTRIB_ORDER_PAGE);
		Long cartId = ParamUtil.getLong(resourceRequest,
				SPShoppingConstants.ATTRIB_CART_ID);
		logger.debug("action = " + action + ", pkgIds = " + pkgIds);

		switch (action) {
		case "validateCart":
			try {
				List<String> errors = new ArrayList<String>();
				SPShoppingCartHelper
						.validateCart(pkgIdArray, errors, orderPage);
				if (errors.size() == 0) {
					obj.put(SPShoppingConstants.STATUS,
							SPShoppingConstants.SUCCESS);
				} else {
					logger.error("Validation errors " + errors);
					SPShoppingHelper.setErrorMsg(obj,
							JSONFactoryUtil.looseSerialize(errors.get(0)));
				}
			} catch (Exception e) {
				logger.error("Error while validating cart", e);
				SPShoppingHelper.setErrorMsg(obj, "Error while validating cart");
			}
			break;
		case "removePromo":
			if (Validator.isNull(cartId) || Validator.isNull(cartPackageId)) {
				SPShoppingHelper.setErrorMsg(obj, "Invalid operation!");
			} else {
				try {
					SPShoppingCartHelper.removeCoupon(cartId, cartPackageId);
					obj.put(SPShoppingConstants.STATUS,
							SPShoppingConstants.SUCCESS);
				} catch (Exception e) {
					logger.error("Error while removing coupon", e);
					SPShoppingHelper.setErrorMsg(obj, "Error removing Promo code!");
				}
			}
			break;
		case "applyPromo":
			String couponCode = ParamUtil.getString(resourceRequest,
					SPShoppingConstants.ATTRIB_COUPON_CODE);
			if (Validator.isNull(cartId) || Validator.isNull(cartPackageId)
					|| Validator.isNull(couponCode)) {
				SPShoppingHelper.setErrorMsg(obj, "Missing promo code!");
			} else {
				try {
					SPCart cart = SPCartLocalServiceUtil.getSPCart(cartId);
					SPCartPackage cartPackage = SPCartPackageLocalServiceUtil
							.getSPCartPackage(GetterUtil.getLong(cartPackageId));
					boolean isValid = SPShoppingCartHelper.applyCoupon(cart,
							cartPackage, couponCode);
					if (!isValid) {
						SPShoppingHelper.setErrorMsg(obj, "Invalid promo code!");
					} else {
						obj.put(SPShoppingConstants.STATUS,
								SPShoppingConstants.SUCCESS);
						obj.put(SPShoppingConstants.CART,
								JSONFactoryUtil.looseSerialize(cart));
						obj.put(SPShoppingConstants.CART_PACKAGE,
								JSONFactoryUtil.looseSerialize(cartPackage));

					}
				} catch (Exception e) {
					logger.error("Error while applying coupon", e);
					SPShoppingHelper.setErrorMsg(obj, "Error applying Promo code!");
				}
			}
			break;
		case "calculateCart":
			try {
				SPCart cart = null;
				if (Validator.isNotNull(cartId)) {
					cart = SPCartLocalServiceUtil.getSPCart(cartId);
				} else {
					cart = SPShoppingCartHelper.initializeCart(cartId,
							pkgIdArray, orderPage, "");
				}
				if (cart == null) {
					SPShoppingHelper.setErrorMsg(obj, "Failed processing cart!");
				} else {
					SPShoppingCartHelper.calculateCart(cart);
					obj.put(SPShoppingConstants.STATUS,
							SPShoppingConstants.SUCCESS);
					obj.put(SPShoppingConstants.OBJECT,
							JSONFactoryUtil.looseSerialize(cart));
				}
			} catch (Exception e) {
				logger.error("Error while calculating cart", e);
				SPShoppingHelper.setErrorMsg(obj, "Error while calculating cart total");
			}
			break;
		case "savePreferences":
			try {
				savePreferences(resourceRequest, resourceResponse);
				obj.put(SPShoppingConstants.STATUS,
						SPShoppingConstants.SUCCESS);
			} catch (Exception e) {
				logger.error(e.getMessage());
				SPShoppingHelper.setErrorMsg(obj, "Error while saving preferences");
			}
			break;
		default:
		}

		resourceResponse.getWriter().write(obj.toString());
	}

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		try {
			List<SPSellingPackage> packages = SPSellingPackageLocalServiceUtil
					.findSPSellingPackage(true);
			if (Validator.isNull(packages) || packages.size() == 0)
				return;

			Map<String, String> dataMap = new HashMap<String, String>();
			for (SPSellingPackage spSellingPackage : packages) {
				String label = spSellingPackage.getTitle();
				if (Validator.isNotNull(spSellingPackage.getPkgCode()))
					label = label + " ( " + spSellingPackage.getPkgCode()
							+ " ) ";
				SPSellingPrice price = null;
				try {
					price = SPSellingPriceLocalServiceUtil
							.findPriceByPackageId(spSellingPackage
									.getSpSellingPackageId());
				} catch (Exception e) {
					continue;
				}
				label = label + "  -  " + price.getTotalPrice()
						+ price.getCurrencyCode();
				dataMap.put(spSellingPackage.getSpSellingPackageId() + "", label);
			}
			renderRequest.setAttribute(
					SPShoppingConstants.ATTRIB_ALL_PACKAGE_MAP, dataMap);
		} catch (SystemException e) {
			logger.error("Error while getting packages", e);
		}
		super.doEdit(renderRequest, renderResponse);
	}

	public void savePreferences(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {

		PortletPreferences preferences = resourceRequest.getPreferences();
		// variable not used directly but used to determine if a pref popup
		// needs to open when portlet is added
		preferences.setValue("initialized", "true");
		String pkgIds = ParamUtil
				.getString(resourceRequest, "selectedPackages");
		if (Validator.isNotNull(pkgIds)) {
			preferences.setValue("selectedPackages", pkgIds);
		}

		String orderPage = ParamUtil.getString(resourceRequest, "orderPage");
		if (Validator.isNotNull(orderPage)) {
			preferences.setValue("orderPage", orderPage);
		}

		String updatable = ParamUtil.getString(resourceRequest, "updatable");
		if (Validator.isNotNull(updatable)) {
			preferences.setValue("updatable", updatable);
		}

		String expandable = ParamUtil.getString(resourceRequest, "expandable");
		if (Validator.isNotNull(expandable)) {
			preferences.setValue("expandable", expandable);
		}

		preferences.store();

	}

}