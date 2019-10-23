package com.sambaash.platform.spshopping.helper;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.spshopping.SPShoppingConstants;
import com.sambaash.platform.util.FormHelper;

public abstract class SPShoppingHelper extends FormHelper {
	
	private static Log _log = LogFactoryUtil.getLog(SPShoppingHelper.class);
			
	private static JSONArray array = JSONFactoryUtil.createJSONArray();

	public SPShoppingHelper(Map<String, String> register, ClassLoader loader) {
		super(register, loader);
	}

	public static final ThemeDisplay getThemeDisplay(PortletRequest request) {
		return (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	public static void loadCurrencies(RenderRequest renderRequest) {
		List<String> tempList = new ArrayList<String>();
		
		if (array.length() == 0) {
			_log.debug("loading currencies");
			try {
				Currency currency = null;
				Locale locale = null;
				String currencySymbol = null;
				List<Country> countryCode = CountryServiceUtil.getCountries();
				for (Country country : countryCode) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {
						locale = new Locale.Builder()
								.setRegion(country.getA2()).build();
						currency = Currency.getInstance(locale);
						currencySymbol = currency.getSymbol(locale);
						if (tempList.contains(currencySymbol))
							continue;
						tempList.add(currencySymbol);
						obj.put("code", currencySymbol);
						array.put(obj);
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
				_log.error(e);
			}
			_log.debug("Loaded currencies" + array);
		}

		if (array.length() > 0) {
			renderRequest.setAttribute("currencyCodes",
					JSONFactoryUtil.looseSerialize(array));
		}
	}
	
	public static void setErrorMsg(JSONObject obj, String errorMsg) {
		obj.put(SPShoppingConstants.STATUS, SPShoppingConstants.FAIL);
		obj.put(SPShoppingConstants.ERROR_MSG, errorMsg);
	}

}
