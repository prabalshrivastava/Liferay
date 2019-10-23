package com.sambaash.platform.srv.spservices.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.srv.spservices.model.SPListType;

public class SPListTypeLocalUtil {

	public static final String CACHE_NAME = SPListTypeLocalUtil.class.getName();

	protected static void clearPreferencesPool() {
		_portalCache.removeAll();
	}

	protected static void clearSPListTypePool(long groupId,
			java.lang.String name) {
		String key = _encodeKey(groupId, name);

		_portalCache.remove(key);
	}

	protected static Map<String, List<SPListType>> getSPListTypePool(
			long groupId, java.lang.String name) {
		String key = _encodeKey(groupId, name);

		Map<String, List<SPListType>> spListTypePool = (Map<String, List<SPListType>>) _portalCache
				.get(key);

		if (spListTypePool == null) {
			spListTypePool = new ConcurrentHashMap<String, List<SPListType>>();

			_portalCache.put(key, spListTypePool);
		}

		return spListTypePool;
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
