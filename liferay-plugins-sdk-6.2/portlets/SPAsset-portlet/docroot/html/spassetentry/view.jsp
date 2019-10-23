
<%@ include file="/html/init.jsp"%>

<portlet:actionURL var="createAssestEntryURL" name="displayCreateAssetEntry">
</portlet:actionURL>

<portlet:actionURL var="editAssestEntryURL" name="displayUpdateAssetEntry">
	<portlet:param name="mvcPath"
		value="/html/spassetentry/editAssetEntry.jsp"></portlet:param>
</portlet:actionURL>

<portlet:actionURL var="deleteAssestEntryURL" windowState="normal"
	name="deleteAssetEntry" />
<liferay-portlet:resourceURL var="downloadAssetEntryUrl"
	id="downloadFiles"></liferay-portlet:resourceURL>

<portlet:actionURL var="searchAssetEntryActionURL" windowState="normal"
	name="searchAssetEntry" />
	
<div class="galleryListing">

<div class="galleryListing-add"> 
	<aui:form action='<%=searchAssetEntryActionURL%>'
		name='<portlet:namespace />searchForm' method="post" id="search_form"
		class="search_form" style="width:90%">

		<input type="text" name="<portlet:namespace/>searchText"
			id="<portlet:namespace/>searchText" value="${searchText}"
			style="width: 20%!important;" />
		<aui:button type="submit"
			value='<%=LanguageUtil.get(pageContext,"label.search")%>'
			onClick="submitForm();" id="search_formBtn" cssClass="searchButton" />
	</aui:form>
	<aui:form>
		<c:if test="${addAssetEntryPermission}">
			<aui:button cssClass="add-galleryBtn btn btn-info icon-pluss btn-primary"
				onClick="<%=createAssestEntryURL%>"
				value='<%=LanguageUtil.get(pageContext,"label.add")%>'
				id="add-galleryBtn" />
		</c:if>
	</aui:form>
	
</div> 
		<div class="thumb_outer listAlign-center ${styleType}"
			id="galleryList">
			
			<c:forEach var="assetEntry" items="${assetList}">

				<div class="thumb_display search-stream-mosaic-block">
					<div
						class="search-stream-mosaic-content-wrap bg-white img-tn-medium-container">
						<div class="thumb_pic img-tn-medium bg-transparent">
							<a href="${assetEntry.value[1]}" target="_self"> <img
								src="${assetEntry.value[0]}" alt="Image" />
							</a>
							<%-- onClick="${editAssestURL}&spAssetTypeId=${assetType.spAssetTypeId}" --%>
						</div>
						<div class="search-stream-mosaic-block-content section-bg">
							<div class="content-title h5">
								<a href="${assetEntry.value[1]}" target="_self"> ${assetEntry.value[2]} </a>
							</div>
							<c:if test="${assetEntry.value[3] != ''}">
							<div
								class="search-stream-mosaic-block-description p">
								${assetEntry.value[3]}</div>
							</c:if>
							<div
								class="search-stream-mosaic-block-author1 copy-caption">
								<a href="#" target="_self">${assetEntry.value[4]}
								</a> <br> ${assetEntry.value[5]}
							</div>
						</div>

						<div class="edit-overlay-box">
							<div class="edit_area ${isEditIconOnTop}">
								<c:if test="${assetEntry.value[6]}">
									<aui:button title="Edit" cssClass="btn icon-edit"
										onClick="${editAssestEntryURL}&spAssetEntryId=${assetEntry.key}" />
								</c:if>
								<c:if test="${assetEntry.value[7]}">
									<aui:button title="Remove" cssClass="btn icon-trash"
										onClick="${deleteAssestEntryURL}&spAssetEntryId=${assetEntry.key}" />
								</c:if>
								<c:if test="${assetEntry.value[8]}">
									<aui:button title="Download" cssClass="btn icon-download"
										onClick='callServeResource(event,${assetEntry.key});' />
								</c:if>


							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div id='siteLoader' class="mask" style="display:none;"> 
	        <div id='siteDetailLoader'> 
		        <%=LanguageUtil.get(pageContext,"label.page.load") %><br /> <br /> 
		        <img src="${themeDisplay.pathThemeImages}/common/loading.gif" border='0' alt="Loading"> 
	        </div> 
		</div> 
		<div class="search-loadMore">
			<c:if test="${showLoadmore }">
				<div id="pagination_next" title="Next"
					class="as-stream-loadmore link" style="display: block;"
					onClick="javascript:startSearch('loadMore')"><%=LanguageUtil.get(pageContext,"label.load.more") %></div>
			</c:if>
			<c:if test="${!showLoadmore }">
				<div id="pagination_next" title="Next"
					class="as-stream-loadmore link" style="display: none;"
					onClick="javascript:startSearch('loadMore')"><%=LanguageUtil.get(pageContext,"label.load.more") %></div>
			</c:if>
		</div>
		<input type="hidden" id="paginationValue" value="10">
		<input type="hidden" id="totalDisplayResults" value="10">
	
</div>
<script type="text/javascript">
var downloadUrl = "";
function callServeResource(e,assetEntryId){
	e.preventDefault();
	window.location='<%=downloadAssetEntryUrl%>&spAssetEntryId='+assetEntryId;
}
function galleryMigrate(){
	var A = AUI();
	var reqUrl = '<portlet:resourceURL id="" />';
	var action = "galleryMigrate";
	
	A.io.request(reqUrl, {
		cache : false,
		sync : true,
		timeout : 1000,
		dataType : 'json',
		method : 'post',
		data : {
			type : action,
		},
		sync : true,
		on : {
			start:function(){
        		if(document.getElementById("galleryMigrate")){
       				document.getElementById("siteLoader").disabled = "true";
        		}	
			},	
			success : function() {
				var items = this.get('responseData');
				if(items){
					alert("Migration Successful");
					window.reload();
						}
					}
				}
			});
}


