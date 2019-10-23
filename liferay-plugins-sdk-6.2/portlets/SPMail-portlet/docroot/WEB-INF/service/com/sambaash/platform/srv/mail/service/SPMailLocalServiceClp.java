/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.mail.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author gauravvijayvergia
 * @generated
 */
public class SPMailLocalServiceClp implements SPMailLocalService {
	public SPMailLocalServiceClp(InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "appendTracker";

		_methodParameterTypes3 = new String[] { "java.lang.String" };

		_methodName4 = "decryptLink";

		_methodParameterTypes4 = new String[] { "java.lang.String" };

		_methodName5 = "encryptLink";

		_methodParameterTypes5 = new String[] { "java.lang.String" };

		_methodName6 = "getLinksFromHtml";

		_methodParameterTypes6 = new String[] { "java.lang.String" };

		_methodName7 = "getMailBody";

		_methodParameterTypes7 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailCampaign", "int"
			};

		_methodName8 = "getMailSubject";

		_methodParameterTypes8 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailCampaign", "int"
			};

		_methodName9 = "getProcessedContent";

		_methodParameterTypes9 = new String[] {
				"java.lang.String",
				"com.sambaash.platform.srv.mail.model.SPMailCampaign", "long",
				"long"
			};

		_methodName10 = "getWebversion";

		_methodParameterTypes10 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailCampaign",
				"com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers"
			};

		_methodName11 = "processMailBodyParameters";

		_methodParameterTypes11 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers",
				"java.lang.String", "java.lang.String"
			};

		_methodName12 = "processMailBodyParameters";

		_methodParameterTypes12 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers",
				"java.lang.String", "java.lang.String", "boolean"
			};

		_methodName13 = "sendMail";

		_methodParameterTypes13 = new String[] {
				"com.sambaash.platform.model.MailMessage"
			};

		_methodName14 = "sendMail";

		_methodParameterTypes14 = new String[] {
				"com.sambaash.platform.srv.mail.model.SPMailCampaign",
				"com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers",
				"java.util.List", "long", "boolean"
			};

		_methodName15 = "testTemplate";

		_methodParameterTypes15 = new String[] { "long" };
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.lang.String appendTracker(java.lang.String content) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(content) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String decryptLink(java.lang.String link) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] { ClpSerializer.translateInput(link) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String encryptLink(java.lang.String link) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(link) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String[] getLinksFromHtml(java.lang.String content) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] { ClpSerializer.translateInput(content) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String[])ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getMailBody(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign,
		int spMailType) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						ClpSerializer.translateInput(spMailCampaign),
						
					spMailType
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getMailSubject(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign,
		int spMailType) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] {
						ClpSerializer.translateInput(spMailCampaign),
						
					spMailType
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getProcessedContent(java.lang.String content,
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign,
		long subscriberId, long edmId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						ClpSerializer.translateInput(content),
						
					ClpSerializer.translateInput(campaign),
						
					subscriberId,
						
					edmId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getWebversion(
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] {
						ClpSerializer.translateInput(campaign),
						
					ClpSerializer.translateInput(subscriber)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String processMailBodyParameters(
		java.lang.String subject, java.lang.String content, long rsvpId,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		java.lang.String fromName, java.lang.String fromAddress) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] {
						ClpSerializer.translateInput(subject),
						
					ClpSerializer.translateInput(content),
						
					rsvpId,
						
					ClpSerializer.translateInput(subscriber),
						
					ClpSerializer.translateInput(fromName),
						
					ClpSerializer.translateInput(fromAddress)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String processMailBodyParameters(
		java.lang.String subject, java.lang.String content, long rsvpId,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		java.lang.String fromName, java.lang.String fromAddress,
		boolean webVersion) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] {
						ClpSerializer.translateInput(subject),
						
					ClpSerializer.translateInput(content),
						
					rsvpId,
						
					ClpSerializer.translateInput(subscriber),
						
					ClpSerializer.translateInput(fromName),
						
					ClpSerializer.translateInput(fromAddress),
						
					webVersion
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String sendMail(
		com.sambaash.platform.model.MailMessage mailMessage) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13,
					new Object[] { ClpSerializer.translateInput(mailMessage) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String sendMail(
		com.sambaash.platform.srv.mail.model.SPMailCampaign campaign,
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers subscriber,
		java.util.List<com.liferay.mail.model.FileAttachment> attachments,
		long scopeGroupId, boolean ccEmail) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14,
					new Object[] {
						ClpSerializer.translateInput(campaign),
						
					ClpSerializer.translateInput(subscriber),
						
					ClpSerializer.translateInput(attachments),
						
					scopeGroupId,
						
					ccEmail
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void testTemplate(long templateId) {
		try {
			_invokableLocalService.invokeMethod(_methodName15,
				_methodParameterTypes15, new Object[] { templateId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private InvokableLocalService _invokableLocalService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
}