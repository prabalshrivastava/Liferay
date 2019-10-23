<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}" prefix="og: http://ogp.me/ns#">

<head>
    <title>${the_title} - ${company_name}</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

    ${theme.include(top_head_include)}
    <link rel="stylesheet" href="${themeDisplay.getPathThemeCss()}/sp/sp_custom.css?minifierType=css&modified=15256977345" />

    <#include "${full_templates_path}/ogTagValues.ftl" />

	<#if themeDisplay.getPortalURL()?contains("foundry.unilever.com")>
		<#include "${full_templates_path}/newrelic.ftl" />
	</#if>

    ${samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head-javascript")}

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
                        <img src="${themeDisplay.getPathThemeImages()}/header-footer/bhp_org_logo.svg" alt="logo" class="whiteLogo">
                        <img src="${themeDisplay.getPathThemeImages()}/header-footer/bhp_org_logo.svg" alt="logo" class="blackLogo">
                       
                        <!-- <span class="site-name sitename-visible" >
                            Mining for Innovation
                        </span> -->
                    
                    </a>

                   
                </div>

                <div class="header-content text-right">

                    <div style="display: block; width: 100%; text-align: right;">
                     <#if is_signed_in>
                        <div class="signedin_nav">
                            <div class="signedin_prof">
                                <#if themeDisplay.getUser().getPortraitURL(themeDisplay) != '' >
                                    <img src="${themeDisplay.getUser().getPortraitURL(themeDisplay)}" alt="User Image"/>
                                    <span class="signedin_name">
                                        ${themeDisplay.getUser().getFirstName()}

                                    </span>


                                <#else>
                                    <span class="signedin_greetings">Hi!</span><span class="signedin_name">${themeDisplay.getUser().getFirstName()}</span>

                                </#if>

                            </div>
                            <ul class="signedin_menu maxChar">
                                <li>


                                    <a href="${dashboardUrl}" class="animate">
                                        My Dashboard
                                    </a>
                                </li>

                                <#assign singleUserStartup = samUtil.getParameter("enable.single_user.startup.access", themeDisplay.getScopeGroupId())>
                                <#if singleUserStartup != "true" >
                                    <#assign usrStartupList = samUtil.getUserStartupProfiles(themeDisplay)>
                                    <#if usrStartupList.size() != 0>
                                    <li>

                                        <a href="#"><b>My StartUps</b></a>
                                            <ul class="startup_list">

                                                    <#list usrStartupList as prof>
                                                        <li>
                                                            <a href="${prof.getDetailsUrl()}">${prof.getName()}</a>
                                                            <span class="actionIcons">
                                                                <a href="${prof.getDetailsUrl()}" title="View Startup"><img src="${themeDisplay.getPathThemeImages()}/header-footer/view.svg" alt="View Startup" /></a>
                                                                <a href="${prof.getEditUrl()}" title="Edit Startup"><img src="${themeDisplay.getPathThemeImages()}/header-footer/edit.svg" alt="Edit Startup" /></a>
                                                            </span>


                                                        </li>
                                                    </#list>




                                            </ul>


                                    </li>
                                    </#if>
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
                        <a href="#" target="_blank">
                            <img src="${themeDisplay.getPathThemeImages()}/header-footer/bhp_wht_logo.svg" class="ul_white" width="55" height="40"  alt="Logo"/>
                            <img src="${themeDisplay.getPathThemeImages()}/header-footer/bhp_wht_logo.svg" class="ul_gray" width="55" height="40"  alt="Logo"/>
                        </a>
                    </div>
                    <div class="GlobeIcon">
                        <a href="#" target="_blank">
                            <img src="${themeDisplay.getPathThemeImages()}/header-footer/globe.svg"   alt="Globe"/>
                          
                        </a>
                    </div>

                    </div>
                    <#if has_navigation || is_signed_in>
                        <nav class="${nav_css_class} main-navigation" id="navigation" role="navigation">
                            <#include "${full_templates_path}/navigation.ftl" />
                        </nav>
                    </#if>

                    <#if is_signed_in && samUtil.showNotificationIconOnDockbar() == false>
                        <div class="inline-block notificationsDiv hide">
                            ${theme.runtime("2_WAR_notificationsportlet")}
                        </div>
                    </#if>


                 
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

     <footer class="footer-section ">
        <div class="overlay-footer ">
            <div class="footer-container">
                <div class="footer-row ">
                 <div class="footer-social-link ">
                        <ul class="f-social-link">
                            <li>
                                <a href="# target="_blank"><img src="${themeDisplay.getPathThemeImages()}/header-footer/footer-linkedin.svg" alt="linkedin"></a>
                            </li>
                            <li>
                                <a href="#" target="_blank"><img src="${themeDisplay.getPathThemeImages()}/header-footer/footer-twitter-icon.svg" alt="twitter"></a>
                            </li>
                            <li>
                                <a href="#" target="_blank"><img src="${themeDisplay.getPathThemeImages()}/header-footer/footer-youtube-icon.svg" alt="youtube"></a>
                            </li>
                        </ul>
                    </div>
                   
                    <div class="footer-link-wrapper">
                        <ul class="footer-link">
                            <li><a href="#">Contact us</a></li>
                            <li><a href="#">Accessibility</a></li>
                            <li><a href="#">Respecting human rights and UK Modern Slavery </a></li>

                            <li><a href="#">Act Statement</a></li>
                            <li><a href="#">Supplying to BHP Billiton</a></li>
                            <li><a href="#">Terms of use</a></li>
                            <li><a href="#">Warnings</a></li>
                            <li><a href="#">Sitemap</a></li>
                        </ul>
                       
                    </div>

                     <div class="footer-logo">
                     
                     <a href="#" target="_blank"><img src="${themeDisplay.getPathThemeImages()}/header-footer/bhp_org_logo.svg" alt="mining-logo" title="mining"></a>
                      <p>MINING FOR INNOVATION © 2017 <a href="#" target="_blank"> BHP</a> 
                      <br> POWERED BY <a href="https://www.sambaash.com" target="_blank">SAMBAASH</a></p>
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
