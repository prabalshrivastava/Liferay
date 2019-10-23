<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="java">
<xsl:param name="saveData"/>
<xsl:param name="can_edit"/>
<xsl:param name="communityName"/>
<xsl:param name="resource" />
<xsl:param name="displayField"/>
	<xsl:template match="/">
		<xsl:apply-templates select="profile/availability_info" />
	</xsl:template>
	<xsl:template match="profile/availability_info">
			<xsl:call-template name="availability_info_button">
				<xsl:with-param name="saveData" select="$saveData"/>
			</xsl:call-template>
			<xsl:for-each select="//user_availability">
				<xsl:variable name="count"><xsl:value-of select="@id" /></xsl:variable>
				<div id="availability_info_{$count}" class="workhistory_bottomgap">
						<div class="availability_info_editAlign dynamic-section-button-align" id="availability_info_button_{$count}" instance="{$count}">
							<xsl:if test="$can_edit=1">
								<a class="book userprofile-edit-link" href="javascript:editDetails('availability_info','{$count}','{$displayField}')" title="Edit">&#160;</a>
								<a class="book userprofile-delete-link" href="javascript:removeGroupInput('availability_info','user_availability','{$count}','{$displayField}')" title="Delete">&#160;</a>
							</xsl:if>
						</div>	
						<xsl:for-each select="*">
							<xsl:if test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
								<xsl:apply-templates mode="output" select="." >
									<xsl:with-param name="count" select="$count"/>
								</xsl:apply-templates>
							</xsl:if>
						</xsl:for-each>
				</div>
				<div id="availability_info_edit_{$count}"/>
			</xsl:for-each>
	</xsl:template>	
	<xsl:template mode="output" match="*">
		<xsl:param name="count"/>
		<div class="availability-horizontalspacing">
			<span class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="java:getString($resource,concat($communityName,'.userprofile.availabilityinfo.',name(),'.label'))"/>
					</xsl:otherwise>
				</xsl:choose>
			</span>
			<div class="seperatedline"></div>
			
			<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
		</div>
		
	</xsl:template>
	<xsl:template name="availability_info_button">
		<xsl:param name="saveData"/>
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
	<xsl:include href="availability_info_template.xsl" />
</xsl:stylesheet>
