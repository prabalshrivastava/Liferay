package com.sambaash.platform.pe.convert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;

public class PEDS {

	// this method can return json formatted data in case form data source
	public String getValue(String fieldId){
		return StringPool.BLANK;
	}
	// this method should return only value
	public String getSimpleValue(String fieldId){
		return StringPool.BLANK;
	}
	// this method useful to return display text, in case selection type fields
	public String getDisplayText(String fieldId){
		return StringPool.BLANK;
	}
	
	public File getFile(String id){
		return null;
	}
	public String getFileName(String fieldId){
		long feId = GetterUtil.getLong(getValue(fieldId));
		
		try {
			FileEntry fe = DLAppServiceUtil.getFileEntry(feId);
			return fe.getTitle();
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}
		return StringPool.BLANK;
	}

	public FileEntry getFileEntryByFieldId(String fieldId){
		long feId = GetterUtil.getLong(getValue(fieldId));
		if(feId == 0){
			return null;
		}
		try {
			FileEntry fe = DLAppServiceUtil.getFileEntry(feId);
			return fe;
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}
		return null;
	}
	
	public static File storeFileLocally(FileEntry fileEntry){
		File tempFolder = FileUtil.createTempFolder();
		String path = tempFolder.getAbsolutePath() + File.separator + fileEntry.getTitle();
		File tempFile = new File(path);
		try {
			FileOutputStream output = new FileOutputStream(tempFile);
			IOUtils.copy(fileEntry.getContentStream(), output);
		} catch (IOException | PortalException | SystemException e) {
			_log.error(e);
		}
		return tempFile;
	}
	
	/**
	 * Dropdown can be multiselect. So it has to return array of values.
	 * @param fieldId
	 * @return
	 */
	public String[] getDropdownValues(String fieldId){
		return new String[]{};
	}
	
	/**
	 * This method used to return checkbox's selected in checkbox group. 
	 * 
	 * @param fieldId
	 * @return
	 */
	public String[] getCheckboxValues(String fieldId){
		return new String[]{};
	}
	
	private static Log _log = LogFactoryUtil
			.getLog(PEDS.class.getName());
}
