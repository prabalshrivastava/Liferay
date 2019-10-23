package com.sambaash.platform.audit.listeners;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPAudit;
import com.sambaash.platform.srv.spservices.service.SPAuditLocalServiceUtil;

public class LayoutListener extends BaseModelListener<Layout> {

	@Override
	public void onAfterCreate(Layout layout) {
	}

	@Override
	public void onAfterRemove(Layout layout) {
		try {
			_log.error("Debugging Purpose:: Layout deleted. Friendly url " +layout.getFriendlyURL() + " layout id" + layout.getLayoutId() );
			_log.error("Debugging Purpose:: Layout deleted. " + layout);
			log(layout,SPAuditConstants.ACTION_AFTER_REMOVE);
			
		} catch (Exception e) {
			_log.error("Error while auditing layout deletion");
		}
	}
	public void log(Layout layout,String action) {
		try {
			AuditHelper helper = new AuditHelper();
			SPAudit audit = helper.createAudit();
			
			ClassName className = ClassNameLocalServiceUtil.getClassName(Layout.class.getCanonicalName());
			audit.setEntityClassNameId(className.getClassNameId());
			audit.setEntityId(layout.getPlid());
			audit.setAction(action);
			
			audit.setField1Str(layout.getFriendlyURL());
			audit.setField1Long(layout.getLayoutId());
			// Get the portled Ids attached to this layout and save them to audit
			try {
				audit.setData1(helper.getJson(layout));
			} catch (Exception e) {
				_log.error(e);
				audit.setData1(layout.toString());
			}
			
			SPAuditLocalServiceUtil.updateSPAudit(audit);
			
		} catch (Exception e) {
			_log.error("Error while auditing layout deletion" );
		}
	}

	@Override
	public void onAfterUpdate(Layout layout) {
		
	}

	@Override
	public void onBeforeRemove(Layout layout) throws ModelListenerException {
		try {
			log(layout,SPAuditConstants.ACTION_BEFORE_REMOVE);
		} catch (Exception e) {
			_log.error("Error while auditing layout deletion");
		}
	}
	
    private static final Log _log = LogFactoryUtil.getLog(LayoutListener.class);
}