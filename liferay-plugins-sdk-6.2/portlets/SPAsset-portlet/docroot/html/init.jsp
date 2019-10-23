<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@
taglib	uri="/tld/sp-ui" prefix="sp-ui"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="com.sambaash.platform.srv.spasset.model.SPAssetType"%>
<%@ page import="com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeImpl"%>
<%@ page import="com.sambaash.platform.srv.spasset.service.SPAssetTypeLocalServiceUtil"%>
	
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List" %>
<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="java.util.Hashtable"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>


<portlet:defineObjects />
<liferay-theme:defineObjects />

	<%--  <link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css" media="all"> --%>
	 <link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" type="text/css" media="all">
	 <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" media="all">
	 

<script src="<%=request.getContextPath()%>/js/common.js"></script>

 