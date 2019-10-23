package com.sambaash.platform.portlet.spadmin.action;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.beanutils.ConvertUtils;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.ThreadUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.srv.legalandcontract.model.Agency;
import com.sambaash.platform.srv.legalandcontract.model.Litigation;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.spgroup.model.SPGroup;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class SPAdminAction
 */
public class SPAdminAction extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean isAdminSupport = SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());

		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		if (!permissionChecker.isOmniadmin() && !isAdminSupport) {
			renderRequest.setAttribute("authorised", false);
		} else {
			renderRequest.setAttribute("authorised", true);
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean isAdminSupport = SambaashUtil.isSupportRole(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());

		String errorMsg = StringPool.BLANK;

		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		if (!permissionChecker.isOmniadmin() && !isAdminSupport) {
			actionRequest.setAttribute("errorMsg", "Not authorised to access");
			return;
		}

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		String msg = "Request processed successfuly";

		try {
			if (cmd.equals("cacheDb")) {
				cacheDb();
			} else if (cmd.equals("cacheMulti")) {
				cacheMulti();
			} else if (cmd.equals("cacheSingle")) {
				cacheSingle();
			} else if (cmd.equals("gc")) {
				gc();
			} else if (cmd.equals("reindexTrademark")) {
				reindex(themeDisplay.getCompanyId(), "reindexTrademark");
			} else if (cmd.equals("reindexLawFirms")) {
				reindex(themeDisplay.getCompanyId(), "reindexLawFirms");
			} else if (cmd.equals("reindexContentiousProceedings")) {
				reindex(themeDisplay.getCompanyId(), "reindexContentiousProceedings");
			} else if (cmd.equals("reindexSPGroups")) {
				reindex(themeDisplay.getCompanyId(), "reindexSPGroups");
				reindex(themeDisplay.getCompanyId(), "reindexUser");
				reindex(themeDisplay.getCompanyId(), "reindexSocialProfile");
				reindex(themeDisplay.getCompanyId(), "reindexStartups");
				reindex(themeDisplay.getCompanyId(), "reindexChallenges");
			} else if (cmd.equals("threadDump")) {
				errorMsg = threadDump();
			} else {
				errorMsg = "Action not defined";
			}

		} catch (SearchException se) {
			errorMsg = se.getMessage();
		} catch (Exception ex) {
			errorMsg = ex.getMessage();
		}

		if (Validator.isNotNull(errorMsg)) {
			actionRequest.setAttribute("errorMsg", errorMsg);
		} else {
			actionRequest.setAttribute("successMsg", msg);
		}
	}

	protected void cacheDb() {
		CacheRegistryUtil.clear();
	}

	protected void cacheMulti() {
		MultiVMPoolUtil.clear();
	}

	protected void cacheSingle() {
		WebCachePoolUtil.clear();
	}

	protected void gc() {
		Runtime.getRuntime().gc();
	}

	protected void reindex(long companyId, String type) throws SearchException {

		_log.error("Reindexing begin... " + type);

		Indexer indexer = null;

		if ("reindexLawFirms".equalsIgnoreCase(type)) {
			indexer = IndexerRegistryUtil.getIndexer(Agency.class.getName());
		} else if ("reindexTrademark".equalsIgnoreCase(type)) {
			indexer = IndexerRegistryUtil.getIndexer(Trademarks.class.getName());
		} else if ("reindexContentiousProceedings".equalsIgnoreCase(type)) {
			indexer = IndexerRegistryUtil.getIndexer(Litigation.class.getName());
		} else if ("reindexSPGroups".equalsIgnoreCase(type)) {
			indexer = IndexerRegistryUtil.getIndexer(SPGroup.class.getName());
		} else if ("reindexUser".equalsIgnoreCase(type)) {
			indexer = IndexerRegistryUtil.getIndexer(User.class.getName());
		} else if ("reindexSocialProfile".equalsIgnoreCase(type)) {
			indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class.getName());
		} else if ("reindexStartups".equalsIgnoreCase(type)) {
			indexer = IndexerRegistryUtil.getIndexer(Organization.class.getName());
		} else if ("reindexChallenges".equalsIgnoreCase(type)) {
			indexer = IndexerRegistryUtil.getIndexer(SPChallenge.class.getName());
		}

		indexer.reindex((String[]) ConvertUtils.convert(PortalUtil.getPortal().getCompanyIds(), String[].class));

		_log.error("Reindexing end... ");

	}

	protected String threadDump() {
		String msg = StringPool.BLANK;

		if (_log.isInfoEnabled()) {
			_log.info(ThreadUtil.threadDump());
		} else {
			msg = "Thread dumps require the log level to be at least INFO";
			_log.error("Thread dumps require the log level to be at least INFO for " + getClass().getName());
		}

		return msg;
	}

	private static Log _log = LogFactoryUtil.getLog(SPAdminAction.class);

}