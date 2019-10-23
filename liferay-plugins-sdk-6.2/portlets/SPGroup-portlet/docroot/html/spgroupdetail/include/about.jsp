<%
				String grpsDesc = spGroup.getDescription();
				grpsDesc = grpsDesc.replaceAll("[\r\n]", "<br>");
				%>
<p class="sp-group-mbm" style="margin:20px 12px"><%= grpsDesc %></p>
<p>
	<span class="sp-group-date"><%= dateFormatDateTime.format(spGroup.getCreateDate()) %></span>
	<span class="sp-group-author">By <a href="/<%= spGroupDetailWrapper.getScreenName() %>"><%= spGroupDetailWrapper.getUsername() %></a></span>
	
</p>
<p  style="margin:20px 12px">
	<span class="sp-group-fcl sp-group-fwb"><liferay-ui:message key="label.tag" />:&nbsp;</span>
	<liferay-ui:asset-tags-summary
		className="<%= SPGroup.class.getName() %>"
		classPK="<%= spGroup.getSpGroupId() %>"
	/>
</p>
<p  style="margin:20px 12px">	
	<span class="sp-group-fcl sp-group-fwb"><liferay-ui:message key="label.category" />:&nbsp;</span>
	<liferay-ui:asset-categories-summary
		className="<%= SPGroup.class.getName() %>"
		classPK="<%= spGroup.getSpGroupId() %>"
	/>
</p>