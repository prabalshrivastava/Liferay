<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/html/common/init.jsp" %>
<portlet:defineObjects />
<portlet:actionURL var="createNewTemplate">
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="action" value="createTemplate" />
</portlet:actionURL>
<portlet:resourceURL var="ajaxUrl" id="ajax">
</portlet:resourceURL>

<%!public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.upload-invitersvp.jsp";%>
<%
	String url = PortalUtil.getPortalURL(themeDisplay);
	String previewIcon = String.valueOf(renderRequest
	.getAttribute("previewIcon"));
	boolean chkEnableRem1 = Boolean.valueOf(String
	.valueOf(renderRequest.getAttribute("chkEnableRem1")));
	boolean chkEnableRem2 = Boolean.valueOf(String
	.valueOf(renderRequest.getAttribute("chkEnableRem2")));
	boolean chkEnableRem3 = Boolean.valueOf(String
	.valueOf(renderRequest.getAttribute("chkEnableRem3")));
	boolean chkEnableThankYou = Boolean.valueOf(String
	.valueOf(renderRequest.getAttribute("chkEnableThankYou")));
	boolean chkEnableMissYou = Boolean.valueOf(String
	.valueOf(renderRequest.getAttribute("chkEnableMissYou")));
%>
<c:choose>
	<c:when test="${!hasAccess}">
		<h3>You don't have the permission to access this url!"</h3>
	</c:when>
	<c:otherwise>
		<div class="rsvpbox-title" style="width: 100%;">Create Mail
			Campaign</div>
		<div id="messageDiv"
			style="background: #f2f2f2; font-weight: bold; margin-top: 10px; padding: 10px; height: 18px; width: 97%; display: none;">
			Campaign is in under processing. It cannot be updated.</div>

		<c:if test="${!empty scheduleErrorMessage}">
			<div
				style="background: #f2f2f2; color: red; font-weight: bold; margin-top: 10px; padding: 10px; height: 18px; width: 98%; margin-bottom: 10px;">
				<c:out value="${scheduleErrorMessage}" />
			</div>
		</c:if>
		<div class="rsvp-preference-border screen-max-width" style="min-height: 300px;">
			<div id="rsvpDiv" style="padding: 10px 0;">
				<div id="newTemplateDiv" class="campaignCreate">
					<form action="<%= createNewTemplate %>" method="post" name="form1"
						id="form1">
						<input id="byCampaignId" type="hidden" name="<portlet:namespace />byCampaignId"
							value="${byCampaignId}" /> <input type="hidden"
							id="editableFlag" name="editableFlag" value="${editable}" /> <input
							type="hidden" id="fileEntryId" name="<portlet:namespace />fileEntryId" />

						<div style="padding-top: 2px; padding-bottom: 2px;">
							<label class="control-label">
								Mail Campaign Name<span style="color: red">*</span>
							</label>
							<div class="">
								<c:if test="${editable}">
									<input name="<portlet:namespace />campaignName" type="text" id="campaignName"
										 value="${campaignName}" />
								</c:if>

								<c:if test="${!editable}">
									<input name="<portlet:namespace />campaignName" type="text" id="campaignName"
										style="width: 300px;" value="${campaignName}" readonly />
								</c:if>

							</div>
						</div>
<!-- merged from version-003 --> 
						<div style="padding:10px 0;">
							<label class="control-label">
								Campaign Type<span style="color: red">*</span>
							</label>
							<div class="">
								<select id="campaignType" name="campaignType" ${disableCampaignType}>
									<option></option>
									<option value="automated"  ${automated}>Automated Scheduling</option>
									<option value="subscription"   ${subscribed}>Subscription Based Scheduling</option>  
								</select>
							</div>
						</div>
