package com.sambaash.platform.portlet.legalandcontract.reports;

import java.io.File;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.util.SambaashUtil;

public abstract class ReportGenerator {
	
	public static final String TRADEMARK_LISTING = "Trademark List";
	public static final String TRADEMARK_DETAILS = "Trademark Details";
	public static final String LITIGATION_LISTING = "Litigation List";
	public static final String LITIGATION_DETAILS = "Litigation Details";

	public static ReportGenerator getPdfGenerator(String type, String rootTag, ThemeDisplay themeDisplay) {
		String pdfReportBase = SambaashUtil.getParameter(
				"pdfReportBase", themeDisplay.getCompanyGroupId());
		pdfReportBase = Validator.isNull(pdfReportBase)? "/Volumes/Development/master62/master.sambaash.platform.004/liferay-plugins-sdk-6.2/portlets/LegalAndContract-portlet/docroot/reports" : pdfReportBase;
	//	
//		pdfReportBase = "/Volumes/Development/master62/master.sambaash.platform.004/liferay-plugins-sdk-6.2.0/portlets/LegalAndContract-portlet/docroot/reports";
	//	pdfReportBase = "/Volumes/Development/master62/master.sambaash.platform.004/liferay-plugins-sdk-6.2/portlets/LegalAndContract-portlet/docroot/reports";
		return new PdfGenerator(type, rootTag, pdfReportBase);
	}

	public static ReportGenerator getExcelGenerator() {
		return new ExcelGenerator();
	}

	public abstract void generateReport(ReportPayload payload, File file)
			throws Exception;

}
