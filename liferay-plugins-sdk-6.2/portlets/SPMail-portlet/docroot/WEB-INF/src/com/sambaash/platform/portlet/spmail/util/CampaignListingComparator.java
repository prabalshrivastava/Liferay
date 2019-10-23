package com.sambaash.platform.portlet.spmail.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;

import java.util.Comparator;
import java.util.Date;

public class CampaignListingComparator implements Comparator<SPMailCampaign> {

	public int compare(SPMailCampaign o1, SPMailCampaign o2) {

		try {
			Date date1 = o1.getCreateDate();
			Date date2 = o2.getCreateDate();

			return date1.compareTo(date2);
		} catch (Exception e) {
			logger.error(" Error occured in comparison " + e.getMessage());
		}

		return 0;
	}

	private static Log logger = LogFactoryUtil
			.getLog(CampaignListingComparator.class);

}