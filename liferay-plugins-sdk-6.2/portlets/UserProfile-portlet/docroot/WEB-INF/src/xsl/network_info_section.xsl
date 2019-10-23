<?xml version="1.0" ?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="java">
	<xsl:param name="can_edit" />
	<xsl:param name="communityName" />
	<xsl:param name="displayField" />
	<xsl:param name="resource" />
	<xsl:param name="section" />
	<xsl:template match="/">
		<xsl:apply-templates select="profile/network_info" />
	</xsl:template>

	<xsl:template match="profile/network_info">
		<xsl:for-each select="//network_info/*">
			<xsl:variable name="categoryName">
				<xsl:value-of select="name()" />
			</xsl:variable>
			<xsl:if test="($categoryName = $section)">
				<xsl:for-each select=".">
					<xsl:apply-templates mode="output" select=".">
						<xsl:with-param name="catName" select="$categoryName" />
					</xsl:apply-templates>
				</xsl:for-each>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>

	<xsl:template mode="output" match="messenger">
		<xsl:param name="catName" />

		<xsl:for-each select="messenger_url">
			<xsl:variable name="count" select="position()" />
			<div id="{$catName}_{$count}">
				<div class="networkinformation-value">
					<xsl:value-of select="*[1]" />
					:
					<xsl:value-of select="*[2]" />
				</div>
				<div id="{$catName}_url_Button_{$count}" class="networkinformation-button">
					<a class="book userprofile-delete-link"
						href="javascript:removeSingleInputInstance('{$catName}','{$catName}_url','{$catName}_url{$count}','{$count}')"
						title="Delete">&#160;</a>
				</div>
			</div>
		</xsl:for-each>

	</xsl:template>

	<xsl:template mode="output" match="websites|twitter|facebook|linkedin">
		<xsl:param name="catName" />
		<xsl:for-each select="*">
			<xsl:variable name="count" select="position()" />
			<div id="{$catName}_{$count}">
				<div class="networkinformation-value">
					<xsl:choose>
						<xsl:when test="starts-with(., 'http://')">
							<a target="_blank" href="{.}">
								<xsl:value-of select="normalize-space(.)" />
							</a>
						</xsl:when>
						<xsl:otherwise>
							<a target="_blank" href="http://{.}">
								<xsl:value-of select="normalize-space(.)" />
							</a>
						</xsl:otherwise>
					</xsl:choose>
				</div>
				<div id="{$catName}_url_Button_{$count}" class="networkinformation-button">
					<a class="book userprofile-delete-link"
						href="javascript:removeSingleInputInstance('{$catName}','{$catName}_url','{$catName}_url{$count}','{$count}')"
						title="Delete">&#160;</a>
				</div>
			</div>
		</xsl:for-each>
	</xsl:template>
	
	<xsl:template mode="output" match="*">
		<xsl:param name="catName" />
		<xsl:for-each select="*">
			<xsl:variable name="count" select="position()" />
			<div id="{$catName}_{$count}">
				<div class="networkinformation-value">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				</div>
				<div id="{$catName}_url_Button_{$count}" class="networkinformation-button">
					<a class="book userprofile-delete-link"
						href="javascript:removeSingleInputInstance('{$catName}','{$catName}_url','{$catName}_url{$count}','{$count}')"
						title="Delete">&#160;</a>
				</div>
			</div>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>
