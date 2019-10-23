
			<div class="" id="mainContainer">
				
				 <div class="form-section ">
				 <div class="Input_Fullwidth componentTitle" style="display: inline-block;  width: 30%;">
				 	<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.withOutFunding")%>
				 	</div>
				 	<div
							class="Input_Fullwidth Addcomponent_click align-margintop" style="width: 40%; vertical-align: baseline;">

							<div class="Add_button">
								<a id="showFeeButton" href="javascript:showFeeInstance()"
									class="Button-green button-pos-center" style="margin:0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.addFeeDetails")%></a>
							</div>
						</div>
                        <div class="form-inner Border Form-pop-padding bg_title hideFunding" id="form-inner-container">
                        
                            <div class="Table-form_div ">
                               <%@ include file="/html/create/fee_tableHeader.jsp"%>
                                       
                                <form action="#" method="POST" id="feeDetailFormId" name="feeDetailForm" >
                                 <input type="hidden" id="globalCountId"  name="globalCountId" value="0">
                                 <c:if test="${not empty feeDetailListJSON}">
                                <div id="feeInner_0">
                        
                                
                                </div>
                               </c:if>
                               <c:if test="${empty feeDetailListJSON}">
                                <div id="feeInner_0" class="showAddFunding">
                        
                                
                                </div>
                               </c:if>
                            <div class="Input_Fullwidth Addproduct_click addFeeFunding-button hideFunding" id="addFeeInstanceButton"">
                         <div class="Add_button">
                            <a href="javascript:addFeeInstances('','', '', '', '','','')" class="Button-green button-pos-center"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.feeDetails.addFeeComponent")%></a>
                            </div>
                            <div id="errorMsg-Modal"></div>
                        </div>
                        </form>
                    </div>
                </div>
                 </div>
                </div>
   
