package com.sambaash.platform.audit.listeners;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.spservices.model.SPAudit;
import com.sambaash.platform.srv.spservices.service.SPAuditLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

public class AuditHelper {

	public SPAudit createAudit() throws SystemException{
		SPAudit audit = SPAuditLocalServiceUtil.create();
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
		SambaashUtil.fillAudit(audit, serviceContext.getThemeDisplay(), audit.isNew());
		audit.setDoneByUserId(themeDisplay.getUserId());
		return audit;
	}
	
	public String getJson(Object obj) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	 
}
