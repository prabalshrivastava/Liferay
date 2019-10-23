<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.Format"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.sambaash.platform.srv.spchallenge.model.SPChallenge"%>
<%@page import="com.liferay.calendar.model.CalendarBooking"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.sambaash.platform.genericsearch.helper.GenericSearchHelper"%>
<%@page import="java.util.Map"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Collections"%>
<%@page
	import="com.sambaash.platform.genericsearch.model.GenericSearchFilter"%>
<%@page import="java.util.List"%>
<%@page
	import="com.sambaash.platform.genericsearch.GenericSearchConstants"%>
<%@page
	import="com.sambaash.platform.genericsearch.model.GenericSearchConfig"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>

<portlet:defineObjects />
<liferay-theme:defineObjects/>

<style type="text/css">
.gsf-items-search-text-clear {
	cursor: pointer;
    margin-top: 5px;
}
	
.gsf-ss-container{
	height: 70px;
}

</style>

<div class="gsf-title"><%=configObj.getFilterTopLabel()%></div>
<div class="gsf-contentarea">
	<div class="gsf-header-title">
		<div class="inline-block"><liferay-ui:message key="refined-by" /></div>
		<div class="inline-block gsf-clear"><button id="generic-search-clear" class="padding-none"><liferay-ui:message key='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.clear")%>' /></button></div>
	</div>
	<div id="myToggler">
	<%
	Map<String, Object> dataMap = null;
		if (configObj.getEnabledComponentFilters()) { %>
			<div class="gsf-section-title toggler-header-expanded">Components</div>
			<div class="gsf-section"> 
					<%
					int index = 0;
					dataMap = new HashMap<String, Object>();
					dataMap.put(GenericSearchConstants.KEY_COMPONENT, "common");
					dataMap.put(GenericSearchConstants.KEY_TYPE_KEY, Field.ENTRY_CLASS_NAME);
					for (String clazz : GenericSearchHelper.getEnabledComponentClasses(renderRequest)) {
						String name = "gsf-component-filter-" + (++index);
						dataMap.put(GenericSearchConstants.KEY_VALUE, clazz);
							%>
						<div class="gsf-section-item">
						  <aui:input type="checkbox" cssClass="filter-node" 
							name="<%=name %>" label='<%=clazz%>' value="<%=clazz %>" data="<%=dataMap %>"/> 
						</div> 
					<% } %>
			</div>
		<%
		}
		List<GenericSearchFilter> filters = configObj.getFilters();
		if (filters != null) {
		Collections.sort(filters);
		int uc = 0;
		for (GenericSearchFilter filter : filters) {
			if (!filter.isDisplay())
				continue;
			
			out.println("<div class='gsf-section-title toggler-header-expanded'>"+ filter.getLabel() + "</div>");
			out.println("<div class='gsf-section'>");
			out.println("<div class='gsf-section-wrapper'>");
			
			Map<String, String> optionsMap = GenericSearchHelper.getFilterOptionsMap(filter, themeDisplay);
			dataMap = GenericSearchHelper.getFilterDataMap(filter);
			
			if (GenericSearchFilter.SELECT_VOCABULARIES.equals(filter.getDisplayCount()) ||  GenericSearchFilter.SELECT_API.equals(filter.getDisplayCount()) || 
					GenericSearchFilter.TYPE_VOCAB.equals(filter.getType()) || GenericSearchFilter.TYPE_TAG.equals(filter.getType()) 
					|| (GenericSearchFilter.TYPE_FIELD.equals(filter.getType()) && (!GenericSearchFilter.SELECT_AGERANGE.equalsIgnoreCase(filter.getDisplayCount())) && (!GenericSearchFilter.SELECT_RATINGS.equalsIgnoreCase(filter.getDisplayCount()))) && (!GenericSearchFilter.SELECT_DATES.equalsIgnoreCase(filter.getDisplayCount()))) {
						
					if (GenericSearchFilter.SELECT_SINGLE.equalsIgnoreCase(filter.getSelection())) {%>
					<div class="gsf-section-searchable-container">
					    <div class="gsf-ss-container relative hide">
							<aui:input name="section-filter" inlineField="true" inlineLabel="true" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.empty")%>' cssClass="gsf-items-search-text" wrapperCssClass="margin-bottom-quarter label-wrapper width-90"/>
							<div class="gsf-items-search-text-clear inline-block absolute"><img src="/GenericSearch-portlet/images/clear-icon.png" style="width: 12px;" alt="clear"/></div>
					    </div>
						<div class="gsf-section-items">
						<% for (String key : optionsMap.keySet()) {
							dataMap.put("gsf-value", key);
						%>
							<div class="gsf-section-item all-categories hide"><aui:a href="#" cssClass="filter-node" label='<%=optionsMap.get(key)%>' data="<%=dataMap %>"/></div>
							
						
						<%}%>
						</div>
					</div>
				<%	} else if (GenericSearchFilter.SELECT_MULTIPLE.equalsIgnoreCase(filter.getSelection())) { %>
							<div class="gsf-section-searchable-container">
							  <div class="gsf-ss-container relative hide">
								<aui:input name="section-filter" inlineField="true" inlineLabel="true" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.empty")%>' cssClass="gsf-items-search-text" wrapperCssClass="margin-bottom-quarter label-wrapper width-90"/>
								<div class="gsf-items-search-text-clear inline-block absolute"><img src="/GenericSearch-portlet/images/clear-icon.png" style="width: 12px;" alt="clear"/></div>
							   </div>	
								<div class="gsf-section-items">
						<%  for (String key : optionsMap.keySet()) {
							String cbName = filter.getComponent() + "_" + uc++ + "_"+ key;
							dataMap.put("gsf-value", key);
							%>
									<div class="gsf-section-item hide">
										<aui:input type="checkbox" cssClass="filter-node" inlineField="true" inlineLabel="left"
											name="<%=cbName%>" label='<%=optionsMap.get(key)%>' data="<%=dataMap%>"
											value="<%=key%>" />
									</div>
							
						<%}%>
								</div>
							</div>	
			<%		}  
			}
			if (GenericSearchFilter.SELECT_RATINGS.equalsIgnoreCase(filter.getDisplayCount()) || GenericSearchFilter.SELECT_AGERANGE.equalsIgnoreCase(filter.getDisplayCount())) {
					String value = filter.getValues().get(0) + "," + filter.getValues().get(1);
					if (filter.getValues().size() == 3){
						value +=  "," + filter.getValues().get(2); 
					} else if (filter.getValues().size() == 4){
						value +=  "," + filter.getValues().get(2) + "," + filter.getValues().get(3); 
					}
					
					dataMap.put(GenericSearchConstants.KEY_OPER, "bt");
					dataMap.put(GenericSearchConstants.KEY_VALUE, value);
					%>
					<div id="slider" class="margin-top-half margin-bottom-one margin-left-half font-10" style="width: 100%;padding: 0 10px;margin: 20px 0 0 0;">
						<div class="gsf-section-item hide gsf-rating-item" style="padding: 0 0 0 0;">
							<aui:input type="hidden" cssClass="filter-node" inlineField="true" 
								name="rating" data="<%=dataMap %>"/>
						</div>
					</div>
					<%
			}  // SELECT_DATES is hard coded needs improvement !!
			 else if (GenericSearchFilter.SELECT_DATES.equalsIgnoreCase(filter.getDisplayCount()) 
					&& LanguageUtil.get(pageContext, CalendarBooking.class.getName()).equalsIgnoreCase(filter.getComponent())) {		
				
					dataMap.remove(GenericSearchConstants.KEY_OPER);
					dataMap.remove(GenericSearchConstants.KEY_TYPE_KEY);
					Format simpleDateFormat = FastDateFormatFactoryUtil
							.getSimpleDateFormat(GenericSearchHelper.DATE_FORMAT_PATTERN);
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.YEAR, -GenericSearchHelper.DATE_RANGE_HACK_YEARS);
					String past10 = simpleDateFormat.format(cal.getTime()) + "," + filter.getValues().get(0);
					cal = Calendar.getInstance();
					cal.add(Calendar.YEAR, GenericSearchHelper.DATE_RANGE_HACK_YEARS);
					String future10 = filter.getValues().get(0) + "," +simpleDateFormat.format(cal.getTime());
				%>
				<div class="gsf-section-item all-categories">
					<aui:a href="#" cssClass="filter-node" inlineField="true" inlineLabel="left"
								name="dates_all" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"all.events")%>' />
				</div>
				<div class="gsf-section-item all-categories">
					<aui:a href="#" cssClass="filter-node" inlineField="true" inlineLabel="left"
								name="dates_past" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.current.future.events")%>' data="<%=dataMap%>" data-gsf-opr="bt"
								 data-gsf-type-key= "endTime_" data-gsf-value= "<%=future10 %>" />
				</div>
				<div class="gsf-section-item all-categories">
					<aui:a href="#" cssClass="filter-node" inlineField="true" inlineLabel="left"
								name="dates_current" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.current.events")%>' data="<%=dataMap%>" data-gsf-opr="bt"
							 data-gsf-type-key= "endTime_" data-gsf-value= "<%=future10 %>" />
					<div class="hide">
						<aui:a href="#" cssClass="filter-node" inlineField="true" inlineLabel="left"
								name="dates_current" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.current.events")%>' data="<%=dataMap%>" data-gsf-opr="bt"
							 data-gsf-type-key= "startTime_"  data-gsf-value= "<%=past10 %>" />
					</div>
				</div>
				<div class="gsf-section-item all-categories">
					<aui:a href="#" cssClass="filter-node" inlineField="true" inlineLabel="left"
								name="dates_future" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.future.events")%>' data="<%=dataMap%>" data-gsf-opr="bt"
								 data-gsf-type-key= "startTime_" data-gsf-value= "<%=future10 %>"/>
				</div>
				<div class="gsf-section-item all-categories">
					<aui:a href="#" cssClass="filter-node" inlineField="true" inlineLabel="left"
								name="dates_past" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.past.events")%>' data="<%=dataMap%>" data-gsf-opr="bt"
								 data-gsf-type-key= "endTime_" data-gsf-value= "<%=past10 %>"/>
				</div>
				
				<%
			} else if (GenericSearchFilter.SELECT_DATES.equalsIgnoreCase(filter.getDisplayCount()) 
					&& LanguageUtil.get(pageContext, SPChallenge.class.getName()).equalsIgnoreCase(filter.getComponent())) {		
				// this section is hard coded needs improvement
					dataMap.remove(GenericSearchConstants.KEY_OPER);
					dataMap.remove(GenericSearchConstants.KEY_TYPE_KEY);
					Format simpleDateFormat = FastDateFormatFactoryUtil
							.getSimpleDateFormat(GenericSearchHelper.DATE_FORMAT_PATTERN);
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.YEAR, -GenericSearchHelper.DATE_RANGE_HACK_YEARS);
					String past10 = simpleDateFormat.format(cal.getTime()) + "," + filter.getValues().get(0);
					cal = Calendar.getInstance();
					cal.add(Calendar.YEAR, GenericSearchHelper.DATE_RANGE_HACK_YEARS);
					String future10 = filter.getValues().get(0) + "," +simpleDateFormat.format(cal.getTime());
				%>
				<div class="gsf-section-item all-categories">
					<aui:a href="#" cssClass="filter-node" name="dates_past" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.past.challenges")%>' data="<%=dataMap%>" data-gsf-opr="bt"
								 data-gsf-type-key= "endDate" data-gsf-value= "<%=past10 %>"/>
				</div>
				<div class="gsf-section-item all-categories">
					<aui:a href="#" cssClass="filter-node" inlineField="true" inlineLabel="left"
								name="dates_current" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.current.challenges")%>' data="<%=dataMap%>" data-gsf-opr="bt"
							 data-gsf-type-key= "endDate" data-gsf-value= "<%=future10 %>"/>
					<div class="hide">
						<aui:a href="#" cssClass="filter-node" inlineField="true" inlineLabel="left"
								name="dates_current" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.current.challenges")%>' data="<%=dataMap%>" data-gsf-opr="bt"
							 data-gsf-type-key= "startDate" data-gsf-value= "<%=past10 %>"/>
					</div>							 
				</div>
				<div class="gsf-section-item all-categories">
					<aui:a href="#" cssClass="filter-node" inlineField="true" inlineLabel="left"
								name="dates_future" label='<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.future.challenges")%>' data="<%=dataMap%>" data-gsf-opr="bt"
								 data-gsf-type-key= "startDate" data-gsf-value= "<%=future10 %>"/>
				</div>
				<%
			}
			%>
			</div>
			<div class='section-show-more'>
				<a class='seeall hide'><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.see.all")%></a>
				<a class='hideall hide'><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.hide")%></a></div>
			</div>
			<%
		}
		}
	%>
	</div>
