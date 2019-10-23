package com.sambaash.platform.portlet.spevent.action;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.PasswordPolicy;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PasswordPolicyLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.PwdGenerator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.model.Paypal;
import com.sambaash.platform.model.RsvpSource;
import com.sambaash.platform.model.RsvpStatus;
import com.sambaash.platform.model.SPMailStatus;
import com.sambaash.platform.model.SPMailType;
import com.sambaash.platform.portlet.spevent.util.CalUtil;
import com.sambaash.platform.portlet.spevent.util.PaymentUtil;
import com.sambaash.platform.portlet.spevent.util.UserProfileUtil;
import com.sambaash.platform.portlet.spevent.util.XMLManipulator;
import com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail;
import com.sambaash.platform.srv.rsvp.model.RsvpDetail;
import com.sambaash.platform.srv.rsvp.model.RsvpDiscount;
import com.sambaash.platform.srv.rsvp.model.RsvpPayment;
import com.sambaash.platform.srv.rsvp.model.RsvpPromoCode;
import com.sambaash.platform.srv.rsvp.model.RsvpTicket;
import com.sambaash.platform.srv.rsvp.service.RsvpCoParticipantDetailLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpDetailLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpDiscountLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpPaymentLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpPromoCodeLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpTicketLocalServiceUtil;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.model.SPAssetType;
import com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalServiceUtil;
import com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class RSVPAction
 */
