package com.sambaash.platform.portlet.socialplugin.util;

import java.util.ResourceBundle;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SocialSharingUtil {

	public static final int NOTSHARED = 0;

	public static final int PENDING = 2;

	public static final int SHARED = 1;

	public static final String DEFAULT = "default";

	public static String getImageUrlFromHtml(String content) throws ParserException {
		String imageSrc = "";

		Parser parser = Parser.createParser(content, StringPool.UTF8);
		TagNameFilter filter = new TagNameFilter("img");
		NodeList nodeList3 = parser.parse(filter);
		Node node = null;

		if (nodeList3.size() > 0) {
			node = nodeList3.elementAt(0);
			imageSrc = ((ImageTag) node).getAttribute("src");
		}

		return imageSrc;
	}

	public static String getMessageResourceBundle(final String key, long scopeGroupId) {
		ResourceBundle res = ResourceBundle.getBundle("message");
		String communityName = SambaashUtil.getCommunityName(scopeGroupId);
		String result = StringPool.BLANK;
		if (Validator.isNull(key)) {
			return result;
		}

		try {
			result = res.getString(communityName + StringPool.PERIOD + key);
		} catch (Exception e) {
			result = res.getString(DEFAULT + StringPool.PERIOD + key);
		}

		return result;
	}

	public static void updateSPParameter(String key, String value, long groupId) {

		try {
			SPParameter parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId, key);

			if (Validator.isNotNull(value)) {
				parameter.setValue(value);
			}

			SPParameterLocalServiceUtil.updateSPParameter(parameter);
			SPParameterLocalServiceUtil.clearSPParameterPool(groupId, key);

		} catch (NoSuchSPParameterException e) {
			_log.error("No such spparameter exist with key: " + key + " groupId: " + groupId);
		} catch (Exception e) {
			_log.error("Exception getting SPParameter ==" + e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SocialSharingUtil.class);

}