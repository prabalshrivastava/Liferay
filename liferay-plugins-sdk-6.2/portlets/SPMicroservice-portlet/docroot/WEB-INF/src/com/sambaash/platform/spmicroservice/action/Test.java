package com.sambaash.platform.spmicroservice.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

public class Test {
	private static ThreadLocal<Map<String, String>> SERVICE_ACCESS_TOKEN = new ThreadLocal<>();

	public static void main(String[] args) {
		String clientId = "form-service";
		String clientSecret = "sambaash";

		Map<String, String> tokenMap = SERVICE_ACCESS_TOKEN.get();
		if (tokenMap == null) {
			SERVICE_ACCESS_TOKEN.set(new HashMap<String, String>());
		}

		String currentToken = SERVICE_ACCESS_TOKEN.get().get(clientId);

		if (StringUtils.isEmpty(currentToken)) {

			byte[] encodedBytes = Base64.encodeBase64((clientId + ":" + clientSecret).getBytes());
			String encoded = new String(encodedBytes);
			SERVICE_ACCESS_TOKEN.get().put(clientId, encoded);

		}
		currentToken = SERVICE_ACCESS_TOKEN.get().get(clientId);
	}

}
