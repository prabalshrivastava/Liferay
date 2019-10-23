<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalService"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessLocalService"%>
<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcess"%>
<%@page import="com.liferay.portal.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.ClassName"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@ include file="/html/init.jsp" %>

<%  
long vocId = GetterUtil.getLong(portletPreferences.getValue("linkedFilterVocId", "0"));
long specializationVocId = GetterUtil.getLong(portletPreferences.getValue("specializationVocId", "0"));
String type = GetterUtil.getString(portletPreferences.getValue("type", "Single"));
String detialsPage = GetterUtil.getString(portletPreferences.getValue("detailPageName", ""));
String levelsData = GetterUtil.getString(portletPreferences.getValue("levelsData", "[]"));
String ivdFiltersData = GetterUtil.getString(portletPreferences.getValue("ivdFiltersData", "[]"));
if(Validator.isNull(levelsData)){
	levelsData = "[]";
}
if(Validator.isNull(ivdFiltersData)){
	ivdFiltersData = "[]";
}

boolean enableLinkedFilter = GetterUtil.getBoolean(portletPreferences.getValue("enableLinkedFilter", "false"));
boolean enableIvdFilter = GetterUtil.getBoolean(portletPreferences.getValue("enableIvdFilter", "false"));

%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<div id="formContainer">

<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit="levelObj.onSubmit();">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="preferences--levelsData--" type="hidden" value="" />
	<aui:input name="preferences--ivdFiltersData--" type="hidden" value="" />
		 <% 
		     	 String OPTION = "<option value='%s' %s>%s</option>";
		  %>
	 <div>
	    <!-- Preference control goes here -->
		  <aui:input name="preferences--detailPageName--" type="text" value="<%= detialsPage %>" required="true" label="detail-page-name"></aui:input>
		  <aui:select name="preferences--specializationVocId--" label="specialization-voc">
				  <%
				  	  out.println("<option></option>");
				  	  List<AssetVocabulary> vocbList = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
				  	  for(AssetVocabulary vocb :vocbList){
				  		 String selected = "";
			     		 if(specializationVocId == vocb.getVocabularyId() ) {
			     			 selected = "selected";
			     		 }
				  		out.println(String.format(OPTION, vocb.getVocabularyId(),selected, vocb.getName()));
				  	  }
				  %>
		  </aui:select>
		  <div>
		      <div>Configure Linked Filter</div>
			  <aui:input name="preferences--enableLinkedFilter--" label="enable-linked-filter" type="checkbox" checked="<%= enableLinkedFilter %>"></aui:input>
			  <aui:select name="preferences--linkedFilterVocId--" label="voc-id" required="true" onChange="">
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
					   <div class="inline"><input type="text" id="name" placeholder="Level Name"/></div>
					   <div class="inline">
					   		<select id="type">
					   			<option value="single">Single</option>
					   			<option value="multiple">Multiple</option>
					   		</select>
					   </div>
					   <span id="displayHeaderContainer"><input type="checkbox"  id="displayHeader"/>Display Header</span>
					   <input type="checkbox"  id="displayAll"/>Display All
				</div>
			</div>
		</div>
		<div>
		   <div>Configure Individual filters</div>
		   <aui:input name="preferences--enableIvdFilter--" label="enable-ivd-filter" type="checkbox" checked="<%= enableIvdFilter %>"></aui:input>
		   <a href="javascript:;" id="addFilter">Add Filter</a>
		   <div id="filtersContainer">
		   
		   </div>
		</div>
		<div class="hide">
			<div id="sampleFilter">
				<input type="text" id="name" placeholder="Filter Name"/>
				<select id="filterVocId">
				  <%
				  	  //out.println("<option></option>");
				  	  List<AssetVocabulary> vocbList = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
				  	  for(AssetVocabulary vocb :vocbList){
				  		out.println(String.format(OPTION, vocb.getVocabularyId(),"", vocb.getName()));
				  	  }
				  %>
				</select>
				<select id="type">
					   			<option value="single">Single</option>
					   			<option value="multiple">Multiple</option>
				</select>
				<span id="displayHeaderContainer"><input type="checkbox"  id="displayHeader"/>Display Header</span>
				<input type="checkbox"  id="displayAll"/>Display All
				<a href="javascript:;" id="remove">Remove</a>
			</div>
		</div>
	    
    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" />
        
    </aui:button-row>
</aui:form>
</div>
<liferay-portlet:resourceURL portletName="${param.portletResource}" var="ajaxUrl">
</liferay-portlet:resourceURL>
<script src="/SPLinkedFilterSearch-portlet/js/config.js"></script>
<script>
var A;
var levelObj = null;
AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated','stylesheet',function(A1){
	A = A1;
	var pns ="<portlet:namespace/>";
	var ajaxUrl = "<%= ajaxUrl %>";
	levelObj = new linkedSearchConfig({pns:pns, ajaxUrl:ajaxUrl,levelsData:<%=levelsData%>,ivdFiltersData:<%= ivdFiltersData %>});
});
</script>



