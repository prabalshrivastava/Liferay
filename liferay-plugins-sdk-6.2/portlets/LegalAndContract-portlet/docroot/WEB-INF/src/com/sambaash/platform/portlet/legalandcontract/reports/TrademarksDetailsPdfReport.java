package com.sambaash.platform.portlet.legalandcontract.reports;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDCcitt;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;

public class TrademarksDetailsPdfReport {
	float pageMargin = 10;
	final float rowHeight = 18f;
	int fontSize = 8;
	final float cellMargin = 3f;
	final float rowMargin = 7f;
	int imageWidth = 80;
	int imageHeight = 40;
	final float valueCellWidth = 300;
	PDType1Font boldFont = PDType1Font.HELVETICA_BOLD;
	float texty = 0;
	float labelx = 50;
	float textx = 250;
	final float labelStartx = 50;
	final float textStartx = 250;
	PDPageContentStream contentStream = null;
	PDDocument doc = null;
	PDPage page = null;
	
	public static void main(String a[]) throws COSVisitorException, IOException{
		//new TrademarksDetailsPdfReport().generateReport();
	}
	public void generateReport(String path,Map<String,String> map ,List<Map<String, String>> attachments,List<Map<String, String>> confAttachments,boolean authorized) throws IOException, COSVisitorException {
//		Map<String,String> map = prepareData();
		int index = 0;
		List<String>keys = new ArrayList(map.keySet());
		doc = new PDDocument();
		PDXObjectImage ximage = getImage(doc, map.get(TrademarksConstants.TRADEMARK_LOGO_COLUMN),imageWidth,imageHeight);
		while(true){
			if(index >= keys.size()){
				break;
			}
			if(texty <= 20){
				if(Validator.isNotNull(contentStream)){
					contentStream.close();
				}
				page = new PDPage();
				doc.addPage(page);
				contentStream = new PDPageContentStream(doc, page);
				contentStream.setFont(boldFont, fontSize);
				texty = page.findMediaBox().getHeight() - (rowHeight + 35);;
				if(index == 0){
					if(Validator.isNotNull(ximage)){
						contentStream.drawImage(ximage, labelx, texty);
						texty = texty - rowMargin;
					}
					texty = texty - rowMargin;
				}
			}
			String key = keys.get(index);
			if(key.equals(TrademarksConstants.TRADEMARK_LOGO_COLUMN) || key.equals(TrademarksConstants.LEGAL_CONF_REMARKS_COLUMN)){
				index ++;
				continue;
			}
			
			String text = map.get(key);
			contentStream.beginText();
			contentStream.moveTextPositionByAmount(labelx, texty);
			contentStream.drawString(GetterUtil.getString(key));
			contentStream.endText();
			drawValue(text, valueCellWidth,"field");
			index = index + 1;
		}
		index = 0;
		
		contentStream.beginText();
		contentStream.moveTextPositionByAmount(labelx, texty);
		contentStream.drawString(TrademarksConstants.ATTACHMENTS_COLUMN + ":");
		contentStream.endText();
		texty = texty - rowMargin ;
		if(Validator.isNotNull(attachments) && !attachments.isEmpty()){
			drawFileTable(attachments);
		}else{
			texty = texty + rowMargin;
			drawValue(" No Attachments Found", 300, "field");
		}
		
		if(authorized){
			contentStream.drawLine(labelStartx-8, texty+3, page.findMediaBox().getWidth()-30, texty+3);
			texty = texty - rowHeight ;
			contentStream.beginText();
			contentStream.moveTextPositionByAmount(labelx, texty);
			contentStream.drawString(TrademarksConstants.LEGAL_CONF_REMARKS_COLUMN);
			contentStream.endText();
			drawValue(map.get(TrademarksConstants.LEGAL_CONF_REMARKS_COLUMN), valueCellWidth, "field");
			texty = texty - rowMargin ;
			
			contentStream.beginText();
			contentStream.moveTextPositionByAmount(labelx, texty);
			contentStream.drawString(TrademarksConstants.CONF_ATTACHMENTS_COLUMN + ":");
			contentStream.endText();
			texty = texty - rowMargin;
			if(Validator.isNotNull(confAttachments) && !confAttachments.isEmpty()){
				drawFileTable(confAttachments);
			}else{
				texty = texty + rowMargin;
				drawValue(" No Confidential Attachments Found", 300, "field");
			}
		}
		
		if(Validator.isNotNull(contentStream)){
			contentStream.close();
		}
		doc.save(path);
		doc.close();
	}
	
