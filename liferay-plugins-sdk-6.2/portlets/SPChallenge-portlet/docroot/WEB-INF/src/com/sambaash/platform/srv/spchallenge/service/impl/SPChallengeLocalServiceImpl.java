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

package com.sambaash.platform.srv.spchallenge.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.search.StringQueryFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.spchallenge.helper.SPChallengeConstants;
import com.sambaash.platform.spchallenge.helper.SPChallengeHelper;
import com.sambaash.platform.spchallenge.helper.SPChallengePermissionHelper;
import com.sambaash.platform.spchallenge.listener.ChallengeListener;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.service.base.SPChallengeLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.SPParameterLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;
import com.sambaash.platform.util.SearchUtils;

/**
 * The implementation of the s p challenge local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.spchallenge.service.base.SPChallengeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spchallenge.service.SPChallengeLocalServiceUtil
 */
public class SPChallengeLocalServiceImpl extends SPChallengeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.spchallenge.service.SPChallengeLocalServiceUtil} to access the s p
	 * challenge local service.
	 */
	public void updateAssets(long userId, SPChallenge challenge, long[] assetCategoryIds)
			throws PortalException, SystemException {

		boolean visible = true;

		assetEntryLocalService.updateEntry(userId, challenge.getGroupId(), SPChallenge.class.getName(),
				challenge.getSpChallengeId(), challenge.getUuid(), 0, assetCategoryIds, null, visible, null, null,
				challenge.getCreateDate(), null, ContentTypes.TEXT_HTML, null, null, null, null, null, 0, 0, null,
				false);
	}

	public List<Document> getChallenges(PortletRequest request, long companyId, int start, int end, String query,
			boolean activeOnly) {
		Hits results = searchChallenges(request, companyId, start, end, query, activeOnly);
		List<Document> list = new ArrayList<Document>();
		if (Validator.isNotNull(results)) {
			int length = results.getDocs().length;
			for (int i = 0; i < length; i++) {
				Document doc = results.doc(i);
				list.add(doc);
			}
		}
		return list;
	}

	public Hits searchChallenges(PortletRequest request, long companyId, int start, int end, String query,
			boolean includeDateCheck) {

		long startTime = System.currentTimeMillis();

		if (logger.isDebugEnabled()) {
			logger.debug(" --- Start searchChallenges SPChallangeLocalServiceImpl" + startTime);
		}

		SearchContext searchContext = new SearchContext();
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setCompanyId(companyId);

		Sort sort = SortFactoryUtil.create(SPChallengeConstants.NAME, Sort.STRING_TYPE, false);
		Sort[] sorts = new Sort[] { sort };
		searchContext.setSorts(sorts);

		String activeQuery = StringPool.BLANK;
		if (includeDateCheck) {
			activeQuery = SearchUtils.getActiveChallengesEndDateOnlyQuery();
		} else {
			activeQuery = "(active:true)";
		}

		if (Validator.isNull(query)) {
			query = activeQuery;
		} else {
			String resultQFormat = "((%s) AND (%s))";
			query = String.format(resultQFormat, query, activeQuery);
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isAdmin = SambaashUtil.isAdmin(themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
		boolean isSignedIn = SambaashUtil.isUserSignedIn(PortalUtil.getHttpServletRequest(request));
		boolean isFoundryAdmin = false;
		long userId = themeDisplay.getUserId();
		try {
			isFoundryAdmin = SambaashUtil.isFoundryAdmin(themeDisplay.getUser());
		} catch (Exception e) {
		}

		String draft = StringPool.BLANK;
		if (!isAdmin && !isFoundryAdmin) {
			if (!isSignedIn) {
				draft = " (draft:false)";
			} else {
				draft = " (draft:false or (draft=true and userId:" + userId + "))";
			}
			query = query.substring(0, query.length() - 1);
			query = query + " AND " + draft + ")";
		}
		logger.info("query = " + query);
		if (Validator.isNotNull(query)) {
			Query stringQuery = StringQueryFactoryUtil.create(query);
			BooleanClause clause = BooleanClauseFactoryUtil.create(searchContext, stringQuery,
					BooleanClauseOccur.MUST.getName());
			searchContext.setBooleanClauses(new BooleanClause[] { clause });
		}
		Hits results = searchChallenges(searchContext);

		if (logger.isDebugEnabled()) {
			logger.debug(" --- End searchChallenges SPChallangeLocalServiceImpl : "
					+ (startTime - System.currentTimeMillis()));
		}

		return results;
	}

	public Hits searchChallenges(SearchContext searchContext) {

		Indexer indexer = IndexerRegistryUtil.getIndexer(SPChallenge.class.getName());
		Hits results = null;
		try {
			results = indexer.search(searchContext);
		} catch (SearchException e) {
			logger.error(e.getMessage(), e);
		}
		return results;
	}

	public String displayChallengeFriendlyURL(ThemeDisplay themeDisplay, long challengeId) {
		return SPChallengeHelper.displayChallengeFriendlyURL(themeDisplay, challengeId, StringPool.DASH);
	}

	public String applyChallengeFriendlyURL(ThemeDisplay themeDisplay, long challengeId, boolean external) {
		return SPChallengeHelper.applyChallengeFriendlyURL(themeDisplay, challengeId, external);
	}

	public String editChallengeFriendlyURL(ThemeDisplay themeDisplay, long challengeId) {
		return SPChallengeHelper.editChallengeFriendlyURL(themeDisplay, challengeId);
	}

	public String addChallengeFriendlyURL(ThemeDisplay themeDisplay) {
		return SPChallengeHelper.createChallengeFriendlyURL(themeDisplay);
	}

	public void addAllChallengesToGraph() {
		try {
			List<SPChallenge> list = getSPChallenges(-1, -1);
			for (SPChallenge spChallenge : list) {
				try {
					ChallengeListener.addOrUpdateGraphData(spChallenge);
				} catch (Exception ex) {
					logger.error("Error while adding challeng to graph " + spChallenge);
				}

			}
		} catch (SystemException e) {
			logger.error(e.getMessage());
		}
	}

	public boolean canUpdateChallenge(PortletRequest request, long challengeId) {
		return SPChallengePermissionHelper.canUpdateChallenge(request, challengeId);
	}
	
	public String displayApplicationFriendlyURL(ThemeDisplay themeDisplay, long applicantId) {
		if (themeDisplay.isSignedIn()) {
			return String.format("%s/-/spchallenge/view/applicant/%s", getChallengesPath(), applicantId);
		} else {

			String loginUrl = SambaashUtil.getSignInURL(themeDisplay.getScopeGroupId(), themeDisplay, true);
			return String.format("%s%sredirect=%s/-/spchallenge/view/applicant/%s", loginUrl,
					loginUrl.contains("?") ? "&" : "?", getChallengesPath(), applicantId);
		}
	}

	public String editApplicationFriendlyURL(ThemeDisplay themeDisplay, long applicantId) {
		if (themeDisplay.isSignedIn()) {
			return String.format("%s/-/spchallenge/edit/applicant/%s", getChallengesPath(), applicantId);
		} else {

			String loginUrl = SambaashUtil.getSignInURL(themeDisplay.getScopeGroupId(), themeDisplay, true);
			return String.format("%s%sredirect=%s/-/spchallenge/edit/applicant/%s", loginUrl,
					loginUrl.contains("?") ? "&" : "?", getChallengesPath(), applicantId);
		}
	}

	
	public String getChallengesPath() {
		String pageHome = "";
		try {
			pageHome = SPParameterLocalServiceUtil
					.findBySPParameterGroupIdAndName(0, SPChallengeConstants.SP_PARAM_CHALLENGE_HOME).getValue();
		} catch (Exception e) {
			pageHome = "/challenges";
		}
		return pageHome;
	}
	
	private static final Log logger = LogFactoryUtil.getLog(SPChallengeLocalServiceImpl.class);

}