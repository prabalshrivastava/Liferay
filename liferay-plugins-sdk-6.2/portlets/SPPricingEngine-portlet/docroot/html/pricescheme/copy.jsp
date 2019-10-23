<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/pricescheme.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/scss"
	href='<%=request.getContextPath()%>/css/custom.scss?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>

<portlet:defineObjects />
<%
	String formStorageId = request.getParameter("storageId");
	String baseUrl = portletPreferences.getValue("baseUrlPref", "");
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = td.getLayout().getGroupId();
	String dashboardLink = SambaashUtil.getParameter("dashboard.link", groupId);
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
	System.out.println("voc url -->" + vocabularyURL);
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
					<h2>PRICING SCHEME SETUP</h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=dashBoardLink%>" title="Back to Dashboard">Back to Dashboard</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div class="pricingSchemeSetup">
		<div class="formContainer container formio-form">
			<form class="aui" id="pricing_scheme_form"
				name="pricing_scheme_form" action="">
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg">Select Facility Type.</div>
						<aui:row>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Pricing Scheme Code <span
										class="red-star">*</span></label>
									<aui:input type="text" name="" id="priceSchemeCode"
										cssClass="form-control"
										placeholder="Enter a Pricing Scheme Code">
									</aui:input>
								</div>
							</aui:col>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Pricing Scheme Name
										<span class="red-star">*</span>
									</label>
									<aui:input type="text" name="" id="priceSchemeName"
										cssClass="form-control" placeholder="Enter a name" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="formio-component-datetime">
							<aui:col span="6">
								<div class="form-group">
									<aui:input type="text" name="startDate" label="Start Date"
										cssClass="form-control startDate" id="startDate"
										placeholder="dd/mm/yyyy" />
									<span class="input-group-addon" style="cursor: pointer">
										<i class="glyphicon glyphicon-calendar"></i>
									</span>
								</div>
							</aui:col>
							<aui:col span="6">
								<div class="form-group">
									<aui:input type="text" name="endDate" label="End Date"
										cssClass="form-control endDate" id="endDate"
										placeholder="dd/mm/yyyy" />
									<span class="input-group-addon" style="cursor: pointer">
										<i class="glyphicon glyphicon-calendar"></i>
									</span>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Pricing Description</label>
									<aui:input type="text" name="" id="pricingDescription"
										cssClass="form-control" placeholder="Enter a Description" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="text-center">
								<div class="sectionHeaderDiv">
									<label class="sectionHeaderLabel">
										PRICING SUB-SCHEME
									</label>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="">
								<div class="subScheme dashed-box">
									<div class="subSchemeHolder" id="subSchemeHolder">
										<div class="subSchemeContainer" id="subSchemeBase" style="display:none">
											<h3 class="header toggler-header-collapsed" style="position: relative;top: 0;">
												<div class="headerText">Promo Code</div>
												<ul class="nav">
													<li><a href="javascript:void(0);"
														class="minusIcon" onclick="closeSubScheme(this)">Close</a></li>
													<li><a href="javascript:void(0);"
														class="removeIcon" onclick="removeSubScheme(this)">Remove</a></li>
												</ul>
											</h3>

											<div class="subSchemeContent period-screen content toggler-conte nt-collapsed">
												<aui:row>
													<aui:row>
														<aui:col span="12" cssClass="formio-component-textfield">
															<label cssClass="control-label">Pricing Sub-Scheme 
																<span class="red-star">*</span></label>
															<aui:select name="" id="priceSubScheme"  onChange="priceSubSchemeChange(this)"
																type="text" cssClass="priceSubScheme form-control"
																placeholder="Choose a Pricing Sub-Scheme">
																<aui:option value="" hidden="true">
															    	Choose a Pricing Sub-Scheme...
															    </aui:option>
															</aui:select>
														</aui:col>
													</aui:row>
													<aui:row>
														<aui:col span="6" cssClass="formio-component-textfield">
															<label cssClass="control-label">Tax</label>
															<aui:select name="" id="taxCode" onChange="taxCodeChange(this)"
																cssClass="form-control taxCode">
																<aui:option value="" hidden="true">
															    	No Tax Included
															    </aui:option>
															    <aui:option value="none">
															    	NONE
															    </aui:option>
															</aui:select>
														</aui:col>
														<aui:col span="6" cssClass="formio-component-checkbox">
															<label class="includeTaxLabel"> <input type="checkbox"
																	name="includeTax" class="form-control includeTax" id="includeTax"
																	onchange=""> Include Tax
															</label>
														</aui:col>
													</aui:row>
													<aui:row>
														<aui:col span="6" cssClass="formio-component-textfield">
															<label cssClass="control-label">Currency Code <span class="red-star">*</span></label>
															<aui:select name="" id="currencyCode"
																cssClass="form-control currencyCode">
																<aui:option value="" hidden="true">
															    	Choose a Currency Code...
															    </aui:option>
															</aui:select>
														</aui:col>
														<aui:col span="6" cssClass="formio-component-textfield">
															<label cssClass="control-label">Amount <span class="red-star">*</span></label>
															<aui:input type="number" step=".01" min="0" name=""
																cssClass="form-control amount" id="amount"
																placeholder="Enter the Amount..." />
														</aui:col>
													</aui:row>
													<aui:row>
														<aui:col span="12" cssClass="formio-component-textfield">
														<label cssClass="control-label">Discount Code</label>
															<aui:select name="" id="discountCode"
															 onChange="discountCodeChange(this)"
																cssClass="form-control discountCode">
																<aui:option value="" hidden="true">
															    	Choose a Discount Code...
															    </aui:option>
															    <aui:option value="none">
															    	NONE
															    </aui:option>
															</aui:select>
														</aui:col>
													</aui:row>
												</aui:row>
												<label style="display: none;" id="deleteStatus"
													class="deleteStatus"></label>
											</div>
											<br />
										</div>
									</div>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="text-center">
								<aui:button cssClass="btn greenbtn" id="addSubSchemeButton"
									value="ADD SUB-SCHEME" onClick="addAnotherSubScheme()"></aui:button>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="text-center">
								<div class="sectionHeaderDiv">
									<label class="sectionHeaderLabel">
										PROMOTION DISCOUNT
									</label>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="">
								<div class="promoCodeBox dashed-box">
									<aui:row>
										<aui:col span="12" cssClass="formio-component-textfield">
											<label cssClass="control-label">Promotion Code</label>
											<aui:select name="" id="promotionCode" type="text"
												cssClass="promotionCode form-control"
												onChange="promoCodeChange()">
												    <aui:option value="" hidden="true">
												    	Choose a Promotion Code...
												    </aui:option>
												    <aui:option value="none">
												    	NONE
												    </aui:option>
											</aui:select>
										</aui:col>
									</aui:row>
								</div>
							</aui:col>
						</aui:row><br />
						<aui:row>
							<aui:col span="12" cssClass="text-center">
								<div class="sectionHeaderDiv">
									<label class="sectionHeaderLabel">
										FUNDING / GRANT
									</label>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="">
								<div class="grantBox dashed-box">
									<aui:row>
										<aui:col span="12" cssClass="formio-component-textfield">
											<label cssClass="control-label">Funding / Grant Code</label>
											<aui:select name="" id="grantCode" type="text"
												cssClass="grantCode form-control">
												<aui:option value="" hidden="true">
												    	Choose a Funding / Grant Code...
												    </aui:option>
											</aui:select>
										</aui:col>
									</aui:row>
								</div>
							</aui:col>
						</aui:row>
						<aui:row cssClass="userAction">
							<aui:col span="1"></aui:col>
							<aui:col span="10">
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
							<aui:col span="1"></aui:col>
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
						<h3 id="success-msg">Pricing Scheme Created</h3>
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
	src="<%=request.getContextPath()%>/js/pricingscheme.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>