<!-- end -->

						<div style="padding:10px 0;" class="hide">
							<label class="control-label">
								Thumbnail Upload</label>
							<div style="width: 72%; display: inline;">
								<input id="imageFiles" name="<portlet:namespace />imageFiles" type="file"
									onchange="performAjaxSubmit()" />
							</div>
						</div>
						<div id="divImageFiles" class="hide"></div>

						<div class="rsvp-label"  style="padding:10px 0;">
							<label class="control-label">Select Category</label>
							<div class="">
								<select id="categoryId" name="<portlet:namespace />categoryId" onChange="javascript:showAddButon()">
									<option value=""></option>

									<c:forEach items="${lstAssetCategory}" var="assetCategory">
										<option value="${assetCategory.categoryId }"
											<c:if test="${categoryId == assetCategory.categoryId}">selected="selected"</c:if>>
											<c:out value="${assetCategory.name }" />
										</option>
									</c:forEach>
								</select>
							</div>
						</div>

						
						<div style="text-align: center">
						 <button id="addEdm" type="button" class="hide" style="text-align: center;margin: 10px 0 20px;"></button>
						 </div>
						 <!--  *********************  START OF EDM TEMPLATE : USED TO REPLICATE THE EDM SECTION UPON CLICKING ADD EDM BUTTON *******************************-->
						 <input type="hidden" id="edmSeqNoLower" name="edmSeqNoLower">
						 <input type="hidden" id="edmSeqNoHigher" name="edmSeqNoHigher">
						<div id="templateEdmRootNode" class="hide">
							<input type="hidden" id="edmSeqNo" name="edmSeqNo"> <!-- edmSeqNo is generated number at client side -->
							<input type="hidden" id="edmId" name="edmId"> <!-- edmId is id in database  -->
							<div>
							  <div>
							  <label class="control-label">Name</label> 
							  <div class="">
							  <input type="text" id="edmName" name="edmName" class="edmName">
							  </div>
							 </div>
							</div>
							<div id="editFieldsGrp">
								<div class='rsvp-label'>
										<label class="control-label">Select Template</label>
										<div class="">
										<select id="mailTemplateId" name="mailTemplateId" class="mailTemplateId">
											<option value=""></option>

											<c:forEach var="spMailTemplate" items="${lstTemplate}">
												<option value="${spMailTemplate.spMailTemplateId }"
													<c:if test="${mailTemplateId == spMailTemplate.spMailTemplateId}">selected="selected"</c:if>>
													<c:out value='${spMailTemplate.templateName }' /> -version
													<c:out value='${spMailTemplate.versionNumber}' />
												</option>
											</c:forEach>
										</select>
										<div id="mailTemplateExpand"><a id="templatePreivew" href="javascript:;" class="hide"><img src="${previewIcon }" alt="Preview"/></a></div>
										<div id="mailTemplateEdit" style="display: none;">
											<a href="" onclick="">Edit</a>
										</div>
									</div>
								</div>
								<div class="recurrenceWrap" id="recurrenceWrap">
									<label class="control-label">Recurrence</label>
									<div class="">
									<select id="croneType" name="croneType" class="croneType">
										<option value="oneTime">One Time</option>
										<option value="daily">Daily</option>
										<option value="weekly">Weekly</option>
										<option value="monthly">Monthly</option>
										<option value="semiAnnual">Semi-Annual</option>
										<option value="yearly">Yearly</option>
									</select>
									</div>
								</div>
								<div id="dayOfWeekContainer" class="hide dayContainer">
									<select id="dayOfWeek" name="dayOfWeek">
										<option value="0" selected>Select Day</option>
										<option value="1" >Sunday</option>
										<option value="2" >Monday</option>
										<option value="3" >Tuesday</option>
										<option value="4" >Wednesday</option>
										<option value="5" >Thursday</option>
										<option value="6" >Friday</option>
										<option value="7">Saturday</option>
									</select>
								</div>
								<div id="dayOfMonthContainer" class="hide dayContainer">
									<select id="dayOfMonth" name="dayOfMonth">
											<option value="0">Select Day</option>
										<c:forEach begin="1" end="31" var="val">
											<option value="${val }">${val}</option>
										</c:forEach>
											<option value="-1">Last Sunday</option>
									</select>
								</div>
								<div id="delayContainer" class='delayContanier'>
									<label class="control-label">Wait At Least</label>
									<div class="">
									<input type="text" id="delayAmount" name="delayAmount"  style="width:49%!important" class="delayAmount"  data-delay-amount/>
									<select id="delayUnit" name="delayUnit" style="width:49%!important;margin-bottom: 8px;" class="delayUnit" data-delay-unit>
										<option value="mins">Min(s)</option>
										<option value="hours">Hour(s)</option>
										<option value="days">Day(s)</option>
										<option value="weeks">Week(s)</option>
										<option value="months">Month(s)</option>
										
									</select>
									</div>
								</div> 
								<div id="delayDateDivider" style="text-align: center;margin: 20px 0;" data-divide>--OR--</div>
								<div class="" id="startDateWrap">
									<div data-label id="startDatelabel" class="">
										<label class="control-label">Start Date</label>
									</div>
									<div class="">
									<div id="dateContainer" class='dateContainer lfr-input-date' data-date-container>
	 								    <input type="text" name="edmStartDate" id="edmStartDate" placeholder="Start Date" value=""/>
	 								</div>
	 								</div>
 								</div>
 								<div class="" id="startTimeWrap">
 									<div data-label id="startTimelabel" class="">
										<label class="control-label">Start Time</label>
									</div>
									<div class="">
									<div id="timeContainer" class='dateContainer' data-time-container>
										<input id="edmStartTime" class="form-control timePicker" type="text" placeholder="hh:mm" value="12:00 AM" name="edmStartTime">
									</div>
									</div>
								</div>
							</div>
							<div id="nextScheduleContainer" class="hide">
								<span id="nextSchedule"></span>
							</div>
							<div>
								<a href="javascript:;" id="editEdm" data-edit-link>Edit</a>
							</div>
							<div>
								<a href="javascript:;" id="pauseResumeLink">Pause</a>
							</div>
							
						</div>
						<!--  *********************  END OF EDM TEMPLATE : USED TO REPLICATE THE EDM SECTION UPON CLICKING ADD EDM BUTTON *******************************-->
						<div id="edmsList">
						
						</div>
						<div  class="hide">
						<input type="checkbox" id="rescheduleEdms" name="rescheduleEdms" style="display:inline-block";> 
							<label style="display: inline-block;">I want to reschedule EDM'S</label>
							
						</div>
						<!-- Reminder1 -->
						<c:if test="${chkEnableRem1=='on'}">
							<div class="mailtemplate-subtitle">Reminder1 Template</div>
							<div
								style="background: none; padding-left: 0px; width: 95%; padding-top: 5px; padding-bottom: 25px;">

					<div class="rsvp-label">
						<div class="left-creatediv">Select Template for Reminder1</div>
						<div class="right-creatediv">
							<select id="reminder1Id" name="<portlet:namespace />reminder1Id"
								onchange="loadMailTemplateDetail('reminder1Id','reminder1Subject','reminder1HTMLContent','reminder1TextContent','reminder1')">
								<option value=""></option>

											<c:forEach var="spMailTemplate" items="${lstTemplate}">
												<option value="${spMailTemplate.spMailTemplateId }"
													<c:if test="${reminder1Id == spMailTemplate.spMailTemplateId}">selected="selected"</c:if>>
													<c:out value='${spMailTemplate.templateName }' /> -version
													<c:out value='${spMailTemplate.versionNumber}' />
												</option>
											</c:forEach>
										</select>

							<div id="reminder1Expand" style="display: none;">
								<a href="" onclick="">Details</a>
							</div>
							<div id="reminder1Edit" style="display: none;">
								<a href="" onclick="">Edit</a>
							</div>
						</div>
					</div>

								<c:choose>
									<c:when test="${!empty reminder1Id}">
										<c:set var="tempClass" value="mailTemplateSectionSlide"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="tempClass" value="mailTemplateSectionHidden"></c:set>
									</c:otherwise>
								</c:choose>

								<div id="reminder1Section" class="${tempClass }">

									<div style="padding-top: 2px; padding-bottom: 2px;">
										<input type="hidden" id="reminder1SubjectValue"
											name="reminder1SubjectValue" value="${reminder1SubjectValue}" />

					</div>

					<div style="padding-top: 2px; padding-bottom: 2px;">
						<input type="hidden" id="reminder1HTMLContentValue"
							name="reminder1HTMLContentValue"
							value="${reminder1HTMLContentValue}" />

					</div>

					<div style="padding-top: 2px; padding-bottom: 2px;">
						<input type="hidden" id="reminder1TextContentValue"
							name="reminder1TextContentValue" />

					</div>

					<c:if test="${!empty rem1Schedule}">
						<div class="left-creatediv">Reminder1 Schedule</div>
						<div class="right-creatediv">
							<c:out value="${rem1Schedule}" />

						</div>
					</c:if>
					<div
						style="display: block; vertical-align: top; font-weight: bold; padding-top: 25px; padding-bottom: 25px;"
						id="reminder1ChkDiv">
						<input name="<portlet:namespace />reminder1Chk" type="checkbox" id="reminder1Chk"
							onclick="checkSchedule('rem1ScheduleDiv');"
							<c:if test="${reminder1Chk == 'on'}"><c:out value="checked=\"checked\""></c:out></c:if> />
						Update Reminder1 Schedule
					</div>

									<c:choose>
										<c:when test="${!empty reminder1Id}">
											<c:set var="tempdisplay" value="block"></c:set>
										</c:when>
										<c:otherwise>
											<c:set var="tempdisplay" value="none"></c:set>
										</c:otherwise>
									</c:choose>

									<div style="width: 100%; display: ${tempdisplay};"
										id="rem1ScheduleDiv">
										<div
											style="width: 25%; display: inline-block; vertical-align: top;">
											<span class='pets-rsvp-label'>Select Schedule</span>
										</div>
										<div
											style="width: 43%; visible: hidden; display: inline-block;"
											id="reminder1Schedule">
											<div class="datepicker helper-clearfix"
												id="#<portlet:namespace />reminder1Picker">
												<input type="hidden" name="reminder1Date"
													id="<portlet:namespace />reminder1Date" size="30" />

												<p>
													<liferay-ui:input-date dayValue="${dayValuerem1}"
														dayParam="reminder1Day" disabled="<%= false %>"
														firstDayOfWeek="${firstDayOfWeekrem1}"
														monthParam="reminder1Month" monthValue="${monthValuerem1}"
														yearParam="reminder1Year" yearValue="${yearValuerem1}" />
														<%-- yearRangeStart="${yearRangeStartrem1}" yearRangeEnd="${yearRangeEndrem1}" --%>
													<liferay-ui:input-time amPmParam="reminder1Ampm"
														amPmValue="${amPmValuerem1}" hourParam="reminder1Hour"
														hourValue="${hourValuerem1}" minuteParam="reminder1Min"
														minuteValue="${minuteValuerem1}" minuteInterval="1" />


												</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:if>
						<!-- Reminder2 -->
						<c:if test="${chkEnableRem2=='on'}">
							<div class="mailtemplate-subtitle">Reminder2 Template</div>
							<div
								style="background: none; padding-left: 0px; width: 95%; padding-top: 5px; padding-bottom: 25px;">

				<div class="rsvp-label">
					<div class="left-creatediv">Select Template for Reminder2</div>
					<div class="right-creatediv">
						<select id="reminder2Id" name="<portlet:namespace />reminder2Id"
							onchange="loadMailTemplateDetail('reminder2Id','reminder2Subject','reminder2HTMLContent','reminder2TextContent','reminder2')">
							<option value=""></option>

											<c:forEach var="spMailTemplate" items="${lstTemplate}">
												<option value="${spMailTemplate.spMailTemplateId }"
													<c:if test="${reminder2Id == spMailTemplate.spMailTemplateId}">selected="selected"</c:if>>
													<c:out value='${spMailTemplate.templateName }' /> -version
													<c:out value='${spMailTemplate.versionNumber}' />
												</option>
											</c:forEach>
										</select>

						<div id="reminder2Expand" style="display: none;">
							<a href="" onclick="">Details</a>
						</div>
						<div id="reminder2Edit" style="display: none;">
							<a href="" onclick="">Edit</a>
						</div>
					</div>
				</div>

								<c:choose>
									<c:when test="${!empty reminder2Id}">
										<c:set var="tempClass" value="mailTemplateSectionSlide"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="tempClass" value="mailTemplateSectionHidden"></c:set>
									</c:otherwise>
								</c:choose>
								<div id="reminder2Section" class="${ tempClass}">

				<div style="padding-top: 2px; padding-bottom: 2px;">
					<input type="hidden" id="reminder2SubjectValue"
						name="reminder2SubjectValue" value="${reminder2SubjectValue}" />

				</div>

				<div style="padding-top: 2px; padding-bottom: 2px;">
					<input type="hidden" id="reminder2HTMLContentValue"
						name="reminder2HTMLContentValue"
						value="${reminder2HTMLContentValue}" />

				</div>

				<div style="padding-top: 2px; padding-bottom: 2px;">
					<input type="hidden" id="reminder2TextContentValue"
						name="reminder2TextContentValue" />

				</div>

				<c:if test="${!empty rem2Schedule}">
					<div class="left-creatediv">Reminder2 Schedule</div>
					<div class="right-creatediv">
						<c:out value="${rem2Schedule}"></c:out>

					</div>
				</c:if>

				<div
					style="display: block; vertical-align: top; font-weight: bold; padding-top: 25px; padding-bottom: 25px;"
					id="reminder2ChkDiv">
					<input name="<portlet:namespace />reminder2Chk" type="checkbox" id="reminder2Chk"
						onclick="checkSchedule('rem2ScheduleDiv');"
						<c:if test="${reminder2Chk == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> />
					Update Reminder2 Schedule
				</div>

									<c:choose>
										<c:when test="${!empty reminder2Id}">
											<c:set var="tempdisplay" value="block"></c:set>
										</c:when>
										<c:otherwise>
											<c:set var="tempdisplay" value="none"></c:set>
										</c:otherwise>
									</c:choose>
									<div style="width: 100%; display: ${tempdisplay};"
										id="rem2ScheduleDiv">
										<div
											style="width: 25%; display: inline-block; vertical-align: top;">
											<span class='pets-rsvp-label'>Select Schedule</span>
										</div>
										<div
											style="width: 43%; visible: hidden; display: inline-block;"
											id="reminder2Schedule">
											<div class="datepicker helper-clearfix"
												id="#<portlet:namespace />reminder2Picker">
												<input type="hidden" name="<portlet:namespace />reminder2Date"
													id="<portlet:namespace />reminder2Date" size="30" />

												<p>
													<liferay-ui:input-date dayValue="${dayValuerem2}"
														dayParam="reminder2Day" disabled="<%= false %>"
														firstDayOfWeek="${firstDayOfWeekrem2}"
														monthParam="reminder2Month" monthValue="${monthValuerem2}"
														yearParam="reminder2Year" yearValue="${yearValuerem2}"
														 />
														<%--  yearRangeStart="${yearRangeStartrem2}"
														yearRangeEnd="${yearRangeEndrem2}" --%>
													<liferay-ui:input-time amPmParam="reminder2Ampm"
														amPmValue="${amPmValuerem2}" hourParam="reminder2Hour"
														hourValue="${hourValuerem2}" minuteParam="reminder2Min"
														minuteValue="${minuteValuerem2}" minuteInterval="1" />


												</p>
											</div>
										</div>

									</div>

								</div>
							</div>
						</c:if>

		<!-- Reminder3 -->
		<c:if test="${chkEnableRem3=='on'}">
			<div class="mailtemplate-subtitle">Reminder3 Template</div>
			<div
				style="background: none; padding-left: 0px; width: 95%; padding-top: 5px; padding-bottom: 25px;">

				<div class="rsvp-label">
					<div class="left-creatediv">Select Template for Reminder3</div>
					<div class="right-creatediv">
						<select id="reminder3Id" name="<portlet:namespace />reminder3Id"
							onchange="loadMailTemplateDetail('reminder3Id','reminder3Subject','reminder3HTMLContent','reminder3TextContent','reminder3')">
							<option value=""></option>

							<c:forEach items="${lstTemplate}" var="spMailTemplate">
								<option value="${spMailTemplate.spMailTemplateId }"
									<c:if test="${reminder3Id == spMailTemplate.spMailTemplateId}">selected="selected"</c:if>>
									<c:out value="${spMailTemplate.templateName }" />
									-version
									<c:out value="${spMailTemplate.versionNumber}" />
								</option>
							</c:forEach>
						</select>

										<div id="reminder3Expand" style="display: none;">
											<a href="" onclick="">Details</a>
										</div>
										<div id="reminder3Edit" style="display: none;">
											<a href="" onclick="">Edit</a>
										</div>
									</div>
								</div>
								<c:choose>
									<c:when test="${!empty reminder3Id}">
										<c:set var="tempClass" value="mailTemplateSectionSlide"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="tempClass" value="mailTemplateSectionHidden"></c:set>
									</c:otherwise>
								</c:choose>

								<div id="reminder3Section" class="${tempClass }">

									<div style="padding-top: 2px; padding-bottom: 2px;">
										<input type="hidden" id="reminder3SubjectValue"
											name="reminder3SubjectValue" value="${reminder3SubjectValue}" />

									</div>

				<div style="padding-top: 2px; padding-bottom: 2px;">
					<input type="hidden" id="reminder3HTMLContentValue"
						name="reminder3HTMLContentValue"
						value="${reminder3HTMLContentValue}" />

				</div>

				<div style="padding-top: 2px; padding-bottom: 2px;">
					<input type="hidden" id="reminder3TextContentValue"
						name="reminder3TextContentValue" />

				</div>

				<c:if test="${!empty rem3Schedule}">
					<div class="left-creatediv">Reminder3 Schedule</div>
					<div class="right-creatediv">
						<c:out value="${rem3Schedule}"></c:out>

					</div>
				</c:if>

				<div
					style="display: block; vertical-align: top; font-weight: bold; padding-top: 25px; padding-bottom: 25px;"
					id="reminder3ChkDiv">
					<input name="<portlet:namespace />reminder3Chk" type="checkbox" id="reminder3Chk"
						onclick="checkSchedule('rem3ScheduleDiv');"
						<c:if test="${reminder3Chk == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> />
					Update Reminder3 Schedule
				</div>

									<c:choose>
										<c:when test="${!empty reminder3Id}">
											<c:set var="tempDisplay" value="block"></c:set>
										</c:when>
										<c:otherwise>
											<c:set var="tempDisplay" value="none"></c:set>
										</c:otherwise>
									</c:choose>
									<div style="width: 100%; display: ${tempDisplay};"
										id="rem3ScheduleDiv">

				<div style="width: 25%; display: inline-block; vertical-align: top;">
					<span class="pets-rsvp-label">Select Schedule</span>
				</div>
				<div style="width: 43%; visible: hidden; display: inline-block;"
					id="reminder3Schedule">
					<div class="datepicker helper-clearfix"
						id="#<portlet:namespace />reminder3Picker">
						<input type="hidden" name="<portlet:namespace />reminder3Date"
							id="<portlet:namespace />reminder3Date" size="30" />

						<p>
							<liferay-ui:input-date dayValue="${dayValuerem3}"
								dayParam="reminder3Day" disabled="<%= false %>"
								firstDayOfWeek="${firstDayOfWeekrem3}"
								monthParam="reminder3Month" monthValue="${monthValuerem3}"
								yearParam="reminder3Year" yearValue="${yearValuerem3}"
								/>
								<%-- yearRangeStart="${yearRangeStartrem3}"
								yearRangeEnd="${yearRangeEndrem3}"  --%>
							<liferay-ui:input-time amPmParam="reminder3Ampm"
								amPmValue="${amPmValuerem3}" hourParam="reminder3Hour"
								hourValue="${hourValuerem3}" minuteParam="reminder3Min"
								minuteValue="${minuteValuerem3}" minuteInterval="1" />


												</p>
											</div>
										</div>
									</div>

								</div>
							</div>
						</c:if>


		<!-- Thank you -->
		<c:if test="${chkEnableThankYou=='on'}">
			<div class="mailtemplate-subtitle">Thank You Template</div>
			<div
				style="background: none; padding-left: 0px; width: 95%; padding-top: 5px; padding-bottom: 25px;">

				<div class="rsvp-label">
					<div class="left-creatediv">Select Template for Thank You</div>
					<div class="right-creatediv">
						<select id="thankYouId" name="<portlet:namespace />thankYouId"
							onchange="loadMailTemplateDetail('thankYouId','thankYouSubject','thankYouHTMLContent','thankYouTextContent','thankYou')">
							<option value=""></option>

							<c:forEach items="${lstTemplate}" var="spMailTemplate">
								<option value="${spMailTemplate.spMailTemplateId }"
									<c:if test="${thankYouId == spMailTemplate.spMailTemplateId}">selected="selected"</c:if>>
									<c:out value="${spMailTemplate.templateName }" />
									-version
									<c:out value="${spMailTemplate.versionNumber}" />
								</option>
							</c:forEach>
						</select>

						<div id="thankYouExpand" style="display: none;">
							<a href="" onclick="">Details</a>
						</div>
						<div id="thankYouEdit" style="display: none;">
							<a href="" onclick="">Edit</a>
						</div>
					</div>
				</div>

								<c:choose>
									<c:when test="${!empty thankYouId}">
										<c:set var="tempClass" value="mailTemplateSectionSlide">
										</c:set>
									</c:when>
									<c:otherwise>
										<c:set var="tempClass" value="mailTemplateSectionHidden">
										</c:set>
									</c:otherwise>
								</c:choose>

								<div id="thankYouSection" class="${tempClass }">

									<div style="padding-top: 2px; padding-bottom: 2px;">
										<input type="hidden" id="thankYouSubjectValue"
											name="thankYouSubjectValue" value="${thankYouSubjectValue}" />

				</div>

				<div style="padding-top: 2px; padding-bottom: 2px;">
					<input type="hidden" id="thankYouHTMLContentValue"
						name="thankYouHTMLContentValue"
						value="${thankYouHTMLContentValue}" />

				</div>

				<div style="padding-top: 2px; padding-bottom: 2px;">
					<input type="hidden" id="thankYouTextContentValue"
						name="thankYouTextContentValue" />

				</div>

				<c:if test="${!empty thankYouSchedule}">
					<div class="left-creatediv">Thank You Schedule</div>
					<div class="right-creatediv">
						<c:out value="${thankYouSchedule}"></c:out>

					</div>
				</c:if>

				<div
					style="display: block; vertical-align: top; font-weight: bold; padding-top: 25px; padding-bottom: 25px;"
					id="thankYouChkDiv">
					<input name="<portlet:namespace />thankYouChk" type="checkbox" id="thankYouChk"
						onclick="checkSchedule('thankYouScheduleDiv');"
						<c:if test="${thankYouChk == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> />
					Update Thank You Schedule
				</div>

									<c:choose>
										<c:when test="${!empty thankYouId}">
											<c:set var="tempDisplay" value="block">
											</c:set>
										</c:when>
										<c:otherwise>
											<c:set var="tempDisplay" value="none">
											</c:set>
										</c:otherwise>
									</c:choose>
									<div style="width: 100%; display: ${tempDisplay};"
										id="thankYouScheduleDiv">
										<div
											style="width: 25%; display: inline-block; vertical-align: top;">
											<span class='pets-rsvp-label'>Select Schedule</span>
										</div>
										<div
											style="width: 43%; visible: hidden; display: inline-block;"
											id="thankYouSchedule">
											<div class="datepicker helper-clearfix"
												id="#<portlet:namespace />thankYouPicker">
												<input type="hidden" name="<portlet:namespace />thankYouDate"
													id="<portlet:namespace />thankYouDate" size="30" />

						<p>
							<liferay-ui:input-date dayValue="${dayValuethankYou}"
								dayParam="thankYouDay" disabled="<%= false %>"
								firstDayOfWeek="${firstDayOfWeekthankYou}"
								monthParam="thankYouMonth" monthValue="${monthValuethankYou}"
								yearParam="thankYouYear" yearValue="${yearValuethankYou}"
								/>
								<%-- yearRangeStart="${yearRangeStartthankYou}"
								yearRangeEnd="${yearRangeEndthankYou}"  --%>
							<liferay-ui:input-time amPmParam="thankYouAmpm"
								amPmValue="${amPmValuethankYou}" hourParam="thankYouHour"
								hourValue="${hourValuethankYou}" minuteParam="thankYouMin"
								minuteValue="${minuteValuethankYou}" minuteInterval="1" />

						</p>
					</div>
				</div>
			</div>

			</div>
			</div>
		</c:if>

		<!-- Miss you -->
		<c:if test="${chkEnableMissYou=='on'}">
			<div class="mailtemplate-subtitle">Missed You Template</div>
			<div
				style="background: none; padding-left: 0px; width: 95%; padding-top: 5px; padding-bottom: 25px;">

				<div class="rsvp-label">
					<div class="left-creatediv">Select Template for Missed You</div>
					<div class="right-creatediv">
						<select id="missYouId" name="<portlet:namespace />missYouId"
							onchange="loadMailTemplateDetail('missYouId','missYouSubject','missYouHTMLContent','missYouTextContent','missYou')">
							<option value=""></option>

							<c:forEach items="${lstTemplate}" var="spMailTemplate">
								<option value="${spMailTemplate.spMailTemplateId }"
									<c:if test="${missYouId == spMailTemplate.spMailTemplateId}">selected="selected"</c:if>>
									<c:out value="${spMailTemplate.templateName }" />
									-version
									<c:out value="${spMailTemplate.versionNumber}" />
								</option>
							</c:forEach>
						</select>

						<div id="missYouExpand" style="display: none;">
							<a href="" onclick="">Details</a>
						</div>
						<div id="missYouEdit" style="display: none;">
							<a href="" onclick="">Edit</a>
						</div>
					</div>
				</div>

								<c:choose>
									<c:when test="${!empty missYouId}">
										<c:set var="tempClass" value="mailTemplateSectionSlide">
										</c:set>
									</c:when>
									<c:otherwise>
										<c:set var="tempClass" value="mailTemplateSectionHidden">
										</c:set>
									</c:otherwise>
								</c:choose>
								<div id="missYouSection" class="${tempClass }">

									<div id="missYouSection" class="mailTemplateSectionHidden">
										<div style="padding-top: 2px; padding-bottom: 2px;">
											<input type="hidden" id="missYouSubjectValue"
												name="missYouSubjectValue" value="${missYouSubjectValue}" />

										</div>

					<div style="padding-top: 2px; padding-bottom: 2px;">
						<input type="hidden" id="missYouHTMLContentValue"
							name="missYouHTMLContentValue" value="${missYouHTMLContentValue}" />

					</div>

					<div style="padding-top: 2px; padding-bottom: 2px;">
						<input type="hidden" id="missYouTextContentValue"
							name="missYouTextContentValue" />

					</div>
					<c:if test="${!empty missYouSchedule}">
						<div class="left-creatediv">Miss You Schedule</div>
						<div class="right-creatediv">
							<c:out value="${missYouSchedule}"></c:out>

						</div>
					</c:if>
					<div
						style="display: block; vertical-align: top; font-weight: bold; padding-top: 25px; padding-bottom: 25px;"
						id="missYouChkDiv">
						<input name="<portlet:namespace />missYouChk" type="checkbox" id="missYouChk"
							onclick="checkSchedule('missYouScheduleDiv');"
							<c:if test="${missYouChk == 'true'}"><c:out value="checked=\"checked\""></c:out></c:if> />
						Update Miss You Schedule
					</div>
					<div id="missYouScheduleDiv" style="width: 100%; display: none;">
						<div
							style="width: 25%; display: inline-block; vertical-align: top;">
							<span class="pets-rsvp-label">Select Schedule</span>
						</div>
						<c:choose>
							<c:when test="${!empty missYouId}">
													<c:set var="tempDisplay" value="block">
													</c:set>
												</c:when>
												<c:otherwise>
													<c:set var="tempDisplay" value="none">
													</c:set>
												</c:otherwise>
											</c:choose>
											<div style="width: 100%; display: ${tempDisplay};"
												id="missYouSchedule">

						<div class="datepicker helper-clearfix"
							id="#<portlet:namespace />missYouPicker">
							<input type="hidden" name="<portlet:namespace />missYouDate"
								id="<portlet:namespace />missYouDate" size="30" />

							<p>
								<liferay-ui:input-date dayValue="${dayValuemissYou}"
									dayParam="missYouDay" disabled="<%= false %>"
									firstDayOfWeek="${firstDayOfWeekmissYou}"
									monthParam="missYouMonth" monthValue="${monthValuemissYou}"
									yearParam="missYouYear" yearValue="${yearValuemissYou}"
									/>
									<%-- yearRangeStart="${yearRangeStartmissYou}"
									yearRangeEnd="${yearRangeEndmissYou}"  --%>
								<liferay-ui:input-time amPmParam="missYouAmpm"
									amPmValue="${amPmValuemissYou}" hourParam="missYouHour"
									hourValue="${hourValuemissYou}" minuteParam="missYouMin"
									minuteValue="${minuteValuemissYou}" minuteInterval="1" />
							</p>
						</div>
					</div>
				</div>

									</div>
								</div>
							</div>
						</c:if>
						<div style="width: 100%; margin-top: 10px; text-align: center;">
							<div style="display: inline-block;">
								<input type="button" value="Save" id="save" onclick="" class="btn-primary"/>
							</div>
							<div style="display: inline-block;">
								<input type="button" value="Cancel"
									onclick="window.open('/${listingPageName}', '_self')" class="btn-primary"/>
							</div>
						</div>

		<div class="white_content" id="light">


			<div class="campaign-mainTitle">
				<div id="campaignSubject" class="campaignSubject"
					style="display: inline-block; width: 80%;">&nbsp;</div>
				<div style="display: inline-block; width: 19%;">
					<a href="javascript:void(0)" onclick="closeTemplateScreen()">Close</a>
				</div>
			</div>
			<!-- <div style="width: 96%; padding-left: 10px; padding-top: 10px;">
					<div class="mailtemplate-subtitle"
						style="font-size: 15px; background: none repeat scroll 0% 0% transparent; text-align: left; padding-left: 0px;">Subject</div>
					<div id="campaignSubject">&nbsp;</div>
				</div>-->

			<div style="width: 96%; padding-left: 10px; padding-top: 10px;">
				<div class="mailtemplate-subtitle"
					style="font-size: 15px; background: none repeat scroll 0% 0% transparent; text-align: left; padding-left: 0px;">HTML
					Content</div>
				<div id="campaignHTMLContent">&nbsp;</div>
			</div>
		</div>
		<div class="black_overlay" id="fade"></div>

		</form>
		</div>
		</div>
		</div>

