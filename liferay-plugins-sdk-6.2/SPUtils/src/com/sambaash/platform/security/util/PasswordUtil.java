package com.sambaash.platform.security.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.User;
import java.util.Map;
import java.util.HashMap;

public class PasswordUtil {
	private static final String METHOD_KEY_PATTERN = "%s_%s";
	private static final String AUTHENTICATE_METHOD = "authenticate";
	private static final String ENCRYPT_METHOD = "encrypt";
	
	private static Log _log = LogFactoryUtil.getLog(PasswordUtil.class);
	private static final String PASSWORD_ENCRYPTOR_UTIL = "com.liferay.portal.security.pwd.PasswordEncryptorUtil";
	private static final String PWD_AUTHENTICATOR = "com.liferay.portal.security.pwd.PwdAuthenticator";
	
	private static final Map<String, MethodKey> methodMap;
	
	static {
		methodMap = new HashMap<>();
		try {
			ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();
			// init PwdAuthenticator methods
			Class<?> pwdAuthenticatorClass = portalClassLoader.loadClass(PWD_AUTHENTICATOR);
			MethodKey authenticate_method = new MethodKey(pwdAuthenticatorClass,
					AUTHENTICATE_METHOD, String.class, String.class, String.class);
			methodMap.put(String.format(METHOD_KEY_PATTERN,PWD_AUTHENTICATOR,AUTHENTICATE_METHOD), authenticate_method);
						
			// init PasswordEncryptorUtil methods
			Class<?> passwordEncryptorUtilClass = portalClassLoader.loadClass(PASSWORD_ENCRYPTOR_UTIL);
			MethodKey encryptMethodKey = new MethodKey(passwordEncryptorUtilClass,
					ENCRYPT_METHOD, String.class, String.class);
			methodMap.put(String.format(METHOD_KEY_PATTERN,PASSWORD_ENCRYPTOR_UTIL,ENCRYPT_METHOD), encryptMethodKey);
			
		} catch (Exception e) {
			_log.error("Failed to initialize portal class methods!", e);
		}
	}
			
	private PasswordUtil() {
		// only static methods here
	}
	
	private static String methodKey(String className, String methodName) {
		return String.format(METHOD_KEY_PATTERN, className, methodName);
	}
	
	private static MethodKey getMethod(String className, String methodName) {
		return methodMap.get(methodKey(className, methodName));
	}
	
	public static String encryptPassword(String plainPassword, String encryptedPassword) {
		try {
			MethodKey encryptMethodKey = getMethod(PASSWORD_ENCRYPTOR_UTIL, ENCRYPT_METHOD);
			return (String) PortalClassInvoker.invoke(false, encryptMethodKey, plainPassword, encryptedPassword);			
		} catch (Exception e) {
			_log.error("Unable to encrypt password. Returning plain password.", e);
			return plainPassword;
		}
	}
	
	public static boolean authenticatePassword(String login, String plainPassword, String encryptedPassword) {
		boolean authenticated = false;
		try {
			MethodKey authenticate_method = getMethod(PWD_AUTHENTICATOR, AUTHENTICATE_METHOD);
			authenticated =  (boolean) PortalClassInvoker.invoke(false, authenticate_method, login, plainPassword, encryptedPassword);			
		} catch (Exception e) {
			_log.error("Unable to authenticate the password.", e);
		}
		return authenticated;
	}
}
