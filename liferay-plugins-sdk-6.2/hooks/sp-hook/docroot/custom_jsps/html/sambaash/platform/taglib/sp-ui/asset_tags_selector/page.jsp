<%@ include file="/html/sambaash/platform/taglib/sp-ui/asset_tags_selector/init.jsp" %>

<%
themeDisplay.setIncludeServiceJs(true);

String className = (String)request.getAttribute("sp-ui:asset-tags-selector:className");
long classPK = GetterUtil.getLong((String)request.getAttribute("sp-ui:asset-tags-selector:classPK"));
String curTags = StringPool.BLANK;

if (Validator.isNotNull(className) && (classPK > 0)) {
	List<AssetTag> tags = AssetTagServiceUtil.getTags(className, classPK);
	curTags = ListUtil.toString(tags, AssetTag.NAME_ACCESSOR);
%>
	<div data-tag-dom-id="tags-selector-container" class="tagselector">
		<div class="tagselector-content textboxlist-content categoriesselector-content">
			<ul data-tag-dom-id="tags-selector-entries-holder" class="helper-clearfix textboxlistentry-holder">
				<%
				for(AssetTag tag : tags) {
					String tagName = tag.getName();
					%>
					<li data-tag-dom-id="tags-selector-entry" class="textboxlistentry">
						<span><%=tagName %></span><span data-tag-dom-id="tags-selector-close-btn" class="icon icon-close textboxlistentry-close"></span>
					</li>
					<%
				}
				%>
				<li class="textboxlist-input-container">
					<input data-tag-dom-id="tags-selector-input" type="text" title="Add Tags" size="15" class="lfr-tag-selector-input field-input-text">
				</li>
			</ul>
			
			<button data-tag-dom-id="tags-selector-add-btn" type="button" class="sp-mls sp-mbs" id="tag-button-icons">
			<span class="buttonitem-icon icon icon-plus"></span>
			<span class="buttonitem-label" id="aui_3_4_0_1_688">Add</span>
			</button>
		</div>
		<input data-tag-dom-id="tags-selector-hidden-input" type="hidden" value="<%=curTags %>" name="<portlet:namespace />assetTagNames" />
	</div>
	
<%
}

%>

<style type="text/css">

	.textboxlistentry-close:hover {
		background-color: #CAD8F3;
	}

</style>

