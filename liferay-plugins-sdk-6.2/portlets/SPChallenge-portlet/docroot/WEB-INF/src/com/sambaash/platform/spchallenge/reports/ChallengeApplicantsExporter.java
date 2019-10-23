package com.sambaash.platform.spchallenge.reports;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.apache.commons.lang.time.StopWatch;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.spchallenge.helper.SPChallengeConstants;
import com.sambaash.platform.spchallenge.helper.SPChallengeHelper;
import com.sambaash.platform.srv.startupprofile.model.Address;
import com.sambaash.platform.srv.startupprofile.model.FundingRound;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.model.Person;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class ChallengeApplicantsExporter {

	private static final Log _log = LogFactoryUtil
			.getLog(ChallengeApplicantsExporter.class);

	public static String exportDoc(Document[] documents,
			ThemeDisplay themeDisplay, PortletRequest request) throws Exception {

		Map<Long, Document> orgDocMap = new HashMap<Long, Document>();
		if (_log.isDebugEnabled())
			_log.debug("Total Documents : " + documents.length);

		// create top header
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet");

		XSSFRow createRow = sheet.createRow(4);
		XSSFCell cell = createRow.createCell(1);
		cell.setCellValue("Challenge Name");
		cell = createRow.createCell(2);
		cell.setCellValue("Startup Name");
		cell = createRow.createCell(3);
		cell.setCellValue("Question 1");
		cell = createRow.createCell(4);
		cell.setCellValue("Question 2");
		cell = createRow.createCell(5);
		cell.setCellValue("Question 3");

		cell = createRow.createCell(6);
		cell.setCellValue("Applied on");
		cell = createRow.createCell(7);
		cell.setCellValue("Website");
		cell = createRow.createCell(8);
		cell.setCellValue("HeadQuarters");
		cell = createRow.createCell(9);
		cell.setCellValue("Country");
		cell = createRow.createCell(10);
		cell.setCellValue("Incorporated");
		cell = createRow.createCell(11);
		cell.setCellValue("Interested In");
		cell = createRow.createCell(12);
		cell.setCellValue("Number of Employees");
		cell = createRow.createCell(13);
		cell.setCellValue("Founded on");
		cell = createRow.createCell(14);
		cell.setCellValue("Board Members (|| separated)");
		cell = createRow.createCell(15);
		cell.setCellValue("Profile Outline");
		cell = createRow.createCell(16);
		cell.setCellValue("Short Pitch");
		cell = createRow.createCell(17);
		cell.setCellValue("Long Description");
		cell = createRow.createCell(18);
		cell.setCellValue("How do you interact with customers");
		cell = createRow.createCell(19);
		cell.setCellValue("Startup Lifecycle Stage");
		cell = createRow.createCell(20);
		cell.setCellValue("Competitors");
		cell = createRow.createCell(21);
		cell.setCellValue("What is unique?");
		cell = createRow.createCell(22);
		cell.setCellValue("Videos");
		cell = createRow.createCell(23);
		cell.setCellValue("Links");
		cell = createRow.createCell(24);
		cell.setCellValue("Investors");
		cell = createRow.createCell(25);
		cell.setCellValue("Funding Rounds");
		cell = createRow.createCell(26);
		cell.setCellValue("Total Funds");
		cell = createRow.createCell(27);
		cell.setCellValue("Startup Raising Funds?");
		cell = createRow.createCell(28);
		cell.setCellValue("Founders");
		cell = createRow.createCell(29);
		cell.setCellValue("Fillby Name");
		cell = createRow.createCell(30);
		cell.setCellValue("Fillby title");
		cell = createRow.createCell(31);
		cell.setCellValue("Fillby email");
		cell = createRow.createCell(32);
		cell.setCellValue("Fillby mobile");
		cell = createRow.createCell(33);
		cell.setCellValue("Fillby skypeId");
		cell = createRow.createCell(34);
		cell.setCellValue("Company Email");
		cell = createRow.createCell(35);
		cell.setCellValue("Twitter URL");
		cell = createRow.createCell(36);
		cell.setCellValue("LinkedIn URL");
		cell = createRow.createCell(37);
		cell.setCellValue("Crunchbase URL");
		
		for (int i = 1; i <= 37; i++) {
			sheet.setColumnWidth(i, 10000);
			cell = createRow.getCell(i);
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFillForegroundColor(new XSSFColor(new java.awt.Color(
					210, 210, 210)));
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			cell.setCellStyle(cellStyle);
		}
		int row = 5;
		boolean hasError = false;
		Document orgDoc = null;
		try {
			initCountry(request);
			StopWatch mainStopWatch = new StopWatch();
			for (int i = 0; i < documents.length; i++) {
				Document doc = documents[i];
				
				Long orgId = GetterUtil.getLong(doc
						.get(SPChallengeConstants.APPLICANT_REF_ID));

				String challengeName = doc.get(SPChallengeConstants.CHALLENGE_NAME);
				_log.debug("Started processing the application of orgId "+orgId+" for the challenge: "+challengeName);
				mainStopWatch.start();
				
				try {
					orgDoc = getOrgDocument(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), orgId, orgDocMap);
					mainStopWatch.split();
					_log.debug("Took "+mainStopWatch.getSplitTime()+" ms to retrieve orgId "+orgId);
					mainStopWatch.unsplit();
				} catch (Exception e) {
					_log.error("Organization missing in table orgId = " + orgId);
				}
				if (Validator.isNull(orgDoc)) {
					mainStopWatch.stop();
					_log.debug("Finished processing of NOT FOUND orgId "+orgId+" for the challenge: "+challengeName+" in "+mainStopWatch.getTime()+" ms");
					mainStopWatch.reset();
					continue;
				}
				createRow = sheet.createRow(row++);

				cell = createRow.createCell(1);
				cell.setCellValue(doc.get(SPChallengeConstants.CHALLENGE_NAME));

				cell = createRow.createCell(2);
				cell.setCellValue(doc.get(SPChallengeConstants.ORGANIZATION_NAME));

				cell = createRow.createCell(3);
				cell.setCellValue(doc.get(SPChallengeConstants.Q1));

				cell = createRow.createCell(4);
				cell.setCellValue(doc.get(SPChallengeConstants.Q2));

				cell = createRow.createCell(5);
				cell.setCellValue(doc.get(SPChallengeConstants.Q3));

				cell = createRow.createCell(6);
				cell.setCellValue(doc.get(Field.CREATE_DATE));

				cell = createRow.createCell(7);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_WEBSITE));

				cell = createRow.createCell(8);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_HQ));
				
				String countryCode = orgDoc.get(SambaashConstants.ORGANIZATION_HQ_COUNTRY);
				cell = createRow.createCell(9);
				if (Validator.isNotNull(countryCode)) {
					String country = countryMap.get(countryCode);
					cell.setCellValue(country);					
				} else {
					cell.setCellValue(StringPool.BLANK);
				}
				
				cell = createRow.createCell(10);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_INCORP_CATEGORY));
				
				cell = createRow.createCell(11);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_STARTUP_CATEGORY));
				
				cell = createRow.createCell(12);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_EMPLOYEE_SIZE));

				cell = createRow.createCell(13);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_FOUNDED_DATE));

				cell = createRow.createCell(15);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_PROFILE_OUTLINE));

				cell = createRow.createCell(16);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_SHORT_PITCH));

				cell = createRow.createCell(17);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_DESCRIPTION));

				cell = createRow.createCell(18);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_EXTRA_INFO));

				cell = createRow.createCell(19);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_LIFECYCLE_STAGE));

