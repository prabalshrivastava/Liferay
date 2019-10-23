<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Time" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="java.awt.BasicStroke" %>
<%@ page import="java.awt.Color" %>
<%@ page import="java.awt.Font" %>

<%@ page import="java.text.NumberFormat" %>

<%@ page import="javax.servlet.jsp.PageContext" %>

<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.plot.DialShape" %>
<%@ page import="org.jfree.chart.plot.MeterInterval" %>
<%@ page import="org.jfree.chart.plot.MeterPlot" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities" %>
<%@ page import="org.jfree.data.Range" %>
<%@ page import="org.jfree.data.general.DefaultValueDataset" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<style type="text/css">
.form {
	margin: 5px;
}
</style>

<c:choose>
	<c:when test="${authorised}">

		<c:if test="${not empty errorMsg}">
			<div class="portlet-msg-error">${errorMsg}</div>
		</c:if>

		<c:if test="${not empty successMsg}">
			<div class="portlet-msg-success">${successMsg}</div>
		</c:if>

		<%
			long uptimeDiff = System.currentTimeMillis() - PortalUtil.getUptime().getTime();
					long days = uptimeDiff / Time.DAY;
					long hours = (uptimeDiff / Time.HOUR) % 24;
					long minutes = (uptimeDiff / Time.MINUTE) % 60;
					long seconds = (uptimeDiff / Time.SECOND) % 60;

					NumberFormat numberFormat = NumberFormat.getInstance();

					numberFormat.setMaximumIntegerDigits(2);
					numberFormat.setMinimumIntegerDigits(2);
		%>

		<%!private JFreeChart _getChart(String title, MeterPlot plot) {
		JFreeChart chart = new JFreeChart(title, new Font(null, Font.PLAIN, 13), plot, true);

		chart.setBackgroundPaint(Color.white);

		chart.removeLegend();

		return chart;
	}

	private MeterPlot _getMeterPlot(DefaultValueDataset dataset, PageContext pageContext) {
		MeterPlot plot = new MeterPlot(dataset);

		plot.setDialBackgroundPaint(Color.white);
		plot.setDialShape(DialShape.PIE);
		plot.setDialOutlinePaint(Color.gray);
		plot.setTickLabelFont(new Font(null, Font.PLAIN, 10));
		plot.setTickLabelPaint(Color.darkGray);
		plot.setTickLabelsVisible(true);
		plot.setTickPaint(Color.lightGray);
		plot.setTickSize(5D);
		plot.setMeterAngle(180);
		plot.setNeedlePaint(Color.darkGray);
		plot.setRange(new Range(0.0D, 100D));
		plot.setValueFont(new Font(null, Font.PLAIN, 10));
		plot.setValuePaint(Color.black);
		plot.setUnits("%");

		plot.addInterval(new MeterInterval(LanguageUtil.get(pageContext, "normal"), new Range(0.0D, 75D),
				Color.lightGray, new BasicStroke(2.0F), new Color(0, 255, 0, 64)));
		plot.addInterval(new MeterInterval(LanguageUtil.get(pageContext, "warning"), new Range(75D, 90D),
				Color.lightGray, new BasicStroke(2.0F), new Color(255, 255, 0, 64)));
		plot.addInterval(new MeterInterval(LanguageUtil.get(pageContext, "critical"), new Range(90D, 100D),
				Color.lightGray, new BasicStroke(2.0F), new Color(255, 0, 0, 128)));

		return plot;
	} %>

		<portlet:actionURL name="gcAction" var="gcAction">
			<portlet:param name="cmd" value="gc"></portlet:param>
		</portlet:actionURL>
		<portlet:actionURL name="svmAction" var="svmAction">
			<portlet:param name="cmd" value="cacheSingle"></portlet:param>
		</portlet:actionURL>
		<portlet:actionURL name="mvmAction" var="mvmAction">
			<portlet:param name="cmd" value="cacheMulti"></portlet:param>
		</portlet:actionURL>
		<portlet:actionURL name="dbAction" var="dbAction">
			<portlet:param name="cmd" value="cacheDb"></portlet:param>
		</portlet:actionURL>
		<portlet:actionURL name="threadDumpAction" var="threadDumpAction">
			<portlet:param name="cmd" value="threadDump"></portlet:param>
		</portlet:actionURL>

		<portlet:actionURL var="reindexTrademarkAction"
			name="reindexTrademarkAction">
			<portlet:param name="cmd" value="reindexTrademark"></portlet:param>
		</portlet:actionURL>
		<portlet:actionURL var="reindexLawFirmsAction"
			name="reindexLawFirmsAction">
			<portlet:param name="cmd" value="reindexLawFirms"></portlet:param>
		</portlet:actionURL>
		<portlet:actionURL var="reindexContentiousProceedingsAction"
			name="reindexContentiousProceedingsAction">
			<portlet:param name="cmd" value="reindexContentiousProceedings"></portlet:param>
		</portlet:actionURL>
		<portlet:actionURL var="reindexSPGroupsAction"
			name="reindexSPGroupsAction">
			<portlet:param name="cmd" value="reindexSPGroups"></portlet:param>
		</portlet:actionURL>

		<liferay-ui:message key="uptime" />
:
<c:if test="<%= days > 0 %>">
			<%= days %>
			<%= LanguageUtil.get(pageContext, ((days > 1) ? "days" : "day")) %>,
