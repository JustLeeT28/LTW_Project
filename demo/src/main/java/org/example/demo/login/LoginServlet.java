package org.example.demo.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin từ form đăng nhập
        String usernameOrEmail = request.getParameter("user_login");
        String password = request.getParameter("user_pass_login");

        String sql = "SELECT * FROM users WHERE (username = ? OR email = ?) AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usernameOrEmail);
            stmt.setString(2, usernameOrEmail);
            stmt.setString(3, password);

            ResultSet rs = stmt.executeQuery();

            // Phản hồi dựa trên kết quả
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
}


