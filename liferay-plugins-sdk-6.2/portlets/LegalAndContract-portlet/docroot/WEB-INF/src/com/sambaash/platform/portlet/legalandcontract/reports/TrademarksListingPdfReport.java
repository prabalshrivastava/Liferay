package com.sambaash.platform.portlet.legalandcontract.reports;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDCcitt;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.pdmodel.interactive.action.type.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;

public class TrademarksListingPdfReport {

	public static PDXObjectImage getImage(PDDocument doc,String fileEntryId) {
		 PDXObjectImage ximage = null;
		 int imageWidth = 60;
		 int imageHeight = 20;
		 FileEntry fe = null;
		 InputStream is = null;
		 try {
			 fe = DLAppServiceUtil.getFileEntry(GetterUtil.getLong(fileEntryId));
			 is = DLFileEntryLocalServiceUtil.getFileAsStream(fe.getUserId(), fe.getFileEntryId(), fe.getLatestFileVersion().getVersion());
		} catch (Exception e) {
		}
		 try{
			 if(Validator.isNotNull(is)){
				 String type = fe.getMimeType().toLowerCase();
				 //TODO: GIF not working
				 if(fe.getTitle().endsWith(".png") || type.contains( "png" ) || type.contains( "gif" )){
					 BufferedImage bufferedImage = ImageIO.read(is);
					 BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
							 bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
					 newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
					 ximage = new PDJpeg(doc, newBufferedImage ); 
				 }
				 else if( type.contains( "jpg" ) || type.contains( "jpeg" ))
				 {
					 ximage = new PDJpeg(doc, is );
				 }
				 else if (type.contains("tif") || type.contains("tiff"))
				 {
					 ximage = new PDCcitt(doc, new RandomAccessFile(new File(fileEntryId),"r"));
				 }
				 else
				 {
					// PDStream pdStream = new PDStream(doc,fe.getContentStream());
					 //ximage = new PDPixelMap(pdStream);
				 }
				 ximage.setHeight(imageHeight);
				 ximage.setWidth(imageWidth);
			 }
		 }catch(Exception ex){
		 }
         return ximage;
	}
	
	public static void generateReport(String path,List<Map<String,String>> list) throws IOException,
			COSVisitorException {
		Map<String,Float>header = getHeaderMap();
		
		float pageMargin = 10;
		final float rowHeight = 18f;
		int fontSize = 8;
		final float cellMargin = 3f;
		final float rowMargin = 7f;

		PDType1Font boldFont = PDType1Font.HELVETICA_BOLD;
		PDDocument doc = new PDDocument();
		PDPage page = new PDPage();
		Map<String,String>row ;
		final float y = page.findMediaBox().getWidth() - 45;
		float texty = y;
		float calculatedRowHeight = y-(rowHeight + 2*rowMargin);
		float textx;
		PDPageContentStream contentStream  =  null;
		int index = 0;
		PDXObjectImage ximage = null;
		List<PDXObjectImage> imageList = new ArrayList<PDXObjectImage>();
		if(Validator.isNull(list) || list.isEmpty()){
			doc.addPage(page);
			contentStream = new PDPageContentStream(doc, page);
			contentStream.setFont(boldFont, 9);
			contentStream.beginText();
			contentStream.moveTextPositionByAmount(150, 750);
			contentStream.drawString("No records");
			contentStream.endText();
		}else{
			for (int i = 0; i < list.size(); i++) {
				row = list.get(i);
				ximage = getImage(doc, row.get(TrademarksConstants.TRADEMARK_LOGO_COLUMN));
				imageList.add(ximage);
			}
			while(true){
				if(index >= list.size()){
					break;
				}
				row = list.get(index);
				
				if(Validator.isNull(contentStream)){
					Object[]result  = createPage(doc,header, boldFont, fontSize, pageMargin,  cellMargin, rowHeight) ;
					page = (PDPage) result[0];
					contentStream = (PDPageContentStream) result[1];
					calculatedRowHeight = y-(rowHeight + 2*rowMargin);
				}
				textx = pageMargin + cellMargin;
				texty = calculatedRowHeight - rowMargin ;
				calculatedRowHeight = checkHeightOrRenderRow(row,header, textx, texty, fontSize,cellMargin, boldFont, rowHeight, contentStream,page, false);
				if(calculatedRowHeight > 20){
					ximage = imageList.get(index);
					if(ximage != null){
						contentStream.drawImage(ximage, textx, texty-10);
						checkHeightOrRenderRow(row,header, textx, texty, fontSize,cellMargin, boldFont, rowHeight, contentStream, page,true);
					}else{
						checkHeightOrRenderRow(row,header, textx, texty, fontSize,cellMargin, boldFont, rowHeight, contentStream, page,true);
					}
						
					index = index + 1;
				}else{
					contentStream.close();
					contentStream = null;//createPage(doc,header, boldFont, fontSize, pageMargin,  cellMargin, rowHeight); 
				}
			}
			
		}
		
		if(Validator.isNotNull(contentStream)){
			contentStream.close();
		}
		doc.save(path);
		doc.close();
	}
	
