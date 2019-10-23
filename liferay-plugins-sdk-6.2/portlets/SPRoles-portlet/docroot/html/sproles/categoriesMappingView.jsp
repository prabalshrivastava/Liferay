
<div Style="font-size:18px;font-weight:bold;text-align:center;padding-bottom:20px"> Categories Mapping </div>
<form action="<%= mapActionURL %>" method="post">
		<c:if test="${!empty mainAssetCategory}">
			<div class="category_sel" id="mainCategory_sel" style="display: inline-block; vertical-align: top; width: 45%;">
				<div class="category-title content-title">
					${selectedMainCategoryName}
					<div class="seperatedline"></div>
				</div>
				<ul>
					<select id="mainCategory_sel_list" name="<portlet:namespace />mainCategory_sel_list" onChange="javascript:resetValues('mainCategory_sel_list','subCategory_chk','','populateCatgMap')">
						<option value="0"></option>
						<c:forEach items="${mainAssetCategory}" var="mainAssetCategory">
							<option value="${mainAssetCategory.categoryId}">${mainAssetCategory.name}</option>
						</c:forEach>
					</select>
				</ul>
			</div>
		</c:if>

			<c:if test="${!empty subAssetCategory}">
			<div class="Category_sel" id="subCategory_sel" style="display: inline-block; vertical-align: top; width: 45%;">
				<div class="category-title content-title">
					${selectedSubCategoryName}
					<div class="seperatedline"></div>
				</div>
				<ul>
					<%int g= 0; %>
					<c:forEach items="${subAssetCategory}" var="subAssetCategory">
						<li><input id="subCategory_chk_<%= g %>" name="<portlet:namespace />subCategory_chk" onClick="javascript:getRemovedCategories('subCategory_chk_','removedSubCatg','<%= g %>')" type="checkbox" value="${subAssetCategory.categoryId}"><label for="subCategory_chk_<%= g %>">${subAssetCategory.name}</label></li>
					<% g = g+1; %>
					</c:forEach>
				</ul>
			</div>
			</c:if>
			<div>
				<input id="removedSubCatg" name="<portlet:namespace />removedSubCatg" type="hidden" value="">
				<input id="removedSubCatgNames" name="<portlet:namespace />removedSubCatgNames" type="hidden" value="">
				<input id="removedmainCatgName" name="<portlet:namespace />removedmainCatgName" type="hidden" value="">
				<input id="saveVocabularyButton" type="submit" value="Save">
				<input id="viewListing1" type="button" value="View Listing" Onclick="javascript:toggleView('list')">
				<input id="saveorupdateVoc" name="<portlet:namespace />saveorupdateVoc" type="hidden" value="">
			</div>
		</form>