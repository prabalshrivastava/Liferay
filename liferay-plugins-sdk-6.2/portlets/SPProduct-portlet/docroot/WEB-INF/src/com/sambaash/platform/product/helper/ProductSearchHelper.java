package com.sambaash.platform.product.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.liferay.compat.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.product.util.Status;
import com.sambaash.platform.srv.model.Certificate;
import com.sambaash.platform.srv.model.CompetencyUnit;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.model.Module;
import com.sambaash.platform.srv.model.Outline;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ThumbnailUtil;

public class ProductSearchHelper {

	private static Log _log = LogFactoryUtil.getLog(ProductSearchHelper.class);

	public static JSONObject fetchProducts(PortletRequest portletRequest, PortletResponse portletResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Status statusPublish = Status.PUBLISH;
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		JSONArray products = JSONFactoryUtil.createJSONArray();
		JSONObject productsJson;
		Hits results = null;
		_log.error("themeDisplay.getLocale() " + themeDisplay.getLocale());
		/** Calculating start and end */
		int start = ParamUtil.getInteger(portletRequest, "start", 0);

		ProductSearch productHelper = new ProductSearch(Product.class);
		results = productHelper.search(portletRequest, start);
		if (start <= results.getLength()) {
			List<Document> docsList = convertToList(results);

			for (Document doc : docsList) {
				productsJson = JSONFactoryUtil.createJSONObject();

				String imageUrl = doc.get("imgUrl");
				if (Validator.isNotNull(imageUrl)) {
					if (imageUrl.contains(
							SambaashUtil.getPortalURL(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId()))) {
						productsJson.put("imgUrl", doc.get("imgUrl"));
					} else {
						imageUrl = themeDisplay.getPathThemeImages() + imageUrl;
						productsJson.put("imgUrl", imageUrl);
					}
				}
				productsJson.put("productId", doc.get("productId"));
				productsJson.put("productName", doc.get("productName"));
				productsJson.put("courseName", doc.get("courseName"));
				productsJson.put("courseId", doc.get("courseId"));

				try {
					productsJson.put("dateCreated", getDateStrddMMYYYYHMS(doc.getDate("createDate")));
					productsJson.put("dateModified", getDateStrddMMYYYYHMS(doc.getDate("modified")));
				} catch (java.text.ParseException e1) {
					// _log.error(e1.getMessage());
				}

				AssetCategory cAsset;

				try {
					cAsset = AssetCategoryLocalServiceUtil.getAssetCategory(GetterUtil.getLong(doc.get("countryId")));
					productsJson.put("countryName", cAsset.getName());
				} catch (NumberFormatException | PortalException | SystemException e) {
					_log.error(e.getMessage());
				}

				if (statusPublish.getCode() == GetterUtil.getInteger(doc.get(Field.STATUS))) {
					productsJson.put("status", "Publish");
				} else {
					productsJson.put("status", "Unpublish");
				}
				products.put(productsJson);
			}
		}
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		responseData.put("resultCountText", results.getLength()+ StringPool.SPACE+ LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.list.products"));
		responseData.put("products", products);

		return responseData;
	}

	public static JSONObject fetchModules(PortletRequest portletRequest, PortletResponse portletResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		JSONArray modules = JSONFactoryUtil.createJSONArray();
		JSONObject modulesJson;
		Hits results = null;
		String replace[] = { "<!--StartFragment-->\n<p>&nbsp;</p>\n<!--EndFragment-->", "&nbsp;", "&amp;" };
		String moduleDesc = StringPool.BLANK;

		/** Calculating start and end */
		int start = ParamUtil.getInteger(portletRequest, "start", 0);

		ProductSearch productHelper = new ProductSearch(Module.class);
		results = productHelper.search(portletRequest, start);
		if (start <= results.getLength()) {
			List<Document> docsList = convertToList(results);

			for (Document doc : docsList) {
				modulesJson = JSONFactoryUtil.createJSONObject();

				modulesJson.put("moduleId", doc.get("moduleId"));
				modulesJson.put("moduleCode", doc.get("moduleCode"));
				modulesJson.put("moduleName", doc.get("moduleName"));
				moduleDesc = doc.get("moduleDesc");

				if (Validator.isNotNull(moduleDesc)) {

					for (String replaceString : replace) {
						moduleDesc = moduleDesc.replace(replaceString, "");
					}

					if (moduleDesc.length() > 60) {

						modulesJson.put("moduleDesc", HtmlUtil.stripHtml(moduleDesc).substring(0, 59));
					} else {
						modulesJson.put("moduleDesc", HtmlUtil.stripHtml(moduleDesc));
					}
				} else {
					modulesJson.put("moduleDesc", moduleDesc);
				}
				modules.put(modulesJson);
			}
		}
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		responseData.put("resultCountText", results.getLength()+ StringPool.SPACE+LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.list.modules"));
		responseData.put("products", modules);

		return responseData;
	}

	public static JSONObject fetchCourses(PortletRequest portletRequest, PortletResponse portletResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		JSONArray courses = JSONFactoryUtil.createJSONArray();
		JSONObject coursesJson;
		Hits results = null;
		String replace[] = { "<!--StartFragment-->\n<p>&nbsp;</p>\n<!--EndFragment-->", "&nbsp;", "&amp;" };
		String courseDesc = StringPool.BLANK;

		/** Calculating start and end */
		int start = ParamUtil.getInteger(portletRequest, "start", 0);

		ProductSearch productHelper = new ProductSearch(Course.class);
		results = productHelper.search(portletRequest, start);
		if (start <= results.getLength()) {
			List<Document> docsList = convertToList(results);

			for (Document doc : docsList) {
				coursesJson = JSONFactoryUtil.createJSONObject();

				coursesJson.put("courseId", doc.get("courseId"));
				coursesJson.put("courseCode", doc.get("courseCode"));
				coursesJson.put("courseName", doc.get("courseName"));
				courseDesc = doc.get("courseDesc");

				if (Validator.isNotNull(courseDesc)) {

					for (String replaceString : replace) {
						courseDesc = courseDesc.replace(replaceString, "");
					}

					if (courseDesc.length() > 60) {

						coursesJson.put("courseDesc", HtmlUtil.stripHtml(courseDesc).substring(0, 59));
					} else {
						coursesJson.put("courseDesc", HtmlUtil.stripHtml(courseDesc));
					}
				} else {
					coursesJson.put("courseDesc", courseDesc);
				}
				courses.put(coursesJson);
			}
		}
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		responseData.put("resultCountText", results.getLength() + StringPool.SPACE + LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.list.courses"));
		responseData.put("products", courses);

		return responseData;
	}
	
	public static JSONObject fetchFeeComponents(PortletRequest portletRequest, PortletResponse portletResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		JSONArray feeTypes = JSONFactoryUtil.createJSONArray();
		JSONObject feeTypeJson;
		Hits results = null;

		/** Calculating start and end */
		int start = ParamUtil.getInteger(portletRequest, "start", 0);

		ProductSearch productHelper = new ProductSearch(FeeType.class);
		results = productHelper.search(portletRequest, start);
		_log.error("results ======== " + results.getLength());
		if (start <= results.getLength()) {
			List<Document> docsList = convertToList(results);

			for (Document doc : docsList) {
				feeTypeJson = JSONFactoryUtil.createJSONObject();

				feeTypeJson.put("spFeeTypeId", doc.get("entryClassPK"));
				feeTypeJson.put("feeType", doc.get("feeType"));
				feeTypeJson.put("feeTypeName", doc.get("feeTypeName"));
				//feeTypeJson.put("feeTypeDesc", doc.get("feeTypeDesc"));
				
				feeTypeJson.put("feeTypeDesc", doc.get("feeTypeDesc"));
				
				feeTypeJson.put("misc", doc.get("misc"));
				feeTypeJson.put("companyId", doc.get("companyId"));
				feeTypeJson.put("groupId", doc.get("groupId"));
				try {
					feeTypeJson.put("modifiedDate", getDateStrddMMYYYYHMS(doc.getDate("modified")));
				} catch (ParseException e) {
					_log.error("uunable to add date to object");
				}
				
				feeTypes.put(feeTypeJson);
			}
		}
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		responseData.put("resultCountText", results.getLength() + StringPool.SPACE + LabelUtil.getLabel(portletConfig, themeDisplay, "label.product.list.feeComponents"));
		responseData.put("products", feeTypes);

		return responseData;
	}


	public static JSONObject fetchCertificates(PortletRequest portletRequest, PortletResponse portletResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		JSONArray certificates = JSONFactoryUtil.createJSONArray();
		JSONObject certificatesJson;
		Hits results = null;

		/** Calculating start and end */
		int start = ParamUtil.getInteger(portletRequest, "start", 0);

		ProductSearch productHelper = new ProductSearch(Certificate.class);
		results = productHelper.search(portletRequest, start);
		if (start <= results.getLength()) {
			List<Document> docsList = convertToList(results);

			for (Document doc : docsList) {
				certificatesJson = JSONFactoryUtil.createJSONObject();
				
				Long imgId = 0L;
				String certificateUrl = "#";
				long groupId = 0;
				if (Validator.isNotNull(doc.get("attachmentFolderId"))) {
					imgId = Long.parseLong(doc.get("attachmentFolderId"));
				}
				String imgUrl = "";
				if (imgId != null && imgId.compareTo(Long.parseLong("0")) != 0) {
					List<FileEntry> fileEntryList;
					try {
						fileEntryList = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(),
								imgId);
						for (FileEntry fileEntry : fileEntryList) {
							imgUrl = ThumbnailUtil.getThumbnailUrl(
									DLAppServiceUtil.getFileEntry(fileEntry.getFileEntryId()),
									themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
									themeDisplay.getPathContext(), 1);
							String certUrl = fileEntry.getUuid();
							groupId = fileEntry.getGroupId();
							certificateUrl = "/documents/" + groupId + "/" + certUrl;
							
							certificatesJson.put("certificateUrl", certificateUrl);
							certificatesJson.put("imgUrl", imgUrl);
						}
					} catch (PortalException | SystemException e) {
						_log.error(e.getMessage());
					}

					
				}
				
				certificatesJson.put("certificateId", doc.get("certificateId"));
				certificatesJson.put("title", doc.get("title"));
				certificatesJson.put("levelName", doc.get("levelName"));
				certificatesJson.put("typeName", doc.get("typeName"));
				certificatesJson.put("description", doc.get("description"));
				

				
				certificates.put(certificatesJson);
			}
		}
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		responseData.put("resultCountText", results.getLength()+ StringPool.SPACE+ LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.list.certificates"));		
		responseData.put("products", certificates);

		return responseData;
	}
	
	
	public static JSONObject fetchOutlines(PortletRequest portletRequest, PortletResponse portletResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		JSONArray outlines = JSONFactoryUtil.createJSONArray();
		JSONObject outlinesJson;
		Hits results = null;

		/** Calculating start and end */
		int start = ParamUtil.getInteger(portletRequest, "start", 0);

		ProductSearch productHelper = new ProductSearch(Outline.class);
		results = productHelper.search(portletRequest, start);
		if (start <= results.getLength()) {
			List<Document> docsList = convertToList(results);

			for (Document doc : docsList) {
				outlinesJson = JSONFactoryUtil.createJSONObject();

				outlinesJson.put("outlineId", doc.get("outlineId"));
				outlinesJson.put("competencyCode", doc.get("competencyCode"));
				outlinesJson.put("competencyDesc", doc.get("competencyDesc"));
				outlinesJson.put("outlineType", doc.get("outlineType"));

				outlines.put(outlinesJson);
			}
		}
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		responseData.put("resultCountText", results.getLength()+ StringPool.SPACE+ LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.list.outlines"));
		responseData.put("products", outlines);

		return responseData;
	}
	
	public static JSONObject fetchCompetencies(PortletRequest portletRequest, PortletResponse portletResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		JSONArray competencies = JSONFactoryUtil.createJSONArray();
		JSONObject competenciesJson;
		Hits results = null;

		/** Calculating start and end */
		int start = ParamUtil.getInteger(portletRequest, "start", 0);

		ProductSearch productHelper = new ProductSearch(CompetencyUnit.class);
		results = productHelper.search(portletRequest, start);
		if (start <= results.getLength()) {
			List<Document> docsList = convertToList(results);

			for (Document doc : docsList) {
				competenciesJson = JSONFactoryUtil.createJSONObject();

				competenciesJson.put("competencyId", doc.get("competencyId"));
				competenciesJson.put("competencyCode", doc.get("competencyCode"));
				competenciesJson.put("competencyDesc", doc.get("competencyDesc"));

				competencies.put(competenciesJson);
			}
		}
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		responseData.put("resultCountText", results.getLength()+ StringPool.SPACE+ LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.list.competencyUnits"));
		responseData.put("products", competencies);

		return responseData;
	}
	
	
	public static JSONObject fetchFrameworks(PortletRequest portletRequest, PortletResponse portletResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		JSONArray frameworks = JSONFactoryUtil.createJSONArray();
		JSONObject frameworksJson;
		Hits results = null;

		/** Calculating start and end */
		int start = ParamUtil.getInteger(portletRequest, "start", 0);

		ProductSearch productHelper = new ProductSearch(Framework.class);
		results = productHelper.search(portletRequest, start);
		if (start <= results.getLength()) {
			List<Document> docsList = convertToList(results);

			for (Document doc : docsList) {
				frameworksJson = JSONFactoryUtil.createJSONObject();

				frameworksJson.put("frameworkId", doc.get("frameworkId"));
				frameworksJson.put("frameworkCode", doc.get("frameworkCode"));
				frameworksJson.put("frameworkName", doc.get("frameworkName"));
				frameworksJson.put("frameworkName", doc.get("frameworkName"));

				try {
				long imgId = GetterUtil.getLong(doc.get("frameworkImageId"));
				String imgUrl = "";
				if (imgId > 0) {
						imgUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(imgId),
								themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
								themeDisplay.getPathContext(), 1);
						frameworksJson.put("frameworkImgUrl", imgUrl);
					} 
				}catch (PortalException | SystemException e) {
						// TODO Auto-generated catch block
					_log.error(e.getMessage());
				}
				
				
				frameworks.put(frameworksJson);
			}
		}
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		responseData.put("resultCountText", results.getLength()+ StringPool.SPACE+ LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.list.frameworks"));
		responseData.put("products", frameworks);

		return responseData;
	}

	public static List<Document> convertToList(Hits results) {

		Document[] docs = results.getDocs();
		List<Document> list = ListUtil.fromArray(docs);

		return list;
	}

	public static String getDateStrddMMYYYYHMS(Date date) {
		String dateStr = "";
		String format = "dd MMM yyyy hh.mm aa";

		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateStr = sdf.format(date);
		}

		return dateStr;
	}

}
