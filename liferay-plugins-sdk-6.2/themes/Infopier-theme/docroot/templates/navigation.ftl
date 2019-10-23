
	<ul aria-label="<@liferay.language key="site-pages" />" role="menubar" class="main-navigation-list font-none dl-menu">
		<#if nav_items?? >
		<#assign index=0>
		<#list nav_items as nav_item>
			<#assign nav_item_attr_has_popup = "" />
			<#assign nav_item_attr_selected = "" />
			<#assign nav_item_css_class = "" />
            <#assign index = index + 1>
		
			<#if nav_item.isSelected()>
				<#assign nav_item_attr_has_popup = "aria-haspopup='true'" />
				<#assign nav_item_attr_selected = "aria-selected='true'" />
				<#assign nav_item_css_class = "selected" />
			</#if>
			
			<!-- ${nav_item_css_class} removed this class name from below li -- to stop editing pagename from menu-->
			<li ${nav_item_attr_selected} class="nav-list-item font-12 inline-block" id="menu${index}" role="presentation" >
				<a aria-labelledby="layout_${nav_item.getLayoutId()}"  ${nav_item_attr_has_popup} class="${nav_item_css_class}" href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem">
				<span>${nav_item.getName()}</span>
				<#if nav_item.hasChildren()>
						<img src="${theme_display.getPathThemeImages()}/menu/menuDropDownIcon1.png" class="resizeImage" alt="Menu drop down"/>
				</#if>
				</a>
				
				<#if nav_item.hasChildren()>
					<ul class="child-menu " role="menu">
						<#list nav_item.getChildren() as nav_child>
							<#assign nav_child_attr_selected = "" />
							<#assign nav_child_css_class = "" />
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
											
											<#if nav_child.hasChildren()>
												<ul class="child-menu" role="menu">
													<#list nav_child.getChildren() as nav_child_child_child>
														<#assign nav_child_child_child_attr_selected = "" />
														<#assign nav_child_child_child_css_class = "" />
														
														<#if nav_child_child.isSelected()>
															<#assign nav_child_child_child_attr_selected = "aria-selected='true'" />
															<#assign nav_child_child_child_css_class = "selected" />
														</#if>
														
														<li ${nav_child_child_child_attr_selected} class="${nav_child_child_child_css_class} nav_child_child_child_css_class inline-block nav-list-item-child-child-child" id="layout_${nav_child_child_child.getLayoutId()}" role="presentation">
															<a aria-labelledby="layout_${nav_child_child_child.getLayoutId()}" class="${nav_child_child_child_css_class}" href="${nav_child_child_child.getURL()}" ${nav_child_child.getTarget()} role="menuitem">
																<span>${nav_child_child_child.getName()}</span>
															</a>
														</li>
													</#list>
												</ul>
											</#if>
										</#list>
									</ul>
								</#if>
							</li>
						</#list>
					</ul>
				</#if>
			</li>
		</#list>
		</#if>
		<li class="topmenu menu_more_item">
                <a href="#"><span>More</span>
                <img src="${theme_display.getPathThemeImages()}/menu/menuDropDownIcon1.png" class="resizeImage" alt="Menu drop down"/>
                </a>
                <ul class="extmenu">


                </ul>

            </li>
	</ul>
	
	<script type="text/javascript">


var resized = true;

