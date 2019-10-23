package com.sambaash.platform.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Theme;
import com.liferay.portal.service.ThemeLocalServiceUtil;

public class ScssUtil {

	private static Log _log = LogFactoryUtil.getLog(ScssUtil.class);

	public static void updateScssVariables(long companyId, String themeId, UnicodeProperties typeSettingsProperties) {
		try {
			Theme theme;

			theme = ThemeLocalServiceUtil.getTheme(companyId, themeId, false);

			String path = PropsUtil.get(PropsKeys.AUTO_DEPLOY_TOMCAT_DEST_DIR) + StringPool.FORWARD_SLASH
					+ theme.getServletContextName() + theme.getCssPath() + "/sp/_sp_variables.scss";

			_log.debug("Path1 : " + PropsUtil.get(PropsKeys.DEFAULT_LIFERAY_HOME) + StringPool.FORWARD_SLASH
					+ theme.getServletContextName() + theme.getCssPath() + "/sp/_sp_variables.scss");

			_log.debug("Path2 : " + PropsUtil.get(PropsKeys.AUTO_DEPLOY_DEFAULT_DEST_DIR) + StringPool.FORWARD_SLASH
					+ theme.getServletContextName() + theme.getCssPath() + "/sp/_sp_variables.scss");

			_log.debug("Path3 : " + PropsUtil.get(PropsKeys.AUTO_DEPLOY_TOMCAT_DEST_DIR) + StringPool.FORWARD_SLASH
					+ theme.getServletContextName() + theme.getCssPath() + "/sp/_sp_variables.scss");

			SPProperties properties = new SPProperties();
			properties.load(new FileInputStream(path));

			Enumeration<Object> em = properties.keys();
			StringBuffer sb = new StringBuffer();
			while (em.hasMoreElements()) {
				String key = (String) em.nextElement();

				String dbKey = (key.indexOf(StringPool.DOLLAR) != -1) ? "lfr-theme:regular:"
						+ key.substring(key.indexOf(StringPool.DOLLAR) + 1) : ("lfr-theme:regular:" + key);

				String newValue = typeSettingsProperties.get(dbKey);
				String curValue = properties.getProperty(key);
				_log.debug(key + " : curValue : " + curValue + " : newValue : " + newValue + StringPool.SEMICOLON);
				if (Validator.isNotNull(newValue)) {
					sb.append(key).append(StringPool.TAB).append(StringPool.COLON).append(newValue)
							.append(StringPool.SEMICOLON).append(StringPool.NEW_LINE);
				}

			}

			FileWriter fw = new FileWriter(path);
			fw.write(sb.toString());
			fw.close();

			try {
				String[] cmd = { "sh", "themedeploy.sh", "/usr/portalv62/" };
				Runtime.getRuntime().exec(cmd);
			} catch (Exception e) {
				_log.error("Exception is:" + e);
			}

			// properties.store(writer, null, StringPool.COLON);

		} catch (SystemException e) {
			_log.error(e);
		} catch (FileNotFoundException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
		}

	}

}
