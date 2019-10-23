package com.sambaash.gu.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.activation.MimetypesFileTypeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.srv.genericuploader.model.GUUploadLog;

public class GUUploadLogHelper {

	private static final Log _log = LogFactoryUtil.getLog(GUUploadLogHelper.class);
	final long groupId ;
	final long companyId ;
	final User logedInUser;
	final GUUploadLog uploadLog;
	
	public GUUploadLogHelper(long companyId, long groupId,User logedInUser, GUUploadLog uploadLog){
		this.companyId = companyId;
		this.groupId = groupId;
		this.logedInUser = logedInUser;
		this.uploadLog = uploadLog;
	}
	
	public FileEntry saveFile(File file, String newName) throws SystemException, PortalException{
		long destFolderId = GUFileHelper.getFolderId(groupId, "SPUploadLog/" + uploadLog.getSPGUUploadLogId(), true);
		ServiceContext fileServiceContext = new ServiceContext();
		GUFileHelper.setDefaultFilePermissions(fileServiceContext);
		InputStream is = null ;
		String mimeType = new MimetypesFileTypeMap().getContentType(file);
		try {
				is = new FileInputStream(file);
				FileEntry fe = DLAppServiceUtil.addFileEntry(groupId, destFolderId, file.getName(), mimeType, file.getName(),file.getName(), "", is,file.length(), fileServiceContext);
				return fe;
		} catch (DuplicateFileException ex) {
			_log.debug("Cannot add file as other file exists with same name. Trying to rename the file and upload");
			String name = DateUtil.newDate().getTime() + "-" + newName;
			FileEntry fe = DLAppServiceUtil.addFileEntry(groupId, destFolderId, name, mimeType, name, "", "", is,file.length(), fileServiceContext);
			return fe;
			//uploadLog.setUploadedFileEntryId(fe.getFileEntryId());
		} catch (FileNotFoundException e) {
			_log.error(e);
		}finally {
			StreamUtil.cleanUp(is);
		}
		return null;
	}
	
	
	public void saveUploadedFile(Workbook wb,String fileName) throws SystemException, PortalException, IOException{
		String name = uploadLog.getSPGUUploadLogId() + "-" + "uploaded-" + fileName;
		File temp = File.createTempFile(name, "");
		FileOutputStream fo = new FileOutputStream(temp);
		wb.write(fo);
		fo.flush();
		FileEntry fe = saveFile(temp, name);
		uploadLog.setUploadedFileEntryId(fe.getFileEntryId());
	}
	public void saveUploadedFile(File uploaded) throws SystemException, PortalException, IOException{
		String name = uploadLog.getSPGUUploadLogId() + "uploaded-" + uploaded.getName();
		FileEntry fe = saveFile(uploaded, name);
		uploadLog.setUploadedFileEntryId(fe.getFileEntryId());
	}
	public void saveErrorFile(Workbook wb,Map<String,Set<Integer>> successRows,String fileName) throws SystemException, PortalException, IOException{
		
		for (Entry<String,Set<Integer>> entry : successRows.entrySet()) {
			Sheet sheet = wb.getSheet(entry.getKey());
			removeRows(sheet, entry.getValue());
		}
		String name = uploadLog.getSPGUUploadLogId() + "-" +  "errorRecords-" + fileName;

		File temp = new File(name);
		FileOutputStream fo = new FileOutputStream(temp);
		wb.write(fo);
		fo.flush();
		
		name = temp.getName().replaceAll("\\.tmp", "");
		FileEntry fe = saveFile(temp, name);
		uploadLog.setErrorFileEntryId(fe.getFileEntryId());
		
	}
	
	private void removeRows(Sheet sheet, Set<Integer> rowNums){
		try {
			if(rowNums == null || sheet == null){
				return;
			}
			SortedSet<Integer> sorted = new TreeSet<>(Collections.reverseOrder());
	        sorted.addAll(rowNums);
			for (Integer num : rowNums) {
				_log.debug("Removing row: "+num);
				_log.debug("sheet.getLastRowNum(): "+sheet.getLastRowNum());
				_log.debug("shifting start row: "+(num + 1));
				_log.debug("shifting end row: "+(sheet.getLastRowNum() + 1));
				sheet.shiftRows(num + 1, sheet.getLastRowNum() + 1 , -1);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
}
