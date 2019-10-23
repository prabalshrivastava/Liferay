package com.sambaash.platform.attendance.ajax;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import com.liferay.mail.model.FileAttachment;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.attendance.service.SPAttendenceLocalServiceUtil;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.utils.PDStreamUtils;

public class SendExamDocketNotificationHandler implements ServeResourceActionHandler {

	private static final Log _log = LogFactoryUtil.getLog(SendExamDocketNotificationHandler.class);
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	
	private static final String  PRODUCT_TYPE = "exam";
	private static final String PRODUCT_SUBTYPE = "sac";
	private static final String FUNCTIONAL_COMPONENT = "finance";
	private static final String CATEGORY_TYPE = "invoice";
	private static final String CLIENT_TYPE = "Individual";
	
	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		try{
			
			long scopeGroupId = PortalUtil.getScopeGroupId(request);
			
			//String data = request.getParameter("data");
			//JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(data);
			//String examDocketNumber = jsonModelData.getString("docketNumber");
			
			String examDocketNumber =  SPAttendenceLocalServiceUtil.generateReferenceNumber(scopeGroupId, PRODUCT_TYPE, PRODUCT_SUBTYPE, FUNCTIONAL_COMPONENT, CATEGORY_TYPE, CLIENT_TYPE);
			String modelData = SystemLocalServiceUtil.getSearchListing(request, response);
			
			JSONObject responseJsonModelData = JSONFactoryUtil.createJSONObject(modelData);
			JSONArray jsonUserExamArray = responseJsonModelData.getJSONArray("content");
			
			if(jsonUserExamArray.length()>0){
				File examDocketPDF = prepareExamDocketFile(jsonUserExamArray,examDocketNumber);
				JSONObject jObject = jsonUserExamArray.getJSONObject(0);
				JSONObject userJsonObj = jObject.getJSONObject("userId");
				
				JSONObject userContentJsonObj = userJsonObj.getJSONObject("contentJson");
				String toEmailAddress = userContentJsonObj.getString("PrimaryEmailAddress");
				sendExamDocketEmail(toEmailAddress, examDocketPDF);
			}
			response.getWriter().write(modelData);
			
		}catch(Exception e){
			_log.error(e);
		}
	}

	
	public static File prepareExamDocketFile(JSONArray jsonUserExamArray, String examDocketNumber) throws IOException {
		
		try{
			File file = File.createTempFile("ExamDocket-", ".pdf");
			File fileName = ResourceUtils
	                .getFile("classpath:SACDocketTemplate.pdf");
	        RandomAccessFile f = new RandomAccessFile(fileName, "r");
	        byte[] fileByteArray = new byte[(int) f.length()];
	        f.readFully(fileByteArray);
	        f.close();
	        FileCopyUtils.copy(fileByteArray, file);
	        
	        
	        PDDocument document = PDDocument.load(file);
			PDPage page = document.getPage(0);

				/*PDDocument document = new PDDocument();
				PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A3.getWidth()));
				document.addPage(page);
				
				File fileName = ResourceUtils
		                .getFile("classpath:../../images/ca-singapore.png");*/
				
/*				PDImageXObject pdImage = PDImageXObject.createFromFile(fileName.getAbsolutePath(), document);*/
				PDPageContentStream contentStream = new PDPageContentStream(document, page,AppendMode.APPEND, true, true);
				
				//contentStream.drawImage(pdImage, 40, 750);
				//PDStreamUtils.write(contentStream, "EXAMINATION ATTENDANCE DOCKET", PDType1Font.TIMES_BOLD, 20, 40, 700, new Color(0, 0, 0));
				//PDStreamUtils.write(contentStream, "Declaration", PDType1Font.TIMES_BOLD, 18, 40, 660, new Color(0, 0, 0));
				
				float margin = 10;
				float yStartNewPage = page.getMediaBox().getHeight() - (12 * margin);
				float tableWidth = page.getMediaBox().getWidth() + (20 * margin);
				boolean drawContent = true;
				float yStart = yStartNewPage;
				float bottomMargin = 80;
				float pageTopMargin = 80;
				
				BaseTable declarationTable = new BaseTable(yStart, yStartNewPage, pageTopMargin, bottomMargin, tableWidth, 20 * 3,document, page, false, drawContent);
				
				ArrayList<Row<PDPage>> declarationRows = new ArrayList();
				
				Cell<PDPage> declarationCell ;
				  
				for(int i=0;i<5;i++){
					declarationRows.add(declarationTable.createRow(30f));
					declarationRows.get(i).setHeight(5);
					
				}
				
				declarationCell = declarationRows.get(0).createCell(40f, "EXAMINATION ATTENDANCE DOCKET");
				declarationCell.setFont(PDType1Font.TIMES_BOLD);
				declarationCell.setFontSize(15);
				declarationCell = declarationRows.get(1).createCell(40f, "Declaration");
				declarationCell.setFont(PDType1Font.TIMES_BOLD);
				declarationCell.setFontSize(12);
				declarationCell = declarationRows.get(2).createCell(70f, declaration1);
				declarationCell.setFont(PDType1Font.TIMES_ROMAN);
				declarationCell.setFontSize(15f);
				declarationCell = declarationRows.get(3).createCell(70f, declaration2);
				declarationCell.setFont(PDType1Font.TIMES_ROMAN);
				declarationCell.setFontSize(15f);
				declarationCell = declarationRows.get(4).createCell(70f,declaration3 );
				
				declarationCell.setFont(PDType1Font.TIMES_ROMAN);
				declarationCell.setFontSize(15f);
				declarationTable.draw();
				
				contentStream.beginText();
				contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
				contentStream.newLineAtOffset(40, 300);
				
				JSONObject jObject = jsonUserExamArray.getJSONObject(0);
				
				String userModelJson = jObject.getString("userId");
				JSONObject userJsonObj = JSONFactoryUtil.createJSONObject(userModelJson);
				
				JSONObject userContentJsonObj = userJsonObj.getJSONObject("contentJson");
				
				String text = "Name : "+userContentJsonObj.getString("FullName");
				String identificationNumber = "Identification No. : "+userContentJsonObj.getString("IDNumber");
				String docketNo = "Docket No. : "+examDocketNumber;
				
				contentStream.showText(text);
				contentStream.newLine();
				contentStream.newLineAtOffset(0, -20);

				contentStream.showText(identificationNumber);
				contentStream.newLine();
				contentStream.newLineAtOffset(0, -20);

				contentStream.showText(docketNo);
				contentStream.newLine();
				contentStream.newLineAtOffset(0, -40);
				contentStream.close();

				//create exam list table 
				BaseTable table = new BaseTable(yStart-250, yStartNewPage-200, pageTopMargin, bottomMargin, tableWidth, margin * 3,document, page, true, drawContent);
				createExamListTable(table,jsonUserExamArray);
				
				document.save(file);
				document.close();
				
				
				
				
				return file;
			
		}
		catch(Exception e){
			return null;
		}
	}

	private static void createExamListTable(BaseTable table, JSONArray jsonUserExamArray) {

		try {
			ArrayList<Row<PDPage>> rows = new ArrayList();
			Cell<PDPage> cell ;
			Date result = null;
			Row<PDPage> headerRow = table.createRow(50);
			headerRow.createCell(8f,"Date");
			headerRow.createCell(8f,"Time");
			headerRow.createCell(15f,"Programme");
			headerRow.createCell(15f,"Module");
			headerRow.createCell(10f,"Exam Venue");
			headerRow.createCell(10f,"Room");
			headerRow.createCell(8f,"Desk Number");

			headerRow.setHeight(20f);

			table.addHeaderRow(headerRow);

			for(int i=0 ; i<jsonUserExamArray.length();i++){

				JSONObject jsonModelData = JSONFactoryUtil.createJSONObject(jsonUserExamArray.getString(i));
				String contentJson = jsonModelData.getString("contentJson");
				JSONObject contentJsonObj = JSONFactoryUtil.createJSONObject(contentJson);

				String scheduleModelJson = jsonModelData.getString("scheduleId");
				JSONObject scheduleJsonObj = JSONFactoryUtil.createJSONObject(scheduleModelJson);

				String seatingPlanModelJson = jsonModelData.getString("seatingPlanInstanceId");
				JSONObject seatingPlanJsonObj = JSONFactoryUtil.createJSONObject(seatingPlanModelJson);

				result = df.parse(jsonModelData.getString("startDate"));

				sdfTime.setTimeZone(TimeZone.getTimeZone("IST"));
				sdfDate.setTimeZone(TimeZone.getTimeZone("IST"));
				rows.add(table.createRow(30f));
				rows.get(i).setHeight(5);

				cell = rows.get(i).createCell(8f, sdfDate.format(result));
				cell.setFontSize(10f);
				cell = rows.get(i).createCell(8f, sdfTime.format(result));
				cell.setFontSize(10f);
				cell = rows.get(i).createCell(15f, scheduleJsonObj.getString("name"));
				cell.setFontSize(10f);
				cell = rows.get(i).createCell(15f, jsonModelData.getString("subjectTitle"));
				cell.setFontSize(10f);
				cell = rows.get(i).createCell(10f, contentJsonObj.getString("Facility"));
				cell.setFontSize(10f);
				cell = rows.get(i).createCell(10f, contentJsonObj.getString("SubFacility"));
				cell.setFontSize(10f);
				cell = rows.get(i).createCell(8f, contentJsonObj.getString("userId"));
				cell.setFontSize(10f);
			}
			table.draw();
		}catch(Exception e){
			_log.error(e);
		}
	}

	public static void sendExamDocketEmail(String toAddress , File docketFile) {
		
		/*String fromName = SambaashUtil.getFromNameMail(ds.getCompanyId());
		String fromAddress = SambaashUtil.getFromMailAddress(ds.getCompanyId());*/
		String fromName="testAccount";
		String fromAddress = "test@test.com";
		
		String subjectFormat = "subjectFormat";
		String contentFormat = "contentFormat";
		
/*		SPMailTemplateLocalServiceUtil.getSPMailTemplate(spMailTemplateId);*/

		MailMessage mailMessage = new MailMessage();
		mailMessage.setFromAddress(fromAddress);
		mailMessage.setFromName(fromName);
		mailMessage.setSubject(subjectFormat);
		mailMessage.setHtmlBody(contentFormat);
		mailMessage.setHtmlFormat(true);
		
		mailMessage.setToAddress(toAddress);
		
		if(Validator.isNotNull(docketFile)){
			
			FileAttachment fileAttachment = new FileAttachment(docketFile,"ExamDocket.pdf");
			List<FileAttachment> fileAttachments = new ArrayList<>();
			fileAttachments.add(fileAttachment);
			mailMessage.setFileAttachments(fileAttachments);
			mailMessage.setMultiPart(true);
		}
		
		SPMailLocalServiceUtil.sendMail(mailMessage);
	}
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS");
	private static final SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
	private static final SimpleDateFormat sdfDate = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	private static final String declaration1 = "1. I declare I have read and understood the Singapore CA Qualification Examination Guidelines and Regulations.";
	private static final String declaration2 = "2. I understand that I will need to bring along this docket and my photo ID which indicates the same identification number as stated on this docket.";
	private static final String declaration3 = "3. I understand that if I do not bring my docket and photo ID, I will need to inform the invigilator before the examination commences";
}
