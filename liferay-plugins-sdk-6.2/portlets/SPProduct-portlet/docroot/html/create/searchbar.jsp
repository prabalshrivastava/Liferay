
<!--search Section-->
<div class="search_section">
	
	
 <div class="search_secWrapbar">
	<div class="Calander_bar">
		<span id="startDateContainer">
			<div class="calander-section">
				<i class="Calander_icon"></i> <input class="calendarDate"
					type="text" name="startDate" id="startDate"
					placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.startDate")%>">
			</div>
		</span>
		<div class="separate-horizontal"></div>
		<span id="endDateContainer">
			<div class="calander-section">
				<i class="Calander_icon"></i> <input class="calendarDate"
					type="text" name="endDate" id="endDate" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.endDate")%>">
			</div>
		</span>
	</div>
</div>
 <div class="search_secWrapbar">
 	<div class="search_bar">
		<i class="Search_icon" id="textSearchButton"></i> <input
			id="searchText" name="searchName" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.search")%>" type="text"
			value="">
	</div>
	<div class="Search_Result_Count">
	<p id="resultCount"></p>
	</div>
</div>
</div>
<!--search Section-->
