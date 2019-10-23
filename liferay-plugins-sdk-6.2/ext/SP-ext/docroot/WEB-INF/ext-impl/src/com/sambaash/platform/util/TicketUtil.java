package com.sambaash.platform.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.BadSecurityHandlerException;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.model.FileAttachment;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.srv.rsvp.NoSuchRsvpCoParticipantDetailException;
import com.sambaash.platform.srv.rsvp.NoSuchRsvpException;
import com.sambaash.platform.srv.rsvp.NoSuchRsvpPaymentException;
import com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail;
import com.sambaash.platform.srv.rsvp.model.RsvpDetail;
import com.sambaash.platform.srv.rsvp.model.RsvpPayment;
import com.sambaash.platform.srv.rsvp.model.RsvpTicket;
import com.sambaash.platform.srv.rsvp.service.RsvpCoParticipantDetailLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpPaymentLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpTicketLocalServiceUtil;
import com.sambaash.platform.ticket.TicketSingleton;

public class TicketUtil {

	private static Log _log = LogFactoryUtil.getLog(TicketUtil.class);

	public List<FileAttachment> generatePdfTicket(RsvpPayment rsvpPayment, RsvpDetail rsvpDetail,
			RsvpTicket spRsvpTicket, String identificationType, String identificationNumber, String contactNumber) {

		DecimalFormat format = new DecimalFormat();
		String price = format.format(spRsvpTicket.getPrice());

		List<FileAttachment> fileList = new ArrayList<FileAttachment>();
		String name = rsvpDetail.getFirstName() + StringPool.BLANK + rsvpDetail.getLastName();
		fileList.add(getTicket(name, rsvpDetail.getEmailAddress(), rsvpPayment.getTicketNumber(), identificationType,
				identificationNumber, contactNumber, price, spRsvpTicket.getTicketTemplateUrl()));

		if (rsvpPayment.getNumberOfPeople() > 1) {
			List<RsvpCoParticipantDetail> coParticipantDetailList;

			int counter = 1;
			try {
				coParticipantDetailList = RsvpCoParticipantDetailLocalServiceUtil.findByRsvpDetailIdAndSPRsvpPaymentId(
						rsvpDetail.getRsvpDetailId(), rsvpPayment.getRsvpPaymentId());

				for (RsvpCoParticipantDetail rsvpCoParticipantDetail : coParticipantDetailList) {
					counter++;
					if (Validator.isNull(rsvpCoParticipantDetail.getTicketNumber())) {
						rsvpCoParticipantDetail.setTicketNumber(getTicketNumber(spRsvpTicket));
						String coparticipantName = StringPool.BLANK;
						if (Validator.isNull(rsvpCoParticipantDetail.getFirstName())
								|| Validator.isNull(rsvpCoParticipantDetail.getFirstName())) {
							coparticipantName = name;
							rsvpCoParticipantDetail.setFirstName(rsvpDetail.getFirstName());
							rsvpCoParticipantDetail.setLastName(rsvpDetail.getLastName());
						} else {
							coparticipantName = rsvpCoParticipantDetail.getFirstName() + StringPool.SPACE
									+ rsvpCoParticipantDetail.getLastName();
						}

						if (Validator.isNull(rsvpCoParticipantDetail.getNric())) {
							rsvpCoParticipantDetail.setNric(identificationNumber);
						}

						if (Validator.isNull(rsvpCoParticipantDetail.getEmailAddress())) {
							rsvpCoParticipantDetail.setEmailAddress(rsvpDetail.getEmailAddress());
						}

						fileList.add(getTicket(coparticipantName, rsvpCoParticipantDetail.getEmailAddress(),
								rsvpCoParticipantDetail.getTicketNumber(), StringPool.BLANK,
								rsvpCoParticipantDetail.getNric(), contactNumber, price,
								spRsvpTicket.getTicketTemplateUrl()));
						rsvpCoParticipantDetail.setTicketNumber(rsvpCoParticipantDetail.getTicketNumber());
						RsvpCoParticipantDetailLocalServiceUtil.updateRsvpCoParticipantDetail(rsvpCoParticipantDetail);
					}

				}

				while (counter < rsvpPayment.getNumberOfPeople()) {
					counter++;
					long coParticipantDetailId = CounterLocalServiceUtil.increment("RsvpCoParticipantDetail.class");
					RsvpCoParticipantDetail coParticipantDetail = RsvpCoParticipantDetailLocalServiceUtil
							.createRsvpCoParticipantDetail(coParticipantDetailId);
					coParticipantDetail.setFirstName(rsvpDetail.getFirstName());
					coParticipantDetail.setLastName(rsvpDetail.getLastName());
					coParticipantDetail.setEmailAddress(coParticipantDetail.getEmailAddress());
					coParticipantDetail.setNric(identificationNumber);
					coParticipantDetail.setTicketNumber(getTicketNumber(spRsvpTicket));
					coParticipantDetail.setRsvpPaymentId(rsvpPayment.getRsvpPaymentId());
					RsvpCoParticipantDetailLocalServiceUtil.updateRsvpCoParticipantDetail(coParticipantDetail);
					fileList.add(getTicket(name, coParticipantDetail.getEmailAddress(),
							coParticipantDetail.getTicketNumber(), identificationType, coParticipantDetail.getNric(),
							contactNumber, price, spRsvpTicket.getTicketTemplateUrl()));
				}

			} catch (NoSuchRsvpException e) {
				_log.error(e);
			} catch (SystemException e) {
				_log.error(e);
			} catch (PortalException e) {
				_log.error(e);
			}

		}

		return fileList;

	}

