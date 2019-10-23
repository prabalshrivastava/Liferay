package com.sambaash.platform.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sambaash.platform.constant.SambaashConstants.SPMAIL;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;

public class SPMailServlet extends HttpServlet {

	private static final long serialVersionUID = -3388280401033577301L;

	private static Log _log = LogFactoryUtil.getLog(SPMailServlet.class);

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		if(_log.isDebugEnabled()){
			_log.debug("request.getRequestURI() : " + request.getRequestURI());
		}
		
		if (request.getRequestURI().endsWith("image/gif")) {
			ServletResponseUtil.write(response, get1x1PixelGifImage());
		} else if (request.getRequestURI().endsWith("image/png")) {
			ServletResponseUtil.write(response, get1x1PixelPngImage());
		} else if (request.getRequestURI().endsWith(SPMAIL.UNSUBSCRIBE_URL)) {
//			SPMailCampaignSubscribers subscriber = (SPMailCampaignSubscribers) request.getAttribute("subscriber");
//			SPMailCampaign campaign = (SPMailCampaign) request.getAttribute("campaign");
//			SPMailUnsubscribeLocalServiceUtil.unsubscribe(subscriber, campaign);
			flushMessage(response, "Unsubscribe", "Your are successfully unsubscribed from this mailing list category.");
		} else if (request.getRequestURI().endsWith(SPMAIL.WEBVERSION_URL)) {
			SPMailCampaignSubscribers subscriber = (SPMailCampaignSubscribers) request.getAttribute("subscriber");
			SPMailCampaign campaign = (SPMailCampaign) request.getAttribute("campaign");
			String content = StringPool.BLANK;
			if (campaign != null && subscriber != null) {
				content = SPMailLocalServiceUtil.getWebversion(campaign, subscriber);
			}

			if (Validator.isNotNull(content)) {
				setHeaders(response);
				PrintWriter out = response.getWriter();
				out.println(content);
				out.flush();
			} else {
				flushMessage(response, "Error", "Webversion temporarily unavailable. Please try again later.");
			}

		} else if (request.getRequestURI().endsWith(SPMAIL.FORWARD_TO_FRIEND_URL)) {
			SPMailCampaign campaign = (SPMailCampaign) request.getAttribute("campaign");
			long fileEntryId = campaign.getDlFileEntryId();
			String imgURL = "";
			try {
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
				imgURL = PortalUtil.getPortalURL(request) + "/documents/" + fileEntry.getGroupId() + "/"
						+ fileEntry.getFolderId() + "/" + fileEntry.getTitle();
			} catch (Exception e) {

			}
			setHeaders(response);
			flushMessageForward(response, imgURL);
		} else {
			_log.error("Invalid subscriberId for camapign");
		}

	}

	private void setHeaders(HttpServletResponse response) {
		response.setContentType("text/html");
		response.setHeader("Pragma", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-cache");
	}

	private void flushMessage(HttpServletResponse response, String title, String message) throws IOException {
		setHeaders(response);
		PrintWriter out = response.getWriter();
		out.println("<head><title>" + title + "</title></head>");
		out.println("<body>");
		out.println("<div style=\"margin: 100px auto 0pt; text-align: center;\"><h2>" + message + "</h2></div>");
		out.println("</body></html>");
		out.flush();
	}

	private void flushMessageForward(HttpServletResponse response, String imgURL) throws IOException {
		PrintWriter out = response.getWriter();

		out.println("<head><title>Foward to a friend.</title></head>");
		out.println("<style>.container input { -moz-box-sizing: content-box;border: 1px solid #C5C5C5; border-radius: 5px 5px 5px 5px;color: #C5C5C5;font-size: 14px;height: 30px;");
		out.print(" margin-bottom: 7px;padding-left: 10px;padding-right: 10px;width: 300px;}");
		out.println(".container .contenteditable {");
		out.println("line-height: 1.6;padding-bottom: 20px;padding-left: 15px;width: 300px;-moz-box-sizing: content-box;border: 1px solid #C5C5C5;");
		out.println("border-radius: 5px 5px 5px 5px;color: #C5C5C5;font-size: 14px;}");
		out.println(".primary{");
		out.println("background-color: #6AAE53;background-image: linear-gradient(rgba(71, 148, 56, 0), #428F33);border-color: #579F4A #4E9340 #327527;");
		out.println("box-shadow: 0 1px 2px 0 rgba(255, 255, 255, 0.15) inset, 0 1px 1px rgba(0, 0, 0, 0.1);color: #FFFFFF;text-shadow: 0 1px 1px #488739, 0 0 5px rgba(255, 255, 255, 0);");
		out.println("font-weight:bold;padding:5px;border-radius:4px;margin-left:15px;");
		out.println("}");
		out.println("</style>");
		out.println("<body style='background-color:#f2f2f2;'>");
		out.println("<table style='border:1px solid #c5c5c5;background-color:white;' align='center' width='60%'>");
		out.println("<tbody><tr><td style='vertical-align: top; width: 30%; padding-top: 25px; padding-left: 21px;'>");
		out.println("<img src='" + imgURL + "?version=1.0&imageThumbnail=1'/>");
		out.println("</td>");
		out.println("<td style='width:70%;padding-top:30px;padding-left:15px;'>");
		out.println("<div style='padding-bottom:10px;'><span><h3>Forward to a Friend</h3></span></div>");
		out.println("<form action='' id='' name=''>");
		out.println("<div class='container'><div style='margin-bottom:15px;' id='multipleDiv'>");
		out.println("<div style='padding-left: 15px;'><span style='color:#666666;'>Who should we forward this to?</span></div>");
		out.println("<div><span style='color:#696969;font-size:12px'>1.&nbsp;</span><input type='text' value='Their name' autofocus='' name='toName1' id='to-name1'></div>");
		out.println("<div style='padding-left: 15px;'><input type='email' spellcheck='false' name='toEmail1' id='to-email1' value='and their email address'><div name='addIcon1' id='addIcon1' style='display:inline;'>");
		out.println("<a onclick='addMultiple()' style='color:#5DC9E6;font-weight:bold;font-size:16px;'>");
		out.println("+</a>");
		out.println("</div></div></div>");
		out.println("<div style='margin-bottom:15px;'>");
		out.println("<div style='margin-left:15px;'><span style='color:#666666;'>Add a message:</span></div>");
		out.println("<div style='margin-left:15px;''><textarea id='forwardMessage' name='forwardMessage'  class='contenteditable'>I just received this email and thought you might find it interesting.</textarea></div>");
		out.println("</div>");

		out.println("<div>");
		out.println("<div style='margin-left:15px;'><span style='color:#666666;'>And your details:</span></div>");
		out.println("<div style='margin-left:15px;'><input type='text' value='Their name' autofocus='' name='from-name' id='from-name'></div>");
		out.println("<div style='margin-left:15px;'><input type='email' spellcheck='false' name='toEmail1' id='to-email' value='and their email address'></div>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div><p class='buttons'><button type='submit' id='submit' class='primary'>Send email</button></p></div></form>");
		out.println("<script>");
		out.println("var count = 1;");
		out.println("function addMultiple(){");
		out.println("if(count <5){");
		out.println("count++;");
		out.println("var childDiv = document.createElement('div');childDiv.setAttribute('style','margin-top:15px');");
		out.println("var spanItem = document.createElement('span');spanItem.setAttribute('style','color:#696969;font-size:12px;')");
		out.println("var numberText = document.createTextNode(count+'. ')");
		out.println("spanItem.appendChild(numberText);childDiv.appendChild(spanItem);");
		out.println("var inputItem = document.createElement('input');inputItem.setAttribute('type','text');inputItem.setAttribute('value','Their name');");
		out.println("inputItem.setAttribute('name','toName'+count);inputItem.setAttribute('id','to-name'+count);childDiv.appendChild(inputItem);document.getElementById('multipleDiv').appendChild(childDiv);");
		out.println("childDiv = document.createElement('div');childDiv.setAttribute('style','margin-left:15px');inputItem = document.createElement('input');inputItem.setAttribute('type','email');");
		out.println("inputItem.setAttribute('value','and their email address');inputItem.setAttribute('name','toEmail'+count);inputItem.setAttribute('id','to-email'+count);childDiv.appendChild(inputItem);");
		out.println("var addIconDiv = document.createElement('div');addIconDiv.setAttribute('style','display:inline;');addIconDiv.setAttribute('id','addIcon'+count);");
		out.println("var addIcon = document.createElement('a');addIcon.setAttribute('onclick','addMultiple()');addIcon.setAttribute('style','color:#5DC9E6;font-weight:bold;font-size:16px;');var cellText = document.createTextNode('+');");
		out.println("addIcon.appendChild(cellText);addIconDiv.appendChild(addIcon);");
		
		out.println("childDiv.appendChild(addIconDiv);");
		out.println("document.getElementById('multipleDiv').appendChild(childDiv);");
		out.println("document.getElementById('addIcon'+(count-1)).style.display='none';");
		out.println("if(count==5){document.getElementById('addIcon5').style.display='none';}");
		out.println("}}");

		out.println("</script>");
		out.println("</body></html>");
		out.flush();
	}

	static byte[] trackingPng = { (byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A, 0x00, 0x00, 0x00, 0x0D, 0x49,
			0x48, 0x44, 0x52, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x01, 0x08, 0x06, 0x00, 0x00, 0x00, 0x1F, 0x15,
			(byte) 0xC4, (byte) 0x89, 0x00, 0x00, 0x00, 0x0B, 0x49, 0x44, 0x41, 0x54, 0x78, (byte) 0xDA, 0x63, 0x60,
			0x00, 0x02, 0x00, 0x00, 0x05, 0x00, 0x01, (byte) 0xE9, (byte) 0xFA, (byte) 0xDC, (byte) 0xD8, 0x00, 0x00,
			0x00, 0x00, 0x49, 0x45, 0x4E, 0x44, (byte) 0xAE, 0x42, 0x60, (byte) 0x82 };

	static byte[] trackingGif = { 0x47, 0x49, 0x46, 0x38, 0x39, 0x61, 0x1, 0x0, 0x1, 0x0, (byte) 0x80, 0x0, 0x0,
			(byte) 0xff, (byte) 0xff, (byte) 0xff, 0x0, 0x0, 0x0, 0x2c, 0x0, 0x0, 0x0, 0x0, 0x1, 0x0, 0x1, 0x0, 0x0,
			0x2, 0x2, 0x44, 0x1, 0x0, 0x3b };

	public static byte[] get1x1PixelPngImage() {
		return trackingPng; // tracking Png is about 68 bytes
	}

	public static byte[] get1x1PixelGifImage() {
		return trackingGif; // tracking Gif is about 38 bytes
	}

}
