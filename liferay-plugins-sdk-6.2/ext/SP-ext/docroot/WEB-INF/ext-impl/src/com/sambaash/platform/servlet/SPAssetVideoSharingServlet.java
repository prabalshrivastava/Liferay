package com.sambaash.platform.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sambaash.platform.util.SambaashUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.PortalSessionThreadLocal;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;

public class SPAssetVideoSharingServlet extends HttpServlet {
	private static final long serialVersionUID = -6074880615562532948L;

	private static Log logger = LogFactoryUtil.getLog(SPAssetVideoSharingServlet.class);

	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		logger.info("ServletName : " + servletConfig.getServletName());
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		logger.info("In SPAssetVideoSharingServlet service method ");
		String videoPreview = "&videoPreview=1&type=mp4";
		User user = null;
		try {

			user = _getUser(request);

			PrincipalThreadLocal.setName(user.getUserId());
			PrincipalThreadLocal.setPassword(PortalUtil.getUserPassword(request));

			PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(user, true);

			PermissionThreadLocal.setPermissionChecker(permissionChecker);

			String path = HttpUtil.fixPath(request.getPathInfo());
			String[] pathArray = StringUtil.split(path, CharPool.SLASH);

			if (pathArray.length >= 3) {
				long fileEntryId = Long.parseLong(pathArray[1]);
				FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
				String url = SambaashUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), videoPreview, true);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);

				requestDispatcher.forward(request, response);
				return;
			}

		} catch (Exception e) {
		}

	}

	private static User _getUser(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();

		if (PortalSessionThreadLocal.getHttpSession() == null) {
			PortalSessionThreadLocal.setHttpSession(session);
		}

		User user = PortalUtil.getUser(request);

		if (user != null) {
			return user;
		}

		String userIdString = (String) session.getAttribute("j_username");
		String password = (String) session.getAttribute("j_password");

		if ((userIdString != null) && (password != null)) {
			long userId = GetterUtil.getLong(userIdString);

			user = UserLocalServiceUtil.getUser(userId);
		} else {
			long companyId = PortalUtil.getCompanyId(request);

			Company company = CompanyLocalServiceUtil.getCompany(companyId);

			user = company.getDefaultUser();
		}

		return user;
	}

}