package com.sambaash.platform.spshopping.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
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
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.spshopping.SPShoppingConstants;
import com.sambaash.platform.spshopping.helper.SPShoppingDiscountHelper;
import com.sambaash.platform.spshopping.helper.SPShoppingHelper;
import com.sambaash.platform.spshopping.helper.SPShoppingItemHelper;
import com.sambaash.platform.spshopping.helper.SPShoppingPackageHelper;
import com.sambaash.platform.spshopping.helper.SPShoppingTaxHelper;
import com.sambaash.platform.srv.spshopping.model.SPDiscount;
import com.sambaash.platform.srv.spshopping.model.SPSellingItem;
import com.sambaash.platform.srv.spshopping.model.SPSellingPackage;
import com.sambaash.platform.srv.spshopping.model.SPSellingPrice;
import com.sambaash.platform.srv.spshopping.model.SPTax;
import com.sambaash.platform.srv.spshopping.service.SPDiscountLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingItemLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPTaxLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.wrapper.HttpServletRequestWrapperExtended;

/**
 * Portlet implementation class ShoppingCatalogAction
 */
public class ShoppingCatalogAction extends MVCPortlet {

	private static Log logger = LogFactoryUtil
			.getLog(ShoppingCatalogAction.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String action = GetterUtil.getString(
				renderRequest.getParameter("actionp"), "");
		ThemeDisplay themeDisplay = SPShoppingHelper
				.getThemeDisplay(renderRequest);
		renderRequest.setAttribute("pageURL", themeDisplay.getLayout()
				.getFriendlyURL());
		if (!isAuthorizedUser(themeDisplay)) {
			logger.warn("Unauthorized accesss action = " + action + " userId="
					+ themeDisplay.getUserId() + " url = "
					+ themeDisplay.getURLCurrent());
			renderRequest.setAttribute(SPShoppingConstants.ERROR_MSG,
					"You are not authorized to do this operation");
			include(SPShoppingConstants.PAGE.ERROR_PAGE, renderRequest,
					renderResponse);
			return;
		}
		SPShoppingHelper.loadCurrencies(renderRequest);
		switch (action) {
		case SPShoppingConstants.PARAM_LIST_ITEMS:
			handleListItems(themeDisplay, renderRequest, renderResponse);
			include(SPShoppingConstants.PAGE.LIST_ITEMS, renderRequest,
					renderResponse);
			break;
		case SPShoppingConstants.PARAM_LIST_DISCOUNTS:
			handleListDiscounts(themeDisplay, renderRequest, renderResponse);
			include(SPShoppingConstants.PAGE.LIST_DISCOUNTS, renderRequest,
					renderResponse);
			break;
		case SPShoppingConstants.PARAM_DISPLAY_DISCOUNT:
			handleDisplayDiscount(themeDisplay, renderRequest, renderResponse);
			include(SPShoppingConstants.PAGE.DISPLAY_DISCOUNT, renderRequest,
					renderResponse);
			break;
		case SPShoppingConstants.PARAM_DISPLAY_ITEM:
			handleDisplayItem(themeDisplay, renderRequest, renderResponse);
			include(SPShoppingConstants.PAGE.DISPLAY_ITEM, renderRequest,
					renderResponse);
			break;
		case SPShoppingConstants.PARAM_DISPLAY_PACKAGE:
			handleDisplayPackage(themeDisplay, renderRequest, renderResponse);
			include(SPShoppingConstants.PAGE.DISPLAY_PACKAGE, renderRequest,
					renderResponse);
			break;
		case SPShoppingConstants.PARAM_CREATE_DISCOUNT:
			handleCreateDiscount(themeDisplay, renderRequest, renderResponse);
			include(SPShoppingConstants.PAGE.CREATE_DISCOUNT, renderRequest,
					renderResponse);
			break;
		case SPShoppingConstants.PARAM_CREATE_ITEM:
			handleCreateItem(themeDisplay, renderRequest, renderResponse);
			include(SPShoppingConstants.PAGE.CREATE_ITEM, renderRequest,
					renderResponse);
			break;
		case SPShoppingConstants.PARAM_CREATE_PACKAGE:
			handleCreatePackage(themeDisplay, renderRequest, renderResponse);
			include(SPShoppingConstants.PAGE.CREATE_PACKAGE, renderRequest,
					renderResponse);
			break;
		case SPShoppingConstants.PARAM_SETTINGS:
			handleCreatePackage(themeDisplay, renderRequest, renderResponse);
			include(SPShoppingConstants.PAGE.SETTINGS, renderRequest,
					renderResponse);
			break;
		case SPShoppingConstants.PARAM_SELECT_ITEMS:
			handleSelectItems(themeDisplay, renderRequest, renderResponse);
			include(SPShoppingConstants.PAGE.SELECT_ITEMS, renderRequest,
					renderResponse);
			break;
		default:
			logger.debug("Defaulting to package listing");
		case SPShoppingConstants.PARAM_LIST_PACKAGES:
			handleListPackages(themeDisplay, renderRequest, renderResponse);
			include(SPShoppingConstants.PAGE.LIST_PACKAGES, renderRequest,
					renderResponse);
			break;
		}
	}

