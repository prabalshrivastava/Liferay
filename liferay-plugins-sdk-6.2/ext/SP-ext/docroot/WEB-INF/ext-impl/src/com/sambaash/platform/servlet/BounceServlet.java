package com.sambaash.platform.servlet;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.model.aws.Message;
import com.sambaash.platform.model.aws.SNS;
import com.sambaash.platform.srv.mail.service.SPMailBlackListLocalServiceUtil;

public class BounceServlet extends HttpServlet {

	private static final long serialVersionUID = 335470382973067072L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Scanner scanner = new Scanner(request.getInputStream());
			StringBuilder builder = new StringBuilder();
			while (scanner.hasNextLine()) {
				builder.append(scanner.nextLine());
			}

			if (_log.isDebugEnabled()) {
				_log.debug(builder.toString());
			}

			SNS sns = new ObjectMapper().readValue(builder.toString(), SNS.class);
			_log.info("sns.getMessageId() : " + sns.getMessageId());
			if ("SubscriptionConfirmation".equalsIgnoreCase(sns.getType())) {
				Scanner sc = new Scanner(new URL(sns.getSubscribeURL()).openStream());
				StringBuilder sb = new StringBuilder();
				while (sc.hasNextLine()) {
					sb.append(sc.nextLine());
				}
				_log.info(">>Subscription confirmation (" + sns.getSubscribeURL() + ") Return value: " + sb.toString());
			} else if ("UnsubscribeConfirmation".equalsIgnoreCase(sns.getType())) {
				Scanner sc = new Scanner(new URL(sns.getUnsubscribeURL()).openStream());
				StringBuilder sb = new StringBuilder();
				while (sc.hasNextLine()) {
					sb.append(sc.nextLine());
				}
				_log.info(">>Unsubscription confirmation (" + sns.getUnsubscribeURL() + ") Return value: "
						+ sb.toString());
			} else if ("Notification".equalsIgnoreCase(sns.getType())) {
				Message message = new ObjectMapper().readValue(sns.getMessage(), Message.class);
				if ("Bounce".equalsIgnoreCase(message.getNotificationType())) {
					SPMailBlackListLocalServiceUtil.addBounce(sns.getMessage(), message);
				} else {
					_log.error("Received unknown message : " + sns.toString());
				}
			} else {
				_log.error("Received unknown message : " + sns.toString());
				return;
			}

		} catch (Exception e) {
			_log.error(e);
		}

	}

	private static Log _log = LogFactoryUtil.getLog(BounceServlet.class);

}

