package com.sambaash.platform.portlet.spmail.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.srv.mail.NoSuchBlackListException;
import com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.service.SPMailBlackListLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalServiceUtil;

public class CampaignHelper {
	private static final Log _log = LogFactoryUtil.getLog(CampaignHelper.class);
	public static boolean canSendMail(SPMailCampaign campaign, String email) {
		_log.debug("Checking if mail can send to  " + email);
		boolean canSend = false;
		try {
			SPMailBlackListLocalServiceUtil.findByEmailAddress(email);
		} catch (NoSuchBlackListException e) {
			try {
				SPMailUnsubscribeLocalServiceUtil
						.findByEmailAddressAndCategoryId(email,
								campaign.getCategoryId());
			} catch (NoSuchUnsubscribeException e1) {
				canSend = true;
			} catch (SystemException e1) {
				_log.debug(e1);
			}
		} catch (SystemException e) {
			_log.debug(e);
		}
		
		_log.debug("Can mail send to " + email + " ?? " + canSend);
		return canSend;
	}
}
