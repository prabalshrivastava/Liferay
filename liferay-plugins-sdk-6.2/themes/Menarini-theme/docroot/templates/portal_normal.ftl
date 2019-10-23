<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

	${theme.include(top_head_include)}

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="${themeDisplay.getPathThemeCss()}/sp/sp_custom.css" />


	 <#include "${full_templates_path}/ogTagValues.ftl" />

	${samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head-javascript")}

</head>

<body class="${css_class}">

<#assign cURL = themeDisplay.getURLCurrent()>

<a href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

${theme.include(body_top_include)}


<#if is_signed_in>
	<@liferay.dockbar />
</#if>

<div class="container-fluid" id="wrapper">

	<header class="main-header fixed block pin-left pin-right pin-top  full-width " id="banner" role="banner">

			<div class=" block padding-left-half padding-right-half full-width relative" id="heading">

				<div class="site-main-logo absolute pin-top-left inline-block ">
					<a class="${logo_css_class}" href="/home" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						<!-- <img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" /> -->
						<img src="${themeDisplay.getPathThemeImages()}/header-footer/logo_w.svg" alt="logo" class="whiteLogo">
						<img src="${themeDisplay.getPathThemeImages()}/header-footer/logo.svg" alt="logo" class="blackLogo">
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

					<#if is_signed_in &&  !samUtil.isNonAdUser(user) && layout.isPublicLayout() && samUtil.showNotificationIconOnDockbar() == false>
						<div class="inline-block notificationsDiv">
							${theme.runtime("2_WAR_notificationsportlet")}
						</div>
					</#if>

					<#if is_signed_in>

						<#if !samUtil.isNonAdUser(user) && layout.isPublicLayout() >
                                        <div class="header-tools">


                                                <div class="header-tools-content">

                                                        <div class="header-tools-list">
                                                                <ul>
                                                                        <li>
                                                                                <a href="/wiki/user-guide">
                                                                                        <img src="/Menarini-theme/images/menu/UserGuide.png" alt="UserGuide" title="User Guide" />
                                                                                </a>
                                                                        </li>
                                                                        <li>
                                                                                <a href="/open-search">
                                                                                        <img src="/Menarini-theme/images/menu/Search.png" alt="Search" title="Search"/>
                                                                                </a>
                                                                        </li>
                                                                         <li>
                                                                                <a href="/feedback">
                                                                                        <img src="/Menarini-theme/images/menu/Feedback.png" alt="Feedback" title="Feedback"/>
                                                                                </a>
                                                                        </li>
                                                                </ul>
                                                        </div>
                                                         </div>
                                                          </div>
                                                          <div class="headerLanguage">
                                         ${theme.runtime("82")}
                                         </div>
                                         </#if>
                        <#if samUtil.isNonAdUser(user)>
                        	<#assign signedinnavclass="signedin_nav">
                        <#else>
                        	<#assign signedinnavclass="signedin_nav_no_bcg">
                        </#if>
						<div class="${signedinnavclass}">
							<div class="signedin_prof">
								<#if themeDisplay.getUser().getPortraitURL(themeDisplay) != '' >
									<!-- <img src="${themeDisplay.getUser().getPortraitURL(themeDisplay)}" alt="prof avatar"/> -->
									<span class="signedin_name">
										${themeDisplay.getUser().getFirstName()}

									</span>


								<#else>
									<span class="signedin_greetings">Hi!</span><span class="signedin_name">${themeDisplay.getUser().getFirstName()}</span>

								</#if>

							</div>
							<#if samUtil.isNonAdUser(user)>
								<ul class="signedin_menu maxChar">
									<li>
	    								<a href="/c/portal/logout"><b>Sign Out</b></a>
	    							</li>
								</ul>
							</#if>
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

	<footer class="footer">
                <div class="siteFooter  boxPadding">

               <div class="footerInfo">
                        <div class="copyright">
                        Copyright &copy;2017 Menarini. All rights reserved.
                    </div>
                    <div class="footerLinks">
                         <p class="powered-by"><a href="/terms-of-use"> Terms of Use </a> | <a href="/privacy-policy"> Privacy Policy </a> |  Powered By <a href="https://www.sambaash.com" rel="external" target="_blank">Sambaash</a> </p>
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


<#if themeDisplay.getPortalURL()?contains("connect.menariniapac.com")>
	<#include "${full_templates_path}/analytics.ftl" />
</#if>

</body>

</html>
