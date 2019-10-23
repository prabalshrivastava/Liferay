<%@page import="com.sambaash.platform.srv.spservices.model.SPListType"%>
<%@page import="com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.sambaash.platform.finance.service.SPFinanceLocalServiceUtil"%>
<%@page import="com.fasterxml.jackson.databind.SerializationFeature"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.Map"%>
<%@page import="com.sambaash.platform.finance.constants.FinanceConstants"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.liferay.portal.security.auth.AuthTokenUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<link rel='stylesheet'
	href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/billing.css?minifierType=css'></link>
	<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/portlet.css?minifierType=css'></link>
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/main.css?minifierType=css'></link>
<link rel='stylesheet' type="text/scss"
	href='<%=request.getContextPath()%>/css/custom.scss?minifierType=css'></link>
<script type="text/javascript" src="/html/js/sp/hook.js?<%=System.currentTimeMillis()%>" language="javascript1.2""></script>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:resourceURL var="resourceURL">
	<portlet:param name="sp_p_auth"
		value="<%= AuthTokenUtil.getToken(request) %>" />
</portlet:resourceURL>

<!-- Example style to set in portlet preference: "margin:5px auto; max-width: 640px" -->

<portlet:resourceURL var="ajaxUrl">

</portlet:resourceURL>
<portlet:resourceURL var="searchlisturl">
	<portlet:param name="action" value="searchList" />
</portlet:resourceURL>
<portlet:resourceURL var="elastisearchlisturl">
	<portlet:param name="action" value="elastiSearchList" />
</portlet:resourceURL>
<portlet:resourceURL var="filtercolumnlisturl">
	<portlet:param name="action" value="filterColumnList" />
</portlet:resourceURL>
<portlet:resourceURL var="exportstorageurl">
	<portlet:param name="action" value="exportRow" />
</portlet:resourceURL>
<portlet:resourceURL var="globalexportlisturl">
	<portlet:param name="action" value="exportList" />
</portlet:resourceURL>
<portlet:resourceURL var="globalarchivelisturl">
	<portlet:param name="action" value="archiveList" />
</portlet:resourceURL>
<portlet:resourceURL var="globaldeactivatelisturl">
	<portlet:param name="action" value="deactivateList" />
</portlet:resourceURL>
<%
String portalURL = themeDisplay.getPortalURL();
String cssClass  = GetterUtil.getString((String)request.getAttribute("sp-formio:Listing:cssClass"), "social-share margin-top-half text-center");
String modelName = portletPreferences.getValue(SystemSetupConstants.PREF_MODEL_NAME, "TransactionMaster");
String categoryType = portletPreferences.getValue(FinanceConstants.PREF_CATEGORY_TYPE, "IN");
String listHeader = portletPreferences.getValue(FinanceConstants.PREF_LIST_HEADER, "WALLET & TRANSACTIONS");
String baseUrl = portletPreferences.getValue("baseUrlPref", "");
String receiptBaseUrl = portletPreferences.getValue(FinanceConstants.PREF_RECEIPT_BASE_URL, "");
String payOnlineBaseUrl = portletPreferences.getValue(FinanceConstants.PREF_PAY_ONLINE_BASE_URL, "");
String dashBoardLink = SambaashUtil.getDashBoard();
Map<String, String> categoryMap = SPFinanceLocalServiceUtil.getCategoryMap(request);
Map<String, String> transactionTypeMap = SPFinanceLocalServiceUtil.getTransactionTypeMap(request);
Map<String, String> clientTypeMap = SPFinanceLocalServiceUtil.getClientTypeMap(request);
Map<String, String> functionalComponentMap = SPFinanceLocalServiceUtil.getFunctionalComponentMap(request);
Map<String, String> functionalComponentDisplayMap = SPFinanceLocalServiceUtil.getFunctionalComponentDisplayMap(request);
Map<String, String> productMap = SPFinanceLocalServiceUtil.getProductTypeMap(request);
Map<String, String> productSubtypeMap = SPFinanceLocalServiceUtil.getProductSubTypeMap(request);
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
String serverCurrDate = sdf.format(new Date());

