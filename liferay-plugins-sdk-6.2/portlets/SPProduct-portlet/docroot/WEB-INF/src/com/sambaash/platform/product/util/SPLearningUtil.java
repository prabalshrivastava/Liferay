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
import com.sambaash.platform.srv.NoSuchCourseDurationException;
import com.sambaash.platform.srv.NoSuchCourseLearningException;
import com.sambaash.platform.srv.model.CourseDuration;
import com.sambaash.platform.srv.model.CourseDurationType;
import com.sambaash.platform.srv.model.CourseLearning;
import com.sambaash.platform.srv.service.CourseDurationLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseDurationTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseLearningLocalServiceUtil;
import com.sambaash.platform.util.LabelUtil;
import com.sambaash.platform.util.SambaashUtil;

public class SPLearningUtil {

	private static Log _log = LogFactoryUtil.getLog(SPLearningUtil.class);
	
	public  static String PARAM_INTRO = "intro";
	public  static String PARAM_OPTION_TITLE = "optionTitle";
	public  static String PARAM_OPTION1 = "option1";
	public  static String PARAM_OPTION2 = "option2";
	public  static String PARAM_NOTE = "note";
	public  static String PARAM_DURATION_TITLE = "durationTitle";
	public  static String PARAM_DURATION_TYPE_ID = "durationTypeId";
	
	
	public static JSONObject deleteDurationType(PortletRequest portletRequest, PortletResponse portletResponse)  {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		long id = ParamUtil.getLong(portletRequest, PARAM_DURATION_TYPE_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		try {
			CourseDurationTypeLocalServiceUtil.deleteCourseDurationType(id);
		} catch (PortalException | SystemException e) {
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.durationDelete.error.message"));
		}
		return response;
	}
	public static JSONObject createUpdateLearningDetail(ResourceRequest resourceRequest, ResourceResponse resourceResponse)  {
		JSONObject response = JSONFactoryUtil.createJSONObject();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		long spCourseId = ParamUtil.getLong(resourceRequest,"spCourseId");
		response.put("process", "create");
		try {
			if (spCourseId > 0) {
				CourseLearning courseLearning = null;
				try {
					courseLearning = CourseLearningLocalServiceUtil.findByCourseId(spCourseId);
					if(Validator.isNotNull(courseLearning)){
						response.put("process", "update");
					}
				} catch (NoSuchCourseLearningException e) {
					// it's a create
					_log.debug("Course Learning doesn't exist for course id " + spCourseId + ". So create one now");
					courseLearning = CourseLearningLocalServiceUtil.create();
				}
				// fill audit fields
				SambaashUtil.fillAudit(courseLearning, themeDisplay, courseLearning.isNew());
				
				courseLearning.setSpCourseId(spCourseId);
				courseLearning.setIntro(ParamUtil.getString(resourceRequest, PARAM_INTRO));
				courseLearning.setOptionTitle(ParamUtil.getString(resourceRequest, PARAM_OPTION_TITLE));
				courseLearning.setOption1(ParamUtil.getString(resourceRequest, PARAM_OPTION1));
				courseLearning.setOption2(ParamUtil.getString(resourceRequest, PARAM_OPTION2));
				courseLearning.setNote(ParamUtil.getString(resourceRequest, PARAM_NOTE));
				
				CourseLearningLocalServiceUtil.updateCourseLearning(courseLearning);
				response.put("learningId",courseLearning.getSpCourseLearningId());
				
				CourseDuration courseDuration = createUpdateDuration(courseLearning.getSpCourseLearningId(), spCourseId, resourceRequest, resourceResponse);
				response.put("duriationId", courseDuration.getSpCourseDurationId());
				
				try {
					createUpdateDurationTypes(courseDuration.getSpCourseDurationId(), courseLearning.getSpCourseLearningId(), spCourseId, resourceRequest, response);
				} catch (PortalException e) {
					response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.course.not.exist"));
				}
				
			}else{
				// it cannot exist without course.. Course must exist
				response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.course.not.exist"));
				_log.error("Invalid course id received from client");
			}
		} catch (SystemException e) {
			_log.error(e);
			response.put("error", LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.save.learning"));
		}
		
		return response;
	}
	public static CourseDuration createUpdateDuration(long learningid,long spCourseId,PortletRequest request, PortletResponse response) throws SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		CourseDuration courseDuration = null;
		if (spCourseId > 0) {
			try {
				courseDuration = CourseDurationLocalServiceUtil.findByCourseId(spCourseId);
			} catch (NoSuchCourseDurationException e) {
				// it's a create
				_log.debug("Course duriation doesn't exist for course id " + spCourseId + ". So create one now");
				courseDuration = CourseDurationLocalServiceUtil.create();
				courseDuration.setSpCourseId(spCourseId);
				courseDuration.setSpCourseLearningId(learningid);
			}
			// fill audit fields
			SambaashUtil.fillAudit(courseDuration, themeDisplay, courseDuration.isNew());
			courseDuration.setTitle(ParamUtil.getString(request, PARAM_DURATION_TITLE));
			
			CourseDurationLocalServiceUtil.updateCourseDuration(courseDuration);
		}
		return courseDuration;
	}
	public static void createUpdateDurationTypes(long duriationId,long learningid,long spCourseId,PortletRequest request, JSONObject response) throws SystemException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		long count = ParamUtil.getLong(request, "durationTypecount");
		long durationTypeId;
		CourseDurationType durationType = null;
		boolean create ;
		String idParam;
		JSONArray types = JSONFactoryUtil.createJSONArray();
		JSONObject type ;
		for(int i= 1 ; i<=count ; i++){
			type = JSONFactoryUtil.createJSONObject();
			if(ParamUtil.getLong(request, "counter_"+i) <= 0){ // check for corresponding row data exists or not
				continue;
			}
			idParam = "durationTypeId_" + i;
			durationTypeId = ParamUtil.getLong(request,idParam );
			create = true;
			if(durationTypeId > 0){
				create = false;
				durationType = CourseDurationTypeLocalServiceUtil.getCourseDurationType(durationTypeId);
			}
			if(create){
				durationType = CourseDurationTypeLocalServiceUtil.create();
				durationType.setSpCourseId(spCourseId);
				durationType.setSpCourseDurationId(duriationId);
			}
			// fill audit
			SambaashUtil.fillAudit(durationType, themeDisplay, durationType.isNew());
			
			durationType.setTitle1(ParamUtil.getString(request, "title1_"+i));
			durationType.setTitle2(ParamUtil.getString(request, "title2_"+i));
			durationType.setDuration1(ParamUtil.getString(request, "duration1_"+i));
			durationType.setDuration2(ParamUtil.getString(request, "duration2_"+i));
			
			CourseDurationTypeLocalServiceUtil.updateCourseDurationType(durationType);

			// indication to client that corresponding duration type saved successfully.
			type.put("counter", i);
			type.put("durationTypeId", durationType.getSpCourseDurationTypeId());
			types.put(type);
			
		}
		// for subsequent updates without page refresh, these durationtype id's must be preserved
		response.put("durationTypes",types);
	}
	
