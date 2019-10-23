package com.sambaash.platform.dbutility.util;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.regex.Pattern;

import com.sambaash.platform.dbutility.entity.Column;
import com.sambaash.platform.dbutility.entity.Table;

public class SqlScriptUtil {
	public static String generateDatabase(String database) {
		StringBuilder sb = new StringBuilder();
		sb.append("DROP DATABASE IF EXISTS " + database + ";");
		addNewLine(sb);
		sb.append("CREATE DATABASE `" + database + "` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;");
		addNewLine(sb);
		sb.append("USE " + database + ";");
		addNewLine(sb);
		addNewLine(sb);
		return sb.toString();
	}

	public static String generateTable(Table table) {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE `" + table.getName() + "` (");
		addNewLine(sb);
		for (Column column : table.getColumnList()) {
			sb.append(column.toString());
			sb.append(",");
			addNewLine(sb);

		}
		int keyCount = table.getPrimaryKey().size();
		int i = 1;

		sb.append("PRIMARY KEY (");
		for (String primaryKey : table.getPrimaryKey()) {
			sb.append("`" + primaryKey + "`");

			if (i < keyCount) {
				sb.append(",");
			}

			i++;
		}
		sb.append(")");
		addNewLine(sb);
		sb.append(")");
		sb.append(" ENGINE = " + table.getEngine() + " DEFAULT CHARACTER SET "
				+ getCharSetFromCollation(table.getCollation()) + " COLLATE " + table.getCollation() + ";");
		addNewLine(sb);
		addNewLine(sb);
		return sb.toString();
	}

	public static String generateTableData(Table table) throws SQLException, IOException {
		StringBuilder sb = new StringBuilder();
		for (Object[] rowData : table.getRowList()) {
			sb.append("INSERT INTO `" + table.getName() + "` VALUES(");
			int index = 0;
			for (Object data : rowData) {
				sb.append(removeLine(sqlDataToString(data)));
				if (index < rowData.length - 1) {
					sb.append(",");
				}
				index++;
			}
			sb.append(");");
			
			addNewLine(sb);
		}
		if (table.getRowList().size() != DBManager.UPDATE_SIZE) {
			addNewLine(sb);
			addNewLine(sb);
		}
		return sb.toString();
	}


	private static String sqlDataToString(Object data) throws SQLException, IOException {
		if (data == null) {
			return "NULL";
		} else if (data instanceof java.lang.String || data instanceof Timestamp || data instanceof Time
				|| data instanceof Date) {
			return "'" + data.toString().replaceAll("\\\\", "\\\\\\\\").replaceAll("\'", "\\\\'") + "'";
		} else if (data instanceof byte[]) {
			byte[] byteArray = (byte[]) data;
			String dataString = new String(byteArray, StandardCharsets.UTF_8);
			return "'" + dataString + "'";
		} else if (data instanceof Blob) {
			Blob blob = (Blob) data;
			int blobLength = (int) blob.length();
			byte[] blobAsBytes = blob.getBytes(1, blobLength);
			String dataString = new String(blobAsBytes, StandardCharsets.UTF_8);
			return "'" + dataString + "'";
		} else if (data instanceof Clob) {
			Clob clob = (Clob) data;
			char[] clobVal = new char[(int) clob.length()];
			Reader r = clob.getCharacterStream();
			r.read(clobVal);
			StringWriter sw = new StringWriter();
			sw.write(clobVal);
			return "'" + String.valueOf(clobVal) + "'";
		}
		return data.toString().replaceAll("\\\\", "\\\\\\\\").replaceAll("\'", "\\\\'");
	}

	private static void addNewLine(StringBuilder sb) {
		sb.append(System.getProperty("line.separator"));
	}

	private static String getCharSetFromCollation(String collation) {
		if (collation == null) {
			return null;
		}
		return collation.split("_")[0];
	}
	private static String removeLine(String sql){
		return sql.replace("\n", "").replace("\r", "");
	}
	
	public static String removeSQLComment(String sql){
		Pattern commentPattern = Pattern.compile("/\\*.*?\\*/", Pattern.DOTALL);
		return commentPattern.matcher(sql).replaceAll("");
	}

}
