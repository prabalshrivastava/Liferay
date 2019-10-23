package com.sambaash.platform.product.util;

import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.sambaash.platform.srv.model.Course;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;


public class SPCourseProductIndexerThread implements Runnable {
	private static final Log _log = LogFactoryUtil.getLog(Course.class);
	
	private Course course;
	private User user;
	
	public SPCourseProductIndexerThread(Course framework, User user){
		this.course = framework;
		this.user = user;
	}

	@Override
	public void run() {
		
		_log.debug("SPCourseProductIndexerThread is intialised");
		Indexer indexer = IndexerRegistryUtil.getIndexer(Product.class);
		try {
			initializePermissionChecker(user);
			List<Product> productList = ProductLocalServiceUtil.findByGroupIdAndCourseId(course.getGroupId(), course.getSpCourseId());
			for(Product product : productList){
				_log.debug("The product being reindexed is productId="+product.getSpProductId());
				indexer.reindex(product);
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