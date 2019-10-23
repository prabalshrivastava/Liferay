package com.sambaash.platform.portlet.contactus.action;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.portlet.contactus.exception.ContactUsCategoryException;
import com.sambaash.platform.portlet.contactus.exception.ContactUsCommentException;
import com.sambaash.platform.portlet.contactus.exception.ContactUsContactNumberException;
import com.sambaash.platform.portlet.contactus.exception.ContactUsCountryException;
import com.sambaash.platform.portlet.contactus.exception.ContactUsNameException;
import com.sambaash.platform.srv.contactus.service.SPContactUsLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class ContactUsAction extends com.liferay.util.bridges.mvc.MVCPortlet {

	private static Log logger = LogFactoryUtil.getLog(ContactUsAction.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String step = renderRequest.getParameter("step");
		renderRequest.setAttribute("step", step);

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(renderRequest));
		ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		// String commmunityName =
		// SambaashUtil.getCommunityName(themeDisplay.getScopeGroupId());
		try {
			// List<SPListType> lstCategories = SPListTypeLocalServiceUtil
			// .getByKey("em.contactus.type",
			// themeDisplay.getScopeGroupId());
			String communityName = SambaashUtil.getCommunityName(themeDisplay
					.getScopeGroupId());

			String volcaName = communityName + ".contactus.category";
			List<AssetCategory> categoryList = SambaashUtil.getCategory(
					themeDisplay.getScopeGroupId(), volcaName);

			String locationName = communityName + ".contactus.careerlocation";
			List<AssetCategory> lstLocation = SambaashUtil.getCategory(
					themeDisplay.getScopeGroupId(), locationName);
			// String locationName = communityName +
			// ".contactus.careerlocation";
			// List<SPListType> lstLocation =
			// SPListTypeLocalServiceUtil.getByKey(locationName,themeDisplay.getScopeGroupId());

			String bundleName = "Language_" + themeDisplay.getLocale();

			renderRequest.setAttribute("lstCategories", categoryList);
			renderRequest.setAttribute("lstLocation", lstLocation);
		} catch (SystemException e) {
			logger.error(e.getMessage());
		}

		super.doView(renderRequest, renderResponse);
	}

	public ResourceBundle getLangResourceBundle(String bundleName) {
		ResourceBundle res = ResourceBundle.getBundle(bundleName);
		return res;
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException {
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(actionRequest));
		ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String communityName = SambaashUtil.getCommunityName(themeDisplay
				.getScopeGroupId());
		try {
			if (communityName.equalsIgnoreCase("mn")) {
				menariniProcessAction(actionRequest, actionResponse);
			} else if (communityName.equalsIgnoreCase("em")) {
				emerioProcessAction(actionRequest, actionResponse);
			}
		} catch (Exception e) {
			logger.error("error process action " + e.getMessage());
		}

	}

	private void menariniProcessAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(actionRequest));
		ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String step = StringPool.BLANK;
		String name = actionRequest.getParameter("sender-name");
		String emailAddress = actionRequest.getParameter("sender-address");
		String category = actionRequest.getParameter("categorys");
		String countryName = actionRequest.getParameter("country-List");
		String comment = actionRequest.getParameter("mail-message");

		String countryValue = countryName;
		countryValue = countryValue.replaceAll(" ", "");
		countryValue = countryValue.replaceAll(",", "");
		countryValue = countryValue.replaceAll("-", "");
		countryValue = countryValue.replaceAll("_", "");
		countryValue = countryValue.replaceAll("[()]", "");

		String categoryValue = category;
		categoryValue = categoryValue.replaceAll(" ", "");
		categoryValue = categoryValue.replaceAll("[()]", "");
		categoryValue = categoryValue.replaceAll("-", "");
		categoryValue = categoryValue.replaceAll("_", "");
		categoryValue = categoryValue.replaceAll(",", "");

		String toAddressType = "email." + countryValue + "." + categoryValue;
		String toAddress = "";
		String description = "";
		int categoryOrder = 0;
		try {
			List<SPListType> addressTypeList = SPListTypeLocalServiceUtil
					.getByKey(toAddressType, themeDisplay.getScopeGroupId());
			for (SPListType selectedAddress : addressTypeList) {
				toAddress = selectedAddress.getItemValue();
			}
			String volcaName = SambaashUtil.getCommunityName(themeDisplay
					.getScopeGroupId()) + ".contactus.category";
			List<AssetCategory> lstCategories = SambaashUtil.getCategory(
					themeDisplay.getScopeGroupId(), volcaName);

			// List<AssetCategory> lstCategories = SPListTypeLocalServiceUtil
			// .getByKey("em.contactus.type",
			// themeDisplay.getScopeGroupId());

		} catch (SystemException e) {
			logger.error("for loop categories" + e.getMessage());
		}
		try {

			String location = "";
			SPContactUsLocalServiceUtil.create(name, emailAddress, category,
					comment, countryName, 0, "", "", "", "", 0, "", "", "");

			String subject = category + " : Comments / Request via Contact Us";
			StringBuilder content = new StringBuilder();

			content.append("Name - ").append(name)
					.append("<br/>Email Address - ").append(emailAddress);

			content.append("Details of enquiry - ").append(comment);

			MailMessage mailMessage = new MailMessage();
			mailMessage.setFromAddress(emailAddress);
			mailMessage.setFromName(name);
			mailMessage.setSubject("Enquiry");
			mailMessage.setToAddress(toAddress);
			mailMessage.setBccAddress("hostmaster@sambaash.com");
			mailMessage.setHtmlBody(content.toString());
			logger.info("mailMessage " + mailMessage.toString());
			SPMailLocalServiceUtil.sendMail(mailMessage);

			/*
			 * MailMessage message = new MailMessage(from, to, subject,
			 * content.toString(), true); MailServiceUtil.sendEmail(message);
			 * step = "two"; actionResponse.setRenderParameter("step", step);
			 */

		} catch (Exception e) {
			logger.error(e.getMessage() + e);
			if (e instanceof CaptchaTextException
					|| e instanceof ContactUsNameException
					|| e instanceof UserEmailAddressException
					|| e instanceof ContactUsCategoryException
					|| e instanceof ContactUsCommentException
					|| e instanceof ContactUsCountryException
					|| e instanceof ContactUsContactNumberException)

			{

				actionRequest.setAttribute("name", name);
				actionRequest.setAttribute("emailAddress", emailAddress);
				actionRequest.setAttribute("category", category);
				actionRequest.setAttribute("comment", comment);
				actionRequest.setAttribute("countryName", countryName);

				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			} else {
				PortalUtil.sendError(e, actionRequest, actionResponse);
			}

		}
		logger.info(name + " " + emailAddress + " " + category + " " + comment
				+ " " + countryName);
	}

	private void emerioProcessAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException {

		String step = StringPool.BLANK;
		String name = actionRequest.getParameter("name");
		String emailAddress = actionRequest.getParameter("emailAddress");
		String category = actionRequest.getParameter("category");
		String comment = actionRequest.getParameter("comment");
		String countryId = actionRequest.getParameter("countryId");
		String contactNumber = actionRequest.getParameter("contactNumber");
		String companyName = actionRequest.getParameter("companyName");
		String companyUrl = actionRequest.getParameter("companyUrl");
		String jobTitle = actionRequest.getParameter("jobTitle");
		String noOfEmployee = actionRequest.getParameter("noOfEmployee");
		String lastName = actionRequest.getParameter("lastName");
		String rate = actionRequest.getParameter("rate");
		String typeOfEnquiry = actionRequest.getParameter("typeOfEnquiry");
		String emLocationOffice = actionRequest
				.getParameter("emLocationOffice");

		String countryName = "";
		String toAddress = SambaashUtil.getParameter(
				"admin.email.contact.address", Long.valueOf(0));
		int categoryOrder = 0;
		try {
			HttpServletRequest httpRequest = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(actionRequest));
			ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			String volcaName = SambaashUtil.getCommunityName(themeDisplay
					.getScopeGroupId()) + ".contactus.category";
			List<AssetCategory> lstCategories = SambaashUtil.getCategory(
					themeDisplay.getScopeGroupId(), volcaName);

			// List<AssetCategory> lstCategories = SPListTypeLocalServiceUtil
			// .getByKey("em.contactus.type",
			// themeDisplay.getScopeGroupId());

			for (AssetCategory assetCategory : lstCategories) {
				categoryOrder++;
				if (category.equals(assetCategory.getName())) {
					if (assetCategory.getDescription() != null
							&& assetCategory.getDescription() != "") {
						String description = assetCategory.getDescription();
						logger.info(description);
						String static1 = "<Description language-id=\"en_US\">";

						String static2 = "</Description>";

						int start = description.lastIndexOf(static1)
								+ static1.length();
						int end = description.indexOf(static2);
						toAddress = description.substring(start, end);

						break;
					}

				}

			}

		} catch (SystemException e) {
			logger.info(e.getMessage());
		}

		try {

			if (countryId != null) {
				if (!countryId.equals("0")) {
					countryName = CountryServiceUtil.getCountry(
							Long.parseLong(countryId)).getName();
				}

			}

			validate(name, lastName, emailAddress, comment, companyName,
					contactNumber, category);
			if (contactNumber.equals("")) {
				contactNumber = "0";
			}

			if (noOfEmployee.equals("") || noOfEmployee == null) {
				noOfEmployee = "0";
			}
			CaptchaUtil.check(actionRequest);

			// ContactUsLocalServiceUtil.create(name, emailAddress, category,
			// comment, Long.parseLong(countryId),
			// Long.parseLong(contactNumber));
			String location = "";
			SPContactUsLocalServiceUtil.create(name, emailAddress, category,
					comment, countryName, Long.parseLong(contactNumber),
					lastName, companyName, jobTitle, companyUrl,
					Long.parseLong(noOfEmployee), rate, typeOfEnquiry,
					emLocationOffice);

			// String toAddress = cate
			logger.info(toAddress);
			String subject = category + " : Comments / Request via Contact Us";
			StringBuilder content = new StringBuilder();
			InternetAddress to = new InternetAddress(toAddress, toAddress);
			content.append("Name - ").append(name + lastName)
					.append("<br/>Email Address - ").append(emailAddress);

			switch (categoryOrder) {
			case 1:
				content.append("Details of enquiry - ").append(comment)
						.append("<br/>Company Name - ").append(companyName)
						.append("<br/>Phone Number - ").append(contactNumber)
						.append("<br/>Country - ").append(countryName)
						.append("<br/>Company Website/URL - ")
						.append(companyUrl).append("<br/>No of Employee - ")
						.append(noOfEmployee);

				break;

			case 2:
				content.append("<br/>Location of Emerio office - ")
						.append(emLocationOffice)
						.append("<br/>Please list skill sets - ")
						.append(comment).append("<br/>Phone Number - ")
						.append(contactNumber)
						.append("<br/>Current country of residence - ")
						.append(countryName);
				break;

			case 3:
				content.append("<br/>Feedback - ").append(comment)
						.append("<br/>Company Name - ").append(companyName)
						.append("<br/>Phone Number - ").append(contactNumber)
						.append("<br/>Rate our website - ").append(rate)
						.append("<br/>").append(typeOfEnquiry)
						.append(" is looked for.").append("<br/>Country - ")
						.append(countryName);
				break;

			case 4:
				content.append("<br/>Feedback - ").append(comment)
						.append("<br/>Company Name - ").append(companyName)
						.append("<br/>Phone Number - ").append(contactNumber)
						.append("<br/>Country - ").append(countryName);
				break;

			default:
				break;
			}

			if (contactNumber != "0") {
				content.append(contactNumber);
			}

			content.append("<br/>Comment - ").append(comment);

			// MailMessage message = new MailMessage(to, to, subject,
			// content.toString(), true);

			MailMessage mailMessage = new MailMessage();
			mailMessage.setFromAddress(emailAddress);
			mailMessage.setFromName(name);
			mailMessage.setSubject(subject);
			mailMessage.setToAddress(toAddress);
			//mailMessage.setBccAddress("admin@sambaash.com");
			mailMessage.setHtmlBody(content.toString());
			logger.info("mailMessage " + mailMessage.toString());
			SPMailLocalServiceUtil.sendMail(mailMessage);

			// MailServiceUtil.sendEmail(message);
			step = "two";
			actionResponse.setRenderParameter("step", step);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			if (e instanceof CaptchaTextException
					|| e instanceof ContactUsNameException
					|| e instanceof UserEmailAddressException
					|| e instanceof ContactUsCategoryException
					|| e instanceof ContactUsCommentException
					|| e instanceof ContactUsCountryException
					|| e instanceof ContactUsContactNumberException)

			{

				actionRequest.setAttribute("name", name);
				actionRequest.setAttribute("lastName", lastName);
				actionRequest.setAttribute("emailAddress", emailAddress);
				actionRequest.setAttribute("category", category);
				actionRequest.setAttribute("comment", comment);
				actionRequest.setAttribute("countryId", countryId);
				actionRequest.setAttribute("contactNumber", contactNumber);
				actionRequest.setAttribute("companyName", companyName);
				actionRequest.setAttribute("companyUrl", companyUrl);
				actionRequest.setAttribute("jobTitle", jobTitle);
				actionRequest.setAttribute("rate", rate);
				actionRequest.setAttribute("typeOfEnquiry", typeOfEnquiry);
				actionRequest.setAttribute("noOfEmployee", noOfEmployee);
				actionRequest
						.setAttribute("emLocationOffice", emLocationOffice);

				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			} else {
				PortalUtil.sendError(e, actionRequest, actionResponse);
			}

		}

	}

	public void validate(String name, String lastName, String emailAddress,
			String comment, String companyName, String contactNumber,
			String categoryId) throws Exception {

		if (Validator.isNull(name) || Validator.isNull(lastName)
				|| Validator.isNull(emailAddress) || Validator.isNull(comment)) {
			throw new ContactUsNameException();
		}

		if (!categoryId.equals("Career Enquiry")) {
			if (Validator.isNull(companyName)) {
				throw new ContactUsNameException();
			}
		}
		if (!Validator.isEmailAddress(emailAddress)) {
			throw new UserEmailAddressException();
		}

		if (Validator.isNull(comment)) {
			throw new ContactUsCommentException();
		}
		/*
		 * if (Validator.isNull(countryId)) { throw new
		 * ContactUsCountryException(); }
		 */
		if (!Validator.isNull(contactNumber)) {

			if (!Validator.isNumber(contactNumber)) {
				throw new ContactUsContactNumberException();
			}

		}

	}
}