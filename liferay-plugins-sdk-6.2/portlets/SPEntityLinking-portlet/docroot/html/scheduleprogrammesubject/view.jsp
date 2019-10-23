<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib
	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/link.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2""></script>

<portlet:defineObjects />
<portlet:resourceURL var="ajaxUrl">

</portlet:resourceURL>
<%
	String dashBoardLink = SambaashUtil.getDashBoard();

	String leftModel = renderRequest.getPreferences().getValue("leftModel", "");
	String rightModel = renderRequest.getPreferences().getValue("rightModel", "");
%>

<c:set var="leftModel" value="<%=leftModel%>" />
<c:set var="rightModel" value="<%=rightModel%>" />


<div class="newPortlets">
<div class="subHeader">
	<div class="container">
		<aui:row>
			<aui:col span="10" cssClass="text-center"><h2>Schedule Subject Linking</h2></aui:col>
			<aui:col span="2" cssClass="text-right"><aui:a href="<%= dashBoardLink %>" title="Back to Dashboard">Back to Dashboard</aui:a></aui:col>
		</aui:row>
	</div>
</div>


<ul>
	<li class="liAnchorElement" style="display:none" >
		<a>MSE002</a>
		<span  style="display:none">CC</span>
	</li>
	 
	<li id ="listElement" class="listElement" style="display:none">
		<label>
			<input type="checkbox"  name="programm" class="listCheckBox" onChange="modifyList(this,'left')"/>
			<span class="listSpanTitle">PP</span>
			<span class="listSpanCode" style="display:none">CC</span>
		</label>
	</li>
</ul>




<div class="sambaashContent ">
	<form class="formContainer" id="mappingform" >
	<div class="container entitylink">
		<aui:row cssClass="entityTab">
			<aui:col span="6" cssClass="text-center posRelative"><em class="progIcon"></em>
				<select id="leftDropdown" onchange="leftDropdownChanged()">
					
					<option value="programme-schedule">PROGRAMME-SCHEDULE</option>
				</select>

			</aui:col>
			<aui:col span="6" cssClass="text-center posRelative"><em class="subIcon"></em>
				<select id="rightDropdown" onchange="rightDropdownChanged()">
					<option value="price-scheme">SCHEDULE</option>
				</select>
			</aui:col>
		</aui:row>
		<div id="myAutoComplete"></div>
		<aui:row cssClass="entitylinkBox">
			<aui:col span="6" cssClass="text-center">
				<div class="entitySearch">
					<aui:row>
						<aui:col span="12">
							<div class="selectedItem slectedItem">
								<ul></ul>
							</div>
							<aui:input type="text"  name="left" placeholder="Search for a ${leftModel} title or code" onchange="leftDropdownChanged1(this)"></aui:input>
						</aui:col>
					</aui:row>
					<aui:row>
						<div class="programmeDiv" id="programmeDiv">
							<aui:col span="12">
							<ul>
							
								<li>
									<label> 
										<input type="checkbox" name="programm" class="checkNone" id="checkNoneLeft" onchange="checkNone(this,'left')"> 
										<span class="listSpanTitleDefault">None</span>
									</label> 
								</li>
								<li>
									<label> 
										<input type="checkbox" name="programm" class="checkAll" onchange="checkAll(this,'left')"> 
										<span class="listSpanTitleDefault">All</span>
									</label> 
								</li>
								
							</ul>
						</aui:col>
						</div>
					</aui:row>
				</div>
			</aui:col>
			<aui:col span="6" cssClass="text-center">
				<div class="entitySearch">
					<aui:row>
						<aui:col span="12">
						<div class="selectedItem slectedItem">
								<ul></ul>
							</div>
							<aui:input type="text"  name="right" placeholder="Search for a ${rightModel} title or code" onchange="rightDropdownChanged()"></aui:input>
						</aui:col>
					</aui:row>
					<aui:row>
						<div class="subjectDiv" id="subjectDiv"> 
							<aui:col span="12">
								<ul>
									<li>
									<label> 
										<input type="checkbox" name="programm" class="checkNone"  id="checkNoneRight"  onchange="checkNone(this,'right')"> 
										<span class="listSpanTitleDefault">None</span>
									</label> 
								</li>
								<li>
									<label> 
										<input type="checkbox" name="programm" class="checkAll" onchange="checkAll(this,'right')"> 
										<span class="listSpanTitleDefault">All</span>
									</label> 
								</li>
								
									
								</ul>
							</aui:col>
						</div>
						
					</aui:row>
					
				</div>
			</aui:col>
			<div class="msg">Search and add entities for mapping</div>
		</aui:row>
		
		<aui:row cssClass="routeCode addEntityDetails" >
				<aui:col span="12" cssClass="text-center routeCodeEnter">
					
					<aui:col span="4" cssClass="text-center">
					</aui:col>
					<aui:col span="4">
						<aui:col span="2"></aui:col>
						<aui:col span="4">
							<label>Route Code</label>
						</aui:col>
						<aui:col span="4">
							<input type="text" id="RouteCode" name="RouteCode" class="form-control" />
						</aui:col>
					</aui:col>
					<aui:col span="4" cssClass="text-center">
					</aui:col>
				</aui:col>
				<aui:col span="12" cssClass="text-center">
					<aui:col span="4" cssClass="text-center">
					</aui:col>
					<aui:col span="4">
					<button class="btn btn-primary" id="save_btn" type="button" disabled="disabled" onClick="saveLink()">Save</button> 
				 	 <button class="btn btn-default"  onclick="reset1()" type="button">Clear</button>
					</aui:col>
					<aui:col span="4" cssClass="text-center">
					</aui:col>
					 
	 			</aui:col>
			</aui:row>
			
		
		
		
	</div>
	</form>
	
