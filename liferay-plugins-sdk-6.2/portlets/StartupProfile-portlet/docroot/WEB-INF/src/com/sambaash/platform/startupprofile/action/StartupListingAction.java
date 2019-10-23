package com.sambaash.platform.startupprofile.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.startupprofile.StartupConstants;
import com.sambaash.platform.startupprofile.helper.StartupFormHelper;
import com.sambaash.platform.startupprofile.helper.StartupPermissionHelper;
import com.sambaash.platform.startupprofile.helper.StartupProfileHelper;
import com.sambaash.platform.startupprofile.reports.StartupProfileExporter;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.SambaashUtil;

public class StartupListingAction extends MVCPortlet {

	private static final Log logger = LogFactoryUtil
			.getLog(StartupListingAction.class);

	public void searchAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		search(actionRequest, actionResponse);
		actionResponse.setRenderParameter("jspPage",
				"/html/startuplisting/view.jsp");
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}

	public void search(PortletRequest request, PortletResponse response)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		List<String> headerNames = new ArrayList<String>();
		headerNames.add(StartupConstants.NAME);
		headerNames.add(StartupConstants.DESCRIPTION);
		headerNames.add("Created By");
		headerNames.add("Actions");

		StartupFormHelper.fillCategories(request, null);

		PortletURL portletURL = getRenderUrl(
				StartupConstants.PORTLET_ID_STARTUP_LISTING, request,
				themeDisplay);
		PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String errorMessage = "No Startup Profiles!";
		errorMessage = LabelUtil.getLabel(portletConfig,themeDisplay,"label.no.startup.profiles");
		
		SearchContainer<StartupListingAction> searchContainer = new SearchContainer<StartupListingAction>(
				request, null, null, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_DELTA, portletURL, headerNames,
				errorMessage);

		addSearchAttributes(request, portletURL);

		portletURL.setParameter(searchContainer.getCurParam(),
				String.valueOf(searchContainer.getCur()));
		Hits results = searchDocuments(themeDisplay, request,
				searchContainer.getStart(), searchContainer.getEnd());
		boolean hasRows = results.getLength() > 0;
		request.setAttribute("hasRows", hasRows);
		try {
			if (results != null) {
				searchContainer.setTotal(results.getLength());
				List<ResultRow> resultRows = searchContainer.getResultRows();
				int length = results.getDocs().length;
				for (int i = 0; i < length; i++) {
					Document doc = results.doc(i);
					long classPK = GetterUtil.getLong(doc
							.get(Field.ENTRY_CLASS_PK));
					ResultRow row = new ResultRow(doc, classPK, i);

					String orgName = GetterUtil.getString(doc
							.get(StartupConstants.NAME));
					row.addText("<div class='applicantStartup'><p><a href='"
							+ StartupProfileHelper
									.displayStartupDetailsFriendlyURL(
											themeDisplay, classPK)

							+ "'>" + orgName + "</a></p></div>");

					String desc = doc.get(StartupConstants.DESCRIPTION);
					if (desc.length() > 105) {
						desc = desc.substring(0, 80) + "...";
					}
					row.addText(desc);
					// Startup Created user
					User scUser = null;
					try {
						long userId = GetterUtil
								.getLong(doc.get(Field.USER_ID));
						if (userId != 0) {
							scUser = UserLocalServiceUtil.getUser(userId);
						}
					} catch (Exception ex) {

					}
					if (Validator.isNotNull(scUser)) {
						String userProfileUrl = SocialProfileLocalServiceUtil
								.getIndProfilePublicUrl(
										themeDisplay.getCompanyId(),
										themeDisplay.getScopeGroupId(),
										scUser.getUserId());
						row.addText("<div class='applicantStartup'><p><a href='"
								+ userProfileUrl + "'>" + scUser.getFullName()
								+ "</a></p></div>");
					} else {
						row.addText(StringPool.BLANK);
					}

					String deleteUrl = StartupProfileHelper
							.deleteStarupFriendlyURL(themeDisplay, classPK);
					HttpServletRequest httpOrig = PortalUtil
							.getOriginalServletRequest(PortalUtil
									.getHttpServletRequest(request));
					String authToken = AuthTokenUtil.getToken(httpOrig);
					deleteUrl = addSearchParamsToUrl(deleteUrl, authToken,
							searchContainer, request);

					PortletURL exportUrl = PortletURLFactoryUtil.create(
							request,
							StartupConstants.PORTLET_ID_STARTUP_LISTING,
							themeDisplay.getPlid(),
							PortletRequest.RESOURCE_PHASE); 
					exportUrl.setParameter("action", "exportPdf");
					exportUrl.setParameter(StartupConstants.ORGANIZATION_ID,
							String.valueOf(classPK));
					Map<String, Object> data = row.getData();
					if (Validator.isNull(data)) {
						data = new HashMap<String, Object>();
					}
					data.put("deleteUrl", deleteUrl);
					data.put("viewUrl", StartupProfileHelper.displayStartupDetailsFriendlyURL(themeDisplay, classPK));
					data.put("exportUrl", exportUrl.toString());
					row.setData(data);
					row.addJSP("/html/startuplisting/sub-menu.jsp");
					resultRows.add(row);
				}
			}
		} catch (Exception e) {
			logger.error("Error while creating the search container", e);
		}
		request.setAttribute("searchContainer", searchContainer);
	}

	private Hits searchDocuments(ThemeDisplay themeDisplay,
			PortletRequest request, int start, int end) {
		Hits results = null;
		try {
			SearchContext searchContext = new SearchContext();
			searchContext.setStart(start);
			searchContext.setEnd(end);
			searchContext.setCompanyId(themeDisplay.getUser().getCompanyId());

			Sort sort = SortFactoryUtil.create(StartupConstants.NAME,
					Sort.STRING_TYPE, false);
			Sort[] sorts = new Sort[] { sort };
			searchContext.setSorts(sorts);

			List<BooleanClause> bcs = new ArrayList<BooleanClause>();
			BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
			bq.addRequiredTerm(StartupConstants.ACTIVE, true);
			BooleanClause bc = BooleanClauseFactoryUtil.create(searchContext,
					bq, BooleanClauseOccur.MUST.getName());
			bcs.add(bc);

			bq = BooleanQueryFactoryUtil.create(searchContext);
			bq.addRequiredTerm(StartupConstants.BASE_ORG, true);
			bc = BooleanClauseFactoryUtil.create(searchContext, bq,
					BooleanClauseOccur.MUST.getName());
			bcs.add(bc);

			boolean isAdmin = SambaashUtil.isAdmin(themeDisplay
					.getScopeGroupId(), themeDisplay.getUser().getUserId());

			if (!isAdmin
					&& !SambaashUtil.isFoundryAdmin(themeDisplay.getUser())) {
				bcs.add(addSearchClause(searchContext, Field.USER_ID,
						themeDisplay.getUser().getUserId() + "", false));
			}

			// search params
			String searchStartupName = ParamUtil.getString(request,
					StartupConstants.PARAM_SEARCH_STARTUP_NAME);
			String searchStartupEmail = ParamUtil.getString(request,
					StartupConstants.PARAM_SEARCH_STARTUP_EMAIL);
			String searchLifecycleStage = ParamUtil.getString(request,
					StartupConstants.PARAM_SEARCH_STARTUP_LIFECYCLE);
			String searchCountry = ParamUtil.getString(request,
					StartupConstants.PARAM_SEARCH_COUNTRY);
			String searchCategory = ParamUtil.getString(request,
					StartupConstants.PARAM_SEARCH_CATEGORY);

			if (Validator.isNotNull(searchStartupEmail)) {
				// Exact email address match
				searchStartupEmail = StringPool.QUOTE + searchStartupEmail + StringPool.QUOTE ;
				bq = BooleanQueryFactoryUtil.create(searchContext);
				bq.addTerm(StartupConstants.EMAIL, searchStartupEmail, true);
				bq.addTerm(StartupConstants.FILLED_BY_EMAIL,
						searchStartupEmail, true);
				BooleanClause clause = BooleanClauseFactoryUtil.create(
						searchContext, bq, BooleanClauseOccur.MUST.getName());
				bcs.add(clause);
			}

			if (Validator.isNotNull(searchStartupName)) {
				bcs.add(addSearchClause(searchContext, StartupConstants.NAME,
						searchStartupName, true));
			}
			if (Validator.isNotNull(searchLifecycleStage)) {
				bcs.add(addSearchClause(searchContext,
						Field.ASSET_CATEGORY_IDS, searchLifecycleStage, false));
			}
			if (Validator.isNotNull(searchCountry)) {
				bcs.add(addSearchClause(searchContext,
						Field.ASSET_CATEGORY_IDS, searchCountry, false));
			}
			if (Validator.isNotNull(searchCategory)) {
				bcs.add(addSearchClause(searchContext,
						Field.ASSET_CATEGORY_IDS, searchCategory, false));
			}

			if (Validator.isNotNull(bcs) && bcs.size() > 0) {
				searchContext.setBooleanClauses(bcs
						.toArray(new BooleanClause[bcs.size()]));
			}
			Indexer indexer = IndexerRegistryUtil.getIndexer(Organization.class
					.getName());

			results = indexer.search(searchContext);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return results;
	}

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		StartupFormHelper.preparePreferencesData(renderRequest, renderResponse);
		super.doEdit(renderRequest, renderResponse);
	}

	public void savePreferences(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		StartupFormHelper.savePreferences(actionRequest, actionResponse);
	}

	protected boolean download(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, String fileName) {

		try {
			String contentType = MimeTypesUtil.getContentType(fileName);
			File file = new File(fileName);
			boolean exists = file.exists();
			if (!exists) {
				logger.info("File does not exists");
			}

			Integer length = new Integer(file.length() + "");
			resourceResponse.setContentType(contentType);
			resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL,
					"max-age=3600, must-revalidate");
			resourceResponse.addProperty("Content-Disposition",
					"attachment; filename=\"" + file.getName() + "\"");
			resourceResponse.setContentLength(length);
			logger.info("File length ==" + file.length());
			if (file.length() <= 0) {
				return false;
			}

			final FileInputStream fos = new FileInputStream(file);
			BufferedOutputStream output = null;
			output = new BufferedOutputStream(
					resourceResponse.getPortletOutputStream(), length);
			byte[] buffer = new byte[length];
			while ((length = fos.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			if (fos != null) {
				fos.close();
			}

		} catch (Exception e) {
			if (logger.isWarnEnabled()) {
				logger.warn(e, e);
			}
		}
		return true;
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		HttpServletRequest httpOrig = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(renderRequest));
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String action = ParamUtil.getString(renderRequest, "actionp");
		long orgId = ParamUtil.getLong(renderRequest,
				StartupConstants.ORGANIZATION_ID);
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String errorMessage = "Error while deleting startup profile";
		String successMessage1 = "Startup Profile '";
		String successMessage2 = "' successfully deleted.";
		successMessage1 = LabelUtil.getLabel(portletConfig,themeDisplay,"label.startup.profile");
		successMessage2	= LabelUtil.getLabel(portletConfig,themeDisplay,"label.startup.delete.success");
		errorMessage = LabelUtil.getLabel(portletConfig,themeDisplay,"label.error.delete.startup");
		if ("exportProfile".equalsIgnoreCase(action)) {
			return;
		} else if ("deleteProfile".equalsIgnoreCase(action)) {
			try {
				AuthTokenUtil.check(httpOrig);
			} catch (PortalException e1) {
				renderRequest.setAttribute("msg",
						StartupConstants.UNAUTH_MSG_VIEW);
				super.doView(renderRequest, renderResponse);
				return;
			}
			if (StartupPermissionHelper.canDeleteStartup(renderRequest, orgId)) {
				try {
					Organization org = OrganizationLocalServiceUtil
							.getOrganization(orgId);
					boolean status = StartupProfileHelper.deleteStartup(
							renderRequest, orgId);
					if (status) {
						renderRequest.setAttribute("msg", successMessage1
								+ org.getName() + successMessage2);
					}
				} catch (Exception e) {
					logger.error(e);
					renderRequest.setAttribute("msg",
							errorMessage);
				}
			}
		}

		this.search(renderRequest, renderResponse);
		super.doView(renderRequest, renderResponse);
	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String action = ParamUtil.getString(resourceRequest, "action");
			if ("exportPdf".equalsIgnoreCase(action)) {
				long orgId = ParamUtil.getLong(resourceRequest,
						StartupConstants.ORGANIZATION_ID);
				Organization org = OrganizationLocalServiceUtil
						.getOrganization(orgId);
				String fileName = OrganizationLocalServiceUtil
						.exportStartupDetails(themeDisplay, org, null);
				if (StartupPermissionHelper.canViewStartup(resourceRequest,
						orgId)) {
					if (!download(resourceRequest, resourceResponse, fileName))
						logger.error("File was not generated");
				} else {
					logger.error("User does not have permission to view startup so unable to export to pdf report");
				}
			} else if ("exportResults".equalsIgnoreCase(action)) {
				Hits results = searchDocuments(themeDisplay, resourceRequest,
						-1, -1);
				String fileName = StartupProfileExporter.exportDoc(
						results.getDocs(), themeDisplay, resourceRequest);
				if (!download(resourceRequest, resourceResponse, fileName))
					logger.error("File was not generated");
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	private String addSearchParamsToUrl(String url, String authToken,
			SearchContainer searchContainer, PortletRequest request) {
		if (Validator.isNotNull(url)) {
			String kv1 = "&%s=%s";
			String kv2 = "%s=%s";
			StringBuilder sb = new StringBuilder(url);
			sb.append(StringPool.QUESTION);
			sb.append(String.format(kv2, searchContainer.getCurParam(),
					String.valueOf(searchContainer.getCur())));
			sb.append(String.format(kv1, SearchContainer.DEFAULT_DELTA_PARAM,
					ParamUtil.getString(request,
							SearchContainer.DEFAULT_DELTA_PARAM)));
			sb.append(String.format(kv1, "resetCur",
					ParamUtil.getString(request, "resetCur")));
			sb.append(String.format(kv1, "p_auth", authToken));

			String searchCategory = ParamUtil.getString(request,
					StartupConstants.PARAM_SEARCH_CATEGORY);
			if (Validator.isNotNull(searchCategory)) {
				sb.append(String.format(kv1,
						StartupConstants.PARAM_SEARCH_CATEGORY, searchCategory));
			}
			String searchCountry = ParamUtil.getString(request,
					StartupConstants.PARAM_SEARCH_COUNTRY);
			if (Validator.isNotNull(searchCountry)) {
				sb.append(String.format(kv1,
						StartupConstants.PARAM_SEARCH_COUNTRY, searchCountry));
			}
			String searchLifecycleStage = ParamUtil.getString(request,
					StartupConstants.PARAM_SEARCH_STARTUP_LIFECYCLE);
			if (Validator.isNotNull(searchLifecycleStage)) {
				sb.append(String.format(kv1,
						StartupConstants.PARAM_SEARCH_STARTUP_LIFECYCLE,
						searchLifecycleStage));
			}
			String searchStartupEmail = ParamUtil.getString(request,
					StartupConstants.PARAM_SEARCH_STARTUP_EMAIL);
			if (Validator.isNotNull(searchStartupEmail)) {
				sb.append(String.format(kv1,
						StartupConstants.PARAM_SEARCH_STARTUP_EMAIL,
						searchStartupEmail));
			}
			String searchStartupName = ParamUtil.getString(request,
					StartupConstants.PARAM_SEARCH_STARTUP_NAME);
			if (Validator.isNotNull(searchStartupName)) {
				sb.append(String.format(kv1,
						StartupConstants.PARAM_SEARCH_STARTUP_NAME,
						searchStartupName));
			}
			return sb.toString();
		}
		return StringPool.BLANK;
	}

	private PortletURL getRenderUrl(String portledId, PortletRequest request,
			ThemeDisplay themeDisplay) {
		PortletURL portletURL = PortletURLFactoryUtil.create(request,
				portledId, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		portletURL.setParameter("formPage",
				ParamUtil.getString(request, "formPage"));
		return portletURL;
	}

	private void addSearchAttributes(PortletRequest request,
			PortletURL portletURL) {

		String searchStartupName = ParamUtil.getString(request,
				StartupConstants.PARAM_SEARCH_STARTUP_NAME);
		request.setAttribute(StartupConstants.PARAM_SEARCH_STARTUP_NAME,
				searchStartupName);
		portletURL.setParameter(StartupConstants.PARAM_SEARCH_STARTUP_NAME,
				searchStartupName);

		String searchStartupEmail = ParamUtil.getString(request,
				StartupConstants.PARAM_SEARCH_STARTUP_EMAIL);
		request.setAttribute(StartupConstants.PARAM_SEARCH_STARTUP_EMAIL,
				searchStartupEmail);
		portletURL.setParameter(StartupConstants.PARAM_SEARCH_STARTUP_EMAIL,
				searchStartupEmail);

		List<Long> tempList = new ArrayList<Long>();
		String searchLifecycleStage = ParamUtil.getString(request,
				StartupConstants.PARAM_SEARCH_STARTUP_LIFECYCLE);
		tempList.add(GetterUtil.getLong(searchLifecycleStage));
		request.setAttribute(StartupConstants.PARAM_SEARCH_STARTUP_LIFECYCLE,
				tempList);
		portletURL.setParameter(
				StartupConstants.PARAM_SEARCH_STARTUP_LIFECYCLE,
				searchLifecycleStage);

		tempList = new ArrayList<Long>();
		String searchCountry = ParamUtil.getString(request,
				StartupConstants.PARAM_SEARCH_COUNTRY);
		tempList.add(GetterUtil.getLong(searchCountry));
		request.setAttribute(StartupConstants.PARAM_SEARCH_COUNTRY, tempList);
		portletURL.setParameter(StartupConstants.PARAM_SEARCH_COUNTRY,
				searchCountry);

		tempList = new ArrayList<Long>();
		String searchCategory = ParamUtil.getString(request,
				StartupConstants.PARAM_SEARCH_CATEGORY);
		tempList.add(GetterUtil.getLong(searchCategory));
		request.setAttribute(StartupConstants.PARAM_SEARCH_CATEGORY, tempList);
		portletURL.setParameter(StartupConstants.PARAM_SEARCH_CATEGORY,
				searchCategory);

	}

	private BooleanClause addSearchClause(SearchContext searchContext,
			String key, String value, boolean isLike) throws Exception {
		BooleanQuery bq = BooleanQueryFactoryUtil.create(searchContext);
		bq.addTerm(key, value, isLike);
		BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext,
				bq, BooleanClauseOccur.MUST.getName());
		return clause;
	}

}
