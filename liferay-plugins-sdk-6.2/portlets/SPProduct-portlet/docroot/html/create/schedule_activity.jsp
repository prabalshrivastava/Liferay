<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<div class="Schedule_wrapper" id="SchedulewrapperId_0">
	<div class="form-inner Form-padding">
		<div class="sc_head">
			<div class="sc_title">
				<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.schedule")%>
				<div class="close_button">
					<span onclick="javascript:removeByInstanceId('SchedulewrapperId_0');"><img
						src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg"
						alt="Close"></span>
				</div>
			</div>
		</div>
		<div class="form-summary-inner">
			<div class="Input_Fullwidth">
				<input id="sessionNumberId_0" name="sessionNumber_0" type="text"
					value="" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.sessionNumber")%>" class="sessionNumber">
			</div>
			<div class="Input_Fullwidth margin-20-topbottom">
				<liferay-ui:input-editor name='<%="eligibility_criteria_desc_0"%>'
					editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="sp"
					initMethod='<%="initEditor_eligibility_criteria_desc"%>'
					cssClass="ckeditor" height="150" />
				<input type="hidden" value="" name="Ip_eligibility_criteria_desc_0"
					id="Ip_eligibility_criteria_desc_0">
				<aui:script>
					function <portlet:namespace />initEditor_eligibility_criteria_desc() {
						return "<%=UnicodeFormatter.toString(eligibilityCriteriaDescLabel)%>";
					}
				</aui:script>
					
				</div>
			<div class="Input_HalfWidth Margin-20">
				<div class="select_style" id="sessionType_select">
					<select id="sessionTypeListId_0" name="sessionTypeList_0"
						class="sessionTypeList">
						<option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.sessionType")%></option>
						<c:forEach var="sessionType" items="${sessionTypeList}">
							<option value="${sessionType.categoryId}">${sessionType.name}</option>
						</c:forEach>

					</select>
				</div>
			</div>
			<div class="Input_HalfWidth">
				<input type="text" id="sessionDurationId_0" name="sessionDuration_0"
					class="sessionDuration scheduleFields" value=""
					placeholder='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.sessionDuration")%>'>
			</div>
		</div>
	</div>

	<!--ACTIVITY SECTION-->
	<div id="activitySectionId_0">
		<div class="Input_Fullwidth text-right ">
			<a href="javascript:addActivityInstances(0,false);"
				class="Button-green button-pos-right Add_Activitytype"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.addActivity")%></a>
		</div>
		<div id="activityInner">

			<div class="Activity_wrapper" id="activitywrapperId_0">
				<div
					class="form-inner Border Form-padding Form-bg FormBorder-active ">
					<div class="close_button">
						<span onclick="javascript:removeByInstanceId('activitywrapperId_0');"><img
							src="<%=request.getContextPath()%>/images/Product_create/Close-icon.svg"
							alt="Close"></span>
					</div>
					<div class="form-summary-inner">
						<liferay-ui:input-editor
							name='<%="SchedulewrapperId_0_activitywrapperId_0_activity_desc_0"%>'
							editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="sp"
							initMethod='<%="initEditor_activity_desc"%>' cssClass="ckeditor"
							height="150" />
						<%-- onChangeMethod='<%="updateInputField"%>'  --%>
						<input type="hidden" value=""
							name="Ip_SchedulewrapperId_0_activitywrapperId_0_activity_desc_0"
							id="Ip_SchedulewrapperId_0_activitywrapperId_0_activity_desc_0">
						<aui:script>
							function <portlet:namespace />initEditor_activity_desc() {
								return "<%=UnicodeFormatter.toString(activityDescLabel)%>";
							}
						</aui:script>
					
						</div>
					<div class="Input_HalfWidth Margin-20">
						<input type="text"
							id="SchedulewrapperId_0_activitywrapperId_0_activityTimingId_0"
							name="SchedulewrapperId_0_activitywrapperId_0_activityTiming_0"
							class="activityTiming scheduleFields"
							value=""
							placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.activityTiming")%>">
					</div>
					<div class="Input_HalfWidth">
						<input type="text"
							id="SchedulewrapperId_0_activitywrapperId_0_activityPerformerId_0"
							name="SchedulewrapperId_0_activitywrapperId_0_activityPerformer_0"
							class="activityPerformer scheduleFields" value=""
							placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.activityPerformer")%>">
					</div>
					<div class="Input_HalfWidth Margin-20">
						<input type="text" id="activityDurationId_0"
							name="SchedulewrapperId_0_activitywrapperId_0_activityDuration_0"
							class="activityDuration scheduleFields" value=""
							placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.activityDuration")%>">
					</div>

				</div>
			</div>

		</div>
	</div>
	<div id="activityAppendSection"></div>
</div>
