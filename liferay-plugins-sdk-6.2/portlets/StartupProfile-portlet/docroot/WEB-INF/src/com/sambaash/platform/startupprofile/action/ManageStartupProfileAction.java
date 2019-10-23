package com.sambaash.platform.startupprofile.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.facebook.FacebookConnectUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserConstants;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.ProfileType;
import com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsLocalServiceUtil;
import com.sambaash.platform.srv.sprating.model.AttrRate;
import com.sambaash.platform.srv.sprating.model.RatingAttr;
import com.sambaash.platform.srv.sprating.model.RatingComponent;
import com.sambaash.platform.srv.sprating.service.AttrRateLocalServiceUtil;
import com.sambaash.platform.srv.sprating.service.RatingAttrLocalServiceUtil;
import com.sambaash.platform.srv.sprating.service.RatingComponentLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.ATODocument;
import com.sambaash.platform.srv.startupprofile.model.Address;
import com.sambaash.platform.srv.startupprofile.model.Guidelines;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.model.Person;
import com.sambaash.platform.srv.startupprofile.model.Principles;
import com.sambaash.platform.srv.startupprofile.model.Relationship;
import com.sambaash.platform.srv.startupprofile.service.ATODocumentLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.AccreditationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.AddressLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.ApprovedMentorsLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.FundingRoundLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.GuidelinesLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.PersonLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.PrinciplesLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.RelationshipLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.impl.PrinciplesLocalServiceImpl;
import com.sambaash.platform.startupprofile.RatingConstants;
import com.sambaash.platform.startupprofile.StartupConstants;
import com.sambaash.platform.startupprofile.StartupSignupUtil;
import com.sambaash.platform.startupprofile.helper.RatingHelper;
import com.sambaash.platform.startupprofile.helper.SPStartupDLHelper;
import com.sambaash.platform.startupprofile.helper.StartupFormHelper;
import com.sambaash.platform.startupprofile.helper.StartupPermissionHelper;
import com.sambaash.platform.startupprofile.helper.StartupProfileHelper;
import com.sambaash.platform.startupprofile.notification.StartupProfileNotificationConstants;
import com.sambaash.platform.tag.handlers.CommentTagProcess;
import com.sambaash.platform.util.PermissionUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class ManageStartupProfileAction
 */
public class ManageStartupProfileAction extends MVCPortlet {

	private static Log logger = LogFactoryUtil.getLog(ManageStartupProfileAction.class);
	private final static String PAGE = "/html/managestartupprofile/addOrEditProfile.jsp";
	private final static String DISPLAY_PAGE = "/html/displaystartupprofile/displayProfile.jsp";
	private final static String ERROR_PAGE = "/html/common/error.jsp";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String orgId = renderRequest.getParameter(StartupConstants.ORGANIZATION_ID);
		String action = renderRequest.getParameter("actionp");
		String initialTab = renderRequest.getParameter("initialTab");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean authorized = false;
		boolean isPostLogin = StartupConstants.PARAM_POST_LOGIN_PROFILE.equalsIgnoreCase(action);
		boolean isDisplayAction = StartupConstants.PARAM_DISPLAY_PROFILE.equalsIgnoreCase(action) || isPostLogin;

		List<Principles> principles = PrinciplesLocalServiceUtil.findBySiteId(0);
		renderRequest.setAttribute(StartupConstants.ATTRIB_PRINCIPLES, principles);
		// View request
		if (isDisplayAction) {
			if (StartupPermissionHelper.canViewStartup(renderRequest, GetterUtil.getLong(orgId))) {
				authorized = true;
			}
			CommentTagProcess.addCommentPermissionToReq(renderRequest, StartupConstants.PORTLET_ID);
		} else if (Validator.isNull(orgId)) {
			// Add request
			// if (StartupPermissionHelper.canCreateStartup(renderRequest)) {
			authorized = true;
			// }
			// don't show comments on create
			renderRequest.setAttribute(CommentTagProcess.ACTION_VIEW_COMMENTS_PERMISSION, false);
		} else {
			// Edit request
			if (StartupPermissionHelper.canUpdateStartup(renderRequest, GetterUtil.getLong(orgId))) {
				authorized = true;
			}
			;
			CommentTagProcess.addCommentPermissionToReq(renderRequest, StartupConstants.PORTLET_ID);
		}

