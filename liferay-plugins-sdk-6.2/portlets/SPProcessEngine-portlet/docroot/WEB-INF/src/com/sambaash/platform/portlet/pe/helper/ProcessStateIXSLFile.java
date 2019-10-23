package com.sambaash.platform.portlet.pe.helper;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ProcessStateIXSLFile {

	private static Log _log = LogFactoryUtil.getLog(ProcessStateIXSLFile.class);
	
	// Sheet Name
	final private static String SHEET_NAME = "list";
	
	final private static int COLUMN_START_INDEX = 1;
	
	private String path;
	private Map<Long,Map<String,String>> headerMap;
	
	private XSSFWorkbook workbook ;

	// at below index header starts
	private int rowIndex = 4; 
	private int lastColIndex;
	
	private ProcessStateIXSLFile(String path){
		this.path = path;
	}
	
	public static ProcessStateIXSLFile createXslFile(String path){
		return new ProcessStateIXSLFile(path);
	}
	
	public void configure(){
		workbook = new XSSFWorkbook();
	}
	public void writeHeader(Map<Long,Map<String,String>> headerMap, boolean withParticipants) {
		if(workbook == null){
			configure();
		}
		this.headerMap = headerMap;
		XSSFSheet sheet = getSheet();
		XSSFRow row = sheet.createRow(rowIndex);
		XSSFFont font1 = getHeaderFont(workbook);
		XSSFCellStyle style1 = getHeaderStyle(workbook, font1);
		
		Map<String, String> form;
		int colCount = COLUMN_START_INDEX;
		for (Entry<Long, Map<String, String>> entry : headerMap.entrySet()){
			form = entry.getValue();
			for (Entry<String,String> field : form.entrySet()) {
				XSSFCell cell = row.createCell(colCount++);
				cell.setCellValue(field.getValue());
				cell.setCellStyle(style1);
			}
		}
		if (withParticipants) {
			// add participant details
			for (int i=1; i<=ExportHelper.MAX_PARTICIPANTS_TO_SHOW; i++) {
				for (Entry<String, String> entry : ExportHelper.PARTICIPANTS_FIELD_MAP.entrySet()){
					XSSFCell cell = row.createCell(colCount++);
					cell.setCellValue(String.format("(Participant %d) %s", i, entry.getValue()));
					cell.setCellStyle(style1);				
				}
			}			
		}
		
	}
	

	
	public XSSFRow writeRow(Map<Long,Map<String,String>> rowMap){
		//assuming only one sheet
		XSSFSheet sheet  = getSheet();
		XSSFRow row = sheet.createRow(++rowIndex); // increment the row
		long formId ;
		Map<String, String> form;
		Map<String, String> rowForm;
		int colCount = COLUMN_START_INDEX;
		String cellValue;
		for (Entry<Long, Map<String, String>> entry : headerMap.entrySet()){
			formId = entry.getKey();
			rowForm = rowMap.get(formId);
			form = entry.getValue();
				for (Entry<String,String> field : form.entrySet()) {
					XSSFCell cell = row.createCell(colCount++);
					cellValue = StringPool.BLANK;
					if(rowForm != null){
						cellValue = GetterUtil.getString(rowForm.get(field.getKey()));
					}
					cell.setCellValue(cellValue);
				}
		}
		lastColIndex = colCount;
		return row;
	}
	
	public void saveFile() throws FileNotFoundException, IOException{
		workbook.write(new FileOutputStream(new File(path)));
	}

	private XSSFSheet getSheet(){
		XSSFSheet sheet  = workbook.getSheet(SHEET_NAME);
		if(sheet == null){
			sheet = workbook.createSheet(SHEET_NAME);
		}
		return sheet;
	}

	private XSSFCellStyle getHeaderStyle(XSSFWorkbook wb, XSSFFont font1) {
		XSSFCellStyle style1 = wb.createCellStyle();
		style1.setFillForegroundColor(new XSSFColor(new Color(77, 93, 99)));
		style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		style1.setBorderTop(XSSFCellStyle.BORDER_THIN);
		style1.setBorderRight(XSSFCellStyle.BORDER_THIN);
		style1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		style1.setFont(font1);
		return style1;
	}

	private XSSFFont getHeaderFont(XSSFWorkbook wb) {
		XSSFFont font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 14);
		font1.setFontName("Times New Roman");
		font1.setColor(IndexedColors.WHITE.getIndex());
		return font1;
	}

	public void writeParticipantDetails(XSSFRow row, String participantsJsonArr) {
		int colCount = lastColIndex;
		try {
			JSONArray participantsArr = JSONFactoryUtil.createJSONArray(participantsJsonArr);
			for (int i=0; i<participantsArr.length(); i++) {
				JSONObject participant = participantsArr.getJSONObject(i);
				for (Entry<String, String> entry : ExportHelper.PARTICIPANTS_FIELD_MAP.entrySet()){
					XSSFCell cell = row.createCell(colCount++);
					try {
						cell.setCellValue(participant.getString(entry.getKey()));				
					} catch (Exception e) {
						cell.setCellValue(StringPool.BLANK);
					}
				}
			}			
		} catch (Exception ex) {
			_log.error(ex.getMessage());
		}
		
	}
}
