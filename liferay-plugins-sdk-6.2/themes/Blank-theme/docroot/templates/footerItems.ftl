<#list navItems as nav_item>
		<#if samUtil.getExpandoValueString(nav_item.getLayout().getExpandoBridge(),"Footer Right", themeDisplay) == "true">
		<#if nav_item.hasChildren()>
    		<nav class="footer-links footer-links-group footer-links-group inline-block align-top box-sizing-border text-left">
    			<span class="group-title medium-gray">${nav_item.getName()}</span>
				<ul class="list-bare font-10">
    				<#list nav_item.getChildren() as nav_child>
    					<#if samUtil.getExpandoValueString(nav_item.getLayout().getExpandoBridge(),"Footer Right", themeDisplay) == "true">
							<li class="block">
								<a href="${nav_child.getURL()}" target="_self" class="link">
									<span class="">${nav_child.getName()}</span>
								</a>
							</li>
						</#if>	
					</#list>
    			</ul>
    		</nav>
		</#if>
	</#if>
</#list>
