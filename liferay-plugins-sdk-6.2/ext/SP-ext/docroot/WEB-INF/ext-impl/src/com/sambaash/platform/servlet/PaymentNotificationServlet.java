package com.sambaash.platform.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;

import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.liferay.mail.model.FileAttachment;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.model.SPMailType;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.model.RsvpDetail;
import com.sambaash.platform.srv.rsvp.model.RsvpPayment;
import com.sambaash.platform.srv.rsvp.model.RsvpTicket;
import com.sambaash.platform.srv.rsvp.service.RsvpDetailLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpPaymentLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpTicketLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.util.PaypalUtil;
import com.sambaash.platform.util.TicketUtil;

public class PaymentNotificationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long spRsvpPaymentId = ParamUtil.getLong(request, "spTxnId");

		_log.info("spRsvpPaymentId : " + spRsvpPaymentId);

		Enumeration<String> en = request.getParameterNames();// read post
																// from
																// PayPal
																// system
																// and add
																// 'cmd'
		String str = "cmd=_notify-validate";
		while (en.hasMoreElements()) {
			String paramName = (String) en.nextElement();
			String paramValue = request.getParameter(paramName);

			str = str + "&" + paramName + "="
					+ URLEncoder.encode(paramValue, "UTF-8");
		}

		_log.info("str: " + str);

		long groupId = Long.valueOf(SambaashConstants.DEFAULT_GROUP_ID);

		String paypalGatewayURL = PaypalUtil.getPaypalGatewayURL(groupId);
		// String paypalGatewayURL =
		// "https://www.sandbox.paypal.com/cgi-bin/webscr";

		// post back to PayPal system to validate
		// NOTE: change http: to https: in the following URL to verify using
		// SSL (for increased security).
		// using HTTPS requires either Java 1.4 or greater, or Java Secure
		// Socket Extension (JSSE)
		// and configured for older versions.
		URL u = new URL(paypalGatewayURL);
		URLConnection uc = u.openConnection();
		uc.setDoOutput(true);
		uc.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		PrintWriter pw = new PrintWriter(uc.getOutputStream());
		pw.println(str);
		pw.close();

		String res = "";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			res = in.readLine();
		} catch (IOException e) {
			_log.error(e.getMessage(), e);
		} finally {
			if (in != null) {
				in.close();
			}
		}

		String paymentStatus = ParamUtil.getString(request, "payment_status");
		String txnId = ParamUtil.getString(request, "txn_id");
		String payerEmailAddress = ParamUtil.getString(request, "payer_email");
		String receiverEmailAddress = ParamUtil.getString(request,
				"receiver_email");
		double amount = ParamUtil.getDouble(request, "mc_gross");

		_log.info("payment_status : " + paymentStatus + "txn_id : " + txnId
				+ "mc_gross : " + amount + "mc_currency : "
				+ ParamUtil.getString(request, "mc_currency")
				+ "receiver_email : " + receiverEmailAddress + "payer_email : "
				+ payerEmailAddress);

		if (res.equalsIgnoreCase("VERIFIED")) {
			_log.error("Paypal transaction completed successfully.");

			try {

				RsvpPayment rsvpPayment = RsvpPaymentLocalServiceUtil
						.getRsvpPayment(spRsvpPaymentId);
				rsvpPayment.setTransactionId(txnId);
				rsvpPayment.setTransactionAmount(amount);
				rsvpPayment.setTransactionStatus(paymentStatus);
				rsvpPayment.setTransactionDate(DateUtil.newDate());
				rsvpPayment.setPayerEmailAddress(payerEmailAddress);
				rsvpPayment.setReceiverEmailAddress(receiverEmailAddress);
				if (Validator.isNotNull(rsvpPayment)) {
					rsvpPayment.setTicketNumber(null);
				}
				if ("Completed".equalsIgnoreCase(rsvpPayment
						.getTransactionStatus())) {

					RsvpDetail rsvpDetail = RsvpDetailLocalServiceUtil
							.getRsvpDetail(rsvpPayment.getRsvpDetailId());
					Rsvp rsvp = RsvpLocalServiceUtil.getRsvp(rsvpPayment
							.getRsvpId());

					SPMailCampaign campaign = SPMailCampaignLocalServiceUtil
							.findByrsvpId(rsvp.getRsvpId());
					SPMailCampaignSubscribers subscriber = SPMailCampaignSubscribersLocalServiceUtil
							.findByCampaignIdMailTypeAndEmailAddress(
									campaign.getSpMailCampaignId(),
									SPMailType.THANKYOU.ordinal(),
									rsvpDetail.getEmailAddress());
					List<FileAttachment> fileList = null;
					if (rsvp.isTicketFlag()) {
						TicketUtil ticket = new TicketUtil();
						SocialProfile socialProfile = null;
						User user = null;

						long spRsvpTicketId = rsvpPayment.getRsvpTicketId();

						String dynamicSectionName = rsvp
								.getDynamicSectionName();

						if (rsvpDetail.getUserId() > 0) {
							socialProfile = SocialProfileLocalServiceUtil
									.getSocialProfile(rsvpDetail.getUserId());
						} else {
							user = UserLocalServiceUtil.getUserByEmailAddress(
									PortalUtil.getDefaultCompanyId(),
									rsvpDetail.getEmailAddress());
							socialProfile = SocialProfileLocalServiceUtil
									.getSocialProfile(user.getUserId());
						}

						if (socialProfile != null
								&& socialProfile.getUserInfo() != null) {

							Document doc = initDoc(socialProfile.getUserInfo());

							Element root = doc.getDocumentElement();

							String identificationType = getNode(root, doc,
									socialProfile, dynamicSectionName,
									"identification_type");
							String identificationNumber = getNode(root, doc,
									socialProfile, dynamicSectionName,
									"identification_number");
							String contactNumber = getNode(root, doc,
									socialProfile, dynamicSectionName,
									"mobile_number");

							if (Validator.isNull(rsvpPayment.getTicketNumber())) {
								RsvpTicket spRsvpTicket = RsvpTicketLocalServiceUtil
										.getRsvpTicket(spRsvpTicketId);
								rsvpPayment.setTicketNumber(ticket
										.getTicketNumber(spRsvpTicket));
								RsvpDetailLocalServiceUtil
										.updateRsvpDetail(rsvpDetail);
								fileList = ticket.generatePdfTicket(
										rsvpPayment, rsvpDetail, spRsvpTicket,
										identificationType,
										identificationNumber, contactNumber);
							}
						}
					}

					if (!rsvpPayment.isEmailStatus()) {
						String messageId = SPMailLocalServiceUtil.sendMail(
								campaign, subscriber, fileList,
								rsvpPayment.getGroupId(), rsvp.getCcEmail());
						if (Validator.isNotNull(messageId)) {
							rsvpPayment.setEmailStatus(true);
						}
					}

				}

				RsvpPaymentLocalServiceUtil.updateRsvpPayment(rsvpPayment);

			} catch (NumberFormatException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			}

		} else if (res.equals("INVALID")) {
			_log.error("Paypal transaction returns INVALID");
		} else {
			_log.error("Paypal transaction unsuccessful!");
		}

	}

	private String getNode(Element root, Document doc,
			SocialProfile socialProfile, String categoryName, String nodeName) {

		// fieldValue = manipulator.findValue("//" + fieldName);
		NodeList nodes = findNodeList(root, doc, "//other_details/"
				+ categoryName + "/" + categoryName + "_details");

		// NodeList nodeList = document.getElementsByTagName(categoryName +
		// "_details");

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = (Node) nodes.item(i);
			if (node.hasChildNodes()) {
				NodeList nodeListRSVP = node.getChildNodes();

				int totalCount = 0;
				while (totalCount < nodeListRSVP.getLength()) {
					Node nodeRSVP = (Node) nodeListRSVP.item(totalCount);
					if (nodeRSVP.getNodeName().contains(nodeName)) {
						return nodeRSVP.getTextContent();
					}

					totalCount++;
				}
			}
		}

		return StringPool.BLANK;
	}

	public NodeList findNodeList(Element root, Document doc, String xpath) {
		NodeList nodes = null;
		try {
			doc = root.getOwnerDocument();
			doc.normalizeDocument();
			nodes = XPathAPI.selectNodeList(root, xpath);
		} catch (TransformerException e) {
			_log.debug(e.getMessage(), e);
		} catch (Exception e) {
			_log.debug(e.getMessage(), e);
		}
		return nodes;
	}

	private Document initDoc(String xmlString) {

		Document doc = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(new InputSource(new StringReader(xmlString)));
			doc.normalizeDocument();
		} catch (Exception e) {
			_log.debug(e.getMessage());
		}
		return doc;

	}

	private static Log _log = LogFactoryUtil
			.getLog(PaymentNotificationServlet.class);

}
