package com.sambaash.platform.dbutility.entity;

import java.util.ArrayList;

public class Table {
	private String name;
	private String engine;
	private String collation;
	private ArrayList<Column> columnList;
	private ArrayList<Object[]> rowList;

	public Table(String name, String engine, String collation) {
		this.name = name;
		this.engine = engine;
		this.collation = collation;
	}

	public Table(String name, String engine, String collation, ArrayList<Column> columnList, ArrayList<Object[]> rowList) {
		super();
		this.name = name;
		this.engine = engine;
		this.collation = collation;
		this.columnList = columnList;
		this.rowList = rowList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getCollation() {
		return collation;
	}

	public void setCollation(String collation) {
		this.collation = collation;
	}

	public ArrayList<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(ArrayList<Column> columnList) {
		this.columnList = columnList;
	}

	public ArrayList<Object[]> getRowList() {
		return rowList;
	}

	public void setRowList(ArrayList<Object[]> rowList) {
		this.rowList = rowList;
	}

	public String toString() {
		return name;
	}

	public ArrayList<String> getPrimaryKey() {
		ArrayList<String> primaryKeyList = new ArrayList<String>();
		for (Column column : columnList) {
			if (column.isKey()) {
				primaryKeyList.add(column.getName());
			}
		}
		return primaryKeyList;
	}

}
