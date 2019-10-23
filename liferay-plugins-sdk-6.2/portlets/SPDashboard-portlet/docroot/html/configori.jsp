
<%@page import="javax.portlet.PortletPreferences"%>
<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@page import="java.util.*"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.sambaash.platform.spdashboard.JsonUtil" %>

<style>
  .div_hidden { 
       visibility:hidden;
       display:none;
   }
  .div_visible {
       visibility:visible;
        display:block;
   }
   
   .add-btn{
   		content:'+';
   		font-size:10px;
   		font-color:green;
   }
   
   .rem-btn{
   		content:'-';
   		font-size:10px;
   		font-color:red;
   } 
   
    .form-el{
 		margin-left:5px;
 		display:inline;
 		float:left;
 	}
 	
 	.form-row{
 		display:inline-block;
 	}
 	
 	.form-child-row{
 		display:inline-block;
 		margin-left:30px;
 	}
 	
 	.form-child-child-row{
 		margin-left:10px;
 	}
 	
 	.form-child-child-child-row{
 		margin-left:10px;
 	}
</style>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%=configurationURL %>" method="post" name="fm" >
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" ></aui:input> 
	<div class="" style="float:right">
		<aui:button class="add-btn" type="button" value="+" onclick="addNewRow();"></aui:button>
	</div>
	<div class="input-container" >
	<%		
		List<Role> userRoles=RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId());
		request.setAttribute("userRoles", userRoles);
		Map<String,String[]> mapEntries=portletPreferences.getMap();
		if(!mapEntries.isEmpty()){
			JSONObject mapJson=JsonUtil.generateJSON(mapEntries);
			Iterator jsonIter=mapJson.keys();
			request.setAttribute("jsonIter", jsonIter);
			%>
				<c:forEach begin="0" end="${mapJson.length()-1}" var="index">
					${mapJson.getJSONObject(index).getString("label")}
				</c:forEach>
			<% 
			while(jsonIter.hasNext()){
				String currRow=jsonIter.next().toString();
				JSONObject row=mapJson.getJSONObject(currRow);
				%>
					<div class="form-row row-line" id="row-1">
						<div class="form-el">
							<aui:input class="input-small" label="" name="preferences--label_row-1--" type="text" value="<%=row.get(\"label\")%>" placeholder="Label"></aui:input>
						</div>
						
						<div class="form-el">
							<aui:input class="input-small" label="" name="preferences--url_row-1--" type="text" value="<%=row.get(\"url\")%>" placeholder="URL"></aui:input>
						</div>
						
						<div class="form-el">
							<aui:select label="" name="preferences--portlet_row-1--" class="span1">
								<aui:option selected="true">Portlets</aui:option>
								<aui:option value="Portlet1">Portlet1</aui:option>
								<aui:option value="Portlet2">Portlet2</aui:option>
							</aui:select>
						</div>
						
						<div class="form-el">
							<aui:select label="" name="preferences--role_row-1--" multiple="true">
								<aui:option value="" disabled="true">Select roles</aui:option>
								<c:forEach var="role" items="${userRoles}">
									<aui:option value="${role.getName()}">${role.getName()}</aui:option>
								</c:forEach>
							</aui:select>
						</div>
						
						<div class="form-el">
							<aui:input label="" type="file" name="preferences--icon_row-1--" style="width:80px"></aui:input>
						</div>
						
						<div class="form-el">
							<aui:button id="btn-row-1" class="add-btn" value="+" type="button"  onclick="addNewChildRow(this);"></aui:button>
							<aui:button class="rem-btn" value="-" type="button"  onclick="removeRow(this);"></aui:button>
						</div>
						
						<div class="child-container">
							<%
								
							
							%>
						</div>
					</div>	
				
				<%		
			}
		}
		else{
			%>
				<div class="form-row row-line" id="row-1">
					<div class="form-el">
						<aui:input class="input-small" label="" name="preferences--label_row-1--" type="text" placeholder="Label"></aui:input>
					</div>
					
					<div class="form-el">
						<aui:input class="input-small" label="" name="preferences--url_row-1--" type="text" placeholder="URL"></aui:input>
					</div>
					
					<div class="form-el">
						<aui:select label="" name="preferences--portlet_row-1--" class="span1">
							<aui:option selected="true">Portlets</aui:option>
							<aui:option value="Portlet1">Portlet1</aui:option>
							<aui:option value="Portlet2">Portlet2</aui:option>
						</aui:select>
					</div>
					
					<div class="form-el">
						<aui:select label="" name="preferences--role_row-1--" multiple="true">
							<aui:option value="" disabled="true">Select roles</aui:option>
							<c:forEach var="role" items="${userRoles}">
								<aui:option value="${role.getName()}">${role.getName()}</aui:option>
							</c:forEach>
						</aui:select>
					</div>
					
					<div class="form-el">
						<aui:input label="" type="file" name="preferences--icon_row-1--" style="width:80px"></aui:input>
					</div>
					
					<div class="form-el">
						<aui:button id="btn-row-1" class="add-btn" value="+" type="button"  onclick="addNewChildRow(this);"></aui:button>
						<aui:button class="rem-btn" value="-" type="button"  onclick="removeRow(this);"></aui:button>
					</div>
					
					<div class="child-container">
						
					</div>
				</div>
				
			<%
			
		}	
	%>

		
	</div>
	
	<div style="float:right;">
		<aui:button type="submit" value="Save"></aui:button>
	</div>
	

