<%-- <div>
<h2>Showing template2</h2>
<div><h2>template2 - ${preferredLanguage }</h2></div>
<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.callout.form.registration")%></h2>
</div> --%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.service.ProductLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="com.sambaash.platform.product.permissions.ProductPermissionsUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.sambaash.platform.util.ThumbnailUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<c:set var="preferredLanguage"  value="<%=wrapper.getProduct().getProductTemplateLanguage() %>"/>

<c:set var="productBannerImageId"
							value="<%=wrapper.getProduct().getProductBannerImageId() %>" />
						<%
						String bImgUrl = "";
						if(pageContext.getAttribute("productBannerImageId") != null) {
							try{
								Long bImgId = (Long) pageContext.getAttribute("productBannerImageId");
								
								if (bImgId != null && bImgId.compareTo(Long.parseLong("0")) != 0 ) {
									bImgUrl = ThumbnailUtil.getBannerImageUrl(DLAppServiceUtil.getFileEntry(bImgId),
											themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
											themeDisplay.getPathContext(), 1);
								}
							}catch(Exception e){
								_logt2.error(e.getMessage());
							}
						}
						if(bImgUrl != ""){
							%>
<style>
.product_section_bg{
	background: url("<%=bImgUrl %>")no-repeat center;
	background-position: center;
    background-size: cover;
    width: 100%;
    height: 100%;
}

.product_section.product_section_bg .Prod_h2 {
    text-shadow:1px 1px #000;
}
</style>
<%}%>

<% if(bImgUrl != "" && wrapper.getProduct().getBannerDetailsEnabled().equalsIgnoreCase("false")){%>
<style>
.product_section_bg_ht{
    height: 260px !important;
}
</style>
<%}%>

