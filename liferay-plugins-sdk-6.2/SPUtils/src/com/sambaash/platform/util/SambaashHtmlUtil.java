package com.sambaash.platform.util;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

public class SambaashHtmlUtil {
	
	public static String escape(String text) {
		if (text == null) {
			return null;
		}

		if (text.length() == 0) {
			return StringPool.BLANK;
		}
		
	  	final StringBuilder result = new StringBuilder();
	    final StringCharacterIterator iterator = new StringCharacterIterator(text);
	    char character =  iterator.current();
	    while (character != CharacterIterator.DONE ){
	      if (character == '<') {
	        result.append("&lt;");
	      }
	      else if (character == '>') {
	        result.append("&gt;");
	      }
	      else if (character == '\"') {
	        result.append("&quot;");
	      }
	      else if (character == '\'') {
	        result.append("&#039;");
	      }
	      else if (character == '&') {
	         result.append("&amp;");
	      }
	      else if ((character == '\u2019')) {//right single quotation
		     result.append("&#8217;");
		  }
	      else if ((character == '\u2018')) {//left single quotation
			     result.append("&#8216;");
		  }
	      else if ((character == '\u201D')) {
			     result.append("&#8221;");//right double quotation
		  }
	      else if ((character == '\u201C')) {
			     result.append("&#8220;");//left double quotation
		  }
	      
	      else if ((character == '\u20AC')) {
			     result.append("&#8364;");//euro sign
		  }
	      else if ((character == '\u201A')) {
			     result.append("&#8218;");//SINGLE LOW-9 QUOTATION MARK
		  }
	      else if ((character == '\u201E')) {
			     result.append("&#8222;");//DOUBLE LOW-9 QUOTATION MARK
		  }
	      else if ((character == '\u2026')) {
			     result.append("&#8230;");//HORIZONTAL ELLIPSIS
		  }
	      else if ((character == '\u2020')) {
			     result.append("&#8224;");//DAGGER
		  }
	      else if ((character == '\u2021')) {
			     result.append("&#8225;");//DOUBLE DAGGER
		  }
	      else if ((character == '\u2022')) {
			     result.append("&#8226;");//BULLET
		  }
	      else if ((character == '\u2013')) {
			     result.append("&#8211;");//EN DASH
		  }
	      else if ((character == '\u2014')) {
			     result.append("&#8212;");//EM DASH
		  }
	      else if ((character == '\u02DC')) {
			     result.append("&#732;");//SMALL TILDE
		  } 
	      else if ((character == '\u2122')) {
			     result.append("&#8482;");//TRADE MARK SIGN
		  }
	      else {
	        //make sure unicode characters are filtered
	    	String str = String.valueOf(character).replace("[^\\p{L}\\p{N}]", "");
	        result.append(str);
	      }
	      character = iterator.next();
	    }
	    return result.toString();
		
	}
	
	public static String unescape(String text) {
		if (text == null) {
			return null;
		}

		if (text.length() == 0) {
			return StringPool.BLANK;
		}

		// Optimize this

		text = StringUtil.replace(text, "&lt;", "<");
		text = StringUtil.replace(text, "&gt;", ">");
		text = StringUtil.replace(text, "&amp;", "&");
		text = StringUtil.replace(text, "&#034;", "\"");
		text = StringUtil.replace(text, "&#039;", "'");
		text = StringUtil.replace(text, "&#040;", "(");
		text = StringUtil.replace(text, "&#041;", ")");
		text = StringUtil.replace(text, "&#044;", ",");
		text = StringUtil.replace(text, "&#035;", "#");
		text = StringUtil.replace(text, "&#037;", "%");
		text = StringUtil.replace(text, "&#059;", ";");
		text = StringUtil.replace(text, "&#061;", "=");
		text = StringUtil.replace(text, "&#043;", "+");
		text = StringUtil.replace(text, "&#045;", "-");
		
		return text;
	}
}
