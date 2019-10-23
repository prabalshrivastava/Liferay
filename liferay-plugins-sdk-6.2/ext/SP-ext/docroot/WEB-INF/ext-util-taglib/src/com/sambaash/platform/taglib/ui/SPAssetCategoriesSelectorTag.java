package com.sambaash.platform.taglib.ui;

import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Clark Cui Jian Jun
 */
public class SPAssetCategoriesSelectorTag extends IncludeTag {

	public void setClassName(String className) {
		_className = className;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	@Override
	protected void cleanUp() {
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
			"sp-ui:asset-categories-selector:className", _className);
		request.setAttribute(
			"sp-ui:asset-categories-selector:classPK",
			String.valueOf(_classPK));
	}

	private static final String _PAGE =
		"/html/sambaash/platform/taglib/sp-ui/asset_categories_selector/page.jsp";

	private String _className;
	private long _classPK;

}