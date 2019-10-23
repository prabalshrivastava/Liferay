package com.sambaash.platform.portlet.spevent.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.compat.portal.model.UserConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.calendar.NoSuchEventException;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.model.RsvpAttendanceList;
import com.sambaash.platform.portlet.spevent.util.CalUtil;
import com.sambaash.platform.portlet.spevent.util.ExcelUtil;
import com.sambaash.platform.portlet.spevent.util.UserProfileUtil;
import com.sambaash.platform.portlet.spevent.util.XMLManipulator;
import com.sambaash.platform.srv.rsvp.NoSuchRsvpException;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.model.RsvpDetail;
import com.sambaash.platform.srv.rsvp.service.RsvpDetailLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileDetailLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class RSVPDetailAction
 */
public class RSVPDetailAction extends MVCPortlet {

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences preferences = renderRequest.getPreferences();
		String mobileNumberId = preferences.getValue("mobileNumberId", StringPool.BLANK);
		String pageName = preferences.getValue("pageName", StringPool.BLANK);

		String pageNameOfCoParticipantsDetail = preferences
				.getValue("pageNameOfCoParticipantsDetail", StringPool.BLANK);

		renderRequest.setAttribute("mobileNumberId", mobileNumberId);
		renderRequest.setAttribute("pageName", pageName);
		renderRequest.setAttribute("pageNameOfCoParticipantsDetail", pageNameOfCoParticipantsDetail);

		super.doEdit(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Rsvp> rsvpList = null;
		List<RsvpDetail> rsvpDetailList = null;
		List<Rsvp> resultRsvp = new ArrayList<Rsvp>();
		boolean hasAccess = false;
		try {
			rsvpList = RsvpLocalServiceUtil.getRsvps(-1, -1);
			Calendar cal1 = Calendar.getInstance();
			if (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
					|| SambaashUtil.isReportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())) {
				hasAccess = true;
			}

			for (Rsvp rsvp : rsvpList) {
				if (rsvp.getEventId() > 0) {
					try {
						CalendarBooking rsvpCal = CalendarBookingLocalServiceUtil.getCalendarBooking(rsvp.getEventId());

						Calendar calEndDate = Calendar.getInstance();
						calEndDate.setTimeInMillis(rsvpCal.getEndTime());
						calEndDate.set(Calendar.DAY_OF_MONTH, calEndDate.get(Calendar.DAY_OF_MONTH) - 1);

						calEndDate.set(Calendar.HOUR,
								Integer.parseInt(formatHour.format(CalUtil.getEndTime(rsvpCal))) + 12);
						calEndDate.set(Calendar.MINUTE,
								Integer.parseInt(formatMinute.format(CalUtil.getEndTime(rsvpCal))));

						if (rsvpCal.isRecurring()) {
							if (calEndDate.getTime().after(cal1.getTime())) {
								resultRsvp.add(rsvp);
							}
						} else {
							if (CalUtil.getEndTime(rsvpCal).after(cal1.getTime())) {
								resultRsvp.add(rsvp);
							}
						}

					} catch (NoSuchEventException e) {
					}

				} else {
					resultRsvp.add(rsvp);
				}
			}

			rsvpDetailList = RsvpDetailLocalServiceUtil.getRsvpDetails(0, totalCount);
		} catch (Exception e) {
			_log.error("No RSVP Detail list available " + e.getMessage());
		}

