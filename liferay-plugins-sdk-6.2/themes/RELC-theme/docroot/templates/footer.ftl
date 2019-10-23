<footer id="footer" role="contentinfo" class="footer full-width light-gray-bg text-left block" data-track-content data-content-name="Footer">
	<div class="footer-wrap max-width full-width relative block box-sizing-border font-none">
		<div class="footer-section-left inline-block align-top box-sizing-border">
			<#include "${full_templates_path}/footerItems.ftl" >
			<nav class="footer-links footer-links-group footer-links-group inline-block align-top box-sizing-border text-left mobileNav3">
				<span class="group-title medium-gray">UPDATES</span>
				<ul class="list-bare font-10">
					<li class="inline-block padding-right-quarter">
							<span class="">Join Our Mailing List</span>
					</li>
					<li>
						<div class="subscribeContainer">
								<#assign campId = "mail.subscribe.campaign.id">
								<#assign VOID = freeMarkerPortletPreferences.setValue("campaignId", samUtil.getParameter(campId,0))>
								<#assign portletIdTemp = "mailsubscribe_WAR_SPMailportlet_INSTANCE_BBDDDFFFEEE" + samUtil.getParameter(campId,0)>
								${theme.runtime(portletIdTemp,'',freeMarkerPortletPreferences.toString())}
								<#assign VOID = freeMarkerPortletPreferences.reset()>
						</div>
					</li>
					<li class="mobilefooter-socialShare-container">
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
					</li>
				</ul>
			</nav>
			<nav class="footer-links footer-links-group footer-links-group inline-block align-top box-sizing-border text-right copyrightLinks">
				<div class="block margin-bottom-quarter">
					<span class="copyright">Copyright © 2018 SEAMEO RELC. All Rights Reserved</span>
					<ul class="list-bare font-10">
						<li class="block">
	                       	<a class="block link" href="/pdpp" target="_blank"><span>Personal Data Protection Policy</span></a>
	                   	</li>
						<li class="block">
	                       	<a class="block link" href="/privacy-statement" target="_blank"><span>Privacy Statement </span></a>
	                   	</li>
	                   	<li class="block">
	                        <a class="block link" href="/terms-of-use" target="_blank"><span>Terms of Use </span></a>
	                    </li>
					</ul>
				</div>
			</nav>
		</div>
		<div class="footerBrowser"><p>This website is best viewed in Google Chrome browser.</p></div>
	</div>	
</footer>
