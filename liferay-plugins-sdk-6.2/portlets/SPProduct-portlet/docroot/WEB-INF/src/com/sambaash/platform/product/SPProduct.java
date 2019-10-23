package com.sambaash.platform.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.product.helper.ProductSearchHelper;
import com.sambaash.platform.product.util.CopyCourseUtil;
import com.sambaash.platform.product.util.CopyModuleUtil;
import com.sambaash.platform.product.util.EditUtil;
import com.sambaash.platform.product.util.FileUtil;
import com.sambaash.platform.product.util.ProductConfigUtil;
import com.sambaash.platform.product.util.ProductDetailUtil;
import com.sambaash.platform.product.util.SPCareerUtil;
import com.sambaash.platform.product.util.SPCertificateUtil;
import com.sambaash.platform.product.util.SPCompetencyUnitsUtil;
import com.sambaash.platform.product.util.SPCourseUtil;
import com.sambaash.platform.product.util.SPFeeDetailUtil;
import com.sambaash.platform.product.util.SPFeeTypeUtil;
import com.sambaash.platform.product.util.SPFrameworkUtil;
import com.sambaash.platform.product.util.SPFundingUtil;
import com.sambaash.platform.product.util.SPGraduationCriteriaUtil;
import com.sambaash.platform.product.util.SPLearningUtil;
import com.sambaash.platform.product.util.SPMiscFeeUtil;
import com.sambaash.platform.product.util.SPModuleUtil;
import com.sambaash.platform.product.util.SPOutcomeUtil;
import com.sambaash.platform.product.util.SPOutlineUtil;
import com.sambaash.platform.product.util.SPPersonnaUtil;
import com.sambaash.platform.product.util.SPProductConstants;
import com.sambaash.platform.product.util.SPProductUtil;
import com.sambaash.platform.product.util.SPProgessionPathUtil;
import com.sambaash.platform.product.util.Status;
import com.sambaash.platform.product.util.VocabularyUtil;
import com.sambaash.platform.srv.model.Certificate;
import com.sambaash.platform.srv.model.CompetencyUnit;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.model.Module;
import com.sambaash.platform.srv.model.Outcome;
import com.sambaash.platform.srv.model.Outline;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.service.CertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.FrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.OutcomeLocalServiceUtil;
import com.sambaash.platform.srv.service.OutlineLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.service.persistence.ProductUtil;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class Product
 */
public class SPProduct extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(SPProduct.class);
	private static final long CLASS_NAME_ID = ClassNameLocalServiceUtil.getClassNameId(Product.class);

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_log.debug("doview");
		_log.info("inside view.....");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		
		String label = getLabel(portletConfig, Locale.CHINA,themeDisplay, "label.product.same.page.registration");
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("locale", Locale.CHINA);
		super.doView(renderRequest, renderResponse);
	}

	
	public static String getLabel(PortletConfig portletConfig,Locale locale, ThemeDisplay themeDisplay,
			String key) {
		
		String communityName = SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());

		String communityLabelKey = communityName + StringPool.PERIOD + key;
		
		String label = LanguageUtil.get(portletConfig, locale, communityLabelKey);

		if (label.equalsIgnoreCase(communityLabelKey)) {
			label = LanguageUtil.get(portletConfig, locale, key);
		}

		return label;

	}
	
	
