<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<liferay-theme:defineObjects />

<style>
	.errorStatus {
		margin: 100px;
	}
	.separator{
		border: none;
	}
	.errorBottom{
		text-align: right;
	}
	.errorText {
    	margin-left: 20%;
	}
</style>

<div class="errorStatus">
	<div class="errorBox">
		<div class="errorTop">
			<span class="errorText"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.error.processing.operation")%></span>
		</div>
		<div class="separator">
		</div>
		<div class="errorBottom">
			<a class="backButton" href="javascript:history.go(-1);">« Back</a>
		</div>
	</div>
</div>