package org.example.demo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demo.dao.model.FoodCombo;
import org.example.demo.dao.model.FoodTicketItem;
import org.example.demo.dao.model.User;
import org.example.demo.service.FoodService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CheckOutController", urlPatterns = "/checkout")
public class CheckOutController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        if (session == null || user == null) {
            response.sendRedirect("Pages/login.jsp");
            return;
        }
        FoodService foodService = new FoodService();
        String movieId = request.getParameter("mId"); // ID phim
        // Tạo một Map để lưu trữ comboId và quantity
        Map<String, Integer> comboMap = new HashMap<>();

        // Lấy danh sách comboId và quantity từ query string
        String[] comboIdArray = request.getParameterValues("comboId");
        String[] quantityArray = request.getParameterValues("quantity");

        // Đảm bảo rằng comboId và quantity có số lượng phần tử như nhau
        if (comboIdArray != null && quantityArray != null && comboIdArray.length == quantityArray.length) {
            for (int i = 0; i < comboIdArray.length; i++) {
                // Lưu comboId và quantity vào Map
                comboMap.put(comboIdArray[i], Integer.parseInt(quantityArray[i]));
            }
        }
            List<FoodTicketItem> foodTicketItems = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : comboMap.entrySet()) {
            FoodTicketItem foodTicketItem = new FoodTicketItem();
            foodTicketItem.setComboId(Integer.parseInt(entry.getKey()));
            foodTicketItem.setQuantity(entry.getValue());

            // Lấy FoodCombo từ dịch vụ
            List<FoodCombo> foodCombos = foodService.getFoodComboById(Integer.parseInt(entry.getKey()));

            // Kiểm tra danh sách có phần tử không
            if (foodCombos != null && !foodCombos.isEmpty()) {
                FoodCombo foodCombo = foodCombos.get(0); // Lấy phần tử đầu tiên
                foodTicketItem.setTotalPrice(foodCombo.getPrice() * entry.getValue());
                foodTicketItem.setUserId(user.getId());
                foodTicketItems.add(foodTicketItem);
            } else {
                // Xử lý trường hợp không tìm thấy FoodCombo
                System.out.println("Không tìm thấy FoodCombo với comboId: " + entry.getKey());
                // Hoặc có thể bỏ qua combo này, hoặc tạo một lỗi tùy ý
            }
        }


        session.setAttribute("foodTicketItems", foodTicketItems);


        // Tiếp tục xử lý dữ liệu (ví dụ: tính tổng tiền, hiển thị thông tin,...)
        request.setAttribute("movieId", movieId);
        request.setAttribute("comboMap", comboMap);
        request.setAttribute("foodTicketItems", foodTicketItems);
        request.setAttribute("user", user);

        // Forward tới trang checkout.jsp (hoặc nơi bạn muốn hiển thị thông tin)
        request.getRequestDispatcher("Pages/Payment.jsp").forward(request, response);
    }
}
