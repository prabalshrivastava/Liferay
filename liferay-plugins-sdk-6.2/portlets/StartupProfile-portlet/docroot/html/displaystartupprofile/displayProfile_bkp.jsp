<%@page import="com.sambaash.platform.tag.handlers.CommentTagProcess"%>
<%@page import="com.sambaash.platform.constant.SambaashConstants"%>
<%@page import="com.sambaash.platform.startupprofile.helper.StartupPermissionHelper"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sambaash.platform.startupprofile.StartupConstants"%>
<%@page import="java.util.List"%>
<%@page import="com.sambaash.platform.util.FormHelper"%>
<%@page import="com.sambaash.platform.startupprofile.helper.StartupFormHelper"%>
<%@page import="com.sambaash.platform.srv.startupprofile.model.Organization"%>
<%@page import="com.sambaash.platform.model.StrartupProfileBean"%>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/tld/sp-ui" prefix="sp-ui"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-util:html-top>                                                                                                                                                    
        <meta property="og:title" content="${ogtitle}"/>                                                                                                                   
        <meta property="og:description" content="${ogdescription}"/>                                                                                                       
        <meta property="og:image" content="${logoUrl}"/>                                                                                                                   
        <meta property="og:url" content="${ogurl}"/>                                                                                                                       
        <meta property="og:type" content="Startup Profile"/>                                                                                                                       
</liferay-util:html-top> 

<portlet:actionURL var="addStartupActionURL" name="addStartup" />

<portlet:resourceURL var="resourceURL" />
<portlet:renderURL portletMode="view" var="viewURL" />
<portlet:resourceURL var="uploadFileResourceURL">
    <portlet:param name="action" value="uploadFile" />
</portlet:resourceURL>

<portlet:resourceURL var="removeFileResourceURL">
    <portlet:param name="action" value="removeFile" />
</portlet:resourceURL>

<script>

var submitError = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.submit")%>';
var successMsg = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.success")%>';
var errorMsg = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error")%>';
var sessionTimeOut = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.session.timed.out")%>';
var thankUMsg = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.thankyou.create.account")%>';
var startupSaveFail = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.fail.save.information.startup")%>';
var nameLogo = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.add.name.logo")%>';
var warningLabel = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.warning")%>';
var deleteConfirm = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.are.you.sure.want.to.delete.it")%>';
var removeError = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.remove")%>';
var removeSuccess = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.successfully.removed")%>';
var removeFailrefresh = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.remove.refresh.page")%>';
var errorAddingUser = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.adding.user")%>';
var maxAllowedChars = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.allowed.maximimum.tags")%>';
var duplicateTag = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.duplicate.tag")%>';
</script>

<style>
    .aui .video-js .vjs-control-bar{
        opacity: 100 !important;
    }
    
    .vp480 .startup_moreMenu li{
        display:none;
    }
    
    .category-tags-div div{
        height:30px;
        width:auto;
        background-color: #f5A5A5;
        padding:5px;
    }
    #ninja-slider .ns-img
    {
        object-fit: contain;
    }
    img[data-object-fit="contain"] {
    object-fit: contain;
}

img[data-object-fit="cover"] {
    object-fit: cover;
}
    
</style>

