package com.sambaash.platform.product.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.UnicodeFormatter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.sambaash.platform.srv.NoSuchCourseCareerException;
import com.sambaash.platform.srv.model.CourseCareer;
import com.sambaash.platform.srv.model.StudyOption;
import com.sambaash.platform.srv.service.CourseCareerLocalServiceUtil;
import com.sambaash.platform.srv.service.StudyOptionLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.ThumbnailUtil;

public class SPCareerUtil {

	private static Log _log = LogFactoryUtil.getLog(SPCareerUtil.class);
	
	
	public static String PARAM_STUDY_OPTION_ID = "studyOptionId";
	public static String PARAM_INTRO = "intro";
	
	public static JSONObject deleteStudyOption(PortletRequest portletRequest, PortletResponse portletResponse)  {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		long id = ParamUtil.getLong(portletRequest, PARAM_STUDY_OPTION_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {
			StudyOptionLocalServiceUtil.deleteStudyOption(id);
		} catch (PortalException | SystemException e) {
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.study.option.error"));
		}
		return response;
	}
	public static JSONObject createUpdateCareerDetails(ResourceRequest resourceRequest, ResourceResponse resourceResponse)  {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		long spCourseId = ParamUtil.getLong(resourceRequest,"spCourseId");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		response.put("process", "create");
		try {
			if (spCourseId > 0) {
				CourseCareer career = null;
				try {
					career = CourseCareerLocalServiceUtil.findByCourseId(spCourseId);
					if(Validator.isNotNull(career)){
						response.put("process", "update");
					}
				} catch (NoSuchCourseCareerException e) {
					// it's a create
					_log.debug("Course career doesn't exist for course id " + spCourseId + ". So create one now");
					career = CourseCareerLocalServiceUtil.create();
					career.setSpCourseId(spCourseId);
				}
				// fill audit fields
				SambaashUtil.fillAudit(career, themeDisplay, career.isNew());
				career.setIntro(ParamUtil.getString(resourceRequest, "intro"));
				
				CourseCareerLocalServiceUtil.updateCourseCareer(career);
			
				try {
					createUpdateStudyOptions(spCourseId, resourceRequest, response);
				} catch (PortalException e) {
					response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.study.option.error"));
				}
			}else{
				// it cannot exist without course.. Course must exist
				response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.course.not.exist"));
				_log.error(LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.invalid.courseId"));
			}
		} catch (SystemException e) {
			_log.error(e);
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.careerDetail.save.error"));
		}
		
		return response;
	}
	
	public static void createUpdateStudyOptions(long spCourseId,PortletRequest request, JSONObject response) throws SystemException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long count = ParamUtil.getLong(request, "studyOptioncount");
		long studyOptionId;
		StudyOption studyOption = null;
		boolean create ;
		String idParam;
		JSONArray options = JSONFactoryUtil.createJSONArray();
		JSONObject option ;
		for(int i= 1 ; i<=count ; i++){
			option = JSONFactoryUtil.createJSONObject();
			if(ParamUtil.getLong(request, "counter_"+i) <= 0){ // check for corresponding row data exists or not
				continue;
			}
			idParam = "studyOptionId_" + i;
			studyOptionId = ParamUtil.getLong(request,idParam );
			create = true;
			if(studyOptionId > 0){
				create = false;
				studyOption = StudyOptionLocalServiceUtil.getStudyOption(studyOptionId);
			}
			if(create){
				studyOption = StudyOptionLocalServiceUtil.create();
				studyOption.setSpCourseId(spCourseId);
			}
			// fill audit
			SambaashUtil.fillAudit(studyOption, themeDisplay, studyOption.isNew());
			
			studyOption.setTitle(ParamUtil.getString(request, "title_"+i));
			studyOption.setDesc(ParamUtil.getString(request, "studyOptionDesc_"+i));
			long fileId = ParamUtil.getLong(request, "coverImageId_" + i);
			studyOption.setCoverImageFileEntryId(fileId);
			// file was saved initially to temp - it needs to move to actual folder
			FileUtil.moveFileToCareerFolder(request, fileId);

			StudyOptionLocalServiceUtil.updateStudyOption(studyOption);

			// indication to client that corresponding study option saved successfully.
			option.put("counter", i);
			option.put(PARAM_STUDY_OPTION_ID, studyOption.getSpStudyOptionId());
			options.put(option);
			
		}
		// for subsequent updates without page refresh, these durationtype id's must be preserved
		response.put("studyOptions",options);
	}
	
	private static String getUnicodeString(String str){
//		return GetterUtil.getString(str);
		return UnicodeFormatter.toString(GetterUtil.getString(str));
	}
	// for edit page
	public static void loadCareerDetails(RenderRequest renderRequest) throws  SystemException{
		long courseId = ParamUtil.getLong(renderRequest,"spCourseId");
		Map<String,String>map = new HashMap<>();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) renderRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		String defaultTitle = "Add a Title (Eg: 'Choose Your Study Options:')";
		defaultTitle = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.study.option");
		if (courseId > 0) {
			loadCareerData(courseId, map,defaultTitle);
			loadStudyOptionData(renderRequest, courseId, map);
		}else{
		 // this case handled in jsp, there shouldn't be this case
		}
		renderRequest.setAttribute("career", map);
	}
	// for edit page
	private static void loadCareerData(long courseId, Map<String, String> map,String defaultTitle)
			throws SystemException {
		String DESC_DEFAULT = defaultTitle;
		try {
			CourseCareer career = CourseCareerLocalServiceUtil.findByCourseId(courseId);
			String temp = career.getIntro();
			temp = Validator.isNull(temp) ? DESC_DEFAULT : temp;
			map.put(PARAM_INTRO, getUnicodeString(temp));
		} catch (NoSuchCourseCareerException e) {
			_log.debug("Course career doesn't exist for course id " + courseId );
			map.put(PARAM_INTRO, DESC_DEFAULT );
		}
	}
	// for edit page
	private static void loadStudyOptionData(RenderRequest renderRequest,
			long courseId, Map<String, String> map) throws SystemException {
		// load study options as json array.. js will handle the rendering part 
		JSONArray array = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		List<StudyOption>list = StudyOptionLocalServiceUtil.findByCourseId(courseId);
		int counter = 1;
		String imgUrl;
		for (StudyOption type : list) {
			JSONObject temp = JSONFactoryUtil.createJSONObject();
			temp.put("studyOptionId_" + counter, type.getSpStudyOptionId());
			temp.put("counter_" + counter, counter);
			temp.put("title_" + counter, type.getTitle());
			temp.put("coverImageId_" + counter, type.getCoverImageFileEntryId());
			temp.put("studyOptionDesc_" + counter, getUnicodeString(type.getDesc()));
			
			if(type.getCoverImageFileEntryId() > 0){
				try {
					imgUrl = ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(type.getCoverImageFileEntryId()),
							themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
							themeDisplay.getPathContext(), 1);
					temp.put("coverImageId_" + counter + "_url", imgUrl);
				} catch (PortalException e) {
					_log.error("error while fetching image url");
				}
			}
			array.put(temp);
			counter = counter + 1;
		}
	
