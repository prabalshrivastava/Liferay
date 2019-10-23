<#assign ogTitle = "" />
<#assign ogType = "" />
<#assign ogImage = "" />
<#assign ogUrl = "" />
<#assign ogVideo = "" />
<#assign ogVideoHeight = "" />
<#assign ogVideoWidth = "" />
<#assign ogAudio = "" />
<#assign ogSiteName = "" />
<#assign fbAppId = "" />
<#assign fbAdmins = "" />


<#if samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogTitle") != "">
	<#assign ogTitle = samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogTitle") />
</#if>
<#if samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogType") != "">
	<#assign ogType = samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogType") />
</#if>
<#if samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogImage") != "">
	<#assign ogImage = samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogImage") />
</#if>
<#if samUtil.getLayoutExpandoValueByAttribute(themeDisplay, " head_ogUrl") != "">
	<#assign ogUrl = samUtil.getLayoutExpandoValueByAttribute(themeDisplay, " head_ogUrl") />
</#if>
<#if samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogVideo") != "">
	<#assign ogVideo = samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogVideo") />
</#if>
<#if samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogVideoHeight") != "">
	<#assign ogVideoHeight = samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogVideoHeight") />
</#if>
<#if samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogVideoWidth") != "">
	<#assign ogVideoWidth = samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogVideoWidth") />
</#if>
<#if samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogAudio") != "">
	<#assign ogAudio = samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogAudio") />
</#if>
<#if samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogSiteName") != "">
	<#assign ogSiteName = samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_ogSiteName") />
</#if>
<#if samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_fbAppId") != "">
	<#assign fbAppId = samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_fbAppId") />
</#if>
<#if samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_fbAdmins") != "">
	<#assign fbAdmins = samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head_fbAdmins") />
</#if>

		<#if ogTitle != "">
        	<meta property="og:title" content="${ogTitle}"/>
        </#if>
        <#if ogType != "">
        <meta property="og:type" content="${ogType}"/>
         </#if>
        <#if ogImage != "">
        <meta property="og:image" content="${ogImage}"/>
         </#if>
        <#if ogUrl != "">
        <meta property="og:url" content="${ogUrl}"/>
         </#if>
        <#if ogVideo != "">
        <meta property="og:video" content="${ogVideo}"/>
         </#if>
        <#if ogVideoHeight != "">
        <meta property="og:video:height" content="${ogVideoHeight}"/>
         </#if>
        <#if ogVideoWidth != "">
        <meta property="og:video:width" content="${ogVideoWidth}"/>
         </#if>
        <#if ogAudio != "">
        <meta property="og:audio" content="${ogAudio}"/>
         </#if>
        <#if ogSiteName != "">
        <meta property="og:site_name" content="${ogSiteName}"/>
         </#if>
        <#if fbAppId != "">
        <meta property="og:app_id" content="${fbAppId}"/>
         </#if>
        <#if fbAdmins != "">
        <meta property="fb:admins" content="${fbAdmins}"/>
         </#if>

	
   
    ${samUtil.getLayoutExpandoValueByAttribute(themeDisplay, "head-javascript")}