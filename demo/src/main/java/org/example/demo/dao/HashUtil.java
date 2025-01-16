package org.example.demo.dao;
import org.example.demo.dao.model.User;
import org.example.demo.service.LoginSignupService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class HashUtil {
    public static String hashWithMD5(String input) {
        try {
            // Tạo instance của MessageDigest sử dụng thuật toán MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Mã hóa chuỗi đầu vào thành dạng byte
            byte[] hashedBytes = md.digest(input.getBytes());
            // Chuyển đổi byte sang dạng hex
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString(); // Trả về chuỗi đã mã hóa
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Lỗi khi mã hóa MD5: " + e.getMessage());
        }
    }

//    public static void main(String[] args) {
//        // Ví dụ sử dụng
//        String originalPassword = "Dung12345";
//        String hashedPassword = hashWithMD5(originalPassword);
//        System.out.println("Password gốc: " + originalPassword);
//        System.out.println("Password mã hóa (MD5): " + hashedPassword);
//    }

    public static void main(String[] args) {
        // Kiểm tra hàm mã hóa MD5
        String password = "userB123";
        String p = hashWithMD5(password);
        System.out.println("Mật khẩu mã hóa MD5 là: " + p);

//        // Kiểm tra đăng nhập
//        String userEmail = "phamthidung@gmail.com";
//        LoginSignupService loginSignupService = new LoginSignupService();
//        User u =  loginSignupService.getUser(userEmail, p);
//        if(u != null) {
//            System.out.println(u);
//        }
//        System.out.println("không có người dùng này");

    }
}

