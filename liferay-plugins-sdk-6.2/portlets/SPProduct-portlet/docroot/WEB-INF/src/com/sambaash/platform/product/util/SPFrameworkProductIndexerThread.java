package com.sambaash.platform.product.util;

import java.util.List;

import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.srv.model.CourseModule;
import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.model.ModuleFramework;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.service.CourseModuleLocalServiceUtil;
import com.sambaash.platform.srv.service.ModuleFrameworkLocalServiceUtil;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;


public class SPFrameworkProductIndexerThread implements Runnable {
	private static final Log _log = LogFactoryUtil.getLog(Framework.class);
	
	private Framework framework;
	private User user;
	
	public SPFrameworkProductIndexerThread(Framework framework, User user){
		this.framework = framework;
		this.user = user;
	}

	@Override
	public void run() {
		
		_log.debug("SPFrameworkProductIndexerThread is intialised");
		long frameworkId = framework.getSpFrameworkId();
		long groupId = framework.getGroupId();

		Indexer indexer = IndexerRegistryUtil.getIndexer(Product.class);
		
		try {
			
			initializePermissionChecker(user);
			
			List<ModuleFramework> moduleFrameworkList = ModuleFrameworkLocalServiceUtil.findByFrameworkIdAndGroupId(frameworkId, groupId);

			for (ModuleFramework moduleFramework : moduleFrameworkList){
				List<CourseModule> courseModuleList = CourseModuleLocalServiceUtil.findByModuleIdAndGroupId(moduleFramework.getSpModuleId(), moduleFramework.getGroupId());
				for(CourseModule courseModule : courseModuleList){
					List<Product> productList = ProductLocalServiceUtil.findByGroupIdAndCourseId(courseModule.getGroupId(), courseModule.getSpCourseId());
					for(Product product : productList){
						_log.debug("The product being reindexed is productId="+product.getSpProductId());
						indexer.reindex(product);
					}
				
				}
			
			}
			
		} catch (Exception e) {
			_log.error(e);
		}
		
	}
	
	public  void initializePermissionChecker(User logedInUser) throws Exception {
		PrincipalThreadLocal.setName(logedInUser.getUserId());
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(logedInUser);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
	}
}