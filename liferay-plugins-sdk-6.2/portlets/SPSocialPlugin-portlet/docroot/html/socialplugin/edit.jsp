<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:actionURL var="submitAutoShareURL">
	<portlet:param name="action" value="autoshare" />
</portlet:actionURL>

<c:if test="${admin == true}">
	<div>
		<form id="<portlet:namespace />editSocialSharing" name="<portlet:namespace />editSocialSharing"
		action='<c:out value="${submitAutoShareURL}" />' method="post">

		<div class="reg-outer-wrap">
			<aui:layout cssClass="reg-content-wrap">
				<aui:layout cssClass="ms-row-content">
					<aui:column cssClass="left-align" first="true">
						<font class="header-pretitle">Enable <span class="header-posttitle">Auto-sharing</span></font>
					</aui:column>
				</aui:layout>
				<aui:layout cssClass="ms-row-content">
					<aui:column columnWidth="40" cssClass="left-align" first="true">
						<label>Facebook</label>
					</aui:column>
					<aui:column columnWidth="50" cssClass="left-align" first="true">
						<input name="facebook_share" type="checkbox" value="1" <c:if test="${facebook == 1}">checked="checked"</c:if>>
					</aui:column>
				</aui:layout>
				<aui:layout cssClass="ms-row-content">
					<aui:column columnWidth="40" cssClass="left-align" first="true">
						<label>Linkedin</label>
					</aui:column>
					<aui:column columnWidth="50" cssClass="left-align" first="true">
						<input name="linkedin_share" type="checkbox" value="1" <c:if test="${linkedin == 1}">checked="checked"</c:if>>
					</aui:column>
				</aui:layout>
				<aui:layout cssClass="ms-row-content">
					<aui:column columnWidth="40" cssClass="left-align" first="true">
						<label>Twitter</label>
					</aui:column>
					<aui:column columnWidth="50" cssClass="left-align" first="true">
						<input name="twitter_share" type="checkbox" value="1" <c:if test="${twitter == 1}">checked="checked"</c:if>>
					</aui:column>
				</aui:layout>

				<aui:layout cssClass="ms-row-content">
					<aui:column cssClass="left-align" first="true">
						<font class="header-pretitle">Post Status <span class="header-posttitle">API</span></font>
					</aui:column>
				</aui:layout>
				<aui:layout cssClass="ms-row-content">
					<aui:column columnWidth="40" cssClass="left-align" first="true">
						<label>Facebook API</label>
					</aui:column>
					<aui:column columnWidth="50" cssClass="left-align" first="true">
						<input name="facebook_api" type="text" value="${facebookAPI}" />
					</aui:column>
				</aui:layout>
				<aui:layout cssClass="ms-row-content">
					<aui:column columnWidth="40" cssClass="left-align" first="true">
						<label>Linkedin API</label>
					</aui:column>
					<aui:column columnWidth="50" cssClass="left-align" first="true">
						<input name="linkedin_api" type="text" value="${linkedinAPI}" />
					</aui:column>
				</aui:layout>
				<aui:layout cssClass="ms-row-content">
					<aui:column columnWidth="40" cssClass="left-align" first="true">
						<label>Twitter API</label>
					</aui:column>
					<aui:column columnWidth="50" cssClass="left-align" first="true">
						<input name="twitter_api" type="text" value="${twitterAPI}" />
					</aui:column>
				</aui:layout>
				<aui:layout>
				<aui:column cssClass="left-align" first="true">
					<aui:button name="save" type="submit" value="Save Changes" />
				</aui:column>
			</aui:layout>
			</aui:layout>

		</div>

	</div>
</c:if>