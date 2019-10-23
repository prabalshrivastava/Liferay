package com.sambaash.platform.finance.ajax;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.liferay.mail.model.FileAttachment;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

public class SendNotificationActionHandler implements ServeResourceActionHandler {
	private Log log = LogFactoryUtil.getLog(SendNotificationActionHandler.class.getName());

	private static final String CONTENT_JSON = "contentJson";
	private static final String STORAGE_ID = "storageId";
	private static final String TRANSACTION_CODE = "[$TRANSACTION_CODE$]";
	private static final String NAME = "[$NAME$]";
	private static final String FULLNAME = "[$TO_FULL_NAME$]";
	private static final String USERFULLNAME = "[$USER_FULL_NAME$]";
	private static final String ATONAME = "[$ATO_NAME$]";
	private static final String FEETYPE = "[$FEE_TYPE$]";
	private static final String PDF_LOCATION = "pdfLocation";
	private static final String COMPONENT_REF_NUMBER = "ComponentRefNumber";
	private static final String EXTERNAL_REF_NUMBER = "ExtRefNumber";
	private static final String TRANSACTION_MASTER_CODE = "TransactionMasterCode";
	private static final String USER_ID = "userId";

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String output;
		// get credit details by storage id
		output = SPFinanceLocalServiceUtil.fetchRecord(request, response);
		try {
			long cuserId = PortalUtil.getUserId(request);
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject(output);
			log.error("jsonObj : " + jsonObj.toString());
			String data = request.getParameter("data");
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(data);
			String pdfLocation = jsonObject.getString(PDF_LOCATION);
			long userId;
			if (jsonObject.has("payonline")) {
				log.info("payonline id : ");
				sendEmailTOEBSAC(jsonObject, request, response);
			} else if (jsonObject.has("individual")) {
				JSONObject contentJson = jsonObj.getJSONObject(CONTENT_JSON);
				userId = Long.valueOf("" + contentJson.getLong("NameOfPayer"));
				User user = UserLocalServiceUtil.getUserById(userId);
				
				sendEmailIndividual(user, cuserId, jsonObj, new File(pdfLocation));
			} else if (jsonObject.has("corporate")) {
				JSONObject contentJson = jsonObj.getJSONObject(CONTENT_JSON);
				Long orgId = Long.valueOf("" + contentJson.getLong("NameOfPayer"));
				Organization organization = OrganizationLocalServiceUtil.fetchOrganization(orgId);
				sendEmailCorporate(organization, cuserId, jsonObj, new File(pdfLocation));
				response.getWriter().write(output);
				return;
			} else {
				userId = Long.valueOf(jsonObj.getString(USER_ID));
				User user = UserLocalServiceUtil.getUserById(userId);
				if (pdfLocation == "") {
					sendEmail(user, jsonObj, null);
				} else {
					sendEmail(user, jsonObj, new File(pdfLocation));
				}
			}

			response.getWriter().write(output);
		} catch (IOException | PortalException | SystemException e) {
			log.error(e);
		}
	}

	private void sendEmailTOEBSAC(JSONObject jsonObject, ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			log.info("jsonObject : " + jsonObject.toString());
			String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_NAME);
			log.info(":fromName : " + fromName);
			String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			log.info(":fromAddress : " + fromAddress);
			MailMessage mailMessage = new MailMessage();
			SPMailTemplate mailTemplate = SPMailTemplateLocalServiceUtil
					.getTemplateByName("Online Payment Notification To EB SAC Request Officer");
			log.info("mailTemplate : " + mailTemplate.getSubject());
			String subject = mailTemplate.getSubject();
			String body = mailTemplate.getHtmlContent();
			String toAddresses = jsonObject.getString("emailAddresses");
			String loggedInEmail = jsonObject.getString("loggedInEmail");
			String[] invoiceIds = jsonObject.getString("formStorageId").split(",");
			JSONArray receipts = jsonObject.getJSONArray("receipts");
			mailMessage.setSubject(subject);
			mailMessage.setFromAddress(fromAddress);
			mailMessage.setFromName(fromName);
			mailMessage.setMultiPart(true);
			
			List<String> filePaths = new ArrayList<>();
			Map<String, JSONArray> emailReceipts = new HashMap();
			for (int i = 0; i < receipts.length(); i++) {
				JSONObject receipt = receipts.getJSONObject(i);
				String storageId = receipt.getString(TRANSACTION_MASTER_CODE);
				JSONObject pdfData = JSONFactoryUtil.createJSONObject();
				JSONObject dataJson = JSONFactoryUtil.createJSONObject();
				dataJson.put("docType", "OFFICIAL RECEIPT");
				JSONArray docInfoValues = JSONFactoryUtil.createJSONArray();
				docInfoValues.put("");
				docInfoValues.put("");
				dataJson.put("docInfoValues", docInfoValues);
				
				JSONObject detail = receipt.getJSONArray("TransactionDetails").getJSONObject(0);
				String currentEmail = "";
				String currentName = "";
				if(detail.has(USER_ID) && !StringUtils.isEmpty(detail.getString(USER_ID))) {
					String userId = detail.getString(USER_ID);
					User user = UserLocalServiceUtil.getUser(Long.parseLong(userId));
					currentEmail = user.getEmailAddress();
					currentName = user.getFullName();
				} else {
					String organisationId = detail.getString("organisationId");
					Organization organization = OrganizationLocalServiceUtil
							.getOrganization(Long.parseLong(organisationId));
					currentEmail = organization.getEmailId();
					currentName = organization.getName();
					JSONArray custDetails = JSONFactoryUtil.createJSONArray();
					custDetails.put(organization.getName());
					dataJson.put("custDetails", custDetails);
				}
				JSONArray currentReceipts = emailReceipts.get(currentEmail);
				if(currentReceipts == null) {
					currentReceipts = JSONFactoryUtil.createJSONArray();
				}
				receipt.put("FullName", currentName);
				currentReceipts.put(receipt);
				emailReceipts.put(currentEmail, currentReceipts);

				pdfData.put("data", dataJson);
				pdfData.put(STORAGE_ID, storageId);
				String pdfLoc = SPFinanceLocalServiceUtil.preparePdf(resourceRequest, resourceResponse,
						pdfData.toString());
				filePaths.add(pdfLoc);
				receipt.put(PDF_LOCATION, pdfLoc);
			}
			sendEmailToLoggedInUser(mailMessage, receipts, body, jsonObject, subject, themeDisplay);
			sendEmailToOfficers(mailMessage, receipts, toAddresses, body);
			sendEmailToCandidateOrganization(resourceRequest, invoiceIds, mailMessage, emailReceipts, body,
					loggedInEmail);
			sendEmailToAtos(resourceRequest, invoiceIds, receipts, mailMessage);
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	private void sendEmailToLoggedInUser(MailMessage mailMessage, JSONArray receipts, String body,
			JSONObject jsonObject, String subject, ThemeDisplay themeDisplay) {
		String loggedInName = jsonObject.getString("loggedInName");
		String loggedInEmail = jsonObject.getString("loggedInEmail");
		String loggedInId = jsonObject.getString("loggedInId");
		List<FileAttachment> fileAttachments = populateFileAttachment(receipts);
		log.info("fileAttachments : " + receipts.length());
		if (!fileAttachments.isEmpty() && !StringUtils.isEmpty(loggedInEmail)) {
			log.info(":loggedInEmail : " + loggedInEmail);
			String newBody = String.valueOf(body);
			newBody = newBody.replace(NAME, loggedInName);
			newBody = newBody.replace(FULLNAME, loggedInName);
			mailMessage.setFileAttachments(fileAttachments);
			mailMessage.setToAddress(loggedInEmail);
			mailMessage.setHtmlBody(newBody);
			SystemLocalServiceUtil.addTimelineActivity(
					"/online-payment?r=" + jsonObject.getString("tokenId") + "&id="
							+ jsonObject.getString("formStorageId"),
					"Details", subject, StringPool.BLANK, StringPool.BLANK, "Completed", Long.parseLong(loggedInId),
					"Receipt", "Payment", StringPool.BLANK, StringPool.BLANK, "" + loggedInId, themeDisplay.getScopeGroupId());
			SPMailLocalServiceUtil.sendMail(mailMessage);
		}
	}
	
	private void sendEmailToOfficers(MailMessage mailMessage, JSONArray receipts, String toAddresses, String body) {
		List<FileAttachment> fileAttachments = populateFileAttachment(receipts);
		log.info("fileAttachments : " + receipts.length());
		if (!fileAttachments.isEmpty()) {
			String[] toAddressArray = toAddresses.split(",");
			for (String toMailAddr : toAddressArray) {
				if (!StringUtils.isEmpty(toMailAddr)) {
					log.info(":toMailAddr : " + toMailAddr);
					String newBody = String.valueOf(body);
					newBody = newBody.replace(NAME, "EB SAC Request Officer");
					newBody = newBody.replace(FULLNAME, "EB SAC Request Officer");
					mailMessage.setFileAttachments(fileAttachments);
					mailMessage.setToAddress(toMailAddr);
					mailMessage.setHtmlBody(newBody);
					SPMailLocalServiceUtil.sendMail(mailMessage);
				}
			}
		}
	}

	private void sendEmailToCandidateOrganization(ResourceRequest resourceRequest, String[] invoiceIds,
			MailMessage mailMessage, Map<String, JSONArray> emailReceipts, String body, String loggedInEmail) {
		String atoAdmissions = getAtoAdmissions(resourceRequest, invoiceIds);
		try {
			Map<String, JSONObject> admissionMap = new HashMap<>();
			try {
				JSONObject admissions = JSONFactoryUtil.createJSONObject(atoAdmissions);
				JSONArray admissionArray = admissions.getJSONArray("content");
				for (int i = 0; i < admissionArray.length(); i++) {
					JSONObject admission = admissionArray.getJSONObject(i);
					admissionMap.put(admission.getJSONObject(CONTENT_JSON).getString("InvoiceId"), admission);
				}
			} catch (Exception e) {
				log.error(e);
			}
			SPMailTemplate mailTemplate = SPMailTemplateLocalServiceUtil.getTemplateByName(
					"ATO Invoicing Billing - Notification to Candidate after ATO Successfully Made Payment");
			String candMailBody = mailTemplate.getHtmlContent();
			String newBody = body;
			for (Map.Entry<String, JSONArray> entry : emailReceipts.entrySet()) {
				if (entry.getKey().equals(loggedInEmail)) {
					continue;
				}
				JSONArray currReceipts = entry.getValue();
				List<FileAttachment> currAttachments = populateFileAttachment(currReceipts);
				log.info("currAttachments : " + currReceipts.length());
				if (!currAttachments.isEmpty()) {
					log.info(":userEmail : " + entry.getKey());
					JSONObject currReceipt = currReceipts.getJSONObject(0);
					String name = currReceipt.getString("FullName");
					JSONArray receiptTransDetails = currReceipt.getJSONArray("TransactionDetails");
					String amountType = receiptTransDetails.getJSONObject(0).getString("amountType");
					JSONObject admissionObj = admissionMap.get(currReceipt.getString(COMPONENT_REF_NUMBER));
					String atoName = "";
					if (admissionObj != null) {
						atoName = admissionObj.getJSONObject(CONTENT_JSON).getString("AtoName");
					}
					if (!StringUtils.isEmpty(atoName)) {
						newBody = candMailBody;
						newBody = newBody.replace(ATONAME, atoName);
						newBody = newBody.replace(FEETYPE, amountType);
					}
					newBody = newBody.replace(NAME, name);
					newBody = newBody.replace(USERFULLNAME, name);
					mailMessage.setFileAttachments(currAttachments);
					mailMessage.setToAddress(entry.getKey());
					mailMessage.setHtmlBody(newBody);
					SPMailLocalServiceUtil.sendMail(mailMessage);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	private List<String> sendEmailToAtos(ResourceRequest resourceRequest, String[] invoiceIds, JSONArray receipts,
			MailMessage mailMessage) {
		String atoAdmissions = getAtoAdmissions(resourceRequest, invoiceIds);
		List<String> toAddresses = new ArrayList<>();
		try {
			JSONObject admissions = JSONFactoryUtil.createJSONObject(atoAdmissions);
			JSONArray admissionArray = admissions.getJSONArray("content");
			log.info("admissionArray : " + admissionArray.toString());

			SPMailTemplate mailTemplate = SPMailTemplateLocalServiceUtil
					.getTemplateByName("ATO Invoicing Billing - Notification to Officer for Successful Payment");
			String emailBody = mailTemplate.getHtmlContent();
			for (int admi = 0; admi < admissionArray.length(); admi++) {
				JSONObject admission = admissionArray.getJSONObject(admi);
				log.info("admission : " + admission.toString());
				String atoEmail = admission.getJSONObject(CONTENT_JSON).getString("AtoEmailId");
				String atoName = admission.getJSONObject(CONTENT_JSON).getString("AtoName");
				JSONArray atoReceipts = getReceiptsForAto(admission.getJSONObject(CONTENT_JSON).getString("InvoiceId"),
						receipts);
				JSONObject atoRec = receipts.getJSONObject(admi);
				String name = atoRec.getString("FullName");
				JSONArray atoRecArray = atoRec.getJSONArray("TransactionDetails");
				String amountType = atoRecArray.getJSONObject(0).getString("amountType");
				List<FileAttachment> fileAttachments = populateFileAttachment(atoReceipts);
				if (!fileAttachments.isEmpty()) {
					String newBody = emailBody;
					newBody = newBody.replace(ATONAME, atoName);
					newBody = newBody.replace(FEETYPE, amountType);
					newBody = newBody.replace(NAME, atoName);
					newBody = newBody.replace(USERFULLNAME, name);
					mailMessage.setFileAttachments(fileAttachments);
					mailMessage.setToAddress(atoEmail);
					mailMessage.setHtmlBody(newBody);
					SPMailLocalServiceUtil.sendMail(mailMessage);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return toAddresses;
	}

	private JSONArray getReceiptsForAto(String invoiceId, JSONArray receipts) {
		JSONArray atoReceipts = JSONFactoryUtil.createJSONArray();
		for (int i = 0; i < receipts.length(); i++) {
			try {
				JSONObject receiptJson = receipts.getJSONObject(i);
				if (receiptJson.has(COMPONENT_REF_NUMBER)) {
					List<String> refs = Arrays.asList(receiptJson.getString(COMPONENT_REF_NUMBER).split(","));
					if (refs.contains(invoiceId)) {
						atoReceipts.put(receiptJson);
					}
				}
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		return atoReceipts;
	}

	private List<FileAttachment> populateFileAttachment(JSONArray receipts) {
		List<FileAttachment> fileAttachments = new ArrayList<>();
		try {
			log.info("receipts : "+receipts);
			if (receipts.length() == 1) {
				File file = new File(receipts.getJSONObject(0).getString(PDF_LOCATION));
				fileAttachments.add(new FileAttachment(file,
						receipts.getJSONObject(0).getString(EXTERNAL_REF_NUMBER).replace("/", "") + ".pdf"));

			} else {
				File zipFile = new File("receipts.zip");
				FileUtils.writeByteArrayToFile(zipFile, getZipFile(receipts).toByteArray());
				fileAttachments.add(new FileAttachment(zipFile, "receipts.zip"));
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return fileAttachments;
	}

	public ByteArrayOutputStream getZipFile(JSONArray receipts) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(baos);
		byte[] bytes = new byte[2048];
		for (int i = 0; i < receipts.length(); i++) {
			JSONObject receipt = receipts.getJSONObject(i);
			String filePath = receipt.getString(PDF_LOCATION);
			String fileName = receipt.getString(EXTERNAL_REF_NUMBER);
			log.info("filePath : " + filePath);
			FileInputStream fis = new FileInputStream(filePath);
			BufferedInputStream bis = new BufferedInputStream(fis);
			zos.putNextEntry(new ZipEntry(fileName.replace("/", "") + ".pdf"));
			int bytesRead;
			while ((bytesRead = bis.read(bytes)) != -1) {
				zos.write(bytes, 0, bytesRead);
			}
			bis.close();
			fis.close();
		}
		zos.closeEntry();
		zos.flush();
		baos.flush();
		zos.close();
		baos.close();
		return baos;
	}
	
	private String getAtoAdmissions(ResourceRequest request, String[] storageIds) {
		return SPFinanceLocalServiceUtil.searchAdmissionRecords(request, storageIds);
	}
	
	private void sendEmail(User user, JSONObject jsonObj, File file) {
		try {
			log.info(jsonObj.toString());
			JSONObject contentJson = jsonObj.getJSONObject(CONTENT_JSON);
			log.info("credit balance data : " + contentJson);
			String dateStr = jsonObj.getString("createdDate");
			String year = dateStr.substring(0, 4);
			String utilisationPurpose = contentJson.getString("Type");
			log.info("utilisationPurpose : " + utilisationPurpose);
			Double amtToProcess = contentJson.getDouble("Amount");
			log.info("amtToProcess : " + amtToProcess);
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(user.getGroupId());
			String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_NAME);
			String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			log.info(fromName);
			log.info(fromAddress);
			String subject = null;
			String body = null;
			MailMessage mailMessage = new MailMessage();
			if (utilisationPurpose.equals("Refund")) {
				subject = "Refund Advice";
				body = "<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">Dear $CandidateName$,</span></span></span></p>\r\n<p class=\"western\" lang=\"en-US\">&nbsp;</p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">Your refund request has been approved, please find the refund advice attached to this email.</span></span></span></p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"color: #000000;\">&nbsp;</span></p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">Please do not hesitate to contact us at&nbsp;</span></span><span style=\"color: #0563c1;\"><u><a href=\"mailto:uol@relc.org.sg\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">uol@relc.org.sg</span></span></a></u></span><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">&nbsp;if you have any query.</span></span></span></p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"color: #000000;\">&nbsp;</span></p>\r\n<p class=\"western\" lang=\"en-GB\">&nbsp;</p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">Yours sincerely,</span></span></span></p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">RELC Examinations Bureau</span></span></span></p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #0563c1;\"><u><a href=\"http://www.relc.org.sg/uol\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #1155cc;\"><span style=\"font-family: Arial, serif;\">www.relc.org.sg/uol</span></span></a></u></span><span style=\"color: #0000cc;\"><span style=\"font-family: Arial, serif;\">&nbsp;&nbsp;</span></span></span></p>";
			} else {
				subject = "Confirmation";
				body = "<p class=\"western\" lang=\"en-GB\">Dear $CandidateName$,</p>\r\n<p class=\"western\" lang=\"en-US\">&nbsp;</p>\r\n<p class=\"western\" lang=\"en-GB\">There has been an overpayment for your $Year$ UOL Exam Registration Fee. &nbsp;Please be advised that a $20 Administrative Fee is applicable for a refund of any overpayment. &nbsp;As your overpayment of $$AmtToProcess$ for the $Year$ UOL Exam Registration is less than the refund Administrative Fee, this email serves as an official confirmation that you would like to forfeit the overpayment of $$AmtToProcess$.</p>\r\n<p class=\"western\" lang=\"en-GB\">&nbsp;</p>\r\n<p class=\"western\" lang=\"en-GB\">Thank you for your understanding. We wish you every success for your examination. Please do not hesitate to contact us at&nbsp;<u><a href=\"mailto:uol@relc.org.sg\" target=\"_blank\" rel=\"noopener\">uol@relc.org.sg</a></u>&nbsp;if you have further queries.</p>\r\n<p class=\"western\" lang=\"en-GB\">&nbsp;</p>\r\n<p class=\"western\" lang=\"en-GB\">Yours sincerely,</p>\r\n<p class=\"western\" lang=\"en-GB\">RELC Examinations Bureau</p>\r\n<p class=\"western\" lang=\"en-GB\"><u><a href=\"http://www.relc.org.sg/uol\" target=\"_blank\" rel=\"noopener\">www.relc.org.sg/uol</a></u>&nbsp;&nbsp;</p>";
			}
			String toName = user.getFullName();
			String toAddress = user.getEmailAddress();
			body = body.replace("$CandidateName$", toName);
			body = body.replace("$Year$", year);
			body = body.replaceAll("\\$AmtToProcess\\$", String.valueOf(amtToProcess));
			mailMessage.setSubject(subject);
			mailMessage.setFromAddress(fromAddress);
			mailMessage.setFromName(fromName);
			mailMessage.setToAddress(toAddress);
			mailMessage.setHtmlBody(body);
			if (Validator.isNotNull(file) && file.canRead()) {
				FileAttachment fileAttachment = new FileAttachment(file, "refund.pdf");
				List<FileAttachment> fileAttachments = new ArrayList<>();
				fileAttachments.add(fileAttachment);
				mailMessage.setFileAttachments(fileAttachments);
				mailMessage.setMultiPart(true);
			}
			SPMailLocalServiceUtil.sendMail(mailMessage);
		} catch (PortalException | SystemException e) {
			log.error(e);
		}
	}

	private void sendEmailIndividual(User user, long cuserId, JSONObject jsonObj, File file) {

		try {
			log.info(jsonObj.toString());
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(user.getGroupId());

			String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_NAME);

			String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			log.info(fromName);
			log.info(fromAddress);

			String subject = "Invoice Payment Due";
			String body = "<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\">"
					+ "<span style=\"font-family: Arial, serif;\">Dear "+NAME+",</span></span></span></p>\r\n"
					+ "<p class=\"western\" lang=\"en-US\">&nbsp;</p>\r\n<p class=\"western\" lang=\"en-GB\">"
					+ "<span style=\"font-size: small;\"><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">"
					+ "Please find the invoice attached to this email. <br /> "
					+ "<a href='/online-payment?id="+TRANSACTION_CODE+"' >Click here for online payment.</a> </span></span></span></p>\r\n"
					+ "<p class=\"western\" lang=\"en-GB\"><span style=\"color: #000000;\">&nbsp;</span></p>\r\n"
					+ "<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\">"
					+ "<span style=\"font-family: Arial, serif;\">Please do not hesitate to contact us at&nbsp;</span></span>"
					+ "<span style=\"color: #0563c1;\"><u><a href=\"mailto:uol@relc.org.sg\" target=\"_blank\" rel=\"noopener\">"
					+ "<span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">uol@relc.org.sg</span></span></a></u></span>"
					+ "<span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">&nbsp;if you have any query.</span></span></span></p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"color: #000000;\">&nbsp;</span></p>\r\n<p class=\"western\" lang=\"en-GB\">&nbsp;</p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">Yours sincerely,</span></span></span></p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">RELC Examinations Bureau</span></span></span></p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #0563c1;\"><u><a href=\"http://www.relc.org.sg/uol\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #1155cc;\"><span style=\"font-family: Arial, serif;\">www.relc.org.sg/uol</span></span></a></u></span><span style=\"color: #0000cc;\"><span style=\"font-family: Arial, serif;\">&nbsp;&nbsp;</span></span></span></p>";

			MailMessage mailMessage = new MailMessage();

			SPMailTemplate mailTemplate = SPMailTemplateLocalServiceUtil
					.getTemplateByName("Individual Invoice Payment Due Notification");

			if (mailTemplate != null) {
				subject = mailTemplate.getSubject();
				body = mailTemplate.getHtmlContent();
			}

			ThemeDisplay td = new ThemeDisplay();
			SystemLocalServiceUtil.addTimelineActivity(
					"/online-payment?id=" + jsonObj.getString(STORAGE_ID), "Pay Now",
					subject, StringPool.BLANK, StringPool.BLANK, "Pending Payment", cuserId, "Invoice",
					"Payment", StringPool.BLANK, StringPool.BLANK, "" + user.getUserId(), td.getScopeGroupId());


			String toName = user.getFullName();
			String toAddress = user.getEmailAddress();
			body = body.replace(NAME, toName);
			body = body.replace(TRANSACTION_CODE, jsonObj.getString(STORAGE_ID));
			mailMessage.setSubject(subject);
			mailMessage.setFromAddress(fromAddress);
			mailMessage.setFromName(fromName);
			mailMessage.setToAddress(toAddress);
			mailMessage.setHtmlBody(body);

			if (Validator.isNotNull(file) && file.canRead()) {
				FileAttachment fileAttachment = new FileAttachment(file, "invoice.pdf");
				List<FileAttachment> fileAttachments = new ArrayList<>();
				fileAttachments.add(fileAttachment);
				mailMessage.setFileAttachments(fileAttachments);
				mailMessage.setMultiPart(true);
			}
			SPMailLocalServiceUtil.sendMail(mailMessage);
		} catch (PortalException | SystemException e) {
			log.info("error" + e.toString());
		}
	}

	private void sendEmailCorporate(Organization organization, long cuserId, JSONObject jsonObj, File file) {

		try {
			log.info(jsonObj.toString());
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(organization.getGroupId());

			String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_NAME);

			String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			log.info(fromName);
			log.info(fromAddress);

			String subject = "Invoice Payment Due";

			String body = "<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\">"
					+ "<span style=\"font-family: Arial, serif;\">Dear "+NAME+",</span></span></span></p>\r\n"
					+ "<p class=\"western\" lang=\"en-US\">&nbsp;</p>\r\n<p class=\"western\" lang=\"en-GB\">"
					+ "<span style=\"font-size: small;\"><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">"
					+ "Please find the invoice attached to this email. <br /> "
					+ "<a href='/online-payment?id="+TRANSACTION_CODE+"' >Click here for online payment.</a> </span></span></span></p>\r\n"
					+ "<p class=\"western\" lang=\"en-GB\"><span style=\"color: #000000;\">&nbsp;</span></p>\r\n"
					+ "<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\">"
					+ "<span style=\"font-family: Arial, serif;\">Please do not hesitate to contact us at&nbsp;</span></span>"
					+ "<span style=\"color: #0563c1;\"><u><a href=\"mailto:uol@relc.org.sg\" target=\"_blank\" rel=\"noopener\">"
					+ "<span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">uol@relc.org.sg</span></span></a></u></span>"
					+ "<span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">&nbsp;if you have any query.</span></span></span></p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"color: #000000;\">&nbsp;</span></p>\r\n<p class=\"western\" lang=\"en-GB\">&nbsp;</p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">Yours sincerely,</span></span></span></p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #000000;\"><span style=\"font-family: Arial, serif;\">RELC Examinations Bureau</span></span></span></p>\r\n<p class=\"western\" lang=\"en-GB\"><span style=\"font-size: small;\"><span style=\"color: #0563c1;\"><u><a href=\"http://www.relc.org.sg/uol\" target=\"_blank\" rel=\"noopener\"><span style=\"color: #1155cc;\"><span style=\"font-family: Arial, serif;\">www.relc.org.sg/uol</span></span></a></u></span><span style=\"color: #0000cc;\"><span style=\"font-family: Arial, serif;\">&nbsp;&nbsp;</span></span></span></p>";

			MailMessage mailMessage = new MailMessage();

			SPMailTemplate mailTemplate = SPMailTemplateLocalServiceUtil
					.getTemplateByName("Corporate Invoice Payment Due Notification");

			if (mailTemplate != null) {
				subject = mailTemplate.getSubject();
				body = mailTemplate.getHtmlContent();
			}
			
			ThemeDisplay td = new ThemeDisplay();
			SystemLocalServiceUtil.addTimelineActivity(
					"/online-payment?id=" + jsonObj.getString(STORAGE_ID), "Pay Now",
					subject, StringPool.BLANK, StringPool.BLANK, "Pending Payment", cuserId, "Invoice",
					"Payment", StringPool.BLANK, StringPool.BLANK, "" + organization.getUserId(), td.getScopeGroupId());


			String toName = organization.getName();
			String toAddress = organization.getEmailId();
			body = body.replace(NAME, toName);
			body = body.replace(TRANSACTION_CODE, jsonObj.getString(STORAGE_ID));
			mailMessage.setSubject(subject);
			mailMessage.setFromAddress(fromAddress);
			mailMessage.setFromName(fromName);
			mailMessage.setToAddress(toAddress);
			mailMessage.setHtmlBody(body);

			if (Validator.isNotNull(file) && file.canRead()) {
				FileAttachment fileAttachment = new FileAttachment(file, "invoice.pdf");
				List<FileAttachment> fileAttachments = new ArrayList<>();
				fileAttachments.add(fileAttachment);
				mailMessage.setFileAttachments(fileAttachments);
				mailMessage.setMultiPart(true);
			}
			SPMailLocalServiceUtil.sendMail(mailMessage);
		} catch (SystemException e) {
			log.info("error" + e.toString());
		}
	}
}
