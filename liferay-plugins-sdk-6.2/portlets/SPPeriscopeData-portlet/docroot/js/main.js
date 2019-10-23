var portletNamespace;
var ajax;

function loadDashboard(link, menuData) {
    var A = AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated');
    var data = {};
    data[portletNamespace + 'action'] = 'loadDashboard';
    data[portletNamespace + 'menuData'] = JSON.stringify(menuData);
    A.io.request(ajax, {
        dataType: 'json',
        method: 'POST',
        sync: true,
        data: data,
        on: {
            success: function() {
                var data = this.get('responseData');
                A.one('#periscope').set('src', data.dashboardUrl);
                if (link) {
                    A.all('.ps-activeMenu').removeClass('ps-activeMenu');
                    A.one(link).ancestor('li').addClass('ps-activeMenu');
                    A.all('.ps-activeMenudrop').removeClass('ps-activeMenudrop');
                    A.one(link).addClass('ps-activeMenudrop');


                }
            },
            failure: function() {
                if (console) console.log('Error in retrieving dashboard url.');
            }
        }
    });
};

function showSubMenu(comp, show) {
    if (show) {
        AUI().one(comp).one('.ps-dropdown .ps-dropdown-content').show();
    } else {
        AUI().one(comp).one('.ps-dropdown .ps-dropdown-content').hide();
    }
}

