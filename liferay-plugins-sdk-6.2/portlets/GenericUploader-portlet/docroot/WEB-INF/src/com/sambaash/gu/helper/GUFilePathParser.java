package com.sambaash.gu.helper;

import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.gu.msg.GUMsgFactory;

public class GUFilePathParser {
	
	private static final Log _log = LogFactoryUtil.getLog(GUFilePathParser.class); 

	public static JSONObject validatePathPlaceholders(String modalName,String path,String sheetName,Row row, String clmnName){
		if(Validator.isNull(path)){
			return null;
		}

		String names[] = path.split("/");
		for(String pathToken: names){
			JSONObject error = validateName(modalName, pathToken, sheetName, row, clmnName);
			if(error != null){
				return error;
			}
		}
		
		return null;
	}

	/**
	 *  Validates the given path for placeholders.
	 *  
	 *  Examples: 
	 *   /startup/ORG_[spOrganizationId]/Cover   - is Valid,  spOrganizationId is property exists in Organizaion modal and braces properly ended
	 *   /startup/ORG_[spOrganizationId/Cover - Not valid closing brace missing
	 *      
	 * @param modalName
	 * @param pathToken
	 * @param sheetName
	 * @param row
	 * @param clmnName
	 * @return
	 */
	public static JSONObject validateName(String modalName,String pathToken,String sheetName,Row row, String clmnName){
		if(Validator.isNull(pathToken)){
			return null;
		}

		JSONObject error = null;
		String origPathToken = pathToken;
		while(true){
			
			int openIndex = pathToken.indexOf("[");
			if(openIndex == -1){
				break;
			}
			// to save from out of boundry issue
			if(openIndex >= origPathToken.length() -1 ){
				error = GUMsgFactory.createMsg("Syntax error.Braces are not properly closed", sheetName, row.getRowNum(), clmnName);
				return error;
			}
			
			// look for matching close bracket
			String afterOpen = pathToken.substring(openIndex + 1);
			int end = afterOpen.indexOf("]");
			if( end == -1 ){
				error = GUMsgFactory.createMsg("Syntax error.Braces are not properly closed", sheetName, row.getRowNum(), clmnName);
				return error;
			}
			
			// Look for property.. if it does not exists in the modal throw error
			String fieldName = afterOpen.substring(0, end);
			try {
				 Method set =  GUEntityHelper.getEntitySetMethod(modalName, fieldName);
				 if(set == null){
					 error = GUMsgFactory.createMsg("Invalid placeholder. Can not find the the property in the modal = " + fieldName, sheetName, row.getRowNum(), clmnName);
				 }
			} catch (Exception e) {
				_log.error(e);
			}
			
			pathToken = afterOpen.substring(end);
		}
		
		return null;
	}
	
	/**
	 * Recursively replaces tokens with values in given object.
	 * Those tokens called properties of object must exist 
	 * 
	 * @param modalName
	 * @param obj
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static String replacePlaceHolders(String modalName,Object obj, String path) throws Exception{

		int openIndex = path.indexOf("[");
		if(openIndex == -1){
			return path;
		}
		// look for matching close bracket
		int closeIndex = path.indexOf("]");
		
		// Look for property.. if it does not exists in the modal throw error
		String fieldName = path.substring(openIndex + 1, closeIndex);
		try {
				Object fieldValue = GUEntityHelper.getValue(modalName, obj, fieldName);
				String toReplace = path.substring(openIndex, closeIndex + 1); 
				path = path.replace(toReplace, fieldValue.toString());
				path = replacePlaceHolders(modalName, obj, path);
				
		} catch (Exception e) {
			_log.error(e);
			throw new Exception();
		}
		return path;
	}
}
