<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}" prefix="og: http://ogp.me/ns#">

<head>
    <title>${the_title} - ${company_name}</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    
    <#include "${full_templates_path}/ogTagValues.ftl" />
    
    <#if themeDisplay.getPortalURL()?contains("foundry.unilever.com")>
		<#include "${full_templates_path}/newrelic.ftl" />
	</#if>


    ${theme.include(top_head_include)}
    <link rel="stylesheet" href="${themeDisplay.getPathThemeCss()}/sp/sp_custom.css?minifierType=css&modified=1522912085" />

    

</head>

<body class="${css_class}">

<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '441152992720009',
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

<#if cURL == "/" || cURL == "/welcome"  >
    <div class="se-pre-con" id="Loader2"></div>
    <p class="hide"> ${cURL} </p>
</#if>


<a href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

${theme.include(body_top_include)}


<#if samUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())>
    <@liferay.dockbar />
</#if>

<div class="container-fluid" id="wrapper">

    <header class="main-header fixed block pin-left pin-right pin-top  full-width " id="banner" role="banner">

            <div class=" block padding-left-half padding-right-half full-width relative" id="heading">

                <div class="site-main-logo absolute pin-top-left inline-block ">
                    <a class="${logo_css_class}" href="${site_default_url}" title="Home"/>
                        <!-- <img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" /> -->
                        <img src="${themeDisplay.getPathThemeImages()}/header-footer/Unilever-Foundry-02.svg" alt="Unilever Logo" class="Unilever whiteLogo">
                        <img src="${themeDisplay.getPathThemeImages()}/header-footer/Unilever-Foundry-01.svg" alt="Unilever Logo" class="Unilever blackLogo">
                    </a>

                    <#if show_site_name>
                        <span class="site-name hide" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
                            ${site_name}
                        </span>
                    </#if>
                </div>

                <div class="header-content text-right">
                    <#if has_navigation || is_signed_in>
                        <nav class="${nav_css_class} main-navigation" id="navigation" role="navigation">
                            <#include "${full_templates_path}/navigation.ftl" />
                        </nav>
                    </#if>

                    <#if is_signed_in && samUtil.showNotificationIconOnDockbar() == false>
                        <div class="inline-block notificationsDiv" style="display:none;">
                            ${theme.runtime("2_WAR_notificationsportlet")}
                        </div>
                    </#if>

                    <#if is_signed_in>
                        <div class="signedin_nav">
                            <div class="signedin_prof">
                                <#if themeDisplay.getUser().getPortraitURL(themeDisplay) != '' >
                                    <img src="${themeDisplay.getUser().getPortraitURL(themeDisplay)}" alt="User Image"/>
                                    <#assign usrStartupList1 = samUtil.getUserStartupProfiles(themeDisplay)>
	                                <#if usrStartupList1.size() != 0>
                                    <span class="signedin_name">
                                    <#list usrStartupList1 as prof1>
                                        <a href="${prof1.getDetailsUrl()}" title="View Startup">${themeDisplay.getUser().getFirstName()}</a>
									</#list>
                                    </span>
									</#if>

                                <#else>
                                    <span class="signedin_greetings">Hi!</span><span class="signedin_name">${themeDisplay.getUser().getFirstName()}</span>

                                </#if>

                            </div>
                            <ul class="signedin_menu maxChar">
                            	<#assign singleUserStartup = samUtil.getParameter("enable.single_user.startup.access", themeDisplay.getScopeGroupId())>
								<#if singleUserStartup != "true" >
									<#assign usrStartupList = samUtil.getUserStartupProfiles(themeDisplay)>
									<#assign profileUrl = "#">
	                                <#if usrStartupList.size() != 0>
	                                <li>
										 <#list usrStartupList as prof>
										 	<#assign profileUrl = prof.getDetailsUrl()>
	                                     </#list>
	                                     <a href="${profileUrl}" target="_blank"><b>MY PROFILE</b></a>
	                                </li>
	                                </#if>
                                </#if>
                                <#if samUtil.isStartup(themeDisplay.getUser())>
                                <#assign startupApplicationsPage = samUtil.startupApplicationsFriendlyURL(themeDisplay) >
                                <li>
									<a href="${startupApplicationsPage}" class="animate">MY APPLICATIONS</a>
                                </li>
                                </#if>
									<#if samUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())>
									<li>
										<a href="${dashboardUrl}" class="animate">MY DASHBOARD</a>
									 </li>	
									</#if>
								
								

                                <#if is_signed_in>
                                    <li>
                                        <a href="/c/portal/logout" class="animate">
                                            Signout
                                        </a>
                                    </li>
                                </#if>


                            </ul>

                        </div>

                    <#else>
                        <span class="joinus"><a href="/signup" class="animate" style="display:none;">REGISTER</a></span>
                        <span class="joinus"><a href="/signin"  class="animate">SIGN IN</a></span>
                    </#if>
                    <div class="companyLogo2">
                        <a href="http://www.unilever.com" target="_blank">
                            <img src="${themeDisplay.getPathThemeImages()}/lp/UL-logo.svg" class="ul_white" width="55" height="40"  alt="Unilever Logo"/>
                            <img src="${themeDisplay.getPathThemeImages()}/lp/Unilever-Logo-Blue.svg" class="ul_gray" width="55" height="40"  alt="Unilever Logo"/>
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

     <footer class="footer-section" id="footer">
        <div class="overlay-footer ">
            <div class="footer-container">
                <div class="footer-row ">
                    <div class="footer-logo"><a href="https://www.unilever.com/" target="_blank"><img src="/UnileverFoundry-theme/images/header-footer/Logo-Unilever-footer.svg" alt="unilever-logo" title="unilever"></a></div>
                    <div class="footer-link-wrapper">
                        <ul class="footer-link">
                            <li><h4><a href="/legal">TERMS OF USE</a></h4></li>
                            <li><h4><a href="http://www.unileverprivacypolicy.com/en_gb/policy.aspx">PRIVACY POLICY</a></h4></li>
                            <li><h4><a href="http://www.unilevercookiepolicy.com/en_GB/accept-policy.aspx">COOKIE POLICY</a></h4></li>

                            <li><h4><a href="/faq">FAQ</a></h4></li>
                            <li><h4><a href="/contact-us">CONTACT US</a></h4></li>
                        </ul>
                        <p>A GLOBAL UNILEVER INITIATIVE © 2017 <a href="https://www.unilever.com/" target="_blank"> UNILEVER</a> | POWERED BY <a href="https://www.sambaash.com" target="_blank">SAMBAASH</a></p>
                    </div>
                    <div class="footer-social-link ">
                        <ul class="f-social-link">
                            <li>
                                <a href="https://www.linkedin.com/company/the-unilever-foundry" target="_blank"><img src="/UnileverFoundry-theme/images/header-footer/footer-linkedin.png" alt="Linkedin"></a>
                            </li>
                            <li>
                                <a href="https://twitter.com/UnileverFoundry" target="_blank"><img src="/UnileverFoundry-theme/images/header-footer/footer-twitter-icon.png" alt="Twitter"></a>
                            </li>
                            <li>
                                <a href="https://www.youtube.com/channel/UCKTg9Vo_pcevOZUYc8wcTmA" target="_blank"><img src="/UnileverFoundry-theme/images/header-footer/footer-youtube-icon.png" alt="Youtube"></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</div>

<div class="backToTop animated animate" id="backToTop-node">
    <a href="#docHead">
        <img src="${themeDisplay.getPathThemeImages()}/menu/MenuDropDownIcon.png" id="b2top_icon" alt="BackToTop"/>
    </a>
</div>
<#if is_signed_in>
    <div class="adminCtrls animated animate" id="adminCtrls">
            <a>
                <span class="txt ad">Admin</span> <span class="txt test">Test</span>
            </a>
    </div>
</#if>

<script src="${themeDisplay.getPathThemeJavaScript()}/mobile-menu.js" type="text/javascript"></script>
<script src="${themeDisplay.getPathThemeJavaScript()}/script.js" type="text/javascript"></script>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

<#if themeDisplay.getPortalURL()?contains("foundry.unilever.com")>
	<#include "${full_templates_path}/analytics.ftl" />
</#if>


</body>

</html>
