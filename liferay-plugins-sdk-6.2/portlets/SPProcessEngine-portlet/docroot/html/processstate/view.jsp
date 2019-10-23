<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.sambaash.platform.constant.FormConstants"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil"%>
<%@page import="com.sambaash.platform.constant.PEConstantsGlobal"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.sambaash.platform.portlet.pe.helper.ProcessStateSearchHelper"%>
<%@page import="com.sambaash.platform.pe.helpers.PEProcessHelper"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcessStage"%>
<%@page import="com.sambaash.platform.pe.helpers.ProcessBuilderHelper"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.sambaash.platform.pe.permissions.PermissionsUtil"%>
<%@ include file="/html/init.jsp" %>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcess"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="javax.servlet.jsp.PageContext"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="com.sambaash.platform.pe.PEEntityClassRegister"%>
<%@ page import="com.sambaash.platform.srv.processbuilder.service.PEProcessLocalService" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.model.PEProcess" %>
<%@ page import="com.liferay.portal.service.ClassNameLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.ClassName" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>

<%
JSONObject prefs = ProcessStateSearchHelper.getStateListingConfiguration(renderRequest);

String userType = GetterUtil.getString(ProcessStateSearchHelper.getPreference(prefs, PEConstants.PREF_USER_TYPE, "0"));
String userId = String.valueOf(themeDisplay.getUser().getUserId());

boolean displayActiveStatusDD = GetterUtil.getBoolean(ProcessStateSearchHelper.getPreference(prefs, PEConstants.PREF_DISPLAY_ACTIVE_STATUS, ""));
boolean displayEntityDD = GetterUtil.getBoolean(ProcessStateSearchHelper.getPreference(prefs, PEConstants.PREF_DISPLAY_ENTITY_FILTER, ""));
boolean changeStatusPref = GetterUtil.getBoolean(ProcessStateSearchHelper.getPreference(prefs, PEConstants.PREF_DISPLAY_CHANGE_STATUS, ""));
boolean hasAssignPerm = PermissionsUtil.hasAssignPermission(themeDisplay); 
boolean hasClosePerm = PermissionsUtil.hasApplicationClosePermission(themeDisplay);
long[] processIds = ProcessStateSearchHelper.getPrefrencesIdsArray(prefs, PEConstants.PREF_PROCESS_IDS);
long[] stageIds = ProcessStateSearchHelper.getPrefrencesIdsArray(prefs, PEConstants.PREF_STAGE_IDS);
long[] dealStatusIds = ProcessStateSearchHelper.getPrefrencesIdsArray(prefs, PEConstants.PREF_DEAL_STATUS_IDS);
boolean hasSearchSectionPerm = PermissionsUtil.hasSearchSectionPermission(themeDisplay);
boolean hasChangeStatusPerm = PermissionsUtil.hasApplicationChangeStatusPermission(themeDisplay);
boolean hasBulkuploadPerm = PermissionsUtil.hasBulkUploadPermission(themeDisplay);

String formDataParam = SambaashUtil.getParameter(PEConstants.SP_PARAM_PE_PEOCESS_FORM_DATA, 0);
String formDataUrlParam = SambaashUtil.getParameter(PEConstants.SP_PARAM_PE_PEOCESS_FORM_LIST_URL, 0);


Date now = Calendar.getInstance().getTime();
Date firstEnabledDate = Calendar.getInstance().getTime();
Date lastEnabledDate = Calendar.getInstance().getTime();

firstEnabledDate.setYear(now.getYear() - 10);
lastEnabledDate.setYear(now.getYear() + 10);

String modelName  = GetterUtil.getString((String)request.getAttribute("sp-formio:Listing:modelName"));
%>

<style type="text/css">
.aui body.yui3-skin-sam .yui3-widget-mask {
    background-color: #3d3d3d;
}
.aui .modal {
   
    background-color: whitesmoke;
  
}
.aui .modal-header {
    padding: 9px 15px;
    border-bottom: 0px solid #eee; 
}
.aui .modal-header h3 {   
  margin: 0;
    line-height: 30px;
    font-size: 11pt;
    text-align: center;
    padding: 0 0 10px;
    border-bottom: 1px solid #ddd;
 }

