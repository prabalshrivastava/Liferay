<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="addClassActionURL" name="addClass">
</portlet:actionURL>
<portlet:renderURL portletMode="view" var="viewURL" />

<%
	Calendar curValueDate = com.liferay.portal.kernel.util.CalendarFactoryUtil
			.getCalendar(timeZone, locale);
%>
<div>
	<span class="form_Title">Create Class</span>

	<aui:form name="createClass" action="<%=addClassActionURL%>">
		<aui:fieldset>
			<div class="form_fieldset_wrap">
			
				<div class="form_field">
					<aui:input type="text" name="code" id="code" label="CLASS Code" size="100">
						  <aui:validator name="required" errorMessage="CLASS Code is required"></aui:validator>
				    </aui:input>
			    </div>
			    
			    <div class="form_dropD">
					<aui:select name="countryList" label="Country">
						<c:forEach var="country" items="${countryList}">
							<aui:option value=" ${country.categoryId}"
								label="${country.name}" />
						</c:forEach>
					</aui:select>
				</div>
				
				<div class="form_dropD">
					<aui:select name="description" label="CLASS Specifications">
						<c:forEach var="description" items="${descriptionList}">
							<aui:option value=" ${description.categoryId}"
								label="${description.name}" />
						</c:forEach>
					</aui:select>
				</div>
				
				<div class="form_field">
					<aui:input type="text" name="filedBy" id="filedBy" label="Filed By" size="100">
						  <aui:validator name="required" errorMessage="Filed By is required"></aui:validator>
				    </aui:input>
			    </div>
			    
				<div class="form_customField_wrap">
					<div class="form_field">
					    <aui:input type="text" name="customField1" id="customField1" label="Custom Field 1" size="100">
					    </aui:input>
				    </div>
				    <div class="form_field">
					    <aui:input type="text" name="customField2" id="customField2" label="Custom Field 2" size="100">
					    </aui:input>
				    </div>
			    </div>
			    
			    <div class="form_calendar_wrap form_customDate_wrap">
				   	<ul>
						<li>
							<div class="form_calendar">
								<label class="field-label">Custom Date 1</label>
								<liferay-ui:input-date
									dayValue="<%=curValueDate.get(Calendar.DATE)%>"
									dayParam="customDay1" disabled="false"
									firstDayOfWeek="<%=curValueDate.getFirstDayOfWeek() - 1%>"
									monthParam="customMonth1"
									monthValue="<%=curValueDate.get(Calendar.MONTH)%>"
									yearParam="customYear1"
									yearValue="<%=curValueDate.get(Calendar.YEAR)%>"
									yearRangeStart="<%=curValueDate.get(Calendar.YEAR) - 100%>"
									yearRangeEnd="<%=curValueDate.get(Calendar.YEAR) + 100%>"  />
							</div>	
							<div class="form_calendar">
								<label class="field-label">Custom Date 2</label>
								<liferay-ui:input-date
										dayValue="<%=curValueDate.get(Calendar.DATE)%>" 
										dayParam="customDay2"
										disabled="false"
										firstDayOfWeek="<%=curValueDate.getFirstDayOfWeek() - 1%>"
										monthParam="customMonth2"
										monthValue="<%=curValueDate.get(Calendar.MONTH)%>"
										yearParam="customYear2"
										yearValue="<%=curValueDate.get(Calendar.YEAR)%>"
										yearRangeStart="<%=curValueDate.get(Calendar.YEAR) - 100%>"
										yearRangeEnd="<%=curValueDate.get(Calendar.YEAR) + 100%>" />
							</div>
						</li>
					</ul>
				</div>
				
				<div class="form_customList_wrap">
				    <div class="form_dropD">
					    <aui:select name="customList1" label="Custom List 1">
							<c:forEach var="listEntry" items="${customList1}">
								<aui:option value=" ${listEntry.categoryId}"
									label="${listEntry.name}" />
							</c:forEach>
						</aui:select>
					</div>
					<div class="form_dropD">
						<aui:select name="customList2" label="Custom List 2">
							<c:forEach var="listEntry" items="${customList2}">
								<aui:option value=" ${listEntry.categoryId}"
									label="${listEntry.name}" />
							</c:forEach>
						</aui:select>
					</div>
				</div>
				
				<div class="form_CTA">
					<aui:button-row>
						<aui:button type="submit" name="addClass" id="addClass"
							value="Add Class" label="" />
						 <aui:button type="cancel" onClick="<%= viewURL %>" />
					</aui:button-row>
				</div>
			</div>
		</aui:fieldset>
	</aui:form>

</div>
