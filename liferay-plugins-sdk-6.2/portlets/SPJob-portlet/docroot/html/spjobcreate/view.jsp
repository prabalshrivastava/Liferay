<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>

<%@ page import="com.sambaash.platform.srv.spjob.model.SPJob" %>

<%@ page import="java.util.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<style type="text/css">

</style>

<portlet:resourceURL var="notefToSuggestionsURL">
	<portlet:param name="action" value="notefToSuggestions"></portlet:param>
</portlet:resourceURL>

<script type="text/javascript">

	function simulate(element, eventName) {
	    var options = extend(defaultOptions, arguments[2] || {});
	    var oEvent, eventType = null;

	    for (var name in eventMatchers) {
	        if (eventMatchers[name].test(eventName)) { eventType = name; break; }
	    }

	    if (!eventType)
	        throw new SyntaxError('Only HTMLEvents and MouseEvents interfaces are supported');

	    if (document.createEvent) {
	        oEvent = document.createEvent(eventType);
	        if (eventType == 'HTMLEvents')
	        {
	            oEvent.initEvent(eventName, options.bubbles, options.cancelable);
	        }
	        else
	        {
	            oEvent.initMouseEvent(eventName, options.bubbles, options.cancelable, document.defaultView,
	            options.button, options.pointerX, options.pointerY, options.pointerX, options.pointerY,
	            options.ctrlKey, options.altKey, options.shiftKey, options.metaKey, options.button, element);
	        }
	        element.dispatchEvent(oEvent);
	    }
	    else {
	        options.clientX = options.pointerX;
	        options.clientY = options.pointerY;
	        var evt = document.createEventObject();
	        oEvent = extend(evt, options);
	        element.fireEvent('on' + eventName, oEvent);
	    }
	    return element;
	}

	function extend(destination, source) {
	    for (var property in source)
	      destination[property] = source[property];
	    return destination;
	}

	var eventMatchers = {
	    'HTMLEvents': /^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,
	    'MouseEvents': /^(?:click|dblclick|mouse(?:down|up|over|move|out))$/
	}

	var defaultOptions = {
	    pointerX: 0,
	    pointerY: 0,
	    button: 0,
	    ctrlKey: false,
	    altKey: false,
	    shiftKey: false,
	    metaKey: false,
	    bubbles: true,
	    cancelable: true
	}

</script>

<script type="text/javascript">

function SimpleTabSheet(param) {

	var that = this;

	this.j_tabsheet = null;

	var cur_tab = null;
	var count = 0;

	function __construct(p) {
	try{
		for (pkey in p) {
			if (pkey[0] != "_") {
				that[pkey] = p[pkey];
			}
		}

		initTabSheet();
	}catch(err) {
		alert(err);
	}
	}

	function initTabSheet() {
	try{
		for (var i=0;i<that.j_tabsheet.length;i++) {
			var j_tab_obj = that.j_tabsheet[i];
			var j_tab = j_tab_obj.j_tab;
			var j_tab_selected_by_default = j_tab_obj.j_tab_selected_by_default;

			j_tab.setAttribute("data-tabsheet-index", i);

			if (j_tab_selected_by_default === true) {
				cur_tab = j_tab;
				showSelectedTab(j_tab);
			}

			if (navigator.appName == 'Microsoft Internet Explorer') {
				addEventHandler(j_tab, "click", tabClick);
			}else {
				j_tab.addEventListener ("click", tabClick, false);
			}

			count++;
		}

	}catch(err) {
		alert(err);
	}
	}

	function tabClick(e) {
	try{
		e.preventDefault();

		var selected_tab = getEventTarget(e);
				if (hasClass(selected_tab.parentNode, "tab")) {
					selected_tab = selected_tab.parentNode;
				}

		if (cur_tab) {
			if (selected_tab.getAttribute("data-tabsheet-index") === cur_tab.getAttribute("data-tabsheet-index")) {
				//do nothing
			}else {
				//hide current tab
				hideCurrentTab();
				//show select tab
				showSelectedTab(selected_tab);
				cur_tab = selected_tab;
			}
		}else {
			showSelectedTab(selected_tab);
			cur_tab = selected_tab;
		}
	}catch(err) {
		alert(err);
	}
	}

	function showSelectedTab(selected_tab) {
	try{
		var selected_tab_content = document.getElementById(selected_tab.id + "_content");

		if (!hasClass(selected_tab, "active")) {
			addClass(selected_tab, "active");
		}

		if (!hasClass(selected_tab_content, "active")) {
			addClass(selected_tab_content, "active");
		}
	}catch(err) {
		alert(err);
	}
	}

	function hideCurrentTab() {
	try{
		if (cur_tab) {
			var cur_tab_content = document.getElementById(cur_tab.id + "_content");
			if (hasClass(cur_tab, "active")) {
				removeClass(cur_tab, "active");
			}
			if (hasClass(cur_tab_content, "active")) {
				removeClass(cur_tab_content, "active");
			}
		}
	}catch(err) {
		alert(err);
	}
	}

	__construct(param);

}

