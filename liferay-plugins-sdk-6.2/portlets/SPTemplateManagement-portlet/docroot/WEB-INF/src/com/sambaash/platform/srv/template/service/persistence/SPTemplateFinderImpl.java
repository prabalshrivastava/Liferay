package com.sambaash.platform.srv.template.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.sambaash.platform.srv.template.model.SPTemplate;
import com.sambaash.platform.srv.template.model.impl.SPComponentTemplateImpl;
import com.sambaash.platform.srv.template.model.impl.SPTemplateImpl;

public class SPTemplateFinderImpl extends BasePersistenceImpl<SPTemplate> implements SPTemplateFinder {

	private Log _log = LogFactoryUtil.getLog(SPTemplateFinderImpl.class.getName());

	public List getAllTemplates(String cur, String delta) {
		Session session = null;
		try {
			session = openSession();
			String sql = "Select t.*,c.*"
					+ " FROM SPTemplate t LEFT join SPComponentTemplate c ON t.spTemplateId = c.spTemplateId where t.status !=0 group by t.spTemplateID "
					+ " LIMIT " + delta + " OFFSET " + ((Integer.valueOf(cur) - 1) * Integer.valueOf(delta)) ;
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);

			queryObject.addEntity("SPTemplate", SPTemplateImpl.class);
			queryObject.addEntity("SPComponentTemplate", SPComponentTemplateImpl.class);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			return (List) queryObject.list();
		} catch (Exception e) {
			_log.error(e.getMessage());
		} finally {
			closeSession(session);
		}
		return null;
	}
	public int getAllTemplatesCount() {
		Session session = null;
		try {
			session = openSession();
			String sql = "Select t.*,c.*"
					+ " FROM SPTemplate t LEFT join SPComponentTemplate c ON t.spTemplateId = c.spTemplateId where t.status !=0 group by t.spTemplateID " ;
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);

			queryObject.addEntity("SPTemplate", SPTemplateImpl.class);
			queryObject.addEntity("SPComponentTemplate", SPComponentTemplateImpl.class);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			return queryObject.list().size();
		} catch (Exception e) {
			_log.error(e.getMessage());
		} finally {
			closeSession(session);
		}
		return 0;
	}

	public List getTemplateDetail(long templateId) {
		Session session = null;
		try {
			session = openSession();
			String sql = "Select t.*,c.*"
					+ " FROM SPTemplate t LEFT join SPComponentTemplate c ON t.spTemplateId = c.spTemplateId WHERE t.spTemplateId = ?";
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);

			queryObject.addEntity("SPTemplate", SPTemplateImpl.class);
			queryObject.addEntity("SPComponentTemplate", SPComponentTemplateImpl.class);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(templateId);
			return (List) queryObject.list();
		} catch (Exception e) {
			_log.info(e.toString());
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<Object> getTemplateDetail(String templateName) {
		Session session = null;
		try {
			session = openSession();
			String sql = "Select t.templateName,t.spTemplateId,c.spComponentTemplateId,c.level0FormId,c.level1FormId,c.level2FormId,c.level3FormId"
					+ " FROM SPTemplate t LEFT join SPComponentTemplate c ON t.spTemplateId = c.spTemplateId WHERE t.templateName = ?";
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);

			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(templateName);

			List<Object> objectList = (List<Object>) queryObject.list();
			Object[] objectArray;
			String productName;
			for (Object object : objectList) {
				objectArray = (Object[]) object;

				for (int i = 0; i < objectArray.length; i++) {
					productName = objectArray[i].toString();
				}
			}
			return objectList;
		} catch (Exception e) {
			_log.info(e.toString());
		} finally {
			closeSession(session);
		}
		return null;
	}

	public boolean deleteTemplateComponents(long templateId) {
		Session session = null;
		try {
			session = openSession();
			String sql = "delete FROM SPComponentTemplate WHERE spTemplateId = ?";
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(templateId);
			queryObject.executeUpdate();
			return true;
		} catch (Exception e) {
			_log.info(e.toString());
		} finally {
			closeSession(session);
		}
		return true;
	}

	public boolean deleteTemplate(long templateId) {
		Session session = null;
		try {
			session = openSession();
			String sql = "update SPTemplate set status = 0 WHERE spTemplateId = ?";
			SQLQuery queryObject = session.createSQLQuery(sql);
			queryObject.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(queryObject);
			qPos.add(templateId);
			queryObject.executeUpdate();

			return true;
		} catch (Exception e) {
			_log.info(e.toString());
		} finally {
			closeSession(session);
		}
		return true;
	}

}
