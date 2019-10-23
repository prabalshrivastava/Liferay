<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  
xmlns:java="java" 
xmlns:sputil="com.sambaash.platform.portlet.socialprofile.util.UserProfileUtil">

<xsl:param name="communityName"/>
<xsl:param name="resource" />
<xsl:param name="scopeGroupId"/>

	<xsl:template name="companyType">
	<xsl:param name="fieldName" />
		<xsl:variable name="existingValue">
			<xsl:value-of select="."/>
		</xsl:variable>		
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label" />
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</span>
		</div>
		<div class="userjobdetails-input-right-align radioField">
			<input type="radio" name="{$fieldName}_{$instance}" value="Private" id="{$fieldName}_{$instance}" class="workhistory_radio"> 
			<xsl:if test="($existingValue = 'Private')">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
			</input>Private
			<input type="radio" name="{$fieldName}_{$instance}" value="Public" id="{$fieldName}_{$instance}" class="workhistory_radio"> 
			<xsl:if test="($existingValue = 'Public')">
				<xsl:attribute name="checked">checked</xsl:attribute>
			</xsl:if>
			</input>Public
		</div>	
	</xsl:template>
	
	<xsl:template name="relatedProjects">
	<xsl:param name="fieldName" />
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label" />
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</span>
		</div>
		<div class="userjobdetails-input-right-align" >
			<xsl:for-each select="project">
				<xsl:value-of select="url" disable-output-escaping="yes" />
				<span style="margin-left:10px"></span>
			</xsl:for-each>
		</div>	
	</xsl:template>
	
	<xsl:template name="AddrelatedProjects">
	<xsl:param name="fieldName" />
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:value-of select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))"/>
			</span>	
		</div>
	</xsl:template>
	
	<xsl:template name="recommendation">
	<xsl:param name="fieldName" />
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label" />
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</span>
		</div>
		<div class="userjobdetails-input-right-align">
			Feedback is not available
		</div>	
	</xsl:template>
	
	<xsl:template name="workDescription">
	<xsl:param name="fieldName" />	
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label" />
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</span>
		</div>
		<br />
		<div class="ckeditor_alignRight">
			<textarea name="workDescription" id="{$fieldName}_{$instance}" rows="5" cols="40" class="ckeditor-textarea-workhistory personal_info_textarea">
				<xsl:value-of select="normalize-space(.)"/>
			</textarea>
		</div>	
	</xsl:template>
	
	<xsl:template name="startDate">
	<xsl:param name="fieldName" />
	<xsl:variable name="existingValue">
		<xsl:value-of select="normalize-space(.)"/>
	</xsl:variable>
				
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label" />
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</span>
		</div>
		<div class="userjobdetails-input-right-align">
				<input style="display: none"  section_name="{$fieldName}" type="text" value="{$existingValue}" class="multiple-input text_calendar_workhistory" id="{$fieldName}_{$instance}" disabled="true">
					<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
					<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
					<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
					<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
			</input>
			<input type="hidden" id="hdnStartDate" value="{$existingValue}"/>
			<div id="{$fieldName}_{$instance}_cal" />
			<div id="{$fieldName}_{$instance}_iconstatus" style="display:inline;" class="msg_tooltip" />
		</div>	
	</xsl:template>
	
	<xsl:template name="endDate">
	<xsl:param name="fieldName" />
	<xsl:variable name="existingValue">
		<xsl:value-of select="normalize-space(.)"/>
	</xsl:variable>	
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label" />
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</span>
		</div>
		<div class="userjobdetails-input-right-align">
			<div class="endDate_" style="width:100%;">
				<input style="display: none;padding-bottom:5px;" section_name="{$fieldName}" type="text" value="{$existingValue}" class="multiple-input text_calendar_workhistory" id="{$fieldName}_{$instance}" disabled="true">
					<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
					<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
					<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
					<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
				</input>
				<input type="hidden" id="hdnEndDate" value="{$existingValue}"/>
			    <div id="{$fieldName}_{$instance}_cal" />
				<div id="{$fieldName}_{$instance}_iconstatus" style="display:inline;" class="msg_tooltip"></div>
				
			</div> 
			<div class="pres_">

			<span class="content-title" style="float:left;text-align:left;padding-right:3px;display:inline-block;">Present</span>
			
			  <span style="text-align:left;">
				<input type="checkbox" value="Y" name="jobPresent"  id="{$fieldName}_{$instance}_presentBox" style="margin-top:0px;">
					<xsl:if test="($existingValue = 'Present')">
						<xsl:attribute name="checked">checked</xsl:attribute>
					</xsl:if>
				</input>
				<input type="hidden" value="on" name="_job.present" />
			</span>
			</div>
			
		</div>	
	</xsl:template>
	
	
	<xsl:template name="employees">
		<xsl:param name="loadEmployee" />
		<xsl:param name="fieldName" />
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label" />
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</span>
		</div>
		<div class="userjobdetails-input-right-align">
			<select id="{$fieldName}_{$instance}" class="workhistory-inputtemp">
			 <option selected="true">
				 <xsl:attribute name="value">
					<xsl:value-of select="normalize-space(.)"/>
				</xsl:attribute>
				<xsl:value-of select="normalize-space(.)"/>
			 </option>
				<xsl:call-template name="output-tokens">
					<xsl:with-param name="list" select="$loadEmployee" />
				</xsl:call-template>
			</select>	
		</div>		
	</xsl:template>
	<xsl:template name="industryType">
		<xsl:param name="loadIndustry" />
		<xsl:param name="fieldName" />
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label" />
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</span>
		</div>
		<div class="userjobdetails-input-right-align">
			<select id="{$fieldName}_{$instance}" class="workhistory-inputtemp">
				<option selected="true">
					<xsl:attribute name="value">
						<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					</xsl:attribute>
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
				</option>
				<xsl:call-template name="output-tokens">
					<xsl:with-param name="list" select="$loadIndustry" />
				</xsl:call-template>
			</select>	
		</div>		
	</xsl:template>	
	
	 <xsl:template name="output-tokens">
      <xsl:param name="list"/>
      <xsl:choose>
      <xsl:when test="$list = ''">
      </xsl:when>
      <xsl:when test="contains($list, ',')=false()">
         <option value="{$list}"><xsl:value-of select="$list"/></option>
      </xsl:when>
      <xsl:otherwise>
         <xsl:variable name="head" select="substring-before($list, ',')"/>
         <xsl:variable name="tail" select="substring-after($list, ',')"/>
         <option value="{$head}"><xsl:value-of select="$head"/></option>
         <xsl:call-template name="output-tokens">
         <xsl:with-param name="list" select="$tail"/>
         </xsl:call-template>
      </xsl:otherwise>
      </xsl:choose>
   </xsl:template>
   
   <xsl:template name="showWorkhistoryDefaultField">
		<xsl:param name="fieldName" />
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:value-of select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',name(),'.label'))" />
			</span>
		</div>
		<div class="userjobdetails-input-right-align">
			<xsl:variable name="existingValue">
				<xsl:value-of select="normalize-space(.)"/>
			</xsl:variable>							
			<input type="text" value="{$existingValue}" class="multiple-input" name="{$fieldName}" id="{$fieldName}_{$instance}">
				<xsl:attribute name="validation_key"><xsl:apply-templates mode="ValidationKey" select="."/></xsl:attribute>
				<xsl:attribute name="mandatory"><xsl:apply-templates mode="Mandatory" select="."/></xsl:attribute>
				<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
				<xsl:attribute name="maxlength"><xsl:apply-templates mode="MaxLength" select="."/></xsl:attribute>
			</input>
			<div id="{$fieldName}_{$instance}_iconstatus" class="msg_tooltip" />
		</div>
	</xsl:template>
	
	<!-- Validation templates -->
	<!--1: integer, 2:alpha-numeric, 3:url, 4:phone, 5:email, 6: letters -->
	<xsl:template mode="ValidationKey" match="company_url">3</xsl:template>
	<xsl:template mode="ValidationKey" match="*">0</xsl:template>
	<xsl:template mode="Mandatory" match="job_title|company_name|company_url|start_date">true</xsl:template>
	<xsl:template mode="Mandatory" match="*">false</xsl:template>
	<xsl:template mode="Size" match="*">47</xsl:template>
	<xsl:template mode="MaxLength" match="job_title|company_name|company_url">1000</xsl:template>
	<xsl:template mode="MaxLength" match="*">75</xsl:template>

	<xsl:template name="showWorkhistoryField">
		<xsl:param name="fieldName" />
		<div class="userjobdetails-input-left-align">
			<span class="content-title">
				<xsl:choose>
					<xsl:when test="@fieldType != ''">
						<xsl:call-template name="Pascalize">
							<xsl:with-param name="pText" select="@label" />
						</xsl:call-template>
						<xsl:if test="@mandatory='true'">*</xsl:if>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of
							select="java:getString($resource,concat($communityName,'.userprofile.workhistory.',$fieldName,'.label'))" />
					</xsl:otherwise>
				</xsl:choose>
			</span>
		</div>
		<xsl:choose>
			<xsl:when test="@fieldType = 'TextArea'">
				<xsl:call-template name="showWorkhistoryTextArea">
					<xsl:with-param name="fieldValue" select="normalize-space(.)"/>
					<xsl:with-param name="fieldName" select="$fieldName"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'CKEditor'">
				<xsl:call-template name="showWorkhistoryCKEditor">
					<xsl:with-param name="fieldValue" select="normalize-space(.)"/>
					<xsl:with-param name="fieldName" select="$fieldName"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'Dropdown'">
				<xsl:call-template name="showDropdown">
					<xsl:with-param name="fieldValue" select="normalize-space(.)"/>
					<xsl:with-param name="fieldName" select="$fieldName"/>
					<xsl:with-param name="mandatory" select="@mandatory"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'MultipleList'">
				<xsl:call-template name="showMultipleList">
					<xsl:with-param name="fieldValue" select="normalize-space(.)"/>
					<xsl:with-param name="fieldName" select="$fieldName"/>
					<xsl:with-param name="mandatory" select="@mandatory"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'Radio'">
				<xsl:call-template name="showWorkhistoryRadio">
					<xsl:with-param name="fieldValue" select="normalize-space(.)"/>
					<xsl:with-param name="fieldName" select="$fieldName"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="@fieldType = 'Calendar'">
					<xsl:call-template name="showWorkhistoryCalendar">
						<xsl:with-param name="fieldValue" select="normalize-space(.)"/>
						<xsl:with-param name="fieldName" select="$fieldName"/>
					</xsl:call-template>
			</xsl:when>
			<xsl:otherwise><!-- TextField default-->
				<xsl:call-template name="showWorkhistoryTextField">
					<xsl:with-param name="fieldValue" select="normalize-space(.)"/>
					<xsl:with-param name="fieldName" select="$fieldName"/>
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="showWorkhistoryTextArea">
		<xsl:param name="fieldValue" />
		<xsl:param name="fieldName" />
		<div class="userjobdetails-input-right-align">
			<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{$fieldName}_{$instance}" id="{$fieldName}_{$instance}" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
					<textarea name="{$fieldName}_{$instance}_textarea" id="{$fieldName}_{$instance}" rows="5" cols="40" class="personal_info_textarea">
						<!--  <xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
						<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
						<xsl:attribute name="editorType"></xsl:attribute>
						-->
						<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
						<xsl:attribute name="editorType"></xsl:attribute>
						<xsl:value-of select="normalize-space(.)"/>
					</textarea>
					<div id="{$fieldName}_{$instance}_iconstatus" class="msg_tooltip" />
				</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>
	<xsl:template name="showWorkhistoryTextField">
		<xsl:param name="fieldValue" />
		<xsl:param name="fieldName" />
		<div class="userjobdetails-input-right-align">
			<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{$fieldName}_{$instance}" id="{$fieldName}_{$instance}" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
					<input type="text" value="{$fieldValue}" class="multiple-input"
						name="jobTitle" id="{$fieldName}_{$instance}">
						<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
						<xsl:attribute name="size"><xsl:apply-templates mode="Size" select="."/></xsl:attribute>
					</input>
					<div id="{$fieldName}_{$instance}_iconstatus" class="msg_tooltip" />
				</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>
	<xsl:template name="showWorkhistoryCKEditor">
		<xsl:param name="fieldValue" />
		<xsl:param name="fieldName" />
		<div class="ckeditor_alignRight">
			<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{$fieldName}_{$instance}" id="{$fieldName}_{$instance}" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
					<textarea name="{$fieldName}_{$instance}" id="{$fieldName}_{$instance}" rows="5" cols="40" class="ckeditor-textarea-workhistory personal_info_textarea">
						<!--  <xsl:value-of select="$fieldValue"
							disable-output-escaping="yes" />
						<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
						<xsl:attribute name="editorType">CKEditor</xsl:attribute>-->
						
						<xsl:attribute name="validation_key"><xsl:value-of select="@validation" /></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:value-of select="@mandatory" /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:value-of select="@maxLen" /></xsl:attribute>
						<xsl:attribute name="editorType">CKEditor</xsl:attribute>
						<xsl:value-of select="normalize-space(.)"/>
					</textarea>
					<div id="{$fieldName}_{$instance}_iconstatus" class="msg_tooltip" />
				</xsl:otherwise>
			</xsl:choose>
		</div>	
	</xsl:template>

	<xsl:template name="showWorkhistoryRadio">
		<xsl:param name="fieldValue" />
		<xsl:param name="fieldName" />
		<xsl:variable name="mandatory" select="@mandatory"/>
		<xsl:variable name="validation_key" select="@validation_key"/>
		<xsl:variable name="optionId" select="@optionId"/>
		<div class="userjobdetails-input-right-align">
			<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{$fieldName}_{$instance}" id="{$fieldName}_{$instance}" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="sputil:getRadioFields($optionId,$fieldName,$instance,$fieldValue,$mandatory,$validation_key,$scopeGroupId)" disable-output-escaping="yes"/>
					<div id="{$fieldName}_{$instance}_iconstatus" class="msg_tooltip" />
				</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>
	
	<xsl:template name="showWorkhistoryCalendar">
		<xsl:param name="fieldValue" />
		<xsl:param name="fieldName" />
		<div class="userjobdetails-input-right-align">
			<xsl:choose>
				<xsl:when test="@edittable='false'">
					<xsl:value-of select="normalize-space(.)" disable-output-escaping="yes"/>
					<input type="hidden" name="{$fieldName}_{$instance}" id="{$fieldName}_{$instance}" value="{.}"/>
				</xsl:when>
				<xsl:otherwise>
					<input style="display: none" type="text" value="{$fieldValue}" class="multiple-input text_calendar_workhistory"
						name="workhistoryCalendar" id="{$fieldName}_{$instance}">
						<xsl:attribute name="validation_key"><xsl:apply-templates
							mode="ValidationKey" select="." /></xsl:attribute>
						<xsl:attribute name="mandatory"><xsl:apply-templates
							mode="Mandatory" select="." /></xsl:attribute>
						<xsl:attribute name="size"><xsl:apply-templates
							mode="Size" select="." /></xsl:attribute>
						<xsl:attribute name="maxlength"><xsl:apply-templates
							mode="MaxLength" select="." /></xsl:attribute>
					</input>
					<div id="{$fieldName}_{$instance}_cal" />
					<div id="{$fieldName}_{$instance}_iconstatus" style="display:inline;" class="msg_tooltip" />
				</xsl:otherwise>
			</xsl:choose>
		</div>
	</xsl:template>

	<xsl:template name="showDropdown">
		<xsl:param name="fieldValue" />
		<xsl:param name="fieldName" />
		<xsl:param name="mandatory" />
		<xsl:variable name="optionId" select="@optionId"/>
		<xsl:variable name="level" select="@level"/>
		<div class="userjobdetails-input-right-align">
			<xsl:value-of select="sputil:getSelectOptionList($optionId,$fieldName,$instance,$fieldValue,'work_history',$mandatory,$scopeGroupId,$level)" disable-output-escaping="yes"/>
			<div id="{$fieldName}_{$instance}_iconstatus" class="msg_tooltip" />
		</div>
    </xsl:template>
    
    <xsl:template name="showMultipleList">
		<xsl:param name="fieldValue" />
		<xsl:param name="fieldName" />
		<xsl:param name="mandatory" />
		<xsl:variable name="optionId" select="@optionId"/>
		<div class="userjobdetails-input-right-align">
			<xsl:value-of select="sputil:getSelectMultipleList($optionId,$fieldName,$instance,$fieldValue,'work_history',$mandatory,$scopeGroupId)" disable-output-escaping="yes"/>
			<div id="{$fieldName}_{$instance}_iconstatus" class="msg_tooltip" />
		</div>
    </xsl:template>
    
	<xsl:template name="requestRecommendation">
	<div class="workhistory_recommendation">
				<span class="content-title">
					[Request for Recommendations]
				</span>	
			</div>
	</xsl:template>
	<xsl:template name="removeWorkDetails">
		<div class="workhistory-buttonalign" id="workhistory_Button_{$instance}">
			<a class="book userprofile-delete-link"
				href="javascript:removeGroupInput('workhistory','work_details','{$instance}','{$displayField}')"
				style="float:right">&#160;</a>
		</div>
	</xsl:template>
	
	
    
	<xsl:include href="dynamic_fields_template.xsl" />
</xsl:stylesheet>
