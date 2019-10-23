package com.sambaash.platform.activityhub.indexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.activityhub.constants.SPActivityHubConstants;
import com.sambaash.platform.srv.model.Conversation;
import com.sambaash.platform.srv.model.Note;
import com.sambaash.platform.srv.service.NoteLocalServiceUtil;
import com.sambaash.platform.srv.service.persistence.NoteActionableDynamicQuery;

public class SPNoteIndexer extends BaseIndexer {
	public static final String[] CLASS_NAMES = { Note.class.getName() };

	public static final String PORTLET_ID = SPActivityHubConstants.PORTLET_ID;

	private static Log _log = LogFactoryUtil.getLog(SPNoteIndexer.class);

	

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Note note = (Note)obj;
		deleteDocument(note.getCompanyId(), note.getSpNoteId());
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
		Note note = (Note)obj;
		Document document = null;
		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Indexing document " + note);
			}
			
			document = getBaseModelDocument(PORTLET_ID, note);
			document.addKeyword(SPActivityHubConstants.CLASS_NAME, Note.class.getName());
			document.addKeyword(SPActivityHubConstants.ENTITY_ID, note.getEntityId());
			document.addKeyword(SPActivityHubConstants.ENTITY_CLASS_ID, note.getEntityClassId());
			document.addKeyword(SPActivityHubConstants.ENTITY_CLASS_NAME, note.getEntityClassName());
			document.addDate(SPActivityHubConstants.CREATE_DATE, note.getCreateDate());
			document.addDate(SPActivityHubConstants.MODIFIED_DATE, note.getModifiedDate());
			document.addKeyword(SPActivityHubConstants.SP_NOTE_ID, note.getSpNoteId());
			document.addKeyword(SPActivityHubConstants.SAVED_BY_USER_ID, note.getSavedByUserId());
			document.addKeyword(SPActivityHubConstants.NOTE_TITLE, note.getNoteTitle());
			document.addKeyword(SPActivityHubConstants.NOTE_CONTENT, note.getNoteContent());
			document.addKeyword(SPActivityHubConstants.FILE_ENTRY_ID, note.getFileEntryId());
			document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH, note.getAssociatedWith());
			document.addKeyword(SPActivityHubConstants.STATUS, note.getStatus());
			document.addKeyword(SPActivityHubConstants.PARENT_NOTE_ID, note.getParentNoteId());
			
			

			
			
			User user = UserLocalServiceUtil.getUser(note.getSavedByUserId());
			if(user != null){
				document.addKeyword(SPActivityHubConstants.SAVED_BY_USER_SCREEN_NAME, user.getScreenName());
				document.addKeyword(SPActivityHubConstants.SAVED_BY_USER_EMAIL, user.getEmailAddress());
				document.addKeyword(SPActivityHubConstants.SAVED_BY_USER_EMAIL_SEARCHABLE, getSearchableString(user.getEmailAddress()));
				document.addKeyword(SPActivityHubConstants.SAVED_BY_USER_FULL_NAME_SEARCHABLE, getSearchableString(user.getFullName()));
				document.addKeyword(SPActivityHubConstants.SAVED_BY_USER_FULL_NAME, user.getFullName());	
			}
			
			if (note.getAssociatedWith() > 0){
				user = UserLocalServiceUtil.getUser(note.getAssociatedWith());
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
		Note note = (Note)obj;
		Document doc = getDocument(obj);
		SearchEngineUtil.updateDocument(SearchEngineUtil.getSearchEngineId(doc), note.getCompanyId(), doc, true);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Note note = NoteLocalServiceUtil.getNote(classPK);
		reindex(note);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	private void reindexEntries(long companyId) throws PortalException, SystemException {

		// reference DLFileEntryIndexer

		ActionableDynamicQuery query = new NoteActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) throws PortalException,
					SystemException {
				Note note = (Note)object;
				Document document = getDocument(note);

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