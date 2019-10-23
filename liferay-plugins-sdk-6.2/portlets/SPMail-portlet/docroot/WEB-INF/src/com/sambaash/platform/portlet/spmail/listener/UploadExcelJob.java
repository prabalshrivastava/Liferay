package com.sambaash.platform.portlet.spmail.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.validator.EmailValidator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import sambaash.platform.util.SchedulerUtil;



import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.PwdGenerator;
import com.sambaash.platform.constant.SambaashConstants.EXCEL;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.model.RsvpSource;
import com.sambaash.platform.model.RsvpStatus;
import com.sambaash.platform.model.SPMailStatus;
import com.sambaash.platform.model.SPMailType;
import com.sambaash.platform.scheduler.SPScheduledJob;
import com.sambaash.platform.srv.mail.NoSuchBlackListException;
import com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;
import com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.service.SPMailBlackListLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignEDMLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailCampaignSubscribersLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailUnsubscribeLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.NoSuchRsvpDetailException;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.model.RsvpDetail;
import com.sambaash.platform.srv.rsvp.service.RsvpDetailLocalServiceUtil;
import com.sambaash.platform.srv.rsvp.service.RsvpLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileServiceUtil;
import com.sambaash.platform.util.SchedulerUtil;

import java.util.*;

public class UploadExcelJob extends SPScheduledJob {

	private static Log _log = LogFactoryUtil.getLog(UploadExcelJob.class);

	public void receive(Message message) throws MessageListenerException {

		_log.info(" Upload Excel - " + message.toString());

		long startTime = Calendar.getInstance().getTimeInMillis();
		Map<String,String> mapMsg = (Map<String,String>)message.get("map");
		long campaignId = Long.parseLong(mapMsg.get("campaignId"));
		//String[] params = StringUtil.split(mapMsg.get("spParams"), CharPool.DASH);

		long fileEntryId = Long.parseLong(mapMsg.get("fileEntryId"));
		long userId = Long.parseLong(mapMsg.get("userId"));
		boolean doRegistration = false;

		try {
			SchedulerUtil.unschedule(UploadExcelJob.class.getName(), String.valueOf(campaignId) + StringPool.COLON
					+ String.valueOf(fileEntryId) + StringPool.DASH + String.valueOf(userId) + "-Upload");
		} catch (Exception e) {
			_log.error(" unable to schedule or delete");
		}

		try {
			SPMailCampaign spMailCampaign = SPMailCampaignLocalServiceUtil.getCampaign(campaignId);

			if (spMailCampaign.getRsvpId() > 0) {
				Rsvp rsvp = RsvpLocalServiceUtil.getRsvp(spMailCampaign.getRsvpId());
				doRegistration = rsvp.isRegisterFlag();
			}

		} catch (Exception e) {
			_log.error(" unable to schedule or delete");
		}

		try {
			if (_log.isDebugEnabled()) {
				_log.debug(" campaignId value - " + campaignId);
				_log.debug(" spParams value - " + message.getString("spParams"));
			}

			PrincipalThreadLocal.setName(userId);

			User user = UserLocalServiceUtil.getUserById(userId);

			PermissionChecker permissionChecker;

			permissionChecker = PermissionCheckerFactoryUtil.create(user, false);

			PermissionThreadLocal.setPermissionChecker(permissionChecker);

			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);

			StringBuilder result = uploadSubscribers(fileEntry, userId, campaignId, doRegistration);

			long endTime = Calendar.getInstance().getTimeInMillis();

			result.append("Total time taken for upload : ").append(getTotalTime(endTime - startTime));

			_log.info("Total time taken for uplaod : " + getTotalTime(endTime - startTime));

			String fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_NAME);