	private boolean isAuthorizedUser(ThemeDisplay themeDisplay) {
		boolean isAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(),
				themeDisplay.getUserId());
		boolean isShoppingCatalogAdmin = SambaashUtil.isShoppingCatalogAdmin(
				themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
		return isAdmin || isShoppingCatalogAdmin;
	}

	private void handleListDiscounts(ThemeDisplay themeDisplay,
			RenderRequest renderRequest, RenderResponse renderResponse) {

	}

	private void handleListPackages(ThemeDisplay themeDisplay,
			RenderRequest renderRequest, RenderResponse renderResponse) {

	}

	private void handleListItems(ThemeDisplay themeDisplay,
			RenderRequest renderRequest, RenderResponse renderResponse) {

	}

	private void handleCreatePackage(ThemeDisplay themeDisplay,
			RenderRequest renderRequest, RenderResponse renderResponse) {

	}

	private void handleCreateItem(ThemeDisplay themeDisplay,
			RenderRequest renderRequest, RenderResponse renderResponse) {

	}

	private void handleCreateDiscount(ThemeDisplay themeDisplay,
			RenderRequest renderRequest, RenderResponse renderResponse) {

	}

	private void handleDisplayPackage(ThemeDisplay themeDisplay,
			RenderRequest renderRequest, RenderResponse renderResponse) {

	}

	private void handleDisplayItem(ThemeDisplay themeDisplay,
			RenderRequest renderRequest, RenderResponse renderResponse) {

	}

	private void handleDisplayDiscount(ThemeDisplay themeDisplay,
			RenderRequest renderRequest, RenderResponse renderResponse) {

	}

	private void handleSelectItems(ThemeDisplay themeDisplay,
			RenderRequest renderRequest, RenderResponse renderResponse) {

		try {
			List<SPSellingItem> items = SPSellingItemLocalServiceUtil
					.findSPSellingItems(true);
			if (Validator.isNull(items) || items.size() == 0)
				return;

			Map<String, String> dataMap = new HashMap<String, String>();
			for (SPSellingItem spSellingItem : items) {
				String label = spSellingItem.getTitle();
				if (Validator.isNotNull(spSellingItem.getItemCode()))
					label = label + " ( " + spSellingItem.getItemCode()
							+ " ) ";
				List<SPSellingPrice> priceList = SPSellingPriceLocalServiceUtil
						.findPriceByItemId(spSellingItem
								.getSpSellingItemId());
				for (SPSellingPrice price : priceList) {
					label = label + "  -  " + price.getTotalPrice()
							+ price.getCurrencyCode();
					dataMap.put(price.getSpSellingPriceId() + "", label);
				}
			}
			renderRequest.setAttribute(
					SPShoppingConstants.ATTRIB_ALL_ITEM_MAP, dataMap);
		} catch (SystemException e) {
			logger.error("Error while getting packages", e);
		}
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
			obj.put(SPShoppingConstants.ERROR_MSG,
					SPShoppingConstants.UNAUTH_MSG_VIEW);
			logger.error(e1.getMessage());
			resourceResponse.getWriter().write(obj.toString());
			return;
		}

