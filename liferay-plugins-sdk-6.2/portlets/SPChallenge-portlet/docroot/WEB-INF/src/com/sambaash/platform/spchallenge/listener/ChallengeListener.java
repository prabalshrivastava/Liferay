package com.sambaash.platform.spchallenge.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.sambaash.platform.model.ActivityFeedType;
import com.sambaash.platform.model.spneo4j.form.AssetEntityGraphForm;
import com.sambaash.platform.model.spneo4j.form.RealtimeActivityFeedForm;
import com.sambaash.platform.model.spneo4j.wrapper.AssetEntityGraphWrapper;
import com.sambaash.platform.model.spneo4j.wrapper.UserGraphWrapper;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.util.Neo4jHelper;
import com.sambaash.platform.util.SambaashUtil;

public class ChallengeListener {

	private static Log logger = LogFactoryUtil.getLog(ChallengeListener.class);

	private static void LOG(String msg) {
		if (logger.isDebugEnabled()) {
			logger.debug(msg);
		}
	}

	public void onAfterCreate(SPChallenge challenge)
			throws ModelListenerException {
		try {
			LOG("Challenge onAfterCreate event :" + challenge
					+ "SambaashUtil.isNeo4jEnabled() ="
					+ SambaashUtil.isNeo4jEnabled());
			if (SambaashUtil.isNeo4jEnabled()) {

				String communityName = SambaashUtil.getCommunityName(challenge
						.getGroupId());
				AssetEntityGraphForm assetEntityGraphForm = getAssetEntityGraph(challenge);

				SPNeoforjLocalServiceUtil
						.addAssetEntityGraph(assetEntityGraphForm);
				// push real time activity

				if (challenge.isActive()) {
					List<UserGraphWrapper> followers = SPNeoforjLocalServiceUtil
							.findUserFollowers(challenge.getUserId(),
									challenge.getCompanyId(),
									challenge.getGroupId(), -1L, 0, 100000);
					List<String> sendToUsers = new ArrayList<String>();

					for (UserGraphWrapper follower : followers) {
						sendToUsers.add(follower.getScreenName());
					}

					if (SambaashUtil.isWebSocketEnabled()) {
						SPNeoforjLocalServiceUtil
								.pushRealtimeActivityFeed(new RealtimeActivityFeedForm(
										communityName, SPChallenge.class
												.getName(), challenge
												.getSpChallengeId(),
										ActivityFeedType.ADD_ENTITY.getValue(),
										sendToUsers));
					}
				}
			}

		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	public void onAfterRemove(SPChallenge challenge)
			throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				LOG("***************** onAfterRemove SPChallenge ********************");

				long classPK = challenge.getSpChallengeId();

				SPNeoforjLocalServiceUtil.removeAssetEntityGraph(
						SPChallenge.class.getName(), classPK,
						challenge.getCompanyId(), challenge.getGroupId(), -1L);
			}

		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	public static void onAfterUpdate(SPChallenge challenge)
			throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				LOG("***************** onAfterUpdate SPChallenge ********************");
				addOrUpdateGraphData(challenge);
			}

		} catch (Exception e) {
			logger.error(e);
			throw new ModelListenerException(e);
		}
	}

	public static void addOrUpdateGraphData(SPChallenge challenge) {
		AssetEntityGraphForm assetEntityGraphForm = getAssetEntityGraph(challenge);
		boolean update = true;
		try {
			AssetEntityGraphWrapper assetEntityGraphWrapper = SPNeoforjLocalServiceUtil
					.findAssetEntityGraph(challenge.getCompanyId(),
							challenge.getGroupId(), -1L,
							SPChallenge.class.getName(),
							challenge.getSpChallengeId());
			if (Validator.isNull(assetEntityGraphWrapper)) {
				update = false;
			}
		} catch (Exception ex) {
			update = false;
		}
		if (update) {
			SPNeoforjLocalServiceUtil
					.updateAssetEntityGraph(assetEntityGraphForm);
		} else {
			SPNeoforjLocalServiceUtil
					.addAssetEntityGraph(assetEntityGraphForm);
		}
	}

	private static AssetEntityGraphForm getAssetEntityGraph(
			SPChallenge challenge) {

		long classPK = challenge.getSpChallengeId();
		String title = challenge.getName();
		String urlTitle = challenge.getName();
		String content = challenge.getDescription();
		long userId = challenge.getUserId();
		int status = 0;
		Date createDate = challenge.getCreateDate();
		Date modifiedDate = challenge.getModifiedDate();

		String imageUrl = SambaashUtil.getDLFileUrl(challenge.getLogoId());

		AssetEntityGraphForm assetEntityGraphForm = new AssetEntityGraphForm();

		assetEntityGraphForm.setClassName(SPChallenge.class.getName());
		assetEntityGraphForm.setClassPK(classPK);
		assetEntityGraphForm.setTitle(title);
		assetEntityGraphForm.setUrlTitle(urlTitle);
		assetEntityGraphForm.setContent(StringUtil.shorten(
				HtmlUtil.extractText(content), 400));
		assetEntityGraphForm.setImageUrl(imageUrl);
		assetEntityGraphForm.setUserId(userId);
		assetEntityGraphForm.setStatus(status);
		assetEntityGraphForm.setCreateDate(createDate);
		assetEntityGraphForm.setModifiedDate(modifiedDate);

		Neo4jHelper.fillMandatoryFields(assetEntityGraphForm, challenge.getCompanyId(), challenge.getGroupId(), -1L);

		try {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
					SPChallenge.class.getName(), challenge.getSpChallengeId());
			if (assetEntry != null) {
				List<Long> catIds = ListUtil
						.toList(assetEntry.getCategoryIds());
				if (catIds.size() > 0)
					assetEntityGraphForm.setCategoryIds(catIds);
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return assetEntityGraphForm;
	}

	private static Log _log = LogFactoryUtil.getLog(ChallengeListener.class);

}