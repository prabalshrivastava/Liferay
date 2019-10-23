<?xml version="1.0" ?>
<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  
	xmlns:aui="http://liferay.com/tld/aui"
	xmlns:java="java" 
	xmlns:sputil="com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil">
	<xsl:param name="instance"/>
	<xsl:param name="communityName"/>
	<xsl:param name="resource" />
	<xsl:param name="displayField" />
	<xsl:param name="category_details" />
	<xsl:param name="section_name" />
	
	<xsl:template match="/">
		<div id="availability" class="aui-helper-clearfix">
			<xsl:apply-templates select="*" />
		</div>	
	</xsl:template>
	<xsl:template match="*">
			<div id="{$section_name}_{$instance}">
			<div>
				<div id="{$section_name}_button_{$instance}" class="{$section_name}-savedatabutton sp-mbm aui-helper-clearfix">
					<div id="{$section_name}Save" class="available-saveinfo">
						<a style="float:right" title="save" id="{$section_name}_save" class="book update-button" href="javascript:saveInfo('{$section_name}', '{$instance}','{$section_name}_infoList','{$displayField}')">&#160;</a>
					</div>
					<div class="available_undo">
						<a title="cancel" id="{$section_name}_cancel" class="book undo-button" href="javascript:cancelInfo('{$section_name}', '{$instance}','{$section_name}_infoList','{$displayField}')">&#160;</a>
					</div>
				</div>
				<div id="{$section_name}_{$instance}_iconstatus" class="msg_tooltip"/>
				<div id="{$section_name}_{$instance}_status"/>
			</div>
			<div>
				<xsl:call-template name="removeAvailabilityDetails" />
				<xsl:for-each select="*">
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
		</div>
	</xsl:template>
	
	<!-- Validation templates -->
	<!--1: integer, 2:alpha-numeric, 3:url, 4:phone, 5:email, 6: letters -->
	<xsl:template mode="ValidationKey" match="*">0</xsl:template>
	<xsl:template mode="Mandatory" match="*">false</xsl:template>
	<xsl:template mode="MaxLength" match="*">75</xsl:template>
	<xsl:template mode="Size" match="*">47</xsl:template>
	
	 <xsl:template mode="showField" match="*">
		<xsl:param name="position" />
		<div class="userjobdetails-input-left-align">
			<div class="content-title">
				<xsl:call-template name="Pascalize">
					<xsl:with-param name="pText" select="@label" />
				</xsl:call-template>
				<xsl:if test="@mandatory='true'">*</xsl:if>
			</div>
		</div>
		<div class="userjobdetails-input-right-align">
			 <xsl:choose>
				<xsl:when test="name() = 'postal_code_4'">
					<input type="text" value="{.}" name="{name()}_{$position}" id="{name()}_{$position}" class="multiple-input tooltip" onBlur="javascript:validatePostalCode('{name()}_{$position}')">
						<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
						<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
					</input>
				</xsl:when>
				<xsl:otherwise>
					<input type="text" value="{.}" name="{name()}_{$position}" id="{name()}_{$position}" class="multiple-input tooltip">
						<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
						<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
					</input>
				</xsl:otherwise>
			</xsl:choose> 
			
			<div id="{name()}_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
		</div>	
	</xsl:template>
	
	<xsl:template name = "removeAvailabilityDetails">
		
	</xsl:template>
	<xsl:include href="dynamic_section_template.xsl" />
</xsl:stylesheet>
