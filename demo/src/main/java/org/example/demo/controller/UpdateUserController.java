package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.demo.dao.model.User;
import org.example.demo.service.UserService;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "Update_User_Controller", urlPatterns = {"/UpdateUserController"})
public class UpdateUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String numPhone = request.getParameter("numPhone");

        HttpSession session = request.getSession();
        String user_id = String.valueOf(((User) session.getAttribute("user")).getId());

        int count = 0;
        UserService userService = new UserService();
        if (name != null && !name.isEmpty()) {
            userService.updateName(user_id, name);
            count++;
        }
        if (birthday != null && !birthday.isEmpty()) {
            userService.updateDob(user_id, birthday);
            count++;
        }
        if (email != null && !email.isEmpty()) {
            userService.updateEmail(user_id, email);
            count++;
        }
        if (numPhone != null && !numPhone.isEmpty()) {
            userService.updatePhone(user_id, numPhone);
            count++;
        }
        if (count > 0) {
//            request.setAttribute("Message", "Cập nhập thông tin thành công !");
//            request.getRequestDispatcher("/Pages/user-updateinfor.jsp").forward(request, response);
            User u = userService.getUserById(user_id);
            session.setAttribute("user", u);
            response.sendRedirect("/demo_war_exploded/Pages/user-infor.jsp");
            return;
        }
//        request.setAttribute("Message", "Cập nhật không thành công!");
        request.getRequestDispatcher("/Pages/user-updateinfor.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Pages/user-updateinfor.jsp").forward(request, response);

    }
}