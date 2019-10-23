package com.sambaash.platform.portlet.blogsmostpopular.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class BlogsMostPopularAction
 */
public class BlogsMostPopularAction extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			List<AssetEntry> topTagsAssets = AssetEntryLocalServiceUtil.getTopViewedEntries(BlogsEntry.class.getName(), false, 0, 5);

			renderRequest.setAttribute("topTagsAssets", topTagsAssets);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	private static Log logger = LogFactoryUtil.getLog(BlogsMostPopularAction.class);

}