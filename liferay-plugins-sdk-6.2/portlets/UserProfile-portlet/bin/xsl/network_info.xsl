<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="java">
<xsl:output method="html" indent="yes" encoding="UTF-8"/>
<xsl:param name="can_edit"/>
<xsl:param name="categoryList"/>
<xsl:param name="communityName"/>
<xsl:param name="publicField"/>
<xsl:param name="displayField"/>
<xsl:param name="resource" />
<xsl:template match="/">
	<head>
	<script><![CDATA[
		AUI().ready(
		'aui-panel',
		'anim',
		function(A) {
			var container = new A.Panel(
					{
						collapsible: true,
						//collapsed: true,
						headerContent: '<font class="header-pretitle">Network<span class="header-posttitle"> Information</span></font>',
						boundingBox: '#webInfo > .aui-panel-content',
						contentBox:'#webInfo'
					}
				).render();
			
		});
				
		function addNetworkInfo(category,categoryDetails){
			addSingleInputAjaxCall(category,categoryDetails,'addSingleInputInstance');
			
			//attach event to single input field
			
			AUI().ready(function(A) {  
				var singleInputDiv = A.one('#' + category + '_new');
				
				if(singleInputDiv){
					singleInputDiv.delegate(['keypress','blur','change','click'], function(event){
						var sDiv = this;
						if (event.keyCode == 13){ 
					    	saveNetworkInfo(sDiv.attr('id'));
					    }else if(event.type == "blur"){
					    	saveNetworkInfo(sDiv.attr('id'));
		           		}else if(event.type == "change"){
					    	saveNetworkInfo(sDiv.attr('id'));
		           		}
					},'input[type=text],textarea,input[type=radio]'); 
				}
			});
			
		}
	    
	    function saveNetworkInfo(txtId)
	    {	
	    	var inputField = document.getElementById(txtId);
	    	
	    	if(inputField != null){
	    		var category_name = inputField.getAttribute("category");
		    	var position =  inputField.getAttribute("position");
				var editorType = inputField.getAttribute("editorType");
				var input_value = '';
				var isValid = true;
				var objType = inputField.type;
				
				/*if(editorType == 'CKEditor'){
					input_value = CKEDITOR.instances[txtId].getData(); //get value from ckeditor
					inputField.value = input_value;
				}*/
				
				if(objType == 'select-one'){
					input_value = inputField.options[inputField.selectedIndex].value.trim();
				}else if(objType == 'select-multiple'){
					var opt = inputField.options;
					for ( var i = 0; i < opt.length; i++) {
						if (opt[i].selected){
							if(input_value != ''){
								input_value += ', ' + opt[i].value;
							}else{
								input_value = opt[i].value;
							}
						}
					}
				}else if(objType == 'radio'){
					if(inputField.checked){
						input_value = inputField.value;
					}
				}else if(objType == 'textarea'){
					var ckeditor =CKEDITOR.instances[txtId];
					if (ckeditor != null) {
						input_value = ckeditor.getData();
						inputField.value = input_value;
					}else{
						input_value = inputField.value;
					}	
				}else{//default is textfield
					input_value = " "+inputField.value+" ";			
				}
				if(category_name == 'linkedin')
				{
					isValid = validateLinkedIn(txtId,"");
					if(isValid){
					var linkedin;
						
						if(input_value.indexOf("https://") != -1)
						{
							linkedin = " "+input_value+" ";
						} else {
							linkedin = " https://" + input_value+" ";
						}
						ajaxSubmitNetwork(category_name,linkedin,txtId, position);
					}
				}else if(category_name == 'email')
				{
					isValid = validateInput(txtId,"",'5');
					if(isValid){
						ajaxSubmitNetwork(category_name,input_value,txtId, position);
					}
				}else if(category_name == 'twitter' || category_name == 'facebook')
				{
					isValid = validateInput(txtId,"",'0');
				
					if(category_name == 'twitter'){
						input_value = " https://www.twitter.com/"+input_value+" ";
					}else {
						input_value = " https://www.facebook.com/"+input_value+" ";
					}
					if(isValid){
						ajaxSubmitNetwork(category_name,input_value,txtId, position);
					}
				
				}else if(category_name == 'messenger')
				{
					var messengerTypeId = category_name + '_select_' + position;
					//var msgrTypeValue = jq("#" + messengerTypeId).val();
					var msgrTypeValue = document.getElementById(messengerTypeId).value;
					
					isValid = validateInput(txtId,"",'0');
					
					if(isValid){
						ajaxSubmitNetwork(category_name, msgrTypeValue + ':' + input_value, txtId, position);
					}
					
				}else if(category_name == 'websites')
				{
					isValid = validateInput(txtId,"",'3');
					if(isValid){
						ajaxSubmitNetwork(category_name,input_value,txtId, position);
					}
				}else
				{
					var A = AUI();
					var validationKey = A.one('#'+txtId).attr('validation_key');
					
					if(!validationKey){
						validationKey = '0';
					}
					
					if(objType == 'text' || objType == 'textarea'){
						isValid = validateInput(txtId,"",validationKey);
					}else{ 
						isValid = true; //bypass validation for other field types
					}
					
					if(isValid){
						ajaxSubmitNetwork(category_name,input_value,txtId, position);
					}
				}
	    	}//end inputField
	    	
	    }//end saveNetworkInfo
	    
		function ajaxSubmitNetwork(categoryName, txtVal, inputId, position){
			if(txtVal != ""){
				ajaxSubmitAddSingleField(categoryName, categoryName+"_url", txtVal, 'network_info', inputId);
			}else{
				removeElement('new_' + category_name + '_' + position);
			}
		}
		
		function ajaxSubmitNetworkPrefix(categoryName, txtVal, inputId, position){
			if(txtVal != ""){
				
				if(txtVal.indexOf('https://') < 0){
					txtVal = 'https://' + txtVal;
				}
					
				ajaxSubmitAddSingleField(categoryName, categoryName+"_url", txtVal, position, inputId);
			}else{
				removeElement('new_' + category_name + '_' + position);
			}
		}
		
		]]>
	</script>
	</head>
	<body style="width:100%">
		<div id="webInfo">
			<div class="showdowheader-profile" />
			<div class="yui3-widget-bd">
				<div id="webinfo_details">
					<xsl:call-template name="webinfo_button" />
					<xsl:for-each select="//network_info/*">
						<xsl:variable name="categoryName">
							<xsl:value-of select="name()" />
						</xsl:variable>
						<xsl:if test="(contains(concat(',',$displayField,','),concat(',',$categoryName,',')))">
							<xsl:choose>
								<xsl:when test="$can_edit=0">
									<xsl:if test="(contains(concat(',',$publicField,','),concat(',',$categoryName,',')))"><!-- allow fields to view on public -->
										<xsl:call-template name="showNetworkInfo" />
									</xsl:if>
								</xsl:when>
								<xsl:when test="$can_edit=2">
									<xsl:if test="(contains(concat(',',$publicField,','),concat(',',$categoryName,',')))"><!-- allow fields to view on public -->
										<xsl:call-template name="showNetworkInfo" />
									</xsl:if>
								</xsl:when>
								<xsl:otherwise>
									<xsl:call-template name="showNetworkInfo" />
								</xsl:otherwise>
							</xsl:choose>
						</xsl:if>
					</xsl:for-each>
				</div>
			</div>
			<!-- <xsl:apply-templates select="profile/network_info" /> -->
			<xsl:call-template name="listOfCategory" />
		</div>
	</body>
	</xsl:template>

	<xsl:template name="showNetworkInfo">
		<xsl:variable name="categoryName">
			<xsl:value-of select="name()" />
		</xsl:variable>
								
		<div class="groupWidth">
			<div class="content-title">
				<div>
				<div style="float:left">
					<xsl:choose>
						<xsl:when test="@fieldType != ''">
							<xsl:call-template name="Pascalize">
								<xsl:with-param name="pText" select="@label" />
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
						
							<xsl:value-of
								select="java:getString($resource,concat($communityName,'.userprofile.networkinfo.',name(),'.label'))" />
						</xsl:otherwise>
					</xsl:choose>
				</div>
				<div style="float:right;">
					<xsl:if test="$can_edit=1">
						<input type="hidden" id="{$categoryName}_counter" value="0" />
						<xsl:choose>
							<xsl:when test="@fieldType != ''">
								<xsl:if test="@edittable='true'">
									<a class="book userprofile-add-link"
										href="javascript:addNetworkInfo('{$categoryName}','{$categoryName}_url')"
										title="Add">&#160;</a>
								</xsl:if>
							</xsl:when>
							<xsl:otherwise>
								<a class="book userprofile-add-link"
								href="javascript:addNetworkInfo('{$categoryName}','{$categoryName}_url')"
								title="Add">&#160;</a>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:if>
				</div>
				</div>
				
			</div>
			<div class="seperatedline" />
			<div id="{$categoryName}">
				<xsl:for-each select=".">
					<xsl:apply-templates mode="output" select=".">
						<xsl:with-param name="catName" select="$categoryName" />
					</xsl:apply-templates>
				</xsl:for-each>
			</div>
			<div id="{$categoryName}_new" />
		</div>
	</xsl:template>

	<xsl:template mode="output" match="messenger">
		<xsl:param name="catName" />
		<xsl:for-each select="messenger_url">
			<xsl:variable name="count" select="position()" />
			<div id="{$catName}_{$count}">
				<div class="networkinformation-value">
					<xsl:value-of select="*[1]" />
					:
					<xsl:value-of select="*[2]" />
				</div>
				<xsl:if test="$can_edit=1">
					<div id="{$catName}_url_Button_{$count}" class="networkinformation-button">
						<a class="book userprofile-delete-link"
							href="javascript:removeSingleInputInstance('{$catName}','{$catName}_url','{$catName}_url{$count}','{$count}')"
							title="Delete">&#160;</a>
					</div>
				</xsl:if>
			</div>
		</xsl:for-each>
	</xsl:template>

	<xsl:template mode="output" match="email">
		<xsl:param name="catName" />
		<xsl:for-each select="*">
			<xsl:variable name="count" select="position()" />
			<div id="{$catName}_{$count}">
				<div class="networkinformation-value">
					<a target="_blank" href="mailto:{.}">
						<xsl:value-of select="normalize-space(.)" />
					</a>
				</div>
				<xsl:if test="$can_edit=1">
					<div id="{$catName}_url_Button_{$count}" class="networkinformation-button">
						<a class="book userprofile-delete-link"
							href="javascript:removeSingleInputInstance('{$catName}','{$catName}_url','{$catName}_url{$count}','{$count}')"
							title="Delete">&#160;</a>
					</div>
				</xsl:if>
			</div>
		</xsl:for-each>
	</xsl:template>
	
	<xsl:template mode="output" match="websites|twitter|facebook|linkedin">
		<xsl:param name="catName" />
		<xsl:for-each select="*">
			<xsl:variable name="count" select="position()" />
			<div id="{$catName}_{$count}">
				<div class="networkinformation-value">
					<xsl:choose>
						<xsl:when test="starts-with(., 'http://')">
							<a target="_blank" href="{.}">
								<xsl:value-of select="normalize-space(.)" />
							</a>
						</xsl:when>
						<xsl:when test="starts-with(., 'https://')">
							<a target="_blank" href="{.}">
								<xsl:value-of select="normalize-space(.)" />
							</a>
						</xsl:when>
						<xsl:otherwise>
							<a target="_blank" href="http://{.}">
								<xsl:value-of select="normalize-space(.)" />
							</a>
						</xsl:otherwise>
					</xsl:choose>					
				</div>
				<xsl:if test="$can_edit=1">
					<div id="{$catName}_url_Button_{$count}" class="networkinformation-button">
						<a class="book userprofile-delete-link"
							href="javascript:removeSingleInputInstance('{$catName}','{$catName}_url','{$catName}_url{$count}','{$count}')"
							title="Delete">&#160;</a>
					</div>
				</xsl:if>
			</div>
		</xsl:for-each>
	</xsl:template>

	<xsl:template mode="output" match="*">
		<xsl:param name="catName" />
		<xsl:for-each select="*">
			<xsl:variable name="count" select="position()" />
			<div id="{$catName}_{$count}">
				<div class="networkinformation-value">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				</div>
				<xsl:if test="$can_edit=1">
					<div id="{$catName}_url_Button_{$count}" class="networkinformation-button">
						<a class="book userprofile-delete-link"
							href="javascript:removeSingleInputInstance('{$catName}','{$catName}_url','{$catName}_url{$count}','{$count}')"
							title="Delete">&#160;</a>
					</div>
				</xsl:if>
			</div>
		</xsl:for-each>
	</xsl:template>
	
	<xsl:template name="listOfCategory">
		<input type="hidden" id="webinfoList" value="{$displayField}" />
	</xsl:template>

	<xsl:template name="webinfo_button">
		<div id="webinfo_button" class="networkinformation-webinfobutton" />
		<div id="webinfo_input" class="networkinformation-webinforpadding" />
	</xsl:template>

	<xsl:include href="network_info_template.xsl" />

</xsl:stylesheet>
