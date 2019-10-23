package com.sambaash.platform.pe.helpers;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.sambaash.platform.model.microservicemodel.ProgrammeModel;
import com.sambaash.platform.pe.error.PEErrors;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.processbuilder.model.PEDummyEntity;

public class PEJSPDisplayHelper {

	private static final String PAYMENT_JSP = "/html/custom/payment/payment.jsp";

	public PEJSPDisplayHelper(PortletRequest request) {
		this.request = request;
	}

	public String getJspPath(long classNameId, String jspId) throws PEException {
		if (Validator.isNull(jspId)) {
			_log.error("Jsp id is null");
			throw new PEException(PEErrors.JSP_PATH_NOT_FOUND);
		}
		// long classNameId =
		// (Long)request.getAttribute(PEConstants.ATTR_CLASS_NAME_ID);
		String path = StringPool.BLANK;
		ClassName cn;
		try {
			cn = ClassNameLocalServiceUtil.getClassName(classNameId);
			jspId = jspId.replace(" ", "");
			path = "payment".equals(jspId) ? PAYMENT_JSP : getFolderPath(cn.getClassName()) + "/" + jspId + ".jsp";
		} catch (PortalException | SystemException e) {
			_log.error("Error while resolving jsp path ", e);
		}

		return path;
	}

	private String getFolderPath(String className) throws PEException {
		String prefix = "/html/custom/";
		String folderName = jspPaths.get(className);

		if (Validator.isNull(folderName)) {
			throw new PEException(PEErrors.JSP_PATH_NOT_FOUND);
		}

		return prefix + folderName;
	}

	private static Log _log = LogFactoryUtil.getLog(PEJSPDisplayHelper.class);
	private static Map<String, String> jspPaths = new HashMap<String, String>();
	static {

		// for product type, enrollmentcourse is the folder name and it's path
		// is /html/custom/enrollmentcourse

		jspPaths.put(Product.class.getName(), "enrollmentcourse");
		jspPaths.put(PEDummyEntity.class.getName(), "enrollmentcourse");
		jspPaths.put(ProgrammeModel.class.getName(), "enrollmentcourse");
	}

	private PortletRequest request;

}
