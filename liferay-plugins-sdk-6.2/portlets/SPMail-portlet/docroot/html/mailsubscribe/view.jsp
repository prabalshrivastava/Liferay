<%@ include file="/html/common/init.jsp" %>
<%
		long campaignId = GetterUtil.getLong(portletPreferences.getValue("campaignId", "0"));
String campaignName = "";
try{
SPMailCampaign campaign = SPMailCampaignLocalServiceUtil.fetchSPMailCampaign(campaignId);
campaignName = campaign.getCampaignName();
}catch(Exception e){
	
}
		boolean displayFn = GetterUtil.getBoolean(portletPreferences.getValue("displayFn", ""));
		boolean displayLn = GetterUtil.getBoolean(portletPreferences.getValue("displayLn", ""));
	%>
	<c:if test="<%= displayFn %>">
	<div class="subscribeFormWrap">
	<%if(campaignName != ""){ %>
	<div class="campaignNameDisplay">Subscribe to : <%=campaignName%></div>
	<%} %>
	</c:if>
<aui:form cssClass="subscribeForm">
	<c:if test="<%= displayFn %>">
		<aui:input label="first-name" name="firstName" type="text" ></aui:input>
	</c:if>
	<c:if test="<%= displayLn %>">
		<aui:input label="last-name" name="lasttName" type="text" ></aui:input>
	</c:if>
	<aui:input label="email-address" name="emailAddress" type="text" cssClass="subscribeInput" >
		<aui:validator name="email"/>
	</aui:input>

	<a type="button" href="#<portlet:namespace/>subscribePopup1" id="<portlet:namespace/>subscribeButton">Subscribe</a>

</aui:form>

<c:if test="<%= displayFn %>">
	</div>
	</c:if>

<%-- <% if (displayFn){ %>
<style type="text/css">
.subscribeFormWrap .subscribeForm .control-group{
display:block;
}

.subscribeFormWrap .subscribeForm{
padding:40px!important;
border:1px solid #ccc;
width:50%;
margin:0 auto!important;
text-align:center!important;
}

.subscribeFormWrap .subscribeForm label {
    display: block!important;
    text-align:left;
}

#_mailsubscribe_WAR_SPMailportlet_INSTANCE_p1Yy152Pfh5b_fm {
    display: block!important;
    margin-top: 0px!important;
}

.subscribeFormWrap .subscribeForm a {
    padding: 10px 15px;
background: #d63c32;
border: 1px solid #d63c32;
color: #ffffff;
}

</style> 
<% } %>--%>

<style type="text/css">

#<portlet:namespace/>fm
{
	
    display: flex;
    flex-direction: row;
    margin-top: 0px;
   
}
#<portlet:namespace/>subscribeButton
{
	    
    padding: 5px;
   
    /* margin-top: 25px; */
}

</style>

<liferay-portlet:resourceURL id="ajax" var="ajaxUrl">
	<% if (displayFn){ %>
	<liferay-portlet:param  name="action"  value="subscribeToEmail"/>
	<%}else{ %>
	<liferay-portlet:param  name="action"  value="subscribe"/>
	<%} %>
</liferay-portlet:resourceURL>
<script>

AUI().use('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',function(A) {
	var pns  ="<portlet:namespace/>";
	var ajaxUrl = "<%= ajaxUrl %>";
	var b = A.one('#' + pns + 'subscribeButton');
	if(!b) return;
	b.on("click",function(){
		// TODO: validate email
		var data = {};
		data["firstName"] =  getVal("firstName");
		data["lastName"] =  getVal("firstName");
		data["emailAddress"] =  getVal("emailAddress");
		
		A.io.request(ajaxUrl,{
			dataType: 'json',
			method: 'POST',
			data: data,
			on: {
			success: function() {
				var data=this.get('responseData');
				var subscribePopupTitle = A.one('#' + pns + 'subscTitle');
				var subscribePopupDataMessage = A.one('#' + pns + 'subscribePopupContent');
				
				if (data) {
					if (data.error) {

                         subscribePopupTitle.html('Sorry');
						 subscribePopupDataMessage.html('Error: ' + data.error);
					}else {
						setVal("emailAddress","");
						/*alert("Subscribed.");*/
						subscribePopupTitle.html('Thank You For Subscribing!');
						subscribePopupDataMessage.html('You have been added to our mailing list and will now be among the first to hear about our latest updates and upcoming events');

					}
				}else {
					//handle due to some reason data is null
					/*alert("Can not subscribe at this moment.");*/
					    subscribePopupTitle.html('Sorry');
						subscribePopupDataMessage.html('Can not subscribe at this moment.');
				}
			  },
		    failure : function() {
					/*alert("Can not subscribe at this moment.");*/
					    subscribePopupTitle.html('Sorry');
						subscribePopupDataMessage.html('Can not subscribe at this moment.');

		    }
			}
		});
	});
	
	var getVal = function(id){
		var node = A.one("#" + pns + id);
		if(node){
			return node.val();
		}
		return "";
	}
	var setVal = function(id,value){
		var node = A.one("#" + pns + id);
		if(node){
			node.val(value);
		}
	}
});
</script>

<div id="<portlet:namespace/>subscribePopup1" class="subscribeOverlay">
	<div class="subscribePopup">
		<h2 id="<portlet:namespace/>subscTitle"></h2>
		<a class="subscribeClose" href="#">&times;</a>
		<div class="content" id="<portlet:namespace/>subscribePopupContent">
			
		</div>
	</div>
</div>