function initializeView(a, ns, navConfig) {
    ajax = a;
    portletNamespace = ns;

    AUI().ready(function(A) {
        var periscope = AUI().one('#periscope');

        function periscopeDrilldown(drilldownData) {
            var A = AUI().use('aui-node', 'aui-base', 'aui-io-request-deprecated');
            var data = {};
            var drillDownLink = A.one('.d' + drilldownData.destination_dashboard_id);
            var drilldownFilters = drillDownLink.getData('filters');
            if (drilldownFilters) {
            	drilldownData.defaultDrilldownFilters = drilldownFilters.split(',');
            }
            data[portletNamespace + 'action'] = 'drilldown';
            data[portletNamespace + 'drilldownData'] = JSON.stringify(drilldownData);
            A.io.request(ajax, {
                dataType: 'json',
                method: 'POST',
                sync: true,
                data: data,
                on: {
                    success: function() {
                        var retdata = this.get('responseData');
                        A.one('#periscope').set('src', retdata.drilldownUrl);
                        if (A.one('.d' + drilldownData.destination_dashboard_id)) {
                            A.all('.ps-activeMenu').removeClass('ps-activeMenu');
                            A.one('.d' + drilldownData.destination_dashboard_id).ancestor('li').addClass('ps-activeMenu');
                        }
                    },
                    failure: function() {
                        if (console) console.log('Error in retrieving drilldown url.');
                    }
                }
            });
        };

        var sHeight = 600;
        
        function receiveMessage(e) {
            console.log("Message Received: " + JSON.stringify(e.data));
            if (e.data.event_type === 'drilldown') {
                if (navConfig.defaultDrilldownFilters) {
                    e.data.defaultDrilldownFilters = navConfig.defaultDrilldownFilters;
                }
                periscopeDrilldown(e.data);
            }
            
            if (e.data.event_type === 'dashboard_resize') {
            	sHeight = e.data.dashboard_height+50;
            	A.one('#periscope').set('height', sHeight);
            	A.one('#main-ps-content').set('height', sHeight+50);
            }
        }

        window.addEventListener('message', receiveMessage);

        // adjust height of iframe
        //		  var sHeight = (document.body.scrollHeight - A.one('.footer-section').get('scrollHeight') - A.one('.main-header').get('scrollHeight'))+'px'
       
        A.one('#periscope').set('height', sHeight);

        if (navConfig) {
            var navContainer = A.one('.ps-sidebar-heading');
            if (navConfig.navTitle) {
                navContainer.one('.ps-sidebar-title').html(navConfig.navTitle);
            }
            var defaultActive;
            for (var i = 0; i < navConfig.menus.length; i++) {
                var menu = navConfig.menus[i];
                var menuHtmlStr = '<div class="ps-sidebarnav" id="ps-sidebarnav-' + menu.menuName + '"><h3 class="ps-headerToggler toggler-header-collapsed ps-sidebarnav-title">' + menu.menuName + '</h3><ul class="ps-contentToggler toggler-content-collapsed">';
                for (var j = 0; j < menu.menuItems.length; j++) {
                    var menuItem = menu.menuItems[j];
                    var menuItemHasLink = menuItem.dashboardId;
                    var hasSubMenus = menuItem.subMenuItems && menuItem.subMenuItems.length > 0;
                    menuHtmlStr += '<li';
                    if (hasSubMenus) {
                        menuHtmlStr += ' onmouseover="showSubMenu(this, true)" onmouseout="showSubMenu(this, false)" ';
                    }
                    menuHtmlStr += (menuItem.defaultActive ? ' class="ps-activeMenu"' : '') + '><a ';
                    if (menuItemHasLink) {
                        menuHtmlStr += " class='d" + menuItem.dashboardId + "' ";
                        menuHtmlStr += " data-filters='" + menuItem.filters + "' ";
                        menuHtmlStr += "onclick='loadDashboard(this, " + JSON.stringify(menuItem) + ")'";
                        if (menuItem.defaultActive) {
                            defaultActive = menuItem;
                        }
                    }
                    menuHtmlStr += '><img alt="Menu Image" src="/SPPeriscopeData-portlet' + menuItem.menuItemIcon + '"><span>' + menuItem.menuItem + '</span>';
                    if (hasSubMenus) {
                        menuHtmlStr += '<div class="ps-dropdown"><div class="ps-dropdown-content" style="display:none;">';
                        for (var k = 0; k < menuItem.subMenuItems.length; k++) {
                            var subMenuItem = menuItem.subMenuItems[k];
                            var subMenuItemHasLink = subMenuItem.dashboardId;
                            menuHtmlStr += '<a ';
                            if (subMenuItemHasLink) {
                                menuHtmlStr += " class='d" + subMenuItem.dashboardId + "' ";
                                menuHtmlStr += " data-filters='" + subMenuItem.filters + "' ";
                                menuHtmlStr += "onclick='loadDashboard(this, " + JSON.stringify(subMenuItem) + ")'";
                                if (subMenuItem.defaultActive) {
                                    defaultActive = subMenuItem;

                                }
                            }
                            menuHtmlStr += ' class="drpsp">' + subMenuItem.subMenuItem + '</a>';
                        }
                        menuHtmlStr += '</div></div>';
                    }
                    menuHtmlStr += '</a></li>';
                }
                menuHtmlStr += '</ul></div>';
                navContainer.append(menuHtmlStr);
            }
            if (defaultActive) {
                loadDashboard(null, defaultActive);
            }
        }

    });
    YUI().ready('aui-toggler', function(A) {
        var lastClicked = null;
        toggler = new A.TogglerDelegate({
            
            closeAllOnExpand: true,
            conteiner: '#ps-sidebarToggle',
            content: '.ps-contentToggler',
            expanded: false,
            header: '.ps-headerToggler',
            
            after: {
                init: function() {
                	if(A.one('.ps-headerToggler')){
	                    singleToggler = A.one('.ps-headerToggler').getData("toggler");
	                    singleToggler.expand();
                	} 
                }
            }
        });
    });

}

function refresh() {
	console.log("Charts refresh triggered.");
	document.getElementsByTagName("iframe")[0].contentWindow.postMessage({
		event_type : "refresh_charts"
	}, "*");
}

function openSidebarNav() {
  document.getElementById("ps-sidebarToggler").style.width = "250px";
  document.getElementById("ps-sidebarToggler").style.borderStyle = "solid";
  document.getElementById("main-ps-content").style.marginLeft = "250px";
}

function closeSidebarNav() {
  document.getElementById("ps-sidebarToggler").style.width = "0px";
  document.getElementById("ps-sidebarToggler").style.borderStyle = "none";
  document.getElementById("main-ps-content").style.marginLeft= "0px";
  document.getElementById("main-ps-content").style.width= "100%";
}
