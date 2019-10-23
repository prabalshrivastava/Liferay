package com.sambaash.platform.activityhub.indexer;



import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.activityhub.constants.SPActivityHubConstants;
import com.sambaash.platform.srv.model.LogActivity;
import com.sambaash.platform.srv.service.LogActivityLocalServiceUtil;
import com.sambaash.platform.srv.service.persistence.LogActivityActionableDynamicQuery;

public class SPLogActivityIndexer extends BaseIndexer {
	public static final String[] CLASS_NAMES = { LogActivity.class.getName() };

	public static final String PORTLET_ID = SPActivityHubConstants.PORTLET_ID;

	private static Log _log = LogFactoryUtil.getLog(SPLogActivityIndexer.class);

	

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		LogActivity logActivity = (LogActivity)obj;
		deleteDocument(logActivity.getCompanyId(), logActivity.getSpLogActivityId());
	}

	public static String getSearchableString(String str){
		str = GetterUtil.getString(str);
		str = str.toLowerCase();
		str = str.replace("?", "");
		str = str.replace("*", "");
		str = str.replace("'", "");
		str = str.replace(" ", "");
		str = str.replace("-", "");
		str = str.replace("_", "");
		str = str.replace("+", "");
		str = str.replace("@", "");
		str = str.replace("&", "");
		str = str.replace(":", "");
		return str;
	}
	
	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		LogActivity logActivity = (LogActivity)obj;
		Document document = null;
		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Indexing document " + logActivity);
			}
			
			document = getBaseModelDocument(PORTLET_ID, logActivity);
			document.addKeyword(SPActivityHubConstants.CLASS_NAME, LogActivity.class.getName());
			document.addKeyword(SPActivityHubConstants.ENTITY_ID, logActivity.getEntityId());
			document.addKeyword(SPActivityHubConstants.ENTITY_CLASS_ID, logActivity.getEntityClassId());
			document.addKeyword(SPActivityHubConstants.ENTITY_CLASS_NAME, logActivity.getEntityClassName());
			document.addDate(SPActivityHubConstants.CREATE_DATE, logActivity.getCreateDate());
			document.addDate(SPActivityHubConstants.MODIFIED_DATE, logActivity.getModifiedDate());
			document.addKeyword(SPActivityHubConstants.SP_LOG_ACTIVITY_ID, logActivity.getSpLogActivityId());
			document.addKeyword(SPActivityHubConstants.SAVED_BY_USER_ID, logActivity.getSavedByUserId());
			document.addKeyword(SPActivityHubConstants.LOG_ACTIVITY_TITLE, logActivity.getActivityTitle());
			document.addKeyword(SPActivityHubConstants.LOG_ACTIVITY_CONTENT, logActivity.getActivityContent());
			document.addKeyword(SPActivityHubConstants.FILE_ENTRY_ID, logActivity.getFileEntryId());
			document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH, logActivity.getAssociatedWith());
			document.addKeyword(SPActivityHubConstants.STATUS, logActivity.getStatus());
			document.addKeyword(SPActivityHubConstants.PARENT_LOG_ACTIVITY_ID, logActivity.getParentLogActivityId());
			document.addKeyword(SPActivityHubConstants.LOG_ACTIVITY_OUTCOME, logActivity.getActivityOutcome());
			document.addKeyword(SPActivityHubConstants.LOG_ACTIVITY_TYPE, logActivity.getActivityType());
			document.addDate(SPActivityHubConstants.LOG_ACTIVITY_DATE, logActivity.getActivityDate());
			document.addKeyword(SPActivityHubConstants.LOG_ACTIVITY_TIME, logActivity.getActivityTime());
			
			

			
			
			User user = UserLocalServiceUtil.getUser(logActivity.getSavedByUserId());
			if(user != null){
				document.addKeyword(SPActivityHubConstants.SAVED_BY_USER_SCREEN_NAME, user.getScreenName());
				document.addKeyword(SPActivityHubConstants.SAVED_BY_USER_EMAIL, user.getEmailAddress());
				document.addKeyword(SPActivityHubConstants.SAVED_BY_USER_EMAIL_SEARCHABLE, getSearchableString(user.getEmailAddress()));
				document.addKeyword(SPActivityHubConstants.SAVED_BY_USER_FULL_NAME_SEARCHABLE, getSearchableString(user.getFullName()));
				document.addKeyword(SPActivityHubConstants.SAVED_BY_USER_FULL_NAME, user.getFullName());	
			}
			
			if (logActivity.getAssociatedWith() > 0){
				user = UserLocalServiceUtil.getUser(logActivity.getAssociatedWith());
				if(user != null){
					document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH_USER_SCREEN_NAME, user.getScreenName());
					document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH_USER_EMAIL, user.getEmailAddress());
					document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH_USER_EMAIL_SEARCHABLE, getSearchableString(user.getEmailAddress()));
					document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH_USER_FULL_NAME_SEARCHABLE, getSearchableString(user.getFullName()));
					document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH_USER_FULL_NAME, user.getFullName());	
				}
			}
		
			try{
				// to support case insensitive search
				StringBuilder sb = new StringBuilder();
				Map<String, Field> map = document.getFields();
				Set<String> keyset = map.keySet();
				Iterator<String> iterator = keyset.iterator();
				while (iterator.hasNext()) {
					Field field = map.get(iterator.next());
					sb.append(field.getValue());
					sb.append(StringPool.SPACE);
				}
				document.addText("searchableContent", sb.toString().toLowerCase());
			}catch(Exception e){
				_log.error(e);
			}
			
			
		}catch (Exception ex) {
			_log.error("Error while indexing document " + obj,ex );
		}
		

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {

		// TODO Auto-generated method stub

		return null;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		LogActivity logActivity = (LogActivity)obj;
		Document doc = getDocument(obj);
		SearchEngineUtil.updateDocument(SearchEngineUtil.getSearchEngineId(doc), logActivity.getCompanyId(), doc, true);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		LogActivity logActivity = LogActivityLocalServiceUtil.getLogActivity(classPK);
		reindex(logActivity);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	private void reindexEntries(long companyId) throws PortalException, SystemException {

		// reference DLFileEntryIndexer

		ActionableDynamicQuery query = new LogActivityActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) throws PortalException,
					SystemException {
				LogActivity logActivity = (LogActivity)object;
				Document document = getDocument(logActivity);

				if (document != null) {
					addDocument(document);
				}
			}
		};
		query.setClassLoader(PortletClassLoaderUtil.getClassLoader(PORTLET_ID));
		query.setCompanyId(companyId);

		// this method internall query the all rows , calls performaction method on each object.

		query.performActions();
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {

		// TODO Auto-generated method stub

		return PORTLET_ID;
	}
}