Calendar cal = Calendar.getInstance();
cal.add(Calendar.DAY_OF_MONTH, 5);
String toDate = sdf.format(cal.getTime());
cal.add(Calendar.DAY_OF_MONTH, -10);
String fromDate = sdf.format(cal.getTime());

ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

Long groupId = td.getLayout().getGroupId();

List<SPListType> pendingDispList = SPListTypeLocalServiceUtil
.getByKey("finance.wallet.pendingdisplayfilter", groupId);

List<SPListType> historyDispList = SPListTypeLocalServiceUtil
.getByKey("finance.wallet.historydisplayfilter", groupId);

%>
<portlet:renderURL var="CreateNewURL">
	<portlet:param name="jspPage" value="wwww" />
</portlet:renderURL>
<style>
#togglerSortColumn .toggler-content-wrapper {
	overflow: inherit;
}

#togglerSortColumn ul li {
	display: inline-block;
	float: left;
	margin: 0 5px;
}
#togglerSortColumn ul {
	float: right;
}

#togglerSortColumn .toggler-content-wrapper {
	position: absolute;
	left: 0;
	right: 0;
	width: 100%;
}

#togglerSortColumn .content.toggler-content {
	background-image: linear-gradient(to top, #fff, #f3f5fa);
	padding: 0 !important;
	border-top: 1px solid #dbdeee;
	box-shadow: inset 0 12px 20px 0 rgba(37, 38, 94, 0.07);
	left: 0;
	width: 100%;
	text-align: center;
	top: 52px;
}

#loadingDiv {
	width: 100%;
	height: 100%;
	background: #b8b9bf40;
	position: fixed;
	z-index: 9999;
	top: 0;
	display: none
}

.m-blockui {
	border-radius: 4px;
	display: table;
	table-layout: fixed;
}

.m-blockui>span {
	display: table-cell;
	vertical-align: middle;
	padding: 8px 15px;
	font-size: 1rem;
	font-weight: 400;
}

.m-blockui>span>.m-loader, .m-blockui>span>.m-spinner {
	margin-right: 10px;
}

.m-blockui {
	background: #ffffff;
	-webkit-box-shadow: 0px 1px 15px 1px rgba(69, 65, 78, 0.1);
	box-shadow: 0px 1px 15px 1px rgba(69, 65, 78, 0.1);
}

.m-blockui.m-blockui-no-shadow {
	-webkit-box-shadow: none;
	box-shadow: none;
}

.m-blockui>span {
	color: #6f727d;
}

.m-blockui.m-blockui--skin-dark {
	background: #2c2e3e;
	-webkit-box-shadow: 0px 1px 15px 1px rgba(69, 65, 78, 0.5);
	box-shadow: 0px 1px 15px 1px rgba(69, 65, 78, 0.5);
}

.m-blockui.m-blockui--skin-dark.m-blockui-no-shadow {
	-webkit-box-shadow: none;
	box-shadow: none;
}

.m-blockui.m-blockui--skin-dark>span {
	color: #9093ac;
}

.m-loader.m-loader--brand:before {
	border-top-color: #716aca;
	margin-left: 34px;
}

.m-loader:before {
	width: 1.4rem;
	height: 1.4rem;
	margin-top: -0.7rem;
	margin-left: -0.7rem;
	border-top-width: 2px !important;
	border-right-width: 2px !important;
}

.m-loader:before {
	content: '';
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	position: absolute;
	top: 50%;
	left: 50%;
	border-top: 2px solid #07d;
	border-right: 2px solid transparent;
	border-radius: 50%;
	-webkit-animation: m-loader-rotate 0.6s linear infinite;
	animation: spin 800ms linear infinite !important
}




