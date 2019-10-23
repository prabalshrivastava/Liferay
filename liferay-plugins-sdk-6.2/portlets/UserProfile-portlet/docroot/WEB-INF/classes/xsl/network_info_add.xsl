<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="category" />
	<xsl:param name="instance" />
	<xsl:param name="selected" />
	
	<xsl:template match="/">
		<xsl:apply-templates select="profile/network_info" />
	</xsl:template>

	<xsl:template match="profile/network_info">
		<xsl:for-each select="//network_info/*">
			<xsl:variable name="categoryName">
				<xsl:value-of select="name()" />
			</xsl:variable>
			<xsl:if test="($categoryName = $category)">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:apply-templates mode="showNetworkInfoField" select=".">
							<xsl:with-param name="position" select="$instance" />
							<xsl:with-param name="categoryName" select="$categoryName" />
							<xsl:with-param name="selected" select="$selected" />
						</xsl:apply-templates>
					</xsl:when>
					<xsl:otherwise>
						<xsl:apply-templates mode="outputNetwork" select=".">
							<xsl:with-param name="position" select="$instance" />
							<xsl:with-param name="categoryName" select="$categoryName" />
						</xsl:apply-templates>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	<xsl:include href="network_info_template.xsl" />
</xsl:stylesheet>