/*	public static String getParameter(String key, long groupId) {

		String value = "";
		try {
			SPParameter parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId, key);
			value = parameter.getValue();
		} catch (NoSuchSPParameterException e) {
			_log.info("No such spparameter exist with key: " + key + " groupId: " + groupId);
		} catch (Exception e) {
			_log.error("Exception getting SPParameter ==" + e.getMessage());
		}
		return value;
	}*/

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		try {

			String action = renderRequest.getParameter("action");
			String classpk = renderRequest.getParameter("productId");
			long productId = 0;
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Locale[] availaleLocales = LanguageUtil.getAvailableLocales(themeDisplay.getScopeGroupId());
			
			if (Validator.isNotNull(renderRequest.getParameter("jspPage")) && Validator.isNotNull(classpk)){
				if (renderRequest.getParameter("jspPage").equalsIgnoreCase("/html/detail/view.jsp") && GetterUtil.getLong(classpk) > 0){
	 				ClassName cn = ClassNameLocalServiceUtil.getClassName(Product.class.getName());
					renderRequest.setAttribute("SPActivityHub_ClassPK_"+ themeDisplay.getPortletDisplay().getId(), classpk);
					renderRequest.setAttribute("SPActivityHub_ClassName_"+ themeDisplay.getPortletDisplay().getId(), Product.class.getName());
					renderRequest.setAttribute("SPActivityHub_ClassNameId_"+ themeDisplay.getPortletDisplay().getId(), cn.getClassNameId());
					renderRequest.setAttribute("SPActivityHub_DispalyParam_"+ themeDisplay.getPortletDisplay().getId(), "productDetailView");	
	 			}
 			}
			
			if(Validator.isNotNull(classpk)){
				productId = Long.parseLong(classpk);
			}
			
			boolean hasInventory = false;
			JSONArray inventoryDetailListJSON = null;

//			for(Locale locales : availaleLocales){
//				_log.error("locales displayLnag " + locales.getDisplayLanguage());
//				_log.error("Lang yag " + locales.getLanguage());
//			}
			_log.debug("SPProductCreate render action: " + action);
			
			if ("copyCourse".equalsIgnoreCase(action)) {
				CopyCourseUtil.copyCourse(renderRequest);
			}

			if ("copyModule".equalsIgnoreCase(action)) {
				CopyModuleUtil.copyModule(renderRequest);
			}
			
			if ("productInventory".equalsIgnoreCase(action)) {
				inventoryDetailListJSON = SPProductUtil.getProductInventoryDetail(CLASS_NAME_ID,productId);
				Product product = ProductLocalServiceUtil.fetchProduct(productId);
				renderRequest.setAttribute("productId", productId);
				hasInventory = product.isHasInventory();
			}

			VocabularyUtil vocUtil = new VocabularyUtil();

			AssetVocabulary competencyVocabulary = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.COMPETENCY_LEVEL);

			List<AssetCategory> competencyLevelList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(competencyVocabulary.getVocabularyId(), -1, -1, null);

			AssetVocabulary jobFamilyVocabulary = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.JOB_FAMILY);
			List<AssetCategory> jobFamilyList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(jobFamilyVocabulary.getVocabularyId(), -1, -1, null);

			AssetVocabulary locationVocabulary = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.LOCATION);
			List<AssetCategory> countryList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(locationVocabulary.getVocabularyId(), -1, -1, null);
			
			AssetVocabulary courseDeveloperVocabulary = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.COURSE_DEVELOPER);
			List<AssetCategory> courseDeveloperList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(courseDeveloperVocabulary.getVocabularyId(), -1, -1, null);

			AssetVocabulary awardVocabulary = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.AWARD);
			List<AssetCategory> awardList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(awardVocabulary.getVocabularyId(), -1, -1, null);

			AssetVocabulary outcomeTypeVocabulary = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.OUTCOME_TYPE);

			AssetVocabulary certificateTypeVocabulary = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.CERTIFICATE_TYPE);
			List<AssetCategory> certificateTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(certificateTypeVocabulary.getVocabularyId(), -1, -1, null);

			AssetVocabulary certificateLevelVocabulary = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.CERTIFICATE_LEVEL);
			List<AssetCategory> certificateLevelList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(certificateLevelVocabulary.getVocabularyId(), -1, -1, null);

			AssetVocabulary moduleTypeVocabulary = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.MODULE_TYPE);
			List<AssetCategory> moduleTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(moduleTypeVocabulary.getVocabularyId(), -1, -1, null);

			AssetVocabulary outlineTypeVocabulary = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.OUTLINE_TYPE);
			List<AssetCategory> outlineTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(outlineTypeVocabulary.getVocabularyId(), -1, -1, null);

			AssetVocabulary sessionTypeVocabulary = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.SESSION_TYPE);
			List<AssetCategory> sessionTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(sessionTypeVocabulary.getVocabularyId(), -1, -1, null);

			AssetVocabulary courseTypeVocabulary = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.COURSE_TYPE);
			List<AssetCategory> courseTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(courseTypeVocabulary.getVocabularyId(), -1, -1, null);

			AssetVocabulary criteriaType = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.CRITERIA_TYPE);
			List<AssetCategory> criteriaTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(criteriaType.getVocabularyId(), -1, -1, null);

			AssetVocabulary criteriaLevel = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.CRITERIA_LEVEL);
			List<AssetCategory> criteriaLevelList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(criteriaLevel.getVocabularyId(), -1, -1, null);

			AssetVocabulary sponsoredBy = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.SPONSORED_BY);
			List<AssetCategory> sponsoredByList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(sponsoredBy.getVocabularyId(), -1, -1, null);
			String selfSponsorId = "0";
			for (AssetCategory asstCatg : sponsoredByList) {
				if (asstCatg.getName().equalsIgnoreCase("Self")) {
					selfSponsorId = String.valueOf(asstCatg.getCategoryId());
				}
			}

			AssetVocabulary residentialStatus = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.RESIDENTIAL_STATUS);
			List<AssetCategory> residentialStatusList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(residentialStatus.getVocabularyId(), -1, -1, null);

			AssetVocabulary careerLevel = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.CAREER_LEVEL);
			List<AssetCategory> careerLevelList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(careerLevel.getVocabularyId(), -1, -1, null);

			AssetVocabulary progressionType = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.PROGRESSION_TYPE);
			List<AssetCategory> progressionTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(progressionType.getVocabularyId(), -1, -1, null);

			AssetVocabulary progressionCategory = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.PROGRESSION_CATEGORY);
			List<AssetCategory> progressionCategoryList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(progressionCategory.getVocabularyId(), -1, -1, null);

			AssetVocabulary courseLevelVoc = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.COURSE_LEVEL);
			List<AssetCategory> courseLevelList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(courseLevelVoc.getVocabularyId(), -1, -1, null);

			List<FeeType> feeTypeList = FeeTypeLocalServiceUtil.findByMisc(false);

			List<FeeType> miscFeeTypeList = FeeTypeLocalServiceUtil.findByMisc(true);
			AssetVocabulary miscWhenPayable = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.WHEN_PAYABLE);
			List<AssetCategory> miscWhenPayableList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(miscWhenPayable.getVocabularyId(), -1, -1, null);

			AssetVocabulary personaType = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.PERSONA_TYPE);
			List<AssetCategory> personaTypeList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(personaType.getVocabularyId(), -1, -1, null);

			List<AssetCategory> specializationList;
			try {
				specializationList = vocUtil.getSpecializationCategories(renderRequest);
				loadModuleSpecialization(specializationList, renderRequest);
			} catch (Exception e) {
				specializationList = new ArrayList<AssetCategory>();
				renderRequest.setAttribute("specializationListJSON", "0");
				renderRequest.setAttribute("selectedSpecializationListJSON", "0");
				_log.error(e);
			}

			List<AssetCategory> personaCatgList;
			try {
				personaCatgList = vocUtil.getPersonaCategories(renderRequest);
				loadCoursePersona(personaCatgList, renderRequest);
			} catch (Exception e) {
				personaCatgList = new ArrayList<AssetCategory>();
				renderRequest.setAttribute("personaListJSON", "0");
				renderRequest.setAttribute("selectedPersonaListJSON", "0");
				_log.error(e);
			}

			AssetVocabulary skills = vocUtil.getVocabulary(renderRequest, renderResponse,
					SPProductConstants.OUTLINE_TYPE_SKILLS);
			List<AssetCategory> skillsList = AssetCategoryLocalServiceUtil
					.getVocabularyCategories(skills.getVocabularyId(), -1, -1, null);
			loadskillsList(skillsList, renderRequest);

			if (outcomeTypeVocabulary != null) {
				List<AssetCategory> outcomeTypeList = AssetCategoryLocalServiceUtil
						.getVocabularyCategories(outcomeTypeVocabulary.getVocabularyId(), -1, -1, null);

				renderRequest.setAttribute("outcomeTypeList", outcomeTypeList);
			}

			List<Framework> frameworkList = FrameworkLocalServiceUtil.getFrameworks(-1, -1);
			List<CompetencyUnit> competencyUnitCodeList = CompetencyUnitLocalServiceUtil.getCompetencyUnits(-1, -1);
			loadModuleCompetencyUnits(competencyUnitCodeList, renderRequest);
			List<Outcome> outcomeList = OutcomeLocalServiceUtil.getOutcomes(-1, -1);

			List<Outline> outlineList = OutlineLocalServiceUtil.getOutlines(-1, -1);
			Map<Long, List<String>> outlineDetailsList = SPOutlineUtil.getOutlineMap(outlineList);

			List<Certificate> certificateList = CertificateLocalServiceUtil.getCertificates(-1, -1);
			loadCertifcatesList(certificateList, renderRequest);
			List<Module> moduleList = ModuleLocalServiceUtil.getModules(-1, -1);
			loadModuleList(moduleList, renderRequest);

			List<Course> courseList = CourseLocalServiceUtil.getCourses(-1, -1);
			String productTemplates = StringPool.BLANK;
			try {
				SPParameter paraConfigur = SPParameterLocalServiceUtil
						.findBySPParameterGroupIdAndName(themeDisplay.getScopeGroupId(),SPProductConstants.PRODUCT_DISPLAY_TEMPLATES);
				productTemplates = paraConfigur.getValue();
			} catch (Exception e1) {
			}
			
			String[] productTemplatesArray = productTemplates.split(StringPool.COMMA);
			//List<String> productTemplateList = new List<String>();
			List<String> productTemplateList = Arrays.asList(productTemplatesArray);
