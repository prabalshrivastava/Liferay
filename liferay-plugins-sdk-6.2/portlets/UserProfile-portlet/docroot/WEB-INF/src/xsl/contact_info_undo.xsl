<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="java">
<xsl:param name="can_edit" select="1"/>
<xsl:param name="categoryList"/>
<xsl:param name="communityName"/>
<xsl:param name="resource" />
<xsl:param name="displayField" />
<xsl:template match="/">
	<xsl:apply-templates select="profile/contact_info" />
</xsl:template>
	<xsl:template match="profile/contact_info">
		<!--aui-widget-bd is required to hide & show of the content, if not given the content loaded is always shown -->
		<xsl:call-template name="listOfCategory"/>
		<xsl:call-template name="contactInfo_button"/>
		<xsl:for-each select="//contact_details">
			<div id="contact_info_{position()}">
				<xsl:if test="$can_edit=1">
					<div class="contact_info_editAlign" id="contact_info_edit"><a style="float:right;" class="book userprofile-edit-link" href="javascript:editContactInfo('contact_info','{position()}','{$displayField}')" title="Edit">&#160;</a></div>
				</xsl:if>
				<xsl:for-each select="*">
					<xsl:apply-templates mode="showField" select="." />
				</xsl:for-each>
			</div>
			<div id="contact_info_edit_{position()}"/>
		</xsl:for-each>
	</xsl:template>

	<xsl:template mode="showField" match="phone_details">
		<xsl:if test="(contains(concat(',',$displayField,','),concat(',','phone_no',','))) or (contains(concat(',',$displayField,','),concat(',','ext',',')))">
			<div class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="name()" />
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.contactinfo.',name(),'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</div>
		</xsl:if>
		<span class="contact-phonedetails-span">
			<xsl:text>:</xsl:text>
		</span>
		<div class="contact-phone-ext">
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','ext',',')))">
				<span>
					<xsl:value-of select="ext" />
				</span>
			</xsl:if>
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','phone_no',',')))">
				<span class="phone">
					<xsl:value-of select="phone_no" />
				</span>
			</xsl:if>	
		</div>
	</xsl:template>

	<xsl:template mode="showField" match="address_details">
		<xsl:if test="(contains(concat(',',$displayField,','),concat(',','address',','))) or (contains(concat(',',$displayField,','),concat(',','address1',','))) 
				or (contains(concat(',',$displayField,','),concat(',','city',','))) or (contains(concat(',',$displayField,','),concat(',','country',','))) or (contains(concat(',',$displayField,','),concat(',','postal_code',',')))">
			<div class="content-title contact-addressdetails">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="name()" />
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.contactinfo.',name(),'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</div>
		</xsl:if>
		<span class="contact-phonedetails-span">
			<xsl:text>:</xsl:text>
		</span>
		<div class="contact-phone-ext">
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','address',',')))">
				<div>
					<xsl:value-of select="address" />
				</div>
			</xsl:if>
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','address1',',')))">
				<div>
					<xsl:value-of select="address1" />
				</div>
			</xsl:if>
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','city',',')))">
				<div>
					<xsl:value-of select="city" />
				</div>
			</xsl:if>
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','country',',')))">
				<div>
					<xsl:value-of select="country" />
				</div>
			</xsl:if>
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','postal_code',',')))">
				<div>
					<xsl:value-of select="postal_code" />
				</div>
			</xsl:if>
		</div>
	</xsl:template>

	<xsl:template mode="showField" match="*">
		<xsl:if test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
			<div class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label" />
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.contactinfo.',name(),'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</div>
			<span class="contact-phonedetails-span">
				<xsl:text>:</xsl:text>
			</span>
			<div class="contact-phone-ext">
				<div>
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				</div>
			</div>
		</xsl:if>
	</xsl:template>

	<xsl:template name="listOfCategory">
		<input type="hidden" id="contact_infoList" value="{$displayField}" />
	</xsl:template>

	<xsl:template name="contactInfo_button">
		<div>
		<div id="contact_info_iconstatus" class="msg_tooltip"></div>
			<div id="contact_info_button" class="contactinfo-button" style="width:100%;clear:both;height:2px;"></div>
			
			<div id="contact_info_status"/>
		</div>
	</xsl:template>	
<xsl:include href="dynamic_fields_template.xsl" />
</xsl:stylesheet>
