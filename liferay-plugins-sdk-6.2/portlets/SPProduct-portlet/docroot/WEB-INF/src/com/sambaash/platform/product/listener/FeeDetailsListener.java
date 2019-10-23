package com.sambaash.platform.product.listener;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.sambaash.platform.product.util.SPProductUtil;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.FeeDetails;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPShoppingLocalServiceUtil;

public class FeeDetailsListener extends BaseModelListener<FeeDetails> {
	public static Log _log = LogFactoryUtil.getLog(FeeDetailsListener.class);
	public static final long COURSE_FEE_TYPE_IDENTIFIER = 10;
	private static final long CLASS_NAME_ID = ClassNameLocalServiceUtil.getClassNameId(FeeDetails.class);
	
	@Override
	public void onAfterCreate(FeeDetails feeDetails) throws ModelListenerException {
		try {
			if (SPProductUtil.isCoursePaymentEnabled(feeDetails.getGroupId()) && feeDetails.getFeeType() == COURSE_FEE_TYPE_IDENTIFIER) {
				_log.error("Adding price detail for courseId '"+feeDetails.getSpCourseId()+"' into the Shopping product price catalog.");
				String currencyCode = getCourseCurrency(feeDetails.getSpCourseId());
				SPShoppingLocalServiceUtil.addProductPrice(
						feeDetails.getCompanyId(), feeDetails.getGroupId(), 
						feeDetails.getUserId(), feeDetails.getUserName(), 
						CLASS_NAME_ID, feeDetails.getSpCourseId(), currencyCode, 
						new BigDecimal(feeDetails.getAmount()));
			}
		} catch (Exception e) {
			_log.error("Error adding price detail for courseId '"+feeDetails.getSpCourseId()+"' into the Shopping product price catalog.", e);
		}
	}
	
	private String getCourseCurrency(long spCourseId) {
		String currencyCode = "";
		try {
		   Course course = CourseLocalServiceUtil.getCourse(spCourseId);
		   Country country = CountryServiceUtil.getCountryByName(AssetCategoryLocalServiceUtil
		         .getAssetCategory(Long.parseLong(course.getCountryId())).getName().toLowerCase());
		   Locale localeTemp = new Locale("", country.getA2());
		   currencyCode = Currency.getInstance(localeTemp).getCurrencyCode();
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return currencyCode;
	}
	
}
