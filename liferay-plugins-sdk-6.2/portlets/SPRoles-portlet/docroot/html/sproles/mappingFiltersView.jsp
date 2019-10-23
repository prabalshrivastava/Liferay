<div Style="font-size:18px;font-weight:bold;text-align:center;padding-bottom:20px"> Role - Category Mapping </div>
<form action="<%= viewActionURL %>" method="post">
			<div class="content-title">
				Select a Role
				<div class="seperatedline"></div>
			</div>
			<div class="userpersonaldetails-value-full-width">
				<div
					class="userpersonaldetails-value-Leftfull-width basicinfo-textedit"
					id="current_role">
					<c:if test="${roleSaved != null}">
						<select class="" id="current_role_list" name="<portlet:namespace />current_role_Id" onChange="javascript:resetValues()">
							<option label="" value="0"></option>
							<c:forEach items="${roleList}" var="roleList">
								<c:choose>
									<c:when test="${roleList.roleId == roleSaved}">
										<option selected="true" value="${roleList.roleId}">${roleList.name}</option>
									</c:when>
									<c:otherwise>
										<option value="${roleList.roleId}">${roleList.name}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</c:if>
					<c:if test="${roleSaved == null}">
						<select class="" id="current_role_list" name="<portlet:namespace />current_role_Id" onChange="javascript:resetValues('current_role_list','categories1','categories2','populateRoleCatg')">
							<option label="" value="0"></option>
							<c:forEach items="${roleList}" var="roleList">
								<option value="${roleList.roleId}">${roleList.name}</option>
							</c:forEach>
						</select>
					</c:if>
				</div>
				<div id="jobrole_error_icon" class="msg_tooltip"
					tooltip="Please select a Role" style="cursor: pointer;"></div>
			</div>

			<div class="category_sel" id="category_sel"
				style="display: inline-block; vertical-align: top; width: 45%;">
				<div class="category-title content-title">
					${selectedCategoryName}
					<input id="selectedCategoryId1" name="<portlet:namespace />selectedCategoryId1" type="hidden" value="${selectedCategory}">
					<div class="seperatedline"></div>
				</div>
				<ul>
					<%-- <%int f= 0; %>
					<c:forEach items="${assetCategory}" var="assetCategory">
						<li><input id="categories1_<%= f %>" name="<portlet:namespace />categories1" onClick="javascript:getRemovedCategories('categories1_','removedCatg1','<%= f %>')" type="checkbox" value="${assetCategory.categoryId}">${assetCategory.name}</li>
					<% f = f+1; %>
					</c:forEach> --%>
					<c:forEach items="${allChannelWrappers}" var="allChannelWrapper">
											<%-- <optgroup label="${allChannelWrapper.vocabularyName}"> --%>
												<c:forEach items="${allChannelWrapper.channelWrappers}"
													var="channelWrapper">

													<c:if test="${channelWrapper.child}">
														<li class="categoryList_${channelWrapper.parentCategoryId}" style="display:none">---
															<input id="categories1_${channelWrapper.categoryId}" mainCategory="${channelWrapper.parentCategoryId}" name="<portlet:namespace />categories1" onChange="javascript:getRemovedCategories('categories1_','removedCatg1',${channelWrapper.categoryId})" type="checkbox" value="${channelWrapper.categoryId}">
															${channelWrapper.categoryName}
														</li>
													</c:if>
													<c:if test="${!channelWrapper.child}">
														<li>
															<input id="categories1_${channelWrapper.categoryId}" name="<portlet:namespace />categories1" onClick="javascript:selectAllSubCategories(this,${channelWrapper.categoryId})" type="checkbox" value="${channelWrapper.categoryId}">
															${channelWrapper.categoryName}
															<a href="#" onClick="javascript:showSubCategories(${channelWrapper.categoryId})"> + </a>
														</li>
													</c:if>
												</c:forEach>
										</c:forEach>
				</ul>
			</div>

			<c:if test="${!empty assetCategory1}">
			<div class="category_sel" id="category_sel"
				style="display: inline-block; vertical-align: top; width: 45%;">
				<div class="category-title content-title">
					${selectedCategoryMappedToName}
					<div class="seperatedline"></div>
				</div>
				<ul>
					<%int g= 0; %>
					<c:forEach items="${assetCategory1}" var="assetCategory1">
						<li><input id="categories2_<%= g %>" name="<portlet:namespace />categories2" onClick="javascript:getRemovedCategories2('<%= g %>')" type="checkbox" value="${assetCategory1.categoryId}">${assetCategory1.name}</li>
					<% g = g+1; %>
					</c:forEach>
				</ul>
			</div>
			</c:if>
			<input id="removedCatg1" name="<portlet:namespace />removedCatg1" type="hidden" value="">
			<input id="removedCatg2" name="<portlet:namespace />removedCatg2" type="hidden" value="">
			<div>
				<!-- <input type="button" value="Save" onClick="javascript:saveRoleInfo()"> -->
				<input id="saveButton" type="submit" value="Save">
				<!-- <input type="button" value="Back" id="backButton" style="display:none" Onclick="location.reload();"> -->
				<input id="viewListing" type="button" value="View Listing" Onclick="javascript:toggleView('list')">
				<input id="saveorupdate" name="<portlet:namespace />saveorupdate" type="hidden" value="">
			</div>
		</form>