package com.sambaash.platform.spshopping.helper;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.spshopping.SPShoppingConstants;
import com.sambaash.platform.srv.spshopping.model.SPSellingPackage;
import com.sambaash.platform.srv.spshopping.model.SPSellingPrice;
import com.sambaash.platform.srv.spshopping.model.impl.SPSellingPackageImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceImpl;
import com.sambaash.platform.srv.spshopping.service.SPSellingPackageLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalServiceUtil;
import com.sambaash.platform.util.FormHelper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SPShoppingPackageHelper extends SPShoppingHelper {

	private static Log _log = LogFactoryUtil.getLog(SPShoppingPackageHelper.class);
	
	
	private static final Map<String, String> register = new HashMap<String, String>();

	static {
		register.put(SPShoppingConstants.ATTRIB_PKG,
				SPSellingPackageImpl.class.getName());
		register.put(SPShoppingConstants.ATTRIB_PRICE,
				SPSellingPriceImpl.class.getName());
	}

	public SPShoppingPackageHelper() {
		super(register, SPShoppingPackageHelper.class.getClassLoader());
	}

	public SPSellingPackage persistData(PortletRequest request, String spPkgId) {
		ThemeDisplay themeDisplay = getThemeDisplay(request);
		SPSellingPackage pkg = null;
		try {
			Map<String, Object> dataMap = this.parsedRequestData(
					FormHelper.getRequestParamMap(request, themeDisplay), null,
					StringPool.BLANK);

			pkg = (SPSellingPackage) dataMap
					.get(SPShoppingConstants.ATTRIB_PKG);
			SPSellingPrice price = (SPSellingPrice) dataMap
					.get(SPShoppingConstants.ATTRIB_PRICE);
			if (pkg.isNew()) {
				price.setPriceRefTypeId(SPShoppingConstants.PRICE_REF_TYPE_PKG_ID);
				pkg.setSpSellingPackageId(CounterLocalServiceUtil
						.increment("SPSellingPackage"));
			}
			price.setPriceRefId(pkg.getSpSellingPackageId());
			if (price.isNew()) {
				price.setSpSellingPriceId(CounterLocalServiceUtil
						.increment("SPSellingPrice"));
			}
			SPSellingPackageLocalServiceUtil.updateSPSellingPackage(pkg);
			SPSellingPriceLocalServiceUtil.updateSPSellingPrice(price);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		return pkg;
	}

}