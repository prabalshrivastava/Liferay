<div class="adminHeader header">
	<div class="header-container container">
		<div class="inner-container">
		 <div class="navLeftLogosh"><a href="/"><img src="${theme_display.getPathThemeImages()}/menu/mobileLogo.png"></a></div> 
		<ul class="nav-right">
			<li>
				<a href="/" title="Website">Website</a>
			</li>
			<li>
				<a href="javascript:void(0);" onclick="toggleNotifications()"><img src="${theme_display.getPathThemeImages()}/common/notify.png"/></a>
				
			
			</li>
			<li>
			<#if themeDisplay.getLayout().isPrivateLayout() >
				<a href="/group/${themeDisplay.getScopeGroup().getName()}/my-account" class="avatar" data-toggle="dropdown" aria-expanded="false">
			<#else>
				<a href="/web/${themeDisplay.getScopeGroup().getName()}/my-account" class="avatar" data-toggle="dropdown" aria-expanded="false">
			</#if>
					<div>
						<img src="${themeDisplay.getUser().getPortraitURL(themeDisplay)}" alt="">    
					</div>
				</a>
			</li>	
			<li>
			
				<div class="threedotaccountmenu">
					<img src="${themeDisplay.getPathThemeImages()}/common/down-arrow@2x.png" width="31" height="31" alt="">
					<div id="popoverId" class="Pop-Action-Account hide">
						<ul>
						<#if themeDisplay.getLayout().isPrivateLayout() >
										
							<li><a href="/group/${themeDisplay.getScopeGroup().getName()}/workspace" title="">Workspace</a></li>
							<li><a href="/group/${themeDisplay.getScopeGroup().getName()}/change-password" title="">Change Password</a></li>
							<li><a href="/c/portal/logout" title="">Sign Out</a></li>
						<#else>	
							<li><a href="/web/${themeDisplay.getScopeGroup().getName()}/workspace" title="">Workspace</a></li>
							<li><a href="/web/${themeDisplay.getScopeGroup().getName()}/change-password" title="">Change Password</a></li>
							<li><a href="/c/portal/logout" title="">Sign Out</a></li>						
						
						</#if>
						</ul>
					</div>
				</div>
			
			</li>
			
		</ul>
		
	</div>
	
</div>
</div>





<script>

var threedot = document.getElementById("threedot");

YUI().use("node", "event", function(A) {
    var j = A.one(".threedotaccountmenu");
    j.on("click", function(o) {
       
        var p = document.getElementsByClassName("Pop-Action-Account");
        if(p[0].classList.contains("hide")){
        	p[0].classList.remove("hide");
        }else{
        	p[0].classList.add("hide");
        }
        
    })
   
});

function toggleNotifications(){
	var p = document.getElementsByClassName("topannouncement");
    if(p[0].classList.contains("hide")){
    	loadListTop();
    	p[0].classList.remove("hide");
    }else{
    	p[0].classList.add("hide");
    }
	
}

</script>