</aui:form>

<div class="form-child-row row-line div_hidden dummy-div" id="row-1" >
	<div class="form-el"><aui:input class="input-small" label="" name="preferences--cfglabel_row-1--" type="text" placeholder="Label"></aui:input></div>
	<div class="form-el"><aui:input class="input-small" label="" type="text" name="preferences--cfgurl_row-1--" placeholder="URL"></aui:input></div>
	<div class="form-el">
		<aui:select label="" name="preferences--cfgtype_row-1--" >
			<aui:option selected="true">Type</aui:option>
			<aui:option value="Chart">Chart</aui:option>
			<aui:option value="Numeric">Numeric</aui:option>
		</aui:select>
	</div>
	<div class="form-el">
		<aui:select label="" name="preferences--cfganalytics_row-1--" >
			<aui:option selected="true">Analytics</aui:option>
			<aui:option value="">val</aui:option>
			<aui:option value="">val</aui:option>
		</aui:select>
	</div>
	
	<div class="form-el">
		<aui:button class="rem-btn" value="-" type="button"  onclick="removeRow(this);"></aui:button>
	</div>
</div>


<aui:script use="aui-base,aui-node,event,node">
		
		var A=AUI();
		var rows=0;
	    Liferay.provide(
	    	window,
	    	'addNewRow',
	    	function(component){
	    		
	    		var container=A.one('.input-container');
	    		rows=A.all('.input-container .form-row').size();
	    		
	    		var newId='row-'+(rows+1);
	    		var newRow=A.one('.input-container .form-row').clone();
	    		if(newRow.all('.child-container .form-child-row').size()!=0){
	    			newRow.all('.child-container .form-child-row').each(function(){
	    				
	    			}).remove();
	    		}
	    		
	    		var htmlRow=newRow.get('outerHTML');
	    		htmlRow=htmlRow.replace(/(row-)\d/g,newId);
	    		container.append(htmlRow);
	    	},
	    	['aui-base','aui-node','event','node']
	    );
	    
	    Liferay.provide(
		    	window,
		    	'addNewChildRow',
		    	function(component){
		    		var newChildRow;
		    		var newChildId;
		    		var htmlChildRow;
		    		var childContainer;
		    		var rows; 
		    		
		    		var formRowId=A.one(component).ancestor('.form-row').get('id');
		    		
		    		if(A.one(component).ancestor('.form-row')!=null){
		    			childContainer=A.one('#'+formRowId+' .child-container');
			    		rows=A.all('#'+formRowId+' .child-container .form-child-row').size();
			    		
			    		newChildId=formRowId+'_child-'+(rows+1);
			    	
			    			
		    			newChildRow=A.one('.dummy-div').clone();
		    			newChildRow.removeClass('dummy-div');
		    			newChildRow.replaceClass('div_hidden','div_visible');
			    		htmlChildRow=newChildRow.get('outerHTML');
			    		htmlChildRow=htmlChildRow.replace(/(row-)\d/g,newChildId);
			    		childContainer.append(htmlChildRow);
		    		}
		    		
		    	
		    		
		    		
		    	},
		    	['aui-base','aui-node','event','node']
		    );
	    
	    Liferay.provide(
		    	window,
		    	'removeRow',
		    	function(component){
		    		var row=A.one(component).ancestor('.row-line');
		    		if(row!=null){
		    			if(A.all('.input-container .row-line').size()>1)
		    				row.remove();
		    		}
		    		
		    		
		    	},
		    	['aui-base','aui-node','event','node']
		    );
	    
	    
</aui:script>