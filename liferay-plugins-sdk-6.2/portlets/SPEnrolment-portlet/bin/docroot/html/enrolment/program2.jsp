<%@page import="com.sambaash.platform.enrolement.EnrolmentConstants"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="com.sambaash.platform.constant.SystemSetupConstants"%>
 
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
 
<link rel='stylesheet' href='<%=request.getContextPath()%>/css/main.css?<%=System.currentTimeMillis()%>'>
 
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2"></script>
 
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
 
<c:set var="formStorageId"    value='<%=request.getParameter("formStorageId")%>' />
 
<portlet:defineObjects />
<liferay-theme:defineObjects />
 
<portlet:renderURL var="candidate">
    <portlet:param name="jspPage" value="/html/enrolment/candidate.jsp" />
    <portlet:param name="formStorageId" value="${formStorageId}" />
</portlet:renderURL>
 
<portlet:renderURL var="homePage">
    <portlet:param name="jspPage" value="/html/enrolment/view.jsp" />
</portlet:renderURL>
 
<portlet:renderURL var="fee">
    <portlet:param name="jspPage" value="/html/enrolment/fee.jsp" />
</portlet:renderURL>
 
<portlet:actionURL var="proceedToFees" name="proceedToFees">
</portlet:actionURL>
<%
    if (PermissionUtil.canAddModel((PortletRequest) request.getAttribute("javax.portlet.request"))) {
%>
<%
        String formId = portletPreferences.getValue(EnrolmentConstants.PREF_ENROLMENT_FORM_ID, EnrolmentConstants.DEFAULT_ENROLMENT_FORM_ID);
		if (StringUtils.isEmpty(formId)) {
			formId = EnrolmentConstants.DEFAULT_ENROLMENT_FORM_ID;
		}
		String cancelUrl = portletPreferences.getValue(EnrolmentConstants.PREF_ENROLMENT_CANCEL_URL, EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL);
		if (StringUtils.isEmpty(cancelUrl)) {
			cancelUrl = EnrolmentConstants.DEFAULT_ENROLMENT_CANCEL_URL;
		}
        String formType = "Programme";
        String dashBoardLink = SambaashUtil.getDashBoard();
        long userId = themeDisplay.getUserId();
        String formStorageId = request.getParameter("formStorageId");
%>
 
<div class="newPortlets enrolment-body enrolment-center-align">
    <div class="subHeader">
        <div class="container">
        	<div class="inner-container">
            <aui:row>
                <aui:col span="10" cssClass="text-center header-title">
                    <h2><span>PROCESS ENROLMENT</span></h2>
                </aui:col>
                <aui:col span="2" cssClass="text-right header-home-link">
                    <aui:a href="<%=homePage%>" title="Back to Dashboard">Back to Home</aui:a>
                </aui:col>
            </aui:row>
            </div>
 

        </div>
    </div>
    <div class="container">
        <div class="text-center">
            <div class="enrolment-center-align tabs mt-50">
                <div class="tab ">SPONSORSHIP</div>
 
                <div class="tab">CANDIDATE</div>
 
                <div class="tab tab-selected">PROGRAMME & SUBJECTS</div>
 
                <div class="tab">FEE</div>
            </div>
        </div>
        <div id="programme"></div>
        <div id="subjects"></div>
        <div class="text-center">
            <aui:button-row>
                <aui:button onClick="backToCandidate()" type="button"
                    value="PREVIOUS" />
                <aui:button type="submit" cssClass="btn-primary"
                    value="NEXT" />
                <aui:button type="submit" cssClass="btn-primary" disabled="true" 
                    value="SAVE" />
                <aui:button type="button" onClick="onCancelProcess()" value="CANCEL" />
            </aui:button-row>
        </div>
 
    </div>
</div>
 
<script type="text/javascript">
    var mode = "view";
    var feeUrl = "<%=fee%>";
    var formStorageId = "<%=formStorageId%>";
    var namespace = "<portlet:namespace/>";
    var candidateUrl = "<%=candidate%>";
    var homeUrl = "<%=cancelUrl%>";
 
    function afterFormLoadedFormIOForm(thisInstance) {
        var data = {
            "limit" : 10,
            "modelName" : "Subject",
            "page" : 0,
            "formType" : "Subject"
        };
    }
 
    
    function proceedToFee() {
        if (typeof formStorageId !== 'undefined' || formStorageId !== null) {
            location.href = feeUrl + "&" + namespace + "formStorageId="+ formStorageId;
        } else {
            location.href = feeUrl;
        }
 
    }
 
    function backToCandidate() {
        if (formStorageId == "null" || formStorageId == null) {
            location.href = candidateUrl;
        } else {
            location.href = candidateUrl + "&" + namespace + "formStorageId="+ formStorageId;
        }
    }
    function onCancelProcess() {
        location.href = homeUrl;
    }
    
    
    
    Formio.createForm(document.getElementById('programme'), {
          components: [
            {
                 type: 'select',
                 label: 'Programme + Semester',
                 key: 'programSemester',
                 placeholder: 'Type and search',
                 dataSrc: 'url',
                 data: {
                   url: 'http://localhost:8081/web/rc/welcome?p_p_id=enrolment_WAR_SPEnrolmentportlet&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&p_p_col_id=column-1&p_p_col_count=1&_enrolment_WAR_SPEnrolmentportlet_sp_p_auth=1Nxj6oEE&_enrolment_WAR_SPEnrolmentportlet_jspPage=%2Fhtml%2Fenrolment%2Fprogram.jsp&_enrolment_WAR_SPEnrolmentportlet_formId=&_enrolment_WAR_SPEnrolmentportlet_formStorageId=&_enrolment_WAR_SPEnrolmentportlet_formType=Programme&_enrolment_WAR_SPEnrolmentportlet_action=program&_enrolment_WAR_SPEnrolmentportlet_data=%7B%22limit%22%3A10%2C%22modelName%22%3A%22Programme%22%2C%22page%22%3A0%2C%22formType%22%3A%22Programme%22%7D'
                 },
                 valueProperty: "contentJson.ProgrammeTitle",
                 template: '<span>{{item.contentJson.ProgrammeTitle}}</span>',
                 selectValues: "content",
                 multiple: true,
                 input: true
            }
          ]
        });
    
</script>
<%
}
%>