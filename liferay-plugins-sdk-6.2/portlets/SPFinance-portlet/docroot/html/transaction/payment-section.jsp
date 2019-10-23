<%@page
	import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page
	import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="java.util.Map"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="java.util.List"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page
	import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalService"%>
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
<portlet:defineObjects />
<portlet:resourceURL var="downloadPdfUrl">
	<portlet:param name="action" value="downloadPdf" />
</portlet:resourceURL>
<%
	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Long groupId = td.getLayout().getGroupId();
	List<SPListType> paymentModeList = SPListTypeLocalServiceUtil.getByKey("finance.payment.mode", groupId);
	List<SPListType> creditCardTypeList = SPListTypeLocalServiceUtil.getByKey("finance.payment.creditcardtype",
			groupId);
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	String vocabularyURL = SambaashUtil.getParameter(SambaashConstants.API_VOCABULARY_URL, groupId);
	Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
	String categoryType = portletPreferences.getValue(FinanceConstants.PREF_CATEGORY_TYPE, "IN");
	Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getTransactionTypeMap(request);
	Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getClientTypeMap(request);
	Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentMap(request);
	Map<String, String> functionalComponentDisplayMap = SPFinanceLocalServiceUtil.getFunctionalComponentDisplayMap(request);
	Map<String, String> productMap = SPFinanceLocalServiceUtil.getProductTypeMap(request);
	Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
	Map<Long, String> creditCardTypeMap = SPFinanceLocalServiceUtil.getSpListTypeIdToDisplayName("finance.payment.creditcardtype",
			request);
	Map<String, String> paymentModeMap = SPFinanceLocalServiceUtil
			.getSpListTypeMap("finance.payment.mode", request);