</c:if>

		<%= numberFormat.format(hours) %>:<%= numberFormat.format(minutes) %>:<%= numberFormat.format(seconds) %>

		<br />
		<br />

		<%
			Runtime runtime = Runtime.getRuntime();

					numberFormat = NumberFormat.getInstance(locale);

					long usedMemory = runtime.totalMemory() - runtime.freeMemory();
		%>

		<div>

			<%
				DefaultValueDataset dataset = new DefaultValueDataset(usedMemory * 100 / runtime.totalMemory());

						MeterPlot plot = _getMeterPlot(dataset, pageContext);

						JFreeChart chart = _getChart(
								LanguageUtil.get(pageContext, "used-memory") + " / "
										+ LanguageUtil.get(pageContext, "total-memory"), plot);
			%>

			<img border="0" 
				src="<%= themeDisplay.getPathContext() %>/display_chart?filename=<%= ServletUtilities.saveChartAsPNG(chart, 280, 180, null, null) %>" alt="Display Chart"/>

			<%
				dataset = new DefaultValueDataset(usedMemory * 100 / runtime.maxMemory());

						plot = _getMeterPlot(dataset, pageContext);

						chart = _getChart(
								LanguageUtil.get(pageContext, "used-memory") + " / "
										+ LanguageUtil.get(pageContext, "maximum-memory"), plot);
			%>

			<img border="0"
				src="<%= themeDisplay.getPathContext() %>/display_chart?filename=<%= ServletUtilities.saveChartAsPNG(chart, 280, 180, null, null) %>" alt="Display Chart"/>
		</div>

		<br />

		<table class="lfr-table">
			<tr>
				<td><liferay-ui:message key="used-memory" />:</td>
				<td><%= numberFormat.format(usedMemory) %> <liferay-ui:message
						key="bytes" /></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="total-memory" />:</td>
				<td><%= numberFormat.format(runtime.totalMemory()) %> <liferay-ui:message
						key="bytes" /></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="maximum-memory" />:</td>
				<td><%= numberFormat.format(runtime.maxMemory()) %> <liferay-ui:message
						key="bytes" /></td>
			</tr>
		</table>

		<br />

		<liferay-ui:panel-container extended="<%= true %>"
			id="adminServerAdministrationActionsPanelContainer"
			persistState="<%= true %>">
			<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
				id="adminServerAdministrationActionsPanel" persistState="<%= true %>"
				title="Server Administration">
				<table class="lfr-table">
					<tr>
						<td><liferay-ui:message key="clear-the-database-cache" /></td>
						<td><aui:form action="<%= dbAction %>" name="dbActionForm">
								<aui:button name="execute" type="submit" id="dbActionId"
									value="Execute" label="" />
							</aui:form></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="clear-content-cached-by-this-vm" />
						</td>
						<td><aui:form action="<%= svmAction %>" name="svmActionForm">
								<aui:button name="execute" type="submit" id="svmActionId"
									value="Execute" label="" />
							</aui:form></td>
					</tr>
					<tr>
						<td><liferay-ui:message
								key="clear-content-cached-across-the-cluster" /></td>
						<td><aui:form action="<%= mvmAction %>" name="mvmActionForm">
								<aui:button name="execute" type="submit" id="mvmActionId"
									value="Execute" label="" />
							</aui:form></td>
					</tr>
					<tr>
						<td><liferay-ui:message
								key="run-the-garbage-collector-to-free-up-memory" /></td>
						<td><aui:form action="<%= gcAction %>" name="gcActionForm">
								<aui:button name="execute" type="submit" id="gcActionId"
									value="Execute" label="" />
							</aui:form></td>
					</tr>
				</table>
			</liferay-ui:panel>
		</liferay-ui:panel-container>

		<liferay-ui:panel-container extended="<%= true %>"
			id="reindexActionsPanelContainer" persistState="<%= true %>">
			<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
				id="reindexActionsPanel" persistState="<%= true %>" title="Indexing">
				<table class="lfr-table">
					<tr>
						<td><liferay-ui:message key="Reindex LawFirms" /></td>
						<td><aui:form name="reindexLawFirmsActionForm"
								action="<%= reindexLawFirmsAction %>">
								<aui:button type="submit" name="execute"
									id="reindexLawFirmsActionId" value="Execute" label="" />
							</aui:form></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="Reindex Trademarks" /></td>
						<td><aui:form name="reindexTrademarkActionForm"
								action="<%= reindexTrademarkAction %>">
								<aui:button type="submit" name="execute"
									id="reindexTrademarkActionId" value="Execute" label="" />
							</aui:form></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="Reindex Contentious Proceedings" /></td>
						<td><aui:form name="reindexContentiousProceedingsActionForm"
								action="<%= reindexContentiousProceedingsAction %>">
								<aui:button type="submit" name="execute"
									id="reindexContentiousProceedingsActionId" value="Execute"
									label="" />
							</aui:form></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="Reindex Groups" /></td>
						<td><aui:form name="reindexGroupsActionForm"
								action="<%= reindexSPGroupsAction %>">
								<aui:button type="submit" name="execute"
									id="reindexSPGroupsActionId" value="Execute"
									label="" />
							</aui:form></td>
					</tr>
				</table>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
	</c:when>
	<c:otherwise>
		<div class="portlet-msg-error">You are not authorised to access.</div>
	</c:otherwise>
</c:choose>
