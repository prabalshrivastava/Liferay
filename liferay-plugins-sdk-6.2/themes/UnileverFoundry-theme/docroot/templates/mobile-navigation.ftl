<header class="main-header-mobile">
		<div class="heading-mobile">
			<div class="mobile-header-logo inline-block align-middle">
				<a class="${logo_css_class}" href="${site_default_url}" title="Home">
					<img src="${themeDisplay.getPathThemeImages()}/header-footer/logo_w.svg" alt="logo" class="whiteLogo">
 				</a>
			</div>
			
			
			<div class="mobile_header_cta">
					<#if is_signed_in>
								<#-- <div class="signedin_nav">
									<div class="signedin_prof">
										<#if themeDisplay.getUser().getPortrait(themeDisplay)>
											<img src="${themeDisplay.getUser().getPortrait(themeDisplay)}" alt="User Image"/>
											<span class="signedin_name">
												${themeDisplay.getUser().getFirstName()}
												
											</span>
									
										
										<#else>
											<span class="signedin_greetings">Hi!</span><span class="signedin_name">${themeDisplay.getUser().getFirstName()}</span>
									
										</#if>
		
									</div>
								</div> -->
		
					<#else>
						
						<span class="joinus"><a href="/signup" class="animate">REGISTER</a></span>
		    			<span class="joinus"><a href="/signin"  class="animate">SIGN IN</a></span>
					</#if>
					<div class="companyLogo2">
						<a href="http://www.unilever.com" target="_blank">
							<img src="${themeDisplay.getPathThemeImages()}/lp/UL-logo.svg"class="ul_white" width="35" height="40"  alt="Unilever Logo"/>
							<img src="${themeDisplay.getPathThemeImages()}/lp/UL-logo-gray.svg" class="ul_gray" width="35" height="40"  alt="Unilever Logo"/>
						</a>
					</div>   
    			</div>
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