</script>

<c:choose>
<c:when test="${postServiceHasAccess}">

	<%
	SPJob spJob = (SPJob)request.getAttribute("SP_JOB");

	long spJobId = ParamUtil.getLong(request, "spJobId");

	String jobDescription = StringPool.BLANK;

	Calendar startCal = com.liferay.portal.kernel.util.CalendarFactoryUtil.getCalendar(timeZone, locale);
	Calendar endCal = com.liferay.portal.kernel.util.CalendarFactoryUtil.getCalendar(timeZone, locale);
	Calendar closingCal = com.liferay.portal.kernel.util.CalendarFactoryUtil.getCalendar(timeZone, locale);
	%>

	<portlet:actionURL var="editSPJobURL">
		<portlet:param name="action" value="editSPJob" />
	</portlet:actionURL>

	<%
	if (spJob != null) {
		jobDescription = spJob.getJobDescription();
		Date startDate = spJob.getStartDate();
		Date endDate = spJob.getEndDate();
		Date closingDate = spJob.getClosingDate();
		if (startDate != null) {
			startCal.setTime(startDate);
		}
		if (endDate != null) {
			endCal.setTime(endDate);
		}
		if (closingDate != null) {
			closingCal.setTime(closingDate);
		}
		%>

		<h2><liferay-ui:message key="${communityName}.label.post.edit.job" /> '<b><%= spJob.getJobTitle() %>'</b></h2>

		<%
	}else {
		%>

		<h2><liferay-ui:message key="${communityName}.label.post.post.job" /></h2>
		<c:set value="${true}" var="newJob" />

		<%
	}
	%>

	<br />
	<c:choose>
		<c:when test="${newJob || (!newJob && (isCommunityAdmin || themeDisplay.userId == spJob.userId))}">

			<div id="spjob_tab_sheet">
				<ul class="horizontal">
					<li><a class="spjob-tab" href="javascript:;" id="<portlet:namespace />tab_1">STEP 1 : Detail</a></li>
					<li><a class="spjob-tab" href="javascript:;" id="<portlet:namespace />tab_2">STEP 2 : Preview</a></li>
				</ul>
			</div>

			<div class="spjob-tab-content" id="<portlet:namespace />tab_1_content">

				<p class="spjob-field-required">* denotes required field</p>
				<br />
				<aui:form action="<%= editSPJobURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>
					<aui:input name="jobId" type="hidden" value="<%= spJobId %>" />
					<aui:input name="draft" type="hidden" />
					<aui:input name="attachments" type="hidden" value="false" />

					<liferay-ui:error exception="<%= com.sambaash.platform.srv.spjob.SPJobCategoriesException.class %>" message="Invalid categories" />
					<liferay-ui:error exception="<%= com.sambaash.platform.srv.spjob.SPJobDescriptionException.class %>" message="Invalid job description" />
					<liferay-ui:error exception="<%= com.sambaash.platform.srv.spjob.SPJobLocationException.class %>" message="Invalid location" />
					<liferay-ui:error exception="<%= com.sambaash.platform.srv.spjob.SPJobNameException.class %>" message="Invalid job name" />
					<liferay-ui:error exception="<%= com.sambaash.platform.srv.spjob.SPJobTagsException.class %>" message="Invalid tags" />
					<liferay-ui:error exception="<%= com.sambaash.platform.srv.spjob.SPJobTypeException.class %>" message="Invalid job type" />

					<liferay-ui:error exception="<%= com.liferay.portal.kernel.upload.UploadException.class %>" message="an-unexpected-error-occurred-while-uploading-your-file" />
					<liferay-ui:error exception="<%= com.sambaash.platform.srv.spjob.SPJobImageNameException.class %>" message="Invalid image name" />
					<liferay-ui:error exception="<%= com.sambaash.platform.srv.spjob.SPJobImageSizeException.class %>">

						<%
						String spJobImageMaxSizeStr = portletPreferences.getValue("spJobImageMaxSize", "307200");
						long spJobImageMaxSize = Long.valueOf(spJobImageMaxSizeStr);
						%>

						<liferay-ui:message arguments="<%= spJobImageMaxSize %>" key="please-enter-a-file-with-a-valid-file-size-no-larger-than-x" />
					</liferay-ui:error>

					<liferay-ui:error exception="<%= com.sambaash.platform.srv.spjob.SPJobImageTypeException.class %>" message="please-enter-a-file-with-a-valid-file-type" />

					<liferay-ui:asset-categories-error />
					<liferay-ui:asset-tags-error />

					<aui:model-context bean="<%= spJob %>" model="<%= SPJob.class %>" />

					<aui:fieldset>

						<label class="field-label" for="<portlet:namespace />corporateName"><liferay-ui:message key="${communityName}.label.post.company.name" /></label>
						<aui:input cssClass="spjob-box-sizing" label="" name="corporateName" value="" />

						<label class="field-label" for="<portlet:namespace />jobTitle"><liferay-ui:message key="${communityName}.label.post.job.title" />*</label>
						<aui:input cssClass="spjob-box-sizing" label="" name="jobTitle" value="" />

						<div class="spjob-box-sizing">
							<label class="field-label" for="<portlet:namespace />jobType"><liferay-ui:message key="${communityName}.label.post.job.type" />*</label>
							<aui:select label="" name="jobType">
								<aui:option label="" value="" />
								<c:forEach items="${jobTypeAssetCategories}" var="jobTypeAssetCategory">
									<aui:option label="${jobTypeAssetCategory.name}" value="${jobTypeAssetCategory.name}" />
								</c:forEach>
							</aui:select>
						</div>

						<div class="spjob-box-sizing">
							<label class="field-label" for="<portlet:namespace />jobLocation"><liferay-ui:message key="${communityName}.label.post.job.location" />*</label>
							<aui:select label="" name="jobLocation">
								<aui:option label="" value="" />
								<c:forEach items="${jobLocationAssetCategories}" var="jobLocationAssetCategory">
									<aui:option label="${jobLocationAssetCategory.name}" value="${jobLocationAssetCategory.name}" />
								</c:forEach>
							</aui:select>
						</div>

						<div class="spjob-box-sizing">
							<label class="field-label" for="<portlet:namespace />yoe"><liferay-ui:message key="${communityName}.label.post.years.of.experience" /></label>
							<aui:select label="" name="yoe">
								<aui:option label="" value="" />
								<c:forEach items="${yoeAssetCategories}" var="yoeAssetCategory">
									<aui:option label="${yoeAssetCategory.name}" value="${yoeAssetCategory.name}" />
								</c:forEach>
							</aui:select>
						</div>
						
						<label class="field-label" for="<portlet:namespace />categories"><liferay-ui:message key="${communityName}.label.post.categories" />*</label>
						<aui:input label="" name="categories" type="assetCategories" />
						<label class="field-label" for="<portlet:namespace />tags"><liferay-ui:message key="${communityName}.label.post.tags" />*</label>
						<aui:input label="" name="tags" type="assetTags" />

						<label class="field-label" for="<portlet:namespace />jobDescription"><liferay-ui:message key="${communityName}.label.post.job.description" />*</label>
						<aui:field-wrapper label="">
							<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" height="120" initMethod='<%= "initEditor" %>' toolbarSet="editInPlaceWithLink" />
							<aui:input name="jobDescription" type="hidden" />
						</aui:field-wrapper>

						<label class="field-label" for="<portlet:namespace />fileName"><liferay-ui:message key="${communityName}.label.post.upload.image" />*</label>
						<aui:input label="" name="fileName" onChange='<%= renderResponse.getNamespace() + "manageAttachments();" %>' size="50" type="file" />

						<label class="field-label"><liferay-ui:message key="${communityName}.label.post.rate.or.salary" /></label>
						<div class="helper-clearfix">
							<div style="float: left;margin-right:5px;">
								<aui:select label="" name="currency">
									<aui:option label="" value="" />
									<aui:option label="USD" value="USD" />
									<aui:option label="SGD" value="SGD" />
									<aui:option label="CNY" value="CNY" />
									<aui:option label="LKR" value="LKR" />
									<aui:option label="VND" value="VND" />
									<aui:option label="HKD" value="HKD" />
									<aui:option label="THB" value="THB" />
									<aui:option label="PHP" value="PHP" />
									<aui:option label="MMK" value="MMK" />
									<aui:option label="MYR" value="MYR" />
									<aui:option label="KRW" value="KRW" />
									<aui:option label="JPY" value="JPY" />
									<aui:option label="IDR" value="IDR" />
									<aui:option label="INR" value="INR" />
								</aui:select>
							</div>
							<div style="float: left;margin-right:5px;">
								<aui:input label="" name="salary" value="" />
							</div>
							<div style="float: left;">
								<aui:select label="" name="rate">
									<aui:option label="" value="" />
									<aui:option label="per hour" value="per hour" />
									<aui:option label="per day" value="per day" />
									<aui:option label="per month" value="per month" />
									<aui:option label="per year" value="per year" />
								</aui:select>
							</div>
						</div>
						<div class="dateErrorMsg" id="dateErrorMsg"></div>
						<div class="helper-clearfix">
							<label class="field-label"><liferay-ui:message key="${communityName}.label.post.start.date" /></label>
							<liferay-ui:input-date
								dayValue="<%= startCal.get(Calendar.DAY_OF_MONTH) %>"
								dayParam="startDay"
								disabled="<%= false %>"
								firstDayOfWeek="<%= startCal.getFirstDayOfWeek() - 1 %>"
								monthParam="startMonth"
								monthValue="<%= startCal.get(Calendar.MONTH) %>"
								yearParam="startYear"
								yearValue="<%= startCal.get(Calendar.YEAR) %>"
							/>
							
						</div>

						<div class="helper-clearfix field-content">
							<label class="field-label"><liferay-ui:message key="${communityName}.label.post.closing.date" /></label>
							<liferay-ui:input-date
								dayValue="<%= closingCal.get(Calendar.DAY_OF_MONTH) %>"
								dayParam="closingDay"
								disabled="<%= false %>"
								firstDayOfWeek="<%= closingCal.getFirstDayOfWeek() - 1 %>"
								monthParam="closingMonth"
								monthValue="<%= closingCal.get(Calendar.MONTH) %>"
								yearParam="closingYear"
								yearValue="<%= closingCal.get(Calendar.YEAR) %>"
							/>
						</div>

						<c:if test="${enableNotificationTo }">
							<div class="fieldset">
								<aui:input name="notefto" type="hidden"></aui:input>
									<div id="notefDiv">
										<label for="ip_to" class="sp-group-column sp-group-of-ten"
											style="vertical-align: top;"> <span
											class="sp-group-ui-db"><liferay-ui:message key="${communityName}.label.post.job.notefTo" /></span></label>
										<div
											class="sp-group-nonuple-column sp-group-column sp-group-of-ten">
											<div data-autocomplete-dom-id="sis-holder"
												data-group-id="0" class="ip-to">
												<ul data-autocomplete-dom-id="selected-items"
													class="horizontal sp-group-ui-dib sp-group-ui-vam">

												</ul>
												<span class="ip-to-input-outer"><span
													style="visibility: hidden; z-index: -10000; position: relative; width: 100%;">Add
														Email Address&nbsp;</span><input data-autocomplete-dom-id="input"
													id="ip_to" type="text" tabindex="0"
													placeholder="Add Email Address" autocomplete="off" value=""
													class="ip-to-input" /></span>
											</div>
											<div data-autocomplete-dom-id="suggestions-board"
												class="ip-sb" style="display: none;">
												<div class="ip-sb-c" data-autocomplete-dom-id="close-btn"></div>
												<div data-autocomplete-dom-id="options"
													class="ip-sb-options"></div>

											</div>
										</div>
									</div>
								</div>
						</c:if>

						<br />
						<aui:button-row>
							<aui:button name="preview" type="button" value="Preview"  cssClass="btn-primary"/>
						</aui:button-row>

					</aui:fieldset>

				</aui:form>

			</div>

			<div class="spjob-tab-content" id="<portlet:namespace />tab_2_content">
				<h3>Preview</h3>
				<br />
				<label class="field-label" for="<portlet:namespace />corporateName_preview"><liferay-ui:message key="${communityName}.label.post.company.name" /></label>
				<div id="<portlet:namespace />corporateName_preview"></div>
				<br />
				<label class="field-label" for="<portlet:namespace />jobTitle_preview"><liferay-ui:message key="${communityName}.label.post.job.title" /></label>
				<div id="<portlet:namespace />jobTitle_preview"></div>
				<br />
				<label class="field-label" for="<portlet:namespace />jobType_preview"><liferay-ui:message key="${communityName}.label.post.job.type" /></label>
				<div id="<portlet:namespace />jobType_preview"></div>
				<br />
				<label class="field-label" for="<portlet:namespace />jobLocation_preview"><liferay-ui:message key="${communityName}.label.post.job.location" /></label>
				<div id="<portlet:namespace />jobLocation_preview"></div>
				<br />
				<label class="field-label" for="<portlet:namespace />yoe_preview"><liferay-ui:message key="${communityName}.label.post.years.of.experience" /></label>
				<div id="<portlet:namespace />yoe_preview"></div>
				<br />
				<label class="field-label" for="<portlet:namespace />assetCategoryNames_preview" id="<portlet:namespace />assetCategoriesLabelPreview"></label>
				<div id="<portlet:namespace />assetCategoryNames_preview"></div>
				<br />
				<label class="field-label" for="<portlet:namespace />assetTagNames_preview"><liferay-ui:message key="${communityName}.label.post.tags" /></label>
				<div id="<portlet:namespace />assetTagNames_preview"></div>
				<br />
				<label class="field-label" for="<portlet:namespace />jobDescription_preview"><liferay-ui:message key="${communityName}.label.post.job.description" /></label>
				<div id="<portlet:namespace />jobDescription_preview"></div>
				<br />
				<label class="field-label" for="<portlet:namespace />rateSalary_preview"><liferay-ui:message key="${communityName}.label.post.rate.or.salary" /></label>
				<div id="<portlet:namespace />rateSalary_preview"></div>
				<br />
				<label class="field-label" for="<portlet:namespace />startDate_preview"><liferay-ui:message key="${communityName}.label.post.start.date" /></label>
				<div id="<portlet:namespace />startDate_preview"></div>
				<br />
				<label class="field-label" for="<portlet:namespace />endDate_preview"><liferay-ui:message key="${communityName}.label.post.end.date" /></label>
				<div id="<portlet:namespace />endDate_preview"></div>
				<br />
				<label class="field-label" for="<portlet:namespace />closingDate_preview"><liferay-ui:message key="${communityName}.label.post.closing.date" /></label>
				<div id="<portlet:namespace />closingDate_preview"></div>
				<br />
				<c:if test="${enableNotificationTo }">
					<label class="field-label" for="<portlet:namespace />notefTo_preview"><liferay-ui:message key="${communityName}.label.post.job.notefTo" /></label>
					<div id="<portlet:namespace />notefTo_preview"></div>
				</c:if>
				<br />
				<aui:button-row>
					<aui:button name="backButton" type="button" value="Back" cssClass="btn-primary"/>
					<%-- <aui:button name="saveAsDraftButton" type="submit" value="Save as Draft" cssClass="btn-primary"/> --%>
					<aui:button name="saveButton" type="submit" value="Confirm" cssClass="btn-primary"/>
				</aui:button-row>
			</div>

			<script type="text/javascript">

			AUI().ready('aui-form-validator', 'aui-io-request', function(A) {
				var validator = new A.FormValidator({
					boundingBox: '#<portlet:namespace />fm',
				       errorClass: 'form-validator-error',
					rules: {
						<portlet:namespace />jobTitle: {
							required: true,
							rangeLength: [1,500]
						},
						<portlet:namespace />jobType: {
							required: true
						},
						<portlet:namespace />jobLocation: {
							required: true
						},
						<portlet:namespace />jobDescription: {
							required: true
						},
						<portlet:namespace />assetTagNames: {
							required: true
						},
						<portlet:namespace />assetCategoryIds_${assetCategoriesVocabularyId}: {
							required: true
						}
					},
					fieldStrings: {
						<portlet:namespace />jobTitle: {
							required: 'Job title is required',
							rangeLength: 'Job title must be less than or equal to 500 characters'
						},
						<portlet:namespace />jobType: {
							required: 'Job type is required'
						},
						<portlet:namespace />jobLocation: {
							required: 'Job location is required'
						},
						<portlet:namespace />jobDescription: {
							required: 'Job description is required'
						},
						<portlet:namespace />assetTagNames: {
							required: 'Tags for skills/qualifications is required'
						},
						<portlet:namespace />assetCategoryIds_${assetCategoriesVocabularyId}: {
							required: 'Creative fields is required'
						}
					},
					on: {
						blur: function(event) {
							var validator = event.validator;
							var field = validator.field;
						},
						validateField: function(event) {
							var validator = event.validator;
							var field = validator.field;
						},
						errorField: function(event) {
							var instance = this;
							var validator = event.validator;
							var field = validator.field;

							instance.highlight(field);
							if (instance.get('showMessages')) {
								var stackContainer = instance.getFieldStackErrorContainer(field);

								field.placeBefore(stackContainer);

								instance.printStackError(
									field,
									stackContainer,
									validator.errors
								);
								stackContainer.one("div").removeClass("form-validator-message");
							}
							event.halt();
						}
					}
				});

				var validateAddSPJobForm = function(event) {
					if (window.<portlet:namespace />editor) {
						document.<portlet:namespace />fm.<portlet:namespace />jobDescription.value = window.<portlet:namespace />editor.getHTML();
					}
					var dateValidation = fValidateStartAndEndDate();
					if(dateValidation){
						validator.validate();
						
						if (!validator.hasErrors()) {
	
							var corporateName = document.<portlet:namespace />fm.<portlet:namespace />corporateName.value;
							var jobTitle = document.<portlet:namespace />fm.<portlet:namespace />jobTitle.value;
							var jobType = document.<portlet:namespace />fm.<portlet:namespace />jobType.value;
							var jobLocation = document.<portlet:namespace />fm.<portlet:namespace />jobLocation.value;
							var yoe = document.<portlet:namespace />fm.<portlet:namespace />yoe.value;
							var jobDescription = document.<portlet:namespace />fm.<portlet:namespace />jobDescription.value;
	
							var assetobj = document.<portlet:namespace />fm.<portlet:namespace />assetCategoryIds_${assetCategoriesVocabularyId};
							var assetCategoryIds = [];
							if (assetobj) {
								assetCategoryIds = assetobj.value;
							}
							var assetTagNames = document.<portlet:namespace />fm.<portlet:namespace />assetTagNames.value;
	
							var startYear = document.<portlet:namespace />fm.<portlet:namespace />startYear.value;
							var startMonth = parseInt(document.<portlet:namespace />fm.<portlet:namespace />startMonth.value)+1;
							var startDay = document.<portlet:namespace />fm.<portlet:namespace />startDay.value;
	
							var closingYear = document.<portlet:namespace />fm.<portlet:namespace />closingYear.value;
							var closingMonth = parseInt(document.<portlet:namespace />fm.<portlet:namespace />closingMonth.value)+1;
							var closingDay = document.<portlet:namespace />fm.<portlet:namespace />closingDay.value;
							var rateSalary = document.<portlet:namespace />fm.<portlet:namespace />salary.value + document.<portlet:namespace />fm.<portlet:namespace />currency.value + " " + document.<portlet:namespace />fm.<portlet:namespace />rate.value;
	
							document.getElementById("<portlet:namespace />corporateName_preview").innerHTML = corporateName;
							document.getElementById("<portlet:namespace />jobTitle_preview").innerHTML = jobTitle;
							document.getElementById("<portlet:namespace />jobType_preview").innerHTML = jobType;
							document.getElementById("<portlet:namespace />jobLocation_preview").innerHTML = jobLocation;
							document.getElementById("<portlet:namespace />yoe_preview").innerHTML = yoe;
							document.getElementById("<portlet:namespace />jobDescription_preview").innerHTML = jobDescription;
							document.getElementById("<portlet:namespace />rateSalary_preview").innerHTML = rateSalary;
	
							var assetCategoryNames = "";
							if (assetCategoryIds.length > 0) {
								var assetCategoryIdArray = assetCategoryIds.split(',');
								var assetCategoryIdArrayLength = assetCategoryIdArray.length;
								for (var i = 0; i < assetCategoryIdArrayLength; i++) {
									var assetCategoryNameElem = document.getElementById("category" + assetCategoryIdArray[i]);
									var assetCategoryName = "";
									if (assetCategoryNameElem) {
										assetCategoryName = assetCategoryNameElem.innerHTML;
									}
									assetCategoryNames += assetCategoryName;
								}
							}
	
							document.getElementById("<portlet:namespace />assetCategoryNames_preview").innerHTML = assetCategoryNames;
							var assetCategLabel = document.getElementById("<portlet:namespace />assetCategoriesLabel_${assetCategoriesVocabularyId}");
							if (assetCategLabel) {
								document.getElementById("<portlet:namespace />assetCategoriesLabelPreview").innerHTML = assetCategLabel.innerHTML;
	
							}
		//					document.getElementById("<portlet:namespace />assetCategoriesLabelPreview").innerHTML = .innerHTML;
	
							document.getElementById("<portlet:namespace />assetTagNames_preview").innerHTML = assetTagNames;
	
							document.getElementById("<portlet:namespace />startDate_preview").innerHTML = startYear + "-" + startMonth + "-" + startDay;
							document.getElementById("<portlet:namespace />closingDate_preview").innerHTML = closingYear + "-" + closingMonth + "-" + closingDay;
							if (autoCompleteObj) {
								document.getElementById("<portlet:namespace />notefTo_preview").innerHTML = getNoteFtoIds();
							}
							simulate(document.getElementById("<portlet:namespace />tab_2"), "click");
						}
					}	
				}

				var backAddSPJobForm = function(event) {
					simulate(document.getElementById("<portlet:namespace />tab_1"), "click");
				}

				var getNoteFtoIds =function() {
					var ids ="";
					if (autoCompleteObj) {
						ids = autoCompleteObj.getSelectedIds();
					}
					return ids;
				}

				var setNotefToValue = function() {
					 if (autoCompleteObj) {
						var notefTo = A.one("#<portlet:namespace />notefto");
						if (notefTo) {
							notefTo.set('value',getNoteFtoIds());
						}
					 }
				}
				var saveAsDraftAddSPJobForm = function(event) {
					document.<portlet:namespace />fm.<portlet:namespace />draft.value = "true";
					setNotefToValue();

					A.one("#<portlet:namespace />fm").submit();
				}

				var confirmAddSPJobForm = function(event) {
					setNotefToValue();
					A.one("#<portlet:namespace />fm").submit();
				}

				A.one("#<portlet:namespace />preview").on("click", validateAddSPJobForm);

				A.one("#<portlet:namespace />backButton").on("click", backAddSPJobForm);
				/* A.one("#<portlet:namespace />saveAsDraftButton").on("click", saveAsDraftAddSPJobForm); */
				A.one("#<portlet:namespace />saveButton").on("click", confirmAddSPJobForm);

			});
			
			function fValidateStartAndEndDate()
			{	
				var startYear = document.<portlet:namespace />fm.<portlet:namespace />startYear.value;
				var startMonth = parseInt(document.<portlet:namespace />fm.<portlet:namespace />startMonth.value)+1;
				var startDay = document.<portlet:namespace />fm.<portlet:namespace />startDay.value;

				var closingYear = document.<portlet:namespace />fm.<portlet:namespace />closingYear.value;
				var closingMonth = parseInt(document.<portlet:namespace />fm.<portlet:namespace />closingMonth.value)+1;
				var closingDay = document.<portlet:namespace />fm.<portlet:namespace />closingDay.value;
				var start_date = startDay + "-" + startMonth + "-" + startYear;
				var end_date = closingDay + "-" + closingMonth + "-" + closingYear;
				var startDate = GetDate(start_date);
				var endDate = GetDate(end_date);
				var currentTime = new Date();
				var month = currentTime.getMonth() + 1;
				var day = currentTime.getDate();
				var year = currentTime.getFullYear();
				
				var crntDate = GetDate(day + "-" + month + "-" + year);
				var errMsg = "";
				
				if( startDate > endDate )
				{
					errMsg = "End date should be later than start date";
					document.getElementById("dateErrorMsg").innerHTML = errMsg;
					return false;
				}else if(crntDate > startDate){
					errMsg = "Start date cannot be earlier than current date";
					document.getElementById("dateErrorMsg").innerHTML = errMsg;
					return false;
				}else{
					return true;
				}
				
			}


			function GetDate(text)
			{
				var text1 = text.toString();
				var splits=text1.split("-");
				var xx=splits.length;
				
				for(var x=0;x<xx;++x){
					splits[x]=parseInt(splits[x],10);
				}
				return new Date(splits[2],splits[1]-1,splits[0]);
				
			}
			</script>

			<aui:script>

				function <portlet:namespace />getSuggestionsContent() {
					var content = '';

					content += document.<portlet:namespace />fm.<portlet:namespace />jobTitle.value + ' ';
					content += window.<portlet:namespace />editor.getHTML();
					document.title += " -content: " + content;
					return content;
				}

				function <portlet:namespace />manageAttachments() {
					document.<portlet:namespace />fm.encoding = "multipart/form-data";
					document.<portlet:namespace />fm.<portlet:namespace />attachments.value = "true";
				}

				function <portlet:namespace />initEditor() {
					return "<%= UnicodeFormatter.toString(jobDescription) %>";
				}

			</aui:script>

			<script type="text/javascript">

			AUI().ready('', function(A) {

				new SimpleTabSheet({
					'j_tabsheet' : [
										{ 'j_tab' : document.getElementById("<portlet:namespace />tab_1"), 'j_tab_selected_by_default' : true },
										{ 'j_tab' : document.getElementById("<portlet:namespace />tab_2"), 'j_tab_selected_by_default' : false }
								   ]
				});

			});

			</script>

		</c:when>
		<c:otherwise>
			<div class="portlet-msg-alert">You don't have the permission to edit this job.</div>
		</c:otherwise>
	</c:choose>

