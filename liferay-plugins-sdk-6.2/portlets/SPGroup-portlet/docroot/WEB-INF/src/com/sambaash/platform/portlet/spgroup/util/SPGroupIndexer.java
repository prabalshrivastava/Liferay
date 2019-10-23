package com.sambaash.platform.portlet.spgroup.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.model.SPGroupStatus;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.service.SPGroupLocalServiceUtil;

public class SPGroupIndexer extends BaseIndexer {

	private static Log _log = LogFactoryUtil.getLog(SPGroupIndexer.class);

	public static final String[] CLASS_NAMES = { SPGroup.class.getName() };

	public static final String PORTLET_ID = "SPGroupDetail_WAR_SPGroupportlet";

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
		searchContext.setUserId(0);
		return super.search(searchContext);
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		SPGroup spGroup = (SPGroup) obj;
		deleteDocument(spGroup.getCompanyId(), spGroup.getSpGroupId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		SPGroup spGroup = (SPGroup) obj;
		Document document = getBaseModelDocument(PORTLET_ID, spGroup);
		document.addKeyword(Field.ENTRY_CLASS_PK, spGroup.getSpGroupId());
		document.addText(Field.TITLE, spGroup.getTitle());
		document.addText(Field.DESCRIPTION, spGroup.getDescription());
		document.addKeyword(Field.USER_ID, spGroup.getUserId());
		document.addKeyword(Field.USER_NAME, spGroup.getUserName());
		document.addKeyword(Field.STATUS, spGroup.getStatus());
		document.addKeyword(Field.TYPE, spGroup.getType());
		document.addDate(Field.CREATE_DATE, spGroup.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, spGroup.getModifiedDate());

		document.addKeyword(SPGroupConstants.FIELDS.URL_TITLE, spGroup.getUrlTitle());
		document.addKeyword(SPGroupConstants.FIELDS.IMAGE_ID, spGroup.getImageId());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) {
		String title = document.get(Field.TITLE);
		String description = snippet;

		if (Validator.isNull(snippet)) {
			description = StringUtil.shorten(document.get(Field.DESCRIPTION), 200);
		}

		String entryId = document.get(Field.ENTRY_CLASS_PK);
		portletURL.setParameter("entryId", entryId);
		return new Summary(title, description, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {

		SPGroup spGroup = (SPGroup) obj;

		_log.error("doReindex getTitle : " + spGroup.getTitle() + " : getSpGroupId : " + spGroup.getSpGroupId());

		if (spGroup.getStatus() == SPGroupStatus.CLOSED.getValue()) {
			return;
		}

		Document document = getDocument(spGroup);
		SearchEngineUtil.updateDocument(getSearchEngineId(), spGroup.getCompanyId(), document, true);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		_log.error("doReindex className : " + className + " : classPK : " + classPK);
		SPGroup spGroup = SPGroupLocalServiceUtil.getSPGroup(classPK);
		doReindex(spGroup);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		_log.error("doReindex : " + ids);
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void reindexEntries(long companyId) throws Exception {
		List<SPGroup> spGroups = SPGroupLocalServiceUtil.getSPGroups(-1, -1);

		_log.error("reindexEntries : spGroups.size() : " + spGroups.size());

		if (spGroups.isEmpty()) {
			return;
		}

		Collection<Document> documents = new ArrayList<Document>();

		for (SPGroup spGroup : spGroups) {

			_log.error("Indexing spGroup.getTitle() : " + spGroup.getTitle());

			if (spGroup.getStatus() == SPGroupStatus.OPEN.getValue()) {
				Document document = getDocument(spGroup);
				documents.add(document);
			}
		}

		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents, true);
	}

}