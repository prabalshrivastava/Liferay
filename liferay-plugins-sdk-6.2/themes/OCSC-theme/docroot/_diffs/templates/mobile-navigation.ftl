<header class="main-header-mobile">
		<div class="heading-mobile">
				<div class="site-main-logo absolute pin-top-left inline-block ">
					<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						<img src="${themeDisplay.getPathThemeImages()}/menu/LithanHall_Logo2Footer.png" alt="logo" class="blackLogo">
					</a>

					<#if show_site_name>
						<span class="site-name hide" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
							${site_name}
						</span>
					</#if>
				</div>
			
			<#if is_signed_in>
			<div class="mobile-menu-head rippled absolute mobile_header_cta">
			<#else>
			<div class="mobile-menu-head rippled absolute mobile_header_cta mobile_header_cta_signout">
			</#if>
					<div class="mobileheaderSearch">
	                  	<div class="searchBtn"></div>
		                     <div class="dropdown-search" id="dropdown-search">
		                        <input type="text" placeholder="Search for a Course" id="mobile-headerSearchField">
		                        <div class="mobileheader_search_icon">
									<img src="${themeDisplay.getPathThemeImages()}/menu/mobilesearch.svg" alt="Search">
								</div>
	                    	</div>
	                 </div>
			
			
					<div class="dropdown">
	                  	<div class="dropbtn"></div>
		                     <div class="dropdown-content">
		                        <#if is_signed_in>
		                            <a href="/profile"><div class="profile"></div>My Profile</a>
		                            <a href="/c/portal/logout"><div class="logout"></div>Sign Out</a>
		                        <#else>
		                         	<a href="/signin"><div class="signin"></div>Signin</a>
		                            <a href="${portalUtil.getCreateAccountURL(request, themeDisplay)}"><div class="signup"></div>Signup</a>
		                        </#if>
	                    	</div>
	                 </div>

                    <div class="dropdown1">
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

            		
        	</div>    	
		
			</div>
				<#if is_signed_in>
					<#if has_navigation>
						<div class="mobile-navigation">
							<div class="mobile-navigation-button">
								<button class="mobile-menu-icon-hamburger rippled"><span></span></button>
							</div>
						
								<nav class="dl-menuwrapper dl-menu">
									<#include "${full_templates_path}/mobile-navigation-items.ftl" />
								</nav>
						</div>
					</#if>
				</#if>	
				
	
</header>

