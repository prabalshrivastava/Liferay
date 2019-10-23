<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="java">
<xsl:output method="html" indent="yes" encoding="UTF-8"/>
<xsl:param name="saveData"/>
<xsl:param name="can_edit"/>
<xsl:param name="communityName"/>
<xsl:param name="resource" />
<xsl:param name="displayField"/>
<xsl:param name="publicField"/>
	<xsl:template match="/">
	<head>
	<script>
		AUI().ready(
		'aui-panel',
		'anim',
		function(A) {
			var availabilityStatus = new A.Panel(
					{
						collapsible: true,
						//collapsed: true,
						headerContent: '<font class="header-pretitle">User<span class="header-posttitle"> Availability Status</span></font>',
						boundingBox: '#availability > .aui-panel-content',
						contentBox:'#availability'
					}
				).render();
			
		}	);
		</script>
	</head>
	<body style="width:100%">
		<div id="availability">
		<div class="showdowheader-profile"></div>
			<xsl:apply-templates select="profile/availability_info" />
		</div>
	</body>
	</xsl:template>
	
	<xsl:template match="profile/availability_info">
		<div class="yui3-widget-bd">
			<xsl:call-template name="availability_info_button">
				<xsl:with-param name="saveData" select="$saveData"/>
			</xsl:call-template>
			<div id="availability_info_details">
			<xsl:for-each select="//user_availability">
				<xsl:variable name="count"><xsl:value-of select="@id" /></xsl:variable>
				<!-- <xsl:variable name="count"><xsl:value-of select="position()" /></xsl:variable> -->
				<div id="availability_info_{$count}" class="workhistory_bottomgap">
						<div class="availability_info_editAlign" id="availability_info_button_{$count}" instance="{$count}">
							<xsl:if test="$can_edit=1">
								<a class="book userprofile-edit-link" href="javascript:editDetails('availability_info','{$count}','{$displayField}')" title="Edit">&#160;</a>
								<a class="book userprofile-delete-link" href="javascript:removeGroupInput('availability_info','user_availability','{$count}','{$displayField}')" title="Delete">&#160;</a>
							</xsl:if>
						</div>	
						<xsl:for-each select="*">
							<xsl:if test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
								<xsl:choose>
									<xsl:when test="$can_edit=0"><!-- public view -->
										<xsl:if test="(contains(concat(',',$publicField,','),concat(',',name(),',')))">
											<xsl:apply-templates mode="output" select="." >
												<xsl:with-param name="count" select="$count"/>
											</xsl:apply-templates>
										</xsl:if>
									</xsl:when>
									<xsl:when test="$can_edit=2"><!-- public view -->
										<xsl:if test="(contains(concat(',',$publicField,','),concat(',',name(),',')))">
											<xsl:apply-templates mode="output" select="." >
												<xsl:with-param name="count" select="$count"/>
											</xsl:apply-templates>
										</xsl:if>
									</xsl:when>
									<xsl:otherwise>
										<xsl:apply-templates mode="output" select="." >
											<xsl:with-param name="count" select="$count"/>
										</xsl:apply-templates>
									</xsl:otherwise>
								</xsl:choose>
							</xsl:if>
						</xsl:for-each>
				</div>
				<div id="availability_info_edit_{$count}"/>
			</xsl:for-each>
			</div>
		</div>
	</xsl:template>	
	<xsl:template mode="output" match="*">
		<xsl:param name="count"/>
		<div class="availability-horizontalspacing">
			<span class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label" />
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.availabilityinfo.',name(),'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</span>
			<div class="seperatedline" />

			<xsl:value-of select="normalize-space(.)"
				disable-output-escaping="yes" />
		</div>
		
	</xsl:template>
	<xsl:template name="availability_info_button">
		<xsl:param name="saveData"/>
		<input type="hidden" id="availability_infoList" value="{$displayField}" />
		<xsl:if test="$can_edit=1">
			<div style="{$saveData}">
				<div class="workhistory-savedata"  id="availability_info_add">
					<a class="book userprofile-add-link" href="javascript:addWorkHistoryInfo('availability_info','user_availability','addMultipleInput','{$displayField}');"  title="Add">&#160;</a>
				</div>
				<div id="availability_info_button" class="workhistory-savedatabutton"/>
				<div id="availability_info_iconstatus" class="msg_tooltip"/>
				<div id="availability_info_status"/>
			</div>
		</xsl:if>
	</xsl:template>
	<xsl:include href="dynamic_fields_template.xsl" />
</xsl:stylesheet>
