<%@ include file="init.jsp" %>
<%--
/**
* Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>
<portlet:actionURL var="actionCancel">
	<portlet:param name="action" value="cancel" />
</portlet:actionURL>

<div class="reg-outer-wrap">
	<div class="reg-content-wrap">
	<!-- upgrade package screen -->
		<h1 class="header-title">Membership Package Upgrade</h1>
		<div id="<portlet:namespace/>divSuccessMessage" style="text-align: center; padding: 30px">
			<h2>
	 			No membership package available for Upgrade
	 		</h2>
	  		<div style="text-align: right;padding-right:50px;">
	    		<a href="${actionCancel}">home page</a>
	    	</div>
		</div>
	</div>
</div>