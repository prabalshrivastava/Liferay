<%@page import="com.sambaash.platform.spperiscopedata.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.spperiscopedata.util.PeriscopedataUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.sambaash.platform.spperiscopedata.builder.PeriscopedataRequestBuilder.APIOptions"%>
<%@page import="com.sambaash.platform.spperiscopedata.SPPeriscopeDataConstant"%>
<%@page import="com.sambaash.platform.spperiscopedata.builder.PeriscopedataRequestBuilder"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"/>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:resourceURL var="resourceURL" />

   <div class="ps-container">
        <div class="ps-main-wrapper">
            <!-- sidebar-->
             <div class="ps-sidebar" id="ps-sidebarToggler">
                <a href="javascript:void(0)" class="closebtn" onclick="closeSidebarNav()">&times;</a>
                <div class="ps-sidebar-heading">
                    <h2 class="ps-sidebar-title">Business Intelligence (BI)</h2>
                </div>
            </div>
            <!-- sidebar end-->
            <!-- content -->
            <div class="ps-content-wrapper" id="main-ps-content">
                <span style="font-size:30px;cursor:pointer" onclick="openSidebarNav()">&#9776;</span>
                <span class="icon-refresh icon-spin" style="font-size:25px;cursor:pointer;float:right;" onclick="refresh()"></span> 
                <!-- iframe -->
				<iframe id="periscope" src="" align="middle" frameborder="0" height="100%" scrolling="no" width="100%" >
				</iframe>    
            </div>
            <!-- content End -->
        </div>
    </div>
 
<script src="/SPPeriscopeData-portlet/js/main.js?t=432234723435" type="text/javascript"></script>

<aui:script use="aui-base,aui-io-request">
initializeView('<%=resourceURL%>', '<portlet:namespace />', <%=PermissionUtil.getPermittedNavConfig(themeDisplay, portletPreferences)%>);
</aui:script>
