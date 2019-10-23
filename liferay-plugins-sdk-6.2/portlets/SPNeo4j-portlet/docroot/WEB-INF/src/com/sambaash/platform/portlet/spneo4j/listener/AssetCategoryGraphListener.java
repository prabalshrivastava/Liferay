package com.sambaash.platform.portlet.spneo4j.listener;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.asset.model.AssetCategory;
import com.sambaash.platform.model.spneo4j.form.AssetCategoryGraphForm;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.util.Neo4jHelper;
import com.sambaash.platform.util.SambaashUtil;

public class AssetCategoryGraphListener extends
		BaseModelListener<AssetCategory> {

	@Override
	public void onAfterCreate(AssetCategory assetCategory)
			throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterCreate user ********************");

				long categoryId = assetCategory.getCategoryId();
				String name = assetCategory.getName();
				long vocabularyId = assetCategory.getVocabularyId();

				AssetCategoryGraphForm assetCategoryGraphForm = new AssetCategoryGraphForm();
				assetCategoryGraphForm.setCategoryId(categoryId);
				assetCategoryGraphForm.setName(name);
				assetCategoryGraphForm.setVocabularyId(vocabularyId);

				assetCategoryGraphForm.setCommunityName(PropsUtil
						.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME));
				Neo4jHelper.fillMandatoryFields(assetCategoryGraphForm,
						assetCategory.getCompanyId(),
						assetCategory.getGroupId(), -1L);

				SPNeoforjLocalServiceUtil
						.addAssetCategoryGraph(assetCategoryGraphForm);
			}
		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	@Override
	public void onAfterRemove(AssetCategory assetCategory)
			throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterRemove user ********************");

				long categoryId = assetCategory.getCategoryId();

				SPNeoforjLocalServiceUtil.removeAssetCategoryGraph(categoryId,
						assetCategory.getCompanyId(),
						assetCategory.getGroupId(), -1L);
			}
		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	@Override
	public void onAfterUpdate(AssetCategory assetCategory)
			throws ModelListenerException {
		try {
			if (SambaashUtil.isNeo4jEnabled()) {
				_log.debug("***************** onAfterUpdate user ********************");

				long categoryId = assetCategory.getCategoryId();
				String name = assetCategory.getName();

				AssetCategoryGraphForm assetCategoryGraphForm = new AssetCategoryGraphForm();
				assetCategoryGraphForm.setCategoryId(categoryId);
				assetCategoryGraphForm.setName(name);

				assetCategoryGraphForm.setCommunityName(PropsUtil
						.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME));
				
				Neo4jHelper.fillMandatoryFields(assetCategoryGraphForm,
						assetCategory.getCompanyId(),
						assetCategory.getGroupId(), -1L);

				SPNeoforjLocalServiceUtil
						.updateAssetCategoryGraph(assetCategoryGraphForm);
			}

		} catch (Exception e) {
			throw new ModelListenerException(e);
		}
	}

	private static Log _log = LogFactoryUtil
			.getLog(AssetCategoryGraphListener.class);

}