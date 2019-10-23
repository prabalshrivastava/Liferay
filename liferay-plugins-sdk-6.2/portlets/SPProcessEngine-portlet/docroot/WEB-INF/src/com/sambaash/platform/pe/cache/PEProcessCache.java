package com.sambaash.platform.pe.cache;

import java.io.Serializable;

import javax.xml.bind.JAXBException;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.pe.exception.PEConfigException;

final public class PEProcessCache {

	private static final Log _log = LogFactoryUtil.getLog(PEProcessCache.class);
	private static PEProcessCache pdsCache = new PEProcessCache();

	public static PEProcessCache getInstance() {
		return pdsCache;
	}

	public void clearCache() {
		_portalCache.removeAll();
	}

	public void reload(long pdId) throws JAXBException, PEConfigException {
		_log.debug("Loading process directory for ProcessId =" + pdId);
		_portalCache.remove(pdId);
		PEProcessDirectory pd = PEProcessDirectory.loadPD(pdId);
		_portalCache.put(pdId, pd);
	}

	public PEProcessDirectory getProcessDirectory(long pdId) throws JAXBException, PEConfigException {
		// TODO:remove below reload method. since iam changing db directly, here
		// iam trying to load process everytime
		// reload(pdId);
		PEProcessDirectory pd = (PEProcessDirectory) _portalCache.get(pdId);
		if (pd == null) {
			synchronized (_portalCache) {
				pd = (PEProcessDirectory) _portalCache.get(pdId);
				if(pd == null){
					_log.debug("Process directory does not exist for ProcessId =" + pdId + " So it has to load from db.");
					reload(pdId);
				}
			}
			pd = (PEProcessDirectory) _portalCache.get(pdId);
		}
		return pd;
	}

	private static final String _CACHE_NAME = PEProcessCache.class.getName();
	private static PortalCache<Long, Serializable> _portalCache = MultiVMPoolUtil.getCache(_CACHE_NAME);
}
