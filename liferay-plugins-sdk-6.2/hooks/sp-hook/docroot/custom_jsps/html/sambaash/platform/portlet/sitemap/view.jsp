
<%@ include file="/html/portlet/site_map/init.jsp" %>
<%-- added import (A) - vincent 09 nov 2011 --%>
<%@ page import="sambaash.platform.srv.corporate.service.CorporateProfileLocalService" %>
<%@ page import="sambaash.platform.srv.corporate.service.CorporateProfileLocalServiceUtil" %>
<%@ page import="sambaash.platform.srv.corporate.service.CorporateProfileUserLocalService" %>
<%@ page import="sambaash.platform.srv.corporate.service.CorporateProfileUserLocalServiceUtil" %>
<%@ page import="sambaash.platform.srv.membershippackage.service.MembershipPackageLocalService" %>
<%@ page import="sambaash.platform.srv.membershippackage.service.MembershipPackageLocalServiceUtil" %>
<%@ page import="sambaash.platform.srv.spparameter.model.SPParameters" %>
<%@ page import="sambaash.platform.srv.spparameter.service.SPParametersLocalService" %>
<%@ page import="sambaash.platform.srv.spparameter.service.SPParametersLocalServiceUtil" %>
<%@ page import="sambaash.platform.srv.socialprofile.model.SocialProfile" %>
<%@ page import="sambaash.platform.srv.socialprofile.service.SocialProfileLocalServiceUtil" %>
<%@ page import="sambaash.platform.util.SambaashConstants" %>
<%@ page import="sambaash.platform.util.SambaashUtil" %>

<%@ page import="com.liferay.portlet.expando.model.ExpandoBridge" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoColumn" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoTableConstants" %>
<%@ page import="com.liferay.portlet.expando.model.ExpandoValue" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoColumnLocalService" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoRowLocalService" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoTableLocalService" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoValueLocalService" %>
<%@ page import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.bean.BeanLocatorException" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%-- (/A) --%>
<%
List<Layout> rootLayouts = LayoutLocalServiceUtil.getLayouts(layout.getGroupId(), layout.isPrivateLayout(), rootLayoutId);

StringBundler sb = new StringBundler();

_buildSiteMap(layout, rootLayouts, rootLayout, includeRootInTree, displayDepth, showCurrentPage, useHtmlTitle, showHiddenPages, 1, themeDisplay, sb);
%>

<%= sb.toString() %>

<%!
/* added method (B) - vincent 09 nov 2011*/
private boolean getExpandoValue(ExpandoBridge eb, String name, ThemeDisplay themeDisplay) throws SystemException{
	boolean eValue = false;
	long companyId = themeDisplay.getCompanyId();
	if(eb!=null){
		ExpandoColumn ec = ExpandoColumnLocalServiceUtil.getColumn(companyId, Layout.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, name);
		if(ec!=null){
			ExpandoValue ev = ExpandoValueLocalServiceUtil.getValue(ec.getTableId(), ec.getColumnId(), eb.getClassPK());
			if(ev!=null){
				String data = ev.getData();
				if(Validator.isNotNull(data)){
					eValue = Boolean.valueOf(data);
				}
			}
		}
	}
	return eValue;
}
/* (/B) */
private void _buildLayoutView(Layout layout, String cssClass, boolean useHtmlTitle, ThemeDisplay themeDisplay, StringBundler sb) throws Exception {
	String layoutURL = PortalUtil.getLayoutURL(layout, themeDisplay);
	String target = PortalUtil.getLayoutTarget(layout);

	sb.append("<a href=\"");
	sb.append(layoutURL);
	sb.append("\" ");
	sb.append(target);

	if (Validator.isNotNull(cssClass)) {
		sb.append(" class=\"");
		sb.append(cssClass);
		sb.append("\" ");
	}

	sb.append("> ");

	String layoutName = layout.getName(themeDisplay.getLocale());

	if (useHtmlTitle) {
		layoutName = layout.getHTMLTitle(themeDisplay.getLocale());
	}

	sb.append(layoutName);
	sb.append("</a>");
}