</div>

<aui:script
	use="aui-node,aui-base,aui-io-request-deprecated,liferay-util-window,aui-io-plugin-deprecated">
	
	var scList = A.all('.gsf-section-searchable-container');
	if (scList) {
		scList.each(function(sc){
			var tempItems = sc.all('.gsf-section-item');
			if(tempItems.size() > 10 ){
				sc.one(".gsf-ss-container").removeClass("hide");
				sc.one('.gsf-items-search-text').on('keyup', function (ev) {
					showSearchItemsUsingSearchText(this);
				});
				sc.one('.gsf-items-search-text-clear').on('click', function(event) {
					var sc = this.ancestor(".gsf-section-searchable-container");
					sc.one('.gsf-items-search-text').val('');
					showSearchItemsUsingSearchText(sc.one('.gsf-items-search-text'));
				});
				sc.all('.gsf-section-item input[type="checkbox"]').on('click', function (event) {
					var sc = event.target.ancestor(".gsf-section-searchable-container");
					handleOrdering(A,sc);});	
			}
		});
		
	}
	
	function showSearchItemsUsingSearchText(tempNode, seeAll){
		var sectionNode ;
		if(tempNode.hasClass('gsf-section')){
			sectionNode = tempNode;
		}else{
			sectionNode = tempNode.ancestor(".gsf-section");
		}
			
		var orgItems = sectionNode.all('.gsf-section-item');
	/*	orgItems.each(function(item){
			if(!item.hasClass("active-item")){
				item.addClass('hide');
			}
		});*/
		var textNode = sectionNode.one('.gsf-items-search-text');
		var searchKey = textNode.val();
		var wrap = sectionNode.one(".gsf-section-wrapper");
		if (searchKey) {
			searchKey = searchKey.toLowerCase();
			var height = getDefaultSectionWraperHeight(wrap);
			orgItems.each(function(item) {
				var chkbox = item.one("input[type='checkbox']");
				var consider = true; // for single selection it's useful
				if(chkbox){
					if( chkbox.get('checked') == false){
						consider= true;
					}else{
						consider= false; // checked items
					}
				}
				var text = item.one('label') ? item.one('label').text() :item.one('a').text();
				item.removeClass('hide');
				var foundIndex = text.trim().toLowerCase().indexOf(searchKey);
				if ( (foundIndex  < 0  && consider) || (!seeAll  && height > 230)) {
					item.addClass('hide');
				}else if(foundIndex >=0){
						item.removeClass('hide');
						height = height + item.get('offsetHeight') ;
				}
			});
			if(seeAll){
				sectionNode.one('.section-show-more .seeall').addClass('hide');
				sectionNode.one('.section-show-more .hideall').removeClass('hide');
			}else{
				if(height > 230){
					sectionNode.one('.section-show-more .seeall').removeClass('hide');
					sectionNode.one('.section-show-more .hideall').addClass('hide');
				}
			}
		}else{
			showSearchItemsUsingHeight(wrap);
		}
	}
	
	function getDefaultSectionWraperHeight(wrap){
		var height = 0;
		var sc = wrap.one(".gsf-ss-container");
		if(sc){
			 height = sc.get('offsetHeight');
		}
		return height;
	}
	
	function showSearchItemsUsingHeight(wrap){
		if(wrap){
			var items = wrap.all(".gsf-section-item");
			var height = getDefaultSectionWraperHeight(wrap);
			/*var height = 0;
			var sc = wrap.one(".gsf-ss-container");
			if(sc){
				 height = sc.get('offsetHeight');
			}*/
			var showmore = false;
			for(var index = 0 ; index < items.size(); index++){
				var item = items.item(index);
				//If element is hidden, we wont get height.
				item.removeClass("hide");
				height = height + item.get('offsetHeight') ;
				if (height > 230) {
					showmore = true;
					item.addClass("hide");
				} else {
					item.removeClass("hide");
				}	
			}
			if(showmore){
			//	wrap.ancestor('.gsf-section').addClass('show-more-on');
				wrap.ancestor('.gsf-section').one('.section-show-more .seeall').removeClass('hide');				
			}else{
			//	wrap.ancestor('.gsf-section').addClass('show-more-off');
			}
		}
	}
	
	var wraps = A.all('.gsf-section-wrapper');
	wraps.each(function (wrap) {
		showSearchItemsUsingHeight(wrap);
	});
	try {
		A.all('.seeall').on('click', function (event) {
			var sectionNode = A.one(event.currentTarget).ancestor('.gsf-section');
			sectionNode.one('.hideall').removeClass('hide');
			sectionNode.one('.seeall').addClass('hide');
			var textNode = sectionNode.one('.gsf-items-search-text');
			if(textNode && textNode.val().trim() !=''){
				showSearchItemsUsingSearchText(textNode,true);				
			}else{
				sectionNode.all(".gsf-section-item").removeClass("hide");
			}
			//sectionNode.replaceClass('show-more-on', 'show-more-off');
		});
	} catch (e){
	}
	try {
		A.all('.hideall').on('click', function (event) {
			var sectionNode = A.one(event.currentTarget).ancestor('.gsf-section');
			sectionNode.one('.hideall').addClass('hide');
			sectionNode.one('.seeall').removeClass('hide');
			var wrapper = sectionNode.one(".gsf-section-wrapper");
			var textNode = sectionNode.one('.gsf-items-search-text');
			if(textNode && textNode.val().trim() !=''){
				showSearchItemsUsingSearchText(textNode);				
			}else{
				showSearchItemsUsingHeight(wrapper);
				
			}
			//sectionNode.replaceClass('show-more-off', 'show-more-on');
		});
	} catch (e){
	}
	
	YUI().use(
	  'aui-toggler',
	  function(Y) {
	    new Y.TogglerDelegate(
	      {
	        animated: true,
	        closeAllOnExpand: false,
	        container: '#myToggler',
	        content: '.gsf-section',
	        expanded: true,
	        header: '.gsf-section-title',
	        transition: {
	          duration: 0.2,
	          easing: 'cubic-bezier(0, 0.1, 0, 1)'
	        }
	      }
	    );
	  }
	);
</aui:script>
