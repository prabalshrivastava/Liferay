<%@page
	import="com.sambaash.platform.product.permissions.ProductPermissionsUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ page import="com.sambaash.platform.util.ThumbnailUtil"%>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>
<%@page import="javax.servlet.jsp.PageContext"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="editProduct">
	<portlet:param name="jspPage" value="/html/create/product.jsp" />
	<portlet:param name="action" value="editProduct" />
</portlet:renderURL>

<portlet:renderURL var="productDetail">
	<portlet:param name="jspPage" value="/html/detail/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="editCourses">
	<portlet:param name="jspPage" value="/html/create/course.jsp" />
	<portlet:param name="action" value="editCourse"></portlet:param>
	<portlet:param name="activeClass" value="courses" />
</portlet:renderURL>

<c:choose>
	<c:when
		test="<%=ProductPermissionsUtil.hasListViewPermission(themeDisplay)%>">
		<div
			class="product_createsection screen-max-width product_create margin-top-40">
			<div class="product_section_wrap product_create_wrapper">
				<div class="Product_Sidebar">
					<%@ include file="/html/create/navigation.jsp"%>
				</div>

				<div class="Right_content_section">
					<!--search Section-->
					<div class="search_section">
					 <div class="search_secWrapbar">
					    <div class="Calander_bar">
						<span id="startDateContainer">
							<div class="calander-section">
								<i class="Calander_icon"></i> <input class="calendarDate" type="text" name="startDate" id="startDate" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.startDate")%>">
							</div>
							</span>
							<div class="separate-horizontal"></div>
							<span id="endDateContainer">
							<div class="calander-section">
								<i class="Calander_icon"></i> <input class="calendarDate" type="text" name="endDate" id="endDate" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.endDate")%>">
							</div>
							</span>
						</div>
						<c:if
							test="<%=ProductPermissionsUtil.hasAddPermission(themeDisplay)%>">
							<div class="Productadd-section">
								<a href="${addProduct}" class="addproduct-btn"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.addProduct")%></a>
							</div>
						</c:if>
					 </div>
					  <div class="search_secWrapbar">
						<div class="search_bar">
							<i class="Search_icon" id="textSearchButton"></i> <input id="searchText" name="searchName" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.search")%>" type="text" value="">
						</div>
						
						
						<div class ="Search_Result_Count">
							<p id="resultCount"></p>
						</div>
					</div>
				</div>

					<div class="Border">
		
						<div class="Product_listing_table">
							<table>
								<thead>
									<tr>
										<th class="width-5"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.table.id")%></th>
										<th class="addStyle width-30 flexTD"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.table.productName")%></th>
										<th class="width-20"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.courseName")%></th>
										<th class="width-15"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.table.countryStatus")%></th>
										<th class="width-15"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.table.createDate")%></th>
										
								
										<th class="width-15"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.table.modifiedDate")%></th>
										<th class="width-10">Actions</th>
										
									</tr>
								</thead>
								
								<tbody id="productsContainer">
								<tr id="sampleProductRow" class="Row hide">
								
									
									<td class="Prod_id" id="productId"><a id="productIdHref"></a></td>
									<td class="flexTD"> <img id="imgUrl" alt="Product"> 	<h2 id="productName"><a id="productNameHref"></a> </h2></td>
									<td><p id="courseName"><a id="coursePageHref"></a></p></td>
									<td><span id="country"></span>
																<p id="countryName"></p></td>
									<td><p class="Date-Time" id="dateCreated"></p></td>
									<td><p class="Date-Time" id="dateModified"></p></td>
									<td><div class="Pname_div">
								
								
									
									<a href="#" class="threedot" id="threedot" title="Edit"></a>
									<div class="productUpdatebox Display-none">
										<ul>

											<c:if
												test="<%=ProductPermissionsUtil.hasPublishPermission(themeDisplay)%>">
												<li id="productMenu"><a id="productMenuLink"><img id="productMenuImg" alt="Product Publish"></a></li>
											</c:if>
											
											<c:if
												test="<%=ProductPermissionsUtil.hasUpdatePermission(themeDisplay)%>">
												<li><a id="updateMenuLink"><img id="updateMenuImg" alt="Update"></a></li>
											</c:if>
											<c:if
												test="<%=ProductPermissionsUtil.hasPreviewPermission(themeDisplay)%>">
												<li><a id="previewMenuLink"><img id="previewMenuImg" alt="Preview"></a></li>
											</c:if>
											
											
										</ul>
									</div>
								</div></td>
									
										
											
										
								
								</tr>
								
								
								</tbody>
								
								<tfoot>
								<tr>
								<td colspan="6">
								<div class="Loadmore_dot" id="loadMore"><a href="javascript:;"></a></div>
								<p id="viewResultsText" class="Loadmore_text"></p>
							
								</td>
								</tr>
								</tfoot>
	
							</table>
						</div>
						<!--CONTENT WRAP END-->
					</div>
					
					<!--search Section-->
			

					
							
					
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
var productUpdatebox = null;
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

