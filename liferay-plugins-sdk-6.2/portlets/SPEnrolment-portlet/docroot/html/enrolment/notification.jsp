<link rel='stylesheet' href='<%=request.getContextPath()%>/css/notification.css?<%=System.currentTimeMillis()%>'>


<div class="panel">
	<div class="p-5 text-center text-bold">
		Configure Notification
	</div>
	<div>
        <label>Notification Type</label>
        <select>
			<option value="feesacknowledgement">Fees Acknowledgement</option>
		</select>
		<div class="enrolment-center-align py-5">
            <aui:button-row cssClass="text-center">
                <aui:button cssClass="btn-primary" value="SEND EMAIL" />
                <aui:button type="button" value="CANCEL" />
            </aui:button-row>
        </div>
	</div>
</div>