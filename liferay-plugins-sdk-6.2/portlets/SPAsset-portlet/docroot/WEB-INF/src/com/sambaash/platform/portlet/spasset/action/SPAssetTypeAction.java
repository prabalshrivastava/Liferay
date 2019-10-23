package com.sambaash.platform.portlet.spasset.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.srv.spasset.model.SPAssetType;
import com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil;
import com.sambaash.platform.util.SPAssetConstants;

/**
 * Portlet implementation class SPAssetType
 */
public class SPAssetTypeAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SPAssetTypeAction.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			List<SPAssetType> assetTypeList = SPAssetTypeLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId());
			_log.info("assetList size==" + themeDisplay.getScopeGroupId() + "===" + assetTypeList.size());
			renderRequest.setAttribute("assetTypeList", assetTypeList);

		} catch (SystemException e) {
			_log.error(e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {

		_log.info(" ------------render----------------");

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		long spAssetTypeId = -1L;
		if (Validator.isNotNull(httpRequest.getParameter("spAssetTypeId"))) {
			spAssetTypeId = GetterUtil.getLong(httpRequest.getParameter("spAssetTypeId"));
		}

		_log.info("spAssetTypeId =" + httpRequest.getParameter("spAssetTypeId"));

		SPAssetType assetType;
		try {
			assetType = SPAssetTypeLocalServiceUtil.fetchSPAssetType(spAssetTypeId);
			request.setAttribute("assetType", assetType);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		super.render(request, response);
	}

	public void addAssetType(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		try {
			String allowedFileTypes = "";
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long spAssetTypeId = ParamUtil.getLong(actionRequest, "spAssetTypeId");
			String spAssetTypeName = ParamUtil.getString(actionRequest, "spAssetTypeName");
			String spAssetTypeCreateUrl = ParamUtil.getString(actionRequest, "spAssetTypeCreateUrl");
			String spAssetTypeDetailUrl = ParamUtil.getString(actionRequest, "spAssetTypeDetailUrl");
			String spAssetTypeInnerDetailUrl = ParamUtil.getString(actionRequest, "spAssetTypeInnerDetailUrl");

			String[] allowedFileTypesList = ParamUtil.getParameterValues(actionRequest, "allowedFileTypes",
					new String[] {});
			for (String type : allowedFileTypesList) {
				allowedFileTypes = allowedFileTypes + "," + type;
			}
			allowedFileTypes = allowedFileTypes.substring(1, allowedFileTypes.length());

			long notificationTemplateId = ParamUtil.getLong(actionRequest, "notificationTemplateId");
			boolean requiredLogin = Boolean.parseBoolean(ParamUtil.getString(actionRequest, "requiredLogin"));
			int minImageHeight = ParamUtil.getInteger(actionRequest, "minImageHeight");
			int minImageWidth = ParamUtil.getInteger(actionRequest, "minImageWidth");
			int maxFileSize = ParamUtil.getInteger(actionRequest, "maxFileSize");

			boolean requiredTermsOfUse = Boolean.parseBoolean(ParamUtil.getString(actionRequest, "requiredTermsOfUse"));

			boolean notifyUponCreation = Boolean.parseBoolean(ParamUtil.getString(actionRequest, "notifyUponCreation"));

			boolean categoryMandatory = Boolean.parseBoolean(ParamUtil.getString(actionRequest, "categoryMandatory"));

			_log.debug("spAssetTypeName==" + spAssetTypeName);
			_log.debug("spAssetTypeCreateUrl==" + spAssetTypeCreateUrl);
			_log.debug("maxFileSize==" + maxFileSize);

			_log.info("allowedFileTypes==" + allowedFileTypes);
			_log.info("notificationTemplateId==" + notificationTemplateId);
			_log.info("notifyUponCreation==" + notifyUponCreation);
			_log.info("requiredLogin==" + requiredLogin);
			_log.info("spAssetTypeId==" + spAssetTypeId);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(SPAssetType.class.getName(),
					actionRequest);

			SPAssetType spAssetType;
			// create spAssetType persistance object
			if (spAssetTypeId > 0) {
				spAssetType = SPAssetTypeLocalServiceUtil.updateSPAssetType(spAssetTypeId, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), spAssetTypeName, true,
						spAssetTypeCreateUrl, spAssetTypeDetailUrl, spAssetTypeInnerDetailUrl, requiredTermsOfUse,
						requiredLogin, categoryMandatory, notifyUponCreation, notificationTemplateId, allowedFileTypes,
						maxFileSize, minImageHeight, minImageWidth, serviceContext);
			} else {
				spAssetType = SPAssetTypeLocalServiceUtil.addSPAssetType(themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), spAssetTypeName, true,
						spAssetTypeCreateUrl, spAssetTypeDetailUrl, spAssetTypeInnerDetailUrl, requiredTermsOfUse,
						requiredLogin, categoryMandatory, notifyUponCreation, notificationTemplateId, allowedFileTypes,
						maxFileSize, minImageHeight, minImageWidth, serviceContext);
			}

			if (spAssetType != null) {

				String[] grpperms = { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT,
						ActionKeys.ADD_SUBFOLDER };
				serviceContext.setGroupPermissions(grpperms);
				serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
				// create folder for uploading the files
				Folder spAssetFolder = null;
				try {
					spAssetFolder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0,
							SPAssetConstants.SPASSET_ROOT_FOLDER_NAME);
				} catch (Exception e) {
					_log.error(e);
				}
				if (Validator.isNull(spAssetFolder)) {
					spAssetFolder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(),
							themeDisplay.getScopeGroupId(), 0, SPAssetConstants.SPASSET_ROOT_FOLDER_NAME, "SPAsset",
							serviceContext);
				}
				if (Validator.isNull(spAssetTypeId))
					DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
							spAssetFolder.getFolderId(), String.valueOf(spAssetType.getSpAssetTypeId()), "SPAssetType",
							serviceContext);
				// adding success message
				SessionMessages.add(actionRequest.getPortletSession(), "spassettype-add-success");
			} else {
				SessionErrors.add(actionRequest.getPortletSession(), "spassettype-add-error");
			}
			/*
			 * actionResponse.setRenderParameter("mvcPath",
			 * "/html/spassettype/view.jsp");
			 */
		} catch (Exception e) {
			SessionErrors.add(actionRequest.getPortletSession(), "spassettype-add-error");
			_log.error(e);
		}
	}
}
