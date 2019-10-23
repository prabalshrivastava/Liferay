<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - InfoPier</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
 <#include "${full_templates_path}/ogTagValues.ftl" />
	${theme.include(top_head_include)}
<link rel="stylesheet" href="${themeDisplay.getPathThemeCss()}/sp/sp_custom.css" />

<#if samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head-facebook-pixel") != "">
	${samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head-facebook-pixel")}
</#if>
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

				<div class="site-main-logo absolute pin-top-left inline-block">
					<#if is_signed_in>
						<div id="headLogo" class="logo2">
							<a class="${logo_css_class} logo" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">

							</a>
						</div>
					<#else>
						<div id="headLogo" class="logo_1">
							<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">

							</a>
						</div>
					</#if>
					<a class="scsLogo" href="http://www.scs.org.sg/" target="_blank">
						<img src="/Infopier-theme/images/common/scs_logo.png" alt="SCS logo">
					</a>
					<#if show_site_name>
						<span class="site-name hide" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
							${site_name}
						</span>
					</#if>
				</div>

				<div class="header-content text-right">

						<#if has_navigation>
							<nav class="${nav_css_class} main-navigation" id="navigation" role="navigation">
								<#include "${full_templates_path}/navigation.ftl" />
							</nav>
						</#if>
						<#if is_signed_in>
						<ul class="signout_">
							<li>
								<a href="/c/portal/logout">
									<span>Sign Out</span>
								</a>
							</li>
						</ul>
						<#else>
						 <ul class="signin_">
							<li>
								<a href="/signin">
									<span>Login</span>
								</a>
							</li>
							<li class="slashSeparator">/</li>
							<li>
								<a href="${portalUtil.getCreateAccountURL(request, themeDisplay)}" style="color: #FF9001;">
									<span>Signup</span>
								</a>
							</li>
						</ul>
						</#if>
					</div>
						</div>
					<#if has_navigation>
					<div class="main-header-mobile">
						<div class="mobile-navigation">
							<div class="mobile-navigation-button">
								<button class="mobile-menu-icon-hamburger rippled"><span></span></button>
							</div>

								<nav class="dl-menuwrapper dl-menu">
									<#include "${full_templates_path}/mobile-navigation-items.ftl" />
								</nav>
						</div>

						<div id="mobile_logo" class="mobile-staff-inline">
							<a href="/"><img src="/Infopier-theme/images/common/Infopier_mobile_logo.png" width="100" alt="logo"></a>
						</div>

						<ul class="horizontal topmenu menuhopper mobile-staff">
							<li class="topmenu">
								<a href="/signin">
									<img src="/Infopier-theme/images/common/Infopier_mobile_Login.png" alt="Signin">
								</a>
							</li>
							<li class="topmenu topMenuSignup">
								<a href="${portalUtil.getCreateAccountURL(request, themeDisplay)}">
									<img src="/Infopier-theme/images/common/Infopier_mobile_Register.png" alt="Register">
								</a>
							</li>
						</ul>
						</div>
					</#if>

	</header>


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


<#if themeDisplay.getPortalURL()?contains("www.infopier.sg")>
	<#include "${full_templates_path}/analytics.ftl" />
<#elseif themeDisplay.getPortalURL()?contains("staging.infopier.sg")>
	<#include "${full_templates_path}/analytics-stg.ftl" />
</#if>

</body>

</html>
