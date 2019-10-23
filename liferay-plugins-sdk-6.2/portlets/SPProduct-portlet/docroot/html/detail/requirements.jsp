<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="Lp_Cont_3" class="section">
<h4 class="header prod-accrodion-h4 toggler-header-collapsed"><a href="#"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.whoShouldAttend")%></a> </h4>
<div class="content  toggler-content-collapsed">
	<section class="Course-structure-section" data-track-content
		data-content-name="${productWrapper.product.productName}"
		data-content-piece="Ideal Candidates">
		<div class="Course_wrap ">
			<h2 class="course_h2"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.whoShouldAttend")%></h2>
		</div>
	</section>
	<div class="Product-section-wrap">
		<div class="desk-view-left"></div>
		<div class="desk-tab-view">
			<div class="prod-cont-sec1 ">
				<div class="course-expl">
					<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.whoShouldAttend")%></h2>
					<p>${productWrapper.course.personaDesc}</p>
				</div>
			</div>
		</div>
	</div>
</div>
</div>