<script type="text/javascript">
function showAddButon(){
	var categorySelect = document.getElementById('categoryId');
	var categorySelectOpt =  categorySelect.options[categorySelect.selectedIndex].innerHTML;
	var addEdmBtn = document.getElementById('addEdm');
	if(categorySelectOpt != ''){
		addEdmBtn.classList.remove('hide');
		addEdmBtn.innerHTML = "Add " + categorySelectOpt;
	}else{
		addEdmBtn.classList.add('hide');
	}
	
}
function loadContent(obj) {
	var AI=AUI();
	var itemis = null;
	var reqUrlis = '<portlet:resourceURL id="" />';
		//document.getElementById("light").style.display='block';
		//document.getElementById("fade").style.display='block';

			try{
			 	AI.io.request(reqUrlis, {
				    cache: false,
				    sync: true,
				    timeout: 1000,
				    dataType: 'json',
				    method: 'post',
				    data:{
				   	 filterName:"templateDetail",
				   	 filterValue:obj,
				    },

				    on: {
				        success: function() {
				       	 itemis = this.get('responseData');
				        if (itemis) {

				       		for (key in itemis) {
				       			var cellTextValues = itemis[key];
				       			for (key in cellTextValues) {
				       				switch(key) {
					       				case "subject": subject=cellTextValues[key];break;
					       				case "htmlContent": htmlContent=cellTextValues[key];break;
					       				case "textContent": textContent=cellTextValues[key];break;
					       				case "name":campaignName=cellTextValues[key];break;
				       				}
				       			}
				       		}
				       		//document.getElementById("campaignTitle").innerHTML=campaignName;
				       		document.getElementById("campaignSubject").innerHTML=subject;
				       		document.getElementById("campaignHTMLContent").innerHTML=htmlContent;
				       		document.getElementById("event-invite-pannel").style.display="none";
				       		/* alert("1");
				       		var myWindow = window.open("", subject,'width=680,location=no,toolbar=no,menubar=no,status=no,resizable=0,scrollbars=yes,height=700,top=100,left=100');
				       		myWindow.document.write(htmlContent); */

				       	}
				        },

				        failure: function() {
				        }
				    }
				});

		 	return true;
		}catch(err) {
		}

}

