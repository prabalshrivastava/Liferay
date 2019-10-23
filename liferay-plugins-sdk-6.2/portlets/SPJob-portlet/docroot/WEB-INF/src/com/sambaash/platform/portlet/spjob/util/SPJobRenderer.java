package com.sambaash.platform.portlet.spjob.util;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.sambaash.platform.srv.spjob.model.SPJob;
public class SPJobRenderer extends BaseAssetRenderer {

	public SPJobRenderer(SPJob spJob) {
		this.spJob = spJob;
	}

	@Override
	public String getClassName() {

		// TODO Auto-generated method stub

		return null;
	}

	public long getClassPK() {
		return spJob.getSpJobId();
	}

	public long getGroupId() {
		return spJob.getGroupId();
	}

	public String getSummary(Locale locale) {
		return spJob.getJobDescription();
	}

	public String getTitle(Locale locale) {
		return spJob.getJobTitle();
	}

	public long getUserId() {
		return spJob.getUserId();
	}

	@Override
	public String getUserName() {

		// TODO Auto-generated method stub

		return null;
	}

	public String getUuid() {
		return spJob.getUuid();
	}

	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
		return null;
	}

	private SPJob spJob;

}