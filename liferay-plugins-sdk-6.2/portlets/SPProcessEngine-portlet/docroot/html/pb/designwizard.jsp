<%@page import="com.sambaash.platform.pe.helpers.ProcessBuilderHelper"%>
<%@page import="com.sambaash.platform.model.payment.PaymentProvider"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.sambaash.platform.util.SambaashUtil" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="com.sambaash.platform.pe.PEEntityClassRegister"%>
<%@page import="java.util.Map"%>

<portlet:defineObjects />

<!-- Resource URL for AJAX -->
<portlet:resourceURL id = "SaveProcess" var="saveProcessURL"></portlet:resourceURL>
<portlet:resourceURL id = "retriveNodeSkelton" var="retriveNodeInfoURL"></portlet:resourceURL>
<portlet:resourceURL id = "retriveModelPopupDropDownList" var="retriveModelPopupDropDownListURL"></portlet:resourceURL>
<portlet:resourceURL id = "retriveRuleSetId" var="retriveRuleSetIdURL"></portlet:resourceURL>
<portlet:resourceURL id = "validateEmailAddress" var="validateEmailAddressURL"></portlet:resourceURL>
<portlet:resourceURL id = "getPKs" var="getPKsURL"></portlet:resourceURL>
<portlet:resourceURL id = "getPriceSubSchemes" var="getPriceSubSchemesURL"></portlet:resourceURL>


