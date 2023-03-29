package com.example.javaprogrammingideas.liaoxuefeng;

import android.os.Build;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import androidx.annotation.RequiresApi;

/**
 * ClassName:TestCoding
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-17
 * @author:liujianming
 */
public class TestCoding {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) throws Exception {
//        testURLEncoderEncode();
//        testURLDecoderDecode();
//        testBase64Encoded();
//        testBase64Decoded();
//        testBase64Encoded1();
//        testMD5();
//        testHmacMD5();
//        testECBEncoded();
        testCBCEncoded();
    }

    private static void testURLEncoderEncode() throws UnsupportedEncodingException {
        String encoded = URLEncoder.encode("中文!", String.valueOf(StandardCharsets.UTF_8));
        System.out.println(encoded);
    }

    private static void testURLDecoderDecode() throws UnsupportedEncodingException {
        String decoded = URLDecoder.decode("%E4%B8%AD%E6%96%87%21", String.valueOf(StandardCharsets.UTF_8));
        System.out.println(decoded);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void testBase64Encoded() {
        byte[] input = new byte[] {(byte) 0xe4, (byte) 0xb8, (byte) 0xad};
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void testBase64Decoded() {
        byte[] output = Base64.getDecoder().decode("5Lit");
        System.out.println(Arrays.toString(output));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void testBase64Encoded1() {
        byte[] input = new byte[] {(byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21};
        String b64encoded = Base64.getEncoder().encodeToString(input);
        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input);
        System.out.println(b64encoded);
        System.out.println(b64encoded2);
        byte[] output = Base64.getDecoder().decode(b64encoded2);
        System.out.println(Arrays.toString(output));
    }

    private static void testMD5() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest();
        "ss".charAt(8);
        System.out.println(new BigInteger(1, result).toString(16));
    }

    private static void testHmacMD5() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGenerator.generateKey();
        byte[] skey = key.getEncoded();
        System.out.println(new BigInteger(1, skey).toString(16));
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = mac.doFinal();
        System.out.println(new BigInteger(1, result).toString(16));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void testECBEncoded() throws Exception {
        String message = "Hello, world";
        System.out.println("Message: " + message);
        byte[] key = "1234567890abcdef".getBytes("UTF-8");
        byte[] data = message.getBytes("UTF-8");
        //加密
        byte[] encrypted = encryptAES(key, data);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        //解密
        byte[] decrypted = decryptAES(key, encrypted);
        System.out.println("Decrypted: " + new String(decrypted, "UTF-8"));
    }

    //加密
    public static byte[] encryptAES(byte[] key, byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(input);
    }

    //解密
    public static byte[] decryptAES(byte[] key, byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(input);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void testCBCEncoded() throws Exception {
        String message = "Hello, World";
        System.out.println("Message: " + message);
        byte[] key = "1234567890abcdef".getBytes("UTF-8");
        //加密
        byte[] data = message.getBytes("UTF-8");
        byte[] encrypted = encryptCBC(key, data);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        //解密
        byte[] decrypted = decryptCBC(key, encrypted);
        System.out.println("Decrypted: " + new String(decrypted, "UTF-8"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static byte[] encryptCBC(byte[] key, byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] iv = sr.generateSeed(16);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
        byte[] data = cipher.doFinal(input);
        return join(iv, data);
    }

    public static byte[] decryptCBC(byte[] key, byte[] input) throws Exception {
        //把input分割成IV和密文
        byte[] iv = new byte[16];
        byte[] data = new byte[input.length - 16];
        System.arraycopy(input, 0, iv, 0, 16);
        System.arraycopy(input, 16, data, 0, data.length);
        //解密
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(data);
    }

    public static byte[] join(byte[] bs1, byte[] bs2) {
        byte[] r = new byte[bs1.length + bs2.length];
        System.arraycopy(bs1, 0, r, 0, bs1.length);
        System.arraycopy(bs2, 0, r, bs1.length, bs2.length);
        return r;
    }

}
