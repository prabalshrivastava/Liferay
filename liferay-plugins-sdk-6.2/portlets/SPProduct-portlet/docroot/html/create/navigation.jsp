<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%
boolean showFeeComponent = GetterUtil.getBoolean(portletPreferences.getValue("showFeeComponent", ""));
%>
<liferay-theme:defineObjects />
<portlet:renderURL var="listFramework">
	<portlet:param name="jspPage" value="/html/list/framework.jsp" />
	<portlet:param name="activeClass" value="framework" />
	<portlet:param name="action" value="listFramework"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="listCompetency">
	<portlet:param name="jspPage" value="/html/list/competency.jsp" />
	<portlet:param name="activeClass" value="competency" />
</portlet:renderURL>

<portlet:renderURL var="listModule">
	<portlet:param name="jspPage" value="/html/list/module.jsp" />
	<portlet:param name="activeClass" value="module" />
</portlet:renderURL>

<portlet:renderURL var="listOutline">
	<portlet:param name="jspPage" value="/html/list/outline.jsp" />
	<portlet:param name="activeClass" value="outline" />
</portlet:renderURL>

<portlet:renderURL var="listCertificate">
	<portlet:param name="jspPage" value="/html/list/certificate.jsp" />
	<portlet:param name="activeClass" value="certificate" />
</portlet:renderURL>

<portlet:renderURL var="listCourse">
	<portlet:param name="jspPage" value="/html/list/course.jsp" />
	<portlet:param name="activeClass" value="courses" />
</portlet:renderURL>

<portlet:renderURL var="listProduct">
	<portlet:param name="jspPage" value="/html/list/product.jsp" />
	<%-- <portlet:param name="jspPage" value="/html/detail/view.jsp" /> --%>
	<portlet:param name="activeClass" value="product" />
</portlet:renderURL>

<portlet:renderURL var="addFramework">
	<portlet:param name="jspPage" value="/html/create/framework.jsp" />
	<portlet:param name="activeClass" value="framework" />
</portlet:renderURL>

<portlet:renderURL var="addCompetency">
	<portlet:param name="jspPage" value="/html/create/competency.jsp" />
	<portlet:param name="activeClass" value="competency" />
</portlet:renderURL>

<portlet:renderURL var="addModule">
	<portlet:param name="jspPage" value="/html/create/module.jsp" />
	<portlet:param name="activeClass" value="module" />
</portlet:renderURL>

<portlet:renderURL var="addOutline">
	<portlet:param name="jspPage" value="/html/create/outline.jsp" />
	<portlet:param name="activeClass" value="outline" />
</portlet:renderURL>

<portlet:renderURL var="addCertificate">
	<portlet:param name="jspPage" value="/html/create/certificate.jsp" />
	<portlet:param name="activeClass" value="certificate" />
</portlet:renderURL>

<portlet:renderURL var="addCourse">
	<portlet:param name="jspPage" value="/html/create/course.jsp" />
	<portlet:param name="activeClass" value="courses" />
</portlet:renderURL>

<portlet:renderURL var="addProduct">
	<portlet:param name="jspPage" value="/html/create/product.jsp" />
	<portlet:param name="activeClass" value="product" />
</portlet:renderURL>

<portlet:renderURL var="manageFeeComponent">
	<portlet:param name="jspPage" value="/html/list/fee_component.jsp" />
	<portlet:param name="activeClass" value="feeComponent" />
</portlet:renderURL>

<div class="Right_iconmenu" id="rightIconMenuId">
	<ul id="navMenuAdmin" class="navMenu">
		<li class="sidebar-Header">

			<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.header.title")%></h2>

		</li>
		<li>
			<div class="Menuitem">
				<a href="<%=listProduct%>" class="Active-ProductMenu productnav"
					id="product">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.product")%></h2>
				</a>
 			<div class="productSiderbar" id="productSiderbar" style="display:none">
					<%@ include file="/html/create/product_sidebar.jsp"%>
				</div>
					
			</div>
		</li>
		<li>
			<div class="Menuitem">
				<a href="<%=listCourse%>" class="productnav"
					id="courses">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.courses")%></h2>
				</a>
				<div class="courseSiderbar" id="courseSiderbar" style="display:none">
					<%@ include file="/html/create/course_sidebar.jsp"%>
				</div>	
				
			</div>
		</li>
		<li>
			<div class="Menuitem">
				<a href="<%=listModule%>" id="module" class="productnav">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.modules")%></h2>
				</a>
			</div>
		</li>
		<li>
			<div class="Menuitem">
				<a href="<%=listCertificate%>" id="certificate" class="productnav">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.certificate")%></h2>
				</a>
			</div>
		</li>
		<li>
			<div class="Menuitem">
				<a href="<%=listOutline%>" id="outline" class="productnav">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.outline")%></h2>
				</a>
			</div>
		</li>
		<li>
			<div class="Menuitem">
				<a href="<%=listCompetency%>" id="competency" class="productnav">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.competencyUnits")%></h2>
				</a>
			</div>
		</li>
		<li>
			<div class="Menuitem">
				<a href="<%=listFramework%>" id="framework" class="productnav">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.framework")%></h2>
				</a>
			</div>
		</li>

		<c:if test="<%= showFeeComponent%>">
		<li>
			<div class="Menuitem">
				<a href="<%=manageFeeComponent%>" id="feeComponent" class="productnav">
					<h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.feeComponent")%></h2>
				</a>
			</div>
		</li>
		</c:if>
	</ul>
</div>
<script type="text/javascript">
	function Rightmenu_toggle(el, className) {
		var el = document.querySelectorAll(el);

		for (i = 0; i < el.length; i++) {

			if (el[i].classList) {
				el[i].classList.toggle(className);
			} else {
				var classes = el[i].className.split(' ');
				var existingIndex = -1;
				for (var j = classes.length; j--;) {
					if (classes[j] === className)
						existingIndex = j;
				}

				if (existingIndex >= 0)
					classes.splice(existingIndex, 1);
				else
					classes.push(className);

				el[i].className = classes.join(' ');
			}
		}
	}

	function setActiveClass() {
		var locs = document.URL;
		var prdMenu = locs.split('_Product_WAR_SPProductportlet_activeClass=')[1];
		var prdMenuId = "";
		if (prdMenu) {
			prdMenuId = prdMenu.split('&')[0];
		}
		//showSubMenu(prdMenuId);
		var menuUrls = document.getElementById(prdMenuId);
		var menuCourses = document.querySelectorAll('.navMenu li a.productnav');
		for (var i = menuCourses.length - 1; i >= 0; i--) {
			menuCourses[i].setAttribute("class", "unactive productnav");
		}
		if (menuUrls) {
			menuUrls.setAttribute("class", "Active-ProductMenu productnav");
		} else {
			document.getElementById("product").setAttribute("class",
					"Active-ProductMenu productnav");
		}
		setCourseActiveClass();
	}
	
	function showSubMenu(menuId) {
			document.getElementById(menuId).style.display ="block";
	}
	

	setActiveClass();
	
</script>

