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
import com.sambaash.platform.srv.spshopping.service.SPDiscountLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SPDiscountIndexer extends BaseIndexer {

	private static Log _log = LogFactoryUtil.getLog(SPDiscountIndexer.class);
	
	public static final String[] CLASS_NAMES = { SPDiscount.class.getName() };

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
		SPDiscount disc = (SPDiscount) obj;
		deleteDocument(disc.getCompanyId(), disc.getSpDiscountId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		SPDiscount discount = (SPDiscount) obj;
		Document document = getBaseModelDocument(
				SPShoppingConstants.PORTLET_ID, discount);
		try {
			document.addText(SPShoppingConstants.NAME, discount.getTitle());
			document.addKeyword(SPShoppingConstants.ATTRIB_PKGID, discount.getPackageId());
			document.addText(SPShoppingConstants.SHORT_DESCRIPTION,
					discount.getDescription());
			document.addText(SPShoppingConstants.ITEM_CODE, discount.getCouponCode());
			document.addDate(SPShoppingConstants.START_DATE, discount.getStartDate());
			document.addDate(SPShoppingConstants.END_DATE, discount.getEndDate());
			document.addKeyword(SPShoppingConstants.MIN_QUANTITY, discount.getMinQuantity());
			document.addKeyword(SPShoppingConstants.MAX_QUANTITY, discount.getMaxQuantity());
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
		SPDiscount disc = (SPDiscount) obj;
		Document document = getDocument(disc);
		SearchEngineUtil.updateDocument(this.getSearchEngineId(),
				disc.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		SPDiscount discount = SPDiscountLocalServiceUtil.getSPDiscount(classPK);
		doReindex(discount);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		List<SPDiscount> list = SPDiscountLocalServiceUtil.getSPDiscounts(-1, -1);
		if (list.isEmpty()) {
			return;
		}
		Collection<Document> documents = new ArrayList<Document>();
		for (SPDiscount classObj: list) {
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
