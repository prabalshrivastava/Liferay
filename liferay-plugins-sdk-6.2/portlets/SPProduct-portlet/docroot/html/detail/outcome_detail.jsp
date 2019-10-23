<%@page import="com.sambaash.platform.srv.model.Product"%>
<%@page import="com.liferay.portal.service.ClassNameLocalServiceUtil"%>
<%@page import="com.sambaash.platform.util.SambaashUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page
	import="com.sambaash.platform.product.wrapper.ProductDetailWrapper"%>
<%@page import="com.sambaash.platform.srv.model.ProductWrapper"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<div id="Lp_Cont_1" class="section" data-track-content
	data-content-name="${productWrapper.product.productName}"
	data-content-piece="Course Outcome">
	<h4 class="header prod-accrodion-h4 toggler-header-collapsed"><a href="#"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseOutcome")%></a> </h4>
	<div class="Product-section-wrap content  toggler-content-collapsed">
		<div class="desk-view-left"></div>
		<div class="desk-tab-view">
			<!--Course Outcome-->
			<div class="prod-cont-left-sidebar">
				<div class="prod-cont-sec " id="Course-Outcome">
					<div class="courseOutcome">
						<div class="course-Outcome-Title" id="Course-Outcome-Title">
							${productWrapper.course.courseOutcomeTitle}</div>
						<div class="cont-desc course-Outcome-Desc"
							id="Course-Outcome-Desc">
							${productWrapper.course.courseOutcomeDesc}</div>
					</div>
				</div>
				<c:forEach var="outcomeDetailsList"
					items="${productWrapper.outcomeDetailsList}">
					<div class="prod-cont-sec " id="Course-Outcome">

						<div class="cont-sec-inner padding-20px">
							<div class="cont-image">
								<c:choose>
									<c:when test="${empty outcomeDetailsList.value[2]}">
										<img
											src="<%=request.getContextPath()%>/images/product/training.png" alt="Training">
									</c:when>
									<c:otherwise>
										<img src="${outcomeDetailsList.value[2]}" alt="Training">
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
			</div>
			<!--rightsidebar-->
			
		</div>
	</div>
</div>

<script type="text/javascript">
var A;
var pns = "<portlet:namespace/>";
AUI().use('aui-node', 'aui-io-request', 'liferay-util-window', 'aui-io-plugin-deprecated', function(A1) {
    A = A1;
    var eventMethod = window.addEventListener ? "addEventListener" : "attachEvent";
    var eventer = window[eventMethod];
    var messageEvent = eventMethod == "attachEvent" ? "onmessage" : "message";
    eventer(messageEvent, function(b) {
        console.log("parent received message!: ", b.data);
        if ("scroll" == b.data) {
            var scrollNode = A.one("#registerForm");
            if (scrollNode) {
                scrollNode.scrollIntoView();
            }
        }
    }, false);

});
</script>

