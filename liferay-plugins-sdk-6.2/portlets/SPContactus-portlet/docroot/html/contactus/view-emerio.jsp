<aui:script>
     var portletNameSpace = "<portlet:namespace/>";
     
     var businesslst=["divFirstName","divLastName","divLastEmail","divComment","divcomName","divPhoneNumber","divJobTitle","divWebsite","divCountry","divNoOfEmp"];
     var careerlst = ["divLocation","divFirstName","divLastName","divLastEmail","divComment","divPhoneNumber","divCountry"];
     var feedbacklst = ["divFirstName","divLastName","divLastEmail","divComment","divcomName","divCountry","divPhoneNumber","divRate","divTypeOfEnquiry"];
     var otherFeedlst = ["divFirstName","divLastName","divLastEmail","divComment","divcomName","divPhoneNumber","divCountry"];
     showTeams(document.getElementById("<portlet:namespace/>category").value);
     
     function showTeams(selectOcurrece){
     document.getElementById("idmain").innerHTML = "";
     if(selectOcurrece=="Business Enquiry"){
     	for(j=0;j < businesslst.length;j++){
     		document.getElementById("idmain").innerHTML +=  "<div class='contactusrow'>"+ document.getElementById(businesslst[j]).innerHTML + "</div>";
     	}
     	document.getElementById("lblComment").innerHTML = "Please provide details of enquiry:<font color='red'>*</font>";
	    document.getElementById("lblCountry").innerHTML = "Country:";
	    document.getElementById("buttonSave").style.display="block";
     }else if(selectOcurrece=="Career Enquiry"){
     	for(j=0;j < careerlst.length;j++){
     		document.getElementById("idmain").innerHTML +=  "<div class='contactusrow'>"+ document.getElementById(careerlst[j]).innerHTML + "</div>";
     	}
     	document.getElementById("lblComment").innerHTML = "Please list skill sets:<font color='red'>*</font>";
	    document.getElementById("lblCountry").innerHTML = "Current country of residence:";
	    document.getElementById("lblEnquiryType").innerHTML = "I would like to make a<font color='red'>*</font>";
	    document.getElementById("buttonSave").style.display="block";
     }else if(selectOcurrece=="Website Feedback"){
     	for(j=0;j < feedbacklst.length;j++){
     		document.getElementById("idmain").innerHTML +=  "<div class='contactusrow'>"+ document.getElementById(feedbacklst[j]).innerHTML + "</div>";
     	}
     	document.getElementById("lblComment").innerHTML = "Please provide your feedback:<font color='red'>*</font>";
	    document.getElementById("lblCountry").innerHTML = "Country:";
	    document.getElementById("lblEnquiryType").innerHTML = "I would like to give<font color='red'>*</font>";
	    document.getElementById("buttonSave").style.display="block";
     }else if(selectOcurrece=="Other Feedback"){
     	for(j=0;j < otherFeedlst.length;j++){
     		document.getElementById("idmain").innerHTML +=  "<div class='contactusrow'>"+ document.getElementById(otherFeedlst[j]).innerHTML + "</div>";
     	}
     	
     	document.getElementById("lblComment").innerHTML = "Please provide your feedback:<font color='red'>*</font>";
	    document.getElementById("lblCountry").innerHTML = "Country:";
	    document.getElementById("lblEnquiryType").innerHTML = "I would like to give<font color='red'>*</font>";
	    document.getElementById("buttonSave").style.display="block";
     }
     
     
     
   }
</aui:script>

<%


String subString = "";
String step = (String)renderRequest.getAttribute("step");
if(step==null){
	step = "";
}

List countriesList =CountryServiceUtil.getCountries(); 
%>

<%

String name =(String)renderRequest.getAttribute("name");

if(Validator.isNull(name)){
	name="";
}

String lastName =(String)renderRequest.getAttribute("lastName");

if(Validator.isNull(name)){
	lastName="";
}

String emailAddress = (String)renderRequest.getAttribute("emailAddress");
if(Validator.isNull(emailAddress)){
	emailAddress="";
}

String companyName = (String)renderRequest.getAttribute("companyName");
if(Validator.isNull(companyName)){
	companyName="";
}

String jobTitle = (String)renderRequest.getAttribute("jobTitle");
if(Validator.isNull(jobTitle)){
	jobTitle="";
}

String companyUrl = (String)renderRequest.getAttribute("companyUrl");
if(Validator.isNull(companyUrl)){
	companyUrl="";
}

String noOfEmployee = (String)renderRequest.getAttribute("noOfEmployee");
if(Validator.isNull(noOfEmployee)){
	noOfEmployee="";
}

String comment = (String)renderRequest.getAttribute("comment");
if(Validator.isNull(comment)){
	comment="";
}

