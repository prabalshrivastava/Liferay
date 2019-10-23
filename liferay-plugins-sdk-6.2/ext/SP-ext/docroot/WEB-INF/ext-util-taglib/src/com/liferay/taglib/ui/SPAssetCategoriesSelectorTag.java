package com.liferay.taglib.ui;

import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 */
public class SPAssetCategoriesSelectorTag extends IncludeTag {

	public void setClassName(String className) {
		_className = className;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public void setContentCallback(String contentCallback) {
		_contentCallback = contentCallback;
	}

	public void setCurCategoryIds(String curCategoryIds) {
		_curCategoryIds= curCategoryIds;
	}

	public void setFocus(boolean focus) {
		_focus = focus;
	}

	public void setHiddenInput(String hiddenInput) {
		_hiddenInput = hiddenInput;
	}
	
	public void setHelpMessage(String helpMessage) {
		_helpMessage = helpMessage;
	}
	
	public void setLabelRequired(boolean labelRequired) {
		_labelRequired = labelRequired;
	}

	@Override
	protected void cleanUp() {
		_className = null;
		_classPK = 0;
		_contentCallback = null;
		_curCategoryIds = null;
		_focus = false;
		_hiddenInput = "assetCategoryIds";
		_helpMessage = null;
		_labelRequired = true;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute(
			"liferay-ui:asset-categories-selector:className", _className);
		request.setAttribute(
			"liferay-ui:asset-categories-selector:classPK",
			String.valueOf(_classPK));
		request.setAttribute(
			"liferay-ui:asset-categories-selector:contentCallback",
			String.valueOf(_contentCallback));
		request.setAttribute(
			"liferay-ui:asset-categories-selector:curCategoryIds",
			_curCategoryIds);
		request.setAttribute(
			"liferay-ui:asset-categories-selector:focus",
			String.valueOf(_focus));
		request.setAttribute(
			"liferay-ui:asset-categories-selector:hiddenInput", _hiddenInput);
		request.setAttribute(
				"liferay-ui:asset-categories-selector:helpMessage", _helpMessage);
		request.setAttribute(
				"liferay-ui:asset-categories-selector:labelRequired", _labelRequired);
	}

	private static final String _PAGE =
		"/html/taglib/ui/asset_categories_selector/page.jsp";

	private String _className;
	private long _classPK;
	private String _contentCallback;
	private String _curCategoryIds;
	private boolean _focus;
	private String _hiddenInput = "assetCategoryIds";
	private String _helpMessage;
	private boolean _labelRequired;

}