package com.sambaash.platform.portlet.spms.util;

/**
**/
public class MembershipSubscriptionConfigurValue {
/**
	PAYPAL_PAYPALID, PAYPAL_TAXFACTOR, LOCALHOST_URL, SIT_URL, QA_URL, PRODUCTION_URL;

	public String toString() {

		SPParameters spParametersPayaplid = null;
		SPParameters spParametersTaxFactor = null;

		//return spParameters.getValue();

		Log _log = LogFactoryUtil.getLog(MembershipSubscriptionConfigurValue.class);
		try {

			spParametersPayaplid = SPParametersLocalServiceUtil.findBySPParametersGroupIdAndName(
													Long.valueOf(SambaashConstants.DEFAULT_GROUP_ID),
													SambaashConstants.PAYPAL_PAYPALID);

			spParametersTaxFactor = SPParametersLocalServiceUtil.findBySPParametersGroupIdAndName(
					Long.valueOf(SambaashConstants.DEFAULT_GROUP_ID),
					SambaashConstants.PAYPAL_TAXFACTOR);

		}catch (Exception ex) {
			_log.info("SPParametersLocalServiceUtil.findBySPParametersGroupIdAndName Exception : "+ex);
		}

		switch(this) {
			case PAYPAL_PAYPALID : return spParametersPayaplid.getValue();
			case PAYPAL_TAXFACTOR : return spParametersTaxFactor.getValue();
			case LOCALHOST_URL : return PropsUtil.get(PropsKeys.CAS_SERVER_NAME);//"http://localhost:8080";
			case SIT_URL : return PropsUtil.get(PropsKeys.CAS_SERVER_NAME);//"http://sit.sambaash.com";
			case QA_URL : return PropsUtil.get(PropsKeys.CAS_SERVER_NAME);//"http://alphaus.sixdegrees.asia";
			case PRODUCTION_URL : return PropsUtil.get(PropsKeys.CAS_SERVER_NAME);//"http://www.sixdegrees.asia";
			default : return "";
		}
	}

	**/
}