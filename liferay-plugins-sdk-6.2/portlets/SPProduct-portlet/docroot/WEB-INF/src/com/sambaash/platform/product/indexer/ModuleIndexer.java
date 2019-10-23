package com.sambaash.platform.product.indexer;

import java.util.List;
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
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.sambaash.platform.product.util.SPProductConstants;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.CourseModule;
import com.sambaash.platform.srv.model.Module;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.persistence.ModuleActionableDynamicQuery;

public class ModuleIndexer extends BaseIndexer {

	private static final Log _log = LogFactoryUtil.getLog(ModuleIndexer.class);

	public static final String[] CLASS_NAMES = { Module.class.getName() };

	public static final String PORTLET_ID = SPProductConstants.PORTLET_ID;

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Module module = (Module) obj;
		deleteDocument(module.getCompanyId(), module.getSpModuleId());
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

		Module module = (Module) obj;
		Document document = null;
		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Indexing Module " + module.getSpModuleId());
			}
			document = getBaseModelDocument(PORTLET_ID, module);
			// adding UID check as we are using multiple indexers in the same portlet, inorder to avoid the chances of over-riding.
			document.addUID(PORTLET_ID, module.getSpModuleId(), Module.class.getName());
			document.addKeyword(Field.TITLE, module.getModuleName());
			document.addKeyword("moduleName", module.getModuleName());
			document.addKeyword("moduleName_lower", module.getModuleName().toLowerCase().trim());
			document.addKeyword("moduleCode", module.getModuleCode());
			document.addKeyword("moduleCode_lower", module.getModuleCode().toLowerCase().trim());
			document.addKeyword("moduleId", module.getSpModuleId());
			document.addKeyword("moduleDesc", module.getModuleDesc());
			try{
				List<CourseModule> modules = CourseModuleLocalServiceUtil
						.findByModuleIdAndGroupId(module.getSpModuleId(), module.getGroupId());
				
				StringBuilder courseName = new StringBuilder();
				for (CourseModule courseModule : modules) {
					Course course = CourseLocalServiceUtil.getCourse(courseModule.getSpCourseId());
					courseName.append("[").append(course.getCourseName().toLowerCase().trim()).append("]");
				}
				if(courseName.length() > 0){
					document.addKeyword("courseName_lower", courseName.toString());
				}
			}catch(Exception e){
				_log.error(e);
			}
			

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
		Module module = (Module) obj;
		Document doc = getDocument(obj);
		SearchEngineUtil.updateDocument(SearchEngineUtil.getSearchEngineId(doc), module.getCompanyId(), doc, true);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Module module = ModuleLocalServiceUtil.getModule(classPK);
		doReindex(module);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	private void reindexEntries(long companyId) throws SystemException, PortalException {
		// reference DLFileEntryIndexer
		ActionableDynamicQuery query = new ModuleActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				Module module = (Module) object;
				Document document = getDocument(module);

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
