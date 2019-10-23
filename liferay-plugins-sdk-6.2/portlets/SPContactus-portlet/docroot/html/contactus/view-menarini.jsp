
<div id="EnquiryForm-div" class="EnquiryForm-div" style="display: block;">
<div style="margin:20px"><div class="aboutSub_title_text"> <liferay-ui:message key="label.form.name" /></div></div>
	<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>">
		          <portlet:param name="struts_action" value="/contact_us/view" />
     	 	  </portlet:actionURL>" class="EnquiryForm uni-form" method="post" name="<portlet:namespace />fm">
		<p class="form-label">
			<liferay-ui:message key="label.country" />: 
		</p>
			
		<p class="country-List-span">
			<aui:select class="country-List-select" name="country-List" id="country-List" label="">
					    <%
					    for(AssetCategory item : lstLocation){   
					    	
					    %>
					    
					    <aui:option selected="<%= true %>" value="<%=item.getName()%>"><%=item.getDescription(themeDisplay.getLocale())%></aui:option>         
					    <%}%>
					</aui:select>	
		</p>
		<p class="form-label">
			<liferay-ui:message key="label.send.message" />: 
		</p>	
			<p class="mail-recipient-span">
				<aui:select class="mail-recipient-select" name="categorys" id="mail-recipient-category" label="">
					    <%
					    for(int j=0;j<lstCategories.size();j++){  
					    	AssetCategory items = lstCategories.get(j);
					    	
					    	if(category.equals(items.getName())){
					    %>
					    <aui:option selected="true" value="<%=items.getName()%>"><%=items.getDescription(themeDisplay.getLocale())%></aui:option>         
					    <%}else{
			
					    %>
					    <aui:option value="<%=items.getName()%>"><%=items.getDescription(themeDisplay.getLocale())%></aui:option> 
					    <%
					    	
					    }}%>
					    
					</aui:select>
			</p>
		<p class="sender-details">
			<span class="sender-address-span">
				<input type="email" placeholder="<%= LanguageUtil.get(pageContext,"label.sender.mail")%>" class="sender-address" size="40" value="" name="<portlet:namespace />sender-address">
			</span>
		</p>
		<p class="sender-details">
			<span class="sender-name-span">
				<input type="text" placeholder="<%= LanguageUtil.get(pageContext,"label.sender.name")%>" class="sender-name" size="40" value="" name="<portlet:namespace />sender-name">
			</span>
		</p>
		<p class="sender-details">
			<span class="mail-message">
				<textarea placeholder="<%= LanguageUtil.get(pageContext,"label.sender.message")%>" class="mail-message" rows="10" cols="40" name="<portlet:namespace />mail-message"></textarea>
			</span>
		</p>
		<p style="text-align: center">
			<!-- <input type="reset"> -->
			
			<input type="submit" class="submit-form" value="<%= LanguageUtil.get(pageContext,"label.send")%>">
			<input type="button" class="reset-form" value="<%= LanguageUtil.get(pageContext,"label.reset")%>" onClick="window.location.reload();">
			<img class="ajax-loader" src="http://www.menariniapac.com/wp-content/plugins/contact-form-7/images/ajax-loader.gif" alt="Sending ..." style="visibility: hidden;">
		</p>
	</form>
</div>