<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="javax.servlet.http.HttpUtils.*" %> 
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
List listSize= (List) request.getAttribute("docList");
List msgList= (List) request.getAttribute("msgList");
String feedPageTitle= (String) request.getAttribute("feedPageTitle");
String imgPath=themeDisplay.getPathThemeImages();

String error= (String) request.getAttribute("error");
%>

<div class="style2UI-mainDiv">
<%if (Validator.isNotNull(error)){ %>
	<div class="emptyFeedsMsg">
		<%= error %>
	</div>
<%} else { %>
	<div class="style2UI-content">
		<div class="style2UI-heading">
			<%= feedPageTitle %>
		</div>
		<div class="style2UI-list">

			<div class="style2UI-listCol1">
			<c:if test="${not empty obj1 }">
				<div class="search-stream-style2UI-event-block">
					<div style="width: 100%; position: relative;">
						<div class="search-stream-style2UI-block-icon">
							<a href="${obj1.detailUrl }"><img src="${obj1.url }" alt="Image"></a>
						</div>
						<div class="arrow-up-events"></div>
						<div class="contentType-name-Events">
							<img src="${obj1.imagepath }" alt="${obj1.header }">
							<span>${obj1.header }</span>
						</div>
						<div class="search-stream-style2UI-block-content">
							<div class="search-stream-style2UI-content-title">
								<a href="${obj1.detailUrl }">${obj1.title }</a>
							</div>
							<div class="search-stream-style2UI-content-desc">
								${obj1.description }
							</div>
						</div>
						<div class="search-stream-style2UI-block-button">
							<a href="${obj1.detailUrl }"><div class="reg-Button">${obj1.text1 }</div></a>
							<a href="/${obj1.pageUrl}"><div class="all-Button">${obj1.text2 }</div></a>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${not empty obj3 }">
				<div class="search-stream-style2UI-event-block">
					<div style="width: 100%; position: relative;">
						<div class="search-stream-style2UI-block-icon">
							<a href="${obj3.detailUrl }"><img src="${obj3.url }" alt="image"></a>
						</div>
						<div class="arrow-up-gallery"></div>
						<div class="contentType-name-gallery">
							<img src="${obj3.imagepath }" alt="${obj3.header }">
							<span>${obj3.header }</span>
						</div>
						<div class="search-stream-style2UI-block-content">
							<div class="search-stream-style2UI-content-title">
								<a href="${obj3.detailUrl }">${obj3.title }</a>
							</div>
							<div class="search-stream-style2UI-content-desc">
								${obj3.description }
							</div>
						</div>
						<div class="search-stream-style2UI-block-button">
							<a href="${obj3.detailUrl }"><div class="reg-Button">${obj3.text1 }</div></a>
							<a href="/${obj3.pageUrl}"><div class="all-Button">${obj3.text2 }</div></a>
						</div>
					</div>
				</div>
				</c:if>
			</div>

			<div class="style2UI-listCol2">
			<c:if test="${not empty obj2 }">
				<div class="search-stream-style2UI-event-block">
					<div style="width: 100%; position: relative;">
						<div class="search-stream-style2UI-block-icon">
							<a href="${obj2.detailUrl }"><img src="${obj2.url }" alt="Image"></a>
						</div>
						<div class="arrow-up-events1"></div>
						<div class="contentType-name-Events1">
							<img src="${obj2.imagepath }" alt="${obj2.header }">
							<span>${obj2.header }</span>
						</div>
						<div class="search-stream-style2UI-block-content">
							<div class="search-stream-style2UI-content-title">
								<a href="${obj2.detailUrl }">${obj2.title }</a>
							</div>
							<div class="search-stream-style2UI-content-desc">
								${obj2.description }
							</div>
						</div>
						<div class="search-stream-style2UI-block-button">
							<a href="${obj2.detailUrl }"><div class="reg-Button">${obj2.text1 }</div></a>
							<a href="/${obj2.pageUrl}"><div class="all-Button">${obj2.text2 }</div></a>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${not empty obj4 }">
				<div class="search-stream-style2UI-event-block">
					<div style="width: 100%; position: relative;">
						<div class="search-stream-style2UI-block-icon">
							<a href="${obj4.detailUrl }"><img src="${obj4.url }" alt="Image"></a>
						</div>
						<div class="arrow-up-blog"></div>
						<div class="contentType-name-blog">
							<img src="${obj4.imagepath }" alt="${obj4.header }">
							<span>${obj4.header }</span>
						</div>
						<div class="search-stream-style2UI-block-content">
							<div class="search-stream-style2UI-content-title">
								<a href="${obj4.detailUrl }">${obj4.title }</a>
							</div>
							<div class="search-stream-style2UI-content-desc">
								${obj4.description }
							</div>
						</div>
						<div class="search-stream-style2UI-block-button">
							<a href="${obj4.detailUrl }"><div class="reg-Button">${obj4.text1 }</div></a>
							<a href="/${obj4.pageUrl}"><div class="all-Button">${obj4.text2 }</div></a>
						</div>
					</div>
				</div>
				</c:if>
			</div>

			<div class="style2UI-listCol3">
				<div class="search-stream-style2UI-grp-block">
					<div class="contentType-name-grp">
						<img src="<%= imgPath %>/feeds/Discussions-icon.png" alt="Discussions">
						<span>Discussion</span>
					</div>
					<% if (!msgList.isEmpty()) {
					int k = 0;
					for (int i=0;i<msgList.size()/4;i++){ %>
					<div style="width: 100%; position: relative;border-bottom:1px solid grey;">
						<div class="search-stream-style2UI-block-content">
							<div class="search-stream-style2UI-content-title">
								<%= msgList.get(k) %>
								<% k=k+1; %>
							</div>
							<div class="date-Div">
								Posted <%= msgList.get(k) %>
								<% k=k+1; %>
							</div>
							<div class="search-stream-style2UI-content-desc">
								<%= msgList.get(k) %>
								<% k=k+1; %>
							</div>
						</div>
						<div class="search-stream-style2UI-block-feeds-button">
							<a href="<%= msgList.get(k) %>"><div class="rdMore-Button">READ MORE</div></a>
							<a href="<%= msgList.get(k) %>"><div class="cmts-Button"><img src="<%= imgPath %>/feeds/msg-icon.png" alt="Message"></div></a>
							<% k=k+1; %>
						</div>
					</div>
					<%}
					 } %>
				</div>
			</div>

			<div class="style2UI-listCol4">
				<div class="search-stream-style2UI-doc-block">
					<div class="contentType-name-doc">
						<img src="<%=imgPath %>/feeds/Doc-Library-icon.png" alt="Library">
						<span><%= LanguageUtil.get(pageContext,"label.doc.library")%></span>
					</div>
					<% 
					if(!listSize.isEmpty()){
					int j = 0;
					for(int i=0;i<(listSize.size()/4);i++){
					%>

					<div style="width: 100%; position: relative;border-bottom:1px solid grey;">
						<div class="search-stream-style2UI-block-content">
							<div class="search-stream-style2UI-content-title">
								<%= listSize.get(j) %>
								<%j=j+1; %>
							</div>
							<div class="date-Div">
								Posted <%= listSize.get(j) %>
								<% j=j+1; %>
							</div>
							<div class="search-stream-style2UI-content-desc">
								<%= listSize.get(j) %>
								<%j=j+1; %>
							</div>
						</div>
						<div class="search-stream-style2UI-block-feeds-button">
							<a href="<%= listSize.get(j) %>"><div class="rdMore-Button">READ MORE</div></a>
							<% j=j+1; %>
						</div>
					</div>
					<% }
					} %>
				</div>
			</div>

		</div>
	</div>
	<%} %>
</div>
