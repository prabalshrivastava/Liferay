package com.sambaash.platform.portlet.spevent.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;

import com.sambaash.platform.srv.rsvp.NoSuchRsvpException;
import com.sambaash.platform.srv.rsvp.model.Rsvp;
import com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail;
import com.sambaash.platform.srv.rsvp.service.RsvpCoParticipantDetailLocalServiceUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;

import java.math.BigInteger;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.xpath.XPathAPI;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
public class ExcelUtil {

	private static Log _log = LogFactoryUtil.getLog(ExcelUtil.class);

	public static String getFilePath(String id, String targetExtension) {
		StringBundler sb = new StringBundler(5);

		sb.append(SystemProperties.get(SystemProperties.TMP_DIR));
		sb.append("/liferay/");
		sb.append(id);
		sb.append(StringPool.PERIOD);
		sb.append(targetExtension);

		return sb.toString();
	}

	public String createExcel(List<Object> objectList, Rsvp rsvp, String includeCo) throws NoSuchRsvpException, SystemException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dynamicSection = rsvp.getDynamicSectionName();
		String xmlString = StringPool.BLANK;
		Map<String, String> dynamicSectionNode = null;
		try {
			List<com.liferay.portal.model.PortletPreferences> portletPref = PortletPreferencesLocalServiceUtil
					.getPortletPreferenceses(-1, -1);

			for (com.liferay.portal.model.PortletPreferences pPref : portletPref) {
				String pId = pPref.getPortletId();

				if (pId.contains("UserProfile_WAR_UserProfileportlet")) {
					xmlString = pPref.getPreferences();
					boolean relatedDynamicSection = getVisibleNodes(dynamicSection, xmlString, "preference");

					if (relatedDynamicSection) {
						dynamicSectionNode = getVisibleNodes(xmlString, "preference");
						break;
					}
				}
			}
		} catch (Exception e) {
			_log.error("prefernces node " + e.getMessage());
		}

		/** new form fields added -- by Harini**/

		UserProfileUtil profileUtil = new UserProfileUtil();
		Map<String, String> RsvpDynamicSectionNode = null;
		try {
			List<com.liferay.portal.model.PortletPreferences> rsvpportletPref = PortletPreferencesLocalServiceUtil
					.getPortletPreferenceses(-1, -1);

			for (com.liferay.portal.model.PortletPreferences pPref : rsvpportletPref) {
				String pId = pPref.getPortletId();

				if (pId.contains("RSVP_WAR_SPEventportlet")) {
					String rsvpXmlString = pPref.getPreferences();

					if (rsvpXmlString.contains(rsvp.getTitle())) {
						RsvpDynamicSectionNode = profileUtil.getRSVPVisibleNodes(rsvpXmlString, "preference");
					}
				}
			}
		} catch (Exception e) {
			_log.error("prefernces node " + e.getMessage());
		}

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("RSVP Attendence");
		HSSFCellStyle styleAmount = workbook.createCellStyle();
		HSSFCellStyle styleNumberic = workbook.createCellStyle();
		styleAmount.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		styleNumberic.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
		sheet.createFreezePane(0, 1, 0, 1);
		Font headerFont = workbook.createFont();
		headerFont.setFontHeightInPoints((short) 10);
		headerFont.setFontName("Arial Narrow");
		headerFont.setColor(HSSFColor.WHITE.index);

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(HSSFColor.BLACK.index);
		headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		headerStyle.setFont(headerFont);
		headerStyle.setBorderBottom(CellStyle.BORDER_THIN);
		headerStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		headerStyle.setBorderLeft(CellStyle.BORDER_THIN);
		headerStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		headerStyle.setBorderRight(CellStyle.BORDER_THIN);
		headerStyle.setRightBorderColor(HSSFColor.BLACK.index);
		headerStyle.setBorderTop(CellStyle.BORDER_THIN);
		headerStyle.setTopBorderColor(HSSFColor.BLACK.index);

		int i = 0;
		int numberOfColumns = 0;