AUI().ready(function(A) {
	var chkEnableRem1 = '<%= chkEnableRem1 %>';
	var chkEnableRem2 = '<%= chkEnableRem2 %>';
	var chkEnableRem3 = '<%= chkEnableRem3 %>';
	var chkEnableThankYou = '<%= chkEnableThankYou %>';
	var chkEnableMissYou = '<%= chkEnableMissYou %>';
	if (document.getElementById("byCampaignId").value == "") {

	}else {
		var editFlag = document.getElementById("editableFlag").value;
		//enableDetailSection('mailTemplate',editFlag);	
		if(chkEnableRem1 == "on"){
			enableDetailSection('reminder1',editFlag);
		}

		if (chkEnableRem2 == "on") {
			enableDetailSection("reminder2",editFlag);
		}

		if (chkEnableRem3 == "on") {
			enableDetailSection("reminder3",editFlag);
		}

		if (chkEnableThankYou == "on") {
			enableDetailSection("thankYou",editFlag);
		}

		if (chkEnableMissYou == "on") {
			enableDetailSection("missYou",editFlag);
		}

		if (editFlag=="true") {
			document.getElementById("messageDiv").style.display="none";
		}else {
			document.getElementById("messageDiv").style.display="block";
			document.getElementById("messageDiv").style.color="red";
			document.getElementById("mailTemplateChkDiv").style.display="none";


			if (chkEnableRem1 == "on") {
				document.getElementById("reminder1ChkDiv").style.display="none";
			}
			if (chkEnableRem2 == "on") {
				document.getElementById("reminder2ChkDiv").style.display="none";
			}

			if (chkEnableRem3 == "on") {
				document.getElementById("reminder3ChkDiv").style.display="none";
			}

			if (chkEnableThankYou == "on") {
				document.getElementById("thankYouChkDiv").style.display="none";
			}

			if (chkEnableMissYou == "on") {
				document.getElementById("missYouChkDiv").style.display="none";
			}
		}
	}
});

