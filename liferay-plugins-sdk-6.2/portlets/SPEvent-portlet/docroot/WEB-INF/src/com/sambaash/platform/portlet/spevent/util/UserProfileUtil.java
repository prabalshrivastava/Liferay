package com.sambaash.platform.portlet.spevent.util;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.model.RsvpDetail;
import com.sambaash.platform.srv.rsvp.model.RsvpPayment;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class UserProfileUtil {
	
	private static Log _log = LogFactoryUtil.getLog(UserProfileUtil.class);

	public boolean getVisibleNodes(String dynamicSection, String xmlString, String xPath) {
		boolean isRelatedDynamicSection = false;
		try {
			NodeList nodes = findNodeList(xmlString, "//" + xPath);


			for (int i = 0; i < nodes.getLength(); i++) {
				Node childNode = nodes.item(i);
				NodeList childNodes = childNode.getChildNodes();

				if (childNodes.getLength() > 1) {
					for (int j = 0; j < childNodes.getLength(); j++) {
						Node grandChildNode = childNodes.item(j);
						String text = grandChildNode.getTextContent().trim();


						if (text != null) {
							if (text.equalsIgnoreCase(dynamicSection)) {
								isRelatedDynamicSection = true;
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return isRelatedDynamicSection;
	}

	public Map<String, String> getVisibleNodes(String xmlString, String xPath) {
		String nameText = StringPool.BLANK;
		String label = StringPool.BLANK;
		Map<String, String> nodesMap = new HashMap<String, String>();
		try {
			NodeList nodes = findNodeList(xmlString, "//" + xPath);


			for (int i = 0; i < nodes.getLength(); i++) {
				Node childNode = nodes.item(i);
				NodeList childNodes = childNode.getChildNodes();

				if (childNodes.getLength() > 1) {
					for (int j = 0; j < childNodes.getLength(); j++) {
						Node grandChildNode = childNodes.item(j);
						String key = grandChildNode.getNodeName();
						String text = grandChildNode.getTextContent().trim();

						if (text != null) {
							if (key.equalsIgnoreCase("name")) {
								nameText = text;
							}

							if ((key.equalsIgnoreCase("value")) && (text.contains("display:true"))) {
								String fieldvalues[] = text.split(",");

								for (int l = 0; i < fieldvalues.length - 1; l++) {
									if (fieldvalues[l].contains("label")) {
										String labelText[] = fieldvalues[l].split(":");
										label = labelText[1];
										break;
									}
								}

								nodesMap.put(nameText, label);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return nodesMap;
	}

	public Map<String, String> getRSVPVisibleNodes(String xmlString, String xPath) {
		String nameText = StringPool.BLANK;
		String label = StringPool.BLANK;
		Map<String, String> nodesMap = new HashMap<String, String>();
		try {
			NodeList nodes = findNodeList(xmlString, "//" + xPath);

			for (int i = 0; i < nodes.getLength(); i++) {
				Node childNode = nodes.item(i);
				NodeList childNodes = childNode.getChildNodes();

				if (childNodes.getLength() > 1) {
					for (int j = 0; j < childNodes.getLength(); j++) {
						Node grandChildNode = childNodes.item(j);
						String key = grandChildNode.getNodeName();
						String text = grandChildNode.getTextContent().trim();

						if (text != null) {
							if (key.equalsIgnoreCase("name")) {
								nameText = text;
							}

							if ((key.equalsIgnoreCase("value")) && (text.contains("true"))) {
								nodesMap.put(nameText, nameText);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return nodesMap;
	}

	public String getNode(XMLManipulator manipulator, String categoryName, String nodeName) {

		// fieldValue = manipulator.findValue("//" + fieldName);

		NodeList nodes = manipulator.findNodeList("//other_details/" + categoryName + "/" + categoryName + "_details");

		// NodeList nodeList = document.getElementsByTagName(categoryName +
		// "_details");

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = (Node)nodes.item(i);

			if (node.hasChildNodes()) {
				NodeList nodeListRSVP = node.getChildNodes();

				int totalCount = 0;
				while (totalCount < nodeListRSVP.getLength()) {
					Node nodeRSVP = (Node)nodeListRSVP.item(totalCount);

					if (nodeRSVP.getNodeName().contains(nodeName)) {
						return nodeRSVP.getTextContent();
					}

					totalCount++;
				}
			}
		}

		return StringPool.BLANK;
	}

	public NodeList findNodeList(String xmlString, String xpath) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new InputSource(new StringReader(xmlString)));
		Element root = doc.getDocumentElement();

		doc = root.getOwnerDocument();
		doc.normalizeDocument();
		NodeList nodes = XPathAPI.selectNodeList(root, xpath);
		return nodes;
	}

	public void emailRegData(Rsvp rsvp, User user, SocialProfile socialProfile, RsvpPayment rsvpPayment,
			RsvpDetail rsvpDetail, boolean isDynamicSection) {
		try {
			StringBuilder content = new StringBuilder();

			content.append("<html><body><tr><td>First Name</td><td>").append(user.getFirstName()).append("</td></tr>");
			content.append("<tr><td>Last Name</td><td>").append(user.getLastName()).append("</td></tr>");
			content.append("<tr><td>Email Address</td><td>").append(user.getEmailAddress()).append("</td></tr>");

			content.append("<tr><td>Street Address 1</td><td>").append(rsvpDetail.getStreetAddress1())
					.append("</td></tr>");
			content.append("<tr><td>Street Address 2</td><td>").append(rsvpDetail.getStreetAddress2())
					.append("</td></tr>");
			content.append("<tr><td>Postal Code</td><td>").append(rsvpDetail.getPostalCode()).append("</td></tr>");
			content.append("<tr><td>City</td><td>").append(rsvpDetail.getCity()).append("</td></tr>");
			content.append("<tr><td>Country</td><td>").append(rsvpDetail.getCountry()).append("</td></tr>");
			content.append("<tr><td>State</td><td>").append(rsvpDetail.getState()).append("</td></tr>");
			content.append("<tr><td>Gender</td><td>").append(rsvpDetail.getGender()).append("</td></tr>");
			content.append("<tr><td>Phone Number 1</td><td>").append(rsvpDetail.getPhoneNumber1()).append("</td></tr>");
			content.append("<tr><td>Phone Number 2</td><td>").append(rsvpDetail.getPhoneNumber2()).append("</td></tr>");
			content.append("<tr><td>Hear About Us</td><td>").append(rsvpDetail.getHearAboutUs()).append("</td></tr>");
			content.append("<tr><td>Attended Webinar</td><td>").append(rsvpDetail.getAttendedWebinar())
					.append("</td></tr>");
			content.append("<tr><td>Age Group</td><td>").append(rsvpDetail.getAgeGroup()).append("</td></tr>");
			content.append("<tr><td>Age Restrition</td><td>").append(rsvpDetail.getAgeRestriction())
					.append("</td></tr>");

			if (isDynamicSection) {
				String dynamicSection = rsvp.getDynamicSectionName();
				String xmlString = StringPool.BLANK;
				Map<String, String> dynamicSectionNode = null;
				UserProfileUtil profileUtil = new UserProfileUtil();
				List<com.liferay.portal.model.PortletPreferences> portletPref = PortletPreferencesLocalServiceUtil
						.getPortletPreferenceses(-1, -1);

				for (com.liferay.portal.model.PortletPreferences pPref : portletPref) {
					String pId = pPref.getPortletId();

					if (pId.contains("UserProfile_WAR_UserProfileportlet")) {
						xmlString = pPref.getPreferences();
						boolean relatedDynamicSection = profileUtil.getVisibleNodes(dynamicSection, xmlString,
								"preference");

						if (relatedDynamicSection) {
							dynamicSectionNode = profileUtil.getVisibleNodes(xmlString, "preference");
							break;
						}
					}
				}

				if (Validator.isNotNull(socialProfile) && Validator.isNotNull(socialProfile.getUserInfo())) {
					XMLManipulator manipulator = new XMLManipulator(socialProfile.getUserInfo());
					Set<Map.Entry<String, String>> set = dynamicSectionNode.entrySet();

					for (Map.Entry<String, String> node : set) {
						String nodeValue = profileUtil.getNode(manipulator, dynamicSection, node.getKey());
						String nodeLabel = node.getValue();
						content.append("<tr><td>").append(nodeLabel).append("</td><td>").append(nodeValue)
								.append("</td></tr>");
					}
				}
			}

			if (rsvpPayment != null) {
				content.append("<tr><td>Payment Id</td><td>").append(rsvpPayment.getRsvpPaymentId())
						.append("</td></tr>");
				content.append("<tr><td>Number of People</td><td>").append(rsvpPayment.getNumberOfPeople())
						.append("</td></tr>");
				content.append("<tr><td>Amount</td><td>").append(rsvpPayment.getNetTotal())
						.append("</td></tr></body></html>");
			} else {
				content.append("<tr><td>Rsvp Detail Id</td><td>").append(rsvpDetail.getRsvpDetailId())
						.append("</td></tr>");
				content.append("<tr><td>Number of People</td><td>").append(rsvpDetail.getNumberOfPeople())
						.append("</td></tr>");
			}

			String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_NAME);

			String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			MailMessage mailMessage = new MailMessage();
			mailMessage.setFromAddress(fromAddress);
			mailMessage.setFromName(fromName);
			mailMessage.setSubject(rsvp.getTitle());
			mailMessage.setToAddress(fromAddress);
			mailMessage.setHtmlBody(content.toString());
			SPMailLocalServiceUtil.sendMail(mailMessage);

		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
}