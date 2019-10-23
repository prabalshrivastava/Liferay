package com.sambaash.platform.spperiscopedata.util;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.SystemProperties;

public class FinanceReportExcelUtil {

	private static Log _log = LogFactoryUtil.getLog(FinanceReportExcelUtil.class);

	public static String getFilePath(String id, String targetExtension) {
		StringBundler sb = new StringBundler(5);

		sb.append(SystemProperties.get(SystemProperties.TMP_DIR));
		sb.append("/liferay/");
		sb.append(id);
		sb.append(StringPool.PERIOD);
		sb.append(targetExtension);

		return sb.toString();
	}

	public String createExcel(List<Object> objectList,String reportType) throws SystemException, IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet sheet = workbook.createSheet("Financial Report " + reportType);
		//sheet.protectSheet("qwert");
		XSSFCellStyle styleAmount = workbook.createCellStyle();
		XSSFCellStyle styleNumberic = workbook.createCellStyle();
		XSSFDataFormat format = workbook.createDataFormat();
		styleAmount.setDataFormat(format.getFormat("0.00"));
		styleNumberic.setDataFormat(format.getFormat("0"));
		sheet.createFreezePane(0, 1, 0, 1);
		Font headerFont = workbook.createFont();
		headerFont.setFontHeightInPoints((short) 10);
		headerFont.setFontName("Arial Narrow");
		headerFont.setColor(IndexedColors.WHITE.getIndex());
		short BLACK = IndexedColors.BLACK.getIndex();	
		XSSFCellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(BLACK);
		headerStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		headerStyle.setFont(headerFont);
		headerStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		headerStyle.setBottomBorderColor(BLACK);
		headerStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		headerStyle.setLeftBorderColor(BLACK);
		headerStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
		headerStyle.setRightBorderColor(BLACK);
		headerStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
		headerStyle.setTopBorderColor(BLACK);

		int i = 0;
		int numberOfColumns = 0;

