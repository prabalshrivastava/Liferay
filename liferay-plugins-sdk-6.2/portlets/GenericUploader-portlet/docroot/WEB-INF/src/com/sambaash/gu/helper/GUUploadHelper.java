package com.sambaash.gu.helper;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.NoSuchCategoryException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.sambaash.gu.custom.uploader.GUWBRowHelper;
import com.sambaash.gu.helper.GUModal.GUField;
import com.sambaash.platform.util.SambaashUtil;

public class GUUploadHelper {
	final long groupId ;
	final long companyId ;
	final User logedInUser;
	private static Log _log = LogFactoryUtil.getLog(GUUploadHelper.class);
	
	public GUUploadHelper(long companyId, long groupId,User logedInUser){
		this.companyId = companyId;
		this.groupId = groupId;
		this.logedInUser = logedInUser;
	}

	public AssetCategory getAssetCategory(AssetVocabulary vocabulary,String catgName,boolean create)
			throws SystemException, NoSuchCategoryException {
		catgName = catgName.trim();
		List<AssetCategory> list = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabulary.getVocabularyId(), -1, -1, null);
		AssetCategory catg = null;
		for (AssetCategory assetCategory : list) {
			if(catgName.equalsIgnoreCase(assetCategory.getName())){
				catg = assetCategory;
				break; 
			}
		}
		if(catg == null && create){
			try{
				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setScopeGroupId(groupId);
				catg = AssetCategoryLocalServiceUtil.addCategory(SambaashUtil.getAdminUserId(), catgName, vocabulary.getVocabularyId(),serviceContext );
			}catch(Exception ex){
				_log.error(ex);
			}
		}
		
		if(catg == null){
			throw new NoSuchCategoryException(catgName);
		}
		return catg;
	}
	
	public  AssetVocabulary getAssetVocabulary(String vocName){
		DynamicQuery dq = AssetVocabularyLocalServiceUtil.dynamicQuery();
		dq.add(RestrictionsFactoryUtil.eq("name", vocName));
		dq.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		try {
			List<AssetVocabulary> list = AssetVocabularyLocalServiceUtil.dynamicQuery(dq);
			if(list.size() > 0){
				return list.get(0);
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		
		return null;
	}
	
	public Set<Long> getAssetCategoreis(Row row, GUField field, GUWBRowHelper rowHelper) throws SystemException, NoSuchCategoryException{
		Set<Long> catgIds = new LinkedHashSet<Long>();
		AssetVocabulary vocb = field.getAssetVocabulary();
		if(vocb == null){
			return catgIds;
		}

		String cellValue = rowHelper.getCellValue(row, field);
		String catgNames[] = cellValue.split(GUConstants.CELL_VALUE_SEPARATOR_ESCAPED);
		for (String catgName : catgNames) {
			if(Validator.isNull(catgName)){
				continue;
			}
			AssetCategory catg = getAssetCategory(vocb, catgName, field.isCreateCatg());
			catgIds.add(catg.getCategoryId());
		}
	
		return catgIds;
	}

	public static boolean isFile_Folder_type(String docType) {
		return GUConstants.DOCUMENT_TYPE_FILE.equalsIgnoreCase(docType) || GUConstants.DOCUMENT_TYPE_Folder.equalsIgnoreCase(docType);
	}
	
	public static String getSubModalName(String modalName){
		final String subModalName = modalName.substring( modalName.indexOf(GUConstants.MODAL_NAME_SEPARATOR) + 1);
		return subModalName;
	}
}