		for (Object object : objectList) {
			Object[] objectArray = (Object[])object;

			BigInteger rsvpPaymentId = (BigInteger)objectArray[0];
			String firstName = (String)objectArray[1];
			String lastName = (String)objectArray[2];
			String emailAddress = (String)objectArray[3];
			int attendance = (Integer)objectArray[4];
			int numberOfPeople = (Integer)objectArray[5];
			String transactionId = (String)objectArray[6];
			double amount = (Double)objectArray[7];
			Date transactionDate = (Date)objectArray[8];
			String userInfo = (String)objectArray[9];

			//			BigInteger rsvpDetailId = (BigInteger) objectArray[10]; // this value is not displayed in excel

			BigInteger rsvpDetailId = (BigInteger)objectArray[10];
			String ticketNumber = (String)objectArray[11];
			String promoCode = (String)objectArray[12];

			/** new form fields added -- by Harini**/
			String gender = StringPool.BLANK;
			String ageGroup = StringPool.BLANK;
			String identificationType = StringPool.BLANK;
			String nric = StringPool.BLANK;
			String streetAddress1 = StringPool.BLANK;
			String streetAddress2 = StringPool.BLANK;
			String city = StringPool.BLANK;
			String state = StringPool.BLANK;
			String postalCode = StringPool.BLANK;
			String country = StringPool.BLANK;
			String address = StringPool.BLANK;
			String phoneNumber1 = StringPool.BLANK;
			String phoneNumber2 = StringPool.BLANK;
			String phoneNumber = StringPool.BLANK;
			String hearAboutUs = StringPool.BLANK;
			String attendedWebinar = StringPool.BLANK;
			boolean addressFlag = false;
			boolean phoneFlag = false;

			if (rsvp.isPaymentFlag()) {
				if (Validator.isNotNull(userInfo)) {
					XMLManipulator manipulator = new XMLManipulator(userInfo);

					if (i == 0) {
						int j = 0;
						HSSFRow rowA = sheet.createRow(i);

						if (StringPool.TRUE.equalsIgnoreCase(includeCo)) {
							HSSFCell cellA1 = rowA.createCell(j++);
							cellA1.setCellValue(new HSSFRichTextString("Ticket Number"));
							cellA1.setCellStyle(headerStyle);
							HSSFCell cellA2 = rowA.createCell(j++);
							cellA2.setCellValue(new HSSFRichTextString("Promo Code"));
							cellA2.setCellStyle(headerStyle);
						}

						HSSFCell cellA = rowA.createCell(j++);
						cellA.setCellValue(new HSSFRichTextString("RSVP Payment Id"));
						cellA.setCellStyle(headerStyle);
						HSSFCell cellH = rowA.createCell(j++);
						cellH.setCellValue(new HSSFRichTextString("Transaction Date"));
						cellH.setCellStyle(headerStyle);
						HSSFCell cellB = rowA.createCell(j++);
						cellB.setCellValue(new HSSFRichTextString("Name"));
						cellB.setCellStyle(headerStyle);
						HSSFCell cellC = rowA.createCell(j++);
						cellC.setCellValue(new HSSFRichTextString("Email Address"));
						cellC.setCellStyle(headerStyle);

						if(Validator.isNotNull(RsvpDynamicSectionNode)){
							Set<Map.Entry<String, String>> Rsvpset = RsvpDynamicSectionNode.entrySet();
							for (Map.Entry<String, String> node : Rsvpset) {
								String nodeName = node.getKey();
	
								if (nodeName.equalsIgnoreCase("genderFlag")) {
									HSSFCell cellHX = rowA.createCell(j++);
									cellHX.setCellValue(new HSSFRichTextString("Gender"));
									cellHX.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("ageGroupFlag")) {
									HSSFCell cellHQ = rowA.createCell(j++);
									cellHQ.setCellValue(new HSSFRichTextString("Age Group"));
									cellHQ.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("identificationTypeFlag")) {
									HSSFCell cellHR = rowA.createCell(j++);
									cellHR.setCellValue(new HSSFRichTextString("Identification Type"));
									cellHR.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("identificationNumberFlag")) {
									HSSFCell cellHS = rowA.createCell(j++);
									cellHS.setCellValue(new HSSFRichTextString("Identification Number"));
									cellHS.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("streetAddress1Flag")) {
									HSSFCell cellHT = rowA.createCell(j++);
									cellHT.setCellValue(new HSSFRichTextString("Address1"));
									cellHT.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("streetAddress2Flag")) {
									HSSFCell cellHT1 = rowA.createCell(j++);
									cellHT1.setCellValue(new HSSFRichTextString("Address2"));
									cellHT1.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("cityFlag")) {
									HSSFCell cellHT2 = rowA.createCell(j++);
									cellHT2.setCellValue(new HSSFRichTextString("City"));
									cellHT2.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("stateFlag")) {
									HSSFCell cellHT3 = rowA.createCell(j++);
									cellHT3.setCellValue(new HSSFRichTextString("State"));
									cellHT3.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("postalCodeFlag")) {
									HSSFCell cellHT4 = rowA.createCell(j++);
									cellHT4.setCellValue(new HSSFRichTextString("Postal Code"));
									cellHT4.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("countryFlag")) {
									HSSFCell cellHT5 = rowA.createCell(j++);
									cellHT5.setCellValue(new HSSFRichTextString("Country"));
									cellHT5.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("phoneNumber1Flag")) {
									HSSFCell cellHU = rowA.createCell(j++);
									cellHU.setCellValue(new HSSFRichTextString("Contact no1."));
									cellHU.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("phoneNumber2Flag")) {
									HSSFCell cellHU1 = rowA.createCell(j++);
									cellHU1.setCellValue(new HSSFRichTextString("Contact no2."));
									cellHU1.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("phoneNumber1Flag")) {
								}
	
								if (nodeName.equalsIgnoreCase("hearAboutUsFlag")) {
									HSSFCell cellHV = rowA.createCell(j++);
									cellHV.setCellValue(new HSSFRichTextString("Hear AboutUs"));
									cellHV.setCellStyle(headerStyle);
								}
	
								if (nodeName.equalsIgnoreCase("attendedWebinarFlag")) {
									HSSFCell cellHW = rowA.createCell(j++);
									cellHW.setCellValue(new HSSFRichTextString("Attended Webinar"));
									cellHW.setCellStyle(headerStyle);
								}
							}
						}	

						if (!dynamicSection.isEmpty()) {
							Set<Map.Entry<String, String>> set = dynamicSectionNode.entrySet();
							for (Map.Entry<String, String> node : set) {
								HSSFCell cell = rowA.createCell(j++);
								cell.setCellValue(new HSSFRichTextString(node.getValue()));
								cell.setCellStyle(headerStyle);
							}
						}

						HSSFCell cellD = rowA.createCell(j++);
						cellD.setCellValue(new HSSFRichTextString("PayPal Id"));
						cellD.setCellStyle(headerStyle);
						HSSFCell cellE = rowA.createCell(j++);
						cellE.setCellValue(new HSSFRichTextString("Number of people"));
						cellE.setCellStyle(headerStyle);
						HSSFCell cellF = rowA.createCell(j++);
						cellF.setCellValue(new HSSFRichTextString("Net Total"));
						cellF.setCellStyle(headerStyle);
						HSSFCell cellG = rowA.createCell(j++);
						cellG.setCellValue(new HSSFRichTextString("Attended"));
						cellG.setCellStyle(headerStyle);

						numberOfColumns = j;
					}

					int k = 0;
					HSSFRow rowB = sheet.createRow(++i);

					if (StringPool.TRUE.equalsIgnoreCase(includeCo)) {
						HSSFCell cellI1 = rowB.createCell(k++);
						cellI1.setCellValue(ticketNumber);
						HSSFCell cellI2 = rowB.createCell(k++);
						cellI2.setCellValue(promoCode);
					}

					HSSFCell cellI = rowB.createCell(k++);
					cellI.setCellValue(rsvpPaymentId.doubleValue());
					HSSFCell cellP = rowB.createCell(k++);
					cellP.setCellValue(dateFormat.format(transactionDate));
					HSSFCell cellJ = rowB.createCell(k++);
					cellJ.setCellValue(new HSSFRichTextString(firstName + StringPool.SPACE + lastName));
					HSSFCell cellK = rowB.createCell(k++);
					cellK.setCellValue(new HSSFRichTextString(emailAddress));

					if(Validator.isNotNull(RsvpDynamicSectionNode)){
						Set<Map.Entry<String, String>> Rsvpset = RsvpDynamicSectionNode.entrySet();
						for (Map.Entry<String, String> node : Rsvpset) {
							String nodeName = node.getKey();
							int rc = 0;
	
							if (nodeName.equalsIgnoreCase("genderFlag")) {
								gender = (String)objectArray[13];
								HSSFCell cellX = rowB.createCell(k++);
								cellX.setCellValue(new HSSFRichTextString(gender));
							}
	
							if (nodeName.equalsIgnoreCase("ageGroupFlag")) {
								ageGroup = (String)objectArray[14];
								HSSFCell cellQ = rowB.createCell(k++);
								cellQ.setCellValue(new HSSFRichTextString(ageGroup));
							}
	
							if (nodeName.equalsIgnoreCase("identificationTypeFlag")) {
								identificationType = (String)objectArray[15];
								HSSFCell cellR = rowB.createCell(k++);
								cellR.setCellValue(new HSSFRichTextString(identificationType));
							}
	
							if (nodeName.equalsIgnoreCase("identificationNumberFlag")) {
								nric = (String)objectArray[16];
								HSSFCell cellS = rowB.createCell(k++);
								cellS.setCellValue(new HSSFRichTextString(nric));
							}
	
							if (nodeName.equalsIgnoreCase("streetAddress1Flag")) {
								streetAddress1 = (String)objectArray[17];
								addressFlag = true;
								HSSFCell cellT = rowB.createCell(k++);
								cellT.setCellValue(new HSSFRichTextString(streetAddress1));
							}
	
							if (nodeName.equalsIgnoreCase("streetAddress2Flag")) {
								streetAddress2 = (String)objectArray[18];
								HSSFCell cellT1 = rowB.createCell(k++);
								cellT1.setCellValue(new HSSFRichTextString(streetAddress2));
							}
	
							if (nodeName.equalsIgnoreCase("cityFlag")) {
								city = (String)objectArray[19];
								HSSFCell cellT2 = rowB.createCell(k++);
								cellT2.setCellValue(new HSSFRichTextString(city));
							}
	
							if (nodeName.equalsIgnoreCase("stateFlag")) {
								state = (String)objectArray[20];
								HSSFCell cellT3 = rowB.createCell(k++);
								cellT3.setCellValue(new HSSFRichTextString(state));
							}
	
							if (nodeName.equalsIgnoreCase("postalCodeFlag")) {
								postalCode = (String)objectArray[21];
								HSSFCell cellT4 = rowB.createCell(k++);
								cellT4.setCellValue(new HSSFRichTextString(postalCode));
							}
	
							if (nodeName.equalsIgnoreCase("countryFlag")) {
								country = (String)objectArray[22];
								HSSFCell cellT5 = rowB.createCell(k++);
								cellT5.setCellValue(new HSSFRichTextString(country));
							}
	
							if (nodeName.equalsIgnoreCase("phoneNumber1Flag")) {
								phoneNumber1 = (String)objectArray[23];
								phoneFlag = true;
								HSSFCell cellU = rowB.createCell(k++);
								cellU.setCellValue(new HSSFRichTextString(phoneNumber1));
							}
	
							if (nodeName.equalsIgnoreCase("phoneNumber2Flag")) {
								phoneNumber2 = (String)objectArray[24];
								HSSFCell cellU1 = rowB.createCell(k++);
								cellU1.setCellValue(new HSSFRichTextString(phoneNumber2));
							}
	
							if (nodeName.equalsIgnoreCase("hearAboutUsFlag")) {
								hearAboutUs = (String)objectArray[25];
								HSSFCell cellV = rowB.createCell(k++);
								cellV.setCellValue(new HSSFRichTextString(hearAboutUs));
							}
	
							if (nodeName.equalsIgnoreCase("attendedWebinarFlag")) {
								attendedWebinar = (String)objectArray[26];
								HSSFCell cellW = rowB.createCell(k++);
								cellW.setCellValue(new HSSFRichTextString(attendedWebinar));
							}
						}
					}	
						
					if (!dynamicSection.isEmpty()) {
						Set<Map.Entry<String, String>> set = dynamicSectionNode.entrySet();
						for (Map.Entry<String, String> node : set) {
							HSSFCell cell = rowB.createCell(k++);
							cell.setCellValue(new HSSFRichTextString(getNode(manipulator, dynamicSection, node.getKey())));
						}
					}

					HSSFCell cellL = rowB.createCell(k++);
					cellL.setCellValue(new HSSFRichTextString(String.valueOf(transactionId)));
					HSSFCell cellM = rowB.createCell(k++);
					cellM.setCellStyle(styleNumberic);
					cellM.setCellType(Cell.CELL_TYPE_NUMERIC);
					cellM.setCellValue(numberOfPeople);
					HSSFCell cellN = rowB.createCell(k++);
					cellN.setCellStyle(styleAmount);
					cellN.setCellType(Cell.CELL_TYPE_NUMERIC);
					cellN.setCellValue(amount);
					HSSFCell cellO = rowB.createCell(k++);
					switch (attendance) {
					case 0:
						cellO.setCellValue("Not-Attended");
						break;
					case 1:
						cellO.setCellValue("Attended");
						break;
					}

					if (StringPool.TRUE.equalsIgnoreCase(includeCo)) {
						List<RsvpCoParticipantDetail> coParticipantsDetailList = RsvpCoParticipantDetailLocalServiceUtil
								.findByRsvpDetailIdAndSPRsvpPaymentId(rsvpDetailId.longValue(), rsvpPaymentId.longValue());

						for (RsvpCoParticipantDetail coParticipantsDetail : coParticipantsDetailList) {
							int ck = 0;
							HSSFRow rowCB = sheet.createRow(++i);
							HSSFCell cellCI1 = rowCB.createCell(ck++);
							cellCI1.setCellValue(coParticipantsDetail.getTicketNumber());
							HSSFCell cellCI2 = rowCB.createCell(ck++);
							cellCI2.setCellValue(promoCode);
							HSSFCell cellCI = rowCB.createCell(ck++);
							cellCI.setCellValue(coParticipantsDetail.getRsvpPaymentId());
							HSSFCell cellCP = rowCB.createCell(ck++);
							cellCP.setCellValue(dateFormat.format(transactionDate));
							HSSFCell cellCJ = rowCB.createCell(ck++);
							cellCJ.setCellValue(new HSSFRichTextString(coParticipantsDetail.getFirstName() + StringPool.SPACE + coParticipantsDetail.getLastName()));
							HSSFCell cellCK = rowCB.createCell(ck++);
							cellCK.setCellValue(new HSSFRichTextString(coParticipantsDetail.getEmailAddress()));

							if(Validator.isNotNull(dynamicSectionNode)){
								Set<Map.Entry<String, String>> set = dynamicSectionNode.entrySet();
								for (Map.Entry<String, String> node : set) {
									HSSFCell cell = rowCB.createCell(ck++);
									String nodeValue = node.getValue();
	
									if ("Identification Type".equalsIgnoreCase(nodeValue)) {
										cell.setCellValue(coParticipantsDetail.getIdentificationType());
									}else if ("Identification Number".equalsIgnoreCase(nodeValue)) {
										cell.setCellValue(coParticipantsDetail.getNric());
									}else {
										cell.setCellValue(new HSSFRichTextString(getNode(manipulator, dynamicSection, node.getKey())));
									}
								}
							}	

							HSSFCell cellCL = rowCB.createCell(ck++);
							cellCL.setCellValue(new HSSFRichTextString(String.valueOf(transactionId)));
							HSSFCell cellCM = rowCB.createCell(ck++);
							cellCM.setCellStyle(styleNumberic);
							cellCM.setCellType(Cell.CELL_TYPE_NUMERIC);
							cellCM.setCellValue(numberOfPeople);
							HSSFCell cellCN = rowCB.createCell(ck++);
							cellCN.setCellStyle(styleAmount);
							cellCN.setCellType(Cell.CELL_TYPE_NUMERIC);
							cellCN.setCellValue(amount);
							HSSFCell cellCO = rowCB.createCell(ck++);
							switch (attendance) {
							case 0:
								cellCO.setCellValue("Not-Attended");
								break;
							case 1:
								cellCO.setCellValue("Attended");
								break;
							}
						}
					}
				}
			}
		}

		for (int q = 0; q < numberOfColumns; q++) {
			sheet.autoSizeColumn(q);
		}

		String filePath = getFilePath("RsvpList-" + Calendar.getInstance().getTimeInMillis(), "xls");
		try {
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			workbook.write(fos);
		} catch (Exception e) {
			_log.error(e);
		}

		return filePath;
	}

	private boolean getVisibleNodes(String dynamicSection, String xmlString, String xPath) {
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
			_log.error(e);
		}

		return isRelatedDynamicSection;
	}

	private Map<String, String> getVisibleNodes(String xmlString, String xPath) {
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
			_log.error(e);
		}

		return nodesMap;
	}

	private String getNode(XMLManipulator manipulator, String categoryName, String nodeName) {

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

	private NodeList findNodeList(String xmlString, String xpath) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new InputSource(new StringReader(xmlString)));
		Element root = doc.getDocumentElement();

		doc = root.getOwnerDocument();
		doc.normalizeDocument();
		NodeList nodes = XPathAPI.selectNodeList(root, xpath);
		return nodes;
	}
}