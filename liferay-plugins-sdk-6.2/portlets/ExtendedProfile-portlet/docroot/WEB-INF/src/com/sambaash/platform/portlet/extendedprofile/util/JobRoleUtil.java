package com.sambaash.platform.portlet.extendedprofile.util;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.platform.srv.extendedprofile.NoSuchSPJobRoleException;
import com.sambaash.platform.srv.extendedprofile.model.SPCompetency;
import com.sambaash.platform.srv.extendedprofile.model.SPJobRole;
import com.sambaash.platform.srv.extendedprofile.service.SPCompetencyLocalServiceUtil;
import com.sambaash.platform.srv.extendedprofile.service.SPJobRoleLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.SPListType;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;
public class JobRoleUtil {

		private static final Log logger = LogFactoryUtil.getLog(JobRoleUtil.class);

		private static List<AssetVocabulary> assetVocabularies;

		private static List<AssetCategory> interestCategories = null;

		private long interestCategoryId = 0;

		public static void populateJobLevelValues(ResourceResponse response, String jobRoleVocabularyId) {
			logger.info("assetCategories frm populateJobLevelValues " + jobRoleVocabularyId);
			List<AssetCategory> assetCategories = null;
			JSONObject jobLevelCategoriesJSONObject = JSONFactoryUtil.createJSONObject();

			try {
				assetCategories = getInterestCategories(Long.parseLong(jobRoleVocabularyId));

				for (AssetCategory av : assetCategories) {
					jobLevelCategoriesJSONObject.put(String.valueOf(av.getCategoryId()), av.getName());
				}

				response.getWriter().append(jobLevelCategoriesJSONObject.toString());
			} catch (NumberFormatException e) {
				logger.error(e);
			} catch (SystemException e) {
				logger.error(e);
			} catch (IOException e) {
				logger.error(e);
			}

			logger.info("assetCategories frm doview " + jobLevelCategoriesJSONObject.toString());
		}

		public static void populateCompetencyValues(String competencyVocabularyId, ResourceResponse resourceResponse) {

			logger.info("assetCategories frm populateCompetencyValues " + competencyVocabularyId);
			List<AssetCategory> assetCategories = null;
			JSONObject jobLevelCategoriesJSONObject = JSONFactoryUtil.createJSONObject();

			try {
				assetCategories = getInterestCategories(Long.parseLong(competencyVocabularyId));

				for (AssetCategory av : assetCategories) {
					jobLevelCategoriesJSONObject.put(String.valueOf(av.getCategoryId()), av.getName());
				}

				resourceResponse.getWriter().append(jobLevelCategoriesJSONObject.toString());
			} catch (NumberFormatException e) {
				logger.error(e);
			} catch (SystemException e) {
				logger.error(e);
			} catch (IOException e) {
				logger.error(e);
			}

			logger.info("assetCategories frm populateCompetencyValues " + jobLevelCategoriesJSONObject.toString());
		}

