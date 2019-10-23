<%-- <div>
<h2>Showing template2</h2>
<div><h2>template2 - ${preferredLanguage }</h2></div>
<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.callout.form.registration")%></h2>
</div> --%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.sambaash.platform.srv.model.Product"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.service.ClassNameLocalServiceUtil"%>
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
		<div id="sections" class="Max-width-1280 template3">
				    <!-- CourseOutcome -->
			
			
			<div class="prod-cont-left-sidebar"> 
				<div class="prod-cont-sec " id="Course-Outcome"> 
					<div class="courseOutcome"> 
						<div class="course-Outcome-Title" id="Course-Outcome-Title"> 
							${productWrapper.course.courseName}
						</div> 
						<div class="outcomeDetail">
									${productWrapper.course.courseDesc}
								</div>
					</div> 
				</div> 
				<%-- <div class="prod-cont-sec " id="Course-Outcome"> 
					<div class="cont-sec-inner padding-20px"> 
						<div class="cont-image"> <img src="<%=request.getContextPath()%>/images/product/Icon-Description.svg"> 
							</div> <div class="cont-desc"> <h3>Course Description</h3> 
								<div class="outcomeDetail">
									${productWrapper.course.courseDesc}
								</div> 
							</div> 
						</div> 
					</div>  --%>
					
					<c:forEach var="outcomeDetailsList"
					items="${productWrapper.outcomeDetailsList}">
					<div class="prod-cont-sec margin-left-30" id="Course-Outcome">

						<div class="cont-sec-inner padding-20px">
							<div class="cont-image">
								<c:choose>
									<c:when test="${empty outcomeDetailsList.value[2]}">
										<img
											src="<%=request.getContextPath()%>/images/product/training.png" alt="training">
									</c:when>
									<c:otherwise>
										<img src="${outcomeDetailsList.value[2]}" alt="training">
									</c:otherwise>
								</c:choose>
							</div>
							<div class="cont-desc">

								<h3>${outcomeDetailsList.value[0]}</h3>
								<div class="outcomeDetail">${outcomeDetailsList.value[1]}</div>
							</div>
						</div>
					</div>
				</c:forEach>
					

            <%
            if(wrapper.getProduct().getSamePageRegistration().equalsIgnoreCase("true")){ %>
            <div class="template2 prod-right-sidebar" id="form-sideBar-samePageregistration">
            <%}else{ %>
            <div class="template2 prod-right-sidebar">
            	<div  id="form-sideBar">
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
							_logt3.error(ex.getMessage());
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
								_logt3.error(e.getMessage());
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
		
		
		
		YUI().use('node', 'event', 'anim', 'transition', function(Y) {
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
		        Y.all('.section').each(function(e) {
		            var target = e.getY();
		            var targetid = e.get('id');
		            if (Position >= target - 255) {
		                var Menusticky = Y.all('.Menu-sidebar-left');
		                //  Menusticky.addClass('fixed');
		                //  Menusticky.setStyle('top', '25');
		
		
		                var MenuItem = Y.all('.prod-left-sidebar ul li a');
		                Y.all('.prod-left-sidebar > ul > li > a ').removeClass('active1');
		                Y.all('.prod-left-sidebar > ul > li >  a[href="#' + targetid + '"]').addClass('active1');
		
		
		            }
		
		        });
		
		         //SCROL STICKY DESKTOP START
		
		        Y.on('scroll', function() {
		            var Position = window.scrollY;
		           
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
private static Log _logt3 = LogFactoryUtil.getLog("html.detail.template3_jsp");
%> 