.aui .modal-body select {
    width: 100%;
    margin-bottom: 15px;
}

.aui .modal-footer {
text-align:center;
}

.enrollmentRow {
    text-align: center;
}

</style>

<div class="enrollmentContainer screen-max-width">
		<div class="enrollmentRow margin-top-40">
			<div class="maincontentRight">
				<div class="mainContentContainer">
					<!-- Calendar & Search -->
					<c:if test="<%= hasSearchSectionPerm%>">
					<div class="SearchBar-Container">
						<div class="Calendar-From Span-width-20">
							 
 							<span class="lfr-input-date " id="startDateContainer">
 							<div class="Calendar-Icon"><img src="/SPProcessEngine-portlet/images/calendar-ion-icons.png" alt=""></div>
 							    <input type="text" name="startDate" id="startDate" placeholder="Start Date"/>
 							</span>
						</div>
						<div class="Calendar-To Span-width-20">

							<span class="lfr-input-date " id="endDateContainer">
							<div class="Calendar-Icon"><img src="/SPProcessEngine-portlet/images/calendar-ion-icons.png" alt=""></div>
 							    <input type="text" name="endDate" id="endDate" placeholder="End Date"/>
 							</span>
						</div>
						<div class="Filterdiv Span-width-20">
								<select id="selectDateType">
									<option value=<%=Field.MODIFIED_DATE %>>Last Activity Date</option>
									<option value=<%=Field.CREATE_DATE %>>Create Date</option>
								</select>
						</div>
						<div class ="Search_Result_Count">
							<p id="resultCount"></p>
					 	</div>
					 	<div class="Searchdiv Span-width-95">
							<div class="filterTags" style="" > 
								<ul id="filterSearchTags">
								</ul> 
							</div>
							<div class="Icon-Search sIv2" id="textSearchButton"><img src="/SPProcessEngine-portlet/images/ios-search-ion-icons.png" alt=""></div>
							<input id="searchText" name="searchName" placeholder="search" type="text" value="">
						</div>
						<div class="filterIcon" id="filtersearchic1">
							<svg xmlns="http://www.w3.org/2000/svg" width="18" height="17" viewBox="0 0 18 17">
							    <path class="filterColor" fill-rule="evenodd" d="M3.929 13.571V15H0v-1.429h3.929zm3.928-1.428c.194 0 .361.07.502.212a.686.686 0 0 1 .212.502v2.857c0 .194-.07.361-.212.503a.686.686 0 0 1-.502.212H5a.686.686 0 0 1-.502-.212.686.686 0 0 1-.212-.503v-2.857c0-.193.07-.36.212-.502A.686.686 0 0 1 5 12.143h2.857zm1.786-4.286v1.429H0V7.857h9.643zM2.5 2.143V3.57H0V2.143h2.5zM17.143 13.57V15H8.929v-1.429h8.214zM6.429.714c.193 0 .36.071.502.212a.686.686 0 0 1 .212.503v2.857c0 .193-.07.36-.212.502A.686.686 0 0 1 6.429 5H3.57a.686.686 0 0 1-.502-.212.686.686 0 0 1-.212-.502V1.429c0-.194.07-.361.212-.503a.686.686 0 0 1 .502-.212H6.43zM13.57 6.43c.194 0 .361.07.503.212a.686.686 0 0 1 .212.502V10c0 .193-.071.36-.212.502a.686.686 0 0 1-.503.212h-2.857a.686.686 0 0 1-.502-.212A.686.686 0 0 1 10 10V7.143c0-.194.07-.361.212-.502a.686.686 0 0 1 .502-.212h2.857zm3.572 1.428v1.429h-2.5V7.857h2.5zm0-5.714V3.57H7.5V2.143h9.643z"/>
							</svg>

						</div>
					</div>
					<!-- Calendar & Search End-->

				

					<!-- Filter Fields-->
					<div class="SearchBar-Container dropFilter arrow-up" id="filterwrapper1">


					 <c:if test="<%= ProcessStateSearchHelper.isApproverType(renderRequest) || ProcessStateSearchHelper.isAgentType(renderRequest)
					 				|| ProcessStateSearchHelper.isSupervisorType(renderRequest)%>">
					 <!-- All Processes -->				
					 	<div class="Filterdiv Span-width-25">
					  		<select id="processId">
						  <option value="0">All Processes</option>
								<%
								  for(long processId : processIds){
									  if(processId > 0){
										  PEProcess process = PEProcessLocalServiceUtil.fetchPEProcess(processId);
								%>
								   <option value="<%= process.getSpPEProcessId() %>"><%= process.getName() %></option>
								<% 	  
									  }
								  }
								%>
							</select>
					 	</div>
                     <!-- All Processes End-->	
                     
                     <!-- Status Type -->	
						<div class="Filterdiv Span-width-25" >
							<select id="statusType" name="statusType">
							</select>
						</div>
					 <!-- Status Type End -->	
                     
                    
						<div class="Filterdiv Span-width-25">
							<select id="dealStatus" name="dealStatus">
							   <option value="-1">Deal Status</option>
								<%
								  for(long dealStatusId : dealStatusIds){
									  if(dealStatusId > 0){
										  PEProcessStage stage = PEProcessStageLocalServiceUtil.fetchPEProcessStage(dealStatusId);
								%>
								   <option value="<%= stage.getSpPEProcessStageId() %>"><%= stage.getName() %></option>
								<% 	  
									  }
								  }
								%>
							</select>
						</div>
                     
                     <!-- Sales -->	
						<c:if test="<%= ProcessStateSearchHelper.isApproverType(renderRequest) || ProcessStateSearchHelper.isSupervisorType(renderRequest)
							%>">
							<script>
						   		var salesDropdownData = <%= ProcessStateSearchHelper.getDataSalesDropdown(processIds, renderRequest).toString() %>;
							</script>	
							<div class="Filterdiv Span-width-20 marginRight0" >
								<select id="assignee" name="assignee">
								</select>
							</div>
						</c:if>
					  <!-- Sales End -->

                     

                     <!-- All Stages -->
						<div class="Filterdiv Span-width-25">
						
						<select id="stage" name="stage" multiple="multiple">
							   <option value="0">All Stages</option>
							   <%
								  for(long stageId : stageIds){
									  
									  if(stageId > 0){
										  PEProcessStage stage = PEProcessStageLocalServiceUtil.fetchPEProcessStage(stageId);
								%>
								   <option value="<%= stage.getSpPEProcessStageId() %>"><%= stage.getName() %></option>
								<% 	  
									  }
								  }
								%>
							</select>
						</div>
					 <!-- All Stages End -->

					 

					   <!-- Deal Stage  -->	
					  <div class="Filterdiv Span-width-25 " >
					  
								<select id="filterClosedLost" name="filterClosedLost">
									<option value="-1">All Closed Lost Reasons</option>
									
								</select>
					   </div>
					    <!-- Deal Stage End -->	

                      <!-- Status active -->	
						<c:if test="<%=displayActiveStatusDD %>">
							<div class="Filterdiv Span-width-15">
								<select id="activeStatus">
									<option value=<%=PEConstantsGlobal.ACTIVE_STATUS_ACTIVE %>>Active</option>
									<option value=<%=PEConstantsGlobal.ACTIVE_STATUS_IN_ACTIVE %>>Inactive</option>
									<option value="-1">All Applications</option>
								</select>
							</div>
						</c:if>
						<script>
						   var statusTypes = <%= ProcessStateSearchHelper.getStatusTypes(processIds).toString() %>;
						</script>
					   <!-- Status Active End-->
						<!-- All Entitytype Listing -->
						
						<c:if test="<%=displayEntityDD %>">
							<div class="Filterdiv Span-width-20">
								<select id="entityType">
						
									  <%
									  String OPTION = "<option value='%s' %s>%s</option>";
									  	  Map<Long,String>names = PEEntityClassRegister.getEntityClassNames(); 
									      out.println(String.format(OPTION, 0, "selected", "All"));
									  	  for (Entry<Long,String>entry:names.entrySet()) {
									  		out.println(String.format(OPTION, entry.getKey(),"",entry.getValue()));
									  	  }
									  %>
						
								</select>
							</div>
						</c:if>
						<!-- All Entitytype Listing end -->
					  <!--  All products -->	
							<c:if test="<%=displayEntityDD %>">
							<div class="Filterdiv Span-width-20">
								<select id="entity">
									<option value="">Loading...</option>
								</select>
							</div>
						</c:if>
						 <!-- All products End-->
						 
					<%
					
					JSONArray jsonArrayObject = JSONFactoryUtil.createJSONArray(formDataParam);
					for (int i = 0; i < jsonArrayObject.length(); i++) {
						JSONObject fieldInput = jsonArrayObject.getJSONObject(i);
						String formId = fieldInput.getString("htmlFormId");
						String fieldName = fieldInput.getString("fieldId");
						String fieldType = fieldInput.getString("fieldType");
						String fieldKeyName = "";
						JSONArray formSchema = FormBuilderLocalServiceUtil.getFormSchema(Long.parseLong("1"), Long.parseLong(formId));
						JSONArray selectFields = JSONFactoryUtil.createJSONArray();
						if(null != formSchema && formSchema.length() > 0){
							
							for(int index = 0; index < formSchema.length() ; index++){
								JSONObject fieldAct = formSchema.getJSONObject(index);
								String fieldKeyId = fieldAct.getString(FormConstants.KEY_ID);
								if(fieldName.trim().equalsIgnoreCase(fieldKeyId.trim())){
									fieldKeyName = fieldAct.getString("placeholder");
									selectFields = JSONFactoryUtil.createJSONArray(fieldAct.getString(FormConstants.KEY_OPTION_LIST));
								}
							}
							if(null != selectFields && selectFields.length() > 0){
								%>
								<div class="Filterdiv Span-width-20 " >
									<select id="<%= fieldName+"_"+formId %>" name="<%= fieldName+"_"+formId %>">
									<option value="-1"><%= fieldKeyName %></option>
								<%
								for(int index1 = 0; index1 < selectFields.length() ; index1++){
									JSONObject fieldSelectType = selectFields.getJSONObject(index1);
									
								%>
								   <option value="<%= fieldSelectType.getString(FormConstants.KEY_VALUE_BIGV) %>"><%= fieldSelectType.getString(FormConstants.KEY_TEXT_BIGT) %></option>
								<%
								}
								%>
								
								</select>
								</div>
								<%
							}
							
						}
						
						
					}
					%>
						


						<div class="Span-width-100">
					 		
						<c:if test="<%= hasBulkuploadPerm%>">
							<div class="fileUploadBtn btn btn-primary hide">
    							<span style="font-size: 13px;" id="bulkUploadSpan">Bulk Upload</span>
    							<input id="bulkRegistration" type="file" class="upload" name="bulkRegistration"
    							accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
							</div>
						</c:if>
						<c:if test="<%= PermissionsUtil.hasExportPermission(themeDisplay) %>">
								<div class="Exportbtn hide">
						     		<button id="export" type="button" class="btn btn-primary" style="font-size: 13px;">Export</button>
								</div>
					    </c:if>
					 	</div>

					
					
					
					    </c:if>
					
					 </div>
	
					 <!-- Filter Fields End-->
					</c:if>				 
				
					<div class="Table-Layout" id="processStatesContainer">
						<div class="Heading">
							<div class="Cell Span-width-10">
								<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "request.id")%></p>
							</div>
							<c:if test="<%= !ProcessStateSearchHelper.isApplicantType(renderRequest) %>">
								<div class="Cell" id="stageClmn">
									<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "stage")%></p>
								</div>
							</c:if>
							<div class="Cell">
								<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "course.name.title")%></p>
							</div>
							<c:if test="<%= !ProcessStateSearchHelper.isApplicantType(renderRequest) %>">
								<div class="Cell" id="applicantClmn">
									<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "applicant")%></p>
								</div>
							</c:if>
							<div class="Cell">
								<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "current.step")%></p>
							</div>
							<c:if test="<%= ProcessStateSearchHelper.isApproverType(renderRequest) %>">
								<div class="Cell" id="supervisorClmn">
									<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "sales.supervisor")%></p>
								</div>
							</c:if>
							<c:if test="<%= ProcessStateSearchHelper.isApproverType(renderRequest) 
										||	ProcessStateSearchHelper.isSupervisorType(renderRequest)%>">
								<div class="Cell" id="agentClmn">
									<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "sales.agent")%></p>
								</div>
							</c:if>
							<div class="Cell Span-width-10">
								<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "ps.created.date")%></p>
							</div>
							<div class="Cell Span-width-10">
								<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "last.activity.date")%></p>
							</div>
							<div class="Cell Span-width-10">
								<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "actions")%></p>
							</div>
						</div>
					</div>
					<div class="LoadMore" id="loadMore">
						<a href="javascript:;"><img src="/SPProcessEngine-portlet/images/Load-more.svg" alt=""></a>
						<p><%= LabelUtil.getLabel(pageContext, themeDisplay, "click.and.view.results")%></p>
					</div>
				</div>
			</div>
		</div>
	</div>

