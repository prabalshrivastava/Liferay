package com.sambaash.platform.portlet.spjob.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.sambaash.platform.srv.spjob.model.SPJob;
import com.sambaash.platform.srv.spjob.service.SPJobLocalServiceUtil;
public class SPJobRendererFactory extends BaseAssetRendererFactory {

	public static final String CLASS_NAME = SPJob.class.getName();

	public static final String TYPE = "SPJob";

	public AssetRenderer getAssetRenderer(long classPK, int type) throws PortalException, SystemException {
		SPJob spJob = SPJobLocalServiceUtil.getSPJob(classPK);
		return new SPJobRenderer(spJob);
	}

	public String getClassName() {
		return CLASS_NAME;
	}

	public String getType() {
		return TYPE;
	}

}