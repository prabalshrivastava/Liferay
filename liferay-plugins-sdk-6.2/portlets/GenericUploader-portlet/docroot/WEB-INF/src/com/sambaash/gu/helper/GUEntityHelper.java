package com.sambaash.gu.helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.tools.ant.util.LeadPipeInputStream;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.sambaash.platform.srv.model.Activity;
import com.sambaash.platform.srv.model.Certificate;
import com.sambaash.platform.srv.model.CompetencyUnit;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.CourseCareer;
import com.sambaash.platform.srv.model.CourseCertificate;
import com.sambaash.platform.srv.model.CourseDuration;
import com.sambaash.platform.srv.model.CourseDurationType;
import com.sambaash.platform.srv.model.CourseLearning;
import com.sambaash.platform.srv.model.CourseModule;
import com.sambaash.platform.srv.model.CourseOutcome;
import com.sambaash.platform.srv.model.FeeDetails;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.model.Funding;
import com.sambaash.platform.srv.model.GraduationCriteria;
import com.sambaash.platform.srv.model.MiscellaneousFees;
import com.sambaash.platform.srv.model.Module;
import com.sambaash.platform.srv.model.ModuleCertificate;
import com.sambaash.platform.srv.model.ModuleCompetencyUnit;
import com.sambaash.platform.srv.model.ModuleFramework;
import com.sambaash.platform.srv.model.Outline;
import com.sambaash.platform.srv.model.Persona;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.model.Schedule;
import com.sambaash.platform.srv.model.StudyOption;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;
import com.sambaash.platform.srv.processbuilder.service.PEProcessLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStageLocalServiceUtil;
import com.sambaash.platform.srv.service.ActivityLocalServiceUtil;
import com.sambaash.platform.srv.service.CertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.CompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseCareerLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseDurationLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseDurationTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseLearningLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.CourseOutcomeLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeDetailsLocalServiceUtil;
import com.sambaash.platform.srv.service.FeeTypeLocalServiceUtil;
import com.sambaash.platform.srv.service.FrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.FundingLocalServiceUtil;
import com.sambaash.platform.srv.service.GraduationCriteriaLocalServiceUtil;
import com.sambaash.platform.srv.service.MiscellaneousFeesLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleCertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleCompetencyUnitLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleFrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.OutlineLocalServiceUtil;
import com.sambaash.platform.srv.service.PersonaLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.service.ScheduleLocalServiceUtil;
import com.sambaash.platform.srv.service.StudyOptionLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileServiceUtil;
import com.sambaash.platform.srv.startupprofile.model.Address;
import com.sambaash.platform.srv.startupprofile.model.FundingRound;
import com.sambaash.platform.srv.startupprofile.model.Organization;
//import com.sambaash.platform.srv.startupprofile.model.OrganizationContact;
//import com.sambaash.platform.srv.startupprofile.model.PELeadProspect;
import com.sambaash.platform.srv.startupprofile.model.Questionnaire;
import com.sambaash.platform.srv.startupprofile.service.AddressLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.FundingRoundLocalServiceUtil;
//import com.sambaash.platform.srv.startupprofile.service.OrganizationContactLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;
//import com.sambaash.platform.srv.startupprofile.service.PELeadProspectLocalServiceUtil;
import com.sambaash.platform.srv.startupprofile.service.QuestionnaireLocalServiceUtil;

public class GUEntityHelper {
	private static final Log _log = LogFactoryUtil.getLog(GUEntityHelper.class);
	public static final Map<String,GUDBEntity>DB_MODALS_MAP = new LinkedHashMap<String, GUDBEntity>();
	
	public static class GUDBEntity{
		private Class entityClass;
		private Class localServiceUtilClass;
		
		public GUDBEntity(Class entity, Class localServiceUtil){
			this.entityClass = entity;
			this.localServiceUtilClass = localServiceUtil;
		}

		public Class getEntityClass() {
			return entityClass;
		}

		public void setEntityClass(Class entityClass) {
			this.entityClass = entityClass;
		}

		public Class getLocalServiceUtilClass() {
			return localServiceUtilClass;
		}

		public void setLocalServiceUtilClass(Class localServiceUtilClass) {
			this.localServiceUtilClass = localServiceUtilClass;
		}
		
		public String getModalImplClassFullname(){
			return entityClass.getPackage().getName() + ".impl." + entityClass.getSimpleName() + "ModelImpl";
		}
	}
	
