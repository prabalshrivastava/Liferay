package com.sambaash.platform.dbutility.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.dbutility.entity.Column;
import com.sambaash.platform.dbutility.entity.Table;

public class DBManager {
	public static final String DEV_TEMP_DATABASE = "devtemp";
	public static final String DEFAULT_URL = "jdbc:mysql://";
	private String connectionString;
	private String userid;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	public static final int UPDATE_SIZE = 200;

	private static Log _log = LogFactoryUtil.getLog(DBManager.class);

	public DBManager(String server_URL, String username, String password) {
		this.connectionString = generateConnectionStr(server_URL, username, password);
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionString);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			_log.error("Error while creating SQL connection ", e);
		}
	}

	public DBManager(String server_URL, String database, String username, String password, String userid) {
		this.connectionString = generateConnectionStr(server_URL, database, username, password);
		this.userid = userid;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionString);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			_log.error("Error while creating SQL connection ", e);
		}
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			_log.error("Error while Closing SQL connection ", e);
		}
	}

	public boolean testConnection() {
		try {
			return conn.isValid(10);
		} catch (SQLException | NullPointerException e) {
			_log.error("Error while Testing SQL connection ", e);
		}
		return false;
	}

	public ArrayList<String> getAllDatabase() {
		try {
			stmt = conn.createStatement();
			ArrayList<String> databaseList = new ArrayList<String>();
			rs = stmt.executeQuery("SHOW DATABASES");
			while (rs.next()) {
				String database = rs.getString("Database");
				databaseList.add(database);
			}
			return databaseList;
		} catch (SQLException e) {
			_log.error("Error while Geting All Database in the Server", e);
		} finally {
			try {
				rs.close();
				stmt.close();
				// conn.close();
			} catch (SQLException e) {
				_log.error("Error while Geting All Database in the Server", e);
			}
		}
		return null;
	}
	

	public InputStream getDatabase(String database, String toDatabase) throws IOException {
		try {
			stmt = conn.createStatement();
			FileUtil fileUtil = new FileUtil(toDatabase);
			rs = stmt.executeQuery("SHOW TABLE STATUS");
			while (rs.next()) {
				String name = rs.getString("Name");
				String engine = rs.getString("Engine");
				String collation = rs.getString("Collation");
				ArrayList<Column> columnList = getTableSchema(name);

				Table table = new Table(name, engine, collation, columnList, null);
				MessageQueueUtil.enQueue(userid, "Start Processing " + name + " table ", 1);
				fileUtil.writeFile(table, 0);
				getTableRow(fileUtil, table);
				MessageQueueUtil.enQueue(userid, "Done processing " + name + " table ", 1);
				table = null;
			}
			MessageQueueUtil.enQueue(userid, "Done processing all table, start reading from temp.sql file.", 0);

			return fileUtil.readFile();
		} catch (SQLException e) {
			_log.error("Error while Geting All Database Info", e);
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				_log.error("Error while closing connection", e);
			}
		}
		return null;
	}

	public ArrayList<Column> getTableSchema(String table) {
		ResultSet rs1 = null;
		try {
			stmt = conn.createStatement();
			ArrayList<Column> columnList = new ArrayList<Column>();
			rs1 = stmt.executeQuery("DESCRIBE " + table + ";");
			while (rs1.next()) {
				String name = rs1.getString("Field");
				String type = rs1.getString("Type");
				boolean isNull = isNullToBoolean(rs1.getString("Null"));
				boolean isKey = isKeyToBoolean(rs1.getString("Key"));
				String defaultValue = rs1.getString("Default");
				String extra = rs1.getString("Extra");

				Column column = new Column(name, type, isNull, isKey, defaultValue, extra);
				columnList.add(column);
			}
			return columnList;
		} catch (SQLException e) {
			_log.error("Error while Geting Table Schema", e);
		} finally {
			try {
				rs1.close();
			} catch (SQLException e) {
				_log.error("Error while closing connection", e);
			}
		}
		return null;
	}

	public ArrayList<Object[]> getTableRow(FileUtil fileUtil, Table table) throws IOException {
		ResultSet rs1 = null;
		try {
			stmt = conn.createStatement();
			ArrayList<Object[]> rowList = new ArrayList<Object[]>();
			rs1 = stmt.executeQuery("SELECT * FROM " + table.getName() + ";");
			ResultSetMetaData rsmd = rs1.getMetaData();
			int columnCount = rsmd.getColumnCount();
			int rowCount = 1;
			String message = "";
			while (rs1.next()) {
				Object[] values = new Object[columnCount];
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					values[i - 1] = rs1.getObject(i);
				}
				rowList.add(values);

				if (rowCount % UPDATE_SIZE == 0) {

					message = "Inserting " + rowList.size() + " record(s) to " + table.getName();
					MessageQueueUtil.enQueue(userid, message, 2);

					table.setRowList(rowList);
					fileUtil.writeFile(table, 1);
					rowList.clear();
				}

				rowCount++;
			}
			message = "Inserting " + rowList.size() + " record(s) to " + table.getName();
			MessageQueueUtil.enQueue(userid, message, 2);

			table.setRowList(rowList);
			fileUtil.writeFile(table, 1);
			rowList.clear();

			return rowList;
		} catch (SQLException e) {
			_log.error("Error while Geting Table Row", e);
		} finally {
			try {
				rs1.close();
				// stmt.close();
				// conn.close();
			} catch (SQLException e) {
				_log.error("Error while closing connection", e);
			}
		}
		return null;
	}

	public void updateDatabase(InputStream in, String dbname) throws IOException {
		ArrayList<String> sqlList = new ArrayList<String>();
		try {
			stmt = conn.createStatement();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			StringBuilder sb = new StringBuilder();
			String line = null;
			// int rowCount = 1;
			while (br.ready()) {
				if ((line = br.readLine()) != null && !line.equals("")) {
					sb.append(line);
					if(line.endsWith(";")){
						sqlList = addToSQLList(sqlList, sb.toString());
						sb = new StringBuilder();
						if (sqlList.size() == DBManager.UPDATE_SIZE) {
							for (String sql : sqlList) {
								stmt.addBatch(sql);
							}
							stmt.executeBatch();
							MessageQueueUtil.enQueue(userid, "Loading " + sqlList.size() + " line(s) to " + dbname
									+ " database", 1);
							sqlList = new ArrayList<String>();
						}
					}
				}
			}
			for (String sql : sqlList) {
				stmt.addBatch(sql);
			}
			stmt.executeBatch();
			MessageQueueUtil.enQueue(userid, "Loading " + sqlList.size() + " line(s) to " + dbname + " database", 1);

		} catch (SQLException e) {
			_log.error("Error loading scirpt to Database in the Server", e);
		} finally {
			try {
				stmt.close();
				// conn.close();
			} catch (SQLException e) {
				_log.error("Error loading scirpt to Database in the Server", e);
			}
		}

	}

	public String getConnectionString() {
		return connectionString;
	}

	private String generateConnectionStr(String server_URL, String username, String password) {
		return server_URL + "?user=" + username + "&password=" + password;
	}

	private String generateConnectionStr(String server_URL, String database, String username, String password) {
		return server_URL + "/" + database + "?useUnicode=true&characterEncoding=UTF-8&user=" + username + "&password=" + password;
	}

	private boolean isNullToBoolean(String isNull) {
		return isNull.equals("YES") ? true : false;
	}

	private boolean isKeyToBoolean(String isKey) {
		return isKey.equals("PRI") ? true : false;
	}

	private ArrayList<String> addToSQLList(ArrayList<String> sqlList, String sql) {
		//if 2 condition met - keyword at start and ';' at end
		if(sqlList.isEmpty()){
			sqlList.add(sql);
			return sqlList;
		}
		String lastline = sqlList.get(sqlList.size() - 1);
		if(isKeywordAtStart(lastline.trim()) && lastline.endsWith(";") && isKeywordAtStart(sql.trim())){
			sqlList.add(sql);
		}
		else{
			sqlList.set(sqlList.size() - 1, lastline + "\r\n" + sql);
		}
		return sqlList;
	}
	private boolean isKeywordAtStart(String sql){
		return (sql.toUpperCase().startsWith("INSERT") || sql.toUpperCase().startsWith("CREATE")
				||sql.toUpperCase().startsWith("USE") || sql.toUpperCase().startsWith("DROP")
				|| sql.toUpperCase().startsWith("UPDATE") || sql.toUpperCase().startsWith("ALTER")
				|| sql.toUpperCase().startsWith("DELETE"));
	}

}
