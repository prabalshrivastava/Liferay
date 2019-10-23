package com.sambaash.platform.model.listener;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;
import com.sambaash.platform.srv.spservices.model.SPSite;
import com.sambaash.platform.srv.spservices.service.SPSiteLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.impl.SPSiteLocalServiceImpl;

public class UserListener extends BaseModelListener<User>{
	private static Log _log = LogFactoryUtil.getLog(SPSiteLocalServiceImpl.class);
	
	@Override
	public void onAfterCreate(User user) throws ModelListenerException {
		updateSPSitePassword(user);
	}

	@Override
	public void onAfterUpdate(User user) throws ModelListenerException {
		updateSPSitePassword(user);
	}

	@Override
	public void onAfterRemove(User user) throws ModelListenerException {
		deleteSPSiteEntry(user);
	}

	private void updateSPSitePassword(User user) {
		try {
			for (SPSite spSite : SPSiteLocalServiceUtil.findByUserId(user.getUserId())){
				spSite.setPassword(user.getPassword());
				SPSiteLocalServiceUtil.updateSPSite(spSite);
			}			
		} catch (Exception e) {
			_log.error("Error updating SPSite password", e);
		}
	}

	private void deleteSPSiteEntry(User user) {
		try {
			for (SPSite spSite : SPSiteLocalServiceUtil.findByUserId(user.getUserId())){
				SPSiteLocalServiceUtil.deleteSPSite(spSite);
			}
		} catch (Exception e) {
			_log.error("Error removing SPSite entry for user "+user.getEmailAddress()+" - "+user.getUserId(), e);
		}
	}

}
