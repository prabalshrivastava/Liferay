<header class="main-header-mobile" id="mobileBanner">
		<div class="heading-mobile">
				<div class="site-main-logo absolute pin-top-left inline-block ">
					<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						<img src="${site_logo}" alt="logo" class="blackLogo">
					</a>

					<#if show_site_name>
						<span class="site-name hide" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
							${site_name}
						</span>
					</#if>
				</div>
			
			
			<div class="mobile-menu-head rippled absolute mobile_header_cta">
			
					
					<!-- <div class="dropdown">
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
	                 </div>-->
            		
        	</div>    	
		
			</div>
			
					<#if has_navigation>
						<div class="mobile-navigation">
						    <div class="inline-block requestDemo"> <a href="#reqDemoSambaash"><span>Request Demo</span></a> </div>
							<div class="mobile-navigation-button">
								<button class="mobile-menu-icon-hamburger rippled"><span></span></button>
							</div>
						
								<nav class="dl-menuwrapper dl-menu">
									<#include "${full_templates_path}/mobile-navigation-items.ftl" />
								</nav>
						</div>
					</#if>
			
				
	
</header>

