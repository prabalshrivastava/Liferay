<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="java.util.List"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalService"%>
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
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>

<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/scss"
	href='<%=request.getContextPath()%>/css/custom.scss?minifierType=css'></link>
<script type="text/javascript"
	src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>

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
					<h2>PROMO / DISCOUNT SETUP</h2>
				</aui:col>
				<aui:col span="2" cssClass="text-right">
					<aui:a href="<%=dashBoardLink%>" title="Back to Dashboard">Back to Dashboard</aui:a>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div class="discountSetup">
		<div class="formContainer container formio-form">
			<form class="aui" id="discountPromotion_form"
				name="discountPromotion_form" action="">
				<aui:row>
					<aui:col span="10" cssClass="offset1">
						<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg">Select Facility Type.</div>
						<aui:row>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Promo / Discount Code <span
										class="red-star">*</span></label>
									<aui:input type="text" name="" id="discountCode"
										cssClass="form-control"
										placeholder="Enter a Promo / Discount Code">
									</aui:input>
								</div>
							</aui:col>
							<aui:col span="6" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Promotion/Discount Name
										<span class="red-star">*</span>
									</label>
									<aui:input type="text" name="" id="discountName"
										cssClass="form-control" placeholder="Enter a name" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="formio-component-textfield">
								<div class="form-group">
									<label cssClass="control-label">Pricing Description</label>
									<aui:input type="text" name="" id="discountDescription"
										cssClass="form-control" placeholder="Enter a description" />
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Promotion / Discount
										Category</label>
									<aui:select name="" id="discountCategory"
										cssClass="form-control" onChange="changeDiscountCategory();">
										<%
											List<SPListType> catList = 
												SPListTypeLocalServiceUtil.getByKey("priceengine.discount.category", groupId);
											for(SPListType type : catList) {
												%><aui:option value="<%=type.getItemValue() %>"><%=type.getDisplayName() %></aui:option><%
											}
										%>
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="choices formio-choices">
								<div class="form-group">
									<label cssClass="control-label">Currency Code</label>
									<aui:select name="" id="currencyCode"
										cssClass="form-control currencyCode">
									</aui:select>
								</div>
							</aui:col>
						</aui:row>
						<aui:row>
							<aui:col span="12" cssClass="">
								<div class="discountPeriod dashed-box">
									<div class="discountPeriodHolder" id="discountPeriodHolder">
										<div class="discountPeriodContainer" id="discountPriceBase"
											style="display: none">
											<h3 class="header toggler-header-collapsed" style="position: relative;top: 0;">
												<div style="display: inline-block;">Promo Code</div>
											</h3>

											<div
												class="discountPeriodContent period-screen content toggler-conte nt-collapsed">
												<aui:row>
													<aui:row cssClass="formio-component-datetime">
														<aui:col span="6">
															<div class="form-group">
																<aui:input type="text" name="startDate"
																	label="Start Date" cssClass="form-control startDate"
																	id="startDate" placeholder="dd/mm/yyyy" />
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
														<aui:col span="6" cssClass="formio-component-textfield">
															<aui:select name="discountType" id="discountType"
																onChange="showHideCurrency(this)" label="Discount Type"
																cssClass="form-control discountType">
																<%
																	List<SPListType> discTypeList = 
																		SPListTypeLocalServiceUtil.getByKey("priceengine.discount.type", groupId);
																	for(SPListType type : discTypeList) {
																		%><aui:option value="<%=type.getItemValue() %>"><%=type.getDisplayName() %></aui:option><%
																	}
																%>
															</aui:select>
														</aui:col>
														<aui:col span="6">
															<aui:input type="number" step=".01" min="0"
																name="discountValue" label="Value"
																cssClass="form-control discountValue" id="discountValue"
																placeholder="Enter the value" />
														</aui:col>
													</aui:row>
												</aui:row>
												<label style="display: none;" id="deleteStatus"
													class="deleteStatus"></label>
											</div>
										</div>
										<div class="discountPeriodContainer"
											id="discountPriceForBulkPurchaseBase"
											style="margin-top: 5px; display: none">
											<h3 class="header toggler-header-collapsed" style="position: relative;top: 0;">
												<div style="display: inline-block;">Promo Code</div>
											</h3>

											<div
												class="discountPeriodContent period-screen content toggler-conte nt-collapsed">
												<aui:row>
													<aui:row>
														<aui:col span="6">
															<div class="form-group">
																<aui:input type="number" min="0" name="minQuantity"
																	label="Quantity(Min)"
																	cssClass="form-control minQuantity" id="minQuantity"
																	placeholder="Enter a number" />
															</div>
														</aui:col>
														<aui:col span="6">
															<div class="form-group">
																<aui:input type="number" min="0" label="Quantity (Max)"
																	name="maxQuantity" cssClass="form-control maxQuantity"
																	id="maxQuantity" placeholder="Enter a number" />
															</div>
														</aui:col>
													</aui:row>
													<aui:row cssClass="formio-component-datetime">
														<aui:col span="6">
															<div class="form-group">
																<aui:input type="text" name="startDate"
																	label="Start Date" cssClass="form-control startDate"
																	id="startDate" placeholder="dd/mm/yyyy" />
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
														<aui:col span="6" cssClass="formio-component-textfield">
															<aui:select name="discountType" id="discountType"
																onChange="showHideCurrency(this)" label="Discount Type"
																cssClass="form-control discountType">
																<aui:option value="Percentage">Percentage</aui:option>
																<aui:option value="Amount">Amount</aui:option>
															</aui:select>
														</aui:col>
														<aui:col span="6">
															<aui:input type="number" step=".01" min="0"
																name="discountValue" label="Value"
																cssClass="form-control discountValue" id="discountValue"
																placeholder="Enter the value" />
														</aui:col>
													</aui:row>
												</aui:row>
												<label style="display: none;" id="deleteStatus"
													class="deleteStatus"></label>
											</div>
										</div>
										<div class="discountPeriodContainer"
											id="discountPriceWithPromocodeBase"
											style="margin-top: 5px; display: none">
											<h3 class="header toggler-header-collapsed" style="position: relative;top: 0;">
												<div style="display: inline-block;">Promo Code</div>
											</h3>
											<div
												class="discountPeriodContent period-screen content toggler-conte nt-collapsed">
												<aui:row>
													<aui:row>
														<aui:col span="12">
															<div class="form-group">
																<aui:input type="text" name="extPromoCode"
																	label="External Promotion/Coupon Code"
																	cssClass="form-control extPromoCode" id="extPromoCode"
																	placeholder="Enter code" />
															</div>
														</aui:col>
													</aui:row>
													<aui:row>
														<aui:col span="6">
															<div class="form-group">
																<aui:input type="number" min="0" name="minQuantity"
																	label="Quantity(Min)"
																	cssClass="form-control minQuantity" id="minQuantity"
																	placeholder="Enter a number" />
															</div>
														</aui:col>
														<aui:col span="6">
															<div class="form-group">
																<aui:input type="number" min="0" label="Quantity (Max)"
																	name="maxQuantity" cssClass="form-control maxQuantity"
																	id="maxQuantity" placeholder="Enter a number" />
															</div>
														</aui:col>
													</aui:row>
													<aui:row cssClass="formio-component-datetime">
														<aui:col span="6">
															<div class="form-group">
																<aui:input type="text" name="startDate"
																	label="Start Date" cssClass="form-control startDate"
																	id="startDate" placeholder="dd/mm/yyyy" />
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
														<aui:col span="6" cssClass="formio-component-textfield">
															<aui:select name="discountType" id="discountType"
																onChange="showHideCurrency(this)" label="Discount Type"
																cssClass="form-control discountType">
																<aui:option value="Percentage">Percentage</aui:option>
																<aui:option value="Amount">Amount</aui:option>
															</aui:select>
														</aui:col>
														<aui:col span="6">
															<aui:input type="number" step=".01" min="0"
																name="discountValue" label="Value"
																cssClass="form-control discountValue" id="discountValue"
																placeholder="Enter the value" />
														</aui:col>
													</aui:row>
												</aui:row>
												<label style="display: none;" id="deleteStatus"
													class="deleteStatus"></label>
											</div>
										</div>
									</div>
								</div>
							</aui:col>
						</aui:row>
					</aui:col>
				</aui:row>
			</form>
			<aui:row cssClass="userAction">
				<aui:col span="4"></aui:col>
				<aui:col span="4">
					<button type="button" onclick="goBack();" class="btn btn-default">Cancel</button>
				</aui:col>
				<aui:col span="4"></aui:col>
			</aui:row>
		</div>
	</div>


	<div id="sucess-popup" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 id="success-msg">Promo/Discount Created</h3>
					</aui:col>

				</aui:row>
				<aui:row>
					<aui:col span="12">
						<button type="button"
							class="btn btn-default popup-confirm-archive pull-left"
							onClick="reloadPage()">Start Again</button>
						<button type="button"
							class="btn cancel btn-primary popup-cancel pull-right"
							onClick="moveToDashboard()">DashBoard</button>
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
var baseUrl = "<%=baseUrl%>";
var mode = "view";
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/promocode-discount.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>