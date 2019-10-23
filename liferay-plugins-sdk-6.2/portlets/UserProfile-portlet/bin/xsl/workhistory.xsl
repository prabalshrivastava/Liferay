<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="java">
<xsl:output method="html" indent="yes" encoding="UTF-8"/>
<xsl:param name="saveData"/>
<xsl:param name="can_edit"/>
<xsl:param name="communityName"/>
<xsl:param name="displayField"/>
<xsl:param name="publicField"/>
<xsl:param name="resource" />
<xsl:param name="validateOverlapping"/>

	<xsl:template match="/">
	<head>
	<script>
		AUI().ready(
		'aui-panel',
		'anim',
		function(A) {
			var workHistory = new A.Panel(
					{
						collapsible: true,
						//collapsed: true,
						headerContent: '<font class="header-pretitle">Work<span class="header-posttitle"> History</span></font>',
						boundingBox: '#workHistory > .aui-panel-content',
						contentBox:'#workHistory'
					}
				).render();
				
		});
		
		AUI().ready('aui-io-request', function(A) {
			var workDescNodes = A.all('.work_description_section');
				var nodesFound = false;
				workDescNodes.each(function() {
					nodesFound = true;
				});
	
				if (nodesFound == false) {
					var addLink = A.one('a.userprofile-add-link');
					if (addLink != null) {
						displayWorkHistoryAddForm();
					}
			}
		
		});
		
		</script>
	</head>
	<body style="width:100%">
		<div id="workHistory">
			<div class="showdowheader-profile"></div>
			<xsl:apply-templates select="profile/workhistory" />
		</div>
	</body>
	</xsl:template>
	
	<xsl:template match="profile/workhistory">
		<div class="yui3-widget-bd">
		<xsl:call-template name="work_history_button">
			<xsl:with-param name="saveData" select="$saveData"/>
		</xsl:call-template>
		<xsl:call-template name="validate_Overlapping">
			<xsl:with-param name="validateOverlapping" select="$validateOverlapping"/>
		</xsl:call-template>
		<div id="workhistory_details">
		<xsl:for-each select="//work_details">
			<xsl:sort select="substring-after(substring-after(start_date,'/'),'/')" data-type="number" order="descending"/> <!--start_date sort -->
       		<xsl:sort select="substring-before(substring-after(start_date,'/'),'/')" data-type="number" order="descending"/> <!--month sort -->
       		<xsl:sort select="substring-before(start_date,'/')" data-type="number" order="descending"/> <!--day sort -->  
			<xsl:variable name="count"><xsl:value-of select="@id" /></xsl:variable>
			<xsl:variable name="position"><xsl:value-of select="position()" /></xsl:variable>
			<div id="workhistory_{$count}" class="workhistory_bottomgap">
				<div class="workhistory_editAlign" id="workhistory_button_{$count}" instance="{$count}" Name="workhistory_editAlign">
					<xsl:if test="$can_edit=1">
					<a class="book userprofile-edit-link" href="javascript:editDetails('workhistory','{$count}','{$displayField}')" title="Edit">&#160;</a>
					<a class="book userprofile-delete-link" href="javascript:removeGroupInput('workhistory','work_details','{$count}','{$displayField}')" title="Delete">&#160;</a>
					</xsl:if>
				</div>	
				<xsl:for-each select="*">
					<xsl:choose>
						<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
							<xsl:if test="(contains(concat(',',$publicField,','),concat(',',name(),',')))">
								
								<xsl:apply-templates mode="output" select="." >
									<xsl:with-param name="count" select="$position"></xsl:with-param>
								</xsl:apply-templates>
							</xsl:if>
						</xsl:when>
						<xsl:otherwise>
							<xsl:apply-templates mode="output" select="." >
								<xsl:with-param name="count" select="$position"></xsl:with-param>
							</xsl:apply-templates>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:for-each>	
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','recommendation',',')))">
				<xsl:choose>
					<xsl:when test="($can_edit=0) or ($can_edit=2)"><!-- public view -->
						<xsl:if test="(contains(concat(',',$publicField,','),concat(',',name(),',')))">
							<xsl:call-template name="requestRecommendation"></xsl:call-template>
						</xsl:if>
					</xsl:when>
					<xsl:otherwise>
						<xsl:call-template name="requestRecommendation"></xsl:call-template>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:if>
			</div>
			<div id="workhistory_edit_{$count}"/>
		</xsl:for-each>
		</div>
	</div>
	</xsl:template>	

	<xsl:template mode="output" match="job_title">
		<div class="content-title">
					<xsl:choose>
						<xsl:when test="@fieldType != ''">
							<xsl:call-template name="Pascalize">
								<xsl:with-param name="pText" select="name()" />
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of
								select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))"
								disable-output-escaping="yes" />
						</xsl:otherwise>
					</xsl:choose>
					<div class="seperatedline"></div>
				</div>
		<xsl:if test="(contains(concat(',',$displayField,','),concat(',','job_title',',')))">
			<div class="workhistory-jobtitle"><xsl:value-of select="normalize-space(../job_title)" disable-output-escaping="yes"/></div>
		</xsl:if>	
	</xsl:template>
	
	 <xsl:template mode="output" match="related_projects">
		 <xsl:if test="(contains(concat(',',$displayField,','),concat(',','related_projects',',')))">
			<div class="workhistory-topspacing">
				<div class="content-title">
					<xsl:choose>
							<xsl:when test="@fieldType != ''">
								<xsl:call-template name="Pascalize">
									<xsl:with-param name="pText" select="name()" />
								</xsl:call-template>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="java:getString($resource,concat($communityName,'.userprofile.workhistory.related_projects','.label'))"/>
							</xsl:otherwise>
					</xsl:choose>
					<div class="seperatedline"></div>
				</div>
			</div>
			<xsl:for-each select="project">
				<xsl:value-of select="url" disable-output-escaping="yes"/>
			</xsl:for-each>
		</xsl:if>
	</xsl:template> 
	
	<xsl:template mode="output" match="company_name">
		<xsl:variable name="companyUrl">
			<xsl:value-of select="normalize-space(../company_url)"/>
		</xsl:variable>
		<div class="workhistory-horizontalspacing workhistory-topspacing">
		<div class="content-title">
					<xsl:choose>
						<xsl:when test="@fieldType != ''">
							<xsl:call-template name="Pascalize">
								<xsl:with-param name="pText" select="name()" />
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of
								select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))"
								disable-output-escaping="yes" />
						</xsl:otherwise>
					</xsl:choose>
					<div class="seperatedline"></div>
				</div>
		<xsl:choose>
			<xsl:when test="(contains(concat(',',$displayField,','),concat(',','company_name',',')))">
					<xsl:choose>
						<xsl:when test="(contains(concat(',',$displayField,','),concat(',','company_url',',')))">
							<a target="_blank">
								<xsl:if test="$companyUrl!=''">
									<xsl:attribute name="href">
										<xsl:if test="not(starts-with($companyUrl,'http://'))">
											<xsl:text>http://</xsl:text>
										</xsl:if>
										<xsl:value-of select="$companyUrl"/>
									</xsl:attribute>
								</xsl:if>
								<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
							</a>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
						</xsl:otherwise>
					</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:if test="(contains(concat(',',$displayField,','),concat(',','company_url',',')))">
					<a target="_blank">
						<xsl:if test="$companyUrl!=''">
							<xsl:attribute name="href">
								<xsl:if test="not(starts-with($companyUrl,'http://'))">
									<xsl:text>http://</xsl:text>
								</xsl:if>
								<xsl:value-of select="$companyUrl"/>
							</xsl:attribute>
						</xsl:if>
						<xsl:value-of select="$companyUrl"/>
					</a>
				</xsl:if>
			</xsl:otherwise>
		</xsl:choose>
		</div>
	</xsl:template>
	<xsl:template mode="output" match="company_url|number_of_employees|end_date|recommendation"><!-- this node will be ignored  --></xsl:template>
	<xsl:template mode="output" match="work_description">
		<xsl:if test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
		<div class="workhistory-horizontalspacing">
			<div class="workhistory-topspacing">
				<div class="content-title">
					<xsl:choose>
						<xsl:when test="@fieldType != ''">
							<xsl:call-template name="Pascalize">
								<xsl:with-param name="pText" select="name()" />
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of
								select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))"
								disable-output-escaping="yes" />
						</xsl:otherwise>
					</xsl:choose>
					<div class="seperatedline"></div>
				</div>			</div>
			<div class="work_description_section personalinfo-textedit">
				<xsl:value-of select="." disable-output-escaping="yes"/>
			</div>
		</div>
		</xsl:if>
	</xsl:template>
	<xsl:template mode="output" match="recommendation">
		<xsl:if test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
		<div class="workhistory-horizontalspacing">
			<div class="workhistory-topspacing">
				<div class="content-title">
					<xsl:choose>
						<xsl:when test="@fieldType != ''">
							<xsl:call-template name="Pascalize">
								<xsl:with-param name="pText" select="name()" />
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))" disable-output-escaping="yes"/>
						</xsl:otherwise>
					</xsl:choose>
					<div class="seperatedline"></div>
				</div>
			</div>
			Feedback not available 
		</div>
		</xsl:if>
	</xsl:template>
	<xsl:template mode="output" match="industry_type">
		<xsl:if test="(contains(concat(',',$displayField,','),concat(',','industry_type',',')))">
			<xsl:variable name="industryType">
				<xsl:value-of select="normalize-space(.)"/>
			</xsl:variable>
			<xsl:if test="$industryType!=''">
			<div class="content-title">
					<xsl:choose>
						<xsl:when test="@fieldType != ''">
							<xsl:call-template name="Pascalize">
								<xsl:with-param name="pText" select="name()" />
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of
								select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))"
								disable-output-escaping="yes" />
						</xsl:otherwise>
					</xsl:choose>
					<div class="seperatedline"></div>
				</div>
				<div class="workhistory-horizontalspacing">
					<xsl:value-of
						select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))"
						disable-output-escaping="yes" /><xsl:text>&#160;:&#160;</xsl:text>
					<xsl:value-of select="$industryType"/>
				</div>
			</xsl:if>
		</xsl:if>
	</xsl:template>
	<xsl:template mode="output" match="company_type">
		<xsl:variable name="companyType">
			<xsl:value-of select="normalize-space(.)"/>
		</xsl:variable>
		<xsl:variable name="employeeNum">
			<xsl:value-of select="normalize-space(../number_of_employees)"/>
		</xsl:variable>
		<div class="workhistory-horizontalspacing">
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','company_type',',')))">
				<xsl:if test="$companyType!=''">
				<div class="content-title">
					<xsl:choose>
						<xsl:when test="@fieldType != ''">
							<xsl:call-template name="Pascalize">
								<xsl:with-param name="pText" select="name()" />
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of
								select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))"
								disable-output-escaping="yes" />
						</xsl:otherwise>
					</xsl:choose>
					<div class="seperatedline"></div>
				</div>
					<xsl:value-of select="$companyType"/><xsl:text>&#160;Company&#160;</xsl:text>
					<xsl:text>:&#160;</xsl:text>
					<xsl:value-of select="$employeeNum"/>
					<xsl:text>&#160;&#160;employees</xsl:text>
				</xsl:if>
			</xsl:if>
			<!--<xsl:if test="(contains(concat(',',$displayField,','),concat(',','number_of_employees',',')))">
				<xsl:if test="$employeeNum!=''">
				<div class="content-title">
					<xsl:choose>
						<xsl:when test="@fieldType != ''">
							<xsl:call-template name="Pascalize">
								<xsl:with-param name="pText" select="name()" />
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of
								select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))"
								disable-output-escaping="yes" />
						</xsl:otherwise>
					</xsl:choose>
					<div class="seperatedline"></div>
				</div>
					 <xsl:text>:&#160;</xsl:text>
					<xsl:value-of select="$employeeNum"/>
					<xsl:text>&#160;employees</xsl:text> 
				</xsl:if>
			</xsl:if>-->
		</div>
	</xsl:template>
	<xsl:template mode="output" match="start_date">
		<xsl:param name="count"/>
		<xsl:variable name="startDate">
			<xsl:value-of select="normalize-space(.)"/>
		</xsl:variable>
		<xsl:variable name="endDate">
			<xsl:value-of select="normalize-space(../end_date)"/>
		</xsl:variable>
		<div class="workhistory-horizontalspacing">
		<div class="workHistory-startDate">
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','start_date',',')))">	
				<xsl:if test="$startDate != ''">
				<div class="content-title">
					<xsl:choose>
						<xsl:when test="@fieldType != ''">
							<xsl:call-template name="Pascalize">
								<xsl:with-param name="pText" select="name()" />
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of
								select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))"
								disable-output-escaping="yes" />
						</xsl:otherwise>
					</xsl:choose>
					<div class="seperatedline"></div>
				</div>
					<xsl:value-of select="$startDate"/>
				</xsl:if>
				<!-- <xsl:choose>
				  <xsl:when test="($startDate != '') and ($endDate!='')">
				  	<xsl:text>&#160;-&#160;</xsl:text> 
				  </xsl:when>
				  <xsl:when test="($startDate != '') and ($endDate='Present')">
				  	<xsl:text>&#160;till&#160;</xsl:text> 
				  </xsl:when>
				  <xsl:otherwise>
				  </xsl:otherwise>
				</xsl:choose> -->
			</xsl:if>
			</div>
			<div class="workHistory-endDate">
			<xsl:if test="(contains(concat(',',$displayField,','),concat(',','end_date',',')))">
			<xsl:if test="$endDate != ''">
			<div class="content-title">
					<xsl:choose>
						<xsl:when test="@fieldType != ''">
							<xsl:call-template name="Pascalize">
								<xsl:with-param name="pText" select="name()" />
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
						End Date*
							<!-- <xsl:value-of
								select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))"
								disable-output-escaping="yes" /> -->
						</xsl:otherwise>
					</xsl:choose>
					<div class="seperatedline"></div>
				</div>	
				<xsl:value-of select="$endDate"/> 
				</xsl:if>
			</xsl:if>
			</div>
		</div>
		<div style="display:none" class="work_history_dates">
			<input type="hidden" value="{$startDate}" id="start_date_{$count}" name="work_history_date"/>
			<input type="hidden" value="{$endDate}" id="end_date_{$count}" name="work_history_date"/>
		</div>
	</xsl:template>
	<xsl:template mode="output" match="*">
		<xsl:if test="(contains(concat(',',$displayField,','),concat(',',name(),',')))">
			<div class="workhistory-horizontalspacing">
				<div class="workhistory-topspacing">
					<div class="content-title">
						<xsl:choose>
							<xsl:when test="@fieldType != ''">
								<xsl:call-template name="Pascalize">
									<xsl:with-param name="pText" select="@label" />
								</xsl:call-template>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of
									select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))"
									disable-output-escaping="yes" />
							</xsl:otherwise>
						</xsl:choose>
						<div class="seperatedline"></div>
					</div>
				</div>
				<br />
				<div class="work_description_section">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes" />
				</div>
			</div>
		</xsl:if>
	</xsl:template>
	
	<xsl:template name="work_history_button">
	<xsl:param name="saveData"/>
		<input type="hidden" id="workhistoryList" value="{$displayField}" />
		<xsl:if test="$can_edit=1">
		<div style="{$saveData}">
			<div class="workhistory-savedata" id="workhistory_add">
				<a class="book userprofile-add-link" href="javascript:addWorkHistoryInfo('workhistory','work_details','addMultipleInput','{$displayField}')"  title="Add">&#160;</a>
			</div>
		</div>
		</xsl:if>
	</xsl:template>	
	
	<xsl:template name="requestRecommendation">
		<div class="workhistory-topspacing">
			<div class="content-title">
				[Request for Recommendations]
				<div class="seperatedline"></div>
			</div>	
		</div>
	</xsl:template>
	
		<xsl:template name="output-tokens">
      <xsl:param name="list"/>
      <xsl:choose>
      <xsl:when test="$list = ''">
      </xsl:when>
      <xsl:when test="contains($list, ',')=false()">
        <div class="workhistory-relatedprojects"><a href="#"><xsl:value-of select="$list"/></a></div>
      </xsl:when>
      <xsl:otherwise>
         <xsl:variable name="head" select="substring-before($list, ',')"/>
         <xsl:variable name="tail" select="substring-after($list, ',')"/> 
				<div class="workhistory-relatedprojects"><a href="#"><xsl:value-of select="$head"/></a></div>	
         <xsl:call-template name="output-tokens">
         <xsl:with-param name="list" select="$tail"/>
         </xsl:call-template>
      </xsl:otherwise>
      </xsl:choose>
   </xsl:template>
   <xsl:include href="dynamic_fields_template.xsl" />

   <xsl:template name="validate_Overlapping">
   		<xsl:param name="validateOverlapping"/>
   		<input type="hidden" id="isOverlapping" value="{$validateOverlapping}"/>
   </xsl:template>
</xsl:stylesheet>
