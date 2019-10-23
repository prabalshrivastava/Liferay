<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="java">
	<xsl:param name="instance"/>
	<xsl:param name="communityName"/>
	<xsl:param name="resource" />
	<xsl:param name="displayField" />
	<xsl:template match="/">
		<div id="availability">
			<xsl:apply-templates select="//user_availability" />
		</div>	
	</xsl:template>
	<xsl:template match="//user_availability">
			<div id="availability_info_{$instance}">
			<div>
				<div id="availability_info_button_{$instance}" class="availability_info-savedatabutton">
					<div id="availability_infoSave" class="available-saveinfo">
						<a style="float:right" title="save" id="availability_info_save" class="book update-button" href="javascript:saveInfo('availability_info', '{$instance}','availability_infoList','{$displayField}')">&#160;</a>
					</div>
					<div class="available_undo">
						<a title="cancel" id="availability_info_cancel" class="book undo-button" href="javascript:cancelInfo('availability_info', '{$instance}','availability_infoList','{$displayField}')">&#160;</a>
					</div>
				</div>
				<div id="availability_info_{$instance}_iconstatus" class="msg_tooltip"/>
				<div id="availability_info_{$instance}_status"/>
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
	<xsl:template mode="Mandatory" match="available_for|avail_start_date|avail_end_date">true</xsl:template>
	<xsl:template mode="Mandatory" match="*">false</xsl:template>
	<xsl:template mode="MaxLength" match="available_for|avail_start_date|avail_end_date">75</xsl:template>
	<xsl:template mode="MaxLength" match="*">75</xsl:template>
	<xsl:template mode="Size" match="*">47</xsl:template>
	
	<xsl:template mode="showField" match="avail_start_date|avail_end_date">
		<xsl:param name="position" />
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="name()"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="java:getString($resource,concat($communityName,'.userprofile.availabilityinfo.',name(),'.edit.label'))" disable-output-escaping="yes"/>
					</xsl:otherwise>
				</xsl:choose>
			</span>	
		</div>
		<div class="userjobdetails-input-right-align">
			<input style="display: none" type="text" value="{.}" name="{name()}_{$position}" id="{name()}_{$position}" class="multiple-input tooltip text_calendar_availability_info" readonly="readonly">
				<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
				<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
				<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
				<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
			</input>
			<div id="{name()}_{$position}_cal" />
			<div id="{name()}_{$position}_iconstatus" class="msg_tooltip" />
			<xsl:if test="name() = 'avail_start_date'">
				<input type="hidden" id="hdnStartDate" value="{.}"/>
			</xsl:if>
		</div>	
	</xsl:template>

	 <xsl:template mode="showField" match="*">
		<xsl:param name="position" />
		<div class="userjobdetails-input-left-align">
			<div class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label" />
						</xsl:call-template>
						<xsl:if test="@mandatory='true'">*</xsl:if>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.availabilityinfo.',name(),'.edit.label'))"
							disable-output-escaping="yes" />
					</xsl:otherwise>
				</xsl:choose>
			</div>
		</div>
		<div class="userjobdetails-input-right-align">
			<input type="text" value="{.}" name="{name()}_{$position}" id="{name()}_{$position}" class="multiple-input tooltip">
				<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
				<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
				<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
				<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
			</input>
			<div id="{name()}_{$position}_iconstatus" style="display:inline;" class="msg_tooltip" />
		</div>	
	</xsl:template>
	
	<xsl:template name = "removeAvailabilityDetails">
		<div class="workhistory-buttonalign" id="availability_info_Button_{$instance}">
			<a class="book userprofile-delete-link" href="javascript:removeGroupInput('availability_info','user_availability','{$instance}','{$displayField}')" title="Delete">&#160;</a>
		</div>
	</xsl:template>
	<xsl:include href="availability_info_template.xsl" />
</xsl:stylesheet>
