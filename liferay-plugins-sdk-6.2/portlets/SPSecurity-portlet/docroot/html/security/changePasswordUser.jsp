
<table width="100%">
	<tr valign="bottom">
		<td colspan="2"></br></td>
	</tr>

	<tr style="height:40px;">
		<td class="leftColumn">Enter EmailAddress:*</td>
		<td class="rightColumn"><input type="text" autocomplete="off" name="emailAddress" id="emailAddress" value="" style="width: 250px;" /></td>
	</tr>

	<tr style="height:40px;">
		<td class="leftColumn">Enter new password:*</td>
		<td class="rightColumn"><input type="password" autocomplete="off" name="userPassword1" id="userPassword1" value="" style="width: 250px;"  maxlength="75" /></td>
	</tr>

	<tr style="height:40px;">
		<td class="leftColumn">Confirm new password:*</td>
		<td class="rightColumn"><input type="password" autocomplete="off" name="userPassword2" id="userPassword2" value="" style="width: 250px;"  maxlength="75" /></td>
	</tr>

	<tr align="left" style="height:40px; margin-top:30px;">
		<td align="left" colspan="2">
	   		<input type="button" value="Save Changes" name="button" style="margin-left: 15px;" onclick="javascript:<portlet:namespace />submitForm('changePasswordUser');" />
	   		<input type="Reset" value="Cancel" name="Reset" style="margin-left: 15px;" onclick="javascript:<portlet:namespace />submitForm('cancel');" />
	   </td>
	</tr>
</table>