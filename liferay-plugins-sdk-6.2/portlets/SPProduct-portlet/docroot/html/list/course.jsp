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


<portlet:renderURL var="copyCourse">
	<portlet:param name="jspPage" value="/html/list/course.jsp" />
	<portlet:param name="action" value="copyCourse"></portlet:param>
	<portlet:param name="activeClass" value="courses" />
</portlet:renderURL>

<portlet:renderURL var="editCourses">
	<portlet:param name="jspPage" value="/html/create/course.jsp" />
	<portlet:param name="action" value="editCourse"></portlet:param>
	<portlet:param name="activeClass" value="courses" />
</portlet:renderURL>


<portlet:renderURL var="listProduct">
	<portlet:param name="jspPage" value="/html/list/product.jsp" />
	<%-- <portlet:param name="jspPage" value="/html/detail/view.jsp" /> --%>
	<portlet:param name="activeClass" value="product" />
</portlet:renderURL>

<portlet:renderURL var="listModule">
	<portlet:param name="jspPage" value="/html/list/module.jsp" />
	<portlet:param name="activeClass" value="module" />
</portlet:renderURL>

<style>
<!--
.addStyle{ 
width:150px;
}
-->
</style>



<jsp:useBean id="htmlUtil" class="com.liferay.portal.kernel.util.HtmlUtil"/>
<c:choose>
	<c:when test="<%= ProductPermissionsUtil.hasListViewPermission(themeDisplay) %>">
		<div class="product_createsection product_create screen-max-width">
			<div class="product_create_wrapper">
				<div class="Product_Sidebar">
					<%@ include file="/html/create/navigation.jsp"%>
				</div>
		
		
				<div class="Right_content_section">
					<div>
						<c:if test="<%= ProductPermissionsUtil.hasAddPermission(themeDisplay) %>">
							<div class="Productadd-section">
								<a href="${addCourse}" class="addproduct-btn"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.course.createCourse")%></a>
							</div>
						</c:if>	
						<div><%@ include file="/html/create/searchbar.jsp"%>
						</div>
						
						
					</div>
					<div class="Border">
		
						<div class="Product_listing_table">
							<table>
								<thead>
									<tr>
										<th class="addStyle width-20"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseCode")%></th>
										<th class="width-20"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseName")%></th>
										<th class="width-50"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseDescription")%></th>
									
										<th class="width-10">Actions</th>
									
									</tr>
								</thead>
								
								<tbody id="productsContainer">
								<tr id="sampleProductRow" class="Row hide">
								
									
									<td id="courseCode"><a id="courseCodeEditLink"></a></td>
									<td id="courseName"></td>
									<td id="courseDesc"></td>
										
											
										

									
									<td>	
										<div class="Pname_div">
											<a href="#" class="threedot"  title="Edit"></a>
									<div class="productUpdatebox Display-none">
										<ul>

												<c:if test="<%= ProductPermissionsUtil.hasUpdatePermission(themeDisplay) %>">
												<li>
														<a id="courseEditLink"><img id="courseEditImg" alt="Edit">Edit</a>
													</li>
													
											</c:if>
											
										<li>
												<a id="courseCopyLink"><img id="courseCopyImg" alt="Copy">Copy Course</a>
													</li>
											<li><a id="showProductsHref" ><img id="showProductsHrefImg" alt="Copy">Show Product</a></li>
											<li><a id="showModulesHref" ><img id="showModulesHrefImg" alt="Copy">Show Module</a></li>
											
											
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

	if (product && product.courseId) {
		// clone the node - true indicates deep cloning
		var newRow = sampleRow.cloneNode(true);
		var id = product.courseId;
		var pns = '<portlet:namespace />';
		

		//set id of product row
		newRow.set("id", "productRow_" + id);

		//setTextSafe(newRow.one("#courseCode"), product.courseCode);
		setTextSafe(newRow.one("#courseName"), product.courseName);
		setTextSafe(newRow.one("#courseDesc"), product.courseDesc);
		
		
		var ahref = "<%=editCourses%>&"+ pns +"spCourseId="+ id;
		addAttrSafe(newRow.one("#courseCodeEditLink"), 'href', ahref);
		setTextSafe(newRow.one("#courseCodeEditLink"), product.courseCode);
			var ahref = "<%=editCourses%>&"+ pns +"spCourseId="+ id;
			addAttrSafe(newRow.one("#courseEditLink"), 'href', ahref);
			var imgPath = "<%=request.getContextPath()%>/images/Product_create/Icon-Edit.svg";
			addAttrSafe(newRow.one("#courseEditImg"), 'src', imgPath);
			addAttrSafe(newRow.one("#courseEditImg"), 'alt', "Edit Course");
			
			var ahref = "<%=copyCourse%>&"+ pns +"spCourseId="+ id;
			addAttrSafe(newRow.one("#courseCopyLink"), 'href', ahref);
			var imgPath = "<%=request.getContextPath()%>/images/Product_create/Icon-Copy.svg";
			addAttrSafe(newRow.one("#courseCopyImg"), 'src', imgPath);
			addAttrSafe(newRow.one("#courseCopyImg"), 'alt', "Copy Course");

			
			var ahrefCourse = "<%=listProduct%>&"+ pns +"searchName="+ escape(product.courseName);
			addAttrSafe(newRow.one("#showProductsHref").setAttribute('href', ahrefCourse));
			addAttrSafe(newRow.one("#showProductsHref"), 'title', 'Show all products linked to ' + product.courseName);
			var imgPath1 = "<%=request.getContextPath()%>/images/Product_create/icon-relatedproduct.svg";
			addAttrSafe(newRow.one("#showProductsHrefImg"), 'src', imgPath1);
		
			var ahrefCourse = "<%=listModule%>&"+ pns +"searchName="+ escape(product.courseName);
			addAttrSafe(newRow.one("#showModulesHref").setAttribute('href', ahrefCourse));
			addAttrSafe(newRow.one("#showModulesHref"), 'title', 'Show all modules linked to ' + product.courseName);
			var imgPath2 = "<%=request.getContextPath()%>/images/Product_create/icon-relatedmodule.svg";
			addAttrSafe(newRow.one("#showModulesHrefImg"), 'src', imgPath2);
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
		config.actionMethod ="fetchCourses";
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
function showTooltip(id, message){
	AUI().ready('aui-tooltip', 'aui-io-plugin', function(A) {
		var tooltip = new A.Tooltip({
			trigger: '#'+id,
			align: { points: [ 'lc', 'rc' ] },
			showArrow: false,
			bodyContent: message
		})
		.render();
	});
}




</script>