		for (Object object : objectList) {
			Object[] objectArray = (Object[])object;

			BigInteger applicationId = (BigInteger)objectArray[0];
			String productName = (String)objectArray[1];
			String firstName = (String)objectArray[2];
			String lastName = (String)objectArray[3];
			String emailAddress = (String)objectArray[4];
			double registerationFee = 0;
			String registerationFeeDate = "NA";
			String prpCorseFeeDate = "NA";
			String plTestFeeDate = "NA";
			double plTestFee = 0;
			double prpCorseFee = 0;
			String stripeIdReg = "NA";
			String registerationFeeOnline = "0";
			String stripeIdPlc = "NA";
			String plTestFeeOnline = "0";
			String stripeIdPrp = "NA";
			String prpCorseFeeOnline = "0";
			if(reportType.equalsIgnoreCase("Offline")){
				registerationFee = (Double)objectArray[5];
				_log.error("excel sheet generated registerationFee " + registerationFee);
				registerationFeeDate = (String)objectArray[6];
				plTestFee = (Double)objectArray[7];
				plTestFeeDate = (String)objectArray[8];
				prpCorseFee = (Double)objectArray[9];
				prpCorseFeeDate = (String)objectArray[10];
			}

			if(reportType.equalsIgnoreCase("online")){
				stripeIdReg = (String) objectArray[5];
				registerationFeeOnline = (String)objectArray[6];
				registerationFeeDate = (String)objectArray[7];
				stripeIdPlc = (String) objectArray[8];
				plTestFeeOnline = (String)objectArray[9];
				plTestFeeDate = (String)objectArray[10];
				stripeIdPrp = (String) objectArray[11];
				prpCorseFeeOnline = (String)objectArray[12];
				prpCorseFeeDate = (String)objectArray[13];
			}
			

					if (i == 0) {
						int j = 0;
						XSSFRow rowA = sheet.createRow(i);

						XSSFCell cellA = rowA.createCell(j++);
						cellA.setCellValue(new XSSFRichTextString("Application Id"));
						cellA.setCellStyle(headerStyle);
						XSSFCell cellB = rowA.createCell(j++);
						cellB.setCellValue(new XSSFRichTextString("Product Name"));
						cellB.setCellStyle(headerStyle);
						XSSFCell cellC = rowA.createCell(j++);
						cellC.setCellValue(new XSSFRichTextString("First Name"));
						cellC.setCellStyle(headerStyle);

						XSSFCell cellD = rowA.createCell(j++);
						cellD.setCellValue(new XSSFRichTextString("Last Name"));
						cellD.setCellStyle(headerStyle);
						XSSFCell cellE = rowA.createCell(j++);
						cellE.setCellValue(new XSSFRichTextString("Email Address"));
						cellE.setCellStyle(headerStyle);
						if(reportType.equalsIgnoreCase("Offline")){
							XSSFCell cellF = rowA.createCell(j++);
							cellF.setCellValue(new XSSFRichTextString("Registration Fee"));
							cellF.setCellStyle(headerStyle);
							XSSFCell cellF1 = rowA.createCell(j++);
							cellF1.setCellValue(new XSSFRichTextString("Registration Fee - Capture Date"));
							cellF1.setCellStyle(headerStyle);
							XSSFCell cellG = rowA.createCell(j++);
							cellG.setCellValue(new XSSFRichTextString("Placement Test Fee"));
							cellG.setCellStyle(headerStyle);
							XSSFCell cellG1 = rowA.createCell(j++);
							cellG1.setCellValue(new XSSFRichTextString("Placement Test Fee - Capture Date"));
							cellG1.setCellStyle(headerStyle);
							XSSFCell cellH = rowA.createCell(j++);
							cellH.setCellValue(new XSSFRichTextString("Preparation Course Fee"));
							cellH.setCellStyle(headerStyle);
							XSSFCell cellH1 = rowA.createCell(j++);
							cellH1.setCellValue(new XSSFRichTextString("Preparation Course Fee - Capture Date"));
							cellH1.setCellStyle(headerStyle);
						}
						
						if(reportType.equalsIgnoreCase("online")){
							XSSFCell cellF = rowA.createCell(j++);
							cellF.setCellValue(new XSSFRichTextString("Stripe Id (Registration Fee)"));
							cellF.setCellStyle(headerStyle);
							XSSFCell cellG = rowA.createCell(j++);
							cellG.setCellValue(new XSSFRichTextString("Registration Fee"));
							cellG.setCellStyle(headerStyle);
							XSSFCell cellG1 = rowA.createCell(j++);
							cellG1.setCellValue(new XSSFRichTextString("Registration Fee - Payment Date"));
							cellG1.setCellStyle(headerStyle);
							XSSFCell cellH = rowA.createCell(j++);
							cellH.setCellValue(new XSSFRichTextString("Stripe Id (Placement Test Fee)"));
							cellH.setCellStyle(headerStyle);
							XSSFCell cellI = rowA.createCell(j++);
							cellI.setCellValue(new XSSFRichTextString("Placement Test Fee"));
							cellI.setCellStyle(headerStyle);
							XSSFCell cellI1 = rowA.createCell(j++);
							cellI1.setCellValue(new XSSFRichTextString("Placement Test Fee - Payment Date"));
							cellI1.setCellStyle(headerStyle);
							XSSFCell cellJ = rowA.createCell(j++);
							cellJ.setCellValue(new XSSFRichTextString("Stripe Id (Preparation Course Fee)"));
							cellJ.setCellStyle(headerStyle);
							XSSFCell cellK = rowA.createCell(j++);
							cellK.setCellValue(new XSSFRichTextString("Preparation Course Fee"));
							cellK.setCellStyle(headerStyle);
							XSSFCell cellK1 = rowA.createCell(j++);
							cellK1.setCellValue(new XSSFRichTextString("Preparation Course Fee - Payment Date"));
							cellK1.setCellStyle(headerStyle);
							
						}

						numberOfColumns = j;
					}

					int k = 0;
					XSSFRow rowB = sheet.createRow(++i);

					XSSFCell cellL = rowB.createCell(k++);
					cellL.setCellValue(String.valueOf(applicationId));
					XSSFCell cellM = rowB.createCell(k++);
					cellM.setCellValue(productName);
					XSSFCell cellN = rowB.createCell(k++);
					cellN.setCellValue(new XSSFRichTextString(firstName));
					XSSFCell cellO = rowB.createCell(k++);
					cellO.setCellValue(new XSSFRichTextString(lastName));
					XSSFCell cellP = rowB.createCell(k++);
					cellP.setCellValue(emailAddress);
					
					if(reportType.equalsIgnoreCase("Offline")){
					XSSFCell cellQ = rowB.createCell(k++);
					cellQ.setCellStyle(styleAmount);
					cellQ.setCellType(Cell.CELL_TYPE_NUMERIC);
					cellQ.setCellValue(registerationFee);
					XSSFCell cellQ1 = rowB.createCell(k++);
					cellQ1.setCellValue(registerationFeeDate);
					XSSFCell cellR = rowB.createCell(k++);
					cellR.setCellStyle(styleAmount);
					cellR.setCellType(Cell.CELL_TYPE_NUMERIC);
					cellR.setCellValue(plTestFee);
					XSSFCell cellR1 = rowB.createCell(k++);
					cellR1.setCellValue(plTestFeeDate);
					XSSFCell cellS = rowB.createCell(k++);
					cellS.setCellStyle(styleAmount);
					cellS.setCellType(Cell.CELL_TYPE_NUMERIC);
					cellS.setCellValue(prpCorseFee);
					XSSFCell cellS1 = rowB.createCell(k++);
					cellS1.setCellValue(prpCorseFeeDate);
					}
					
					if(reportType.equalsIgnoreCase("online")){
						XSSFCell cellT = rowB.createCell(k++);
						cellT.setCellStyle(styleAmount);
						cellT.setCellType(Cell.CELL_TYPE_NUMERIC);
						cellT.setCellValue(stripeIdReg);
						XSSFCell cellU = rowB.createCell(k++);
						cellU.setCellStyle(styleAmount);
						cellU.setCellType(Cell.CELL_TYPE_NUMERIC);
						cellU.setCellValue(registerationFeeOnline);
						XSSFCell cellU1 = rowB.createCell(k++);
						cellU1.setCellValue(registerationFeeDate);
						XSSFCell cellV = rowB.createCell(k++);
						cellV.setCellStyle(styleAmount);
						cellV.setCellType(Cell.CELL_TYPE_NUMERIC);
						cellV.setCellValue(stripeIdPlc);
						XSSFCell cellW = rowB.createCell(k++);
						cellW.setCellStyle(styleAmount);
						cellW.setCellType(Cell.CELL_TYPE_NUMERIC);
						cellW.setCellValue(plTestFeeOnline);
						XSSFCell cellW1 = rowB.createCell(k++);
						cellW1.setCellValue(plTestFeeDate);
						XSSFCell cellX = rowB.createCell(k++);
						cellX.setCellStyle(styleAmount);
						cellX.setCellType(Cell.CELL_TYPE_NUMERIC);
						cellX.setCellValue(stripeIdPrp);
						XSSFCell cellY = rowB.createCell(k++);
						cellY.setCellStyle(styleAmount);
						cellY.setCellType(Cell.CELL_TYPE_NUMERIC);
						cellY.setCellValue(prpCorseFeeOnline);
						XSSFCell cellY1 = rowB.createCell(k++);
						cellY1.setCellValue(prpCorseFeeDate);
						}
		}

