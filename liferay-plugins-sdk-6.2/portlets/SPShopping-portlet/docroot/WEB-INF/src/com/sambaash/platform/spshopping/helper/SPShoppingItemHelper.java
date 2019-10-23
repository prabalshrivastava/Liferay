package com.sambaash.platform.spshopping.helper;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.spshopping.SPShoppingConstants;
import com.sambaash.platform.srv.spshopping.model.SPSellingItem;
import com.sambaash.platform.srv.spshopping.model.SPSellingPrice;
import com.sambaash.platform.srv.spshopping.model.impl.SPSellingItemImpl;
import com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceImpl;
import com.sambaash.platform.srv.spshopping.service.SPSellingItemLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalServiceUtil;
import com.sambaash.platform.util.FormHelper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SPShoppingItemHelper extends SPShoppingHelper {
	
	private static Log _log = LogFactoryUtil.getLog(SPShoppingItemHelper.class);

	private static final Map<String, String> register = new HashMap<String, String>();

	static {
		register.put(SPShoppingConstants.ATTRIB_ITEM,
				SPSellingItemImpl.class.getName());
		register.put(SPShoppingConstants.ATTRIB_PRICE,
				SPSellingPriceImpl.class.getName());
	}

	public SPShoppingItemHelper() {
		super(register, SPShoppingItemHelper.class.getClassLoader());
	}

	public SPSellingItem persistData(PortletRequest request, String spItemId) {
		ThemeDisplay themeDisplay = getThemeDisplay(request);
		SPSellingItem item = null;
		try {
			Map<String, Object> dataMap = this.parsedRequestData(
					FormHelper.getRequestParamMap(request, themeDisplay), null,
					StringPool.BLANK);

			item = (SPSellingItem) dataMap.get(SPShoppingConstants.ATTRIB_ITEM);
			SPSellingPrice price = (SPSellingPrice) dataMap
					.get(SPShoppingConstants.ATTRIB_PRICE);
			if (item.isNew()) {
				item.setSpSellingItemId(CounterLocalServiceUtil
						.increment("SPSellingItem"));
			}
			price.setPriceRefId(item.getSpSellingItemId());
			if (price.isNew()) {
				price.setPriceRefTypeId(SPShoppingConstants.PRICE_REF_TYPE_ITEM_ID);
				price.setSpSellingPriceId(CounterLocalServiceUtil
						.increment("SPSellingPrice"));
			}
			SPSellingItemLocalServiceUtil.updateSPSellingItem(item);
			SPSellingPriceLocalServiceUtil.updateSPSellingPrice(price);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		return item;
	}

}