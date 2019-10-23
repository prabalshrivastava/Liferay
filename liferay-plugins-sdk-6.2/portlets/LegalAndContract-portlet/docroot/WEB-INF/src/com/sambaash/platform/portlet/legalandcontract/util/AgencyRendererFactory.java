package com.sambaash.platform.portlet.legalandcontract.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.sambaash.platform.srv.legalandcontract.model.Agency;

public class AgencyRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = Agency.class.getName();
	public static final String TYPE = "Agency";

	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type) throws PortalException, SystemException {
		return null;
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