//				handleCompetitors(orgMap, createRow, orgId);
				cell = createRow.createCell(20);
				cell.setCellValue(StringPool.BLANK);
				
				cell = createRow.createCell(21);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_UNIQUE_DESC));

				cell = createRow.createCell(22);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_VIDEOS));

				cell = createRow.createCell(23);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_LINKS));

//				handleInvestors(orgMap, createRow, orgId);
				cell = createRow.createCell(24);
				cell.setCellValue(StringPool.BLANK);

				cell = createRow.createCell(25);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_FUNDING_ROUNDS));

				cell = createRow.createCell(26);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_TOTAL_FUNDS));
				cell = createRow.createCell(27);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_RAISING_FUNDS));

				cell = createRow.createCell(28);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_FOUNDERS));
				
				cell = createRow.createCell(29);
				cell.setCellValue(orgDoc.get(SambaashConstants.FILLED_BY));
				cell = createRow.createCell(30);
				cell.setCellValue(orgDoc.get(SambaashConstants.FILLED_BY_TITLE));
				cell = createRow.createCell(31);
				cell.setCellValue(orgDoc.get(SambaashConstants.FILLED_BY_EMAIL));
				cell = createRow.createCell(32);
				cell.setCellValue(orgDoc.get(SambaashConstants.FILLED_BY_MOBILE));
				cell = createRow.createCell(33);
				cell.setCellValue(orgDoc.get(SambaashConstants.FILLED_BY_SKYPE_ID));
				
				cell = createRow.createCell(34);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_EMAIL));

				cell = createRow.createCell(35);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_TWITTER_URL));

				cell = createRow.createCell(36);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_LINKEDIN_URL));

				cell = createRow.createCell(37);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_CRUNCHBASE_URL));
				
				mainStopWatch.stop();
				_log.debug("Finished processing the application of orgId "+orgId+" for the challenge: "+challengeName+" in "+mainStopWatch.getTime()+" ms");
				mainStopWatch.reset();
			}
			
			int[] autosizeColumns = { 1, 2, 3, 4, 5, 6, 7, 8, 21, 22, 25, 26,
					27, 28, 29, 30, 31, 32, 33, 34, 35, 36 };
			for (int i = 0; i < autosizeColumns.length; i++) {
				sheet.autoSizeColumn(autosizeColumns[i]+5);
			}
		} catch (Exception e) {
			_log.error("Error while processing documents", e);
			hasError = true;
		}

		if (hasError)
			return null;

		String filename = SPChallengeHelper.generateExportFileName(
				themeDisplay.getUserId(), "StartupProfiles", ".xlsx");

		workbook.write(new FileOutputStream(new File(filename)));
		return filename;
	}

	private static Document getOrgDocument(long companyId, long groupId, Long orgId, Map<Long, Document> orgDocMap) {
		Document doc = orgDocMap.get(orgId);
		if (doc == null) {
			try {
				doc = searchOrgDocument(companyId, groupId, orgId).getDocs()[0];
				orgDocMap.put(orgId, doc);				
			} catch (Exception e) {
				_log.error("Unable to find document for orgId = "+orgId, e);
			}
		}
		
		return doc;
	}

	private static Hits searchOrgDocument(long companyId, long groupId, Long orgId) throws SearchException {
		SearchContext searchContext = newSearchContext(companyId, groupId);
		
		BooleanQuery searchQuery = newSearchQuery(searchContext, companyId, groupId);
		searchQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, Organization.class.getName());
		searchQuery.addRequiredTerm(Field.ENTRY_CLASS_PK, orgId);
		
