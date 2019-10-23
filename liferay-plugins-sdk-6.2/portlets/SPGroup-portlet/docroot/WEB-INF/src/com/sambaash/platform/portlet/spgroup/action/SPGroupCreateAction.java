package com.sambaash.platform.portlet.spgroup.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.beanutils.ConvertUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.AssetCategoryException;
import com.liferay.portlet.asset.AssetTagException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.SPGroupStatus;
import com.sambaash.platform.model.SPGroupUserStatus;
import com.sambaash.platform.model.SPGroupUserType;
import com.sambaash.platform.portlet.spgroup.util.ActionUtil;
import com.sambaash.platform.srv.spgroup.NoSuchUserException;
import com.sambaash.platform.srv.spgroup.SPGroupDescriptionException;
import com.sambaash.platform.srv.spgroup.SPGroupImageNameException;
import com.sambaash.platform.srv.spgroup.SPGroupImageSizeException;
import com.sambaash.platform.srv.spgroup.SPGroupImageTypeException;
import com.sambaash.platform.srv.spgroup.SPGroupTitleException;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spgroup.model.SPGroupUser;
import com.sambaash.platform.srv.spgroup.service.SPGroupLocalServiceUtil;
import com.sambaash.platform.srv.spgroup.service.SPGroupUserLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
//import sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil;

/**
 * Portlet implementation class SPGroupCreateAction
 */
