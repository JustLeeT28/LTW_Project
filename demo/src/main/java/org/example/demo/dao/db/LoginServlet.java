package org.example.demo.dao.db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usernameOrEmail = request.getParameter("user_login");
        String password = request.getParameter("user_pass_login");

        // Mã hóa mật khẩu bằng MD5
        String hashedPassword = hashMD5(password);

        String sql = "SELECT * FROM users WHERE (username = ? OR email = ?) AND password = ?";

        try (Statement statement = DbConnect.get();
             PreparedStatement preparedStatement = statement.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, usernameOrEmail);
            preparedStatement.setString(2, usernameOrEmail);
            preparedStatement.setString(3, hashedPassword);

            ResultSet rs = preparedStatement.executeQuery();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (rs.next()) {
                out.println("<h3>Login successful! Welcome, " + rs.getString("username") + ".</h3>");
            } else {
                out.println("<h3>Invalid credentials. Please try again.</h3>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred.");
        }
    }

    // Hàm mã hóa MD5
    private String hashMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}