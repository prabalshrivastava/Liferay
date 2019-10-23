package com.sambaash.platform.portlet.legalandcontract.reports;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.portlet.legalandcontract.util.AgencyConstants;
import com.sambaash.platform.portlet.legalandcontract.util.LitigationConstants;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;

public class ExcelGenerator extends ReportGenerator {
	private static final Log _log = LogFactoryUtil.getLog(ExcelGenerator.class);
	@Override
	public void generateReport(ReportPayload payload, File file)
			throws Exception {

		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet(payload.getType());

			if (GetterUtil.getString(payload.getType()).endsWith("List"))
				createListReport(workbook, sheet, payload);
			else
				createDetailsReport(workbook, sheet, payload);

			workbook.write(new FileOutputStream(file));
		} catch (Exception ee) {
			_log.error(ee.getMessage());
		}
	}
	
	private Picture drawImage(long feId,int rowNo, int cellNo, Workbook wb,Sheet sheet){
		try {
			if (feId != 0) {
				FileEntry fe = DLAppServiceUtil.getFileEntry(feId);
				byte[] bytes = IOUtils.toByteArray(fe.getContentStream());
				int PICTURE_TYPE;
				String mimeType = fe.getMimeType().toLowerCase();
				if(mimeType.contains("png") ){
					PICTURE_TYPE = Workbook.PICTURE_TYPE_PNG;
				}else if(mimeType.contains("jpg") || mimeType.contains("jpeg")){
					PICTURE_TYPE = Workbook.PICTURE_TYPE_JPEG;
				}else if(mimeType.contains("dib")){
					PICTURE_TYPE = Workbook.PICTURE_TYPE_DIB;
				}else if(mimeType.contains("emf")){
					PICTURE_TYPE = Workbook.PICTURE_TYPE_EMF;
				}else if(mimeType.contains("wmf")){
					PICTURE_TYPE = Workbook.PICTURE_TYPE_WMF;
				}else{
					PICTURE_TYPE = Workbook.PICTURE_TYPE_JPEG;
				}
				int pictureIdx = wb.addPicture(bytes, PICTURE_TYPE);
				CreationHelper helper = wb.getCreationHelper();
				Drawing drawing = sheet.createDrawingPatriarch();
				ClientAnchor anchor = helper.createClientAnchor();
				anchor.setAnchorType(ClientAnchor.DONT_MOVE_AND_RESIZE);
				// set top-left corner for the image
				anchor.setRow1(rowNo);
				anchor.setCol1(cellNo);
				anchor.setRow2(rowNo+1);
				anchor.setCol2(cellNo);
				// Creates a picture
				Picture pict = drawing.createPicture(anchor, pictureIdx);
			//	pict.resize(0.7);
				// Reset the image to the original size
				//pict.resize();
				
				//pict.
				return pict;
			}
		} catch (Exception e) {
			_log.error("Error while drawing image in excel");
		}
		return null;
	}

	private void createDetailsReport(XSSFWorkbook workbook, XSSFSheet sheet,
			ReportPayload payload) {

		List<ReportRecord> recList = payload.getRecList();
		if (recList == null || recList.size() <= 0)
			return;
		ReportRecord reportRecord = recList.get(0);
		Map<String, String> dataMap = reportRecord.getDataMap();
		Set<Entry<String, String>> eSet = dataMap.entrySet();
		int i = 3;
		for (Entry<String, String> entry : eSet) {
			if (entry.getKey().equalsIgnoreCase("DetailsLink"))
				continue;
			//if (entry.getValue().toLowerCase().startsWith("http"))
				//continue;
			XSSFFont font1 = workbook.createFont();
			font1.setFontHeightInPoints((short) 14);
			font1.setFontName("Times New Roman");
			XSSFCellStyle style1 = workbook.createCellStyle();
			style1.setFont(font1);
			style1.setFillForegroundColor(new XSSFColor(
					new Color(245, 248, 251)));
			style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
			style1.setBorderTop(XSSFCellStyle.BORDER_THIN);
			style1.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style1.setWrapText(true);
			
			// start for litigations only
			if (entry.getKey().startsWith(
					LitigationConstants.RESPONSE_DEADLINE_COLUMN)) {
				i = i + 1;
				XSSFRow row = sheet.createRow(i++);
				XSSFCell cell = row.createCell(1);
				cell.setCellStyle(style1);
				cell.setCellValue("Response Deadline");
				cell = row.createCell(2);
				cell.setCellValue(entry.getValue().substring(0,
						entry.getValue().indexOf("~~")));

				row = sheet.createRow(i++);
				cell = row.createCell(1);
				cell.setCellStyle(style1);
				cell.setCellValue("Alert Before");
				cell = row.createCell(2);
				cell.setCellValue(entry.getValue().substring(
						entry.getValue().indexOf("~~") + 2));
				continue;
			}
			// end litigations only

			XSSFRow row = sheet.createRow(i++);
			XSSFCell cell = row.createCell(1);
			cell.setCellStyle(style1);
			cell.setCellValue(entry.getKey());
			XSSFCellStyle style2 = workbook.createCellStyle();
			style2.setWrapText(true);
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			if(ReportGenerator.LITIGATION_DETAILS.equalsIgnoreCase(payload.getType())){
				String logoId = reportRecord.getExtraData(TrademarksConstants.LOGO_FILE_ENTRY_ID);
				if(Validator.isNotNull(logoId) && GetterUtil.getLong(logoId) != 0 && entry.getKey().equalsIgnoreCase(
						TrademarksConstants.TRADEMARK_COLUMN)){
					// dont display url
				}else{
					cell.setCellValue(entry.getValue());
				}
			}else if(ReportGenerator.TRADEMARK_DETAILS.equalsIgnoreCase(payload.getType())){
				String logoId = reportRecord.getExtraData(TrademarksConstants.LOGO_FILE_ENTRY_ID);
				if(Validator.isNotNull(logoId) && GetterUtil.getLong(logoId) != 0 && entry.getKey().equalsIgnoreCase(
						TrademarksConstants.TRADEMARK_COLUMN)){
					// dont display url
				}else{
					cell.setCellValue(entry.getValue());
				}
			}
			else{
				cell.setCellValue(entry.getValue());
			}

		}
		
		if(ReportGenerator.TRADEMARK_DETAILS.equalsIgnoreCase(payload.getType())){
			int rowCount = 4;
			String logoId = reportRecord.getExtraData(TrademarksConstants.LOGO_FILE_ENTRY_ID);
			if(Validator.isNotNull(logoId) &&  GetterUtil.getLong(logoId) != 0){
				try {
					FileEntry fe = DLAppServiceUtil.getFileEntry(GetterUtil.getLong(logoId));
					byte[] bytes = IOUtils.toByteArray(fe.getContentStream());
					new ExcelImageHelper().addImageToSheet("C"+rowCount, sheet, sheet.createDrawingPatriarch(),
							bytes, 22, 21,
							ExcelImageHelper.EXPAND_ROW_AND_COLUMN,fe.getMimeType());
				} catch (Exception e) {
				} 
			}
			
			rowCount = rowCount + 1;
		}
		if(ReportGenerator.LITIGATION_DETAILS.equalsIgnoreCase(payload.getType())){
			int rowCount = 5;
			String logoId = reportRecord.getExtraData(TrademarksConstants.LOGO_FILE_ENTRY_ID);
			if(Validator.isNotNull(logoId) && GetterUtil.getLong(logoId) != 0){
				try {
					FileEntry fe = DLAppServiceUtil.getFileEntry(GetterUtil.getLong(logoId));
					byte[] bytes = IOUtils.toByteArray(fe.getContentStream());
					new ExcelImageHelper().addImageToSheet("C"+rowCount, sheet, sheet.createDrawingPatriarch(),
							bytes, 22, 21,
							ExcelImageHelper.EXPAND_ROW_AND_COLUMN,fe.getMimeType());
				} catch (Exception e) {
				} 
			}
			
			rowCount = rowCount + 1;
		}
		
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		int col = sheet.getColumnWidth(2);
		if (col > 100000)
			sheet.setColumnWidth(2, 30000);
		else if (col > 50000){
			sheet.setColumnWidth(2, 25000);
		}else if(col > 10000){
			sheet.setColumnWidth(2, 10000);
		}
	}
	
	private void createSetHyperLink(XSSFWorkbook workbook,XSSFCell cell,String address){
		try {
			CreationHelper createHelper = workbook
					.getCreationHelper();
			Hyperlink link = createHelper
					.createHyperlink(Hyperlink.LINK_URL);
			link.setAddress(address);
			cell.setHyperlink( link);
			cell.getCellStyle().getFont().setColor(new XSSFColor(new java.awt.Color(11,0,255)));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void createListReport(XSSFWorkbook workbook, XSSFSheet sheet,
			ReportPayload payload) {

		XSSFRow row = sheet.createRow(4);
		List<ReportRecord> recList = payload.getRecList();
		int colCount = createHeader(workbook, row, recList.get(0));
		int rowCount = 5;
		for (ReportRecord reportRecord : recList) {
			row = sheet.createRow(rowCount++);
			Map<String, String> dataMap = reportRecord.getDataMap();
			Set<Entry<String, String>> eSet = dataMap.entrySet();
			int i = 1;
			for (Entry<String, String> entry : eSet) {
				if (entry.getKey().startsWith("DetailsLink"))
					continue;
				XSSFCell cell = row.createCell(i);
				setStyle(cell, rowCount, workbook);
				if (!entry.getValue().startsWith("http"))
					cell.setCellValue(entry.getValue());
				
				if(ReportGenerator.TRADEMARK_LISTING.equalsIgnoreCase(payload.getType())){
					if(TrademarksConstants.APPLICATION_NO_COLUMN.equalsIgnoreCase(entry.getKey())){
						createSetHyperLink(workbook, cell, dataMap.get(TrademarksConstants.DETAILS_LINK));
					}
					
				}else if(ReportGenerator.LITIGATION_LISTING.equalsIgnoreCase(payload.getType())){
					if(LitigationConstants.TRADEMARK_APPNO_COUNTRY.equalsIgnoreCase(entry.getKey())){
						createSetHyperLink(workbook, cell, dataMap.get(LitigationConstants.DETAILS_LINK));
					}
					if(TrademarksConstants.TRADEMARK_COLUMN.equalsIgnoreCase(entry.getKey())){
						createSetHyperLink(workbook, cell, dataMap.get(LitigationConstants.DETAILS_LINK + "_TM"));
					}
					
				}else {
					if(AgencyConstants.NUMBER_COLUMN.equalsIgnoreCase(entry.getKey())){
						createSetHyperLink(workbook, cell, dataMap.get(AgencyConstants.DETAILS_LINK));
					}
				
				}
				
				i = i + 1;
			}
		}
		

		for (int i = 0; i <= colCount; i++) {
			sheet.autoSizeColumn(i);
			int col = sheet.getColumnWidth(i);
			if (col > 10000)
				sheet.setColumnWidth(i, 10000);
		}
		
		rowCount = 6;
		int col = 1;
		if(ReportGenerator.TRADEMARK_LISTING.equalsIgnoreCase(payload.getType())){
		for (ReportRecord reportRecord : recList) {
				sheet.setColumnWidth(col, 5000);
				row.setHeight((short) 1500);
				rowCount ++;
			}
		}
		if(ReportGenerator.TRADEMARK_LISTING.equalsIgnoreCase(payload.getType())){
			rowCount = 6;
			for (ReportRecord reportRecord : recList) {
				String logoId = reportRecord.getExtraData(TrademarksConstants.LOGO_FILE_ENTRY_ID);
				if(Validator.isNotNull(logoId) && GetterUtil.getLong(logoId) != 0){
					String url = reportRecord.getExtraData(TrademarksConstants.TRADEMARK_COLUMN);
					try {
						FileEntry fe = DLAppServiceUtil.getFileEntry(GetterUtil.getLong(logoId));
						byte[] bytes = IOUtils.toByteArray(fe.getContentStream());
						new ExcelImageHelper().addImageToSheet("B"+rowCount, sheet, sheet.createDrawingPatriarch(),
								bytes, 22, 21,
								ExcelImageHelper.EXPAND_ROW_AND_COLUMN,fe.getMimeType());
					} catch (Exception e) {
					} 
				}
				
				rowCount = rowCount + 1;
				
			}
		}
		if(ReportGenerator.LITIGATION_LISTING.equalsIgnoreCase(payload.getType())){
			rowCount = 6;
			for (ReportRecord reportRecord : recList) {
				String logoId = reportRecord.getExtraData(TrademarksConstants.LOGO_FILE_ENTRY_ID);
				if(Validator.isNotNull(logoId) && GetterUtil.getLong(logoId) != 0){
					String url = reportRecord.getExtraData(TrademarksConstants.TRADEMARK_COLUMN);
					try {
						FileEntry fe = DLAppServiceUtil.getFileEntry(GetterUtil.getLong(logoId));
						byte[] bytes = IOUtils.toByteArray(fe.getContentStream());
						new ExcelImageHelper().addImageToSheet("C"+rowCount, sheet, sheet.createDrawingPatriarch(),
								bytes, 22, 21,
								ExcelImageHelper.EXPAND_ROW_AND_COLUMN,fe.getMimeType());
					} catch (Exception e) {
					} 
				}
				
				rowCount = rowCount + 1;
				
			}
		}

	}

	private int createHeader(XSSFWorkbook wb, XSSFRow row,
			ReportRecord reportRecord) {
		XSSFFont font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 14);
		font1.setFontName("Times New Roman");
		font1.setColor(IndexedColors.WHITE.getIndex());
		XSSFCellStyle style1 = wb.createCellStyle();
		style1.setFillForegroundColor(new XSSFColor(new Color(77, 93, 99)));
		style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style1.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style1.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style1.setFont(font1);

		Map<String, String> dataMap = reportRecord.getDataMap();
		Set<String> keys = dataMap.keySet();
		int colCount = 1;
		for (String key : keys) {
			if (key.startsWith("DetailsLink"))
				continue;
			XSSFCell cell = row.createCell(colCount++);
			cell.setCellStyle(style1);
			cell.setCellValue(key);
		}
		return colCount;
	}

	private void setStyle(XSSFCell cell, int rowCount, XSSFWorkbook wb) {
		XSSFFont font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 14);
		font1.setFontName("Times New Roman");
		XSSFCellStyle style1 = wb.createCellStyle();
		style1.setFont(font1);
		if (rowCount % 2 != 0)
			style1.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		else
			style1.setFillForegroundColor(new XSSFColor(
					new Color(245, 248, 251)));
		style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style1.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style1.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style1.setWrapText(true);
		cell.setCellStyle(style1);
	}
}
