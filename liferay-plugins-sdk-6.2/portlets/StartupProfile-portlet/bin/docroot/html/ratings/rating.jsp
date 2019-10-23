<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.portlet.WindowState"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<liferay-ui:error key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.required")%>' message='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.required")%>' />
<portlet:renderURL portletMode="view" var="viewURL" />
<portlet:resourceURL var="resourceURL" id="myResourceID01" />
	<div class="sp_ratings">
		<div class="ratingsSection_wrap">
			<div class="rs_container">
				<div class="rs_ave inline-block">
					 <span class="aveValue" id='<portlet:namespace/>overallRating'></span>
					<div class="aveRating stars" id='<portlet:namespace/>overallRatingStars'>
						<ul>
							
						</ul>
						<div class="rs_link hide">
							<a class="ind_ratings" href="#" id='<portlet:namespace/>avgIndRatingsButton'> <liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"view-individual-ratings")%>' /></a>
							<a class="ind_ratings" href="#" id='<portlet:namespace/>avgIndRatingsButtonHide'> <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.no.ratings.yet")%> </a>
						</div>
						<c:if test="${ratingPermisson}">
							<div class="rs_cta inline-block">
								<aui:a href="javascript:" id="rateItButton"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"rate-it")%>' /></aui:a>
							</div>
						</c:if>
					</div>
					<div class="ratings-pop-wrap" id='<portlet:namespace/>attrAvgModelContainer'>
						<div class="ratings-pop-content" >
							<div class="closePop">
								<img src="<%=themeDisplay.getPathThemeImages()%>/x_icon.svg" alt="closePop" />
							</div>
							<div class='hide-content'>
								<div class="aveRating stars" id='<portlet:namespace/>attrAvg'>
								  <span id='<portlet:namespace/>attrNameSpan' class="start-rating-row-title">
								  </span>
									<ul class="star-rating-row-stars">
									</ul>
								</div>
							</div>
							<div id='<portlet:namespace/>attrAvgContainer'>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	
<div class="ratings-pop-wrap " id='<portlet:namespace/>ratingsMainDiv'>
	<div class="ratings-pop-content" >
		<div class="closePop">
			<img src="<%=themeDisplay.getPathThemeImages()%>/x_icon.svg" alt="closePop" />
		</div>
		<div class="ratings-pop-title">
			<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"rate-this-startup")%>' />
		</div>
		
		<div class="ratings-pop-subtitle">
			<liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"hover-n-click-stars")%>' />
		</div>
		<div class='hide-content'>
			<div id='<portlet:namespace/>sampleRateDiv' class="ratings-pop-item">
			</div>		
		</div>
		<div id='<portlet:namespace/>ratingsDiv'>
		</div>
		
	</div>	
</div>
<script src="/StartupProfile-portlet/js/spUtilities.js" type="text/javascript"></script>
<script src="/StartupProfile-portlet/js/rating.js" type="text/javascript"></script>
<script>
var configObj = {
		pns: '<portlet:namespace/>',
		ajaxUrl: "<%= resourceURL  %>",
		ratingPermisson:${ratingPermisson}
	};
AUI().ready(function (){
	var ratings = new IndividualRatings(configObj);
	ratings.initialize();
});
</script>