</div>


<div id="sucess-popup" hidden="true" class="modalpopupBox">
		<div id="sucess-popup-box" class="modalpopupContent">
			<form class="formContainer">
				<aui:row>
					<aui:col span="12">
						<h3>Linked Successful</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12">
						<button class="btn btn-primary  pull-left" onClick="reloadPage()">Start Again</button>
      					<button class="btn btn-default pull-right" type="button" onClick="moveToDashboard()">BACK TO HOME</button>
					</aui:col>
				</aui:row>
			</form>
		</div>
	</div>

<div id="overwrite-popup" hidden="true" class="modalpopupBox">
   <div id="overwrite-popup-box" class="modalpopupContent">
   <form class="formContainer" >
     <aui:row>
         <aui:col span="12">
       	  <h3>Choosing multiple Left side Records will reset the previous links to this records. </h3>
       	  </aui:col>
       
     </aui:row>
     <aui:row>
      	<aui:col span="12" cssClass="text-center">
      		<button type="button" class="btn btn-primary  closeBtn" >OK</button>
      		
      	</aui:col>
     </aui:row>
           
   </form>
   </div>
</div>


<div id="error-popup" hidden="true" class="modalpopupBox">
		<div id="error-popup-box" class="modalpopupContent">
			<form class="formContainer" action="">
				<aui:row>
					<aui:col span="12">
						<h3 id="error-msg">Price Scheme(s) doesn't fall within schedule(s) timeline.</h3>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col span="12">
						<button type="button"
							class="btn btn-default popup-confirm-archive pull-left"
							onClick="reloadPage()">Start Again</button>
						<button class="btn cancel bluebtn popup-cancel pull-right">DashBoard</button>
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

var mode = "edit";
var namespace = "<portlet:namespace/>";
const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
                    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
                  ];
var leftSideList = [],rightSideList = [],selectedLeftModel = [],selectedRightModel = [],elem1;
var ajaxUrl = "<%=ajaxUrl.toString()%>";
var listElement = document.getElementById("listElement");
var liAnchorElement  = document.getElementsByClassName("liAnchorElement")[0];
var selectedItem;
var entitySearch;
var inp_waivefee, inp_subject_sub_type;
var progLoaded, schLoaded, linkingLoaded;
var programmeList = [];
var priceSchemeList = [];
var scheduleList = [];
var entityLinkList = [];
var dashBoardLink = "<%=dashBoardLink%>";
var linkType = "";
var formType = "EntityLink";
	
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js?<%=System.currentTimeMillis()%>"
	language="javascript1.2"></script>
<style>
.listSpanTitle {
	margin-left: 37px;
	width: 100% !important;
	text-align: left;
	margin-top: 20px !important;
}
</style>