package com.sambaash.platform.taglib.ui;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

/**
 * @author Clark Cui Jian Jun
 */
public class SPLikeTag extends IncludeTag {

	public void setCommunityName(String communityName) {
		_communityName = communityName;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	@Override
	protected void cleanUp() {
		_communityName = null;
		_className = null;
		_classPK = 0;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute(
			"sp-ui:like:communityName", _communityName);
		request.setAttribute(
			"sp-ui:like:className", _className);
		request.setAttribute(
			"sp-ui:like:classPK", String.valueOf(_classPK));
	}

	private static final String _PAGE =
		"/html/sambaash/platform/taglib/sp-ui/like/page.jsp";

	private String _communityName;
	private String _className;
	private long _classPK;

}