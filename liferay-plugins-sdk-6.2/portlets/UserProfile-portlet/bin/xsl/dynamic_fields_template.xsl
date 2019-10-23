<?xml version="1.0" ?>
<xsl:stylesheet version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  
	xmlns:aui="http://liferay.com/tld/aui"
	xmlns:java="java" 
	xmlns:sputil="com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil">

	<xsl:output method="html" encoding="UTF-8"/>
	
	<xsl:variable name="vLower" select="'abcdefghijklmnopqrstuvwxyz'"/>
	<xsl:variable name="vUpper" select="'ABCDEFGHIJKLMNOPQRSTUVWXYZ'"/>

	<xsl:template name="Pascalize">
	    <xsl:param name="pText" />
	     <xsl:if test="$pText">
	        <xsl:value-of select="translate(substring($pText,1,1), $vLower, $vUpper)" />
	        <xsl:choose>
	            <xsl:when test="contains($pText, '_')"> 
	                <xsl:value-of select="concat(substring-before(substring($pText,2), '_'),' ')" />
	            </xsl:when>
	            <xsl:otherwise>
	                <xsl:value-of select="substring($pText,2)" />
	            </xsl:otherwise>
	        </xsl:choose>
	        <xsl:call-template name="Pascalize">
	            <xsl:with-param name="pText" select="substring-after(substring($pText,2), '_')" />
	        </xsl:call-template>
	    </xsl:if> 
	</xsl:template>
	
</xsl:stylesheet>
