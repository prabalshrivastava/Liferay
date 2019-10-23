package com.sambaash.platform.portlet.profileimage.action;

import com.liferay.portal.UserPortraitSizeException;
import com.liferay.portal.UserPortraitTypeException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import com.sambaash.platform.util.SambaashUtil;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 * Portlet implementation class SPProfileImage
 */
public class SPProfileImageAction extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isSignedIn = themeDisplay.isSignedIn();

		if (isSignedIn) {
			try {
				long remoteUserId = themeDisplay.getUserId();
				String friendlyURL = themeDisplay.getURLCurrent();
				long companyId = themeDisplay.getCompanyId();
				long profileUserId = SambaashUtil.getUserIdByScreenName(companyId, friendlyURL);

				String usersImageMaxWidth = PropsUtil.get(PropsKeys.USERS_IMAGE_MAX_WIDTH);
				String usersImageMaxHeight = PropsUtil.get(PropsKeys.USERS_IMAGE_MAX_HEIGHT);
				String usersImageMaxSizeStr = PropsUtil.get(PropsKeys.USERS_IMAGE_MAX_SIZE);

				if (profileUserId == 0) {
					profileUserId = remoteUserId;
				}

				User profileUser = UserLocalServiceUtil.getUser(profileUserId);
				long portraitId = profileUser.getPortraitId();
				String portraitIdToken = WebServerServletTokenUtil.getToken(portraitId);

				String redirect = StringPool.BLANK;

				if (renderRequest.getAttribute("redirect") != null) {
					redirect = (String) renderRequest.getAttribute("redirect");
				}

				if (Validator.isNull(redirect)) {
					HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
					HttpServletRequest originalServletRequest = PortalUtil
							.getOriginalServletRequest(httpServletRequest);
					redirect = originalServletRequest.getParameter("redirect");
				}

				renderRequest.setAttribute("portraitId", portraitId);
				renderRequest.setAttribute("portraitIdToken", portraitIdToken);

				long usersImageMaxSize = 0;
				try {
					usersImageMaxSize = Long.valueOf(usersImageMaxSizeStr);
				} catch (NumberFormatException nfe) {
					usersImageMaxSize = Integer.MAX_VALUE;
				}

				renderRequest.setAttribute("usersImageMaxWidth", usersImageMaxWidth);
				renderRequest.setAttribute("usersImageMaxHeight", usersImageMaxHeight);
				renderRequest.setAttribute("usersImageMaxSize", usersImageMaxSize);
				renderRequest.setAttribute("redirect", HtmlUtil.escape(redirect));

			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}

		renderRequest.setAttribute("isSignedIn", isSignedIn);
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String action = actionRequest.getParameter("action");
		String redirect = ParamUtil.getString(actionRequest, "redirect");

		_log.error("actionRequest : " + redirect);

		actionResponse.setRenderParameter("redirect", redirect);
		int x = ParamUtil.getInteger(actionRequest, "l");
		int y = ParamUtil.getInteger(actionRequest, "t");
		int width = ParamUtil.getInteger(actionRequest, "w");
		int height = ParamUtil.getInteger(actionRequest, "h");

		// x = 10; y = 10; width = 100; height = 100;

		try {
			if ("editUserPortrait".equalsIgnoreCase(action)) {
				String html5Supported = actionRequest.getParameter("html5Supported");

				if ("true".equalsIgnoreCase(html5Supported)) {
					long tempFileEntryId = ParamUtil.getLong(actionRequest, "tempFileEntryId");
					try {
						DLFileEntry tempFileEntry = DLFileEntryLocalServiceUtil.getFileEntry(tempFileEntryId);
						InputStream is = tempFileEntry.getContentStream();

						// ConvertCmd cmd = new ConvertCmd(); IMOperation
						// imOperation = new IMOperation();
						// imOperation.resize(GetterUtil.getInteger(PropsUtil.get("users.image.max.width")),
						// GetterUtil.getInteger(PropsUtil.get("users.image.max.height")));
						// imOperation.crop(width, height, x, y);
						// cmd.run(imOperation);

						is = resizeImage(is, tempFileEntry.getExtension(),
								GetterUtil.getInteger(PropsUtil.get("users.image.max.width")),
								GetterUtil.getInteger(PropsUtil.get("users.image.max.height")));
						is = cropImage(is, tempFileEntry.getExtension(), x, y, width, height);

						byte[] bytes = IOUtils.toByteArray(is);
						UserLocalServiceUtil.updatePortrait(themeDisplay.getUserId(), bytes);

						DLFileEntryLocalServiceUtil.deleteDLFileEntry(tempFileEntry);

					} catch (NoSuchFileEntryException msfee) {

						// do nothing

					}
				} else {
					try {
						UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

						InputStream inputStream = uploadPortletRequest.getFileAsStream("fileName");

						if (inputStream == null) {
							throw new UploadException();
						}

						byte[] bytes = FileUtil.getBytes(inputStream);

						UserServiceUtil.updatePortrait(themeDisplay.getUserId(), bytes);
					} catch (Exception e) {
						if (e instanceof UploadException || e instanceof UserPortraitSizeException ||
							e instanceof UserPortraitTypeException) {

							SessionErrors.add(actionRequest, e.getClass().getName());
						} else {
							throw e;
						}
					}
				}
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = new ServiceContext();
		String action = resourceRequest.getParameter("action");
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(resourceRequest));

		if ("uploadFile".equalsIgnoreCase(action)) {
			long folderId = 0;
			try {
				List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(httpRequest);
				FileEntry fileEntry = null;

				for (FileItem item : items) {
					String name = item.getName();
					try {
						fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
								themeDisplay.getScopeGroupId(), folderId, name, item.getContentType(), name,
								StringPool.BLANK, StringPool.BLANK, item.getInputStream(), item.getSize(),
								serviceContext);
					} catch (DuplicateFileException dfe) {
						int lastPeriod = name.lastIndexOf(StringPool.PERIOD);
						name = name.subSequence(0, lastPeriod) + StringPool.UNDERLINE + UUID.randomUUID() +
								name.substring(lastPeriod, name.length());

						fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
								themeDisplay.getScopeGroupId(), folderId, name, item.getContentType(), name,
								StringPool.BLANK, StringPool.BLANK, item.getInputStream(), item.getSize(),
								serviceContext);
					}
				}

				JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");

				if (fileEntry != null) {
					dataJSONObject.put("fileEntryId", fileEntry.getFileEntryId());
				} else {
					dataJSONObject.put("fileEntryId", 0);
				}

				resourceResponse.getWriter().write(dataJSONObject.toString());

			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	public InputStream cropImage(InputStream sourceInputStream, String extension, int x, int y, int rectWidth,
			int rectHeight) throws IOException {
		BufferedImage sourceBufferedImage = ImageIO.read(sourceInputStream);
		int type = sourceBufferedImage.getType() == 0 ? BufferedImage.TYPE_INT_RGB : sourceBufferedImage.getType();

		BufferedImage resizedBufferedImage = getCroppeddBufferedImage(sourceBufferedImage, type, x, y, rectWidth,
				rectHeight);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(resizedBufferedImage, extension, os);
		InputStream scaledInputStream = new ByteArrayInputStream(os.toByteArray());
		return scaledInputStream;
	}

	private BufferedImage getCroppeddBufferedImage(BufferedImage sourceBufferedImage, int type, int x, int y,
			int rectWidth, int rectHeight) {

		// Create empty image with new dimensions

		BufferedImage resizedBufferedImage = new BufferedImage(rectWidth, rectHeight, type);
		Graphics2D graphics = (Graphics2D)resizedBufferedImage.getGraphics();

		// Draw to crop image

		graphics.drawImage(sourceBufferedImage, 0, 0, rectWidth, rectHeight, x, y, x + rectWidth, y + rectHeight, null);
		graphics.dispose();
		return resizedBufferedImage;
	}

	private InputStream resizeImage(InputStream sourceInputStream, String extension, int maxWidth, int maxHeight)
			throws IOException {
		BufferedImage sourceBufferedImage = ImageIO.read(sourceInputStream);
		int type = sourceBufferedImage.getType() == 0 ? BufferedImage.TYPE_INT_RGB : sourceBufferedImage.getType();

		float calculatedWidth = 0;
		float calculatedHeight = 0;

		float aspectRatio = (float)sourceBufferedImage.getWidth() / (float) sourceBufferedImage.getHeight();

		if (aspectRatio > 1) {
			calculatedWidth = maxWidth;
			calculatedHeight = maxWidth / aspectRatio;

			if (calculatedHeight > maxHeight) {
				calculatedWidth = maxHeight * aspectRatio;
				calculatedHeight = calculatedWidth / aspectRatio;
			}
		} else {
			calculatedWidth = maxHeight * aspectRatio;
			calculatedHeight = maxHeight;

			if (calculatedWidth > maxWidth) {
				calculatedHeight = maxWidth / aspectRatio;
				calculatedWidth = calculatedHeight * aspectRatio;
			}
		}

		BufferedImage resizedBufferedImage = getResizedBufferedImage(sourceBufferedImage, type, (int)calculatedWidth,
				(int)calculatedHeight);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(resizedBufferedImage, extension, os);
		InputStream scaledInputStream = new ByteArrayInputStream(os.toByteArray());
		return scaledInputStream;
	}

	private BufferedImage getResizedBufferedImage(BufferedImage sourceBufferedImage, int type, int width, int height) {

		// Create empty image with new dimensions

		BufferedImage resizedBufferedImage = new BufferedImage(width, height, type);
		Graphics2D graphics = (Graphics2D)resizedBufferedImage.getGraphics();

		// Draw to scaled image

		graphics.drawImage(sourceBufferedImage, 0, 0, width, height, null);
		graphics.dispose();
		return resizedBufferedImage;
	}

	private static Log _log = LogFactoryUtil.getLog(SPProfileImageAction.class);

}