long countryId = 0;
if(renderRequest.getAttribute("countryId")!= null) {
	countryId = Long.parseLong((String)renderRequest.getAttribute("countryId"));
}

String contactNumber = "";

if(renderRequest.getAttribute("contactNumber")!= null) {
	contactNumber = (String)renderRequest.getAttribute("contactNumber");
}

String rate = "";

if(renderRequest.getAttribute("rate")!= null) {
	rate = (String)renderRequest.getAttribute("rate");
}

String typeOfEnquiry = "";

if(renderRequest.getAttribute("typeOfEnquiry")!= null) {
	typeOfEnquiry = (String)renderRequest.getAttribute("typeOfEnquiry");
}

String typeOfLooking = "";

if(renderRequest.getAttribute("typeOfLooking")!= null) {
	typeOfLooking = (String)renderRequest.getAttribute("typeOfLooking");
}

String emLocationOffice = "";

if(renderRequest.getAttribute("emLocationOffice")!= null) {
	emLocationOffice = (String)renderRequest.getAttribute("emLocationOffice");
}

%>

<%
PortletURL pu= renderResponse.createRenderURL();
pu.setWindowState(WindowState.NORMAL);
pu.setParameter("struts_action","/contact_us/view");


%>




<body class="contactus-background" onload="javascript:showTeams(1);">
<div class="tablecontent" style="width:100%;">
<tr>
<!-- <td class="contactusleft" valign="top">

<div class=Section1>


<%= subString %>

</div>

</td> -->



