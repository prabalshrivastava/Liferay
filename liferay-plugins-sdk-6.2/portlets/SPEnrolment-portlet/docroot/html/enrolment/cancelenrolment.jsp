<%@ page import="com.sambaash.platform.util.PermissionUtil"%>
<%@ page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>

<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/switchsubjects.css?<%=System.currentTimeMillis()%>"/>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='<%=request.getContextPath()%>/css/main.css?<%=System.currentTimeMillis()%>'>

<portlet:defineObjects />

<portlet:renderURL var="sponsorshipLink">
  <portlet:param name="jspPage" value="/html/enrolment/sponsorship.jsp" />
</portlet:renderURL>

<portlet:renderURL var="batchEnrolement">
  <portlet:param name="jspPage" value="/html/enrolment/batch/upload.jsp" />
</portlet:renderURL>

<portlet:renderURL var="homePage">
  <portlet:param name="jspPage" value="/html/enrolment/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="listLink">
  <portlet:param name="jspPage" value="/html/enrolment/candidatelist.jsp" />
</portlet:renderURL>

<portlet:renderURL var="uploadLink">
  <portlet:param name="jspPage" value="/html/enrolment/batch/upload.jsp" />
</portlet:renderURL>


<div class="newPortlets">
  <div class="subHeader">
    <div class="container">
    	<div class="inner-container">
      <aui:row>
        <aui:col span="10" cssClass="text-center"><h2><span>Cancel Enrolment</span></h2></aui:col
        >
        <aui:col span="2" cssClass="text-right"
          ><a href="<%= homePage %>" title="Back to Home">Back to Home
            </a>
          </aui:col>
      </aui:row>
      </div>
    </div>
  </div>
