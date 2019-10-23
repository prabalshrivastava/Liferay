package com.sambaash.platform.portlet.spsc.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

import java.util.Date;
import java.util.List;
/**
import sambaash.platform.servicecomponent.indexer.Indexer;
import sambaash.platform.srv.servicecomponent.model.ServiceComponentGroup;
import sambaash.platform.srv.servicecomponent.model.ServiceComponents;
import sambaash.platform.srv.servicecomponent.service.ServiceComponentGroupLocalServiceUtil;
import sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil;
**/
public class ServiceHelper {

	private static long companyId = PortalUtil.getDefaultCompanyId(); // WARNING -
	// please ensure
	// that it is
	// done
// correctly
/**
private static Log _log = LogFactoryUtil
.getLog(ServiceHelper.class);

public static List<ServiceComponents> getServiceComponents(long scgId)
throws SystemException {
_log.info("ServiceComponents with scgId:"
+ scgId);

return ServiceComponentsLocalServiceUtil.findByServiceComponentsScgId(scgId);

}

public static void reIndex(long entryId) throws SystemException {
if (SearchEngineUtil.isIndexReadOnly()) {
return;
}

ServiceComponentGroup entry = null;
try {
entry = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroup(entryId);
} catch (PortalException e) {
// TODO Auto-generated catch block
_log.error(e);
}

if (entry == null) {
return;
}

reIndex(entry);
}

public static void reIndex(ServiceComponentGroup entry) throws SystemException {

// com.liferay.portal.model.User logedInUser =
// com.liferay.portal.util.PortalUtil.getUser(request);

long groupId = 0;

long folderId = 0;

long scgID = entry.getPrimaryKey();

String name = entry.getName();
String url = null;

String comments = entry.getDescription();

String title = entry.getName();

String description = entry.getDescription();

Date modifiedDate = new Date();

String[] tagsEntries = null;

try {
Indexer.updateServiceComponentGroup(companyId, groupId, folderId,
scgID, name, url, comments, title, description,
modifiedDate, tagsEntries, null);
_log.info("Reindexing updateServiceComponentGroupg " + scgID+">>"+ name);

} catch (Exception se) {
_log.error("Reindexing " + scgID, se);
_log.info("Adding indexing " + scgID);

}

}

public static void index(ServiceComponentGroup entry) throws SystemException {

// com.liferay.portal.model.User logedInUser =
// com.liferay.portal.util.PortalUtil.getUser(request);

_log.error("Indexing " + entry.getName());

long groupId = 0;

long folderId = 0;

long scgID = entry.getPrimaryKey();

String name = entry.getName();
String url = null;

String comments = entry.getDescription();

String title = entry.getName();

String description = entry.getDescription();

Date modifiedDate = new Date();

String[] tagsEntries = null;

try {
Indexer.addServiceComponentGroup(companyId, groupId, folderId,
scgID, name, url, comments, title, description,
modifiedDate, tagsEntries, null);

} catch (Exception e) {
// TODO Auto-generated catch block
_log.error("Indexing " + scgID, e);
}

}

public static void removeIndex(ServiceComponentGroup entry) throws SystemException {

// com.liferay.portal.model.User logedInUser =
// com.liferay.portal.util.PortalUtil.getUser(request);

long groupId = 0;

long folderId = 0;

long scgID = entry.getPrimaryKey();

String name = entry.getName();
String url = null;

String comments = entry.getDescription();

String title = entry.getName();

String description = entry.getDescription();

Date modifiedDate = new Date();

String[] tagsEntries = null;

try {
Indexer.deleteServiceComponentGroup(companyId, groupId, folderId,
scgID, name, url, comments, title, description,
modifiedDate, tagsEntries, null);
} catch (Exception e) {
// TODO Auto-generated catch block
_log.error("Indexing " + scgID, e);
}

}

public static void reIndex(String[] ids) throws SystemException {
if (SearchEngineUtil.isIndexReadOnly()) {
return;
}

long companyId = GetterUtil.getLong(ids[0]);

try {
reIndexEntries(companyId);
} catch (SystemException se) {
throw se;
} catch (Exception e) {
throw new SystemException(e);
}
}

protected static void reIndexEntries(long companyId) throws SystemException {
int count = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroupsCount();

List<ServiceComponentGroup> entries = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroups(0, count);

for (ServiceComponentGroup entry : entries) {
reIndex(entry);

}

}

protected static void reIndexEntries2(long scgId) throws SystemException,
PortalException {

reIndex(ServiceComponentGroupLocalServiceUtil.getServiceComponentGroup(scgId));

}

protected static void reIndexEntries(String name, int start, int end)
throws SystemException {

int count = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroupsCount();

List<ServiceComponentGroup> entries = ServiceComponentGroupLocalServiceUtil.getServiceComponentGroups(0, count);

for (ServiceComponentGroup entry : entries) {
reIndex(entry);
}
}

public static Hits search(long companyId, long groupId, long userId,
long ownerUserId, String keywords, int start, int end)
throws SystemException {
_log.info(keywords);
SearchContext searchContext = new SearchContext();
try {
BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);

contextQuery.addRequiredTerm(Field.PORTLET_ID, Indexer.PORTLET_ID);

BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);

_log.info("Validator.isNotNull:" + Validator.isNotNull(keywords));
if (Validator.isNotNull(keywords)) {

// searchQuery.addTerm(Field.USER_NAME, keywords);
searchQuery.addTerm(Field.TITLE, keywords);
searchQuery.addTerm(Field.DESCRIPTION, keywords);
searchQuery.addTerm("extra1", keywords);
searchQuery.addTerm("community", keywords);
// searchQuery.addTerm(Field.CONTENT, keywords);
// searchQuery.addTerm(Field.TAGS_ENTRIES, keywords);
}

BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);

fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

if (searchQuery.clauses().size() > 0) {
fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
}

_log.info("fullQuery:" + fullQuery.toString());

return null;
//commented by Clark
//return SearchEngineUtil.search(companyId, groupId, userId,
//ServiceComponentGroup.class.getName(), fullQuery, start,
//end);
} catch (Exception e) {
throw new SystemException(e);
}
}
**/
}
