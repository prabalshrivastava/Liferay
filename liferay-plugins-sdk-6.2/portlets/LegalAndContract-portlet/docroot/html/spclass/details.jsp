<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<div class="form_details form_details_desktop">
	<span class="form_Title">Class Details</span>
	<table>
	  <tr><td>Class Code</td><td>${classMaster.code }</td></tr>
	  <tr><td>Country</td><td>${classMaster.country }</td></tr>
	  <tr><td>Version</td><td>${classMaster.version }</td></tr>
	  <tr><td>Class Description</td><td>${classMaster.description }</td></tr>
	  <tr><td> Filed By</td><td>${classMaster.filedBy }</td></tr>
	</table>
	<table>
	  <tr><td>Custom Field 1</td><td>${classMaster.customField1 }</td></tr>
	  <tr><td>Custom Field 2</td><td>${classMaster.customField2 }</td></tr>
	  <tr><td>Custom Date 1</td><td>${classMaster.customDate1 }</td></tr>
	  <tr><td>Custom Date 2</td><td>${classMaster.customDate2 }</td></tr>
	  <tr><td>Custom List 1</td><td>${classMaster.customList1 }</td></tr>
	  <tr><td>Custom List 2</td><td>${classMaster.customList2 }</td></tr>
	</table>
</div>

<div class="form_details form_details_mobile">
	<span class="form_Title">Class Details</span>
	<table>
	  <tr><td>Class Code</td><td>${classMaster.code }</td></tr>
	  <tr><td>Country</td><td>${classMaster.country }</td></tr>
	  <tr><td>Version</td><td>${classMaster.version }</td></tr>
	  <tr><td>Class Description</td><td>${classMaster.description }</td></tr>
	  <tr><td> Filed By</td><td>${classMaster.filedBy }</td></tr>
	
	  <tr><td>Custom Field 1</td><td>${classMaster.customField1 }</td></tr>
	  <tr><td>Custom Field 2</td><td>${classMaster.customField2 }</td></tr>
	  <tr><td>Custom Date 1</td><td>${classMaster.customDate1 }</td></tr>
	  <tr><td>Custom Date 2</td><td>${classMaster.customDate2 }</td></tr>
	  <tr><td>Custom List 1</td><td>${classMaster.customList1 }</td></tr>
	  <tr><td>Custom List 2</td><td>${classMaster.customList2 }</td></tr>
	</table>
</div>