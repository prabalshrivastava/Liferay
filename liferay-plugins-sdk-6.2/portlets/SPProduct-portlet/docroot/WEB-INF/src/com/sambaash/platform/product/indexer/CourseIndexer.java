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
import com.sambaash.platform.srv.service.persistence.CourseActionableDynamicQuery;

public class CourseIndexer extends BaseIndexer {

	private static final Log _log = LogFactoryUtil.getLog(CourseIndexer.class);

	public static final String[] CLASS_NAMES = { Course.class.getName() };

	public static final String PORTLET_ID = SPProductConstants.PORTLET_ID;

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Course course = (Course) obj;
		deleteDocument(course.getCompanyId(), course.getSpCourseId());
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

		Course course = (Course) obj;
		Document document = null;
		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Indexing Course " + course.getSpCourseId());
			}
			document = getBaseModelDocument(PORTLET_ID, course);
			// adding UID check as we are using multiple indexers in the same
			// portlet, inorder to avoid the chances of over-riding.
			document.addUID(PORTLET_ID, course.getSpCourseId(), Course.class.getName());
			document.addKeyword(Field.TITLE, course.getCourseName());
			document.addKeyword("courseName", course.getCourseName());
			document.addKeyword("courseName_lower", course.getCourseName().toLowerCase().trim());
			document.addKeyword("courseCode", course.getCourseCode());
			document.addKeyword("courseCode_lower", course.getCourseCode().toLowerCase().trim());
			document.addKeyword("courseId", course.getSpCourseId());
			document.addKeyword("courseDesc", course.getCourseDesc());
			
			
			try{
				List<CourseModule> modules = CourseModuleLocalServiceUtil
						.findByCourseIdAndGroupId(course.getSpCourseId(), course.getGroupId());
				
				StringBuilder moduleName = new StringBuilder();
				for (CourseModule courseModule : modules) {
					Module module = ModuleLocalServiceUtil.getModule(courseModule.getSpModuleId());
					moduleName.append("[").append(module.getModuleName().toLowerCase().trim()).append("]");
				}
				if(moduleName.length() > 0){
					document.addKeyword("moduleName_lower", moduleName.toString());
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
		Course course = (Course) obj;
		Document doc = getDocument(obj);
		SearchEngineUtil.updateDocument(SearchEngineUtil.getSearchEngineId(doc), course.getCompanyId(), doc, true);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Course course = CourseLocalServiceUtil.getCourse(classPK);
		doReindex(course);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	private void reindexEntries(long companyId) throws SystemException, PortalException {
		// reference DLFileEntryIndexer
		ActionableDynamicQuery query = new CourseActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				Course course = (Course) object;
				Document document = getDocument(course);

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
