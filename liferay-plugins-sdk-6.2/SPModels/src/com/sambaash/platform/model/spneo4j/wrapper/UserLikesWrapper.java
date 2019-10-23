package com.sambaash.platform.model.spneo4j.wrapper;

import java.util.ArrayList;
import java.util.List;

public class UserLikesWrapper {
	
	List<AssetEntityGraphWrapper> assetEntityGraphWrappersUserLikes = new ArrayList<AssetEntityGraphWrapper>();
	
	int assetEntitiesUserLiksCount;

	public List<AssetEntityGraphWrapper> getAssetEntityGraphWrappersUserLikes() {
		return assetEntityGraphWrappersUserLikes;
	}

	public void setAssetEntityGraphWrappersUserLikes(
			List<AssetEntityGraphWrapper> assetEntityGraphWrappersUserLikes) {
		this.assetEntityGraphWrappersUserLikes = assetEntityGraphWrappersUserLikes;
	}

	public int getAssetEntitiesUserLiksCount() {
		return assetEntitiesUserLiksCount;
	}

	public void setAssetEntitiesUserLiksCount(int assetEntitiesUserLiksCount) {
		this.assetEntitiesUserLiksCount = assetEntitiesUserLiksCount;
	}

}
