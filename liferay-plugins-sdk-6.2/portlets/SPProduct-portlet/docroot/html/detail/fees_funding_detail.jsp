<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="Lp_Cont_6" class="section">
<h4 class="header prod-accrodion-h4 toggler-header-collapsed"><a href="#"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseFeesFunding")%></a> </h4>
<div class="content  toggler-content-collapsed">
	<section class="Course-structure-section">
		<div class="Course_wrap">
			<h2 class="course_h2">
				<%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseFeesFunding")%>
				<c:if test="${not empty productWrapper.feeDetailsList || !selffeeFundListIsEmpty}">
				<div class="subheader">(<%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.feesStated")%> ${currencyCode}<%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.feesStatedEnd")%>)</div>
				</c:if>
			</h2>
		</div>
	</section>
	<div class="Product-section-wrap">
		<div class="desk-view-left"></div>
		<div class="desk-tab-view">
			<div class="prod-cont-sec1">
				<div class="Entry-middle ">
					<div class="Entrymodule">
					
						<div class="feeFund-desktopView">
						<!--  Non-funded fee -->
						<c:if test="${not empty productWrapper.feeDetailsList}">
						<div class="table-all course-expl" data-track-content
							data-content-name="${productWrapper.product.productName}"
							data-content-piece="Non-funded">
							<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.nonFunded")%></h2>
							<div class="feeStructure">
								<table>
									<thead>
										<tr>
											<th><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.type")%></th>
											<th class="header-col-title"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.create.feeDetail.amount")%></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="feeDetailsList"
											items="${productWrapper.feeDetailsList}" varStatus="ff">
											<c:if test="${ff.index < feeDetailCount-1}">
											<tr>
												<td>${feeDetailsList.value[0]}</td>
												<td class="fee-rightAlign"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${feeDetailsList.value[1]}" /></td>
											</tr>
											</c:if>
											<c:if test="${ff.index == feeDetailCount-1}">
											<tr>
											<td class="lastRowStyling">${feeDetailsList.value[0]}</td>
												<td class="lastRowStyling fee-rightAlign"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${feeDetailsList.value[1]}" /></td>
											</tr>
											</c:if>
										</c:forEach>
										<c:if test="${not empty productWrapper.course.fundingDescPost}">
										<tr>
										<td class="footerNoteText"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.note")%>:  ${productWrapper.course.fundingDescPost}</td>
										<td>
										</td>
										</tr>
										</c:if>
									</tbody>
								</table>
							</div>
						</div>
						</c:if>
						
						<!--  For self sposored individulas -->
						<c:if test="${!selffeeFundListIsEmpty}">
						<div class="table-all course-expl" data-track-content
							data-content-name="${productWrapper.product.productName}"
							data-content-piece="For Self-sponsored Individuals">
							<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.selfSponsor")%></h2>
							<c:forEach begin="0" end="${totalCnt }" step="12" var="sc">
							<c:set var="s" value="${sc}" />
							<div class="feeStructure">
								<table>
									<thead>
									<tr>
									<th style="border-bottom:none"></th>
									<th colspan="3" class="table-header-title"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.categoryIndividual")%></th>
									</tr>
										<tr>
											<th style="border-top:none;vertical-align: initial;"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.type")%></th>
											<%int f = 0; %>
											<c:forEach var="selffeeDetailsList"
											items="${productWrapper.selffeeDetailsList}">
											<c:forEach var="selffeeList"
											items="${selffeeDetailsList.value}">
											<%if(f < 1){ %>
											<c:if test="${not empty selffeeList.value[s]}">
											<th class="header-col-title ${s}">${selffeeList.value[s]}</th>
											</c:if>
											<c:if test="${not empty selffeeList.value[s+4]}">
											<th class="header-col-title ${s}">${selffeeList.value[s+4]}</th>
											</c:if>
											<c:if test="${not empty selffeeList.value[s+8]}">
											<th class="header-col-title ${s}">${selffeeList.value[s+8]}</th>
											</c:if>
											<%} %>
											<% f = f+1; %>
											</c:forEach>
											</c:forEach>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="selffeeDetailsList"
											items="${productWrapper.selffeeDetailsList}">
											<c:forEach var="selffeeList"
											items="${selffeeDetailsList.value}" varStatus="ff">
											<c:if test="${ff.index < feeTypeCount-1}">
											<tr>
											<td class="${feeTypeCount} ${s}">${selffeeList.value[s+2]}</td>
											
												<c:if test="${not empty selffeeList.value[s+3]}">
												<td class="fee-rightAlign ${s}"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${selffeeList.value[s+3]}" /></td>
														</c:if>
														<c:if test="${not empty selffeeList.value[s+7]}">
														<td class="fee-rightAlign ${s}"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${selffeeList.value[s+7]}" /></td>
														</c:if>
														<c:if test="${not empty selffeeList.value[s+11]}">
														<td class="fee-rightAlign ${s}"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${selffeeList.value[s+11]}" /></td>  
														</c:if>
														</tr>
														</c:if>
														<c:if test="${ff.index == feeTypeCount-1}">
											<tr>
											<td class="${feeTypeCount} ${ff.index} lastRowStyling">${selffeeList.value[2]}</td>
											
														<c:if test="${not empty selffeeList.value[s+3]}">
												<td class="lastRowStyling fee-rightAlign ${s}"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${selffeeList.value[s+3]}" /></td>
														</c:if>
														<c:if test="${not empty selffeeList.value[s+7]}">
														<td class="lastRowStyling fee-rightAlign ${s}"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${selffeeList.value[s+7]}" /></td>
														</c:if>
														<c:if test="${not empty selffeeList.value[s+11]}">
														<td class="lastRowStyling fee-rightAlign ${s}"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${selffeeList.value[s+11]}" /></td>  
														</c:if>
														</tr>
														</c:if>
													</c:forEach>
											
										</c:forEach>
										<c:if test="${isHasSelfSpnsrNotes == true }">
										<tr>
										
										<td class="footerNoteText">
										<c:if test="${not empty productWrapper.course.fundingDescPost}">
										Note :  ${productWrapper.course.fundingDescPost}
										</c:if>
										</td>
										
										<%int f2 = 0; %>
										<c:forEach var="selffeeDetailsList"
											items="${productWrapper.selffeeDetailsList}">
											<c:forEach var="selffeeList"
											items="${selffeeDetailsList.value}">
											<%if(f2 < 1){ %>
														
											<td class="footerNoteText ${s}"><c:if test="${not empty selffeeList.value[s+1]}">Note : ${selffeeList.value[s+1]}</c:if></td>
											<c:if test="${not empty selffeeList.value[s+7]}">
														
											<td class="footerNoteText ${s}"><c:if test="${not empty selffeeList.value[s+5]}">Note :  ${selffeeList.value[s+5]}</c:if></td></c:if>
														<c:if test="${not empty selffeeList.value[s+11]}">
											<td class="footerNoteText ${s}"><c:if test="${not empty selffeeList.value[s+9]}">Note :  ${selffeeList.value[s+9]}</c:if></td>
											</c:if>
											<%} %>
											<% f2 = f2+1; %>
											</c:forEach>
											</c:forEach>
											</tr>
											</c:if>
									</tbody>
								</table>
							</div>
							</c:forEach>
						</div>
						</c:if>
						<!--  For company sposored -->
						<c:if test="${!compfeeFundListIsEmpty}">
						<div class="table-all course-expl" data-track-content
							data-content-name="${productWrapper.product.productName}"
							data-content-piece="For Company sponsored">
							<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.companySponsor")%></h2>
							<c:forEach begin="0" end="${cmptotalCnt }" step="12" var="cc">
							<c:set var="cc" value="${cc}" />
							<div class="feeStructure">
								<table>
									<thead>
									<tr>
									<th style="border-bottom:none"></th>
									<th colspan="3" class="table-header-title"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.companytype")%></th>
									</tr>
										<tr>
											<th style="border-top:none;vertical-align: initial;"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.type")%></th>
											<c:forEach var="compfeeDetailsList"
											items="${productWrapper.compfeeDetailsList}">
											<c:forEach var="compffeeList"
											items="${compfeeDetailsList.value}" varStatus="f">
											<c:if test="${f.index < 1}">
														<c:if test="${not empty compffeeList.value[cc]}">
											<th class="header-col-title">${compffeeList.value[cc]}</th>
											</c:if>
														<c:if test="${not empty compffeeList.value[cc+4]}">
											<th class="header-col-title">${compffeeList.value[cc+4]}</th>
											</c:if>
														<c:if test="${not empty compffeeList.value[cc+8]}">
											<th class="header-col-title">${compffeeList.value[cc+8]}</th>
											</c:if>
											</c:if>
											</c:forEach>
											</c:forEach>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="compfeeDetailsList"
											items="${productWrapper.compfeeDetailsList}">
											<c:forEach var="compffeeList"
											items="${compfeeDetailsList.value}" varStatus="ff">
											<c:if test="${ff.index < feeTypeCount-1}">
											<tr>
											<td class="${feeTypeCount}">${compffeeList.value[cc+2]}</td>
														<c:if test="${not empty compffeeList.value[cc+3]}">
												<td class="fee-rightAlign"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${compffeeList.value[cc+3]}" /></td>
														</c:if>
														<c:if test="${not empty compffeeList.value[cc+7]}">
														<td class="fee-rightAlign"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${compffeeList.value[cc+7]}" /></td>
														</c:if>
														<c:if test="${not empty compffeeList.value[cc+11]}">
														<td class="fee-rightAlign"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${compffeeList.value[cc+11]}" /></td>  
														</c:if>
														</tr>
														</c:if>
														
														<c:if test="${ff.index == feeTypeCount-1}">
											<tr>
											<td class="${feeTypeCount} ${ff.index} lastRowStyling">${compffeeList.value[cc+2]}</td>
											
														<c:if test="${not empty compffeeList.value[cc+3]}">
												<td class="lastRowStyling fee-rightAlign"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${compffeeList.value[cc+3]}" /></td>
														</c:if>
														<c:if test="${not empty compffeeList.value[cc+7]}">
														<td class="lastRowStyling fee-rightAlign"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${compffeeList.value[cc+7]}" /></td>
														</c:if>
														<c:if test="${not empty compffeeList.value[cc+11]}">
														<td class="lastRowStyling fee-rightAlign"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${compffeeList.value[cc+11]}" /></td>  
														</c:if>
														</tr>
														</c:if>
													</c:forEach>
											
										</c:forEach>
										<c:if test="${isHasCompSpnsrNotes == true }">
										<tr>
										
										<td class="footerNoteText">
										<c:if test="${not empty productWrapper.course.fundingDescPost}">
										Note :  ${productWrapper.course.fundingDescPost}
										</c:if>
										</td>
										
										<c:forEach var="compfeeDetailsList"
											items="${productWrapper.compfeeDetailsList}">
											<c:forEach var="compffeeList"
											items="${compfeeDetailsList.value}" varStatus="f">
											<c:if test="${f.index < 1}">
														
											<td class="footerNoteText"><c:if test="${not empty compffeeList.value[cc+1]}"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.note")%> :  ${compffeeList.value[cc+1]}</c:if></td>
											
														<c:if test="${not empty compffeeList.value[cc+7]}">
											<td class="footerNoteText"><c:if test="${not empty compffeeList.value[cc+5]}"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.note")%> :  ${compffeeList.value[cc+5]}</c:if></td>
											</c:if>
														<c:if test="${not empty compffeeList.value[cc+11]}">
											<td class="footerNoteText"><c:if test="${not empty compffeeList.value[cc+9]}"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.note")%> :  ${compffeeList.value[cc+9]}</c:if></td>
											</c:if>
											</c:if>
											
											</c:forEach>
											</c:forEach>
											</tr>
											</c:if>
									</tbody>
								</table>
							</div>
							</c:forEach>
						</div>
						</c:if>
						
						<c:if test="${not empty productWrapper.course.feeDetailsDesc }">
						<div class="feeNotes">${productWrapper.course.feeDetailsDesc}</div>
						</c:if>
						<!--  Miscellaneous fee -->
						<c:if test="${!miscfeeDetailsListIsEmpty}">
						<div class="table-all course-expl" data-track-content
							data-content-name="${productWrapper.product.productName}"
							data-content-piece="Miscellaneous Fee" style="text-align: center;">
							<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.miscellaneousFees")%></h2>
							<div class="feeStructure">
								<table>
									<thead>
										<tr>
											<th colspan="2" class="header-col-title" style="text-align:center"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.miscellaneousFees.individuals")%></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="miscfeeDetailsList"
											items="${productWrapper.miscfeeDetailsList}">
											<tr>
												<td>${miscfeeDetailsList.value[0]}</td>
												<td class="fee-leftAlign">${miscfeeDetailsList.value[1]}</td>
											</tr>
										</c:forEach>
										<c:if test="${not empty productWrapper.course.miscFeeDesc}">
										
										
										<tr>
										<td class="footerNoteText">
										<%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.courseStructure")%><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.note")%> :  ${productWrapper.course.miscFeeDesc}
										</td>
										<td></td>
										</tr>
										</c:if>
									</tbody>
								</table>
							</div>
						</div>
						</c:if>
						</div>
						
						
						<div class="feeFund-mobileView">
							<%@ include file="/html/detail/feesFunding_mobileView.jsp"%>
						</div>
						
					</div>
				</div>
			</div>


		</div>
	</div>
</div>
</div>
