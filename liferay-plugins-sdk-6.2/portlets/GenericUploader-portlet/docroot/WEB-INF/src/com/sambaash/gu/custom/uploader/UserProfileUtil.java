package com.sambaash.gu.custom.uploader;

import java.io.FileInputStream;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileViewAuditLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class UserProfileUtil {

	public static List<SPListType> getSPListType(String key, long groupId) {
		try {
			return SPListTypeLocalServiceUtil.getByKey(key, groupId);
		} catch (SystemException e) {
			return null;
		}
	}

	public static List<AssetCategory> getAssetCategories(long groupId,
			String key) {
		try {
			SPParameter param = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(groupId, key);
			AssetVocabulary vocab = AssetVocabularyLocalServiceUtil
					.getGroupVocabulary(groupId, param.getValue());
			int noOfCategories = AssetCategoryLocalServiceUtil
					.getAssetCategoriesCount();
			return AssetCategoryLocalServiceUtil.getVocabularyCategories(
					vocab.getVocabularyId(), 0, noOfCategories, null);
		} catch (SystemException e) {
			_log.error("Error getting asset categories == " + e.getMessage());
		} catch (NoSuchSPParameterException e) {
			_log.error("Error getting asset categories == " + e.getMessage());
		} catch (PortalException e) {
			_log.error("Error getting asset categories == " + e.getMessage());
		}

		return null;
	}

	
	private static StringBuffer getAssetCategoryListAsString(
			List<AssetCategory> list) {
		StringBuffer listType = new StringBuffer();

		for (AssetCategory comp : list) {
			if (listType.length() > 0)
				listType.append(",");

			listType.append(comp.getName());
		}

		return listType;
	}

	public static String getRelatedPortfolio(long userId, String companyName) {
		StringBuffer listType = new StringBuffer();
		return listType.toString();
	}

	

	public void addUserContactInformation(long userId, String className,
			long classPK, String street1, String street2, String street3,
			String city, String zip, long regionId, long countryId, int typeId,
			boolean mailing, boolean primary, String number, String extension) {

		try {
			AddressLocalServiceUtil.addAddress(userId, className, classPK,
					street1, street2, street3, city, zip, regionId, countryId,
					typeId, mailing, primary);
			PhoneLocalServiceUtil.addPhone(userId, className, classPK, number,
					extension, typeId, primary);
		} catch (Exception e) {

			// need to delete address if adding phone fails

			_log.error(e.getMessage());
			return;
		}
	}

	

	public static String fieldIdToLabel(String fieldId) {
		if (Validator.isNull(fieldId)) {
			return "";
		}

		String label = "";
		fieldId = fieldId.trim();
		String[] words = fieldId.split(StringPool.UNDERLINE);

		for (int i = 0; i < words.length; i++) {
			String w = words[i];
			label += w.replaceFirst(w.substring(0, 1), w.substring(0, 1)
					.toUpperCase());

			if (i < words.length - 1) {
				label += StringPool.SPACE;
			}
		}

		return label;
	}

	public static String labelTofieldId(String label) {
		if (Validator.isNull(label)) {
			return "";
		}

		label = label.trim().toLowerCase();
		String fieldId = label.replace(StringPool.SPACE, StringPool.UNDERLINE);
		return fieldId;
	}

	public static String toString(String filePath) throws Exception {
		StringBuilder text = new StringBuilder();
		String NL = System.getProperty("line.separator");
		Scanner scanner = new Scanner(new FileInputStream(filePath), "UTF-8");
		try {
			while (scanner.hasNextLine()) {
				text.append(scanner.nextLine() + NL);
			}
		} finally {
			scanner.close();
		}

		return text.toString();
	}

	public static String escapeXML(String xml) {
		String escapedXmlStr = xml;

		if (Validator.isNotNull(xml)) {
			escapedXmlStr = escapedXmlStr.replaceAll("&", "&amp;");
			escapedXmlStr = escapedXmlStr.replaceAll(">", "&gt;");
			escapedXmlStr = escapedXmlStr.replaceAll("<", "&lt;");
			escapedXmlStr = escapedXmlStr.replaceAll("\"", "&quot;");
			escapedXmlStr = escapedXmlStr.replaceAll("'", "&apos;");

		}

		return escapedXmlStr;
	}

	public static Map<String, String> getSocialProfilePersonalInfoMap(
			SocialProfile socialProfile) throws PortalException,
			SystemException {

		XMLManipulator manipulator = new XMLManipulator(
				socialProfile.getUserInfo());
		Map<String, String> personalInfo = new HashMap<String, String>();
		try {
			personalInfo = manipulator.getNodeAsMap("//personal_info/*");
		} catch (Exception e) {
			_log.error("Error retrieving socialprofile personal info: "
					+ e.getMessage());
		}

		return personalInfo;
	}

	public static Map<String, String> getSocialProfileBasicInfoMap(
			SocialProfile socialProfile) throws PortalException,
			SystemException {

		XMLManipulator manipulator = new XMLManipulator(
				socialProfile.getUserInfo());
		Map<String, String> basicInfo = new HashMap<String, String>();
		try {
			basicInfo = manipulator.getNodeAsMap("//basic_info/*");
		} catch (Exception e) {
			_log.error("Error retrieving socialprofile basic info: "
					+ e.getMessage());
		}

		return basicInfo;
	}

	public static Map<String, Map<String, String>> getSocialProfileNetworkInfoMap(
			SocialProfile socialProfile) throws PortalException,
			SystemException {

		XMLManipulator manipulator = new XMLManipulator(
				socialProfile.getUserInfo());
		Map<String, Map<String, String>> networkInfo = new HashMap<String, Map<String, String>>();

		try {
			Map<String, String> websiteMap = manipulator
					.getNodeAsMap("//network_info/websites/websites_url");
			Map<String, String> twitterMap = manipulator
					.getNodeAsMap("//network_info/twitter/twitter_url");
			Map<String, String> facebookMap = manipulator
					.getNodeAsMap("//network_info/facebook/facebook_url");
			Map<String, String> linkedinMap = manipulator
					.getNodeAsMap("//network_info/linkedin/linkedin_url");
			Map<String, String> emailMap = manipulator
					.getNodeAsMap("//network_info/email/email_url");
			Map<String, String> messengerMap = manipulator
					.getNameValueNodeAsMap("//network_info/messenger/messenger_url/*");

			networkInfo.put("websites", websiteMap);
			networkInfo.put("twitter", twitterMap);
			networkInfo.put("facebook", facebookMap);
			networkInfo.put("linkedin", linkedinMap);
			networkInfo.put("email", emailMap);
			networkInfo.put("messenger", messengerMap);

		} catch (Exception e) {
			_log.error("Error retrieving socialprofile network info: "
					+ e.getMessage());
		}

		return networkInfo;
	}

	public static Map<String, Map<String, String>> getSocialProfileContactInfoMap(
			SocialProfile socialProfile) throws PortalException,
			SystemException {
		XMLManipulator manipulator = new XMLManipulator(
				socialProfile.getUserInfo());
		Map<String, Map<String, String>> contactInfo = new HashMap<String, Map<String, String>>();

		try {
			Map<String, String> phoneDetailsMap = new HashMap<String, String>();
			String phoneNum = manipulator.findNode("//phone_details/phone_no")
					.getTextContent().trim();
			String extension = manipulator.findNode("//phone_details/ext")
					.getTextContent().trim();
			phoneDetailsMap.put("phone_no", phoneNum);
			phoneDetailsMap.put("ext", extension);

			Map<String, String> addressDetailsMap = new HashMap<String, String>();
			addressDetailsMap.put("address",
					manipulator.findNode("//address_details/address")
							.getTextContent().trim());
			addressDetailsMap.put("address1",
					manipulator.findNode("//address_details/address1")
							.getTextContent().trim());
			addressDetailsMap.put("city",
					manipulator.findNode("//address_details/city")
							.getTextContent().trim());
			addressDetailsMap.put("country",
					manipulator.findNode("//address_details/country")
							.getTextContent().trim());
			addressDetailsMap.put("postal_code",
					manipulator.findNode("//address_details/postal_code")
							.getTextContent().trim());

			contactInfo.put("phone_details", phoneDetailsMap);
			contactInfo.put("address_details", addressDetailsMap);
		} catch (Exception e) {
			_log.error("Error retrieving socialprofile contact info: "
					+ e.getMessage());
		}

		return contactInfo;
	}

	public static Map<String, Map<String, String>> getSocialProfileWorkHistoryMap(
			SocialProfile socialProfile) throws PortalException,
			SystemException {
		Map<String, Map<String, String>> workHistoryInfo = new HashMap<String, Map<String, String>>();
		XMLManipulator manipulator = new XMLManipulator(
				socialProfile.getUserInfo());
		try {
			NodeList workHistory = manipulator.findNodeList("//work_details");

			for (int i = 0; i < workHistory.getLength(); i++) {
				Node work = (Node) workHistory.item(i);
				Element link = (Element) workHistory.item(i);

				Map<String, String> workDetailsMap = new HashMap<String, String>();
				NodeList workDetailInfo = work.getChildNodes();

				for (int j = 0; j < workDetailInfo.getLength(); j++) {
					Node workDetails = (Node) workDetailInfo.item(j);
					String key = workDetails.getNodeName();
					String value = workDetails.getTextContent().trim();

					if (!value.isEmpty() && !value.equals("#text"))
						workDetailsMap.put(key, value);
				}

				workHistoryInfo.put(link.getAttribute("id"), workDetailsMap);
			}
		} catch (Exception e) {
			_log.error("Error retrieving socialprofile work history: "
					+ e.getMessage());
		}

		return workHistoryInfo;
	}

	public static Map<String, Map<String, String>> getSocialProfilAvailabilityInfoMap(
			SocialProfile socialProfile) throws PortalException,
			SystemException {
		Map<String, Map<String, String>> availabilityInfo = new HashMap<String, Map<String, String>>();
		XMLManipulator manipulator = new XMLManipulator(
				socialProfile.getUserInfo());
		try {
			NodeList availability = manipulator
					.findNodeList("//user_availability");

			for (int i = 0; i < availability.getLength(); i++) {
				Node work = (Node) availability.item(i);
				Element link = (Element) availability.item(i);

				Map<String, String> availabilityDetailsMap = new HashMap<String, String>();
				NodeList availabilityDetailInfo = work.getChildNodes();

				for (int j = 0; j < availabilityDetailInfo.getLength(); j++) {
					Node workDetails = (Node) availabilityDetailInfo.item(j);
					String key = workDetails.getNodeName();
					String value = workDetails.getTextContent().trim();

					if (!value.isEmpty() && !value.equals("#text"))
						availabilityDetailsMap.put(key, value);
				}

				availabilityInfo.put(link.getAttribute("id"),
						availabilityDetailsMap);
			}
		} catch (Exception e) {
			_log.error("Error retrieving socialprofile work history: "
					+ e.getMessage());
		}

		return availabilityInfo;
	}

	public static Map<String, String> getFieldAttributesMap(String fieldName,
			ResourceRequest request) {
		Map<String, String> attributes = new HashMap<String, String>();
		PortletPreferences prefs = request.getPreferences();

		Map<String, String[]> preferences = prefs.getMap();

		for (Map.Entry<String, String[]> entry : preferences.entrySet()) {
			String key = entry.getKey();

			if ("name".equalsIgnoreCase(key)) {
				continue;
			} else if (key.equalsIgnoreCase(fieldName)) {
				String[] prefInfo = entry.getValue();
				String pref = "";

				if (Validator.isNotNull(prefInfo) && prefInfo.length > 0) {
					pref = prefInfo[0];
				}

				if (Validator.isNotNull(pref)) {
					String[] prefsDetails = pref.split(StringPool.COMMA);

					for (int j = 0; j < prefsDetails.length; j++) {
						String[] prefOptions = prefsDetails[j]
								.split(StringPool.COLON);
						String attrKey = prefOptions[0];
						String attrVal = "";

						if (prefOptions.length > 1)
							attrVal = prefOptions[1];

						if (Validator.isNotNull(attrKey)) {
							attributes.put(attrKey, attrVal);
						}
					}// end for prefsDetails
				}// end if
			}// end else
		}

		return attributes;
	}

	public static String getDomainNameFromUrl(String url) {
		final Pattern p = Pattern.compile(".*?([^.]+\\.[^.]+)");
		String _url = url;

		try {
			URI uri = new URI(url);

			// e.g. uri.getHost() will return "www.sambash.com"

			String host = uri.getHost();

			if (host != null) {
				Matcher m = p.matcher(host);

				if (m != null && m.matches()) {
					String domain = m.group(1);
					_url = url.substring(url.indexOf(domain), url.length());
				}
			}
		} catch (URISyntaxException e) {
			_log.error(e);
		}

		return _url;
	}

	

	public static String getSingleInputRadioFields(long optionId,
			String category, String selected, long scopeGroupId,
			String templateName) {
		String fieldName = category + "_input";
		String jsAction = " onchange=\"javascript:saveSingleInput(this.id,'"
				+ templateName + "')\" ";

		StringBuilder sb = new StringBuilder();
		List<AssetCategory> assetCategories = SocialProfileLocalServiceUtil
				.getAssetCategories(scopeGroupId, optionId);
		_log.info("###assetCategories: " + assetCategories.size());

		if (Validator.isNull(assetCategories)) {
			return "No options available";
		}

		int i = 0;

		for (AssetCategory assetCategory : assetCategories) {
			String option = assetCategory.getName();
			sb.append("<span class='dynamic_input_radio'>");
			sb.append("<input type='radio' name='");
			sb.append(fieldName);
			sb.append("' id='" + fieldName + "_" + i + "' value='");
			sb.append(option);
			sb.append("'");
			sb.append(jsAction);

			if (option.equals(selected)) {
				sb.append(" checked='true' ");
			}

			sb.append("section_name='" + category + "'");
			sb.append("/>");
			sb.append(option);
			sb.append("</span>");

			i++;
		}

		return sb.toString();
	}

	public static Map<String, String> getAllAssetVocabulary(long scopeGroupId) {
		Map<String, String> assetVocabularies = new HashMap<String, String>();
		try {
			List<AssetVocabulary> assetVocabulary = AssetVocabularyLocalServiceUtil
					.getGroupVocabularies(scopeGroupId);

			for (AssetVocabulary vocabulary : assetVocabulary) {
				assetVocabularies.put(
						String.valueOf(vocabulary.getVocabularyId()),
						vocabulary.getName());
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return assetVocabularies;
	}

	public static String getRadioFields(long optionId, String category,
			long instance, String selected, String mandatory,
			String validationKey, long scopeGroupId) {

		// String _key = category + ".asset.categories";

		String fieldName = category;

		if (instance > 0) {
			fieldName = category + "_" + instance;
		}

		if (Validator.isNull(optionId)) {
			return "No options available";
		}

		List<AssetCategory> assetCategories = SocialProfileLocalServiceUtil
				.getAssetCategories(scopeGroupId, optionId);

		if (Validator.isNull(assetCategories)) {
			return "No options available";
		}

		StringBuilder sb = new StringBuilder();

		for (AssetCategory assetCategory : assetCategories) {
			String option = assetCategory.getName();
			sb.append("<span class='dynamic_input_radio'>");
			sb.append("<input type='radio' name='");
			sb.append(fieldName);
			sb.append("' id='" + fieldName + "' value='");
			sb.append(option);
			sb.append("'");

			if (option.equals(selected)) {
				sb.append(" checked='true' ");
			}

			if (Validator.isNotNull(mandatory)) {
				sb.append(" mandatory='" + mandatory + "' ");
			}

			if (Validator.isNotNull(validationKey)) {
				sb.append(" validation_key='" + validationKey + "' ");
			}

			sb.append("/>");
			sb.append(option);
			sb.append("</span>");
		}

		return sb.toString();
	}

	public static String getSelectMultipleList(long optionId, String fieldName,
			long position, String selected, String portletName,
			String mandatory, long scopeGroupId) {
		StringBuffer sb = new StringBuffer();
		String category = fieldName;
		List<AssetCategory> assetCategories = SocialProfileLocalServiceUtil
				.getAssetCategories(scopeGroupId, optionId);

		if (Validator.isNull(assetCategories)) {
			return "No options available";
		}

		sb.append("<select MULTIPLE ");

		if (Validator.isNotNull(position)) {
			sb.append("section_name='" + fieldName + "_" + position + "' ");
		} else {
			sb.append("section_name='" + fieldName + "' ");
		}

		sb.append("position='" + position + "' ");
		sb.append("category='" + category + "' ");
		sb.append("style='width:235px;' ");
		sb.append("mandatory='" + mandatory + "' ");

		if (portletName.equals("personal_info")
				|| portletName.equals("basic_info")) {
			// basic and personal info uses same function
			sb.append("id='" + fieldName + "_input' ");
			sb.append("class='single-input tooltip'");
			sb.append("onblur=\"saveSingleInput(this.id,'" + portletName
					+ "');\" >");
		} else if (portletName.equals("network_info")) {
			sb.append("id='" + fieldName + "_Input_" + position + "' ");
			sb.append("class='single-input tooltip'");
			sb.append("onblur='saveNetworkInfo(this.id);' >");
		} else {
			if (position > 0) {
				fieldName = fieldName + "_" + position;
			}

			sb.append("id='" + fieldName + "'");
			sb.append("class='multiple-input tooltip'");
			sb.append(">");
		}

		if (Validator.isNotNull(selected)) {
			String[] optList = selected.split(", ");

			for (int i = 0; i < optList.length; i++) {
				sb.append("<option selected value='" + optList[i] + "'>"
						+ optList[i] + "</option>");
			}
		}

		for (AssetCategory assetCategory : assetCategories) {
			String catName = assetCategory.getName();

			if (Validator.isNull(selected)) {
				sb.append("<option value='" + catName + "'>" + catName
						+ "</option>");
			} else {
				if (selected.indexOf(catName) < 0) { // check if catName already
														// selected to avoid
														// duplicate display of
														// values
					sb.append("<option value='" + catName + "'>" + catName
							+ "</option>");
				}
			}
		}

		sb.append("</select>");
		return sb.toString();
	}

	public static String getSelectOptionList(long optionId, String fieldName,
			long position, String selected, String portletName,
			String mandatory, long scopeGroupId) {
		StringBuffer sb = new StringBuffer();
		String category = fieldName;
		List<AssetCategory> assetCategories = SocialProfileLocalServiceUtil
				.getAssetCategories(scopeGroupId, optionId);

		if (Validator.isNull(assetCategories)) {
			return "No options available";
		}

		sb.append("<select ");

		if (Validator.isNotNull(position)) {
			sb.append("section_name='" + fieldName + "_" + position + "' ");
		} else {
			sb.append("section_name='" + fieldName + "' ");
		}

		sb.append("position='" + position + "' ");
		sb.append("category='" + category + "' ");
		sb.append("style='min-width:100%;font-size:12pt;' ");
		sb.append("mandatory='" + mandatory + "' ");

		if (portletName.equals("personal_info")
				|| portletName.equals("basic_info")) {
			// basic and personal info uses same function
			sb.append("id='" + fieldName + "_input' ");
			sb.append("class='single-input tooltip'");
			sb.append("onblur=\"saveSelectInput(this.id,'" + portletName
					+ "');\" >");
		} else if (portletName.equals("network_info")) {
			sb.append("id='" + fieldName + "_Input_" + position + "' ");
			sb.append("class='single-input tooltip'");
			sb.append("onblur='saveNetworkInfo(this.id);' >");
		} else {
			if (position > 0) {
				fieldName = fieldName + "_" + position;
			}

			sb.append("id='" + fieldName + "'");
			sb.append("class='multiple-input tooltip'");
			sb.append(">");
		}

		sb.append("<option selected value='" + selected + "'>" + selected
				+ "</option>");

		for (AssetCategory assetCategory : assetCategories) {
			String catName = assetCategory.getName();

			if (!catName.equals(selected)) {
				sb.append("<option value='" + catName + "'>" + catName
						+ "</option>");
			}
		}

		sb.append("</select>");
		return sb.toString();
	}

	

	public static long getVocId(String categoryName,String fieldName){
		try {
			SPParameter parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(0, categoryName
					+ ".xml.template");
			String xml = parameter.getDescription();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			InputSource inputSource = new InputSource( new StringReader( xml ) );
			Document doc = dBuilder.parse(inputSource);
			NodeList nList = doc.getElementsByTagName(fieldName);
			Node node = nList.item(0);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				long vocId = GetterUtil.getLong(eElement.getAttribute("optionId"));
				return vocId;
			}
		} catch (Exception e) {
			_log.error("Error while getting vocabularyid");
		}
	
		return 0l;
	}
	
	private static Log _log = LogFactoryUtil.getLog(UserProfileUtil.class);

}