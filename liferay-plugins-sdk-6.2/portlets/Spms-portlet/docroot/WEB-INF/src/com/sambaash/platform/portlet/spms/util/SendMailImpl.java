package com.sambaash.platform.portlet.spms.util;

/**
**/
public class SendMailImpl {
/**
	public static String createMailbody() throws Exception {

		// URL u =
		// Thread.currentThread().getContextClassLoader().getResource("");

		//
		//

		// String path= new File(u.getFile()).getParent();

		BufferedReader reader = null;

		// String templateFile1 = "/WEB-INF/resources/forgotUserName.html";

		String templateFile = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "membershipRegistration.html";

		//String templateFile  = "/Users/harini/portal6/tomcat-6.0.26/webapps/ROOT/html/portlet/login/mebershipRegistration.html";

		StringWriter writer = new StringWriter();
		VelocityEngine engine = null;
		try {

			// Output content buffer to store the parsed template content

			engine = new VelocityEngine();

			// engine.init();

			engine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
					"org.apache.velocity.runtime.log.Log4JLogChute");

			// engine.setProperty("runtime.log.logsystem.log4j.logger",
			// "velexample");

			engine.init();

			VelocityContext context = new VelocityContext();
			reader = new BufferedReader(new FileReader(templateFile));

			engine.evaluate(context, writer, "velocity template", reader);

		} catch (Exception e) {
		} finally {

			if (reader != null) {
				reader.close();
			}

			if (engine != null) {
				engine = null;
			}
		}

		// MailServiceImpl mailservice = new MailServiceImpl();

		// sendEmail(String subject, String body, String emailAddress, String
		// FullName, Long companyId)

		return writer.toString();
	}

	public static void sendEmail(String usrMpDetailsFrom, long mpId,
			User user, SocialProfile usrDetails, String portalURL, long scopeGroupId)
	{
		try {

			// * Administrators Name and Email

			String fromName = PrefsPropsUtil.getString(
					user.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
				String fromAddress = PrefsPropsUtil.getString(
					user.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			// * Recipient Name and Email

			String toName = user.getFirstName() + " " + user.getLastName();
			String toAddress = user.getEmailAddress();

			MembershipPackage mpTo =
					MembershipPackageLocalServiceUtil.getMembershipPackage(mpId);

			// * Mail Template Construction

			String mailTemplateIdParameter =
					SambaashConstants.TEMPLATE_MEMBERSHIP_UPGRADED_NOTIFICATION_ID;

			com.sambaash.platform.model.MailMessage mailMessage =
					SPMailTemplateLocalServiceUtil.getMailMessage(mailTemplateIdParameter, scopeGroupId, true);

			String subject = mailMessage.getSubject();
			String body = mailMessage.getHtmlBody();

			SubscriptionSender subscriptionSender = new SubscriptionSender();
			subscriptionSender.setBody(body);
			subscriptionSender.setCompanyId(user.getCompanyId());

			subscriptionSender.setContextAttributes(
				"[$USER_SCREEN_NAME$]", toName, "[$MEMBERSHIP_PACK_FROM$]",
				usrMpDetailsFrom, "[$MEMBERSHIP_PACK_TO$]", mpTo.getName(),
				"[$SENDER_NAME$]", fromName, "[$SENDER_EMAIL_ADDRESS$]",
				fromAddress);

			subscriptionSender.setFrom(fromAddress, fromName);
			subscriptionSender.setHtmlFormat(true);
			subscriptionSender.setMailId("user", user.getUserId());
			subscriptionSender.setSubject(subject);
			subscriptionSender.setUserId(user.getUserId());

			subscriptionSender.addRuntimeSubscribers(toAddress, toName);
			subscriptionSender.flushNotificationsAsync();
			} catch (Exception e) {
		}
	}**/

}