	private static Object[] createPage(PDDocument doc,Map<String,Float>header,PDType1Font boldFont,int fontSize,float pageMargin, 
			float cellMargin,float rowHeight) throws IOException{

		PDPage page = new PDPage(PDPage.PAGE_SIZE_A4);
		page.setRotation(90);
		doc.addPage(page);
		PDPageContentStream contentStream = new PDPageContentStream(doc, page);
		contentStream.concatenate2CTM(0, 1, -1, 0, page.findMediaBox().getWidth(), 0);
		contentStream.setFont(boldFont, fontSize);
		final float tableWidth = page.findMediaBox().getHeight() - (2 * pageMargin);
		final float y = page.findMediaBox().getWidth() - 30;
		float textx = pageMargin + cellMargin;
		float texty = y - 15;
		contentStream.drawLine(pageMargin, y, pageMargin + tableWidth, y);
		for(String name: header.keySet()){
			float width = header.get(name);
			contentStream.beginText();
			contentStream.moveTextPositionByAmount(textx, texty);
			if(name.equals(TrademarksConstants.REGISTRATION_NO_COLUMN)){
				contentStream.drawString("Registration");
				contentStream.endText();
				texty -= 9;
				textx += 10;
				contentStream.beginText();
				contentStream.moveTextPositionByAmount(textx, texty);
				contentStream.drawString("Number");
				texty += 9; 
				textx -= 10;
			}else if(name.equals(TrademarksConstants.CONTENTIOUS_PROCEEDINGS_COLUMN)){
				contentStream.drawString("Contentious");
				contentStream.endText();
				texty -= 9;
				contentStream.beginText();
				contentStream.moveTextPositionByAmount(textx, texty);
				contentStream.drawString("Proceedings");
				texty += 9;
			}
			else{
				contentStream.drawString(GetterUtil.getString(name));
			}
			contentStream.endText();
			textx += width + cellMargin;
		}
		float nexty = y - (rowHeight + 9  );
		contentStream.drawLine(pageMargin, nexty, pageMargin + tableWidth, nexty);

		Object []result= new Object[2];
		result[0] = page;
		result[1] = contentStream;
		return result;
	}
	
	private static float checkHeightOrRenderRow(Map<String,String>row,Map<String,Float>header,float textx,float texty,float fontSize,float cellMargin,
			PDType1Font boldFont,float rowHeight,PDPageContentStream contentStream,PDPage page,boolean drawData) throws IOException{
		float calculatedRowHeight = texty - rowHeight ;
		for(String name: row.keySet()){
			if(name.equals(TrademarksConstants.DETAILS_LINK)){
				continue;
			}
			if(!name.equals(TrademarksConstants.TRADEMARK_LOGO_COLUMN)){
				String text = GetterUtil.getString(row.get(name));
				float cellWidth = header.get(name);
				float availbleArea = (cellWidth * 1000)/fontSize;
				int startPoint = 0;
				if(boldFont.getStringWidth(text) > availbleArea ){
					int length = text.length();
					float tempTexty = texty;
					while(startPoint < length){
						for(int counter = length  ; counter >= startPoint; counter --){
							String subStr = text.substring(startPoint,counter);
							float subStrArea = boldFont.getStringWidth(subStr);
							if(subStrArea <= availbleArea){
								if(drawData){
									contentStream.beginText();
									contentStream.moveTextPositionByAmount(textx, tempTexty);
									contentStream.drawString(subStr);
									contentStream.endText();
								}
								tempTexty -= 9;
								startPoint = counter;
								break;
							}
						}
					}
					if(calculatedRowHeight > tempTexty){
						calculatedRowHeight = tempTexty;
					}
				}else{
					if(drawData){
						if(name.equals(TrademarksConstants.DETAILS)){
							List annotations = page.getAnnotations();
							PDBorderStyleDictionary borderULine = new PDBorderStyleDictionary();
							borderULine.setStyle(PDBorderStyleDictionary.STYLE_UNDERLINE);
							borderULine.setWidth(5);
							
							PDAnnotationLink txtLink = new PDAnnotationLink();
						//	txtLink.setBorderStyle(borderULine);
							PDActionURI action = new PDActionURI();
							action.setURI(row.get(TrademarksConstants.DETAILS_LINK));
							txtLink.setAction(action);
							
							PDRectangle position = new PDRectangle();
							position.setLowerLeftX(page.findMediaBox().getWidth() - (texty + 8));
							position.setUpperRightX(page.findMediaBox().getWidth() + 5 - texty);
							position.setLowerLeftY(805);  // down a couple of points
							position.setUpperRightY(830); 
						
							
							txtLink.setRectangle(position);
							annotations.add(txtLink);
							contentStream.setNonStrokingColor(Color.BLUE);
							contentStream.beginText();
							contentStream.moveTextPositionByAmount(textx, texty);
							contentStream.drawString(GetterUtil.getString(text));
							contentStream.endText();
							contentStream.setNonStrokingColor(Color.BLACK);
						}else{
							contentStream.beginText();
							contentStream.moveTextPositionByAmount(textx, texty);
							contentStream.drawString(GetterUtil.getString(text));
							contentStream.endText();
						}
						
					}
				}
			}
			textx += header.get(name) + cellMargin;
		}
		return calculatedRowHeight;
	}
	
