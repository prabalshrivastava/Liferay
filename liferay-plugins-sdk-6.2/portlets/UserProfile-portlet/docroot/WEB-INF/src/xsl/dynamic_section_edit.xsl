<?xml version="1.0" ?>
<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  
	xmlns:aui="http://liferay.com/tld/aui"
	xmlns:java="java" 
	xmlns:sputil="com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil">
	<xsl:param name="instance"/>
	<xsl:param name="displayField" />
	<xsl:param name="communityName"/>
	<xsl:param name="resource" />
	<xsl:param name="section_name" />
	
	<xsl:template match="/">
		<div id="availability">
			<xsl:call-template name="removeDynamicSectionDetails" />
			<xsl:apply-templates select="profile/other_details" />
		</div>	
	</xsl:template>
	
	<xsl:template match="profile/other_details">
		<xsl:for-each select="*">
			<xsl:if test="$section_name = name()"> <!-- selected xsl should match the node -->
				<xsl:for-each select="*"><!-- start read details child nodes  -->
					<xsl:if test="@id = $instance">	
					<div>
						<div id="{$section_name}_button_{$instance}" class="{$section_name}-savedatabutton">
							<div id="{$section_name}Save" class="available-saveinfo">
								<a style="float:right;" title="save" id="{$section_name}_save" class="book update-button" href="javascript:saveInfo('{$section_name}', '{$instance}','{$section_name}_infoList','{$displayField}')">&#160;</a>
							</div>
							<div class="available_undo">
								<a title="cancel" id="{$section_name}_cancel" class="book undo-button" href="javascript:cancelInfo('{$section_name}', '{$instance}','{$section_name}_infoList','{$displayField}')">&#160;</a>
							</div>	
						</div>
						<div id="{$section_name}_{$instance}_iconstatus" class="msg_tooltip"/>
						<div id="{$section_name}_{$instance}_status"/>
					</div>	
					<div>
						<xsl:for-each select="child::*">
							<xsl:variable name="fieldName" select="name()" />
							<xsl:if
								test="(contains(concat(',',$displayField,','),concat(',',$fieldName,',')))">
								<div class="userjobdetails-input-height">
									<xsl:choose>
										<xsl:when test="@fieldType != ''">
											<xsl:apply-templates mode="showAvailabilityField" select=".">
												<xsl:with-param name="position" select="$instance" />
											</xsl:apply-templates>
										</xsl:when>
										<xsl:otherwise>
											<xsl:apply-templates mode="showField" select=".">
												<xsl:with-param name="position" select="$instance" />
											</xsl:apply-templates>
										</xsl:otherwise>
									</xsl:choose>
								</div>
							</xsl:if>
						</xsl:for-each>
					</div>
				</xsl:if>
					
				
				</xsl:for-each>
			</xsl:if>
		</xsl:for-each>
	
			
	</xsl:template>
		
	 <xsl:template mode="showField" match="*">
		<xsl:param name="position" />
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:call-template name="Pascalize">
					<xsl:with-param name="pText" select="@label" />
				</xsl:call-template>
				<xsl:if test="@mandatory='true'">*</xsl:if>
			</span>	
		</div>
		<div class="userjobdetails-input-right-align">
			<input type="text" maxlength="40" value="{.}" name="{name()}_{$position}" id="{name()}_{$position}" class="multiple-input tooltip">
				<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
				<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
				<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
			</input>
			<div id="{name()}_{$position}_iconstatus" class="msg_tooltip" />
		</div>	
	</xsl:template>
	
	<xsl:template name = "removeDynamicSectionDetails">

	</xsl:template>
	<xsl:include href="dynamic_section_template.xsl" />
	
	<!-- Validation templates -->
	<!--1: integer, 2:alpha-numeric, 3:url, 4:phone, 5:email, 6: letters -->
	<xsl:template mode="ValidationKey" match="*">0</xsl:template>
	<xsl:template mode="Mandatory" match="*">false</xsl:template>
	<xsl:template mode="MaxLength" match="*">75</xsl:template>
	<xsl:template mode="Size" match="*">47</xsl:template>
</xsl:stylesheet>
