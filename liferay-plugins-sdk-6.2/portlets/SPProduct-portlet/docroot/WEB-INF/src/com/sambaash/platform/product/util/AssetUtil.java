package com.sambaash.platform.product.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

public class AssetUtil {

	public static void updateAsset(long userId, long groupId, String className, long primaryKeyId,
			String[] assetCategoryIds, String[] assetTagNames) throws PortalException, SystemException {

		long[] assetCatIds = new long[assetCategoryIds.length];

		for (int i = 0; i < assetCategoryIds.length; i++) {
			assetCatIds[i] = Long.parseLong(assetCategoryIds[i]);
		}

		AssetEntryLocalServiceUtil.updateEntry(userId, groupId, className, primaryKeyId, assetCatIds, assetTagNames);
		
	}

}
