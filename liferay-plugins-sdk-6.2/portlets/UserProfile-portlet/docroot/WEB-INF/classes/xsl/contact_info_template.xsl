<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  
xmlns:java="java" 
xmlns:sputil="com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil">

<xsl:param name="scopeGroupId"/>

	<xsl:template mode="showContactInfoField" match="*">
		<xsl:param name="fieldName" />
		<xsl:param name="position" />
			<xsl:choose>
				<xsl:when test="@fieldType = 'TextArea'">
					<xsl:call-template name="showContactTextArea">
						<xsl:with-param name="position" select="$position"/>
						<xsl:with-param name="fieldName" select="$fieldName"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="@fieldType = 'CKEditor'">
					<xsl:call-template name="showContactCKEditor">
						<xsl:with-param name="position" select="$position"/>
						<xsl:with-param name="fieldName" select="$fieldName"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="@fieldType = 'Dropdown'">
					<xsl:call-template name="showDropdown">
					<xsl:with-param name="position" select="$position"/>
					<xsl:with-param name="fieldName" select="$fieldName"/>
					<xsl:with-param name="mandatory" select="@mandatory"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="@fieldType = 'MultipleList'">
					<xsl:call-template name="showMultipleList">
					<xsl:with-param name="position" select="$position"/>
					<xsl:with-param name="fieldName" select="$fieldName"/>
					<xsl:with-param name="mandatory" select="@mandatory"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="@fieldType = 'Calendar'">
					<xsl:call-template name="showContactCalendar">
					<xsl:with-param name="position" select="$position"/>
					<xsl:with-param name="fieldName" select="$fieldName"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="@fieldType = 'Radio'">
					<xsl:call-template name="showContactRadio">
						<xsl:with-param name="position" select="$position"/>
						<xsl:with-param name="fieldName" select="$fieldName"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise><!-- TextField default-->
					<xsl:call-template name="showContactTextField">
						<xsl:with-param name="position" select="$position"/>
						<xsl:with-param name="fieldName" select="$fieldName"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
	</xsl:template>
	<xsl:template name="showContactTextArea">
		<xsl:param name="position" />
		<xsl:param name="fieldName" />
		<div class="userjobdetails-input-right-align">
			<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{$fieldName}_{$position}" id="{$fieldName}_{$position}" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
				<textarea maxlength="40" section_name="{$fieldName}_{$position}"
					name="{$fieldName}" id="{$fieldName}_{$position}"
					class="multiple-input tooltip">
					<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
					<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
					<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
					<xsl:attribute name="size"><xsl:apply-templates
						mode="Size" select="." /></xsl:attribute>
					<xsl:value-of select="normalize-space(.)"
						disable-output-escaping="yes" />
				</textarea>
				<div id="{$fieldName}_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
				</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>
	<xsl:template name="showContactTextField">
		<xsl:param name="position" />
		<xsl:param name="fieldName" />
		<div class="userjobdetails-input-right-align">
			<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{$fieldName}_{$position}" id="{$fieldName}_{$position}" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
					<input type="text" maxlength="40" section_name="{$fieldName}_{$position}"
						value="{.}" name="{$fieldName}" id="{$fieldName}_{$position}" class="multiple-input tooltip">
						<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
						<xsl:attribute name="size"><xsl:apply-templates
							mode="Size" select="." /></xsl:attribute>
					</input>
					<div id="{$fieldName}_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
				</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>
	<xsl:template name="showContactCKEditor">
		<xsl:param name="position" />
		<xsl:param name="fieldName" />
		<div class="ckeditor_alignRight">
			<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{$fieldName}_{$position}" id="{$fieldName}_{$position}" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
					<textarea maxlength="40" section_name="{$fieldName}_{$position}"
						name="{$fieldName}" id="{$fieldName}_{$position}"
						class="ckeditor-textarea-contact_info multiple-input tooltip" editorType="ckeditor">
						<!-- <xsl:value-of select="normalize-space(.)"
							disable-output-escaping="yes" /> -->
						<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
						<xsl:attribute name="editorType">CKEditor</xsl:attribute>
						<xsl:value-of select="normalize-space(.)"/>
					</textarea>
					<div id="{$fieldName}_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
				</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>
	<xsl:template name="showContactRadio">
		<xsl:param name="position" />
		<xsl:param name="fieldName" />
		<xsl:variable name="mandatory" select="@mandatory"/>
		<xsl:variable name="validation_key" select="@validation_key"/>
		<xsl:variable name="fieldValue" select="."/>
		<xsl:variable name="optionId" select="@optionId"/>
		<div class="userjobdetails-input-right-align">
			<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{$fieldName}_{$position}" id="{$fieldName}_{$position}" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="sputil:getRadioFields($optionId,$fieldName,$position,$fieldValue,$mandatory,$validation_key,$scopeGroupId)" disable-output-escaping="yes"/>
					<div id="{$fieldName}_{$position}_iconstatus" style="display:inline;"
						class="msg_tooltip" />
				</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>
	
	<xsl:template name="showDropdown">
		<xsl:param name="position" />
		<xsl:param name="fieldName"/>
		<xsl:param name="mandatory"/>
		<xsl:variable name="optionId" select="@optionId"/>
		<xsl:variable name="level" select="@level"/>
		<xsl:variable name="fieldValue" select="."/>
		<div class="userjobdetails-input-right-align">
			<xsl:value-of select="sputil:getSelectOptionList($optionId,$fieldName,$position,$fieldValue,'contact_info',$mandatory,$scopeGroupId,$level)" disable-output-escaping="yes"/>
				<div id="{$fieldName}_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
		</div>
    </xsl:template>
    
    <xsl:template name="showMultipleList">
		<xsl:param name="position" />
		<xsl:param name="fieldName"/>
		<xsl:param name="mandatory"/>
		<xsl:variable name="optionId" select="@optionId"/>
		<xsl:variable name="fieldValue" select="."/>
		<div class="userjobdetails-input-right-align">
			<xsl:value-of select="sputil:getSelectMultipleList($optionId,$fieldName,$position,$fieldValue,'contact_info',$mandatory,$scopeGroupId)" disable-output-escaping="yes"/>
				<div id="{$fieldName}_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
		</div>
    </xsl:template>
    
    <xsl:template name="showContactCalendar">
		<xsl:param name="position" />
		<xsl:param name="fieldName" />
		<xsl:variable name="fieldValue" select="."/>
		<div class="userjobdetails-input-right-align">
			<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{$fieldName}_{$position}" id="{$fieldName}_{$position}" value="."/>
				</xsl:when>
				<xsl:otherwise>
					<input type="hidden" id="{$fieldName}_{$position}" value="{.}" section_name="{$fieldName}_{$position}" class="text_calendar_contact_info" name="auicalendar">
						<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
						<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="." /></xsl:attribute>
					</input>
					<div id="{$fieldName}_{$position}_cal" />
					<div id="{$fieldName}_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
				</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>
    
	<xsl:include href="dynamic_fields_template.xsl"/>
</xsl:stylesheet>
