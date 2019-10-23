<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}"
      prefix="og: http://ogp.me/ns#">

<head>

    <title>${the_title} - SCAQ</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="theme-color" content="#00205b"/>

    <#if themeDisplay.getPortalURL()?contains("sambaash.com")||themeDisplay.getPortalURL()?contains("uat.relc.org.sg") >
        <meta name="robots" content="noindex">
    </#if>

    ${theme.include(top_head_include)}
    <link rel="stylesheet"
          href="${themeDisplay.getPathThemeCss()}/sp/sp_custom.css?minifierType=css&modified=1565793669"/>

    <#include "${full_templates_path}/ogTagValues.ftl" />

    ${samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head-javascript")}

    <#if themeDisplay.getPortalURL()?contains("www.relc.org.sg")>
        <#include "${full_templates_path}/analytics.ftl" />
    </#if>


</head>

<body class="${css_class}">

<script>
    window.fbAsyncInit = function () {
        FB.init({
            appId: '558366327829145',
            cookie: true,
            xfbml: true,
            version: 'v2.11'
        });

        FB.AppEvents.logPageView();

    };

    (function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {
            return;
        }
        js = d.createElement(s);
        js.id = id;
        js.src = "https://connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>

<#assign cURL = themeDisplay.getURLCurrent()>
<#assign isShowSignin = samUtil.isShowSignIn(themeDisplay)>

<a href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

${theme.include(body_top_include)}

<#if samUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())>
    <@liferay.dockbar />
</#if>

<div class="container-fluid" id="wrapper">
    <#if !(!is_signed_in || samUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()))>
        <style>
            .main-content {
                margin-top: 8px !important;
            }
        </style>
    </#if>

    <#if !is_signed_in || (is_signed_in && !themeDisplay.getLayout().isPrivateLayout() && !themeDisplay.getPortalURL()?contains("ems.sambaash.com")
    && !themeDisplay.getPortalURL()?contains("mt.sambaash.com"))>
        <header class="main-header fixed block pin-left pin-right pin-top  full-width " id="banner" role="banner">

            <div class=" block full-width relative" id="heading">

                <div class="site-main-logo absolute pin-top-left inline-block ">
                    <a class="${logo_css_class}" href="/" title="Back to Homepage">
                        <img src="${themeDisplay.getPathThemeImages()}/menu/sac-logo.png" alt="logo" class="blackLogo">
                    </a>

                    <#if show_site_name>
                        <span class="site-name hide"
                              title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
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
                        <div class="user-dropdown">
                            <div class="dropbtn" id="user-dropdown-dropbtn" style="background: none !important;">
                                <img src="${themeDisplay.getUser().getPortraitURL(themeDisplay)}">
                            </div>
                            <div class="dropdown-content-dsktop searchContainer" id="dropdown-content-dsktop">
                                <#if is_signed_in>
                                    <a href="/profile" class="userDetail">
                                        <div class="userDetailIcon"><img
                                                    src="${themeDisplay.getUser().getPortraitURL(themeDisplay)}"><span>${themeDisplay.getUser().getFirstName()}</span>
                                        </div>
                                    </a>
                                    <a href="/profile">
                                        <div class="profile"></div>
                                        <span>Account</span></a>

                                    <#include "${full_templates_path}/useraccout_menu.ftl" />
                                    <a href="/c/portal/logout">
                                        <div class="logout"></div>
                                        <span>Sign Out</span></a>
                                <#else>
                                    <a href="/signin">
                                        <div class="signin"></div>
                                        <span>Sign In</span></a>

                                </#if>
                            </div>
                        </div>
                    </#if>
                </div>
            </div>
            <!-- SUBHEADER -->
            <div class="shWrapper">
                <div class="shContainer">
                    <h2 class="themeSh">Singapore Chartered Accountant Qualification</h2>
                </div>
            </div>
        </header>
    </#if>


    <#include "${full_templates_path}/mobile-navigation.ftl" />

    <#assign cURLClass = "">
    <#if cURL == "" || cURL == "/login" || cURL == "/signup" || cURL == "/welcome" >
        <#assign cURLClass = 'full-width-page'>
    </#if>
    <#assign contentWrapClass ="">
    <#if is_signed_in &&  (themeDisplay.getLayout().isPrivateLayout() || themeDisplay.getPortalURL()?contains("ems.sambaash.com"))>
        <#assign contentWrapClass = 'privatePage'>
    </#if>
    <main class="main-content-wrap ${cURLClass} ${contentWrapClass}">
        <#if is_signed_in &&  (themeDisplay.getLayout().isPrivateLayout() || themeDisplay.getPortalURL()?contains("ems.sambaash.com")
        || themeDisplay.getPortalURL()?contains("mt.sambaash.com") )>
            <#include "${full_templates_path}/left-navigation.ftl" />
        </#if>
        <#if  samUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())>
        <div class="main-content rightSide admin" id="content" onclick="checkNav()">
            <#else>
            <div class="main-content rightSide" id="content" onclick="checkNav()">

                </#if>

                <#if is_signed_in &&  (themeDisplay.getLayout().isPrivateLayout() || themeDisplay.getPortalURL()?contains("ems.sambaash.com")
                || themeDisplay.getPortalURL()?contains("mt.sambaash.com") )>

                    <#include "${full_templates_path}/top-bar.ftl" />
                </#if>

                <#if selectable>
                    ${theme.include(content_include)}
                <#else>
                    ${portletDisplay.recycle()}

                    ${portletDisplay.setTitle(the_title)}

                    ${theme.wrapPortlet("portlet.ftl", content_include)}
                </#if>
            </div>
    </main>

    <#if !is_signed_in >
        <#include "${full_templates_path}/footer.ftl" />
    </#if>
    <div class="footerDiv"></div>
