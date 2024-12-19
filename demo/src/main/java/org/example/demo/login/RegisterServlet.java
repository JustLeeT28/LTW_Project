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
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin từ form đăng ký
        String email = request.getParameter("user_email");
        String username = request.getParameter("user_name");
        String password = request.getParameter("user_pass");

        String sql = "INSERT INTO users (email, username, password) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, username);
            stmt.setString(3, password);

            int rowsInserted = stmt.executeUpdate();

            // Phản hồi dựa trên kết quả
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (rowsInserted > 0) {
                out.println("<h3>Registration successful!</h3>");
            } else {
                out.println("<h3>Registration failed!</h3>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred.");
        }
    }
}


