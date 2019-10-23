<%@ include file="/html/sambaash/platform/taglib/sp-ui/asset_categories_selector/init.jsp" %>

<%
themeDisplay.setIncludeServiceJs(true);

String className = (String)request.getAttribute("sp-ui:asset-categories-selector:className");
long classPK = GetterUtil.getLong((String)request.getAttribute("sp-ui:asset-categories-selector:classPK"));

if (Validator.isNotNull(className) && (classPK > 0)) {
	long classNameId = PortalUtil.getClassNameId(className);

	List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();

	Group group = themeDisplay.getScopeGroup();

	if (group.isLayout()) {
		vocabularies.addAll(AssetVocabularyLocalServiceUtil.getGroupVocabularies(group.getParentGroupId(), false));
	}
	else {
		vocabularies.addAll(AssetVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId, false));
	}

	if (scopeGroupId != themeDisplay.getCompanyGroupId()) {
		vocabularies.addAll(AssetVocabularyLocalServiceUtil.getGroupVocabularies(themeDisplay.getCompanyGroupId(), false));
	}

	// filter vocabularies
	vocabularies = _filterVocabularies(vocabularies, themeDisplay);
	
	if(vocabularies != null && vocabularies.size() > 0) {
		// assume there is only one vocabulary left
		AssetVocabulary vocabulary = vocabularies.get(0);
		vocabulary = vocabulary.toEscapedModel();

		List<AssetCategory> categories = AssetCategoryLocalServiceUtil.getCategories(className, classPK);

		String curCategoryIds = ListUtil.toString(categories, AssetCategory.CATEGORY_ID_ACCESSOR);
		String curCategoryNames = ListUtil.toString(categories, AssetCategory.NAME_ACCESSOR);

		String[] categoryIdsTitles = _getCategoryIdsTitles(curCategoryIds, curCategoryNames, vocabulary.getVocabularyId(), themeDisplay);

		String[] curCategoryIdsArray = curCategoryIds.split(StringPool.COMMA);
		String[] curCategoryNamesArray = curCategoryNames.split(StringPool.COMMA);
		
		List<AssetCategory> vocabularyCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabulary.getVocabularyId(), -1, -1, null);
		
		%>
		<div data-category-dom-id="categories-selector-container" class="tagselector">
			<div class="tagselector-content textboxlist-content">
				<ul data-category-dom-id="categories-selector-entries-holder" class="helper-clearfix textboxlistentry-holder">
					<%
					for(int i=0; i<curCategoryIdsArray.length; i++) {
						if(Validator.isNotNull(curCategoryIdsArray[i]) && Validator.isNotNull(curCategoryNamesArray[i])) {
						%>
						<li data-category-dom-id="categories-selector-entry" data-category-id="<%=curCategoryIdsArray[i] %>" class="textboxlistentry">
							<span><%=curCategoryNamesArray[i] %></span><span data-category-dom-id="categories-selector-close-btn" class="icon icon-close textboxlistentry-close"></span>
						</li>
						<%
						}
					}
					%>
				</ul>
				<input data-category-dom-id="categories-selector-select-btn" type="button" value="Select"/>
				<div data-category-dom-id="categories-selector-popup" class="yui3-widget component panel dialog yui3-widget-positioned yui3-widget-stacked lfr-tag-selector-popup yui3-dd-draggable resize hide" style="position: absolute; width: 320px; z-index: 2001;">
					<div class="panel-content dialog-content yui3-widget-stdmod">
						<div class="yui3-widget-hd helper-clearfix panel-hd">
							<span class="panel-hd-text">Categories</span>
							<span class="yui3-widget component toolbar toolbar-horizontal panel-icons">
								<span class="toolbar-content">
									<button type="button" data-category-dom-id="categories-selector-popup-close-btn" class="buttonitem-content yui3-widget component buttonitem state-default buttonitem-icon-only toolbar-first toolbar-last toolbar-item" title="Close dialog">
										<span class="buttonitem-icon icon icon-closethick"></span>
										<span class="buttonitem-label hide"></span>
									</button>
								</span>
							</span>
						</div>
						<div class="yui3-widget-bd panel-bd dialog-bd">
							<div class="lfr-tags-selector-list lfr-categories-selector-list">
								<ul data-category-dom-id="categories-selector-popup-tree-container" class="tree-container">
								<%
									for(AssetCategory vocabularyCategory : vocabularyCategories) {
										long vocabularyCategoryId = vocabularyCategory.getCategoryId();
										String vocabularyCategoryName = vocabularyCategory.getName();
										%>
										<li class="yui3-widget component tree-data tree-node tree-node-io tree-node-check">
											<div class="helper-clearfix tree-node-content tree-data-content tree-node-content tree-node-io-content tree-node-check-content tree-node-leaf">
												<div data-category-dom-id="categories-selector-popup-tree-node-checkbox" data-category-id="<%=vocabularyCategoryId %>" class="tree-node-checkbox-container"></div>
												<div class="tree-label helper-unselectable" style="-moz-user-select: none;"><%=vocabularyCategoryName %></div>
											</div>
										</li>
										<%
									}
								 %>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<input data-category-dom-id="categories-selector-hidden-input" type="hidden" value="<%=curCategoryIds %>" name="<portlet:namespace />assetCategoryIds" />
		</div>
		<%
	}
}
%>