<!doctype html>
<html lang="en">

	<head>
		<title>Process Builder</title>
		<link href="/SPProcessEngine-portlet/css/jquery-ui.css" rel="stylesheet" />
		<link href="/SPProcessEngine-portlet/css/spprocessbuilder.css" rel="stylesheet" />
		<link href="/SPProcessEngine-portlet/css/model-popup.css" rel="stylesheet" />
		<link href="/SPProcessEngine-portlet/css/jquery.contextMenu.css" rel="stylesheet" />
		<link href="/SPProcessEngine-portlet/css/process-builder-fixes.css?v=2" rel="stylesheet" />
		<link href="/SPProcessEngine-portlet/css/jquery-cron.css" rel="stylesheet" />
		<link href="/SPProcessEngine-portlet/css/jquery-gentleSelect.css" rel="stylesheet" />

		<script src="/SPProcessEngine-portlet/js/pb/lib/jquery.min.js"></script>
		<script src="/SPProcessEngine-portlet/js/pb/lib/jquery-ui.js"></script>
		<script src="/SPProcessEngine-portlet/js/pb/lib/kinetic-v4.3.3.min.js"></script>
		
		<script src="/SPProcessEngine-portlet/js/pb/lib/jquery.contextMenu.js"></script>
		<script src="/SPProcessEngine-portlet/js/pb/lib/jquery.contextMenu.js"></script>
		<script src="/SPProcessEngine-portlet/js/pb/lib/jquery.ui.position.min.js"></script>
		<script src="/SPProcessEngine-portlet/js/pb/lib/jquery-cron.js"></script>
		<script src="/SPProcessEngine-portlet/js/pb/lib/jquery-gentleSelect.js"></script>
			
		<script type="text/javascript">
			var processID = <%= renderRequest.getParameter("processId") %>;
			var isUpdate = <%= renderRequest.getParameter("isUpdate") %>;					
		</script>	
		
	</head>
	
	<body>

		

		<!--***PROCESS TOP HEADER-->
		<div class="newPortlets">
		<div class="formRoot">
		
		<section class="SectionHeader BgPink-Border-ProcessNav topHeaderFixed" style="margin-top: 75px;">
				<div class="HeaderContainer">
				<div class="HeaderRow">
					<div class="ProcessHeader">
						<div class="ProcessBack" id="c1" onclick="rederToURL('/html/pb/process-builder.jsp')">
								<a href="#" title="">
									<img src="/SPProcessEngine-portlet/images/left-arrow-white.svg" alt="Left navigation"><p class="color-white">Process</p>
								</a>
						</div>
						<div class="ProcessTitle" id="c2">
							<h2 class="color-white"><%= renderRequest.getParameter("processId") %> - <%= renderRequest.getParameter("processName") %></h2>
						</div>
						<div class="DesignerWizard-btn" id="c3">
	    					<button onclick="saveDesignerWizard('save')" id="saveDesignerWizard" class="saveWizard greybtn">Save</button>
	    					<button onclick="saveDesignerWizard('publish')" class="saveWizard greenbtn">Publish</button>
						</div>
						
					</div>
				</div>
				</div>
		</section>
		<!--***PROCESS TOP HEADER-->
				
		<!-- Left Side Container -->
		<div class="processSideBarFixed" style="overflow-y: auto; overflow-x: hidden;">
				
		 	<div id="processdiv" class="ui-widget-content">
		 
		        <div class="ui-widget-header"><CENTER><p class="PROCESS-COMPONENTS" style="margin-top: 10px">PROCESS COMPONENTS</p></CENTER></div>
		        
		        <div id="catalog">
		            <h3>General</h3>
		            <div class="processComponentWrap">	
		            			            
		            	<table >
		            		<tr >
		            			<th >
		            				 <img alt="Form" id="form" src="/SPProcessEngine-portlet/images/Icon-Forms.png" class="droppable-icon" />
		                			<figcaption> Form</figcaption>
		            			</th>
		            			<th >
		            				<img alt="Process" id="process" src="/SPProcessEngine-portlet/images/Icon-Process.png" class="droppable-icon" />
		                			<figcaption> Process</figcaption>
		            			</th>
		            		</tr>
		            		<tr>
		            			<th >
		            				
		            				<img alt="JSP" id="jsp" src="/SPProcessEngine-portlet/images/Icon-JSP.png" class="droppable-icon" />
		                			<span class="caption"> JSP</span>
		            			</th>
		            			<th >
		            				
		            				<img alt="Payment" id="payment" src="/SPProcessEngine-portlet/images/Icon-JSP.png" class="droppable-icon" />
		                			<span class="caption"> Payment</span>
		            			</th>
		            		</tr>
		            		<tr >
		            			<th >
		            				 <img alt="Form V2" id="formV2" src="/SPProcessEngine-portlet/images/Icon-Forms.png" class="droppable-icon" />
		                			<figcaption> Form V2</figcaption>
		            			</th>
		            			<th >
		            				 <img alt="Payment V2" id="paymentV2" src="/SPProcessEngine-portlet/images/Icon-JSP.png" class="droppable-icon" />
		                			<figcaption> Payment V2</figcaption>
		            			</th>
		            		</tr>
		            		<tr >
		            			<th >
		            				 <img alt="Pricing" id="pricing" src="/SPProcessEngine-portlet/images/Icon-JSP.png" class="droppable-icon without-child" />
		                			<figcaption> Pricing</figcaption>
		            			</th>
		            			<th >
		            				 <img alt="API" id="api" src="/SPProcessEngine-portlet/images/Icon-Action2.png" class="droppable-icon without-child" />
		                			<figcaption> API</figcaption>
		            			</th>
		            		</tr>
		            		<tr >
		            			<th >
		            				 <img alt="Entity" id="entity" src="/SPProcessEngine-portlet/images/Icon-Action2.png" class="droppable-icon without-child" />
		                			<figcaption> Entity</figcaption>
		            			</th>
		            		</tr>
		            	</table>	
		            				                
		            </div>
	
		            <h3>Communications</h3>
		            <div class="processComponentWrap">				            
		            	<table >
		            		<tr >
		            			<th >
		            				<img alt="Mail" id="mail" src="/SPProcessEngine-portlet/images/Icon-Email.png" class="droppable-icon without-child" />
		                			<figcaption>Mail</figcaption>
		            			</th>
		            			<th >
		            				<img alt="Message" id="message" src="/SPProcessEngine-portlet/images/Icon-Message.png" class="droppable-icon without-child" />
		                			<figcaption>Message</figcaption>
		            			</th>
		            		</tr>			            		
		            	</table>					            					
		            </div>
	
		            <h3>Actions</h3>
		            <div class="processComponentWrap">
		            	<table >
		            		<tr >
		            			<th >
		            				<img alt="Status" id="status" src="/SPProcessEngine-portlet/images/Icon-Status.png" class="droppable-icon without-child" />
		                			<figcaption>Status</figcaption>
		            			</th>
		            			<th >
		            				<img alt="Create Account" id="account" src="/SPProcessEngine-portlet/images/Icon-Account.png" class="droppable-icon without-child" />
		                			<figcaption>Create<br>Account</figcaption>
		            			</th>
		            		</tr>
		            		<tr>
		            			<th >
		            				
		            				<img alt="Custom Action" id="customAction" src="/SPProcessEngine-portlet/images/Icon-Action2.png" class="droppable-icon without-child" />
		                			<span class="caption"> Custom Action</span>
		            			</th>
		            			<th >
		            				
		            				<img alt="Preview" id="preview" src="/SPProcessEngine-portlet/images/Preview-02.svg" class="droppable-icon without-child" />
		                			<span class="caption"> Preview</span>
		            			</th>
		            		</tr>					            		
		            	</table>				                
		            </div>
	
		            <h3>Timers</h3>
		            <div class="processComponentWrap">
		            	<table >
		            		<tr >
		            			<th >
		            				<img alt="Timers" id="timer" src="/SPProcessEngine-portlet/images/Icon-Timer.png" class="droppable-icon without-child" />
		                			<figcaption>Timers</figcaption>
		            			</th>
		            			
		            		</tr>				            		
		            	</table>					            
		            </div>
	
		            <h3>Widgets</h3>
		            <div>
		                <p>Icons will be added here.</p>
		            </div>
		            
		        </div>
		        		        
	    	</div>
	    	
    	</div>

		<div id="containerId"></div>

		<!-- This is root element drop frame, which will be clonned dynamically to add more nodes -->
		<div id="1" draggable="true" class="drop-frame">
			<div class="id-div" style="position: absolute;top:0px;left:5px;font-size:10px;">1</div>
		</div>

		<!-- Divs used in pop-up-->
		<div>
			<%@ include file="/html/pb/fragments/formV2_modal.jspf"  %>
			<%@ include file="/html/pb/fragments/api_modal.jspf"  %>
			<%@ include file="/html/pb/fragments/entity_modal.jspf"  %>
			<%@ include file="/html/pb/fragments/paymentV2_modal.jspf"  %>
			<%@ include file="/html/pb/fragments/pricing_modal.jspf"  %>
			
			<!-- The Form Modal -->
			<div id="form_model_popup" class="modal modal-hidden">
				<div class="modal-content">
				
					<div class="modal-header">
			    		<span class="close">x</span>
			    		<h2>Configure Form Component</h2>
					</div>
				
					<div class="modal-body">
					 	<input type="submit" id="btnModelCancel" value="Cancel">
					 	<input type="submit" id="btnModelSave" value="Save">
					</div>
					
				</div>
				<!-- <div class="geHsplit" title="Collapse/Expand" style="width: 8px; top: 95px; bottom: 46px; left: 208px;"></div> -->
			</div>
			
			<!-- The Form Modal Skelton -->
			<div id="form_model_popup_skelton" class="modal-body modal-hidden" style="max-height: 300px; overflow: auto;">
	 			
	    		<%@ include file="/html/pb/fragments/reprocess_config.jspf"  %>
	    		
	 			<span style="font-size:12px">Rule Set </span>
				<select id="formRuleOptions"></select><br>
	    		
	    		<span style="font-size:12px">Custom Name </span>
	    		<input type="text" id="customNameTxtField" placeholder="Enter Name">
	    		
	    		<span style="font-size:12px">Submitter </span>
	    		<select id="submitterRoleIds" multiple></select><br>
	    		
	    		<span style="font-size:12px">Submittable by applicant </span>
	    		<input type="checkbox" id="submittableByApplicant"><br>
	    		
	    		<span style="font-size:12px">Wait Message </span>
	    		
	    		<%--Ckeditor to be added later <liferay-ui:input-editor />
	    		<input name="<portlet:namespace />waitMsg" id="waitMessage" type="hidden" value="" /> --%>
	
				<textarea id="waitMessage" style="font-size:12px" cols="50" rows="10" required="required" placeholder="Enter message"></textarea><br />
				
				<input id='addDataMapSectionBtnId' onclick="showDataMapSection();" type="button" value="Add Data Map Section" />
				
				<div id="dataMapId" style="display: none;">
					<span style="font-size:12px">Datamap </span>
					<div class = "dataMapSection" style="float: left; width: 100%; border-bottom:1px solid #d9dce3;">
						
	           			<form id="dataMapFormId">
	           			
			    			<select id="formDataMapOptions" style="float: left; margin-right: 5px; width: 35%;"></select>
							<input id="formDataMapTextField" placeholder="Enter data map text" style="width: 50%;" type="text">		
													
							<div style="float: right; margin-top: 15px;">
								<input onclick="removeFormPopupRowsHelper(this, 'dataMapSection', 'dataMapId');" type="button" value=" - " />
								<input onclick="addPopupRows(this, 'dataMapSection');" type="button" value="+" />
	     					</div>	
	   							
	      				</form>
	     			</div>
				</div>
				
				<input id='addRuleSectionFormBtnId' onclick="showRuleSectionForm();" type="button" value="Add Edit Section" />
				
				<div id="ruleFormId">
					<span style="margin-top: 10px;float: left;font-size:12px;">Edit Options </span>
					
					<div class = "ruleSection" style="float: left; width: 100%; border-bottom:1px solid #d9dce3;">
						
	           			<div>
	           				
	           				<div style="font-size:12px;margin-top: 10px;float: left;">Editable By </div>
	           				<div style="float: right;">
								<input onclick="removeFormPopupRowsHelper(this, 'ruleSection', 'ruleId');" type="button" value=" - " />
								<input onclick="addPopupRows(this, 'ruleSection');" type="button" value="+" />
	     					</div>
	     					
	     					
	     					
	           				<select id="editableByRoles" multiple></select><br>
	           				
	           				<div style="font-size:12px;margin-top: 10px;float: left;">Editable Condition </div>
	           				<div style="width: 438px;height: 200px;border: solid 1px #d9dce3;border-radius: 3px;margin-top: 30px;padding: 10px;margin-bottom: 10px;">
	           				<select id="stepId">
	           				</select>
	           				<select id="editableSteps" multiple></select>
							</div>
	      				</div>
	     			</div>
				</div>
	     	</div>
	
			<!-- The Process Modal -->
			<div class="modal" id="process_model_popup">
			    <div class="modal-content">
			        <div class="modal-header">
			            <span class="close">x</span>
			            <h2>Configure Process Component</h2>
			        </div>
			        <div class="modal-body">
			        	<%@ include file="/html/pb/fragments/reprocess_config.jspf"  %>
			        	<%@ include file="/html/pb/fragments/rule_version_config.jspf"  %>
			            <select id="processRuleOptions"></select><br>
			            <input type="submit" id="btnModelCancel" value="Cancel">
				        <input type="submit" id="btnModelSave" value="Save">
			        </div>
			    </div>
			</div>
	
			<!-- The JSP Modal -->
			 <div class="modal" id="jsp_model_popup">
				<div class="modal-content">
				    <div class="modal-header">
				        <span class="close">x</span>
				        <h2>Configure JSP Component</h2>
				    </div>
				    
					   
				  
				   
				    <CENTER class="modal-submit">
				    	<input type="submit" id="btnModelCancel" value="Cancel">
				        <input type="submit" id="btnModelSave" value="Save">
				    </CENTER>
				</div>
			</div> 
			
			<!-- <div id="jsp_model_popup" class="modal modal-hidden">
				<div class="modal-content">
				
					<div class="modal-header">
			    		<span class="close">x</span>
			    		<h2>Configure JSP Component</h2>
					</div>
				
					<div class="modal-submit">
					 	<input type="submit" id="btnModelCancel" value="Cancel">
					 	<input type="submit" id="btnModelSave" value="Save">
					</div>
					
				</div>
				<div class="geHsplit" title="Collapse/Expand" style="width: 8px; top: 95px; bottom: 46px; left: 208px;"></div>
			</div> -->
			
			<div id="jsp_model_popup_skelton" class="modal-body modal-hidden" style="max-height: 300px; overflow: auto;">
					        <%@ include file="/html/pb/fragments/reprocess_config.jspf"  %>
			
				<span style="font-size:12px">Custom Name </span>					        
					    	<input type="text" id="customNameTxtField" placeholder="Enter Name">
					        
					        <%@ include file="/html/pb/fragments/rule_version_config.jspf"  %>

					        <span style="font-size:12px">JSP Ruleset </span>
					        <select id="jspRuleOptions">
					            <!--<option value="1">1</option>-->
					        </select><br>
					        
					        <span style="font-size:12px">Submitter </span>
				    		<select id="submitterRoleIds" multiple></select><br>
				    		
				    		<span style="font-size:12px">Submittable by applicant </span>
				    		<input type="checkbox" id="submittableByApplicant"><br>
				    		
				    		<span style="font-size:12px">Wait Message </span>
				    		
				    		<%-- <liferay-ui:input-editor toolbarSet="simple" />
				    		<input name="<portlet:namespace />waitMsg" id="waitMessage" type="hidden" value="" /> --%>
				
							<textarea id="waitMessage" style="font-size:12px" cols="50" rows="10" required="required" placeholder="Enter message"></textarea><br />
					    
				
				
				
			 <input id='addDataMapSectionJspBtnId' onclick="showDataMapSectionJsp();" type="button" value="Add Data Map Section" />
				
					<div id="dataMapJspId" style="display: none;">
						<span style="font-size:12px">Datamap </span>
						<div class = "dataMapSectionJsp" style="float: left; width: 100%; border-bottom:1px solid #d9dce3;">
						
	           				<form id="dataMapFormId">
	           			
			    				<input id="jspDataMapOptions" placeholder="Enter field value" style="width: 30%;" type="text">	
								<input id="jspDataMapTextField" placeholder="Enter data map text" style="width: 50%;" type="text">		
													
								<div style="float: right; margin-top: 15px;">
									<input onclick="removeFormPopupRowsHelper(this, 'dataMapSectionJsp', 'dataMapJspId');" type="button" value=" - " />
									<input onclick="addPopupRowsJsp(this, 'dataMapSectionJsp');" type="button" value="+" />
	     						</div>	
	   							
	      					</form>
	     				</div>
					</div>
					
					<input id='addRuleSectionJspBtnId' onclick="showRuleSectionJsp();" type="button" value="Add Edit Section" />
					     
					      <div id="ruleJspId" style="display: none;" >
							<span style="margin-top: 10px;float: left;font-size:12px;">Edit Options </span>
					
							<div class = "ruleSection" style="float: left; width: 100%; border-bottom:1px solid #d9dce3;">
						
	      	     			<div>
	      
	     					
	           				<div style="font-size:12px;margin-top: 10px;float: left;">Editable By </div>
	           				<div style="float: right;">
								<input onclick="removeFormPopupRowsHelper(this, 'ruleSection', 'ruleId');" type="button" value=" - " />
								<input onclick="addPopupRowsJsp(this, 'ruleSection');" type="button" value="+" />
	     					</div>
	     					
	     					
	     					
	           				<select id="editableByRoles" multiple></select><br>
	           				
	           				<div style="font-size:12px;margin-top: 10px;float: left;">Editable Condition </div>
	           				<div style="width: 438px;height: 200px;border: solid 1px #d9dce3;border-radius: 3px;margin-top: 30px;padding: 10px;margin-bottom: 10px;">
	           				<select id="stepId">
	           				</select>
	           				<select id="editableSteps" multiple></select>
							</div>
	      				</div>
	     			</div>
					    </div>
					    
			</div>
			
			
			
	
			<!-- The mail Modal -->
			<div class="modal modalform" id="mail_model_popup">
			    <div class="modal-content">
			        <div class="modal-header">
			            <span class="close">x</span>
			            <h2>Configure Mail Component</h2>
			        </div>
			        
					<div style="overflow: auto;">
						<!-- <div class="modal-body">
			            	<input id = 'toEmailIds' type="text" name="email" placeholder="Enter your email id">
			        	</div> -->
	
				        <!-- <div class="modal-body">
				            <select multiple size="5" id="mailComponentRoleOptions"></select>
				        </div> -->
				        
				        <div class="modal-body" id="mailComponent">
				        	<%@ include file="/html/pb/fragments/reprocess_config.jspf"  %>
							<%@ include file="/html/pb/fragments/mail_config.jspf"  %>
				        </div>			      
					</div>	
					<CENTER>
						<input type="submit" id="btnModelSave" value="Save">	 
						<input type="submit" id="btnModelCancel" value="Cancel">
					</CENTER>    
			    </div>
			</div>
	
			<!-- The Message Modal -->
			<div class="modal" id="message_model_popup">
			    <div class="modal-content">
			        <div class="modal-header">
			            <span class="close">x</span>
			            <h2>Configure Message Component</h2>
			        </div>
			        <div class="modal-body">
			        	<%@ include file="/html/pb/fragments/reprocess_config.jspf"  %>
			            <textarea id="messgeInputId" cols="50" rows="10" required="required" placeholder="Enter message"></textarea><br />
			            <input type="submit" id="btnModelCancel" value="Cancel">
			            <input type="submit" id="btnModelSave" value="Save">
			        </div>
			    </div>
			</div>
			
			
			<!-- The custom action Modal -->
			<div class="modal modalform" id="customAction_model_popup">
			    <div class="modal-content">
			        <div class="modal-header">
			            <span class="close">x</span>
			            <h2>Configure Custom Action Component</h2>
			        </div>
			        
					<div style="max-height: 300px; overflow: auto;">
				        
				        <div class="modal-body">
				        	<%@ include file="/html/pb/fragments/reprocess_config.jspf"  %>
				        	<span style="font-size:12px">Title</span>
				            <select id="customActionTitleOptions"></select><br>
				            <span style="font-size:12px">Configuration</span>
				            <textarea id="configurationText" name="messageInput" cols="50" rows="10" required="required" placeholder="Enter configuration details"></textarea><br />   
				            <input type="submit" id="btnModelSave" value="Save">	 
							<input type="submit" id="btnModelCancel" value="Cancel">         
				        </div>			      
					</div>	  
			    </div>
			</div>
	
			<!-- The Status Modal -->
			<div class="modal" id="status_model_popup">
			    <div class="modal-content">
			        <div class="modal-header">
			            <span class="close">x</span>
			            <h2>Configure Status Component</h2>
			        </div>
			        <div style="max-height: 250px; overflow: auto;">
				        <div class="modal-body">
				        	<%@ include file="/html/pb/fragments/reprocess_config.jspf"  %>
				        	<span style="font-size:12px">Status Type</span>
				            <select id="statusDropDownOptions">
				            </select><br>
		
				            <span style="font-size:12px">Status</span>
				            <select id="statusOptions">
				            	<option value="Started">Started</option>
				            	<option value="InProgress">InProgress</option>
				             	<option value="Approved">Approved</option>
				                <option value="Pending">Pending</option>
				                <option value="Rejected">Rejected</option>
				                <option value="Offline">Offline</option>
				                <option value="Refunded">Refunded</option>
				            </select><br>
				            
				            <span style="font-size:12px">Approver</span>
				            <select id="approverDropDownOptions" multiple></select><br>
				            
				            <div id="mailTemplateDiv">
					            <span style="font-size:12px">Approver Notification Mail Template</span>
					            <select id="emailTemplateDropDownOptions" ></select><br>
				            </div>
				        </div>
				      </div>
				      <CENTER>
					       <input type="submit" id="btnModelCancel" value="Cancel">
					       <input type="submit" id="btnModelSave" value="Save">
				       </CENTER>
				</div>
			</div>
	
			<!-- The Create Account Modal -->
			<div class="modal" id="account_model_popup">
			    <div class="modal-content">
			        <div class="modal-header">
			            <span class="close">x</span>
			            <h2>Configure Create Account Component</h2>
			        </div>
	
			        <div class="modal-body">
			        	<%@ include file="/html/pb/fragments/reprocess_config.jspf"  %>
			        	<span style="font-size:12px">Mail Template</span>
			            <select id="mailTemplateOptions"></select><br>
			            
			            <span style="font-size:12px">Account Status</span>
				            <select id="accountStatusOptions">
				            	<option value="0">Active</option>
				             	<option value="<%= WorkflowConstants.STATUS_INACTIVE %>">InActive</option>
				        	</select><br>
				        	
				         <span style="font-size:12px">Email Address Verified</span>
				            <select id="emailAddressVerifiedOptions">
				            	<option value="1">Yes</option>
				            	<option value="0">No</option>
				        	</select><br>
				        	
				        <input type="submit" id="btnModelCancel" value="Cancel">
			            <input type="submit" id="btnModelSave" value="Save">
			            
			        </div>
			    </div>
			</div>
	
			<!-- The Timer Modal -->
			<div id="timer_model_popup" class="modal modalform" >
			    <div class="modal-content" style="overflow: auto;">
			        <div class="modal-header">
			            <span class="close">x</span>
			            <h2>Configure Timer Component</h2>
			        </div>
			        
					<div style="overflow: auto;">
						<div class="modal-body" id="timerComponent">
				        	<%@ include file="/html/pb/fragments/reprocess_config.jspf"  %>
				        	<span style="font-size:12px">Execute Only Once</span>
							<input type="checkbox" id="execOnceCB"><br/>
				        	<span style="font-size:12px">Check Execution </span>
				        	<div id='cronSchedule'></div>
				        	<span style="font-size:12px">Execute Only When Specified Rule Is Satisfied </span>
				        	<select id="timerRuleSetId">
			        		</select><br />
				        	<span style="font-size:12px">Job Listener Class </span>
				        	<select id="jobListener">
			        		</select><br />
							<%@ include file="/html/pb/fragments/mail_config.jspf"  %>
						</div>
					</div>	
					<CENTER>
						<input type="submit" id="btnModelSave" value="Save">	 
						<input type="submit" id="btnModelCancel" value="Cancel">
					</CENTER>    
			    </div>
			</div>
        </div>
        
        <!-- The Preview Modal -->
			 <div class="modal" id="preview_model_popup">
				<div class="modal-content">
				    <div class="modal-header">
				        <span class="close">x</span>
				        <h2>Configure Preview Component</h2>
				    </div>
				    <CENTER class="modal-submit">
				    	<input type="submit" id="btnModelCancel" value="Cancel">
				        <input type="submit" id="btnModelSave" value="Save">
				    </CENTER>
				</div>
			</div>
			
			<div id="preview_model_popup_skelton" class="modal-body modal-hidden" style="max-height: 300px; overflow: auto;">
								        
	    		<%@ include file="/html/pb/fragments/reprocess_config.jspf"  %>
	    		
  				<span style="font-size:12px">Preview </span>			    
				<select id="previewOptions">
		        </select><br />
		        
		        <div id="customOptionsDiv">
		        <span style="font-size:12px">Custom Implementation </span>			    
				<select id="customOptions">
		        </select><br />
		        </div>
		        			    
  				<span style="font-size:12px">Data Mapping </span><br/>
			   
  				<span style="font-size:12px">Enable Preview </span>
			    <input type="checkbox" id="enablePreviewField" ><br/>
			    
			    <span style="font-size:12px">Enable Esign </span>
			    <input type="checkbox" id="enableEsignField" ><br/>
				
				<div id="esignDiv">	    
  				<span style="font-size:12px">Esign Api Key </span>
			    <input type="text" id="esignApiKeyTxtField" placeholder="Enter the Esign Api Key">
			    
  				<span style="font-size:12px">Esign Api Url </span>
			    <input type="text" id="esignApiUrlTxtField" placeholder="Enter the Esign Api URL" >
			    </div>
  				
  				<span style="font-size:12px">Preview JSP Node Number </span>
			    <input type="text" id="previewJspNodeTxtField" placeholder="Enter the JSP node number for preview" >
			    
				    
			</div>
			
			

			<!-- The Payment Modal -->
			 <div class="modal" id="payment_model_popup">
				<div class="modal-content">
				    <div class="modal-header">
				        <span class="close">x</span>
				        <h2>Configure Payment Component</h2>
				    </div>
				    <CENTER class="modal-submit">
				    	<input type="submit" id="btnModelCancel" value="Cancel">
				        <input type="submit" id="btnModelSave" value="Save">
				    </CENTER>
				</div>
			</div>
			
			<div id="payment_model_popup_skelton" class="modal-body modal-hidden" style="max-height: 300px; overflow: auto;">
				<%@ include file="/html/pb/fragments/reprocess_config.jspf"  %>				        
	    		<span style="font-size:12px">Custom Name </span>
	    		<input type="text" id="customNameTxtField" placeholder="Enter Name">
	    		
  				<span style="font-size:12px">Provider </span>
