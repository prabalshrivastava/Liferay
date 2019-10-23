<%@page import="com.sambaash.platform.product.permissions.ProductPermissionsUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>


<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="editModule">
	<portlet:param name="jspPage" value="/html/create/module.jsp" />
	<portlet:param name="action" value="editModule"></portlet:param>
	<portlet:param name="activeClass" value="module" />
</portlet:renderURL>


<portlet:renderURL var="copyModule">
	<portlet:param name="jspPage" value="/html/list/module.jsp" />
	<portlet:param name="action" value="copyModule"></portlet:param>
	<portlet:param name="activeClass" value="module" />
</portlet:renderURL>

<portlet:renderURL var="listCourse">
	<portlet:param name="jspPage" value="/html/list/course.jsp" />
	<portlet:param name="activeClass" value="courses" />
</portlet:renderURL>
<c:choose>
	<c:when test="<%= ProductPermissionsUtil.hasListViewPermission(themeDisplay) %>">

		<jsp:useBean id="htmlUtil" class="com.liferay.portal.kernel.util.HtmlUtil"/>
		<div class="product_createsection product_create screen-max-width">
			<div class="product_create_wrapper">
				<div class="Product_Sidebar">
					<%@ include file="/html/create/navigation.jsp"%>
				</div>
		
		
				<div class="Right_content_section">
					<div>
							<c:if test="<%= ProductPermissionsUtil.hasAddPermission(themeDisplay) %>">
							<div class="Productadd-section">
								<a href="${addModule}" class="addproduct-btn"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.module.createModule")%></a>
							</div>
						</c:if>	
						<div><%@ include file="/html/create/searchbar.jsp"%></div>
						
					</div>
					
					<!--CONTENT WRAP-->
					<div class="Border">
						<div class="Product_listing_table">
						
							<table>
								<thead>
									<tr>
										<th><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.module.moduleCode")%></th>
										<th><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.module.moduleName")%></th>
										<th><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.module.moduleDescription")%></th>
										<th>Actions</th>
									
									</tr>
								</thead>
								
							
							<tbody id="productsContainer">
								<tr id="sampleProductRow" class="Row hide">
								
									
									<td id="moduleCode"><a id="moduleCodeEditLink"></a></td>
									<td id="moduleName"></td>
									<td id="moduleDesc"></td>
										
									
											<td>
												<div class="Pname_div">
								
								
									
									<a href="#" class="threedot" id="threedot" title="Edit"></a>
									<div class="productUpdatebox Display-none">
										<ul>

											<c:if test="<%= ProductPermissionsUtil.hasUpdatePermission(themeDisplay) %>">
												<li><a id="moduleEditLink"><img id="moduleEditImg" alt="Edit">Edit Module</a></li>
											</c:if>
											<li>	<a id="moduleCopyLink"><img id="moduleCopyImg" alt="Module Copy">Copy Module</a></li>
											
											<li><a id="showCoursesHref"><img id="showCoursesHrefImg" alt="Show Courses">Show Courses</a></li>
											
											
											
										</ul>
									</div>
								</div>
											</td>
								
								</tr>
								
								
								</tbody>
								
								<tfoot>
								<tr>
								<td colspan="5">
								<div class="Loadmore_dot" id="loadMore"><a href="javascript:;"></a></div>
								<p id="viewResultsText" class="Loadmore_text"></p>
							
								</td>
								</tr>
								</tfoot>
								
						</table>
						
					</div>
					
					
						
					<!--CONTENT WRAP END-->
					
				</div>
				
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<%@ include file="/html/error.jsp"%>
	</c:otherwise>
</c:choose>


<script>

var data = {};
var requestUnderProcess = false;
var sampleRow = null;
var rowContainer = null;
var loadMoreNode = null;
var viewResultsText = null;
var reqUrl = null;
var loadMoreNode = null;
var searchText = null;
var endDate = null;
var startDate = null;
var resultCount = null;

var A = null;
var reqUrl = "<portlet:resourceURL id="" />";


