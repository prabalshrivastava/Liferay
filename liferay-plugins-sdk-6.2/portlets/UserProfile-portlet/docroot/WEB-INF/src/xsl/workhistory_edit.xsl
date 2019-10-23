<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="employeeValues"/>
	<xsl:param name="indType"/>
	<xsl:param name="action" />
	<xsl:param name="displayField"/>
	<xsl:param name="instance"/>
	
	<xsl:template match="/">
		<div id="workhistory" class="workhistory_bottomgap">
			<xsl:apply-templates select="//work_details" >
				<xsl:with-param name="displayField" select="$displayField"></xsl:with-param>
			</xsl:apply-templates>	
		</div>	
	</xsl:template>
	
	<xsl:template match="//work_details">
		<xsl:param name="displayField"></xsl:param>
			<xsl:variable name="cnt" select="$instance" />
			<xsl:if test="@id= $cnt">		
			
				<div>
					<div id="workhistory_button_{$cnt}" class="workhistory-savedatabutton">
						<div id="workhistorySave" class="available-saveinfo">
							<a style="float:right;" title="save" id="workhistory_save" class="book update-button" href="javascript:saveInfo('workhistory', '{$cnt}','workhistoryList','{$displayField}')">&#160;</a>
						</div>
						<div class="available_undo">
							<a title="cancel" id="workhistory_cancel" class="book undo-button" href="javascript:cancelInfo('workhistory', '{$cnt}','workhistoryList','{$displayField}')">&#160;</a>
						</div>
					</div>
					<div id="workhistory_{$cnt}_iconstatus" class="msg_tooltip"/>
					<div id="workhistory_{$cnt}_status"/>
				</div>
				<xsl:call-template name="removeWorkDetails" />
			
				<xsl:for-each select="child::*">
				<xsl:variable name="fieldName" select="name()" />
				<xsl:if test="(contains(concat(',',$displayField,','),concat(',',$fieldName,',')))">
					<div class="userjobdetails-input-height">
					<xsl:choose>
					<xsl:when test="($fieldName='company_type')">
						<xsl:call-template name="companyType">
						<xsl:with-param name="fieldName" select="$fieldName"></xsl:with-param>
						</xsl:call-template>
					</xsl:when>
					 <xsl:when test="($fieldName='end_date')">
						<xsl:call-template name="endDate" >
							<xsl:with-param name="fieldName" select="$fieldName"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="($fieldName='start_date')">
						<xsl:call-template name="startDate" >
							<xsl:with-param name="fieldName" select="$fieldName"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="($fieldName='number_of_employees')">
						<xsl:call-template name="employees" >
							<xsl:with-param name="loadEmployee" select="$employeeValues"/>
							<xsl:with-param name="fieldName" select="$fieldName"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="($fieldName='industry_type')">
						<xsl:call-template name="industryType">
							<xsl:with-param name="loadIndustry" select="$indType"/>
							<xsl:with-param name="fieldName" select="$fieldName"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="($fieldName='related_projects')">
						<xsl:call-template name="relatedProjects">
							<xsl:with-param name="fieldName" select="$fieldName"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="($fieldName='recommendation')">
						<xsl:call-template name="recommendation">
							<xsl:with-param name="fieldName" select="$fieldName"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="($fieldName='work_description')">
						<xsl:call-template name="workDescription">
							<xsl:with-param name="fieldName" select="$fieldName"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>	
						<xsl:choose>
							<xsl:when test="@fieldType != ''">
								<xsl:call-template name="showWorkhistoryField">
									<xsl:with-param name="fieldName" select="$fieldName"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:otherwise>
								<xsl:call-template name="showWorkhistoryDefaultField">
									<xsl:with-param name="fieldName" select="$fieldName"/>
								</xsl:call-template>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:otherwise>
					</xsl:choose>	
					</div>
					</xsl:if>
				</xsl:for-each>	
				<xsl:if test="(contains(concat(',',$displayField,','),concat(',','recommendation',',')))">
					<xsl:call-template name="requestRecommendation"></xsl:call-template>
				</xsl:if>
			</xsl:if>
		</xsl:template>
		
	<xsl:include href="workhistory_template.xsl"/>
	
</xsl:stylesheet>
