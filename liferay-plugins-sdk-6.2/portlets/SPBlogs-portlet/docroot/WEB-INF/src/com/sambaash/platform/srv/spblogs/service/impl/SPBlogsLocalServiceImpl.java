/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.spblogs.service.impl;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;

import com.liferay.portlet.blogs.model.BlogsEntry;
import com.sambaash.platform.srv.spblogs.service.base.SPBlogsLocalServiceBaseImpl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the s p blogs local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spblogs.service.SPBlogsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author nebrawski
 * @see com.sambaash.platform.srv.spblogs.service.base.SPBlogsLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spblogs.service.SPBlogsLocalServiceUtil
 */
public class SPBlogsLocalServiceImpl extends SPBlogsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spblogs.service.SPBlogsLocalServiceUtil} to access the s p blogs local service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(SPBlogsLocalServiceImpl.class);
	
	
	public static final String DEFAULT_CHARSET = "UTF-8";
	
	public String retrieveBlogImageUrl(long blogId) {
		try {
			BlogsEntry blog = blogsEntryLocalService.getBlogsEntry(blogId);
			return retrieveImageUrlFromHtml(blog.getContent());
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return "";
	}
	
	public String retrieveImageUrlFromHtml(String content) {
		String imageUrl = "";
		try {
			Parser parser = Parser.createParser(content, DEFAULT_CHARSET);
			TagNameFilter filter = new TagNameFilter("img");
			NodeList nodeList = parser.parse(filter);
			Node node = null;

			if (nodeList.size() > 0) {
				node = nodeList.elementAt(0);
				imageUrl = ((ImageTag) node).getAttribute("src");
			}			
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return imageUrl;
	}

}