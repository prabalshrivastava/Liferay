<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="java.util.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />
<c:choose>
<c:when test="${!jobNotFound}">
<liferay-util:html-top>                                                                                                                                                    
        <meta property="og:title" content="${jobDetailWrapper.title}"/>                                                                                                                   
        <meta property="og:description" content="${jobDetailWrapper.description}"/>                                                                                                       
        <meta property="og:image" content="<%=PortalUtil.getPortalURL(request) %>${jobDetailWrapper.imageUrl}"/>                                                                                                                   
        <meta property="og:url" content="<%= URLEncoder.encode(themeDisplay.getPortalURL() + themeDisplay.getURLCurrent(), "UTF-8")%>"/>                                                                                                                       
        <meta property="og:type" content="Job"/>                                                                                                                       
</liferay-util:html-top> 
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>

<liferay-portlet:renderURL var="dialogURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
<liferay-portlet:param name="mvcPath" value="/message.jsp" />
</liferay-portlet:renderURL>
<c:choose>
	<c:when test="${!jobNotFound}">
		<div style="padding: 15px; background-color: #EBEBEB; border: 1px solid black;">
			<div class="helper-clearfix">
				<div style="float: left; font-weight: bold;">${jobDetailWrapper.title}</div>
				<div style="float: right;">Posted on: ${jobDetailWrapper.createDate}</div>
			</div>
			<div align="right">
				<liferay-ui:social-bookmarks
					displayStyle="horizontal"
					target="_blank"
					title="${jobDetailWrapper.title}"
					url="<%= themeDisplay.getPortalURL() + themeDisplay.getURLCurrent() %>"
				/>
			</div>
			<br />
			<div><div style="width: 120px; display: inline-block;"><liferay-ui:message key="${communityName}.label.detail.job.type" />:</div><span>${jobDetailWrapper.type}</span></div>
			<div><div style="width: 120px; display: inline-block;"><liferay-ui:message key="${communityName}.label.detail.company.name" />:</div><span>${jobDetailWrapper.companyName}</span></div>
			<div class="jobdetail-apply"><div style="width: 120px; display: inline-block;"><liferay-ui:message key="${communityName}.label.detail.job.location" />:</div><span>${jobDetailWrapper.location}</span></div>
			<div><div style="width: 120px; display: inline-block;"><liferay-ui:message key="${communityName}.label.detail.years.of.experience" />:</div><span>${jobDetailWrapper.exp}</span></div>
			<div><div style="width: 120px; display: inline-block;"><liferay-ui:message key="${communityName}.label.detail.start.and.end.date" />:</div><span>${jobDetailWrapper.startDate}</span></div>
			<div><div style="width: 120px; display: inline-block;"><liferay-ui:message key="${communityName}.label.post.closing.date" />:</div><span>${jobDetailWrapper.closingDate}</span></div>
			<div><div style="width: 120px; display: inline-block;"><liferay-ui:message key="${communityName}.label.detail.rate.or.salary" />:</div><span>${jobDetailWrapper.cost}</span></div>
			<div><div style="width: 120px; display: inline-block;"><liferay-ui:message key="${communityName}.label.detail.categories" />:</div><span>${jobDetailWrapper.categories}</span></div>
			<div><div style="width: 120px; display: inline-block;"><liferay-ui:message key="${communityName}.label.detail.tags" />:</div><span>${jobDetailWrapper.tags}</span></div>
			<c:if test="${enableNoteF }">
				<div><div style="width: 120px; display: inline-block;"><liferay-ui:message key="${communityName}.label.post.job.notefTo" />:</div><span>${jobDetailWrapper.notefTo}</span></div>
			</c:if>

		</div>
		<br />
		
		<div style="padding: 15px; background-color: #EBEBEB; border: 1px solid black;">
			<div><img alt="Job Image" src="${jobDetailWrapper.imageUrl}" style="border:1px solid #000;max-width:700px" /></div>
			<br />
			<div><b>Job Description:</b></div>
			<br />
			${jobDetailWrapper.description}
			<br />
			<div class="yui3-skin-sam">
		<div id="errorMsg-Modal"></div>
		</div>
			<div align="right">
				<%-- <c:choose>
					<c:when test="<%= themeDisplay.isSignedIn() %>">
						<c:choose>
							<c:when test="${(jobDetailWrapper.userId == themeDisplay.userId)}">
								<input class="spjobs-mrm spjobs-owner-cannot-apply btn-primary" name="The member who posted the job can't apply for it." title="Application Denied" type="button" value="Apply for this job" />
							</c:when>
							<c:when test="${applyServiceHasAccess}">
								<aui:button cssClass="spjobs-mrm btn-primary" href="/${nameOfApplyPage}?id=${jobDetailWrapper.id}&show=apply" value="Apply for this job" />
							</c:when>
							<c:otherwise>
								<input id="applyRoleChk" class="spjobs-mrm spjobs-service-access btn-primary" name="${applyServiceUserStatus}" title="Permission Denied" type="button" value="Apply for this job" />
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
							<input id="applyRoleChk" class="spjobs-mrm spjobs-service-access btn-primary" name="${applyServiceUserStatus}" title="Login to apply" type="button" value="Apply for this job" />
					</c:otherwise>
				</c:choose> --%>
				<aui:button href="/${nameOfLandingPage}" value="Back"  cssClass="btn-primary"/>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="portlet-msg-error">This job posting is closed or not available.</div>
	</c:otherwise>
</c:choose>

<script>
function showPopup(){
	
YUI().use(
		  'aui-modal',
		  function(Y) {
		    var modal = new Y.Modal(
		      {
		        bodyContent: errMsg,
		        centered: true,
		        headerContent:'login',
		        draggable: false,
		        render: '#errorMsg-Modal',
		        resizable: false
		      }
		    ).render();
		  }
		);
}
		</script>



<aui:script>

AUI().use('aui-base', function(A) {

	var documentBody = A.one('document.body')
	if (documentBody) {
		documentBody.delegate(
			'click',
			function(event) {
				var name = this.get('name');
				var title = this.get('title');
				var popup = Liferay.Util.openWindow(
{
dialog: {
						bodyContent: name,
						centered: true,
						destroyOnClose: true,
						modal: true,
						headerContent: title,
						height: 160,
						width: 515
					}}
				);
			},
			'.spjobs-service-access'
		);
	}

});
</aui:script>
<aui:script>
	AUI().use('aui-base', function(A) {

		var documentBody = A.one('document.body')
		if (documentBody) {
			documentBody.delegate(
				'click',
				function(event) {
					var name = this.get('name');
					var title = this.get('title');
					var popup = Liferay.Util.Window.getWindow(
{
dialog: {
							bodyContent: name,
							centered: true,
							destroyOnClose: true,
							modal: true,
							headerContent: title,
							height: 160,
							width: 515
						}}
					).render();
				},
				'.spjobs-owner-cannot-apply'
			);
		}

	});

</aui:script>