<div class="Row hide addInfo" id="sampleProcessStateRow">
<input id="processStateId" type="hidden" value="" />
<input id="processId" type="hidden" value="" />
	 <div class="Cell Span-width-10">
		  <p><a id="id" ></a></p>
	 </div>
	 <c:if test="<%= !ProcessStateSearchHelper.isApplicantType(renderRequest) %>">
		 <div class="Cell">
			 <p id="stageName"></p>
			 <div class="Stage" id="stageStyle">
			 	<div class="tooltipText" id="tooltip"></div>
			 </div>
		 </div>
	 </c:if>
	 <div class="Cell">
		 <p id="entityName"></p>
	 </div>
	 <c:if test="<%= !ProcessStateSearchHelper.isApplicantType(renderRequest) %>">
		 <div class="Cell">
			 <p><a id="applicantName" target="_blank"></a></p>
		 </div>
	 </c:if>
	 <div class="Cell">
		 <p id="currentStep"></p>
	 </div>
	 <c:if test="<%= ProcessStateSearchHelper.isApproverType(renderRequest) %>">
		 <div class="Cell">
			 <p id="supervisorName"></p>
		 </div>
	 </c:if>
	 <c:if test="<%= ProcessStateSearchHelper.isApproverType(renderRequest) || ProcessStateSearchHelper.isSupervisorType(renderRequest)%>">
		 <div class="Cell">
			 <p id="agentName"></p>
		 </div>
	 </c:if>
	 <div class="Cell Span-width-10">
		 <p class="Date-Time" id="dataCreated"></p>
	 </div>
	 <div class="Cell Span-width-10">
		 <p class="Date-Time" id="dataModified"></p>
	 </div>
	 <div class="Cell Span-width-10">
	 	<a href="#" class="threedot addInfo" id="threedot" title="Actions"></a>
	 	<div class="conextMenuDiv hide">
			<ul>
			    <c:if test="<%= hasAssignPerm %>">
				<li id="assign" class="addInfo">
					<a
						href="#"><img
							src="/SPProcessEngine-portlet/images/assign.svg" alt="Assign"><%= LabelUtil.getLabel(pageContext, themeDisplay, "assign")%></a></li>
			    </c:if>	
			    <c:if test="<%= hasClosePerm%>">
					<li id="closeLost" class="addInfo">
						<a
							href="#"><img
								src="/SPProcessEngine-portlet/images/lost.svg" alt="Lost"><%= LabelUtil.getLabel(pageContext, themeDisplay, "mark.as.close.lost")%></a></li>
					<li id="closeWon" class="addInfo hide">
						<a
							href="#"><img
								src="/SPProcessEngine-portlet/images/won.svg" alt="Won"><%= LabelUtil.getLabel(pageContext, themeDisplay, "mark.as.close.won")%></a></li>
			    </c:if>
				<li id="view" class="addInfo"><a
					href="#" id="viewUrl"><img
						src="/SPProcessEngine-portlet/images/Preview.svg" alt="Preview"><%= LabelUtil.getLabel(pageContext, themeDisplay, "view.the.details")%></a></li>
				<li id="viewConvertedTo" class="addInfo"><a
					href="#" id="viewConvertedToUrl"><img
						src="/SPProcessEngine-portlet/images/Preview.svg" alt="Preview"><%= LabelUtil.getLabel(pageContext, themeDisplay, "view.converted.to.details")%></a></li>
				<li id="viewConvertedFrom" class="addInfo"><a
					href="#" id="viewConvertedFromUrl"><img
						src="/SPProcessEngine-portlet/images/Preview.svg" alt="Preview"><%= LabelUtil.getLabel(pageContext, themeDisplay, "view.converted.from.details")%></a></li>
				<c:if test="<%= hasChangeStatusPerm && changeStatusPref%>">
					<li id="statusActive" class="addInfo hide">
						<a
							href="#"><img
								src="/SPProcessEngine-portlet/images/won.svg" alt="Won"><%= LabelUtil.getLabel(pageContext, themeDisplay, "mark.as.active")%></a></li>
					<li id="statusInActive" class="addInfo hide">
						<a
							href="#"><img
								src="/SPProcessEngine-portlet/images/lost.svg" alt="Won"><%= LabelUtil.getLabel(pageContext, themeDisplay, "mark.as.in.active")%></a></li>
			    </c:if>
			</ul>
		</div>
	 </div>
