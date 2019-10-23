<#if nav_items?? >
<#assign navCount = 1 />
<#list navItems as nav_item>
		<#if (samUtil.getExpandoValueString(nav_item.getLayout().getExpandoBridge(), "Footer Right", themeDisplay) == "true")>
		<#if nav_item.hasChildren()>
		<#assign navClass = "mobileNav"+navCount>
    		<nav class="footer-links footer-links-group footer-links-group inline-block align-top box-sizing-border text-left ${navClass}">
				<span class="group-title medium-gray" data-track-content data-content-name="Footer ${nav_item.getName()}">${nav_item.getName()}</span>
				<ul class="list-bare font-10">
    				<#list nav_item.getChildren() as nav_child>
							<li class="block" data-track-content data-content-name="Footer ${nav_item.getName()}" data-content-piece="${nav_child.getName()}" data-content-target="${nav_child.getURL()}" >
								<a href="${nav_child.getURL()}" target="_self" class="link">
									<span class="">${nav_child.getName()}</span>
								</a>
							</li>
					</#list>
					<li class="footer-socialShare-container">
							<#if (navCount == 2)>
								<span class="group-title medium-gray" data-track-content data-content-name="Footer Social Connect">Social Connect</span>
								<ul class="footer-socialShare"> 
									<li> 
										<a title="Facebook" href="https://www.facebook.com/SeameoRELC/" target="_blank"> <img src="/RELC-theme/images/social_icons/icon-fb.svg" alt="FaceBook"> </a> 
									</li> 
									<li> 
										<a target="_blank" title="Twitter" href="https://twitter.com/SeameoRELC"> <img src="/RELC-theme/images/social_icons/icon-tw.svg" alt="Twitter"> </a> 
									</li> 
									<li> 
										<a target="_blank" title="Instagram" href="https://www.instagram.com/seameorelc/"> <img src="/RELC-theme/images/social_icons/icon-ig.png" alt="GPlus"> </a> 
									</li> 
								</ul>
							</#if>
							</li>
    			</ul>
    		</nav>
    		<#assign navCount = navCount+1 />
		</#if>
		</#if>
</#list>
</#if>
