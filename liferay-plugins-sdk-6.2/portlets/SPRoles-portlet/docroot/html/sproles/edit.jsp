<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="CategoriesMappingURL">
	<portlet:param name="action" value="CategoriesMapping"></portlet:param>
</portlet:actionURL>

<portlet:actionURL var="editActionURL">
	<portlet:param name="action" value="<%= Constants.EDIT %>"></portlet:param>
</portlet:actionURL>

<div id="RoleMapping_contents">

	<div class="maindiv" style="margin-bottom:20px">
		<div class="content-title">
			Select Categories to be Mapped
			<div class="seperatedline"></div>
		</div>
		<form method="post" name="categoriesMappingForm"  onSubmit="return ValidateForm('<%= CategoriesMappingURL %>');">

			<div class="maindivpersonalInfo">

				<div class="content-title">
					Select a Category
					<div class="seperatedline"></div>
				</div>
				<div class="userpersonaldetails-value-full-width">
					<div class="userpersonaldetails-value-Leftfull-width basicinfo-textedit" id="CategoriesMapping_main">
						<c:if test="${selectedMainCategory != null}">
							<select class="" id="CategoriesMapping_mainlist" name="<portlet:namespace />CategoriesMapping_mainlist" onChange="javascript:CategoryChanged();">
								<option label="" value="0"></option>
								<c:forEach items="${assetVocabularies}" var="assetVocabularies">
									<c:choose>
										<c:when test="${selectedMainCategory == assetVocabularies.vocabularyId}">
											<option value="${assetVocabularies.vocabularyId}"
												selected="true">${assetVocabularies.name}
											<option>
										</c:when>
										<c:otherwise>
											<option value="${assetVocabularies.vocabularyId}">${assetVocabularies.name} </option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</c:if>
						<c:if test="${selectedMainCategory == null}">
							<select class="" id="CategoriesMapping_mainlist" name="<portlet:namespace />CategoriesMapping_mainlist" onChange="javascript:CategoryChanged();">
								<option label="" value="0"></option>
								<c:forEach items="${assetVocabularies}" var="assetVocabularies">
									<option value="${assetVocabularies.vocabularyId}">${assetVocabularies.name}</option>
								</c:forEach>
							</select>
						</c:if>
					</div>
				</div>

			</div>

			<div class="maindivpersonalInfo">

				<div class="content-title">
					Select a Sub-Category
					<div class="seperatedline"></div>
				</div>
				<div class="userpersonaldetails-value-full-width">
					<div class="userpersonaldetails-value-Leftfull-width basicinfo-textedit" id="CategoriesMapping_sub">
						<c:if test="${selectedSubCategory != null}">
							<select class="" id="CategoriesMapping_sublist" name="<portlet:namespace />CategoriesMapping_sublist" value="">
								<option label="" value="0"></option>
								<c:forEach items="${assetVocabularies}" var="assetVocabularies">
									<c:choose>
										<c:when
											test="${selectedSubCategory == assetVocabularies.vocabularyId}">
											<option value="${assetVocabularies.vocabularyId}"
												selected="true">${assetVocabularies.name}</option>
										</c:when>
										<c:otherwise>
											<option value="${assetVocabularies.vocabularyId}">${assetVocabularies.name}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</c:if>
						<c:if test="${selectedSubCategory == null}">
							<select class="" id="CategoriesMapping_sublist" name="<portlet:namespace />CategoriesMapping_sublist" value="">
								<option label="" value="0"></option>
								<c:forEach items="${assetVocabularies}" var="assetVocabularies">
									<option value="${assetVocabularies.vocabularyId}">${assetVocabularies.name}</option>
								</c:forEach>
							</select>
						</c:if>
					</div>
				</div>

			</div>
			<input type="submit" value="Save Categories Mapping" />
		</form>
	</div>

	<div class="maindiv">
		<div class="category-title content-title">
			Select Categories to be Mapped with Role
			<div class="seperatedline"></div>
		</div>
		<form action="<%= editActionURL %>" method="post">

			<div class="maindivpersonalInfo">

				<div class="content-title">
					Select a Category
					<div class="seperatedline"></div>
				</div>
				<div class="userpersonaldetails-value-full-width">
					<div
						class="userpersonaldetails-value-Leftfull-width basicinfo-textedit"
						id="current_category">
						<c:if test="${selectedCategory != null}">
							<select name="<portlet:namespace />current_category_Id" class=""
								id="current_category_list" label="">
								<option label="" value="0"></option>
								<c:forEach items="${assetVocabularies}" var="assetVocabularies">
									<c:choose>
										<c:when
											test="${selectedCategory == assetVocabularies.vocabularyId}">
											<option value="${assetVocabularies.vocabularyId}"
												selected="true">${assetVocabularies.name}
											<option>
										</c:when>
										<c:otherwise>
											<option value="${assetVocabularies.vocabularyId}">${assetVocabularies.name}

											<option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</c:if>
						<c:if test="${selectedCategory == null}">
							<select name="<portlet:namespace />current_category_Id"
								fieldName="current_category_Id" value="" class=""
								id="current_category_list" label="">
								<option label="" value="0"></option>
								<c:forEach items="${assetVocabularies}" var="assetVocabularies">
									<option value="${assetVocabularies.vocabularyId}">${assetVocabularies.name}</option>
								</c:forEach>
							</select>
						</c:if>
					</div>
				</div>

			</div>

			<div class="maindivpersonalInfo">

				<div class="content-title">
					Select a Sub-Category
					<div class="seperatedline"></div>
				</div>
				<div class="userpersonaldetails-value-full-width">
					<div
						class="userpersonaldetails-value-Leftfull-width basicinfo-textedit"
						id="current_category1">
						<c:if test="${selectedCategoryMappedTo != null}">
							<select name="<portlet:namespace />current_category1_Id" value="" class=""
								id="ccurrent_category1_list">
								<option label="" value="0"></option>
								<c:forEach items="${assetVocabularies}" var="assetVocabularies">
									<c:choose>
										<c:when
											test="${selectedCategoryMappedTo == assetVocabularies.vocabularyId}">
											<option value="${assetVocabularies.vocabularyId}"
												selected="true">${assetVocabularies.name}</option>
										</c:when>
										<c:otherwise>
											<option value="${assetVocabularies.vocabularyId}">${assetVocabularies.name}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</c:if>
						<c:if test="${selectedCategoryMappedTo == null}">
							<select name="<portlet:namespace />current_category1_Id" value="" class=""
								id="current_category1_list">
								<option label="" value="0"></option>
								<c:forEach items="${assetVocabularies}" var="assetVocabularies">
									<option value="${assetVocabularies.vocabularyId}">${assetVocabularies.name}</option>
								</c:forEach>
							</select>
						</c:if>
					</div>
				</div>

			</div>
			<input type="submit" value="Save Role Categories Mapping" />
		</form>
	</div>

</div>

<script type="text/javascript">

function CategoryChanged() {
	mainCatgChanged = true;
}

function ValidateForm(actionUrl) {
	document.categoriesMappingForm.action=actionUrl;
	if (mainCatgChanged) {
		if (confirm("Changing Main Category will delete all the existing Data. Do you want to proceed?"))
			return true;
		else
	    	return false;
	}else {
		return false;
	}
}

</script>