package com.sambaash.platform.taglib.ui;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

/**
 * @author Clark Cui Jian Jun
 */
public class SPFollowTag extends IncludeTag {

	public void setCommunityName(String communityName) {
		_communityName = communityName;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public void setLinkOrBtn(String linkOrBtn) {
		_linkOrBtn = linkOrBtn;
	}

	@Override
	protected void cleanUp() {
		_communityName = null;
		_className = null;
		_classPK = 0;
		_linkOrBtn = "btn";
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute(
			"sp-ui:follow:communityName", _communityName);
		request.setAttribute(
			"sp-ui:follow:className", _className);
		request.setAttribute(
			"sp-ui:follow:classPK", String.valueOf(_classPK));
		request.setAttribute(
			"sp-ui:follow:linkOrBtn", _linkOrBtn);
	}

	private static final String _PAGE =
		"/html/sambaash/platform/taglib/sp-ui/follow/page.jsp";

	private String _communityName;
	private String _className;
	private long _classPK;
	private String _linkOrBtn;

}