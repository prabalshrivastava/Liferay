<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output encoding="UTF-8" indent="yes" method="xml" />

	<xsl:template match="profile/workhistory">
		<xsl:element name="workhistory">
			<xsl:for-each select="//work_details">
				<xsl:sort select="substring-after(substring-after(start_date,'/'),'/')" data-type="number" order="descending"/> <!--start_date sort -->
       			<xsl:sort select="substring-before(substring-after(start_date,'/'),'/')" data-type="number" order="descending"/> <!--month sort -->
       			<xsl:sort select="substring-before(start_date,'/')" data-type="number" order="descending"/> <!--day sort -->  
				<xsl:variable name="count"><xsl:value-of select="@id" /></xsl:variable>
				<xsl:variable name="fieldName" select="name()" />
				<xsl:element name="work_details">
				<xsl:variable name="workhistoryId"><xsl:value-of select="$count"></xsl:value-of></xsl:variable>
				<xsl:attribute name="id"><xsl:value-of select="$workhistoryId" /></xsl:attribute>
					<xsl:element name="job_title">
				      <xsl:value-of select="./job_title" />
					</xsl:element>
					<xsl:element name="company_name">
				      <xsl:value-of select="./company_name" />
					</xsl:element>
					<xsl:element name="company_url">
				      <xsl:value-of select="./company_url" />
					</xsl:element>
					<xsl:element name="company_type">
				      <xsl:value-of select="./company_type" />
					</xsl:element>
					<xsl:element name="industry_type">
				      <xsl:value-of select="./industry_type" />
					</xsl:element>
					<xsl:element name="number_of_employees">
				      <xsl:value-of select="./number_of_employees" />
					</xsl:element>
					<xsl:element name="start_date">
				      <xsl:value-of select="./start_date" />
					</xsl:element>
					<xsl:element name="end_date">
				      <xsl:value-of select="./end_date" />
					</xsl:element>
					<xsl:element name="work_description">
				      <xsl:value-of select="./work_description" />
					</xsl:element>
					<xsl:element name="recommendation">
				      <xsl:value-of select="./recommendation" />
					</xsl:element>
					<xsl:element name="related_projects">
						<xsl:element name="project">
							<xsl:element name="url">
				      			<xsl:value-of select="./related_projects"/>
				      		</xsl:element>
				      	</xsl:element>		
					</xsl:element>
				</xsl:element>	
			</xsl:for-each>
		</xsl:element>
		
	</xsl:template>
</xsl:stylesheet>
