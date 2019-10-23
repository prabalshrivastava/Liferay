<%@page import="com.sambaash.platform.pe.jaxb.PEJSP"%>
<%@page import="java.util.Currency"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.sambaash.platform.pe.course.enroll.CourseEnrollConstants"%>
<%@page import="com.sambaash.platform.pe.course.enroll.CourseEnrollFeeHelper"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.model.FeeType"%>
<%@page import="com.sambaash.platform.pe.PEDataSource"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.srv.model.Course"%>
<%@page import="com.sambaash.platform.srv.service.CourseLocalServiceUtil"%>
<%@ page import="com.sambaash.platform.srv.model.Product" %>
<%@ page import="com.sambaash.platform.srv.processbuilder.model.PEProcessState" %>
<%@ page import="com.sambaash.platform.srv.service.ProductLocalServiceUtil" %>
<%@ page import="com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter" %>

<%@ include file="/html/init.jsp" %>
<% String OPTION = "<option value='%s' %s>%s</option>"; %>
<%
   //PEDataSource dataSource = (PEDataSource)request.getAttribute(PEConstants.ATTR_DATA_SOURCE);
PEOutput output =(PEOutput) renderRequest.getAttribute(PEConstants.ATTR_OUTPUT);
PEDataSource dataSource = output.getDataSource();
boolean editFeeDetails = dataSource.getProcess().getEditFeeDetails();
CourseEnrollFeeHelper feeHelper = CourseEnrollFeeHelper.getInstance(dataSource,(PEJSP) dataSource.getDirectory().getNode(output.getNodeId()));
PEProcessStateDataAdapter processStateDataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(dataSource.getProcessState());
boolean isContractReleased = Boolean.valueOf(processStateDataAdapter.getDataFromProcessState("isContractReleased", true));
boolean isCompleted = feeHelper.isFeeDetailsCompleted();
Product product = ProductLocalServiceUtil.getProduct(dataSource.getProcessState().getEntityId());
boolean isQualificationType = ProductLocalServiceUtil.isQualificationTypeProduct(product);
Course course = CourseLocalServiceUtil.getCourse(product.getSpCourseId());
String currencyCode = "";
try {
   Country country = CountryServiceUtil.getCountryByName(AssetCategoryLocalServiceUtil
         .getAssetCategory(Long.parseLong(course.getCountryId())).getName().toLowerCase());
   Locale localeTemp = new Locale("", country.getA2());
   currencyCode = Currency.getInstance(localeTemp).getCurrencyCode();
} catch (Exception e) {
	_log.error(e.getMessage());
}

