<ul class="sp-group-horizontal"><c:forEach items="${spGroupOwnerWrappers}" var="spGroupOwnerWrapper"><li class="sp-group-member">
	<div class="sp-group-clearfix">
		<a class="sp-group-lfloat sp-group-mrm" href="/${spGroupOwnerWrapper.screenName}">
			<img alt="${spGroupOwnerWrapper.screenName}" src="${spGroupOwnerWrapper.pic}" style="width: 50px; height: 50px;" />
		</a>
		<div class="sp-group-ui-oh">
			<div class="sp-group-ui-dib">
				<div class="sp-group-ui-dib sp-group-ui-vam" style="height:50px;"></div><div class="sp-group-ui-dib sp-group-ui-vam">
					<p><a href="/${spGroupOwnerWrapper.screenName}">${spGroupOwnerWrapper.userName}</a></p>
					<span class="sp-group-fcl sp-group-mts sp-group-fss sp-group-fwb"><liferay-ui:message key="label.owner" /></span>
				</div>
			</div>
		</div>
	</div>
</li></c:forEach></ul>

<ul class="sp-group-horizontal"><c:forEach items="${spGroupAdminWrappers}" var="spGroupAdminWrapper"><li class="sp-group-member">
	<div class="sp-group-clearfix">
		<a class="sp-group-lfloat sp-group-mrm" href="/${spGroupAdminWrapper.screenName}">
			<img alt="${spGroupAdminWrapper.screenName}" src="${spGroupAdminWrapper.pic}" style="width: 50px; height: 50px;" />
		</a>
		<div class="sp-group-ui-oh">
			<div class="sp-group-ui-dib">
				<div class="sp-group-ui-dib sp-group-ui-vam" style="height:50px;"></div><div class="sp-group-ui-dib sp-group-ui-vam">
					<p><a href="/${spGroupAdminWrapper.screenName}">${spGroupAdminWrapper.userName}</a></p>
					<span class="sp-group-fcl sp-group-mts sp-group-fss sp-group-fwb"><liferay-ui:message key="label.admin" /></span>
				</div>
			</div>
		</div>
	</div>
</li></c:forEach></ul>
