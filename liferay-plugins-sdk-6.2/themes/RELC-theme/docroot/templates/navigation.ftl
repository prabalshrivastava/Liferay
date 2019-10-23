
	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar" class="main-navigation-list font-none dl-menu" >
		<#if nav_items?? >
		<#assign menuCount = 0 />
		<#assign signinClass = "signedOut" />
		<#if is_signed_in && samUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())>
		<#assign signinClass = "signedIn" />
		</#if>
		<#assign isAdminClass = "notAdmin" />
		<#if samUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())>
		<#assign isAdminClass = "itsAdmin" />
		</#if>
		<#assign showSingin = "hideSingin" />
		<#if samUtil.isShowSignIn(themeDisplay)>
		<#assign showSingin = "showSingin" />
		</#if>
		<#if !samUtil.isShowSignIn(themeDisplay) && is_signed_in>
		<#assign showSingin = "showSingin" />
		</#if>
		<#list nav_items as nav_item>
			<#assign nav_item_attr_has_popup = "" />
			<#assign nav_item_attr_selected = "" />
			<#assign nav_item_css_class = "" />
			<#assign show_nav_item = "true" />
			
		<#if (samUtil.getExpandoValueString(nav_item.getLayout().getExpandoBridge(), "Header", themeDisplay) == "true")>
			<#if nav_item.isSelected()>
				<#assign nav_item_attr_has_popup = "aria-haspopup='true'" />
				<#assign nav_item_attr_selected = "aria-selected='true'" />
				<#assign nav_item_css_class = "selected" />
			</#if>
			
			<#if show_nav_item == 'true'>
			
				<!-- ${nav_item_css_class} removed this class name from below li, to stop editing pagename from menu-->
				<li ${nav_item_attr_selected} class="nav-list-item font-12" id="layout_${nav_item.getLayoutId()}}" role="presentation" >
					<#if nav_item.getName() != 'Home'>
						<a aria-labelledby="layout_${nav_item.getLayoutId()}"  ${nav_item_attr_has_popup} class="${nav_item_css_class}" href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem">
					<#else>
						<a aria-labelledby="layout_${nav_item.getLayoutId()}"  ${nav_item_attr_has_popup} class="${nav_item_css_class} homeIconLink" href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem">
					</#if>
					<#if nav_item.getName() != 'Admin'>
						<#if nav_item.getName() != 'Home'>
							<span>${nav_item.getName()}</span>
						<#else>
							<span><img alt="Home" src="${theme_display.getPathThemeImages()}/menu/icon-home.svg" class="resizeImage homeIcon" /></span>
						</#if>	
					<#else>
						<span><img alt="Admin" src="${theme_display.getPathThemeImages()}/menu/RELC-Settings.svg" class="resizeImage" /></span>
					</#if>
					
					<#if nav_item.hasChildren()>
						<#list nav_item.getChildren() as nav_child>
							<#assign childNav = "true" />
						</#list>
						<#if (childNav == "true")>
							<img alt="Menu Drop Down" src="${theme_display.getPathThemeImages()}/menu/menuDropDownIcon1.png" class="resizeImage"/>
						</#if>
					</#if>
					</a>
					
					<#if nav_item.hasChildren()>
					<#if (menuCount >= 1)>
						<ul class="${signinClass} ${isAdminClass} child-menu-left${menuCount} ${showSingin} child-menu" role="menu">
					<#else>	
					<ul class="${signinClass} ${isAdminClass} child-menu ${showSingin}" role="menu">
					</#if>
							<#list nav_item.getChildren() as nav_child>
							<#assign childNav1 = "false" />
								<#assign nav_child_attr_selected = "" />
								<#assign nav_child_css_class = "" />
								<#if nav_child.isSelected()>
									<#assign nav_child_attr_selected = "aria-selected='true'" />
									<#assign nav_child_css_class = "selected" />
								</#if>
	
								<li ${nav_child_attr_selected} class="${nav_child_css_class} nav-list-item-child" id="layout_${nav_child.getLayoutId()}" role="presentation" onMouseOver='javascript:changeDropDownHeight("layout_${nav_child.getLayoutId()}")' onMouseOut='javascript:restoreDropDownHeight("layout_${nav_child.getLayoutId()}")'>
									<a aria-labelledby="layout_${nav_child.getLayoutId()}" class="${nav_child_css_class}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">
										<span>${nav_child.getName()}</span>
										<#list nav_child.getChildren() as nav_child>
											<#assign childNav1 = "true" />
										</#list>
										<#if (childNav1 == "true")>
										<#if (menuCount >= 1)>
										<i class="icon icon-chevron-left"></i>
										<#else>
										<i class="icon icon-chevron-right"></i>
										</#if>
										</#if>
									</a>
									<#if nav_child.hasChildren()>
									<#if (menuCount >= 1)>
										<ul class="${signinClass} ${isAdminClass} child-child-menu-left${menuCount} ${showSingin}" role="menu">
									<#else>	
										<ul class="${signinClass} ${isAdminClass} child-menu ${showSingin}" role="menu">
									</#if>
											<#list nav_child.getChildren() as nav_child_child>
											<#assign childNav2 = "false" />
												<#assign nav_child_child_attr_selected = "" />
												<#assign nav_child_child_css_class = "" />
												
												<#if nav_child_child.isSelected()>
													<#assign nav_child_child_attr_selected = "aria-selected='true'" />
													<#assign nav_child_child_css_class = "selected" />
												</#if>
												
												<li ${nav_child_child_attr_selected} class="${nav_child_child_css_class} nav_child_child_css_class nav-list-item-child-child" id="layout_${nav_child_child.getLayoutId()}" role="presentation" onMouseOver='javascript:changeDropDownHeight("layout_${nav_child_child.getLayoutId()}")' onMouseOut='javascript:restoreDropDownHeight("layout_${nav_child_child.getLayoutId()}")'>
													<a aria-labelledby="layout_${nav_child_child.getLayoutId()}" class="${nav_child_child_css_class}" href="${nav_child_child.getURL()}" ${nav_child_child.getTarget()} role="menuitem">
														<span>${nav_child_child.getName()}</span>
														<#list nav_child_child.getChildren() as nav_child>
															<#assign childNav2 = "true" />
														</#list>
														<#if (childNav2 == "true")>
														<#if (menuCount >= 1)>
														<i class="icon icon-chevron-left"></i>
														<#else>
														<i class="icon icon-chevron-right"></i>
														</#if>
														</#if>
													</a>
													<#if nav_child_child.hasChildren()>
														<ul class="child-menu" role="menu">
															<#list nav_child_child.getChildren() as nav_child_child_child>
																<#assign nav_child_child_child_attr_selected = "" />
																<#assign nav_child_child_child_css_class = "" />
																
																<#if nav_child_child_child.isSelected()>
																	<#assign nav_child_child_child_attr_selected = "aria-selected='true'" />
																	<#assign nav_child_child_child_css_class = "selected" />
																</#if>
																
																<li ${nav_child_child_child_attr_selected} class="${nav_child_child_child_css_class} nav_child_child_child_css_class nav-list-item-child-child_child" id="layout_${nav_child_child_child.getLayoutId()}" role="presentation">
																	<a aria-labelledby="layout_${nav_child_child_child.getLayoutId()}" class="${nav_child_child_child_css_class}" href="${nav_child_child.getURL()}" ${nav_child_child_child.getTarget()} role="menuitem">
																		<span>${nav_child_child_child.getName()}</span>
																	</a>
																</li>
															</#list>
														</ul>
													</#if>
												</li>
											</#list>
										</ul>
									</#if>
								</li>
							</#list>
						</ul>
					</#if>
				</li>
			
			</#if>
			<#assign menuCount = menuCount+1 />
</#if>
		</#list>
		</#if>
	</ul>
