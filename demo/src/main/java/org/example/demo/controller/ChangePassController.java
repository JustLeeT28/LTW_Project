package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.demo.dao.HashUtil;
import org.example.demo.dao.model.User;
import org.example.demo.service.LoginSignupService;
import org.example.demo.service.UserService;

import java.io.IOException;

@WebServlet(name = "Update_User_Controller", urlPatterns = {"/userChangePass"})
public class ChangePassController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        // Lấy dữ liệu từ form
        String old_pass = request.getParameter("old_pass");
        String new_pass1 = request.getParameter("new_pass1");
        String new_pass2 = request.getParameter("new_pass2");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        // mã hóa dữ liệu
        HashUtil hashUtil = new HashUtil();
        String hashOld_pass = hashUtil.hashWithMD5(old_pass);
        if (!hashOld_pass.equals(user.getPassword())){
            request.setAttribute("message","Mật khẩu hiện tại không đúng!");
            request.getRequestDispatcher("/Pages/user-change-pass.jsp").forward(request, response);
        }
        if (!new_pass1.equals(new_pass2)){
            request.setAttribute("message","Mật khẩu mới không trùng nhau cui lòng nhập lại!");
            request.getRequestDispatcher("/Pages/user-change-pass.jsp").forward(request, response);
        }
        LoginSignupService loginSignupService = new LoginSignupService();
        String hashNewPass = hashUtil.hashWithMD5(new_pass1);
        loginSignupService.changePass2(user.getId(),hashNewPass);
        request.setAttribute("message","Đổi mật khẩu thành công!");
        request.getRequestDispatcher("/Pages/user-change-pass.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/Pages/user-change-pass.jsp").forward(request, response);

    }
}