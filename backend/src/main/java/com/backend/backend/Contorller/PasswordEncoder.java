package com.backend.backend.Contorller;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {
    public static String encode(String password) {
        try {
            // 创建MessageDigest对象，指定使用SHA-256算法
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // 将密码转换为字节数组
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // 返回加密后的密码
            return hexString.toString().substring(0, 50);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
