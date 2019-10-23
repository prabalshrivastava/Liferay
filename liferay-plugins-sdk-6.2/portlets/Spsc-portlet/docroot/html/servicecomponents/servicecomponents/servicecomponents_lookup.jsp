<%@ include file="init.jsp" %>

<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponentGroup" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentGroupLocalServiceUtil" %>
<%@ page import="sambaash.platform.srv.servicecomponent.model.ServiceComponents" %>
<%@ page import="sambaash.platform.srv.servicecomponent.service.ServiceComponentsLocalServiceUtil" %>
<%@ page import="java.util.*" %>

<%
	int count = ServiceComponentsLocalServiceUtil.getServiceComponentsesCount();
	List<ServiceComponents> items = ServiceComponentsLocalServiceUtil.getServiceComponentses(0, count);

	PortletURL renderURL2 = renderResponse.createRenderURL();
	renderURL2.setParameter("struts_action", "/spsc/servicecomponents_action");
	renderURL2.setParameter("CMD", "sclookup");

	PortletURL renderURL3 = renderResponse.createRenderURL();
	renderURL3.setParameter("struts_action", "/spsc/servicecomponents_action");
	renderURL3.setParameter("CMD", "list");

	String strutsPath = "/spsc/servicecomponents_action";
	actionURL.setParameter("struts_action", strutsPath);
	actionURL.setParameter("CMD", "delete");

	String keywords = ParamUtil.getString(request, "keywords");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("keywords", keywords);
%>

<div id="scgtable"> Service Component </div>
<form action="<%= actionURL %>" method="post" name="<portlet:namespace/>fm">

	<liferay-ui:search-container emptyResultsMessage="Sorry. There are no items to display." iteratorURL="<%= renderURL2 %>">

		<liferay-ui:search-container-results
	 		results="<%= ListUtil.subList(items, searchContainer.getStart(), searchContainer.getEnd()) %>"
	 		total="<%= items.size() %>"
		/>
	 	<liferay-ui:search-container-row modelVar="item" className="sambaash.platform.srv.servicecomponent.model.ServiceComponents">

		 	<%
		 	String serviceIds = item.getExtra1();

		 	StringTokenizer st = new StringTokenizer(serviceIds, ",");
		 	serviceIds = "";
		while (st.hasMoreElements())
{

String token = st.nextElement().toString();

try{
//serviceIds = serviceIds+","+token+":"+ServiceComponentsLocalServiceUtil.getServiceComponents(new Long(token).longValue()).getName();
}catch(Exception e){}
}


		 plns = "changeit";
			 	String recordId = String.valueOf(item.getPrimaryKey()+"***"+serviceIds+"***"+item.getName());
			 	renderURL.setParameter("recId", recordId);
			 	String checkBox1 = "<input type='checkbox' name='<portlet:namespace />" + plns + "check' onClick='" + plns + "checkAll(this);'/>";
			 	String checkBox2 = "<input type='checkbox' id='name' name='<portlet:namespace />" + plns + "deleteItem' value='" + recordId + "' onChange='" + plns + "checkAllRev(this);' />";
		 	%>

		 	<c:if test="<%= roleId1 %>">
		 	<liferay-ui:search-container-column-text name="" value="<%= checkBox2 %>" />
	        </c:if>
			<liferay-ui:search-container-column-text name="Name" property="name" />
			<liferay-ui:search-container-column-text name="ScId" property="scId" />

	 	</liferay-ui:search-container-row>

	 	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
	</liferay-ui:search-container>

	<input type=button value="OK" onClick="sendValue();" style="margin-right:10px"><input type=button value="Cancel" onClick="window.close()">

</form>

<SCRIPT LANGUAGE="JavaScript">

var valueDetails = "";
var addData = " ";

/*function changeitcheckAllRev(_this) {
if (_this.checked) {
	window.status = _this.value;
	valueDetails = valueDetails+"&&&&&"+_this.value;
	}

}*/
function changeitcheckAllRev(_this) {
if (_this.checked) {
	window.status = _this.value;
	valueDetails = valueDetails+"&&&&&"+_this.value;
	addData = "&&&&&"+_this.value;
	}else {
		window.status = _this.value;
		valueDetails = remove(valueDetails,"&&&&&"+_this.value);
		addData = remove(addData,"&&&&&"+_this.value);
	}
	window.opener.indprepareData(addData,"addData");
}

function remove(s, t) {
	  /*
	  **  Remove all occurrences of a token in a string
	  **    s  string to be processed
	  **    t  token to be removed
	  **  returns new string
	  */
	  i = s.indexOf(t);
	  r = "";
	  if (i == -1) return s;
	  r += s.substring(0,i) + remove(s.substring(i + t.length), t);
	  return r;
}

function changeitcheckAll(obj) {
		var items = document.getElementsByName("changeitdeleteItem");
		for (var i=0; i<items.length; i++) {
			items[i].checked = obj.checked;
		}
		changeitcheckAllRev(this);
	}

function sendValue (s) {
var selvalue = valueDetails;
window.opener.indprepareData(valueDetails,"submit");
addData = " ";
window.close();
}
</SCRIPT>