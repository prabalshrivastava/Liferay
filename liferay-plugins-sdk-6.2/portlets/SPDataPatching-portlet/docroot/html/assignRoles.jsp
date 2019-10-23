<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:actionURL var="uploadURL" name="assignRoles">
</portlet:actionURL>
<style>
.sqls = {
margin: 50px !important;
font-size : 15px !important;
}
</style>
<aui:form name="assignRolesForm" action="<%=uploadURL%>" enctype="multipart/form-data">
			
			<aui:fieldset>
				 <aui:input name="filesToUpload"
								id="filesToUpload" type="file"
								accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
				  <div class="form_CTA_submit">
				 	 <aui:button type="submit" name="assignRoles" id="assignRoles"  
						value="Assign Roles" label="" />
				  </div>
			</aui:fieldset>
				
				<p class="sqls" style="font-size: 14px;">
				${usersNotFound }
				</p>
				<p class="sqls" style="font-size: 14px;">
				<p class="sqls" style="font-size: 14px;">
				${erors }
				</p>
				<p class="sqls" style="font-size: 14px;">
				${log }
				</p>
</aui:form>