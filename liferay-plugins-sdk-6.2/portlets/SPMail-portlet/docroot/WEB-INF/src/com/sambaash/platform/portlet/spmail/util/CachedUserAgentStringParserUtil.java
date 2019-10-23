package com.sambaash.platform.portlet.spmail.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
public final class CachedUserAgentStringParserUtil implements UserAgentStringParser {

	private final UserAgentStringParser parser = UADetectorServiceFactory.getCachingAndUpdatingParser();
	private final Cache<String, ReadableUserAgent> cache = CacheBuilder.newBuilder().maximumSize(100)
			.expireAfterWrite(2, TimeUnit.HOURS).build();

	public String getDataVersion() {
		return parser.getDataVersion();
	}

	public ReadableUserAgent parse(final String userAgentString) {
		ReadableUserAgent result = cache.getIfPresent(userAgentString);
		if (result == null) {
			result = parser.parse(userAgentString);
			cache.put(userAgentString, result);
		}
		return result;
	}

	public void shutdown() {
		parser.shutdown();
	}

}