<!-- 			    <input type="text" id="providerTxtField" placeholder="Enter Provider" value="stripe"> -->
				<select id="providerLOV">
		        </select><br />
		        			    
  				<span style="font-size:12px">Pay Currency </span>
			    <input type="text" id="payCcyTxtField" placeholder="Enter Payment Currency data mapping" value="sgd">
			    
  				<span style="font-size:12px">Pay Amount </span>
			    <input type="text" id="payAmountTxtField" placeholder="Enter Amount data mapping" >
			    
  				<span style="font-size:12px">Pay Description </span>
			    <input type="text" id="payDescTxtField" placeholder="Enter Payment Description data mapping">
			    
  				<span style="font-size:12px">Site Name </span>
			    <input type="text" id="siteNameTxtField" placeholder="Enter Site name" >
			    
  				<span style="font-size:12px">Site Logo </span>
			    <input type="text" id="siteLogoTxtField" placeholder="Enter site logo" >
			    
			    <span style="font-size:12px">Enable Payment cancel </span>
	    		<input type="checkbox" id="paymentCancelTxtField"><br/>
			    				    	
			    <span style="font-size:12px">Enable Payment Refund </span>
	    		<input type="checkbox" id="paymentRefundTxtField"><br/>
			    				    	
		        <span style="font-size:12px">Payment Ruleset </span>
		        <select id="paymentRuleOptions">
		        </select><br />

  				<span style="font-size:12px;display:none; ">Pay Item Class Name </span>
			    <input style="display:none;" type="text" id="payItemClassNameTxtField" placeholder="Enter pay item classname" >
			    				    	
  				<span style="font-size:12px;display:none;">Pay Item Class PK </span>
			    <input style="display:none;" type="text" id="payItemClassPkTxtField" placeholder="Enter pay item class pk data mapping" >
			    				    	
	    		<span style="font-size:12px">Wait Message </span>	    		
				<textarea id="waitMessage" style="font-size:12px" cols="50" rows="10" required="required" placeholder="Enter message"></textarea><br />
			
	    		<span style="font-size:12px">Paid Message </span>	    		
				<textarea id="paidMessage" style="font-size:12px" cols="50" rows="10" required="required" placeholder="Enter message"></textarea><br />
			
	    		<span style="font-size:12px">Refunded Message </span>	    		
				<textarea id="refundedMessage" style="font-size:12px" cols="50" rows="10" required="required" placeholder="Enter message"></textarea><br />
			
			 	<input id='addDataMapSectionPaymentBtnId' onclick="showDataMapSectionPayment();" type="button" value="Add Data Map Section" />
				
				<div id="dataMapPaymentId" style="display: none;">
					<span style="font-size:12px">Metadata Map </span>
					<div class = "dataMapSectionPayment" style="float: left; width: 100%; border-bottom:1px solid #d9dce3;">
					
           				<form id="dataMapFormId">
           			
		    				<input id="paymentDataMapOptions" placeholder="Enter field value" style="width: 30%;" type="text">	
							<input id="paymentDataMapTextField" placeholder="Enter data map text" style="width: 50%;" type="text">		
												
							<div style="float: right; margin-top: 15px;">
								<input onclick="removeFormPopupRowsHelper(this, 'dataMapSectionPayment', 'dataMapPaymentId');" type="button" value=" - " />
								<input onclick="addPopupRowsPayment(this, 'dataMapSectionPayment');" type="button" value="+" />
     						</div>	
   							
      					</form>
     				</div>
				</div>
				    
			</div>
			</div></div>
			

		<script type="text/javascript">		
		    var defaultPaidMessage = "<%=PaymentProvider.DEFAULT_PAID_MESSAGE%>";
		    var defaultRefundedMessage = "<%=PaymentProvider.DEFAULT_REFUNDED_MESSAGE%>";
		    var defaultEsignApiKey = "<%=SambaashUtil.getParameter("esign.api.key",0)%>";
		    var defaultEsignApiUrl = "<%=SambaashUtil.getParameter("esign.api.url",0)%>";
		    var dwNameSpace = "<portlet:namespace />";
		    
			YUI().use(
				  'aui-tooltip',
				  function(Y) {
				    new Y.TooltipDelegate(
				      {
				        trigger: '.drop-frame',
				        cssClass: 'tooltip-help',
				        position: 'top'
				      }
				    );
				  }
			);
			
		    function saveDesignerWizard(saveType){

		    	//iterate through node groups
		    	rootNodeStructure = {};
		    	rootNodeStructure.nodeGroups = [];
		    	loggedNodeIds = [];
		    	for(var ind=0; ind<nodeGroupComponents.length; ind++){
		    		var nodeGroup = {};
		    		nodeGroup.groupId = nodeGroupComponents[ind];
		    		
		    		nodeStructure = {};
		    		traverse($('#'+nodeGroupComponents[ind]), nodeStructure);
		    		nodeGroup.nodeStructure = nodeStructure;
		    		if(rootNodeStructure.nodeGroups.length == 0){
		    			rootNodeStructure.nodeGroups.push(nodeGroup);
		    		}
		    		
		    	}
		    
		        //don't publish if diagram has disconnected nodes
		        if(saveType==='publish' && rootNodeStructure.nodeGroups.length>1){
		        	alert('This diagram has disconnected nodes !!');
		        	return;
		        }
		        	
		      //push to peprocess db.
		        AUI().use('aui.io.request', function(A) {A.io.request('${saveProcessURL}', {
		        		method : 'post',
		  				data : {
		  						 <portlet:namespace />operationType : saveType,
		  						 <portlet:namespace />processId : processID,
		  						 <portlet:namespace />nodeSkelton : JSON.stringify(rootNodeStructure),
		  				},
	    				on : {
	    					success : function(){
	    						alert('Digram is saved successfully---');
	    						loggedNodeIds = [];
	    					}
		  				}
	   				});
	  			});
		    }

		    function retrieveDesignerWizard() {
		        AUI().use('aui.io.request', function(A) {A.io.request('${retriveNodeInfoURL}', {
		        		method : 'get',
		  				data : {
		  						 <portlet:namespace />processId : processID,
		  				},
	    				on : {
	    					success : function() {

	    						var nodeStructureString = JSON.parse(this.get('responseData')).processDefinition;	    						
	    						if (nodeStructureString == "" || nodeStructureString == "{}")
	    							return;	    							

	    						rootNodeStructure = JSON.parse(nodeStructureString);
	    						loggedNodeIds = [];
	    						if(!rootNodeStructure.nodeGroups)
	    							return ;
	    						
	    						var nodeGroups = rootNodeStructure.nodeGroups;
	    						
	    						for(var idx=0;idx<nodeGroups.length;idx++){
	    							if(idx>0){
	    								rootElmntDropFrame = rootElmntDropFrame.cloneNode(false);
	    								document.body.appendChild(rootElmntDropFrame);
	    								
	    								addDragDropListner(rootElmntDropFrame);
	    								//Right-Click event handler
	    								document.getElementById(rootElmntDropFrame.id).addEventListener("contextmenu", function(){rightClickEventHandler(rootElmntDropFrame.id);});

	    							}	
									reDrawDesignerWizard(nodeGroups[idx].nodeStructure);
	    						}
	    						
	    					}	    					
		  				}
	   				});
	  			});
		    }

	    	function loadJSONArrForDropDown(componentType, self) {
				var ajaxUrlMap = {
						"entity": ["${getPKsURL}"],
						"pricing": ["${getPriceSubSchemesURL}"]
				};
				
		        AUI().use('aui.io.request', function(A) {A.io.request('${retriveModelPopupDropDownListURL}', {
		        		method : 'get',
		  				data : {
		  						 <portlet:namespace />componentType : componentType,
		  				},
	    				on : {
	    					success : function() {
	    						var data = this.get('responseData');
	    						console.log(data);
	    						dropDownOptionsJSONArr = JSON.parse(data).model_popup_dropdown_json;

	    						//call a method which will populate the drop-down list...
	    						if (ajaxUrlMap.hasOwnProperty(componentType)) {
	    							displayModelPopup(componentType + '_model_popup', self, ajaxUrlMap[componentType]); 
	    						} else {
		    						displayModelPopup(componentType + '_model_popup', self);   							
	    						}
	    					}
		  				}
	   				});
	  			});
		    }

	    	var dataMapOptionList = null;
	        function populateDataMapSection(componentId, self, modal) {
	        	
	        	// rest call to FormBuilderServiceImpl
	        	Liferay.Service(
	  				  '/SPProcessEngine-portlet.formbuilder/get-form-schema',
	  				  {
	  				    userId: Liferay.ThemeDisplay.getUserId(),
	  				    formId: componentId
	  				  },
	  				  function(obj) {
	  				    console.log(obj);
	  				    dataMapOptionList =  JSON.parse(obj);
	  				  	addFormDataMapSection(dataMapOptionList, self, modal);
	  				  }
	  				);
	            }

	        function setRuleSetId(form_id, self) {

	        	 AUI().use('aui.io.request', function(A) {
	        	  A.io.request('${retriveRuleSetIdURL}', {method : 'post', data : {<portlet:namespace />formID : form_id},

	        	   on : {
	        	     	success : function() {
	        	     		var rulesetId = "-1";
	        	     		if(JSON.parse(this.get('responseData'))){
	        	     			rulesetId = JSON.parse(this.get('responseData')).ruleSetId || "-1"
	        	     		}
		        	     	console.log("rulesetId : " + rulesetId);
		        	     	self.data("rulesetId", rulesetId);
	        	     }
	        	   }
	        	   });
	        	  });
	        	}

	        var resultEmailVerification = null;
	        function validateEmailAddress(emailInputNode){
	        	
	        	AUI().use('aui.io.request', function(A) {A.io.request('${validateEmailAddressURL}', {
			        		method : 'get',
			        		sync : true,
			  				data : {
			  					<portlet:namespace />emailAddress : emailInputNode.value,
			  				},
		    				on : {
		    					success : function() {
		    						var data = this.get('responseData');
		    						resultEmailVerification = JSON.parse(data).result;
		    						getResult(resultEmailVerification);
		    					}
			  				}
		   				});
		  			});
			  
	        }
	       
	       //invokes CKeditor 
	       function <portlet:namespace />initEditor() {
	    	    console.log("html:....."+htmlContent);
                return htmlContent!="" ? htmlContent:"";
           }

           function extractCodeFromEditor() {
                var htmlContent=document.getElementById('waitMessage').value = window.<portlet:namespace />editor.getHTML();
           		return htmlContent;
           }
           
           var userJSON = <%=ProcessBuilderHelper.loadUsers()%>;
        		AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated','autocomplete-list','aui-io-request','autocomplete-filters','autocomplete-highlighters', function(A) {
        			if(userJSON) {
        				new A.AutoCompleteList(
        			      {
        			    	allowBrowserAutocomplete: false,
        			        inputNode: '.ccEmailAddressText',
        			        activateFirstItem: true,
        			        source: userJSON,
        			        resultTextLocator: 'code',
        			        resultHighlighter: 'phraseMatch',
        			        resultFilters: 'phraseMatch',
        			        minQueryLength : 1,
        			        width: 440,
        			        after: {
                                select: function (event) {
                                	document.getElementById("mailComponent").scrollTop=0;
                                	document.getElementById("mailComponent").style.overflow = 'hidden';
                                }
                            },
        			        render: 'true'
        			      }
        			    ).render();
        				
        			}
        		});
        	
           
	    </script>
	    
		
	    <script src="/SPProcessEngine-portlet/js/pb/designwizard-ui.js?t=<%=DateUtil.newTime() %>"></script>
	    <script src="/SPProcessEngine-portlet/js/pb/designwizard-ui-formv2.js?t=<%=DateUtil.newTime() %>"></script>
		<script src="/SPProcessEngine-portlet/js/pb/designwizard-ui-api.js?t=<%=DateUtil.newTime() %>"></script>
		<script src="/SPProcessEngine-portlet/js/pb/designwizard-ui-pricing.js?t=<%=DateUtil.newTime() %>"></script>
		<script src="/SPProcessEngine-portlet/js/pb/designwizard-ui-entity.js?t=<%=DateUtil.newTime() %>"></script>

		<style>
		.aui .dockbar-ready .main-content.rightSide.admin {
		    margin-top: -91px;
		}
		</style>
		
	</body>

</html>
