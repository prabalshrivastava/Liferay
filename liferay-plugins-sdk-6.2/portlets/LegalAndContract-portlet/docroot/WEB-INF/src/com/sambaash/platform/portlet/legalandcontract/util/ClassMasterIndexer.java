package com.sambaash.platform.portlet.legalandcontract.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;
import com.sambaash.platform.srv.legalandcontract.model.ClassMaster;
import com.sambaash.platform.srv.legalandcontract.service.ClassMasterLocalServiceUtil;

public class ClassMasterIndexer extends BaseIndexer {
	
	public static final String[] CLASS_NAMES = { ClassMaster.class.getName() };
	
	public static final String PORTLET_ID = "SPClass_WAR_LegalAndContractportlet";

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		ClassMaster classMaster = (ClassMaster) obj;
		deleteDocument(classMaster.getCompanyId(), classMaster.getSpClassId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		ClassMaster classMaster = (ClassMaster)obj;
		Document document = getBaseModelDocument(PORTLET_ID, classMaster);
		document.addKeyword(Field.ENTRY_CLASS_PK, classMaster.getSpClassId());
		document.addKeyword(Field.COMPANY_ID, classMaster.getCompanyId());
		document.addKeyword(ClassMasterConstants.CLASS_CODE, classMaster.getCode());
		document.addKeyword(ClassMasterConstants.COUNTRY, classMaster.getCountry());
		document.addKeyword(ClassMasterConstants.FILED_BY, classMaster.getFiledBy());
		document.addKeyword(ClassMasterConstants.CUSTOM_FIELD_1, classMaster.getCustomField1());
		document.addKeyword(ClassMasterConstants.CUSTOM_FIELD_2, classMaster.getCustomField2());
		document.addDate(ClassMasterConstants.CUSTOM_DATE_1,classMaster.getCustomDate1());
		document.addDate(ClassMasterConstants.CUSTOM_DATE_2,classMaster.getCustomDate2());
		document.addKeyword(Field.USER_ID, classMaster.getUserId());
		document.addKeyword(Field.USER_NAME, classMaster.getUserName());
		document.addDate(Field.CREATE_DATE, classMaster.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, classMaster.getModifiedDate());
		
		document.addKeyword(ClassMasterConstants.VERSION,classMaster.getVersion());
		document.addKeyword(ClassMasterConstants.ROOT_CLASS_ID,classMaster.getRootSpClassId());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL) {
		String title = document.get(ClassMasterConstants.CLASS_CODE);
		String description = snippet;
		if (Validator.isNull(snippet)) {
			description = document.get(ClassMasterConstants.CLASS_CODE);;
		}
		String entryId = document.get(Field.ENTRY_CLASS_PK);
		portletURL.setParameter("entryId", entryId);
		return new Summary(title, description, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		Map<String,Object> map = (Map<String,Object>) obj;
		ClassMaster classMaster = (ClassMaster) map.get(ClassMasterConstants.CLASS_MASTER);
		boolean isLatest = new Boolean(map.get(ClassMasterConstants.LATEST)+"");
		Document document = getDocument(classMaster);
		document.addKeyword(ClassMasterConstants.LATEST, isLatest);
		SearchEngineUtil.updateDocument(classMaster.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}
	
	protected void reindexEntries(long companyId) throws Exception {
		List<ClassMaster> classs = ClassMasterLocalServiceUtil.getClassMasters(-1, -1);
		if (classs.isEmpty()) {
			return;
		}
		Collection<Document> documents = new ArrayList<Document>();
		for (ClassMaster  classObj: classs) {
			Document document = getDocument(classObj);
			documents.add(document);
		}
		SearchEngineUtil.updateDocuments(companyId, documents);
	}

	@Override
	protected void doReindex(String arg0, long arg1) throws Exception {
		ClassMaster classMaster = ClassMasterLocalServiceUtil.getClassMaster(arg1);
		doReindex(classMaster);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return PORTLET_ID;
		}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker,String entryClassName,
			long entryClassPK, String actionId) throws Exception {
		// TODO Auto-generated method stub
		return super.hasPermission(permissionChecker,entryClassName, entryClassPK, actionId);
	}
	
	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
		return super.search(searchContext);
	}

}
