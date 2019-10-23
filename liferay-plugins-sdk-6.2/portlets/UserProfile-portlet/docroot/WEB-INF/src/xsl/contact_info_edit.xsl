<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="java">
	<xsl:param name="loadCountry"/>
	<xsl:param name="communityName"/>
	<xsl:param name="resource" />
	<xsl:param name="displayField" />
	<xsl:param name="instance" />
	<xsl:template match="/">
		<xsl:apply-templates select="profile/contact_info">
			<xsl:with-param name="displayField" select="$displayField" />
		</xsl:apply-templates>
	</xsl:template>

	<xsl:template match="profile/contact_info">
		<xsl:param name="displayField" />
		<xsl:for-each select="//contact_details">
			<xsl:if test="position() = $instance">
				<div>
					<div id="contact_info_button_{$instance}" class="contact_info-savedatabutton">
						<div id="contact_info_infoSave" class="available-saveinfo">
							<a style="float:right;" title="save" id="contact_info_save"
								class="book update-button"
								href="javascript:saveInfo('contact_info', '{$instance}','contact_infoList','{$displayField}')">&#160;</a>
						</div>
						<div class="available_undo">
							<a title="cancel" id="contact_info_cancel" class="book undo-button"
								href="javascript:cancelInfo('contact_info', '{$instance}','contact_infoList','{$displayField}')">&#160;</a>
						</div>
					</div>
					<div id="contact_info_{$instance}_iconstatus" class="msg_tooltip" />
					<div id="contact_info_{$instance}_status" />
				</div>
				<div id="contact_info_edit_{position()}">
					<xsl:for-each select="*">
						<xsl:apply-templates mode="editContactInfo"
							select=".">
							<xsl:with-param name="displayField" select="$displayField" />
						</xsl:apply-templates>
					</xsl:for-each>
				</div>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>

	<xsl:template mode="editContactInfo" match="phone_details">
		<xsl:param name="displayField" />
		<xsl:for-each select="*">
			<xsl:if
				test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
				<div class="usercontactdetails-inputbox-height">
					<div class="userjobdetails-input-left-align">
							<xsl:choose>
								<xsl:when test="@fieldType != ''">
									<xsl:call-template name="Pascalize">
										<xsl:with-param name="pText" select="@label" />
									</xsl:call-template>
									<xsl:if test="@mandatory='true'">*</xsl:if>
								</xsl:when>
								<xsl:otherwise>
									<xsl:value-of
										select="java:getString($resource,concat($communityName,'.userprofile.contactinfo.',name(),'.edit.label'))" />
								</xsl:otherwise>
							</xsl:choose>
						</div>
					<xsl:apply-templates mode="showField" select="." />
				</div>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	<xsl:template mode="editContactInfo" match="address_details">
		<xsl:param name="displayField" />
		<xsl:for-each select="*">
			<xsl:if
				test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
				<div class="usercontactdetails-inputbox-height">
					<div class="userjobdetails-input-left-align">
							<xsl:choose>
								<xsl:when test="@fieldType != ''">
									<xsl:call-template name="Pascalize">
										<xsl:with-param name="pText" select="@label" />
									</xsl:call-template>
									<xsl:if test="@mandatory='true'">*</xsl:if>
								</xsl:when>
								<xsl:otherwise>
									<xsl:value-of
										select="java:getString($resource,concat($communityName,'.userprofile.contactinfo.',name(),'.edit.label'))" />
								</xsl:otherwise>
							</xsl:choose>
					</div>
					<xsl:apply-templates mode="showField" select="." />
				</div>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	<xsl:template mode="editContactInfo" match="*">
		<xsl:param name="displayField" />
		<xsl:if test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
			<div class="usercontactdetails-inputbox-height">
				<div class="userjobdetails-input-left-align">
						<xsl:choose>
							<xsl:when test="@fieldType != ''">
								<xsl:call-template name="Pascalize">
									<xsl:with-param name="pText" select="@label" />
								</xsl:call-template>
								<xsl:if test="@mandatory='true'">*</xsl:if>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of
									select="java:getString($resource,concat($communityName,'.userprofile.contactinfo.',name(),'.edit.label'))" />
							</xsl:otherwise>
						</xsl:choose>
				</div>
				<xsl:apply-templates mode="showContactInfoField" select="." >
					<xsl:with-param name="position" select="$instance" />
					<xsl:with-param name="fieldName" select="name()" />
				</xsl:apply-templates>
			</div>
		</xsl:if>
	</xsl:template>
	
	<!-- Validation templates -->
	<!--1: integer, 2:alpha-numeric, 3:url, 4:phone, 5:email, 6: letters -->
	<xsl:template mode="ValidationKey" match="phone_no">4</xsl:template>
	<xsl:template mode="ValidationKey" match="ext|postal_code">1</xsl:template>
	<xsl:template mode="ValidationKey" match="*">0</xsl:template>
	<xsl:template mode="Mandatory" match="city|country">true</xsl:template>
	<xsl:template mode="Mandatory" match="*">false</xsl:template>
	<xsl:template mode="Size" match="*">47</xsl:template>
	<xsl:template mode="MaxLength" match="phone_no">75</xsl:template>
	<xsl:template mode="MaxLength" match="ext">5</xsl:template>
	<xsl:template mode="MaxLength" match="*">2500</xsl:template>

	<xsl:template mode="showField" match="country">
		<xsl:apply-templates mode="loadCountry" select="." >
			<xsl:with-param name="loadCountry" select="$loadCountry"/>
		</xsl:apply-templates>
	</xsl:template>
	<xsl:template mode="showField" match="*">
		<div class="userjobdetails-input-right-align">
			<input type="text" maxlength="40" section_name=""
				value="{.}" name="{name()}" id="{name()}_{position()}" class="multiple-input tooltip">
				<xsl:attribute name="validation_key"><xsl:apply-templates
					mode="ValidationKey" select="." /></xsl:attribute>
				<xsl:attribute name="mandatory"><xsl:apply-templates
					mode="Mandatory" select="." /></xsl:attribute>
				<xsl:attribute name="size"><xsl:apply-templates
					mode="Size" select="." /></xsl:attribute>
				<xsl:attribute name="maxlength"><xsl:apply-templates
					mode="MaxLength" select="." /></xsl:attribute>
			</input>
			<div id="{name()}_{position()}_iconstatus" style="display:inline;" class="msg_tooltip" />
		</div>	
	</xsl:template>
	
	<xsl:template mode="loadCountry" match="*">
		<xsl:param name="loadCountry" />
		<div class="userjobdetails-input-right-align">
			<select id="{name()}_1" style="width:67%" class="multiple-input tooltip">
				<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
				<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
				<option>
					<xsl:attribute name="value">
						<xsl:value-of select="."/>
					</xsl:attribute>
					<xsl:value-of select="."/>
				</option>
				<xsl:call-template name="output-tokens">
					<xsl:with-param name="list" select="$loadCountry" />
				</xsl:call-template>
			</select>	
			<div id="{name()}_{position()}_iconstatus" style="display:inline;" class="msg_tooltip" />
		</div>
	</xsl:template>

	<xsl:template name="output-tokens">
		<xsl:param name="list" />
		<xsl:choose>
			<xsl:when test="$list = ''" />

			<xsl:when test="contains($list, ',')=false()">
				<option value="{$list}">
					<xsl:value-of select="$list" />
				</option>
			</xsl:when>
			<xsl:otherwise>
				<xsl:variable name="head" select="substring-before($list, ',')" />
				<xsl:variable name="tail" select="substring-after($list, ',')" />
				<option value="{$head}">
					<xsl:value-of select="$head" />
				</option>
				<xsl:call-template name="output-tokens">
					<xsl:with-param name="list" select="$tail" />
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<xsl:include href="contact_info_template.xsl" />
</xsl:stylesheet>
