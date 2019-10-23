<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}" prefix="og: http://ogp.me/ns#" >

<head>
	<#if themeDisplay.getPortalURL()?contains("www.lithan.com")>
        <link rel="manifest" href="/manifest.webmanifest">
		<#include "${full_templates_path}/custom_tracking.ftl" />
		<#include "${full_templates_path}/fb-pixel.ftl" />
		<#include "${full_templates_path}/yahoo-pixel.ftl" />
	</#if>

	<title>${the_title} - Lithan</title>

    <#if themeDisplay.getPortalURL()?contains("sambaash.com")>
        <meta name="robots" content="noindex">
    </#if>

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

	${theme.include(top_head_include)}
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="${themeDisplay.getPathThemeCss()}/sp/sp_custom.css?minifierType=css&modified=1524467276" />

	 <#include "${full_templates_path}/ogTagValues.ftl" />

    <#if themeDisplay.getPortalURL()?contains("www.lithan.com")>
        <script type="text/javascript">
        window.$zopim||(function(d,s){var z=$zopim=function(c){z._.push(c)},$=z.s=
        d.createElement(s),e=d.getElementsByTagName(s)[0];z.set=function(o){z.set.
        _.push(o)};z._=[];z.set._=[];$.async=!0;$.setAttribute("charset","utf-8");
        $.src="https://v2.zopim.com/?4WqD241pwge0Ml20ANzSYTdwVRYVYCZR";z.t=+new Date;$.
        type="text/javascript";e.parentNode.insertBefore($,e)})(document,"script");
        </script>
    </#if>

    ${samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head-javascript")}



</head>

<body class="${css_class}">

<#if themeDisplay.getPortalURL()?contains("www.lithan.com")>
  <#--<#include "${full_templates_path}/gtm-body.ftl" />-->
</#if>


<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '1511551305817811',
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

<a href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

${theme.include(body_top_include)}


<#if samUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())>
	<@liferay.dockbar />
</#if>

<div class="container-fluid" id="wrapper">

	<header class="main-header fixed block pin-left pin-right pin-top  full-width " id="banner" role="banner">

			<div class=" block full-width relative" id="heading">

				<div class="site-main-logo absolute pin-top-left inline-block ">
					<a class="${logo_css_class}" href="${site_default_url}" title="Go to Lithan">
						<img src="${themeDisplay.getPathThemeImages()}/menu/LithanHall_Logo2Footer.png" alt="logo" class="blackLogo">
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
				                        <input type="text" placeholder="Search for a Course" id="signIn-headerSearchField">
				                        <div class="signIn_search_icon">
										<img alt="Search" src="${themeDisplay.getPathThemeImages()}/menu/mobilesearch.svg">
									</div>
			                    </div>
			                 </div>
					<#else>
						<div class="headerSearch">
							<input type="text" placeholder="Search for a Course" id="headerSearchField">
							<div class="header_search_icon">
								<img alt="Search" src="${themeDisplay.getPathThemeImages()}/menu/shape.svg" id="header_search_icon">
							</div>
						</div>
					</#if>

					<div class="user-dropdown">
                  <button class="dropbtn"></button>
                    <div class="dropdown-content">
                        <#if is_signed_in>
                        	<!-- <a href="${themeDisplay.getUser().getScreenName()}"><div class="profile"></div><span>My Profile</span></a> -->
                        	<#include "${full_templates_path}/useraccout_menu.ftl" />
                            <a href="/c/portal/logout"><div class="logout"></div>Sign Out</a>
                        <#else>
                         	<a href="/signin"><div class="signin resize-original-width"></div>Signin</a>
                            <a href="${portalUtil.getCreateAccountURL(request, themeDisplay)}"><div class="signup"></div>Signup</a>
                        </#if>
                    </div>
                    </div>

					<div class="country-dropdown">
                    <button class="dropbtn1 ${samUtil.getLocationFromUrl(request)} selected-country"></button>
                      <div class="dropdown-content1">
                        <a href="${samUtil.getLocationBasedURL('en', request)}"><div class="international"></div>International</a>
                        <a href="${samUtil.getLocationBasedURL('singapore', request)}"><div class="singapore"></div>Singapore</a>
                        <a href="${samUtil.getLocationBasedURL('malaysia', request)}"><div class="malaysia"></div>Malaysia</a>
                        <a href="${samUtil.getLocationBasedURL('myanmar', request)}"><div class="myanmar"></div>Myanmar</a>
                        <a href="${samUtil.getLocationBasedURL('india', request)}"><div class="india"></div>India</a>
                        <a href="${samUtil.getLocationBasedURL('china', request)}"><div class="china"></div>China</a>
                      </div>
                    </div>

					<div class="header-cta inline-block align-middle font-std">
						<a class="normal-cta inline-block align-middle" href="/contact-us">
							<span>Get In Touch</span>
						</a>
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
<script src="${themeDisplay.getPathThemeJavaScript()}/sp-ninja-slider.js?v=1524467276" type="text/javascript"></script>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

${theme.runtime("SPActivityHub_WAR_SPActivityHubportlet")}


<#if themeDisplay.getPortalURL()?contains("www.lithan.com")>
	<#include "${full_templates_path}/analytics.ftl" />
<#elseif themeDisplay.getPortalURL()?contains("lh.sambaash.com")>
	<#include "${full_templates_path}/analytics-stg.ftl" />
</#if>

  <script type="text/javascript" src="upup.min.js"></script>
  <script>
    UpUp.start({
      'content-url': '/'
    });
  </script>

</body>

</html>
