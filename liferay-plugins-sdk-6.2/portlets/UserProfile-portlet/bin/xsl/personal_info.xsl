<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="java">
	<xsl:output method="html" indent="yes" encoding="UTF-8"/>
	<xsl:param name="can_edit"/>
	<xsl:param name="form_edit"/>
	<xsl:param name="communityName" />
	<xsl:param name="resource" />
	<xsl:param name="displayField"/>
	<xsl:param name="publicField"/>
	<xsl:param name="currentURL" />
	<xsl:param name="locationValues" />
	<!--========================================================================================================================-->
	<xsl:template match="profile">
			<head>
				<title></title>
				<!-- Event source file -->
				<script><![CDATA[ 
					AUI().ready(
					'panel',
					'anim',
					function(A) {
						var profileContainer = new A.Panel(
								{
									collapsible: true,
									//collapsed: true,
									headerContent: '<font class="header-pretitle">My Profile<span class="header-posttitle"> Information</span></font>',
									boundingBox: '#personalInfo > .aui-panel-content',
									contentBox:'#personalInfo'
								}
							).render();
						
					});
					
					window.onload = function() {
						renderCalendarSingleInput('personalinfo');
					};//end window onload
					
					AUI().ready(function(A) { 
						
						var sectionDiv = A.all('.personalinfo-textedit');
						
						sectionDiv.each(function() {
							var currentNode = this;
							var sectionName = currentNode.attr('sectionDiv');
							if(sectionName == "about"){
								new Edittable(sectionName, 1000); //change to label display
							}else{
								new Edittable(sectionName, 20); //change to label display
							}
							var section = A.one('#' + sectionName + '_text');
							
							if(section){
								section.on(['mouseout', 'mouseover', 'click'], function(event){
									if (event.type == "mouseover"){ 
								    	section.addClass("single-input-focus");
								    }else if(event.type == "mouseout"){
						           		section.removeClass("single-input-focus");
						           	}else if(event.type == "click"){
						           		editThis(this.attr('id')); // make the label edittable
						           	}
								});//end section.on
							}
							
							
						});
						
						var personalInfoDiv = A.all('.personal-info');
						
						if(personalInfoDiv){
							personalInfoDiv.each(function() {
								var sDiv = this;
								var fieldName = sDiv.attr('id');
								
								sDiv.on(['keypress','blur'], function(event){
									if(event.type == "blur"){
										if(fieldName == "about_input"){
										saveSingleInput(sDiv.attr('id'), 'personal_info', 1000);
										}else{
					           			saveSingleInput(sDiv.attr('id'), 'personal_info', 20);
					           			}
					           		}if(event.type == "keypress"){
					           			if (event.keyCode == 13){ 
								    		if(fieldName == "about_input"){
										saveSingleInput(sDiv.attr('id'), 'personal_info', 1000);
										}else{
					           			saveSingleInput(sDiv.attr('id'), 'personal_info', 20);
					           			}
								    	} 
					           		}
								});
							});
						}
						
					});
				
				]]>
				</script>
			</head>
			<body style="width:100%">
				<div id="personalInfo">
				<div class="showdowheader-profile"></div>
					<div class="yui3-widget-bd">
						<xsl:for-each select="personal_info/*">
							<xsl:choose>
								<xsl:when test="$can_edit=0">
									<xsl:if test="(contains(concat(',',$publicField,','),concat(',',name(),',')))"><!-- allow fields to view on public -->
										<xsl:call-template name="GetPersonalInfo"/>
									</xsl:if>
								</xsl:when>
								<xsl:when test="$can_edit=2">
									<xsl:if test="(contains(concat(',',$publicField,','),concat(',',name(),',')))"><!-- allow fields to view on public -->
										<xsl:call-template name="GetPersonalInfo"/>
									</xsl:if>
								</xsl:when>
								<xsl:otherwise>
									<xsl:call-template name="GetPersonalInfo"/>
								</xsl:otherwise>
							</xsl:choose>
						</xsl:for-each>
					</div>
				</div>
			</body>
		</xsl:template>
	<!--========================================================================================================================-->
	<xsl:template mode="TypeId" match="location">3</xsl:template>
	<xsl:template mode="TypeId" match="about|training_education|skills_qualification">2</xsl:template>
	<xsl:template mode="TypeId" match="*">1</xsl:template>
	<xsl:template mode="showField" match="about">
	 <div id="cke_{name()}_container">
			<div class="save_button">
				<a href="#" onclick="javascript:saveCKEditor(this.id,'personal_info');return false;" section_name="{name()}"  class="update-button" id="{name()}_submit_button">&#160;</a>
			</div>
			<div class="undo_button">
				<a href="#" onclick="javascript:cancelCKEditor(this.id);return false;" section_name="{name()}"  class="undo-button" id="{name()}_cancel_button">&#160;</a>
			</div>
			<div class="ckeditor_alignRight">
				<textarea section_name="{name()}" id="{name()}_input" rows="5" cols="40" class="personal_info_textarea" name="ckeditor"  >
				<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
				<xsl:attribute name="editorType"><xsl:apply-templates mode="editorType" select="."/></xsl:attribute>
				<xsl:value-of select="normalize-space(.)"/>
				</textarea>
			</div>
		</div> 
		<!-- <textarea section_name="{name()}" id="{name()}_input" rows="5" cols="40" class="single-input personal-info personal-info-textarea" name="textarea"  >
			<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
			<xsl:attribute name="editorType"><xsl:apply-templates mode="editorType" select="."/></xsl:attribute>
			<xsl:value-of select="normalize-space(.)"/>
		</textarea> -->
	</xsl:template>
	
	<xsl:template mode="showField" match="training_education|skills_qualification|interest">
	
		<textarea section_name="{name()}" id="{name()}_input" rows="5" cols="40" class="single-input personal-info personal-info-textarea" name="textarea"  >
			<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
			<xsl:attribute name="editorType"><xsl:apply-templates mode="editorType" select="."/></xsl:attribute>
			<xsl:value-of select="normalize-space(.)"/>
		</textarea>
	</xsl:template>
	
		
	<xsl:template mode="showField" match="screen_name">
		<span class="hosturl"><xsl:value-of select="$currentURL"/></span>
		<span class="input_screenname">
			<input style="vertical-align:middle; width: 150px;" section_name="{name()}" id="{name()}_input" type="text" value="{.}" class="single-input personal-info" >
				<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
				<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
				<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
			</input>
		</span>
	</xsl:template>
	<xsl:template mode="showField" match="location">
		<input section_name="{name()}" id="{name()}_input" type="text" value="{.}" class="single-input personal-info" tooltip="" onfocus="javascript:CallAutoComplete('{name()}_input','getLocation')">
			<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
			<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
			<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
			<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
		</input>
	</xsl:template>
	<xsl:template mode="showField" match="area_of_expertise">
		<input section_name="{name()}" id="{name()}_input" type="text" value="{.}" class="single-input personal-info" tooltip="" onfocus="javascript:CallAutoComplete('{name()}_input', 'getAreaExpertise')">
			<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
			<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
			<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
			<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
		</input>
	</xsl:template>
	<xsl:template mode="showField" match="*">
		<input section_name="{name()}" id="{name()}_input" type="text" value="{.}" class="single-input personal-info" tooltip="">
			<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
			<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
			<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
			<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
		</input>
	</xsl:template>
	
	<!--1: decimal, 2:alpha-numeric, 3:url, 4:phone, 5:email, 6: letters, 7: integers -->
	<!-- <xsl:template mode="ValidationKey" match="screen_name">3</xsl:template> -->
	<xsl:template mode="ValidationKey" match="years_of_experience">7</xsl:template>
	<xsl:template mode="ValidationKey" match="*">0</xsl:template>
	<xsl:template mode="Mandatory" match="screen_name">true</xsl:template>
	<xsl:template mode="Mandatory" match="*">false</xsl:template>
	<xsl:template mode="MaxLength" match="title">100</xsl:template>
	<xsl:template mode="MaxLength" match="screen_name|location">75</xsl:template>
	<xsl:template mode="MaxLength" match="years_of_experience">2</xsl:template>
	<xsl:template mode="MaxLength" match="*">2500</xsl:template>
	<xsl:template mode="editorType" match="about">CKEditor</xsl:template>
	<xsl:template mode="Size" match="*">47</xsl:template>
	<!--========================================================================================================================-->
	<xsl:template name="GetPersonalInfo">
	<xsl:param name="head"></xsl:param>
		<xsl:if test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
		<div class="maindivpersonalInfo" id="maindivPersonalInfo">
			<div class = "content-title">
				<xsl:choose>
						<xsl:when test="@fieldType != ''">
							<xsl:call-template name="Pascalize">
								<xsl:with-param name="pText" select="@label"/>
							</xsl:call-template>
							<xsl:if test="@mandatory='true'">*</xsl:if>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="java:getString($resource,concat($communityName,'.userprofile.personalinfo.',name(),'.label'))"/>
						</xsl:otherwise>
				</xsl:choose>
				<div class="seperatedline"></div>
			</div>
			<xsl:choose>
				<xsl:when test="($can_edit=0) or ($can_edit=2)">
					<div style="padding-left:8px;text-align: justify;" class="single-input">
						<xsl:choose>
							<xsl:when test="(name() = 'screen_name')">	
								<xsl:variable name="screenName" select="." />
								<a target="_blank" href="{$currentURL}{$screenName}">
									<xsl:value-of select="$currentURL"/><xsl:value-of select="." disable-output-escaping="yes" />
								</a>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes" />
							</xsl:otherwise>
						</xsl:choose>
					</div>
				</xsl:when>
				<xsl:otherwise>
					<div class="userpersonaldetails-value-full-width">
						<div class="userpersonaldetails-value-Leftfull-width personalinfo-textedit" id="{name()}_container" sectionDiv="{name()}">
							<xsl:choose>
								<xsl:when test="@fieldType != ''">
									<xsl:apply-templates mode="showAdditionalField" select="." >
										<xsl:with-param name="categoryName" select="'personal_info'" />
									</xsl:apply-templates>
								</xsl:when>
								<xsl:otherwise>
									<xsl:apply-templates mode="showField" select="." />
								</xsl:otherwise>
							</xsl:choose>
						</div>
						<div id="{name()}_iconstatus" class="msg_tooltip"/>
					</div>
					<xsl:variable name="function_name" select="'Update'"/>
			 		 
				</xsl:otherwise>
			</xsl:choose>
		</div>
		</xsl:if>
	</xsl:template>
	<!--========================================================================================================================-->
	
	<xsl:template name="output-tokens">
      <xsl:param name="list"/>
      <xsl:choose>
      <xsl:when test="$list = ''">
      </xsl:when>
      <xsl:when test="contains($list, ',')=false()">
         <option value="{$list}"><xsl:value-of select="$list"/></option>
      </xsl:when>
      <xsl:otherwise>
         <xsl:variable name="head" select="substring-before($list, ',')"/>
         <xsl:variable name="tail" select="substring-after($list, ',')"/> 
				<xsl:call-template name="GetPersonalInfo">
				<xsl:with-param name="head" select="$head"/>
				<xsl:with-param name="headValue" select="."/>
				</xsl:call-template>	
         <xsl:call-template name="output-tokens">
         <xsl:with-param name="list" select="$tail"/>
         </xsl:call-template>
      </xsl:otherwise>
      </xsl:choose>
   </xsl:template>
   
   <xsl:include href="personal_info_template.xsl"/>
</xsl:stylesheet>