//			for(String producttemp : productTemplatesArray){
//				productTemplateList.add(producttemp);
//			}
			EditUtil.setDetails(renderRequest, renderResponse);
			ProductDetailUtil.setDetails(renderRequest, renderResponse);

			renderRequest.setAttribute("frameworkList", frameworkList);
			renderRequest.setAttribute("miscFeeTypeList", miscFeeTypeList);
			renderRequest.setAttribute("hasInventory", String.valueOf(hasInventory));
			if(Validator.isNotNull(inventoryDetailListJSON)){
				renderRequest.setAttribute("inventoryDetailListJSON", inventoryDetailListJSON);
			}else{
				renderRequest.setAttribute("inventoryDetailListJSON", "0");
			}
			renderRequest.setAttribute("miscWhenPayableList", miscWhenPayableList);
			renderRequest.setAttribute("criteriaTypeList", criteriaTypeList);
			renderRequest.setAttribute("criteriaLevelList", criteriaLevelList);
			renderRequest.setAttribute("sponsoredByList", sponsoredByList);
			renderRequest.setAttribute("residentialStatusList", residentialStatusList);
			renderRequest.setAttribute("competencyLevelList", competencyLevelList);
			renderRequest.setAttribute("outcomeList", outcomeList);
			renderRequest.setAttribute("outlineList", outlineList);
			renderRequest.setAttribute("outlineDetailsList", outlineDetailsList);
			renderRequest.setAttribute("jobFamilyList", jobFamilyList);
			renderRequest.setAttribute("countryList", countryList);
			renderRequest.setAttribute("courseDeveloperList", courseDeveloperList);
			renderRequest.setAttribute("awardList", awardList);
			renderRequest.setAttribute("competencyUnitCodeList", competencyUnitCodeList);
			renderRequest.setAttribute("careerLevelList", careerLevelList);
			renderRequest.setAttribute("progressionTypeList", progressionTypeList);
			renderRequest.setAttribute("progressionCategoryList", progressionCategoryList);
			renderRequest.setAttribute("feeTypeList", feeTypeList);
			renderRequest.setAttribute("personaTypeList", personaTypeList);
			renderRequest.setAttribute("specializationList", specializationList);
			renderRequest.setAttribute("courseLevelList", courseLevelList);

			renderRequest.setAttribute("certificateTypeList", certificateTypeList);
			renderRequest.setAttribute("certificateLevelList", certificateLevelList);
			renderRequest.setAttribute("moduleTypeList", moduleTypeList);
			renderRequest.setAttribute("outlineTypeList", outlineTypeList);
			renderRequest.setAttribute("sessionTypeList", sessionTypeList);
			renderRequest.setAttribute("certificateList", certificateList);
			renderRequest.setAttribute("courseTypeList", courseTypeList);
			renderRequest.setAttribute("localeList", availaleLocales);
			renderRequest.setAttribute("courseList", courseList);
			renderRequest.setAttribute("skillsList", skillsList);
			renderRequest.setAttribute("selfSponsorId", selfSponsorId);
			renderRequest.setAttribute("productTemplateList", productTemplateList);
			
		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		super.render(renderRequest, renderResponse);
	}

	public static HashMap<Long, List<String>> getProductDetailsListMap(
			List<com.sambaash.platform.srv.model.Product> productList) {
		HashMap<Long, List<String>> productDetailsMap = new LinkedHashMap<Long, List<String>>();
		Status statusPublish = Status.PUBLISH;
		try {
			for (com.sambaash.platform.srv.model.Product product : productList) {
				List<String> productListing = new ArrayList<String>();
				productListing.add(String.valueOf(product.getProductImageId()));
				productListing.add(String.valueOf(product.getSpProductId()));
				productListing.add(product.getProductName());

				AssetCategory cAsset;

				cAsset = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(product.getCountryId()));

				productListing.add(cAsset.getName());
				if (statusPublish.getCode() == product.getStatus()) {
					productListing.add("published");
				} else {
					productListing.add("unpublished");
				}

				productDetailsMap.put(product.getSpProductId(), productListing);
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return productDetailsMap;
	}

	public static HashMap<Long, List<String>> getProductDetailsListMap(Hits results, ThemeDisplay themeDisplay) {
		HashMap<Long, List<String>> productDetailsMap = new LinkedHashMap<Long, List<String>>();
		Status statusPublish = Status.PUBLISH;
		try {

			if (Validator.isNotNull(results)) {
				for (int i = 0; i < 10; i++) {
					Document doc = results.doc(i);
					List<String> productListing = new ArrayList<String>();
					String imageUrl = doc.get("imgUrl");
					if (Validator.isNotNull(imageUrl)) {
						if (imageUrl.contains(SambaashUtil.getPortalURL(themeDisplay.getCompanyId(),
								themeDisplay.getScopeGroupId()))) {
							productListing.add(doc.get("imgUrl"));
						} else {
							imageUrl = themeDisplay.getPathThemeImages() + imageUrl;
							productListing.add(imageUrl);
						}
					}
					productListing.add(doc.get("productId"));
					productListing.add(doc.get("productName"));

					AssetCategory cAsset;

					long countryId = GetterUtil.getLong(doc.get("countryId"));
					if (countryId > 0) {
						cAsset = AssetCategoryLocalServiceUtil.getAssetCategory(countryId);
						productListing.add(cAsset.getName());
					}
					if (statusPublish.getCode() == Integer.parseInt(doc.get(Field.STATUS))) {
						productListing.add("published");
					} else {
						productListing.add("unpublished");
					}

					productDetailsMap.put(Long.parseLong(doc.get("productId")), productListing);
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return productDetailsMap;
	}

	private void loadModuleSpecialization(List<AssetCategory> specializationList, RenderRequest renderRequest) {

		List<String> tempList = new ArrayList<String>();
		JSONArray array = JSONFactoryUtil.createJSONArray();

		if (array.length() == 0) {
			try {
				String splName = null;
				for (AssetCategory asset : specializationList) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {
						splName = asset.getName().trim();
						if (tempList.contains(splName))
							continue;
						tempList.add(splName);
						obj.put("code", splName);
						obj.put("key", asset.getCategoryId());
						array.put(obj);
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
				_log.error(e);
			}
		}

		if (array.length() > 0) {
			renderRequest.setAttribute("specializationListJSON", JSONFactoryUtil.looseSerialize(array));
		} else {
			renderRequest.setAttribute("specializationListJSON", "0");
		}
		renderRequest.setAttribute("selectedSpecializationListJSON", "0");

	}

	private void loadCoursePersona(List<AssetCategory> personaList, RenderRequest renderRequest) {

		List<String> tempList = new ArrayList<String>();
		JSONArray array = JSONFactoryUtil.createJSONArray();

		if (array.length() == 0) {
			try {
				String pName = null;
				for (AssetCategory asset : personaList) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {
						pName = asset.getName().trim();
						if (tempList.contains(pName))
							continue;
						tempList.add(pName);
						obj.put("code", pName);
						obj.put("key", asset.getCategoryId());
						array.put(obj);
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
				_log.error(e);
			}
		}
		if (array.length() > 0) {
			renderRequest.setAttribute("personaListJSON", JSONFactoryUtil.looseSerialize(array));
		} else {
			renderRequest.setAttribute("personaListJSON", "0");
		}
		renderRequest.setAttribute("selectedPersonaListJSON", "0");

	}

	private void loadskillsList(List<AssetCategory> skillsList, RenderRequest renderRequest) {

		List<String> tempList = new ArrayList<String>();
		JSONArray array = JSONFactoryUtil.createJSONArray();

		if (array.length() == 0) {
			try {
				String skillsName = null;
				for (AssetCategory asset : skillsList) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {
						skillsName = asset.getName();
						if (tempList.contains(skillsName))
							continue;
						tempList.add(skillsName);
						obj.put("code", skillsName);
						obj.put("key", asset.getCategoryId());
						array.put(obj);
					} catch (Exception e) {
						_log.error(e);
					}
				}
			} catch (Exception e) {
				_log.error(e);
			}
		}

		if (array.length() > 0) {
			renderRequest.setAttribute("skillsListJSON", JSONFactoryUtil.looseSerialize(array));
		} else {
			renderRequest.setAttribute("skillsListJSON", "0");
		}
		renderRequest.setAttribute("selectedSkillsListJSON", "0");

	}

	private void loadModuleList(List<Module> moduleList, RenderRequest renderRequest) {
		// List<String> tempList = new ArrayList<String>();
		JSONArray array = JSONFactoryUtil.createJSONArray();

		if (array.length() == 0) {
			try {
				String moduleName = null;
				for (Module module : moduleList) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {
						moduleName = module.getModuleName().trim();
						/*
						 * if (tempList.contains(moduleName)) continue;
						 * tempList.add(moduleName);
						 */
						moduleName = moduleName + " [" + module.getModuleCode() + "]";
						obj.put("code", moduleName);
						obj.put("key", module.getSpModuleId());
						array.put(obj);
					} catch (Exception e) {
						_log.error(e);
					}
				}
			} catch (Exception e) {
				_log.error(e);
			}
		}

		if (array.length() > 0) {
			renderRequest.setAttribute("moduleListJSON", JSONFactoryUtil.looseSerialize(array));
		} else {
			renderRequest.setAttribute("moduleListJSON", "0");
		}
		renderRequest.setAttribute("moduleCourseListJSON", "0");

	}

	private void loadCertifcatesList(List<Certificate> certificateList, RenderRequest renderRequest) {
		List<String> tempList = new ArrayList<String>();
		JSONArray array = JSONFactoryUtil.createJSONArray();

		if (array.length() == 0) {
			try {
				String certificateCode = null;
				for (Certificate certificates : certificateList) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {
						certificateCode = certificates.getCertificateCode().trim();
						if (tempList.contains(certificateCode))
							continue;
						tempList.add(certificateCode);
						obj.put("code", certificateCode);
						obj.put("key", certificates.getSpCertificatetId());
						array.put(obj);
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
				_log.error(e);
			}
		}

		if (array.length() > 0) {
			renderRequest.setAttribute("certificatesList", JSONFactoryUtil.looseSerialize(array));
		} else {
			renderRequest.setAttribute("certificatesList", "0");
		}
		renderRequest.setAttribute("moduleCertificatesListJSON", "0");
		renderRequest.setAttribute("courseCertificateListJSON", "0");
		renderRequest.setAttribute("scheduleListJSON", "0");

	}

	public static void loadModuleCompetencyUnits(List<CompetencyUnit> competencyUnitCodeList,
			RenderRequest renderRequest) {
		List<String> tempList = new ArrayList<String>();
		JSONArray array = JSONFactoryUtil.createJSONArray();

		if (array.length() == 0) {
			try {
				String competencyUnitCode = null;
				for (CompetencyUnit competencyUnit : competencyUnitCodeList) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {
						competencyUnitCode = competencyUnit.getCompetencyUnitCode().trim();
						// if (tempList.contains(competencyUnitCode))
						// continue;
						tempList.add(competencyUnitCode);
						obj.put("code", competencyUnitCode);
						obj.put("key", competencyUnit.getSpCompetencyUnitId());
						array.put(obj);
					} catch (Exception e) {
						_log.error(e);
					}
				}
			} catch (Exception e) {
				_log.error(e);
			}
		}

		if (array.length() > 0) {
			renderRequest.setAttribute("competencyUnitList", JSONFactoryUtil.looseSerialize(array));
		} else {
			renderRequest.setAttribute("competencyUnitList", "0");
		}
		renderRequest.setAttribute("moduleCompetencyUnitListJSON", "0");
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String action = resourceRequest.getParameter("action");

		if (_log.isDebugEnabled()) {
			_log.debug("action : " + action);
		}
		Object response = null;

		if ("getFramework".equalsIgnoreCase(action)) {
			response = SPFrameworkUtil.getFramework(resourceRequest, resourceResponse);
		} else if ("addFramework".equalsIgnoreCase(action)) {
			response = SPFrameworkUtil.addFramework(resourceRequest, resourceResponse);
		} else if ("addCompetencyUnits".equalsIgnoreCase(action)) {
			response = SPCompetencyUnitsUtil.addCompetencyUnits(resourceRequest, resourceResponse);
		} else if ("addOutcome".equalsIgnoreCase(action)) {
			response = SPOutcomeUtil.addOutcome(resourceRequest, resourceResponse);
		} else if ("addOutline".equalsIgnoreCase(action)) {
			response = SPOutlineUtil.addOutline(resourceRequest, resourceResponse);
		} else if ("addCertificate".equalsIgnoreCase(action)) {
			response = SPCertificateUtil.addCertificate(resourceRequest, resourceResponse);
		} else if ("addModule".equalsIgnoreCase(action)) {
			response = SPModuleUtil.addModule(resourceRequest, resourceResponse);
		} else if ("addCourse".equalsIgnoreCase(action)) {
			response = SPCourseUtil.addCourse(resourceRequest, resourceResponse);
		} else if ("addGraduationCriteria".equalsIgnoreCase(action)) {
			response = SPGraduationCriteriaUtil.addGraduationCriteria(resourceRequest, resourceResponse);
		} else if ("addFunding".equalsIgnoreCase(action)) {
			response = SPFundingUtil.addFunding(resourceRequest, resourceResponse);
		} else if ("addProgessionPath".equalsIgnoreCase(action)) {
			response = SPProgessionPathUtil.addProgessionPath(resourceRequest, resourceResponse);
		} else if ("addFeeDetail".equalsIgnoreCase(action)) {
			response = SPFeeDetailUtil.addFeeDetail(resourceRequest, resourceResponse, "", 0,
					resourceRequest.getParameter("critInstancesCount"));
		} else if ("addMiscFee".equalsIgnoreCase(action)) {
			response = SPMiscFeeUtil.addMiscFeeDetail(resourceRequest, resourceResponse);
		} else if ("addPersonna".equalsIgnoreCase(action)) {
			response = SPPersonnaUtil.addPersonna(resourceRequest, resourceResponse);
		} else if ("getFeeType".equalsIgnoreCase(action)) {
			response = SPFeeDetailUtil.getFeeType(resourceRequest, resourceResponse);
		} else if ("addProduct".equalsIgnoreCase(action)) {
			response = SPProductUtil.addProduct(resourceRequest, resourceResponse);
		} else if ("createInventory".equalsIgnoreCase(action)) {
			response = SPProductUtil.addProductInventory(resourceRequest, resourceResponse);
		} else if ("uploadProductImage".equalsIgnoreCase(action)) {
			response = FileUtil.uploadFile(resourceRequest, resourceResponse);
		} else if ("uploadProductFormImage".equalsIgnoreCase(action)) {
			response = FileUtil.uploadFile(resourceRequest, resourceResponse);
		} else if ("uploadProductBannerImage".equalsIgnoreCase(action)) {
			response = FileUtil.uploadFile(resourceRequest, resourceResponse);
		} else if ("uploadProductVideos".equalsIgnoreCase(action)) {
			response = FileUtil.uploadToProductVideoFolder(resourceRequest, resourceResponse);
		} else if ("uploadProductBrochures".equalsIgnoreCase(action)) {
			response = FileUtil.uploadToProductBrochuresFolder(resourceRequest, resourceResponse);
		} else if ("uploadCertificates".equalsIgnoreCase(action)) {
			response = FileUtil.uploadToCertificatesFolder(resourceRequest, resourceResponse);
		} else if ("uploadOutcomeLogo".equalsIgnoreCase(action)) {
			response = FileUtil.uploadToOutcomeLogoFolder(resourceRequest, resourceResponse);
		} else if ("uploadFrameworkImage".equalsIgnoreCase(action)) {
			response = FileUtil.uploadFile(resourceRequest, resourceResponse);
		} else if ("uploadAttendeeImage".equalsIgnoreCase(action)) {
			response = FileUtil.uploadFile(resourceRequest, resourceResponse);
		} else if ("addLearning".equalsIgnoreCase(action)) {
			response = SPLearningUtil.createUpdateLearningDetail(resourceRequest, resourceResponse);
		} else if ("deleteDurationType".equalsIgnoreCase(action)) {
			response = SPLearningUtil.deleteDurationType(resourceRequest, resourceResponse);
		} else if ("addCareerDetails".equalsIgnoreCase(action)) {
			response = SPCareerUtil.createUpdateCareerDetails(resourceRequest, resourceResponse);
		} else if ("deleteStudyOption".equalsIgnoreCase(action)) {
			response = SPCareerUtil.deleteStudyOption(resourceRequest, resourceResponse);
		} else if ("uploadStudyOptionCoverImage".equalsIgnoreCase(action)) {
			response = FileUtil.uploadFile(resourceRequest, resourceResponse);
		} else if ("getMaxSubLevel".equalsIgnoreCase(action)) {
			response = ProductConfigUtil.prepareResponseMaxSublevel(resourceRequest);
		} else if ("fixPermission".equalsIgnoreCase(action)) {
			FileUtil.fixFolderPermissions(resourceRequest);
			response = "Completed";
		} else if ("publish".equalsIgnoreCase(action)) {
			response = SPProductUtil.publish(resourceRequest, resourceResponse);
		} else if ("unpublish".equalsIgnoreCase(action)) {
			response = SPProductUtil.unpublish(resourceRequest, resourceResponse);
		} else if ("fetchProducts".equalsIgnoreCase(action)) {
			response = ProductSearchHelper.fetchProducts(resourceRequest, resourceResponse);
		} else if ("fetchModules".equalsIgnoreCase(action)) {
			response = ProductSearchHelper.fetchModules(resourceRequest, resourceResponse);
		} else if ("fetchCourses".equalsIgnoreCase(action)) {
			response = ProductSearchHelper.fetchCourses(resourceRequest, resourceResponse);
		} else if ("fetchCertificates".equalsIgnoreCase(action)) {
			response = ProductSearchHelper.fetchCertificates(resourceRequest, resourceResponse);
		} else if ("fetchOutlines".equalsIgnoreCase(action)) {
			response = ProductSearchHelper.fetchOutlines(resourceRequest, resourceResponse);
		} else if ("fetchCompetencies".equalsIgnoreCase(action)) {
			response = ProductSearchHelper.fetchCompetencies(resourceRequest, resourceResponse);
		} else if ("fetchFrameworks".equalsIgnoreCase(action)) {
			response = ProductSearchHelper.fetchFrameworks(resourceRequest, resourceResponse);
		}else if ("fetchFeeComponents".equalsIgnoreCase(action)) {
			response = ProductSearchHelper.fetchFeeComponents(resourceRequest, resourceResponse);
		}else if ("createFeeComponent".equalsIgnoreCase(action)) {
			response = SPFeeTypeUtil.addUpdateFeeType(resourceRequest, resourceResponse);
		}

		if(action.equalsIgnoreCase("downLoadBrochure")){
			String fileUrl = resourceRequest.getParameter("fileUrl");
			String fileType = resourceRequest.getParameter("fileType");
	        try {
	            File file = new File(fileUrl);
	            InputStream in = new FileInputStream(file);
	            HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(resourceResponse);
	            HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);
	            ServletResponseUtil.sendFile(httpReq,httpRes, file.getName(), in, "application/download");
	            in.close();
	        } catch (Exception e) {
	        	_log.error(e.getMessage());
	        }   
		}
		resourceResponse.getWriter().write(response.toString());
	}

}
