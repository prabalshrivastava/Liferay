<%@include file="/html/common/init.jsp"%>
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
				<aui:row style="display:none !important;">
					<aui:col span="10" cssClass="offset1">
						<p id="formStatus" class="formStatus form_draft"
							style="padding: 2px 0px">Draft</p>
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
									<aui:select disabled="true"  name="" id="schedule" cssClass="schedule form-control" onChange="scheduleChange(this)" >

									</aui:select>
								</div>
							</aui:col>
						</aui:row>
<br />
						<aui:row>

							<aui:col span="12" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Candidate Reference Number<span
										class="red-star">*</span></label>
									<aui:select name="" disabled="true" id="candidateNumber"
										cssClass="candidateNumber form-control" onChange="candidateNumberChange(this)" >
										
									</aui:select>
								</div>
							</aui:col>

						</aui:row>
<br />
						<aui:row >
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<!-- <label cssClass="control-label">ID No <span
										class="red-star">*</span>
									</label> -->
									<aui:input type="hidden" name="" id="idNumber" disabled=""
										cssClass="idNumber form-control" >
									</aui:input>
								</div>
							</aui:col>
							</aui:row>
							<aui:row>
							<aui:col span="12" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Candidate Name <span
										class="red-star">*</span>
									</label>
									<aui:input type="text" name="" id="candidateName" disabled="true"
										cssClass="candidateName form-control" >
									</aui:input>
								</div>
							</aui:col>
						</aui:row>
<br />
						
<br />
						<aui:row>
							<aui:col span="12" cssClass="">
								<div class="subScheme dashed-box">
									
										<aui:row>
							<aui:col span="12" cssClass="formio-component-textfield">
								<label cssClass="control-label">Programme Title <span
									class="red-star">*</span></label>

								<aui:select name="" id="programTitle"
									onChange="programTitleChange(this)" type="text"
									cssClass="programTitle form-control">
								</aui:select>
							</aui:col>
						</aui:row>
						<br/><br/>
									<div class="subSchemeHolder" id="subSchemeHolder"><div class="subSchemeContainer" id="subSchemeBase">
											<h3 class="header toggler-header-collapsed"
												style="position: relative; top: 0;">
												<div class="headerText">Programme</div>
												<ul class="nav">
													<li><a href="javascript:void(0);" class="minusIcon"
														onclick="closeSubScheme(this)">Close</a></li>
													<li><a href="javascript:void(0);" class="removeIcon"
														onclick="removeSubScheme(this)">Remove</a></li>
												</ul>
											</h3>
											<div
												class="subSchemeContent period-screen content toggler-conte nt-collapsed">
												<aui:row>
													<aui:row>
														<aui:col span="12" cssClass="formio-component-textfield">
														<input type="hidden" name="program" class="program" ></input>
															<label cssClass="control-label">Choose a Result type: <span
																class="red-star">*</span></label>
																<input type="hidden" class="resultType" name="resultType" id="resultType" ></input>
																<label> 
																	<input  type="checkbox" class="resultTypeGRADE" name="resultTypeGRADE" value="GRADE" checked="checked" onchange="resultTypeGRADEChange(this)"> 
																	<span class="listSpanTitleDefault" >Grade</span>
																</label>
																<label> 
																	<input  type="checkbox" class="resultTypeCA" value="ClassificationAward" name="resultTypeCA" onchange="resultTypeCAChange(this)"> 
																	<span class="listSpanTitleDefault">Award</span>
																</label>
														</aui:col>
													</aui:row>
													<div class="GRADE">
														<label cssclass="control-label">GRADE:</label><hr></hr>
													</div>
													<aui:row cssClass="ClassificationAward" style="display: none;">
														<aui:col span="12" cssClass="formio-component-textfield">
														<label cssclass="control-label">Award:</label><hr></hr>
															<label cssClass="control-label">Award Title</label>
															<aui:select name="" id="awardTitle"
																cssClass="awardTitle form-control">
																<aui:option value="firstClass">First Class</aui:option>
																<aui:option value="secondClass">Second Class</aui:option>
															</aui:select>
														</aui:col>
													</aui:row>
												</aui:row>
												<label style="display: none;" id="deleteStatus"
													class="deleteStatus"></label>
											</div>
											<br /></div>
									</div>
								</div>
							</aui:col>
						</aui:row>


						<aui:row cssClass="userAction">
							<aui:col span="12">
								<center>
									<button type="button" class="btn btn-primary" id="publish"
											onClick="validateFields('Active')">Update</button>
									&nbsp;&nbsp;&nbsp;
									<button type="button" onclick="reset();"
											class="btn btn-default">Clear</button>
									&nbsp;&nbsp;&nbsp;
									<button type="button" onclick="goBack();"
											class="btn btn-default">Cancel</button>
								</center>			
							</aui:col>
						</aui:row>
					</aui:col>
				</aui:row>
			</form>
		</div>
	</div>

	<div class="yui3-skin-sam invoice-action-feedback-dialog">
		<div id="action-feedback-dialog" hidden="true" class="modalpopupBox">
			<div id="action-feedback-dialog-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3>Candidate Result Created</h3>
						</aui:col>
					</aui:row>
					<br />
					<aui:row>
						<aui:col span="12">
						<button type="button"
							class="btn btn-default popup-confirm-archive pull-left"
							onClick="reloadPage()">Start Again</button>
						<button type="button"
							class="btn cancel btn-primary popup-cancel pull-right"
							onClick="goBack()">Go Back</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
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
formStorageId = formStorageId.split("@")[0];
var vocabularyURL = "<%=vocabularyURL%>";
var mode = "edit";
var baseUrl = "<%=baseUrl%>";
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/candidate-result-capture.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script>
fetchAwardTypeData();
fetchResultDetails();
</script>
