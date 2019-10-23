package com.sambaash.platform.startupprofile.reports;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;

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
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.startupprofile.StartupConstants;
import com.sambaash.platform.startupprofile.helper.StartupProfileHelper;

public class StartupProfileExporter {

	private static final Log _log = LogFactoryUtil
			.getLog(StartupProfileExporter.class);

	public static String exportDoc(Document[] documents,
			ThemeDisplay themeDisplay, PortletRequest request) throws Exception {

		if (_log.isDebugEnabled())
			_log.debug("Total Documents : " + documents.length);

		// create top header
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet");
		XSSFRow createRow = sheet.createRow(4);
		XSSFCell cell = createRow.createCell(1);
		cell.setCellValue("Startup Name");
		cell = createRow.createCell(2);
		cell.setCellValue("Website");
		cell = createRow.createCell(3);
		cell.setCellValue("HeadQuarters");
		cell = createRow.createCell(4);
		cell.setCellValue("Country");
		cell = createRow.createCell(5);
		cell.setCellValue("Incorporated");
		cell = createRow.createCell(6);
		cell.setCellValue("Interested In");
		cell = createRow.createCell(7);
		cell.setCellValue("Number of Employees");
		cell = createRow.createCell(8);
		cell.setCellValue("Founded on");
		cell = createRow.createCell(9);
		cell.setCellValue("Board Members (|| separated)");
		cell = createRow.createCell(10);
		cell.setCellValue("Profile Outline");
		cell = createRow.createCell(11);
		cell.setCellValue("Short Pitch");
		cell = createRow.createCell(12);
		cell.setCellValue("Description");
		cell = createRow.createCell(13);
		cell.setCellValue("How do you interact with customers");
		cell = createRow.createCell(14);
		cell.setCellValue("Startup Lifecycle Stage");
		cell = createRow.createCell(15);
		cell.setCellValue("Competitors");
		cell = createRow.createCell(16);
		cell.setCellValue("What is unique?");
		cell = createRow.createCell(17);
		cell.setCellValue("Videos");
		cell = createRow.createCell(18);
		cell.setCellValue("Links");
		cell = createRow.createCell(19);
		cell.setCellValue("Investors");
		cell = createRow.createCell(20);
		cell.setCellValue("Funding Rounds");
		cell = createRow.createCell(21);
		cell.setCellValue("Total Funds");
		cell = createRow.createCell(22);
		cell.setCellValue("Startup Raising Funds?");
		cell = createRow.createCell(23);
		cell.setCellValue("Founders");
		cell = createRow.createCell(24);
		cell.setCellValue("Fillby Name");
		cell = createRow.createCell(25);
		cell.setCellValue("Fillby title");
		cell = createRow.createCell(26);
		cell.setCellValue("Fillby email");
		cell = createRow.createCell(27);
		cell.setCellValue("Fillby mobile");
		cell = createRow.createCell(28);
		cell.setCellValue("Fillby skypeId");
		cell = createRow.createCell(29);
		cell.setCellValue("Company Email");
		cell = createRow.createCell(30);
		cell.setCellValue("Twitter URL");
		cell = createRow.createCell(31);
		cell.setCellValue("LinkedIn URL");
		cell = createRow.createCell(32);
		cell.setCellValue("Crunchbase URL");

		for (int i = 1; i <= 32; i++) {
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
		try {
			initCountry(request);
			for (int i = 0; i < documents.length; i++) {
				Long orgId = GetterUtil.getLong(documents[i]
						.get(Field.ENTRY_CLASS_PK));
				createRow = sheet.createRow(row++);

				Document orgDoc = documents[i];
				cell = createRow.createCell(1);
				cell.setCellValue(orgDoc.get(StartupConstants.NAME));
				cell = createRow.createCell(2);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_WEBSITE));

				cell = createRow.createCell(3);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_HQ));
				
				String countryCode = orgDoc.get(SambaashConstants.ORGANIZATION_HQ_COUNTRY);
				cell = createRow.createCell(4);
				if (Validator.isNotNull(countryCode)) {
					String country = countryMap.get(countryCode);
					cell.setCellValue(country);					
				} else {
					cell.setCellValue(StringPool.BLANK);
				}

				cell = createRow.createCell(5);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_INCORP_CATEGORY));
				
				cell = createRow.createCell(6);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_STARTUP_CATEGORY));
				
				cell = createRow.createCell(7);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_EMPLOYEE_SIZE));

				cell = createRow.createCell(8);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_FOUNDED_DATE));

//				handleBoardMembers(orgMap, createRow, orgId);
//
				cell = createRow.createCell(10);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_PROFILE_OUTLINE));

				cell = createRow.createCell(11);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_SHORT_PITCH));

				cell = createRow.createCell(12);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_DESCRIPTION));

				cell = createRow.createCell(13);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_EXTRA_INFO));

				cell = createRow.createCell(14);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_LIFECYCLE_STAGE));

//				handleCompetitors(orgMap, createRow, orgId);
				cell = createRow.createCell(16);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_UNIQUE_DESC));

				cell = createRow.createCell(17);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_VIDEOS));

				cell = createRow.createCell(18);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_LINKS));

				// 19
//				handleInvestors(orgMap, createRow, orgId);

				cell = createRow.createCell(20);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_FUNDING_ROUNDS));

				cell = createRow.createCell(21);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_TOTAL_FUNDS));
				cell = createRow.createCell(22);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_RAISING_FUNDS));
				

				cell = createRow.createCell(23);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_FOUNDERS));
				
				cell = createRow.createCell(24);
				cell.setCellValue(orgDoc.get(SambaashConstants.FILLED_BY));
				cell = createRow.createCell(25);
				cell.setCellValue(orgDoc.get(SambaashConstants.FILLED_BY_TITLE));
				cell = createRow.createCell(26);
				cell.setCellValue(orgDoc.get(SambaashConstants.FILLED_BY_EMAIL));
				cell = createRow.createCell(27);
				cell.setCellValue(orgDoc.get(SambaashConstants.FILLED_BY_MOBILE));
				cell = createRow.createCell(28);
				cell.setCellValue(orgDoc.get(SambaashConstants.FILLED_BY_SKYPE_ID));
				
				cell = createRow.createCell(29);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_EMAIL));

				cell = createRow.createCell(30);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_TWITTER_URL));

				cell = createRow.createCell(31);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_LINKEDIN_URL));

				cell = createRow.createCell(32);
				cell.setCellValue(orgDoc.get(SambaashConstants.ORGANIZATION_CRUNCHBASE_URL));
				
			}

			int[] autosizeColumns = { 1, 2, 3, 4, 5, 6, 7, 8, 21, 22, 25, 26,
					27, 28, 29, 30, 31, 32, 33, 34, 35, 36 };
			for (int i = 0; i < autosizeColumns.length; i++) {
				sheet.autoSizeColumn(autosizeColumns[i]);
			}
		} catch (Exception e) {
			_log.error("Error while processing documents", e);
			hasError = true;
		}

		if (hasError)
			return null;

		String filename = StartupProfileHelper.generateExportFileName(
				themeDisplay.getUserId(), "StartupProfiles", ".xlsx");

		workbook.write(new FileOutputStream(new File(filename)));
		return filename;
	}

	static Map<String, String> countryMap = new HashMap<String, String>();

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
