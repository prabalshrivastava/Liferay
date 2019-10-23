package com.sambaash.platform.srv.spasset.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;

public class SPAssetEntryFinderImpl extends BasePersistenceImpl<SPAssetEntry> implements SPAssetEntryFinder {

	public static String FIND_SPASSET_FILE_ENTRIES_FOR_GUEST = SPAssetEntryFinder.class.getName() + ".findSPAssetFileEntriesForGuest";

	public static String FIND_SPASSET_FILE_ENTRIES = SPAssetEntryFinder.class.getName() + ".findSPAssetFileEntries";

	public java.util.List<DLFileEntry> findSPAssetFileEntriesForGuest(long groupId, long spAssetTypeId, int start, int end)
			throws com.liferay.portal.kernel.exception.SystemException {
		
		// fetch liferay's session factory
		SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
		Session session = null;

		try {
		    // open session using liferay's session factory
		    session = sessionFactory.openSession();

			String sql = CustomSQLUtil.get(FIND_SPASSET_FILE_ENTRIES_FOR_GUEST);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("DLFileEntry", PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portlet.documentlibrary.model.impl.DLFileEntryImpl"));

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);
			qPos.add(spAssetTypeId);
			qPos.add(0);

			return (List<DLFileEntry>)QueryUtil.list(q, getDialect(), start, end);

		}catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	public java.util.List<DLFileEntry> findSPAssetFileEntries(long groupId, long spAssetTypeId, long signedinUserId, int start, int end)
			throws com.liferay.portal.kernel.exception.SystemException {
		
		// fetch liferay's session factory
		SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
		Session session = null;

		try {
		    // open session using liferay's session factory
		    session = sessionFactory.openSession();

			String sql = CustomSQLUtil.get(FIND_SPASSET_FILE_ENTRIES);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("DLFileEntry", PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portlet.documentlibrary.model.impl.DLFileEntryImpl"));

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);
			qPos.add(spAssetTypeId);
			qPos.add(0);
			qPos.add(1);
			qPos.add(groupId);
			qPos.add(spAssetTypeId);
			qPos.add(2);
			qPos.add(signedinUserId);

			return (List<DLFileEntry>)QueryUtil.list(q, getDialect(), start, end);

		}catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}
