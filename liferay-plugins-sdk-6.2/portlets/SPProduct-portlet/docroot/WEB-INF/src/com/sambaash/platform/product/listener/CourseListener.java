package com.sambaash.platform.product.listener;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.sambaash.platform.product.util.SPProductUtil;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.spshopping.service.SPShoppingLocalServiceUtil;

public class CourseListener extends BaseModelListener<Course> {
	public static Log logger = LogFactoryUtil.getLog(CourseListener.class);
	private static final long CLASS_NAME_ID = ClassNameLocalServiceUtil.getClassNameId(Course.class);
	
	@Override
	public void onAfterCreate(Course course) throws ModelListenerException {
//		try {
//			if (SPProductUtil.isCoursePaymentEnabled(course.getGroupId())) {
//				debug("Adding new course '"+course.getCourseName()+"' into the Shopping product catalog.");
//				SPShoppingLocalServiceUtil.addProductCatalog(course.getCompanyId()
//						, course.getGroupId(), course.getUserId(), course.getUserName()
//						, CLASS_NAME_ID, course.getSpCourseId()
//						, course.getCourseName(), SPProductUtil.getCourseItemCode(course.getSpCourseId())
//						, course.getCourseDesc(), course.getCourseDesc());
//			}
//		} catch (Exception e) {
//			logError("Error adding new course '"+course.getCourseName()+"' into the Shopping product catalog.", e);
//		}
	}
	
	private static void debug(String debugMsg) {
		if (logger.isDebugEnabled()) {
			logger.debug(debugMsg);
		}
	}
	private static void logError(String debugMsg, Throwable e) {
		logger.error(debugMsg, e);
	}
	
}