<%
    
	String licenseNinjaSlider = SambaashUtil.getParameter(SambaashConstants.NINJA_SLIDER_LICENSE, 0);
	boolean showAdminNav = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId())
        || SambaashUtil.isFoundryAdmin(themeDisplay.getUser())
        || SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
    
    String membersDisplayStyle = "";
    boolean isMembersEnabled = false;
    try {
        isMembersEnabled = Boolean.valueOf(portletPreferences.getValue(StartupConstants.ORG_ENABLE_MEMBERS, StringPool.FALSE));
    } catch (Exception e) {
    	_log.error(e.getMessage());
    }
    membersDisplayStyle = (isMembersEnabled) ? "" : "style='display:none'";     
    int sliderPageCnt = 0;
    boolean canUpdate = false;
    String profileEditUrl = "#";
	String orgJsonStr = (String) renderRequest.getAttribute("organization");
    if (StringUtils.isNotEmpty(orgJsonStr)) {
    	try {
    	JSONObject orgJsonObj = JSONFactoryUtil.createJSONObject(orgJsonStr);
    	Organization organization = OrganizationLocalServiceUtil.getOrganization(orgJsonObj.getLong("organizationId"));
    	canUpdate = StartupPermissionHelper.canUpdateStartup(renderRequest, organization.getOrganizationId());
    	StrartupProfileBean bean = new StrartupProfileBean();
    	if (organization.getCompleteness())
    		bean.setName(organization.getName());
    	else
    		bean.setName(organization.getName() + "(Incomplete)");
    	if (organization.getName().length() >= 13)
    		bean.setShortName(organization.getName().substring(0, 10) + "..");
    	else
    		bean.setShortName(organization.getName());
    	bean.setDetailsUrl(OrganizationLocalServiceUtil.displayFriendlyURL(themeDisplay,
    			organization.getOrganizationId()));
    	bean.setEditUrl(
    			OrganizationLocalServiceUtil.editFriendlyURL(themeDisplay, organization.getOrganizationId()));
    	bean.setImageUrl(SambaashUtil.getDLFileUrl(themeDisplay, organization.getLogoId()));  
    	profileEditUrl = bean.getEditUrl();
    	} catch (Exception e) {
    		_log.error(e.getMessage());
    	}
    }
	String briefTabVisibilityStyle = ""; // show    
	String challengesListPage = SambaashUtil.getParameter("challengesListPage", themeDisplay.getScopeGroupId());
	boolean isBriefEnabled = StringUtils.isNotEmpty(challengesListPage);
	if (!isBriefEnabled) {
		briefTabVisibilityStyle = "display:none;"; // hide
	}
	boolean canViewComment = false;
	try {
		canViewComment = (Boolean) renderRequest.getAttribute(CommentTagProcess.ACTION_VIEW_COMMENTS_PERMISSION);
	} catch(Exception e) {
		_log.error(e.getMessage());
	}

%>

