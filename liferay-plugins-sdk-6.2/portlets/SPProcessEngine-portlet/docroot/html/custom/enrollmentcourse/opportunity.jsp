<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.model.PEProcessState" %>
<%@page import="com.sambaash.platform.pe.PEOutput"%>
<%@page import="com.sambaash.platform.pe.constants.PEConstants"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>

<%@ include file="/html/init.jsp" %>
<%
PEOutput output = (PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);
PEProcessState processState = output.getProcessState();
JSONObject dataJ = JSONFactoryUtil.createJSONObject(GetterUtil.getString(processState.getData()));       
String frstName = dataJ.getString("firstName");
String lastName = dataJ.getString("lastName");
String mobileNumber = dataJ.getString("mobileNumber");
String emailAddress = dataJ.getString("emailAddress");  
String residenceStatus = dataJ.getString("residenceStatus").substring(1, dataJ.getString("residenceStatus").length()-1);
JSONObject dataResidenceStatus = JSONFactoryUtil.createJSONObject(residenceStatus);
String text = dataResidenceStatus.getString("text");
String value = dataResidenceStatus.getString("value");
List<String> residenceStatusList = new ArrayList<String>();
residenceStatusList.add(text);
residenceStatusList.add(value);
%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

	
	<aui:form name="opportunity"  method="post">

	<div class="form_dropD">
				  		
					    <aui:select name="productId" label="Product" id="productId">
					    <aui:option value="-1" label="--SELECT--"/> 
					    	<c:forEach var="product" items="${products}">
								<aui:option value="${product.spProductId}"
									label="${product.productName}" />
							</c:forEach>
						
						</aui:select>
					
					
					<%-- <c:if test="${productId.selectValue != -1}"> --%>
					<iframe frameborder="0"  scrolling="no" id="opportnityIframe"
						src="https://forms.sambaash.com/formloader/index.html?Id=1079&firstName=${firstName}&lastName=${lastName}&mobile_number_3=${mobileNumber}&emailAddress=${emailAddress}&residence_status_6=${residenceStatus}">
					</iframe>
					<%--</c:if> --%>
						
	</div>

<%-- 	<div class="form_field">
		<aui:input type="text" name="country" id="country" value="${country}" label="Country" size="100" >
		</aui:input>
	</div>
	
	<div class="form_field">
		<aui:input type="text" name="yearsOfEmployment" id="yearsOfEmployment" value="${yearsOfEmployment}" label="Years of Employment" size="100" >
		</aui:input>
	</div>
	
	<div class="form_field">
		<aui:input type="text" name="highestQualification" id="highestQualification" value="${highestQualification}" label="Highest Qualification" size="100" >
		</aui:input>
	</div>
	 --%>


	</aui:form>