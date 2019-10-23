package com.sambaash.gu.custom.uploader;

import java.util.Map;

import org.apache.poi.ss.usermodel.Row;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.gu.helper.GUModal.GUField;
import com.sambaash.gu.helper.GUConstants;
import com.sambaash.gu.helper.GUWBHelper;

public class GUWBRowHelper {

	final Map<String, Integer> clmnIndexMap;
	public GUWBRowHelper(Map<String, Integer> clmnIndexMap){
		this.clmnIndexMap = clmnIndexMap;
	}
	
	public String getCellValue(Row row, GUField field){
		String clmnName = field.getClmnName();
		String cellValue = StringPool.BLANK;
		if(Validator.isNotNull(clmnName)){
			cellValue = GUWBHelper.getCellValue(row.getCell(clmnIndexMap.get(field.getClmnName())));
		}
		if(Validator.isNull(cellValue)){
			cellValue = field.getDefaultValue();
		}
		return cellValue;
	}
	
	public String[] getCellValues(Row row, GUField field){
		String value = getCellValue(row, field);
		return value.split(GUConstants.CELL_VALUE_SEPARATOR_ESCAPED);
	}
}
