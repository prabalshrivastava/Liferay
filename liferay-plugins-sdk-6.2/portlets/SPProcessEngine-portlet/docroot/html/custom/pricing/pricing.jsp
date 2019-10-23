<%@page import="com.sambaash.platform.util.ConvertUtil"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.model.PEProcessAudit"%>
<%@page import="com.sambaash.platform.pe.constants.PEAuditConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.sambaash.platform.pe.pricing.PEPricingHelper"%>
<%@page import="com.sambaash.platform.pe.jaxb.PEPricing"%>
<%@page import="com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter"%>
<%@page import="com.sambaash.platform.pe.PEDataSource"%>

<%@ include file="/html/init.jsp" %>

<%
	PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);
	PEDataSource dataSource = output.getDataSource();
	PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(dataSource.getProcessState());
	PEPricing pricingNode = (PEPricing) dataSource.getDirectory().getNode(output.getNodeId());
	PEPricingHelper helper = new PEPricingHelper(dataSource, pricingNode);
	long _SCOPE_ID = themeDisplay.getScopeGroupId()	;
	String candidateId = String.valueOf(dataSource.getProcessState().getUserIdProcess());
			
	// check if sub pricing was filtered by previous nodes
	String selectedSubPricing = dataAdapter.getDataFromProcessState("selectedSubPricing");
		
	String selectedScheme = pricingNode.getScheme();
	List<String> selectedSubSchemes = Arrays.asList(pricingNode.getSubScheme().split(","));
	if (org.apache.commons.lang.StringUtils.isNotEmpty(selectedSubPricing)) {
		selectedSubSchemes = Arrays.asList(selectedSubPricing.replace("[", "").replace("]", "").replace("\"","").replace("\\","").split(","));
	}

	JSONArray outstandingFees = null;
	double totalOutstandingFees;
	JSONArray consolidateFees = null;
	double totalConsolidateFees;
	JSONObject userFees = null;
	JSONObject computedFeesForInvoicing = JSONFactoryUtil.createJSONObject();
	JSONObject computedCurrentFees = null;
	JSONArray currentFees = null;
	
	boolean isCompleted = false;
	if (helper.isCompleted()) {
		PEProcessAudit completedPricingAudit = PEProcessAuditLocalServiceUtil.findByProcessStateIdNodeIdAction(dataSource.getProcessState().getSpPEProcessStateId(), pricingNode.getNodeId(), PEAuditConstants.ACTION_SUBMIT);
		computedFeesForInvoicing = JSONFactoryUtil.createJSONObject(completedPricingAudit.getData1());
		// get comma-separated list tran codes of consolidated and outstanding payments
		String otherTranCodes = computedFeesForInvoicing.getString("transactionMasterCodes");
		JSONObject txnModel = JSONFactoryUtil.createJSONObject(completedPricingAudit.getData2());
// 		storageId
		ArrayList<String> tranCodeList = new ArrayList<String>();
        if(StringUtils.isNotEmpty(otherTranCodes)) {
        	tranCodeList.addAll(Arrays.asList(otherTranCodes.split(",")));
        }
        if(txnModel != null && txnModel.has("storageId") && StringUtils.isNotEmpty(txnModel.getString("storageId"))) {
        	tranCodeList.add(txnModel.getString("storageId"));
        }
        JSONObject txnStatus = PricingMicroserviceLocalServiceUtil.retrieveTransactionStatus(_SCOPE_ID, tranCodeList);
        List<String> completedStatusList = Arrays.asList("Completed","Confirmed");
        isCompleted = txnStatus.has("status") && completedStatusList.contains(txnStatus.getString("status"));
	}
	
	if (isCompleted) {
		userFees = computedFeesForInvoicing.getJSONObject("userFees");
	    computedCurrentFees = computedFeesForInvoicing.getJSONObject("computedCurrentFees");
		currentFees = computedCurrentFees.getJSONArray("currentFees");		
	} else {
		computedFeesForInvoicing = JSONFactoryUtil.createJSONObject();
		userFees = PricingMicroserviceLocalServiceUtil.getUserFees(_SCOPE_ID, 
				dataSource.getApplicant().getUserId(), helper.getComponentRefNumber(),
				pricingNode.getOutstanding().booleanValue(), 
				pricingNode.getConsolidate() ? helper.getConsolidateSourceId() : "",
				true);
		computedFeesForInvoicing.put("userFees", userFees);

		// check if pricingNodeOverride set by previous nodes, in which case the pricing setup of this node will be ignored
		String pricingNodeOverride = dataAdapter.getDataFromProcessState("pricingNodeOverride");
		if (org.apache.commons.lang.StringUtils.isNotEmpty(pricingNodeOverride)) {
			JSONArray pricingNodeOverrideArr = JSONFactoryUtil.createJSONArray(pricingNodeOverride);
			for (int i=0; i<pricingNodeOverrideArr.length(); i++) {
				JSONObject pricing = pricingNodeOverrideArr.getJSONObject(i);
				if (i==0) {
					computedCurrentFees = PricingMicroserviceLocalServiceUtil.computeCandidateSchemeFees(_SCOPE_ID, candidateId, pricing.getString("priceScheme"), ConvertUtil.Json.jsonArrayToStringList(pricing.getJSONArray("priceSubSchemes")));
				} else {
					JSONObject anotherComputedCurrentFees= PricingMicroserviceLocalServiceUtil.computeCandidateSchemeFees(_SCOPE_ID, candidateId, pricing.getString("priceScheme"), ConvertUtil.Json.jsonArrayToStringList(pricing.getJSONArray("priceSubSchemes")));
					computedCurrentFees.put("hasTax", computedCurrentFees.getBoolean("hasTax") || anotherComputedCurrentFees.getBoolean("hasTax"));
					computedCurrentFees.put("currentNetFees", computedCurrentFees.getDouble("currentNetFees") + anotherComputedCurrentFees.getDouble("currentNetFees"));
					computedCurrentFees.put("hasDiscount", computedCurrentFees.getBoolean("hasDiscount") || anotherComputedCurrentFees.getBoolean("hasDiscount"));
					// transfer all current net fees
					JSONArray anotherCurrentFees = anotherComputedCurrentFees.getJSONArray("currentFees");
					for (int x=0; x<anotherCurrentFees.length(); x++) {
						computedCurrentFees.getJSONArray("currentFees").put(anotherCurrentFees.getJSONObject(x));
					}
				}
			}
			currentFees = computedCurrentFees.getJSONArray("currentFees");
			computedFeesForInvoicing.put("computedCurrentFees", computedCurrentFees);
		} else {
		    computedCurrentFees = PricingMicroserviceLocalServiceUtil.computeCandidateSchemeFees(_SCOPE_ID, candidateId, selectedScheme, selectedSubSchemes);
			currentFees = computedCurrentFees.getJSONArray("currentFees");
			computedFeesForInvoicing.put("computedCurrentFees", computedCurrentFees);
		}
	}
	outstandingFees = userFees.getJSONArray("outstandingFees");
	totalOutstandingFees = userFees.getDouble("currentOutstandingFees");
	consolidateFees = userFees.getJSONArray("consolidateFees");
	totalConsolidateFees = userFees.getDouble("currentOtherConsolidatedFees");
	
	long processStateId = 0;
	if (output.getProcessState() != null && output.getProcessState().getUserIdProcess() != 0) {
		processStateId = output.getProcessState().getSpPEProcessStateId();
	}
	
	String baseCurrency = SambaashUtil.getParameter("base_currency", themeDisplay.getScopeGroupId());
	Set<String> tmOtherTranCodes = new HashSet<String>();
	
	boolean hasTax = computedCurrentFees.getBoolean("hasTax");
	boolean hasDiscount = computedCurrentFees.getBoolean("hasDiscount");

	double currentNetFees = computedCurrentFees.getDouble("currentNetFees");
	computedFeesForInvoicing.put("currentNetFees", currentNetFees);
	computedFeesForInvoicing.put("currency", baseCurrency);
	boolean hasOutstandingFees = outstandingFees.length() > 0;	
	
	String hasTaxDisplayStyle = hasTax ? "" : "display: none;";
	String hasDiscountDisplayStyle = hasDiscount ? "" : "display: none;";