%>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/payment.css?minifierType=css'></link>
<div class="mainDiv" id="mainDiv">
	<div class="paymentDiv" id="paymentDiv">
		<div class="heading">
			<img class="headingImage" alt=""
				src="<%=request.getContextPath()%>/images/fee.png" />
			<p class="payment-info">PAYMENT INFO</p>
			<img class="headingCloseImage" alt="" onclick="closePaymentSection()"
				src="<%=request.getContextPath()%>/images/cancel.png" />
		</div>
		<div class="contentScrollDiv">
			<div class="contentDiv">
				<div class="totalDiv">
					<div class="subTotalDiv">
						<label class="leftLabel">Sub Total (excl GST)</label> <label
							class="rightLabel" id="subTotalLabel">0.00</label>
					</div>
					<div class="gstDiv">
						<label class="leftLabel">GST (<span
							class="baseCurrencyLabel">SGD</span>)
						</label> <label class="rightLabel" id="taxRateLabel">0.00</label>
					</div>
					<div class="grandTotalDiv">
						<label class="leftLabel">Total Receivable (<span
							class="baseCurrencyLabel">SGD</span>)
						</label> <label class="rightLabel grandTotal" id="totalReceivableAmount">0.00</label>
					</div>
				</div>
				<div class="paymentModeDiv">
					<div class="formContainer formio-form"
						style="box-shadow: none; padding: 0px 0px;">
						<form class="aui" id="paymentForm" name="paymentForm" action="">
							<aui:row>
								<aui:col span="12">
									<div style="display: none;" class="alert alert-danger"
										role="showAlert" id="alert_msg">Select Facility Type.</div>
									<aui:row>
										<aui:col span="12" cssClass="formio-component-textfield">
											<div class="form-group">
												<label>Payer's Full Name <span class="red-star">*</span></label>
												<aui:input type="text" name="" id="payerFullName"
													cssClass="form-control" placeholder="Enter a Full Name">
												</aui:input>
											</div>
										</aui:col>
									</aui:row>
									<aui:row>
										<aui:col span="12" cssClass="formio-component-textfield">
											<div class="form-group">
												<label>Payment / Settlement Mode <span
													class="red-star">*</span>
												</label>
												<aui:select name="" id="paymentMode" type="text"
													cssClass="paymentMode form-control"
													onChange="showPaymentMode(this)" placeholder="Add a mode">
													<aui:option value="">
															    	Add a mode
															    </aui:option>
												</aui:select>
											</div>
										</aui:col>
									</aui:row>
								</aui:col>
							</aui:row>
							<aui:row cssClass="paymentModeRow" id="cashRow">
								<aui:col span="12">
									<aui:row>
										<aui:col span="1">
											<img alt=""
												src="<%=application.getContextPath()%>/images/money.png" />
										</aui:col>
										<aui:col span="5">
											<label class="headingLabel">Cash</label>
										</aui:col>
										<aui:col span="4">
											<label class="headingAmountLabel" value="0" value="0">$0.00</label>
										</aui:col>
										<aui:col span="1">
											<img class="minimizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-minus.png"
												onclick="minimizePaymentMode(this)" />
											<img class="maximizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/plus.png"
												onclick="maximizePaymentMode(this)" />
										</aui:col>
										<aui:col span="1">
											<img class="closeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-red.png"
												onclick="hidePaymentMode(this)" />
										</aui:col>
									</aui:row>
									<div class="paymentModeContentDiv">
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Payment Amount (<span
														class="baseCurrencyLabel">SGD</span>) <span
														class="red-star">*</span></label>
													<aui:input type="number" min="0" name="" value="0"
														id="cashPaymentAmount"
														cssClass="form-control paymentAmount"
														placeholder="Enter Payment Amount">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
									</div>
								</aui:col>
							</aui:row>
							<aui:row cssClass="paymentModeRow" id="creditbalanceRow">
								<aui:col span="12">
									<aui:row>
										<aui:col span="1">
											<img alt=""
												src="<%=application.getContextPath()%>/images/wallet.png" />
										</aui:col>
										<aui:col span="5">
											<label class="headingLabel">Credit Balance</label>
										</aui:col>
										<aui:col span="4">
											<label class="headingAmountLabel" value="0">$0.00</label>
										</aui:col>
										<aui:col span="1">
											<img class="minimizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-minus.png"
												onclick="minimizePaymentMode(this)" />
											<img class="maximizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/plus.png"
												onclick="maximizePaymentMode(this)" />
										</aui:col>
										<aui:col span="1">
											<img class="closeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-red.png"
												onclick="hidePaymentMode(this)" />
										</aui:col>
									</aui:row>
									<div class="paymentModeContentDiv">
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Credit Balance (<span
														class="baseCurrencyLabel">SGD</span>) <span
														class="red-star">*</span></label>
													<aui:input type="number" min="0" name=""
														id="creditBalanceAvailAmount" cssClass="form-control"
														readonly="true">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Payment Amount (<span
														class="baseCurrencyLabel">SGD</span>) <span
														class="red-star">*</span></label>
													<aui:input type="number" min="0" name="" value="0"
														id="creditBalancePaymentAmount"
														cssClass="form-control paymentAmount"
														placeholder="Enter Payment Amount">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
									</div>
								</aui:col>
							</aui:row>
							<aui:row cssClass="paymentModeRow" id="chequeRow">
								<aui:col span="12">
									<aui:row>
										<aui:col span="1">
											<img alt=""
												src="<%=application.getContextPath()%>/images/cheque.png" />
										</aui:col>
										<aui:col span="5">
											<label class="headingLabel">Cheque</label>
										</aui:col>
										<aui:col span="4">
											<label class="headingAmountLabel" value="0">$0.00</label>
										</aui:col>
										<aui:col span="1">
											<img class="minimizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-minus.png"
												onclick="minimizePaymentMode(this)" />
											<img class="maximizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/plus.png"
												onclick="maximizePaymentMode(this)" />
										</aui:col>
										<aui:col span="1">
											<img class="closeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-red.png"
												onclick="hidePaymentMode(this)" />
										</aui:col>
									</aui:row>
									<div class="paymentModeContentDiv">
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Bank Name <span class="red-star">*</span></label>
													<aui:select name="" id="chequeBankName"
														cssClass="form-control bankName">
														<aui:option value="" hidden="true">
																	Choose Bank Name...
																</aui:option>
													</aui:select>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Cheque Number <span class="red-star">*</span></label>
													<aui:input type="number" min="0" name="" id="chequeNumber"
														cssClass="form-control" placeholder="Enter Cheque Number">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-checkbox">
												<label class="checkbox-custom-label"> <input
													type="checkbox" class="form-control checkbox-custom"
													id="chequeMultiple"> Cheque used for paying
													multiple invoices
												</label>
											</aui:col>
										</aui:row>
										<br />
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Cheque Amount (<span
														class="baseCurrencyLabel">SGD</span>) <span
														class="red-star">*</span></label>
													<aui:input type="number" min="0" name="" id="chequeAmount"
														cssClass="form-control" placeholder="Enter Cheque Amount">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Payment Amount (<span
														class="baseCurrencyLabel">SGD</span>) <span
														class="red-star">*</span></label>
													<aui:input type="number" min="0" name="" value="0"
														id="chequePaymentAmount"
														cssClass="form-control paymentAmount"
														placeholder="Enter Payment Amount">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
									</div>
								</aui:col>
							</aui:row>
							<aui:row cssClass="paymentModeRow" id="bankdraftRow">
								<aui:col span="12">
									<aui:row>
										<aui:col span="1">
											<img alt=""
												src="<%=application.getContextPath()%>/images/money.png" />
										</aui:col>
										<aui:col span="5">
											<label class="headingLabel">Bank Draft</label>
										</aui:col>
										<aui:col span="4">
											<label class="headingAmountLabel" value="0">$0.00</label>
										</aui:col>
										<aui:col span="1">
											<img class="minimizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-minus.png"
												onclick="minimizePaymentMode(this)" />
											<img class="maximizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/plus.png"
												onclick="maximizePaymentMode(this)" />
										</aui:col>
										<aui:col span="1">
											<img class="closeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-red.png"
												onclick="hidePaymentMode(this)" />
										</aui:col>
									</aui:row>
									<div class="paymentModeContentDiv">
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Bank Name <span class="red-star">*</span></label>
													<aui:select name="" id="bankDraftBankName"
														cssClass="form-control bankName">
														<aui:option value="" hidden="true">
																	Choose Bank Name...
																</aui:option>
													</aui:select>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Draft Number <span class="red-star">*</span></label>
													<aui:input type="number" min="0" name=""
														id="bankDraftRefNumber" cssClass="form-control"
														placeholder="Enter Reference Number">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Payment Amount (<span
														class="baseCurrencyLabel">SGD</span>) <span
														class="red-star">*</span></label>
													<aui:input type="number" min="0" name="" value="0"
														id="bankDraftPaymentAmount"
														cssClass="form-control paymentAmount"
														placeholder="Enter Payment Amount">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
									</div>
								</aui:col>
							</aui:row>
							<aui:row cssClass="paymentModeRow" id="creditcardRow">
								<aui:col span="12">
									<aui:row>
										<aui:col span="1">
											<img alt=""
												src="<%=application.getContextPath()%>/images/money.png" />
										</aui:col>
										<aui:col span="5">
											<label class="headingLabel">Credit Card</label>
										</aui:col>
										<aui:col span="4">
											<label class="headingAmountLabel" value="0">$0.00</label>
										</aui:col>
										<aui:col span="1">
											<img class="minimizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-minus.png"
												onclick="minimizePaymentMode(this)" />
											<img class="maximizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/plus.png"
												onclick="maximizePaymentMode(this)" />
										</aui:col>
										<aui:col span="1">
											<img class="closeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-red.png"
												onclick="hidePaymentMode(this)" />
										</aui:col>
									</aui:row>
									<div class="paymentModeContentDiv">
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Type of Credit Card <span class="red-star">*</span></label>
													<aui:select name="" id="creditCardType"
														cssClass="form-control creditCardType">
														<aui:option value="" hidden="true">
																	Choose Type...
																</aui:option>
													</aui:select>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Name on Card <span class="red-star">*</span></label>
													<aui:input type="text" name="" id="creditCardName"
														cssClass="form-control" placeholder="Enter Name on Card">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Payment Amount (<span
														class="baseCurrencyLabel">SGD</span>) <span
														class="red-star">*</span></label>
													<aui:input type="number" min="0" name="" value="0"
														id="creditCardPaymentAmount"
														cssClass="form-control paymentAmount"
														placeholder="Enter Payment Amount">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
									</div>
								</aui:col>
							</aui:row>
							<aui:row cssClass="paymentModeRow" id="axsRow">
								<aui:col span="12">
									<aui:row>
										<aui:col span="1">
											<img alt=""
												src="<%=application.getContextPath()%>/images/money.png" />
										</aui:col>
										<aui:col span="5">
											<label class="headingLabel">AXS</label>
										</aui:col>
										<aui:col span="4">
											<label class="headingAmountLabel" value="0">$0.00</label>
										</aui:col>
										<aui:col span="1">
											<img class="minimizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-minus.png"
												onclick="minimizePaymentMode(this)" />
											<img class="maximizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/plus.png"
												onclick="maximizePaymentMode(this)" />
										</aui:col>
										<aui:col span="1">
											<img class="closeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-red.png"
												onclick="hidePaymentMode(this)" />
										</aui:col>
									</aui:row>
									<div class="paymentModeContentDiv">
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Transaction Number <span class="red-star">*</span></label>
													<aui:input type="number" min="0" name=""
														id="axsTransNumber" cssClass="form-control"
														placeholder="Enter Transaction Number">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Payment Amount (<span
														class="baseCurrencyLabel">SGD</span>) <span
														class="red-star">*</span></label>
													<aui:input type="number" min="0" name=""
														id="axsPaymentAmount" value="0"
														cssClass="form-control paymentAmount"
														placeholder="Enter Payment Amount">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
									</div>
								</aui:col>
							</aui:row>
							<aui:row cssClass="paymentModeRow" id="netsRow">
								<aui:col span="12">
									<aui:row>
										<aui:col span="1">
											<img alt=""
												src="<%=application.getContextPath()%>/images/money.png" />
										</aui:col>
										<aui:col span="5">
											<label class="headingLabel">NETS</label>
										</aui:col>
										<aui:col span="4">
											<label class="headingAmountLabel" value="0">$0.00</label>
										</aui:col>
										<aui:col span="1">
											<img class="minimizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-minus.png"
												onclick="minimizePaymentMode(this)" />
											<img class="maximizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/plus.png"
												onclick="maximizePaymentMode(this)" />
										</aui:col>
										<aui:col span="1">
											<img class="closeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-red.png"
												onclick="hidePaymentMode(this)" />
										</aui:col>
									</aui:row>
									<div class="paymentModeContentDiv">
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Reference Number</label>
													<aui:input type="number" min="0" name="" id="netsRefNumber"
														cssClass="form-control"
														placeholder="Enter Reference Number">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Payment Amount (<span
														class="baseCurrencyLabel">SGD</span>) <span
														class="red-star">*</span></label>
													<aui:input type="number" min="0" name="" value="0"
														id="netsPaymentAmount"
														cssClass="form-control paymentAmount"
														placeholder="Enter Payment Amount">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
									</div>
								</aui:col>
							</aui:row>
							<aui:row cssClass="paymentModeRow" id="inwardremittanceRow">
								<aui:col span="12">
									<aui:row>
										<aui:col span="1">
											<img alt=""
												src="<%=application.getContextPath()%>/images/money.png" />
										</aui:col>
										<aui:col span="5">
											<label class="headingLabel">Inward Remittance</label>
										</aui:col>
										<aui:col span="4">
											<label class="headingAmountLabel" value="0">$0.00</label>
										</aui:col>
										<aui:col span="1">
											<img class="minimizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-minus.png"
												onclick="minimizePaymentMode(this)" />
											<img class="maximizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/plus.png"
												onclick="maximizePaymentMode(this)" />
										</aui:col>
										<aui:col span="1">
											<img class="closeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-red.png"
												onclick="hidePaymentMode(this)" />
										</aui:col>
									</aui:row>
									<div class="paymentModeContentDiv">
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Bank Name <span class="red-star">*</span></label>
													<aui:select name="" id="inwardRemitBankName"
														cssClass="form-control bankName">
														<aui:option value="" hidden="true">
																	Choose Bank Name...
																</aui:option>
													</aui:select>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Transaction Number <span class="red-star">*</span></label>
													<aui:input type="number" min="0" name=""
														id="inwardRemitTransNumber" cssClass="form-control"
														placeholder="Enter Transaction Number">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Payment Amount (<span
														class="baseCurrencyLabel">SGD</span>) <span
														class="red-star">*</span></label>
													<aui:input type="number" min="0" name="" value="0"
														id="inwardRemitPaymentAmount"
														cssClass="form-control paymentAmount"
														placeholder="Enter Payment Amount">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
									</div>
								</aui:col>
							</aui:row>
							<aui:row cssClass="paymentModeRow" id="credittransferRow">
								<aui:col span="12">
									<aui:row>
										<aui:col span="1">
											<img alt=""
												src="<%=application.getContextPath()%>/images/direct-transfer.png" />
										</aui:col>
										<aui:col span="5">
											<label class="headingLabel">Credit Transfer</label>
										</aui:col>
										<aui:col span="4">
											<label class="headingAmountLabel" value="0">$0.00</label>
										</aui:col>
										<aui:col span="1">
											<img class="minimizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-minus.png"
												onclick="minimizePaymentMode(this)" />
											<img class="maximizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/plus.png"
												onclick="maximizePaymentMode(this)" />
										</aui:col>
										<aui:col span="1">
											<img class="closeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-red.png"
												onclick="hidePaymentMode(this)" />
										</aui:col>
									</aui:row>
									<div class="paymentModeContentDiv">
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Transaction Number <span class="red-star">*</span></label>
													<aui:input type="number" min="0" name=""
														id="creditTransferTransactionNumber"
														cssClass="form-control"
														placeholder="Enter Transaction Number">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Currency <span class="red-star">*</span></label>
													<aui:select name="" id="creditTransferCurrency"
														cssClass="form-control creditTransferCurrency"
														onChange="populateExchangeRate();">
														<aui:option value="" hidden="true">
																	Choose Currency...
																</aui:option>
													</aui:select>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Amount <span class="red-star">*</span></label>
													<aui:input type="number" min="0" name=""
														id="creditTransferAmount" cssClass="form-control"
														placeholder="Enter Amount">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Exchange Rate <span class="red-star">*</span></label>
													<aui:input type="number" min="0" name=""
														id="creditTransferExchangeRate" cssClass="form-control"
														readonly="true" value="1">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Amount (<span
														class="baseCurrencyLabel">SGD</span>)<span
														class="red-star">*</span></label>
													<aui:input type="number" min="0" name="" value="0"
														id="creditTransferBAmount"
														cssClass="form-control paymentAmount" readonly="true">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
									</div>
								</aui:col>
							</aui:row>
							<aui:row cssClass="paymentModeRow" id="othersRow">
								<aui:col span="12">
									<aui:row>
										<aui:col span="1">
											<img alt=""
												src="<%=application.getContextPath()%>/images/money.png" />
										</aui:col>
										<aui:col span="5">
											<label class="headingLabel">Others</label>
										</aui:col>
										<aui:col span="4">
											<label class="headingAmountLabel" value="0">$0.00</label>
										</aui:col>
										<aui:col span="1">
											<img class="minimizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-minus.png"
												onclick="minimizePaymentMode(this)" />
											<img class="maximizeIcon" alt=""
												src="<%=application.getContextPath()%>/images/plus.png"
												onclick="maximizePaymentMode(this)" />
										</aui:col>
										<aui:col span="1">
											<img class="closeIcon" alt=""
												src="<%=application.getContextPath()%>/images/close-red.png"
												onclick="hidePaymentMode(this)" />
										</aui:col>
									</aui:row>
									<div class="paymentModeContentDiv">
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Description <span class="red-star">*</span></label>
													<aui:input type="text" name="" id="othersDesc"
														cssClass="form-control" placeholder="Enter Description">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
										<aui:row>
											<aui:col span="12" cssClass="formio-component-textfield">
												<div class="form-group">
													<label>Payment Amount (<span
														class="baseCurrencyLabel">SGD</span>) <span
														class="red-star">*</span></label>
													<aui:input type="number" min="0" name="" value="0"
														id="othersPaymentAmount"
														cssClass="form-control paymentAmount"
														placeholder="Enter Payment Amount">
													</aui:input>
												</div>
											</aui:col>
										</aui:row>
									</div>
								</aui:col>
							</aui:row>
						</form>
					</div>
				</div>
				<div class="totalDiv paymentTotalDiv">
					<div class="subTotalDiv">
						<label class="leftLabel">Total (<span
							class="baseCurrencyLabel">SGD</span>)
						</label> <label class="rightLabel" id="totalPaymentAmount">0.00</label>
					</div>
					<div class="grandTotalDiv">
						<label class="leftLabel">Outstanding (<span
							class="baseCurrencyLabel">SGD</span>)
						</label> <label class="rightLabel" id="totalOutstandingAmount">0.00</label>
					</div>
				</div>
			</div>
		</div>
		<div class="buttonDiv formContainer">
			<aui:row>
				<aui:col span="6">
					<button type="button" class="btn btn-default" id="previewBtn"
						onclick="previewPayment()">PREVIEW</button>
				</aui:col>
				<aui:col span="6">
					<button type="button" class="btn btn-primary" id="acceptPaymentBtn"
						onclick="acceptPayment()">ACCEPT PAYMENT</button>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col span="6">
					<button type="button" class="btn btn-default" id="hold"
						onclick="holdPayment()">HOLD</button>
				</aui:col>
				<aui:col span="6" id="cancelContainer">
					<button type="button" class="btn btn-default" id="cancelBtn"
						onclick="cancelPayment()">CANCEL</button>
				</aui:col>
			</aui:row>
		</div>
	</div>
	<div class="yui3-skin-sam receipt-feedback-dialog">
		<div id="receipt-feedback-popup" hidden="true" class="modalpopupBox">
			<div id="receipt-feedback-popup-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="success-msg">Receipt processed Successfully!</h3>
							<p id="action_msg">You may either open & view the Receipt as
								a PDF in a new tab by clicking on the link below.</p>
						</aui:col>
					</aui:row>
					<aui:row>
						<div
							style="text-align: center; margin-top: 10px; font-weight: 500;">
							<a href="javascript:void(0);" onclick="exportReceipt()">VIEW
								RECEIPT (.PDF)</a>
						</div>
					</aui:row>
					<aui:row>
						<aui:col span="2">
						</aui:col>
						<aui:col span="8">
							<button type="button" class="btn-primary popup-backtolist-button"
								id="backToListBtn">BACK TO LIST OF RECEIPTS</button>
						</aui:col>
						<aui:col span="2">
						</aui:col>
					</aui:row>
				</form>
			</div>
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
<script>
	var paymentModeList =
<%=objectMapper.writeValueAsString(paymentModeList)%>
	;
	var creditCardTypeList =
<%=objectMapper.writeValueAsString(creditCardTypeList)%>
	;
	var categoryMap =
<%=objectMapper.writeValueAsString(categoryMap)%>;
	var namespace = "<portlet:namespace/>";
	var vocabularyURL = "<%=vocabularyURL%>";
	var categoryType = "<%=categoryType%>";
	var downloadPdfUrl="<%=downloadPdfUrl%>";
	var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
	var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
	var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
	var functionalDispMap = <%=objectMapper.writeValueAsString(functionalComponentDisplayMap)%>;
	var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
	var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
	var creditCardTypeMap = <%=objectMapper.writeValueAsString(creditCardTypeMap)%>;
	var paymentModeMap = <%=objectMapper.writeValueAsString(paymentModeMap)%>;
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/payment-section.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/invoice-actions.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>