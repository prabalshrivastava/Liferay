<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ page import="com.sambaash.platform.util.ThumbnailUtil"%>
<%@ page
	import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="editOutcome">
	<portlet:param name="jspPage" value="/html/create/outcome.jsp" />
	<portlet:param name="action" value="editOutcome"></portlet:param>
</portlet:renderURL>

<div class="product_create">
	<div class="product_create_wrapper">
		<div class="Product_Sidebar">
			<%@ include file="/html/create/navigation.jsp"%>
		</div>


		<div class="Right_content_section">
			<div>
				<c:if test="<%=themeDisplay.isSignedIn() %>">
					<div class="Productadd-section">
						<a href="${addOutcome}" class="addproduct-btn"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outcome.createOutcome")%></a>
					</div>
				</c:if>	
				<div><%@ include file="/html/create/searchbar.jsp"%></div>
			
			</div>
			<div class="Border">
				<div class="Product_listing_table">
					<table>
						<thead>
							<tr>
								<th><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outcome.outcomeImage")%></th>
								<th><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outcome.outcomeCode")%></th>
								<th<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.outcome.outcomeDescription")%>></th>
								<th><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.edit")%></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="outcome" items="${outcomeList}">
								<tr>

									<c:set var="outcomeImageId" value="${outcome.outcomeFolderId }" />
									<td id="">
										<%
											Long imgId = 0L;
												if (Validator.isNotNull(pageContext.getAttribute("outcomeImageId"))) {
													imgId = (Long) pageContext.getAttribute("outcomeImageId");
												}
												String imgUrl = "";
												if (imgId != null && imgId.compareTo(Long.parseLong("0")) != 0) {
													List<FileEntry> fileEntryList = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(),
															imgId);

													for (FileEntry fileEntry : fileEntryList) {
														imgUrl = ThumbnailUtil.getThumbnailUrl(
																DLAppServiceUtil.getFileEntry(fileEntry.getFileEntryId()),
																themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
																themeDisplay.getPathContext(), 1);
										%> <img src="<%=imgUrl%>" alt="Outcome"> 
										<%
									 	}
									 		}
									 %>
									</td>
									<td id="">${outcome.outcomeCode}</td>
									<c:set var="outComeDesc" value="${outcome.outcomeDesc}" />
									<%
										String outComeDesc = (String) pageContext.getAttribute("outComeDesc");
										if (outComeDesc.length() > 200) {
											outComeDesc = outComeDesc.substring(0, 200) + "..";
										}
									%>
									<td id=""><%=outComeDesc %></td>
									<td><div class="Edit_image">
											<a
												href="${editOutcome}&<portlet:namespace />spOutcomeId=${outcome.spOutcomeId}"><img
												src="<%=request.getContextPath()%>/images/Product_create/Icon-Edit.svg" alt="Edit"></a>
										</div></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!--CONTENT WRAP END-->
			</div>
		</div>
	</div>
</div>


