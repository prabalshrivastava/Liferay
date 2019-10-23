<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="Lp_Cont_2" class="section">
<h4 class="header prod-accrodion-h4 toggler-header-collapsed"><a href="#"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseStructure")%></a> </h4>
<div class="content  toggler-content-collapsed">
	<section class="Course-structure-section" data-track-content
		data-content-name="${productWrapper.product.productName}"
		data-content-piece="Course Structure">
		<div class="Course_wrap">
			<h2 class="course_h2"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseStructure")%></h2>
		</div>
	</section>
	<div class="Product-section-wrap">
		<div class="desk-view-left"></div>
		<div class="desk-tab-view">
			<div class="prod-cont-sec1 ">
				<div class="course-expl course-desc">
					<%-- <h2>${productWrapper.course.courseName}</h2> --%>
					<p>${productWrapper.course.courseDesc}</p>
				</div>
				<div class="course-middle">
					<div class="coremodule" id="coreModule">
						<%
							int i = 1;
						%>
						<c:forEach var="moduleDetailsList"
							items="${productWrapper.moduleDetailsList}">
							<div class="Course_struc_div" id="CT<%=i%>">
								
								<div class="mob_Tabcontent disp-hid " id="Lp<%=i%>_M"></div>
								<div class="mob_Tabcontent  disp-hid" id="Sp<%=i%>_M"></div>
							</div>


							
							<div id="Sp<%=i%>_Outline">
								<div class="table-Entry">
									<table>
										<tbody>
											<tr>
												<td><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.module.moduleName")%></td>
												<td>
												<%-- <h4>${moduleDetailsList.value[1] }</h4> --%>
													<h4>${moduleDetailsList.value[2] }</h4>
												</td>
											</tr>
												<tr>
													<td><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.description")%></td>
													<td>${moduleDetailsList.value[4]}</td>
												</tr>
											</tbody>
									</table>
								</div>

							</div>
							<!--  lp2 schedule  -->
							<!-- lp2 outline -->
							<%
								i = i + 1;
							%>
						</c:forEach>
					</div>
					<!--  core module -->
				</div>
			</div>
			
		</div>
	</div>
	</div>
</div>