if (!editFeeDetails) {
%>
<style>
.disable_editing{
    pointer-events:none;
}
</style>
<%}%>

      <jsp:include page="/html/formData.jsp"></jsp:include>
      
      <div class="feeDetailWrap form-inner Border Form-pop-padding bg_title">
         <ul id="feeRowContainer" class="disable_editing">
            <div class="Div_Head_row">
                                    <div class="col1"> Label</div>
                                    <div class="col2">Fees Breakdown</div>
                                    <div class="col3">Formula (+, -, *, /, Labels)</div>
                                    <div class="col4">Total Payable(<%= currencyCode %>)</div>
                                </div>
         </ul>
         <c:if test="<%=((output.isCanEdit() || output.isCanSubmit()) && (editFeeDetails) && (!isContractReleased)) %>">
          <div class="Input_Fullwidth Addproduct_click addFeeFunding-button aclign-margintop">
            <div class="Add_button">
               <a href="javascript:;" id="addFee"
                  class="Button-green button-pos-center feeInstButton">Add Fee
                  Component</a>
            </div>
         </div>
         </c:if>
      </div>
      <c:if test="<%= isQualificationType %>">
      <div class="disable_editing">
         <div class="instSelectContainer">
         <span>
         Total number of Installments
         </span>
            <select id="noOfInsmnts">
                 <% for(int i = 1 ; i<=4; i++){
                  out.print(String.format(OPTION,  i,StringPool.BLANK,i));    
                  }
                 %>
            </select>
         </div>
         <div class="finstmntRowWrap form-inner Border Form-pop-padding bg_title">
         <div class="Div_Head_row">
                                       <div class="col1"> Installment Schedule</div>
                                       <div class="col2">Amount(<%=currencyCode %>)</div>
                                       <div class="col3">Date due</div>
                                   </div>
            <div id="instmntRowContainer">
                
               
            </div>
         </div>
         </div>
      </c:if>

      <c:if test="<%= output.isCanEdit() && editFeeDetails && !isContractReleased%>">
         <div class="btn-div">
            <aui:button id="save" name="save"  value="save.button.text"></aui:button>
         </div>
      </c:if>
      <c:if test="<%= output.isCanSubmit() && editFeeDetails && !isContractReleased%>">
         <div class="btn-div">
            <aui:button id="submit" name="submit"  value="submit.button.text"></aui:button>
         </div>
      </c:if>
      <li id="feeRowTemplate" data-id=feeRow class="hide Div_Col_row drag_Icon_Fee">
      
        <div class="feeRowCol col1">
          
           <select id="feeLabel">
              <%
               char temp;
               for(int i = 65 ; i < 91; i++){
                  temp = (char)i;
                  out.print(String.format(OPTION, temp,StringPool.BLANK,temp));
               }
              %>
           </select>
        </div>
        <div class="feeRowCol col2">
           <select id="feeType">
             <%
                 try{
                    List<FeeType> types = FeeTypeLocalServiceUtil.findByMisc(false);
                    for(FeeType type : types){
                      out.print(String.format(OPTION, type.getFeeType(),StringPool.BLANK,type.getFeeTypeName())); 
                    }
                 }catch(Exception ex){
                	 _log.error(ex.getMessage());
                 }
             %>
           </select>
        </div>
        <div class="feeRowCol col3">
            <input type="text" id="formula"/>
        </div>
        <div class="feeRowCol col4">
           <input type="text" id="feeAmount" />
           <input type="hidden" id="order" />
        </div>
         <div class="close_button">
          <span id="remove"><img src="/SPProcessEngine-portlet/images/close.svg" alt="Close"></span>
      </div>
      
      </li>
      
      <div id="insmntRowTemplate" class="hide Div_Col_row" data-id="instmntRow"> 
         <input type="hidden" id="insmntNo"/>
         <div class="feeRowInstCol col1">
            <span id="insmntNoTxt"></span>Installment
         </div>
         <div class="feeRowInstCol col2">
            <input type="text" id="instmntAmount" />
         </div>
         <div class="feeRowInstCol col3">
            <div id="dateContainer">
               <input type="text" id="date" data-id="date"/>
            </div>
         </div>
      </div>
      
      <portlet:resourceURL var ="ajaxUrl">
         <portlet:param name="action" value="CourseEnrollmentProcess"/>
      </portlet:resourceURL>
      <script src="/SPProcessEngine-portlet/js/custom/enrollmentcourse/feeDetails.js?t=<%=DateUtil.newTime() %>">
      </script>
       <script src="/SPProcessEngine-portlet/js/custom/enrollmentcourse/feeDetaisDragDrop.js?t=<%=DateUtil.newTime() %>">
      </script>

        <script>
      // dragover
     initSortable( "feeRowContainer" );
      </script>
      <script>
        var FEE_TYPE_COURSE_FEE = "<%=CourseEnrollConstants.FEE_TYPE_COURSE_FEE%>";
        var FEE_TYPE_WDA_GRANT = "<%=CourseEnrollConstants.FEE_TYPE_WDA_GRANT%>";
        var TOTAL_FEE_PAYABLE_TO_LITHAN = "<%=CourseEnrollConstants.TOTAL_FEE_PAYABLE_TO_LITHAN%>";
        var disabled = <%= !output.isCanEdit() && !output.isCanSubmit() %>;
        var feeDetail;
        AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated','aui-datepicker',function(A) {
           var config = {  };
           config.A = A;
           config.defaultFeeRows = <%= feeHelper.getExistingFeeDetails() %>;
           config.defaultInstmntRows = <%= feeHelper.getExistingInsmntDetails() %>;
           config.editFeeDetails = <%= editFeeDetails%>,
           config.disabled =  disabled ,
           config.insmntsExist = <%= isQualificationType%>,
           config.ajaxUrl = '<%=ajaxUrl%>';
           feeDetail = new FeeDetails(config);
         });
      </script>
     

  
<%!
private static Log _log = LogFactoryUtil.getLog("html.custom.enrollmentcourse.feeDetails_jsp");
%>     
