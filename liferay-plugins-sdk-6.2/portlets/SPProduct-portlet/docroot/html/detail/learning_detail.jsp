<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

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
        <c:if test="${not empty learning }">
	        <div class="Product-section-wrap">
	            <div class="desk-view-left">
	            </div>
	            <div class="desk-tab-view">
	                <div class="prod-cont-sec1">
	                	<div class="topDesc">
	                		${learning.intro }
	                	</div>
	                    <div class="Entry-middle ">
	                        <div class="Entrymodule">
	                        <div class="enrolText"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.howyoulearnenroll.message")%></div>
	                            <div class="table-all learning-duration">
	                            <div class="durationTitle">
	                                <h2>${duration.title}</h2>
	                                </div>
	                                <table>
	                                    <tbody>
	                                    <c:forEach var="durationType" items="${durationTypes}">
	                                        <tr>
	                                            <td>
	                                            	<span class="hrsText">${durationType.title1 }</span><br><span class="hrsNum">${durationType.duration1 }</span>
	                                            </td>
	                                            <td>
	                                            	<span class="hrsText">${durationType.title2 }</span><br><span class="hrsNum">${durationType.duration2 }</span>
	                                            </td>
	                                        </tr>
	                                     </c:forEach>   
	                                    </tbody>
	                                </table>
	                            </div>
	                            <div class="table-all study-options">
	                            <div class="durationTitle">
	                                <h2>${learning.optionTitle }</h2>
	                              </div>  
	                                <table>
	                                    <tbody>
	                                        <tr>
	                                            <td>${learning.option1 }</td>
	                                            <td>${learning.option2 }</td>
	                                        </tr>
	                                    </tbody>
	                                </table>
	                            </div>
	                            <div class="bot-para-mob">
	                                <p> ${learning.note }
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
        </c:if>
</div>
</div>