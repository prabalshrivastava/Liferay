package com.sambaash.platform.startupprofile.reports;

import java.io.File;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.util.SambaashUtil;

public abstract class ReportGenerator {
	
	private static Log _log = LogFactoryUtil.getLog(ReportGenerator.class);
	
	public static ReportGenerator getPdfGenerator(String type) {
		String pdfReportBase = SambaashUtil.getParameter(
				"pdfReportBase", 0);
		pdfReportBase = Validator.isNull(pdfReportBase)? "/usr/portalv62/tomcat-7.0.42/webapps/StartupProfile-portlet/reports" : pdfReportBase;
	//	
	//	pdfReportBase = "/Volumes/Development/master/master.sambaash.platform.003/liferay-plugins-sdk-6.1.0/portlets/StartupProfile-portlet/docroot/reports";
		_log.debug("Using pdfReportBase = " + pdfReportBase);
		return new PdfGenerator( pdfReportBase);
	}

	public static ReportGenerator getExcelGenerator() {
		return null;
	}

	public abstract void generateReport(ReportPayload payload, File file)
			throws Exception;

}
