<header class="main-header-mobile">
		<div class="heading-mobile">
			<div class="mobile-header-logo inline-block align-middle">
				<a class="${logo_css_class}" href="${site_default_url}" >
					<img src="${themeDisplay.getPathThemeImages()}/header-footer/logo.svg" alt="logo" class="whiteLogo">
 				</a>
			</div>
			
		</div>
		
		<#if has_navigation>
			<div class="mobile-navigation">
				<div class="mobile-navigation-button">
					<button class="mobile-menu-icon-hamburger">
						<span></span>
					</button>
				</div>
			
					<nav class="dl-menuwrapper dl-menu mobile-menu">
						<#include "${full_templates_path}/mobile-navigation-items.ftl" />
					</nav>
			</div>
		</#if>
</header>