		renderRequest.setAttribute("hasAccess", hasAccess);
		renderRequest.setAttribute("rsvpList", resultRsvp);
		renderRequest.setAttribute("rsvpDetailList", null);
		renderRequest.setAttribute("hasrsvpDetailList", rsvpDetailList.isEmpty());

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException {
		String action = actionRequest.getParameter("action");
		PortletPreferences preferences = actionRequest.getPreferences();

		if (Constants.VIEW.equalsIgnoreCase(action)) {
			filterByRSVP(actionRequest, actionResponse, "");
		} else {
			if ("dynamicFields".equalsIgnoreCase(action)) {
				String mobileNumberId = actionRequest.getParameter("mobileNumberId");
				String pageName = actionRequest.getParameter("pageName");
				String pageNameOfCoParticipantsDetail = actionRequest.getParameter("pageNameOfCoParticipantsDetail");

				preferences.setValue("mobileNumberId", mobileNumberId);
				preferences.setValue("pageName", pageName);
				preferences.setValue("pageNameOfCoParticipantsDetail", pageNameOfCoParticipantsDetail);
				preferences.store();
				actionResponse.setPortletMode(PortletMode.VIEW);
			} else {
				String[] selectedRsvp = actionRequest.getParameterValues("rsvpSelect");
				String rsvpAtt = StringPool.BLANK;

				ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

				long rsvpDetailId = 0;
				try {
					if (selectedRsvp != null) {
						for (int i = 0; i < selectedRsvp.length; ++i) {
							rsvpDetailId = Long.parseLong(selectedRsvp[i]);

							if (rsvpDetailId > 0) {
								String rsvpAttId = "rsvpAtt_" + rsvpDetailId;
								rsvpAtt = actionRequest.getParameter(rsvpAttId);
								RsvpDetail rsvpDetail = RsvpDetailLocalServiceUtil.getRsvpDetail(rsvpDetailId);
								//rsvpDetail.setRsvpStatus(Integer.parseInt(rsvpStatus));
								rsvpDetail.setAttendance(Integer.parseInt(rsvpAtt));
								rsvpDetail.setRsvpStatusBy(themeDisplay.getUserId());
								rsvpDetail.setRsvpStatusDate(Calendar.getInstance().getTime());
								RsvpDetailLocalServiceUtil.updateRsvpDetail(rsvpDetail);
							}
						}
					}
				} catch (Exception e) {
					_log.error("rsvp detail not updated " + e.getMessage());
				}
			}
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String action = resourceRequest.getParameter("action");

		String filter = ParamUtil.getString(resourceRequest, "filterType", StringPool.BLANK);
		String value = ParamUtil.getString(resourceRequest, "filterValue", StringPool.BLANK);
		long rsvpId = ParamUtil.getLong(resourceRequest, "rsvpId", -1L);
		String includeCo = ParamUtil.getString(resourceRequest, "includeCo", StringPool.FALSE);

		if (Constants.EXPORT.equalsIgnoreCase(action)) {
			HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
			HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);

			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			if (SambaashUtil.isUserSignedIn(request)
					&& (SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()) || SambaashUtil
							.isReportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()))) {
				try {
					Rsvp rsvp = RsvpLocalServiceUtil.getRsvp(rsvpId);
					List<Object> objectList = null;

					if (Validator.isNotNull(filter) && Validator.isNotNull(value)) {
						if ("name".equalsIgnoreCase(filter)) {
							objectList = RsvpDetailLocalServiceUtil.findByCustomSqlRsvpIdAndName(rsvpId, value, value, -1, -1);
						} else if ("email".equalsIgnoreCase(filter)) {
							objectList = RsvpDetailLocalServiceUtil.findByCustomSqlRsvpIdAndEMailAddress(rsvpId, value, -1, -1);
						} else {
							sendError(response, "Invalid Parameters");
						}
					} else if (Validator.isNull(filter) || Validator.isNull(value)) {
						objectList = RsvpDetailLocalServiceUtil.findByCustomSqlAndRsvpId(rsvpId, -1, -1);
					} else {
						sendError(response, "Invalid Parameters");
					}

					if (objectList != null && objectList.size() > 0) {
						ExcelUtil excelUtil = new ExcelUtil();
						String filePath = excelUtil.createExcel(objectList, rsvp, includeCo);
						String contentType = MimeTypesUtil.getContentType(filePath);
						File file = new File(filePath);
						boolean exists = file.exists();

						if (!exists) {
							_log.info("File does not exists");
						}

						Integer length = new Integer(file.length() + "");
						response.setContentType(contentType);
						response.setHeader("Content-Length", String.valueOf(file.length()));
						response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
						_log.info("File length ==" + file.length());

						final FileInputStream fos = new FileInputStream(file);
						BufferedOutputStream output = null;
						output = new BufferedOutputStream(response.getOutputStream(), length);
						byte[] buffer = new byte[length];
						while ((length = fos.read(buffer)) > 0) {
							output.write(buffer, 0, length);
						}

						if (fos != null) {
							fos.close();
						}
					}
				} catch (Exception e) {
					throw new PortletException(e);
				}

			} else {
				sendError(response, "Unauthorised Access");
			}
		}
	}

	private void filterByRSVP(ActionRequest actionRequest, ActionResponse actionResponse, String loadmore) {

		String filterName = actionRequest.getParameter("filterNames");
		String filterValue = actionRequest.getParameter("filterValue");
		if (Validator.isNotNull(filterValue) && (filterValue.equalsIgnoreCase("yes"))) {
			filterValue = "0";
		} else if (Validator.isNotNull(filterValue) && (filterValue.equalsIgnoreCase("no"))) {
			filterValue = "1";
		}

		if (Validator.isNotNull(actionRequest.getParameter("rsvp_Names"))) {
			long rsvpId = Long.parseLong(actionRequest.getParameter("rsvp_Names"));

			try {
				Rsvp rsvp = RsvpLocalServiceUtil.getRsvp(rsvpId);
				List<List<RsvpAttendanceList>> rsvpwrapperList = new LinkedList<List<RsvpAttendanceList>>();
				
				if(rsvp.isPaymentFlag()){
					List<Object> objectList = null;
	
					if (Validator.isNotNull(filterName) && Validator.isNotNull(filterValue)) {
						if ("name".equalsIgnoreCase(filterName)) {
							objectList = RsvpDetailLocalServiceUtil.findByCustomSqlRsvpIdAndName(rsvpId,
									filterValue.toLowerCase(), filterValue.toLowerCase(), -1, -1);
	
							rsvpwrapperList = populateRsvpDetail(objectList, rsvp, actionRequest);
						} else if ("email".equalsIgnoreCase(filterName)) {
							objectList = RsvpDetailLocalServiceUtil.findByCustomSqlRsvpIdAndEMailAddress(rsvpId,
									filterValue.toLowerCase(), -1, -1);
							rsvpwrapperList = populateRsvpDetail(objectList, rsvp, actionRequest);
						} else {
							throw new PortalException("Invalid Filters");
						}
	
						actionRequest.setAttribute("filterNames", filterName);
						actionRequest.setAttribute("filterValue", filterValue);
	
					} else if (Validator.isNull(filterName) || Validator.isNull(filterValue)) {
						objectList = RsvpDetailLocalServiceUtil.findByCustomSqlAndRsvpId(rsvpId, -1, -1);
						rsvpwrapperList = populateRsvpDetail(objectList, rsvp, actionRequest);
					}
				}else{
					if (Validator.isNotNull(filterName) && Validator.isNotNull(filterValue)) {
						if ("name".equalsIgnoreCase(filterName)) {
							List<RsvpDetail> rsvpDetail = RsvpDetailLocalServiceUtil.findBynameAndRsvpId(filterValue.toLowerCase(), rsvpId);
							rsvpwrapperList = populateRsvpDetailWithOutPayment(rsvpDetail,rsvp, actionRequest);
						} else if ("email".equalsIgnoreCase(filterName)) {
							List<RsvpDetail> rsvpDetail = RsvpDetailLocalServiceUtil.findByemailAddressAndRsvpId(rsvpId, filterValue.toLowerCase());
							rsvpwrapperList = populateRsvpDetailWithOutPayment(rsvpDetail,rsvp, actionRequest);
						} else {
							throw new PortalException("Invalid Filters");
						}
	
						actionRequest.setAttribute("filterNames", filterName);
						actionRequest.setAttribute("filterValue", filterValue);
	
					} else if (Validator.isNull(filterName) || Validator.isNull(filterValue)) {
						List<RsvpDetail> rsvpDetail = RsvpDetailLocalServiceUtil.findByRsvpId(rsvpId);
						rsvpwrapperList = populateRsvpDetailWithOutPayment(rsvpDetail,rsvp, actionRequest);
					}
					
				}
				actionRequest.setAttribute("rsvpwrapperList", rsvpwrapperList);
				actionRequest.setAttribute("selectedRsvp", rsvp.getRsvpId());
				actionResponse.setPortletMode(PortletMode.VIEW);

			} catch (NoSuchRsvpException e) {
				_log.error("Rsvp not found");
			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			} catch (PortletModeException e) {
				_log.error(e);
			}
		}
	}

	private List<List<RsvpAttendanceList>> populateRsvpDetailWithOutPayment(
			List<RsvpDetail> rsvpDetailList, Rsvp rsvp, ActionRequest actionRequest) {
		
		PortletPreferences preferences = actionRequest.getPreferences();
		String firstName = StringPool.BLANK;
		String lastName = StringPool.BLANK;
		String emailAddress = StringPool.BLANK;
		int attendance = 0;
		int numberOfPeople = 0;
		String userInfo = StringPool.BLANK;

		UserProfileUtil profileUtil = new UserProfileUtil();
		Map<String, String> RsvpDynamicSectionNode = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		List<List<RsvpAttendanceList>> attendanceList = new LinkedList<List<RsvpAttendanceList>>();
		String dynamicSection = rsvp.getDynamicSectionName();
		String xmlString = StringPool.BLANK;
		Map<String, String> dynamicSectionNode = null;
		try {
			List<com.liferay.portal.model.PortletPreferences> portletPref = PortletPreferencesLocalServiceUtil
					.getPortletPreferenceses(-1, -1);

			for (com.liferay.portal.model.PortletPreferences pPref : portletPref) {
				String pId = pPref.getPortletId();

				if (pId.contains("UserProfile_WAR_UserProfileportlet")) {
					xmlString = pPref.getPreferences();
					boolean relatedDynamicSection = profileUtil
							.getVisibleNodes(dynamicSection, xmlString, "preference");

					if (relatedDynamicSection) {
						dynamicSectionNode = profileUtil.getVisibleNodes(xmlString, "preference");
						break;
					}
				}
			}
		} catch (Exception e) {
			_log.error("prefernces node " + e.getMessage());
		}

		/** new form fields added -- by Harini **/
		profileUtil = new UserProfileUtil();
		try {
			List<com.liferay.portal.model.PortletPreferences> rsvpportletPref = PortletPreferencesLocalServiceUtil
					.getPortletPreferenceses(-1, -1);

			for (com.liferay.portal.model.PortletPreferences pPref : rsvpportletPref) {
				String pId = pPref.getPortletId();

				if (pId.contains("RSVP_WAR_SPEventportlet")) {
					String rsvpXmlString = pPref.getPreferences();

					if (rsvpXmlString.contains(rsvp.getTitle())) {
						RsvpDynamicSectionNode = profileUtil.getRSVPVisibleNodes(rsvpXmlString, "preference");
					}
				}
			}
		} catch (Exception e) {
			_log.error("prefernces node " + e.getMessage());
		}

		for (RsvpDetail rsvpDetail : rsvpDetailList) {

			
			List<RsvpAttendanceList> innerList = new LinkedList<RsvpAttendanceList>();
			
			firstName = rsvpDetail.getFirstName();
			lastName = rsvpDetail.getLastName();
			emailAddress = rsvpDetail.getEmailAddress();
			attendance = rsvpDetail.getAttendance();
			numberOfPeople = rsvpDetail.getAttendance();
			
			String gender = StringPool.BLANK;
			String ageGroup = StringPool.BLANK;
			String identificationType = StringPool.BLANK;
			String nric = StringPool.BLANK;
			String streetAddress1 = StringPool.BLANK;
			String streetAddress2 = StringPool.BLANK;
			String city = StringPool.BLANK;
			String state = StringPool.BLANK;
			String postalCode = StringPool.BLANK;
			String country = StringPool.BLANK;
			String address = StringPool.BLANK;
			String phoneNumber1 = StringPool.BLANK;
			String phoneNumber2 = StringPool.BLANK;
			String phoneNumber = StringPool.BLANK;
			String hearAboutUs = StringPool.BLANK;
			String attendedWebinar = StringPool.BLANK;
			boolean addressFlag = false;
			boolean phoneFlag = false;

			
			try{
			SocialProfile socialprofile = SocialProfileLocalServiceUtil.findByuserIdCompIdAndRegStatus(rsvp.getUserId(), rsvp.getCompanyId(), "active");
			userInfo = socialprofile.getUserInfo();
			}catch(Exception e){
				_log.error("Error getting socialprofile detail for user " + rsvp.getUserId());
			}
			long rsvpDetailId = rsvpDetail.getRsvpDetailId();

			innerList.add(new RsvpAttendanceList(String.valueOf(rsvpDetailId), "", "Rsvp Detail ID"));
			innerList.add(new RsvpAttendanceList(firstName + StringPool.SPACE + lastName, "", "Name"));
			innerList.add(new RsvpAttendanceList(emailAddress, "", "Email Address"));

			if(Validator.isNotNull(RsvpDynamicSectionNode)){
				Set<Map.Entry<String, String>> Rsvpset = RsvpDynamicSectionNode.entrySet();
				for (Map.Entry<String, String> node : Rsvpset) {
					String nodeName = node.getKey();

					if (nodeName.equalsIgnoreCase("genderFlag")) {
						gender = rsvpDetail.getGender();
						innerList.add(new RsvpAttendanceList(gender, "", "Gender"));
					}

					if (nodeName.equalsIgnoreCase("ageGroupFlag")) {
						ageGroup = rsvpDetail.getAgeGroup();
						innerList.add(new RsvpAttendanceList(ageGroup, "", "Age Group"));
					}

					if (nodeName.equalsIgnoreCase("identificationTypeFlag")) {
						identificationType = rsvpDetail.getIdentifiactionType();
						innerList.add(new RsvpAttendanceList(identificationType, "", "Identification Type"));
					}

					if (nodeName.equalsIgnoreCase("identificationNumberFlag")) {
						nric = rsvpDetail.getNric();
						innerList.add(new RsvpAttendanceList(nric, "", "Identification Number"));
					}

					if (nodeName.equalsIgnoreCase("streetAddress1Flag")) {
						streetAddress1 = rsvpDetail.getStreetAddress1();
						innerList.add(new RsvpAttendanceList(streetAddress1, "", "Address1"));
					}

					if (nodeName.equalsIgnoreCase("streetAddress2Flag")) {
						streetAddress2 = rsvpDetail.getStreetAddress1();
						innerList.add(new RsvpAttendanceList(streetAddress2, "", "Address2"));
					}

					if (nodeName.equalsIgnoreCase("cityFlag")) {
						city = rsvpDetail.getCity();
						innerList.add(new RsvpAttendanceList(city, "", "City"));
					}

					if (nodeName.equalsIgnoreCase("stateFlag")) {
						state = rsvpDetail.getState();
						innerList.add(new RsvpAttendanceList(state, "", "State"));
					}

					if (nodeName.equalsIgnoreCase("postalCodeFlag")) {
						postalCode = rsvpDetail.getPostalCode();
						innerList.add(new RsvpAttendanceList(postalCode, "", "Postal Code"));
					}

					if (nodeName.equalsIgnoreCase("countryFlag")) {
						country = rsvpDetail.getCountry();
						innerList.add(new RsvpAttendanceList(country, "", "Country"));
					}

					if (nodeName.equalsIgnoreCase("phoneNumber1Flag")) {
						phoneNumber1 = rsvpDetail.getPhoneNumber1();
						phoneFlag = true;
						innerList.add(new RsvpAttendanceList(phoneNumber1, "", "Phone Number1"));
					}

					if (nodeName.equalsIgnoreCase("phoneNumber2Flag")) {
						phoneNumber2 = rsvpDetail.getPhoneNumber2();
						innerList.add(new RsvpAttendanceList(phoneNumber2, "", "Phone Number2"));
					}

					if (nodeName.equalsIgnoreCase("hearAboutUsFlag")) {
						hearAboutUs = rsvpDetail.getHearAboutUs();
						innerList.add(new RsvpAttendanceList(hearAboutUs, "", "Hear About Us"));
					}

					if (nodeName.equalsIgnoreCase("attendedWebinarFlag")) {
						attendedWebinar = rsvpDetail.getAttendedWebinar();
						innerList.add(new RsvpAttendanceList(attendedWebinar, "", "Attended Webinar"));
					}
				}
			}
			
			if (!dynamicSection.isEmpty()) {
				if (Validator.isNotNull(userInfo)) {
					XMLManipulator manipulator = new XMLManipulator(userInfo);
					Set<Map.Entry<String, String>> set = dynamicSectionNode.entrySet();

					for (Map.Entry<String, String> node : set) {
						String nodeValue = profileUtil.getNode(manipulator, dynamicSection, node.getKey());
						String nodeLabel = node.getValue();
						innerList.add(new RsvpAttendanceList(nodeValue, "", nodeLabel));
					}
				}
			}

				innerList.add(new RsvpAttendanceList(String.valueOf(numberOfPeople), "", "Number of people"));
				innerList.add(new RsvpAttendanceList(String.valueOf(attendance), "", "Attended"));

			attendanceList.add(innerList);
		}

		return attendanceList;
	}

	private List<List<RsvpAttendanceList>> populateRsvpDetail(List<Object> objectList, Rsvp rsvp, ActionRequest actionRequest) {

		PortletPreferences preferences = actionRequest.getPreferences();
		String firstName = StringPool.BLANK;
		String lastName = StringPool.BLANK;
		String emailAddress = StringPool.BLANK;
		int attendance = 0;
		int numberOfPeople = 0;
		String transactionId = StringPool.BLANK;
		double amount = 0;
		String userInfo = StringPool.BLANK;

		/** new form fields added -- by Harini**/

		UserProfileUtil profileUtil = new UserProfileUtil();
		Map<String, String> RsvpDynamicSectionNode = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		DecimalFormat amountFormat = new DecimalFormat("###.##");
		List<List<RsvpAttendanceList>> attendanceList = new LinkedList<List<RsvpAttendanceList>>();
		String dynamicSection = rsvp.getDynamicSectionName();
		String xmlString = StringPool.BLANK;
		Map<String, String> dynamicSectionNode = null;
		try {
			List<com.liferay.portal.model.PortletPreferences> portletPref = PortletPreferencesLocalServiceUtil
					.getPortletPreferenceses(-1, -1);

			for (com.liferay.portal.model.PortletPreferences pPref : portletPref) {
				String pId = pPref.getPortletId();

				if (pId.contains("UserProfile_WAR_UserProfileportlet")) {
					xmlString = pPref.getPreferences();
					boolean relatedDynamicSection = profileUtil
							.getVisibleNodes(dynamicSection, xmlString, "preference");

					if (relatedDynamicSection) {
						dynamicSectionNode = profileUtil.getVisibleNodes(xmlString, "preference");
						break;
					}
				}
			}
		} catch (Exception e) {
			_log.error("prefernces node " + e.getMessage());
		}

		/** new form fields added -- by Harini **/
		profileUtil = new UserProfileUtil();
		try {
			List<com.liferay.portal.model.PortletPreferences> rsvpportletPref = PortletPreferencesLocalServiceUtil
					.getPortletPreferenceses(-1, -1);

			for (com.liferay.portal.model.PortletPreferences pPref : rsvpportletPref) {
				String pId = pPref.getPortletId();

				if (pId.contains("RSVP_WAR_SPEventportlet")) {
					String rsvpXmlString = pPref.getPreferences();

					if (rsvpXmlString.contains(rsvp.getTitle())) {
						RsvpDynamicSectionNode = profileUtil.getRSVPVisibleNodes(rsvpXmlString, "preference");
					}
				}
			}
		} catch (Exception e) {
			_log.error("prefernces node " + e.getMessage());
		}

		for (Object object : objectList) {
			Object[] objectArray = (Object[])object;

			Set<Map.Entry<String, String>> Rsvpset = RsvpDynamicSectionNode.entrySet();

			BigInteger rsvpPaymentId = (BigInteger)objectArray[0];
			firstName = (String)objectArray[1];
			lastName = (String)objectArray[2];
			emailAddress = (String)objectArray[3];
			attendance = (Integer)objectArray[4];
			numberOfPeople = (Integer)objectArray[5];
			transactionId = (String)objectArray[6];
			amount = (Double)objectArray[7];
			Date transactionDate = (Date)objectArray[8];
			userInfo = (String)objectArray[9];
			BigInteger rsvpDetailId = (BigInteger)objectArray[10];

			/** new form fields added -- by Harini**/
			String gender = StringPool.BLANK;
			String ageGroup = StringPool.BLANK;
			String identificationType = StringPool.BLANK;
			String nric = StringPool.BLANK;
			String streetAddress1 = StringPool.BLANK;
			String streetAddress2 = StringPool.BLANK;
			String city = StringPool.BLANK;
			String state = StringPool.BLANK;
			String postalCode = StringPool.BLANK;
			String country = StringPool.BLANK;
			String address = StringPool.BLANK;
			String phoneNumber1 = StringPool.BLANK;
			String phoneNumber2 = StringPool.BLANK;
			String phoneNumber = StringPool.BLANK;
			String hearAboutUs = StringPool.BLANK;
			String attendedWebinar = StringPool.BLANK;
			boolean addressFlag = false;
			boolean phoneFlag = false;

			List<RsvpAttendanceList> innerList = new LinkedList<RsvpAttendanceList>();

			if (rsvp.isPaymentFlag()) {
				innerList.add(new RsvpAttendanceList(String.valueOf(rsvpDetailId), "", "Rsvp Detail ID"));
				innerList.add(new RsvpAttendanceList(String.valueOf(rsvpPaymentId), "", "Rsvp Payment ID"));
				if(Validator.isNotNull(transactionDate)){
					innerList.add(new RsvpAttendanceList(dateFormat.format(transactionDate), "", "Transaction Date"));
				}	
				innerList.add(new RsvpAttendanceList(firstName + StringPool.SPACE + lastName, "", "Name"));
				innerList.add(new RsvpAttendanceList(emailAddress, "", "Email Address"));

/** new form fields added -- by Harini **/

				for (Map.Entry<String, String> node : Rsvpset) {
					String nodeName = node.getKey();

					if (nodeName.equalsIgnoreCase("genderFlag")) {
						gender = (String)objectArray[13];
						innerList.add(new RsvpAttendanceList(gender, "", "Gender"));
					}

					if (nodeName.equalsIgnoreCase("ageGroupFlag")) {
						ageGroup = (String)objectArray[14];
						innerList.add(new RsvpAttendanceList(ageGroup, "", "Age Group"));
					}

					if (nodeName.equalsIgnoreCase("identificationTypeFlag")) {
						identificationType = (String)objectArray[15];
						innerList.add(new RsvpAttendanceList(identificationType, "", "Identification Type"));
					}

					if (nodeName.equalsIgnoreCase("identificationNumberFlag")) {
						nric = (String)objectArray[16];
						innerList.add(new RsvpAttendanceList(nric, "", "Identification Number"));
					}

					if (nodeName.equalsIgnoreCase("streetAddress1Flag")) {
						streetAddress1 = (String)objectArray[17];
						innerList.add(new RsvpAttendanceList(streetAddress1, "", "Address1"));
					}

					if (nodeName.equalsIgnoreCase("streetAddress2Flag")) {
						streetAddress2 = (String)objectArray[18];
						innerList.add(new RsvpAttendanceList(streetAddress2, "", "Address2"));
					}

					if (nodeName.equalsIgnoreCase("cityFlag")) {
						city = (String)objectArray[19];
						innerList.add(new RsvpAttendanceList(city, "", "City"));
					}

					if (nodeName.equalsIgnoreCase("stateFlag")) {
						state = (String)objectArray[20];
						innerList.add(new RsvpAttendanceList(state, "", "State"));
					}

					if (nodeName.equalsIgnoreCase("postalCodeFlag")) {
						postalCode = (String)objectArray[21];
						innerList.add(new RsvpAttendanceList(postalCode, "", "Postal Code"));
					}

					if (nodeName.equalsIgnoreCase("countryFlag")) {
						country = (String)objectArray[22];
						innerList.add(new RsvpAttendanceList(country, "", "Country"));
					}

					if (nodeName.equalsIgnoreCase("phoneNumber1Flag")) {
						phoneNumber1 = (String)objectArray[23];
						phoneFlag = true;
						innerList.add(new RsvpAttendanceList(phoneNumber1, "", "Phone Number1"));
					}

					if (nodeName.equalsIgnoreCase("phoneNumber2Flag")) {
						phoneNumber2 = (String)objectArray[24];
						innerList.add(new RsvpAttendanceList(phoneNumber2, "", "Phone Number2"));
					}

					if (nodeName.equalsIgnoreCase("hearAboutUsFlag")) {
						hearAboutUs = (String)objectArray[25];
						innerList.add(new RsvpAttendanceList(hearAboutUs, "", "Hear About Us"));
					}

					if (nodeName.equalsIgnoreCase("attendedWebinarFlag")) {
						attendedWebinar = (String)objectArray[26];
						innerList.add(new RsvpAttendanceList(attendedWebinar, "", "Attended Webinar"));
					}
				}

				/** -- -- **/

				if (!dynamicSection.isEmpty()) {
					if (Validator.isNotNull(userInfo)) {
						XMLManipulator manipulator = new XMLManipulator(userInfo);
						Set<Map.Entry<String, String>> set = dynamicSectionNode.entrySet();

						for (Map.Entry<String, String> node : set) {
							String nodeValue = profileUtil.getNode(manipulator, dynamicSection, node.getKey());
							String nodeLabel = node.getValue();
							innerList.add(new RsvpAttendanceList(nodeValue, "", nodeLabel));
						}
					}
				}

				innerList.add(new RsvpAttendanceList(transactionId, "", "PayPal Id"));

				innerList.add(new RsvpAttendanceList(String.valueOf(numberOfPeople), "", "Number of people"));

				innerList.add(new RsvpAttendanceList(amountFormat.format(amount), "", "Amount"));
				innerList.add(new RsvpAttendanceList(String.valueOf(attendance), "", "Attended"));
			}

			attendanceList.add(innerList);
		}

		return attendanceList;
	}

	private void sendError(HttpServletResponse response, String message) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(message);
		out.flush();
	} private SimpleDateFormat formatHour = new SimpleDateFormat("HH");

	private static final int totalCount = 50;

	private static Log _log = LogFactoryUtil.getLog(RSVPDetailAction.class);

	private SimpleDateFormat formatMinute = new SimpleDateFormat("mm");

}