<c:set var="hasAccess"  value="<%= ProductPermissionsUtil.hasPreviewPermission(themeDisplay) %>"/>
<c:choose>
	<c:when test="${productWrapper.product.status == 1 || hasAccess}">

		<section class="product_section product_section_bg product_section_bg_ht" data-track-content
			data-content-name="${productWrapper.product.productName}"
			id="product_Topheader">
	<%	if(wrapper.getProduct().getBannerDetailsEnabled().equalsIgnoreCase("true") || wrapper.getProduct().getBannerDetailsEnabled().isEmpty()){ %>
			<h2 class="Prod_h2 ">${productWrapper.product.productName }</h2>
			<p>
				<c:if test="${productWrapper.course.displayCourseName}">
			${productWrapper.course.courseName}
		</c:if>
				<span>${specialisation}</span>
			</p>



			<div class="mob-BV">
				<ul>
					<li class="borderlight-right borderlight-top borderlight-bottom">
						<div class="mob-BV-img">
							<img
								src="<%=request.getContextPath()%>/images/product/pdf-icon.png" alt="PDF">
						</div>
						<div class="mob-BV-content"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.Brochures")%></div>
					</li>
					<li class="borderlight-left borderlight-top borderlight-bottom">
						<div class="mob-BV-img">
							<img
								src="<%=request.getContextPath()%>/images/product/pdf-icon.png" alt="PDF">
						</div>
						<div class="mob-BV-content"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.videos")%></div>
					</li>
				</ul>
			</div>
			<div class="Mob-bot-btn" data-track-content
				data-content-name="${productWrapper.product.productName}"
				data-content-piece="Register to know more">
				<button class="normal-cta shadow-subtle  font-14 bold"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.registerToKnow")%></button>
			</div>

			<div class="PTA_ShareSocial">
    <div class="PTA_ShareSocial_label"> <%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.shareThis")%> </div>
    <ul>
       
        <li>
            <a title="Share ${ogtitle}" href="https://www.facebook.com/dialog/share?app_id=${fbappid}&display=popup&href=${ogurl}&redirect_uri=${ogurl}"> <img src="/SPProduct-portlet/images/social_icon/facebook.png" alt="Facebook Icon"> </a>
        </li>
   
        <li>
            <a target="_blank" title="Share ${ogtitle}" href="https://twitter.com/share?text=${ogtitle}&url=${ogurl}"> <img src="/SPProduct-portlet/images/social_icon/twitter.png" alt="Twitter Icon"> </a>
        </li>
    
        <li>
            <a target="_blank" title="Share ${ogtitle}" href="https://www.linkedin.com/shareArticle?mini=true&url=${ogurl}&summary=${ogtitle}&source=Product"> <img src="/SPProduct-portlet/images/social_icon/linkedIn.png" alt="LinkedIn Icon"> </a>
        </li>
    
        <li>
            <a target="_blank" title="Share ${ogtitle}" href="https://plus.google.com/share?url=${ogurl}&hl=en-US"> <img src="/SPProduct-portlet/images/social_icon/gplus.png" alt="Gplus Icon"> </a>
        </li>

        <li>
            <a target="_blank" title="Share ${ogtitle}" href="mailto:?subject=${ogtitle}&body=Check out this product ${ogurl} ${ogdescription}"> <img src="/SPProduct-portlet/images/social_icon/mail.png" alt="Mail Icon"> </a>
        </li>
    </ul>
</div>
<% } %>
		</section>
		<!--Course OuCome-->
		<div id="sections" class="Max-width-1280 template2">
			<div id="sidebarmenu ${learning.intro }">
				<div class="Menu-sidebar-left Menu-sidebar-left-width" id="Menu-warp">
					<div class="prod-left-sidebar padding-20px" id="MENU_STICKY">
						<ul>
						<c:if test="${!empty(productWrapper.course.courseOutcomeTitle)}">
							<li><a href="#Lp_Cont_1" class="acd" class="active"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseOutcome")%></a></li>
						</c:if>
						<c:if test="${!empty learning.intro }">	
							<li><a href="#Lp_Cont_8" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.sidebar.menu.howyoulearn")%></a></li>
						</c:if>	
							<li><a href="#Lp_Cont_2" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseStructure")%></a></li>
							<li><a href="#Lp_Cont_3" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.whoShouldAttend")%></a></li>
							<li><a href="#Lp_Cont_9" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.sidebar.menu.advanceyoucareer")%></a></li>
							<li><a href="#Lp_Cont_6" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseFeesFunding")%></a></li>
							<li><a href="#Lp_Cont_4" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.gradRequirements")%></a></li>
							<li><a href="#Lp_Cont_5" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.certificate")%></a></li>
						</ul>
				</div>
				
				
			</div>

			
				    <!-- CourseOutcome -->
  				
  					
  					
			
			<!--Outcome-->
			
			<%@ include file="/html/detail/outcome_detail.jsp"%>

			<!-- How you learn -->
			
			<%@ include file="/html/detail/learning_detail_template2.jsp"%>

			<!--Course Structure-->
			
			<%@ include file="/html/detail/course_detail_template2.jsp"%>

			<!--Who should attend-->
			
			<%@ include file="/html/detail/requirements.jsp"%>

			<!-- Career details -->
			
			<%@ include file="/html/detail/career_detail.jsp"%>
			
			<!--Course Fees & Funding-->
			
			<%@ include file="/html/detail/fees_funding_detail.jsp"%>

			<!--graduation criteria-->
			
			<%@ include file="/html/detail/graduation_criteria_detail.jsp"%>

			<!--Certificates-->
			
			<%@ include file="/html/detail/certficates_detail.jsp"%>

			

			<%
            if(wrapper.getProduct().getSamePageRegistration().equalsIgnoreCase("true")){ %>
            <div class="template2 prod-right-sidebar" id="form-sideBar-samePageregistration">
            <%
            }
            else{ %>
            <div class="template2 prod-right-sidebar" >
            <div id="form-sideBar">
            <%} %>
            <%
           
            if(wrapper.getProduct().getSamePageRegistration().equalsIgnoreCase("true")){ %>
				<%
					/* String registerPageUrl = GetterUtil.getString(portletPreferences.getValue("registerPageUrl", "")); */
							           if(Validator.isNotNull(wrapper)){
									    if(wrapper.getProduct().getPEProcessId() > 0){
				%>
				<div id="registerForm" class="prod-right-inner">
					<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.registerToKnow")%></h2>
					<script type="text/javascript">
						function frameLoadedOuter() {
							 var iFrameID = document.getElementById('registerIframe');
							 /* if (iFrameID) {
									// here you can make the height, I delete it first, then I make it again
									iFrameID.height = "";
									iFrameID.height = iFrameID.contentWindow.document.body.scrollHeight + "px";
							  } */
						}
					</script>
				
					<%
						long classNameId = 0;
						long productId = wrapper.getProduct().getSpProductId();
						String urlLoadForm = StringPool.BLANK;
						long formId = 0;
						long processId = 0;
						
						try{
							 classNameId = ClassNameLocalServiceUtil.getClassName(Product.class.getCanonicalName()).getClassNameId();
							 processId = PEEngineLocalServiceUtil.getLeadProcessId();
							 if (Validator.isNull(processId) || processId <= 0){
								 processId = ProductLocalServiceUtil.getProduct(productId).getPEProcessId();
							 }
							 formId = PEEngineLocalServiceUtil.getFirstFormIdToLoad(processId);
							 urlLoadForm = FormBuilderLocalServiceUtil.getUrlFormLoad(formId, processId, productId, classNameId);
							 AssetCategory catg = AssetCategoryLocalServiceUtil.getAssetCategory(GetterUtil.getLong(wrapper.getProduct().getCountryId()));
							 urlLoadForm = HttpUtil.addParameter(urlLoadForm, "country_name_1", catg.getName());
							 
							 urlLoadForm = PEEngineLocalServiceUtil.addExtraParamsToFormUrl(themeDisplay.isSignedIn(), themeDisplay.getUser(), processId, urlLoadForm);
							 
							
						}catch(Exception ex){
							_logt2.error(ex.getMessage());
						}
					%>
					
					<%-- <iframe frameborder="0"  scrolling="no" id="registerIframe"
						src="<%=registerPageUrl %>?classNameId=<%=classNameId %>&classPK=${productWrapper.product.spProductId }&processId=<%=SambaashUtil.getParameter("pe.lead.process.id", 0) %>">
					</iframe> --%>
					
					<iframe frameborder="0"  scrolling="no" id="registerIframe"
						src="<%=urlLoadForm %>">
					</iframe>
				</div>
				<%
									    }
					}
            }else{
				%>
				<div id="callOutRegisterForm" class="prod-right-inner">
				<c:set var="callOutFormImageId"
							value="<%=wrapper.getProduct().getProductFormImageId() %>" />
						<%
						String fImgUrl = "/SPProduct-portlet/images/product/register-icon.svg";
						if(pageContext.getAttribute("callOutFormImageId") != null) {
							try{
								Long fImgId = (Long) pageContext.getAttribute("callOutFormImageId");
								
								if (fImgId != null && fImgId.compareTo(Long.parseLong("0")) != 0 ) {
									fImgUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(fImgId),
											themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
											themeDisplay.getPathContext(), 1);
								}
							}catch(Exception e){
								_logt2.error(e.getMessage());
							}
						}
							%>
				<div class="callOutFormWrap">
					<div class="callOutForm">
					<% if(fImgUrl != ""){ %>
						<div class="productCallOutFormImg">
							<img src="<%=fImgUrl %>" alt="Product callout form">
						</div>
						<%} %>
						<div class="productNameForForm">
							<span><%=wrapper.getProduct().getProductFormName() %></span>
						</div>
						<div class="callOutFormButton">
							<a href="<%=wrapper.getProduct().getProductFormUrl() %>" class="ns-button" target="_blank">
								<span><%=wrapper.getProduct().getProductFormButtonName() %></span>
							</a>
						</div>
					</div>
				</div>
	</div>
