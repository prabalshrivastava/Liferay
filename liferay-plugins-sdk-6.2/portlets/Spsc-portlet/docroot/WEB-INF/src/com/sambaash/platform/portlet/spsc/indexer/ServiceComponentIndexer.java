package com.sambaash.platform.portlet.spsc.indexer;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;

import java.util.Locale;

import javax.portlet.PortletURL;

/**
import sambaash.platform.servicecomponent.util.ServiceHelper;
import sambaash.platform.srv.servicecomponent.model.ServiceComponentGroup;
import sambaash.platform.srv.servicecomponent.model.ServiceComponents;
import sambaash.platform.srv.servicecomponent.service.ServiceComponentGroupLocalServiceUtil;**/
import com.liferay.portal.kernel.search.BaseIndexer;

public class ServiceComponentIndexer extends BaseIndexer {

	@Override
	public String[] getClassNames() {

		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public String getPortletId() {

		// TODO Auto-generated method stub

		return null;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

		// TODO Auto-generated method stub

	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {

		// TODO Auto-generated method stub

		return null;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {

		// TODO Auto-generated method stub

		return null;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {

		// TODO Auto-generated method stub

	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		// TODO Auto-generated method stub

	}

	@Override
	protected void doReindex(String[] ids) throws Exception {

		// TODO Auto-generated method stub

	}

	@Override
	protected String getPortletId(SearchContext searchContext) {

		// TODO Auto-generated method stub

		return null;
	}
	//com.liferay.portal.kernel.search.Indexer {
/**
		private static long companyId = PortalUtil.getDefaultCompanyId();

		private static Log _log = LogFactoryUtil.getLog(ServiceComponentIndexer.class);

		public static final String PORTLET_ID = "Spsc_WAR_Spscportlet";

		private static final String[] _CLASS_NAMES = new String[] {
			ServiceComponents.class.getName(), ServiceComponentGroup.class.getName()
		};

		protected String getPortletId(SearchContext searchContext) {
			return PORTLET_ID;
		}

		public String[] getClassNames() {

			// TODO Auto-generated method stub

			return _CLASS_NAMES;
		}

		public static Document getEntryDocument(long companyId, long groupId, long folderId, long scgID, String name,
				String url, String comments, String title, String description, Date modifiedDate, String[] tagsEntries,
				ExpandoBridge expandoBridge) {

			_log.info("getEntryDocument:"+scgID+">>"+title);

				Document doc = new DocumentImpl();

				doc.addUID(PORTLET_ID, scgID);

				doc.addModifiedDate(modifiedDate);

				doc.addKeyword(Field.COMPANY_ID, companyId);
				doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);
				doc.addKeyword(Field.GROUP_ID, groupId);

				doc.addText(Field.TITLE, name);
//				doc.addKeyword(Field.TAGS_ENTRIES, tagsEntries);

				doc.addKeyword("folderId", folderId);
				doc.addText(Field.TITLE, title);
				doc.addText(Field.DESCRIPTION, description);
				doc.addKeyword(Field.ENTRY_CLASS_NAME, ServiceComponentGroup.class.getName());
				doc.addKeyword(Field.ENTRY_CLASS_PK, scgID);
				doc.addText(Field.URL, url);
				doc.addText(Field.COMMENTS, comments);

			//	ExpandoBridgeIndexerUtil.addAttributes(doc, expandoBridge);

				return doc;
			}

		public static String getServiceComponentGroupUID(long scgID) {
			Document doc = new DocumentImpl();

			doc.addUID(PORTLET_ID, scgID);

			_log.info("getServiceComponentGroupUID:"+doc.get(Field.UID));

			return doc.get(Field.UID);
		}

		public static void addServiceComponentGroup(
				long companyId, long groupId, long folderId, long scgID, String name,
				String url, String comments, String title, String description, Date modifiedDate, String[] tagsEntries,
				ExpandoBridge expandoBridge)
			throws SearchException {

			Document doc = getEntryDocument(
				companyId, groupId, folderId, scgID, name, url, comments, title, description,
				modifiedDate, tagsEntries, expandoBridge);

			_log.info("addServiceComponentGroup:"+scgID);

			SearchEngineUtil.addDocument(companyId, doc);
			_log.info("After sSearchEngineUtil.addDocument(companyId, doc);");
		}

		public static void updateServiceComponentGroup(
				long companyId, long groupId, long folderId, long scgID, String name,
				String url, String comments, String title, String description, Date modifiedDate, String[] tagsEntries,
				ExpandoBridge expandoBridge)
			throws SearchException {

			Document doc = getEntryDocument(
					companyId, groupId, folderId, scgID, name, url, comments, title, description,
					modifiedDate, tagsEntries, expandoBridge);

			_log.info("updateServiceComponentGroup:"+scgID+">>"+name+">>doc:"+doc);

		SearchEngineUtil.updateDocument(companyId,  doc);//doc.get(Field.UID), }

		public static void deleteServiceComponentGroup(
				long companyId, long groupId, long folderId, long scgID, String name,
				String url, String comments, String title, String description, Date modifiedDate, String[] tagsEntries,
				ExpandoBridge expandoBridge)
			throws SearchException {

			Document doc = getEntryDocument(
					companyId, groupId, folderId, scgID, name, url, comments, title, description,
					modifiedDate, tagsEntries, expandoBridge);
			_log.info("updateServiceComponentGroup:"+scgID);
			SearchEngineUtil.deleteDocument(companyId, doc.get(Field.UID));

		}

//		public DocumentSummary getDocumentSummary(Document doc, PortletURL portletURL) {
//			// TODO Auto-generated method stub
//			// Title
	//
//			String title = doc.get(Field.TITLE);
//			// Content
	//
//			String content = doc.get(Field.DESCRIPTION);
	//
//			content = StringUtil.shorten(content, 200);
	//
//			// Portlet URL
	//
//			String entryId = doc.get(Field.ENTRY_CLASS_PK);
	//
//			portletURL.setParameter("struts_action", "/spsc/servicecomponentgroup_action");
//			portletURL.setParameter("entryId", entryId);
	//
//			_log.info("getDocumentSummary:"+entryId);
	//
//			return new DocumentSummary(title, content, portletURL);
//		}

		public void reIndex(String[] ids) throws SearchException {

			// TODO Auto-generated method stub

			try {
				//ServiceComponentsLocalServiceUtil.reIndex(ids);
				_log.info("ServiceComponents.reIndex:"+ids[0]);
				ServiceHelper.reIndex(ids);
			}
			catch (Exception e) {
				throw new SearchException(e);
			}

		}

		public void reIndex(String className, long classPK) throws SearchException {

			// TODO Auto-generated method stub

			try {
				_log.info("reIndex:"+classPK);
				//ServiceComponentsLocalServiceUtil.reIndex(classPK);
				ServiceHelper.reIndex(classPK);
			}
			catch (Exception e) {
				throw new SearchException(e);
			}

		}

		public void doDelete(Object obj) throws SearchException {
			ServiceComponentGroup scg = (ServiceComponentGroup)obj;
			_log.info("doDelete:"+obj);
			Document document = new DocumentImpl();

			document.addUID(PORTLET_ID, scg.getScgId());

			SearchEngineUtil.deleteDocument(companyId, document.get(Field.UID));

		}

		public Document doGetDocument(Object obj) throws SearchException {

			// TODO Auto-generated method stub

			//return null;

			ServiceComponentGroup scg = (ServiceComponentGroup)obj;

			_log.info("getDocument:"+scg.getName());
			_log.info("getEntryDocument:"+scg.getScgId());

			Document doc = new DocumentImpl();

			doc.addUID(PORTLET_ID, scg.getScgId());

			doc.addModifiedDate(scg.getDateModified());

			doc.addKeyword(Field.COMPANY_ID, companyId);
			doc.addKeyword(Field.PORTLET_ID, PORTLET_ID);
			//doc.addKeyword(Field.GROUP_ID, groupId);

			doc.addText(Field.TITLE, scg.getName());
//			doc.addKeyword(Field.TAGS_ENTRIES, tagsEntries);

		//	doc.addKeyword("folderId", folderId);
			doc.addText(Field.TITLE, scg.getName());
			doc.addText(Field.DESCRIPTION, scg.getDescription());
			doc.addKeyword(Field.ENTRY_CLASS_NAME, ServiceComponentGroup.class.getName());
			doc.addKeyword(Field.ENTRY_CLASS_PK, scg.getScgId());
		//	doc.addText(Field.URL, null);
			doc.addText(Field.COMMENTS, scg.getDescription());
	return doc;
		}

		public Summary getSummary(Document document, String snippet,
				PortletURL portletURL) {
			String title = document.get(Field.TITLE);

			String content = snippet;

			if (Validator.isNull(snippet)) {
				content = StringUtil.shorten(document.get(Field.DESCRIPTION), 200);
			}

			String eventId = document.get(Field.ENTRY_CLASS_PK);

			portletURL.setParameter("struts_action", "spmp.membershippackagegrpservices.detail");
			portletURL.setParameter("recId", eventId);

			_log.info("getSummary:"+document);

			return new Summary(title, content, portletURL);

		}

		public void doReindex(Object obj) throws SearchException {
			_log.info("doReindex:"+obj);

			ServiceComponentGroup scg = (ServiceComponentGroup)obj;
			_log.info("doReindex:"+scg.getName());
			Document document = getDocument(scg);

			SearchEngineUtil.updateDocument(companyId, document);

		}

		public void doReindex(String[] ids) throws SearchException {
			_log.info("doReindex:"+ids[0]);
			reIndex( ids);

		}

		public void doReindex(String className, long classPK) throws SearchException {

			try {
			ServiceComponentGroup scg = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroup(classPK);
			_log.info("doReindex classPK:"+classPK);

			reindex(scg);
			}catch (Exception e){_log.error(e); }

		}

		public Hits search(SearchContext searchContext) throws SearchException {
			{

					BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);

					contextQuery.addRequiredTerm(Field.PORTLET_ID, Indexer.PORTLET_ID);

					BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);

					_log.info("Validator.isNotNull:" + Validator.isNotNull(searchContext.getKeywords()));

					if (Validator.isNotNull(searchContext.getKeywords())) {
						try {

								// searchQuery.addTerm(Field.USER_NAME, keywords);

								searchQuery.addTerm(Field.TITLE, searchContext.getKeywords());
								searchQuery.addTerm(Field.DESCRIPTION, searchContext.getKeywords());
								searchQuery.addTerm("extra1", searchContext.getKeywords());
								searchQuery.addTerm("community", searchContext.getKeywords());

								// searchQuery.addTerm(Field.CONTENT, keywords);
								// searchQuery.addTerm(Field.TAGS_ENTRIES, keywords)

						} catch (ParseException e) {

							// TODO Auto-generated catch block

							_log.error(e);
						};
					}

					BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);

				try {
							fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
					} catch (ParseException e) {

						// TODO Auto-generated catch block

						_log.error(e);
					};

					if (searchQuery.clauses().size() > 0) {
						try {
							fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
						} catch (ParseException e) {

							// TODO Auto-generated catch block

							_log.error(e);
						}
					}

					_log.info("fullQuery:" + fullQuery.toString());

					_log.info("fullQuery: searchContext:" + searchContext.getStart()+"-"+searchContext.getEnd());

		return SearchEngineUtil.search(companyId, searchQuery, searchContext.getStart(), searchContext.getEnd());

		}
	}

		@Override
		public String getPortletId() {
			return PORTLET_ID;
		}

		@Override
		protected Summary doGetSummary(Document document, Locale locale,
				String snippet, PortletURL portletURL) throws Exception {

			// TODO Auto-generated method stub

			return null;
		}

**/

}