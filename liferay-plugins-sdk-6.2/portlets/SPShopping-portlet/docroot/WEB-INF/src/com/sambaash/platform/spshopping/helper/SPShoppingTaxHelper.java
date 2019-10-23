package com.sambaash.platform.spshopping.helper;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.spshopping.SPShoppingConstants;
import com.sambaash.platform.srv.spshopping.model.SPTax;
import com.sambaash.platform.srv.spshopping.model.impl.SPTaxImpl;
import com.sambaash.platform.srv.spshopping.service.SPTaxLocalServiceUtil;
import com.sambaash.platform.util.FormHelper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SPShoppingTaxHelper extends SPShoppingHelper {

	private static Log _log = LogFactoryUtil.getLog(SPShoppingTaxHelper.class);
	
	private static final Map<String, String> register = new HashMap<String, String>();

	static {
		register.put(SPShoppingConstants.ATTRIB_TAX, SPTaxImpl.class.getName());
	}

	public SPShoppingTaxHelper() {
		super(register, SPShoppingTaxHelper.class.getClassLoader());
	}

	public SPTax persistData(PortletRequest request, String spPkgId) throws Exception {
		ThemeDisplay themeDisplay = getThemeDisplay(request);
		SPTax tax = null;
		try {
			Map<String, Object> dataMap = this.parsedRequestData(
					FormHelper.getRequestParamMap(request, themeDisplay), null,
					StringPool.BLANK);

			tax = (SPTax) dataMap.get(SPShoppingConstants.ATTRIB_TAX);

			SPTax existingTax = SPTaxLocalServiceUtil.getSPTaxByCurrency(tax
					.getCurrencyCode());

			if (existingTax == null) {
				tax.setSpTaxId(CounterLocalServiceUtil.increment("SPTax"));
			} else if (existingTax != null && tax.isNew()) {
				throw new Exception("Tax configuration already exists");
			} else {
				// for edit
			}
			SPTaxLocalServiceUtil.updateSPTax(tax);
		} catch (Exception e) {
			_log.error(e.getMessage());
			throw e;
		}
		return tax;
	}
}
