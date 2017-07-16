package com.sxt.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
	
	public static void main(String[] args) {
		System.out.println(getMd5("123123").length());
	}
	
	public static String getMd5(String passwd) {
		String result = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			//生成md5byte数组
			byte[] bytes = md5.digest(passwd.getBytes());
			//使用stringBuffer进行接收
			StringBuffer buffer = new StringBuffer();
			for(byte b:bytes){
				int by = b & 0xff;
				if(by < 16){
					buffer.append(0);
				}
				buffer.append(Integer.toHexString(by));
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
}
