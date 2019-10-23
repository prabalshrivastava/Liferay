package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;

public class TrademarksRenderer extends BaseAssetRenderer {

	public TrademarksRenderer (Trademarks trademarks){
		this.trademarks = trademarks;
	}
	
	@Override
	public long getClassPK() {
		return trademarks.getSpTrademarksId();
	}

	@Override
	public long getGroupId() {
		return trademarks.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return StringPool.BLANK;
	}

	@Override
	public String getTitle(Locale locale) {
		return trademarks.getTrademarkType();
	}

	@Override
	public long getUserId() {
		return trademarks.getUserId();
	}

	@Override
	public String getUuid() {
		return trademarks.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
		return null;
	}
	
	private Trademarks trademarks;

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
