<#assign theme_display = themeDisplay />
<#assign theme_settings = themeDisplay.getThemeSettings() />

<#assign themeColor1 = theme_settings["primary-color"] />
<#assign themeColor2 = theme_settings["secondary-color"] />
<#assign themeColor3 = theme_settings["tertiary-color"] />

<div>
	themecolor1 = ${themeColor1} , themecolor2 = ${themeColor2} , themecolor3 = ${themeColor3} 
</div>