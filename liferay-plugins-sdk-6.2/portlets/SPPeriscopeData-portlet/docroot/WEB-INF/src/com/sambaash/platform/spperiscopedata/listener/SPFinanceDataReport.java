package com.sambaash.platform.spperiscopedata.listener;

	
	import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.liferay.mail.model.FileAttachment;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.scheduler.SPScheduledJob;
import com.sambaash.platform.spperiscopedata.util.FinanceReportExcelUtil;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;
import com.sambaash.platform.srv.spservices.NoSuchSPParameterException;
import com.sambaash.platform.srv.spservices.model.SPParameter;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;

	public class SPFinanceDataReport extends SPScheduledJob {

		private static Log _log = LogFactoryUtil.getLog(SPFinanceDataReport.class);

		public void receive(Message message) throws MessageListenerException {
			_log.debug("SPFinanceDataReport ");
			Map<String, Object> mapMsg = (Map<String, Object>) message.get("map");
			
			Calendar calendar = Calendar.getInstance();
			//calendar.setTime(dateOfOrder);            
			calendar.add(Calendar.DAY_OF_YEAR, 7);
			
			_log.debug(mapMsg.get("toEmailAddress"));
			String toEmail = (String) mapMsg.get("toEmailAddress");
			String toBccEmail = (String) mapMsg.get("tobccEmailAddress");
			_log.debug("satarta date 213 " +  mapMsg.get("reportStartDate"));
			String sDate = (String) mapMsg.get("reportStartDate");
			String mailFrequency = (String) mapMsg.get("mailFrequency");
			_log.debug("reportEndDate date 213 " +  mapMsg.get("reportEndDate"));
			String eDate = (String) mapMsg.get("reportEndDate");
			
			boolean offlineList = false;
			boolean onlineList = false;
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd 59:59:23");
	        Calendar cal = Calendar.getInstance();
	        Calendar cal1 = Calendar.getInstance();
	        
	        if("weekly".equalsIgnoreCase(mailFrequency)){
	        	cal.add(Calendar.DATE, -7);
	        }
	        if("monthly".equalsIgnoreCase(mailFrequency)){
	        	cal.add(Calendar.DATE, -30);
	        }
	        if("yearly".equalsIgnoreCase(mailFrequency)){
	        	cal.add(Calendar.DATE, -365);
	        }
	        Date startDate = cal.getTime();   
	        Date endDate = cal1.getTime(); 
	        String fromdate = dateFormat.format(startDate);
	        String fromdateEnd = dateFormat1.format(endDate);
	        _log.debug("fromdate " + fromdate + " fromdateEnd " + fromdateEnd);
	        
			String format = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat df = new SimpleDateFormat(format);
				try {
					if (Validator.isNotNull(fromdate)) {
						startDate = df.parse(fromdate);
					}
					if (Validator.isNotNull(fromdateEnd)) {
						endDate = df.parse(fromdateEnd);
					}	
				} catch (ParseException e) {
					_log.error(e.getMessage());
				}
				 _log.debug("startDate " + startDate + " endDate " + endDate);
			long groupId =  (long) mapMsg.get("scopeGroupId");
			String filePath = StringPool.BLANK;
			try {
				List<FileAttachment> fileList = new ArrayList<FileAttachment>();
				List<Object> objectList = PEProcessStateLocalServiceUtil.getOfflineFinancereport(startDate,endDate,startDate,endDate,startDate,endDate);

				if(Validator.isNotNull(objectList)){
					if(!objectList.isEmpty()){
					_log.debug("objectList " + objectList.size());
					filePath = getFinancereport(objectList,"offline");
					fileList.add(new FileAttachment(new File(filePath), "Finance-Report-Offline-"+Calendar.getInstance().getTime() +".xlsx"));
					offlineList = true;
					}
				}
				List<Object> objectListOnline = PEProcessStateLocalServiceUtil.getOnlineFinancereport(startDate,endDate,startDate,endDate,startDate,endDate);
				if(Validator.isNotNull(objectListOnline)){
					if(!objectListOnline.isEmpty()){
						filePath = getFinancereport(objectListOnline,"online");
						onlineList = true;
						_log.debug("filePath receive  " + filePath);
						fileList.add(new FileAttachment(new File(filePath), "Finance-Report-Online"+Calendar.getInstance().getTime() +".xlsx"));
					}	
				}	
				_log.debug("fileList " + fileList.size());
				sendEmail(toEmail,fileList,groupId,mailFrequency,toBccEmail,offlineList,onlineList);
		}catch(Exception e){
			_log.error(e.getMessage(),e);
		}
		}			
		
		private String getFinancereport(List<Object> objectList,String reportType) {

			String filePath = StringPool.BLANK;
			try{
			if (objectList != null && objectList.size() > 0) {
				FinanceReportExcelUtil excelUtil = new FinanceReportExcelUtil();
				try {
					filePath = excelUtil.createExcel(objectList,reportType);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					_log.error(e);
				}
				_log.debug("filePath filePath ==" + filePath);
				String contentType = MimeTypesUtil.getContentType(filePath);
				File file = new File(filePath);
				boolean exists = file.exists();

				if (!exists) {
					_log.error("File does not exists");
				}

			}
			} catch (Exception e) {
				_log.error(e.getMessage(),e);
			}
			return filePath;
		}

		private void createPasswordProtectedZip(){
			
		}

		private void sendEmail(String toEmail, List<FileAttachment> fileList,long groupId,String mailFrequency,String toBccEmail,boolean offlineList,boolean onlineList) {
			// TODO Auto-generated method stub
			_log.debug("send Email ######## ");
			String fromName;
			String offline = "Offline";
			String online = "Online";
			String reportType = "Offline and Online";
			String noRecordMessage = StringPool.BLANK;
			if(!offlineList){
				offline =  StringPool.BLANK;
				reportType = "Online";
				noRecordMessage = "No transaction received for today with offline payment";
			}
			if(!onlineList){
				online =  StringPool.BLANK;
				reportType = "Offline";
				noRecordMessage = "No transaction received for today with online payment";
			}
			try {
				fromName = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
						PropsKeys.ADMIN_EMAIL_FROM_NAME);
			String fromAddress = PrefsPropsUtil.getString(PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFromAddress(fromAddress);
			mailMessage.setFromName(fromName);
			if(fileList.isEmpty()){
				mailMessage.setSubject("Finance Report");
				mailMessage.setHtmlBody("There is no transaction received for today");
			}else{	
				String content = "Please find attached the Finance Reports for [$reportType$] Payments";
				String subject = "Finance Report";
	
				String tempId = "0";
				SPMailTemplate template = null;
				try {
					SPParameter parameter = SPParameterLocalServiceUtil.findBySPParameterGroupIdAndName(groupId, "finance.report.template");
					tempId = parameter.getValue();
					if(Validator.isNotNull(tempId)){
						template = SPMailTemplateLocalServiceUtil.getSPMailTemplate(Long.parseLong(tempId));
						}
				} catch (NoSuchSPParameterException e) {
					_log.info("No such spparameter exist with key: " + "finance.report.template" + " groupId: " + groupId);
				} catch (Exception e) {
					_log.error("Exception getting SPParameter ==" + e.getMessage());
				}
				
				if(Validator.isNotNull(template)){
					content = template.getHtmlContent();
					subject = template.getSubject();
				}	
				
				content = StringUtil.replace(content, new String[] { "[$firstName$]", "[$Date$]", "[$FROM$]","[$reportType$]","[$noRecordMessage$]","[$offline$]","[$online$]"},
								new String[] { "RELC TEAM", mailFrequency, fromName,reportType,noRecordMessage,offline,online});
				
				subject = StringUtil.replace(subject, new String[] {"[$Date$]"},
						new String[] {mailFrequency});
				
				if(Validator.isNotNull(subject)){
					subject = subject.substring(0, 1).toUpperCase() + subject.substring(1);
				}
	
				
				mailMessage.setSubject(subject);
				mailMessage.setHtmlBody(content);
				if (fileList != null) {
					mailMessage.setFileAttachments(fileList);
					mailMessage.setMultiPart(true);
				} else {
					mailMessage.setMultiPart(false);
				}
			}
			mailMessage.setToAddress(toEmail);
			mailMessage.setBccAddress(toBccEmail);
			//_log.error("Final html content : " + mailMessage.getHtmlBody());
			//_log.error("Final mail : " + mailMessage.toString());
			SPMailLocalServiceUtil.sendMail(mailMessage);
			} catch (SystemException e) {
				_log.error(e.getMessage());
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

		@Override
		public void executeJob() {
			_log.debug("executeJob ");
			Map<String, Object> extrasMap = getExtrasMap();
			Message message = new Message();
			message.put("map", extrasMap);
			try {
				receive(message);
			} catch (MessageListenerException e) {
				_log.error(e);
			}
		}

	}
