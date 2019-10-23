<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />


<liferay-portlet:actionURL portletConfiguration="true" var="fixPermissionURL" />
	
<%  
long vocId = GetterUtil.getLong(portletPreferences.getValue("vocIdSpecialization", "0"));
String levelsData = GetterUtil.getString(portletPreferences.getValue("levelsData", "{}"));
if(Validator.isNull(levelsData)){
	levelsData = "{}";
}
String registerPageUrl = GetterUtil.getString(portletPreferences.getValue("registerPageUrl", ""));
boolean downloadBrochure = GetterUtil.getBoolean(portletPreferences.getValue("downloadBrochure", ""));
String downloadBrochureUrl = GetterUtil.getString(portletPreferences.getValue("downloadBrochureUrl", ""));
boolean showInventory = GetterUtil.getBoolean(portletPreferences.getValue("showInventory", ""));
long personaVocId = GetterUtil.getLong(portletPreferences.getValue("personaVocIdSpecialization", "0"));
boolean showFeeComponent = GetterUtil.getBoolean(portletPreferences.getValue("showFeeComponent", ""));
boolean showPersona = GetterUtil.getBoolean(portletPreferences.getValue("showPersona", ""));
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<div id="formContainer">

<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit="levelObj.onSubmit()">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="preferences--levelsData--" type="hidden" value="" />

    <!-- Preference control goes here -->
	 <% 
	     	 String OPTION = "<option value='%s' %s>%s</option>";
	  %>
		<!-- Persona -->
		<aui:select name="preferences--personaVocIdSpecialization--" label="pVoc-id-specialization" required="true" onChange="">
		  <%
		  	  out.println("<option></option>");
		  	  List<AssetVocabulary> pVocbList = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
		  	  for(AssetVocabulary pVocb :pVocbList){
		  		 String selected = "";
	     		 if(personaVocId == pVocb.getVocabularyId() ) {
	     			 selected = "selected";
	     		 }
		  		out.println(String.format(OPTION, pVocb.getVocabularyId(),selected, pVocb.getName()));
		  	  }
		  %>
		</aui:select>
		
		<!-- Specialization -->
	  	<aui:select name="preferences--vocIdSpecialization--" label="voc-id-specialization" required="true" onChange="">
		  <%
		  	  out.println("<option></option>");
		  	  List<AssetVocabulary> vocbList = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
		  	  for(AssetVocabulary vocb :vocbList){
		  		 String selected = "";
	     		 if(vocId == vocb.getVocabularyId() ) {
	     			 selected = "selected";
	     		 }
		  		out.println(String.format(OPTION, vocb.getVocabularyId(),selected, vocb.getName()));
		  	  }
		  %>
		</aui:select>
		
		<div id="levelsContainer">
			
		</div>
		
		<div id="sampleLevel" class="hide">
			   <input type="hidden" id="levelNo" />
			   <span id="levelSpan"></span>
			   <input type="checkbox" id="includeLevel"/>
		</div>
		<br>
		<div>
		<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.config.message")%>
		   <aui:input name="preferences--registerPageUrl--" type="text" value="<%= registerPageUrl %>" />
		</div>
		
		<div>
	  		 <aui:input label="show-sidemenu-feeComponent" name="preferences--showFeeComponent--" type="checkbox" checked="<%= showFeeComponent %>"/>
	  	</div>
	  	
	  	<!-- Show Persona -->
	  	<div>
	  		 <aui:input label="show-persona" name="preferences--showPersona--" type="checkbox" checked="<%= showPersona %>"/>
	  	</div>
	  	
		
		<!-- Download Brochure -->
	  	<div>
	  		 <aui:input label="download-brochure" name="preferences--downloadBrochure--" type="checkbox" checked="<%= downloadBrochure %>"/>
	  	</div>
	  	
	  	<div>
		   <aui:input label="label.product.downloadBrochure.url" name="preferences--downloadBrochureUrl--" type="text" value="<%= downloadBrochureUrl %>" />
		</div>
		
		<!-- Show Inventory -->
		
		<div>
		   <aui:input label="label.product.ShowInventory" name="preferences--showInventory--"  type="checkbox" checked="<%= showInventory %>" />
		</div>
	    
    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" />
        
    </aui:button-row>
</aui:form>
</div>
<liferay-portlet:resourceURL portletName="${param.portletResource}" var="ajaxUrl">
</liferay-portlet:resourceURL>

<div id="permButtonContainer">


		<aui:button-row>
			<aui:button type="submit" cssClass="btn btn-primary" value="permission.button" onClick="javascript:fixPermission('${ajaxUrl}');"/>
		</aui:button-row>

</div>

<script src="/SPProduct-portlet/js/config.js"></script>
<script>
var A;
var levelObj = null;
AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated','stylesheet',function(A1){
	A = A1;
	var pns ="<portlet:namespace/>";
	var ajaxUrl = "<%= ajaxUrl %>";
	var errorMsg = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.maximum.vocabulary.message")%>';
	levelObj = new ProductConfig({pns:pns, ajaxUrl:ajaxUrl,errorMsg:errorMsg,levelsData:<%=levelsData%>});
});


	

	function fixPermission(url) {
		var contentId = 'permButtonContainer';
		//preloader
		startPreLoader(contentId);
		var data = {};
		data.action = "fixPermission";
		AUI().use('aui-node', 'aui-io-request', 'liferay-util-window',
				'aui-io-plugin-deprecated', 'stylesheet', function(A1) {
					A.io.request(url, {
						dataType : 'json',
						method : 'POST',
						data : data,
						on : {
							complete : function() {
								// this is called before success and failure methods. So right place for any post processing of request.
								stopPreLoader(contentId);
							},
							success : function() {
								var data = this.get('responseData');

								if (data) {
									alert(data);
								}

							},
							failure : function() {
							}
						}
					});
				});
	}
</script>



