<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="java">
<xsl:param name="can_edit"/>
<xsl:param name="categoryList"/>
<xsl:param name="communityName"/>
<xsl:param name="resource" />
<xsl:param name="displayField" />
<xsl:param name="publicField" />

<xsl:template match="/">
		<head>
			<script>
					AUI().ready(
						'aui-panel',
						'anim',
						function(A) {
						var contactContainer = new A.Panel(
							{
								collapsible: true,
								//collapsed: true,
								headerContent: '<font class="header-pretitle">Contact<span class="header-posttitle"> Information</span></font>',
								boundingBox: '#contactInfo > .aui-panel-content',
								contentBox:'#contactInfo'
							}
						).render();
					});
					
				</script>
			</head>
			<body style="width:100%">
				<div id="contactInfo">
					<div class="showdowheader-profile" />
					<xsl:apply-templates select="profile/contact_info" />
				</div>
			</body>
	</xsl:template>
	<xsl:template match="profile/contact_info">
		<!--aui-widget-bd is required to hide & show of the content, if not given 
			the content loaded is always shown -->
		<div class="yui3-widget-bd">
			<div id="contact_info_details">
				<xsl:call-template name="listOfCategory" />
				<xsl:call-template name="contactInfo_button" />
				<xsl:for-each select="//contact_details">
					<div id="contact_info_{position()}">
						<xsl:if test="$can_edit=1">
							<div class="contact_info_editAlign" id="contact_info_edit">
								<a style="float:right;" class="book userprofile-edit-link"
									href="javascript:editContactInfo('contact_info','{position()}','{$displayField}')"
									title="Edit">&#160;</a>
							</div>
						</xsl:if>
						<xsl:for-each select="*">
							<xsl:apply-templates mode="showField" select="." />
						</xsl:for-each>
					</div>
					<div id="contact_info_edit_{position()}" />
				</xsl:for-each>
			</div>
		</div>
	</xsl:template>

	<xsl:template mode="showField" match="phone_details">
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','phone_no',','))) or (contains(concat(',',$displayField,','),concat(',','ext',',')))">
				<xsl:choose>
					<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
						<xsl:if test="(contains(concat(',',$publicField,','),concat(',','phone_no',','))) or (contains(concat(',',$publicField,','),concat(',','ext',',')))">
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
						</xsl:if>
					</xsl:when>
					<xsl:otherwise>
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
					</xsl:otherwise>
				</xsl:choose>
			</xsl:if>
			<span class="contact-phonedetails-span">
				<xsl:text>:</xsl:text>Rbl
			</span>
			<div class="contact-phone-ext">
				<xsl:if test="(contains(concat(',',$displayField,','),concat(',','ext',',')))">
					<span>
						<xsl:choose>
							<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
								<xsl:if test="(contains(concat(',',$publicField,','),concat(',','ext',',')))">
									<xsl:value-of select="ext" />
								</xsl:if>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="ext" />
							</xsl:otherwise>
						</xsl:choose>
					</span>
				</xsl:if>
				<xsl:if test="(contains(concat(',',$displayField,','),concat(',','phone_no',',')))">
					<span class="phone">
						<xsl:choose>
							<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
								<xsl:if test="(contains(concat(',',$publicField,','),concat(',','phone_no',',')))">
									<xsl:value-of select="phone_no" />
								</xsl:if>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="phone_no" />
							</xsl:otherwise>
						</xsl:choose>
					</span>
				</xsl:if>
			</div>
	</xsl:template>

	<xsl:template mode="showField" match="address_details">
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','address',','))) or (contains(concat(',',$displayField,','),concat(',','address1',','))) 
				or (contains(concat(',',$displayField,','),concat(',','city',','))) or (contains(concat(',',$displayField,','),concat(',','country',','))) or (contains(concat(',',$displayField,','),concat(',','postal_code',',')))">
				<xsl:choose>
					<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
						<xsl:if test="(contains(concat(',',$publicField,','),concat(',','address',','))) or (contains(concat(',',$publicField,','),concat(',','publicField',','))) 
							or (contains(concat(',',$publicField,','),concat(',','city',','))) or (contains(concat(',',$publicField,','),concat(',','country',','))) or (contains(concat(',',$publicField,','),concat(',','postal_code',',')))">
							<div class="content-title contact-addressdetails">
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
						</xsl:if>
					</xsl:when>
					<xsl:otherwise>
						<div class="content-title contact-addressdetails">
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
					</xsl:otherwise>
				</xsl:choose>
			</xsl:if>
			<span class="contact-phonedetails-span">
				<xsl:text>:</xsl:text>
			</span>
			<div class="contact-phone-ext">
				<xsl:if test="(contains(concat(',',$displayField,','),concat(',','address',',')))">
					<div>
						<xsl:choose>
							<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
								<xsl:if test="(contains(concat(',',$publicField,','),concat(',','address',',')))">
									<xsl:value-of select="address" />
								</xsl:if>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="address" />
							</xsl:otherwise>
						</xsl:choose>
					</div>
				</xsl:if>
				<xsl:if test="(contains(concat(',',$displayField,','),concat(',','address1',',')))">
					<div>
						<xsl:choose>
							<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
								<xsl:if test="(contains(concat(',',$publicField,','),concat(',','address1',',')))">
									<xsl:value-of select="address1" />
								</xsl:if>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="address1" />
							</xsl:otherwise>
						</xsl:choose>
					</div>
				</xsl:if>
				<xsl:if test="(contains(concat(',',$displayField,','),concat(',','city',',')))">
					<div>
						<xsl:choose>
							<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
								<xsl:if test="(contains(concat(',',$publicField,','),concat(',','city',',')))">
									<xsl:value-of select="city" />
								</xsl:if>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="city" />
							</xsl:otherwise>
						</xsl:choose>
					</div>
				</xsl:if>
				<xsl:if test="(contains(concat(',',$displayField,','),concat(',','country',',')))">
					<div>
						<xsl:choose>
							<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
								<xsl:if test="(contains(concat(',',$publicField,','),concat(',','country',',')))">
									<xsl:value-of select="country" />
								</xsl:if>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="country" />
							</xsl:otherwise>
						</xsl:choose>
					</div>
				</xsl:if>
				<xsl:if test="(contains(concat(',',$displayField,','),concat(',','postal_code',',')))">
					<div>
						<xsl:choose>
							<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
								<xsl:if test="(contains(concat(',',$publicField,','),concat(',','postal_code',',')))">
									<xsl:value-of select="postal_code" />
								</xsl:if>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="postal_code" />
							</xsl:otherwise>
						</xsl:choose>
					</div>
				</xsl:if>
			</div>
	</xsl:template>

	<xsl:template mode="showField" match="*">
		<xsl:choose>
			<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
				<xsl:if test="(contains(concat(',',$publicField,','),concat(',',name(),',')))">
					<xsl:call-template name="GetDefaultContactInfoFld" />
				</xsl:if>
			</xsl:when>
			<xsl:otherwise>
				<xsl:call-template name="GetDefaultContactInfoFld" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<xsl:template name="GetDefaultContactInfoFld">
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
					<xsl:choose>
						<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
							<xsl:if test="(contains(concat(',',$publicField,','),concat(',',name(),',')))">
								<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
							</xsl:if>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
						</xsl:otherwise>
					</xsl:choose>
				</div>
			</div>
		</xsl:if>
	</xsl:template>

	<xsl:template name="listOfCategory">
		<input type="hidden" id="contact_infoList" value="{$displayField}" />
	</xsl:template>

	<xsl:template name="contactInfo_button">
		<div>
			<div id="contact_info_iconstatus" class="msg_tooltip" />
			<div id="contact_info_button" class="contactinfo-button"
				style="width:100%;clear:both;height:2px;" />

			<div id="contact_info_status" />
		</div>
	</xsl:template>
	<xsl:include href="contact_info_template.xsl" />
</xsl:stylesheet>
