package com.michael.example.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.michael.example.enumeration.http.ResponseStatus;
import com.michael.example.exception.ApiException;

public class EncDecUtil {
	public static String sha256(String str){
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] byteData = str.getBytes("UTF-8");
			byte[] hashBytes = md.digest(byteData);
			StringBuilder hexString = new StringBuilder();
			for (byte hashByte : hashBytes) {
				String hex = Integer.toHexString(0xff & hashByte);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		}catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new ApiException(ResponseStatus.ENCRYPT_FAILURE);
		}

	}
}