function startSearch(selType){
	var A = AUI();
	var reqUrl = '<portlet:resourceURL id="" />';
	var action = selType;
	
	var ldMoreDiv = document.getElementById("pagination_next");
	var paginationDiv =  document.getElementById("paginationValue");
	var pagination = paginationDiv.value;
	var totalDisplayResults =  document.getElementById("totalDisplayResults").value;

	A.io.request(reqUrl, {
		cache : false,
		sync : true,
		timeout : 1000,
		dataType : 'json',
		method : 'post',
		data : {
			type : action,
			pagination : pagination,
			totalDisplayResults:totalDisplayResults
		},
		sync : true,
		on : {
			start:function(){
        		if(document.getElementById("siteLoader").style.display != "block"){
       				document.getElementById("siteLoader").style.display = "block";
        		}	
			},	
			success : function() {
				var items = this.get('responseData');
				if(items){
					for(key in items){
							var indItem = items[key];
									if(key == "urls"){
										if(indItem != '[]'){
											paginationDiv.value =parseInt(pagination,10)+ parseInt(totalDisplayResults,10);
											for(var i = 0 ; i < items.urls.length; i++){
												populateListFromLoadMore(items.urls[i]);
											}
											document.getElementById("siteLoader").style.display = "none";
										}else{
											ldMoreDiv.style.display = "none";
										}		
								}else if(key == "showLoadmore"){
									if(indItem){
										ldMoreDiv.style.display = "block";
									}else{
										ldMoreDiv.style.display = "none";
									}
								}
							}
						}
					}
				}
			});
}

function populateListFromLoadMore(urls){

	var list = urls;
	var galleryList = document.getElementById("galleryList");
	
	var item1 = document.createElement("div");
	item1.setAttribute("class","thumb_display search-stream-mosaic-block");
	
	var item2 = document.createElement("div");
	item2.setAttribute("class","search-stream-mosaic-content-wrap bg-white img-tn-medium-container");
	
	/** elements for image **/
	var item3 = document.createElement("div");
	item3.setAttribute("class","thumb_pic img-tn-medium bg-transparent");
	var item4 = document.createElement("a");
	item4.setAttribute("href",list[1]);
	item4.setAttribute("target","_self");
	var item5 = document.createElement("img");
	item5.setAttribute("src",list[0]);
	item5.setAttribute("alt",'Image');
	item4.appendChild(item5);
	item3.appendChild(item4);
	item2.appendChild(item3);
	
	/** elements for title, description section **/
	var item6 = document.createElement("div");
	item6.setAttribute("class","search-stream-mosaic-block-content section-bg");
	var item7 = document.createElement("div");
	item7.setAttribute("class","content-title h5");
	var item8 = document.createElement("a");
	item8.setAttribute("href",list[1]);
	item8.setAttribute("target","_self");
	var item9 = document.createTextNode(list[2]);
	item8.appendChild(item9);
	item7.appendChild(item8);
	item6.appendChild(item7);
	if(list[3] != ''){
	var item10 = document.createElement("div");
	item10.setAttribute("class","search-stream-mosaic-block-description p align-center");
	var item11 = document.createTextNode(list[3]);
	item10.appendChild(item11);
	}
	var item12 = document.createElement("div");
	item12.setAttribute("class","search-stream-mosaic-block-author1 copy-caption");
	var item13 = document.createElement("a");
	item13.setAttribute("href",list[4]);
	item13.setAttribute("target","_self");
	var item14 = document.createTextNode(list[5]);
	item13.appendChild(item14);
	item12.appendChild(item13);
	var item16 = document.createTextNode(list[6]);
	item12.appendChild(item16);
	
	/** elements for edit icons **/
	var item17 = document.createElement("div");
	item17.setAttribute("class","edit-overlay-box");
	var item18 = document.createElement("div");
	item18.setAttribute("class","edit_area " + list[8]);
	if(list[9] ==  "true"){
		var item19 = document.createElement("a");
		item19.setAttribute("href","${editAssestEntryURL}&spAssetEntryId=" + list[7]);
		var item20 = document.createElement("button");
		item20.setAttribute("class","btn icon-edit");
		item20.setAttribute("type","button");
		item20.setAttribute("title","Edit");
		item19.appendChild(item20);
		item18.appendChild(item19);
	}
	if(list[10]  ==  "true"){
		var item21 = document.createElement("a");
		item21.setAttribute("href","${deleteAssestEntryURL}&spAssetEntryId=" + list[7]);
		var item22 = document.createElement("button");
		item22.setAttribute("class","btn icon-trash");
		item22.setAttribute("type","button");
		item22.setAttribute("title","Remove");
		item21.appendChild(item22);
		item18.appendChild(item21);
	}
	if(list[11]  ==  "true"){
		var item23 = document.createElement("a");
		var hrefUrl = "javascript:callServeResource(event," + list[7] + ")";
		item23.setAttribute("href",hrefUrl);
		var item24 = document.createElement("button");
		item24.setAttribute("class","btn icon-download");
		item24.setAttribute("type","button");
		item24.setAttribute("title","Download");
		item23.appendChild(item24);
		item18.appendChild(item23);
	}

	item17.appendChild(item18);
	if(list[3] != ''){
	item6.appendChild(item10);
	}
	item6.appendChild(item12);
	item2.appendChild(item6);
	item2.appendChild(item17);
	item1.appendChild(item2);
	
	
	galleryList.appendChild(item1);
}
</script>
