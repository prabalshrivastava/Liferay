<%@page import="com.sambaash.platform.srv.service.ProductLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.PEEngineLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.FormBuilderLocalServiceUtil"%>
<%@page import="com.sambaash.platform.srv.processbuilder.service.FormBuilderServiceUtil"%>
<%@page import="com.sambaash.platform.product.permissions.ProductPermissionsUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@ page import="com.sambaash.platform.util.ThumbnailUtil"%>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Locale"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-util:html-top>
	<meta property="og:title" content="${ogtitle}"/>
	<meta property="og:description" content="${ogdescription}"/>
	<meta property="og:image" content="${ogimage}"/>
	<meta property="og:url" content="${ogurl}"/>
	<meta property="og:type" content="product"/>
</liferay-util:html-top>

<portlet:resourceURL var="downLoadBrochure">
	<portlet:param name="action" value="downLoadBrochure"></portlet:param>
</portlet:resourceURL>

<%

boolean downloadBrochure = GetterUtil.getBoolean(portletPreferences.getValue("downloadBrochure", ""));
String downloadBrochureUrl = GetterUtil.getString(portletPreferences.getValue("downloadBrochureUrl", ""));
ProductDetailWrapper wrapper = (ProductDetailWrapper)request.getAttribute("productWrapper");
String prefferedLang = wrapper.getProduct().getProductTemplateLanguage();
String[] prefferedLangArray = prefferedLang.split("_");
Locale prefLocale = new Locale("en","US");
if(prefferedLangArray.length>1){
	if(prefferedLangArray[0].equalsIgnoreCase("china")){
		prefferedLangArray[0] = "zh";
	}
 prefLocale = new Locale(prefferedLangArray[0],prefferedLangArray[1]);//Locale.forLanguageTag("zh-CN");//new Locale("zh","CN");//LanguageUtil.getLocale("CHINA");
}
%>
<c:set var="preferredLanguage"  value="<%=wrapper.getProduct().getProductTemplateLanguage() %>"/>

