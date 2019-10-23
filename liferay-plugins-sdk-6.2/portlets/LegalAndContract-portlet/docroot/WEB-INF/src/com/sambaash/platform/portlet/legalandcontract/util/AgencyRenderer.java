package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.sambaash.platform.srv.legalandcontract.model.Agency;

public class AgencyRenderer extends BaseAssetRenderer {

	public AgencyRenderer(Agency agency) {
		this.agency = agency;
	}

	@Override
	public long getClassPK() {
		return agency.getSpAgencyId();
	}

	@Override
	public long getGroupId() {
		return agency.getGroupId();
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
		return agency.getUserId();
	}

	@Override
	public String getUuid() {
		return agency.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
		return StringPool.BLANK;
	}

	private Agency agency;

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