	public static final String ENTITY_STATUP_PROFILE = "Startup Profile";
	public static final String ENTITY_STARTUP_CONTACT = "Organization Contact";
	public static final String ENTITY_STARTUP_LEADPROSPECT = "Lead Prospect";
	public static final String ENTITY_STATUP_PROFILE_PS = "Projects";
	public static final String ENTITY_STATUP_PROFILE_VL = "VideoLinks";
	public static final String ENTITY_USER_PROFILE = "User Profile";
	public static final String ENTITY_PROCESS = "Process";
	
	static{
		DB_MODALS_MAP.put("User", new GUDBEntity(User.class,UserLocalServiceUtil.class));
		DB_MODALS_MAP.put(ENTITY_USER_PROFILE, new GUDBEntity(SocialProfile.class,SocialProfileLocalServiceUtil.class));
		DB_MODALS_MAP.put(ENTITY_STATUP_PROFILE, new GUDBEntity(Organization.class,OrganizationLocalServiceUtil.class));
		DB_MODALS_MAP.put("Funding Round", new GUDBEntity(FundingRound.class,FundingRoundLocalServiceUtil.class));
//		DB_MODALS_MAP.put(ENTITY_STARTUP_CONTACT, new GUDBEntity(OrganizationContact.class,OrganizationContactLocalServiceUtil.class));
		DB_MODALS_MAP.put("Startup Profile Address", new GUDBEntity(Address.class,AddressLocalServiceUtil.class));
		DB_MODALS_MAP.put("Startup Profile Questionnaire", new GUDBEntity(Questionnaire.class,QuestionnaireLocalServiceUtil.class));
//		DB_MODALS_MAP.put(ENTITY_STARTUP_LEADPROSPECT, new GUDBEntity(PELeadProspect.class,PELeadProspectLocalServiceUtil.class));
		
		DB_MODALS_MAP.put("Framework", new GUDBEntity(Framework.class,FrameworkLocalServiceUtil.class));
		DB_MODALS_MAP.put("Competency Unit", new GUDBEntity(CompetencyUnit.class,CompetencyUnitLocalServiceUtil.class));
		DB_MODALS_MAP.put("Outline", new GUDBEntity(Outline.class,OutlineLocalServiceUtil.class));
		DB_MODALS_MAP.put("Certificate", new GUDBEntity(Certificate.class,CertificateLocalServiceUtil.class));
		DB_MODALS_MAP.put("Module", new GUDBEntity(Module.class,ModuleLocalServiceUtil.class));
		DB_MODALS_MAP.put("Module Framework", new GUDBEntity(ModuleFramework.class,ModuleFrameworkLocalServiceUtil.class));
		DB_MODALS_MAP.put("Module Competency Unit", new GUDBEntity(ModuleCompetencyUnit.class,ModuleCompetencyUnitLocalServiceUtil.class));
		DB_MODALS_MAP.put("Module Schedule", new GUDBEntity(Schedule.class,ScheduleLocalServiceUtil.class));
		DB_MODALS_MAP.put("Module Activity", new GUDBEntity(Activity.class,ActivityLocalServiceUtil.class));
		DB_MODALS_MAP.put("Module Certificate", new GUDBEntity(ModuleCertificate.class,ModuleCertificateLocalServiceUtil.class));

		DB_MODALS_MAP.put("Course", new GUDBEntity(Course.class,CourseLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Module", new GUDBEntity(CourseModule.class,CourseModuleLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Certificate", new GUDBEntity(CourseCertificate.class,CourseCertificateLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Outcome", new GUDBEntity(CourseOutcome.class,CourseOutcomeLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Persona", new GUDBEntity(Persona.class,PersonaLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Learning", new GUDBEntity(CourseLearning.class,CourseLearningLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Duration", new GUDBEntity(CourseDuration.class,CourseDurationLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Duration Type", new GUDBEntity(CourseDurationType.class,CourseDurationTypeLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Career", new GUDBEntity(CourseCareer.class,CourseCareerLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Study Option", new GUDBEntity(StudyOption.class,StudyOptionLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Graduation Criteria", new GUDBEntity(GraduationCriteria.class,GraduationCriteriaLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Miscellaneous Fees", new GUDBEntity(MiscellaneousFees.class,MiscellaneousFeesLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Fee Type", new GUDBEntity(FeeType.class,FeeTypeLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Funding", new GUDBEntity(Funding.class,FundingLocalServiceUtil.class));
		DB_MODALS_MAP.put("Course Fee", new GUDBEntity(FeeDetails.class,FeeDetailsLocalServiceUtil.class));
		
		DB_MODALS_MAP.put("Product", new GUDBEntity(Product.class,ProductLocalServiceUtil.class));
		DB_MODALS_MAP.put(ENTITY_PROCESS, new GUDBEntity(PEProcess.class,PEProcessLocalServiceUtil.class));
		DB_MODALS_MAP.put("Process Stage", new GUDBEntity(PEProcessStage.class,PEProcessStageLocalServiceUtil.class));
		
		DB_MODALS_MAP.put("ProcessV2", new GUDBEntity(PEProcess.class,PEProcessLocalServiceUtil.class));
	}
	
	public static Object create(String modalName){
		try {
			Class util = DB_MODALS_MAP.get(modalName).getLocalServiceUtilClass();
			_log.error("Create method error , no user created... ");
			Method createMethod = util.getMethod("create");
			return createMethod.invoke(null);
		} catch (Exception e) {
			_log.error(e);
		}
		return null;
	}
	public static boolean update(String modalName, Object obj){
		boolean result = true;
		try {
			GUDBEntity entity = DB_MODALS_MAP.get(modalName);
			Class util = entity.getLocalServiceUtilClass();
			_log.error("Inside update method, user creation for : " + entity.getEntityClass());
//			if(OrganizationContact.class.getName().equalsIgnoreCase(DB_MODALS_MAP.get(modalName).getEntityClass().getName())){
//				OrganizationContact organizationContact = (OrganizationContact) obj;
//				if(!Validator.isNull(organizationContact.getEmailId()) 
//						&& !Validator.isNull(organizationContact.getFirstName())
//						&& !Validator.isNull(organizationContact.getLastName())){
//					User contactAUser = null;
//					try {
//						contactAUser = UserLocalServiceUtil.getUserByEmailAddress(organizationContact.getCompanyId(), organizationContact.getEmailId());
//						_log.error("user already exists");
//						organizationContact.setUserId(contactAUser.getUserId());
//					} catch (NoSuchUserException nsue) {
//						_log.error("Will create user : " + organizationContact.getEmailId());
//						String apiKey = "cWqb6X63ut+SXix3RESxtIy1W412NbY/MLLZf3v4RA==";
//						contactAUser = SocialProfileServiceUtil.addUser(apiKey, organizationContact.getFirstName(), 
//								organizationContact.getLastName(), organizationContact.getEmailId(), "zaq12wsx",
//								false);
//						organizationContact.setUserId(contactAUser.getUserId());
//					}catch(Exception e){
//						_log.error("Error While creating user : " + organizationContact.getEmailId());
//						organizationContact.setUserId(0);
//					}
//				}
//			}
			String methodName = "update" + entity.getEntityClass().getSimpleName();
			Method createMethod = util.getMethod(methodName, entity.getEntityClass());
			createMethod.invoke(null,obj);
			
		} catch (Exception e) {
			result = false;
			_log.error(e);
		}
		return result;
	}

	/**
	 *  Used to return all matching records for given input.
	 * 
	 * @param modalName  - Used to identity the table whose rows has to return
	 * @param data  - selection criteria.  Key - fieldId and Value - field value
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws ClassNotFoundException 
	 * @throws GUInvalidDataException 
	 * @throws GUException 
	 */
	public static List getAll(String modalName, Map<String,String>data) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, GUInvalidDataException{
		Class util = DB_MODALS_MAP.get(modalName).getLocalServiceUtilClass();
		
		
		Method dqCreate = util.getMethod("dynamicQuery");
		DynamicQuery dynamicQuery = (DynamicQuery) dqCreate.invoke(null);
		Criterion criterion = null;
		for (Entry<String, String> entry : data.entrySet()) {
			String fieldName = entry.getKey();
			String fieldValue = entry.getValue();
			Class fieldType = getEntityFieldType(modalName, fieldName);
			Object obj =  convertStringToType(fieldValue, fieldType);
			Criterion temp = RestrictionsFactoryUtil.eq(fieldName,obj);
			if(criterion != null){
				criterion = RestrictionsFactoryUtil.and(criterion, temp);
			}else{
				criterion = temp;
			}
		}
		dynamicQuery.add(criterion);
		Method dqExecute = util.getMethod("dynamicQuery",DynamicQuery.class);
		List list = (List) dqExecute.invoke(null, dynamicQuery);
		
		return list;
	}
	
	/**
	 * Method used to convert String to given Type
	 * 
	 * @param value - String to convert
	 * @param type - Target type ( long,int,Date etc..)
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws GUException 
	 */
	public static Object convertStringToType(String value,Class type) throws ClassNotFoundException, NoSuchMethodException, SecurityException, GUInvalidDataException{
		//Class type = getFieldType(modalName, fieldName);
		Object obj = null;
		if(type.equals(String.class)){
			obj = value;
		}else if(type.getName().equals("byte") || type.getName().equals(Byte.class.getName())){
//		   setMethod.invoke(obj, (byte)GetterUtil.getShort(value));
			obj = (byte)GetterUtil.getShort(value);
		}else if(type.getName().equals("short") || type.getName().equals(Short.class.getName())){
		   if(value.indexOf(".") != -1){
			   // Remove the decimal placess
			   value = value.substring(0,value.indexOf("."));
		   }
			if (Validator.isNotNull(value)) {
				if (NumberUtils.isNumber(value)) {
					obj = GetterUtil.getShort(value);
				} else {
					throw new GUInvalidDataException("Invalid data");
				}
			} else {
				obj = GetterUtil.getShort(value);
			}
		   //setMethod.invoke(obj, GetterUtil.getShort(value));
		   
		}else if(type.getName().equals("int") || type.getName().equals(Integer.class.getName())){
			if(value.indexOf(".") != -1){
			   // Remove the decimal placess
			   value = value.substring(0,value.indexOf("."));
			 }
			if (Validator.isNotNull(value)) {
				if (NumberUtils.isNumber(value)) {
					obj = GetterUtil.getInteger(value);
				} else {
					throw new GUInvalidDataException("Invalid data");
				}
			} else {
				obj = GetterUtil.getInteger(value);
			}
			//setMethod.invoke(obj, GetterUtil.getInteger(value));
		}else if(type.getName().equals("long") || type.getName().equals(Long.class.getName())){
			if(value.indexOf(".") != -1){
				// Remove the decimal placess
				value = value.substring(0,value.indexOf("."));
			}
			if (Validator.isNotNull(value)) {
				if (NumberUtils.isNumber(value)) {
					obj = GetterUtil.getLong(value);
				} else {
					throw new GUInvalidDataException("Invalid data");
				}
			} else {
				obj = GetterUtil.getLong(value);
			}
			//setMethod.invoke(obj, GetterUtil.getLong(value));
		}else if(type.getName().equals("char") || type.getName().equals(Character.class.getName())){
			if(Validator.isNotNull(value)){
				obj = new Character(value.charAt(0));
				//setMethod.invoke(obj, new Character(value.charAt(0)));
			}else{
				obj = Character.SPACE_SEPARATOR;
				//setMethod.invoke(obj, Character.SPACE_SEPARATOR);
			}
			
		}else if(type.getName().equals("float") || type.getName().equals(Float.class.getName())){
			if (Validator.isNotNull(value)) {
				if (NumberUtils.isNumber(value)) {
					obj = GetterUtil.getFloat(value);
				} else {
					throw new GUInvalidDataException("Invalid data");
				}
			} else {
				obj = GetterUtil.getFloat(value);
			}
			//setMethod.invoke(obj, GetterUtil.getFloat(value));
			
		}else if(type.getName().equals("double") || type.getName().equals(Double.class.getName())){
			if (Validator.isNotNull(value)) {
				if (NumberUtils.isNumber(value)) {
					obj = GetterUtil.getDouble(value);
				} else {
					throw new GUInvalidDataException("Invalid data");
				}
			} else {
				obj = GetterUtil.getDouble(value);
			}
			//setMethod.invoke(obj, GetterUtil.getDouble(value));
			
		}else if(type.getName().equals("boolean") || type.getName().equals(Boolean.class.getName())){
			obj = GetterUtil.getBoolean(value);
			//setMethod.invoke(obj, GetterUtil.getBoolean(value));
		}else if(type.equals(Date.class)){
			obj = getDate4rDDMMMYYYY(value);
			//setMethod.invoke(obj, date);
		}
		
		return obj;
	}
	private static Date getDate4rDDMMMYYYY(String str){
		if(Validator.isNotNull(str)){
			try{
				SimpleDateFormat df = new SimpleDateFormat(GUConstants.DATE_FORMAT);
				Date date = df.parse(str);
				return date;
			}catch(Exception ex){
				_log.error("Error while format String to date. String=" + str);
			}
			
		}
		return null;
	}
	
	public static Object getOne(String modalName, Map<String,String>data) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, GUInvalidDataException{
		 List list = getAll(modalName, data);
		 if(list.size() > 0){
			 return list.get(0);
		 }
		return null;
	}
	
	public static Method getEntitySetMethod(String modalName,String fieldName) throws ClassNotFoundException, NoSuchMethodException, SecurityException{
		GUDBEntity entityInfo = DB_MODALS_MAP.get(modalName);
		// Getting setter method object. First find the return type of  getMethod. Return type of getmethod is input parameter type for setter method
		Method getMethod = getEntitygetMethod(modalName, fieldName);
		String setMethodName = "set" + toUpeerFirstChar(fieldName);
		Class entityClass = entityInfo.getEntityClass();
		Method setMethod = entityClass.getMethod(setMethodName,getMethod.getReturnType());
	
		return setMethod;
	}
	
	public static Method getEntitygetMethod(String modalName,String fieldName) throws ClassNotFoundException, NoSuchMethodException, SecurityException{
		GUDBEntity entityInfo = DB_MODALS_MAP.get(modalName);
		String tempFN =  toUpeerFirstChar(fieldName);
		String getMethodName = "get" + tempFN;
		Class entityClass = entityInfo.getEntityClass();
		Method getMethod = entityClass.getMethod(getMethodName);
		return getMethod;
	}
	
	public static String toUpeerFirstChar(String str){
		String fc = str.charAt(0) + "";
		String tempFN =  str.replaceFirst(fc, fc.toUpperCase());
		return tempFN;
	}
	
	public static void deleteRecords(String modalName, Map<String,String>criteriaMap) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, GUInvalidDataException{
		GUDBEntity entity = DB_MODALS_MAP.get(modalName);
		List list = getAll(modalName, criteriaMap);
		if( list != null){
			//ProductLocalServiceUtil.deleteProduct(product)
			Class util = entity.getLocalServiceUtilClass();
			String methodName = "delete" + entity.getEntityClass().getSimpleName();
			Method deleteMethod = util.getMethod(methodName, entity.getEntityClass());
			//deleteMethod.invoke(null,obj);
			for (Object object : list) {
				deleteMethod.invoke(null,object);
			}
		}
	}

	public static Class getEntityFieldType(String modalName, String fieldName) throws ClassNotFoundException, NoSuchMethodException, SecurityException{
		Method getMethod = getEntitygetMethod(modalName, fieldName);
		return getMethod.getReturnType();
	}
	
	public static void setValue(String modalName,Object obj,String fieldName,String value) throws Exception{
		
		Method setMethod  = getEntitySetMethod(modalName, fieldName);
		
		// Parameter type to pass to above setter method
		Class params[] = setMethod.getParameterTypes();
		Class type = params[0]; // set method will have only one parameter

		Object targetType = convertStringToType(value, type);
		setMethod.invoke(obj, targetType);
	
	}
	public static Object getValue(String modalName,Object obj,String fieldName) throws Exception{
		
		Method getMethod  = getEntitygetMethod(modalName, fieldName);
		
		Class type = getMethod.getReturnType();
		
		//Object targetType = convertStringToType(value, type);
		Object returndValue = getMethod.invoke(obj);
		return returndValue;
		
	}
	
	public static long getPrimarykey(Object dbObj){
		Class entityClass = dbObj.getClass();
		try {
				Method getMethod = entityClass.getMethod("getPrimaryKey", null);
				long key =  (long)getMethod.invoke(dbObj, null);
				return key;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			_log.error(e);
		}
		return 0;
	}
	public static String getUUID(Object dbObj){
		Class entityClass = dbObj.getClass();
		try {
			Method getMethod = entityClass.getMethod("getUuid", null);
			String key =  (String)getMethod.invoke(dbObj, null);
			return key;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			_log.error(e);
		}
		return StringPool.BLANK;
	}

	public static void updateAssetCategories(long userId, long groupId,String modalName,Object dbObj,
			long[] assetCategoryIds) throws PortalException, SystemException{
		String[]tagNames = null;
		Organization org;
		GUDBEntity entityInfo = DB_MODALS_MAP.get(modalName);
		Class entityClass = entityInfo.getEntityClass();
		AssetEntryLocalServiceUtil.updateEntry(userId, groupId, new Date(), new Date(), 
				entityClass.getName(), getPrimarykey(dbObj), 
				getUUID(dbObj), 0, assetCategoryIds, tagNames, true, null, null, null, 
				ContentTypes.TEXT_HTML, null, null, null, null, null, 0, 0, null, false);
	}
	
}