private void _buildSiteMap(Layout layout, List<Layout> layouts, Layout rootLayout, boolean includeRootInTree, int displayDepth, boolean showCurrentPage, boolean useHtmlTitle, boolean showHiddenPages, int curDepth, ThemeDisplay themeDisplay, StringBundler sb) throws Exception {
	if (layouts.isEmpty()) {
		return;
	}

	/* added this section (C) - vincent 09 nov 2011 */
	boolean isAdmin = false;
	boolean isContentEditor = false;
	boolean isCorpUsr = false;
	boolean isIndividualUser = true;
	long userId = themeDisplay.getUserId();
	long scopeGroupId = themeDisplay.getScopeGroupId();

	String TOPPER = "Topper";
	String HEADER = SambaashConstants.PAGE.HEADER;
	String FOOTER_LEFT = SambaashConstants.PAGE.FOOTER_LEFT;
	String FOOTER_RIGHT = SambaashConstants.PAGE.FOOTER_RIGHT;
	String POPUP = SambaashConstants.PAGE.POPUP;
	String FOR_GUEST_ONLY = SambaashConstants.PAGE.FOR_GUEST_ONLY;
	String FOR_ADMIN_ONLY = SambaashConstants.PAGE.FOR_ADMIN_ONLY;
	String FOR_CONTENT_EDITOR_ONLY = SambaashConstants.PAGE.FOR_CONTENT_EDITOR_ONLY;
	String FOR_CORP_USER_ONLY = SambaashConstants.PAGE.FOR_CORP_USER_ONLY;
	String FOR_INDIVIDUAL_USER_ONLY = SambaashConstants.PAGE.FOR_INDIVIDUAL_USER_ONLY;
	String FOR_SIGN_IN_USER_ONLY = SambaashConstants.PAGE.FOR_SIGNEDIN_USER_ONLY;

	isAdmin = SambaashUtil.isAdmin(scopeGroupId, userId);
	isContentEditor = SambaashUtil.isContentEditor(scopeGroupId, userId);

	try {
		//isIndividualUser = UserProfileBasicLocalServiceUtil.isIndividualUser(themeDisplay.getUserId(), themeDisplay.getCompanyId());
		isIndividualUser = SocialProfileLocalServiceUtil.isIndividualUser(themeDisplay.getUserId(), themeDisplay.getCompanyId());
		if(!isIndividualUser){
			isCorpUsr = true;
		}
	} catch(BeanLocatorException ble){
		_log.error(" Services not yet initialized. ");
	}
/* (/C) */
	PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
	boolean showRoot = (rootLayout != null) && (curDepth == 1) && includeRootInTree;

	sb.append("<ul>");

	if (showRoot) {
		String cssClass = "root";

		sb.append("<li>");

		if (rootLayout.getPlid() == layout.getPlid()) {
			cssClass += " current";
		}

		_buildLayoutView(rootLayout, cssClass, useHtmlTitle, themeDisplay, sb);

		sb.append("</li>");
	}

	for (int i = 0; i < layouts.size(); i++) {
		/* added variables (D) - vincent 09 nov 2011 */
		boolean isTopper = false;
		boolean isHeader = false;
		boolean isFooterLeft = false;
		boolean isFooterRight = false;
		boolean isPopup = false;
		boolean isForGuestOnly = false;
		boolean isForAdminOnly = false;
		boolean isForContentEditorOnly = false;
		boolean isForCorpUserOnly = false;
		boolean isForIndividualUserOnly = false;
		boolean isOnlyForSignIn = false;
		/* (/D) */
		Layout curLayout = layouts.get(i);

		/* added this section (E) - vincent 09 nov 2011 */
		ExpandoBridge eb = curLayout.getExpandoBridge();
		if(eb!=null){
			isTopper = getExpandoValue(eb, TOPPER, themeDisplay);
			isHeader = getExpandoValue(eb, HEADER, themeDisplay);
			isFooterLeft = getExpandoValue(eb, FOOTER_LEFT, themeDisplay);
			isFooterRight = getExpandoValue(eb, FOOTER_RIGHT, themeDisplay);
			isPopup = getExpandoValue(eb, POPUP, themeDisplay);
			isForGuestOnly = getExpandoValue(eb, FOR_GUEST_ONLY, themeDisplay);
			isForAdminOnly = getExpandoValue(eb, FOR_ADMIN_ONLY, themeDisplay);
			isForContentEditorOnly = getExpandoValue(eb, FOR_CONTENT_EDITOR_ONLY, themeDisplay);
			isForCorpUserOnly = getExpandoValue(eb, FOR_CORP_USER_ONLY, themeDisplay);
			isForIndividualUserOnly = getExpandoValue(eb, FOR_INDIVIDUAL_USER_ONLY, themeDisplay);
			isOnlyForSignIn = getExpandoValue(eb, FOR_SIGN_IN_USER_ONLY, themeDisplay);
		}

		if(isForGuestOnly && themeDisplay.isSignedIn()){
			continue;
		}

		if(isForAdminOnly && !isAdmin){
			continue;
		}

		if(isForIndividualUserOnly && !isIndividualUser){
			continue;
		}


		if(isForContentEditorOnly && !isContentEditor){
			continue;
		}

		if(isForCorpUserOnly && !isCorpUsr){
			continue;
		}

		if(isOnlyForSignIn && !themeDisplay.isSignedIn()){
			continue;
		}
		/* (/E) */
		if ((showHiddenPages || !curLayout.isHidden()) && LayoutPermissionUtil.contains(permissionChecker, curLayout, ActionKeys.VIEW)) {
			String cssClass = StringPool.BLANK;

			if (curLayout.getPlid() == layout.getPlid()) {
				cssClass = "current";
			}

			sb.append("<li>");

			_buildLayoutView(curLayout, cssClass, useHtmlTitle, themeDisplay, sb);

			if ((displayDepth == 0) || (displayDepth > curDepth)) {
				_buildSiteMap(layout, curLayout.getChildren(), rootLayout, includeRootInTree, displayDepth, showCurrentPage, useHtmlTitle, showHiddenPages, curDepth + 1, themeDisplay, sb);
			}

			sb.append("</li>");
		}
	}

	sb.append("</ul>");
}
%>
<%-- add log (F) - vincent 09 nov 2011 --%>
<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.site_map.view.jsp");
%>
<%-- (/F) --%>