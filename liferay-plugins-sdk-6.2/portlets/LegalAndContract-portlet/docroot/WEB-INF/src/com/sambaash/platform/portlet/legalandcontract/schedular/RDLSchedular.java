package com.sambaash.platform.portlet.legalandcontract.schedular;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.GetterUtil;
import com.sambaash.platform.portlet.legalandcontract.util.LegalConstants;
import com.sambaash.platform.util.SambaashUtil;

public class RDLSchedular implements MessageListener {

	private static Log _log = LogFactoryUtil.getLog(RDLSchedular.class);

	public void receive(Message msg) {
		_log.debug("Crone Schedular : for sending mails for Contintious Proceedings Response Deadlines");
		try {
			_log.debug("-------------------RDL Schedular-----------------");
			boolean sendMail = GetterUtil.getBoolean(SambaashUtil.getParameter(
					LegalConstants.SP_PARAMETER_SEND_EXPIRE_TM_ALERTS, 0));
			_log.debug("sendmail flag from spparameter" + sendMail);
			if (sendMail) {
				RDLMailHelper.sendMails();
			}
		} catch (Exception e) {
			_log.error(" Error while sending mails ");
		}
		_log.debug("-------------------End RDL Schedular-----------------");
		_log.debug("Crone Schedular : for sending mails for Contintious Proceedings Response Deadlines - finished");
	}

}
