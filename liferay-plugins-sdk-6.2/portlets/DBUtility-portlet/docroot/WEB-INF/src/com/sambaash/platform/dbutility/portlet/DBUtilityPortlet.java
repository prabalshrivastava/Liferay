package com.sambaash.platform.dbutility.portlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.RoleConstants;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.dbutility.util.DBManager;
import com.sambaash.platform.dbutility.util.FileUtil;
import com.sambaash.platform.dbutility.util.MessageQueueUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class DBUtilityPortlet
 */
public class DBUtilityPortlet extends MVCPortlet {
	public static final String FORMOPTION_CONFIGURE = "CONFIGURE";
	public static final String FORMOPTION_POST = "POST";
	public static final String FORMOPTION_POLL = "POLL";
	public static final String COMPLETED_STRING = "Done uploading SQL script.";
	public static final String RESTRICTED_MSG = "You are not authorize to access!";

	private static Log log = LogFactoryUtil.getLog(DBUtilityPortlet.class);

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		if (!resourceRequest.isUserInRole(RoleConstants.ADMINISTRATOR)) {
			PrintWriter out = resourceResponse.getWriter();
			out.print(RESTRICTED_MSG);
			out.flush();
		} else {
			String option = ParamUtil.getString(resourceRequest, "formOption");
			String userid = resourceRequest.getRemoteUser();
			if (option.equals(FORMOPTION_CONFIGURE)) {
				String server_URL = ParamUtil.getString(resourceRequest, "server_URL");
				String username = ParamUtil.getString(resourceRequest, "username");
				String password = ParamUtil.getString(resourceRequest, "password");

				DBManager dbmanager = new DBManager(server_URL, username, password);

				resourceResponse.setContentType("application/json");
				PrintWriter out = resourceResponse.getWriter();
				JSONObject jsonObject = new JSONObject();

				try {
					jsonObject.put("status", dbmanager.testConnection());

				} catch (JSONException e) {
					log.error(e.getMessage());
				}
				out.print(jsonObject.toString());
				out.flush();
			} else if (option.equals(FORMOPTION_POST)) {
				PortletPreferences prefs = resourceRequest.getPreferences();
				String server_URL = prefs.getValue("server_URL_PrefKey", DBManager.DEFAULT_URL);
				String username = prefs.getValue("username_PrefKey", StringPool.BLANK);
				String password = prefs.getValue("password_PrefKey", StringPool.BLANK);

				String database = ParamUtil.getString(resourceRequest, "databaseDropdown");

				MessageQueueUtil.deQueue(userid);// Clear Queue

				MessageQueueUtil.enQueue(userid, "Start query " + database + " database", 0);
				DBManager dbmanager = new DBManager(server_URL, database, username, password, userid);
				InputStream in = dbmanager.getDatabase(database, DBManager.DEV_TEMP_DATABASE);

				MessageQueueUtil.enQueue(userid, "Done reading temp.sql file, start loading temp.sql file to "
						+ DBManager.DEV_TEMP_DATABASE + " database", 0);

				dbmanager.updateDatabase(in, DBManager.DEV_TEMP_DATABASE);

				FileUtil.deleteFile(in);

				MessageQueueUtil.enQueue(userid, "Done loading temp.sql file to " + DBManager.DEV_TEMP_DATABASE
						+ " database, start reading " + FileUtil.EXTRA_SCRIPT, 0);
				in = FileUtil.getSQLListFromExtra(dbmanager);

				MessageQueueUtil.enQueue(userid, "Done reading " + FileUtil.EXTRA_SCRIPT + " file, start loading "
						+ FileUtil.EXTRA_SCRIPT + " file to " + DBManager.DEV_TEMP_DATABASE + " database", 0);
				dbmanager.updateDatabase(in, DBManager.DEV_TEMP_DATABASE);

				MessageQueueUtil.enQueue(userid, "Done loading " + FileUtil.EXTRA_SCRIPT + " file to "
						+ DBManager.DEV_TEMP_DATABASE + " database", 0);

				MessageQueueUtil.enQueue(userid, "Start query " + DBManager.DEV_TEMP_DATABASE + " database", 0);
				in = dbmanager.getDatabase(DBManager.DEV_TEMP_DATABASE, database);
				dbmanager.closeConnection();

				resourceResponse.setContentType("text/plain");
				resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION,
						"attachment;filename=" + database + ".sql");
				OutputStream out = resourceResponse.getPortletOutputStream();
				IOUtils.copy(in, out);
				out.flush();
				FileUtil.deleteFile(in);

				MessageQueueUtil.enQueue(userid, COMPLETED_STRING, 0);

			} else if (option.equals(FORMOPTION_POLL)) {
				String message = MessageQueueUtil.deQueue(userid);
				resourceResponse.setContentType("application/json");
				PrintWriter out = resourceResponse.getWriter();
				JSONObject jsonObject = new JSONObject();

				try {
					jsonObject.put("message", message);

				} catch (JSONException e) {
					log.error(e.getMessage());
				}
				out.print(jsonObject.toString());
				out.flush();
			}
		}

	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {
		if (!renderRequest.isUserInRole(RoleConstants.ADMINISTRATOR)) {
			PrintWriter out = renderResponse.getWriter();
			out.print(RESTRICTED_MSG);
			out.flush();
		} else {
			PortletPreferences prefs = renderRequest.getPreferences();
			String server_URL = prefs.getValue("server_URL_PrefKey", DBManager.DEFAULT_URL);
			String username = prefs.getValue("username_PrefKey", StringPool.BLANK);
			String password = prefs.getValue("password_PrefKey", StringPool.BLANK);

			DBManager dbmanager = new DBManager(server_URL, username, password);

			boolean connectionStatus = dbmanager.testConnection();
			if (connectionStatus) {
				renderRequest.setAttribute("databaseList", dbmanager.getAllDatabase());
			}

			prefs.setValue("connectionStatus", connectionStatus + "");

			super.render(renderRequest, renderResponse);
		}
	}

}
