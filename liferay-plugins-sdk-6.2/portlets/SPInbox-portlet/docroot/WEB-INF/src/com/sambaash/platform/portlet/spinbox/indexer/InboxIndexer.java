package com.sambaash.platform.portlet.spinbox.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.portlet.spinbox.helper.InboxConstants;
import com.sambaash.platform.srv.spinbox.model.IBMessage;
import com.sambaash.platform.srv.spinbox.service.IBMessageLocalServiceUtil;

public class InboxIndexer extends BaseIndexer {

	public static final String[] CLASS_NAMES = {IBMessage.class.getName()};

	public static final String PORTLET_ID = "spinboxnew_WAR_SPInboxportlet";

	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		IBMessage msg = (IBMessage)obj;
		Document document = getBaseModelDocument(PORTLET_ID, msg);
		document.addKeyword(Field.ENTRY_CLASS_PK, msg.getMessageId());
		
		StringBuilder sb = new StringBuilder();
		sb.append(msg.getFrom());
		sb.append(StringPool.BLANK);
		sb.append(msg.getTo());
		sb.append(StringPool.BLANK);
		sb.append(msg.getSubject());
		sb.append(StringPool.BLANK);
		sb.append(msg.getContent());
		sb.append(StringPool.BLANK);

		document.addText(InboxConstants.SEARCH_FIELD, sb.toString());
		document.addText(InboxConstants.FROM_EMAIL, msg.getFrom());
		document.addText(InboxConstants.TO_EMAIL, msg.getTo());
		document.addText(InboxConstants.SUBJECT, msg.getSubject());
		document.addText(InboxConstants.CONTENT, msg.getContent());
		document.addKeyword(Field.USER_ID, msg.getCreateByUserId());
		document.addKeyword(Field.USER_NAME, msg.getCreateBy());
		document.addDate(Field.CREATE_DATE, msg.getCreateDate());

		return document;
	}
	
	@Override
	protected void doDelete(Object obj) throws Exception {
		IBMessage msg = (IBMessage) obj;
		deleteDocument(msg.getCompanyId(), msg.getMessageId());
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		IBMessage msg = (IBMessage) obj;
		Document document = getDocument(msg);
		SearchEngineUtil.updateDocument(msg.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		IBMessage msg = IBMessageLocalServiceUtil.getIBMessage(classPK);
		doReindex(msg);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	protected void reindexEntries(long companyId) throws Exception {
		List<IBMessage> allMessages = IBMessageLocalServiceUtil.getIBMessages(-1, -1);
		if (allMessages.isEmpty()) {
			return;
		}
		Collection<Document> documents = new ArrayList<Document>();
		for (IBMessage msg : allMessages) {
			if(!msg.getDeleteStatus()) {
				Document document = getDocument(msg);
				documents.add(document);
			}
		}
		SearchEngineUtil.updateDocuments(companyId, documents);
	}

	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
		searchContext.setUserId(0);
		return super.search(searchContext);
	}

	@Override
	protected void addSearchKeywords(BooleanQuery searchQuery, SearchContext searchContext) throws Exception {
		String keywords = searchContext.getKeywords();
		if (Validator.isNull(keywords)) {
			return;
		}
		searchQuery.addTerms(_DEFAULT_KEYWORDS_FIELDS, keywords);
	}

	private static final String[] _DEFAULT_KEYWORDS_FIELDS = {
		InboxConstants.FROM_EMAIL, InboxConstants.TO_EMAIL, InboxConstants.SUBJECT, InboxConstants.CONTENT, Field.USER_NAME,InboxConstants.SEARCH_FIELD
	};

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {
		return null;
	}

}