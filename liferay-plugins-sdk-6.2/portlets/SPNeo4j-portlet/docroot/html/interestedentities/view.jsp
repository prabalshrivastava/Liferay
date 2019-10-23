<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />
<section class="sp-feeds">
	<div class="sp-feeds-wrap">
		<div class="sp-feeds-section-title" style="padding-bottom: 5px; border-bottom: 1px solid #DDDDDD;">Things you may be interested</div>
		<div class="sp-feeds-interested">
			<ul>
				<c:if test="${not empty assetEntityGraphWrappersUserMayBeInterested}">
					<c:forEach items="${assetEntityGraphWrappersUserMayBeInterested}" var="assetEntityGraphWrapperUserMayBeInterested">
						<li class="inline-block">
							
							<div class="sp-feeds-interested-image block">
								<img class="full-width" src="${assetEntityGraphWrapperUserMayBeInterested.imageUrl}" alt="Image"/>
							</div>
							<div class="sp-feeds-interested-body">
								<div class="sp-feeds-interested-title block margin-bottom-quarter">
									<a href="${assetEntityGraphWrapperUserMayBeInterested.detailUrl}">
										<c:out value="${assetEntityGraphWrapperUserMayBeInterested.title}"></c:out>
									</a>
								</div>
								<div class="sp-feeds-interested-content">
									<p>${assetEntityGraphWrapperUserMayBeInterested.content}</p>
								</div>
							</div>
							
							
						</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
		
		<%--
		
		<div style="font-size: 16px; padding-bottom: 10px; border-bottom: 1px solid #DDDDDD; font-weight: bold;">Blogs you may be interested</div>
		<div style="padding: 10px 0;">
			<c:if test="${not empty assetEntityGraphBosUserMayBeInterested}">
				<c:forEach items="${assetEntityGraphBosUserMayBeInterested}" var="assetEntityGraphBoUserMayBeInterested">
					<b style="font-size: 15px; margin-bottom: 6px; display: block;"><a href="${assetEntityGraphBoUserMayBeInterested.detailUrl}"><c:out value="${assetEntityGraphBoUserMayBeInterested.title}"></c:out></a></b>
					<div class="helper-clearfix">
						<div style="float: left;line-height: 0;">
							<img src="${assetEntityGraphBoUserMayBeInterested.imageUrl}" style="width: 68px; height: 68px;" alt="Image"/>
						</div>
						<div style="margin-left: 80px; min-height: 68px;">
							<div>${assetEntityGraphBoUserMayBeInterested.content}</div>
						</div>
						<hr style="margin: 10px 0;border-top: none;">
					</div>
				</c:forEach>
			</c:if>
		</div>
		
		--%>
	</div>
</section>