.BG-Copy {
  width: 223px;
  height: 70px;
  border-radius: 4px;
  background-image: linear-gradient(107deg, #3023ae, #3980e3);
}

.span1 Wallet {
  width: 20px;
  height: 20px;
  object-fit: contain;
}

.Current-Balance {
  width: 88px;
  height: 18px;
  font-family: WorkSans;
  font-size: 11px;
  font-weight: normal;
  font-style: normal;
  font-stretch: normal;
  line-height: 1.64;
  letter-spacing: normal;
  color: #ffffff;
}

.dollarSign
{
  width: 9px;
  height: 18px;
  font-family: WorkSans;
  font-size: 14px;
  font-weight: 500;
  font-style: normal;
  font-stretch: normal;
  line-height: 1.29;
  letter-spacing: normal;
  color: #ffffff;
}

.balAmt
{
 width: 116px;
  height: 100%;
  font-family: WorkSans;
  font-size: 40px;
  font-weight: 300 !important;
  font-style: normal;
  font-stretch: normal;
  line-height: normal;
  letter-spacing: normal;
  display:grid;  
}

.balAmt label {
	color: #ffffff;
}

.balAmtValRow {
	line-height: 0;
    vertical-align: text-bottom;
    min-height: 0;
}

.balAmtVal {
	font-size: 40px !important;
    line-height: 25px !important;
    text-align: left;
    font-weight: 300 !important;
}

.wallRow {
	height: 100%;
}

.walletDiv {
	display: flex !important;
	height: 100%;
}

.walletDiv img {
	margin: auto;
}

.walletDiv label {
	color: #ffffff;
	margin: auto;
	font-weight: 300 !important;
}

.balColLbl {
	margin: 0 auto;
    display: flex !important;
}

.balColLbl label {
	margin: auto 0;
    display: flex;
    min-height: 0px;
    margin-bottom: 6px;
    font-weight: 300 !important;
    
}

 .text-style-1 {
  font-size: 24px;
}

.btnClassSel {
  width: 185px;
  height: 40px;
  border-radius: 8px 0px 0px 8px;  
  margin: auto !important;
}

.btnClass {
  width: 185px;
  height: 40px;
  border-radius: 0px 8px 8px 0px;
  margin: auto !important;
}

.btnSelDiv {
	display: flex !important;
    height: 70px;
    position: relative;
    margin-left: 34px !important;
}

.btnSel {
	box-shadow: inset 0 1px 8px 0 #1a347d;
  	background-color: #3955a5;
  	color: #ffffff;
}

.btnPmt {
	background-color: #ffffff;
  	color: #3955a5;
}

.btnDiv {
	display: flex !important;
    height: 70px;
    margin-left: -10px !important;
}

.dtPicker {
	margin-top: 18px !important;
	width: 124px !important;
	font-size: 11px !important;
	height: 34px !important;
  	border-radius: 3px !important;
  	background-color: #ffffff !important;
}

.dtPickerIcon {
	top: 25px !important;
    right: 37px !important;
}

.datePickCol {
	margin-left: auto !important;
}

.datePickCol2 {
	margin-left: -25px !important;
}

.line3 {
	width: 6px !important;
    height: 1px;
    margin-top: 26px;
    margin-left: -16px !important;
}

.dispFilter {
	width: 104px !important;
    height: 39px !important;
    border-radius: 3px !important;
    background-color: #ffffff !important;
    margin-top: 15px !important;
    margin-left: -33px !important;
    padding-left: 5px !important;
}

.dispFilter1 {
	width: 104px !important;
    height: 39px !important;
    border-radius: 3px !important;
    background-color: #ffffff !important;
    margin-top: 15px !important;
    margin-left: -33px !important;
  	display: none !important;
  	padding-left: 5px !important;
}

.dispFilter select {
	padding-left: 5px !important;
}

.dispFilter1 select {
	padding-left: 5px !important;
}

.tblHeader {
  width: 1200px !important;
  height: 48px;
  background-image: linear-gradient(to bottom, #f9fafc, #f1f4f8);
}

.tblHeader1 {
  width: 1200px !important;
  height: 48px;
  background-image: linear-gradient(to bottom, #f9fafc, #f1f4f8);
  display: none;
}

.Normal {
	width: 100px;
  	height: 34px;
  	object-fit: contain;
}

.selectedPage {
	font-weight: 900;
}

.IconArrow {
  color: #ed6878;
}

.IconArrow2 {
  color: #22bd0d;
}
#tableId button {
	margin-bottom: 0px
}
#tableId td {
	height: 60px
}
</style>
<script>
var config = {
	    
	};
</script>

<div class="newPortlets">
	<div class="subHeader">
		<div class="container">
			<div class="inner-container">
				<aui:row>
					<aui:col span="10" cssClass="text-center">
						<h2><%=listHeader%>
						</h2>
					</aui:col>
					<aui:col span="2" cssClass="text-right">
						<aui:a href="<%=dashBoardLink%>" title="Back to Home">Back to Home</aui:a>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="formRoot">
		<div class="innerFormRoot">
	<div id='formio1' class="<%=cssClass%> container">
		
		<aui:row>
				
			<aui:col span="4">
				<div class="BG-Copy">
					
					<aui:row cssClass="wallRow">

						<aui:col span="3" cssClass="walletDiv">
							<img alt="wallet.img" src="<%=request.getContextPath()%>/images/wallet.png">
						</aui:col>
						
						<aui:col span="1" cssClass="walletDiv">
							<label>$</label>
						</aui:col>
						
						<aui:col span="8" cssClass="balAmt">
							<aui:row>
								<aui:col cssClass="balColLbl">
									<label>Current Balance</label>
								</aui:col>
							</aui:row>
								
							<aui:row cssClass="balAmtValRow">
								<aui:col>
									<label class="balAmtVal">0.00</label>
								</aui:col>
							</aui:row>
								
						</aui:col>
									
					</aui:row>
				</div>				
			</aui:col>
			
			<aui:col span="2" cssClass="btnSelDiv">
				<button type="submit" id="btnPendingPmnts" class="btnClassSel btnSel" onClick="getPendingPaymets()">
					PAYMENTS PENDING
				</button>
			</aui:col>
			<aui:col span="2" cssClass="btnDiv">
				<button type="submit" id="btnHistPmnts" class="btnClass btnPmt" onClick="getHistoryPaymets()">
					PAYMENT HISTORY
				</button>
			</aui:col>
		
			<aui:col span="2" cssClass="formio-component-textfield datePickCol">
				<div class="form-group">
					<aui:input type="text" name="toDate" label=""
						cssClass="form-control dueDate dtPicker" id="toDate"
						value="<%=fromDate%>" readonly="true"/>
					<span class="input-group-addon" style="cursor: pointer">
						<i class="glyphicon glyphicon-calendar dtPickerIcon"></i>
					</span>
				</div>
			</aui:col>
			
			<aui:col span="1" cssClass="line3">
				<label> - </label>
			</aui:col> 
			
			<aui:col span="2" cssClass="formio-component-textfield datePickCol2">
				<div class="form-group">
					<aui:input type="text" name="fromDate" label=""
						cssClass="form-control dueDate dtPicker" id="fromDate"
						value="<%=toDate%>" readonly="true"/>
					<span class="input-group-addon" style="cursor: pointer">
						<i class="glyphicon glyphicon-calendar dtPickerIcon"></i>
					</span>
				</div>
			</aui:col>
			
			<aui:col span="1" cssClass="formio-component-textfield">
				<div class="form-group">
					<div id="dispFilterDiv" class="dispFilter">
						<aui:select name="" id="dispFilter" cssClass="form-control" onChange="initTable('pending')">
							
						</aui:select>
					</div>
					<div id="dispFilterDiv1" class="dispFilter1">
						<aui:select name="" id="dispFilter1" cssClass="form-control" onChange="initTable('history')">
							
						</aui:select>
					</div>
				</div>
			</aui:col>
				
		</aui:row>
		
		
		<div class="dataListing">
			
			<div style="display: none;" class="alert alert-danger"
							role="showAlert" id="alert_msg">Select Facility Type.</div>
			<div class="data-listing">
				
				<table id="tableId" class="aui">
					<thead class="Heading">
						
					</thead>
					<tbody class="Body">

					</tbody>
				</table>
			</div>
			<div class="pagination">
				<aui:row>
					<aui:col span="6" cssClass="text-left">
						<aui:select cssClass="itemsPerPage" name="itemsPerPage"
							label="Items per page:" onChange="reloadTable()">
							<aui:option value="5">5</aui:option>
							<aui:option value="10" selected="true">10</aui:option>
							<aui:option value="20">20</aui:option>
							<aui:option value="50">50</aui:option>
							<aui:option value="100">100</aui:option>
						</aui:select>
					</aui:col>
					<aui:col span="6" cssClass="text-right myPagination aui-pagination">
						<div id="jslarge" class="pagination myPagination pagination-large"></div>
					</aui:col>
				</aui:row>
			</div>
			<div class="no-data-listing" style="display: none">
				<div class="sambaashContent">
					<div class="container nodates">
						<aui:row>
							<aui:col span="12" cssClass="text-center">
								<h3 id="h3message" class="no-data-listing-message">
									No
									<%=modelName%></h3>
								<p id="pmessage" class="no-data-listing-message">
									There aren't any records of existing
									<%=modelName%>s as of now. If you would like to create a new
									one, please click on the 'ADD NEW' button.
								</p>
								<a id="ahrefmessage" href="<%=dashBoardLink%>"
									title="BACK TO DASHBOARD" class="btn btn-primary">BACK TO
									DASHBOARD</a>
							</aui:col>
						</aui:row>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
	<!-- Dialogs -->
	<div class="yui3-skin-sam">
		<div id="archive-record" hidden="true" class="modalpopupBox">
			<div id="archive-record-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3>Are you sure about archiving this record ?</h3>
							<p>You may have to contact admin to retrieve this record post
								archival</p>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button"
								class="btn btn-default popup-confirm-archive pull-left">Confirm</button>
							<button type="button"
								class="btn btn-primary popup-cancel-archive pull-right">Cancel</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam">
		<div id="deactive-record" hidden="true" class="modalpopupBox">
			<div id="deactive-record-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3>Deactivate this record?</h3>
							<p id="deactivate_msg">Please provide your reasons for
								deactivating this record</p>
							<textarea cols="" rows="" id="deactivate_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button"
								class="btn btn-default popup-confirm-deactivate pull-left">Confirm</button>
							<button type="button"
								class="btn btn-primary popup-cancel-deactivate pull-right">Cancel</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam">
		<div id="deactivation-success" hidden="true" class="modalpopupBox">
			<div id="inactive-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>De-activation successful!</h3>
						<p>This record will not be in use anymore</p>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button class="btn btn-primary popup-reactivate">Re-active</button>
					</aui:col>
				</aui:row>

			</div>
		</div>
	</div>
	<div class="yui3-skin-sam">
		<div id="blacklist-record" hidden="true" class="modalpopupBox">
			<div id="blacklist-record-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3>Blacklist this record?</h3>
							<p id="blacklist_msg">Please provide your reasons for
								blacklisting this record</p>
							<textarea cols="" rows="" id="blacklist_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12" cssClass="userAction">
							<button type="button"
								class="btn btn-default popup-confirm-blacklist pull-left">Confirm</button>
							<button type="button"
								class="btn btn-primary cancel popup-cancel-blacklist">Cancel</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam">
		<div id="blacklist-success" hidden="true" class="modalpopupBox">
			<div id="blacklist-success-box" class="modalpopupContent">
				<aui:row>
					<aui:col span="12">
						<h3>Blacklist successful!</h3>
						<p>This record will not be in use anymore</p>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button type="button"
							class="btn btn-primary cancel popup-cancel-blacklist"
							onclick="reload();">BACK TO LISTING</button>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam">
		<div id="activation-success" hidden="true" class="modalpopupBox">
			<div id="active-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>Activation successful!</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button type="button"
							class="btn btn-primary cancel popup-cancel-blacklist"
							onclick="reload();">BACK TO LISTING</button>
					</aui:col>
				</aui:row>

			</div>
		</div>
	</div>
	<div class="yui3-skin-sam">
		<div id="confirmed-success" hidden="true" class="modalpopupBox">
			<div id="confirmed-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>Confirmed!</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button type="button"
							class="btn btn-primary cancel popup-cancel-blacklist"
							onclick="reload();">BACK TO LISTING</button>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam">
		<div id="cancelled-success" hidden="true" class="modalpopupBox">
			<div id="cancelled-success-box" class="modalpopupContent">

				<aui:row>
					<aui:col span="12">
						<h3>Cancelled!</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12" cssClass="userAction">
						<button type="button"
							class="btn btn-primary cancel popup-cancel-blacklist"
							onclick="reload();">BACK TO LISTING</button>
					</aui:col>
				</aui:row>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam invoice-action-dialog">
		<div id="action-dialog" hidden="true" class="modalpopupBox">
			<div id="action-dialog-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="action_title">Submit for Approval ?</h3>
							<p id="action_msg">Please key in your reasons below and
								confirm your action.</p>
							<br />
							<div id="selectReasonDiv" style="display: none">
								<aui:row>
									<aui:col span="12">
									Choose a reason
									</aui:col>
								</aui:row>
								<aui:row>
									<aui:col span="12">
										<input type="radio" name="reasonsCb" value="Cheque Dishonoured" checked="checked">
										Cheque Dishonoured<br />
										<input type="radio" name="reasonsCb" value="Cheque Rejected">
										Cheque Rejected<br />
										<input type="radio" name="reasonsCb" value="Others (Refund to Credit Balance)">
										Others (Refund to Credit Balance)
									</aui:col>
								</aui:row>
							</div>
							<br />
							<textarea placeholder="Enter Reasons..." cols="" rows=""
								id="action_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary popup-submit-action pull-left" style="padding: 8px 12px !important">Submit</button>
							<button type="button" id="popup-cancel-action"
								class="btn-default popup-cancel-action pull-right">Cancel</button>
						</aui:col>
					</aui:row>
				</form>
			</div>
		</div>
	</div>
	<div class="yui3-skin-sam invoice-action-feedback-dialog">
		<div id="action-feedback-dialog" hidden="true" class="modalpopupBox">
			<div id="action-feedback-dialog-box" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3>Action performed successfully.</h3>
						</aui:col>
					</aui:row>
					<br />
					<aui:row>
						<aui:col span="12">
							<button type="button"
								class="btn btn-default popup-ok-action" style="margin: 0 auto; display:block">Back To List</button>
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
<script type="text/javascript">
var mode = "view";
var ajaxUrl = "${resourceURL}";
var availableColumns,masterColumns,exForm = [],columnsToShow =[],tableData,pageRequested = 1,itemsPerPage = 2,
namespace = "<portlet:namespace />",columnlist,totalRecords = 0,totalPages = 0,modelName = "<%= modelName %>";
console.log("modelname ::: " + modelName);
var threedot = document.getElementById("threedot");
var portletns = "<portlet:namespace/>";
var ajaxurl = "<%= ajaxUrl.toString() %>";
var ajaxLock  = 0;
var userArray = [];
var baseUrl = "<%= portalURL + baseUrl %>";
var receiptBaseUrl = "<%= receiptBaseUrl %>";
var payOnlineBaseUrl = "<%= payOnlineBaseUrl %>";
var searchlisturl="<%=searchlisturl%>";
var elastisearchlisturl="<%=elastisearchlisturl%>";
var filtercolumnlisturl="<%=filtercolumnlisturl%>";
var globalarchivelisturl="<%=globalarchivelisturl%>";
var globaldeactivatelisturl="<%=globaldeactivatelisturl%>";
var globalexportlisturl="<%=globalexportlisturl%>";
var exportstorageurl="<%=exportstorageurl%>";
var categoryType="<%=categoryType%>";
var categoryMap = <%=objectMapper.writeValueAsString(categoryMap)%>;
var transactionTypeMap = <%=objectMapper.writeValueAsString(transactionTypeMap)%>;
var clientTypeMap = <%=objectMapper.writeValueAsString(clientTypeMap)%>;
var functionalMap = <%=objectMapper.writeValueAsString(functionalComponentMap)%>;
var functionalDispMap = <%=objectMapper.writeValueAsString(functionalComponentDisplayMap)%>;
var productMap = <%=objectMapper.writeValueAsString(productMap)%>;
var productSubtypeMap = <%=objectMapper.writeValueAsString(productSubtypeMap)%>;
var serverCurrDate ="<%=serverCurrDate%>";

var pendingDisplayFilterList = <%=objectMapper.writeValueAsString(pendingDispList)%>;
var historyDisplayFilterList = <%=objectMapper.writeValueAsString(historyDispList)%>;

YUI().use(
		  'aui-toggler',
		  function(Y) {
		    new Y.TogglerDelegate(
		      {
		        animated: false,
		        closeAllOnExpand: true,
		        container: '#togglerSortColumn',
		        content: '.content',
		        expanded: false,
		        header: '.header',
		        transition: {
		          duration: 0.2,
		          easing: 'cubic-bezier(0, 0.1, 0, 1)'
		        }
		      }
		    );
		  }
		);

</script>


<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/calculation.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/wallet.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/billing.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>