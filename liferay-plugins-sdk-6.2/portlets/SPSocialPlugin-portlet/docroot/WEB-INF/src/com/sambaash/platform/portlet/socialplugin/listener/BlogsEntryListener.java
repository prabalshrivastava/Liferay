package com.sambaash.platform.portlet.socialplugin.listener;

import java.util.Date;

import org.htmlparser.util.ParserException;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.User;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.model.BlogsStatsUser;
import com.liferay.portlet.blogs.service.BlogsStatsUserLocalServiceUtil;
import com.sambaash.platform.portlet.socialplugin.util.SocialSharingUtil;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
import com.sambaash.platform.srv.spsocialsharing.service.SPSocialSharingLocalServiceUtil;

public class BlogsEntryListener extends BaseModelListener<BlogsEntry> {

	@Override
	public void onAfterUpdate(BlogsEntry blog) throws ModelListenerException {
/*
		try {
			BlogsStatsUser statsUser = BlogsStatsUserLocalServiceUtil
					.getStatsUser(blog.getGroupId(), blog.getUserId());
			Date lastDisplayDate = blog.getDisplayDate();
			Date lastPostDate = statsUser.getLastPostDate();

			if (Validator.isNull(lastPostDate)) {
				lastPostDate = new Date();
			}

			if ((blog.isApproved()) && (lastDisplayDate.after(lastPostDate))) { // blog
																				// has
																				// been
																				// pulished
																				// and
																				// not
																				// yet
																				// shared
																				// to
																				// social
																				// networks
				try {
					long groupId = blog.getGroupId();
					long companyId = blog.getCompanyId();
					String url = getBlogsEntryURL(blog.getUrlTitle(),
							blog.getCompanyId(), blog.getGroupId());

					User user = UserLocalServiceUtil.getUser(blog.getUserId());

					SocialProfile profile = SocialProfileLocalServiceUtil
							.getSocialProfile(blog.getUserId());

					String blogsImg = blog.getSmallImageURL();

					if (Validator.isNull(blogsImg)) {
						try {
							blogsImg = SocialSharingUtil
									.getImageUrlFromHtml(blog.getContent());
						} catch (ParserException e) {
							_log.error("Unable to extract image from contents");
						}
					}

					SPSocialSharingLocalServiceUtil.postBlogToSocialNetwork(
							blog.getEntryId(), blog.getTitle(),
							StringPool.BLANK, url, blogsImg, companyId,
							groupId, profile, user);

				} catch (PortalException e) {
					_log.error(e.getMessage(), e);
				} catch (SystemException e) {
					_log.error(e.getMessage(), e);
				}
			}

		} catch (PortalException e1) {
			_log.error(e1.getMessage(), e1);
		} catch (SystemException e1) {
			_log.error(e1.getMessage(), e1);
		} */
	}

	/**
	 * BlogsEntry friendlyURL mapping
	 * 
	 * @param urlTitle
	 * @param companyId
	 * @param groupId
	 * @return BlogsEntry friendly url mapping
	 */
	protected String getBlogsEntryURL(String urlTitle, long companyId,
			long groupId) {
		StringBundler sb = new StringBundler(5);

		String layoutFullURL;
		try {
			layoutFullURL = PortalUtil.getLayoutFullURL(groupId,
					PortletKeys.BLOGS);
			sb.append(layoutFullURL);

			sb.append(Portal.FRIENDLY_URL_SEPARATOR);

			Portlet portlet = PortletLocalServiceUtil.getPortletById(companyId,
					PortletKeys.BLOGS);

			sb.append(portlet.getFriendlyURLMapping());
			sb.append(StringPool.SLASH);
			sb.append(urlTitle);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
		}

		return sb.toString();
	}

	private static Log _log = LogFactoryUtil.getLog(BlogsEntryListener.class);

}