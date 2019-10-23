package com.sambaash.platform.portlet.spms.util;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
public class PaymentUtil {

	public static final String CACHE_NAME = PaymentUtil.class.getName();

	public static PortalCache _cache = MultiVMPoolUtil.getCache(CACHE_NAME);

}