package com.sambaash.platform.portlet.legalandcontract.schedular;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.GetterUtil;
import com.sambaash.platform.portlet.legalandcontract.util.LegalConstants;
import com.sambaash.platform.util.SambaashUtil;

public class RenewalAlertSchedular implements MessageListener {
	
	private static Log _log = LogFactoryUtil.getLog(RenewalAlertSchedular.class);
	public void receive(Message msg) {
		_log.debug("Crone Schedulr : for sending mails for expired trademarks");
		try {
			_log.debug("-------------------RDL Schedular-----------------");
			boolean sendMail = GetterUtil.getBoolean(SambaashUtil.getParameter(LegalConstants.SP_PARAMETER_SEND_EXPIRE_TM_ALERTS, 0));
			_log.debug("sendmail flag from spparameter" + sendMail);
			if(sendMail){
				RenewalAlertMailHelper.sendMails();
			}
				
		} catch (Exception e) {
			_log.error(" Error while sending Renewal Alert for Trademarks " + e.getMessage());
		}
	}
	
	
	long getTimeDiffInDays(Date date1,Date date2){
		long diffInMillies = date1.getTime() - date2.getTime();
	    return TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
}
