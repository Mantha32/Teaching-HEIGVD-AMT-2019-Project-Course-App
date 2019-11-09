/**
 * 
 */
package com.amt.schedule.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author
 * 
 */
public class DataFactory {
	public static String crypt(String s) {

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(s.getBytes());

		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();
	}
}
