package com.sambaash.platform.portlet.extendedprofile.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.extendedprofile.wrapper.CompetencyLevelWrapper;
import com.sambaash.platform.portlet.extendedprofile.wrapper.OtherCompetenciesWrapper;
import com.sambaash.platform.srv.extendedprofile.NoSuchSPCompetencyException;
import com.sambaash.platform.srv.extendedprofile.model.SPCompetency;
import com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class CompetencyAction
 */
public class CompetencyAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			List<AssetVocabulary> assetVocabularies = getAssetVocabularies(themeDisplay);
			JSONObject vocabulariesJSONObject = JSONFactoryUtil.createJSONObject();
			JSONObject vocabulariesOnlyJSONObject = JSONFactoryUtil.createJSONObject();

			for (AssetVocabulary av : assetVocabularies) {
				long vocabularyId = av.getVocabularyId();
				String vocabularyName = av.getName();
				vocabulariesOnlyJSONObject.put(String.valueOf(vocabularyId), vocabularyName);
				List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, -1, -1, null);
				JSONObject categoryJSONObject = JSONFactoryUtil.createJSONObject();

				for (AssetCategory ac : assetCategories) {
					categoryJSONObject.put(String.valueOf(ac.getCategoryId()), ac.getName().trim());
				}

				vocabulariesJSONObject.put(String.valueOf(av.getVocabularyId()), categoryJSONObject);
			}

			PortletPreferences preferences = renderRequest.getPreferences();
			String savedLevelOneId = preferences.getValue("savedLevelOneId", StringPool.BLANK);
			String savedLevelTwoAndLevelThreeParams = preferences.getValue("savedLevelTwoAndLevelThreeParams", StringPool.BLANK);

			String[] savedLevelTwoAndLevelThreeParamsArray = StringUtil.split(savedLevelTwoAndLevelThreeParams, StringPool.COMMA);
			JSONObject savedLevelTwoIdAndLevelThreeIdJSONObject = JSONFactoryUtil.createJSONObject();

			for (String s : savedLevelTwoAndLevelThreeParamsArray) {
				String[] savedLevelTwoIdAndLevelThreeId = StringUtil.split(s, StringPool.DASH);
				savedLevelTwoIdAndLevelThreeIdJSONObject.put(savedLevelTwoIdAndLevelThreeId[0], savedLevelTwoIdAndLevelThreeId[1]);
			}

			renderRequest.setAttribute("savedLevelOneId", savedLevelOneId);
			renderRequest.setAttribute("savedLevelTwoIdAndLevelThreeIdJSONObject", savedLevelTwoIdAndLevelThreeIdJSONObject.toString());

			renderRequest.setAttribute("assetVocabularies", assetVocabularies);
			renderRequest.setAttribute("vocabulariesJSONObject", vocabulariesJSONObject.toString());
			renderRequest.setAttribute("vocabulariesOnlyJSONObject", vocabulariesOnlyJSONObject.toString());

		}catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long profileUserId = getProfileUserId(themeDisplay);
		long remoteUserId = themeDisplay.getUserId();
		boolean editable = (profileUserId == remoteUserId) ? true : false;
		renderRequest.setAttribute("editable", editable);
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String savedLevelOneId = preferences.getValue("savedLevelOneId", StringPool.BLANK);
			String savedLevelTwoAndLevelThreeParams = preferences.getValue("savedLevelTwoAndLevelThreeParams", StringPool.BLANK);

			String[] savedLevelTwoAndLevelThreeParamsArray = StringUtil.split(savedLevelTwoAndLevelThreeParams, StringPool.COMMA);
			JSONObject savedLevelTwoIdAndLevelThreeIdJSONObject = JSONFactoryUtil.createJSONObject();

			for (String s : savedLevelTwoAndLevelThreeParamsArray) {
				String[] levelTwoIdAndLevelThreeId = StringUtil.split(s, StringPool.DASH);
				savedLevelTwoIdAndLevelThreeIdJSONObject.put(levelTwoIdAndLevelThreeId[0], levelTwoIdAndLevelThreeId[1]);
			}

			List<AssetVocabulary> assetVocabularies = getAssetVocabularies(themeDisplay);
			JSONObject vocabulariesJSONObject = JSONFactoryUtil.createJSONObject();

			for (AssetVocabulary av : assetVocabularies) {
				long vocabularyId = av.getVocabularyId();
				List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, -1, -1, null);
				JSONObject categoryJSONObject = JSONFactoryUtil.createJSONObject();

				for (AssetCategory ac : assetCategories) {
					categoryJSONObject.put(String.valueOf(ac.getCategoryId()), ac.getName().trim());
				}

				vocabulariesJSONObject.put(String.valueOf(av.getVocabularyId()), categoryJSONObject);
			}

			long vocabularyId = 0;
			try {
				vocabularyId = Long.valueOf(savedLevelOneId);
			}catch (NumberFormatException nfe) {

				// do nothing

			}

			List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, -1, -1, null);

			//			List<SPListType> spListTypes = SPListTypeLocalServiceUtil.getByKey("jobrole.compentency", themeDisplay.getScopeGroupId());
			List<SPListType> _spListTypes = SPListTypeLocalServiceUtil.getByKey("jobrole.compentency", themeDisplay.getScopeGroupId());
			List<SPListType> spListTypes = new ArrayList<SPListType>();
			spListTypes.addAll(_spListTypes);
			Collections.sort(spListTypes,
							new Comparator<SPListType>()
							{
								public int compare(SPListType spListType1, SPListType spListType2)
								{
									return spListType1.getItemKey().compareTo(spListType2.getItemKey());
								}
							}
							);

			com.sambaash.platform.portlet.extendedprofile.json.JSONObject levelJSONObject = new com.sambaash.platform.portlet.extendedprofile.json.JSONObject();

			for (SPListType spListType : spListTypes) {
				levelJSONObject.put(String.valueOf(spListType.getSpListTypeId()), spListType.getItemValue());
			}

			renderRequest.setAttribute("savedLevelTwoIdAndLevelThreeIdJSONObject", savedLevelTwoIdAndLevelThreeIdJSONObject.toString());
			renderRequest.setAttribute("vocabulariesJSONObject", vocabulariesJSONObject.toString());
			renderRequest.setAttribute("assetCategories", assetCategories);
			renderRequest.setAttribute("levelJSONObject", levelJSONObject.toString());

			List<SPCompetency> competencies = SPCompetencyLocalServiceUtil.findByCompetencyList(profileUserId);
			List<OtherCompetenciesWrapper> otherCompetenciesWrappers = new ArrayList<OtherCompetenciesWrapper>();

			for (SPCompetency competency : competencies) {
				long competencyId = competency.getCompetencyId();
				long categoryId = competency.getCategoryId();
				long competencyLevelId = competency.getCompetencyLevelId();
				AssetCategory category = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);
				String categoryName = category.getName();
				SPListType spListType = SPListTypeLocalServiceUtil.getSPListType(competencyLevelId);
				long levelId = spListType.getSpListTypeId();
				String levelName = spListType.getItemValue();
				AssetCategory competencyCategory = AssetCategoryLocalServiceUtil.getAssetCategory(competencyId);
				String competencyName = competencyCategory.getName();

				CompetencyLevelWrapper competencyLevelWrapper = new CompetencyLevelWrapper();
				competencyLevelWrapper.setCompetencyId(competencyId);
				competencyLevelWrapper.setCompetencyName(competencyName);
				competencyLevelWrapper.setLevelId(levelId);
				competencyLevelWrapper.setLevelName(levelName);

				boolean existing = false;

				for (OtherCompetenciesWrapper otherCompetenciesWrapper : otherCompetenciesWrappers) {
					if (otherCompetenciesWrapper.getCategoryId() == categoryId) {
						existing = true;
						otherCompetenciesWrapper.getCompetencyLevelWrappers().add(competencyLevelWrapper);
					}
				}

				if (!existing) {
					OtherCompetenciesWrapper otherCompetenciesWrapper = new OtherCompetenciesWrapper();
					otherCompetenciesWrapper.setCategoryId(categoryId);
					otherCompetenciesWrapper.setCategoryName(categoryName);
					List<CompetencyLevelWrapper> competencyLevelWrappers = new ArrayList<CompetencyLevelWrapper>();
					competencyLevelWrappers.add(competencyLevelWrapper);
					otherCompetenciesWrapper.setCompetencyLevelWrappers(competencyLevelWrappers);
					otherCompetenciesWrappers.add(otherCompetenciesWrapper);
				}
			}

			String quotation = "&quot;";

			for (OtherCompetenciesWrapper otherCompetenciesWrapper : otherCompetenciesWrappers) {
				StringBuffer competenciesJSONDataSB = new StringBuffer();
				competenciesJSONDataSB.append(StringPool.OPEN_CURLY_BRACE);
				long categoryId = otherCompetenciesWrapper.getCategoryId();
				competenciesJSONDataSB.append(quotation);
				competenciesJSONDataSB.append("categoryId");
				competenciesJSONDataSB.append(quotation);
				competenciesJSONDataSB.append(StringPool.COLON);
				competenciesJSONDataSB.append(quotation);
				competenciesJSONDataSB.append(categoryId);
				competenciesJSONDataSB.append(quotation);
				competenciesJSONDataSB.append(StringPool.COMMA);
				competenciesJSONDataSB.append(quotation);
				competenciesJSONDataSB.append("competencies");
				competenciesJSONDataSB.append(quotation);
				competenciesJSONDataSB.append(StringPool.COLON);
				competenciesJSONDataSB.append(StringPool.OPEN_CURLY_BRACE);
				List<CompetencyLevelWrapper> competencyLevelWrappers = otherCompetenciesWrapper.getCompetencyLevelWrappers();
				int i = 0;

				for (CompetencyLevelWrapper competencyLevelWrapper : competencyLevelWrappers) {
					if (i > 0) {
						competenciesJSONDataSB.append(StringPool.COMMA);
					}

					competenciesJSONDataSB.append(quotation);
					competenciesJSONDataSB.append(competencyLevelWrapper.getCompetencyId());
					competenciesJSONDataSB.append(quotation);
					competenciesJSONDataSB.append(StringPool.COLON);
					competenciesJSONDataSB.append(quotation);
					competenciesJSONDataSB.append(competencyLevelWrapper.getLevelId());
					competenciesJSONDataSB.append(quotation);
					i++;
				}

				competenciesJSONDataSB.append(StringPool.CLOSE_CURLY_BRACE);
				competenciesJSONDataSB.append(StringPool.CLOSE_CURLY_BRACE);
				otherCompetenciesWrapper.setCompetenciesJSONData(competenciesJSONDataSB.toString());
			}

			renderRequest.setAttribute("otherCompetenciesWrappers", otherCompetenciesWrappers);

		}catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		try {
			SocialProfile socialProfile = null;
			try {
				socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(userId);
			}catch (NoSuchSocialProfileException nsspe) {

				// do nothing

			}

			Indexer indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class.getName());

			String action = resourceRequest.getParameter("action");

			if (Constants.EDIT.equalsIgnoreCase(action)) {
				String levelOneId = resourceRequest.getParameter("levelOneId");
				String levelTwoAndLevelThreeParams = resourceRequest.getParameter("levelTwoAndLevelThreeParams");


				PortletPreferences preferences = resourceRequest.getPreferences();
				preferences.setValue("savedLevelOneId", levelOneId);
				preferences.setValue("savedLevelTwoAndLevelThreeParams", levelTwoAndLevelThreeParams);
				preferences.store();

			}else if ("saveOne".equalsIgnoreCase(action)) {
				boolean edit = true;
				StringBuffer sb = new StringBuffer();
				String categoryIdStr = resourceRequest.getParameter("categoryId");
				String competencyAndLevelParams = resourceRequest.getParameter("competencyAndLevelParams");

				if (Validator.isNotNull(categoryIdStr)) {
					String[] competencyIdAndLevelIds = StringUtil.split(competencyAndLevelParams, StringPool.COMMA);
					long categoryId = 0;
					try {
						categoryId = Long.valueOf(categoryIdStr);
					}catch (NumberFormatException nfe) {
					}

					if (categoryId > 0) {
						List<SPCompetency> existingCompetencies = SPCompetencyLocalServiceUtil.findByCategoryId(userId, categoryId);

						List<SPCompetency> _existingCompetencies = new ArrayList<SPCompetency>();
						_existingCompetencies.addAll(existingCompetencies);

						if (Validator.isNotNull(competencyAndLevelParams)) {
							AssetCategory category = AssetCategoryLocalServiceUtil.getAssetCategory(categoryId);
							String categoryName = category.getName();
							sb.append("<div class=\"maindivpersonalInfo\"><div class=\"content-title\">Category:<div class=\"seperatedline\"></div></div><div class=\"left-align-content basicinfo-textedit\">" + categoryName + "</div></div>");
							sb.append("<div class=\"maindivpersonalInfo\"><div class=\"content-title\">Competencies:<div class=\"seperatedline\"></div></div>");
							sb.append("<div class=\"left-align-content basicinfo-textedit\">");

							String quotation = "&quot;";
							StringBuffer competenciesJSONDataSB = new StringBuffer();
							competenciesJSONDataSB.append(StringPool.OPEN_CURLY_BRACE);
							competenciesJSONDataSB.append(quotation);
							competenciesJSONDataSB.append("categoryId");
							competenciesJSONDataSB.append(quotation);
							competenciesJSONDataSB.append(StringPool.COLON);
							competenciesJSONDataSB.append(quotation);
							competenciesJSONDataSB.append(categoryId);
							competenciesJSONDataSB.append(quotation);
							competenciesJSONDataSB.append(StringPool.COMMA);
							competenciesJSONDataSB.append(quotation);
							competenciesJSONDataSB.append("competencies");
							competenciesJSONDataSB.append(quotation);
							competenciesJSONDataSB.append(StringPool.COLON);
							competenciesJSONDataSB.append(StringPool.OPEN_CURLY_BRACE);

							sb.append("<table style=\"width: 100%;\">");

							int i = 0;

							for (String competencyIdAndLevelId : competencyIdAndLevelIds) {
								if (i > 0) {
									competenciesJSONDataSB.append(StringPool.COMMA);
								}

								i++;
								String[] competencyIdAndLevelIdArray = StringUtil.split(competencyIdAndLevelId, StringPool.DASH);
								long competencyId = 0;
								long levelId = 0;

								if (competencyIdAndLevelIdArray.length == 2) {
									try {
										competencyId = Long.valueOf(competencyIdAndLevelIdArray[0]);
									}catch (NumberFormatException nfe) {
									}

									try {
										levelId = Long.valueOf(competencyIdAndLevelIdArray[1]);
									}catch (NumberFormatException nfe) {
									}
								}

								competenciesJSONDataSB.append(quotation);
								competenciesJSONDataSB.append(competencyId);
								competenciesJSONDataSB.append(quotation);
								competenciesJSONDataSB.append(StringPool.COLON);
								competenciesJSONDataSB.append(quotation);
								competenciesJSONDataSB.append(levelId);
								competenciesJSONDataSB.append(quotation);

								if (competencyId > 0 && levelId > 0) {
									SPListType spListType = SPListTypeLocalServiceUtil.getSPListType(levelId);
									String levelName = spListType.getItemValue();
									AssetCategory competencyCategory = AssetCategoryLocalServiceUtil.getAssetCategory(competencyId);
									String competencyName = competencyCategory.getName();

									SPCompetency competency = null;
									Date now = new Date();
									try {
										competency = SPCompetencyLocalServiceUtil.findByCategoryIdAndCompetencyId(themeDisplay.getUserId(), categoryId, competencyId);
										_existingCompetencies.remove(competency);
									}catch (NoSuchSPCompetencyException nsce) {
										edit = false;
										competency = SPCompetencyLocalServiceUtil.createSPCompetency(CounterLocalServiceUtil.increment());
										competency.setCreateDate(now);
									}

									competency.setBelongsToJobRole(0);
									competency.setCompanyId(themeDisplay.getCompanyId());
									competency.setCategoryId(categoryId);
									competency.setCompetencyId(competencyId);
									competency.setCompetencyLevelId(levelId);
									competency.setUserId(themeDisplay.getUserId());
									competency.setModifiedDate(now);
									SPCompetencyLocalServiceUtil.updateSPCompetency(competency);

									sb.append("<tr><td style=\"width: 70%;\"><p>");
									sb.append(competencyName);
									sb.append("</p></td>");
									sb.append("<td style=\"width: 30%;\">");
									sb.append(levelName);
									sb.append("</td>");
									sb.append("</tr>");
								}
							}

							sb.append("</table>");
							sb.append("<br />");
							sb.append("</div>");
							sb.append("</div>");
							sb.append("</div>");

							competenciesJSONDataSB.append(StringPool.CLOSE_CURLY_BRACE);
							competenciesJSONDataSB.append(StringPool.CLOSE_CURLY_BRACE);

							String tempStr = sb.toString();
							tempStr = "<div><div class=\"workhistory_editAlignExt\"><a href=\"#\" onclick=\"javascript:editOneOnClick(event)\" title=\"edit\" data-competencies=\"" + competenciesJSONDataSB.toString() + "\" class=\"userprofile-edit-linkExt\">&nbsp;</a> <a href=\"#\" onclick=\"javascript:deleteOneOnClick(event)\" class=\"userprofile-delete-link\" title=\"delete\">&nbsp;</a></div>" + tempStr;
							tempStr = "<div data-competency-dom-id=\"other-competencies-container\" data-category-id=\"" + categoryId + "\">" + tempStr;
							sb = new StringBuffer(tempStr);
						}

						for (SPCompetency competency : _existingCompetencies) {
							SPCompetencyLocalServiceUtil.deleteSPCompetency(competency);
						}

						if (socialProfile != null) {
							indexer.reindex(socialProfile);
						}
					}

					resourceResponse.setContentType("application/json");
					resourceResponse.setCharacterEncoding("utf-8");

					JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
					dataJSONObject.put("categoryId", categoryId);
					dataJSONObject.put("html", sb.toString());
					dataJSONObject.put("edit", edit);

					resourceResponse.getWriter().write(dataJSONObject.toString());
				}

			}else if ("deleteOne".equalsIgnoreCase(action)) {
				String categoryIdStr = resourceRequest.getParameter("categoryId");

				if (Validator.isNotNull(categoryIdStr)) {
					long categoryId = 0;
					try {
						categoryId = Long.valueOf(categoryIdStr);
					}catch (NumberFormatException nfe) {
					}

					List<SPCompetency> competencies = SPCompetencyLocalServiceUtil.findByCategoryId(themeDisplay.getUserId(), categoryId);

					for (SPCompetency competency : competencies) {
						SPCompetencyLocalServiceUtil.deleteSPCompetency(competency);
					}

					if (socialProfile != null) {
						indexer.reindex(socialProfile);
					}

					resourceResponse.setContentType("application/json");
					resourceResponse.setCharacterEncoding("utf-8");

					JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();
					dataJSONObject.put("categoryId", categoryId);

					resourceResponse.getWriter().write(dataJSONObject.toString());
				}

			}
		}catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

	private List<AssetVocabulary> getAssetVocabularies(ThemeDisplay themeDisplay) throws PortalException, SystemException {
		long scopeGroupId = themeDisplay.getScopeGroupId();
		List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();
		Group group = themeDisplay.getScopeGroup();

		if (group.isLayout()) {
			vocabularies.addAll(AssetVocabularyLocalServiceUtil.getGroupVocabularies(group.getParentGroupId(), false));
		}
		else {
			vocabularies.addAll(AssetVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId, false));
		}

		if (scopeGroupId != themeDisplay.getCompanyGroupId()) {
			vocabularies.addAll(AssetVocabularyLocalServiceUtil.getGroupVocabularies(themeDisplay.getCompanyGroupId(), false));
		}

		return vocabularies;
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

	private static Log _log = LogFactoryUtil.getLog(CompetencyAction.class);

}