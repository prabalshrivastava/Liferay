<%@ include file="/html/sptabbedcategorycontent/init.jsp" %>

<%@ page import="com.sambaash.platform.portlet.spcontent.config.TabConfigurations"%>
<%@ page import="com.sambaash.platform.portlet.spcontent.util.ActionUtil"%>
<%@ page import="com.sambaash.platform.portlet.spcontent.config.TabConfiguration"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="com.sambaash.platform.portlet.spcontent.StatusMessage"%>

<liferay-ui:error key="<%=StatusMessage.MISSING_CONFIG_ERROR%>" message="MISSING_CONFIG_ERROR"/>

<%
	String contentType = (String) request.getAttribute(Constant.TAB_CONTENT_TYPE);
	Integer tabIndex = (Integer) request.getAttribute(Constant.TAB_CONTENT_INDEX);
	String contentTitle = (String) request.getAttribute(Constant.TAB_CONTENT_TITLE);
	TabConfigurations tabConfigs = new TabConfigurations();	
	try {
		tabConfigs = ActionUtil.retrieveTabConfigurations(portletPreferences);		
	} catch (Exception e) {
		// portlet not yet configured
	}
%>

<div class="journal-content-article" > 
  <div class="max-width tabContentWrap animated fadeIn" id="tab-1" style="display: block;">
	<div class="theme-tab-new">
		<div class="screen-max-width">
			<div class="mobile-menu-section animated" id="submenuclickhandlermenu1">
				<div class="active-tab animated " >
					Menu
				</div>
				<ul class="tab submenuclickhandlermenu animated fadeIn" >
					<%
						int tabCtr = 0; 
						String initialUrl = null;
						int curIndex = (tabIndex==null) ? 0 : tabIndex;
						for (TabConfiguration t: tabConfigs.getTabs()) {
							String classList = ( curIndex==tabCtr ) 
									? "tablinks active active-1" : "tablinks";
							PortletURL actionUrl = ActionUtil.newActionUrl(request, "displayTabbedCategoryContent");
							actionUrl.setParameter(Constant.TAB_CONTENT_INDEX, String.valueOf(tabCtr++));
							actionUrl.setParameter(Constant.TAB_CONTENT_TYPE, t.type);
							actionUrl.setParameter(Constant.TAB_CONTENT_TITLE, t.title);
							if (contentType==null && initialUrl==null) {
								initialUrl = actionUrl.toString();
							}
					%>
						<li>
						<a href='#' onClick="location.href = '<%=actionUrl.toString()%>';" class='<%=classList%>'><%=t.title%></a>
						</li>
					<%
						}
					%>
				</ul>
			</div>
		</div>				
	</div>	
	<%
		if (initialUrl != null) { // initial load	
			out.println("<script type='text/javascript'> window.location='" + initialUrl + "'; </script>");
		} else if (contentType==null) { // or when no configuration yet	
			List<String> portletIdList = themeDisplay.getLayoutTypePortlet().getPortletIds();
			int tabPortletCnt = 0;
			for (String p: portletIdList) {
				if (p.startsWith("sptabbedcategorycontent")) {
					++tabPortletCnt;
				}
			}
			if (tabPortletCnt>1) {
				out.println("<div class='alert alert-error'>Only 1 instance of SPTabbedCategoryContent portlet must be in the same page. Please remove this new instance.</div>");
			} else {
				out.println("<div class='alert alert-error'> Portlet Not Configured </div>");				
			}
		}
	%>

	<aui:row cssClass="sp-tab-cat-content-list">
	<div class="col">
	<div id="ideas1" class="tabcontent">
	<div class="ideas-section _ideas-section">

	<%
	if (Constant.ALL_CONTENT.equalsIgnoreCase(contentType)) {
		for (TabConfiguration t: tabConfigs.getTabs()) {
			if (!Constant.ALL_CONTENT.equalsIgnoreCase(t.type)) {
				contentTitle = t.title;
	%>
				<%
					if(Constant.BLOG_CONTENT.equalsIgnoreCase(t.type)) {
				%>
					<%@ include file="/html/sptabbedcategorycontent/view-blogs.jspf" %>				
				<%		
					}
				%>
				<%
					if(Constant.CHALLENGE_CONTENT.equalsIgnoreCase(t.type)) {
				%>
					<%@ include file="/html/sptabbedcategorycontent/view-challenge.jspf" %>	
				<%		
					}
				%>
				<%
					if(Constant.USER_CONTENT.equalsIgnoreCase(t.type)) {
				%>
					<%@ include file="/html/sptabbedcategorycontent/view-users.jspf" %>
				<%		
					}
				%>
				<%
					if(Constant.EVENT_CONTENT.equalsIgnoreCase(t.type)) {
				%>
					<%@ include file="/html/sptabbedcategorycontent/view-events.jspf" %>
				<%		
					}
				%>
				<%
					if(Constant.JOURNAL_CONTENT.equalsIgnoreCase(t.type)) {
				%>
					<%@ include file="/html/sptabbedcategorycontent/view-journals.jspf" %>
				<%		
					}
				%>
	<%
			}
		}
	} else {
	%>
		<%@ include file="/html/sptabbedcategorycontent/view-journals.jspf" %>
		<%@ include file="/html/sptabbedcategorycontent/view-blogs.jspf" %>
		<%@ include file="/html/sptabbedcategorycontent/view-events.jspf" %>
		<%@ include file="/html/sptabbedcategorycontent/view-users.jspf" %>
		<%@ include file="/html/sptabbedcategorycontent/view-challenge.jspf" %>	
	<%	
	}
	%>
	</div></div></div>
	</aui:row>
	
  </div>
</div>

<script>
AUI().ready('' , function () {
    var accItem = document.getElementsByClassName('accordionItem');
    var accHD = document.getElementsByClassName('accordionItemHeading');
    for (i = 0; i < accHD.length; i++) {
        accHD[i].addEventListener('click', toggleItem, false);
    }
    function toggleItem() {
    	//console.log('clicked');
    	var isClose = this.parentNode.className.indexOf('close') >= 0;
    	AUI().all('.accordionItem').attr('class', 'accordionItem close');
    	if (isClose) {
    		AUI().one(this.parentNode).removeClass('close'); 
    		AUI().one(this.parentNode).addClass('open'); 		
    	}
    }
});    
</script>

<script>
	var logo = document.getElementsByClassName('mobile-menu-section')[0];
	var trigger = window.innerHeight*0.8;
	
	// Logo
	function fixLogo(){
	  if(window.scrollY >= trigger){
	    if(!logo.classList.contains('fixed-mob-menu')){
	      logo.classList.add('fixed-mob-menu');
	      logo.classList.add('fixed-mob-menu');
	    }
	  } else{
	    if(logo.classList.contains('fixed-mob-menu')){
	      logo.classList.remove('fixed-mob-menu');
	      logo.classList.remove('slideInDown');
	    }
	  }
	}
	window.addEventListener('scroll', fixLogo);
	logo.addEventListener('click', function(e){
		if(!logo.classList.contains('active')){
	        logo.classList.add('active');
	    } else {
	    	logo.classList.remove('active');
	    }
	});
	document.querySelectorAll('.sp-tabbed-category-content-portlet .portlet-content')[0].style='padding: 0 !important';
</script>