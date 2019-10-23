<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sambaash.platform.srv.mail.service.SPMailCampaignLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.mail.model.SPMailCampaign"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.Validator" %>


<%@ page import="java.util.List" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
	long campaignId = GetterUtil.getLong(portletPreferences.getValue("campaignId", "0"));
	boolean displayFn = GetterUtil.getBoolean(portletPreferences.getValue("displayFn", ""));
	boolean displayLn = GetterUtil.getBoolean(portletPreferences.getValue("displayLn", ""));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<div id="formContainer">

<aui:form action="<%=configurationURL%>" method="post" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" />
 <%
	 	String OPTION = "<option value='%s' %s>%s</option>";
	 %>
	  	<aui:select name="preferences--campaignId--" label="campaign-name" required="true" >
	  	<%
	  	    List<SPMailCampaign>list = SPMailCampaignLocalServiceUtil.getSPMailCampaigns(-1, -1);
	  		for(SPMailCampaign campaign: list){
	  			String selected = "";
 	     		 if (campaignId == campaign.getSpMailCampaignId()) {
 	     			 selected = "selected";
 	     		 }
 		  		out.println(String.format(OPTION, campaign.getSpMailCampaignId(),selected,campaign.getCampaignName()));
	  		}
	  	%>
	  	</aui:select>
	  	<aui:input label="show-first-name" name="preferences--displayFn--" type="checkbox" checked="<%= displayFn %>"></aui:input>
	  	<aui:input label="show-last-name" name="preferences--displayLn--" type="checkbox" checked="<%= displayLn %>"></aui:input>
	  	<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>
</aui:form>
</div>	  	

	