%>

<style type="text/css">

.pe-fee-details th, .pe-fee-details td {
    text-align: left;
}

.aui table .fee-header td {
    background-color: #f9f8f6;
    text-align: left;
}

.aui table th.amount, .aui table td.amount {
    text-align: right;
}

.aui table .total-fee-row td {
    background-color: #faf7eb;
}

.waived:before {
    content: "Waived";
    background: rgba(255, 255, 255, 0);
    color: #F44336;
    line-height: 3.3;
    height: 100%;
    font-weight: 600;
    position: absolute;
    text-indent: -12px;
}

</style>

<portlet:actionURL name="process" var ="pricingSubmitUrl">
   <portlet:param name="action" value="pricing"/>
</portlet:actionURL>

<div style="text-align: center;margin: auto;">
	<div class="pe-fee-details">
		<aui:form action="<%= pricingSubmitUrl %>" name="pricing-fees-form">
			<aui:input name="formData"  type="hidden"></aui:input>
			<aui:input name="processStateId"  type="hidden" value="<%= processStateId %>"></aui:input>
			<aui:input name="nodeId"  type="hidden" value="<%= output.getNodeId() %>"></aui:input>
			<aui:input name="classPK"  type="hidden" value="<%= output.getClassPk() %>"></aui:input>
			<aui:input name="classNameId"  type="hidden" value="<%= output.getClassNameId() %>"></aui:input>
			<aui:input name="processId"  type="hidden" value="<%= output.getProcessId() %>"></aui:input>
			<aui:input name="actionType"  type="hidden" value="submit"></aui:input>
			
			<aui:input name="priceSchemeCode"  type="hidden" value="<%= selectedScheme %>"></aui:input>
			<aui:input name="priceSubSchemeCodes"  type="hidden" value="<%= pricingNode.getSubScheme() %>"></aui:input>
			<aui:input name="computedFeesForInvoicing"  type="hidden"></aui:input>
			
			<table>
				<thead>
					<tr>
					   <th>Items</th>
					   <th style="<%=hasTaxDisplayStyle%>">Tax Code</th>
					   <th class="amount" style="<%=hasTaxDisplayStyle%>">Tax Rate</th>
					   <th class="amount" style="<%=hasTaxDisplayStyle%>">Tax Amount</th>
					   <th class="amount" style="<%=hasDiscountDisplayStyle%>">Discount</th>
					   <th class="amount">Amount (Tax Inclusive)</th>
					</tr>				
				</thead>
				
				<tbody>
					<tr class="fee-header" style="display: none">
						<td colspan="5">OUTSTANDING</td>
					</tr>
					
					<%
					for (int i=0 ; i<outstandingFees.length(); i++) {
						JSONObject outstandingFee = outstandingFees.getJSONObject(i);
						Double oTaxAmt = outstandingFee.getDouble("taxAmount");
						Double oDiscountAmount = outstandingFee.getDouble("discountAmount");
						Double oAmount = outstandingFee.getDouble("amount");
						tmOtherTranCodes.add(outstandingFee.getString("transactionMasterCode"));
						Double oTaxPercentage = 0d;
						if (oTaxAmt>0) {
							oTaxPercentage = (oTaxAmt / (oAmount - oTaxAmt)) * 100;
						}
						%>
						<tr class="outstanding-detail-row">
							<td><%=outstandingFee.getString("priceSubSchemeName")%></td>
							<td style="<%=hasTaxDisplayStyle%>"><%=outstandingFee.getString("taxCode")%></td>
							<td class="amount" style="<%=hasTaxDisplayStyle%>"><%=oTaxPercentage>0 ? String.format("%1$,.2f",oTaxPercentage):""%></td>
							<td class="amount" style="<%=hasTaxDisplayStyle%>"><%=oTaxAmt>0 ? String.format("%1$,.2f",oTaxAmt):""%></td>
							<td class="amount" style="<%=hasDiscountDisplayStyle%>"><%=oDiscountAmount>0 ? String.format("%1$,.2f",oDiscountAmount):""%></td>
							<td class="amount"><%=oAmount>0 ? String.format("%1$,.2f",oAmount):""%></td>
						</tr>
						<%
					}
					%>
	
					<tr class="fee-header" style="display: none">
						<td colspan="5">CURRENT</td>
					</tr>
	
					<%
					for (int i=0; i<currentFees.length(); i++) {
						JSONObject currFeeDetails = currentFees.getJSONObject(i);
						if (currFeeDetails.has("amount")) {
							Double taxAmt = currFeeDetails.getDouble("taxAmount");
							Double oTaxPercentage = currFeeDetails.getDouble("taxPercentage");
							Double discountAmount = currFeeDetails.getDouble("discountAmount");
							Double amount = currFeeDetails.getDouble("computedAmount");
							boolean isWaived = currFeeDetails.has("isWaived") && currFeeDetails.getBoolean("isWaived");
						%>
						<tr class="fee-detail-row">
							<td><%=currFeeDetails.getString("priceSubSchemeName")%></td>
							<td style="<%=hasTaxDisplayStyle%>"><%=currFeeDetails.getString("taxCode")%></td>
							<td class="amount" style="<%=hasTaxDisplayStyle%>"><%=oTaxPercentage>0 ? String.format("%1$,.2f",oTaxPercentage):""%></td>
							<td class="amount <%=isWaived ? "waived" : ""%>" style="<%=hasTaxDisplayStyle%>"><%=taxAmt>0 ? String.format("%1$,.2f",taxAmt):""%></td>
							<td class="amount<%=isWaived ? "waived" : ""%>" style="<%=hasDiscountDisplayStyle%>"><%=discountAmount>0 ? String.format("%1$,.2f",discountAmount):""%></td>
							<td class="amount <%=isWaived ? "waived" : ""%>"><%=amount>0 ? String.format("%1$,.2f",amount):""%></td>
						</tr>
						<%						
						}
					}
					%>

					<%
					for (int i=0 ; i<consolidateFees.length(); i++) {
						JSONObject consolidateFee = consolidateFees.getJSONObject(i);
						Double cTaxAmt = consolidateFee.getDouble("taxAmount");
						Double cDiscountAmount = consolidateFee.getDouble("discountAmount");
						Double cAmount = consolidateFee.getDouble("amount");
						tmOtherTranCodes.add(consolidateFee.getString("transactionMasterCode"));
						Double cTaxPercentage = 0d;
						if (cTaxAmt>0) {
							cTaxPercentage = (cTaxAmt / (cAmount - cTaxAmt)) * 100;
						}
						%>
						<tr class="outstanding-detail-row">
							<td><%=consolidateFee.getString("priceSubSchemeName")%></td>
							<td style="<%=hasTaxDisplayStyle%>"><%=consolidateFee.getString("taxCode")%></td>
							<td class="amount" style="<%=hasTaxDisplayStyle%>"><%=cTaxPercentage>0 ? String.format("%1$,.2f",cTaxPercentage):""%></td>
							<td class="amount" style="<%=hasTaxDisplayStyle%>"><%=cTaxAmt>0 ? String.format("%1$,.2f",cTaxAmt):""%></td>
							<td class="amount" style="<%=hasDiscountDisplayStyle%>"><%=cDiscountAmount>0 ? String.format("%1$,.2f",cDiscountAmount):""%></td>
							<td class="amount"><%=cAmount>0 ? String.format("%1$,.2f",cAmount):""%></td>
						</tr>
						<%
					}
					%>

				</tbody>
				
				<tfoot>
					<tr class="total-fee-row">
						<td>Total Amount Payable</td>
						<td style="<%=hasTaxDisplayStyle%>"></td>
						<td style="<%=hasTaxDisplayStyle%>"></td>
						<td style="<%=hasTaxDisplayStyle%>"></td>
						<td style="<%=hasDiscountDisplayStyle%>"></td>
						<td class="amount"><%= baseCurrency + " " +String.format("%1$,.2f",currentNetFees + totalOutstandingFees + totalConsolidateFees) %></td>
					</tr>
				</tfoot>
			</table>
			<%
			if (output.isCanEdit() || output.isCanSubmit()) {
			%>
			  <aui:button-row>
			    <aui:button name="_pr_back" value="BACK" onClick="PricingController.back()"/>
				<aui:button name="_pr_acknowledgeFees" type="submit" value="SAVE & NEXT" onClick="PricingController.submit()"/>
				<aui:button name="_pr_cancel" value="CANCEL" onClick="PricingController.cancel()"/>
			  </aui:button-row>
			<%	
			}
			%>
		</aui:form>
	</div>
