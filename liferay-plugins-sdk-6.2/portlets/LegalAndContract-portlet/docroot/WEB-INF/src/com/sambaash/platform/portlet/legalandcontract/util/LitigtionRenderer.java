package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.sambaash.platform.srv.legalandcontract.model.Litigation;

public class LitigtionRenderer extends BaseAssetRenderer {

	public LitigtionRenderer(Litigation litigation) {
		this.litigation = litigation;
	}

	@Override
	public long getClassPK() {
		return litigation.getSpLitigationId();
	}

	@Override
	public long getGroupId() {
		return litigation.getGroupId();
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
		return litigation.getUserId();
	}

	@Override
	public String getUuid() {
		return litigation.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
		return StringPool.BLANK;
	}

	private Litigation litigation;

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
