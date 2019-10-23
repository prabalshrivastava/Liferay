package com.sambaash.platform.comparator;

import java.util.Comparator;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.SambaashUtil;

public class RoleComparatorByOrder implements Comparator<Role> {

	private ThemeDisplay themeDisplay;
	public  RoleComparatorByOrder(ThemeDisplay themeDisplay) {
		this.themeDisplay = themeDisplay;
	}
	@Override
	public int compare(Role o1, Role o2) {
		try {
			    int order1 = GetterUtil.getInteger(SambaashUtil.getRoleExpandoValueByAttribute(themeDisplay, o1, SambaashConstants.EXPANDO_ATTR_ROLE_ORDER));
			    int order2 = GetterUtil.getInteger(SambaashUtil.getRoleExpandoValueByAttribute(themeDisplay, o2, SambaashConstants.EXPANDO_ATTR_ROLE_ORDER));
			    return order1 - order2;
		} catch (Exception e) {
		}
		return 0;
	}

}
