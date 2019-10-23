package com.sambaash.platform.portlet.legalandcontract.search;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
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
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.util.AgencyConstants;
import com.sambaash.platform.portlet.legalandcontract.util.FilesUpload;
import com.sambaash.platform.portlet.legalandcontract.util.LegalConstants;
import com.sambaash.platform.portlet.legalandcontract.util.LitigationConstants;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.legalandcontract.service.LitigationLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class TrademarksSearch extends LegalContractSearch {

	private static List<SearchField> listFiellds;
	private static boolean initialized;
	private static Log _log = LogFactoryUtil.getLog(TrademarksSearch.class);

	public TrademarksSearch(PortletRequest request, PortletResponse response) {
		super(request, response, Trademarks.class.getName());
	}

	protected List<SearchField> getSearchFields() {
		if (!initialized) {
			listFiellds = new ArrayList<SearchField>();

			SearchField sf = SearchFieldFactory.getSearchFieldText(TrademarksConstants.ALL_SEARCH_COLUMN, TrademarksConstants.ALL_SEARCH,	TrademarksConstants.ALL_SEARCH);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchFieldText(TrademarksConstants.REGISTRATION_NUMBER_COLUMN, TrademarksConstants.REGISTRATION_NUMBER, TrademarksConstants.REGISTRATION_NUMBER);
			listFiellds.add(sf);
			
			sf = SearchFieldFactory.getSearchFieldDate(TrademarksConstants.APPLICATION_DATE_COLUMN, TrademarksConstants.APPLICATION_DATE, TrademarksConstants.APPLICATION_DATE);
			listFiellds.add(sf);
			
			sf = SearchFieldFactory.getSearchFieldDate(TrademarksConstants.FIRST_REG_DATE_COLUMN, TrademarksConstants.FIRST_REG_DATE, TrademarksConstants.FIRST_REG_DATE);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchFieldDate(TrademarksConstants.PRIORITY_DATE_COLUMN, TrademarksConstants.PRIORITY_DATE, TrademarksConstants.PRIORITY_DATE);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchFieldDate(TrademarksConstants.EXPIRY_DATE_COLUMN, TrademarksConstants.EXPIRY_DATE, TrademarksConstants.EXPIRY_DATE);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchField(LegalConstants.MODIFIED_IN_LABEL, LegalConstants.MODIFIED_TIME, SearchField.DROPDOWN);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchField(TrademarksConstants.PENDING_RENEWAL_LABEL, TrademarksConstants.PENDING_RENEWAL,SearchField.DROPDOWN);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchField(TrademarksConstants.TRADEMARK_HISTORY_LABEL, TrademarksConstants.TRADEMARK_HISTORY, SearchField.DROPDOWN);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchFieldCategory(TrademarksConstants.COUNTRY_COLUMN, TrademarksConstants.COUNTRY,
					TrademarksConstants.COUNTRY, TrademarksConstants.COUNTRY_VOC_ID);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchFieldText(TrademarksConstants.TRADEMARK_COLUMN, TrademarksConstants.TRADEMARK, TrademarksConstants.TRADEMARK_KEY);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchFieldText(TrademarksConstants.APPLICATION_NO_COLUMN, TrademarksConstants.APPLICATION_NO,TrademarksConstants.APPLICATION_NO);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchFieldText(TrademarksConstants.INTERNATIONAL_REG_NUM_COLUMN,	TrademarksConstants.INTERNATIONAL_REG_NUM, TrademarksConstants.INTERNATIONAL_REG_NUM);
			listFiellds.add(sf);

			
			sf = SearchFieldFactory.getSearchFieldCategory(TrademarksConstants.STATUS_COLUMN, TrademarksConstants.STATUS,
					TrademarksConstants.STATUS,  TrademarksConstants.STATUS_VOC_ID);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchFieldCategory(TrademarksConstants.CLASS_COLUMN, TrademarksConstants.CLASS_CODE,
					TrademarksConstants.CLASS_CODE,  TrademarksConstants.CLASS_CODE_VOC_ID);
			listFiellds.add(sf);

			sf = SearchFieldFactory.getSearchFieldCategory(TrademarksConstants.REGISTERED_OWNER_COLUMN, TrademarksConstants.REGISTERED_OWNER,
					TrademarksConstants.REGISTERED_OWNER, TrademarksConstants.REGISTERED_OWNER_VOC_ID);
			listFiellds.add(sf);

			initialized = true;
		}

		return listFiellds;

	}

	public void extraSetup() {
		request.setAttribute("showExports", true);
	}

	public SearchContainer getSearchContainer() throws WindowStateException, PortalException {
		boolean editPermission = false;
		String imageHtml = TrademarksConstants.TRADEMARK_LOGO_IMG_FORMAT;// "<img border='2' src='%s' style=max-width:60px max-height:150px>";
		try {
			LegalPermissionUtil.authorize(request, TrademarksConstants.PORTLET_ID,
					TrademarksConstants.ACTION_KEY_EDIT_TRADEMARK);
			editPermission = true;
		} catch (Exception e) {
			_log.error(e);
		}

		PortletURL portletURL = getRenderUrl(TrademarksConstants.PORTLET_ID);

		List<String> headerNames = new ArrayList<String>();
		headerNames.add(TrademarksConstants.TRADEMARKS_COLUMN);
		headerNames.add(TrademarksConstants.COUNTRY_COLUMN);
		headerNames.add(TrademarksConstants.REGISTERED_OWNER_COLUMN);
		headerNames.add(TrademarksConstants.APPLICATION_NO_COLUMN);
		headerNames.add(TrademarksConstants.REGISTRATION_NUMBER_COLUMN);
		headerNames.add(TrademarksConstants.STATUS_COLUMN);
		headerNames.add(TrademarksConstants.APPLICATION_DATE_COLUMN);
		headerNames.add(TrademarksConstants.CLASS_COLUMN);
		headerNames.add(TrademarksConstants.EXPIRY_DATE_COLUMN);
		headerNames.add(TrademarksConstants.CONTENTIOUS_PROCEEDINGS_COLUMN);
		headerNames.add(TrademarksConstants.VERSION);
		if (editPermission) {
			headerNames.add("Edit");
		}
		headerNames.add("Details");

		// create search container, used to display table
		SearchContainer searchContainer = new SearchContainer(request, null, null, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_DELTA, portletURL, headerNames, "There are no Trademarks to display");
		portletURL.setParameter(searchContainer.getCurParam(), String.valueOf(searchContainer.getCurValue()));
	
		// Fill searchparammap to retain the search criteria
		setSearchContainerParamsToSearchParamMap(searchContainer);
		
		// portletURL.setParameter(TrademarksConstants.FROM_PAGE,
		// ParamUtil.getString(request,"andOperator");
		//{advancedSearch=[Ljava.lang.String;@1e66199c, keywords=[Ljava.lang.String;@411b605b, fromPage=[Ljava.lang.String;@6c5317c1, delta=[Ljava.lang.String;@433cb776, resetCur=[Ljava.lang.String;@4730c676, cur=[Ljava.lang.String;@5335917d, andOperator=[Ljava.lang.String;@61e2d038}
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(searchContainer.getStart());
		searchContext.setEnd(searchContainer.getEnd());
		searchContext.setCompanyId(themeDisplay.getUser().getCompanyId());

		setSearchConditions(searchContext);

		Sort sort = SortFactoryUtil.create(LegalConstants.SORT_FIELD, Sort.STRING_TYPE, false);
		Sort sort1 = SortFactoryUtil.create(TrademarksConstants.COUNTRY, Sort.STRING_TYPE, false);
		Sort[] sorts = new Sort[] { sort, sort1 };
		searchContext.setSorts(sorts);

		Indexer indexer = IndexerRegistryUtil.getIndexer(Trademarks.class.getName());
		Hits results = null;
		try {
			results = indexer.search(searchContext);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
		if (results != null) {
			// set count into search container
			searchContainer.setTotal(results.getLength());
			// fill table
			List<ResultRow> resultRows = searchContainer.getResultRows();
			int length = results.getDocs().length;
			PortletURL actionUrl;
			String country = "";
			String classCode = "";
			String trademarkType = "";
			String status;
			String registeredOwnere;
			List<Long> catIds;
			boolean isLatest;
			String rootTMId;
			// AssetCategory category;
			// AgencySearch agencySearch = new AgencySearch(request, response);
			// ClassSearch classSearch = new ClassSearch(request, response);
			LitigationSearch litigationSearch = new LitigationSearch(request, response);
			long classCodeVocId = GetterUtil.getLong(preferences.getValue(TrademarksConstants.CLASS_CODE_VOC_ID, "0"));
			long countryVocId = GetterUtil.getLong(preferences.getValue(TrademarksConstants.COUNTRY_VOC_ID, "0"));
			for (int i = 0; i < length; i++) {
				Document doc = results.doc(i);
				long classPK = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
				ResultRow row = new ResultRow(doc, classPK, i);

				catIds = Utils.getCategoryIds(doc);
				country = Utils.getCategoryName(preferences, TrademarksConstants.COUNTRY_VOC_ID, catIds);
				status = Utils.getCategoryName(preferences, TrademarksConstants.STATUS_VOC_ID, catIds);
				registeredOwnere = Utils.getCategoryName(preferences, TrademarksConstants.REGISTERED_OWNER_VOC_ID,
						catIds);
				classCode = getClassCodes(classCodeVocId, catIds);

				String regNum = doc.get(TrademarksConstants.REGISTRATION_NUMBER);
				String applicationNo = doc.get(TrademarksConstants.APPLICATION_NO);
				rootTMId = doc.get(TrademarksConstants.ROOT_TRADEMARK_ID);

				String folderName = TrademarksSearch.getTrademarksFolderName(rootTMId);
				long logoFolderId = TrademarksSearch.getLogoFolderId(request, folderName);

				trademarkType = GetterUtil.getString(doc.get(TrademarksConstants.TRADEMARK_TYPE));
				if (TrademarksConstants.LOGO.equalsIgnoreCase(trademarkType) && logoFolderId != 0) {
					List<Map<String, String>> logos = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(),
							logoFolderId, false);
					if (Validator.isNotNull(logos) && !logos.isEmpty()) {
						String fileUrl = Utils.getDLFileUrl(request, logos.get(0).get(LegalConstants.FILE_ENTRY_ID));
						row.addText(String.format(imageHtml, fileUrl));
					} else {
						row.addText("");
					}
				} else {
					row.addText(getEscapedString(doc.get(TrademarksConstants.TRADEMARK)));
				}
				row.addText(country);
				row.addText(registeredOwnere);
				row.addText(getEscapedString(applicationNo));
				row.addText(getEscapedString(regNum));
				row.addText(status);
				row.addText(Utils.getDateStrYMD(doc, TrademarksConstants.APPLICATION_DATE));
				row.addText(classCode);
				row.addText(Utils.getDateStrYMD(doc, TrademarksConstants.EXPIRY_DATE));
				Map<String, String> rootTM = getTrademarksMap(
						GetterUtil.getString(doc.get(TrademarksConstants.ROOT_TRADEMARK_ID)), false);
				String litIdsStr = rootTM.get(TrademarksConstants.LITIGATION_IDS);
				if (Validator.isNotNull(litIdsStr)) {
					String[] litIds = litIdsStr.split(",");
					// StringBuilder idsSb = new StringBuilder();
					StringBuilder hrefSb = new StringBuilder();
					String HREF_FORMAT = "<a id='litigation%s' href='%s'>%s</a>";
					for (String litId : litIds) {
						/*
						 * if(idsSb.length() != 0){ idsSb.append(","); }
						 * idsSb.append(litId);
						 */
						Map<String, String> latestLitigation = litigationSearch.getLitigationMap(litId, false);
						// String filedBy =
						// GetterUtil.getString(litigationSearch.getLatestLitigationFiledByRootLitigationId(litId));
						if (Validator.isNotNull(latestLitigation)) {
							// String filedBy =
							// GetterUtil.getString(latestLitigation.get(LitigationConstants.FILED_BY));
							String tptan = GetterUtil.getString(latestLitigation
									.get(LitigationConstants.THRID_PARTY_APP_NUMBER));
							if (Validator.isNull(tptan)) {
								tptan = litId;
							}
							String latestLitId = latestLitigation.get(LitigationConstants.LITIGATION_ID);
							String litUrl = Utils.getLitigationDetailsFriendlyUrl(GetterUtil.getLong(latestLitId));
							if (hrefSb.length() != 0) {
								hrefSb.append(StringPool.SPACE);
							}
							hrefSb.append(String.format(HREF_FORMAT, latestLitId, litUrl, tptan));
						}
					}
					row.addText(hrefSb.toString());
				} else {
					row.addText("  ");
				}
				row.addText(getEscapedString(doc.get(TrademarksConstants.VERSION)));
				// row.addText(getEscapedString(doc.get(TrademarksConstants.TRADEMARK)));

				/*
				 * agencyId = doc.get(TrademarksConstants.AGENCY_ID); agencyCN =
				 * agencySearch.getAgencyCountryName(agencyId); latestAgencyId =
				 * agencySearch.getLatestAgencyIdByRootAgencyId(agencyId);
				 * actionUrl = PortletURLFactoryUtil.create(request,
				 * TrademarksConstants.PORTLET_ID, themeDisplay.getPlid(),
				 * PortletRequest.ACTION_PHASE);
				 * //renderResponse.createActionURL();
				 * actionUrl.setWindowState(WindowState.MAXIMIZED);
				 * actionUrl.setParameter(AgencyConstants.AGENCY_ID,
				 * GetterUtil.getString(latestAgencyId) );
				 * actionUrl.setParameter("javax.portlet.action",
				 * "displayAgencyDetails"); row.addText(agencyCN,
				 * actionUrl.toString());
				 */

				/*
				 * classCC = classSearch.getClassCodeCountry(classId);
				 * latestClassId =
				 * classSearch.getLatestClassIdByRootClassId(classId); actionUrl
				 * = PortletURLFactoryUtil .create(request,
				 * TrademarksConstants.PORTLET_ID, themeDisplay.getPlid(),
				 * PortletRequest.ACTION_PHASE);
				 * //renderResponse.createActionURL();
				 * actionUrl.setWindowState(WindowState.MAXIMIZED);
				 * actionUrl.setParameter(ClassMasterConstants.CLASS_ID,
				 * GetterUtil.getString(latestClassId) );
				 * actionUrl.setParameter("javax.portlet.action",
				 * "displayClassDetails"); row.addText(classCC,
				 * actionUrl.toString());
				 */

				isLatest = GetterUtil.getBoolean(doc.get(TrademarksConstants.LATEST));
				if (editPermission) {
					if (isLatest) {
						boolean canEdit = Utils.checkUserPermissionOnCountry(request, countryVocId, country);
						if (canEdit) {
							actionUrl = PortletURLFactoryUtil.create(request, TrademarksConstants.PORTLET_ID,
									themeDisplay.getPlid(), PortletRequest.ACTION_PHASE); // renderResponse.createActionURL();
							actionUrl.setWindowState(WindowState.MAXIMIZED);
							actionUrl.setParameter(TrademarksConstants.TRADEMARKS_ID, String.valueOf(classPK));
							actionUrl.setParameter("javax.portlet.action", "displayEditTrademarks");
							addSearchParams(actionUrl);
							row.addText("Edit", actionUrl.toString());
						} else {
							row.addText("  ");
						}

					} else {
						row.addText("  ");
					}
				}

				actionUrl = PortletURLFactoryUtil.create(request, TrademarksConstants.PORTLET_ID,
						themeDisplay.getPlid(), PortletRequest.ACTION_PHASE); // renderResponse.createActionURL();
				actionUrl.setWindowState(WindowState.MAXIMIZED);
				actionUrl.setParameter(TrademarksConstants.TRADEMARKS_ID, String.valueOf(classPK));
				actionUrl.setParameter("javax.portlet.action", "displayTrademarksDetails");
				addSearchParams(actionUrl);
				row.addText("Details", actionUrl.toString());
				resultRows.add(row);
			}
		}

		return searchContainer;
	}
	public static String getClassCodes(long vocId, List<Long> catIds) {
		String codes = "";
		if (Validator.isNotNull(catIds)) {
			try {
				for (int i = 0; i < catIds.size(); i++) {
					AssetCategory catg = AssetCategoryLocalServiceUtil.getAssetCategory(catIds.get(i));
					if (Validator.isNotNull(catg)) {
						if (catg.getVocabularyId() == vocId) {
							if (i != catIds.size() - 1) {
								codes = codes + catg.getName() + ", ";
							}
						}
					}
				}
				if (codes.charAt(codes.length() - 1) == ' ') {
					codes = codes.substring(0, codes.length() - 1);
					if (codes.charAt(codes.length() - 1) == ',') {
						codes = codes.substring(0, codes.length() - 1);
					}
				}
			} catch (Exception e) {

			}
		}
		return codes;
	}

	public PortletURL getLitigationActionUrl(String litigationId) {
		PortletURL actionUrl = PortletURLFactoryUtil.create(request, TrademarksConstants.PORTLET_ID,
				themeDisplay.getPlid(), PortletRequest.ACTION_PHASE); // renderResponse.createActionURL();
		try {
			actionUrl.setWindowState(WindowState.MAXIMIZED);
		} catch (WindowStateException e) {
		}
		actionUrl.setParameter(LitigationConstants.LITIGATION_ID, litigationId);
		actionUrl.setParameter("javax.portlet.action", "displayLitigationDetails");

		return actionUrl;
	}

	protected BooleanClause getSearchCondition(SearchContext searchContext,String searchField, String searchFieldValue,String from,String to) {
		BooleanClause bc = null;
		if (TrademarksConstants.TRADEMARK_HISTORY.equals(searchField)) {
			if ("all".equals(searchFieldValue)) {
			} else if ("active".equals(searchFieldValue)) {
				bc = getActiveRecordsBC(searchContext);
			} else if ("expired".equals(searchFieldValue)) {
				bc = getExpiredRecordsBC(searchContext);
			} else if ("auditHistory".equals(searchFieldValue)) {
				this.showLatestOnly = false;
			}
		}else if (TrademarksConstants.PENDING_RENEWAL.equals(searchField)) {
			int days = GetterUtil.getInteger(ParamUtil.getString(request,
					getListId(TrademarksConstants.PENDING_RENEWAL)));
			Calendar fromCalendar = Calendar.getInstance();
			Calendar toCalender = Calendar.getInstance();
			toCalender.add(Calendar.DAY_OF_MONTH, days);
			bc = getBC4RangeTerm(TrademarksConstants.EXPIRY_DATE, fromCalendar, toCalender, searchContext);
		}else{
			bc = super.getSearchCondition(searchContext, searchField, searchFieldValue, from, to);
		}
		return bc;
	}

	private BooleanClause getExpiredRecordsBC(SearchContext searchContext) {
		Calendar fromCalender = Calendar.getInstance();
		Calendar toCalendar = Calendar.getInstance();
		fromCalender.add(Calendar.YEAR, -100);
		BooleanClause bc = getBC4RangeTerm(TrademarksConstants.EXPIRY_DATE, fromCalender, toCalendar, searchContext);
		return bc;
	}

	private BooleanClause getActiveRecordsBC(SearchContext searchContext) {
		Calendar fromCalender = Calendar.getInstance();
		Calendar toCalendar = Calendar.getInstance();
		toCalendar.add(Calendar.YEAR, 100);
		BooleanClause bc = getBC4RangeTerm(TrademarksConstants.EXPIRY_DATE, fromCalender, toCalendar, searchContext);

		return bc;
	}

	public Map<String, String> getTrademarksIdAdnRegNum() {
		Map<String, String> map = new LinkedHashMap<String, String>();

		SearchContext searchContext = getDefaultSearchContext();
		BooleanClause[] booleanClauses = new BooleanClause[1];
		booleanClauses[0] = getBC4ExactTerm(TrademarksConstants.LATEST, "true", searchContext);
		searchContext.setBooleanClauses(booleanClauses);
		Hits results = searchTrademarks(searchContext);

		if (Validator.isNotNull(results)) {
			int length = results.getDocs().length;
			String countryNam = "";
			String applicationNo;
			// String applicationNo;
			String rootTrademarksId;
			for (int i = 0; i < length; i++) {
				Document doc = results.doc(i);
				rootTrademarksId = doc.get(TrademarksConstants.ROOT_TRADEMARK_ID);
				applicationNo = GetterUtil.getString(doc.get(TrademarksConstants.APPLICATION_NO));
				countryNam = GetterUtil.getString(doc.get(TrademarksConstants.COUNTRY));
				map.put(rootTrademarksId, String.format(APPLICATION_NUM_COUNTRY_FORMAT, applicationNo, countryNam));
				// applicationNo =
				// GetterUtil.getString(doc.get(TrademarksConstants.APPLICATION_NO));
				// map.put(rootTrademarksId,String.format(REG_NUM_COUNTRY_FORMAT,regNum,countryNam));
			}
		}

		return sortByComparator(map);
	}

	private static Map<String, String> sortByComparator(Map<String, String> unsortMap) {
		Map<String, String> sortedMap = new LinkedHashMap<String, String>();

		try {
			// Convert Map to List
			List<Map.Entry<String, String>> list = new LinkedList<Map.Entry<String, String>>(unsortMap.entrySet());

			// Sort list with comparator, to compare the Map values
			Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
				public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
					return (o1.getValue()).compareTo(o2.getValue());
				}
			});

			// Convert sorted map back to a Map
			for (Iterator<Map.Entry<String, String>> it = list.iterator(); it.hasNext();) {
				Map.Entry<String, String> entry = it.next();
				sortedMap.put(entry.getKey(), entry.getValue());
			}

		} catch (Exception ex) {
			sortedMap = unsortMap;
		}

		return sortedMap;
	}

	public static List<Document> getTrademarksExpiresOnDay(int days, long companyId, boolean considerAlertBefore) {
		SearchContext searchContext = getDefaultSearchContext(companyId);
		Calendar fromCalendar = Calendar.getInstance();
		Calendar toCalender = Calendar.getInstance();
		fromCalendar.add(Calendar.DAY_OF_MONTH, days);
		toCalender.add(Calendar.DAY_OF_MONTH, days);
		List<BooleanClause> booleanClauseList = new ArrayList<BooleanClause>();
		booleanClauseList
				.add(getBC4RangeTerm(TrademarksConstants.EXPIRY_DATE, fromCalendar, toCalender, searchContext));
		booleanClauseList.add(getBC4ExactTerm(TrademarksConstants.LATEST, "true", searchContext));

		if (considerAlertBefore) {
			try {
				long vocId = GetterUtil.getLong(SambaashUtil.getParameter(
						SambaashConstants.TRADEMARKS_RENEWAL_ALERT_VOC_ID, 0));
				long catId = Utils.getCategoryId(vocId, String.valueOf(days));

				BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);

				bq.addRequiredTerm(Field.ASSET_CATEGORY_IDS, catId);
				BooleanClause bc = BooleanClauseFactoryUtil.create(searchContext,bq, BooleanClauseOccur.MUST.getName());
				booleanClauseList.add(bc);

			} catch (Exception ex) {
				_log.error("Error while adding alert before boolean clause ");
			}
		}
		BooleanClause[] booleanClauses = toBCArray(booleanClauseList);
		if (Validator.isNotNull(booleanClauses) && booleanClauses.length > 0) {
			searchContext.setBooleanClauses(booleanClauses);
		}
		searchContext.setBooleanClauses(booleanClauses);
		Hits results = searchTrademarks(searchContext);
		List<Document> list = new ArrayList<Document>();
		if (Validator.isNotNull(results)) {
			int length = results.getDocs().length;
			for (int i = 0; i < length; i++) {
				Document doc = results.doc(i);
				list.add(doc);
			}
		}
		return list;

	}

	private SearchContext getDefaultSearchContext() {
		return getDefaultSearchContext(themeDisplay.getUser().getCompanyId());
	}

	private static SearchContext getDefaultSearchContext(long companyId) {
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(-1);
		searchContext.setEnd(-1);
		searchContext.setCompanyId(companyId);

		Sort sort = SortFactoryUtil.create(LegalConstants.SORT_FIELD, Sort.STRING_TYPE, false);
		Sort sort1 = SortFactoryUtil.create(TrademarksConstants.COUNTRY, Sort.STRING_TYPE, false);

		Sort[] sorts = new Sort[] { sort, sort1 };
		searchContext.setSorts(sorts);

		return searchContext;
	}

	public static Hits searchTrademarks(SearchContext searchContext) {

		Indexer indexer = IndexerRegistryUtil.getIndexer(Trademarks.class.getName());
		Hits results = null;
		try {
			results = indexer.search(searchContext);
		} catch (SearchException e) {
			_log.error(e.getMessage(), e);
		}
		return results;
	}

	public List<Document> getTrademarks() {
		SearchContext searchContext = getDefaultSearchContext();
		setup();
		setSearchConditions(searchContext);
		Hits results = searchTrademarks(searchContext);
		List<Document> list = new ArrayList<Document>();
		if (Validator.isNotNull(results)) {
			int length = results.getDocs().length;
			for (int i = 0; i < length; i++) {
				Document doc = results.doc(i);
				list.add(doc);
			}
		}

		return list;
	}

	public String getTrademarkRegNumCountryByRootTrademarkId(String trademarkId) {
		String result = StringPool.BLANK;
		try {
			Document doc = getLatestDocumentByRootId(Long.parseLong(trademarkId), TrademarksConstants.ROOT_TRADEMARK_ID);
			String regNum = doc.get(TrademarksConstants.REGISTRATION_NUMBER);
			String country = doc.get(TrademarksConstants.COUNTRY);
			result = String.format(APPLICATION_NUM_COUNTRY_FORMAT, regNum, country);
		} catch (Exception ex) {

		}
		return result;
	}

	public String getTrademarkApplicationNumCountryByRootTrademarkId(String trademarkId) {
		String result = StringPool.BLANK;
		try {
			Document doc = getLatestDocumentByRootId(Long.parseLong(trademarkId), TrademarksConstants.ROOT_TRADEMARK_ID);
			String regNum = doc.get(TrademarksConstants.APPLICATION_NO);
			String country = doc.get(TrademarksConstants.COUNTRY);
			result = String.format(APPLICATION_NUM_COUNTRY_FORMAT, regNum, country);
		} catch (Exception ex) {

		}
		return result;
	}

	public String getTrademarkRegNumCountry(long trademarkId) {
		String result = StringPool.BLANK;
		try {
			Document root = getDocumentByPK(trademarkId);

			String regNum = GetterUtil.getString(root.get(TrademarksConstants.REGISTRATION_NUMBER));
			String countryNam = GetterUtil.getString(root.get(TrademarksConstants.COUNTRY));
			result = String.format(APPLICATION_NUM_COUNTRY_FORMAT, regNum, countryNam);

		} catch (Exception ex) {

		}
		return result;
	}

	public String getTrademarkApplicationNumCountry(long trademarkId) {
		String result = StringPool.BLANK;
		try {
			Document doc = getDocumentByPK(trademarkId);
			String applicationNo = GetterUtil.getString(doc.get(TrademarksConstants.APPLICATION_NO));
			String countryNam = GetterUtil.getString(doc.get(TrademarksConstants.COUNTRY));
			result = String.format(APPLICATION_NUM_COUNTRY_FORMAT, applicationNo, countryNam);

		} catch (Exception ex) {

		}
		return result;
	}

	public Map<String, String> getTrademarksMap(Document doc, boolean convertNLtoBr) {
		Map<String, String> map = new HashMap<String, String>();
		if (Validator.isNotNull(doc)) {
			try {
				List<Long> catIds = Utils.getCategoryIds(doc);
				// catIds = reorderCategoryIds(preferences, catIds);
				String country = Utils.getCategoryName(preferences, TrademarksConstants.COUNTRY_VOC_ID, catIds);
				String status = Utils.getCategoryName(preferences, TrademarksConstants.STATUS_VOC_ID, catIds);
				String renewalAlertB = Utils.getCategoryName(preferences,
						TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID, catIds);
				// String oppStatus = Utils.getCategoryName(preferences,
				// TrademarksConstants.OPPOSITION_STATUS_VOC_ID, catIds);
				String customList1CatName = Utils.getCategoryName(preferences,
						TrademarksConstants.REGISTERED_OWNER_VOC_ID, catIds);
				// String customList2CatName =
				// Utils.getCategoryName(preferences,
				// TrademarksConstants.CUSTOM_LIST_2_VOC_ID, catIds);
				// String customList3CatName =
				// Utils.getCategoryName(preferences,
				// TrademarksConstants.CUSTOM_LIST_3_VOC_ID, catIds);

				if (convertNLtoBr) {
					map.put(TrademarksConstants.REMARKS, Utils.toHtmlTags((doc.get(TrademarksConstants.REMARKS))));
					map.put(TrademarksConstants.LEGAL_CONF_REMARKS,
							Utils.toHtmlTags(doc.get(TrademarksConstants.LEGAL_CONF_REMARKS)));
					map.put(TrademarksConstants.ACTIVE_IN_GREDIENTS,
							Utils.toHtmlTags(doc.get(TrademarksConstants.ACTIVE_IN_GREDIENTS)));
					map.put(TrademarksConstants.CUSTOM_FIELD_3,
							Utils.toHtmlTags(doc.get(TrademarksConstants.CUSTOM_FIELD_3)));
				} else {
					map.put(TrademarksConstants.REMARKS, GetterUtil.getString(doc.get(TrademarksConstants.REMARKS)));
					map.put(TrademarksConstants.LEGAL_CONF_REMARKS,
							GetterUtil.getString(doc.get(TrademarksConstants.LEGAL_CONF_REMARKS)));
					map.put(TrademarksConstants.ACTIVE_IN_GREDIENTS,
							GetterUtil.getString(doc.get(TrademarksConstants.ACTIVE_IN_GREDIENTS)));
					map.put(TrademarksConstants.CUSTOM_FIELD_3,
							GetterUtil.getString(doc.get(TrademarksConstants.CUSTOM_FIELD_3)));

				}

				map.put(TrademarksConstants.TRADEMARKS_ID, GetterUtil.getString(doc.get(Field.ENTRY_CLASS_PK)));
				String rootTMId = GetterUtil.getString(doc.get(TrademarksConstants.ROOT_TRADEMARK_ID)); 
				map.put(TrademarksConstants.ROOT_TRADEMARK_ID, rootTMId		);
				map.put(TrademarksConstants.REGISTRATION_NUMBER,
						GetterUtil.getString(doc.get(TrademarksConstants.REGISTRATION_NUMBER)));
				map.put(TrademarksConstants.APPLICATION_NO,
						GetterUtil.getString(doc.get(TrademarksConstants.APPLICATION_NO)));
				map.put(TrademarksConstants.COUNTRY, country);
				// map.put(TrademarksConstants.CLASS_CODE,classCode);
				map.put(TrademarksConstants.CLASS_DESCRIPTION,
						GetterUtil.getString(doc.get(TrademarksConstants.CLASS_DESCRIPTION)));
				map.put(TrademarksConstants.VERSION, GetterUtil.getString(doc.get(TrademarksConstants.VERSION)));
				map.put(TrademarksConstants.TRADEMARK, GetterUtil.getString(doc.get(TrademarksConstants.TRADEMARK)));
				map.put(TrademarksConstants.TRADEMARK_LOCALIZED,
						GetterUtil.getString(doc.get(TrademarksConstants.TRADEMARK_LOCALIZED)));
				// map.put(classCode);
				String tmType = GetterUtil.getString(doc.get(TrademarksConstants.TRADEMARK_TYPE)) ;
				map.put(TrademarksConstants.TRADEMARK_TYPE, tmType);
				if(TrademarksConstants.LOGO.equalsIgnoreCase(tmType)){
					map.put(TrademarksConstants.LOGO_FILE_ENTRY_ID,getTrademarkLogoFileEntryId(request, rootTMId));
					String title = FilesUpload.removeLogoExtension(doc.get(TrademarksConstants.TRADEMARK));
					map.put(TrademarksConstants.TRADEMARK, title);
				}
				map.put(TrademarksConstants.STATUS, status);
				map.put(TrademarksConstants.REGISTERED_OWNER, GetterUtil.getString(customList1CatName));
				map.put(TrademarksConstants.APPLICATION_DATE,
						Utils.getDateStrYMD(doc, TrademarksConstants.APPLICATION_DATE));
				map.put(TrademarksConstants.FIRST_REG_DATE,
						Utils.getDateStrYMD(doc, TrademarksConstants.FIRST_REG_DATE));
				map.put(TrademarksConstants.RENEWAL_ALERT_BEFORE, renewalAlertB);
				map.put(TrademarksConstants.EXPIRY_DATE, Utils.getDateStrYMD(doc, TrademarksConstants.EXPIRY_DATE));
				// map.put(TrademarksConstants.GOODS_SERVICES,GetterUtil.getString(doc.get(TrademarksConstants.GOODS_SERVICES)));
				// map.put(TrademarksConstants.OPPOSITION_STATUS,oppStatus);

				String agencyId = doc.get(TrademarksConstants.AGENCY_ID);
				// String classId = doc.get(TrademarksConstants.CLASS_ID);
				AgencySearch agencySearch = new AgencySearch(request, response);
				map.put(AgencyConstants.AGENCY, agencySearch.getAgencyCountryName(agencyId));
				map.put(AgencyConstants.AGENCY_ID, agencyId);
				// ClassSearch classSearch = new ClassSearch(request,response);
				// map.put(ClassMasterConstants.CLASS_MASTER,classSearch.getClassCodeCountry(classId));
				map.put(TrademarksConstants.INTERNATIONAL_REG_NUM,
						GetterUtil.getString(doc.get(TrademarksConstants.INTERNATIONAL_REG_NUM)));
				map.put(TrademarksConstants.PRIORITY_DATE, Utils.getDateStrYMD(doc, TrademarksConstants.PRIORITY_DATE));
				// map.put(TrademarksConstants.CUSTOM_DATE_2,Utils.getDateStrYMD(doc,
				// TrademarksConstants.CUSTOM_DATE_2));
				// map.put(TrademarksConstants.CUSTOM_DATE_3,Utils.getDateStrYMD(doc,
				// TrademarksConstants.CUSTOM_DATE_3));
				map.put(TrademarksConstants.REGISTERED_OWNER_LIST, customList1CatName);
				// map.put(TrademarksConstants.CUSTOM_LIST_2,customList2CatName);
				// map.put(TrademarksConstants.CUSTOM_LIST_3,customList3CatName);

				map.put(TrademarksConstants.LATEST, GetterUtil.getString(doc.get(TrademarksConstants.LATEST)));
				map.put(TrademarksConstants.LITIGATION_IDS,
						GetterUtil.getString(doc.get(TrademarksConstants.LITIGATION_IDS)));

			} catch (Exception ex) {
				_log.error("error while retrieving data", ex);
			}

		}
		return map;
	}

	public Map<String, String> getTrademarksMap(Trademarks trademarks, boolean convertNLtoBr) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		if (Validator.isNotNull(trademarks)) {
			try {
				//AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(Trademarks.class.getName(),
						//trademarks.getSpTrademarksId());
				List<Long> catIds = Utils.getAssetCategoryIds(Trademarks.class.getName(),trademarks.getSpTrademarksId());//Utils.getLongList(assetEntry.getCategoryIds());
				// catIds = reorderCategoryIds(preferences, catIds);
				String country = Utils.getCategoryName(preferences, TrademarksConstants.COUNTRY_VOC_ID, catIds);
				String status = Utils.getCategoryName(preferences, TrademarksConstants.STATUS_VOC_ID, catIds);
				String renewalAlertB = Utils.getCategoryName(preferences,
						TrademarksConstants.RENEWAL_ALERT_BEFORE_VOC_ID, catIds);
				// String oppStatus = Utils.getCategoryName(preferences,
				// TrademarksConstants.OPPOSITION_STATUS_VOC_ID, catIds);
				String customList1CatName = Utils.getCategoryName(preferences,
						TrademarksConstants.REGISTERED_OWNER_VOC_ID, catIds);
				// String customList2CatName =
				// Utils.getCategoryName(preferences,
				// TrademarksConstants.CUSTOM_LIST_2_VOC_ID, catIds);
				// String customList3CatName =
				// Utils.getCategoryName(preferences,
				// TrademarksConstants.CUSTOM_LIST_3_VOC_ID, catIds);

				if (convertNLtoBr) {
					map.put(TrademarksConstants.REMARKS,
							Utils.toHtmlTags(GetterUtil.getString(trademarks.getPendingComments())));
					map.put(TrademarksConstants.LEGAL_CONF_REMARKS,
							Utils.toHtmlTags(GetterUtil.getString(trademarks.getLegalConfRemarks())));
					map.put(TrademarksConstants.ACTIVE_IN_GREDIENTS,
							Utils.toHtmlTags(GetterUtil.getString(trademarks.getCustomField1())));
					map.put(TrademarksConstants.CUSTOM_FIELD_3,
							Utils.toHtmlTags(GetterUtil.getString(trademarks.getCustomField3())));
				} else {
					map.put(TrademarksConstants.REMARKS, GetterUtil.getString(trademarks.getPendingComments()));
					map.put(TrademarksConstants.LEGAL_CONF_REMARKS,
							GetterUtil.getString(trademarks.getLegalConfRemarks()));
					map.put(TrademarksConstants.ACTIVE_IN_GREDIENTS, GetterUtil.getString(trademarks.getCustomField1()));
					map.put(TrademarksConstants.CUSTOM_FIELD_3, GetterUtil.getString(trademarks.getCustomField3()));
				}
				map.put(TrademarksConstants.TRADEMARKS_ID, GetterUtil.getString(trademarks.getSpTrademarksId()));
				map.put(TrademarksConstants.ROOT_TRADEMARK_ID, String.valueOf(trademarks.getRootSpTrademarksId()));
				map.put(TrademarksConstants.REGISTRATION_NUMBER,
						GetterUtil.getString(trademarks.getRegistrationNumber()));
				map.put(TrademarksConstants.APPLICATION_NO, GetterUtil.getString(trademarks.getApplicationNo()));
				map.put(TrademarksConstants.COUNTRY, country);
				// map.put(TrademarksConstants.CLASS_CODE,classCode);
				// map.put(TrademarksConstants.CLASS_DESCRIPTION,GetterUtil.getString(doc.get(TrademarksConstants.CLASS_DESCRIPTION)));
				map.put(TrademarksConstants.VERSION, GetterUtil.getString(trademarks.getVersion()));
				map.put(TrademarksConstants.TRADEMARK, GetterUtil.getString(trademarks.getTrademark()));
				map.put(TrademarksConstants.TRADEMARK_LOCALIZED,
						GetterUtil.getString(trademarks.getTrademarkLocalized()));
				// map.put(classCode);
				map.put(TrademarksConstants.TRADEMARK_TYPE, GetterUtil.getString(trademarks.getTrademarkType()));
				
				if(TrademarksConstants.LOGO.equalsIgnoreCase(trademarks.getTrademarkType())){
					map.put(TrademarksConstants.LOGO_FILE_ENTRY_ID,getTrademarkLogoFileEntryId(request, String.valueOf(trademarks.getRootSpTrademarksId())));
					String title = FilesUpload.removeLogoExtension(trademarks.getTrademark());
					map.put(TrademarksConstants.TRADEMARK, title);
				}
				
				map.put(TrademarksConstants.STATUS, status);
				map.put(TrademarksConstants.REGISTERED_OWNER, GetterUtil.getString(customList1CatName));
				map.put(TrademarksConstants.APPLICATION_DATE, Utils.getDateStrYMD(trademarks.getApplicationDate()));
				map.put(TrademarksConstants.FIRST_REG_DATE, Utils.getDateStrYMD(trademarks.getFirstRegistrationDate()));
				map.put(TrademarksConstants.RENEWAL_ALERT_BEFORE, renewalAlertB);
				map.put(TrademarksConstants.EXPIRY_DATE, Utils.getDateStrYMD(trademarks.getRenewalDate()));
				
				// map.put(TrademarksConstants.GOODS_SERVICES,GetterUtil.getString(trademarks.getGoodsServices()));
				// map.put(TrademarksConstants.OPPOSITION_STATUS,oppStatus);

				// String agencyId =
				// GetterUtil.getString(trademarks.getAgencyId());
				// AgencySearch agencySearch = new
				// AgencySearch(request,response);
				try {
					long rootAgencyId = trademarks.getSpAgencyId();
					AgencySearch agencySearch = new AgencySearch(request, response);
					Map<String, String> latest = agencySearch.getLatestAgencyByRootAgencyId(rootAgencyId, false);
					String latestAgencyId = "";
					String url = "";
					String agencyInfo = "";
					if (Validator.isNotNull(latest) && Validator.isNotNull(latest.get(AgencyConstants.AGENCY_ID))) {
						String agencyName = "";
						String agencyCountry = "";
						agencyName = GetterUtil.getString(latest.get(Field.NAME));
						agencyCountry = GetterUtil.getString(latest.get(AgencyConstants.COUNTRY));
						agencyInfo = agencyName + " / " + agencyCountry;
						latestAgencyId = latest.get(AgencyConstants.AGENCY_ID);

						url = Utils.getAgencyDetailsFriendlyUrl(request,GetterUtil.getLong(latestAgencyId));

					}
					map.put(AgencyConstants.AGENCY, agencyInfo);
					map.put(AgencyConstants.AGENCY_ID, latestAgencyId);
					map.put(TrademarksConstants.AGENCY_DETAILS_LINK, url);

				} catch (Exception ex) {

				}
				// ClassSearch classSearch = new ClassSearch(request,response);
				// map.put(ClassMasterConstants.CLASS_MASTER,classSearch.getClassCodeCountry(classId));

				map.put(TrademarksConstants.INTERNATIONAL_REG_NUM, GetterUtil.getString(trademarks.getCustomField2()));

				map.put(TrademarksConstants.PRIORITY_DATE, Utils.getDateStrYMD(trademarks.getCustomDate1()));
				// map.put(TrademarksConstants.CUSTOM_DATE_2,Utils.getDateStrYMD(trademarks.getCustomDate2()));
				// map.put(TrademarksConstants.CUSTOM_DATE_3,Utils.getDateStrYMD(trademarks.getCustomDate3()));
				map.put(TrademarksConstants.REGISTERED_OWNER_LIST, customList1CatName);
				// map.put(TrademarksConstants.CUSTOM_LIST_2,customList2CatName);
				// map.put(TrademarksConstants.CUSTOM_LIST_3,customList3CatName);
				map.put(TrademarksConstants.UPDATE_BY, trademarks.getUserName());
				map.put(TrademarksConstants.MODIFIED_DATE, Utils.getDateTime(trademarks.getModifiedDate()));

				map.put(TrademarksConstants.LATEST, String.valueOf(isTrademarkLatest(trademarks)));
				map.put(TrademarksConstants.LITIGATION_IDS,
						GetterUtil.getString(getTrademarksLitigations(trademarks.getRootSpTrademarksId())));

			} catch (Exception ex) {

			}

		}
		return map;
	}

	public static String getTrademarksLitigations(long rootTrademarkId) {
		List<Object[]> litidationIdArrList = LitigationLocalServiceUtil
				.getLatestLitigationsByTrademarkId(rootTrademarkId);

		String litigationIds = StringPool.BLANK;
		if (Validator.isNotNull(litidationIdArrList) && litidationIdArrList.size() > 0) {
			for (Object[] litidationIdArr : litidationIdArrList) {
				litigationIds = Validator.isNull(litigationIds) ? Long.toString((Long) litidationIdArr[1])
						: litigationIds + StringPool.COMMA + Long.toString((Long) litidationIdArr[1]);
			}
			// document.addKeyword(TrademarksConstants.LITIGATION_IDS,
			// litigationIds);
		}

		return litigationIds;
	}

	public static boolean isTrademarkLatest(Trademarks tradeMark) {
		boolean latest = true;
		List<Object[]> trademarkIdArrList = TrademarksLocalServiceUtil.getLatestTrademarkIdAndVersionNumber(
				tradeMark.getApplicationNo(), tradeMark.getCountry());
		if (Validator.isNotNull(trademarkIdArrList) && trademarkIdArrList.size() > 0) {
			Object[] trademarkIdArr = ((Object[]) trademarkIdArrList.get(0));

			if (((Long) trademarkIdArr[1]).compareTo(tradeMark.getSpTrademarksId()) == 0) {
				// document.addKeyword(TrademarksConstants.LATEST, true);
				latest = true;
			} else {
				// document.addKeyword(TrademarksConstants.LATEST, false);
				latest = false;
			}
		}
		return latest;

	}

	public Map<String, String> getTrademarksMap(long trademarksId, boolean convertNLtoBr) {
		Document doc = getDocumentByPK(trademarksId);
		Map<String, String> map = getTrademarksMap(doc, convertNLtoBr);
		return map;
	}

	public Map<String, String> getTrademarksMap(String trademarksId, boolean convertNLtoBr) {
		return getTrademarksMap(GetterUtil.getLong(trademarksId), convertNLtoBr);
	}

	public Map<String, String> getLatestTrademarksByRootTrademarksId(long rootTrademarksId, boolean convertNLtoBr) {
		Document doc = getLatestDocumentByRootId(rootTrademarksId, TrademarksConstants.ROOT_TRADEMARK_ID);
		Map<String, String> map = getTrademarksMap(doc, convertNLtoBr);
		return map;
	}

	public Map<String, String> getLatestTrademarksByRootTrademarksId(String rootTrademarksId, boolean convertNLtoBr) {
		return getLatestTrademarksByRootTrademarksId(GetterUtil.getLong(rootTrademarksId), convertNLtoBr);
	}

	public static long[] getFolderIds(PortletRequest actionRequest, String folderName) {
		long[] folderIds = new long[3];
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String rootPath = LegalConstants.LEGAL_ROOT_FOLDER_NAME + "/"
					+ TrademarksConstants.TRADEMARK_ROOT_FOLDER_NAME + "/" + folderName;
			String attachmentPath = rootPath + "/" + TrademarksConstants.FOLDER_NAME_ATTACHEMENTS;
			String ConfattachmentPath = rootPath + "/" + TrademarksConstants.FOLDER_NAME_CONF_ATTACHEMENTS;
			String logoPath = rootPath + "/" + TrademarksConstants.FOLDER_NAME_TRADEMARK_LOGOS;

			Folder attachmentFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(),
					LegalConstants.DL_ROOT_FOLDER_ID, attachmentPath, LegalConstants.FOLDER, false, true, true);
			Folder ConfattachmentFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(),
					LegalConstants.DL_ROOT_FOLDER_ID, ConfattachmentPath, LegalConstants.FOLDER, false, true, true);
			Folder logoFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(),
					LegalConstants.DL_ROOT_FOLDER_ID, logoPath, LegalConstants.FOLDER, false, true, true);
			folderIds[0] = attachmentFolder.getFolderId();
			folderIds[1] = ConfattachmentFolder.getFolderId();
			folderIds[2] = logoFolder.getFolderId();

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return folderIds;
	}

	// here folder name is eithere trademark folder or user folder whoever
	// having logo folder
	public static long getLogoFolderId(PortletRequest actionRequest, String folderName) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long folderId = 0;
		try {
			String rootPath = LegalConstants.LEGAL_ROOT_FOLDER_NAME + "/"
					+ TrademarksConstants.TRADEMARK_ROOT_FOLDER_NAME + "/" + folderName;
			String logoPath = rootPath + "/" + TrademarksConstants.FOLDER_NAME_TRADEMARK_LOGOS;

			Folder logoFolder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(),
					LegalConstants.DL_ROOT_FOLDER_ID, logoPath, LegalConstants.FOLDER, false, true, true);
			folderId = logoFolder.getFolderId();

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return folderId;
	}

	public static long[] getFolderIdsOld(PortletRequest actionRequest, String folderName) throws PortalException {
		long[] folderIds = new long[3];
		long trademarkFolderId;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String folderNameAttachments = TrademarksConstants.FOLDER_NAME_ATTACHEMENTS;
		String folderNameConfAttachments = TrademarksConstants.FOLDER_NAME_CONF_ATTACHEMENTS;
		String folderNameConfLogos = TrademarksConstants.FOLDER_NAME_TRADEMARK_LOGOS;
		try {
			Folder folder = null;
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
			long repositoryId = themeDisplay.getScopeGroupId();
			long parentFolderId;
			try {
				parentFolderId = DLAppServiceUtil.getFolder(repositoryId, 0, LegalConstants.LEGAL_ROOT_FOLDER_NAME)
						.getFolderId();
			} catch (Exception ex) {
				Folder legalFolder = DLAppServiceUtil.addFolder(repositoryId, 0, LegalConstants.LEGAL_ROOT_FOLDER_NAME,
						LegalConstants.LEGAL_ROOT_FOLDER_NAME, serviceContext);
				parentFolderId = legalFolder.getFolderId();
			}
			try {
				parentFolderId = DLAppServiceUtil.getFolder(repositoryId, parentFolderId,
						TrademarksConstants.TRADEMARK_ROOT_FOLDER_NAME).getFolderId();
			} catch (Exception ex) {
				Folder trademarksRootFolder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId,
						TrademarksConstants.TRADEMARK_ROOT_FOLDER_NAME, TrademarksConstants.TRADEMARK_ROOT_FOLDER_NAME,
						serviceContext);
				parentFolderId = trademarksRootFolder.getFolderId();
			}

			try {
				folder = DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
				trademarkFolderId = folder.getFolderId();
			} catch (NoSuchFolderException e) {
				folder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, folderName, folderName,
						serviceContext);
				trademarkFolderId = folder.getFolderId();
			}

			try {
				folder = DLAppServiceUtil.getFolder(repositoryId, trademarkFolderId, folderNameAttachments);
			} catch (NoSuchFolderException e) {
				folder = DLAppServiceUtil.addFolder(repositoryId, trademarkFolderId, folderNameAttachments,
						folderNameAttachments, serviceContext);
			}
			folderIds[0] = folder.getFolderId();

			try {
				folder = DLAppServiceUtil.getFolder(repositoryId, trademarkFolderId, folderNameConfAttachments);
			} catch (NoSuchFolderException e) {
				folder = DLAppServiceUtil.addFolder(repositoryId, trademarkFolderId, folderNameConfAttachments,
						folderNameConfAttachments, serviceContext);
			}
			folderIds[1] = folder.getFolderId();

			try {
				folder = DLAppServiceUtil.getFolder(repositoryId, trademarkFolderId, folderNameConfLogos);
			} catch (NoSuchFolderException e) {
				folder = DLAppServiceUtil.addFolder(repositoryId, trademarkFolderId, folderNameConfLogos,
						folderNameConfLogos, serviceContext);
			}
			folderIds[2] = folder.getFolderId();

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return folderIds;
	}

	public static String getTrademarksFolderName(String trademarkId) {
		String folderName = String.format(TrademarksConstants.TRADEMARK_FOLDER_NAME, trademarkId);
		return folderName;
	}

	public static String getTrademarksFolderName(long trademarkId) {
		return getTrademarksFolderName(String.valueOf(trademarkId));
	}

	public static String getTrademarksLogoDLUrl(PortletRequest request, String rootTrademarkId) throws PortalException {
		try {			
			long fileEntryId = GetterUtil.getLong(getTrademarkLogoFileEntryId(request,rootTrademarkId));
			int fileSize = 0;
			String url = StringPool.BLANK;
			if(fileEntryId != 0){
				FileEntry fe = DLAppServiceUtil.getFileEntry(fileEntryId);
				fileSize = fe.getContentStream().available();
				url = PortalUtil.getPortalURL(request) + "/FileSharing-portlet/download?fileEntryId=" + fileEntryId;
			}
			
			return fileEntryId == 0 || fileSize == 0 ? "" : url;
		} catch (Exception e) {
			_log.error(e.getMessage());
			return "";
		}
	}

	public static String getTrademarkLogoUrl(PortletRequest request, String rootTMId) {
	/*	String folderName = TrademarksSearch.getTrademarksFolderName(rootTMId);
		long logoFolderId = TrademarksSearch.getLogoFolderId(request, folderName);
		String fileUrl = "";
		if (logoFolderId != 0) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			List<Map<String, String>> logos = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(), logoFolderId, false);
			if (Validator.isNotNull(logos) && !logos.isEmpty()) {
				fileUrl = Utils.getDLFileUrl(request, logos.get(0).get(LegalConstants.FILE_ENTRY_ID));
			}
		} */
		String fileUrl = "";
		long fileEntryId = GetterUtil.getLong(getTrademarkLogoFileEntryId(request,rootTMId));
		if(fileEntryId != 0){
			fileUrl = Utils.getDLFileUrl(request,fileEntryId);
		}
		return fileUrl;
	}
	public static String getTrademarkLogoFileEntryId(PortletRequest request, String rootTMId) {
		String folderName = TrademarksSearch.getTrademarksFolderName(rootTMId);
		long logoFolderId = TrademarksSearch.getLogoFolderId(request, folderName);
		if (logoFolderId != 0) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			List<Map<String, String>> logos = Utils.getFiles4mIndexer(themeDisplay.getCompanyId(), logoFolderId, false);
			if (Validator.isNotNull(logos) && !logos.isEmpty()) {
				 return logos.get(0).get(LegalConstants.FILE_ENTRY_ID);
			}
		}
		return "";
	}
	private static final String APPLICATION_NUM_COUNTRY_FORMAT = " %s / %s";
}
