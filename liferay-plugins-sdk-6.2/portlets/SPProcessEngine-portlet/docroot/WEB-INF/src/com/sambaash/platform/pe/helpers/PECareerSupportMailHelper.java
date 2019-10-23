package com.sambaash.platform.pe.helpers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashUtil;

public class PECareerSupportMailHelper {

	private static Log _log = LogFactoryUtil.getLog(PECareerSupportMailHelper.class);

	public static String searchByDomain(PEDataSource ds, String format) {

		if (Validator.isNotNull(format)) {
			String domainAreas = StringPool.BLANK;
			String searchByDomainValues = StringPool.BLANK;

			String paramKey = ds.getProcess().getSpPEProcessId() + ".domainAreas.Vocabularies";// "1187449.domainAreas.Vocabularies";

			_log.debug("processId " + ds.getProcess().getSpPEProcessId());

			String vocabularyList = SambaashUtil.getParameter(paramKey, ds.getRequestData().getScopeGroupId());
			String[] vocabularyArray = vocabularyList.split(StringPool.COMMA);

			try {

				JSONObject dataJ = JSONFactoryUtil
						.createJSONObject(GetterUtil.getString(ds.getProcessState().getData()));
				domainAreas = dataJ.getString("domainAreas");

				_log.debug("domainAreas pemailhelper" + domainAreas);

				if (domainAreas.contains("[") && domainAreas.contains("]")) {
					domainAreas = domainAreas.substring((domainAreas.indexOf("[") + 1), domainAreas.indexOf("]"));
				}
				String[] dmnAreasArr = domainAreas.split(StringPool.COMMA);
				for (String domainAreaVal : dmnAreasArr) {
					JSONObject jObject1 = JSONFactoryUtil.createJSONObject(domainAreaVal);
					if (!searchByDomainValues.isEmpty()) {
						searchByDomainValues = searchByDomainValues + StringPool.COMMA + jObject1.getString("value");// "Business
																														// computing";
					} else {
						searchByDomainValues = jObject1.getString("value");
					}
				}

			} catch (Exception e2) {
				_log.error("Error getting json object for domain " + e2.getMessage());
			}

			_log.error("PECareerSupportMailHelper searchByDomainValues " + searchByDomainValues);
			String eventsMatchingText = "There is no upcoming event(s) that match your domain area.  Please stay tuned for further updates";
			if (format.contains("[$EVENT_")) {
				String[] searchByDomainArray = searchByDomainValues.split(StringPool.COMMA);
				String domainCategoryAdded = StringPool.BLANK;
				int j = 0;

				if (Validator.isNotNull(searchByDomainValues)) {

					try {
						for (String vocabulary : vocabularyArray) {
							if (Validator.isNotNull(vocabulary)) {
								List<AssetCategory> categoryIds = AssetCategoryLocalServiceUtil
										.getVocabularyCategories(Long.parseLong(vocabulary), -1, -1, null);// (190731);//Categories(841371,calEvent.getCalendarBookingId());
								for (int l = 0; l < categoryIds.size(); l++) {
									long categoryId = categoryIds.get(l).getCategoryId();
									String categoryName = categoryIds.get(l).getName();
									for (String domainAreaValue : searchByDomainArray) {
										if (categoryName.equalsIgnoreCase(domainAreaValue)) {
											if (!domainCategoryAdded.contains(categoryId + StringPool.COMMA)) {
												domainCategoryAdded = String.valueOf(categoryId) + StringPool.COMMA
														+ domainCategoryAdded;
											}
										}
									}
								}
							}
						}
						_log.error("domain category list matching to event vocabluray " + domainCategoryAdded);
					} catch (NumberFormatException e) {
						_log.error(e.getMessage());
					} catch (SystemException e) {
						_log.error(e.getMessage());
					}

					Hits results;
					Indexer indexer = null;
					indexer = IndexerRegistryUtil.getIndexer(CalendarBooking.class.getName());
					SearchContext searchContext = new SearchContext();
					searchContext.setCompanyId(ds.getCompanyId());
					searchContext.setStart(-1);
					searchContext.setEnd(-1);
					Sort sort = SortFactoryUtil.create("startTime", Sort.LONG_TYPE, false);
					Sort[] sorts = new Sort[] { sort };
					searchContext.setSorts(sorts);
					BooleanQuery categoryBooleanQuery = BooleanQueryFactoryUtil.create(searchContext);
					String[] domainCategoryAddedArray = domainCategoryAdded.split(StringPool.COMMA);
					try {
						for (String searchByDomain : domainCategoryAddedArray) {
							categoryBooleanQuery.addTerm(Field.ASSET_CATEGORY_IDS, searchByDomain);
						}

					} catch (ParseException e1) {
						_log.error("Error adding domain area to searchcontext " + e1.getMessage());
					}
					BooleanClause categoryBooleanClause = BooleanClauseFactoryUtil.create(searchContext,
							categoryBooleanQuery, BooleanClauseOccur.MUST.getName());

					List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
					booleanClauseList.add(categoryBooleanClause);

					BooleanClause[] booleanClauses = new BooleanClause[booleanClauseList.size()];

					searchContext.setBooleanClauses(booleanClauseList.toArray(booleanClauses));

					try {
						results = indexer.search(searchContext);
						_log.debug("indexr reult length " + results.getDocs().length);
						if (results.getDocs().length > 0) {
							eventsMatchingText = "The following are the upcoming events that match your domain area(s):";
						}
						int k = 0;
						for (int i = 0; i < results.getDocs().length; i++) {
							Document doc = results.doc(i);
							long endDate = GetterUtil.getLong(doc.get("endTime"));
							long startDate = GetterUtil.getLong(doc.get("startTime"));
							_log.debug("startDate " + startDate + " endDate " + endDate);
							Date now = new Date();

							if (Validator.isNotNull(startDate)) {
								if (now.getTime() > startDate) {
									continue;
								} else {
									if (Validator.isNotNull(endDate)) {
										if (now.getTime() > endDate) {
											continue;
										}
									}
								}
							}

							String portalUrl = ds.getRequestData().getPortalUrl();
							String title = GetterUtil.getString(doc.get(Field.TITLE));
							_log.debug("filtered event title " + title);
							String description = GetterUtil.getString(doc.get(Field.DESCRIPTION));
							String imageUrl = StringPool.BLANK;
							imageUrl = getEventsImageUrl(portalUrl, ds.getRequestData().getUser(),
									ds.getRequestData().getScopeGroupId(),
									Long.parseLong(GetterUtil.getString(doc.get("calendarBookingId"))));
							if (Validator.isNotNull(description) && description.length() > 250) {
								description = description.substring(0, 250) + "...";
							}
							String detailUrl = portalUrl + "/event-details/-/event/view_event/"
									+ GetterUtil.getString(doc.get("calendarBookingId")) + "?flagDetail=false";

							String eventsDetailurl = "[$EVENT_DETAIL_URL" + k + "$]";
							String eventImageUrl = "[$EVENT_IMAGE" + k + "$]";
							String eventTitle = "[$EVENT_TITLE" + k + "$]";
							String eventDescription = "[$EVENT_DESCRIPTION" + k + "$]";
							String startVar = "[$EVENT_START" + k + "$]";

							if (format.contains(eventsDetailurl)) {
								format = StringUtil.replace(format,
										new String[] { startVar, eventsDetailurl, eventImageUrl, eventsDetailurl,
												eventTitle, eventDescription },
										new String[] { StringPool.BLANK, detailUrl, imageUrl, detailUrl, title,
												description });
							}

							j = k + 1;
							k = k + 1;
						}
					} catch (SearchException e) {
						_log.error("Error getting events matching domainarea " + e.getMessage());
					}
				}

				String strt = "[$EVENT_START" + j + "$]";
				if (format.contains(strt)) {
					int stIndex = format.indexOf(strt);
					int endIndex = format.lastIndexOf("[$EVENT_END$]");
					String cntToBeRemoved = format.substring(stIndex, endIndex);
					format = format.replace(cntToBeRemoved, StringPool.BLANK);
					format = StringUtil.replace(format, new String[] { "[$EVENT_END$]" },
							new String[] { StringPool.BLANK });
				} else {
					format = StringUtil.replace(format, new String[] { "[$EVENT_END$]" },
							new String[] { StringPool.BLANK });
				}
			}

			format = StringUtil.replace(format, new String[] { "[$DOMAIN_AREAS$]", "[$GENARAL_TEXT$]" },
					new String[] { searchByDomainValues, eventsMatchingText });
			_log.debug("actual content %%%% " + format);

		}

		return format;

	}

	private static String getEventsImageUrl(String portalUrl, User user, long respositoryId, long calendarBookingId) {
		long parentFolderId = 0;
		String imageUrl = null;
		_log.debug("respositoryId " + respositoryId + " calendarBookingId " + calendarBookingId);
		try {
			PermissionUtil.initializeAdminPermissionChecker();
			Folder folder = DLAppServiceUtil.getFolder(respositoryId, 0, "EventsImages");
			_log.debug("folder " + folder);
			if (folder != null) {
				parentFolderId = folder.getFolderId();
				_log.debug("parentFolderId " + parentFolderId);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		try {
			Folder subFolder = DLAppServiceUtil.getFolder(respositoryId, parentFolderId, "Events_" + calendarBookingId);

			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(respositoryId, subFolder.getFolderId());
			_log.debug("fileEntries " + fileEntries);
			for (FileEntry file : fileEntries) {
				imageUrl = portalUrl + "/documents/" + respositoryId + "/" + subFolder.getFolderId() + "/"
						+ file.getTitle();
				_log.debug("imageUrl " + imageUrl);
				break;
			}
			PermissionUtil.resetPermissionChecker(user);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return imageUrl;
	}

}