function renderRowMethod(product) {

	if (product && product.moduleId) {
		// clone the node - true indicates deep cloning
		var newRow = sampleRow.cloneNode(true);
		var id = product.moduleId;
		var pns = '<portlet:namespace />';
		

		//set id of product row
		newRow.set("id", "productRow_" + id);

		//setTextSafe(newRow.one("#moduleCode"), product.moduleCode);
		setTextSafe(newRow.one("#moduleName"), product.moduleName);
		setTextSafe(newRow.one("#moduleDesc"),product.moduleDesc);
		
		
			var ahref = "<%=editModule%>&"+ pns +"spModuleId="+ id;
			addAttrSafe(newRow.one("#moduleCodeEditLink"), 'href', ahref);
			setTextSafe(newRow.one("#moduleCodeEditLink"), product.moduleCode);
			
			var ahref = "<%=editModule%>&"+ pns +"spModuleId="+ id;
			addAttrSafe(newRow.one("#moduleEditLink"), 'href', ahref);
			var imgPath = "<%=request.getContextPath()%>/images/Product_create/Icon-Edit.svg";
			addAttrSafe(newRow.one("#moduleEditImg"), 'src', imgPath);
			
			var ahref = "<%=copyModule%>&"+ pns +"spModuleId="+ id;
			addAttrSafe(newRow.one("#moduleCopyLink"), 'href', ahref);
			var imgPath = "<%=request.getContextPath()%>/images/Product_create/icon-relatedmodule.svg";
			addAttrSafe(newRow.one("#moduleCopyImg"), 'src', imgPath);
			addAttrSafe(newRow.one("#moduleCopyImg"), 'alt', "Copy Course");

			var ahrefCourse = "<%=listCourse%>&"+ pns +"searchName="+ escape(product.moduleName);
			addAttrSafe(newRow.one("#showCoursesHref").setAttribute('href', ahrefCourse));
			addAttrSafe(newRow.one("#showCoursesHref").setAttribute('title', 'Show all courses linked to ' + product.moduleName));
			var imgPath2 = "<%=request.getContextPath()%>/images/Product_create/create-new.png";
			addAttrSafe(newRow.one("#showCoursesHrefImg"), 'src', imgPath2);

				contextMenu(newRow);
			
		show(newRow);

		//TODO: onclick of this row, load applicant detail screen
		rowContainer.appendChild(newRow);
		}
					
}

function show (node){
	if (node) {
		node.removeClass("hide");
	}
}


function setTextSafe (node, text){
if (node) {
	node.set('text', text);
}
}

function addAttrSafe (node,key,value){
if(node){
	node.setAttribute(key,value);
}
}


AUI().ready('aui-node','aui-io-request', 'liferay-util-window','aui-io-plugin-deprecated',
			'stylesheet','aui-datepicker','overlay','event', 'widget-anim', function(A1) {
		 A = A1;
		 sampleRow = A.one("#sampleProductRow");
		 rowContainer = A.one("#productsContainer");
	 	 searchText = A.one("#searchText");
		 startDate = A.one("#startDate");
		 endDate = A.one("#endDate");
		
		 
		var config = {};
		config.renderRowMethod = renderRowMethod;
		config.rowContainer = rowContainer;
		config.reqUrl = reqUrl;
		config.searchText = searchText;
		config.startDate = startDate;
		config.endDate = endDate;
		config.actionMethod ="fetchModules";
		config.loadMoreNode = A.one("#loadMore");
		config.viewResultsText = A.one("#viewResultsText");
		config.resultCount = A.one("#resultCount");
		config.moreResult = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.action.moreResult")%>';
		config.noMoreResult = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.action.noMoreResult")%>';
		
		var obj = new productSearch(config);
	});
function setSarchText(){
	var url_string = document.URL;
	var url = new URL(url_string);
	var searchNameParam = url.searchParams.get("_Product_WAR_SPProductportlet_searchName");
	//var prdMenu = locs.split('_Product_WAR_SPProductportlet_searchName=')[1];
	//var prdMenuId = "";
	if (searchNameParam) {
		document.getElementById("searchText").value = unescape(searchNameParam);
	}
	
}
setSarchText();
</script>
