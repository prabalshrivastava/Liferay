package com.sambaash.platform.srv.processbuilder.service.persistence;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateImpl;

public class PEProcessStateFinderImpl extends BasePersistenceImpl  implements
PEProcessStateFinder {

	public static String getOfflineFinancereport = PEProcessStateFinder.class
	.getName() + ".getOfflineFinancereport";
	
	public static String getOnlineFinancereport = PEProcessStateFinder.class
			.getName() + ".getOnlineFinancereport";

	public List<Object> getOfflineFinancereport(Date startDate,Date endDate,Date startDate1,Date endDate1,Date startDate2,Date endDate2) throws SystemException {

		Session session = null;
		
		try {
			session = openSession();
		
			String sql = CustomSQLUtil.get(getOfflineFinancereport);
		
			SQLQuery q = session.createSQLQuery(sql);
		
			//q.addEntity("SPPEProcessState", PEProcessStateImpl.class);
		
			QueryPos qPos = QueryPos.getInstance(q);
		
			qPos.add(startDate);
			qPos.add(endDate);
			qPos.add(startDate1);
			qPos.add(endDate1);
			qPos.add(startDate2);
			qPos.add(endDate2);
		
			return (List<Object>) QueryUtil.list(q, getDialect(), -1,
					-1);
		
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<Object> getOnlineFinancereport(Date startDate,Date endDate,Date startDate1,Date endDate1,Date startDate2,Date endDate2) throws SystemException {
		
		Session session = null;
		
		try {
			session = openSession();
		
			String sql = CustomSQLUtil.get(getOnlineFinancereport);
		
			SQLQuery q = session.createSQLQuery(sql);
		
			//q.addEntity("SPPEProcessState", PEProcessStateImpl.class);
		
			QueryPos qPos = QueryPos.getInstance(q);
		
			qPos.add(startDate);
			qPos.add(endDate);
			qPos.add(startDate1);
			qPos.add(endDate1);
			qPos.add(startDate2);
			qPos.add(endDate2);
		
			return (List<Object>) QueryUtil.list(q, getDialect(), -1,
					-1);
		
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	@Override
	public List<Object> getOfflineFinancereport(Date arg0, Date arg1) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getOnlineFinancereport(Date arg0, Date arg1) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}
}