	private FileAttachment getTicket(String name, String emailAddress, String ticketNumber, String identificationType,
			String identificationNumber, String contactNumber, String price, String ticketTemplateUrl) {
		try {
			PDDocument pdDoc = PDDocument.load(new URL(ticketTemplateUrl));

			PDDocumentCatalog pdCatalog = pdDoc.getDocumentCatalog();
			PDAcroForm acroForm = pdCatalog.getAcroForm();

			@SuppressWarnings("unchecked")
			List<PDField> fields = acroForm.getFields();
			for (PDField field : fields) {

				if (field.getFullyQualifiedName().equals("Name")) {
					field.setValue(name);
				}

				if (field.getFullyQualifiedName().equals("Email")) {
					field.setValue(emailAddress);
				}

				if (field.getFullyQualifiedName().equals("TicketNumber")) {
					field.setValue(ticketNumber);
				}
				if (field.getFullyQualifiedName().equals("IdentificationType")) {
					field.setValue(identificationType);
				}
				if (field.getFullyQualifiedName().equals("IdentificationNumber")) {
					field.setValue(identificationNumber);
				}
				if (field.getFullyQualifiedName().equals("ContactNumber")) {
					field.setValue(contactNumber);
				}

				if (field.getFullyQualifiedName().equals("Price")) {
					field.setValue(price);
				}

				field.setReadonly(true);
			}

			COSDictionary acroFormDict = acroForm.getDictionary();
			COSArray cosFields = (COSArray) acroFormDict.getDictionaryObject("Fields");
			cosFields.clear();

			AccessPermission access = pdDoc.getCurrentAccessPermission();
			access.setCanAssembleDocument(false);
			access.setCanExtractContent(false);
			access.setCanModifyAnnotations(false);
			access.setCanFillInForm(false);
			access.setCanModify(false);
			access.setCanPrint(true);
			access.setReadOnly();
			StandardProtectionPolicy p = new StandardProtectionPolicy("", "", access);
			pdDoc.protect(p);

			String fileName = getFilePath(ticketNumber, "pdf");

			_log.error("PDF path :" + fileName);

			pdDoc.save(fileName);
			pdDoc.close();
			return new FileAttachment(new File(fileName), ticketNumber + ".pdf");
		} catch (MalformedURLException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
		} catch (COSVisitorException e) {
			_log.error(e);
		} catch (BadSecurityHandlerException e) {
			_log.error(e);
		} catch (Exception e) {
			_log.error(e);
		}

		return null;

	}

	public String getTicketNumber(RsvpTicket spRsvpTicket) throws PortalException, SystemException {

		int counter = TicketSingleton.getInstance(spRsvpTicket).getTicketCounter(spRsvpTicket);
		String ticketNumber = spRsvpTicket.getSequencePrefix() + String.format("%04d", counter)
				+ spRsvpTicket.getSequenceSuffix();
		try {
			RsvpPaymentLocalServiceUtil.findByTicketNumber(ticketNumber);
			return getTicketNumber(spRsvpTicket);

		} catch (NoSuchRsvpPaymentException e) {
			try {
				RsvpCoParticipantDetailLocalServiceUtil.findByTicketNumber(ticketNumber);
				return getTicketNumber(spRsvpTicket);
			} catch (NoSuchRsvpCoParticipantDetailException ce) {
				spRsvpTicket.setSoldQuantity(counter - spRsvpTicket.getTicketSequence() + 1);
				spRsvpTicket.setLastSequenceNumber(counter);
				RsvpTicketLocalServiceUtil.updateRsvpTicket(spRsvpTicket);
				if (_log.isDebugEnabled()) {
					_log.debug(" RsvpId  : " + spRsvpTicket.getRsvpId() + " : price : " + spRsvpTicket.getPrice()
							+ " : ticketNumber : " + ticketNumber);
				}
				return ticketNumber;
			}
		}
	}

	public static String getFilePath(String id, String targetExtension) {
		StringBundler sb = new StringBundler(5);

		sb.append(SystemProperties.get(SystemProperties.TMP_DIR));
		sb.append("/liferay/");
		sb.append(id);
		sb.append(StringPool.PERIOD);
		sb.append(targetExtension);

		return sb.toString();
	}

}