<%!
private long[] _filterCategoryIds(long vocabularyId, long[] categoryIds) throws PortalException, SystemException {
	List<Long> filteredCategoryIds = new ArrayList<Long>();

	for (long categoryId : categoryIds) {
		AssetCategory category = AssetCategoryLocalServiceUtil.getCategory(categoryId);

		if (category.getVocabularyId() == vocabularyId) {
			filteredCategoryIds.add(category.getCategoryId());
		}
	}

	return ArrayUtil.toArray(filteredCategoryIds.toArray(new Long[filteredCategoryIds.size()]));
}

private String[] _getCategoryIdsTitles(String categoryIds, String categoryNames, long vocabularyId, ThemeDisplay themeDisplay) throws PortalException, SystemException {
	if (Validator.isNotNull(categoryIds)) {
		long[] categoryIdsArray = GetterUtil.getLongValues(StringUtil.split(categoryIds));

		if (vocabularyId > 0) {
			categoryIdsArray = _filterCategoryIds(vocabularyId, categoryIdsArray);
		}

		if (categoryIdsArray.length == 0) {
			categoryIds = StringPool.BLANK;
			categoryNames = StringPool.BLANK;
		}
		else {
			StringBundler sb = new StringBundler(categoryIdsArray.length * 2);

			for (long categoryId : categoryIdsArray) {
				AssetCategory category = AssetCategoryLocalServiceUtil.getCategory(categoryId);

				category = category.toEscapedModel();

				sb.append(category.getTitle(themeDisplay.getLocale()));
				sb.append(_CATEGORY_SEPARATOR);
			}

			sb.setIndex(sb.index() - 1);

			categoryIds = StringUtil.merge(categoryIdsArray);
			categoryNames = sb.toString();
		}
	}

	return new String[] {categoryIds, categoryNames};
}

private List<AssetVocabulary> _filterVocabularies(List<AssetVocabulary> vocabularies, ThemeDisplay themeDisplay) throws PortalException, SystemException {
	vocabularies = ListUtil.copy(vocabularies);
	Iterator<AssetVocabulary> itr = vocabularies.iterator();

	while (itr.hasNext()) {
		AssetVocabulary vocabulary = itr.next();
		String primaryKey = String.valueOf(vocabulary.getVocabularyId());
		List<Role> roles = RoleLocalServiceUtil.getUserRoles(themeDisplay.getUserId());
		boolean hasPermission = false;
		for (Role role : roles) {
			long roleId = role.getRoleId();
			if (ResourcePermissionLocalServiceUtil.hasResourcePermission(themeDisplay.getCompanyId(), AssetVocabulary.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, primaryKey, roleId, ActionKeys.VIEW)) {
				hasPermission = true;
				break;
			}
		}
		if (!hasPermission) {
			itr.remove();
		}
	}
	return vocabularies;
}

private static final String _CATEGORY_SEPARATOR = "_CATEGORY_";
private static final String _CHARACTER_QUOTE = "&quot;";
%>