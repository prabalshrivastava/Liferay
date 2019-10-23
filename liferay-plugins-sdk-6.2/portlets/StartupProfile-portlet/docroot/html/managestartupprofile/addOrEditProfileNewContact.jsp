<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sambaash.platform.util.PermissionUtil"%>
<%@page import="com.sambaash.platform.constant.SystemSetupConstants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib	uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
taglib	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%><%@
taglib	uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%@ taglib	uri="/tld/sp-ui" prefix="sp-ui"%>
<%@ taglib uri="/tld/sp-formio" prefix="sp-formio"%>
<link rel='stylesheet' href='/html/css/sp/formio.full.min.css?minifierType=css'>
<link rel='stylesheet' href='/html/css/hook.css?minifierType=css'>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<div class="CorporateProfile">
<header>
	<ul>
		<li><a href="#link" class="logoContact"></a></li>
		<li>GETING SINGAPORE</li>
		<li><a href="www.gentingsingapore.com" class="link-icon" title="gentingsingapore.com"></a></li>
		<li>
			<ul>
				<li>Singapore</li>
				<li>Founded in 1984</li>
			</ul>
		</li>
	</ul>
</header>
<div class="menu">
	<div class="container">
	<ul>
		<li class="active">About</li>
		<li>More Info</li>
		<li><a href="#Link" class="btn btn-primary">Edit Profile</a></li>
	
	
	</ul>
	</div>
</div>
<div class="container">
<aui:row>
	<aui:col span="9">
		<div class="boxWhite contact">
			<h2>CONTACT DETAILS</h2>
			
			<ul>
				<li><a href="tel:+65 6577 8888" class="contact-icon" title="+65 6577 8888">+65 6577 8888</a></li>
				<li><a href="mailto:ir@gentingsingapore.com" class="envolope-icon" title="ir@gentingsingapore.com">ir@gentingsingapore.com</a></li>
				<li><a href="www.gentingsingapore.com" class="link-icon" title="gentingsingapore.com">gentingsingapore.com</a></li>
			</ul>
		</div>
		<div class="boxWhite">
			<h2>COMPANY BACKGROUND</h2>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut risus ut libero tincidunt consectetur. Nullam semper elementum ante, ac tincidunt nisl efficitur ac. Vivamus ac viverra ipsum. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque id maximus quam, at fringilla libero. Nam quis erat dolor. Nunc at felis a nisi semper ornare. Etiam eget dapibus diam. Cras cursus pharetra scelerisque. Aliquam facilisis, libero eget convallis ultrices, felis lorem blandit nisl, a facilisis ex leo feugiat magna. Quisque nunc mi, semper vel sodales a, ullamcorper at diam. Vestibulum id est fringilla, elementum erat euismod, aliquam nisi.</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut risus ut libero tincidunt consectetur. Nullam semper elementum ante, ac tincidunt nisl efficitur ac. Vivamus ac viverra ipsum. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque id maximus quam, at fringilla libero. Nam quis erat dolor. Nunc at felis a nisi semper ornare. Etiam eget dapibus diam. Cras cursus pharetra scelerisque. Aliquam facilisis, libero eget convallis ultrices, felis lorem blandit nisl, a facilisis ex leo feugiat magna. Quisque nunc mi, semper vel sodales a, ullamcorper at diam. Vestibulum id est fringilla, elementum erat euismod, aliquam nisi.</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ut risus ut libero tincidunt consectetur. Nullam semper elementum ante, ac tincidunt nisl efficitur ac. Vivamus ac viverra ipsum. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Quisque id maximus quam, at fringilla libero. Nam quis erat dolor. Nunc at felis a nisi semper ornare. Etiam eget dapibus diam. Cras cursus pharetra scelerisque. Aliquam facilisis, libero eget convallis ultrices, felis lorem blandit nisl, a facilisis ex leo feugiat magna. Quisque nunc mi, semper vel sodales a, ullamcorper at diam. Vestibulum id est fringilla, elementum erat euismod, aliquam nisi.</p>
		</div>
	</aui:col>
	<aui:col span="3">
	<div class="boxWhite">
		<h2>Location</h2>
		<ul>
			<li>10 Sentosa Gateway,</li>
			<li>Resorts World Sentosa,</li>
			<li>Singapore 098270</li>
		</ul>	
	</div>
	</aui:col>
</aui:row>
</div>
</div>