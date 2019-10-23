<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/security/init.jsp" %>

<%@ page import="com.liferay.portal.NoSuchUserException" %>
<%@ page import="com.liferay.portal.UserEmailAddressException" %>
<%@ page import="com.liferay.portal.UserReminderQueryException" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.model.PasswordPolicy" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>

<%@ page import="com.sambaash.platform.exception.UpdateFailedException" %>
<%@ page import="com.sambaash.platform.portlet.security.exception.WrongTempPasswordException" %>
<%@ page import="com.sambaash.platform.util.SambaashUtil" %>

<%@ page import="java.util.*" %>

<%@ page import="javax.portlet.*" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

<script type="text/javascript">
	function <portlet:namespace />submitForm(formAction) {
		document.getElementById("<portlet:namespace />formAction").value=formAction;
		document.<portlet:namespace />fm.submit();
	}
</script>

<%
		ThemeDisplay _themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PasswordPolicy passwordPolicy = _themeDisplay.getUser().getPasswordPolicy();
%>

<form action="<portlet:actionURL/>" id="<portlet:namespace />fm" method="post" name="<portlet:namespace />fm">
<liferay-ui:success key="SuccessPasswordChange" message="Successful! Password has been changed."></liferay-ui:success>
<liferay-ui:success key="SuccessReminderQuery" message="Successful! Your password reminder question has been changed."></liferay-ui:success>
<liferay-ui:success key="SuccessMessageWithWarning" message="Password Updated. You need to signout and login with the email address and password to activate this account." />
<liferay-ui:error exception="<%= Exception.class %>" message="Sorry, error" />
<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="Sorry, no such user exist" />
<liferay-ui:error exception="<%= UpdateFailedException.class%>" message='<%="Update failed on " + SambaashUtil.getThirdPartyAppUrl(_themeDisplay.getScopeGroupId()).substring(7) %>' />
<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="Please enter a valid email address" />
<liferay-ui:error exception="<%= UserReminderQueryException.class %>" message="Reminder Query and answer should not be empty" />
<liferay-ui:error exception="<%= WrongTempPasswordException.class %>" message="Current Password does not match" />
<liferay-ui:error key="ErrPasswordLength" message='<%= "Password length should be atleast " + passwordPolicy.getMinLength() + " characters."  %>'/>
<liferay-ui:error key="ErrPasswordAlreadyUsed" message="Password has already been used. Please enter in a different password." />
<liferay-ui:error key="ErrPasswordInvalid" message="Password is invalid. Please enter in a different password." />
<liferay-ui:error key="ErrPasswordTrival" message="Password is too trivial." />
<liferay-ui:error key="ErrPasswordCommon" message="Password uses common words. Please enter in a password that is harder to guess (i.e. contains a mix of numbers and letters)." />
<liferay-ui:error key="ErrPasswordChngWaitTime" message='<%= "You cannot change your password yet. Please wait at least " + LanguageUtil.getTimeDescription(pageContext, passwordPolicy.getMinAge() * 1000) + " before changing your password again." %>'/>
<liferay-ui:error key="ErrPasswordSameAsOld" message="Your new password cannot be the same as your old password. Please enter in a different password." />
<liferay-ui:error key="ErrPasswordCantChng" message="Your password cannot be changed." />
<liferay-ui:error key="ErrPasswordMatch" message="The passwords you entered do not match. Please re-enter your password." />
<liferay-ui:error key="ErrPasswordUnknown" message="Please contact support to update your password." />

<input id="<portlet:namespace />formAction" name="<portlet:namespace />formAction" type="hidden" />

<%
	if ( _themeDisplay.isSignedIn()) {
%>

<div id="show_public_profile">
<table align="center" cellpadding="0px" cellspacing="0px" class="fpassword" width="100%">
	<tbody>

				<%
					if (SambaashUtil.isSupportRole(_themeDisplay.getScopeGroupId(), _themeDisplay.getUserId())
								|| SambaashUtil.isAdmin(_themeDisplay.getScopeGroupId(), _themeDisplay.getUserId())) {
				%>

				<tr>
					<td colspan="2"><h1>Update Community User Details</h1></td>
				</tr>

				<tr>
					<td colspan="2"><%@ include file="/html/security/changePasswordUser.jsp" %>
					</td>
				</tr>

				<%
					} else {
				%>

		<tr>
			<td colspan="2"><h1>Personal settings</h1></td>
		</tr>

		<tr>
			<td colspan="2">
				<%@ include file="/html/security/changePassword.jsp" %>
			</td>
		</tr>

		<%
			}
		%>

	</tbody>
</table>
</div>

<%
	} else {
%>

	<div class="portlet-msg-error">You do not have permission to view this page.</div>

<%
	}
%>

</form>