
package com.sambaash.platform.video.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.sambaash.platform.model.JobStatus;
import com.sambaash.platform.srv.video.model.VideoFileEntry;
import com.sambaash.platform.srv.video.service.VideoFileEntryLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class VideoConversionNotificationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Log _log = LogFactoryUtil.getLog(VideoConversionNotificationServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		String videoFileEntryId = (String) request.getParameter("vEntryId");

		try {

			if (_log.isErrorEnabled()) {

				_log.error("Zencoder notification received, vEntryId : " + videoFileEntryId);

				// Enumeration headerNames = request.getHeaderNames();
				// while (headerNames.hasMoreElements()) {
				// String headerName = (String) headerNames.nextElement();
				// _log.error("Header Name - " + headerName + ", Value - "
				// + request.getHeader(headerName));
				// }
				//
				// Enumeration params = request.getParameterNames();
				// while (params.hasMoreElements()) {
				// String paramName = (String) params.nextElement();
				// _log.error("Parameter Name - " + paramName + ", Value - "
				// + request.getParameter(paramName));
				// }
			}

			if (Validator.isNumber(videoFileEntryId)) {

				VideoFileEntry videoFileEntry =
					VideoFileEntryLocalServiceUtil.getVideoFileEntry(Long.parseLong(videoFileEntryId));
				FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(videoFileEntry.getFileEntryId());
				VideoFileEntryLocalServiceUtil.updateVideoConversionStatus(
					videoFileEntry, fileEntry, JobStatus.FINISHED.getStatus());
			}

		}
		catch (Exception e) {
			SambaashUtil.notifySystemAdmin(
				"Video converstion status update failed.", "Zenoder notification received, videoFileEntryId : " +
					videoFileEntryId);
			_log.error("Failed to update video conversion status, videoFileEntryId : " + videoFileEntryId);
		}

	}

}