</div>

<%
	computedFeesForInvoicing.put("transactionMasterCodes", org.apache.commons.lang.StringUtils.join(new ArrayList<String>(tmOtherTranCodes), ","));
%>

<aui:script use="aui-base,aui-node,aui-io-request">
	const PricingController = function(A, namespace) {
		const computedFeesForInvoicing = <%= computedFeesForInvoicing.toString() %>;
		var _ns = namespace;
		var _A = A;
		
		var _init = function() {
			_A.on('domready', function () {
				console.log("_ns="+_ns);
				var hasOutstandingFees = <%= hasOutstandingFees %>;
				if (hasOutstandingFees) {
					_A.all(".fee-header").show();
				}
			});
		}
		
		var _submit = function() {
			var dataNode = _A.one("#" + _ns + "computedFeesForInvoicing");
			var dataStr = JSON.stringify(computedFeesForInvoicing);
			dataNode.val(dataStr);
			_A.one("#" + _ns + "pricing-fees-form").submit();
		}
		
		var _back = function() {
			if (!steps) {
        		console.log("Steps are null");
        		window.history.back();
        		return;
        	}
        	for(var i = 0; i < steps.length ; i++) {
        		if(steps[i].id == processStateObj.currentStatusTypeId){
        			var redirectUrl = steps[i - 1].url;
        			var res = redirectUrl.indexOf("/",10);
        			redirectUrl = redirectUrl.substring(redirectUrl.indexOf("/",10));
        			console.log(redirectUrl);
        			window.location.href = redirectUrl;
        		}
        		
        	}
		}
		
		var _cancel = function() {
			window.location.href = "/workspace";
		}
		
		return {
			init : _init,
			submit: _submit,
			back: _back,
			cancel: _cancel
		}
	}(AUI(), '<portlet:namespace />');

	window.PricingController = PricingController;
	PricingController.init();
</aui:script>