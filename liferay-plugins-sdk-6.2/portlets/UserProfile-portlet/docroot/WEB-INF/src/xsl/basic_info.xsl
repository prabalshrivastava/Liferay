<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  
	xmlns:aui="http://liferay.com/tld/aui"
	xmlns:java="java" 
	xmlns:sputil="com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil">
	<xsl:output method="html" indent="yes" encoding="UTF-8"/>
  	
	<xsl:output method="html" indent="yes"/>
	<xsl:param name="can_edit"/>
	<xsl:param name="form_edit"/>
	<xsl:param name="communityName" />
	<xsl:param name="resource" />
	<xsl:param name="currentURL" />
	<xsl:param name="displayField"/>
	<xsl:param name="publicField"/>
	<xsl:param name="isMentor"/>
	<xsl:param name="mentorUser"/>
	<!--========================================================================================================================-->
	<xsl:template match="profile">
	
			<head>
				<script><![CDATA[
				
					AUI().ready(
					'panel',
					'anim',
					function(A) {
						var profileContainer = new A.Panel(
								{
									collapsible: true,
									//collapsed: true,
									headerContent: '<font class="header-pretitle">Basic<span class="header-posttitle"> Information</span></font>',
									boundingBox: '#basicInfo > .panel-content',
									contentBox:'#basicInfo'
								}
							).render();
						
					});
					
					initDateFields();
					
					function initDateFields() {
	
						// for date fields
						AUI().use('aui-datepicker-deprecated', function(A) {
							var inp = '#date_of_birth_input';
							
							var dp = new A.DatePicker({
								container: inp,
						        on : {
										click : function (ev) {
											saveSingleInput('date_of_birth_input', 'basic_info', 20);
										}
										
									},
								trigger: inp
						      });
							dp.render('#startDatePicker');
							
						});
					}
					
					
					AUI().ready(function(A) {  
						var sectionDiv = A.all('.basicinfo-textedit');
						
						sectionDiv.each(function() {
							var currentNode = this;
							var sectionName = currentNode.attr('sectionDiv');
							
							new Edittable(sectionName, 20); //change to label display
							
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
						
						var basicInfoDiv = A.all('.basic-info');
						if(basicInfoDiv){
							basicInfoDiv.each(function() {
								var sDiv = this;
								sDiv.on(['keypress','blur'], function(event){
									if(event.type == "blur"){
					           			saveSingleInput(sDiv.attr('id'), 'basic_info', 20);
					           		}else if(event.type == "keypress"){
					           			if (event.keyCode == 13){ 
								    		saveSingleInput(sDiv.attr('id'), 'basic_info', 20);
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
				<div id="basicInfo">
				<input type="hidden" value="{$communityName}"></input>
				<div class="showdowheader-profile"></div>
					
					<div class="yui3-widget-bd otherBasicInfo">
						<xsl:for-each select="basic_info/*">
							<xsl:choose>
								<xsl:when test="$can_edit=0 or $can_edit=2">
									<xsl:if test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
										<xsl:if test="(contains(concat(',',$publicField,','),concat(',',name(),',')))"><!-- allow fields to view on public -->
											<xsl:if test="name()!='first_name' and name()!='last_name'">
												<xsl:call-template name="GetBasicInfoReadOnly" />
											</xsl:if>
										</xsl:if>
									</xsl:if>
								</xsl:when>
								<xsl:otherwise>
									<xsl:if test="name()!='first_name' and name()!='last_name'">
										<xsl:call-template name="GetBasicInfo" />
									</xsl:if>
								</xsl:otherwise>
							</xsl:choose>
						</xsl:for-each>
					</div>
					
					
					<div class="yui3-widget-bd nameBasicInfo">
						<xsl:for-each select="basic_info/*">
							<xsl:choose>
								<xsl:when test="$can_edit=0 or $can_edit=2">
									<xsl:if test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
										<xsl:if test="(contains(concat(',',$publicField,','),concat(',',name(),',')))"><!-- allow fields to view on public -->
											<xsl:if test="name()='first_name' or name()='last_name'">
												<xsl:call-template name="GetBasicInfoReadOnly" />
											</xsl:if>	
										</xsl:if>
									</xsl:if>
								</xsl:when>
								<xsl:otherwise>
									<xsl:if test="name()='first_name' or name()='last_name'">
										<xsl:call-template name="GetBasicInfo" />
									</xsl:if>	
								</xsl:otherwise>
							</xsl:choose>
						</xsl:for-each>
					</div>
				</div>
				<!-- 
					<xsl:if test="$isMentor=1">
					<div class="yui3-widget-bd mentorButton">
						<xsl:call-template name="ShowMentorButton" />
						</div>
					</xsl:if>
				 -->
			</body>
		</xsl:template>
		
		<xsl:template name="GetBasicInfoReadOnly">
			<!--<xsl:choose>
				 <xsl:when test="name()='first_name'">
					<div class = "content-title" style="margin-top:13px;">
						<xsl:choose>
							<xsl:when test="@fieldType != ''">
								<xsl:call-template name="Pascalize">
									<xsl:with-param name="pText" select="@label"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="java:getString($resource,concat($communityName,'.userprofile.basicinfo.name.label'))"/>
							</xsl:otherwise>
						</xsl:choose>
						<div class="seperatedline"></div>
					</div>
					<span style="padding-left:8px;">
						<xsl:value-of select="."/>
					</span>
				</xsl:when>
				<xsl:when test="name()='last_name'">
					<span style="padding-left:8px;">
						<xsl:value-of select="."/>
					</span>
				</xsl:when> -->
				<!-- <xsl:otherwise> -->
					<div class = "content-title" style="margin-top:13px;">
						<xsl:choose>
							<xsl:when test="@fieldType != ''">
								<xsl:call-template name="Pascalize">
									<xsl:with-param name="pText" select="@label"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="java:getString($resource,concat($communityName,'.userprofile.basicinfo.',name(),'.label'))"/>
							</xsl:otherwise>
						</xsl:choose>
						<div class="seperatedline"></div>
					</div>
					<div style="padding-left:0px;">
						<xsl:apply-templates mode="readOnlyMode" select="." />
					</div>
				<!-- </xsl:otherwise>
			</xsl:choose> -->
		</xsl:template>
		
		<xsl:template name="ShowMentorButton">
		<div class="mentorApplyButton">
			<div style="margin-bottom:20px">Would you like <b><xsl:value-of select="$mentorUser" disable-output-escaping="yes"/></b> to be your mentor?</div>
			<div><input id="mentorButton" type="button" onClick="sendMentorRequestMail(this.id)" value="Apply"/></div>
		</div>	
		</xsl:template>
		
		<xsl:template name="GetBasicInfo">
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
				<div class="maindivpersonalInfo" id="maindivBasicInfo">
					<xsl:choose>
						<xsl:when test="$can_edit=0">
							<div style="padding-left:0px;">
								<xsl:apply-templates mode="readOnlyMode" select="." />
							</div>
						</xsl:when>
						<xsl:otherwise>
							<div class = "content-title">
								<xsl:choose>
									<xsl:when test="@fieldType != ''">
										<xsl:call-template name="Pascalize">
											<xsl:with-param name="pText" select="@label"/>
										</xsl:call-template>
										<xsl:if test="@mandatory='true'">*</xsl:if>
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="java:getString($resource,concat($communityName,'.userprofile.basicinfo.',name(),'.label'))"/>
									</xsl:otherwise>
								</xsl:choose>
								<div class="seperatedline"></div>
							</div>
							<div class="userpersonaldetails-value-full-width">
								<div class="userpersonaldetails-value-Leftfull-width basicinfo-textedit" id="{name()}_container" sectionDiv="{name()}">
									<xsl:choose>
										<xsl:when test="@fieldType != ''">
											<xsl:apply-templates mode="showAdditionalField" select="." >
												<xsl:with-param name="categoryName" select="'basic_info'" />
											</xsl:apply-templates>
										</xsl:when>
										<xsl:otherwise>
											<xsl:apply-templates mode="showField" select="." />
										</xsl:otherwise>
									</xsl:choose>
								</div>
								<div id="{name()}_iconstatus" class="msg_tooltip"/>
							</div>
						</xsl:otherwise>
					</xsl:choose>
				</div>
			</xsl:if>
		</xsl:template>
		
	<xsl:template mode="readOnlyMode" match="gender">
		<xsl:if test=".='1'">
			<xsl:text>Male</xsl:text> 
		</xsl:if>
		<xsl:if test=".='0'">
			<xsl:text>Female</xsl:text>
		</xsl:if>
	</xsl:template>
	<xsl:template mode="readOnlyMode" match="*">
		<xsl:value-of select="."/>
	</xsl:template>
	<xsl:template mode="showField" match="date_of_birth">
		<div id="startDatePicker" class="datepicker-example helper-clearfix">
			<input name="auicalendar" id="date_of_birth_input" label="{name()}" value="{.}" section_name="{name()}" class="text_calendar_single"/>
		</div>
	<!--<input type="hidden" id="{name()}_inputbbbbb" value="{.}" section_name="{name()}" class="text_calendar_single" name="auicalendarhhhhh">
		<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
			<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
			<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
			<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
		</input>
		 <div id="{name()}_input_cal"/>
		<div id="{name()}_input_iconstatus" class="msg_tooltip"/> -->
	</xsl:template> 

	<xsl:template mode="showField" match="gender">
		<select id="{name()}_input" section_name="{name()}" class="single-input" onchange="saveSelectInput(this.id,'basic_info');" validation_key="0">
			<xsl:if test=".='1'">
				<option value="1" selected="yes">Male</option>
				<option value="0">Female</option>
			</xsl:if>
			<xsl:if test=".='0'">
				<option value="1">Male</option>
				<option value="0" selected="yes">Female</option>
			</xsl:if>
		</select>
	</xsl:template>
	<xsl:template mode="showField" match="*">
		<input section_name="{name()}" id="{name()}_input" type="text" value="{.}" class="single-input basic-info" >
			<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
			<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
			<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
			<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
		</input>
		<input type="hidden" id="{name()}_input_hidden" value="{.}"/>
	</xsl:template>
	<!--1: integer, 2:alpha-numeric, 3:url, 4:phone, 5:email, 6: letters -->
	<xsl:template mode="ValidationKey" match="user_status">2</xsl:template>
	<xsl:template mode="ValidationKey" match="*">0</xsl:template>
	<xsl:template mode="Mandatory" match="first_name|last_name|date_of_birth">true</xsl:template>
	<xsl:template mode="Mandatory" match="*">false</xsl:template>
	<xsl:template mode="MaxLength" match="user_status">2500</xsl:template>
	<xsl:template mode="MaxLength" match="*">75</xsl:template>
	<xsl:template mode="Size" match="*">47</xsl:template>
	
	<xsl:include href="basic_info_template.xsl"/>
</xsl:stylesheet>