function enableDetailSection(obj,flag) {
	var imageURL = '<%= previewIcon %>';
	document.getElementById(obj+"Id").style.visibility="hidden";
	document.getElementById(obj+"Expand").innerHTML = "<a onclick=loadTemplateDisplay('"+obj+"')><img alt='Load' src='"+imageURL+"'/></a>";
	document.getElementById(obj+"Expand").style.display="inline-block";
	document.getElementById(obj+"Section").className="mailTemplateSectionSlide";
	//document.getElementById(obj+"SubjectDiv").innerHTML = document.getElementById(obj+"SubjectValue").value;
	if (flag=="true") {
		document.getElementById(obj+"Edit").innerHTML = "<a onclick=editCampaign('"+obj+"')> | Edit Campaign</a>";
		document.getElementById(obj+"Edit").style.display="inline-block";
	}

	if (document.getElementById(obj+"HTMLContentValue")) {
		//document.getElementById(obj+"HTMLContentDiv").innerHTML = document.getElementById(obj+"HTMLContentValue").value;
	}
	if (document.getElementById(obj+"TextContentValue")) {
		//document.getElementById(obj+"TextContentDiv").innerHTML = document.getElementById(obj+"TextContentValue").value;
	}

	return true;
}

function loadTemplateDisplay(obj) {
		//document.getElementById("light").style.display='block';
		//document.getElementById("fade").style.display='block';
		//document.getElementById("campaignSubject").innerHTML=document.getElementById(obj+"SubjectValue").value;
		//document.getElementById("campaignHTMLContent").innerHTML=document.getElementById(obj+"HTMLContentValue").value;
		var subject = document.getElementById(obj+"SubjectValue").value;
		var htmlContent = document.getElementById(obj+"HTMLContentValue").value;
		var myWindow = window.open("", subject,'width=680,location=no,toolbar=no,menubar=no,status=no,resizable=0,scrollbars=yes,height=700,top=100,left=100');
		myWindow.document.write(htmlContent);

}

