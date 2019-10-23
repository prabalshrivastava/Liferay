<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="Lp_Cont_5" class="section">
<h4 class="header prod-accrodion-h4 toggler-header-collapsed"><a href="#"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.certificate")%></a> </h4>
<div class="content  toggler-content-collapsed">
	<section class="Course-structure-section" data-track-content
		data-content-name="${productWrapper.product.productName}"
		data-content-piece="Certificates">
		<div class="Course_wrap">
			<h2 class="course_h2"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.certificate")%></h2>
		</div>
	</section>
	<div class="Product-section-wrap">
		<div class="desk-view-left"></div>
		<div class="desk-tab-view">
			<div class="prod-cont-sec1 ">
				<div class="course-expl">
				<c:choose>
						<c:when test="${productWrapper.product.productTemplateName == 'productTemplate1'}">
						<h3>${productWrapper.course.certificateTitle}</h3>
						</c:when>
						<c:otherwise>
						<h2>${productWrapper.course.certificateTitle}</h2>
						</c:otherwise>
				</c:choose>
				<c:choose>
				<c:when test="${productWrapper.product.productTemplateName == 'productTemplate1'}">
					<ul>
					<c:forEach var="certificatesList"
							items="${productWrapper.certificateDetailsList}">
							<li>${certificatesList.value[1]}
							</li>
						</c:forEach>
					</ul>
				</c:when>	
				<c:otherwise>
				<ol>
				<c:forEach var="certificatesList"
							items="${productWrapper.certificateDetailsList}">
							<li>
							<span class="fontWeight600">${certificatesList.value[1]}</span>
							<c:if test="${productWrapper.product.productTemplateName == 'productTemplate2'}">
							<p>${certificatesList.value[2]}</p>
							</c:if>
							</li>
						</c:forEach>
						</ol>
				</c:otherwise>
				</c:choose>	
				</div>
			</div>
		</div>
	</div>
	</div>
</div>