//		searchQuery.add(TermQueryFactoryUtil.create(searchContext, Field.ENTRY_CLASS_NAME, Organization.class.getName()), BooleanClauseOccur.MUST);
//		searchQuery.addRequiredTerm(Field.ENTRY_CLASS_PK, orgId); 
		Hits results = SearchEngineUtil.search(searchContext.getSearchEngineId(),companyId, searchQuery, -1, -1);
		
		return results;
	}
	
	

	private static SearchContext newSearchContext(long companyId, long groupId) {
		SearchContext searchContext = new SearchContext();
		searchContext.setStart(-1);
		searchContext.setEnd(-1);
		searchContext.setEntryClassNames(new String[]{Organization.class.getName()});
		searchContext.setGroupIds(new long[] { groupId });
		searchContext.setCompanyId(companyId);
		return searchContext;
	}

	private static BooleanQuery newSearchQuery(SearchContext searchContext, long companyId, long groupId) {
		BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
		searchQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
		searchQuery.addRequiredTerm(Field.SCOPE_GROUP_ID, groupId);
		return searchQuery;
	}
	
	static Map<String, String> countryMap = new HashMap<String, String>();

	private static void handleInvestors(Map<String, Object> orgMap,
			XSSFRow createRow, Long orgId) throws Exception {
		String inv = StringPool.BLANK;
		for (int i = 1;; i++) {
			try {
				Object object = orgMap
						.get(SPChallengeConstants.ATTRIB_INVESTOR_COMP + i);
				if (Validator.isNull(object))
					break;
				Organization comp = (Organization) object;
				String name = comp.getName();
				String description = comp.getDescription();
				String text = "";
				if (!Validator.isNull(name)) {
					text += name;
				} else {
					continue;
				}
				text += ", ";
				if (!Validator.isNull(description)) {
					text = text + description;
				}
				inv = inv + "|| " + text;
			} catch (Exception e) {
				_log.error("Error while reading board member", e);
			}
		}

		XSSFCell cell = createRow.createCell(24);
		if (inv.length() > 0) {
			cell.setCellValue(inv.substring(2));
		}
	}

	private static void handleCompetitors(Map<String, Object> orgMap,
			XSSFRow createRow, Long orgId) throws Exception {

		String board = StringPool.BLANK;
		for (int i = 1;; i++) {
			try {
				Object object = orgMap
						.get(SPChallengeConstants.ATTRIB_COMPETITOR + i);
				if (Validator.isNull(object))
					break;
				Organization comp = (Organization) object;
				String name = comp.getName();
				String description = comp.getDescription();
				String text = "";
				if (!Validator.isNull(name)) {
					text += name;
				} else {
					continue;
				}
				text += ", ";
				if (!Validator.isNull(description)) {
					text = text + description;
				}
				board = board + "|| " + text;
			} catch (Exception e) {
				_log.error("Error while reading board member", e);
			}
		}

		XSSFCell cell = createRow.createCell(20);
		if (board.length() > 0) {
			cell.setCellValue(board.substring(2));
		}

	}

	private static void handleBoardMembers(Map<String, Object> orgMap,
			XSSFRow createRow, long orgId) throws Exception {

		String board = StringPool.BLANK;
		for (int i = 1;; i++) {
			try {
				Object object = orgMap
						.get(SPChallengeConstants.ATTRIB_BOARD_MEMBER + i);
				if (Validator.isNull(object))
					break;
				Person boardMember = (Person) object;
				String name = boardMember.getName();
				String description = boardMember.getDescription();
				String text = "";
				if (!Validator.isNull(name)) {
					text += name;
				} else {
					continue;
				}
				text += ", ";
				if (!Validator.isNull(description)) {
					text = text + description;
				}
				board = board + "|| " + text;
			} catch (Exception e) {
				_log.error("Error while reading board member", e);
			}
		}

		XSSFCell cell = createRow.createCell(14);
		if (board.length() > 0) {
			cell.setCellValue(board.substring(2));
		}
	}

	private static void initCountry(PortletRequest request) {
		try {
			List<Country> items = CountryServiceUtil.getCountries(true);
			String languageId = LanguageUtil.getLanguageId(request);
			int pos = languageId.indexOf(CharPool.UNDERLINE);
			Locale locale = LocaleUtil.getDefault();
			if (pos >= 0) {
				String language = languageId.substring(0, pos);
				locale = LocaleUtil.fromLanguageId(language);
			}
			for (Country country : items) {
				countryMap.put(country.getCountryId() + "", StringUtil
						.upperCaseFirstLetter(country.getName(locale)));
			}
		} catch (Exception e) {
			_log.error("Error while reading country information", e);
		}
		if (_log.isDebugEnabled())
			_log.debug("Country Map" + countryMap);
	}
}
