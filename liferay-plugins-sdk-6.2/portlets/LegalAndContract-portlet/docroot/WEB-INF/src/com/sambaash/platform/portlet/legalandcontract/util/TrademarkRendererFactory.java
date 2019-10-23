package com.sambaash.platform.portlet.legalandcontract.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalServiceUtil;


public class TrademarkRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = Trademarks.class.getName();
	public static final String TYPE = "Trademarks";
	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type) throws PortalException, SystemException {
		Trademarks trademarks = TrademarksLocalServiceUtil.getTrademarks(classPK);
		return new TrademarksRenderer(trademarks);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