			String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			MailMessage msg = new MailMessage();
			msg.setSubject("Excel upload completed.");
			msg.setHtmlBody(result.toString());
			msg.setHtmlFormat(true);
			msg.setFromAddress(fromAddress);
			msg.setFromName(fromName);
			msg.setToAddress("alerts@sambaash.com");
			SPMailLocalServiceUtil.sendMail(msg);

		} catch (Exception e) {
			_log.error(e);
		}

		try {
			SchedulerUtil.unschedule(UploadExcelJob.class.getName(), String.valueOf(campaignId) + StringPool.COLON
					+ String.valueOf(fileEntryId) + StringPool.DASH + String.valueOf(userId) + "-Upload");
		} catch (Exception e) {
			_log.error(" unable to schedule or delete");
		}

	}

	private StringBuilder uploadSubscribers(FileEntry fileEntry, long userId, long campaignId, boolean doRegistration)
			throws PortalException, SystemException {

		SPMailCampaign spMailCampaign = SPMailCampaignLocalServiceUtil.getSPMailCampaign(campaignId);
		List<SPMailCampaignEDM>edms = SPMailCampaignEDMLocalServiceUtil.findByCampaignId(campaignId);
		String apiKey = "mXqb6XuR+SVQXix3y1MQUxtIy1W4NbY/MLLZfv4RA==";
		StringBuilder result = new StringBuilder("<html><body><p><table>");
		Workbook wb = null;
		if (fileEntry != null) {
			try {
				if (fileEntry.getTitle().endsWith(EXCEL.EXTENSION_OLD)) {

					wb = readFileXls(fileEntry.getContentStream());

				} else if (fileEntry.getTitle().endsWith(EXCEL.EXTENSION)) {
					wb = readFileXlsx(fileEntry.getContentStream());
				}

				Calendar cal = Calendar.getInstance();

				RsvpDetail rsvpDetail = null;

				if (wb != null) {
					for (int i = 0; i < wb.getNumberOfSheets(); i++) {
						Sheet sheet = wb.getSheetAt(i);
						int uploadCount = 0;
						int failedCount = 0;
						int registrationCount = 0;
						for (Row row : sheet) {
							try {
								result.append("<tr>");
								if (Validator.isNull(String.valueOf(row.getCell(0)))
										|| Validator.isNull(String.valueOf(row.getCell(2)))
										|| !EmailValidator.getInstance().isValid(String.valueOf(row.getCell(2)))) {
									result.append("<td>").append(String.valueOf(row.getRowNum()))
											.append("</td><td colspan=\"1\"></td><td>validation failed</td>");
									failedCount++;
								} else {

									SPMailCampaignSubscribers spMailCamSub = null;
									User user = null;
									String firstName = String.valueOf(row.getCell(0)).trim();
									String lastName = String.valueOf(row.getCell(1)).trim();
									String emailAddress = String.valueOf(row.getCell(2)).trim().toLowerCase();

									try {
										SPMailBlackListLocalServiceUtil.findByEmailAddress(emailAddress);

										result.append("<td>").append(String.valueOf(row.getRowNum()))
												.append("</td><td>").append(emailAddress)
												.append("</td><td>Exists in bounced list. Will skip this record </td>");

									} catch (NoSuchBlackListException e) {

										try {
											SPMailUnsubscribeLocalServiceUtil.findByEmailAddressAndCategoryId(
													emailAddress, spMailCampaign.getCategoryId());

											result.append("<td>")
													.append(String.valueOf(row.getRowNum()))
													.append("</td><td>")
													.append(emailAddress)
													.append("</td><td>unsubscribed from this category. Will skip this record </td>");

										} catch (NoSuchUnsubscribeException ue) {

											try {
												user = UserLocalServiceUtil.getUserByEmailAddress(
														PortalUtil.getDefaultCompanyId(), emailAddress);
											} catch (NoSuchUserException ne) {
												if (_log.isDebugEnabled()) {
													_log.debug("User not found : " + emailAddress);
												}

												if (doRegistration && spMailCampaign.getRsvpId() > 0) {
													SocialProfileServiceUtil.addUser(apiKey, firstName, lastName,
															emailAddress, PwdGenerator.getPassword(), "0", "male",
															StringPool.BLANK);
													user = UserLocalServiceUtil.getUserByEmailAddress(
															PortalUtil.getDefaultCompanyId(), emailAddress);
													registrationCount++;
												}

											}

											try {

												spMailCamSub = SPMailCampaignSubscribersLocalServiceUtil
														.findByCampaignIdMailTypeAndEmailAddress(campaignId,
																SPMailType.MAIN.getCode(), emailAddress);

												failedCount++;
												result.append("<td>")
														.append(String.valueOf(row.getRowNum()))
														.append("</td><td>")
														.append(emailAddress)
														.append("</td><td>subscriber already exists. Will skip this record </td>");

											} catch (NoSuchCampaignSubscribersException ce) {

												if(edms.size() > 0){
													// new implementation
													for (SPMailCampaignEDM spMailCampaignEDM : edms) {
														try{
															SPMailCampaignSubscribersLocalServiceUtil
															.findByCampaignIdMailTypeAndEmailAddress(campaignId,
																	spMailCampaignEDM.getSeqNo(), emailAddress);
															continue;
														}catch(Exception ex){
															
														}
														// create subscriber for each edm.
														long spMailCampaignSubscribersId = CounterLocalServiceUtil
																.increment("SPMailCampaignSubscribers.class");
														spMailCamSub = SPMailCampaignSubscribersLocalServiceUtil
																.createSPMailCampaignSubscribers(spMailCampaignSubscribersId);
														// ** - mailtype is used to identify the edm.
														// existing mailTyp are 0 to 4, new mailType starts from 10001. EdmId can not be used because edms having ids ( 1 to 4 ) can interfer with existing mail type
														spMailCamSub.setSpMailType((int) spMailCampaignEDM.getSeqNo());
														
														spMailCamSub.setSpMailCampaignId(campaignId);
														spMailCamSub.setCreateBy(userId);
														spMailCamSub.setUserId(user != null ? user.getUserId() : 0);
														spMailCamSub.setCreateDate(cal.getTime());
														spMailCamSub.setStatus(SPMailStatus.NOT_SCHEDULED.getStatus());
														spMailCamSub.setFirstName(firstName);
														spMailCamSub.setLastName(lastName);
														spMailCamSub.setEmailAddress(emailAddress);
														
														SPMailCampaignSubscribersLocalServiceUtil
														.updateSPMailCampaignSubscribers(spMailCamSub);
														
													}
												}else{
													// keeping support for old campaigns
													long spMailCampaignSubscribersId = CounterLocalServiceUtil
															.increment("SPMailCampaignSubscribers.class");
													spMailCamSub = SPMailCampaignSubscribersLocalServiceUtil
															.createSPMailCampaignSubscribers(spMailCampaignSubscribersId);
													
													spMailCamSub.setSpMailCampaignId(campaignId);
													spMailCamSub.setCreateBy(userId);
													spMailCamSub.setUserId(user != null ? user.getUserId() : 0);
													spMailCamSub.setCreateDate(cal.getTime());
													spMailCamSub.setStatus(SPMailStatus.NOT_SCHEDULED.getStatus());
													spMailCamSub.setFirstName(firstName);
													spMailCamSub.setLastName(lastName);
													spMailCamSub.setEmailAddress(emailAddress);
													
													SPMailCampaignSubscribersLocalServiceUtil
													.updateSPMailCampaignSubscribers(spMailCamSub);
												}
												uploadCount++;
											}

											if (spMailCampaign.getRsvpId() > 0) {
												try {
													
													if(RsvpDetailLocalServiceUtil
															.findByemailAddressAndRsvpId(spMailCampaign.getRsvpId(),
																	emailAddress).size() > 0) {
													rsvpDetail = RsvpDetailLocalServiceUtil
															.findByemailAddressAndRsvpId(spMailCampaign.getRsvpId(),
																	emailAddress).get(0);
													}
												} catch (NoSuchRsvpDetailException ne) {
												}

												if (rsvpDetail == null) {
													long rsvpDetailId = CounterLocalServiceUtil
															.increment("RsvpDetail.class");
													rsvpDetail = RsvpDetailLocalServiceUtil
															.createRsvpDetail(rsvpDetailId);

													rsvpDetail.setFirstName(firstName);
													rsvpDetail.setLastName(lastName);
													rsvpDetail.setEmailAddress(emailAddress);
													rsvpDetail.setUserId(user != null ? user.getUserId() : 0);
													rsvpDetail.setSource(RsvpSource.BYINVITATION.ordinal());
													rsvpDetail.setRsvpStatus(RsvpStatus.WAITING.ordinal());
													rsvpDetail.setUserId(userId);
													rsvpDetail.setCreateDate(DateUtil.newDate());
													rsvpDetail.setNumberOfPeople(1);
													RsvpDetailLocalServiceUtil.updateRsvpDetail(rsvpDetail);
												} else {
													_log.error(" RSVP detail already exists. Will skip this record.");
												}
											}
										}
									}
								}

							} catch (Exception e) {
								_log.error(e);
							}

							result.append("</tr>");
						}

						result.append("</p></table><p>");
						result.append("Total uplaoded records : ").append(uploadCount);

						if (doRegistration) {
							result.append("<br />").append("Total new registrations : ").append(registrationCount);
						}

						result.append(" <br /> Total error records : ").append(failedCount);
						result.append("<br /> </p></body></html>");

						if (_log.isDebugEnabled()) {
							_log.debug(result.toString());
						}
					}
				}

			} catch (Exception e) {
				_log.error("Invalid file " + e.getMessage());
			}
		}

		return result;
	}

	public String getTotalTime(long diffMSec) {
		int left = 0;
		int ss = 0;
		int mm = 0;
		int hh = 0;
		int dd = 0;
		left = (int) (diffMSec / 1000);
		ss = left % 60;
		left = (int) left / 60;
		if (left > 0) {
			mm = left % 60;
			left = (int) left / 60;
			if (left > 0) {
				hh = left % 24;
				left = (int) left / 24;
				if (left > 0) {
					dd = left;
				}
			}
		}

		StringBuffer diff = new StringBuffer();
		diff.append(dd).append(StringPool.SPACE).append(StringPool.COLON).append(StringPool.SPACE).append(hh)
				.append(StringPool.SPACE).append(StringPool.COLON).append(StringPool.SPACE).append(mm)
				.append(StringPool.SPACE).append(StringPool.COLON).append(StringPool.SPACE).append(ss)
				.append(StringPool.SPACE).append(StringPool.COLON).append(StringPool.SPACE);

		return diff.toString();

	}

	private HSSFWorkbook readFileXls(InputStream inputStream) throws IOException {
		return new HSSFWorkbook(inputStream);
	}

	private XSSFWorkbook readFileXlsx(InputStream inputStream) throws IOException {
		return new XSSFWorkbook(inputStream);
	}

	@Override
	public void executeJob() {
		// TODO Auto-generated method stub
		Map<String, Object> extrasMap = getExtrasMap();
		for (Map.Entry<String, Object> entry : extrasMap.entrySet())
		{
		}
		Message message = new Message();
	 	message.put("map",extrasMap);
	 	try {
			receive(message);
		} catch (MessageListenerException e) {
			_log.error(e.getMessage());
		}
	}

}