<section class="g-detail-banner-container" style="background-image: url('<%=themeDisplay.getPathThemeImages()%>/background/gray-patterned.png'); background-position: top center; background-repeat: no-repeat;background-size:cover; ">
        <div class="gdb-content-section">
          
            <div class="gdb-image"><img src="${logoUrl}" alt="logo"></div>
            <div class="gdb-title"><h1>${name}</h1></div>
            <div class="gdb-social-icon">
                <ul>
                     <c:if test="${not empty cbUrl}">
                    <li>
                        <a href="${cbUrl}"  target = "_blank"> 
                            <img src="<%=themeDisplay.getPathThemeImages()%>/social_icons/cb.svg" alt="Crunchbase" title="Crunchbase" />
                        </a>
                    </li>
                    </c:if>
                    <c:if test="${not empty twitterUrl}">
                        
                    <li>
                            <a href="${twitterUrl}" target = "_blank"> 
                                <img src="<%=themeDisplay.getPathThemeImages()%>/social_icons/twitter.svg" alt="Twitter" title="Twitter" />
                            </a>
                    
                    </li>
                    </c:if>
                    
                        
                    
                    <c:if test="${not empty linkedInUrl}">
                    <li>
                        <a href="${linkedInUrl}" target = "_blank">
                            <img src="<%=themeDisplay.getPathThemeImages()%>/social_icons/linkedin.svg" alt="Linkedin" title="LinkedIn" />
                        </a>
                    </li>
                    </c:if>
                    
                        
                    
                    <c:if test="${not empty website}">
                     <li>
                       <a href="${website}" target="_blank">
                            <img src="<%=themeDisplay.getPathThemeImages()%>/social_icons/website.svg" alt="website" title="website" />
                        </a>
                    </li>
                    </c:if>
                </ul>
            </div>
            <div class="gdb-description">
                <ul>
                    <li class="separated">
                        <p class="org-loc"></p>
                    </li>
                    <li class="separated">
                        <p class="org-founded"></p>
                    </li>
                    <li class="separated">
                        <p class="org-funds"></p>
                    </li>
                    
                </ul>
            </div>
            <div class="gdb-ratings hide" id="startupratingsection">
                <div class="g-detail-rating ">
                    <c:if test="<%= SambaashUtil.isMarketer(themeDisplay.getUser()) 
                || SambaashUtil.isFoundryAdmin(themeDisplay.getUser()) 
                    || SambaashUtil.isAdmin(themeDisplay.getCompanyGroupId(), themeDisplay.getUserId()) %>">
                        
                            <%@ include file="/html/ratings/rating.jsp" %>
                        
                    </c:if>     
                </div>
            </div>
          
             <div class="gdb-navlink ">
             <span class="mobileNavSelect"> <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile")%>'/> </span>
           <div class="startupProfile-menuWrap">
                    <ul  class="tabs-events">
                         <li class="separated animated" >
                                 <a href="#" class="tablinks is-active" onclick="startuptabs(event, 'tab-one')"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.about")%>' /></a>
                        </li>
                         <li class="separated animated" style="<%=briefTabVisibilityStyle%>">
                             <a id="tab-applications-link" href="#" class="tablinks" onclick="startuptabs(event, 'tab-applications')"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.applications")%>' /></a>
                        </li>                
                         <li class="animated">
                             <a href="#" class="tablinks" onclick="startuptabs(event, 'tab-two')"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.more")%>' /></a>
                        </li>
                    </ul>
                    </div>
                    <%
                    if (canUpdate) {
                    %>
                    <div class="profileEdit-wrap"> 
                    <a href="<%=renderRequest.getAttribute("editFriendlyUrl") %>" title="Edit Startup" target="_blank"><input value="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.edit.profile")%>" type="button" class="btn-primary"></a> 
                    </div>
                    <%}%>
            </div>  
        </div>
       
    </section>

     <div class="screen-max-width">
        <div class="tabdetails-content animated fadeIn block" id="tab-one" >
        <div class="layout-container">
            <div class="layout-70">
                
                    <%
                            boolean showDesc = false;
                            Object obj = renderRequest.getAttribute("showcaseFiles");
                            List<String> videoLinkList = (List<String>) renderRequest.getAttribute(StartupConstants.ORG_SLIDER_VIDEO_LINK_LIST);
                            if (obj != null || (videoLinkList != null && videoLinkList.size()>0)) {
                                try {
                                    List<String> files = (List<String>)obj;
                                    boolean displayNinjaSlider = (files!=null && files.size() > 0) || (videoLinkList!=null && videoLinkList.size()>0);
                                    if (displayNinjaSlider) {
                                        sliderPageCnt = files==null ? 0 : files.size(); 
                                        sliderPageCnt += videoLinkList == null ? 0 : videoLinkList.size();
                                        %>
                                        <div class="gdb-box-sec padding-medium margin-bot-28">
                                            <div class=" video-container showcase-container">
                                            <div id="ninja-slider" class="relative margin-bottom-half">
                                              <div><div class="slider-inner">
                                                <ul>
                                                <%
                                                        String text = "";
                                                        int i=0;
                                                        for (String file: files) {
                                                            if( file.contains("imageThumbNail")) {
                                                                text += "<li><a href='#'><img alt='Image' class='ns-img' data-object-fit='contain' src='" + file + "'/></a></li>";
                                                            } else {
                                                                text += "<li><div class='video'><video id=vid" + i++ + " class='video video-js vjs-default-skin vjs-big-play-centered' controls  ><source src='";
                                                                text += file;
                                                                text += "' type='video/mp4'><p class='vjs-no-js'>";
                                                                text += LabelUtil.getLabel(pageContext, themeDisplay,"label.to.view.this.video");
                                                                text += LabelUtil.getLabel(pageContext, themeDisplay,"label.to.web.browser");
                                                                text += "<a href='http://videojs.com/html5-video-support/' target='_blank'>supports";
                                                                text += LabelUtil.getLabel(pageContext, themeDisplay,"label.html5.video") + "</a>";
                                                                text += "</p></video></div></li>";
                                                            }
                                                        }
                                                        if (videoLinkList != null) {
                                                            for(String videoLink: videoLinkList) {
                                                                text += "<li><div class='video'>";
                                                                text += "    <iframe src='" + videoLink + "'";
                                                                text += "    frameborder='0'  data-autoplay='0'  ></iframe>";
                                                                text += "</div></li>";
                                                            }
                                                            out.println(text);                                                          
                                                        }
                                                %>
                                                </ul>
                                                <div class="fs-icon" title="<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.expand.close")%>"></div>
                                              </div></div>
                                            </div>
                                            </div>
                                            </div>
                                        <%          
                                    } else {
                                        showDesc = false;               
                                    }
                                } catch(Exception e) {
                                	_log.error(e.getMessage());
                                    showDesc = false;
                                }
                            } else {
                                showDesc = false;
                            }
    
                            if (showDesc) {
                                %>
                                    <div class="detailed-description ">
                                        ${fullDescription}
                                    </div>
                                <% 
                            }
                            
                        %>
                <div class="gdb-box-sec padding-medium">
                    <div><h2 class="detailed-title-big margin-bot-10"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"comp-back")%>' /></h2></div>
                    <div class="detailed-description margin-bot-20" id="comp-descr"></div>
                </div>
              
                <div class="gdb-box-sec padding-medium margin-bot-28">
                    <div><h2 class="detailed-title margin-bot-20"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"comp-info")%>' /></h2></div>
                    <div class="box-section">
                        <div class="layout-30 ">
                            <div class="img-icon">
                                <img src="<%=themeDisplay.getPathThemeImages()%>/startup-profile/icon-phone.svg" alt="Contact" />
                            </div>
                            <a href="" class="cont-desc" id="comp-contact"></a>
                        </div>
                        <div class="layout-30 ">
                            <div class="img-icon">
                               <img src="<%=themeDisplay.getPathThemeImages()%>/startup-profile/icon-mail.svg" alt="Email" />
                            </div>
                            <a href="" class="cont-desc" id="comp-email"></a>
                        </div>
                        <div class="layout-30 ">
                            <div class="img-icon">
                               <img src="<%=themeDisplay.getPathThemeImages()%>/startup-profile/icon-website.svg" alt="Website" />
                            
                            </div>
                            <a href="${website}" target="_blank" class="cont-desc" id="comp-website"></a>
                        </div>
                    </div>
                </div>
            
                <div class="gdb-box-sec padding-medium margin-bot-28 hide" <%= membersDisplayStyle%> >
                    <div class="detailed-title margin-bot-20"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"comp-team")%>' /></div>
                    <div class="team-member">
                  
                    </div>
                </div>
            </div>
            <div class="layout-30">
                <!-- CATEGORIES -->
                <div class="gdb-box-sec padding-normal">
                 <div><h2 class="detailed-title"><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.q3")%></h2></div>
                    <div class="detail-content-wrap">
                        <div class="startup-tagsdiv" id="category-tags-div">
                            <% StartupFormHelper.createCategoryTags( "orgCategoryList", "cats", renderRequest, out);%>
                         
                        </div>
                    </div>
                </div>
                <!-- METHODOLOGY -->
                <div class="gdb-box-sec padding-normal">
                 <div><h2 class="detailed-title"><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.methodology")%></h2></div>
                    <div class="detail-content-wrap">
                        <div class="startup-tagsdiv" id="methodology-tags-div">
                           <% StartupFormHelper.createCategoryTags( "orgMethodologyTypeList", "methodologyCats", renderRequest, out, "small methodology_tagbg");%>
                           <% StartupFormHelper.createCategoryTags( "orgMethodologySubTypeList", "methodologyCats", renderRequest, out, "small methodology_tagbg");%>
                        </div>
                    </div>
                </div>
                 <!-- BRANDS & PROJECTS -->
                <div class="gdb-box-sec padding-normal">
                 <div><h2 class="detailed-title"><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.brands.and.projects")%></h2></div>
                    <div class="detail-content-wrap">
                       <div class="startup-tagsdiv" id="brands-tags-div">
                            <% StartupFormHelper.createCategoryTags( "brandList", "cats", renderRequest, out, "small brands_tagbg");%>
                     <%
                 List<String> projectList = (List<String>) renderRequest.getAttribute(StartupConstants.ORG_PROJECT_LIST);
                 if (projectList !=null && projectList.size()>0) {
                     for (int i = 0; i < projectList.size(); i++) {
                         String project = projectList.get(i);
                 %>
                    <div class="st-tags small brands_tagbg"><%=project %></div>
                 <%
                     }
                 }
                 %>                         
                        </div>
                    </div>
                </div>

                  <!-- TAGS -->
                <div class="gdb-box-sec padding-normal">
                 <div class="detailed-title"><%= LabelUtil.getLabel(pageContext, themeDisplay,"label.signup.tags")%></div>
                    <div class="detail-content-wrap">
                       <div class="startup-tagsdiv" id="gsTag-tags-div">
                            <% StartupFormHelper.createCategoryTagsFromStringList( "orgTagList", "cats", renderRequest, out, "small tags_bg");%>                         
                        </div>
                    </div>
                </div>
                <div class="gdb-box-sec padding-normal hide"  >
                    <div class="detailed-title" id="detailedRatingDiv"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"detailed-rating")%>' /></div>
                    <!--Ratings-->
                    <div class="detail-content-wrap">
                       <!--  <div class="detailed-title-small">EFFICIENCY</div>
                       <div class="g-detail-rating ">
                           <span class="star-rating smallStar r45" title="4/5">4</span>
                       </div> -->
                    </div>
                     <!--Ratings END-->
                  
                </div>

                 <div class="gdb-box-sec padding-normal "  >
                    <div class="detailed-title" id="detailedRatingDiv"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.q17")%>' /></div>
                    <!--Ratings-->
                    <div class="detail-content-wrap">
                     <iframe width="600" height="500" frameborder="0" id="uMap" scrolling="no" marginheight="0" src="" marginwidth="0"></iframe></div><style>#gmap_canvas{height:500px;width:600px;}#mapouter{overflow:hidden;height:500px;width:600px;}</style>
                    </div>
                     <!--Ratings END-->
                  
                </div>
            
            </div>
        </div>

    <div class="tabdetails-content  full-width animated fadeIn" id="tab-two">
        <div class="sp_profile sp_profile_view max-width padding-left-75 padding-right-75 box-sizing-border full-width block" >
    
            
            <section class="profile_content">
                <div class="profile_forms_wrap" id = "profile_forms_wrap">
                    <div class="page_headTitle" style="opacity: 1;">
                        <i><img src="<%=themeDisplay.getPathThemeImages()%>/content/apply_icon.png" alt="Profile Head" /></i>
                        <span>
                            <h1><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile")%>' /></h1>
                        </span>
                    </div>
                     <div class="profile_form_navigation stickyNav animate">
                        <span class="formNavTitle"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.overview")%>' /></span>
                        <nav>
                        <!--  added id to fix the expand / collapse in mobile -- Harini -->
                        <span class="mobileNavSelect" id="startup_more"> <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile")%>' /> </span>
                           <ul id="startup_moreMenu" class="startup_moreMenu">
                            <li class=" animated active" id="form_1"><i><img src="${themeDisplay.getPathThemeImages()}/startup-profile/line-chart.svg" alt="Line Chart"></i><span><h2><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-profile")%>'/></h2></span></li>
                            <li class="animated" id="form_2"><i><img src="${themeDisplay.getPathThemeImages()}/startup-profile/contact-info.svg" alt="Contact Info"></i><span><h2><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-contacts")%>'/></h2></span></li>
                            <% if (showAdminNav) { %>
                            <li class="animated" id="form_21"><i><img src="${themeDisplay.getPathThemeImages()}/startup-profile/contact-info.svg" alt="Contact Info"></i><span><h2><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-admin-section")%>'/></h2></span></li>
                            <% } %>
                            
							<%
								if (canViewComment){
							%>
	                            <li class="animated" id="form_22"><i><img src="${themeDisplay.getPathThemeImages()}/startup-profile/selft-assesment.svg" alt="Comments"></i><span><h2><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.comments.section")%>' /></h2></span></li>
							<% 	
								}
							%>
                            
                            <li class="animated" id="form_3"><i><img src="${themeDisplay.getPathThemeImages()}/startup-profile/selft-assesment.svg" alt="Self Assessment"></i><span><h2><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"startup-assessment")%>'/></h2></span></li>
                           </ul>
                       </nav>
                      </div>
                      <aui:form name="addStartup" action="<%=addStartupActionURL%>" cssClass="profile_form smartForm"  enctype="multipart/form-data">
                            <div class="apiPath" style="display: none">0</div>
                            <%@ include file="/html/displaystartupprofile/displayProfileSections.jsp" %>
                      </aui:form>
                </div>
              </section>
        </div>
    </div>
    <div class="tabdetails-content  full-width animated fadeIn" id="tab-applications" style="<%=briefTabVisibilityStyle%>">
        <%@ include file="/html/displaystartupprofile/challengeApplications.jspf" %>
    </div>
