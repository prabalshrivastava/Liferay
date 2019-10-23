<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:actionURL var="displayCountryDeptPermURL" name="displayCountryDeptPerm">
</portlet:actionURL>
<portlet:actionURL var="displayPortetPermURL" name="displayPortetPerm">
</portlet:actionURL>
<portlet:actionURL var="displayPermInhertURL" name="displayPermInherit">
</portlet:actionURL>
<portlet:actionURL var="displayRoleAssignmentURL" name="displayRoleAssignment">
</portlet:actionURL>
<portlet:actionURL var="displayEsnLdapMappingSQl" name="displayEsnLdapMappingSQl">
</portlet:actionURL>
<portlet:actionURL var="displayFeeFundingBulkuploadPage" name="displayFeeFundingBulkuploadPage">
</portlet:actionURL>
<portlet:actionURL var="displaymiscFeeBulkuploadPage" name="displaymiscFeeBulkuploadPage">
</portlet:actionURL>
<portlet:actionURL var="displayCourseDetailsUploadPage" name="displayCourseDetailsUploadPage">
</portlet:actionURL>
<portlet:actionURL var="displayClosedDateUploadPage" name="displayClosedDateUploadPage">
</portlet:actionURL>
<portlet:actionURL var="displayPreCourseCounselling" name="displayPreCourseCounselling">
</portlet:actionURL>


<ol>
  <li> <a href="<%= displayCountryDeptPermURL %>">Country Department Folder Permissions</a> </li>
  <li> <a href="<%= displayPortetPermURL %>">Assign Portet Permissions to Country-Department users</a> </li>
  <li> <a href="<%= displayPermInhertURL %>">Docment Library Permissions Data Patch - Inheriting Parent Permissions to Child</a> </li>
  <li> <a href="<%= displayRoleAssignmentURL %>">Assign Roles</a> </li>
  <li> <a href="<%= displayFeeFundingBulkuploadPage %>">Use this link to bulk upload Fudning details of Course (Product App)</a> </li>
  <li> <a href="<%= displaymiscFeeBulkuploadPage %>">Use this link to bulk upload Miscelleneous Fee details of Course (Product App)</a> </li>
  <li> <a href="<%= displayCourseDetailsUploadPage %>">Use this link to bulk upload Course details (Product App)</a> </li>
  <li> <a href="<%= displayClosedDateUploadPage %>">Use this link to bulk upload Closed Date of Applications</a> </li>
  <li> <a href="<%= displayPreCourseCounselling %>">Use this link to update the data for Pre Course Counselling</a> </li>
</ol>


