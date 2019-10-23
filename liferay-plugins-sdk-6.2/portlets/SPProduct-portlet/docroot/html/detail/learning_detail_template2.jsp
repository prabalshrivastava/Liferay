<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
 <c:if test="${not empty learning.intro }">
<div id="Lp_Cont_8" class="section">
<h4 class="header prod-accrodion-h4 toggler-header-collapsed"><a href="#"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.sidebar.menu.howyoulearn")%></a> </h4>
<div class="content  toggler-content-collapsed">
        <section class="Course-structure-section" data-track-content
							data-content-name="${productWrapper.product.productName}"
							data-content-piece="How You Learn?">
            <div class="Course_wrap">
                <h2 class="course_h2"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.sidebar.menu.howyoulearn")%>?</h2>
            </div>
        </section>
       
	        <div class="Product-section-wrap">
	            <div class="desk-view-left">
	            </div>
	            <div class="desk-tab-view">
	                <div class="prod-cont-sec1">
	                <div class="course-expl">
	              <%--   <c:if test="${not empty LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.create.course.coursePersona") }"> --%>
						<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.our.approaches")%></h2>
					<%-- </c:if>	 --%>
						<p>${learning.intro }</p>
					</div>
	                </div>
	            </div>
	        </div>
        
</div>
</div>
</c:if>