<% } %>
		
			
			<%if ((wrapper.getProduct().getProductBrochuresFolderId() > 0) && Validator.isNotNull(wrapper.getProduct().getProductBrochuresFolderId())){%>
			<%@ include file="/html/detail/brochure.jsp"%>
			<%}%>

        </div>
		</div>
		<script type="text/javascript">
			YUI().use(
  			'aui-toggler',
  			function(Y) {
  				
  			
    			new Y.TogglerDelegate(
    			
     			 {
        			animated: false,
       				closeAllOnExpand: true,
        			container: '#sections',
        			content: '.content',
        			expanded: false,
       				header: '.header',

        			
      				}
    			  );
  				}
			);
			YUI().use('node','event', 'anim', 'transition', function(Y) {
				if (Y.one('.header')) {
		        var accItem = Y.all('.header');
		        accItem.on('click', accItemClick);
		
		    }
		     function accItemClick(m) {

		     	    Y.one('body').delegate('click', function(m) {
		            smoothScrolls(m);
		        }, '#sections'); 

		     }

		      function smoothScrolls(m) {
		        //Prevent default on-click behavior
		        m.preventDefault();
		        var scrollTarget = m.target.getAttribute('id');
		            var scrollTargetY = m.target.get('parentNode').getY(),
		            //Set YUI animation and its properties
		            scrollAnim = new Y.Anim({
		
		                //Set duration in seconds
		                duration: 0.3,
		                node: 'win',
		                to: {
		                    scroll: [0, scrollTargetY-63]
		                }
		            });
		        scrollAnim.run();
		    }

			});
			
		</script>
		<script type="text/javascript">
		YUI().use('node','event', 'anim', 'transition', function(Y) {
		
		    //Schedule
		
		    if (Y.one('.list-cont')) {
		        var tabItem = Y.all('.list-file-cal');
		        tabItem.on('click', tabItemClick);
		
		    }
		   /*  var botSchItem = Y.all('.bot-link-schedule');
		    alert("botSchItem " + botSchItem);
		    botSchItem.on('click', tabItemClick); */
		    var tabSelected;
		
		    function tabItemClick(e) {
		        //window.scroll(0, 0);
		        e.preventDefault();
		        var tabItems = Y.all('.Lp_Mobtab');
		        for (var i = 0; i < tabItems.size(); i++) {
		            tabItems.removeClass('active');
		        }
		        var selectedContent = e.currentTarget;
		        var contshow = selectedContent.get('id');
		
		        var expToHide = Y.all('.Lp_para_exp');
		        var maintitle = Y.all('.Lp_para_main');
		
		        for (var i = 0; i < maintitle.size(); i++) {
		            maintitle.removeClass('disp-hid');
		            expToHide.setContent('');
		        }
		
		        var contshowParent = selectedContent.get('parentNode');
		        var textNode = contshowParent.get('childNodes').item(1).get('childNodes').item(1);
		        textNode.addClass('disp-hid');
		        textNode.next().setContent('Schedule');
		       
		            var sTop = document.getElementById('coreModule').offsetTop;
                    window.scrollTo(0,sTop);
		      
		
		        var headercontent = Y.one('#' + contshow + '_Schedule').get('innerHTML');
		
		        var mobcont = Y.one('#' + contshow + '_M');
		
		        mobcont.empty(true);
		        if (mobcont) {
		            mobcont.append(headercontent);
		            selectedContent.addClass("active");
		
		        }
		        var inscont = Y.all('.mob_Tabcontent');
		        for (var i = 0; i < inscont.size(); i++) {
		            inscont.addClass('disp-hid');
		        }
		        if (mobcont) {
		            mobcont.removeClass('disp-hid');
		            mobcont.addClass('.active-list');
		
		        }
		    }
		   
		});
		
		YUI().use('node', 'event', 'anim','transition', function(Y) {
		
		    if (Y.one('.list-cont')) {
		        var tabItem = Y.all('.list-file');
		        tabItem.on('click', tabItemClick);
		    }
		    
		        var tabItem = Y.all('.bot-link-outline');
		        tabItem.on('click', tabItemClick);
		    var tabSelected;
		
		    function tabItemClick(e) {
		        e.preventDefault();
		        var tabItems = Y.all('.Lp_Mobtab');
		        for (var i = 0; i < tabItems.size(); i++) {
		            tabItems.removeClass('active');
		        }
		        var selectedContent = e.currentTarget;
		        var Outlineshow = selectedContent.get('id');
		
		        var expToHide = Y.all('.Lp_para_exp');
		        var maintitle = Y.all('.Lp_para_main');
		
		        for (var i = 0; i < maintitle.size(); i++) {
		            maintitle.removeClass('disp-hid');
		            expToHide.setContent('');
		        }
		
		        var contshowParent = selectedContent.get('parentNode');
		        var textNode = contshowParent.get('childNodes').item(1).get('childNodes').item(1);
		        textNode.addClass('disp-hid');
		        textNode.next().setContent('Outline');
		       
		        	 var sTop = document.getElementById('coreModule').offsetTop;
   					 window.scrollTo(0,sTop);

		
		        var Outlinecontent = Y.one('#' + Outlineshow + '_Outline').get('innerHTML');
		        var Outcont = Y.one('#' + Outlineshow + '_M');
		        Outcont.empty(true);
		        if (Outcont) {
		            Outcont.append(Outlinecontent);
		            selectedContent.addClass("active");
		        }
		        var inscont1 = Y.all('.mob_Tabcontent');
		        for (var i = 0; i < inscont1.size(); i++) {
		            inscont1.addClass('disp-hid');
		        }
		        if (Outcont) {
		            Outcont.removeClass('disp-hid');
		            Outcont.addClass('.active-list');
		        }
		    }
		    
		   
		
		});
		
		YUI().use('node', 'event', 'anim', 'transition', function(Y) {

		var selector, elems, makeActive;
		selector = '.prod-left-sidebar ul li a';
		elems = document.querySelectorAll(selector);
		makeActive = function () {
    	for (var i = 0; i < elems.length; i++)
        		elems[i].classList.remove('active1');
  				this.classList.add('active1');
		};

		for (var i = 0; i < elems.length; i++)
    	elems[i].addEventListener('mousedown', makeActive);
		    //**********MENU ACTIVE
		
		   
		    //**********MENU end
		
		    // Get this value outside of the scroll listener.
		    // That way the browser doesn't have to recalculate a million times.
		
		    function smoothScroll(e) {
		        //Prevent default on-click behavior
		        e.preventDefault();
		        var scrollTarget = e.target.getAttribute('href'),
		            scrollTargetY = Y.one(scrollTarget).getY(),
		            //Set YUI animation and its properties
		            scrollAnim = new Y.Anim({
		
		                //Set duration in seconds
		                duration: 0.5,
		                node: 'win',
		                easing: 'easeBoth',
		                to: {
		                    scroll: [0, scrollTargetY - 90]
		                }
		            });
		        scrollAnim.run();
		    }
		
		    Y.all('.acd').each(function() {
		        Y.one('body').delegate('click', function(e) {
		            smoothScroll(e);
		        }, '.acd');
		
		    });
		
		    //SCROLL ANIMATION END
		
		    //SCROLL ACTIVE START
		    body = Y.one('body');
		    windowHeight1 = body.getY();
		
		    Y.on('scroll', function() {
		        var Position = window.scrollY;
	
		
		         //SCROL STICKY DESKTOP START
		
		        Y.on('scroll', function() {
		            var Position = window.scrollY;
		            Y.all('#Menu-warp').each(function(e) {
		                var target2 = e.getY();
		                var targetid2 = e.get('id');
		                if (Position > 100) {
		                    var menu_Wrap_sec = Y.one('#Menu-warp');
		                    navAnimHeight = menu_Wrap_sec.getStyle('height').replace(/\Y/g, '')
		                    menu_Wrap_sec.addClass('fixed');
		                    menu_Wrap_sec.setStyle('z-index', '1');
		                    menu_Wrap_sec.setStyle('margin-left', '20px');
		                    menu_Wrap_sec.setStyle('top', '19%');
		                    
		
		                } else if (Position <= 100) {
		                    var menu_Wrap_sec = Y.one('#Menu-warp');
		                    menu_Wrap_sec.removeClass('fixed');
		                      menu_Wrap_sec.setStyle('top', '0');
		                   
		
		
		                }
		                var Off_set = menu_Wrap_sec.getY();
		                var Off_set_height = menu_Wrap_sec.get("offsetHeight");
		                var off_both = Off_set + Off_set_height;
		                var footer_foo = Y.one('#footer');
		                var Off_set_footer = footer_foo.getY();
		                if (off_both > Off_set_footer) {
		
		                    menu_Wrap_sec.setStyle('top', -(off_both - Off_set_footer));
		                   
		                  
		                }
		            });
		            
		            Y.all('#form-sideBar').each(function(e) {
		                var target2 = e.getY();
		                var targetid2 = e.get('id');
		                if (Position > 100) {
		                    var menu_Wrap_sec = Y.one('#form-sideBar');
		                    navAnimHeight = menu_Wrap_sec.getStyle('height').replace(/\Y/g, '')
		                    menu_Wrap_sec.addClass('fixed');
		                    menu_Wrap_sec.setStyle('z-index', '1');
		                    menu_Wrap_sec.setStyle('margin-left', '0');
		                    menu_Wrap_sec.setStyle('top', '25%');
		                    

		                } else if (Position <= 100) {
		                    var menu_Wrap_sec = Y.one('#form-sideBar');
		                    menu_Wrap_sec.removeClass('fixed');
		                      menu_Wrap_sec.setStyle('top', '40px');
		                   


		                }
		                var Off_set = menu_Wrap_sec.getY();
		                var Off_set_height = menu_Wrap_sec.get("offsetHeight");
		                var off_both = Off_set + Off_set_height;
		                var footer_foo = Y.one('#footer');
		                var Off_set_footer = footer_foo.getY();
		                if (off_both > Off_set_footer) {

		                    menu_Wrap_sec.setStyle('top', -(off_both - Off_set_footer));
		                   
		                  
		                }
		            });
		           
		        });
		
		        //SCROL STICKY DESKTOP END
		        //SCROL STICKY MOBILE START
		    });
		
		    //SCROLL ACTIVE END
		
		    //SCROL STICKY
		
		
		
		
		    //SCROLL STICKY END
		    
		});
