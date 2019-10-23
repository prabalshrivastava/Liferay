package com.sambaash.platform.util;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.jsp.JspWriter;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;

/**
 * 
 */
public class FormHelper {

	private static Log logger = LogFactoryUtil.getLog(FormHelper.class);

	private Map<String, String> register;// new HashMap<String, String>();
	private ClassLoader claassLoader;

	public FormHelper(Map<String, String> register, ClassLoader loader) {
		this.register = register;
		this.claassLoader = loader;
	}

	public static Map<String, String> getRequestParamMap(PortletRequest resourceRequest, ThemeDisplay themeDisplay)
			throws SystemException {
		Map<String, String> paramMap = SambaashUtil.getParameterMap(resourceRequest);
		paramMap.put("audituserName", themeDisplay.getUser().getFullName());
		paramMap.put("audituserId", "" + themeDisplay.getUserId());
		paramMap.put("auditgroupId", "" + themeDisplay.getScopeGroupId());
		paramMap.put("auditcompanyId", "" + themeDisplay.getCompanyId());
		return paramMap;
	}

	public Map<String, Object> parsedRequestData(Map<String, String> paramMap, Map<String, Object> existingMap,
			String prefix) throws SystemException {
		if (logger.isInfoEnabled())
			logger.info("existingMap -> " + existingMap);

		Map<String, Object> results = null;

		if (Validator.isNull(existingMap)) {
			results = new HashMap<String, Object>();
		} else {
			results = existingMap;
		}

		Set<Entry<String, String>> set = paramMap.entrySet();
		Date date = new Date();
		for (Entry<String, String> entry : set) {
			String classkey = null;
			try {
				if (Validator.isNull(entry.getValue()) && Validator.isNull(existingMap)) {
					continue;
				}
				if (entry.getKey().indexOf("_") <= 0) {
					results.put(entry.getKey(), entry.getValue());
					continue;
				}
				classkey = entry.getKey().split("_")[0];
				String attrib = entry.getKey().split("_")[1];
				Object obj = results.get(classkey);
				if (Validator.isNull(obj)) {
					String clazz = register.get(classkey.replaceAll("\\d", ""));

					obj = Class.forName(clazz, false, claassLoader).newInstance();
					results.put(classkey, obj);

					// if uuid generation is enabled
					setFieldValue(obj, "uuid", PortalUUIDUtil.generate());
					setFieldValue(obj, "new", true);
					setFieldValue(obj, "createDate", date);
					setFieldValue(obj, "userName", paramMap.get("audituserName"));
					setFieldValue(obj, "userId", paramMap.get("audituserId"));
					setFieldValue(obj, "groupId", paramMap.get("auditgroupId"));
					setFieldValue(obj, "companyId", paramMap.get("auditcompanyId"));
				}
				// if no diff then below
				boolean removeNonPrintable = !"budgetCcySign".equals(attrib);
				if("challenge_background".equalsIgnoreCase(entry.getKey()) || "challenge_description".equalsIgnoreCase(entry.getKey()) || "challenge_benefits".equalsIgnoreCase(entry.getKey())){
					setFieldValue(obj, attrib, entry.getValue(), false);
				}else{
					setFieldValue(obj, attrib, entry.getValue(), removeNonPrintable);
				}
				setFieldValue(obj, "modifiedDate", date);
				setFieldValue(obj, "active", true);
			} catch (NullPointerException e) {
				if (logger.isDebugEnabled()) {
					logger.error("No class for key = " + classkey.replaceAll("\\d", ""));
				}
				results.put(entry.getKey(), entry.getValue());
			} catch (Exception e) {
				logger.error("Error while parsing form data", e);
				throw new SystemException(e);
			}
		}
		logger.debug(results);
		return results;
	}

