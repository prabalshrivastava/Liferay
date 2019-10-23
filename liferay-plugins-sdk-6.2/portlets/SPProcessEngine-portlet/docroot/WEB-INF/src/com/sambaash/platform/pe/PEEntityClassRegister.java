package com.sambaash.platform.pe;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.sambaash.platform.constant.PEConstantsGlobal;
import com.sambaash.platform.model.microservicemodel.ProgrammeModel;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.processbuilder.model.PEDummyEntity;
import com.sambaash.platform.srv.processbuilder.service.PEDummyEntityLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
public class PEEntityClassRegister {

	public static Set<Long> getClassNameIds() {
		return classes.keySet();
	}

	public static String getDisplayName(long classNameId) {
		return classes.get(classNameId).getDisplayName();
	}

	public static String getName(long classNameId) {
		return classes.get(classNameId).getName();
	}
	
	public static boolean isRegisteredClass(long classNamedId){
		return classes.containsKey(classNamedId);
	}

	public static Class getUtilClass(long classNameId) {
		return classes.get(classNameId).getUtilClass();
	}

	public static String getServerCall(long classNameId) {
		return classes.get(classNameId).getServerCall();
	}
	
	public static String getApiUsed(long classNameId) {
		return classes.get(classNameId).getApiUsed();
	}
	private static Log _log = LogFactoryUtil.getLog(PEEntityClassRegister.class);
	private static Map<Long, PEEntityClass> classes = new HashMap<Long, PEEntityClass>();
	static {
		
		try {
			List<SPListType> listypeList = SPListTypeLocalServiceUtil.getByKey("process.entity.type", 0);
			ClassName cnName = ClassNameLocalServiceUtil.getClassName(Product.class.getName());
			for(SPListType listype : listypeList){
				PEEntityClass entityClass = new PEEntityClass();
				String entityName = "";
				long classNameId =0;
				String serverCall = StringPool.BLANK;
				String apiUsed = StringPool.BLANK;
				if(Validator.isNotNull(listype.getItemValue())){
				String[] nameClassArray = listype.getItemValue().split(",");
				entityName = listype.getDisplayName();
				try {
					Class className = Class.forName(listype.getItemValue());
					classNameId = ClassNameLocalServiceUtil.getClassNameId((listype.getItemValue()));
					if(className.toString().contains("PEDummyEntity")){
						entityClass.setUtilClass(PEDummyEntityLocalServiceUtil.class);
					}else if(className.toString().contains("Product")){
						entityClass.setUtilClass(ProductLocalServiceUtil.class);
					}
					serverCall = listype.getModeldata();
				} catch (ClassNotFoundException e) {
					_log.error(e.getMessage());
				}
				
				
				}
				entityClass.setName(entityName);
				entityClass.setDisplayName(entityName);
				entityClass.setId(classNameId);
				entityClass.setServerCall(serverCall);
				entityClass.setApiUsed(apiUsed);
				classes.put(classNameId, entityClass);
			}	
			
		} catch (SystemException e) {
			_log.error("Error registering class", e);
		}
	}


	public static Map<Long,String> getEntityClassNames(){
		Map<Long,String>names = new LinkedHashMap<Long, String>();
		for (Entry<Long,PEEntityClass> entry : classes.entrySet()) {
			names.put(entry.getKey(), entry.getValue().getDisplayName());
		}
		return names;
	}
	
	public static long getEntityClassId(String className){
		for (Entry<Long,PEEntityClass> entry : classes.entrySet()) {
			if(entry.getValue().getName().equals(className)){
				return entry.getKey();
			}
		}
		return 0;
	}
}
