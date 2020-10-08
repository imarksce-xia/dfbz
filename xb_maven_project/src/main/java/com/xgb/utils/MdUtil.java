package com.xgb.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author iMarksce
 * @date 2020/9/22
 * @Description
 */
public class MdUtil {
    public static void main(String[] args) {
        System.out.println(MdUtil.md5("admin"));
    }

    //盐值加密
    private static final String SALT = "abc";
    private static final String SALT2 = "abc";

    public static String md5(String password) {
        String result = "";
        try {
            //md5 sha
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update((password + SALT).getBytes());
//            md.update((password).getBytes());
            //加密后的密文（32位）
            result = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String sha(String password) {
        String result = "";
        try {
            //md5 sha
            MessageDigest md = MessageDigest.getInstance("sha");
            md.update((password + SALT2).getBytes());
//            md.update((password).getBytes());
            //加密后的密文（32位）
            result = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