<%if(wrapper.getProduct().getProductTemplateName().contains("Full") || wrapper.getProduct().getProductTemplateName().isEmpty()){ %>
<c:set var="hasAccess"  value="<%= ProductPermissionsUtil.hasPreviewPermission(themeDisplay) %>"/>
<c:choose>
	<c:when test="${productWrapper.product.status == 1 || hasAccess}">

		<section class="product_section" data-track-content
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
		<div id="sections" class="Max-width-1280">
			<div id="sidebarmenu">
				<div class="Menu-sidebar-left" id="Menu-warp">
					<div class="prod-left-sidebar padding-20px" id="MENU_STICKY">
						<ul>
							<li><a href="#Lp_Cont_1" class="acd" class="active"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseOutcome")%></a></li>
							<li><a href="#Lp_Cont_8" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.sidebar.menu.howyoulearn")%></a></li>
							<li><a href="#Lp_Cont_2" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseStructure")%></a></li>
							<li><a href="#Lp_Cont_3" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.whoShouldAttend")%></a></li>
							<li><a href="#Lp_Cont_9" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.sidebar.menu.advanceyoucareer")%></a></li>
							<li><a href="#Lp_Cont_4" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.gradRequirements")%></a></li>
							<li><a href="#Lp_Cont_5" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.certificate")%></a></li>
							<li><a href="#Lp_Cont_6" class="acd"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseFeesFunding")%></a></li>
							<% if ((downloadBrochure) && Validator.isNotNull(downloadBrochureUrl)){ %>
							<li><a href="<%= downloadBrochureUrl %>${productWrapper.product.spProductId}" target="_blank" ><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.downloadBrochure")%></a></li>
							<% } %>
						</ul>
				</div>
				
				
			</div>

			
				    <!-- CourseOutcome -->
  				
  					
  					
			
			<!--Outcome-->
			
			<%@ include file="/html/detail/outcome_detail.jsp"%>

			<!-- How you learn -->
			
			<%@ include file="/html/detail/learning_detail.jsp"%>

			<!--Course Structure-->
			
			<%@ include file="/html/detail/course_detail.jsp"%>

			<!--Who should attend-->
			
			<%@ include file="/html/detail/persona_attendee_detail.jsp"%>

			<!-- Career details -->
			
			<%@ include file="/html/detail/career_detail.jsp"%>

			<!--graduation criteria-->
			
			<%@ include file="/html/detail/graduation_criteria_detail.jsp"%>

			<!--Certificates-->
			
			<%@ include file="/html/detail/certficates_detail.jsp"%>

			<!--Course Fees & Funding-->
			
			<%@ include file="/html/detail/fees_funding_detail.jsp"%>

			<% if ((downloadBrochure) && Validator.isNotNull(downloadBrochureUrl)){ %>
			<div class="downloadBrochureMob">
				<a href="<%= downloadBrochureUrl %>${productWrapper.product.spProductId}" target="_blank" ><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.downloadBrochure")%></a>
			</div>
			<%} %>

            <div class="prod-right-sidebar">
            <%
           
            if(wrapper.getProduct().getSamePageRegistration().equalsIgnoreCase("true") || wrapper.getProduct().getSamePageRegistration().isEmpty()){ %>
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
							_log.error(ex.getMessage());
						}
					%>
					
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
							<a href="<%=wrapper.getProduct().getProductFormUrl() %>" class="ns-button">
								<span><%=wrapper.getProduct().getProductFormButtonName() %></span>
							</a>
						</div>
					</div>
				</div>

<% if ((wrapper.getProduct().getProductBrochuresFolderId() > 0) && Validator.isNotNull(wrapper.getProduct().getProductBrochuresFolderId())){ %>

<c:set var="callOutFormBrchId"
							value="<%=wrapper.getProduct().getProductBrochuresFolderId() %>" />
						<%
						String fImgUrl1 = "/SPProduct-portlet/images/product/Icon-PDF.svg";
						String brochureUrl = "";String fileType = "";
						
							if(pageContext.getAttribute("callOutFormBrchId") != null) {
								Long brochureFolderId = (Long) pageContext.getAttribute("callOutFormBrchId");
								if(brochureFolderId > 0) {
									List<FileEntry> fileEntryBList = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), brochureFolderId);
															String brochureId = "";
															for(FileEntry fileEntry : fileEntryBList){
																brochureId = fileEntry.getUuid();
																fileType = fileEntry.getMimeType();
															if (brochureId != "") {
																brochureUrl = "/documents/"+fileEntry.getGroupId()+"/"+brochureFolderId+"/"+brochureId;
															}
															}
								}
								if(brochureUrl != ""){
									//brochureUrl = "/documents/12720/66036/downloadPDFTest/98a933ff-02f8-49f0-b8e9-1d65bd4eb4c5?version=1.0";
								%>
				<div class="callOutFormWrap margin-top-20">
					<div class="callOutForm">
					<% if(fImgUrl1 != ""){ %>
						<div class="productCallOutFormImg">
							<img src="<%=fImgUrl1 %>" alt="Product Brochure">
						</div>
						<%} %>
						<%-- "javascript:downloadFile('<%= brochureUrl %>','<%=fileType%>')"  --%>
						<div class="callOutFormButton actionButton">
							<a href="<%=brochureUrl %>" class="ns-button" onClick="javascript:downloadFile('<%= brochureUrl %>','<%=fileType%>')">
								<span><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.view.brochure")%></span>
							</a>
						</div>
					</div>
				</div>
							
							<% }} %>
							</div>
<%}} %>
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
		    //**********MENU ACTIVE
		
		    if (Y.one('.Menu-sidebar-left')) {
		
		        var MenuItem = Y.all('.prod-left-sidebar ul li');
		        var MenuItem1 = Y.all('.prod-left-sidebar ul li a');
		
		        MenuItem.on('click', MenuItemClick);
		    }
		
		
		    function MenuItemClick(e) {
		        MenuItem.removeClass('active');
		        var menuContent = e.currentTarget;
		        var menuShow = menuContent.get('id');
		        e.currentTarget.addClass('active1');
		        var bjj = Y.one('.Course_wrap');
		
		    }
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
		            Y.all('#Menu-warp').each(function(e) {
		                var target2 = e.getY();
		                var targetid2 = e.get('id');
		                if (Position > 100) {
		                    var menu_Wrap_sec = Y.one('#Menu-warp');
		                    navAnimHeight = menu_Wrap_sec.getStyle('height').replace(/\Y/g, '')
		                    menu_Wrap_sec.addClass('fixed');
		                    menu_Wrap_sec.setStyle('z-index', '1');
		                    menu_Wrap_sec.setStyle('margin-left', '35px');
		                    menu_Wrap_sec.setStyle('top', '30%');
		                    
		
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
<%}else if(wrapper.getProduct().getProductTemplateName().contains("Simplified 1")){ %>
	<%@ include file="/html/detail/template2.jsp"%>
	<%}else{ %>
	<%@ include file="/html/detail/template3.jsp"%>
<%}%>

<%!
private static Log _log = LogFactoryUtil.getLog("html.detail.view_jsp");
%> 
