package com.sambaash.platform.portlet.filesharing.servlet;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.portlet.filesharing.util.FileSharingConstants;
import com.sambaash.platform.portlet.filesharing.util.FileSharingUtils;

public class DownloadServlet extends HttpServlet {

	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		logger.info("ServletName : " + servletConfig.getServletName());
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		logger.info("In DownloadServlet service method ");
		download(request, response);
	}

	protected void download(HttpServletRequest request, HttpServletResponse response) {

		try {
			String param = request.getParameter(FileSharingConstants.FILE_ENTRY_ID);

			if (Validator.isNotNull(param)) {
				long feId = Long.parseLong(param);
				FileSharingUtils.initializePermissionChecker();
				FileEntry fe = DLAppServiceUtil.getFileEntry(feId);
				String contentType = fe.getMimeType();
				response.setContentType(contentType);
				response.setHeader("Content-Length", String.valueOf(fe.getSize()));
				response.setHeader("Content-Disposition", "attachment; filename=\"" + fe.getTitle() + "\"");
				InputStream is = fe.getContentStream();
				OutputStream output = response.getOutputStream();
				IOUtils.copy(is, output);
				output.flush();
				output.close();
				is.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		try {
			String param = request.getParameter("folderIdTest");

			if (Validator.isNotNull(param)) {
				long foldeId = Long.parseLong(param);
				FileSharingUtils.initializePermissionChecker();
				Folder folder = DLAppServiceUtil.getFolder(foldeId);
				String path = folder.getName();
				String zipName = folder.getName() + ".zip";
				String zipParent = System.getProperty("java.io.tmpdir") + File.separator + System.currentTimeMillis()
						+ File.separator;
				String zipPath = zipParent + zipName;
				File zipPf = new File(zipParent);

				if (!zipPf.exists()) {
					zipPf.mkdirs();
				}

				FileOutputStream dest = new FileOutputStream(zipPath);
				CheckedOutputStream checksum = new CheckedOutputStream(dest, new Adler32());
				ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(checksum));
				writeFolder(folder, path, out);
				out.close();

				File zipF = new File(zipPath);
				response.setContentType("application/zip");
				response.setHeader("Content-Length", zipF.length() + "");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + zipName + "\"");
				InputStream is = new FileInputStream(zipF);
				OutputStream output = response.getOutputStream();
				IOUtils.copy(is, output);
				output.flush();
				output.close();
				is.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
	}

	private void writeFolder(Folder folder, String path, ZipOutputStream out)
			throws IOException, PortalException, SystemException {
		try {
			if (Validator.isNotNull(folder)) {
				List<Folder> childFolders = DLAppServiceUtil.getFolders(folder.getGroupId(), folder.getFolderId());
				String childPath;

				for (Folder childFolder : childFolders) {
					childPath = path + File.separator + childFolder.getName();
					writeFolder(childFolder, childPath, out);
				}

				List<FileEntry> fes = DLAppServiceUtil.getFileEntries(folder.getGroupId(), folder.getFolderId());

				for (FileEntry fe : fes) {
					try {
						ZipEntry entry = new ZipEntry(path + File.separator + fe.getTitle());
						out.putNextEntry(entry);
						IOUtils.copy(fe.getContentStream(), out);
					} catch (Exception ex) {
						logger.error(ex.getMessage());
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	private static Log logger = LogFactoryUtil.getLog(DownloadServlet.class);

}