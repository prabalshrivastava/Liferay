<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="Lp_Cont_4" class="section">
<h4 class="header prod-accrodion-h4 toggler-header-collapsed"><a href="#"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.gradRequirements")%></a> </h4>
<div class="content  toggler-content-collapsed">
	<section class="Course-structure-section" data-track-content
		data-content-name="${productWrapper.product.productName}"
		data-content-piece="Graduation Requirements">
		<div class="Course_wrap ">
			<h2 class="course_h2"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.graduationRequirements")%></h2>
		</div>
	</section>
	<div class="Product-section-wrap ">
		<div class="desk-view-left"></div>
		<div class="desk-tab-view">
			<div class="prod-cont-sec1 ">
				<div class="course-expl">
				<c:choose>
						<c:when test="${productWrapper.product.productTemplateName == 'productTemplate1'}">
						<h3>${productWrapper.course.graduationCriteriaDesc}</h3>
						</c:when>
						<c:otherwise>
						<h2>${productWrapper.course.graduationCriteriaDesc}</h2>
						</c:otherwise>
				</c:choose>
					
					<ul>
					<c:forEach var="graduationCriteriaList"
						items="${productWrapper.graduationCriteriaDetailsList}">
						<li>${graduationCriteriaList.value[0] }</li>
					</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>