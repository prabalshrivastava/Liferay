<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
xmlns:base="com.sambaash.platform.portlet.socialprofile.action.UserProfileBase" 
xmlns:sputil="com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil">

<xsl:param name="scopeGroupId"/>

<!-- ########## Personal Info and Basic Info field templates ############ -->
	<xsl:template mode="showAdditionalField" match="*">
		<xsl:param name="categoryName" />
		<xsl:choose>
			<xsl:when test="@fieldType = 'TextArea'">
				<xsl:call-template name="showTextArea"/>
			</xsl:when>
			<xsl:when test="@fieldType = 'CKEditor'">
				<xsl:call-template name="showCKEditor">
					<xsl:with-param name="categoryName" select="$categoryName"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'Dropdown'">
				<xsl:call-template name="showDropdown">
					<xsl:with-param name="categoryName" select="$categoryName"/>
					<xsl:with-param name="mandatory" select="@mandatory"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'MultipleList'">
				<xsl:call-template name="showMultipleList">
					<xsl:with-param name="categoryName" select="$categoryName"/>
					<xsl:with-param name="mandatory" select="@mandatory"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'Radio'">
				<xsl:call-template name="showRadio">
					<xsl:with-param name="categoryName" select="$categoryName"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'Calendar'">
				<xsl:call-template name="showCalendar"/>
			</xsl:when>
			<xsl:otherwise><!-- TextField default-->
				<xsl:call-template name="showTextField"/>
			</xsl:otherwise>
		</xsl:choose>
		
		<input type="hidden" id="{name()}_input_hidden" value="{.}"/>
	</xsl:template>
	
	 <xsl:template name="showCKEditor">
		<xsl:param name="categoryName" />
		<div id="cke_{name()}_container">
			<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{name()}_input" id="{name()}_input" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
					<div class="save_button">
						<a href="javascript:saveCKEditor('{name()}_input','{$categoryName}');" section_name="{name()}"  class="update-button" id="{name()}_submit_button">&#160;</a>
					</div>
					<div class="undo_button">
						<a href="javascript:cancelCKEditor('{name()}_input');" section_name="{name()}"  class="undo-button" id="{name()}_cancel_button">&#160;</a>
					</div>
					<div class="ckeditor_alignRight">
						<textarea section_name="{name()}" id="{name()}_input" rows="5" cols="40" class="personal_info_textarea" name="ckeditor"  >
						<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
						<xsl:attribute name="editorType">CKEditor</xsl:attribute>
						<xsl:value-of select="normalize-space(.)"/>
						</textarea>
					</div>
				</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>
	
	<xsl:template name="showTextArea">
		<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{name()}_input" id="{name()}_input" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
				<textarea section_name="{name()}" id="{name()}_input" rows="5" cols="40" class="single-input personal-info tooltip personal-info-textarea" name="textarea"  >
					<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
					<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
					<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
					<xsl:attribute name="editorType"></xsl:attribute>
					<xsl:value-of select="normalize-space(.)"/>
				</textarea>
				</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<xsl:template name="showTextField">
		<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{name()}_input" id="{name()}_input" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
				<input section_name="{name()}" id="{name()}_input" type="text" value="{.}" class="single-input personal-info tooltip" >
					<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
					<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
					<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
					<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
				</input>
				</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<xsl:template name="showDropdown">
		<xsl:param name="categoryName" />
		<xsl:param name="mandatory" />
		<xsl:variable name="optionId" select="@optionId"/>
		<xsl:variable name="level" select="@level"/>
       	<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{name()}_input" id="{name()}_input" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:variable name="fieldName" select="name()"/>
					<xsl:variable name="fieldValue" select="."/>
			       	<xsl:value-of select="sputil:getSelectOptionList($optionId,$fieldName,0,$fieldValue,$categoryName,$mandatory,$scopeGroupId,$level)" disable-output-escaping="yes"/>
				</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<xsl:template name="showMultipleList">
		<xsl:param name="categoryName" />
		<xsl:param name="mandatory" />
		<xsl:variable name="optionId" select="@optionId"/>
       	<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{name()}_input" id="{name()}_input" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:variable name="fieldName" select="name()"/>
					<xsl:variable name="fieldValue" select="."/>
			       	<xsl:value-of select="sputil:getSelectMultipleList($optionId,$fieldName,0,$fieldValue,$categoryName,$mandatory,$scopeGroupId)" disable-output-escaping="yes"/>
				</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<xsl:template name="showRadio">
		<xsl:param name="categoryName" />
			<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{name()}_input" id="{name()}_input" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:variable name="fieldName" select="name()"/>
					<xsl:variable name="fieldValue" select="."/>
					<xsl:variable name="optionId" select="@optionId"/>
					<xsl:value-of select="sputil:getSingleInputRadioFields($optionId,$fieldName,$fieldValue,$scopeGroupId,$categoryName)" disable-output-escaping="yes"/>
				</xsl:otherwise>
			</xsl:choose>
	</xsl:template>
	
	<xsl:template name="showCalendar">
		<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				</xsl:when>
				<xsl:otherwise>
					<input type="hidden" id="{name()}_input" value="{.}" section_name="{name()}" class="text_calendar_personalinfo" name="auicalendar">
						<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
						<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
					</input>
					<div id="{name()}_input_cal" />
					<div id="{name()}_input_iconstatus" class="msg_tooltip"/>
				</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<xsl:include href="dynamic_fields_template.xsl"/>
</xsl:stylesheet>
