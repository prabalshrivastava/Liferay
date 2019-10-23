package com.dlperm.hook;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.PermissionUtil;
//import com.liferay.portlet.documentlibrary.model.DLFileEntry;
/**
 *
 * @author james Stuart Milne & Joaquin Cabal
 */
public class FileHook implements ModelListener {
	
	private static final Log _log = LogFactoryUtil.getLog(FileHook.class);

    public void onAfterCreate(Object model) throws ModelListenerException {
    	_log.debug("Call received to onAfterCreate");
        com.liferay.portlet.documentlibrary.model.DLFileEntry addedFileEntry
                = (com.liferay.portlet.documentlibrary.model.DLFileEntry) model;
  /*      try {          
            ResourceLocalServiceUtil.addResource(addedFileEntry.getCompanyId(), DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(addedFileEntry.getFileEntryId()));
        } catch (Exception ex) {
            Logger.getLogger(FileHook.class.getName()).log(Level.SEVERE, null, ex);
        } */
        onAfterUpdate(addedFileEntry);
    }

    public void onAfterAddAssociation(Object arg0, String arg1, Object arg2) throws ModelListenerException {
      
        //Add your implementation here
    }

    public void onAfterRemove(Object model) throws ModelListenerException {
        //Add your implementation here
    }

    public void onAfterRemoveAssociation(Object arg0, String arg1, Object arg2) throws ModelListenerException {
        //Add your implementation here
    }

    public void onAfterUpdate(Object model) throws ModelListenerException {
        //Add your implementation here
    	_log.debug("Call received to onAfterUpdate " + model);
        com.liferay.portlet.documentlibrary.model.DLFileEntry addedFileEntry
               = (com.liferay.portlet.documentlibrary.model.DLFileEntry) model;
        DLFolder parentFolder = null;
		try {
			parentFolder = addedFileEntry.getFolder();
		} catch (PortalException | SystemException e) {
			_log.error(e);
		}
        if(parentFolder != null) {
           try {
           	PermissionUtil.inhertParentPermissions(addedFileEntry,SambaashConstants.PERMISSION_OPERATION_MERGE,null); 
           } catch (Exception ex) {
               _log.error(ex);
           } 
           
		}
   }

    public void onBeforeAddAssociation(Object arg0, String arg1, Object arg2) throws ModelListenerException {
        //Add your implementation here
    }

    public void onBeforeCreate(Object model) throws ModelListenerException {
        //Add your implementation here
    }

    public void onBeforeRemove(Object model) throws ModelListenerException {
        //Add your implementation here
    }

    public void onBeforeRemoveAssociation(Object arg0, String arg1, Object arg2) throws ModelListenerException {
        //Add your implementation here
    }

    public void onBeforeUpdate(Object model) throws ModelListenerException {
        //Add your implementation here

    }

}