	private static String getUnicodeString(String str){
		return UnicodeFormatter.toString(GetterUtil.getString(str));
	}
	
	public static void loadLearningDetails(RenderRequest renderRequest,long courseId) throws  SystemException{
		
		//long courseId = ParamUtil.getLong(renderRequest,"spCourseId");
		Map<String,String>map = new HashMap<>();
		if (courseId > 0) {
			// Learning details
			CourseLearning learning;
			try {
				learning = CourseLearningLocalServiceUtil.findByCourseId(courseId);
				map.put("optionTitle", learning.getOptionTitle());
				map.put("intro", getUnicodeString(learning.getIntro()));
				map.put("option1", getUnicodeString(learning.getOption1()));
				map.put("option2", getUnicodeString(learning.getOption2()));
				map.put("note", getUnicodeString(learning.getNote()));
				 
			} catch (NoSuchCourseLearningException e1) { // looks learning details not yet created for this course (courseId)
				//setDefaultData(map);
			} 
			CourseDuration courseDuration;
			try {
				courseDuration = CourseDurationLocalServiceUtil.findByCourseId(courseId);
				map.put("durationTitle", courseDuration.getTitle());
			} catch (NoSuchCourseDurationException e) {
				_log.error("Course duration does not exist for course id " + courseId);
			}
			loadDurationData(renderRequest, courseId);
			
		}else{
		 // this case handled in jsp, there shouldn't be this case
		}
		renderRequest.setAttribute("learning", map);
	}
	private static void loadDurationData(RenderRequest renderRequest,long courseId) throws SystemException {
		// load duration types as json array.. js will handle the rendering part 
		JSONArray array = JSONFactoryUtil.createJSONArray();
		// Duration details ( duration title, type etc..
		double duration = 0;

		List<CourseDurationType>list = CourseDurationTypeLocalServiceUtil.findByCourseId(courseId);
		int counter = 1;
		for (CourseDurationType type : list) {
			JSONObject temp = JSONFactoryUtil.createJSONObject();
			temp.put("durationTypeId_" + counter, type.getSpCourseDurationTypeId());
			temp.put("counter_" + counter, counter);
			temp.put("title1_" + counter, type.getTitle1());
			temp.put("title2_" + counter, type.getTitle2());
			temp.put("duration1_" + counter, type.getDuration1());
			temp.put("duration2_" + counter, type.getDuration2());
			
			array.put(temp);
			//duration = type.getDuration1() + type.getDuration2();
			counter = counter + 1;
		}
	
		renderRequest.setAttribute("durationTypes", array.toString());
		renderRequest.setAttribute("totalDuration", duration);

	}	

