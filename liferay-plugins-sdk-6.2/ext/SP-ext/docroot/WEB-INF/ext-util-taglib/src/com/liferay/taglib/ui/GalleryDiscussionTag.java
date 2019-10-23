package com.liferay.taglib.ui;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Charles May
 */
public class GalleryDiscussionTag extends IncludeTag {

	public void setClassName(String className) {
		_className = className;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public void setFormAction(String formAction) {
		_formAction = formAction;
	}

	public void setFormName(String formName) {
		_formName = formName;
	}

	public void setHideControls(boolean hideControls) {
		_hideControls = hideControls;
	}

	public void setPermissionClassName(String permissionClassName) {
		_permissionClassName = permissionClassName;
	}

	public void setPermissionClassPK(long permissionClassPK) {
		_permissionClassPK = permissionClassPK;
	}

	public void setRatingsEnabled(boolean ratingsEnabled) {
		_ratingsEnabled = ratingsEnabled;
	}

	public void setRedirect(String redirect) {
		_redirect = redirect;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUrlTitle() {
		return _urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		this._urlTitle = urlTitle;
	}

	@Override
	protected void cleanUp() {
		_className = null;
		_classPK = 0;
		_formAction = null;
		_formName = "fm";
		_hideControls = false;
		_permissionClassName = null;
		_permissionClassPK = 0;
		_ratingsEnabled = true;
		_redirect = null;
		_subject = null;
		_userId = 0;
		_urlTitle = null;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest request) {
		String permissionClassName = _permissionClassName;

		if (Validator.isNull(permissionClassName)) {
			permissionClassName = _className;
		}

		long permissionClassPK = _permissionClassPK;

		if (permissionClassPK == 0) {
			permissionClassPK = _classPK;
		}

		request.setAttribute("liferay-ui:discussion:className", _className);
		request.setAttribute(
			"liferay-ui:discussion:classPK", String.valueOf(_classPK));
		request.setAttribute("liferay-ui:discussion:formAction", _formAction);
		request.setAttribute("liferay-ui:discussion:formName", _formName);
		request.setAttribute(
			"liferay-ui:discussion:hideControls",
			String.valueOf(_hideControls));
		request.setAttribute(
			"liferay-ui:discussion:permissionClassName", permissionClassName);
		request.setAttribute(
			"liferay-ui:discussion:permissionClassPK",
			String.valueOf(permissionClassPK));
		request.setAttribute(
			"liferay-ui:discussion:ratingsEnabled",
			String.valueOf(_ratingsEnabled));
		request.setAttribute("liferay-ui:discussion:redirect", _redirect);
		request.setAttribute("liferay-ui:discussion:subject", _subject);
		request.setAttribute(
			"liferay-ui:discussion:userId", String.valueOf(_userId));
		request.setAttribute("liferay-ui:discussion:urlTitle", _urlTitle);
	}

	private static final String _PAGE = "/html/taglib/ui/discussion/gallery_page.jsp";

	private String _className;
	private long _classPK;
	private String _formAction;
	private String _formName = "fm";
	private boolean _hideControls;
	private String _permissionClassName;
	private long _permissionClassPK;
	private boolean _ratingsEnabled = true;
	private String _redirect;
	private String _subject;
	private long _userId;
	private String _urlTitle;

}