public class SPGroupCreateAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = renderRequest.getPreferences();
		try {

			boolean createServiceHasAccess = true;
			String createServiceStrutsAction = StringPool.BLANK;
			SPParameter commentServiceParameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(
					themeDisplay.getScopeGroupId(), SambaashConstants.MEMBERSHIP_SERVICECOMPONENTS.SPGROUP_CREATE);
			createServiceStrutsAction = commentServiceParameter.getValue();
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("struts_action", createServiceStrutsAction);
			parameterMap.put("groupId", new Long(themeDisplay.getScopeGroupId()));
			String imageSize = preferences.getValue("spGroupImageMaxSize", "");
			String imageType = preferences.getValue("spGroupImageExtensions", "");
			renderRequest.setAttribute("imageSize", imageSize);
			renderRequest.setAttribute("imageType", imageType);
			renderRequest.setAttribute("createServiceHasAccess", createServiceHasAccess);
			renderRequest.setAttribute("createServiceMessage", "");

			SPGroup spGroup = null;

			if (createServiceHasAccess) {
				spGroup = ActionUtil.getSPGroup(renderRequest);

				if (spGroup != null) {

					// check privilege

					boolean allowToEdit = false;
					boolean isCommunityAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(),
							themeDisplay.getUserId());

					if (isCommunityAdmin) {
						allowToEdit = true;
					} else {
						SPGroupUser spGroupUser = null;
						try {
							spGroupUser = SPGroupUserLocalServiceUtil.findByUserIdAndGroupIdAndStatus(
									themeDisplay.getUserId(), spGroup.getSpGroupId(),
									SPGroupUserStatus.APPROVE.getValue());

							if (spGroupUser.getRole() == SPGroupUserType.OWNER.getValue()) {
								allowToEdit = true;
							}
						} catch (NoSuchUserException nsue) {
						}
					}

					renderRequest.setAttribute("allowToEdit", allowToEdit);
				}
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = actionRequest.getPreferences();

		String groupDetailPageName = preferences.getValue("groupDetailPageName", "group-detail");

		String action = ParamUtil.getString(actionRequest, "action");

		SPGroup spGroup = null;
		String oldUrlTitle = StringPool.BLANK;

		if ("edit_preferences".equalsIgnoreCase(action)) {
			try {
				String spGroupImageMaxSize = ParamUtil.getString(actionRequest, "spGroupImageMaxSize");
				String spGroupImageExtensions = ParamUtil.getString(actionRequest, "spGroupImageExtensions");
				preferences.setValue("spGroupImageMaxSize", spGroupImageMaxSize);
				preferences.setValue("spGroupImageExtensions", spGroupImageExtensions);

				groupDetailPageName = ParamUtil.getString(actionRequest, "groupDetailPageName");
				preferences.setValue("groupDetailPageName", groupDetailPageName);

				preferences.store();

				actionResponse.setPortletMode(PortletMode.VIEW);

			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

		} else if ("edit_sp_group".equalsIgnoreCase(action)) {

			try {
				String spGroupImageMaxSizeStr = preferences.getValue("spGroupImageMaxSize",
						String.valueOf(DEFAULT_SPGROUP_IMAGE_MAX_SIZE));
				String spGroupImageExtensionsStr = preferences.getValue("spGroupImageExtensions",
						String.valueOf(DEFAULT_SPGROUP_IMAGE_EXTENSIONS));

				long spGroupImageMaxSize = DEFAULT_SPGROUP_IMAGE_MAX_SIZE;
				try {
					spGroupImageMaxSize = Long.valueOf(spGroupImageMaxSizeStr);
				} catch (NumberFormatException nfe) {

					// do nothing

				}

				String[] spGroupImageExtensions = StringUtil.split(spGroupImageExtensionsStr, StringPool.COMMA);

				Object[] returnValue = updateSPGroup(actionRequest, themeDisplay, spGroupImageMaxSize,
						spGroupImageExtensions);

				spGroup = (SPGroup) returnValue[0];
				oldUrlTitle = ((String) returnValue[1]);

				String viewSPGroupURL = StringPool.BLANK;
				try {
					Layout viewSPGroupLayout = LayoutLocalServiceUtil
							.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, "/" + groupDetailPageName);
					long viewSPGroupPlid = viewSPGroupLayout.getPlid();

					PortletURL viewSPGroupPortletURL = PortletURLFactoryUtil.create(actionRequest,
							"SPGroupDetail_WAR_SPGroupportlet", viewSPGroupPlid, PortletRequest.RENDER_PHASE);
					viewSPGroupPortletURL.setWindowState(javax.portlet.WindowState.NORMAL);
					viewSPGroupPortletURL.setPortletMode(javax.portlet.PortletMode.VIEW);
					viewSPGroupPortletURL.setParameter("struts_action", "/groups/view_entry");
					viewSPGroupPortletURL.setParameter("urlTitle", oldUrlTitle);
					viewSPGroupPortletURL.setParameter("spGroupId", String.valueOf(spGroup.getSpGroupId()));
					viewSPGroupPortletURL.setParameter("showSMsg", StringPool.TRUE);
					viewSPGroupURL = viewSPGroupPortletURL.toString();

				} catch (com.liferay.portal.NoSuchLayoutException e) {

					// do nothing

				}

				actionResponse.sendRedirect(viewSPGroupURL);

			} catch (Exception e) {
				if (e instanceof SPGroupTitleException || e instanceof SPGroupDescriptionException
						|| e instanceof SPGroupImageNameException || e instanceof SPGroupImageSizeException
						|| e instanceof SPGroupImageTypeException || e instanceof AssetCategoryException
						|| e instanceof AssetTagException) {

					SessionErrors.add(actionRequest, e.getClass().getName(), e);

				} else {
					_log.error(e.getMessage(), e);
				}
			}

		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		String reindex = ParamUtil.getString(resourceRequest, "reindex");

		if ("all".equalsIgnoreCase(reindex)) {
			Indexer indexer = IndexerRegistryUtil.getIndexer(SPGroup.class);
			try {

				indexer.reindex((String [])ConvertUtils.convert(PortalUtil.getPortal().getCompanyIds(), String[].class));

				PrintWriter out = resourceResponse.getWriter();
				out.println("Reindexing completed");
				out.flush();

			} catch (SearchException e) {
				_log.error(e.getMessage());
			}
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	private Object[] updateSPGroup(ActionRequest actionRequest, ThemeDisplay themeDisplay, long spGroupImageMaxSize,
			String[] spGroupImageExtensions) throws Exception {

		String imageFileName = null;
		InputStream imageInputStream = null;

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		imageFileName = uploadPortletRequest.getFileName("fileName");
		imageInputStream = uploadPortletRequest.getFileAsStream("fileName");

		long spGroupId = ParamUtil.getLong(uploadPortletRequest, "spGroupId");

		String title = ParamUtil.getString(uploadPortletRequest, "title");
		String description = ParamUtil.getString(uploadPortletRequest, "description");
		int type = ParamUtil.getInteger(uploadPortletRequest, "type");

		SPGroup spGroup = null;
		String oldUrlTitle = StringPool.BLANK;
		int status = SPGroupStatus.OPEN.getValue();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(SPGroup.class.getName(), actionRequest);

		// the form is multipart, hence assetcategoryids,links and tags are
		// being set to servicecontext manually. //TODO: have to fix

		setCatIdsLinksTags(serviceContext, uploadPortletRequest);

		if (spGroupId <= 0) {

			// Add entry

			spGroup = SPGroupLocalServiceUtil.addSPGroup(themeDisplay.getUserId(), type, title, description, status,
					imageFileName, imageInputStream, spGroupImageMaxSize, spGroupImageExtensions, serviceContext);

			SPGroupUserLocalServiceUtil.addSPGroupUser(spGroup.getSpGroupId(), themeDisplay.getUserId(),
					SPGroupUserType.OWNER.getValue(), SPGroupUserStatus.APPROVE.getValue(),
					spGroup.getGroupId(), spGroup.getCompanyId());

		} else {

			// Update entry

			spGroup = SPGroupLocalServiceUtil.getSPGroup(spGroupId);

			String tempOldUrlTitle = spGroup.getUrlTitle();

			spGroup = SPGroupLocalServiceUtil.updateSPGroup(themeDisplay.getUserId(), spGroupId, type, title,
					description, status, imageFileName, imageInputStream, spGroupImageMaxSize, spGroupImageExtensions,
					serviceContext);

			if (!tempOldUrlTitle.equals(spGroup.getUrlTitle())) {
				oldUrlTitle = tempOldUrlTitle;
			}

		}

		Indexer indexer = IndexerRegistryUtil.getIndexer(SPGroup.class);
		indexer.reindex(spGroup);

		return new Object[] { spGroup, oldUrlTitle };

	}

	private void setCatIdsLinksTags(ServiceContext serviceContext, UploadPortletRequest uploadPortletRequest) {
		Enumeration<String> params = uploadPortletRequest.getParameterNames();
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		while (params.hasMoreElements()) {
			String name = params.nextElement();
			String value = uploadPortletRequest.getParameter(name);

			if (Validator.isNotNull(name) && name.startsWith("assetCategoryIds")) {
				if (Validator.isNotNull(value)) {
					sb.append(value);
					sb.append(",");
				}
			}

			if (Validator.isNotNull(name) && name.startsWith("assetLinkEntryIds")) {
				if (Validator.isNotNull(value)) {
					sb1.append(value);
					sb1.append(",");
				}
			}
		}

		if (sb.length() > 0) {
			if (sb.charAt(sb.length() - 1) == ',') {
				sb.deleteCharAt(sb.length() - 1);
			}

			String assetCatIds[] = sb.toString().split(",");
			long catIds[] = new long[assetCatIds.length];

			for (int i = 0; i < assetCatIds.length; i++) {
				catIds[i] = GetterUtil.getLong(assetCatIds[i]);
			}

			serviceContext.setAssetCategoryIds(catIds);
		}

		if (sb1.length() > 0) {
			if (sb1.charAt(sb.length() - 1) == ',') {
				sb1.deleteCharAt(sb.length() - 1);
			}

			String assetLinkIds[] = sb.toString().split(",");
			long linkIds[] = new long[assetLinkIds.length];

			for (int i = 0; i < assetLinkIds.length; i++) {
				linkIds[i] = GetterUtil.getLong(assetLinkIds[i]);
			}

			serviceContext.setAssetLinkEntryIds(linkIds);
		}

		String tags = ParamUtil.getString(uploadPortletRequest, "assetTagNames");

		if (Validator.isNotNull(tags)) {
			serviceContext.setAssetTagNames(tags.split(","));
		}
	}

	private static final long DEFAULT_SPGROUP_IMAGE_MAX_SIZE = 307200;

	private static final String DEFAULT_SPGROUP_IMAGE_EXTENSIONS = ".gif,.jpeg,.jpg,.png";

	private static Log _log = LogFactoryUtil.getLog(SPGroupCreateAction.class);

}