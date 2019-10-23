package com.sambaash.platform.spshopping.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.spshopping.SPShoppingConstants;
import com.sambaash.platform.srv.spshopping.model.SPDiscount;
import com.sambaash.platform.srv.spshopping.model.SPSellingItem;
import com.sambaash.platform.srv.spshopping.model.SPSellingPackage;
import com.sambaash.platform.srv.spshopping.service.SPDiscountLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPSellingPackageLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SPSellingPackageIndexer extends BaseIndexer {
	
	private static Log _log = LogFactoryUtil.getLog(SPSellingPackageIndexer.class);
	
	public static final String[] CLASS_NAMES = { SPSellingPackage.class.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return SPShoppingConstants.PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		SPSellingPackage pkg = (SPSellingPackage) obj;
		deleteDocument(pkg.getCompanyId(), pkg.getSpSellingPackageId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		SPSellingPackage pkg = (SPSellingPackage) obj;
		Document document = getBaseModelDocument(
				SPShoppingConstants.PORTLET_ID, pkg);
		try {
			document.addText(SPShoppingConstants.NAME, pkg.getTitle());
			document.addText(SPShoppingConstants.SHORT_DESCRIPTION,
					pkg.getShortDescription());
			document.addText(SPShoppingConstants.LONG_DESCRIPTION,
					pkg.getLongDescription());
			document.addText(SPShoppingConstants.ITEM_CODE, pkg.getPkgCode());
			document.addKeyword("needPayment", pkg.isNeedsPayment());
			
			//TODO not complete
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {
		if (Validator.isNull(snippet)) {
			snippet = document.get(SPShoppingConstants.NAME);
		}
		String entryId = document.get(Field.ENTRY_CLASS_PK);
		portletURL.setParameter(SPShoppingConstants.ID, entryId);
		return new Summary(snippet, snippet, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		SPSellingPackage pkg = (SPSellingPackage) obj;
		Document document = getDocument(pkg);
		SearchEngineUtil.updateDocument(this.getSearchEngineId(),
				pkg.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		SPSellingPackage discount = SPSellingPackageLocalServiceUtil.getSPSellingPackage(classPK);
		doReindex(discount);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		List<SPSellingPackage> list = SPSellingPackageLocalServiceUtil.getSPSellingPackages(-1, -1);
		if (list.isEmpty()) {
			return;
		}
		Collection<Document> documents = new ArrayList<Document>();
		for (SPSellingPackage classObj: list) {
			Document document = getDocument(classObj);
			documents.add(document);
		}
		SearchEngineUtil.updateDocuments(companyId, documents);	
	
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return SPShoppingConstants.PORTLET_ID;
	}

}
