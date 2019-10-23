<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  
	xmlns:aui="http://liferay.com/tld/aui"
	xmlns:java="java" 
	xmlns:sputil="com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil">
<xsl:output method="html" indent="yes" encoding="UTF-8"/>
<xsl:param name="saveData"/>
<xsl:param name="can_edit"/>
<xsl:param name="communityName"/>
<xsl:param name="resource" />
<xsl:param name="displayField"/>
<xsl:param name="defaultBillingId"/>
<xsl:param name="defaultShippingId"/>
<xsl:param name="publicField"/>
<xsl:param name="section_name"/>
<xsl:param name="form_name"/>
	<xsl:template match="/">
	<head>
	<script>
		AUI().ready(
		'aui-panel',
		'anim',
		function(A) {
			var availabilityStatus = new A.Panel(
					{
						collapsible: true,
						headerContent: '<font class="header-pretitle"><xsl:value-of select="$form_name" disable-output-escaping="yes"/></font>',
						boundingBox: '#<xsl:value-of select="$section_name"/> > .aui-panel-content',
						contentBox:'#<xsl:value-of select="$section_name"/>'
					}
				).render();
			
		}	);
		</script>
	</head>
	<body style="width:100%">
		<div id="{$section_name}" style="border-style: none; width: 100%;">
			<div class="showdowheader-profile"></div>
			<div align="right" class="sp-mts postal-code-display">** <a id="checkPostalCodeLink" href="#" onclick="javascript:checkPostalCodeLinkOnClick(event);" class="sp-fcb">Click here to check your Postal Code</a></div>
			<xsl:apply-templates select="profile/other_details" />
		</div>
	</body>
	</xsl:template>
	
	<xsl:template match="profile/other_details">
		<div class="yui3-widget-bd">
			<xsl:call-template name="availability_info_button">
				<xsl:with-param name="saveData" select="$saveData"/>
			</xsl:call-template>
			
			<div id="{$section_name}_details" class="aui-helper-clearfix">
			<xsl:for-each select="*">
				<xsl:if test="$section_name = name()"> <!-- selected xsl should match the node -->
					<xsl:for-each select="*"><!-- start read details child nodes  -->
						
						<xsl:variable name="count"><xsl:value-of select="@id" /></xsl:variable><!-- detail node attr ID -->
						<xsl:variable name="pst" select="position()" />
						<div id="{$section_name}_{$count}" class="aui-helper-clearfix">
								<div class="{$section_name}_editAlign dynamic-section-button-align" id="{$section_name}_button_{$count}" instance="{$count}" Name="{$section_name}_editAlign">
									<xsl:if test="$can_edit=1">
										<a class="book userprofile-edit-link" href="javascript:editDetails('{$section_name}','{$count}','{$displayField}')" title="Edit">&#160;</a>
										<a class="book userprofile-delete-link" href="javascript:removeGroupInput('{$section_name}','{$section_name}_details','{$count}','{$displayField}')" title="Delete">&#160;</a>
									</xsl:if>
								</div>	
								<div id="Address_{$pst}" class="address_title">Address <xsl:value-of select="$pst" /></div>
								<xsl:for-each select="*">
									<xsl:if test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
										<xsl:choose>
											<xsl:when test="$can_edit=0"><!-- public view -->
												<xsl:if test="(contains(concat(',',$publicField,','),concat(',',name(),',')))">
													<xsl:apply-templates mode="output" select="." >
														<xsl:with-param name="count" select="$count"/>
														<xsl:with-param name="pst" select="$pst" />
													</xsl:apply-templates>
												</xsl:if>
											</xsl:when>
											<xsl:when test="$can_edit=2"><!-- public view -->
												<xsl:if test="(contains(concat(',',$publicField,','),concat(',',name(),',')))">
													<xsl:apply-templates mode="output" select="." >
														<xsl:with-param name="count" select="$count"/>
														<xsl:with-param name="pst" select="$pst" />
													</xsl:apply-templates>
												</xsl:if>
											</xsl:when>
											<xsl:otherwise>
												<xsl:apply-templates mode="output" select="." >
													<xsl:with-param name="count" select="$count"/>
													<xsl:with-param name="pst" select="$pst" />
												</xsl:apply-templates>
											</xsl:otherwise>
										</xsl:choose>
									</xsl:if>
								</xsl:for-each>
						</div>
						<div id="{$section_name}_edit_{$count}" class="aui-helper-clearfix workhistory_bottomgap"/>
						
					</xsl:for-each><!-- end read details -->
				</xsl:if>
			</xsl:for-each>
			</div>
		</div>
	</xsl:template>	
	<xsl:template mode="output" match="*">
		<xsl:param name="count"/>
		<xsl:param name="pst"/>
		<xsl:variable name="pTextName" select="name()">
			<!-- <xsl:call-template name="getLabel">
				<xsl:with-param name="elements-list" select="$displayField" />
			</xsl:call-template> -->
		</xsl:variable>
		<xsl:variable name="pTextName1" select="name()">
		</xsl:variable>
		<div class="content-title">
			<xsl:call-template name="Pascalize">
				<xsl:with-param name="pText" select="@label" />
			</xsl:call-template>
			<xsl:if test="@mandatory='true'">*</xsl:if>
			<div class="seperatedline"></div>
		</div>
		<div class="availability-horizontalspacing" id="{$pTextName}_info_{$pst}" name="{$pTextName}">
			<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes" />
		</div>
	</xsl:template>
	
	<xsl:template name="availability_info_button">
		<xsl:param name="saveData"/>
		<input type="hidden" id="{$section_name}_infoList" value="{$displayField}" />
		<xsl:if test="$can_edit=1">
			<div style="{$saveData}">
				<div class="workhistory-savedata"  id="{$section_name}_add">
					<a class="book userprofile-add-link" href="javascript:addWorkHistoryInfo('{$section_name}','{$section_name}_details','addMultipleInput','{$displayField}');"  title="Add">&#160;</a>
				</div>
				<div id="{$section_name}_button" class="workhistory-savedatabutton"/>
				<div id="{$section_name}_iconstatus" class="msg_tooltip"/>
				<div id="{$section_name}_status"/>
			</div>
		</xsl:if>
	</xsl:template>
	 <xsl:include href="dynamic_fields_template.xsl"/>
</xsl:stylesheet>
