<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="Lp_Cont_3" class="section">
<h4 class="header prod-accrodion-h4 toggler-header-collapsed"><a href="#"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.whoShouldAttend")%></a> </h4>
<div class="content  toggler-content-collapsed">
	<section class="Course-structure-section" data-track-content
		data-content-name="${productWrapper.product.productName}"
		data-content-piece="Ideal Candidates">
		<div class="Course_wrap ">
			<h2 class="course_h2"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.idealCandidates")%></h2>
		</div>
	</section>
	<div class="Product-section-wrap">
		<div class="desk-view-left"></div>
		<div class="desk-tab-view">
			<div class="prod-cont-sec1 ">
				<div class="course-expl">
					<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.create.course.coursePersona")%></h2>
					<p>${productWrapper.course.personaDesc}</p>
				</div>
			</div>
		</div>
	</div>
	<div class="Product-section-wrap">
		<div class="desk-view-left"></div>
		<div class="desk-tab-view">
			<div class="prod-cont-sec1 without-paddding-wrap ">
			<div class="course-expl ">
					<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.whoShouldAttend")%></h2>
				</div>
				<div class="Who-sholud-attend-sec who-should-attend-desktop">
					<div class="who-should-attend">
						<ul>
							<c:forEach var="personaList"
								items="${productWrapper.personaDetailsList}" varStatus="status">
								<c:choose>
									<c:when test='${(status.index)%2 eq 0}'>
										<li>
											<div class="Wsa_image">
												<img src="${personaList.value[4]}" alt="Persona">
											</div>
											<div class="Wsa_content">
												<p>${personaList.value[1] }</p>
											</div>
										</li>
									</c:when>
									<c:otherwise>
										<li>
											<div class="Wsa_content">
												<p>${personaList.value[1] }</p>
											</div>
											<div class="Wsa_image">
												<img src="${personaList.value[4]}" alt="Persona">
											</div>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</div>
				</div>
				<!--  who should attend for mobile view -->
				<div class="Who-sholud-attend-sec who-should-attend-mobile">
					<div class="who-should-attend">
						<ul>
							<c:forEach var="personaList"
								items="${productWrapper.personaDetailsList}" varStatus="status">
										<li>
											<div class="Wsa_image">
												<img src="${personaList.value[4]}" alt="Persona">
											</div>
											<div class="Wsa_content">
												<p>${personaList.value[1] }</p>
											</div>
										</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>
</div>
