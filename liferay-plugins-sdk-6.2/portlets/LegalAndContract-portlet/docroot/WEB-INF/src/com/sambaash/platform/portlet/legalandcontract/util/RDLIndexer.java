package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.model.Litigation;
import com.sambaash.platform.srv.legalandcontract.model.RDL;
import com.sambaash.platform.srv.legalandcontract.service.LitigationLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.RDLLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class RDLIndexer extends BaseIndexer {
	
	private static Log _log = LogFactoryUtil.getLog(RDLIndexer.class);

	public static final String[] CLASS_NAMES = { RDL.class.getName() };

	public static final String PORTLET_ID = LitigationConstants.PORTLET_ID;

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		RDL rdl = (RDL) obj;
		deleteDocument(rdl.getCompanyId(), rdl.getSpRdlId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		Document document = null;
		try {
			RDL rdl = (RDL) obj;
			document = getBaseModelDocument(PORTLET_ID, rdl);

			document.addKeyword(Field.ENTRY_CLASS_PK, rdl.getSpRdlId());
			document.addKeyword(LitigationConstants.LITIGATION_ID, rdl.getSpLitigationId());
			document.addKeyword(Field.COMPANY_ID, rdl.getCompanyId());

			document.addDate(LitigationConstants.RESPONSE_DEADLINE, rdl.getResponseDeadline());
			document.addKeyword(LitigationConstants.ALERT_BEFORE, rdl.getAlertBefore());
			Utils.addIndexKeywords(document, LitigationConstants.CLAIMS_REMARKS, rdl.getClaimsRemarks());

			try {
				//
				Litigation litigation = LitigationLocalServiceUtil.getLitigation(rdl.getSpLitigationId());
				LitigationIndexer.addSearchFields(document, litigation);

				List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil
						.getCategories(Litigation.class.getName(), litigation.getSpLitigationId());

				long[] assetCategoryIds = StringUtil
						.split(ListUtil.toString(assetCategories, AssetCategory.CATEGORY_ID_ACCESSOR), 0L);

				document.addKeyword(Field.ASSET_CATEGORY_IDS, assetCategoryIds);

				String[] assetCategoryNames = StringUtil
						.split(ListUtil.toString(assetCategories, AssetCategory.NAME_ACCESSOR));

				document.addText(Field.ASSET_CATEGORY_NAMES, assetCategoryNames);

			} catch (Exception ex) {
				_log.error(ex.getMessage());
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) {

		return new Summary("", "", portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		RDL rdl = (RDL) obj;
		Document document = getDocument(rdl);
		SearchEngineUtil.updateDocument(rdl.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	protected void reindexEntries(long companyId) throws Exception {
		List<RDL> rdls = RDLLocalServiceUtil.getRDLs(-1, -1);
		if (rdls.isEmpty()) {
			return;
		}
		Collection<Document> documents = new ArrayList<Document>();
		for (RDL rdl : rdls) {
			Document document = getDocument(rdl);
			documents.add(document);
		}
		SearchEngineUtil.updateDocuments(companyId, documents);
	}

	@Override
	protected void doReindex(String arg0, long arg1) throws Exception {
		RDL rdl = RDLLocalServiceUtil.getRDL(arg1);
		doReindex(rdl);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return PORTLET_ID;
	}

	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
		return super.search(searchContext);
	}

}