</div>

<script>
    var _ftSearchJsonItems = [];
    try {
        var str = ${samUtil.getParameter("free.text.search.pages",0)} +"";
        if (str.trim().length == 0) {
            _ftSearchJsonItems = [];
        } else {
            _ftSearchJsonItems = ${samUtil.getParameter("free.text.search.pages",0)};
        }

    } catch (e) {
        _ftSearchJsonItems = [];
    }

    function openNav() {

        setCookie("pin", "true", (24 * 60 * 60));
        showNav();
    }

    function showNav() {
        document.getElementById("sideNav").style.width = "290px";
        document.getElementById("content").style.marginLeft = "290px";
        document.getElementById("content").style.paddingLeft = "0px";
        var a = document.getElementById("content");
        a.classList.add("unpin-content");
        document.getElementById("sideNavRoot").style.display = "block";
        document.getElementById("navPin").style.display = "block";
        document.getElementById("menuIcon").style.display = "none";

    }

    function closeNav() {
        setCookie("pin", "false", (24 * 60 * 60));
        hideNav();
        document.getElementById("sideNavRoot").style.display = "none";

    }

    function hideNav() {

        if (document.getElementById("sideNav")) {
            document.getElementById("sideNav").style.width = "50px";
            document.getElementById("content").style.marginLeft = "0px";
            var a = document.getElementById("content");
            document.getElementById("menuIcon").style.display = "block";
            document.getElementById("sideNavRoot").style.display = "none";
            document.getElementById("navPin").style.display = "none";
            a.classList.remove("unpin-content");

        }
    }


    function togglePin() {
        if (getCookie("pin") == "true") {
            setCookie("pin", "false", (24 * 60 * 60));
            document.getElementById("navPin").innerHTML = "PIN";
            document.getElementById("sideNavRoot").style.display = "none";
            document.getElementById("menuIcon").style.display = "block";
            hideNav()
        } else {
            setCookie("pin", "true", (24 * 60 * 60));
            document.getElementById("navPin").innerHTML = "UNPIN";
            document.getElementById("menuIcon").style.display = "none";
        }
    }

    function checkNav() {
        if (getCookie("pin") != "true") {
            hideNav()
        }
    }


</script>

<script src="${themeDisplay.getPathThemeJavaScript()}/mobile-menu.js" type="text/javascript"></script>
<script src="${themeDisplay.getPathThemeJavaScript()}/script.js" type="text/javascript"></script>
<script src="${themeDisplay.getPathThemeJavaScript()}/ninja-slider-gallery.js" type="text/javascript"></script>
<script type="text/javascript" src="/html/js/sp/hook.js?1555059104" language="javascript1.2"></script>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

${theme.runtime("SPActivityHub_WAR_SPActivityHubportlet")}

</body>

</html>
