<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="Lp_Cont_2" class="section">
<h4 class="header prod-accrodion-h4 toggler-header-collapsed"><span><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseStructure")%></span> </h4>
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
					<h2>${productWrapper.course.courseName}</h2>
					<p>${productWrapper.course.courseDesc}</p>
				</div>
				<div class="course-middle">
					<div style="display:inline-block"><h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseModules")%> :</h2></div>
					<div style="display:inline-block;float:right;">
										<span class="linline-bl list-imgsec1">
											<img
												src="<%=request.getContextPath()%>/images/product/icon_dark_file.svg" alt="Outline">
										</span>
										<span style="font-size:11px;margin-right: 5px;"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.sidebar.menu.outline")%></span>
										<span class="linline-bl list-imgsec1">
											<img
												src="<%=request.getContextPath()%>/images/product/icon_dark_calendar.svg" alt="Schedule">
										</span>
										<span style="font-size:11px"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.update.moduels.schedule")%></span>
							</div>
					<div class="coremodule" id="coreModule">
						<%
							int i = 1;
						%>
						<c:forEach var="moduleDetailsList"
							items="${productWrapper.moduleDetailsList}">
							<div class="Course_struc_div" id="CT<%=i%>">
								<div class="light-pink color-black borderlight inner-core">
									<div class="list-cont">
										<div class="linline-bl list-para1 ">
											<p class="Lp_para Lp_para_main">${moduleDetailsList.value[1] }
												- ${moduleDetailsList.value[2] }</p>
											<h2 class="Lp_para Lp_para_exp" id="sectionName-<%=i%>"></h2>
										</div>
										<div class="linline-bl list-file Lp_Mobtab" id="Sp<%=i%>"
											title="Outline">
											<a href="#"><img
												src="<%=request.getContextPath()%>/images/product/icon_dark_file.svg" alt="Outline"></a>
										</div>
										<div class="linline-bl list-file-cal Lp_Mobtab" id="Lp<%=i%>"
											title="Schedule">
											<a href="#"><img
												src="<%=request.getContextPath()%>/images/product/icon_dark_calendar.svg" alt="Schedule"></a>
										</div>
									</div>
								</div>
								<div class="mob_Tabcontent disp-hid " id="Lp<%=i%>_M"></div>
								<div class="mob_Tabcontent  disp-hid" id="Sp<%=i%>_M"></div>
							</div>


							<div id="Lp<%=i%>_Schedule" class="Empty-none">
								<div class="table-Entry">
									<table>
										<thead>
											<tr>
												<th class="wid-100"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.module.moduleName")%></th>
												<th>
													<h4>${moduleDetailsList.value[2] }</h4>
												</th>
											</tr>
										</thead>
									</table>
								</div>
								<div class="col-shedule">
									<table class="rwd-table">
										<tr>
											<th><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.session")%></th>
											<th><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.sidebar.menu.outline")%></th>
											<th><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.activities")%></th>
										</tr>
										<%
											int j = 1;
										%>
										<c:forEach var="scheduleDetailsList"
											items="${productWrapper.scheduleDetailsList}">
											<c:if
												test="${scheduleDetailsList.value[2] == moduleDetailsList.value[0] }">
												<tr>
													<td data-th="Session">
														<div class="div-align-tab">
															<h1>${scheduleDetailsList.value[0] }</h1>
														</div>
													</td>
													<td data-th="Outline">
														<div class="div-align-tab">
															${scheduleDetailsList.value[1] }</div>
													</td>
													<td data-th="Activities">
														<div class="div-align-tab">
															${scheduleDetailsList.value[3] }</div>
													</td>
												</tr>
												<%
													j = j + 1;
												%>
											</c:if>
										</c:forEach>
									</table>
								</div>
								<div class="pro-bot-link bot-link-outline" data-track-content
									data-content-name="${productWrapper.product.productName}"
									data-content-piece="Course Outline">
									<h1>
										<a><span onclick="showOutlineClick(event,<%=i%>)"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.outline")%>
												</span></a>
									</h1>
								</div>
							</div>
							<div id="Sp<%=i%>_Outline" class="Empty-none">
								<div class="table-Entry">
									<table>
										<thead>
											<tr>
												<th><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.module.moduleName")%></th>
												<th>
													<h4>${moduleDetailsList.value[2] }</h4>
												</th>
											</tr>
										</thead>
										<c:if test="${displayCompetency eq true}">
											<tbody>
												<tr>
													<td><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.competencyUnit")%></td>
													<td>${moduleDetailsList.value[9] }</td>
												</tr>
											</tbody>
										</c:if>
									</table>
									<div class="course-exp2">${moduleDetailsList.value[10] }
									</div>
								</div>

								<div class="pro-bot-link-right bot-link-schedule"
									data-track-content
									data-content-name="${productWrapper.product.productName}"
									data-content-piece="Course Schedule">
									<h1>
										<a><span onclick="showScheduleClick(event,<%=i%>)">Course
												Schedule</span></a>
									</h1>
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
<script>
function showOutlineClick(e,j) {
    e.preventDefault();
    var tabItems = document.getElementsByClassName('Lp_Mobtab active');
    var selectedContent;
    for (var i = 0; i < tabItems.length; i++) {
    	var classNames = tabItems[i].getAttribute("class");
    	if(classNames.indexOf('active') > -1){
    		selectedContent = tabItems[i];
    	}
        tabItems[i].classList.remove('active');
    }
    
    var actualContent = selectedContent.previousSibling.previousSibling;
    var Outlineshow = actualContent.getAttribute('id');

    var expToHide = document.getElementsByClassName('Lp_para_exp');
    var maintitle = document.getElementsByClassName('Lp_para_main');

    for (var i = 0; i < maintitle.length; i++) {
        maintitle[i].classList.remove('disp-hid');
        expToHide.innerHTML = '';
    }

    var contshowParent = actualContent.parentNode;
    var textNode = contshowParent.childNodes[1].childNodes[1];
    textNode.classList.add('disp-hid');
    var ttNode = document.getElementById("sectionName-"+j);
    ttNode.childNodes.item(0).data = 'Outline';
    var h1 =  document.getElementsByClassName('Course_struc_div');
    var h2 =  h1.length;
    var h3 =  ttNode.scrollHeight*h2;
    var sTop = document.getElementById('coreModule').offsetTop;
   
    window.scrollTo(0,sTop); 
    var id = Outlineshow + '_Outline';
    var Outlined = document.getElementById(id);
    var Outlinecontent = Outlined.innerHTML;
    var Outcont = document.getElementById(Outlineshow + '_M');
    if (Outcont) {
        Outcont.innerHTML = Outlinecontent;
        actualContent.classList.add("active");
    }
    var inscont1 = document.getElementsByClassName('mob_Tabcontent');
    for (var i = 0; i < inscont1.length; i++) {
        inscont1[i].classList.add('disp-hid');
    }
    if (Outcont) {
        Outcont.classList.remove('disp-hid');
        Outcont.classList.add('.active-list');
    }
}