function publishUnpublish(action,spProductId){
		var items = null;
		var reqUrl = '<portlet:resourceURL id="" />';
		var menuHtml = document.getElementById('productMenu_'+spProductId);

		try {
			startPreLoader("mainContainer");
			A.io.request(reqUrl, {
								cache : false,
								sync : true,
								timeout : 1000,
								dataType : 'json',
								method : 'post',
								data : {
									action : action,
									spProductId : spProductId
								},
								on : {
									complete : function(){
										stopPreLoader("mainContainer");
									},
									success : function() {
										var data = this.get('responseData');
										if (data) {
											if(data.error){
												alert(data.error);
											}else if(data.saveFlag == 'success'){
												var prod = document.getElementById('country_'+spProductId);
												if(action == 'Publish'){
													prod.className = 'color-dot-green';
													var ahref = 'javascript:publishUnpublish("Unpublish",' + spProductId + ')';
													var imgPath = "<%=request.getContextPath()%>/images/Product_create/Icon-UnPublish.svg";
													menuHtml.innerHTML = "<a href='"+ ahref +"'><img alt='Unpublish' src='"+ imgPath +"'>Unpublish</a>";
												}else{
													prod.className = 'color-dot-yellow';
													var ahref = 'javascript:publishUnpublish("Publish",' + spProductId + ')';
													var imgPath = "<%=request.getContextPath()%>/images/Product_create/Icon-Edit.svg";
													menuHtml.innerHTML = "<a href='"+ ahref +"'><img alt='Publish' src='"+ imgPath +"'>Publish</a>";
												}
																} else {
																	// This case is very very rare
																	alert("Error while"
																			+ action
																			+ "ing Product. Please refresh the screen and update");
																}
															} else {
																alert("Error while"
																		+ action
																		+ "ing Product");
															}
														},
														failure : function() {
															alert("Error while"
																	+ action
																	+ "ing Product");
														}
													}

												});
							} catch (err) {
								alert(err);
							}
						

	}


	
	 function show (node){
			if (node) {
				node.removeClass("hide");
			}
		}

	function renderRowMethod(product) {

		if (product && product.productId) {
			// clone the node - true indicates deep cloning
			var newRow = sampleRow.cloneNode(true);
			var id = product.productId;

			setTextSafe(newRow.one("#productIdHref"), product.productId);

			//set id of product row
			newRow.set("id", "productRow_" + id);

			newRow.one("#imgUrl").setAttribute('src', product.imgUrl);
			setTextSafe(newRow.one("#productNameHref"), product.productName);
			

			// add null check
			addAttrSafe(newRow.one("#productMenu"), 'id', 'productMenu_' + id);

			var ahref = "<%=productDetail%>?productId="+ id;
			newRow.one("#productNameHref").setAttribute('href', ahref);
			newRow.one("#productIdHref").setAttribute('href', ahref);
			
			var pns = '<portlet:namespace />';
			
			var ahrefCourse = "<%=editCourses%>&"+ pns +"spCourseId="+ product.courseId;
			newRow.one("#coursePageHref").setAttribute('href', ahrefCourse);
			
			setTextSafe(newRow.one("#coursePageHref"), product.courseName);
			setTextSafe(newRow.one("#countryName"), product.countryName);
			setTextSafe(newRow.one("#dateCreated"), product.dateCreated);
			setTextSafe(newRow.one("#dateModified"), product.dateModified);
			
			if(product.status == 'Unpublish'){
				newRow.one("#country").setAttribute('class', 'color-dot-yellow');
				var ahref = 'javascript:publishUnpublish("Publish",' + id + ')';
				addAttrSafe(newRow.one("#productMenuLink"), 'href', ahref);
				var imgPath = "<%=request.getContextPath()%>/images/Product_create/tool.svg";
				addAttrSafe(newRow.one("#productMenuImg"), 'src', imgPath);
				newRow.one("#productMenuLink").appendChild('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.action.publish")%>');
				
			}else{
				newRow.one("#country").setAttribute('class', 'color-dot-green');
				var ahref = 'javascript:publishUnpublish("Unpublish",' + id + ')';
				addAttrSafe(newRow.one("#productMenuLink"), 'href', ahref);
				var imgPath = "<%=request.getContextPath()%>/images/Product_create/Icon-UnPublish.svg";
				addAttrSafe(newRow.one("#productMenuImg"), 'src', imgPath);
				newRow.one("#productMenuLink").appendChild('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.action.unpublish")%>');
			}
			addAttrSafe(newRow.one("#country"), 'id', 'country_'+id);
				
			var ahref = "<%=editProduct%>&productId="+ id;
			addAttrSafe(newRow.one("#updateMenuLink"), 'href', ahref);
			var imgPath = "<%=request.getContextPath()%>/images/Product_create/Icon-Update.svg";
			addAttrSafe(newRow.one("#updateMenuImg"), 'src', imgPath);
			newRow.one("#updateMenuLink").appendChild('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.action.update")%>');
			
			var ahref = "<%=productDetail%>?productId="+ id;
			addAttrSafe(newRow.one("#previewMenuLink"), 'href', ahref);
			var imgPath = "<%=request.getContextPath()%>/images/Product_create/Preview.svg";
			addAttrSafe(newRow.one("#previewMenuImg"), 'src', imgPath);
			newRow.one("#previewMenuLink").appendChild('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.action.preview")%>');
			
		

			contextMenu(newRow);

			show(newRow);

			//TODO: onclick of this row, load applicant detail screen
			rowContainer.appendChild(newRow);
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
		 productUpdatebox = A.one("#productUpdatebox");
		 searchText = A.one("#searchText");
		 startDate = A.one("#startDate");
		 endDate = A.one("#endDate");
		
		 
		var config = {};
		config.renderRowMethod = renderRowMethod;
		config.rowContainer = rowContainer;
		config.reqUrl = reqUrl;
		//config.start = start;
		//config.pageSize = pageSize;
		config.searchText = searchText;
		config.startDate = startDate;
		config.endDate = endDate;
		config.actionMethod ="fetchProducts";
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
