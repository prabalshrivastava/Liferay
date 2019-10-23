package com.sambaash.platform.srv.spservices.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.srv.spservices.model.SPParameter;

public class SPParameterLocalUtil {

	public static final String CACHE_NAME = SPParameterLocalUtil.class
			.getName();

	public static void clearPreferencesPool() {
		_portalCache.removeAll();
	}

	public static void clearSPParameterPool(long groupId, java.lang.String name) {
		String key = _encodeKey(groupId, name);

		_portalCache.remove(key);
	}

	public static Map<String, SPParameter> getSPParameterPool(long groupId,
			java.lang.String name) {
		String key = _encodeKey(groupId, name);

		Map<String, SPParameter> spParameterPool = (Map<String, SPParameter>) _portalCache
				.get(key);

		if (spParameterPool == null) {
			spParameterPool = new ConcurrentHashMap<String, SPParameter>();

			_portalCache.put(key, spParameterPool);
		}

		return spParameterPool;
	}

	public static Map<String, SPParameter> getSPParameterPool(String key) {
		Map<String, SPParameter> spParameterPool = (Map<String, SPParameter>) _portalCache.get(key);
		if (spParameterPool == null) {
			spParameterPool = new ConcurrentHashMap<String, SPParameter>();
			_portalCache.put(key, spParameterPool);
		}
		return spParameterPool;
	}

	private static String _encodeKey(long groupId, java.lang.String name) {
		StringBundler sb = new StringBundler(5);

		sb.append(CACHE_NAME);
		sb.append(StringPool.POUND);
		sb.append(groupId);
		sb.append(StringPool.POUND);
		sb.append(name);

		return sb.toString();
	}

	private static PortalCache _portalCache = MultiVMPoolUtil
			.getCache(CACHE_NAME);

}
