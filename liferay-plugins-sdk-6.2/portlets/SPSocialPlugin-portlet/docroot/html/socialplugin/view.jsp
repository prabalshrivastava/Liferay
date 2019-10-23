<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

<script type="text/javascript">

function authorise(provider) {
	//alert(provider);
	var A=AUI();
	var items = null;
	var reqUrl = '<portlet:resourceURL id="" />';

	A.io.request(reqUrl, {
	     cache: true,
	     sync: true,
	     timeout: 1000,
	     dataType: 'json',
	     method: 'post',
	     data:{
	    	 provider:provider
	     },
	     on: {
	         success: function() {
	        	 items = this.get('responseData');
	        	 if (items) {
	        		var status = items[0].status;
	        		var message = items[0].message;

	        		//alert(status);
	        		//alert(message);

	        		if (status == 100) {
	        			window.location = message;
	        		}else if (status == 200) {
	        			//document.getElementById('displayMsg').style.display="block";
	        			document.getElementById('errorMsg').style.display="none";
	        		}else {
	        			//document.getElementById('displayMsg').style.display="none";
	        			document.getElementById('errorMsg').style.display="block";
	        		}
	        		//AUI().use(function(A) { A.one('#connect_dialog').close();});
	        	}
	         },
	         failure: function() {
	        	 alert('failed');
	         }
	     }
	 });

	return items;
}

</script>

<c:choose>
	<c:when test='<%= com.liferay.portal.kernel.servlet.SessionMessages.contains(request, "successConnect") %>'>

		<%
			String successLink = (String) com.liferay.portal.kernel.servlet.SessionMessages.get(request, "successConnect");
		%>

		<div class="portlet-msg-success">
			<%= successLink %>
		</div>
	</c:when>
	<c:when test='<%= com.liferay.portal.kernel.servlet.SessionMessages.contains(request, "errorConnect") %>'>

		<%
			String errorLinking = (String) com.liferay.portal.kernel.servlet.SessionMessages.get(request, "errorConnect");
		%>

		<div class="portlet-msg-error">
			<%= errorLinking %>
		</div>
	</c:when>
	<c:when test='<%= com.liferay.portal.kernel.servlet.SessionMessages.contains(request, "userAlreadyExists") %>'>

		<%
			String alreadyExists = (String) com.liferay.portal.kernel.servlet.SessionMessages.get(request, "userAlreadyExists");
		%>

		<div class="portlet-msg-error">
			<%= alreadyExists %>
		</div>
	</c:when>
	<c:otherwise></c:otherwise>
</c:choose>

<span class="portlet-msg-error" id="errorMsg" style="display:none;">
	<liferay-ui:message key="Error encountered during your request." />
</span>

<portlet:actionURL var="linkActionURL">
	<portlet:param name="action" value="linkActionURL"></portlet:param>
</portlet:actionURL>

<div align="center">
<ul class="social-index horizontal">
	<li>
		<div><c:out value="${link_message}" /></div>
		<div class="social-icons" id="social-connections-dashboard">
			<ul >
			<li class="facebook"><a href="#" title="Facebook" onClick="authorise('facebook')">facebook</a></li>
			<li class="twitter"><a href="#" title="Twitter" onClick="authorise('twitter')">twitter</a></li>
			<li class="linkedin"><a href="#" title="LinkedIn" onClick="authorise('linkedin')">ln</a></li>
			<li class="google"><a href="#" title="Google" onClick="authorise('google')">g</a></li>
			<li class="yahoo"><a href="#" title="Yahoo" onClick="authorise('yahoo')">y</a></li>
			<!-- <li class="openid"><a href="#" title="OpenId" onClick="authorise('openid')"></a></li> -->
			</ul>
		</div>
	</li>
</ul>
</div>