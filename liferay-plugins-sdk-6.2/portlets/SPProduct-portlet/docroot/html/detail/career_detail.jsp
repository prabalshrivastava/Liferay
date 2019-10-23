<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>


<div id="Lp_Cont_9" class="section ">
<h4 class="header prod-accrodion-h4 toggler-header-collapsed"><a href="#"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.sidebar.menu.advanceyoucareer")%></a> </h4>
<div class="content  toggler-content-collapsed">
	<section class="Course-structure-section" data-track-content
		data-content-name="${productWrapper.product.productName}"
		data-content-piece="Advance Your Career">
		<div class="Course_wrap">
			<h2 class="course_h2"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.sidebar.menu.advanceyoucareer")%></h2>
		</div>
	</section>
	<c:if test="${not empty career }">
		<div class="Product-section-wrap">
			<div class="desk-view-left"></div>
			<div class="desk-tab-view">
				<div class="prod-cont-sec1">
					<div class="course-expl orderedList mobile-center-align">
						<c:choose>
						<c:when test="${productWrapper.product.productTemplateName == 'productTemplate1'}">
						<h3>${career.intro }</h3>
						</c:when>
						<c:otherwise>
						<h2>${career.intro }</h2>
						</c:otherwise>
						</c:choose>
					</div>
					<c:forEach var="option" items="${studyoptions}">
						<div class="careerblk">
							<div class="careerLeft">
								<div>
									<img src='${option.imgUrl }' alt="Career"></img>
								</div>
							</div>
							<div class="careerRight">
								<div class="course-middle">
									<h2>${option.title }</h2>
								</div>
								<div class="careerDetail">
									<p>${option.desc }</p>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
	</c:if>
</div>
</div>
