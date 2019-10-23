
	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar" class="main-navigation-list font-none dl-menu">
		<#if nav_items?? >
		<#list nav_items as nav_item>
			<#assign nav_item_attr_has_popup = "" />
			<#assign nav_item_attr_selected = "" />
			<#assign nav_item_css_class = "" />
		
			 <#if (samUtil.getExpandoValueString(nav_item.getLayout().getExpandoBridge(), "Header", themeDisplay) == "true")>
			
			<#if nav_item.isSelected()>
				<#assign nav_item_attr_has_popup = "aria-haspopup='true'" />
				<#assign nav_item_attr_selected = "aria-selected='true'" />
				<#assign nav_item_css_class = "selected" />
			</#if>
			
			<#if nav_item.getName() != 'Home'>
			<!-- ${nav_item_css_class} removed this class name from below li -- to stop editing pagename from menu-->
			<li ${nav_item_attr_selected} class="nav-list-item font-12 inline-block" id="layout_${nav_item.getLayoutId()}" role="presentation" >
				<a aria-labelledby="layout_${nav_item.getLayoutId()}"  ${nav_item_attr_has_popup} class="${nav_item_css_class}" href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem">
				<span>${nav_item.getName()}</span>
				<#if nav_item.hasChildren()>
					<#list nav_item.getChildren() as nav_child>
						<#if (samUtil.getExpandoValueString(nav_child.getLayout().getExpandoBridge(), "Header", themeDisplay) == "true")>
							<#assign childNav = "true" />
						<#else>
							<#assign childNav = "false" />
						</#if>
					</#list>
					<#if (childNav == "true")>
						<img src="${theme_display.getPathThemeImages()}/menu/menuDropDownIcon1.png" class="resizeImage"/>
					</#if>
				</#if>
				</a>
				
				<#if nav_item.hasChildren()>
					<ul class="child-menu " role="menu">
						<#list nav_item.getChildren() as nav_child>
							<#assign nav_child_attr_selected = "" />
							<#assign nav_child_css_class = "" />
							<#if (samUtil.getExpandoValueString(nav_child.getLayout().getExpandoBridge(), "Header", themeDisplay) == "true")>
							<#if nav_child.isSelected()>
								<#assign nav_child_attr_selected = "aria-selected='true'" />
								<#assign nav_child_css_class = "selected" />
							</#if>

							<li ${nav_child_attr_selected} class="${nav_child_css_class} inline-block nav-list-item-child" id="layout_${nav_child.getLayoutId()}" role="presentation">
								<a aria-labelledby="layout_${nav_child.getLayoutId()}" class="${nav_child_css_class}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">
									<span>${nav_child.getName()}</span>
								</a>
								<#if nav_child.hasChildren()>
									<ul class="child-menu" role="menu">
										<#list nav_child.getChildren() as nav_child_child>
										<#if (samUtil.getExpandoValueString(nav_child_child.getLayout().getExpandoBridge(), "Header", themeDisplay) == "true")>
											<#assign nav_child_child_attr_selected = "" />
											<#assign nav_child_child_css_class = "" />
											
											<#if nav_child_child.isSelected()>
												<#assign nav_child_child_attr_selected = "aria-selected='true'" />
												<#assign nav_child_child_css_class = "selected" />
											</#if>
											
											<li ${nav_child_child_attr_selected} class="${nav_child_child_css_class} nav_child_child_css_class inline-block nav-list-item-child-child" id="layout_${nav_child_child.getLayoutId()}" role="presentation">
												<a aria-labelledby="layout_${nav_child_child.getLayoutId()}" class="${nav_child_child_css_class}" href="${nav_child_child.getURL()}" ${nav_child_child.getTarget()} role="menuitem">
													<span>${nav_child_child.getName()}</span>
												</a>
											</li>
											</#if>
										</#list>
									</ul>
								</#if>
							</li>
							</#if>
						</#list>
					</ul>
				</#if>
			</li>
			</#if>
</#if>
		</#list>
		</#if>
	</ul>
