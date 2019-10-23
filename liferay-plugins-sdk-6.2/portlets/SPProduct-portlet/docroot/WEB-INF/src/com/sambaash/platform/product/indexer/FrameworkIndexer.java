package com.sambaash.platform.product.indexer;


import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.permission.PermissionChecker;
import com.sambaash.platform.product.util.SPProductConstants;
import com.sambaash.platform.srv.model.CompetencyUnit;
import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.FrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.persistence.CompetencyUnitActionableDynamicQuery;
import com.sambaash.platform.srv.service.persistence.FrameworkActionableDynamicQuery;

public class FrameworkIndexer extends BaseIndexer {

	private static final Log _log = LogFactoryUtil.getLog(FrameworkIndexer.class);

	public static final String[] CLASS_NAMES = { Framework.class.getName() };

	public static final String PORTLET_ID = SPProductConstants.PORTLET_ID;

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Framework framework = (Framework) obj;
		deleteDocument(framework.getCompanyId(), framework.getSpFrameworkId());
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return PORTLET_ID;
	}

	public boolean hasPermission(PermissionChecker permissionChecker, long entryClassPK, String actionId)
			throws Exception {
		// TODO: have to look into it
		// return super.hasPermission(permissionChecker, entryClassPK,
		// actionId);
		return true;
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {

		Framework framework = (Framework) obj;
		Document document = null;
		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Indexing Framework " + framework.getSpFrameworkId());
			}
			document = getBaseModelDocument(PORTLET_ID, framework);
			// adding UID check as we are using multiple indexers in the same
			// portlet, inorder to avoid the chances of over-riding.
			document.addUID(PORTLET_ID, framework.getSpFrameworkId(), Framework.class.getName());
			document.addKeyword("frameworkId", framework.getSpFrameworkId());
			document.addKeyword("frameworkCode", framework.getFrameworkCode());
			document.addKeyword("frameworkName", framework.getFrameworkName());
			document.addKeyword("frameworkCode_lower", framework.getFrameworkCode().toLowerCase().trim());
			document.addKeyword("frameworkName_lower", framework.getFrameworkName().toLowerCase().trim());
			document.addKeyword("frameworkImageId", framework.getFrameworkImageId());
			

		} catch (Exception ex) {
			_log.error("Error while indexing document " + obj, ex);
		}
		return document;

	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL)
			throws Exception {
		return null;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		Framework framework = (Framework) obj;
		Document doc = getDocument(obj);
		SearchEngineUtil.updateDocument(SearchEngineUtil.getSearchEngineId(doc), framework.getCompanyId(), doc, true);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Framework framework = FrameworkLocalServiceUtil.getFramework(classPK);
		doReindex(framework);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	private void reindexEntries(long companyId) throws SystemException, PortalException {
		// reference DLFileEntryIndexer
		ActionableDynamicQuery query = new FrameworkActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				Framework framework = (Framework) object;
				Document document = getDocument(framework);

				if (document != null) {
					addDocument(document);
				}
			}
		};
		query.setClassLoader(PortletClassLoaderUtil.getClassLoader(PORTLET_ID));
		query.setCompanyId(companyId);
		// this method internall query the all rows , calls performaction method
		// on each object.
		query.performActions();
	}

}
