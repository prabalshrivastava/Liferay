<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - sambaash</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

	${theme.include(top_head_include)}
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="${themeDisplay.getPathThemeCss()}/sp/sp_custom.css?minifierType=css&modified=1521387023" />

	 <#include "${full_templates_path}/ogTagValues.ftl" />

    ${samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head-javascript")}

</head>

<body class="${css_class}">

<#assign cURL = themeDisplay.getURLCurrent()>
<#assign site_logo = themeDisplay.getCompanyLogo()>

<a href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

${theme.include(body_top_include)}


<#if samUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())>
	<@liferay.dockbar />
</#if>

<div class="container-fluid" id="wrapper">

	<header class="main-header fixed block pin-left pin-right pin-top  full-width " id="banner" role="banner">

			<div class=" block full-width relative" id="heading">

				<div class="site-main-logo absolute pin-top-left inline-block ">
					<a class="${logo_css_class}" href="#" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						<img src="${site_logo}" alt="logo" class="blackLogo">
					</a>

					<#if show_site_name>
						<span class="site-name hide" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
							${site_name}
						</span>
					</#if>
				</div>

				<div class="header-content text-right">
					 <#if is_signed_in>
						<#if has_navigation>
							<nav class="${nav_css_class} main-navigation" id="navigation" role="navigation">
								<#include "${full_templates_path}/navigation.ftl" />
							</nav>
						</#if>
							<div class="signInheaderSearch">
			                  	<div class="signInsearchBtn"></div>
				                     <div class="dropdown-signInsearch" id="dropdown-signInsearch">
				                        ${theme.journalContentSearch()}
				                        <!--<input type="text" placeholder="Search for a Course" id="signIn-headerSearchField">-->
				                        <div class="signIn_search_icon">
										<img src="${themeDisplay.getPathThemeImages()}/menu/mobilesearch.svg" alt="Search">
									</div>
			                    </div>
			                 </div>
					</#if>

					<#if is_signed_in && samUtil.showNotificationIconOnDockbar() == false>
						<div class="inline-block notificationsDiv">
							${theme.runtime("2_WAR_notificationsportlet")}
						</div>
					</#if>

					<div class="user-dropdown">
                  	<button class="dropbtn"></button>
                    <div class="dropdown-content">
                        <#if is_signed_in>
                        	<#assign usrStartupList1 = samUtil.getUserStartupProfiles(themeDisplay)>
                        	<#if usrStartupList1.size() != 0>
                        	    <#if usrStartupList1.size() gt 1>
		                            <#list usrStartupList1 as prof1>
		                                <a href="${prof1.getDetailsUrl()}" title="View Startup"><div class="profile"></div>${prof1.getName()}</a>
									</#list>
                        	    <#else>
		                            <#list usrStartupList1 as prof1>
		                                <a href="${prof1.getDetailsUrl()}" title="View Startup"><div class="profile"></div>My Profile</a>
									</#list>
								</#if>
							<#else>
								<#assign dashUrl = samUtil.getDashboardUrl(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()) >
                            	<a href="${dashUrl}"><div class="profile"></div>My Profile</a>
                            </#if>
                            <#assign briefListPage = samUtil.getParameter("challengesListPage",themeDisplay.getScopeGroupId()) >
							<#if briefListPage != "" && samUtil.isStartup(themeDisplay.getUser())>
                                <#assign startupApplicationsPage = samUtil.startupApplicationsFriendlyURL(themeDisplay) >
    							<a href="${startupApplicationsPage}"><div class="profile"></div>My Applications</a>
                            </#if>                            
                            <a href="/c/portal/logout"><div class="logout"></div>Sign Out</a>
                        <#else>
                         	<a href="/signin"><div class="signin"></div>Signin</a>
                         	 <#if samUtil.canStrangersCreateAccount(themeDisplay) == true>
                            	<a href="${portalUtil.getCreateAccountURL(request, themeDisplay)}"><div class="signup"></div>Signup</a>
                            </#if>
                        </#if>
                    </div>
                    </div>

				</div>
			</div>
	</header>


	<#include "${full_templates_path}/mobile-navigation.ftl" />

	<#assign cURLClass = "">
	<#if cURL == "" || cURL == "/signin" || cURL == "/signup" || cURL == "/welcome" >
		<#assign cURLClass = 'full-width-page'>
	</#if>
	<main class="main-content-wrap ${cURLClass}">

		<div class="main-content" id="content">

			<#if selectable>
				${theme.include(content_include)}
			<#else>
				${portletDisplay.recycle()}

				${portletDisplay.setTitle(the_title)}

				${theme.wrapPortlet("portlet.ftl", content_include)}
			</#if>
		</div>
	</main>

	<#include "${full_templates_path}/footer.ftl" />

</div>

<script src="${themeDisplay.getPathThemeJavaScript()}/mobile-menu.js" type="text/javascript"></script>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}


<#if themeDisplay.getPortalURL()?contains("www.sambaash.com")>
	<#include "${full_templates_path}/analytics.ftl" />
<#elseif themeDisplay.getPortalURL()?contains("lh.sambaash.com")>
	<#include "${full_templates_path}/analytics-stg.ftl" />
</#if>

</body>

</html>
