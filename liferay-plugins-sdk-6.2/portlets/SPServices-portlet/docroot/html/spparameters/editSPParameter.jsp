<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sambaash.platform.srv.spservices.model.SPParameter" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<liferay-ui:error key="spparameters.name.update.error" message="Enter a different name. The name has to be unique for each Group ID." />
<liferay-ui:error key="spparameters.add.error" message='<%= LanguageUtil.get(pageContext,"error.while.adding.spparameter")%>' />

<portlet:resourceURL var="resourceURL" id="myResourceID01" />
<portlet:actionURL var="updateSPParameterActionURL" name="updateSPParameter">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<style>
<!--
.hide{ 
display: none;
}
-->
</style>


<div>
 	<span class="form_Title ${showhideSpan1}" style="font-weight: bold;">UPDATE SPPARAMETER</span>
 	<span class="form_Title ${showhideSpan2}" style="font-weight: bold;">ADD SPPARAMETER</span>
	
	<aui:form name="updateSPParameterForm" action="<%=updateSPParameterActionURL%>" method="post">
	
	<br/>
		<aui:model-context bean="${spparameter}" model="<%= SPParameter.class %>" />
		<aui:fieldset>
			<div class="form_fieldset_wrap">
				
				<div class="form_field ${showhide}">
					<aui:input type="text" name="spparameterId" value="${spparameterId}" label="SPParameter ID" size="100" disabled="true">
				    </aui:input>
			    </div>
			    
			    <div class="form_field">
					<aui:input type="hidden" name="spparameterId" id="spparameterId" value="${spparameterId}">
				    </aui:input>
				</div>
				
				<div class="form_dropD">
				  		
					    <aui:select name="groupId" label="Group">
					     <c:forEach var="listEntry" items="${groups}">
								<aui:option value="${listEntry}"
									selected="${groupId == listEntry}" 
									label="${listEntry}" />
							</c:forEach>
						
						</aui:select>
					</div>
			    
			    <div class="form_field">
					<aui:input type="text" name="name" id="name" value="${name}" label="Name" size="100" required="true">
				    </aui:input>
			    </div>
			    
			    <div class="form_field">
					<aui:input type="text" name="value" id="value" value="${value}" label="Value" size="100">
				    </aui:input>
			    </div>
				<br>
				<div class="form_CTA">
					<aui:button-row>
						<aui:button value="Submit" id="submitUpdateSpParameter" class="submit" />
						<aui:button type="cancel" id='cancel' onClick="<%= viewURL %>"/>
					</aui:button-row>
				</div>
			</div>
		</aui:fieldset>
</aui:form>
</div>


<script>
var pns = '<portlet:namespace/>';
try{
	initSubmitSPParameterForm(pns,'submitUpdateSpParameter','updateSPParameterForm');
}catch(error){
	console.log(error);
}

</script>


