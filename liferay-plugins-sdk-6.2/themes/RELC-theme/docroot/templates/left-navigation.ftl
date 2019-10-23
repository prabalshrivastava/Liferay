
<#if  samUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())>
	<div id="sideNav" class="sideMenu admin" onclick="showNav()">
	<#else>
	<div id="sideNav" class="sideMenu" onclick="showNav()">
</#if>

<#if is_signed_in &&  (themeDisplay.getLayout().isPrivateLayout() || themeDisplay.getPortalURL()?contains("ems.sambaash.com")
                                     || themeDisplay.getPortalURL()?contains("mt.sambaash.com") )>
	<span class="menuIcon" id="menuIcon"  >&#9776;</span>
</#if>

<button class="btn btn-default unbinBtn" style="display:none" id="navPin"  onclick="togglePin()">PIN</button>

<#assign locale = localeUtil.getDefault()>
<#assign requestedLanguageId =  localeUtil.toLanguageId(locale)>


	<div id="sideNavRoot" style="display:none">
	<div class="userInfo">
		<div class="userImage">
			<img style="border-radius:50%; height:20px;width:20px" src="${themeDisplay.getUser().getPortraitURL(themeDisplay)}" alt="">    
		</div>
		
		<div class="userName">${themeDisplay.getUser().getFirstName()}</div>
		
	</div> 
	<ul>
		
		<li id="level2">
			
			<div class="content toggler-content-expanded" style="display:block;">
				<ul>
				
				<#assign counter1 = 0 >
				<#list nav_items as nav_item>
					<#assign nav_item_attr_has_popup = "" />
					<#assign nav_item_attr_selected = "" />
					<#assign nav_item_css_class = "" />
					<#assign counter1 = counter1 + 1>
		
					<#if nav_item.isSelected()>
						<#assign nav_item_attr_has_popup = "aria-haspopup='true'" />
						<#assign nav_item_attr_selected = "aria-selected='true'" />
						<#assign nav_item_css_class = "selected" />
					</#if>
					<li ${nav_item_attr_selected} class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">
						
						<#if !nav_item.hasChildren()>
							<h4 class="level-1-header" id="h4-header-${counter1}">
								<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem"><span>${nav_item.icon()} ${nav_item.getName()}</span></a>
							</h4>
						</#if>
						<#if nav_item.hasChildren()>
							<h4 class="level-1-header header toggler-header-collapsed" id="h4-header-${counter1}">
								<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem"><span>${nav_item.icon()} ${nav_item.getName()}</span></a>
							</h4>
						</#if>
						
						
						<#if nav_item.hasChildren()>
						<div class="content level-1 toggler-content-collapsed">
							<ul class="child-menu" role="menu">
								<#list nav_item.getChildren() as nav_child>
									<#assign nav_child_attr_selected = "" />
									<#assign nav_child_css_class = "" />
		
									<#if nav_item.isSelected()>
										<#assign nav_child_attr_selected = "aria-selected='true'" />
										<#assign nav_child_css_class = "selected" />
									</#if>
		
									<li ${nav_child_attr_selected} class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" role="presentation">
										
										<#if !nav_child.hasChildren()>
										<h4 class="level-2-header" id="h4-header-${counter1}">
											<a aria-labelledby="layout_${nav_child.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem"><span>${nav_child.icon()} ${nav_child.getName()}</span></a>
										</h4>
										</#if>
										<#if nav_child.hasChildren()>
										<h4 class="level-2-header header toggler-header-collapsed" id="h4-header-${counter1}">
											<a aria-labelledby="layout_${nav_child.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem"><span>${nav_child.icon()} ${nav_child.getName()}</span></a>
										</h4>
										</#if>
										
										<#if nav_child.hasChildren()>
										<div class="content level-2 toggler-content-collapsed">
											<ul class="child-menu" role="menu">
										<#list nav_child.getChildren() as nav_child_item>
											<#assign nav_child_item_attr_has_popup = "" />
											<#assign nav_child_item_attr_selected = "" />
											<#assign nav_child_item_css_class = "" />
											<#assign counter1 = counter1 + 1>

											<#if nav_child_item.isSelected()>
												<#assign nav_child_item_attr_has_popup = "aria-haspopup='true'" />
												<#assign nav_child_item_attr_selected = "aria-selected='true'" />
												<#assign nav_child_item_css_class = "selected" />
											</#if>
											<li ${nav_child_item_attr_selected} class="${nav_child_item_css_class}" id="layout_${nav_child_item.getLayoutId()}" role="presentation">
												
												<#if !nav_child_item.hasChildren()>
													<h4 class="level-3-header" id="h4-header-">
														<a aria-labelledby="layout_${nav_child_item.getLayoutId()}" ${nav_child_item_attr_has_popup} href="${nav_child_item.getURL()}" ${nav_child_item.getTarget()} role="menuitem"><span>${nav_child_item.icon()} ${nav_child_item.getName()}</span></a>
													</h4>
												</#if>
												<#if nav_child_item.hasChildren()>
													<h4 class="level-3-header header toggler-header-collapsed" id="h4-header-">
														<a aria-labelledby="layout_${nav_child_item.getLayoutId()}" ${nav_child_item_attr_has_popup} href="${nav_child_item.getURL()}" ${nav_child_item.getTarget()} role="menuitem"><span>${nav_child_item.icon()} ${nav_child_item.getName()}</span></a>
													</h4>
												</#if>
												
												
												<#if nav_child_item.hasChildren()>
												<div class="content level-3 toggler-content-collapsed">
													<ul class="child-menu" role="menu">
														<#list nav_child_item.getChildren() as nav_child_child>
															<#assign nav_child_attr_selected = "" />
															<#assign nav_child_css_class = "" />

															<#if nav_child_item.isSelected()>
																<#assign nav_child_attr_selected = "aria-selected='true'" />
																<#assign nav_child_css_class = "selected" />
															</#if>

															<li ${nav_child_attr_selected} class="${nav_child_css_class}" id="layout_${nav_child_child.getLayoutId()}" role="presentation">
																
																
																
																
																
																<a aria-labelledby="layout_${nav_child_child.getLayoutId()}" href="${nav_child_child.getURL()}" ${nav_child_child.getTarget()} role="menuitem">${nav_child_child.getName()}</a>
															</li>
														</#list>
													</ul>
												</div>
												</#if>
											</li>
										</#list>
											</ul>
										</div>
										</#if>
										
										
										
										
										
									</li>
								</#list>
							</ul>
						</div>
						</#if>
					</li>
				</#list>
			
				</ul>

				
			</div>
		</li>
		
	</ul>
	</div>
</div>
<script>
YUI().use(
  'aui-toggler',
  function(Y) {
    new Y.TogglerDelegate(
      {
        animated: true,
        closeAllOnExpand: true,
        container: '#level2',
        content: '.content',
        expanded: false,
        header: '.header',
        transition: {
          duration: 0.2,
          easing: 'cubic-bezier(0, 0.1, 0, 1)'
        }
      }
    );
  }
);

</script>

<script>
AUI().use('event-base', function(A) {
		A.on('domready', function() {
		
		
		var selectedmenu =  document.querySelector(".selected-menu");
		if(selectedmenu != null){
			var dd = selectedmenu.closest(".toggler-content");
			dd.classList.add("toggler-content-expanded");
			dd.classList.remove("toggler-content-collapsed");
			dd.previousElementSibling.classList.remove("toggler-header-collapsed");
			dd.previousElementSibling.classList.add("toggler-header-expanded");
		}
		if(document.getElementById("navPin")) {
			if(getCookie("pin") == "true"){
				showNav();

				document.getElementById("navPin").innerHTML = "UNPIN";

			}else{
				hideNav();
				document.getElementById("navPin").innerHTML = "PIN";
			}
		}
		
		});
	});
	
</script>