
<c:set var="callOutFormBrchId"
							value="<%=wrapper.getProduct().getProductBrochuresFolderId() %>" />
						<%
						String fImgUrl1 = "/SPProduct-portlet/images/product/Icon-PDF.svg";
						String brochureUrl = "";String fileType = "";
						
							if(pageContext.getAttribute("callOutFormBrchId") != null) {
								Long brochureFolderId = (Long) pageContext.getAttribute("callOutFormBrchId");
								if(brochureFolderId > 0) {
									List<FileEntry> fileEntryBList = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), brochureFolderId);
															String brochureId = "";
															String brochureName = "";
															String version = "";
															for(FileEntry fileEntry : fileEntryBList){
																brochureId = fileEntry.getUuid();
																fileType = fileEntry.getMimeType();
																brochureName = fileEntry.getTitle();
																version = fileEntry.getVersion();
															if (brochureId != "") {
																brochureUrl = "/documents/"+fileEntry.getGroupId()+"/"+brochureFolderId+"/"+ brochureName + "/" +brochureId + "?version=" + version;
															}
															}
								}
								if(brochureUrl != ""){
									//brochureUrl = "/documents/12720/66036/downloadPDFTest/98a933ff-02f8-49f0-b8e9-1d65bd4eb4c5?version=1.0";
								%>
				<div class="callOutFormWrap margin-top-20">
					<div class="callOutForm">
					<% if(fImgUrl1 != ""){ %>
						<div class="productCallOutFormImg">
							<img src="<%=fImgUrl1 %>" alt="Product Brochure">
						</div>
						<%} %>
						<%-- "javascript:downloadFile('<%= brochureUrl %>','<%=fileType%>')"  --%>
						<div class="callOutFormButton actionButton">
							<a href="<%=brochureUrl %>" class="ns-button" target="_blank" onClick="javascript:downloadFile('<%= brochureUrl %>','<%=fileType%>')">
								<span><%=LabelUtil.getLabel(portletConfig,prefLocale, themeDisplay,"label.product.view.brochure")%></span>
							</a>
						</div>
					</div>
				</div>
							
							<% }} %>
							</div>
