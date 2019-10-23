package com.sambaash.platform.portlet.upgrade.util;

//import com.liferay.portlet.login.util.LoginUtil;

import java.text.DateFormat;

import java.util.Date;
import java.util.List;

/**
import sambaash.platform.srv.membershippackage.model.MembershipPackagePromotionCode;
import sambaash.platform.srv.membershippackage.service.MembershipPackagePromotionCodeLocalServiceUtil;
import sambaash.platform.srv.socialprofile.model.SocialProfile;
import sambaash.platform.srv.socialprofile.service.SocialProfileLocalServiceUtil;
**/
public class MembershipUpgradeService {
/**
	public static String getDisplayPromotionDateRange(long promtionCodId) {
		String promotionPeriodDateMsg = "";
		try {
			MembershipPackagePromotionCode promotionCode = MembershipPackagePromotionCodeLocalServiceUtil
					.getMembershipPackagePromotionCode(promtionCodId);

			Date datePromoFrom = promotionCode.getPromotionFrom();
			Date datePromoTo = promotionCode.getPromotionTo();

			promotionPeriodDateMsg = "Promotion code is valid from " + DateFormat.getDateInstance(DateFormat.MEDIUM).format(datePromoFrom) + " to "
					+ DateFormat.getDateInstance(DateFormat.MEDIUM).format(datePromoTo) + " UTC +8 (Asia/Singapore) Time";

		} catch (NumberFormatException nfe) {
			promotionPeriodDateMsg = "Please enter a valid promotion code.";
		} catch (Exception e) {
			_log.error(e);
		}

		return promotionPeriodDateMsg;
	}

	public static String getValidatePromotionCode(long mpId, String promotionCode) {
		String msg = "";
		try {
			if (Validator.isNull(promotionCode))
				return msg;

			List<MembershipPackagePromotionCode> promoCodes = MembershipPackagePromotionCodeLocalServiceUtil.findBypromotionCode(promotionCode);

			if (promoCodes.isEmpty())
				return msg = "Invalid promotion code";

			List<MembershipPackagePromotionCode> mpPromotionCodeList = MembershipPackagePromotionCodeLocalServiceUtil
					.findBymembershipPackage_Id(mpId);

			if (mpPromotionCodeList.isEmpty())
				return msg = "No Promotion code available for this package";

			for (MembershipPackagePromotionCode mp : mpPromotionCodeList) {
				if (mp.getPromotionCode().equals(promotionCode)) {
					Date currentDate = new Date();
					Date promoFrom = mp.getPromotionFrom();
					Date promoTo = mp.getPromotionTo();

					if (!(currentDate.after(promoFrom) && currentDate.before(promoTo))) {
						return msg = "Promotion code " + promotionCode + " is already expired";
					}
				}
			}

		} catch (SystemException e) {
			_log.error(e);
		}

		return msg;
	}

	public static MembershipPackagePromotionCode getMembershipPackagePromotionCode(long mpId, String promotionCode) {
		MembershipPackagePromotionCode mppc = null;
		try {
			List<MembershipPackagePromotionCode> mpPromotionCodeList = MembershipPackagePromotionCodeLocalServiceUtil
					.findBymembershipPackage_Id(mpId);

			for (MembershipPackagePromotionCode mp : mpPromotionCodeList) {
				if (mp.getPromotionCode().equals(promotionCode)) {
					mppc = (MembershipPackagePromotionCode)mp.clone();
				}
			}
		} catch (SystemException e) {
			_log.error(e);
		}

		return mppc;
	}

	public static SocialProfile getUserProfile(String remoteUser) {
		SocialProfile sp = null;
		try {
			long userID = Long.valueOf(remoteUser).longValue();
			sp = SocialProfileLocalServiceUtil.getSocialProfile(userID);

		} catch (Exception e) {
		}

		return sp;
	}

	private static Log _log = LogFactoryUtil.getLog(MembershipUpgradeService.class);	**/

}