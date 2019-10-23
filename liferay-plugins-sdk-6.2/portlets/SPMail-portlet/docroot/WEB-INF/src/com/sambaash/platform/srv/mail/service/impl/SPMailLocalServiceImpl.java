/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.mail.service.impl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.RawMessage;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;
import com.amazonaws.services.simpleemail.model.SendRawEmailResult;

import com.google.common.util.concurrent.RateLimiter;

import com.liferay.mail.model.FileAttachment;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.constant.SambaashConstants.SPMAIL;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.model.SPMailStatus;
import com.sambaash.platform.model.SPMailType;
import com.sambaash.platform.srv.mail.NoSuchCampaignException;
import com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.model.SPMailLinkTracking;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.base.SPMailLocalServiceBaseImpl;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil;
import com.sambaash.platform.util.DesEncrypter;
import com.sambaash.platform.util.SambaashUtil;

import java.io.ByteArrayOutputStream;

import java.nio.ByteBuffer;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * The implementation of the s p mail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.mail.service.SPMailLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author sambaash
 * @see com.sambaash.platform.srv.mail.service.base.SPMailLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil
 */
public class SPMailLocalServiceImpl extends SPMailLocalServiceBaseImpl {
	public String appendTracker(String content) {

		if (Validator.isNotNull(content) && content.indexOf("</html>") != -1) {
			String[] tempContent = StringUtil.split(content, "</html>");

			return tempContent[0] + "<img src=\""
					+ SambaashUtil.getPortalURL(PortalUtil.getDefaultCompanyId(),
							Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID))
					+ "/spmail/[$SUBSCRIBER_ID$]\" width=\"1\" height=\"1\" border=\"0\" alt=\"\" style=\"height:1px !important;width:1px !important;border-width:0 !important;margin-top:0 !important;margin-bottom:0 !important;margin-right:0 !important;margin-left:0 !important;padding-top:0 !important;padding-bottom:0 !important;padding-right:0 !important;padding-left:0 !important;outline-style:none;text-decoration:none;display:block;\"></body></html>";
		} else {
			return content + "<span><img src=\""
					+ SambaashUtil.getPortalURL(PortalUtil.getDefaultCompanyId(),
							Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID))
					+ "/spmail/[$SUBSCRIBER_ID$]" + "\" /> </span>";
		}
	}

	public String decryptLink(String link) {
		return DesEncrypter.getInstance().decrypt(link);
	}

	public String encryptLink(String link) {
		return DesEncrypter.getInstance().encrypt(link);
	}

	public String[] getLinksFromHtml(String content) {

		try {
			Parser parser = Parser.createParser(content, DEFAULTCHARSET);
			TagNameFilter filter = new TagNameFilter("a");
			NodeList nodeList = parser.parse(filter);
			String[] links = new String[nodeList.size()];

			for (int i = 0; i < nodeList.size(); i++) {
				Node node = nodeList.elementAt(i);
				links[i] = ((LinkTag) node).getAttribute("href");

				if (_log.isDebugEnabled()) {
					_log.debug("links[i] : " + links[i]);
				}
			}

			Set<String> set = new LinkedHashSet<String>(Arrays.asList(links));

			return set.toArray(new String[set.size()]);
		} catch (Exception e) {
			_log.error(e);
		}

		return null;
	}

	public String getMailBody(SPMailCampaign spMailCampaign, int spMailType) {
		try {
			switch (spMailType) {

			case (0):
				return spMailTemplateLocalService.getSPMailTemplate(spMailCampaign.getMainTempalteId())
						.getHtmlContent();

			case (1):
				return spMailTemplateLocalService.getSPMailTemplate(spMailCampaign.getRem1TempalteId())
						.getHtmlContent();

			case (2):
				return spMailTemplateLocalService.getSPMailTemplate(spMailCampaign.getRem2TempalteId())
						.getHtmlContent();

			case (3):
				return spMailTemplateLocalService.getSPMailTemplate(spMailCampaign.getRem3TempalteId())
						.getHtmlContent();

			case (4):
				return spMailTemplateLocalService.getSPMailTemplate(spMailCampaign.getThankyouTempalteId())
						.getHtmlContent();

			case (5):
				return spMailTemplateLocalService.getSPMailTemplate(spMailCampaign.getMissedyouTempalteId())
						.getHtmlContent();

			default:
				return StringPool.BLANK;
			}
		} catch (Exception e) {
		}

		return StringPool.BLANK;
	}

	public String getMailSubject(SPMailCampaign spMailCampaign, int spMailType) {

		try {
			switch (spMailType) {

			case (0):
				return spMailTemplateLocalService.getSPMailTemplate(spMailCampaign.getMainTempalteId()).getSubject();

			case (1):
				return spMailTemplateLocalService.getSPMailTemplate(spMailCampaign.getRem1TempalteId()).getSubject();

			case (2):
				return spMailTemplateLocalService.getSPMailTemplate(spMailCampaign.getRem2TempalteId()).getSubject();

			case (3):
				return spMailTemplateLocalService.getSPMailTemplate(spMailCampaign.getRem3TempalteId()).getSubject();

			case (4):
				return spMailTemplateLocalService.getSPMailTemplate(spMailCampaign.getThankyouTempalteId())
						.getSubject();

			case (5):
				return spMailTemplateLocalService.getSPMailTemplate(spMailCampaign.getThankyouTempalteId())
						.getSubject();

			default:
				return StringPool.BLANK;
			}
		} catch (Exception e) {
		}

		return StringPool.BLANK;
	}

	public String getProcessedContent(String content, SPMailCampaign campaign, long subscriberId, long edmId) {

		try {
			Document doc = Jsoup.parse(content, DEFAULTCHARSET);

			Elements links = doc.select("a");

			String portalUrl = SambaashUtil.getPortalURL(campaign.getCompanyId(), campaign.getGroupId());

			String mailUrl = portalUrl + SambaashConstants.SPMAIL.MAIL_PATH;

			String param = campaign.getSpMailCampaignId() + StringPool.FORWARD_SLASH + subscriberId
					+ StringPool.FORWARD_SLASH;

			for (Element element : links) {
				String link = element.attr("href");
				String label = element.ownText();

				if (Validator.isNull(label)) {
					Elements childElememts = element.children().select("img");

					for (Element childElememt : childElememts) {
						label = childElememt.attr("alt");

						if (Validator.isNotNull(label)) {
							break;
						}
					}
				}

				if (label.length() > 74) {
					label = label.substring(0, 74);
				}

				String encryptedLink = StringPool.BLANK;

				if (_log.isDebugEnabled()) {
					_log.debug("links[i] : " + link);
				}

				long spMailLinkTrackingId;
				try {
					spMailLinkTrackingId = counterLocalService.increment("SPMailLinkTracking.class");

					String trackingUrl = param + spMailLinkTrackingId;

					encryptedLink = mailUrl + DesEncrypter.getInstance().encrypt(trackingUrl);

					// if (_log.isDebugEnabled()) {
					_log.debug(" \n link : " + link + "  \n encryptedLinks : " + encryptedLink + " \n decryptedLink : "
							+ DesEncrypter.getInstance().decrypt(encryptedLink));
					// }

					SPMailLinkTracking spMailLinkTracking = spMailLinkTrackingLocalService
							.createSPMailLinkTracking(spMailLinkTrackingId);
					spMailLinkTracking.setLabel(label);
					spMailLinkTracking.setLink(link);
					spMailLinkTracking.setSpMailCampaignId(campaign.getSpMailCampaignId());
					spMailLinkTracking.setSpMailCampaignEDMId(edmId);
					spMailLinkTracking.setSpMailCampaignSubscribersId(subscriberId);
					spMailLinkTracking.setEncryptedlink(encryptedLink);
					spMailLinkTracking.setCreateDate(DateUtil.newDate());
					spMailLinkTrackingLocalService.updateSPMailLinkTracking(spMailLinkTracking);

				} catch (SystemException e) {
					_log.error(e);
				}

				element.attr("href", encryptedLink);
			}

			content = doc.html();

		} catch (Exception e) {
			_log.error(e);
		}

		if (_log.isDebugEnabled()) {
			_log.debug("content : " + content);
		}

		return content;
	}

	public String getWebversion(SPMailCampaign campaign, SPMailCampaignSubscribers subscriber) {
		try {
			String content = getMailBody(campaign, subscriber.getSpMailType());

			String subject = getMailSubject(campaign, subscriber.getSpMailType());

			String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_NAME);

			String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			content = processMailBodyParameters(subject, content, campaign.getRsvpId(), subscriber, fromName,
					fromAddress, true);

			List<SPMailLinkTracking> spMailLinkTrackingList = spMailLinkTrackingPersistence
					.findByCampaignIdAndSubscribersId(campaign.getSpMailCampaignId(),
							subscriber.getSpMailCampaignSubscribersId());

			Document doc = Jsoup.parse(content, DEFAULTCHARSET);

			Elements links = doc.select("a");

			for (Element element : links) {
				String link = element.attr("href");

				if (_log.isDebugEnabled()) {
					_log.debug("links[i] : " + link);
				}

				for (int i = 0; i < spMailLinkTrackingList.size(); i++) {
					SPMailLinkTracking spMailLinkTracking = spMailLinkTrackingList.get(i);

					if (spMailLinkTracking.getLink().equalsIgnoreCase(link)) {
						element.attr("href", spMailLinkTracking.getEncryptedlink());
						break;
					}
				}
			}

			return content = doc.html();

		} catch (Exception e) {
			_log.error(e);
		}

		return StringPool.BLANK;
	}

	public String processMailBodyParameters(String subject, String content, long rsvpId,
			SPMailCampaignSubscribers subscriber, String fromName, String fromAddress) {
		return processMailBodyParameters(subject, content, rsvpId, subscriber, fromName, fromAddress, false);
	}

	public String processMailBodyParameters(String subject, String content, long rsvpId,
			SPMailCampaignSubscribers subscriber, String fromName, String fromAddress, boolean webVersion) {

		try {
			String portalUrl = SambaashUtil.getPortalURL(PortalUtil.getDefaultCompanyId(),
					Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));

			StringBuilder rsvpUrl = null;

			if (rsvpId > 0) {
				Rsvp rsvp = RsvpLocalServiceUtil.getRsvp(rsvpId);

				rsvpUrl = new StringBuilder().append(portalUrl).append(StringPool.FORWARD_SLASH)
						.append(rsvp.getRsvpUrl()).append("?transactionId=").append(subscriber.getUserId())
						.append(StringPool.AMPERSAND).append("rsvp=").append(rsvp.getRsvpId());
			}

			return StringUtil.replace(content,
					new String[] { "[$FROM_NAME$]", "[$FROM_ADDRESS$]", "[$TO_ADDRESS$]", "[$TO_FIRST_NAME$]",
							"[$TO_LAST_NAME$]", "[$PORTAL_URL$]", "[$RSVP_URL$]", "[$RSVP_STATUS_YES$]",
							"[$RSVP_STATUS_NO$]", "[$RSVP_STATUS_MAYBE$]", "[$UNSUBSCRIBE_URL$]", "[$WEBVERSION_URL$]",
							"[$WEBVERSION_LABEL$]", "[$SUBSCRIBER_ID$]", "[$SUBJECT$]", "[$FORWARD_TO_FRIEND_URL$]",
							"[$PREFERENCES_URL$]" },
					new String[] { fromName, fromAddress, HtmlUtil.escape(subscriber.getEmailAddress()),
							HtmlUtil.escape(subscriber.getFirstName()), HtmlUtil.escape(subscriber.getLastName()),
							portalUrl, Validator.isNotNull(rsvpUrl) ? rsvpUrl.toString() : StringPool.POUND,
							Validator.isNotNull(rsvpUrl)
									? rsvpUrl.append(StringPool.AMPERSAND).append("st=").toString() + "Y"
									: StringPool.POUND,
							Validator.isNotNull(rsvpUrl) ? rsvpUrl.toString() + "N" : StringPool.POUND,
							Validator.isNotNull(rsvpUrl) ? rsvpUrl.toString() + "M" : StringPool.POUND,
							portalUrl + StringPool.FORWARD_SLASH + SPMAIL.UNSUBSCRIBE_URL,
							webVersion ? "#" : portalUrl + StringPool.FORWARD_SLASH + SPMAIL.WEBVERSION_URL,
							webVersion ? StringPool.BLANK : "View Web Version",
							encryptLink(String.valueOf(subscriber.getSpMailCampaignSubscribersId())) + ".gif", subject,
							portalUrl + StringPool.FORWARD_SLASH + SPMAIL.FORWARD_TO_FRIEND_URL,
							portalUrl + StringPool.FORWARD_SLASH + SPMAIL.PREFERENCES_URL });

		} catch (Exception e) {
			_log.error(e);
		}

		return StringPool.BLANK;
	}

	public String sendMail(MailMessage mailMessage) {
		if(_log.isDebugEnabled()){
			_log.debug("send mail");
		}
		
		String toAddress = SambaashUtil.getParameter(SambaashConstants.REDIRECT_EMAIL_ADDRESS,
				SambaashConstants.DEFAULT_GROUP_ID_LONG);

		if (Validator.isNotNull(toAddress)) {
			if (_log.isDebugEnabled()) {
				_log.debug(String.format("Overriding the receiver address from %s to %s ", mailMessage.getToAddress(),
						toAddress));
			}
			
			mailMessage.setSubject("Redirected : " + mailMessage.getSubject());
			mailMessage.setBccAddress(StringPool.BLANK);
			mailMessage.setCcAddress(StringPool.BLANK);
			mailMessage.setToAddress(toAddress);
		}
		
		SendEmailResult result = null;
		SendRawEmailResult rawEmailResult = null;

		String accessKeyId = SambaashUtil.getParameter(SambaashConstants.AWS_SES_ACCESS_KEY_ID,
				Long.valueOf(SambaashConstants.DEFAULT_GROUP_ID));

		String secretKey = SambaashUtil.getParameter(SambaashConstants.AWS_SES_SECRET_KEY,
				Long.valueOf(SambaashConstants.DEFAULT_GROUP_ID));

		AWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretKey);
		RateLimiter rateLimiter = RateLimiter.create(5);

		int maxRetries = 5;
		while (maxRetries-- > 0) {
			try {
				rateLimiter.acquire();

				if (mailMessage.isMultiPart()) {
					try {
						Session s = Session.getInstance(new Properties(), null);
						MimeMessage msg = new MimeMessage(s);

						// Sender and recipient

						msg.setFrom(new InternetAddress(mailMessage.getFromAddress(), mailMessage.getFromName()));
						msg.setRecipient(javax.mail.Message.RecipientType.TO,
								new InternetAddress(mailMessage.getToAddress()));
						
						// BCC
						if (Validator.isNotNull(mailMessage.getBccAddress())
								&& !SambaashConstants.DEFAULT_EMAIL_COPY_ADDRESS
										.equalsIgnoreCase(mailMessage.getBccAddress())) {
							msg.setRecipients(javax.mail.Message.RecipientType.BCC,
									new Address[] { new InternetAddress(mailMessage.getBccAddress()),
											new InternetAddress(SambaashConstants.DEFAULT_EMAIL_COPY_ADDRESS) });
						} else if (Validator.isNotNull(mailMessage.getBccAddress())) {
							msg.setRecipients(javax.mail.Message.RecipientType.BCC,
									new Address[] { new InternetAddress(mailMessage.getBccAddress()) });
						} else {
							msg.setRecipients(javax.mail.Message.RecipientType.BCC, new Address[] {
									new InternetAddress(SambaashConstants.DEFAULT_EMAIL_COPY_ADDRESS) });
						}
						
						//CC
						if (Validator.isNotNull(mailMessage.getCcAddress())) {
							msg.setRecipients(javax.mail.Message.RecipientType.CC,
									new Address[] { new InternetAddress(mailMessage.getCcAddress()) });
						}
						

						// Subject

						msg.setSubject(mailMessage.getSubject());

						Multipart multipart = new MimeMultipart();
						BodyPart messageBodyPart = new MimeBodyPart();
						messageBodyPart.setContent(mailMessage.getHtmlBody(), "text/html");
						multipart.addBodyPart(messageBodyPart);
						_log.error("SPMailLocalService " + mailMessage.getHtmlBody());
						// Attachment part

						if (mailMessage.getFileAttachments() != null && mailMessage.getFileAttachments().size() > 0) {
							for (FileAttachment attachment : mailMessage.getFileAttachments()) {
								messageBodyPart = new MimeBodyPart();
								DataSource source = new ByteArrayDataSource(FileUtil.getBytes(attachment.getFile()),
										"application/pdf");
								messageBodyPart.setDataHandler(new DataHandler(source));
								messageBodyPart.setFileName(attachment.getFileName());
								multipart.addBodyPart(messageBodyPart);
							}
						}

						msg.setContent(multipart);
						_log.error("multipart " + multipart);
						// send message

						ByteArrayOutputStream out = new ByteArrayOutputStream();
						msg.writeTo(out);

						RawMessage rawMessage = new RawMessage();
						rawMessage.setData(ByteBuffer.wrap(out.toString().getBytes()));

						// Instantiate an Amazon SES client, which will make the
						// service call with the supplied AWS credentials.

						AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient(credentials);
						rawEmailResult = client.sendRawEmail(new SendRawEmailRequest().withRawMessage(rawMessage));

						if (_log.isDebugEnabled()) {
							_log.debug("Email sent " + rawEmailResult.getMessageId());
						}

					} catch (MessagingException e) {
						_log.error(e.getMessage());
					}

				} else {

					Destination destination = new Destination()
							.withToAddresses(new String[] { mailMessage.getToAddress() });

					if (Validator.isNotNull(mailMessage.getBccAddress())) {
						destination.withBccAddresses(new String[] { mailMessage.getBccAddress() });
					}
					
					if (Validator.isNotNull(mailMessage.getCcAddress())) {
						destination.withCcAddresses(new String[] { mailMessage.getCcAddress() });
					}


					Body body = new Body().withHtml(new Content().withData(mailMessage.getHtmlBody()));

					// Create a message with the specified subject and body.

					Message message = new Message().withSubject(new Content().withData(mailMessage.getSubject()))
							.withBody(body);

					// Assemble the email.

					SendEmailRequest request = new SendEmailRequest()
							.withSource(mailMessage.getFromName() + " <" + mailMessage.getFromAddress() + ">")
							.withDestination(destination).withMessage(message);

					// Instantiate an Amazon SES client, which will make the
					// service call with the supplied AWS credentials.

					AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient(credentials);

					result = client.sendEmail(request);

					if (_log.isDebugEnabled()) {
						_log.debug("Email sent " + result.getMessageId());
					}
				}

				break;
			} catch (AmazonServiceException e) {

				// retries only throttling errors

				if ("Throttling".equals(e.getErrorCode()) && "Maximum sending rate exceeded.".equals(e.getMessage())) {
					_log.error("Maximum send rate exceeded when sending email to " + mailMessage.getFromAddress() + ". "
							+ (maxRetries > 1 ? "Will retry." : "Will not retry."));
				} else {
					_log.error(mailMessage.getFromAddress() + " unable to send email to: " + mailMessage.getToAddress()
							+ ". " + e.toString());
					break;
				}
			} catch (Exception e) {
				_log.error("Unable to send email to: " + mailMessage.getToAddress() + ". " + e.toString());
				_log.error(e.getMessage());
				break;
			}
		}

		if (_log.isDebugEnabled()) {
			_log.error(mailMessage.toString());
		}

		if (mailMessage.isMultiPart()) {
			return Validator.isNotNull(rawEmailResult) && Validator.isNotNull(rawEmailResult.getMessageId())
					? rawEmailResult.getMessageId() : "Error";
		}

		return Validator.isNotNull(result) && Validator.isNotNull(result.getMessageId()) ? result.getMessageId()
				: "Error";
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil} to
	 * access the s p mail local service.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil} to
	 * access the s p mail local service.
	 */

	public String sendMail(SPMailCampaign campaign, SPMailCampaignSubscribers subscriber,
			List<FileAttachment> attachments, long scopeGroupId, boolean ccEmail) {

		try {
			SPMailTemplate template = spMailTemplateLocalService.getSPMailTemplate(campaign.getThankyouTempalteId());

			String content = appendTracker(template.getHtmlContent());

			String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_NAME);

			String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			String htmlContent = processMailBodyParameters(template.getSubject(), content, campaign.getRsvpId(),
					subscriber, fromName, fromAddress);

			MailMessage mailMessage = new MailMessage();
			mailMessage.setFromAddress(fromAddress);
			mailMessage.setFromName(fromName);
			mailMessage.setSubject(template.getSubject());
			mailMessage.setHtmlBody(getProcessedContent(htmlContent, campaign,
					subscriber.getSpMailCampaignSubscribersId(), subscriber.getSpMailType()));
			mailMessage.setToAddress(subscriber.getEmailAddress());

			if (ccEmail) {
				mailMessage.setBccAddress(SambaashConstants.DEFAULT_EMAIL_COPY_ADDRESS);
			}

			if (attachments != null) {
				mailMessage.setFileAttachments(attachments);
				mailMessage.setMultiPart(true);
			} else {
				mailMessage.setMultiPart(false);
			}

			if (_log.isDebugEnabled()) {
				_log.debug("Final html content : " + mailMessage.getHtmlBody());
			}

			String messageId = sendMail(mailMessage);
			subscriber.setMessageId(messageId);
			subscriber.setStatus(SPMailStatus.SENT.getStatus());
			spMailCampaignSubscribersLocalService.updateSPMailCampaignSubscribers(subscriber);
			return messageId;
		} catch (PortalException e) {
			_log.error(e);
		} catch (SystemException e) {
			_log.error(e);
		} catch (Exception e) {
			_log.error(e);
		}

		return null;
	}

	public void testTemplate(long templateId) {
		try {
			SPMailCampaign spMailCampaign = null;
			SPMailCampaignSubscribers spMailCamSub = null;
			try {
				spMailCampaign = spMailCampaignPersistence.findByCampaignName(TESTING_CAMPAIGN_NAME);
			} catch (NoSuchCampaignException e) {
				try {
					spMailCampaign = spMailCampaignLocalService
							.createSPMailCampaign(counterLocalService.increment("SPMailCampaign.class"));
					spMailCampaign.setCampaignName(TESTING_CAMPAIGN_NAME);
					spMailCampaign.setCategoryId(0);
					spMailCampaign.setCreateDate(DateUtil.newDate());
					spMailCampaign.setArchive(true);
					spMailCampaign.setCreateBy(0);
					spMailCampaignLocalService.updateSPMailCampaign(spMailCampaign);
				} catch (SystemException e1) {
					_log.error(e1);
				}

			} catch (SystemException e) {
				_log.error(e);
			}

			String emailAddress = SambaashUtil.getTestGroupEmail();

			if (Validator.isNotNull(emailAddress)) {
				try {
					spMailCamSub = spMailCampaignSubscribersLocalService.findByCampaignIdMailTypeAndEmailAddress(
							spMailCampaign.getSpMailCampaignId(), SPMailType.TEST.getCode(), emailAddress);
				} catch (NoSuchCampaignSubscribersException e) {

					long spMailCampaignSubscribersId = counterLocalService.increment("SPMailCampaignSubscribers.class");
					spMailCamSub = spMailCampaignSubscribersLocalService
							.createSPMailCampaignSubscribers(spMailCampaignSubscribersId);

					spMailCamSub.setSpMailCampaignId(spMailCampaign.getSpMailCampaignId());
					spMailCamSub.setCreateBy(0);
					spMailCamSub.setUserId(0);
					spMailCamSub.setCreateDate(DateUtil.newDate());
					spMailCamSub.setStatus(SPMailStatus.PROCESSING.getStatus());
					spMailCamSub.setFirstName("Test");
					spMailCamSub.setLastName("Email");
					spMailCamSub.setEmailAddress(emailAddress);
					spMailCamSub.setSpMailType(SPMailType.TEST.getCode());
					try {
						spMailCampaignSubscribersLocalService.updateSPMailCampaignSubscribers(spMailCamSub);
					} catch (SystemException e1) {
						_log.error("error adding subscriber : " + emailAddress);
					}
				} catch (SystemException e) {
					_log.error("Unknown error while adding subscriber : " + emailAddress);
				}

				SPMailTemplate template = spMailTemplateLocalService.getSPMailTemplate(templateId);

				String content = appendTracker(template.getHtmlContent());

				String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
						PropsKeys.ADMIN_EMAIL_FROM_NAME);

				String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
						PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

				String htmlContent = processMailBodyParameters(template.getSubject(), content, 0, spMailCamSub,
						fromName, fromAddress);

				MailMessage mailMessage = new MailMessage();
				mailMessage.setFromAddress(fromAddress);
				mailMessage.setFromName(fromName);
				mailMessage.setSubject(template.getSubject());
				mailMessage.setHtmlBody(getProcessedContentForTestMail(htmlContent,
						spMailCampaign.getSpMailCampaignId(), spMailCamSub.getSpMailCampaignSubscribersId()));
				mailMessage.setToAddress(spMailCamSub.getEmailAddress());

				String messageId = sendMail(mailMessage);
				spMailCamSub.setMessageId(messageId);
				spMailCamSub.setStatus(SPMailStatus.SENT.getStatus());
				spMailCampaignSubscribersLocalService.updateSPMailCampaignSubscribers(spMailCamSub);
			}
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private String getProcessedContentForTestMail(String content, long campaignId, long subscriberId) {
		try {
			Document doc = Jsoup.parse(content, DEFAULTCHARSET);
			Elements links = doc.select("a");
			String portalUrl = SambaashUtil.getPortalURL(PortalUtil.getDefaultCompanyId(),
					Long.parseLong(SambaashConstants.DEFAULT_GROUP_ID));
			String mailUrl = portalUrl + SambaashConstants.SPMAIL.MAIL_PATH;
			String param = campaignId + StringPool.FORWARD_SLASH + subscriberId + StringPool.FORWARD_SLASH;

			for (Element element : links) {
				String link = element.attr("href");
				String encryptedLink = StringPool.BLANK;
				long spMailLinkTrackingId;
				try {
					spMailLinkTrackingId = counterLocalService.increment("SPMailLinkTracking.class");
					String trackingUrl = param + spMailLinkTrackingId;

					if (link.startsWith(portalUrl)) {
						encryptedLink = mailUrl + DesEncrypter.getInstance()
								.encrypt(trackingUrl + StringPool.FORWARD_SLASH + (link.split(portalUrl).length > 1
										? link.split(portalUrl)[1] : StringPool.FORWARD_SLASH));
					} else if (link.startsWith(StringPool.FORWARD_SLASH)) {

						if (link.length() > 1) {
							encryptedLink = mailUrl
									+ DesEncrypter.getInstance().encrypt(trackingUrl + StringPool.FORWARD_SLASH + link);
						} else {
							encryptedLink = mailUrl + DesEncrypter.getInstance().encrypt(trackingUrl);
						}
					} else {
						encryptedLink = mailUrl
								+ DesEncrypter.getInstance().encrypt(trackingUrl + StringPool.FORWARD_SLASH + link);
					}
				} catch (SystemException e) {
					_log.error(e);
				}

				element.attr("href", encryptedLink);
			}

			content = doc.html();
		} catch (Exception e) {
			_log.error(e);
		}

		return content;
	}

	private static Log _log = LogFactoryUtil.getLog(SPMailLocalServiceImpl.class);

	private final static String DEFAULTCHARSET = "UTF-8";

	private final static String TESTING_CAMPAIGN_NAME = "Testing-Campaign";

}