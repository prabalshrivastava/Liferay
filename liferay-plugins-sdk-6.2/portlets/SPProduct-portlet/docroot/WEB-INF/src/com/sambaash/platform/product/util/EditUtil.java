package com.sambaash.platform.product.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeFormatter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.sambaash.platform.srv.model.Activity;
import com.sambaash.platform.srv.model.Certificate;
import com.sambaash.platform.srv.model.CompetencyUnit;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.CourseCertificate;
import com.sambaash.platform.srv.model.CourseModule;
import com.sambaash.platform.srv.model.CourseOutcome;
import com.sambaash.platform.srv.model.FeeDetails;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.model.Funding;
import com.sambaash.platform.srv.model.GraduationCriteria;
import com.sambaash.platform.srv.model.MiscellaneousFees;
import com.sambaash.platform.srv.model.Module;
import com.sambaash.platform.srv.model.ModuleCertificate;
import com.sambaash.platform.srv.model.ModuleCompetencyUnit;
import com.sambaash.platform.srv.model.ModuleFramework;
import com.sambaash.platform.srv.model.Outcome;
import com.sambaash.platform.srv.model.Outline;
import com.sambaash.platform.srv.model.Persona;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.model.ProgressionPath;
import com.sambaash.platform.srv.model.Schedule;
import com.sambaash.platform.srv.service.ActivityLocalServiceUtil;
import com.sambaash.platform.srv.service.CertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseOutcomeLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeDetailsLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.FrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.FundingLocalServiceUtil;
import com.sambaash.platform.srv.service.GraduationCriteriaLocalServiceUtil;
import com.sambaash.platform.srv.service.MiscellaneousFeesLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleCompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleFrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.OutcomeLocalServiceUtil;
import com.sambaash.platform.srv.service.OutlineLocalServiceUtil;
import com.sambaash.platform.srv.service.PersonaLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.service.ProgressionPathLocalServiceUtil;
import com.sambaash.platform.srv.service.ScheduleLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class EditUtil {

	private static Log _log = LogFactoryUtil.getLog(EditUtil.class);

	public static void setDetails(RenderRequest renderRequest, RenderResponse renderResponse) {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String action = renderRequest.getParameter("action");
			log("action editutil " + action);
			
			if ("editFramework".equalsIgnoreCase(action)) {
				String spFrameworkId = renderRequest.getParameter("spFrameworkId");
				if (Validator.isNumber(spFrameworkId)) {
					Framework frameworkDetail = FrameworkLocalServiceUtil.getFramework(Long.parseLong(spFrameworkId));
					renderRequest.setAttribute("frameworkDetail", frameworkDetail);
					log("frameworkDetail: " + frameworkDetail);

				}

			} else if ("editCompetency".equalsIgnoreCase(action)) {
				String spCompetencyId = renderRequest.getParameter("spCompetencyId");
				if (Validator.isNumber(spCompetencyId)) {
					CompetencyUnit competencyDetail = CompetencyUnitLocalServiceUtil.getCompetencyUnit(Long
							.parseLong(spCompetencyId));
					renderRequest.setAttribute("competencyDetail", competencyDetail);
					log("competencyDetail: " + competencyDetail);

				}

			} else if ("editOutcome".equalsIgnoreCase(action)) {
				String spOutcomeId = renderRequest.getParameter("spOutcomeId");
				if (Validator.isNumber(spOutcomeId)) {
					Outcome outcomeDetail = OutcomeLocalServiceUtil.getOutcome(Long.parseLong(spOutcomeId));
					renderRequest.setAttribute("outcomeDetail", outcomeDetail);
					log("outcomeDetail: " + outcomeDetail);

				}

			}

			if ("editOutLine".equalsIgnoreCase(action)) {
				String spOutlineId = renderRequest.getParameter("spOutlineId");
				if (Validator.isNumber(spOutlineId)) {
					Outline outlineDetail = OutlineLocalServiceUtil.getOutline(Long.parseLong(spOutlineId));
					renderRequest.setAttribute("outlineDetail", outlineDetail);
					log("outlineDetail: " + outlineDetail);

				}
			} else if ("editCertificate".equalsIgnoreCase(action)) {
				String spCertificateId = renderRequest.getParameter("spCertificateId");
				if (Validator.isNumber(spCertificateId)) {
					Certificate certificateDetail = CertificateLocalServiceUtil.getCertificate(Long
							.parseLong(spCertificateId));
					renderRequest.setAttribute("certificateDetail", certificateDetail);
					log("outlineDetail: " + certificateDetail);

				}

			} else if ("editModule".equalsIgnoreCase(action)) {
				String spModuleId = renderRequest.getParameter("spModuleId");
				if (Validator.isNumber(spModuleId)) {
					Module moduleDetail = ModuleLocalServiceUtil.getModule(Long.parseLong(spModuleId));
					List<ModuleFramework> moduleFrameWorkDetail = ModuleFrameworkLocalServiceUtil
							.findByModuleIdAndGroupId(Long.parseLong(spModuleId), themeDisplay.getScopeGroupId());
					renderRequest.setAttribute("moduleDetail", moduleDetail);
					renderRequest.setAttribute("moduleFrameWorkDetail", moduleFrameWorkDetail);
					log("moduleDetail: " + moduleDetail);

					getScheduleActivity(renderRequest, renderResponse, Long.parseLong(spModuleId));

					List<ModuleCompetencyUnit> moduleCompetencyUnitList = ModuleCompetencyUnitLocalServiceUtil
							.findByModuleIdAndGroupId(Long.parseLong(spModuleId), themeDisplay.getScopeGroupId());
					loadModuleCompetencyUnits(moduleCompetencyUnitList, renderRequest);
					renderRequest.setAttribute("moduleCompetencyUnitList", moduleCompetencyUnitList);
					List<Outline> outLineList = null;
					for (ModuleCompetencyUnit mcUnit : moduleCompetencyUnitList) {
						OutlineLocalServiceUtil.findByGroupIdAndCompetencyUnitId(themeDisplay.getScopeGroupId(),
								mcUnit.getSpCompetencyUnitId());
					}
					renderRequest.setAttribute("outLineList", outLineList);
					List<ModuleCertificate> moduleCertificateList = ModuleCertificateLocalServiceUtil
							.findByModuleIdAndGroupId(Long.parseLong(spModuleId), themeDisplay.getScopeGroupId());
					renderRequest.setAttribute("moduleCertificateList", moduleCertificateList);
					loadModuleCertificateUnits(moduleCertificateList, renderRequest);
					List<ModuleFramework> moduleFrameworkList = ModuleFrameworkLocalServiceUtil
							.findByModuleIdAndGroupId(Long.parseLong(spModuleId), themeDisplay.getScopeGroupId());
					renderRequest.setAttribute("moduleFrameworkList", moduleFrameworkList);
					log("moduleCertificateList " + moduleCertificateList);
				}

			} else if ("editCourse".equalsIgnoreCase(action)) {
				String spCourseId = renderRequest.getParameter("spCourseId");
				if (Validator.isNumber(spCourseId)) {
					Course courseDetail = CourseLocalServiceUtil.getCourse(Long.parseLong(spCourseId));
					renderRequest.setAttribute("courseDetail", courseDetail);

					log("courseDetail: " + courseDetail);
					List<CourseModule> courseModuleList = CourseModuleLocalServiceUtil.findByCourseIdAndGroupId(
							Long.parseLong(spCourseId), themeDisplay.getScopeGroupId());
					loadModuleCourseList(courseModuleList, renderRequest);
					List<CourseCertificate> courseCertificateList = CourseCertificateLocalServiceUtil
							.findByCourseIdAndGroupId(Long.parseLong(spCourseId), themeDisplay.getScopeGroupId());
					loadCourseCertificateList(courseCertificateList, renderRequest);
					renderRequest.setAttribute("courseModuleList", courseModuleList);
					List<CourseOutcome> courseOutcomeList = CourseOutcomeLocalServiceUtil.findByCourseIdAndGroupId(
							Long.parseLong(spCourseId), themeDisplay.getScopeGroupId());
					renderRequest.setAttribute("courseOutcomeList", courseOutcomeList);
					renderRequest.setAttribute("courseOutcomeListLength", courseOutcomeList.size());
					log("courseModuleList " + courseModuleList);
				}

			} else if ("editPersona".equalsIgnoreCase(action)) {
				String spCourseId = renderRequest.getParameter("spCourseId");
				if (Validator.isNumber(spCourseId)) {
					List<Persona> personaDetailList = PersonaLocalServiceUtil.findByCourseIdAndGroupId(
							Long.parseLong(spCourseId), themeDisplay.getScopeGroupId());
					renderRequest.setAttribute("personaDetailList", personaDetailList);
					renderRequest.setAttribute("personaDetailListLength", personaDetailList.size());

					log("personaDetail: " + personaDetailList);
					Course personaCourseList = CourseLocalServiceUtil.getCourse(Long.parseLong(spCourseId));
					renderRequest.setAttribute("personaCourseDesc", personaCourseList.getPersonaDesc());
					log("personaAttendeeList " + personaCourseList.getPersonaDesc());
				}
			} else if ("editProgressionPath".equalsIgnoreCase(action)) {
				String spCourseId = renderRequest.getParameter("spCourseId");
				if (Validator.isNumber(spCourseId)) {
					List<ProgressionPath> progressionPathDetail = ProgressionPathLocalServiceUtil
							.findByCourseIdAndGroupId(Long.parseLong(spCourseId), themeDisplay.getScopeGroupId());
					renderRequest.setAttribute("progressionPathDetail", progressionPathDetail);

					log("progressionPathList: " + progressionPathDetail);
				}
			} else if ("editLearningDetails".equalsIgnoreCase(action)) {
				long courseId = ParamUtil.getLong(renderRequest, "spCourseId");
				if (courseId > 0) {
					SPLearningUtil.loadLearningDetails(renderRequest, courseId);

				}
			} else if ("editCareerDetails".equalsIgnoreCase(action)) {
				long courseId = ParamUtil.getLong(renderRequest, "spCourseId");
				if (courseId > 0) {
					SPCareerUtil.loadCareerDetails(renderRequest);
				}
			} else if ("editGraduationCriteria".equalsIgnoreCase(action)) {
				String spCourseId = renderRequest.getParameter("spCourseId");
				if (Validator.isNumber(spCourseId)) {
					Course courseDetail = CourseLocalServiceUtil.getCourse(Long.parseLong(spCourseId));
					List<GraduationCriteria> graduationCriteriaDetail = GraduationCriteriaLocalServiceUtil
							.findByCourseIdAndGroupId(Long.parseLong(spCourseId), themeDisplay.getScopeGroupId());
					renderRequest.setAttribute("graduationCriteriaDetail", graduationCriteriaDetail);
					renderRequest.setAttribute("graduationCriteriaDetailListLength", graduationCriteriaDetail.size());
					renderRequest.setAttribute("graduationCriteriaTitle", courseDetail.getGraduationCriteriaDesc());
					log("graduationCriteriaDetail: " + graduationCriteriaDetail);

				}
			} else if ("editFunding".equalsIgnoreCase(action)) {
				String spCourseId = renderRequest.getParameter("spCourseId");
				String countryId = "0";
				boolean isShowFunding = false;
				if (Validator.isNumber(spCourseId)) {
					Course courseDetail = CourseLocalServiceUtil.getCourse(Long.parseLong(spCourseId));
					countryId = courseDetail.getCountryId();
					String countries = SambaashUtil.getParameter("courseFunding.available.for.countries", themeDisplay.getScopeGroupId());
					if(countries.contains(StringPool.COMMA)){
						String[] countriesArray = countries.split(StringPool.COMMA);
						for(String country : countriesArray){
							if(country.equals(countryId)){
								isShowFunding = true;
							}
						}
					}else{
						if(countries.equals(countryId)){
							isShowFunding = true;
						}
					}

					renderRequest.setAttribute("fundingDescPost", courseDetail.getFundingDescPost());
					renderRequest.setAttribute("feeDesc", courseDetail.getFeeDetailsDesc());
					renderRequest.setAttribute("isShowFunding", isShowFunding);

					getFeeFundingDetail(renderRequest, renderResponse, Long.parseLong(spCourseId));
					getFeeDetail(renderRequest, renderResponse, Long.parseLong(spCourseId));
					_log.error("fundingDetail: ");
				}

			} else if ("editMiscFeeDetails".equalsIgnoreCase(action)) {
				String spCourseId = renderRequest.getParameter("spCourseId");
				if (Validator.isNumber(spCourseId)) {
					Course courseDetail = CourseLocalServiceUtil.getCourse(Long.parseLong(spCourseId));
					getMiscFeeDetail(renderRequest, renderResponse, Long.parseLong(spCourseId));
					renderRequest.setAttribute("miscFeeDesc", courseDetail.getMiscFeeDesc());
				}
				
			} else if ("editProduct".equalsIgnoreCase(action)) {
				String spProductId = renderRequest.getParameter("productId");
				if (Validator.isNumber(spProductId)) {
					Product productDetail = ProductLocalServiceUtil.getProduct(Long.parseLong(spProductId));
					renderRequest.setAttribute("productDetail", productDetail);
					renderRequest.setAttribute("spProductId", spProductId);
					List<String> selectedSpecializationList = new ArrayList<String>();
					try {
						AssetEntry asst = AssetEntryLocalServiceUtil.getEntry(Product.class.getName(),
								Long.parseLong(spProductId));
						if (Validator.isNotNull(asst)) {
							List<AssetCategory> asstCtg = asst.getCategories();
							loadSelectedSpecializationList(asstCtg, renderRequest);
							loadSelectedPersonaList(asstCtg, renderRequest);
							for (AssetCategory category : asstCtg) {
								selectedSpecializationList.add(String.valueOf(category.getCategoryId()));
							}
						}
						renderRequest.setAttribute("selectedSpecializationList", selectedSpecializationList);
						renderRequest.setAttribute(SPProductConstants.SHOW_PERSONA, renderRequest.getPreferences().getValue(SPProductConstants.SHOW_PERSONA, ""));
					} catch (Exception e) {
						_log.error(e);
						renderRequest.setAttribute("selectedPersonaListJSON", "0");
					}

					log("productDetail: " + productDetail);
				}
			} else if ("editFeeComponent".equalsIgnoreCase(action)) {
				String spFeeTypeId = renderRequest.getParameter("spFeeTypeId");
				if (Validator.isNumber(spFeeTypeId)) {
					FeeType feeType = FeeTypeLocalServiceUtil.getFeeType(Long.parseLong(spFeeTypeId));
					renderRequest.setAttribute("feeComponentDetail", feeType);
					renderRequest.setAttribute("spFeeTypeId", spFeeTypeId);

					log("feeComponentDetail: " + feeType);
				}
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (NumberFormatException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

	}

	public static void getFeeFundingDetail(RenderRequest renderRequest, RenderResponse renderResponse, long spCourseId) {
	
		log("getFeeFundingDetail");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Funding> fundingDetail = null;
		try {
			fundingDetail = FundingLocalServiceUtil.findByCourseIdAndGroupId(spCourseId, themeDisplay.getScopeGroupId());
		} catch (SystemException e1) {
			_log.error(e1);
		}
		
		JSONArray array = JSONFactoryUtil.createJSONArray();
		JSONObject objwarp = JSONFactoryUtil.createJSONObject();
		if (Validator.isNotNull(fundingDetail)) {
			try {
				for (Funding funding : fundingDetail) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					obj.put("fundOrder", funding.getFundOrder());
					obj.put("sponsoredBy", funding.getSponsoredBy());
					obj.put("residentStatus", funding.getResidenceStatus());
					obj.put("fundingDescription", funding.getFundingDesc());
					obj.put("ageOperator", funding.getAgeOperator());
					obj.put("ageGroup", funding.getAge());
					obj.put("salOperator", funding.getSalaryOperator());
					obj.put("salary", funding.getSalary());
					JSONObject feeWarp = JSONFactoryUtil.createJSONObject();
					List<FeeDetails> feeDetails = FeeDetailsLocalServiceUtil.findByFundIdAndSpCourseId(funding.getSpFundingId(),spCourseId);
					for (FeeDetails feeDetail : feeDetails) {
						JSONObject feeDt = JSONFactoryUtil.createJSONObject();
						feeDt.put("displayOrder", feeDetail.getDisplayOrder());
						feeDt.put("feeType", feeDetail.getFeeType());
						feeDt.put("feeDesc", feeDetail.getFeeDesc());
						feeDt.put("amount", feeDetail.getAmount());
						feeWarp.put(String.valueOf(feeDetail.getSpFeeDetailsId()), feeDt);
						obj.put("feeDetails", feeWarp);
					}
					if (feeDetails.isEmpty()) {
						obj.put("feeDetails", "");
					}
					objwarp.put(String.valueOf(funding.getSpFundingId()), obj);
				}
				array.put(objwarp);
			} catch (Exception e) {
				_log.error(e);
			}
			
			log("Loaded feefubdingList " + objwarp + "  array.length " + objwarp.length());

			if (objwarp.length() > 0) {
				renderRequest.setAttribute("feeFundingDetailListJSON", JSONFactoryUtil.looseSerialize(array));
			}else{
				renderRequest.setAttribute("feeFundingDetailListJSON", "0");
			}
		}else{
			renderRequest.setAttribute("feeFundingDetailListJSON", "0");
		}

	}
	
	public static void getFeeDetail(RenderRequest renderRequest, RenderResponse renderResponse, long spCourseId) {
		
		log("getFeeDetail " + spCourseId);

		JSONArray array = JSONFactoryUtil.createJSONArray();
		List<FeeDetails> feeDetails = null;
		try {
					feeDetails = FeeDetailsLocalServiceUtil.findByFundIdAndSpCourseId(0,spCourseId);
				} catch (Exception e) {
					_log.error(e);
				}
		if (Validator.isNotNull(feeDetails)) {	
			JSONObject feeWarp = JSONFactoryUtil.createJSONObject();
			for (FeeDetails feeDetail : feeDetails) {
				JSONObject feeDt = JSONFactoryUtil.createJSONObject();
				feeDt.put("displayOrder", feeDetail.getDisplayOrder());
				feeDt.put("feeType", feeDetail.getFeeType());
				feeDt.put("feeDesc", feeDetail.getFeeDesc());
				feeDt.put("amount", feeDetail.getAmount());
				feeWarp.put(String.valueOf(feeDetail.getSpFeeDetailsId()), feeDt);
			}
			array.put(feeWarp);
			if (feeWarp.length() > 0) {
				renderRequest.setAttribute("feeDetailListJSON", JSONFactoryUtil.looseSerialize(array));
			}else{
				renderRequest.setAttribute("feeDetailListJSON", 0);
			}
		}else{
			renderRequest.setAttribute("feeDetailListJSON", 0);
		}
	}
	
	public static void getMiscFeeDetail(RenderRequest renderRequest, RenderResponse renderResponse, long spCourseId) {
		
		log("getFeeDetail " + spCourseId);

		//JSONArray array = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<MiscellaneousFees> miscFeeDetails = null;
		JSONObject feeWarp = JSONFactoryUtil.createJSONObject();
		try {
						
						miscFeeDetails = MiscellaneousFeesLocalServiceUtil.findByCourseIdAndGroupId(spCourseId, themeDisplay.getScopeGroupId());
						
				} catch (Exception e) {
					_log.error(e);
				}
		if (Validator.isNotNull(miscFeeDetails)) {
			for (MiscellaneousFees miscFee : miscFeeDetails) {
				JSONObject feeDt = JSONFactoryUtil.createJSONObject();
				feeDt.put("miscFeeType", miscFee.getMiscFeeType());
				feeDt.put("amount", miscFee.getAmount());
				feeDt.put("payable", miscFee.getPayable());
				feeWarp.put(String.valueOf(miscFee.getSpMiscFeesId()), feeDt);
			}

			log("getFeeDetail " + feeWarp.length());
			log("getFeeDetail " + feeWarp.toString());
		}
		if (feeWarp.length() > 0) {
			renderRequest.setAttribute("miscFeeDetailListJSON", feeWarp.toString());
		}else{
			renderRequest.setAttribute("miscFeeDetailListJSON", "0");
			
		}
	}
	
	public static void getScheduleActivity(RenderRequest renderRequest, RenderResponse renderResponse, long spModuleId) {
		log("getOutcomeAndOulineDetail");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Schedule> scheduleDetail;
		try {
			scheduleDetail = ScheduleLocalServiceUtil.findByGroupIdAndModuleId(themeDisplay.getScopeGroupId(),
					spModuleId);
			JSONArray array = JSONFactoryUtil.createJSONArray();
			JSONObject objwarp = JSONFactoryUtil.createJSONObject();
			if (!scheduleDetail.isEmpty()) {
				try {
					for (Schedule schedule : scheduleDetail) {
						JSONObject obj = JSONFactoryUtil.createJSONObject();

						obj.put("sessionNumber", schedule.getSessionNumber());
						obj.put("sessionType", schedule.getSessionType());
						obj.put("sessionDescription", UnicodeFormatter.toString(schedule.getDescription()));
						obj.put("sessionDuration", schedule.getSessionDuration());
						JSONObject actvWarp = JSONFactoryUtil.createJSONObject();
						List<Activity> activityDetail = ActivityLocalServiceUtil.findByGroupIdAndScheduleId(
								themeDisplay.getScopeGroupId(), schedule.getSpScheduleId());
						for (Activity activity : activityDetail) {
							JSONObject actv = JSONFactoryUtil.createJSONObject();
							actv.put("activityDescription", UnicodeFormatter.toString(activity.getDescription()));
							actv.put("activityTiming", activity.getActivityTiming());
							actv.put("activityPerformer", activity.getActivityPerformer());
							actv.put("activityDuration", activity.getActivityDuration());
							actvWarp.put(String.valueOf(activity.getSpActivityId()), actv);
							obj.put("activityDetails", actvWarp);
						}
						if (activityDetail.isEmpty()) {
							obj.put("activityDetails", "");
						}
						objwarp.put(String.valueOf(schedule.getSpScheduleId()), obj);
					}
					array.put(objwarp);
				} catch (Exception e) {
					_log.error(e);
				}
				log("Loaded scheduleList " + array);

				if (array.length() > 0) {
					renderRequest.setAttribute("scheduleListJSON", JSONFactoryUtil.looseSerialize(array));
				}

			}
		} catch (SystemException e1) {
			_log.error(e1);
		}

	}

	private static void loadCourseCertificateList(List<CourseCertificate> courseCertificateList,
			RenderRequest renderRequest) {
		List<String> tempList = new ArrayList<String>();
		JSONArray array = JSONFactoryUtil.createJSONArray();

		if (array.length() == 0) {
			try {
				String certName = null;
				for (CourseCertificate courseCertificate : courseCertificateList) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {
						Certificate certificate = CertificateLocalServiceUtil.getCertificate(courseCertificate
								.getSpCertificatetId());
						certName = certificate.getCertificateCode();
						if (tempList.contains(certName))
							continue;
						tempList.add(certName);
						obj.put("code", certName);
						obj.put("key", certificate.getSpCertificatetId());
						array.put(obj);
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
				_log.error(e);
			}
			log("Loaded courseCertificateListJSON" + array);
		}

		if (array.length() > 0) {
			renderRequest.setAttribute("courseCertificateListJSON", JSONFactoryUtil.looseSerialize(array));
		}

	}

	private static void loadSelectedSpecializationList(List<AssetCategory> asstCtg, RenderRequest renderRequest) {

		List<String> tempList = new ArrayList<String>();
		JSONArray array = JSONFactoryUtil.createJSONArray();
		AssetVocabulary splzVoc = VocabularyUtil.getVocublarySpeicialization(renderRequest);
		if (array.length() == 0) {
			try {
				String splName = null;
				for (AssetCategory asset : asstCtg) {
					if (asset.getVocabularyId() != splzVoc.getVocabularyId()) {
						continue;
					}
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {
						String parentName = StringPool.BLANK;
						if (asset.getParentCategoryId() > 0) {
							AssetCategory parent = AssetCategoryLocalServiceUtil.getAssetCategory(asset
									.getParentCategoryId());
							parentName = parent.getName();
						}

						splName = VocabularyUtil.getSpecializationCatName(parentName, asset.getName());
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
			log("Loaded selectedSpecializationListJSON" + array);
		}

		if (array.length() > 0) {
			renderRequest.setAttribute("selectedSpecializationListJSON", JSONFactoryUtil.looseSerialize(array));
		}else{
			renderRequest.setAttribute("selectedSpecializationListJSON", "0");
		}

	}

	private static void loadSelectedPersonaList(List<AssetCategory> asstCtg, RenderRequest renderRequest) {

		List<String> tempList = new ArrayList<String>();
		JSONArray array = JSONFactoryUtil.createJSONArray();
		AssetVocabulary pVoc = VocabularyUtil.getVocublaryPersona(renderRequest);
		if (array.length() == 0) {
			try {
				String splName = null;
				for (AssetCategory asset : asstCtg) {
					if (asset.getVocabularyId() != pVoc.getVocabularyId()) {
						continue;
					}
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {

						splName = asset.getName();
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
			log("Loaded selectedPersonaListJSON" + array);
		}

		if (array.length() > 0) {
			renderRequest.setAttribute("selectedPersonaListJSON", JSONFactoryUtil.looseSerialize(array));
		}else{
			renderRequest.setAttribute("selectedPersonaListJSON", "0");
		}

	}

	private static void loadModuleCourseList(List<CourseModule> courseModuleList, RenderRequest renderRequest) {
		//List<String> tempList = new ArrayList<String>();
		JSONArray array = JSONFactoryUtil.createJSONArray();

		if (array.length() == 0) {
			try {
				String moduleName = null;
				for (CourseModule courseModule : courseModuleList) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {
						Module module = ModuleLocalServiceUtil.getModule(courseModule.getSpModuleId());
						moduleName = module.getModuleName();

						moduleName = moduleName + " [" + module.getModuleCode() + "]"; 
						obj.put("code", moduleName);
						obj.put("key", module.getSpModuleId());
						array.put(obj);
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
				_log.error(e);
			}
			log("Loaded moduleCourseList" + array);
		}

		if (array.length() > 0) {
			renderRequest.setAttribute("moduleCourseListJSON", JSONFactoryUtil.looseSerialize(array));
		}

	}

	private static void loadModuleCertificateUnits(List<ModuleCertificate> moduleCertificateList,
			RenderRequest renderRequest) {
		List<String> tempList = new ArrayList<String>();
		JSONArray array = JSONFactoryUtil.createJSONArray();

		if (array.length() == 0) {
			try {
				String certficateCode = null;
				for (ModuleCertificate moduleCertificate : moduleCertificateList) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {
						Certificate certficate = CertificateLocalServiceUtil.getCertificate(moduleCertificate
								.getSpCertificatetId());
						certficateCode = certficate.getCertificateCode();
						if (tempList.contains(certficateCode))
							continue;
						tempList.add(certficateCode);
						obj.put("code", certficateCode);
						obj.put("key", certficate.getSpCertificatetId());
						array.put(obj);
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
				_log.error(e);
			}
			log("Loaded moduleCertificateList" + array);
		}

		if (array.length() > 0) {
			renderRequest.setAttribute("moduleCertificatesListJSON", JSONFactoryUtil.looseSerialize(array));
		}
	}

	public static void loadModuleCompetencyUnits(List<ModuleCompetencyUnit> moduleCompetencyUnitList,
			RenderRequest renderRequest) {
		List<String> tempList = new ArrayList<String>();
		JSONArray array = JSONFactoryUtil.createJSONArray();

		if (array.length() == 0) {
			try {
				String competencyUnitCode = null;
				for (ModuleCompetencyUnit moduleCompetency : moduleCompetencyUnitList) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					try {
						CompetencyUnit competency = CompetencyUnitLocalServiceUtil.getCompetencyUnit(moduleCompetency
								.getSpCompetencyUnitId());
						competencyUnitCode = competency.getCompetencyUnitCode();
						if (tempList.contains(competencyUnitCode))
							continue;
						tempList.add(competencyUnitCode);
						obj.put("code", competencyUnitCode);
						obj.put("key", competency.getSpCompetencyUnitId());
						array.put(obj);
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
				_log.error(e);
			}
			log("Loaded moduleCompetencyUnitList" + array);
		}

		if (array.length() > 0) {
			renderRequest.setAttribute("moduleCompetencyUnitListJSON", JSONFactoryUtil.looseSerialize(array));
		}
	}

	private static void log(String message) {
		if (_log.isDebugEnabled()) {
			_log.debug(message);
		}
	}

}
