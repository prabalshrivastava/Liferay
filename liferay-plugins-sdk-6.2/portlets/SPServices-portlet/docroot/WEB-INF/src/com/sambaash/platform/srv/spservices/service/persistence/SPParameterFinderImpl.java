package com.sambaash.platform.srv.spservices.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.model.impl.SPParameterImpl;

public class SPParameterFinderImpl extends BasePersistenceImpl<SPParameter>
		implements SPParameterFinder {

	public static String FIND_BY_NAME_PREFIX = SPParameterFinder.class
			.getName() + ".findByNamePrefix";

	public List<SPParameter> findByNamePrefix(String prefix, int start, int end)
			throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_NAME_PREFIX);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("SPParameter", SPParameterImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(prefix);

			return (List<SPParameter>) QueryUtil.list(q, getDialect(), start,
					end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

}