</script>
		<script type="text/javascript">
		function downloadFile(fileUrl,fileType){
				AUI().use('aui-node','aui-io-request',function(A){
					var items = null;
					var downLoadBrochure = '${downLoadBrochure}';
					try {
						startPreLoader("mainContainer");
						A.io
								.request(
										downLoadBrochure,
										{
											cache : false,
											sync : true,
											timeout : 1000,
											dataType : 'json',
											method : 'post',
											data : {
												fileUrl : fileUrl,
												fileType : fileType
											},
											on : {
												complete : function(){
													stopPreLoader("mainContainer");
												},
												success : function() {
													//alert("file Downloaded.");
												},
												failure : function() {
													//alert("Download failed. Please try again later");
												}
											}
		
										});
					} catch (err) {
						alert(err);
					}
					
				});
			}
		</script>

			
	</c:when>
	<c:otherwise>
		<div class="alert alert-error">
		<%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.course.unavailable.message")%>
		<%if(LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.mailto.text").trim().equalsIgnoreCase("added in link")){ %>
			 <a href="<%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.mailto")%>" target="_blank"> here </a> <%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.course.unavailable.message1")%>
		<%}else{ %>
			<a href="<%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.mailto")%>" target="_top"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.mailto.text")%></a>
		<%} %>
		</div>
	</c:otherwise>
</c:choose>

<%!
private static Log _logt2 = LogFactoryUtil.getLog("html.detail.template2_jsp");
%> 
