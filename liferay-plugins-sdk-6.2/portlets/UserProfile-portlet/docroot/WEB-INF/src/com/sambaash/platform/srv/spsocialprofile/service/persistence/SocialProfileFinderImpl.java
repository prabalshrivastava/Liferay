package com.sambaash.platform.srv.spsocialprofile.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileImpl;

public class SocialProfileFinderImpl extends BasePersistenceImpl implements
		SocialProfileFinder {
	public static String FIND_BY_U1_S1_S_E = SocialProfileFinder.class
			.getName() + ".findByU1_S1_S_E";
	public static String FIND_ALL_LOCATION = SocialProfileFinder.class
			.getName() + ".findSocialProfileLocation";

	public List<SocialProfile> findByU1_S1_S_E(String userRegistrationStatus,
			boolean active, int start, int end) throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_U1_S1_S_E);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("SocialProfile", SocialProfileImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(userRegistrationStatus);
			qPos.add(active);

			return (List<SocialProfile>) QueryUtil.list(q, getDialect(), start,
					end);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public String findSocialProfileLocation() throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_ALL_LOCATION);

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("location", Type.STRING);

			Iterator<String> itr = q.list().iterator();

			if (itr.hasNext()) {
				return (String) itr.next();
			}

			return null;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

}