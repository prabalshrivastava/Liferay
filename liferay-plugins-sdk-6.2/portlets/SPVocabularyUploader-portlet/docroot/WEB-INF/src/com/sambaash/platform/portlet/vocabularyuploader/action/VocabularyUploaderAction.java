package com.sambaash.platform.portlet.vocabularyuploader.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.DuplicateCategoryException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Portlet implementation class VocabularyUploaderAction
 */
public class VocabularyUploaderAction extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);

		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
		try {
			/*
			 * Parse the request
			 */
			List<DiskFileItem> items = uploadHandler.parseRequest(request);
			Iterator<DiskFileItem> itr = items.iterator();
			while (itr.hasNext()) {
				DiskFileItem item = itr.next();

				if (!item.isFormField()) {
					//Handle Uploaded files. 
					String itemName = item.getName();

					String row1Col1Name = StringPool.BLANK;
					String row1Col2Name = StringPool.BLANK;
					String row1Col3Name = StringPool.BLANK;
					String row1Col4Name = StringPool.BLANK;

					Map<String, Map<String, List<String>>> dataMapForColumn123 = new HashMap<String, Map<String, List<String>>>();
					List<String> dataListForColumn4 = new ArrayList<String>();

					File file = item.getStoreLocation();
					String filePath = file.getPath();
			List<List<String>> rowList = read(itemName, filePath, 4);

			for (int i = 0; i<rowList.size(); i++) {
				List<String> r = rowList.get(i);
				String col1 = r.get(0);
				String col2 = r.get(1);
				String col3 = r.get(2);
				String col4 = r.get(3);

				if (i == 0) {
					row1Col1Name = col1;
					row1Col2Name = col2;
					row1Col3Name = col3;
					row1Col4Name = col4;
			        	}else {
				        	if (!BLANK_CELL_VALUE.equalsIgnoreCase(col1)) {
					        	Map<String, List<String>> dataMapForColumn23 = null;

						if (!dataMapForColumn123.containsKey(col1)) {
							dataMapForColumn23 = new HashMap<String, List<String>>();
							dataMapForColumn123.put(col1, dataMapForColumn23);
						}else {
							dataMapForColumn23 = dataMapForColumn123.get(col1);
						}

								List<String> dataListForColumn3 = null;

								if (!dataMapForColumn23.containsKey(col2)) {
									dataListForColumn3 = new ArrayList<String>();
							dataMapForColumn23.put(col2, dataListForColumn3);
								}else {
									dataListForColumn3 = dataMapForColumn23.get(col2);
								}

						if (!BLANK_CELL_VALUE.equalsIgnoreCase(col3)) {
									dataListForColumn3.add(col3);
						}
					}

					if (!BLANK_CELL_VALUE.equalsIgnoreCase(col4)) {
						dataListForColumn4.add(col4);
					}
				}
			}

			AssetVocabulary functionalGroupVocabulary = addVocabulary(row1Col1Name, actionRequest);
			long functionalGroupVocabularyId = functionalGroupVocabulary.getVocabularyId();

			        // Functional Group, Job Role, Competence

					//			        int i = 0, j = 0;

					for (Map.Entry<String, Map<String, List<String>>> entryForColumn123 : dataMapForColumn123.entrySet()) {
						//						i++;
						String valueForColumn1 = entryForColumn123.getKey();
						_log.debug(" ***** level 1 : valueForColumn1 : " + valueForColumn1 + " : functionalGroupVocabularyId : "+ functionalGroupVocabularyId );
						addAssetCategory(valueForColumn1, functionalGroupVocabularyId, actionRequest);

						Map<String, List<String>> dataMapForColumn23 = entryForColumn123.getValue();
						AssetVocabulary jobRoleVocabulary = addVocabulary(valueForColumn1 + StringPool.SPACE + StringPool.OPEN_PARENTHESIS + row1Col2Name + StringPool.CLOSE_PARENTHESIS, actionRequest);
						//						AssetVocabulary jobRoleVocabulary = addVocabulary(row1Col2Name + StringPool.SPACE + i, actionRequest);

				long jobRoleVocabularyId = jobRoleVocabulary.getVocabularyId();

						for (Map.Entry<String, List<String>> entryForColumn23 : dataMapForColumn23.entrySet()) {
							//							j++;
							String valueForColumn2 = entryForColumn23.getKey();
							_log.debug("level 2 : valueForColumn2 : " + valueForColumn2 + " : jobRoleVocabularyId : "+ jobRoleVocabularyId );
							addAssetCategory(valueForColumn2, jobRoleVocabularyId, actionRequest);

							List<String> dataListForColumn3 = entryForColumn23.getValue();

							if (dataListForColumn3.size() > 0) {
								AssetVocabulary competencyVocabulary = addVocabulary(valueForColumn2 + StringPool.SPACE + StringPool.OPEN_PARENTHESIS + row1Col3Name + StringPool.CLOSE_PARENTHESIS, actionRequest);
								//								AssetVocabulary competencyVocabulary = addVocabulary(row1Col3Name + StringPool.SPACE + j, actionRequest);
								long competencyVocabularyId = competencyVocabulary.getVocabularyId();

								for (String valueForColumn3 : dataListForColumn3) {
									try {
										_log.debug("level 3 : valueForColumn3 : " + valueForColumn3 + " : competencyVocabularyId : "+ competencyVocabularyId );
										addAssetCategory(valueForColumn3, competencyVocabularyId, actionRequest);
									}catch (DuplicateCategoryException e) {

										// do nothing

									}
								}
							}
						}

					}

					// Certification

					if (dataListForColumn4.size() > 0) {
						AssetVocabulary certificationVocabulary = addVocabulary(row1Col4Name, actionRequest);
				long certificationVocabularyId = certificationVocabulary.getVocabularyId();

						for (String valueForColumn4 : dataListForColumn4) {
							try {
								addAssetCategory(valueForColumn4, certificationVocabularyId, actionRequest);
							}catch (DuplicateCategoryException e) {

								// do nothing

							}
						}
					}

				}
			}

			addSuccessMessage(actionRequest, actionResponse);

		}catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.processAction(actionRequest, actionResponse);
	}

	private AssetCategory addAssetCategory(String name, long vocabularyId, ActionRequest actionRequest) throws PortalException, SystemException {
		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(LocaleUtil.getDefault(), name);
		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
		String[] categoryProperties = new String[0];
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AssetCategory.class.getName(), actionRequest);

		long parentCategoryId = 0;
		AssetCategory category = AssetCategoryServiceUtil.addCategory(parentCategoryId, titleMap, descriptionMap, vocabularyId,
																	categoryProperties, serviceContext);

		return category;
	}

	private AssetVocabulary addVocabulary(String name, ActionRequest actionRequest) throws PortalException, SystemException {
		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(LocaleUtil.getDefault(), name);
		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
		UnicodeProperties settingsProperties = new UnicodeProperties();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AssetVocabulary.class.getName(), actionRequest);

		AssetVocabulary vocabulary = AssetVocabularyServiceUtil.addVocabulary(
																			StringPool.BLANK, titleMap, descriptionMap, settingsProperties.toString(), serviceContext);

		return vocabulary;
	}

	private HSSFWorkbook readFileXls(String filename) throws IOException {
		return new HSSFWorkbook(new FileInputStream(filename));
	}

	private XSSFWorkbook readFileXlsx(String filename) throws IOException {
		return new XSSFWorkbook(new FileInputStream(filename));
	}

	private List<List<String>> read(String fileName, String filePath, int columnNo) {
		List<List<String>> list = new ArrayList<List<String>>();
		try {
			if (fileName.endsWith(OLD_EXCEL_EXTENSION)) {
				Workbook wb;
				wb = readFileXls(filePath);

				for (int i = 0; i < wb.getNumberOfSheets(); i++) {
					Sheet sheet = wb.getSheetAt(i);
					int rowNum = 0;
					_log.debug(OLD_EXCEL_EXTENSION + " ******** Sheet number : " + i);

					for (Row row : sheet) {
						List<String> l = new ArrayList<String>();

						for (int m = 0; m<columnNo; m++) {
							_log.debug(" ******** rowNum " + rowNum + " : colNum : " + m);
							Cell cell = row.getCell(m);

							if (cell != null) {
								l.add(cell.toString().trim());
							}
						}

						list.add(l);
					}
				}
			} else if (fileName.endsWith(NEW_EXCEL_EXTENSION)) {
				Workbook wb = readFileXlsx(filePath);

				for (int i = 0; i < wb.getNumberOfSheets(); i++) {
					Sheet sheet = wb.getSheetAt(i);
					int rowNum = 0;
					_log.debug(NEW_EXCEL_EXTENSION + " ******** Sheet number : " + i);

					for (Row row : sheet) {
						List<String> l = new ArrayList<String>();

						for (int m = 0; m<columnNo; m++) {
							_log.debug(" ******** rowNum " + rowNum + " : colNum : " + m);
							Cell cell = row.getCell(m);

							if (cell != null) {
								l.add(cell.toString().trim());
							}
						}

						list.add(l);
						rowNum++;
					}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return list;
	}

	private final String OLD_EXCEL_EXTENSION = ".xls";
	private final String NEW_EXCEL_EXTENSION = ".xlsx";

	private final String BLANK_CELL_VALUE = "BLANK";

	private static Log _log = LogFactoryUtil.getLog(VocabularyUploaderAction.class);

}