	private void drawFileTable(	List<Map<String,String>> files) throws IOException{
	//	List<Map<String,String>> files = getAttachments();
		Map<String,String> file;
		int index = 0;
		while(true){
			if(index  >= files.size()){
				break;
			}
			if(texty <= 50){
				if(Validator.isNotNull(contentStream)){
					contentStream.close();
				}
				page = new PDPage();
				doc.addPage(page);
				contentStream = new PDPageContentStream(doc, page);
				contentStream.setFont(boldFont, fontSize);
				texty = page.findMediaBox().getHeight() - (rowHeight + 35);;
			}
			if(index == 0){
				textx = labelStartx;
				contentStream.drawLine(labelStartx-8, texty, page.findMediaBox().getWidth()-30, texty);
				texty = texty - 2*rowMargin;
				
				contentStream.beginText();
				contentStream.moveTextPositionByAmount(textx, texty);
				contentStream.drawString("Title");
				contentStream.endText();
				
				textx = textx + cellMargin + 150;
				
				contentStream.beginText();
				contentStream.moveTextPositionByAmount(textx , texty);
				contentStream.drawString("Version");
				contentStream.endText();
				textx = textx +  60;

				contentStream.beginText();
				contentStream.moveTextPositionByAmount(textx, texty);
				contentStream.drawString("Description");
				contentStream.endText();
				
				texty = texty - (rowMargin + 3);
				contentStream.drawLine(labelStartx-8, texty, page.findMediaBox().getWidth()-30, texty);
				texty = texty - (rowMargin + 3);
			}
			
			file = files.get(index);
			textx = labelStartx;
			float tempTexty = texty;
			drawValue(file.get("title"), 150,"table");
			
			textx = textx + cellMargin + 150;
			texty = tempTexty;
			drawValue(file.get("version"), 60,"table");

			textx = textx + 60;
			texty = tempTexty;
			drawValue(file.get("description"), 300,"table");
			
			texty = texty - rowHeight;
			
			index = index + 1;
		}
	}
	
	private  void drawValue(String text,float cellWidth,String src) throws IOException{
		float availbleArea = (cellWidth * 1000)/fontSize;
		int startPoint = 0;
		text = GetterUtil.getString(text);
		if(boldFont.getStringWidth(text) > availbleArea ){
			int length = text.length();
			while(startPoint < length){
				if(texty <= 20){
					page = new PDPage();
					doc.addPage(page);
					contentStream.close();
					contentStream = new PDPageContentStream(doc, page);
					contentStream.setFont(boldFont, fontSize);
					texty =  page.findMediaBox().getHeight() - (rowHeight + 35);;
				}
				for(int counter = length  ; counter >= startPoint; counter --){
					String subStr = text.substring(startPoint,counter);
					float subStrArea = boldFont.getStringWidth(subStr);
					if((subStrArea <= availbleArea)){
						contentStream.beginText();
						contentStream.moveTextPositionByAmount(textx, texty);
						contentStream.drawString(subStr);
						contentStream.endText();
						texty -= 9;
						startPoint = counter;
						break;
					}
				}
			}
			texty = texty - (rowHeight - 9);
			
		}else{
			contentStream.beginText();
			contentStream.moveTextPositionByAmount(textx, texty);
			contentStream.drawString(GetterUtil.getString(text));
			contentStream.endText();
			if(!"table".equals(src)){
				texty = texty - rowHeight ;
			}
		}
	}

	private static PDXObjectImage getImage(PDDocument doc,String fileEntryId,int imageWidth,int imageHeight) {
		PDXObjectImage ximage  = TrademarksListingPdfReport.getImage(doc, fileEntryId);
		if(Validator.isNotNull(ximage)){
			ximage.setHeight(imageHeight);
			ximage.setWidth(imageWidth);
		}
        return ximage;
	}
	private static Map<String, String> prepareData() {
		Map<String, String> map;

		map = new LinkedHashMap<String, String>();
		map.put(TrademarksConstants.TRADEMARK_LOGO_COLUMN,"paypaleee.jpeg");
		map.put(TrademarksConstants.COUNTRY_COLUMN, "India");
		map.put(TrademarksConstants.CLASS_COLUMN, "22");
		map.put(TrademarksConstants.CLASS_DESCRIPTION_COLUMN, "22");
		map.put(TrademarksConstants.REGISTERED_OWNER_COLUMN, "");
		map.put(TrademarksConstants.APPLICATION_NO_COLUMN,	"Application 01012sa sdafasf 1asdf");
		map.put(TrademarksConstants.REGISTRATION_NUMBER_COLUMN_1,"TradeMarks 12afasdf345");
		map.put(TrademarksConstants.STATUS_COLUMN,	"Activesaf asdf as asfasfasdfsadf asfsa");

		map.put(TrademarksConstants.CONTENTIOUS_PROCEEDINGS_COLUMN,	"12345, 6789, 12342");
		map.put(TrademarksConstants.ACTIVE_INGREDIENTS_COLUMN,"Active Ingredients");
		map.put(TrademarksConstants.TRADEMARK_TYPE_COLUMN,"TradeMarks Type");
		map.put(TrademarksConstants.APPLICATION_DATE_COLUMN, "21-DEC-2014");
		map.put(TrademarksConstants.FIRST_REG_DATE_COLUMN, "21-DEC-2014");
		map.put(TrademarksConstants.RENEWAL_ALERT_BEFORE_COLUMN, "80");
		map.put(TrademarksConstants.EXPIRY_DATE_COLUMN, "20-DEC-2024");
		map.put(TrademarksConstants.REMARKS_COLUMN, "test");
		map.put(TrademarksConstants.VERSION, "7.0");
		map.put(TrademarksConstants.LEGAL_CONF_REMARKS_COLUMN, "test");
		
		
		return map;
	}
	
	private List<Map<String, String>> getAttachments(){
		List<Map<String,String>> files = new ArrayList<Map<String,String>>();
		for(int i=0;i<5;i++){
			Map<String,String>file = new HashMap<String, String>();
			file.put("title", "bmp test.jpg");
			file.put("version", "5.0");
			file.put("description", "file to test attachements");
			files.add(file);
		}
		return files;
	}
}
