
					
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
											<th></th>
											<th class="header-col-title" style="text-align:center"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.nonFunded")%></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="feeDetailsList"
											items="${productWrapper.feeDetailsList}" varStatus="ff">
											<c:if test="${ff.index < feeDetailCount-1}">
											<tr>
												<td>${feeDetailsList.value[0]}</td>
												<td><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${feeDetailsList.value[1]}" /></td>
											</tr>
											</c:if>
											<c:if test="${ff.index == feeDetailCount-1}">
											<tr>
											<td class="lastRowStyling">${feeDetailsList.value[0]}</td>
												<td class="lastRowStyling"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${feeDetailsList.value[1]}" /></td>
											</tr>
											</c:if>
										</c:forEach>
										<c:if test="${not empty productWrapper.course.fundingDescPost}">
										<tr>
										<td class="footerNoteText"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.note")%> :  ${productWrapper.course.fundingDescPost}</td>
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
						
						<c:if test="${!mobilefeeFundListIsEmpty}">
						<div class="table-all course-expl" data-track-content
							data-content-name="${productWrapper.product.productName}"
							data-content-piece="For Self-sponsored Individuals">
							<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.selfSponsor")%></h2>
							<div class="feeStructure">
							
								<table>
									<thead>
									<tr>
									<th colspan="3" class="table-header-title"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.categoryIndividual")%></th>
									</tr>
									</thead>
									<c:forEach var="mobfeeDetailsList" items="${productWrapper.mobilefeeFundList}">
									<tbody>
									<c:forEach var="mobfeeList"
											items="${mobfeeDetailsList.value}" varStatus="ff">
											<c:if test="${ff.index < 1}">
										<tr>
											
											<th colspan="2" class="header-col-title" style="text-align:center">${mobfeeList.value[0]}</th>
										</tr>
										</c:if>
										
											<c:if test="${ff.index < feeTypeCount-1}">
											<tr>
											<td class="${feeTypeCount} ${ff.index}">${mobfeeList.value[2]}</td>
											
												<td><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${mobfeeList.value[3]}" /></td>
														</tr>
														</c:if>
														<c:if test="${ff.index == feeTypeCount-1}">
											<tr>
											<td class="${feeTypeCount} ${ff.index} lastRowStyling">${mobfeeList.value[2]}</td>
											
												
												<td class="lastRowStyling"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${mobfeeList.value[3]}" /></td>
														</tr>
														</c:if>
														<c:if test="${isHasSelfSpnsrNotes == true }">
														<c:if test="${ff.index == feeTypeCount-1}">
										<tr>
										<td class="footerNoteText"><c:if test="${not empty productWrapper.course.fundingDescPost}">Note :  ${productWrapper.course.fundingDescPost}</c:if></td>
											<td class="footerNoteText"><c:if test="${not empty mobfeeList.value[1]}">Note : ${mobfeeList.value[1]}</c:if></td>
											</tr>
											</c:if>
											</c:if>
									
									</c:forEach>
									</tbody>
									</c:forEach>
								</table>
								
							</div>
						</div>
						</c:if>
						<!--  For company sposored -->
						<c:if test="${!mobilecompfeeFundListIsEmpty}">
						<div class="table-all course-expl" data-track-content
							data-content-name="${productWrapper.product.productName}"
							data-content-piece="For Company sponsored">
							<h2><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.companySponsor")%></h2>
							<div class="feeStructure">
							
								<table>
									<thead>
									<tr>
									<th colspan="3" class="table-header-title"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.companytype")%></th>
									</tr>
									</thead>
									<c:forEach var="mobCompfeeDetailsList" items="${productWrapper.mobilecompfeeFundList}">
									<tbody>
									<c:forEach var="mobCompfeeList"
											items="${mobCompfeeDetailsList.value}" varStatus="ff">
											<c:if test="${ff.index < 1}">
										<tr>
											
											<th colspan="2" class="header-col-title" style="text-align:center">${mobCompfeeList.value[0]}</th>
										</tr>
										</c:if>
										
											<c:if test="${ff.index < feeTypeCount-1}">
											<tr>
											<td class="${feeTypeCount} ${ff.index}">${mobCompfeeList.value[2]}</td>
											
												<td><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${mobCompfeeList.value[3]}" /></td>
														</tr>
														</c:if>
														<c:if test="${ff.index == feeTypeCount-1}">
											<tr>
											<td class="${feeTypeCount} ${ff.index} lastRowStyling">${mobCompfeeList.value[2]}</td>
											
												
												<td class="lastRowStyling"><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${mobCompfeeList.value[3]}" /></td>
														</tr>
														</c:if>
														<c:if test="${isHasCompSpnsrNotes == true }">
														<c:if test="${ff.index == feeTypeCount-1}">
										<tr>
										<td class="footerNoteText"><c:if test="${not empty productWrapper.course.fundingDescPost}"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.note")%> :  ${productWrapper.course.fundingDescPost}</c:if></td>
											<td class="footerNoteText"><c:if test="${not empty mobCompfeeList.value[1]}"><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.note")%> : ${mobCompfeeList.value[1]}</c:if></td>
											</tr>
											</c:if>
									</c:if>
									</c:forEach>
									</tbody>
									</c:forEach>
								</table>
								
							</div>
						</div>
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
												<td>${miscfeeDetailsList.value[1]}</td>
											</tr>
										</c:forEach>
										<c:if test="${not empty productWrapper.course.miscFeeDesc}">
										<tr>
										<td class="footerNoteText">
										<%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.note")%> :  ${productWrapper.course.miscFeeDesc}
										</td>
										<td></td>
										</tr>
										</c:if>
									</tbody>
								</table>
							</div>
						</div>
						</c:if>


