package com.sambaash.platform.util;

import java.util.HashMap;
import java.util.Map;

public class SPAssetActivityKeys {
 
 public static final int ADD_ENTRY = 1;
 public static final int UPDATE_ENTRY = 2;
 public static final int DELETE_ENTRY = 3;
 public static final int DOWNLOAD_ENTRY = 4;
 
 public static Map<Integer, String> ACTIVITY_MESSAGES;
    static
    {
     ACTIVITY_MESSAGES = new HashMap<Integer, String>();
     ACTIVITY_MESSAGES.put(ADD_ENTRY, "added a new SPAssetEntry");
     ACTIVITY_MESSAGES.put(UPDATE_ENTRY, "updated a SPAssetEntry");
     ACTIVITY_MESSAGES.put(DELETE_ENTRY, "deleted a SPAssetEntry");
     ACTIVITY_MESSAGES.put(DOWNLOAD_ENTRY, "downloaded a SPAssetEntry");
    }
}