<%
if("".equals(step))
{
%>


	<liferay-ui:success key="Success" message="Successful! Your password has been changed."></liferay-ui:success>
	<liferay-ui:error exception="<%= Exception.class %>" message="Sorry, error" />
	<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="Text verification failed" />
	<liferay-ui:error exception="<%= ContactUsNameException.class %>" message="&nbsp;<font color='red'>*</font>&nbsp;indicated fields should not be empty." />
	<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="Please enter a valid email address" />
	<liferay-ui:error exception="<%= ContactUsCategoryException.class %>" message="Please select a valid category" />
	<liferay-ui:error exception="<%= ContactUsCommentException.class %>" message="Please enter a valid comments" />
	<liferay-ui:error exception="<%= ContactUsCountryException.class %>" message="Please select a valid Country" />
	<liferay-ui:error exception="<%= ContactUsContactNumberException.class %>" message="Please enter a valid Contact Number" />

<span class="contactus-requiredField"><font class="errorfont">* </font>indicates a required field</span>
<br>

<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>">
		          <portlet:param name="struts_action" value="/contact_us/view" />
     	 	  </portlet:actionURL>" class="uni-form" method="post" name="<portlet:namespace />fm">
     	 	  
 <div class="contactusrow">
	
	<div class="leftcontactusrow" id="lblEnquiryType">I would like to make a <font class="errorfont">*</font></div>
	<div class="rightcontactusrow">
		<aui:select name="category" id="category" onchange="javascript:showTeams(this.value);" label="">
		    <%
		    for(int i=0;i<lstCategories.size();i++){  
		    	AssetCategory item = lstCategories.get(i);
		    	
		    	if(category.equals(item.getName())){
		    %>
		    <aui:option selected="true" value="<%=item.getName()%>"><%=item.getName()%></aui:option>         
		    <%}else{

		    %>
		    <aui:option value="<%=item.getName()%>"><%=item.getName()%></aui:option> 
		    <%
		    	
		    }}%>
		    
		</aui:select>
	</div>	
</div>

 <div id="idmain" style="width:100%;clear:both;display:block;">
 
 </div>
<div id="tempcontent" style="display:none;">   	 	  

	<div class="contactusrow" id="divFirstName">
		
		<div class="leftcontactusrow">First Name:<font class="errorfont">*</font></div>
		<div class="rightcontactusrow"><input type="text" name="<portlet:namespace />name" id="name" value="<%=name %>" class="contactus-input-field" /></div>
	</div>

	<div class="contactusrow" id="divLastName">
		
		<div class="leftcontactusrow">Last Name:<font class="errorfont">*</font></div>
		<div class="rightcontactusrow"><input type="text" name="<portlet:namespace />lastName" id="lastName" value="<%=lastName %>" class="contactus-input-field" /></div>
	</div>


	<div class="contactusrow" id="divLastEmail">
		
		<div class="leftcontactusrow">Email:<font class="errorfont">*</font></div>
		<div class="rightcontactusrow"><input type="text" name="<portlet:namespace />emailAddress" id="emailAddress" value="<%=emailAddress%>" class="contactus-input-field" /></div>
	</div>

	<div class="contactusrow" id="divComment">
		
			<div class="leftcontactusrow" id="lblComment"><font class="errorfont">*</font></div>
			<div class="rightcontactusrow"><textarea name="<portlet:namespace />comment" id="comment" class="contactus-textarea-field"><%=comment%></textarea></div>
	</div>
	
	<div class="contactusrow" id="divPhoneNumber">
		
		<div class="leftcontactusrow">Phone Number:</div>
		<div class="rightcontactusrow"><input type="text" name="<portlet:namespace />contactNumber" id="contactNumber" class="contactus-input-field" value="<%=contactNumber%>"/></div>
	</div>

	<div class="contactusrow" id="divCountry">
		
		<div class="leftcontactusrow" id="lblCountry">Country</div>
		<div class="rightcontactusrow">
			<% 
				if ( countriesList != null){
				
					%>
						<select name="<portlet:namespace />countryId" id="countryId" class="contactus-select-field">
						<option value="0"> </option>
						<% for (int i = 0; i < countriesList.size()-1; i++) {
							Country countryObj =(Country) countriesList.get(i);
							
						%>
							<option value="<%= countryObj.getCountryId() %>" <%if(countryObj.getCountryId()==countryId) out.print("selected=\"selected\""); %>><%= countryObj.getName() %></option>
				
						<% } %>
						</select>
				
						<br>
					<% } %>
				              
		</div>
		</div>


	<div class="contactusrow" id="divcomName">
		<div class="leftcontactusrow">Company Name:<font class="errorfont">*</font></div>
		<div class="rightcontactusrow">
			<input type="text" name="<portlet:namespace />companyName" id="companyName" value="<%=companyName%>" class="contactus-input-field" />
		</div>
	</div>

	<div class="contactusrow" id="divJobTitle">
		
		<div class="leftcontactusrow">Job Title:</div>
		<div class="rightcontactusrow">
			<input type="text" name="<portlet:namespace />jobTitle" id="jobTitle" value="<%=jobTitle%>" class="contactus-input-field" />
		</div>
	</div>

	<div class="contactusrow" id="divWebsite">
		
		<div class="leftcontactusrow">Company Website/URL:</div>
		<div class="rightcontactusrow">
			<input type="text" name="<portlet:namespace />companyUrl" id="companyUrl" value="<%=companyUrl%>" class="contactus-input-field" />
		</div>
	</div>

	<div class="contactusrow" id="divNoOfEmp">
		
		<div class="leftcontactusrow">Number of Employees:</div>
		<div class="rightcontactusrow">
			<input type="text" name="<portlet:namespace />noOfEmployee" id="noOfEmployee" value="<%=noOfEmployee%>" class="contactus-input-field" />
		</div>
	</div>	

	<div class="contactusrow" id="divLocation">
	
		<div class="leftcontactusrow">Location of Emerio office <font class="windowBrowser"> for which you are seeking employment:</font></div>
		<div class="rightcontactusrow">
			<aui:select name="emLocationOffice" id="emLocationOffice" label="">
			    <%
			    for(AssetCategory item : lstLocation){   
			    %>
			    <aui:option selected="<%= true %>" value="<%=item.getName()%>"><%=item.getName()%></aui:option>         
			    <%}%>
			</aui:select>
		</div>	
	</div>
	
	<div class="contactusrow" id="divRate">
	
		<div class="leftcontactusrow">Please rate our website:</div>
		<div class="rightcontactusrow">
		
			<select name="<portlet:namespace />rate" id="rate" class="contactus-select-field">
					<option value="0"> Select-- </option>
					<option value="Average"> Average</option>
					<option value="Good"> Good</option>
					<option value="Excellent"> Excellent</option>
			</select>
		</div>
	</div>
	
	<div class="contactusrow" id="divTypeOfEnquiry">
	
		<div class="leftcontactusrow">Did you find what you are
looking for?</div>
		<div class="rightcontactusrow">
		
			<select name="<portlet:namespace />typeOfEnquiry" id="typeOfEnquiry" class="contactus-select-field">
					<option value="0"> Select-- </option>
					<option value="Yes"> Yes</option>
					<option value="Partially"> Partially</option>
					<option value="No"> No</option>
			</select>
		</div>
	</div>
	

</div>


<div class="contactusrow" style="float: right;margin: 6px;display:none;" id="buttonSave">

	<input type="submit" value="Submit" name="<portlet:namespace />submit" class="contactussubmit" style="float:right;"/>

</div>


   	 	  

</form>

<%
}else{
%>


<div id="part2" align="center">
<p class="contactus-process-message"><b>Your comments are sent.</b></p>
<p class="contactus-process-message"><b>We will contact you shortly.</b></p>
</div>

<%
}
%>

</div>

</body>

