"use strict";

const SPFormPermissionHandler = function SPFormPermissionHandler() {
	var _hasAccess = function(permittedRoles, userRoles) {
		// no permitted roles settings, then any user has access
		// this is for convenience. else we have to set permission for each component.
		// Hence, we only setup for exception cases.
		if (!permittedRoles || permittedRoles.length==0) {
			return true;
		}
		
		// permission settings found
		// check user roles against permitted roles
		var valid = false;
		userRoles.forEach(function(role){
			if (permittedRoles.indexOf(role) >= 0) {
				valid = true;
				return valid;
			}
		});
		
		return valid;
	}
	
	var _getPermittedRoleList = function(permissionList) {
		var roleList = [];
		permissionList.forEach(function(permission){
			roleList.push(permission.siteRoleId);
		});
		return roleList;
	}
	
	var _checkCreatePermission = function(componentsMap,  fieldList, userRoles) {
		var valid = true;
	    fieldList.forEach(function(field) {
	    	if (field.platform && field.platform.permission) {
	    		var permittedRoles = _getPermittedRoleList(field.platform.permission.create);
	    		
	    		if (!_hasAccess(permittedRoles, userRoles)) {
	    			var component = componentsMap[field.key];
	    			if (component) {
	    				component.disabled = true;
	    			}
	    			valid = false;
	    		}
	    	}
	    });
	    return valid;
	}
	
	var _checkReadPermission = function(componentsMap,  fieldList, userRoles) {
		var valid = true;
	    fieldList.forEach(function(field) {
	    	if (field.platform && field.platform.permission) {
	    		var permittedRoles = _getPermittedRoleList(field.platform.permission.read);
	    		
	    		if (!_hasAccess(permittedRoles, userRoles)) {
	    			var component = componentsMap[field.key];
	    			if (component) {
	    				component.visible = false;
	    				component.element.style.display = "none";
	    			}
	    			valid = false;
	    		}
	    	}
	    });
	    return valid;		
	}
	
	var _checkUpdatePermission = function(componentsMap,  fieldList, userRoles) {
		var valid = true;
	    fieldList.forEach(function(field) {
	    	if (field.platform && field.platform.permission) {
	    		var permittedRoles = _getPermittedRoleList(field.platform.permission.update);
	    		
	    		if (!_hasAccess(permittedRoles, userRoles)) {
	    			var component = componentsMap[field.key];
	    			if (component) {
	    				component.disabled = true;
	    			}
	    			valid = false;
	    		}
	    	}
	    });
	    return valid;		
	}
	
	var _checkDeletePermission = function(componentsMap,  fieldList, userRoles) {
		var valid = true;
	    fieldList.forEach(function(field) {
	    	if (field.platform && field.platform.permission) {
	    		var permittedRoles = _getPermittedRoleList(field.platform.permission['delete']);	    		
	    		if (!_hasAccess(permittedRoles, userRoles)) {
	    			valid = false;
	    		}
	    	}
	    });
	    return valid;		
	}
	
	var modePermissionHandlers = {
			"create" : _checkCreatePermission,
			"copy" : _checkCreatePermission,
			"view" : _checkReadPermission,
			"edit" : _checkUpdatePermission,
			"delete" : _checkDeletePermission
		};
		
	var _applyPermission = function _applyPermission(formInstance) {
		var mode = formInstance.mode.toLocaleLowerCase();
		
		var componentsMap = {};
		Object.values(formInstance.components).forEach(function(c) {
			componentsMap[c.component.key] = c;
		});

		Liferay.Service(
		  '/SPMicroservice-portlet.spmicroservice/get-form-fields',
		  {
		    formId: formInstance.formId,
		    includeLayout: true,
		    fullInfo: true
		  },
		  function(fieldList) {
			// apply enabling permissions
		    modePermissionHandlers[mode](componentsMap, fieldList, formInstance.userRoles);
		    // apply visibility permissions
		    modePermissionHandlers["view"](componentsMap, fieldList, formInstance.userRoles);
		    // do some operation after permission checked
		    afterPermissionsChecked(formInstance);
		  }
		);
		
		
	}
	
	return {
		checkPermission : _applyPermission,
		hasAccess : _hasAccess
	}
}();