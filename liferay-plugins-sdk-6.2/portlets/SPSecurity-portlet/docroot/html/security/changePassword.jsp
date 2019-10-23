
<table width="100%">
	<tr valign="bottom">
		<td colspan="2">Change your account password.</td>
	</tr>

	<tr style="height:40px;">
		<td class="leftColumn">Enter old password:*</td>
		<td class="rightColumn"><input type="password" name="currentPassword" id="currentPassword" value="" style="width: 250px;" /></td>
	</tr>

	<tr style="height:40px;">
		<td class="leftColumn">Enter new password:*</td>
		<td class="rightColumn"><input type="password" name="password1" id="password1" value="" style="width: 250px;"  maxlength="75" /></td>
	</tr>

	<tr style="height:40px;">
		<td class="leftColumn">Confirm new password:*</td>
		<td class="rightColumn"><input type="password" name="password2" id="password2" value="" style="width: 250px;"  maxlength="75" /></td>
	</tr>

	<tr align="left" style="height:40px; margin-top:30px;">
		<td align="left" colspan="2">
	   		<input type="button" value="Save Changes" name="button" style="margin-left: 15px;" onclick="javascript:<portlet:namespace />submitForm('changePassword');" />
	   		<input type="Reset" value="Cancel" name="Reset" style="margin-left: 15px;" onclick="javascript:<portlet:namespace />submitForm('cancel');" />
	   </td>
	</tr>
</table>