</div>

<div id="assignPopup" class="hide">
		<div id="assignContainer">
			<div id="assignDDiv">
			<script>
				var assigneeData = <%= ProcessStateSearchHelper.getAssignees(processIds, renderRequest).toString() %>;
			</script>	
				<select id="assigneeId">
				</select>
			</div>
		</div>
</div>

<script>

	var closedReasonsFilter = <%= ProcessStateSearchHelper.getCloseReasonsFliter(processIds) %>;
	var closedReasons = <%= ProcessStateSearchHelper.getCloseReasons(processIds) %>;
	var reasonForCloseLostTitle = "<%= LabelUtil.getLabel(pageContext, themeDisplay, "reason.for.close.lost")%>";
	var reasonForCloseWonTitle = "<%= LabelUtil.getLabel(pageContext, themeDisplay, "reason.for.close.won")%>";
</script>

<div id="closeAppPopup" class="hide">
       <div id="closeAppPopupContainer">
			<div id="closeLostDateContainer">
				 <%
						
				%>
 					
 				<div class="Calendar-To Span-width-20" style="position: relative;">

							<span class="lfr-input-date " id="endDateContainer">
							<div class="Calendar-Icon" style="position: absolute;top: 1px;left: 1px;height: 50px;">
							<img src="/SPProcessEngine-portlet/images/calendar-ion-icons.png" alt="End Date">
							</div>
 							    
 							</span>
				</div>
 				<input style="background-color: white;padding: 15px 0 15px 50px;border: 1px solid #E0E7EE;margin-bottom: 15px;" 
 						type="text" name="closedLostDate" id="closedLostDate"/> 
			</div>
			<div>
               <select id="closedReasonId">
               </select>
           </div>
           <div>
               <textarea rows="10" cols="100" id="closedDesc" placeholder="Optional"></textarea>
           </div>
       </div>
