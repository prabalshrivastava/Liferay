package com.sambaash.platform.portlet.spgroup.listener;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.spneo4j.form.JoinGraphForm;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.model.SPGroupUser;
import com.sambaash.platform.util.Neo4jHelper;
import com.sambaash.platform.util.SambaashUtil;
public class SPGroupUserGraphListener extends BaseModelListener<SPGroupUser> {

	@Override
	public void onAfterCreate(SPGroupUser spGroupUser) throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterCreate spGroupUser ********************");

				SPNeoforjLocalServiceUtil.join(SambaashConstants.NEO4J.JOIN, spGroupUser.getUserId(), SPGroup.class.getName(),
						spGroupUser.getSpGroupId(), spGroupUser.getRole(), spGroupUser.getStatus(), spGroupUser.getCompanyId(), spGroupUser.getGroupId(), -1L);

				// push real time activity

			}

		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	@Override
	public void onAfterRemove(SPGroupUser spGroupUser) throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterRemove spGroupUser ********************");

				SPNeoforjLocalServiceUtil.join(SambaashConstants.NEO4J.QUIT, spGroupUser.getUserId(), SPGroup.class.getName(),
						spGroupUser.getSpGroupId(), spGroupUser.getRole(), spGroupUser.getStatus(), spGroupUser.getCompanyId(), spGroupUser.getGroupId(), -1L);
			}

		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	@Override
	public void onAfterUpdate(SPGroupUser spGroupUser) throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterUpdate spGroupUser ********************");

				JoinGraphForm joinGraphForm = new JoinGraphForm(null, spGroupUser.getUserId(), SPGroup.class.getName(),
						spGroupUser.getSpGroupId(), spGroupUser.getRole(), spGroupUser.getStatus(), spGroupUser.getJoinDate());
				
				Neo4jHelper.fillMandatoryFields(joinGraphForm, spGroupUser.getCompanyId(), spGroupUser.getGroupId(), -1L);
				
				SPNeoforjLocalServiceUtil.updateJoinGraph(joinGraphForm);
			}

		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPGroupUserGraphListener.class);

}