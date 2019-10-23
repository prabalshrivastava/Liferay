package com.sambaash.platform.portlet.spneo4j.util;

import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.service.ClassNameLocalServiceUtil;

public class ClassUtil {
	private static Map<String, Long> CLASS_ID_MAP = new HashMap<String, Long>();

	private ClassUtil() {
		// not meant for instantiation
	}

	public static final long getClassId(String className) {
		Long classId = CLASS_ID_MAP.get(className);
		if (classId == null) {
			classId = ClassNameLocalServiceUtil.getClassNameId(className);
			CLASS_ID_MAP.put(className, classId);
		}
		return classId;
	}
}
