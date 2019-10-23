<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<section class="sp-feeds update-interest">
	<div class="sp-feeds-wrap max-width padding-left-75 padding-right-75 padding-top-one padding-bottom-one full-height">
		<portlet:actionURL var="updateInterestsURL">
			<portlet:param name="action" value="updateInterests"></portlet:param>
		</portlet:actionURL>
		<div class="table align-middle full-height full-width text-center">
		
			<div class="table-cell align-middle full-height full-width text-center">
				<div class="sp-feeds-head block text-center padding-bottom-half">
					<h2>My Interests</h2>
					<span>Tell us some of your interests and we'll give you a couple of suggestions.</span>
				</div>
				<div class="sp-feeds-content block text-center">
					<aui:form action="<%= updateInterestsURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>
						<aui:input name="skip" type="hidden" value="false" />
						<div class="alert alert-error hide-content" id="errorDiv"> Please select at least one interest. </div>
						<ul class="interests-setting block padding" id="interestList">
							<c:forEach items="${assetCategories}" var="category"><c:set var="on" value="false" />
								<c:forEach items="${selectedInterests}" var="myInterestedCategoryId">
									<c:if test="${myInterestedCategoryId == category.categoryId}">
										<c:set var="on" value="true" />
									</c:if>
								</c:forEach>
								<li class="inline-block btn-filter <c:if test="${on}">on</c:if>" >
									<label class="label" for="interest_${category.categoryId}">
									<input type="checkbox" id="interest_${category.categoryId}" <c:if test="${on}">checked='checked'</c:if> value="${category.categoryId}" name="interests" onclick="interestOnClick(this)" />
									${category.name}
									</label>
								</li>
							</c:forEach>
						</ul>
						<div class="sp-feeds-cta text-center">
							<aui:button-row>
								<aui:button name="saveButton" cssClass="btn-primary" onClick='<%= renderResponse.getNamespace() + "saveChanges();" %>' type="submit" value="Save changes" />
								<aui:button name="skipButton" cssClass="btn-primary" onClick='<%= renderResponse.getNamespace() + "continueToCommunity();" %>' type="submit" value="Not now, continue to Community" />
							</aui:button-row>
						</div>
					</aui:form>
				</div>
			</div>
		
		</div>
	</div>
</section>

<script type="text/javascript">

	function interestOnClick(input) {
		toggleClass(input.parentNode.parentNode, "on");
	}

</script>

<aui:script>

	Liferay.provide(
		window,
		'<portlet:namespace />saveChanges',
		function() {
			var A = AUI();
			var catList = A.one("#interestList").all("input[type='checkbox']");
			var valid = false;
			catList.each(function(temp){
				if(temp.get('checked')){
					valid = true;
				}
			});
			if(valid){
				submitForm(document.<portlet:namespace />fm);
			}else{
				var errDiv = A.one("#errorDiv");
				errDiv.removeClass("hide-content");
				errDiv.addClass("show-content");
			}
		}
	);

	Liferay.provide(
		window,
		'<portlet:namespace />continueToCommunity',
		function() {
			var A = AUI();
			var skip = A.one("#<portlet:namespace />skip");
			skip.set('value', true);
			submitForm(document.<portlet:namespace />fm);
		}
	);

</aui:script>