package com.sambaash.platform.portlet.spcontent.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;

import org.apache.commons.lang.StringUtils;

import com.liferay.compat.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.sambaash.platform.portlet.spcontent.WebKeys;
import com.sambaash.platform.portlet.spcontent.util.ActionUtil;

public class JournalArticleHelper<T> extends AbstractDocumentSearchHelper<JournalArticle> {
	
	private static final String CONSOLIDATED_CONTENT_CATEGORY_FIELD = "SPContentCategories";

	private static final Log LOG = LogFactoryUtil
			.getLog(JournalArticleHelper.class);
	
	private SearchContext searchContext;

	public JournalArticleHelper(ActionRequest actionRequest) {
		super(actionRequest, JournalArticle.class);
	}
	
	@SuppressWarnings("unchecked")
	public JournalArticleHelper(ActionRequest actionRequest, Class<T> indexedClass) {
		super(actionRequest, (Class<JournalArticle>) indexedClass);
	}

	public List<String> searchArticleContentsByCategory(ActionRequest actionRequest)
			throws SystemException, SearchException, ParseException {
		List<String> contentList = new ArrayList<>();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Document> docList = searchDocumentsByCategory();
		for ( Document document : docList ){
			try {
				JournalArticle journalArticleObj = retrieveArticle(themeDisplay, document);
				addArticleContent(contentList, themeDisplay,
						journalArticleObj);					
			} catch (Exception e) {
				LOG.debug(e);
			}
		}	
		return contentList;
	}

	private JournalArticle retrieveArticle(ThemeDisplay themeDisplay,
			Document document) throws PortalException, SystemException {
		JournalArticleResource journalArticleResourceObj = JournalArticleResourceLocalServiceUtil.getJournalArticleResource(Long.parseLong(document.get(Field.ENTRY_CLASS_PK)));
		return JournalArticleLocalServiceUtil.getArticle(themeDisplay.getScopeGroupId(),journalArticleResourceObj.getArticleId());
	}
	
	@Override
	public List<Document> searchDocumentsByCategory() throws SystemException,
			SearchException, ParseException {
		List<Document> docList = super.searchDocumentsByCategory();
		removeConsolidatedWebContentInOrigToAvoidDuplicates(docList);
		docList.addAll(getCategorizedConsolidatedWebContents());
		return docList;
	}

	private void removeConsolidatedWebContentInOrigToAvoidDuplicates(
			List<Document> docList) throws SystemException {
		Iterator<Document> iterator = docList.iterator();
		while(iterator.hasNext()) {
			try {
				Document doc = iterator.next();
				JournalArticle article = retrieveArticle(themeDisplay, doc);
				if (isConsolidatedWebCentent(article)) {
					iterator.remove();
				}
			} catch (Exception e) {
				// do nothing
			}
		}
	}

	private List<Document> getCategorizedConsolidatedWebContents() throws SearchException, ParseException {
		List<Document> consolidatedWebContents = new ArrayList<Document>();
		if (parentCatId > -1) {

			SearchContext searchContext = getSearchContext();
			// parent category id here
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
			BooleanQuery searchQuery = ActionUtil.newSearchQuery(searchContext, themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
			searchQuery.add(TermQueryFactoryUtil.create(searchContext, Field.ENTRY_CLASS_NAME, indexedClass.getName()), BooleanClauseOccur.MUST);
			searchQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, parentCatId); 
            fullQuery.add(searchQuery, BooleanClauseOccur.MUST); 
             
			Sort sort = SortFactoryUtil.create(Field.MODIFIED_DATE, Sort.LONG_TYPE, true);
			searchContext.setSorts(sort);

			Hits hits = doDocumentSearch(searchContext, themeDisplay.getCompanyId(), fullQuery, -1, -1);

			LOG.debug("getCategorizedConsolidatedWebContents query = "+fullQuery);
			for ( Document document : hits.getDocs() ) {
				try {
					JournalArticle article = retrieveArticle(themeDisplay, document);
					if (isConsolidatedWebCentent(article)) {
						consolidatedWebContents.add(document);											
					}
				} catch (Exception e) {
					LOG.error(e);
				}
			}			
		}
		return consolidatedWebContents;
	}

	private void addArticleContent(List<String> contentList,
			ThemeDisplay themeDisplay, JournalArticle journalArticleObj) {
		String content="";
		try {
			JournalArticle cloneArticle = (JournalArticle) journalArticleObj.clone();
			if (isConsolidatedWebCentent(cloneArticle)) {
				extractCategorizedContent(contentList, cloneArticle);				
			} else {
				String articleId = journalArticleObj.getArticleId();
				JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(
						themeDisplay.getScopeGroupId(), articleId, "",
						themeDisplay.getLanguageId(), themeDisplay);
				content = articleDisplay.getContent();							
				contentList.add(content);
			}
		} catch (Exception e) {
			LOG.debug(e);
		}
	}

	private boolean isConsolidatedWebCentent(JournalArticle article) {
		return article.getContent().contains(CONSOLIDATED_CONTENT_CATEGORY_FIELD);
	}

	private void extractCategorizedContent(List<String> contentList, JournalArticle cloneArticle) throws DocumentException {
		LOG.debug("Extracting categorization in consolidated web content");
		com.liferay.portal.kernel.xml.Document origDoc = SAXReaderUtil.read(cloneArticle.getContent());
		XPath xPathSelector = SAXReaderUtil.createXPath("//dynamic-element[@name = '" + CONSOLIDATED_CONTENT_CATEGORY_FIELD + "']/..");
		for(Node node : xPathSelector.selectNodes(origDoc)) {
			String categories = node.valueOf("./dynamic-element[@name = '" + CONSOLIDATED_CONTENT_CATEGORY_FIELD + "']/dynamic-content/text()");
			if (StringUtils.isNotBlank(categories)) {
				if (!Arrays.asList(categories.split(",")).contains(contentCategory)) {
					continue;
				}
				try {
					StringBuilder xmlBuilder = new StringBuilder("<root available-locales=\"en_US\" default-locale=\"en_US\">");
					xmlBuilder.append(node.asXML());
					String xml = xmlBuilder.append("</root>").toString();
					JournalArticle cloneArticle2 = (JournalArticle) cloneArticle.clone();
					cloneArticle2.setContent(xml);
					JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(cloneArticle2, 
							cloneArticle2.getTemplateId(), "view", LocaleUtil.toLanguageId(themeDisplay.getLocale()), 
							1, null, themeDisplay);				
					contentList.add(articleDisplay.getContent()
							.replace("column-count: 3", "column-count: 1")
							.replace("column-count: 2", "column-count: 1"));					
				} catch (PortalException | SystemException e) {
					LOG.debug(e);
				}
			}
		}
	}

	@Override
	protected SearchContext getSearchContext() {
		if (searchContext==null) {
			searchContext = ActionUtil.newSearchContext(actionRequest, -1, -1, indexedClass.getName());
		}
		return searchContext;
	}

	@Override
	protected Hits doDocumentSearch(SearchContext searchContext,
			long companyId, BooleanQuery fullQuery, int start,
			int end) throws SearchException {
		fullQuery.addRequiredTerm("head", Boolean.TRUE);
		Hits hits = SearchEngineUtil.search(searchContext.getSearchEngineId(),
				companyId, fullQuery, -1, -1);
		return hits;
	}

}