</div>

<div id="closeWonPopup" class="hide">
       <div id="closeWonPopupContainer">
			<div id="closeWonDateContainer">
				 
 					
 				  <div class="Calendar-To Span-width-20" style="position: relative;">

							<span class="lfr-input-date " id="endDateContainer">
							<div class="Calendar-Icon" style="position: absolute;top: 1px;left: 1px;height: 50px;">
							<img src="/SPProcessEngine-portlet/images/calendar-ion-icons.png" alt="End Date">
							</div>
 							    
 							</span>
				</div>
 				<input style="background-color: white;padding: 15px 0 15px 50px;border: 1px solid #E0E7EE;" 
 						type="text" name="closedWonDate" id="closedWonDate"/> 
			</div>
       </div>
</div>


<liferay-portlet:resourceURL id="ajax" var="ajaxUrl">
</liferay-portlet:resourceURL>
<liferay-portlet:resourceURL id="exportUrl" var="exportUrl">
   <portlet:param name="filePath" value="FILE_PATH"/>
   <portlet:param name="action" value="downloadFile"/>
</liferay-portlet:resourceURL>
<portlet:resourceURL id="ajaxUrlBulkRegistration" var ="ajaxUrlBulkRegistration">
	<portlet:param name="action" value="uploadBulkRegistration"/>
