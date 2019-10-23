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

package com.sambaash.platform.service.impl;

import java.util.List;
import java.util.Locale;

import com.liferay.compat.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.sambaash.platform.service.FetchLocalServiceUtil;
import com.sambaash.platform.service.base.FetchServiceBaseImpl;
import com.sambaash.platform.srv.genericsearch.model.GSFavourite;
import com.sambaash.platform.srv.genericsearch.service.GSFavouriteLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the fetch remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.service.FetchService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author biswo
 * @see com.sambaash.platform.service.base.FetchServiceBaseImpl
 * @see com.sambaash.platform.service.FetchServiceUtil
 */
public class FetchServiceImpl extends FetchServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.service.FetchServiceUtil} to access the fetch
	 * remote service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(FetchServiceImpl.class);

	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getAllRolesOne() throws SystemException {

		JSONArray categoryArray = JSONFactoryUtil.createJSONArray();
		List<Role> roles = RoleLocalServiceUtil.getRoles(-1, -1);

		for (Role role : roles) {
			JSONObject js = JSONFactoryUtil.createJSONObject();
			js.put("id", role.getRoleId());
			js.put("name", role.getName());
			categoryArray.put(js);
		}
		return categoryArray;
	}

	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getLayoutsOne() throws SystemException {
		Locale locale = LocaleUtil.getDefault();
		String requestedLanguageId = LocaleUtil.toLanguageId(locale);
		JSONArray categoryArray = JSONFactoryUtil.createJSONArray();
		List<Layout> llayouts = LayoutLocalServiceUtil.getLayouts(-1, -1);
		for (Layout llayout : llayouts) {
			JSONObject js = JSONFactoryUtil.createJSONObject();
			js.put("id", llayout.getLayoutId());
			js.put("name", LocalizationUtil.getLocalization(llayout.getName(), requestedLanguageId));
			categoryArray.put(js);
		}
		return categoryArray;
	}

	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getParentLayouts() throws SystemException {
		Locale locale = LocaleUtil.getDefault();
		String requestedLanguageId = LocaleUtil.toLanguageId(locale);
		JSONArray categoryArray = JSONFactoryUtil.createJSONArray();
		List<Layout> llayouts = LayoutLocalServiceUtil.getLayouts(-1, -1);
		for (Layout llayout : llayouts) {
			if (llayout.getParentLayoutId() == 0) {
				JSONObject js = JSONFactoryUtil.createJSONObject();
				js.put("id", llayout.getLayoutId());
				js.put("name", LocalizationUtil.getLocalization(llayout.getName(), requestedLanguageId));
				categoryArray.put(js);
			}

		}
		return categoryArray;
	}

	@AccessControlled(guestAccessEnabled = true)
	public JSONArray getConfiguredParentLayouts() throws SystemException {

		String navigation = FetchLocalServiceUtil.fetchRecord("1", "Navigation",20199,21424);
		JSONObject navigationObject = JSONFactoryUtil.createJSONObject();
		JSONArray newcategoryArray = JSONFactoryUtil.createJSONArray();
		try {
			navigationObject = JSONFactoryUtil.createJSONObject(navigation);
		} catch (JSONException e) {
			_log.error(e.getMessage());
		}
		JSONObject contentJson = navigationObject.getJSONObject("contentJson");
		JSONArray datagrid = contentJson.getJSONArray("DataGrid");
		Locale locale = LocaleUtil.getDefault();
		String requestedLanguageId = LocaleUtil.toLanguageId(locale);

		for (int i = 0; i < datagrid.length(); i++) {
			if (datagrid.getJSONObject(i).getString("Layout") != "") {
				JSONObject js = JSONFactoryUtil.createJSONObject();

				js.put("id", datagrid.getJSONObject(i).getJSONObject("Layout").getString("id"));
				js.put("name", LocalizationUtil.getLocalization(
						datagrid.getJSONObject(i).getJSONObject("Layout").getString("name"), requestedLanguageId));
				js.put("Roles", datagrid.getJSONObject(i).getString("Role"));
				newcategoryArray.put(js);
			}

		}
		return newcategoryArray;
	}

	public JSONArray getChildLayouts() throws SystemException {
		Locale locale = LocaleUtil.getDefault();
		String requestedLanguageId = LocaleUtil.toLanguageId(locale);
		JSONArray categoryArray = JSONFactoryUtil.createJSONArray();
		List<Layout> llayouts = LayoutLocalServiceUtil.getLayouts(-1, -1);
		for (Layout llayout : llayouts) {
			if (llayout.getParentLayoutId() != 0) {
				JSONObject js = JSONFactoryUtil.createJSONObject();
				js.put("id", llayout.getLayoutId());
				js.put("name", LocalizationUtil.getLocalization(llayout.getName(), requestedLanguageId));
				categoryArray.put(js);
			}
		}
		return categoryArray;
	}

	public JSONArray getNavigationParentLayouts() throws SystemException {

		String response = FetchLocalServiceUtil.fetchRecord("1", "Navigation",20199,21424);
		JSONArray categoryArray = JSONFactoryUtil.createJSONArray();
		Locale locale = LocaleUtil.getDefault();
		String requestedLanguageId = LocaleUtil.toLanguageId(locale);
		List<Layout> llayouts = LayoutLocalServiceUtil.getLayouts(-1, -1);
		for (Layout llayout : llayouts) {
			if (llayout.getParentLayoutId() != 0) {
				JSONObject js = JSONFactoryUtil.createJSONObject();
				js.put("id", llayout.getLayoutId());

				js.put("name", LocalizationUtil.getLocalization(llayout.getName(), requestedLanguageId));
				categoryArray.put(js);
			}
		}
		return categoryArray;
	}

	public JSONArray getFavourites() throws SystemException {

		JSONArray categoryArray = JSONFactoryUtil.createJSONArray();
		List<GSFavourite> favourites = GSFavouriteLocalServiceUtil.getGSFavourites(-1, -1);
		for (GSFavourite favourite : favourites) {
			if (favourite.getSPGSFavouriteId() != 0) {
				JSONObject js = JSONFactoryUtil.createJSONObject();
				js.put("id", favourite.getSPGSFavouriteId());
				js.put("name", favourite.getName());
				categoryArray.put(js);
			}
		}
		return categoryArray;
	}
}