		public static String saveJobRoleInformation(String jobRoleId, String jobLevelId, String competencyId, String competencyLevelId, String compPubliclyView, long userId,
				String careerPath, ResourceResponse resourceResponse) throws SystemException {
			logger.info("saveJobRoleInformation " + competencyId);
			JSONObject json = JSONFactoryUtil.createJSONObject();
			long classPk = 0;
			SPJobRole jobRole = null;
			SPCompetency competency = null;
			Date createDate = Calendar.getInstance().getTime();
			Date modifiedDate = Calendar.getInstance().getTime();

			try {
				jobRole = SPJobRoleLocalServiceUtil.findByJobRole(userId);
				logger.info("inside if " + jobRole);

				String[] cIds = competencyId.split(",");
				String[] clIds = competencyLevelId.split(",");
				String[] cpvs = compPubliclyView.split(",");

				List<SPCompetency> competencyList = SPCompetencyLocalServiceUtil.findByCompetencyListByJobRole(jobRole.getSpJobRoleId());
				Iterator<SPCompetency> competencyListItr = competencyList.iterator();

				while (competencyListItr.hasNext()) {
					SPCompetency oldCompetency = SPCompetencyLocalServiceUtil.fetchSPCompetency(competencyListItr.next().getClasspk());
					createDate = oldCompetency.getCreateDate();
					SPCompetencyLocalServiceUtil.deleteSPCompetency(oldCompetency);
				}

				jobRole.setJobLevelId(Long.parseLong(jobLevelId));
				jobRole.setFunctionalGroupId(Long.parseLong(jobRoleId));
				jobRole.setModifiedDate(modifiedDate);
				jobRole.setCareerPathId(Long.parseLong(careerPath));
				SPJobRole newJobRole = SPJobRoleLocalServiceUtil.updateSPJobRole(jobRole);

				for (int i = 0; i < cIds.length; i++) {
					long compId = CounterLocalServiceUtil.increment("Competency.class");
					competency = SPCompetencyLocalServiceUtil.createSPCompetency(compId);
					competency.setClasspk(compId);
					competency.setUserId(userId);
					competency.setBelongsToJobRole(newJobRole.getSpJobRoleId());
					competency.setCreateDate(createDate);
					competency.setModifiedDate(modifiedDate);
					competency.setCategoryId(0);
					competency.setCompetencyId(Long.parseLong(cIds[i]));
					competency.setCompetencyLevelId(Long.parseLong(clIds[i]));
					competency.setPublicView(Boolean.valueOf(cpvs[i]));
					SPCompetencyLocalServiceUtil.addSPCompetency(competency);
				}

				json.put("status", "200");
				json.put("message", "JobRole update successfully");
			} catch (SystemException e) {

				// TODO Auto-generated catch block

				logger.error(e);
				;
				json.put("status", "404");
				json.put("message", "An Unexpected Error occured.Please try again later");
			} catch (NoSuchSPJobRoleException e) {

				// TODO Auto-generated catch block

				logger.error(e);
				;

				if (jobRole == null) {
					logger.info("inside if");
					classPk = CounterLocalServiceUtil.increment("JobRole.class");
					jobRole = SPJobRoleLocalServiceUtil.createSPJobRole(classPk);
					jobRole.setSpJobRoleId(classPk);
					jobRole.setUserId(userId);
					jobRole.setCreateDate(createDate);
					jobRole.setJobLevelId(Long.parseLong(jobLevelId));
					jobRole.setFunctionalGroupId(Long.parseLong(jobRoleId));
					jobRole.setModifiedDate(modifiedDate);
					jobRole.setCareerPathId(Long.parseLong(careerPath));
					SPJobRoleLocalServiceUtil.addSPJobRole(jobRole);

					String[] cIds = competencyId.split(",");
					String[] clIds = competencyLevelId.split(",");

					for (int i = 1; i < cIds.length; i++) {
						long compId = CounterLocalServiceUtil.increment("Competency.class");
						competency = SPCompetencyLocalServiceUtil.createSPCompetency(compId);
						competency.setClasspk(compId);
						competency.setUserId(userId);
						competency.setBelongsToJobRole(classPk);
						competency.setCreateDate(createDate);
						competency.setModifiedDate(modifiedDate);
						competency.setCategoryId(0);
						competency.setCompetencyId(Long.parseLong(cIds[i]));
						competency.setCompetencyLevelId(Long.parseLong(clIds[i]));
						SPCompetencyLocalServiceUtil.addSPCompetency(competency);
					}
				}

				json.put("status", "200");
				json.put("message", "JobRole update successfully");
			}

			SocialProfile socialProfile = null;
			try {
				socialProfile = SocialProfileLocalServiceUtil.getSocialProfile(userId);
				Indexer indexer = IndexerRegistryUtil.getIndexer(SocialProfile.class.getName());
				indexer.reindex(socialProfile);
			}catch (Exception e) {
				if (e instanceof NoSuchSocialProfileException) {

					// do nothing

				}else {
					logger.error(e.getMessage(), e);
				}
			}

			logger.info("jobRole " + jobRole);
			return json.toString();
		}

		public static SPJobRole getJobRoleByUserId(long userId) throws SystemException {

			SPJobRole jobRole = null;

			try {
				jobRole = SPJobRoleLocalServiceUtil.findByJobRole(userId);
			} catch (NoSuchSPJobRoleException e) {

				// TODO Auto-generated catch block

				logger.error(e);
				;
			}

			return jobRole;
		}

		public long getInterestCategoryId() {
			return interestCategoryId;
		}

		public void setInterestCategoryId(long interestCategoryId) {
			this.interestCategoryId = interestCategoryId;
		}

		public static List<AssetCategory> getInterestCategories(long vocabularyId) throws SystemException {
			initInterestCategories(vocabularyId);
			return interestCategories;
		}

		public static void initInterestCategories(long vocabularyId) throws SystemException {
			int noOfCategories = AssetCategoryLocalServiceUtil.getAssetCategoriesCount();
			interestCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, 0, noOfCategories, null);
		}

		public static List<AssetVocabulary> getAssetVocabularies() throws SystemException {
			initAssetVocabularies();
			return assetVocabularies;
		}

		public static void initAssetVocabularies() throws SystemException {
			if (assetVocabularies == null) {
				assetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
			}
		}

		public static List<SPListType> getSPListType(String key, long groupId) {
			try {
				return SPListTypeLocalServiceUtil.getByKey(key, groupId);
			} catch (SystemException e) {
				return null;
			}
		}

		public static void populateCareerPathValues(String careerUrlId, ResourceResponse resourceResponse) {
			JSONObject careerPathJSONObject = JSONFactoryUtil.createJSONObject();
			SPListType urlList = null;

			try {
				urlList = SPListTypeLocalServiceUtil.getSPListType(Long.parseLong(careerUrlId));
				careerPathJSONObject.put(String.valueOf(urlList.getSpListTypeId()), urlList.getItemValue());
				resourceResponse.getWriter().append(careerPathJSONObject.toString());
			} catch (PortalException e) {
				logger.error(e);
			} catch (NumberFormatException e) {
				logger.error(e);
			} catch (SystemException e) {
				logger.error(e);
			} catch (IOException e) {
				logger.error(e);
			}
		}
	}