		for (int q = 0; q < numberOfColumns; q++) {
			sheet.autoSizeColumn(q);
		}

		String filePath = getFilePath("Finance Report " + reportType + "-" + Calendar.getInstance().getTimeInMillis(), "xlsx");
		try {
			FileOutputStream fos1 = new FileOutputStream(filePath);
			//workbook.writeProtectWorkbook(Biff8EncryptionKey.getCurrentUserPassword(), "");
			workbook.write(fos1);
		} catch (Exception e) {
			_log.error(e);
		}
		_log.error("excel sheet generated");
		//Add password protection and encrypt the file
        POIFSFileSystem fs = new POIFSFileSystem();
        _log.error("excel sheet generated EncryptionInfo");
        debugClassLoader(EncryptionMode.class);
       EncryptionInfo info = new EncryptionInfo(fs, EncryptionMode.agile);
       _log.error("excel sheet generated Encryptor");
        Encryptor enc = info.getEncryptor();
        _log.error("excel sheet generated Encryptor1");
        enc.confirmPassword("s3cr3t");
        _log.error("excel sheet generated confirmPassword");
 
        OPCPackage opc;
		try {
			opc = OPCPackage.open(new File(filePath), PackageAccess.READ_WRITE);
			 OutputStream os = enc.getDataStream(fs);
		        opc.save(os);
		        opc.close();
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
 
        FileOutputStream fos = new FileOutputStream(filePath);
        fs.writeFilesystem(fos);
        workbook.write(fos);
        fos.close();

		return filePath;
	}
	
	private void debugClassLoader(Class<?> clazz) {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		String debugMsgPattern = "[CHILD] %s loaded from: %s";
		_log.error(String.format(debugMsgPattern, clazz.getSimpleName(), cl.getResource(clazz.getName().replace(".", "/")+".class")));	
		debugParentClassLoader(cl.getParent(), clazz);
	}

	private void debugParentClassLoader(ClassLoader parentCl, Class<?> clazz) {
		String debugMsgPattern = "[PARENT] %s loaded from: %s";
		_log.error(String.format(debugMsgPattern, clazz.getSimpleName(), parentCl.getResource(clazz.getName().replace(".", "/")+".class")));		
	}

}