function <portlet:namespace />extractCodeFromEditor() {
	var x = window.<portlet:namespace />editor.getHTML();
	document.getElementById("EditorContent").value=x;
	document.<portlet:namespace />fm.EditorContent.value = x;
}

function loadMailTemplateDetail(optionValue,subjectId,htmlContentId,textContentId,mailTemplate) {

	var AI=AUI();
	var itemis = null;
	var reqUrlis = '<portlet:resourceURL id="" />';
	var imageURL = '<%= previewIcon %>';

	var e = document.getElementById(optionValue);
	var filter= e.options[e.selectedIndex].value;

	try{
	 	AI.io.request(reqUrlis, {
		    cache: false,
		    sync: true,
		    timeout: 1000,
		    dataType: 'json',
		    method: 'post',
		    data:{
		   	 filterName:"templateDetail",
		   	 filterValue:filter,
		    },

		    on: {
		        success: function() {
		       	 itemis = this.get('responseData');
		       	if (itemis) {
		       		for (key in itemis) {
		       			var cellTextValues = itemis[key];
		       			for (key in cellTextValues) {
		       				switch(key) {
		       				case "subject":
							   			   document.getElementById(subjectId+"Value").value = cellTextValues[key];break;
		       				case "htmlContent":
		       								   document.getElementById(htmlContentId+"Value").value = cellTextValues[key];break;
		       				case "textContent":
							   				   document.getElementById(textContentId+"Value").value = cellTextValues[key];break;
		       				case "templateId": document.getElementById(mailTemplate+"Expand").innerHTML = "<a onclick='loadContent("+cellTextValues[key]+")'><img alt='Load' src='"+imageURL+"'/></a>";break;

		       				}
		       			}
		       		}
		       		document.getElementById(mailTemplate+"Section").className="mailTemplateSectionSlide";
		       		//document.getElementById(mailTemplate+"Expand").innerHTML = "<a onclick=collapse('"+mailTemplate+"')>Hide Detail</a>";
		       		document.getElementById(mailTemplate+"Expand").style.display="inline-block";
		       		//document.getElementById(mailTemplate+"Edit").style.display="inline-block";
		       		document.getElementById(mailTemplate+"Schedule").style.visibility="visible";
		       	}
		        },

		        failure: function() {
		        }
		    }
		});

	return true;
}catch(err) {
}
}
function collapse(obj) {
	document.getElementById(obj+"Section").className="mailTemplateSectionHidden";
	document.getElementById(obj+"Expand").innerHTML = "<a onclick=expand('"+obj+"')>Show Detail</a>";
	document.getElementById(obj+"Schedule").style.visibility="hidden";
	return false;
}
function expand(obj) {
	document.getElementById(obj+"Section").className="mailTemplateSectionSlide";
	document.getElementById(obj+"Expand").innerHTML = "<a onclick=collapse('"+obj+"')>Hide Detail</a>";
	document.getElementById(obj+"Schedule").style.visibility="visible";
	return false;
}

