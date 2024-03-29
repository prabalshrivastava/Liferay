<%@page import="com.sambaash.platform.product.permissions.ProductPermissionsUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="editOutLine">
	<portlet:param name="jspPage" value="/html/create/outline.jsp" />
	<portlet:param name="action" value="editOutLine"></portlet:param>
	<portlet:param name="activeClass" value="outline" />
</portlet:renderURL>
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
								<a href="${addOutline}" class="addproduct-btn"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outline.createOutline")%></a>
							</div>
						</c:if>	

						<%@ include file="/html/create/searchbar.jsp"%>
						
						
						

					</div>
					<div class="Border">
						<div class="Product_listing_table">
							<table>
								<thead>
									<tr>
										<th><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outline.competencyCode")%></th>
										<th><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outline.competencyDescription")%></th>
										<th><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outline.outlineType")%></th>
										<c:if test="<%= ProductPermissionsUtil.hasUpdatePermission(themeDisplay) %>">
											<th><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.edit")%></th>
										</c:if>
									</tr>
								</thead>
								
								<tbody id="productsContainer">
								<tr id="sampleProductRow" class="Row hide">
								
									
									<td id="competencyCode"><a id="outlineCodeEditLink"></a></td>
									<td id="competencyDesc"></td>
									<td id="outlineType"></td>
									<td>
									<div class="Pname_div">
								    <a href="#" class="threedot" id="threedot" title="Edit"></a>
									<div class="productUpdatebox Display-none">
										<ul>

											<c:if test="<%= ProductPermissionsUtil.hasUpdatePermission(themeDisplay) %>">
												<li><a id="outlineEditLink"><img id="outlineEditImg" alt="Edit">Edit</a></li>
											</c:if>
											
											
										</ul>
									</div>
								    </div>
									</td>
									
										
									
								
								</tr>
								
								
								</tbody>
								
								<tfoot>
								<tr>
								<td colspan="4">
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

	if (product && product.outlineId) {
		// clone the node - true indicates deep cloning
		var newRow = sampleRow.cloneNode(true);
		var id = product.outlineId;
		var pns = '<portlet:namespace />';
		

		//set id of product row
		newRow.set("id", "productRow_" + id);
		
		//setTextSafe(newRow.one("#competencyCode"), product.competencyCode);
		setTextSafe(newRow.one("#competencyDesc"), product.competencyDesc);
		setTextSafe(newRow.one("#outlineType"), product.outlineType);
		
		
		var ahref = "<%=editOutLine%>&"+ pns +"spOutlineId="+ id;
		addAttrSafe(newRow.one("#outlineCodeEditLink"), 'href', ahref);
		setTextSafe(newRow.one("#outlineCodeEditLink"), product.competencyCode);
			var ahref = "<%=editOutLine%>&"+ pns +"spOutlineId="+ id;
			addAttrSafe(newRow.one("#outlineEditLink"), 'href', ahref);
			var imgPath = "<%=request.getContextPath()%>/images/Product_create/Icon-Edit.svg";
			addAttrSafe(newRow.one("#outlineEditImg"), 'src', imgPath);

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
		config.actionMethod ="fetchOutlines";
		config.loadMoreNode = A.one("#loadMore");
		config.viewResultsText = A.one("#viewResultsText");
		config.resultCount = A.one("#resultCount");
		config.moreResult = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.action.moreResult")%>';
		config.noMoreResult = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.list.action.noMoreResult")%>';
		
		var obj = new productSearch(config);
	});

</script>

