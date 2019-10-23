package com.sambaash.platform.product.util;

import static com.sambaash.platform.product.util.SPProductConstants.COURSE_PAYMENT_ENABLED_PARAM;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.platform.product.permissions.ProductPermissionsUtil;
import com.sambaash.platform.srv.NoSuchProductException;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPShoppingLocalServiceUtil;
import com.sambaash.platform.util.DateUtils;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SPProductUtil {

	private static Log _log = LogFactoryUtil.getLog(SPProductUtil.class);
	private static final long CLASS_NAME_ID = ClassNameLocalServiceUtil.getClassNameId(Product.class);

	public static JSONObject addProduct(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		try {
			_log.error("Adding ProductUtil");
			long productId = GetterUtil.getLong(resourceRequest.getParameter("spProductId"));
			boolean hasPermission = false;
			if (productId > 0) {
				// update permission check
				hasPermission = ProductPermissionsUtil.hasUpdatePermission(themeDisplay);
			} else {
				// create permission check
				hasPermission = ProductPermissionsUtil.hasAddPermission(themeDisplay);
			}

			if (!hasPermission) {
				response.put("error",
						LabelUtil.getLabel(portletConfig, themeDisplay, "label.product.noauth.add.product"));
				return response;
			}
			String productName = resourceRequest.getParameter("productName");
			String specializationArray[] = resourceRequest.getParameterValues("specializationArray");
			String personaArray[] = null;
			String countryId = resourceRequest.getParameter("country");
			String creditValue = resourceRequest.getParameter("creditValue");

			// check for uniqueness
			try {
				Product exisitng = ProductLocalServiceUtil.findByProductNameCountryId(productName, countryId);
				if (exisitng.getSpProductId() != productId) {
					AssetCategory country = AssetCategoryLocalServiceUtil.getCategory(GetterUtil.getLong(countryId));
					response.put("error",
							LabelUtil.getLabel(portletConfig, themeDisplay, "label.product.noauth.add.product")
									+ productName
									+ LabelUtil.getLabel(portletConfig, themeDisplay,
											"label.product.product.country.exist")
									+ country.getName()
									+ LabelUtil.getLabel(portletConfig, themeDisplay, "label.product.unique.product"));
					return response;
				}
			} catch (NoSuchProductException ex) {
				// does not exist .. so fine
			} catch (Exception ex) {
				response.put("error",
						LabelUtil.getLabel(portletConfig, themeDisplay, "label.product.create.save.error"));
				return response;
			}

			String courseId = resourceRequest.getParameter("course");
			String tempFileEntryId = resourceRequest.getParameter("tempFileEntryId");
			String productVideosFolderId = resourceRequest.getParameter("productVideosFolderId");
			String productBrochuresFolderId = resourceRequest.getParameter("productBrochuresFolderId");
			_log.error("productVideosFolderId : " + productVideosFolderId + " : productBrochuresFolderId : "
					+ productBrochuresFolderId + " countryId " + countryId);

			String prodcutTemplate = resourceRequest.getParameter("templateName");
			String templateLanguageList = resourceRequest.getParameter("templateLanguage");
			String tempFormImageFileEntryId = resourceRequest.getParameter("tempFormImageFileEntryId");
			String tempBannerImageFileEntryId = resourceRequest.getParameter("tempBannerImageFileEntryId");
			String isRegistrationEnabled = resourceRequest.getParameter("isRegistrationEnabled");
			String isBannerDetailsEnabled = resourceRequest.getParameter("isBannerDetailsEnabled");
			String isSamePageRegistration = resourceRequest.getParameter("isSamePageRegistration");
			String productFormName = resourceRequest.getParameter("productFormName");
			String formButtonName = resourceRequest.getParameter("formButtonName");
			String formurl = resourceRequest.getParameter("formurl");

			Product product = null;

			if (productId > 0) {
				product = ProductLocalServiceUtil.fetchProduct(productId);
				product.setModifiedDate(DateUtil.newDate());
			} else {
				long spProductId = CounterLocalServiceUtil.increment("Product.class");
				product = ProductLocalServiceUtil.createProduct(spProductId);
				product.setStatus(Status.CREATED.getCode());
				product.setCreateDate(DateUtil.newDate());
			}

			product.setGroupId(themeDisplay.getScopeGroupId());
			product.setUserId(themeDisplay.getUser().getUserId());
			product.setUserName(themeDisplay.getUser().getFullName());
			product.setCompanyId(themeDisplay.getCompanyId());
			product.setProductName(productName);
			product.setCountryId(countryId);
			product.setPEProcessId(ParamUtil.getLong(resourceRequest, "PEProcessId"));
			product.setProductFormName(productFormName);
			product.setProductFormButtonName(formButtonName);
			product.setProductFormUrl(formurl);
			product.setProductTemplateName(prodcutTemplate);
			product.setProductTemplateLanguage(templateLanguageList);
			product.setRegistrationEnabled(isRegistrationEnabled);
			product.setBannerDetailsEnabled(isBannerDetailsEnabled);
			product.setSamePageRegistration(isSamePageRegistration);

			if (Validator.isNumber(creditValue)) {
				product.setCreditValues(Long.parseLong(creditValue));
			}

			boolean personaEnabled = GetterUtil
					.getBoolean(resourceRequest.getPreferences().getValue(SPProductConstants.SHOW_PERSONA, ""));
			if (personaEnabled) {
				personaArray = resourceRequest.getParameterValues("personaArray");
			} else {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(Product.class.getName(),
						product.getSpProductId());
				if (Validator.isNotNull(assetEntry)) {
					long categoryIds[] = assetEntry.getCategoryIds();
					long personaVocabId = GetterUtil
							.getLong(SambaashUtil.getParameter(SPProductConstants.PERSONA_VOCABULARY_ID, 0));
					List<AssetCategory> personaListAssetCatList = AssetCategoryLocalServiceUtil
							.getVocabularyCategories(0, personaVocabId, -1, -1, null);

					List<String> personaList = new ArrayList<String>();

					for (long categoryId : categoryIds) {
						for (AssetCategory personaListAssetCat : personaListAssetCatList) {
							if (personaListAssetCat.getCategoryId() == categoryId) {
								personaList.add(String.valueOf(categoryId));
							}
						}
					}

					personaArray = new String[personaList.size()];
					personaArray = personaList.toArray(personaArray);
				}

			}

			if (specializationArray != null && personaArray != null) {
				AssetUtil.updateAsset(product.getUserId(), product.getGroupId(), Product.class.getName(),
						product.getSpProductId(),
						ArrayUtil.append(ArrayUtil.append(specializationArray, personaArray), countryId), null);
			} else if (personaArray == null) {
				AssetUtil.updateAsset(product.getUserId(), product.getGroupId(), Product.class.getName(),
						product.getSpProductId(), ArrayUtil.append(specializationArray, countryId), null);
			}

			if (Validator.isNumber(tempFileEntryId)) {
				if (Long.parseLong(tempFileEntryId) > 0) {
					FileUtil.moveFile(resourceRequest, themeDisplay, product.getSpProductId(),
							Long.parseLong(tempFileEntryId), FileUtil.getRootFolder(themeDisplay).getFolderId(),
							SPProductConstants.PRODUCT_FOLDER);
					product.setProductImageId(Long.parseLong(tempFileEntryId));
				}
			}

			if (Validator.isNumber(productVideosFolderId)) {
				if (Long.parseLong(productVideosFolderId) > 0) {
					FileUtil.moveFolder(resourceRequest, themeDisplay, String.valueOf(product.getSpProductId()),
							Long.parseLong(productVideosFolderId), SPProductConstants.PRODUCT_VIDEO_FOLDER,
							SPProductConstants.PRODUCT_FOLDER);
					product.setProductVideoFolderId(Long.parseLong(productVideosFolderId));
				}
			}

			if (Validator.isNumber(productBrochuresFolderId)) {
				if (Long.parseLong(productBrochuresFolderId) > 0) {
					FileUtil.moveFolder(resourceRequest, themeDisplay, String.valueOf(product.getSpProductId()),
							Long.parseLong(productBrochuresFolderId), SPProductConstants.PRODUCT_BROUCHERS_FOLDER,
							SPProductConstants.PRODUCT_FOLDER);
					product.setProductBrochuresFolderId(Long.parseLong(productBrochuresFolderId));
				}
			}

			if (Validator.isNumber(courseId)) {
				product.setSpCourseId(Long.parseLong(courseId));
			}

			if (Validator.isNumber(tempFormImageFileEntryId)) {
				if (Long.parseLong(tempFormImageFileEntryId) > 0) {
					FileUtil.moveFile(resourceRequest, themeDisplay, product.getSpProductId(),
							Long.parseLong(tempFormImageFileEntryId),
							FileUtil.getRootFolder(themeDisplay).getFolderId(), SPProductConstants.PRODUCT_FOLDER);
					product.setProductFormImageId(Long.parseLong(tempFormImageFileEntryId));
				} else {
					product.setProductFormImageId(Long.parseLong(tempFormImageFileEntryId));
				}
			}

			if (Validator.isNumber(tempBannerImageFileEntryId)) {
				if (Long.parseLong(tempBannerImageFileEntryId) > 0) {
					FileUtil.moveFile(resourceRequest, themeDisplay, product.getSpProductId(),
							Long.parseLong(tempBannerImageFileEntryId),
							FileUtil.getRootFolder(themeDisplay).getFolderId(), SPProductConstants.PRODUCT_FOLDER);
					product.setProductBannerImageId(Long.parseLong(tempBannerImageFileEntryId));
				} else {
					product.setProductBannerImageId(Long.parseLong(tempBannerImageFileEntryId));
				}
			}

			ProductLocalServiceUtil.updateProduct(product);

			ProductLocalServiceUtil.clearCache();

			response.put("spProductId", product.getSpProductId());
			return response.put("saveFlag", "success");

		} catch (Exception e) {
			response.put("error", LabelUtil.getLabel(portletConfig, themeDisplay, "label.product.create.save.error"));
			_log.error(e);
		}

		response.put("saveFlag", "error");

		return response;

	}

	public static JSONObject addProductInventory(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		// SPShoppingLocalserviceUtil.addProductInventory();
		JSONObject response = JSONFactoryUtil.createJSONObject();
		String spProductId = resourceRequest.getParameter("spProductId");
		String hasInventory = resourceRequest.getParameter("hasInventory");
		if (hasInventory.equalsIgnoreCase("on")) {
			hasInventory = "true";
		} else {
			hasInventory = "false";
		}
		String critInstancesCount = resourceRequest.getParameter("critInstancesCount");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_log.error("productId " + spProductId + " critInstancesCount " + critInstancesCount);

		if (Validator.isNotNull(spProductId)) {
			long productId = Long.parseLong(spProductId);
			String productName = StringPool.BLANK;
			String productCode = StringPool.BLANK;
			String productDesc = StringPool.BLANK;
			long remainingInventory = 0;

			try {
				Product product = ProductLocalServiceUtil.getProduct(productId);
				productName = product.getProductName();
				productCode = SPProductUtil.getProductItemCode(product.getSpProductId());
				productDesc = product.getProductDesc();
				product.setHasInventory(Boolean.parseBoolean(hasInventory));
				Product product1 = ProductLocalServiceUtil.updateProduct(product);
				if (Boolean.parseBoolean(hasInventory)) {
					for (int i = 0; i < Long.parseLong(critInstancesCount); i++) {
						String quantityVal = ParamUtil.getString(resourceRequest, "inventoryValue" + i);
						String sDate = ParamUtil.getString(resourceRequest, "startDateVal" + i);
						String eDate = ParamUtil.getString(resourceRequest, "endDateVal" + i);
						String sellingIdVal = ParamUtil.getString(resourceRequest, "sellingId" + i);
						_log.error("sDate " + sDate + " eDate " + eDate);
						int quantity = 0;
						int sellingId = 0;
						DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
						if (Validator.isNull(quantity) && Validator.isNull(sDate) && Validator.isNull(eDate)) {
							_log.error("Will skip the saving of Feedetail instance as it is empty.");
						} else {
							Date startDate = null;
							Date endDate = null;
							try {
								if (Validator.isNotNull(sDate)) {
									startDate = format.parse(sDate);
								}

								if (Validator.isNotNull(eDate)) {
									endDate = format.parse(eDate);
								}
							} catch (ParseException e) {
								_log.error(e.getMessage());
							}
							if (Validator.isNotNull(quantityVal)) {
								quantity = Integer.parseInt(quantityVal);
							}
							if (Validator.isNotNull(sellingIdVal)) {
								sellingId = Integer.parseInt(sellingIdVal);
							}
							_log.error("startDate " + startDate + " endDate " + endDate);
							long productSellingId = SPShoppingLocalServiceUtil.addProductCatalog(
									themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(),
									themeDisplay.getUserId(), themeDisplay.getUser().getFullName(), CLASS_NAME_ID,
									productId, productName, productCode, productDesc, productName);

							SPShoppingLocalServiceUtil.addProductInventory(themeDisplay.getCompanyId(),
									themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
									themeDisplay.getUser().getFullName(), CLASS_NAME_ID, productId, startDate, endDate,
									quantity);
							remainingInventory = SPShoppingLocalServiceUtil.retrieveRemainingInventory(CLASS_NAME_ID,
									productId);
						}
					}
				}
				response.put("remainingInventory", remainingInventory);
				response.put("saveFlag", "success");
			} catch (PortalException e) {
				response.put("saveFlag", "error");
				_log.error(e.getMessage());
			} catch (SystemException e) {
				response.put("saveFlag", "error");
				_log.error(e.getMessage());
			}
		}

		return response;
	}

	public static JSONArray getProductInventoryDetail(long classNameId, long classPk) {
		JSONArray result = SPShoppingLocalServiceUtil.retrieveProductInventory(classNameId, classPk);
		return result;

	}

	public static JSONObject publish(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		if (!ProductPermissionsUtil.hasPublishPermission(themeDisplay)) {
			response.put("error",
					LabelUtil.getLabel(portletConfig, themeDisplay, "label.product.noauth.publish.product"));
			return response;
		}
		String productId = resourceRequest.getParameter("spProductId");
		try {
			if (Validator.isNumber(productId)) {
				Product product = ProductLocalServiceUtil.fetchProduct(Long.parseLong(productId));
				product.setStatus(Status.PUBLISH.getCode());
				product.setModifiedDate(DateUtil.newDate());
				ProductLocalServiceUtil.updateProduct(product);
				return response.put("saveFlag", "success");
			}
		} catch (Exception e) {
			response.put("error", LabelUtil.getLabel(portletConfig, themeDisplay, "label.product.publish.save.error"));
		}

		return response;

	}

	public static JSONObject unpublish(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		if (!ProductPermissionsUtil.hasPublishPermission(themeDisplay)) {
			response.put("error",
					LabelUtil.getLabel(portletConfig, themeDisplay, "label.product.noauth.publish.product"));
			return response;
		}
		String productId = resourceRequest.getParameter("spProductId");
		try {
			if (Validator.isNumber(productId)) {
				Product product = ProductLocalServiceUtil.fetchProduct(Long.parseLong(productId));
				product.setStatus(Status.UNPUBLISH.getCode());
				product.setModifiedDate(DateUtil.newDate());
				ProductLocalServiceUtil.updateProduct(product);
				return response.put("saveFlag", "success");
			}
		} catch (Exception e) {
			response.put("error",
					LabelUtil.getLabel(portletConfig, themeDisplay, "label.product.noauth.unpublish.product"));
		}

		return response;

	}

	public static boolean isQualificationTypeProduct(Product product) {
		try {
			Course course = CourseLocalServiceUtil.getCourse(product.getSpCourseId());
			return isQualificationTypeCourse(course);
		} catch (Exception ex) {
			_log.error(ex);
		}
		return false;
	}

	public static boolean isQualificationTypeCourse(Course course) {
		try {
			AssetCategory category = AssetCategoryLocalServiceUtil.getAssetCategory(course.getCourseType());
			return SPProductConstants.COURSE_TYPE_QUALIFICATION.equalsIgnoreCase(category.getName());
		} catch (Exception ex) {
			_log.error(ex);
		}
		return false;
	}

	public static boolean isCoursePaymentEnabled(long groupId) {
		String enabled = SambaashUtil.getParameter(COURSE_PAYMENT_ENABLED_PARAM, groupId);
		return "true".equalsIgnoreCase(enabled);
	}

	public static String getCourseItemCode(long courseId) {
		return String.format("Course_%d", courseId);
	}

	public static String getProductItemCode(long courseId) {
		return String.format("Product_%d", courseId);
	}
}
