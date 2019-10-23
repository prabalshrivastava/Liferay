<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<liferay-ui:error key="spparameters.name.update.error" message="Enter a different name. The name has to be unique for each Group ID." />
<liferay-ui:error key="spparameters.add.error" message='<%= LanguageUtil.get(pageContext,"error.while.adding.spparameter")%>' />

<style>
<!--
.addStyle{ 
text-align:right;
font-size: 20px;
}
-->
</style>


<portlet:actionURL var="searchSPParameterActionURL"  name="searchSPParameter">
</portlet:actionURL>

<span class="form_Title" style="font-weight: bold; font-size: 25pt"><%= LanguageUtil.get(pageContext,"SP PARAMETERS")%></span><br><br><br>

	
	
	<aui:form name="searchSPParameter" action="<%=searchSPParameterActionURL%>"  method="post">
	<aui:row>
	<aui:col span="2">
	
	<div class="form_field">
		<aui:input type="text" name="nameValue" id="nameValue" value="${nameValue}" label="Search Text" size="100" >
		</aui:input>
	</div>
	
	</aui:col>
	
	<aui:col span="2">
	<div class="form_dropD">
				  		
					    <aui:select name="groupId" label="Group">
					    <aui:option value="-1" label="--SELECT--"/> 
					    	<c:forEach var="listEntry" items="${groups}">
								<aui:option value="${listEntry}"
									selected="${groupId == listEntry}" 
									label="${listEntry}" />
							</c:forEach>
						
						</aui:select>
	</div>
	</aui:col>

	<aui:col span="2">
	<aui:button-row>
		<aui:button type="submit" name="searchSPParameter" id="searchSPParameter" value="Search" label=""/>
		</aui:button-row>
	</aui:col>
	<aui:col span="4">
	</aui:col>
	
	<aui:col span="2">
	<div class="esn_addSPParameter">
	
		<aui:fieldset>
			<p class="addStyle"> <a href='${displayAddSPParameterURL}' title="Add SPParameter" id="addSPParameter"><b>Add</b></a></p>
					
		</aui:fieldset>
	</div>
	</aui:col>
	</aui:row>
	</aui:form>


<div>
<liferay-ui:search-iterator searchContainer="${searchContainer}" />
</div>