YUI().use('node', 'event', function (Y) {

	var ext_menuNo;
    var menu = Y.one('.main-navigation-list');

    var menuListSize = menu.all('li.nav-list-item').size();

    var menuListSize_temp = menuListSize;
    var menuOver;
    var tempMenuItemContent;
    //var screenWidth = Y.one('html').get('offsetWidth');
    var screenWidth = document.body.clientWidth;

    menu.one('li.menu_more_item').setStyle('display', 'none');


    Y.on('windowresize', function () {
        screenWidth = document.body.clientWidth;
        var scr = screenWidth;

       // console.log(scr);
        //loadScreen();

    });
	
	 if (menuListSize_temp < 6) {
                menu.one('li.menu_more_item').remove(true);
     }

    loadScreen();

    function loadScreen() {


        console.log(screenWidth);
        if (screenWidth > 1100 && resized) {

            //alert("Screen size is: " +screenWidth);
		 	ext_menuNo = 1;
            if (menuListSize_temp > 6) {


                menuOver = menuListSize - 6;
                menuListSize_temp = menuListSize_temp - menuOver;
                //alert("Menu Items: " +menuListSize+ " (exceeds 7 items)");

                menu.one('li.menu_more_item').setStyle('display', 'inline-block');

                menu.one('li.menu_more_item').setStyle('float', 'right');


                resized = false;
                //alert("Resized: " +resized);

                //alert(menuListSize);
				//console.log("menuListSize " + menuListSize);

                for (var i = 7; i <= menuListSize; i++) {

                    var list_menu_item = document.getElementById('menu' + i);

                    //alert("Ready! yyyy " +i);
                    //alert("?" + i);


                    tempMenuItemContent = list_menu_item.innerHTML;
                    menu.one('li#menu' + i).setStyle('display', 'none');
                    //alert(tempMenuItemContent);
                    //alert("Excess Content: " + tempMenuItemContent);
                    menu.one('li.menu_more_item ul.extmenu').append('<li class="ext_menu' + ext_menuNo + '">' + tempMenuItemContent + '</li>');
					ext_menuNo++;

                }


            }

            


        }


        else if (screenWidth <= 1100 && screenWidth > 1000) {

            //alert("Screen Size is between 1000 and 1100");
            resized = true;


            if (menuListSize_temp > 5 && resized) {

                menuOver = menuListSize_temp - 5;
                menuListSize_temp = menuListSize_temp - menuOver;


                menu.one('li.menu_more_item').setStyle('display', 'inline-block');
                menu.one('li.menu_more_item').setStyle('float', 'left');
                resized = false;
                menu.all('li.menu_more_item ul.extmenu li').remove();

                for (var i = 6; i <= menuListSize; i++) {


                    var list_menu_item = document.getElementById('menu' + i);

                    //alert("Ready! yyyy " +i);


                    tempMenuItemContent = list_menu_item.innerHTML;
                    menu.one('li#menu' + i).setStyle('display', 'none');
                    //alert(tempMenuItemContent);
                    //alert("Excess Content: " + tempMenuItemContent);
                    menu.one('li.menu_more_item ul.extmenu').append('<li>' + tempMenuItemContent + '</li>');

                }
            }
        }


        else if (screenWidth <= 1000 && screenWidth > 900) {

            //alert("Screen Size is between 900 and 1000");
            resized = true;


            if (menuListSize_temp > 5 && resized) {

                menuOver = menuListSize_temp - 5;
                menuListSize_temp = menuListSize_temp - menuOver;


                menu.one('li.menu_more_item').setStyle('display', 'inline-block');
                resized = false;
                menu.all('li.menu_more_item ul.extmenu li').remove();

                for (var i = 6; i <= menuListSize; i++) {

                    var list_menu_item = document.getElementById('menu' + i);

                    //alert("Ready! yyyy " +i);


                    tempMenuItemContent = list_menu_item.innerHTML;
                    menu.one('li#menu' + i).setStyle('display', 'none');
                    //alert(tempMenuItemContent);
                    //alert("Excess Content: " + tempMenuItemContent);
                    menu.one('li.menu_more_item ul.extmenu').append('<li>' + tempMenuItemContent + '</li>');

                }
            }
        }

        else if (screenWidth <= 900 && screenWidth > 800) {

            //alert("Screen Size is between 800 and 900");
            resized = true;


            if (menuListSize_temp > 4 && resized) {

                menuOver = menuListSize_temp - 4;
                menuListSize_temp = menuListSize_temp - menuOver;


                menu.one('li.menu_more_item').setStyle('display', 'inline-block');
                resized = false;
                menu.all('li.menu_more_item ul.extmenu li').remove();

                for (var i = 5; i <= menuListSize; i++) {

                    var list_menu_item = document.getElementById('menu' + i);

                    //alert("Ready! yyyy " +i);


                    tempMenuItemContent = list_menu_item.innerHTML;
                    menu.one('li#menu' + i).setStyle('display', 'none');
                    //alert(tempMenuItemContent);
                    //alert("Excess Content: " + tempMenuItemContent);
                    menu.one('li.menu_more_item ul.extmenu').append('<li>' + tempMenuItemContent + '</li>');

                }
            }
        }

        else if (screenWidth <= 800 && screenWidth > 700) {

            //alert("Screen Size is between 700 and 800");
            resized = true;


            if (menuListSize_temp > 3 && resized) {

                menuOver = menuListSize_temp - 3;
                menuListSize_temp = menuListSize_temp - menuOver;


                menu.one('li.menu_more_item').setStyle('display', 'inline-block');
                resized = false;
                menu.all('li.menu_more_item ul.extmenu li').remove();

                for (var i = 4; i <= menuListSize; i++) {

                    var list_menu_item = document.getElementById('menu' + i);

                    tempMenuItemContent = list_menu_item.innerHTML;
                    menu.one('li#menu' + i).setStyle('display', 'none');
                    //alert(tempMenuItemContent);
                    //alert("Excess Content: " + tempMenuItemContent);
                    menu.one('li.menu_more_item ul.extmenu').append('<li>' + tempMenuItemContent + '</li>');
                }
            }
        }

        else if (screenWidth <= 700 && screenWidth > 600) {

            //alert("Screen Size is between 600 and 700");
            resized = true;


            if (menuListSize_temp > 2 && resized) {

                menuOver = menuListSize_temp - 2;
                menuListSize_temp = menuListSize_temp - menuOver;


                menu.one('li.menu_more_item').setStyle('display', 'inline-block');
                resized = false;
                menu.all('li.menu_more_item ul.extmenu li').remove();

                for (var i = 3; i <= menuListSize; i++) {

                    var list_menu_item = document.getElementById('menu' + i);

                    tempMenuItemContent = list_menu_item.innerHTML;
                    menu.one('li#menu' + i).setStyle('display', 'none');
                    //alert(tempMenuItemContent);
                    //alert("Excess Content: " + tempMenuItemContent);
                    menu.one('li.menu_more_item ul.extmenu').append('<li>' + tempMenuItemContent + '</li>');

                }
            }
        }


    }


});

</script>
	
