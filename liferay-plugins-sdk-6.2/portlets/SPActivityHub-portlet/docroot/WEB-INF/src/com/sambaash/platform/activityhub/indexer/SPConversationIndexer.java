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
import com.sambaash.platform.srv.model.ConversationUser;
import com.sambaash.platform.srv.service.ConversationLocalServiceUtil;
import com.sambaash.platform.srv.service.ConversationUserLocalServiceUtil;
import com.sambaash.platform.srv.service.persistence.ConversationActionableDynamicQuery;

public class SPConversationIndexer extends BaseIndexer {
	public static final String[] CLASS_NAMES = { Conversation.class.getName() };

	public static final String PORTLET_ID = SPActivityHubConstants.PORTLET_ID;

	private static Log _log = LogFactoryUtil.getLog(SPConversationIndexer.class);

	

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Conversation conversation = (Conversation)obj;
		deleteDocument(conversation.getCompanyId(), conversation.getSpConversationId());
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
		Conversation conversation = (Conversation)obj;
		Document document = null;
		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Indexing document " + conversation);
			}
			
			document = getBaseModelDocument(PORTLET_ID, conversation);
			document.addKeyword(SPActivityHubConstants.CLASS_NAME, Conversation.class.getName());
			document.addKeyword(SPActivityHubConstants.ENTITY_ID, conversation.getEntityId());
			document.addKeyword(SPActivityHubConstants.ENTITY_CLASS_ID, conversation.getEntityClassId());
			document.addKeyword(SPActivityHubConstants.ENTITY_CLASS_NAME, conversation.getEntityClassName());
			document.addDate(SPActivityHubConstants.CREATE_DATE, conversation.getCreateDate());
			document.addDate(SPActivityHubConstants.MODIFIED_DATE, conversation.getModifiedDate());
			document.addKeyword(SPActivityHubConstants.SP_CONVERSATION_ID, conversation.getSpConversationId());
			document.addKeyword(SPActivityHubConstants.SENT_BY_USER_ID, conversation.getSentByUserId());
			document.addKeyword(SPActivityHubConstants.MESSAGE, conversation.getMessage());
			document.addKeyword(SPActivityHubConstants.FILE_ENTRY_ID, conversation.getFileEntryId());
			document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH, conversation.getAssociatedWith());
			document.addKeyword(SPActivityHubConstants.RESTRICTED, conversation.getRestricted());
			document.addKeyword(SPActivityHubConstants.STATUS, conversation.getStatus());
			document.addKeyword(SPActivityHubConstants.PARENT_CONVERSATION_ID, conversation.getParentConverstationId());
			document.addKeyword(SPActivityHubConstants.CONV_UUID, conversation.getUuid());
			
			

			
			
			User user = UserLocalServiceUtil.getUser(conversation.getSentByUserId());
			if(user != null){
				document.addKeyword(SPActivityHubConstants.SENT_BY_USER_SCREEN_NAME, user.getScreenName());
				document.addKeyword(SPActivityHubConstants.SENT_BY_USER_EMAIL, user.getEmailAddress());
				document.addKeyword(SPActivityHubConstants.SENT_BY_USER_EMAIL_SEARCHABLE, getSearchableString(user.getEmailAddress()));
				document.addKeyword(SPActivityHubConstants.SENT_BY_USER_FULL_NAME_SEARCHABLE, getSearchableString(user.getFullName()));
				document.addKeyword(SPActivityHubConstants.SENT_BY_USER_FULL_NAME, user.getFullName());	
			}
			
			if (conversation.getAssociatedWith() > 0){
				user = UserLocalServiceUtil.getUser(conversation.getAssociatedWith());
				if(user != null){
					document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH_USER_SCREEN_NAME, user.getScreenName());
					document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH_USER_EMAIL, user.getEmailAddress());
					document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH_USER_EMAIL_SEARCHABLE, getSearchableString(user.getEmailAddress()));
					document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH_USER_FULL_NAME_SEARCHABLE, getSearchableString(user.getFullName()));
					document.addKeyword(SPActivityHubConstants.ASSOCIATED_WITH_USER_FULL_NAME, user.getFullName());	
				}
			}
			
			List<ConversationUser> conversationUsers = ConversationUserLocalServiceUtil.findByspConversationId(conversation.getSpConversationId());
			List<Long> sentToUserId = new ArrayList<Long>();
			List<String> sentToUserScreenName = new ArrayList<String>();
			List<String> sentToUserEmail = new ArrayList<String>();
			List<String> sentToUserEmailSearchable = new ArrayList<String>();
			List<String> sentToUserFullNameSearchable = new ArrayList<String>();
			List<String> sentToUserFullName = new ArrayList<String>();
			for (ConversationUser conversationUser : conversationUsers){
					
					sentToUserId.add(conversationUser.getSentToUserId());
					if (conversationUser.getSentToUserId() > 0){
					user = UserLocalServiceUtil.getUser(conversationUser.getSentToUserId());
					if(user != null){
						sentToUserScreenName.add(user.getScreenName());
						sentToUserEmail.add(user.getEmailAddress());
						sentToUserEmailSearchable.add(getSearchableString(user.getEmailAddress()));
						sentToUserFullNameSearchable.add(getSearchableString(user.getFullName()));
						sentToUserFullName.add(user.getFullName());
					}
				}
			}
			
			if (Validator.isNotNull(sentToUserId)){
				document.addKeyword(SPActivityHubConstants.SENT_TO_USER_ID, Arrays.toString(sentToUserId.toArray()).replaceAll("\\[|\\]|",""));
				document.addKeyword(SPActivityHubConstants.SENT_TO_USER_SCREEN_NAME, Arrays.toString(sentToUserScreenName.toArray()).replaceAll("\\[|\\]|",""));
				document.addKeyword(SPActivityHubConstants.SENT_TO_USER_EMAIL, Arrays.toString(sentToUserEmail.toArray()).replaceAll("\\[|\\]|",""));
				document.addKeyword(SPActivityHubConstants.SENT_TO_USER_EMAIL_SEARCHABLE, Arrays.toString(sentToUserEmailSearchable.toArray()).replaceAll("\\[|\\]|",""));
				document.addKeyword(SPActivityHubConstants.SENT_TO_USER_FULL_NAME_SEARCHABLE, Arrays.toString(sentToUserFullNameSearchable.toArray()).replaceAll("\\[|\\]|",""));
				document.addKeyword(SPActivityHubConstants.SENT_TO_USER_FULL_NAME, Arrays.toString(sentToUserFullName.toArray()).replaceAll("\\[|\\]|",""));
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
		Conversation conversation = (Conversation)obj;
		Document doc = getDocument(obj);
		SearchEngineUtil.updateDocument(SearchEngineUtil.getSearchEngineId(doc), conversation.getCompanyId(), doc, true);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Conversation conversation = ConversationLocalServiceUtil.getConversation(classPK);
		reindex(conversation);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	private void reindexEntries(long companyId) throws PortalException, SystemException {

		// reference DLFileEntryIndexer

		ActionableDynamicQuery query = new ConversationActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) throws PortalException,
					SystemException {
				Conversation conversation = (Conversation)object;
				Document document = getDocument(conversation);

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