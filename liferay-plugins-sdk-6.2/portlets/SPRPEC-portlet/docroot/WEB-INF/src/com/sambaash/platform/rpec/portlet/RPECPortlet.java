package com.sambaash.platform.rpec.portlet;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.rpec.ajax.ArchiveActionHandler;
import com.sambaash.platform.rpec.ajax.CandidateProfile;
import com.sambaash.platform.rpec.ajax.CheckCompetencyProficiencyActionHandler;
import com.sambaash.platform.rpec.ajax.CompetenceSubjectsActionHandler;
import com.sambaash.platform.rpec.ajax.CompetenceSubjectsQuestionsActionHandler;
import com.sambaash.platform.rpec.ajax.CompetenceTypeActionHandler;
import com.sambaash.platform.rpec.ajax.CreateRemarkActionHandler;
import com.sambaash.platform.rpec.ajax.CreateActionHandler;
import com.sambaash.platform.rpec.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.rpec.ajax.ExportListActionHandler;
import com.sambaash.platform.rpec.ajax.ExportRowActionHandler;
import com.sambaash.platform.rpec.ajax.FetchActionHandler;
import com.sambaash.platform.rpec.ajax.FetchCandidateOfInternalUser;
import com.sambaash.platform.rpec.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.rpec.ajax.FetchRemarksActionHandler;
import com.sambaash.platform.rpec.ajax.FileDownloadActionHandler;
import com.sambaash.platform.rpec.ajax.FilterColumnListActionHandler;
import com.sambaash.platform.rpec.ajax.ListByElastic;
import com.sambaash.platform.rpec.ajax.LoadListActionHandler;
import com.sambaash.platform.rpec.ajax.SearchListActionHandler;
import com.sambaash.platform.rpec.service.SPRPECLocalServiceUtil;
import com.sambaash.platform.rpec.ajax.StatusUpdateActionHandler;
import com.sambaash.platform.util.SambaashUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class RPEC
 */
public class RPECPortlet extends MVCPortlet {
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;

	private String roleName;
	private Log log = LogFactoryUtil.getLog(RPECPortlet.class.getName());
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist",
				CreateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData",
				FetchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchFormFields",
				FetchFormFieldsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadList",
				LoadListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("searchList",
				SearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler(
				"elastiSearchList", ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler(
				"filterColumnList", FilterColumnListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportRow",
				ExportRowActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportList",
				ExportListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fileDownload",
				FileDownloadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("competenceType",
				CompetenceTypeActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler(
				"competenceSubject", CompetenceSubjectsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler(
				"elastiSearchList", ListByElastic.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler(
				"competenceQuestions",
				CompetenceSubjectsQuestionsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchRemarks",
				FetchRemarksActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("addRemarks",
				CreateRemarkActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("updateStatus",
				StatusUpdateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("archiveRecord",
				ArchiveActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("candidateProfile",
				CandidateProfile.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("checkCompetencyProficiency",
				CheckCompetencyProficiencyActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("getcandidateforinternaluser",
				FetchCandidateOfInternalUser.class);
	}

	@Override
	public void doView(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		// TODO Auto-generated method stub

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences prefer = request.getPreferences();
		String candidateRole = null;
		String relcUser = null;
		String trainingPricipalRole = null;
		String mentor = null;
		if (prefer.getMap().containsKey("candidateRole")) {
			candidateRole = prefer.getMap().get("candidateRole")[0];
		}
		if (prefer.getMap().containsKey("relcUserRole")) {
			relcUser = prefer.getMap().get("relcUserRole")[0];
		}
		if (prefer.getMap().containsKey("traniningPrincipalRole")) {
			trainingPricipalRole = prefer.getMap()
					.get("traniningPrincipalRole")[0];
		}
		if (prefer.getMap().containsKey("mentor")) {
			mentor = prefer.getMap().get("mentor")[0];
		}
		String userType = SPRPECLocalServiceUtil.getUserType(candidateRole,
				relcUser, trainingPricipalRole, mentor,
				themeDisplay.getUserId());
		request.setAttribute("userType", userType);
		super.doView(request, response);
	}

	/**
	 * This is an object of Log class
	 */
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		PortletPreferences prefer = request.getPreferences();
		String candidateRole = null;
		String relcUser = null;
		String trainingPricipalRole = null;
		String mentor = null;
		if (prefer.getMap().containsKey("candidateRole")) {
			candidateRole = prefer.getMap().get("candidateRole")[0];
		}
		if (prefer.getMap().containsKey("relcUserRole")) {
			relcUser = prefer.getMap().get("relcUserRole")[0];
		}
		if (prefer.getMap().containsKey("traniningPrincipalRole")) {
			trainingPricipalRole = prefer.getMap()
					.get("traniningPrincipalRole")[0];
		}
		if (prefer.getMap().containsKey("mentor")) {
			mentor = prefer.getMap().get("mentor")[0];
		}
		String userType = SPRPECLocalServiceUtil.getUserType(candidateRole,
				relcUser, trainingPricipalRole, mentor,
				themeDisplay.getUserId());
		request.setAttribute("userType", userType);
		super.render(request, response);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		try {
			String action = resourceRequest.getParameter("action");
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest,
					resourceResponse);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void savePreferences(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		PortletPreferences preferences = actionRequest.getPreferences();
		String formId = ParamUtil.getString(actionRequest,
				SystemSetupConstants.PREF_HTML_FORM_ID, "0");
		String style = ParamUtil.getString(actionRequest,
				SystemSetupConstants.PREF_CONTAINER_STYLE, "");
		String modelName = ParamUtil.getString(actionRequest,
				SystemSetupConstants.PREF_MODEL_NAME, "0");
		String baseUrl = ParamUtil.getString(actionRequest,
				SystemSetupConstants.PREF_BASE_URL, "");
		String maximumCalendarDays = ParamUtil.getString(actionRequest,
				"maximumCalendarDays", "");
		String legendsLink = ParamUtil.getString(actionRequest, "legendsLink",
				"");
		String candidateRole = ParamUtil.getString(actionRequest,
				"candidateRole", "");
		String relcUserRole = ParamUtil.getString(actionRequest,
				"relcUserRole", "");
		String traniningPrincipalRole = ParamUtil.getString(actionRequest,
				"traniningPrincipalRole", "");
		String mentor = ParamUtil.getString(actionRequest, "mentor", "");

		try {
			preferences
					.setValue(SystemSetupConstants.PREF_HTML_FORM_ID, formId);
			preferences.setValue(SystemSetupConstants.PREF_CONTAINER_STYLE,
					style);
			preferences.setValue(SystemSetupConstants.PREF_MODEL_NAME,
					modelName);
			preferences.setValue(SystemSetupConstants.PREF_BASE_URL, baseUrl);
			preferences.setValue("maximumCalendarDays", maximumCalendarDays);
			preferences.setValue("legendsLink", legendsLink);
			preferences.setValue("candidateRole", candidateRole);
			preferences.setValue("relcUserRole", relcUserRole);
			preferences.setValue("traniningPrincipalRole",
					traniningPrincipalRole);
			preferences.setValue("mentor", mentor);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException | ValidatorException | IOException
				| PortletModeException e) {
			log.error(e);
		}
	}
}
