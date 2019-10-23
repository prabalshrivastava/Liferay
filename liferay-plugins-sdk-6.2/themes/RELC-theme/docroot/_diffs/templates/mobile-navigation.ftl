<#assign cURL = themeDisplay.getURLCurrent()>
<#assign isShowSignin = samUtil.isShowSignIn(themeDisplay)>

<header class="main-header-mobile">
		<div class="heading-mobile">
			<div class="mobile-header-logo inline-block align-middle">
				<a class="${logo_css_class}" href="${site_default_url}" title="Home">
					<img src="${themeDisplay.getPathThemeImages()}/menu/mobileLogo.png" alt="logo" class="whiteLogo">
 				</a>
			</div>
			 <#if is_signed_in>
			       <div class="mobile_header_cta">
						<div class="user-dropdown-mobile">
                  <button class="dropbtn" style="background: none !important;"><img src="${themeDisplay.getUser().getPortraitURL(themeDisplay)}"></button>
                    <div class="dropdown-content-mobile" id="dropdown-content-mobile">
                        <#if is_signed_in>
                            <a href="/profile" class="userDetail"><div class="userDetailIcon"><img src="${themeDisplay.getUser().getPortraitURL(themeDisplay)}"><span>${themeDisplay.getUser().getFirstName()}</span></div></a>
	                         <a href="/profile"><div class="profile"></div><span>Account</span></a>
	                         <#include "${full_templates_path}/useraccout_menu.ftl" />
	                            <a href="/c/portal/logout"><div class="logout"></div><span>Sign Out</span></a>
                        <#else>
                         	<a href="/signin"><div class="signin"></div><span>Sign In</span></a>
                        </#if>
                    </div>
                    </div>
					
    			</div>
			         <#else>
			<#if samUtil.isShowSignIn(themeDisplay)>
			<div class="mobile_header_cta">
						<div class="user-dropdown-mobile">
                  <button class="dropbtn"></button>
                    <div class="dropdown-content-mobile" id="dropdown-content-mobile">
                        <#if is_signed_in>
                             <a href="/profile" class="userDetail"><div class="userDetailIcon"><img src="${themeDisplay.getUser().getPortraitURL(themeDisplay)}"><span>${themeDisplay.getUser().getFirstName()}</span></div></a>
	                         <a href="/profile"><div class="profile"></div><span>Account</span></a>
	                          <#include "${full_templates_path}/useraccout_menu.ftl" />
	                         <a href="/c/portal/logout"><div class="logout"></div><span>Sign Out</span></a>
                        <#else>
                         	<a href="/signin"><div class="signin"></div><span>Sign In</span></a>
                        </#if>
                    </div>
                    </div>
					
    			</div>
    			</#if>
    			</#if>
		</div>
		
		<#if has_navigation>
			<div class="mobile-navigation">
				<div class="mobile-navigation-button">
					<button class="mobile-menu-icon-hamburger">
						<span></span>
					</button>
				</div>
			
					<nav class="dl-menuwrapper dl-menu">
						<#include "${full_templates_path}/mobile-navigation-items.ftl" />
					</nav>
			</div>
		</#if>
</header>