</div>
     
   

<link href="/html/css/sp/video-js.min.css" rel="stylesheet" type="text/css">
<script src="/StartupProfile-portlet/js/main.js" type="text/javascript"></script>
<script src="/html/js/sp/video.min.js?js_fast_load=0" type="text/javascript"></script>
<script src="/StartupProfile-portlet/js/script.js" type="text/javascript"></script>
<script src="/StartupProfile-portlet/js/slidervideos.js" type="text/javascript"></script>
<script type="text/javascript">
max = 0;
function initNinjaSlider(pageCount) {
    max = max + 1;
    var multiPage = pageCount>1;
    var nslider;
    if (document.getElementById('ninja-slider')) {
        try {
            var nsOptions = {
                sliderId : "ninja-slider",
                transitionType : "slide", //"fade", "slide", "zoom", "kenburns 1.2" or "none"
                autoAdvance : multiPage,
                delay : "default",
                transitionSpeed : 2000,
                aspectRatio : "2:1",
                initSliderByCallingInitFunc : false,
                shuffle : false,
                startSlideIndex : 0,
                navigateByTap : true,
                pauseOnHover : multiPage,
                keyboardNav : true,
                before : null,
                m:multiPage,
                license : "<%= licenseNinjaSlider%>"
            };

            nslider = new NinjaSlider(nsOptions);
        } catch (err) {
            //console.log(err);
        }
    }
    try {
    if (typeof nslider == "undefined"
                || typeof nslider.getSlides() == "undefined") {
        if (max == 99) {
            console.log('last try');
        }
        if (max < 100)
            setTimeout(initNinjaSlider, 200, pageCount);
        
    }
    }catch (er){
        console.log(er);
    }
}
</script>   
<script type="text/javascript">
var namespace = '<portlet:namespace/>';
var organization = <%=renderRequest.getAttribute("organization")%>;
var hq = <%=renderRequest.getAttribute("hq")%>;
var logoObj = <%=renderRequest.getAttribute("logoObj")%>;
var coverObj = <%=renderRequest.getAttribute("coverObj")%>;
var othersObj = <%=renderRequest.getAttribute("othersObj")%>;
var formattedTotalFunds = '<%=renderRequest.getAttribute("formattedTotalFunds")%>';
var showApplicationsImmediately = 'applications' === '<%=renderRequest.getAttribute("initialTab")%>';
var dynaSectionCounters = {};
var companyName;
try {
	companyName = organization.name;
}catch(e){companyName = "";}
<%StartupFormHelper.toMultipleFieldHtml("fundingRound", renderRequest, out);%>
<%StartupFormHelper.toMultipleFieldHtml("teamMember", renderRequest, out);%>
<%StartupFormHelper.toMultipleFieldHtml("questionnaire", renderRequest, out);%>

