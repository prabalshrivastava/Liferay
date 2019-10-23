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
import com.sambaash.platform.product.util.SPProductConstants;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.persistence.FeeTypeActionableDynamicQuery;

public class FeeTypeIndexer extends BaseIndexer {

	private static final Log _log = LogFactoryUtil.getLog(FeeTypeIndexer.class);

	public static final String[] CLASS_NAMES = { FeeType.class.getName() };

	public static final String PORTLET_ID = SPProductConstants.PORTLET_ID;

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		FeeType feeType = (FeeType) obj;
		deleteDocument(feeType.getCompanyId(), feeType.getSpFeeTypeId());
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

		FeeType feeType = (FeeType) obj;
		Document document = null;
		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Indexing FeeType " + feeType.getFeeType());
			}
			document = getBaseModelDocument(PORTLET_ID, feeType);
			// adding UID check as we are using multiple indexers in the same
			// portlet, inorder to avoid the chances of over-riding.
			document.addUID(PORTLET_ID, feeType.getSpFeeTypeId(), FeeType.class.getName());
			document.addKeyword(Field.TITLE, feeType.getFeeType());
			document.addKeyword("spFeeTypeId", feeType.getSpFeeTypeId());
			document.addKeyword("feeType", feeType.getFeeType());
			document.addKeyword("feeTypeName", feeType.getFeeTypeName());
			document.addKeyword("feeTypeDesc", feeType.getFeeTypeDesc());
			//document.addKeyword("groupId", feeType.getGroupId());
			//document.addKeyword("companyId", feeType.getCompanyId());
			document.addKeyword("misc", feeType.getMisc());
			//document.addKeyword("modifiedDate", feeType.getModifiedDate());
			document.addKeyword("title_lower", feeType.getFeeType().toLowerCase());
			

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
		FeeType feeType = (FeeType) obj;
		Document doc = getDocument(obj);
		SearchEngineUtil.updateDocument(SearchEngineUtil.getSearchEngineId(doc), feeType.getCompanyId(), doc, true);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		
		FeeType feeType = FeeTypeLocalServiceUtil.getFeeType(classPK);
		doReindex(feeType);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	private void reindexEntries(long companyId) throws SystemException, PortalException {
		// reference DLFileEntryIndexer
		ActionableDynamicQuery query = new FeeTypeActionableDynamicQuery() {

			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				FeeType feeType = (FeeType) object;
				Document document = getDocument(feeType);

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
