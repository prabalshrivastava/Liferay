package com.sambaash.platform.util;

import java.util.List;

import com.liferay.portal.kernel.bean.BeanLocatorException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
public class SitemapUtil {

	private static Log _log = LogFactoryUtil.getLog(SitemapUtil.class);

	public static String getSitemap(
			long groupId, boolean privateLayout, ThemeDisplay themeDisplay)
		throws PortalException, SystemException {

		Document doc = SAXReaderUtil.createDocument();

		doc.setXMLEncoding(StringPool.UTF8);

		Element root = doc.addElement(
			"urlset", "http://www.google.com/schemas/sitemap/0.84");

		List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(
			groupId, privateLayout, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);

		_visitLayouts(root, layouts, themeDisplay);

		return doc.asXML();
	}

	public static String encodeXML(String input) {
		return StringUtil.replace(
			input,
			new String[] {"&", "<", ">", "'", "\""},
			new String[] {"&amp;", "&lt;", "&gt;", "&apos;", "&quot;"});
	}

	private static void _visitLayouts(
			Element element, List<Layout> layouts, ThemeDisplay themeDisplay)
		throws PortalException, SystemException {

		boolean isAdmin = false;
		boolean isContentEditor = false;
		boolean isCorpUsr = false;
		boolean isIndividualUser = true;
		long userId = themeDisplay.getUserId();
		long scopeGroupId = themeDisplay.getScopeGroupId();

		String FOR_GUEST_ONLY = SambaashConstants.PAGE.FOR_GUEST_ONLY;
		String FOR_ADMIN_ONLY = SambaashConstants.PAGE.FOR_ADMIN_ONLY;
		String FOR_CONTENT_EDITOR_ONLY = SambaashConstants.PAGE.FOR_CONTENT_EDITOR_ONLY;
		String FOR_CORP_USER_ONLY = SambaashConstants.PAGE.FOR_CORP_USER_ONLY;
		String FOR_INDIVIDUAL_USER_ONLY = SambaashConstants.PAGE.FOR_INDIVIDUAL_USER_ONLY;
		String FOR_SIGN_IN_USER_ONLY = SambaashConstants.PAGE.FOR_SIGNEDIN_USER_ONLY;

		isAdmin = SambaashUtil.isAdmin(scopeGroupId, userId);
		isContentEditor = SambaashUtil.isContentEditor(scopeGroupId, userId);

		try {
			isIndividualUser = SocialProfileLocalServiceUtil.isIndividualUser(themeDisplay.getUserId(), themeDisplay.getCompanyId());
			if (!isIndividualUser) {
				isCorpUsr = true;
			}
		} catch(BeanLocatorException ble) {
			_log.error(" Services not yet initialized. ");
		}

		for (Layout layout : layouts) {
			UnicodeProperties props = layout.getTypeSettingsProperties();
			boolean isForGuestOnly = false;
			boolean isForAdminOnly = false;
			boolean isForContentEditorOnly = false;
			boolean isForCorpUserOnly = false;
			boolean isForIndividualUserOnly = false;
			boolean isOnlyForSignIn = false;

			ExpandoBridge eb = layout.getExpandoBridge();
			if (eb!=null) {
				isForGuestOnly = getExpandoValue(eb, FOR_GUEST_ONLY, themeDisplay);
				isForAdminOnly = getExpandoValue(eb, FOR_ADMIN_ONLY, themeDisplay);
				isForContentEditorOnly = getExpandoValue(eb, FOR_CONTENT_EDITOR_ONLY, themeDisplay);
				isForCorpUserOnly = getExpandoValue(eb, FOR_CORP_USER_ONLY, themeDisplay);
				isForIndividualUserOnly = getExpandoValue(eb, FOR_INDIVIDUAL_USER_ONLY, themeDisplay);
				isOnlyForSignIn = getExpandoValue(eb, FOR_SIGN_IN_USER_ONLY, themeDisplay);
			}

			if (isForGuestOnly && themeDisplay.isSignedIn()) {
				continue;
			}

			if (isForAdminOnly && !isAdmin) {
				continue;
			}

			if (isForIndividualUserOnly && !isIndividualUser) {
				continue;
			}

			if (isForContentEditorOnly && !isContentEditor) {
				continue;
			}

			if (isForCorpUserOnly && !isCorpUsr) {
				continue;
			}

			if (isOnlyForSignIn && !themeDisplay.isSignedIn()) {
				continue;
			}

			if (!layout.isHidden() &&
				GetterUtil.getBoolean(
					props.getProperty("sitemap-include"), true)) {

				if(PortalUtil.isLayoutSitemapable(layout)) {

					Element url = element.addElement("url");

					String layoutFullURL = PortalUtil.getLayoutFullURL(
						layout, themeDisplay);

					url.addElement("loc").addText(encodeXML(layoutFullURL));

					String changefreq = props.getProperty("sitemap-changefreq");

					if (Validator.isNotNull(changefreq)) {
						url.addElement("changefreq").addText(changefreq);
					}

					String priority = props.getProperty("sitemap-priority");

					if (Validator.isNotNull(priority)) {
						url.addElement("priority").addText(priority);
					}

				}
				
				/**
				 * Even though parent is not layout sitemapable, still check children
				 * By Clark
				 */
				List<Layout> children = layout.getChildren();
				_visitLayouts(element, children, themeDisplay);
			}
		}
	}

	private static boolean getExpandoValue(ExpandoBridge eb, String name, ThemeDisplay themeDisplay) throws SystemException{
		boolean eValue = false;
		long companyId = themeDisplay.getCompanyId();
		if (eb!=null) {
			ExpandoColumn ec = ExpandoColumnLocalServiceUtil.getColumn(companyId, Layout.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, name);
			if (ec!=null) {
				ExpandoValue ev = ExpandoValueLocalServiceUtil.getValue(ec.getTableId(), ec.getColumnId(), eb.getClassPK());
				if (ev!=null) {
					String data = ev.getData();
					if (Validator.isNotNull(data)) {
						eValue = Boolean.valueOf(data);
					}
				}
			}
		}
		return eValue;
	}

}