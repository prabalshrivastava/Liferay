package com.sambaash.platform.spmicroservice.listener;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.Role;
import com.sambaash.platform.srv.spmicroservice.service.FormsMicroserviceLocalServiceUtil;

public class RoleListener extends BaseModelListener<Role>{

	@Override
	public void onAfterCreate(Role role) throws ModelListenerException {
		FormsMicroserviceLocalServiceUtil.synchroniseRole(role.getCompanyId(), role.getRoleId(), role.getName());
	}

	@Override
	public void onAfterUpdate(Role role) throws ModelListenerException {
		FormsMicroserviceLocalServiceUtil.synchroniseRole(role.getCompanyId(), role.getRoleId(), role.getName());
	}

}