<%
StartupFormHelper.toMultipleFieldHtml("fundingRound", renderRequest, out);%>
var fillBy = <%=renderRequest.getAttribute("fillBy")%>;
AUI().use(
        'aui-node',
        'aui-base',
        'aui-io-request',
        function(A) {
    addMultiSectionsToForm('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.are.you.sure.want.to.delete.it")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.successfully.removed")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.remove")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.remove.refresh.page")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.success")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.session.timed.out")%>',"fundingRound", A);
    initialize('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.missing.information")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.profile.save.success")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.success")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.submit")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.get.user.info.refresh.page")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.session.timed.out")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.are.you.sure.want.to.delete.it")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.successfully.removed")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.remove")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.failed.remove.refresh.page")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.thankyou.create.account")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.fail.save.information.startup")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.view.briefs")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.go.to.profile")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.ok")%>','<%=resourceURL%>');
    disableAllFields();
    hideAllButtons();
    if (coverObj != null) {
        if (coverObj.logoUrl != null) {
            var banner = A.one('.g-detail-banner-container');
            banner.setStyle("backgroundImage", "url(" + coverObj.logoUrl + ")");
        }
    }
    if(organization){
        A.one('#comp-descr').set("innerHTML","<p>"+organization.description+"</p>");
        A.one('#comp-contact').set("innerHTML",organization.mobile);
        A.one('#comp-contact').set("href",'tel:'+organization.mobile);
        A.one('#comp-email').set("innerHTML",organization.emailId);
        A.one('#comp-email').set("href",'mailto:' + organization.emailId);
        A.one('#comp-website').set("innerHTML",organization.website);
        //A.one('#comp-website').set("href",organization.website);
    }
    
    if(organization && hq){
        var mapSrc = "https://maps.google.com/maps?q="+hq.city+","+hq.postalCode+",&t=&z=14&ie=UTF8&iwloc=&output=embed";
        A.one('.org-loc').set('innerHTML',hq.city);
        var foundedIn=organization.foundedOn.split('-')[0];
        if (foundedIn && foundedIn !== '') {
            A.one('.org-founded').set('innerHTML','<%= LabelUtil.getLabel(pageContext, themeDisplay,"label.founded.in")%> '+foundedIn);         
        } else {
            A.one('.org-founded').ancestor().remove();
        }
        if (formattedTotalFunds && formattedTotalFunds !== '' && formattedTotalFunds !== 'null') {
            A.one('.org-funds').set('innerHTML','\u20AC '+formattedTotalFunds);         
        } else {
            A.one('.org-funds').ancestor().remove();            
        }
        A.one('#uMap').set('src', mapSrc);
    } else  {
    	A.one('.org-loc').ancestor().remove();
    	A.one('.org-founded').ancestor().remove();
    	A.one('.org-funds').ancestor().remove();
    }
    var memberContainer=A.one('.team-member');
    for (var i = 1;; i++) {
        try {
            var obj=eval("teamMember"+i);
            if(obj.memberUserId!= undefined){
                
                var memberNode=A.Node.create('<div class="detail-content-team " >'+
                        '<img class="profileImage"  alt="image" src="'+obj.imageUrl+'" >'+
                        '<div class="dcs-row "><a class="dcs-title" href="'+obj.memberUserId+'" target="_blank">'+obj.name+'</a>'+
                        '<div class="g-detail-paragraph ">'+obj.title+'</div></div>'+
                        '</div>');
                memberNode.appendTo(memberContainer);
            }
        } catch (err) {
            console.log(err);
            break;
            
        }
    }
});

function cancel(){
    document.location.href = '<%=viewURL%>';
}
function edit(){
    document.location.href = '<%=renderRequest.getAttribute("editFriendlyUrl")%>';
}


initTabs();
initVideos();
initNinjaSlider(<%=sliderPageCnt%>);

AUI().ready(function(A){
	var hideTagContainerWhenEmpty = function(containerName) {
		 var catCnt = A.one('#'+containerName).all('div.st-tags')._nodes.length;
		 if (catCnt===0) {
			 A.one('#'+containerName).ancestor('div.gdb-box-sec').hide();			 
		 }			
	};
	hideTagContainerWhenEmpty('category-tags-div');
	hideTagContainerWhenEmpty('methodology-tags-div');
	hideTagContainerWhenEmpty('brands-tags-div');
	hideTagContainerWhenEmpty('gsTag-tags-div');
	if (showApplicationsImmediately) {
		startuptabs({preventDefault:function(){},currentTarget:AUI().one('#tab-applications-link')}, 'tab-applications')
	}		
});	

</script>

<%!
private static Log _log = LogFactoryUtil.getLog("html.displaystartupprofile.displayProfile_jsp");
%> 