	// this method used to load learning details to display in view page
	public static void loadLearningDetailsViewPage(RenderRequest renderRequest,long courseId) throws  SystemException{
		
		if (courseId > 0) {
			// Learning details
			CourseLearning learning;
			try {
				learning = CourseLearningLocalServiceUtil.findByCourseId(courseId);
				
				CourseDuration courseDuration = CourseDurationLocalServiceUtil.findByCourseId(courseId);
				
				renderRequest.setAttribute("learning", learning);
				renderRequest.setAttribute("duration", courseDuration);
				List<CourseDurationType>list = CourseDurationTypeLocalServiceUtil.findByCourseId(courseId);
				
				double duration = 0;
				List<Map<String,String>> types = new ArrayList<Map<String,String>>();
				//DecimalFormat df = new DecimalFormat("0.##"); 
				for (CourseDurationType type : list) {
					Map<String,String>map = new HashMap<String, String>();
					
					map.put("title1", type.getTitle1());
					map.put("title2", type.getTitle2());
					String d1 = type.getDuration1();
					//map.put("duration1", df.format(d1));
					map.put("duration1", d1);
					String d2 = type.getDuration2();
					//map.put("duration2", df.format(d2));
					map.put("duration2", d2);
					//duration = duration + d1 + d2;
					
					types.add(map);
				}
				//renderRequest.setAttribute("totalDuration", df.format(duration));
				renderRequest.setAttribute("totalDuration", duration);
				renderRequest.setAttribute("durationTypes", types);
				
			} catch (NoSuchCourseLearningException e1) { // looks learning details not yet created for this course (courseId)
			} catch (NoSuchCourseDurationException e) {
				_log.error("Duration data does not exist for course id = " + courseId);
			}
		}else{
		 // this case handled in jsp, there shouldn't be this case
		}
		//renderRequest.setAttribute("learning", map);
	}
}
