package com.sambaash.platform.product.indexer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletURL;

import com.liferay.portal.NoSuchRepositoryEntryException;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.product.util.SPProductConstants;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.CourseModule;
import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.model.Module;
import com.sambaash.platform.srv.model.ModuleFramework;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.FrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleFrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.service.persistence.ProductActionableDynamicQuery;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ThumbnailUtil;

public class ProductIndexer extends BaseIndexer {

	private static final Log _log = LogFactoryUtil.getLog(ProductIndexer.class);

	public static final String[] CLASS_NAMES = { Product.class.getName() };

	public static final String PORTLET_ID = SPProductConstants.PORTLET_ID;

	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Product product = (Product) obj;
		deleteDocument(product.getCompanyId(), product.getSpProductId());
	}

	@Override
	protected String getPortletId(SearchContext arg0) {
		return PORTLET_ID;
	}

	public boolean hasPermission(PermissionChecker permissionChecker, long entryClassPK, String actionId)
			throws Exception {
		// TODO: have to look into it
		// return super.hasPermission(permissionChecker, entryClassPK,
		// actionId);
		return true;
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {

		Product product = (Product) obj;
		Document document = null;
		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Indexing document productId=" + product.getSpProductId());
			}
			document = getBaseModelDocument(PORTLET_ID, product);
			// adding UID check as we are using multiple indexers in the same
			// portlet, inorder to avoid the chances of over-riding.
			document.addUID(PORTLET_ID, product.getSpProductId(), Product.class.getName());
			document.addKeyword(Field.TITLE, product.getProductName());
			document.addKeyword(PRODUCT_NAME, product.getProductName());
			document.addKeyword(PRODUCT_NAME_LOWER, product.getProductName().toLowerCase().trim());
			document.addKeyword("productCode", product.getProductCode());
			document.addKeyword("productId", product.getSpProductId());
			// document.addKeyword(Field.DESCRIPTION, product.get);
			List<AssetCategory> productCategoriesList = AssetCategoryLocalServiceUtil
					.getCategories(Product.class.getName(), product.getSpProductId());
			_log.debug(
					"product categories... " + ListUtil.toString(productCategoriesList, AssetCategory.NAME_ACCESSOR));

			String[] productCategories = StringUtil
					.split(ListUtil.toString(productCategoriesList, AssetCategory.NAME_ACCESSOR));
			document.addText(PRODUCT_CATEGORIES, productCategories);
			String imgUrl = StringPool.BLANK;
			String originalImageUrl = StringPool.BLANK;
			String imgIds = String.valueOf(product.getProductImageId());
			long imgId = 0;
			if (Validator.isNotNull(imgIds)) {
				imgId = Long.parseLong(imgIds);
			}
			try {
				if (imgId > 0) {
					originalImageUrl = ThumbnailUtil._getPreviewURL(DLAppServiceUtil.getFileEntry(imgId), DLAppServiceUtil.getFileEntry(imgId).getFileVersion(), 
							StringPool.BLANK, false, SambaashUtil.getPortalURL(product.getCompanyId(), product.getGroupId()), PortalUtil.getPathContext());
					
					imgUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(imgId), "",
							PortalUtil.getPathContext(),
							SambaashUtil.getPortalURL(product.getCompanyId(), product.getGroupId()), 1);
				
				}
			} catch (NoSuchRepositoryEntryException ex) {

			}
			_log.debug("imgurl " + imgUrl);
			document.addKeyword("originalImageUrl", originalImageUrl);
			document.addKeyword("imgUrl", imgUrl);
			document.addKeyword("productImageId", product.getProductImageId());
			String countryId = product.getCountryId();
			document.addKeyword("countryId", countryId);
			document.addKeyword(Field.STATUS, product.getStatus());
			try {
				AssetCategory category = AssetCategoryLocalServiceUtil
						.fetchAssetCategory(GetterUtil.getLong(countryId));
				_log.debug("countryName " + category.getName() + " product " + product.getProductName() + " "
						+ product.getSpProductId());
				document.addKeyword("countryName", category.getName());
				document.addKeyword("countryName_lower", category.getName().toLowerCase());

			} catch (Exception ex) {

			}
			document.addKeyword("courseId", product.getSpCourseId());
			document.addKeyword("status", product.getStatus());

			// course relaed fields
			try {
				
				Course course = CourseLocalServiceUtil.getCourse(product.getSpCourseId());
				document.addKeyword("courseDescription", course.getCourseDesc());
				document.addKeyword("courseName", course.getCourseName());
				document.addKeyword(COURSE_NAME_LOWER, course.getCourseName().toLowerCase().trim());
				_log.debug("courseName " + course.getCourseName());
				document.addKeyword("courseDuration", course.getCourseDurationFullTime());
				document.addKeyword("courseDurationPartTime", course.getCourseDurationPartTime());
				long typeId = course.getCourseType();
				if (typeId > 0) {
					AssetCategory caegory = AssetCategoryLocalServiceUtil.getCategory(course.getCourseType());
					_log.debug("courseType " + caegory.getName() + " product " + product.getProductName() + " "
							+ product.getSpProductId());
					document.addKeyword("courseType", caegory.getName());
					document.addKeyword("courseTypeId", typeId);
				}
				List<CourseModule> modules = CourseModuleLocalServiceUtil
						.findByCourseIdAndGroupId(product.getSpCourseId(), product.getGroupId());
				document.addKeyword("moduleCount", modules.size());
				// framework details
				if (modules.size() > 0) {
					CourseModule courseModule = modules.get(0);
					Module module = ModuleLocalServiceUtil.getModule(courseModule.getSpModuleId());
					List<ModuleFramework> list = ModuleFrameworkLocalServiceUtil
							.findByModuleIdAndGroupId(module.getSpModuleId(), module.getGroupId());
					if (list.size() > 0) {
						Framework framework = FrameworkLocalServiceUtil.getFramework(list.get(0).getSpFrameworkId());
						document.addKeyword("frameworkImageId", framework.getFrameworkImageId());
					}
				}

			} catch (Exception ex) {
				_log.error(ex.getMessage());
			}

			// to support case insensitive search
			StringBuilder sb = new StringBuilder();
			Map<String, Field> map = document.getFields();
			Set<String> keyset = map.keySet();
			Iterator<String> iterator = keyset.iterator();
			while (iterator.hasNext()) {
				Field field = map.get(iterator.next());
				sb.append(field.getValue());
				sb.append(StringPool.SPACE);
			}
			document.addText("searchableContent", sb.toString().toLowerCase());
		} catch (Exception ex) {
			_log.error("Error while indexing document " + obj, ex);
		}
		return document;

	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL)
			throws Exception {
		return null;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		Product produc = (Product) obj;
		Document doc = getDocument(obj);
		SearchEngineUtil.updateDocument(SearchEngineUtil.getSearchEngineId(doc), produc.getCompanyId(), doc, true);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Product product = ProductLocalServiceUtil.getProduct(classPK);
		doReindex(product);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	private void reindexEntries(long companyId) throws SystemException, PortalException {
		// reference DLFileEntryIndexer
		ActionableDynamicQuery query = new ProductActionableDynamicQuery() {

			int count = 1;
			@Override
			protected void performAction(Object object) throws PortalException, SystemException {
				Product product = (Product) object;
				_log.debug("Indexing Product. Product Id " + product.getSpProductId());
				_log.debug("Count = " + count++ );
				Document document = getDocument(product);
				if (document != null) {
					if (_log.isDebugEnabled()) {
						_log.debug("Indexing document prepared for productId=" + product.getSpProductId());
					}
					addDocument(document);
				}
			}
		};
		query.setClassLoader(PortletClassLoaderUtil.getClassLoader(PORTLET_ID));
		query.setCompanyId(companyId);
		// this method internall query the all rows , calls performaction method
		// on each object.
		query.performActions();
	}
	

	public static final String PRODUCT_NAME_LOWER = "productName_lower";
	public static final String COURSE_NAME_LOWER = "courseName_lower";
	public static final String PRODUCT_CATEGORIES = "productCatgories";
	public static final String PRODUCT_NAME = "productName";
	
	public Map<String, String> getIndexedFields() {
		Map<String, String> map = new HashMap<String, String>(super.getIndexedFields());
		map.put(Field.STATUS, "Status");
		map.put(Field.TITLE, "Title");
		map.put(PRODUCT_NAME_LOWER, "Product Name Lower");
		map.put(PRODUCT_CATEGORIES, "Product Categories");
		map.put(PRODUCT_NAME, "Product Name");
		
		return map;
	}

}
