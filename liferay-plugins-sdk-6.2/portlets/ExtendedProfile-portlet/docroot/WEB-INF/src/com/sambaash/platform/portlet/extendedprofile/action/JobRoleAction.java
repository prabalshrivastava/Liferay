package com.sambaash.platform.portlet.extendedprofile.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.extendedprofile.util.JobRoleUtil;
import com.sambaash.platform.srv.extendedprofile.model.SPCompetency;
import com.sambaash.platform.srv.extendedprofile.model.SPJobRole;
import com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalServiceUtil;
import com.sambaash.platform.srv.extendedprofile.service.SPJobRoleLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class JobRoleAction
 */
public class JobRoleAction extends MVCPortlet {

private static Log _log = LogFactoryUtil.getLog(JobRoleAction.class);

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences preferences = renderRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<AssetVocabulary> assetVocabularies = null;
		List<SPListType> urlList = null;
		try {
			assetVocabularies = JobRoleUtil.getAssetVocabularies();
		} catch (SystemException e) {
			_log.error(e);
		}

		String jobRole = preferences.getValue("jobRole", "0");
		String jobLevelObject = preferences.getValue("jobLevelObject", "0");
		String competencyJSONObject = preferences.getValue("competencyJSONObject", "0");
		String careerUrlJSONObject = preferences.getValue("careerUrlJSONObject", "0");

		long vocabularyId = Long.parseLong(jobRole);
		List<AssetCategory> assetCategory = null;
		_log.info("vocabularyId do edit " + vocabularyId);
		try {
			assetCategory = JobRoleUtil.getInterestCategories(vocabularyId);
			urlList = SPListTypeLocalServiceUtil.getByKey("jobrole.joblevel.careerpathurl", themeDisplay.getScopeGroupId());
		} catch (SystemException e) {
			_log.error(e);
		}

		for (AssetCategory ac : assetCategory) {
			String jobLevel = "jobLevel_" + ac.getCategoryId();
			String jobLevel1 = "jobLevel_" + ac.getCategoryId();
			jobLevel1 = preferences.getValue(jobLevel, "0");
			renderRequest.setAttribute(jobLevel, jobLevel1);
		}

		renderRequest.setAttribute("jobRole", jobRole);
		renderRequest.setAttribute("jobLevelObject", jobLevelObject);
		renderRequest.setAttribute("assetVocabularies", assetVocabularies);
		renderRequest.setAttribute("assetCategory", assetCategory);
		renderRequest.setAttribute("competencyJSONObject", competencyJSONObject);
		renderRequest.setAttribute("careerUrlJSONObject", careerUrlJSONObject);

		JSONObject assetVocabulariesJSONObject = JSONFactoryUtil.createJSONObject();

		for (AssetVocabulary av : assetVocabularies) {
			assetVocabulariesJSONObject.put(String.valueOf(av.getVocabularyId()), av.getName());
		}

		renderRequest.setAttribute("assetVocabulariesJSONObject", assetVocabulariesJSONObject.toString()); // list of Vocabularies

		JSONObject assetCategoriesJSONObject = JSONFactoryUtil.createJSONObject();

		for (AssetVocabulary av : assetVocabularies) {
			vocabularyId = av.getVocabularyId();
			List<AssetCategory> assetCategories = null;
			try {
				int noOfCategories = AssetCategoryLocalServiceUtil.getAssetCategoriesCount();
				assetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, 0, noOfCategories, null);
			} catch (SystemException e) {
				_log.error(e);
			}

			JSONObject assetCategoryJSONObject = JSONFactoryUtil.createJSONObject();

			for (AssetCategory ac : assetCategories) {
				assetCategoryJSONObject.put(String.valueOf(ac.getCategoryId()), ac.getName());
			}

