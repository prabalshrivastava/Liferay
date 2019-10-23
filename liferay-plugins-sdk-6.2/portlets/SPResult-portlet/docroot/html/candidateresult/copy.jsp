<%@include file="/html/common/init.jsp" %>
<%
	String formStorageId = request.getParameter("storageId");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = td.getLayout().getGroupId();
	String dashboardLink = SambaashUtil.getParameter("dashboard.link", groupId);
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
	String dashBoardLink = SambaashUtil.getDashBoard();
%>

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%=AuthTokenUtil.getToken(request)%>" />
</portlet:resourceURL>

<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<aui:row>
				<aui:col span="10" cssClass="text-center">
					<h2>CANDIDATE RESULT</h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=dashBoardLink%>" title="Back to Dashboard">Back to Dashboard</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div class="candidateResultCapture">
		<div class="formContainer container formio-form">
			<form class="aui" id="candidateResultCapture_form"
				name="candidateResultCapture" action="">
				<aui:input name="" type="hidden" id="candidateResultCode" />
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<p id="formStatus" class="formStatus form_draft" style="padding: 2px 0px">
							Draft
						</p>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg">Select Facility Type.</div>
						<aui:row>
							<aui:col span="12" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Schedule (Programme) <span
										class="red-star">*</span></label>
									<aui:select name="" id="schedule" cssClass="form-control">
										
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						
						<aui:row>
							
							<aui:col span="12" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Candidate Number<span
										class="red-star">*</span></label>
									<aui:select name="" id="candidateNumber" cssClass="form-control">
										<%
											List<SPListType> catList = 
												SPListTypeLocalServiceUtil.getByKey("finance.accountingtable.productype", groupId);
											for(SPListType type : catList) {
												%><aui:option value="<%=type.getItemValue() %>"><%=type.getDisplayName() %></aui:option><%
											}
										%>
									</aui:select>
								</div>
							</aui:col>
							
						</aui:row>
						<aui:row>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">ID No
										<span class="red-star">*</span>
									</label>
									<aui:input type="text" name="" id="idNumber"
										cssClass="form-control" placeholder="Enter Details" >
									</aui:input>
								</div>
							</aui:col>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Candidate Name
										<span class="red-star">*</span>
									</label>
									<aui:input type="text" name="" id="candidateName"
										cssClass="form-control" placeholder="Enter Details" >
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
						
						<aui:row cssClass="userAction">
							<aui:col span="12">
								<aui:col span="3">
									<button type="button" class="btn btn-default" id="draft"
										onClick="validateFields('draft')">Save Draft</button>
								</aui:col>
								<aui:col span="3">
									<button type="button" class="btn btn-primary" id="publish"
										onClick="validateFields('publish')">Publish</button>
								</aui:col>
								<aui:col span="3">
									<button type="button" onclick="reset();"
										class="btn btn-default">Clear</button>
								</aui:col>
								<aui:col span="3">
									<button type="button" onclick="goBack();"
										class="btn btn-default">Cancel</button>
								</aui:col>
							</aui:col>
						</aui:row>
					</aui:col>
				</aui:row>
			</form>
		</div>
	</div>


	<div id="sucess-popup" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 id="success-msg">Candidate Result Created</h3>
					</aui:col>

				</aui:row>
				<aui:row>
					<aui:col span="12">
						<button type="button"
							class="btn btn-default popup-confirm-archive pull-left"
							onClick="reloadPage()">Start Again</button>
						<button type="button"
							class="btn cancel btn-primary popup-cancel pull-right"
							onClick="moveToList()">Go Back</button>
					</aui:col>
				</aui:row>

			</form>
		</div>
	</div>
	<div class="loadingDiv" id="loadingDiv">
		<div class="m-blockui"
			style="position: fixed; z-index: 1031; left: 50%; top: 50%;">
			<span>Please Wait</span> <span>
				<div class="m-loader m-loader--brand"></div>
			</span>
		</div>
	</div>
</div>

<script type="text/javascript">
var namespace =  "<portlet:namespace/>";
var ajaxUrl = "${resourceURL}";
var formStorageId = "<%=formStorageId%>";
var vocabularyURL = "<%=vocabularyURL%>";
var mode = "copy";
var baseUrl = "<%=baseUrl%>";
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/candidate-result.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>