function showScheduleClick(e,j) {
    e.preventDefault();
    var tabItems = document.getElementsByClassName('Lp_Mobtab active');
    var selectedContent;
    for (var i = 0; i < tabItems.length; i++) {
    	var classNames = tabItems[i].getAttribute("class");
    	if(classNames.indexOf('active') > -1){
    		selectedContent = tabItems[i];
    	}
        tabItems[i].classList.remove('active');
    }
    
    var actualContent = selectedContent.nextSibling.nextSibling;
    var Outlineshow = actualContent.getAttribute('id');
	
    var expToHide = document.getElementsByClassName('Lp_para_exp');
    var maintitle = document.getElementsByClassName('Lp_para_main');

    for (var i = 0; i < maintitle.length; i++) {
        maintitle[i].classList.remove('disp-hid');
        expToHide.innerHTML = '';
    }

    var contshowParent = actualContent.parentNode;
    var textNode = contshowParent.childNodes[1].childNodes[1];
    textNode.classList.add('disp-hid');
    var ttNode = document.getElementById("sectionName-"+j);
    ttNode.childNodes.item(0).data = 'Schedule';
    var h1 =  document.getElementsByClassName('Course_struc_div');
    var h2 =  h1.length;
    var h3 =  ttNode.scrollHeight*h2;
    var sTop = document.getElementById('coreModule').offsetTop;
   
    window.scrollTo(0,sTop);
    var id = Outlineshow + '_Schedule';
    var Outlined = document.getElementById(id);
    var Outlinecontent = Outlined.innerHTML;
    var Outcont = document.getElementById(Outlineshow + '_M');
    if (Outcont) {
        Outcont.innerHTML = Outlinecontent;
        actualContent.classList.add("active");
    }
    var inscont1 = document.getElementsByClassName('mob_Tabcontent');
    for (var i = 0; i < inscont1.length; i++) {
        inscont1[i].classList.add('disp-hid');
    }
    if (Outcont) {
        Outcont.classList.remove('disp-hid');
        Outcont.classList.add('.active-list');
    }
}
</script>
