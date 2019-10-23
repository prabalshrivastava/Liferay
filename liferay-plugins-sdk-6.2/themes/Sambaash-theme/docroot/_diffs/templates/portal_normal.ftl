<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - sambaash</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

	${theme.include(top_head_include)}
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="${themeDisplay.getPathThemeCss()}/sp/sp_custom.css?modified=1522060577" />

	 <#include "${full_templates_path}/ogTagValues.ftl" />

	<#if themeDisplay.getPortalURL()?contains("www.sambaash.com")>
		<#include "${full_templates_path}/analytics.ftl" />
	</#if>

<!--Start of Zendesk Chat Script-->
<script type="text/javascript">
window.$zopim||(function(d,s){var z=$zopim=function(c){z._.push(c)},$=z.s=
d.createElement(s),e=d.getElementsByTagName(s)[0];z.set=function(o){z.set.
_.push(o)};z._=[];z.set._=[];$.async=!0;$.setAttribute("charset","utf-8");
$.src="https://v2.zopim.com/?28VzSG8RdSj7LLtFhjpIKxEA8ODPGLHk";z.t=+new Date;$.
type="text/javascript";e.parentNode.insertBefore($,e)})(document,"script");
</script>
<!--End of Zendesk Chat Script-->

        ${samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head-metatags")}
        ${samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head-javascript")}

</head>

<body class="${css_class}">

<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '236955386405994',
      xfbml      : true,
      version    : 'v2.8'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>


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
					<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						<img src="${site_logo}" alt="logo" class="blackLogo">
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

					<div class="inline-block requestDemo">
							<a href="#reqDemoSambaash"><span>Request Demo</span></a>
					</div>

					<#if is_signed_in && samUtil.showNotificationIconOnDockbar() == false>
						<div class="inline-block notificationsDiv">
							${theme.runtime("2_WAR_notificationsportlet")}
						</div>
					</#if>

					<!-- <div class="user-dropdown">
                 	 <button class="dropbtn"></button>
                    	<div class="dropdown-content">
                        <#if is_signed_in>
                            <a href="/profile"><div class="profile"></div>My Profile</a>
                            <a href="/c/portal/logout"><div class="logout"></div>Sign Out</a>
                        <#else>
                         	<a href="/signin"><div class="signin"></div>Signin</a>
                            <a href="${portalUtil.getCreateAccountURL(request, themeDisplay)}"><div class="signup"></div>Signup</a>
                        </#if>
                    </div>
                    </div>-->

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
<script type="text/javascript" src="/Sambaash-theme/js/homepage.js?v=1514882590"></script>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

<!-- Start of HubSpot Embed Code -->
  <script type="text/javascript" id="hs-script-loader" async defer src="//js.hs-scripts.com/2568368.js"></script>
<!-- End of HubSpot Embed Code -->

</body>

</html>
