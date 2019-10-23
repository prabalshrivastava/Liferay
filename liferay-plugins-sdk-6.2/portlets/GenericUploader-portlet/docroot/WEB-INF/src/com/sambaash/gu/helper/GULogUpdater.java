package com.sambaash.gu.helper;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.srv.genericuploader.model.GUUploadLog;
import com.sambaash.platform.srv.genericuploader.service.GUUploadLogLocalServiceUtil;

public class GULogUpdater {
	private static final Log _log = LogFactoryUtil.getLog(GUUploader.class);
	
	private GUUploadLog uploadLog;
	
	public GULogUpdater(GUUploadLog uploadLog){
		this.uploadLog = uploadLog;
	}

	public void run() {
	
//		_log.debug("Updating Uploader Log. UploadLog - Id " + uploadLog.getSPGUUploadLogId());
//		while(uploadLog.getEndTime() == null){
//			if(_log.isDebugEnabled()){
//				_log.debug("Running GUUploadLogId : " + uploadLog.getSPGUUploadLogId());
//			}
//			
//			try {
//				GUUploadLogLocalServiceUtil.updateGUUploadLog(uploadLog);
//			} catch (SystemException e) {
//				_log.error(e);
//			}
//			
//		}
		
		try {
			GUUploadLogLocalServiceUtil.updateGUUploadLog(uploadLog);
		} catch (SystemException e) {
			_log.error(e);
		}
		
	}

}
