package com.sambaash.platform.invigilatormanagement.action.ajax;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;

public class ExportReportActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(ExportReportActionHandler.class.getName());
	private static final String CONTENT_JSON = "contentJson";
	private static final String CONTENT_JSON_PREFIX = "contentJson.";
	private static final String ELASTIC_SEARCH = "/elasticsearch?";
	private static final String CONTENT_DISPOSITION = "Content-Disposition";  
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		
		String modelData = SystemLocalServiceUtil.getElasticSearchListing(request, response);
		try {
			JSONObject responseJSON = JSONFactoryUtil.createJSONObject(modelData);
			JSONArray content = responseJSON.getJSONArray("content");
			
	        String[] order =  new String[]{"GroupName","No.","AppointType","Lead","FullName","UserId","Deadline","AppointmentStatus"};
	        
			XSSFWorkbook workbook = new XSSFWorkbook();
			String fileName = "download.xlsx";
			XSSFSheet sheet = workbook.createSheet(fileName.replace(".xlsx", ""));
	        //rowNum = writeExcelEntityTitle(sheet, jsonTitles, order);
			JSONObject entityJson = JSONFactoryUtil.createJSONObject();
			JSONObject preventityJson = content.getJSONObject(0).getJSONObject("contentJson");
	        int rowNum = writeExcelEntityRow(sheet, 0, entityJson, order,1);
	        int count = 0;
	        for (Integer index = 0; index < content.length(); index++) {
	        	preventityJson = entityJson;
	        	entityJson = content.getJSONObject(index).getJSONObject("contentJson");
	        	if(entityJson.getString("GroupName").equalsIgnoreCase(preventityJson.getString("GroupName"))){
	        		count++;
	        		entityJson.put("GroupName", "");
	        		
	        	}else{
	        		count = 1;
	        	}
	        	entityJson.put("No.", count);
	            rowNum = writeExcelEntityRow(sheet, rowNum, entityJson, order,0);
	        }
	        autoSizeColumns(workbook);
	        OutputStream outStrm = null;
	        try {
	            
	        	response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        	response.addProperty("Cache-Control", "max-age=100, must-revalidate");
	        	response.addProperty("Content-Disposition","attachment; filename="+fileName);
	            outStrm = response.getPortletOutputStream();
	            workbook.write(outStrm);
	            
	        } catch (IOException e) {
	        	log.error(e);
	        } 
	        finally{
	            try {
	                outStrm.flush();
	                outStrm.close();
	            } catch (IOException e) {                
	            	log.error(e);
	            }
	        }
			
		} catch (JSONException e) {
			log.error(e);
		}
		
	}
	public void autoSizeColumns(XSSFWorkbook workbook) {
	    int numberOfSheets = workbook.getNumberOfSheets();
	    for (int i = 0; i < numberOfSheets; i++) {
	    	XSSFSheet sheet = workbook.getSheetAt(i);
	        if (sheet.getPhysicalNumberOfRows() > 0) {
	            Row row = sheet.getRow(sheet.getFirstRowNum());
	            Iterator<Cell> cellIterator = row.cellIterator();
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                int columnIndex = cell.getColumnIndex();
	                sheet.autoSizeColumn(columnIndex);
	            }
	        }
	    }
	}
	private int writeExcelEntityRow(XSSFSheet sheet, int rowNum, JSONObject entityJson, String[] order, int key) {
 
		int colNum = 0;
		Row row = sheet.createRow(rowNum++);
		for (String datakey : order) {
			Cell cell = row.createCell(colNum++);
			Object field = null;
			if(key==1){
				 field =  datakey; 
			}
			else{
			  field = entityJson.getString(datakey);
			}
			
			if (field instanceof String) {
				cell.setCellValue((String) field);

			} else if (field instanceof Integer) {
				cell.setCellValue(String.valueOf(field));
			} else if (field != null) {
				cell.setCellValue(field.toString());
			} else {
				cell.setCellValue("");
			}

		}

		return rowNum;
	}

}