			assetCategoriesJSONObject.put(String.valueOf(vocabularyId), assetCategoryJSONObject);
		}

		JSONObject urlListJSONObject = JSONFactoryUtil.createJSONObject();

		for (SPListType cl : urlList) {
			urlListJSONObject.put(String.valueOf(cl.getSpListTypeId()), cl.getItemValue());
		}

		renderRequest.setAttribute("assetCategoriesJSONObject", assetCategoriesJSONObject.toString()); // category list for functional group linked with selected vocabulary
		renderRequest.setAttribute("urlListJSONObject", urlListJSONObject.toString()); // list of career path url
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences preferences = renderRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String jobRole = preferences.getValue("jobRole", "0");
		String jobLevelObject = preferences.getValue("jobLevelObject", "0");
		long jobLevelVId = 0;
		String competencyJSONObject = preferences.getValue("competencyJSONObject", "0");
		String careerUrlJSONObject = preferences.getValue("careerUrlJSONObject", "0");
		_log.info("doView " + jobRole);

		long profileUserId = getProfileUserId(themeDisplay);
		long remoteUserId = themeDisplay.getUserId();
		boolean editable = (profileUserId == remoteUserId) ? true : false;

		long vocabularyId = Long.parseLong(jobRole);
		List<AssetCategory> jobRoleCategories = null;
		List<AssetVocabulary> assetVocabularies = null;
		List<SPListType> compList = null;
		SPJobRole jobRoleList = null;
		AssetCategory jobRoleSaved = null;
		AssetCategory jobLevelSaved = null;
		AssetCategory competecySaved = null;
		List<AssetCategory> competecyLevelSaved = new ArrayList<AssetCategory>();
		List<AssetCategory> highlightedCompetecyLevelSaved = new ArrayList<AssetCategory>();
		List<SPCompetency> jobComepetencyList = null;
		JSONObject competecySPListJSONObject = JSONFactoryUtil.createJSONObject();
		JSONObject competecyPublicViewJSONObject = JSONFactoryUtil.createJSONObject();
		SPListType spList = null;
		List<AssetCategory> jobLevelCategories = null;
		SPListType careerPath = null;
		String competencyLevelId = "";
		String competencyLevelValue = "";
		try {
			jobRoleCategories = JobRoleUtil.getInterestCategories(vocabularyId);
			assetVocabularies = JobRoleUtil.getAssetVocabularies();
			List<SPListType> _compList = SPListTypeLocalServiceUtil.getByKey("jobrole.compentency", themeDisplay.getScopeGroupId());
			compList = new ArrayList<SPListType>();
			compList.addAll(_compList);
			Collections.sort(compList,
							new Comparator<SPListType>()
							{
								public int compare(SPListType spListType1, SPListType spListType2)
								{
									return spListType1.getItemKey().compareTo(spListType2.getItemKey());
								}
							}
							);

			jobRoleList = SPJobRoleLocalServiceUtil.findByJobRole(profileUserId);
			jobComepetencyList = SPCompetencyLocalServiceUtil.findByCompetencyListByJobRole(jobRoleList.getSpJobRoleId());

			for (SPCompetency ct : jobComepetencyList) {
				JSONObject competecyLevelJSONObject = JSONFactoryUtil.createJSONObject();
				competecySaved = AssetCategoryLocalServiceUtil.getAssetCategory(ct.getCompetencyId());

				if (ct.isPublicView()) {
					highlightedCompetecyLevelSaved.add(competecySaved);
				}

				competecyLevelSaved.add(competecySaved);
				spList = SPListTypeLocalServiceUtil.fetchSPListType(ct.getCompetencyLevelId());

				if (spList != null) {
					competencyLevelId = String.valueOf(spList.getSpListTypeId());
					competencyLevelValue = spList.getItemValue();
				}else {
					competencyLevelId = "";
					competencyLevelValue = "";
				}

				competecyLevelJSONObject.put(competencyLevelId, competencyLevelValue);
				competecySPListJSONObject.put(String.valueOf(ct.getCompetencyId()), competecyLevelJSONObject);
				competecyPublicViewJSONObject.put(String.valueOf(ct.getCompetencyId()), ct.getPublicView());
			}

			if (jobRoleList != null) {
				jobLevelSaved = AssetCategoryLocalServiceUtil.getAssetCategory(jobRoleList.getJobLevelId());
				jobRoleSaved = AssetCategoryLocalServiceUtil.getAssetCategory(jobRoleList.getFunctionalGroupId());
				jobLevelVId = jobLevelSaved.getVocabularyId();
				careerPath = SPListTypeLocalServiceUtil.fetchSPListType(jobRoleList.getCareerPathId());
			}

			jobLevelCategories = JobRoleUtil.getInterestCategories(jobLevelVId);
		} catch (SystemException e) {
			_log.error(e.getMessage());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}

		com.sambaash.platform.portlet.extendedprofile.json.JSONObject compListJSONObject = new com.sambaash.platform.portlet.extendedprofile.json.JSONObject();

		for (SPListType spListType : compList) {
			try {
				compListJSONObject.put(String.valueOf(spListType.getSpListTypeId()), spListType.getItemValue());
			}catch (JSONException jsonex) {
				_log.error(jsonex.getMessage(), jsonex);
			}
		}

		_log.info("doView careerPath " + careerPath);
		renderRequest.setAttribute("jobRoleCategories", jobRoleCategories);
		renderRequest.setAttribute("assetVocabularies", assetVocabularies);
		renderRequest.setAttribute("jobLevelObject", jobLevelObject);
		renderRequest.setAttribute("competencyJSONObject", competencyJSONObject);
		renderRequest.setAttribute("compListJSONObject", compListJSONObject);
		renderRequest.setAttribute("jobRoleSaved", jobRoleSaved);
		renderRequest.setAttribute("jobLevelSaved", jobLevelSaved);
		renderRequest.setAttribute("competecyLevelSaved", competecyLevelSaved);
		renderRequest.setAttribute("highlightedCompetecyLevelSaved", highlightedCompetecyLevelSaved);
		renderRequest.setAttribute("jobLevelCategories", jobLevelCategories);
		renderRequest.setAttribute("competecySPListJSONObject", competecySPListJSONObject);
		renderRequest.setAttribute("competecyPublicViewJSONObject", competecyPublicViewJSONObject);
		renderRequest.setAttribute("careerUrlJSONObject", careerUrlJSONObject);
		renderRequest.setAttribute("careerPath", careerPath);
		renderRequest.setAttribute("editable", editable);

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		String action = actionRequest.getParameter("action");

		if (Constants.EDIT.equalsIgnoreCase(action)) {

			PortletPreferences preferences = actionRequest.getPreferences();
			String jobRole = actionRequest.getParameter("jobRole"); // vocabularyId of functional group
			_log.info("jobRole " + jobRole);
			List<AssetCategory> assetCategory = null;

			try {
				assetCategory = JobRoleUtil.getInterestCategories(Long.parseLong(jobRole));
			} catch (NumberFormatException e) {
				_log.error(e.getMessage());
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}

			JSONObject jobLevelJSONObject = JSONFactoryUtil.createJSONObject();
			JSONObject competencyJSONObject = JSONFactoryUtil.createJSONObject();
			long cId = 0;
			long vId = 0;
			List<AssetCategory> jobLevelCategory = null;
			long jobLevelVocabularyId = 0;
			JSONObject careerUrlJSONObject = JSONFactoryUtil.createJSONObject();

			for (AssetCategory ac : assetCategory) {
				String jobLevel1 = "jobLevel_" + ac.getCategoryId();
				jobLevel1 = actionRequest.getParameter(jobLevel1);

				if (jobLevel1 != null) {
					vId = Long.parseLong(jobLevel1);

					cId = ac.getCategoryId();
					AssetVocabulary assetVocabulary = null;
					JSONObject assetVocabularyJSONObject = JSONFactoryUtil.createJSONObject();
					try {
						assetVocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabulary(vId);
						jobLevelVocabularyId = assetVocabulary.getVocabularyId();
						jobLevelCategory = JobRoleUtil.getInterestCategories(jobLevelVocabularyId);
						assetVocabularyJSONObject.put(String.valueOf(assetVocabulary.getVocabularyId()), ac.getName());
						_log.info("jobLevelCategory " + jobLevelCategory);
					} catch (SystemException e) {
						_log.error(e.getMessage());
					} catch (PortalException e) {
						_log.error(e.getMessage());
					}

					JSONObject assetJSONObject = JSONFactoryUtil.createJSONObject();
					JSONObject careerJSONObject = JSONFactoryUtil.createJSONObject();

					jobLevelJSONObject.put(String.valueOf(cId), assetVocabularyJSONObject);

					if (jobLevelCategory != null) {
						for (AssetCategory act : jobLevelCategory) {
							String competency = "competency_" + act.getCategoryId();
							competency = actionRequest.getParameter(competency);
							assetJSONObject.put(String.valueOf(act.getCategoryId()), competency);
							String url = "url_" + act.getCategoryId();
							url = actionRequest.getParameter(url);
							careerJSONObject.put(String.valueOf(act.getCategoryId()), url);
						}
					}

					competencyJSONObject.put(String.valueOf(cId), assetJSONObject);
					careerUrlJSONObject.put(String.valueOf(cId), careerJSONObject);
				}
			}

			_log.info("careerUrlJSONObject process action " + careerUrlJSONObject);
			preferences.setValue("jobRole", jobRole); //vocabularyId of functional group
			preferences.setValue("jobLevelObject", jobLevelJSONObject.toString()); // vocabulary list for joblevel linked with selected functional group
			preferences.setValue("competencyJSONObject", competencyJSONObject.toString());// competency list saved in preferences - linked with functional group & joblevel categories
			preferences.setValue("careerUrlJSONObject", careerUrlJSONObject.toString());// career path url saved in preferences - linked with functional group & joblevel categories
			preferences.store();

			actionResponse.setPortletMode(PortletMode.VIEW);
		}

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		super.serveResource(resourceRequest, resourceResponse);

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String type = resourceRequest.getParameter("type");
		String jobLevelVocabularyId = resourceRequest.getParameter("jobLevelVocabularyId");
		String competencyVocabularyId = resourceRequest.getParameter("competencyVocabularyId");
		String jobRoleId = resourceRequest.getParameter("jobRoleId");
		String jobLevelId = resourceRequest.getParameter("jobLevelId");
		String competencyId = resourceRequest.getParameter("competencyId");
		String careerUrlId = resourceRequest.getParameter("careerUrlId");
		String competencyLevelId = resourceRequest.getParameter("competencyLevelId");
		String compPubliclyView = resourceRequest.getParameter("compPubliclyView");
		String careerPath = resourceRequest.getParameter("careerPath");

		long userId = themeDisplay.getUserId();

		if (type.equals("populateJobLevels")) {
			JobRoleUtil.populateJobLevelValues(resourceResponse, jobLevelVocabularyId);

		} else if (type.equals("populateCompetencies")) {

			JobRoleUtil.populateCompetencyValues(competencyVocabularyId, resourceResponse);

		} else if (type.equals("populateCareerPathUrl")) {

			JobRoleUtil.populateCareerPathValues(careerUrlId, resourceResponse);

		} else if (type.equals("saveJobRoleInfo")) {

			String jsonResponse = null;
			try {
				jsonResponse = JobRoleUtil.saveJobRoleInformation(jobRoleId, jobLevelId, competencyId, competencyLevelId, compPubliclyView, userId, careerPath,
																resourceResponse);
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}

			resourceResponse.getWriter().append(jsonResponse.toString());
			resourceRequest.setAttribute("jobRoleId", jobRoleId);
		}
	}

	private long getProfileUserId(ThemeDisplay themeDisplay) {
		long remoteUserId = themeDisplay.getUserId();
	String friendlyURL = themeDisplay.getURLCurrent();
	long companyId = themeDisplay.getCompanyId();
	long profileUserId = SambaashUtil.getUserIdByScreenName(companyId, friendlyURL);

	if (profileUserId == 0) {
	profileUserId = remoteUserId;
	}

	return profileUserId;
	}
}