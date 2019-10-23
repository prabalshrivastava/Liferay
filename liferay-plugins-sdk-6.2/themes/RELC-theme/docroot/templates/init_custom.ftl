<#--
This file allows you to override and define new FreeMarker variables.
-->
<#assign samUtil = staticUtil["com.sambaash.platform.util.SambaashUtil"]>
<#assign portalUtil = staticUtil["com.liferay.portal.util.PortalUtil"]>
<#assign samConstants = staticUtil["com.sambaash.platform.constant.SambaashConstants"]>
<#assign navUtil = staticUtil["com.sambaash.platform.util.NavigationUtil"]>
<#assign localizationUtil = staticUtil["com.liferay.compat.portal.kernel.util.LocalizationUtil"]>
<#assign localeUtil = staticUtil["com.liferay.portal.kernel.util.LocaleUtil"]>

<#assign dashBoardLink = samUtil.getDashBoard()> 