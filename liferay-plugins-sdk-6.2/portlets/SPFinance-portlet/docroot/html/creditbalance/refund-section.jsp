<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
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
			<p class="payment-info">
			<%=LabelUtil.getLabel(pageContext, td, "cb.section.title")%></p>
			<img class="headingCloseImage" alt="" onclick="closeRefundSection()"
				src="<%=request.getContextPath()%>/images/cancel.png" />
		</div>
		<div class="contentScrollDiv">
			<div class="contentDiv">
				<div class="totalDiv">
					<div class="subTotalDiv">
						<label class="leftLabel">
						<%=LabelUtil.getLabel(pageContext, td, "label.total")%>
						</label> <label
							class="rightLabel" id="subTotalLabel">0.00</label>
					</div>
					<div class="gstDiv">
						<label class="leftLabel">
						<%=LabelUtil.getLabel(pageContext, td, "cb.detail.miscfee")%>
						</label> <label class="rightLabel" id="miscTotalLabel"> 0.00</label>
					</div>
					<div class="grandTotalDiv">
						<label class="leftLabel">
						<%=LabelUtil.getLabel(pageContext, td, "cb.detail.tp")%>
						
						(<span
							class="baseCurrencyLabel"><%=LabelUtil.getLabel(pageContext, td, "label.sgd")%>
							</span>)
						</label> <label class="rightLabel grandTotal" id="totalReceivableAmount">0.00</label>
					</div>
				</div>
			</div>
		</div>
		<div class="buttonDiv formContainer">
			<aui:row>
				<aui:col span="7">
					<button type="button" class="btn btn-primary" id="submit_refund_Btn"
						onclick="submitCollectPayment()">
						<%=LabelUtil.getLabel(pageContext, td, "workflow.status.verification")%></button>
				</aui:col>
				<aui:col span="5" id="cancelContainer">
					<button type="button" class="btn btn-default" id="cancelBtn"
						onclick="closeRefundSection()">
						<%=LabelUtil.getLabel(pageContext, td, "pa.mass.process.payment.cancel")%></button>
				</aui:col>
			</aui:row>
		</div>
	</div>
		<div class="yui3-skin-sam invoice-action-dialog">
		<div id="credit-action-dialog-bound" hidden="true" class="modalpopupBox">
			<div id="credit-action-dialog-content" class="modalpopupContent">
				<form class="formContainer" action="">
					<aui:row>
						<aui:col span="12">
							<h3 id="action_title"><%=LabelUtil.getLabel(pageContext, td, "label.remark.title")%>
							
							</h3>
							<p id="action_msg">
								<%=LabelUtil.getLabel(pageContext, td, "label.remark.mgs")%>
							</p>
							<br />
							<textarea placeholder="Add your text here..." cols="" rows=""
								id="credit_action_reason"></textarea>
						</aui:col>
					</aui:row>
					<aui:row>
						<aui:col span="12">
							<button type="button" id="popup-submit-action"
								class="btn-primary credit-action-dialog-submit popup-submit-action pull-left"
								style="padding: 8px 12px !important"><%=LabelUtil.getLabel(pageContext, td, "label.submit")%></button>
							<button type="button" id="popup-cancel-action"
								class="btn-default credit-action-dialog-cancel popup-cancel-action pull-right">
								<%=LabelUtil.getLabel(pageContext, td, "label.cancel")%></button>
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
	var namespace = "<portlet:namespace/>";
</script>