		ThemeDisplay themeDisplay = SPShoppingHelper
				.getThemeDisplay(resourceRequest);
		String action = ParamUtil.getString(resourceRequest,
				SPShoppingConstants.ACTION);
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		String id = ParamUtil
				.getString(resourceRequest, SPShoppingConstants.ID);
		if (isAuthorizedUser(themeDisplay)) {
			switch (action) {
			case "addItem":
				try {
					SPSellingItem item = new SPShoppingItemHelper()
							.persistData(resourceRequest, id);
					obj.put(SPShoppingConstants.OBJECT,
							JSONFactoryUtil.looseSerialize(item));
					obj.put(SPShoppingConstants.STATUS,
							SPShoppingConstants.SUCCESS);
				} catch (Exception e) {
					logger.error("Exception while saving selling item");
					SPShoppingHelper.setErrorMsg(obj, "Error while saving item");
				}
				break;
			case "addPackage":
				try {
					SPSellingPackage pkg = new SPShoppingPackageHelper()
							.persistData(resourceRequest, id);
					obj.put(SPShoppingConstants.OBJECT,
							JSONFactoryUtil.looseSerialize(pkg));
					obj.put(SPShoppingConstants.STATUS,
							SPShoppingConstants.SUCCESS);
				} catch (Exception e) {
					logger.error("Exception while saving selling package");
					SPShoppingHelper.setErrorMsg(obj, "Error while saving package");
				}
				break;
			case "addTax":
				try {
					SPTax tax = new SPShoppingTaxHelper()
							.persistData(resourceRequest, id);
					obj.put(SPShoppingConstants.OBJECT,
							JSONFactoryUtil.looseSerialize(tax));
					obj.put(SPShoppingConstants.STATUS,
							SPShoppingConstants.SUCCESS);
				} catch (Exception e) {
					logger.error("Exception while saving selling package");
					SPShoppingHelper.setErrorMsg(obj, "Error while saving tax configuration");
				}
				break;
			case "addDiscount":
				try {
					SPShoppingDiscountHelper.validateRequest(resourceRequest, id);
					
					SPDiscount discount = new SPShoppingDiscountHelper()
							.persistData(resourceRequest, id);
					obj.put(SPShoppingConstants.OBJECT,
							JSONFactoryUtil.looseSerialize(discount));
					obj.put(SPShoppingConstants.STATUS,
							SPShoppingConstants.SUCCESS);
				} catch (Exception e) {
					logger.error("Exception while saving selling package");
					SPShoppingHelper.setErrorMsg(obj, "Error while saving discount");
				}
				break;
			case "getTax":
				try {
					String currencyCode = ParamUtil.getString(resourceRequest, "currencyCode");
					SPTax tax = SPTaxLocalServiceUtil.getSPTaxByCurrency(currencyCode);
					obj.put(SPShoppingConstants.OBJECT,
							JSONFactoryUtil.looseSerialize(tax));
					obj.put(SPShoppingConstants.STATUS,
							SPShoppingConstants.SUCCESS);
					logger.info("successfully saved prouct data = " + id);
				} catch (Exception e) {
					logger.error("Exception while saving selling package");
					SPShoppingHelper.setErrorMsg(obj, e.getMessage());
				}
				break;
			case "getPackageDiscounts":
				try {
					List<SPDiscount> discounts = SPDiscountLocalServiceUtil
							.findDiscountsByPackageId(GetterUtil.getLong(id));
					obj.put(SPShoppingConstants.STATUS,
							SPShoppingConstants.SUCCESS);
					obj.put(SPShoppingConstants.OBJECT,
							JSONFactoryUtil.looseSerialize(discounts));
				} catch (Exception e) {
					logger.error("Exception while saving selling package");
					SPShoppingHelper.setErrorMsg(obj, e.getMessage());
				}
				break;
			default:
				SPShoppingHelper.setErrorMsg(obj, "Invalid action code");
			}
		} else {
			SPShoppingHelper.setErrorMsg(obj, SPShoppingConstants.UNAUTH_MSG_VIEW);
		}

		resourceResponse.getWriter().write(obj.toString());
	}
	
}