/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.sambaash.platform.srv.mail.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.comparator.SPMailTemplateVersionComparator;
import com.sambaash.platform.model.MailMessage;
import com.sambaash.platform.srv.mail.NoSuchTemplateException;
import com.sambaash.platform.srv.mail.model.SPMailTemplate;
import com.sambaash.platform.srv.mail.model.impl.SPMailTemplateImpl;
import com.sambaash.platform.srv.mail.service.SPMailLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil;
import com.sambaash.platform.srv.mail.service.base.SPMailTemplateLocalServiceBaseImpl;
import com.sambaash.platform.srv.mail.service.persistence.SPMailTemplateUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * The implementation of the s p mail template local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.mail.service.SPMailTemplateLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author sambaash
 * @see com.sambaash.platform.srv.mail.service.base.SPMailTemplateLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil
 */
public class SPMailTemplateLocalServiceImpl extends SPMailTemplateLocalServiceBaseImpl {
	public void addCustomSPMailTemplate(SPMailTemplate spMailTemplate) {
		try {
			spMailTemplateLocalService.addSPMailTemplate(spMailTemplate);
			SPMailTemplateUtil.clearCache();
		} catch (SystemException e) {
			_log.error(e);
		}
	}

	public List<SPMailTemplate> findByparentTempalteId(long parentTempalteId)
			throws com.liferay.portal.kernel.exception.SystemException {
		return spMailTemplatePersistence.findByparentTempalteId(parentTempalteId);
	}

	public List<SPMailTemplate> findByStatus(boolean status)
			throws com.liferay.portal.kernel.exception.SystemException {
		return spMailTemplatePersistence.findBystatus(status);
	}

