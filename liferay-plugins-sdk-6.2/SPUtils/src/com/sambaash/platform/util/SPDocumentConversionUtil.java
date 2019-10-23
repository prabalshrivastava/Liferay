package com.sambaash.platform.util;

import java.io.File;
import java.io.InputStream;

import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;

/**
 * @author Bruno Farache
 */
public class SPDocumentConversionUtil {

	public static File convert(String id, InputStream inputStream, String sourceExtension, String targetExtension)
			throws Exception {

		Object returnObj = PortalClassInvoker.invoke(false, _convertMethodKey, id, inputStream, sourceExtension,
				targetExtension);

		if (returnObj != null) {
			return (File) returnObj;
		} else {
			return null;
		}
	}

	public static String[] getConversions(String extension) throws Exception {
		Object returnObj = PortalClassInvoker.invoke(false, _getConversionsMethodKey, extension);

		if (returnObj != null) {
			return (String[]) returnObj;
		} else {
			return null;
		}
	}

	private static final String _CLASS_NAME = "com.liferay.portlet.documentlibrary.util.DocumentConversionUtil";

	private static MethodKey _convertMethodKey = new MethodKey(_CLASS_NAME, "convert", String.class, InputStream.class,
			String.class, String.class);
	private static MethodKey _getConversionsMethodKey = new MethodKey(_CLASS_NAME, "getConversions", String.class);

}