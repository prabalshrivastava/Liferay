package com.sambaash.gu.custom.uploader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.sambaash.gu.helper.GUConstants;
import com.sambaash.gu.helper.GUEntityHelper;
import com.sambaash.gu.helper.GUException;
import com.sambaash.gu.helper.GUModal;
import com.sambaash.gu.msg.GUMsgHelper;

public class GUCustomUploaderHelper {

	private static final Log log = LogFactoryUtil.getLog(GUCustomUploaderHelper.class);
	
	static Map<String, Class> uploaderClasses = new LinkedHashMap<>();
	
	static {
		uploaderClasses.put(GUEntityHelper.ENTITY_USER_PROFILE + GUConstants.MODAL_NAME_SEPARATOR + "*",  GUUserProfileUploader.class);
		uploaderClasses.put(GUEntityHelper.ENTITY_PROCESS,  GUProcessAppUploader.class);
		uploaderClasses.put("ProcessV2",  GUProcessV2AppUploader.class);
		uploaderClasses.put(GUEntityHelper.ENTITY_STATUP_PROFILE + GUConstants.MODAL_NAME_SEPARATOR + GUEntityHelper.ENTITY_STATUP_PROFILE_PS,  GUStartupProfilePSUploader.class);
		uploaderClasses.put(GUEntityHelper.ENTITY_STATUP_PROFILE + GUConstants.MODAL_NAME_SEPARATOR + GUEntityHelper.ENTITY_STATUP_PROFILE_VL,  GUStartupProfilePSUploader.class);
		uploaderClasses.put(GUEntityHelper.ENTITY_STARTUP_CONTACT,  GUStartupContactUploader.class);
		//uploaderClasses.put(GUEntityHelper.ENTITY_STARTUP_LEADPROSPECT,  GUStartupProfilePSUploader.class);
	}
	
	final long groupId ;
	final long companyId ;
	final User logedInUser;
	final Workbook wb;
	final GUMsgHelper msgHelper;
	//uploaders.. will caches these objects while parsing meta-data so that no need to create object again while uploading
	private Map<String, GUCustomUploader>uploaderCache  = new LinkedHashMap<String, GUCustomUploader>();

	public GUCustomUploaderHelper(long companyId, long groupId,
			User logedInUser, Workbook wb,  GUMsgHelper msgHelper){
		this.companyId = companyId;
		this.groupId = groupId;
		this.logedInUser = logedInUser;
		this.wb = wb;
		this.msgHelper = msgHelper;
	}
	
	
	/**
	 *  Here modalName can be 
	 *   a) modal registered in GUEntityHelper.DB_MODALS_MAP. Keys of this  map represents modal names
	 *   b) <modal>:<submodal>  ( Here modal is same as above map keys. Submodal can be any sub section in modal. This submodal not necessarily be registered in above map)
	 *      Submodal is used to represent some custom data ( like data in json/xml format which generic uploader can not handle directly as it's internal structure is not known)
	 *      In this Customuploader will help to upload the data.
	 *      
	 *  
	 * @param modalName
	 * @return
	 *    1. Check's if any modalName or <modalname:submodal> is registered, if so it returns the corresponding obj
	 *    2. If not, checks if <modalname>:<*> is registred, if so it returns the the corresponding obj irrespectinve of submodal name supplied
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public  GUCustomUploader getUploader(String modalName, GUModal modal) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		
		// First check in cache
		GUCustomUploader uploader = getUploader(modalName);
		if(uploader != null){
			return uploader;
		}
		
		Class uclass = uploaderClasses.get(modalName);
		if(uclass != null){
			uploader = getInstance(uclass, modal);
			uploaderCache.put(modalName, uploader);
			return  uploader;
		}
		
		// looking if any modals registered to serve all submodals.
		if(modalName.indexOf(GUConstants.MODAL_NAME_SEPARATOR) != -1){
			String parentModal = modalName.substring(0, modalName.indexOf(GUConstants.MODAL_NAME_SEPARATOR));
			String allKey = parentModal + GUConstants.MODAL_NAME_SEPARATOR + "*";
			uclass = uploaderClasses.get(allKey);
			if(uclass != null){
				uploader = getInstance(uclass, modal);
				uploaderCache.put(modalName, uploader);
				return  uploader;
			}else{
				new GUException("No uploader registered for this modal");
			}
		}
		return null;
	}
	
	private  GUCustomUploader getInstance(Class clazz, GUModal modal) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Constructor<?> ctor = clazz.getConstructor(long.class,long.class,User.class,Workbook.class,GUModal.class,GUMsgHelper.class);
		Object object = ctor.newInstance(new Object[] { companyId,groupId,logedInUser,wb,modal,msgHelper });
		return (GUCustomUploader) object;

	}
	
	private GUCustomUploader getUploader(String modalName){
		GUCustomUploader uploader = uploaderCache.get(modalName);
		if(uploader != null){
			return uploader;
		}
		
		// looking if any modals registered to serve all submodals.
		/*if(modalName.indexOf(GUConstants.MODAL_NAME_SEPARATOR) != -1){
			String parentModal = modalName.substring(0, modalName.indexOf(GUConstants.MODAL_NAME_SEPARATOR));
			String allKey = parentModal + GUConstants.MODAL_NAME_SEPARATOR + "*";
			return uploaderCache.get(allKey);
		}*/
		return uploader;
	}
}
