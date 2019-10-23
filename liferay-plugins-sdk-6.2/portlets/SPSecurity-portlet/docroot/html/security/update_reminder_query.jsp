<%
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>

<%@ page import="java.util.Map" %>

	<%
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Map userInfoMap = (Map) request.getAttribute(PortletRequest.USER_INFO);
		User user = themeDisplay.getUser();
		long userId = themeDisplay.getUserId();
	%>

	<table width="100%">
	<tr height="30" valign="bottom">
		<td colspan="2">
			<font class="more">Password reminder question</font>
			<br>
		</td>
	</tr>

	<tr valign="bottom">
		<td colspan="2">Change your password reminder question.</td>
	</tr>

	<tr>
		<td class="leftColumn">Reminder Question:*</td>
		<td class="rightColumn">
			<select id="reminderQueryQuestion" name="reminderQueryQuestion">
				<option></option>
				<% for (String question : user.getReminderQueryQuestions()) { %>
				<option value="<%= question %>"><%= question %></option>
				<% } %>
			</select>
		</td>
	</tr>
	<tr>
		<td class="leftColumn">Reminder Answer:*</td>
		<td class="rightColumn">
			<input maxlength="75" name="reminderQueryAnswer" style="width: 250px;" type="text"  value="" />
		</td>
	</tr>
	<tr align="left" style="height:40px; margin-top:30px;">
		<td align="left" colspan="2">
			<input name="button" onclick="javascript:<portlet:namespace />submitForm('updateReminderQuestion');" style="margin-left: 15px;" type="button" value="Save Changes" />
			<input name="Reset" onclick="javascript:<portlet:namespace />submitForm('updateReminderQuestion');" style="margin-left: 15px;" type="Reset" value="Cancel" />
		</td>
	</tr>

	</table>