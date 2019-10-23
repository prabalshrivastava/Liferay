package com.sambaash.platform.util;

import java.io.InputStream;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;

public class SPDLUtil {

	private static Log _log = LogFactoryUtil.getLog(SPDLUtil.class);

	public static FileEntry addFileEntryAndResourcePermission(
			long repositoryId, long folderId, String selectedFileName,
			String mimeType, String title, String description,
			String changeLog, InputStream inputStream, long size,
			ServiceContext serviceContext, String TEMP_RANDOM_SUFFIX,
			ThemeDisplay themeDisplay) throws DuplicateFileException {

		FileEntry fileEntry = null;

		String extension = FileUtil.getExtension(selectedFileName);

		int pos = selectedFileName.lastIndexOf(TEMP_RANDOM_SUFFIX);

		if (pos != -1) {
			selectedFileName = selectedFileName.substring(0, pos);

			if (Validator.isNotNull(extension)) {
				selectedFileName = selectedFileName + StringPool.PERIOD
						+ extension;
			}
		}

		while (true) {
			try {
				DLAppLocalServiceUtil.getFileEntry(
						themeDisplay.getScopeGroupId(), folderId,
						selectedFileName);

				StringBundler sb = new StringBundler(5);

				sb.append(FileUtil.stripExtension(selectedFileName));
				sb.append(StringPool.DASH);
				sb.append(StringUtil.randomString());

				if (Validator.isNotNull(extension)) {
					sb.append(StringPool.PERIOD);
					sb.append(extension);
				}

				selectedFileName = sb.toString();
			} catch (Exception e) {
				break;
			}
		}

		try {
			fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folderId,
					selectedFileName, mimeType, selectedFileName, description,
					changeLog, inputStream, size, serviceContext);

			PermissionUtil.addDefaultRoleResourcePermission(
					themeDisplay.getCompanyId(), DLFileEntry.class.getName(),
					fileEntry.getFileEntryId(), new String[] { ActionKeys.VIEW,
							ActionKeys.UPDATE });
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return fileEntry;

	}

}
