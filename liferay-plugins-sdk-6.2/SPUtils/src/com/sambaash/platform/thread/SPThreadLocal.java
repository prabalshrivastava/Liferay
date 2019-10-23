package com.sambaash.platform.thread;

import java.util.HashMap;
import java.util.Map;

/*
 * This ThreadLocal is used only during login to share
 * data from LoginAction to SPAuthenticator.
 */
public class SPThreadLocal {

	public static enum Key {
		// HttpSession for use during LoginAction only
		LOGIN_SESSION("loginHttpSession"),
		SPSITE_AUTH_ACCESS("spSiteAuthAccess"),
		SP_LOGIN_LAYOUTSET_ID("spLayoutSetId"),
		SP_VIRTUALHOST_ID("spVirtualhostId"),
		SP_SUB_PRODUCT_IDS("spSubProductIds")
		;	
		
		private String attribute;
		private Key(String attribute) {
            this.attribute = attribute;
        }
		
		public String getAttribute() {
			return attribute;
		}
		
		public Key getKey(String attribute) {
			Key key = null;
            for (Key k: Key.values()) {
                if (k.getAttribute().equals(attribute)) {
                    key = k;
                    break;
                }
            }
            return key;
        }
	}

	private SPThreadLocal() {
		// do not instantiate
	}
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static final ThreadLocal<Map<Key,Object>> threadLocalMap = new ThreadLocal(){
        @Override
        protected Map<Key,Object> initialValue() {
            return new HashMap<>();
        }
    };

	public static void setValue(Key key, Object val) {
		threadLocalMap.get().put(key, val);
	}
	
	public static Object getValue(Key key) {
		return getValue(key, false);
	}
	
	// use free to remove temporary map data, just like HTTPSession which is used only 
	// in LoginAction to pass data to the SPAuthenticator
	public static Object getValue(Key key, boolean free) {
		Object o = threadLocalMap.get().get(key);
		if (free) {
			threadLocalMap.get().remove(key);
		}
		return o;
	}
	
	public static void destroy() {
		threadLocalMap.get().clear();
		threadLocalMap.remove();
	}
}
