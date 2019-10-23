package com.sambaash.platform.portlet.socialprofile.action;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;

import org.json.JSONException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.DuplicateUserScreenNameException;
import com.liferay.portal.UserScreenNameException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.portlet.socialprofile.util.ProfileConstants;
import com.sambaash.platform.portlet.socialprofile.util.SocialProfileField;
import com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil;
import com.sambaash.platform.portlet.socialprofile.util.XMLManipulator;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.SambaashHtmlUtil;
import com.sambaash.platform.util.SambaashUtil;

public class UserProfileBase extends MVCPortlet {
	private static Log _log = LogFactoryUtil.getLog(UserProfileBase.class);

	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long scopeGroupId = themeDisplay.getScopeGroupId();
		PortletPreferences prefs = actionRequest.getPreferences();
		boolean signedIn = themeDisplay.isSignedIn();
		String action = actionRequest.getParameter("action");
		if (signedIn) {
			if ("addFormSubmit".equals(action)) { // add new form
				String newFormNameInputField = actionRequest
						.getParameter("newFormNameInput");
				String formEdittable = actionRequest
						.getParameter("formEdittable");
				String formLabel = actionRequest.getParameter("formLabel");

				if (Validator.isNotNull(newFormNameInputField)) {
					// cleanup preferences
					Map<String, String[]> preferences = prefs.getMap();
					for (Map.Entry<String, String[]> entry : preferences
							.entrySet()) {
						String key = entry.getKey();
						prefs.reset(key);
					}
					prefs.store();

					String newFormName = newFormNameInputField.toLowerCase()
							.trim().replaceAll("( )+", StringPool.UNDERLINE);
					String xslNames = SambaashUtil.getParameter(
							ProfileConstants.USER_PROFILE.XSLNAMES,
							scopeGroupId);
					int pos = (xslNames).lastIndexOf(newFormName);
					String instance = String.valueOf(new Date().getTime());
					if (pos >= 0) {// form name already exists,then append with
									// id (index +1)
						newFormName += StringPool.UNDERLINE + instance;
					}
					xslNames += StringPool.COMMA + newFormName;
					try {
						prefs.setValue("formedit", Validator
								.isNotNull(formEdittable) ? formEdittable
								: StringPool.FALSE);
						prefs.setValue("name", newFormName);
						prefs.setValue(
								"formLabel",
								Validator.isNotNull(formLabel) ? SambaashHtmlUtil
										.escape(formLabel) : SambaashHtmlUtil
										.escape(newFormNameInputField));
						prefs.store();

						// update xsl names list
						addOrUpdateSPParameter(
								ProfileConstants.USER_PROFILE.XSLNAMES,
								scopeGroupId, xslNames, StringPool.BLANK);
						
						// update generic xml template with dynamic form
						addOrUpdateSPParameterWithDymaicform(scopeGroupId,newFormName);

						// create new xml template
						String tempXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><?xml-stylesheet type=\"text/xsl\"?>";
						tempXml += "<" + newFormName + "_details/>";

						createXMLTemplate(newFormName, scopeGroupId,
								StringPool.BLANK, tempXml);

					} catch (SystemException e) {
						_log.error("Unable to add new form name to spparameters: "
								+ e.getMessage());
					}
				}

			} else if ("editFormSubmit".equalsIgnoreCase(action)) {
				String selectedXslName = actionRequest
						.getParameter("xslSelect");
				String curXslName = prefs.getValue("name", StringPool.BLANK);
				String formEdittable = actionRequest
						.getParameter("formEdittable");
				String formLabel = actionRequest.getParameter("formLabel");

				if (Validator.isNotNull(curXslName)
						&& !(curXslName.equalsIgnoreCase(selectedXslName))) {
					// remove preferences if new xsl template selected
					Map<String, String[]> preferences = prefs.getMap();
					for (Map.Entry<String, String[]> entry : preferences
							.entrySet()) {
						String key = entry.getKey();
						prefs.reset(key);
					}
					prefs.store();
				}

				// if selected XSL name is not empty
				if (Validator.isNotNull(selectedXslName)) {
					prefs.setValue("formedit", Validator
							.isNotNull(formEdittable) ? formEdittable
							: StringPool.FALSE);
					prefs.setValue("name", selectedXslName);
					prefs.setValue(
							"formLabel",
							Validator.isNotNull(formLabel) ? SambaashHtmlUtil
									.escape(formLabel) : SambaashHtmlUtil
									.escape(selectedXslName).replaceAll(
											StringPool.UNDERLINE,
											StringPool.SPACE));

					String xslFields = SambaashUtil.getParameter(
							selectedXslName + ".fields", scopeGroupId);

					String[] checkedFieldArray = actionRequest
							.getParameterValues(selectedXslName + "-checkbox");

					List<String> checkedFieldList = new ArrayList<String>();
					if (Validator.isNotNull(checkedFieldArray)) {
						for (int i = 0; i < checkedFieldArray.length; i++) {
							checkedFieldList.add(UserProfileUtil
									.labelTofieldId(checkedFieldArray[i]));
						}
					}

					int fieldsLength = 0;

					// add or update preferences(except name)
					if (Validator.isNotNull(xslFields)) {
						String[] xslFieldArray = xslFields
								.split(StringPool.COMMA);
						fieldsLength = xslFieldArray.length;

						for (int j = 0; j < fieldsLength; j++) {
							String xslField = xslFieldArray[j];

							String fieldType = actionRequest
									.getParameter(xslField + "-fieldType");
							String indexable = actionRequest
									.getParameter(xslField + "-indexable");
							String defaultVal = actionRequest
									.getParameter(xslField + "-default");
							String maxLen = actionRequest.getParameter(xslField
									+ "-maxlength");
							String mandatory = actionRequest
									.getParameter(xslField + "-mandatory");
							String searchable = actionRequest
									.getParameter(xslField + "-searchable");
							String validation = actionRequest
									.getParameter(xslField + "-validation");
							String options = actionRequest
									.getParameter(xslField + "-options");
							String edittable = actionRequest
									.getParameter(xslField + "-edittable");
							String privateView = actionRequest
									.getParameter(xslField + "-private");
							String label = actionRequest
									.getParameter(xslField + "-label");
							String level = actionRequest
									.getParameter(xslField + "-level");

							if (Validator.isNotNull(searchable)
									&& searchable.equals("true")) {
								indexable = "true"; // set indexable to true if
													// field is searchable
							}

							StringBuilder sbPrefs = new StringBuilder();
							sbPrefs.append("fieldType:")
									.append(Validator.isNotNull(fieldType) ? fieldType
											: StringPool.BLANK)
									.append(StringPool.COMMA);
							sbPrefs.append("indexable:")
									.append(Validator.isNotNull(indexable) ? indexable
											: StringPool.FALSE)
									.append(StringPool.COMMA);
							sbPrefs.append("searchable:")
									.append(Validator.isNotNull(searchable) ? searchable
											: StringPool.FALSE)
									.append(StringPool.COMMA);
							sbPrefs.append("edittable:")
									.append(Validator.isNotNull(edittable) ? edittable
											: StringPool.FALSE)
									.append(StringPool.COMMA);
							sbPrefs.append("default:")
									.append(Validator.isNotNull(defaultVal) ? defaultVal
											: StringPool.BLANK)
									.append(StringPool.COMMA);
							sbPrefs.append("maxLen:")
									.append(Validator.isNotNull(maxLen) ? maxLen
											: "100").append(StringPool.COMMA);
							sbPrefs.append("mandatory:")
									.append(Validator.isNotNull(mandatory) ? mandatory
											: StringPool.FALSE)
									.append(StringPool.COMMA);
							sbPrefs.append("validation:")
									.append(Validator.isNotNull(validation) ? validation
											: "0").append(StringPool.COMMA);
							sbPrefs.append("options:")
									.append(Validator.isNotNull(options) ? options
											: StringPool.BLANK)
									.append(StringPool.COMMA);
							sbPrefs.append("label:")
									.append(Validator.isNotNull(label) ? label
											: StringPool.BLANK)
									.append(StringPool.COMMA);
							
							sbPrefs.append("level:")
							.append(Validator.isNotNull(level) ? level
									: StringPool.BLANK)
									.append(StringPool.COMMA);

							if (checkedFieldList.contains(xslField
									.toLowerCase())) {
								sbPrefs.append("display:")
										.append(StringPool.TRUE)
										.append(StringPool.COMMA);
								sbPrefs.append("private:")
										.append(Validator
												.isNotNull(privateView) ? privateView
												: StringPool.FALSE);

							} else {
								sbPrefs.append("display:")
										.append(StringPool.FALSE)
										.append(StringPool.COMMA);
								sbPrefs.append("private:").append(
										StringPool.TRUE);

							}
							prefs.setValue(xslField, sbPrefs.toString());
						}// end for
					}

					String newInputField = actionRequest
							.getParameter("newFieldInput");

					if (Validator.isNotNull(newInputField)) {
						String newField = newInputField.toLowerCase().trim()
								.replaceAll("( )+", StringPool.UNDERLINE);

						// int pos = xslFields.indexOf(newField);

						// if (pos >= 0){//field name already exist, then append
						// with random id
						// newField += StringPool.UNDERLINE + String.valueOf(new
						// Date().getTime());
						// }
						newField += StringPool.UNDERLINE
								+ String.valueOf(fieldsLength + 1);

						if (xslFields.length() == 0) {
							xslFields = newField;
						} else {
							xslFields += StringPool.COMMA + newField;
						}

						// SocialProfileLocalServiceUtil.updateSPParameter(selectedXslName
						// + ".fields", scopeGroupId, xslFields,
						// StringPool.BLANK);
						try {
							addOrUpdateSPParameter(selectedXslName + ".fields",
									scopeGroupId, xslFields, StringPool.BLANK);
						} catch (SystemException e) {
							_log.error(
									"Error creating spparameters entry."
											+ e.getMessage(), e);
						}

						StringBuilder sbPrefs = new StringBuilder();
						sbPrefs.append("fieldType:").append(StringPool.BLANK)
								.append(StringPool.COMMA);
						sbPrefs.append("indexable:").append(StringPool.FALSE)
								.append(StringPool.COMMA);
						sbPrefs.append("searchable:").append(StringPool.FALSE)
								.append(StringPool.COMMA);
						sbPrefs.append("edittable:").append(StringPool.TRUE)
								.append(StringPool.COMMA);
						sbPrefs.append("default:").append(StringPool.BLANK)
								.append(StringPool.COMMA);
						sbPrefs.append("maxLen:").append("250")
								.append(StringPool.COMMA);
						sbPrefs.append("mandatory:").append(StringPool.FALSE)
								.append(StringPool.COMMA);
						sbPrefs.append("display:").append(StringPool.TRUE)
								.append(StringPool.COMMA);
						sbPrefs.append("validation:").append("0")
								.append(StringPool.COMMA);
						sbPrefs.append("options:").append(StringPool.BLANK)
								.append(StringPool.COMMA);
						sbPrefs.append("private:").append(StringPool.TRUE)
								.append(StringPool.COMMA);
						sbPrefs.append("level:").append(StringPool.BLANK)
								.append(StringPool.COMMA);
						sbPrefs.append("label:").append(newField);
						prefs.setValue(newField, sbPrefs.toString());
					}// end isNotNull newInputField
					actionResponse.setPortletMode(PortletMode.EDIT);
					prefs.store();
				}
			}
		}// end signedin
	}

	private void addOrUpdateSPParameterWithDymaicform(long scopeGroupId,String newFormName) {
		
		SPParameter spParameters = null;
		
		try {
			spParameters = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(scopeGroupId, "socialprofile.xml.template");
		
		XMLManipulator manipulator = new XMLManipulator(spParameters.getDescription());
		manipulator.cleanupXML();
		
		if (manipulator.findNodeList("//profile/other_details").getLength() == 0) {// if

			// dynamic
			// section
			// parent
			// node
			// doesn't
			// exists

			manipulator.appendNode("other_details", "//profile"); // append

			// a
			// node
			// where
			// all
			// dynamic
			// section
			// will
			// be
			// appended
			// to

		}
		
		NodeList parentNodeList = manipulator.findNodeList("//other_details/" + newFormName); // check

		// if
		// parent
		// category
		// exists

		if (parentNodeList.getLength() == 0) { // parent

			// category
			// doesn't
			// exist, so
			// append to
			// "other_details"
			// parent
			// node

			manipulator.appendNode(newFormName, "//other_details");
		}
		
			spParameters.setDescription(manipulator.toString(null));
			SPParameterLocalServiceUtil.updateSPParameter(spParameters);
		} catch (NoSuchSPParameterException e) {
			_log.info("No such spparameter exist with key: socialprofile.xml.template"
					+ " groupId: " + scopeGroupId);
		} catch (Exception e) {
			_log.error("Exception getting SPParameter ==" + e.getMessage());
		}
		
		
	}

	public void createXMLTemplate(String categoryName, long scopeGroupId,
			String value, String description) {
		try {
			addOrUpdateSPParameter(categoryName + ".xml.template",
					scopeGroupId, value, description);
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		renderResponse.setContentType("text/html");
		PortletPreferences prefs = renderRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long scopeGroupId = themeDisplay.getScopeGroupId();
		boolean signedIn = themeDisplay.isSignedIn();
		String formName = StringPool.BLANK;
		String xslName = StringPool.BLANK;

		if (signedIn) {
			List<SocialProfileField> fieldsList = new ArrayList<SocialProfileField>();
			Map<String, String[]> preferences = prefs.getMap();

			xslName = prefs.getValue("name", StringPool.BLANK);
			formName = prefs.getValue("formLabel",
					xslName.replaceAll(StringPool.UNDERLINE, StringPool.SPACE));

			for (Map.Entry<String, String[]> entry : preferences.entrySet()) {
				String key = entry.getKey();

				if (("name".equals(key)) || ("formedit".equals(key))
						|| ("formLabel".equals(key))) {
					continue;
				}

				String[] value = entry.getValue();
				String fieldAttr = StringPool.BLANK;
				if (value.length > 0) {
					fieldAttr = value[0];
				}

				SocialProfileField spField = getSocialProfileField(key,
						fieldAttr);

				if (Validator.isNotNull(xslName)) {
					String propKey = "userprofile.system.fields." + xslName;
					boolean sysField = isSystemField(propKey, key);
					spField.setSystemField(sysField);

					if (sysField) {
						boolean searchable = isSearchable(key);
						boolean indexable = isIndexable(key);

						spField.setSearchable(searchable);
						spField.setIndexable(indexable);
					}
				}
				fieldsList.add(spField);
			}// end for

			String xslNames = SambaashUtil.getParameter(
					ProfileConstants.USER_PROFILE.XSLNAMES, scopeGroupId);
			String[] xslNamesArr = {};
			if (Validator.isNotNull(xslNames)) {
				xslNamesArr = xslNames.split(StringPool.COMMA);
			}

			// Setup system fields
			Map<String, List<SocialProfileField>> fieldsByCategory = new HashMap<String, List<SocialProfileField>>();// retrieve
																														// all
																														// available
																														// fields
																														// per
																														// category
			for (int i = 0; i < xslNamesArr.length; i++) {
				String fieldName = xslNamesArr[i];
				String xslFields = SambaashUtil.getParameter(fieldName
						+ ".fields", scopeGroupId);
				if (Validator.isNotNull(xslFields)) {
					String[] fields = xslFields.split(StringPool.COMMA);
					List<SocialProfileField> spFldList = new ArrayList<SocialProfileField>();
					for (int j = 0; j < fields.length; j++) {
						String fName = fields[j];
						SocialProfileField f = new SocialProfileField(fName,
								UserProfileUtil.fieldIdToLabel(fName));
						String propKey = "userprofile.system.fields."
								+ fieldName;
						boolean sysField = isSystemField(propKey, fName);
						boolean searchable = isSearchable(fName);
						boolean indexable = isIndexable(fName);

						f.setSystemField(sysField);
						f.setSearchable(searchable);
						f.setIndexable(indexable);

						spFldList.add(f);
					}
					fieldsByCategory.put(fieldName, spFldList);
				}

			}

			renderRequest.setAttribute("curXslName",
					prefs.getValue("name", StringPool.BLANK));
			renderRequest.setAttribute("formEdittable",
					prefs.getValue("formedit", "true"));
			renderRequest.setAttribute("fieldList", fieldsList);
			renderRequest.setAttribute("xslNamesArr", xslNamesArr);// list of
																	// field
																	// options
			renderRequest.setAttribute("fieldsByCategory", fieldsByCategory);// list
																				// of
																				// available
																				// fields
																				// per
																				// category
			renderRequest.setAttribute("fieldTypes",
					UserProfileUtil.getFieldTypes(scopeGroupId));
			renderRequest.setAttribute("validationTypes",
					UserProfileUtil.getFieldValidationTypeList(scopeGroupId));
			renderRequest.setAttribute("assetVocabulary",
					UserProfileUtil.getAllAssetVocabulary(scopeGroupId));
			renderRequest.setAttribute("formLabel",
					SambaashHtmlUtil.unescape(formName));
			include(editTemplate, renderRequest, renderResponse);
		}// end signedin
	}

	public SPParameter addOrUpdateSPParameter(String key, long groupId,
			String value, String description) throws SystemException {
		SPParameter spParameters = null;
		
		try {
			spParameters = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(groupId, key);
		} catch (NoSuchSPParameterException e) {
			_log.info("No such spparameter exist with key: " + key
					+ " groupId: " + groupId);
		} catch (Exception e) {
			_log.error("Exception getting SPParameter ==" + e.getMessage());
		}
		if (spParameters == null) {
		//	long spparamId;
			try {
				/*spparamId = CounterLocalServiceUtil
						.increment("SPParameter.class");*/
				spParameters = SPParameterLocalServiceUtil.getNewSPParameter();
				spParameters.setName(key);
				spParameters.setValue(value);
				spParameters.setDescription(description);
				spParameters = SPParameterLocalServiceUtil.updateSPParameter(spParameters);
			} catch (SystemException e) {
				_log.error("Error creating SPParameter: " + e.getMessage());
			}
		} else {
			spParameters.setName(key);
			spParameters.setValue(value);
			spParameters.setDescription(description);
			spParameters = SPParameterLocalServiceUtil
					.updateSPParameter(spParameters);
		}
		SPParameterLocalServiceUtil.clearSPParameterPool(groupId, key);
		SPParameterLocalServiceUtil.clearSPParameterPool(0, key);
		return spParameters;
	}

	private boolean isIndexable(String fieldName) {
		String indexableFields = getResourceBundleFields(ProfileConstants.USER_PROFILE.INDEXABLE_FIELDS);

		if (Validator.isNotNull(indexableFields)) {
			indexableFields = "," + indexableFields + ",";

			if (indexableFields.indexOf("," + fieldName + ",") >= 0) {
				return true;
			}
		}
		return false;
	}

	private boolean isSearchable(String fieldName) {
		String searchableFields = getResourceBundleFields(ProfileConstants.USER_PROFILE.SEARCHABLE_FIELDS);
		if (Validator.isNotNull(searchableFields)) {
			searchableFields = "," + searchableFields + ",";

			if (searchableFields.indexOf("," + fieldName + ",") >= 0) {
				return true;
			}
		}
		return false;
	}

	private boolean isSystemField(String key, String fieldName) {
		String systemFields = getResourceBundleFields(key);
		if (Validator.isNotNull(systemFields)) {
			systemFields = "," + systemFields + ",";

			if (systemFields.indexOf("," + fieldName + ",") >= 0) {
				return true;
			}
		}
		return false;
	}

	protected SocialProfileField getSocialProfileField(String key,
			String fieldAttr) {

		SocialProfileField spField = new SocialProfileField();

		spField.setFieldName(key);
		spField.setFieldLabel(UserProfileUtil.fieldIdToLabel(key));

		if (Validator.isNotNull(fieldAttr)) {
			// read through field properties
			String[] fieldProps = fieldAttr.split(StringPool.COMMA);
			for (int i = 0; i < fieldProps.length; i++) {
				String propName = fieldProps[i];
				String[] tempProp = propName.split(StringPool.COLON);

				if (tempProp.length >= 2) {
					String keyProp = tempProp[0];
					String valueProp = tempProp[1];

					if (("indexable".equalsIgnoreCase(keyProp))
							&& ("true".equals(valueProp))) {
						spField.setIndexable(true);
					} else if (("searchable".equalsIgnoreCase(keyProp))
							&& ("true".equals(valueProp))) {
						spField.setSearchable(true);
					} else if (("edittable".equalsIgnoreCase(keyProp))
							&& ("true".equals(valueProp))) {
						spField.setEdittable(true);
					} else if (("fieldType".equalsIgnoreCase(keyProp))
							&& (Validator.isNotNull(valueProp))) {
						spField.setType(valueProp);
					} else if (("default".equalsIgnoreCase(keyProp))
							&& (Validator.isNotNull(valueProp))) {
						spField.setDefaultValue(valueProp);
					} else if (("maxLen".equalsIgnoreCase(keyProp))
							&& (Validator.isNotNull(valueProp))) {
						spField.setMaxlength(Integer.valueOf(valueProp));
					} else if (("mandatory".equalsIgnoreCase(keyProp))
							&& ("true".equals(valueProp))) {
						spField.setMandatory(true);
					} else if (("display".equalsIgnoreCase(keyProp))
							&& ("true".equals(valueProp))) {
						spField.setDisplay(true);
					} else if (("validation".equalsIgnoreCase(keyProp))
							&& (Validator.isNotNull(valueProp))) {
						spField.setValidationType(Integer.valueOf(valueProp));
					} else if (("options".equalsIgnoreCase(keyProp))
							&& (Validator.isNotNull(valueProp))) {
						spField.setOptions(valueProp);
					} else if (("private".equalsIgnoreCase(keyProp))
							&& ("true".equals(valueProp))) {
						spField.setPrivateView(true);
					} else if (("label".equalsIgnoreCase(keyProp))
							&& (Validator.isNotNull(valueProp))) {
						spField.setFieldLabel(valueProp);
					} else if (("level".equalsIgnoreCase(keyProp))
							&& (Validator.isNotNull(valueProp))) {
						spField.setLevelValue(valueProp);
					}
				}
			}// end for
		}// if not null
		return spField;
	}

	public void transform(Source xml, Source xsl, Result result,
			HashMap<String, Object> params) throws TransformerException {
		TransformerFactory tfactory = TransformerFactory.newInstance();
		Transformer t = tfactory.newTransformer(xsl);

		Iterator<Map.Entry<String, Object>> iter = params.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Object> entry = iter.next();
			t.setParameter((String) entry.getKey(), entry.getValue());
		}
		t.transform(xml, result);
	}

	public Source SourceFromFilename(String filename) {
		File file = new File(filename);
		Source source = new StreamSource(file);
		return source;
	}

	public String getCurrentURL(ThemeDisplay themeDisplay) {
		StringBuilder sb = new StringBuilder();
		sb.append(SambaashUtil.getPortalURL(themeDisplay.getCompanyId(),
				themeDisplay.getScopeGroupId()));
		sb.append(StringPool.SLASH);

		return sb.toString();
	}

	public String getCountries() {
		StringBuffer countries = new StringBuffer();
		List<Country> countryList;
		try {
			countryList = CountryServiceUtil.getCountries();

			for (Country country : countryList) {
				if (countries.length() > 0)
					countries.append(StringPool.COMMA);

				countries.append(country.getName());
			}
		} catch (SystemException e) {
			_log.error("Error occured in getting countries : " + e.getMessage());
		}
		return countries.toString();
	}

	public String[] getAssetTags(String expertise) {
		String[] assetTags = null;
		String aTags = expertise;
		String[] tagsArr = aTags.trim().split(StringPool.COMMA);
		if (aTags != null && aTags != StringPool.BLANK)
			assetTags = new String[tagsArr.length];
		else
			return null;
		for (int i = 0; i < tagsArr.length; i++) {
			if (tagsArr[i].length() > 1) {
				assetTags[i] = tagsArr[i].trim();
			}
		}
		return assetTags;
	}

	public String getCommunityName(ThemeDisplay themeDisplay) {
		String communityName = SambaashUtil.getCommunityName(themeDisplay
				.getScopeGroupId());

		ResourceBundle res = getProfileResourceBundle();

		if (communityName.equals(StringPool.BLANK)
				|| !res.containsKey(communityName
						+ ".userprofile.personalinfo.location.label")) {
			return ProfileConstants.USER_PROFILE.DEFAULT_COMMUNITY_NAME;
		}

		return communityName;
	}

	public ResourceBundle getProfileResourceBundle() {
		ResourceBundle res = ResourceBundle
				.getBundle(ProfileConstants.USER_PROFILE.RESOURCE_BUNDLE_NAME);
		return res;
	}

	public String getWorkHistoryOverlapSettings(long groupId) {
		SPParameter parameter = null;
		String token = "false";

		try {
			parameter = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(groupId,
							ProfileConstants.USER_PROFILE.OVERLAPPING_TOKEN);
			token = parameter.getValue();
		} catch (NoSuchSPParameterException e) {
			_log.error(e.getMessage(), e);
		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
		}

		return token;
	}

	public String getResourceBundleFields(final String key) {
		ResourceBundle res = null;
		if (Validator.isNull(key)) {
			return StringPool.BLANK;
		}
		try {
			res = ResourceBundle
					.getBundle(ProfileConstants.USER_PROFILE.RESOURCE_BUNDLE_FIELDS);
			return res.getString(key);
		} catch (Exception e) {
			_log.info("Resource bundle not found. " + e.getMessage());
		}
		return StringPool.BLANK;
	}

	public void getLocationValues(ResourceResponse response) {
		try {
			JSONArray jsonResult = com.liferay.portal.kernel.json.JSONFactoryUtil
					.createJSONArray();
			JSONObject jsonRow = com.liferay.portal.kernel.json.JSONFactoryUtil
					.createJSONObject();

			String locationValues = SocialProfileLocalServiceUtil
					.findSocialProfileLocation() + "," + getCountries();

			jsonRow.put("values", locationValues);
			jsonRow.put("status", "200");
			jsonResult.put(jsonRow);
			response.getWriter().append(jsonResult.toString());
		} catch (IOException e) {
			_log.error("error getting json result " + e.getMessage());
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}

	public void getExpertiseValues(ResourceResponse response) {
		try {
			String expertiseValues = SocialProfileLocalServiceUtil
					.getExpertiseTags();

			JSONArray jsonResult = com.liferay.portal.kernel.json.JSONFactoryUtil
					.createJSONArray();
			JSONObject jsonRow = com.liferay.portal.kernel.json.JSONFactoryUtil
					.createJSONObject();
			jsonRow.put("values", expertiseValues);
			jsonRow.put("status", "200");
			jsonResult.put(jsonRow);
			response.getWriter().append(jsonResult.toString());
		} catch (IOException e) {
			_log.error("error getting json result " + e.getMessage());
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}

	/**
	 * Single instance
	 * 
	 * @param tagValue
	 * @param category
	 * @param status
	 * @param response
	 */
	public void getJsonResult(String tagValue, String category, String status,
			String message, ResourceResponse response) {
		try {
			_log.debug("getJsonResult " + category);
			JSONArray jsonResult = com.liferay.portal.kernel.json.JSONFactoryUtil
					.createJSONArray();
			JSONObject jsonRow = com.liferay.portal.kernel.json.JSONFactoryUtil
					.createJSONObject();
			jsonRow.put("tag", tagValue);
			jsonRow.put("category", category);
			jsonRow.put("status", status);
			jsonRow.put("message", message);
			jsonResult.put(jsonRow);
			response.getWriter().append(jsonResult.toString());
		} catch (IOException e) {
			_log.error("error getting json result " + e.getMessage());
		}
	}

	/**
	 * By instance
	 * 
	 * @param tagValue
	 * @param count
	 * @param instance
	 * @param category
	 * @param status
	 * @param response
	 */
	public void getJsonResult(String tagValue, long count, String instance,
			String category, String status, ResourceResponse response) {
		try {
			_log.debug("getJsonResult " + category);
			JSONArray jsonResult = com.liferay.portal.kernel.json.JSONFactoryUtil
					.createJSONArray();
			JSONObject jsonRow = com.liferay.portal.kernel.json.JSONFactoryUtil
					.createJSONObject();
			jsonRow.put("tag", tagValue);
			jsonRow.put("instanceCount", count);
			jsonRow.put("instance", instance);
			jsonRow.put("category", category);
			jsonRow.put("status", "200");
			jsonResult.put(jsonRow);
			response.getWriter().append(jsonResult.toString());
		} catch (IOException e) {
			_log.error("error getting json result " + e.getMessage());
		}
	}

	/**
	 * Instance is base on nodeId instead of counter
	 * 
	 * @param tagValue
	 * @param instance
	 * @param category
	 * @param status
	 * @param response
	 */
	public void appendInstanceJsonResult(String tagValue, String instance,
			String category, String status, ResourceResponse response) {
		getJsonResult(tagValue, 0, instance, category, status, response);
	}

	/**
	 * Triggered after updating single node field Saves the profile details to
	 * the respective DB column
	 * 
	 * @param fieldName
	 * @param value
	 * @param profileUser
	 * @param themeDisplay
	 * @return
	 */
	public String saveProfileInfo(String fieldName, String value,
			SocialProfile profileUser, User user, ThemeDisplay themeDisplay) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		long scopeGroupId = 0;

		try {
			String resultXML = SocialProfileLocalServiceUtil
					.updateSingleNodeField(profileUser.getUserInfo(),
							fieldName, value);
			profileUser.setUserInfo(resultXML);
			String assetTags[] = null;
			scopeGroupId = themeDisplay.getScopeGroupId();

			if (fieldName.equalsIgnoreCase("area_of_expertise")) {
				assetTags = getAssetTags(value);
				SocialProfileLocalServiceUtil.updateSocialProfileAndTags(
						profileUser, assetTags, scopeGroupId);
				SocialProfileLocalServiceUtil.addOrUpdateSocialProfile(
						profileUser, user, false, scopeGroupId);
			} else {

				if (fieldName.equalsIgnoreCase("location")) {
					profileUser.setLocation(value);
				} else if (fieldName.equalsIgnoreCase("title")) {
					profileUser.setTitle(value);
					user.setJobTitle(value);
				} else if (fieldName.equalsIgnoreCase("about")) {
					profileUser.setAbout(value);
				} else if (fieldName.equalsIgnoreCase("interest")) {
					profileUser.setInterest(value);
				} else if (fieldName.equalsIgnoreCase("honors")) {
					profileUser.setHonors(value);
				} else if (fieldName.equalsIgnoreCase("group_association")) {
					profileUser.setGroupAssociation(value);
				} else if (fieldName.equalsIgnoreCase("about")) {
					profileUser.setAbout(value);
				} else if (fieldName.equalsIgnoreCase("screen_name")) {
					if (!user.getScreenName().equals(value)) {
						SocialProfileLocalServiceUtil.updateUserScreenName(
								user.getUserId(), value);
						user.setScreenName(value);
					}
				} else if (fieldName.equalsIgnoreCase("skills_qualification")) {
					profileUser.setSkillsQualification(value);
				} else if (fieldName.equalsIgnoreCase("training_education")) {
					profileUser.setTrainingEducation(value);
				} else if (fieldName.equalsIgnoreCase("user_status")) {
					user.setGreeting(value);
				} else if (fieldName.equalsIgnoreCase("first_name")) {
					user.setFirstName(value);
				} else if (fieldName.equalsIgnoreCase("last_name")) {
					user.setLastName(value);
				} else if (fieldName.equalsIgnoreCase("gender")) {
					SocialProfileLocalServiceUtil.updateGender(user, value);

				} else if (fieldName.equalsIgnoreCase("date_of_birth")) {
					DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					Date bday = (Date) formatter.parse(value);
					SocialProfileLocalServiceUtil.updateBirthday(user, bday);
				}
				_log.error("Updating UserProfile");
				SocialProfileLocalServiceUtil.addOrUpdateSocialProfile(
						profileUser, user, false, scopeGroupId);
				SocialProfileLocalServiceUtil.updateUser(user);
			}
			json.put("status", "200");
			json.put("fieldValue", value);
		} catch (DuplicateUserScreenNameException e) {
			_log.error("DuplicateUserScreenNameException ");
			json.put("status", "404");
			json.put("message", "Screen name is already in use.");
		} catch (UserScreenNameException e) {
			_log.error("UserScreenNameException: " + e.getMessage());
			json.put("status", "404");
			json.put("message", "Invalid screen name.");
		} catch (SystemException e) {
			_log.error("Unable to save Social Profile Personal Info: "
					+ e.getMessage());
			json.put("status", "404");
		} catch (Exception e) {
			_log.error("Unable to save Social Profile Personal Info: "
					+ e.getMessage());
			json.put("status", "404");
		}
		return json.toString();
	}

	/**
	 * Creates new textbox by instance number and a delete button Returns as
	 * JSON response and will be parsed using javascript to display as HTML
	 * 
	 * @param themeDisplay
	 * @param categoryName
	 * @param categoryDetail
	 * @param instance
	 * @param profileUser
	 * @param request
	 * @param response
	 */

	public void addSingleInputField(ThemeDisplay themeDisplay,
			String categoryName, String categoryDetail, String instance,
			SocialProfile profileUser, String displayField,
			ResourceResponse response) {

		List<SPListType> msgType = new ArrayList<SPListType>();
		try {
			int count = Integer.valueOf(instance);

			String Id = categoryName + "_Input_" + count;
			String sId = categoryName + "_select_" + count;
			String divId = categoryName + "_" + count;
			String jScript = "javascript:removeElement('new_" + divId + "');";
			StringBuffer tagValue = new StringBuffer();
			StringBuffer optionTags = null;

			if (categoryName.equals("messenger")) {
				optionTags = new StringBuffer();
				msgType = UserProfileUtil.getMessengers(themeDisplay
						.getScopeGroupId());
				if (msgType != null && msgType.size() > 0) {
					for (SPListType list : msgType) {
						optionTags.append("<option>")
								.append(list.getItemValue())
								.append("</option>");
					}
				}

				tagValue.append("<div id='new_" + divId + "'>")
						.append("<div class='networkinformation-value'><select id='")
						.append(sId)
						.append("' name='")
						.append(sId)
						.append("'>")
						.append(optionTags.toString())
						.append("</select><input type='text' id='")
						.append(Id)
						.append("' class='single-input-social' category='")
						.append(categoryName)
						.append("' position='"
								+ count
								+ "' mandatory='true' maxlength='1000'/>"
								+ "<a href=\"javascript:saveNetworkInfo('"
								+ Id
								+ "');\" class=\"ie7-update-button\">&#160;</a>"
								+ "<div id='")
						.append(Id)
						.append("_iconstatus' class='msg_tooltip'></div></div><div class='networkinformation-button'><a class='book userprofile-delete-link' href=")
						.append(jScript)
						.append(" title='Delete'>&#160;</a></div></div>");

			} else if (categoryName.equals("twitter")) {
				tagValue.append("<div id='new_")
						.append(divId)
						.append("' class='workhistory-paddingbottom'><div class='workhistory-inputuserprofileaction' ><span class='networkinfo-inputfield'>http://www.twitter.com/</span><span><input type='text' id='")
						.append(Id)
						.append("' class='single-input-social' category='")
						.append(categoryName)
						.append("' position='"
								+ count
								+ "' mandatory='true' style='width:120px' maxlength='1000' />"
								+ "<a href=\"javascript:saveNetworkInfo('"
								+ Id
								+ "');\" class=\"ie7-update-button\">&#160;</a>"
								+ "</span><div id='")
						.append(Id)
						.append("_iconstatus' class='msg_tooltip' /></div></div><div class='workhistory-inputuserprofile-delete-link'><a class='book userprofile-delete-link' href=")
						.append(jScript)
						.append(" title='Delete'>&#160;</a></div></div>");

			} else if (categoryName.equals("facebook")) {
				tagValue.append("<div id='new_")
						.append(divId)
						.append("' class='workhistory-paddingbottom'><div class='workhistory-inputuserprofileaction' ><span class='networkinfo-inputfield'>http://www.facebook.com/</span><span><input type='text' id='")
						.append(Id)
						.append("' class='single-input-social' category='")
						.append(categoryName)
						.append("' position='"
								+ count
								+ "' mandatory='true' style='width:120px' maxlength='1000' />"
								+ "<a href=\"javascript:saveNetworkInfo('"
								+ Id
								+ "');\" class=\"ie7-update-button\">&#160;</a>"
								+ "</span><div id='")
						.append(Id)
						.append("_iconstatus' class='msg_tooltip' /></div></div><div class='workhistory-inputuserprofile-delete-link'><a class='book userprofile-delete-link' href=")
						.append(jScript)
						.append(" title='Delete'>&#160;</a></div></div>");

			} else {

				try {
					HashMap<String, Object> params = new HashMap<String, Object>();
					String xslFile = getClass().getResource(
							ProfileConstants.USER_PROFILE.XSL_PATH
									+ "network_info_add.xsl").getFile();
					String xmlFile = SambaashHtmlUtil.unescape(profileUser
							.getUserInfo());

					Source xml;
					Source xsl;
					StringWriter writer = new StringWriter();
					Result result = new javax.xml.transform.stream.StreamResult(
							writer);
					String htmlContent = StringPool.BLANK;

					try {
						DocumentBuilder parser = DocumentBuilderFactory
								.newInstance().newDocumentBuilder();
						Document document = parser.parse(new InputSource(
								new StringReader(xmlFile)));
						xml = new DOMSource(document);
						xsl = SourceFromFilename(xslFile);

						// get the default value
						XMLManipulator manipulator = new XMLManipulator(xmlFile);
						String selected = manipulator.getDefault(categoryName);

						if (selected == null)
							selected = StringPool.BLANK;

						params.put("category", categoryName);
						params.put("instance", instance);
						params.put("selected", selected);
						params.put("scopeGroupId",
								themeDisplay.getScopeGroupId());

						transform(xml, xsl, result, params);
						htmlContent = writer.toString();

						tagValue.append(htmlContent);
					} catch (Exception e) {
						_log.error("Exception: " + e.getMessage());
					}

				} catch (Exception e1) {
					_log.error("cannot add multiple input field "
							+ e1.getMessage());
				}

			}

			getJsonResult(tagValue.toString(), count, instance, categoryName,
					"200", response);
		} catch (Exception e) {
			_log.error("cannot add single input field " + e.getMessage());
		}

	}

	/**
	 * Save new single input field by category name This will append new xml
	 * node with a specific category name Sample Output:
	 * <websites><websites_url>www.yahoo.com</websites_url></websites>
	 * 
	 * @param themeDisplay
	 * @param categoryName
	 *            - i.e. websites
	 * @param categoryDetail
	 *            - i.e. websites_url
	 * @param inputValue
	 *            - i.e. www.sambaash.com
	 * @param profileUser
	 * @param response
	 */
	public void saveSingleInputField(ThemeDisplay themeDisplay,
			String categoryName, String categoryDetail, String inputValue,
			SocialProfile profileUser, User user, String instance,
			ResourceResponse response) {

		HashMap<String, Object> params = new HashMap<String, Object>();
		// long scopeGroupId = 0;

		try {
			SocialProfileLocalServiceUtil.addNetworkInfo(profileUser,
					categoryName, categoryDetail, inputValue);
			params.put("communityName", getCommunityName(themeDisplay));
			params.put("resource", getProfileResourceBundle());
			params.put("section", categoryName);

			getXMLSectionByCategory(themeDisplay, instance, categoryName,
					profileUser, params, "200", StringPool.BLANK, response);
		} catch (Exception e) {
			_log.error("cannot save single input field " + e.getMessage());
		}

	}

	/**
	 * This to add a instance with multiple inputs(generated from xml & xsl)
	 * 
	 * @param themeDisplay
	 * @param categoryName
	 * @param instance
	 * @param profileUser
	 * @param response
	 */

	public void addMultipleInputFieldDetails(ThemeDisplay themeDisplay,
			String categoryName, String categoryDetails, String instance,
			SocialProfile profileUser, String displayField,
			ResourceResponse response) {

		HashMap<String, Object> params = new HashMap<String, Object>();

		params.put("employeeValues",
				UserProfileUtil.getCompanySizes(themeDisplay.getScopeGroupId()));
		params.put("indType",
				UserProfileUtil.getIndustryType(themeDisplay.getScopeGroupId()));
		params.put("resource", getProfileResourceBundle());
		params.put("communityName", getCommunityName(themeDisplay));
		params.put("displayField", displayField);

		addMultipleInputField(themeDisplay, categoryName, categoryDetails,
				instance, profileUser, params, response);
	}

	public void addMultipleInputField(ThemeDisplay themeDisplay,
			String categoryName, String categoryDetails, String instance,
			SocialProfile profileUser, HashMap<String, Object> params,
			ResourceResponse response) {

		String xmlFile = StringPool.BLANK;
		String xslFile = StringPool.BLANK;
		XMLManipulator manipulator = null;
		SPParameter parameter = null;

		if (Validator.isNotNull(categoryName)) {
			try {

				manipulator = new XMLManipulator(profileUser.getUserInfo());

				parameter = SPParameterLocalServiceUtil
						.findBySPParameterGroupIdAndName(
								themeDisplay.getScopeGroupId(), categoryName
										+ ".xml.template");
				xmlFile = parameter.getDescription();
				// manipulator.appendXml(categoryName, xmlFile);

				try {
					xslFile = getClass().getResource(
							ProfileConstants.USER_PROFILE.XSL_PATH
									+ categoryName + "_add.xsl").getFile();
				} catch (Exception e) {
					_log.debug("Cannot find XSL file: " + e.getMessage());
				}

				if (Validator.isNull(xslFile)) {
					xslFile = getClass().getResource(
							ProfileConstants.USER_PROFILE.XSL_PATH
									+ "dynamic_section_add.xsl").getFile();
					params.put("section_name", categoryName);
					params.put("category_details", categoryDetails);
					manipulator.appendXml("//other_details/" + categoryName,
							xmlFile);
				} else {
					manipulator.appendXml(categoryName, xmlFile);
				}

				Source xml;
				Source xsl;
				StringWriter writer = new StringWriter();
				Result result = new javax.xml.transform.stream.StreamResult(
						writer);
				String htmlContent = StringPool.BLANK;
				String status = "200";
				String _instance = String.valueOf(new Date().getTime());

				try {
					DocumentBuilder parser = DocumentBuilderFactory
							.newInstance().newDocumentBuilder();
					Document document = parser.parse(new InputSource(
							new StringReader(xmlFile)));
					xml = new DOMSource(document);
					xsl = SourceFromFilename(xslFile);

					params.put("instance", _instance);
					params.put("scopeGroupId", themeDisplay.getScopeGroupId());

					transform(xml, xsl, result, params);
					htmlContent = writer.toString();

				} catch (Exception e) {
					_log.error("Exception: " + e.getMessage());
				}

				appendInstanceJsonResult(htmlContent, _instance, categoryName,
						status, response);
			} catch (Exception e1) {
				_log.error("cannot add multiple input field " + e1.getMessage());
			}
		}// end validator is not null
	}

	public void editContactDetails(ThemeDisplay themeDisplay,
			String categoryName, String instance, SocialProfile profileUser,
			String displayField, ResourceResponse response) {

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("displayField", displayField);
		params.put("loadCountry", getCountries());
		params.put("communityName", getCommunityName(themeDisplay));
		params.put("resource", getProfileResourceBundle());
		params.put("instance", instance);
		params.put("scopeGroupId", themeDisplay.getScopeGroupId());

		editInputInstanceDetails(themeDisplay, categoryName, instance,
				profileUser, params, response);
	}

	public void editWorkHistoryDetails(ThemeDisplay themeDisplay,
			String categoryName, String instance, SocialProfile profileUser,
			String displayField, ResourceResponse response) {

		HashMap<String, Object> params = new HashMap<String, Object>();

		params.put("employeeValues",
				UserProfileUtil.getCompanySizes(themeDisplay.getScopeGroupId()));
		params.put("indType",
				UserProfileUtil.getIndustryType(themeDisplay.getScopeGroupId()));
		params.put("instance", instance);
		params.put("displayField", displayField);
		params.put("communityName", getCommunityName(themeDisplay));
		params.put("resource", getProfileResourceBundle());
		params.put("scopeGroupId", themeDisplay.getScopeGroupId());
		params.put("section_name", categoryName);

		editInputInstanceDetails(themeDisplay, categoryName, instance,
				profileUser, params, response);
	}

	public void editInputInstanceDetails(ThemeDisplay themeDisplay,
			String categoryName, String instance, SocialProfile profileUser,
			HashMap<String, Object> params, ResourceResponse response) {

		_log.debug("Category: " + categoryName + " Instance:" + instance);

		String xslFile = StringPool.BLANK;
		Source xml;
		Source xsl;
		StringWriter writer = new StringWriter();
		Result result = new javax.xml.transform.stream.StreamResult(writer);
		String htmlContent = StringPool.BLANK;
		String status = "200";

		try {
			xslFile = getClass().getResource(
					ProfileConstants.USER_PROFILE.XSL_PATH + categoryName
							+ "_edit.xsl").getFile();
		} catch (Exception e) {
			_log.debug("Cannot find XSL file: " + e.getMessage());
		}

		if (Validator.isNull(xslFile)) {
			xslFile = getClass().getResource(
					ProfileConstants.USER_PROFILE.XSL_PATH
							+ "dynamic_section_edit.xsl").getFile();
		}
		
		if (profileUser != null && !xslFile.isEmpty()) {
			DocumentBuilder parser;
			try {
				parser = DocumentBuilderFactory.newInstance()
						.newDocumentBuilder();
				String xmlInfo = SambaashHtmlUtil.unescape(profileUser
						.getUserInfo());
				xml = new DOMSource(parser.parse(new InputSource(
						new StringReader(xmlInfo))));
				xsl = SourceFromFilename(xslFile);
				transform(xml, xsl, result, params);
				htmlContent = writer.toString();
			} catch (Exception e) {
				_log.error("Error on editInputInstanceDetails: "
						+ e.getMessage());
			}
		}
		appendInstanceJsonResult(htmlContent, instance, categoryName, status,
				response);
	}

	public void getXMLSectionByCategory(ThemeDisplay themeDisplay,
			String xslName, String categoryName, SocialProfile profileUser,
			HashMap<String, Object> params, String status, String message,
			ResourceResponse response) {

		_log.debug("Category: " + categoryName);

		String xslFile = getClass().getResource(
				ProfileConstants.USER_PROFILE.XSL_PATH + xslName
						+ "_section.xsl").getFile();
		Source xml;
		Source xsl;
		StringWriter writer = new StringWriter();
		Result result = new javax.xml.transform.stream.StreamResult(writer);
		String htmlContent = StringPool.BLANK;

		if (profileUser != null && !xslFile.isEmpty()) {
			DocumentBuilder parser;
			try {
				parser = DocumentBuilderFactory.newInstance()
						.newDocumentBuilder();
				String xmlInfo = SambaashHtmlUtil.unescape(profileUser
						.getUserInfo());
				xml = new DOMSource(parser.parse(new InputSource(
						new StringReader(xmlInfo))));
				xsl = SourceFromFilename(xslFile);
				transform(xml, xsl, result, params);
				htmlContent = writer.toString();
			} catch (Exception e) {
				_log.error("Error on getXMLCategorySectionDetails: "
						+ e.getMessage());
			}
		}
		getJsonResult(htmlContent, categoryName, status, message, response);
	}

	public void removeInputField(String categoryName, String categoryDetails,
			String instance, ResourceResponse response,
			SocialProfile profileUser) {

		int count = SocialProfileLocalServiceUtil.deleteXMLInstance(
				categoryName, categoryDetails, instance, profileUser);
		getJsonResult(StringPool.BLANK, count - 1, instance, categoryName,
				"200", response);
	}

	public void updateUIWithModifiedData(ThemeDisplay themeDisplay,
			String categoryName, SocialProfile profileUser, String instance,
			ResourceResponse response, String displayField)
			throws PortalException, SystemException {
		_log.debug("displayField " + displayField);
		// SocialProfile profileUser =
		// SocialProfileLocalServiceUtil.getSocialProfile(themeDisplay.getUserId());
		String xslFile = StringPool.BLANK;
		Source xml;
		Source xsl;
		HashMap<String, Object> params = new HashMap<String, Object>();
		StringWriter writer = new StringWriter();
		Result result = new javax.xml.transform.stream.StreamResult(writer);
		String htmlContent = StringPool.BLANK;
		String status = "200";

		if (profileUser != null) {
			DocumentBuilder parser;

			try {
				xslFile = getClass().getResource(
						ProfileConstants.USER_PROFILE.XSL_PATH + categoryName
								+ "_undo"
								+ ProfileConstants.USER_PROFILE.XSL_FILE_EXT)
						.getFile();
			} catch (Exception e) {
				_log.debug("Cannot find XSL file: " + e.getMessage());
			}

			if (Validator.isNull(xslFile)) {
				xslFile = getClass().getResource(
						ProfileConstants.USER_PROFILE.XSL_PATH
								+ "dynamic_section_undo"
								+ ProfileConstants.USER_PROFILE.XSL_FILE_EXT)
						.getFile();
			}

			String defaultBillingId = StringPool.BLANK;
			String defaultShippingId = StringPool.BLANK;
			String[] indDisplay = displayField.split(",");
			for (int i = 0; i < indDisplay.length; i++) {
				if (indDisplay[i].equalsIgnoreCase("default_billing_address_9")) {
					defaultBillingId = indDisplay[i];
				}
				if (indDisplay[i]
						.equalsIgnoreCase("default_shipping_address_8")) {
					defaultShippingId = indDisplay[i];
				}
			}
			try {
				parser = DocumentBuilderFactory.newInstance()
						.newDocumentBuilder();
				String xmlInfo = SambaashHtmlUtil.unescape(profileUser
						.getUserInfo());
				xml = new DOMSource(parser.parse(new InputSource(
						new StringReader(xmlInfo))));
				xsl = SourceFromFilename(xslFile);
				params.put("employeeValues", UserProfileUtil
						.getCompanySizes(themeDisplay.getScopeGroupId()));
				params.put("indType", UserProfileUtil
						.getIndustryType(themeDisplay.getScopeGroupId()));
				params.put("saveData", "display:none");
				params.put("displayField", displayField);
				params.put("defaultBillingId", defaultBillingId);
				params.put("defaultShippingId", defaultShippingId);
				params.put("communityName", getCommunityName(themeDisplay));
				params.put("resource", getProfileResourceBundle());
				params.put("can_edit", "1");
				params.put("section_name", categoryName);

				transform(xml, xsl, result, params);
				htmlContent = writer.toString();
				_log.debug("htmlContent " + htmlContent);
			} catch (Exception e) {
				_log.error("Exception: " + e.getMessage());
			}
		}

		getJsonResult(htmlContent, 0, instance, categoryName, status, response);
	}

	public void updateAvailabilityInfoData(String sData, String categoryName,
			SocialProfile profileUser, User user, long scopeGroupId) {
		org.json.JSONObject jsonObject = null;
		String inst = StringPool.BLANK;
		String jsonArrStr = "[" + sData + "]";

		Map<String, String> availabilityInfo = new HashMap<String, String>();

		try {
			org.json.JSONArray newJArray = new org.json.JSONArray(jsonArrStr);

			for (int i = 0; i < newJArray.length(); i++) {

				jsonObject = new org.json.JSONObject(newJArray.getString(i));

				inst = jsonObject.getString("instance");

				for (int j = 0; j < jsonObject.names().length(); j++) {
					String tagId = jsonObject.names().getString(j);
					String tagValue = jsonObject.getString(tagId);

					if ((tagId != null) && (!tagId.equals(StringPool.BLANK))) {

						availabilityInfo.put(tagId, tagValue);
					}
				}
			}

			if (Validator.isNotNull(inst)) {
				SocialProfileLocalServiceUtil.addOrUpdateAvailability(
						categoryName, "user_availability", inst, profileUser,
						scopeGroupId, availabilityInfo);
			}

		} catch (NumberFormatException e) {
			_log.error("Error on updateWorkHistoryData: " + e.getMessage());
		} catch (JSONException e) {
			_log.error("Error on updateWorkHistoryData: " + e.getMessage());
		} catch (Exception e) {
			_log.error("Error on updateWorkHistoryData: " + e.getMessage());
		}
	}

	public void updateWorkHistoryData(String sData, String categoryName,
			SocialProfile profileUser, User user, long scopeGroupId) {
		org.json.JSONObject jsonObject = null;
		String inst = StringPool.BLANK;
		String jsonArrStr = "[" + sData + "]";

		Map<String, String> workDetails = new HashMap<String, String>();

		try {
			org.json.JSONArray newJArray = new org.json.JSONArray(jsonArrStr);

			for (int i = 0; i < newJArray.length(); i++) {

				jsonObject = new org.json.JSONObject(newJArray.getString(i));

				inst = jsonObject.getString("instance");

				for (int j = 0; j < jsonObject.names().length(); j++) {
					String tagId = jsonObject.names().getString(j);
					String tagValue = jsonObject.getString(tagId);

					if ((tagId != null) && (!tagId.equals(StringPool.BLANK))) {

						workDetails.put(tagId, tagValue);
					}

				}
			}

			if (Validator.isNotNull(inst)) {
				SocialProfileLocalServiceUtil.addOrUpdateWorkHistory(
						categoryName, "work_details", inst, profileUser,
						scopeGroupId, workDetails);
			}

		} catch (NumberFormatException e) {
			_log.error("Error on updateWorkHistoryData: " + e.getMessage());
		} catch (JSONException e) {
			_log.error("Error on updateWorkHistoryData: " + e.getMessage());
		} catch (Exception e) {
			_log.error("Error on updateWorkHistoryData: " + e.getMessage());
		}
	}

	public void updateDynamicSectionData(String sData, String categoryName,
			SocialProfile profileUser, User user, long scopeGroupId) {
		org.json.JSONObject jsonObject = null;
		String inst = StringPool.BLANK;
		String jsonArrStr = "[" + sData + "]";

		Map<String, String> categoryInfo = new HashMap<String, String>();

		try {
			org.json.JSONArray newJArray = new org.json.JSONArray(jsonArrStr);
			for (int i = 0; i < newJArray.length(); i++) {
				jsonObject = new org.json.JSONObject(newJArray.getString(i));
				inst = jsonObject.getString("instance");
				for (int j = 0; j < jsonObject.names().length(); j++) {
					String tagId = jsonObject.names().getString(j);
					String tagValue = jsonObject.getString(tagId);
					if ((tagId != null) && (!tagId.equals(StringPool.BLANK))) {
						categoryInfo.put(tagId, tagValue);
					}
				}
			}
			if (Validator.isNotNull(inst)) {
				SocialProfileLocalServiceUtil.addOrUpdateDynamicSection(
						categoryName, categoryName + "_details", inst,
						profileUser, scopeGroupId, categoryInfo);
			}
		} catch (NumberFormatException e) {
			_log.error("Error on update dynamic section Data: "
					+ e.getMessage());
		} catch (JSONException e) {
			_log.error("Error on update  dynamic section  Data: "
					+ e.getMessage());
		} catch (Exception e) {
			_log.error("Error on update  dynamic section  Data: "
					+ e.getMessage());
		}
	}

	public void updateContactInfoData(String sData, String categoryName,
			SocialProfile profileUser) {
		org.json.JSONObject jsonObject = null;
		String resultXML = StringPool.BLANK;
		String tagId = StringPool.BLANK;
		String tagValue = StringPool.BLANK;
		XMLManipulator manipulator = null;
		String jsonArrStr = "[" + sData + "]";

		try {

			org.json.JSONArray newJArray = new org.json.JSONArray(jsonArrStr);
			manipulator = new XMLManipulator(profileUser.getUserInfo());
			for (int i = 0; i < newJArray.length(); i++) {
				jsonObject = new org.json.JSONObject(newJArray.getString(i));
				for (int j = 0; j < jsonObject.names().length(); j++) {
					tagId = jsonObject.names().getString(j);
					tagValue = jsonObject.getString(tagId);
					manipulator.setNodeValue(tagValue, "//" + tagId);
				}
			}

			resultXML = manipulator.toString(null);
			profileUser.setUserInfo(resultXML);
			SocialProfileLocalServiceUtil.saveContactInfoXMLData(profileUser,
					sData, categoryName);
		} catch (Exception e) {
			_log.error(e);
			_log.error("Error on updateContactInfoXMLWithModifiedData: "
					+ e.getMessage());
		}
	}

	public void cancelProcess(ThemeDisplay themeDisplay, String categoryName,
			ResourceResponse response, SocialProfile profileUser,
			String displayField, String instance) {

		String xslFile = StringPool.BLANK;
		Source xml;
		Source xsl;
		HashMap<String, Object> params = new HashMap<String, Object>();
		StringWriter writer = new StringWriter();
		Result result = new javax.xml.transform.stream.StreamResult(writer);
		String htmlContent = StringPool.BLANK;
		String status = "200";

		try {
			xslFile = getClass().getResource(
					ProfileConstants.USER_PROFILE.XSL_PATH + categoryName
							+ "_undo"
							+ ProfileConstants.USER_PROFILE.XSL_FILE_EXT)
					.getFile();
		} catch (Exception e) {
			_log.debug("Cannot find XSL file: " + e.getMessage());
		}

		if (Validator.isNull(xslFile)) {
			xslFile = getClass().getResource(
					ProfileConstants.USER_PROFILE.XSL_PATH
							+ "dynamic_section_undo"
							+ ProfileConstants.USER_PROFILE.XSL_FILE_EXT)
					.getFile();
		}

		String defaultBillingId = StringPool.BLANK;
		String defaultShippingId = StringPool.BLANK;
		String[] indDisplay = displayField.split(",");
		_log.debug("displayField" + displayField);
		for (int i = 0; i < indDisplay.length; i++) {
			if (indDisplay[i].equalsIgnoreCase("default_billing_address_9")) {
				defaultBillingId = indDisplay[i];
			}
			if (indDisplay[i].equalsIgnoreCase("default_shipping_address_8")) {
				defaultShippingId = indDisplay[i];
			}
		}

		if (profileUser != null) {
			DocumentBuilder parser;
			try {
				parser = DocumentBuilderFactory.newInstance()
						.newDocumentBuilder();
				String xmlInfo = SambaashHtmlUtil.unescape(profileUser
						.getUserInfo());
				xml = new DOMSource(parser.parse(new InputSource(
						new StringReader(xmlInfo))));
				xsl = SourceFromFilename(xslFile);
				params.put("employeeValues", UserProfileUtil
						.getCompanySizes(themeDisplay.getScopeGroupId()));
				params.put("indType", UserProfileUtil
						.getIndustryType(themeDisplay.getScopeGroupId()));
				params.put("action", "editDetails");
				params.put("saveData", "display:none");
				params.put("displayField", displayField);
				params.put("defaultShippingId", defaultShippingId);
				params.put("defaultBillingId", defaultBillingId);
				params.put("loadCountry", getCountries());
				params.put("communityName", getCommunityName(themeDisplay));
				params.put("resource", getProfileResourceBundle());
				params.put("can_edit", "1");
				params.put("section_name", categoryName);

				transform(xml, xsl, result, params);
				htmlContent = writer.toString();
			} catch (Exception e) {
				_log.error("Error on cancelProcess: " + e.getMessage());
			}
		}
		appendInstanceJsonResult(htmlContent, instance, categoryName, status,
				response);
	}

}