	public static void toMultipleFieldHtml(String fieldName, RenderRequest req, JspWriter out) {
		try {
			for (int i = 1;; i++) {
				String temp = fieldName + i;
				if (Validator.isNotNull(req.getAttribute(temp))) {
					out.println("var " + temp + " = " + req.getAttribute(temp) + ";");
				} else {
					break;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	private void setFieldValue(Object obj, String field, Object value) {
		setFieldValue(obj, field, value, true);
	}

	private void setFieldValue(Object obj, String field, Object value, boolean removeNonPrintableValues) {
		Method mthd = null;
		field = field.substring(0, 1).toUpperCase() + field.substring(1);
		try {
			mthd = obj.getClass().getMethod("set" + field, String.class);
			if(Validator.isNotNull(value)) {
				String temp = HtmlUtil.stripHtml((String) value);
				if (removeNonPrintableValues) {
					temp = temp.replaceAll("\\P{Print}", ""); //remove all non printable characters
				}
				mthd.invoke(obj, temp);
			} else {
				mthd.invoke(obj, value);
			}
			return;
		} catch (NoSuchMethodException e) {
			if (field.equalsIgnoreCase("uuid"))
				return;
		} catch  (ClassCastException e) {
			//ignore
		} catch (Exception e) {
			logger.warn("Error while invoking setter method", e);
		}
		try {
			mthd = obj.getClass().getMethod("set" + field, Date.class);
			if (value instanceof Date) {
				mthd.invoke(obj, (Date) value);
			} else {
				mthd.invoke(obj, new SimpleDateFormat("MM/dd/yyyy").parse((String) value));
			}
			return;
		} catch (Exception e) {
		}
		try {
			mthd = obj.getClass().getMethod("set" + field, boolean.class);
			mthd.invoke(obj, Boolean.valueOf(value.toString()).booleanValue());
			return;
		} catch (Exception e) {
		}
		try {
			mthd = obj.getClass().getMethod("set" + field, int.class);
			mthd.invoke(obj, Integer.valueOf(value.toString()).intValue());
			return;
		} catch (Exception e) {
		}
		try {
			mthd = obj.getClass().getMethod("set" + field, long.class);
			mthd.invoke(obj, Long.valueOf(value.toString()).longValue());
			return;
		} catch (Exception e) {
		}
		logger.warn("no setter method for field" + field);
	}

	@SuppressWarnings("unchecked")
	public static void createDropDownOptions(String allOptionsListName, String selectedOptionName, RenderRequest req,
			JspWriter out) throws Exception {
		List<AssetCategory> items = (List<AssetCategory>) req.getAttribute(allOptionsListName);
		if (items==null) {
			logger.warn(allOptionsListName + " was not found on the request data");
			return;
		}
		List<Long> selectedOptions = null;
		if (Validator.isNotNull(req.getAttribute(selectedOptionName))) {
			selectedOptions = (List<Long>) req.getAttribute(selectedOptionName);
		}
		for (AssetCategory assetCategory : items) {
			String str = "<option value='" + assetCategory.getCategoryId() + "'";
			if (Validator.isNotNull(selectedOptions) && selectedOptions.contains(assetCategory.getCategoryId()))
				str += " selected ";
			str += ">" + assetCategory.getName() + "</option>";
			out.print(str);
		}
	}

	@SuppressWarnings("unchecked")
	public static void createCheckBoxes(String allOptionsListName, String selectedOptionsName, RenderRequest req,
			RenderResponse res, JspWriter out) throws Exception {
		List<AssetCategory> items = (List<AssetCategory>) req.getAttribute(allOptionsListName);
		List<Long> selectedOptions = null;
		if (Validator.isNotNull(req.getAttribute(selectedOptionsName))) {
			selectedOptions = (List<Long>) req.getAttribute(selectedOptionsName);
		}

		for (AssetCategory assetCategory : items) {
			String name = res.getNamespace() + "asset_" + assetCategory.getCategoryId();
			String str = "<div class='checkItem'><label for='" + name + "'>" + assetCategory.getName() + "</label>"
					+ "<input type='checkbox' class='aui-field-input' value='" + assetCategory.getCategoryId()
					+ "' name='" + name + "' id='" + name + "' ";
			if (Validator.isNotNull(selectedOptions) && selectedOptions.contains(assetCategory.getCategoryId()))
				str += " checked ";
			str += " /></div>";
			out.print(str);
		}
	}

	@SuppressWarnings("unchecked")
	public static void createCountryDDOptions(String selectedOptionName, RenderRequest req, JspWriter out)
			throws Exception {
		List<Country> items = CountryServiceUtil.getCountries(true);
		List<Long> selectedOptions = null;
		if (Validator.isNotNull(req.getAttribute(selectedOptionName))) {
			selectedOptions = (List<Long>) req.getAttribute(selectedOptionName);
		}
		String languageId = LanguageUtil.getLanguageId(req);
		int pos = languageId.indexOf(CharPool.UNDERLINE);
		Locale locale = LocaleUtil.getDefault();
		if (pos >= 0) {
			String language = languageId.substring(0, pos);
			locale = LocaleUtil.fromLanguageId(language);
		}
		for (Country country : items) {
			String str = "<option value='" + country.getCountryId() + "'";
			if (Validator.isNotNull(selectedOptions) && selectedOptions.contains(country.getCountryId()))
				str += " selected ";
			str += ">"
					+ StringUtil.upperCaseFirstLetter(country
							.getName(locale)) + "</option>";
			out.print(str);
		}
	}

	@SuppressWarnings("unchecked")
	public static void createJsonSelectOptions(String jsonOptionsList, String selectedValueAttrib, RenderRequest req,
			JspWriter out) {
		try {
			String selectOptionFormat = "<option value='%s' %s>%s</option>";
			JSONArray items = (JSONArray) req.getAttribute(jsonOptionsList);
			List<String> selectedOptions = null;
			if (Validator.isNotNull(req.getAttribute(selectedValueAttrib))) {
				selectedOptions = (List<String>) req.getAttribute(selectedValueAttrib);
			}
			for (int i=0; i<items.length(); i++) {
				JSONObject o = items.getJSONObject(i);
				String value = o.getString("value");
				String label = o.getString("label");
				if (Validator.isNotNull(selectedOptions) && selectedOptions.contains(value)) {
					out.print(String.format(selectOptionFormat, value,"selected", label));
				} else {
					out.print(String.format(selectOptionFormat, value,"", label));
				}
			}
		} catch (Exception e) {
			logger.warn("Error generating selct options.", e);
		}
	}
	
}