		renderRequest.setAttribute("studyOptions", array.toString());

	}	

	// to display in view page
	public static void loadCareerDetailsViewPage(RenderRequest renderRequest,long courseId) throws  SystemException{
		if (courseId > 0) {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			try {
				CourseCareer career = CourseCareerLocalServiceUtil.findByCourseId(courseId);
				renderRequest.setAttribute("career", career);
			} catch (NoSuchCourseCareerException e) {
				_log.error("Career object does not exist for course id +" + courseId);
			}
			List<StudyOption>list = StudyOptionLocalServiceUtil.findByCourseId(courseId);
			List<Map<String,String>>options = new ArrayList<Map<String,String>>();
			for(StudyOption optin : list){
				Map<String,String>map = new HashMap<String, String>();
				map.put("title", optin.getTitle());
				map.put("desc", optin.getDesc());
				try {
					map.put("imgUrl",ThumbnailUtil.getThumbnailUrl(DLAppServiceUtil.getFileEntry(optin.getCoverImageFileEntryId()),
								themeDisplay.getPathThemeImages(), themeDisplay.getPortalURL(),
								themeDisplay.getPathContext(), 1));
				} catch (PortalException e) {
					_log.error("error while fetching image url");
				}
				options.add(map);
			}
			renderRequest.setAttribute("studyoptions", options);
		}else{
		 // this case handled in jsp, there shouldn't be this case
		}
	}
}
