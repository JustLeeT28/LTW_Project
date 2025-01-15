package org.example.demo.service;

import org.example.demo.dao.OrderDao;

public class DashboardService {
    OrderDao orderDao = new OrderDao();
    public double getTotalR7() {
        return orderDao.getTotalR7();
    }
}
