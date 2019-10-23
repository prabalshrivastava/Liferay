package com.sambaash.platform.srv.spasset.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.service.SPAssetEntryLocalServiceUtil;

public class SPAssetEntryPermission {
    public static void check(PermissionChecker permissionChecker,
            long spAssetEntryId, String actionId) throws PortalException,
            SystemException {

        if (!contains(permissionChecker, spAssetEntryId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker,
            long spAssetEntryId, String actionId) throws PortalException,
            SystemException {

        SPAssetEntry spAssetEntry = SPAssetEntryLocalServiceUtil.getSPAssetEntry(spAssetEntryId);

        return permissionChecker
                .hasPermission(spAssetEntry.getGroupId(),
                        SPAssetEntry.class.getName(),spAssetEntry.getSpAssetEntryId(),
                        actionId);

    }
}

