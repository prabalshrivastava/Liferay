package com.sambaash.platform.portlet.spmail.util;

import java.io.UnsupportedEncodingException;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;
public class DesEncrypter {

	private static DesEncrypter instance = null;

	Cipher ecipher;
	Cipher dcipher;

	protected DesEncrypter() {

	}

	public static DesEncrypter getInstance() {
		if (instance == null) {
			instance = new DesEncrypter("UrlEncryption");
		}
		return instance;
	}

	byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3,
			(byte) 0x03 };

	int iterationCount = 3;

	public DesEncrypter(String passPhrase) {

		try {

			KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
			SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

			ecipher = Cipher.getInstance(key.getAlgorithm());
			dcipher = Cipher.getInstance(key.getAlgorithm());

			AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

		} catch (java.security.InvalidAlgorithmParameterException e) {
		} catch (java.security.spec.InvalidKeySpecException e) {
		} catch (javax.crypto.NoSuchPaddingException e) {
		} catch (java.security.NoSuchAlgorithmException e) {
		} catch (java.security.InvalidKeyException e) {
		}
	}

	public String encrypt(String str) {

		try {

			byte[] utf8 = str.getBytes("UTF8");
			byte[] enc = ecipher.doFinal(utf8);

			return Base64.encodeBase64URLSafeString(enc);

		} catch (javax.crypto.BadPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		} catch (UnsupportedEncodingException e) {
		}

		return null;
	}

	public String decrypt(String str) {

		try {

			byte[] dec = dcipher.doFinal(Base64.decodeBase64(str));

			return new String(dec);

		} catch (javax.crypto.BadPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		}

		return null;
	}

	public static void main(String[] args) {

		String orgStr = "http://www.test.com";

		String str = DesEncrypter.getInstance().encrypt(orgStr);
		str = DesEncrypter.getInstance().decrypt(str);

	}

}
