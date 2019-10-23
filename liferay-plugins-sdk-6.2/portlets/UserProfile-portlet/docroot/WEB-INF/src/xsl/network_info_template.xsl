<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
xmlns:sputil="com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil">

<xsl:param name="scopeGroupId"/>

	<xsl:template mode="showNetworkInfoField" match="*">
		<xsl:param name="categoryName" />
		<xsl:param name="position" />
		<xsl:param name="selected" />
		<div id='new_{$categoryName}_{$position}' class='workhistory-paddingbottom'>
			<div class='workhistory-inputuserprofileaction' style="float:left;">
				<xsl:choose>
					<xsl:when test="@fieldType = 'TextArea'">
						<xsl:call-template name="showNetworkTextArea">
							<xsl:with-param name="position" select="$position"/>
							<xsl:with-param name="categoryName" select="$categoryName"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="@fieldType = 'CKEditor'">
						<xsl:call-template name="showNetworkCKEditor">
							<xsl:with-param name="position" select="$position"/>
							<xsl:with-param name="categoryName" select="$categoryName"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="@fieldType = 'Dropdown'">
						<xsl:call-template name="showDropdown">
							<xsl:with-param name="position" select="$position"/>
							<xsl:with-param name="categoryName" select="$categoryName"/>
							<xsl:with-param name="selected" select="$selected"/>
							<xsl:with-param name="mandatory" select="@mandatory"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="@fieldType = 'Radio'">
						<xsl:call-template name="showNetworkRadio">
							<xsl:with-param name="position" select="$position"/>
							<xsl:with-param name="categoryName" select="$categoryName"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="@fieldType = 'Calendar'">
						<xsl:call-template name="showNetworkCalendar">
							<xsl:with-param name="position" select="$position"/>
							<xsl:with-param name="categoryName" select="$categoryName"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="@fieldType = 'MultipleList'">
						<xsl:call-template name="showMultipleList">
							<xsl:with-param name="categoryName" select="$categoryName"/>
							<xsl:with-param name="mandatory" select="@mandatory"/>
							<xsl:with-param name="position" select="$position"/>
							<xsl:with-param name="selected" select="$selected"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise><!-- TextField default-->
						<xsl:call-template name="showNetworkTextField">
							<xsl:with-param name="position" select="$position"/>
							<xsl:with-param name="categoryName" select="$categoryName"/>
						</xsl:call-template>
					</xsl:otherwise>
				</xsl:choose>
			</div>
			<div id='{$categoryName}_Input_{$position}_iconstatus' class='msg_tooltip' />
			<div class='workhistory-inputuserprofile-delete-link'>
				<a class='book userprofile-delete-link' href="javascript:removeElement('new_{$categoryName}_{$position}');" title='Delete'>&#160;</a>
			</div>
		</div>
	</xsl:template>
	<xsl:template name="showNetworkTextArea">
		<xsl:param name="position" />
		<xsl:param name="categoryName" />
		<xsl:choose>
			<xsl:when test="@edittable='false'">
				<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				<input type="hidden" name="{$categoryName}_Input_{$position}" id="{$categoryName}_Input_{$position}" value="{.}"/>
			</xsl:when>
			<xsl:otherwise>
				<textarea id='{$categoryName}_Input_{$position}' class='single-input-social' category='{$categoryName}' position='{$position}'>
					<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
					<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
					<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
					<xsl:value-of select="@default" />
				</textarea>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="showNetworkTextField">
		<xsl:param name="position" />
		<xsl:param name="categoryName" />
		<xsl:choose>
			<xsl:when test="@edittable='false'">
				<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				<input type="hidden" name="{$categoryName}_Input_{$position}" id="{$categoryName}_Input_{$position}" value="{.}"/>
			</xsl:when>
			<xsl:otherwise>
				<input type='text' id='{$categoryName}_Input_{$position}' class='single-input-social' category='{$categoryName}' position='{$position}'>
					<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
					<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
					<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
					<xsl:attribute name="value"><xsl:value-of select="@default" /></xsl:attribute>
				</input>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="showNetworkCKEditor">
		<xsl:param name="position" />
		<xsl:param name="categoryName" />
		<xsl:choose>
			<xsl:when test="@edittable='false'">
				<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				<input type="hidden" name="{$categoryName}_Input_{$position}" id="{$categoryName}_Input_{$position}" value="{.}"/>
			</xsl:when>
			<xsl:otherwise>
				<div class="save_button">
					<a href="javascript:saveNetworkInfo('{$categoryName}_Input_{$position}');" section_name="{$categoryName}"  class="update-button" id="{$categoryName}_submit_button">&#160;</a>
				</div>
				<div class="ckeditor_alignRight">
					<textarea id='{$categoryName}_Input_{$position}' class='ckeditor-textarea-{$categoryName}-{$position} single-input-social' category='{$categoryName}' position='{$position}' editorType='CKEditor'>
						<xsl:value-of select="@default" />
						<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
					</textarea>
				</div>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="showNetworkRadio">
		<xsl:param name="position" />
		<xsl:param name="categoryName" />
		<xsl:variable name="mandatory" select="@mandatory"/>
		<xsl:variable name="validation_key" select="@validation_key"/>
		<xsl:variable name="fieldValue" select="@default"/>
		<xsl:variable name="optionId" select="@optionId"/>
		<xsl:choose>
			<xsl:when test="@edittable='false'">
				<xsl:value-of select="normalize-space(.)" />
				<input type="hidden" name="{$categoryName}_Input_{$position}" id="{$categoryName}_Input_{$position}" value="{@default}" class="single-input-social"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="sputil:getRadioFields($optionId,$categoryName,$position,$fieldValue,$mandatory,$validation_key,$scopeGroupId)" disable-output-escaping="yes"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<xsl:template name="showNetworkCalendar">
		<xsl:param name="position" />
		<xsl:param name="categoryName" />
		<xsl:variable name="fieldValue" select="."/>
		<xsl:choose>
			<xsl:when test="@edittable='false'">
				<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				<input type="hidden" name="{$categoryName}_Input_{$position}" id="{$categoryName}_Input_{$position}" value="{.}"/>
			</xsl:when>
			<xsl:otherwise>
				<input type="hidden" category='{$categoryName}' position='{$position}' id="{$categoryName}_Input_{$position}" section_name="{$categoryName}" class="text_calendar_{$position}_{$categoryName}" name="auicalendar">
					<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
					<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
					<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
				</input>
				<div id="{$categoryName}_Input_{$position}_cal" />
				<div id="{$categoryName}_Input_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<xsl:template name="showDropdown">
		<xsl:param name="position" />
		<xsl:param name="categoryName" />
		<xsl:param name="selected" />
		<xsl:param name="mandatory" />
		<xsl:variable name="optionId" select="@optionId"/>
		<xsl:variable name="level" select="@level"/>
		<xsl:choose>
			<xsl:when test="@edittable='false'">
				<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				<input type="hidden" name="{$categoryName}_Input_{$position}" id="{$categoryName}_Input_{$position}" value="."/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="sputil:getSelectOptionList($optionId,$categoryName,$position,$selected,'network_info',$mandatory,$scopeGroupId,$level)" disable-output-escaping="yes"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<xsl:template name="showMultipleList">
		<xsl:param name="categoryName" />
		<xsl:param name="mandatory" />
		<xsl:param name="position" />
		<xsl:param name="selected" />
		<xsl:variable name="optionId" select="@optionId"/>
       	<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/> <!-- TODO: replace the concatenated list delimiter with space or comma for display -->
					<input type="hidden" name="{$categoryName}_Input_{$position}" id="{$categoryName}_Input_{$position}" value="."/>
				</xsl:when>
				<xsl:otherwise>
			       	<xsl:value-of select="sputil:getSelectMultipleList($optionId,$categoryName,$position,$selected,'network_info',$mandatory,$scopeGroupId)" disable-output-escaping="yes"/>
				</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
    
	<xsl:template mode="outputNetwork" match="*">
		<xsl:param name="categoryName" />
		<xsl:param name="position" />
		<div id='new_{$categoryName}_{$position}' class='workhistory-paddingbottom'>
			<div class='workhistory-inputuserprofileaction' style="float:left;">
				<xsl:choose>
					<xsl:when test="@edittable='false'">
						<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
						<input type="hidden" name="{$categoryName}_Input_{$position}" id="{$categoryName}_Input_{$position}" value="{.}"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:choose>
							<xsl:when test="$categoryName = 'email'">
								<input type='text' id='{$categoryName}_Input_{$position}' class='single-input-social' category='{$categoryName}' position='{$position}'>
									<xsl:attribute name="validation_key">5</xsl:attribute>
									<xsl:attribute name="mandatory">true</xsl:attribute>
									<xsl:attribute name="maxlength">1000</xsl:attribute>
								</input>
							</xsl:when>
							<xsl:otherwise><!-- TextField default -->
								<input type='text' id='{$categoryName}_Input_{$position}' class='single-input-social' category='{$categoryName}' position='{$position}'>
									<xsl:attribute name="validation_key">3</xsl:attribute>
									<xsl:attribute name="mandatory">true</xsl:attribute>
									<xsl:attribute name="maxlength">1000</xsl:attribute>
								</input>
							</xsl:otherwise>
						</xsl:choose>
						<div id='{$categoryName}_Input_{$position}_iconstatus' class='msg_tooltip' />
					</xsl:otherwise>
				</xsl:choose>
			</div>
			<div class='workhistory-inputuserprofile-delete-link'>
					<a class='book userprofile-delete-link' href="javascript:removeElement('new_{$categoryName}_{$position}');" title='Delete'>&#160;</a>
				</div>
		</div>
	</xsl:template>
    
	<xsl:include href="dynamic_fields_template.xsl"/>
</xsl:stylesheet>