function editCampaign(obj) {
	document.getElementById(obj+"Id").style.visibility="visible";
	document.getElementById(obj+"Section").className="mailTemplateSectionSlide";
}

function checkSchedule(obj) {
	if (document.getElementById(obj).style.display=="none") {
		document.getElementById(obj).style.display="block";
	}else {
		document.getElementById(obj).style.display="none";
	}

}

function validation() {

	if (document.getElementById("campaignName").value.length==0) {
		alert("Campaign Name should not be empty!");

		return false;
	}else {
		var editFlag = document.getElementById("editableFlag").value;
		if (editFlag == "false") {
		}else {
			document.getElementById("form1").submit();
		}

	}
}


	function performAjaxSubmit() {
		var reqRenUrl = '<portlet:resourceURL id="" />'+'&cmd=imagesUpload';

	   // var sampleText = document.getElementById("sampleText").value;

		var sampleFile = document.getElementById("imageFiles").files[0];

		var formdata = new FormData();

		//formdata.append("sampleText", sampleText);

		formdata.append("sampleFile", sampleFile);

		var xhr = new XMLHttpRequest();

	   // xhr.open("POST","/fileUploadTester/FileUploader", true);

		if (window.XMLHttpRequest) {
			xhr.open("POST", reqRenUrl, true);
			//xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xhr.onreadystatechange=function() {
	 			if (xhr.readyState==4 && xhr.status==200) {
	 					var data = xhr.responseText.split(":");

	 					var imageURL = '<%= url %>'
									+ data[1].substring(1, data[1].length - 2);
							document.getElementById("fileEntryId").value = data[0]
									.substring(2, data[0].length - 1);
							document.getElementById("divImageFiles").innerHTML += "<font style='padding-right:15px;font-weight:bold;'> image url :</font>"
									+ imageURL
									+ "<br /><img alt='Image' src='"+imageURL+"'' style='width:150px;height:100px;margin-top:10px;margin-bottom:10px;' /><br />";
						}
					};
				}
				xhr.send(formdata);

			}

			function closeTemplateScreen() {
				document.getElementById('light').style.display = 'none';
				document.getElementById('fade').style.display = 'none';
				document.getElementById("campaignSubject").innerHTML = " ";
				document.getElementById("campaignHTMLContent").innerHTML = " ";
			}
		</script>

	</c:otherwise>
</c:choose>

<script src="<%=request.getContextPath() %>/js/campaignCreate.js">
</script>
<script>
showAddButon();
var A;
var AArray;
AUI().use('aui-node','aui-base','aui-event','aui-io-request','aui-datepicker',function(A1){
	A = A1;
	AArray = A.Array;
	var config = {
		pns : '<portlet:namespace />',
		ajaxUrl : '<%=ajaxUrl%>' 
	};
	var cc  = new campaignCreate(config);
	
});

AUI().use(
		  'aui-timepicker',
		  function(A) {
		    new A.TimePicker(
		      {
		        trigger: '.timePicker',
		        popover: {
		          zIndex: 1
		        },
		        on: {
		          selectionChange: function(event) {
		            console.log(event.newSelection)
		          }
		        }
		      }
		    );
		  }
		);

</script>	
