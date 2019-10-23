package com.sambaash.gu.helper;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

public class GUWBHelper {

	public static SimpleDateFormat dateFormatter = new SimpleDateFormat(GUConstants.DATE_FORMAT);
	public static HSSFWorkbook readFileXls(InputStream inputStream)
			throws IOException {
		return new HSSFWorkbook(inputStream);
	}

	public static XSSFWorkbook readFileXlsx(InputStream inputStream)
			throws IOException {
		return new XSSFWorkbook(inputStream);
	}
	
	public static String getCellValue(Cell cell) throws UnsupportedOperationException{
		if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){
			return StringPool.BLANK;
		}
		if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
            return cell.getStringCellValue().trim();
        } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
        	return getNumericCell(cell);
        } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
        	return "" + cell.getBooleanCellValue();
        } else  if(cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
        	return getFormulaCell(cell);
        }
        else {
          throw new UnsupportedOperationException("Unsupported cell value");
        }
	}
	
	public static String getNumericCell(Cell cell){
    	if (HSSFDateUtil.isCellDateFormatted(cell)) {
			Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
			return dateFormatter.format(date);
    	}else{
    		cell.setCellType(Cell.CELL_TYPE_STRING);
			return cell.getRichStringCellValue().getString();
    	}
	}
	
	public static String getFormulaCell(Cell cell){
		switch(cell.getCachedFormulaResultType()) {
			case Cell.CELL_TYPE_NUMERIC: return getNumericCell(cell);
            
			case Cell.CELL_TYPE_STRING:  return cell.getRichStringCellValue().getString() ;
            
		}
		return StringPool.BLANK;
	}

	public static Map<String, Integer> getClmnIndexMap(Row headerRow) {
		Map<String,Integer>clmnIndexMap = new LinkedHashMap<String, Integer>();
		for(int cc = 0 ; cc < headerRow.getLastCellNum(); cc++){
		   Cell cell = headerRow.getCell(cc);
		   String clmnName = GUWBHelper.getCellValue(cell);
		   if(Validator.isNotNull(clmnName)){
			   clmnIndexMap.put(clmnName, cc);
		   }
		}
		return clmnIndexMap;
	}
	
	
	public static boolean isRowEmpty(Row row) {
	    if (row == null) {
	        return true;
	    }
	    if (row.getLastCellNum() <= 0) {
	        return true;
	    }
	    for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
	        Cell cell = row.getCell(cellNum);
	        if (cell != null && cell.getCellType() != HSSFCell.CELL_TYPE_BLANK && Validator.isNotNull(getCellValue(cell))) {
	            return false;
	        }
	    }
	    return true;
	}

}
