package com.sambaash.platform.exception;

public class FileFormatException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final int FILE_TYPE_EXCEPTION = 1;

	public static final int METADATA_EXCEPTION = 2;

	public static final int METADATA_MISMATCH_EXCEPTION = 3;
	
	public static final int COLUMN_NOT_FOUND_IN_METADATA = 4;
	
	public static final int DUPLICATE_COLUMN_NAME_IN_METADATA = 5;
	
	public static final int DUPLICATE_COLUMN_NAME_IN_USERDATA = 6;
	
	public static final int COLUMN_COUNT_NOT_EQUAL = 7;
	
	public static final int FIXED_COLUMN_EXCEPTION = 8;

	private int _type;

	public FileFormatException(int type) {
		_type = type;
	}

	public int getType() {
		return _type;
	}

}
