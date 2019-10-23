<%@ page import="com.sambaash.platform.pe.error.PEErrors" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.sambaash.platform.util.LabelUtil"%>
<%@ include file="/html/init.jsp" %>

<liferay-ui:error key="config.error" message="<%= PEErrors.CONIG_ERROR_REGISTER_PAGE.toString() %>" />
<liferay-ui:error key="config.process.state.list.error" message="<%= PEErrors.CONIG_ERROR_PROCESS_STATE_LISTING_PAGE.toString() %>" />
<liferay-ui:error key="system.error" message="<%= PEErrors.SYSTEM_ERROR.toString() %>" />
<liferay-ui:error key="unsupported.device.error" message="unsupported.device.error.msg" />
<liferay-ui:error key="temp.storage.validation.error" message="<%= PEErrors.TEMP_STORAGE_VALIDATION_ERROR.toString() %>" />

