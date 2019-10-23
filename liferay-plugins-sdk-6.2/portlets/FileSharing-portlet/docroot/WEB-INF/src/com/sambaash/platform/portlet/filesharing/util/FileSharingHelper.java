package com.sambaash.platform.portlet.filesharing.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.srv.sharing.model.SPSharing;
import com.sambaash.platform.srv.sharing.service.SPSharingLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
public class FileSharingHelper {

	public static SPSharing getShareIfValidRequest(PortletRequest request,
			ThemeDisplay themeDisplay) throws Exception {
		try {
			String encString = parseTokenId(request);

			SPSharing share = SPSharingLocalServiceUtil.getSPSharing(GetterUtil
					.getLong(SambaashUtil.decrypt(encString)));

			if (themeDisplay.getUserId() != share.getUserId()) {
//				request.setAttribute(FSConstants.ERROR,
//						"Unauthorized to view the share!");
				return null;
			}

			Date currentDate = Calendar.getInstance().getTime();

			if (currentDate.compareTo(share.getStartDate()) < 0 ||
				currentDate.compareTo(share.getEndDate()) > 0 ||
				share.getExpired()) {
				request.setAttribute(FileSharingConstants.ERROR,
						"The shared link is expired!");
				return share;
			}

			return share;
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean isFile(SPSharing share) {
		return share.getClassName().equals(DLFileEntry.class.getName());
	}

	public static boolean isImageFile(String name) {
		return Pattern.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|jpeg))$)", name);
	}

	public static String parseTokenId(PortletRequest request) {
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));
		String encString = httpReq.getParameter(FileSharingConstants.TOKEN);

		if (encString == null) {
			encString = ParamUtil.getString(httpReq,
					"_" + ParamUtil.get(httpReq, "p_p_id", "") + "_" +
							FileSharingConstants.TOKEN);
		}

		return encString;
	}

	public SearchContainer getFilesSharedByUser(long userId,
			PortletRequest portletRequest) {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL portletURL = PortletURLFactoryUtil.create(portletRequest,
				FileSharingConstants.PORTLET_ID, themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);

		List<String> headerNames = new ArrayList<String>();
		headerNames.add("File/Folder Name");
		headerNames.add("User Name");
		headerNames.add("Email Id");
		headerNames.add("Start Date");
		headerNames.add("End Date");
		headerNames.add("Action");

		SearchContainer searchContainer = new SearchContainer(portletRequest,
				null, null, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_DELTA, portletURL, headerNames,
				"There are no files/folder shared by you");

		portletURL.setParameter(searchContainer.getCurParam(),
				String.valueOf(searchContainer.getCurValue()));
		portletURL.setParameter("tab", "sharedByMe");

		try {
			List<SPSharing> results = SPSharingLocalServiceUtil.getUserSharedFiles(
					userId, new Date());
			int totalRowCount = results.size();

			if (totalRowCount >= searchContainer.getDelta()) {
				results = SPSharingLocalServiceUtil.getUserSharedFiles(userId,
					new Date(), searchContainer.getStart(),
					searchContainer.getEnd());
			}

			searchContainer.setResults(results);

			List resultRows = searchContainer.getResultRows();
			int rowCount = 0;

			for (SPSharing sharing : results) {
				try {
					ResultRow row = new ResultRow(sharing,
							sharing.getCreatedBy(), rowCount++);
					User user = UserLocalServiceUtil.getUser(sharing
							.getUserId());
					String name = "";
					String fileType = "";

					if (isFile(sharing)) {
						FileEntry fileEntry = DLAppServiceUtil
								.getFileEntry(sharing.getClassPK());
						name = fileEntry.getTitle();
						fileType = fileEntry.getIcon();
					} else {
						Folder folder = DLAppServiceUtil.getFolder(sharing
								.getClassPK());
						name = folder.getName();
						fileType = "folder";
					}

					row.addText("<img alt='Image' src='" +
							themeDisplay.getPathThemeImages() +
							"/file_system/small/" + fileType + ".png'> " +
							name);
					row.addText(user.getFullName());
					row.addText(sharing.getEmailAddress());
					row.addText(new SimpleDateFormat("dd-MMM-yyyy")
							.format(sharing.getStartDate()));
					row.addText(new SimpleDateFormat("dd-MMM-yyyy")
							.format(sharing.getEndDate()));
					LiferayPortletURL actionUrl = PortletURLFactoryUtil
							.create(portletRequest, FileSharingConstants.PORTLET_ID,
									themeDisplay.getPlid(),
									PortletRequest.ACTION_PHASE);
					actionUrl.setWindowState(WindowState.MAXIMIZED);
					actionUrl.setParameter("javax.portlet.action",
							"revokeAccess");
					actionUrl.setParameter("sharingId", sharing.getSpSharingId() +
							"");
					actionUrl.setParameter("tab", "sharedByMe");
					actionUrl.setParameter(searchContainer.getCurParam(),
							String.valueOf(searchContainer.getCurValue()));
					actionUrl.setParameter(searchContainer.getDeltaParam(),
							String.valueOf(searchContainer.getDelta()));
					actionUrl.setParameter(FileSharingConstants.TOKEN,
							parseTokenId(portletRequest));
					row.addButton("Revoke Access",
							"javascript:document.location.href='" + actionUrl +
									"'");
					resultRows.add(row);
				} catch (Exception e) {
					_log.error("error while fetching file/folder entry", e);
					totalRowCount--;
				}
			}

			searchContainer.setTotal(totalRowCount);
		} catch (Exception e) {
			_log.error("error while calling service", e);
		}

		return searchContainer;
	}

	private static Log _log = LogFactoryUtil.getLog(FileSharingHelper.class);

}