	private static Map<String,Float> getHeaderMap(){
		Map<String,Float> map = new LinkedHashMap<String, Float>();
		map.put(TrademarksConstants.TRADEMARK_LOGO_COLUMN,85f);
		map.put(TrademarksConstants.COUNTRY_COLUMN, 60f);
		map.put(TrademarksConstants.REGISTERED_OWNER_COLUMN, 100f);
		map.put(TrademarksConstants.APPLICATION_NO_COLUMN, 85f);
		map.put(TrademarksConstants.REGISTRATION_NUMBER_COLUMN_1, 85f);
		map.put(TrademarksConstants.STATUS_COLUMN, 40f);
		map.put(TrademarksConstants.APPLICATION_DATE_COLUMN, 70f);
		map.put(TrademarksConstants.EXPIRY_DATE_COLUMN,70f);
		map.put(TrademarksConstants.CLASS_COLUMN, 40f);
		map.put(TrademarksConstants.CONTENTIOUS_PROCEEDINGS_COLUMN,85f);
		map.put(TrademarksConstants.VERSION,40f);
		map.put(TrademarksConstants.DETAILS,40f);
		
		return map;
	}
	

	private static List<Map<String,String>> prepareData(){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		//map.put(TrademarksConstants.TRADEMARKS_ID, "12345");
		Map<String,String> map;
		for(int i=0;i < 50 ;i++){
		
		/*	map = new LinkedHashMap<String, String>();
			map.put(TrademarksConstants.TRADEMARK_LOGO_COLUMN,"moon.jpg");
			map.put(TrademarksConstants.COUNTRY_COLUMN,"India" + i);
			map.put(TrademarksConstants.REGISTERED_OWNER_COLUMN, "ABC Corporation");
			map.put(TrademarksConstants.APPLICATION_NO_COLUMN, "Application ");
			map.put(TrademarksConstants.REGISTRATION_NUMBER_COLUMN_1, "TradeMarks ");
			map.put(TrademarksConstants.STATUS_COLUMN, "Active");
			map.put(TrademarksConstants.APPLICATION_DATE_COLUMN, "21-DEC-2014");
			map.put(TrademarksConstants.RENEWAL_DATE_COLUMN,"20-DEC-2024");
			map.put(TrademarksConstants.CLASS_COLUMN,"32");
			map.put(TrademarksConstants.CONTENTIOUS_PROCEEDINGS_COLUMN,"12345, 6789, 12342");
			map.put(TrademarksConstants.VERSION,"7.0");
			map.put(TrademarksConstants.DETAILS,"Details");
			list.add(map); */
			
			 map = new LinkedHashMap<String, String>();
			 if(i%4 == 0){
				 map.put(TrademarksConstants.TRADEMARK_LOGO_COLUMN,"ina.jpeg");
			 }
			 if(i%4 == 1){
				 map.put(TrademarksConstants.TRADEMARK_LOGO_COLUMN,"destiny.png");
			 } 
			 if(i%4 == 2){
				 map.put(TrademarksConstants.TRADEMARK_LOGO_COLUMN,"File-BMP-icon.png");
			 } 
			 if(i%4 == 3){
				 map.put(TrademarksConstants.TRADEMARK_LOGO_COLUMN,"paypal.jpeg");
			 }
			 
				map.put(TrademarksConstants.COUNTRY_COLUMN,"India" + i);
				map.put(TrademarksConstants.REGISTERED_OWNER_COLUMN, "ABC kjyuiiiw saf asdf aa sdfasf as asfasf asfa fsaf asfrtrwti[iafasf ad afasfdaf urwCorporation");
				map.put(TrademarksConstants.APPLICATION_NO_COLUMN, "Application 01012sa sdafasf 1asdf");
				map.put(TrademarksConstants.REGISTRATION_NUMBER_COLUMN_1, "TradeMarks 12afasdf345");
				map.put(TrademarksConstants.STATUS_COLUMN, "Activesaf asdf as asfasfasdfsadf asfsa");
				map.put(TrademarksConstants.APPLICATION_DATE_COLUMN, "21-DEC-2014");
				map.put(TrademarksConstants.EXPIRY_DATE_COLUMN,"20-DEC-2024");
				map.put(TrademarksConstants.CLASS_COLUMN,"32");
				map.put(TrademarksConstants.CONTENTIOUS_PROCEEDINGS_COLUMN,"12345, 6789, 12342");
				map.put(TrademarksConstants.VERSION,"7.0");
				map.put(TrademarksConstants.DETAILS,"Details"); 
				map.put(TrademarksConstants.DETAILS_LINK,"https://www.youtube.com/watch?v=ZFlsu_cvVRI"); 
				list.add(map);  
		}
		return list;
	}
}