public class RSVPAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(RSVPAction.class);
	
	public static final String PORTLET_ID = "UserProfile_WAR_UserProfileportlet";

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String dynamicSectionName = preferences.getValue(
					"dynamicSectionName", StringPool.BLANK);
			renderRequest.setAttribute("dynamicSectionName", dynamicSectionName);
			_log.error("dynamicSectionName do edit  " + dynamicSectionName);
			String title = preferences.getValue("title", StringPool.BLANK);
			String description = preferences.getValue("description",
					StringPool.BLANK);
			String eventFlag = preferences.getValue("eventFlag",
					StringPool.BLANK);
			String paymentFlag = preferences.getValue("paymentFlag",
					StringPool.BLANK);
			String registrationFlag = preferences.getValue("registrationFlag",
					StringPool.BLANK);
			String spAssetFlag = preferences.getValue("spAssetFlag",
					StringPool.BLANK);
			String rsvpId = preferences.getValue("rsvpId", StringPool.BLANK);
			String rsvpUrl = preferences.getValue("rsvpUrl", StringPool.BLANK);
			String spMailCampaignId = preferences.getValue("spMailCampaignId",
					StringPool.BLANK);
			String categoryId = preferences.getValue("categoryId",
					StringPool.BLANK);
			String accountID = preferences.getValue("accountID",
					StringPool.BLANK);
			String price = preferences.getValue("price", StringPool.BLANK);
			String tax = preferences.getValue("tax", StringPool.BLANK);
			String multiRegFlag = preferences.getValue("multiRegFlag",
					StringPool.BLANK);
			String defaultStatusFlag = preferences.getValue(
					"defaultStatusFlag", StringPool.BLANK);
			String countryFlag = preferences.getValue("countryFlag",
					StringPool.BLANK);
			String genderFlag = preferences.getValue("genderFlag",
					StringPool.BLANK);
			String numberOfPeopleFlag = preferences.getValue(
					"numberOfPeopleFlag", StringPool.BLANK);
			String orderFields = preferences.getValue("orderFields",
					StringPool.BLANK);
			String grouping = preferences
					.getValue("grouping", StringPool.BLANK);
			String discountFlag = preferences.getValue("discountFlag",
					StringPool.BLANK);
			String promoCodeFlag = preferences.getValue("promoCodeFlag",
					StringPool.BLANK);
			String signInFlag = preferences.getValue("signInFlag",
					StringPool.BLANK);
			String emailFlag = preferences.getValue("emailFlag",
					StringPool.BLANK);
			String mandatoryFlagChild = preferences.getValue(
					"mandatoryFlagChild", StringPool.BLANK);
			String defaultPrice = preferences.getValue("defaultPrice",
					StringPool.BLANK);
			String miniPriceFlag = preferences.getValue("miniPriceFlag",
					StringPool.BLANK);
			String priceListFlag = preferences.getValue("priceListFlag",
					StringPool.BLANK);

			String logoUrl = preferences.getValue("logoUrl", StringPool.BLANK);
			String colorCode = preferences.getValue("colorCode",
					StringPool.BLANK);
			String pdfTicket = preferences.getValue("pdfTicket",
					StringPool.BLANK);
			String ccEmail = preferences.getValue("ccEmail", StringPool.BLANK);

			String identificationTypeFlag = preferences.getValue(
					"identificationTypeFlag", StringPool.BLANK);
			String identificationNumberFlag = preferences.getValue(
					"identificationNumberFlag", StringPool.BLANK);
			String passwordFlag = preferences.getValue("passwordFlag",
					StringPool.BLANK);
			String streetAddress1Flag = preferences.getValue(
					"streetAddress1Flag", StringPool.BLANK);
			String streetAddress2Flag = preferences.getValue(
					"streetAddress2Flag", StringPool.BLANK);
			String postalCodeFlag = preferences.getValue("postalCodeFlag",
					StringPool.BLANK);
			String cityFlag = preferences
					.getValue("cityFlag", StringPool.BLANK);

			// String countryFlag = preferences.getValue("countryFlag",
			// StringPool.BLANK);

			String stateFlag = preferences.getValue("stateFlag",
					StringPool.BLANK);

			// String genderFlag = preferences.getValue("genderFlag",
			// StringPool.BLANK);

			String phoneNumber1Flag = preferences.getValue("phoneNumber1Flag",
					StringPool.BLANK);
			String phoneNumber2Flag = preferences.getValue("phoneNumber2Flag",
					StringPool.BLANK);
			String hearAboutUsFlag = preferences.getValue("hearAboutUsFlag",
					StringPool.BLANK);
			String attendedWebinarFlag = preferences.getValue(
					"attendedWebinarFlag", StringPool.BLANK);
			String termsOfUseFlag = preferences.getValue("termsOfUseFlag",
					StringPool.BLANK);
			String ageRestrictionFlag = preferences.getValue(
					"ageRestrictionFlag", StringPool.BLANK);
			String ageGroupFlag = preferences.getValue("ageGroupFlag",
					StringPool.BLANK);

			String ageGroupVocId = preferences.getValue("ageGroupVocId",
					StringPool.BLANK);
			String identificationTypeVocId = preferences.getValue(
					"identificationTypeVocId", StringPool.BLANK);
			String hearAboutUsVocId = preferences.getValue("hearAboutUsVocId",
					StringPool.BLANK);
			
			String customList1Flag = preferences.getValue("customList1Flag", StringPool.BLANK);
			String customList1Label = preferences.getValue("customList1Label", StringPool.BLANK);
			String customList1VocId = preferences.getValue("customList1VocId", StringPool.BLANK);

			try {
				if (Validator.isNotNull(rsvpId)) {
					Rsvp rsvp = RsvpLocalServiceUtil.getRsvp(Long
							.valueOf(rsvpId));
					title = rsvp.getTitle();
					description = rsvp.getDescription();
					dynamicSectionName = rsvp.getDynamicSectionName();
					SPMailCampaign spMailCampaign = null;
					try {
						spMailCampaign = SPMailCampaignLocalServiceUtil
								.findByrsvpId(rsvp.getRsvpId());

						if (Validator.isNotNull(spMailCampaign)) {
							spMailCampaignId = String.valueOf(spMailCampaign
									.getSpMailCampaignId());
						}
					} catch (Exception e) {
					}
				}
			} catch (Exception e) {
				_log.error(e.getMessage());
			}

			if (price.isEmpty()) {
				price = "0";
			}

			Calendar cal1 = Calendar.getInstance();

			String categoryName = "Currency Codes";
			try {
				List<AssetVocabulary> lstAssetVocabulary = AssetVocabularyLocalServiceUtil
						.getAssetVocabularies(0,
								AssetVocabularyLocalServiceUtil
										.getAssetVocabulariesCount());
				long volId = 0;

				for (AssetVocabulary assetVo : lstAssetVocabulary) {
					if (assetVo.getName().equals(categoryName)) {
						volId = assetVo.getVocabularyId();
					}
				}

				List<AssetCategory> lstAssetCategory = AssetCategoryLocalServiceUtil
						.getVocabularyCategories(volId, -1, -1, null);

				renderRequest
						.setAttribute("lstAssetCategory", lstAssetCategory);
			} catch (Exception e) {
			}

			try {
				List<RsvpTicket> priceList = RsvpTicketLocalServiceUtil
						.findByrsvpId(Long.parseLong(rsvpId));
				renderRequest.setAttribute("priceList", priceList);
			} catch (Exception e) {
			}

			String dynamicrsvp = SambaashUtil.getParameter(
					"profile.page.url.private", 0);
			try {
				if (!StringPool.BLANK.equals(rsvpId)) {
					renderRequest.setAttribute("serviceFlag", "ExistingRSVP");

					if (Boolean.valueOf(discountFlag)) {
						List<RsvpDiscount> lstRsvpDiscount = RsvpDiscountLocalServiceUtil
								.findByrsvpId(Long.valueOf(rsvpId));

						if (Validator.isNotNull(lstRsvpDiscount)) {
							renderRequest.setAttribute("discountDetail",
									lstRsvpDiscount);
						}
					}

					if (Boolean.valueOf(promoCodeFlag)) {
						List<RsvpPromoCode> lstRsvpPromoCode = RsvpPromoCodeLocalServiceUtil
								.findByrsvpId(Long.valueOf(rsvpId));

						if (Validator.isNotNull(lstRsvpPromoCode)) {
							renderRequest.setAttribute("promoCodeDetail",
									lstRsvpPromoCode);
						}
					}

				} else {
					renderRequest.setAttribute("serviceFlag", "NewRSVP");
				}
			} catch (Exception e) {
				_log.error(e.getMessage());
			}

			String spAssetId = null;
			String eventId = null;

			if ("true".equals(spAssetFlag)) {
				spAssetId = preferences.getValue("spAssetId", StringPool.BLANK);
			}

			if ("true".equals(eventFlag)) {
				eventId = preferences.getValue("eventId", StringPool.BLANK);

				if (!eventId.equals("")) {
					CalendarBooking calEvent = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.parseLong(eventId));

					Calendar calEndDate = Calendar.getInstance();
					calEndDate.setTimeInMillis(calEvent.getEndTime());
					calEndDate.set(Calendar.DAY_OF_MONTH,
							calEndDate.get(Calendar.DAY_OF_MONTH) - 1);

					calEndDate.set(Calendar.HOUR, Integer.parseInt(formatHour
							.format(CalUtil.getEndTime(calEvent))) + 12);
					calEndDate.set(Calendar.MINUTE, Integer
							.parseInt(formatMinute.format(CalUtil
									.getEndTime(calEvent))));

					if (calEvent.isRecurring()) {
						if (calEndDate.getTime().after(cal1.getTime())) {
							renderRequest.setAttribute("canEdit", true);
						} else {
							renderRequest.setAttribute("canEdit", false);
						}
					} else {
						if (CalUtil.getEndTime(calEvent).after(cal1.getTime())) {
							renderRequest.setAttribute("canEdit", true);

						} else {
							renderRequest.setAttribute("canEdit", false);
						}
					}
				} else {
					renderRequest.setAttribute("canEdit", true);
				}

			} else {
				renderRequest.setAttribute("canEdit", true);
			}

			renderRequest.setAttribute("title", title);
			renderRequest.setAttribute("description", description);
			renderRequest.setAttribute("eventFlag", eventFlag);
			renderRequest.setAttribute("paymentFlag", paymentFlag);
			renderRequest.setAttribute("registrationFlag", registrationFlag);
			renderRequest.setAttribute("spAssetFlag", spAssetFlag);
			renderRequest.setAttribute("eventId", eventId);
			renderRequest.setAttribute("spAssetId", spAssetId);
			renderRequest.setAttribute("dynamicrsvp", dynamicrsvp);
			renderRequest.setAttribute("spMailCampaignId", spMailCampaignId);
			renderRequest.setAttribute("categoryId", categoryId);
			renderRequest.setAttribute("accountID", accountID);
			renderRequest.setAttribute("price", price);
			renderRequest.setAttribute("tax", tax);
			renderRequest.setAttribute("multiRegFlag", multiRegFlag);
			renderRequest.setAttribute("defaultStatusFlag", defaultStatusFlag);
			renderRequest.setAttribute("countryFlag", countryFlag);
			renderRequest.setAttribute("genderFlag", genderFlag);
			renderRequest
					.setAttribute("numberOfPeopleFlag", numberOfPeopleFlag);
			renderRequest.setAttribute("orderFields", orderFields);
			renderRequest.setAttribute("grouping", grouping);
			renderRequest.setAttribute("discountFlag", discountFlag);
			renderRequest.setAttribute("promoCodeFlag", promoCodeFlag);
			renderRequest.setAttribute("signInFlag", signInFlag);
			renderRequest.setAttribute("emailFlag", emailFlag);
			renderRequest
					.setAttribute("mandatoryFlagChild", mandatoryFlagChild);
			renderRequest.setAttribute("defaultPrice", defaultPrice);
			renderRequest.setAttribute("miniPriceFlag", miniPriceFlag);
			renderRequest.setAttribute("priceListFlag", priceListFlag);

			renderRequest.setAttribute("logoUrl", logoUrl);
			renderRequest.setAttribute("colorCode", colorCode);
			renderRequest.setAttribute("pdfTicket", pdfTicket);
			renderRequest.setAttribute("ccEmail", ccEmail);

			renderRequest.setAttribute("identificationTypeFlag",
					identificationTypeFlag);
			renderRequest.setAttribute("identificationNumberFlag",
					identificationNumberFlag);
			renderRequest.setAttribute("passwordFlag", passwordFlag);
			renderRequest
					.setAttribute("streetAddress1Flag", streetAddress1Flag);
			renderRequest
					.setAttribute("streetAddress2Flag", streetAddress2Flag);
			renderRequest.setAttribute("postalCodeFlag", postalCodeFlag);
			renderRequest.setAttribute("cityFlag", cityFlag);

			// renderRequest.setAttribute("countryFlag", countryFlag);

			renderRequest.setAttribute("stateFlag", stateFlag);

			// renderRequest.setAttribute("genderFlag", genderFlag);

			renderRequest.setAttribute("phoneNumber1Flag", phoneNumber1Flag);
			renderRequest.setAttribute("phoneNumber2Flag", phoneNumber2Flag);
			renderRequest.setAttribute("hearAboutUsFlag", hearAboutUsFlag);
			renderRequest.setAttribute("attendedWebinarFlag",
					attendedWebinarFlag);
			renderRequest.setAttribute("termsOfUseFlag", termsOfUseFlag);
			renderRequest
					.setAttribute("ageRestrictionFlag", ageRestrictionFlag);
			renderRequest.setAttribute("ageGroupFlag", ageGroupFlag);

			renderRequest.setAttribute("ageGroupVocId", ageGroupVocId);
			renderRequest.setAttribute("identificationTypeVocId",
					identificationTypeVocId);
			renderRequest.setAttribute("hearAboutUsVocId", hearAboutUsVocId);
			renderRequest.setAttribute("customList1Flag", customList1Flag);
			renderRequest.setAttribute("customList1Label", customList1Label);
			renderRequest.setAttribute("customList1VocId", customList1VocId);

			renderRequest.setAttribute("vocabularies",
					AssetVocabularyLocalServiceUtil
							.getAssetVocabularies(-1, -1));

			// renderRequest.setAttribute("serviceFlag", serviceFlag);

			if (rsvpId != "") {
				renderRequest.setAttribute("rsvpId", Long.parseLong(rsvpId));
			} else {
				renderRequest.setAttribute("rsvpId", null);
			}

			renderRequest.setAttribute("rsvpUrl", rsvpUrl);
			_log.debug("rsvpId " + rsvpId);

			int count = CalEventLocalServiceUtil.getCalEventsCount();

			/** Till here **/

			List<CalendarBooking> eventsAll = new ArrayList<CalendarBooking>();
			List<CalendarBooking> eventsResult = new ArrayList<CalendarBooking>();
			String type = null;
			eventsAll = CalendarBookingLocalServiceUtil.getCalendarBookings(0, count);

			if (eventsAll != null) {
				for (CalendarBooking calEvent : eventsAll) {
					Calendar calEndDate = Calendar.getInstance();
					calEndDate.setTimeInMillis(calEvent.getEndTime());
					calEndDate.set(Calendar.DAY_OF_MONTH,
							calEndDate.get(Calendar.DAY_OF_MONTH) - 1);

					calEndDate.set(Calendar.HOUR, Integer.parseInt(formatHour
							.format(CalUtil.getEndTime(calEvent))) + 12);
					calEndDate.set(Calendar.MINUTE, Integer
							.parseInt(formatMinute.format(CalUtil
									.getEndTime(calEvent))));

					if (calEvent.isRecurring()) {
						if (calEndDate.getTime().after(cal1.getTime())) {
							eventsResult.add(calEvent);
						}
					} else {
						if (CalUtil.getEndTime(calEvent).after(cal1.getTime())) {
							eventsResult.add(calEvent);
						}
					}
				}
			}

			renderRequest.setAttribute("lstEvents", eventsResult);
			renderRequest.setAttribute("lstEventsAll", eventsAll);
			List<Rsvp> lstRsvp = RsvpLocalServiceUtil.getRsvps(0,
					RsvpLocalServiceUtil.getRsvpsCount());

			List<SPMailCampaign> lstSpMailCampaign = SPMailCampaignLocalServiceUtil
					.getActiveCampaigns(0, SPMailCampaignLocalServiceUtil
							.getSPMailCampaignsCount());

			renderRequest.setAttribute("lstMailCampaign", lstSpMailCampaign);

			renderRequest.setAttribute("lstRsvp", lstRsvp);

			List<SPAssetType> spAssetAll = new ArrayList<SPAssetType>();
			List<SPAssetType> spAssetResult = new ArrayList<SPAssetType>();
			spAssetAll = SPAssetTypeLocalServiceUtil.getSPAssetTypes(0,
					SPAssetTypeLocalServiceUtil.getSPAssetTypesCount());

			for (SPAssetType spAssetType : spAssetAll) {
				if (spAssetType.getStatus()) {
					spAssetResult.add(spAssetType);
				}
			}

			renderRequest.setAttribute("lstSPAssets", spAssetResult);
		} catch (Exception e) {
		}

		super.doEdit(renderRequest, renderResponse);
	}

	private void createUserInfoXML(SocialProfile socialProfile,
			String userInfoXml, String categoryName, String categoryDetails,
			ThemeDisplay themeDisplay) throws Exception, SystemException {

		if (Validator.isNotNull(categoryName)
				&& Validator.isNotNull(categoryDetails)) {
			String xmlFile = "";
			SPParameter parameter = null;
			XMLManipulator manipulator = null;
			manipulator = new XMLManipulator(userInfoXml);
			String _instance = String.valueOf(new Date().getTime());
			String attr = manipulator.findNodeById("other_details"
					+ StringPool.SLASH + categoryName + StringPool.SLASH
					+ categoryDetails, "id", _instance);

			if (Validator.isNull(attr)) { // create new node
				try {
					parameter = SPParameterLocalServiceUtil
							.findBySPParameterGroupIdAndName(
									themeDisplay.getScopeGroupId(),
									categoryName + ".xml.template");
					xmlFile = parameter.getDescription();
				} catch (NoSuchSPParameterException e1) {
					_log.error(e1);
				}

				String nodeId = _instance;
				Node node = manipulator.appendXmlWithId("//other_details/"
						+ categoryName, xmlFile, nodeId);

				if (node == null) {
					manipulator.appendNode(categoryName, "other_details");
					manipulator.appendXmlWithId("//other_details/"
							+ categoryName, xmlFile, nodeId);
				}

				socialProfile.setUserInfo(manipulator.toString(null));
				SocialProfileLocalServiceUtil
						.updateSocialProfile(socialProfile);
			}
		}
	}

	private static final SimpleDateFormat formatMinute = new SimpleDateFormat(
			"mm");

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		_log.error("Testing dynamic update");

		PortletPreferences preferences = renderRequest.getPreferences();
		String dynamicSectionName = preferences.getValue("dynamicSectionName",
				StringPool.BLANK);
		_log.error("dynamicSectionName do view " + dynamicSectionName);
		String title = preferences.getValue("title", StringPool.BLANK);
		String eventId = preferences.getValue("eventId", StringPool.BLANK);
		String spAssetId = preferences.getValue("spAssetId", StringPool.BLANK);
		String rsvpId = preferences.getValue("rsvpId", StringPool.BLANK);
		String paymentFlag = preferences.getValue("paymentFlag",
				StringPool.BLANK);
		String price = preferences.getValue("price", StringPool.BLANK);
		String currency = preferences.getValue("categoryId", StringPool.BLANK);
		String tax = preferences.getValue("tax", StringPool.BLANK);
		String multiRegFlag = preferences.getValue("multiRegFlag",
				StringPool.BLANK);
		String defaultStatusFlag = preferences.getValue("defaultStatusFlag",
				StringPool.BLANK);
		String countryFlag = preferences.getValue("countryFlag",
				StringPool.BLANK);
		String genderFlag = preferences
				.getValue("genderFlag", StringPool.BLANK);
		String numberOfPeopleFlag = preferences.getValue("numberOfPeopleFlag",
				StringPool.BLANK);
		String orderFields = preferences.getValue("orderFields",
				StringPool.BLANK);
		String grouping = preferences.getValue("grouping", StringPool.BLANK);
		String discountFlag = preferences.getValue("discountFlag",
				StringPool.BLANK);
		String promoCodeFlag = preferences.getValue("promoCodeFlag",
				StringPool.BLANK);
		String signInFlag = preferences
				.getValue("signInFlag", StringPool.BLANK);
		String emailFlag = preferences.getValue("emailFlag", StringPool.BLANK);
		String mandatoryFlagChild = preferences.getValue("mandatoryFlagChild",
				StringPool.BLANK);
		String defaultPrice = preferences.getValue("defaultPrice",
				StringPool.BLANK);
		String miniPriceFlag = preferences.getValue("miniPriceFlag",
				StringPool.BLANK);
		String priceListFlag = preferences.getValue("priceListFlag",
				StringPool.BLANK);
		String logoUrl = preferences.getValue("logoUrl", StringPool.BLANK);
		String colorCode = preferences.getValue("colorCode", StringPool.BLANK);

		String identificationTypeFlag = preferences.getValue(
				"identificationTypeFlag", StringPool.BLANK);
		String identificationNumberFlag = preferences.getValue(
				"identificationNumberFlag", StringPool.BLANK);
		String passwordFlag = preferences.getValue("passwordFlag",
				StringPool.BLANK);
		String streetAddress1Flag = preferences.getValue("streetAddress1Flag",
				StringPool.BLANK);
		String streetAddress2Flag = preferences.getValue("streetAddress2Flag",
				StringPool.BLANK);
		String postalCodeFlag = preferences.getValue("postalCodeFlag",
				StringPool.BLANK);
		String cityFlag = preferences.getValue("cityFlag", StringPool.BLANK);

		// String country = preferences.getValue("country", StringPool.BLANK);

		String stateFlag = preferences.getValue("stateFlag", StringPool.BLANK);

		// String gender = preferences.getValue("gender", StringPool.BLANK);

		String phoneNumber1Flag = preferences.getValue("phoneNumber1Flag",
				StringPool.BLANK);
		String phoneNumber2Flag = preferences.getValue("phoneNumber2Flag",
				StringPool.BLANK);
		String hearAboutUsFlag = preferences.getValue("hearAboutUsFlag",
				StringPool.BLANK);
		String attendedWebinarFlag = preferences.getValue(
				"attendedWebinarFlag", StringPool.BLANK);
		String termsOfUseFlag = preferences.getValue("termsOfUseFlag",
				StringPool.BLANK);
		String ageRestrictionFlag = preferences.getValue("ageRestrictionFlag",
				StringPool.BLANK);
		String ageGroupFlag = preferences.getValue("ageGroupFlag",
				StringPool.BLANK);

		String ageGroupVocId = preferences.getValue("ageGroupVocId",
				StringPool.BLANK);
		String identificationTypeVocId = preferences.getValue(
				"identificationTypeVocId", StringPool.BLANK);
		String hearAboutUsVocId = preferences.getValue("hearAboutUsVocId",
				StringPool.BLANK);
		String customList1Flag = preferences.getValue("customList1Flag", "false");
		String customList1Label = preferences.getValue("customList1Label", StringPool.BLANK);
		String customList1VocId = preferences.getValue("customList1VocId", StringPool.BLANK);

		if (Boolean.getBoolean(priceListFlag) == true) {
			defaultPrice = "0.00";
		}

		renderRequest.setAttribute("multiRegFlag",
				Validator.isNotNull(multiRegFlag) ? multiRegFlag : false);
		renderRequest.setAttribute("defaultStatusFlag", Validator
				.isNotNull(defaultStatusFlag) ? defaultStatusFlag : false);
		renderRequest.setAttribute("genderFlag",
				Validator.isNotNull(genderFlag) ? genderFlag : false);
		renderRequest.setAttribute("countryFlag",
				Validator.isNotNull(countryFlag) ? countryFlag : false);
		renderRequest.setAttribute("numberOfPeopleFlag", Validator
				.isNotNull(numberOfPeopleFlag) ? numberOfPeopleFlag : false);
		renderRequest.setAttribute("orderFields", orderFields);
		renderRequest.setAttribute("grouping", grouping);
		renderRequest.setAttribute("discountFlag",
				Validator.isNotNull(discountFlag) ? discountFlag : false);
		renderRequest.setAttribute("promoCodeFlag",
				Validator.isNotNull(promoCodeFlag) ? promoCodeFlag : false);
		renderRequest.setAttribute("signInFlag",
				Validator.isNotNull(signInFlag) ? signInFlag : false);
		renderRequest.setAttribute("emailFlag",
				Validator.isNotNull(emailFlag) ? emailFlag : false);
		renderRequest.setAttribute("mandatoryFlagChild", mandatoryFlagChild);
		renderRequest.setAttribute("defaultPrice", defaultPrice);
		renderRequest.setAttribute("miniPriceFlag",
				Validator.isNotNull(miniPriceFlag) ? miniPriceFlag : false);
		renderRequest.setAttribute("priceListFlag",
				Validator.isNotNull(priceListFlag) ? priceListFlag : false);
		renderRequest.setAttribute("logoUrl", logoUrl);
		renderRequest.setAttribute("colorCode", colorCode);

		renderRequest.setAttribute("identificationTypeFlag", Validator
				.isNotNull(identificationTypeFlag) ? identificationTypeFlag
				: false);
		renderRequest.setAttribute("identificationNumberFlag", Validator
				.isNotNull(identificationNumberFlag) ? identificationNumberFlag
				: false);
		renderRequest.setAttribute("passwordFlag",
				Validator.isNotNull(passwordFlag) ? passwordFlag : false);
		renderRequest.setAttribute("streetAddress1Flag", Validator
				.isNotNull(streetAddress1Flag) ? streetAddress1Flag : false);
		renderRequest.setAttribute("streetAddress2Flag", Validator
				.isNotNull(streetAddress2Flag) ? streetAddress2Flag : false);
		renderRequest.setAttribute("postalCodeFlag",
				Validator.isNotNull(postalCodeFlag) ? postalCodeFlag : false);
		renderRequest.setAttribute("cityFlag",
				Validator.isNotNull(cityFlag) ? cityFlag : false);
		renderRequest.setAttribute("stateFlag",
				Validator.isNotNull(stateFlag) ? stateFlag : false);
		renderRequest.setAttribute("phoneNumber1Flag", Validator
				.isNotNull(phoneNumber1Flag) ? phoneNumber1Flag : false);
		renderRequest.setAttribute("phoneNumber2Flag", Validator
				.isNotNull(phoneNumber2Flag) ? phoneNumber2Flag : false);
		renderRequest.setAttribute("hearAboutUsFlag",
				Validator.isNotNull(hearAboutUsFlag) ? hearAboutUsFlag : false);
		renderRequest.setAttribute("attendedWebinarFlag", Validator
				.isNotNull(attendedWebinarFlag) ? attendedWebinarFlag : false);
		renderRequest.setAttribute("termsOfUseFlag",
				Validator.isNotNull(termsOfUseFlag) ? termsOfUseFlag : false);
		renderRequest.setAttribute("ageRestrictionFlag", Validator
				.isNotNull(ageRestrictionFlag) ? ageRestrictionFlag : false);
		renderRequest.setAttribute("ageGroupFlag",
				Validator.isNotNull(ageGroupFlag) ? ageGroupFlag : false);

		renderRequest.setAttribute("ageGroupVocId", ageGroupVocId);
		renderRequest.setAttribute("identificationTypeVocId",
				identificationTypeVocId);
		renderRequest.setAttribute("hearAboutUsVocId", hearAboutUsVocId);
		renderRequest.setAttribute("customList1Flag", customList1Flag);

		try {
			List<RsvpTicket> priceList = new ArrayList<RsvpTicket>();

			if (Validator.isNumber(rsvpId)) {
				priceList = RsvpTicketLocalServiceUtil.findByrsvpId(Long
						.parseLong(rsvpId));
			}

			renderRequest.setAttribute("priceList", priceList);

			JSONObject priceListJSONObject = JSONFactoryUtil.createJSONObject();

			for (RsvpTicket spRsvpTicket : priceList) {
				JSONObject pListJSONObject = JSONFactoryUtil.createJSONObject();
				pListJSONObject.put("priceValue", spRsvpTicket.getPrice());
				priceListJSONObject.put(
						String.valueOf(spRsvpTicket.getRsvpTicketId()),
						pListJSONObject);
			}

			renderRequest.setAttribute("priceListJSONObject",
					priceListJSONObject);
		} catch (Exception e) {
		}

		try {
			if (Validator.isNotNull(currency)) {
				String currencyName = AssetCategoryLocalServiceUtil
						.getAssetCategory(Long.valueOf(currency)).getName();
				renderRequest.setAttribute("currency", currencyName);
			}
		} catch (Exception e) {
		}

		renderRequest.setAttribute("paymentFlag", Validator.isNotNull(paymentFlag)?paymentFlag:false);
		renderRequest.setAttribute("countryFlag", Validator.isNotNull(countryFlag)?countryFlag:false);
		renderRequest.setAttribute("genderFlag", Validator.isNotNull(genderFlag)?genderFlag:false);
		if (Validator.isNumber(price)) {
			renderRequest.setAttribute("price", (Double.parseDouble(price)));
		}

		renderRequest.setAttribute("tax", tax);

		String dynamicrsvp = SambaashUtil.getParameter(
				"profile.page.url.private", 0);

		CalendarBooking calEvent = null;
		SPAssetEntry spAsset = null;

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute("title", title);

		PortletPreferences portletPreferences = null;

		try {
			renderRequest.setAttribute("isAdmin", SambaashUtil.isAdmin(
					themeDisplay.getScopeGroupId(), themeDisplay.getUserId()));

			renderRequest.setAttribute("isSignIn", themeDisplay.isSignedIn());

			User user = null;

			if (themeDisplay.isSignedIn()) {
				user = themeDisplay.getUser();
				renderRequest.setAttribute("email", user.getEmailAddress());
			}

			try {
				if (Validator.isNotNull(dynamicSectionName)) {
					String profielFriendlyURL = StringPool.SLASH + dynamicrsvp;
					Layout layout = LayoutLocalServiceUtil
							.getFriendlyURLLayout(
									themeDisplay.getScopeGroupId(), false,
									profielFriendlyURL);
					long plid = layout.getPlid();
					ClassLoader cl = PortalClassLoaderUtil.getClassLoader();

					DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
							.forClass(
									com.liferay.portal.model.PortletPreferences.class,
									cl);
					dynamicQuery.add(PropertyFactoryUtil.forName("plid").eq(
							new Long(plid)));
					dynamicQuery.add(PropertyFactoryUtil.forName("portletId")
							.like(PORTLET_ID + "%"));

					@SuppressWarnings("unchecked")
					List<com.liferay.portal.model.PortletPreferences> portletPreferencesList = PortletPreferencesLocalServiceUtil
							.dynamicQuery(dynamicQuery);

					for (com.liferay.portal.model.PortletPreferences pref : portletPreferencesList) {
						String portletId = pref.getPortletId();
						PortletPreferences prefs = PortletPreferencesFactoryUtil
								.getPortletPreferencesFactory()
								.getLayoutPortletSetup(layout, portletId);
						String xslName = prefs.getValue("name", "");
						_log.error("xslName " + xslName);
						if (xslName.equals(dynamicSectionName)) {
							portletPreferences = prefs;
						}
					}

					if (portletPreferences != null) {
						HashMap<String, HashMap<String, String>> displayArray = getDisplayFields(
								themeDisplay, dynamicrsvp, dynamicSectionName);

						String[] lstOrder = null;

						if (Validator.isNotNull(orderFields)) {
							lstOrder = orderFields.split(",");
						} else {
							lstOrder = SPParameterLocalServiceUtil
									.findBySPParameterGroupIdAndName(
											themeDisplay.getScopeGroupId(),
											dynamicSectionName + ".fields")
									.getValue().split(",");
						}

						int start = -1;
						int end = -1;

						if (Validator.isNotNull(grouping)) {
							String[] lstGrouping = grouping.split(",");

							for (int k = 0; k < lstOrder.length; k++) {
								if (lstOrder[k].equals(lstGrouping[0])) {
									start = k;
								}

								if (lstOrder[k]
										.equals(lstGrouping[lstGrouping.length - 1])) {
									end = k;
								}
							}
						}

						try {
							StringBuffer sb = new StringBuffer();
							int count = 0;
							String validateField = "";
							String mandatoryField = "";

							for (int j = 0; j < lstOrder.length; j++) {
								HashMap<String, String> fileds = displayArray
										.get(lstOrder[j]);
								_log.debug(" fileds " + fileds);

								if (fileds.get("edittable").equals("true")
										&& fileds.get("display").equals("true")) {
									if (fileds.get("label") != null) {
										if (j == start) {
											sb.append("<div style='padding: 10px; width: 95%; margin-top: 10px; margin-bottom: 10px; background:#f8f8f8;border:1px solid #C5C5C5;'>");
										}

										if (fileds.get("fieldType")
												.toLowerCase().equals("radio")) {
											String vocabularyId = fileds
													.get("options");
											int noOfCategories = AssetCategoryLocalServiceUtil
													.getVocabularyCategoriesCount(Long
															.parseLong(vocabularyId));
											List<AssetCategory> lstAssetCategories = AssetCategoryLocalServiceUtil
													.getVocabularyCategories(
															Long.parseLong(vocabularyId),
															0, noOfCategories,
															null);

											sb.append("<div class='rsvp-label'><div style='width:41%;display:inline-block;vertical-align: top;'> <span class='pets-reg-label'>"
													+ fileds.get("label")
													+ "</span>");

											if (fileds.get("mandatory")
													.toLowerCase()
													.equals("true")) {
												if (mandatoryField.length() > 0) {
													mandatoryField += ",";
												}

												mandatoryField += "item"
														+ count;

												sb.append("<span style='color:red;'>*</span>");
											}

											sb.append("</div><div class='radio-button' style='width:56%;display:inline-block' id='radio"
													+ count + "'>");

											for (AssetCategory category : lstAssetCategories) {
												sb.append("<input type='"
														+ fileds.get(
																"fieldType")
																.toLowerCase()
														+ "' name='item"
														+ count
														+ "' style='margin-right:10px;' value='"
														+ category.getName()
														+ "' required='required' onclick='javascript:getRadioButtonValue("
														+ count + ")'/>"
														+ category.getName()
														+ "<br/>");
											}

											sb.append("</div><input type='hidden' id='item"
													+ count
													+ "' value=''></div>");

										} else if (fileds.get("fieldType")
												.toLowerCase()
												.equals("dropdown")) {
											String vocabularyId = fileds
													.get("options");
											int noOfCategories = AssetCategoryLocalServiceUtil
													.getVocabularyCategoriesCount(Long
															.parseLong(vocabularyId));
											List<AssetCategory> lstAssetCategories = AssetCategoryLocalServiceUtil
													.getVocabularyCategories(
															Long.parseLong(vocabularyId),
															0, noOfCategories,
															null);
											sb.append("<div class='rsvp-label'><div style='width:41%;display:inline-block;vertical-align: top;'> <span class='pets-reg-label'>"
													+ fileds.get("label")
													+ "</span>");

											if (fileds.get("mandatory")
													.toLowerCase()
													.equals("true")) {
												if (mandatoryField.length() > 0) {
													mandatoryField += ",";
												}

												mandatoryField += "item"
														+ count;
												sb.append("<span style='color:red;'>*</span>");
											}

											sb.append("</div><div style='width:59%;display:inline-block'><select id='item"
													+ count
													+ "' name='item"
													+ count + "' >");

											for (AssetCategory category : lstAssetCategories) {
												sb.append("<option value='"
														+ category.getName()
														+ "'>"
														+ category.getName()
														+ "</>");
											}

											sb.append("</select></div></div>");

										} else if (fileds.get("fieldType")
												.toLowerCase()
												.equals("calendar")) {
											Calendar cal = Calendar
													.getInstance();

											if (lstOrder[j]
													.contains("monthyearcal")) {
												sb.append("<div class='rsvp-label'><div style='width:41%;display:inline-block;vertical-align: top;'> <span class='pets-reg-label'>"
														+ fileds.get("label")
														+ "</span></div>");
												sb.append("<div style='width:59%;display:inline-block'>");
												sb.append("<select id='itemMonth"
														+ count
														+ "' name='itemMonth"
														+ count + "' >");

												int month = cal
														.get(Calendar.MONTH) + 1;

												for (int i = 1; i < 13; i++) {
													if (month == i) {
														sb.append("<option value='"
																+ i
																+ "' selected='selected'>"
																+ i + "</>");
													} else {
														sb.append("<option value='"
																+ i
																+ "'>"
																+ i
																+ "</>");
													}
												}

												sb.append("</select> / ");

												sb.append("<select id='itemYear"
														+ count
														+ "' name='itemYear"
														+ count + "' >");

												int startYear = cal
														.get(Calendar.YEAR) - 20;
												int endYear = cal
														.get(Calendar.YEAR) + 20;

												for (int i = startYear; i < endYear; i++) {
													if (i == cal
															.get(Calendar.YEAR)) {
														sb.append("<option value='"
																+ i
																+ "' selected='selected'>"
																+ i + "</>");
													} else {
														sb.append("<option value='"
																+ i
																+ "'>"
																+ i
																+ "</>");
													}
												}

												sb.append("</select>");
												sb.append("</div></div>");
											}
										} else {

											sb.append("<div class='rsvp-label'><div style='width:41%;display:inline-block;vertical-align: top;'> <span class='pets-reg-label'>"
													+ fileds.get("label")
													+ "</span>");

											if (fileds.get("mandatory")
													.toLowerCase()
													.equals("true")) {
												if (mandatoryField.length() > 0) {
													mandatoryField += ",";
												}

												mandatoryField += "item"
														+ count;
												sb.append("<span style='color:red;'>*</span>");
											}

											sb.append("</div>");

											if (fileds.get("fieldType")
													.toLowerCase()
													.toLowerCase()
													.equals("textfield")) {
												if (fileds.get("mandatory")
														.toLowerCase()
														.equals("true")) {
													if (!fileds.get(
															"validation")
															.equals("0")) {
														if (validateField
																.length() > 0) {
															validateField += ",";
														}

														validateField += "item"
																+ count
																+ ":"
																+ fileds.get("validation");
													}

													if (lstOrder[j]
															.startsWith("identification_number_")) {
														sb.append("<div style='width:59%;display:inline-block'><input type='text' name='item"
																+ count
																+ "' id='item"
																+ count
																+ "' class='rsvp-textbox' required='required' maxlength='9'/></div></div>");
													} else {
														sb.append("<div style='width:59%;display:inline-block'><input type='text' name='item"
																+ count
																+ "' id='item"
																+ count
																+ "' class='rsvp-textbox' required='required'/></div></div>");
													}
												} else {
													if (!fileds.get(
															"validation")
															.equals("0")) {
														if (validateField
																.length() > 0) {
															validateField += ",";
														}

														validateField += "item"
																+ count
																+ ":"
																+ fileds.get("validation");
													}

													sb.append("<div style='width:59%;display:inline-block'><input type='text' name='item"
															+ count
															+ "' id='item"
															+ count
															+ "' class='rsvp-textbox' /></div></div>");
												}

											} else {
												sb.append("<div style='width:59%;display:inline-block'><input type='"
														+ fileds.get("fieldType")
														+ "' name='item"
														+ count
														+ "' id='item"
														+ count
														+ "' class='rsvp-textbox'/></div></div>");
											}
										}

										if (j == end) {
											sb.append("</div>");
										}

										count++;
									}
								}
							}

							renderRequest.setAttribute("userprofile",
									sb.toString());
							renderRequest.setAttribute("validateField",
									validateField);
							renderRequest.setAttribute("mandatoryField",
									mandatoryField);
						} catch (Exception e) {
						}
					}
				}

				if (Validator.isNotNull(httpRequest
						.getParameter("transactionId"))) {
					try {
						User usrByRequest = UserLocalServiceUtil.getUser(Long
								.parseLong(httpRequest
										.getParameter("transactionId")));
						renderRequest.setAttribute("email",
								usrByRequest.getEmailAddress());
						renderRequest.setAttribute("firstName",
								usrByRequest.getFirstName());
						renderRequest.setAttribute("lastName",
								usrByRequest.getLastName());

						if (Validator.isNotNull(httpRequest.getParameter("st"))) {
							String rsvpStatus = httpRequest.getParameter("st");

							if (rsvpStatus.equals("Y")) {
								renderRequest.setAttribute("rsvpStatus", 1);
							} else if (rsvpStatus.equals("M")) {
								renderRequest.setAttribute("rsvpStatus", 3);
							} else {
								renderRequest.setAttribute("rsvpStatus", 2);
								renderRequest.setAttribute("notAttend", "true");
								try {
									if (RsvpDetailLocalServiceUtil
											.findByemailAddressAndRsvpId(
													Long.parseLong(rsvpId),
													usrByRequest
															.getEmailAddress())
											.size() > 0) {
										RsvpDetail rsvpDetailByEmail = (RsvpDetailLocalServiceUtil
												.findByemailAddressAndRsvpId(
														Long.parseLong(rsvpId),
														usrByRequest
																.getEmailAddress()))
												.get(0);
										rsvpDetailByEmail.setRsvpStatus(2);
										rsvpDetailByEmail
												.setRsvpStatusBy(usrByRequest
														.getUserId());
										RsvpDetailLocalServiceUtil
												.updateRsvpDetail(rsvpDetailByEmail);
									}
								} catch (Exception e) {
									_log.error("No rsvpDetail with email address = "
											+ usrByRequest.getEmailAddress());
								}
							}
						}

					} catch (NoSuchUserException e) {
						_log.error("No user exists with userId"
								+ httpRequest.getParameter("transactionId"));
					}
				}
			} catch (Exception mainError) {
			}

			if (Boolean.valueOf(discountFlag)) {
			}

			if (Validator.isNotNull(eventId)) {
				calEvent = CalendarBookingLocalServiceUtil.getCalendarBooking(Long
						.parseLong(eventId));

				Calendar calEndDate = Calendar.getInstance();
				Calendar cal1 = Calendar.getInstance();

				calEndDate.setTimeInMillis(calEvent.getEndTime());
				calEndDate.set(Calendar.DAY_OF_MONTH,
						calEndDate.get(Calendar.DAY_OF_MONTH) - 1);

				calEndDate.set(Calendar.HOUR, Integer.parseInt(formatHour
						.format(CalUtil.getEndTime(calEvent))) + 12);
				calEndDate.set(Calendar.MINUTE, Integer.parseInt(formatMinute
						.format(CalUtil.getEndTime(calEvent))));

				if (calEvent.isRecurring()) {
					if (calEndDate.getTime().after(cal1.getTime())) {
						renderRequest.setAttribute("canEdit", true);
					} else {
						renderRequest.setAttribute("canEdit", false);
					}
				} else {
					if (CalUtil.getEndTime(calEvent).after(cal1.getTime())) {
						renderRequest.setAttribute("canEdit", true);

					} else {
						renderRequest.setAttribute("canEdit", false);
					}
				}

				renderRequest.setAttribute("event", calEvent);
			} else {
				renderRequest.setAttribute("canEdit", true);
			}

			if (spAssetId != null) {
				if (!spAssetId.equals("")) {
					spAsset = SPAssetEntryLocalServiceUtil.getSPAssetEntry(Long
							.parseLong(spAssetId));
					renderRequest.setAttribute("spAssetId", spAsset);
				}
			}

			renderRequest
					.setAttribute("dynamicSectionName", dynamicSectionName);

			long countryId = getCountry(themeDisplay);
			renderRequest.setAttribute("countryId", countryId);

			List<AssetCategory> hearAboutUsList = new ArrayList<AssetCategory>();
			List<AssetCategory> identificationTypeList = new ArrayList<AssetCategory>();
			List<AssetCategory> ageGroupList = new ArrayList<AssetCategory>();
			List<AssetCategory> customList1 = new ArrayList<AssetCategory>();
			
			if (Validator.isNumber(hearAboutUsVocId)) {
				hearAboutUsList = AssetCategoryLocalServiceUtil
						.getVocabularyCategories(
								Long.parseLong(hearAboutUsVocId), -1, -1, null);
			}

			if (Validator.isNumber(identificationTypeVocId)) {
				identificationTypeList = AssetCategoryLocalServiceUtil
						.getVocabularyCategories(
								Long.parseLong(identificationTypeVocId), -1,
								-1, null);
			}

			if (Validator.isNumber(ageGroupVocId)) {
				ageGroupList = AssetCategoryLocalServiceUtil
						.getVocabularyCategories(Long.parseLong(ageGroupVocId),
								-1, -1, null);
			}
			
			if (Validator.isNumber(customList1VocId)) {
				customList1 = AssetCategoryLocalServiceUtil.getVocabularyCategories(
						Long.parseLong(customList1VocId), -1, -1, null);
			}

			renderRequest.setAttribute("identificationTypeList", identificationTypeList);
			renderRequest.setAttribute("hearAboutUsList", hearAboutUsList);
			renderRequest.setAttribute("ageGroupList", ageGroupList);
			renderRequest.setAttribute("customList1", customList1);

			List<Country> countries = CountryServiceUtil.getCountries();

			renderRequest.setAttribute("countries", countries);

			if (themeDisplay.getUser().getContact().getMale()) {
				renderRequest.setAttribute("gender", 1);
			} else {
				renderRequest.setAttribute("gender", 0);
			}

			String titleindi = "rsvp-message";
			String subStringIndi = "";
			try {
				JournalArticle jonIndiL = JournalArticleLocalServiceUtil
						.getArticleByUrlTitle(themeDisplay.getScopeGroupId(),
								titleindi);
				String static1 = "<static-content language-id=\"en_US\">";
				String static2 = "</static-content>";
				int start = jonIndiL.getContent().indexOf(static1);
				int end = jonIndiL.getContent().lastIndexOf(static2);
				subStringIndi = jonIndiL.getContent().substring(start, end);

				subStringIndi = subStringIndi.replace("&lt;", "<")
						.replace("&gt;", ">").replace("&nbsp;", " ")
						.replace("&amp;", " ").replace("nbsp;", " ");
			} catch (Exception e) {
			}

			renderRequest.setAttribute("subStringIndi", subStringIndi);

		} catch (PortalException e) {

		} catch (SystemException e) {
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String action = actionRequest.getParameter("action");
		String step = StringPool.BLANK;
		PortletPreferences preferences = actionRequest.getPreferences();

		if (Constants.EDIT.equalsIgnoreCase(action)) {
			String serviceFlag = actionRequest.getParameter("serviceFlag");
			String eventFlag = actionRequest.getParameter("eventFlag");
			String paymentFlag = actionRequest.getParameter("paymentFlag");
			String registrationFlag = actionRequest
					.getParameter("registrationFlag");
			String spAssetFlag = actionRequest.getParameter("spAssetFlag");
			String dynamicSectionName = actionRequest
					.getParameter("dynamicSectionName");
			_log.error("dynamicSectionName process action " + dynamicSectionName);
			String title = actionRequest.getParameter("title");
			String spMailCampaignId = actionRequest
					.getParameter("spMailCampaignId");
			String description = actionRequest.getParameter("description");
			String rsvpUrl = actionRequest.getParameter("rsvpUrl");
			String rsvpId = actionRequest.getParameter("rsvpId");
			String categoryId = actionRequest.getParameter("categoryId");
			String accountID = actionRequest.getParameter("accountID");
			String price = actionRequest.getParameter("priceField");
			String tax = actionRequest.getParameter("tax");
			String multiRegFlag = actionRequest.getParameter("multiRegFlag");
			String defaultStatusFlag = actionRequest
					.getParameter("defaultStatusFlag");
			String genderFlag = actionRequest.getParameter("genderFlag");
			String countryFlag = actionRequest.getParameter("countryFlag");
			String numberOfPeopleFlag = actionRequest
					.getParameter("numberOfPeopleFlag");
			String orderFields = actionRequest.getParameter("orderFields");
			String grouping = actionRequest.getParameter("grouping");
			String discountFlag = actionRequest.getParameter("discountFlag");
			String promoCodeFlag = actionRequest.getParameter("promoCodeFlag");
			String signInFlag = actionRequest.getParameter("signInFlag");
			String emailFlag = actionRequest.getParameter("emailFlag");
			String mandatoryFlagChild = actionRequest
					.getParameter("mandatoryFlagChild");
			String defaultPrice = actionRequest.getParameter("defaultPrice");
			String miniPriceFlag = actionRequest.getParameter("miniPriceFlag");
			String priceListFlag = actionRequest.getParameter("priceListFlag");

			String logoUrl = actionRequest.getParameter("logoUrl");
			String colorCode = actionRequest.getParameter("colorCode");
			String pdfTicket = actionRequest.getParameter("pdfTicket");
			String ccEmail = actionRequest.getParameter("ccEmail");

			String identificationTypeFlag = actionRequest
					.getParameter("identificationTypeFlag");
			String identificationNumberFlag = actionRequest
					.getParameter("identificationNumberFlag");
			String passwordFlag = actionRequest.getParameter("passwordFlag");
			String streetAddress1Flag = actionRequest
					.getParameter("streetAddress1Flag");
			String streetAddress2Flag = actionRequest
					.getParameter("streetAddress2Flag");
			String postalCodeFlag = actionRequest
					.getParameter("postalCodeFlag");
			String cityFlag = actionRequest.getParameter("cityFlag");

			// String countryFlag = actionRequest.getParameter("countryFlag");

			String stateFlag = actionRequest.getParameter("stateFlag");

			// String genderFlag = actionRequest.getParameter("genderFlag");

			String phoneNumber1Flag = actionRequest
					.getParameter("phoneNumber1Flag");
			String phoneNumber2Flag = actionRequest
					.getParameter("phoneNumber2Flag");
			String hearAboutUsFlag = actionRequest
					.getParameter("hearAboutUsFlag");
			String attendedWebinarFlag = actionRequest
					.getParameter("attendedWebinarFlag");
			String termsOfUseFlag = actionRequest
					.getParameter("termsOfUseFlag");
			String ageRestrictionFlag = actionRequest
					.getParameter("ageRestrictionFlag");
			String ageGroupFlag = actionRequest.getParameter("ageGroupFlag");

			String ageGroupVocId = actionRequest.getParameter("ageGroupVocId");
			String identificationTypeVocId = actionRequest
					.getParameter("identificationTypeVocId");
			String hearAboutUsVocId = actionRequest
					.getParameter("hearAboutUsVocId");
			
			String customList1Flag = actionRequest.getParameter("customList1Flag");
			String customList1Label = actionRequest.getParameter("customList1Label");
			String customList1VocId = actionRequest.getParameter("customList1VocId");

			if (Boolean.parseBoolean(priceListFlag) == true) {
				price = "0";
			}

			if (Boolean.valueOf(discountFlag)) {
				String totalDiscount = actionRequest
						.getParameter("totalDiscount");

				if (Validator.isNotNull(totalDiscount)) {
					int discountRow = Integer.valueOf(totalDiscount);
					Calendar today = Calendar.getInstance();
					Calendar endDay = Calendar.getInstance();
					_log.debug("discountRow " + discountRow);

					for (int i = 1; i <= discountRow; i++) {
						String noOfTickets = actionRequest
								.getParameter("ticket" + i);
						String startDate = actionRequest.getParameter("fDate"
								+ i);
						String tDate = actionRequest.getParameter("tDate" + i);
						String percentage = actionRequest
								.getParameter("discount" + i);
						String priceListId = actionRequest
								.getParameter("priceListId" + i);

						try {
							long spRsvpDiscountId = CounterLocalServiceUtil
									.increment("RsvpDiscount.class");
							RsvpDiscount rsvpDiscount = RsvpDiscountLocalServiceUtil
									.createRsvpDiscount(spRsvpDiscountId);
							rsvpDiscount.setRsvpId(Long.valueOf(rsvpId));
							rsvpDiscount.setNoOfTickets(Integer
									.valueOf(noOfTickets));

							String[] fromDate = startDate.split("/");

							today.set(Calendar.DATE,
									Integer.valueOf(fromDate[0]));
							today.set(Calendar.MONTH,
									Integer.valueOf(fromDate[1]) - 1);
							today.set(Calendar.YEAR,
									Integer.valueOf(fromDate[2]));
							today.set(Calendar.MINUTE, 0);
							today.set(Calendar.HOUR, 0);
							today.set(Calendar.SECOND, 0);
							today.set(Calendar.AM_PM, 0);

							rsvpDiscount.setFromDate(today.getTime());

							String[] toDate = tDate.split("/");

							endDay.set(Calendar.DATE,
									Integer.valueOf(toDate[0]));
							endDay.set(Calendar.MONTH,
									Integer.valueOf(toDate[1]) - 1);
							endDay.set(Calendar.YEAR,
									Integer.valueOf(toDate[2]));
							endDay.set(Calendar.MINUTE, 59);
							endDay.set(Calendar.HOUR, 23);
							today.set(Calendar.SECOND, 50);
							endDay.set(Calendar.AM_PM, 0);

							rsvpDiscount.setToDate(endDay.getTime());
							rsvpDiscount.setGroupId(themeDisplay
									.getScopeGroupId());
							rsvpDiscount.setDiscount(Integer
									.valueOf(percentage));
							rsvpDiscount.setUserId(themeDisplay.getUserId());
							rsvpDiscount.setCreateDate(Calendar.getInstance()
									.getTime());

							rsvpDiscount.setRsvpTicketId(Long
									.parseLong(priceListId));
							RsvpDiscountLocalServiceUtil
									.updateRsvpDiscount(rsvpDiscount);

						} catch (SystemException e) {
							_log.error(e.getMessage());
						}
					}
				}
			}

			if (Boolean.valueOf(promoCodeFlag)) {
				String totalPromoCode = actionRequest
						.getParameter("totalPromoCode");

				if (Validator.isNotNull(totalPromoCode)) {
					int promoCodeRow = Integer.valueOf(totalPromoCode);
					Calendar today = Calendar.getInstance();
					Calendar endDay = Calendar.getInstance();
					_log.debug("promoCodeRow " + promoCodeRow);

					for (int i = 1; i <= promoCodeRow; i++) {
						String noOfTickets = actionRequest
								.getParameter("ticketPC" + i);
						String promoCode = actionRequest
								.getParameter("promoCodePC" + i);
						String startDate = actionRequest.getParameter("fDatePC"
								+ i);
						String tDate = actionRequest
								.getParameter("tDatePC" + i);
						String percentage = actionRequest
								.getParameter("discountPC" + i);
						String priceListId = actionRequest
								.getParameter("priceListIdPC" + i);

						try {
							long spRsvpPromoCodeId = CounterLocalServiceUtil
									.increment(RsvpPromoCode.class.getName());
							RsvpPromoCode rsvpPromoCode = RsvpPromoCodeLocalServiceUtil
									.createRsvpPromoCode(spRsvpPromoCodeId);
							rsvpPromoCode.setRsvpId(Long.valueOf(rsvpId));
							rsvpPromoCode.setNoOfTickets(Integer
									.valueOf(noOfTickets));
							rsvpPromoCode.setPromoCode(promoCode);

							String[] fromDate = startDate.split("/");

							today.set(Calendar.DATE,
									Integer.valueOf(fromDate[0]));
							today.set(Calendar.MONTH,
									Integer.valueOf(fromDate[1]) - 1);
							today.set(Calendar.YEAR,
									Integer.valueOf(fromDate[2]));
							today.set(Calendar.MINUTE, 0);
							today.set(Calendar.HOUR, 0);
							today.set(Calendar.SECOND, 0);
							today.set(Calendar.AM_PM, 0);

							rsvpPromoCode.setFromDate(today.getTime());

							String[] toDate = tDate.split("/");

							endDay.set(Calendar.DATE,
									Integer.valueOf(toDate[0]));
							endDay.set(Calendar.MONTH,
									Integer.valueOf(toDate[1]) - 1);
							endDay.set(Calendar.YEAR,
									Integer.valueOf(toDate[2]));
							endDay.set(Calendar.MINUTE, 59);
							endDay.set(Calendar.HOUR, 23);
							today.set(Calendar.SECOND, 50);
							endDay.set(Calendar.AM_PM, 0);

							rsvpPromoCode.setToDate(endDay.getTime());
							rsvpPromoCode.setGroupId(themeDisplay
									.getScopeGroupId());
							rsvpPromoCode.setDiscount(Integer
									.valueOf(percentage));
							rsvpPromoCode.setUserId(themeDisplay.getUserId());
							rsvpPromoCode.setCreateDate(Calendar.getInstance()
									.getTime());

							rsvpPromoCode.setRsvpTicketId(Long
									.parseLong(priceListId));
							RsvpPromoCodeLocalServiceUtil
									.updateRsvpPromoCode(rsvpPromoCode);

						} catch (SystemException e) {
							_log.error(e.getMessage());
						}
					}
				}
			}

			String dynamicrsvp = SambaashUtil.getParameter(
					"profile.page.url.private", 0);

			Rsvp rsvp = null;

			String spAssetId = null;
			String eventId = null;

			Calendar cal = Calendar.getInstance();

			if (!("ExistingRSVP".equals(serviceFlag))
					&& Validator.isNotNull(title)
					&& Validator.isNotNull(description)) {
				try {
					long rsvpIdNew = CounterLocalServiceUtil
							.increment("Rsvp.class");
					rsvp = RsvpLocalServiceUtil.createRsvp(rsvpIdNew);
					rsvp.setUserId(themeDisplay.getUserId());
					rsvp.setTitle(title);
					rsvp.setDescription(description);
					rsvp.setCreateDate(cal.getTime());
					rsvp.setDynamicSectionName(dynamicSectionName);

					if ("true".equals(spAssetFlag)) {
						spAssetId = actionRequest.getParameter("spAssetId");
						rsvp.setSpAssetTypeId(Long.parseLong(spAssetId));
					}

					if ("true".equals(eventFlag)) {
						String expireEvent = String.valueOf(actionRequest
								.getParameter("canEdit"));

						if (Boolean.parseBoolean(expireEvent)) {
							eventId = actionRequest.getParameter("eventId");
						} else {
							eventId = actionRequest.getParameter("alleventId");
						}

						rsvp.setEventId(Long.parseLong(eventId));
					}

					rsvp.setStatus(true);
					rsvp.setUserId(themeDisplay.getUserId());
					rsvp.setModifiedDate(null);
					rsvp.setRsvpUrl(rsvpUrl);
					rsvp.setProcessing(0);
					rsvp.setTicketFlag(Boolean.valueOf(pdfTicket));
					rsvp.setCcEmail(Boolean.valueOf(ccEmail));

					try {
						if (Boolean.valueOf(paymentFlag)) {
							rsvp.setAccountId(accountID);
							rsvp.setPrice(price);
							String currencyName = AssetCategoryLocalServiceUtil
									.getAssetCategory(Long.valueOf(categoryId))
									.getName();
							rsvp.setCurrency(currencyName);
							rsvp.setTax(tax);
							rsvp.setPaymentFlag(true);
						}

						if (Boolean.valueOf(registrationFlag)) {
							rsvp.setRegisterFlag(true);
						}
					} catch (Exception e) {
					}

					RsvpLocalServiceUtil.addRsvp(rsvp);
					actionRequest.setAttribute("rsvpId", rsvpIdNew);
					preferences.setValue("rsvpId",
							String.valueOf(rsvp.getRsvpId()));

					SPMailCampaign spMailCampaign = SPMailCampaignLocalServiceUtil
							.getSPMailCampaign(Long.valueOf(spMailCampaignId));
					spMailCampaign.setRsvpId(Long.valueOf(rsvpIdNew));
					SPMailCampaignLocalServiceUtil
							.updateSPMailCampaign(spMailCampaign);

				} catch (Exception e) {
				}

			} else {
				try {
					Rsvp updateRsvp = RsvpLocalServiceUtil.getRsvp(Long
							.parseLong(actionRequest.getParameter("rsvpId")
									.toString()));

					title = updateRsvp.getTitle();
					description = updateRsvp.getDescription();

					updateRsvp.setRsvpUrl(rsvpUrl);
					updateRsvp.setGroupId(themeDisplay.getScopeGroupId());
					try {
						if (Boolean.valueOf(paymentFlag)) {
							updateRsvp.setAccountId(accountID);
							updateRsvp.setPrice(price);
							String currencyName = AssetCategoryLocalServiceUtil
									.getAssetCategory(Long.valueOf(categoryId))
									.getName();
							updateRsvp.setCurrency(currencyName);
							updateRsvp.setTax(tax);
							updateRsvp.setPaymentFlag(true);
						}

						if (Boolean.valueOf(registrationFlag)) {
							updateRsvp.setRegisterFlag(true);
						}
					} catch (Exception e) {
					}

					if ("true".equals(spAssetFlag)) {
						spAssetId = actionRequest.getParameter("spAssetId");

						if (spAssetId != null) {
							updateRsvp.setSpAssetTypeId(Long
									.parseLong(spAssetId));
						}
					}

					if ("true".equals(eventFlag)) {
						String expireEvent = actionRequest
								.getParameter("canEdit");

						if (!Boolean.parseBoolean(expireEvent)) {
							eventId = actionRequest.getParameter("alleventId");
						} else {
							eventId = actionRequest.getParameter("eventId");
						}

						updateRsvp.setEventId(Long.parseLong(eventId));

					} else {
						updateRsvp.setEventId(0);
					}

					updateRsvp.setTicketFlag(Boolean.valueOf(pdfTicket));
					updateRsvp.setCcEmail(Boolean.valueOf(ccEmail));

					updateRsvp.setModifiedDate(cal.getTime());
					RsvpLocalServiceUtil.updateRsvp(updateRsvp);

					actionRequest.setAttribute("rsvpId", rsvpId);
					preferences.setValue("rsvpId",
							String.valueOf(updateRsvp.getRsvpId()));

					SPMailCampaign spMailCampaign = SPMailCampaignLocalServiceUtil
							.getSPMailCampaign(Long.valueOf(spMailCampaignId));
					spMailCampaign.setRsvpId(Long.valueOf(rsvpId));
					SPMailCampaignLocalServiceUtil
							.updateSPMailCampaign(spMailCampaign);

				} catch (Exception e) {
				}
			}

			preferences.setValue("eventId", eventId);
			preferences.setValue("spAssetId", spAssetId);
			preferences.setValue("dynamicSectionName", dynamicSectionName);
			preferences.setValue("eventFlag", eventFlag);
			preferences.setValue("paymentFlag", paymentFlag);
			preferences.setValue("registrationFlag", registrationFlag);
			preferences.setValue("spAssetFlag", spAssetFlag);
			preferences.setValue("title", title);
			preferences.setValue("description", description);
			preferences.setValue("rsvpUrl", rsvpUrl);
			preferences.setValue("dynamicrsvp", dynamicrsvp);
			preferences.setValue("spMailCampaignId", spMailCampaignId);
			preferences.setValue("categoryId", categoryId);
			preferences.setValue("accountID", accountID);
			preferences.setValue("price", price);
			preferences.setValue("tax", tax);
			preferences.setValue("multiRegFlag", multiRegFlag);
			preferences.setValue("defaultStatusFlag", defaultStatusFlag);
			preferences.setValue("countryFlag", countryFlag);
			preferences.setValue("genderFlag", genderFlag);
			preferences.setValue("numberOfPeopleFlag", numberOfPeopleFlag);
			preferences.setValue("orderFields", orderFields);
			preferences.setValue("grouping", grouping);
			preferences.setValue("discountFlag", discountFlag);
			preferences.setValue("promoCodeFlag", promoCodeFlag);
			preferences.setValue("signInFlag", signInFlag);
			preferences.setValue("emailFlag", emailFlag);
			preferences.setValue("mandatoryFlagChild", mandatoryFlagChild);
			preferences.setValue("defaultPrice", defaultPrice);
			preferences.setValue("miniPriceFlag", miniPriceFlag);
			preferences.setValue("priceListFlag", priceListFlag);

			preferences.setValue("logoUrl", logoUrl);
			preferences.setValue("colorCode", colorCode);
			preferences.setValue("pdfTicket", pdfTicket);
			preferences.setValue("ccEmail", ccEmail);

			preferences.setValue("identificationTypeFlag",
					identificationTypeFlag);
			preferences.setValue("identificationNumberFlag",
					identificationNumberFlag);
			preferences.setValue("passwordFlag", passwordFlag);
			preferences.setValue("streetAddress1Flag", streetAddress1Flag);
			preferences.setValue("streetAddress2Flag", streetAddress2Flag);
			preferences.setValue("postalCodeFlag", postalCodeFlag);
			preferences.setValue("cityFlag", cityFlag);

			// preferences.setValue("countryFlag", countryFlag);

			preferences.setValue("stateFlag", stateFlag);

			// preferences.setValue("genderFlag", genderFlag);

			preferences.setValue("phoneNumber1Flag", phoneNumber1Flag);
			preferences.setValue("phoneNumber2Flag", phoneNumber2Flag);
			preferences.setValue("hearAboutUsFlag", hearAboutUsFlag);
			preferences.setValue("attendedWebinarFlag", attendedWebinarFlag);
			preferences.setValue("termsOfUseFlag", termsOfUseFlag);
			preferences.setValue("ageRestrictionFlag", ageRestrictionFlag);
			preferences.setValue("ageGroupFlag", ageGroupFlag);

			preferences.setValue("ageGroupVocId", ageGroupVocId);
			preferences.setValue("identificationTypeVocId",
					identificationTypeVocId);
			preferences.setValue("hearAboutUsVocId", hearAboutUsVocId);
			
			preferences.setValue("customList1Flag", customList1Flag);
			preferences.setValue("customList1Label", customList1Label);
			preferences.setValue("customList1VocId", customList1VocId);
			
			preferences.store();

			actionResponse.setPortletMode(PortletMode.VIEW);

		} else if ("rsvpAction".equalsIgnoreCase(action)) {

			String promoCodeFlag = preferences.getValue("promoCodeFlag",
					StringPool.FALSE);
			String emailFlag = preferences.getValue("emailFlag",
					StringPool.FALSE);

			String logoUrl = preferences.getValue("logoUrl", StringPool.BLANK);
			String colorCode = preferences.getValue("colorCode",
					StringPool.BLANK);

			if (Validator.isNumber(preferences.getValue("rsvpId",
					StringPool.BLANK))) {
				boolean paymentEnabled = Boolean.parseBoolean(preferences
						.getValue("paymentFlag", "false"));

				long rsvpId = Long.parseLong(preferences.getValue("rsvpId",
						StringPool.BLANK));
				Rsvp rsvp = null;
				try {
					rsvp = RsvpLocalServiceUtil.getRsvp(rsvpId);
				} catch (PortalException e2) {
					_log.error(e2);
				} catch (SystemException e2) {
					_log.error(e2);
				}

				String email = actionRequest.getParameter("email");
				String firstName = actionRequest.getParameter("firstName");
				String lastName = actionRequest.getParameter("lastName");
				String promoCode = actionRequest.getParameter("promoCode");

				String identificationType = actionRequest
						.getParameter("identificationType");
				String identificationNumber = actionRequest
						.getParameter("identificationNumber");
				String password = actionRequest.getParameter("password");
				String streetAddress1 = actionRequest
						.getParameter("streetAddress1");
				String streetAddress2 = actionRequest
						.getParameter("streetAddress2");
				String postalCode = actionRequest.getParameter("postalCode");
				String city = actionRequest.getParameter("city");
				String countryId = actionRequest.getParameter("countryId");
				String state = actionRequest.getParameter("state");
				String genderId = actionRequest.getParameter("genderId");
				String phoneNumber1 = actionRequest
						.getParameter("phoneNumber1");
				String phoneNumber2 = actionRequest
						.getParameter("phoneNumber2");
				String hearAboutUs = actionRequest.getParameter("hearAboutUs");
				String attendedWebinar = actionRequest
						.getParameter("attendedWebinar");
				String termsOfUse = actionRequest.getParameter("termsOfUse");
				String ageRestriction = actionRequest
						.getParameter("ageRestriction");
				String ageGroup = actionRequest.getParameter("ageGroup");
				String customField1 = actionRequest.getParameter("customField1");

				int noOfPeople = 1;

				if (Validator.isNotNull(actionRequest
						.getParameter("noOfPeople"))) {
					noOfPeople = Validator.isNumber(actionRequest
							.getParameter("noOfPeople")) ? Integer
							.parseInt(actionRequest.getParameter("noOfPeople"))
							: 1;
				}

				SocialProfile socialProfile = null;
				String categoryName = actionRequest
						.getParameter("dynamicSectionName");
				String categoryDetails = categoryName + "_details";
				User user = null;

				boolean enableMultipleReg = Boolean.valueOf(preferences
						.getValue("multiRegFlag", "false"));

				if (enableMultipleReg && noOfPeople > 1) {
					enableMultipleReg = true;
				} else {
					enableMultipleReg = false;
				}

				try {
					if (themeDisplay.isSignedIn()
							&& !(SambaashUtil.isAdmin(
									themeDisplay.getScopeGroupId(),
									themeDisplay.getUserId()))) {
						socialProfile = SocialProfileLocalServiceUtil
								.getSocialProfile(themeDisplay.getUserId());
						user = themeDisplay.getUser();

						// user.setFirstName(actionRequest.getParameter("firstName"));
						// user.setLastName(actionRequest.getParameter("lastName"));
						// UserLocalServiceUtil.updateUser(user);

						if (Validator.isNotNull(categoryName)) {
							getUserInfoExistingUser(socialProfile,
									socialProfile.getUserInfo(), categoryName,
									categoryDetails, themeDisplay);
						}

					} else if (!themeDisplay.isSignedIn()
							|| (SambaashUtil.isAdmin(
									themeDisplay.getScopeGroupId(),
									themeDisplay.getUserId()))) {
						try {
							user = UserLocalServiceUtil.getUserByEmailAddress(
									themeDisplay.getCompanyId(), email);

							// user.setFirstName(actionRequest.getParameter("firstName"));
							// user.setLastName(actionRequest.getParameter("lastName"));
							// UserLocalServiceUtil.updateUser(user);

							socialProfile = SocialProfileLocalServiceUtil
									.getSocialProfile(user.getUserId());

							if (Validator.isNotNull(categoryName)) {
								getUserInfoExistingUser(socialProfile,
										socialProfile.getUserInfo(),
										categoryName, categoryDetails,
										themeDisplay);
							}

						} catch (NoSuchUserException e) {
							SocialProfileServiceUtil.addUser(API_KEY,
									firstName, lastName, email, (Validator
											.isNotNull(password) ? password
											: PwdGenerator.getPassword()), "0",
									"male", StringPool.BLANK);

							user = UserLocalServiceUtil.getUserByEmailAddress(
									themeDisplay.getCompanyId(), email);

							socialProfile = SocialProfileLocalServiceUtil
									.getSocialProfile(user.getUserId());

							if (Validator.isNotNull(categoryName)) {
								String xml = socialProfile.getUserInfo();
								xml.indexOf("/profile");
								xml = xml
										.replaceAll(
												"</profile>",
												"<other_details><"
														+ categoryName
														+ "/></other_details></profile>");
								try {
									createUserInfoXML(socialProfile, xml,
											categoryName, categoryDetails,
											themeDisplay);
								} catch (Exception e1) {
									_log.error(e1);
								}
							}
						}
					}

					// String dynamicrsvp = preferences.getValue("dynamicrsvp",
					// StringPool.BLANK);

					String dynamicrsvp = SambaashUtil.getParameter(
							"profile.page.url.private", 0);
					String dynamicSectionName = preferences.getValue(
							"dynamicSectionName", StringPool.BLANK);
					_log.error("dynamicSectionName " + dynamicSectionName);
					HashMap<String, HashMap<String, String>> displayArray = getDisplayFields(
							themeDisplay, dynamicrsvp, dynamicSectionName);

					if (Validator.isNotNull(dynamicSectionName)) {
						try {
							DocumentBuilder parser = DocumentBuilderFactory
									.newInstance().newDocumentBuilder();
							Document document = parser.parse(new InputSource(
									new StringReader(socialProfile
											.getUserInfo())));
							NodeList nodeList = document
									.getElementsByTagName(preferences.getValue(
											"dynamicSectionName",
											StringPool.BLANK)
											+ "_details");
							Node node = null;

							for (int i = 0; i < nodeList.getLength(); i++) {
								node = (Node) nodeList.item(i);

								if (node.hasChildNodes()) {
									NodeList nodeListRSVP = node
											.getChildNodes();
									int totalCount = 1;
									int j = 0;
									while (totalCount < nodeListRSVP
											.getLength()) {
										Node nodeRSVP = (Node) nodeListRSVP
												.item(totalCount);

										if (Validator.isNotNull(nodeRSVP
												.getNodeName())) {
											if (Boolean
													.parseBoolean(displayArray
															.get(nodeRSVP
																	.getNodeName())
															.get("display"))
													&& Boolean
															.parseBoolean(displayArray
																	.get(nodeRSVP
																			.getNodeName())
																	.get("edittable"))) {
												if (nodeRSVP.getNodeName()
														.contains(
																"monthyearcal")) {
													if (actionRequest
															.getParameter("itemMonth"
																	+ j) == null
															&& (actionRequest
																	.getParameter("itemYear"
																			+ j) == null)) {
														_log.error("*****"
																+ "itemMonth"
																+ j);
													} else {
														_log.error("*****"
																+ nodeRSVP
																		.getNodeName());
														nodeRSVP.setTextContent(String
																.valueOf(actionRequest
																		.getParameter("itemMonth"
																				+ j))
																+ "/"
																+ String.valueOf(actionRequest
																		.getParameter("itemYear"
																				+ j)));
														j++;
													}
												} else {
													if (actionRequest
															.getParameter("item"
																	+ j) == null
															|| actionRequest
																	.getParameter(
																			"item"
																					+ j)
																	.equals("")) {
														_log.error("*****"
																+ "itemMonth"
																+ j);
													} else {
														_log.error("*****"
																+ nodeRSVP
																		.getNodeName());
														nodeRSVP.setTextContent(String
																.valueOf(actionRequest
																		.getParameter("item"
																				+ j)));
														j++;
													}
												}
											}
										}

										totalCount = totalCount + 2;
									}
								}
							}

							String result = getStringFromDocument(document);
							socialProfile.setUserInfo(result);
							try {
								SocialProfileLocalServiceUtil
										.updateSocialProfile(socialProfile);
							} catch (Exception e) {
								_log.error(e);
							}
						} catch (Exception e) {
							_log.error(e);
						}
					}

					step = "success";
					actionRequest.setAttribute("step", step);

					Calendar cal = Calendar.getInstance();

					long rsvpDetailId = CounterLocalServiceUtil
							.increment("RsvpDetail.class");
					RsvpDetail rsvpDetail = RsvpDetailLocalServiceUtil
							.createRsvpDetail(rsvpDetailId);
					rsvpDetail.setRsvpId(rsvp.getRsvpId());

					if ((themeDisplay.isSignedIn() && !(SambaashUtil.isAdmin(
							themeDisplay.getScopeGroupId(),
							themeDisplay.getUserId())))
							|| !themeDisplay.isSignedIn()) {
						rsvpDetail.setSource(RsvpSource.BYMEMBER.ordinal());
					} else if (SambaashUtil.isAdmin(
							themeDisplay.getScopeGroupId(),
							themeDisplay.getUserId())) {
						rsvpDetail.setSource(RsvpSource.BYADMINI.ordinal());
					}

					if (Validator.isNotNull(actionRequest
							.getParameter("rsvpStatus"))) {
						rsvpDetail.setRsvpStatus(Integer.parseInt(actionRequest
								.getParameter("rsvpStatus")));
					} else {
						rsvpDetail
								.setRsvpStatus(RsvpStatus.ATTENDING.ordinal());
					}

					rsvpDetail.setGroupId(themeDisplay.getScopeGroupId());
					rsvpDetail.setNumberOfPeople(noOfPeople);
					rsvpDetail.setCreateDate(cal.getTime());
					rsvpDetail.setUserId(user.getUserId());
					rsvpDetail.setUserId(user.getUserId());
					rsvpDetail.setFirstName(firstName);
					rsvpDetail.setLastName(lastName);
					rsvpDetail.setEmailAddress(email);

					rsvpDetail.setIdentifiactionType(identificationType);
					rsvpDetail.setNric(identificationNumber);
					rsvpDetail.setStreetAddress1(streetAddress1);
					rsvpDetail.setStreetAddress2(streetAddress2);
					rsvpDetail.setPostalCode(postalCode);
					rsvpDetail.setCity(city);
					rsvpDetail.setCountry(countryId);
					rsvpDetail.setState(state);
					rsvpDetail.setGender(genderId);
					rsvpDetail.setPhoneNumber1(phoneNumber1);
					rsvpDetail.setPhoneNumber2(phoneNumber2);
					rsvpDetail.setHearAboutUs(hearAboutUs);
					rsvpDetail.setAttendedWebinar(attendedWebinar);
					rsvpDetail.setAgeGroup(ageGroup);
					rsvpDetail.setTermsOfUse("on".equalsIgnoreCase(termsOfUse) ? true : false);
					rsvpDetail.setAgeRestriction("on".equalsIgnoreCase(ageRestriction) ? true : false);
					//rsvpDetail.setCustomField1(customField1);

					RsvpDetailLocalServiceUtil.updateRsvpDetail(rsvpDetail);

					SPMailCampaign campaign = SPMailCampaignLocalServiceUtil
							.findByrsvpId(rsvp.getRsvpId());
					SPMailCampaignSubscribers subscriber = addSubscriber(
							rsvpDetail, campaign);
					RsvpPayment rsvpPayment = null;
					PaymentUtil paymentUtil = new PaymentUtil();

					if (paymentEnabled) {
						String miniPriceFlag = preferences.getValue(
								"miniPriceFlag", StringPool.BLANK);
						_log.debug("miniPriceFlag " + miniPriceFlag);

						if (!Boolean.parseBoolean(miniPriceFlag)) {
							if (Validator.isNull(actionRequest
									.getParameter("price"))
									|| !Validator.isNumber(actionRequest
											.getParameter("price"))) {
								throw new Exception("Invalid Pricing.");
							}
						}

						double discount = 0.0;

						if (Validator.isNotNull(actionRequest
								.getParameter("discountValue"))) {
							discount = Double.parseDouble(actionRequest
									.getParameter("discountValue"));
						}

						long rsvpPromoCodeId = 0;

						if (Validator.isNotNull(promoCode)) {
							List<RsvpPromoCode> rsvpPromoCodes = RsvpPromoCodeLocalServiceUtil
									.findByPromoCode(promoCode);

							if (rsvpPromoCodes != null
									&& rsvpPromoCodes.size() > 0) {
								rsvpPromoCodeId = rsvpPromoCodes.get(0)
										.getRsvpPromoCodeId();
							}
						}

						rsvpPayment = paymentUtil.addPaymentDetails(
								actionRequest, themeDisplay, rsvpDetail, rsvp,
								Boolean.parseBoolean(miniPriceFlag), discount,
								rsvpPromoCodeId);
					}

					if (enableMultipleReg) {
						if (rsvpDetail != null) {
							for (int i = 1; i < noOfPeople; i++) {
								long coParticipantDetailId = CounterLocalServiceUtil
										.increment("RsvpCoParticipantDetail.class");
								RsvpCoParticipantDetail coParticipantDetail = RsvpCoParticipantDetailLocalServiceUtil
										.createRsvpCoParticipantDetail(coParticipantDetailId);
								coParticipantDetail
										.setEmailAddress(actionRequest
												.getParameter("multiItemEmail"
														+ i));
								coParticipantDetail
										.setFirstName(actionRequest
												.getParameter("multiItemFirstName"
														+ i));
								coParticipantDetail.setLastName(actionRequest
										.getParameter("multiItemLastName" + i));
								coParticipantDetail.setRsvpDetailId(rsvpDetail
										.getRsvpDetailId());
								coParticipantDetail.setUserId(rsvpDetail
										.getUserId());
								coParticipantDetail.setAttendance(rsvpDetail
										.getAttendance());
								coParticipantDetail.setCreateDate(rsvpDetail
										.getCreateDate());
								coParticipantDetail.setNric(actionRequest
										.getParameter("multiItemId" + i));
								coParticipantDetail.setRsvpStatus(rsvpDetail
										.getRsvpStatus());

								if (rsvpPayment != null) {
									coParticipantDetail
											.setRsvpPaymentId(rsvpPayment
													.getRsvpPaymentId());
								}

								RsvpCoParticipantDetailLocalServiceUtil
										.updateRsvpCoParticipantDetail(coParticipantDetail);
							}
						}
					}

					// paypal processing

					if (paymentEnabled && rsvpPayment.getNetTotal() > 0) {
						Paypal paypal = paymentUtil.processPaypalPayment(
								actionRequest, themeDisplay, rsvpPayment,
								campaign, subscriber, rsvp, promoCodeFlag,
								promoCode);
						paypal.setCppPayflowColor(colorCode);
						paypal.setLogoUrl(logoUrl);
						actionRequest.setAttribute("paypal", paypal);
						actionResponse.setWindowState(WindowState.MAXIMIZED);
					} else {
						if (campaign.getThankyouTempalteId() > 0) {
							SPMailLocalServiceUtil.sendMail(campaign,
									subscriber, null,
									themeDisplay.getScopeGroupId(),
									rsvp.getCcEmail());
						}

						actionRequest.setAttribute("thankYouMsgWithoutPayment",
								"thankYouMsgWithoutPayment");
					}

					// send copy of data to admin (only for isha)

					if ("true".equalsIgnoreCase(emailFlag)) {
						UserProfileUtil util = new UserProfileUtil();
						util.emailRegData(rsvp, user, socialProfile,
								rsvpPayment, rsvpDetail, Validator
										.isNull(dynamicSectionName) ? false
										: true);
					}

				} catch (Exception e) {
					_log.error(e);
				}
			}
		} else if ("return_payment".equalsIgnoreCase(action)) {
			_log.debug("processAction : action : " + action);
			actionRequest.setAttribute("thankyouMsg", "thankyouMsg");
		} else if ("cancel".equalsIgnoreCase(action)) {
			_log.debug("processAction : action : " + action);
			String spTxnId = actionRequest.getParameter("spTxnId");
			try {
				RsvpPayment rsvpPayment = RsvpPaymentLocalServiceUtil
						.getRsvpPayment(Long.parseLong(spTxnId));
				rsvpPayment.setTicketNumber(null);
				rsvpPayment.setTransactionStatus("Cancelled");
				RsvpPaymentLocalServiceUtil.updateRsvpPayment(rsvpPayment);
			} catch (NumberFormatException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}

			actionRequest.setAttribute("cancelMsg", "cancelMsg");
		}
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		String action = ParamUtil.getString(request, "action");
		String action1 = request.getParameter("action") != null ? request
				.getParameter("action") : "-";
		_log.error("render method : action : " + action);
		_log.error("render method : action1 : " + action1);
		super.render(request, response);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		JSONObject rsvpDetail = JSONFactoryUtil.createJSONObject();

		PasswordPolicy passwordPolicy = null;

		String filterName = resourceRequest.getParameter("filter");

		if ("verifyPassword".equalsIgnoreCase(filterName)) {
			String password1 = resourceRequest.getParameter("password");
			String password2 = resourceRequest.getParameter("reTypePassword");

			String message = StringPool.BLANK;

			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			try {
				passwordPolicy = PasswordPolicyLocalServiceUtil
						.getDefaultPasswordPolicy(themeDisplay.getCompanyId());

				validatePassword(themeDisplay.getCompanyId(), 0, password1,
						password2, passwordPolicy);

				message = "Valid";

			} catch (UserPasswordException upe) {

				if (upe.getType() == UserPasswordException.PASSWORD_CONTAINS_TRIVIAL_WORDS) {
					message = "Password uses common words.";
				} else if (upe.getType() == UserPasswordException.PASSWORD_INVALID) {
					message = "Password is invalid. Please enter a different password.";
				} else if (upe.getType() == UserPasswordException.PASSWORD_LENGTH) {
					message = "Password is too short. Please make sure password is between "
							+ String.valueOf(passwordPolicy.getMinLength())
							+ "and 512 characters.";
				} else if (upe.getType() == UserPasswordException.PASSWORDS_DO_NOT_MATCH) {
					message = "Passwords do not match.";
				}

			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			} catch (Exception e) {
				_log.error(e);
			}

			resourceResponse.getWriter().write(String.valueOf(message));

		} else {

			String filter = resourceRequest.getParameter("filterValue");
			String numberOfPeople = resourceRequest.getParameter("noOfPeople");
			String promoCode = resourceRequest.getParameter("promoCode");

			if ("changeRSVP".equals(filterName)) {
				try {
					Rsvp rsvp = RsvpLocalServiceUtil.getRsvp(Long
							.parseLong(filter));

					rsvpDetail.put("title", rsvp.getTitle());
					rsvpDetail.put("description", rsvp.getDescription());
					rsvpDetail.put("eventId", rsvp.getEventId());
					rsvpDetail.put("spAssetId", rsvp.getSpAssetTypeId());
					SPMailCampaign spMailCampaign = null;
					try {
						spMailCampaign = SPMailCampaignLocalServiceUtil
								.findByrsvpId(rsvp.getRsvpId());

						if (Validator.isNotNull(spMailCampaign)) {
							rsvpDetail.put("spMailCampaignId",
									spMailCampaign.getSpMailCampaignId());
						}
					} catch (Exception e) {
					}

					if (spMailCampaign == null) {
						rsvpDetail.put("spMailCampaignId", 0);
					}

					if (rsvp.getEventId() != 0) {
						CalendarBooking calEvent = CalendarBookingLocalServiceUtil.getCalendarBooking(rsvp.getEventId());
						Calendar calEndDate = Calendar.getInstance();
						calEndDate.setTimeInMillis(calEvent.getEndTime());
						Calendar cal1 = Calendar.getInstance();

						calEndDate.set(Calendar.HOUR, Integer
								.parseInt(formatHour.format(CalUtil
										.getEndTime(calEvent))));
						calEndDate.set(Calendar.MINUTE, Integer
								.parseInt(formatMinute.format(CalUtil
										.getEndTime(calEvent))));

						if (calEvent.isRecurring()) {
							if (calEndDate.after(cal1.getTime())) {
								rsvpDetail.put("canEdit", true);
							} else {
								rsvpDetail.put("canEdit", false);
							}
						} else {
							if (CalUtil.getEndTime(calEvent).after(
									cal1.getTime())) {
								rsvpDetail.put("canEdit", true);
							} else {
								rsvpDetail.put("canEdit", false);
							}
						}
					} else {
						rsvpDetail.put("canEdit", true);
					}

				} catch (Exception e) {
				}

				resourceResponse.getWriter().write(rsvpDetail.toString());
			} else if ("loadDiscount".equals(filterName)) {
				PortletPreferences preferences = resourceRequest
						.getPreferences();
				String promoCodeFlag = preferences.getValue("promoCodeFlag",
						StringPool.FALSE);
				String rsvpId = preferences
						.getValue("rsvpId", StringPool.BLANK);
				boolean flag = false;

				try {
					PaymentUtil paymentUtil = new PaymentUtil();
					_log.debug("rsvpDiscount " + rsvpId + "" + filter);

					double discount = paymentUtil.getDiscount(
							Long.valueOf(filter), Long.valueOf(rsvpId),
							Integer.parseInt(numberOfPeople), promoCodeFlag,
							promoCode);
					_log.debug("rsvpDiscount " + discount);

					if (discount > 0) {
						rsvpDetail.put("discount", discount);
						flag = true;
					}
				} catch (Exception e) {
					_log.error(e.getMessage());
				}

				if (!flag) {
					rsvpDetail.put("discount", 0);
				}

				resourceResponse.getWriter().write(rsvpDetail.toString());
				;
			} else if ("loadPrice".equals(filterName)) {
				String ticketId = resourceRequest.getParameter("filterValue");
				double price = 0.0;
				try {
					RsvpTicket spRsvpTicket = RsvpTicketLocalServiceUtil
							.getRsvpTicket(Long.parseLong(ticketId));
					price = spRsvpTicket.getPrice();
					rsvpDetail.put("price", price);
				} catch (Exception e) {
					_log.error("Error in retrieving price " + e.getMessage());
				}

				resourceResponse.getWriter().write(rsvpDetail.toString());
			} else if ("loadNetTotal".equalsIgnoreCase(filterName)) {
				String priceSelectedStr = resourceRequest
						.getParameter("priceSelected");
				String noOfPeopleStr = resourceRequest
						.getParameter("noOfPeople");
				String taxStr = resourceRequest.getParameter("tax");
				String discountStr = resourceRequest.getParameter("discount");

				double priceSelected = 0.0d;
				int noOfPeople = 0;
				float tax = 0.0f;
				double discount = 0.0d;

				try {
					priceSelected = Double.valueOf(priceSelectedStr);
				} catch (NumberFormatException nfe) {

					// do nothing

				}

				try {
					noOfPeople = Integer.valueOf(noOfPeopleStr);
				} catch (NumberFormatException nfe) {

					// do nothing

				}

				try {
					tax = Float.valueOf(taxStr);
				} catch (NumberFormatException nfe) {

					// do nothing

				}

				try {
					discount = Double.valueOf(discountStr);
				} catch (NumberFormatException nfe) {

					// do nothing

				}

				double netTotal = (Math.round((priceSelected
						+ (tax / 100 * priceSelected) - (priceSelected
						* discount / 100)) * 100.0) / 100.0)
						* noOfPeople;
				resourceResponse.getWriter().write(String.valueOf(netTotal));
			}
		}

	}

	public void validatePassword(long companyId, long userId, String password1,
			String password2, PasswordPolicy passwordPolicy) throws Exception {
		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();
		Class<?> pwdToolkitUtilClass = portalClassLoader.loadClass(_CLASS_NAME);
		MethodKey _validateMethodKey = new MethodKey(pwdToolkitUtilClass,
				"validate", long.class, long.class, String.class, String.class,
				PasswordPolicy.class);
		PortalClassInvoker.invoke(false, _validateMethodKey, companyId, userId,
				password1, password2, passwordPolicy);
	}

	private SPMailCampaignSubscribers addSubscriber(RsvpDetail rsvpDetail,
			SPMailCampaign campaign) throws SystemException {

		// Add record for main template (It is just a dummy record . just to
		// make it consistent)

		SPMailCampaignSubscribers spMailCamSub = null;
		try {
			spMailCamSub = SPMailCampaignSubscribersLocalServiceUtil
					.findByCampaignIdMailTypeAndEmailAddress(
							campaign.getSpMailCampaignId(),
							SPMailType.MAIN.ordinal(),
							rsvpDetail.getEmailAddress());
		} catch (NoSuchCampaignSubscribersException e) {

			long spMailCampaignSubscribersId = CounterLocalServiceUtil
					.increment("SPMailCampaignSubscribers.class");
			spMailCamSub = SPMailCampaignSubscribersLocalServiceUtil
					.createSPMailCampaignSubscribers(spMailCampaignSubscribersId);

			spMailCamSub.setSpMailCampaignId(campaign.getSpMailCampaignId());
			spMailCamSub.setCreateBy(rsvpDetail.getUserId());
			spMailCamSub
					.setUserId(Validator.isNotNull(rsvpDetail.getUserId()) ? rsvpDetail
							.getUserId() : 0);
			spMailCamSub.setCreateDate(DateUtil.newDate());

			// spMailCamSub.setStatus(SPMailStatus.NOT_REQUIRED.ordinal());

			spMailCamSub.setFirstName(rsvpDetail.getFirstName());
			spMailCamSub.setLastName(rsvpDetail.getLastName());
			spMailCamSub.setEmailAddress(rsvpDetail.getEmailAddress());
			spMailCamSub.setSpMailType(SPMailType.MAIN.ordinal());
			try {
				SPMailCampaignSubscribersLocalServiceUtil
						.updateSPMailCampaignSubscribers(spMailCamSub);
			} catch (SystemException e1) {
				_log.error("error adding subscriber : "
						+ rsvpDetail.getEmailAddress());
			}
		} catch (SystemException e) {
			_log.error("Unknown error while adding subscriber : "
					+ rsvpDetail.getEmailAddress());
		}

		try {
			spMailCamSub = SPMailCampaignSubscribersLocalServiceUtil
					.findByCampaignIdMailTypeAndEmailAddress(
							campaign.getSpMailCampaignId(),
							SPMailType.THANKYOU.ordinal(),
							rsvpDetail.getEmailAddress());
		} catch (NoSuchCampaignSubscribersException e) {

			long spMailCampaignSubscribersId = CounterLocalServiceUtil
					.increment("SPMailCampaignSubscribers.class");
			spMailCamSub = SPMailCampaignSubscribersLocalServiceUtil
					.createSPMailCampaignSubscribers(spMailCampaignSubscribersId);

			spMailCamSub.setSpMailCampaignId(campaign.getSpMailCampaignId());
			spMailCamSub.setCreateBy(rsvpDetail.getUserId());
			spMailCamSub
					.setUserId(Validator.isNotNull(rsvpDetail.getUserId()) ? rsvpDetail
							.getUserId() : 0);
			spMailCamSub.setCreateDate(DateUtil.newDate());
			spMailCamSub.setStatus(SPMailStatus.PROCESSING.ordinal());
			spMailCamSub.setFirstName(rsvpDetail.getFirstName());
			spMailCamSub.setLastName(rsvpDetail.getLastName());
			spMailCamSub.setEmailAddress(rsvpDetail.getEmailAddress());
			spMailCamSub.setSpMailType(SPMailType.THANKYOU.ordinal());
			try {
				SPMailCampaignSubscribersLocalServiceUtil
						.updateSPMailCampaignSubscribers(spMailCamSub);
			} catch (SystemException e1) {
				_log.error("error adding subscriber : "
						+ rsvpDetail.getEmailAddress());
			}
		} catch (SystemException e) {
			_log.error("Unknown error while adding subscriber : "
					+ rsvpDetail.getEmailAddress());
		}

		return spMailCamSub;
	}

	private long getCountry(ThemeDisplay themeDisplay) {
		try {
			List<Address> addresses = SocialProfileLocalServiceUtil
					.getUserAddresses(themeDisplay.getUserId(),
							themeDisplay.getCompanyId());
			Address primaryAddress = (Address) addresses.get(0);
			return primaryAddress.getCountryId();
		} catch (Exception e) {
		}

		return 0;
	}

	private HashMap<String, HashMap<String, String>> getDisplayFields(
			ThemeDisplay themeDisplay, String dynamicrsvp,
			String dynamicSectionName) {
		String profielFriendlyURL = StringPool.SLASH + dynamicrsvp;
		Layout layout;
		HashMap<String, HashMap<String, String>> displayArray = new HashMap<String, HashMap<String, String>>();
		try {
			layout = LayoutLocalServiceUtil.getFriendlyURLLayout(
					themeDisplay.getScopeGroupId(), false, profielFriendlyURL);
			long plid = layout.getPlid();
			ClassLoader cl = PortalClassLoaderUtil.getClassLoader();

			PortletPreferences portletPreferences = null;
			Map<String, String[]> entrySet = null;

			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
					com.liferay.portal.model.PortletPreferences.class, cl);
			dynamicQuery.add(PropertyFactoryUtil.forName("plid").eq(
					new Long(plid)));
			dynamicQuery.add(PropertyFactoryUtil.forName("portletId").like(
					PORTLET_ID + "%"));

			@SuppressWarnings("unchecked")
			List<com.liferay.portal.model.PortletPreferences> portletPreferencesList = PortletPreferencesLocalServiceUtil
					.dynamicQuery(dynamicQuery);

			for (com.liferay.portal.model.PortletPreferences pref : portletPreferencesList) {
				String portletId = pref.getPortletId();
				PortletPreferences prefs = PortletPreferencesFactoryUtil
						.getPortletPreferencesFactory().getLayoutPortletSetup(
								layout, portletId);
				String xslName = prefs.getValue("name", "");

				if (xslName.equals(dynamicSectionName)) {
					portletPreferences = prefs;
				}
			}

			if (portletPreferences != null) {
				entrySet = portletPreferences.getMap();

				for (Map.Entry<String, String[]> entry : entrySet.entrySet()) {
					String[] value = entry.getValue();
					HashMap<String, String> mapField = new HashMap<String, String>();

					for (String entryValue : value) {
						for (String var : entryValue.split(",")) {
							if (var.contains("label")) {
								String[] dispalyedFields = var.split(":");
								mapField.put("label", dispalyedFields[1]);
							}

							if (var.contains("fieldType")) {
								String[] dispalyedFields = var.split(":");
								mapField.put("fieldType", dispalyedFields[1]);
							}

							if (var.contains("mandatory")) {
								String[] dispalyedFields = var.split(":");
								mapField.put("mandatory", dispalyedFields[1]);
							}

							if (var.contains("options")) {
								String[] dispalyedFields = var.split(":");
								mapField.put("options", dispalyedFields[1]);
							}

							if (var.contains("validation")) {
								String[] dispalyedFields = var.split(":");
								mapField.put("validation", dispalyedFields[1]);
							}

							if (var.contains("display")) {
								String[] dispalyedFields = var.split(":");
								mapField.put("display", dispalyedFields[1]);
							}

							if (var.contains("edittable")) {
								String[] dispalyedFields = var.split(":");
								mapField.put("edittable", dispalyedFields[1]);
							}
						}
					}

					displayArray.put(entry.getKey(), mapField);
				}
			}
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		}

		return displayArray;

	}

	private String getStringFromDocument(Document doc) {
		try {
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			Result result = new javax.xml.transform.stream.StreamResult(writer);

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			return writer.toString();
		} catch (javax.xml.transform.TransformerException ex) {
			_log.error(ex);
			return null;
		}
	}

	private void getUserInfoExistingUser(SocialProfile socialProfile,
			String userInfoXml, String categoryName, String categoryDetails,
			ThemeDisplay themeDisplay) throws Exception {
		DocumentBuilder parser = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document document = parser.parse(new InputSource(new StringReader(
				socialProfile.getUserInfo())));
		NodeList nodeList = document.getElementsByTagName(categoryDetails);

		if (nodeList.getLength() < 1) {
			createUserInfoXML(socialProfile, userInfoXml, categoryName,
					categoryDetails, themeDisplay);
		}
	}

	private static final String _CLASS_NAME = "com.liferay.portal.security.pwd.PwdToolkitUtil";

	private static final String API_KEY = "mXqb6XuR+SVQXix3y1MQUxtIy1W4NbY/MLLZfv4RA==";

	private static final SimpleDateFormat formatHour = new SimpleDateFormat(
			"HH");

}
