package com.sambaash.platform.rpec.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.liferay.compat.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

public class SPERPECModelHandler {

	private static Log _log = LogFactoryUtil.getLog(SPERPECModelHandler.class);
	private static final String ORDER = "order";
	private static final String COLUMN_LIST = "columnlist";
	private static final String CONTENT_JSON = "contentJson";
	private static final String CONTENT_JSON_PREFIX = "contentJson.";
	private static final String CONTENT_DISPOSITION = "Content-Disposition";
	private static String contentStr = "content";

	public static void exportData(ResourceRequest resourceRequest,String response2, String data, ResourceResponse resourceResponse) {

		
		String fileName = "download.csv";
		org.json.JSONObject responseObject;
		try {
			responseObject = new org.json.JSONObject(response2);
			org.json.JSONArray content = responseObject.getJSONArray(contentStr);
			org.json.JSONObject exportSourceJson = new org.json.JSONObject(data);
			
			JSONObject  contentJsonData = exportSourceJson.getJSONObject("titles");
			
			JSONArray jsonOrderData = exportSourceJson.getJSONArray(ORDER);
			JSONArray contentJsonTitles = new JSONArray();
			JSONArray jsonTitlesOrder = new JSONArray();
			JSONArray jsonColumnList =exportSourceJson.getJSONArray(COLUMN_LIST);
			
			Iterator iter = contentJsonData.keys();
			while(iter.hasNext()){
				 String key = (String)iter.next();
				 if(key.contains("contentJson")){
					 contentJsonTitles.put(key.replaceAll("contentJson.", ""));
				 }
				 
			}

			for (int i = 0; i < jsonOrderData.length(); i++) {
			    if (!jsonOrderData.get(i).equals("contentJson.")) {
			    	jsonTitlesOrder.put(jsonOrderData.get(i));
			    }
			}
			
			for (int i = 0; i < jsonColumnList.length(); i++) {
				 if(!contentJsonTitles.toString().contains(jsonColumnList.getString(i))){
					 contentJsonTitles.put(jsonColumnList.getString(i));
				 }
				 
			}
			
			ArrayList<String> jsonOrder = new ArrayList<>();
			for (int i = 0; i < jsonTitlesOrder.length(); i++) {
				jsonOrder.add(jsonTitlesOrder.getString(i));
			}
			for (int i = 0; i < contentJsonTitles.length(); i++) {
				jsonOrder.add(contentJsonTitles.getString(i));
			}
			
			String[] order = jsonOrder.toArray(new String[0]);
//			XSSFSheet sheet = workbook.createSheet(fileName.replace(".csv", ""));
			// rowNum = writeExcelEntityTitle(sheet, jsonTitles, order);
			
			
			JSONArray orderFromJSONList=new JSONArray();
			
			for (Integer index = 0; index < content.length(); index++) {
				JSONObject orderFromJSON=new JSONObject();
				JSONObject tempObject=content.getJSONObject(index);
				for (int i = 0; i < jsonTitlesOrder.length(); i++) {
					orderFromJSON.put(jsonTitlesOrder.getString(i),
							((tempObject.has(jsonTitlesOrder.getString(i))) ? tempObject.getString(jsonTitlesOrder.getString(i)) : ""));
				}
				JSONObject contentJson=tempObject.getJSONObject("contentJson");
				for (int i = 0; i < contentJsonTitles.length(); i++) {
					
					orderFromJSON.put(contentJsonTitles.getString(i),
							((contentJson.has(contentJsonTitles.getString(i))) ? contentJson.getString(contentJsonTitles.getString(i)) : ""));

				}
				orderFromJSONList.put(orderFromJSON);
			}
			String CSV_SEPARATOR = ",";
			System.out.println(jsonOrder);
			StringBundler sb = new StringBundler();
			for (String columnName : jsonOrder) {
				sb.append(getCSVFormattedValue(contentJsonData.getString(columnName)));
				sb.append(CSV_SEPARATOR);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);
		
	
			for (Integer index = 0; index < orderFromJSONList.length(); index++) {
				JSONObject entityJson = orderFromJSONList.getJSONObject(index);
				for(int j=0;j<jsonOrder.size();j++)
				{
					sb.append(getCSVFormattedValue(String.valueOf(entityJson.getString(jsonOrder.get(j)))));
					sb.append(CSV_SEPARATOR);
				}
			}
			OutputStream outStrm = null;
			try {
				
				byte[] bytes = sb.toString().getBytes();
				String contentType = ContentTypes.APPLICATION_TEXT;
				PortletResponseUtil.sendFile(resourceRequest, resourceResponse, fileName, bytes, contentType);
//				resourceResponse.setContentType("application/text");
//				resourceResponse.addProperty("Cache-Control", "max-age=3600, must-revalidate");
//				resourceResponse.addProperty(CONTENT_DISPOSITION, "attachment; filename=" + fileName);
//				outStrm = resourceResponse.getPortletOutputStream();
//				workbook.write(outStrm);
			} catch (IOException e) {
				_log.error(e);
			} finally {
				try {
					outStrm.flush();
					outStrm.close();
				} catch (IOException e) {
					_log.error(e);
				}
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	protected static String getCSVFormattedValue(String value) {
		StringBundler sb = new StringBundler(3);
		sb.append(CharPool.QUOTE);
		sb.append(StringUtil.replace(value, CharPool.QUOTE, StringPool.DOUBLE_QUOTE));
		sb.append(CharPool.QUOTE);
		return sb.toString();
	}
	public static void exportDataOld(String response2, String data, ResourceResponse resourceResponse) {

		XSSFWorkbook workbook = new XSSFWorkbook();
		String fileName = "downloadw.xlsx";
		org.json.JSONObject responseObject;
		try {
			responseObject = new org.json.JSONObject(response2);

			org.json.JSONArray content = responseObject.getJSONArray(contentStr);

			org.json.JSONObject exportSourceJson = new org.json.JSONObject(data);
			org.json.JSONArray jsonTitlesOrder = (org.json.JSONArray) exportSourceJson.get(ORDER);
			ArrayList<String> jsonOrder = new ArrayList<>();
			for (int i = 0; i < jsonTitlesOrder.length(); i++) {
				jsonOrder.add(jsonTitlesOrder.getString(i));
			}
			String[] order = jsonOrder.toArray(new String[0]);
			XSSFSheet sheet = workbook.createSheet(fileName.replace(".xlsx", ""));
			// rowNum = writeExcelEntityTitle(sheet, jsonTitles, order);
			org.json.JSONObject entityJson = content.getJSONObject(0);
			int rowNum = writeExcelEntityRow(sheet, 0, entityJson, order, 1);
			for (Integer index = 0; index < content.length(); index++) {
				entityJson = content.getJSONObject(index);
				rowNum = writeExcelEntityRow(sheet, rowNum, entityJson, order, 0);
			}
			OutputStream outStrm = null;
			try {

				resourceResponse.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				resourceResponse.addProperty("Cache-Control", "max-age=3600, must-revalidate");
				resourceResponse.addProperty(CONTENT_DISPOSITION, "attachment; filename=" + fileName);
				outStrm = resourceResponse.getPortletOutputStream();
				workbook.write(outStrm);

			} catch (IOException e) {
				_log.error(e);
			} finally {
				try {
					outStrm.flush();
					outStrm.close();
				} catch (IOException e) {
					_log.error(e);
				}
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private static int writeExcelEntityRow(XSSFSheet sheet, int rowNum, org.json.JSONObject entityJson, String[] order,int key) {

		int colNum = 0;
		Row row = sheet.createRow(rowNum++);
		for (String datakey : order) {
			Cell cell = row.createCell(colNum++);
			Object field = null;
			try {
				if (datakey.contains(CONTENT_JSON_PREFIX)) {
					Iterator<?> keys = entityJson.getJSONObject(CONTENT_JSON).keys();
					while (keys.hasNext()) {
						if (key == 1) {
							field = keys.next();
						} else {
							field = entityJson.getJSONObject(CONTENT_JSON).get((String) keys.next());
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

						if (colNum < entityJson.getJSONObject(CONTENT_JSON).length() | rowNum > 2)
							cell = row.createCell(colNum++);

					}

				} else {
					if (key == 1) {
						field = datakey;
					} else {
						if (entityJson.has(datakey))
							field = entityJson.get(datakey);
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
			} catch (org.json.JSONException e) {
				_log.error(e);
			}

		}

		return rowNum;
	}

}
	