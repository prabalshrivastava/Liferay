package com.sambaash.platform.dbutility.util;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

import com.sambaash.platform.dbutility.entity.Table;

public class FileUtil {
	private static File file;
	public final static String EXTRA_SCRIPT = "extra.sql";

	public FileUtil(String database) throws IOException {
		file = File.createTempFile("temp", ".sql");
		initFile(database);	
	}

	public void initFile(String database) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),StandardCharsets.UTF_8));
		out.append(SqlScriptUtil.generateDatabase(database));
		out.close();
	}
	
	public static void deleteFile(InputStream in) throws IOException{
		in.close();
		if(file!=null){
			file.delete();
		}
	}

	public void writeFile(Table table, int option) throws IOException, SQLException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),StandardCharsets.UTF_8));
		
		if (option == 0) {
			out.append(SqlScriptUtil.generateTable(table));
		} else if (option == 1) {
			if (table.getRowList().size() != 0) {
				out.append(SqlScriptUtil.generateTableData(table));
			}
		}
		out.close();
	}

	public static InputStream getSQLListFromExtra(DBManager dbmanager) throws IOException {
		URL url = FileUtil.class.getResource(EXTRA_SCRIPT);
		String osAppropriatePath = System.getProperty("os.name").contains("indow") ? url.getPath().substring(1) : url
				.getPath();
		byte[] encoded = Files.readAllBytes(Paths.get(osAppropriatePath));

		ByteArrayInputStream bis = new ByteArrayInputStream(encoded);
		return bis;
	}

	public InputStream readFile() throws IOException {
		InputStream in = new FileInputStream(file);
		return in;
	}
}
