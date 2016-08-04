package com.tiza.mbp.utils.encrypt;

import java.security.MessageDigest;

/**
 * CreateDate:2016/7/28
 *
 * @version 1.0.
 * @auther XieChen
 */
public class MD5Util {
    public static String md5Encode(String input) throws Exception {
        MessageDigest  md5 = MessageDigest.getInstance("MD5");
        byte[] byteArray = input.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
