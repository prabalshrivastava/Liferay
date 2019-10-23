package com.sambaash.platform.product.indexer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.sambaash.platform.product.util.SPProductConstants;
import com.sambaash.platform.srv.model.CompetencyUnit;
import com.sambaash.platform.srv.model.Outline;
import com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.OutlineLocalServiceUtil;
import com.sambaash.platform.srv.service.persistence.OutlineActionableDynamicQuery;

public class OutlineIndexer extends BaseIndexer {

	private static final Log _log = LogFactoryUtil.getLog(OutlineIndexer.class);

	public static final String[] CLASS_NAMES = { Outline.class.getName() };

	public static final String PORTLET_ID = SPProductConstants.PORTLET_ID;

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Outline outline = (Outline) obj;
		deleteDocument(outline.getCompanyId(), outline.getSpOutlineId());
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return PORTLET_ID;
	}

	public boolean hasPermission(PermissionChecker permissionChecker, long entryClassPK, String actionId)
			throws Exception {
		// TODO: have to look into it
		// return super.hasPermission(permissionChecker, entryClassPK,
		// actionId);
		return true;
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {

		Outline outline = (Outline) obj;
		Document document = null;
		CompetencyUnit competencyUnit = null;
		String competencyDesc = StringPool.BLANK;
		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Indexing Outline " + outline.getSpOutlineId());
			}
			document = getBaseModelDocument(PORTLET_ID, outline);
			// adding UID check as we are using multiple indexers in the same
			// portlet, inorder to avoid the chances of over-riding.
			document.addUID(PORTLET_ID, outline.getSpOutlineId(), Outline.class.getName());

			AssetCategory oAsset = AssetCategoryLocalServiceUtil.getAssetCategory(outline.getOutlineType());

			if (Validator.isNull(competencyUnit)) {
				competencyUnit = CompetencyUnitLocalServiceUtil.getCompetencyUnit(outline.getSpCompetencyUnitId());
			}

			if (competencyUnit != null && competencyUnit.getSpCompetencyUnitId() != outline.getSpCompetencyUnitId()) {
				competencyUnit = CompetencyUnitLocalServiceUtil.getCompetencyUnit(outline.getSpCompetencyUnitId());
			}
			
			competencyDesc = HtmlUtil.stripHtml(competencyUnit.getCompetencyUnitDesc());
			
			document.addKeyword("outlineId", outline.getSpOutlineId());
			document.addKeyword("competencyCode", competencyUnit.getCompetencyUnitCode());
			document.addKeyword("competencyDesc", competencyDesc);
			document.addKeyword("outlineType", oAsset.getName());
			document.addKeyword("competencyCode_lower", competencyUnit.getCompetencyUnitCode().toLowerCase().trim());
			document.addKeyword("competencyDesc_lower", competencyDesc.toLowerCase().trim());
			document.addKeyword("outlineType_lower", oAsset.getName().toLowerCase().trim());
			

		} catch (Exception ex) {
			_log.error("Error while indexing document " + obj, ex);
		}
		return document;

	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL)
			throws Exception {
		return null;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		Outline outline = (Outline) obj;
		Document doc = getDocument(obj);
		SearchEngineUtil.updateDocument(SearchEngineUtil.getSearchEngineId(doc), outline.getCompanyId(), doc, true);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Outline outline = OutlineLocalServiceUtil.getOutline(classPK);
		doReindex(outline);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	private void reindexEntries(long companyId) throws SystemException, PortalException {
		// reference DLFileEntryIndexer
		ActionableDynamicQuery query = new OutlineActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				Outline outline = (Outline) object;
				Document document = getDocument(outline);

				if (document != null) {
					addDocument(document);
				}
			}
		};
		query.setClassLoader(PortletClassLoaderUtil.getClassLoader(PORTLET_ID));
		query.setCompanyId(companyId);
		// this method internall query the all rows , calls performaction method
		// on each object.
		query.performActions();
	}

}
