package com.sambaash.platform.thread;

public class ExamBodyThreadLocal {
	
	private static ThreadLocal<String> examBody = new ThreadLocal<> ();
	
	private ExamBodyThreadLocal() {
		// do not instantiate
	}
		
	public static void setValue(String val) {
		examBody.set(val);
	}
	
	public static String getValue() {
		return examBody.get();
	}
}