		if (authorized) {
			// will handle edits also
			prepareAddStartup(orgId, renderRequest);
			if (isDisplayAction) {
				prepareDisplayStartup(orgId, renderRequest);
				renderRequest.setAttribute(StartupConstants.EDIT_FRIENDLY_URL,
						StartupProfileHelper.editStartupFriendlyURL(themeDisplay, GetterUtil.getLong(orgId)));
				try {
					// TODO fix this
					// boolean ratingPermisson =
					// RatingHelper.checkRatingPermission(renderRequest);
					renderRequest.setAttribute("ratingPermisson", true);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
				renderRequest.setAttribute("isPostLogin", isPostLogin);
				renderRequest.setAttribute("initialTab", initialTab);
				include(DISPLAY_PAGE, renderRequest, renderResponse);
				return;
			}
			super.doView(renderRequest, renderResponse);
		} else {
			logger.warn("Unauthorized accesss action = " + action + " userId=" + themeDisplay.getUserId() + "orgId = "
					+ orgId);
			include(ERROR_PAGE, renderRequest, renderResponse);
			return;
		}
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// startup preferences
		StartupFormHelper.preparePreferencesData(renderRequest, renderResponse);

		// startup rating preferences
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String ratingComponentId = preferences.getValue(RatingConstants.COMPONENT_ID, "");
			renderRequest.setAttribute(RatingConstants.COMPONENT_ID, ratingComponentId);

			List<RatingComponent> comps = RatingComponentLocalServiceUtil.getAllRatingComponents();
			renderRequest.setAttribute("ratingComponents", comps);
		} catch (Exception e) {
			logger.error("Error while getting component information", e);
		}
		super.doEdit(renderRequest, renderResponse);
	}

	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// startup preferences
		StartupFormHelper.savePreferences(actionRequest, actionResponse);
		// startup rating preferences
		try {
			String compId = ParamUtil.getString(actionRequest, "prefComponentId");
			if (Validator.isNull(compId)) {
				logger.warn("No rating component selected");
			} else {
				PortletPreferences preferences = actionRequest.getPreferences();
				preferences.setValue(RatingConstants.COMPONENT_ID, compId);
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				SambaashUtil.saveSPParameter(themeDisplay.getScopeGroupId(), SambaashConstants.STARTUP_RATING_ID,
						compId);
				preferences.store();
			}
		} catch (Exception e) {
			logger.error("Error while saving component preferences", e);
		}
	}

	public void prepareAddStartup(String orgId, PortletRequest request) {
		StartupFormHelper.fillCategories(request, orgId);
		StartupProfileHelper.readOrgData(orgId, request);
	}

	private void prepareDisplayStartup(String orgId, RenderRequest renderRequest) {
		try {
			HttpServletRequest req = PortalUtil.getHttpServletRequest(renderRequest);
			HttpServletRequest Httprequest = PortalUtil.getOriginalServletRequest(req);
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			Organization org = OrganizationLocalServiceUtil.getOrganization(Long.valueOf(orgId));
			renderRequest.setAttribute(StartupConstants.NAME, org.getName());
			renderRequest.setAttribute("foundedOn", org.getFoundedOn());
			renderRequest.setAttribute("", org.getName());
			Address address = OrganizationLocalServiceUtil.getOfficeHeadQuaterAddress(org.getOrganizationId());
			String addressStr = getAddressString(address);
			if (address != null) {
				renderRequest.setAttribute("streetName", address.getStreet2());
				renderRequest.setAttribute("unitNo", address.getStreet3());
				renderRequest.setAttribute("blockNo", address.getStreet1());
				renderRequest.setAttribute("buildingName", address.getStreet4());
				renderRequest.setAttribute("postalCode", address.getPostalCode());
				renderRequest.setAttribute("country", address.getCountry());
			}
			if (Validator.isNotNull(addressStr))
				renderRequest.setAttribute(StartupConstants.HQ_ADDRESS, addressStr);
			if (Validator.isNotNull(org.getMobile()))
				renderRequest.setAttribute("phone", org.getMobile());
			if (Validator.isNotNull(org.getEmailId()))
				renderRequest.setAttribute("email", org.getEmailId());
			addUrlLink(renderRequest, "cbUrl", org.getCrunchbase());
			addUrlLink(renderRequest, "linkedInUrl", org.getLinkedIn());
			addUrlLink(renderRequest, "twitterUrl", org.getTwitter());
			addUrlLink(renderRequest, "website", org.getWebsite());

			PortalUtil.setPageSubtitle(HtmlUtil.stripHtml(org.getName()), Httprequest);
			PortalUtil.setPageDescription(HtmlUtil.stripHtml(org.getDescription()), Httprequest);
			List<String> files = SPStartupDLHelper.getShowcaseFiles(renderRequest, "" + org.getOrganizationId(), false);
			renderRequest.setAttribute("snappyDescription", org.getShortPitch());
			renderRequest.setAttribute("fullDescription", org.getDescription());
			renderRequest.setAttribute("showcaseFiles", files);

			renderRequest.setAttribute("ogtitle", HtmlUtil.stripHtml(org.getName()));
			renderRequest.setAttribute("ogdescription", HtmlUtil.stripHtml(org.getDescription()));
			try {
				renderRequest.setAttribute("ogurl",
						URLEncoder.encode(themeDisplay.getPortalURL() + themeDisplay.getURLCurrent(), "UTF-8"));
				renderRequest.setAttribute("fbappid", FacebookConnectUtil.getAppId(themeDisplay.getCompanyId()));
			} catch (UnsupportedEncodingException | SystemException e) {
				logger.error(e.getMessage());
			}

		} catch (Exception e) {
			logger.error("Error filling org info for display startup", e);
		}
	}

	private void addUrlLink(RenderRequest renderRequest, String key, String value) {
		if (Validator.isNull(value))
			return;
		if (value.trim().startsWith("www.")) {
			value = "http://" + value;
		}
		renderRequest.setAttribute(key, value);
	}

	private String getAddressString(Address address) {
		try {
			String addressStr = address.getName();
			addressStr += (Validator.isNotNull(address.getStreet1()) ? ", " + address.getStreet1() : "");
			addressStr += (Validator.isNotNull(address.getStreet2()) ? ", " + address.getStreet2() : "");
			addressStr += (Validator.isNotNull(address.getCity()) ? ", " + address.getCity() : "");
			// TODO get country
			addressStr += (Validator.isNotNull(address.getPostalCode()) ? ", " + address.getPostalCode() : "");
			return addressStr;
		} catch (Exception e) {
			logger.error("Error creating address string", e);
		}
		return null;
	}

	/*
	 * Used when drag and drop for uploading is not enabled
	 */
	public void addStartup(ActionRequest request, ActionResponse response) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			if (logger.isDebugEnabled())
				logger.debug("Uploading logo for Organization via form submit " + themeDisplay.getUserId());

			Object objs[] = null;
			FileEntry fe = null;
			// TODO :: handle this properly
			try {
				objs = SPStartupDLHelper.parseFileUploadRequest(request, response);
				Map<String, String> paramMap = (Map<String, String>) objs[0];
				String orgId = paramMap.get(response.getNamespace() + StartupConstants.ORGANIZATION_ID);
				prepareAddStartup(orgId, request);

				List<FileItem> files = (List<FileItem>) objs[1];
				if (Validator.isNotNull(files) && !files.isEmpty()) {
					for (FileItem fileItem : files) {
						if (SPStartupDLHelper.isLogoTypAllowed(fileItem.getContentType())) {
							fe = SPStartupDLHelper.uploadToTemp(request, orgId, fileItem,
									StartupConstants.FOLDERTYPE_LOGO);
							if (Validator.isNotNull(fe)) {
								String logoUrl = SambaashUtil.getDLFileUrl(request, fe.getFileEntryId());
								// Logo url should set after showAddStartup to
								// override the url attribute in request
								request.setAttribute(StartupConstants.LOGO_URL, logoUrl);
								if (logger.isInfoEnabled())
									logger.info("logo uploaded for by user = " + themeDisplay.getUserId()
											+ " logoUrl = " + logoUrl);
							} else {
								request.setAttribute("logoError", StartupConstants.MSG_UPLOAD_ERROR);
							}
						} else {
							request.setAttribute("logoError", StartupConstants.MSG_UPLOAD_ERROR);
						}
					}
				}
				request.setAttribute("lowerVBrowser", "true");

			} catch (FileUploadException e) {
				logger.error("Error while parsing file upload request" + e.getMessage(), e);
			}
		} catch (Exception e) {
			logger.error("Error while fetching users", e);
		}

		response.setWindowState(WindowState.MAXIMIZED);
		response.setRenderParameter("jspPage", PAGE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		Object multiPartData[] = new Object[2];
		PortletPreferences preferences = resourceRequest.getPreferences();
		HttpServletRequestWrapper httpRequest = null;
		if (ServletFileUpload.isMultipartContent(PortalUtil.getHttpServletRequest(resourceRequest))) {
			try {
				multiPartData = SPStartupDLHelper.parseFileUploadRequest(resourceRequest, resourceResponse);

				httpRequest = StartupProfileHelper.getHttpRequestWrapperMultiPart(resourceRequest,
						((Map<String, String>) multiPartData[0]));
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		} else {
			httpRequest = StartupProfileHelper.getHttpRequestWrapper(resourceRequest);
		}

		boolean isCommentRequest = checkIfCommentRequest(resourceRequest);
		if (isCommentRequest) {
			// pass process to common comment handler
			String source = ParamUtil.getString(resourceRequest, "source");
			if (CommentTagProcess.SOURCE_COMMENTS_TAG.equalsIgnoreCase(source)) {
				CommentTagProcess ctp = new CommentTagProcess();
				ctp.serveResource(resourceRequest, resourceResponse);
			}
			return;
		} else {
			try {
				AuthTokenUtil.checkCSRFToken(httpRequest, ManageStartupProfileAction.class.getName());
			} catch (PortalException e1) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put(StartupConstants.ERROR_MSG, StartupConstants.UNAUTH_MSG_VIEW);
				logger.error(e1.getMessage());
				resourceResponse.getWriter().write(obj.toString());
				return;
			}
		}

		String action = ParamUtil.getString(resourceRequest, StartupConstants.ACTION);
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (action.equals("uploadDoc")) {
			Map<String, String> data2 = (Map<String, String>) multiPartData[0];
			String documentName = "";
			if (data2 != null) {
				documentName = data2.get("documentName");
			}
			// Object[] multiPartData = Util.parseFileUploadRequest(request);
			JSONObject retObj = JSONFactoryUtil.createJSONObject();
			JSONArray objArr = JSONFactoryUtil.createJSONArray();

			long organizationId = ParamUtil.getLong(resourceRequest, "orgId");
			FileEntry fe = null;
			try {
				if (ArrayUtil.isNotEmpty(multiPartData)) {
					@SuppressWarnings("unchecked")
					List<FileItem> files = (List<FileItem>) multiPartData[1];
					if (Validator.isNotNull(files) && files.size() > 0) {
						for (FileItem f : files) {
							JSONObject obj = JSONFactoryUtil.createJSONObject();
							try {
								fe = Util.uploadFile(resourceRequest, f, false);
							} catch (PortalException | SystemException e) {
								logger.error("Error uploading", e);
							}
							if (Validator.isNotNull(fe)) {
								String fileUrl = SambaashUtil.getDLFileUrl(resourceRequest, fe.getFileEntryId());
								obj.put("name", f.getName());
								obj.put("size", f.getSize());
								obj.put("url", fileUrl);
								obj.put("fileEntryId", fe.getFileEntryId());
							} else {
								obj.put("error", "Error uploading the file.");
							}
							objArr.put(obj);
						}
						// List<ATODocument> atoDocuments =
						// ATODocumentLocalServiceUtil.findByOrganizationId(organizationId);
						ATODocument atoDocument = ATODocumentLocalServiceUtil
								.createATODocument(CounterLocalServiceUtil.increment("ATODocument"));
						atoDocument.setOrganizationId(organizationId);
						atoDocument.setDocumentType(documentName);
						atoDocument.setDocumentFileId(String.valueOf(fe.getFileEntryId()));

						ATODocumentLocalServiceUtil.updateATODocument(atoDocument);
						retObj.put("result", objArr);
						retObj.put("data", objArr.getJSONObject(0));
						resourceResponse.getWriter().write(retObj.toString());
						return;
					}
				}
			} catch (SystemException e) {
				logger.error(e.getMessage());
			}

		}
		if (action.equals("checkEmailExists")) {
			String emailAddress = ParamUtil.getString(resourceRequest, "email");
			String orgIdStr = ParamUtil.getString(resourceRequest, StartupConstants.ORGANIZATION_ID);
			String resp = OrganizationLocalServiceUtil.isUserLinkedToOrganization(emailAddress, Long.valueOf(orgIdStr));
			JSONObject retObj = JSONFactoryUtil.createJSONObject();
			retObj.put("result", resp);
			resourceResponse.getWriter().write(retObj.toString());
			return;
		} else if (action.equals(StartupConstants.ACTION_DELETE)) {
			String name = ParamUtil.getString(resourceRequest, StartupConstants.NAME);
			long dbId = ParamUtil.getLong(resourceRequest, StartupConstants.DB_ID);
			if (logger.isDebugEnabled())
				logger.debug("Delete request for " + name + " dbId = " + dbId + " userId=" + themeDisplay.getUserId());
			if (name.equalsIgnoreCase("addressId")) {
				try {
					AddressLocalServiceUtil.deleteAddress(dbId);
					resourceResponse.getWriter().write(StartupConstants.SUCCESS);
				} catch (Exception e) {
					logger.error("Error deleting organization" + dbId, e);
					resourceResponse.getWriter().write(StartupConstants.FAIL);
				}
			}
			if (name.equalsIgnoreCase("personId")) {
				try {
					PersonLocalServiceUtil.deletePerson(dbId);
					resourceResponse.getWriter().write(StartupConstants.SUCCESS);
				} catch (Exception e) {
					logger.error("Error deleting person" + dbId, e);
					resourceResponse.getWriter().write(StartupConstants.FAIL);
				}
			}
			// --Abhinay- to remove team member and corresponding relationships
			if (name.equalsIgnoreCase("memberId")) {
				try {
					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
							.forClass(Person.class, this.getClass().getClassLoader())
							.add(PropertyFactoryUtil.forName("memberUserId").eq(dbId));

					List<Person> person = PersonLocalServiceUtil.dynamicQuery(dynamicQuery);
					long personId = 0;
					if (person.size() != 0) {
						personId = person.get(0).getPersonId();
						PersonLocalServiceUtil.deletePerson(personId);
					}

					dynamicQuery = DynamicQueryFactoryUtil
							.forClass(Relationship.class, this.getClass().getClassLoader())
							.add(PropertyFactoryUtil.forName("refId").eq(personId));
					List<Relationship> rel = RelationshipLocalServiceUtil.dynamicQuery(dynamicQuery);
					if (rel.size() != 0)
						RelationshipLocalServiceUtil.deleteRelationship(rel.get(0).getRelationshipId());
					resourceResponse.getWriter().write(StartupConstants.SUCCESS);
				} catch (Exception e) {
					logger.error("Error deleting person" + dbId, e);
					resourceResponse.getWriter().write(StartupConstants.FAIL);
				}
			}
			if (name.equalsIgnoreCase("organizationId")) {
				try {
					OrganizationLocalServiceUtil.deleteOrganization(dbId);
					resourceResponse.getWriter().write(StartupConstants.SUCCESS);
				} catch (Exception e) {
					logger.error("Error deleting organization" + dbId, e);
					resourceResponse.getWriter().write(StartupConstants.FAIL);
				}
			}
			if (name.equalsIgnoreCase("fundingRoundId")) {
				try {
					FundingRoundLocalServiceUtil.deleteFundingRound(dbId);
					resourceResponse.getWriter().write(StartupConstants.SUCCESS);
				} catch (Exception e) {
					logger.error("Error deleting fundingRound " + dbId, e);
					resourceResponse.getWriter().write(StartupConstants.FAIL);
				}
			}

		} else if (action.equals(StartupConstants.ACTION_SIGNUP)) {
			try {
				signupStartup(resourceRequest, resourceResponse, themeDisplay);
			} catch (UserPasswordException e) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("passErrMsg", String.valueOf(e.getType()));
				resourceResponse.getWriter().write(obj.toString());
			} catch (UserEmailAddressException e) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("emailErrMsg", e.getMessage());
				resourceResponse.getWriter().write(obj.toString());
			} catch (Exception e) {
				logger.error("Failed to signup startup profile.", e);
				resourceResponse.getWriter().write(StartupConstants.FAIL);
			}
		} else if (action.equals(StartupConstants.ACTION_IMPORT)) {
			// save startup info
			String orgIdStr = ParamUtil.getString(resourceRequest, StartupConstants.ORGANIZATION_ID);
			JSONObject obj = JSONFactoryUtil.createJSONObject();

			if (Validator.isNotNull(orgIdStr) && orgIdStr.equals("-1")) {
				orgIdStr = null;
			}

			// Permission Checks
			boolean authorized = false;
			if (Validator.isNull(orgIdStr)) {
				if (themeDisplay.isSignedIn() && StartupPermissionHelper.canCreateStartup(themeDisplay.getUserId())) {
					authorized = true;
				}
			} else {
				if (StartupPermissionHelper.canUpdateStartup(resourceRequest, GetterUtil.getLong(orgIdStr))) {
					authorized = true;
				}
			}

			if (authorized) {
				// if (logger.isDebugEnabled())
				logger.error("Authorized user" + themeDisplay.getUserId() + ", Saving orgId = " + orgIdStr);
				StartupProfileHelper helper = new StartupProfileHelper();
				try {
					long orgId = helper.persistStartupData(resourceRequest, orgIdStr);
					obj.put(StartupConstants.ORGANIZATION_ID, orgId);
					ServiceContext serviceContext = ServiceContextFactory.getInstance(Organization.class.getName(),
							resourceRequest);
					// SocialProfileLocalServiceUtil.updateProfileType(themeDisplay.getUser(),
					// ProfileType.STARTUP,serviceContext);
					try {

						boolean isDocumentsMandatory = Boolean
								.valueOf(preferences.getValue("isDocumentsMandatory", StringPool.TRUE));
						String documentsToDelete = ParamUtil.getString(resourceRequest, "documentsToDelete");
						JSONArray documentsToDeleteArr = JSONFactoryUtil.createJSONArray(documentsToDelete);
						for (int i = 0; i < documentsToDeleteArr.length(); i++) {
							long atoDocumentId = documentsToDeleteArr.getLong(i);

							ATODocument atoDocument = ATODocumentLocalServiceUtil.getATODocument(atoDocumentId);
							List<ATODocument> atoDocuments = ATODocumentLocalServiceUtil
									.findByOrganizationAndDocumentType(atoDocument.getOrganizationId(),
											atoDocument.getDocumentType());
							if ((atoDocuments.size() > 1) || !isDocumentsMandatory) {
								long documentId = Long.valueOf(atoDocument.getDocumentFileId());
								ATODocumentLocalServiceUtil.deleteATODocument(atoDocument);
								DLAppServiceUtil.deleteFileEntry(documentId);
							}
						}
					} catch (PortalException | SystemException e) {
						logger.error(e.getMessage());
					}

					obj.put("dashBoardUrl",
							SambaashUtil.getDashboardUrl(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()));
					logger.error("successfully saved organization data = " + orgIdStr);
				} catch (Exception e) {
					logger.error("Exception while saving profile type for user" + themeDisplay.getUser().getFullName(),
							e);
					resourceResponse.getWriter().write(StartupConstants.FAIL);
					return;
				}

			} else {
				logger.warn("Unauthorized save operation on startup userId=" + themeDisplay.getUserId() + " orgId="
						+ orgIdStr);
				if (themeDisplay.isSignedIn()) {
					obj.put(StartupConstants.ERROR_MSG, StartupConstants.UNAUTH_MSG_VIEW);
				}
			}
			resourceResponse.getWriter().write(obj.toString());
		} else if (action.equals(StartupConstants.ACTION_ORG_NAME_CHECK)) {
			// save startup info
			String orgIdStr = ParamUtil.getString(resourceRequest, StartupConstants.ORGANIZATION_ID);
			String name = ParamUtil.getString(resourceRequest, StartupConstants.NAME);
			boolean nameExists = false;
			if (Validator.isNotNull(name)) {
				if (logger.isDebugEnabled())
					logger.debug("checking organization name orgId" + orgIdStr + " name=" + name);
				if (Validator.isNull(orgIdStr)) {
					nameExists = OrganizationLocalServiceUtil.isOrganizationExistsWithName(name);
				} else {
					try {
						Organization org = OrganizationLocalServiceUtil.getOrganization(GetterUtil.getLong(orgIdStr));
						if (!name.equalsIgnoreCase(org.getName())) {
							nameExists = OrganizationLocalServiceUtil.isOrganizationExistsWithName(name);
						}
					} catch (Exception e) {
					}
				}
			}
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			if (nameExists) {
				if (logger.isInfoEnabled())
					logger.info("Organization with the same name exists");
				obj.put("errorMsg", "Startup Profile exists with the given name '" + name + "'");
			} else {
				obj.put("successMsg", "Startup Profile doesnot exists with the given name '" + name + "'");
			}
			resourceResponse.getWriter().write(obj.toString());
		} else if (action.equals(StartupConstants.ACTION_ORG_EMAIL_CHECK)) {
			String email = ParamUtil.getString(resourceRequest, "emailAddress");
			boolean mailExists = false;
			if (Validator.isNotNull(email)) {
				try {
					User u = UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(), email);
					mailExists = (u != null);
				} catch (Exception e) {
					logger.debug(e); // just debug and return false
				}
			}
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			if (mailExists) {
				if (logger.isInfoEnabled())
					logger.info("Email address is already in use.");
				obj.put("errorMsg", "Startup Profile exists with the given email address '" + email + "'");
			}
			resourceResponse.getWriter().write(obj.toString());
		} else if (action.equals(StartupConstants.ACTION_ORG_UEN_CHECK)) {
			// save startup info
			String orgIdStr = ParamUtil.getString(resourceRequest, StartupConstants.ORGANIZATION_ID);
			String uen = ParamUtil.getString(resourceRequest, StartupConstants.UEN);
			boolean uenExists = false;
			if (Validator.isNotNull(uen)) {
				if (logger.isDebugEnabled())
					logger.debug("checking organization UEN orgId" + orgIdStr + " UEN=" + uen);
				if (Validator.isNull(orgIdStr)) {
					uenExists = OrganizationLocalServiceUtil.isOrganizationExistsWithUEN(uen);
				} else {
					try {
						Organization org = OrganizationLocalServiceUtil.getOrganization(GetterUtil.getLong(orgIdStr));
						if (!uen.equalsIgnoreCase(org.getUen())) {
							uenExists = OrganizationLocalServiceUtil.isOrganizationExistsWithUEN(uen);
						}
					} catch (Exception e) {
					}
				}
			}
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			if (uenExists) {
				if (logger.isInfoEnabled())
					logger.info("Organization with the same UEN exists");
				obj.put("errorMsg", "Startup Profile exists with the given UEN '" + uen + "'");
			} else {
				obj.put("successMsg", "Startup Profile doesnot exists with the given UEN '" + uen + "'");
			}
			resourceResponse.getWriter().write(obj.toString());
		} else if (action.equals(StartupConstants.ACTION_PASSWORD_CHECK)) {
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			boolean isValid = true;
			try {
				String pw1 = ParamUtil.getString(resourceRequest, "pw1");
				String pw2 = ParamUtil.getString(resourceRequest, "pw2");
				StartupSignupUtil.validatePassword(themeDisplay, pw1, pw2);
			} catch (Exception e) {
				isValid = false;
				String errCode = String.valueOf(UserPasswordException.PASSWORD_INVALID);
				if (e instanceof UserPasswordException) {
					errCode = String.valueOf(((UserPasswordException) e).getType());
				}
				obj.put("passErrMsg", errCode);
				if (logger.isInfoEnabled()) {
					logger.info("Password is invalid -> " + errCode, e);
				}
			}
			obj.put("isValidPassword", isValid);
			resourceResponse.getWriter().write(obj.toString());
		} else if (action.equals(StartupConstants.ACTION_PROFILE_COMPLETE)) {
			String orgIdStr = ParamUtil.getString(resourceRequest, StartupConstants.ORGANIZATION_ID);
			JSONObject responseData = JSONFactoryUtil.createJSONObject();
			String displayPathUrl = StartupProfileHelper
					.displayStartupDetailsFriendlyURL(themeDisplay.getScopeGroupId());
			displayPathUrl = displayPathUrl + orgIdStr;
			if (logger.isDebugEnabled())
				logger.debug("Setting Organization status to completed " + orgIdStr);
			try {
				Organization org = OrganizationLocalServiceUtil.getOrganization(Long.valueOf(orgIdStr));
				boolean complete = org.getCompleteness();
				if (!complete) {
					org.setCompleteness(true);
					// String videoLinkArrJsonStr =
					// ParamUtil.getString(resourceRequest,"orgVideoLinkList");
					// org.setVideoLinks(videoLinkArrJsonStr);
					OrganizationLocalServiceUtil.updateOrganization(org);
					OrganizationLocalServiceUtil.clearCache(org);
					try {
						JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
						payloadJSON.put(Field.USER_ID, themeDisplay.getUserId());
						payloadJSON.put(StartupProfileNotificationConstants.USER_NAME,
								themeDisplay.getUser().getFullName());
						payloadJSON.put(StartupProfileNotificationConstants.TITLE, org.getName());
						payloadJSON.put(StartupProfileNotificationConstants.STARTUP_LINK, StartupProfileHelper
								.displayStartupDetailsFriendlyURL(themeDisplay, Long.valueOf(orgIdStr)));
						ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);

						Date now = new Date();
						UserNotificationEventLocalServiceUtil.addUserNotificationEvent(SambaashUtil.getAdminUserId(),
								StartupConstants.PORTLET_ID, now.getTime(), themeDisplay.getUserId(),
								payloadJSON.toString(), false, serviceContext);

						long[] userIds = StartupProfileHelper.getFoundryAdminIds(themeDisplay);
						for (int i = 0; i < userIds.length; i++) {
							UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userIds[i],
									StartupConstants.PORTLET_ID, now.getTime(), themeDisplay.getUserId(),
									payloadJSON.toString(), false, serviceContext);
						}
					} catch (Exception e) {
						logger.error("Error while sending notification event " + e.getMessage());
					}
					// } else {
					// String videoLinkArrJsonStr =
					// ParamUtil.getString(resourceRequest,"orgVideoLinkList");
					// org.setVideoLinks(videoLinkArrJsonStr);
					// OrganizationLocalServiceUtil.updateOrganization(org);
					// OrganizationLocalServiceUtil.clearCache(org);
				}
				responseData.put(StartupConstants.SUCCESS, StartupConstants.SUCCESS);
				responseData.put("displayPathUrl", displayPathUrl);
				resourceResponse.getWriter().write(responseData.toString());
				if (logger.isInfoEnabled())
					logger.info("Organization status complete " + orgIdStr);
			} catch (Exception e) {
				logger.error("Error while changing profile status to completed", e);
				resourceResponse.getWriter().write(StartupConstants.FAIL);
			}
		} else if (action.equals("deleteFileEntry")) {
			Long fileEntryId = ParamUtil.getLong(resourceRequest, StartupConstants.FILE_ENTRY_ID);
			Long orgId = ParamUtil.getLong(resourceRequest, StartupConstants.ORGANIZATION_ID);
			try {
				DLAppServiceUtil.deleteFileEntry(fileEntryId);
				Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
				if (org.getLogoId() == fileEntryId) {
					org.setLogoId(0);
				}
			} catch (Exception e) {
				resourceResponse.getWriter().write(StartupConstants.FAIL);
			}
		} else if (action.equals("getShowcaseFileDetails")) {
			try {
				String orgIdStr = ParamUtil.getString(resourceRequest, StartupConstants.ORGANIZATION_ID);
				if (Validator.isNull(orgIdStr))
					return;
				List<String> fileMap = SPStartupDLHelper.getShowcaseFiles(resourceRequest, orgIdStr, true);
				if (Validator.isNotNull(fileMap)) {
					resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(fileMap));
				}
			} catch (Exception e) {
				resourceResponse.getWriter().write(StartupConstants.FAIL);
			}
		} else if ("getRatingsForObj".equals(action)) {
			JSONObject data = JSONFactoryUtil.createJSONObject();
			try {
				String objId = ParamUtil.getString(resourceRequest, RatingConstants.OBJID);
				if (Validator.isNotNull(objId)) {
					resourceResponse.setContentType("application/json");
					resourceResponse.setCharacterEncoding("utf-8");
					long componentId = getRatingComponentId(resourceRequest);
					List<RatingAttr> attrs = RatingAttrLocalServiceUtil.findRatingAttrsByComponentId(componentId);
					JSONArray array = JSONFactoryUtil.createJSONArray();
					JSONObject item;
					for (RatingAttr attr : attrs) {
						item = JSONFactoryUtil.createJSONObject();
						item.put(RatingConstants.RATING_ATTR_NAME, attr.getName());
						item.put(RatingConstants.RATING_ATTR_ID, attr.getSpRatingAttrId());
						item.put(RatingConstants.OBJID, objId);
						item.put(RatingConstants.COMPONENT_ID, componentId);
						boolean found = false;

						try {
							AttrRate attrRate = AttrRateLocalServiceUtil.findByUserIdRatingAttrIdObjId(
									themeDisplay.getUserId(), attr.getSpRatingAttrId(), objId);
							item.put("attrRateId", attrRate.getSpAttrRateId());
							item.put(RatingConstants.VALUE, attrRate.getValue());
							found = true;

						} catch (Exception ex) {
						}
						if (!found) {
							item.put(RatingConstants.VALUE, 0);
						}
						array.put(item);
					}
					data.put(RatingConstants.ITEMS, array);
					data.put("status", RatingConstants.SUCCESS);
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage());
				data.put("status", RatingConstants.ERROR);
			} finally {
				resourceResponse.getWriter().write(data.toString());
			}
		} else if ("saveAttrRate".equals(action)) {
			resourceResponse.setContentType("application/json");
			resourceResponse.setCharacterEncoding("utf-8");
			JSONObject data = JSONFactoryUtil.createJSONObject();
			try {
				String objId = ParamUtil.getString(resourceRequest, RatingConstants.OBJID);
				long ratingAttrId = ParamUtil.getLong(resourceRequest, RatingConstants.RATING_ATTR_ID);
				double rateValue = ParamUtil.getLong(resourceRequest, RatingConstants.VALUE);
				long componentId = getRatingComponentId(resourceRequest);
				RatingComponent rcomp = RatingComponentLocalServiceUtil.getRatingComponent(componentId);
				AttrRate attrRate = AttrRateLocalServiceUtil.findByUserIdRatingAttrIdObjId(themeDisplay.getUserId(),
						ratingAttrId, objId);

				if (Validator.isNull(attrRate)) {
					AttrRateLocalServiceUtil.addAttrRate(objId, ratingAttrId, rcomp.getClassNameId(), rateValue,
							themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getUser());
				} else {
					attrRate.setValue(rateValue);
					attrRate.setModifiedDate(new Date());
					AttrRateLocalServiceUtil.updateAttrRate(attrRate);
				}

				// objId
				try {
					Organization org = OrganizationLocalServiceUtil.getOrganization(Long.valueOf(objId));
					OrganizationLocalServiceUtil.reIndex(org);
				} catch (Exception e) {
					logger.error("Error indexing organization, rating update wont index!!", e);
				}

				RatingHelper ratingHelper = new RatingHelper();
				data.put("avgRatings", ratingHelper.getAllAvgRatingsJson(componentId, objId));
				data.put("status", RatingConstants.SUCCESS);
			} catch (Exception ex) {
				logger.error("Error while saving AttrRate ", ex);
				data.put("status", RatingConstants.ERROR);
			} finally {
				resourceResponse.getWriter().write(data.toString());
			}
		} else if ("getAllAvgRatings".equals(action)) {
			try {
				String objId = ParamUtil.getString(resourceRequest, RatingConstants.OBJID);
				long componentId = getRatingComponentId(resourceRequest);
				JSONObject data = JSONFactoryUtil.createJSONObject();
				RatingHelper helper = new RatingHelper();
				data = helper.getAllAvgRatingsJson(componentId, objId);
				data.put("status", RatingConstants.SUCCESS);
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			} catch (Exception ex) {
				logger.error(ex.getMessage());
			}
			// --Abhinay : searches user and returns
		} else if ("getUserList".equals(action)) {
			try {
				JSONArray jsonResults = JSONFactoryUtil.createJSONArray();
				JSONObject data = null;
				String key = ParamUtil.getString(resourceRequest, "keys").toLowerCase();

				DynamicQuery getUserByKeysDynamicQuery = DynamicQueryFactoryUtil.forClass(User.class,
						PortletClassLoaderUtil.getClassLoader());
				Criterion criterion = null;
				criterion = RestrictionsFactoryUtil.like("firstName",
						new StringBuilder().append(key).append("%").toString());
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.like("emailAddress",
						new StringBuilder().append(key).append("%").toString()));

				getUserByKeysDynamicQuery.add(criterion);
				List<User> userList = UserLocalServiceUtil.dynamicQuery(getUserByKeysDynamicQuery);

				for (User user : userList) {
					data = JSONFactoryUtil.createJSONObject();
					data.put("name", user.getFirstName() + " " + user.getLastName());
					data.put("imgUrl",
							UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, user.getPortraitId()));
					data.put("userId", user.getUserId());
					jsonResults.put(data);
				}

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(jsonResults.toString());
			} catch (Exception ex) {
				logger.error(ex.getMessage());
			}

			// --Abhinay : add user and send invitation
		} else if ("addInvitedUser".equals(action)) {
			try {
				JSONObject data = JSONFactoryUtil.createJSONObject();
				String firstName = ParamUtil.getString(resourceRequest, "inviteFN");
				String lastName = ParamUtil.getString(resourceRequest, "inviteLN");
				String emailAdddress = ParamUtil.getString(resourceRequest, "inviteEmail");
				String apiKey = ParamUtil.getString(resourceRequest, "apiKey");
				User user = SocialProfileServiceUtil.addUser(apiKey, firstName, lastName, emailAdddress, true);
				if (null != user) {
					data.put("status", "success");
					data.put("userId", user.getUserId());
					data.put("userName", firstName + " " + lastName);
					data.put("userImg",
							UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, user.getPortraitId()));
					logger.info("addInvitedUser - User added and invitation sent successfully");
				} else {
					data.put("status", "failed");
					logger.info("addInvitedUser - User added and invitation sent unsuccessful");
				}

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			} catch (Exception ex) {
				logger.error(ex.getMessage());
			}

		} else if ("getTagList".equals(action)) {
			try {
				JSONArray jsonResults = JSONFactoryUtil.createJSONArray();
				JSONObject data = null;
				String key = ParamUtil.getString(resourceRequest, "keys").toLowerCase();

				DynamicQuery getTagByKeysDynamicQuery = DynamicQueryFactoryUtil.forClass(AssetTag.class,
						PortletClassLoaderUtil.getClassLoader());
				Criterion criterion = null;
				criterion = RestrictionsFactoryUtil.like("name",
						new StringBuilder().append(key).append("%").toString());

				getTagByKeysDynamicQuery.add(criterion);
				List<AssetTag> tagList = AssetTagLocalServiceUtil.dynamicQuery(getTagByKeysDynamicQuery);

				for (AssetTag tag : tagList) {
					data = JSONFactoryUtil.createJSONObject();
					data.put("tagId", tag.getTagId());
					data.put("tagName", tag.getName());
					jsonResults.put(data);
				}

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(jsonResults.toString());
			} catch (Exception ex) {
				logger.error(ex.getMessage());
			}

		} else if ("getMethodologySubTypes".equals(action)) {
			try {
				JSONArray jsonResults = JSONFactoryUtil.createJSONArray();
				JSONObject data = null;
				long parentCatId = ParamUtil.getLong(resourceRequest, "parentCategoryId");
				long orgMethodologyVocId = GetterUtil.getLong(
						resourceRequest.getPreferences().getValue(StartupConstants.VOC_ORG_METHODOLOGY_ID, "0"));

				if (parentCatId > 0) {
					List<AssetCategory> subCats = AssetCategoryLocalServiceUtil.getVocabularyCategories(parentCatId,
							orgMethodologyVocId, -1, -1, null);
					for (AssetCategory sub : subCats) {
						data = JSONFactoryUtil.createJSONObject();
						data.put("categoryId", sub.getCategoryId());
						data.put("name", sub.getName());
						jsonResults.put(data);
					}
				}

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(jsonResults.toString());
			} catch (Exception ex) {
				logger.error(ex.getMessage());
			}
		} else if ("get_projects".equals(action)) {
			try {
				String searchText = ParamUtil.getString(resourceRequest, "searchText");
				JSONArray jsonResults = JSONFactoryUtil.createJSONArray();
				JSONObject data = JSONFactoryUtil.createJSONObject();
				long orgProjectsVocId = GetterUtil
						.getLong(resourceRequest.getPreferences().getValue(StartupConstants.VOC_ORG_PROJECTS_ID, "0"));

				DynamicQuery getProjectsQuery = DynamicQueryFactoryUtil
						.forClass(AssetCategory.class, PortletClassLoaderUtil.getClassLoader())
						.add(RestrictionsFactoryUtil.eq("vocabularyId", orgProjectsVocId))
						.add(RestrictionsFactoryUtil.ilike("name", "%" + searchText + "%"));

				List<AssetCategory> orgProjectList = AssetCategoryLocalServiceUtil.dynamicQuery(getProjectsQuery, -1,
						-1);
				for (AssetCategory proj : orgProjectList) {
					data = JSONFactoryUtil.createJSONObject();
					data.put("categoryId", proj.getCategoryId());
					data.put("name", proj.getName());
					jsonResults.put(data);
				}

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(jsonResults.toString());
			} catch (Exception ex) {
				logger.error(ex.getMessage());
			}
		} else if ("get_tags".equals(action)) {
			try {
				String searchText = ParamUtil.getString(resourceRequest, "searchText");
				JSONArray jsonResults = JSONFactoryUtil.createJSONArray();
				JSONObject data = JSONFactoryUtil.createJSONObject();
				long orgTagsVocId = GetterUtil
						.getLong(resourceRequest.getPreferences().getValue(StartupConstants.VOC_ORG_TAGS_ID, "0"));

				DynamicQuery getTagsQuery = DynamicQueryFactoryUtil
						.forClass(AssetCategory.class, PortletClassLoaderUtil.getClassLoader())
						.add(RestrictionsFactoryUtil.eq("vocabularyId", orgTagsVocId))
						.add(RestrictionsFactoryUtil.ilike("name", "%" + searchText + "%"));

				List<AssetCategory> orgTagList = AssetCategoryLocalServiceUtil.dynamicQuery(getTagsQuery, -1, -1);
				for (AssetCategory proj : orgTagList) {
					data = JSONFactoryUtil.createJSONObject();
					data.put("categoryId", proj.getCategoryId());
					data.put("name", proj.getName());
					jsonResults.put(data);
				}

				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(jsonResults.toString());
			} catch (Exception ex) {
				logger.error(ex.getMessage());
			}
		} else {
			try {
				// file type can be either logo..cover image..or other files
				if (logger.isDebugEnabled())
					logger.debug("Uploading files for Organization " + themeDisplay.getUserId());
				FileEntry fe = null;
				List<FileEntry> fileEntries = new ArrayList<FileEntry>();
				String uploadType = null;
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				if (ArrayUtil.isNotEmpty(multiPartData)) {
					Map<String, String> paramMap = (Map<String, String>) multiPartData[0];
					if (Validator.isNotNull(paramMap)) {
						action = paramMap.get(StartupConstants.ACTION);
						List<FileItem> files = (List<FileItem>) multiPartData[1];
						String orgIdStr = paramMap.get(StartupConstants.ORGANIZATION_ID);
						if (!themeDisplay.isSignedIn() || Validator.isNull(orgIdStr)) {
							orgIdStr = paramMap.get("orgName");
						}
						if (Validator.isNotNull(files) && !files.isEmpty() && Validator.isNotNull(orgIdStr)) {
							for (FileItem fileItem : files) {
								if (action.equals(StartupConstants.ACTION_UPLOAD_COVER)) {
									uploadType = StartupConstants.FOLDERTYPE_COVER;
								} else if (action.equals(StartupConstants.ACTION_UPLOAD_LOGO)) {
									uploadType = StartupConstants.FOLDERTYPE_LOGO;
								} else {
									uploadType = StartupConstants.FOLDERTYPE_OTHERS;
								}
								fe = SPStartupDLHelper.uploadToTemp(resourceRequest, orgIdStr, fileItem, uploadType);
								fileEntries.add(fe);
							}
						} else {
							obj.put(StartupConstants.ERROR_MSG, StartupConstants.MSG_UPLOAD_ERROR);
							resourceResponse.getWriter().write(obj.toString());
							return;
						}

						if (uploadType == StartupConstants.FOLDERTYPE_OTHERS) {
							// the list of files uploaded will be updated on UI
							// thru
							// a separate ajax request
							resourceResponse.getWriter().write(StartupConstants.SUCCESS);
							return;
						} else if (Validator.isNotNull(fe)) {
							String logoUrl = SambaashUtil.getDLFileUrl(resourceRequest, fe.getFileEntryId());
							obj.put(uploadType + "Url", logoUrl);
							obj.put(StartupConstants.FILE_ENTRY_ID, fe.getFileEntryId());
							if (logger.isInfoEnabled())
								logger.info(uploadType + " uploaded for by user = " + themeDisplay.getUserId()
										+ "orgId = " + orgIdStr + uploadType + " Url = " + logoUrl);
						} else {
							obj.put(StartupConstants.ERROR_MSG, StartupConstants.MSG_UPLOAD_ERROR);
						}
					}
				} else {
					obj.put(StartupConstants.ERROR_MSG, StartupConstants.MSG_UPLOAD_ERROR);
				}

				resourceResponse.getWriter().write(obj.toString());
			} catch (Exception e) {
				logger.error("Error while fetching users", e);
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put(StartupConstants.ERROR_MSG, StartupConstants.MSG_UPLOAD_ERROR);
				resourceResponse.getWriter().write(obj.toString());
			}
		}

	}

	private boolean checkIfCommentRequest(ResourceRequest resourceRequest) {
		return CommentTagProcess.isCommentRequest(resourceRequest);
	}

	private void signupStartup(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
			ThemeDisplay themeDisplay) throws SystemException, PortalException, Exception {
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		String userEmail = ParamUtil.getString(resourceRequest, "organization_emailId");
		String userPwd = ParamUtil.getString(resourceRequest, "login_pwd1");
		String userPwd2 = ParamUtil.getString(resourceRequest, "login_pwd2");
		String firstName = ParamUtil.getString(resourceRequest, "org_contact_fname");
		String lastName = ParamUtil.getString(resourceRequest, "org_contact_lname");
		String country = ParamUtil.getString(resourceRequest, "hq_country");
		String city = ParamUtil.getString(resourceRequest, "hq_city");
		String website = ParamUtil.getString(resourceRequest, "organization_website");
		String UEN = ParamUtil.getString(resourceRequest, "organization_uen");
		long orgId = 0;
		String orgIdVal = ParamUtil.getString(resourceRequest, "orgId");
		if (Validator.isNotNull(orgIdVal) && !orgIdVal.isEmpty()) {
			orgId = Long.parseLong(orgIdVal);
		}
		FileEntry fe = null;

		Date now = new Date();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Organization.class.getName(),
				resourceRequest);

		User startupUser = StartupSignupUtil.getStartupProfileUser(serviceContext, themeDisplay.getCompanyId(),
				userEmail, firstName, lastName, userPwd, userPwd2, themeDisplay);
		SocialProfileLocalServiceUtil.updateProfileType(startupUser, ProfileType.STARTUP, serviceContext);
		obj.put("dashBoardUrl", SambaashUtil.getDashboardUrl(themeDisplay.getScopeGroupId(), startupUser.getUserId()));
		Organization org = null;
		if (orgId <= 0) {
			orgId = CounterLocalServiceUtil.increment("Organization");
			org = OrganizationLocalServiceUtil.createOrganization(orgId);
		} else {
			org = OrganizationLocalServiceUtil.getOrganization(orgId);
		}

		if (Validator.isNotNull(org)) {
			// FileEntry fileEntry = DLAppServiceUtil.getFileEntry(groupId,
			// folderId, title);
			org.setEmailId(userEmail);
			org.setDescription(ParamUtil.getString(resourceRequest, "organization_description"));
			org.setCategories("");
			org.setName(ParamUtil.getString(resourceRequest, "organization_name"));
			org.setIsBaseOrg(true);
			org.setActive(true);
			org.setUserId(startupUser.getUserId());
			org.setUserName(startupUser.getFullName());
			org.setGroupId(themeDisplay.getScopeGroupId());
			org.setCompanyId(themeDisplay.getCompanyId());
			org.setUen(UEN);
			org.setCorporateCode(UEN);
			org.setCreateDate(now);
			org.setModifiedDate(now);
			org.setWebsite(website);

			try {
				// Move files from temp folder to actual folder
				fe = SPStartupDLHelper.updateOrMoveFolders(resourceRequest,
						ParamUtil.getString(resourceRequest, "organization_name"), String.valueOf(orgId),
						StartupConstants.FOLDERTYPE_LOGO);
			} catch (Exception e) {
				logger.error("Error while uploading logo" + e.getMessage(), e);
			}
			if (Validator.isNotNull(fe)) {
				org.setLogoId(fe.getFileEntryId());
			}
			OrganizationLocalServiceUtil.addOrganization(org);

			try {
				long addressId = CounterLocalServiceUtil.increment("Address");
				Address hqAddress = AddressLocalServiceUtil.createAddress(addressId);
				hqAddress.setCountry(country);
				hqAddress.setOrganizationId(orgId);
				hqAddress.setHq(true);
				hqAddress.setUserId(startupUser.getUserId());
				hqAddress.setGroupId(themeDisplay.getScopeGroupId());
				hqAddress.setCompanyId(themeDisplay.getCompanyId());
				hqAddress.setCreateDate(now);
				hqAddress.setModifiedDate(now);
				hqAddress.setActive(true);
				hqAddress.setUserName(startupUser.getFullName());
				hqAddress.setCity(city);
				AddressLocalServiceUtil.addAddress(hqAddress);
			} catch (Exception e) {
				logger.error("Error while setting Organizatin address", e);
			}
		}

		try {
			long[] categoryIds = getSelectedCategoryIds(resourceRequest);
			long[] tagIds = getTagIds(resourceRequest);
			long[] consolidatedCatIds = ArrayUtil.append(categoryIds, tagIds);
			logger.error("categoryIds=" + ReflectionToStringBuilder.toString(categoryIds, ToStringStyle.SIMPLE_STYLE));
			logger.error("tagIds=" + ReflectionToStringBuilder.toString(categoryIds, ToStringStyle.SIMPLE_STYLE));
			logger.error("consolidatedCatIds="
					+ ReflectionToStringBuilder.toString(categoryIds, ToStringStyle.SIMPLE_STYLE));
			AssetEntryLocalServiceUtil.updateEntry(startupUser.getUserId(), themeDisplay.getScopeGroupId(),
					Organization.class.getName(), org.getOrganizationId(), consolidatedCatIds, null);
		} catch (Exception e) {
			logger.error("Failed to save category entries during sign up!", e);
		}

		obj.put(StartupConstants.ORGANIZATION_ID, orgId);
		logger.error("successfully saved organization data = " + orgId);
		resourceResponse.getWriter().write(obj.toString());
	}

	private long getRatingComponentId(PortletRequest request) {
		return GetterUtil.getLong(request.getPreferences().getValue(RatingConstants.COMPONENT_ID, ""));
	}

	private long[] getSelectedCategoryIds(ResourceRequest resourceRequest) {
		String categories = ParamUtil.getString(resourceRequest, "asset_orgCategoryList");
		long[] catIds = {};
		if (StringUtils.isNotEmpty(categories)) {
			String[] idList = categories.split(",");
			catIds = new long[idList.length];
			for (int i = 0; i < idList.length; i++) {
				catIds[i] = Long.parseLong(idList[i]);
			}
		}
		return catIds;
	}

	private long[] getTagIds(ResourceRequest resourceRequest) {
		String tagIds = ParamUtil.getString(resourceRequest, "startupTag_tagIdList");
		long[] catIds = {};
		if (StringUtils.isNotEmpty(tagIds)) {
			String[] idList = tagIds.split(",");
			catIds = new long[idList.length];
			for (int i = 0; i < idList.length; i++) {
				catIds[i] = Long.parseLong(idList[i]);
			}
		}
		return catIds;
	}

	private static class Util {
		private static final String FILE_CLASSNAME = DLFileEntry.class.getName();
		private static final String FOLDER_CLASSNAME = DLFolder.class.getName();
		private static final String[] DEFAULT_PERMISSIONS = { "SHARE", ActionKeys.DELETE, ActionKeys.PERMISSIONS,
				ActionKeys.VIEW, ActionKeys.UPDATE };
		private static final String DEFAULT_PERMISSION_ROLES = "Site Member"; // comma-delimited
		private static final long DL_ROOT_FOLDER_ID = 0;
		private static final Log LOG = LogFactoryUtil.getLog(Util.class);

		private Util() {
			// only static methods can be added here
		}

		@SuppressWarnings("unchecked")
		public static Object[] parseFileUploadRequest(PortletRequest actionRequest) throws FileUploadException {
			Object[] objs = new Object[2];
			Map<String, String> paramMap = new HashMap<>();
			List<FileItem> files = new ArrayList<>();

			HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);
			try {
				List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(httpRequest);
				String key;
				for (FileItem item : items) {
					if (item.isFormField()) {
						key = item.getFieldName();
						paramMap.put(key, item.getString());
					} else {
						files.add(item);
					}
				}

			} catch (FileUploadException e) {
				LOG.error(e.getMessage(), e);
				throw e;
			}

			objs[0] = paramMap;
			objs[1] = files;

			return objs;
		}

		public static FileEntry uploadFile(PortletRequest request, FileItem item, boolean isTemp)
				throws PortalException, SystemException {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(FILE_CLASSNAME, request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long scopeGroupId = themeDisplay.getScopeGroupId();
			long companyId = themeDisplay.getCompanyId();
			FileEntry fileEntry = null;

			Folder folder = getSPFormFolder(request, isTemp);

			final long folderId = folder.getFolderId();
			String name = item.getName();

			try {
				fileEntry = DLAppServiceUtil.addFileEntry(scopeGroupId, folderId, name, item.getContentType(), name,
						StringPool.BLANK, StringPool.BLANK, item.getInputStream(), item.getSize(), serviceContext);
				addDefaultFilePermissions(companyId, fileEntry.getFileEntryId());
			} catch (DuplicateFileException ex) {
				fileEntry = DLAppServiceUtil.getFileEntry(scopeGroupId, folderId, name); // the
																							// duplicate
				DLFileVersion fileVersion = DLFileVersionLocalServiceUtil
						.getLatestFileVersion(fileEntry.getFileEntryId(), false);
				if (fileVersion.getStatus() == WorkflowConstants.STATUS_INACTIVE) {
					fileVersion.setStatus(WorkflowConstants.STATUS_APPROVED);
					DLFileVersionLocalServiceUtil.updateDLFileVersion(fileVersion);
				}
				try {
					fileEntry = DLAppServiceUtil.updateFileEntryAndCheckIn(fileEntry.getFileEntryId(),
							fileEntry.getTitle(), item.getContentType(), name, "", "", true, item.getInputStream(),
							item.getSize(), serviceContext);
					addDefaultFilePermissions(companyId, fileEntry.getFileEntryId());
				} catch (FileSizeException fs) {
					LOG.error("File size exceeds maximum allowed limit" + fs.getMessage());
				} catch (Exception ex1) {
					LOG.error("Error while uploading file " + ex1.getMessage());
				}
			} catch (IOException e) {
				LOG.error("Error uploading file.", e);
			}
			return fileEntry;
		}

		private static String getSPFormFolderName(long formId) {
			return String.format("SPForm/%d", formId);
		}

		private static String getUserFolderName(long userId, long formId) {
			return String.format("%s/User_%d", getSPFormFolderName(formId), userId);
		}

		private static void addDefaultFolderPermissions(long companyId, long folderId) {
			addDefaultPermissions(companyId, folderId, FOLDER_CLASSNAME);
		}

		private static void addDefaultFilePermissions(long companyId, long fileEntryId) {
			addDefaultPermissions(companyId, fileEntryId, FILE_CLASSNAME);
		}

		private static void addDefaultPermissions(long companyId, long entryId, String permClassname) {
			String[] privilegedRoles = DEFAULT_PERMISSION_ROLES.split(",");
			for (String roleName : privilegedRoles) {
				try {
					Role role = RoleLocalServiceUtil.getRole(companyId, roleName);
					PermissionUtil.addResourcePermission(companyId, role.getRoleId(), permClassname, entryId,
							DEFAULT_PERMISSIONS);
				} catch (Exception e) {
					LOG.error("Error while assigning permissions to roles " + e.getMessage());
				}
			}
		}

		private static Folder getSPFormFolder(PortletRequest request, boolean isTemp)
				throws PortalException, SystemException {
			Folder folder;
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String formId = "1";
			long id = StringUtils.isEmpty(formId) ? 0L : Long.parseLong(formId);
			String folderName = getUserFolderName(themeDisplay.getUserId(), id);
			if (isTemp) {
				folderName = folderName + "/temp";
			}
			folder = recursiveGetFolder(request, new LinkedList<>(Arrays.asList(folderName.split("/"))), null);
			return folder;
		}

		private static Folder recursiveGetFolder(PortletRequest request, LinkedList<String> folderList,
				Folder parentFolder) throws PortalException, SystemException {
			if (folderList.isEmpty())
				return parentFolder;
			String folderName = folderList.removeFirst();
			Folder folder = getFolder(request, folderName,
					parentFolder == null ? DL_ROOT_FOLDER_ID : parentFolder.getFolderId());
			return recursiveGetFolder(request, folderList, folder);
		}

		private static Folder getFolder(PortletRequest request, String folderName, Long parentFolderId)
				throws PortalException, SystemException {
			if (folderName == null) {
				return null;
			}
			Folder folder;
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = themeDisplay.getScopeGroupId();
			try {
				folder = DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName);
			} catch (NoSuchFolderException ex) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(FOLDER_CLASSNAME, request);

				LOG.error("groupId : " + groupId + " : parentFolderId : " + parentFolderId + " : folderName : "
						+ folderName);

				updatePermissions(themeDisplay.getCompanyId(), groupId, parentFolderId);

				folder = DLAppServiceUtil.addFolder(groupId, parentFolderId, folderName, folderName, serviceContext);
				addDefaultFolderPermissions(themeDisplay.getCompanyId(), folder.getFolderId());
			} catch (PortalException | SystemException e) {
				folder = null;
				LOG.error("Error while getting folder" + e.getMessage());
			}
			return folder;
		}

		public static void setErrorResponse(ResourceResponse response, Exception e) {
			JSONObject errorObj = JSONFactoryUtil.createJSONObject();
			String errMsg = StringUtils.isNotEmpty(e.getMessage()) ? e.getMessage() : e.toString();
			errorObj.put("error", errMsg);
			try {
				response.getWriter().write(errorObj.toString());
			} catch (Exception e2) {
				// should not reach here
				LOG.error("Error returning error message", e);
			}
		}

		public static void updatePermissions(long companyId, long groupId, long primaryKey) {

			try {

				LOG.error(" Updating folder permission for :  " + primaryKey);
				ResourceLocalServiceUtil.updateResources(companyId,
						groupId, DLFolder.class.getName(), primaryKey, new String[] { ActionKeys.VIEW,
								ActionKeys.UPDATE, ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SUBFOLDER },
						new String[] { ActionKeys.VIEW });

				List<DLFolder> subFolderList = DLFolderLocalServiceUtil.getFolders(groupId, primaryKey);

				for (DLFolder dlFolder : subFolderList) {
					updatePermissions(companyId, groupId, dlFolder.getFolderId());
				}
			} catch (PortalException | SystemException e) {
				LOG.error("Error occured while updating permission : " + e.getMessage());
			}
		}

	}

}
