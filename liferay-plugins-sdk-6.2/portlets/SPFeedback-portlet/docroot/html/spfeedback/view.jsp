<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<portlet:defineObjects />
<c:if test="${not isPreferencesSet}">
    <span><%= LanguageUtil.get(pageContext,"msg.preferences.not.set")%></span>
 </c:if>
<c:if test="${isPreferencesSet}">
	<div class="fdBack-form">
		<input class="aui-field-input aui-field-input-text" id="feedback-sentby" name="feedback-sentby" type="hidden" value="">
		<div class="taglib-header ">
		<h1 class="header-title">
			<span> <%= LanguageUtil.get(pageContext,"feedback")%> </span>
		</h1>
		</div>
			<div id="fdBack-success-msg"></div> 
			<div class="aui-fieldset-content ">
				<span class="aui-field aui-field-select aui-field-menu" id="aui_3_4_0_1_294"> 
					<span class="aui-field-content"> 
						<label class="aui-field-label" for="fdBack-type-voc"> <%= LanguageUtil.get(pageContext,"select")%> </label> 
							<span class="aui-field-element"> 
								<select name="fdBack-type-voc" id="fdBack-type-voc">
									<c:forEach var="assetCategories" items="${assetCategories}">
										<c:if test="${assetCategories != null}">
											<option value="${assetCategories.name}">${assetCategories.name}</option>
										</c:if>	
									</c:forEach>
								</select> 
							</span>
						</span>
					</span>
				<div class="aui-field-wrapper-content lfr-forms-field-wrapper">
					<span class="aui-field aui-field-text aui-w50 aui-w50"> 
						<span class="aui-field-content"> 
							<label class="aui-field-label" for="fbBack-details"> <%= LanguageUtil.get(pageContext,"feedback.details")%> *</label>
							<div class="aui-form-validator-message" id="fdBack-form-validator" style="display:none"><%= LanguageUtil.get(pageContext,"feedback.required.msg")%></div>
							<span class="aui-field-element "> 
								<textarea class="aui-field-input aui-field-input-text" id="fbBack-details" name="fbBack-details"></textarea>
							</span>
						</span>
					</span>
				</div>
				<div class="aui-button-holder ">
					<span class="aui-button aui-button-submit"> <span
						class="aui-button-content"> 
						<input class="aui-button-input aui-button-input-submit" id="fdBack-submit-button" onclick="submitFeedbakForm();" type="button" value="<%= LanguageUtil.get(pageContext,"feedback.send.mail")%>">
					</span>
					</span> <span class="aui-button aui-button-cancel"> <span
						class="aui-button-content"> <input
							class="aui-button-input aui-button-input-cancel"
							id="fdBack-cancel-button" type="button"
							value="<%= LanguageUtil.get(pageContext,"feedback.cancel")%>" onClick="window.location.reload();">
					</span>
					</span>
				</div>
			</div>
			</div>
		</c:if>	
<script>

function submitFeedbakForm(){
	var A = AUI();
	var reqUrl = '<portlet:resourceURL id="" />';
	var action = "submit";
	var e = document.getElementById("fdBack-type-voc");
	var feedBackType = e.options[e.selectedIndex].value;
	var feedBackDetail = document.getElementById("fbBack-details").value;
	var feedBacktext = document.getElementById("fdBack-form-validator");
	if(feedBackDetail != ''){
		feedBacktext.style.display = "none";
	A.io.request(reqUrl, {
		cache : false,
		sync : true,
		timeout : 1000,
		dataType : 'json',
		method : 'post',
		data : {
			action : action,
			feedBackType : feedBackType,
			feedBackDetail : feedBackDetail
		},
		sync : true,
		on : {
			success : function() {
				items = this.get('responseData');
				if(items){
					var e = document.getElementById("fdBack-type-voc");
					e.selectedIndex = 0;
					document.getElementById("fbBack-details").value = "";
					var successMsgDiv = document.getElementById("fdBack-success-msg");
					successMsgDiv.setAttribute("class","portlet-msg-success");
					successMsgDiv.innerHTML = items;
				}
			}
		}
	});
	}else{
		feedBacktext.style.display = "block";
	}
}

</script>			
