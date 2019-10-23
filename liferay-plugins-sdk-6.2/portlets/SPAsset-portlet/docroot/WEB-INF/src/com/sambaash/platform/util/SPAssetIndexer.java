package com.sambaash.platform.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SPAssetIndexer extends BaseIndexer {

	private static Log _log = LogFactoryUtil.getLog(SPAssetIndexer.class);
	
	public static final String[] CLASS_NAMES = { SPAssetEntry.class.getName() };
	public static final String PORTLET_ID = SPAssetConstants.PORTLET_ID;
	public static int COUNT = getCount();

	public static int getCount() {
		int count = 1;
		try {
			count = SPAssetEntryLocalServiceUtil.getSPAssetEntriesCount();
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		return count;
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object arg0) throws Exception {
		SPAssetEntry assetEntry = (SPAssetEntry) arg0;
		Document document = new DocumentImpl();
		document.addUID(PORTLET_ID, assetEntry.getSpAssetEntryId());
		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.deleteDocument(searchEngineId,
				assetEntry.getCompanyId(), document.get(Field.UID), true);
		reIndexAssetEntriesDelete(assetEntry.getCompanyId());
	}

	@Override
	protected Document doGetDocument(Object arg0) throws Exception {
		SPAssetEntry assetEntry = (SPAssetEntry) arg0;
		long groupId = assetEntry.getGroupId();
		long scopeGroupId = assetEntry.getGroupId();
		long companyId = assetEntry.getCompanyId();
		String description = assetEntry.getDescription();
		String title = assetEntry.getTitle();
		Document document = getBaseModelDocument(PORTLET_ID, assetEntry);
		document.addKeyword(Field.COMPANY_ID, companyId);
		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);

		document.addText(Field.DESCRIPTION, description);
		document.addKeyword("spAssetEntryId", assetEntry.getSpAssetEntryId());
		document.addText(Field.TITLE, title);

		document.addDate(Field.CREATE_DATE, assetEntry.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, assetEntry.getModifiedDate());
		document.addKeyword(Field.USER_ID, assetEntry.getUserId());
		document.addKeyword(Field.USER_NAME, assetEntry.getUserName());
		document.addKeyword("spCoverFileEntryId",
				Long.toString(assetEntry.getCoverFileEntryId()));
		document.addKeyword("spDLFolderId", assetEntry.getDlFolderId());
		document.addKeyword("spAssetTypeId", assetEntry.getSpAssetTypeId());
		document.addKeyword("status", assetEntry.getStatus());

		return document;
	}

	protected Document getDocumentUpdate(Object arg0) throws Exception {
		SPAssetEntry assetEntry = (SPAssetEntry) arg0;
		long groupId = assetEntry.getGroupId();
		long scopeGroupId = assetEntry.getGroupId();
		long companyId = assetEntry.getCompanyId();
		String description = assetEntry.getDescription();
		String title = assetEntry.getTitle();
		Document document = getBaseModelDocument(PORTLET_ID, assetEntry);
		document.addKeyword(Field.COMPANY_ID, companyId);
		document.addKeyword(Field.GROUP_ID, groupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);

		document.addText(Field.DESCRIPTION, description);
		document.addKeyword("spAssetEntryId", assetEntry.getSpAssetEntryId());
		document.addText(Field.TITLE, title);

		document.addDate(Field.CREATE_DATE, assetEntry.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, assetEntry.getModifiedDate());
		document.addKeyword(Field.USER_ID, assetEntry.getUserId());
		document.addKeyword(Field.USER_NAME, assetEntry.getUserName());
		document.addKeyword("spCoverFileEntryId",
				Long.toString(assetEntry.getCoverFileEntryId()));
		document.addKeyword("spDLFolderId", assetEntry.getDlFolderId());
		document.addKeyword("spAssetTypeId", assetEntry.getSpAssetTypeId());
		document.addKeyword("status", assetEntry.getStatus());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document arg0, Locale arg1, String arg2,
			PortletURL arg3) throws Exception {
		long spAssetEntryId = GetterUtil.getLong(arg0.get("spAssetEntryId"));
		SPAssetEntry spAssetEntry = null;
		List<SPAssetEntry> totalRecord = new ArrayList<SPAssetEntry>();
		if (spAssetEntryId > 0) {
			spAssetEntry = SPAssetEntryLocalServiceUtil
					.fetchSPAssetEntry(spAssetEntryId);
		}
		String title = arg0.get(Field.TITLE);
		String content = arg2;
		List<SPAssetEntry> spAssetlList = null;

		spAssetlList = SPAssetEntryLocalServiceUtil.getSPAssetEntries(0, -1);
		for (SPAssetEntry tr : spAssetlList) {
			totalRecord.add(tr);
		}
		int pos = totalRecord.indexOf(spAssetEntry) + 1;
		if (pos > 0) {
			int page = pos / 10;
			if (pos % 10 > 0) {
				page = page + 1;
			}
			if (page == 0) {
				page = 1;
			}
			arg3.setParameter("cur", String.valueOf(page));
		}
		return new Summary(title, content, arg3);
	}

	@Override
	protected void doReindex(Object arg0) throws Exception {
		SPAssetEntry assetEntry = (SPAssetEntry) arg0;
		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.updateDocument(searchEngineId,
				assetEntry.getCompanyId(), getDocument(assetEntry), true);
		reIndexAssetEntriesDelete(assetEntry.getCompanyId());

	}

	protected void doReindexUpdate(Object arg0) throws Exception {
		SPAssetEntry assetEntry = (SPAssetEntry) arg0;
		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.updateDocument(searchEngineId,
				assetEntry.getCompanyId(), getDocumentUpdate(assetEntry), true);
	}

	@Override
	protected void doReindex(String[] arg0) throws Exception {
		long companyId = GetterUtil.getLong(arg0[0]);
		doReindexAll(companyId);
	}

	private void doReindexAll(long companyId) throws Exception {
		int count = SPAssetEntryLocalServiceUtil.getSPAssetEntriesCount();
		int pages = count / Indexer.DEFAULT_INTERVAL;
		for (int i = 0; i <= pages; i++) {
			int start = (i * Indexer.DEFAULT_INTERVAL);
			int end = start + Indexer.DEFAULT_INTERVAL;
			reIndexAssetEntries(companyId, start, end);
		}
	}

	@Override
	protected void doReindex(String arg0, long spAssetEntryId) throws Exception {
		SPAssetEntry assetEntry = SPAssetEntryLocalServiceUtil
				.getSPAssetEntry(spAssetEntryId);
		doReindex(assetEntry);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return PORTLET_ID;
	}

	protected void reIndexAssetEntries(long companyId, int start, int end)
			throws Exception {
		List<SPAssetEntry> assetEntries = SPAssetEntryLocalServiceUtil
				.getSPAssetEntries(start, end);
		if (assetEntries.isEmpty()) {
			return;
		}
		Collection<Document> documents = new ArrayList<Document>();
		COUNT = 1;
		for (SPAssetEntry assetEntry : assetEntries) {
			Document document = getDocument(assetEntry);
			document.addText("count", String.valueOf(COUNT++));
			documents.add(document);
		}
		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.updateDocuments(searchEngineId, companyId, documents,
				true);
	}

	public void reIndexAssetEntriesDelete(long companyId) throws Exception {
		List<SPAssetEntry> assetEntries = SPAssetEntryLocalServiceUtil
				.getSPAssetEntries(-1, -1);
		if (assetEntries.isEmpty()) {
			return;
		}
		Collection<Document> documents = new ArrayList<Document>();
		COUNT = 1;
		for (SPAssetEntry assetEntry : assetEntries) {
			Document document = getDocument(assetEntry);
			document.addText("count", String.valueOf(COUNT++));
			documents.add(document);
		}
		String searchEngineId = SearchEngineUtil.getDefaultSearchEngineId();
		SearchEngineUtil.updateDocuments(searchEngineId, companyId, documents,
				true);
	}
}
