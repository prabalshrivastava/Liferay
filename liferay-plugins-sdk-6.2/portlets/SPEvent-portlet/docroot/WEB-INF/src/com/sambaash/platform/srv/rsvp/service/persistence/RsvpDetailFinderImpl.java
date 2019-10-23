package com.sambaash.platform.srv.rsvp.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;
@SuppressWarnings({ "unchecked", "rawtypes" })
public class RsvpDetailFinderImpl extends BasePersistenceImpl implements RsvpDetailFinder {

	public static String FIND_BY_RSVP_ID = RsvpDetailFinder.class.getName() + ".findByRsvpId";
	public static String FIND_BY_EMAIL_ADDRESS = RsvpDetailFinder.class.getName() + ".findByEmailAddress";

	public static String FIND_BY_NAME = RsvpDetailFinder.class.getName() + ".findByName";

	public List<Object> findByRsvpId(long rsvpId, int start, int end) throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_RSVP_ID);

			SQLQuery q = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rsvpId);

			return (List<Object>)QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List<Object> findByName(long rsvpId, String firstName, String lastName, int start, int end)
			throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_NAME);

			SQLQuery q = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rsvpId);
			qPos.add(firstName);
			qPos.add(lastName);

			return (List<Object>)QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List<Object> findByEmailAddress(long rsvpId, String emailAddress, int start, int end) throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_EMAIL_ADDRESS);

			SQLQuery q = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(rsvpId);
			qPos.add(emailAddress);

			return (List<Object>)QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

}