	public MailMessage getMailMessage(String parameter, long scopeGroupId, boolean hmtlFormat) {
		SPMailTemplate spMailTemplate = getSPMailTemplate(parameter, scopeGroupId);
		MailMessage message = null;

		if (spMailTemplate != null) {
			message = new MailMessage();
			message.setSubject(spMailTemplate.getSubject());

			if (hmtlFormat) {
				message.setHtmlBody(spMailTemplate.getHtmlContent());
				message.setHtmlFormat(true);
			} else {
				message.setHtmlBody(spMailTemplate.getTextContent());
				message.setHtmlFormat(false);
			}
		}

		return message;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use
	 * {@link com.sambaash.platform.srv.mail.service.SPMailTemplateLocalServiceUtil}
	 * to access the s p mail template local service.
	 */

	public SPMailTemplate getSPMailTemplate(String parameter, long scopeGroupId) {
		SPMailTemplate spMailTemplate = null;
		SPMailTemplate spMailTemplate2 = null;
		String templateId_str = SambaashUtil.getParameter(parameter, scopeGroupId);

		if (Validator.isNotNull(templateId_str)) {
			try {
				long spMailTemplateId = Long.valueOf(templateId_str);
				spMailTemplate = spMailTemplatePersistence.fetchByPrimaryKey(spMailTemplateId);

				OrderByComparator comparator = OrderByComparatorFactoryUtil.create(SPMailTemplateImpl.TABLE_NAME,
						"spMailTemplateId", false);
				spMailTemplate2 = spMailTemplatePersistence
						.findByparentTempalteId_First(spMailTemplate.getParentTempalteId(), comparator);

			} catch (Exception e) {
				if (e instanceof NoSuchTemplateException) {
					_log.info("No such mail template exist with primary key: " + templateId_str);
				} else if (e instanceof NumberFormatException) {
					_log.info("SpParameter: " + templateId_str + "can not convert to Long type");
				} else {
					_log.error(e.getMessage(), e);
				}
			}
		}

		return spMailTemplate2;
	}

	@SuppressWarnings("unchecked")
	public List<SPMailTemplate> getTemplates() throws com.liferay.portal.kernel.exception.SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SPMailTemplate.class,
				PortletClassLoaderUtil.getClassLoader("SPMail_WAR_SPMailportlet"));

		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.max("spMailTemplateId"));
		projectionList.add(ProjectionFactoryUtil.property("templateName"));
		projectionList.add(ProjectionFactoryUtil.count("versionNumber"));
		projectionList.add(ProjectionFactoryUtil.groupProperty("parentTempalteId"));
		dynamicQuery.setProjection(projectionList);
		dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(new Boolean(false)))
				.addOrder(OrderFactoryUtil.asc("templateName"));
		List<Object[]> resultsItr = SPMailTemplateLocalServiceUtil.dynamicQuery(dynamicQuery);

		List<SPMailTemplate> lstTemplate = new ArrayList<SPMailTemplate>();

		for (Object[] obj : resultsItr) {
			SPMailTemplate spMailTemplate = new SPMailTemplateImpl();
			spMailTemplate.setSpMailTemplateId(((Long) obj[0]).longValue());

			String templateName = (String) obj[1];
			String version = " v1" + ((Long) obj[2] > 1 ? ("." + (((Long) obj[2]) - 1)) : "");
			spMailTemplate.setTemplateName(templateName + version);
			spMailTemplate.setParentTempalteId(((Long) obj[3]).longValue());
			lstTemplate.add(spMailTemplate);
		}

		return lstTemplate;
	}

	public SPMailTemplate getTemplateByName(String templateName)
			throws com.liferay.portal.kernel.exception.SystemException {
	    try {
            templateName = URLDecoder.decode(templateName, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            _log.error(e1);
        }
		SPMailTemplate spMailTemplate = null;
		List<SPMailTemplate> lstTemplate = getSPMailTemplatePersistence().findByTemplateName(templateName, -1, -1,
				new SPMailTemplateVersionComparator());
		if (lstTemplate.size() > 0) {
			return lstTemplate.get(0);
		} else {
			
			String versionNumber = "8";
			try {
				spMailTemplate = getSPMailTemplatePersistence().findByTemplateNameAndVersionNumber(templateName, versionNumber);
			} catch (Exception e) {
				
			}

			if (Validator.isNull(spMailTemplate)) {
				long spMailTemplateId = CounterLocalServiceUtil.increment("SPMailTemplate.class");
				spMailTemplate = spMailTemplateLocalService.createSPMailTemplate(spMailTemplateId);
				spMailTemplate.setTemplateName(templateName);
				spMailTemplate.setSubject(templateName);
				spMailTemplate.setHtmlContent(templateName);
				spMailTemplate.setProductTypeId(0);
				spMailTemplate.setSubProductTypeId(0);
				spMailTemplate.setStatus(false);
				spMailTemplate.setCreateBy(SambaashUtil.getAdminUserId());
				spMailTemplate.setCreateDate(DateUtil.newDate());
				spMailTemplate.setGroupId(SambaashUtil.getScopeGroupId(Long.parseLong("0")));
				spMailTemplate.setCompanyId(PortalUtil.getDefaultCompanyId());
				spMailTemplate.setVersionNumber("8");
				spMailTemplate.setParentTempalteId(spMailTemplate.getSpMailTemplateId());
				spMailTemplate.setHtmlUpload(false);
				spMailTemplate = spMailTemplateLocalService.addSPMailTemplate(spMailTemplate);
			}

		}

		return spMailTemplate;
	}
	
	public SPMailTemplate getTemplateByName(long productTypeId, long subProductTypeId, String templateName)
			throws com.liferay.portal.kernel.exception.SystemException {
		SPMailTemplate spMailTemplate = null;
		List<SPMailTemplate> lstTemplate = getSPMailTemplatePersistence().findByProductTypeIdAndSubProductTypeIdAndTemplateName(productTypeId, subProductTypeId, templateName, -1, -1,
				new SPMailTemplateVersionComparator());
		if (lstTemplate.size() > 0) {
			return lstTemplate.get(0);
		} else {
			
			String versionNumber = "8";
			try {
				spMailTemplate = getSPMailTemplatePersistence().findByProductTypeIdAndSubProductTypeIdAndTemplateNameAndVersionNumber(productTypeId, subProductTypeId, templateName, versionNumber);
			} catch (Exception e) {
				
			}

			if (Validator.isNull(spMailTemplate)) {
				long spMailTemplateId = CounterLocalServiceUtil.increment("SPMailTemplate.class");
				spMailTemplate = spMailTemplateLocalService.createSPMailTemplate(spMailTemplateId);
				spMailTemplate.setTemplateName(templateName);
				spMailTemplate.setSubject(templateName);
				spMailTemplate.setHtmlContent(templateName);
				spMailTemplate.setProductTypeId(productTypeId);
				spMailTemplate.setSubProductTypeId(subProductTypeId);
				spMailTemplate.setStatus(false);
				spMailTemplate.setCreateBy(SambaashUtil.getAdminUserId());
				spMailTemplate.setCreateDate(DateUtil.newDate());
				spMailTemplate.setGroupId(SambaashUtil.getScopeGroupId(Long.parseLong("0")));
				spMailTemplate.setCompanyId(PortalUtil.getDefaultCompanyId());
				spMailTemplate.setVersionNumber("8");
				spMailTemplate.setParentTempalteId(spMailTemplate.getSpMailTemplateId());
				spMailTemplate.setHtmlUpload(false);
				spMailTemplate = spMailTemplateLocalService.addSPMailTemplate(spMailTemplate);
			}

		}

		return spMailTemplate;
	}
	
	public void sendAdHocEmaills(String userIdsStr, long templateId) {
		MailMessage msg = null;
		List<String> userIds = Arrays.asList(StringUtils.split(userIdsStr, StringPool.COMMA));
		try {
			SPMailTemplate template = SPMailTemplateLocalServiceUtil.getSPMailTemplate(templateId);

			for (String userId : SambaashUtil.emptyIfNull(userIds)) {
				if (Validator.isNumber(userId)) {
					try {
						User user = UserLocalServiceUtil.getUser(Long.parseLong(userId));
						
						_log.info("Sending email to " + user.getEmailAddress());
						
						msg = new MailMessage();
						msg.setToAddress(user.getEmailAddress());
						msg.setFromName(SambaashUtil.getEmailFromName(template.getCompanyId(), template));
						msg.setFromAddress(SambaashUtil.getEmailFromAddress(template.getCompanyId(), template));
						msg.setSubject(replaceVariables(template.getSubject(), user));
						msg.setHtmlFormat(true);
						msg.setHtmlBody(replaceVariables(template.getHtmlContent(), user));
						SPMailLocalServiceUtil.sendMail(msg);
					} catch (NumberFormatException | PortalException | SystemException e) {
						_log.error(e.getMessage());
					}
				}
			}
		} catch (PortalException | SystemException e) {
			_log.error(e.getMessage());
		}
	}
	
	private String replaceVariables(String str, User user){
		return StringUtil.replace(str,
				new String[] { "[$USER_FULL_NAME$]", "[$FIRST_NAME$]",
						"[$LAST_NAME$]", "[$EMAIL$]"},
				new String[] {user.getFullName(), user.getFirstName(), user.getLastName(),user.getEmailAddress()});
	}

	private static Log _log = LogFactoryUtil.getLog(SPMailTemplateLocalServiceImpl.class);

}