package com.sambaash.platform.util;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;

public class SPHtmlUtil {
	
	 public static String shortenHtmlText(String html, int length) {
		 return html == null ? null : StringUtil.shorten(HtmlUtil.stripHtml(changeBRtoNewLine(html)), length);
	 }
	 
	 public static String shortenHtmlTextWithLink(String html, int length) {
		 return html == null ? null : StringUtil.shorten(changeBRtoNewLine(html), length);
	 }

	 public static String shortenTextToHtml(String text, int length) {
		 return text == null ? null : changeNewLineToBR(StringUtil.shorten(text, length));
	 }

	public static void main(String[] args) {
		String s = "test <br />";
		String s2 = "test 2 <bR >";
		String s3 = "test 3 <bR/>";
		String s4 = "no br";
		String s5 = s + s2 + s3 + s4;
		
		String ss =  changeBRtoNewLine(s);
		String ss2 =  changeBRtoNewLine(s2);
		String ss3 =  changeBRtoNewLine(s3);
		String ss4 =  changeBRtoNewLine(s4);
		String ss5 =  changeBRtoNewLine(s5);
	}

	public static String changeBRtoNewLine(String htmlContent) {
		return htmlContent == null ? null : htmlContent.replaceAll("(?i)<(\\s*)(br)(\\s*)(/?)>", "\n");
	}
	
	public static String changeNewLineToBR(String text2Html) {
		return text2Html==null ? null :text2Html.replaceAll("\n", "<br>");
	}
}
