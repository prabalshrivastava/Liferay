package com.sambaash.platform.product.util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.facebook.FacebookConnectUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.product.wrapper.ProductDetailWrapper;
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
import com.sambaash.platform.srv.model.Outline;
import com.sambaash.platform.srv.model.Persona;
import com.sambaash.platform.srv.model.Product;
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
import com.sambaash.platform.srv.service.OutlineLocalServiceUtil;
import com.sambaash.platform.srv.service.PersonaLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.service.ScheduleLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ThumbnailUtil;

public class ProductDetailUtil {

	private static Log _log = LogFactoryUtil.getLog(ProductDetailUtil.class);

	@SuppressWarnings("unused")
	public static void setDetails(RenderRequest renderRequest, RenderResponse renderResponse) {

		VocabularyUtil vocUtil = new VocabularyUtil();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String spProductId = renderRequest.getParameter("productId");
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		if (Validator.isNull(spProductId)) {
			spProductId = httpRequest.getParameter("productId");
		}
		//Locale prefLocale = Locale.CHINA;//Locale.forLanguageTag("cn","china");//new Locale("china_CN");//LanguageUtil.getLocale("CHINA");
		//prefLocale.getLanguage()
		log("spProductId ProductDetailUtil " + spProductId);
		HashMap<Long, List<String>> outcomeDetailsList = new LinkedHashMap<Long, List<String>>();
		HashMap<Long, List<String>> moduleDetailsList = new LinkedHashMap<Long, List<String>>();
		HashMap<Long, List<String>> competencyDetailsList = new LinkedHashMap<Long, List<String>>();
		HashMap<Long, List<String>> scheduleDetailsList = new LinkedHashMap<Long, List<String>>();
		HashMap<Long, List<String>> outlineDetailsList = new LinkedHashMap<Long, List<String>>();
		HashMap<Long, List<String>> personaDetailsList = new LinkedHashMap<Long, List<String>>();
		HashMap<Long, List<String>> certificateDetailsList = new LinkedHashMap<Long, List<String>>();
		HashMap<Long, List<String>> graduationCriteriaDetailsList = new LinkedHashMap<Long, List<String>>();
		HashMap<Long, List<String>> fundingDetailsList = new LinkedHashMap<Long, List<String>>();
		HashMap<Long, List<String>> feeDetailsList = new LinkedHashMap<Long, List<String>>();
		HashMap<Long, List<String>> miscfeeDetailsList = new LinkedHashMap<Long, List<String>>();
		HashMap<Long, HashMap<Long, List<String>>> selffeeFundList = new LinkedHashMap<Long, HashMap<Long, List<String>>>();
		HashMap<Long, HashMap<Long, List<String>>> mobilefeeFundList = new LinkedHashMap<Long, HashMap<Long, List<String>>>();
		HashMap<Long, HashMap<Long, List<String>>> mobilecompfeeFundList = new LinkedHashMap<Long, HashMap<Long, List<String>>>();
		HashMap<Long, HashMap<Long, List<String>>> compfeeFundList = new LinkedHashMap<Long, HashMap<Long, List<String>>>();
		HashMap<Long, List<String>> frameworkDetailsList = new LinkedHashMap<Long, List<String>>();

		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {

			long spCourseId = 0;
			long groupId = themeDisplay.getScopeGroupId();

			if (Validator.isNotNull(spProductId)) {
				// product detail
				Product product = ProductLocalServiceUtil.getProduct(Long.parseLong(spProductId));
				spCourseId = product.getSpCourseId();
				boolean displayCompetency = false;

				try {
					AssetCategory country = AssetCategoryLocalServiceUtil
							.getAssetCategory(Long.parseLong(product.getCountryId()));
					if ("Singapore".equalsIgnoreCase(country.getName())) {
						displayCompetency = true;
					}
				} catch (Exception e) {
					_log.error(
							LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.country.name.error"));
				}

				List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil
						.getCategories(Product.class.getName(), product.getSpProductId());

				Map<Long, AssetCategory> specCatMap = vocUtil.getSpecializationCategoriesMap(renderRequest);

				StringBuilder sb = null;
				for (AssetCategory assetCategory : assetCategories) {
					if (specCatMap.containsKey(assetCategory.getCategoryId())) {
						if (Validator.isNull(sb)) {
							sb = new StringBuilder();
							sb.append(assetCategory.getName());
						} else {
							sb.append(StringPool.COMMA).append(StringPool.SPACE).append(assetCategory.getName());
						}
					}

				}

				renderRequest.setAttribute("displayCompetency", displayCompetency);

				renderRequest.setAttribute("specialisation",
						Validator.isNotNull(sb) ? sb.toString() : StringPool.BLANK);
				// _log.debug("assetCategories: " + sb.toString());

				// course detail
				Course course = CourseLocalServiceUtil.getCourse(spCourseId);

				// get modules linked to course
				List<CourseModule> cModule = CourseModuleLocalServiceUtil.findByCourseIdAndGroupId(spCourseId, groupId);
				log("cModule " + cModule);
				for (CourseModule courseModule : cModule) {
					// module detail
					Module module = ModuleLocalServiceUtil.getModule(courseModule.getSpModuleId());
					List<String> moduleList = new ArrayList<String>();

					moduleList.add(String.valueOf(module.getSpModuleId()));
					moduleList.add(module.getModuleCode());
					moduleList.add(module.getModuleName());
					if (Validator.isNotNull(module.getCountryId())) {
						moduleList.add(String.valueOf(module.getCountryId()));
					}
					moduleList.add(module.getModuleDesc());
					if (Validator.isNotNull(module.getModuleType())) {
						moduleList.add(String.valueOf(module.getModuleType()));
					}
					if (Validator.isNotNull(module.getCreditValue())) {
						moduleList.add(String.valueOf(module.getCreditValue()));
					}
					if (Validator.isNotNull(module.getModuleDuration())) {
						moduleList.add(String.valueOf(module.getModuleDuration()));
					}
					if (Validator.isNotNull(module.getNoOfSessions())) {
						moduleList.add(String.valueOf(module.getNoOfSessions()));
					}
					// getcompetencies linked to module --> course
					String competencyUnits = StringPool.BLANK;
					String outlineDesc = StringPool.BLANK;
					List<ModuleCompetencyUnit> mCompetency = ModuleCompetencyUnitLocalServiceUtil
							.findByModuleIdAndGroupId(courseModule.getSpModuleId(), groupId);
					for (ModuleCompetencyUnit moduleCompetency : mCompetency) {
						long competencyId = moduleCompetency.getSpCompetencyUnitId();

						// get competency linked to module
						CompetencyUnit competencyunit = CompetencyUnitLocalServiceUtil.getCompetencyUnit(competencyId);

						// competency list for product summary
						List<String> competencyList = new ArrayList<String>();

						competencyList.add(String.valueOf(competencyunit.getSpCompetencyUnitId()));
						competencyList.add(competencyunit.getCompetencyUnitCode());
						competencyList.add(competencyunit.getCompetencyUnitDesc());
						competencyList.add(String.valueOf(moduleCompetency.getSpModuleId()));

						if (Validator.isNotNull(competencyunit.getCompetencyLevel())) {
							competencyList.add(String.valueOf(competencyunit.getCompetencyLevel()));
						}

						if (Validator.isNotNull(competencyunit.getCreditValue())) {
							competencyList.add(String.valueOf(competencyunit.getCreditValue()));
						}
						if (Validator.isNotNull(competencyunit.getJobFamily())) {
							competencyList.add(String.valueOf(competencyunit.getJobFamily()));
						}
						if (Validator.isNotNull(competencyunit.getCountryId())) {
							competencyList.add(String.valueOf(competencyunit.getCountryId()));
						}

						competencyUnits = competencyUnits + "<p>" + competencyunit.getCompetencyUnitCode() + " : "
								+ competencyunit.getCompetencyUnitDesc() + "<p>";

						competencyDetailsList.put(competencyunit.getSpCompetencyUnitId(), competencyList);
						// get outline detail linked to competencyUnit
						List<Outline> outlineListing = OutlineLocalServiceUtil.findByGroupIdAndCompetencyUnitId(groupId,
								competencyId);
						for (Outline outline : outlineListing) {
							String skillsDesc = StringPool.BLANK;
							List<String> outlineList = new ArrayList<String>();
							AssetCategory oAsset = AssetCategoryLocalServiceUtil
									.getAssetCategory(outline.getOutlineType());
							String outlineType = StringPool.BLANK;
							if (Validator.isNotNull(oAsset)) {
								outlineType = oAsset.getName();
							}
							outlineList.add(String.valueOf(competencyunit.getSpCompetencyUnitId()));
							outlineList.add(outlineType);
							outlineList.add(skillsDesc);
							outlineDesc = outlineDesc + "<p>" + outline.getOutlineDesc() + "<p>";
							outlineList.add(outline.getOutlineDesc());
							outlineList.add(String.valueOf(outline.getOutlineType()));
							outlineDetailsList.put(competencyunit.getSpCompetencyUnitId(), outlineList);
						}
					}
					moduleList.add(competencyUnits); // group of competencies
														// for this module
					moduleList.add(outlineDesc); // group of Outline description
													// for the competencies
													// under this module
					// framework details
					List<ModuleFramework> modFrame = ModuleFrameworkLocalServiceUtil
							.findByModuleIdAndGroupId(courseModule.getSpModuleId(), groupId);
					for (ModuleFramework mFrame : modFrame) {
						List<String> frameworkList = new ArrayList<String>();
						Framework frame = FrameworkLocalServiceUtil.getFramework(mFrame.getSpFrameworkId());
						frameworkList.add(frame.getFrameworkCode());
						frameworkList.add(frame.getFrameworkName());
						frameworkDetailsList.put(frame.getSpFrameworkId(), frameworkList);
					}

					// get session & activity details
					List<Schedule> schedule = ScheduleLocalServiceUtil.findByGroupIdAndModuleId(groupId,
							courseModule.getSpModuleId());
					for (Schedule sch : schedule) {
						String activityDesc = StringPool.BLANK;
						List<String> scheduleList = new ArrayList<String>();
						scheduleList.add(sch.getSessionNumber());
						scheduleList.add(sch.getDescription());
						if (Validator.isNotNull(sch.getSpModuleId())) {
							scheduleList.add(String.valueOf(sch.getSpModuleId()));
						}
						List<Activity> activity = ActivityLocalServiceUtil.findByGroupIdAndScheduleId(groupId,
								sch.getSpScheduleId());
						for (Activity actv : activity) {
							List<String> activityList = new ArrayList<String>();
							activityList.add(actv.getDescription());
							activityDesc = activityDesc + actv.getDescription();
						}
						scheduleList.add(activityDesc);
						scheduleDetailsList.put(sch.getSpScheduleId(), scheduleList);
					}

					// get certificate list
					List<ModuleCertificate> moduleCertificate = ModuleCertificateLocalServiceUtil
							.findByModuleIdAndGroupId(courseModule.getSpModuleId(), groupId);
					for (ModuleCertificate mCertificate : moduleCertificate) {
						Certificate certificate = CertificateLocalServiceUtil
								.getCertificate(mCertificate.getSpCertificatetId());
						List<String> certificateList = new ArrayList<String>();
						certificateList.add(certificate.getCertificateCode());
						certificateList.add(certificate.getTitle());
						certificateList.add(certificate.getDescription());
						if (Validator.isNotNull(certificate.getLevel())) {
							certificateList.add(String.valueOf(certificate.getLevel()));
						}
						if (Validator.isNotNull(certificate.getCertificateType())) {
							certificateList.add(String.valueOf(certificate.getCertificateType()));
						}
						certificateList.add(module.getModuleName());
						certificateList.add(module.getGeneralDesc());
						certificateDetailsList.put(certificate.getSpCertificatetId(), certificateList);
					}

					moduleDetailsList.put(module.getSpModuleId(), moduleList);
				}

				List<CourseCertificate> courseCertificateList = CourseCertificateLocalServiceUtil
						.findByCourseIdAndGroupId(spCourseId, groupId);

				for (CourseCertificate courseCertificate : courseCertificateList) {
					List<String> certificateList = new ArrayList<String>();
					Certificate certificate = CertificateLocalServiceUtil
							.getCertificate(courseCertificate.getSpCertificatetId());
					certificateList.add(certificate.getCertificateCode());
					certificateList.add(certificate.getTitle());
					certificateList.add(certificate.getDescription());
					certificateDetailsList.put(certificate.getSpCertificatetId(), certificateList);
				}

				// persona requirements
				List<Persona> persona = PersonaLocalServiceUtil.findByCourseIdAndGroupId(spCourseId, groupId);

				// get who should attend
				for (Persona prsn : persona) {
					List<String> personaList = new ArrayList<String>();

					AssetCategory oAsset = AssetCategoryLocalServiceUtil.getAssetCategory(prsn.getPersonaType());
					personaList.add(GetterUtil.get(oAsset.getName(), StringPool.BLANK));
					personaList.add(prsn.getPersonaDesc());
					personaList.add(GetterUtil.get(String.valueOf(prsn.getPersonaImageId()), StringPool.BLANK));
					personaList.add(String.valueOf(prsn.getSpPersonaId()));
					personaList.add(Validator.isNotNull(prsn.getPersonaImageId()) && prsn.getPersonaImageId() > 0
							? (ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(prsn.getPersonaImageId()),
									themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
									themeDisplay.getPathContext(), 4))
							: renderRequest.getContextPath() + "/images/product/Early_career.png");
					personaDetailsList.put(prsn.getSpPersonaId(), personaList);
				}

				// course outcome
				List<CourseOutcome> outcome = CourseOutcomeLocalServiceUtil.findByCourseIdAndGroupId(spCourseId,
						groupId);
				// add outcomes to a list to send it to product wrapper
				for (CourseOutcome outcomeD : outcome) {
					List<String> outcomeList = new ArrayList<String>();
					AssetCategory oAsset = AssetCategoryLocalServiceUtil.getAssetCategory(outcomeD.getOutcomeId());
					String outcomeType = StringPool.BLANK;
					String outcomeImage = StringPool.BLANK;
					if (Validator.isNotNull(oAsset)) {
						outcomeType = oAsset.getName();
						outcomeImage = oAsset.getDescription(themeDisplay.getLocale());
						log("outcomeImage : " + outcomeImage);
					}
					outcomeList.add(outcomeType);
					outcomeList.add(outcomeD.getOutcomeDesc());
					outcomeList.add(outcomeImage);
					outcomeDetailsList.put(outcomeD.getSpCourseOutcomeId(), outcomeList);
				}

				// get Grad requirements
				List<GraduationCriteria> gradCriteria = GraduationCriteriaLocalServiceUtil
						.findByCourseIdAndGroupId(spCourseId, groupId);
				for (GraduationCriteria gCriteria : gradCriteria) {
					List<String> graduationCriteriaList = new ArrayList<String>();
					graduationCriteriaList.add(gCriteria.getCriteriaDesc());
					graduationCriteriaList.add(gCriteria.getCriteriaValueRange());
					if (Validator.isNotNull(gCriteria.getCriteriaType())) {
						graduationCriteriaList.add(String.valueOf(gCriteria.getCriteriaType()));
					}
					if (Validator.isNotNull(gCriteria.getCriteriaLevel())) {
						graduationCriteriaList.add(String.valueOf(gCriteria.getCriteriaLevel()));
					}
					graduationCriteriaDetailsList.put(gCriteria.getSpGraduationCriteriaId(), graduationCriteriaList);
				}

				String currencyCode = "SGD";

				try {
					Country country = CountryServiceUtil.getCountryByName(AssetCategoryLocalServiceUtil
							.getAssetCategory(Long.parseLong(course.getCountryId())).getName().toLowerCase());
					Locale locale = new Locale("", country.getA2());
					currencyCode = Currency.getInstance(locale).getCurrencyCode();
					log(currencyCode);
				} catch (Exception e) {
					_log.error(
							LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.currency.error"));
				}

				renderRequest.setAttribute("currencyCode", currencyCode);
				int totalCnt = 0;
				int cmptotalCnt = 0;
				try {
					// get non-funded fee details
					List<FeeDetails> feeDetail = FeeDetailsLocalServiceUtil.findByFundIdAndSpCourseId(0, spCourseId);
					renderRequest.setAttribute("feeDetailCount", feeDetail.size());
					for (FeeDetails fees : feeDetail) {
						List<String> feesList = new ArrayList<String>();
						long feeType = fees.getFeeType();
						log("feeType @@@ " + feeType + " spCourseId " + spCourseId);
						String feesType = StringPool.BLANK;
						try {
							FeeType feeTyp = FeeTypeLocalServiceUtil.getFeeType(feeType);
							if (Validator.isNotNull(feeTyp)) {
								feesType = feeTyp.getFeeTypeName();
							}
							feesList.add(feesType);
							if (Validator.isNotNull(fees.getAmount())) {
								feesList.add(String.valueOf(fees.getAmount()));
							}
							feesList.add(fees.getFeeDesc());
							feeDetailsList.put(fees.getSpFeeDetailsId(), feesList);
						} catch (Exception e) {
							_log.error(LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.feedetails.get.error") + e.getMessage());
						}
					}
					// get self Fee funding details
					boolean isHasSelfSpnsrNotes = true;
					String selfSpnsrNotes = StringPool.BLANK;
					boolean isHasCompSpnsrNotes = true;
					String compSpnsrNotes = StringPool.BLANK;
					List<Funding> funding = FundingLocalServiceUtil.findByCourseIdAndGroupId(spCourseId, groupId);
					HashMap<Long, List<String>> selffeeFundDetailsList = new LinkedHashMap<Long, List<String>>();
					HashMap<Long, List<String>> compfeeFundDetailsList = new LinkedHashMap<Long, List<String>>();
					long feeDetailSelfSize = 0;
					for (Funding fund : funding) {
						List<String> fundingList = new ArrayList<String>();

						List<FeeDetails> feeDetailSelf = FeeDetailsLocalServiceUtil
								.findByFundIdAndSpCourseId(fund.getSpFundingId(), spCourseId);
						renderRequest.setAttribute("feeTypeCount", feeDetailSelf.size());
						long feeFundId = 0;

						for (FeeDetails fees : feeDetailSelf) {
							List<FeeDetails> feeDetailType = FeeDetailsLocalServiceUtil
									.findByFeeTypeAndCourseId(fees.getFeeType(), spCourseId);
							feeDetailSelfSize = feeDetailSelf.size();
							renderRequest.setAttribute("selFeeListSize", (feeDetailSelf.size()) - 1);
							List<String> feesList = new ArrayList<String>();
							List<String> compFeesList = new ArrayList<String>();
							for (FeeDetails fees1 : feeDetailType) {

								if (fees1.getFundId() > 0) {
									Funding feeFund = FundingLocalServiceUtil.getFunding(fees1.getFundId());

									String selfSpnIdValue = SambaashUtil.getParameter(
											SPProductConstants.SELF_SPONSOR_ID, themeDisplay.getScopeGroupId());
									long selfSpnId = 0;
									if (Validator.isNotNull(selfSpnIdValue)) {
										selfSpnId = Long.parseLong(selfSpnIdValue);
									}
									if (feeFund.getSponsoredBy() == selfSpnId) {
										long feeType = fees.getFeeType();
										List<Funding> selfFund = FundingLocalServiceUtil
												.findBySponsorByCourseId(spCourseId, selfSpnId);
										totalCnt = selfFund.size();
										String residentialStatus = getResidentStatus(0, feeFund.getResidenceStatus(),
												feeFund.getAgeOperator(), feeFund.getAge(), feeFund.getSalaryOperator(),
												feeFund.getSalary());

										FeeType feeTyp = FeeTypeLocalServiceUtil.getFeeType(feeType);
										if (Validator.isNotNull(feeTyp)) {
											feesList.add(residentialStatus);
											feesList.add(feeFund.getFundingDesc());
											feesList.add(String.valueOf(feeTyp.getFeeTypeName()));
											selfSpnsrNotes = feeFund.getFundingDesc() + selfSpnsrNotes;

											feesList.add(String.valueOf(fees1.getAmount()));
											selffeeFundDetailsList.put(fees.getFeeType(), feesList);
										}

										selffeeFundList.put(feeFundId, selffeeFundDetailsList);

									}
									// totalCnt = totalCnt+1;
									// for comp fee funding list
									String nonsmeSpnIdValue = SambaashUtil.getParameter(
											SPProductConstants.NONSME_SPONSOR_ID, themeDisplay.getScopeGroupId());
									long nonsmeSpnId = 0;
									if (Validator.isNotNull(nonsmeSpnIdValue)) {
										nonsmeSpnId = Long.parseLong(nonsmeSpnIdValue);
									}
									String smeSpnIdValue = SambaashUtil.getParameter(SPProductConstants.SME_SPONSOR_ID,
											themeDisplay.getScopeGroupId());
									long smeSpnId = 0;
									if (Validator.isNotNull(smeSpnIdValue)) {
										smeSpnId = Long.parseLong(smeSpnIdValue);
									}
									if (feeFund.getSponsoredBy() == nonsmeSpnId
											|| feeFund.getSponsoredBy() == smeSpnId) {
										long feeType = fees.getFeeType();
										List<Funding> smeFund = FundingLocalServiceUtil
												.findBySponsorByCourseId(spCourseId, smeSpnId);
										List<Funding> nsmeFund = FundingLocalServiceUtil
												.findBySponsorByCourseId(spCourseId, nonsmeSpnId);

										int sme = (int) smeFund.size();
										int nsme = (int) nsmeFund.size();
										cmptotalCnt = sme + nsme;
										String residentialStatus = getResidentStatus(feeFund.getSponsoredBy(),
												feeFund.getResidenceStatus(), feeFund.getAgeOperator(),
												feeFund.getAge(), feeFund.getSalaryOperator(), feeFund.getSalary());

										FeeType feeTyp = FeeTypeLocalServiceUtil.getFeeType(feeType);
										if (Validator.isNotNull(feeTyp)) {
											compFeesList.add(residentialStatus);
											compFeesList.add(feeFund.getFundingDesc());
											compSpnsrNotes = feeFund.getFundingDesc() + compSpnsrNotes;
											compFeesList.add(String.valueOf(feeTyp.getFeeTypeName()));
											compFeesList.add(String.valueOf(fees1.getAmount()));
											compfeeFundDetailsList.put(fees.getFeeType(), compFeesList);
										}

										compfeeFundList.put(feeFundId, compfeeFundDetailsList);
										// cmptotalCnt = cmptotalCnt+1;
									}

								}
							}

						}

						fundingList.add(fund.getAbsenteePayroll());
						fundingDetailsList.put(fund.getSpFundingId(), fundingList);
					}

					renderRequest.setAttribute("compfeeFundListIsEmpty", compfeeFundList.isEmpty());
					renderRequest.setAttribute("selffeeFundListIsEmpty", selffeeFundList.isEmpty());
					int finatCount = 11;
					// _log.error("totalCnt size $$$$$$@@@@@!!!! " + cmptotalCnt
					// + " finatCount " + finatCount);
					if (totalCnt > 3 && totalCnt <= 6) {
						finatCount = 12;
					} else if (totalCnt > 6) {
						finatCount = 23;
					}
					renderRequest.setAttribute("totalCnt", finatCount);
					finatCount = 11;
					if (cmptotalCnt > 3 && cmptotalCnt <= 6) {
						finatCount = 12;
					} else if (cmptotalCnt > 6) {
						finatCount = 23;
					}
					renderRequest.setAttribute("cmptotalCnt", finatCount);

					if (compSpnsrNotes.isEmpty() && Validator.isNull(course.getFundingDescPost())) {
						isHasCompSpnsrNotes = false;
					} else {
						isHasCompSpnsrNotes = true;
					}

					if (selfSpnsrNotes.isEmpty() && Validator.isNull(course.getFundingDescPost())) {
						isHasSelfSpnsrNotes = false;
					}
					renderRequest.setAttribute("isHasCompSpnsrNotes", isHasCompSpnsrNotes);
					renderRequest.setAttribute("isHasSelfSpnsrNotes", isHasSelfSpnsrNotes);
					for (Funding fund : funding) {
						List<FeeDetails> feeDetailSelf = FeeDetailsLocalServiceUtil
								.findByFundIdAndSpCourseId(fund.getSpFundingId(), spCourseId);
						HashMap<Long, List<String>> mobilefeeFundDetailsList = new LinkedHashMap<Long, List<String>>();
						HashMap<Long, List<String>> mobilecompfeeFundDetailsList = new LinkedHashMap<Long, List<String>>();
						for (FeeDetails feesDet : feeDetailSelf) {
							if (feesDet.getFundId() > 0) {
								List<FeeDetails> feesDetail = FeeDetailsLocalServiceUtil
										.findByFundIdAndSpCourseId(feesDet.getFundId(), spCourseId);
								long feeInstId = 0;
								Funding mobFund = FundingLocalServiceUtil.getFunding(feesDet.getFundId());
								String selfSpnIdValue1 = SambaashUtil.getParameter(SPProductConstants.SELF_SPONSOR_ID,
										themeDisplay.getScopeGroupId());
								String nonSmeSpnIdValue1 = SambaashUtil.getParameter(
										SPProductConstants.NONSME_SPONSOR_ID, themeDisplay.getScopeGroupId());
								String smeSpnIdValue1 = SambaashUtil.getParameter(SPProductConstants.SME_SPONSOR_ID,
										themeDisplay.getScopeGroupId());
								long selfSpnId1 = 0;
								long nonsmeSpnId1 = 0;
								long smeSpnId1 = 0;
								if (Validator.isNotNull(selfSpnIdValue1)) {
									selfSpnId1 = Long.parseLong(selfSpnIdValue1);
								}
								if (Validator.isNotNull(nonSmeSpnIdValue1)) {
									nonsmeSpnId1 = Long.parseLong(nonSmeSpnIdValue1);
								}
								if (Validator.isNotNull(smeSpnIdValue1)) {
									smeSpnId1 = Long.parseLong(smeSpnIdValue1);
								}
								String residentialStatus = getResidentStatus(0, mobFund.getResidenceStatus(),
										mobFund.getAgeOperator(), mobFund.getAge(), mobFund.getSalaryOperator(),
										mobFund.getSalary());
								if (mobFund.getSponsoredBy() == selfSpnId1) {
									for (FeeDetails feesmob : feesDetail) {
										feeInstId = feesmob.getFundId();
										List<String> feesListMobileDet = new ArrayList<String>();
										long feeType = feesmob.getFeeType();
										FeeType feeTyp1 = FeeTypeLocalServiceUtil.getFeeType(feeType);
										feesListMobileDet.add(residentialStatus);
										feesListMobileDet.add(mobFund.getFundingDesc());
										feesListMobileDet.add(feeTyp1.getFeeTypeName());
										feesListMobileDet.add(String.valueOf(feesmob.getAmount()));
										mobilefeeFundDetailsList.put(feesmob.getFeeType(), feesListMobileDet);
									}
									mobilefeeFundList.put(feeInstId, mobilefeeFundDetailsList);
								}

								String residentialStatus1 = getResidentStatus(mobFund.getSponsoredBy(),
										mobFund.getResidenceStatus(), mobFund.getAgeOperator(), mobFund.getAge(),
										mobFund.getSalaryOperator(), mobFund.getSalary());
								if (mobFund.getSponsoredBy() == nonsmeSpnId1 || mobFund.getSponsoredBy() == smeSpnId1) {
									for (FeeDetails feesmob : feesDetail) {
										feeInstId = feesmob.getFundId();
										List<String> compfeesListMobileDet = new ArrayList<String>();
										long feeType = feesmob.getFeeType();
										FeeType feeTyp1 = FeeTypeLocalServiceUtil.getFeeType(feeType);
										compfeesListMobileDet.add(residentialStatus1);
										compfeesListMobileDet.add(mobFund.getFundingDesc());
										compfeesListMobileDet.add(feeTyp1.getFeeTypeName());
										compfeesListMobileDet.add(String.valueOf(feesmob.getAmount()));
										mobilecompfeeFundDetailsList.put(feesmob.getFeeType(), compfeesListMobileDet);
									}
									mobilecompfeeFundList.put(feeInstId, mobilecompfeeFundDetailsList);
								}

							}
						}
					}
					renderRequest.setAttribute("mobilefeeFundListIsEmpty", mobilefeeFundList.isEmpty());
					renderRequest.setAttribute("mobilecompfeeFundListIsEmpty", mobilecompfeeFundList.isEmpty());
					// get miscellaneous fee details
					List<MiscellaneousFees> miscFeeDetail = MiscellaneousFeesLocalServiceUtil
							.findByCourseIdAndGroupId(spCourseId, groupId);
					for (MiscellaneousFees miscFees : miscFeeDetail) {
						List<String> miscFeesList = new ArrayList<String>();
						long feeType = miscFees.getMiscFeeType();
						String feesType = StringPool.BLANK;

						FeeType feeTyp = FeeTypeLocalServiceUtil.getFeeType(feeType);
						if (Validator.isNotNull(feeTyp)) {
							feesType = feeTyp.getFeeTypeName();
						}
						miscFeesList.add(feesType);
						AssetCategory asset = AssetCategoryLocalServiceUtil.getAssetCategory(miscFees.getPayable());
						String remarks = asset.getName();

						if (Validator.isNotNull(miscFees.getAmount())) {
							remarks = String.format("%.2f", miscFees.getAmount()) + StringPool.SPACE + StringPool.DASH
									+ StringPool.SPACE + remarks;
						}
						miscFeesList.add(remarks);
						miscfeeDetailsList.put(miscFees.getSpMiscFeesId(), miscFeesList);
					}
					renderRequest.setAttribute("miscfeeDetailsListIsEmpty", miscfeeDetailsList.isEmpty());
				} catch (Exception e) {
					_log.error(e);
				}
				ProductDetailWrapper productWrapper = new ProductDetailWrapper(product, course, outcomeDetailsList,
						moduleDetailsList, scheduleDetailsList, outlineDetailsList, personaDetailsList,
						graduationCriteriaDetailsList, certificateDetailsList, feeDetailsList, miscfeeDetailsList,
						selffeeFundList, compfeeFundList, mobilefeeFundList, mobilecompfeeFundList, fundingDetailsList,
						competencyDetailsList, frameworkDetailsList);
				log("productWrapper " + productWrapper);
				renderRequest.setAttribute("productWrapper", productWrapper);

				SPLearningUtil.loadLearningDetailsViewPage(renderRequest, spCourseId);
				SPCareerUtil.loadCareerDetailsViewPage(renderRequest, spCourseId);

				// Add SEO properties
				try {
					HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
					PortalUtil.setPageSubtitle(HtmlUtil.stripHtml(product.getProductName()), request);
					PortalUtil.setPageDescription(HtmlUtil.stripHtml(course.getCourseDesc()), request);
					PortalUtil.setPageKeywords(Validator.isNotNull(sb) ? sb.toString() : StringPool.BLANK, request);
					PortalUtil.addPortletBreadcrumbEntry(request, product.getProductName(),
							themeDisplay.getURLCurrent());

					renderRequest.setAttribute("ogtitle", product.getProductName());
					renderRequest.setAttribute("ogdescription", HtmlUtil.stripHtml(course.getCourseDesc()));
					renderRequest.setAttribute("ogurl", URLEncoder.encode(themeDisplay.getPortalURL() + themeDisplay.getURLCurrent(), "UTF-8"));
					renderRequest.setAttribute("fbappid",FacebookConnectUtil.getAppId(themeDisplay.getCompanyId()));
					
					String imgUrl = StringPool.BLANK;
					if (product.getProductImageId() > 0) {
						imgUrl = ThumbnailUtil.getThumbnailUrl(
								DLAppServiceUtil.getFileEntry(product.getProductImageId()),
								themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
								themeDisplay.getPathContext(), 2);
						renderRequest.setAttribute("og-image", imgUrl);
					}
					

					_log.error("productUrl : " + URLEncoder.encode(themeDisplay.getPortalURL() + themeDisplay.getURLCurrent(), "UTF-8"));
				} catch (Exception e) {
					_log.error("seo error " + e.getMessage());
				}

			}

		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static String getResidentStatus(long sponsor, String resdStatus, String ageOperator, double age,
			String salOperator, double salary) {

		String[] rStatus = resdStatus.split(StringPool.COMMA);
		String residentialStatus = StringPool.BLANK;
		String sponsorName = StringPool.BLANK;
		String ageCtriteria = getAgeCreiteria(ageOperator, age);
		String salaryCtriteria = getSalaryCreiteria(salOperator, salary);

		if (Validator.isNotNull(sponsor)) {
			try {
				AssetCategory sponsorAsset = AssetCategoryLocalServiceUtil.getAssetCategory(sponsor);
				sponsorName = sponsorAsset.getName();
			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}
		}

		for (int r = 0; r < rStatus.length; r++) {
			if (!rStatus[r].isEmpty()) {
				if (!rStatus[r].equalsIgnoreCase("NA")) {
					if (Long.parseLong(rStatus[r]) > 0) {
						AssetCategory residentialStatusAsset = null;
						try {
							residentialStatusAsset = AssetCategoryLocalServiceUtil
									.getAssetCategory(Long.parseLong(rStatus[r]));
							if (r == 0) {
								residentialStatus = residentialStatusAsset.getName();
							} else {
								residentialStatus = residentialStatus + " & " + residentialStatusAsset.getName();
							}
						} catch (NumberFormatException e) {
							_log.error(e);
						} catch (PortalException e) {
							_log.error(e);
						} catch (SystemException e) {
							_log.error(e);
						}
					}
				}
			}
		}
		if (!residentialStatus.isEmpty() && !sponsorName.isEmpty()) {
			residentialStatus = sponsorName + " & " + residentialStatus + StringPool.SPACE + ageCtriteria;
		} else if (residentialStatus.isEmpty()) {
			residentialStatus = sponsorName + StringPool.SPACE + ageCtriteria;
		} else if (sponsorName.isEmpty()) {
			residentialStatus = residentialStatus + StringPool.SPACE + ageCtriteria;
		}
		if (!salaryCtriteria.isEmpty()) {
			residentialStatus = residentialStatus + StringPool.SPACE + salaryCtriteria;
		}
		return residentialStatus;
	}

	private static String getSalaryCreiteria(String salOperator, double salary) {
		// TODO Auto-generated method stub
		String salCtriteria = StringPool.BLANK;
		String salOprVal = StringPool.BLANK;

		if (salOperator.equals("0") || salOperator.equals("")) {
			salOprVal = "";
		} else if (salOperator.equals("gt")) {
			salOprVal = ">";
		} else if (salOperator.equals("lt")) {
			salOprVal = "<";
		} else if (salOperator.equals("ge")) {
			salOprVal = ">=";
		} else if (salOperator.equals("le")) {
			salOprVal = "<=";
		} else if (salOperator.equals("eq")) {
			salOprVal = "=";
		}
		if (salary != 0) {
			salCtriteria = " & earning " + salOprVal + StringPool.SPACE + String.format("%.2f", salary) + "/month";
		}
		return salCtriteria;
	}

	private static String getAgeCreiteria(String ageOperator, double age) {
		// TODO Auto-generated method stub
		String ageCtriteria = StringPool.BLANK;
		String ageOprVal = StringPool.BLANK;
		if (ageOperator.equals("0") || ageOperator.equals("")) {
			ageOprVal = "";
		} else if (ageOperator.equals("gt")) {
			ageOprVal = ">";
		} else if (ageOperator.equals("lt")) {
			ageOprVal = "<";
		} else if (ageOperator.equals("ge")) {
			ageOprVal = ">=";
		} else if (ageOperator.equals("le")) {
			ageOprVal = "<=";
		} else if (ageOperator.equals("eq")) {
			ageOprVal = "=";
		}
		if (Validator.isNotNull(age)) {
			if (age > 0) {
				ageCtriteria = "Age " + ageOprVal + StringPool.SPACE + (int) age;
			}
		}

		return ageCtriteria;
	}

	private static void log(String message) {
		if (_log.isDebugEnabled()) {
			_log.debug(message);
		}
	}

}
