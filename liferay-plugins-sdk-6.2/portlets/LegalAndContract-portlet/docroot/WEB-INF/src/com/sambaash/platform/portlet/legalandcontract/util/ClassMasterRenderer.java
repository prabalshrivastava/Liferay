package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.sambaash.platform.srv.legalandcontract.model.ClassMaster;

public class ClassMasterRenderer extends BaseAssetRenderer {

	public ClassMasterRenderer(ClassMaster classMaster) {
		this.classMaster = classMaster;
	}

	@Override
	public long getClassPK() {
		return classMaster.getSpClassId();
	}

	@Override
	public long getGroupId() {
		return classMaster.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return StringPool.BLANK;
	}

	@Override
	public String getTitle(Locale locale) {
		return StringPool.BLANK;
	}

	@Override
	public long getUserId() {
		return classMaster.getUserId();
	}

	@Override
	public String getUuid() {
		return classMaster.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
		return StringPool.BLANK;
	}

	private ClassMaster classMaster;

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

}
