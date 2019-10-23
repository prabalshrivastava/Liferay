<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

	<div>
	<div>
		<font class="header-pretitle">
			Current
		</font>
		<font class="header-posttitle">
			Job Role
		</font>
	</div>
	<div class="showdowheader-profile"></div>
	<div>
		<font class="header-pretitle" style="padding-left: 0;">based on</font><a href="http://www.nicf.sg" target="blank" class="header-posttitle"> National Infocomm Competency framework.</a>
	</div>
	<div id="JobRole_contents">
	<div class="workhistory_editAlignExt" id="">
		<div class="dynamic-section-button-align">
		<a class="book undo-button" href="javascript:cancelJobRoleInfo()" id="jobRole_view_cancel" title="cancel">&nbsp;</a>
		<a class="book update-button" href="javascript:saveJobRoleInfo()" id="jobRole_view_save" id="dynamic_section_test_save" style="float:right;" title="save">&nbsp;</a>
		</div>
	</div>
	<div class="maindivpersonalInfo">
	<div class="content-title">
		Functional Group
		<div class="seperatedline"></div>
	</div>
	<div class="userpersonaldetails-value-full-width">
		<div class="userpersonaldetails-value-Leftfull-width basicinfo-textedit" id="current_jobrole">
		<aui:layout>
			<aui:column>
			<c:if test="${jobRoleSaved != null}">
				<aui:select class="single-input" fieldName="current_jobrole_Id" id="current_jobrole_list" label="" name="current_jobrole_Id" onchange="javascript:jobRoleOnchange('current_jobrole_list','populateJobLevels',0)" value="">
					<aui:option label="" value="0"></aui:option>
					<c:forEach items="${jobRoleCategories}" var="jobRoleCategory">
						 <c:choose>
							<c:when test="${jobRoleSaved.categoryId == jobRoleCategory.categoryId}">
								<aui:option label="${jobRoleSaved.name}" selected="true" value="${jobRoleSaved.categoryId}"></aui:option>
							</c:when>
							<c:otherwise>
								<aui:option label="${jobRoleCategory.name}" value="${jobRoleCategory.categoryId}"></aui:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</aui:select>
			</c:if>
			<c:if test="${jobRoleSaved == null}">
				<aui:select class="single-input" fieldName="current_jobrole_Id" id="current_jobrole_list" label="" name="current_jobrole_Id" onchange="javascript:jobRoleOnchange('current_jobrole_list','populateJobLevels',0)" value="">
					<aui:option label="" value="0"></aui:option>
					<c:forEach items="${jobRoleCategories}" var="jobRoleCategory">
						<aui:option label="${jobRoleCategory.name}" value="${jobRoleCategory.categoryId}"></aui:option>
					</c:forEach>
				</aui:select>
			</c:if>
			</aui:column>
		</aui:layout>
		</div>
		<div class="msg_tooltip" id="jobrole_error_icon" style="cursor: pointer;" tooltip="Please select a Functional Group">
				</div>
	</div>
	</div>
	<div class="maindivpersonalInfo">
		<div class="content-title">
			Job Levels
			<div class="seperatedline"></div>
		</div>
		<div class="userpersonaldetails-value-full-width">
			<div class="userpersonaldetails-value-Leftfull-width basicinfo-textedit" id="current_jobrole">
			<aui:layout>
				<aui:column>
				<div id="jobLevelView" style="width: 80%; display: inline-block;">
				<c:if test="${jobLevelSaved != null}">
					<aui:select class="single-input" fieldName="current_joblevel_Id" id="current_jobLevel_list" label="" name="current_joblevel_Id" onchange="javascript:jobLevelOnchange('current_jobLevel_list','populateCompetencies',0)" value="">
						<aui:option label="" value="0"></aui:option>
						<%-- <aui:option label="${jobLevelSaved.name}" value="${jobLevelSaved.categoryId}" selected="true"></aui:option> <aui:option label="${jobLCategory.name}" value="${jobLCategory.categoryId}" selected="true"></aui:option>--%>
						<c:forEach items="${jobLevelCategories}" var="jobLCategory">
							<c:choose>
									<c:when test="${jobLevelSaved.categoryId == jobLCategory.categoryId}">
										<aui:option label="${jobLevelSaved.name}" selected="true" value="${jobLevelSaved.categoryId}"></aui:option>
									</c:when>
									<c:otherwise>
										<aui:option label="${jobLCategory.name}" value="${jobLCategory.categoryId}"></aui:option>
									</c:otherwise>
								</c:choose>
						</c:forEach>
					</aui:select>
				</c:if>
				<%-- <c:if test="${jobLevelSaved == null}">
					<aui:select class="single-input" fieldName="current_jobrole_Id" id="current_jobrole_list" label="" name="current_jobrole_Id" onchange="javascript:jobRoleOnchange('current_jobrole_list','populateJobLevels')" value="">
						<aui:option label="" value="0"></aui:option>
						<c:forEach items="${jobLevelCategories}" var="jobLCategory">
							<aui:option label="${jobLCategory.name}" value="${jobLCategory.categoryId}"></aui:option>
						</c:forEach>
					</aui:select>
				</c:if> --%>
				</div>
				<div class="msg_tooltip" id="joblevel_error_icon" style="cursor: pointer;" tooltip="Please select a Job Level">
				</div>
				<%-- <div id="careerPath_view">
					<div class="div_linkColor" id="careerPath_url" onClick="window.open('${careerPath.itemValue}','StatusBar','width=850,menubar=no,toolbar=no,resizable=yes,scrollbars=yes,location=0,height=700,top=100,left=100');">
						${careerPath.itemValue}
					</div>
					<input id="career_urlPath" type="hidden" value="${careerPath.spListTypeId}">
				</div> --%>
				</aui:column>
			</aui:layout>
			</div>
		</div>
	</div>
	<div class="maindivpersonalInfo">
		<div class="content-title">
			Competencies
			<div class="seperatedline"></div>
		</div>
		<div><span style="font-size: 11px; font-weight: 400; color: gray;">(Highlight your competency by ticking on the checkbox)</span></div>
		<div class="userpersonaldetails-value-full-width">
			<div class="userpersonaldetails-value-Leftfull-width basicinfo-textedit" id="current_jobrole">
				<div id="competencyView">
				<c:if test="${competecyLevelSaved != null}">
					<c:forEach items="${competecyLevelSaved}" var="competecyLevelSaved">
						<div style="margin-bottom:10px">
							<%-- <input type="Checkbox" value="${competecyLevelSaved.categoryId}" name="competency_checkbox[]" style="vertical-align:top"> --%>
							<div class="competencyLabel">
								<label class="jobRole_label" competency_categoryId="${competecyLevelSaved.categoryId}" id="competencyLabel_${competecyLevelSaved.categoryId}" name="competencyLabelName">${competecyLevelSaved.name}</label>
							</div><select id="competencyLevel_${competecyLevelSaved.categoryId}" style="margin-left: 2%; width: 28%;"></select><span>&nbsp;&nbsp;</span><input type="checkbox" id="competencyPubliclyViewCheckbox_${competecyLevelSaved.categoryId}" />
						</div>
					</c:forEach>
					</c:if>
				</div>
			</div>
			<div id="careerPath_view">
				<div career_path_url="${careerPath.itemValue}" class="nicf_url div_linkColor" id="careerPath_url" onClick="window.open('${careerPath.itemValue}','StatusBar','width=850,menubar=no,toolbar=no,resizable=yes,scrollbars=yes,location=0,height=700,top=100,left=100');">
					<font style="font-size: 15px;font-weight: bold;padding-left: 5px;">>> Upgrade myself to acquire these competencies</font>
				</div>
				<input id="career_urlPath" type="hidden" value="${careerPath.spListTypeId}">
				<div>
					<a class="nicf_url" href="/contact-us" style="margin-left: 33px;">
						<font>Can't find your Job Role? Contact us now.</font>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
</div>