<!DOCTYPE html>

<#include init />

<html prefix="og: http://ogp.me/ns#" class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>

	<#if themeDisplay.getPortalURL()?contains("www.lithan.com")>
        <link rel="manifest" href="/manifest.webmanifest">
	    <#include "${full_templates_path}/custom_tracking.ftl" />
		<#include "${full_templates_path}/fb-pixel.ftl" />
		<#include "${full_templates_path}/yahoo-pixel.ftl" />
	</#if>

	<title>${the_title} - ${company_name}</title>

    <#if themeDisplay.getPortalURL()?contains("sambaash.com")>
        <meta name="robots" content="noindex">
    </#if>

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

	${theme.include(top_head_include)}
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="${themeDisplay.getPathThemeCss()}/sp/sp_custom.css?minifierType=css" />

	<#if ogTitle??>
        <meta property="og:title" content="${ogTitle}"/>
    </#if>

    <#if ogDescription??>
        <meta property="og:description" content="${ogDescription}"/>
    </#if>

    <#if ogUrl??>
        <meta property="og:url" content="${ogUrl}"/>
    </#if>

    <#if ogImage??>
        <meta property="og:image" content="${ogImage}"/>
    </#if>

    <#if ogType??>
        <meta property="og:type" content="${ogType}"/>
    </#if>

    <#if ogVideo??>
        <meta property="og:video" content="${ogVideo}"/>
        <meta property="og:video:height" content="${ogVideoHeight}"/>
        <meta property="og:video:width" content="${ogVideoWidth}"/>
    </#if>

    <#if ogAudio??>
        <meta property="og:audio" content="${ogAudio}"/>
    </#if>

    <#if ogSiteName??>
        <meta property="og:site_name" content="${ogSiteName}"/>
    </#if>

    <#if fbAppId??>
        <meta property="og:app_id" content="${fbAppId}"/>
    </#if>

    <#if fbAdmins??>
        <meta property="fb:admins" content="${fbAdmins}"/>
    </#if>

    <#if themeDisplay.getPortalURL()?contains("www.lithan.com") && !themeDisplay.getURLCurrent()?contains("pereg")>
        <script type="text/javascript">
        window.$zopim||(function(d,s){var z=$zopim=function(c){z._.push(c)},$=z.s=
        d.createElement(s),e=d.getElementsByTagName(s)[0];z.set=function(o){z.set.
        _.push(o)};z._=[];z.set._=[];$.async=!0;$.setAttribute("charset","utf-8");
        $.src="https://v2.zopim.com/?4WqD241pwge0Ml20ANzSYTdwVRYVYCZR";z.t=+new Date;$.
        type="text/javascript";e.parentNode.insertBefore($,e)})(document,"script");
        </script>
    </#if>

    ${samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head-metatags")}
    ${samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head-javascript")}

</head>

<body class="${css_class}">

<#if themeDisplay.getPortalURL()?contains("www.lithan.com")>
  <#--  <#include "${full_templates_path}/gtm-body.ftl" /> -->
</#if>

<#assign cURL = themeDisplay.getURLCurrent()>

<a href="#main-content" id="skip-to-content"></a>

${theme.include(body_top_include)}


<#if samUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())>
	<@liferay.dockbar />
</#if>

<div class="container-fluid" id="wrapper">
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
</div>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}


<#if themeDisplay.getPortalURL()?contains("www.lithan.com")>
	<#include "${full_templates_path}/analytics.ftl" />
<#elseif themeDisplay.getPortalURL()?contains("lh.sambaash.com")>
	<#include "${full_templates_path}/analytics-stg.ftl" />
</#if>

<#if themeDisplay.getPortalURL()?contains("www.lithan.com")>
  <script type="text/javascript" src="upup.min.js"></script>
  <script>
    UpUp.start({
      'content-url': '/'
    });
  </script>
</#if>

</body>

</html>
