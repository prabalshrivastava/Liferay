package com.sambaash.platform.spshopping.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.spshopping.SPShoppingConstants;
import com.sambaash.platform.srv.spshopping.model.SPDiscount;
import com.sambaash.platform.srv.spshopping.model.impl.SPDiscountImpl;
import com.sambaash.platform.srv.spshopping.service.SPDiscountLocalServiceUtil;
import com.sambaash.platform.util.FormHelper;

public class SPShoppingDiscountHelper extends SPShoppingHelper {

	private static final Map<String, String> register = new HashMap<String, String>();
	private static String PREFIX = SPShoppingConstants.ATTRIB_DISCOUNT + "_";
	
	private static Log _log = LogFactoryUtil.getLog(SPShoppingDiscountHelper.class);
	
	static {
		register.put(SPShoppingConstants.ATTRIB_DISCOUNT,
				SPDiscountImpl.class.getName());
	}

	public SPShoppingDiscountHelper() {
		super(register, SPShoppingDiscountHelper.class.getClassLoader());
	}

	public SPDiscount persistData(PortletRequest request, String spDiscountId) {
		ThemeDisplay themeDisplay = getThemeDisplay(request);
		SPDiscount discount = null;
		try {
			Map<String, Object> dataMap = this.parsedRequestData(
					FormHelper.getRequestParamMap(request, themeDisplay), null,
					StringPool.BLANK);

			discount = (SPDiscount) dataMap
					.get(SPShoppingConstants.ATTRIB_DISCOUNT);
			if (discount.isNew()) {
				discount.setSpDiscountId(CounterLocalServiceUtil
						.increment("SPDiscount"));
			}
			SPDiscountLocalServiceUtil.updateSPDiscount(discount);
		} catch (SystemException e) {
			_log.error(e);
		}
		return discount;
	}

	// TODO combine the below method to one.
	public static SPDiscount getPercentDiscount(List<SPDiscount> discounts,
			Date date) throws SystemException {
		SPDiscount result = null;
		if (discounts == null || discounts.size() == 0)
			return null;
		for (SPDiscount spDiscount : discounts) {
			if (Validator.isNull(spDiscount.getCouponCode())) {
				if (date.after(spDiscount.getStartDate())
						&& date.before(spDiscount.getEndDate())) {
					if (result == null)
						result = spDiscount;
					else
						throw new SystemException(
								"Incorrect discount configuration");
					// there shouldnt be 2 discounts(of same type) configured
					// for a package
				}
			}
		}
		return result;
	}

	public static SPDiscount getCouponDiscount(List<SPDiscount> discounts,
			Date date) throws SystemException {
		SPDiscount result = null;
		if (discounts == null || discounts.size() == 0)
			return null;
		for (SPDiscount spDiscount : discounts) {
			if (Validator.isNotNull(spDiscount.getCouponCode())) {
				if (date.after(spDiscount.getStartDate())
						&& date.before(spDiscount.getEndDate())) {
					if (result == null)
						result = spDiscount;
					else
						throw new SystemException(
								"Incorrect discount configuration");
					// there shouldnt be 2 discounts(of same type) configured
					// for a package
				}
			}
		}
		return result;
	}

	public static void validateRequest(ResourceRequest resourceRequest,
			String discountId) throws SystemException, PortalException {
		ThemeDisplay themeDisplay = getThemeDisplay(resourceRequest);
		Map<String, String> requestParamMap = FormHelper.getRequestParamMap(
				resourceRequest, themeDisplay);

		Date endDate = GetterUtil.getDate(requestParamMap.get(PREFIX
				+ "endDate"), new SimpleDateFormat("MM/dd/yyyy"));
		Date startDate = GetterUtil.getDate(
				requestParamMap.get(PREFIX + "startDate"),
				new SimpleDateFormat("MM/dd/yyyy"));
		boolean isCoupon = Validator.isNotNull(requestParamMap.get(PREFIX
				+ "couponCode"));
		Long packageId = GetterUtil.getLong(requestParamMap.get(PREFIX
				+ "packageId"));

		if (endDate.before(new Date())) {
			throw new SystemException("End Date is in the past!");
		}
		
		if (endDate.before(startDate)) {
			throw new SystemException("End Date is before Start Date!");
		}
		

		List<SPDiscount> discounts = SPDiscountLocalServiceUtil
				.findDiscountsByPackageId(packageId);
		for (SPDiscount spDiscount : discounts) {
			if (spDiscount.getSpDiscountId() == GetterUtil.getLong(discountId)) {
				continue;
			}
			
			// if date ranges are not intersecting, its ok
			if (endDate.compareTo(spDiscount.getStartDate()) <= 0 ||
					spDiscount.getEndDate().compareTo(startDate) <= 0){
				continue;
			}
			
			boolean existingIsCoupon = Validator.isNotNull(spDiscount.getCouponCode());
			
			// reached here..so intersecting dates
			if((isCoupon && !existingIsCoupon) || (!isCoupon && existingIsCoupon)) {
				continue;
			}
			if (isCoupon)
				throw new SystemException("Promo Discount already configured for the date range");
			else 
				throw new SystemException("Discount already configured for the date ranage");
		}
	}

}