</portlet:resourceURL>

<script src="/SPProcessEngine-portlet/js/processstate/processStateSearch.js?t=1305679"></script>
<script>
var A;
AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
		'stylesheet','aui-datepicker','overlay','event', 'widget-anim', function(A1) {
	A = A1;
	var pns ="<portlet:namespace/>";
	var ajaxUrl = "<%= ajaxUrl %>";
	var userType = "<%= userType %>";
	var userId = "<%=userId%>";
	var exportUrl = "<%= exportUrl %>";
	var ajaxUrlBulkRegistration = "<%= ajaxUrlBulkRegistration %>";
	var tempStatusTypes = window.statusTypes || {};
	var tempSalesDrodpdownData = window.salesDropdownData || {};
	var tempAssigneeData = window.assigneeData || {};
	var closedReasons = window.closedReasons || {};
	var closedReasonsFilter = window.closedReasonsFilter || {};
	
	var formDataParam = '<%= formDataParam %>';
	var formDataUrlParam = "<%= formDataUrlParam %>";
	var reasonForCloseLostTitle = window.reasonForCloseLostTitle;
	var modelData = "{'limit':'99999','modelName':'Programme','page':'0','formType':'Programme','filterdata':[]}";
	var obj = new processStateSearch({pns:pns, ajaxUrl:ajaxUrl,formDataParam:formDataParam,formDataUrlParam:formDataUrlParam,userId:userId,userType:userType,exportUrl:exportUrl,ajaxUrlBulkRegistration:ajaxUrlBulkRegistration,statusTypes:tempStatusTypes,assigneeData:tempAssigneeData,closedReasons:closedReasons, closedReasonsFilter:closedReasonsFilter,reasonForCloseLostTitle:reasonForCloseLostTitle,reasonForCloseWonTitle:reasonForCloseWonTitle,salesDrodpdownData:tempSalesDrodpdownData,modelData:modelData});
	
});
</script>

<!-- Filter Icon -->
<script type="text/javascript">
	var mainNav1 = document.getElementById('filterwrapper1');
var navToggle1 = document.getElementById('filtersearchic1');
if(mainNav1 && mainNav1 != null){
	// Start by adding the class "collapse" to the mainNav
	mainNav1.classList.add('collapsed');	
}


// Establish a function to toggle the class "collapse"
function mainNavToggle2() {
    mainNav1.classList.toggle('collapsed');
    navToggle1.classList.toggle('filterActive');
}
if(navToggle1 && navToggle1 != null){
	// Add a click event to run the mainNavToggle function
	navToggle1.addEventListener('click', mainNavToggle2);	
}

</script>

