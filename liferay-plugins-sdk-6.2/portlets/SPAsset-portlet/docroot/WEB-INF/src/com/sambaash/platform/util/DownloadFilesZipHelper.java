package com.sambaash.platform.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import com.sambaash.platform.util.FilenameUtils;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;

public class DownloadFilesZipHelper {
	private static final Log log = LogFactoryUtil
			.getLog(DownloadFilesZipHelper.class);

	public static void exportMultipleFilesToZipFile(String[] fileIdsArray,
			OutputStream outputStream) throws PortalException, SystemException,
			IOException {
		List<FileEntry> filesList = getMultipleFiles(fileIdsArray);
		if (!filesList.isEmpty()) {
			exportMultipleFilesToOutputStream(filesList, outputStream);
		}
	}

	public static List<FileEntry> getMultipleFiles(String[] fileIdsArray)
			throws PortalException, SystemException {
		long fileEntryId;
		List<FileEntry> fileEntryList = new ArrayList<FileEntry>();
		for (String fileEntry : fileIdsArray) {
			fileEntryId = Long.parseLong(fileEntry);
			fileEntryList.add(DLAppServiceUtil.getFileEntry(fileEntryId));
		}
		return fileEntryList;
	}
	
	public static void exportMultipleFilesToZipFile(List<String> fileIdsArray,
			OutputStream outputStream) throws PortalException, SystemException,
			IOException {
		List<FileEntry> filesList = getMultipleFiles(fileIdsArray);
		if (!filesList.isEmpty()) {
			exportMultipleFilesToOutputStream(filesList, outputStream);
		}
	}

	public static List<FileEntry> getMultipleFiles(List<String> fileIdsArray)
			throws PortalException, SystemException {
		long fileEntryId;
		List<FileEntry> fileEntryList = new ArrayList<FileEntry>();
		for (String fileEntry : fileIdsArray) {
			fileEntryId = Long.parseLong(fileEntry);
			fileEntryList.add(DLAppServiceUtil.getFileEntry(fileEntryId));
		}
		return fileEntryList;
	}

	public static void exportMultipleFilesToOutputStream(
			List<FileEntry> filesList, OutputStream outputStream)
			throws IOException, PortalException, SystemException {
		ZipOutputStream zipWriter = null;
		try {
			zipWriter = new ZipOutputStream(outputStream);
			exportMultipleFilesToZipWriter(filesList, zipWriter);
		} catch (Exception e) {
			log.debug("Exception", e);
		} finally {
			if (zipWriter != null) {
				zipWriter.close();
			}
		}
	}

	public static void exportMultipleFilesToZipWriter(
			List<FileEntry> filesList, ZipOutputStream zipOutputStream) {
		InputStream fileInputStream = null;
		try {
			for (FileEntry fileEntry : filesList) {
				String zipEntryPath = buildZipEntryPath(fileEntry, "",
						zipOutputStream);
				fileInputStream = fileEntry.getContentStream();
				zipOutputStream.putNextEntry(new ZipEntry(zipEntryPath));
				StreamUtil.transfer(fileInputStream, zipOutputStream, false);
			}
		} catch (Exception e) {
			log.debug(e);
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
					fileInputStream = null;
				}
			} catch (IOException e) {
				log.debug("IOException", e);
			}
		}
	}

	private static String buildZipEntryPath(FileEntry fileEntry,
			String folderPath, ZipOutputStream zipOutputStream)
			throws SystemException, PortalException {
		String fileEntryBaseName = fileEntry.getTitle();
		fileEntryBaseName = FilenameUtils.getBaseName(fileEntryBaseName);
		fileEntryBaseName = fileEntryBaseName.replaceAll("\\W+", "_");
		String zipEntryName = folderPath + fileEntryBaseName
				+ FilenameUtils.EXTENSION_SEPARATOR_STR
				+ fileEntry.getExtension();
		log.info("zipEntryName " + zipEntryName);
		return zipEntryName;
	}
}