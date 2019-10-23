package com.sambaash.platform.product.indexer;

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
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.sambaash.platform.product.util.SPProductConstants;
import com.sambaash.platform.srv.model.Certificate;
import com.sambaash.platform.srv.service.CertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.persistence.CertificateActionableDynamicQuery;

public class CertificateIndexer extends BaseIndexer {

	private static final Log _log = LogFactoryUtil.getLog(CertificateIndexer.class);

	public static final String[] CLASS_NAMES = { Certificate.class.getName() };

	public static final String PORTLET_ID = SPProductConstants.PORTLET_ID;

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Certificate certificate = (Certificate) obj;
		deleteDocument(certificate.getCompanyId(), certificate.getSpCertificatetId());
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

		Certificate certificate = (Certificate) obj;
		Document document = null;
		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Indexing Certificate " + certificate.getSpCertificatetId());
			}
			document = getBaseModelDocument(PORTLET_ID, certificate);
			// adding UID check as we are using multiple indexers in the same
			// portlet, inorder to avoid the chances of over-riding.
			document.addUID(PORTLET_ID, certificate.getSpCertificatetId(), Certificate.class.getName());
			document.addKeyword(Field.TITLE, certificate.getTitle());
			document.addKeyword("attachmentFolderId", certificate.getAttachmentFolderId());
			document.addKeyword("title", certificate.getTitle());
			document.addKeyword("level", certificate.getLevel());
			document.addKeyword("description", certificate.getDescription());
			document.addKeyword("title_lower", certificate.getTitle().toLowerCase().trim());
			document.addKeyword("certificateId", certificate.getSpCertificatetId());
			
			AssetCategory certificateNameAC = AssetCategoryLocalServiceUtil.getCategory(certificate.getLevel());
			document.addKeyword("levelName", certificateNameAC.getName());
			document.addKeyword("levelName_lower", certificateNameAC.getName().toLowerCase().trim());
			
			AssetCategory certificateTypeAC = AssetCategoryLocalServiceUtil.getCategory(certificate.getCertificateType());
			document.addKeyword("typeName", certificateTypeAC.getName());
			document.addKeyword("typeName_lower", certificateTypeAC.getName().toLowerCase().trim());

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
		Certificate certificate = (Certificate) obj;
		Document doc = getDocument(obj);
		SearchEngineUtil.updateDocument(SearchEngineUtil.getSearchEngineId(doc), certificate.getCompanyId(), doc, true);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Certificate certificate = CertificateLocalServiceUtil.getCertificate(classPK);
		doReindex(certificate);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	private void reindexEntries(long companyId) throws SystemException, PortalException {
		// reference DLFileEntryIndexer
		ActionableDynamicQuery query = new CertificateActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				Certificate certificate = (Certificate) object;
				Document document = getDocument(certificate);

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
