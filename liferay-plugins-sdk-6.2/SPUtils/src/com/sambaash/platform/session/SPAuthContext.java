package com.sambaash.platform.session;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

public class SPAuthContext {
	
	public static enum Key {
		SPSITE_AUTH_ACCESS,
		SP_LOGIN_TYPE,
		SP_LOGIN_LAYOUTSET_ID,
		SP_VIRTUALHOST_ID,
		SPSITE_PRODUCT_IDS,
		SPSITE_ACTIVE_PRODUCT_ID,
		IS_BACK_OFFICE,
		SPSITE_AUTH_ACTIVE
	}
	
	private static final Map<String, Object> contextData = new HashMap<>();
			
	private SPAuthContext() {
		// static only
	}
	
	public static void setValue(HttpSession session, Key contextKey, Object value) {
		contextData.put(generateSessionKey(session, contextKey), value);
	}
	
	public static Object getValue(HttpSession session, Key contextKey) {
		return contextData.get(generateSessionKey(session, contextKey));
	}
	
	public static Object getValue(String key) {
		return contextData.get(key);
	}
	
	public static Set<String> getContextKeys(HttpSession session) {
		String sessionId = session.getId();
		Set<String> keySet = new HashSet<>();
		for(String k : contextData.keySet()) {
			if (k.startsWith(sessionId)) {
				keySet.add(k);
			}
		}
		return keySet;
	}
	
	/*
	 * Call this on logout, to remove session context.
	 */
	public static void remove(HttpSession session) {
		for(String key: getContextKeys(session)) {
			contextData.remove(key);
		}
	}
	
	/*
	 * Liferay by default creates a new Session after login to avoid phishing.
	 * We use this to transfer data collected by SPAuthenticator to the new session after successful login.
	 * Then we can use SPAuthContext through out the session.
	 */
	public static void transferContext(HttpSession origSession, HttpSession newSession) {
		transferContext(origSession.getId(), newSession.getId());
	}
		
	public static void transferContext(String origId, String newId) {
		Map<String, Object> newMap = new HashMap<>();
		Iterator<Entry<String, Object>> oldIter = contextData.entrySet().iterator();
		while(oldIter.hasNext()) {
			Entry<String, Object> entry = oldIter.next();
			String key = entry.getKey();
			if (key.startsWith(origId)) {
				Object value = entry.getValue();
				newMap.put(key.replace(origId, newId), value);
				oldIter.remove();
			}
		}
		if (!newMap.isEmpty()) {
			contextData.putAll(newMap);
		}
	}
	
	private static String generateSessionKey(HttpSession session, Key contextKey) {
		return String.format("%s_%s", session.getId(), contextKey.name());
	}
	
}
