package com.sambaash.platform.product.util;

import java.util.List;

import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.Persona;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.PersonaLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;

public class SPPersonnaUtil {

	private static Log _log = LogFactoryUtil.getLog(SPPersonnaUtil.class);

	public static JSONObject addPersonna(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {

			response.put("process", "create");
			String spCourseId = resourceRequest.getParameter("spCourseId");
			String personaCourseDesc = resourceRequest.getParameter("personaCourseDesc");
			String prsnInstancesCount = resourceRequest.getParameter("prsnInstancesCount");
			if (Validator.isNotNull(spCourseId)) {
				List<Persona> personaList = PersonaLocalServiceUtil.findByCourseIdAndGroupId(
						Long.parseLong(spCourseId), themeDisplay.getScopeGroupId());
				if (!personaList.isEmpty()) {
					for (Persona psn : personaList) {
						PersonaLocalServiceUtil.deletePersona(psn.getSpPersonaId());
					}
					response.put("process", "update");
				}

				Course course = CourseLocalServiceUtil.getCourse(Long.parseLong(spCourseId));
				course.setPersonaDesc(personaCourseDesc);
				CourseLocalServiceUtil.updateCourse(course);
			}

			for (int i = 0; i < Long.parseLong(prsnInstancesCount); i++) {
				String personaTypeList = ParamUtil.getString(resourceRequest, "personaTypeList_" + i);
				String personaDesc = ParamUtil.getString(resourceRequest, "personaAttendanceDesc_" + i);
				long personaImgFeId = ParamUtil.getLong(resourceRequest, "attendAttachment_" + i);
				long personaId = 0;
				try {
					if (Validator.isNull(personaTypeList) && (Validator.isNull(personaImgFeId))) {

						_log.error("Will skip the saving of personna instance as it is empty.");

					} else {
						personaId = CounterLocalServiceUtil.increment("Persona.class");
						Persona persona = PersonaLocalServiceUtil.createPersona(personaId);

						persona.setSpPersonaId(personaId);
						persona.setCompanyId(themeDisplay.getCompanyId());
						persona.setGroupId(themeDisplay.getScopeGroupId());
						persona.setUserId(themeDisplay.getUserId());
						persona.setUserName(themeDisplay.getUser().getFullName());
						persona.setCreateDate(DateUtil.newDate());

						if (Validator.isNumber(personaTypeList)) {
							persona.setPersonaType(Long.parseLong(personaTypeList));
						}
						if (Validator.isNumber(spCourseId)) {
							persona.setSpCourseId(Long.parseLong(spCourseId));
						}
						persona.setPersonaDesc(personaDesc);

						if (personaImgFeId > 0) {
							persona.setPersonaImageId(personaImgFeId);
							FileUtil.moveFileToPersonaFolder(resourceRequest, personaImgFeId);
						}

						PersonaLocalServiceUtil.updatePersona(persona);
					}

				} catch (SystemException e) {
					_log.error(e);
				}
			}

			PersonaLocalServiceUtil.clearCache();

			_log.error("Added Personna!!!!!!!!!!");
			response.put("saveFlag", "success");

		} catch (Exception e) {
			_log.error(e);
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.persona.save.error"));
		}

		return response;
	}

}
