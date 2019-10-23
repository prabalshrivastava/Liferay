<?xml version="1.0" ?>
<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  
	xmlns:aui="http://liferay.com/tld/aui"
	xmlns:java="java" 
	xmlns:sputil="com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil">

<xsl:param name="scopeGroupId"/>
<xsl:param name="section_name"/>

	<xsl:template mode="showAvailabilityField" match="*">
		<xsl:param name="position" />
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:call-template name="Pascalize">
					<xsl:with-param name="pText" select="@label" />
				</xsl:call-template>
				<xsl:if test="@mandatory='true'">*</xsl:if>
			</span>
		</div>
		<xsl:choose>
			<xsl:when test="@fieldType = 'TextArea'">
				<xsl:call-template name="showAvailTextArea">
					<xsl:with-param name="position" select="$position"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'CKEditor'">
				<xsl:call-template name="showAvailCKEditor">
					<xsl:with-param name="position" select="$position"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'Radio'">
				<xsl:call-template name="showAvailRadio">
					<xsl:with-param name="position" select="$position"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'Calendar'">
				<xsl:call-template name="showAvailCalendar">
					<xsl:with-param name="position" select="$position"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'Dropdown'">
				<xsl:call-template name="showDropdown">
					<xsl:with-param name="position" select="$position"/>
					<xsl:with-param name="fieldName" select="name()"/>
					<xsl:with-param name="fieldValue" select="."/>
					<xsl:with-param name="mandatory" select="@mandatory"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'MultipleList'">
				<xsl:call-template name="showMultipleList">
					<xsl:with-param name="position" select="$position"/>
					<xsl:with-param name="fieldName" select="name()"/>
					<xsl:with-param name="fieldValue" select="."/>
					<xsl:with-param name="mandatory" select="@mandatory"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise><!-- TextField default-->
				<xsl:call-template name="showAvailTextField">
					<xsl:with-param name="position" select="$position"/>
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
			
	</xsl:template>
	<xsl:template name="showAvailTextArea">
		<xsl:param name="position" />
		<div class="userjobdetails-input-right-align">
				<xsl:choose>
					<xsl:when test="@edittable='false'">
						<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
						<input type="hidden" name="{name()}_{$position}" id="{name()}_{$position}" value="{.}"/>
					</xsl:when>
					<xsl:otherwise>
					<textarea maxlength="40" section_name="{name()}_{$position}"
						name="{name()}_{$position}" id="{name()}_{$position}"
						class="multiple-input">
						<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
						<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="." /></xsl:attribute>
						<xsl:value-of select="normalize-space(.)"
							disable-output-escaping="yes" />
					</textarea>
					<div id="{name()}_{$position}_iconstatus" style="display:inline;"
						class="msg_tooltip" />
					</xsl:otherwise>
				</xsl:choose>
		</div>
	</xsl:template>
	<xsl:template name="showAvailTextField">
		<xsl:param name="position" />
		<div class="userjobdetails-input-right-align">
			<xsl:choose>
					<xsl:when test="@edittable='false'">
						<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
						<input type="hidden" name="{name()}_{$position}" id="{name()}_{$position}" value="{.}"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:choose>
							<xsl:when test="name() = 'postal_code_4'">
								<input type="text" maxlength="40" section_name="{name()}_{$position}"
							value="{.}" name="{name()}_{$position}" id="{name()}_{$position}"
							class="multiple-input tooltip" onBlur="javascript:validatePostalCode('{name()}_{$position}','{$position}')">
									<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
									<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
									<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
									<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="." /></xsl:attribute>
								</input>
							</xsl:when>
							<xsl:otherwise>
								<xsl:choose>
									<xsl:when test="name() = 'city_5'">
										<input type="text" maxlength="40" section_name="{name()}_{$position}"
							value="{.}" name="{name()}_{$position}" id="{name()}_{$position}"
							class="multiple-input tooltip" disabled="true">
											<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
											<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
											<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
											<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="." /></xsl:attribute>
										</input>
									</xsl:when>
									<xsl:otherwise>
										<input type="text" maxlength="40" section_name="{name()}_{$position}"
							value="{.}" name="{name()}_{$position}" id="{name()}_{$position}"
							class="multiple-input tooltip">
											<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
											<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
											<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
											<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="." /></xsl:attribute>
										</input>
									</xsl:otherwise>
								</xsl:choose>
							</xsl:otherwise>
						</xsl:choose>
						
						<div id="{name()}_{$position}_iconstatus" style="display:inline;"
							class="msg_tooltip" />
					</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>
	<xsl:template name="showAvailCKEditor">
		<xsl:param name="position" />
		<div class="ckeditor_alignRight">
			<xsl:choose>
					<xsl:when test="@edittable='false'">
						<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
						<input type="hidden" name="{name()}_{$position}" id="{name()}_{$position}" value="{.}"/>
					</xsl:when>
					<xsl:otherwise>
						<textarea maxlength="40" section_name="{name()}_{$position}"
							name="{name()}_{$position}" id="{name()}_{$position}"
							class="ckeditor-textarea-{$section_name} multiple-input" editorType="ckeditor">
							<!-- <xsl:value-of select="normalize-space(.)"
								disable-output-escaping="yes" /> -->
							<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
							<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
							<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
							<xsl:attribute name="editorType">CKEditor</xsl:attribute>
							<xsl:value-of select="normalize-space(.)"/>
						</textarea>
						<div id="{name()}_{$position}_iconstatus" style="display:inline;"
							class="msg_tooltip" />
					</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>
	<xsl:template name="showAvailRadio">
		<xsl:param name="position" />
		<xsl:variable name="fieldName" select="name()"/>
		<xsl:variable name="fieldValue" select="."/>
		<xsl:variable name="mandatory" select="@mandatory"/>
		<xsl:variable name="validation_key" select="@validation_key"/>
		<xsl:variable name="optionId" select="@optionId"/>
		<div class="userjobdetails-input-right-align">
		<xsl:choose>
			<xsl:when test="@edittable='false'">
				<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				<input type="hidden" name="{name()}_{$position}" id="{name()}_{$position}" value="{.}"/>
			</xsl:when>
			<xsl:otherwise>
				<div id="{$fieldName}_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
				<xsl:value-of select="sputil:getRadioFields($optionId,$fieldName,$position,$fieldValue,$mandatory,$validation_key,$scopeGroupId)" disable-output-escaping="yes"/>
			</xsl:otherwise>
		</xsl:choose>
		</div>
	</xsl:template>
	<xsl:template name="showAvailCalendar">
		<xsl:param name="position" />
		<div class="userjobdetails-input-right-align">
		<xsl:choose>
			<xsl:when test="@edittable='false'">
				<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				<input type="hidden" name="{name()}_{$position}" id="{name()}_{$position}" value="{.}"/>
			</xsl:when>
			<xsl:otherwise>
				<input style="display: none" type="text" section_name="{name()}_{$position}"
					value="{.}" name="availabilityCalendar" id="{name()}_{$position}"
					class="multiple-input tooltip text_calendar_{$section_name}">
					<xsl:attribute name="validation_key"><xsl:apply-templates
						mode="ValidationKey" select="." /></xsl:attribute>
					<xsl:attribute name="mandatory"><xsl:apply-templates
						mode="Mandatory" select="." /></xsl:attribute>
					<xsl:attribute name="size"><xsl:apply-templates
						mode="Size" select="." /></xsl:attribute>
				</input>
				<div id="{name()}_{$position}_cal" />
				<div id="{name()}_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
			</xsl:otherwise>
		</xsl:choose>
		</div>
	</xsl:template>
	
	<xsl:template name="showDropdown">
		<xsl:param name="position"/>
		<xsl:param name="fieldName"/>
		<xsl:param name="fieldValue"/>
		<xsl:param name="mandatory"/>
		<xsl:variable name="optionId" select="@optionId"/>
		<xsl:variable name="level" select="@level"/>
		<div class="userjobdetails-input-right-align">
			<xsl:value-of select="sputil:getSelectOptionList($optionId,$fieldName,$position,$fieldValue,'$section_name',$mandatory,$scopeGroupId,$level)" disable-output-escaping="yes"/>
			<div id="{name()}_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
		</div>
	</xsl:template>
	
	<xsl:template name="showMultipleList">
		<xsl:param name="position"/>
		<xsl:param name="fieldName"/>
		<xsl:param name="fieldValue"/>
		<xsl:param name="mandatory"/>
		<xsl:variable name="optionId" select="@optionId"/>
		<div class="userjobdetails-input-right-align">
			<xsl:value-of select="sputil:getSelectMultipleList($optionId,$fieldName,$position,$fieldValue,'$section_name',$mandatory,$scopeGroupId)" disable-output-escaping="yes"/>
			<div id="{name()}_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
		</div>
	</xsl:template>
    <xsl:include href="dynamic_fields_template.xsl"/>
</xsl:stylesheet>
