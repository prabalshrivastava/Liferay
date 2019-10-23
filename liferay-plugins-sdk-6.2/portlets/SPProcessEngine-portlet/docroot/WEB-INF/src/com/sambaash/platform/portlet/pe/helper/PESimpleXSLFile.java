package com.sambaash.platform.portlet.pe.helper;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
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

public class PESimpleXSLFile {

	// Sheet Name
	final private static String SHEET_NAME = "list";
	
	final private static int COLUMN_START_INDEX = 1;
	
	private String path;
	private Map<String,String> headerMap;
	
	private XSSFWorkbook workbook ;

	// at below index header starts
	private int rowIndex = 4; 
	private PESimpleXSLFile(String path){
		this.path = path;
	}
	
	public static PESimpleXSLFile createXslFile(String path){
		return new PESimpleXSLFile(path);
	}
	
	public void configure(){
		workbook = new XSSFWorkbook();
	}
	public void writeHeader(Map<String,String> headerMap) {
		if(workbook == null){
			configure();
		}
		this.headerMap = headerMap;
		XSSFSheet sheet = getSheet();
		XSSFRow row = sheet.createRow(rowIndex);
		XSSFFont font1 = getHeaderFont(workbook);
		XSSFCellStyle style1 = getHeaderStyle(workbook, font1);
		
		String columnName;
		int colCount = COLUMN_START_INDEX;
		for (Entry<String, String> entry : headerMap.entrySet()){
			columnName = entry.getValue();
			XSSFCell cell = row.createCell(colCount++);
			cell.setCellValue(columnName);
			cell.setCellStyle(style1);
		}
	}
	
	public void writeRow(Map<String,String> rowMap){
		//assuming only one sheet
		XSSFSheet sheet  = getSheet();
		XSSFRow row = sheet.createRow(++rowIndex); // increment the row
		int colCount = COLUMN_START_INDEX;
		for (Entry<String, String> entry : headerMap.entrySet()){
			XSSFCell cell = row.createCell(colCount++);
			cell.setCellValue(rowMap.get(entry.getKey()));
		}
	}
	
	public void writeRows(List<Map<String,String>> rowList){
		for (Map<String, String> map : rowList) {
			writeRow(map);
		}
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
}