<div class="w-95 mx-auto">
<div class="title-container">
      <div class="">
        <img src="<%=request.getContextPath()%>/img/fee.png"
     srcset="<%=request.getContextPath()%>/img/fee@2x.png 2x,
             img/fee@3x.png 3x"
     class="title-icon">
        

        <span class="title">FEE STRUCTURE</span>
      </div>
      <div class="horizontal-line"></div>
    </div>

    <div id="fee-container" class="mt-5">
      <div id="standardFeeToggler">
        <h4
          class="standardFeeHeader fee-toggler-header toggler-header-expanded"
        >
          <span>STANDARD FEE</span>
        </h4>
        <div class="standardFeeContent toggler-content-expanded ">
          <table id="fees" class="aui">
            <thead>
              <tr class="Heading">
                <th>Subject Name & Code</th>
                <th>Pricing SubType</th>
                <th>Subject Type</th>
                <th>CCY</th>
                <th>Amount (Incl GST)</th>
              </tr>
            </thead>
            <tbody>
              <tr id="fess_data_row" class="fees_table_row Row">
                <td>
                  <label id="rul_id" class="rul_id"
                    >[FN3023] Investment management</label
                  >
                </td>
                <td><label id="rul_set" class="rul_set">Exam Fees</label></td>
                <td>
                  <label id="rul_CompType" class="rul_CompType"
                    >Full Unit</label
                  >
                </td>
                <td><label id="rul_CompId" class="rul_CompId">SGD</label></td>
                <td><label id="rul_No" class="rul_No">92</label></td>
              </tr>

              <tr id="fess_data_row" class="fees_table_row Row">
                <td>
                  <label id="rul_id" class="rul_id"
                    >[FN3023] Investment management</label
                  >
                </td>
                <td><label id="rul_set" class="rul_set">Local Fees</label></td>
                <td>
                  <label id="rul_CompType" class="rul_CompType"
                    >Full Unit</label
                  >
                </td>
                <td><label id="rul_CompId" class="rul_CompId">SGD</label></td>
                <td><label id="rul_No" class="rul_No">45</label></td>
              </tr>

              <tr id="fess_data_row" class="fees_table_row Row">
                <td>
                  <label id="rul_id" class="rul_id"
                    >[FN2191] Principles of Corporate Finance</label
                  >
                </td>
                <td><label id="rul_set" class="rul_set">Exam Fees</label></td>
                <td>
                  <label id="rul_CompType" class="rul_CompType"
                    >Half Unit</label
                  >
                </td>
                <td><label id="rul_CompId" class="rul_CompId">SGD</label></td>
                <td><label id="rul_No" class="rul_No">12</label></td>
              </tr>

              <tr id="fess_data_row" class="fees_table_row Row">
                <td>
                  <label id="rul_id" class="rul_id"
                    >[FN2191] Principles of Corporate Finance</label
                  >
                </td>
                <td><label id="rul_set" class="rul_set">Exam Fees</label></td>
                <td>
                  <label id="rul_CompType" class="rul_CompType"
                    >Full Unit</label
                  >
                </td>
                <td><label id="rul_CompId" class="rul_CompId">SGD</label></td>
                <td><label id="rul_No" class="rul_No">925</label></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>

      <div id="miscellaneousFeesToggler">
        <h4
          class="miscellaneousFeesHeader fee-toggler-header toggler-header-expanded"
        >
          <span>MISCELLANEOUS FEE</span>
        </h4>
        <div class="miscellaneousFeesContent  toggler-content-expanded">
          <div id="miscFeesMultiSelect"></div>

          <div id="miscFeesSelectedItemsGrid">
            <table id="misc-fees" class="aui">
              <thead>
                <tr class="Heading">
                  <th>Misc. Fee</th>
                  <th>Fee (incl GST)</th>
                  <th>Quantity</th>
                  <th>Total Fees ($)</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
          </div>
        </div>
      </div>
      <div class='mx-auto w-33 d-flex justify-content-around'>
        <div>
        <span class="listSpanTitleDefault">Credit Exam Fees</span>
        	<input type="radio" name="creditFees" value="exam">
        	</div>
        	<div>
        	<span class="listSpanTitleDefault">Credit Local Fees</span>
        	<input type="radio" name="creditFees" value="local">
        	</div> 
        </div>
    </div>
    
    <div class="title-container">
      <span class="">
        <img src="<%=request.getContextPath()%>/img/fee.png"
     srcset="<%=request.getContextPath()%>/img/fee@2x.png 2x,
             img/fee@3x.png 3x"
     class="title-icon">
        

        <span class="title">TOTAL FEE PAYABLE / RECEIVABLE</span>
      </span>
      <div class="horizontal-line"></div>
    </div>
    <div id="">
        <div class="miscellaneousFeesContent">
          <div id="miscFeesMultiSelect"></div>

          <div id="miscFeesSelectedItemsGrid">
            <table id="misc-fees" class="aui">
              <thead>
                <tr class="Heading">
                  <th></th>
                  <th>Standard Fee (incl. GST)</th>
                  <th>Standard Fee (incl. GST)</th>
                  <th>GST</th>
                  <th>Total Fee (excl GST)</th>
                  <th>Total Fee Payable (SGD)</th>
                </tr>
              </thead>
              <tbody>
              <tr>
              <td>CURRENT SUBJECT(S)<span class='badge-success'>Amount Paid</span></td>
              <td>925.00</td>
              <td>184.00</td>
              <td>72.52</td>
              <td>1036</td>
              <td>1109.00</td>
              </tr>
              <tr>
              <td>NEW SUBJECT(S)</td>
              <td>818.00</td>
              <td>123.00</td>
              <td>61.53</td>
              <td>879</td>
              <td>941.00</td>
              </tr>
              </tbody>
              <tfoot>
              <td class="text-right text-bold" colspan=5>TOTAL REFUND</td>
              <td class="text-bold">168.00</td>
              </tfoot>
            </table>
          </div>
        </div>
      </div>
      <div class="enrolment-center-align py-5">
      <label class='title'>Reasons for Cancellation</label>
      <textarea placeholder="Enter the reason..." class="reason-textarea"></textarea>
      </div>
      <div class="enrolment-center-align py-5">
            <aui:button-row cssClass="text-center">
                <aui:button type="button" value="SAVE" />
                <aui:button cssClass="btn-primary" value="SEND FOR APPROVAL" />
                <aui:button type="button" value="CANCEL" />
            </aui:button-row>
        </div>
   </div>
</div>