</c:when>
<c:otherwise>
	<div class="portlet-msg-error">You don't have access to this page.</div>
</c:otherwise>
</c:choose>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.liferay-plugins-sdk-6.1.0.portlets.SPJob-portlet.docroot.view.create.view.jsp";
%>

<script src="/SPJob-portlet/js/auto_complete.js"> </script>

<script type="text/javascript">
var autoCompleteObj = null;
<c:if test="${enableNotificationTo }">
try{
	var j_ip_form = document.getElementById("notefDiv");
	var notefToHiden = document.getElementById("<portlet:namespace />notefto");
	//alert(notefToHiden.value);
	var j_autocomplete_sis_holder = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "sis-holder");
	var j_autocomplete_input = getFirstElementsByAttribute(document, "input", "data-autocomplete-dom-id", "input");
	var j_autocomplete_suggestions_board = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "suggestions-board");
	var j_autocomplete_close_btn = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "close-btn");
	var j_autocomplete_options = getFirstElementsByAttribute(document, "div", "data-autocomplete-dom-id", "options");
	var j_autocomplete_selected_items = getFirstElementsByAttribute(document, "ul", "data-autocomplete-dom-id", "selected-items");

	autoCompleteObj = new AutoComplete({
		'j_ip_form' : j_ip_form,
		'j_autocomplete_sis_holder' : j_autocomplete_sis_holder,
		'j_autocomplete_input' : j_autocomplete_input,
		'j_autocomplete_suggestions_board' : j_autocomplete_suggestions_board,
		'j_autocomplete_close_btn' : j_autocomplete_close_btn,
		'j_autocomplete_options' : j_autocomplete_options,
		'j_autocomplete_selected_items' : j_autocomplete_selected_items,
		'_duration_list' : '',
		'_find_suggestions_url' : '<%= notefToSuggestionsURL %>',
		'_portlet_namespace' : '<portlet:namespace />',
		'shareEmailList' : []
	});
	if (notefToHiden) {
		autoCompleteObj.createMailIds(notefToHiden.value);
	}
}catch(error) {
	console.log(error);
}
</c:if>
</script>